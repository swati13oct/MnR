package acceptancetests.memberredesign.healthandwellness;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
		healthnWellnessPage.validateHeaderOnDashborad();

		getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE, healthnWellnessPage);
	}

	/**
	 * Clicks on Health and Wellness Tab
	 */
	/* tbd @When("^then click the health and wellness tab HW$")
	public void then_click_the_health_and_wellness_tab() { 
		// Express the Regexp above with the code you wish you had
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickHealthnWellnessTab();
	} */
	
	/**
	 * TODO Clicks on Health and Wellness Tab
	 */
	@When("^I navigate to the Health and Wellness page$")
	public void navigateToHwPg() { 
		if (MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("Health and Wellness page content won't load on lower environment, fail it to exit", false);
			return;
		}
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			System.out.println("Running with testharness, go to secondary page like claims then go ot H&W tab");
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			HealthAndWellnessPage healthnWellnessPage = testHarness.navigateToHealthAndWellnessFromTestHarnessPage();
			Assert.assertTrue("PROBLEM - unable to navigate to the Health and Wellness page", healthnWellnessPage!=null);
			getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE, healthnWellnessPage);
		} else {
			WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			HealthAndWellnessPage healthnWellnessPage = new HealthAndWellnessPage(wd);
			healthnWellnessPage.validateHeaderOnDashborad();
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
		String cssPath=healthnWellnessPage.validateHeaderOnDashborad();
		healthnWellnessPage.clickHealthnWellnessTab(cssPath);
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
		//tbd String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
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
	
	@Given("^this microapp feature has security flag set to true on test env$")
	public void checkSecurityFlag() {
		String securityFlagXpath="//td[text()='enableSecurity']/following-sibling::td";
		String configPgUrl="https://www."+MRScenario.environment+"-medicare."+MRScenario.domain+"/UCPHealthWellness/wsConfig";
		System.out.println("Config page URL="+configPgUrl);
		MRScenario m=new MRScenario();
		WebDriver d=m.getWebDriverNew();
		d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		d.get(configPgUrl);
		try {
			WebElement e=d.findElement(By.xpath(securityFlagXpath));
			if (e.isDisplayed()) {
				System.out.println("Element '"+e.toString()+"' found!!!!");
				String value=e.getText();
				if (value.equalsIgnoreCase("false") && MRScenario.environment.toLowerCase().contains("stage")) {
					Assert.assertTrue("PROBLEM - stage environment should have security flag = true, right now it is set to "+value+", stopping all tests now", false);
				}
			} else {
				Assert.assertTrue("PROBLEM - unable to locate security flag in the config URL='"+configPgUrl+"' page, stopping all tests now", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to locate security flag in the config URL='"+configPgUrl+"' page, stopping all tests now", false);
		}
		d.quit();
	}



}
