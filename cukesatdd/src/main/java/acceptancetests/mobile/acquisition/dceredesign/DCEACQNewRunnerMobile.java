package acceptancetests.mobile.acquisition.dceredesign;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.dceredesign.SwitchToGeneric;
import pages.acquisition.dceredesign.TellUsAboutDrug;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;
import pages.mobile.acquisition.dceredesign.TellUsAboutDrugMobile;
import pages.mobile.acquisition.dceredesign.ZipCodeAndPlanYearCapturePageMobile;
import pages.mobile.acquisition.ulayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.ulayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.ulayer.PlanDetailsPageMobile;
//import pages.mobile.acquisition.ulayer.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.SwitchToGenericMobile;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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

	@Then("^the user edits supply length to three months for following drug$")
	public void the_user_edits_supply_length_to_three_months_for_following_drug(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
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
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
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
		String pharmacy = "Preferred Mail Service Pharmacy";
		drugDetailsPage.validatePharmacyName(pharmacy);
		getLoginScenario().saveBean(PageConstants.PHARMACY_NAME, pharmacy);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^the user selects following Standard pharmacy and returns to DCE Details page$")
	public void the_user_selects_following_Standard_pharmacy_and_returns_to_DCE_Details_page(DataTable givenAttributes)
			throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String StandardPharmacytoSelect = memberAttributesMap.get("SelectStandardPharmacy");
		drugDetailsPage.SelectStandardPharmacy(StandardPharmacytoSelect);
		drugDetailsPage.validatePharmacyName(StandardPharmacytoSelect);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^the user validates following premium for the following plan on DCE Summary Page$")
	public void the_user_validates_following_premium_for_the_following_plan_on_DCE_Summary_Page(DataTable arg1)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
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
		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
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
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String PartialDrug = memberAttributesMap.get("DrugNameAutoComplete");
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEbuildDrugList.ValidateDrugAutocomplete(PartialDrug);
	}

	@Then("^the user selects the following Brand Name drug from the dropdown$")
	public void the_user_selects_the_following_drug_from_the_dropdown(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
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
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String genericDrugName = memberAttributesMap.get("GenericName");
		String BrandDrugName = (String) getLoginScenario().getBean(DCERedesignCommonConstants.BRAND_DRUG1);
		// String BrandDrugName = memberAttributesMap.get("BrandDrugName");

		TellUsAboutDrugMobile tellUsAboutDrug = (TellUsAboutDrugMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrug.validateBrandDrugPage(BrandDrugName, genericDrugName);
	}

	@Then("^the user clicks on Add Drug to add drug to drug list$")
	public void the_user_clicks_on_Add_Drug_to_add_drug_to_drug_list(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
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
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
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
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
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

	@Then("^the user validates Drug List in Your Drugs Section on Drug Details Page$")
	public void the_user_validates_druglist_yourDrugs_DrugDetailsPage() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		drugDetailsPage.ValidatesDrugsList(druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, drugDetailsPage);
	}

	@Then("^the user validates planName on LearnMore page matches plan Name in VPP$")
	public void the_user_validates_planName_on_LearnMore_page_matches_plan_Name_in_VPP() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanNameLearnMore(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

//	LearnMore changes Start
	@Then("^the user clicks PrescriptionBenifit Tab on Plan Details Page$")
	public void the_user_clicks_PrescriptionBenifit_Tab_on_Plan_Details_Page() throws Throwable {
		PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		plandetailspage.clickPrescriptionBenifitTab();
	}

	@Then("^the user clicks Learn More button on Prescription Drug Costs Tab on Plan Details Page$")
	public void the_user_clicks_Learn_More_button_on_Prescription_Drug_Costs_Tab_on_Plan_Details_Page()
			throws Throwable {
		PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		DrugDetailsPageMobile drugDetailsPage = plandetailspage.clickLearnMore();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates Insulin savings on Copay section, Your Drugs and Important Information Section$")
	public void the_user_validates_Insulin_savings_on_Copay_section_Your_Drugs_and_Important_Information_Section(
			DataTable arg1) throws Throwable {
		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
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
		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String PharmacyZipCode = memberAttributesMap.get("PharmacyZipCode");
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateZipandDistanceDropDwn(PharmacyZipCode);
	}

	@Then("^the user selects following pharmacy and returns to DCE Details page$")
	public void the_user_selects_following_pharmacy_and_returns_to_DCE_Details_page(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
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

}