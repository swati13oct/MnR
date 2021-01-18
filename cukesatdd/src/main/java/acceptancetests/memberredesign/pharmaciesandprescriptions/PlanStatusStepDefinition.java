package acceptancetests.memberredesign.pharmaciesandprescriptions;

import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.contactus.ContactUsPage;
import pages.regression.explanationofbenefits.EOBPage;
import pages.regression.healthandwellness.HealthAndWellnessPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import pages.regression.testharness.TestHarness;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 Functionality : validate the Pharmacies & Prescriptions Page content on the member site.
 */
public class PlanStatusStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}



	@Then("^I see it as preeffective member and no PP page on the navigation bar$")
	public void I_see_it_as_preeffective_member_and_no_PP_page_on_the_navigation_bar() throws Throwable {


		if (MRScenario.environment.equalsIgnoreCase("stage") & "NO".equalsIgnoreCase(MRScenario.isTestHarness))
		{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
			accountHomePage.validatePreEffectiveMessagePresent();
			accountHomePage.validateNoPPPage();
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}

		else if ((MRScenario.environment.equalsIgnoreCase("team-h")) || (MRScenario.environment.equalsIgnoreCase("stage") & "YES".equalsIgnoreCase(MRScenario.isTestHarness)))
		{
			TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			System.out.println("After login via the TestHarness validaying the element on test Harness");
			testHarnessPage.validatePreEffectiveMessagePresent();
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
		}
		else {
			System.out.println("Not verifying that preeffective message is displayed as the environment is not set to team-h or Stage");
		}

	}



	@Then("^I see it as termed member and no PP page on the navigation bar$")
	public void I_see_it_as_termed_member_and_no_PP_page_on_the_navigation_bar() throws Throwable {


		if (MRScenario.environment.equalsIgnoreCase("stage") & "NO".equalsIgnoreCase(MRScenario.isTestHarness))
		{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
			accountHomePage.validateNoPPPage();
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}

		else if ((MRScenario.environment.equalsIgnoreCase("team-h")) || (MRScenario.environment.equalsIgnoreCase("stage") & "YES".equalsIgnoreCase(MRScenario.isTestHarness)))
		{
			TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			System.out.println("After login via the TestHarness validaying the element on test Harness");
			testHarnessPage.validatePharmaciesTabNotDisplayed();
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
		}
		else {
			System.out.println("Not verifying that preeffective message is displayed as the environment is not set to team-h or Stage");
		}

	}


	@Then("^I will be sent back to the member site dashboard$")
	public void I_will_be_sent_back_to_the_member_site_dashboard() throws Throwable {

//		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
//				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
//		accountHomePage.validateDashboardURL();
//		Thread.sleep(2000);

		if (MRScenario.environment.equalsIgnoreCase("stage") & "NO".equalsIgnoreCase(MRScenario.isTestHarness))
		{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			accountHomePage.validateLoginonDashboard();
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}

	}






}