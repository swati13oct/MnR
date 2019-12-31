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
import acceptancetests.memberredesign.claims.ClaimsCommonConstants;
import acceptancetests.memberredesign.claims.ClaimsSearchNavigateStepDefinition;
import acceptancetests.memberredesign.ordermaterials.OrderPlanMaterialsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimDetailsPage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import pages.regression.myDocumentsPage.myDocumentsPage;
import pages.regression.ordermaterials.OrderMaterialsPage;
import pages.regression.testharness.TestHarness;

/**
 * Step definitions for my Documents Page on the member site.
 */
public class myDocumentsStepDefinition {

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

	/**
	 * This step will let the user navigate to My Documents Page from Forms and Resources page
	 */

	@When("^the user navigates to my Documents Page$")
	public void user_navigates_to_MyDocuments_page() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		myDocumentsPage myDocumentsPage = formsAndResourcesPage.navigateToMyDocumentsPage();
		Assert.assertTrue("PROBLEM - Error in loading  my Documents Page",myDocumentsPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.My_Documents_PAGE,myDocumentsPage);
	}

	/**
	 * This step will validate few elements on My Documents Page
	 */


	@And("user validates header section content on My Documents Page$")	
	public void user_validates_header_Content() throws InterruptedException { 
		myDocumentsPage myDocumentsPage = (myDocumentsPage) getLoginScenario()
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
		myDocumentsPage myDocumentsPage = (myDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.searchDocumentsByTimePeriod(timePeriod);

	}

	/**
	 * This steps enables validates if Documents Table is present or not
	 */
	@And("^I validate the Documents Table if present$")	
	public void validate_the_Documents_Table() throws InterruptedException { 
		int currentNumberOfRowsInDocumentsTable = 0;
		myDocumentsPage myDocumentsPage = (myDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		Boolean tableIsPresent=myDocumentsPage.validateDocumentsTable();
		if(tableIsPresent)
		{
			myDocumentsPage.validateTableHeaders();	
			currentNumberOfRowsInDocumentsTable=myDocumentsPage.validateNumberOfRowsInTable();
			Assert.assertTrue("Problem with Number of Documents in the Documents Table", currentNumberOfRowsInDocumentsTable>=previousNumberOfRowsInDocumentsTable);
			previousNumberOfRowsInDocumentsTable=currentNumberOfRowsInDocumentsTable; 
		}

	}
	
	/**
	 * This steps validates the calendar elements on Custom search
	 * Also it lets user to perform a Custom search with a date Range 
	 *  From: Current Date Minus 26 months To :Current Date 
	 */
	@Then("^I can validate the calendar will show up for custom search when user clicks on From and To calendars$")	
	public void validate_the_Calendar() throws InterruptedException { 
		String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(26).toDate());
		String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		System.out.println("search range from '"+fromDate+"' to '"+toDate+"'");

		myDocumentsPage myDocumentsPage = (myDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.customSearchCalendar(fromDate,toDate);
	}
	
	/**
	 * While performing the Custom Search, This steps validates error message when user leaves both the From
	 * And To textfields blank
	 */
	@Then("^I should be able to see the error messages when to and from dates are not entered$")
	public void validateEmptyDatesErrorMessage(){
		myDocumentsPage myDocumentsPage = (myDocumentsPage) getLoginScenario()
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
		System.out.println("From Date is: "+ fromDate +"And To Date is: "+ toDate );
		myDocumentsPage myDocumentsPage = (myDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.customSearchByTimeInterval(fromDate,toDate);
	}
	
	/**
	 * This Step validates the Disclaimer Present on My documents Page
	 */

	@And("^I validate the disclaimer on my Documents Page$")
	public void validateDisclaimer() throws InterruptedException{ 

		myDocumentsPage myDocumentsPage = (myDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.validateDisclaimer();

	}

	/**
	 * This Step validates the Note Present on My documents Page
	 */
	@And("^I validate the Note  text on my Documents Page$")
	public void validateNoteText() throws InterruptedException{ 

		myDocumentsPage myDocumentsPage = (myDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.validateNoteText();

	}

	/**
	 * This Step validates the Need Help section Present on My documents Page
	 */

	@Then("^I validate Need Help section on my Documents Page$")
	public void validateNeedHelpSection() throws InterruptedException{ 

		myDocumentsPage myDocumentsPage = (myDocumentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.My_Documents_PAGE);
		myDocumentsPage.validateNeedHelpSection();

	}

}





