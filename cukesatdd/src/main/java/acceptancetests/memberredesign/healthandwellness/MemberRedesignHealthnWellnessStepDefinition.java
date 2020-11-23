package acceptancetests.memberredesign.healthandwellness;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
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
	 * View Health n Wellness Global Navigation
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
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		healthnWellnessPage.validateHeaderOnDashborad();

		getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE, healthnWellnessPage);
	}

	/**
	 * Clicks on Health and Wellness Tab
	 */
	@When("^I navigate to the Health and Wellness page$")
	public void navigateToHwPg() { 
		if (MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("Health and Wellness page content won't load on lower environment, fail it to exit", false);
			return;
		}
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			System.out.println("Running with testharness, go to H&W page via link on testharness table");
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			HealthAndWellnessPage healthnWellnessPage = testHarness.navigateToHealthAndWellnessFromTestHarnessPage();
			Assert.assertTrue("PROBLEM - unable to navigate to the Health and Wellness page", healthnWellnessPage!=null);
			getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE, healthnWellnessPage);
		} else {
			AccountHomePage accountHomePage=(AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			HealthAndWellnessPage healthnWellnessPage=accountHomePage.navigateDirectToHwPag();
			healthnWellnessPage.clickHealthnWellnessTab();
			getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE, healthnWellnessPage);
		} 
	} 

	@When("^I navigate to the Health and Wellness page from Rally$")
	public void navigateToHwPgFromRally() { 
		if (MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("Health and Wellness page content won't load on lower environment, fail it to exit", false);
			return;
		}
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		HealthAndWellnessPage healthnWellnessPage = new HealthAndWellnessPage(wd);
		int index=healthnWellnessPage.validateHeaderOnDashborad();
		Assert.assertTrue("PROBLEM - unable to locate Health and Wellness option on dashboard", index!=-1);
		if (index==1) {
			System.out.println("located element: xpath=//header[@class='hide-mobile']//*[@id='sticky-nav']");
		} else if (index==2) {
			System.out.println("located element: xpath menuL1");
		} else {
			System.out.println("Located shadow root element with element index ="+index);
		}
		healthnWellnessPage.clickHealthnWellnessTab();
		getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE, healthnWellnessPage);
	}
	
	/**
	 * See health n Wellness Generic dashboard and lifestyle , learning and rewards level 2 tabs
	 */
	@And("^I should see the H&W Generic dashboard$") 
	public void I_should_see_the_H_W_Generic_dashboard_and_tabs() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.validateHnWDashboardnL2Tabs();

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

	@And("^I should see GET REWARD tile if available and be able to click it$")
	public void getRewardValidation(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String hasReward=memberAttributesMap.get("Has Reward");
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		if (hasReward.equalsIgnoreCase("true")) {
			healthnWellnessPage.validateGetReward();
		} else {
			healthnWellnessPage.validateNoGetReward();
		}
	}
	
	@And("^I should see RENEW ACTIVE tile if available and be able to click it$")
	public void getRenewActiveValidation(DataTable memberAttributes) {
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String hasRenewActive=memberAttributesMap.get("Has RenewActive");
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		if (hasRenewActive.equalsIgnoreCase("true")) {
			healthnWellnessPage.validateRenewActive(planType);
		} else {
			healthnWellnessPage.validateNoRenewActive(planType);
		}
	}

}
