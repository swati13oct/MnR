/**
 * 
 */
package acceptancetests.browsercheck.member.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
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
 * @author pnampall
 * 
 */
public class UnsupportedBrowserMemberAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;
	

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the AARP Member site landing page$")
	public void user_login_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	}
	
	@When("^the user is on the ulayer member home page$")
	public void user_on_ulayer_membr_home_page(){
		
		LoginPage memberLoginHomepage = (LoginPage) getLoginScenario()
				.getBean(PageConstants.LOGIN_PAGE);
		JSONObject browserCheckActual = memberLoginHomepage.getBrowserCheck();
		// Get expected data 
		String fileName = "browsercheckexpected";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER_MEMBER
				+ File.separator
				+ LoginCommonConstants.MEMBER_BROWSER_CHECK_FLOW_NAME
				+ File.separator;
		JSONObject browserCheckExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				LoginCommonConstants.MEMBER_BROWSER_CHECK_ACTUAL,
				browserCheckActual);
		getLoginScenario().saveBean(
				LoginCommonConstants.MEMBER_BROWSER_CHECK_EXPECTED,
				browserCheckExpectedJson);
	
	}
	@When("^the user logs in with a registered AMP with following details in member AARP medicare plans site$")
	public void user_logs_in_with_membber(DataTable memberAttributes)
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
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		
		
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			JSONObject browserCheckActual = accountHomePage.getBrowserCheck();
			// Get expected data 
			String fileName = "browsercheckexpected";
			String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER_MEMBER
					+ File.separator
					+ LoginCommonConstants.MEMBER_BROWSER_CHECK_FLOW_NAME
					+ File.separator;
			JSONObject browserCheckExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);

			getLoginScenario().saveBean(
					LoginCommonConstants.MEMBER_BROWSER_CHECK_ACTUAL,
					browserCheckActual);
			getLoginScenario().saveBean(
					LoginCommonConstants.MEMBER_BROWSER_CHECK_EXPECTED,
					browserCheckExpectedJson);	
	}

	}
	
	@Then("^the user validates error message on the browser of AARP member site$")
	public void user_validates_error_message(){
		Capabilities caps = ((RemoteWebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER)).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();		
		Assert.assertEquals("firefox", browserName);
		Assert.assertEquals("22.0", browserVersion);		
		JSONObject browserCheckActual = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.MEMBER_BROWSER_CHECK_ACTUAL);
		JSONObject browserCheckExpectedJson = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.MEMBER_BROWSER_CHECK_EXPECTED);		
		try {
			JSONAssert.assertEquals(browserCheckActual,
					browserCheckExpectedJson, true);
		} catch (JSONException e) {
		
			e.printStackTrace();
		}
		
	}
	
	@Then("^the user validates unsupported error message after login in member AARP medicare plans site$")
	public void member_aarpm_login_validation() {
		 getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		Capabilities caps = ((RemoteWebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER)).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();		
		Assert.assertEquals("firefox", browserName);
		Assert.assertEquals("22.0", browserVersion);		
		JSONObject browserCheckActual = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.MEMBER_BROWSER_CHECK_ACTUAL);
		JSONObject browserCheckExpectedJson = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.MEMBER_BROWSER_CHECK_EXPECTED);		
		try {
			JSONAssert.assertEquals(browserCheckActual,
					browserCheckExpectedJson, true);
		} catch (JSONException e) {
		
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		//getLoginScenario().flushBeans();
	}
}
