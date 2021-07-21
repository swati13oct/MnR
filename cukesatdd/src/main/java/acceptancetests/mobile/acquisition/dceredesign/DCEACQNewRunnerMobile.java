package acceptancetests.mobile.acquisition.dceredesign;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DCEStepHeaderMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;
import pages.mobile.acquisition.dceredesign.SwitchToGenericMobile;
import pages.mobile.acquisition.dceredesign.TellUsAboutDrugMobile;
import pages.mobile.acquisition.dceredesign.ZipCodeAndPlanYearCapturePageMobile;

/**
 * Functionality:DCE Acquisition
 */
public class DCEACQNewRunnerMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;
	
	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}
	

	@Then("^the user edits supply length to three months for following drug$")
	public void the_user_edits_supply_length_to_three_months_for_following_drug(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String drugName = memberAttributesMap.get("EditDrug");
		System.out.println(drugName);
		BuildYourDrugListMobile buildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrugMobile tellUsAboutDrug = buildDrugList.EditDrug(drugName);
		tellUsAboutDrug.selectSupplyLength("3 Months");
		buildDrugList = tellUsAboutDrug.ClickAddDrug();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}

	@Then("^the user validates Dynamic Copay Section for following Pharmacy selection$")
	public void the_user_validates_Dynamic_Copay_Section_for_following_Pharmacy_selection(DataTable givenAttributes)
			throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PharmacyTypeSelected = memberAttributesMap.get("Pharmacy Selection");
		if (PharmacyTypeSelected.contains("Preferred Retail")) {
			drugDetailsPage.validatePreferredRetailCopaySection();
		} else if (PharmacyTypeSelected.contains("Standard Retail")) {
			drugDetailsPage.validateStandardRetailCopaySection();
		} else if (PharmacyTypeSelected.contains("Standard Mail")) {
			drugDetailsPage.validateStandardMailCopaySection();
		} else if (PharmacyTypeSelected.contains("Preferred Mail")) {
			drugDetailsPage.validatePreferredMailCopaySection();
		}
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@When("^user clicks on change pharmacy link from details page$")
	public void user_clicks_on_change_pharmacy_link_from_details_page_in_AARP() throws InterruptedException {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.clickChangePharmacyLinkDetailsPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user selects Mail Pharmacy and returns to DCE Details page$")
	public void the_user_selects_Mail_Pharmacy_and_returns_to_DCE_Details_page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.SelectMailPharmacy();
		String pharmacy = "OptumRx Mail Service Pharmacy";
		drugDetailsPage.validatePharmacyName(pharmacy);
		getLoginScenario().saveBean(PageConstants.PHARMACY_NAME, pharmacy);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^the user selects following Standard pharmacy and returns to DCE Details page$")
	public void the_user_selects_following_Standard_pharmacy_and_returns_to_DCE_Details_page(DataTable givenAttributes)
			throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String StandardPharmacytoSelect = memberAttributesMap.get("SelectStandardPharmacy");
		drugDetailsPage.SelectStandardPharmacy(StandardPharmacytoSelect);
		drugDetailsPage.validatePharmacyName(StandardPharmacytoSelect);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^the user validates following premium for the following plan on DCE Summary Page$")
	public void the_user_validates_following_premium_for_the_following_plan_on_DCE_Summary_Page(DataTable arg1)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*
		 * List<DataTableRow> memberAttributesRow = arg1.getGherkinRows(); for (int i =
		 * 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String Premium = memberAttributesMap.get("Premium");
		String PlanType = memberAttributesMap.get("Plan Type");
		String PlanName = memberAttributesMap.get("Plan Name");
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validatePremiumForPlan(Premium, PlanType, PlanName);
	}

	@Then("^the user validates following expected Premium on DCE Details Page$")
	public void the_user_validates_following_expected_Premium_on_DCE_Details_Page(DataTable arg1) throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*
		 * List<DataTableRow> memberAttributesRow = arg1.getGherkinRows(); for (int i =
		 * 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String Premium = memberAttributesMap.get("Premium");
		drugDetailsPage.validatePremium(Premium);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates error message for blank search$")
	public void the_user_validates_error_message_for_blank_search() throws Throwable {
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEbuildDrugList.validateNoDrug_ErrorMsg();
	}

	@Then("^plan year dropdown should not be displayed during Non AEP$")
	public void plan_year_dropdown_should_not_be_displayed_during_NonAEP_period() {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validatePlanYearDrpDownNonAEP();
	}

	@Then("^user should be navigated to zipcode and plan year capture page for Non AEP$")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page_for_Non_AEP() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = new ZipCodeAndPlanYearCapturePageMobile(wd);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@Then("^the user validates No Drug found error message for search$")
	public void the_user_validates_No_Drug_found_error_message_for_search() throws Throwable {
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEbuildDrugList.validateDrugNotFound_ErrorMsg();
	}

	@Then("^user enter the following drug info and validates drug autocomplete$")
	public void user_enter_the_following_drug_info_and_validates_drug_autocomplete(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PartialDrug = memberAttributesMap.get("DrugNameAutoComplete");
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEbuildDrugList.ValidateDrugAutocomplete(PartialDrug);
	}

	@Then("^the user selects the following Brand Name drug from the dropdown$")
	public void the_user_selects_the_following_drug_from_the_dropdown(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String DrugName = memberAttributesMap.get("BrandDrugName");
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrugMobile tellUsAboutDrug = DCEbuildDrugList.SelectDrugfromList(DrugName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_TellUsAboutDrug, tellUsAboutDrug);
		getLoginScenario().saveBean(DCERedesignCommonConstants.BRAND_DRUG1, DrugName);
	}

	@Then("^the user validates Tell Us About Drug - Brand page for the Drug$")
	public void the_user_validates_Tell_Us_About_Drug_Brand_page_for_the_Drug(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String genericDrugName = memberAttributesMap.get("GenericName");
		String BrandDrugName = (String) getLoginScenario().getBean(DCERedesignCommonConstants.BRAND_DRUG1);
		// String BrandDrugName = memberAttributesMap.get("BrandDrugName");

		TellUsAboutDrugMobile tellUsAboutDrug = (TellUsAboutDrugMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrug.validateBrandDrugPage(BrandDrugName, genericDrugName);
	}

	@Then("^the user clicks on Add Drug to add drug to drug list$")
	public void the_user_clicks_on_Add_Drug_to_add_drug_to_drug_list(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String drugName = memberAttributesMap.get("BrandDrugName");
		TellUsAboutDrugMobile tellUsAboutDrug = (TellUsAboutDrugMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		BuildYourDrugListMobile DCEbuildDrugList = tellUsAboutDrug.ClickAddDrug();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		if (null == druglist) {
			druglist = "";
		}
		druglist = druglist + "&" + drugName;
		System.out.println("Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
	}

	// MonthlyDrugCost Changes Start
	@Then("^the user validates Monthly Drug Costs$")
	public void the_user_validates_Monthly_Drug_Costs() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateMonthlyCost();
	}

	@Then("^the user validates Switch to generic for following Brand Drug and validate Generic drug on Details Page$")
	public void the_user_validates_Switch_to_generic_for_following_Brand_Drug_and_validate_Generic_drug_on_Details_Page(
			DataTable givenAttributes) throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String BrandDrug = memberAttributesMap.get("Brand Drug");
		String GenericDrug = memberAttributesMap.get("Generic Drug");
		SwitchToGenericMobile switchToGenericPage = drugDetailsPage.clickSwitchGeneric(BrandDrug);
		switchToGenericPage.validateSwitchPage(GenericDrug, BrandDrug);
		drugDetailsPage = switchToGenericPage.ClickSwitch_ReturnDetailsPage();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		druglist = druglist.replace(BrandDrug, GenericDrug);
		System.out.println("Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);

		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user clicks Edit Drug on Drug Details Page and validates user navigates to Build your drug list Page$")
	public void the_user_clicks_Edit_Drug_on_Drug_Details_Page_and_validates_user_navigates_to_Build_your_drug_list_Page()
			throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		BuildYourDrugListMobile buildDrugListPage = drugDetailsPage.clickEditDrugs();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugListPage);

	}

	@Then("^the user deletes the following drug from Drug list$")
	public void the_user_deletes_the_following_drug_from_Drug_list(DataTable givenAttributes) throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		BuildYourDrugListMobile buildDrugListPage = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String DeleteDrug = memberAttributesMap.get("DrugName");
		buildDrugListPage.deleteDrug(DeleteDrug);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		System.out.println("Drug List before Delete Drug : " + druglist);
		druglist = druglist.replace("&" + DeleteDrug, "");
		System.out.println("Updated Drugs List after Delete Drug : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^the user clicks on Review Drug Costs to Land on Drug Details Page$")
	public void the_user_clicks_on_Review_Drug_Costs_to_Land_on_Drug_DetailsP_Page() throws Throwable {
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugDetailsPageMobile drugDetailsPage = DCEbuildDrugList.navigateToDrugDetailsPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^user verify and click on switch to generic NBA on drug detail page$")
	public void user_verify_and_click_on_switch_to_generic_NBA_on_drug_detail_page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.clickswitchToGeneric();
	}

	@Then("^the user validates Drug List in Your Drugs Section on Drug Details Page$")
	public void the_user_validates_druglist_yourDrugs_DrugDetailsPageMobile() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		drugDetailsPage.ValidatesDrugsList(druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, drugDetailsPage);
	}

	@Then("^verify drug is switched to generic on detail page$")
	public void verify_drug_is_switched_to_generic_on_detail_page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.verifyDrugisSwitchedtoGeneric();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, drugDetailsPage);
	}

	@When("^the user saves plan from drug details page$")
	public void the_user_saves_plan_from_drug_details_page(DataTable givenAttributes) {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PlanName = memberAttributesMap.get("planname");
		System.out.println(PlanName);
		drugDetailsPage.savePlan(PlanName);
	}

	@And("^user validates the plans on new visitor profile page of AARP site$")
	public void user_validates_the_plans_on_new_visitor_profile_page_of_AARP_site(DataTable planNames) {
		
		/*Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		
		List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String mapdPlanName = givenAttributesMap.get("Test Plans");*/
		
		List<List<String>> givenAttributesMap = planNames.asLists();
		List<String> favPlans = givenAttributesMap.stream().map(planDetails -> planDetails.get(1)).collect(Collectors.toList());
		
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedPlansNew(favPlans);
	}

	@Then("^the user validates planName on LearnMore page matches plan Name in VPP$")
	public void the_user_validates_planName_on_LearnMore_page_matches_plan_Name_in_VPP() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		String PlanName = (String) getLoginScenario().getBean(DCERedesignCommonConstants.PLANNAME);
		drugDetailsPage.validatePlanNameLearnMore(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	// LearnMore changes Start
	@Then("^the user clicks PrescriptionBenifit Tab on Plan Details Page$")
	public void the_user_clicks_PrescriptionBenifit_Tab_on_Plan_Details_Page() throws Throwable {

		// PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile)
		// getLoginScenario()
		// .getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		// plandetailspage.clickPrescriptionBenifitTab();

		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		PlanDetailsPageMobile plandetailspage = drugDetailsPage.clickPrescriptionBenifitTab();
		getLoginScenario().saveBean(PageConstants.DETAIL_PAGE_INFO, plandetailspage);
	}

	@Then("^the user clicks Learn More button on Prescription Drug Costs Tab on Plan Details Page$")
	public void the_user_clicks_Learn_More_button_on_Prescription_Drug_Costs_Tab_on_Plan_Details_Page()
			throws Throwable {
		PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DETAIL_PAGE_INFO);
		getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		plandetailspage.clickLearnMore();

		// String PlanName = (String)
		// getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		// getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

	}

	@Then("^the user validates Insulin savings on Copay section, Your Drugs and Important Information Section$")
	public void the_user_validates_Insulin_savings_on_Copay_section_Your_Drugs_and_Important_Information_Section(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*
		 * List<DataTableRow> memberAttributesRow = arg1.getGherkinRows(); for (int i =
		 * 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String InsulinCopay = memberAttributesMap.get("InsulinCopay");
		String InsulinDrug = memberAttributesMap.get("Insulin Drug");
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateInsulinTier_CopaySection(InsulinCopay);
		drugDetailsPage.validateInsulinDrug_YourDrugs(InsulinDrug, InsulinCopay);
		drugDetailsPage.validateInsulinText_ImportantInfo();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^the user validates distance dropdown and Zipcode change on DCE Details page - Change Pharmacy Page$")
	public void the_user_validates_distance_dropdown_and_Zipcode_change_on_Details_page_Change_Pharmacy_Page(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*
		 * List<DataTableRow> memberAttributesRow = arg1.getGherkinRows(); for (int i =
		 * 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PharmacyZipCode = memberAttributesMap.get("PharmacyZipCode");
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateZipandDistanceDropDwn(PharmacyZipCode);
	}

	@Then("^the user selects following pharmacy and returns to DCE Details page$")
	public void the_user_selects_following_pharmacy_and_returns_to_DCE_Details_page(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String PharmacytoSelect = memberAttributesMap.get("SelectPharmacy");
		drugDetailsPage.SelectPharmacy(PharmacytoSelect);
		drugDetailsPage.validatePharmacyName(PharmacytoSelect);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^the user validates Not Covered Pharmacy view for DCE Details Page$")
	public void the_user_validates_Not_Covered_Pharmacy_view_for_DCE_Details_Page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateNotCoveredPharmacyView();
	}

	@When("^user clicks on edit drugs button from plan card$")
	public void user_clicks_on_edit_drugs_button_from_plan_card() {
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.clickEditDrugsPlancard();
	}

	@Then("^user should see back to drug cost estimator link on visitor profile page$")
	public void user_should_see_back_to_drug_cost_estimator_link_on_visitor_profile_page() {
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateBackToDceLink();
	}

	@When("^user clicks on Return to profile link on details page$")
	public void user_clicks_on_Return_to_profile_link_on_details_page() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugDetailsPageMobile drugDetailsPage = new DrugDetailsPageMobile(wd);
		drugDetailsPage.clickReturnToProfile();
	}

	@Then("^the user clicks on the enter drug information button from plan card on Visitor Profile page$")
	public void the_user_clicks_on_the_enter_drug_information_button_from_plan_card_on_VP_page() {
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.clickAddDrugsPlancardNew();
	}

	@And("^user validates the added plans on new visitor profile page$")
	public void user_validates_the_added_plans_on_new_visitor_profile_page(DataTable planNames) {
		/*Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		
		 * List<DataTableRow> givenAttributesRow = planNames.getGherkinRows(); for (int
		 * i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 
		String savePlanNames = givenAttributesMap.get("Test Plans"); */
		List<List<String>> givenAttributesMap = planNames.asLists();
		List<String> favPlans = givenAttributesMap.stream().map(planDetails -> planDetails.get(1)).collect(Collectors.toList());
		
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedPlansNew(favPlans);
	}

	@And("^user click on view saved plans button$")
	public void user_click_on_view_saved_plans_button() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		VisitorProfilePageMobile visitorProfilePage = plansummaryPage.viewSavedPlans();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@Then("^user should be able to see Return to profile link on details page$")
	public void user_should_be_able_to_see_Return_to_profile_link_on_details_page() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugDetailsPageMobile drugDetailsPage = new DrugDetailsPageMobile(wd);
		drugDetailsPage.verifyReturnToProfileDisplayed();
	}

	@Then("^user should be navigated to build drug list page$")
	public void user_should_be_navigated_to_build_drug_list_page() {
		BuildYourDrugListMobile buildDrugListPage = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		buildDrugListPage.validateBuildDrugListPageDisplayed();
	}

	@Then("^user should be navigated to shopper profile page$")
	public void user_should_be_navigated_to_shopper_profile_page() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		VisitorProfilePageMobile visitorProfile = new VisitorProfilePageMobile(wd);
		visitorProfile.validateVisitorProfilePage();

	}

	@When("^user clicks on Back to profile button$")
	public void user_clicks_on_Back_to_profile_button() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
//		drugSummaryPage.clickBackToProfileBtn();
		System.out.println("Clicking 'Return To Profile' link.");
		drugSummaryPage.clickReturnToProfileLink();
	}

	@Then("^Back to profile button should be displayed for each plan card$")
	public void back_to_profile_button_for_each_plan_card() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		drugSummaryPage.verifyBackToProfileDisplayed();
	}

	@Then("^user should be able to see Return to profile link on summary page$")
	public void user_should_be_able_to_see_Return_to_profile_link_on_summary_page() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		getLoginScenario().getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		drugSummaryPage.verifyReturnToProfileDisplayed();
	}

	@And("^the user navigate to Visitor profile page$")
	public void the_user_navigate_to_visitor_profile_page() {
		AcquisitionHomePageMobile acqHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VisitorProfilePageMobile visitorProfilePage = acqHomePage.navigateToNewVisitorProfilePage();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@And("^the user clicks on the add drugs button globally on the profile page$")
	public void the_user_clicks_on_the_add_drugs_button_globally_in__profile_page() {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.clickAddDrugsGlobal();
	}

	@Then("the user clicks on Review Button on Build Drug Page to land on DCE Summary page")
	public void the_user_clicks_on_review_button_on_build_drug_page_to_land_on_dce_summary_page()
			throws InterruptedException {
		scenario.log(
				"Sneha Dwarakanath - Change made for July Release - F603797: DCE | Mobile First Optimization | Edit Drug List from Summary | Desktop & Mobile");
		scenario.log(
				"Sneha Dwarakanath - Change made for July Release - F603797: step added to @dce_DrugSummary_Page or @dce_MedEdPage_E2E_Scenario4_UAT");
		BuildYourDrugListMobile buildDrugListPage = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugSummaryPageMobile drugSummaryPage = buildDrugListPage.navigateToDrugSummaryPage();
		drugSummaryPage.validateDrugSummaryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	/**
	 * Step Header Flags as follows C - Current E - Enabled D - Disabled
	 **/
	@Then("the user validates the Step Header as follows")
	public void the_user_validates_teh_step_header_as_follows(io.cucumber.datatable.DataTable attributes) {
		scenario.log(
				"Sneha Dwarakanath - Change made 06/07/2021 - Step Header validation Added --> C for Current, E for Enabled, D for Disabled ");
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String StepHeaderFlag = memberAttributesMap.get("Flags");
		System.out.println("Flags -->>" + StepHeaderFlag);
		System.out.println(">>> Skipping validation on mobile <<< Step headers are not displayed on mobile.");
//		DCEStepHeaderMobile dceStepHeader = new DCEStepHeaderMobile(wd);
//		dceStepHeader.validateStepHeader(StepHeaderFlag);
	}

	@Then("the user clicks on Step Header Step {int} to land on Build your drug list Page")
	public void the_user_clicks_on_step_header_step_to_land_on_build_your_drug_list_page(Integer int1) {
		scenario.log("Sneha Dwarakanath - Change made 06/07/2021 - Step Header Navigation validation Added ");
		DCEStepHeaderMobile dceStepHeader = new DCEStepHeaderMobile(wd);
		BuildYourDrugListMobile buildDrugListPage = dceStepHeader.ClickStep2_NavigateDrugListPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugListPage);
	}

	@Then("the user clicks on Step Header Step {int} to land on Drug Details Page")
	public void the_user_clicks_on_step_header_step_to_land_on_drug_details_page(Integer int1) {
		scenario.log("Sneha Dwarakanath - Change made 06/07/2021 - Step Header Navigation validation Added ");
		DCEStepHeaderMobile dceStepHeader = new DCEStepHeaderMobile(wd);
		DrugDetailsPageMobile drugDetailsPage = dceStepHeader.ClickStep3_NavigateDrugDetailsPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("the user clicks on Step Header Step {int} to land on Drug Summary Page")
	public void the_user_clicks_on_step_header_step_to_land_on_drug_summary_page(Integer int1) {
		scenario.log("Sneha Dwarakanath - Change made 06/07/2021 - Step Header Navigation validation Added ");
		DCEStepHeaderMobile dceStepHeader = new DCEStepHeaderMobile(wd);
		DrugSummaryPageMobile drugSummaryPage = dceStepHeader.ClickStep3_NavigateDrugSummaryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("the user clicks on Edit Drug list link on View Drug pricing modal")
	public void the_user_clicks_on_edit_drug_list_link_on_view_drug_pricing_modal() {
		scenario.log(
				"Sneha Dwarakanath - Change made for July Release - F603797: DCE | Mobile First Optimization | Edit Drug List from Summary | Desktop & Mobile");
		scenario.log(
				"Sneha Dwarakanath - Change made for July Release - F603797: step added to @dce_DrugSummary_Page or @dce_MedEdPage_E2E_Scenario4_UAT");
		wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		BuildYourDrugListMobile buildDrugListPage = drugSummaryPage.clickEditDrugs_DrugPricingModal();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugListPage);
	}

	@Then("^the user validates correct Copay section view and LIS message Not Displayed and zero deductible for LIS Buydown Plan on DCE details Page$")
	public void the_user_validates_correct_Copay_section_view_and_LIS_message_for_LIS_Buydown_Plan_on_DCE_details_Page()
			throws Throwable {
        scenario.log("Sneha Dwarakanath - Change made 06/08/2021 - F608087 - DCE | Copay Buydown, Deductible Display Change");
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateLISBuyDown_CopaySection_LISAlert();
	}
}