package acceptancetests.ProfileandPreferencesredesign.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.openqa.selenium.By;

import pages.member.bluelayer.ProfilePreferencesPage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.BenefitsAndCoveragePage;
import pages.member.ulayer.LoginPage2;
import pages.member.ulayer.PlanBenefitsCoveragePage;
import pages.member.ulayer.ProfileandPreferencesPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.profandpref.data.ProfnPrefCommonConstants;
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
	pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP with following details for profile and preferences flow in AARP site$")
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

	@Then("^the user navigate to Profile and Preference page")
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
	
	
	
	
	
	@Then("^the user view jenkins of Profile and preferences in AARP site")
	public void user_views_ProfileandPreferences() {

		
		if (ProfileandPreferencespage != null) {
			// Get actual data
			JSONObject actualJsonObj = ProfileandPreferencespage.ProfileandPreferencesJson;
			loginScenario.saveBean(ProfnPrefCommonConstants.MY_Profile_AND_PREFERENCES_ACTUAL, actualJsonObj);
			// getLoginScenario().saveBean(PageConstants.BENEFITS_COVERAGE_PAGE,
			// benefitsCoveragePage);
			System.out.println("Profile and Preferences actual ==============>" + actualJsonObj.toString());
			// Get expected data
			String fileName = this.userName;
			String directory = CommonConstants.PROFILE_AND_PREFERNCES_PAGE_DIRECTORY;
			JSONObject profileAndPreferencesExpectedJson = MRScenario.readExpectedJson(fileName, directory);
			loginScenario.saveBean(ProfnPrefCommonConstants.MY_Profile_AND_PREFERENCES_EXPECTED,
					profileAndPreferencesExpectedJson);
			System.out.println(
					"Profile and Preferences Expected==============>" + profileAndPreferencesExpectedJson.toString());
		}
	}
	
	@Then("^the user validates the content on Profile and Preferences page")
	public void validateContentOnProfileandPreferncesPage() {

		try {

			JSONObject actual = (JSONObject) loginScenario
					.getBean(ProfnPrefCommonConstants.MY_Profile_AND_PREFERENCES_ACTUAL);

			JSONObject expected = (JSONObject) loginScenario
					.getBean(ProfnPrefCommonConstants.MY_Profile_AND_PREFERENCES_EXPECTED);

			if (actual != null && expected != null) {
				JSONAssert.assertEquals(expected, actual, true);
			}

		} catch (Exception e) {
			e.printStackTrace();
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

		ProfileandPreferencespage.validateEmail();
	
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
	
	@Then("^the user validates disclaimer link and on clicking disclaimer link it should expand and on again clicking it should collapse")
	public void uservalidatesdisclaimerlink()
	{
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
		
		
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		try
		{
		JSONObject profilenpreferencesActualJson = ProfileandPreferencespage.ProfileandPreferencesPageJson;
		loginScenario.saveBean(ProfnPrefCommonConstants.MY_PROFILE_PREFERENCES_ACTUAL, profilenpreferencesActualJson);
		System.out.println("profilenpreferencesActualJson---->" + profilenpreferencesActualJson);
		System.out.println(userName);
		// Get expected data
					String fileName = userName;
					String directory = CommonConstants.PROFILE_AND_PREFERNCES_PAGE_DIRECTORY;
					JSONObject myProfilenpreferencesexpectedjson = MRScenario.readExpectedJson(fileName,directory);
					loginScenario.saveBean(ProfnPrefCommonConstants.MY_PROFILE_PREFERENCES_EXPECTED,
							myProfilenpreferencesexpectedjson);
					ProfileandPreferencespage.clickOndisclaimerlink(myProfilenpreferencesexpectedjson);
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
	pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
			.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
	
	ProfileandPreferencespage.validateneedhelpheader();
	
	}
	
	@Then("^the user validates the Phone section in AARP site")
	public void UserValidatesPhoneSection() {
		pages.member.ulayer.ProfileandPreferencesPage ProfileandPreferencespage = (pages.member.ulayer.ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);

		ProfileandPreferencespage.validatePhoneElements();
	
	}
}
