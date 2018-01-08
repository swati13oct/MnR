package acceptancetests.gogreen.redesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.redesign.BlueLayerHomePage;
import pages.redesign.BlueLayerLoginPage;
import pages.redesign.GoGreenPreferencesPage;
import pages.redesign.MyProfilesPage;
import pages.redesign.OrderplanmaterialsPage;
import pages.redesign.UlayerHomePage;
import pages.redesign.UlayerLoginPage;

public class MyGoGreenPageStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP member with following attributes$")
	public void registered_AMP_member_with_following_attributes(DataTable memberAttributes) throws InterruptedException {
		
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

	
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

		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);
//				.getUMSMemberWithDesiredAttributes(desiredAttributes);
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
			getLoginScenario()
					.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}
		getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		UlayerLoginPage loginPage = new UlayerLoginPage(wd);

		UlayerHomePage accountHomePage = (UlayerHomePage) loginPage.loginWith(userName, pwd);

		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);

	}
	
	@Given("^registered UHC member with following attributes$")
	public void registered_UHC_member_with_following_attributes(DataTable memberAttributes) {

		
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

		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);
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
			getLoginScenario()
					.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		BlueLayerLoginPage loginPage = new BlueLayerLoginPage(wd);

		BlueLayerHomePage accountHomePage = (BlueLayerHomePage) loginPage.loginWith(userName, pwd, category);

		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);

	}


	@When("^the user Navigates to AARP Member Redesign My Profile and Preferences page$")
	public void the_user_Navigates_to_Member_Redesign_My_Profile_and_Preferences_page() throws InterruptedException {
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MyProfilesPage myProfilepage = accountHomePage.navigateToProfAndPref();
		if (myProfilepage != null) {
			System.out.println("Profile page Loaded");
			getLoginScenario().saveBean(PageConstants.PROF_AND_PREF_PAGE, myProfilepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in Loading Profile and Preferences Summary Page");
		}

	}

	@When("^the user Navigates to BlueLayer Member Redesign My Profile and Preferences page$")
	public void the_user_Navigates_to_UMS_Member_Redesign_My_Profile_and_Preferences_page() throws InterruptedException {
		BlueLayerHomePage accountHomePage = (BlueLayerHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MyProfilesPage myProfilepage = accountHomePage.navigateToProfAndPref();
		if (myProfilepage != null) {
			System.out.println("Profile page Loaded");
			getLoginScenario().saveBean(PageConstants.PROF_AND_PREF_PAGE, myProfilepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in Loading Profile and Preferences Summary Page");
		}

	}
	
	
	@When("^user navigates to Redesign Go Green Page from My Profile Page$")
	public void the_user_Navigates_to_UMS_Member_Redesign_GoGreen_page() throws InterruptedException {
		MyProfilesPage myProfilepage = (MyProfilesPage) getLoginScenario().getBean(PageConstants.PROF_AND_PREF_PAGE);
		GoGreenPreferencesPage goGreenPage = myProfilepage.NavigateTo_GoGreen_MyPreferences_Page();
		if (goGreenPage != null) {
			System.out.println("@@@@ Go Green Preferences page is Loaded @@@@");
			getLoginScenario().saveBean(PageConstants.MY_PREFERENCES_PAGE, goGreenPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("@@@@ Error in Loading Go Green Preferences page @@@@");
		}

	}

	@Then("^the user Validates Single Tab for all SHIP Plans$")
	public void the_user_Validates_Single_Tab_for_all_SHIP_Plans() {
		GoGreenPreferencesPage goGreenPage = (GoGreenPreferencesPage) getLoginScenario().getBean(PageConstants.MY_PREFERENCES_PAGE);
		if(goGreenPage.Validate_Single_Tab_SHIP() ){
			System.out.println("**********Single Tab displayed for all SHIP Plans");
			Assert.assertTrue(true);
		}
		else{
			System.out.println("**********Single Tab NOT displayed for all SHIP Plans");
			Assert.fail();
			}
	}

	@Then("^the user Validates Separate PHIP tab$")
	public void the_user_Validates_Separate_PHIP_Tab() throws InterruptedException {
		GoGreenPreferencesPage goGreenPage = (GoGreenPreferencesPage) getLoginScenario().getBean(PageConstants.MY_PREFERENCES_PAGE);
		String PlanType = "PHIP";
		System.out.println("********** Plan Tab to Validate :"+PlanType+"*********");
		Boolean Flag = goGreenPage.navigatePlanTabs(PlanType);
		if(Flag){
			System.out.println("********** Separate PHIP Tab is Displayed **********");
			Assert.assertTrue(true);
		}
		else{
			System.out.println("********* Separate PHIP Tab is NOT Displayed **********");
			Assert.fail();
			}

	}

	@Then("^user navigates to Tabs for all Plan Types$")
	public void user_navigates_Plan_Tabs(DataTable givenAttributes) throws InterruptedException {
		GoGreenPreferencesPage goGreenPage = (GoGreenPreferencesPage) getLoginScenario().getBean(PageConstants.MY_PREFERENCES_PAGE);
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PlanTypes = givenAttributesMap.get("Combo Plans");
		String[] Plans= PlanTypes.split(",");
		for(String currentPlan: Plans){
			boolean TabPresent = goGreenPage.navigatePlanTabs(currentPlan);
			if(!TabPresent){
				System.out.println("Plan Tab not displayed "+currentPlan);
				Assert.fail("***** Plan Tab not displayed "+currentPlan+"*****");
			}
		}
	}
}






