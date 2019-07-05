package acceptancetests.acquisition.pharmacylocator;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.PharmacyResultPage;
import pages.acquisition.ulayer.PharmacySearchPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality:PharmacyLocator
 */
public class PharmacyLocatorStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;
	String langName;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}
	/**
	 *  user is on the AARP Medicare Site landing page
	 */
	@Given("^the user is on the AARP Medicare Site landing page$")
	public void registered_member_located_pharmacy_aarp() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		AcquisitionHomePage acqusitionHomePage = new AcquisitionHomePage(wd);
		Assert.assertTrue("PROBLEM - unable to navigate to AARP Medicare site", acqusitionHomePage != null);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acqusitionHomePage);
		/* tbd-remove
		if (acqusitionHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acqusitionHomePage);
			Assert.assertTrue(true);
		} */
	}

	/**
	 * user hovers to Our Plans and select Request More Help and Information for following plan type
	 */
	@When("^the user hovers on shop for a Plan and select Request More Help and Information for following plan type in AARP Site$")
	public void user_hovers_to_our_plans_and_select_request_more_help_and_information_aarp(DataTable planAttributes){
		String planType = planAttributes.getGherkinRows().get(0).getCells().get(0);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_TYPE, planType);
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.navigateToRequestMoreHelpAndInformation(planType);
	}

	/**
	 *  user navigates to pharmacy search page
	 */
	@When("^the user navigates to pharmacy search page in AARP Site$")
	public void user_views_pharmacy_locator_aarp() {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = acqusitionHomePage
				.navigateToPharmacyLocator();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page", pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
				pharmacySearchPage);
		/* tbd-remove
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
			//pharmacySearchPage.validateDefaultChooseaPlanSection();
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		} */
	}

	

	/**
	 * user enters following details for pharmacy search
	 */
	@And("^the user enters following details for pharmacy search in AARP Site$")
	public void user_enters_zipcode_distance_details_aarp(DataTable zipAttributes) {
		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {
			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
					zipAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = zipAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE,
				zipcode);
		String distance = zipAttributesMap.get("Distance");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.DISTANCE,
				distance);
		String county = zipAttributesMap.get("County Name");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.COUNTY,
				county);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.enterZipDistanceDetails(zipcode, distance, county);
	}

	/**
	 * user selects a language from dropdown 
	 */
	@And("^the user selects a language from dropdown in AARP Site$")
	public void user_selects_language_aarp(DataTable languageAttributes) {
		langName = languageAttributes.getGherkinRows().get(0).getCells().get(0);
		if (("Spanish").equalsIgnoreCase(langName)) {
			langName = "es";
		} else if (("Chinese").equalsIgnoreCase(langName)) {
			langName = "zh";
		} else {
			langName = "en";
		}
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectLanguage(langName);
	}

	/**
	 * user chooses a plan from dropdown
	 */
	@And("^the user chooses a plan from dropdown in AARP Site$")
	public void user_chooses_plan_dropdown_aarp(DataTable planAttributes) {
		List<DataTableRow> zipAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {
			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0), zipAttributesRow.get(i).getCells().get(1));
		}
		String planName = zipAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, planName);
		
		String planYear = zipAttributesMap.get("planyear");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_YEAR, planYear);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		Boolean isplanyear = pharmacySearchPage.isPlanYear();
		if (isplanyear) {
			pharmacySearchPage.selectsPlanYear(planYear);
		}
		pharmacySearchPage.selectsPlanName(planName);
	}

	/**
	 * user chooses the Pharmacy Type
	 */
	@Then("^the user chooses the Pharmacy Type$")
	public void the_user_chooses_the_pharmacy_type(DataTable pharmacyTypeAttribute) {
		String PharmacyType = pharmacyTypeAttribute.getGherkinRows().get(0).getCells().get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean isPharmacySelected;
		isPharmacySelected = pharmacySearchPage.selectPharmacyandServices(PharmacyType);
		Assert.assertTrue("PROBLEM - Error in selecting pharmacy type!!!", isPharmacySelected);
		/* tbd-remove
		if (!isPharmacySelected) {
			Assert.fail("Error in selecting pharmacy type!!!");
		} */
	}

	/**
	 * user chooses the Service Type
	 */
	@Then("^the user chooses the Service Type$")
	public void the_user_chooses_the_service_type(DataTable serviceTypeAttribute) {
		String serviceType = serviceTypeAttribute.getGherkinRows().get(0).getCells().get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean isServicesSelected;
		isServicesSelected = pharmacySearchPage.selectPharmacyandServices(serviceType);
		Assert.assertTrue("PROBLEM - Error in selecting service type!!!", isServicesSelected);
		/* tbd-remove
		if (!isServicesSelected) {
			Assert.fail("Error in selecting service type!!!");
		} */
	}

	/**
	 * user searches available pharmacies by selecting 
	 */
	@And("^the user searches available pharmacies by selecting \"Show pharmacies for ALL types\" in AARP site$")
	public void user_selects_show_pharmacy_for_all_pharmacy_types_aarp() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.showAllPharmacies();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page", pharmacyResultPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE,
				pharmacyResultPage);
		/* Get actual data */
		JSONObject pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
		getLoginScenario().saveBean(
				PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
				pharmacyResultActualJson);
		/* tbd-remove
		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE,
					pharmacyResultPage);
			//Get actual data 
			JSONObject pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
			getLoginScenario().saveBean(
					PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
					pharmacyResultActualJson);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		} */
	}

	/**
	 * user searches available pharmacies by selecting
	 */
	@And("the user searches available pharmacies by selecting \"Show pharmacies for these services.\" in AARP site$")
	public void  user_searches_pharmacies_by_choosing_pharmacy_types_aarp(DataTable pharmacyTypeAttributes) {
		String[] pharmacyTypeArray = pharmacyTypeAttributes.getGherkinRows().get(0).getCells().get(0).split(",");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage.searchSelectingPharmacyTypes(pharmacyTypeArray);
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page", pharmacyResultPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE,
				pharmacyResultPage);
		/* Get actual data */
		JSONObject pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
		getLoginScenario().saveBean(
				PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
				pharmacyResultActualJson);
		/* tbd-remove
		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE,
					pharmacyResultPage);
			// Get actual data 
			JSONObject pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
			getLoginScenario().saveBean(
					PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
					pharmacyResultActualJson);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}*/
	}

	/**
	 * user validates the error message for no pharmacies found for below pharmacy
	 */
	@Then("^the user validates the error message for no pharmacies found for below pharmacy in the AARP Site$")
	public void validates_error_msg_for_no_pharmacies_found_aarp(DataTable pharmacyTypeAttributes){
		String[] pharmacyTypeArray = pharmacyTypeAttributes.getGherkinRows().get(0).getCells().get(0).split(",");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateNoPharmacyErrormsg(pharmacyTypeArray);
	}

	/**
	 * user clicks on SearchAgain and navigates to pharmacies search page
	 */
	@Then("^the user clicks on SearchAgain and navigates to pharmacies search page in the AARP site$")
	public void clicks_searchAgain_navigates_to_pharmaacies_search_page_aarp(){
		PharmacyResultPage pharmacyResultPage = (PharmacyResultPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_RESULTS_PAGE);
		PharmacySearchPage pharmacySearchPage = pharmacyResultPage.navigateTopharmacySearch();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page", pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
				pharmacySearchPage);
		/* tbd-remove
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
		}else {
			Assert.fail("Failed to load Pharmacy search page");
		} */
	}

	/**
	 * user should see county popup
	 */
	@Then("^the user should see county popup in AARP site$")
	public void user_should_see_county_popup_aarp() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		Assert.assertTrue("PROBLEM - County Pop up did not appear",pharmacySearchPage.validateCountypopoup());
		/* tbd-remove
		if(pharmacySearchPage.validateCountypopoup()){
			Assert.assertTrue(true);
		} else {
			Assert.fail("County Pop up did not appear");
		} */
	}

	/**
	 * user selects the county
	 */
	@When("^the user selects the county in AARP site$")
	public void user_selects_county_aarp(DataTable countyAttributes){
		String countyName = countyAttributes.getGherkinRows().get(0).getCells().get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectCounty(countyName);
	}

	/**
	 * user should see choose a plan
	 */
	@Then("^the user should see choose a plan in AARP site$")
	public void user_should_see_choose_plan_aarp(){
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateChoosePlanSectionAfterzipcodeSearch();
	}

	/**
	 * user validates the available pharmacies page
	 */
	@Then("^the user validates the available pharmacies page in AARP site$")
	public void user_validates_available_pharmacies_aarp() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		Assert.assertTrue("PROBLEM - Error in validating Pharmacy Results", pharmacySearchPage.validatePharmacyResults());
		/* tbd-remove
		if (pharmacySearchPage.validatePharmacyResults()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating Pharmacy Results ");
		} */
	}

	/**
	 * user hovers to Our Plans and select Request More Help and Information for following plan type
	 */
	@When("^the user hovers to Our Plans and select pharmacy search for following plan type in AARP Site$")
	public void user_hovers_to_our_plans_and_select_request_more_help_and_information_aarp(){
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage =acqusitionHomePage.navigateToPharmacyLocator();
		Assert.assertTrue("PROBLEM - Not able to navigate to Pharmacy page", pharmacySearchPage!=null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,pharmacySearchPage);
		/* tbd-remove
		if (pharmacySearchPage!=null){
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,pharmacySearchPage);
		} else{
			Assert.fail("Not able to navigate to Pharmacy page");
		} */
	}

	/**
	 * user validates the available pharmacies page
	 */
	@Then("^the user validates language changes in AARP site$")
	public void user_validates_language_changes_aarp() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		Assert.assertTrue("Changes to language is not successful",
				pharmacySearchPage.validateLanguageChanges(langName));
	}

	@And("^the user enters following Multi County details and  validates the Cancel button for Multi COunty Pop-up clears the Zip code text fields in pharmacy search in AARP Site$")
	public void user_enters_MultiCounty_zip_to_validate(DataTable zipAttributes) {
		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {
			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
					zipAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = zipAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE,
				zipcode);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.enterZipCode(zipcode);
		boolean Validation_Flag = pharmacySearchPage.validate_MultiCounty_CancelBtn();
		Assert.assertTrue("Validation failed : Cancel button Validation for Multi County Pop-up Failed ",Validation_Flag);
	}

	@Then("^the user validates the no pharmacies display error message$")
	public void the_user_validates_the_no_pharmacies_error_message(){
		//String PharmacyType = pharmacyTypeAttribute.getGherkinRows().get(0).getCells().get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean isPharmacySelected;
		isPharmacySelected = pharmacySearchPage.validateNoPharmaciesErrorMessage();
		Assert.assertTrue("PROBLEM - Error in selecting pharmacy type!!!",isPharmacySelected);
		/* tbd-remove
		if (!isPharmacySelected) {
			Assert.fail("Error in selecting pharmacy type!!!");
		} */
	}

	@And("^the user enters the invalid zipcode and validates the no results error message$")
	public void the_invalid_zipcode_error_message_validation(){
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateNoresultsZipcodeError();
	}

	
	/** Verifying the error message in pharmacy search tool */	
	@And("^the user verify error messages in pharmacy locator page$")
	public void verifyPharmacyErrorMessages() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String inputZip=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.ZIPCODE);
		pharmacySearchPage = pharmacySearchPage.verifyPharmacyErrormessages(inputZip);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
	}
	
	/** Verify the pharmacies as per the filter criteria 
	 * @throws InterruptedException */
	@Then("^the user validates the pharmacies available$")
	public void validatesPharmaciesAvailable(DataTable inputAttributes) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String planName=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		pharmacySearchPage.searchesPharmacy(language,planName);
	//tbd 	Assert.assertTrue("PROBLEM - Pharmacy Results Not Displayed",
		//tbd 			pharmacySearchPage != null);
		//tbd 	getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,pharmacySearchPage);
	}

	/** Verify tooltips on the filters */
	@And("^the user validates tooltips on filters$")
	public void verifyTooltips(DataTable inputData) {
		Map<String, String> inputDataMap=parseInputArguments(inputData);
		String memberType = inputDataMap.get("Member Type");
		String language = inputDataMap.get("Language");
		String tmp=inputDataMap.get("Has Preferred Retail Pharmacy network").trim();
		Assert.assertTrue("PROBLEM - input 'Has Preferred Retail Pharmacy network Widget' should be True or False. Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateAllTooltips(memberType, language, hasPrefRetailPharmacy);
	}
	
	
	@And("^the user validates map section content$")
	public void verifyMapSectionContent() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateMapSectionContent();
	}
	
	/** Verifying show on map link clickable for pharmacies appearing in the search results */
	@Then("^the user validates show on map link$")
	public void viewsShowOnMapResult() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateShowOnMapLinks();
		Assert.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}
	

	@Then("^the user validates get direction link$")
	public void getDirectionResult() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateGetDirectionLinks();
		Assert.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}
	
	/** Verify search results based on plan type */
	@And("^the user validates more information content based on plan type$")
	public void validateMoreInformationContent() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateMoreInfoContent();
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("More Info Disclaimer is Displayed");
	}
	
	/**
	 * Verify Create a PDF in pharmacy search page
	 * @throws InterruptedException 
	 */
	@Then("^the user validates view search PDF link$")
	public void viewsSearchResultPdf() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.ValidateSearchPdfResults();
		Assert.assertTrue("PROBLEM - PDF Results Page Not Displayed", 
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("PDF Result Page is Displayed");
	}

	@Then("^the user validates pharmacy widgets$")
	public void verifyPharmacyWidgets(DataTable inputData) { 
		Map<String, String> inputDataMap=parseInputArguments(inputData);
		String planType = inputDataMap.get("Plan Type");
		String memberType = inputDataMap.get("Member Type");
		String planName = inputDataMap.get("Plan Name");
		String tmp=inputDataMap.get("Has Preferred Retail Pharmacy network").trim();
		Assert.assertTrue("PROBLEM - input 'Has Preferred Retail Pharmacy network Widget' should be True or False. Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);
	
		tmp=inputDataMap.get("Has Walgreens").trim();
		Assert.assertTrue("PROBLEM - input 'Has Walgreens Widget' should be True or False. Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasWalgreens = Boolean.parseBoolean(tmp);

		tmp=inputDataMap.get("Has Preferred Mail Service Pharmacy").trim();
		Assert.assertTrue("PROBLEM - input 'Has Preferred Mail Service Pharmacy Widget' should be True or False. Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefMailServ = Boolean.parseBoolean(tmp);
		
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validatePharmacyWidgets(planType, memberType,planName,
				hasPrefRetailPharmacy, hasWalgreens, hasPrefMailServ);
	}
	
	/** Choosing the different set of combination in Pharmacy filter */
	@When("^the user selects Pharmacy Types to Filter$")
	public void selectsPharmacyTypesfilter(DataTable pharmacyAttributes) {
		Map<String, String> PharmacyAttributesMap=parseInputArguments(pharmacyAttributes);
		String pharmacyType = PharmacyAttributesMap.get("Pharmacy Type");
		String language = PharmacyAttributesMap.get("Language");
		System.out.println("Filter Type to Select : "+pharmacyType);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.Select_PlanType_Filter(pharmacyType, language);
//tbd 		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page",
		//tbd 				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,	pharmacySearchPage);
	}

	
	@Then("^the user selects Chinese Language$")
	public void selectChinese() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.clickChinese();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page - Chinese Language Selected",pharmacySearchPage != null);
	}
	
	/** Verifying the pharmacy search tool in Spanish language */	
	@Then("^the user selects Spanish Language$")
	public void selectSpanish() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectspanLanguage();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page - Spanish Language Selected",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
	}
	
	/** Verifying the pharmacy search tool in different languages */	
	@And("^the user searches multi lang for pharmacy search results available$")
	public void viewsMultiLangPharmacySearch() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.multilangPharmacySearchResult();
		Assert.assertTrue("PROBLEM - Pharmacy Results are NOT Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("Pharmacy Results are Displayed");
	}
	
	@And("^the user validates header section content$")
	public void verifyHeaderSection() {
		
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateHeaderSection();
	}
	
	/** Filter criteria verification in pharmacy tool page */
	@And("^the user enters following details for pharmacy search$")
	public void enterZipCodeForNewSearch(DataTable zipAttributes) {
		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {

			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
					zipAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = zipAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE,
				zipcode);
		String distance = zipAttributesMap.get("Distance");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.DISTANCE,
				distance);
		String county = zipAttributesMap.get("County Name");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.COUNTY,
				county);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.COUNTY, county);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		System.out.println("Zip Code is '"+zipcode+"' | Distance is '"+distance+"' | County is '"+county+"'");
		/*if (county==null) {
			System.out.println("TEST - no county");
		} else {
			System.out.println("TEST - has county");
		}*/
		pharmacySearchPage = pharmacySearchPage.enterDistanceZipCountyDetails(distance,zipcode,county );
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,	pharmacySearchPage);
	}



	@Then("^the user validates the question widget$")
	public void validateQuestionWidget() {
		
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateQuestionsWidget();
	}
	
	/**
	 *  user is on the AARP Medicare Site landing page
	 */
	@Given("^the user is on the Acquisition Site landing page$")
	public void validateUserIsOnAcquisitionSite(DataTable pharmacyAttributes) {
		
		Map<String, String> PharmacyAttributesMap=parseInputArguments(pharmacyAttributes);
		String siteName = PharmacyAttributesMap.get("Site Name");
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd,siteName);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	}
	
	
