package acceptancetests.memberredesign.HSID;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
//import acceptancetests.deprecated.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;

import pages.memberrdesignVBF.RallyDashboardPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.deeplinkPages.ClaimsDeeplinkLoginPage;
import pages.regression.deeplinkPages.OfflineProd_PharmacynPrescriptionLoginPage;
import pages.regression.deeplinkPages.OfflineProd_VirtualVisitDeeplinkLoginPage;
import pages.regression.deeplinkPages.PaymentsDeeplinkLoginPage;
import pages.regression.deeplinkPages.PharmacyDeeplinkLoginPage;
import pages.regression.deeplinkPages.Prod_VirtualVisitDeeplinkLoginPage;
import pages.regression.deeplinkPages.VirtualVisitDeeplinkLoginPage;
import pages.regression.deeplinkPages.aarpChatAgentLogin;
import pages.regression.deeplinkPages.accountsProfileDeeplinkLoginPage;
import pages.regression.deeplinkPages.coverageandBenefitsDeeplinkLoginPage;
import pages.regression.deeplinkPages.eobDeeplinkLoginPage;
import pages.regression.deeplinkPages.healthwellnessDeepLinkLoginPage;
import pages.regression.deeplinkPages.healthwellnessDeepLinkLoginPageSHIP;
import pages.regression.deeplinkPages.myDocumentsDeeplinkLoginPage;
import pages.regression.deeplinkPages.myDocumentsEdeliveryDeeplinkLoginPage;
import pages.regression.footer.FooterPage;
import pages.regression.healthandwellness.HealthAndWellnessPage;
import pages.regression.login.AssistiveRegistrationPage;
import pages.regression.login.DeregisterPage;
import pages.regression.login.HSIDLoginPage;
import pages.regression.login.HsidRegistrationPersonalCreateAccount;
import pages.regression.login.LoginPage;
import pages.regression.myDocumentsPage.MyDocumentsPage;
import pages.regression.planDocumentsAndResources.PlanDocumentsAndResourcesPage;
import pages.regression.testharness.TestHarness;

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
		System.out.println("******the user connect to DB*****");
//		Map<String, String> props = new HashMap<String, String>();
		//props = loginScenario.getProperties();	
		loginScenario.getPDBDBConnection();
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
		System.out.println("*****the user delete record from mbr_portal******");
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
		System.out.println("*****the user delete record from mbr*****");
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
		System.out.println("*****the user delete record from extreme scale*****");
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
	
	//----------- updated to handle microapp
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
		getLoginScenario().saveBean(LoginCommonConstants.CATOGERY,category);
		String planType = memberAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(LoginCommonConstants.PLANTYPE,planType);
		String testDataType = memberAttributesMap.get("Claim System");
		String userSelection = memberAttributesMap.get("User Selection");
			
		//note: use this to determine if need to validate footer on sign-in page
		//note: after obtaining the value, remove it so it will not look for it on csv
		String validateFooter = memberAttributesMap.get("Validate Footer");
		memberAttributesMap.remove("Validate Footer");
		String speedup = memberAttributesMap.get("Speed Up");
		memberAttributesMap.remove("Speed Up");

		//note: use the Member Type field to store the user info selection option from MicroApp testharness sign-in page
		//note: if run on team-a, then the user selection is for the dropdown option
		//note: if run on stage or stage-testharness, then ignore the user selection field
		String useDropdown=System.getProperty("useDropdown");
		boolean testHarnessUseDropdown=false;
		if (useDropdown==null) 
			System.out.println("use UUID for sign-in");
		else {
			if (useDropdown.equalsIgnoreCase("YES")) { //note: need to do this so the same script can be run on stage
				if (MRScenario.environment.contains("team-atest") && (userSelection!=null)) {
					testHarnessUseDropdown = true;
					System.out.println("useDropdown=YES and env is team-atest, will use dropdown for sign-in");
				} else {
					System.out.println("useDropdown=YES but this is either not team-atest env or feature file has no userSelection field, so will default back to use UUID for sign-in");
				}
			} else 		
				System.out.println("use UUID for sign-in");
		}

		if (!MRScenario.environment.contains("team-atest")) { //note: need to do this so the same script can be run on stage
		 	userSelection = category;
		} 
	 	memberAttributesMap.remove("User Selection");
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
		//note: to be able to run for other team env, need to update the if condition. not sure if others want it so comment out for now
		//note: if (MRScenario.environment.toLowerCase().contains("team-")) {
		if ((MRScenario.environment.contains("team-a"))||(MRScenario.environment.contains("team-h"))) {
			if ((planType != null) && (category == null)) { //note: input has planType only
				if (planType.toLowerCase().contains("pcp") || (planType.toLowerCase().contains("medica") && !planType.toLowerCase().contains("medicare supplement"))) {
					teamSpecialCase=true;		
					System.out.println("1 - This is a PCP / Medica case - need to use different URL on "+MRScenario.environment+" env");
				}
			} else if ((planType == null) && (category != null)) { //note: input has memberType only
				if (category.toLowerCase().contains("pcp") || (category.toLowerCase().contains("medica") && !category.toLowerCase().contains("medicare supplement"))) {
					teamSpecialCase=true;		
					System.out.println("2 - This is a PCP / Medica case - need to use different URL on "+MRScenario.environment+" env");
				}
			} else if ((planType != null) && (category != null)) { //note: input has both planType and memberType
				if (planType.toLowerCase().contains("pcp") || (planType.toLowerCase().contains("medica") && !planType.toLowerCase().contains("medicare supplement"))
						|| category.toLowerCase().contains("pcp") || (category.toLowerCase().contains("medica") && !category.toLowerCase().contains("medicare supplement"))
						) {
					teamSpecialCase=true;		
					System.out.println("3 - This is a PCP / Medica case - need to use different URL on "+MRScenario.environment+" env");
				}
			}
		}
		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);
		String userName = null;
		String pwd = null;
		Assert.assertTrue("unable to find a " + desiredAttributes + " member. Member Type data could not be setup !!! ", loginCreds != null);
		userName = loginCreds.get("user");
		pwd = loginCreds.get("pwd");
		System.out.println("User is..." + userName);
		System.out.println("Password is..." + pwd);
		//note: for team-a microapp env, the username is the userselection
		getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);

		WebDriver wd = getLoginScenario().getWebDriverNew();
		if (speedup!=null && speedup.equalsIgnoreCase("true"))
			wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		if ("YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)) { //note: isHSIDCompatible=yes then only path is to dashboard
			HSIDLoginPage loginPage = new HSIDLoginPage(wd);

			if (validateFooter!=null && validateFooter.equalsIgnoreCase("yes")) {
				loginPage.validateFooter();
				System.out.println("Finished validating sign-in page footer");
			}

			if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
				TestHarness testHarnessPage=null;
					testHarnessPage = (TestHarness) loginPage.doLoginWith(userName, pwd);
				Assert.assertTrue("PROBLEM - Login not successful...", testHarnessPage != null);
				getLoginScenario().saveBean(PageConstantsMnR.TEST_HARNESS_PAGE, testHarnessPage);
				return;
			}
			AccountHomePage accountHomePage=null;
			try {
				accountHomePage = (AccountHomePage) loginPage.doLoginWith(userName, pwd);
			} catch (Exception ae) {
				System.out.println("Exception: "+ae);
				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					Assert.assertTrue("***** Error in loading  Redesign Account Landing Page ***** - Got Exception. "+ae.getMessage(), false);
				else
					Assert.assertTrue("***** Error in loading  Redesign Account Landing Page ***** username: "+userName+" - Got Exception. "+ae.getMessage(), false);
			}
			
			if (accountHomePage != null) {
				getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
			} else {  
				try {
					WebElement sorry=wd.findElement(By.xpath("//h1[@translate='INTERNAL_ERROR_SORRY']")); 
					Assert.assertTrue("***** Error in loading Redesign Account Landing Page ***** Got error for 'Sorry. it's not you, it's us'", !sorry.isDisplayed());
				} catch (Exception e) {}
				try { //check to see if it has something went wrong eeror
					WebElement wentWrong=wd.findElement(By.xpath("//h1[contains(text(),'Something went wrong')]"));
					Assert.assertTrue("***** Error in loading Redesign Account Landing Page ***** Got error for 'Something went wrong'", !wentWrong.isDisplayed());
				} catch (Exception e) {}
			}
		} else { //note: isHSIDCompatible=no then go to either dashboard or testharness
			if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
				LoginPage loginPage=null;
				//note: to be able to run on other team env will need to update if condition, not sure if others want it so comment it for now
				//note: if (MRScenario.environment.toLowerCase().contains("team-")) {
				if ((MRScenario.environment.contains("team-a"))||(MRScenario.environment.contains("team-h")) || MRScenario.environment.contains("team-voc")) {
					loginPage = new LoginPage(wd, teamSpecialCase);
				} else {
					loginPage = new LoginPage(wd);
				}
				if (validateFooter!=null && validateFooter.equalsIgnoreCase("yes")) {
					loginPage.validateFooter();
					System.out.println("Finished validating sign-in page footer");
				}
				
				TestHarness testHarnessPage=null;
				try {
					if (testHarnessUseDropdown) {
						testHarnessPage = (TestHarness) loginPage.loginWithLegacy(userName, pwd, userSelection, testHarnessUseDropdown);
						if (MRScenario.environment.contains("team-a") && (userSelection !=null)) {
						 	getLoginScenario().saveBean(LoginCommonConstants.USERNAME, "use dropdown " + userSelection);
						}
					} else {
						testHarnessPage = (TestHarness) loginPage.loginWithLegacy(userName, pwd);
					}
				} catch (UnhandledAlertException ae) {
					System.out.println("Exception: "+ae);
					Assert.assertTrue("***** Error in loading  Redesign Account Landing Page ***** Got Alert text : There was an error while processing login", false);
				}
				Assert.assertTrue("PROBLEM - Login not successful...",testHarnessPage != null);
				getLoginScenario().saveBean(PageConstantsMnR.TEST_HARNESS_PAGE,testHarnessPage);
			} else {
				LoginPage loginPage = new LoginPage(wd);
				RallyDashboardPage rallyDashboard=null;
				try {
					rallyDashboard = (RallyDashboardPage) loginPage.loginWithLegacy(userName, pwd);
				} catch (UnhandledAlertException ae) {
					System.out.println("Exception: "+ae);
					Assert.assertTrue("***** Error in loading  Redesign Account Landing Page ***** Got Alert text : There was an error while processing login", false);
				}
				Assert.assertTrue("PROBLEM - Login not successful...",rallyDashboard != null);
				getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
			}
		}
	}
	
	@And("^login with a deeplink in the member portal and validate elements$")
	public void login_with_deeplink(DataTable memberAttributes)
			throws Exception {

		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String category = memberAttributesMap.get("Member Type");
		getLoginScenario().saveBean(LoginCommonConstants.CATOGERY,category);
		String planType = memberAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(LoginCommonConstants.PLANTYPE,planType);
		String deepLinkUrl = memberAttributesMap.get("Deeplink");
		getLoginScenario().saveBean(LoginCommonConstants.DEEPLINK,deepLinkUrl);

		String speedup = memberAttributesMap.get("Speed Up");
		memberAttributesMap.remove("Speed Up");

	    //----- note: these parameters won't be in csv, take them out of memberAttributesMap before searching csv
	 	memberAttributesMap.remove("User Selection");
	 	memberAttributesMap.remove("Deeplink");
	 	//------------
	 	
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
		
		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);
		String userName = null;
		String pwd = null;
		Assert.assertTrue("unable to find a " + desiredAttributes + " member. Member Type data could not be setup !!! ", loginCreds != null);
		userName = loginCreds.get("user");
		pwd = loginCreds.get("pwd");
		System.out.println("User is..." + userName);
		System.out.println("Password is..." + pwd);

		getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		WebDriver wd = getLoginScenario().getWebDriverNew();
		if (speedup!=null && speedup.equalsIgnoreCase("true"))
			wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		HSIDLoginPage loginPage = new HSIDLoginPage(wd, deepLinkUrl);
		
		try {
			if (deepLinkUrl.contains("my-documents")) {
				MyDocumentsPage	myDocumentsPage=null;
				myDocumentsPage =  (MyDocumentsPage) loginPage.doLoginWith(userName, pwd);
				Assert.assertTrue("PROBLEM - Login not successful...", myDocumentsPage != null);
				getLoginScenario().saveBean(PageConstantsMnR.My_Documents_PAGE,myDocumentsPage);
			} else if (deepLinkUrl.contains("rewards/program-overview")) {
				AccountHomePage accountHomePage=null;
				accountHomePage =  (AccountHomePage) loginPage.doLoginWith(userName, pwd);
				Assert.assertTrue("PROBLEM - Login not successful...", accountHomePage != null);
				getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			} else if (deepLinkUrl.contains("member/claims.html")) {
				ClaimsSummaryPage claimsSummaryPage=null;
				claimsSummaryPage =  (ClaimsSummaryPage) loginPage.doLoginWith(userName, pwd);
				Assert.assertTrue("PROBLEM - Login not successful...", claimsSummaryPage != null);
				getLoginScenario().saveBean(PageConstantsMnR.CLAIM_SUMMARY_PAGE,claimsSummaryPage);
			} else {
				Assert.assertTrue("PROBLEM - need to code behavior for deeplink='"+deepLinkUrl+"'", false);
			}
		} catch (UnhandledAlertException ae) {
			System.out.println("Exception: "+ae);
			Assert.assertTrue("PROBLEM - ***** Error in loading  Member Account Landing Page with deeplink '"+deepLinkUrl+"' ***** username: "+userName+" - Got Alert error", false);
		} 
		
	}	

	public static Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@Given("^feature security flag must set to true when testing on test env$")
	public void checkSecurityFlag(DataTable memberAttributes) {
		if (MRScenario.environment.contains("team")) {
			System.out.println("SKIP security test for team env (doesn't matter) and offline/online-prod (is through memAuth access so it doesn't matter)");
			return;
		}
		boolean useStage3=false;
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String feature=memberAttributesMap.get("Feature");
		
		if (!feature.equals("ClaimsMicroApp")
				&& !feature.equals("UCPProfileAndPreferences")
				&& !feature.equals("UCPPlanDocuments")
				&& !feature.equals("UCPMyDocuments")
				&& !feature.equals("UCPHealthWellness")
				&& !feature.equals("UCPBenefits")
				&& !feature.equals("UCPEob")
				&& !feature.equals("UCPOrderPlanMaterials")
				) {
			Assert.assertTrue("PROBLEM - ATDD code doesn't support security flag check for feature '"+feature+"' yet or make sure it's spelled correctly", false);
		}
		
		System.out.println("feature="+feature);
		String envDomain="http://apsrs7260:8080";
		if (useStage3) { //note: this is for if stage ever switch to stage3 again
			if (feature.equals("ClaimsMicroApp")) {
				envDomain="http://ucp-claims-mnr-ucp-stage-3.ocp-ctc-dmz-stg.optum.com";
			} else if (feature.equals("UCPEob")) {
				envDomain="http://ucp-eob-mnr-ucp-stage-3.ocp-ctc-dmz-stg.optum.com";
			} else if (feature.equals("UCPHealthWellness")) {
				envDomain="http://ucp-health-wellness-mnr-ucp-stage-3.ocp-ctc-dmz-stg.optum.com";
			} else if (feature.equals("UCPBenefits")) {
				envDomain="http://ucp-benefits-mnr-ucp-stage-3.ocp-ctc-dmz-stg.optum.com";
			} else if (feature.equals("UCPPlanDocuments")) {
				envDomain="http://ucp-plan-documents-mnr-ucp-stage-3.ocp-ctc-dmz-stg.optum.com";
			} else if (feature.equals("UCPProfileAndPreferences")) {
				envDomain="http://ucp-profile-preferences-mnr-ucp-stage-3.ocp-ctc-dmz-stg.optum.com";
			} else if (feature.equals("UCPOrderPlanMaterials")) {
				envDomain="http://ucp-order-plan-materials-mnr-ucp-stage-3.ocp-ctc-dmz-stg.optum.com";
			} else if (feature.equals("UCPMyDocuments")) {
				envDomain="http://ucp-mydocuments-mnr-ucp-stage-3.ocp-ctc-dmz-stg.optum.com";
			}
		}
		MRScenario m=new MRScenario();
		WebDriver d=m.getWebDriverNew();
		d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		if (MRScenario.environment.contains("stage")) {
			//note: for stage, only check 1 server
			checkEnableSecurityPerServer(d, envDomain, feature);
			
		} else if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) {
			//note: offline/online-prod servers will keep switching between release
			//note: it's hard to figure out at run time which server to use so just check for both
			//note: in theory,both should always be true anyway
			envDomain="http://apsrp04762:8080";
			checkEnableSecurityPerServer(d, envDomain, feature);

			envDomain="http://apsrp04763:8080";
			checkEnableSecurityPerServer(d, envDomain, feature);
			
		}
		d.quit();
		
	}
	
	public void checkEnableSecurityPerServer(WebDriver d, String envDomain, String feature) {
		String configPgUrl=envDomain+"/"+feature+"/wsConfig";
		System.out.println("Config page URL="+configPgUrl);

		d.get(configPgUrl);
		CommonUtility.checkPageIsReady(d);
		try {
			String securityFlagXpath="//td[text()='enableSecurity']/following-sibling::td";
			WebElement e=d.findElement(By.xpath(securityFlagXpath));
			CommonUtility.waitForPageLoad(d, e, 5);
			if (e.isDisplayed()) {
				System.out.println("Element '"+e.toString()+"' found!!!!");
				String value=e.getText();
				if (value.equalsIgnoreCase("false")) {
					if (MRScenario.environment.toLowerCase().contains("stage") 
							|| MRScenario.environment.equalsIgnoreCase("offline") 
							|| MRScenario.environment.equalsIgnoreCase("prod")) 
						Assert.assertTrue("PROBLEM - stage environment should have featire '"+feature+"' security flag = true, right now it is set to "+value+" | configPgUrl="+configPgUrl+", stopping all tests now. | saurcelab session="+MRScenario.returnJobURL(), false);
					else
						System.out.println("feature '"+feature+"' security flag is false on env '"+MRScenario.environment+"' configPgUrl="+configPgUrl+", not on stage, okay to move on...");
				} else {
					System.out.println("feature '"+feature+"' security flag is true on env '"+MRScenario.environment+"' configPgUrl="+configPgUrl+", okay to move on...");
				}
			} else {
				Assert.assertTrue("PROBLEM - unable to locate security flag in the config URL='"+configPgUrl+"' page, stopping all tests now. | saurcelab session="+MRScenario.returnJobURL(), false);
			}
		} catch (Exception e) {
			if (MRScenario.environment.toLowerCase().contains("stage") 
					|| MRScenario.environment.toLowerCase().equalsIgnoreCase("offline") 
					|| MRScenario.environment.toLowerCase().equalsIgnoreCase("prod")) {
				e.printStackTrace();
				Assert.assertTrue("PROBLEM - unable to locate security flag in the config URL='"+configPgUrl+"' page, "
						+ "stopping all tests now. | saurcelab session="+MRScenario.returnJobURL(), false);
			} else {
				System.out.println("unable to locate security flag in the config URL='"+configPgUrl+"' page but also not testing on stage/offline-prod/online-prod, okay to move on...");
			}
		}
	}
	
/** 
	 * @todo :member lands on payments deep link
	 */
	@Given("^member lands on the payment deeplink page$")
	public void the_user_is_onPayments_deeplink_Page() throws InterruptedException{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		PaymentsDeeplinkLoginPage paymentsDeeplinkLoginPage = new PaymentsDeeplinkLoginPage(wd);
		paymentsDeeplinkLoginPage.navigateToLoginURL();
		getLoginScenario().saveBean(PageConstants.STAGE_PAYMENT_DEEPLINK_lOGIN_PAGE,paymentsDeeplinkLoginPage );	
	}	
	
	@Given("^user login with payment Overview link$")
	public void user_login_with_payment_Overview_link() throws InterruptedException{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		PaymentsDeeplinkLoginPage paymentsDeeplinkLoginPage = new PaymentsDeeplinkLoginPage(wd);
		paymentsDeeplinkLoginPage.navigateToLoginOverviewURL();
		getLoginScenario().saveBean(PageConstants.STAGE_PAYMENT_DEEPLINK_lOGIN_PAGE,paymentsDeeplinkLoginPage );	
	}
	
	@Given("^Member login with payment Overview-new link$")
	public void Member_login_with_payment_Overview_New_link() throws InterruptedException{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		PaymentsDeeplinkLoginPage paymentsDeeplinkLoginPage = new PaymentsDeeplinkLoginPage(wd);
		paymentsDeeplinkLoginPage.navigateToLoginOverviewNewURL();
		getLoginScenario().saveBean(PageConstants.STAGE_PAYMENT_DEEPLINK_lOGIN_PAGE,paymentsDeeplinkLoginPage );	
	}
	/** 
	 * @todo :member lands on claims deep link
	 */
	@Given("^member lands on the claims deeplink page$")
	public void the_user_is_Onclaims_deeplink_Page() throws InterruptedException{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		ClaimsDeeplinkLoginPage claimsDeeplinkLoginPage = new ClaimsDeeplinkLoginPage(wd);
		claimsDeeplinkLoginPage.navigateToLoginURL();
		getLoginScenario().saveBean(PageConstants.STAGE_CLAIMS_DEEPLINK_lOGIN_PAGE,claimsDeeplinkLoginPage );	
	}
	/** 
	 * @todo :deep link login page elements validate  
	 */
	@And("^the payments deeplink page is displayed with all the fields$")
	public void paymentdeeplink_pageis_displayed(){
		PaymentsDeeplinkLoginPage PaymentsDeeplinkLoginPage = (PaymentsDeeplinkLoginPage) loginScenario.getBean(PageConstants.STAGE_PAYMENT_DEEPLINK_lOGIN_PAGE);
		PaymentsDeeplinkLoginPage.validatePageElements();
	} 
	/** 
	 * @todo :on the payments deep link page member enters login credentials
	 */
	@Given("^on payment deeplink page I enter the member details and click continue$")
	public void the_user_is_on_payments_deeplink_page(DataTable givenAttributes) throws InterruptedException{
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String username = memberAttributesMap.get("User Name");
		String password  = memberAttributesMap.get("Password");
		System.out.println("User name : "+username );
		PaymentsDeeplinkLoginPage paymentsDeeplinkLoginPage = (PaymentsDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_PAYMENT_DEEPLINK_lOGIN_PAGE);
		Thread.sleep(5000);
		System.out.println("Title of new page : "+paymentsDeeplinkLoginPage.getTitle());
		paymentsDeeplinkLoginPage.enterusername(username);
		paymentsDeeplinkLoginPage.enterpassword(password);	
		paymentsDeeplinkLoginPage.clickSubmit();
	}
	/** 
	 * @todo :member lands on payments deep link page 
	 */
	 @Given("^user is navigated to the paymentDeeplink page$") 
	 public void user_navigatedTo_payment_Deeplink_page() throws InterruptedException{
		
		 PaymentsDeeplinkLoginPage paymentsDeeplinkLoginPage = (PaymentsDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_PAYMENT_DEEPLINK_lOGIN_PAGE);
	     Thread.sleep(3000);
    	 paymentsDeeplinkLoginPage.validatePaymentsPage();
	}
	 /** 
		 * @todo :deep link login page elements validate  
		 */
		@And("^the calims deeplink page is displayed with all the fields$")
		public void claimsdeeplink_pageis_displayed(){
			ClaimsDeeplinkLoginPage claimsDeeplinkLoginPage = (ClaimsDeeplinkLoginPage) loginScenario.getBean(PageConstants.STAGE_CLAIMS_DEEPLINK_lOGIN_PAGE);
			claimsDeeplinkLoginPage.validatePageElements();
		} 
		/** 
		 * @todo :on the claims deep link page member enters login credentials 
		 */
		@Given("^on claims deeplink page I enter the member details and click continue$")
		public void the_user_is_on_claims_deeplink_page(DataTable givenAttributes) throws InterruptedException{
			/* Reading the given attribute from feature file */
			List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}

			String username = memberAttributesMap.get("User Name");
			String password  = memberAttributesMap.get("Password");
			System.out.println("User name : "+username );
			ClaimsDeeplinkLoginPage ClaimsDeeplinkLoginPage = (ClaimsDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_CLAIMS_DEEPLINK_lOGIN_PAGE);
			Thread.sleep(5000);
			System.out.println("Title of new page : "+ClaimsDeeplinkLoginPage.getTitle());
			ClaimsDeeplinkLoginPage.enterusername(username);
			ClaimsDeeplinkLoginPage.enterpassword(password);	
			ClaimsDeeplinkLoginPage.clickSubmit();
		}
		/** 
		 * @todo :member lands on claims deep link page 
		 */
		 @Given("^user is navigated to the claimsDeeplink page$") 
		 public void user_navigatedTo_claims_Deeplink_page() throws InterruptedException{
			
			 ClaimsDeeplinkLoginPage ClaimsDeeplinkLoginPage = (ClaimsDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_CLAIMS_DEEPLINK_lOGIN_PAGE);
		     Thread.sleep(3000);
		     ClaimsDeeplinkLoginPage.validateClaimsPage();
		}
		 /** 
			 * @todo :member lands on eob deep link
			 */
			@Given("^member lands on the eob deeplink page$")
			public void the_user_is_on_eob_deeplink_Page() throws InterruptedException{
				WebDriver wd = getLoginScenario().getWebDriver();
				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
				eobDeeplinkLoginPage eobDeeplinkLoginPage = new eobDeeplinkLoginPage(wd);
				eobDeeplinkLoginPage.navigateToLoginURL();
				getLoginScenario().saveBean(PageConstants.STAGE_EOB_DEEPLINK_lOGIN_PAGE,eobDeeplinkLoginPage );	
			}
			/** 
			 * @todo :deep link login page elements validate  
			 */
			@And("^the eob deeplink page is displayed with all the fields$")
			public void eobdeeplink_pageis_displayed(){
				eobDeeplinkLoginPage eobDeeplinkLoginPage = (eobDeeplinkLoginPage) loginScenario.getBean(PageConstants.STAGE_EOB_DEEPLINK_lOGIN_PAGE);
				eobDeeplinkLoginPage.validatePageElements();
			} 
			/** 
			 * @todo :on the eob deep link page member enters login credentials 
			 */
			@Given("^on eob deeplink page I enter the member details and click continue$")
			public void the_user_is_on_eob_deeplink_page(DataTable givenAttributes) throws InterruptedException{
				/* Reading the given attribute from feature file */
				List<DataTableRow> memberAttributesRow = givenAttributes
						.getGherkinRows();
				Map<String, String> memberAttributesMap = new HashMap<String, String>();
				for (int i = 0; i < memberAttributesRow.size(); i++) {

					memberAttributesMap.put(memberAttributesRow.get(i).getCells()
							.get(0), memberAttributesRow.get(i).getCells().get(1));
				}

				String username = memberAttributesMap.get("User Name");
				String password  = memberAttributesMap.get("Password");
				System.out.println("User name : "+username );
				eobDeeplinkLoginPage eobDeeplinkLoginPage = (eobDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_EOB_DEEPLINK_lOGIN_PAGE);
				Thread.sleep(5000);
				System.out.println("Title of new page : "+eobDeeplinkLoginPage.getTitle());
				eobDeeplinkLoginPage.enterusername(username);
				eobDeeplinkLoginPage.enterpassword(password);	
				eobDeeplinkLoginPage.clickSubmit();
			}
			/** 
			 * @todo :member lands on eob deep link page 
			 */
			 @Given("^user is navigated to the eobDeeplink page$") 
			 public void user_navigatedTo_eob_Deeplink_page() throws InterruptedException{
				
				 eobDeeplinkLoginPage eobDeeplinkLoginPage = (eobDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_EOB_DEEPLINK_lOGIN_PAGE);
			     Thread.sleep(3000);
			     eobDeeplinkLoginPage.validateEobPage();
			}
			 /** 
				 * @todo :member lands on accountProfile deep link
				 */
				@Given("^member lands on the accountProfile deeplink page$")
				public void the_user_is_on_accountProfile_deeplink_Page() throws InterruptedException{
					WebDriver wd = getLoginScenario().getWebDriver();
					getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
					accountsProfileDeeplinkLoginPage accountsProfileDeeplinkLoginPage = new accountsProfileDeeplinkLoginPage(wd);
					accountsProfileDeeplinkLoginPage.navigateToLoginURL();
					getLoginScenario().saveBean(PageConstants.STAGE_AccountProfile_DEEPLINK_lOGIN_PAGE,accountsProfileDeeplinkLoginPage );	
				}
				/** 
				 * @todo :deep link login page elements validate  
				 */
				@And("^the accountProfile deeplink page is displayed with all the fields$")
				public void accountProfile_pageis_displayed(){
					accountsProfileDeeplinkLoginPage accountsProfileDeeplinkLoginPage = (accountsProfileDeeplinkLoginPage) loginScenario.getBean(PageConstants.STAGE_AccountProfile_DEEPLINK_lOGIN_PAGE);
					accountsProfileDeeplinkLoginPage.validatePageElements();
				}  
				/** 
				 * @todo :on the accountProfile deep link page member enters login credentials 
				 */
				@Given("^on accountProfile deeplink page I enter the member details and click continue$")
				public void the_user_is_on_accountProfile_deeplink_page(DataTable givenAttributes) throws InterruptedException{
					/* Reading the given attribute from feature file */
					List<DataTableRow> memberAttributesRow = givenAttributes
							.getGherkinRows();
					Map<String, String> memberAttributesMap = new HashMap<String, String>();
					for (int i = 0; i < memberAttributesRow.size(); i++) {

						memberAttributesMap.put(memberAttributesRow.get(i).getCells()
								.get(0), memberAttributesRow.get(i).getCells().get(1));
					}

					String username = memberAttributesMap.get("User Name");
					String password  = memberAttributesMap.get("Password");
					System.out.println("User name : "+username );
					accountsProfileDeeplinkLoginPage accountsProfileDeeplinkLoginPage = (accountsProfileDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_AccountProfile_DEEPLINK_lOGIN_PAGE);
					Thread.sleep(5000);
					System.out.println("Title of new page : "+accountsProfileDeeplinkLoginPage.getTitle());
					accountsProfileDeeplinkLoginPage.enterusername(username);
					accountsProfileDeeplinkLoginPage.enterpassword(password);	
					accountsProfileDeeplinkLoginPage.clickSubmit();
				}
				/** 
				 * @todo :member lands on accountProfile deep link page 
				 */
				 @Given("^user is navigated to the accountProfile deep link page$") 
				 public void user_navigatedTo_accountProfile_Deeplink_page() throws InterruptedException{
					
					 accountsProfileDeeplinkLoginPage accountsProfileDeeplinkLoginPage = (accountsProfileDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_AccountProfile_DEEPLINK_lOGIN_PAGE);
				     Thread.sleep(3000);
				     accountsProfileDeeplinkLoginPage.validateAccountProfilePage();
				}
				 
				 /** 
					 * @todo :member lands on coverageandBenefits deep link
					 */
					@Given("^member lands on the coverageandBenefits deeplink page$")
					public void the_user_is_on_coverageandBenefits_deeplink_Page() throws InterruptedException{
						WebDriver wd = getLoginScenario().getWebDriver();
						getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
						coverageandBenefitsDeeplinkLoginPage coverageandBenefitsDeeplinkLoginPage = new coverageandBenefitsDeeplinkLoginPage(wd);
						coverageandBenefitsDeeplinkLoginPage.navigateToLoginURL();
						getLoginScenario().saveBean(PageConstants.STAGE_CoverageBenefits_DEEPLINK_lOGIN_PAGE,coverageandBenefitsDeeplinkLoginPage );	
					}
					/** 
					 * @todo :deep link login page elements validate  
					 */
					@And("^the coverageandBenefits deeplink page is displayed with all the fields$")
					public void coverageandBenefits_pageis_displayed(){
						coverageandBenefitsDeeplinkLoginPage coverageandBenefitsDeeplinkLoginPage = (coverageandBenefitsDeeplinkLoginPage) loginScenario.getBean(PageConstants.STAGE_CoverageBenefits_DEEPLINK_lOGIN_PAGE);
						coverageandBenefitsDeeplinkLoginPage.validatePageElements();
					}  
					/** 
					 * @todo :on the coverageandBenefits deep link page member enters login credentials 
					 */
					@Given("^on coverageandBenefits deeplink page I enter the member details and click continue$")
					public void the_user_is_on_coverageandBenefits_deeplink_page(DataTable givenAttributes) throws InterruptedException{
						/* Reading the given attribute from feature file */
						List<DataTableRow> memberAttributesRow = givenAttributes
								.getGherkinRows();
						Map<String, String> memberAttributesMap = new HashMap<String, String>();
						for (int i = 0; i < memberAttributesRow.size(); i++) {

							memberAttributesMap.put(memberAttributesRow.get(i).getCells()
									.get(0), memberAttributesRow.get(i).getCells().get(1));
						}

						String username = memberAttributesMap.get("User Name");
						String password  = memberAttributesMap.get("Password");
						System.out.println("User name : "+username );
						coverageandBenefitsDeeplinkLoginPage coverageandBenefitsDeeplinkLoginPage = (coverageandBenefitsDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_CoverageBenefits_DEEPLINK_lOGIN_PAGE);
						Thread.sleep(5000);
						System.out.println("Title of new page : "+coverageandBenefitsDeeplinkLoginPage.getTitle());
						coverageandBenefitsDeeplinkLoginPage.enterusername(username);
						coverageandBenefitsDeeplinkLoginPage.enterpassword(password);	
						coverageandBenefitsDeeplinkLoginPage.clickSubmit();
					}
					/** 
					 * @todo :member lands on coverageandBenefits deep link page 
					 */
					 @Given("^user is navigated to the coverageandBenefits deep link page$") 
					 public void user_navigatedTo_coverageandBenefits_Deeplink_page() throws InterruptedException{
						
						 coverageandBenefitsDeeplinkLoginPage coverageandBenefitsDeeplinkLoginPage = (coverageandBenefitsDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_CoverageBenefits_DEEPLINK_lOGIN_PAGE);
					     Thread.sleep(3000);
					     coverageandBenefitsDeeplinkLoginPage.validateCoverageBenefitPage();
					}
					 /** 
						 * @todo :member lands on healthwellness deep link
						 */
						@Given("^member lands on the healthwellness deeplink page$")
						public void the_user_is_on_healthwellness_deeplink_Page() throws InterruptedException{
							WebDriver wd = getLoginScenario().getWebDriver();
							getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
							healthwellnessDeepLinkLoginPage healthwellnessDeepLinkLoginPage = new healthwellnessDeepLinkLoginPage(wd);
							healthwellnessDeepLinkLoginPage.navigateToLoginURL();
							getLoginScenario().saveBean(PageConstants.STAGE_HelthandWellness_DEEPLINK_lOGIN_PAGE,healthwellnessDeepLinkLoginPage );	
						}
						/** 
						 * @todo :deep link login page elements validate  
						 */
						@And("^the healthwellness deeplink page is displayed with all the fields$")
						public void healthwellness_pageis_displayed(){
							healthwellnessDeepLinkLoginPage healthwellnessDeepLinkLoginPage = (healthwellnessDeepLinkLoginPage) loginScenario.getBean(PageConstants.STAGE_HelthandWellness_DEEPLINK_lOGIN_PAGE);
							healthwellnessDeepLinkLoginPage.validatePageElements();
						}  
						/** 
						 * @todo :on the healthwellness deep link page member enters login credentials 
						 */
						@Given("^on healthwellness deeplink page I enter the member details and click continue$")
						public void the_user_is_on_healthwellness_deeplink_page(DataTable givenAttributes) throws InterruptedException{
							/* Reading the given attribute from feature file */
							List<DataTableRow> memberAttributesRow = givenAttributes
									.getGherkinRows();
							Map<String, String> memberAttributesMap = new HashMap<String, String>();
							for (int i = 0; i < memberAttributesRow.size(); i++) {

								memberAttributesMap.put(memberAttributesRow.get(i).getCells()
										.get(0), memberAttributesRow.get(i).getCells().get(1));
							}

							String username = memberAttributesMap.get("User Name");
							String password  = memberAttributesMap.get("Password");
							System.out.println("User name : "+username );
							healthwellnessDeepLinkLoginPage healthwellnessDeepLinkLoginPage = (healthwellnessDeepLinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_HelthandWellness_DEEPLINK_lOGIN_PAGE);
							Thread.sleep(5000);
							System.out.println("Title of new page : "+healthwellnessDeepLinkLoginPage.getTitle());
							healthwellnessDeepLinkLoginPage.enterusername(username);
							healthwellnessDeepLinkLoginPage.enterpassword(password);	
							healthwellnessDeepLinkLoginPage.clickSubmit();
						}
						/** 
						 * @todo :member lands on healthwellness deep link page 
						 */
						 @Given("^user is navigated to the healthwellness deep link page$") 
						 public void user_navigatedTo_healthwellness_Deeplink_page() throws InterruptedException{
							
							 healthwellnessDeepLinkLoginPage healthwellnessDeepLinkLoginPage = (healthwellnessDeepLinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_HelthandWellness_DEEPLINK_lOGIN_PAGE);
						     Thread.sleep(3000);
						     healthwellnessDeepLinkLoginPage.validateHealthWellnessPage();
						}
						 /** 
							 * @todo :member lands on myDocuments deep link
							 */
							@Given("^member lands on the myDocuments deeplink page$")
							public void the_user_is_on_myDocuments_deeplink_Page() throws InterruptedException{
								WebDriver wd = getLoginScenario().getWebDriver();
								getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
								myDocumentsDeeplinkLoginPage myDocumentsDeeplinkLoginPage = new myDocumentsDeeplinkLoginPage(wd);
								myDocumentsDeeplinkLoginPage.navigateToLoginURL();
								getLoginScenario().saveBean(PageConstants.STAGE_MyDocuments_DEEPLINK_lOGIN_PAGE,myDocumentsDeeplinkLoginPage );	
							}
							/** 
							 * @todo :deep link login page elements validate  
							 */
							@And("^the myDocuments deeplink page is displayed with all the fields$")
							public void myDocuments_pageis_displayed(){
								myDocumentsDeeplinkLoginPage myDocumentsDeeplinkLoginPage = (myDocumentsDeeplinkLoginPage) loginScenario.getBean(PageConstants.STAGE_MyDocuments_DEEPLINK_lOGIN_PAGE);
								myDocumentsDeeplinkLoginPage.validatePageElements();
							}  
							/** 
							 * @todo :on the myDocuments deep link page member enters login credentials 
							 */
							@Given("^on myDocuments deeplink page I enter the member details and click continue$")
							public void the_user_is_on_myDocuments_deeplink_page(DataTable givenAttributes) throws InterruptedException{
								/* Reading the given attribute from feature file */
								List<DataTableRow> memberAttributesRow = givenAttributes
										.getGherkinRows();
								Map<String, String> memberAttributesMap = new HashMap<String, String>();
								for (int i = 0; i < memberAttributesRow.size(); i++) {

									memberAttributesMap.put(memberAttributesRow.get(i).getCells()
											.get(0), memberAttributesRow.get(i).getCells().get(1));
								}

								String username = memberAttributesMap.get("User Name");
								String password  = memberAttributesMap.get("Password");
								System.out.println("User name : "+username );
								myDocumentsDeeplinkLoginPage myDocumentsDeeplinkLoginPage = (myDocumentsDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_MyDocuments_DEEPLINK_lOGIN_PAGE);
								Thread.sleep(5000);
								System.out.println("Title of new page : "+myDocumentsDeeplinkLoginPage.getTitle());
								myDocumentsDeeplinkLoginPage.enterusername(username);
								myDocumentsDeeplinkLoginPage.enterpassword(password);	
								myDocumentsDeeplinkLoginPage.clickSubmit();
							}
							/** 
							 * @todo :member lands on myDocuments deep link page 
							 */
							 @Given("^user is navigated to the myDocuments deep link page$") 
							 public void user_navigatedTo_myDocuments_Deeplink_page() throws InterruptedException{
								
								 myDocumentsDeeplinkLoginPage myDocumentsDeeplinkLoginPage = (myDocumentsDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_MyDocuments_DEEPLINK_lOGIN_PAGE);
							     Thread.sleep(3000);
							     myDocumentsDeeplinkLoginPage.validateMyDocumentsPage();
							}
							 
							@And("^user stores test input for validations$")
							public void storeTestInput(DataTable memberAttributes) {
								List<DataTableRow> memberAttributesRow = memberAttributes
										.getGherkinRows();
								Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
								for (int i = 0; i < memberAttributesRow.size(); i++) {

									memberAttributesMap.put(memberAttributesRow.get(i).getCells()
											.get(0), memberAttributesRow.get(i).getCells().get(1));
								}

								String planType = memberAttributesMap.get("Plan Type");
								String category = memberAttributesMap.get("Member Type");
								String userName = memberAttributesMap.get("Username");

								getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
								getLoginScenario().saveBean(LoginCommonConstants.PLANTYPE,planType);
								getLoginScenario().saveBean(LoginCommonConstants.CATOGERY,category);

							}

							/** 
								 * @todo :agent lands on login page 
								 */
								@Given("^agentlogin lands on page$") 
								public void agentloginandsnpage() throws InterruptedException{
									WebDriver wd = getLoginScenario().getWebDriver();
									getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
									aarpChatAgentLogin aarpChatAgentLogin = new aarpChatAgentLogin(wd);
									aarpChatAgentLogin.navigateToLoginURL();
									aarpChatAgentLogin.validatePageElements();
									getLoginScenario().saveBean(PageConstants.AARP_CHAT_AGENT_LOGIN,aarpChatAgentLogin );	
								}
								/** 
								 * @todo :agent enters credentials 
								 */
								 @Given("^agent enters credentials$") 
								 public void agententercredentials(DataTable credentialsList) throws InterruptedException{
									 Thread.sleep(5000);
									 String username = credentialsList.asList(String.class).get(0);
									 String password = credentialsList.asList(String.class).get(1);
									aarpChatAgentLogin.enterusername(username);
									aarpChatAgentLogin.enterpassword(password);	
									 aarpChatAgentLogin.clickSubmit();
									
									 aarpChatAgentLogin aarpChatAgentLogin = (aarpChatAgentLogin) getLoginScenario().getBean(PageConstants.AARP_CHAT_AGENT_LOGIN);
								     Thread.sleep(3000);
								     aarpChatAgentLogin.aarpchatagentreadystate();
								}	
								 /** 
									 * @todo :agent enters credentials 
									 */
									 @Given("^agent enters credentials for federal$") 
									 public void fedagententercredentials(DataTable credentialsList) throws InterruptedException{
										 Thread.sleep(5000);
										 String username = credentialsList.asList(String.class).get(0);
										 String password = credentialsList.asList(String.class).get(1);
										aarpChatAgentLogin.enterusername(username);
										aarpChatAgentLogin.enterpassword(password);	
										 aarpChatAgentLogin.clickSubmit();
										
										 aarpChatAgentLogin aarpChatAgentLogin = (aarpChatAgentLogin) getLoginScenario().getBean(PageConstants.AARP_CHAT_AGENT_LOGIN);
									     Thread.sleep(3000);
									     aarpChatAgentLogin.aarpchatagentreadystate();
									}
									 /** 
										 * @todo :member lands on myDocuments deep link
										 */
										@Given("^I am an M&R SHIP member$")
										public void the_SHIP_user_iS_on_deeplink_Page() throws InterruptedException{
											WebDriver wd = getLoginScenario().getWebDriver();
											getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
											healthwellnessDeepLinkLoginPageSHIP healthwellnessDeepLinkLoginPageSHIP = new healthwellnessDeepLinkLoginPageSHIP(wd);
											healthwellnessDeepLinkLoginPageSHIP.navigateToLoginURL();
											getLoginScenario().saveBean(PageConstants.AARP_HAWL,healthwellnessDeepLinkLoginPageSHIP );	
										}
										/** 
										 * @todo :deep link login page elements validate  
										 */
										@And("^the page is displayed with all the fields$")
										public void signin_pageis_displayed(){
											healthwellnessDeepLinkLoginPageSHIP healthwellnessDeepLinkLoginPageSHIP = (healthwellnessDeepLinkLoginPageSHIP) loginScenario.getBean(PageConstants.AARP_HAWL);
											healthwellnessDeepLinkLoginPageSHIP.validatePageElements();
										}  
										/** 
										 * @todo :on the healthwellness deep link page SHIP member enters login credentials 
										 */
										@Given("^I Sign on to the M&R Member Portal$")
										public void the_user_is_on(DataTable givenAttributes) throws InterruptedException{
											/* Reading the given attribute from feature file */
											List<DataTableRow> memberAttributesRow = givenAttributes
													.getGherkinRows();
											Map<String, String> memberAttributesMap = new HashMap<String, String>();
											for (int i = 0; i < memberAttributesRow.size(); i++) {

												memberAttributesMap.put(memberAttributesRow.get(i).getCells()
														.get(0), memberAttributesRow.get(i).getCells().get(1));
											}

											String username = memberAttributesMap.get("User Name");
											String password  = memberAttributesMap.get("Password");
											System.out.println("User name : "+username );
											healthwellnessDeepLinkLoginPageSHIP healthwellnessDeepLinkLoginPageSHIP = (healthwellnessDeepLinkLoginPageSHIP) getLoginScenario().getBean(PageConstants.AARP_HAWL);
											Thread.sleep(5000);
											System.out.println("Title of new page : "+healthwellnessDeepLinkLoginPageSHIP.getTitle());
											healthwellnessDeepLinkLoginPageSHIP.enterusername(username);
											healthwellnessDeepLinkLoginPageSHIP.enterpassword(password);	
											healthwellnessDeepLinkLoginPageSHIP.clickSubmit();
										}
										/** 
										 * @todo :member lands on healthwellness deep link page 
										 */
										 @Given("^I will land on the Talix page for At Your Best$") 
										 public void i_will_land_on_the_Talix_page_for_At_Your_Best() throws InterruptedException{											
											 healthwellnessDeepLinkLoginPageSHIP healthwellnessDeepLinkLoginPageSHIP = (healthwellnessDeepLinkLoginPageSHIP) getLoginScenario().getBean(PageConstants.AARP_HAWL);
										     Thread.sleep(3000);
										     healthwellnessDeepLinkLoginPageSHIP.validateHealthWellnessPage();
										}
										
										/** 
										 * @todo :member lands on pharmacy deep link
										*/
										@Given("^member lands on the pharmacy deeplink page$")
										public void the_user_is_on_pharmacy_deeplink_Page(DataTable givenAttributes) throws InterruptedException{
											String brand = givenAttributes.asList(String.class).get(0);
											WebDriver wd = getLoginScenario().getWebDriver();
											getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
											PharmacyDeeplinkLoginPage pharmacyDeeplinkLoginPage = new PharmacyDeeplinkLoginPage(wd);
											pharmacyDeeplinkLoginPage.navigateToLoginURL(brand);
											getLoginScenario().saveBean(PageConstants.STAGE_Pharmacy_DEEPLINK_lOGIN_PAGE,pharmacyDeeplinkLoginPage );	
										}
										/** 
										 * @todo :deep link login page elements validate  
										*/
										@And("^the pharmacy deeplink login page is displayed with all the fields$")
										public void pharmacy_pageis_displayed(){
											PharmacyDeeplinkLoginPage pharmacyDeeplinkLoginPage = (PharmacyDeeplinkLoginPage) loginScenario.getBean(PageConstants.STAGE_Pharmacy_DEEPLINK_lOGIN_PAGE);
											pharmacyDeeplinkLoginPage.validatePageElements();
										}  
										/** 
										 * @todo :on the pharmacy deep link page member enters login credentials 
										 */
										@Given("^on pharmacy deeplink login page I enter the member details and click continue$")
										public void the_user_is_on_pharmacy_deeplink_page(DataTable givenAttributes) throws InterruptedException{
											/* Reading the given attribute from feature file */
											Map<String, String> memberAttributesMap=parseInputArguments(givenAttributes);
											String username = memberAttributesMap.get("User Name");
											String password  = memberAttributesMap.get("Password");
											System.out.println("User name : "+username );
											PharmacyDeeplinkLoginPage pharmacyDeeplinkLoginPage = (PharmacyDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_Pharmacy_DEEPLINK_lOGIN_PAGE);
											Thread.sleep(5000);
											System.out.println("Title of new page : "+pharmacyDeeplinkLoginPage.getTitle());
											pharmacyDeeplinkLoginPage.enterusername(username);
											pharmacyDeeplinkLoginPage.enterpassword(password);	
											pharmacyDeeplinkLoginPage.clickSubmit();
										}
										/** 
										 * @todo :member lands on pharmacy deep link page 
										 */
										 @Given("^user is navigated to the pharmacy deep link page$") 
										 public void user_navigatedTo_Pharmacy_Deeplink_page() throws InterruptedException{
											 PharmacyDeeplinkLoginPage pharmacyDeeplinkLoginPage = (PharmacyDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_Pharmacy_DEEPLINK_lOGIN_PAGE);
										     Thread.sleep(3000);
										     pharmacyDeeplinkLoginPage.validatePharmacyPage();
										}
										
										/** 
										 * @todo :member lands on virtual visit deep link
										*/
										@Given("^member lands on the virtual visit deeplink page$")
										public void the_user_is_on_virtualVisit_deeplink_Page(DataTable givenAttributes) throws InterruptedException{
											String brand = givenAttributes.asList(String.class).get(0);
											WebDriver wd = getLoginScenario().getWebDriver();
											getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
											VirtualVisitDeeplinkLoginPage virtualVisitDeeplinkLoginPage = new VirtualVisitDeeplinkLoginPage(wd);
											virtualVisitDeeplinkLoginPage.navigateToLoginURL(brand);
											getLoginScenario().saveBean(PageConstants.STAGE_VirtualVisit_DEEPLINK_lOGIN_PAGE,virtualVisitDeeplinkLoginPage );	
										}
										/** 
										 * @todo :deep link login page elements validate  
										*/
										@And("^the virtual visit deeplink login page is displayed with all the fields$")
										public void virtualVisit_pageis_displayed(){
											VirtualVisitDeeplinkLoginPage virtualVisitDeeplinkLoginPage = (VirtualVisitDeeplinkLoginPage) loginScenario.getBean(PageConstants.STAGE_VirtualVisit_DEEPLINK_lOGIN_PAGE);
											virtualVisitDeeplinkLoginPage.validatePageElements();
										}  
										/** 
										 * @todo :on the virtual visit deep link page member enters login credentials 
										 */
										@Given("^on virtual visit deeplink login page I enter the member details and click continue$")
										public void the_user_is_on_virtualVisit_deeplink_page(DataTable givenAttributes) throws InterruptedException{
											/* Reading the given attribute from feature file */
											Map<String, String> memberAttributesMap=parseInputArguments(givenAttributes);
											String username = memberAttributesMap.get("User Name");
											String password  = memberAttributesMap.get("Password");
											System.out.println("User name : "+username );
											VirtualVisitDeeplinkLoginPage virtualVisitDeeplinkLoginPage = (VirtualVisitDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_VirtualVisit_DEEPLINK_lOGIN_PAGE);
											Thread.sleep(5000);
											System.out.println("Title of new page : "+virtualVisitDeeplinkLoginPage.getTitle());
											virtualVisitDeeplinkLoginPage.enterusername(username);
											virtualVisitDeeplinkLoginPage.enterpassword(password);	
											virtualVisitDeeplinkLoginPage.clickSubmit();
										}
										/** 
										 * @todo :member lands on virtual visit deep link page 
										*/
										@Given("^user is navigated to the virtual visit deep link page$") 
										public void user_navigatedTo_VirtualVisit_Deeplink_page() throws InterruptedException{
											 VirtualVisitDeeplinkLoginPage virtualVisitDeeplinkLoginPage = (VirtualVisitDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_VirtualVisit_DEEPLINK_lOGIN_PAGE);
										     Thread.sleep(3000);
										     virtualVisitDeeplinkLoginPage.validateVirtualVisitPage();
										}
										
										/** 
										 * member lands on Dentegra Dental Deeplink URL
										 */
										@Given("^member lands on dentegra dental deeplink page$")
										public void the_SHIP_user_iS_on_dentegra_dental_deeplink_Page() throws InterruptedException{
											WebDriver wd = getLoginScenario().getWebDriver();
											getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
											healthwellnessDeepLinkLoginPageSHIP healthwellnessDeepLinkLoginPageSHIP = new healthwellnessDeepLinkLoginPageSHIP(wd);
											healthwellnessDeepLinkLoginPageSHIP.navigateToDentegraDentalURL();
											getLoginScenario().saveBean(PageConstants.AARP_HAWL,healthwellnessDeepLinkLoginPageSHIP );	
										}
										/** 
										 * member lands on Talix page for the Dentegra Dental Discount article
										 */
										 @Given("^I will land on the Talix page for the Dentegra Dental Discount article$") 
										 public void i_will_land_on_the_Talix_page_for_Dentegra_Dental_Page() throws InterruptedException{											
											 healthwellnessDeepLinkLoginPageSHIP healthwellnessDeepLinkLoginPageSHIP = (healthwellnessDeepLinkLoginPageSHIP) getLoginScenario().getBean(PageConstants.AARP_HAWL);
										     Thread.sleep(3000);
										     healthwellnessDeepLinkLoginPageSHIP.validateDentegraDentalPage();
										}
										 
										@Then("^I click on logout and validate the login page$")
										public void click_on_logout_validate_login_page() {
											TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
											if(testHarnessPage != null) {
												testHarnessPage.clickAccountProfile();
												testHarnessPage.logout();
											} else {
												AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
												accountHomePage.clickAccountProfileDashboard();
												accountHomePage.clickLogoutDashboardAndCheckLoginPage();												
											}
										}

										@Given("^First check if feature security flag is set to true$")
										 public void checkSecurityFlagCTCW(DataTable memberAttributes) {
										  String domain = null;
										  Map < String,
										  String > memberAttributesMap = parseInputArguments(memberAttributes);
										  String feature = memberAttributesMap.get("Feature");
										  if (!feature.equals("UCPPayments")
										  && !feature.equals("UCPContactus")
										  && !feature.equals("UCPUserManagement")
										  && !feature.equals("UCPSSOMemberAuth")
										  ) {
										    Assert.assertTrue("PROBLEM - ATDD code doesn't support security flag check for feature '" + feature + "' yet or make sure it's spelled correctly", false);
										  }
										  System.out.println("feature=" + feature);
										  
										  if (MRScenario.environment.equalsIgnoreCase("stage"))
										  {
											  domain = "http://apsrs7260.uhc.com:8080";
										  }
										 
										  else if (MRScenario.environment.equalsIgnoreCase("team-h")) {
										    if (feature.equals("UCPPayments")) {
										    	domain = "http://ucp-payments-team-h.ocp-ctc-dmz-nonprod.optum.com";
										    } else if (feature.equals("UCPUserManagement")) {
										    	domain = "http://ucp-user-management-team-h.ocp-ctc-dmz-nonprod.optum.com";
										    } else if (feature.equals("UCPContactus")) {
										    	domain = "http://ucp-contactus-team-h.ocp-ctc-dmz-nonprod.optum.com/";
										    } else if (feature.equals("UCPSSOMemberAuth")) {
										    	domain = "http://ucp-benefits-mnr-ucp-stage-3.ocp-ctc-dmz-stg.optum.com";
										    }
										  }
										  
										  
										  MRScenario m = new MRScenario();
										  WebDriver d = m.getWebDriverNew();
										  d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
										  if (MRScenario.environment.contains("stage")|| MRScenario.environment.contains("team-h")) {
												//note: for stage or team-h, only check 1 server
											  checkEnableSecurityPerServerCTCW(d, domain, feature);
												
											} else if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) {
												//note: offline/online-prod servers will keep switching between release
												//note: it's hard to figure out at run time which server to use so just check for both
												//note: in theory,both should always be true anyway
												domain="http://apsrp04756.uhc.com:8080";
												checkEnableSecurityPerServerCTCW(d, domain, feature);

												domain="http://apsrp04757.uhc.com:8080";
												checkEnableSecurityPerServerCTCW(d, domain, feature);
												
											}
										
										  d.quit();
										}
										
										public void checkEnableSecurityPerServerCTCW(WebDriver d, String domain, String feature) {
											  String configPgUrl = domain + "/" + feature + "/wsConfig";
											  System.out.println("Config page URL=" + configPgUrl);

											  d.get(configPgUrl);
											  d.navigate().refresh();
											  CommonUtility.checkPageIsReady(d);
											  try {
												String securityFlagXpath = "//td[text()='enableSecurity']/following-sibling::td";
											    WebElement e = d.findElement(By.xpath(securityFlagXpath));
											    CommonUtility.waitForPageLoad(d, e, 5);
											    if (e.isDisplayed()) {
											      System.out.println("Element '" + e.toString() + "' found!!!!");
											      String value = e.getText();
											      System.out.println("Value of enableSecurity flag is : "+value);
											      if (value.equalsIgnoreCase("false")) 
											      {      
											        Assert.assertTrue("PROBLEM - " + MRScenario.environment + " environment should have feature '" + feature + "' security flag = true, right now it is set to " + value + " | configPgUrl=" + configPgUrl + ", stopping all tests now. | saurcelab session=" + MRScenario.returnJobURL(), false);
											      }
											      else {
											        System.out.println("feature '" + feature + "' security flag is true on env '" + MRScenario.environment + "' configPgUrl=" + configPgUrl + ", okay to move on...");
											      }
											    } else {
											      Assert.assertTrue("PROBLEM - unable to locate security flag in the config URL='" + configPgUrl + "' page, stopping all tests now. | saurcelab session=" + MRScenario.returnJobURL(), false);
											    }
											  } catch(Exception e) {
											    
											      System.out.println("unable to locate security flag in the config URL='" + configPgUrl + "' page");
											       Assert.fail("unable to locate security flag in the config URL='\" + configPgUrl + \"' page");
											  }
										}
										
										/** 
										 * @todo :member lands on myDocuments e-delivery deep link page 
										 */
										@Given("^member lands on the myDocuments edelivery deeplink page$")
										public void the_user_is_on_myDocuments_edelivery_deeplink_Page() throws InterruptedException{
											WebDriver wd = getLoginScenario().getWebDriver();
											getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
											myDocumentsEdeliveryDeeplinkLoginPage myDocumentsEdeliveryDeeplinkLoginPage = new myDocumentsEdeliveryDeeplinkLoginPage(wd);
											myDocumentsEdeliveryDeeplinkLoginPage.navigateToLoginURL();
											//myDocumentsDeeplinkLoginPage myDocumentsDeeplinkLoginPage = new myDocumentsDeeplinkLoginPage(wd);
											//myDocumentsDeeplinkLoginPage.navigateToLoginURL();
											getLoginScenario().saveBean(PageConstants.STAGE_MyDocuments_Edelivery_DEEPLINK_lOGIN_PAGE,myDocumentsEdeliveryDeeplinkLoginPage );	
										}
										/** 
										 * @todo :edelivery deep link login page elements validate  
										 */
										@And("^the myDocuments edelivery deeplink page is displayed with all the fields$")
										public void myDocuments_edelivery_pageis_displayed(){
											myDocumentsEdeliveryDeeplinkLoginPage myDocumentsEdeliveryDeeplinkLoginPage = (myDocumentsEdeliveryDeeplinkLoginPage) loginScenario.getBean(PageConstants.STAGE_MyDocuments_Edelivery_DEEPLINK_lOGIN_PAGE);
											myDocumentsEdeliveryDeeplinkLoginPage.validatePageElements();
										}  
										/** 
										 * @todo :on the myDocuments edelivery deep link page member enters login credentials 
										 */
										@Given("^on myDocuments edelivery deeplink page I enter the member details and click continue$")
										public void the_user_is_on_myDocuments_edelivery_deeplink_page(DataTable givenAttributes) throws InterruptedException{
											/* Reading the given attribute from feature file */
											List<DataTableRow> memberAttributesRow = givenAttributes
													.getGherkinRows();
											Map<String, String> memberAttributesMap = new HashMap<String, String>();
											for (int i = 0; i < memberAttributesRow.size(); i++) {

												memberAttributesMap.put(memberAttributesRow.get(i).getCells()
														.get(0), memberAttributesRow.get(i).getCells().get(1));
											}
											String username = memberAttributesMap.get("User Name");
											String password  = memberAttributesMap.get("Password");
											System.out.println("User name : "+username );
											myDocumentsEdeliveryDeeplinkLoginPage myDocumentsEdeliveryDeeplinkLoginPage = (myDocumentsEdeliveryDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_MyDocuments_Edelivery_DEEPLINK_lOGIN_PAGE);
											Thread.sleep(5000);
											System.out.println("Title of new page : "+myDocumentsEdeliveryDeeplinkLoginPage.getTitle());
											myDocumentsEdeliveryDeeplinkLoginPage.enterusername(username);
											myDocumentsEdeliveryDeeplinkLoginPage.enterpassword(password);	
											myDocumentsEdeliveryDeeplinkLoginPage.clickSubmit();
										                                               }
										/** 
										 * @todo :member lands on myDocuments edelivery deep link page 
										 */
										 @Given("^user is navigated to the myDocuments edelivery deep link page$") 
										 public void user_navigatedTo_myDocuments_edelivery_Deeplink_page() throws InterruptedException{
											
											 myDocumentsEdeliveryDeeplinkLoginPage myDocumentsEdeliveryDeeplinkLoginPage = (myDocumentsEdeliveryDeeplinkLoginPage) getLoginScenario().getBean(PageConstants.STAGE_MyDocuments_Edelivery_DEEPLINK_lOGIN_PAGE);
										     Thread.sleep(3000);
										     myDocumentsEdeliveryDeeplinkLoginPage.validateMyDocumentsPage();
										}
										 /** 
											 * @todo :member lands on virtual visit offline PROD deep link
											*/
											@Given("^member lands on the offline PROD virtual visit deeplink page$")
											public void the_user_is_on_offline_PROD_virtualVisit_deeplink_Page(DataTable givenAttributes) throws InterruptedException{
												String brand = givenAttributes.asList(String.class).get(0);
												WebDriver wd = getLoginScenario().getWebDriver();
												getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
												OfflineProd_VirtualVisitDeeplinkLoginPage OfflineProd_VirtualVisitDeeplinkLoginPage = new OfflineProd_VirtualVisitDeeplinkLoginPage(wd);
												OfflineProd_VirtualVisitDeeplinkLoginPage.navigateToLoginURL(brand);
												getLoginScenario().saveBean(PageConstants.Offline_PROD_VirtualVisit_DEEPLINK_lOGIN_PAGE,OfflineProd_VirtualVisitDeeplinkLoginPage);
														}
											/** 
											 * @todo :deep link login page elements validate  
											*/
											@And("^the offline PROD virtual visit deeplink login page is displayed with all the fields$")
											public void offlinePROD_virtualVisit_pageis_displayed(){
												OfflineProd_VirtualVisitDeeplinkLoginPage OfflineProd_VirtualVisitDeeplinkLoginPage = (OfflineProd_VirtualVisitDeeplinkLoginPage) loginScenario.getBean(PageConstants.Offline_PROD_VirtualVisit_DEEPLINK_lOGIN_PAGE);
												OfflineProd_VirtualVisitDeeplinkLoginPage.validatePageElements();
												OfflineProd_VirtualVisitDeeplinkLoginPage.validateOfflineProdVirtualVisitPage();
											}  
											
											/** 
											 * @todo :member lands on virtual visit offline PROD deep link
											*/
											@Given("^member lands on the offline PROD HWP deeplink page$")
											public void the_user_is_on_offline_PROD_HWP_deeplink_Page(DataTable givenAttributes) throws InterruptedException{
												String brand = givenAttributes.asList(String.class).get(0);
												WebDriver wd = getLoginScenario().getWebDriver();
												getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
												OfflineProd_PharmacynPrescriptionLoginPage OfflineProd_PharmacynPrescriptionLoginPage = new OfflineProd_PharmacynPrescriptionLoginPage(wd);
												OfflineProd_PharmacynPrescriptionLoginPage.navigateToLoginURL(brand);
												getLoginScenario().saveBean(PageConstants.Offline_PROD_HWP_DEEPLINK_lOGIN_PAGE,OfflineProd_PharmacynPrescriptionLoginPage);
														}
											/** 
											 * @todo :deep link login page elements validate  
											*/
											@And("^the offline PROD HWP deeplink login page is displayed with all the fields$")
											public void offlinePROD_HWP_pageis_displayed(){
												OfflineProd_PharmacynPrescriptionLoginPage OfflineProd_PharmacynPrescriptionLoginPage = (OfflineProd_PharmacynPrescriptionLoginPage) loginScenario.getBean(PageConstants.Offline_PROD_HWP_DEEPLINK_lOGIN_PAGE);
												OfflineProd_PharmacynPrescriptionLoginPage.validatePageElements();
												OfflineProd_PharmacynPrescriptionLoginPage.validateOfflineProdHWPPage();
											}  
											/** 
											 * @todo :member lands on the offline PROD health & wellness deeplink page
											*/
											@Given("^member lands on the offline PROD health & wellness deeplink page$")
											public void the_user_is_on_offline_PROD_healthnwellness_deeplink_Page(DataTable givenAttributes) throws InterruptedException{
												String brand = givenAttributes.asList(String.class).get(0);
												WebDriver wd = getLoginScenario().getWebDriver();
												getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
												healthwellnessDeepLinkLoginPageSHIP healthwellnessDeepLinkLoginPageSHIP = new healthwellnessDeepLinkLoginPageSHIP(wd);
												healthwellnessDeepLinkLoginPageSHIP.navigateToLoginURLoffline(brand);
												getLoginScenario().saveBean(PageConstants.Offline_PROD_SHIP_healthNwellness,healthwellnessDeepLinkLoginPageSHIP);
														}
											/** 
											 * @throws InterruptedException 
											 * @todo :deep link login page elements validate  
											*/
											@And("^the offline PROD health & wellness deeplink login page is displayed with all the fields$")
											public void offlinePROD_healthnWellness_displayed() throws InterruptedException{
												healthwellnessDeepLinkLoginPageSHIP healthwellnessDeepLinkLoginPageSHIP = (healthwellnessDeepLinkLoginPageSHIP) loginScenario.getBean(PageConstants.Offline_PROD_SHIP_healthNwellness);
												healthwellnessDeepLinkLoginPageSHIP.validateofflinePageElements();
												healthwellnessDeepLinkLoginPageSHIP.validateOfflineProdhealthwellnessPage();
											}
											/** 
											 * @todo :member lands on the offline PROD health & wellness deeplink page
											*/
											@Given("^member lands on the PROD /offline edelivery deeplink page$")
											public void the_user_is_on_offline_PROD_edelivery_deeplink_Page(DataTable givenAttributes) throws InterruptedException{
												String brand = givenAttributes.asList(String.class).get(0);
												WebDriver wd = getLoginScenario().getWebDriver();
												getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
												myDocumentsEdeliveryDeeplinkLoginPage myDocumentsEdeliveryDeeplinkLoginPage = new myDocumentsEdeliveryDeeplinkLoginPage(wd);
												myDocumentsEdeliveryDeeplinkLoginPage.navigateToLoginURLoffline(brand);
												getLoginScenario().saveBean(PageConstants.Offline_PROD_edelivery,myDocumentsEdeliveryDeeplinkLoginPage);
														}
											/** 
											 * @throws InterruptedException 
											 * @todo :deep link login page elements validate  
											*/
											@And("^the offline PROD edelivery deeplink login page is displayed with all the fields$")
											public void offlinePROD_edelivery_displayed() throws InterruptedException{
												myDocumentsEdeliveryDeeplinkLoginPage myDocumentsEdeliveryDeeplinkLoginPage = (myDocumentsEdeliveryDeeplinkLoginPage) loginScenario.getBean(PageConstants.Offline_PROD_edelivery);
												myDocumentsEdeliveryDeeplinkLoginPage.validateofflinePageElements();
												myDocumentsEdeliveryDeeplinkLoginPage.validateOfflineProdpRODedeliverypage();
											}
											/** 
											 * @todo :member lands on virtual visit offline PROD deep link
											*/
											@Given("^member lands on the PROD virtual visit deeplink page$")
											public void the_user_is_on_PROD_virtualVisit_deeplink_Page(DataTable givenAttributes) throws InterruptedException{
												String brand = givenAttributes.asList(String.class).get(0);
												WebDriver wd = getLoginScenario().getWebDriver();
												getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
												Prod_VirtualVisitDeeplinkLoginPage Prod_VirtualVisitDeeplinkLoginPage = new Prod_VirtualVisitDeeplinkLoginPage(wd);
												Prod_VirtualVisitDeeplinkLoginPage.navigateToLoginURL(brand);
												getLoginScenario().saveBean(PageConstants.PROD_VirtualVisit_DEEPLINK_lOGIN_PAGE,Prod_VirtualVisitDeeplinkLoginPage);
														}
											/** 
											 * @todo :deep link login page elements validate  
											*/
											@And("^the PROD virtual visit deeplink login page is displayed with all the fields$")
											public void PROD_virtualVisit_pageis_displayed(){
												Prod_VirtualVisitDeeplinkLoginPage Prod_VirtualVisitDeeplinkLoginPage = (Prod_VirtualVisitDeeplinkLoginPage) loginScenario.getBean(PageConstants.PROD_VirtualVisit_DEEPLINK_lOGIN_PAGE);
												Prod_VirtualVisitDeeplinkLoginPage.validatePageElements();
												Prod_VirtualVisitDeeplinkLoginPage.validateOfflineProdVirtualVisitPage();
											}  
											/** 
											 * @todo :member lands on the offline PROD health & wellness deeplink page
											*/
											@Given("^member lands on the PROD health & wellness deeplink page$")
											public void the_user_is_on_PROD_healthnwellness_deeplink_Page(DataTable givenAttributes) throws InterruptedException{
												String brand = givenAttributes.asList(String.class).get(0);
												WebDriver wd = getLoginScenario().getWebDriver();
												getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
												healthwellnessDeepLinkLoginPageSHIP healthwellnessDeepLinkLoginPageSHIP = new healthwellnessDeepLinkLoginPageSHIP(wd);
												healthwellnessDeepLinkLoginPageSHIP.navigateToLoginURLPROD(brand);
												getLoginScenario().saveBean(PageConstants.Offline_PROD_SHIP_healthNwellness,healthwellnessDeepLinkLoginPageSHIP);
														}
											/** 
											 * @throws InterruptedException 
											 * @todo :deep link login page elements validate  
											*/
											@And("^the PROD health & wellness deeplink login page is displayed with all the fields$")
											public void PROD_healthnWellness_displayed() throws InterruptedException{
												healthwellnessDeepLinkLoginPageSHIP healthwellnessDeepLinkLoginPageSHIP = (healthwellnessDeepLinkLoginPageSHIP) loginScenario.getBean(PageConstants.Offline_PROD_SHIP_healthNwellness);
												healthwellnessDeepLinkLoginPageSHIP.validateofflinePageElements();
												healthwellnessDeepLinkLoginPageSHIP.validateOfflineProdhealthwellnessPage();
											}
											/** 
											 * @todo :member lands on the offline PROD health & wellness deeplink page
											*/
											@Given("^member lands on the PROD edelivery deeplink page$")
											public void the_user_is_on_PROD_edelivery_deeplink_Page(DataTable givenAttributes) throws InterruptedException{
												String brand = givenAttributes.asList(String.class).get(0);
												WebDriver wd = getLoginScenario().getWebDriver();
												getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
												myDocumentsEdeliveryDeeplinkLoginPage myDocumentsEdeliveryDeeplinkLoginPage = new myDocumentsEdeliveryDeeplinkLoginPage(wd);
												myDocumentsEdeliveryDeeplinkLoginPage.navigateToLoginURLPOD(brand);
												getLoginScenario().saveBean(PageConstants.Offline_PROD_edelivery,myDocumentsEdeliveryDeeplinkLoginPage);
														}
										}
