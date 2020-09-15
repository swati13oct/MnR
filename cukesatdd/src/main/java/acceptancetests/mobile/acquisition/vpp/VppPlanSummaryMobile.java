package acceptancetests.mobile.acquisition.vpp;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.VPPTestHarnessPage;
import pages.acquisition.ulayer.keywordSearchAARP;
import pages.mobile.acquisition.dce.ulayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;
import pages.mobile.acquisition.ulayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.ulayer.PlanDetailsPageMobile;
import pages.mobile.acquisition.ulayer.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.ulayer.VPPTestHarnessPageMobile;
//import pages.acquisition.ulayer.keywordSearch;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
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

	/**
	 * @toDo:user is on AARP medicare acquisition site landing page
	 */
	@Given("^the user is on the AARP medicare acquisition site landing page$")
	public void the_user_on_aarp_medicareplans_Site() {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		// aquisitionhomepage.openVPPPage();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	/**
	 * @throws InterruptedException
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user does plan search using the following information in the AARP site$")
	public void zipcode_details_in_aarp_site(DataTable givenAttributes) throws InterruptedException {

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

	
	@And("^Enduser views the plans of the below plan type in AARP site and select Next year$")
	public void user_performs_planSearch_in_aarp_site_next_year(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		if(!plantype.equalsIgnoreCase("MS"))
			plansummaryPage.handlePlanYearSelectionPopup();
	}

	/**
	 * @toDo:user views the plans of the below plan type
	 */
	@And("^the user views plans of the below plan type in AARP site$")
	public void user_performs_planSearch_in_aarp_site(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		System.out.println("Select PlanType to view Plans for entered Zip " + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
	}
	
	/**
	 * @throws InterruptedException
	 * @toDo:user validates plan summary for the below plan
	 */
	@And("^the user validates plan summary for the below plan in AARP site$")
	public void user_validates_plan_summary(DataTable planAttributes) throws InterruptedException {
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
	
	@And("^Enduser validates plan summary for the below plan in AARP site for Medsup Deeplink$")
	public void user_validates_plan_summary_AARP_for_medsup_deepLink(DataTable planAttributes)
			throws InterruptedException {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.validateMedSupSpecificPlanInfo(planName);
	}

	@And("^the user selects plan year for the AARP site$")
	public void user_selects_plan_year(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planYear = givenAttributesMap.get("Plan Year");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
	}

	List<String> allPlanNames = null;

	@When("^user clicks on Continue Enrollment button in AARP Site$")
	public void user_clicks_on_Continue_Enrollment_button_in_aarp_Site() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		allPlanNames = plansummaryPage.getAllPlanNames();
		plansummaryPage.clickContinueEnrollmentBtn();
	}

	@Then("^user saves plan as favorite on AARP site$")
	public void user_saves_plan_as_favorite_on_aarp_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		plansummaryPage.savePlan(PlanName);
	}

	/**
	 * @toDo:user view plan details of the above selected plan in AARP site and
	 *            validates
	 */
	@Then("^the user view plan details of the above selected plan in AARP site and validate$")
	public void user_views_plandetails_selected_plan_aarp(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName, planType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);

		PlanDetailsPageMobile vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Details Page");

	}

	/**
	 * @throws InterruptedException
	 * @toDo:user validates add to compare checkbox on Plan Card
	 */
	@Then("^the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans$")
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

	/**
	 * @toDo:user validates the available plans for selected plan types
	 */
	@Then("^the user validates available plans for selected plan types in the AARP site$")
	public void user_validates_available_plans_aarp() {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (plansummaryPage.validatePlanNames(planType)) {
			String SiteName = "AARP_ACQ";
			getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error validating availables plans for selected plantype in  VPP plan summary page");
		}
	}

	@Then("^the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site")
	public void User_clicks_BackToPlansLink_and_validates_redirection_in_AARP_site() {

		PlanDetailsPageMobile planDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPageFromDetailsPage();
		// VPPPlanSummaryPage plansummaryPage =
		// planDetailsPage.navigateBackToPlanSummaryPage();

		// VPPPlanSummaryPage plansummaryPage =
		// planDetailsPage.navigateBackToPlanSummaryPage();

		if (plansummaryPage != null) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the Plan Summary Page");
	}

	@Then("^the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site$")
	public void User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_aarp() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("MA")) {
			DrugCostEstimatorPageMobile drugCostEstimatorPage = (DrugCostEstimatorPageMobile) getLoginScenario()
					.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
			drugCostEstimatorPage.navigateBackToPlanSummaryPage();

		}
	}

	@Then("^the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site$")
	public void the_user_clicks_enterDrugInformation_validates_dceHomePage_AARP() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("MA")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			DrugCostEstimatorPageMobile drugCostEstimatorPage = plansummaryPage.navigatetoDCEPage(planName);
			if (drugCostEstimatorPage != null) {
				getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, drugCostEstimatorPage);

			} else {
				Assert.fail("Error Loading DCE page");
			}

		}
	}

	@Then("^the user validates Add to compare checkbox is not present for DSNP Plans in AARP$")
	public void addToCompareNotPresentForDSNP() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (planType.equals("SNP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.validateAddToCompareNotPresentForDSNP(planName);
		}
	}

	@Then("^the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site$")
	public void user_validatesPopup_learnMoreAboutExtraHelp_aarp() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("MA")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			// String planName = (String)
			// getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.validatesLearnMoreAboutExtraHelpPopup();
		}
	}

	@Then("^the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site$")
	public void user_validatesAndClickslearnMoreAboutExtraHelp_aarp() throws InterruptedException {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		plansummaryPage.validateAndClickLearnMoreAboutExtraHelpInAARP(planType, planName);
	}

	@Then("^the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans$")
	public void user_validates_IsMyProviderCoveredLink_aarp() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("PDP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.clickOnViewMoreForPlan(planName);
			plansummaryPage.validateIsMyProviderCoveredLinkInAarp(planType, planName);
		}
	}

	@Then("^the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans$")
	public void user_clicks_IsMyProviderCoveredLink_aarp() throws InterruptedException {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("PDP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.ValidateclicksOnIsProviderCovered(planName);
		}
	}

	@Then("^the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page")
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

	@Then("^the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans$")
	public void user_validates_planBenefitValues_inAARP(DataTable givenAttributes) {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("PDP")) {
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
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.clickOnViewMoreForPlan(planName);
			plansummaryPage.validatePlanPremium(planName, monthlyPremium);
			plansummaryPage.validatePrimaryCarePhysicianBenefit(planType, planName, primaryCarePhysician);
			plansummaryPage.validateSpecialistBenefit(planType, planName, specialist);
			plansummaryPage.validateReferrralRequiredBenefit(planName, referralRequired);
			plansummaryPage.validatesOutOfPocketMaximum(planName, outOfPocketMaximum);
			plansummaryPage.validatePrescriptionDrugsTier1(planName, planType, prescriptionDrugsTier1);
		} else
			System.out.println("Benefits are not applicable for PDP Plans");
	}

	@Then("^the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans$")
	public void user_validates_planBenefitValues_PDP_AARP(DataTable givenAttributes) {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (planType.equals("PDP")) {
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}
			String monthlyPremium = memberAttributesMap.get("Monthly Premium");
			String annualDeductible = memberAttributesMap.get("Annual Deductible");
			String prescriptionDrugsTier1 = memberAttributesMap.get("Prescription Drugs, Tier 1");
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.validatePlanPremium(planName, monthlyPremium);
			plansummaryPage.validateAnnualDeductible(planName, annualDeductible);
			plansummaryPage.validatePrescriptionDrugsTier1(planName, planType, prescriptionDrugsTier1);
		} else
			System.out.println("Benefits are not applicable for MA, MAPD and DSNP Plans");
	}

	@Then("^the user validates marketing bullets of the plan in AARP site$")
	public void validate_marketingBullets() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		plansummaryPage.validateMarketingBullets(planType, planName);
	}

	@Then("^the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site$")
	public void toolTip_premium0_validateText_inAARP() throws Throwable {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (planType.equals("MA") || planType.equals("MAPD")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.toolTipForPremium0(planName);
		}
	}
	
	@Given("^enduser is on AARP medicare acquisition site landing page$")
	public void the_user_on_uhc_medicaresolutions_site_mobile() {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@Then("^the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site$")
	public void toolTip_annualDeductible_inAARP() throws Throwable {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (planType.equals("PDP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.toolTipForAnnualDeductible(planName);
		}
	}

	@Then("^the user validates the right rail in AARP Site$")
	public void user_validates_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateRightRailSection();
	}

	@Then("^the user validates the Need Help Section in the right rail in aarp Site$")
	public void validate_needHelp_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateNeedHelpRightRail();
	}

	@Then("^the user validates the TFN in the Need Help Section in aarp Site$")
	public void validate_TFN_inRIghtRail_aarp() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.GetTFNforPlanType();
	}

	@Then("^the user validates and clicks on Find an agent in your area link in aarp Site$")
	public void validateAndClick_findAgentInYourArea_RightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateAgentEBRCPage();
	}

	@Then("^the user validates Get a free medicare Guide section in the right rail in aarp Site$")
	public void validate_freeMedicareGuide_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateMedicareGuideRightRail();
	}

	@Then("^the user enters the following information in the Get a free medicare Guide section in aarp Site$")
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

	@Then("^the user validates Need More Information section in the right rail in aarp Site$")
	public void validate_needMoreInformation_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateNeedMoreInformationRightRail();
	}

	@Then("^the user validates Medicare Plans Video Guide Page after clicking Choose a video link in aarp Site$")
	public void validate_andClick_ChooseAVideo() throws InterruptedException {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateMedicareVideoGuideRightRail();
	}

	@Then("^the user validates Plan Selector Tool section in the right rail in aarp Site$")
	public void validate_planSelectorTool_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validatePlanSelectorToolRightRail();
	}

	@Then("^the user validates Plan Selector Page after clicking on Start Plan Selector button in aarp Site$")
	public void user_validate_planSelectorPage_inaarpSite() throws Exception {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validatePlanSelectorPageInRightRail();
	}

	/**
	 * @toDo:user is on AARP medicare acquisition site landing page
	 */
	@Given("^the potential user is on AARP medicare acquisition site landing page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^the member validates the search engine$")
	public void I_validate_search_box() throws InterruptedException {

		AcquisitionHomePageMobile acquisitionHomePage = (AcquisitionHomePageMobile) loginScenario
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acquisitionHomePage.searchfield();
		keywordSearchAARP newkeywordsearchpage = new keywordSearchAARP(acquisitionHomePage.driver);
		getLoginScenario().saveBean(PageConstants.Keyword_Search, newkeywordsearchpage);
	}

	@Then("^the member lands on the result pag$")
	public void I_land_on_result_page() {
		{

			keywordSearchAARP newkeywordsearchpage = (keywordSearchAARP) loginScenario
					.getBean(PageConstants.Keyword_Search);
			newkeywordsearchpage.url();
			if (newkeywordsearchpage != null)
				getLoginScenario().saveBean(PageConstants.Keyword_Search, newkeywordsearchpage);

		}

	}

	@Then("^the user clicks on Learn More AARP for Rocky Mountain plans$")
	public void the_user_clicks_on_Learn_More_for_AARP_for_Rocky_Mountain_plans(DataTable planAttributes)
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

	@Then("^the user clicks on Learn More AARP for people Health plans$")
	public void the_user_clicks_on_Learn_More_for_AARP_for_people_Health_plans(DataTable planAttributes)
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

	@Then("^user should be able to see the Select Plan for Enroll Modal with saved plans in AARP site$")
	public void user_should_be_able_to_see_Select_Plan_for_Enroll_Modal_with_Saved_plans_in_aarp_site(
			DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		plansummaryPage.verifySelectPlanForEnrollModalForSavedPlans(PlanName);
	}

	@Then("^user should be able to see the Select Plan for Enroll Modal with all plans in AARP site$")
	public void user_should_be_able_to_see_the_Select_Plan_for_Enroll_Modal_with_all_plans_in_aarp_site(DataTable arg1)
			throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifySelectPlanForEnrollModalForallPlans(allPlanNames);
	}
}
