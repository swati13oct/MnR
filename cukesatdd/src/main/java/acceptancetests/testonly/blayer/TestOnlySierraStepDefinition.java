package acceptancetests.testonly.blayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
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
import pages.member.bluelayer.FormsandresourcesPage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.MyProfilesPage;
import pages.member.bluelayer.OrderplanmaterialsPage;
import pages.member.bluelayer.PharmacySearchPage;
import pages.member.bluelayer.PlanSummaryPage;
import pages.member.bluelayer.*;

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


	@When("^I am using the MyProfile page$")
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


	@When("^I am using the My Forms and Resource page$")
	public void I_am_using_the_My_Forms_and_Resource_page(DataTable memberAttributes) {


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
		FormsandresourcesPage formsandresourcesPage = accountHomePage
				.navigateToFormsandResourcePage();
		if (formsandresourcesPage != null) {

			getTestonlyScenario().saveBean(
					PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsandresourcesPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in loading  Forms and resources Page");
		}
	}

	@When("^I am using the Order My Materials page$")
	public void  I_am_using_the_Order_My_Materials_page(DataTable memberAttributes) {


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
		OrderplanmaterialsPage orderplanmaterialsPage = accountHomePage
				.navigateToOrderPlanMaterialsPage();
		if (orderplanmaterialsPage != null) {

			getTestonlyScenario().saveBean(
					PageConstants.FORMS_AND_RESOURCES_PAGE,
					orderplanmaterialsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in loading  Forms and resources Page");
		}

	}

	@When("^I am using the My Summary page$")
	public void  I_am_using_the_My_Summary_page(DataTable memberAttributes) {


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
		PlanSummaryPage planSummaryPage = accountHomePage
				.navigateToPlanSummary();
		if (planSummaryPage != null) {

			getTestonlyScenario().saveBean(
					PageConstants.PLAN_SUMMARY_PAGE,
					planSummaryPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in loading  Forms and resources Page");
		}

	}
	@When("^I am using the Pharmacy Locator page$")
	public void  I_am_using_the_phamacy_locator_page(DataTable memberAttributes) {


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
		PharmacySearchPage pharmacySearchPage = accountHomePage
				.navigateToPharmacyLocator();
		if (pharmacySearchPage != null) {

			getTestonlyScenario().saveBean(
					PageConstants.PLAN_SUMMARY_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in loading  Forms and resources Page");
		}

	}
	
	
	@When("^I am using the My Health & Wellness page$")
	public void  I_am_using_the_My_Health_And_Wellness_page(DataTable memberAttributes) {


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
		PharmacySearchPage pharmacySearchPage = accountHomePage
				.navigateToPharmacyLocator();
		if (pharmacySearchPage != null) {

			getTestonlyScenario().saveBean(
					PageConstants.PLAN_SUMMARY_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in loading  Forms and resources Page");
		}

	}
	
	@When("^I am using the Go Green page$")
	public void i_am_using_the_go_green_page(DataTable memberAttributes) {


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
		GoGreenPage goGreenPage = accountHomePage
				.navigateToGoGreenPage();
		//getTestonlyScenario().saveBean(PageConstants.GOGREEN_PAGE, goGreenPage);


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
	@Then("^I should see the Sierra plan on the page$")
	public void I_should_see_the_Sierra_plan_On_The_Page() {

		AccountHomePage acctHomePage = (AccountHomePage) getTestonlyScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		Assert.assertEquals("Sierra Plan name not found in the page",true,acctHomePage.isUHCMedicareCompleteChoicePPOPresent());
		acctHomePage.logOut();
	}

}
