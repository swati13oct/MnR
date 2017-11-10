package acceptancetests.dashboard.eob;

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
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.eob.EOBPage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;

 
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
	public void the_user_navigates_to_EOB_page_and_validates_the_page(DataTable givenAttributes) {
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
	public void the_user_navigates_to_EOB_page() {
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.navigateDirectToEOBPag();
		if(eobPage!=null){
			getLoginScenario().saveBean(PageConstants.MEDICAL_EOB_PAGE,
					eobPage);
		} 
	}
	@And("^the user validates how to read medical eob PDF$")
	public void the_user_validates_how_to_read_medical_eob_PDF() {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.MEDICAL_EOB_PAGE);
		eobPage.validateReadPDF();		 
	}
	@Then("^the user validates EOB statments displayed$")
	public void the_user_validates_EOB_statments_displayed() {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.MEDICAL_EOB_PAGE);
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
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.MEDICAL_EOB_PAGE);
        System.out.println(planType);
		eobPage.validateDropDowns(planType);		 
	}
	@And("^the user validates How to read your Medical EOB video$")
	public void the_user_validates_how_to_read_medical_eob_Video() {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.MEDICAL_EOB_PAGE);
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
	public void user_validates_content_displayed_on_EOB_page(DataTable givenAttributes){
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
	public void user_validates_content_displayed_on_EOB_page_without_combo_tabs(DataTable givenAttributes){
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
	
	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean("webDriver");
		if(wd!=null){
		wd.quit();
		}
		
	}
}
