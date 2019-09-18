package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstantsMnR;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.contactus.ContactUsPage;
import pages.regression.footer.FooterPage;
import pages.regression.healthandwellness.HealthAndWellnessPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import pages.regression.testharness.TestHarness;

/**
 Functionality : validate the Pharmacies & Prescriptions Page content on the member site.
 */
public class PharmaciesAndPrescriptionsStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	/**
	 * This step performs navigation from either dashboard or testharness to the pharmacies and prescriptions page.
	 * If user is on dashboard page, it will navigate via the top menu 'pharmacies and prescriptions' link.
	 * If user is on testharness, it will navigate through the link for the pharmacies and prescriptions page in the table.
	 * @throws InterruptedException 
	 */
	@When("^user navigates to the pharmacies and prescriptions page from dashboard or testharness page$")
	public void navigate_PnP_page(DataTable givenAttributes) throws InterruptedException { 
		Map<String, String> givenAttributesMap = parseInputArguments(givenAttributes);
		String planType = givenAttributesMap.get("Plan Type");
		String memberType = givenAttributesMap.get("Member Type");
		PharmaciesAndPrescriptionsPage pnpPg;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			pnpPg = testHarness.navigateToPharAndPresFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			//note: rally data not yet sync up so dashboard will not have pnp link, just go through secondary page
			pnpPg = accountHomePage.navigateToPharmaciesAndPrescriptions();
			if (pnpPg==null) //note: try secondary page before giving up
				pnpPg = accountHomePage.navigateToPharmaciesAndPrescriptionsFromSecondaryPg();
		}
		Assert.assertTrue("PROBLEM - unable to navigate to Pharmacies & Prescriptions page", 
				pnpPg != null);
		
		Thread.sleep(2000); //let page settle down before looking into the localStorage.consumerDetails
		String userFirstName=pnpPg.getInfoInConsumerDetails(planType, memberType, "firstName");
		String userLastName=pnpPg.getInfoInConsumerDetails(planType, memberType, "lastName");
		String userPlanCategoryId=pnpPg.getInfoInConsumerDetails(planType, memberType, "planCategoryId");
		
		System.out.println("TEST - userFirstName="+userFirstName+" | userLastName="+userLastName+" | userPlanCategoryId="+userPlanCategoryId);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE, planType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE, memberType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_FIRSTNAME, userFirstName);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_LASTNAME, userLastName);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_PLAN_CATEGORY_ID, userPlanCategoryId);
	}
	
	@Then("^user validates header section content$")
	public void validate_header_section() {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		String firstName=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_FIRSTNAME);
		String lastName=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_LASTNAME);
		pnpPg.validateHeaderSectionContent(firstName, lastName);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
	@Then("^user validates pharmacies text content$")
	public void validate_header_sub_section() {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmaciesText();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
	@Then("^user validates pharmacies tiles section content$")
	public void validate_pharmacies_tiles_section() {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		// if LIS != 0, no benefit tile
		// if PEEHIP group user, no prescriptions tile and no delivery
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		String  planCategoryId=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_PLAN_CATEGORY_ID);
		boolean tileDrug=true;
		boolean tilePharmacy=true;	
		boolean tilePrescription=true;
		boolean tileDelivery=true;
		if (memberType.toUpperCase().contains("PEEHIP")) {
			tilePrescription=false;
			tileDelivery=false;
		}
		boolean tileBenefit=false;
		if (planCategoryId.equalsIgnoreCase("0")) {
			tileBenefit=true;
		}
		
		pnpPg.validatePharmaciesTilesSection(tileDrug, tilePharmacy, tilePrescription,tileDelivery,tileBenefit);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	

	@Then("^user validates pharmacies tile Compare drug pricing page$")
	public void validate_compare_drug_pricing_page() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		String tile="Compare drug pricing";
		pnpPg.validateTileLnkDestination(planType, memberType, tile);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}	

	@Then("^user validates pharmacies tile Find a network pharmacy page$")
	public void validate_find_a_network_pharmacy_page() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		String tile="Find a network pharmacy";
		pnpPg.validateTileLnkDestination(planType, memberType, tile);		
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}	

	@Then("^user validates pharmacies tile Order prescription refills page$")
	public void validate_order_prescription_refills_page() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		String tile="Order prescription refills";
		pnpPg.validateTileLnkDestination(planType, memberType, tile);		
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, 
				pnpPg);
	}	
	
	@Then("^user validates pharmacies tile Check home delivery order status page$")
	public void validate_check_home_delivery_order_status_page() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		String tile="Check home delivery order status";
		pnpPg.validateTileLnkDestination(planType, memberType, tile);		
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}	
	
	@Then("^user validates pharmacies tile Prescription Benefits Information page$")
	public void validate_prescription_benefits_info_page() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		String  planCategoryId=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_PLAN_CATEGORY_ID);
		String tile="Prescription Benefits Information";
		pnpPg.validateTileLnkDestination(planType, memberType, tile, planCategoryId);		
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}	
	
	@Then("^user validates Plan Materials link$")
	public void validate_planMaterials_link() {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePlanMaterialsLink();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
	@Then("^user validates Need Help section content$")
	public void validate_need_help_section() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNeedHelpSection(planType, memberType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
	@Then("^user should not see Pharmacies and Prescription link on dashboard$")
	public void validateNoPnPLinkOnDashboard(DataTable givenAttributes) {
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			System.out.println("Dashboard related validation will be skipped on NON-testharness environment...skipping");
			return;
		}
		Map<String, String> givenAttributesMap = parseInputArguments(givenAttributes);
		String planType = givenAttributesMap.get("Plan Type");
		String memberType = givenAttributesMap.get("Member Type");
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		boolean result = accountHomePage.findShadowRootTopMenuLinkForPnP();
		Assert.assertTrue("PROBLEM - user '"+planType+"' '"+memberType+"' should not have Pharmacies & Prescriptions link on dashboard", !result);
	}

	@Then("^user should see Pharmacies and Prescription link on dashboard$")
	public void validatePnPLinkOnDashboard(DataTable givenAttributes) {
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			System.out.println("Dashboard related validation will be skipped on NON-testharness environment...skipping");
			return;
		}
		Map<String, String> givenAttributesMap = parseInputArguments(givenAttributes);
		String planType = givenAttributesMap.get("Plan Type");
		String memberType = givenAttributesMap.get("Member Type");
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		boolean result = accountHomePage.findShadowRootTopMenuLinkForPnP();
		Assert.assertTrue("PROBLEM - user '"+planType+"' '"+memberType+"' should have Pharmacies & Prescriptions link on dashboard", result);
	}
	@Then("^user should not see Pharmacies and Prescription link on secondary page$")
	public void validateNoPnPLinkOnSecondaryPage(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = parseInputArguments(givenAttributes);
		String planType = givenAttributesMap.get("Plan Type");
		String memberType = givenAttributesMap.get("Member Type");
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testharnessPg = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			result=testharnessPg.findPnPLinksExistOnSecondaryPg();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			result=accountHomePage.findPnPLinksExistOnSecondaryPg();
		}
		Assert.assertTrue("PROBLEM - user '"+planType+"' '"+memberType+"' should not have Pharmacies & Prescriptions link on dashboard", !result);
	}
	
	@And("^user validates the footer section$")
	public void user_validates_footer_in_claimsPage() throws InterruptedException{
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		FooterPage footerPg=new FooterPage(pnpPg.driver);
		footerPg.validateFooterLinks();
	}

	@Then("^user navigates to the claims page to validate Pharamcies and Prescriptions link$")
	public void validate_claims_page() throws InterruptedException { 
		String page="claims";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			ClaimsSummaryPage claimsPg=testHarness.navigateToClaimsSummaryFromTestHarnessPage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, claimsPg!=null);
			result=testHarness.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			testHarness.driver.navigate().back();
			CommonUtility.checkPageIsReady(testHarness.driver);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			ClaimsSummaryPage claimsPg=accountHomePage.navigateToClaimsSummaryPage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, claimsPg!=null);
			result=accountHomePage.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			accountHomePage.driver.navigate().back();
			CommonUtility.checkPageIsReady(accountHomePage.driver);
		}
	}
	
	@Then("^user navigates to the benefit and coverage page to validate Pharamcies and Prescriptions link$")
	public void validate_bnc_page() throws InterruptedException { 
		String page="benefit and coverage";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			BenefitsAndCoveragePage bncPg=testHarness.navigateDirectToBnCPagFromTestharnessPage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, bncPg!=null);
			result=testHarness.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			testHarness.driver.navigate().back();
			CommonUtility.checkPageIsReady(testHarness.driver);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			BenefitsAndCoveragePage bncPg=accountHomePage.navigateDirectToBnCPag();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, bncPg!=null);
			result=accountHomePage.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			accountHomePage.driver.navigate().back();
			CommonUtility.checkPageIsReady(accountHomePage.driver);
		}
	}

	@Then("^user navigates to the payment page to validate Pharamcies and Prescriptions link$")
	public void validate_payment_page() throws InterruptedException { 
		String page="payment";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			PaymentHistoryPage paymentPg=testHarness.navigateToPaymentFromTestHarnessPage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, paymentPg!=null);
			result=testHarness.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			testHarness.driver.navigate().back();
			CommonUtility.checkPageIsReady(testHarness.driver);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			PaymentHistoryPage paymentPg=accountHomePage.navigateTooPaymentHistoryPage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, paymentPg!=null);
			result=accountHomePage.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			accountHomePage.driver.navigate().back();
			CommonUtility.checkPageIsReady(accountHomePage.driver);
		}
	}

	@Then("^user navigates to the health and wellness page to validate Pharamcies and Prescriptions link$")
	public void validate_health_and_wellness_page() throws InterruptedException { 
		if (MRScenario.environment.equalsIgnoreCase("team-a"))	{		
			System.out.println("Lower env doesn't support Health and Wellness page, skipping this step");
			return;
		}
		String page="health and wellness";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			HealthAndWellnessPage healthnWellnessPg = new HealthAndWellnessPage(testHarness.driver);
			healthnWellnessPg.clickHealthnWellnessTab();
			HealthAndWellnessPage.checkForIPerceptionModel(healthnWellnessPg.driver);
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, healthnWellnessPg!=null);
			result=testHarness.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			testHarness.driver.navigate().back();
			CommonUtility.checkPageIsReady(testHarness.driver);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			HealthAndWellnessPage healthnWellnessPg = new HealthAndWellnessPage(accountHomePage.driver);
			healthnWellnessPg.clickHealthnWellnessTab();
			HealthAndWellnessPage.checkForIPerceptionModel(healthnWellnessPg.driver);
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, healthnWellnessPg!=null);
			result=accountHomePage.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			accountHomePage.driver.navigate().back();
			CommonUtility.checkPageIsReady(accountHomePage.driver);
		}
	}
	
	@Then("^user navigates to the contact us page to validate Pharamcies and Prescriptions link$")
	public void validate_contact_us_page() throws InterruptedException { 
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			String page="contact us";
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			ContactUsPage contactUsPg=testHarness.navigateToContactUsPageFromTestHarnessPage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, contactUsPg!=null);
			result=testHarness.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);

			//note: go to common question page
			page="contact us - common questions";
			contactUsPg.navigateToCommonQuestionsPg();
			result=testHarness.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			
			testHarness.driver.navigate().back(); //note: back to contact us page
			CommonUtility.checkPageIsReady(testHarness.driver);
			testHarness.driver.navigate().back(); //note: back to testharness page
			CommonUtility.checkPageIsReady(testHarness.driver);
		} else {
			String page="contact us";
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			ContactUsPage contactUsPg=accountHomePage.navigateToContactUsPage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, contactUsPg!=null);
			result=accountHomePage.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			
			//note: go to common question page
			page="contact us - common questions";
			contactUsPg.navigateToCommonQuestionsPg();
			result=accountHomePage.findPnPLinksExistOnPg();
			Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			
			accountHomePage.driver.navigate().back();
			CommonUtility.checkPageIsReady(accountHomePage.driver);
			accountHomePage.driver.navigate().back();
			CommonUtility.checkPageIsReady(accountHomePage.driver);
		}
	}
	
	@Then("^user navigates to the account setting to validate Pharamcies and Prescriptions link$")
	public void validate_account_setting_page() throws InterruptedException { 
		String page="account setting";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			ProfileandPreferencesPage acctPg=testHarness.navigateDirectToProfilePageFromTestHarnessPage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, acctPg!=null);
			result=testHarness.findPnPLinksExistOnPg();
			testHarness.driver.navigate().back();
			CommonUtility.checkPageIsReady(testHarness.driver);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			ProfileandPreferencesPage acctPg=accountHomePage.navigateDirectToProfilePage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, acctPg!=null);
			result=accountHomePage.findPnPLinksExistOnPg();
			accountHomePage.driver.navigate().back();
			CommonUtility.checkPageIsReady(accountHomePage.driver);
		}
		Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
	}
	
	@Then("^user navigates to the Notices and Disclosures to validate Pharamcies and Prescriptions link$")
	public void validate_disclosures_page() throws InterruptedException { 
		String page="notices and disclosures";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.navigateToNoticeAndDisclosuresPage();
			result=testHarness.findPnPLinksExistOnPg();
			testHarness.driver.navigate().back();
			CommonUtility.checkPageIsReady(testHarness.driver);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			//note: rally dashboard will open new tab for this page
			WebDriver testDriver=accountHomePage.driver;
			String winHandleBefore = testDriver.getWindowHandle();
			accountHomePage.navigateToNoticeAndDisclousuresPage();
			result=accountHomePage.findPnPLinksExistOnPg();
			ArrayList<String> afterClicked_tabs = new ArrayList<String>(testDriver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();					
			testDriver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			testDriver.close();
			testDriver.switchTo().window(winHandleBefore);
	
			CommonUtility.checkPageIsReady(accountHomePage.driver);
		}
		Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
	}
}
