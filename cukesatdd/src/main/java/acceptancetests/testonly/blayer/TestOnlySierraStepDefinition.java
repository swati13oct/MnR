package acceptancetests.testonly.blayer;

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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.ContactUsPage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.MyProfilesPage;

public class TestOnlySierraStepDefinition {

	@Autowired
	MRScenario testonlyScenario;

	public MRScenario getTestonlyScenario() {
		return testonlyScenario;
	}


	@Given("^I am an authenticated Sierra Spectrum Plan Member who has registered on UHCMedicareSolutions.com$")
	public void uhc_login_page(){
		WebDriver wd = getTestonlyScenario().getWebDriver();
		getTestonlyScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getTestonlyScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);

	}
	@When("^I am using the My Account Home page$")
	public void login_with_member(DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String,String> loginCreds = testonlyScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);


		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a "+ desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd );
			getTestonlyScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getTestonlyScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		LoginPage loginPage = (LoginPage)getTestonlyScenario().getBean(PageConstants.LOGIN_PAGE);

		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);


		getTestonlyScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);

	}


	@When("^the user navigates to contact us page in UHC site$")
	public void views_order_materials_in_Ums_site(DataTable memberAttributes) {


		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String,String> loginCreds = testonlyScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);


		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a "+ desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd );
			getTestonlyScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getTestonlyScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		LoginPage loginPage = (LoginPage)getTestonlyScenario().getBean(PageConstants.LOGIN_PAGE);

		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);


		getTestonlyScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);



		accountHomePage = (AccountHomePage) getTestonlyScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ContactUsPage contactUsPage = accountHomePage
				.navigatesToContactUsPage();
		if (contactUsPage != null) {

			getTestonlyScenario().saveBean(
					PageConstants.CONTACT_US_PAGE,
					contactUsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in loading  Contact Us page");
		}


	}


	@When("^the user navigates to my profile page in UHC site$")
	public void the_user_navigates_to_my_profile_page_in_UHC_site(DataTable memberAttributes) {


		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String,String> loginCreds = testonlyScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);


		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a "+ desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd );
			getTestonlyScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getTestonlyScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		LoginPage loginPage = (LoginPage)getTestonlyScenario().getBean(PageConstants.LOGIN_PAGE);

		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);


		getTestonlyScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);



		accountHomePage = (AccountHomePage) getTestonlyScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MyProfilesPage myProfilesPage = accountHomePage
				.navigateToMyProfilesPage();
		getTestonlyScenario().saveBean(PageConstants.MY_PROFILES_PAGE, myProfilesPage);


	}
	@Then("^I should see the Sierra plan in My Home Page$")
	public void I_should_see_the_Sierra_plan() {

		AccountHomePage acctHomePage = (AccountHomePage) getTestonlyScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		Assert.assertEquals("Sierra Plan name not found in the page",true,acctHomePage.isUHCMedicareCompleteChoicePPOPresent());
		acctHomePage.logOut();
	}

	@Then("^I should see the Sierra plan in profile page$")
	public void I_should_see_the_Sierra_plan_profile_page() {
		MyProfilesPage myProfilesPage = (MyProfilesPage) getTestonlyScenario()
				.getBean(PageConstants.MY_PROFILES_PAGE);
		Assert.assertEquals("Sierra Plan name not found in the page",true,myProfilesPage.isUHCMedicareCompleteChoicePPOPresent());
		myProfilesPage.logOut();
	} 


}
