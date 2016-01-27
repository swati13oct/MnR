package acceptancetests.gogreen.ulayer;

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
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.profandpref.data.ProfnPrefCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */
public class GoGreenAarpStepDefintion {
	

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^registered member for go green in AARP site$")
	public void login_with_member_aarp(DataTable memberAttributes) {

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
		loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		AccountHomePage accountHomePage = (AccountHomePage) loginPage
				.checkLoginSuccessful();
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

	@When("^the user clicks on go green icon in AARP site$")
	public void views_benefits_and_Coverage() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		
		MyPreferencesPage myPreferencesPage = accountHomePage.clicksOnGoGreenIcon();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject myPreferencesExpectedJson = myPreferencesPage
				.getExpectedData(expectedDataMap);
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
		
		/* Validations */
		try {
			JSONAssert.assertEquals(myPreferencesExpectedJson,
					myPreferencesActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}
	
	@And("^the user updates delivery preference with the following details in AARP site$")
	public void updates_delivery_preference_details_aarp(DataTable prefAttributes)
	{
		/* Reading the given attribute from feature file */
		List<DataTableRow> prefAttributesRow = prefAttributes
				.getGherkinRows();
		Map<String, String> prefAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < prefAttributesRow.size(); i++) {
			prefAttributesMap.put(prefAttributesRow.get(i).getCells()
					.get(0), prefAttributesRow.get(i).getCells().get(1));
		}
		
		MyPreferencesPage myPreferencesPage = (MyPreferencesPage) getLoginScenario()
				.getBean(PageConstants.MY_PREFERENCES_PAGE);
		
		myPreferencesPage = myPreferencesPage.updatesDeliveryPreference(prefAttributesMap);
		
		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject myPreferencesExpectedJson = myPreferencesPage
				.getExpectedData(expectedDataMap);
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

	
	@Then("^the user validates the updated delivery preferences in AARP site$")
	public void validates_updated_delivery_preferences_aarp()
	{
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
	
	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
