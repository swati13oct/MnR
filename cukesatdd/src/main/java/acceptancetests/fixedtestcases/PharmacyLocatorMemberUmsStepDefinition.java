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

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.PharmacyResultPage;
import pages.member.bluelayer.PharmacySearchPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
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
public class PharmacyLocatorMemberUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}




	@Given("^registered member to verify locate a pharmacy in UMS Site$")
	public void registered_member_located_pharmacy_ums(
			DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String category = memberAttributesMap.get("Member Type");

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);
		
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
		System.out.println(desiredAttributes.get(1));
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd,category);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
		}else{
			Assert.fail("Account Home page not displayed for the user "+userName);
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

	@When("^the user navigates to pharmacy search page in UMS site$")
	public void user_views_pharmacy_locator_ums() {
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

	@And("^the user enters distance details in UMS site$")
	public void user_enters_distance_details_ums(DataTable zipAttributes) {
		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {

			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
					zipAttributesRow.get(i).getCells().get(1));
		}
		String distance = zipAttributesMap.get("Distance");
		String countyName = zipAttributesMap.get("County Name");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.enterZipDistanceDetails(zipAttributesMap);
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	@And("^the user searches for pharmacies available in UMS site$")
	public void user_pharmacy_available_ums() {
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

	@Then("^the user validates the pharmacies available in UMS site$")
	public void user_validates_pharmacies_available_ums() {
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
		//pharmacyResultPage.logOut();
	}

	@Then("^the user validates the pharmacies available for the above selected language in UMS site$")
	public void user_validates_pharmacies_available_language_specific_ums() {
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
		if(pharmacyResultPage.validatelanguageSpecificPharmacyResultpage(pharmacyResultActualJson,zipcode,planName,language)){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating Pharmacy Results page ");
		}
		//pharmacyResultPage.logOut();
	}

	@And("^the user selects \"Show pharmacies for these services\" in UMS Site$")
	public void user_selects_pharmacy_type_ums_site(
			DataTable pharmacyAttributes) {
		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();

		String pharmacyType = pharmacyAttributesRow.get(0).getCells().get(0);
		PharmacySearchPage pharmacySearchumsPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchumsPage = pharmacySearchumsPage.selectsPharmacy(pharmacyType);				
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
				pharmacySearchumsPage);

	}

	@And("^the user enters zipcode and distance details for UMS site$")
	public void user_enters_zipcode_distance_details_ums(
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

	@And("^the user clicks chinese Link in UMS site$")
	public void click_chinese_ums() {
		PharmacySearchPage pharmacySearchumsPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchumsPage = pharmacySearchumsPage.clickChinese();
		if (pharmacySearchumsPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchumsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}

	@And("^the user clicks espanol Link in UMS site$")
	public void click_espanol_ums() {
		PharmacySearchPage pharmacySearchumsPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchumsPage = pharmacySearchumsPage.clickEspanol();
		if (pharmacySearchumsPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchumsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}


	@And("^the user clicks below Language Link in UMS site$")
	public void click_language_ums(DataTable languageAttributes) {
		List<DataTableRow> languageAttributesRow = languageAttributes.getGherkinRows();
		String language = languageAttributesRow.get(0).getCells().get(0);
		System.out.println(language);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.LANGUAGE, language);
		PharmacySearchPage pharmacySearchumsPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		if(language.equals("Spanish"))
			pharmacySearchumsPage = pharmacySearchumsPage.clickEspanol();
		else if(language.equals("Chinese"))
			pharmacySearchumsPage = pharmacySearchumsPage.clickChinese();

		if (pharmacySearchumsPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchumsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}

	@And("^the user chooses a plan from dropdown in UMS site$")
	public void user_chooses_plan_dropdown_ums(DataTable planAttributes) {
		List<DataTableRow> planAttributesRow = planAttributes.getGherkinRows();
		String planName = planAttributesRow.get(0).getCells().get(0);
		System.out.println(planName);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, planName);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage
				.selectsPlanName(planName);

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean("pharmacySearchumsPage",
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
				pharmacySearchPage);
	}

	@And("^the user clicks create pdf in ums Site$")
	public void click_create_pdf_ums() {
		PharmacySearchPage pharmacySearchumsPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		//PharmacyResultPage pharmacyResultPage = pharmacySearchumsPage.searchesPharmacy();
		pharmacySearchumsPage.clickCreatePdf();
		System.out.println("Create Pdf clicked");
	}

}
