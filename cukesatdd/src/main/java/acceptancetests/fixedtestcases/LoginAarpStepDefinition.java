/**
 * 
 */
package acceptancetests.fixedtestcases;

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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.TerminatedHomePage;

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

	@Given("^the user is on the AARP medicare site login page$")
	public void user_login_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	}
	
	@When("^the user logs in with a registered AMP with following details in AARP site$")
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
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		
		
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			
	}

	}

	@When("^the terminated user logs in with a registered AMP with following details in AARP site$")
	public void login_terminateduser_successful(DataTable memberAttributes) {
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
		TerminatedHomePage terminatedHomePage = (TerminatedHomePage) loginPage.loginWith(userName, pwd);
		
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
			getLoginScenario().saveBean(PageConstants.TERMINATED_HOME_PAGE,
					terminatedHomePage);
			Assert.assertTrue(true);
			JSONObject accountHomeActualJson = terminatedHomePage.terminatedAccountJson;
			getLoginScenario().saveBean(
					LoginCommonConstants.ACCOUNT_HOME_ACTUAL,
					accountHomeActualJson);
		}

	}

	@Then("^the user validates plan and member details after login in AARP site$")
	public void login_validation() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		if(accountHomePage.validateGogreenPopup())
			accountHomePage.closeGogreenPopup();
		
		if(accountHomePage.validateAccountHome())
			Assert.assertTrue(true);
		else
			Assert.fail("Login failed, could not validate the account home page");
		
		accountHomePage.logOut();

	}

	@Then("^the user validates terminated plan details$")
	public void login_terminate_validation() {

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
	
	@Then("^the user validates the preferred Mail service link in menu details$")
	public void user_validates_preferred_mail_service_link() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		
		accountHomePage.validatePreferredMailOderLink();
		accountHomePage.logOut();

	}

	@Then("^the user validates the order drugs from your preferred Mail Service pharmacy link in AARP site$")
	public void user_validates_order_drugs_from_your_preferred_Mail_Service_pharmacy_link() {


		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		
		accountHomePage.validateDrugsPreferredMailOderLink();
		accountHomePage.logOut();

	}
	
	@Then("^the user should be able to sign out and Sign In page is displayed.$")
	public void the_user_should_be_able_to_sign_out_and_Sign_In_page_is_displayed() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		accountHomePage.logOut();
		LoginPage loginPage = (LoginPage) getLoginScenario()
				.getBean(PageConstants.LOGIN_PAGE);
		
		LoginPage loginPage1 = loginPage.validateLoginPage();
		System.out.println("loginPage1 value"+loginPage1);
	}
	

	/*
	 @And("^click on View Health & Wellness button and My Health and Wellness page should be displayed$")
	 public void click_on_View_Health_and_Wellness_button_and_My_Health_and_Wellness_page_should_be_displayed(){
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.navigateToHealthAndWellnessPage();
	 }
	 
	 @And("verify Health & Wellness sub tabs and content$")
	 public void verify_Health_and_Wellness_sub_tabs_and_content(){
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.validateHWTabsAndContent();
	 }
	 
	 @And("click on Life style Tab and life style content should display$")
	 public void click_on_Life_style_Tab_and_life_style_content_should_display(){
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.validateHWLifeStyleTab();
		 
	 }
	 
	 @And("click on Learning Tab and learning content should display$")
	 public void click_on_Learning_Tab_and_learning_content_should_display(){
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.validateHWLearningTab();
		 
	 }
	 
	 @And("click on Reward Tab and reward content should display$")
	 public void click_on_Reward_Tab_and_reward_content_should_display(){
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.validateHWRewardsTab();
		 
	 }*/

	

//	@After
//	public void tearDown() {
//		
//		WebDriver wd = (WebDriver) getLoginScenario().getBean(
//				CommonConstants.WEBDRIVER);
//		// wd.close();
//		wd.quit();
//		getLoginScenario().flushBeans();
//		
//	}

}
