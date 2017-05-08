package acceptancetests.fixedtestcases;

import gherkin.formatter.model.DataTableRow;

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

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.ClaimDetailsPage;
import pages.member.bluelayer.ClaimSummaryPage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.PlanSummaryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;

/**
 * @author pagarwa5
 *
 */
public class MedicalClaimsUMSStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
    @Given("^the user is on the UHC medicare site login page$")
    public void uhc_login_page(){
                   WebDriver wd = getLoginScenario().getWebDriver();
                   getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

                   LoginPage loginPage = new LoginPage(wd);
                   getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
                   
    }
    
    @When("^the user logs in with a registered UMP with following details in UHC site$")
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

                   Map<String,String> loginCreds = loginScenario
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
                                  getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
                                  getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
                   }
                   
                   LoginPage loginPage = (LoginPage)getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
                   
                   AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
                   
                   
                   JSONObject accountHomeActualJson =  null;
                   if (accountHomePage != null) {
                       			  getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
                                  
                   }

    }


	@When("^the user logs in with the following attributes in UMS site for medical claims$")
	public void registered_UMS_with_attributes_medical_claims_UMS(
			DataTable memberAttributes) {
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
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}
		
		 LoginPage loginPage = (LoginPage)getLoginScenario().getBean(PageConstants.LOGIN_PAGE);		
		 AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd,category);
	
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			
			Assert.assertTrue(true);
		}
	}
	
	@When("^the user navigates to plan summary page in UMS site and validates$")
	public void user_navigates_to_plan_summary_ums() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		
		PlanSummaryPage planSummaryPage = new PlanSummaryPage(wd);
		getLoginScenario().saveBean(PageConstants.PLAN_SUMMARY_PAGE,wd);
		planSummaryPage = accountHomePage.navigateToPlanSummary();
		
		if(planSummaryPage!=null){
			getLoginScenario().saveBean(PageConstants.PLAN_SUMMARY_PAGE, planSummaryPage);
			Assert.assertTrue(true);
			
			if(planSummaryPage.validateClaims()){
				Assert.assertTrue(true);
			}else
				Assert.fail("Error in validating the claims on Plan Summary Page");
		}
	}

	@When("^the user navigates to claim summary page in UMS site$")
	public void user_views_claim_summary_ums() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PlanSummaryPage planSummaryPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SUMMARY_PAGE);
		
		ClaimSummaryPage claimSummaryPage = new ClaimSummaryPage(wd);
		getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,wd);
		
		claimSummaryPage = planSummaryPage.navigateToMedicalClaimsSummary();
		if (claimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
					claimSummaryPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("claimSummaryPage Not Available");
		}

	}

	@And("^user searches the claims for the following period in UMS site$")
	public void user_claims_following_period_ums(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.CLAIM_SUMMARY_PAGE);
		claimSummaryPage = claimSummaryPage
				.searchClaimsByPeriod(timeAttributesMap);
		
		if (claimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
					claimSummaryPage);
			Assert.assertTrue(true);
			
		}

	}

	@And("^user validates the medical claims for the selected time period in UMS site$")
	public void validates_claims_Summary_ums(DataTable timeAttributes) {
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.CLAIM_SUMMARY_PAGE);
		
		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		if(claimSummaryPage!=null){
			if(claimSummaryPage.validateClaims()){
				Assert.assertTrue(true);
				System.out.println("Claims were found in the following time range: "+timeAttributesMap.get("Claim Period"));
				
			}else
				Assert.fail("Claims were not found in the following time range: "+timeAttributesMap.get("Claim Period"));
		}
	}

	@Then("^user views medical claim details for individual claim in UMS site and validates them$")
	public void user_claims_details_ums() {
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.CLAIM_SUMMARY_PAGE);
		ClaimDetailsPage claimDetailsPage = claimSummaryPage.getClaimDetail();
		
		if (claimDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.CLAIM_DETAILS_PAGE,
					claimDetailsPage);
			Assert.assertTrue(true);
			if(claimDetailsPage.validateMoreInfo()){
				Assert.assertTrue(true);
				System.out.println("More Info link has the appropriate elements");
			}else
				Assert.fail("Could not verify the More Info elements");
		
		}
		tearDown();
	}
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		CommonUtility.resetMRRestTime(getLoginScenario());
		CommonUtility.resetPartDTime(getLoginScenario());
		getLoginScenario().flushBeans();
	}

}

