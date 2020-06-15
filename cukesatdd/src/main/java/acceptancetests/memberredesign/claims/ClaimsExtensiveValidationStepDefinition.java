package acceptancetests.memberredesign.claims;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import pages.regression.claims.ClaimDetailsPage;
import pages.regression.claims.ClaimsSummaryPage;

/**
 * Step definitions for extensive validations for Claims Summary and Claim Details Page on the member site.
 */
public class ClaimsExtensiveValidationStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
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
	@SuppressWarnings("unchecked")
	public void compareAllClaimsPeriods(DataTable memberAttributes) {
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		HashMap<String, Integer> allClaims = (HashMap<String, Integer>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_ALLCLAIMS);
		List<String> recordInvokedBypass = (List<String>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_RECORDINVOKEDBYPASS);		
		HashMap<String,List<HashMap<String,String>>> allClaimsData = (HashMap<String,List<HashMap<String,String>>>) 
				getLoginScenario().getBean(ClaimsCommonConstants.TEST_ALLCLAIMSDATA);
		List<String> searchOptions=new ArrayList<String>();
		searchOptions.add("Last 30 days");
		searchOptions.add("Last 90 days");
		searchOptions.add("Last 6 months");
		searchOptions.add("Last 12 months");
		searchOptions.add("Last 24 months");
		searchOptions.add("Custom search");

		//note: use this flag to determine if you want to fail the case if zero claims
		Map<String, String> memberAttributesMap=ClaimsSearchNavigateStepDefinition.parseInputArguments(memberAttributes);
		String flagZeroClaimsUserInput = memberAttributesMap.get("Flag Zero Claims User");
		Assert.assertTrue("PROBLEM - 'Flag Zero Claims User' can only be yes or no.  Actual="+flagZeroClaimsUserInput, 
				flagZeroClaimsUserInput.equalsIgnoreCase("yes") || flagZeroClaimsUserInput.equalsIgnoreCase("no"));

		String claimType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE);

		boolean flagZeroClaimsUser=true;
		if (flagZeroClaimsUserInput.equalsIgnoreCase("yes"))
			flagZeroClaimsUser=true;
		else 
			flagZeroClaimsUser=false;

		//note: do the logic for validating whether claims number makes sense between pages
		claimsSummaryPage.validateNumOfClaimsForEachPeriod(allClaims, flagZeroClaimsUser); 
		claimsSummaryPage.validateDataRowsSequenceAndDataExistsInOtherSearchPeriods(searchOptions, allClaimsData, claimType);

		//note: store the test note to display later if needed
		List<String> noteList=new ArrayList<String>();
		//note: display any of the issues encountered that are currently bypassed
		noteList.add("\n\n================================================================");
		noteList.add("===== TEST NOTE ================================================");
		noteList.add("Plan Type    = "+(String) getLoginScenario()
			.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE));
		noteList.add("Member Type  = "+(String) getLoginScenario()
			.getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE));
		noteList.add("Claim System = "+(String) getLoginScenario()
			.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM));
		noteList.add("Claim Type   = "+(String) getLoginScenario()
			.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE));
		noteList.add("========== Data collected during test run ======================");
		noteList.add("========== known issues ==========");
		if (recordInvokedBypass.size()==0) {
			noteList.add("Did not encounter any existing known issues");
		} else {
			noteList.add("Encountered existing known issues:");
			for (String s: recordInvokedBypass) 
				noteList.add("  issue: "+s);
		}
		noteList.add("------------ begin list of claims result ---------------");
		noteList.add("Number of claims for 'Last 30 days'       = "
				+String.valueOf(allClaims.get("Last 30 days")));
		noteList.add("Number of claims for 'Last 90 days'       = "
				+String.valueOf(allClaims.get("Last 90 days")));
		noteList.add("Number of claims for 'Last 6 months'      = "
				+String.valueOf(allClaims.get("Last 6 months")));
		noteList.add("Number of claims for 'Last 12 months'     = "
				+String.valueOf(allClaims.get("Last 12 months")));
		noteList.add("Number of claims for 'Last 24 months'     = "
				+String.valueOf(allClaims.get("Last 24 months")));
		noteList.add("Number of claims for 'Last Custom search' = "
				+String.valueOf(allClaims.get("Custom search")));
		noteList.add("------------ end list of claims result ---------------");
		noteList.add("================================================================");

		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_RESULT_NOTE, noteList);

		List<String> result_testNote=(List<String>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_RESULT_NOTE);
		for (String s: result_testNote) {
			System.out.println(s);
		}
	}
	
	/**
	 * This step will do comprehensive validation (used by the long case) for the following:
	 * It takes the values rows claims from claims summary page and validate them against the info display on detail page
	 * It has potential to loop through all rows that are displaying at the time on claims summary page, 
	 * current setup will validate the first 2 rows only to speed up test time
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
	@Then("^I perform extensive validation for values between claims summary and claim details page$")
	@SuppressWarnings("unchecked")
	public void validate_claim_details_extensive() throws InterruptedException {
		// note: only validate for medical case, skip for prescription drug case because that one doesn't have 'More Info'
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimPeriod = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String claimType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE);
		String claimSystem = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		HashMap<String, Integer> allClaims = (HashMap<String, Integer>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_ALLCLAIMS);
		List<String> recordInvokedBypass = (List<String>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_RECORDINVOKEDBYPASS);
		HashMap<String,List<HashMap<String,String>>> allClaimsData = (HashMap<String,List<HashMap<String,String>>>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_ALLCLAIMSDATA);

		boolean hasYourShare=true;
		if (planType.equalsIgnoreCase("ship") || planType.equalsIgnoreCase("pdp") )
			hasYourShare=false;
		
		int numClaims=allClaims.get(claimPeriod);
		List<HashMap<String,String>> claimsDataForSearchPeriod=new ArrayList<HashMap<String,String>>();
		if (numClaims > 0) {	//note: only do this if claims > 0
			System.out.println("Proceed to Claims Summary page");
			ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
					.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
			claimsSummaryPage.validateSystemErrorMsgNotExist();  //note: don't bother if getting system error already
			//note: this can be updated handle more than 1 page of claims, 
			//note: for now just handle 1st page of claims if there are more than 1 page
			//note: gather data on summary page for validation on detail page
			int totalDataRows=claimsSummaryPage.getTableTotalDataRows(claimType);
			System.out.println("Determine number of data rows on table="+totalDataRows);
			int total=0;
			if (totalDataRows < 3) {
				total=totalDataRows+1;
			} else {
				total=(totalDataRows+2); //note: cap at max =4 to cut down test time including header
				if (total>4) {
					total=4;
					System.out.println("Total claims='"+totalDataRows+"', will validate the first 2 rows for detail to shorten test time");
				}
			}
			//KEEP- for (int x=2; x<(totalDataRows+2); x++) {		//note: use this instead if want to validate all entries
			for (int x=2; x<total; x++) { //note: look at row index 2, 3
				System.out.println("========================================================================");
				System.out.println("Proceed to validate data row index="+x+" ===============================");
				HashMap<String, String> dataMapSummary=claimsSummaryPage.gatherDataFromSummaryPage(claimType, x, claimSystem, hasYourShare);
				claimsDataForSearchPeriod.add(dataMapSummary); //note: save the info for later overall validation
				if (claimType.equalsIgnoreCase("prescription drug")) {
					System.out.println("Prescription drug doesn't have more info for claims, skip claims detail validation");
				} else {
					ClaimDetailsPage newClaimDetailsPage = claimsSummaryPage.navigateToClaimDetailsPgByClaimRow(x);
					Assert.assertTrue("PROBLEM - unable to load claims detail page from a given claims row on claims summary page. "
							+ "table row index='"+x+"'", newClaimDetailsPage!=null);
					
					newClaimDetailsPage.validateSystemErrorMsgNotExist();
					
					System.out.println("Proceed to validate claims table");
					getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
					//note: collect the values on the detail page then perform comparison between data collected from summary page
					HashMap<String, String> dataMapDetail=newClaimDetailsPage.gatherDataFromDetlPg(claimType);
					boolean invokedBypass_INC10332773_YourShareMissmatched=newClaimDetailsPage.compareSummAndDetlData(claimType, 
							dataMapSummary, dataMapDetail);
					if (invokedBypass_INC10332773_YourShareMissmatched) {  //note: keep track of the known issues encountered
						System.out.println("Encountered issue for INC10332773_YourShareMissmatched_detailPage on detail page");
						recordInvokedBypass.add("invokedBypass_INC10332773_YourShareMissmatched_detailPage");
					}

					System.out.println("Proceed to validate claims total - if encounter INC10332773 then ignore the failure for now");
					double totalYourPlanPaid=newClaimDetailsPage.validateClaimsTotalAccurate(invokedBypass_INC10332773_YourShareMissmatched, planType);

					if (planType.equalsIgnoreCase("SHIP")) {
						double adjustmentValue=newClaimDetailsPage.validateClaimsTotSection(planType);
						Assert.assertTrue("PROBLEM - 'Your Plan Paid' value is not the same as the 'Adjustment' value. totalYourPlanPaid='"+totalYourPlanPaid+"' | adjustmentValue='"+adjustmentValue+"' ", totalYourPlanPaid==adjustmentValue);
					}
					//note: if all goes well, go back to the summary page to prep for next run
					claimsSummaryPage= newClaimDetailsPage.navigateBackToClaimSummPg(planType, claimPeriod);
					Assert.assertTrue("PROBLEM - unable to get back to claims summary page to prep for next test step", 
							claimsSummaryPage!=null);
				}
			} //note: end for loop that loops the number of claims rows on summary page
		} else {
			System.out.println("There is 0 claims for claim period '"+claimPeriod+"', skip claims detail validation");
		}
		allClaimsData.put(claimPeriod, claimsDataForSearchPeriod); //note: save the info for later overall validation
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_ALLCLAIMSDATA, allClaimsData);
	}
}
