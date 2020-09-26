package acceptancetests.mobile.acquisition.vpp;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AboutUsPage;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AddDrugDetails;
import pages.acquisition.bluelayer.ContactUsUmsPage;
import pages.acquisition.bluelayer.DisclaimersPage;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.bluelayer.PrivacyPolicyUmsPage;
import pages.acquisition.bluelayer.ProviderSearchPage;
import pages.acquisition.bluelayer.SavingsOppurtunity;
import pages.acquisition.bluelayer.SiteMapUMSPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.emailAndPrint.EmailAndPrintUtil;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.VPPTestHarnessPage;
import pages.acquisition.ulayer.keywordSearchAARP;
import pages.mobile.acquisition.bluelayer.AboutUsPageMobile;
import pages.mobile.acquisition.bluelayer.ContactUsUmsPageMobile;
import pages.mobile.acquisition.bluelayer.DisclaimersPageMobile;
import pages.mobile.acquisition.bluelayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.bluelayer.PlanDetailsPageMobile;
import pages.mobile.acquisition.bluelayer.PrivacyPolicyUmsPageMobile;
import pages.mobile.acquisition.bluelayer.ProviderSearchPageMobile;
import pages.mobile.acquisition.bluelayer.SiteMapUMSPageMobile;
import pages.mobile.acquisition.dce.bluelayer.AddDrugDetailsMobile;
import pages.mobile.acquisition.dce.bluelayer.SavingsOppurtunityMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.emailAndPrint.EmailAndPrintUtilMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;
import pages.mobile.acquisition.ulayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.ulayer.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.ulayer.VPPTestHarnessPageMobile;
//import pages.acquisition.ulayer.keywordSearch;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality: VPP flow for AARP site
 */

public class VppPlanSummaryMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;

	@When("^the user validates plan summary for the below plan$")
	public void user_validates_plan_summary_ums(DataTable planAttributes) throws InterruptedException {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assert.assertTrue("Error loading specific plan summary in VPP plan summary page",
				planSummaryPage.getSpecificPlanInfo(planName));
	}

	@Then("^the user validates marketing bullets of the plan$")
	public void validate_marketingBullets() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		plansummaryPage.validateMarketingBullets(planType, planName);
	}

	@Then("^the user validates and clicks Add to compare checkbox for the above selected plan for MA, MAPD , PDP Plans$")
	public void user_validates_addtocompare_aarp() throws InterruptedException {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("SNP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.validateAndClickAddtoCompareinAARP(planType, planName);
			plansummaryPage.compareTextAfterclickingAddtoCompareinAARP(planName);
			plansummaryPage.deselectAddToCompareinAARP(planName);
			
		}
	}

	@Then("^the user views plan details of the above selected plan and validates$")
	public void user_views_plandetails_selected_plan_aarp(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName, planType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);

		pages.mobile.acquisition.ulayer.PlanDetailsPageMobile vppPlanDetailsPage = vppPlanSummaryPage
				.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Details Page");

	}

	@Then("^the user clicks on back to all plans link and validates its redirection to Plan Summary")
	public void User_clicks_BackToPlansLink_and_validates_redirection() {

		PlanDetailsPageMobile planDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPageFromDetailsPage();
		if (plansummaryPage != null) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the Plan Summary Page");
	}

	@Then("^the user validates below plan benefit values for the above selected plan$")
	public void user_validates_planBenefitValues_inAARP(DataTable givenAttributes) {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String primaryCarePhysician = memberAttributesMap.get("Primary Care Physician");
		String specialist = memberAttributesMap.get("Specialist");
		String referralRequired = memberAttributesMap.get("Referral Required");
		String outOfPocketMaximum = memberAttributesMap.get("Out Of Pocket Maximum");
		String prescriptionDrugsTier1 = memberAttributesMap.get("Prescription Drugs, Tier 1");
		String annualDeductible = memberAttributesMap.get("Annual Deductible");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		plansummaryPage.clickOnViewMoreForPlan(planName);
		plansummaryPage.validatePlanPremium(planName, monthlyPremium);
		plansummaryPage.validatePrescriptionDrugsTier1(planName, planType, prescriptionDrugsTier1);
		if (!planType.equals("PDP")) {
			plansummaryPage.validatePrimaryCarePhysicianBenefit(planType, planName, primaryCarePhysician);
			plansummaryPage.validateSpecialistBenefit(planType, planName, specialist);
			plansummaryPage.validateReferrralRequiredBenefit(planName, referralRequired);
			plansummaryPage.validatesOutOfPocketMaximum(planName, outOfPocketMaximum);

		} else {
			plansummaryPage.validateAnnualDeductible(planName, annualDeductible);

		}
	}

	@Then("^the user hover overs the tool tip for Why is my premium 0 and validates the text$")
	public void toolTip_premium0_validateText() throws Throwable {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (planType.equals("MA") || planType.equals("MAPD")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.toolTipForPremium0(planName);
		} else if (planType.equals("PDP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.toolTipForAnnualDeductible(planName);
		}
	}

	@Then("^the user click on return to plan summary from Get Started Page to return to VPP Plan Summary$")
	public void the_user_clicks_on_returnlink_to_vpp_planSummary_Getstarted() {
		GetStartedPageMobile getStartedPage = (GetStartedPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		VPPPlanSummaryPageMobile plansummaryPage = getStartedPage.ClickReturnToBtnToVPPSummary();
		if (null != plansummaryPage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}

	@Then("^the user validates Is my provider covered link$")
	public void user_validates_IsMyProviderCoveredLink_aarp() throws InterruptedException {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		plansummaryPage.clickOnViewMoreForPlan(planName);
		plansummaryPage.validateIsMyProviderCoveredLink(planType, planName);

	}

	@Then("^the user clicks on Enroll Now and validates the Welcome to OLE Page")
	public void user_clicks_enrollInPlan_validates_welcomeOLE() throws InterruptedException {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		WelcomePageMobile welcomeOLEPage = plansummaryPage.Enroll_OLE_Plan(planName, planType);
		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assert.fail("Error Loading Welcome Page for OLE");
		}
	}

	@Given("^the user is on uhcmedicaresolutions site landing page$")
	public void the_user_on_uhc_medicareplans_Site() {
		wd = (AppiumDriver) getLoginScenario().getWebDriverNew();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		// aquisitionhomepage.openVPPPage();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^the user does plan search using the following information in UMS site$")
	public void zipcode_details_in_UMS_site(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = null;
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty(zipcode);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	@Then("^the user validates the right rail in UMS Site$")
	public void user_validates_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateRightRailSection();
	}

	@Then("^the user validates the Need Help Section in the right rail in ums Site$")
	public void validate_needHelp_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateNeedHelpRightRail();
	}

	@Then("^the user validates the TFN in the Need Help Section in ums Site$")
	public void validate_TFN_inRIghtRail_aarp() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.GetTFNforPlanType();
	}

	@Then("^the user validates and clicks on Find an agent in your area link in ums Site$")
	public void validateAndClick_findAgentInYourArea_RightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateAgentEBRCPage();
	}

	@Then("^the user validates Get a free medicare Guide section in the right rail in ums Site$")
	public void validate_freeMedicareGuide_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateMedicareGuideRightRail();
	}

	@Then("^the user enters the following information in the Get a free medicare Guide section in ums Site$")
	public void user_enters_necessaryInformation_inGetFreeMedicareGuideSection(DataTable givenAttributes)
			throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		plansummaryPage.enterRequiredFieldsForMedicareGuide(memberAttributesMap);

	}

	@Then("^the user validates Plan Selector Tool section in the right rail in ums Site$")
	public void validate_planSelectorTool_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validatePlanSelectorToolRightRail();
	}

	@Then("^the user validates Plan Selector Page after clicking on Start Plan Selector button in ums Site$")
	public void user_validate_planSelectorPage_inaarpSite() throws Exception {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validatePlanSelectorPageInRightRail();
	}

	@When("^the user clicks on Aboutus link from home page footer UHC Medicaresolutions Site$")
	public void user_clicks_Aboutus_links_ums() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AboutUsPageMobile aboutUsPage = aquisitionhomepage.aboutUsClick();
		if (aboutUsPage != null) {
			getLoginScenario().saveBean(PageConstants.ABOUT_US_PAGE, aboutUsPage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Error in Aboutus page");

		}

	}

	@When("^the user clicks on Contactus link from about us page footer UHC Medicaresolutions Site$")
	public void user_clicks_Contactus_link_ums() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ContactUsUmsPageMobile contactUsUmsPage = aquisitionhomepage.contactUsClick();
		if (contactUsUmsPage != null) {
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE, contactUsUmsPage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Error in Contact us page");
		}

	}

	@When("^the user clicks on Sitemap link from home page footer UHC Medicaresolutions Site$")
	public void user_clicks_Sitemap_links_ums() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		SiteMapUMSPageMobile siteMapUMSPage = aquisitionhomepage.siteMapFooterClick();
		if (siteMapUMSPage != null) {
			getLoginScenario().saveBean(PageConstants.SITE_MAP_PAGE, siteMapUMSPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in Site map page");

		}
	}

	@When("^the user clicks on Privacy Policy link from Contactus page footer UHC Medicaresolutions Site$")
	public void user_clicks_PrivacyPolicy_link_ums() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PrivacyPolicyUmsPageMobile privacyPolicyUmsPage = aquisitionhomepage.privacyPolicyClick();
		if (privacyPolicyUmsPage != null) {
			getLoginScenario().saveBean(PageConstants.PRIVACY_POLICY_PAGE, privacyPolicyUmsPage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Error in Private policy page");
		}

	}

	@When("^the user clicks on Disclaimers link from Terms of use page footer UHC Medicaresolutions Site$")
	public void user_clicks_Disclaimers_link_ums() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersPageMobile disclaimersPage = aquisitionhomepage.disclaimersClick();
		if (disclaimersPage != null) {
			getLoginScenario().saveBean(PageConstants.DISCLAIMERS_PAGE, disclaimersPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in disclaimers page");
		}

	}

	@When("^user verifies home link of agents&brokers page bluelayer$")
	public void user_verifies_and_clicks_on_home_link_of_agents_brokers_page_blayer() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePageMobile aquisitionHomePageReload = aquisitionhomepage.homeFooterClick();
		Assert.assertTrue("home page not found", aquisitionHomePageReload != null);
	}

	@When("^the user views the plans of the below plan type on test site$")
	public void user_performs_planSearch(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		String site = givenAttributesMap.get("Site");
		System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		getLoginScenario().saveBean(PageConstants.ACQ_PAGE_TYPE, site);
		if (site.equalsIgnoreCase("ulayer")) {
			pages.acquisition.ulayer.VPPPlanSummaryPage plansummaryPage = (pages.acquisition.ulayer.VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			plansummaryPage.viewPlanSummary(plantype);
			EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(plansummaryPage.driver);
			util.handlePlanYearSelectionPopup(plantype);
			getLoginScenario().saveBean(PageConstants.ACQ_PAGE_DRIVER, plansummaryPage.driver);
		} else {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			plansummaryPage.viewPlanSummary(plantype);
			EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(plansummaryPage.driver);
			util.handlePlanYearSelectionPopup(plantype);
			getLoginScenario().saveBean(PageConstants.ACQ_PAGE_DRIVER, plansummaryPage.driver);
		}
	}

	@Then("^user saves first plan on plan summary page on test site$")
	public void saveFirtPlan() {
		wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		util.savedHeartFirstPlanOnSummaryPage();
	}

	@Then("^user validates print option for selected plan on plan summary page on test site$")
	public void user_validates_print_option_for_plan_on_test_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		util.validatePrintOptionExistOnSummaryPage(planType);
	}

	@Then("^user validates print functionality for selected plan on plan summary page on test site$")
	public void user_validates_print_functionality_for_plan_on_test_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		String pageType = "summary";
		util.validatePrintOptionOnPage(pageType, planType);
	}

	@Then("^user validates email option for selected plan on plan summary page on test site$")
	public void user_validates_email_option_on_for_selected_plan_test_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		util.validateEmailOptionExistOnSummaryPage(planType);
	}

	@Then("^user validates email functionality with invalid and valid email address for selected plan on plan summary page on test site$")
	public void user_validates_email_functionality_on_for_selected_plan_test_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		util.validateEmailFunctionOnSummaryPage(planType);

		// note: collect page data for email deeplink validation
		HashMap<String, Integer> vppSummaryPgInfo = util.collectInfoVppPlanSummaryPg();

		// note: if email is successfully sent, deepLink info should be available, save
		// it for later use
		String deepLinkStr = util.getEmailDeepLink();
		getLoginScenario().saveBean(PageConstants.SUMMARY_PAGE_DEEPLINK, deepLinkStr);
		getLoginScenario().saveBean(PageConstants.SUMMARY_PAGE_INFO, vppSummaryPgInfo);
	}

	@SuppressWarnings("unchecked")
	@Then("^user loads page using email deeplink for plan and validate vpp summary page content on test site$")
	public void validate_summary_deeplink() {
		wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String deepLinkStringId = "";
		String infoMapStringId = "";
		deepLinkStringId = PageConstants.SUMMARY_PAGE_DEEPLINK;
		infoMapStringId = PageConstants.SUMMARY_PAGE_INFO;
		String deepLink = (String) getLoginScenario().getBean(deepLinkStringId);
		HashMap<String, Integer> origPage = (HashMap<String, Integer>) getLoginScenario().getBean(infoMapStringId);

		// note: use new driver to achieve clear cache
		WebDriver newTestDriver = getLoginScenario().getWebDriverNew();
		newTestDriver.get(deepLink);
		CommonUtility.checkPageIsReady(newTestDriver);
		// tbd wDriver.navigate().refresh(); //note: need this to trick the original
		// driver from timing out before the validation is done
		util = new EmailAndPrintUtilMobile(newTestDriver);
		util.handlePlanYearSelectionPopup(planType);
		CommonUtility.checkPageIsReady(newTestDriver);
		wd.navigate().refresh(); // note: need this to trick the original driver from timing out before the
									// validation is done
		List<String> noteList = util.validatePlanSummaryEmailDeeplink(planType, deepLinkStringId, infoMapStringId,
				deepLink, origPage);
		getLoginScenario().saveBean(VPPCommonConstants.TEST_RESULT_NOTE, noteList);
	}

	@When("^user Click on Is my Provider covered link ums$")
	public void user_click_on_Providercoveredlink_ums(DataTable Planname) {
		List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String planName = plannameAttributesMap.get("PlanName");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		ProviderSearchPageMobile providerSearchPage = plansummaryPage.clicksOnIsProviderCoveredUms(planName);
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);

		}
	}

	@When("^user selects a provider and retuns to VPP page in ums$")
	public void user_selects_provider_and_return_vpp_page_ums() {
		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			VPPPlanSummaryPageMobile plansummaryPage = providerSearchPage.selectsProvider();
			Assert.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);

		}
	}

	@Then("^Verify X out of Y provider covered information is displayed on Plan Summary page ums$")
	public void verify_providers_covered_ums(DataTable Planname) {

		List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String planName = plannameAttributesMap.get("PlanName");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assert.assertTrue("Provider coverage Info not updated", plansummaryPage.providerinfo(planName));
	}

	@Then("^Verify provider name is displayed on Plan Summary page ums$")
	public void verify_provider_covered_ums(DataTable Planname) {

		List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String planName = plannameAttributesMap.get("PlanName");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyproviderName(planName);
	}

	@Given("^user is on blue layer landing page$")
	public void user_on_UHC_Medicaresolutions_Site() {
		wd = (AppiumDriver) getLoginScenario().getWebDriverNew();

		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		// aquisitionhomepage.openVPPPage();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^user performs plan search using following information in the UMS site$")
	public void zipcode_details_in_UMS_site1(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = null;
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty(zipcode);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	@Then("^the user navigates to the plan details for the given plan type in UMS site$")
	public void the_user_navigates_to_the_plan_details_for_the_given_plan_type_in_UMS_site(DataTable data)
			throws Throwable {
		wd.manage().window().maximize();
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String planType = memberAttributesRow.get(0).getCells().get(1);
		String planName = memberAttributesRow.get(1).getCells().get(1);
		VPPPlanSummaryPageMobile plansummaryPage = new VPPPlanSummaryPageMobile(wd);
		// plansummaryPage.viewPlanSummary(planType);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		pages.mobile.acquisition.ulayer.PlanDetailsPageMobile plandetailspage = plansummaryPage
				.navigateToPlanDetails(planName, planType);
		if (plandetailspage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE, plandetailspage);
		}

	}

	@Then("^the user navigates to Plan Costs tab in UMS site$")
	public void the_user_navigates_to_Plan_Costs_tab_in_UMS_site() throws Throwable {
		PlanDetailsPageMobile planDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_DETAILS_PAGE);
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) planDetailsPage.navigateToDCEThroughPlanCost();
		if (dce != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}

	@Then("^user adds drug to drug cost estimator flow for the given plan name in UMS site$")
	public void the_user_adds_below_drugs_to_drug_cost_estimator_flow_for_the_given_plan_name_on_UHC_site(
			DataTable data) throws Throwable {

		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(1).getCells().get(1);
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		boolean isDrugPresent = dce.isDrugPresent(drug);
		if (!isDrugPresent) {
			AddDrugDetailsMobile addDrugDetails = dce.addDrug(drug.split(" ")[0]);
			if (null != addDrugDetails) {
				getLoginScenario().saveBean(PageConstants.ADD_DRUG_DETAILS, addDrugDetails);
			} else
				Assert.fail("Drug Details content not loaded");
		}

	}

	@Then("^selects drug details in UMS site$")
	public void user_selects_drug_details(DataTable data) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		String quantity = memberAttributesRow.get(1).getCells().get(1);
		String frequency = memberAttributesRow.get(2).getCells().get(1);

		AddDrugDetailsMobile DrugDetails = (AddDrugDetailsMobile) getLoginScenario()
				.getBean(PageConstants.ADD_DRUG_DETAILS);

		/*
		 * if(drug.equalsIgnoreCase("Lipitor"))
		 * DrugDetails.selectDosageAttribute("//li[@data-index='1']");
		 */

		DrugDetails.selectDosageAttribute(drug);
		DrugDetails.selectQnty(quantity);
		DrugDetails.selectFrequency(frequency);
	}

	@When("^user successfully adds drug in the UMS site$")
	public void user_successfully_adds_drug(DataTable data) throws InterruptedException {

		AddDrugDetailsMobile DrugDetails = (AddDrugDetailsMobile) getLoginScenario()
				.getBean(PageConstants.ADD_DRUG_DETAILS);
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		// SavingsOppurtunity savingsOppurtunity =
		// DrugDetails.continueAddDrugDetailsModWithSaving();

		DrugDetails.continueAddDrugDetailsModNoSaving();

		SavingsOppurtunityMobile savingsOppurtunity = new SavingsOppurtunityMobile(wd);
		dce = savingsOppurtunity.savedrugbutton();

		if (null != savingsOppurtunity) {
			getLoginScenario().saveBean(PageConstants.SAVING_OPPORTUNITY, savingsOppurtunity);
		}
	}

	@Then("^the user clicks on the Pick a pharmacy button in the DCE flow in UMS site$")
	public void the_user_clicks_on_the_Pick_a_pharmacy_button_in_the_DCE_flow_in_UMS_site() throws Throwable {

		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		dce.pickAPharmacy();
	}

	@When("^the user selects the pharmacy type and distance in UMS site$")
	public void the_user_selects_the_pharmacy_type_and_distance_in_UMS_site(DataTable data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacyType = memberAttributesRow.get(0).getCells().get(1);
		String distance = memberAttributesRow.get(1).getCells().get(1);

		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		dce.selectRadius(dce.getMilesSelection(), distance);
		dce.selectPharmacyType(pharmacyType);

	}

	@Then("^the user selects a pharmacy from the list of pharmacies in UMS site$")
	public void the_user_selects_a_pharmacy_from_the_list_of_pharmacies_in_UMS_site(DataTable data) throws Throwable {

		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacyName = memberAttributesRow.get(0).getCells().get(1);

		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.verifyPharmacyResults();
		for (int i = 0; i < dce.getLstPharmacyNames().size(); i++)
			if (dce.getLstPharmacyNames().get(i).getText().toLowerCase().contains(pharmacyName.toLowerCase())) {
				dce.getLstSelectPharmacy().get(i).click();
				break;
			}

		dce.clickButtonViewCost();
	}

	/* DCE cost Estimator */
	String cost;

	@Then("^the user validates the added drugs on See your Estimated Costs page in UMS site$")
	public void the_user_validates_the_added_drugs_on_See_your_Estimated_Costs_page_in_UMS_site(DataTable data)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		cost = dce.getCostText().getText();
		/*
		 * if(cost.contains("$")) cost=cost.split("$")[1];
		 */

		String drug = null;
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			drug = memberAttributesRow.get(i).getCells().get(1).toLowerCase().trim();
			if (dce.getHdrDrugName().get(i).getText().toLowerCase().trim().split(" ")[0]
					.contains(drug.split(" ")[0].trim().toLowerCase()))
				Assert.assertTrue(dce.getHdrDrugName().get(i).getText().toLowerCase().trim() + "is found", true);
			else
				Assert.assertTrue(dce.getHdrDrugName().get(i).getText().toLowerCase().trim() + "isn't found", false);
		}

		// dce.validateTotalEstimatedAnnualDrugCosts(totalAnnualDrugCost);
	}

	@When("^the user clicks on Edit Drug List link in UMS site$")
	public void the_user_clicks_on_Edit_Drug_List_link_in_UMS_site() throws Throwable {
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickEditDrugList();

	}

	@Then("^Enter your drugs page is displayed to the user in UMS site$")
	public void enter_your_drugs_page_is_displayed_to_the_user_in_UMS_site() throws Throwable {
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		Assert.assertEquals("Find A Pharamcy line is not present, pick a pharmacy section isn't displayed", true,
				dce.getLblCreateAListOfThePrescriptionDrug().isDisplayed());

	}

	@Then("^User click on Switch now to select the Generic of the Brand drug added in UMS site$")
	public void user_click_on_Switch_now_to_select_the_Generic_of_the_Brand_drug_added_in_UMS_site() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickSwitchNUpdateAll();

	}

	@Then("^the user change the pharmacy type and select new pharmacy in UMS site$")
	public void the_user_change_the_pharmacy_type_and_select_new_pharmacy_in_UMS_site(DataTable data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacyType = memberAttributesRow.get(0).getCells().get(1);

		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.selectPharmacyType(pharmacyType);
		dce.clickButtonViewCost();
	}

	@Then("^the user clicks on Back to Plans button on See Your Estimated Costs page in UMS site$")
	public void the_user_clicks_on_Back_to_Plans_button_on_See_Your_Estimated_Costs_page_in_UMS_site()
			throws Throwable {
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickBtnBackToPlansNavigateToDetails();
	}

	/* Plan Cost tab */
	String planCostTabEstimatedTotalAnnualCost;

	/* Cost comparison for Plan Costs Tab */
	@Then("^user verifies annual drug cost in the Plan Cost tab of UMS site$")
	public void user_verifies_annual_drug_cost_in_the_Plan_Cost_tab_of_UMS_site(DataTable data) throws Throwable {

		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String planType = memberAttributesRow.get(0).getCells().get(1);
		PlanDetailsPageMobile plandetailspage = new PlanDetailsPageMobile(wd, planType);

		planCostTabEstimatedTotalAnnualCost = plandetailspage.costComparisonCostTabFromDCE();

		if (cost.trim().contains(planCostTabEstimatedTotalAnnualCost))
			Assert.assertTrue("It's a match on on prescription drug tab and Drug CostEstimator page", true);
		else
			Assert.assertTrue("Cost mismatch on prescription drug tab and drug CostEstimator page", false);

		// plandetailspage.navigateBackToPlanSummaryPageFromDetailsPage();

		getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE, plandetailspage);

	}

	/* Back To All Plans on prescription drug tab */
	@Then("^the user clicks on Back to All Plans button present on details page in UMS site$")
	public void the_user_clicks_on_Back_to_All_Plans_button_present_UMS_sit() throws Throwable {
		PlanDetailsPageMobile plandetailspage = new PlanDetailsPageMobile(wd);

		plandetailspage.navigateBackToPlanSummaryPageFromDetailsPage();

	}

	@Then("^user validates Drug information is reflected on plan summary page in UMS site$")
	public void user_validates_Drug_information_is_reflected_on_plan_summary_page_in_UMS_site(DataTable data)
			throws Throwable {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();

		String planName = memberAttributesRow.get(0).getCells().get(1);
		// VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(wd);
		System.out.println(cost);
		System.out.println(plansummaryPage.getValEstimatedAnnualDrugCostValue(planName).getText().trim());
		if (cost.trim().contains(plansummaryPage.getValEstimatedAnnualDrugCostValue(planName).getText().trim()))
			Assert.assertTrue(true);
		else
			Assert.assertTrue("Cost Mismatch on VPP and Drug cost estimator page", false);
	}

	@When("^the user validates plan summary for the below plan in UMS site$")
	public void user_validates_plan_summary_ums1(DataTable planAttributes) throws InterruptedException {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assert.assertTrue("Error loading specific plan summary in VPP plan summary page",
				planSummaryPage.getSpecificPlanInfo(planName));
	}

	@Then("^the user clicks on Learn More UMS for Rocky Mountain plans$")
	public void the_user_clicks_on_Learn_More_for_UHC_for_Rocky_Mountain_plans(DataTable planAttributes)
			throws Throwable {

		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.RockyLearnMoreButtonandValidate(planName);
	}

	@Then("^the user clicks on Learn More UMS for people Health plans$")
	public void the_user_clicks_on_Learn_More_for_UHC_for_people_Health_plans(DataTable planAttributes)
			throws Throwable {

		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.peopleLearnMoreButtonandValidate(planName);
	}

}
