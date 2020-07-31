package acceptancetests.acquisition.dceredesign;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.dce.ulayer.DCETestHarnessPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.dceredesign.TellUsAboutDrug;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AddDrugDetails;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.SavingsOppurtunity;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.VisitorProfilePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
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
public class DCEStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver driver;

	@Then("^the user validates Get Started Page$")
	public void the_user_validates_Get_Started_Page() throws Throwable {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		GetStartedPage DCEgetStarted = new GetStartedPage(driver);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, DCEgetStarted);

	}
	@When("^I access the acquisition DCE Redesign from home page$")
	public void I_access_the_DCE_redesign_home_page() throws InterruptedException {

		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		GetStartedPage getStartedPage = acquisitionHomePage.navigateToDCERedesignFromHome();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}
	
	/*verify DCE flow from Ulayer home page hover over*/
	@When("^I click on DCE Redesign link from Shop for a plan hover over for AARP site$")
	public void i_click_on_DCE_Redesign_link_from_Shop_for_a_plan_hover_over_for_ums_site() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		GetStartedPage getStartedPage = acquisitionHomePage.navigateToDCERedesignFromSubNav();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}
	
	@Then("^the user clicks on Build Drug List to navigate to Build Drug List Page$")
	public void the_user_clicks_on_Build_Drug_List_to_navigate_to_Build_DrugList() throws Throwable {
		GetStartedPage DCEgetStarted = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		BuildYourDrugList DCEbuildDrugList = DCEgetStarted.clickAddsDrugs();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}
	 

	@Then("^the user clicks on Build Drug List to navigate to Step (\\d+)$")
	public void the_user_clicks_on_Build_Drug_List_to_navigate_to_Step(int arg1) throws Throwable {
		GetStartedPage DCEgetStarted = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		BuildYourDrugList DCEbuildDrugList = DCEgetStarted.clickAddsDrugs();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);

		ZipCodePlanYearCapturePage zipCodePlanYearPage = new ZipCodePlanYearCapturePage(driver);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}
	
	@Then("^the user validates error message for blank search$")
	public void the_user_validates_error_message_for_blank_search() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEbuildDrugList.validateNoDrug_ErrorMsg();
	}

	@When("^the user clicks on Add drugs button$")
	public void the_user_clicks_on_Add_drugs_button() {
		GetStartedPage DCEgetStarted = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEgetStarted.clickAddDrugsBtn();
		//getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@Then("^plan year dropdown should be displayed during AEP in AARP$")
	public void plan_year_dropdown_should_be_displayed_during_AEP_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validatePlanYearDrpDownAEP();
	}

	@Then("^plan year dropdown should not be displayed during Non AEP$")
	public void plan_year_dropdown_should_not_be_displayed_during_NonAEP_period() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validatePlanYearDrpDownNonAEP();
	}

	@Then("^user should be navigated to zipcode and plan year capture page for Non AEP$")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page_for_Non_AEP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
	}

	@Then("^user should be navigated to zipcode and plan year capture page for AEP in AARP$")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page_for_AEP_in_AARP() {
		/*
		 * ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage)
		 * getLoginScenario()
		 * .getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		 * zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		 */

	}
	
	@Then("^the user validates No Drug found error message for search$")
	public void the_user_validates_No_Drug_found_error_message_for_search() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEbuildDrugList.validateDrugNotFound_ErrorMsg();
	}

	@Then("^user enter invalid zipcode in AARP$")
	public void user_enter_invalid_zipcode_in_AARP(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String invalidzipcode = memberAttributesMap.get("inValidzipCode");
		System.out.println("zipcode" + invalidzipcode);
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.enterZipCode(invalidzipcode);
	}

	@Then("^user enter the following drug info and validates drug autocomplete$")
	public void user_enter_the_following_drug_info_and_validates_drug_autocomplete(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String PartialDrug = memberAttributesMap.get("DrugNameAutoComplete");	
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
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
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrug tellUsAboutDrug = DCEbuildDrugList.SelectDrugfromList(DrugName);		
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_TellUsAboutDrug, tellUsAboutDrug);
		getLoginScenario().saveBean(DCERedesignCommonConstants.BRAND_DRUG1, DrugName);
	}
	
	
	@Then("^the user validates Tell Us About Drug - Brand page for the Drug$")
	public void the_user_validates_Tell_Us_About_Drug_Brand_page_for_the_Drug(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String genericDrugName = memberAttributesMap.get("GenericName");
		String BrandDrugName = (String) getLoginScenario().getBean(DCERedesignCommonConstants.BRAND_DRUG1);
		//String BrandDrugName = memberAttributesMap.get("BrandDrugName");	

		TellUsAboutDrug tellUsAboutDrug = (TellUsAboutDrug) getLoginScenario().getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrug.validateBrandDrugPage(BrandDrugName, genericDrugName);
	}

	@Then("^the user selects following Drug Details$")
	public void the_user_selects_following_Drug_Details() throws Throwable {
		
	}


	@Then("^the user validates Blank Drug Quantity error message$")
	public void the_user_validates_Blank_Quantity_error_message() throws Throwable {
		TellUsAboutDrug tellUsAboutDrug = (TellUsAboutDrug) getLoginScenario().getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrug.ValidateBlankQuantityError();

	}

	@Then("^the user clicks on Add Drug to add drug to drug list$")
	public void the_user_clicks_on_Add_Drug_to_add_drug_to_drug_list() throws Throwable {
		TellUsAboutDrug tellUsAboutDrug = (TellUsAboutDrug) getLoginScenario().getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		BuildYourDrugList DCEbuildDrugList = tellUsAboutDrug.ClickAddDrug();
	}

	@Then("^the user does drug search and selects drug for following drug$")
	public void the_user_does_drug_search_and_selects_drug_for_following_drug(DataTable arg1) throws Throwable {

	}


	@Then("^the user clicks on Review Drug Costs to Land on Zip Entry Page$")
	public void the_user_clicks_on_Add_Drug() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		ZipCodePlanYearCapturePage zipCodePlanYearPage = DCEbuildDrugList.navigateToZipEntryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}
	
	@Then("^user enters valid zipcode and county in AARP$")
	public void user_enter_valid_zipcode_and_county_in_AARP(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = memberAttributesMap.get("ZipCode");
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.enterZipCodeandcounty(zipcode);
	}

	@When("^user selects plan year in AARP$")
	public void user_selects_plan_year_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.selectPlanYear();
	}

	@When("^user clicks on continue button in AARP$")
	public void user_clicks_on_continue_button_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.clickContinueBtn();
		zipCodePlanYearPage.verifyLoadScreen();
	}

	@Then("^user should be navigated to Review drug cost estimate page in AARP$")
	public void user_should_be_navigated_to_Review_drug_cost_estimate_page_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.verifyReviewDrugCostPageDisplayed();
	}

	@Then("^error message should be displayed in AARP$")
	public void error_message_should_be_displayed_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validateZipCodeErrorMessage();
	}

	@When("^adds drugs in drug list page$")
	public void adds_drugs_in_drug_list_page(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String drugName = memberAttributesMap.get("DrugName");
		System.out.println("zipcode" + drugName);
		BuildYourDrugList buildDrugList = new BuildYourDrugList(driver);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
		buildDrugList.addDrugs(drugName);
	}

	@When("^clicks on Review drug cost button$")
	public void clicks_on_Review_drug_cost_button() {
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		buildDrugList.clickReviewDrugCostBtn();
	}
	

	@Then("^load screen should be displayed in AARP$")
	public void load_screen_should_be_displayed_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		//zipCodePlanYearPage.verifyLoadScreen();
	}
	
	@Then("^the user searches and adds the following Drug to Drug List$")
	public void the_user_searches_and_adds_the_following_Drug_to_Drug_List(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String drugName = memberAttributesMap.get("DrugName");
		System.out.println(drugName);
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrug tellUsAboutDrug = buildDrugList.SearchaddDrugs(drugName);
		buildDrugList = tellUsAboutDrug.ClickAddDrug();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		druglist = druglist+"&"+drugName;
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST,druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}
	
	@Then("^the user validates all added drugs in DrugList$")
	public void the_user_validates_all_added_drugs_in_DrugList() throws Throwable {
	}
	
	@And("^I access the DCE Redesign on aarp site from Plan Summary for first plan$")
	public void accessDCERign_PlanSummary(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String plantype = memberAttributesMap.get("Plan Type");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		GetStartedPage getStartedPage = plansummaryPage.navigateToDCERedesignFromPlanSummary(plantype);
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}
	@And("^I access the DCE Redesign on aarp site from Plan Summary for mentioned plan$")
	public void accessDCERign_PlanSummaryforPlan(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String plantype = memberAttributesMap.get("Plan Type");
		String planName = memberAttributesMap.get("Plan Name");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		GetStartedPage getStartedPage = plansummaryPage.navigateToDCERedesignFromVPPPlanCard(plantype, planName);
		getLoginScenario().saveBean(DCERedesignCommonConstants.PLANTYPE, plantype);
		getLoginScenario().saveBean(DCERedesignCommonConstants.PLANNAME, planName);
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
		
	}
	
	@And("^the user clicks on the add drugs button to navigate to DCE Redesign in the profile in AARP site$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_profile_to_DCE_Redesign_in_AARP_site() {
		
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		GetStartedPage getStartedPage = visitorProfilePage.addDrug_DCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}	
	
	@Then("^the user navigates to Med Ed - Prescription Drugs Page$")
	public void the_user_navigates_to_Med_Ed_Prescription_Drugs_Page() throws Throwable {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acquisitionHomePage.navigateToMedEdPresDrugPage();

	}

	@Then("^the uset clicks on Estimate Drug Costs Link to land on DCE Redesign$")
	public void the_uset_clicks_on_Estimate_Drug_Costs_Link_to_land_on_DCE_Redesign() throws Throwable {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		GetStartedPage getStartedPage = acquisitionHomePage.clickDCERedesignLinkonMedEdPage();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}

	
	@Then("^the user navigates to Shop plans for PDP Page and clicks on DCE link fto land on DCE Redesign$")
	public void the_user_navigates_to_Shop_plans_for_PDP_Page_and_clicks_on_DCE_link_fto_land_on_DCE_Redesign()
			throws Throwable {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acquisitionHomePage.navigateToShopPDPpage();
		GetStartedPage getStartedPage = acquisitionHomePage.clickDCERedesignLinkonShopPDPpage();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");	
	}
	

	@Then("^the user clicks on Review Drug Costs to Land on Drug DetailsP Page$")
	public void the_user_clicks_on_Review_Drug_Costs_to_Land_on_Drug_DetailsP_Page() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugDetailsPage drugDetailsPage = DCEbuildDrugList.navigateToDrugDetailsPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates planName matches plan Name in VPP$")
	public void the_user_validates_planName_matches_plan_Name_in_VPP() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		
		String PlanName = (String) getLoginScenario().getBean(DCERedesignCommonConstants.PLANNAME);
		drugDetailsPage.validatePlanName(PlanName);
	}

	@Then("^the user validates Drug Costs section$")
	public void the_user_validates_Drug_Costs_section() throws Throwable {
	}

	@Then("^the user validates Your Drugs sections$")
	public void the_user_validates_Your_Drugs_sections() throws Throwable {
	}

	@Then("^the user validates Monthly Drug Costs by Stage Section$")
	public void the_user_validates_Monthly_Drug_Costs_by_Stage_Section() throws Throwable {
	}

	@Then("^the user validates Important information section$")
	public void the_user_validates_Important_information_section() throws Throwable {
	}

	@Then("^the user validates Disclaimers section$")
	public void the_user_validates_Disclaimers_section() throws Throwable {
	}
	
}
