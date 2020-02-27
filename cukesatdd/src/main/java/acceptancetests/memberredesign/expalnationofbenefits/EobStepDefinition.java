package acceptancetests.memberredesign.expalnationofbenefits;

import gherkin.formatter.model.DataTableRow;

import static org.junit.Assert.assertTrue;

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

import pages.regression.explanationofbenefits.DreamEOBPage;
import pages.regression.explanationofbenefits.EOBPage;
import pages.regression.testharness.TestHarness;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
//import pages.regression.explanationofbenefits.EOBPage;

public class EobStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 *@throws InterruptedException 
	 * @toDo: get the required parameters from the feature files
	 */

	@Given("^registered AMP with for EOB flow$")
	public void registered_AMP_with_attribute_eob_aarp(DataTable memberAttributes) throws InterruptedException{
		//get the required parameters from the feature files
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
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
			getLoginScenario().saveBean(LoginCommonConstants.CATOGERY, category);
		}
		EOBPage eobPage = new EOBPage(wd);
		eobPage.loginToDashboardPage(userName);
		if (eobPage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.EOB_Page, eobPage);
		}

	}


	/**
	 *@toDo: get the required parameters from the feature files 
	 */

	@Then("^the user navigates to EOB page and validates the page$")
	public void the_user_navigates_to_EOB_page_and_validates_the_page(DataTable givenAttributes) {
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

	/**
	 *@toDo: This method is to validate that user navigates to EOB page
	 */

	@Then("^the user navigates to EOB page$")
	public void the_user_navigates_to_EOB_page() {
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.navigateDirectToEOBPag();
		if(eobPage!=null){
			getLoginScenario().saveBean(PageConstants.MEDICAL_EOB_PAGE,
					eobPage);
		} 
	}

	/**
	 *@toDo: This method is to validate the How to read Medical EOB link and Video link is working
	 */

	@And("^the user validates how to read medical eob PDF$")
	public void the_user_validates_how_to_read_medical_eob_PDF(DataTable givenAttributes) {
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}

			String eobTypeData = memberAttributesMap.get("EOB Type");
			if(eobTypeData.toLowerCase().contains("medical")) {
					EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateReadPDF();		 
			}
	}

	/**
	 *@toDo:  this method validates size/date/link displayed on UI for each EOB
	 */

	@Then("^the user validates EOB statments displayed$")
	public void the_user_validates_EOB_statments_displayed() {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.MEDICAL_EOB_PAGE);
		eobPage.validateEachEOBonUI();		 
	}

	/**
	 *@toDo: the method validates the EOB Type and Date range for MAPD members
	 */

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

	/**
	 *@toDo: the method validates EOB video link on EOB page
	 */

	@And("^the user validates How to read your Medical EOB video$")
	public void the_user_validates_how_to_read_medical_eob_Video() {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.MEDICAL_EOB_PAGE);
		eobPage.validateEobVideo();
	}

	/**
	 *@toDo: the method validates Pagination functionality on EOB page
	 */

	@And("the user validates pagination functionality")
	public void validate_pagination(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

	}

	/**
	 *@toDo: the method validates site leaving popup on EOB page
	 */

	@Then("^the user validates site leaving pop up$")
	public void user_validates_site_leaving_poup(){
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateSiteLeaveingPopUP();
	}

	/**
	 *@toDo: the method validates the date range functionality on EOB page
	 */	

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

	/**
	 *@toDo:  the method validates the content displayed on EOB page
	 */

	@Then("^the user validates content displayed on EOB page$")
	public void user_validates_content_displayed_on_EOB_page(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Tab");
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);

		eobPage.navigatePlanTabs(planType);
		eobPage.validateDropDowns(planType);

	}

	/**
	 *@toDo: the method validates the content displayed on EOB page
	 */

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

	/**
	 *@toDo: the method is used to select the date range
	 */

	@And("^the user selects the desired date range$")
	public void user_selects_the_desired_date_range(DataTable givenAttributes){
		/*List<DataTableRow> memberAttributesRow = givenAttributes
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
		eobPage.selectDateRange(dateRange, planType, eobTypeData);*/

	}	


	/**
	 *@toDo: the method validates the eob count
	 */

	@Then("^the user validates EOB count$")
	public void user_validated_EOB_Count(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String eobCount = memberAttributesMap.get("EOB COUNT");
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateEOBStatements(eobCount);
	}

	@And("^the user clicks on first eob from the list$")
	public void the_user_clicks_on_first_eob_from_the_list() throws InterruptedException {

		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);

		eobPage.clickOnEob();
	}

	@Then("^the user navigates to EOB page_hsid$")
	public void user_views_EOBpagehsid() throws InterruptedException {   
		System.out.println("****the user navigates to EOB page_hsid****");
		pages.regression.explanationofbenefits.EOBPage eobPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			eobPage = testHarness.navigateDirectToEOBPag();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			eobPage = accountHomePage.navigateDirectToEOBPag();
		}

		if (eobPage!=null){
			getLoginScenario().saveBean(PageConstants.EOB_Page, eobPage);
			System.out.println("user is on the EOB page"); 
		}     
		else
			Assert.assertTrue("Issue : EOB Page is not Displayed", eobPage!=null);
	}

	@And("^the user gets the error message for PHIP member$")
	public void user_gets_error_message_PHIP(){
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validatePHIPErorrMessage();	
	}




	/**
	 * DREAM EOB Step Definition
	 */

	@Then("^the user navigates to Dream EOB Page$")
	public void user_views_dream_EOB() throws InterruptedException {   
		System.out.println("****the user navigates to EOB page_hsid****");
		DreamEOBPage DreameobPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			DreameobPage = testHarness.navigateDirectToDreamEOBPag();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			DreameobPage = accountHomePage.navigateDirectToDreamEOBPag();
		}

		if (DreameobPage!=null){
			getLoginScenario().saveBean(PageConstants.EOB_Page, DreameobPage);
			System.out.println("user is on the EOB page"); 
		}     
		else
			Assert.assertTrue("Issue : EOB Page is not Displayed", DreameobPage!=null);
	}


	@Then("^the user validates EOB type dropdown is not displayed on Dream EOB page$")
	public void the_user_validates_EOB_type_dropdown_is_not_displayed_on_Dream_EOB_page() throws Throwable {
		DreamEOBPage eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validate_EOBdropDownNotDisplayed();
	}

	@Then("^the user validates Learn More Link and section on Dream EOB Page$")
	public void the_user_validates_Learn_More_Link_and_section_on_Dream_EOB_Page() throws Throwable {
		DreamEOBPage eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validate_LearnMoreSection();

	}

	@Then("^the user validates the EOB table for Medical only EOBs$")
	public void the_user_validates_the_EOB_table_for_Medical_only_EOBs() throws Throwable {
		DreamEOBPage eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validate_MedicalOnlyEOB();

	}
	
	@Then("^the user validates the EOB table for Rx only EOBs$")
	public void the_user_validates_the_EOB_table_for_Rx_only_EOBs() throws Throwable {
		DreamEOBPage eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validate_RxOnlyEOB();

	}

	@Then("^the user validates the date range dropdown$")
	public void the_user_valiudates_the_date_range_dropdown() throws Throwable {
		DreamEOBPage eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateDateRangeDropDowns();

	}

	@Then("^the user selects the desired date range on Dream EOB Page$")
	public void the_user_slects_the_desired_date_range_on_Dream_EOB_Page(DataTable arg1) throws Throwable {
		DreamEOBPage eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String dateRange = memberAttributesMap.get("Date Range");
		eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.selectDateRange(dateRange);
	}

	@Then("^the user validates EOB count on Dream EOB Page$")
	public void the_user_validates_EOB_count_on_Dream_EOB_Page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String eobCount = memberAttributesMap.get("EOB COUNT");
		DreamEOBPage eobPage =  (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateEOBStatements(eobCount);
}

	@Then("^the user validates EOB PDF size is not (\\d+)kb on Dream EOB Page$")
	public void the_user_validates_EOB_PDF_size_is_not_kb_on_Dream_EOB_Page(int arg1) throws Throwable {
	}

	/*@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean("webDriver");
		if(wd!=null){
		wd.quit();
		}*/


}

