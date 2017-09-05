package acceptancetests.ProfileandPreferencesredesign.bluelayer;

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

import pages.member.bluelayer.LoginPage2;
import pages.member.bluelayer.ProfilePreferencesPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.profandpref.data.ProfnPrefCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
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
		ProfilePreferencesPage.validateEmailEditElements();

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

	
		
		String	 Password = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		ProfilePreferencesPage.validateAccountEdit(Password);
	
	}
	
	@Then("^the user clicks on save button without filling current and new password and the red mandatory message should come")
	public void UserValidatesclickingbutton() 
	{
			pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
					.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

			ProfileandPreferencespage.validateSavebuttonclick();
	}
	
	@Then("^the user validates the functionality of Cancel Button")
	public void UserValidatesAccountEditCancelButton() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateCancelButton();
	
	}
	
	@Then("^the user validates see more ways to contact us section")
	public void Uservalidatesneedhelpsection()
	{
	
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
		ProfilePreferencesPage.validateseemorewaystext();
	}
	
	@Then("^the user validates on clicking contact us link it should route to contact us page")
	public void uservalidatescontactuslink()
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
		ProfilePreferencesPage.clickcontactUslink();
	}
	
	@Then("^the user validates disclaimer link and on clicking disclaimer link it should expand and on again clicking it should collapse")
	public void uservalidatesdisclaimerlink()
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
		
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		try
		{
		JSONObject profilenpreferencesActualJson = ProfilePreferencesPage.ProfileandPreferencesPageJson;
		loginScenario.saveBean(ProfnPrefCommonConstants.MY_PROFILE_PREFERENCES_ACTUAL, profilenpreferencesActualJson);
		System.out.println("profilenpreferencesActualJson---->" + profilenpreferencesActualJson);
		System.out.println(userName);
		// Get expected data
					String fileName = userName;
					String directory = CommonConstants.PROFILE_AND_PREFERNCES_PAGE_DIRECTORY;
					JSONObject myProfilenpreferencesexpectedjson = MRScenario.readExpectedJson(fileName,directory);
					loginScenario.saveBean(ProfnPrefCommonConstants.MY_PROFILE_PREFERENCES_EXPECTED,
							myProfilenpreferencesexpectedjson);
					ProfilePreferencesPage.clickOndisclaimerlink(myProfilenpreferencesexpectedjson);
					System.out.println("profilenpreferencesExpectedJson---->" + myProfilenpreferencesexpectedjson);

					/*if (profilenpreferencesActualJson != null && myProfilenpreferencesexpectedjson != null) 
					{
						JSONAssert.assertEquals(myProfilenpreferencesexpectedjson, profilenpreferencesActualJson, true);
					}*/

				} 
		catch (Exception e) {
					e.printStackTrace();
				}
		}
	
	
	@Then("^the user validates the need help section")
	public void uservalidatesneedhelpsection()
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
	
		ProfilePreferencesPage.validateneedhelpheader();
	
	}
	
	@Then("^the user validates permanent address section")
	public void uservalidatespermanentaddresssection()
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
	
		ProfilePreferencesPage.validatepermanentaddress();
	
	}
	
	@Then("^the user clicks on contact us then contact us page should come")
	public void uservalidatescontactuslinkpermanentadress()
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
	
		ProfilePreferencesPage.validatecontactuslink();
	
	}
	
	@Then("^the user clicks on edit button")
	public void userclickemailedit()
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
			
		ProfilePreferencesPage.validateEmail();
     }
	
	@Then("^the user clicks on save without filling both fields then the user should see red mandatory message")
	public void uservalidatemandatorymessage()
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
		ProfilePreferencesPage.emailblankfieldsvalidation();
		
	}
	
	
	@Then("^the user fill new email address and click save then user should see new updated email on page")
	public void uservalidatesemailsavefunctionality() 
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
		ProfilePreferencesPage.validateemailsavefunctionality();
	}
	
	@Then("^the user fill invalid email and clicks on save button then the user should see error message for invalid email")
	public void uservalidatesinvalidemailmessage() 
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
		ProfilePreferencesPage.validateinvalidemailerrormessage();

	}
	
	@Then("^the user fill different email id in confirm email box from new email address then error message should come")
	public void uservalidatesdifferentemail() 
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
		ProfilePreferencesPage.validateduplicateerrormessage();
	}
	
	@Then("^the user validates Communication Preferences section")
	public void uservalidatescommunicationpreferncessection() 
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
		ProfilePreferencesPage.validatecommunicationpreferences();

	}
	
	@Then("^the user validates Go paperless button and on clicking button go green page should come")
	public void uservalidatesgogreenpagerouting() 
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
		ProfilePreferencesPage.validategogreenbutton();
	}
	
	@Then("^the user validates headers on green page") 
	public void uservalidatesgogreenheader() 
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
		ProfilePreferencesPage.validateheader();
	}
	
	@Then("^the user validates on clicking Profilenpreferences arrow user should route to Profile and Preferences page") 
	public void uservalidatespnplinkatthetop() 
	{
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);
		
		ProfilePreferencesPage.validatepnparrowlink();
	}
	
}
