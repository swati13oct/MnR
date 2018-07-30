package acceptancetests.memberrdesignVBF.login;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.memberrdesignVBF.BenefitsAndCoveragePage;
import pages.memberrdesignVBF.FormsAndResourcesPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import atdd.framework.MRScenario;

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
		FormsAndResourcesPage formsAndResourcesPage = null;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			if (category.contains(CommonConstants.CATEGORY_TERMIATED)) {
				formsAndResourcesPage = testHarness.navigateDirectToFnRPage();
			} else {
				benefitsAndCoveragePage = testHarness.navigateDirectToBnCPag();
			}
		} else {
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			if (category.contains(CommonConstants.CATEGORY_TERMIATED)) {
				formsAndResourcesPage = rallyDashboard.navigateDirectToFnRPage();
			} else {
				benefitsAndCoveragePage = rallyDashboard.navigateDirectToBnCPag();
			}

		}
		if (category.contains(CommonConstants.CATEGORY_TERMIATED)) {
			if (formsAndResourcesPage == null)
				Assert.fail("FnR page is not loaded");
			else
				Assert.assertTrue("FnR page is loaded", true);
		} else {
			if (benefitsAndCoveragePage == null)
				Assert.fail("BnC page is not loaded");
			else
				Assert.assertTrue("BnC page is loaded", true);
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
		else if (category.equalsIgnoreCase("ComboMAPDANDSHIP"))
			Assert.assertTrue(wd.getCurrentUrl().contains("/aarp/dashboard"));
		else if (category.equalsIgnoreCase("TerminatedFedAARP"))
			Assert.assertTrue(wd.getCurrentUrl().contains("/aarp/dashboard"));
		else if (category.equalsIgnoreCase("TerminatedFedUHC"))
			Assert.assertTrue(wd.getCurrentUrl().contains("/medicare/dashboard"));
		else {
			System.out.println("Please specifiy a specific member type ");
			Assert.fail("Please specifiy a specific member type ");
		}
	}

}
