/**
 * 
 */
package acceptancetests.phr.ulayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.PhrPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.phr.data.PhrCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */
public class PhrAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP with following details for phr flow in AARP site$") 
	public void login_with_member(DataTable memberAttributes) throws InterruptedException ,NoAlertPresentException,UnhandledAlertException {

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

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		
		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean("AccountHomePage", accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);

	}

	@When("^the user navigates to the personal health record in AARP site$")
	public void clicks_phr() throws InterruptedException,NoAlertPresentException {
		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean("AccountHomePage");
		PhrPage phrPage = accountHomePage.navigateToPhr();
		JSONObject phrExpectedJson = phrPage.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(PhrCommonConstants.PHR_EXPECTED,
				phrExpectedJson);
		JSONObject phrActualJson = phrPage.phrJson;
		getLoginScenario().saveBean(PhrCommonConstants.PHR_ACTUAL,
				phrActualJson);
		getLoginScenario().saveBean(PageConstants.PHR_PAGE, phrPage);

	}

	@Then("^the user validates the personal health records details in AARP site$")
	public void details_validation() {
		PhrPage phrPage = (PhrPage) getLoginScenario().getBean(
				PageConstants.PHR_PAGE);

		JSONObject phrActualJson = (JSONObject) getLoginScenario().getBean(
				PhrCommonConstants.PHR_ACTUAL);
		JSONObject phrExpectedJson = (JSONObject) getLoginScenario().getBean(
				PhrCommonConstants.PHR_EXPECTED);

		System.out.println("phrActualJson====>" + phrActualJson.toString());
		System.out.println("phrExpectedJson====>" + phrExpectedJson.toString());
		try {
			JSONAssert.assertEquals(phrExpectedJson, phrActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phrPage.logOut();
	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}
}
