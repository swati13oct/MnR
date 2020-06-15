package acceptancetests.memberrdesignVBF.healthandwellness;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.memberrdesignVBF.HealthAndWellness;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;

public class MemberHealthnWellnessStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @throws InterruptedException
	 * *
	 * 
	 */
	@When("^then click the health and wellness tab$")
	public void then_click_the_health_and_wellness_tab() throws InterruptedException {
		HealthAndWellness healthAndWellness;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			healthAndWellness = testHarness.clickHealthnWellnessTab();
		} else {
			RallyDashboardPage rallyDashboardPage = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			healthAndWellness = rallyDashboardPage.clickHealthnWellnessTab();
		}
		if (healthAndWellness != null) {
			getLoginScenario().saveBean(PageConstants.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE, healthAndWellness);
		}
		if (healthAndWellness == null) {
			System.out.println(" Variable is NULL!");
			Assert.fail();
		}
	}

	/***
	 * 
	 */
	@When("^I should see the H&W Generic dashboard and lifestyle,learning and rewards$")
	public void I_should_see_the_H_W_Generic_dashboard_and_tabs() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellness healthnWellnessPage = (HealthAndWellness) getLoginScenario()
				.getBean(PageConstants.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.validateHnWDashboard();

	}

	/***
	 * 
	 */
	@When("^then click the Lifestyle tab and I should be directed to Lifestyle Page$")
	public void then_click_the_Lifestyle_tab_and_I_should_be_directed_to_Lifestyle_Page() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellness healthnWellnessPage = (HealthAndWellness) getLoginScenario()
				.getBean(PageConstants.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickLifestyleTab();
		healthnWellnessPage.validateLifestylePage();

	}

	/***
	 * 
	 */
	@When("^then click the Learning tab and I should be directed to Learning Page$")
	public void then_click_the_Learning_tab_and_I_should_be_directed_to_Learning_Page() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellness healthnWellnessPage = (HealthAndWellness) getLoginScenario()
				.getBean(PageConstants.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickLearningTab();
		healthnWellnessPage.validateLearningPage();

	}
	@When("^user then click again on health and wellness tab$")
	public void user_then_click_again_health_and_wellness_tab() throws InterruptedException {
		HealthAndWellness healthAndWellness;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			healthAndWellness = testHarness.clickHealthnWellnessTab();
		} else {
			RallyDashboardPage rallyDashboardPage = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			healthAndWellness = rallyDashboardPage.clickHealthnWellnessSecondaryTab();
		}
		if (healthAndWellness != null) {
			getLoginScenario().saveBean(PageConstants.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE, healthAndWellness);
		}
		if (healthAndWellness == null) {
			System.out.println(" Variable is NULL!");
			Assert.fail();
		}
	}
	
	
	/***
	 * 
	 */
	@Then("^I should see the H&W Generic new dashboard$")
	public void I_should_see_the_H_W_Generic_new_dashboard() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellness healthnWellnessPage = (HealthAndWellness) getLoginScenario()
				.getBean(PageConstants.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.validateHnWNewDashboard();

	}
}
