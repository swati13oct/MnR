
package acceptancetests.memberredesign.Profileandpreferences;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

//import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage2;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.profileandpreferences.CommunicationPreferencePage;
//import pages.member.bluelayer.ProfilePreferencesPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality: Profile And Preferences page
 */
public class ProfileandPreferencesUMSStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo : The user logs in to the member Redesign Portal
	 */
	@Given("^registered member with following details for Profile and Preferences flow$")
	public void login_with_member(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

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
		LoginPage2 loginPage = new LoginPage2(wd);

		AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWith(userName, pwd);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
		}

	}

	/**
	 * @throws InterruptedException
	 * @toDo : The user navigates to Profile and Preferences page from Rally
	 *       Dashboard
	 */
	@Then("^the user navigates to Profile and Preferences page$")
	public void user_navigate_toProfileandPreferencespage() throws InterruptedException {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);

		ProfileandPreferencesPage profilePreferencesPage = accountHomePage.navigateDirectToProfilePage();

		if (profilePreferencesPage != null) {

			getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE, profilePreferencesPage);
		} else
			Assert.fail("Profile preference page not loaded");

	}
	/*
	 * @Then("^the user navigates to Profile page") public void
	 * user_navigate_toProfilepage() { AccountHomePage accountHomePage =
	 * (AccountHomePage)
	 * getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
	 * profilePreferencesPage profilePreferencesPage =
	 * accountHomePage.navigateDirectToProfilePage();
	 * 
	 * if (profilePreferencesPage != null) {
	 * getLoginScenario().saveBean(PageConstantsMnR.
	 * PROFILE_AND_PREFERENCES_PAGE, profilePreferencesPage); } if
	 * (profilePreferencesPage == null) {
	 * System.out.println(" Variable is NULL!");
	 * 
	 * } }
	 */

	/**
	 * @toDo : The user validates the Account information of the logged in
	 *       member
	 */

	@And("^the user validates the Plan Name, Member name, Member ID and account section in UMS site")
	public void user_Validates_FED_PROFILE_MEMBERNAME_ID_AccountProfile() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		if (profilePreferencesPage == null) {
			System.out.println("Profile and Preferences page variable is Null");
		}
		profilePreferencesPage.validatePlanNameMemberidNameAccountProfile();

	}

	/**
	 * @toDo : The user checks the email section
	 */
	@Then("^the user validates the Email section in UMS site")
	public void user_Validates_email(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		String memberType = memberAttributesRow.get(0).getCells().get(1);
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateEmail(memberType);
		profilePreferencesPage.validateEmailEditElements(memberType);

	}

	/**
	 * @toDo : The user checks the elements that appear when the user clicks on
	 *       edit link of Account section
	 */
	@Then("^the user validates the elements on clicking the edit link")
	public void UserValidatesAccountEditOptions() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateAccountEditElements();

	}

	/**
	 * @toDo : The user checks the Password Update functionality
	 */
	@Then("^the user validates the functionality of save Button")
	public void UserValidatesAccountEditSaveButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		String Password = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		profilePreferencesPage.validateAccountEdit(Password);

	}

	@Then("^the user validate the temporary address section for ship member")
	public void UserValidatesTempAddressShip() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateTempAddressShip();
	}

	/**
	 * @toDo : The user checks the Password Update functionality without
	 *       entering the mandatory fields
	 */
	@Then("^the user clicks on save button without filling current and new password and the red mandatory message should come")
	public void UserValidatesclickingbutton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateSavebuttonclick();
	}

	/**
	 * @toDo : The user checks the functionality of cancel Button of the
	 *       password update window
	 */
	@Then("^the user validates the functionality of Cancel Button")
	public void UserValidatesAccountEditCancelButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateCancelButton();

	}

	/**
	 * @toDo : The user checks the Password Update functionality by entering an
	 *       invalid password
	 */
	@Then("^the user enters invalid password in new password field and clicks save button and the user should see expected error message - Password does not meet requirements")
	public void UserValidatesinvalidpassword() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.invalidpasswordvalidation();

	}

	/**
	 * @toDo : The user checks the Password Update functionality by entering
	 *       different password in confirm password field
	 */
	@Then("^the user enters different password in confirm password field and clicks save button and the user should see expected error message - Please enter the same value again")
	public void UserValidatesinvalidpassword2() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.invalidpasswordvalidation2();

	}

	/**
	 * @toDo : checks the see more ways to contact us link in the Need help
	 *       section
	 */

	@Then("^the user validates see more ways to contact us section")
	public void Uservalidatesneedhelpsection() {

		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateseemorewaystext();
	}

	/**
	 * @toDo : the user validates the page that opens up on clicking the see
	 *       more ways to contact us link in the Need help section
	 */

	@Then("^the user validates on clicking contact us link it should route to contact us page")
	public void uservalidatescontactuslink() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.clickcontactUslink();
	}

	/**
	 * @toDo : Validates the disclaimer link and the way it expands and
	 *       collapses
	 */

	@Then("^the user validates disclaimer link and on clicking disclaimer link it should expand and on again clicking it should collapse")
	public void uservalidatesdisclaimerlink() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		try {
			JSONObject profilenpreferencesActualJson = profilePreferencesPage.ProfileandPreferencesPageJson;
			// loginScenario.saveBean(ProfnPrefCommonConstants.MY_PROFILE_PREFERENCES_ACTUAL,
			// profilenpreferencesActualJson);
			System.out.println("profilenpreferencesActualJson---->" + profilenpreferencesActualJson);
			System.out.println(userName);
			// Get expected data
			String fileName = userName;
			String directory = CommonConstants.PROFILE_AND_PREFERNCES_PAGE_DIRECTORY;
			JSONObject myProfilenpreferencesexpectedjson = MRScenario.readExpectedJson(fileName, directory);
			// loginScenario.saveBean(ProfnPrefCommonConstants.MY_PROFILE_PREFERENCES_EXPECTED,
			// myProfilenpreferencesexpectedjson);
			profilePreferencesPage.clickOndisclaimerlink(myProfilenpreferencesexpectedjson);
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

	/**
	 * @toDo : Validates the need help section headers
	 */
	@Then("^the user validates the need help section")
	public void uservalidatesneedhelpsection() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateneedhelpheader();

	}

	/**
	 * @toDo : Validates the permanent address section header
	 */

	@Then("^the user validates permanent address section")
	public void uservalidatespermanentaddresssection() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatepermanentaddress();

	}

	@Then("^the user validates the address section")
	public void uservalidatestheaddresssection(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		String memberType = memberAttributesRow.get(0).getCells().get(1);
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatesAddressSection(memberType);

	}

	/**
	 * @toDo : Validates the contact us link and the page that opens up on
	 *       clicking the contact us link
	 */

	@Then("^the user validates contact us statement")
	public void uservalidatescontactuslinkpermanentadress() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatecontactuslink();
	}

	/**
	 * @toDo : Validates the elements of Email section
	 */
	@Then("^the user clicks on edit button")
	public void userclickemailedit() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateEmailEdit();
	}

	/**
	 * @toDo : Validates the email edit functionality without filling any of the
	 *       email text fields
	 */

	@Then("^the user clicks on save without filling both fields then the user should see red mandatory message")
	public void uservalidatemandatorymessage() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.emailblankfieldsvalidation();

	}

	/**
	 * @toDo : Validates the email edit functionality with valid email
	 */
	@Then("^the user fill new email address and click save then user should see new updated email on page")
	public void uservalidatesemailsavefunctionality() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateemailsavefunctionality();
	}

	/**
	 * @toDo : Validates the email edit functionality with invalid email
	 */

	@Then("^the user fill invalid email and clicks on save button then the user should see error message for invalid email")
	public void uservalidatesinvalidemailmessage() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateinvalidemailerrormessage();

	}

	/**
	 * @toDo : Validates the email edit functionality by entering different
	 *       email id's in confirm email box from new email address
	 */
	@Then("^the user fill different email id in confirm email box from new email address then error message should come")
	public void uservalidatesdifferentemail() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateduplicateerrormessage();
	}

	/**
	 * @toDo : Validates the Communication Preferences section headers
	 */
	@Then("^the user validates Communication Preferences section")
	public void uservalidatescommunicationpreferncessection() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validatecommunicationpreferences();
	}

	/**
	 * @toDo : Validates the Go green button in Communication Preferences
	 *       section
	 */
	@Then("^the user validates Go paperless button and on clicking button go green page should come")
	public void uservalidatesgogreenpagerouting() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validategogreenbutton();
	}

	/**
	 * @toDo : Clicks on Edit Preferences link under Communication Preferences
	 *       section
	 */
	@Then("^the user clicks on edit preferences link and validates the page")
	public void userClicksOnEditPrefLink() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		CommunicationPreferencePage communicationPrefPage = profilePreferencesPage
				.navigateToCommunicationPreferencePage();
		if (communicationPrefPage != null) {
			if (!communicationPrefPage.validatePage())
				Assert.fail("Error in validating communication preferences page");
			else
				getLoginScenario().saveBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE, communicationPrefPage);
		}
	}

	@Then("^the user changes the online preference and saves the change")
	public void userChangesOnlinePref() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);


		if(communicationPrefPage.changeAndVerifyOnlinePreference())
		{
			System.out.println("Communication preference online preference changed and verified");
			getLoginScenario().saveBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE,communicationPrefPage);
		}else
			Assert.fail("Error in changing and saving online preference");
	}
	@Then("^the user clicks on profile & preferences link to go back to Account settings page")
	public void navigateBackToAccountSettingsPage() {
		CommunicationPreferencePage communicationPreferencePage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		ProfileandPreferencesPage profilePreferencesPage = communicationPreferencePage.clickProfAndPrefLink();
		if (profilePreferencesPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE, profilePreferencesPage);
		}
	}

	/**
	 * @toDo : Validates the headers on Go green page
	 */
	@Then("^the user validates headers on green page")
	public void uservalidatesgogreenheader() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateheader();
	}

	/**
	 * @throws InterruptedException
	 * @toDo : Validates the back Link functionality from Go green page to
	 *       Profile page
	 */

	@Then("^the user validates on clicking Profilenpreferences arrow user should route to Profile and Preferences page")
	public void uservalidatespnplinkatthetop() throws InterruptedException {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatepnparrowlink();
	}

	/**
	 * @toDo : Validates the elements of Phone section
	 */

	@Then("^the user validates the Phone section")
	public void UserValidatesPhoneSection(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		String memberType = memberAttributesRow.get(0).getCells().get(1);
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatePhoneElements(memberType);

	}

	/**
	 * @toDo : Validates the elements on clicking the Phone edit Button
	 */
	@Then("^the user Clicks on the the Edit phone Link and validates the elements")
	public void UserClicksEditPhoneSection(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		String memberType = memberAttributesRow.get(0).getCells().get(1);
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatePhoneEditElements(memberType);

	}

	/**
	 * @toDo : Validates the presence of Cancel Button post clicking the edit
	 *       buttton of the Phone section
	 */

	@Then("^the user checks the Edit Button changes to Cancel Button")
	public void UserChecksSaveCancelButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateCancelElement();

	}

	/**
	 * @toDo : Validates the functionality of saving or updating Phone numbers
	 *       in phone section
	 */

	@Then("^the user checks the functionality of save Button in Phoneeditsection")
	public void UserValidatesPhoneSaveButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatePhoneSave();

	}

	/**
	 * @toDo : Validates the functionality of cancel Button which appears post
	 *       clicking the edit button in phone section
	 */

	@Then("^the user validate the functionality of Cancel Button In phoneeditSection")
	public void UserValidatesPhoneCancelButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatePhoneCancel();

	}

	/**
	 * @toDo : Validates the elements of the temporary address section
	 */
	@Then("^the user validates the temporary address section")
	public void tempaddress() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatetempaddressElements();

	}

	/**
	 * @toDo : Validates the elements that appear on clicking the edit button of
	 *       the temp address section
	 */

	@Then("^the user validates the fields and Buttons of temp address section")
	public void UserClicksEdittempaddressSection() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatetempaddressEditElements();

	}

	/**
	 * @toDo : Validates the Cancel button that appear on clicking the edit
	 *       button of the temp address section
	 */

	@Then("^the user checks the Edit Button on the top changes to Cancel Button")
	public void UserChecksTopCancelButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateTempAddressTopCancelElement();

	}

	/**
	 * @toDo : Validates the Save Functionality of the Temporary address section
	 */

	/**
	 * @toDo : Validates the Cancel Functionality of the temp address section
	 */

	@Then("^the user validates functionality of Cancel Button In Temporary adrress section")
	public void UserValidatestempaddressCancelButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatetempaddressCancel();

	}

	/**
	 * @toDo : Validates the presence of Go Paperless button
	 */
	@Then("^the user validates the presence of Go Paperless button")
	public void UserValidateGoPaperlessbutton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateGoPaperlessbutton();

	}

	/**
	 * @toDo : Validates the plan name on the Go Green page
	 */
	@Then("^the user validates the presence of Plan Name")
	public void UserValidatePlanName() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatePlanName();

	}

	/**
	 * @toDo : Validates the headers of the communication preferences section
	 */

	@Then("^the user validates the presence of Communication preferences header")
	public void UserValidatescommunicationpreferencesheader() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatecommunicationpreferencesheader();

	}

	/**
	 * @toDo : Validates the presence of Back to Profile and Preferences links
	 *       on Go green page
	 */
	@Then("^the user validates the presence of Back to Profile and Preferences links")
	public void UserValidatesBacktoPNPlink() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateBacktoPNPlink();

	}

	/**
	 * @toDo : Validates the Note section on Go green page
	 */
	@Then("^the user validates the Note section")
	public void UserValidatesNoteSection() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateNoteSection();

	}

	/**
	 * @toDo : Validates the I have read checkbox on Go green page
	 */
	@Then("^the user validates the I have read checkbox and check it")
	public void UserValidatesCheckbox() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateCheckbox();

	}

	/**
	 * @toDo : Validates the save preferences functionality on Go green page
	 */
	@Then("^the user validates the Save Preferences Button")
	public void UserValidatesSavePreferences() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateSavePreferences();

	}

	/**
	 * @toDo : Validates the Go green header on Go green page
	 */

	@Then("^the user validates the Go Green Header")
	public void UserValidatesGoGreenHeader() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateGoGreenHeader();

	}

	/**
	 * @toDo : Validates the Need help section for ship member
	 */

	@Then("^the user validate the need help section for ship member")
	public void UserValidatesNeedHelpShip() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateNeedHelpShip();

	}

	@Then("^the user validates the Presence of edit button in email section")
	public void UserValidatesEmailEditNokia() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateEmailEditNokia();

	}

	@Then("^the user validates the Presence of edit button in Phone section")
	public void UserValidatesPhoneEditNokia() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatePhoneEditNokia();

	}

	@Then("^the user validates the Presence of edit button in Temporary Address section")
	public void UserValidatesTempAddEditNokia() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateTempAddEditNokia();

	}

	@Then("^the user validates the Presence of edit button in Mailing Address section$")
	public void UserValidatesMailAddEditNokia() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateMailAddEditButton();

	}

	@Then("^the user validates the fields under add mailing address button$")
	public void validateElementsInAddMailingAddress() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateMailingAddressFields();
	}

	/**
	 * @throws InterruptedException
	 * @toDo : The user logs in to the member Redesign Portal
	 */

	@Given("^registered member with following details$")
	public void registered_member_with_following_details(DataTable memberAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

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
		LoginPage2 loginPage = new LoginPage2(wd);

		AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWithHsid(userName, pwd);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
		}

	}

	/**
	 * @toDo : The user enters the security questions
	 */

	@When("^I enter the security questions$")
	public void i_enter_the_security_questions(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String friendname = memberAttributesMap.get("friendname");
		String favouritecolor = memberAttributesMap.get("favouritecolor");
		String PhoneNumber = memberAttributesMap.get("PhoneNumber");

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);

		accountHomePage.validateTheSecurityQues(friendname, favouritecolor, PhoneNumber);

	}

	/**
	 * @toDo : The user clicks on health safe Id password
	 */

	@When("^I click the HEALTHSAFE ID PASSWORD link and validate username and password and verify edit password link$")
	public void i_click_the_HEALTHSAFE_ID_PASSWORD_link() throws InterruptedException {

		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateHealthSafeIdLink();
		profilePreferencesPage.validateEditPasswordLinkBox();
	}

	/**
	 * @toDo : The user should see the breadcrumb in the upper left side
	 */

	@Then("^I should see the breadcrumb  in the upper left side of the page$")
	public void i_should_see_the_breadcrumb_in_the_upper_left_side_of_the_page() throws InterruptedException {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateBreadCrumb();

	}

	/**
	 * @toDo : The functionality of Bread crumb
	 */
	@And("^clicking the link should lead me back to the Account Settings page of the member site$")
	public void clicking_the_link_should_lead_me_back_to_the_Account_Settings_page_of_the_Medica_member_site() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencesPage profAndPrefPage = profilePreferencesPage.validateBreadCrumbClick();
		if (profAndPrefPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE, profAndPrefPage);
		}

	}

	/**
	 * @toDo : The functionality of health safe Id account recovery
	 */

	@Then("^I click the HEALTHSAFE ID ACCOUNT RECOVERY AND SECURITY link$")
	public void i_click_the_HEALTHSAFE_ID_ACCOUNT_RECOVERY_AND_SECURITY_link() throws InterruptedException {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateHealthSafeAccountLink();

	}

	@And("^I should see the EPMP i frame on profile page$")
	public void i_should_see_the_EPMP_i_frame_on_profile_page() {
		// Write code here that turns the phrase above into concrete actions
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateEpmpIframe();

	}

	@And("^I should see the communicationpreferncessection$")
	public void i_should_see_the_communicationpreferncessection() {
		// Write code here that turns the phrase above into concrete actions
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validatecommunicationpreferncessection();
	}

	@And("^I should be able to see edit email address and to view read only HSID email$")
	public void i_should_be_able_to_view_emailaddress_section() {
		// Write code here that turns the phrase above into concrete actions
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateEmailaddressSection();
		profilePreferencesPage.validateEmailEditUpdates();
	}

	@And("^I should be able to view and edit phone numbers$")
	public void iShouldBeAbleToViewAndEditPhoneNumbers() {

		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validatePhoneSection();
		profilePreferencesPage.validatePhoneUpdate();

	}

	@And("^the user validate the email section on profile page for ship member$")
	public void theUserValidatesTheEmailSectionOnProfilePageForShipMember() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateEmailSectionForShip();

	}

	@And("^the user validate the Phone section on profile page for ship member$")
	public void theUserValidatesThePhoneSectionOnProfilePageForShipMember() {

		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validatePhoneSectionForShip();
	}

	@And("^the user validate the Permanent Address section on profile page for ship member$")
	public void theUserValidatesThePermanentAddressSectionOnProfilePageForShipMember() throws Throwable {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validatePermanentAddressSectionForShip();
	}

	@And("^the user validate the temporary section on profile page for ship member$")
	public void theUserValidatesTheTemporarySectionOnProfilePageForShipMember() throws Throwable {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateTempAddressSectionForShip();

	}
	@And("^I should not be able to edit the Phone numbers section for specific group members$")
	public void i_should_not_be_able_to_edit_phoneNumbers_for_Specific_Group_Members(DataTable groupAttributes) {
		// Write code here that turns the phrase above into concrete actions
		List<DataTableRow> memberAttributesRow = groupAttributes.getGherkinRows();
		//Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

				
		String groupPlanName = memberAttributesMap.get("Group Plan Name");
		System.out.println(groupPlanName);
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateGroupsPhoneNumbersSection(groupPlanName);

	}

	
	/** 
	 * @toDo : The user checks the email section 
	 */
	@Then("^the user validate the Email section in UMS site")
	public void user_Validate_email() {

		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateEmailForPCPMedica();
		profilePreferencesPage.validateEmailEditElements();

	}
	
	
	
	@Then("^the user validates that  Communication Preferences section doesn't come for PCP medica member$")
	public void userValidatescommunicationpreferncesSectionForPCP() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateCommunicationPreferencesForPcpMedica();
	}
	
	
	@Then("^the user validates that  Communication Preferences section comes up for Ship Member$")
	public void userValidatescommunicationpreferncesSectionForShip() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateCommunicationPreferencesForShip();
	}
	

	@Then("^the user validates the Go Green page for a ship member$")
	public void userValidatesGoGreenSectionForShip() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateGoGreenSectionForShip();
	}

	@Then("^the user validates that  Communication Preferences section doesn't come for terminated members$")
	public void userValidatescommunicationpreferncesSectionForTerminated() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateCommunicationPreferencesForTerminated();
	}


}
