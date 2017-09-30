/**
 * 
 */
package acceptancetests.pharmacylocator.bluelayer;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.pharmacylocator.data.PharmacySearchCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.PharmacyResultPage;
import pages.acquisition.bluelayer.PharmacySearchPage;

/**
 * @author sdwaraka
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
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
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

	}
/////////////////***************************New Pharmacy Locator Code**************************************/////////////////
	
	@And("^the user enters following details for pharmacy search in UHC Site$")
	public void user_enters_zipcode_distance_details_UHC(DataTable zipAttributes) {
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
		System.out.println("Zip Code is"+zipcode);
		System.out.println("Distance is"+distance);
		System.out.println("County is"+county);
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
	
	@And("^the user chooses the year and a plan from dropdown in UHC site$")
	public void chooses_year_chooses_plan(DataTable planAttributes){
		List<DataTableRow> planAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> planAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < planAttributesRow.size(); i++) {

			planAttributesMap.put(planAttributesRow.get(i).getCells().get(0),
					planAttributesRow.get(i).getCells().get(1));
		}
		
		String year = planAttributesMap.get("year");
		String planName = planAttributesMap.get("Plan Name");		
		System.out.println("@@@@@@@ Year : "+year+" @@@@@@@@");
		System.out.println("@@@@@@@ Plan Name : "+planName+" @@@@@@@@");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectYear();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			System.out.println("Failed to load Pharmacy search page after Year Selection");
		}
		pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectsPlanName(planName);
		
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			System.out.println("Failed to load Pharmacy search page");
		}
	}
	
	
	@And("^the user chooses a plan from dropdown in UHC Site$")
	public void user_chooses_plan_dropdown_UHC(DataTable planAttributes) {
		
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		
		//PharmacySearchPage pharmacyResultPage = pharmacySearchPage.selectsPlanName();	
		

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

	@And("^the user searches available pharmacies by selecting \"Show pharmacies for ALL types\" in UHC site$")
	public void user_selects_show_pharmacy_for_all_pharmacy_types_UHC() {
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

		pages.acquisition.ulayer.PharmacyResultPage pharmacyResultPage = pharmacySearchPage
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

	@And("the user searches available pharmacies by selecting \"Show pharmacies for these services.\" in UHC site$")
	public void  user_searches_pharmacies_by_choosing_pharmacy_types_UHC(DataTable pharmacyTypeAttributes)
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

		pages.acquisition.ulayer.PharmacyResultPage pharmacyResultPage = pharmacySearchPage.searchSelectingPharmacyTypes(pharmacyTypeArray);

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
	
	
	@Then("^the user validates the available pharmacies page in UHC site$")
	public void user_validates_available_pharmacies_UHC() {

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
	
	@Then("^the user validate multiple language dropdown menu in UHC site$")
	public void user_views_multiple_language_dropdown_result_UHC() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage pharmacyResultPage = pharmacySearchPage
				.selectspanLanguage();
		
	}
	
	@Then("^the user click on show on map link in UHC Site$")
	public void user_views_show_on_map_result_UHC() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pages.acquisition.ulayer.PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.ValidateShowOnMapResult();
		
	}
	
	
/*	// View on Map is removed temporarily for Sep 2017 Release.

	@Then("^the user click on view search PDF link in UHC Site$")
	public void user_views_search_pdf_result_UHC() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.ValidateSearchPdfResult();
		
	}
*/	
	@Then("^the user validate google map colcor for pharmacy and standard network in UHC Site$")
	public void user_views_google_map_color_UHC() {
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
	
	@When("^the user navigates to pharmacy search page for plan type MAPD in UHC Site$")
    public void user_views_pharmacy_search_mapd_UHC() {
           PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
                        .getBean(PageConstants.PHARMACY_SEARCH_PAGE);
           PharmacySearchPage pharmacyResultPage = pharmacySearchPage
                        .ValidateSearchResultMapd();
           
    }

    @Then("^the user click on pharmacy locater link in UHC site$")
    public void user_views_pharmacy_locater_page_UHC() {
           PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
                        .getBean(PageConstants.PHARMACY_SEARCH_PAGE);
           PharmacySearchPage pharmacyResultPage = pharmacySearchPage
                        .ValidatePharmacyLocaterPage();
           
    }
    
    @When("^the user navigates to pharmacy search page for plan type PDP in UHC Site$")
    public void user_views_pharmacy_search_pdp_UHC() {
           PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
                        .getBean(PageConstants.PHARMACY_SEARCH_PAGE);
           PharmacySearchPage pharmacyResultPage = pharmacySearchPage
                        .ValidateSearchResultpdp();
           
    }
    
    @When("^the user navigates to Request more info page$")
    public void user_navigates_to_request_more_info() {
    	AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
    	PharmacySearchPage pharmacyResultPage = acqusitionHomePage.navigateToRequestMoreHelp();
    }

    @And("^the user validate pharmacy saver widget in UHC site$")
    public void user_validate_pharmacysaver_widget(){
    	PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
                .getBean(PageConstants.PHARMACY_SEARCH_PAGE);
   PharmacySearchPage pharmacyResultPage = pharmacySearchPage.validatesPharmacySaverWidget();
    }
    
    
    
    @And("^the user searches for pharmacy search results available in UHC site$")
	public void user_views_pharmacy_search_result_UHC() {
    	PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.navigateToPharmacySearchResult();
		
		/*if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}*/
    	
    }
    
    @And("^the user clicks chineseLink in UHC Site$")
	public void click_chinese() {
		PharmacySearchPage pharmacySearchUHCPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchUHCPage = pharmacySearchUHCPage.clickChinese();
		if (pharmacySearchUHCPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchUHCPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}
    
    @Then("^the user validate google map red ballon based on plan type in UHC Site$")
	public void user_views_pharmacy_saver_google_map_color_UHC() {
		JSONObject pharmacyResultActualJson = (JSONObject) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL);
		JSONObject pharmacyResultExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED);		
	}
	
	@Then("^the user validate tool tip for pharmacy saver plan type in UHC Site$")
	public void user_validate_tooltip_pharmacy_saver_UHC() {
    	PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.navigateToToolTipPharmacySaver();
	}
	
	 @And("^the user searches multi lang for pharmacy search results available in UHC site$")
		public void user_views_chinese_lang_pharmacy_search_result_UHC() {
	    	PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
					.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
			pharmacySearchPage = pharmacySearchPage.multilangPharmacySearchResult();
			
			/*if (pharmacySearchPage != null) {
				getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
						pharmacySearchPage);
				Assert.assertTrue(true);
			} else {
				Assert.fail("Failed to load Pharmacy search page");
			}*/
	    	
	    }
	 
	 @And("^the user verify error messages in pharmacy locator page in UHC site$")
	 public void user_verify_pharmacyerrormessages(){
		 PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
					.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
			pharmacySearchPage = pharmacySearchPage.verifyPharmacyErrormessages();
	 }
	  
	@When("^the user validate chat widget in UHC Site$")
	public void the_user_validate_chat_widget_in_UHC_Site() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean present = pharmacySearchPage.validateChatWidget();

		if (present) {
			System.out.println("@@@@@@@@@ Able to find Chat widget @@@@@@@@@");
			Assert.assertTrue("@@@@@@@@@ No Chat widget @@@@@@@@@", present);
		}
	}

	@When("^the user validate TFN widget in UHC Site$")
	public void the_user_validate_TFN_widget_in_UHC_Site() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean present = pharmacySearchPage.validateTfnWidget();
		if (present) {
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			Assert.assertTrue("@@@@@@@@@ No TFN widget @@@@@@@@@",present);
		} 
	}

	@When("^the user validate more information content based on plan type in UHC Site$")
	public void the_user_validate_more_information_content_based_on_plan_type_in_UHC_Site() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		boolean present = pharmacySearchPage.validateMoreInfo();
		if (present) {
			System.out.println("@@@@@@@@@ Able to find More Info Link @@@@@@@@@");
			Assert.assertTrue("@@@@@@@@@ More Info Link is not displayed @@@@@@@@@",present);
		} 
	}

}
	
	
	
	/******************************/////////////////////////****************************************/

/*	@And("^the user enters following details for pharmacy search in UMS Site$")
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

			 Get expected data 
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

			 Get actual data 
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

			 Get expected data 
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

			 Get actual data 
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
	
	@When("^the user navigates to Request more info page$")
    public void user_navigates_to_request_more_info() {
    	AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
    	PharmacySearchPage pharmacyResultPage = acqusitionHomePage.navigateToRequestMoreHelp();
    }
	
	@And("^the user chooses the year and a plan from dropdown in UMS Site$")
	public void chooses_year_chooses_plan(DataTable planAttributes){
		List<DataTableRow> planAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> planAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < planAttributesRow.size(); i++) {

			planAttributesMap.put(planAttributesRow.get(i).getCells().get(0),
					planAttributesRow.get(i).getCells().get(1));
		}
		
		String year = planAttributesMap.get("year");
		//String planName = planAttributesMap.get("Plan Name");		

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectYear();
		pharmacySearchPage = pharmacySearchPage.selectsPlanName();
		
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}
	
	@And("^the user validate pharmacy saver widget in UHC site$")
    public void user_validate_pharmacysaver_widget(){
    	PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
                .getBean(PageConstants.PHARMACY_SEARCH_PAGE);
   PharmacySearchPage pharmacyResultPage = pharmacySearchPage.validatesPharmacySaverWidget();
    }

*/	
	
	
	
//}
