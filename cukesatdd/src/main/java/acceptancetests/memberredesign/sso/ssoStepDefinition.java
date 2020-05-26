/**
 * 
 */
/**
 * @author jkuma14
 *
 */
package acceptancetests.memberredesign.sso;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.mysql.jdbc.Driver;

//import pages.member_deprecated.bluelayer.AccountHomePage;
//import pages.member_deprecated.bluelayer.ProfilePageHsid;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import pages.regression.sso.bswiftPage;
import pages.regression.sso.CQLoginPage;
import pages.regression.sso.ssoTestHarnessPage;
import pages.regression.testharness.TestHarness;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.pharmaciesandprescriptions.PharmaciesAndPrescriptionsCommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.GlobalTearDown;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

//import pages.regression.profileandpreferences.ProfileandPreferencesPage;
/**
 * 
 * @author jkuma14
 *
 */

public class ssoStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @todo :user to login for sso from CQ5 page
	 */
	@Given("^the user access AEM Test Harness Page and enters his AEM Stage username and password and click on signin button$")
	public void the_user_is_on_member_auth_login_page(DataTable givenAttributes) throws InterruptedException {
		WebDriver wd = getLoginScenario().getWebDriver();

		CQLoginPage cqloginpage = new CQLoginPage(wd);
		cqloginpage.navigateToLoginURL();

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String userName = memberAttributesMap.get("CQ UserName");
		String passWord = memberAttributesMap.get("CQ Password");

		// create SSO Test Harness page context by signing in on CQ Page
		ssoTestHarnessPage ssoTestHarnessPage = cqloginpage.enterValuesAndSubmit(userName, passWord);
		getLoginScenario().saveBean(PageConstants.SSO_TEST_HARNESS_PAGE, ssoTestHarnessPage);
	}

	@Given("^the user enters details of member on the SSO test harness page and click submit$")

	public void the_user_is_on_member_auth_login(DataTable givenAttributes) throws InterruptedException {
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String ssopartner = memberAttributesMap.get("SSO Partner");
		String firstname = memberAttributesMap.get("First Name");
		String lastname = memberAttributesMap.get("Last Name");
		String dob = memberAttributesMap.get("DOB");
		String uhcid = memberAttributesMap.get("UHCID");
		String eaid = memberAttributesMap.get("EAID");
		String empnumber = memberAttributesMap.get("EmpNumber");

		ssoTestHarnessPage ssoTestHarnessPage = (ssoTestHarnessPage) getLoginScenario()
				.getBean(PageConstants.SSO_TEST_HARNESS_PAGE);
		Thread.sleep(5000);
		System.out.println("Title of new page : " + ssoTestHarnessPage.getTitle());

		ssoTestHarnessPage.selectBenefitFocusFromSSOPartnerDropdown(ssopartner);
		ssoTestHarnessPage.enterFirstName(firstname);
		ssoTestHarnessPage.enterLastName(lastname);
		ssoTestHarnessPage.enterDOB(dob);
		ssoTestHarnessPage.enterUHCID(uhcid);
		ssoTestHarnessPage.enterEAID(eaid);
		ssoTestHarnessPage.enterEmpNumber(empnumber);
		ssoTestHarnessPage.clickSubmit();
	}

	@Given("^user click on SSO link generated on the page$")
	public void user_click_on_SSO_link_generated_on_the_page() throws Throwable {
		ssoTestHarnessPage ssoTestHarnessPage = (ssoTestHarnessPage) getLoginScenario()
				.getBean(PageConstants.SSO_TEST_HARNESS_PAGE);
		ssoTestHarnessPage.clickSSOLink();
		Thread.sleep(3000);
		AccountHomePage accountHomePage = new AccountHomePage(ssoTestHarnessPage.driver);
		getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);

	}

	@Then("^user should be navigated to home page of rally dashboard$")
	public void user_should_be_navigated_to_home_page_of_rally_dashboard() throws Throwable {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		accountHomePage.verifyPageTitle();
		Thread.sleep(2000);
	}

	@And("^user clicks on account setting link$")
	public void user_clicks_on_account_setting_link() throws Throwable {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		ProfileandPreferencesPage profilePageHsid = accountHomePage.navigatedirectToProfilePageurl();

		if (profilePageHsid != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE_HSID, profilePageHsid);

		} else {
			System.out.println("Pnp page object is Null Here");
		}
	}

	@Then("^security and password reset link should not be visible$")
	public void security_and_password_reset_link_should_not_be_visible() throws Throwable {
		ProfileandPreferencesPage profilePageHsid = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE_HSID);
		profilePageHsid.validateHealthSafePasswordLinkNOTPresent();
		System.out.println("Health Safe Password Link was not present as expected");
		profilePageHsid.validateHealthSafeAccountLinkNOTPresent();
		System.out.println("Health Safe Account Link was not present as expected");
	}

	/**
	 * @todo :SSO for bswift client with CE group MAPD plan
	 */
	@Given("^User lands on the ping federate SSO test harness page$")
	public void the_user_is_pingFederate_Testharness_Page() throws InterruptedException {
		WebDriver wd = getLoginScenario().getWebDriver();

		// adding to get screenshots
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		bswiftPage bswiftpage = new bswiftPage(wd);
		bswiftpage.navigateToLoginURL1();
		getLoginScenario().saveBean(PageConstants.STAGE_SSO_TESTHANESS_URL_bswift, bswiftpage);
	}

	/**
	 * @todo :bswift CE testharness page elements
	 */
	@And("^testharness page is displayed with all the fields$")
	public void thetestharness_pageis_displayed() {
		bswiftPage bswiftpage = (bswiftPage) loginScenario.getBean(PageConstants.STAGE_SSO_TESTHANESS_URL_bswift);
		bswiftpage.validatePageElements();
	}

	/**
	 * @todo :bswift CE testharness page enter member details
	 */
	@Given("^User enter details on ping federate test harness page$")
	public void the_user_is_on_testharnessPage(DataTable givenAttributes) throws InterruptedException {
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String samlsubject = memberAttributesMap.get("SAML_SUBJECT");
		String firstName = memberAttributesMap.get("First Name");
		String lastName = memberAttributesMap.get("Last Name");
		String dateOfBirth = memberAttributesMap.get("DOB");
		String mbi = memberAttributesMap.get("MBI");
		String applandingurl = memberAttributesMap.get("APPLANDINGURL");
		System.out.println("Fetching values of various fields from Feature File");
		System.out.println("firstName: " + firstName + "   lastName: " + lastName + "    dob: " + dateOfBirth
				+ "    MBI: " + mbi + "    APPLANDINGURL: " + applandingurl);
		bswiftPage bswiftpage = (bswiftPage) getLoginScenario().getBean(PageConstants.STAGE_SSO_TESTHANESS_URL_bswift);
		Thread.sleep(2000);
		System.out.println("Title of new page : " + bswiftpage.getTitle());
		bswiftpage.entersamlSubject(samlsubject);
		System.out.println("Entered samlsubject as : " + samlsubject);
		bswiftpage.enterFirstName(firstName);
		System.out.println("Entered firstName as : " + firstName);
		bswiftpage.enterLastName(lastName);
		System.out.println("Entered lastName as : " + lastName);
		bswiftpage.enterMBI(mbi);
		System.out.println("Entered mbi as : " + mbi);
		bswiftpage.enterDOB(dateOfBirth);
		System.out.println("Entered dob as : " + dateOfBirth);
		bswiftpage.enterapplandingURL(applandingurl);
		System.out.println("Entered APPLANDINGURL as : " + applandingurl);

	}

	@Then("^user clicks on submit button on the Ping Federate Test Harness Page$")
	public void user_click_on_SSO_link_on_the_Ping_Federate_Test_Harness() throws InterruptedException {
		bswiftPage bswiftpage = (bswiftPage) getLoginScenario().getBean(PageConstants.STAGE_SSO_TESTHANESS_URL_bswift);
		bswiftpage.clickSubmit();
		Thread.sleep(2000);
		System.out.println("Submit button has been clicked");
		//
		System.out.println("Now Checking if user landed on covid-19 banner page");
		bswiftpage.checkCovid19Page();
		AccountHomePage accountHomePage = new AccountHomePage(bswiftpage.driver);
		getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);

	}

	@Then("^user scrolls down to Express Scripts link to perform outbound SSO$")
	public void userScrollstoExpressScriptsLink() throws Throwable {

		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		System.out.println("Now scrolling to Express Scripts link");

		benefitsCoveragePage.scrollToViewexpressScriptsLink();
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);

	}

	@Then("^user clicks on Express Scripts link and lands on Express Scripts SSO page in new window$")
	public void clickScrollstoExpressScriptsLink() throws Throwable {

		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		System.out.println("Now clicking on Express Scripts link");

		benefitsCoveragePage.clickExpressScriptsLink();
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);

	}

	@And("^user directly access the SSO link for myhce$")
	public void userdirectlyaccessesmyhcesso() throws Throwable {

		if (MRScenario.environment.equalsIgnoreCase("stage")) {
			System.out.println("Now directly accessing the SSO link for myhce");
			TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarnessPage.userdirectlyaccessesmyhcesso();
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
		} else if (MRScenario.environment.equalsIgnoreCase("prod")
				|| MRScenario.environment.equalsIgnoreCase("offline")) {
			System.out.println("Now directly accessing the SSO link for myhce");
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			accountHomePage.userdirectlyaccessesmyhcessoPROD();
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
		}
	}

	@And("^user enters zip code on myhce page and clicks on continue button$")
	/* This method will enter zip code during myhce SSO */
	public void userenterszipcode(DataTable givenAttributes) throws InterruptedException {
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipCode = memberAttributesMap.get("Zip Code");

		if (MRScenario.environment.equalsIgnoreCase("stage")) {
			TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarnessPage.userEntersZipCode(zipCode);
			testHarnessPage.clickContinueonZipEntryPage();

			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
		} else if (MRScenario.environment.equalsIgnoreCase("prod")
				|| MRScenario.environment.equalsIgnoreCase("offline")) {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			accountHomePage.userEntersZipCodePROD(zipCode);
			accountHomePage.clickContinueonZipEntryPagePROD();
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
		}
	}

	@Then("^user lands on hceestimator landing page$")
	public void userlandsonhceestimatorpage() throws Throwable {
		if (MRScenario.environment.equalsIgnoreCase("stage")) {
			System.out.println("Now checking if user landed on myhce page");
			TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarnessPage.checkuserlandsonhceestimatorpage();
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
		} else if (MRScenario.environment.equalsIgnoreCase("prod")
				|| MRScenario.environment.equalsIgnoreCase("offline")) {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			accountHomePage.checkuserlandsonhceestimatorpagePROD();
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
		}
	}

	@Then("^user scrolls down to OptumRx SSO link to perform outbound OptumRx SSO$")
	public void userScrollstoOptumRxSSOLink(DataTable givenAttributes) throws InterruptedException {

		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String optumrxssolink = memberAttributesMap.get("OptumRx SSO Link");
		System.out.println("Optum Rx SSO Link being tested in this test case is " + optumrxssolink);

		benefitsCoveragePage.scrollToOptumRxSSOLink(optumrxssolink);
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);

	}

	@Then("^user clicks on OptumRx SSO link and lands on OptumRx SSO Page in new window$")
	public void clicksToOptumRxSSOLink(DataTable givenAttributes) throws InterruptedException {

		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String optumrxssolink = memberAttributesMap.get("OptumRx SSO Link");
		System.out.println("Optum Rx SSO Link being tested in this test case is " + optumrxssolink);

		benefitsCoveragePage.clicksToOptumRxSSOLink(optumrxssolink);
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);

	}

	@Then("^now user navigates to the pharmacies and prescriptions page from dashboard or testharness page$")
	public void userClicksOnPharmaciesAndPrescriptionsPage(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String PlanType = memberAttributesMap.get("PlanType");
		System.out.println("Value of PlanType in ssoStepDefinition is :" + PlanType);
		if ((MRScenario.environment.equalsIgnoreCase("stage") & "NO".equalsIgnoreCase(MRScenario.isTestHarness))
				|| MRScenario.environment.equalsIgnoreCase("prod")
				|| MRScenario.environment.equalsIgnoreCase("offline")) {

			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			Thread.sleep(9000);
			PharmaciesAndPrescriptionsPage pnpPg = accountHomePage
					.ssousernavigateToPharmaciesAndPrescriptionsPage(PlanType);
			getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE,
					pnpPg);
		}

		else if ((MRScenario.environment.equalsIgnoreCase("team-h"))
				|| (MRScenario.environment.equalsIgnoreCase("stage")
						& "YES".equalsIgnoreCase(MRScenario.isTestHarness))) {
			System.out
					.println("Now clicking on pharmacies and prescriptions tab from Team-h or Stage test harness page");
			TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			PharmaciesAndPrescriptionsPage pnpPg = testHarnessPage.navigateToPharAndPresFromTestHarnessPage();
			getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE,
					pnpPg);
		}

		else {
			System.out.println("Not clicked on pharmacies and prescriptions tab, check conditions above");
			Assert.fail("Not clicked on pharmacies and prescriptions tab, check conditions above");
		}

	}

}
