
/*
 * @author sdwaraka
 * 
 */
package acceptancetests.shipplans.ulayer;
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
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
* @author sdwaraka
*
*/
public class ShipPlansStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP member with SHIP combo plans$")
	public void registered_member_SHIPplans() throws InterruptedException {

		/* Reading the given attribute from feature file */
		/*List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");*/
		String businessType = "SHIP";
		
		getLoginScenario().saveBean(ClaimsCommonConstants.BUSINESS_TYPE,
				businessType);

		//Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		desiredAttributes.add("SHIP");
		/*for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				if (!memberAttributesMap.get(key).isEmpty()) {
					desiredAttributes.add(memberAttributesMap.get(key));
				}
			}
		}*/
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario
				.getAMPMemberWithDesiredAttributes(desiredAttributes);

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

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		JSONObject accountHomeActualJson = null;
		UlayerLoginPage loginPage = new UlayerLoginPage(wd);

		UlayerHomePage accountHomePage = (UlayerHomePage)loginPage.loginWith(userName, pwd);
		
		 getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,accountHomePage);
		

		/* Get expected data */
		/*Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);*/

	}
	
	@When("^the user navigates to mentioned page in AARP site$")
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
				getLoginScenario().saveBean(PageConstants.MEDICAL_EOB_PAGE,
						planBenefitsCoverage);
				Assert.assertTrue(true);
			}
			else {
				Assert.fail("Error in loading  EOB Page");
			}
		}
		else if (PageName.equalsIgnoreCase("Profile")){
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
		}
		else if (PageName.equalsIgnoreCase("Payment")){
			UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			PaymentHistoryPage paymentHistorypage = accountHomePage.navigateToPayments();
			if (paymentHistorypage != null) {
				System.out.println("Payment page Loaded");
				getLoginScenario().saveBean(PageConstants.PAYMENT_HISTORY_PAGE,
						paymentHistorypage);
				Assert.assertTrue(true);
			}
			else {
				Assert.fail("Error in loading Payment History Page");
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
					.getBean(PageConstants.CLAIM_SUMMARY_PAGE);
			
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
					.getBean(PageConstants.PROF_AND_PREF_PAGE);
			
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
					.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
			
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
		
	
	

	/*@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}*/

	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
