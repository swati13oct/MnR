package acceptancetests.login.bluelayer;

/**
 * @author pagarwa5
 *
 */

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

	@Given("^the user is on the UHC medicare site login page$")
	public void uhc_login_page(){
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		
	}
	
	@When("^the user logs in with a registered UMP with following details in UHC site$")
	public void login_with_member(DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
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
		
		
		
		JSONObject accountHomeActualJson =  null;
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
			accountHomeActualJson = accountHomePage.accountHomeJson;
			getLoginScenario().saveBean(LoginCommonConstants.ACCOUNT_HOME_ACTUAL, accountHomeActualJson);
			
			/*Get expected data*/
			Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
			JSONObject accountHomeExpectedJson = accountHomePage.getExpectedData(expectedDataMap);
			getLoginScenario().saveBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED, accountHomeExpectedJson);
			getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
		}
		
		

		

	}
	
	@Then("^the user validates plan and member details after login in UHC site$")
	public void login_validation() {
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
	
	@Then("^the user validates temp id card pop up after login in UHC site$")
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
	
	@Given("^registered member to login in UMS site$")
	public void registered_member_UMS(DataTable memberAttributes){
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String category = memberAttributesMap.get("Member Type");

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

		getLoginScenario().saveBean(CommonConstants.CATEGORY, category);

		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);
		if(loginPage.loginWith(userName, pwd,category) instanceof TerminatedHomePage){
			TerminatedHomePage terminatedHomePage = (TerminatedHomePage) loginPage.loginWith(userName, pwd,category);
			if (terminatedHomePage != null) {
				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
				getLoginScenario().saveBean(PageConstants.TERMINATED_HOME_PAGE,terminatedHomePage);
		}
		}
		else{
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		}
		
	}
	
	 @Then("the user validate add a plan link is not displayed for albama memeber$")
	 
	 public void user_validates_addaplan_link()
	    {
		 TerminatedHomePage terminatedHomePage = ( TerminatedHomePage) getLoginScenario().getBean(PageConstants.TERMINATED_HOME_PAGE);
		 if(terminatedHomePage!=null){ 
			boolean flagValue=terminatedHomePage.validateaddaplanlink();
			if(!flagValue){
				System.out.println("add a plan link is not displayed");
				Assert.assertTrue(true);
			}else{
				System.out.println("add a plan link is displayed");
				Assert.assertTrue(false);				
			}
		}
	    }
	    
}
				


	  
