
/*
 * @author sdwaraka
 * 
 */
package acceptancetests.combotabsredesignpages;
import gherkin.formatter.model.DataTableRow;

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
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.redesign.UlayerHomePage;
import pages.redesign.ContactUsPage;
import pages.redesign.EoBSearchPage;
import pages.redesign.GoGreenPreferencesPage;
import pages.redesign.UlayerLoginPage;
import pages.redesign.MedicalClaimSummaryPage;
import pages.redesign.MyProfilesPage;
import pages.redesign.OrderplanmaterialsPage;
import pages.redesign.PaymentHistoryPage;
import pages.redesign.EoBSearchPage;
import pages.redesign.PlanMaterialConfirmationPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.ordermaterials.data.OrderPlanMaterialsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
* @author sdwaraka
*
*/
public class ComboTabsRedesignPagesStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered Combo Plans member with following attribute$")
	public void registered_member_with_following_attributes(DataTable memberAttributes) {
		
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
	
	@When("^the user navigates to mentioned page in Redesign site$")
	public void views_pages_in_Ums_site(DataTable givenAttributes) {
		
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PageName = givenAttributesMap.get("Page Name");
		System.out.println("Page Name"+PageName);
		//switch(PageName){
		if (PageName.equalsIgnoreCase("Claims")){
			UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			MedicalClaimSummaryPage medicalClaimssummaryPage = accountHomePage.navigateToMedicalClaimsSummary();
			if (medicalClaimssummaryPage != null) {
				System.out.println("Claims page Loaded");
				getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
						medicalClaimssummaryPage);
				Assert.assertTrue(true);
			}
			else {
				Assert.fail("Error in loading  Claims Summary Page");
			}
		}
		else if (PageName.equalsIgnoreCase("EOB")){
			UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			EoBSearchPage planBenefitsCoverage = accountHomePage.navigateToBenefitsAndCoverage();
			if (planBenefitsCoverage != null) {
				System.out.println("EOB page Loaded");
				getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE,
						planBenefitsCoverage);
				Assert.assertTrue(true);
			}
			else {
				Assert.fail("Error in loading  EOB Page");
			}
		}
		else if (PageName.equalsIgnoreCase("Profile") || PageName.equalsIgnoreCase("GoGreenPreferences")){
			UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			MyProfilesPage myProfilepage = accountHomePage.navigateToProfAndPref();
			if (myProfilepage != null) {
				System.out.println("Profile page Loaded");
				getLoginScenario().saveBean(PageConstants.PROF_AND_PREF_PAGE,
						myProfilepage);
				Assert.assertTrue(true);
			}
			else {
				Assert.fail("Error in Loading Profile and Preferences Summary Page");
			}
			if (PageName.equalsIgnoreCase("GoGreenPreferences")){
				GoGreenPreferencesPage goGreenPage = myProfilepage.NavigateTo_GoGreen_MyPreferences_Page();
				if (goGreenPage != null) {
					System.out.println("@@@@ Go Green Preferences page is Loaded @@@@");
					getLoginScenario().saveBean(PageConstants.MY_PREFERENCES_PAGE, goGreenPage);
					Assert.assertTrue(true);
				} else {
					Assert.fail("@@@@ Error in Loading Go Green Preferences page @@@@");
				}
			}
		}
		else if (PageName.equalsIgnoreCase("ContactUs")){
			UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			ContactUsPage contactUspage = accountHomePage.navigatesToContactUsPage();
			if (contactUspage != null) {
				System.out.println("ContactUs page Loaded");
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactUspage);
				Assert.assertTrue(true);
			}
			else {
				Assert.fail("Error in loading  Contact Us Page");
			}
		}
		else{System.out.println("Invalid Page Name selection");}
	}
	
	@Then("^the user validates Terminated Plans Tab are Not Displayed in the Redesign Page$")
	public void user_validates_TerminatedTabs_NotDIsplayed(DataTable givenAttributes) {
		
		
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PageName = givenAttributesMap.get("Page Name");
		System.out.println(PageName);
		//switch(PageName){
		
		if (PageName.equalsIgnoreCase("Profile")){
			MyProfilesPage myProfilepage = (MyProfilesPage) getLoginScenario().getBean(PageConstants.PROF_AND_PREF_PAGE);			
			if(myProfilepage.Validate_NoDisplay_TerminatedTabs()){
				System.out.println("Terminated Tabs are NOT Displayed");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Terminated Tabs are Displayed");
				Assert.fail();
				}
			}
		else if (PageName.equalsIgnoreCase("GoGreenPreferences")){
			GoGreenPreferencesPage goGreenPage = (GoGreenPreferencesPage) getLoginScenario().getBean(PageConstants.MY_PREFERENCES_PAGE);
			if(goGreenPage.Validate_NoDisplay_TerminatedTabs() ){
				System.out.println("Terminated Tabs are NOT Displayed");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Terminated Tabs are Displayed");
				Assert.fail();
				}
			}
		else{
			System.out.println("Invalid Page Name Selection");
			Assert.fail();
		}
	}
		
	@Then("^the user validates Terminated Plan Tabs in the Redesign Page$")
	public void user_validates_TerminatedTabs(DataTable givenAttributes) {
		
		
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PageName = givenAttributesMap.get("Page Name");
		System.out.println(PageName);
		//switch(PageName){
		
		if (PageName.equalsIgnoreCase("Claims")){
			MedicalClaimSummaryPage medicalClaimssummaryPage = 
					(MedicalClaimSummaryPage) getLoginScenario()
					.getBean(PageConstants.CLAIM_SUMMARY_PAGE);
			
			if(medicalClaimssummaryPage.Validate_Terminated_Tab() ){
				System.out.println("Terminated Tabs are Displayed");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Terminated Tabs are NOT Displayed");
				Assert.fail();
				}
			}
		else if (PageName.equalsIgnoreCase("EOB")){
			EoBSearchPage EOBsearchPage = 
					(EoBSearchPage) getLoginScenario()
					.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
			if(EOBsearchPage.Validate_Terminated_Tab() ){
				System.out.println("Terminated Tabs are Displayed");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Terminated Tabs are NOT Displayed");
				Assert.fail();
				}
			}
		else if (PageName.equalsIgnoreCase("ContactUs")){
			ContactUsPage contactUspage  = 
					(ContactUsPage) getLoginScenario()
					.getBean(PageConstants.CONTACT_US_PAGE);
			if(contactUspage.Validate_Terminated_Tab() ){
				System.out.println("Terminated Tabs are Displayed");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Terminated Tabs are NOT Displayed");
				Assert.fail();
				}
			}
		else{
			System.out.println("Invalid Page Name Selection");
			Assert.fail();
		}
		
	}
	
/*
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}
*/
}
