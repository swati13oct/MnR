package acceptancetests.ProfileandPreferencesredesign.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.member.bluelayer.ProfilePreferencesPage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage2;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;

import pages.member.ulayer.ProfileandPreferencesPage;
import  acceptancetests.profandpref.data.ProfnPrefCommonConstants;
import acceptancetests.formsandresources.data.FnRCommonConstants;
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
public class ProfileandPreferencesAARPStepDefinition {

	@Autowired
	MRScenario loginScenario;

	private String userName = null;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered member with following details for Profile and Preferences flow$")
	public void login_with_member(DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();

		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);

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
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}

		/* Get expected data */
		/*
		 * Map<String, JSONObject> expectedDataMap = loginScenario
		 * .getExpectedJson(userName); JSONObject accountHomeExpectedJson =
		 * accountHomePage .getExpectedData(expectedDataMap);
		 * 
		 * if (accountHomePage != null) {
		 * getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
		 * accountHomePage); Assert.assertTrue(true); accountHomeActualJson =
		 * accountHomePage.accountHomeJson; }
		 * 
		 * try { JSONAssert.assertEquals(accountHomeExpectedJson,
		 * accountHomeActualJson, true); } catch (JSONException e) {
		 * e.printStackTrace(); }
		 * 
		 * getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
		 * expectedDataMap);
		 */

	}

	@Then("^the user navigates to Profile and Preferences page")
	public void user_navigate_toProfileandPreferencespage() {
		pages.member.ulayer.AccountHomePage accountHomePage = (pages.member.ulayer.AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = accountHomePage
				.navigateDirectToProfileandPreferencesPage();

		if (ProfileandPreferencespage != null) {
	
			getLoginScenario().saveBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE, ProfileandPreferencespage);
		}
		
		if (ProfileandPreferencespage == null)
		{
			System.out.println(" Variable is NULL" );
		}
	}

	@Then("^the user validates the Plan Name, Member name, Member ID section in AARP site")
	public void user_Validates_FED_PROFILE_MEMBERNAME_ID() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validatePlanNameMemberidandName();
	
	}
	@Then("^the user validates the Email section in AARP site")
	public void UserValidatesEmail() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		//ProfileandPreferencespage.validateEmail();
		ProfileandPreferencespage.validateeditform();
	
	}
	@Then("^the user validates the elements on clicking the edit link")
	public void UserValidatesAccountEditOptions() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validateAccountEditElements();
	
	}
	@Then("^the user validates the functionality of save Button")
	public void UserValidatesAccountEditSaveButton() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

	
		
		String	 Password = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		ProfileandPreferencespage.validateAccountEdit(Password);
	
	}
	@Then("^the user validates the functionality of Cancel Button")
	public void UserValidatesAccountEditCancelButton() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validateCancelButton();
	}
	
	@Then("^the user clicks on save button without filling current and new password and the red mandatory message should come")
	public void UserValidatesclickingbutton() 
	{
			pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
					.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

			ProfileandPreferencespage.validateSavebuttonclick();
	}
	
	@Then("^the user validates see more ways to contact us section")
	public void Uservalidatesneedhelpsection()
	{
	
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.validateseemorewaystext();
	}
	
	@Then("^the user validates on clicking contact us link it should route to contact us page")
	public void uservalidatescontactuslink()
	{
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.clickcontactUslink();
	}
	
	
	
	@Then("^the user validates the need help section")
	public void uservalidatesneedhelpsection()
	{
	pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
			.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
	
	ProfileandPreferencespage.validateneedhelpheader();
	
	}
	
	
	@Then("^the user validates permanent address section")
	public void uservalidatespermanentaddresssection()
	{
	pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
			.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
	
	ProfileandPreferencespage.validatepermanentaddress();
	
	}
	
	@Then("^the user validates permanent address section pdp")
	public void uservalidatespermanentaddresssectionpdp()
	{
	pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
			.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
	
	ProfileandPreferencespage.validatepermanentaddresspdp();
	
	}
	
	
	@Then("^the user clicks on contact us then contact us page should come")
	public void uservalidatescontactuslinkpermanentadress()
	{
	pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
			.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
	
	ProfileandPreferencespage.validatecontactuslink();
	
	}
	
	@Then("^the user clicks on edit button")
	public void userclickemailedit()
	{
			pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
					.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
			
			ProfileandPreferencespage.validateEmail();
     }
	
	@Then("^the user clicks on save without filling both fields then the user should see red mandatory message")
	public void uservalidatemandatorymessage()
	{
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.emailblankfieldsvalidation();
		
	}
	
	
	@Then("^the user fill new email address and click save then user should see new updated email on page")
	public void uservalidatesemailsavefunctionality() 
	{
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.validateemailsavefunctionality();
	}
	

	@Then("^the user fill invalid email and clicks on save button then the user should see error message for invalid email")
	public void uservalidatesinvalidemailmessage() 
	{
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.validateinvalidemailerrormessage();

	}
	
	@Then("^the user fill different email id in confirm email box from new email address then error message should come")
	public void uservalidatesdifferentemail() 
	{
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.validateduplicateerrormessage();
	}
	@Then("^the user validates the Phone section")
	public void UserValidatesPhoneSection() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validatePhoneElements();

	}

	@Then("^the user Clicks on the the Edit Link and validates the elements")
	public void UserClicksEditPhoneSection() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validatePhoneEditElements();

	}

	@Then("^the user checks the Edit Button changes to Cancel Button")
	public void UserChecksSaveCancelButton() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validateCancelElement();

	}

	@Then("^the user validates the functionality of save Button in Phoneeditsection")
	public void UserValidatesPhoneSaveButton() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validatePhoneSave();

	}

	@Then("^the user validates the functionality of Cancel Button In phoneeditSection")
	public void UserValidatesPhoneCancelButton() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validatePhoneCancel();

	}

	@Then("^the user validates Communication Preferences section")
	public void uservalidatescommunicationpreferncessection() 
	{
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.validatecommunicationpreferences();

	}
	
	@Then("^the user validates Go paperless button and on clicking button go green page should come")
	public void uservalidatesgogreenpagerouting() 
	{
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.validategogreenbutton();
	}
	
	@Then("^the user validates headers on green page") 
	public void uservalidatesgogreenheader() 
	{
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.validateheader();
	}
	
	@Then("^the user validates on clicking Profilenpreferences arrow user should route to Profile and Preferences page") 
	public void uservalidatespnplinkatthetop() 
	{
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.validatepnparrowlink();
	}
	

	@Then("^the user validates the presence of Go Paperless button")
	public void UserValidateGoPaperlessbutton() {
		
		
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.validateGoPaperlessbutton();

	}
	@Then("^the user validates the presence of Plan Name")
	public void UserValidatePlanName() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.validatePlanName();

	}
	@Then("^the user validates the presence of Communication preferences header")
	public void UserValidatescommunicationpreferencesheader() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		ProfileandPreferencespage.validatecommunicationpreferencesheader();

	}
	@Then("^the user validates the presence of Back to Profile and Preferences links")
	public void UserValidatesBacktoPNPlink() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

			ProfileandPreferencespage.validateBacktoPNPlink();
		

	}

	
	@Then("^the user validates the Note section")
	public void UserValidatesNoteSection() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validateNoteSection();

	}
	
	@Then("^the user validates the I have read checkbox and check it")
	public void UserValidatesCheckbox() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validateCheckbox();

	}
	
	@Then("^the user validates the Save Preferences Button")
	public void UserValidatesSavePreferences() 
	{
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validateSavePreferences();

	}
	
	
	@Then("^the user validates the Go Green Header")
	public void UserValidatesGoGreenHeader() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validateGoGreenHeader();

	}
	
	@Then("^the user validates the temporary address section")
	public void tempaddress() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validatetempaddressElements();

	}

	@Then("^the user validates the fields and Buttons of temp address section")
	public void UserClicksEdittempaddressSection() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validatetempaddressEditElements();

	}

	@Then("^the user checks the Edit Button on the top changes to Cancel Button")
	public void UserChecksTopCancelButton() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validateTempAddressTopCancelElement();

	}

	@Then("^the user validates the functionality of save Button in Temporary adrress section")
	public void UserValidatestempaddressSaveButton() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validatetempaddressSave();

	}

	@Then("^the user validates the functionality of Cancel Button In Temporary adrress section")
	public void UserValidatestempaddressCancelButton() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validatetempaddressCancel();

	}
	
	
	
	
	
}



