package acceptancetests.memberredesign.needHelp;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.claims.ClaimsCommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.needHelp.NeedHelpPage;
import pages.regression.ordermaterials.OrderMaterialsPage;
import pages.regression.pharmacylocator.PharmacySearchPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import pages.regression.testharness.TestHarness;

/**
 Functionality : Helper steps for validating the Need Help section on the member site.
 */
public class NeedHelpStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public static Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}
	
	/**
	 * User should be on either dashboard or testharness at this step.
	 * Save the URL and driver for later user
	 * @param memberAttributes This takes the input of 'Plan Type' and 'Member Type' from input
	 */
	@When("^I am on dashboard or testharness page$")
	public void land_on_dashboard_or_testharness_page(DataTable memberAttributes) { 
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType=memberAttributesMap.get("Plan Type");
		String memberType=memberAttributesMap.get("Member Type");
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE, planType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE, memberType);

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			getLoginScenario().saveBean(NeedHelpCommonConstants.TEST_INITIAL_PAGE_URL, 
					testHarness.driver.getCurrentUrl());
			getLoginScenario().saveBean(NeedHelpCommonConstants.TEST_DRIVER, 
					testHarness.driver);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			getLoginScenario().saveBean(NeedHelpCommonConstants.TEST_INITIAL_PAGE_URL, 
					accountHomePage.driver.getCurrentUrl());
			getLoginScenario().saveBean(NeedHelpCommonConstants.TEST_DRIVER, 
					accountHomePage.driver);
		}
	}

	/**
	 * This step performs navigation from either dashboard or testharness to the Claims Summary page.
	 * If user is on dashboard page, it will navigate via the top menu 'Claims' link.
	 * If user is on testharness, it will navigate through the link for the claims summary page in the table.
	 */
	@When("^I navigate to the Claims Summary page$")
	public void navigate_Claims_Summary_page() { 
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		// note: if current URL is not on testharness or dashboard, reset it to prep for the test
		String backToUrl=(String) getLoginScenario()
				.getBean(NeedHelpCommonConstants.TEST_INITIAL_PAGE_URL);
		WebDriver wd=(WebDriver) getLoginScenario()
				.getBean(NeedHelpCommonConstants.TEST_DRIVER);
		String currentURL=wd.getCurrentUrl();
		if (!currentURL.equals(backToUrl)) {
			wd.get(backToUrl);
			CommonUtility.checkPageIsReady(wd);
		}
		ClaimsSummaryPage claimsSummPg;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			claimsSummPg = testHarness.navigateToClaimsSummaryFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			claimsSummPg = accountHomePage.navigateToClaimsSummaryPage();
		}
		CommonUtility.checkPageIsReady(claimsSummPg.driver);
		Assert.assertTrue("PROBLEM - unable to navigate to Claims Summary page", 
				claimsSummPg != null);
		getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, 
				claimsSummPg);
		NeedHelpPage needHelpPage=new NeedHelpPage(claimsSummPg.driver);
		if (memberType.toUpperCase().contains("COMBO")) {
			needHelpPage.goToSpecificComboTab(planType);
		}
	}
	
	/** 
	 * This step performs validation on the Need Help section of the Claims Summary Page
	 */
	@Then("^I validate Need Help section on Claims page$")
	public void validate_claims_needHelp() {
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - unable to reach Claims page", (claimsSummPg != null));
		NeedHelpPage needHelpPage=new NeedHelpPage(claimsSummPg.driver);
		needHelpPage.validateSectionInNeedHelp(planType, memberType);
	}
	
	/**
	 * This step performs navigation from either dashboard or testharness to the Order Plan Materials page.
	 * If user is on dashboard page, it will navigate through the Order Material link on the page body.
	 * If user is on testharness, it will navigate through the link for the Order Plan Materials page in the table.
	 */
	@When("^I navigate to the Order Plan Materials page$")
	public void navigateToOrderPlanMaterialsPage() throws InterruptedException {
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		// note: if current URL is not on testharness or dashboard, reset it to prep for the test
		String backToUrl=(String) getLoginScenario()
				.getBean(NeedHelpCommonConstants.TEST_INITIAL_PAGE_URL);
		WebDriver wd=(WebDriver) getLoginScenario()
				.getBean(NeedHelpCommonConstants.TEST_DRIVER);
		String currentURL=wd.getCurrentUrl();
		if (!currentURL.equals(backToUrl)) {
			wd.get(backToUrl);
			CommonUtility.checkPageIsReady(wd);
		}
		
		OrderMaterialsPage orderPlanMaterialsPg;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			orderPlanMaterialsPg = testHarness.navigateToOrderPlanMaterialsPageFromTestHarnessPage();
		} else {
			//note: will use the Order Material link on the page body
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			orderPlanMaterialsPg = accountHomePage.navigateToOrderPlanMaterialsPage();
		}
		CommonUtility.checkPageIsReady(orderPlanMaterialsPg.driver);
		Assert.assertTrue("PROBLEM - unable to navigate to Order Plan Materials page",
				orderPlanMaterialsPg != null);
		getLoginScenario().saveBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE,orderPlanMaterialsPg);
		NeedHelpPage needHelpPage=new NeedHelpPage(orderPlanMaterialsPg.driver);
		if (memberType.toUpperCase().contains("COMBO"))
			needHelpPage.goToSpecificComboTab(planType);
	}
	
	/** 
	 * This step performs validation on the Need Help section of the Order Plan Material Page
	 */
	@Then("^I validate Need Help section on Order Plan Materials page$")
	public void validate_orderPlan_needHelp() {
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		OrderMaterialsPage orderMaterialPg = (OrderMaterialsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		Assert.assertTrue("PROBLEM - unable to reach Order Plan Materials page", (orderMaterialPg != null));
		NeedHelpPage needHelpPage=new NeedHelpPage(orderMaterialPg.driver);
		needHelpPage.validateSectionInNeedHelp(planType, memberType);
	}

	/**
	 * This step performs navigation from either dashboard or testharness to the Pharmacy locator page.
	 * If user is on dashboard page, it will navigate through the Pharmacy locator link on the page body.
	 * If user is on testharness, it will navigate through the link for the Pharmacy locator page in the table.
	 * @throws InterruptedException
	 */
	@When("^I navigate to pharmacy search page$")
	public void navigateToPharmacyLocatorPage() throws InterruptedException {
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		if (memberType.toUpperCase().contains("INDIVIDUAL") && planType.toUpperCase().equals("SHIP")
				|| planType.toUpperCase().equals("MA")) {
			System.out.println("Pharamcy locator doesn't show up for SHIP user, skip this test");
			return;
		}
		
		// note: if current URL is not on testharness or dashboard, reset it to prep for the test
		String backToUrl=(String) getLoginScenario()
				.getBean(NeedHelpCommonConstants.TEST_INITIAL_PAGE_URL);
		WebDriver wd=(WebDriver) getLoginScenario()
				.getBean(NeedHelpCommonConstants.TEST_DRIVER);
		String currentURL=wd.getCurrentUrl();
		if (!currentURL.equals(backToUrl)) {
			wd.get(backToUrl);
			CommonUtility.checkPageIsReady(wd);
		}
		PharmacySearchPage pharmacySearchPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			pharmacySearchPage = testHarness.navigateToPharmacyLocatorFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			pharmacySearchPage = accountHomePage.navigateToRedesignPharmacyLocaterPage();
		}
		Assert.assertTrue("PROBLEM - unable to navigate to Pharmacy locator page",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_SEARCH_PAGE,pharmacySearchPage);
	}
	
	/** 
	 * This step performs validation on the Need Help section of the Pharmacy locator Page
	 */
	@Then("^I validate Need Help section on Pharmacy Locator page$")
	public void validate_pharmacyLocator_needHelp() {
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		if (memberType.toUpperCase().contains("COMBO") && planType.toUpperCase().equals("SHIP")) {
			System.out.println("This is COMBO plan, pharamcy locator need help section should behave like NON-SHIP");
			planType="NONSHIP";
		} else if ((memberType.toUpperCase().contains("INDIVIDUAL") && planType.toUpperCase().equals("SHIP")) 
			|| planType.toUpperCase().equals("MA")) {
			System.out.println("Pharamcy locator doesn't show up for SHIP Individual or MA user, skip this test");
			return;
		} 
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstantsMnR.PHARMACY_SEARCH_PAGE);
		Assert.assertTrue("PROBLEM - unable to reach Order Plan Materials page", (pharmacySearchPage != null));
		NeedHelpPage needHelpPage=new NeedHelpPage(pharmacySearchPage.driver);
		needHelpPage.validateSectionInNeedHelp(planType, memberType);
	}

	/**
	 * This step performs navigation from either dashboard or testharness to the Preference page.
	 * If user is on dashboard page, it will navigate through the Account/Profile dropdown 
	 * If user is on testharness, it will navigate through the link for preference page in the table.
	 */
	@When("^I navigate to the Preference page$")
	public void navigateToPreference() throws InterruptedException {
		// note: if current URL is not on testharness or dashboard, reset it to prep for the test
		String backToUrl=(String) getLoginScenario()
				.getBean(NeedHelpCommonConstants.TEST_INITIAL_PAGE_URL);
		WebDriver wd=(WebDriver) getLoginScenario()
				.getBean(NeedHelpCommonConstants.TEST_DRIVER);
		String currentURL=wd.getCurrentUrl();
		if (!currentURL.equals(backToUrl)) {
			wd.get(backToUrl);
			CommonUtility.checkPageIsReady(wd);
		}
		
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);

		ProfileandPreferencesPage preferencesPg;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			preferencesPg = testHarness.navigateDirectToProfilePageFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			preferencesPg = accountHomePage.navigateDirectToProfilePage();
		}
		CommonUtility.checkPageIsReady(preferencesPg.driver);
		Assert.assertTrue("PROBLEM - unable to navigate to Order Plan Materials page",
				preferencesPg != null);
		getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE,preferencesPg);
		NeedHelpPage needHelpPage=new NeedHelpPage(wd);
		if (memberType.toUpperCase().contains("COMBO"))
			needHelpPage.goToSpecificComboTab(planType);
	}
	
	/** 
	 * This step performs validation on the Need Help section of the Preference Page
	 */
	@Then("^I validate Need Help section on Preference page$")
	public void validate_preferece_needHelp() {
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		ProfileandPreferencesPage preferencesPg = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		Assert.assertTrue("PROBLEM - unable to reach Order Plan Materials page", preferencesPg != null);
		NeedHelpPage needHelpPage=new NeedHelpPage(preferencesPg.driver);
		//note: 
		needHelpPage.validateSectionInNeedHelp(planType, memberType); 
	}
}
