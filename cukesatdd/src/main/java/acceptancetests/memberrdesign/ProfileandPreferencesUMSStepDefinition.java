
package acceptancetests.memberrdesign;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.DashboardPage;
import pages.member.bluelayer.LoginPage2;
import pages.member.bluelayer.ProfilePreferencesPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.profandpref.data.ProfnPrefCommonConstants;
import atdd.framework.MRScenario;
import cucumber.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

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

	@Given("^registered member with following details for Profile and Preferences flow$")
	public void login_with_member(DataTable memberAttributes) throws InterruptedException {
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
		DashboardPage dashboardPage = (DashboardPage) loginPage.loginWith(userName, pwd);

		if (dashboardPage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.dashboardPage, dashboardPage);
				
		}
		else
		{
		System.out.println("NULL here");
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

		DashboardPage dashboardPage = (DashboardPage) getLoginScenario().getBean(PageConstants.dashboardPage);
		ProfilePreferencesPage ProfilePreferencesPage = dashboardPage.navigateDirectToProfilePage();

		if (ProfilePreferencesPage != null) {
			getLoginScenario().saveBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE, ProfilePreferencesPage);

		}

		else

		{
			System.out.println("NULL PNP ");
		}

	}

	/*@Then("^the user navigates to Profile page")
	public void user_navigate_toProfilepage() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ProfilePreferencesPage ProfilePreferencesPage = accountHomePage.navigateDirectToProfilePage();

		if (ProfilePreferencesPage != null) {
			getLoginScenario().saveBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE, ProfilePreferencesPage);
		}
		if (ProfilePreferencesPage == null) {
			System.out.println(" Variable is NULL!");

		}
	}*/

	@And("^the user validates the Plan Name, Member name, Member ID and account section in UMS site")
	public void user_Validates_FED_PROFILE_MEMBERNAME_ID_AccountProfile() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		if (ProfilePreferencesPage == null) {
			System.out.println(" Variable is NULL");
		}
		ProfilePreferencesPage.validatePlanNameMemberidNameAcountProfile();

	}

	@Then("^the user validates the Email section in UMS site")
	public void user_Validates_email() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateEmail();
		ProfilePreferencesPage.validateEmailEditElements();

	}

	@Then("^the user validates the elements on clicking the edit link")
	public void UserValidatesAccountEditOptions() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		ProfilePreferencesPage.validateAccountEditElements();

	}

	@Then("^the user validates the functionality of save Button")
	public void UserValidatesAccountEditSaveButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		String Password = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		ProfilePreferencesPage.validateAccountEdit(Password);

	}

	@Then("^the user clicks on save button without filling current and new password and the red mandatory message should come")
	public void UserValidatesclickingbutton() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		ProfilePreferencesPage.validateSavebuttonclick();
	}

	@Then("^the user validates the functionality of Cancel Button")
	public void UserValidatesAccountEditCancelButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateCancelButton();

	}

	@Then("^the user enters invalid password in new password field and clicks save button and the user should see expected error message - Password does not meet requirements")
	public void UserValidatesinvalidpassword() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.invalidpasswordvalidation();

	}

	@Then("^the user enters different password in confirm password field and clicks save button and the user should see expected error message - Please enter the same value again")
	public void UserValidatesinvalidpassword2() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.invalidpasswordvalidation2();

	}

	@Then("^the user validates see more ways to contact us section")
	public void Uservalidatesneedhelpsection() {

		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateseemorewaystext();
	}

	@Then("^the user validates on clicking contact us link it should route to contact us page")
	public void uservalidatescontactuslink() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.clickcontactUslink();
	}

	@Then("^the user validates disclaimer link and on clicking disclaimer link it should expand and on again clicking it should collapse")
	public void uservalidatesdisclaimerlink() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		try {
			JSONObject profilenpreferencesActualJson = ProfilePreferencesPage.ProfileandPreferencesPageJson;
			loginScenario.saveBean(ProfnPrefCommonConstants.MY_PROFILE_PREFERENCES_ACTUAL,
					profilenpreferencesActualJson);
			System.out.println("profilenpreferencesActualJson---->" + profilenpreferencesActualJson);
			System.out.println(userName);
			// Get expected data
			String fileName = userName;
			String directory = CommonConstants.PROFILE_AND_PREFERNCES_PAGE_DIRECTORY;
			JSONObject myProfilenpreferencesexpectedjson = MRScenario.readExpectedJson(fileName, directory);
			loginScenario.saveBean(ProfnPrefCommonConstants.MY_PROFILE_PREFERENCES_EXPECTED,
					myProfilenpreferencesexpectedjson);
			ProfilePreferencesPage.clickOndisclaimerlink(myProfilenpreferencesexpectedjson);
			System.out.println("profilenpreferencesExpectedJson---->" + myProfilenpreferencesexpectedjson);

			/*
			 * if (profilenpreferencesActualJson != null &&
			 * myProfilenpreferencesexpectedjson != null) {
			 * JSONAssert.assertEquals(myProfilenpreferencesexpectedjson,
			 * profilenpreferencesActualJson, true); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^the user validates the need help section")
	public void uservalidatesneedhelpsection() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateneedhelpheader();

	}

	@Then("^the user validates permanent address section")
	public void uservalidatespermanentaddresssection() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatepermanentaddress();

	}

	@Then("^the user clicks on contact us then contact us page should come")
	public void uservalidatescontactuslinkpermanentadress() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatecontactuslink();

	}

	@Then("^the user clicks on edit button")
	public void userclickemailedit() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateEmail();
	}

	@Then("^the user clicks on save without filling both fields then the user should see red mandatory message")
	public void uservalidatemandatorymessage() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.emailblankfieldsvalidation();

	}

	@Then("^the user fill new email address and click save then user should see new updated email on page")
	public void uservalidatesemailsavefunctionality() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateemailsavefunctionality();
	}

	@Then("^the user fill invalid email and clicks on save button then the user should see error message for invalid email")
	public void uservalidatesinvalidemailmessage() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateinvalidemailerrormessage();

	}

	@Then("^the user fill different email id in confirm email box from new email address then error message should come")
	public void uservalidatesdifferentemail() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateduplicateerrormessage();
	}

	@Then("^the user validates Communication Preferences section")
	public void uservalidatescommunicationpreferncessection() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatecommunicationpreferences();

	}

	@Then("^the user validates Go paperless button and on clicking button go green page should come")
	public void uservalidatesgogreenpagerouting() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validategogreenbutton();
	}

	@Then("^the user validates headers on green page")
	public void uservalidatesgogreenheader() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateheader();
	}

	@Then("^the user validates on clicking Profilenpreferences arrow user should route to Profile and Preferences page")
	public void uservalidatespnplinkatthetop() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatepnparrowlink();
	}

	@Then("^the user validates the Phone section")
	public void UserValidatesPhoneSection() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatePhoneElements();

	}

	@Then("^the user Clicks on the the Edit Link and validates the elements")
	public void UserClicksEditPhoneSection() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatePhoneEditElements();

	}

	@Then("^the user checks the Edit Button changes to Cancel Button")
	public void UserChecksSaveCancelButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateCancelElement();

	}

	@Then("^the user validates the functionality of save Button in Phoneeditsection")
	public void UserValidatesPhoneSaveButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatePhoneSave();

	}

	@Then("^the user validates the functionality of Cancel Button In phoneeditSection")
	public void UserValidatesPhoneCancelButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatePhoneCancel();

	}

	@Then("^the user validates the temporary address section")
	public void tempaddress() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatetempaddressElements();

	}

	@Then("^the user validates the fields and Buttons of temp address section")
	public void UserClicksEdittempaddressSection() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatetempaddressEditElements();

	}

	@Then("^the user checks the Edit Button on the top changes to Cancel Button")
	public void UserChecksTopCancelButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateTempAddressTopCancelElement();

	}

	@Then("^the user validates the functionality of save Button in Temporary adrress section")
	public void UserValidatestempaddressSaveButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatetempaddressSave();

	}

	@Then("^the user validates the functionality of Cancel Button In Temporary adrress section")
	public void UserValidatestempaddressCancelButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatetempaddressCancel();

	}

	@Then("^the user validates the presence of Go Paperless button")
	public void UserValidateGoPaperlessbutton() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateGoPaperlessbutton();

	}

	@Then("^the user validates the presence of Plan Name")
	public void UserValidatePlanName() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatePlanName();

	}

	@Then("^the user validates the presence of Communication preferences header")
	public void UserValidatescommunicationpreferencesheader() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatecommunicationpreferencesheader();

	}

	@Then("^the user validates the presence of Back to Profile and Preferences links")
	public void UserValidatesBacktoPNPlink() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateBacktoPNPlink();

	}

	@Then("^the user validates the Note section")
	public void UserValidatesNoteSection() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateNoteSection();

	}

	@Then("^the user validates the I have read checkbox and check it")
	public void UserValidatesCheckbox() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateCheckbox();

	}

	@Then("^the user validates the Save Preferences Button")
	public void UserValidatesSavePreferences() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateSavePreferences();

	}

	@Then("^the user validates the Go Green Header")
	public void UserValidatesGoGreenHeader() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.member.bluelayer.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateGoGreenHeader();

	}
}
