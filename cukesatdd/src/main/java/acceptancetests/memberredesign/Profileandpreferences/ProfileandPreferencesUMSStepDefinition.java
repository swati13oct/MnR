
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

//import pages.member_deprecated.bluelayer.AccountHomePage;
import pages.member_deprecated.bluelayer.LoginPage2;
import pages.memberrdesignVBF.ProfilePreferencesPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.profileandpreferences.CommunicationPreferencePage;
//import pages.member_deprecated.bluelayer.ProfilePreferencesPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import pages.regression.testharness.TestHarness;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
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
   public String planName;
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
		ProfileandPreferencesPage profilePreferencesPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			profilePreferencesPage = testHarness.navigateDirectToProfilePageFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			profilePreferencesPage = accountHomePage.navigateDirectToProfilePage();
		}
		if (profilePreferencesPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE, profilePreferencesPage);
		} else {
			Assert.fail("Profile preference page not loaded");
		}
		/* tbd-remove
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		ProfileandPreferencesPage profilePreferencesPage = accountHomePage.navigateDirectToProfilePage();

		if (profilePreferencesPage != null) {

			getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE, profilePreferencesPage);
		} else
			Assert.fail("Profile preference page not loaded");
	 */
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

	@And("^the user validates the Plan Name, Member name, Member ID and account section$")
	public void user_Validates_FED_PROFILE_MEMBERNAME_ID_AccountProfile() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		if (profilePreferencesPage == null) {
			System.out.println("Profile and Preferences page variable is Null");
		}
		planName=profilePreferencesPage.validatePlanNameMemberidNameAccountProfile();
		getLoginScenario().saveBean(CommonConstants.PLAN_NAME_ON_PROFILE_PAGE, planName);


	}

	/**
	 * @toDo : The user checks the email section
	 */
	@Then("^the user validates the Email section in UMS site$")
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
	
	@Then("^the user validates the elements on clicking the edit link$")
	public void UserValidatesAccountEditOptions() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateAccountEditElements();

	}

	/**
	 * @toDo : The user checks the Password Update functionality
	 */
	@Then("^the user validates the functionality of save Button$")
	public void UserValidatesAccountEditSaveButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		String Password = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		profilePreferencesPage.validateAccountEdit(Password);

	}

	@Then("^the user validate the temporary address section for ship member$")
	public void UserValidatesTempAddressShip() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateTempAddressShip();
	}
	
	@Then("^the user validate the temporary address section for  member$")
	public void UserValidatesTempAddress() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateTempAddress();
	}

	/**
	 * @toDo : The user checks the Password Update functionality without
	 *       entering the mandatory fields
	 */
	@Then("^the user clicks on save button without filling current and new password and the red mandatory message should come$")
	public void UserValidatesclickingbutton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateSavebuttonclick();
	}

	/**
	 * @toDo : The user checks the functionality of cancel Button of the
	 *       password update window
	 */
	@Then("^the user validates the functionality of Cancel Button$")
	public void UserValidatesAccountEditCancelButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateCancelButton();

	}

	/**
	 * @toDo : The user checks the Password Update functionality by entering an
	 *       invalid password
	 */
	@Then("^the user enters invalid password in new password field and clicks save button and the user should see expected error message - Password does not meet requirements$")
	public void UserValidatesinvalidpassword() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.invalidpasswordvalidation();

	}

	/**
	 * @toDo : The user checks the Password Update functionality by entering
	 *       different password in confirm password field
	 */
	@Then("^the user enters different password in confirm password field and clicks save button and the user should see expected error message - Please enter the same value again$")
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

	@Then("^the user validates on clicking contact us link it should route to contact us page$")
	public void uservalidatescontactuslink() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.clickcontactUslink();
	}

	/**
	 * @toDo : Validates the disclaimer link and the way it expands and
	 *       collapses
	 */

	@Then("^the user validates disclaimer link and on clicking disclaimer link it should expand and on again clicking it should collapse$")
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
	@Then("^the user validates the need help section$")
	public void uservalidatesneedhelpsection() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateneedhelpheader();

	}
	@Then("^the ship user validates the need help section$")
	public void uservalidatesneedhelpsectionShip() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateneedhelpheaderShip();

	}

	/**
	 * @toDo : Validates the permanent address section header
	 */

	@Then("^the user validates permanent address section$")
	public void uservalidatespermanentaddresssection() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatepermanentaddress();

	}

	@Then("^the user validates the address section$")
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

	@Then("^the user validates contact us statement$")
	public void uservalidatescontactuslinkpermanentadress() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatecontactuslink();
	}

	/**
	 * @toDo : Validates the elements of Email section
	 */
	@Then("^the user clicks on edit button$")
	public void userclickemailedit() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateEmailEdit();
	}

	/**
	 * @toDo : Validates the email edit functionality without filling any of the
	 *       email text fields
	 */

	@Then("^the user clicks on save without filling both fields then the user should see red mandatory message$")
	public void uservalidatemandatorymessage() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.emailblankfieldsvalidation();

	}

	/**
	 * @toDo : Validates the email edit functionality with valid email
	 */
	@Then("^the user fill new email address and click save then user should see new updated email on page$")
	public void uservalidatesemailsavefunctionality() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateemailsavefunctionality();
	}

	/**
	 * @toDo : Validates the email edit functionality with invalid email
	 */

	@Then("^the user fill invalid email and clicks on save button then the user should see error message for invalid email$")
	public void uservalidatesinvalidemailmessage() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateinvalidemailerrormessage();

	}

	/**
	 * @toDo : Validates the email edit functionality by entering different
	 *       email id's in confirm email box from new email address
	 */
	@Then("^the user fill different email id in confirm email box from new email address then error message should come$")
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
	 * @toDo : Clicks on Edit Preferences link under Communication Preferences
	 *       section
	 */
	@Then("^the user clicks on edit preferences link$")
	public void userClicksOnEditPrefLink() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		CommunicationPreferencePage communicationPrefPage = profilePreferencesPage
				.navigateToCommunicationPreferencePage();
		if (communicationPrefPage != null) {
				getLoginScenario().saveBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE, communicationPrefPage);
		}
		else {
			Assert.fail("Preference page is not loaded");
	}
		
		
	}
	
	@Then("^the user validates preferences page for non epmp")
	public void userValidatesNonEPMPPrefPage() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		CommunicationPreferencePage communicationPrefPage = profilePreferencesPage
				.navigateToCommunicationPreferencePage();
		if (communicationPrefPage != null) {
			if (!communicationPrefPage.validatePageNonEPMP())
				Assert.fail("Error in validating communication preferences page");
			else
				getLoginScenario().saveBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE, communicationPrefPage);
		}
	}
	
	/**
	 * @toDo : Clicks on Edit Preferences link under Communication Preferences for ship
	 *       section
	 */
	@Then("^the user clicks on edit preferences link page for ship$")
	public void the_user_clicks_on_edit_preferences_link_page_for_ship() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		CommunicationPreferencePage communicationPrefPage = profilePreferencesPage
				.navigateToCommunicationPreferencePage();
		if (communicationPrefPage != null) {
			if (!communicationPrefPage.validatePageForShip())
				Assert.fail("Error in validating communication preferences page");
			else
				getLoginScenario().saveBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE, communicationPrefPage);
		}
	}

	

	@Then("^the user clicks on profile & preferences link to go back to Account settings page$")
	public void navigateBackToAccountSettingsPage() {
		CommunicationPreferencePage communicationPreferencePage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		ProfileandPreferencesPage profilePreferencesPage = communicationPreferencePage.clickProfAndPrefLink();
		if (profilePreferencesPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE, profilePreferencesPage);
		}
	}

	

	/**
	 * @toDo : Validates the elements of Phone section
	 */

	@Then("^the user validates the Phone section$")
	public void UserValidatesPhoneSection(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		String memberType = memberAttributesRow.get(0).getCells().get(1);
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatePhoneElements(memberType);

	}
	
	/**
	 * @toDo : Validates the elements of Phone section
	 */

	@Then("^the user validates the Phone section with iframe$")
	public void UserValidatesPhoneSectionIframe(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		String memberType = memberAttributesRow.get(0).getCells().get(1);
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatePhoneElementsWithIframe(memberType);

	}

	/**
	 * @toDo : Validates the elements on clicking the Phone edit Button
	 */
	@Then("^the user Clicks on the the Edit phone Link and validates the elements$")
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

	@Then("^the user checks the Edit Button changes to Cancel Button$")
	public void UserChecksSaveCancelButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateCancelElement();

	}
	
	@Then("^the Ship user checks the Edit Button changes to Cancel Button$")
	public void UserChecksSaveCancelButtonShip() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateCancelElementShip();

	}

	/**
	 * @toDo : Validates the functionality of saving or updating Phone numbers
	 *       in phone section
	 */

	@Then("^the user checks the functionality of save Button in Phoneeditsection$")
	public void UserValidatesPhoneSaveButton(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		String memberType = memberAttributesRow.get(0).getCells().get(1);
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validatePhoneSave(memberType);

	}

	/**
	 * @toDo : Validates the functionality of cancel Button which appears post
	 *       clicking the edit button in phone section
	 */

	@Then("^the user validate the functionality of Cancel Button In phoneeditSection$")
	public void UserValidatesPhoneCancelButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatePhoneCancel();

	}

	/**
	 * @toDo : Validates the elements of the temporary address section
	 */
	@Then("^the user validates the temporary address section$")
	public void tempaddress() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatetempaddressElements();

	}

	/**
	 * @toDo : Validates the elements that appear on clicking the edit button of
	 *       the temp address section
	 */

	@Then("^the user validates the fields and Buttons of temp address section$")
	public void UserClicksEdittempaddressSection() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatetempaddressEditElements();

	}

	/**
	 * @toDo : Validates the Cancel button that appear on clicking the edit
	 *       button of the temp address section
	 */

	@Then("^the user checks the Edit Button on the top changes to Cancel Button$")
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

	@Then("^the user validates functionality of Cancel Button In Temporary adrress section$")
	public void UserValidatestempaddressCancelButton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatetempaddressCancel();

	}

	/**
	 * @toDo : Validates the presence of Go Paperless button
	 */
	@Then("^the user validates the presence of Go Paperless button$")
	public void UserValidateGoPaperlessbutton() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateGoPaperlessbutton();

	}

	/**
	 * @toDo : Validates the headers of the communication preferences section
	 */

	@Then("^the user validates the presence of Communication preferences header$")
	public void UserValidatescommunicationpreferencesheader() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatecommunicationpreferencesheader();

	}
	

	/**
	 * @toDo : Validates the Need help section for ship member
	 */

	@Then("^the user validate the need help section for ship member$")
	public void UserValidatesNeedHelpShip() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateNeedHelpShip();

	}

	@Then("^the user validates the Presence of edit button in email section$")
	public void UserValidatesEmailEditNokia() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateEmailEditNokia();

	}

	@Then("^the user validates the Presence of edit button in Phone section$")
	public void UserValidatesPhoneEditNokia() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatePhoneEditNokia();

	}

	@Then("^the user validates the Presence of edit button in Temporary Address section$")
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
		if(MRScenario.environment.contains("team-a")) {
			System.out.println("HSID password related step is not supported on lower env, skipping...");
			return;
		}
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.clickHealthSafeIdLink();
		profilePreferencesPage.validateEditPasswordLinkBox();
	}
	
	@When("^I validate the healthsafe ID links$")
	public void clickHealthSafeIdLinks() throws InterruptedException{
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateHealthSafeIdLinks();
	}
	
//	@Then ("^the user clicks on save button without filling current and new password and the red mandatory message should come$")
//	public void empty_value_password_field() throws InterruptedException {
//
//		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
//				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
//
//		profilePreferencesPage.validateEmptyPasswordLinkBox();
//		
//	}
	/**
	 * @toDo : The user should see the breadcrumb in the upper left side
	 */

	@Then("^I should see the breadcrumb  in the upper left side of the page$")
	public void i_should_see_the_breadcrumb_in_the_upper_left_side_of_the_page() throws InterruptedException {
		if(MRScenario.environment.contains("team-a")) {
			System.out.println("HSID password related step is not supported on lower env, skipping...");
			return;
		}
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateBreadCrumb();

	}

	/**
	 * @toDo : The functionality of Bread crumb
	 */
	@And("^clicking the link should lead me back to the Account Settings page of the member site$")
	public void clicking_the_link_should_lead_me_back_to_the_Account_Settings_page_of_the_Medica_member_site() {
		if(MRScenario.environment.contains("team-a")) {
			System.out.println("HSID password related step is not supported on lower env, skipping...");
			return;
		}
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
		if(MRScenario.environment.contains("team-a")) {
			System.out.println("HSID password related step is not supported on lower env, skipping...");
			return;
		}
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
                        .getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateHealthSafeAccountLink();
		profilePreferencesPage.validateBreadCrumbClick();
    }

	@And("^I should see the EPMP i frame on profile page$")
	public void i_should_see_the_EPMP_i_frame_on_profile_page() {
		// Write code here that turns the phrase above into concrete actions
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateEpmpIframe();

	}

	@And("^I should see the communication prefernces section$")
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
		profilePreferencesPage.validateEmailUpdateSectionForShip();

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
		// Map<String, String> memberAttributesMap = new LinkedHashMap<String,
		// String>();
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
	@Then("^the user validate the Email section in UMS site$")
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
	
	
	@Then("^the user validates that  Communication Preferences section doesn't come for SSUP member$")
	public void userValidatescommunicationpreferncesSectionForSsupUser() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateCommunicationPreferencesForSsupUser();
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
		
	@And("^the user should not be able to edit the Phone numbers$")
	public void userValidatesThePhoneSectionWithoutEditsAllowed() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validatePhoneSectionWithoutEditAllowed();
	}

	@Then("^the user should not be able to add or update temporary address$")
	public void userValidatestheTemporaryaddressSectioWithoutEditsAllowedn() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateTemporaryAddressSectionWithoutEditAllowed();
	}

	@Then("^the user should not be able to add or update Mailing address$")
	public void userValidatestheMailindAddressSectionWithoutEditsAllowed() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateMailingAddressSectionWithoutEditAllowed();
	}

	@And("^the user select (.*?) for (.*?)$")
	public void user_select_electronic_delivery_for_Plan_Documents(String delivery,String preference) {
		CommunicationPreferencePage communicationPreferencePage = (CommunicationPreferencePage) getLoginScenario().
				getBean(PageConstants.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencePage = communicationPreferencePage.selectPreferences(delivery, preference);
		getLoginScenario().saveBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE, communicationPreferencePage);
	}
	
	@Then("^the user validates that Communication Preferences section for Ship$")
	public void userValidatescommunicationpreferncesForShip(DataTable givenAttributes) {
		/* Reading the given attribute from feature file */
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planName = memberAttributesMap.get("Plan Name");
		CommunicationPreferencePage communicationPreferencePage = (CommunicationPreferencePage) getLoginScenario().getBean(PageConstants.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencePage.validateCommunicationPreferencesForShip(planName);
	}
	
	@Then("^the user navigates to Communication Preferences page$")
	public void user_navigate_toCommunicationPreferencespage(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String memberType = memberAttributesMap.get("Member Type");
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		CommunicationPreferencePage communicationPreferencePage = profilePreferencesPage.navigateToCommunicationPreferencePage();
		if (memberType.toLowerCase().contains("combo"))
			communicationPreferencePage.clickCombTab(planType);
		getLoginScenario().saveBean(PageConstants.COMMUNICATION_PREFERENCE_PAGE, communicationPreferencePage);
	}
	
	@And("^the user validates that Communication Preferences section does not display")
	public void uservalidateNocommunicationPreferncesSection(DataTable givenAttributes) {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		//note: for SSUP case, check to see if combo tab then go to SSUP tab
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		if (planType.toUpperCase().contains("SSUP")) {
			profilePreferencesPage.clickCombTab("SSUP");
		}
		profilePreferencesPage.validateNoCommunicationPreferences();
	}
	/**
	 * Profile page CT Regression 
	 */
	
	/**
	 * @toDo : The user checks the email section
	 */
	@Then("^the email address section should be verified$")
	public void able_to_view_emailaddress_section() throws Throwable{
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validatemailsect1();		
	}
	@Then("^the Phone Numbers section should be validated & all links clicked$")
	public void able_to_validate_Phone_section() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validatePhonelinksforfederalmembers();
	}
	@Then("^the user verifies the Temporary Address Link on the Account settings page$")
	public void validateTemporaryAddressSection() throws Throwable {
		ProfileandPreferencesPage  profilePrefPage = (	ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		profilePrefPage.validateTemporaryAddressSection();
		profilePrefPage.validateMailingAddressSection();
	}
	
	/**
	 * @toDo : The user validates the Account information of the logged in
	 *       member
	 */

	@And("^the user validates the Plan Name, Member name, Member ID and account section in UMS site")
	public void user_Validates_FED_PROFILE_MEMBERNAME_ID_AccountProfile1() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		if (profilePreferencesPage == null) {
			System.out.println("Profile and Preferences page variable is Null");
		}
		profilePreferencesPage.validatePlanNameMemberidNameAccountProfile();
	}
	/**
	 * @toDo : Validates the Sign Up Today in Communication Preferences section
	 */
	@Then("^the user validates sign up today link$")
	public void uservalidatessignuptoday() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateSIGNUp();
	}
	/***
	 * 
	 */
	@Then("^the user validates the presence of Back to Profile and Preferences links$")
	public void UserValidatesBacktoPNPlink() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validateBacktoPNPlink();

}
	/***
	 * Validate Combo tab on Account Settings Page 
	 */
		@Then("^I should see the combo tabs on Account Profile page and user validates the elements on individual tabs$")
	public void userValidatesComboTabsOnProfilePage() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
			boolean Var = profilePreferencesPage.getNumPlanTabComboPlans()>1;
		for (int x=0; x<profilePreferencesPage.getNumPlanTabComboPlans(); x++) {
			String planName=profilePreferencesPage.getComboTabPlanType(x);
			if (planName.toUpperCase().contains("SENIOR SUPPLEMENT PLAN")) {
				System.out.println("This tab is for SSUP plan, proceed to validate no preferences");
				profilePreferencesPage.validateNoCommunicationPreferences();
				return;
			}
			System.out.println("This tab is for plan='"+planName+"', proceed to validate account settings page ");
			try {
				profilePreferencesPage.verifyAccountSettingsPreffectivemember();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ((x+1) == profilePreferencesPage.getNumPlanTabComboPlans())
				System.out.println("This tab is the last tab, testing is done");
			else {
				System.out.println("Click next tab to get ready for next plan validation");
				profilePreferencesPage.switchTabForComboMember(x+1);}
		}
			
	}	
	/***
	 * Validate HSID links on Account Settings Page 
	 */
	@Then("^the user validates HEALTHSAFE ID PASSWORD & HEALTHSAFE ID ACCOUNT RECOVERY & SECURITY links$")
	public void user_Validates_bothHSID_Links() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		profilePreferencesPage.validateHealthSafeIdbothLinks();
	}
	/**
	 * 
	 */
	@Then("^I validate that login is successfull$")
	public void verifyloginOnDashboardHomePage() throws Throwable {
		
		if (MRScenario.environment.equalsIgnoreCase("stage") & "NO".equalsIgnoreCase(MRScenario.isTestHarness))	
		{			
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
			System.out.println("After login validating the element on the Dashboard");
			accountHomePage.validateLoginonDashboard();	
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}
		
		else if ((MRScenario.environment.equalsIgnoreCase("team-h")) || (MRScenario.environment.equalsIgnoreCase("stage") & "YES".equalsIgnoreCase(MRScenario.isTestHarness)))
		{
			TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			System.out.println("After login via the TestHarness validaying the element on test Harness");
			testHarnessPage.validateLoginonTestharness();	
		    getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
		}
		else {
			System.out.println("Not verifying that preeffective message is displayed as the environment is not set to team-h or Stage");
		}
		}
	@Then("^the user validates the address sectioning$")
	public void uservalidatestheaddresssectioning() {
		//List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
	//	String memberType = memberAttributesRow.get(0).getCells().get(1);
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		profilePreferencesPage.validatesAddressSectioning();

	}
}
