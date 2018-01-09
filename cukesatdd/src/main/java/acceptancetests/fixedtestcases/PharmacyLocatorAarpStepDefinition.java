/**
 * 
 */
package acceptancetests.fixedtestcases;

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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;

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
		System.out.println("********Running environment is " +loginScenario.environment);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		AcquisitionHomePage acqusitionHomePage = new AcquisitionHomePage(wd);

		if (acqusitionHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acqusitionHomePage);
			Assert.assertTrue(true);
		}
	}
	
	@When("^the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site$")
	public void user_hovers_to_our_plans_and_select_request_more_help_and_information_aarp(DataTable planAttributes){
		
		String planType = planAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_TYPE, planType);
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.navigateToRequestMoreHelpAndInformation(planType);
	}

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
			pharmacySearchPage.validateChoosePlanSectionAfterzipcodeSearch();
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}
	@And("^the user selects a language from dropdown in AARP Site$")
	public void user_selects_language_aarp(DataTable languageAttributes) {

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
		pharmacySearchPage = pharmacySearchPage.selectLanguage(langName);

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
			pharmacySearchPage.validatePharmaciesSectionAfterplanSelection();
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}
	
	@Then("^the user chooses the Pharmacy Type$")
	public void the_user_chooses_the_pharmacy_type(DataTable pharmacyTypeAttribute){
		
		String PharmacyType = pharmacyTypeAttribute.getGherkinRows().get(0).getCells()
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
	
	@Then("^the user chooses the Service Type$")
	public void the_user_chooses_the_service_type(DataTable serviceTypeAttribute){
		
		String serviceType = serviceTypeAttribute.getGherkinRows().get(0).getCells()
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
			/*String fileName = PharmacySearchCommonConstants.ALL_PHARMACIES;
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
		
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage.searchSelectingPharmacyTypes(pharmacyTypeArray);

		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULTS_PAGE,
					pharmacyResultPage);

			/* Get expected data */
			/*String fileName = "Selected";
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
					pharmacyResultExpectedJson); */

			/* Get actual data */
			JSONObject pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
			getLoginScenario().saveBean(
					PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
					pharmacyResultActualJson);
			
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
		
	}
	
	@Then("^the user validates the error message for no pharmacies found for below pharmacy in the AARP Site$")
	public void validates_error_msg_for_no_pharmacies_found_aarp(DataTable pharmacyTypeAttributes){
		String[] pharmacyTypeArray = pharmacyTypeAttributes.getGherkinRows().get(0).getCells().get(0).split(",");
		
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateNoPharmacyErrormsg(pharmacyTypeArray);
	}
	
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
	
	@When("^the user selects the county in AARP site$")
	public void user_selects_county_aarp(DataTable countyAttributes){
		String countyName = countyAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectCounty(countyName);
	}
	
	@Then("^the user should see choose a plan in AARP site$")
	public void user_should_see_choose_plan_aarp(){
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateChoosePlanSectionAfterzipcodeSearch();
	}
	
	@Then("^the user validates the available pharmacies page in AARP site$")
	public void user_validates_available_pharmacies_aarp() {
		/*PharmacyResultPage pharmacyResultsPage = (PharmacyResultPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_RESULTS_PAGE);
		
		JSONObject pharmacyResultActualJson = (JSONObject) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL);
		System.out.println("pharmacyResultActualJson:::"
				+ pharmacyResultActualJson);
		
		String zipcode = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.COUNTY);
		String distance = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.DISTANCE);
		String planName = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.PLAN_NAME);
		*/
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		if(pharmacySearchPage.validatePharmacyResults()){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating Pharmacy Results ");
		}
		/*JSONObject pharmacyResultExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED);

		
		System.out.println("pharmacyResultExpectedJson:::"
				+ pharmacyResultExpectedJson);
		
		try {
			JSONAssert.assertEquals(pharmacyResultExpectedJson,
					pharmacyResultActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}
	
	
	
	
}
