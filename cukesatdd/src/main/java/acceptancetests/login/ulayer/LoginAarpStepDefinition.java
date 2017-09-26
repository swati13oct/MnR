/**
 * 
 */
package acceptancetests.login.ulayer;

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
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.MultipleEmailAddressNewPage;
import pages.member.ulayer.NewEmailAddressPage;
import pages.member.ulayer.PersonalIdentityUlayerPage;
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

	@Given("^the user is on the AARP medicare site login page$")
	public void user_login_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	}
	
	@Given("^the user is on the AARP Ulayer site login page$")
	public void user_Ulayer_login_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		PersonalIdentityUlayerPage loginPage = new PersonalIdentityUlayerPage(wd);
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
			/*Assert.assertTrue(true);
			JSONObject accountHomeActualJson = accountHomePage.accountHomeJson;
			getLoginScenario().saveBean(
					LoginCommonConstants.ACCOUNT_HOME_ACTUAL,
					accountHomeActualJson);
			
			 Get expected data 
			Map<String, JSONObject> expectedDataMap = loginScenario
					.getExpectedJson(userName);
			JSONObject accountHomeExpectedJson = accountHomePage
					.getExpectedData(expectedDataMap);
			getLoginScenario().saveBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED,
					accountHomeExpectedJson);*/
	
	
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
	
	@Then("^the User clicks moves to test harness page and clicks on go to Multiple Email Address Page$")
	public void Move_To_TestHarness_and_goMultipleEmailAddress() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MultipleEmailAddressNewPage MultipleEmailPage = accountHomePage.navigateToMultipleEmailTestHarness();
		 if(MultipleEmailPage!=null){
		    	getLoginScenario().saveBean(PageConstants.MULTIPLE_EMAIL_ADDRESS,
		    			MultipleEmailPage);
				Assert.assertTrue(true);
			} else {
				Assert.fail("Multiple Email page not found");
			}

	}
	
	@Then("^the User clicks moves to test harness page and clicks on go to No Email Address Page$")
	public void Move_To_TestHarness_and_gotoNoEmailAddress() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		NewEmailAddressPage NewEmailPage = accountHomePage.navigateToNoEmailTestHarness();
		 if(NewEmailPage !=null){
		    	getLoginScenario().saveBean(PageConstants.NEW_EMAIL_ADDRESS,
		    			NewEmailPage);
				Assert.assertTrue(true);
			} else {
				Assert.fail("Multiple Email page not found");
			}

	}
	
	
	@Then("^User selects different mail option and validates the confirmation page$")
	public void EmailMultipleAddress_validation() throws InterruptedException {

		MultipleEmailAddressNewPage MEANewPage = (MultipleEmailAddressNewPage) getLoginScenario()
				.getBean(PageConstants.MULTIPLE_EMAIL_ADDRESS);
	    AccountHomePage MultipleEmailPageConfirmation = MEANewPage.SelectDifferentEmailAddress();
	    if(MultipleEmailPageConfirmation!=null){
	    	getLoginScenario().saveBean(PageConstants.MULTIPLE_EMAIL_CONFIRMATION,
	    			MultipleEmailPageConfirmation);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Multiple Email page not found");
		}
         
	}
	
	@Then("^User selects Radio button for available mail address option and validates the confirmation page$")
	public void EmailSelectOption_validation() throws InterruptedException {

		MultipleEmailAddressNewPage MEANewPage = (MultipleEmailAddressNewPage) getLoginScenario()
				.getBean(PageConstants.MULTIPLE_EMAIL_ADDRESS);
	    AccountHomePage MultipleEmailPageConfirmation = MEANewPage.SelectEmailfromOption();
	    if(MultipleEmailPageConfirmation!=null){
	    	getLoginScenario().saveBean(PageConstants.MULTIPLE_EMAIL_CONFIRMATION,
	    			MultipleEmailPageConfirmation);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Multiple Email page not found");
		}
         
	}
	
	
	
	
	@Then("^User enters new email address and validates the confirmation page$")
	public void EmailEnterNew_validation() throws InterruptedException {

		NewEmailAddressPage NEANewPage = (NewEmailAddressPage) getLoginScenario()
				.getBean(PageConstants.NEW_EMAIL_ADDRESS);
	    AccountHomePage NewEmailPageConfirmation = NEANewPage.EnterNewMail();
	    if(NewEmailPageConfirmation!=null){
	    	getLoginScenario().saveBean(PageConstants.NEW_EMAIL_ADDRESS_CONFIRMATION,
	    			NewEmailPageConfirmation);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Multiple Email page not found");
		}
         
	}
	
	
	
	@Then("^the user validates multiple email address page$")
	public void EmailMultipleAddresses_validation() throws InterruptedException {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
	    AccountHomePage MultipleEmailPage = accountHomePage.ValidateMultipleEmailAddress();
	    if(MultipleEmailPage!=null){
	    	getLoginScenario().saveBean(PageConstants.MULTIPLE_EMAIL_ADDRESS,
	    			MultipleEmailPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Multiple Email page not found");
		}
         
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

	@Then("^the user validates temp id card pop up after login in AARP site$")
		public void tempId_validation() {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			boolean tempIdValid = accountHomePage.tempIdValidation();
			if(tempIdValid){
				Assert.assertTrue(true);
			} else {
				Assert.fail("Aboutus page not found");
			}
	}
	
	@Given("^the user is on the multipleEmailAddressPage and clicks on continue$")
	public void Multiple_Email_address()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		MultipleEmailAddressNewPage loginPage = new MultipleEmailAddressNewPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		AccountHomePage accountHomePage = loginPage.ClickOnContinue();
	}
	
	@Given("^the user is on the multipleEmailAddressPage and enters invalid email address$")
	public void Invallid_Email_address() throws InterruptedException
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		MultipleEmailAddressNewPage loginPage = new MultipleEmailAddressNewPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		AccountHomePage accountHomePage = loginPage.EnterInvalidMail();
	}
	
	@Given("^the user is on the multipleEmailAddressPage and enters does not enters same email address$")
	public void NotMatching_Email_address() throws InterruptedException
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		MultipleEmailAddressNewPage loginPage = new MultipleEmailAddressNewPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		AccountHomePage accountHomePage = loginPage.ConfirmMailIssue();
	}
	

	@After
	public void tearDown() {
		
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		// wd.close();
		if(wd!=null){
			wd.quit();
		}
		getLoginScenario().flushBeans();
		
	}

}
