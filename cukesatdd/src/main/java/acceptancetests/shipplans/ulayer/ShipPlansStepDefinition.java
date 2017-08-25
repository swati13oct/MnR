
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

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.ContactUsPage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.MedicalClaimSummaryPage;
import pages.member.ulayer.MyProfilesPage;
import pages.member.ulayer.OrderplanmaterialsPage;
import pages.member.ulayer.PaymentHistoryPage;
import pages.member.ulayer.PlanBenefitsCoveragePage;
import pages.member.ulayer.PlanMaterialConfirmationPage;
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
* @author pperugu
*
*/
public class ShipPlansStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP member with SHIP combo plans$")
	public void registered_member_SHIPplans() {

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
		LoginPage loginPage = new LoginPage(wd);

		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);
		
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
		switch(PageName){
		case "Claims" :{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			MedicalClaimSummaryPage medicalClaimssummaryPage = accountHomePage.navigateToMedicalClaimsSummary();
			if (medicalClaimssummaryPage != null) {
				System.out.println("Claims not null");
				getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
						medicalClaimssummaryPage);
				Assert.assertTrue(true);
			}
			else {
				Assert.fail("Error in loading  Claims Summary Page");
			}
			break;
		}
		case "EOB" :{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			PlanBenefitsCoveragePage planBenefitsCoverageage = accountHomePage.navigateToBenefitsAndCoverage();
			if (planBenefitsCoverageage != null) {
				getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE,
						planBenefitsCoverageage);
				Assert.assertTrue(true);
			}
			else {
				Assert.fail("Error in loading  EOB Page");
			}
			break;
		}
		case "Profile" :{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			MyProfilesPage myProfilepage = accountHomePage.navigateToProfAndPref();
			if (myProfilepage != null) {
				getLoginScenario().saveBean(PageConstants.PROF_AND_PREF_PAGE,
						myProfilepage);
				Assert.assertTrue(true);
			}
			else {
				Assert.fail("Error in Loading Profile and Preferences Summary Page");
			}
			break;
		}
		case "Payment" :{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			PaymentHistoryPage paymentHistorypage = accountHomePage.navigateToPayments();
			if (paymentHistorypage != null) {
				getLoginScenario().saveBean(PageConstants.PAYMENT_HISTORY_PAGE,
						paymentHistorypage);
				Assert.assertTrue(true);
			}
			else {
				Assert.fail("Error in loading Payment History Page");
			}
			break;
		}
		case "ContactUs" :{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			ContactUsPage contactUspage = accountHomePage.navigatesToContactUsPage();
			if (contactUspage != null) {
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactUspage);
				Assert.assertTrue(true);
			}
			else {
				Assert.fail("Error in loading  Contact Us Page");
			}
			break;
		}
		
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
		switch(PageName){
		
		case "Claims" :{
			MedicalClaimSummaryPage medicalClaimssummaryPage = 
					(MedicalClaimSummaryPage) getLoginScenario()
					.getBean(PageConstants.CLAIM_SUMMARY_PAGE);
			
			if(medicalClaimssummaryPage.Validate_Single_Tab_SHIP() ){
				System.out.println("**********Single Tab displayed for all SHIP Plans");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("**********Single Tab NOT displayed for all SHIP Plans");
				}
			break;
			}
		case "EOB" :{
			PlanBenefitsCoveragePage planBenefitsCoverage = 
					(PlanBenefitsCoveragePage) getLoginScenario()
					.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
			
			if(planBenefitsCoverage.Validate_Single_Tab_SHIP() ){
				System.out.println("**********Single Tab displayed for all SHIP Plans");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("**********Single Tab NOT displayed for all SHIP Plans");
				}
			break;
			}
		case "Profile" :{
			MyProfilesPage myProfilepage = 
					(MyProfilesPage) getLoginScenario()
					.getBean(PageConstants.PROF_AND_PREF_PAGE);
			
			if(myProfilepage.Validate_Single_Tab_SHIP() ){
				System.out.println("**********Single Tab displayed for all SHIP Plans");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("**********Single Tab NOT displayed for all SHIP Plans");
				}
			break;
			}
		case "Payment" :{
			PaymentHistoryPage paymentHistorypage  = 
					(PaymentHistoryPage) getLoginScenario()
					.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
			
			if(paymentHistorypage.Validate_Single_Tab_SHIP() ){
				System.out.println("**********Single Tab displayed for all SHIP Plans");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("**********Single Tab NOT displayed for all SHIP Plans");
				}
			break;
			}
		case "ContactUs" :{
			ContactUsPage contactUspage  = 
					(ContactUsPage) getLoginScenario()
					.getBean(PageConstants.CONTACT_US_PAGE);
			
			if(contactUspage.Validate_Single_Tab_SHIP() ){
				System.out.println("**********Single Tab displayed for all SHIP Plans");
				Assert.assertTrue(true);
			}
			else{
				System.out.println("**********Single Tab NOT displayed for all SHIP Plans");
				}
			break;
			}
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
