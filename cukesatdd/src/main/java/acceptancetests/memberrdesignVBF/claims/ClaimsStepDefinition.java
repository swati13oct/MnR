package acceptancetests.memberrdesignVBF.claims;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.memberrdesignVBF.ClaimDetailsPage;
import pages.memberrdesignVBF.ClaimSummarypage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;

public class ClaimsStepDefinition {
	@Autowired
	MRScenario loginScenario;
	// Map<String, String> memberAttributesMap = new LinkedHashMap<String,
	// String>();
	public static String claimType;
	
	

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 */
	@When("^I navigate to the claims Summary page in redesigned site$")
	public void navigate_Claims_Summary_redesigned() {
		ClaimSummarypage newClaimsSummaryPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			newClaimsSummaryPage = testHarness.navigateToClaimsSummaryPage();
		} else {
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);

			newClaimsSummaryPage = rallyDashboard.navigateToClaimsSummaryPage();
		}
		if (newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	/***
	 * 
	 * @param timeAttributes
	 */
	@And("^the user search claims for the following claim period in AARP site$")
	public void search_claims_period_redesigned_site(DataTable timeAttributes) {
		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < timeAttributesRow.size(); i++) {

			urlAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}

		System.out.println(urlAttributesMap.get("Claim Period"));
		
		String period = urlAttributesMap.get("Claim Period");
		String planType = urlAttributesMap.get("Plan Type");
		String ClaimSystem = urlAttributesMap.get("ClaimSystem");

		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		newClaimsSummaryPage.searchClaimsByTimePeriod(planType, period, ClaimSystem);
	}

	/***
	 * 
	 */
	@Then("^user validates the claims displayed based on the selection in redesigned site$")
	public void validate_claims_table_redesigned_site() {
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validateClaimsTable();
	}

	/***
	 * 
	 * @param memberAttributes
	 */
	@And("^the user validates the EOB section based on domain in redesigned site$")
	public void validates_EOB_redesigned_site(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			CommonStepDefinition.getMemberAttributeMap().put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = CommonStepDefinition.getMemberAttributeMap().get("Plan Type");
		String domain = CommonStepDefinition.getMemberAttributeMap().get("Domain");
		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateEobfordifferentDomainType(domain, planType);
	}

	/***
	 * 
	 */
	@And("^the user validates the DownloadMyData section in redesigned site$")
	public void validates_DownloadMyData_redesigned_site() {
		String ClaimSystem = CommonStepDefinition.getMemberAttributeMap().get("ClaimSystem");
		if(!ClaimSystem.equalsIgnoreCase("SHIPCLAIMS")){
		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateDownloadMyData();
		}
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^I navigate to the Claim Details page in AARP site$")
	public void i_navigate_to_member_redesign_claim_details_page(DataTable timeAttributes) throws InterruptedException {
		
			String ClaimSystem = CommonStepDefinition.getMemberAttributeMap().get("ClaimSystem");
	
			if (ClaimSystem.equalsIgnoreCase("COSMOSCLAIMS") || ClaimSystem.equalsIgnoreCase("NICECLAIMS")
					|| ClaimSystem.equalsIgnoreCase("SHIPCLAIMS")) {
				if (ClaimSystem.equalsIgnoreCase("SHIPCLAIMS")) {
					claimType = "SHIP";
				} else {
					claimType = "Medical";
				}
				ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario()
						.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
				ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPage();
				if (null != newClaimDetailsPage)
					getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
				else {
					Assert.fail("Claims details page is not loaded!!!");
				}
			} else if (ClaimSystem.equalsIgnoreCase("RxCLAIMS")) {
				claimType = "Drug";
				System.out.println("Skipping Claim Details navigation!!!");
			} else {
				Assert.fail("Please check Claim syatems!!!");
			}
		
	}

	/***
	 * 
	 */
	@Then("^I validate the Claims Table in claims details page in AARP site$")
	public void validate_claimsTable_claimsDetails_AARP() {
		
			if (claimType.equalsIgnoreCase("Medical")) {
				ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario()
						.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
				claimDetailspage.validateClaimsTableInDetailsPage();
			} else if (claimType.equalsIgnoreCase("Drug")) {
				System.out.println("Skipping Claim Details validation!!!");
			} else if (claimType.equalsIgnoreCase("SHIP")) {
				ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario()
						.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
				claimDetailspage.validateShipClaimsTableInDetailsPage();
			}
	
	}

	/***
	 * 
	 */
	@And("^I validate the Claims Total in claims details page in AARP site$")
	public void validate_claims_total_AARP() {
		
	
			if (claimType.equalsIgnoreCase("Medical")) {
				ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario()
						.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
				claimDetailspage.validateClaimsTotalInDetailsPage();
			} else if (claimType.equalsIgnoreCase("SHIP")) {
				ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario()
						.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
				claimDetailspage.validateShipClaimsTotalInDetailsPage();
			} else if (claimType.equalsIgnoreCase("Drug")) {
				System.out.println("Skipping Claim Details validation!!!");
			}
		
	}
}
