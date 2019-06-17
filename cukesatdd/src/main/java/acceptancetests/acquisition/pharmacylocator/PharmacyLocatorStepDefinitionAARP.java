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

	/**
	 * @toDo: user is on the AARP Medicare Site landing page
	 */
	@Given("^the user is on the AARP Medicare Site landing page$")
	public void registered_member_located_pharmacy_aarp() {
		WebDriver wd = getLoginScenario().getWebDriver();
	
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		AcquisitionHomePage acqusitionHomePage = new AcquisitionHomePage(wd);

		if (acqusitionHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acqusitionHomePage);
			Assert.assertTrue(true);
		}
	}
	
	/**
	 * @toDo:user hovers to Our Plans and select Request More Help and Information for following plan type
	 */
	@When("^the user hovers to shop for a Plan and select Request More Help and Information for following plan type in AARP Site$")
	public void user_hovers_to_our_plans_and_select_request_more_help_and_information_aarp(DataTable planAttributes){
		
		String planType = planAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_TYPE, planType);
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.navigateToRequestMoreHelpAndInformation(planType);
	}

	/**
	 * @toDo: user navigates to pharmacy search page
	 */
	@When("^the user navigates to pharmacy search page in AARP Site$")
	public void user_views_pharmacy_locator_aarp() {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = acqusitionHomePage
				.navigateToPharmacyLocator();

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
			//pharmacySearchPage.validateDefaultChooseaPlanSection();
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	/**
	 * @toDo:user enters following details for pharmacy search
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
	 * @toDo:user selects a language from dropdown 
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
	 * @toDo:user chooses a plan from dropdown
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

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		Boolean isplanyear = pharmacySearchPage.isPlanYear();
		if (isplanyear) {
			pharmacySearchPage.selectsPlanYear(planYear);
		}
		pharmacySearchPage.selectsPlanName(planName);
	}
	
	/**
	 * @toDo:user chooses the Pharmacy Type
	 */
	@Then("^the user chooses the Pharmacy Type$")
	public void the_user_chooses_the_pharmacy_type(DataTable pharmacyTypeAttribute) {

		String PharmacyType = pharmacyTypeAttribute.getGherkinRows().get(0).getCells().get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean isPharmacySelected;
		isPharmacySelected = pharmacySearchPage.selectPharmacyandServices(PharmacyType);

		if (!isPharmacySelected) {
			Assert.fail("Error in selecting pharmacy type!!!");
		}
	}
	
	/**
	 * @toDo:user chooses the Service Type
	 */
	@Then("^the user chooses the Service Type$")
	public void the_user_chooses_the_service_type(DataTable serviceTypeAttribute) {
		String serviceType = serviceTypeAttribute.getGherkinRows().get(0).getCells().get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean isServicesSelected;
		isServicesSelected = pharmacySearchPage.selectPharmacyandServices(serviceType);
		if (!isServicesSelected) {
			Assert.fail("Error in selecting service type!!!");
		}
	}
	
	/**
	 * @toDo:user searches available pharmacies by selecting 
	 */
	@And("^the user searches available pharmacies by selecting \"Show pharmacies for ALL types\" in AARP site$")
	public void user_selects_show_pharmacy_for_all_pharmacy_types_aarp() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);

		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.showAllPharmacies();

		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE,
					pharmacyResultPage);

			
			/* Get actual data */
			JSONObject pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
			getLoginScenario().saveBean(
					PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
					pharmacyResultActualJson);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	/**
	 * @toDo:user searches available pharmacies by selecting
	 */
	@And("the user searches available pharmacies by selecting \"Show pharmacies for these services.\" in AARP site$")
	public void  user_searches_pharmacies_by_choosing_pharmacy_types_aarp(DataTable pharmacyTypeAttributes)
	{
		String[] pharmacyTypeArray = pharmacyTypeAttributes.getGherkinRows().get(0).getCells().get(0).split(",");
		
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage.searchSelectingPharmacyTypes(pharmacyTypeArray);

		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE,
					pharmacyResultPage);

			

			/* Get actual data */
			JSONObject pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
			getLoginScenario().saveBean(
					PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
					pharmacyResultActualJson);
			
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
		
	}
	
	/**
	 * @toDo:user validates the error message for no pharmacies found for below pharmacy
	 */
	@Then("^the user validates the error message for no pharmacies found for below pharmacy in the AARP Site$")
	public void validates_error_msg_for_no_pharmacies_found_aarp(DataTable pharmacyTypeAttributes){
		String[] pharmacyTypeArray = pharmacyTypeAttributes.getGherkinRows().get(0).getCells().get(0).split(",");
		
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateNoPharmacyErrormsg(pharmacyTypeArray);
	}
	
	/**
	 * @toDo:user clicks on SearchAgain and navigates to pharmacies search page
	 */
	@Then("^the user clicks on SearchAgain and navigates to pharmacies search page in the AARP site$")
	public void clicks_searchAgain_navigates_to_pharmaacies_search_page_aarp(){
		PharmacyResultPage pharmacyResultPage = (PharmacyResultPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_RESULTS_PAGE);
		
		PharmacySearchPage pharmacySearchPage = pharmacyResultPage.navigateTopharmacySearch();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
		}else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}
	
	/**
	 * @toDo:user should see county popup
	 */
	@Then("^the user should see county popup in AARP site$")
	public void user_should_see_county_popup_aarp() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		if(pharmacySearchPage.validateCountypopoup()){
			Assert.assertTrue(true);
		} else {
			Assert.fail("County Pop up did not appear");
		}
	}
	
	/**
	 * @toDo:user selects the county
	 */
	@When("^the user selects the county in AARP site$")
	public void user_selects_county_aarp(DataTable countyAttributes){
		String countyName = countyAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectCounty(countyName);
	}
	
	/**
	 * @toDo:user should see choose a plan
	 */
	@Then("^the user should see choose a plan in AARP site$")
	public void user_should_see_choose_plan_aarp(){
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateChoosePlanSectionAfterzipcodeSearch();
	}
	
	/**
	 * @toDo:user validates the available pharmacies page
	 */
	@Then("^the user validates the available pharmacies page in AARP site$")
	public void user_validates_available_pharmacies_aarp() {

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		if (pharmacySearchPage.validatePharmacyResults()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating Pharmacy Results ");
		}
	}
	
	/**
	 * @toDo:user hovers to Our Plans and select Request More Help and Information for following plan type
	 */
	@When("^the user hovers to Our Plans and select pharmacy search for following plan type in AARP Site$")
	public void user_hovers_to_our_plans_and_select_request_more_help_and_information_aarp(){
		
 		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
 		PharmacySearchPage pharmacySearchPage =acqusitionHomePage.navigateToPharmacyLocator();
 		if (pharmacySearchPage!=null){
 		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,pharmacySearchPage);
 		}
 		else{
 			Assert.fail("Not able to navigate to Pharmacy page");
 		}
	}
	
	/**
	 * @toDo:user validates the available pharmacies page
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

		if (!isPharmacySelected) {
			Assert.fail("Error in selecting pharmacy type!!!");
		}
		
	}
	@And("^the user enters the invalid zipcode and validates the no results error message$")
	public void the_invalid_zipcode_error_message_validation(){
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateNoresultsZipcodeError();
	}
}
