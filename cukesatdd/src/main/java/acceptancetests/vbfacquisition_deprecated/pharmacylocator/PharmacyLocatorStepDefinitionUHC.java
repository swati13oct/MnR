package acceptancetests.vbfacquisition_deprecated.pharmacylocator;

import org.springframework.beans.factory.annotation.Autowired;

import atdd.framework.MRScenario;


/**
 * Functionality: PharmacyLocator
 */

public class PharmacyLocatorStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/* tbd
	@Given("^the user is on the UMS Medicare Site landing page$")
	public void registered_member_located_pharmacy_UMS() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		AcquisitionHomePage acqusitionHomePage = new AcquisitionHomePage(wd);

		if (acqusitionHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acqusitionHomePage);
			Assert.assertTrue(true);
		}
	}

	@When("^the user hovers to Our Plans and select Request More Help and Information for following plan type$")
	public void user_hovers_to_our_plans_and_select_request_more_help_and_information(DataTable planAttributes){

		String planType = planAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_TYPE, planType);
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = 	acqusitionHomePage.navigateToPharmacyLocator();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
			
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}

	@When("^the user navigates to pharmacy search page in UMS Site$")
	public void user_views_pharmacy_locator_UMS(DataTable planAttributes) {
		List<DataTableRow> zipAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {

			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
					zipAttributesRow.get(i).getCells().get(1));
		}
		String planname = zipAttributesMap.get("planname");
		
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		//String planType = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_TYPE);
		PharmacySearchPage pharmacySearchPage = acqusitionHomePage.navigateToPharmacyLocator();

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
			pharmacySearchPage.validateDefaultChooseaPlanSection(planname);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	@And("^the user enters following details for pharmacy search in UMS Site$")
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

	@And("^the user chooses a plan from dropdown in UMS Site$")
	public void user_chooses_plan_dropdown_UMS(DataTable planAttributes) {
		List<DataTableRow> zipAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {

			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0), zipAttributesRow.get(i).getCells().get(1));
		}
		String planName = zipAttributesMap.get("planname");
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

	@Then("^the user chooses the Pharmacy Type blayer$")
	public void the_user_chooses_the_pharmacy_type_blayer(DataTable pharmacyTypeAttribute){
		
		String PharmacyType = pharmacyTypeAttribute.getGherkinRows().get(0).getCells()
				.get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean isPharmacySelected;
		isPharmacySelected = pharmacySearchPage.selectPharmacyandServices(PharmacyType);

		if (!isPharmacySelected) {
			Assert.fail("Error in selecting pharmacy type!!!");
		}
	}
	
	@Then("^the user chooses the Service Type blayer$")
	public void the_user_chooses_the_service_type_blayer(DataTable serviceTypeAttribute){
		
		String serviceType = serviceTypeAttribute.getGherkinRows().get(0).getCells()
				.get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean isPharmacySelected;
		isPharmacySelected = pharmacySearchPage.selectPharmacyandServices(serviceType);

		if (!isPharmacySelected) {
			Assert.fail("Error in selecting service type!!!");
		}
	}
	
	@And("^the user searches available pharmacies by selecting \"Show pharmacies for ALL types\"$")
	public void user_selects_show_pharmacy_for_all_pharmacy_types_ums() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.showAllPharmacies();

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

	@Then("^the user validates the error message for no pharmacies found for below pharmacy$")
	public void validates_error_msg_for_no_pharmacies_found(DataTable pharmacyTypeAttributes){
		

		 getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		//jchen118 remove the non existing btn start
		//pharmacySearchPage.validateNoPharmacyErrormsg(pharmacyTypeArray);
		//jchen118 remove the non existing btn end
	}

	@Then("^the user clicks on SearchAgain and navigates to pharmacies search page$")
	public void clicks_searchAgain_navigates_to_pharmaacies_search_page(){
		PharmacyResultPage pharmacyResultPage = (PharmacyResultPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_RESULTS_PAGE);

		if(pharmacyResultPage.navigateTopharmacySearch()){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	@Then("^the user validates the available pharmacies page in UMS site$")
	public void user_validates_available_pharmacies_UMS() {
	
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		if(pharmacySearchPage.validatePharmacyResults()){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating Pharmacy Results ");
		}
		

	}

	@Then("^the user validates the right rail widget and logo slider$")
	public void validates_Right_Rail_Widget_And_Logo_UMS(){
		
	}

	@Then("^the user validates Pharmacy Locator tool plan dropdown menu for the Medica and PCP member plan$")
	public void validates_Pharmacy_Locator_Tool_Plan_UMS(){
	
	}
	
	@Then("^the user validates Search checkbox displayed dynamically related to the pharmacy network$")
	public void validates_Pharmacy_Network_Displayed_Dynamically_UMS(){
		}
	
	@And("^the user selects a language from dropdown in UMS Site$")
	public void user_selects_language_ums(DataTable languageAttributes) {

		String langName = languageAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		if(langName.equals("Spanish")){
			langName = "espa";	
		}else if(langName.equals("Chinese")){
			langName = "中文";	
		}else{
			langName = "English";	
		}
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectLanguage(langName);
	}
	
	@Then("^the user should see county popup in UMS site$")
	public void user_should_see_county_popup_ums() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		if(pharmacySearchPage.validateCountypopoup()){
			Assert.assertTrue(true);
		} else {
			Assert.fail("County Pop up did not appear");
		}
	}
	
	@When("^the user selects the county in UMS site$")
	public void user_selects_county_ums(DataTable countyAttributes){
		String countyName = countyAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectCounty(countyName);
	}
	
	@Then("^the user should see choose a plan in UMS site$")
	public void user_should_see_choose_plan_ums(){
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateChoosePlanSectionAfterzipcodeSearch();
	}
	*/
}