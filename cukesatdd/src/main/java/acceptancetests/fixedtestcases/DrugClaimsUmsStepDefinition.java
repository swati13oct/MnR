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
import pages.member.bluelayer.TerminatedHomePage;
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
public class DrugClaimsUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the UHC site login page$")
	    public void uhc_login_page_drug(){
	                   WebDriver wd = getLoginScenario().getWebDriver();
	                   getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

	                   LoginPage loginPage = new LoginPage(wd);
	                   getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	                   
	 }
	  
	@When("^the user logs in to UMS site with following details in UHC site$")
    public void login_with_member_drug(DataTable memberAttributes) {

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
                   
                   if (accountHomePage != null) {
                       			  getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
                       			  
                       			if(accountHomePage.validateAccountHome())
                       				Assert.assertTrue("USERNAME:"+userName, true);
                    			else
                    				Assert.fail("Error in validating the Account Home Page - USERNAME:"+userName);
                   }   
    }
	
	@When("^the user navigates to plan summary page and validates$")
	public void user_navigates_to_plan_summary_ums_drug() {
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
	
	@When("^the user navigates to claim summary page in UMS site for drug claims$")
	public void user_views_drug_claim_summary_ums_drug() {
		PlanSummaryPage planSummaryPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SUMMARY_PAGE);
	
		ClaimSummaryPage claimSummaryPage = planSummaryPage
				.navigateToDrugClaimsSummary();
		
		if (claimSummaryPage != null) {

			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					claimSummaryPage);

			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
					claimSummaryPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("claimSummaryPage Not Available");
		}

	}

	@And("^the user search drug claims for the following claim period in UMS site$")
	public void user_drug_claims_following_period_ums_drug(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		String planCategory = (String) getLoginScenario().getBean(
				CommonConstants.PLAN_CATEGORY);
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()

		.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);

		claimSummaryPage = claimSummaryPage.searchDrugClaimsByPeriod(timeAttributesMap);
		
		
		if (claimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
					claimSummaryPage);

			Assert.assertTrue(true);
		}

	}

	@Then("^user validates the drug claims for the selected time period in UMS site$")
	public void validates_number_drug_claims_ums_drug() {
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		
		if(claimSummaryPage.validateRxClaims()){
			Assert.assertTrue(true);
			System.out.println("Claims were found");
		}else
			Assert.fail("Error in validating claims ");
		
	}
/*	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		CommonUtility.resetMRRestTime(getLoginScenario());
		CommonUtility.resetPartDTime(getLoginScenario());
		getLoginScenario().flushBeans();
	}*/

}

