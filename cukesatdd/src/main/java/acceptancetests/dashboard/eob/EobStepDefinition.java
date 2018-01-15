package acceptancetests.dashboard.eob;

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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.eob.EOBPage;
import pages.dashboard.member.ulayer.RallyDashboardPage;
import pages.member.ulayer.TeamHLoginUlayer;

 
public class EobStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^registered AMP with for EOB flow$")
	public void registered_AMP_with_attribute_eob_aarp(DataTable givenAttributes){
	//get the required parameters from the feature files
		
		List<DataTableRow> memberAttributesRow = givenAttributes
		.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
			.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String userName = memberAttributesMap.get("Member Type");	
		WebDriver wd = getLoginScenario().getWebDriver();
        getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
        
        EOBPage eobPage = new EOBPage(wd);
        eobPage.loginToDashboardPage(userName);
        if (eobPage != null) {
        	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
        	getLoginScenario().saveBean(PageConstants.EOB_Page, eobPage);
        }

	}
	
 	@Then("^the user navigates to EOB page and validates the page$")
	public void the_user_navigates_to_EOB_Page_and_validates_the_page(DataTable givenAttributes) {
		//get the required parameters from the feature files
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String dateRange = memberAttributesMap.get("Date Range");
		String planType  = memberAttributesMap.get("Plan Type");
		String eobTypeData = memberAttributesMap.get("EOB Type");
		String fromDate = memberAttributesMap.get("From Date");
		String toDate = memberAttributesMap.get("To Date");
		
		getLoginScenario().saveBean(CommonConstants.PLAN_TYPE, planType);

 	     //Pass the direct URL to validate the page
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.navigateDirectToEOBPag();		 
		eobPage.selectDateRange(dateRange, planType, eobTypeData);
		if(eobPage!=null){
			getLoginScenario().saveBean(PageConstants.EOB_Page, eobPage);
			System.out.println("user is on EOB page");
		} 
	}
 	@Then("^the user navigates to EOB page$")
	public void the_user_navigates_to_EOB_Page() {
 		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario().getBean(PageConstants.RALLY_DASHBOARD_PAGE);
 		EOBPage eobPage= rallyDashboard.navigateToEOBPage();
 		if(null != eobPage){
 			getLoginScenario().saveBean(PageConstants.EOB_Page,
					eobPage);
 		}
 		else
 		{
 			Assert.fail("EOB page is not displayed");
 		}
	}
	@And("^the user validates how to read medical eob PDF$")
	public void the_user_validates_how_to_read_medical_eob_PDF() {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateReadPDF();		 
	}
	@Then("^the user validates EOB statments displayed$")
	public void the_user_validates_EOB_statments_displayed() {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
        eobPage.validateEachEOBonUI();		 
	}
	
	@Then("^the user validates EOB type and Date Range for MAPD$")
	public void the_user_validates_EOB_type_and_Date_Range_for_MAPD(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType  = memberAttributesMap.get("Plan Type");
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
        System.out.println(planType);
		eobPage.validateDropDowns(planType);		 
	}
	@And("^the user validates How to read your Medical EOB video$")
	public void the_user_validates_how_to_read_medical_eob_Video() {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateEobVideo();
	}
	
	@And("the user validates pagination functionality")
	public void validate_pagination(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String dateRange = memberAttributesMap.get("Date Range");
		String planType  = memberAttributesMap.get("Plan Type");
		String eobTypeData = memberAttributesMap.get("EOB Type");
		String fromDate = memberAttributesMap.get("From Date");
		String toDate = memberAttributesMap.get("To Date");
	}
	
	
	@Then("^the user validates site leaving pop up$")
	public void user_validates_site_leaving_poup(){
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
        eobPage.validateSiteLeaveingPopUP();
	}
	
	@And("^the user slects the desired date range$")
	public void user_selects_date_range(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String dateRange = memberAttributesMap.get("Date Range");
		String planType  = memberAttributesMap.get("Plan Type");
		String eobTypeData   = memberAttributesMap.get("EOB Type");
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.selectDateRange(dateRange, planType, eobTypeData);
	}
	
	@Then("^the user validates content displayed on EOB page$")
	public void user_validates_content_displayed_on_EOB_Page(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
 		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
 		
 		eobPage.navigatePlanTabs(planType);
 		eobPage.validateDropDowns(planType);
		
	}
	
	@Then("^the user validates content displayed on EOB page without combo tabs$")
	public void user_validates_content_displayed_on_EOB_Page_without_combo_tabs(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
 		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
  		eobPage.validateDropDowns(planType);
	}
		
	@And("^the user selects the desired date range$")
	public void user_selects_the_desired_date_range(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String eobTypeData = memberAttributesMap.get("EOB Type");
		String dateRange = memberAttributesMap.get("Date Range");

		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.selectDateRange(dateRange, planType, eobTypeData);
		
	}	
	@Then("^the user validates EOB count$")
	public void user_validated_EOB_Count(){
		 
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateEOBStatements();
	}
	@Given("^I am a authenticated member on the member redesign site$")
	public void I_am_a_authenticated_member_on_the_member_redesign_site(DataTable memberAttributes) {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
System.out.println(memberAttributesRow.get(i).getCells()
		.get(0)+"----"+ memberAttributesRow.get(i).getCells().get(1));
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
			getLoginScenario().saveBean(LoginCommonConstants.CATOGERY, category);
		}
	}
	
	@When("^the above plantype user logs in UMS Site Desktop$")
	public void plantype_user_logs_in() throws InterruptedException {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		String category = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		
		TeamHLoginUlayer THloginPage = new TeamHLoginUlayer(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) THloginPage.loginWith(userName, pwd);
		if (rallyDashboard != null) {
			getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE,
					rallyDashboard);
			Assert.assertTrue(true);
		}	
	}
	
	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean("webDriver");
		if(wd!=null){
		wd.quit();
		}
		
	}
}
