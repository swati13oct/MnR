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
import cucumber.api.Scenario;
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
 Functionality : Validating the Claims Summary & Claims Details Page on the member site.
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

	/**
	 * This step performs validation for user where the claims tab should not display
	 * Assumption: input user is SSUP individual
	 * @throws Throwable
	 */
	@When("^Explanation of benefits sub navigation under Claims tab is not displayed$")
	public void check_ExplanationOfBenefits_SubNavigation_UnderClaimsTab() throws Throwable {
		ClaimSummarypage claimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validateExplanationOfBenefitsSubNavNotDisplayedForSSUP();
	}	

	/**
	 * This step performs validation for the EOB deep link from claims summary page.
	 * Assumption: input user is SSUP group
	 * @throws Throwable
	 */
	@When("^Validate Explanation of benefits Page for group SSUP$")
	public void Validate_EOB_Tab_underClaims() throws Throwable {
		ClaimSummarypage claimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validateExplanationOfBenefitsSubNavDisplayedForGroupSSUP();
	}

	/**
	 * This step performs validation for the EOB deep link from claims summary page.
	 * Assumption: input user is SSUP individual
	 * @throws Throwable
	 */
	@When("^Explanation of benefits deep link is invoked and validate the Page$")
	public void check_ExplanationOfBenefits_DeepLink() throws Throwable {
		ClaimSummarypage claimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.invokeEOBDeepLink();
	}

	/**
	 * This step performs search using input search period (non-custom-search). 
	 * @param timeAttributesf
	 * @throws InterruptedException
	 */
	@And("^I can search claims for the following claim period on claims summary page$") 
	public void search_claims_period_redesigned_site(DataTable memberAttributes) throws InterruptedException{
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String claimPeriod=memberAttributesMap.get("Claim Period");
		String memberType=memberAttributesMap.get("Member Type");
		String planType = memberAttributesMap.get("Plan Type");
		String claimSystem = memberAttributesMap.get("Claim System");

		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE, planType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE, memberType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD, claimPeriod);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM, claimSystem);

		System.out.println("claim period = "+claimPeriod);

		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if(claimPeriod.equals("custom-search")){
			System.out.println("custom search");
			newClaimsSummaryPage.searchClaimsbyCustomDate(planType,claimPeriod);
		} else{
			newClaimsSummaryPage.searchClaimsByTimePeriod(planType,claimPeriod,claimSystem);
		}
		//note: store test note to be displayed at later time
		String resultNumOfClaims=newClaimsSummaryPage.validateYouHavemessage(planType);

		List<String> noteList=new ArrayList<String>();
		noteList.add("\n\n================================================================");
		noteList.add("===== TEST NOTE ================================================");
		noteList.add("Plan Type        = "+planType);
		noteList.add("Member Type      = "+memberType);
		noteList.add("Claim System     = "+claimSystem);
		noteList.add("Claim Period     = "+claimPeriod);
		noteList.add("Number of Claims = "+resultNumOfClaims);
		noteList.add("================================================================");
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_RESULT_NOTE, noteList);

		@SuppressWarnings("unchecked")		
		List<String> testNote=(List<String>) getLoginScenario().getBean(ClaimsCommonConstants.TEST_RESULT_NOTE);
		System.out.println("\n\nPrint result note");
		for (String s: testNote) {
			System.out.println(s);
		}

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	/**
	 * This step validates claims table being displayed for user.
	 * Assumption: user has claims.
	 */
	@Then("^I can see the claims displayed based on the selection on claims summary page$")
	public void validate_claims_table_redesigned_site(){
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		boolean flagZeroClaimUser=true;
		newClaimsSummaryPage.validateClaimsTableExists(flagZeroClaimUser);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	/** 
	 * This step validates the 'Search EOB History' link(s) on claims summary page.
	 * @param memberAttributes
	 */
	@And("^I validate the EOB section based on claims system on claims summary page$")
	public void validates_EOB_redesigned_site(){
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);

		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateEobfordifferentClaimsSystem(claimSystem, planType);
		if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);
	}

	/**
	 * This step validates 'DownloadMyData' section on claims summary page.
	 * @param memberAttributes
	 */
	@And("^I validate the DownloadMyData section on claims summary page$")
	public void validates_DownloadMyData_redesigned_site(){
		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateDownloadMyDataExistsAndWorks();
		if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);
	}	

	/**
	 * This step validates the following items on claims summary page.
	 * - 'Learn more...' link
	 * - 'print' button
	 * - 'download' button
	 * Assumption: use has claims
	 * @throws Throwable
	 */
	@And("^I can see the learn more and print and download option on claims summary table section$")
	public void i_can_see_print_and_download_option_in_claims_table() throws Throwable {
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.validateLearnMoreAndPrintAndDownloadOptionExistAndWork());
	}

	/**
	 * This step (used by E2E) validates pagination on the claims summary page.
	 * Assumption: user has claims
	 * @throws Throwable
	 */
	@And("^I validate the pagination on the claims summary page$")
	public void i_validate_the_pagination_on_the_claims_summary_page() throws Throwable {
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - not getting expected pagination.  NOTE: pagination will only show if user has claims for the search range",claimSummarypage.verifyClaimsTableAndPagination());
	}

	/**
	 * This step (used by E2E) validates the claims total section on the claims detail page.
	 * Assumption: user has claims
	 * @param memberAttributes
	 */
	@And("^I validate the Claims Total on claims details page$")
	public void validate_claims_total_AARP(){
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);

		if (planType.toLowerCase().contains("pdp") || claimSystem.toUpperCase().contains("D_")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step for claims total validation on claims detail page");
			return;
		} 
		ClaimDetailsPage newclaimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		newclaimDetailspage.validateClaimsTotalInDetailsPage();
	}

	/**
	 * This step validates the error message will display when user is PHIP member.
	 * Assumption:  input test user is a PHIP member
	 * @throws Throwable
	 */
	@When("^I validate the error message for a PHIP Member on the screen$")
	public void i_validate_the_error_message_for_a_PHIP_Member_on_the_screen() throws Throwable {
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimSummarypage.ValidatePHIPErrorMessage();
	}

	/**
	 * This step validates header section content on the claims summary page.
	 * If user has combo plan, navigates to the plan based on input plan type then performs validation.
	 * @param memberAttributes
	 */
	@Then("^I can validate the claims summary header on claims summary page$")
	public void i_can_validate_the_claims_summary_header(DataTable memberAttributes)  {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		String memberType = memberAttributesMap.get("Member Type");
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		if (memberType.toLowerCase().contains("combo")) {
			System.out.println("This test is for combo plans, validate there are tabs and select the tab accordingly");
			newClaimsSummaryPage.validateComboTabs();
			newClaimsSummaryPage.goToSpecificComboTab(planType); //note: click the target tab for testing
		}
		newClaimsSummaryPage.validateClaimsSummaryHeaderSection(planType,memberType);	

		newClaimsSummaryPage.validateClaimsHeaderCopyText();
		newClaimsSummaryPage.validateSystemErrorMsgNotExist();
	}

	/**
	 * This step (used by E2E2) will navigate from claims summary page to claims detail page using the first row of claims on claims summary page.
	 * Assumption:  user will have claims
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@When("^I navigate to the Claim Details page from claims summary page$")
	public void i_navigate_to_member_redesign_claim_details() throws InterruptedException {
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);

		if (planType.toLowerCase().contains("pdp") || claimSystem.toUpperCase().contains("D_")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step to navigate to claims detail page");
			return;
		} 
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPage();
		Assert.assertTrue("PROBLEM - unable to go to Claims details page!!!",null != newClaimDetailsPage);
		getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
	} 

	/**
	 * This step validates the 'Claims Summary' link on the top of the claims detail page.
	 * @param memberAttributes
	 */
	@And("^I validate the claims summary link on claims detail top page$")
	public void I_validate_the_claims_summary_link_on_claims_detail_top_page(){
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);

		if (planType.toLowerCase().contains("pdp") || claimSystem.toUpperCase().contains("D_")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step to validate top claims summary link on claims detail page");
			return;
		} 
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		ClaimSummarypage claimSummarypage =claimDetailspage.validateClaimsSummaryLinkOnDetailTopPage(planType);
		if(claimSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimSummarypage);
	}

	/**
	 * This step validates the 'Claims Summary' link on the bottom of the claims detail page.
	 * @param memberAttributes
	 */
	@And("^I validate the claims summary link on claims detail bottom page$")
	public void I_validate_the_claims_summary_link_on_claims_detail_bottom_page(){
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		if (planType.toLowerCase().contains("pdp") || claimSystem.toUpperCase().contains("D_")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step to validate bottom claims summary link on claims detail page");
			return;
		} 
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		ClaimSummarypage claimSummarypage =claimDetailspage.validateClaimsSummaryLinkOnDetailBottomPage();
		if(claimSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimSummarypage);
	} 

	/**
	 * This step validates the custom search expected error message when search range exceed 24 months. 
	 * @param memberAttributes
	 */
	@Then("^I should be able to see the search range is greater than two years error$")
	public void validateGreaterThanTwoYearsMessage(){
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
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

	/**
	 * Helper method to retrieve the number of claims for a search period to perform further validation
	 */
	HashMap<String, Integer> allClaims = new HashMap<String, Integer>();
	List<String> recordInvokedBypass=new ArrayList<String>();
	@Then("^I can see the number of claims$")
	public void getClaimsNumber() {
		String claimPeriod = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String claimType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE);
		String memberType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		int numClaims=claimSummarypage.getNumClaims(claimPeriod, claimType);
		System.out.println("Number of Claims="+numClaims);
		allClaims.put(claimPeriod, numClaims);
		if (claimType.equalsIgnoreCase("Prescription drug") && memberType.toUpperCase().contains("SSO")) {
			claimSummarypage.validateClaimsTableSectionOptumRxText(numClaims);
		}
		claimSummarypage.validateSystemErrorMsgNotExist();
		claimSummarypage.printListOfClaimsResult(allClaims);
	}

	/** 
	 * This step (used by the long case) will validate the number of claims between each search period.
	 * logic:  
	 *   0 <= number of claims for 'Last 30 days' <= 'Last 90 days <= 'Last 6 months' <= 'Last 12 months' <= 'Last 24 months'
	 *   0 <= valid custom search result <= number of claims for 'Last 24 months'
	 *   Input argument 'Flag Zero Claims User' will control whether the step will fail or not if user has no claims at all.
	 * @param memberAttributes
	 */
	@Then("^I can validate the numbers of claims from all search periods$")
	public void compareAllClaimsPeriods(DataTable memberAttributes) { 
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		List<String> searchOptions=new ArrayList<String>();
		searchOptions.add("Last 30 days");
		searchOptions.add("Last 90 days");
		searchOptions.add("Last 6 months");
		searchOptions.add("Last 12 months");
		searchOptions.add("Last 24 months");
		searchOptions.add("Custom search");

		//note: use this flag to determine if you want to fail the case if zero claims
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String flagZeroClaimsUserInput = memberAttributesMap.get("Flag Zero Claims User");
		Assert.assertTrue("PROBLEM - 'Flag Zero Claims User' can only be yes or no.  Actual="+flagZeroClaimsUserInput, 
				flagZeroClaimsUserInput.equalsIgnoreCase("yes") || flagZeroClaimsUserInput.equalsIgnoreCase("no"));

		String claimType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE);

		boolean flagZeroClaimsUser=true;
		if (flagZeroClaimsUserInput.equalsIgnoreCase("yes")) {
			flagZeroClaimsUser=true;
		} else if (flagZeroClaimsUserInput.equalsIgnoreCase("no")) {
			flagZeroClaimsUser=false;
		} 

		//note: do the logic for validating whether claims number makes sense between pages
		claimSummarypage.validateNumOfClaimsForEachPeriod(allClaims, flagZeroClaimsUser); 
		claimSummarypage.validateDataRowsSequenceAndDataExistsInOtherSearchPeriods(searchOptions, allClaimsData, claimType);


		//note: store the test note to display later if needed
		List<String> noteList=new ArrayList<String>();
		//note: display any of the issues encountered that are currently bypassed
		noteList.add("\n\n================================================================");
		noteList.add("===== TEST NOTE ================================================");
		noteList.add("Plan Type    = "+(String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE));
		noteList.add("Member Type  = "+(String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE));
		noteList.add("Claim System = "+(String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM));
		noteList.add("Claim Type   = "+(String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE));
		noteList.add("========== Data collected during test run ======================");
		noteList.add("========== known issues ==========");
		if (recordInvokedBypass.size()==0) {
			noteList.add("Did not encounter any existing known issues");
		} else {
			noteList.add("Encounted existing known issues:");
			for (String s: recordInvokedBypass) {
				noteList.add("  issue: "+s);
			}
		}
		noteList.add("------------ begin list of claims result ---------------");
		noteList.add("Number of claims for 'Last 30 days'       = "+String.valueOf(allClaims.get("Last 30 days")));
		noteList.add("Number of claims for 'Last 90 days'       = "+String.valueOf(allClaims.get("Last 90 days")));
		noteList.add("Number of claims for 'Last 6 months'      = "+String.valueOf(allClaims.get("Last 6 months")));
		noteList.add("Number of claims for 'Last 12 months'     = "+String.valueOf(allClaims.get("Last 12 months")));
		noteList.add("Number of claims for 'Last 24 months'     = "+String.valueOf(allClaims.get("Last 24 months")));
		noteList.add("Number of claims for 'Last Custom search' = "+String.valueOf(allClaims.get("Custom search")));
		noteList.add("------------ end list of claims result ---------------");
		noteList.add("================================================================");

		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_RESULT_NOTE, noteList);

		@SuppressWarnings("unchecked")
		List<String> result_testNote=(List<String>) getLoginScenario().getBean(ClaimsCommonConstants.TEST_RESULT_NOTE);

		System.out.println("\n\nPrint out result note:");
		for (String s: result_testNote) {
			System.out.println(s);
		}
	}

	/**
	 * This step validates pagination.  Pagination should show when there is claims.
	 * @throws Throwable
	 */
	@And("^I validate the pagination on the claims summary page for given range$")
	public void validatePagination() throws Throwable {
		String claimPeriod = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		int numClaims=allClaims.get(claimPeriod);
		System.out.println("There are "+numClaims+" number of claims for claim period opion="+claimPeriod);
		if (numClaims <=0) {
			Assert.assertTrue("PROBLEM - Pagination will only show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,!claimSummarypage.verifyClaimsTableAndPagination());
		} else {
			Assert.assertTrue("PROBLEM - Pagination should show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,claimSummarypage.verifyClaimsTableAndPagination());
		}
	}

	/**
	 * This step will search claims based on the claims period input argument.
	 * If user has combo plan, it will go to the target plan tab, based on plan type being tested, first before doing the search.
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@And("^I can search claims for claim period and claim type on claim summary page$")
	public void search_claims_period_for_claimType_redesigned_site(DataTable memberAttributes) throws InterruptedException{
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String claimPeriod=memberAttributesMap.get("Claim Period");
		String planType = memberAttributesMap.get("Plan Type");
		String memberType = memberAttributesMap.get("Member Type");
		String claimType = memberAttributesMap.get("Claim Type");
		String claimSystem = memberAttributesMap.get("Claim System");

		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE, planType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE, memberType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE, claimType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD, claimPeriod);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM, claimSystem);

		System.out.println("===================================================================================================");
		System.out.println("Proceed to test for claim period="+claimPeriod);
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if (memberType.toLowerCase().contains("combo")) { //note: parse claimSystem determine which tab to click
			System.out.println("This test is for combo plans, validate there are tabs and select the tab accordingly");
			newClaimsSummaryPage.validateComboTabs();
			newClaimsSummaryPage.goToSpecificComboTab(planType); //note: click the target tab for testing
		}
		newClaimsSummaryPage.searchClaimsByTimePeriodClaimType(planType,claimPeriod, claimType);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);

	}	

	/**
	 * This step will do comprehensive validation (used by the long case) for the following:
	 * It takes the values rows claims from claims summary page and validate them against the info display on detail page
	 * It has potential to loop through all rows that are displaying at the time on claims summary page, current setup will validate the first 5 rows only to speed up test time
	 * It will validate the following on detail page
	 * - header section content
	 * - 'Learn More...' link
	 * - 'This page contains PDF documents...' text
	 * - 'Search EOB History' links
	 * - claims total row content (will add up the values between each row and validate the sum matches the total value)
	 * - 'Need Help' section
	 * Current bypass known issue:  INC11365785, INC10332773
	 * At the end of this step, it will go back to claims summary page to get ready for next step
	 * @throws InterruptedException
	 */
	HashMap<String,List<HashMap<String,String>>> allClaimsData=new LinkedHashMap<String, List<HashMap<String,String>>>();
	@Then("^I perform extensive validation for values between claims summary and claim details page$")
	public void validate_claim_details_extensive() throws InterruptedException {
		// note: only validate for medical case, skip for prescription drug case because that one doesn't have 'More Info'
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimPeriod = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String claimType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE);
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);

		boolean hasYourShare=true;
		if (planType.equalsIgnoreCase("ship") || planType.equalsIgnoreCase("pdp") ) {
			hasYourShare=false;
		}

		int numClaims=allClaims.get(claimPeriod);
		List<HashMap<String,String>> claimsDataForSearchPeriod=new ArrayList<HashMap<String,String>>();
		if (numClaims > 0) {	//note: only do this if claims > 0
			System.out.println("Proceed to Claims Summary page");
			ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
			claimSummarypage.validateSystemErrorMsgNotExist();  //note: don't bother if getting system error already

			//note: this can be updated handle more than 1 page of claims, for now just handle 1st page of claims if there are more than 1 page
			//note: gather data on summary page for validation on detail page
			System.out.println("Determine number of data rows on table");
			int totalDataRows=claimSummarypage.getTableTotalDataRows(claimType);
			int total=(totalDataRows+2); //note: cap at max =5 to cut down test time
			if (total>5) {
				total=5;
				System.out.println("Total claims='"+totalDataRows+"', will validate the first 3 rows for detail to shorten test time");
			}
			//KEEP- for (int x=2; x<(totalDataRows+2); x++) {		//note: use this instead if want to validate all entries
			for (int x=2; x<total; x++) { //note: look at row index 2, 3, 4
				System.out.println("========================================================================");
				System.out.println("Proceed to validate data row index="+x+" ===============================");

				HashMap<String, String> dataMapSummary=claimSummarypage.gatherDataFromSummaryPage(claimType, x, claimSystem, hasYourShare);
				claimsDataForSearchPeriod.add(dataMapSummary); //note: save the info for later overall validation

				if (claimType.equalsIgnoreCase("prescription drug")) {
					System.out.println("Prescription drug doesn't have more info for claims, skip claims detail validation");
				} else {
					ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPageForGivenClaimRow(x);
					Assert.assertTrue("PROBLEM - unable to load claims detail page from a given claims row on claims summary page. table row index='"+x+"'", newClaimDetailsPage!=null);
					System.out.println("Proceed to validate claims table");
					getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
					//note: collect the values on the detail page then perform comparison between data collected from summary page
					HashMap<String, String> dataMapDetail=newClaimDetailsPage.gatherDataFromDetailPage(claimType);
					boolean invokedBypass_INC10332773_YourShareMissmatched=newClaimDetailsPage.compareSummaryAndDetailData(claimType, dataMapSummary, dataMapDetail);
					if (invokedBypass_INC10332773_YourShareMissmatched) {  //note: keep track of the known issues encountered
						System.out.println("Encountered issue for INC10332773_YourShareMissmatched_detailPage on detail page");
						recordInvokedBypass.add("invokedBypass_INC10332773_YourShareMissmatched_detailPage");
					}
					System.out.println("Proceed to validate claims total - if encounter INC10332773 then ignore the failure for now");
					newClaimDetailsPage.validateClaimsTotalAccurateInDetailsPage(invokedBypass_INC10332773_YourShareMissmatched, planType);

					//note: if all goes well, go back to the summary page to prep for next run
					claimSummarypage= newClaimDetailsPage.navigateBackToClaimSummaryPage(planType, claimPeriod);
					Assert.assertTrue("PROBLEM - unable to get back to claims summary page to prep for next test step", claimSummarypage!=null);
				}
			} //note: end for loop that loops the number of claims rows on summary page
		} else {
			System.out.println("There is 0 claims for claim period '"+claimPeriod+"', skip claims detail validation");
		}
		allClaimsData.put(claimPeriod, claimsDataForSearchPeriod); //note: save the info for later overall validation
	}

	/**
	 * This step will do validation for the claims detail page content (will not fail for user with no claims):
	 * It will validate the following on detail page
	 * - header section content
	 * - 'Learn More...' link
	 * - 'This page contains PDF documents...' text
	 * - 'Search EOB History' links
	 * - claims total row content
	 * - 'Need Help' section
	 * @throws InterruptedException
	 */
	@When("^I validate Claim Details page content value and Learn More and EOB and tooltops$")
	public void validate_claim_details_regardless_claims_value() throws InterruptedException {
		//note: only validate for medical case, skip for prescription drug case because that one doesn't have 'More Info'
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimPeriod = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		String memberType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);

		String claimType="Medical";
		if (claimSystem.toUpperCase().contains("D_")) {
			claimType="Prescription drug";
		} 

		boolean flagZeroUserNow=false; //note: don't want to fail the test in this step if user has no claims
		validate_claims_detail_page_content(planType, memberType, claimPeriod, claimType, claimSystem, flagZeroUserNow);
	}

	/**
	 * This step will do validation for the claims detail page content with expectation that user has claims:
	 * It will validate the following on detail page
	 * - header section content
	 * - 'Learn More...' link
	 * - 'This page contains PDF documents...' text
	 * - 'Search EOB History' links
	 * - claims total row content
	 * - 'Need Help' section
	 * @throws InterruptedException
	 */
	@When("^I validate Claim Details page content with non zero claims value and Learn More and EOB and tooltops$")
	public void validate_claim_details_expect_non_zero_claims() throws InterruptedException {
		//note: only validate for medical case, skip for prescription drug case because that one doesn't have 'More Info'
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimPeriod = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		String memberType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);

		String claimType="Medical";
		if (claimSystem.toUpperCase().contains("D_")) {
			claimType="Prescription drug";
		} 

		boolean flagZeroUserNow=true; //note: want to fail the test in this step if user has zero user
		validate_claims_detail_page_content(planType, memberType, claimPeriod, claimType, claimSystem, flagZeroUserNow);
	}

	/**
	 * Helper method - use the flagZeroUserNow to determine whether to fail the step if user has no claims, therefore, no claim table
	 * @param planType
	 * @param memberType
	 * @param claimPeriod
	 * @param claimType
	 * @param claimSystem
	 * @param flagZeroUserNow
	 * @throws InterruptedException
	 */
	public void validate_claims_detail_page_content(String planType, String memberType, String claimPeriod, String claimType, String claimSystem, boolean flagZeroUserNow) throws InterruptedException {
		if (planType.equalsIgnoreCase("PDP") || claimSystem.toUpperCase().contains("D_")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step validation for content, learn more, and EOB on claims detail page");
			return;
		} else {  //note: this test is assume prior test steps passed so user has claims
			System.out.println("Proceed to Claims Summary page");
			ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
			if (memberType.toLowerCase().contains("combo")) { //note: parse claimSystem determine which tab to click
				System.out.println("This test is for combo plans, validate there are tabs and select the tab accordingly");
				claimSummarypage.goToSpecificComboTab(planType); //note: click the target tab for testing
			}
			claimSummarypage.searchClaimsByTimePeriodClaimType(planType,claimPeriod, claimType);
			if (!claimSummarypage.validateClaimsTableExists(flagZeroUserNow)) {
				System.out.println("Claim Period '"+claimPeriod+"' has no claims, skipping claims detail validation step...");
				return;
			}
			claimSummarypage.validateSystemErrorMsgNotExist(); //note: don't bother if getting system error already

			//note: use the first claim data for validation
			ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPageForGivenClaimRow(2);
			Assert.assertTrue("PROBLEM - unable to go to claims details page is not loaded!!!!!!",newClaimDetailsPage != null);
			getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
			System.out.println("Proceed to validate claims table");
			newClaimDetailsPage.validateClaimsTableInDetailsPage(planType);

			System.out.println("Proceed to validate basic content for claims detail page only for the first summary row visit");

			System.out.println("Proceed to validate header section content on detail page");
			newClaimDetailsPage.validateClaimsDetailPageHeaderSection(planType);
			newClaimDetailsPage.validateClaimsTableInDetailsPage(planType);

			System.out.println("Proceed to validate 'Learn More...' link");
			newClaimDetailsPage.learnMoreCostLink();

			System.out.println("Proceed to validate 'This page contains PDF documents...' text on detail page");
			boolean invokeBypass_INC11365785_conatinsPdfDocText=newClaimDetailsPage.validatePageContainsPdfDocText();
			if (invokeBypass_INC11365785_conatinsPdfDocText) {
				System.out.println("Encountered issue for INC11365785_conatinsPdfDocText  on detail page");
				recordInvokedBypass.add("invokeBypass_INC11365785_conatinsPdfDocText_detailPage");
			}

			System.out.println("Proceed to validate 'EOB' links on detail page");
			boolean invokeBypass_INC11365785_searchEOBHistory=newClaimDetailsPage.validate_SearchEobHistory_onDetailPage(claimSystem,planType);
			if (invokeBypass_INC11365785_searchEOBHistory) {
				System.out.println("Encountered issue for INC11365785_searchEOBHistory on detail page");
				recordInvokedBypass.add("invokeBypass_INC11365785_searchEOBHistory_detailPage");
			}

			System.out.println("Proceed to validate 'Need Help' section on detail page");
			String currentURL=newClaimDetailsPage.validateNeedHelpSection(planType,memberType);

			//note: if all goes well, go back to summary page to prep for next step
			//note: if combo plan, after NeedHelp validation should land back on claims summary page.
			//note: but for non combo case, need to go back to claims summary page 
			if (!currentURL.contains("member/claims.html#/overview")) {
				claimSummarypage= newClaimDetailsPage.navigateBackToClaimSummaryPage(planType, claimPeriod);
			} 
		}
	}

	/**
	 * This step validate the followings on claims summary page
	 * - 'Learn More...' link
	 * - print button
	 * - download button
	 * - DownloadMyData button
	 * @throws Throwable
	 */
	@And("^I can validate the learn more and print and download option and DownloadMyData section on claims summary page$")
	public void validate_print_and_download_option_in_claims_table() throws Throwable {
		String claimPeriod = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);

		int numClaims=allClaims.get(claimPeriod);
		System.out.println("There are "+numClaims+" number of claims for claim period opion="+claimPeriod);
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if (numClaims <=0) {
			Assert.assertTrue("PROBLEM - Print and Download will only show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,claimSummarypage.verifyDownloadMyDataAndLearnMoreAndPrintAndDownloadOptions(numClaims, planType));
		} else {
			Assert.assertTrue("PROBLEM - Print and Download should show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,claimSummarypage.verifyDownloadMyDataAndLearnMoreAndPrintAndDownloadOptions(numClaims, planType));
		}
	}

	/**
	 * This step performs claims search using custom search option.
	 * It takes today's date 'To' date,  and 'from' date is the date 18 months ago from today's date
	 * Using the time different of 18 months on purpose in case in the future we want to compare search result with the EOB page search result (EOB max search range is 18 months)
	 * @throws InterruptedException
	 */
	@And("^I custom search claims for the specific time interval on claims summary page$")
	public void custom_search_claims_redesigned_site() throws InterruptedException{
		//note: today is the 'to' date | go back 18 months will be the from day  01/02/2018
		String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(18).toDate());
		String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		System.out.println("search range from '"+fromDate+"' to '"+toDate+"'");
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.customSearchClaimsByTimeInterval(planType, fromDate,toDate);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	/**
	 * This step performs claims search using custom search option with invalid date input arguments
	 * Validate expected error message
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@And("^I custom search claims for the following invalid time interval on claims summary page$")
	public void invalid_custom_search_claims_redesigned_site(DataTable memberAttributes) throws InterruptedException{
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String fromDate = memberAttributesMap.get(RedesignClaimsCommonConstants.CLAIMS_FROM_DATE);
		String toDate = memberAttributesMap.get(RedesignClaimsCommonConstants.CLAIMS_TO_DATE);
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);

		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.customSearchClaimsByTimeInterval(planType, fromDate,toDate);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	/**
	 * This step performs claims search using custom search option with date range that exceed two years starting from today's date.
	 * Validate expected error message
	 * @throws InterruptedException
	 */
	@And("^I custom search claims for over two years time interval from current date on claims summary page$")
	public void greaterThanTwoYears_custom_search_claims_redesigned_site() throws InterruptedException{
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
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
		newClaimsSummaryPage.customSearchClaimsByTimeInterval(planType, fromDate,toDate);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	/**
	 * This step performs claims search using custom search option with empty date inputs.
	 * Validate expected error message
	 */
	@Then("^I should be able to see the error message when no to and from dates being entered$")
	public void validateEmptyDatesErrorMessage(){
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimSummarypage.validateEmptyDatesError(planType);
	}

	/**
	 * This step performs claims search using custom search option with input arguments where the 'to' date older than 'from' date.
	 * Validate expected error message
	 */
	@Then("^I should be able to see the from date is greater than the to date error message being displayed$")
	public void validateToDateInvalidErrorMessage(){
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimSummarypage.validatefromDateLaterThanToDateError(planType);
	}

	/**
	 * This step performs validation for the claims table on claims summary page based on the input search period
	 */
	@Then("^I can validate claims table displayed based on the selection on claims summary page$")
	public void validate_claims_table_display(){
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimPeriod = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		String claimType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE);

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

	/**
	 * This step performs validation for 'Search EOB History' links on claims summary page based on the input arguments
	 */
	@And("^I can validate the EOB section based on claims system on claims summary page$")
	public void validate_EOB_redesigned_site(){
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);

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

	/**
	 * This step performs navigation from either dashboard or testharness to the claims summary page.
	 * If user is on dashboard page, it will navigate via the top menu 'Claims' link.
	 * If user is on testharness, it will navigate through the link for the claims summary page in the table.
	 */
	@When("^I navigate to the claims Summary page from dashboard or testharness page$") 
	public void navigate_Claims_Summary_page() {
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

	/**
	 * This step performs validation for the 'Need Help' section content on the claims summary page
	 */
	@When("^I validate the Need Help section content on claims summary page$")	
	public void validateNeedHelpSectionOnClaimsSummaryPage(){
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);

		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateNeedHelpSection(planType, memberType);
	}

	/**
	 * This step performs validation for the 'This page contains PDF documents...' text on claims summary page
	 */
	@Then("^I can validate the view as pdf link on claims details page header$")	
	public void i_can_validate_the_eob_pdf_link(){
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);

		ClaimDetailsPage claimsdetailspage = (ClaimDetailsPage )getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimsdetailspage.validateMedicalEOBfordifferentClaimssystem(claimSystem,planType);
		System.out.println("claims-============"+claimsdetailspage);
	}

	/**
	 * This step performs navigation from claims summary page to claims detail page using specific claims row on claims summary page
	 * This test is targeting a specific user data setup at the moment.  
	 * TODO - make this more flexible when we have more user data with EOB in the future
	 */
	@When("^I navigate to the Claim details page to see eob link on details page$")	
	public void i_navigate_to_the_eobclaims_detailspage(DataTable memberAttributes){
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		int pageNum=Integer.valueOf(memberAttributesMap.get("Page Number").trim());
		int rowNum=Integer.valueOf(memberAttributesMap.get("Row Number").trim());

		ClaimDetailsPage newClaimDetailsPage;
		
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
			newClaimDetailsPage=claimSummarypage.navigateToClaimDetailsPagetoseeeobpdflink(pageNum, rowNum);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			newClaimDetailsPage = accountHomePage.navigateToClaimDetailsPagetoseeeobpdflink(pageNum, rowNum);
		}
		System.out.println("claims details page -============"+newClaimDetailsPage);
		if(newClaimDetailsPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
	}

	/**
	 * This step should only be run when user is login to dashboard.
	 * This step performs navigation from dashboard page's 'View Your Claims' link to claims summary page
	 */
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
	/**
	 * This step is for VBF.
	 * This step performs claims table on claims summary page via method used by VBF case
	 */
	@Then("^I validate the claims displayed based on the selection on claims summary page$") 
	public void vbf_validate_claims_table_redesigned_site() {
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.vbf_validateClaimsTable();
	}	

	/**
	 * This step is for VBF.
	 * This step performs navigation from claims summary page to claims detail page via method used by VBF case
	 */
	public static String vbf_claimType;
	@And("^I can navigate to the Claim Details page from claims summary page$")
	public void vbf_i_navigate_to_member_redesign_claim_details_page() throws InterruptedException {
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
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

	/**
	 * This step is for VBF.
	 * This step performs validation for claims table on claims detail page via method used by VBF case
	 */
	@Then("^I can validate the Claims Table on claims details page$")
	public void vbf_validate_claimsTable_claimsDetails_AARP() {
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

	/**
	 * This step is for VBF.
	 * This step performs validation for claims total on claims detail page via method used by VBF case
	 */
	@And("^I can validate the Claims Total on claims details page$")
	public void vbf_validate_claims_total_AARP() {
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
	
	//added code to print test results note in jenkins report at the end of test for successful cases
	@cucumber.api.java.After
	public void testResultNote(Scenario scenario) {
		if(null!=getLoginScenario().getBean(ClaimsCommonConstants.TEST_RESULT_NOTE)) {   
			@SuppressWarnings("unchecked")   
			List<String> testNote=(List<String>) getLoginScenario().getBean(ClaimsCommonConstants.TEST_RESULT_NOTE);
			for (String s: testNote) {   
				scenario.write(s);
			}
			testNote.clear(); 
		}
	}
}
