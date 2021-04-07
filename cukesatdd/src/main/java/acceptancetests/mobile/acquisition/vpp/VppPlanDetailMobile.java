package acceptancetests.mobile.acquisition.vpp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.ComparePlansPageBlayerMobile;
import pages.mobile.acquisition.commonpages.ComparePlansPageMobile;
import pages.mobile.acquisition.commonpages.FindCarePageMobile;
import pages.mobile.acquisition.commonpages.MultiCountyModalPageMobile;
import pages.mobile.acquisition.commonpages.PlanComparePageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.ProviderSearchPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VPPTestHarnessPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfileTestHarnessPageMobile;
import pages.mobile.acquisition.commonpages.ZipcodeLookupHomePageMobile;
import pages.mobile.acquisition.dce.bluelayer.AddDrugDetailsMobile;
import pages.mobile.acquisition.dce.ulayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;

/**
 * Functionality: VPP UHC site
 */

public class VppPlanDetailMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;

	/**
	 * @toDo:user is on the uhcmedicaresolutions site landing page
	 */
	@Given("^the user is on the uhcmedicaresolutions site landing page$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		// aquisitionhomepage.openPRE();
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@Given("^the user lands on AARP medicare acquisition site page$")
	public void the_user_lands_AARP_medicares_Site() {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		// aquisitionhomepage.openPRE();
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}
	
	@Then("^the user click on Prescription Drug Benefits and validates$")
	public void the_user_click_on_Prescription_Drug_Benefits_and_validates() throws Throwable {
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.clickAndValidatePrescriptionDrugBenefits();
	}
	
	@Then("^the user clicks on both top and bottom back to plans link and validate its redirection$")
	public void the_user_clicks_on_both_topand_bottom_back_to_plans_link_and_validate_its_redirection()
			throws InterruptedException {
		// getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
		// vppPlanDetailsPage);
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatetopbacktoplanslink();
		vppPlanDetailsPage.browserBack();
		vppPlanDetailsPage.validatedownbacktoplanslink();

	}
	
	@Then("^the user click on Plan costs tab and validates on site$")
	public void the_user_click_on_Plan_costs_tab_and_validates_in_site(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String yearlyPremium = memberAttributesMap.get("Yearly Premium");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.clickAndValidatePlanCosts(monthlyPremium, yearlyPremium);
		Assertion.assertTrue("Validation failed : Expected text not displayed for monthly and yearly premium - "
				+ monthlyPremium + " " + yearlyPremium, validationFlag);
	}
	
	@Then("^the user click on Optional Services tab and add the rider on site$")
	public void the_user_click_on_Optional_Services_tab_and_add_the_rider_in_AARP_site(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String optionalRider = memberAttributesMap.get("Optional Rider");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		String optionalRiderPremium = vppPlanDetailsPage.addOptionalRider(optionalRider);
	}
	
	@Then("^the user click on Plan costs tab and validates in site$")
	public void the_user_click_on_Plan_costs_tab_and_validates_in_AARP_site(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String yearlyPremium = memberAttributesMap.get("Yearly Premium");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.clickAndValidatePlanCosts(monthlyPremium, yearlyPremium);
		Assertion.assertTrue("Validation failed : Expected text not displayed for monthly and yearly premium - "
				+ monthlyPremium + " " + yearlyPremium, validationFlag);
	}
	
	@Then("^the user click on PDF link and validates document code in site URL$")
	public void the_user_click_on_PDF_link_and_validates_document_code_in_site_URL(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String PDFtype = memberAttributesMap.get("PDF type");

		String DocumentCode = memberAttributesMap.get("DocumentCode");
		boolean validationFlag = vppPlanDetailsPage.ClickValidatePDFlink(PDFtype, DocumentCode);
		Assertion.assertTrue("Validation failed : Expected Document Code is not Present in the PDF URL ", validationFlag);
	}

	
	@Then("^the user validates following PDF link is displayed with correct document code$")
	public void the_user_validates_following_PDF_link_is_displayes_with_correct_document_code(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String PDFtype = memberAttributesMap.get("PDF type");
		String DocumentCode = memberAttributesMap.get("DocumentCode");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		boolean validationFlag = vppPlanDetailsPage.ValidatePDFlinkIsDisplayed(PDFtype, DocumentCode);
		Assertion.assertTrue("Validation failed : Expected text not displayed for riders monthly and yearly premium - ",
				validationFlag);
	}

	@When("^user selects a provider and retuns to VPP plan details page in ulayer$")
	public void user_selects_provider_and_return_vpp_Plan_details_page_ulayer() {
		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			PlanDetailsPageMobile planDetailsPage = providerSearchPage.selectsProviderFromVppPlanDetailsPage();
			Assertion.assertTrue("Not able to return to Plan Details page", planDetailsPage != null);

		}
	}

	/**
	 * @toDo:Verify X out of Y provider covered information is displayed on Plan
	 *              Summary page
	 */
	@Then("^Verify X out of Y provider covered information is displayed on Plan Details page Ulayer$")
	public void verify_providers_covered_ulayer_planDetails() {
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		Assertion.assertTrue("Provider coverage Info not updated", vppPlanDetailsPage.providerinfo());
	}

	@Given("^the user navigates to following UHC medicare solutions site page$")
	public void the_user_navigates_to_following_UHC_medicare_acquisition_site_page(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : " + path);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPath(path);
	}

	@Then("^the user clicks on Enroll Now in Plan Details Page to start the OLE flow$")
	public void the_user_clicks_on_Enroll_Now_in_Plan_Details_Page_to_start_the_OLE_flow() throws Throwable {

		getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);

		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String TFN;
		String SiteName;
		SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);
		

		String PlanPremium = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM);

		WelcomePageMobile welcomePage;
		if (SiteName.contains("UHC_ACQ")) {

			PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			TFN = vppPlanDetailsPage.GetTFNforPlanType();
			welcomePage = vppPlanDetailsPage.Enroll_OLE_Plan(PlanName);
		} else {
			PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			TFN = vppPlanDetailsPage.GetTFNforPlanType();
			welcomePage = vppPlanDetailsPage.Enroll_OLE_Plan(PlanName);
		}
		// String PlanPremium = (String)
		// getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : " + PlanName);
		System.out.println("Plan Type is : " + PlanType);
		System.out.println("Plan Zip Code is : " + ZipCode);
		System.out.println("Plan County Name is : " + County);
		System.out.println("Plan Plan Premium is : " + PlanPremium);
		System.out.println("TFN for Plan Type is : " + TFN);
		System.out.println("Plan Year is : " + PlanYear);
		System.out.println("OLE is being started from Acquisition Site : " + SiteName);
		if (welcomePage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Welcome Page");
	}

	@Then("^the user validates the Plan details on OLE$")
	public void the_user_validates_the_Plan_details_on_OLE() throws Throwable {

		WelcomePageMobile welcomePage = (WelcomePageMobile) getLoginScenario()
				.getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		Map<String, String> PlanDetailsMap = new HashMap<String, String>();
		PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
		PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
		PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
		PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
		PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));

		boolean Validation_Status = welcomePage.validate_plan_details(PlanDetailsMap);
		if (Validation_Status) {
			System.out.println("Plan Details Validation in OLE PAGE : " + Validation_Status + " - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			Assertion.assertTrue(true);
		} else {
			System.out.println("Plan Details Validation in OLE PAGE : " + Validation_Status);
			Assertion.fail();
		}
	}

	@When("^user selects a provider and retuns to VPP plan details page in blayer$")
	public void user_selects_provider_and_return_vpp_Plan_details_page_blayer() {
		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			PlanDetailsPageMobile planDetailsPage = providerSearchPage.selectsProviderFromVppPlanDetailsPage();
			Assertion.assertTrue("Not able to return to Plan Details page", planDetailsPage != null);

		}
	}

	@Then("^Verify X out of Y provider covered information is displayed on Plan Details page blayer$")
	public void verify_providers_covered_blayer_planDetails() {
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		if (!vppPlanDetailsPage.providerinfo()) {
			Assertion.fail("Failed in validating the provider link on plan details page");
		}
	}

	@Then("^I verify the plan name in UMS site$")
	public void verifyPlanName(DataTable attributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String planname = memberAttributesMap.get("Plan Name");

		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.verifyplanname(planname);
		if (dce != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}

	@Then("^selects drug details for other drugs in UMS site$")
	public void user_selects_drug_details_for_other_drugs(DataTable data) throws InterruptedException {

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

		DrugDetails.continueAddDrugDetailsModNoSaving();

	}

	/* Prescription Drug tab */
	String estimatedTotalAnnualCost;

	/* DCE cost Estimator */
	String cost;

	/* Cost comparison for prescription drugs */
	@Then("^user verifies annual drug cost in the prescription drug tab of UMS site$")
	public void user_verifies_drug_cost_in_UMS_site(DataTable data) throws Throwable {

		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String planType = memberAttributesRow.get(0).getCells().get(1);*/
		String planType = data.cell(0, 1);
		PlanDetailsPageMobile plandetailspage = new PlanDetailsPageMobile(wd, planType);

		estimatedTotalAnnualCost = plandetailspage.costComparisonPrescriptionDrugFromDCE();

		if (cost.trim().contains(estimatedTotalAnnualCost))
			Assertion.assertTrue("It's a match on on prescription drug tab and Drug CostEstimator page", true);
		else
			Assertion.assertTrue("Cost mismatch on prescription drug tab and drug CostEstimator page", false);

		// plandetailspage.navigateBackToPlanSummaryPageFromDetailsPage();

		getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE, plandetailspage);

	}

	@When("^the user does plan search using the following information in the AARP site$")
	public void zipcode_details_in_aarp_site(DataTable givenAttributes) throws InterruptedException {

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

	/**
	 * @throws InterruptedException
	 * @toDo : the user enters the zip code to search plans
	 */
	@When("^the user performs plan search using following information in UMS site$")
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
		getLoginScenario().saveBean(VPPCommonConstantsMobile.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.IS_MULTICOUNTY, isMultiCounty);

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

	@When("^the user enters zipcode on health plans page in UMS site$")
	public void enters_zipcode_details_in_UMS_site(DataTable givenAttributes) {
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
		getLoginScenario().saveBean(VPPCommonConstantsMobile.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.IS_MULTICOUNTY, isMultiCounty);

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = null;
		plansummaryPage = aquisitionhomepage.searchPlanOnHealthPlansPage(zipcode, county, isMultiCounty);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}

	}

	/**
	 * @toDo : the user enters the zip code to search plans on team-c
	 */
	@When("^the user performs plan search TeamC using following information in UMS site$")
	public void zipcode_details_in_TeamC_site(DataTable givenAttributes) {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstantsMobile.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.COUNTY, county);

		/*
		 * TeamCAcqHome aquisitionhomepage = (TeamCAcqHome) getLoginScenario()
		 * .getBean(PageConstants.ACQUISITION_HOME_PAGE);
		 */
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		// VPPPlanSummaryPageMobile plansummaryPage =
		// aquisitionhomepage.searchPlans(zipcode, county);
		VPPPlanSummaryPageMobile plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			if (plansummaryPage.validateVPPPlanSummaryPage())
				Assertion.assertTrue(true);
			else
				Assertion.fail("Error in validating the Plan Summary Page");

		}

	}

	/**
	 * @throws InterruptedException
	 * @toDo:user views plans of the below plan type
	 */
	@When("user views plans of the below plan type in UMS site$")
	public void user_performs_planSearch_in_UMS_site(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String plantype = givenAttributesMap.get("Plan Type");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		// plansummaryPage.handlePlanYearSelectionPopup();
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, "UHC_ACQ");
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
	}

	@When("user views plans of the below plan type in UMS site for current year$")
	public void user_performs_planSearch_in_UMS_site_current_year(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String plantype = givenAttributesMap.get("Plan Type");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		plansummaryPage.CheckClick_CurrentYear_Plans();
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, "UHC_ACQ");
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
	}

	@When("user views plans of the below plan type in UMS site for next year$")
	public void user_performs_planSearch_in_UMS_site_next_year(DataTable givenAttributes) {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String plantype = givenAttributesMap.get("Plan Type");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*
		 * try { Thread.sleep(7000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		plansummaryPage.viewPlanSummary(plantype);
		// plansummaryPage.CheckClick_NextYear_Plans();
		if (!plantype.equalsIgnoreCase("MS"))
			plansummaryPage.handlePlanYearSelectionPopup();
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, "UHC_ACQ");
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
	}

	@When("the user selects plan year for the UMS site$")
	public void user_selects_plan_year(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planYear = givenAttributesMap.get("Plan Year");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.handlePlanYearSelectionPopup(planYear);

	}

	@Then("^the user validates the Enroll Now Button present for the plan type$")
	public void Enroll_now_button_validation(DataTable givenAttributes) {

		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.PLAN_NAME, PlanName);
		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String PlanPremium = vppPlanSummaryPage.EnrollmentValidation(PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);

	}

	@Then("^the user validates the Enroll Now Button present for the Chronic plan type$")
	public void Chronic_Enroll_now_button_validation(DataTable givenAttributes) throws InterruptedException {

		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.PLAN_NAME, PlanName);
		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		WelcomePageMobile welcomePage = vppPlanSummaryPage.EnrollmentValidationChronic(PlanName);
		getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);

	}

	/**
	 * @toDo:user view plan details of the above selected plan
	 */
	@Then("^the user view plan details of the above selected plan in UMS site and validates$")
	public void user_views_plandetails_selected_plan_ums(DataTable givenAttributes) {

		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planName = memberAttributesRow.get(0).getCells().get(1);*/
		String planName = givenAttributes.cell(0, 1);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		vppPlanSummaryPage.clickOnViewMoreForPlan(planName);
		PlanDetailsPageMobile vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(planName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		} else
			Assertion.fail("Error in validating the Plan Details Page");
	}

	@Then("^the user validates following PDF link is displayes with correct document code for UHC$")
	public void the_user_validates_following_PDF_link_is_displayes_with_correct_document_code_for_UHC(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String PDFtype = memberAttributesMap.get("PDF type");
		String DocumentCode = memberAttributesMap.get("DocumentCode");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		boolean validationFlag = vppPlanDetailsPage.ValidatePDFlinkIsDisplayed(PDFtype, DocumentCode);
		Assertion.assertTrue("Validation failed : Expected text not displayed for riders monthly and yearly premium - ",
				validationFlag);

	}

	@Then("^the user click on PDF link and validates document code in URL for UHC$")
	public void the_user_click_on_PDF_link_and_validates_document_code_in_URL_for_UHC(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String PDFtype = memberAttributesMap.get("PDF type");

		String DocumentCode = memberAttributesMap.get("DocumentCode");
		boolean validationFlag = vppPlanDetailsPage.ClickValidatePDFlink(PDFtype, DocumentCode);
		Assertion.assertTrue("Validation failed : Expected Document Code is not Present in the PDF URL ", validationFlag);

	}

	@When("^the user validates the pdf section for uhc$")
	public void userValidatesPDFSection() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatePdfSection(planType);
	}

	@Then("^the user validates the document code is present in the PDF for UHC$")
	public void the_user_click_on_PDF_link_and_validates_document_code_in_PDF_for_UHC(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String PDFtype = memberAttributesMap.get("PDF type");

		String DocumentCode = memberAttributesMap.get("DocumentCode");
		boolean validationFlag = vppPlanDetailsPage.ClickValidatePDFText_ForDocCode(PDFtype, DocumentCode);
		Assertion.assertTrue("Validation failed : Expected Document Code is not Present in the PDF Text ", validationFlag);

	}

	@Then("^the user view plan details of the above selected plan in UMS site vpp$")
	public void the_user_view_plan_details_of_the_above_selected_plan_in_UMS_site_vpp(DataTable givenAttributes)
			throws InterruptedException {

		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.PLAN_NAME, PlanName);
		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName, planType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);

		PlanDetailsPageMobile vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in Loading the Plan Details Page");
	}

	@Then("^the user view plan details of the first plan in the given plan type in UMS site vpp$")
	public void the_user_view_plan_details_of_the_first_plan_in_UMS_site_vpp() {
		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) vppPlanSummaryPage
				.navigateToFirstPlanForPlanDetails(planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in Loading the Plan Details Page");
	}

	@Then("^the user clicks on both top and bottom back to plans link and validates its redirection$")
	public void the_user_clicks_on_both_topand_bottom_back_to_plans_link_and_validates_its_redirection()
			throws InterruptedException {
		// getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
		// vppPlanDetailsPage);
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatetopbacktoplanslink();
		vppPlanDetailsPage.browserBack();
		vppPlanDetailsPage.validatedownbacktoplanslink();

	}

	/**
	 * @toDo:access the vpp page
	 */
	@When("^I access the vpp page$")
	public void I_access_the_vpp_page(DataTable memberAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(memberAttributes);
		/*List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String zipcode = memberAttributesMap.get("Zip Code");
		AcquisitionHomePageMobile acqhomepage = (AcquisitionHomePageMobile) loginScenario
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPageMobile vppplansummarypage = acqhomepage.navigateToVpp(zipcode);
		if (vppplansummarypage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppplansummarypage);

		}
	}

	/**
	 * @toDo:click on add to compare checkbox and click on view details
	 */
	@And("^I click on add to compare checkbox and click on view details link$")
	public void I_click_on_compare_checkbox() {
		VPPPlanSummaryPageMobile vppplansummarypage = (VPPPlanSummaryPageMobile) loginScenario
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.clickonViewPlans();
		vppplansummarypage.clickCompareChkBox();
		PlanDetailsPageMobile plandetailspage = vppplansummarypage.clickViewDetails();
		if (plandetailspage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		}
	}

	/**
	 * @toDo:select pdp plans and go to view details page
	 */
	@And("^I select pdp plans and go to view details page$")
	public void I_select_pdp_plans_and_go_to_view_details_page() {
		VPPPlanSummaryPageMobile vppplansummarypage = (VPPPlanSummaryPageMobile) loginScenario
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.clickOnPDPPlans();
		PlanDetailsPageMobile plandetailspage = vppplansummarypage.clickViewDetailsPDP();
		if (plandetailspage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		}
	}

	/**
	 * @toDo:check compare box and verify right info is shown
	 */
	@Then("^I check compare box and verify right info is shown$")
	public void I_check_compare_box_and_verify() {
		PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile) loginScenario
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		if (plandetailspage.validateCompareBoxPDP()) {
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the compare checkbox message and/or link");
	}

	/**
	 * @toDo:user clicks on add to compare box and validates that info shows 2 plans
	 *            added
	 */
	@Then("^the user clicks on add to compare box and validates that info shows 2 plans added$")
	public void I_check_compare_box_and_verify_2_plans() {
		PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile) loginScenario
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		if (plandetailspage.validate2PlansAdded()) {
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the compare checkbox message and/or link");
	}

	/**
	 * @toDo:uncheck and recheck the compare box and verify the message and link
	 *               exists
	 */
	@Then("^I uncheck and recheck the compare box and verify the message and link exists$")
	public void verifyPlanDetailsPage() {
		PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile) loginScenario
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		if (plandetailspage.validateCompareBox()) {
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the compare checkbox message and/or link");
	}

	/**
	 * @toDo:uncheck and go back to the vpp page to validate
	 */
	@Then("^I uncheck and go back to the vpp page to validate$")
	public void uncheck_and_validate_vpp_page() {
		PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile) loginScenario
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		plandetailspage.clickCompareBox();
		VPPPlanSummaryPageMobile vppsummarypage = plandetailspage.navigateBackToPlanSummaryPage();
		if (vppsummarypage != null) {
			if (vppsummarypage.verifyCompareCheckBoxesAreUnchecked())
				Assertion.assertTrue(true);
			else
				Assertion.fail("Error in validating that the checkboxes are unchecked");
		} else
			Assertion.fail("Error in loading the vpp plan summary page");
	}

	/**
	 * @toDo:isAlertPresent
	 */
	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@Then("^the user selects plans to add to plan compare and navigates to Plan compare page in UHC site$")
	public void the_user_selects_plans_to_add_to_plan_compare_and_navigates_to_Plan_compare_page(
			DataTable planAttributes) throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String PlanName = givenAttributesMap.get("Plan Name");
		// String PlanName = (String)
		// getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_NAME);

		String PlanYear = "2018";
		String PlanPremium;
		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		String TFN;
		String SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		TFN = planSummaryPage.GetTFNforPlanType();
		PlanPremium = planSummaryPage.getPlanPremium(PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : " + PlanName);
		System.out.println("Plan Type is : " + PlanType);
		System.out.println("Plan Zip Code is : " + ZipCode);
		System.out.println("Plan County Name is : " + County);
		System.out.println("Plan Plan Premium is : " + PlanPremium);
		System.out.println("TFN for Plan Type is : " + TFN);
		System.out.println("Plan Year is : " + PlanYear);
		System.out.println("OLE is being started from Acquisition Site : " + SiteName);
		ComparePlansPageMobile comparePlansPage = planSummaryPage.selectplantocompare(PlanType, PlanName);

		if (comparePlansPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, comparePlansPage);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in Loading the Plan Compare Page");

	}

	/**
	 * @toDo:select all 3 plans to compare in MA and click on compare plan link
	 */
	@And("^I select all 3 plans to compare in MA and click on compare plan link in UHS site$")
	public void I_select_all_3_plans_to_compare() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickonViewPlans();
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.checkAllMAPlans();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageMobile comparePlansPageblayer = plansummaryPage.clickOnCompareLink();
		if (comparePlansPageblayer != null) {
			getLoginScenario().saveBean(PageConstants.TeamC_Plan_Compare_Page, comparePlansPageblayer);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	/**
	 * @toDo:user validate the print and email link option in plan compare
	 */
	@When("^the user validate the print and email link option in plan compare in UHS site$")
	public void user_validate_print_and_email_link_option_in_plan_compare() {

		ComparePlansPageBlayerMobile comparePlansPage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		comparePlansPage.validateprintandemail();
	}

	/**
	 * @toDo:the user validating email and print option in plan compare
	 */
	@Then("^the user validating email and print option in plan compare in UHS site$")
	public void user_validating_print_and_email_option_in_plan_compare() {

		ComparePlansPageBlayerMobile comparePlansPage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		comparePlansPage.validatingprintandemail();
	}

	/**
	 * @toDo:user validate thank you message in plan compare
	 */
	@When("^the user validate thank you message in plan compare in UHS site$")
	public void user_validate_thank_you_message_in_plan_compare() {

		ComparePlansPageBlayerMobile comparePlansPage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		comparePlansPage.validatingthankyoumessage();
	}

	/**
	 * @toDo:user clicks on back to all plans link and validate all three plans are
	 *            selected
	 */

	@Then("^the user clicks on back to all plans link and validates all three plans are selected$")
	public void the_user_clicks_on_back_to_plans_link_and_validates_plans_are_selected() {

		ComparePlansPageBlayerMobile comparePlansPage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		comparePlansPage.validatetopbacktoplanslink();
	}

	@Then("^the user validates the following Additional Benefits Plan details for the plan in UMS$")
	public void the_user_validates_the_following_Plan_details_for_the_plan(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String benefitType = memberAttributesMap.get("Benefit Type");
		String expectedText = memberAttributesMap.get("Expected Text");
		System.out.println("Validating the following Additional benefits : " + benefitType);

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(benefitType,
				expectedText);
		Assertion.assertTrue("Validation failed : Expected text not displayed for Additional Benefit - " + benefitType,
				validationFlag);
	}

	@Then("^the user validates the following Medical Benefits Plan details for the plan in UMS$")
	public void the_user_validates_the_following_Medical_benefits_Plan_details_for_the_plan(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String benefitType = memberAttributesMap.get("Benefit Type");
		String expectedText = memberAttributesMap.get("Expected Text");
		System.out.println("Validating the following Medical benefits : " + benefitType);

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.validatingMedicalBenefitTextInPlanDetails(benefitType,
				expectedText);
		Assertion.assertTrue("Validation failed : Expected text not displayed for Medical Benefit - " + benefitType,
				validationFlag);

	}

	/**
	 * @toDo:user validates plan count for all plan types on plan summary page
	 */
	@Then("^user validates plan count for all plan types on plan summary page in the UMS site$")
	public void user_validates_following_benefits_ui_ums() {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assertion.assertTrue("Error validating plans in  VPP plan summary page",
				plansummaryPage.validateVPPPlanSummaryPage());
		String SiteName = "UHG_ACQ";
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);

	}

	/**
	 * @toDo:user view plan details of the above selected plan
	 */
	@Then("^User clicks on Back to Plans link and navigate back to plan summary in UMS site$")
	public void User_clicks_BackToPlansLink_and_navigate_back_to_plan_summary_in_UMS_site() {

		PlanDetailsPageMobile planDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		VPPPlanSummaryPageMobile plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPage();
		if (plansummaryPage != null) {
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the Plan Summary Page");
	}

	/**
	 * @toDo:click on add to compare checkbox and click on view details
	 */
	@And("^User click on add to compare checkbox and click on view details link on UMS$")
	public void user_click_on_compare_checkbox_ums() {
		VPPPlanSummaryPageMobile vppplansummarypage = (VPPPlanSummaryPageMobile) loginScenario
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.clickCompareChkBox();
		PlanDetailsPageMobile plandetailspage = vppplansummarypage.clickViewDetails_AddedToCompare();
		if (plandetailspage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
			plandetailspage.clickCompareBox();
		}
	}

	// Steps added to validate Cancel button on Multi County pop-up on Home,
	// SubNav and VPP plan search
	@When("^the user performs plan search using following MultiCounty Zip information in the UHC site$")
	public void the_user_performs_plan_search_using_following_MultiCounty_Zip_information_in_the_UHC_site(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstantsMobile.ZIPCODE, zipcode);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MultiCountyModalPageMobile multiCountyModalPage = aquisitionhomepage.ValidateMultiCOuntyPopUp(zipcode);

		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, multiCountyModalPage);
		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}

	}

	@Then("^the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page in UHC$")
	public void the_user_validates_the_Cancel_button_for_Multi_COunty_Pop_up_lands_on_enter_Zip_code_Page()
			throws Throwable {
		MultiCountyModalPageMobile multiCountyModalPage = (MultiCountyModalPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean Validation_Flag = multiCountyModalPage.validateMultiCounty_CancelButton();
		Assertion.assertTrue("Validation failed : Cancel button Validation for Multi County Pop-up Failed ",
				Validation_Flag);

	}

	@When("^the user performs plan search using following MultiCounty Zip in Header Sub Nav in the UHC site$")
	public void the_user_performs_plan_search_using_following_MultiCounty_Zip_in_Header_Sub_Nav_in_the_UHC_site(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstantsMobile.ZIPCODE, zipcode);

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MultiCountyModalPageMobile multiCountyModalPage = aquisitionhomepage.SubNav_ValidateMultiCOuntyPopUp(zipcode);

		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, multiCountyModalPage);
		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@When("^the user performs Change Location on Plan Summary Page using following MultiCounty Zip information in the UHC site$")
	public void the_user_performs_Change_Location_on_Plan_Summary_Page_using_following_MultiCounty_Zip_information_in_the_UHC_site(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstantsMobile.ZIPCODE, zipcode);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		MultiCountyModalPageMobile multiCountyModalPage = plansummaryPage
				.VPP_ChangeLocationValidateMultiCOuntyPopUp(zipcode);
		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, multiCountyModalPage);
		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@Then("^the user validates the VPP Promo right rail widjet$")
	public void user_validates_the_VPP_promo_widjet(DataTable givenAttributes) {

		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planName = memberAttributesRow.get(0).getCells().get(1);*/
		String planName = givenAttributes.cell(0, 1);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		// String planType = (String)
		// getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		VPPPlanSummaryPageMobile vppPlanDetailsPage = vppPlanSummaryPage.validatePromoWidjetAArp(planName);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		} else
			Assertion.fail("Error in validating the Plan Details Page");
	}

	/**
	 * @toDo:select all 3 plans to compare and click on compare plan link
	 */
	@And("^I select all 3 plans to compare and click on compare plan link in UHC$")
	public void I_select_all_3_plans_to_compare_UHC() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.checkAllMAPlans();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageMobile planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@Given("^I select \"([^\"]*)\" plans to compare and click on compare plan link in UHC$")
	public void i_select_plans_to_compare_and_click_on_compare_plan_link_in_UHC(String planType) throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if (planType.equals("MAPD")) {
			// plansummaryPage.clickonViewPlans();
			plansummaryPage.checkAllMAPlans();
			System.out.println("Selected All MAPD plans for Plan Compare");
		} else if (planType.equals("PDP")) {
			// plansummaryPage.clickOnPDPPlans();
			plansummaryPage.clickCompareChkBoxPDP();
			System.out.println("Selected All PDP plans for Plan Compare");
		}

		ComparePlansPageMobile planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@And("^I Click on DCE link on Plan compare$")
	public void I_Click_On_DCE_link_on_Plan_Compare() {
		ComparePlansPageBlayerMobile planComparePage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pages.mobile.acquisition.commonpages.DrugCostEstimatorPageMobile drugCostEstimatorPage = planComparePage.clickonDCE();
		if (drugCostEstimatorPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, drugCostEstimatorPage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@And("^I Click on Look up your doctor link on Plan compare$")
	public void I_Click_on_Look_up_your_doctor_link_on_Plan_compare() throws InterruptedException {
		ComparePlansPageBlayerMobile planComparePage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FindCarePageMobile findCarePage = planComparePage.clickonLookUpYourDoctor();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@And("^I click on Get Started on and Add Provider from find care page$")
	public void I_click_on_Get_Started_and_Add_Provider_from_find_care_page() throws Exception {
		FindCarePageMobile findCarePage = (FindCarePageMobile) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageMobile planComparePage = findCarePage.getstarted();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@Then("^Verify provider is count is updated on plan compare page$")
	public void Verify_provider_is_count_is_updated_on_plan_compare_page() throws Exception {
		ComparePlansPageBlayerMobile planComparePage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		planComparePage.verifyProvidercount();
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
	}

	/**
	 * @toDo:the user is on UHC medicare acquisition site VPP Plan Summary page
	 *           after hits Campaign URL
	 */
	@Given("^the user is on UHC medicare acquisition site VPP Plan Summary page after hits Campaign URL$")
	public void the_user_on_aarpmedicareplans_Campaign_landing_page() throws Throwable {

		String County = "St. Louis County";
		String ZipCode = "63043";
		String PlanYear = "2020";
		String SiteName = "UHC_ACQ";

		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);

		String OLE_Campaign_URL = "https://stage-uhcmedicaresolutions.uhc.com/health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731#/plan-summary <>";

		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		VPPPlanSummaryPageMobile vppPlanSummaryPage = new VPPPlanSummaryPageMobile(wd, OLE_Campaign_URL, true);
		if (vppPlanSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppPlanSummaryPage);
			System.out.println("OLE Campaign Landing Page Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Campaign Landing");
	}

	@Given("^the user is on UHC medicare acquisition site VPP page after hits Campaign URL$")
	public void the_user_on_aarpmedicareplans_VPPPlanSummaryPage_Campaign_landing_page() throws Throwable {

		String County = "St. Louis County";
		String ZipCode = "63043";
		String PlanYear = "2020";
		String SiteName = "UHC_ACQ";

		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);

		String OLE_Campaign_URL = "https://www.team-acme-uhcmedicaresolutions.ocp-elr-core-nonprod.optum.com/health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731#/plan-summary <>";

		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		VPPPlanSummaryPageMobile vppPlanSummaryPage = new VPPPlanSummaryPageMobile(wd, OLE_Campaign_URL, true);
		if (vppPlanSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppPlanSummaryPage);
			System.out.println("OLE Campaign Landing Page Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Campaign Landing");

	}

	@Then("^the user validates the following Medical Benefits for the plan in Plan Compare Page on UHC$")
	public void the_user_validates_the_following_Medical_benefits_for_the_plan_in_Plan_Compare_Page(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String benefitType = memberAttributesMap.get("Benefit Type");
		String expectedText = memberAttributesMap.get("Expected Text");
		String PlanName = memberAttributesMap.get("Plan Name");
		System.out.println("Validating the following Medical benefits on Plan Compare Page : " + benefitType);

		PlanComparePageMobile comparePlansPage = (PlanComparePageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		boolean validationFlag = comparePlansPage.validatingMedicalBenefitTextInPlanDetails(benefitType, expectedText,
				PlanName);
		Assertion.assertTrue("Validation failed : Expected text not displayed for Medical Benefit - " + benefitType,
				validationFlag);

	}

	// vvv note: added for US1598162
	public Map<String, String> prepareTestInput(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		return memberAttributesMap;
	}

	@Then("^user validates selected plans can be saved as favorite on UHC site$")
	public void user_validates_selected_plan_can_be_saved_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = memberAttributesMap.get("Plan Year");
		getLoginScenario().saveBean(VPPCommonConstantsMobile.PLAN_YEAR, planYear);

		// ----- MA plan type ----------------------------
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateAbilityToSavePlans(ma_savePlanNames, planType);

		// ----- PDP plan type ---------------------------
		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateAbilityToSavePlans(pdp_savePlanNames, planType);

		// ----- SNp plan type ---------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateAbilityToSavePlans(snp_savePlanNames, planType);
	}

	@Then("^user saves two plans as favorite on UHC site$")
	public void user_saves_two_plans_as_favorite_on_UHC_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String savePlanNames = memberAttributesMap.get("Test Plans");

		// ----- MA plan type ----------------------------
		String planType = memberAttributesMap.get("Plan Type");
		switch (planType) {
		case "MAPD":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.savePlans(savePlanNames, planType);
			break;
		case "MA":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.savePlans(savePlanNames, planType);
			break;
		case "SNP":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.savePlans(savePlanNames, planType);
			break;
		case "PDP":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.savePlans(savePlanNames, planType);
			break;

		default:
			break;
		}
	}

	@Then("^user saves two MS plans as favorite on UHC site$")
	public void user_saves_two_MS_plans_as_favorite_on_UHC_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ms_savePlanNames = memberAttributesMap.get("MS Test Plans");

		// ----- MS plan type ----------------------------
		plansummaryPage.saveMSPlans(ms_savePlanNames);
	}

	@Then("^user gets a create profile prompt on UHC site$")
	public void user_saves_two_plans_as_favorite_on_UHC_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.validateCreateProfilePrompt();

		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

	}

	@And("^user click on continue as guest button on UHC site$")
	public void user_click_on_continue_as_guest_button_on_UHC_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		VisitorProfilePageMobile visitorProfilePage = plansummaryPage.continueAsGuest();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);

	}

	@And("^user validate pdf link on UHC Site$")
	public void user_validate_pdf_link_on_AARP_Site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		/*List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String savePlanNames = givenAttributesMap.get("MS Test Plans");
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedPlansPDFLinks(savePlanNames);
	}

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change from Home on UHC site$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Home_on_AARP_site(
			DataTable givenAttributes) throws InterruptedException {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_YEAR);

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		System.out.println("Proceed to click Home button to enter zip code again");
		plansummaryPage.clickHomeButton();

		System.out.println("First go to a totally different zipcode = 90210");
		plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty("90210");

		System.out.println("Then go back to the test zipcode");
		plansummaryPage.clickHomeButton();
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty(zipcode);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			// System.out.println("TEST - loaded plansummary page for
			// zipcode='"+zipcode+"'");
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType);
	}

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change from Shop For a Plan on UHC site$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Shop_For_a_Plan_on_AARP_site(
			DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_YEAR);

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode("80001", "Jefferson County", "NO");

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
		plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode(zipcode, county, isMultiCounty);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			// System.out.println("TEST - loaded plansummary page for
			// zipcode='"+zipcode+"'");
		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType);
	}

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change within VPP page on UHC site$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_within_VPP_page_on_AARP_site(
			DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_YEAR);

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode("80001", "Jefferson County",
				"NO");

		if (plansummaryPage != null) {
			System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
			plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode(zipcode, county, isMultiCounty);
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType);
	}

	@Then("^user validates ability to unsave a saved plan on UHC site$")
	public void user_validates_ability_to_unsave_a_saved_plan_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ma_plans = memberAttributesMap.get("MA Test Plans");
		String pdp_plans = memberAttributesMap.get("PDP Test Plans");
		String snp_plans = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_YEAR);

		// note: the second plan in the list will be unsaved
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		System.out.println("Proceed to unsave the " + planType + " second plan from the input");
		plansummaryPage.validateAbilityToUnSavePlans(ma_plans, planType);

		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		System.out.println("Proceed to unsave the " + planType + " second plan from the input");
		plansummaryPage.validateAbilityToUnSavePlans(pdp_plans, planType);

		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		System.out.println("Proceed to unsave the " + planType + " second plan from the input");
		plansummaryPage.validateAbilityToUnSavePlans(snp_plans, planType);
	}

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change from Home on UHC site$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Home_on_AARP_site(
			DataTable givenAttributes) throws InterruptedException {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_YEAR);

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		System.out.println("Proceed to click Home button to enter zip code again");
		plansummaryPage.clickHomeButton();

		System.out.println("First go to a totally different zipcode = 90210");
		plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty("90210");

		System.out.println("Then go back to the test zipcode");
		plansummaryPage.clickHomeButton();
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty(zipcode);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			// System.out.println("TEST - loaded plansummary page for
			// zipcode='"+zipcode+"'");
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " unsaved plan(s) are still unsaved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " unsaved plan(s) are still unsaved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " unsaved plan(s) are still unsaved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(snp_savePlanNames, planType);
	}

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change from Shop For a Plan on UHC site$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Shop_For_a_Plan_on_AARP_site(
			DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_YEAR);
		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode("80001", "Jefferson County", "NO");

		if (plansummaryPage != null) {
			System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
			plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode(zipcode, county, isMultiCounty);
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(snp_savePlanNames, planType);
	}

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change within VPP page on UHC site$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_within_VPP_page_on_AARP_site(
			DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_YEAR);
		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode("80001", "Jefferson County",
				"NO");

		if (plansummaryPage != null) {
			System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
			plansummaryPage = plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode(zipcode, county,
					isMultiCounty);
			if (plansummaryPage == null) {
				Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
			}
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(snp_savePlanNames, planType);
	}

	@Then("^user validates email option on UHC site$")
	public void user_validates_email_option_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// ----- MA plan type -----------------------------
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOptionExistOnPage(planType);
		// ----- PDP plan type ----------------------------
		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOptionExistOnPage(planType);
		// ----- SNP plan type ----------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOptionExistOnPage(planType);
	}

	@Then("^user validates print option on UHC site$")
	public void user_validates_print_option_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// ----- MA plan type -----------------------------
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOptionExistOnPage(planType);
		// ----- PDP plan type ----------------------------
		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOptionExistOnPage(planType);
		// ----- SNP plan type ----------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOptionExistOnPage(planType);
	}

	@Then("^user validates email functionality with invalid and valid email address on UHC site$")
	public void user_validates_email_functionality_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// ----- MA plan type -----------------------------
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOption(planType);
		// ----- PDP plan type ----------------------------
		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOption(planType);
		// ----- SNP plan type ----------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOption(planType);
	}

	@Then("^user validates print functionality on UHC site$")
	public void user_validates_print_functionality_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// ----- MA plan type -----------------------------
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOption(planType);
		// ----- PDP plan type ----------------------------
		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOption(planType);
		// ----- SNP plan type ----------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOption(planType);
	}

	@Then("^user closes the original tab and open new tab for UHC site$")
	public void user_closes_the_original_tab_and_open_new_tab_for_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.closeOriginalTabAndOpenNewTab();
	}

	@Then("^user validates plans remain saved within same session for UHC site$")
	public void user_validates_plans_remain_saved_within_same_session(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType);
	}
	// ^^^ note: added for US1598162

	@Then("^the UHC user clicks on Start Application Button proceed to next pages for getting resume application key")
	public void Start_application_button(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String DateOfBirth = memberAttributesMap.get("DOB");
		String FirstName = memberAttributesMap.get("Firstname");
		String LastName = memberAttributesMap.get("Lastname");
		String zipcode = memberAttributesMap.get("Zipcode");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation(DateOfBirth);
		String resumeKey = plansummaryPage.StartApplicationButton(FirstName, LastName);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.RESUMEKEY, resumeKey);

	}

	@Then("^the user clicks on resume application button")
	public void click_resume_application() throws Throwable {

		System.out.println("***the user clicks on resume application button***");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.ResumeApplicationButton();

	}

	@Then("^the user navigates to next page to locate resume application button")
	public void click_resume_application(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String DateOfBirth = memberAttributesMap.get("DOB");
		String zipcode = memberAttributesMap.get("Zipcode");
		System.out.println("***the user clicks on resume application button***");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation_2ndTime(DateOfBirth, zipcode);
		plansummaryPage.ResumeApplicationButton();

	}

	@And("^the user signs in with optum Id credentials to resume application in UHC site$")
	public void the_user_signs_in_with_optum_Id_credentials_resume_application_in_AARP_site(DataTable credentials) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		/*List<DataTableRow> plannameAttributesRow = credentials.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String username = plannameAttributesMap.get("User Name");
		String password = plannameAttributesMap.get("Password");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// plansummaryPage.signIn(username, password);
	}

	@Then("^the user will navigate to locate resume application button")
	public void click_resume_application_3(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String DateOfBirth = memberAttributesMap.get("DOB");
		String zipcode = memberAttributesMap.get("Zipcode");
		System.out.println("***the user clicks on resume application button***");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation(DateOfBirth);
		plansummaryPage.ResumeApplicationButton();

	}

	@Then("^the user will proceed to next pages")
	public void the_user_will_proceed_to_next_pages(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String DateOfBirth = memberAttributesMap.get("DOB");
		String zipcode = memberAttributesMap.get("Zip Code");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation(DateOfBirth);

	}

	@Then("^the user enters data to resume the application")
	public void enters_data_to_resume_application(DataTable givenAttributes) throws Throwable {
		System.out.println("***the user enters data to resume the application***");
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String applicationType = memberAttributesMap.get("applicationType");
		String DOB = memberAttributesMap.get("DOB");
		String zipcode = memberAttributesMap.get("Zipcode");

		String ApplicationID = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.RESUMEKEY);

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		/*
		 * if (applicationType.equalsIgnoreCase("Retrieve")) { ApplicationID =
		 * memberAttributesMap.get("ApplicationID"); }
		 */
		plansummaryPage.EnterDataForResumeApp(ApplicationID, DOB, zipcode);

	}

	@Then("^The user validates the resume application processed")
	public void resume_application_processed(DataTable givenAttributes) throws Throwable {
		System.out.println("***The user validates the resume application processed***");
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String FirstName = memberAttributesMap.get("Firstname");
		String LastName = memberAttributesMap.get("Lastname");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.ResumeApplicationButtonValidation(FirstName, LastName);

	}

	@Then("^The user validates the Retrive application")
	public void retrive_application_processed(DataTable givenAttributes) throws Throwable {
		System.out.println("***The user validates the Retrive application***");
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String ApplicationID = memberAttributesMap.get("ApplicationID");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.RetrieveApplicationButtonValidation(ApplicationID);

	}

	@And("^I Click on DCE link on Plan compare for UHC$")
	public void I_Click_On_DCE_link_on_Plan_Compare_for_UHC() {
		ComparePlansPageBlayerMobile planComparePage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pages.mobile.acquisition.commonpages.DrugCostEstimatorPageMobile drugCostEstimatorPage = planComparePage.clickonDCE();
		if (drugCostEstimatorPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, drugCostEstimatorPage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@Then("^the user validate the print and email links on the plan Details Page on uhc site")
	public void user_validate_print_and_email_links_on_the_plan_Details_Page() {

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatePrintandEmailOnPlanDetails();
	}

	/**
	 * @toDo:the user validates the functionality of email and print buttons on the
	 *           plan Details Page
	 */
	@Then("^the user validates the functionality of email and print buttons on the plan Details Page on uhc site$")
	public void user_validates_the_functionality_of_emailandprintbuttons_on_the_plan_Details_Page() {

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatingFunctionalityOfPrintandEmailOnPlanDetails();

	}

	@Then("^the user Click on Look up your Provider button in UMS site$")
	public void user_Clicks_on_Look_upyourProvider_button_on_PlanDetailsPage() {

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		ProviderSearchPageMobile providerSearchPage = vppPlanDetailsPage.validateLookUpYourProviderButton();
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}
	}

	@Then("^user validates Drug information is reflected on plan compare page in UHC$")
	public void user_validates_Drug_information_is_reflected_on_plan_compare_page_in_UHC() throws Exception {
		ComparePlansPageBlayerMobile planComparePage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		planComparePage.verifyDCEAmount();
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
	}

	@When("^the user performs plan search using Standalone Zipcode information in the UHC site$")
	public void the_user_performs_plan_search_using_Standalone_Zipcode_information_in_the_UHC_site(
			DataTable givenAttributes) throws Throwable {
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
		getLoginScenario().saveBean(VPPCommonConstantsMobile.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.IS_MULTICOUNTY, isMultiCounty);

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		String PlanType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		String PlanName = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME);

		WelcomePageMobile welcomePage;
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			welcomePage = aquisitionhomepage.ZipcodeSearchToOLEWithOutCounty(zipcode, PlanName);
		} else {
			welcomePage = aquisitionhomepage.ZipcodeSearchToOLEWithCounty(zipcode, county, PlanName);
		}
		Thread.sleep(7000);
		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
		} else {
			Assertion.fail("Error Loading OLE Welcome page");
		}
	}

	@When("^verify Call SAM icon is visible or not on Plan Comapare on UHC site$")
	public void verify_Call_SAM_icon_is_visible_or_not_PlanCompare_UHC_Site() throws InterruptedException {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallSam();
	}

	@And("^verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare on UHC site$")
	public void verify_Call_SAM_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent_PlanCompare_UHC()
			throws InterruptedException {

		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallSamContent();

	}

	@Then("^user verify the popup and content on Plan Comapare on UHC site$")
	public void user_verify_the_popup_and_content_PlanCompare_UHC() throws InterruptedException {

		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallpopup();
	}

	@When("^verify Chat SAM icon is visible or not on Plan Comapare on UHC site$")
	public void verify_Chat_SAM_icon_is_visible_or_not_PlanCompare_UHC() throws InterruptedException {

		ComparePlansPageBlayerMobile planComparePage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		ComparePlansPageBlayerMobile ChatIcon = planComparePage.validateChatSam();
		if (ChatIcon != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, ChatIcon);
			Assertion.assertTrue(true);
			System.out.println("TFN Widget is Displayed");
		} else {
			Assertion.fail("TFN Widget is NOT Displayed");
		}
	}

	@And("^verify Chat SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare on UHC site$")
	public void verify_Chat_SAM_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent_PlanCompare_UHC()
			throws InterruptedException {

		ComparePlansPageBlayerMobile planComparePage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateChatSamContent();

	}

	@Then("^user verify the Chat original state on UHC site$")
	public void user_verify_the_Chat_original_state_PlanCompare_UHC() throws InterruptedException {

		ComparePlansPageBlayerMobile planComparePage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateChatSam();
	}

	@Then("^the user validates the following Additional Benefits of Plan for the plan in UMS$")
	public void the_user_validates_the_following_Additional_Benefits_of_Plan_for_the_plan_in_UMS(
			DataTable givenAttributes) throws Throwable {
//		List<DataTableRow> additionalBenefits = givenAttributes.getGherkinRows();
		List<List<String>> additionalBenefits = givenAttributes.asLists();
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(additionalBenefits);
	}

	@Then("^the user validates the following Medical Benefits of Plan for the plan in UMS$")
	public void the_user_validates_the_following_Medical_Benefits_of_Plan_for_the_plan_in_UMS(DataTable givenAttributes)
			throws Throwable {
//		List<DataTableRow> medicalBenefits = givenAttributes.getGherkinRows();
		List<List<String>> medicalBenefits = givenAttributes.asLists();
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatingMedicalBenefitTextInPlanDetails(medicalBenefits);
		// Assertion.assertTrue("Validation failed : Expected text not displayed
		// for Additional Benefit - "+benefitType,validationFlag);
	}

	@Then("^the user click on Plan costs tab and validates$")
	public void the_user_click_on_Plan_costs_tab_and_validates(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String yearlyPremium = memberAttributesMap.get("Yearly Premium");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.clickAndValidatePlanCosts(monthlyPremium, yearlyPremium);
		Assertion.assertTrue("Validation failed : Expected text not displayed for monthly and yearly premium - "
				+ monthlyPremium + " " + yearlyPremium, validationFlag);
	}

	@Then("^the user click on Prescription Drug Benefits and validates in UHC site$")
	public void the_user_click_on_Prescription_Drug_Benefits_and_validates_in_UHC_site() throws Throwable {
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.clickAndValidatePrescriptionDrugBenefits();
	}

	@Then("^the user click on Optional Services tab and add the rider$")
	public void the_user_click_on_Optional_Services_tab_and_add_the_rider(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String optionalRider = memberAttributesMap.get("Optional Rider");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		String optionalRiderPremium = vppPlanDetailsPage.addOptionalRider(optionalRider);
	}

	@Then("^the user click on Plan costs tab and validate riders monthly and yearly premium$")
	public void the_user_click_on_Plan_costs_tab_and_validate_riders_monthly_and_yearly_premium(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String yearlyPremium = memberAttributesMap.get("Yearly Premium");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		boolean validationFlag = vppPlanDetailsPage.clickAndValidateOptionalRiderPremiums(monthlyPremium,
				yearlyPremium);
		Assertion.assertTrue("Validation failed : Expected text not displayed for riders monthly and yearly premium - "
				+ monthlyPremium + " " + yearlyPremium, validationFlag);
	}

	@When("^the user checks for AEP CUrrent year plans link and clicks to view current year plans on UHC$")
	public void the_user_views_currentyearlink_clicksLink() throws Throwable {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.CheckClick_CurrentYear_Plans();
	}

	@Then("^verify plan compare page is loaded on UHC$")
	public void verify_plan_compare_page_is_loaded_on_UHC() throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatePlanComparePage();
	}

	@Then("^click on back to plans on plan compare page for UHC$")
	public void click_on_back_to_plans_on_plan_compare_page_for_UHC() throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnBacktoPlans();
	}

	@Then("^Verify the Plan compare checkbox should be unchecked for the removed plan for UHC$")
	public void verify_the_Plan_compare_checkbox_should_be_unchecked_for_the_removed_plan_for_UHC() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyPlanComapreCheckboxIsUnchecked();
	}

	@Given("^I select \"([^\"]*)\" plans and \"([^\"]*)\" plans to compare and click on compare plan link in UHC$")
	public void i_select_plans_and_plans_to_compare_and_click_on_compare_plan_link_in_UHC(String planType,
			String Counter) throws Throwable {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		int counter = Integer.parseInt(Counter);
		if (planType.equals("MAPD")) {
			// plansummaryPage.clickonViewPlans();
			plansummaryPage.checkMAPlansOnly(counter);
			System.out.println("Selected All MAPD plans for Plan Compare");
		}

		ComparePlansPageMobile planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// planComparePage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@Then("^check one plan and add it to plancompare for UHC$")
	public void check_one_plan_and_add_it_to_plancompare_for_UHC() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickon3rdPlan();
		ComparePlansPageMobile planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// planComparePage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@Then("^user select and unselect one plan for plan compare and verify second plan checkbox autoselected and click on plan compare$")
	public void user_select_and_unselect_one_plan_for_plan_compare() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.checkOneCheckboxVerifyAutoSelection("true");
		plansummaryPage.checkOneCheckboxVerifyAutoSelection("false");

	}

	@Then("^verify plan compare checkbox is not visible on plan summary on UHC$")
	public void verify_plan_compare_checkbox_is_not_visible_on_plan_summary_on_UHC() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean validationFlag = plansummaryPage.verifyPlanCompareCheckboxNotVisible();
		Assertion.assertFalse("Validation failed : UnExpected Plan Compare check is Visible - ", validationFlag);

	}

	@Then("^the user clicks on Enroll in plan for UHC site and validates the Welcome to OLE Page on new Plan Compare")
	public void user_clicks_enrollInPlan_newPlanCompare_UHC() throws InterruptedException {
		ComparePlansPageBlayerMobile planComparePage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		WelcomePageMobile welcomeOLEPage = planComparePage.Enroll_OLE_newPlancompare_UHC();
		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assertion.fail("Error Loading Welcome Page for OLE");
		}
	}

	@Then("^the user clicks on Plan details link in new Plan Compare page on UHC")
	public void user_clicks_planDetails_newPlanCompare_UHC() throws InterruptedException {
		ComparePlansPageBlayerMobile planComparePage = (ComparePlansPageBlayerMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		ComparePlansPageBlayerMobile vppPlanDetailsPage = planComparePage.navigateToPlanDetailfromplanCompare();
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in Loading the Plan Details Page");

	}

	@When("^verify Call sticky action menu icon is visible or not$")
	public void verify_Call_sticky_action_menu_icon_is_visible_or_not() throws InterruptedException {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSam();
		/*
		 * if (Aquisitionhomepage != null) {
		 * getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
		 * Aquisitionhomepage); Assertion.assertTrue(true);
		 * System.out.println("TFN Widget is Displayed"); } else{
		 * Assertion.fail("TFN Widget is NOT Displayed"); }
		 */
	}

	@And("^verify Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent$")
	public void verify_Call_sticky_action_menu_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent()
			throws InterruptedException {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSamContent();
	}

	@Then("^user verify the popup and content in popup$")
	public void user_verify_the_popup_and_content_in_popup() throws InterruptedException {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallpopup();

	}

	@When("^verify Chat sticky action menu icon is visible or not$")
	public void verify_Chat_sticky_action_menu_icon_is_visible_or_not() throws InterruptedException {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSam();
		/*
		 * if (Aquisitionhomepage != null) {
		 * getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
		 * Aquisitionhomepage); Assertion.assertTrue(true);
		 * System.out.println("TFN Widget is Displayed"); } else{
		 * Assertion.fail("TFN Widget is NOT Displayed"); }
		 */
	}

	@And("^verify Chat sticky action menu roll out and contain the text Call a Licensed Insurance Agent$")
	public void verify_Chat_sticky_action_menu_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent()
			throws InterruptedException {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSamContent();

	}

	@Then("^user verify the Chat at its original state$")
	public void user_verify_the_Chat_at_its_original_state() throws InterruptedException {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSam();
	}

	@When("^the user clicks on Lookup zipcode on UHC$")
	public void the_user_clicks_on_Lookup_zipcode_on_UHC() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ZipcodeLookupHomePageMobile zipcodeLookuphomePage = aquisitionhomepage.looksupforZipcodes();
		getLoginScenario().saveBean(PageConstants.ZIP_LOOK_UP_HOME_PAGE, zipcodeLookuphomePage);
	}

	@Then("^verify find a zipcode popup displpayed and Enter values and click on LookupZipcode on uhc$")
	public void verify_find_a_zipcode_popup_displpayed_and_Enter_values_and_click_on_LookupZipcode_on_uhc(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String address = memberAttributesMap.get("Address");
		String city = memberAttributesMap.get("City");
		String state = memberAttributesMap.get("State");

		ZipcodeLookupHomePageMobile zipcodeLookuphomePage = (ZipcodeLookupHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ZIP_LOOK_UP_HOME_PAGE);
		zipcodeLookuphomePage.enterAddressDetails(address, city, state);
	}

	@When("^the user performs plan search using following information in the uhc site$")
	public void lookUpzipcode_details_in_UMS_site(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstantsMobile.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.IS_MULTICOUNTY, isMultiCounty);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = null;
		if (isMultiCounty.contains("YES")) {
			plansummaryPage = aquisitionhomepage.searchPlansCounty(county);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlansNoCounty();
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			if (plansummaryPage.validateVPPPlanSummaryPage())
				Assertion.assertTrue(true);
			else
				Assertion.fail("Error in validating the Plan Summary Page");

		}

	}

	@Then("^user clicks on Change Zip code link in UMS site$")
	public void user_clicks_on_Change_Zip_code_link_in_UMS_site() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickOnChangeZipCode();
	}

	@Then("^user clicks on Select by Address and Enter fileds in UMS Site$")
	public void user_clicks_on_Select_by_Address_and_Enter_fileds_in_UMS_Site(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String address = memberAttributesMap.get("Address");
		String city = memberAttributesMap.get("City");
		String state = memberAttributesMap.get("State");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.enterAddressDetails(address, city, state);
	}

	@When("^the user clicks on Find plans on vpp using following information in the UMS site$")
	public void the_user_clicks_on_Find_plans_on_vpp_using_following_information_in_the_UMS_site(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String county2 = memberAttributesMap.get("County Name2");
		String isMultiCounty2 = memberAttributesMap.get("Is Multi County2");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.searchPlansCounty(county2, isMultiCounty2);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			if (plansummaryPage.validateVPPPlanSummaryPage())
				Assertion.assertTrue(true);
			else
				Assertion.fail("Error in validating the Plan Summary Page");

		}
	}

	/** user is on the Medicare Site landing page for VPP Testharness */
	@Given("^the user is on VPP TestHarness page$")
	public void validateUserIsOnUMS_VPPTestharnessPage(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		String TestharnessPage = inputAttributesMap.get("TestHarnessPage");
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd, siteName, TestharnessPage);
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) aquisitionhomepage
				.GetVPPTestHarnessPage();
		getLoginScenario().saveBean(PageConstants.VPP_TESTHARNESS_PAGE, vppTestHarnessPage);
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(memberAttributes);
		/*List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		return memberAttributesMap;
	}

	@When("^the user enters following information in the UMS Acquisition Site VPPZipcode TestHarness page$")
	public void the_user_enters_following_information_in_the_UMS_Site_VPPZipcode_TestHarness_page(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterVppZipcode(ZipCode);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCounty(CountyName);
		}
		VPPPlanSummaryPageMobile plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}

	}

	@When("^the user clicks on Lookup zipcode and enters following information in the UHC Acquisition Site VPPZipcode TestHarness page$")
	public void the_user_clicks_on_Lookup_zipcode_and_enters_following_information_in_the_UHC_Site_VPPZipcode_TestHarness_page(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String Address = inputAttributesMap.get("Address");
		String City = inputAttributesMap.get("City");
		String State = inputAttributesMap.get("State");

		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterAddressDetails(Address, City, State);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCounty(CountyName);
		}
		VPPPlanSummaryPageMobile planSummaryPage = vppTestHarnessPage.navigateToVPP();
		if (planSummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, planSummaryPage);
		}
	}

	@When("^the user click on Go botton without entering Zipcode and enters zipcode from shop for a plan on the UHC Acquisition Site VPPZipcode TestHarness page$")
	public void user_enters_zipcodefromshopforaplan_on_the_UHC_AcquisitionSiteVPPZipcodeTestHarnesspage(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");

		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		VPPPlanSummaryPageMobile planSummaryPage = vppTestHarnessPage.navigateToShopPlanenterZipcodeToVPP(ZipCode,
				CountyName, isMultutiCounty);
		if (planSummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, planSummaryPage);
		}
	}

	@When("^the user enters zipcode on plan summary deep link and clik on deeplink navigates to VPP plan summary for UHC$")
	public void user_enters_zipcode_on_plan_summary_deep_link_and_clik_on_deeplink_navigates_to_VPP_plan_summary_for_UHC(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterZipcodeforPlanSummaryDeepLink(ZipCode);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCounty(CountyName);
		}
		VPPPlanSummaryPageMobile plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}
	}

	@When("^the user enters Mandatory fields on Connector Model and clik on deeplink navigates to VPP plan summary for UHC$")
	public void user_enters_Mandatory_fields_on_Connector_Model_and_clik_on_deeplink_navigates_to_VPP_plan_summary_for_UHC(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String CountyCode = inputAttributesMap.get("CountyCode");
		String StateCode = inputAttributesMap.get("StateCode");
		String WTMCID = inputAttributesMap.get("WTMCID");
		String OrgSite = inputAttributesMap.get("OrgSite");
		String Subdomain = inputAttributesMap.get("Subdomain");

		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterMandatoryforConnectorModelDeepLink(ZipCode, StateCode, CountyCode, OrgSite, WTMCID,
				Subdomain);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCounty(CountyName);
		}
		VPPPlanSummaryPageMobile plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}
	}

	@When("^the user enters Mandatory fields on plan summary email deeplink and clik on deeplink navigates to VPP plan summary for UHC$")
	public void user_enters_Mandatory_fields_on_plan_summary_email_deeplink_and_clik_on_deeplink_navigates_to_VPP_plan_summary_for_UHC(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String Deeplink = inputAttributesMap.get("Deeplink");
		String PlanType = inputAttributesMap.get("Plan Type");
		String PlanYear = inputAttributesMap.get("Year");

		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterEmailPlanSummaryDeepLink(ZipCode, Deeplink, PlanType, PlanYear);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCounty(CountyName);
		}
		VPPPlanSummaryPageMobile plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}
	}

	@When("^the user enters Mandatory fields on plan compare deeplink and clik on deeplink navigates to VPP plan Compare for UHC$")
	public void user_enters_Mandatory_fields_on_plan_compare_email_deeplink_and_clik_on_deeplink_navigates_to_VPP_plan_Compare_for_UHC(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String ExpiryDate = inputAttributesMap.get("Expiry Date");
		String ContractPBP = inputAttributesMap.get("ContractPBP");
		String PlanYear = inputAttributesMap.get("Plan Year");
		String PlanType = inputAttributesMap.get("Plan Type");
		String fisCountyCode = inputAttributesMap.get("fisCountyCode");

		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterEmailPlanCompareDeepLink(ZipCode, ContractPBP, ExpiryDate, PlanType, PlanYear,
				fisCountyCode);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCounty(CountyName);
		}
		ComparePlansPageMobile planComparePage = vppTestHarnessPage.navigateToPlanCompare();
		if (planComparePage != null) {
			loginScenario.saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		}
	}

	@When("^the user enters Mandatory fields on plan details deeplink and clik on deeplink navigates to VPP plan details for UHC$")
	public void user_enters_Mandatory_fields_on_plan_details_email_deeplink_and_clik_on_deeplink_navigates_to_VPP_plan_details_for_UHC(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String Deeplink = inputAttributesMap.get("Deeplink");
		String ContractPBP = inputAttributesMap.get("ContractPBP");
		String PlanYear = inputAttributesMap.get("Plan Year");
		String fisCountyCode = inputAttributesMap.get("fisCountyCode");
		String plantype = inputAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(VPPCommonConstantsMobile.PLAN_TYPE, plantype);
		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterEmailPlanDetailsDeepLink(ZipCode, ContractPBP, PlanYear, Deeplink, fisCountyCode);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCountyforplanDetails(CountyName);
		}
		PlanDetailsPageMobile vppPlanDetailsPage = vppTestHarnessPage.navigateToPlanDetails();
		if (vppPlanDetailsPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		}
	}

	@Then("^the user view plan details of the above selected plan in UMS site and validates from Deeplink$")
	public void user_views_plandetails_selected_plan_ums_form_deepLink(DataTable givenAttributes) {

		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planName = memberAttributesRow.get(0).getCells().get(1);*/
		String planName = givenAttributes.cell(0, 1);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.PLAN_NAME, planName);
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.verifyPlanName(planName);

	}

	@When("^the user enters Mandatory fields on plan selector deeplink and clik on deeplink navigates to VPP plan details for UHC$")
	public void user_enters_Mandatory_fields_on_plan_selector_email_deeplink_and_clik_on_deeplink_navigates_to_VPP_plan_details_for_UHC(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String ContractNum = inputAttributesMap.get("ContractNum");
		String SegmentID = inputAttributesMap.get("Segment ID");
		String PbpNumber = inputAttributesMap.get("PbpNumber");
		String PlanYear = inputAttributesMap.get("Plan Year");
		String CountyCode = inputAttributesMap.get("CountyCode");
		String UserGroup = inputAttributesMap.get("User Group");
		String plantype = inputAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(VPPCommonConstantsMobile.PLAN_TYPE, plantype);
		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterEmailPlanSelectorDeepLink(ContractNum, CountyCode, PbpNumber, SegmentID, PlanYear,
				ZipCode, UserGroup, isMultutiCounty, CountyName);
		PlanDetailsPageMobile vppPlanDetailsPage = vppTestHarnessPage.navigateToPlanDetails();
		if (vppPlanDetailsPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		}
	}

	@When("^the user enters Mandatory fields on MedSup deeplink and clik on deeplink navigates to VPP plan details for UHC$")
	public void user_enters_Mandatory_fields_on_MedSup_email_deeplink_and_clik_on_deeplink_navigates_to_VPP_plan_details_for_UHC(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String uri = inputAttributesMap.get("URI");
		String mpbed = inputAttributesMap.get("MPBED");
		String ebrc = inputAttributesMap.get("EBRC");
		String dpsd = inputAttributesMap.get("DPSD");
		String intref = inputAttributesMap.get("Intref");
		String mpaed = inputAttributesMap.get("MPAED");
		String genderCode = inputAttributesMap.get("GenderCode");
		String tobaccoUser = inputAttributesMap.get("TobaccoUser");
		String dob = inputAttributesMap.get("DOB");

		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterMedSupDetailsDeepLink(ZipCode, ebrc, intref, mpbed, dpsd, mpaed, dob, uri, genderCode,
				tobaccoUser);
		vppTestHarnessPage.navigateToMedSupPlans();
		getLoginScenario().saveBean(PageConstants.VPP_TESTHARNESS_PAGE, vppTestHarnessPage);
	}

	@And("^the user validates plan summary for the below plan in UMS site for Medsup Deeplink$")
	public void user_validates_plan_summary_ums_for_medsup_deepLink(DataTable planAttributes)
			throws InterruptedException {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstantsMobile.PLAN_NAME, planName);
		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.validateMedSupSpecificPlanInfo(planName);
	}

	@And("^the user selects plan year for the AARP site$")
	public void user_selects_plan_years(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planYear = givenAttributesMap.get("Plan Year");
		
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		//plansummaryPage.handlePlanYearFutureSelectionPopup(planYear);
	}

	@And("^the user enters Mandatory fields on ProviderSearch Navigates to provider Page for UHC$")
	public void user_enters_Mandatory_fields_on_ProviderSearch_Navigates_to_provider_Page_for_UHC(
			DataTable planAttributes) throws Exception {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String zipCode = givenAttributesMap.get("Zip Code");
		String planYear = givenAttributesMap.get("Plan Year");
		String planID = givenAttributesMap.get("Plan ID");
		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		ProviderSearchPageMobile providerSearchPage = vppTestHarnessPage.enterMandatoryFieldsToProviderSearch(zipCode,
				planID, planYear);
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}
	}

	@And("^user click on LaunhVPP on testharness page and navigated to VPP on UHC$")
	public void user_click_on_LaunhVPP_on_testharness_page_and_navigated_to_VPP_on_UHC() throws InterruptedException {
		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.clickOnLaunchVVP();
		VPPPlanSummaryPageMobile plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}

	}

	@And("^user selects helper mode for Navigate to VPP with Providers data on UHC$")
	public void user_selects_helper_mode_for_NavigatetoVPPwith_Providers_data_on_UHC() throws Exception {

		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.navigatetoVPPwithProvidersdata();
		VPPPlanSummaryPageMobile plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}
	}

	@When("^the user enters following information in the UMS Acquisition Site VPPDCE TestHarness page$")
	public void the_user_enters_following_information_in_the_UMS_Site_VPPDCE_TestHarness_page(DataTable inputAttributes)
			throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String planName = inputAttributesMap.get("Plan Name");
		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterZipandSearch(ZipCode);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCountyDCE(CountyName);
		}
		vppTestHarnessPage.selectPlan(planName);
	}

	@And("^user selects helper mode for Redirect to VPP from DCE on UHC$")
	public void user_selects_helper_mode_for_Redirect_to_VPP_from_DCE_on_UHC() throws Exception {
		VPPTestHarnessPageMobile vppTestHarnessPage = (VPPTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.redirecttoVPPfromDCE();
		VPPPlanSummaryPageMobile plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}
	}

	@Then("^Verify X out of Y drugs covered information is displayed on Plan Summary page ums$")
	public void verify_drugs_covered_ums(DataTable Planname) {

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
		Assertion.assertTrue("Drugs coverage Info not updated", plansummaryPage.druginfo(planName));
	}

	/** user is on the Medicare Site landing page for Visitorprofile Testharness */
	@Given("^the user is on VistorProfile TestHarness page for UHC$")
	public void validateUserIsOnAARP_VPTestharnessPage_for_UHC(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		String TestharnessPage = inputAttributesMap.get("TestHarnessPage");
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd, siteName, TestharnessPage);
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		VisitorProfileTestHarnessPageMobile vpTestHarnessPage = (VisitorProfileTestHarnessPageMobile) aquisitionhomepage
				.GetVisitorProfileTestHarnessPage();
		getLoginScenario().saveBean(PageConstants.VP_TESTHARNESS_PAGE, vpTestHarnessPage);
	}

	@And("^user selects helper mode for Save plans in Guest profile to VP with plans data on UHC$")
	public void user_selects_helper_mode_for_Save_plans_in_Guest_profile_to_VP_with_plans_data_on_UHC()
			throws Exception {

		VisitorProfileTestHarnessPageMobile vpTestHarnessPage = (VisitorProfileTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePageMobile visitorProfilePage = vpTestHarnessPage.NavigateToVP_from_SaveplansinGuestprofileLink();

		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assertion.fail("Error Loading on visitor Profile page");
		}
	}

	@And("^user Enters Fields and selects helper mode for Save plans in Authenticated profile to VP with plans data on UHC$")
	public void user_Enters_Fields_and_selects_helper_mode_for_Save_plans_in_Guest_profile_to_VP_with_plans_data_on_UHC(
			DataTable inputAttributes) throws Exception {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String uuid = inputAttributesMap.get("UUID");
		String isguest = inputAttributesMap.get("IsGuest");
		VisitorProfileTestHarnessPageMobile vpTestHarnessPage = (VisitorProfileTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePageMobile visitorProfilePage = vpTestHarnessPage
				.NavigateToVP_from_SaveplansinauthenticatedprofileLink(uuid, isguest);

		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assertion.fail("Error Loading on visitor Profile page");
		}
	}

	@And("^user selects helper mode for Launch Visitor Profile with Drugs and Pharmacy in Visitor Profile on UHC site$")
	public void user_selects_helper_mode_for_LaunchVisitorProfilewithDrugsandPharmacyinVisitorProfile_on_UHC()
			throws Exception {

		VisitorProfileTestHarnessPageMobile vpTestHarnessPage = (VisitorProfileTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePageMobile visitorProfilePage = vpTestHarnessPage
				.NavigateToVP_from_LaunchVPwithDrugandPharmacyInfoLink();

		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assertion.fail("Error Loading on visitor Profile page");
		}
	}

	@And("^user selects helper mode for Launch Visitor Profile with Providers in Visitor Profile on UHC site$")
	public void user_selects_helper_mode_for_LaunchVisitorProfilewithProvidersinVisitorProfile_on_UHC()
			throws Exception {

		VisitorProfileTestHarnessPageMobile vpTestHarnessPage = (VisitorProfileTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePageMobile visitorProfilePage = vpTestHarnessPage.NavigateToVP_from_LaunchVPwithProvidersLink();
		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assertion.fail("Error Loading on visitor Profile page");
		}
	}

	@And("^user selects plan to compare from visitor Profile on UHC site$")
	public void user_selectsplantoComparefromVisitorProfile_on_UHC(DataTable inputAttributes) throws Exception {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String Plancompare = inputAttributesMap.get("Plan compare");
		String Zipcode = inputAttributesMap.get("Zip Code");
		VisitorProfileTestHarnessPageMobile vpTestHarnessPage = (VisitorProfileTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		ComparePlansPageMobile planComparePage = vpTestHarnessPage.NavigateToPlanCompareFromVpTest(Zipcode,
				Plancompare);

		if (planComparePage != null) {
			loginScenario.saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else {
			Assertion.fail("Error Loading on Plan Compare page");
		}

	}

	@Then("^verify plans added in plan compare on visitor Profile for UHC$")
	public void verify_plans_addedin_plan_compare_on_visitor_Profile_forUHC() throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatePlansAddedonPlancompareforVisitorProfile();
	}

	@And("^user Enters plan info to land on plan details from visitor Profile on UHC site$")
	public void user_EntersplaninfotolandonplandetailsfromvisitorProfileonUHCsite(DataTable inputAttributes)
			throws Exception {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ContractNo = inputAttributesMap.get("Contract Number");
		String PbpNo = inputAttributesMap.get("PBP Number");
		String SegId = inputAttributesMap.get("Segment ID");
		String CountyCD = inputAttributesMap.get("County code");
		String product = inputAttributesMap.get("Product");
		String year = inputAttributesMap.get("Plan Year");
		String Zipcode = inputAttributesMap.get("Zip Code");

		VisitorProfileTestHarnessPageMobile vpTestHarnessPage = (VisitorProfileTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		PlanDetailsPageMobile vppPlanDetailsPage = vpTestHarnessPage.NavigateToPlanDetailsFromVpTest(Zipcode,
				ContractNo, PbpNo, SegId, CountyCD, product, year);

		if (vppPlanDetailsPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		} else {
			Assertion.fail("Error Loading on Plan Details Page page");
		}
	}

	@And("^user selects helper mode for Launch OLE for Guest profile on UHC$")
	public void user_selects_helper_mode_for_Launch_OLE_for_Guest_profile_on_UHC(DataTable givenAttributes)
			throws Exception {

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
		String PlanName = memberAttributesMap.get("Plan Name");
		String PlanYear = memberAttributesMap.get("Plan Year");
		String PlanType = memberAttributesMap.get("Plan Type");

		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, zipcode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, county);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);

		VisitorProfileTestHarnessPageMobile vpTestHarnessPage = (VisitorProfileTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		WelcomePageMobile welcomePage = vpTestHarnessPage.NavigateToOLEfromVP();
		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
		} else {
			Assertion.fail("Error Loading OLE Welcome page");
		}
	}

	@And("^user selects Delete Drug and Pharamcy on the Authenticated profile on UHC site$")
	public void user_selects_DeleteDrugandPharamcyontheAuthenticatedprofile_on_UHC() throws Exception {

		VisitorProfileTestHarnessPageMobile vpTestHarnessPage = (VisitorProfileTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePageMobile visitorProfilePage = vpTestHarnessPage.DeleteDrugAndPharamacy();

		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assertion.fail("Error Loading on visitor Profile page");
		}
	}

	@And("^user selects Delete Provider on the Authenticated profile on UHC site$")
	public void user_selects_DeleteProviderontheAuthenticatedprofile_on_AARP() throws Exception {

		VisitorProfileTestHarnessPageMobile vpTestHarnessPage = (VisitorProfileTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePageMobile visitorProfilePage = vpTestHarnessPage.DeleteProvider();

		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assertion.fail("Error Loading on visitor Profile page");
		}
	}

	@Then("^the user enter the searchValue in the search text box and hits enter on UHC Site$")
	public void the_user_enter_the_searchValue_in_the_search_text_box_and_hits_enter(DataTable inputvalue)
			throws Throwable {
		/*
		 * VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile)
		 * getLoginScenario() .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		 */

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		urlAttributesMap = DataTableParser.readDataTableAsMaps(inputvalue);
		
		/*List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String InputValue = urlAttributesMap.get("search Value");
		System.out.println("Search value" + InputValue);
		Thread.sleep(3000);

		aquisitionhomepage.enterSearchtextvalue(InputValue);

	}

	@Then("^the user should see fifteen results before pagination on UHC Site$")
	public void the_user_should_see_fifteen_results_before_pagination() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateFifteenResults();

	}

	@Then("^the user validates count of results aganist the total shown at top of the page on UHC Site$")
	public void the_user_validates_count_of_results_aganist_the_total_shown_at_top_of_the_page() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCountResults();
	}

	@Then("^the user validates pagination and results displayed on UHC Site$")
	public void the_user_validates_pagination_and_results_displayed() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validatePaginationofSearchResults();
	}

	@Then("^the user validates the secondary search by providing newsearchvalue in the text box on UHC Site$")
	public void the_user_validates_the_secondary_search_by_providing_newsearchvalue_in_the_text_box(
			DataTable inputvalue) throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		urlAttributesMap = DataTableParser.readDataTableAsMaps(inputvalue);
		/*List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String InputValue = urlAttributesMap.get("NewSearchValue");
		System.out.println("NewSearchValue" + InputValue);
		Thread.sleep(3000);

		aquisitionhomepage.enterSecondarySearchValue(InputValue);

	}

	@Then("^the user clear secondary search box and insert new search value on UHC Site$")
	public void the_user_clea_seacondary_search_box_and_insert_new_search_value(DataTable inputvalue) throws Exception {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		urlAttributesMap = DataTableParser.readDataTableAsMaps(inputvalue);
		/*List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String InputValue = urlAttributesMap.get("New Search Value");
		System.out.println("New Search Value" + InputValue);
		Thread.sleep(3000);
		aquisitionhomepage.insertValueIntoSecondSearchBox(InputValue);

	}

	@Then("^the user validates Error message on UHC site$")
	public void the_user_validates_pagination_and_results_displayed(DataTable inputvalue) throws Throwable {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		urlAttributesMap = DataTableParser.readDataTableAsMaps(inputvalue);
		/*List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String error = urlAttributesMap.get("Error");
		String newSearchValue = urlAttributesMap.get("NewSearchValue");
		System.out.println("Error : " + error);
		Thread.sleep(3000);
		aquisitionhomepage.validateErrorMsg(error, newSearchValue);
	}

	@Then("^user saves all plans as favorite on UHC site$")
	public void user_saves_all_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String savePlanNames = memberAttributesMap.get("Test Plans");
		String planType = memberAttributesMap.get("Plan Type");

		switch (planType) {
		case "MAPD":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.saveAllPlans(savePlanNames, planType);
			break;
		case "MA":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.saveAllPlans(savePlanNames, planType);
			break;
		case "SNP":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.saveAllPlans(savePlanNames, planType);
			break;
		case "PDP":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.saveAllPlans(savePlanNames, planType);
			break;

		default:
			break;
		}
	}

	@Then("^Navigate to Visitor Profile page on UHC site$")
	public void navigate_to_Visitor_Profile_page_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		VisitorProfilePageMobile visitorProfilePage = plansummaryPage.navigateToVisitorProfilePage();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	// New plan compare related
	@And("^I click on Get Started on and Add PrimaryCare PCP from find care page in UHC$")
	public void I_click_on_Get_Started_and_Add_PrimaryCarePCP_find_care_page_in_UHC() throws Exception {
		FindCarePageMobile findCarePage = (FindCarePageMobile) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageMobile planComparePage = findCarePage.providerfromPrimaryCare();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@Then("^remove one plan from new plan compare page for UHC$")
	public void remove_one_plan_from_new_plan_compare_page_for_UHC() throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnNewRemoveLink();
	}

	@Then("^Click on Add Icon on new Plan Compare and verify it navigates to plan summary page for UHC$")
	public void click_on_Add_Icon_newPlanCompare_and_verify_it_navigates_to_plan_summary_page_for_UHC()
			throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnNewAddIcon();
	}

	@Then("^Verify newly added plan displayed on new plan compare page for UHC$")
	public void verify_newly_added_plan_displayed_on_new_plan_compare_page_for_UHC() throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatenewlyAddPlanonNewPlanComapre();
	}

	@Then("^verify Your doctors is loaded with doctor summary on Plan Compare page UHC$")
	public void verify_doctors_covered_uhc() {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateDoctors();
	}

	@Then("^verify Your Hospital is loaded with doctor summary on Plan Compare page UHC$")
	public void verify_Hospital_covered_uhc() {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateEditHospitals();
	}

	@Then("^verify Add doctors is loaded with doctor summary on Plan Compare page UHC$")
	public void verify_Add_doctors_covered_uhc() {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateAddDoctors();
	}

	@Then("^verify Add Hospitals is loaded without summary on Plan Compare page UHC$")
	public void verify_Add_Hospitals_covered_uhc() {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateAddHospitals();
	}

	@And("^click on Add your doctors link and Navigate to Rally page for UHC$")
	public void clickOnAddyourdocits_UHC() throws Exception {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		FindCarePageMobile findCarePage = planComparePage.clickonAddYourDoctors();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@And("^click on Add your Hospitals link and Navigate to Rally page for UHC$")
	public void clickOnAddyourHospitals_UHC() throws Exception {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		FindCarePageMobile findCarePage = planComparePage.clickonAddYourHospitals();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@And("^click on Edit your doctors link and Navigate to Rally page for UHC$")
	public void clickONEdityourdocits_UHC() throws Exception {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		FindCarePageMobile findCarePage = planComparePage.clickonEditYourDoctors();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@And("^click on Edit your Hospitals link and Navigate to Rally page for UHC$")
	public void clickONEdityourHospitals_UHC() throws Exception {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		FindCarePageMobile findCarePage = planComparePage.clickonEditYourHosptials();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@And("^user selects a provider from medical group and retuns to plan compare page in UHC$")
	public void selectsproviderfrommedicalGroupforUHC() throws Exception {
		FindCarePageMobile findCarePage = (FindCarePageMobile) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageMobile planComparePage = findCarePage.providerfromMedicalGroup();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@And("^user selects a Hospitals from Clinical and retuns to plan compare page in UHC$")
	public void selectsproviderfromPrimaryCareClinicforUHC() throws Exception {
		FindCarePageMobile findCarePage = (FindCarePageMobile) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageMobile planComparePage = findCarePage.providerfromPrimaryCareClinicButton();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@And("^I click on Get Started on and Add Places from Hospitals find care page in UHC$")
	public void I_click_on_Get_Started_and_Add_PlacesfromHospitals_find_care_page_in_UHC() throws Exception {
		FindCarePageMobile findCarePage = (FindCarePageMobile) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageMobile planComparePage = findCarePage.placesfromHospital();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@Then("^verify Edit your Drugs is loaded with Drugs summary on Plan Compare page UHC$")
	public void verify_Edit_your_Drugswithsummary_covered_uhc() {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateEditDrugs();
	}

	@And("^click on Edit Drug link on plan compare for UHC site$")
	public void clickonEditDruglinkonplancompareforUHCsite() {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DrugCostEstimatorPageMobile drugCostEstimatorPage = planComparePage.clickonEdityourDrugs();
		if (drugCostEstimatorPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, drugCostEstimatorPage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@Then("^Click on view more plans for right navigaton on UHC$")
	public void ClickonviewmoreplansforrightnavigatononUHC() throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateViewMoreplansComparePage();
	}

	@Then("^Click on view less plans for left navigaton on UHC$")
	public void ClickonviewlessplansforrightnavigatononUHC() throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateViewlessplansComparePage();
	}

	@And("^the user signs in with optum Id in medsup flow for uhc$")
	public void the_user_signs_in_with_optum_Id(DataTable credentials) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(credentials);
		/*List<DataTableRow> plannameAttributesRow = credentials.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String username = plannameAttributesMap.get("User Name");
		String password = plannameAttributesMap.get("Password");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.signInOptumId(username, password);
	}

	@Then("^the user click on Dental Cover Popup he must be able to validate plan defaults in UHC$")
	public void the_user_click_on_Optional_Services_tab_and_validate_PlanDefaults(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = memberAttributesMap.get("Plan Name");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean optionalRiderFlag;
		if (memberAttributesMap.get("Optional Rider").isEmpty())
			optionalRiderFlag = false;
		else {
			String optionalRiderPremium = vppPlanDetailsPage
					.addOptionalRider(memberAttributesMap.get("Optional Rider"));
			optionalRiderFlag = true;
		}
		vppPlanDetailsPage.validateDentalPopupDefaults(planName, optionalRiderFlag);
	}
	
	@When("^the user validates the pdf section on site$")
	public void userValidatesPDFSection1() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatePdfSection(planType);
	}

	@Then("^User clicks on Back to Plans link and navigate back to plan summary$")
	public void User_clicks_BackToPlansLink_and_navigate_back_to_plan_summary() {

		PlanDetailsPageMobile planDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		VPPPlanSummaryPageMobile plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPageFromDetailsPage();
		if (plansummaryPage != null) {
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the Plan Summary Page");
	}

	@And("^User click on add to compare checkbox and click on view details link$")
	public void user_click_on_compare_checkbox_AARP() {
		VPPPlanSummaryPageMobile vppplansummarypage = (VPPPlanSummaryPageMobile) loginScenario
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.clickCompareChkBox();
		PlanDetailsPageMobile planDetailsPage = vppplansummarypage.clickViewDetails_AddedToCompare();
		if (planDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetailsPage);
		}
	}
	
	@Given("^I select \"([^\"]*)\" plans and \"([^\"]*)\" plans to compare$")
	public void i_select_plans_for_compare(String planType, String Counter) throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.checkPlansForCompare(Counter, planType);
	}

	@Then("^click add to compare checkbox on plan details page and navigate to compare page$")
	public void click_add_to_compare_checkbox_on_plan_details_page_and_navigate_to_compare_page() throws Throwable {
		PlanDetailsPageMobile planDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		ComparePlansPageMobile planComparePage = planDetailsPage.addToCompareAndNavigate();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else
			Assertion.fail("Error in loading the compare plans page");
	}
	
	@Then("^I uncheck and go back to the vpp page to validate for site$")
	public void uncheck_and_validate_vpp_page1() {
		PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile) loginScenario.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		plandetailspage.clickCompareBox();
		VPPPlanSummaryPageMobile vppsummarypage = plandetailspage.navigateBackToPlanSummaryPageFromDetailsPage();
		vppsummarypage.verifyPlanComapreCheckboxIsUncheckedforFirstPlan();
	}

	@Then("^the user click on Dental Cover Popup he must be able to validate plan defaults$")
	public void the_user_click_on_Optional_Services_tab_and_validate_PlanDefaults1(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = memberAttributesMap.get("Plan Name");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean optionalRiderFlag;
		if (memberAttributesMap.get("Optional Rider").isEmpty())
			optionalRiderFlag = false;
		else {
			String optionalRiderPremium = vppPlanDetailsPage
					.addOptionalRider(memberAttributesMap.get("Optional Rider"));
			optionalRiderFlag = true;
		}
		vppPlanDetailsPage.validateDentalPopupDefaults(planName, optionalRiderFlag);
	}

}
