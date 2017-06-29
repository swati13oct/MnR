/**
 * 
 */
package acceptancetests.pharmacylocator.ulayer;

import gherkin.formatter.model.DataTableRow;

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

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.PharmacyResultPage;
import pages.acquisition.ulayer.PharmacySearchPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.pharmacylocator.data.PharmacySearchCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */
public class PharmacyLocatorAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

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

	@When("^the user navigates to pharmacy search page in AARP Site$")
	public void user_views_pharmacy_locator_aarp() {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = acqusitionHomePage
				.navigateToPharmacyLocator();

		/*if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}*/

	}

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

	@And("^the user chooses a plan from dropdown in AARP Site$")
	public void user_chooses_plan_dropdown_aarp(DataTable planAttributes) {
		
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage pharmacyResultPage = pharmacySearchPage.selectsPlanName();

		/*String planName = planAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, planName);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectsPlanName();

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}*/

	}

	@And("^the user searches available pharmacies by selecting \"Show pharmacies for ALL types\" in AARP site$")
	public void user_selects_show_pharmacy_for_all_pharmacy_types_aarp() {
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
					+ File.separator + CommonConstants.SITE_ULAYER
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

	@And("the user searches available pharmacies by selecting \"Show pharmacies for these services.\" in AARP site$")
	public void  user_searches_pharmacies_by_choosing_pharmacy_types_aarp(DataTable pharmacyTypeAttributes)
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
					+ File.separator + CommonConstants.SITE_ULAYER
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
	
	
	@Then("^the user validates the available pharmacies page in AARP site$")
	public void user_validates_available_pharmacies_aarp() {

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
	
	@Then("^the user validate multiple language dropdown menu in AARP site$")
	public void user_views_multiple_language_dropdown_result_AARP() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.selectLanguage();
		
	}
	
	@Then("^the user click on show on map link in AARP Site$")
	public void user_views_show_on_map_result_AARP() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.ValidateShowOnMapResult();
		
	}
	
	@Then("^the user click on view search PDF link in AARP Site$")
	public void user_views_search_pdf_result_AARP() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.ValidateSearchPdfResult();
		
	}
	
	@Then("^the user validate google map colcor for pharmacy and standard network in AARP Site$")
	public void user_views_google_map_color_AARP() {
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
	
	@When("^the user navigates to pharmacy search page for plan type MAPD in AARP Site$")
    public void user_views_pharmacy_search_mapd_AARP() {
           PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
                        .getBean(PageConstants.PHARMACY_SEARCH_PAGE);
           PharmacyResultPage pharmacyResultPage = pharmacySearchPage
                        .ValidateSearchResultMapd();
           
    }

    @Then("^the user click on pharmacy locater link in AARP site$")
    public void user_views_pharmacy_locater_page_AARP() {
           PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
                        .getBean(PageConstants.PHARMACY_SEARCH_PAGE);
           PharmacyResultPage pharmacyResultPage = pharmacySearchPage
                        .ValidatePharmacyLocaterPage();
           
    }
    
    @When("^the user navigates to pharmacy search page for plan type PDP in AARP Site$")
    public void user_views_pharmacy_search_pdp_AARP() {
           PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
                        .getBean(PageConstants.PHARMACY_SEARCH_PAGE);
           PharmacyResultPage pharmacyResultPage = pharmacySearchPage
                        .ValidateSearchResultpdp();
           
    }
    
    @When("^the user navigates to Request more info page$")
    public void user_navigates_to_request_more_info() {
    	AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
    	 PharmacyResultPage pharmacyResultPage = acqusitionHomePage.navigateToRequestMoreHelp();
    }


	
	
}
