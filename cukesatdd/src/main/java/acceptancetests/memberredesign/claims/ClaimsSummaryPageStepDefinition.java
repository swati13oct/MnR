package acceptancetests.memberredesign.claims;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.regression.claims.ClaimsSummaryPage;

/**
 * Step definitions for the Claims Summary Page on the member site.
 */
public class ClaimsSummaryPageStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * This step is for VBF.
	 * This step performs claims table on claims summary page via method used by VBF case
	 */
	@Then("^I validate the claims displayed based on the selection on claims summary page$") 
	public void vbf_validate_claims_table() { 
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummPg.vbf_validateClaimsTable();
	}	

	/**
	 * This step performs claims search using custom search option with invalid date input arguments
	 * Validate expected error message
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@And("^I custom search claims for the following invalid time interval on claims summary page$")
	public void validate_invalid_custom_search_claims(DataTable memberAttributes) throws InterruptedException{ 
		Map<String, String> memberAttributesMap=ClaimsSearchNavigateStepDefinition.parseInputArguments(memberAttributes);
		String fromDate = memberAttributesMap.get(ClaimsCommonConstants.CLAIMS_FROM_DATE);
		String toDate = memberAttributesMap.get(ClaimsCommonConstants.CLAIMS_TO_DATE);
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);

		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummPg.customSearchClaimsByTimeInterval(planType, fromDate,toDate);
		if(claimsSummPg != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummPg);
	}

	/**
	 * This step validates header section content on the claims summary page.
	 * If user has combo plan, navigates to the plan based on input plan type then performs validation.
	 * @param memberAttributes
	 */
	@Then("^I can validate the claims summary header on claims summary page$")
	public void validate_the_claims_summary_header(DataTable memberAttributes) { 
		Map<String, String> memberAttributesMap=ClaimsSearchNavigateStepDefinition.parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		String memberType = memberAttributesMap.get("Member Type");
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if (memberType.toLowerCase().contains("combo")) {
			System.out.println("This test is for combo plans, validate there are tabs and select the tab accordingly");
			claimsSummPg.validateComboTabs();
			claimsSummPg.goToSpecificComboTab(planType); //note: click the target tab for testing
		} else {
			System.out.println("TEST - test is not specifically testing for combo but user maybe combo, handle the combo selection");
			boolean flagNonCombo=false; //note: if user has combo then select the right plan
			claimsSummPg.goToSpecificComboTab(planType, flagNonCombo); //note: click the target tab for testing
		}
		claimsSummPg.validateClaimsSummaryHeaderSection(planType,memberType);	
		claimsSummPg.validateSystemErrorMsgNotExist();
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE, planType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE, memberType);
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
	@SuppressWarnings("unchecked")
	public void validate_print_and_download_option_in_claims_table() throws Throwable { 
		String claimPeriod = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		HashMap<String, Integer> allClaims = (HashMap<String, Integer>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_ALLCLAIMS);

		int numClaims=allClaims.get(claimPeriod);
		System.out.println("There are "+numClaims+" number of claims for claim period opion="+claimPeriod);
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummPg.verifyDnldMyDataAndLrnMoreAndPrtAndDnldOpt(numClaims, planType);
	}

	/**
	 * This step performs validation for user where the claims tab should not display on claims summary page
	 * Assumption: input user is SSUP individual
	 * @throws Throwable
	 */
	@When("^Explanation of benefits sub navigation under Claims tab is not displayed$")
	public void validate_ExplanationOfBenefits_SubNavigation_UnderClaimsTab() throws Throwable { 
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummPg.validateExpOfBenSubNavNotDispForSsup();
	}	

	/**
	 * This step performs validation for the EOB deep link from claims summary page.
	 * Assumption: input user is SSUP group
	 * @throws Throwable
	 */
	@When("^Validate Explanation of benefits Page for group SSUP$")
	public void validate_EOB_Tab_underClaims() throws Throwable { 
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummPg.validateExpOfBenSubNavDispForGroupSsup();
	}

	/**
	 * This step performs validation for the EOB deep link from claims summary page.
	 * Assumption: input user is SSUP individual
	 * @throws Throwable
	 */
	@When("^Explanation of benefits deep link is invoked and validate the Page$")
	public void validate_ExplanationOfBenefits_DeepLink() throws Throwable { 
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummPg.invokeEobDeepLink();
	}

	/**
	 * This step validates the error message will display when user is PHIP member.
	 * Assumption:  input test user is a PHIP member
	 * @throws Throwable
	 */
	@When("^I validate the error message for a PHIP Member on the screen$")
	public void validate_PHIP_error() throws Throwable { 
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummPg.validatePHIPErrorMessage();
	}

	/**
	 * This step performs claims search using custom search option with date range that exceed two years starting from today's date.
	 * Validate expected error message
	 * @throws InterruptedException
	 */
	@And("^I custom search claims for over two years time interval from current date on claims summary page$")
	public void greaterThanTwoYears_custom_search_claims() throws InterruptedException{ 
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
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

		claimsSummPg.customSearchClaimsByTimeInterval(planType, fromDate,toDate);
		if(claimsSummPg != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummPg);
	}

	/**
	 * This step performs claims search using custom search option with empty date inputs on claims summary page.
	 * Validate expected error message
	 */
	@Then("^I should be able to see the error message when no to and from dates being entered$")
	public void validateEmptyDatesErrorMessage(){
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		//tbd if (claimsSummPg.getOnlyTestUiFlag())
		//tbd 	System.out.println("TEST UI ONLY - will not validate custom search error for no to and from dates being entered");
		//tbd else {
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		claimsSummPg.validateEmptyDatesError(planType);
		//tbd }
	}

	/**
	 * This step performs claims search using custom search option with input arguments where the 'to' date older than 'from' date.
	 * Validate expected error message
	 */
	@Then("^I should be able to see the from date is greater than the to date error message being displayed$")
	public void validateToDateInvalidErrorMessage(){ 
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		claimsSummPg.validatefromDateLaterThanToDateError(planType);
	}

	/**
	 * This step (used by E2E) validates pagination on the claims summary page.
	 * Assumption: user has claims
	 * @throws Throwable
	 */
	@And("^I validate the pagination on the claims summary page$")
	public void validate_pagination() throws Throwable { 
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		//note: use by E2E non-extensive, just put a non-zero number to validate pagination shows up
		int tmpClaims=(Integer) getLoginScenario().getBean(ClaimsCommonConstants.TEST_CURRENTCLAIMS);
		if (tmpClaims==0) 
			Assert.assertTrue("PROBLEM - should not get pagination for user with 0 claim.  "
					+ "NOTE: pagination will only show if user has claims for the search range",!claimsSummPg.verifyPagination(tmpClaims));
		else
			Assert.assertTrue("PROBLEM - not getting expected pagination.  "
					+ "NOTE: pagination will only show if user has claims for the search range",claimsSummPg.verifyPagination(tmpClaims));
	}

	/**
	 * This step performs validation for the 'Need Help' section content on the claims summary page
	 */
	@When("^I validate the Need Help section content on claims summary page$")	
	public void validateNeedHelpSectionOnClaimsSummaryPage(){ 
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if (MRScenario.environment.contains("team-a"))
			System.out.println("NOTE: MRREST product summary call (used for Need Help) is disabled on team env, will skip this validation on team-a env");
		else
			claimsSummaryPage.validateSectionInNeedHelp(planType, memberType);
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
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummPg.validateClickLrnMoreAndPrtAndDnldOpt();
	}

	/**
	 * This step validates claims table being displayed for user.
	 * Assumption: user has claims.
	 */
	@Then("^I can see the claims displayed based on the selection on claims summary page$")
	public void validate_claims_table() { 
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		boolean flagZeroClaimUser=true;
		if (claimsSummPg.getOnlyTestUiFlag()) 
			flagZeroClaimUser=false;
		boolean result=claimsSummPg.validateClaimsTableExists(flagZeroClaimUser);
		if (!claimsSummPg.getOnlyTestUiFlag() && !result) 
			Assert.assertTrue("PROBLEM - validateClaimsTableExists return false with flagZeroClaimUser is set to '"+flagZeroClaimUser+"')", result);
		if(claimsSummPg != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummPg);
	}

	/** 
	 * This step validates the 'Search EOB History' link(s) on claims summary page.
	 * @param memberAttributes
	 */
	@And("^I validate the EOB section based on claims system on claims summary page$")
	public void validates_Search_EOB_History(){ 
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);

		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummPg.validateSummPgSrchEobHistory(claimSystem, planType);
		if(claimsSummPg != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummPg);
	}

	/**
	 * This step validates 'DownloadMyData' section on claims summary page.
	 * @param memberAttributes
	 */
	@And("^I validate the DownloadMyData section on claims summary page$")
	public void validates_DownloadMyData(){ 
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummPg.validateClickMyDnldMyDataBtn(planType); 
		if(claimsSummPg != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummPg);
	}	

	/**
	 * This step validates pagination.  Pagination should show when there is claims.
	 * @throws Throwable
	 */
	@And("^I validate the pagination on the claims summary page for given range$")
	@SuppressWarnings("unchecked")
	public void validatePagination_extensive() throws Throwable { 
		String claimPeriod = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		HashMap<String, Integer> allClaims = (HashMap<String, Integer>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_ALLCLAIMS);
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		int numClaims=allClaims.get(claimPeriod);
		System.out.println("There are "+numClaims+" number of claims for claim period opion="+claimPeriod);
		if (numClaims <=0) 
			Assert.assertTrue("PROBLEM - Pagination will only show up if more than 0 claims.  "
					+ "There are "+numClaims+" number of claims for claim period opion="+claimPeriod,
					!claimsSummPg.verifyPagination(numClaims));
		else 
			Assert.assertTrue("PROBLEM - Pagination should show up if more than 0 claims.  "
					+ "There are "+numClaims+" number of claims for claim period opion="+claimPeriod,
					claimsSummPg.verifyPagination(numClaims));
	}

	/**
	 * Helper method to retrieve the number of claims for a search period to perform further validation
	 */
	@Then("^I can see the number of claims$")
	@SuppressWarnings("unchecked")
	public void getClaimsNumber() { 
		String claimPeriod = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String claimType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE);
		String memberType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		HashMap<String, Integer> allClaims = (HashMap<String, Integer>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_ALLCLAIMS);
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		int numClaims=claimsSummPg.getNumClaims(claimPeriod, claimType);
		System.out.println("Number of Claims="+numClaims);
		allClaims.put(claimPeriod, numClaims);
		if (claimType.equalsIgnoreCase("Prescription drug") && memberType.toUpperCase().contains("SSO")) {
			claimsSummPg.validateClaimsTableSectionOptumRxText(numClaims);
		}
		claimsSummPg.validateSystemErrorMsgNotExist();
		claimsSummPg.printListOfClaimsResult(allClaims);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_CURRENTCLAIMS, numClaims);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_ALLCLAIMS, allClaims);
	}

	/**
	 * This step validates the custom search expected error message when search range exceed 24 months. 
	 * @param memberAttributes
	 */
	@Then("^I should be able to see the search range is greater than two years error$")
	@SuppressWarnings("unchecked")
	public void validateGreaterThanTwoYearsMessage() { 
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		HashMap<String, Integer> allClaims = (HashMap<String, Integer>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_ALLCLAIMS);
		claimsSummPg.validateGreaterThanTwoYearError(planType);

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
	 * This step performs validation for the claims table on claims summary page based on the input search period
	 */
	@Then("^I can validate claims table displayed based on the selection on claims summary page$")
	@SuppressWarnings("unchecked")
	public void validate_claims_table_display() { 
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimPeriod = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String claimSystem = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		String claimType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE);
		HashMap<String, Integer> allClaims = (HashMap<String, Integer>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_ALLCLAIMS);

		boolean hasYourShare=true;
		if (planType.equalsIgnoreCase("ship") || planType.equalsIgnoreCase("pdp")) 
			hasYourShare=false;
		int numClaims=allClaims.get(claimPeriod);
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validateClaimsTable(planType, numClaims, claimType, claimSystem, hasYourShare);
		if(claimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummaryPage);
	}

	/**
	 * This step performs validation for 'Search EOB History' links on claims summary page based on the input arguments
	 */
	@And("^I can validate the EOB section based on claims system on claims summary page$")
	@SuppressWarnings("unchecked")
	public void validates_Search_EOB_History_extensive() { 
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		List<String> recordInvokedBypass = (List<String>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_RECORDINVOKEDBYPASS);
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		boolean bypass_INC11365785_srchEobHist=claimsSummPg.validateSummPgSrchEobHistory(claimSystem, planType);
		if (bypass_INC11365785_srchEobHist) {
			System.out.println("Encountered issue for INC11365785_searchEOBHistory on summary page");
			recordInvokedBypass.add("bypass_INC11365785_searchEOBHistory_summaryPage");
		}

		System.out.println("Proceed to validate 'This page contains PDF documents...' text on summary page");
		boolean bypass_INC11365785_adobePdfDocTxt=claimsSummPg.validateAdobePdfDocText();
		if (bypass_INC11365785_adobePdfDocTxt) {
			System.out.println("Encountered issue for INC11365785_containsPdfDocText on summary page");
			recordInvokedBypass.add("bypass_INC11365785_containsPdfDocText_summaryPage");
		}
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_RECORDINVOKEDBYPASS, recordInvokedBypass);
		if(claimsSummPg != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummPg);
	}

	@Then("^I can validate the segment ID value in localStorage on claims summary page$")
	public void validates_segmentid(DataTable memberAttributes) {
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		//tbd if (claimsSummPg.getOnlyTestUiFlag()) 
		//tbd 	System.out.println("TEST UI ONLY - will not validate segment ID");
		//tbd else {		
		Map<String, String> memberAttributesMap=ClaimsSearchNavigateStepDefinition.parseInputArguments(memberAttributes);
		String expectedSegmentId = memberAttributesMap.get("Segment ID");
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		claimsSummPg.validateSegmentId(planType, memberType, expectedSegmentId);
		//tbd }
	}

	@When("^I am validating UI only$")
	public void onlyTestUi() {
		ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummPg.setOnlyTestUiFlag(true);
		claimsSummPg.setTestOnlyUiFlagForAll(true);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_ONLY_TEST_UI_FLAG, true);
		getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummPg);
	}
}
