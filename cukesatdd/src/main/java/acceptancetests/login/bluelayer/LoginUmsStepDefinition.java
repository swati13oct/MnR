package acceptancetests.login.bluelayer;

/**
 * @author pagarwa5
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.TerminatedHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class LoginUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered UHC member with following attributes$")
	public void login_with_member(DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();

		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
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

	}

	@When("^the user logs in successfully in UMS site$")
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

			/* Get Actual Data */
			JSONObject accountHomeActualJson = accountHomePage.accountHomeJson;
			getLoginScenario().saveBean(
					LoginCommonConstants.ACCOUNT_HOME_ACTUAL,
					accountHomeActualJson);
		}

	}

	@When("^the user logs in successfully for terminated member in UHC site$")
	public void login_successful_for_terminate() {
		WebDriver wd = getLoginScenario().getWebDriver();

		String userName = (String) getLoginScenario().getBean(
				LoginCommonConstants.USERNAME);
		String password = (String) getLoginScenario().getBean(
				LoginCommonConstants.PASSWORD);
		LoginPage loginPage = new LoginPage(wd);
		loginPage.loginWith(userName, password);
		Object terminatedHomePage = loginPage.checkLoginSuccessful();
		if (terminatedHomePage != null) {
			getLoginScenario().saveBean("webDriver", wd);
			getLoginScenario().saveBean(PageConstants.TERMINATED_HOME_PAGE,
					terminatedHomePage);
			Assert.assertTrue(true);
		}

		else {
			Assert.fail("Login was not successful");
		}

	}

	@Then("^the user validates following plan details in UMS site$")
	public void login_validation(DataTable memberAttributes) {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		JSONObject accountHomeActual = (JSONObject) getLoginScenario().getBean(
				LoginCommonConstants.ACCOUNT_HOME_ACTUAL);
		JSONObject accountHomeExpected = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED);
		System.out.println("accountHomeActual=====>"
				+ accountHomeActual.toString());
		System.out.println("accountHomeExpected======>"
				+ accountHomeExpected.toString());
		try {
			JSONAssert.assertEquals(accountHomeExpected, accountHomeActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		accountHomePage.logOut();
	}

	@Then("^the user validates following UHC terminated plan details$")
	public void login_terminate_validation(DataTable memberAttributes) {

		TerminatedHomePage terminatedHomePage = (TerminatedHomePage) getLoginScenario()
				.getBean(PageConstants.TERMINATED_HOME_PAGE);
		// String planName = terminatedHomePage.getMyPlans();
		// System.out.println("planName---->"+planName);
		// Assert.assertEquals("AARP Medicare Plans | My Account Home",
		// wd.getTitle());

		terminatedHomePage.logOut();

	}

}
