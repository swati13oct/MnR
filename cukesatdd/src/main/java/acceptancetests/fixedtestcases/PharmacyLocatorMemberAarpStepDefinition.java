/**
 * 
 */
package acceptancetests.fixedtestcases;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.PharmacyResultPage;
import pages.member.ulayer.PharmacySearchPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.pharmacylocator.data.PharmacySearchCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;

/**
 * @author pperugu
 *
 */
public class PharmacyLocatorMemberAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;
	
	public MRScenario getLoginScenario() {
		return loginScenario;
	}




	@Given("^registered member to verify locate a pharmacy in AARP Site$")
	public void registered_member_located_pharmacy_aarp(
			DataTable memberAttributes) {
		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();
		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);
		//Map<String, String> loginCreds = new HashedMap();
		//loginCreds.put("user", "q1_apr_ulayer_479");
		//loginCreds.put("pwd","Password@1" );
		
		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario()
			.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
		}else{
			Assert.fail("Account Home page not displayed ");
		}
		/* Get expected data */
		/*Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}
		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);*/
	}

	@When("^the user navigates to pharmacy search page in AARP site$")
	public void user_views_pharmacy_locator_aarp() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = accountHomePage
				.navigateToPharmacyLocator();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}

	@And("^the user enters distance details in AARP site$")
	public void user_enters_distance_details_aarp(DataTable zipAttributes) {
		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		String distance = zipAttributesRow.get(0).getCells().get(0);

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.enterDistanceDetails(distance);
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	@And("^the user searches for pharmacies available in AARP site$")
	public void user_pharmacy_available_aarp() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.searchesPharmacy();

		/* Get expected data */
		/*@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject pharmacyResultExpectedJson = pharmacyResultPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED,
				pharmacyResultExpectedJson);
*/
		JSONObject pharmacyResultActualJson = null;
		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULT_PAGE,
					pharmacyResultPage);
			Assert.assertTrue(true);
			pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
			getLoginScenario().saveBean(
					PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
					pharmacyResultActualJson);
		}
		

	}

	@Then("^the user validates the pharmacies available in AARP site$")
	public void user_validates_pharmacies_available_aarp() {
		PharmacyResultPage pharmacyResultPage = (PharmacyResultPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_RESULT_PAGE);

		
		JSONObject pharmacyResultActualJson = (JSONObject) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL);
		String zipcode = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.ZIPCODE);
		String planName = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.PLAN_NAME);
		if(pharmacyResultPage.validategeneralPharmacyResultpage(pharmacyResultActualJson,zipcode,planName)){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating Pharmacy Results page ");
		}
		pharmacyResultPage.logOut();
	}
	
	@Then("^the user validates the pharmacies available for the above selected language in AARP site$")
	public void user_validates_pharmacies_available_language_specific_aarp() {
		PharmacyResultPage pharmacyResultPage = (PharmacyResultPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_RESULT_PAGE);

		
		JSONObject pharmacyResultActualJson = (JSONObject) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL);
		String zipcode = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.ZIPCODE);
		String planName = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.PLAN_NAME);
		String language = (String) getLoginScenario().getBean(
				PharmacySearchCommonConstants.LANGUAGE);
		
		//if(pharmacyResultPage.validatelanguageSpecificPharmacyResultpage(pharmacyResultActualJson,zipcode,planName,language)){
		if(pharmacyResultPage.validatePharmacyResultpage()){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating Pharmacy Results page ");
		}
		pharmacyResultPage.logOut();
	}

	@And("^the user selects \"Show pharmacies for these services\" in AARP Site$")
	public void user_selects_pharmacy_type_aarp_site(
			DataTable pharmacyAttributes) {
		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();

		String pharmacyType = pharmacyAttributesRow.get(0).getCells().get(0);
		PharmacySearchPage pharmacySearchAarpPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchAarpPage = pharmacySearchAarpPage
				.selectsPharmacy(pharmacyType);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
				pharmacySearchAarpPage);

	}

	@And("^the user enters zipcode and distance details for AARP site$")
	public void user_enters_zipcode_distance_details_aarp(
			DataTable zipAttributes) {			
		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {

			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
					zipAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = zipAttributesMap.get("Zip Code");
		System.out.println("zipcdoe"+zipcode);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE,
				zipcode);
		
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage
				.enterZipDistanceDetails(zipAttributesMap);
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	@And("^the user clicks chinese Link in AARP site$")
	public void click_chinese() {
		PharmacySearchPage pharmacySearchAarpPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchAarpPage = pharmacySearchAarpPage.clickChinese();
		if (pharmacySearchAarpPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchAarpPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}

	@And("^the user clicks espanol Link in AARP site$")
	public void click_espanol() {
		PharmacySearchPage pharmacySearchAarpPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchAarpPage = pharmacySearchAarpPage.clickEspanol();
		if (pharmacySearchAarpPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchAarpPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}
	

	@And("^the user clicks below Language Link in AARP site$")
	public void click_language(DataTable languageAttributes) {
		List<DataTableRow> languageAttributesRow = languageAttributes.getGherkinRows();
		String language = languageAttributesRow.get(0).getCells().get(0);
		System.out.println(language);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.LANGUAGE, language);
		PharmacySearchPage pharmacySearchAarpPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		if(language.equals("Spanish"))
			pharmacySearchAarpPage = pharmacySearchAarpPage.clickEspanol();
		else if(language.equals("Chinese"))
			pharmacySearchAarpPage = pharmacySearchAarpPage.clickChinese();
		
		if (pharmacySearchAarpPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchAarpPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}

	@And("^the user chooses a plan from dropdown in AARP site$")
	public void user_chooses_plan_dropdown_aarp(DataTable planAttributes) {
		List<DataTableRow> planAttributesRow = planAttributes.getGherkinRows();
		String planName = planAttributesRow.get(0).getCells().get(0);
		System.out.println(planName);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, planName);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage
				.selectsPlanName(planName);

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean("pharmacySearchAarpPage",
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
				pharmacySearchPage);
	}

	@And("^the user clicks create pdf in AARP Site$")
	public void click_create_pdf() {
		PharmacySearchPage pharmacySearchAarpPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		//PharmacyResultPage pharmacyResultPage = pharmacySearchAarpPage.searchesPharmacy();
		pharmacySearchAarpPage.clickCreatePdf();
		System.out.println("Create Pdf clicked");
	}

	@And("^the user chooses the year and a plan from dropdown in AARP site$")
	public void chooses_year_chooses_plan(DataTable planAttributes){
		List<DataTableRow> planAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> planAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < planAttributesRow.size(); i++) {

			planAttributesMap.put(planAttributesRow.get(i).getCells().get(0),
					planAttributesRow.get(i).getCells().get(1));
		}

		String year = planAttributesMap.get("Year");
		String planName = planAttributesMap.get("Plan Name");


		PharmacySearchPage pharmacySearchAarpPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchAarpPage = pharmacySearchAarpPage.selectYear(year);
		pharmacySearchAarpPage = pharmacySearchAarpPage.selectsPlanName(planName);

		if (pharmacySearchAarpPage != null) {
			getLoginScenario().saveBean("pharmacySearchAarpPage",
					pharmacySearchAarpPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
				pharmacySearchAarpPage);
	}

	@And("^the user hovers over the tooltip in AARP Site$")
	public void hovers_over_tooltip(DataTable pharmacyAttributes){
		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes.getGherkinRows();
		String pharmacyType = pharmacyAttributesRow.get(0).getCells().get(0);

		PharmacySearchPage pharmacySearchAarpPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchAarpPage = pharmacySearchAarpPage.hoverOverToolTip(pharmacyType);
	}

}
