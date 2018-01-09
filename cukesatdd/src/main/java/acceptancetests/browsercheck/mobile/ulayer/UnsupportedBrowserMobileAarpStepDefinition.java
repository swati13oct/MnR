/**
 * 
 */
package acceptancetests.browsercheck.mobile.ulayer;

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

import pages.mobile.member.ulayer.BenefitsSummaryPage;
import pages.mobile.member.ulayer.LoginPage;
import acceptancetests.atdd.data.mobile.member.PageConstants;
import acceptancetests.atdd.mobile.data.CommonConstants;
import acceptancetests.mobile.login.data.LoginCommonConstants;
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
public class UnsupportedBrowserMobileAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the mobile AARP site landing page$")
	public void user_mobile_login_page()
	{
		WebDriver wd = getLoginScenario().getMobileWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	}
	@When("^the user is on the mobile AARP home page$")
	public void user_is_on_mobile_home_page()
	{	
		LoginPage mobileLoginHomepage = (LoginPage) getLoginScenario()
				.getBean(PageConstants.LOGIN_PAGE);
		JSONObject browserCheckActual = mobileLoginHomepage.getBrowserCheck();
		// Get expected data 
		String fileName = "browsercheck_ulayer";
		String directory = CommonConstants.MOBILE_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER_MEMBER
				+ File.separator
				+ LoginCommonConstants.MOBILE_BROWSER_CHECK_FLOW_NAME
				+ File.separator;
		JSONObject browserCheckExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				LoginCommonConstants.MOBILE_BROWSER_CHECK_ACTUAL,
				browserCheckActual);
		getLoginScenario().saveBean(
				LoginCommonConstants.MOBILE_BROWSER_CHECK_EXPECTED,
				browserCheckExpectedJson);
		System.out.println("browserCheckActual::::::::::::::"+browserCheckActual);
		System.out.println("browserCheckExpectedJson::::::"+browserCheckExpectedJson);
		
	}
	@When("^the user logs in with a registered AMP with following details in mobile AARP site$")
	public void user_logs_with_registerd_member(DataTable memberAttributes){
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
		desiredAttributes.add("mobile");
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
		
		BenefitsSummaryPage benefitsSummaryPage=loginPage.loginWith(userName, pwd);
		
		if(benefitsSummaryPage!=null) 
		{
			getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE, benefitsSummaryPage);
			Assert.assertTrue(true);
			
			JSONObject browserCheckActual = benefitsSummaryPage.getBrowserCheck();
			// Get expected data 
			String fileName = "browsercheck_ulayer";
			String directory = CommonConstants.MOBILE_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER_MEMBER
					+ File.separator
					+ LoginCommonConstants.MOBILE_BROWSER_CHECK_FLOW_NAME
					+ File.separator;
			JSONObject browserCheckExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
 
			getLoginScenario().saveBean(
					LoginCommonConstants.MOBILE_BROWSER_CHECK_ACTUAL,
					browserCheckActual);
			getLoginScenario().saveBean(
					LoginCommonConstants.MOBILE_BROWSER_CHECK_EXPECTED,
					browserCheckExpectedJson);
			
			
		}
			
	}
	@Then("^the user validates error message on the browser for mobile AARP site after login$")
	public void user_validates_error_message_after_login(){
		
		getLoginScenario().getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
		Capabilities caps = ((RemoteWebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER)).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();		
		Assert.assertEquals("chrome", browserName);
		Assert.assertEquals("50.0.2661.94", browserVersion);		
		JSONObject browserCheckActual = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.MOBILE_BROWSER_CHECK_ACTUAL);
		JSONObject browserCheckExpectedJson = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.MOBILE_BROWSER_CHECK_EXPECTED);		
		try {
			JSONAssert.assertEquals(browserCheckActual,
					browserCheckExpectedJson, true);
		} catch (JSONException e) {
		
			e.printStackTrace();
		}
		
		
	}
	
	
	@Then("^the user validates error message on the browser for mobile AARP site$") 
	public void user_validates_error_message()
	{
		
		Capabilities caps = ((RemoteWebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER)).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();		
		Assert.assertEquals("chrome", browserName);
		Assert.assertEquals("50.0.2661.94", browserVersion);		
		JSONObject browserCheckActual = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.MOBILE_BROWSER_CHECK_ACTUAL);
		JSONObject browserCheckExpectedJson = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.MOBILE_BROWSER_CHECK_EXPECTED);		
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
		
	}
}
