package acceptancetests.memberredesign.HSID;

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
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.login.AssistiveRegistrationPage;
import pages.regression.login.DeregisterPage;
import pages.regression.login.HSIDLoginPage;
import pages.regression.login.HsidRegistrationPersonalCreateAccount;
import pages.regression.login.LoginPage;

/**
 * Functionality: Benefits and Coverage page
 */

@SuppressWarnings("static-access")
public class HSIDStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@And("^login with following details logins in the member portal and validate elements$")
	public void login_with_member(DataTable memberAttributes)
			throws Exception {

		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		String planType = memberAttributesMap.get("Plan Type");
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
		if (desiredAttributes.size() > 1) {
			getLoginScenario().saveBean(LoginCommonConstants.MEMBERTYPE,
					desiredAttributes.get(1));
		}
		// note: for the team-a env, it needs a different URL for PCP and Medica users
		boolean teamSpecialCase=false;
		if ("team-a".equalsIgnoreCase(MRScenario.environment)) {
			if (planType != null) {
				if (planType.toLowerCase().contains("pcp") || planType.toLowerCase().contains("medica")) {
					teamSpecialCase=true;		
					System.out.println("This is a PCP / Medica case - need to use different URL on team-a env");
				}
			}
			if (category != null) {
				if (category.toLowerCase().contains("pcp") || category.toLowerCase().contains("medica")) {
					teamSpecialCase=true;		
					System.out.println("This is a PCP / Medica case - need to use different URL on team-a env");
				} 
			}
		}
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
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		if ("YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
			HSIDLoginPage loginPage = new HSIDLoginPage(wd);
			loginPage.validateelements();
			AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWith(userName, pwd);
			if (accountHomePage != null) {
				getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,
						accountHomePage);
				Assert.assertTrue(true);
			} else {
				Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
			}
		} else {
			if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
				LoginPage loginPage=null;
				if ("team-a".equalsIgnoreCase(MRScenario.environment)) {
					loginPage = new LoginPage(wd, teamSpecialCase);
				} else {
					loginPage = new LoginPage(wd);
				}

				AccountHomePage accountHomePage = (AccountHomePage) loginPage
						.loginWithLegacy(userName, pwd);
				if (accountHomePage != null) {
					getLoginScenario()
							.saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,
									accountHomePage);
				} else {
					Assert.fail("Login not successful...");
				}
			} else {
				LoginPage loginPage = new LoginPage(wd);
				RallyDashboardPage rallyDashboard = (RallyDashboardPage) loginPage
						.loginWithLegacy(userName, pwd);
				if (rallyDashboard != null) {
					getLoginScenario().saveBean(
							PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
				} else {
					Assert.fail("Login not successful...");
				}
			}
		}

		/*
		 * AssistiveRegistrationPage assistiveregistration =
		 * (AssistiveRegistrationPage) loginPage.doLoginWith(userName, pwd); if
		 * (assistiveregistration != null) {
		 * getLoginScenario().saveBean(PageConstantsMnR
		 * .ASSISTIVE_REGISTRATION_PAGE,assistiveregistration);
		 * Assert.assertTrue(true); } else {
		 * Assert.fail("***** Error in loading  Assistive Registration Page *****"
		 * ); }
		 */

	}

	@And("^login with following details logins in the member portal and validate elements and route to assistive flow$")
	public void login_with_memberassistive(DataTable memberAttributes)
			throws InterruptedException {
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

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		HSIDLoginPage loginPage = new HSIDLoginPage(wd);
		loginPage.validateelements();

		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = (HsidRegistrationPersonalCreateAccount) loginPage
				.doLoginWith2(userName, pwd);
		if (hsidRegistrationPersonalCreateAccount != null) {
			getLoginScenario().saveBean(
					PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT,
					hsidRegistrationPersonalCreateAccount);
			Assert.assertTrue(true);
		} else {
			Assert.fail("***** Error in loading  Assistive Registration Page *****");
		}

	}

	@And("^the user validate username autofill$")
	public void validateelementassistive() {
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = (HsidRegistrationPersonalCreateAccount) getLoginScenario()
				.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		String username = (String) getLoginScenario().getBean(
				LoginCommonConstants.USERNAME);
		hsidRegistrationPersonalCreateAccount.usernameautofill(username);
	}

	@And("^the user validate all fields on this page$")
	public void validateotherfields() {
		AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
				.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
		String username = (String) getLoginScenario().getBean(
				LoginCommonConstants.USERNAME);
		assistiveregistration.validate_allfields();

	}

	@And("^the user validate security questions option and user answer all security questions$")
	public void validatesecurityquestions(DataTable givenAttributes) {
		AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
				.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
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
	public void validatecheckboxes() {
		AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
				.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
		assistiveregistration.validate_checkboxes();

	}

	@And("^the user clicks submit button$")
	public void validatesubmitbutton() {
		AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
				.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
		assistiveregistration.validate_submitbutton();

	}

	@And("^the user enters password and confirm password field$")
	public void validatepasswordfield() {
		AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
				.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
		assistiveregistration.validate_passwordfields();
	}

	@And("^the user enters email and confirm email field$")
	public void validateemailfield() {
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
	public void i_select_record_data_base(DataTable givenAttributes)
			throws SQLException {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String firstname = memberAttributesMap.get("Firstname");
		String lastname = memberAttributesMap.get("Lastname");
		getLoginScenario().saveBean(LoginCommonConstants.Firstname, firstname);
		getLoginScenario().saveBean(LoginCommonConstants.Lastname, lastname);
		System.out.println(firstname);
		System.out.println(lastname);
		MRScenario.getRecordsFrom_mbr_table(firstname, lastname);
	}

	@And("^the user delete record from mbr_portal$")
	public void i_delete_record_data_base(DataTable givenAttributes)
			throws SQLException {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String firstname = memberAttributesMap.get("Firstname");
		String lastname = memberAttributesMap.get("Lastname");
		getLoginScenario().saveBean(LoginCommonConstants.Firstname, firstname);
		getLoginScenario().saveBean(LoginCommonConstants.Lastname, lastname);
		System.out.println(firstname);
		System.out.println(lastname);
		MRScenario.deleteRecordsFrom_mbr_prtl_table(firstname, lastname);
	}

	@And("^the user delete record from mbr$")
	public void i_delete_record_mbrtable(DataTable givenAttributes)
			throws SQLException {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String firstname = memberAttributesMap.get("Firstname");
		String lastname = memberAttributesMap.get("Lastname");
		getLoginScenario().saveBean(LoginCommonConstants.Firstname, firstname);
		getLoginScenario().saveBean(LoginCommonConstants.Lastname, lastname);
		System.out.println(firstname);
		System.out.println(lastname);
		MRScenario.deleteRecordsFrom_mbr_table(firstname, lastname);
	}

	@And("^the user delete record from extreme scale$")
	public void i_delete_record_extremescaletable(DataTable givenAttributes)
			throws SQLException {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String firstname = memberAttributesMap.get("Firstname");
		String lastname = memberAttributesMap.get("Lastname");
		getLoginScenario().saveBean(LoginCommonConstants.Firstname, firstname);
		getLoginScenario().saveBean(LoginCommonConstants.Lastname, lastname);
		System.out.println(firstname);
		System.out.println(lastname);
		MRScenario.deleteRecordsFrom_mbr_extrm_scl_dtl_table(firstname,
				lastname);
	}

	@Given("^the user deregister from M&R LDAP$")
	public void I_delete_user_from_mnrldap(DataTable givenAttributes) {
		WebDriver wd = loginScenario.getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		DeregisterPage deregisterPage = new DeregisterPage(wd);
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String username = memberAttributesMap.get("Username");
		getLoginScenario().saveBean(LoginCommonConstants.Username, username);

		System.out.println(username);

		deregisterPage.deregisterUser(username);

	}

	@Then("^I enter valid username \"([^\"]*)\" into Username field for bulk registration$")
	public void i_enter_valid_username_into_Username_field(String arg1)
			throws Throwable {
		WebDriver wd = loginScenario.getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		DeregisterPage deregisterPage = new DeregisterPage(wd);
		String username = deregisterPage.getUserName();
		username = username + arg1;// adding special symbol
		deregisterPage.setUserName(username);// setting up new user name
		// deregisterPage.enterUserName(username);

	}

	@Given("^User is on the sign-in page of medicare.uhc.com of the environment mentioned in config file$")
	public void userisonmedicaresigninpage(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String tobeappendedinURL = memberAttributesMap.get("URL");
		System.out.println(tobeappendedinURL);
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		HSIDLoginPage loginPage = new HSIDLoginPage(wd);
		System.out.println("Currently testing on URL:");
		System.out.println("https://" + MRScenario.environmentMedicare
				+ "-medicare.uhc.com/" + tobeappendedinURL);
		wd.get("https://" + MRScenario.environmentMedicare
				+ "-medicare.uhc.com/" + tobeappendedinURL);
		getLoginScenario()
				.saveBean(PageConstantsMnR.HSID_LOGIN_PAGE, loginPage);
	}

	@Given("^User is on the sign-in page of mymedicareaccount.uhc.com of the environment mentioned in config file$")
	public void userisonmymedicareaccountsigninpage(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String tobeappendedinURL = memberAttributesMap.get("URL");
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		HSIDLoginPage loginPage = new HSIDLoginPage(wd);
		System.out.println("this will be appended in the URL:  "
				+ tobeappendedinURL);
		System.out.println("Currently testing on URL:");
		System.out.println("https://" + MRScenario.environmentMedicare
				+ "-mymedicareaccount.uhc.com/" + tobeappendedinURL);
		wd.get("https://" + MRScenario.environmentMedicare
				+ "-mymedicareaccount.uhc.com/" + tobeappendedinURL);
		getLoginScenario()
				.saveBean(PageConstantsMnR.HSID_LOGIN_PAGE, loginPage);
	}

	@Then("^Iperception smiley survey is displayed after waiting for 20 seconds$")
	public void isIPerceptionSurveyDisplayed() throws Throwable {

		/*
		 * Method#1 This method can be used to call method from any other page
		 * format will be class object = new class((WebDriver)
		 * getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		 * 
		 * 
		 * /* Method#2 on top (at class level) declare this - public WebDriver
		 * driver ; format will be class object = new class(driver);
		 * object.method(driver);
		 */

		AccountHomePage cse = new AccountHomePage(
				(WebDriver) getLoginScenario().getBean(
						CommonConstants.WEBDRIVER));
		cse.checkForIPerceptionModel((WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER));

		HSIDLoginPage loginPage = (HSIDLoginPage) getLoginScenario().getBean(
				PageConstantsMnR.HSID_LOGIN_PAGE);
		loginPage.verifyIfIperceptionSmileySurveyIsDisplayed();

	}

	@Then("^User is able to successfully submit the survey$")
	public void iPerceptionSurvey() throws Throwable {

		HSIDLoginPage loginPage = (HSIDLoginPage) getLoginScenario().getBean(
				PageConstantsMnR.HSID_LOGIN_PAGE);
		loginPage.switchToIperceptionSmileySurveyAndSubmit();

	}
}