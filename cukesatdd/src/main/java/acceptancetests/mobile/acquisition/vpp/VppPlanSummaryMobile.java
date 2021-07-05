package acceptancetests.mobile.acquisition.vpp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
//import pages.acquisition.ulayer.keywordSearch;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mobile.acquisition.commonpages.AboutUsPageMobile;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.ComparePlansPageMobile;
import pages.mobile.acquisition.commonpages.ContactUsUmsPageMobile;
import pages.mobile.acquisition.commonpages.DisclaimersAARPPageMobile;
import pages.mobile.acquisition.commonpages.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.commonpages.MultiCountyModalPageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.PrivacyPolicyUmsPageMobile;
import pages.mobile.acquisition.commonpages.ProviderSearchPageMobile;
import pages.mobile.acquisition.commonpages.SiteMapAARPPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;
import pages.mobile.acquisition.dce.bluelayer.AddDrugDetailsMobile;
import pages.mobile.acquisition.dce.bluelayer.SavingsOppurtunityMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.emailAndPrint.EmailAndPrintUtilMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;

/**
 * Functionality: VPP flow for AARP site
 */

public class VppPlanSummaryMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	//AppiumDriver wd;
	
	@Then("^user should be able to see the NBA modal to add drugs on the VPP summary page$")
	public void user_should_be_able_to_see_the_NBA_modal_to_add_drugs_on_the_VPP_summary_page() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNextBestActionModalForDrugCost();
	}
	
	@Then("^the user validates the added drug name on plan summary page for the selected plan$")
	public void verify_drugs_covered_AARP(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("Plan Name");
		String drugName = plannameAttributesMap.get("DrugName");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assertion.assertTrue("Drugs coverage Info not updated", plansummaryPage.verifyAddedDrugName(planName, drugName));
	}

	
	@Then("^user changes zipcode within VPP page$")
	public void User_Change_ZipCode_VPP_pages(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		
		if (plansummaryPage != null) {
			System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
			plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode(zipcode, county, isMultiCounty);
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}
	}

	@When("^the user validates plan summary for the below plan$")
	public void user_validates_plan_summary(DataTable planAttributes) throws InterruptedException {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String planName = givenAttributesMap.get("Plan Name").trim();
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assertion.assertTrue("Error loading specific plan summary in VPP plan summary page",
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
			plansummaryPage.validateAndClickAddtoCompare(planType, planName);
			plansummaryPage.compareTextAfterclickingAddtoCompareinAARP(planName);
			plansummaryPage.deselectAddToCompare(planName);

		}
	}

	@Then("^the user views plan details of the above selected plan and validates$")
	public void user_views_plandetails_selected_plan_aarp(DataTable givenAttributes) throws InterruptedException {
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName, planType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		vppPlanSummaryPage.clickOnViewMoreForPlan(PlanName);
		PlanDetailsPageMobile vppPlanDetailsPage = vppPlanSummaryPage
				.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in Loading the Plan Details Page");

	}

	@Then("^the user clicks on back to all plans link and validates its redirection to Plan Summary")
	public void User_clicks_BackToPlansLink_and_validates_redirection() {

		PlanDetailsPageMobile planDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPageFromDetailsPage();
//		if (plansummaryPage != null) {
//			Assertion.assertTrue(true);
//		} else
//			Assertion.fail("Error in validating the Plan Summary Page");

	}

	@Then("^the user validates below plan benefit values for the above selected plan$")
	public void user_validates_planBenefitValues_inAARP(DataTable givenAttributes) {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		
		String plantype = memberAttributesMap.get("Plan Type");
		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String primaryCarePhysician = memberAttributesMap.get("Primary Care Physician");
		String specialist = memberAttributesMap.get("Specialist");
		String referralRequired = memberAttributesMap.get("Referral Required");
		String outOfPocketMaximum = memberAttributesMap.get("Out Of Pocket Maximum");
		String prescriptionDrugsTier1 = memberAttributesMap.get("Prescription Drugs, Tier 1");
		String annualDeductible = memberAttributesMap.get("Annual Deductible");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.viewPlanSummary(plantype);		
		
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
		if (planType.equals("MA") || planType.equals("MAPD") || planType.equals("SNP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.toolTipForPremium0(planName);
//			plansummaryPage.viewPlanSummary(planType);
		} else if (planType.equals("PDP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
			plansummaryPage.toolTipForAnnualDeductible(planName);
//			plansummaryPage.viewPlanSummary(planType);
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
			Assertion.fail("DCE Redesign page object not loaded");
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
			Assertion.fail("Error Loading Welcome Page for OLE");
		}
	}

	@Given("^the user is on uhcmedicaresolutions site landing page$")
	public void the_user_on_uhc_medicareplans_Site() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getWebDriverNew();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		// aquisitionhomepage.openPRE();
		aquisitionhomepage.openMobileURL();
		// aquisitionhomepage.openVPPPage();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^the user does plan search using the following information in UMS site$")
	public void zipcode_details_in_UMS_site(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

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
			Assertion.fail("Error Loading VPP plan summary page");
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
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
			Assertion.assertTrue(true);

		} else {
			Assertion.fail("Error in Aboutus page");

		}

	}

	@When("^the user clicks on Contactus link from about us page footer UHC Medicaresolutions Site$")
	public void user_clicks_Contactus_link_ums() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ContactUsUmsPageMobile contactUsUmsPage = aquisitionhomepage.contactUsClick();
		if (contactUsUmsPage != null) {
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE, contactUsUmsPage);
			Assertion.assertTrue(true);

		} else {
			Assertion.fail("Error in Contact us page");
		}

	}

	@When("^the user clicks on Sitemap link from home page footer UHC Medicaresolutions Site$")
	public void user_clicks_Sitemap_links_ums() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		SiteMapAARPPageMobile siteMapUMSPage = aquisitionhomepage.siteMapFooterClick();
		if (siteMapUMSPage != null) {
			getLoginScenario().saveBean(PageConstants.SITE_MAP_PAGE, siteMapUMSPage);
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Error in Site map page");

		}
	}

	@When("^the user clicks on Privacy Policy link from Contactus page footer UHC Medicaresolutions Site$")
	public void user_clicks_PrivacyPolicy_link_ums() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PrivacyPolicyUmsPageMobile privacyPolicyUmsPage = aquisitionhomepage.privacyPolicyClick();
		if (privacyPolicyUmsPage != null) {
			getLoginScenario().saveBean(PageConstants.PRIVACY_POLICY_PAGE, privacyPolicyUmsPage);
			Assertion.assertTrue(true);

		} else {
			Assertion.fail("Error in Private policy page");
		}

	}

	@When("^the user clicks on Disclaimers link from Terms of use page footer UHC Medicaresolutions Site$")
	public void user_clicks_Disclaimers_link_ums() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersAARPPageMobile disclaimersPage = aquisitionhomepage.disclaimersClick();
		if (disclaimersPage != null) {
			getLoginScenario().saveBean(PageConstants.DISCLAIMERS_PAGE, disclaimersPage);
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Error in disclaimers page");
		}

	}

	@When("^user verifies home link of agents&brokers page bluelayer$")
	public void user_verifies_and_clicks_on_home_link_of_agents_brokers_page_blayer() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePageMobile aquisitionHomePageReload = aquisitionhomepage.homeFooterClick();
		Assertion.assertTrue("home page not found", aquisitionHomePageReload != null);
	}

	@When("^the user views the plans of the below plan type on test site$")
	public void user_performs_planSearch(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String plantype = givenAttributesMap.get("Plan Type");
		String site = givenAttributesMap.get("Site");
		System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		getLoginScenario().saveBean(PageConstants.ACQ_PAGE_TYPE, site);
		if (site.equalsIgnoreCase("ulayer")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		util.savedHeartFirstPlanOnSummaryPage();
	}

	@Then("^user validates print option for selected plan on plan summary page on test site$")
	public void user_validates_print_option_for_plan_on_test_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		util.validatePrintOptionExistOnSummaryPage(planType);
	}

	@Then("^user validates print functionality for selected plan on plan summary page on test site$")
	public void user_validates_print_functionality_for_plan_on_test_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		String pageType = "summary";
		util.validatePrintOptionOnPage(pageType, planType);
	}

	@Then("^user validates email option for selected plan on plan summary page on test site$")
	public void user_validates_email_option_on_for_selected_plan_test_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		util.validateEmailOptionExistOnSummaryPage(planType);
	}

	@Then("^user validates email functionality with invalid and valid email address for selected plan on plan summary page on test site$")
	public void user_validates_email_functionality_on_for_selected_plan_test_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		util.validateEmailFunctionOnSummaryPage(planType);

		// note: collect page data for email deeplink validation
		HashMap<String, Integer> vppSummaryPgInfo = util.collectInfoVppPlanSummaryPg();

		// note: if email is successfully sent, deepLink info should be available, save
		// it for later use
		String deepLinkStr = util.getEmailDeepLink(wd);
		getLoginScenario().saveBean(PageConstants.SUMMARY_PAGE_DEEPLINK, deepLinkStr);
		getLoginScenario().saveBean(PageConstants.SUMMARY_PAGE_INFO, vppSummaryPgInfo);
	}

	@SuppressWarnings("unchecked")
	@Then("^user loads page using email deeplink for plan and validate vpp summary page content on test site$")
	public void validate_summary_deeplink() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wd);
		CommonUtility commonUtils = new CommonUtility();
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
		commonUtils.checkPageIsReady(newTestDriver);
		// tbd wDriver.navigate().refresh(); //note: need this to trick the original
		// driver from timing out before the validation is done
		util = new EmailAndPrintUtilMobile(newTestDriver);
		util.handlePlanYearSelectionPopup(planType);
		commonUtils.checkPageIsReady(newTestDriver);
		wd.navigate().refresh(); // note: need this to trick the original driver from timing out before the
									// validation is done
		List<String> noteList = util.validatePlanSummaryEmailDeeplink(planType, deepLinkStringId, infoMapStringId,
				deepLink, origPage);
		getLoginScenario().saveBean(VPPCommonConstants.TEST_RESULT_NOTE, noteList);
	}

	@When("^user Click on Is my Provider covered link ums$")
	public void user_click_on_Providercoveredlink_ums(DataTable Planname) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
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
			Assertion.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);

		}
	}

	@Then("^Verify X out of Y provider covered information is displayed on Plan Summary page ums$")
	public void verify_providers_covered_ums(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("PlanName");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assertion.assertTrue("Provider coverage Info not updated", plansummaryPage.providerinfo(planName));
	}

	@Then("^Verify provider name is displayed on Plan Summary page ums$")
	public void verify_provider_covered_ums(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("PlanName");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyproviderName(planName);
	}

	@Given("^user is on blue layer landing page$")
	public void user_on_UHC_Medicaresolutions_Site() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getMobileDriver();

		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		// aquisitionhomepage.openPRE();
		aquisitionhomepage.openMobileURL();
		// aquisitionhomepage.openVPPPage();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^user performs plan search using following information in the UMS site$")
	public void zipcode_details_in_UMS_site1(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

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
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@Then("^the user navigates to the plan details for the given plan type in UMS site$")
	public void the_user_navigates_to_the_plan_details_for_the_given_plan_type_in_UMS_site(DataTable data)
			throws Throwable {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		//wd.manage().window().maximize();
		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String planType = memberAttributesRow.get(0).getCells().get(1);
		String planName = memberAttributesRow.get(1).getCells().get(1);*/
		String planType = data.cell(0, 1);
		String planName = data.cell(1, 1);
		VPPPlanSummaryPageMobile plansummaryPage = new VPPPlanSummaryPageMobile(wd);
		// plansummaryPage.viewPlanSummary(planType);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		PlanDetailsPageMobile plandetailspage = plansummaryPage
				.navigateToPlanDetails(planName, planType);
		if (plandetailspage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE, plandetailspage);
		}

	}

	@Then("^the user navigates to Plan Costs tab in UMS site$")
	public void the_user_navigates_to_Plan_Costs_tab_in_UMS_site() throws Throwable {
		PlanDetailsPageMobile planDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_DETAILS_PAGE);
		DrugCostEstimatorPageMobile dce = planDetailsPage.navigateToDCEThroughPlanCost();
		if (dce != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}

	@Then("^user adds drug to drug cost estimator flow for the given plan name in UMS site$")
	public void the_user_adds_below_drugs_to_drug_cost_estimator_flow_for_the_given_plan_name_on_UHC_site(
			DataTable data) throws Throwable {

		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(1).getCells().get(1);*/
		String drug = data.cell(1, 1);
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		boolean isDrugPresent = dce.isDrugPresent(drug);
		if (!isDrugPresent) {
			pages.mobile.acquisition.commonpages.AddDrugDetailsMobile addDrugDetails = dce.addDrug(drug.split(" ")[0]);
			if (null != addDrugDetails) {
				getLoginScenario().saveBean(PageConstants.ADD_DRUG_DETAILS, addDrugDetails);
			} else
				Assertion.fail("Drug Details content not loaded");
		}

	}

	@Then("^selects drug details in UMS site$")
	public void user_selects_drug_details(DataTable data) throws InterruptedException {

		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		String quantity = memberAttributesRow.get(1).getCells().get(1);
		String frequency = memberAttributesRow.get(2).getCells().get(1);*/

		String drug = data.cell(0, 1);
		String quantity = data.cell(1, 1);
		String frequency = data.cell(2, 1);
		
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
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
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
		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacyType = memberAttributesRow.get(0).getCells().get(1);
		String distance = memberAttributesRow.get(1).getCells().get(1);*/

		String pharmacyType = data.cell(0, 1);
		String distance = data.cell(1, 1);
		
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		dce.selectRadius(dce.getMilesSelection(), distance);
		dce.selectPharmacyType(pharmacyType);

	}

	@Then("^the user selects a pharmacy from the list of pharmacies in UMS site$")
	public void the_user_selects_a_pharmacy_from_the_list_of_pharmacies_in_UMS_site(DataTable data) throws Throwable {

		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacyName = memberAttributesRow.get(0).getCells().get(1);*/

		String pharmacyName = data.cell(0, 1);
		
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.verifyPharmacyResults();
		for (int i = 0; i < dce.getLstPharmacyNames().size(); i++)
			if (dce.getLstPharmacyNames().get(i).getText().toLowerCase().contains(pharmacyName.toLowerCase())) {
				//dce.getLstSelectPharmacy().get(i).click();
				dce.jsClickNew(dce.getLstSelectPharmacy().get(i));
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
//		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		List<List<String>> memberAttributesRow = data.asLists();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			drug = memberAttributesRow.get(i).get(1).toLowerCase().trim();
			if (dce.getHdrDrugName().get(i).getText().toLowerCase().trim().split(" ")[0]
					.contains(drug.split(" ")[0].trim().toLowerCase()))
				Assertion.assertTrue(dce.getHdrDrugName().get(i).getText().toLowerCase().trim() + "is found", true);
			else
				Assertion.assertTrue(dce.getHdrDrugName().get(i).getText().toLowerCase().trim() + "isn't found", false);
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

		Assertion.assertEquals("Find A Pharamcy line is not present, pick a pharmacy section isn't displayed", true,
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
		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacyType = memberAttributesRow.get(0).getCells().get(1);*/

		String pharmacyType = data.cell(0, 1);
		
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
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String planType = memberAttributesRow.get(0).getCells().get(1);*/
		String planType = data.cell(0, 1);
		PlanDetailsPageMobile plandetailspage = new PlanDetailsPageMobile(wd, planType);

		planCostTabEstimatedTotalAnnualCost = plandetailspage.costComparisonCostTabFromDCE();

		if (cost.trim().contains(planCostTabEstimatedTotalAnnualCost))
			Assertion.assertTrue("It's a match on on prescription drug tab and Drug CostEstimator page", true);
		else
			Assertion.assertTrue("Cost mismatch on prescription drug tab and drug CostEstimator page", false);

		// plandetailspage.navigateBackToPlanSummaryPageFromDetailsPage();

		getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE, plandetailspage);

	}

	/* Back To All Plans on prescription drug tab */
	@Then("^the user clicks on Back to All Plans button present on details page in UMS site$")
	public void the_user_clicks_on_Back_to_All_Plans_button_present_UMS_sit() throws Throwable {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PlanDetailsPageMobile plandetailspage = new PlanDetailsPageMobile(wd);

		plandetailspage.navigateBackToPlanSummaryPageFromDetailsPage();

	}

	@Then("^user validates Drug information is reflected on plan summary page in UMS site$")
	public void user_validates_Drug_information_is_reflected_on_plan_summary_page_in_UMS_site(DataTable data)
			throws Throwable {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();

		String planName = memberAttributesRow.get(0).getCells().get(1);*/
		
		String planName = data.cell(0, 1);
		// VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(wd);
		System.out.println(cost);
		System.out.println(plansummaryPage.getValEstimatedAnnualDrugCostValue(planName).getText().trim());
		if (cost.trim().contains(plansummaryPage.getValEstimatedAnnualDrugCostValue(planName).getText().trim()))
			Assertion.assertTrue(true);
		else
			Assertion.assertTrue("Cost Mismatch on VPP and Drug cost estimator page", false);
	}

	@When("^the user validates plan summary for the below plan in UMS site$")
	public void user_validates_plan_summary_ums1(DataTable planAttributes) throws InterruptedException {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assertion.assertTrue("Error loading specific plan summary in VPP plan summary page",
				planSummaryPage.getSpecificPlanInfo(planName));
	}

	@Then("^the user clicks on Learn More UMS for Rocky Mountain plans$")
	public void the_user_clicks_on_Learn_More_for_UHC_for_Rocky_Mountain_plans(DataTable planAttributes)
			throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.RockyLearnMoreButtonandValidate(planName);
	}
	
	@Then("^the user clicks on Learn More for Rocky Mountain plans$")
	public void the_user_clicks_on_Learn_More__for_Rocky_Mountain_plns(DataTable planAttributes) throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.RockyLearnMoreButtonandValidate(planName);
	}

	@Then("^the user clicks on Learn More UMS for people Health plans$")
	public void the_user_clicks_on_Learn_More_for_UHC_for_people_Health_plans(DataTable planAttributes)
			throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.peopleLearnMoreButtonandValidate(planName);
	}
	
	/*@Given("^the user hovers screen over the shop for a plan$")
	public void the_user_hovers_screen_over_the_shop_for_a_plan() throws Throwable {
		AcquisitionHomePageMobile acqusitionHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ShopForPlanNavigationPage shop = acqusitionHomePage.Hoveronaplan();
		if (shop != null) {
			System.out.println("Shop for a plan drop down is opened");
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER, shop);
		} else {
			Assertion.fail("Issue in selecting a plan drop down");
		}
	}*/
	
	
	/*@Given("^the user hovers screen over the learnabout Medicare for a plan$")
	public void the_user_hovers_screen_over_the_learnabout_Medicare_for_a_plan() throws Throwable {	
		AcquisitionHomePageMobile acqusitionHomePage = (AcquisitionHomePageMobile) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ShopForPlanNavigationPage shop = acqusitionHomePage.HoveronalearnaboutMedicare();
//		if (shop!=null) {
//			System.out.println("Medicare Education drop down is opened");
//			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER, shop);
//		}
//		else {
//			Assertion.fail("Issue in selecting a plan drop down");
//		}
	}*/
	
	@Then("^the site user validates the RightRails Links on Medsupp Page$")
	public void user_validate_rightrail_links_medsupp_page() throws Throwable {
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * Map<String, String> memberAttributesMap = new HashMap<String, String>(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); } String urGuideURL =
		 * memberAttributesMap.get("UR Guide URL"); String GuideYourHealthURL =
		 * memberAttributesMap.get("Guide Your Health URL"); String OutlineCoverageURL =
		 * memberAttributesMap.get("Outline Coverage URL"); String PlanOverviewLink =
		 * memberAttributesMap.get("Plan overview URL"); String RulesandDisclosureLink=
		 * memberAttributesMap.get("Rules and Disclosure URL");
		 */
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		// if(urGuideURL!=null){
		plansummaryPage.medsuppOLERightRail();
		plansummaryPage.medsuppOLERightRailGuideourhealth();
	//	plansummaryPage.medsuppOLERightRailoutlinecoverage();
		plansummaryPage.medsuppOLERightRailplanoverview();
		plansummaryPage.medsuppOLERightRailRulesDisclose();
		plansummaryPage.medsuppOLERightRailEnrollmentDiscount();
		//plansummaryPage.medsuppOLERightRailLearnmore();

		// Assertion.assertTrue(true);
		// }else
		// Assertion.fail("Error in loading the yourguide Page");

	}


	
	@Then("^the site user clicks on View Plans Button proceed to View Plans Page$")
	public void the_site_users_clicks_on_View_Plans_Button_proceed_to_View_Plans_Page_button(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String DateOfBirth = memberAttributesMap.get("DOB");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation(DateOfBirth);
	}
	
	@When("the user selects plan year for PRE Flow$")
	public void users_selects_plan_year_for_PRE_Flow(DataTable givenAttributes) {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planYear = givenAttributesMap.get("Plan Year");
		// VPPPlanSummaryPage plansummaryPage = null;
		// VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(wd);
		VPPPlanSummaryPageMobile plansummaryPage = new VPPPlanSummaryPageMobile(
				(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		// getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
		// plansummaryPage);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_YEAR, planYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, planYear);

	}
	

	@Given("^the user is on medicare acquisition site landing page fro campaign Traffic$")
	public void the_user__medicaresolutions_Site_campaign_Traffic(DataTable givenAttributes) {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String site = memberAttributesMap.get("Site");
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd, site);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, " ");
		getLoginScenario().saveBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS, " ");

		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, site);
		if (site.equalsIgnoreCase("AARP")) 
		aquisitionhomepage.validateSubtitle();
	}
	
	@Given("^the user navigates to following Campaign acquisition site page$")
	public void the_user_navigates_to_following_medicare_acquisition_site(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String path = memberAttributesMap.get("PagePath");
		// String plantype = memberAttributesMap.get("Plan Type");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : " + path);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VPPPlanSummaryPageMobile plansummaryPage = aquisitionhomepage.navigateToPathNew(path);
		// Thread.sleep(5000);
		// VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(wd);
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			// getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}
	
	@Then("^the user clicks on the united health care medicare solutions link$")
	public void the_user_clicks_on_the_united_health_care_medicare_solutions_link() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickUnitedHealthcareMedicareSolutions();

	}

	@Then("^the user clicks on Learn More for people Health plans$")
	public void the_user_clicks_at_Learn_More_for_people_Health_plans(DataTable planAttributes) throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.peopleLearnMoreButtonandValidate(planName);
	}

	@Then("^the user validates the Cancel button for Multi County Pop-up lands on enter Zip code Page$")
	public void the_user_validates_the_Cancel_button_for_Multi_COunty_Pop_up_lands_on_enter_Zip_code_Page()
			throws Throwable {
		MultiCountyModalPageMobile multiCountyModalPage = (MultiCountyModalPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean Validation_Flag = multiCountyModalPage.validateMultiCounty_CancelButton();
		Assertion.assertTrue("Validation failed : Cancel button Validation for Multi County Pop-up Failed ",
				Validation_Flag);

	}
	
	@Then("^user verify the popup and content on the site$")
	public void user_verify_the_popup_and_content_on_the_site() throws InterruptedException {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallpopup();
	}
	
	@Then("^user saves two ms plans as favorite$")
	public void user_saves_two_ms_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		
		String ms_savePlanNames = memberAttributesMap.get("MS Test Plans");

		// ----- MS plan type ----------------------------
		plansummaryPage.saveMSPlans(ms_savePlanNames);

	}
	@And ("^the user login with optum Id credentials$")
	public void the_user_login_with_optum_Id_credentials(DataTable credentials) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(credentials);
		
		String username = plannameAttributesMap.get("User Name");
		String password = plannameAttributesMap.get("Password");
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		
		System.out.println("credentials" + username + password);
		visitorProfile.logIn(username, password);
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfile);
	}
	
	@Then("^user should be able to see the NBA modal to Enroll Plan on the VPP summary page$")
	public void user_should_be_able_to_see_the_NBA_modal_to_Enroll_Plan_on_the_VPP_summary_page() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNextBestActionModalForEnrollPlan();
	}
	
	@Given("^I select \"([^\"]*)\" plans to compare and click on compare plan link$")
	public void i_select_plans_to_compare_and_click_on_compare_plan_link_in_AARP(String planType) throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if (planType.equals("MAPD")) {
			plansummaryPage.checkAllMAPlans();
			System.out.println("Selected All MAPD plans for Plan Compare");
		} else if (planType.equals("PDP")) {
			plansummaryPage.checkAllPDPlans();
			System.out.println("Selected All PDP plans for Plan Compare");
		}
		ComparePlansPageMobile planComparePage = plansummaryPage.clickOnCompareLink(planType);
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

		} else
			Assertion.fail("Error in loading the compare plans page");
	}
	
	@And("^user validate Find a Provider NBA on VPP|user be able to see the Find a Provider NBA on VPP$")
	public void user_validate_Find_a_Provider_NBA_on_VPP() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateProviderNBA();
	}
	
	
	@When("^user clicks on Find a Provider button on NBA$")
	public void user_clicks_on_Find_a_provider_button_on_NBA() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) plansummaryPage
				.clickNextBestActionModalFindMyDoctorsBtn();
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}
	}


	@Then("^user should be able to see the NBA modal to add providers on the VPP summary page$")
	public void user_should_be_able_to_see_the_NBA_modal_to_add_providers_on_the_VPP_summary_page() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNextBestActionModalForProviderSearch();
	}
	
	@When("^user clicks on Find My Doctor button$")
	public void user_clicks_on_Find_My_Doctor_button() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) plansummaryPage
				.clickNextBestActionModalFindMyDoctorsBtn();
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}
	}
	
	List<String> allPlanNames = null;
	
	@When("^user clicks on Select a plan button on NBA$")
	public void user_clicks_on_select_a_plan_button_on_NBA() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		System.out.println("plan ytpe" +planType);
		allPlanNames = plansummaryPage.getAllPlanNames(planType);
		plansummaryPage.clickSelectPlanButton();
	}
	
	@Then("^user should be able to see the Select Plan for Enroll Modal with saved plans$")
	public void user_should_be_able_to_see_Select_Plan_for_Enroll_Modal_with_Saved_plans(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		System.out.println("Plan name" + PlanName);
		plansummaryPage.verifySelectPlanForEnrollModalForSavedPlans(PlanName);
	}
	
	@When("^user clicks on Enroll in plan button on the select plan modal on vpp summary page$")
	public void user_clicks_on_Enroll_in_plan_button_on_the_select_plan_modal() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		WelcomePageMobile welcomepage = (WelcomePageMobile) plansummaryPage.clickEnrollPlanBtnOnSelectPlanModal();
		getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,welcomepage);
	}
	
	@Then("^user should be navigated to OLE page$")
	public void user_should_be_navigated_to_OLE_page() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateNavigatedToOle();
	}
	
	@Then("^user should be able to see the Select Plan for Enroll Modal with all plans on vpp summary page$")
	public void user_should_be_able_to_see_the_Select_Plan_for_Enroll_Modal_with_all_plans_in_UMS_site()
			throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifySelectPlanForEnrollModalForAllPlans(allPlanNames);

	}
	
	@When("^user removes drugs from plan card$")
	public void user_removes_drugs_from_plan_card() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.removeDrugsFromPlanCard();
	}
	
	@Then("^user should see the Get started NBA on VPP$")
	public void user_should_see_the_Get_started_NBA() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNextBestActionModalForDrugCostAuthenticated();
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	}
	
	
	@Then("^user verify NBA is not displayed on the VPP page$")
	public void user_verify_NBA_is_not_displayed_on_the_VPP_page() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNBAModalNotDisplayed();
	}
}
