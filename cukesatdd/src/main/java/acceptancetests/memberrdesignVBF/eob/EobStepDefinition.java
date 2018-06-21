package acceptancetests.memberrdesignVBF.eob;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.EOBPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class EobStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Then("^the user navigates to EOB page$")
	public void the_user_navigates_to_EOB_Page() {
		EOBPage eobPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			eobPage = testHarness.navigateToEOBPage();
		} else {
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			eobPage = rallyDashboard.navigateToEOBPage();
		}
		if (null != eobPage) {
			getLoginScenario().saveBean(PageConstants.EOB_Page, eobPage);
		} else {
			Assert.fail("EOB page is not displayed");
		}
	}

	/***
	 * 
	 */
	@Then("^the user validates EOB statments displayed$")
	public void the_user_validates_EOB_statments_displayed() {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateEachEOBonUI();
	}

	/***
	 * 
	 */
	@Then("^the user validates site leaving pop up$")
	public void user_validates_site_leaving_poup() {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateSiteLeaveingPopUP();
	}

	/***
	 * 
	 * @param givenAttributes
	 */
	@And("^the user slects the desired date range$")
	public void user_selects_date_range(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String dateRange = memberAttributesMap.get("Date Range");
		String planType = memberAttributesMap.get("Plan Type");
		String eobTypeData = memberAttributesMap.get("EOB Type");
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.selectDateRange(dateRange, planType, eobTypeData);
	}

	/***
	 * 
	 */
	@Then("^the user validates EOB count$")
	public void user_validated_EOB_Count() {

		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateEOBStatements();

	}

}
