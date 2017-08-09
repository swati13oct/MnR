package acceptancetests.ProfileandPreferencesjenkins.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
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
import pages.member.bluelayer.AccountHomePage;

import pages.member.bluelayer.LoginPage2;
import pages.member.bluelayer.ProfilePreferencesPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;

import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

/**
 * @author akapoo18
 *
 */
public class ProfileandPreferencesUMSStepDefinition {

	@Autowired
	MRScenario loginScenario;

	private String userName = null;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered UHC with following details for Profile and Preferences flow in UMS site$")
	public void login_with_member(DataTable memberAttributes) {
		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();

		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
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
			this.userName = userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		// MRScenario.keyEvent(wd);

		LoginPage2 loginPage = new LoginPage2(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}

		// JSONObject accountHomeActualJson = null;

		/* Get expected data */
		/*
		 * Map<String,JSONObject> expectedDataMap =
		 * loginScenario.getExpectedJson(userName); JSONObject
		 * accountHomeExpectedJson =
		 * accountHomePage.getExpectedData(expectedDataMap);
		 * 
		 * if (accountHomePage != null) {
		 * getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		 * getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
		 * accountHomePage); Assert.assertTrue(true); accountHomeActualJson =
		 * accountHomePage.accountHomeJson; }
		 * 
		 * try { JSONAssert.assertEquals(accountHomeExpectedJson,
		 * accountHomeActualJson, true); } catch (JSONException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
		 * expectedDataMap);
		 */

	}

	@Then("^the user navigates to Profile and Preferences page")
	public void user_navigate_toProfileandPreferencespage() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ProfilePreferencesPage ProfilePreferencesPage = accountHomePage.navigateDirectToProfilePreferencesPage();

		if (ProfilePreferencesPage != null) {
			getLoginScenario().saveBean(PageConstants.ProfilePreferencesPage, ProfilePreferencesPage);
		}
		if (ProfilePreferencesPage == null) {
			System.out.println(" Variable is NULL");

		}
	}

	@And("^the user validates the Plan Name, Member name, Member ID and account section in UMS site")
	public void user_Validates_FED_PROFILE_MEMBERNAME_ID_AccountProfile() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		if (ProfilePreferencesPage == null) {
			System.out.println(" Variable is NULL");
		}
		ProfilePreferencesPage.validatePlanNameMemberidNameAcountProfile();

	}

	@Then("^the user validates the Email section in UMS site")
	public void user_Validates_email() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateEmail();

	}

	@Then("^the user validates the elements on clicking the edit link")
	public void UserValidatesAccountEditOptions() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		ProfilePreferencesPage.validateAccountEditElements();

	}

	@Then("^the user validates the functionality of save Button")
	public void UserValidatesAccountEditSaveButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		String Password = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		ProfilePreferencesPage.validateAccountEdit(Password);

	}

	@Then("^the user validates the functionality of Cancel Button")
	public void UserValidatesAccountEditCancelButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateCancelButton();

	}

	@Then("^the user validates the elements on clicking the email edit link")
	public void UserValidatesEmailEditOptions() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateEmailEditElements();

	}

	@Then("^the user validates the functionality of save Button in the email section")
	public void UserValidatesEmailEditSaveButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.SaveEmailEdit();

	}

	@Then("^the user validates the functionality of Cancel Button in the email section")
	public void UserValidatesEmailEditCancelButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateEmailCancelButton();

	}

}
