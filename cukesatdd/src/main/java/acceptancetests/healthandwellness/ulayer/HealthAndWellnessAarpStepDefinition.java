/**
 * 
 */
package acceptancetests.healthandwellness.ulayer;

import gherkin.formatter.model.DataTableRow;

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

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.HealthAndWellnessPage;
import pages.member.ulayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.healthandwellness.data.HealthAndWellnessCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pjaising
 *
 */
public class HealthAndWellnessAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the AARP medicare site login page$")
	public void user_login_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	}
	
	@When("^the user logs in with a registered AMP with following details for health and wellness flow in AARP site$")
	public void user_logs_in(DataTable memberAttributes)
	{
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

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

		Map<String,String> loginCreds = loginScenario
				.getAMPMemberWithDesiredAttributes(desiredAttributes);
		
		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a "+ desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd );
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}
		
		LoginPage loginPage = (LoginPage)getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
		
		loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.checkLoginSuccessful();
		
		/*Get expected data*/
		Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage.getExpectedData(expectedDataMap);
		
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson, accountHomeActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
	}

	@And("^the user navigates to health and wellness page in AARP site$")
	public void navigation_to_healthandwellness()
	{
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		HealthAndWellnessPage healthAndWellnessPage = accountHomePage.navigateToHWPage();
		getLoginScenario().saveBean(PageConstants.HEALTH_AND_WELLNESS_PAGE, healthAndWellnessPage);
		
		/*Get actual data*/
		JSONObject healthAndWellnessActualJson = healthAndWellnessPage.healthAndWellessJson;
		getLoginScenario().saveBean(HealthAndWellnessCommonConstants.HEALTH_AND_WELLNESS_ACTUAL, healthAndWellnessActualJson);
		System.out.println("healthAndWellnessActualJson---->"+healthAndWellnessActualJson);
		
		/*Get expected data*/
		Map<String,JSONObject> expectedDataMap = (Map<String,JSONObject>) getLoginScenario().getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject healthAndWellnessExoectedJson = healthAndWellnessPage.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(HealthAndWellnessCommonConstants.HEALTH_AND_WELLNESS_EXPECTED, healthAndWellnessExoectedJson);
	}
	
	@Then("^the user validates health and wellness page in AARP site$")
	public void validate_health_and_wellness()
	{
		JSONObject healthAndWellnessActualJson = (JSONObject) getLoginScenario().getBean(HealthAndWellnessCommonConstants.HEALTH_AND_WELLNESS_ACTUAL);
		System.out.println("healthAndWellnessActualJson--->"+healthAndWellnessActualJson);
		
		JSONObject healthAndWellnessExoectedJson = (JSONObject) getLoginScenario().getBean(HealthAndWellnessCommonConstants.HEALTH_AND_WELLNESS_EXPECTED);
		System.out.println("healthAndWellnessExoectedJson--->"+healthAndWellnessExoectedJson);
		
		try {
			JSONAssert.assertEquals(healthAndWellnessExoectedJson, healthAndWellnessActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@After
	public void tearDown() {
		HealthAndWellnessPage healthAndWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstants.HEALTH_AND_WELLNESS_PAGE);
		healthAndWellnessPage.logout();
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
	}
}
