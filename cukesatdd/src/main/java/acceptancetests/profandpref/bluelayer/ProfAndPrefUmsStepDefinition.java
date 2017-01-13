/**
 * 
 */
package acceptancetests.profandpref.bluelayer;

import gherkin.formatter.model.DataTableRow;


/*@author pagarwa5*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.MyPrefPage;
import pages.member.bluelayer.MyProfilesPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.profilesandpref.data.ProfilesAndPrefCommonConstants;
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
public class ProfAndPrefUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered member for My Profile & Preferences in UMS site$")
	public void login_with_member(DataTable memberAttributes) {
		/* Reading the given attribute from feature file */
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

		getLoginScenario().saveBean(CommonConstants.CATEGORY, category);

		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd,category);
		JSONObject accountHomeActualJson = null;
		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		/* get actual data */
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}
		System.out.println("accountHomeActualJson====>"
				+ accountHomeActualJson.toString());
		System.out.println("accountHomeExpectedJson====>"
				+ accountHomeExpectedJson.toString());

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);

	}

	@When("^the user navigates to My Profiles in UMS site$")
	public void navigates_my_profiles() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MyProfilesPage myProfilesPage = accountHomePage
				.navigateToMyProfilesPage();
		boolean isUpdate = false;
		/* Get expected data */
		JSONObject myProfilesActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject myProfilesExpectedJson = myProfilesPage
				.getExpectedData(expectedDataMap,isUpdate);
		getLoginScenario().saveBean(
				ProfilesAndPrefCommonConstants.MY_PROFILES_EXPECTED,
				myProfilesExpectedJson);

		/* Actual data */
		if (myProfilesPage != null) {
			getLoginScenario().saveBean(PageConstants.MY_PROFILES_PAGE,
					myProfilesPage);
			Assert.assertTrue(true);
			myProfilesActualJson = myProfilesPage.myProfilesJson;
			getLoginScenario().saveBean(
					ProfilesAndPrefCommonConstants.MY_PROFILES_ACTUAL,
					myProfilesActualJson);
		}

	}

	@Then("^the user validates the complete profile in UMS site$")
	public void user_validates_profile() {
		MyProfilesPage myProfilesPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.MY_PROFILES_PAGE);
		JSONObject myProfilesActualJson = (JSONObject) getLoginScenario()
				.getBean(ProfilesAndPrefCommonConstants.MY_PROFILES_ACTUAL);
		JSONObject myProfilesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ProfilesAndPrefCommonConstants.MY_PROFILES_EXPECTED);

		System.out.println("myProfilesActualJson=====>"
				+ myProfilesActualJson.toString());
		System.out.println("myProfilesExpectedJson===>"
				+ myProfilesExpectedJson.toString());
		/* Validations */
		try {
			JSONAssert.assertEquals(myProfilesExpectedJson,
					myProfilesActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		myProfilesPage.logOut();

	}

	@And("^the user selects my preferences tab in UMS site$")
	public void user_selects_preferences() {

		MyProfilesPage myProfilesPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.MY_PROFILES_PAGE);
		MyPrefPage myPrefPage = myProfilesPage.selectMyPref();
		/* Get expected data */
		boolean isUpdate = false;
		JSONObject myPrefActualJson = null;
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject myPrefExpectedJson = myPrefPage
				.getExpectedData(expectedDataMap,false);
		getLoginScenario().saveBean(
				ProfilesAndPrefCommonConstants.MY_PREFERENCES_EXPECTED,
				myPrefExpectedJson);

		/* Actual data */
		if (myPrefPage != null) {
			getLoginScenario().saveBean(PageConstants.MY_PREF_PAGE, myPrefPage);
			Assert.assertTrue(true);
			myPrefActualJson = myPrefPage.myPreferencesJson;
			getLoginScenario().saveBean(
					ProfilesAndPrefCommonConstants.MY_PREFERENCES_ACTUAL,
					myPrefActualJson);
		}

	}

	@And("^the user validates the document name and delivery preferences for a plan in UMS site$")
	public void user_views_documentName() {
		MyPrefPage myPrefPage = (MyPrefPage) getLoginScenario().getBean(
				PageConstants.MY_PREF_PAGE);

		JSONObject myPrefActualJson = (JSONObject) getLoginScenario().getBean(
				ProfilesAndPrefCommonConstants.MY_PREFERENCES_ACTUAL);
		JSONObject myPrefExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ProfilesAndPrefCommonConstants.MY_PREFERENCES_EXPECTED);

		System.out.println("myPrefActualJson=====>"
				+ myPrefActualJson.toString());
		System.out.println("myPrefExpectedJson===>"
				+ myPrefExpectedJson.toString());
		/* Validations */
		try {
			JSONAssert.assertEquals(myPrefExpectedJson, myPrefActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		myPrefPage.logOut();

	}

	@And("^the user edits account profile in UMS Site$")
	public void user_edits_account_profile(DataTable profileAttributes) {
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage myProfilesPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.MY_PROFILES_PAGE);
		myProfilesPage.editProfile(profileAttributesMap);

	}

	@And("^the user edits plan profile in UMS Site$")
	public void user_edits_plan_profiles(DataTable profileAttributes) {
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage myProfilesPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.MY_PROFILES_PAGE);
		myProfilesPage.editPlanProfile(profileAttributesMap);

	}

	@And("^the user edits alternate address in plan profile in UMS Site$")
	public void user_edits_alternate_address(DataTable profileAttributes) {
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage myProfilesPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.MY_PROFILES_PAGE);
		myProfilesPage.editAlternateAddress(profileAttributesMap);

	}

	@And("^the user edits mailling address in plan profile in UMS Site$")
	public void user_edits_mailing_address(DataTable profileAttributes) {
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage myProfilesPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.MY_PROFILES_PAGE);
		myProfilesPage.editMailingAddress(profileAttributesMap);
		System.out.println("mailing address edited");
		
		boolean isUpdate = true;
		/* Get expected data */
		JSONObject myProfilesActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject myProfilesExpectedJson = myProfilesPage
				.getExpectedData(expectedDataMap,isUpdate);
		getLoginScenario().saveBean(
				ProfilesAndPrefCommonConstants.MY_PROFILES_EXPECTED,
				myProfilesExpectedJson);

		/* Actual data */
		if (myProfilesPage != null) {
			getLoginScenario().saveBean(PageConstants.MY_PROFILES_PAGE,
					myProfilesPage);
			Assert.assertTrue(true);
			myProfilesActualJson = myProfilesPage.myProfilesJson;
			getLoginScenario().saveBean(
					ProfilesAndPrefCommonConstants.MY_PROFILES_ACTUAL,
					myProfilesActualJson);
		}

	}

	@And("^the user changes delivery preferences for document name in UMS Site$")
	public void user_edits_doc_name_and_delivery_pref(
			DataTable profileAttributes) {
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyPrefPage myPrefPage = (MyPrefPage) getLoginScenario().getBean(
				PageConstants.MY_PREF_PAGE);
		myPrefPage.editDocDetails(profileAttributesMap);
		System.out.println("docDetails edited");

	}

	@And("^user click update preferences in UMS site$")
	public void user_clicks_update_pref() {
		MyPrefPage myPrefPage = (MyPrefPage) getLoginScenario().getBean(
				PageConstants.MY_PREF_PAGE);
		myPrefPage.clickUpdatePref();

	}
	
	@And("^the add plan link should be hidden in UMS site$")
	public void add_Plan_Link_Should_Be_Hidden_In_UMS_Site() {
		MyProfilesPage myPrefPage = (MyProfilesPage) getLoginScenario().getBean(
				PageConstants.MY_PROFILES_PAGE);
		myPrefPage.validateAddPlanLink();
	}
}
