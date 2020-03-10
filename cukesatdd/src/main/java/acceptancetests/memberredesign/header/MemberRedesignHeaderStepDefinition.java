package acceptancetests.memberredesign.header;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

//import pages.dashboard.member.drugcostestimator.blayer.DrugCostEstimatorPage;
import pages.regression.drugcostestimator.DrugCostEstimatorPage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.testharness.TestHarness;
//import pages.memberredesign.bluelayer.AccountHomePage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.memberredesign_deprecated.bluelayer.LoginPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality : Covers step definition methods related to member redesign Header section
 */
public class MemberRedesignHeaderStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo : Finds authenticated user to login
	 * @param memberAttributes
	 */
	@Given("^I am a authenticated member on the member redesign site Header$")
	public void I_am_a_authenticated_member_on_the_member_redesign_site(DataTable memberAttributes) {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario()
			.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
			getLoginScenario().saveBean(LoginCommonConstants.CATOGERY, category);
		}
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);

	}

	/**
	 * @toDo : user gets logged in to new member site
	 */
	@When("^the above plantype user logs in UMS Site Desktop Header$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		String category = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		LoginPage loginPage = new LoginPage(wd);
		//loginPage.loginToStageTestHarness();
		getLoginScenario().saveBean(PageConstantsMnR.LOGIN_PAGE, loginPage);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.thloginWith(userName, pwd,category);
		getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE, accountHomePage);

	}

	/**
	 * @toDo : View Global Navigation Header
	 * @throws InterruptedException
	 */
	@When("^I view the global navigation Header$")
	public void I_view_the_global_navigation() throws InterruptedException {
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.navigateToDCEPageFromTestHarnessPage();
			getLoginScenario().saveBean(PageConstantsMnR.TEST_HARNESS_PAGE, testHarness);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			accountHomePage.navigate_to_dce();
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
		}

		
		/* tbd-remove
		// Express the Regexp above with the code you wish you had
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		//note: updated to use the accounthomepage to navigate to dce, in case need to use 'sorry' page workaround for header testing
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		accountHomePage.navigate_to_dce();
		accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
		*/
		/* tbd-remove
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
		try {
			dce.feebackpopupClose();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AccountHomePage accountHomePage = new AccountHomePage(wd);
		getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
		*/
	}

	/**
	 *  @toDO : see and checks Header
	 */
	@Then("^I should be able to see and use the Home tab Header$")
	public void I_should_be_able_to_see_and_use_the_Home_tab() {
		// Express the Regexp above with the code you wish you had
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)){
			TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarnessPage.navigateDirectToAcccntHomePage();
		}else{
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
				accountHomePage.validateHeader();
		}
	}

	/**
	 *  @toDo : see and validate Find care and cost tab header
	 */
	@Then("^I should be able to see and use the Find Care & Costs tab Header$")
	public void I_should_be_able_to_see_and_use_the_Find_Care_Costs_tab() {
		String memberType = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.validateFindCareCostTab(memberType);
		}else{	
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean
				(PageConstantsMnR.ACCOUNT_HOME_PAGE);
						accountHomePage.validateFindCareCostTab();
						accountHomePage.validateFindCarePage();
					}
		}
	
	/**
	 * @toDo : verify that the Find Care & Costs tab is not displayed for ex: ship plan
	 */
	@Then("^I should not be able to see the Find Care & Costs tab Header$")
	public void I_should_not_be_able_to_see_the_Find_Care_Costs_tab() {
		// Express the Regexp above with the code you wish you had
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.validateFindCareCostTabNotAvailable();
		}else{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			accountHomePage.findCareNotAvailable();
		}
	}

	/**
	 *  @toDo : see and validate Claims tab Header
	 */
	@Then("^I should be able to see and use the Claims tab Header$")
	public void I_should_be_able_to_see_and_use_the_Claims_tab() {
		// Express the Regexp above with the code you wish you had
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage)testHarness.navigateToClaimsSummaryPage();
			getLoginScenario().saveBean(PageConstantsMnR.CLAIM_SUMMARY_PAGE, claimsSummaryPage);
		}else{	
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
				accountHomePage.validateClaims();
				try {
					accountHomePage.feebackpopupClose();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	/**
	 * @toDo : Clicks on Claims tab and see for claims summary tab and Explanation of Benefits tab on second navigation level 
	 */
	@Then("^clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation Header$")
	public void clicking_on_the_Claims_tab_should_allow_me_to_see_links_for_the_Claims_Summary_tab_and_Explanation_of_Benefits_tab_on_the_second_level_navigation() {
		// Express the Regexp above with the code you wish you had
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario().getBean(PageConstantsMnR.CLAIM_SUMMARY_PAGE);
		claimsSummaryPage.validateSubTabs();

	}

	/**
	 * @toDo : Clicks on claims summary tab and navigate to claims summary page
	 */
	@Then("^then click the Claims Summary tab and I should be directed to the Claims Summary Page Header$")
	public void then_click_the_Claims_Summary_tab() {
		// Express the Regexp above with the code you wish you had
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		accountHomePage.checkModelPopup();
		accountHomePage.clickClaimsSummary();
		try {
			accountHomePage.feebackpopupClose();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @toDo : Clicks on Explanation of Benefits tab and navigate to xplanation of Benefits Page
	 */
	@Then("^then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page Header$")
	public void then_click_the_Explanation_of_Benefits_tab() {
		// Express the Regexp above with the code you wish you had
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario().getBean(PageConstantsMnR.CLAIM_SUMMARY_PAGE);
		claimsSummaryPage.clickOnEOBNavTab();

	}

	/**
	 * @toDo : See and validate Coverage & Benefits tab
	 */
	@Then("^I should be able to see and use the Coverage & Benefits tab Header$")
	public void I_should_be_able_to_see_and_use_the_Coverage_Benefits_tab() {
		// Express the Regexp above with the code you wish you had
		{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			accountHomePage.validateCoverageBenefits();
		}
	}

	/**
	 *  @toDo : Clicks on Coverage & Benefits tab and see links for Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation
	 */
	@Then("^clicking on the Coverage & Benefits tab should allow me to see links for the Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation Header$")
	public void clicking_on_the_Coverage_Benefits_tab_should_allow_me_to_see_links_for_the_Benefits_Summary_tab_the_Forms_Resources_tab_and_Explanation_of_Benefits_tab_on_the_second_level_navigation() {
		// Express the Regexp above with the code you wish you had
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			BenefitsAndCoveragePage bncPage = (BenefitsAndCoveragePage)testHarness.validateBnCNavigation();
			bncPage.validateNavTabs();
			getLoginScenario().saveBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE, bncPage);
		}else{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			accountHomePage.validateCoverageBenefitsL2Tabs();
		}
	}
	
	
	/**
	 *  @toDo : Clicks on Coverage & Benefits tab and see links for the Forms & Resources tab on the second level navigation for a terminated member
	 */

     @Then("^clicking on the Coverage & Benefits tab should allow me to see link of for the Forms & Resources tab on the second level navigation Header$")
     public void clicking_on_the_Coverage_Benefits_tab_should_allow_me_to_see_link_of_for_the_Forms_Resources_tab_on_the_second_level_navigation_Header() throws Throwable {
 
	// Express the Regexp above with the code you wish you had
	if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
		TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage)testHarness.validateBnCNavigationForTerminated();
		getLoginScenario().saveBean(PageConstantsMnR.FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
	}else{
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		accountHomePage.validateCoverageBenefitsL2TabsForTerminated();
	}
}
	 

	/**
	 * @toDo : clicks  Benefits Summary tab and Navigate to Benefits Summary Page
	 */
	@Then("^then click the Benefits Summary tab and I should be directed to the Benefits Summary Page Header$")
	public void then_click_the_Benefits_Summary_tab_and_I_should_be_directed_to_the_Benefits_Summary_Page() {
		// Express the Regexp above with the code you wish you had
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		accountHomePage.clickBenefitsSummary();

	}

     
 
	/**
	 *  @toDo : clicks on Forms & Resources tab and Navigate to the Forms & Resources Page
	 */
	@Then("^then click the Forms & Resources tab and I should be directed to the Forms & Resources Page Header$")
	public void then_click_the_Forms_Resources_tab_and_I_should_be_directed_to_the_Forms_Resources_Page() {
		// Express the Regexp above with the code you wish you had
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		BenefitsAndCoveragePage bncPage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		bncPage.clickPlanDocsAndResourcesTab();
	}

	/**
	 *  @toDo : click on Order Materials tab and navigate to Order Materials Page
	 */
	@Then("^then click the Order Materials tab and I should be directed to the Order Materials Page Header$")
	public void then_click_the_Order_Materials_tab_and_I_should_be_directed_to_the_Order_Materials_Page() {
		// Express the Regexp above with the code you wish you had
		String memberType = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		BenefitsAndCoveragePage bncPage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		if(!memberType.equalsIgnoreCase("TERMINATED")){
			bncPage.clickOrderMaterialsNavTab();
		}else
			bncPage.validateOrderPlanMaterialsSubNavNotDisplayed();

	}

	/**
	 *  @toDo : See and click on Premium payment 
	 */
	@Then("^I should be able to see and use the Premium Payments tab Header$")
	public void I_should_be_able_to_see_and_use_the_Premium_Payments_tab() {
		String memberType = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			if(memberType.equalsIgnoreCase("TERMINATED"))
				testHarness.validatePaymentsTabNotDisplayed();
			else{
				PaymentHistoryPage paymentsPage = (PaymentHistoryPage) testHarness.validatePremiumPaymentPage();
				getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_HISTORY_PAGE, paymentsPage);
			}
		}else{AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			try {
				accountHomePage.navigateToPaymentHistoryPage();
				accountHomePage.validatePremiumPage();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		 
	}

	/**
	 *  @toDo : verify that the Premium payment tab is not displayed when premium subsidy is 100%
	 */
	
	@Then("^I should not be able to see the Premium Payments tab Header$")
	public void upon_clicking_the_Premium_Payments_tab_I_should_navigate_to_the_Premium_Payments_Overview_Page() {
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
				testHarness.validatePaymentsTabNotDisplayed();
		}else{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean
				(PageConstantsMnR.ACCOUNT_HOME_PAGE);
						accountHomePage.premiumPaymentsNotAvailable();
		}
	}
	/**
	 *  @toDo : See and Validate Help button present on header
	 */
	@Then("^I should be able to see the help button Header$")
	public void I_should_be_able_to_see_the_help_button() {
		// Express the Regexp above with the code you wish you had
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.clickOnHelpLink();
		}else{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			accountHomePage.validateHelp();
		}
	}

	/**
	 * @toDo : see and validates the Account/Profile dropdown and its options 
	 */
	@Then("^I should be able to see and use the Account/Profile dropdown and logout$")
	public void I_should_be_able_to_see_and_use_the_Account_Profile_dropdown_and_its_options() {
		// Express the Regexp above with the code you wish you had
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.validateAccountProfile();
			testHarness.clickLogout();
		}else{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			accountHomePage.validateAccountProfile();
			accountHomePage.clickLogout();
		}
	}
		
	
	/**
	 *  @toDo : From Member page i see footer section and validate claims , check pop up and validate footer section
	 */
	@When("^I am on the member page then I should be able to see the footer sections Header$")
	public void I_am_on_the_member_page_then_I_should_be_able_to_see_the_footer_sections() {
		// Express the Regexp above with the code you wish you had
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		//accountHomePage.validateClaimsL2Tabs();
		//accountHomePage.checkModelPopup();
		//accountHomePage.validateFooterSection();
	}

	/**
	 *  @toDo : Check for Member support and validate its link under it
	 */
	@When("^Member Support and links under it should be displayed Header$")
	public void Member_Support_and_links_under_it_should_be_displayed() {
		// Express the Regexp above with the code you wish you had
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		//accountHomePage.validateMemberSupport();
	}

	/**
	 * @toDo : Check for quick links and validate its link under it
	 */
	@When("^Quick links and links under it should be displayed Header$")
	public void Quick_links_and_links_under_it_should_be_displayed() {
		// Express the Regexp above with the code you wish you had
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		//accountHomePage.validateQuickLinks();
	}

	/**
	 *  @toDo : Access to Rally Provider Search Tool and checks for Saved option under Quick Links
	 */
	@When("^I have access to the Rally Provider Search Tool and I see the Saved option under Quick Links Header$")
	public void I_have_access_to_the_Rally_Provider_Search_Tool_and_I_see_the_Saved_option_under_Quick_Links() {
		// Express the Regexp above with the code you wish you had
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		//accountHomePage.validateSavedLink();
	}



/**
 * @toDo : To check the header tab for a terminated member
 */

	@Then("^I should be able to see and use the Home tab on Dashboard$")
	public void I_should_be_able_to_see_and_use_Home_tab_on_Dashboard() {
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
	accountHomePage.navigateDirectToBnCPag();
	accountHomePage.validateDashboardHelp();
	accountHomePage.dashboardFindCareNotAvailable();
	accountHomePage.dashboardPremiumPaymentsNotAvailable();
	accountHomePage.validateDashboardClaims();
	accountHomePage.validateFormsResources();
	accountHomePage.validateFormsResourcesPage();
	
	}
	
	@Then("^I should be able to see and use the pharmacies tab in the header$")
	public void I_should_be_able_to_see_the_pharmacies_tab() {
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			String memberType = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
			if(memberType.equalsIgnoreCase("TERMINATED"))
				testHarness.validatePharmaciesTabNotDisplayed();
			else
				testHarness.clickOnPharmaciesNavTab();
		}

	}
	
	@Then("^I should be able to see and use the health and wellness tab in the header$")
	public void I_should_be_able_to_see_the_healthAndWellness_tab() {
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("Health and Wellness page doesn't load on team env, skip this step...");
			return;
		}
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			String memberType = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
			if(memberType.equalsIgnoreCase("TERMINATED"))
				testHarness.validateHealthAndWellnessTabNotDisplayed();
			else
				testHarness.clickHealthnWellnessTab();
		}

	}



}
	
	


