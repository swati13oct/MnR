package acceptancetests.acquisition.pharmacylocator;

import org.springframework.beans.factory.annotation.Autowired;

import atdd.framework.MRScenario;


/**
 * Functionality: PharmacyLocator
 * NOTE: deprecating this one, use the one in cukesatdd/src/main/java/acceptancetests/acquisition/pharmacylocator/PharmacyLocatorStepDefinition.java
 */
public class Deprecated_PharmacyLocatorStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;
	String langName;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
/* tbd
	@Given("^ORIG_the user is on the UMS Medicare Site landing page$")
	public void registered_member_located_pharmacy_UMS() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		AcquisitionHomePage acqusitionHomePage = new AcquisitionHomePage(wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acqusitionHomePage);
	}

	@When("^ORIG_the user hovers to Our Plans and select pharmacy search for following plan type in uhc site$")
	public void user_hovers_to_our_plans_and_select_pharmacy_search_uhc() {

		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = acqusitionHomePage.navigateToPharmacyLocator();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page", pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
	}

	@When("^ORIG_the user navigates to pharmacy search page in UMS Site$")
	public void user_views_pharmacy_locator_UMS() {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = acqusitionHomePage
				.navigateToPharmacyLocator();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page", pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
				pharmacySearchPage);
	}

	@And("^ORIG_the user enters following details for pharmacy search in UMS Site$")
	public void user_enters_zipcode_distance_details_UMS(DataTable zipAttributes) {
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

	@And("^ORIG_the user chooses a plan from dropdown in UMS Site$")
	public void user_chooses_plan_dropdown_UMS(DataTable planAttributes) {
		List<DataTableRow> zipAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {
			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0), zipAttributesRow.get(i).getCells().get(1));
		}
		String planName = zipAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, planName);
		String planYear = zipAttributesMap.get("planyear");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, planName);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		Boolean isplanyear = pharmacySearchPage.isPlanYear();
		if (isplanyear) {
			pharmacySearchPage.selectsPlanYear(planYear);
		}
		pharmacySearchPage.selectsPlanName(planName);
	}

	@Then("^ORIG_the user chooses the Pharmacy Type blayer$")
	public void the_user_chooses_the_pharmacy_type_blayer(DataTable pharmacyTypeAttribute){
		
		String pharmacyType = pharmacyTypeAttribute.getGherkinRows().get(0).getCells()
				.get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean isPharmacySelected;
		isPharmacySelected = pharmacySearchPage.selectPharmacyandServices(pharmacyType);
		Assert.assertTrue("PROBLEM - Error in selecting pharmacy type!!!",isPharmacySelected);
	}
	
	@Then("^ORIG_the user chooses the Service Type blayer$")
	public void the_user_chooses_the_service_type_blayer(DataTable serviceTypeAttribute){
		String serviceType = serviceTypeAttribute.getGherkinRows().get(0).getCells().get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean isServicesSelected;
		isServicesSelected = pharmacySearchPage.selectPharmacyandServices(serviceType);
		Assert.assertTrue("PROBLEM - Error in selecting service type!!!",isServicesSelected);
	}
	
	@And("^ORIG_the user searches available pharmacies by selecting \"Show pharmacies for ALL types\"$")
	public void user_selects_show_pharmacy_for_all_pharmacy_types_ums() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.showAllPharmacies();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page", pharmacyResultPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE, pharmacyResultPage);
		// Get actual data
		JSONObject pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
		getLoginScenario().saveBean(
				PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
				pharmacyResultActualJson);
	}

	@And("the user searches available pharmacies by selecting \"Show pharmacies for these services.\"$")
	public void  user_searches_pharmacies_by_choosing_pharmacy_types_ums(DataTable pharmacyTypeAttributes)
	{
		String[] pharmacyTypeArray = pharmacyTypeAttributes.getGherkinRows().get(0).getCells().get(0).split(",");

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);

		PharmacyResultPage pharmacyResultPage = pharmacySearchPage.searchSelectingPharmacyTypes(pharmacyTypeArray);

		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE,
					pharmacyResultPage);
			JSONObject pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
			getLoginScenario().saveBean(
					PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
					pharmacyResultActualJson);

		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	@Then("^ORIG_the user validates the error message for no pharmacies found for below pharmacy$")
	public void validates_error_msg_for_no_pharmacies_found(DataTable pharmacyTypeAttributes){
		 getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
	}

	@Then("^ORIG_the user clicks on SearchAgain and navigates to pharmacies search page$")
	public void clicks_searchAgain_navigates_to_pharmaacies_search_page(){
		PharmacyResultPage pharmacyResultPage = (PharmacyResultPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_RESULTS_PAGE);
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page", pharmacyResultPage.navigateTopharmacySearch());
	}

	@Then("^ORIG_the user validates the available pharmacies page in UMS site$")
	public void user_validates_available_pharmacies_UMS() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		Assert.assertTrue("PROBLEM - Error in validating Pharmacy Results", pharmacySearchPage.validatePharmacyResults());
	}

	@Then("^ORIG_the user validates the right rail widget and logo slider$")
	public void validates_Right_Rail_Widget_And_Logo_UMS(){
		//TODO - keep or delete??
	}

	@Then("^ORIG_the user validates Pharmacy Locator tool plan dropdown menu for the Medica and PCP member plan$")
	public void validates_Pharmacy_Locator_Tool_Plan_UMS(){
		//TODO - keep or delete??
	}
	
	@Then("^ORIG_the user validates Search checkbox displayed dynamically related to the pharmacy network$")
	public void validates_Pharmacy_Network_Displayed_Dynamically_UMS(){
		//TODO - keep or delete??
	}
	
	@And("^ORIG_the user selects a language from dropdown in UMS Site$")
	public void user_selects_language_ums(DataTable languageAttributes) {
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
	
	@Then("^ORIG_the user should see county popup in UMS site$")
	public void user_should_see_county_popup_ums() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		Assert.assertTrue("PROBLEM - County Pop up did not appear",pharmacySearchPage.validateCountypopoup());
	}
	
	@When("^ORIG_the user selects the county in UMS site$")
	public void user_selects_county_ums(DataTable countyAttributes){
		String countyName = countyAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectCounty(countyName);
	}
	
	@Then("^ORIG_the user should see choose a plan in UMS site$")
	public void user_should_see_choose_plan_ums(){
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateChoosePlanSectionAfterzipcodeSearch();
	}
	
	@Then("^ORIG_the user validates language changes in UMS site$")
	public void user_validates_language_changes_uhc() {

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		Assert.assertTrue("PROBLEM - Changes to language is not successful",
				pharmacySearchPage.validateLanguageChanges(langName));
	}
	
	@And("^ORIG_the user enters following Multi County details and  validates the Cancel button for Multi COunty Pop-up clears the Zip code text fields in pharmacy search in UMS Site$")
	public void user_enters_MultiCounty_zip_to_validate(DataTable zipAttributes) {
		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {
			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
					zipAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = zipAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE, zipcode);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.enterZipCode(zipcode);
		boolean Validation_Flag = pharmacySearchPage.validate_MultiCounty_CancelBtn();
		Assert.assertTrue("PROBLEM - Cancel button Validation for Multi County Pop-up Failed ",Validation_Flag);
	} 
	*/
}