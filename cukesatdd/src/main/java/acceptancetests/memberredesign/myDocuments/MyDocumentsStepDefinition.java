package acceptancetests.memberredesign.myDocuments;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.planDocumentsAndResources.PlanDocumentsAndResourcesCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.myDocumentsPage.MyDocumentsPage;
import pages.regression.planDocumentsAndResources.PlanDocumentsAndResourcesPage;
import pages.regression.testharness.TestHarness;

/**
 * Step definitions for my Documents Page on the member site.
 */
public class MyDocumentsStepDefinition {

	@Autowired
	MRScenario loginScenario;
	public static int previousNumberOfRowsInDocumentsTable;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public static Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}	
	
	/* to verify the my doc section */
	@Then("^validate that My Document section is displayed on Plan And Resources Page$")
	public void mydocumentsectionisdispayed() throws InterruptedException {
		/* tbd 
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		if (formsAndResourcesPage.getMyDocumentSection().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("my doc sec is present");

		} else {
			Assert.fail("my doc section is not present");
		} */
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		
		boolean result=planDocumentsAndResourcesPage.isMyDocumentSectionExist();
		Assert.assertTrue("PROBLEM - my doc section is not present", result);

	}


	/**
	 * This step will let the user navigate to My Documents Page from Forms and Resources page
	 */
	@When("^the user navigates to my Documents Page$")
	public void user_navigates_to_MyDocuments_page(DataTable memberAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType=memberAttributesMap.get("Plan Type");
		String memberType=memberAttributesMap.get("Member Type");
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE, planType);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE, memberType);

		if (("YES".equalsIgnoreCase(MRScenario.isTestHarness))) {
			TestHarness testharnessHomepage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			MyDocumentsPage myDocumentsPage = testharnessHomepage.navigateToMyDocumentsFromTestHarnessPage();
			Assert.assertTrue("PROBLEM - Error in loading  my Documents Page",myDocumentsPage != null);
			getLoginScenario().saveBean(PageConstantsMnR.My_Documents_PAGE,myDocumentsPage);
		} else {
			int forceTimeoutInMin=5;
			System.out.println("Proceed to Plan Documents & Resources page");
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage = accountHomePage.navigateDirectToPlanDocPage(memberType,planType, forceTimeoutInMin);
			Assert.assertTrue("PROBLEM - unable to navigate to Plan Documents and Resources page", planDocumentsAndResourcesPage!=null);
			if (memberType.toUpperCase().contains("COMBO")) 
				planDocumentsAndResourcesPage.goToSpecificComboTab(planType);
			planDocumentsAndResourcesPage.sleepBySec(15);
			getLoginScenario().saveBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE,planDocumentsAndResourcesPage);

			MyDocumentsPage myDocumentsPage = planDocumentsAndResourcesPage.navigateToMyDocumentsPage();
			Assert.assertTrue("PROBLEM - Error in loading  my Documents Page",myDocumentsPage != null);
			getLoginScenario().saveBean(PageConstantsMnR.My_Documents_PAGE,myDocumentsPage);
		}
	}
	
	

	/**
	 * This step will validate few elements on My Documents Page
	 */
	@And("user validates header section content on My Documents Page$")	
	public void user_validates_header_Content() throws InterruptedException { 
		MyDocumentsPage myDocumentsPage = (MyDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.validateHeaderSection();
	}

	/**
	 * This steps enables user to select documents for a particular Time Span
	 */
	@And("^then the user searches documents for a valid Period on My documents page$")	
	public void search_by_ValidTimeperiod(DataTable memberAttributes) throws InterruptedException { 
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String timePeriod=memberAttributesMap.get("Search Range");
		MyDocumentsPage myDocumentsPage = (MyDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.searchDocumentsByTimePeriod(timePeriod);
	}

	
	
	/**
	 * This steps enables validates if Documents Table is present or not in past 24 months and also compares it to the documents expected flag if it should have the table or not
	 * If it's present then user validates the doc table else validates the error message
	 */
	@And("^then the user validates the Documents Table if present in past twenty four months time frame$")	
	public void validate_the_Documents_Table24Months(DataTable memberAttributes) throws InterruptedException { 
		int currentNumberOfRowsInDocumentsTable = 0;
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String documentsExpected=memberAttributesMap.get("Documents Expected");

		MyDocumentsPage myDocumentsPage = (MyDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		Boolean tableIsPresent=myDocumentsPage.validateDocumentsTable();
		if(tableIsPresent) {
			myDocumentsPage.validateTableHeaders();	
			currentNumberOfRowsInDocumentsTable=myDocumentsPage.validateNumberOfRowsInTable();
			myDocumentsPage.validateTableContent();
			Assert.assertTrue("Problem with Number of Documents in the Documents Table,currentNumberOfRowsInDocumentsTable="+currentNumberOfRowsInDocumentsTable+" previousNumberOfRowsInDocumentsTable="+ previousNumberOfRowsInDocumentsTable, currentNumberOfRowsInDocumentsTable>=previousNumberOfRowsInDocumentsTable);
			previousNumberOfRowsInDocumentsTable=currentNumberOfRowsInDocumentsTable; 
		}
		/**
		 * validating the expected flag versus the flag to validate if table is present
		 */
		if(documentsExpected.equalsIgnoreCase("Y")&& !tableIsPresent)
		{
		Assert.fail(">>>>>>>>>>>Document table is expected but no document table found.<<<<<<<<<<<<<<<<");
		}
		
	}

	
	
	
	
	/**
	 * This steps enables validates if Documents Table is present or not
	 * If it's present then user validates the doc table else validates the error message
	 */
	@And("^I validate the Documents Table if present$")	
	public void validate_the_Documents_Table() throws InterruptedException { 
		int currentNumberOfRowsInDocumentsTable = 0;
		MyDocumentsPage myDocumentsPage = (MyDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		Boolean tableIsPresent=myDocumentsPage.validateDocumentsTable();
		if(tableIsPresent) {
			myDocumentsPage.validateTableHeaders();	
			currentNumberOfRowsInDocumentsTable=myDocumentsPage.validateNumberOfRowsInTable();
			myDocumentsPage.validateTableContent();
			Assert.assertTrue("Problem with Number of Documents in the Documents Table. currentNumberOfRowsInDocumentsTable='"+currentNumberOfRowsInDocumentsTable+"' | previousNumberOfRowsInDocumentsTable='"+previousNumberOfRowsInDocumentsTable+"'", currentNumberOfRowsInDocumentsTable>=previousNumberOfRowsInDocumentsTable);
			previousNumberOfRowsInDocumentsTable=currentNumberOfRowsInDocumentsTable; 
		}
	}
	
	/**
	 * This steps enables validates if Documents Table is present or not
	 * If it's present then user validates the doc table else validates the error message
	 */
	@And("^I validate the Documents Table if present for Current Year$")	
	public void validate_the_Documents_Table_ForCurrentYear() throws InterruptedException { 
		MyDocumentsPage myDocumentsPage = (MyDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		Boolean tableIsPresent=myDocumentsPage.validateDocumentsTable();
		if(tableIsPresent) {
			myDocumentsPage.validateTableHeaders();	
			myDocumentsPage.validateTableContent();
		}
	}
	
	/**
	 * This steps validates the calendar elements on Custom search
	 * Also it lets user to perform a Custom search with a date Range 
	 *  From: Current Date Minus 26 months To :Current Date 
	 */
	@Then("^I can validate the calendar will show up for custom search when user clicks on From and To calendars$")	
	public void validate_the_Calendar() throws InterruptedException { 
		String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(24).toDate());
		String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		System.out.println("search range from '"+fromDate+"' to '"+toDate+"'");

		MyDocumentsPage myDocumentsPage = (MyDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.customSearchCalendar(fromDate,toDate);
	}
	
	/**
	 * While performing the Custom Search, This steps validates error message when user leaves both the From
	 * And To textfields blank
	 */
	@Then("^I should be able to see the error messages when to and from dates are not entered$")
	public void validateEmptyDatesErrorMessage(){
		MyDocumentsPage myDocumentsPage = (MyDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);

		myDocumentsPage.validateEmptyDatesError();
	}


	/**
	 * This step performs documents search using custom search option with input arguments where the 'to' date older than 'from' date.
	 * Validate expected error message
	 */
	@And("^I custom search documents for the following invalid time interval on my Documents page$")
	public void validate_invalid_custom_search_documents(DataTable memberAttributes) throws InterruptedException{ 
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String fromDate = memberAttributesMap.get("From Date");
		String toDate = memberAttributesMap.get("To Date");
		System.out.println("From Date is: "+ fromDate +" And To Date is: "+ toDate );
		MyDocumentsPage myDocumentsPage = (MyDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.customSearchByTimeInterval(fromDate,toDate);
	}
	
	/**
	 * This Step validates the Disclaimer Present on My documents Page
	 */
	@And("^I validate the disclaimer on my Documents Page$")
	public void validateDisclaimer() throws InterruptedException{ 
		MyDocumentsPage myDocumentsPage = (MyDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.validateDisclaimer();
	}

	/**
	 * This Step validates the Note Present on My documents Page
	 */
	@And("^I validate the Note  text on my Documents Page$")
	public void validateNoteText() throws InterruptedException{ 

		MyDocumentsPage myDocumentsPage = (MyDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.validateNoteText();
	}

	/**
	 * This Step validates the Need Help section Present on My documents Page
	 */
	@Then("^I validate Need Help section on my Documents Page$")
	public void validateNeedHelpSection() throws InterruptedException{ 

		MyDocumentsPage myDocumentsPage = (MyDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.validateNeedHelpSection();
	}

}





