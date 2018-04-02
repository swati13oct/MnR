package acceptancetests.acquisitionvbf.pharmacylocator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisitionvbf.common.CommonStepDefinition;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.PharmacyResultPage;
import pages.acquisition.ulayer.PharmacySearchPage;

/**
 *Functionality:PharmacyLocator
 */
public class PharmacyLocatorStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	private Map<String, String> memberAttributesMap =new CommonStepDefinition().getAttributesMap();
	
	private List<DataTableRow> memberAttributesRow = new CommonStepDefinition().getAttributesRow();

	//moved @given statement to common stepdefinition
		//the user is on AARP medicare acquisition site landing page
	
	/**
	 * @toDo:user hovers to Our Plans and select Request More Help and Information for following plan type
	 */
	@When("^the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site$")
	public void user_hovers_to_our_plans_and_select_request_more_help_and_information_aarp(){
		
		String planType = memberAttributesRow.get(0).getCells()
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
			pharmacySearchPage.validateDefaultChooseaPlanSection();
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	/**
	 * @toDo:user enters following details for pharmacy search
	 */
	@And("^the user enters following details for pharmacy search in AARP Site$")
	public void user_enters_zipcode_distance_details_aarp() {
		List<DataTableRow> zipAttributesRow = memberAttributesRow;
		Map<String, String> zipAttributesMap = memberAttributesMap;
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
		pharmacySearchPage = pharmacySearchPage.enterZipDistanceDetails(
				zipcode, distance, county);

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
			pharmacySearchPage.validateChoosePlanSectionAfterzipcodeSearch();
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}
	
	/**
	 * @toDo:user selects a language from dropdown 
	 */
	@And("^the user selects a language from dropdown in AARP Site$")
	public void user_selects_language_aarp() {

		String langName = memberAttributesRow.get(0).getCells()
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
		pharmacySearchPage = pharmacySearchPage.selectLanguage(langName);

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	
	}
	/**
	 * @toDo:user chooses a plan from dropdown
	 */
	@And("^the user chooses a plan from dropdown in AARP Site$")
	public void user_chooses_plan_dropdown_aarp() {

		String planName = memberAttributesRow.get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, planName);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectsPlanName(planName);

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
			pharmacySearchPage.validatePharmaciesSectionAfterplanSelection();
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}
	
	/**
	 * @toDo:user chooses the Pharmacy Type
	 */
	@Then("^the user chooses the Pharmacy Type$")
	public void the_user_chooses_the_pharmacy_type(){
		
		String PharmacyType = memberAttributesRow.get(0).getCells()
				.get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectPharmacyandServices(PharmacyType);
		
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);			 
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
		
	}
	
	/**
	 * @toDo:user chooses the Service Type
	 */
	@Then("^the user chooses the Service Type$")
	public void the_user_chooses_the_service_type(){
		
		String serviceType = memberAttributesRow.get(0).getCells()
				.get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectPharmacyandServices(serviceType);
		
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);			 
		} else {
			Assert.fail("Failed to load Pharmacy search page");
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
	public void  user_searches_pharmacies_by_choosing_pharmacy_types_aarp()
	{
		String[] pharmacyTypeArray = memberAttributesRow.get(0).getCells().get(0).split(",");
		
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
	public void validates_error_msg_for_no_pharmacies_found_aarp(){
		String[] pharmacyTypeArray = memberAttributesRow.get(0).getCells().get(0).split(",");
		
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
	public void user_selects_county_aarp(){
		String countyName = memberAttributesRow.get(0).getCells()
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
		if(pharmacySearchPage.validatePharmacyResults()){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating Pharmacy Results ");
		}
		

	}
	}
