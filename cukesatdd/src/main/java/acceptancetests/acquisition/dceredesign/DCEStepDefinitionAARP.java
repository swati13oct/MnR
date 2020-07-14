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

	@Then("^the user clicks on Build Drug List to navigate to Step (\\d+)$")
	public void the_user_clicks_on_Build_Drug_List_to_navigate_to_Step(int arg1) throws Throwable {
		GetStartedPage DCEgetStarted =(GetStartedPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_GetStarted);
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
	/*
	 * @Then("^the user clicks on Build Drug List to navigate to Step (\\d+)$")
	 * public void the_user_clicks_on_Build_Drug_List_to_navigate_to_Step(int arg1)
	 * throws Throwable { GetStartedPage DCEgetStarted =(GetStartedPage)
	 * getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
	 * BuildYourDrugList DCEbuildDrugList = DCEgetStarted.clickAddsDrugs();
	 * 
	 * }
	 */

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


	@Then("^the user clicks on Add Drug to Land on Zip Entry Page$")
	public void the_user_clicks_on_Add_Drug() throws Throwable {
		TellUsAboutDrug tellUsAboutDrug = (TellUsAboutDrug) getLoginScenario().getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrug.navigateToZipEntryPage();

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
}
