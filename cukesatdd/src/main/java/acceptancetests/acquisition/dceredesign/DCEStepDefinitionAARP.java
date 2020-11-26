package acceptancetests.acquisition.dceredesign;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.dceredesign.SwitchToGeneric;
import pages.acquisition.dceredesign.TellUsAboutDrug;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.PrescriptionsProvidersBenefitsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
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

	/* verify DCE flow from Ulayer home page hover over */
	@When("^I click on DCE Redesign link from Shop for a plan hover over$")
	public void i_click_on_DCE_Redesign_link_from_Shop_for_a_plan_hover_over_for_ums_site() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) loginScenario
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
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
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		/*
		 * if(null == druglist) { druglist = ""; }
		 */
		System.out.println("Setting Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}
	
	@Then("^the user clicks on Edit button on Drug List page on DCE$")
	public void the_user_clicks_on_EditButton(DataTable Attributes) throws Throwable {
		List<DataTableRow> plannameAttributesRow = Attributes.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String drug = plannameAttributesMap.get("DrugName");
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		
		TellUsAboutDrug tellUsAboutDrugPage = DCEbuildDrugList.clickOnEditButton(drug);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_TellUsAboutDrug,tellUsAboutDrugPage);
		
	}
	
	@Then("^the user clicks on Remove button on Drug List page on DCE to delete drug$")
	public void the_user_clicks_on_RemoveBtn(DataTable Attributes) throws Throwable {
		List<DataTableRow> plannameAttributesRow = Attributes.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String drug = plannameAttributesMap.get("DrugName");
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		
		
		DCEbuildDrugList.clickOnRemoveButton(drug);
		
	}
	
	@Then("^the user changes the supply length$")
	public void the_user_changesSupplyLength(DataTable Attributes) throws Throwable {
		List<DataTableRow> plannameAttributesRow = Attributes.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String supplyLength = plannameAttributesMap.get("Supply Length");
		TellUsAboutDrug tellUsAboutDrugPage = (TellUsAboutDrug) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrugPage.selectSupplyLength(supplyLength);
		BuildYourDrugList DCEbuildDrugList = tellUsAboutDrugPage.ClickAddDrug();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}
	/*
	 * 
	 * UnUSed Step...
	 * @Then("^the user clicks on Build Drug List to navigate to Step (\\d+)$")
	 * public void the_user_clicks_on_Build_Drug_List_to_navigate_to_Step(int arg1)
	 * throws Throwable { GetStartedPage DCEgetStarted = (GetStartedPage)
	 * getLoginScenario() .getBean(PageConstants.DCE_Redesign_GetStarted);
	 * BuildYourDrugList DCEbuildDrugList = DCEgetStarted.clickAddsDrugs();
	 * getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList,
	 * DCEbuildDrugList);
	 * 
	 * ZipCodePlanYearCapturePage zipCodePlanYearPage = new
	 * ZipCodePlanYearCapturePage(driver);
	 * zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
	 * getLoginScenario().saveBean(PageConstants.
	 * DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage); }
	 */
	
	@Then("^the user validates error message for blank search$")
	public void the_user_validates_error_message_for_blank_search() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEbuildDrugList.validateNoDrug_ErrorMsg();
	}

	@When("^the user clicks on Add drugs button$")
	public void the_user_clicks_on_Add_drugs_button() {
		GetStartedPage DCEgetStarted = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		BuildYourDrugList DCEbuildDrugList = DCEgetStarted.clickAddsDrugs();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList,DCEbuildDrugList);
	}

	@Then("^plan year dropdown should be displayed during AEP$")
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
		ZipCodePlanYearCapturePage zipCodePlanYearPage = new ZipCodePlanYearCapturePage(driver);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@Then("^user should be navigated to zipcode and plan year capture page for AEP$")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page_for_AEP_in_AARP() {
		/*
		 * ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage)
		 * getLoginScenario()
		 * .getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		 * zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		 */

		ZipCodePlanYearCapturePage zipCodePlanYearPage = new ZipCodePlanYearCapturePage(driver);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@Then("^the user validates No Drug found error message for search$")
	public void the_user_validates_No_Drug_found_error_message_for_search() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEbuildDrugList.validateDrugNotFound_ErrorMsg();
	}

	@Then("^user enter invalid zipcode$")
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
	public void user_enter_the_following_drug_info_and_validates_drug_autocomplete(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String PartialDrug = memberAttributesMap.get("DrugNameAutoComplete");
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
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
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrug tellUsAboutDrug = DCEbuildDrugList.SelectDrugfromList(DrugName);
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

		TellUsAboutDrug tellUsAboutDrug = (TellUsAboutDrug) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrug.validateBrandDrugPage(BrandDrugName, genericDrugName);
	}

	@Then("^the user selects following Drug Details$")
	public void the_user_selects_following_Drug_Details() throws Throwable {

	}

	@Then("^the user validates Blank Drug Quantity error message$")
	public void the_user_validates_Blank_Quantity_error_message() throws Throwable {
		TellUsAboutDrug tellUsAboutDrug = (TellUsAboutDrug) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrug.ValidateBlankQuantityError();

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
		TellUsAboutDrug tellUsAboutDrug = (TellUsAboutDrug) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		BuildYourDrugList DCEbuildDrugList = tellUsAboutDrug.ClickAddDrug();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		if(null == druglist) {
			druglist = "";
		}
		druglist = druglist + "&" + drugName;
		System.out.println("Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
}


	@Then("^the user clicks on Review Drug Costs to Land on Zip Entry Page$")
	public void the_user_clicks_on_Add_Drug() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		ZipCodePlanYearCapturePage zipCodePlanYearPage = DCEbuildDrugList.navigateToZipEntryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@Then("^user enters valid zipcode and county$")
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

	@When("^user selects plan year$")
	public void user_selects_plan_year_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.selectPlanYear();
	}

	@When("^user clicks on continue button in Zip Entry Page$")
	public void user_clicks_on_continue_button_ZipENtryPage_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		DrugSummaryPage drugSummaryPage = zipCodePlanYearPage.clickContinueBtn();
		// zipCodePlanYearPage.verifyLoadScreen();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user should be navigated to Review drug cost estimate page$")
	public void user_should_be_navigated_to_Review_drug_cost_estimate_page_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.verifyReviewDrugCostPageDisplayed();
	}

	@Then("^error message should be displayed$")
	public void error_message_should_be_displayed_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validateZipCodeErrorMessage();
	}

	/*
	 * Need to be removed. Instead, please use  - 
	 *     Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |


	 * @When("^adds drugs in drug list page$") public void
	 * adds_drugs_in_drug_list_page(DataTable givenAttributes) { List<DataTableRow>
	 * memberAttributesRow = givenAttributes.getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); } String drugName =
	 * memberAttributesMap.get("DrugName"); System.out.println("zipcode" +
	 * drugName); BuildYourDrugList buildDrugList = new BuildYourDrugList(driver);
	 * getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList,
	 * buildDrugList); buildDrugList.addDrugs(drugName); }
	 */	 
	
	@When("^user should verify the Extra help$")
	public void user_should_verify_the_Extra_help_in_AARP() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickOnSNPPlan();
		drugSummaryPage.verifyTheTextAlert();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user should verify the drug extra qualification in drug pricing popup$")
	public void user_should_verify_the_drug_extra_qualification_in_drug_pricing_popup_in_AARP() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.verifyDrugPricingText();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugSummaryPage);
	}
	
	@When("^clicks on Review drug cost button$")
	public void clicks_on_Review_drug_cost_button() {
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		buildDrugList.clickReviewDrugCostBtn();
	}

	@Then("^load screen should be displayed$")
	public void load_screen_should_be_displayed_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		// zipCodePlanYearPage.verifyLoadScreen();
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
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrug tellUsAboutDrug = buildDrugList.SearchaddDrugs(drugName);
		buildDrugList = tellUsAboutDrug.ClickAddDrug();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		/*
		 * if(druglist.isEmpty()) { druglist = ""; }
		 */		
		System.out.println("Drugs List : " + druglist);

		druglist = druglist + "&" + drugName;
		System.out.println("Drugs List after Drug "+drugName+" , Added : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}


	@Then("^the user edits supply length to three months for following drug$")
	public void the_user_edits_supply_length_to_three_months_for_following_drug(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String drugName = memberAttributesMap.get("EditDrug");
		System.out.println(drugName);
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrug tellUsAboutDrug = buildDrugList.EditDrug(drugName);
		tellUsAboutDrug.selectSupplyLength("3 Months");
		buildDrugList = tellUsAboutDrug.ClickAddDrug();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}
	
	@Then("^the user tries to add following drug over cabinet limit and validates error modal$")
	public void the_user_searches_and_adds_and_validates_drug_cabinet_limit(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String drugName = memberAttributesMap.get("DrugName");
		System.out.println(drugName);
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		buildDrugList.SearchValidate_DrugCountError(drugName);
	}

	@Then("^the user validates all added drugs in DrugList$")
	public void the_user_validates_all_added_drugs_in_DrugList() throws Throwable {
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		buildDrugList.ValidateAddedDrugsList(druglist);
	}
	
	@And("^I access the DCE Redesign from Plan Summary for mentioned plan$")
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
		plansummaryPage.handlePlanYearSelectionPopup("current");
		GetStartedPage getStartedPage = plansummaryPage.navigateToDCERedesignFromVPPPlanCard(plantype, planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
		
	}
	
	@And("^the user click on return to plan summary from Get Started Page to return to VPP Plan Summary$")
	public void the_user_clicks_on_returnlink_to_vpp_planSummary_Getstarted() {
		GetStartedPage getStartedPage = (GetStartedPage) getLoginScenario().
				getBean(PageConstants.DCE_Redesign_GetStarted);
		VPPPlanSummaryPage plansummaryPage  = getStartedPage.ClickReturnToBtnToVPPSummary();
		if (null != plansummaryPage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}	
	
	@And("^the user click on return to plan summary from Drug Details Page to return to VPP Plan Summary$")
	public void the_user_clicks_on_returnlink_to_vpp_planSummary_DrugDetails() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		VPPPlanSummaryPage plansummaryPage  = drugDetailsPage.ClickReturnToBtnToVPPSummary();
		if (null != plansummaryPage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}
	
	@And("^the user clicks on Edit your drug list link on drug details page$")
	public void the_user_clicks_on_editDrugLink_on_DrugDetails() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		BuildYourDrugList buildDrugList  = drugDetailsPage.clickOnEditDrugListLink();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}
	
	@And("^the user clicks on Return to details link on Drug Details page$")
	public void the_user_clicks_on_returnlink_DrugDetails() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		PlanDetailsPage planDetailsPage = drugDetailsPage.clickReturnToDetailsLink();
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetailsPage);
		
	}

//	LearnMore changes Start
	@Then("^the user clicks PrescriptionBenifit Tab on Plan Details Page$")
	public void the_user_clicks_PrescriptionBenifit_Tab_on_Plan_Details_Page() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		plandetailspage.clickPrescriptionBenifitTab();
}

	@Then("^the user clicks Learn More button on Prescription Drug Costs Tab on Plan Details Page$")
	public void the_user_clicks_Learn_More_button_on_Prescription_Drug_Costs_Tab_on_Plan_Details_Page() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		DrugDetailsPage drugDetailsPage = plandetailspage.clickLearnMore();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	@Then("^the user validates planName on LearnMore page matches plan Name in VPP$")
	public void the_user_validates_planName_on_LearnMore_page_matches_plan_Name_in_VPP() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanNameLearnMore(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
//	LearnMore changes End
	@Then("^I access the DCE Redesign from Plan Details for the plan$")
	public void the_user_navigates_to_Presciption_Drug_Benefits_tab_in_AARP_site() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		GetStartedPage getStartedPage = plandetailspage.navigateToDCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}


	@Then("^the user Clicks button to VPP Plan Details Page from Drug Details Page$")
	public void the_user_Clicks_button_to_VPP_Plan_Details_Page_from_Drug_Details_Page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		PlanDetailsPage plandetailspage = drugDetailsPage.ClickandNavigate_VPPPlanDetails(PlanName);
		if (null != plandetailspage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		} else
			Assert.fail("VPP Plan Details not loaded");	
	}
	

	@Then("^the user clicks on return to compare link on build drug list page to returns to plan compare$")
	public void the_user_Clicks_button_to_VPP_Plan_Compare_Page_from_Drug_details_Page() throws Throwable {
		BuildYourDrugList buildDrugListPage = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		ComparePlansPage planComparePage = buildDrugListPage.returnToPlanComparePage();
		if (null != planComparePage) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else
			Assert.fail("VPP Plan Compare not loaded");	
	}
	
	@Then("^the user validates drug is displayed on the plan compare page$")
	public void the_userValidatesDrugInfo(DataTable attributes) throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		
		String drug = memberAttributesRow.get(0).getCells().get(1);
		planComparePage.validateDrugInfo(drug);
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

	}

	@And("^the user clicks on the add drugs button to navigate to DCE Redesign on the profile page$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_profile_to_DCE_Redesign_in_AARP_site() {
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		GetStartedPage getStartedPage = visitorProfilePage.addDrug_DCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, getStartedPage);
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
	

	@Then("^the user clicks on Review Drug Costs to Land on Drug Details Page$")
	public void the_user_clicks_on_Review_Drug_Costs_to_Land_on_Drug_DetailsP_Page() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugDetailsPage drugDetailsPage = DCEbuildDrugList.navigateToDrugDetailsPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	@Then("^the user verify the Retail chain pharmacy on detail page$")
	public void the_user_verify_the_Retail_chain_pharmacy_on_detail_page() throws Throwable {
		DrugDetailsPage drugDetailPage = new DrugDetailsPage(driver);
		drugDetailPage.validateRetailChainPharmacy();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailPage);
	}

	@Then("^the user validates planName matches plan Name in VPP$")
	public void the_user_validates_planName_matches_plan_Name_in_VPP() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanName(PlanName);
	}
	
	@Then("^the user verify the drug cost estimator and view plan summary on VPP detail page in AARP$")
	public void the_user_verify_the_drug_cost_estimator() throws Throwable {
		Thread.sleep(10000);
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		
		drugDetailsPage.validateDrugandPanButton();
	}
	
	@Then("^the user verify the drug cost estimator and view plan summary on VPP summary page in AARP$")
	public void the_user_verify_the_drug_cost_estimator_summary() throws Throwable {
		Thread.sleep(10000);
		DrugSummaryPage drugDetailsPage = (DrugSummaryPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		
		drugDetailsPage.validateDrugandPanButton();
	}
	
	@Then("^the user click on drug cost estimator on vpp plan detail page in AARP$")
	public void the_user_click_on_drug_cost_estimator() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		
		drugDetailsPage.clickOnBacktoDrugBtn();
	}
	
	@Then("^the user click on view plan summary on vpp detail page$")
	public void the_user_click_on_drug_cost_estimator_details() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.clickOnvppPlan();
	}
	
	@Then("^Then user click on veiw plan details on summary page in AARP$")
	public void the_user_click_on_view_plan_details() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		
		drugDetailsPage.clickOnvppPlanDetails();
	}
	
	@Then("^the user click on drug cost estimator on vpp plan summary page in AARP$")
	public void the_user_click_on_drug_cost_estimator_summary() throws Throwable {
		DrugSummaryPage drugDetailsPage = (DrugSummaryPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		
		drugDetailsPage.clickOnBacktoDrugBtn();
	}
	
	@Then("^User validates planName matches plan Name in DCE detail page in AARP$")
	public void the_user_validates_matches_planname() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanDrugDetails(PlanName);
	}
	
	@Then("^User validates planName matches plan Name in DCE summary page in AARP$")
	public void the_user_validates_summary_planname() throws Throwable {
		DrugSummaryPage drugDetailsPage = (DrugSummaryPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanDrugDetails(PlanName);
	}

	@Then("^the user validates Drug Costs section$")
	public void the_user_validates_Drug_Costs_section() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDrugCosts();
	}

	@Then("^the user verify the extra help alert message on Drug Detail Page$")
	public void the_user_verify_the_extra_help_alert_message_on_Drug_Detail_Page() throws Throwable {
		DrugDetailsPage drugDetailPage = new DrugDetailsPage(driver);
		drugDetailPage.validateExtraHelpAlert();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailPage);
	}
	
	
	@Then("^the user validates Your Drugs sections$")
	public void the_user_validates_Your_Drugs_sections() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateYourDrugs();
	}

	@Then("^the user validates Monthly Drug Costs by Stage Section$")
	public void the_user_validates_Monthly_Drug_Costs_by_Stage_Section() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateMonthlyCostStage();
	}
	
//	MonthlyDrugCost Changes Start
	@Then("^the user validates Monthly Drug Costs$")
	public void the_user_validates_Monthly_Drug_Costs() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateMonthlyCost();
	}
//	MonthlyDrugCost Changes End
	
	@Then("^the user validates Monthly Drug Costs by Stage Info Modals$")
	public void the_user_validates_Monthly_Drug_Costs_by_Stage_Info_Modals() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDrugStageInfoModals();
	}

	@Then("^the user validates Important information section$")
	public void the_user_validates_Important_information_section() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateImportantInfo();
	}

	@Then("^the user validates Disclaimers section$")
	public void the_user_validates_Disclaimers_section() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDisclaimerAccordian();
	}

	@Then("^the user validates link to Drug Summary Page$")
	public void the_user_validates_link_to_Drug_Summary_Page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		DrugSummaryPage drugSummaryPage = drugDetailsPage.ClickLinktoNavigatetoDrugSummary();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);

	}

	@Then("^the user validates Drug List in Your Drugs Section on Drug Details Page$")
	public void the_user_validates_druglist_yourDrugs_DrugDetailsPage() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		drugDetailsPage.ValidatesDrugsList(druglist);

	}

	@Then("^the user validates Drug List in Monthly Drug Costs by Stage Section on Drug Details Page$")
	public void the_user_validates_druglist_monthly_drug_costs_stage_DrugDetailsPage() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		drugDetailsPage.ValidatesDrugsList_MonthlyDrugStage(druglist);

	}

	@Then("^the user Validates All Tier info and Drug Limits displayed on Your Drugs Section on Drug Details Page$")
	public void the_user_validates_tiers_drugLimits_yourDrugs_DrugDetailsPage() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.ValidatesDrugsTier_LimitsDisplayed();
	}

	@Then("^the user Validates All Tier info and Drug Limits details displayed in Important Information Section on Drug Details Page$")
	public void the_user_validates_tiers_drugLimits_importantInfo_DrugDetailsPage() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.ValidatesDrugsTier_Limits_ImportantInfo();
	}

	@Then("^the user selects View Drug details for following plantype and PlanName$")
	public void the_user_selects_View_Drug_details_for_following_plantype_and_PlanName(DataTable attributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String plantype = memberAttributesMap.get("Plan Type");
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		DrugDetailsPage drugDetailsPage = drugSummaryPage.clickViewDrugDetailsForPlan(plantype, planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user Captures Drug costs on Drug Details Page$")
	public void the_user_Captures_Drug_costs_on_Drug_Details_Page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		Map<String, String> DrugCosts = drugDetailsPage.CaptureDrugCosts();
		String AVG_MONTHLY = DrugCosts.get("AVG_MONTHLY");
		String MONTHLY_PREMIUM = DrugCosts.get("MONTHLY_PREMIUM");
		String ANNUAL_ESTIMATED_TOTAL = DrugCosts.get("ANNUAL_ESTIMATED_TOTAL");
		String COVERED_DRUGS_COUNT = DrugCosts.get("COVERED_DRUGS_COUNT");

		System.out.println(DrugCosts);
		getLoginScenario().saveBean(DCERedesignCommonConstants.AVG_MONTHLY, AVG_MONTHLY);
		getLoginScenario().saveBean(DCERedesignCommonConstants.MONTHLY_PREMIUM, MONTHLY_PREMIUM);
		getLoginScenario().saveBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL, ANNUAL_ESTIMATED_TOTAL);
		getLoginScenario().saveBean(DCERedesignCommonConstants.COVERED_DRUGS_COUNT, COVERED_DRUGS_COUNT);
	}


	@Then("^the user validates Estimated Annual Drug Costs on Prescription Drug Costs Tab on Plan Details Page$")
	public void the_user_validates_Estimated_Drug_Costs_on_Prescription_Drug_Costs_Tab_on_Plan_Details_Page() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String EstimatedDrugCosts = plandetailspage.costComparisonPrescriptionDrugFromDCE();
		String cost = (String) getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		if(cost.trim().contains(EstimatedDrugCosts))
			Assert.assertTrue("It's a match on on prescription drug tab and Drug CostEstimator page; Expected : "+cost+"; Actual : "+EstimatedDrugCosts,true);
		else
		Assert.assertTrue("Cost mismatch on prescription drug tab and drug CostEstimator page; Expected : "+cost+"; Actual : "+EstimatedDrugCosts,false);
		
}

	@When("^user verify the drug summary page$")
	public void user_verify_the_drug_summary_page() throws InterruptedException {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateDrugSummaryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user should be able to see Medicare Advantage plan by default$")
	public void user_should_be_able_to_see_Medicare_Advantage_plan_by_default() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.verifyDefaultPlanType();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user click on view plan details on drug summary page$")
	public void user_click_on_view_plan_details_on_drug_summary_page() throws Throwable {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.clickOnViewPlan();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}


	@Then("^user saves plan as favorite on drug summary page AARP site$")
	public void user_saves_plan_as_favorite_on_drug_summary_AARP_site(DataTable givenAttributes) throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
		/*VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		plansummaryPage.savePlan(PlanName);*/
	}
	@Then("^user save PDP plan as favorite on drug summary page AARP site$")
	public void user_saves_pdp_plan_as_favorite_on_drug_summary_AARP_site(DataTable givenAttributes) throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.clickOnPDPPlan();
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@Then("^user save SNP plan as favorite on drug summary page AARP site$")
	public void user_saves_snp_plan_as_favorite_on_drug_summary_AARP_site(DataTable givenAttributes) throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.clickOnSNPPlan();
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@And ("^user click on return to home on drug summary in AARP site$")
	public void user_click_on_return_to_home_on_drug_summary_in_AARP_site() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickOnReturnToHome();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user should be able to toggle between plan types$")
	public void user_should_be_able_to_toggle_between_plan_types() throws InterruptedException  {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.verifyPDPPlanToggle();
		drugSummaryPage.verifySNPPlanToggle();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user clicks on change pharmacy link from summary page$")
	public void user_clicks_on_change_pharmacy_link_from_summary_page_in_AARP() throws InterruptedException  {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickChangePharmacy();
	}
	

	@Then("^the user selects following pharmacy and returns to DCE Summary page$")
	public void the_user_selects_following_pharmacy_and_returns_to_DCE_Summary_page(DataTable givenAttributes) throws Throwable {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String PharmacytoSelect = memberAttributesMap.get("SelectPharmacy");
		drugSummaryPage.SelectPharmacy(PharmacytoSelect);
		drugSummaryPage.validatePharmacyName(PharmacytoSelect);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);

	}

	@Then("^change pharmacy modal should be displayed$")
	public void change_pharmacy_modal_should_be_displayed_in_AARP() throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.selectPharmacyModalDisplayed();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user verify change pharmacy modal$")
	public void user_verify_change_pharmacy_modal_in_AARP() throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateSelectPharmacyPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user clicks view drug cost button$")
	public void user_clicks_view_drug_cost_button_in_AARP() throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickViewDrugCostBtn();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user clicks on change pharmacy link from details page$")
	public void user_clicks_on_change_pharmacy_link_from_details_page_in_AARP() throws InterruptedException {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.clickChangePharmacyLinkDetailsPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^details page change pharmacy modal should be displayed$")
	public void details_page_change_pharmacy_modal_should_be_displayed_in_AARP() throws InterruptedException {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.selectPharmacyModalDisplayed();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	@Then("^user verify details page change pharmacy modal$")
	public void user_verify_details_page_change_pharmacy_modal_in_AARP() throws InterruptedException {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateSelectPharmacyPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	@When("^user click on View Drug Pricing Modal$")
	public void User_click_on_View_Drug_Pricing_Modal_in_AARP() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickViewPricing();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user click on Switch To Generic$")
	public void User_click_on_Switch_To_Generic_in_AARP() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.clickswitchToGeneric();
		
	}
	

	@When("^user verify drug can switch to generic drug$")
	public void user_verify_drug_can_switch_to_generic_drug_aarp(DataTable givenAttributes) throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String drugName = memberAttributesMap.get("DrugName");
		System.out.println(drugName);
		
		drugSummaryPage.verifyDrugListsUpdated(drugName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@Then("^I access the DCE Redesign from Plan compare page$")
	public void the_user_navigates_to_dce_from_plan_compare_site() throws Throwable {
		ComparePlansPage planComparepage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		/*
		 * if(druglist.isEmpty()) { druglist = "";
		 * getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST,druglist); }
		 */
		BuildYourDrugList DCEbuildDrugList = planComparepage.navigateToDCERedesign();
		if (null != DCEbuildDrugList) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}


	@When("^user change the pharmacy to view no prescription coverage$")
	public void user_change_pharmacy_from_details_page_in_AARP() throws InterruptedException {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.changePharmacyAndSave();
		drugDetailsPage.validatePharmVlaues();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	/*
	 * @When("^user validate the monthly premium value on detail page$") public void
	 * user_validate_monthly_value_in_AARP() throws InterruptedException {
	 * DrugDetailsPage drugDetailsPage = new DrugDetailsPage(driver);
	 * drugDetailsPage.validatePharmVlaues();
	 * getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails,
	 * drugDetailsPage); }
	 */
	
	@When("^user clicks on Keep Using This Pharmacy on change pharmacy page")
	public void user_clicks_on_keep_using_pharmacy() throws InterruptedException {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateAndClickKeepPharm();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	@When("^User validate Walgreens pharmacy on detail page")
	public void user_validate_pharmacy() throws InterruptedException {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateAndClickKeepPharm();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	@When("^user click on PDP plan to view drug pricing$")
	public void User_click_on_PDP_plan_in_AARP() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickOnPdpPlan();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	

	@When("^user click on lipitor Switch To Generic$")
	public void User_click_on_lipitor_Switch_To_Generic_in_AARP() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clicklipitorswitchToGeneric();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@Then("^the user verifies the catastrophic coverage message$")
	public void the_user_verifies_the_catastrophic_coverage_message(DataTable givenAttributes) throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String catastrophicMessage = memberAttributesMap.get("catastrophicCoverage");
		drugDetailsPage.validateCatastrophicCoverageMessage(catastrophicMessage);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user verifies the coverage gap message$")
	public void the_user_verifies_the_coverage_gap_message(DataTable givenAttributes) throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String coverageGapMessage = memberAttributesMap.get("coverageGap");
		drugDetailsPage.validateCoverageGapMessage(coverageGapMessage);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	@Then("^user saves plan as favorite on drug summary page$")
	public void user_saves_plan_as_favorite_on_drug_summary(DataTable givenAttributes) throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user saves plan as favorite on drug details page$")
	public void user_saves_plan_as_favorite_on_drug_details(DataTable givenAttributes) throws InterruptedException {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		drugDetailsPage.validatePlanName(PlanName);
		drugDetailsPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@And("^the user clicks on the heart icon on Drug Details page$")
	public void the_user_clicks_on_the_shopping_cart_icon_on_Drug_details_page() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		VisitorProfilePage visitorProfilePage = drugDetailsPage.navigateToVisitorProfilePage();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	@Then("^user navigates to Review drug costs page$")
	public void user_navigates_to_Review_drug_costs_page() {
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugSummaryPage drugSummaryPage = buildDrugList.verifyReviewDrugCostPage();
		if (null != drugSummaryPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}
	
	@Then("^user validates planName matches plan Name in Drug Details pages$")
	public void the_user_validates_matches_planname_in_Drug_Details() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanDrugDetails(PlanName);
	}
	
	@And("^the user clicks on DCE button to return to Review Drug cost page$")
	public void the_user_clicks_on_DCE_return_Review_Drug_cost_page() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		DrugDetailsPage drugDetailsPage = plandetailspage.returnToReviewDrugCost();
		
		
	}

	@Then("^the user selects View plan details for following plantype and PlanName$")
	public void the_user_selects_View_plan_details_for_following_plantype_and_PlanName(DataTable attributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
	
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String plantype = memberAttributesMap.get("Plan Type");
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPage plansummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		PlanDetailsPage plandetailspage= plansummaryPage.clickViewplanDetailsForPlan(plantype, planName);
		//getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		getLoginScenario().saveBean(DCERedesignCommonConstants.PLANTYPE, plantype);
		getLoginScenario().saveBean(DCERedesignCommonConstants.PLANNAME, planName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, planName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);

		
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		
	}

	
	@Then("^the user validates Switch to generic for following Brand Drug and validate Generic drug on Details Page$")
	public void the_user_validates_Switch_to_generic_for_following_Brand_Drug_and_validate_Generic_drug_on_Details_Page(DataTable givenAttributes) throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String BrandDrug = memberAttributesMap.get("Brand Drug");
		String GenericDrug = memberAttributesMap.get("Generic Drug");
		SwitchToGeneric switchToGenericPage = drugDetailsPage.clickSwitchGeneric(BrandDrug);
		switchToGenericPage.validateSwitchPage(GenericDrug, BrandDrug);
		drugDetailsPage = switchToGenericPage.ClickSwitch_ReturnDetailsPage();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		druglist = druglist.replace(BrandDrug, GenericDrug);
		System.out.println("Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);

		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates Switch to generic for following Brand Drug to Generic from Drug Summary - Drug Pricing Modal$")
	public void the_user_validates_Switch_to_generic_for_following_Brand_Drug_to_Generic_drug_from_Summary_Page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String BrandDrug = memberAttributesMap.get("Brand Drug");
		String GenericDrug = memberAttributesMap.get("Generic Drug");
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		SwitchToGeneric switchToGenericPage = drugSummaryPage.clickSwitchGeneric(BrandDrug);
		switchToGenericPage.validateSwitchPage(GenericDrug, BrandDrug);
		drugSummaryPage = switchToGenericPage.ClickSwitch_ReturnSummaryPage();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		druglist = druglist.replace(BrandDrug, GenericDrug);
		System.out.println("Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);

		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user verifies Drug List on DCE Summary Page - Drug Pricing Modal$")
	public void the_user_validates_druglist_Drugs_DrugSummaryPage() throws Throwable {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		drugSummaryPage.ValidatesDrugsList(druglist);

	}
	
	@Then("^the user clicks Edit Drug on Drug Details Page and validates user navigates to Build your drug list Page$")
	public void the_user_clicks_Edit_Drug_on_Drug_Details_Page_and_validates_user_navigates_to_Build_your_drug_list_Page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		BuildYourDrugList buildDrugListPage = drugDetailsPage.clickEditDrugs();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugListPage);

	}

	@Then("^the user deletes the following drug from Drug list$")
	public void the_user_deletes_the_following_drug_from_Drug_list(DataTable givenAttributes) throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		BuildYourDrugList buildDrugListPage = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String DeleteDrug = memberAttributesMap.get("DrugName");
		buildDrugListPage.deleteDrug(DeleteDrug);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		System.out.println("Drug List before Delete Drug : "+druglist);
		druglist = druglist.replace("&"+DeleteDrug, "");
		System.out.println("Updated Drugs List after Delete Drug : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

		
	}

	@Then("^the user validates Dynamic Copay Section for following Pharmacy selection$")
	public void the_user_validates_Dynamic_Copay_Section_for_following_Pharmacy_selection(DataTable givenAttributes) throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String PharmacyTypeSelected = memberAttributesMap.get("Pharmacy Selection");
		if(PharmacyTypeSelected.contains("Preferred Retail")) {
			drugDetailsPage.validatePreferredRetailCopaySection();
		}
		else if(PharmacyTypeSelected.contains("Standard Retail")) {
			drugDetailsPage.validateStandardRetailCopaySection();
		}
		else if(PharmacyTypeSelected.contains("Standard Mail")) {
			drugDetailsPage.validateStandardMailCopaySection();
		}
		else if(PharmacyTypeSelected.contains("Preferred Mail")) {
			drugDetailsPage.validatePreferredMailCopaySection();
		}
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}


	@Then("^the user selects Mail Pharmacy and returns to DCE Details page$")
	public void the_user_selects_Mail_Pharmacy_and_returns_to_DCE_Details_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.SelectMailPharmacy();
		String pharmacy = "Preferred Mail Service Pharmacy"; 
		drugDetailsPage.validatePharmacyName(pharmacy);
		getLoginScenario().saveBean(PageConstants.PHARMACY_NAME, pharmacy);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^the user selects following Standard pharmacy and returns to DCE Details page$")
	public void the_user_selects_following_Standard_pharmacy_and_returns_to_DCE_Details_page(DataTable givenAttributes) throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
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
	

	@Then("^the user validates following expected Premium on DCE Details Page$")
	public void the_user_validates_following_expected_Premium_on_DCE_Details_Page(DataTable arg1) throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
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

	@Then("^the user validates following premium for the following plan on DCE Summary Page$")
	public void the_user_validates_following_premium_for_the_following_plan_on_DCE_Summary_Page(DataTable arg1) throws Throwable {
		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String Premium = memberAttributesMap.get("Premium");
		String PlanType = memberAttributesMap.get("Plan Type");
		String PlanName = memberAttributesMap.get("Plan Name");
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validatePremiumForPlan(Premium,PlanType,PlanName );
	}
	
	@Then("^the user Captures Drug costs on Drug Summary Page for the given plan$")
	public void the_user_Captures_Drug_costs_on_Drug_Summary_Page_For_Given_Plan(DataTable attributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		Map<String, String> DrugCosts = drugSummaryPage.captureDrugCosts(planName);
		String AVG_MONTHLY = DrugCosts.get("AVG_MONTHLY");
		String MONTHLY_PREMIUM = DrugCosts.get("MONTHLY_PREMIUM");
		String ANNUAL_ESTIMATED_TOTAL = DrugCosts.get("ANNUAL_ESTIMATED_TOTAL");
		String COVERED_DRUGS_COUNT = DrugCosts.get("COVERED_DRUGS_COUNT");
		System.out.println(DrugCosts);
		getLoginScenario().saveBean(DCERedesignCommonConstants.AVG_MONTHLY_DRUG_SUMMARY, AVG_MONTHLY);
		getLoginScenario().saveBean(DCERedesignCommonConstants.MONTHLY_PREMIUM_DRUG_SUMMARY, MONTHLY_PREMIUM);
		getLoginScenario().saveBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL_DRUG_SUMMARY, ANNUAL_ESTIMATED_TOTAL);
		getLoginScenario().saveBean(DCERedesignCommonConstants.COVERED_DRUGS_COUNT_DRUG_SUMMARY,COVERED_DRUGS_COUNT);
	}

	@Then("^the user compares drug costs for drug details and drug summary pages$")
	public void the_user_compares_drug_costs_for_drug_details_and_drug_summary() throws Throwable {
		String drugSummaryAvgMonthly = (String)getLoginScenario().getBean(DCERedesignCommonConstants.AVG_MONTHLY_DRUG_SUMMARY);
		String drugSummaryMonthlyPremium =(String)getLoginScenario().getBean(DCERedesignCommonConstants.MONTHLY_PREMIUM_DRUG_SUMMARY);
		String drugSummaryAnnualEstimated =(String)getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL_DRUG_SUMMARY);
		String drugSummaryDrugCount =(String)getLoginScenario().getBean(DCERedesignCommonConstants.COVERED_DRUGS_COUNT_DRUG_SUMMARY);
		String drugDetailsAvgMonthly =(String)getLoginScenario().getBean(DCERedesignCommonConstants.AVG_MONTHLY);
		String drugDetailsMonthlyPremium =(String)getLoginScenario().getBean(DCERedesignCommonConstants.MONTHLY_PREMIUM);
		String drugDetailsAnnualEstimated =(String)getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		String drugDetailsDrugCount =(String)getLoginScenario().getBean(DCERedesignCommonConstants.COVERED_DRUGS_COUNT);
		
		if(drugSummaryAvgMonthly.equals(drugDetailsAvgMonthly) && drugSummaryMonthlyPremium.equals(drugDetailsMonthlyPremium) && drugSummaryAnnualEstimated.equals(drugDetailsAnnualEstimated) && drugDetailsDrugCount.equals(drugSummaryDrugCount))
			System.out.println("Drug costs mathced");
		else
			Assert.fail("Drug costs between drug details and drug summary didn't match");
		
	}
	
	@Then("^the user verifies the added pharmacy on prescription drug tab$")
	public void the_user_verifies_pharmacy_on_prescription_drug_tab() throws Throwable {
		PlanDetailsPage planDetailsPage = (PlanDetailsPage)getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String pharmacyName = (String)getLoginScenario().getBean(PageConstants.PHARMACY_NAME);
		planDetailsPage.verifyPharmacyAdded(pharmacyName);
		
	}
	
	@Then("^the user validates Insulin savings on Copay section, Your Drugs and Important Information Section$")
	public void the_user_validates_Insulin_savings_on_Copay_section_Your_Drugs_and_Important_Information_Section(DataTable arg1) throws Throwable {
		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String InsulinCopay = memberAttributesMap.get("InsulinCopay");
		String InsulinDrug = memberAttributesMap.get("Insulin Drug");
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateInsulinTier_CopaySection(InsulinCopay);
		drugDetailsPage.validateInsulinDrug_YourDrugs(InsulinDrug,InsulinCopay );
		drugDetailsPage.validateInsulinText_ImportantInfo();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
		
	}


	@Then("^the user validates Covered Drug display for NC Pharmacy selection$")
	public void the_user_validates_Covered_Drug_display_for_NC_Pharmacy_selection() throws Throwable {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.ValidateNCPharmacyCoveredDrugs();
	}
	
	

	@Then("^the user clicks on View Drug Information link for the following Plan and lands on DCE details$")
	public void the_user_clicks_on_View_Drug_Information_link_for_the_following_Plan_and_lands_on_DCE_details(DataTable arg1) throws Throwable {
		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planName = memberAttributesMap.get("PlanName");
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		planComparePage.clickViewDrugInfoLinkForPlan(planName);
		String drugYouPaylist = planComparePage.validateDrugListCaptureDrugYouPay(druglist);
		DrugDetailsPage drugDetailsPage = planComparePage.clickDrugCostDetails_DrugInfoModal();
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME,planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME,planName);

		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST,druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS,drugYouPaylist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	@Then("^the user clicks on View Plan Compare button and validates Plan Compare page, Drug Info Modal$")
	public void the_user_clicks_on_View_Plan_Compare_button_and_validates_Plan_Compare_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		String drugYouPaylist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS);
		drugDetailsPage.validateDrugListYouPay_FromComparePage(druglist, drugYouPaylist);
		ComparePlansPage planComparePage = drugDetailsPage.clickViewPlanCompareBtn_ReturnToCompare_ViewDrugModal();
		if (null != planComparePage) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else
			Assert.fail("VPP Plan Compare not loaded");	
	}

	@Then("^the user clicks on Back to Compare link and validates Plan Compare page, Drug Info Modal$")
	public void the_user_clicks_on_Back_to_Compare_link_and_validates_Plan_Compare_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		String drugYouPaylist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS);
		drugDetailsPage.validateDrugListYouPay_FromComparePage(druglist, drugYouPaylist);
		ComparePlansPage planComparePage = drugDetailsPage.clickViewBackCompareLink_ReturnToCompare_ViewDrugModal();
		if (null != planComparePage) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else
			Assert.fail("VPP Plan Compare not loaded");	
	}

	@Then("^the user closes the Drug Info Modal on Plan Compare page$")
	public void the_user_closes_the_Drug_Info_Modal_on_Plan_Compare_page() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.CloseDrugInfoModal();
	}

	@Then("^the user clicks on Edit Drug link and validates user lands on DCE Build Drug List Page$")
	public void the_user_clicks_on_Edit_Drug_link_and_validates_user_lands_on_DCE_Build_Drug_List_Page() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		BuildYourDrugList DCEbuildDrugList = planComparePage.clickonEdityourDrugs();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}

	@Then("^the user validates all added Drugs on Plan Compare$")
	public void the_user_validates_all_added_Drugs_on_Plan_Compare() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		planComparePage.ValidatesAddedDrugsList(druglist);
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

	}
	@Then("the user click on return to MEdEd page from Get Started Page")
	public void user_click_to_return_to_MedEd_page(){
		GetStartedPage getStartedPage = (GetStartedPage) getLoginScenario().
				getBean(PageConstants.DCE_Redesign_GetStarted);
		

		PrescriptionsProvidersBenefitsPage benefitsPage= getStartedPage.clickReturnToAcqHomePAge();
		if (null != benefitsPage) {
			getLoginScenario().saveBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE, benefitsPage);
		} else
			Assert.fail("Benefit Page not loaded");
	}
	@Then("^user should be navigated to first step of DCE Page$")
	public void the_user_navigated_to_first_step_of_DCE_Page() {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		GetStartedPage DCEgetStarted = new GetStartedPage(driver);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, DCEgetStarted);
		
	}
	
	@When("^user clicks on Return to plan summary page link in DCE$")
	public void user_clicks_on_Return_to_plan_summary_page_link_in_DCE() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickReturnToPlanSummary();
	}
	
	@When("^user clicks on Return to home page link in DCE$")
	public void user_clicks_on_Return_to_home_page_link_in_DCE() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickReturnToHomePage();
	}
	
	@Then("^the user clicks VPP Plan Details button from Drug Details Page$")
	public void the_user_clicks__VPP_Plan_Details_button_from_Drug_Details_Page() throws Throwable {
		DrugDetailsPage drugDetailsPage = new DrugDetailsPage(driver);
		PlanDetailsPage plandetailspage = drugDetailsPage.clickViewPlanDetailsBtn();
		if (null != plandetailspage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		} else
			Assert.fail("VPP Plan Details not loaded");	
	}
	
	@Then("^the user click on view plan summary button on vpp detail page$")
	public void the_user_click_on_view_plan_summary_details() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		VPPPlanSummaryPage plansummaryPage=plandetailspage.clickViewPlanSummaryBtn();
		if(null!=plansummaryPage){
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else
			Assert.fail("VPP Plan Details not loaded");	
	}
	
	@Then("^the user clicks on Estimate Drug Costs Link from Benefit Page to land on DCE Redesign$")
	public void the_user_clicks_on_Estimate_Drug_Costs_Link_from_Benefit_page_to_land_on_DCE_Redesign() throws Throwable {
		PrescriptionsProvidersBenefitsPage benefitsPage= (PrescriptionsProvidersBenefitsPage)getLoginScenario().getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
		  
		GetStartedPage getStartedPage = benefitsPage.clickDCERedesignLinkonMedEdPage();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}
	
}