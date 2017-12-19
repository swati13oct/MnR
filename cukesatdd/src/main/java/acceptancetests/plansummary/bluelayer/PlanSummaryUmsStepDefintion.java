/**
 * 
 */
package acceptancetests.plansummary.bluelayer;

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
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.PlanSummaryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.plansummary.data.PlanSummaryCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */
public class PlanSummaryUmsStepDefintion {

	@Autowired
	MRScenario loginScenario;
	boolean flagValue;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered member to verify plan summary page in UMS site$")
	public void registered_member_plansummary_ums(DataTable memberAttributes) {
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

		getLoginScenario().saveBean(CommonConstants.CATEGORY, category);

		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd,category);
		JSONObject accountHomeActualJson = null;
		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);
	}
	
	@Given("^registered member to login in UMS site$")
	public void registered_member_UMS(DataTable memberAttributes){
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

		getLoginScenario().saveBean(CommonConstants.CATEGORY, category);

		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd,category);
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
		}
		
	}

	@When("^the user navigates to plan summary page in UMS site$")
	public void user_views_plan_summary_Ums() {
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PlanSummaryPage planSummaryPage = accountHomePage
				.navigateToPlanSummary();

		// get expected data
		JSONObject planSummaryExpectedJson = planSummaryPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				PlanSummaryCommonConstants.PLAN_SUMMARY_EXPECTED,
				planSummaryExpectedJson);

		// get Actual data
		JSONObject planSummaryActualJson = planSummaryPage.planSummaryJson;
		getLoginScenario().saveBean(
				PlanSummaryCommonConstants.PLAN_SUMMARY_ACTUAL,
				planSummaryActualJson);
		getLoginScenario().saveBean(PageConstants.PLAN_SUMMARY_PAGE,
				planSummaryPage);

	}
	
	@When("^the user navigates to plan summary page under my plans in UMS site$")
	public void navigates_plansummary_myPlan_UMS(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PlanSummaryPage planSummaryPage = accountHomePage
				.navigateToPlanSummary();
		getLoginScenario().saveBean(PageConstants.PLAN_SUMMARY_PAGE,
				planSummaryPage);
	}

	@Then("^the user validates different resources in UMS site$")
	public void user_validates_plan_summary_ums() {
		PlanSummaryPage planSummaryPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SUMMARY_PAGE);

		JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(PlanSummaryCommonConstants.PLAN_SUMMARY_ACTUAL);
		System.out.println("planSummaryActualJson======>"
				+ planSummaryActualJson.toString());

		JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PlanSummaryCommonConstants.PLAN_SUMMARY_EXPECTED);
		System.out.println("planSummaryExpectedJson===>"
				+ planSummaryExpectedJson.toString());
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		planSummaryPage.logOut();
	}
	

	@Then("^the user click on the view detail button in UMS site$")
	public void user_click_on_view_details_button() {
		PlanSummaryPage planSummaryPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SUMMARY_PAGE);
		 planSummaryPage.navigateToViewDetails();
		
		// planSummaryPage.logOut();     
		 
		}

	@Then("^the user validates pharmacy saver widget in UMS site$")
	public void validates_pharmacySaver_UMS(){
		PlanSummaryPage planSummaryPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SUMMARY_PAGE);
		planSummaryPage.validatePharmacySaver();
		planSummaryPage.logOut();
	}

	 @Then("^user validate view details button is not displayed for  group LIS 3$")
	  
	 public void user_validates_view_button()
	    {
		 PlanSummaryPage planSummaryPage = (PlanSummaryPage) getLoginScenario().getBean(PageConstants.PLAN_SUMMARY_PAGE);

			
			boolean flagValue=planSummaryPage.validateViewDetailsButton();
			if(!flagValue){
				Assert.assertTrue(true);
			}else{
				Assert.assertTrue(false);
 }
			
			
}
@Then("the user validate add a plan link is not displayed for albama memeber$")
	 
	 public void user_validates_addaplan_link()
	    {PlanSummaryPage planSummaryPage = (PlanSummaryPage) getLoginScenario().getBean(PageConstants.PLAN_SUMMARY_PAGE);

			
			boolean flagValue=planSummaryPage.validateaddaplanlink();
			if(!flagValue){
				System.out.println("add a plan link is not displayed");
				Assert.assertTrue(true);
 			}else{
 				System.out.println("add a plan link is displayed");
				Assert.assertTrue(false);
 			}	
 }
@Given("^the user is on the vpp portfolio page$")
     public void user_on_aarp_ourPlans_page(){
             WebDriver wd = getLoginScenario().getWebDriver();
             PlanSummaryPage ourPlans = new PlanSummaryPage(wd);

             getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
             getLoginScenario().saveBean(PageConstants. PLAN_SUMMARY_PAGE, ourPlans);
     }
	 
	 /*@Then("^the user performs plan search using zipcode$")
     public void user_planSearch_with_zipcode(DataTable givenAttributes){
             List<DataTableRow> memberAttributesRow = givenAttributes
                             .getGherkinRows();
             Map<String, String> memberAttributesMap = new HashMap<String, String>();
             for (int i = 0; i < memberAttributesRow.size(); i++) {

                     memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                     .get(0), memberAttributesRow.get(i).getCells().get(1));
             }

             String zipcode = memberAttributesMap.get("Zip Code");
             getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
             String county = memberAttributesMap.get("County");
             getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
             PortfolioPageUhc PortfolioPageUhc = (PortfolioPageUhc) getLoginScenario()
                             .getBean(PageConstants. PORTFOLIO_PAGE_UHC);
             ResponsivePlanSummaryUhc vppPlan = PortfolioPageUhc.searchPlans(zipcode, county);
             if(vppPlan!=null){
                     getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC, vppPlan);
             }else{
                     Assert.fail();
             }
     }*/
}





