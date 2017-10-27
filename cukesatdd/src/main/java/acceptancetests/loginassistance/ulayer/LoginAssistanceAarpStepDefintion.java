/**
 * 
 */
package acceptancetests.loginassistance.ulayer;

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
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.LoginAssistancePage;
import pages.acquisition.ulayer.LoginAssitanceMessagePage;
import pages.acquisition.ulayer.PersonalIdentificationPage;
import pages.member.ulayer.LoginAssistanceConfirmationJava;
//import pages.member.ulayer.LoginAssistanceConfirmationJava;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.PersonalIdentificationPageNew;
import pages.member.ulayer.PersonalIdentityUlayerPage;
import pages.member.ulayer.UNPWAssistancePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.loginassistance.data.LoginAssistanceCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 * */
public class LoginAssistanceAarpStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^user navigates to login assistance page from member AARP site$")
	public void user_navigates_login_assistance_member_aarp() {

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
//		LoginPage loginPage = new LoginPage(wd);
//		LoginAssistancePage loginAssistancePage = loginPage
//				.navigateToLoginAssistance();
//		if (loginAssistancePage != null) {
//			getLoginScenario().saveBean(PageConstants.LOGIN_ASSISTANCE_PAGE,
//					loginAssistancePage);
//			Assert.assertTrue(true);
//		} else {
//			Assert.fail("Error loading LoginAssistance page");
//		}

	}

	@When("^select username and password$")
	public void user_pwd_select() throws InterruptedException {
		// LoginPage loginPage = (LoginPage) getLoginScenario()
		// .getBean(PageConstants.LOGIN_PAGE);

		// UNPWAssistancePage unpwassPage = (UNPWAssistancePage)
		// getLoginScenario()
		// .getBean(PageConstants.LOGIN_ASSISTANCE_PAGE);
		UNPWAssistancePage unpwassPage = new UNPWAssistancePage(
				(WebDriver) getLoginScenario().getBean(
						CommonConstants.WEBDRIVER));
		unpwassPage.UNPWinfoMissing();
		if (unpwassPage != null) {
			getLoginScenario().saveBean(PageConstants.UNPWAssistancePage,
					unpwassPage);
		}

	}

	@Then("^confirmation page need to be displayed$")
	public void login_validation(DataTable memberAttributes)
			throws InterruptedException {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1)
					.toString());
		}

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key.toString()));
			}

		}

		UNPWAssistancePage unpwassPage = (UNPWAssistancePage) getLoginScenario()
				.getBean(PageConstants.UNPWAssistancePage);
		// UNPWAssistancePage unpwassPage = new UNPWAssistancePage((WebDriver)
		// getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		unpwassPage.FillDetails(memberAttributesMap.get("memID"),
				memberAttributesMap.get("DBmm"),
				memberAttributesMap.get("DBdd"),
				memberAttributesMap.get("DOByyyy"),
				memberAttributesMap.get("LastName"),
				memberAttributesMap.get("zipcd"));
	}

	@Given("^user is on AssistanceConfirmationPage and moves to Sign in Page$")
	public void AssistanceConfirmationPage() throws InterruptedException {
		System.out.println("In Method");

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage loginPage = new LoginPage(wd);
		LoginAssistanceConfirmationJava LoginAssistance = new LoginAssistanceConfirmationJava(
				wd);
		Thread.sleep(2000);
		LoginPage loginAssistancePage = LoginAssistance.navigateToSignInPage();
		if (loginAssistancePage != null) {
			getLoginScenario().saveBean(PageConstants.SignIN_Page,
					loginAssistancePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading SignInPage page");
		}

	}

	@Given("^user is on Identity Assistance page selects Username and Password then user should be moved to Personal Identification page$")
	public void IdentityAssistance() throws InterruptedException {
		System.out.println("In Identity Method");
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		// LoginPage loginPage = new LoginPage(wd);
		PersonalIdentityUlayerPage PIUPage = new PersonalIdentityUlayerPage(wd);
		Thread.sleep(2000);
		PersonalIdentificationPageNew loginAssistancePage = PIUPage
				.navigateToPersonalIdentificationPage();
		if (loginAssistancePage != null) {
			getLoginScenario().saveBean(PageConstants.SignIN_Page,
					loginAssistancePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading Personal Identity Page");
		}

	}

	@Given("^user navigates to login assistance page PI page$")
	public void user_navigates_PersonalIdentity() throws InterruptedException {

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		PersonalIdentityUlayerPage PIUPage = new PersonalIdentityUlayerPage(wd);
		Thread.sleep(3000);
		PersonalIdentificationPageNew loginAssistancePage = PIUPage
				.navigateToPersonalIdentificationPage();
		if (loginAssistancePage != null) {
			getLoginScenario().saveBean(PageConstants.LOGIN_ASSISTANCE_PAGE,
					loginAssistancePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading LoginAssistance page");
		}

	}

	@Given("^user is on Identity Assistance page, moves to PI page and validates error messages$")
	public void ErrorrrValidation() throws InterruptedException {
		System.out.println("In error Method");
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		// LoginPage loginPage = new LoginPage(wd);
		PersonalIdentityUlayerPage PIUPage = new PersonalIdentityUlayerPage(wd);
		Thread.sleep(3000);
		PersonalIdentificationPageNew loginAssistancePage = PIUPage
				.navigateToPersonalIdentificationPage();
		PersonalIdentificationPageNew ErrorMessagesCorrect = loginAssistancePage
				.PIErrorMessageValidation();
		if (ErrorMessagesCorrect != null) {
			getLoginScenario().saveBean(PageConstants.SignIN_Page,
					ErrorMessagesCorrect);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading Personal Identity Page");
		}

	}

	/*
	 * @Then("^user clicks on continue button and user validates error messages$"
	 * ) public void ErrorValidation() throws InterruptedException {
	 * System.out.println("In Error Validation method Method");
	 * PersonalIdentityUlayerPage ErrorValidation = (PersonalIdentityUlayerPage)
	 * getLoginScenario() .getBean(PageConstants.LOGIN_ASSISTANCE_PAGE);
	 * PersonalIdentityUlayerPage ErrorMessagesCorrect =
	 * ErrorValidation.ErrorMessageValidation(); if (ErrorMessagesCorrect !=
	 * null) { getLoginScenario().saveBean(PageConstants.SamePage,
	 * ErrorMessagesCorrect); Assert.assertTrue(true); } else {
	 * Assert.fail("Error loading Personal Identity Page"); }
	 * 
	 * }
	 */

	@Given("^user is on Identity Assistance page and selects Nothing then user should be displayed error message$")
	public void ErrorMessageValidation() throws InterruptedException {
		System.out.println("In ErrorMessageValidation Method");
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		PersonalIdentityUlayerPage PIUPage = new PersonalIdentityUlayerPage(wd);
		Thread.sleep(2000);
		PersonalIdentificationPageNew loginAssistancePage = PIUPage
				.ErrorMessageValidation();
		if (loginAssistancePage != null) {
			getLoginScenario().saveBean(PageConstants.SignIN_Page,
					loginAssistancePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("No error message");
		}

	}

	@Given("^user is on Identity Assistance page and clicks cancel then user should be taken to sign in page$")
	public void SignInPageMovement() throws InterruptedException {
		System.out.println("In SignInvalidation Method");
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		PersonalIdentityUlayerPage PIUPage = new PersonalIdentityUlayerPage(wd);
		Thread.sleep(2000);
		LoginPage loginAssistancePage = PIUPage.SignInPageMovement();
		if (loginAssistancePage != null) {
			getLoginScenario().saveBean(PageConstants.SignIN_Page,
					loginAssistancePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading SignInPage page");
		}

	}

	@When("^the user selects the username or password checkbox in AARP site$")
	public void user_selects_username_password_checkbox_aarp(DataTable attribute) {
		String[] choiceSelected = attribute.getGherkinRows().get(0).getCells()
				.get(0).split(",");

		LoginAssistancePage loginAssistancePage = (LoginAssistancePage) getLoginScenario()
				.getBean(PageConstants.LOGIN_ASSISTANCE_PAGE);
		PersonalIdentificationPage personalIdentificationPage = loginAssistancePage
				.navigatesToPersonalDetailsPage(choiceSelected);
		if (personalIdentificationPage != null) {
			getLoginScenario().saveBean(
					PageConstants.PERSONAL_IDENTIFICATION_PAGE,
					personalIdentificationPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading personalIdentification page");
		}
	}

	@And("^the user enters the below member details in personal information page in AARP site$")
	public void user_enters_member_details_personal_infortmation_aarp(
			DataTable personalAttributes) {

		List<DataTableRow> personalAttributesRow = personalAttributes
				.getGherkinRows();
		Map<String, String> personalAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells()
					.get(0), personalAttributesRow.get(i).getCells().get(1));
		}

		PersonalIdentificationPage personalIdentificationPage = (PersonalIdentificationPage) getLoginScenario()
				.getBean(PageConstants.PERSONAL_IDENTIFICATION_PAGE);
		LoginAssitanceMessagePage loginAssitanceMessagePage = personalIdentificationPage
				.enterPersonalDetails(personalAttributesMap);
		if (loginAssitanceMessagePage != null) {
			getLoginScenario().saveBean(
					PageConstants.LOGIN_ASSISTANCE_MESSAGE_PAGE,
					loginAssitanceMessagePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading loginAssitanceMessage page");
		}

	}

	@Then("^the user validates the successfully mail sent message in AARP site$")
	public void user_validates_successfully_mail_sent_message_aarp() {
		LoginAssitanceMessagePage loginAssitanceMessagePage = (LoginAssitanceMessagePage) getLoginScenario()
				.getBean(PageConstants.LOGIN_ASSISTANCE_MESSAGE_PAGE);
		JSONObject loginAssistanceMessageActual = loginAssitanceMessagePage.loginAssistanceMessageJson;

		/* Get expected data */
		String fileName = LoginAssistanceCommonConstants.LOGIN_ASSISTANCE_FLOW;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator
				+ LoginAssistanceCommonConstants.LOGIN_ASSISTANCE_FLOW
				+ File.separator;
		JSONObject loginAssistanceMessageExpectedJson = MRScenario
				.readExpectedJson(fileName, directory);

		System.out.println("loginAssistanceMessageActual=====>"
				+ loginAssistanceMessageActual.toString());
		System.out.println("loginAssistanceMessageExpectedJson======>"
				+ loginAssistanceMessageExpectedJson.toString());
		try {
			JSONAssert.assertEquals(loginAssistanceMessageExpectedJson,
					loginAssistanceMessageActual, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^the user clicks continue button without entering anything$")
	public void user_clicks_continue_button_without_entering_anything() {

		PersonalIdentificationPage personalIdentificationPage = (PersonalIdentificationPage) getLoginScenario()
				.getBean(PageConstants.PERSONAL_IDENTIFICATION_PAGE);
		LoginAssitanceMessagePage loginAssitanceMessagePage = personalIdentificationPage
				.ContinueWithoutEnteringAnything();
		if (loginAssitanceMessagePage != null) {
			getLoginScenario().saveBean(
					PageConstants.LOGIN_ASSISTANCE_MESSAGE_PAGE,
					loginAssitanceMessagePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading loginAssitanceMessage page");
		}
	}

	@Then("^the user validates the successfully all fields error messages$")
	public void the_user_validates_the_successfully_all_fields_error_messages()
			throws InterruptedException {
		LoginAssitanceMessagePage loginAssitanceMessagePage = (LoginAssitanceMessagePage) getLoginScenario()
				.getBean(PageConstants.LOGIN_ASSISTANCE_MESSAGE_PAGE);
		LoginAssitanceMessagePage loginErrorMessages = loginAssitanceMessagePage
				.ErrorMessageValidation();
		if (loginAssitanceMessagePage != null) {
			getLoginScenario().saveBean(PageConstants.Error_Message,
					loginAssitanceMessagePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading loginAssitanceMessage page");
		}

	}

	/*
	 * @After public void tearDown() {
	 * 
	 * WebDriver wd = (WebDriver) getLoginScenario().getBean(
	 * CommonConstants.WEBDRIVER); //wd.quit(); getLoginScenario().flushBeans();
	 * }
	 */

}
