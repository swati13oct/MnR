package acceptancetests.memberredesign.healthandwellness;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.dashboard_deprecated.member.drugcostestimator.blayer.DrugCostEstimatorPage;
import pages.memberredesign_deprecated.bluelayer.AccountHomePage;
import pages.memberredesign_deprecated.bluelayer.HealthAndWellness;
import pages.memberredesign_deprecated.bluelayer.LoginPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.healthandwellness.HealthAndWellnessPage;
import pages.regression.testharness.TestHarness;
/**
 * Functionality : Covers step definition methods related to member redesign Health and Wellness page .
 */
public class MemberRedesignHealthnWellnessStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo : View Health n Wellness Global Navigation
	 * @throws InterruptedException
	 */
	@When("^I view the global navigation HW$")
	public void I_view_the_global_navigation() throws InterruptedException {
		if (MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("Health and Wellness page content won't load on lower environment, fail it to exit", false);
			return;
		}
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			System.out.println("Running with testharness, go to secondary page like claims then go ot H&W tab");
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.navigateToClaimsSummaryFromTestHarnessPage();
			TestHarness.checkForIPerceptionModel(testHarness.driver);
		}
		// Express the Regexp above with the code you wish you had
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		HealthAndWellnessPage healthnWellnessPage = new HealthAndWellnessPage(wd);
		healthnWellnessPage.validateHeaderOnDashborad();

		getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE, healthnWellnessPage);
	}

	/**
	 * @toDo : Clicks on Health and Wellness Tab
	 */
	@When("^then click the health and wellness tab HW$")
	public void then_click_the_health_and_wellness_tab() { 
		// Express the Regexp above with the code you wish you had
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickHealthnWellnessTab();
		HealthAndWellnessPage.checkForIPerceptionModel(healthnWellnessPage.driver);
	}

	/**
	 * @toDo : See health n Wellness Generic dashboard and lifestyle , learning and rewards level 2 tabs
	 */
	//@When("^I should see the H&W Generic dashboard and lifestyle,learning and rewards L2 tabs HW$")
	@And("^I should see the H&W Generic dashboard$") 
	public void I_should_see_the_H_W_Generic_dashboard_and_tabs() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.validateHnWDashboardnL2Tabs();

	}

	/**
	 * @toDo : Clicks on Lifestyle tab and navigate to lifestyle page
	 */
	/* tbd-remove
	@When("^then click the Lifestyle tab and I should be directed to Lifestyle Page HW$")
	public void then_click_the_Lifestyle_tab_and_I_should_be_directed_to_Lifestyle_Page() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickLifestyleTab();
		healthnWellnessPage.validateLifestylePage();

	} */

	/**
	 * @toDo : Clicks on Learning tab and navigate to learning page.
	 */
	/* tbd-remove
	@When("^then click the Learning tab and I should be directed to Learning Page HW$")
	public void then_click_the_Learning_tab_and_I_should_be_directed_to_Learning_Page() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickLearningTab();
		healthnWellnessPage.validateLearningPage();
	} 

	@When("^then click the Rewards tab and I should be directed to Rewards Page HW$")
	public void then_click_the_Rewards_tab_and_I_should_be_directed_to_Rewards_Page() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clicAndValidateRewardsPage();
	} */

	public static Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@And("^I should see GET REWARD tile if available and be able to click it$")
	public void getRewardValidation(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType=memberAttributesMap.get("Plan Type");
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("MA")) {
			healthnWellnessPage.validateGetReward();
		} else {
			healthnWellnessPage.validateNoGetReward();
		}
	}

}
