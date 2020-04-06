package acceptancetests.memberredesign.claims;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimDetailsPage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.testharness.TestHarness;

/**
 Functionality : Helper steps for validating the Claims Summary & Claims Details Page on the member site.
 */
public class ClaimsSearchNavigateStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	//note: added code to print test results note in jenkins report at the end of test for successful cases
	@cucumber.api.java.After
	public void testResultNote(Scenario scenario) { 
		if(null!=getLoginScenario().getBean(ClaimsCommonConstants.TEST_RESULT_NOTE)) {   
			@SuppressWarnings("unchecked")   
			List<String> testNote=(List<String>) getLoginScenario()
			.getBean(ClaimsCommonConstants.TEST_RESULT_NOTE);
			for (String s: testNote) {   
				scenario.write(s);
			}
			testNote.clear(); 
		}
	}
	
	/**
	 * This step is for VBF.
	 * This step performs navigation from claims summary page to claims detail page via method used by VBF case
	 */
	@And("^I can navigate to the Claim Details page from claims summary page$")
	public void vbf_navigate_to_claim_details_page() throws InterruptedException { 
		String claimSystem = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		String vbf_claimType="";
		if (claimSystem.equalsIgnoreCase("COSMOSCLAIMS") || claimSystem.equalsIgnoreCase("NICECLAIMS")
				|| claimSystem.equalsIgnoreCase("SHIPCLAIMS")) {
			if (claimSystem.equalsIgnoreCase("SHIPCLAIMS")) {
				vbf_claimType = "SHIP";
			} else {
				vbf_claimType = "Medical";
			}
			ClaimsSummaryPage claimSummarypage = (ClaimsSummaryPage) getLoginScenario()
					.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
			ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPgByFirstClaim();
			Assert.assertTrue("PROBLEM - Claims details page is not loaded!!!", null != newClaimDetailsPage);
			//tbd if (null != newClaimDetailsPage)
				getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
				//tbd else {
				//tbd 	Assert.fail("Claims details page is not loaded!!!");
				//tbd }
		} else if (claimSystem.equalsIgnoreCase("RxCLAIMS")) {
			vbf_claimType = "Drug";
			System.out.println("Skipping Claim Details navigation!!!");

		} else {
			Assert.fail("Please check Claim syatems!!!");
		}
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE, vbf_claimType);
	}

	/**
	 * This step performs search using input search period (non-custom-search). 
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@And("^I can search claims for the following claim period on claims summary page$")
	public void search_by_claims_period(DataTable memberAttributes) throws InterruptedException { 
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String claimPeriod=memberAttributesMap.get("Claim Period");
		String memberType=memberAttributesMap.get("Member Type");
		String planType = memberAttributesMap.get("Plan Type");
		String claimSystem = memberAttributesMap.get("Claim System");

		//determine claim type
		String claimType="medical";
		if (claimSystem.contains("D_") || claimSystem.contains("RX_")) 
			claimType="prescription drug";
		else if (claimSystem.contains("COMPAS")) 
			claimType="NA";
		System.out.println("This test will validate for claimType='"+claimType+"'");
		
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE, planType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE, memberType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD, claimPeriod);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM, claimSystem);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE, claimType);

		System.out.println("claim period = "+claimPeriod);

		ClaimsSummaryPage newClaimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if(claimPeriod.equals("Custom search")){
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
		noteList.add("Claim Type       = "+claimType);
		noteList.add("Number of Claims = "+resultNumOfClaims);
		noteList.add("================================================================");
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_RESULT_NOTE, noteList);

		@SuppressWarnings("unchecked")		
		List<String> testNote=(List<String>) getLoginScenario()
		.getBean(ClaimsCommonConstants.TEST_RESULT_NOTE);
		System.out.println("\n\nPrint result note");
		for (String s: testNote) {
			System.out.println(s);
		}

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	/**
	 * This step will search claims based on the claims period input argument.
	 * If user has combo plan, it will go to the target plan tab, based on plan type
	 * being tested, first before doing the search.
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@And("^I can search claims for claim period and claim type on claim summary page$")
	public void search_by_claims_period_for_claimType(DataTable memberAttributes) throws InterruptedException { 
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String claimPeriod=memberAttributesMap.get("Claim Period");
		String planType = memberAttributesMap.get("Plan Type");
		String memberType = memberAttributesMap.get("Member Type");
		String claimType = memberAttributesMap.get("Claim Type");
		String claimSystem = memberAttributesMap.get("Claim System");
		if (claimType.equals("<claimType>")) {
			if (claimSystem.contains("D_") || claimSystem.contains("RX_")) 
				claimType="prescription drug";
			else 
				claimType="medical";
		}
		System.out.println("This test will validate for claimType='"+claimType+"'");
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE, planType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE, memberType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE, claimType);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD, claimPeriod);
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM, claimSystem);

		System.out.println("===================================================================================================");
		System.out.println("Proceed to test for claim period="+claimPeriod);
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimsSummaryPage.searchClaimsByTimePeriodClaimType(planType,claimPeriod, claimType);
		if(claimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummaryPage);
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
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			accountHomePage.navigateToClaimsPageByViewYourClaimsLinkThenBackToHome();
		}
	}

	/**
	 * This step (used by E2E2) will navigate from claims summary page to claims detail page 
	 * using the first row of claims on claims summary page.
	 * Assumption:  user will have claims
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@When("^I navigate to the Claim Details page from claims summary page$")
	public void i_navigate_to_claim_details() throws InterruptedException { 
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		String claimSystem = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);

		if (planType.toLowerCase().contains("pdp") || claimSystem.toUpperCase().contains("D_")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step to navigate to claims detail page");
			return;
		} 
		ClaimsSummaryPage claimSummarypage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPgByFirstClaim();
		
		Assert.assertTrue("PROBLEM - unable to go to Claims details page!!!",null != newClaimDetailsPage);
		getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
	} 

	/**
	 * This step performs navigation from either dashboard or testharness to the claims summary page.
	 * If user is on dashboard page, it will navigate via the top menu 'Claims' link.
	 * If user is on testharness, it will navigate through the link for the claims summary page in the table.
	 */
	@When("^I navigate to the claims Summary page from dashboard or testharness page$")
	public void navigate_Claims_Summary_page() { 
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("SKIP validation on team-atest env, does not support Rally page");
			return;
		}
		ClaimsSummaryPage newClaimsSummaryPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			newClaimsSummaryPage = testHarness.navigateToClaimsSummaryFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			newClaimsSummaryPage = accountHomePage.navigateToClaimsSummaryPage();
		}
		Assert.assertTrue("PROBLEM - unable to go to claims summary page", newClaimsSummaryPage!=null);
		getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);

		//note: initialize some variables that will be used by other steps later
		HashMap<String, Integer> allClaims = new HashMap<String, Integer>();
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_ALLCLAIMS, allClaims);
		
		List<String> recordInvokedBypass=new ArrayList<String>();
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_RECORDINVOKEDBYPASS, recordInvokedBypass);

		HashMap<String,List<HashMap<String,String>>> allClaimsData=new LinkedHashMap<String, List<HashMap<String,String>>>();
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_ALLCLAIMSDATA, allClaimsData);
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
	 * This step performs navigation from claims summary page to claims detail page using 
	 * specific claims row on claims summary page
	 * This test is targeting a specific user data setup at the moment.  
	 */
	@When("^I navigate to the Claim details page to see eob link on details page$")	
	public void i_navigate_to_the_eobclaims_detailspage(DataTable memberAttributes) { 
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		int pageNum=Integer.valueOf(memberAttributesMap.get("Page Number").trim());
		int rowNum=Integer.valueOf(memberAttributesMap.get("Row Number").trim());

		ClaimDetailsPage newClaimDetailsPage;
		
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			ClaimsSummaryPage claimSummarypage = (ClaimsSummaryPage) getLoginScenario()
					.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
			newClaimDetailsPage=claimSummarypage.navigateToClaimDetailsPgByMoreInfoLnk(pageNum, rowNum);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			newClaimDetailsPage = accountHomePage.navigateToClaimDetailsPagetoseeeobpdflink(pageNum, rowNum);
		}
		System.out.println("claims details page -============"+newClaimDetailsPage);
		if(newClaimDetailsPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
	}
	
	/**
	 * This step performs claims search using custom search option.
	 * It takes today's date 'To' date,  and 'from' date is the date 18 months ago from today's date
	 * Using the time different of 18 months on purpose in case in the future we want to compare search 
	 * result with the EOB page search result (EOB max search range is 18 months)
	 * @throws InterruptedException
	 */
	@And("^I custom search claims for the specific time interval on claims summary page$")
	public void custom_search_claims() throws InterruptedException{ 
		//note: today is the 'to' date | go back 18 months will be the from day  01/02/2018
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(18).toDate());
		String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		System.out.println("search range from '"+fromDate+"' to '"+toDate+"'");

		ClaimsSummaryPage newClaimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.customSearchClaimsByTimeInterval(planType, fromDate,toDate);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	/**
	 * This step performs claims search using custom search option.
	 * It searches claims that goes back to 6 years
	 * Note: custom search range max is 24 months between from - to date. BUT the date of the claims can go back to 6 years
	 * @throws InterruptedException
	 */
	@And("^I custom search claims for ship users for 6 years claims on claims summary page$")
	public void custom_search_claims_last6years() throws InterruptedException{ 
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);

		System.out.println("Starting to execute the SHIP greater than last 24 months which is last 6 years claims");
		String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(55).toDate());
		String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(43).toDate());
		System.out.println("search range from '"+fromDate+"' to '"+toDate+"'");

		ClaimsSummaryPage newClaimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.customSearchClaimsByTimeInterval(planType, fromDate,toDate);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	@And("^I can validate the calendar will show up for custom search when click on From and To calendars$")
	public void custom_search_calendar() throws InterruptedException{ 
		//note: today is the 'to' date | go back 18 months will be the from day  01/02/2018
		String planType = (String) getLoginScenario().getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(18).toDate());
		String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		System.out.println("search range from '"+fromDate+"' to '"+toDate+"'");

		ClaimsSummaryPage newClaimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.customSearchCalendar(planType, fromDate,toDate);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);	
	}

}
