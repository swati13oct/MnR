/**
 * 
 */
package acceptancetests.phr.bluelayer;

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
import pages.member.bluelayer.PhrPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.phr.data.PhrCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */
public class PhrUmsStepDefinition {

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

		WebDriver wd = getLoginScenario().getWebDriver();

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);

	}

	@When("^the user navigates to personal health record in UHC site$")
	public void clicks_phr() {
		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PhrPage phrPage = accountHomePage.navigateToPhr();
		JSONObject phrExpectedJson = phrPage.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(PhrCommonConstants.PHR_EXPECTED,
				phrExpectedJson);

		// get Actual data
		JSONObject phrActualJson = phrPage.phrJson;
		getLoginScenario().saveBean(PhrCommonConstants.PHR_ACTUAL,
				phrActualJson);
		getLoginScenario().saveBean(PageConstants.PHR_PAGE, phrPage);

	}

	@Then("^the user validates the personal health records details in UHC site$")
	public void details_validation() {
		PhrPage phrPage = (PhrPage) getLoginScenario().getBean(
				PageConstants.PHR_PAGE);

		JSONObject phrActualJson = (JSONObject) getLoginScenario().getBean(
				PhrCommonConstants.PHR_ACTUAL);
		System.out.println("phrActualJson======>" + phrActualJson.toString());

		JSONObject phrExpectedJson = (JSONObject) getLoginScenario().getBean(
				PhrCommonConstants.PHR_EXPECTED);
		System.out.println("phrExpectedJson===>" + phrExpectedJson.toString());
		try {
			JSONAssert.assertEquals(phrExpectedJson, phrActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phrPage.logOut();
	}

}
