package acceptancetests.memberredesign.HSID;

import gherkin.formatter.model.DataTableRow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.bluelayer.AssistiveRegistrationPage;
import pages.member.bluelayer.HSIDLoginPage;
import pages.member.redesign.DeregisterPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.login.LoginPage;
import acceptancetests.data.CommonConstants;
//import acceptancetests.deprecated.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.login.AssistiveRegistrationPage;
import pages.regression.login.DeregisterPage;
import pages.regression.login.HSIDLoginPage;
import pages.regression.login.HsidRegistrationPersonalCreateAccount;

/**
 * Functionality: Benefits and Coverage page
 */
public class HSIDStepDefinition {

	@Autowired
	MRScenario loginScenario;

	

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
 
	


	
	@Given("^login with following details logins in the member portal and validate elements$")
	public void login_with_member(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);
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
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}
         
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		HSIDLoginPage loginPage = new HSIDLoginPage(wd);
		loginPage.validateelements();
        AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWith(userName, pwd);
		
		if (accountHomePage!= null) {
			 getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
		}
		/*AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) loginPage.doLoginWith(userName, pwd);
		if (assistiveregistration != null) {
			 getLoginScenario().saveBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE,assistiveregistration);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("***** Error in loading  Assistive Registration Page *****");
		}*/

	}
	
	
	
	@And("^login with following details logins in the member portal and validate elements and route to assistive flow$")
	public void login_with_memberassistive(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);
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
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}
         
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		HSIDLoginPage loginPage = new HSIDLoginPage(wd);
		loginPage.validateelements();
       
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount  = (HsidRegistrationPersonalCreateAccount) loginPage.doLoginWith2(userName, pwd);
		if (hsidRegistrationPersonalCreateAccount != null) {
			 getLoginScenario().saveBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT, hsidRegistrationPersonalCreateAccount);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("***** Error in loading  Assistive Registration Page *****");
		}

	}
	
	@And("^the user validate username autofill$")
	public void validateelementassistive()
	{
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = (HsidRegistrationPersonalCreateAccount) getLoginScenario().getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		String username = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		hsidRegistrationPersonalCreateAccount.usernameautofill(username);
	}
	
	@And("^the user validate all fields on this page$")
	public void validateotherfields()
	{
		AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario().getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
		getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		assistiveregistration.validate_allfields();
	
	}
	
	@And("^the user validate security questions option and user answer all security questions$")
	public void validatesecurityquestions(DataTable givenAttributes)
	{
		AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
			.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
	
     List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String option = memberAttributesMap.get("Option");
	String option1 = memberAttributesMap.get("Option1");
	String option2 = memberAttributesMap.get("Option2");
	String option3 = memberAttributesMap.get("Option3");
	getLoginScenario().saveBean(LoginCommonConstants.Option, option);
	getLoginScenario().saveBean(LoginCommonConstants.Option1, option1);
	getLoginScenario().saveBean(LoginCommonConstants.Option2, option2);
	getLoginScenario().saveBean(LoginCommonConstants.Option3, option3);
	assistiveregistration.validate_security1_select(option);
	System.out.println(option1);
	assistiveregistration.validate_security2_select(option1);
	assistiveregistration.validate_security2_ans();
	System.out.println(option2);
	assistiveregistration.validate_security3_select(option2);
	assistiveregistration.validate_security3_ans();
	System.out.println(option3);
	assistiveregistration.validate_security4_select(option3);
	assistiveregistration.validate_security4_ans();
	
	
	}
	
	@And("^the user check checkboxes$")
	public void validatecheckboxes()
	{
	AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
	.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
	assistiveregistration.validate_checkboxes();
	
}
	
	@And("^the user clicks submit button$")
	public void validatesubmitbutton()
	{
	AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
	.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
	assistiveregistration.validate_submitbutton();
	
}
	@And("^the user enters password and confirm password field$")
	public void validatepasswordfield()
	{
	AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
	.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
	assistiveregistration.validate_passwordfields();
	}
	
	@And("^the user enters email and confirm email field$")
	public void validateemailfield()
	{
	AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
	.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
	assistiveregistration.validate_emailfields();
	}
	
	

	@Given("^the user connect to DB$")
	public void i_connected_to_Provisional_data_base() {
		Map<String, String> props = new HashMap<String, String>();
		props = loginScenario.getProperties();
		loginScenario.getPDBDBConnection(props);
	}
	
	@And("^the user select record from database$")
	public void i_select_record_data_base(DataTable givenAttributes) throws SQLException {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String firstname = memberAttributesMap.get("Firstname");
		String lastname = memberAttributesMap.get("Lastname");
		getLoginScenario().saveBean(LoginCommonConstants.Firstname, firstname);
		getLoginScenario().saveBean(LoginCommonConstants.Lastname, lastname);
		System.out.println(firstname);
		System.out.println(lastname);
		MRScenario.getRecordsFrom_mbr_table(firstname,lastname);
	}
	
	@And("^the user delete record from mbr_portal$")
	public void i_delete_record_data_base(DataTable givenAttributes) throws SQLException {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String firstname = memberAttributesMap.get("Firstname");
		String lastname = memberAttributesMap.get("Lastname");
		getLoginScenario().saveBean(LoginCommonConstants.Firstname, firstname);
		getLoginScenario().saveBean(LoginCommonConstants.Lastname, lastname);
		System.out.println(firstname);
		System.out.println(lastname);
		MRScenario.deleteRecordsFrom_mbr_prtl_table(firstname,lastname);
	}
	
	@And("^the user delete record from mbr$")
	public void i_delete_record_mbrtable(DataTable givenAttributes) throws SQLException {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String firstname = memberAttributesMap.get("Firstname");
		String lastname = memberAttributesMap.get("Lastname");
		getLoginScenario().saveBean(LoginCommonConstants.Firstname, firstname);
		getLoginScenario().saveBean(LoginCommonConstants.Lastname, lastname);
		System.out.println(firstname);
		System.out.println(lastname);
		MRScenario.deleteRecordsFrom_mbr_table(firstname,lastname);
	}
	
	@And("^the user delete record from extreme scale$")
	public void i_delete_record_extremescaletable(DataTable givenAttributes) throws SQLException {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String firstname = memberAttributesMap.get("Firstname");
		String lastname = memberAttributesMap.get("Lastname");
		getLoginScenario().saveBean(LoginCommonConstants.Firstname, firstname);
		getLoginScenario().saveBean(LoginCommonConstants.Lastname, lastname);
		System.out.println(firstname);
		System.out.println(lastname);
		MRScenario.deleteRecordsFrom_mbr_extrm_scl_dtl_table(firstname,lastname);
	}
	
	@Given("^the user deregister from M&R LDAP$")
	public void I_delete_user_from_mnrldap(DataTable givenAttributes)
	{
		WebDriver wd = loginScenario.getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		DeregisterPage deregisterPage = new DeregisterPage(wd);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String username = memberAttributesMap.get("Username");
		getLoginScenario().saveBean(LoginCommonConstants.Username, username);
		
		System.out.println(username);

		deregisterPage.deregisterUser(username);
		
	}
	
	@Then("^I enter valid username \"([^\"]*)\" into Username field for bulk registration$")
	public void i_enter_valid_username_into_Username_field(String arg1) throws Throwable {
		WebDriver wd = loginScenario.getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		DeregisterPage deregisterPage = new DeregisterPage(wd);
		String username=deregisterPage.getUserName();		
		username=username+arg1;// adding special symbol 		
		deregisterPage.setUserName(username);// setting up new user name				
		//deregisterPage.enterUserName(username);
		
	}
	

	
}