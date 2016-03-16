/**
 * 
 */
package acceptancetests.login.ulayer;

import java.util.ArrayList;
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
import pages.member.ulayer.TerminatedHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pjaising
 *
 */
public class LoginAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP with following attributes$")
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
	}

	@When("^the user logs in successfully in AARP site$")
	public void login_successful() {
		WebDriver wd = getLoginScenario().getWebDriver();

		String userName = (String) getLoginScenario().getBean(
				LoginCommonConstants.USERNAME);
		String password = (String) getLoginScenario().getBean(
				LoginCommonConstants.PASSWORD);
		LoginPage loginPage = new LoginPage(wd);
		loginPage.loginWith(userName, password);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage
				.checkLoginSuccessful();

		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED,
				accountHomeExpectedJson);
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			JSONObject accountHomeActualJson = accountHomePage.accountHomeJson;
			getLoginScenario().saveBean(
					LoginCommonConstants.ACCOUNT_HOME_ACTUAL,
					accountHomeActualJson);
		}

	}

	@When("^the terminated member logs in successfully in AARP site$")
	public void login_terminateduser_successful() {
		WebDriver wd = getLoginScenario().getWebDriver();
		String userName = (String) getLoginScenario().getBean(
				LoginCommonConstants.USERNAME);
		String password = (String) getLoginScenario().getBean(
				LoginCommonConstants.PASSWORD);
		LoginPage loginPage = new LoginPage(wd);
		loginPage.loginWith(userName, password);
		TerminatedHomePage terminatedHomePage = (TerminatedHomePage) loginPage
				.checkLoginSuccessful();

		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = terminatedHomePage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				LoginCommonConstants.TERMINATED_ACCOUNT_EXPECTED,
				accountHomeExpectedJson);

		// get actual data
		if (terminatedHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.TERMINATED_HOME_PAGE,
					terminatedHomePage);
			Assert.assertTrue(true);
			JSONObject accountHomeActualJson = terminatedHomePage.terminatedAccountJson;
			getLoginScenario().saveBean(
					LoginCommonConstants.ACCOUNT_HOME_ACTUAL,
					accountHomeActualJson);
		}

	}

	@Then("^the user validates following plan details$")
	public void login_validation(DataTable memberAttributes) {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		JSONObject accountHomeActual = (JSONObject) getLoginScenario().getBean(
				LoginCommonConstants.ACCOUNT_HOME_ACTUAL);
		JSONObject accountHomeExpected = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED);
		try {
			JSONAssert.assertEquals(accountHomeExpected, accountHomeActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		accountHomePage.logOut();

	}

	@Then("^the user validates following terminated plan details$")
	public void login_terminate_validation(DataTable memberAttributes) {

		AccountHomePage terminatedAccountPage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.TERMINATED_HOME_PAGE);
		JSONObject terminatedAccountActual = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.TERMINATED_ACCOUNT_ACTUAL);
		JSONObject terminatedAccountExpected = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.TERMINATED_ACCOUNT_EXPECTED);
		System.out.println("terminatedAccountActual===>"
				+ terminatedAccountActual.toString());
		System.out.println("terminatedAccountExpected===>"
				+ terminatedAccountExpected.toString());
		try {
			JSONAssert.assertEquals(terminatedAccountExpected,
					terminatedAccountActual, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		terminatedAccountPage.logOut();

	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		// wd.close();
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
