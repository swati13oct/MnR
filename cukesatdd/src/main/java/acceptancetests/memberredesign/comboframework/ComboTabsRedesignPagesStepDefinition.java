
/*
 * @author sdwaraka
 * 
 */
package acceptancetests.memberredesign.comboframework;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.redesign_deprecated.ContactUsPage;
import pages.redesign_deprecated.EoBSearchPage;
import pages.redesign_deprecated.GoGreenPreferencesPage;
import pages.redesign_deprecated.MedicalClaimSummaryPage;
import pages.redesign_deprecated.MyProfilesPage;
import pages.redesign_deprecated.PaymentHistoryPage;
import pages.redesign_deprecated.RedesignLoginPage;
import pages.redesign_deprecated.UlayerHomePage;
/**
* @author sdwaraka
*
*/
/**
* Functionality: Combo tabs in redesign page
*/
public class ComboTabsRedesignPagesStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	/**
	* @todo : Registration of combo members
	*/

	@Given("^registered Combo Plans member with following attribute$")
	public void registered_member_with_following_attributes(DataTable memberAttributes) throws InterruptedException {
		
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

		RedesignLoginPage loginPage = new RedesignLoginPage(wd);

		UlayerHomePage accountHomePage = (UlayerHomePage) loginPage.loginWith(userName, pwd);

		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);



	}
	
	/**
	* @todo : Navigation to different pages from dashboard
	*/
	
	@When("^the user navigates to mentioned page in Redesign site$")
	public void views_pages_in_Ums_site(DataTable givenAttributes) throws InterruptedException {
		
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
				getLoginScenario().saveBean(PageConstantsMnR.CLAIM_SUMMARY_PAGE,
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
			EoBSearchPage eobSearchPage = accountHomePage.navigateToEOBsearchPage();
			if (eobSearchPage != null) {
				System.out.println("EOB page Loaded");
				getLoginScenario().saveBean(PageConstantsMnR.MEDICAL_EOB_PAGE,
						eobSearchPage);
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
				getLoginScenario().saveBean(PageConstantsMnR.PROF_AND_PREF_PAGE,
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
					getLoginScenario().saveBean(PageConstantsMnR.MY_PREFERENCES_PAGE, goGreenPage);
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
	/**
	* @todo : Verifying terminated tab not coming for combo scenario
	*/

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
			MyProfilesPage myProfilepage = (MyProfilesPage) getLoginScenario().getBean(PageConstantsMnR.PROF_AND_PREF_PAGE);			
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
			GoGreenPreferencesPage goGreenPage = (GoGreenPreferencesPage) getLoginScenario().getBean(PageConstantsMnR.MY_PREFERENCES_PAGE);
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
	/**
	* @todo : Verifying only terminated tabs information
	*/
			
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
					.getBean(PageConstantsMnR.CLAIM_SUMMARY_PAGE);
			
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
					.getBean(PageConstantsMnR.MEDICAL_EOB_PAGE);
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

	@Then("^the user validates single tab for all SHIP plans$")
	public void user_validates_single_tab(DataTable givenAttributes) {
		
		
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PageName = givenAttributesMap.get("SHIP Page");
		System.out.println(PageName);
		//switch(PageName){
		
		if (PageName.equalsIgnoreCase("Claims")){
			MedicalClaimSummaryPage medicalClaimssummaryPage = 
					(MedicalClaimSummaryPage) getLoginScenario()
					.getBean(PageConstantsMnR.CLAIM_SUMMARY_PAGE);
			
			if(medicalClaimssummaryPage.Validate_Single_Tab_SHIP() ){
				System.out.println("**********CLAIMS Page - Single Tab displayed for all SHIP Plans");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("**********CLAIMS Page - Single Tab NOT displayed for all SHIP Plans");
				Assert.fail();
				}
			}
		else if (PageName.equalsIgnoreCase("EOB")){
			EoBSearchPage planBenefitsCoverage = 
					(EoBSearchPage) getLoginScenario()
					.getBean(PageConstants.MEDICAL_EOB_PAGE);
			
			if(planBenefitsCoverage.Validate_Single_Tab_SHIP() ){
				System.out.println("**********EOB Page - Single Tab displayed for all SHIP Plans");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("**********EOB Page - Single Tab NOT displayed for all SHIP Plans");
				Assert.fail();
				}
			}
		else if (PageName.equalsIgnoreCase("Profile")){
			MyProfilesPage myProfilepage = 
					(MyProfilesPage) getLoginScenario()
					.getBean(PageConstantsMnR.PROF_AND_PREF_PAGE);
			
			if(myProfilepage.Validate_Single_Tab_SHIP() ){
				System.out.println("**********Profile Page - Single Tab displayed for all SHIP Plans");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("**********Profile Page - Single Tab NOT displayed for all SHIP Plans");
				Assert.fail();
				}
			}
		else if (PageName.equalsIgnoreCase("Payment")){
			PaymentHistoryPage paymentHistorypage  = 
					(PaymentHistoryPage) getLoginScenario()
					.getBean(PageConstantsMnR.PAYMENT_HISTORY_PAGE);
			
			if(paymentHistorypage.Validate_Single_Tab_SHIP() ){
				System.out.println("**********Payment Page - Single Tab displayed for all SHIP Plans");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("**********Payment Page - Single Tab NOT displayed for all SHIP Plans");
				Assert.fail();
				}
			}
		else if (PageName.equalsIgnoreCase("ContactUs")){
			ContactUsPage contactUspage  = 
					(ContactUsPage) getLoginScenario()
					.getBean(PageConstants.CONTACT_US_PAGE);
			
			if(contactUspage.Validate_Single_Tab_SHIP() ){
				System.out.println("**********Contact Us Page - Single Tab displayed for all SHIP Plans");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("**********Contact Us Page - Single Tab NOT displayed for all SHIP Plans");
				Assert.fail();
				}
			}
		else{
			System.out.println("Invalid Page Name Selection");
			Assert.fail();
		}
		
	}
	

	@When("^the user Navigates to AARP Member Redesign My Profile and Preferences page$")
	public void the_user_Navigates_to_Member_Redesign_My_Profile_and_Preferences_page() throws InterruptedException {
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MyProfilesPage myProfilepage = accountHomePage.navigateToProfAndPref();
		if (myProfilepage != null) {
			System.out.println("Profile page Loaded");
			getLoginScenario().saveBean(PageConstantsMnR.PROF_AND_PREF_PAGE, myProfilepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in Loading Profile and Preferences Summary Page");
		}

	}

	@When("^the user Navigates to BlueLayer Member Redesign My Profile and Preferences page$")
	public void the_user_Navigates_to_UMS_Member_Redesign_My_Profile_and_Preferences_page() throws InterruptedException {
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MyProfilesPage myProfilepage = accountHomePage.navigateToProfAndPref();
		if (myProfilepage != null) {
			System.out.println("Profile page Loaded");
			getLoginScenario().saveBean(PageConstantsMnR.PROF_AND_PREF_PAGE, myProfilepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in Loading Profile and Preferences Summary Page");
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
