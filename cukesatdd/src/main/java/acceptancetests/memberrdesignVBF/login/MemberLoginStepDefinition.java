package acceptancetests.memberrdesignVBF.login;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.BenefitsAndCoveragePage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class MemberLoginStepDefinition {
	@Autowired
	MRScenario loginScenario;
	String category = null;
	WebDriver wd = null;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@Then("^User should be able to validate Dashboard elements$")
	public void user_validate_dashboard_elements() throws InterruptedException {
		category = CommonStepDefinition.getMemberAttributeMap().get("Member Type");
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			testHarness.validateTestHarnessElements(category);
		} else {
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			validateURLNavigation();
			rallyDashboard.validateDashboardElements(category);
		}
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^User should be ale to navigate to secondary page$")
	public void user_validate_seconday_page_navigation() throws InterruptedException {
		BenefitsAndCoveragePage benefitsAndCoveragePage = null;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			benefitsAndCoveragePage = testHarness.navigateDirectToBnCPag();
		} else {
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			benefitsAndCoveragePage = rallyDashboard.navigateDirectToBnCPag();
		}

		if (benefitsAndCoveragePage == null) {
			Assert.fail("BnC page is not loaded");
		}
	}

	/***
	 * 
	 */
	public void validateURLNavigation() {
		category = CommonStepDefinition.getMemberAttributeMap().get("Member Type");
		System.out.println("Current category: " + category);
		wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		System.out.println("Current URL: " + wd.getCurrentUrl());
		if (category.equalsIgnoreCase("UhcMapdInd"))
			Assert.assertTrue(wd.getCurrentUrl().contains("/medicare/dashboard"));
		else if (category.equalsIgnoreCase("AARPMapdInd"))
			Assert.assertTrue(wd.getCurrentUrl().contains("/aarp/dashboard"));
		else if (category.equalsIgnoreCase("GroupRetireeMapd"))
			Assert.assertTrue(wd.getCurrentUrl().contains("/retiree/dashboard"));
		else if (category.equalsIgnoreCase("Ship"))
			Assert.assertTrue(wd.getCurrentUrl().contains("/aarp/dashboard"));
		else if (category.equalsIgnoreCase("PCP"))
			Assert.assertTrue(wd.getCurrentUrl().contains("/pcp/dashboard"));
		else if (category.equalsIgnoreCase("Medica"))
			Assert.assertTrue(wd.getCurrentUrl().contains("/medica/dashboard"));
		else {
			System.out.println("Please specifiy a specific member type ");
			Assert.fail("Please specifiy a specific member type ");
		}
	}

}
