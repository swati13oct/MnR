package acceptancetests.memberrdesignVBF.claims;

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

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.memberrdesignVBF.ClaimDetailsPage;
import pages.memberrdesignVBF.ClaimSummarypage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.LoginPage;

public class ClaimsRedesignStepDefinition {
	@Autowired
	MRScenario loginScenario;
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
/***
 * 
 * @param memberAttributes
 * @throws InterruptedException
 */
	@Given("^I am an AARP member on the redesigned site$")
	public void i_am_an_arrp_member_on_the_member_site(DataTable memberAttributes) throws InterruptedException {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String businessType = null;
		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP")) {
			businessType = "GOVT";
		} else {
			businessType = "SHIP";
		}
		getLoginScenario().saveBean(ClaimsCommonConstants.BUSINESS_TYPE, businessType);

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				if (!memberAttributesMap.get(key).isEmpty()) {
					desiredAttributes.add(memberAttributesMap.get(key));
				}
			}
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario.getmemberRedesignVbfWithDesiredAttributes(desiredAttributes);
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
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage THloginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) THloginPage.loginWith(userName, pwd);
			if (testHarness != null) {
				getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarness);
			} else {
				Assert.fail("Login not successful...");
			}
		} else {

			RallyDashboardPage rallyDashboard = (RallyDashboardPage) THloginPage.loginWith(userName, pwd);
			if (rallyDashboard != null) {
				getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
			} else {
				Assert.fail("Login not successful...");
			}
		}
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
		String s = urlAttributesMap.get("Claim Period");
		String planType = urlAttributesMap.get("Plan Type");
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		newClaimsSummaryPage.searchClaimsByTimePeriod(planType, s);
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

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String domain = memberAttributesMap.get("Domain");

		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateEobfordifferentDomainType(domain, planType);
	}
/***
 * 
 */
	@And("^the user validates the DownloadMyData section in redesigned site$")
	public void validates_DownloadMyData_redesigned_site() {
		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateDownloadMyData();
	}

/***
 * 
 * @throws InterruptedException
 */
	@When("^I navigate to the Claim Details page in AARP site$")
	public void i_navigate_to_member_redesign_claim_details_page() throws InterruptedException {
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPage();
		if (null != newClaimDetailsPage)
			getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
		else {
			Assert.fail("Claims details page is not loaded!!!");
		}

	}

/***
 * 
 */
	@And("^I validate the Claims Table in claims details page in AARP site$")
	public void validate_claimsTable_claimsDetails_AARP() {
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimsTableInDetailsPage();
	}
/***
 * 
 */
	@And("^I validate the Claims Total in claims details page in AARP site$")
	public void validate_claims_total_AARP() {
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimsTotalInDetailsPage();
	}

}
