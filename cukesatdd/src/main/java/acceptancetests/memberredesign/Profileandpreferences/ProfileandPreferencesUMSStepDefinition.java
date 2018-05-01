
package acceptancetests.memberredesign.Profileandpreferences;

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
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstantsMnR;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
//import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage2;
import pages.member.bluelayer.ProfilePreferencesPage;
<<<<<<< HEAD
import pages.regression.accounthomepage.AccountHomePage;
=======
//import pages.member.bluelayer.ProfilePreferencesPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
>>>>>>> develop

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
			 getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
		}


	}


	/** 
	 * @throws InterruptedException 
	 * @toDo : The user navigates to Profile and Preferences page from Rally Dashboard
	 */
	@Then("^the user navigates to Profile and Preferences page")
	public void user_navigate_toProfileandPreferencespage() throws InterruptedException {
        
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);

		ProfileandPreferencesPage ProfilePreferencesPage = accountHomePage.navigateDirectToProfilePage();

		if (ProfilePreferencesPage!= null) {
			getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE, ProfilePreferencesPage);
		}
		else
        {
			System.out.println("Pnp page object is Null ");
		}

	}
	/*@Then("^the user navigates to Profile page")
	public void user_navigate_toProfilepage() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		ProfilePreferencesPage ProfilePreferencesPage = accountHomePage.navigateDirectToProfilePage();

		if (ProfilePreferencesPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE, ProfilePreferencesPage);
		}
		if (ProfilePreferencesPage == null) {
			System.out.println(" Variable is NULL!");

		}
	}*/



	/** 
	 * @toDo : The user validates the Account information of the logged in member 
	 */

	@And("^the user validates the Plan Name, Member name, Member ID and account section in UMS site")
	public void user_Validates_FED_PROFILE_MEMBERNAME_ID_AccountProfile() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		if (ProfilePreferencesPage == null) {
			System.out.println("Profile and Preferences page variable is Null");
		}
		ProfilePreferencesPage.validatePlanNameMemberidNameAcountProfile();

	}

	/** 
	 * @toDo : The user checks the email section 
	 */
	@Then("^the user validates the Email section in UMS site")
	public void user_Validates_email() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateEmail();
		ProfilePreferencesPage.validateEmailEditElements();

	}


	/** 
	 * @toDo : The user checks the elements that appear when the user clicks on edit link of Account section
	 */
	@Then("^the user validates the elements on clicking the edit link")
	public void UserValidatesAccountEditOptions() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		ProfilePreferencesPage.validateAccountEditElements();

	}

	/** 
	 * @toDo : The user checks the Password Update functionality
	 */
	@Then("^the user validates the functionality of save Button")
	public void UserValidatesAccountEditSaveButton() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		String Password = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		ProfilePreferencesPage.validateAccountEdit(Password);

	}
	@Then("^the user validate the temporary address section for ship member")
	public void UserValidatesTempAddressShip() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		ProfilePreferencesPage.validateTempAddressShip();
	}
	

	

	/** 
	 * @toDo : The user checks the Password Update functionality  without entering the mandatory fields
	 */
	@Then("^the user clicks on save button without filling current and new password and the red mandatory message should come")
	public void UserValidatesclickingbutton() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		ProfilePreferencesPage.validateSavebuttonclick();
	}

	/** 
	 * @toDo : The user checks the functionality of cancel Button of the password update window
	 */
	@Then("^the user validates the functionality of Cancel Button")
	public void UserValidatesAccountEditCancelButton() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateCancelButton();

	}


	/** 
	 * @toDo :  The user checks the Password Update functionality by entering an invalid password
	 */
	@Then("^the user enters invalid password in new password field and clicks save button and the user should see expected error message - Password does not meet requirements")
	public void UserValidatesinvalidpassword() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.invalidpasswordvalidation();

	}


	/** 
	 * @toDo :  The user checks the Password Update functionality by entering different  password in confirm password field
	 */
	@Then("^the user enters different password in confirm password field and clicks save button and the user should see expected error message - Please enter the same value again")
	public void UserValidatesinvalidpassword2() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.invalidpasswordvalidation2();

	}
	/** 
	 * @toDo : checks the see more ways to contact us link in the Need help section
	 */

	@Then("^the user validates see more ways to contact us section")
	public void Uservalidatesneedhelpsection() {

		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateseemorewaystext();
	}

	/** 
	 * @toDo :  the user validates the page that opens up on  clicking the  see more ways to contact us link in the Need help section
	 */

	@Then("^the user validates on clicking contact us link it should route to contact us page")
	public void uservalidatescontactuslink() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.clickcontactUslink();
	}

	/** 
	 * @toDo :  Validates the disclaimer link and the way it expands and collapses
	 */

	@Then("^the user validates disclaimer link and on clicking disclaimer link it should expand and on again clicking it should collapse")
	public void uservalidatesdisclaimerlink() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		try {
			JSONObject profilenpreferencesActualJson = ProfilePreferencesPage.ProfileandPreferencesPageJson;
			//loginScenario.saveBean(ProfnPrefCommonConstants.MY_PROFILE_PREFERENCES_ACTUAL,
					//profilenpreferencesActualJson);
			System.out.println("profilenpreferencesActualJson---->" + profilenpreferencesActualJson);
			System.out.println(userName);
			// Get expected data
			String fileName = userName;
			String directory = CommonConstants.PROFILE_AND_PREFERNCES_PAGE_DIRECTORY;
			JSONObject myProfilenpreferencesexpectedjson = MRScenario.readExpectedJson(fileName, directory);
			//loginScenario.saveBean(ProfnPrefCommonConstants.MY_PROFILE_PREFERENCES_EXPECTED,
					//myProfilenpreferencesexpectedjson);
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


	/** 
	 * @toDo :  Validates the need help section headers
	 */
	@Then("^the user validates the need help section")
	public void uservalidatesneedhelpsection() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateneedhelpheader();

	}

	/** 
	 * @toDo :  Validates the permanent address section header
	 */

	@Then("^the user validates permanent address section")
	public void uservalidatespermanentaddresssection() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatepermanentaddress();

	}
	/** 
	 * @toDo :  Validates the contact us link and the page that opens up on clicking the contact us link
	 */

	@Then("^the user validates contact us statement")
	public void uservalidatescontactuslinkpermanentadress() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatecontactuslink();
	}
	/** 
	 * @toDo :  Validates the elements of Email section
	 */
	@Then("^the user clicks on edit button")
	public void userclickemailedit() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateEmailEdit();
	}

	/** 
	 * @toDo :  Validates the email edit functionality without filling any of the email text fields
	 */

	@Then("^the user clicks on save without filling both fields then the user should see red mandatory message")
	public void uservalidatemandatorymessage() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.emailblankfieldsvalidation();

	}


	/** 
	 * @toDo :  Validates the email edit functionality with valid email
	 */
	@Then("^the user fill new email address and click save then user should see new updated email on page")
	public void uservalidatesemailsavefunctionality() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateemailsavefunctionality();
	}

	/**
	 * @toDo :  Validates the email edit functionality with invalid email
	 */

	@Then("^the user fill invalid email and clicks on save button then the user should see error message for invalid email")
	public void uservalidatesinvalidemailmessage() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateinvalidemailerrormessage();

	}


	/** 
	 * @toDo :  Validates the email edit functionality by entering different email id's in confirm email box from new email address
	 */
	@Then("^the user fill different email id in confirm email box from new email address then error message should come")
	public void uservalidatesdifferentemail() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateduplicateerrormessage();
	}

	/** 
	 * @toDo :  Validates the Communication Preferences section headers
	 */
	@Then("^the user validates Communication Preferences section")
	public void uservalidatescommunicationpreferncessection() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		ProfilePreferencesPage.validatecommunicationpreferences();
	}

	/** 
	 * @toDo :  Validates the Go green button in Communication Preferences section 
	 */
	@Then("^the user validates Go paperless button and on clicking button go green page should come")
	public void uservalidatesgogreenpagerouting() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validategogreenbutton();
	}


	/** 
	 * @toDo :  Validates the headers on Go green page
	 */
	@Then("^the user validates headers on green page")
	public void uservalidatesgogreenheader() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateheader();
	}


	/** 
	 * @throws InterruptedException 
	 * @toDo :  Validates the back Link functionality from Go green page to Profile page 
	 */

	@Then("^the user validates on clicking Profilenpreferences arrow user should route to Profile and Preferences page")
	public void uservalidatespnplinkatthetop() throws InterruptedException {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatepnparrowlink();
	}

	/** 
	 * @toDo :  Validates the elements of Phone section
	 */

	@Then("^the user validates the Phone section")
	public void UserValidatesPhoneSection() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatePhoneElements();

	}

	/** 
	 * @toDo :  Validates the elements on clicking the Phone edit Button
	 */
	@Then("^the user Clicks on the the Edit Link and validates the elements")
	public void UserClicksEditPhoneSection() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatePhoneEditElements();

	}
	/** 
	 * @toDo :  Validates the presence of Cancel Button post clicking the edit buttton of the Phone section
	 */

	@Then("^the user checks the Edit Button changes to Cancel Button")
	public void UserChecksSaveCancelButton() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateCancelElement();

	}

	/** 
	 * @toDo :  Validates the functionality of saving or updating Phone numbers in phone section
	 */

	@Then("^the user checks the functionality of save Button in Phoneeditsection")
	public void UserValidatesPhoneSaveButton() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatePhoneSave();

	}
	/** 
	 * @toDo :  Validates the functionality of cancel Button which appears post clicking the edit button in phone section
	 */


	@Then("^the user validate the functionality of Cancel Button In phoneeditSection")
	public void UserValidatesPhoneCancelButton() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatePhoneCancel();

	}

	/** 
	 * @toDo :  Validates the elements of the temporary address section
	 */
	@Then("^the user validates the temporary address section")
	public void tempaddress() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatetempaddressElements();

	}
	/** 
	 * @toDo : Validates the elements that appear on clicking the edit button of the temp address section
	 */

	@Then("^the user validates the fields and Buttons of temp address section")
	public void UserClicksEdittempaddressSection() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatetempaddressEditElements();

	}
	/** 
	 * @toDo :  Validates the Cancel button that appear on clicking the edit button of the temp address section
	 */

	@Then("^the user checks the Edit Button on the top changes to Cancel Button")
	public void UserChecksTopCancelButton() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateTempAddressTopCancelElement();

	}
	/** 
	 * @toDo :  Validates the Save Functionality of the Temporary address section
	 */



	/** 
	 * @toDo :  Validates the Cancel Functionality of the temp address section
	 */

	@Then("^the user validates functionality of Cancel Button In Temporary adrress section")
	public void UserValidatestempaddressCancelButton() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatetempaddressCancel();

	}

	/** 
	 * @toDo :  Validates the presence of Go Paperless button
	 */
	@Then("^the user validates the presence of Go Paperless button")
	public void UserValidateGoPaperlessbutton() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateGoPaperlessbutton();

	}


	/** 
	 * @toDo :  Validates the plan name on the Go Green page
	 */
	@Then("^the user validates the presence of Plan Name")
	public void UserValidatePlanName() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatePlanName();

	}
	/** 
	 * @toDo :  Validates the headers of the communication preferences section
	 */

	@Then("^the user validates the presence of Communication preferences header")
	public void UserValidatescommunicationpreferencesheader() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatecommunicationpreferencesheader();

	}

	/** 
	 * @toDo :  Validates the  presence of Back to Profile and Preferences links on Go green page
	 */
	@Then("^the user validates the presence of Back to Profile and Preferences links")
	public void UserValidatesBacktoPNPlink() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateBacktoPNPlink();

	}

	/** 
	 * @toDo :  Validates the Note section on Go green page
	 */
	@Then("^the user validates the Note section")
	public void UserValidatesNoteSection() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateNoteSection();

	}

	/** 
	 * @toDo :  Validates the I have read checkbox  on Go green page
	 */
	@Then("^the user validates the I have read checkbox and check it")
	public void UserValidatesCheckbox() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateCheckbox();

	}

	/** 
	 * @toDo :  Validates the save preferences functionality on Go green page
	 */
	@Then("^the user validates the Save Preferences Button")
	public void UserValidatesSavePreferences() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateSavePreferences();

	}

	/** 
	 * @toDo :  Validates the Go green header on Go green page
	 */

	@Then("^the user validates the Go Green Header")
	public void UserValidatesGoGreenHeader() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateGoGreenHeader();

	}
	/** 
	 * @toDo :  Validates the Need help section for ship member
	 */

	@Then("^the user validate the need help section for ship member")
	public void UserValidatesNeedHelpShip() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateNeedHelpShip();

	}
	@Then("^the user validates the Presence of edit button in email section")
	public void UserValidatesEmailEditNokia() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateEmailEditNokia();

	}
	@Then("^the user validates the Presence of edit button in Phone section")
	public void UserValidatesPhoneEditNokia() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validatePhoneEditNokia();

	}
	@Then("^the user validates the Presence of edit button in Temporary Address section")
	public void UserValidatesTempAddEditNokia() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateTempAddEditNokia();

	}
	@Then("^the user validates the Presence of edit button in Mailing Address section")
	public void UserValidatesMailAddEditNokia() {
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateMailAddEditNokia();

	}
	
	/**
	 * @throws InterruptedException 
	 * @toDo : The user logs in to the member Redesign Portal
	 */
	
	@Given("^registered member with following details$")
	public void registered_member_with_following_details(DataTable memberAttributes) throws InterruptedException{
		
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
			 getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
			
		}
		else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
		}

	   
	   
	}
	/**
	 * @toDo : The user enters the security questions
	 */
	
	@When("^I enter the security questions$")
	public void i_enter_the_security_questions(DataTable givenAttributes)
	{
        List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
        Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
        for (int i = 0; i < memberAttributesRow.size(); i++) {
               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
                            memberAttributesRow.get(i).getCells().get(1));
        }
        String friendname = memberAttributesMap.get("friendname");
        String favouritecolor = memberAttributesMap.get("favouritecolor");
        String PhoneNumber = memberAttributesMap.get("PhoneNumber");
        
        AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);

		accountHomePage.validateTheSecurityQues(friendname,favouritecolor,PhoneNumber);


		
	}
	
	
	
	/**
	 * @toDo : The user clicks on health safe Id password
	 */

	@When("^I click the HEALTHSAFE ID PASSWORD link$")
	public void i_click_the_HEALTHSAFE_ID_PASSWORD_link() throws InterruptedException{
		
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateHealthSafeIdLink();
	}
	
	/**
	 * @toDo : The user should see the breadcrumb in the upper left side
	 */

	@Then("^I should see the breadcrumb  in the upper left side of the page$")
	public void i_should_see_the_breadcrumb_in_the_upper_left_side_of_the_page() throws InterruptedException{
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateBreadCrumb();
	 
	}

	/**
	 * @toDo : The functionality of Bread crumb
	 */
	@And("^clicking the link should lead me back to the Account Settings page of the member site$")
	public void clicking_the_link_should_lead_me_back_to_the_Account_Settings_page_of_the_Medica_member_site(){
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateBreadCrumbClick();

	}
	/**
	 * @toDo : The functionality of health safe Id account recovery
	 */

	@Then("^I click the HEALTHSAFE ID ACCOUNT RECOVERY AND SECURITY link$")
	public void i_click_the_HEALTHSAFE_ID_ACCOUNT_RECOVERY_AND_SECURITY_link() throws InterruptedException{
		ProfileandPreferencesPage ProfilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		ProfilePreferencesPage.validateHealthSafeAccountLink();
	  
	
	}
	
	




}




