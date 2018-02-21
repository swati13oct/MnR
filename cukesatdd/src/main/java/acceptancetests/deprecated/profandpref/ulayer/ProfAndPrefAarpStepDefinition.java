/**
 * 
 */
package acceptancetests.deprecated.profandpref.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.MyPreferencesPage;
import pages.member.ulayer.MyProfilesPage;
import acceptancetests.deprecated.atdd.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.member.PageConstants;
import acceptancetests.deprecated.login.data.LoginCommonConstants;
import acceptancetests.deprecated.profandpref.data.ProfnPrefCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author pagarwa5
 *
 */
public class ProfAndPrefAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered member for My Profile & Preferences in AARP Site$")
	public void login_with_member(DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();

		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario
				.getAMPMemberWithDesiredAttributes(desiredAttributes);

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
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);

		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		 
		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		if (accountHomePage != null) {
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
				expectedDataMap);

	}

	@When("^the user view My Profile & Preferences in AARP Site$")
	public void views_benefits_and_Coverage() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MyProfilesPage myProfilesPage = accountHomePage.navigateToProfAndPref();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject myProfilesPageExpectedJson = myProfilesPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				ProfnPrefCommonConstants.MY_PROFILES_EXPECTED,
				myProfilesPageExpectedJson);

		JSONObject myProfilesPageActualJson = null;
		if (myProfilesPage != null) {
			getLoginScenario().saveBean(PageConstants.MY_PROFILES_PAGE,
					myProfilesPage);
			Assert.assertTrue(true);
			myProfilesPageActualJson = myProfilesPage.myProfilesJson;
		}
		getLoginScenario().saveBean(
				ProfnPrefCommonConstants.MY_PROFILES_ACTUAL,
				myProfilesPageActualJson);

	}

	@Then("^the user validates my profile and preferences in AARP Site$")
	public void user_validates_my_profiles_page_aarp() {
		JSONObject myProfilesPageActualJson = (JSONObject) getLoginScenario()
				.getBean(ProfnPrefCommonConstants.MY_PROFILES_ACTUAL);
		JSONObject myProfilesPageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ProfnPrefCommonConstants.MY_PROFILES_EXPECTED);

		/* Validations */
		try {
			JSONAssert.assertEquals(myProfilesPageExpectedJson,
					myProfilesPageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user navigates to My Preferences in AARP site$")
	public void user_selects_preferences() {
		MyProfilesPage myProfilesPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.MY_PROFILES_PAGE);

		MyPreferencesPage myPreferencesPage = myProfilesPage
				.navigateToMyPrefTab();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		String key = ProfnPrefCommonConstants.BEFORE_UPDATE;
		JSONObject myPreferencesExpectedJson = myPreferencesPage
				.getExpectedData(expectedDataMap, key);
		getLoginScenario().saveBean(
				ProfnPrefCommonConstants.MY_PREFERENCES_EXPECTED,
				myPreferencesExpectedJson);

		JSONObject myPreferencesActualJson = null;
		if (myPreferencesPage != null) {
			getLoginScenario().saveBean(PageConstants.MY_PREFERENCES_PAGE,
					myPreferencesPage);
			Assert.assertTrue(true);
			myPreferencesActualJson = myPreferencesPage.myPreferencesJson;
		}
		getLoginScenario().saveBean(
				ProfnPrefCommonConstants.MY_PREFERENCES_ACTUAL,
				myPreferencesActualJson);
	}

	@And("^the user navigates to My Preferences in AARP Site$")
	public void user_navigates_my_preferences_aarp() {
		MyProfilesPage myProfilesPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.MY_PROFILES_PAGE);

		MyPreferencesPage myPreferencesPage = myProfilesPage
				.navigateToMyPrefTab();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		String Key = ProfnPrefCommonConstants.BEFORE_UPDATE;
		JSONObject myPreferencesExpectedJson = myPreferencesPage
				.getExpectedData(expectedDataMap, Key);
		getLoginScenario().saveBean(
				ProfnPrefCommonConstants.MY_PREFERENCES_EXPECTED,
				myPreferencesExpectedJson);
		getLoginScenario().saveBean(
				ProfnPrefCommonConstants.MY_PREFERENCES_BEFORE_UPDATE_EXPECTED,
				myPreferencesExpectedJson); // used while resetting preferences

		JSONObject myPreferencesActualJson = null;
		if (myPreferencesPage != null) {
			getLoginScenario().saveBean(PageConstants.MY_PREFERENCES_PAGE,
					myPreferencesPage);
			Assert.assertTrue(true);
			myPreferencesActualJson = myPreferencesPage.myPreferencesJson;
		}
		getLoginScenario().saveBean(
				ProfnPrefCommonConstants.MY_PREFERENCES_ACTUAL,
				myPreferencesActualJson);

		System.out.println("myPreferencesActualJson-->"
				+ myPreferencesActualJson.toString());
		System.out.println("myPreferencesExpectedJson-->"
				+ myPreferencesExpectedJson.toString());

		/* Validations */
		try {
			JSONAssert.assertEquals(myPreferencesExpectedJson,
					myPreferencesActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Then("^the user validates displayed document name and delivery preferences for a plan in AARP site$")
	public void user_views_documentName() {

		MyPreferencesPage myPreferencesPage = (MyPreferencesPage) getLoginScenario()
				.getBean(PageConstants.MY_PREFERENCES_PAGE);
		JSONObject myPreferencesActualJson = (JSONObject) getLoginScenario()
				.getBean(ProfnPrefCommonConstants.MY_PREFERENCES_ACTUAL);
		JSONObject myPreferencesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ProfnPrefCommonConstants.MY_PREFERENCES_EXPECTED);

		/* Validations */
		try {
			JSONAssert.assertEquals(myPreferencesExpectedJson,
					myPreferencesActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		myPreferencesPage.logOut();

	}

	@And("^the user updates preferences by changing delivery preferences for corresponding document name in AARP Site$")
	public void user_edits_doc_name_and_delivery_pref(
			DataTable profileAttributes) {

		String preferences = profileAttributes.getGherkinRows().get(0)
				.getCells().get(0);

		MyPreferencesPage myPreferencesPage = (MyPreferencesPage) getLoginScenario()
				.getBean(PageConstants.MY_PREFERENCES_PAGE);
		myPreferencesPage.editDocDetails(preferences);
		myPreferencesPage = myPreferencesPage.updatesDeliveryPreference();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		String key = ProfnPrefCommonConstants.AFTER_UPDATE;
		JSONObject myPreferencesExpectedJson = myPreferencesPage
				.getExpectedData(expectedDataMap, key);
		getLoginScenario().saveBean(
				ProfnPrefCommonConstants.MY_PREFERENCES_EXPECTED,
				myPreferencesExpectedJson);

		JSONObject myPreferencesActualJson = null;
		if (myPreferencesPage != null) {
			getLoginScenario().saveBean(PageConstants.MY_PREFERENCES_PAGE,
					myPreferencesPage);
			Assert.assertTrue(true);
			myPreferencesActualJson = myPreferencesPage.myPreferencesJson;
		}
		getLoginScenario().saveBean(
				ProfnPrefCommonConstants.MY_PREFERENCES_ACTUAL,
				myPreferencesActualJson);

	}

	@Then("^the user validates the updated preferences in AARP site$")
	public void user_validates_updated_preferences_aarp() {

		MyPreferencesPage myPreferencesPage = (MyPreferencesPage) getLoginScenario()
				.getBean(PageConstants.MY_PREFERENCES_PAGE);
		JSONObject myPreferencesActualJson = (JSONObject) getLoginScenario()
				.getBean(ProfnPrefCommonConstants.MY_PREFERENCES_ACTUAL);
		JSONObject myPreferencesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ProfnPrefCommonConstants.MY_PREFERENCES_EXPECTED);

		System.out.println("myPreferencesActualJson-->"
				+ myPreferencesActualJson.toString());
		System.out.println("myPreferencesExpectedJson-->"
				+ myPreferencesExpectedJson.toString());

		/* Validations */
		try {
			JSONAssert.assertEquals(myPreferencesExpectedJson,
					myPreferencesActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		JSONObject myPreferencesJson = (JSONObject) getLoginScenario().getBean(
				ProfnPrefCommonConstants.MY_PREFERENCES_BEFORE_UPDATE_EXPECTED);

		myPreferencesPage = myPreferencesPage
				.resetPreferences(myPreferencesJson);

		if (myPreferencesPage != null) {
			getLoginScenario().saveBean(PageConstants.MY_PREFERENCES_PAGE,
					myPreferencesPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Reset failed");
		}
		myPreferencesPage.logOut();

	}

	@And("^the user validates account profile in AARP Site$")
	public void user_views_account_profile() {
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);

		String accountInfo = profAndPrefPage.getAccountInfo();
		System.out.println("accountInfo======>" + accountInfo);

	}

	@Then("^the user validates plan profile in AARP Site$")
	public void user_views_plan_profile() {
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);

		String planProfileInfo = profAndPrefPage.getPlanProfileInfo();
		System.out.println("accountInfo======>" + planProfileInfo);

	}

	@And("^the user edits and saves account profile information in AARP Site$")
	public void user_edits_account_profile(DataTable profileAttributes) {
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);
		profAndPrefPage.editProfile(profileAttributesMap);

	}

	@And("^the user edits and saves plan profile in AARP Site$")
	public void user_edits_plan_profiles(DataTable profileAttributes) {
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);
		profAndPrefPage.editPlanProfile(profileAttributesMap);

	}

	@And("^the user edits and saves alternate address in plan profile in AARP Site$")
	public void user_edits_alternate_address(DataTable profileAttributes) {
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);
		profAndPrefPage.editAlternateAddress(profileAttributesMap);

	}

	@And("^the user edits and saves mailing address in plan profile in AARP Site$")
	public void user_edits_mailing_address(DataTable profileAttributes) {
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);
		profAndPrefPage.editMailingAddress(profileAttributesMap);
		System.out.println("mailing address edited");

	}

	@And("^the user clicks update preferences in AARP site$")
	public void user_clicks_update_pref() {
		MyPreferencesPage myPrefPage = (MyPreferencesPage) getLoginScenario()
				.getBean(PageConstants.MY_PREF_PAGE);
		myPrefPage.clickUpdatePref();
	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		if(wd!=null){
		   wd.quit();
		}
		getLoginScenario().flushBeans();
	}

}
