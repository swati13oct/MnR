package acceptancetests.memberredesign.claims;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimDetailsPage;
import pages.regression.claims.ClaimSummarypage;
import pages.regression.testharness.TestHarness;

/**
 Functionality : Validating the Claims Summary & Claims Details Page on the redesigned site.
 */
public class ClaimsMemberRedesignStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@When("^Explanation of benefits sub navigation under Claims tab is not displayed$")
	public void check_ExplanationOfBenefits_SubNavigation_UnderClaimsTab() throws Throwable { //in-use
		ClaimSummarypage claimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validateExplanationOfBenefitsSubNavNotDisplayedForSSUP();
	}	

	@When("^Validate Explanation of benefits Page for group SSUP$")
	public void Validate_EOB_Tab_underClaims() throws Throwable { //in-use
		ClaimSummarypage claimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validateExplanationOfBenefitsSubNavDisplayedForGroupSSUP();
	}

	@When("^Explanation of benefits deep link is invoked and validate the Page$")
	public void check_ExplanationOfBenefits_DeepLink() throws Throwable { //in-use
		ClaimSummarypage claimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.invokeEOBDeepLink();
	}

	@And("^I can search claims for the following claim period on claims summary page$") 
	public void search_claims_period_redesigned_site(DataTable timeAttributes) throws InterruptedException{ //in-use
		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {
			urlAttributesMap .put(timeAttributesRow.get(i).getCells().get(0), timeAttributesRow.get(i).getCells().get(1));
		}
		System.out.println("claim period"+urlAttributesMap.get("Claim Period"));
		String s=urlAttributesMap.get("Claim Period");
		String planType = urlAttributesMap.get("Plan Type");

		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if(s.equals("custom-search")){
			System.out.println("custom search");
			newClaimsSummaryPage.searchClaimsbyCustomDate(planType,s);
		} else{
			newClaimsSummaryPage.searchClaimsByTimePeriod(planType,s);
		}
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	@Then("^I can see the claims displayed based on the selection on claims summary page$")
	public void validate_claims_table_redesigned_site(){ //in-use
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validateClaimsTable();
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	@And("^I validate the EOB section based on claims system on claims summary page$")
	public void validates_EOB_redesigned_site(DataTable memberAttributes){ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String claimSystem  = memberAttributesMap.get("Claim System");
		String planType = memberAttributesMap.get("Plan Type");
		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateEobfordifferentClaimsSystem(claimSystem, planType);
		if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);
	}

	@And("^I validate the DownloadMyData section on claims summary page$")
	public void validates_DownloadMyData_redesigned_site(DataTable memberAttributes){ //in-use
		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateDownloadMyDataExistsAndWorks();
		if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);
	}	

	@And("^I can see the learn more and print and download option on claims summary table section$")
	public void i_can_see_print_and_download_option_in_claims_table() throws Throwable { //in-use
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.validateLearnMoreAndPrintAndDownloadOptionExistAndWork());
	}

	@And("^I validate the pagination on the claims summary page$")
	public void i_validate_the_pagination_on_the_claims_summary_page() throws Throwable { //in-use
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - not getting expected pagination.  NOTE: pagination will only show if user has claims for the search range",claimSummarypage.verifyClaimsTableAndPagination());
	}

	@And("^I validate the Claims Total on claims details page$")
	public void validate_claims_total_AARP(DataTable memberAttributes){ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		if (planType.toLowerCase().contains("pdp")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step for claims total validation on claims detail page");
			return;
		} 
		ClaimDetailsPage newclaimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		newclaimDetailspage.validateClaimsTotalInDetailsPage();
	}

	@When("^I validate the error message for a PHIP Member on the screen$")
	public void i_validate_the_error_message_for_a_PHIP_Member_on_the_screen() throws Throwable { //in-use
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimSummarypage.ValidatePHIPErrorMessage();
	}

	@Then("^I can validate the claims summary header on claims summary page$")
	public void i_can_validate_the_claims_summary_header(DataTable memberAttributes)  { //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		String memberType = memberAttributesMap.get("Member Type");
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		if (memberType.toLowerCase().contains("combo_")) {
			System.out.println("This test is for combo plans, validate there are tabs and select the tab accordingly");
			newClaimsSummaryPage.validateComboTabs();
			newClaimsSummaryPage.goToSpecificComboTab(planType); //note: click the target tab for testing
		}
		newClaimsSummaryPage.validateClaimsSummaryHeaderSection(planType,memberType);		
		newClaimsSummaryPage.validateYouHavemessage(planType);
		newClaimsSummaryPage.validateClaimsHeaderCopyText();
		newClaimsSummaryPage.validateSystemErrorMsgNotExist();
	}

	@When("^I navigate to the Claim Details page from claims summary page$")
	public void i_navigate_to_member_redesign_claim_details(DataTable memberAttributes) throws InterruptedException { //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		if (planType.toLowerCase().contains("pdp")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step to navigate to claims detail page");
			return;
		} 
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPage();
		if (null != newClaimDetailsPage)
			getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
		else {
			Assert.fail("Claims details page is not loaded!!!");
		}
	} 

	@And("^I validate the claims summary link on claims detail top page$")
	public void I_validate_the_claims_summary_link_on_claims_detail_top_page(DataTable memberAttributes){ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		if (planType.toLowerCase().contains("pdp")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step to validate top claims summary link on claims detail page");
			return;
		} 
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		ClaimSummarypage claimSummarypage =claimDetailspage.validateClaimsSummaryLinkOnDetailTopPage(planType);
		if(claimSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimSummarypage);
	}

	@And("^I validate the claims summary link on claims detail bottom page$")
	public void I_validate_the_claims_summary_link_on_claims_detail_bottom_page(DataTable memberAttributes){ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		if (planType.toLowerCase().contains("pdp")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step to validate bottom claims summary link on claims detail page");
			return;
		} 
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		ClaimSummarypage claimSummarypage =claimDetailspage.validateClaimsSummaryLinkOnDetailBottomPage();
		if(claimSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimSummarypage);
	} 

	@Then("^I can see the claims displayed based on the selection on claims summary page for PDP plans$") 
	public void validate_claims_table_PDPmember_site(){ //in-use
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validateClaimsTablePDP();
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	} 

	@Then("^I should be able to see the search range is greater than two years error$")
	public void validateGreaterThanTwoYearsMessage(DataTable memberAttributes){ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimSummarypage.validateGreaterThanTwoYearError(planType);

		//note: assume this is the last step in the test, print out a summary of the claims for logging purpose
		if (allClaims==null) {
			System.out.println("========================================");
			System.out.println("allClaims object is null");
			System.out.println("========================================");
		} else {
			System.out.println("========================================");
			System.out.println("List the number of claims in each search range");
			System.out.println(Arrays.asList(allClaims));
			System.out.println("========================================");
		}
	}

	HashMap<String, Integer> allClaims = new HashMap<String, Integer>();
	List<String> recordInvokedBypass=new ArrayList<String>();
	@Then("^I can see the number of claims$")
	public void getClaimsNumber(DataTable memberAttributes) { //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String claimPeriod = memberAttributesMap.get("Claim Period");
		String claimType = memberAttributesMap.get("Claim Type");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		int numClaims=claimSummarypage.getNumClaims(claimPeriod, claimType);
		System.out.println("Number of Claims="+numClaims);
		allClaims.put(claimPeriod, numClaims);
		if (claimType.equalsIgnoreCase("Prescription drug")) {
			claimSummarypage.validateClaimsTableSectionText(numClaims);
		}
		claimSummarypage.validateSystemErrorMsgNotExist();
		System.out.println("------------ begin list of claims result ---------------");
		System.out.println(Arrays.asList(allClaims)); 
		System.out.println("------------ end list of claims result ---------------");
	}

	@Then("^I can validate the numbers of claims from all search periods$")
	public void compareAllClaimsPeriods(DataTable memberAttributes) {  //in-use
		//note: use this flag to determine if you want to fail the case if zero claims
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String flagZeroClaimsUserInput = memberAttributesMap.get("Flag Zero Claims User");
		boolean flagZeroClaimsUser=true;
		if (flagZeroClaimsUserInput.equalsIgnoreCase("yes")) {
			flagZeroClaimsUser=true;
		} else if (flagZeroClaimsUserInput.equalsIgnoreCase("no")) {
			flagZeroClaimsUser=false;
		} else {
			Assert.assertTrue("PROBLEM - 'Flag Zero Claims User' can only be yes or no.  Actual="+flagZeroClaimsUser, false);
		}

		//note: display any of the issues encountered that are currently bypassed
		System.out.println("================================================================");
		System.out.println("========== Data collected during test run ======================");
		System.out.println("========== known issues ==========");
		if (recordInvokedBypass.size()==0) {
			System.out.println("Did not encounter any existing known issues");
		} else {
			System.out.println("Encounted existing known issues:");
			for (String s: recordInvokedBypass) {
				System.out.println("  issue: "+s);
			}
		}

		//note: do the logic for validating whether claims number makes sense between pages
		int last30days=allClaims.get("Last 30 days");
		int last90days=allClaims.get("Last 90 days");
		int last6months=allClaims.get("Last 6 months");
		int last12months=allClaims.get("Last 12 months");
		int last24months=allClaims.get("Last 24 months");
		int customeSearch=allClaims.get("Custom search");
		System.out.println("========== claims number ==========");
		System.out.println("last30days="+last30days);
		System.out.println("last90days="+last90days);
		System.out.println("last6months="+last6months);
		System.out.println("last12months="+last12months);
		System.out.println("last24months="+last24months);
		System.out.println("customeSearch="+customeSearch);
		System.out.println("================================================================");

		Assert.assertTrue("PROBLEM - number of claims from last30days should be greater than or equals to zero.  Expected='0' | Actual='"+last30days+"'", last30days >= 0);
		Assert.assertTrue("PROBLEM - number of claims from last90days should be greater than or equals to zero.  Expected='0' | Actual='"+last90days+"'", last90days >= 0);
		Assert.assertTrue("PROBLEM - number of claims from last6months should be greater than or equals to zero.  Expected='0' | Actual='"+last6months+"'", last6months >= 0);
		Assert.assertTrue("PROBLEM - number of claims from last12months should be greater than or equals to zero.  Expected='0' | Actual='"+last12months+"'", last12months >= 0);
		Assert.assertTrue("PROBLEM - number of claims from last24months should be greater than or equals to zero.  Expected='0' | Actual='"+last24months+"'", last24months >= 0);
		Assert.assertTrue("PROBLEM - number of claims from customeSearch should be greater than or equals to zero.  Expected='0' | Actual='"+customeSearch+"'", customeSearch >= 0);

		Assert.assertTrue("PROBLEM - number of claims from last30days should be less than or equals to last90days.  last30days='"+last30days+"' | last90days='"+last90days+"'", last30days <= last90days);
		Assert.assertTrue("PROBLEM - number of claims from last90days should be less than or equals to last6months.  last90days='"+last90days+"' | last6months='"+last6months+"'", last90days <= last6months);
		Assert.assertTrue("PROBLEM - number of claims from last6months should be less than or equals to last12months.  last6months='"+last6months+"' | last12months='"+last12months+"'", last6months <= last12months);
		Assert.assertTrue("PROBLEM - number of claims from last12months should be less than or equals to last24months.  last12months='"+last12months+"' | last24months='"+last24months+"'", last12months <= last24months);
		Assert.assertTrue("PROBLEM - number of claims from customSearch should be less than or equals to last24months.  customeSearch='"+customeSearch+"' | last24months='"+last24months+"'", customeSearch <= last24months);

		if (flagZeroClaimsUser) {
			Assert.assertTrue("PROBLEM - While this user has passed all basic claims validations for each search period, but this user has 0 claims. please select another user with claims for comprehensive claims testing.  last24months='"+last24months+"'", last24months > 0);
		} else {
			if (last24months < 0) {
				System.out.println("WARNING - While this user has passed all basic claims validations for each search period, but this user has 0 claims. please select another user with claims for comprehensive claims testing.  last24months='"+last24months+"'");
			}
		}
	}

	@And("^I validate the pagination on the claims summary page for given range$")
	public void validatePagination(DataTable memberAttributes) throws Throwable { //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String claimPeriod = memberAttributesMap.get("Claim Period");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		int numClaims=allClaims.get(claimPeriod);
		System.out.println("There are "+numClaims+" number of claims for claim period opion="+claimPeriod);
		if (numClaims <=0) {
			Assert.assertTrue("PROBLEM - Pagination will only show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,!claimSummarypage.verifyClaimsTableAndPagination());
		} else {
			Assert.assertTrue("PROBLEM - Pagination should show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,claimSummarypage.verifyClaimsTableAndPagination());
		}
	}

	@And("^I can search claims for claim period and claim type on claim summary page$")
	public void search_claims_period_for_claimType_redesigned_site(DataTable memberAttributes) throws InterruptedException{ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String claimPeriod=memberAttributesMap.get("Claim Period");
		String planType = memberAttributesMap.get("Plan Type");
		String memberType = memberAttributesMap.get("Member Type");
		String claimType = memberAttributesMap.get("Claim Type");

		System.out.println("===================================================================================================");
		System.out.println("Proceed to test for claim period="+claimPeriod);
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if (memberType.toLowerCase().contains("combo_")) { //note: parse claimSystem determine which tab to click
			System.out.println("This test is for combo plans, validate there are tabs and select the tab accordingly");
			newClaimsSummaryPage.validateComboTabs();
			newClaimsSummaryPage.goToSpecificComboTab(planType); //note: click the target tab for testing
		}
		newClaimsSummaryPage.searchClaimsByTimePeriodClaimType(planType,claimPeriod, claimType);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}	

	@When("^I validate Claim Details page content in detail for value and Learn More and EOB$")
	public void validate_claim_details_extensive_validatoin(DataTable memberAttributes) throws InterruptedException { //in-use
		// note: only validate for medical case, skip for prescription drug case because that one doesn't have 'More Info'
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		String claimPeriod = memberAttributesMap.get("Claim Period");
		String claimType = memberAttributesMap.get("Claim Type");
		String claimSystem = memberAttributesMap.get("Claim System");

		boolean hasYourShare=true;
		if (planType.equalsIgnoreCase("ship") || planType.equalsIgnoreCase("pdp") ) {
			hasYourShare=false;
		}

		if (claimType.equalsIgnoreCase("prescription drug")) {
			System.out.println("Prescription drug doesn't have more info for claims, skip claims detail validation");
		} else {
			int numClaims=allClaims.get(claimPeriod);
			if (numClaims > 0) {	//note: only do this if claims > 0
				System.out.println("Proceed to Claims Summary page");
				ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
				claimSummarypage.validateSystemErrorMsgNotExist();  //note: don't bother if getting system error already

				//note: gather data on summary page for validation on detail page
				System.out.println("Determine number of data rows on table");
				int totalDataRows=claimSummarypage.getTableTotalDataRows(claimType);
				int total=(totalDataRows+2); //note: cap at max =5 to cut down test time
				if (total>5) {
					total=5;
					System.out.println("Total claims='"+totalDataRows+"', will validate the first 5 for detail to shorten test time");
				}
				//KEEP- for (int x=2; x<(totalDataRows+2); x++) {		//note: use this instead if want to validate all entries
				for (int x=2; x<total; x++) {
					System.out.println("========================================================================");
					System.out.println("Proceed to validate data row index="+x+" ===============================");

					HashMap<String, String> dataMapSummary=claimSummarypage.gatherDataFromSummaryPage(claimType, x, claimSystem, hasYourShare);
					ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPage(x);
					if (null != newClaimDetailsPage) {
						getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
						System.out.println("Proceed to validate claims table");
						ClaimDetailsPage newclaimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);

						if(newclaimDetailspage != null) {
							getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newclaimDetailspage);
							System.out.println("Proceed to validate claims total");

							System.out.println("Proceed to validate header section content on detail page");
							newclaimDetailspage.validateClaimsDetailPageHeaderSection(planType);
							newclaimDetailspage.validateClaimsTableInDetailsPage(planType);

							System.out.println("Proceed to validate 'Learn More...' link");
							newclaimDetailspage.learnMoreCostLink();

							System.out.println("Proceed to validate 'This page contains PDF documents...' text on detail page");
							boolean invokeBypass_INC11365785_conatinsPdfDocText=newclaimDetailspage.validatePageContainsPdfDocText();
							if (invokeBypass_INC11365785_conatinsPdfDocText) {
								System.out.println("Encountered issue for INC11365785_conatinsPdfDocText  on detail page");
								recordInvokedBypass.add("invokeBypass_INC11365785_conatinsPdfDocText_detailPage");
							}

							//note: detail page will have Your Share column regardless Summary page
							HashMap<String, String> dataMapDetail=newclaimDetailspage.gatherDataFromDetailPage(claimType);
							boolean invokedBypass_INC10332773_YourShareMissmatched=newclaimDetailspage.compareSummaryAndDetailData(claimType, dataMapSummary, dataMapDetail);
							if (invokedBypass_INC10332773_YourShareMissmatched) {
								System.out.println("Encountered issue for INC10332773_YourShareMissmatched_detailPage on detail page");
								recordInvokedBypass.add("invokedBypass_INC10332773_YourShareMissmatched_detailPage");
							}
							System.out.println("Proceed to validate claims total - if encounter INC10332773 then ignore the failure for now");
							newclaimDetailspage.validateClaimsTotalAccurateInDetailsPage(invokedBypass_INC10332773_YourShareMissmatched, planType);

							System.out.println("Proceed to validate 'EOB' links on detail page");
							boolean invokeBypass_INC11365785_searchEOBHistory=newclaimDetailspage.validate_SearchEobHistory_onDetailPage(claimSystem,planType);
							if (invokeBypass_INC11365785_searchEOBHistory) {
								System.out.println("Encountered issue for INC11365785_searchEOBHistory on detail page");
								recordInvokedBypass.add("invokeBypass_INC11365785_searchEOBHistory_detailPage");
							}

							System.out.println("Proceed to validate 'Need Help' section on detail page");
							newclaimDetailspage.validateNeedHelpSection(planType);

							//note: if all goes well, go back to the summary page to prep for next run
							claimSummarypage= newClaimDetailsPage.navigateBackToClaimSummaryPage(planType, claimPeriod);
							if(claimSummarypage != null) {
								getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimSummarypage);
							} else {
								Assert.fail("Can't get back to claims summary page!!!");
							}
						} 
					} else {
						Assert.fail("Claims details page is not loaded!!!");
					}
				}
			} else {
				System.out.println("There is 0 claims for claim period '"+claimPeriod+"', skip claims detail validation");
			}
		}
	}

	@When("^I validate Claim Details page content value and Learn More and EOB and tooltops$")
	public void validate_claim_details(DataTable memberAttributes) throws InterruptedException { //in-use
		//note: only validate for medical case, skip for prescription drug case because that one doesn't have 'More Info'
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		String claimSystem = memberAttributesMap.get("Claim System");

		if (planType.equalsIgnoreCase("PDP")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step validation for content, learn more, and EOB on claims detail page");
			return;
		} else {  //note: this test is assume prior test steps passed so user has claims
			System.out.println("Proceed to Claims Summary page");
			ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
			claimSummarypage.validateSystemErrorMsgNotExist(); //note: don't bother if getting system error already
			//note: use the first claim data for validation
			ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPage(2);
			if (null != newClaimDetailsPage) {
				getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
				System.out.println("Proceed to validate claims table");
				ClaimDetailsPage newclaimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);

				newclaimDetailspage.validateClaimsTableInDetailsPage(planType);
				if(newclaimDetailspage != null) {
					getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newclaimDetailspage);

					System.out.println("Proceed to validate claims header and tooltips");
					newclaimDetailspage.validateClaimsDetailPageHeaderSection(planType);

					System.out.println("Proceed to validate 'Learn More...' link");
					newclaimDetailspage.learnMoreCostLink();
					
					System.out.println("Proceed to validate 'EOB' links on detail page");
					newclaimDetailspage.validate_SearchEobHistory_onDetailPage(claimSystem,planType);
				} 
			} else {
				Assert.fail("Claims details page is not loaded!!!");
			}
		}
	}

	@And("^I can validate the learn more and print and download option and DownloadMyData section on claims summary page$")
	public void validate_print_and_download_option_in_claims_table(DataTable memberAttributes) throws Throwable { //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String claimPeriod = memberAttributesMap.get("Claim Period");
		String planType = memberAttributesMap.get("Plan Type");
		
		int numClaims=allClaims.get(claimPeriod);
		System.out.println("There are "+numClaims+" number of claims for claim period opion="+claimPeriod);
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if (numClaims <=0) {
			Assert.assertTrue("PROBLEM - Print and Download will only show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,claimSummarypage.verifyDownloadMyDataAndLearnMoreAndPrintAndDownloadOptions(numClaims, planType));
		} else {
			Assert.assertTrue("PROBLEM - Print and Download should show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,claimSummarypage.verifyDownloadMyDataAndLearnMoreAndPrintAndDownloadOptions(numClaims, planType));
		}
	}

	@And("^I custom search claims for the specific time interval on claims summary page$")
	public void custom_search_claims_redesigned_site(DataTable memberAttributes) throws InterruptedException{ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType=memberAttributesMap.get("Plan Type");
		//note: today is the 'to' date | go back 18 months will be the from day  01/02/2018
		String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(18).toDate());
		String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		System.out.println("search range from '"+fromDate+"' to '"+toDate+"'");
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.searchClaimsByTimeInterval(planType, fromDate,toDate);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	@And("^I custom search claims for the following invalid time interval on claims summary page$")
	public void invalid_custom_search_claims_redesigned_site(DataTable memberAttributes) throws InterruptedException{ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType=memberAttributesMap.get("Plan Type");
		String fromDate = memberAttributesMap.get(RedesignClaimsCommonConstants.CLAIMS_FROM_DATE);
		String toDate = memberAttributesMap.get(RedesignClaimsCommonConstants.CLAIMS_TO_DATE);

		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.searchClaimsByTimeInterval(planType, fromDate,toDate);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	@And("^I custom search claims for over two years time interval from current date on claims summary page$")
	public void greaterThanTwoYears_custom_search_claims_redesigned_site(DataTable memberAttributes) throws InterruptedException{ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType=memberAttributesMap.get("Plan Type");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar calendar = Calendar.getInstance();
		Date currentDate=calendar.getTime();
		String toDate = dateFormat.format(currentDate);
		System.out.println("current date="+toDate);
		calendar.add(Calendar.YEAR, -2);
		calendar.add(Calendar.DATE, -1);
		Date twoYearsAndOneDayBackFromCurrentDate=calendar.getTime();
		String fromDate = dateFormat.format(twoYearsAndOneDayBackFromCurrentDate);
		System.out.println("2 yrs and 1 day ago date="+fromDate);

		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.searchClaimsByTimeInterval(planType, fromDate,toDate);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	@Then("^I should be able to see the error message when no to and form dates being entered$")
	public void validateEmptyDatesErrorMessage(){ //in-use
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimSummarypage.validateEmptyDatesError();
	}

	@Then("^I should be able to see the from date is greater than the to date error message being displayed$")
	public void validateToDateInvalidErrorMessage(DataTable memberAttributes){ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType=memberAttributesMap.get("Plan Type");		
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimSummarypage.validatefromDateLaterThanToDateError(planType);
	}

	@Then("^I can validate claims table displayed based on the selection on claims summary page$")
	public void validate_claims_table_display(DataTable memberAttributes){ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType=memberAttributesMap.get("Plan Type");		
		String claimPeriod=memberAttributesMap.get("Claim Period");		
		String claimType=memberAttributesMap.get("Claim Type");		
		String claimSystem=memberAttributesMap.get("Claim System");		

		boolean hasYourShare=true;
		if (planType.equalsIgnoreCase("ship") || planType.equalsIgnoreCase("pdp")) {
			hasYourShare=false;
		}
		int numClaims=allClaims.get(claimPeriod);
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validateClaimsTable(planType, numClaims, claimType, claimSystem, hasYourShare);

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	@And("^I can validate the EOB section based on claims system on claims summary page$")
	public void validate_EOB_redesigned_site(DataTable memberAttributes){ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		String claimSystem = memberAttributesMap.get("Claim System");

		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		boolean invokeBypass_INC11365785_searchEOBHistory=newclaimsSummarypage.validate_SearchEobHistory_onSummaryPage(claimSystem, planType);
		if (invokeBypass_INC11365785_searchEOBHistory) {
			System.out.println("Encountered issue for INC11365785_searchEOBHistory on summary page");
			recordInvokedBypass.add("invokeBypass_INC11365785_searchEOBHistory_summaryPage");
		}

		System.out.println("Proceed to validate 'This page contains PDF documents...' text on summary page");
		boolean invokeBypass_INC11365785_conatinsPdfDocText=newclaimsSummarypage.validatePageContainsPdfDocText();
		if (invokeBypass_INC11365785_conatinsPdfDocText) {
			System.out.println("Encountered issue for INC11365785_conatinsPdfDocText on summary page");
			recordInvokedBypass.add("invokeBypass_INC11365785_conatinsPdfDocText_summaryPage");
		}
		if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);
	}

	@When("^I navigate to the claims Summary page from dashboard or testharness page$") 
	public void navigate_Claims_Summary_page() { //in-use
		ClaimSummarypage newClaimsSummaryPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			newClaimsSummaryPage = testHarness.navigateToClaimsSummaryFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			newClaimsSummaryPage = accountHomePage.navigateToClaimsSummaryPage();
		}
		if (newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	@When("^I validate the Need Help section content on claims summary page$")	
	public void validateNeedHelpSectionOnClaimsSummaryPage(DataTable memberAttributes){ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateNeedHelpSection(planType);
	}

	@Then("^I can validate the view as pdf link on claims details page header$")	
	public void i_can_validate_the_eob_link(DataTable memberAttributes){ //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		String claimSystem = memberAttributesMap.get("Claim System");
		ClaimDetailsPage claimsdetailspage = (ClaimDetailsPage )getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimsdetailspage.validateMedicalEOBfordifferentClaimssystem(claimSystem,planType);

		System.out.println("claims-============"+claimsdetailspage);
	}

	@When("^I navigate to the Claim details page to see eob link on details page$")	
	public void i_navigate_to_the_eobclaims_detailspage(){ //in-use
		ClaimDetailsPage newClaimDetailsPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
			newClaimDetailsPage=claimSummarypage.navigateToClaimDetailsPagetoseeeobpdflink();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			newClaimDetailsPage = accountHomePage.navigateToClaimDetailsPagetoseeeobpdflink();
		}
		System.out.println("claims details page -============"+newClaimDetailsPage);
		if(newClaimDetailsPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
	}

	@And("^if I access via dashboard I can navigate to claims summary page from View Your Claims$")
	public void fromDashboardNavigateToClaimsSummaryViaViewYourClaims() {
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			System.out.println("Running from testharness, this test step not applicable, skipping...");
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			accountHomePage.navigateToClaimsPageByViewYorClaimsLinkThenBackToHome();
		}
	}
		
	//vvv note:	added for VBF	
	@Then("^I validate the claims displayed based on the selection on claims summary page$") 
	public void vbf_validate_claims_table_redesigned_site() { //in-use
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.vbf_validateClaimsTable();
	}	

	public static String vbf_claimType;
	@And("^I can navigate to the Claim Details page from claims summary page$")
	public void vbf_i_navigate_to_member_redesign_claim_details_page(DataTable memberAttributes) throws InterruptedException { //in-use
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String claimSystem = memberAttributesMap.get("Claim System");
		if (claimSystem.equalsIgnoreCase("COSMOSCLAIMS") || claimSystem.equalsIgnoreCase("NICECLAIMS")
				|| claimSystem.equalsIgnoreCase("SHIPCLAIMS")) {
			if (claimSystem.equalsIgnoreCase("SHIPCLAIMS")) {
				vbf_claimType = "SHIP";
			} else {
				vbf_claimType = "Medical";
			}
			ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
			ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPage();
			if (null != newClaimDetailsPage)
				getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
			else {
				Assert.fail("Claims details page is not loaded!!!");
			}
		} else if (claimSystem.equalsIgnoreCase("RxCLAIMS")) {
			vbf_claimType = "Drug";
			System.out.println("Skipping Claim Details navigation!!!");
		} else {
			Assert.fail("Please check Claim syatems!!!");
		}
	}

	@Then("^I can validate the Claims Table on claims details page$")
	public void vbf_validate_claimsTable_claimsDetails_AARP() { //in-use
		if (vbf_claimType.equalsIgnoreCase("Medical")) {
			ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
			claimDetailspage.vbf_validateClaimsTableInDetailsPage();
		} else if (vbf_claimType.equalsIgnoreCase("Drug")) {
			System.out.println("Skipping Claim Details validation!!!");
		} else if (vbf_claimType.equalsIgnoreCase("SHIP")) {
			ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
			claimDetailspage.vbf_validateClaimsTableInDetailsPage();
		}
	}

	@And("^I can validate the Claims Total on claims details page$")
	public void vbf_validate_claims_total_AARP() { //in-use
		if (vbf_claimType.equalsIgnoreCase("Medical")) {
			ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
			claimDetailspage.vbf_validateClaimsTotalInDetailsPage();
		} else if (vbf_claimType.equalsIgnoreCase("SHIP")) {
			ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
			claimDetailspage.vbf_validateShipClaimsTotalInDetailsPage();
		} else if (vbf_claimType.equalsIgnoreCase("Drug")) {
			System.out.println("Skipping Claim Details validation!!!");
		}
	}
	//^^^ note:	added for VBF	
	
}
