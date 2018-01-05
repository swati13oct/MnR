/**
 * 
 */
package acceptancetests.sanity.blayer;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.pharmacylocator.data.PharmacySearchCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.PharmacyResultPage;
import pages.acquisition.bluelayer.PharmacySearchPage;

/**
 * @author pagarwa5
 *
 */
public class PharmacyLocatorUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

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

	@When("^the user navigates to pharmacy search page in UMS Site$")
	public void user_views_pharmacy_locator_UMS() {
/*		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = acqusitionHomePage
				.navigateToPharmacyLocator();

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

*/	}
	
	@And("^Select a year from the available list displayed$")
    public void select_a_year_from_the_available_list_displayed(DataTable givenAttributes){
		// get test variables
/*		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
		    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
	
		// get parameter username and password
		String year = memberAttributesMap.get("Year");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectAYear(year);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
*/    }
    @And("^enter zipcode$")
    public void enter_a_zipcode(DataTable givenAttributes){
		// get test variables
/*		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
		    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
	
		// get parameter username and password
		String zipcode = memberAttributesMap.get("Zipcode");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.enterZipCode(zipcode);
		pharmacySearchPage.clickOnContinue();
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
 */   }
    
    @And("^validate pharmacy search results$")
    public void validatePharmacySearchResults() {
/*
    	PharmacyResultPage pharmacySearchResultsPage = (PharmacyResultPage) getLoginScenario().getBean(PageConstants.PHARMACY_RESULTS_PAGE);
	try {
	    Thread.sleep(8000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	pharmacySearchResultsPage.validatePharmacySearchResults();
 */   }
    
    @And("^validate pharmacy saver$")
    public void validatePharmacySaverInResults() {
/*
    	PharmacyResultPage pharmacySearchResultsPage = (PharmacyResultPage) getLoginScenario().getBean(PageConstants.PHARMACY_RESULTS_PAGE);
	pharmacySearchResultsPage.validatePharmacySaverInResults();
    }
    
    @And("^validate Standard Network pharmacy$")
    public void validateStandardNetworkInResults() {

    	PharmacyResultPage pharmacySearchResultsPage = (PharmacyResultPage) getLoginScenario().getBean(PageConstants.PHARMACY_RESULTS_PAGE);
	pharmacySearchResultsPage.validateStandardNetworkInResults();
    }
 */}   
   /* @And("^Select a Plan from the available plans list displayed$")
    public void select_a_plan_from_the_available_plans_list_displayed(DataTable givenAttributes){
		// get test variables
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
		    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
	
		// get parameter username and password
		String planName = memberAttributesMap.get("PlanName");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacyResultPage pharmacySearchResultsPage = pharmacySearchPage.selectAPlan(planName);
		getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE, pharmacySearchResultsPage);
    }*/
    

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
		pharmacySearchPage = pharmacySearchPage.enterZipDistanceDetails(
				zipcode, distance, county);

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}

	@And("^the user chooses a plan from dropdown in UMS Site$")
	public void user_chooses_plan_dropdown_UMS(DataTable planAttributes) {

		String planName = planAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, planName);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectsPlanName(planName);

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	@And("^the user searches available pharmacies by selecting \"Show pharmacies for ALL types\"$")
	public void user_selects_show_pharmacy_for_all_pharmacy_types_ums() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String zipcode = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.COUNTY);
		String distance = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.DISTANCE);
		String planName = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.PLAN_NAME);

		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.showAllPharmacies();

		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE,
					pharmacyResultPage);

			/* Get expected data */
			String fileName = PharmacySearchCommonConstants.ALL_PHARMACIES;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + PharmacySearchCommonConstants.PHARMACY_SEARCH
					+ File.separator + zipcode + File.separator + county
					+ File.separator + distance + File.separator + planName
					+ File.separator;
			JSONObject pharmacyResultExpectedJson = MRScenario
					.readExpectedJson(fileName, directory);

			getLoginScenario().saveBean(
					PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED,
					pharmacyResultExpectedJson);

			/* Get actual data */
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
		String zipcode = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.COUNTY);
		String distance = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.DISTANCE);
		String planName = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.PLAN_NAME);

		PharmacyResultPage pharmacyResultPage = pharmacySearchPage.searchSelectingPharmacyTypes(pharmacyTypeArray);

		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE,
					pharmacyResultPage);

			/* Get expected data */
			String fileName = "Selected";
			for(String pharmacyType : pharmacyTypeArray){
				fileName = fileName+"_"+pharmacyType;
			}
						
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + PharmacySearchCommonConstants.PHARMACY_SEARCH
					+ File.separator + zipcode + File.separator + county
					+ File.separator + distance + File.separator + planName
					+ File.separator;
			JSONObject pharmacyResultExpectedJson = MRScenario
					.readExpectedJson(fileName, directory);

			getLoginScenario().saveBean(
					PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED,
					pharmacyResultExpectedJson);

			/* Get actual data */
			JSONObject pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
			getLoginScenario().saveBean(
					PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
					pharmacyResultActualJson);
			
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
		
	}
	
	
	@Then("^the user validates the available pharmacies page in UMS site$")
	public void user_validates_available_pharmacies_UMS() {

		JSONObject pharmacyResultActualJson = (JSONObject) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL);
		JSONObject pharmacyResultExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED);

		System.out.println("pharmacyResultActualJson:::"
				+ pharmacyResultActualJson);
		System.out.println("pharmacyResultExpectedJson:::"
				+ pharmacyResultExpectedJson);
		
		try {
			JSONAssert.assertEquals(pharmacyResultExpectedJson,
					pharmacyResultActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^the user validates the right rail widget and logo slider$")
	public void validates_Right_Rail_Widget_And_Logo_UMS(){
		PharmacySearchPage PharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
	 //PharmacySearchPage.validateRightRailWidgetandLogo();		
		
		//PharmacySearchPage.logOut();
		
	}
	
	@Then("^the user validates Pharmacy Locator tool plan dropdown menu for the Medica and PCP member plan$")
	public void validates_Pharmacy_Locator_Tool_Plan_UMS(){
		PharmacySearchPage PharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		//PharmacySearchPage.validateMedicaandPCPMemberplan();		
		
		//PharmacySearchPage.logOut();
		
	}
	@Then("^the user validates Search checkbox displayed dynamically related to the pharmacy network$")
	public void validates_Pharmacy_Network_Displayed_Dynamically_UMS(){
		PharmacySearchPage PharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		//PharmacySearchPage.clickOnShowPharmaciesForTheseServices();		
		
		//PharmacySearchPage.logOut();
		
	}

	
}
