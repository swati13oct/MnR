package acceptancetests.fixedtestcases;

/**
 * @author pagarwa5
 *
 */

import gherkin.formatter.model.DataTableRow;
import pages.member.bluelayer.LoginPage;

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
import pages.member.bluelayer.*;

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
			//Assert.fail("unable to find a "+ desiredAttributes + " member");
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
		
		
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		
		}

	}
	
	@Then("^the user validates account home page for uhc$")
	public void login_validation() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		
		if(accountHomePage.validateAccountHome())
			Assert.assertTrue(true);
		else
			Assert.fail("Login failed. Error in validating the account home page");
		accountHomePage.logOut();
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
		TerminatedHomePage terminatedHomePage = (TerminatedHomePage) loginPage.loginWith(userName, pwd,category);
		if (terminatedHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.TERMINATED_HOME_PAGE,
					terminatedHomePage);
		}
		
	}
	
	
	 
	 @Then("^verify that the tabs are displayed$")
	 public void verify_that_the_tabs_are_displayed(){
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.validateTabs();
		 
	 }
	 
	 @And("^verify that links are displayed$")
	 public void verify_that_links_are_displayed(){
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 
		 accountHomePage.validatWidgetsndButtons();
	 }
	 
	 @And("^click on plan name link and my Plans-Summary page should be displayed$")
	 public void click_on_plan_name_link_and_my_Plans_Summary_page_should_be_displayed(){
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.navigateToPlanSummary();
	 }
	 
	 @And("click on back button in the browser and Home page should be displayed")
	 public void click_on_back_button_in_the_browser_and_Home_page_should_be_displayed() throws InterruptedException{
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.navigateBack();
		 accountHomePage.validateHomePage();
	 }
	 
	 @And("validate provider search not displayed for PDP and for other member, click on search for providers button and Provider search modal window should be displayed")
	 public void click_on_search_for_providers_button_and_Provider_search_modal_window_should_be_displayed() throws InterruptedException{
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 if(!accountHomePage.getPlanName().contains("PDP")){
			 accountHomePage.navigate_ProviderSearch();
			 
			 accountHomePage.navigateToHomePage();
		 } 
	 }
	 	 
	 @And("^click on Drug lookup-estimate costs button and estimate my drug costs page should be displayed$")
	 public void click_on_estimate_costs_button_and_estimate_my_drug_costs_page_should_be_displayed(){
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.navigateToEstimateCost("Individual");
	 }
	 
	 @And("^click on locate a pharmacy button and Locate a pharmacy page should be displayed$")
	 public void click_on_locate_a_pharmacy_button_and_Locate_a_pharmacy_page_should_be_displayed(){
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.navigateToPharmacyLocator();
	 }
	 
	 @And("^click on View Personal Health Record button and My Personal Health Record page should be displayed$")
	 public void click_on_View_Personal_Health_Record_button_and_My_Personal_Health_Record_page_should_be_displayed(){
		 AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.navigateToPhr();
	 }
	 
	 
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
		 
	 }
	 
	 
}
				


	  
