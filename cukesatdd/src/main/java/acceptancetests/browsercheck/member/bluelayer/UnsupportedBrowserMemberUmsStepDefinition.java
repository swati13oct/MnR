/**
 * 
 */
package acceptancetests.browsercheck.member.bluelayer;

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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.LoginAssistancePage;
import pages.member.bluelayer.*;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.ContactUsPage;
import pages.member.bluelayer.*;

/**
 * @author pnampall
 * 
 */
public class UnsupportedBrowserMemberUmsStepDefinition<loginScenario> {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
		
	}
	@Given("^the user is on the UMS Member site landing page$")
	public void uhc_member_login_page(){
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		
	}
	@When("^the user is on the UMS Member home page$")
	public void member_home_page(){
		
		LoginPage loginPage = (LoginPage) getLoginScenario()
				.getBean(PageConstants.LOGIN_PAGE);
		JSONObject browserCheckActual = loginPage.getBrowserCheck();
		// Get expected data 
		String fileName = "browsercheckexpected";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER_MEMBER
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
	@When("^the user logs in with a registered UMP with following details in member UHC medicare site$")
	public void user_member_login_page(DataTable memberAttributes){
		
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		if(category==null){
			category="Individual";
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
				.getUMSMemberWithDesiredAttributes(desiredAttributes);
		
		
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
		
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
		
		
		
		//JSONObject accountHomeActualJson =  null;
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
			Assert.assertTrue(true);
			JSONObject browserCheckActual = loginPage.getBrowserCheck();
			// Get expected data 
			String fileName = "browsercheckexpected";
			String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER_MEMBER
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
	@Then("^the user validates unsupported error message on the browser$")
	public void member_browser_check(){
		Capabilities caps = ((RemoteWebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER)).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();		
		Assert.assertEquals("firefox", browserName);
		Assert.assertEquals("28.0", browserVersion);		
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
	
	@Then("^the user validates unsupported error message after login in UHC medicare site$")
	public void member_uhcm_login_validation()
	{
		 getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			Capabilities caps = ((RemoteWebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER)).getCapabilities();
			String browserName = caps.getBrowserName();
			String browserVersion = caps.getVersion();		
			Assert.assertEquals("firefox", browserName);
			Assert.assertEquals("28.0", browserVersion);		
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
	
	@And("^the user navigates to plan summary page in UHC site$")
	public void user_navigates_to_plan_summary()
	{
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.navigateToPlanSummary();	
	}
	
	@And("^the user navigates to drug search in UHC site$")
	public void user_navigates_to_drug_search_in_UHC_site()
	{
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ManageDrugPage managedrugpage= accountHomePage.navigateToEstimateCost("MAPD");
		if (managedrugpage!=null)
		{
			System.out.println("dce");
	
		}
		else
		{
			System.out.println("dce page not found");
		}
	}
	@When("^the user navigates to contact us page in UHC site$")
	public void views_order_materials_in_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ContactUsPage contactusPage = accountHomePage.navigatesToContactUsPage();
		if (contactusPage != null) {

				System.out.println("Contact Us page found !!!");
		 }
		else
			{
				System.out.println("Contact Us page Not found !!!");
			}
		accountHomePage.logOut();
		}
	
	@And("^user is on UMS error page$")
	public void user_is_on_UMS_error_page()
	{
		LoginPage loginPage = (LoginPage) getLoginScenario()
				.getBean(PageConstants.LOGIN_PAGE);
		loginPage.start("https://member.awe-dev-a-uhcmedicaresolutions.uhc.com/500.html");
	}
	
	@And("^user navigates to login assistance page from member UHC site$")
	public void user_navigates_to_login_assistance_page_UHC()
	{
		getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		LoginPage loginPage = (LoginPage) getLoginScenario()
				.getBean(PageConstants.LOGIN_PAGE);
		LoginAssistancePage loginassistance= loginPage.navigateToLoginAssistance();
		
		if (loginassistance!=null)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail("Errorin loading UHC login assistance page");
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
