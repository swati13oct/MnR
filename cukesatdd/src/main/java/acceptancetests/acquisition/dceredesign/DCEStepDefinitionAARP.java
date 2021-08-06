package acceptancetests.acquisition.dceredesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.PrescriptionsProvidersBenefitsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.dceredesign.*;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;

/**
 * Functionality:DCE Acquisition
 */
public class DCEStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	private WebDriver driver;

	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

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
			Assertion.fail("DCE Redesign page object not loaded");
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
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^the user clicks on Build Drug List to navigate to Build Drug List Page$")
	public void the_user_clicks_on_Build_Drug_List_to_navigate_to_Build_DrugList() throws Throwable {
		GetStartedPage DCEgetStarted = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		BuildYourDrugList DCEbuildDrugList = DCEgetStarted.clickAddsDrugs();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		
		if (druglist == null) {
			druglist = "";
		}
		 
		System.out.println("Setting Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}

	@Then("^the user clicks on Edit button on Drug List page on DCE$")
	public void the_user_clicks_on_EditButton(DataTable Attributes) throws Throwable {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		/*List<DataTableRow> plannameAttributesRow = Attributes.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Attributes);
		String drug = plannameAttributesMap.get("DrugName");
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);

		TellUsAboutDrug tellUsAboutDrugPage = DCEbuildDrugList.clickOnEditButton(drug);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_TellUsAboutDrug, tellUsAboutDrugPage);

	}

	@Then("^the user clicks on Remove button on Drug List page on DCE to delete drug$")
	public void the_user_clicks_on_RemoveBtn(DataTable Attributes) throws Throwable {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		/*List<DataTableRow> plannameAttributesRow = Attributes.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Attributes);
		String drug = plannameAttributesMap.get("DrugName");
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);

		DCEbuildDrugList.clickOnRemoveButton(drug);

	}

	@Then("^the user changes the supply length$")
	public void the_user_changesSupplyLength(DataTable Attributes) throws Throwable {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		/*List<DataTableRow> plannameAttributesRow = Attributes.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Attributes);
		String supplyLength = plannameAttributesMap.get("Supply Length");
		TellUsAboutDrug tellUsAboutDrugPage = (TellUsAboutDrug) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrugPage.selectSupplyLength(supplyLength);
		BuildYourDrugList DCEbuildDrugList = tellUsAboutDrugPage.ClickAddDrug();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}


	@Then("^the user validates error message for blank search$")
	public void the_user_validates_error_message_for_blank_search() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEbuildDrugList.validateNoDrug_ErrorMsg();
	}

	@When("^the user clicks on Add drugs button$")
	public void the_user_clicks_on_Add_drugs_button() {
		GetStartedPage DCEgetStarted = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		BuildYourDrugList DCEbuildDrugList = DCEgetStarted.clickAddsDrugs();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
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

	@Then("^user enter invalid zipcode$")
	public void user_enter_invalid_zipcode_in_AARP(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();

		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String invalidzipcode = memberAttributesMap.get("inValidzipCode");
		System.out.println("zipcode" + invalidzipcode);
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.enterZipCode(invalidzipcode);
	}

	@Then("^user enter the following drug info and validates drug autocomplete$")
	public void user_enter_the_following_drug_info_and_validates_drug_autocomplete(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();

		
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String PartialDrug = memberAttributesMap.get("DrugNameAutoComplete");
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEbuildDrugList.ValidateDrugAutocomplete(PartialDrug);
	}

	@Then("^the user validates Tell Us About Drug - Brand page for the Drug$")
	public void the_user_validates_Tell_Us_About_Drug_Brand_page_for_the_Drug(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();

		
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String genericDrugName = memberAttributesMap.get("GenericName");
		String BrandDrugName = (String) getLoginScenario().getBean(DCERedesignCommonConstants.BRAND_DRUG1);
		// String BrandDrugName = memberAttributesMap.get("BrandDrugName");

		TellUsAboutDrug tellUsAboutDrug = (TellUsAboutDrug) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrug.validateBrandDrugPage(BrandDrugName, genericDrugName);
	}

	@Then("^the user validates Blank Drug Quantity error message$")
	public void the_user_validates_Blank_Quantity_error_message() throws Throwable {
		TellUsAboutDrug tellUsAboutDrug = (TellUsAboutDrug) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrug.ValidateBlankQuantityError();

	}

	@Then("^the user clicks on Add Drug to add drug to drug list$")
	public void the_user_clicks_on_Add_Drug_to_add_drug_to_drug_list(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();

		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String drugName = memberAttributesMap.get("BrandDrugName");
		TellUsAboutDrug tellUsAboutDrug = (TellUsAboutDrug) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		BuildYourDrugList DCEbuildDrugList = tellUsAboutDrug.ClickAddDrug();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		/*if (null == druglist) {
			druglist = "";
		}
		druglist = druglist + "&" + drugName;*/
		
		if(StringUtils.isEmpty(druglist)) {
			druglist = drugName;
		} else {
			druglist = druglist + "&" + drugName;
		}
		
		System.out.println("Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
	}

	@Then("^user enters valid zipcode and county$")
	public void user_enter_valid_zipcode_and_county_in_AARP(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String zipcode = memberAttributesMap.get("ZipCode");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
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



	@When("^user should verify the Extra help on SNP plan type$")
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



	@When("^clicks on Review drug cost button for detail page$")
	public void clicks_on_Review_drug_cost_button_Detail_Page() {
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugDetailsPage drugDetailsPage = buildDrugList.navigateToDrugDetailsPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@When("^clicks on Review drug cost button to land on drug summary page$")
	public void clicks_on_Review_drug_cost_for_drug_summary_Page() {
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugSummaryPage drugSummaryPage = buildDrugList.navigateToDrugSummaryPage();
		
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^load screen should be displayed$")
	public void load_screen_should_be_displayed_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		// zipCodePlanYearPage.verifyLoadScreen();
	}

	@Then("^the user searches and adds the following Drug to Drug List$")
	public void the_user_searches_and_adds_the_following_Drug_to_Drug_List(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String drugName = memberAttributesMap.get("DrugName");
		System.out.println(drugName);
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrug tellUsAboutDrug = buildDrugList.SearchaddDrugs(drugName);
		buildDrugList = tellUsAboutDrug.ClickAddDrug();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		
		 
		System.out.println("Drugs List : " + druglist);

//		if (druglist.isEmpty()) {
		if(StringUtils.isEmpty(druglist)) {
			druglist = drugName;
		} else {
			druglist = druglist + "&" + drugName;
		}
		System.out.println("Drugs List after Drug " + drugName + " , Added : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}

	@Then("^the user edits supply length to three months for following drug$")
	public void the_user_edits_supply_length_to_three_months_for_following_drug(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

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
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

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
	
	@Then("^the user validates Drug Recommendation section$")
	public void the_user_validates_Drug_Recommendation_section() throws Throwable {
		BuildYourDrugList buildYourDrugsListPage = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		buildYourDrugsListPage.validateDrugRecommendationSection(druglist);
	}

	@Then("^the user validates Drug Recommendation section is not Displayed after adding twenty five drugs$")
	public void the_user_validates_Drug_Recommendation_section_does_not_dispaly() throws Throwable {
		BuildYourDrugList buildYourDrugsListPage = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		buildYourDrugsListPage.validateDrugRecommendationSectionNOTdisplayed(druglist);
	}

	@Then("^the user searches and adds the following Drug for following quantity, frequency and Supplylength to Drug List$")
	public void the_user_searches_and_adds_the_following_Drug_for_following_quantity_frequency_and_Supplylength_to_Drug_List(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String drugName = memberAttributesMap.get("DrugName");
		String drugQuantity = memberAttributesMap.get("Quantity");
		String drugFrequency = memberAttributesMap.get("Frequency");
		String drugSupplyLen = memberAttributesMap.get("SupplyLen");
		System.out.println("DrugName"+drugName);
		System.out.println("Quantiry"+drugQuantity);
		System.out.println("Frequency"+drugFrequency);
		System.out.println("SupplyLength"+drugSupplyLen);
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrug tellUsAboutDrug = buildDrugList.SearchaddDrugs(drugName);
		tellUsAboutDrug.selectQuantity(drugQuantity);
		tellUsAboutDrug.selectFrequency(drugFrequency);
		tellUsAboutDrug.selectSupplyLength(drugSupplyLen);
		buildDrugList = tellUsAboutDrug.ClickAddDrug();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);


		System.out.println("Drugs List : " + druglist);

		//		if (druglist.isEmpty()) {
		if(StringUtils.isEmpty(druglist)) {
			druglist = drugName;
		} else {
			druglist = druglist + "&" + drugName;
		}
		System.out.println("Drugs List after Drug " + drugName + " , Added : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}

	@Then("^the user validates qty, frequency and Supply Length for following drug in DrugList Page$")
	public void the_user_validates_qty_frequency_and_Supply_Length_for_following_drug_in_DrugList_Page(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String drugName = memberAttributesMap.get("DrugName");
		String drugQuantity = memberAttributesMap.get("Quantity");
		String drugFrequency = memberAttributesMap.get("Frequency");
		String drugSupplyLen = memberAttributesMap.get("SupplyLen");
		System.out.println("DrugName : "+drugName);
		System.out.println("Quantiry : "+drugQuantity);
		System.out.println("Frequency : "+drugFrequency);
		System.out.println("SupplyLength : "+drugSupplyLen);
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		buildDrugList.validateDetailsForDrug(drugName,drugQuantity,drugFrequency,drugSupplyLen);
		
	}

	@Then("^the user validates qty, frequency and Supply Length for following drug in DCE Details Page$")
	public void the_user_validates_qty_frequency_and_Supply_Length_for_following_drug_in_DCE_Details_Page(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String drugName = memberAttributesMap.get("DrugName");
		String drugQuantity = memberAttributesMap.get("Quantity");
		String drugFrequency = memberAttributesMap.get("Frequency");
		String drugSupplyLen = memberAttributesMap.get("SupplyLen");
		System.out.println("DrugName : "+drugName);
		System.out.println("Quantiry : "+drugQuantity);
		System.out.println("Frequency : "+drugFrequency);
		System.out.println("SupplyLength : "+drugSupplyLen);
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDetailsForDrugInYourDrugs(drugName,drugQuantity,drugFrequency,drugSupplyLen);}

	@And("^I access the DCE Redesign from Plan Summary for mentioned plan$")
	public void accessDCERign_PlanSummaryforPlan(DataTable attributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String plantype = memberAttributesMap.get("Plan Type");
		String planName = memberAttributesMap.get("Plan Name");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
//		plansummaryPage.handlePlanYearSelectionPopup("current");
		GetStartedPage getStartedPage = plansummaryPage.navigateToDCERedesignFromVPPPlanCard(plantype, planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");

	}

	@When("^user verify and click on previous button on zip code enter page$")
	public void user_clicks_on_Previous_button_ZipENtryPage_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		BuildYourDrugList DCEbuildDrugList = zipCodePlanYearPage.clickPreviousBtn();
		// zipCodePlanYearPage.verifyLoadScreen();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}

	@Then("^the user validates No Drug found error message for search$")
	public void the_user_validates_No_Drug_found_error_message_for_search() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEbuildDrugList.validateDrugNotFound_ErrorMsg();
	}

	@Then("^the user selects the following Brand Name drug from the dropdown$")
	public void the_user_selects_the_following_drug_from_the_dropdown(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String DrugName = memberAttributesMap.get("BrandDrugName");
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrug tellUsAboutDrug = DCEbuildDrugList.SelectDrugfromList(DrugName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_TellUsAboutDrug, tellUsAboutDrug);
		getLoginScenario().saveBean(DCERedesignCommonConstants.BRAND_DRUG1, DrugName);
	}

	@Then("^the user clicks on Review Drug Costs to Land on Zip Entry Page$")
	public void the_user_clicks_on_Add_Drug() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		ZipCodePlanYearCapturePage zipCodePlanYearPage = DCEbuildDrugList.navigateToZipEntryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@Then("^the user clicks on Review Drug Costs button to Land on Drug Summary Page$")
	public void the_user_clicks_on_Review_Drug_Costs_button_to_Land_on_Drug_Summary_Page() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugSummaryPage drugSummaryPage = DCEbuildDrugList.navigateToDrugSummay();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^adds drugs in drug list page$")
	public void adds_drugs_in_drug_list_page(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String drugName = memberAttributesMap.get("DrugName");
		System.out.println("zipcode" + drugName);
		BuildYourDrugList buildDrugList = new BuildYourDrugList(driver);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
		buildDrugList.addDrugs(drugName);
	}



	@And("^the user click on return to plan summary from Get Started Page to return to VPP Plan Summary$")
	public void the_user_clicks_on_returnlink_to_vpp_planSummary_Getstarted() {
		GetStartedPage getStartedPage = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		VPPPlanSummaryPage plansummaryPage = getStartedPage.ClickReturnToBtnToVPPSummary();
		if (null != plansummaryPage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@And("^the user click on return to plan summary from Drug Details Page to return to VPP Plan Summary$")
	public void the_user_clicks_on_returnlink_to_vpp_planSummary_DrugDetails() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		VPPPlanSummaryPage plansummaryPage = drugDetailsPage.ClickReturnToBtnToVPPSummary();
		if (null != plansummaryPage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@And("^the user clicks on Edit your drug list link on drug details page$")
	public void the_user_clicks_on_editDrugLink_on_DrugDetails() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		BuildYourDrugList buildDrugList = drugDetailsPage.clickOnEditDrugListLink();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}

	@And("^the user clicks on Return to details link on Drug Details page$")
	public void the_user_clicks_on_returnlink_DrugDetails() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		PlanDetailsPage planDetailsPage = drugDetailsPage.clickReturnToDetailsLink();
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetailsPage);

	}

//	LearnMore changes Start
	@Then("^the user clicks PrescriptionBenifit Tab on Plan Details Page$")
	public void the_user_clicks_PrescriptionBenifit_Tab_on_Plan_Details_Page() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		plandetailspage.clickPrescriptionBenifitTab();
	}

	@Then("^the user clicks Learn More button on Prescription Drug Costs Tab on Plan Details Page$")
	public void the_user_clicks_Learn_More_button_on_Prescription_Drug_Costs_Tab_on_Plan_Details_Page()
			throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		DrugDetailsPage drugDetailsPage = plandetailspage.clickLearnMore();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates planName on LearnMore page matches plan Name in VPP$")
	public void the_user_validates_planName_on_LearnMore_page_matches_plan_Name_in_VPP() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

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
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^the user Clicks button to VPP Plan Details Page from Drug Details Page$")
	public void the_user_Clicks_button_to_VPP_Plan_Details_Page_from_Drug_Details_Page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		PlanDetailsPage plandetailspage = drugDetailsPage.ClickandNavigate_VPPPlanDetails(PlanName);
		if (null != plandetailspage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		} else
			Assertion.fail("VPP Plan Details not loaded");
	}
	
	@Then("^the user clicks view plan details button for first plan from Drug Summary Page$")
	public void the_user_clicks_plan_details_button_on_Drug_Details_Page() throws Throwable {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		
		PlanDetailsPage plandetailspage = drugSummaryPage.clickViewPlanDetails();
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		
	}
	@Then("^the user clicks on return to compare link on build drug list page to returns to plan compare$")
	public void the_user_Clicks_button_to_VPP_Plan_Compare_Page_from_Druglist_page() throws Throwable {
		BuildYourDrugList buildDrugListPage = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		ComparePlansPage planComparePage = buildDrugListPage.returnToPlanComparePage();
		if (null != planComparePage) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else
			Assertion.fail("VPP Plan Compare not loaded");
	}

	@Then("^the user validates drug is displayed on the plan compare page$")
	public void the_userValidatesDrugInfo(DataTable attributes) throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);*/

		String drug = attributes.cell(0, 1);
		planComparePage.validateDrugInfo(drug);
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

	}

	@And("^the user clicks on the add drugs button to navigate to DCE Redesign on the profile page$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_profile_to_DCE_Redesign_in_AARP_site() {
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		GetStartedPage getStartedPage = visitorProfilePage.addDrug_DCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");

	}

	@Then("^the user navigates to Med Ed - Prescription Drugs Page$")
	public void the_user_navigates_to_Med_Ed_Prescription_Drugs_Page() throws Throwable {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		System.out.println("Selecting State in Acq Home page so Med ED CLassic page is displayed...");
		//acquisitionHomePage.selectState("Florida");
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
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^the user navigates to Shop plans for PDP Page and clicks on DCE link fto land on DCE Redesign$")
	public void the_user_navigates_to_Shop_plans_for_PDP_Page_and_clicks_on_DCE_link_fto_land_on_DCE_Redesign()
			throws Throwable {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acquisitionHomePage.navigateToShopPDPpage();
		GetStartedPage getStartedPage = acquisitionHomePage.clickDCERedesignLinkonShopPDPpage();
		String plantype="PDP";
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@And("^the user clicks on DCE link to land on DCE Redesign from PDP Shop page$")
	public void the_user_clicks_on_DCE_link_to_land_on_DCE_Redesign_from_PDP_Shop_page() throws Throwable {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		GetStartedPage getStartedPage = acquisitionHomePage.clickDCERedesignLinkonShopPDPpage();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^the user clicks on Review Drug Costs to Land on Drug Details Page$")
	public void the_user_clicks_on_Review_Drug_Costs_to_Land_on_Drug_DetailsP_Page() throws Throwable {
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugDetailsPage drugDetailsPage = DCEbuildDrugList.navigateToDrugDetailsPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user verify the Retail chain pharmacy on detail page$")
	public void the_user_verify_the_Retail_chain_pharmacy_on_detail_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateRetailChainPharmacy();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates planName matches plan Name in VPP$")
	public void the_user_validates_planName_matches_plan_Name_in_VPP() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanName(PlanName);
	}
	@Then("^the user clicks on Enroll in plan and validates the Welcome to OLE Page$")
	public void the_user_clicks_on_Enroll_in_plan_and_validates_the_Welcome_to_OLE_Page() throws Throwable{
	    DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
	    WelcomePage welcomepage = drugDetailsPage.clickEnrollinPlanbtn();
	    if (null != welcomepage) {
		  getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, welcomepage);
	    } else
		Assertion.fail("Welcome page  not loaded");
    }

	@Then("^the user verify and edit the Pharmacy from vpp detail page$")
	public void the_user_verify_and_edit_the_Pharmacy_from_vpp_detail_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.vppdetails_clickEditPharmacy();
	}

	@Then("^user save the plan on drug detail page$")
	public void user_save_the_plan_on_drug_detail_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.savePlan();
	}

	@Then("^the user verify the drug cost estimator and view plan summary on VPP detail page in AARP$")
	public void the_user_verify_the_drug_cost_estimator() throws Throwable {
		Thread.sleep(10000);
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.validateDrugandPanButton();
	}

	@Then("^the user click on Prescription Drug Benefits tab from drug detail page$")
	public void the_user_click_on_Prescription_Drug_Benefits_tab_from_drug_detail_page() throws Throwable {
		Thread.sleep(10000);
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.validateDrugandPanButton();
	}

	@Then("^the user verify the drug cost estimator and view plan summary on VPP summary page in AARP$")
	public void the_user_verify_the_drug_cost_estimator_summary() throws Throwable {
		Thread.sleep(10000);
		DrugSummaryPage drugDetailsPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);

		drugDetailsPage.validateDrugandPanButton();
	}

	@Then("^the user click on drug cost estimator on vpp plan detail page in AARP$")
	public void the_user_click_on_drug_cost_estimator() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.clickOnBacktoDrugBtn();
	}

	@Then("^the user click on view plan summary on vpp detail page$")
	public void the_user_click_on_drug_cost_estimator_details() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.clickOnvppPlan();
	}

	@Then("^user click on view plan details on summary page in AARP$")
	public void the_user_click_on_view_plan_details() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.clickOnvppPlanDetails();
	}

	@Then("^the user click on drug cost estimator on vpp plan summary page in AARP$")
	public void the_user_click_on_drug_cost_estimator_summary() throws Throwable {
		DrugSummaryPage drugDetailsPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);

		drugDetailsPage.clickOnBacktoDrugBtn();
	}

	@Then("^User validates planName matches plan Name in DCE detail page in AARP$")
	public void the_user_validates_matches_planname() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanDrugDetails(PlanName);
	}

	@Then("^User validates planName matches plan Name in DCE summary page in AARP$")
	public void the_user_validates_summary_planname() throws Throwable {
		DrugSummaryPage drugDetailsPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanDrugDetails(PlanName);
	}

	@Then("^the user validates Drug Costs section$")
	public void the_user_validates_Drug_Costs_section() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDrugCosts();
	}

	@Then("^the user verify the extra help alert message on Drug Detail Page$")
	public void the_user_verify_the_extra_help_alert_message_on_Drug_Detail_Page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateExtraHelpAlert();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
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
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
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
	public void the_user_validates_Estimated_Drug_Costs_on_Prescription_Drug_Costs_Tab_on_Plan_Details_Page()
			throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String EstimatedDrugCosts = plandetailspage.costComparisonPrescriptionDrugFromDCE();
		String cost = (String) getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		if (cost.trim().contains(EstimatedDrugCosts))
			Assertion.assertTrue("It's a match on on prescription drug tab and Drug CostEstimator page; Expected : " + cost
					+ "; Actual : " + EstimatedDrugCosts, true);
		else
			Assertion.assertTrue("Cost mismatch on prescription drug tab and drug CostEstimator page; Expected : " + cost
					+ "; Actual : " + EstimatedDrugCosts, false);

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
		// drugSummaryPage.verifyDefaultPlanType();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user click on view plan details on drug summary page$")
	public void user_click_on_view_plan_details_on_drug_summary_page() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickOnViewPlan();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user saves MAPD plan as favorite on drug summary page AARP site$")
	public void user_saves_plan_as_favorite_on_drug_summary_AARP_site(DataTable givenAttributes)
			throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		List<List<String>> memberAttributesRow = givenAttributes.asLists();
		String PlanName = memberAttributesRow.get(0).get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.clickOnMAPDPlan();
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
		/*
		 * VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
		 * .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE); List<DataTableRow>
		 * memberAttributesRow = givenAttributes.getGherkinRows(); String PlanName =
		 * memberAttributesRow.get(0).getCells().get(1); System.out.println("Plan name"
		 * + PlanName); plansummaryPage.savePlan(PlanName);
		 */
	}

	@Then("^user save PDP plan as favorite on drug summary page AARP site$")
	public void user_saves_pdp_plan_as_favorite_on_drug_summary_AARP_site(DataTable givenAttributes)
			throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		List<List<String>> memberAttributesRow = givenAttributes.asLists();
		String PlanName = memberAttributesRow.get(0).get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.clickOnPDPPlan();
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user save SNP plan as favorite on drug summary page AARP site$")
	public void user_saves_snp_plan_as_favorite_on_drug_summary_AARP_site(DataTable givenAttributes)
			throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		List<List<String>> memberAttributesRow = givenAttributes.asLists();
		String PlanName = memberAttributesRow.get(0).get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.clickOnSNPPlan();
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@And("^user click on return to home on drug summary in AARP site$")
	public void user_click_on_return_to_home_on_drug_summary_in_AARP_site() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickOnReturnToHome();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user should be able to toggle between plan types$")
	public void user_should_be_able_to_toggle_between_plan_types() throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.verifyPDPPlanToggle();
		drugSummaryPage.verifySNPPlanToggle();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user clicks on change pharmacy link from summary page$")
	public void user_clicks_on_change_pharmacy_link_from_summary_page_in_AARP() throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickChangePharmacy();
	}

	@Then("^the user selects following pharmacy and returns to DCE Summary page$")
	public void the_user_selects_following_pharmacy_and_returns_to_DCE_Summary_page(DataTable givenAttributes)
			throws Throwable {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String PharmacytoSelect = memberAttributesMap.get("SelectPharmacy");
		System.out.println(PharmacytoSelect);
		drugSummaryPage.SelectPharmacy(PharmacytoSelect);
		drugSummaryPage.validatePharmacyName(PharmacytoSelect);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^the user selects following pharmacy and returns to DCE Details page$")
	public void the_user_selects_following_pharmacy_and_returns_to_DCE_Details_page(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String PharmacytoSelect = memberAttributesMap.get("SelectPharmacy");
		drugDetailsPage.SelectPharmacy(PharmacytoSelect);
		drugDetailsPage.validatePharmacyName(PharmacytoSelect);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^the user validates Not Covered Pharmacy view for DCE Details Page$")
	public void the_user_validates_Not_Covered_Pharmacy_view_for_DCE_Details_Page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateNotCoveredPharmacyView();
	}

	@When("^user clicks on change pharmacy link on alert message from summary page$")
	public void user_clicks_on_change_pharmacy_link_on_aler_message_from_summary_page() throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickChangePharmacyCoverPrescription();
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
        DrugDetailsPage drugDetailsPage = drugSummaryPage.clickViewDrugCostBtn();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
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
		drugDetailsPage.clickDistanceMiledropdown();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@When("^user click on View Drug Pricing Modal$")
	public void User_click_on_View_Drug_Pricing_Modal_in_AARP() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickViewPricing();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}


	@When("^user verify drug can switch to generic drug$")
	public void user_verify_drug_can_switch_to_generic_drug_aarp(DataTable givenAttributes) throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

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
		GetStartedPage getStartedPage = planComparepage.navigateToDCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@When("^user clicks on Keep Using This Pharmacy on change pharmacy page")
	public void user_clicks_on_keep_using_pharmacy() throws InterruptedException {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateAndClickKeepPharm();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@When("^user validate \"([^\"]*)\" pharmacy on detail page")
	public void user_validate_pharmacy_on_detail_page(String pharmacyName) throws InterruptedException {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDefaultPharmacyName(pharmacyName);
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

	@Then("^user saves plan as favorite on drug summary page$")
	public void user_saves_plan_as_favorite_on_drug_summary(DataTable givenAttributes) throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		List<List<String>> memberAttributesRow = givenAttributes.asLists();
		String PlanName = memberAttributesRow.get(0).get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user saves plan as favorite on drug details page$")
	public void user_saves_plan_as_favorite_on_drug_details(DataTable givenAttributes) throws InterruptedException {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		List<List<String>> memberAttributesRow = givenAttributes.asLists();
		String PlanName = memberAttributesRow.get(0).get(1);
		System.out.println("Plan name" + PlanName);
		drugDetailsPage.validatePlanName(PlanName);
		drugDetailsPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@And("^the user clicks on the heart icon on Drug Details page$")
	public void the_user_clicks_on_the_shopping_cart_icon_on_Drug_details_page() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
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
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^user validates planName matches plan Name in Drug Details pages$")
	public void the_user_validates_matches_planname_in_Drug_Details() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanDrugDetails(PlanName);
	}

	@And("^the user clicks on DCE button to return to Review Drug cost page$")
	public void the_user_clicks_on_DCE_return_Review_Drug_cost_page() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		DrugDetailsPage drugDetailsPage = plandetailspage.returnToReviewDrugCost();

	}
	

	@Then("^the user selects View plan details for following plantype and PlanName$")
	public void the_user_selects_View_plan_details_for_following_plantype_and_PlanName(DataTable attributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String plantype = memberAttributesMap.get("Plan Type");
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPage plansummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		PlanDetailsPage plandetailspage = plansummaryPage.clickViewplanDetailsForPlan(plantype, planName);
		// getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
		// plandetailspage);
		getLoginScenario().saveBean(DCERedesignCommonConstants.PLANTYPE, plantype);
		getLoginScenario().saveBean(DCERedesignCommonConstants.PLANNAME, planName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, planName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);

		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);

	}

	@Then("^the user validates Switch to generic for following Brand Drug and validate Generic drug on Details Page$")
	public void the_user_validates_Switch_to_generic_for_following_Brand_Drug_and_validate_Generic_drug_on_Details_Page(
			DataTable givenAttributes) throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		

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
	public void the_user_validates_Switch_to_generic_for_following_Brand_Drug_to_Generic_drug_from_Summary_Page(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String BrandDrug = memberAttributesMap.get("Brand Drug");
		String GenericDrug = memberAttributesMap.get("Generic Drug");
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
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
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		drugSummaryPage.ValidatesDrugsList(druglist);

	}
	
	@Then("^the user validates View Drug Pricing modal for the given plan$")
	public void user_validates_ViewDrugPricing_modal(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		String planName = memberAttributesMap.get("Plan Name");
		drugSummaryPage.viewDrugPricingModal(planName);
	}

	@Then("^the user clicks Edit Drug on Drug Details Page and validates user navigates to Build your drug list Page$")
	public void the_user_clicks_Edit_Drug_on_Drug_Details_Page_and_validates_user_navigates_to_Build_your_drug_list_Page()
			throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		BuildYourDrugList buildDrugListPage = drugDetailsPage.clickEditDrugs();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugListPage);

	}

	@Then("^the user deletes the following drug from Drug list$")
	public void the_user_deletes_the_following_drug_from_Drug_list(DataTable givenAttributes) throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		BuildYourDrugList buildDrugListPage = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String DeleteDrug = memberAttributesMap.get("DrugName");
		buildDrugListPage.deleteDrug(DeleteDrug);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		System.out.println("Drug List before Delete Drug : " + druglist);
//		druglist = druglist.replace("&" + DeleteDrug, "");
		
		//Get the current drug list into an Arraylist
		try {
			List<String> drugListBeforeRemoving = new ArrayList<String>(Arrays.asList(druglist.split("&")));

			//Update the arraylist by removing the deleted drug
			if(drugListBeforeRemoving.contains(DeleteDrug)) {
				drugListBeforeRemoving.remove(DeleteDrug);
			}
			//Get the updated list of drugs in druglist variable
			druglist = String.join("&", drugListBeforeRemoving);
		}catch(UnsupportedOperationException e) {
			System.out.println("Initiliaze the List correctly !");
			
			/**When using Arrays.asList, arraylist has to be initialized as
			List<String> listName = new ArrayList<String>(Arrays.asList(String.split("delimiter")));
			*/
		}
		
		
		
		System.out.println("Updated Drugs List after Delete Drug : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^the user validates Dynamic Copay Section for following Pharmacy selection$")
	public void the_user_validates_Dynamic_Copay_Section_for_following_Pharmacy_selection(DataTable givenAttributes)
			throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		

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

	@Then("^the user selects Mail Pharmacy and returns to DCE Details page$")
	public void the_user_selects_Mail_Pharmacy_and_returns_to_DCE_Details_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.SelectMailPharmacy();
		String pharmacy = "OptumRx Mail Service Pharmacy";
		drugDetailsPage.validatePharmacyName(pharmacy);
		getLoginScenario().saveBean(PageConstants.PHARMACY_NAME, pharmacy);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}
	@Then("^the user selects Mail Pharmacy and returns to DCE Summary page$")
	public void the_user_selects_Mail_Pharmacy_and_returns_to_DCE_Summary_page() throws Throwable {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.selectMailOrderPharmacy();
		//getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
		String pharmacy = "OptumRx Mail Service Pharmacy";
		drugSummaryPage.validatePharmacyName(pharmacy);
		getLoginScenario().saveBean(PageConstants.PHARMACY_NAME, pharmacy);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
}

	@Then("^the user selects following Standard pharmacy and returns to DCE Details page$")
	public void the_user_selects_following_Standard_pharmacy_and_returns_to_DCE_Details_page(DataTable givenAttributes)
			throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String StandardPharmacytoSelect = memberAttributesMap.get("SelectStandardPharmacy");
		drugDetailsPage.SelectStandardPharmacy(StandardPharmacytoSelect);
		drugDetailsPage.validatePharmacyName(StandardPharmacytoSelect);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^the user validates following expected Premium on DCE Details Page$")
	public void the_user_validates_following_expected_Premium_on_DCE_Details_Page(DataTable arg1) throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);

		String Premium = memberAttributesMap.get("Premium");
		drugDetailsPage.validatePremium(Premium);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates following premium for the following plan on DCE Summary Page$")
	public void the_user_validates_following_premium_for_the_following_plan_on_DCE_Summary_Page(DataTable arg1)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);

		String Premium = memberAttributesMap.get("Premium");
		String PlanType = memberAttributesMap.get("Plan Type");
		String PlanName = memberAttributesMap.get("Plan Name");
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validatePremiumForPlan(Premium, PlanType, PlanName);
	}
	
	@Then("^the user validates functional tool tips for the given plan$")
	public void the_user_validates_functional_tool_tips_for_Given_plan(DataTable attributes)
	throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for(int i=0 ; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0) ,
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.captureFunctionalToolTips(planName);
		
	}

	@Then("^the user Captures Drug costs on Drug Summary Page for the given plan$")
	public void the_user_Captures_Drug_costs_on_Drug_Summary_Page_For_Given_Plan(DataTable attributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		Map<String, String> DrugCosts = drugSummaryPage.captureDrugCosts(planName);
		String AVG_MONTHLY = DrugCosts.get("AVG_MONTHLY");
		String MONTHLY_PREMIUM = DrugCosts.get("MONTHLY_PREMIUM");
		String ANNUAL_ESTIMATED_TOTAL = DrugCosts.get("ANNUAL_ESTIMATED_TOTAL");
		String COVERED_DRUGS_COUNT = DrugCosts.get("COVERED_DRUGS_COUNT");
		System.out.println(DrugCosts);
		getLoginScenario().saveBean(DCERedesignCommonConstants.AVG_MONTHLY_DRUG_SUMMARY, AVG_MONTHLY);
		getLoginScenario().saveBean(DCERedesignCommonConstants.MONTHLY_PREMIUM_DRUG_SUMMARY, MONTHLY_PREMIUM);
		getLoginScenario().saveBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL_DRUG_SUMMARY,
				ANNUAL_ESTIMATED_TOTAL);
		getLoginScenario().saveBean(DCERedesignCommonConstants.COVERED_DRUGS_COUNT_DRUG_SUMMARY, COVERED_DRUGS_COUNT);

	}

	@Then("^user should be able to see Return to profile link on summary page$")
	public void user_should_be_able_to_see_Return_to_profile_link_on_summary_page() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.verifyReturnToProfileDisplayed();
	}

	@Then("^the user compares drug costs for drug details and drug summary pages$")
	public void the_user_compares_drug_costs_for_drug_details_and_drug_summary() throws Throwable {
		String drugSummaryAvgMonthly = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.AVG_MONTHLY_DRUG_SUMMARY);
		String drugSummaryMonthlyPremium = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.MONTHLY_PREMIUM_DRUG_SUMMARY);
		String drugSummaryAnnualEstimated = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL_DRUG_SUMMARY);
		String drugSummaryDrugCount = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.COVERED_DRUGS_COUNT_DRUG_SUMMARY);
		String drugDetailsAvgMonthly = (String) getLoginScenario().getBean(DCERedesignCommonConstants.AVG_MONTHLY);
		String drugDetailsMonthlyPremium = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.MONTHLY_PREMIUM);
		String drugDetailsAnnualEstimated = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		String drugDetailsDrugCount = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.COVERED_DRUGS_COUNT);

		if (drugSummaryAvgMonthly.equals(drugDetailsAvgMonthly)
				&& drugSummaryMonthlyPremium.equals(drugDetailsMonthlyPremium)
				&& drugSummaryAnnualEstimated.equals(drugDetailsAnnualEstimated)
				&& drugDetailsDrugCount.equals(drugSummaryDrugCount))
			System.out.println("Drug costs mathced");
		else
			Assertion.fail("Drug costs between drug details and drug summary didn't match");

	}

	@Then("^the user verifies the added pharmacy on prescription drug tab$")
	public void the_user_verifies_pharmacy_on_prescription_drug_tab() throws Throwable {
		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String pharmacyName = (String) getLoginScenario().getBean(PageConstants.PHARMACY_NAME);
		planDetailsPage.verifyPharmacyAdded(pharmacyName);

	}

	@Then("^the user validates Insulin savings on Copay section, Your Drugs and Important Information Section$")
	public void the_user_validates_Insulin_savings_on_Copay_section_Your_Drugs_and_Important_Information_Section(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);

		String InsulinCopay = memberAttributesMap.get("InsulinCopay");
		String InsulinDrug = memberAttributesMap.get("Insulin Drug");
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		if(null==InsulinCopay || InsulinCopay.isEmpty()) {
			System.out.println("Insulin Benefit not available for the plan");
		}
		else{
			drugDetailsPage.validateInsulinTier_CopaySection(InsulinCopay);
			drugDetailsPage.validateInsulinDrug_YourDrugs(InsulinDrug, InsulinCopay);
			drugDetailsPage.validateInsulinText_ImportantInfo();
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

		}
	}

	@Then("^the user validates Covered Drug display for NC Pharmacy selection$")
	public void the_user_validates_Covered_Drug_display_for_NC_Pharmacy_selection() throws Throwable {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.ValidateNCPharmacyCoveredDrugs();
	}

	@Then("^the user clicks on View Drug Information link for the following Plan and lands on DCE details$")
	public void the_user_clicks_on_View_Drug_Information_link_for_the_following_Plan_and_lands_on_DCE_details(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);

		String planName = memberAttributesMap.get("PlanName");
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		planComparePage.clickViewDrugInfoLinkForPlan(planName);
		String drugYouPaylist = planComparePage.validateDrugListCaptureDrugYouPay(druglist);
		DrugDetailsPage drugDetailsPage = planComparePage.clickDrugCostDetails_DrugInfoModal();
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);

		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS, drugYouPaylist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	@Then("^the user validates Estimated Drug Cost for the following plan to DCE details page estimated Drug Costs$")
	public void the_user_validates_estimated_drug_cost_for_plan_on_compare_page_to_DCEdetails_page_captured_estimated_drug_cost(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);

		String planName = memberAttributesMap.get("PlanName");
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		String Expected_Estimated_Drug_Cost = (String) getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		planComparePage.validateEstimatedDrugCostForPlan(planName, Expected_Estimated_Drug_Cost);

	}

	@Then("^the user clicks on View Plan Compare button and validates Plan Compare page, Drug Info Modal$")
	public void the_user_clicks_on_View_Plan_Compare_button_and_validates_Plan_Compare_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		String drugYouPaylist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS);
		drugDetailsPage.validateDrugListYouPay_FromComparePage(druglist, drugYouPaylist);
		ComparePlansPage planComparePage = drugDetailsPage.clickViewPlanCompareBtn_ReturnToCompare_ViewDrugModal();
		if (null != planComparePage) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else
			Assertion.fail("VPP Plan Compare not loaded");
	}

	@Then("^the user clicks on Back to Compare link and validates Plan Compare page, Drug Info Modal$")
	public void the_user_clicks_on_Back_to_Compare_link_and_validates_Plan_Compare_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		ComparePlansPage planComparePage = drugDetailsPage.clickViewBackCompareLink_ReturnToCompare_ViewDrugModal();
		if (null != planComparePage) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else
			Assertion.fail("VPP Plan Compare not loaded");
	}
	
	@Then("^the user Validates Drug you pay on DCE details page to Compare page Drug Info Modal$")
	public void the_user_validates_drugyoupay_onDCEdetails_toCompareDrugInfoModal() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		String drugYouPaylist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS);
		drugDetailsPage.validateDrugListYouPay_FromComparePage(druglist, drugYouPaylist);
	}

	@Then("^the user closes the Drug Info Modal on Plan Compare page$")
	public void the_user_closes_the_Drug_Info_Modal_on_Plan_Compare_page() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.CloseDrugInfoModal();
	}

	@Then("^the user clicks on Edit Drug link and validates user lands on DCE Build Drug List Page$")
	public void the_user_clicks_on_Edit_Drug_link_and_validates_user_lands_on_DCE_Build_Drug_List_Page()
			throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		BuildYourDrugList DCEbuildDrugList = planComparePage.clickonEdityourDrugs();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}

	@Then("^the user validates all added Drugs on Plan Compare$")
	public void the_user_validates_all_added_Drugs_on_Plan_Compare() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		planComparePage.ValidatesAddedDrugsList(druglist);
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

	}

	@Then("the user click on return to MEdEd page from Get Started Page")
	public void user_click_to_return_to_MedEd_page() {
		GetStartedPage getStartedPage = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		PrescriptionsProvidersBenefitsPage benefitsPage = getStartedPage.clickReturnToAcqHomePAge();
		if (null != benefitsPage) {
			getLoginScenario().saveBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE, benefitsPage);
		} else
			Assertion.fail("Benefit Page not loaded");
	}

	@Then("^user should be navigated to first step of DCE Page$")
	public void the_user_navigated_to_first_step_of_DCE_Page() {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		GetStartedPage DCEgetStarted = new GetStartedPage(driver);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, DCEgetStarted);

	}

	@Then("^the user validates PLan Toggle on Drug Summary Page$")
	public void the_user_validates_PLan_Toggle_on_Drug_Summary_Page() throws Throwable {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.verifyPDPPlanToggle();
		drugSummaryPage.verifySNPPlanToggle();
		drugSummaryPage.verifyMAPDPlanToggle();

	}

	@Then("^the user validates distance dropdown and Zipcode change on Summary page - Change Pharmacy Page$")
	public void the_user_validates_distance_dropdown_and_Zipcode_change_on_Summary_page_Change_Pharmacy_Page(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String PharmacyZipCode = memberAttributesMap.get("PharmacyZipCode");
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateZipandDistanceDropDwn(PharmacyZipCode);
	}

	@Then("^user should be able to see Return to profile link on details page$")
	public void user_should_be_able_to_see_Return_to_profile_link_on_details_page() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.verifyReturnToProfileDisplayed();
	}

	@Then("^Back to profile button should be displayed for each plan card$")
	public void back_to_profile_button_for_each_plan_card() {
		System.out.println(">>> Validation skipped for mobile device. <<< ");
//		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
//		drugSummaryPage.verifyBackToProfileDisplayed();
	}

	@And("^the user click on return to plan summary on DCE summary page$")
	public void the_user_clicks_on_return_to_plan_summary() {
		GetStartedPage getStartedPage = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		VPPPlanSummaryPage plansummaryPage = getStartedPage.ClickReturnToPlanSummary();
		if (null != plansummaryPage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@When("^user clicks on Back to profile button$")
	public void user_clicks_on_Back_to_profile_button() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickBackToProfileBtn();
	}

	@Then("^user should be navigated to build drug list page$")
	public void user_should_be_navigated_to_build_drug_list_page() {
		BuildYourDrugList buildDrugListPage = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		buildDrugListPage.validateBuildDrugListPageDisplayed();
	}

	@When("^user clicks on Return to profile link on details page$")
	public void user_clicks_on_Return_to_profile_link_on_details_page() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.clickReturnToProfile();
	}

	@Then("^user should be navigated to shopper profile page$")
	public void user_should_be_navigated_to_shopper_profile_page() {
		VisitorProfilePage visitorProfile = new VisitorProfilePage(driver);
		visitorProfile.validateVisitorProfilePage();
	}

	@Then("^verify DCE NBA is displayed on drug summary page$")
	public void verify_dce_NBA_is_displayed_on_summary_page() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateDCENBAModal();
	}

	@Then("^I access the DCE Redesign from Plan Details$")
	public void the_user_navigates_plan_details() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.PLAN_DETAILS_PAGE);
		GetStartedPage getStartedPage = plandetailspage.navigateToDCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^verify DCE NBA is displayed on drug details page$")
	public void verify_dce_NBA_is_displayed_on_drug_details_page() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDCENBAModal();
	}

	@When("^user saves and updates pharmacy from list$")
	public void user_saves_and_updates_pharmacy_from_list() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.saveAndUpdatePharmacy();
	}

	@When("^user saves and updates \"([^\"]*)\"  from list$")
	public void user_saves_and_updates_from_list() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.saveAndUpdatePharmacy();
	}

	@Then("^the pharmacy name should be updated on summary page$")
	public void the_pharmacy_name_should_be_updated_on_summary_page() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateSelectedPharmacy();
	}

	@Then("^the pharmacy name should be updated on details page$")
	public void the_pharmacy_name_should_be_updated_on_details_page() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateSelectedPharmacy();
	}

	@When("^user saves and updates pharmacy from list on details page$")
	public void user_saves_and_updates_pharmacy_from_list_on_details_page() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.saveAndUpdatePharmacy();
	}

	@When("^user saves below plan$")
	public void user_saves_below_plan(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String savePlanNames = memberAttributesMap.get("Plan Name");
		String planType = memberAttributesMap.get("Plan Type");
		plansummaryPage.savePlans(savePlanNames, planType);
	}

	@And("^the user navigate to Visitor profile page$")
	public void the_user_navigate_to_visitor_profile_page() {
		AcquisitionHomePage acqHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VisitorProfilePage visitorProfilePage = acqHomePage.navigateToNewVisitorProfilePage();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@And("^user validates the plans on new visitor profile page of AARP site$")
	public void user_validates_the_plans_on_new_visitor_profile_page_of_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);

		String savePlanNames = givenAttributesMap.get("Test Plans");
		VisitorProfilePage visitorProfile = new VisitorProfilePage(driver);
		visitorProfile.validateAddedPlansNew(savePlanNames);
	}

	@Then("^user verify and click on switch to generic NBA on drug detail page$")
	public void user_verify_and_click_on_switch_to_generic_NBA_on_drug_detail_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.clickswitchToGeneric();
	}

	@Then("^verify drug is switched to generic on detail page$")
	public void verify_drug_is_switched_to_generic_on_detail_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.verifyDrugisSwitchedtoGeneric();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, drugDetailsPage);
	}

	@When("^user should be able to see \"([^\"]*)\" by default$")
	public void user_should_be_able_to_see_by_default(String planType) throws Throwable {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.verifyDefaultPlanType(planType);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user click on Switch To Generic link for \"([^\"]*)\" on drug pricing modal$")
	public void user_click_on_Switch_To_Generic_link_for_on_drug_pricing_modal(String drugName) throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickSwitchToGenericLink(drugName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user updates dosage quantity and supply length in switch to generic modal$")
	public void user_updates_dosage_quantity_and_supply_length_in_switch_to_generic_modal() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.updateDosageQtySupplyLength();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user selects Preferred mail order pharmacy$")
	public void user_selects_Preferred_mail_order_pharmacy() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.selectPreferredMailOrderPharmacy();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^the message \"([^\"]*)\" should be displayed on change pharmacy modal$")
	public void the_message_should_be_displayed_on_change_pharmacy_modal(String mailOrderPharmacyMessage) {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validatePreferredMailOrderPharmacyMessage(mailOrderPharmacyMessage);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user verify the default distance on change pharmacy modal$")
	public void user_verify_the_default_distance_on_change_pharmacy_modal() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateDefaultDistance();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user sort the pharmacy list by \"([^\"]*)\"$")
	public void user_sort_the_pharmacy_list_by(String sortOption) {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.sortPharmacies(sortOption);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^pharmacy list should be displayed in ascending order$")
	public void pharmacy_list_should_be_displayed_in_ascending_order() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validatePharmaciesAscendingOrder();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^pharmacy list should be displayed in descending order$")
	public void pharmacy_list_should_be_displayed_in_descending_order() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validatePharmaciesDescendingOrder();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user clicks on next button on change pharmacy modal$")
	public void user_clicks_on_next_button_on_change_pharmacy_modal() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickNextButton();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user clicks on back button on change pharmacy modal$")
	public void user_clicks_on_back_button_on_change_pharmacy_modal() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickBackButton();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user should be navigated to second page of pharmacy list$")
	public void user_should_be_navigated_to_second_page_of_pharmacy_list() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateSecondPageDisplayed();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user should be navigated to first page of pharmacy list$")
	public void user_should_be_navigated_to_first_page_of_pharmacy_list() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateFirstPageDisplayed();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user search with zipcode with no pharamacies$")
	public void user_search_with_zipcode_with_no_pharamacies(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);

		String zipCode = memberAttributesMap.get("ZipCode");
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.searchPharmaciesByZipcode(zipCode);
	}

	@Then("^no results message should be displayed$")
	public void no_results_message_should_be_displayed(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);

		String message = memberAttributesMap.get("NoResultsMessage");
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateNoResultsMsg(message);
	}

	@When("^user search with incorrect zipcode$")
	public void user_search_with_incorrect_zipcode(DataTable attributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);

		String zipCode = memberAttributesMap.get("ZipCode");
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.searchPharmaciesByZipcode(zipCode);
	}
	@When("^user search with correct zipcode$")
	public void user_search_with_correct_zipcode(DataTable attributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String zipCode = memberAttributesMap.get("ZipCode");
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.searchPharmaciesByZipcode(zipCode);
	}

	@Then("^error message \"([^\"]*)\" should be displayed on change pharmacy modal$")
	public void error_message_should_be_displayed_on_change_pharmacy_modal(String errorMessage) {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateInvalidZipCodeMsg(errorMessage);
	}

	@When("^user updates the distance to \"([^\"]*)\"$")
	public void user_updates_the_distance_to(String distance) throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.updateDistance(distance);
	}

	@When("^user selects Preferred mail order pharmacy from drug details page$")
	public void user_selects_Preferred_mail_order_pharmacy_from_drug_detail_page() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.selectPreferredMailOrderPharmacyDrugDetails();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the message \"([^\"]*)\" should be displayed on change pharmacy modal from drug detail page$")
	public void should_be_displayed_on_change_pharmacy_modal_from_drug_detail_page(String mailOrderPharmacyMessage) {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validatePreferredMailOrderPharmacyMessageDrugDetail(mailOrderPharmacyMessage);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);

	}

	@Then("^user verify the default distance on change pharmacy modal from drug details$")
	public void user_verify_the_default_distance_on_change_pharmacy_modal_from_drug_detail() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDefaultDistanceDrugDetails();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@When("^user sort the pharmacy list by \"([^\"]*)\" from drug details$")
	public void user_sort_the_pharmacy_list_by_from_drug_detail(String sortOption) {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.sortPharmaciesDrugDetails(sortOption);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^pharmacy list should be displayed in ascending order from drug details$")
	public void pharmacy_list_should_be_displayed_in_ascending_order_from_drug_detail() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validatePharmaciesAscendingOrderDrugDetail();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^pharmacy list should be displayed in descending order from drug details$")
	public void pharmacy_list_should_be_displayed_in_descending_order_from_drug_detail() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validatePharmaciesDescendingOrderDrugDetails();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@When("^user clicks on next button on change pharmacy modal from drug details$")
	public void user_clicks_on_next_button_on_change_pharmacy_modal_from_drug_detail() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.clickNextButtonPagination();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^user should be navigated to second page of pharmacy list from drug details$")
	public void user_should_be_navigated_to_second_page_of_pharmacy_list_from_drug_details() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateSecondPageDisplayedDrugDetailPharmacy();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@When("^user clicks on back button on change pharmacy modal from drug details$")
	public void user_clicks_on_back_button_on_change_pharmacy_modal_from_drug_details() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.clickBackButtonPagination();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^user should be navigated to first page of pharmacy list from drug details$")
	public void user_should_be_navigated_to_first_page_of_pharmacy_list_from_drug_details() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateFirstPageDisplayedDrugDetails();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@When("^user search with zipcode with no pharamacies from drug details$")
	public void user_search_with_zipcode_with_no_pharamacies_from_drug_details(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String zipCode = memberAttributesMap.get("ZipCode");
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.searchPharmaciesByZipcodeDrugDetails(zipCode);
	}

	@Then("^error message \"([^\"]*)\" should be displayed on change pharmacy modal from drug details$")
	public void error_message_should_be_displayed_on_change_pharmacy_modal_from_drug_details(String errorMessage) {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateInvalidZipErrCodeMsg(errorMessage);
	}

	@When("^user search with incorrect zipcode from drug details$")
	public void user_search_with_incorrect_zipcode_from_drug_details(DataTable attributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String zipCode = memberAttributesMap.get("ZipCode");
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.searchPharmaciesByZipcodeDrugDetails(zipCode);
	}

	@When("^user updates the distance to \"([^\"]*)\" from drug details$")
	public void user_updates_the_distance_to_drug_details(String distance) throws InterruptedException {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.updateDistanceDrugDetails(distance);
	}
	
	@Then("^user clicks on search button$")
	public void user_clicks_on_search_button() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.ClickSearch();
	}

	@Then("^no results message should be displayed from drug details$")
	public void no_results_message_should_be_displayed_from_drug_details(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String message = memberAttributesMap.get("NoResultsMessage");
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateNoResultsMsgDrugDetails(message);
	}

	@When("^the user saves plan from drug details page$")
	public void the_user_saves_plan_from_drug_details_page() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.savePlan();
	}

	@Then("^user verify details page change pharmacy modal for preferred tab$")
	public void user_verify_details_page_change_pharmacy_modal_for_preferred_tab() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validatePreferredTab();
	}

	@Then("^the user validates distance dropdown and Zipcode change on DCE Details page - Change Pharmacy Page$")
	public void the_user_validates_distance_dropdown_and_Zipcode_change_on_Details_page_Change_Pharmacy_Page(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String PharmacyZipCode = memberAttributesMap.get("PharmacyZipCode");
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateZipandDistanceDropDwn(PharmacyZipCode);
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
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		PlanDetailsPage plandetailspage = drugDetailsPage.clickViewPlanDetailsBtn();
		if (null != plandetailspage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		} else
			Assertion.fail("VPP Plan Details not loaded");
	}

	@Then("^the user click on view plan summary button on vpp detail page$")
	public void the_user_click_on_view_plan_summary_details() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		VPPPlanSummaryPage plansummaryPage = plandetailspage.clickViewPlanSummaryBtn();
		if (null != plansummaryPage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else
			Assertion.fail("VPP Plan Details not loaded");
	}

	@Then("^the user clicks on Estimate Drug Costs Link from Benefit Page to land on DCE Redesign$")
	public void the_user_clicks_on_Estimate_Drug_Costs_Link_from_Benefit_page_to_land_on_DCE_Redesign()
			throws Throwable {
		PrescriptionsProvidersBenefitsPage benefitsPage = (PrescriptionsProvidersBenefitsPage) getLoginScenario()
				.getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);

		GetStartedPage getStartedPage = benefitsPage.clickDCERedesignLinkonMedEdPage();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^the user validates correct Copay section view and LIS message Not Displayed and zero deductible for LIS Buydown Plan on DCE details Page$")
	public void the_user_validates_correct_Copay_section_view_and_LIS_message_for_LIS_Buydown_Plan_on_DCE_details_Page()
			throws Throwable {
        scenario.log("Sneha Dwarakanath - Change made 06/08/2021 - F608087 - DCE | Copay Buydown, Deductible Display Change");
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateLISBuyDown_CopaySection_LISAlert();
	}

	@Then("^the user validates learn more about extra help page in separate tab$")
	public void the_user_validates_learn_more_about_extra_help() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		//drugDetailsPage.validateLearnMoreAboutExtraHelp();
	}
	
	@Then("^the user validates the LIS Banner for the below LIS Buydown plan on Drug Summary Page$")
	public void the_user_validates_LISBanner_for_LISBuydown_Plan(DataTable Planname) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> memberAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateLISBanner_LISBuydownPlan_DrugSummary(planName);
		
		
	}
	
	@Then("^the user validates correct Copay section view and LIS message for LIS Non Buydown Plan on DCE details Page$")
	public void the_user_validates_correct_Copay_section_view_and_LIS_message_for_LIS_NonBuydown_Plan_on_DCE_details_Page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateLISonly_CopaySection_LISAlert();
	}

	@Then("^the user validates Monthly Costs are not displayed for LIS Buydown plan on DCE details Page$")
	public void the_user_validates_Monthly_Costs_are_not_displayed_for_LIS_Buydown_plan_on_DCE_details_Page()
			throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateLISBuyDown_MonthlyCostsNotDisplayed();
	}

	@Then("^the user validates zero costs for following Covered generic drug for LIS Buydown on DCE details Page$")
	public void the_user_validates_zero_costs_for_following_Covered_generic_drug_for_LIS_Buydown_on_DCE_details_Page(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);

		String CoveredDrug = memberAttributesMap.get("CoveredDrug");
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateLISBuyDown_CoveredDrugCost(CoveredDrug);
	}

	@Then("^the user validates non zero costs for Not covered Drugs for LIS Buydown on DCE details Page$")
	public void the_user_validates_non_zero_costs_for_Not_covered_Drugs_for_LIS_Buydown_on_DCE_details_Page(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String NotCoveredDrug = memberAttributesMap.get("NotCoveredDrug");
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateLISBuyDown_NotCoveredDrugCost(NotCoveredDrug);
	}

	@Then("^user verify and click on standard tab from drug details")
	public void user_click_on_standard_tab_to_update_the_distance_to_durg_details() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateStandardTab();
	}

	@Then("^verify the default tab displayed on VPP details page$")
	public void verify_the_default_tab_displayed_on_VPP_details_page(DataTable attributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String tabName = memberAttributesMap.get("TabName");
		PlanDetailsPage planDetails = new PlanDetailsPage(driver);
		planDetails.validateDefaultTab(tabName);
	}

	@When("^user clicks on view plan details button on drug summary page$")
	public void user_clicks_on_view_plan_details_button_on_drug_summary_page(DataTable attributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickViewPlanDetails(planName);
		System.out.println(planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^the user validates planName matches plan Name in VPP details page$")
	public void the_user_validates_planName_matches_plan_Name_in_VPP_details_page() throws Throwable {
		PlanDetailsPage planDetails = new PlanDetailsPage(driver);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		planDetails.validatePlanNameVPPDetails(PlanName);
	}

	@Then("^the user verify the drug cost estimator and view plan summary buttons on VPP detail page$")
	public void the_user_verify_the_drug_cost_estimator_and_VPP_buttons() {
		PlanDetailsPage planDetails = new PlanDetailsPage(driver);
		planDetails.validateBackToDceAndBackToVPPButton();
	}

	@Then("^the user click on drug cost estimator button on vpp plan detail page$")
	public void the_user_click_on_drug_cost_estimator_button_on_vpp_details_page() throws Throwable {
		PlanDetailsPage planDetails = new PlanDetailsPage(driver);
		planDetails.clickOnBacktoDrugCostEstBtn();
	}

	@And("^user clicks on change pharmacy link on alert message from plan card on drug summary page$")
	public void user_clicks_on_change_pharmacy_link_on_alert_message_from_plan_card_on_drug_summary_page() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickChangePharmacyFromAltMsg();
	}

	@Then("^the user verify the default Retail chain pharmacy on drug summary page$")
	public void the_user_verify_the_default_Retail_chain_pharmacy_on_drug_summary_page(DataTable attributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String pharmacyName = memberAttributesMap.get("DefaultPharmacy");
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateDefaultPharmacyName(pharmacyName);
	}

	@Then("^user validate \"([^\"]*)\" pharmacy on drug summary page$")
	public void user_validate_pharmacy_on_drug_summary_page(String pharmacyName) {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateDefaultPharmacyName(pharmacyName);
	}

	@When("^user clicks on Keep Using This Pharmacy link on change pharmacy modal$")
	public void user_clicks_on_keep_using_pharmacy_link_on_change_pharmacy_modal() throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickKeepUsingPharmacyLink();
	}

	@And("^the user clicks on the add drugs button globally on the profile page$")
	public void the_user_clicks_on_the_add_drugs_button_globally_in__profile_page() {
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.clickAddDrugsGlobal();
	}


	@Then("^user click on standard tab from drug details$")
	public void user_click_on_standard_tab_from_drug_details() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateStandardTab();
	}

	@Then("^user verify breadcrumb \"([^\"]*)\" on get started page$")
	public void user_verify_breadcrumb_on_get_started_page(String breadCrumb) {
		GetStartedPage DCEgetStarted = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		DCEgetStarted.validateBreadCrumb(breadCrumb);
	}

	@Then("^user verify breadcrumb \"([^\"]*)\" on drug summary page$")
	public void user_verify_breadcrumb_on_drug_summary_page(String breadCrumb) {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateBreadCrumb(breadCrumb);
	}

	@Then("^user verify breadcrumb \"([^\"]*)\" on drug details page$")
	public void user_verify_breadcrumb_on_drug_details_page(String breadCrumb) {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateBreadCrumb(breadCrumb);
	}

	@Then("^user should be able to see Back to profile button on details page$")
	public void user_should_be_able_to_see_Back_to_profile_button_on_details_page() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.verifyBackToProfileBtnDisplayed();
	}
	
	@Then("^the user verifies NBA modal for creating profile on drug summary page$")
	public void user_verifies_NBAmodal_creating_profile_on_drug_summary() {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateNBAModal();
	}

	@Then("^user click on breadcrumb \"([^\"]*)\" on get started page$")
	public void user_click_breadcrumb_on_get_started_page(String breadCrumb) {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.clickReturnToPharamcySearch();

	}


	@Then("^the user validates OptumRx consistently displays on DCE Summary - Pharmacy Page$")
	public void the_user_validates_OptumRx_consistently_displays_on_DCE_Summary_Pharmacy_Page() throws Throwable {
		DrugSummaryPage drugSummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateOptumRxConsistentDisplay_PharmacyPage();
	
	}

	@Then("^the user validates OptumRx consistently displays on DCE Details - Pharmacy Page$")
	public void the_user_validates_OptumRx_consistently_displays_on_DCE_Details_Pharmacy_Page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateOptumRxConsistentDisplay_PharmacyPage();
	}
	@Then("^clicks on back to plans on plan compare page for AARP$")
	public void clicks_on_back_to_plans_on_plan_compare_page_for_AARP() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnBacktoPlans();
	}
	@Then("^should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site$")
	public void should_be_able_to_see_the_NBA_modal_to_Enroll_Plan_on_the_VPP_summary_page_in_UMS_site() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNextBestActionModalForEnrollPlan();
	}
	@Then("^the user clicks on site logo on drug detail Page and returns back to Acquisition Home Page$")
	public void user_clicks_site_logo_on_drugdetail_returns_Acquisition_home_page(DataTable attributes ) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String siteName = memberAttributesMap.get("Site");
		drugDetailsPage.clickingSiteLogoDrugDetail(siteName);
		
	}

	@Then("^the user validates LIS text for coverages stages popups on DCE details page$")
	public void the_user_validates_LIS_text_for_coverages_stages_popups_on_DCE_details_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDrugStageInfoModals_LISbuydownPlans();
	}

	@Then("^the user validates Non-LIS text for coverages stages popups on DCE details page$")
	public void the_user_validates_NonLIS_text_for_coverages_stages_popups_on_DCE_details_page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDrugStageInfoModals_NonLISbuydownPlans();
	}
	
	@When("^user toggle to PDP plan type on drug summary page$")
	public void user_toggle_to_PDP_plan_type_on_drug_summary_page() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.verifyPDPPlanToggle();
	}

	@When("^user toggle to SNP plan type on drug summary page$")
	public void user_toggle_to_SNP_plan_type_on_drug_summary_page() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.verifySNPPlanToggle();
	}
	
	/**
	 * Adding steps to validate filter on change Pharmacy page
	 * @throws Throwable
	 */

	@Then("^the user validates Pharmacy Filter - Error message and x cancel function is working on Summary page - Change Pharmacy Page$")
	public void the_user_validates_Pharmacy_Filter_Error_message_and_x_cancel_function_is_working_on_Summary_page_Change_Pharmacy_Page() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validatePharmacyFilterErrormessage();
		drugSummaryPage.validateXcleartextPharmacyFilter();
	}

	@Then("^the user applies pharmacy filter for following text on Summary page - Change Pharmacy Page$")
	public void the_user_applies_pharmacy_filter_for_following_text_on_Summary_page_Change_Pharmacy_Page(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String FilterText = memberAttributesMap.get("PharmacyFilterText");
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.ApplyPharmacyFilter(FilterText);
	}

	@Then("^the user validates Pharmacy Filter - Error message and x cancel function is working on Details page - Change Pharmacy Page$")
	public void the_user_validates_Pharmacy_Filter_Error_message_and_x_cancel_function_is_working_on_Details_page_Change_Pharmacy_Page() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validatePharmacyFilterErrormessage();
		drugDetailsPage.validateXcleartextPharmacyFilter();
	}

	@Then("^the user applies pharmacy filter for following text on Preferred pharmacies Tab, Details page - Change Pharmacy Page$")
	public void the_user_applies_pharmacy_filter_for_following_text_on_Preferred_pharmacies_Tab_Details_page_Change_Pharmacy_Page(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);

		String FilterText = memberAttributesMap.get("PharmacyFilterText");		
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validatePreferredTab();
		drugDetailsPage.ApplyPharmacyFilter(FilterText);
	}

	@Then("^the user applies pharmacy filter for following text on Standard pharmacies Tab, Details page - Change Pharmacy Page$")
	public void the_user_applies_pharmacy_filter_for_following_text_on_Standard_pharmacies_Tab_Details_page_Change_Pharmacy_Page(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String FilterText = memberAttributesMap.get("PharmacyFilterText");		
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateStandardTab();
		drugDetailsPage.ApplyPharmacyFilter(FilterText);
	}
	

	@Then("^the user selects the following drug recommendation and validates Drug Search page is displayed and add drug$")
	public void the_user_selects_the_following_drug_recommendation_and_validates_Drug_Search_page_is_displayed_and_add_drug(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String drugName = memberAttributesMap.get("SelectDrugRecommendation");
		System.out.println(drugName);
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);

		boolean drugRecommendationDisplayed;
		drugRecommendationDisplayed = buildDrugList.ClickAddDrugRecommended(drugName);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		System.out.println("Drugs List : " + druglist);
		if(drugRecommendationDisplayed) {
			String DrugName = driver.findElement(By.xpath("//h4[contains(text(), '"+drugName+"')]")).getText();
//			if (druglist.isEmpty()) {
			if(StringUtils.isEmpty(druglist)) {
				System.out.println("Added Drug : "+DrugName+", for Drug recommendation : "+drugName);
				druglist = DrugName;
			} else {
				druglist = druglist + "&" + DrugName;
			}
			System.out.println("Drugs List after Drug " + DrugName + " , Added : " + druglist);
		}
		else {
			System.out.println("Drug Recommendation is not displayed : Drug is not added");
		}
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}
	
	
	@Then("^user validates the return to home link is visible and clicked$")
	public void user_validates_the_return_to_home_link_isvisible(DataTable attributes)
	throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		GetStartedPage drugDetailsPage = new GetStartedPage(driver);
		boolean isDrugDetails = drugDetailsPage.homeLinkIsVisibleAndClicked();
		if(isDrugDetails)
			Assertion.assertTrue("DCE return to home link takes to home page",true);
		else
			Assertion.fail("DCE return to home does not take to home page 	");
	}	
	

	@Given("^user is on Yahoo or google and search UHC drug cost estimator and navigate to dce page$")
	public void user_is_on_Yahoo_and_search_AARP_Medicare_Advantage_Plan_to_navigate_to_AARP_page(DataTable attributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String searchParameter = memberAttributesMap.get("searchParameter");
		String searchengine = memberAttributesMap.get("searchengine");
		WebDriver wd = getLoginScenario().getWebDriverNew();
		GetStartedPage dcepage = new GetStartedPage(wd,true);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
		if(searchengine.equalsIgnoreCase("yahoo")){
			String url = "https://www.Yahoo.com/";
			dcepage.openUrl(url);
			dcepage.yahooSearch(searchParameter);
		}else{
			String url = "https://www.google.com/";
			dcepage.openUrl(url);
			dcepage.googleSearch(searchParameter);
		}
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, dcepage);
	}

	@Then("^the user validates default view for Plan Effective Date$")
	public void the_user_validates_default_view_for_Plan_Effective_Date() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		scenario.log("Sneha Dwarakanath - Updated the stepdef to validate current plan year in default PED text. For F628155 - DCE | Plan Effective Null Values for Compare Flows (PRB0982203)");
		String testSiteUrl=(String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		String currentEnvTime=drugDetailsPage.getAcqTestEnvSysTime(testSiteUrl);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_TIME, currentEnvTime);
		String[] tmpDateAndTime=currentEnvTime.split(" ");
		String[] tmpDate=tmpDateAndTime[0].split("/");
		String envMonth=tmpDate[0];
		System.out.println("TEST - sysTimeMonth = "+envMonth);
		String envTimeYear=tmpDate[tmpDate.length-1];
		System.out.println("TEST - sysTimeYear = "+envTimeYear);
		drugDetailsPage.validateDefaultPED(envTimeYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR, envTimeYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_MONTH, envMonth);
	}

	@Then("^the user validates Change effective date Dropdown$")
	public void the_user_validates_Change_effective_date_Dropdown() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String testSiteUrl=(String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		String currentEnvTime=drugDetailsPage.getAcqTestEnvSysTime(testSiteUrl);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_TIME, currentEnvTime);
		String[] tmpDateAndTime=currentEnvTime.split(" ");
		String[] tmpDate=tmpDateAndTime[0].split("/");
		String envMonth=tmpDate[0];
		System.out.println("TEST - sysTimeMonth = "+envMonth);
		String envTimeYear=tmpDate[tmpDate.length-1];
		System.out.println("TEST - sysTimeYear = "+envTimeYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR, envTimeYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_MONTH, envMonth);
		drugDetailsPage.validateChangePEDDropDwn(envMonth,envTimeYear);

	}

	@Then("^the user validates Change effective date modal and display after changing effective date$")
	public void the_user_validates_Change_effective_date_modal_and_display_after_changing_effective_date() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String envMonth = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_SYSTEM_MONTH);
		drugDetailsPage.validateChangePEDandModalandChangeDisplay();
	}

	@Then("^the user validates Reset effective date$")
	public void the_user_validates_Reset_effective_date() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		scenario.log("Sneha Dwarakanath - Updated the stepdef to validate current plan year in default PED text. For F628155 - DCE | Plan Effective Null Values for Compare Flows (PRB0982203)");
		String envTimeYear = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR);
		drugDetailsPage.validateResetEffectiveDate(envTimeYear);
	}

	@Then("^the user validate no bar is displayed for November and December$")
	public void the_user_validate_no_bar_is_displayed_for_November_and_December() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateNoBarChartDisplayforNovDec();

	}

	/**
	 * Axding Steps for Drugs and providers Imports Validation for DCE - Authenticated Profiles
	 * @throws Throwable
	 */
	@Then("^the user validates Import Option is displayed$")
	public void the_user_validates_Import_Option_is_displayed() throws Throwable {
		GetStartedPage getStartedPage = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		getStartedPage.ValidateImportOptionDIspalyed();
	}
	@Then("^the user clicks on Import Drugs and validates Import Flow \\- Imports Get Started\\, Member NonMember Selection modals$")
	public void the_user_clicks_on_Import_Drugs_and_validates_Import_Flow_Imports_Get_Started_Member_NonMember_Selection_modals(DataTable attributes) throws Throwable {
		GetStartedPage getStartedPage = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		Map<String,String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String Authenticated_Flag = memberAttributesMap.get("AuthenticatedFlag");
		getStartedPage.ClickImportValidateModals(Authenticated_Flag);
	}

	@Given("^the user selects Member and provides Member Details and proceeds to import$")
	public void the_user_selects_Member_and_provides_Member_Details_and_proceeds_to_import(DataTable attributes) {
		Map<String,String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String FirstName = "";
		String LastName = "";
		if(memberAttributesMap.get("AuthenticatedFlag").equalsIgnoreCase("false")){
			 FirstName = memberAttributesMap.get("FirstName");
			 LastName = memberAttributesMap.get("LastName");
		}
		String AuthenticatedFlag = memberAttributesMap.get("AuthenticatedFlag");
		String Member_DOB = memberAttributesMap.get("DOB");
		String Member_Zip = memberAttributesMap.get("ZipCode");
		String Member_MBI = memberAttributesMap.get("MBI");
		GetStartedPage getStartedPage = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		getStartedPage.EnterMemberDetailsAndImport(AuthenticatedFlag, FirstName, LastName, Member_DOB, Member_Zip, Member_MBI);
	}

	@Given("^the user validates Import Success/Failure modal as follows$")
	public void the_user_validates_Success_Failure_modal_as_follows(DataTable attributes) {
		Map<String,String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String DrugsFlag = memberAttributesMap.get("DrugsFlag");
		String ProvidersFlag = memberAttributesMap.get("ProvidersFlag");
		GetStartedPage getStartedPage = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		getStartedPage.ValidateImportCompleteModal(DrugsFlag, ProvidersFlag);
	}

	@Then("^the user clicks on Review Imported Drugs and lands on Build your Drug List Page$")
	public void the_user_clicks_on_Review_Imported_Drugs_and_lands_on_Build_your_Drug_List_Page() throws Throwable {
		GetStartedPage getStartedPage = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		BuildYourDrugList buildYourDrugList = getStartedPage.ClickReviewAddDrugsBtn();
		getLoginScenario()
				.saveBean(PageConstants.DCE_Redesign_BuildDrugList,buildYourDrugList);
	}

	@Given("^the user selects NonMember, validates disclsimer page and provides following NonMember Details and proceeds to import$")
	public void the_user_selects_NonMember_and_provides_NonMember_Details_and_proceeds_to_import(DataTable attributes) {
		Map<String,String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String NonMember_DOB = memberAttributesMap.get("DOB");
		String NonMember_Zip = memberAttributesMap.get("ZipCode");
		String NonMember_Gender = memberAttributesMap.get("Gender");
		GetStartedPage getStartedPage = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		getStartedPage.EnterNonMemberDetailsAndImport(NonMember_DOB, NonMember_Zip, NonMember_Gender);
	}

	/**
	 * Step Header Flags as follows
	 * C - Current
	 * E - Enabled
	 * D - Disabled
	 **/
	@Then("the user validates the Step Header as follows")
	public void the_user_validates_teh_step_header_as_follows(io.cucumber.datatable.DataTable attributes) {
		scenario.log("Sneha Dwarakanath - Change made 06/07/2021 - Step Header validation Added --> C for Current, E for Enabled, D for Disabled ");
		Map<String,String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String StepHeaderFlag = memberAttributesMap.get("Flags");
		System.out.println("Flags -->>"+StepHeaderFlag);
		DCEStepHeader dceStepHeader = new DCEStepHeader(driver);
		dceStepHeader.validateStepHeader(StepHeaderFlag);
	}
	@Then("the user clicks on Step Header Step {int} to land on Build your drug list Page")
	public void the_user_clicks_on_step_header_step_to_land_on_build_your_drug_list_page(Integer int1) {
		scenario.log("Sneha Dwarakanath - Change made 06/07/2021 - Step Header Navigation validation Added ");
		DCEStepHeader dceStepHeader = new DCEStepHeader(driver);
		BuildYourDrugList buildDrugListPage = dceStepHeader.ClickStep2_NavigateDrugListPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugListPage);
	}

	@Then("the user clicks on Step Header Step {int} to land on Drug Details Page")
	public void the_user_clicks_on_step_header_step_to_land_on_drug_details_page(Integer int1) {
		scenario.log("Sneha Dwarakanath - Change made 06/07/2021 - Step Header Navigation validation Added ");
		DCEStepHeader dceStepHeader = new DCEStepHeader(driver);
		DrugDetailsPage drugDetailsPage = dceStepHeader.ClickStep3_NavigateDrugDetailsPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("the user clicks on Step Header Step {int} to land on Drug Summary Page")
	public void the_user_clicks_on_step_header_step_to_land_on_drug_summary_page(Integer int1) {
		scenario.log("Sneha Dwarakanath - Change made 06/07/2021 - Step Header Navigation validation Added ");
		DCEStepHeader dceStepHeader = new DCEStepHeader(driver);
		DrugSummaryPage drugSummaryPage = dceStepHeader.ClickStep3_NavigateDrugSummaryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}


    @Then("the user clicks on Edit Drug list link on View Drug pricing modal")
    public void the_user_clicks_on_edit_drug_list_link_on_view_drug_pricing_modal() {
		scenario.log("Sneha Dwarakanath - Change made for July Release - F603797: DCE | Mobile First Optimization | Edit Drug List from Summary | Desktop & Mobile");
		scenario.log("Sneha Dwarakanath - Change made for July Release - F603797: step added to @dce_DrugSummary_Page or @dce_MedEdPage_E2E_Scenario4_UAT");

		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
        BuildYourDrugList buildDrugListPage = drugSummaryPage.clickEditDrugs_DrugPricingModal();
        getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugListPage);
    }
    @Then("the user clicks on Review Button on Build Drug Page to land on DCE Summary page")
    public void the_user_clicks_on_review_button_on_build_drug_page_to_land_on_dce_summary_page() {
		scenario.log("Sneha Dwarakanath - Change made for July Release - F603797: DCE | Mobile First Optimization | Edit Drug List from Summary | Desktop & Mobile");
		scenario.log("Sneha Dwarakanath - Change made for July Release - F603797: step added to @dce_DrugSummary_Page or @dce_MedEdPage_E2E_Scenario4_UAT");
		BuildYourDrugList buildDrugListPage = (BuildYourDrugList) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
        DrugSummaryPage drugSummaryPage = buildDrugListPage.navigateToDrugSummaryPage();
        drugSummaryPage.validateDrugSummaryPage();
        getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
    }

	@When("user enters valid zipcode and county for Multi county as follows")
	public void user_enters_valid_zipcode_and_county_for_multi_county_as_follows(io.cucumber.datatable.DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String zipcode = memberAttributesMap.get("ZipCode");
		String County = memberAttributesMap.get("County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.enterZipCodeandcounty(zipcode);
		zipCodePlanYearPage.selectCounty(County);
	}

	@Then("the user validates Tier {int} Copay in copay section and in Your Drugs section")
	public void the_user_validates_tier_copay_in_copay_section_and_in_your_drugs_section(Integer int1, io.cucumber.datatable.DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String TierNo = "Tier "+String.valueOf(int1);
		String TierCopay = memberAttributesMap.get("TierCopay");
		System.out.println("Expected Tier - Copay : "+TierNo+" - "+TierCopay);
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateTierCopay_CopaySection(TierNo,TierCopay);
		drugDetailsPage.validateTierCopay_YourDrugsSection(TierNo,TierCopay);
	}

	@Then("the user validates the deductible as follows")
	public void the_user_validates_the_deductible_as_follows(io.cucumber.datatable.DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String Deductible = memberAttributesMap.get("Deductible");
		System.out.println("Expected Deductible : "+Deductible);
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDeductible_CopaySection(Deductible);
	}

	@Then("the user validates the text for coverage stages modal popups for Non-LIS Plans")
	public void the_user_validates_the_text_for_coverage_stages_modal_popups_for_NonLIS() {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateCoveragestagePopUpText();
	}


	@Then("the user validates Copay Section for LIS for defined standard plan for following")
	public void the_user_validates_copay_section_for_lis_for_defined_standard_plan_for_following(io.cucumber.datatable.DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String LIScopay = memberAttributesMap.get("LIScopay");
		System.out.println("Expected LIS Copay for Defined Standard plan : "+LIScopay);
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDefStandard_LIScopay(LIScopay);
	}

	@Then("the user validates Copay Section for non-LIS for defined standard plan for following")
	public void the_user_validates_copay_section_for_non_lis_for_defined_standard_plan_for_following(io.cucumber.datatable.DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String nonLIScopay = memberAttributesMap.get("NonLIScopay");
		System.out.println("Expected LIS Copay for Defined Standard plan : "+nonLIScopay);
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDefStandard_nonLIScopay(nonLIScopay);

	}

	@Then("the user validates deductible as follows for Defined Standard plans")
	public void the_user_validates_deductible_as_follows_for_defined_standard_plans(io.cucumber.datatable.DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String deductible = memberAttributesMap.get("Deductible");
		System.out.println("Expected Deductible for Defined Standard plan : "+deductible);
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDefStandard_Deductible(deductible);
	}


    @Then("the user validates the deductible stage modal text for plans having deductible as follows")
    public void the_user_validates_the_deductible_stage_modal_text_for_plans_having_deductible_as_follows(io.cucumber.datatable.DataTable givenAttributes) {
        Map<String, String> memberAttributesMap = new HashMap<String, String>();
        memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
        String deductibleFlag = memberAttributesMap.get("DeductibleFlag");
        System.out.println("Plan has a deductible and will show the deductible stage modal link : "+deductibleFlag);
        DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
                .getBean(PageConstants.DCE_Redesign_DrugDetails);
        if(deductibleFlag.equalsIgnoreCase("true") || deductibleFlag.equalsIgnoreCase("yes"))
            drugDetailsPage.validateModalText_DeductibleStage(deductibleFlag);
    }

	
	@When("^user should be able to click on plan and view drug cost$")
	public void user_should_be_able_to_click_plantype_and_view_drugcost_for_plan(DataTable givenAttributes) throws Throwable {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String planType = memberAttributesMap.get("planType");
		String planName = memberAttributesMap.get("planName");
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		
		drugSummaryPage.selectAndVerifyPlanType(planType, planName);
		
	}
	
	@Then("^user should be able to save drugs$")
	public void user_saves_drud_cost(){
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugDetailsPage drugDetailPage = new DrugDetailsPage(driver);
		
		drugDetailPage.saveDrug();
				
	}

	@And("^the user clicks on the shopping cart icon from DCE$")
	public void the_user_clicks_on_the_shopping_cart_icon_in_AARP_site() {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		
		AcquisitionHomePage acqHomePage = new AcquisitionHomePage(driver);

		VisitorProfilePage visitorProfilePage = acqHomePage.navigateToVisitorProfilePage();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
    
	@Then("^the user validates Get Started Page vp$")
	public void the_user_validates_Get_Started_Page_vp(DataTable givenAttributes) throws Throwable {
		
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String site = memberAttributesMap.get("Site");
		
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(driver);

		aquisitionhomepage.navigateToURL(site);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);

	}
	
	@Then("^remove drug from the saved profile$")
	public void remove_drug_from_saved_profile(DataTable givenAttributes) {
		
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		
		String drugName = memberAttributesMap.get("DrugName");
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.deleteDrugProfile(drugName);
		//button[contains(@aria-label,"Edit ")]
		
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		
	}


	@Then("the user clicks edit drugs on Compare page to land on Build Drug List Page")
	public void the_user_clicks_edit_drugs_on_compare_page_to_land_on_build_drug_list_page() {
		ComparePlansPage planComparepage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		BuildYourDrugList buildYourDrugList = planComparepage.clickonEdityourDrugs();
		if (null != buildYourDrugList) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildYourDrugList);
		} else
			Assertion.fail("DCE Redesign page object not loaded");

	}


	@Then("the user validates default Plan type on DCE Summary page as follows")
	public void the_user_validates_default_plan_type_on_dce_summary_page_as_follows(DataTable givenAttributes) {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String planType = memberAttributesMap.get("Plan Type");
		System.out.println(planType);

		drugSummaryPage.VerifyDefautTab(planType);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);

	}

	@Then("the user clicks Return to Compare on DCE Summary Page to return to Compare page")
	public void the_user_clicks_return_to_compare_on_dce_summary_page_to_return_to_compare_page() {
	}

}