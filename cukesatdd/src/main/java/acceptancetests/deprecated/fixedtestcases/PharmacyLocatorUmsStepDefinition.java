/**
 * 
 */
package acceptancetests.deprecated.fixedtestcases;

import gherkin.formatter.model.DataTableRow;
import pages.deprecated.acquisition.bluelayer.AcquisitionHomePage;
import pages.deprecated.acquisition.bluelayer.PharmacyResultPage;
import pages.deprecated.acquisition.bluelayer.PharmacySearchPage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.acquisition.PageConstants;
import acceptancetests.memberrdesignVBF.pharmacylocator.PharmacySearchCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/**
 * @author ykumar36
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
		WebDriver wd = getLoginScenario().getWebDriverNew();
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
		acqusitionHomePage.navigateToRequestMoreHelpAndInformation(planType);
	}

	@When("^the user navigates to pharmacy search page in UMS Site$")
	public void user_views_pharmacy_locator_UMS() {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		String planType = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_TYPE);
		PharmacySearchPage pharmacySearchPage = acqusitionHomePage
				.navigateToPharmacyLocator(planType);

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
			pharmacySearchPage.validateDefaultChooseaPlanSection();
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
			pharmacySearchPage.validatePharmaciesSectionAfterplanSelection();
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	@Then("^the user chooses the Pharmacy Type blayer$")
	public void the_user_chooses_the_pharmacy_type_blayer(DataTable pharmacyTypeAttribute){
		
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
	
	@Then("^the user chooses the Service Type blayer$")
	public void the_user_chooses_the_service_type_blayer(DataTable serviceTypeAttribute){
		
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
			/*String fileName = PharmacySearchCommonConstants.ALL_PHARMACIES;
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
			 */

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
			 */
			/* Get actual data */
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
		String[] pharmacyTypeArray = pharmacyTypeAttributes.getGherkinRows().get(0).getCells().get(0).split(",");

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateNoPharmacyErrormsg(pharmacyTypeArray);
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
		pharmacySearchPage = pharmacySearchPage.selectLanguage(langName);

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
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
	

}
