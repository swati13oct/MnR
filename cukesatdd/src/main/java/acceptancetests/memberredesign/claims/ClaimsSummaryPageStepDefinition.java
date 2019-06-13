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
import acceptancetests.data.PageConstants;
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
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.vbf_validateClaimsTable();
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

		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.customSearchClaimsByTimeInterval(planType, fromDate,toDate);
		if(claimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummaryPage);
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
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		if (memberType.toLowerCase().contains("combo")) {
			System.out.println("This test is for combo plans, validate there are tabs and select the tab accordingly");
			claimsSummaryPage.validateComboTabs();
			claimsSummaryPage.goToSpecificComboTab(planType); //note: click the target tab for testing
		}
		claimsSummaryPage.validateClaimsSummaryHeaderSection(planType,memberType);	
		claimsSummaryPage.validateSystemErrorMsgNotExist();
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
		String claimPeriod = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		@SuppressWarnings("unchecked")
		HashMap<String, Integer> allClaims = (HashMap<String, Integer>) getLoginScenario()
		.getBean(ClaimsCommonConstants.TEST_ALLCLAIMS);

		int numClaims=allClaims.get(claimPeriod);
		System.out.println("There are "+numClaims+" number of claims for claim period opion="+claimPeriod);
		ClaimsSummaryPage claimSummarypage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if (numClaims <=0) {
			Assert.assertTrue("PROBLEM - Print and Download will only show up if more than 0 claims.  "
					+ "There are "+numClaims+" number of claims for claim period opion="+claimPeriod,
					claimSummarypage.verifyDnldMyDataAndLrnMoreAndPrtAndDnldOpt(numClaims, planType));
		} else {
			Assert.assertTrue("PROBLEM - Print and Download should show up if more than 0 claims.  "
					+ "There are "+numClaims+" number of claims for claim period opion="+claimPeriod,
					claimSummarypage.verifyDnldMyDataAndLrnMoreAndPrtAndDnldOpt(numClaims, planType));
		}
	}

	/**
	 * This step performs validation for user where the claims tab should not display on claims summary page
	 * Assumption: input user is SSUP individual
	 * @throws Throwable
	 */
	@When("^Explanation of benefits sub navigation under Claims tab is not displayed$")
	public void validate_ExplanationOfBenefits_SubNavigation_UnderClaimsTab() throws Throwable { 
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validateExpOfBenSubNavNotDispForSsup();
	}	

	/**
	 * This step performs validation for the EOB deep link from claims summary page.
	 * Assumption: input user is SSUP group
	 * @throws Throwable
	 */
	@When("^Validate Explanation of benefits Page for group SSUP$")
	public void validate_EOB_Tab_underClaims() throws Throwable { 
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validateExpOfBenSubNavDispForGroupSsup();
	}

	/**
	 * This step performs validation for the EOB deep link from claims summary page.
	 * Assumption: input user is SSUP individual
	 * @throws Throwable
	 */
	@When("^Explanation of benefits deep link is invoked and validate the Page$")
	public void validate_ExplanationOfBenefits_DeepLink() throws Throwable { 
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.invokeEobDeepLink();
	}

	/**
	 * This step validates the error message will display when user is PHIP member.
	 * Assumption:  input test user is a PHIP member
	 * @throws Throwable
	 */
	@When("^I validate the error message for a PHIP Member on the screen$")
	public void validate_PHIP_error() throws Throwable { 
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validatePHIPErrorMessage();
	}

	/**
	 * This step performs claims search using custom search option with date range that exceed two years starting from today's date.
	 * Validate expected error message
	 * @throws InterruptedException
	 */
	@And("^I custom search claims for over two years time interval from current date on claims summary page$")
	public void greaterThanTwoYears_custom_search_claims() throws InterruptedException{ 
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

		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.customSearchClaimsByTimeInterval(planType, fromDate,toDate);
		if(claimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummaryPage);
	}

	/**
	 * This step performs claims search using custom search option with empty date inputs on claims summary page.
	 * Validate expected error message
	 */
	@Then("^I should be able to see the error message when no to and from dates being entered$")
	public void validateEmptyDatesErrorMessage(){ 
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validateEmptyDatesError(planType);
	}

	/**
	 * This step performs claims search using custom search option with input arguments where the 'to' date older than 'from' date.
	 * Validate expected error message
	 */
	@Then("^I should be able to see the from date is greater than the to date error message being displayed$")
	public void validateToDateInvalidErrorMessage(){ 
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validatefromDateLaterThanToDateError(planType);
	}
	
	/**
	 * This step (used by E2E) validates pagination on the claims summary page.
	 * Assumption: user has claims
	 * @throws Throwable
	 */
	@And("^I validate the pagination on the claims summary page$")
	public void validate_pagination() throws Throwable { 
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - not getting expected pagination.  "
				+ "NOTE: pagination will only show if user has claims for the search range",claimsSummaryPage.verifyPagination());
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
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimsSummaryPage.validateClickLrnMoreAndPrtAndDnldOpt());
	}

	/**
	 * This step validates claims table being displayed for user.
	 * Assumption: user has claims.
	 */
	@Then("^I can see the claims displayed based on the selection on claims summary page$")
	public void validate_claims_table() { 
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		boolean flagZeroClaimUser=true;
		claimsSummaryPage.validateClaimsTableExists(flagZeroClaimUser);
		if(claimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummaryPage);
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

		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validateSearchEobHisotry(claimSystem, planType);
		if(claimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummaryPage);
	}

	/**
	 * This step validates 'DownloadMyData' section on claims summary page.
	 * @param memberAttributes
	 */
	@And("^I validate the DownloadMyData section on claims summary page$")
	public void validates_DownloadMyData(){ 
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validateDnldMyData();
		if(claimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummaryPage);
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
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		int numClaims=allClaims.get(claimPeriod);
		System.out.println("There are "+numClaims+" number of claims for claim period opion="+claimPeriod);
		if (numClaims <=0) {
			Assert.assertTrue("PROBLEM - Pagination will only show up if more than 0 claims.  "
					+ "There are "+numClaims+" number of claims for claim period opion="+claimPeriod,!claimsSummaryPage.verifyPagination());
		} else {
			Assert.assertTrue("PROBLEM - Pagination should show up if more than 0 claims.  "
					+ "There are "+numClaims+" number of claims for claim period opion="+claimPeriod,claimsSummaryPage.verifyPagination());
		}
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
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		int numClaims=claimsSummaryPage.getNumClaims(claimPeriod, claimType);
		System.out.println("Number of Claims="+numClaims);
		allClaims.put(claimPeriod, numClaims);
		if (claimType.equalsIgnoreCase("Prescription drug") && memberType.toUpperCase().contains("SSO")) {
			claimsSummaryPage.validateClaimsTableSectionOptumRxText(numClaims);
		}
		claimsSummaryPage.validateSystemErrorMsgNotExist();
		claimsSummaryPage.printListOfClaimsResult(allClaims);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_ALLCLAIMS, allClaims);
	}
	
	/**
	 * This step validates the custom search expected error message when search range exceed 24 months. 
	 * @param memberAttributes
	 */
	@Then("^I should be able to see the search range is greater than two years error$")
	@SuppressWarnings("unchecked")
	public void validateGreaterThanTwoYearsMessage() { 
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		HashMap<String, Integer> allClaims = (HashMap<String, Integer>) getLoginScenario()
			.getBean(ClaimsCommonConstants.TEST_ALLCLAIMS);
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.validateGreaterThanTwoYearError(planType);

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
		if (planType.equalsIgnoreCase("ship") || planType.equalsIgnoreCase("pdp")) {
			hasYourShare=false;
		}
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
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		boolean invokeBypass_INC11365785_searchEOBHistory=claimsSummaryPage.validateSummPgSearchEobHistory(claimSystem, planType);
		if (invokeBypass_INC11365785_searchEOBHistory) {
			System.out.println("Encountered issue for INC11365785_searchEOBHistory on summary page");
			recordInvokedBypass.add("invokeBypass_INC11365785_searchEOBHistory_summaryPage");
		}

		System.out.println("Proceed to validate 'This page contains PDF documents...' text on summary page");
		boolean invokeBypass_INC11365785_containsPdfDocText=claimsSummaryPage.validateAdobePdfDocText();
		if (invokeBypass_INC11365785_containsPdfDocText) {
			System.out.println("Encountered issue for INC11365785_containsPdfDocText on summary page");
			recordInvokedBypass.add("invokeBypass_INC11365785_containsPdfDocText_summaryPage");
		}
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_RECORDINVOKEDBYPASS, recordInvokedBypass);
		if(claimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummaryPage);
	}
}
