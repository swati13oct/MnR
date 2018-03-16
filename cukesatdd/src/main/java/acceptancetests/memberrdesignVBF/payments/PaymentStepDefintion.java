package acceptancetests.memberrdesignVBF.payments;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.ReviewOneTimePaymentsPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.LoginPage;
import pages.memberrdesignVBF.OneTimePaymentsPage;
import pages.memberrdesignVBF.PaymentsOverview;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;

/**
 * @author pperugu
 *
 */
public class PaymentStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 */
	@Given("^the user is on the Team-H AARP medicare site login page$")
	public void user_TeamHlogin_page() {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage THloginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^the user navigates to Team H One Time Payments page$")
	public void user_navigates_to_TeamH_one_time_payments() throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstants.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage.navigateToOneTimePaymentpage();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD, oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^the user enters details and click on continue button on One Time Payments Page for Dashboard$")
	public void user_clicks_and_navigates_to_Review_page() throws InterruptedException {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.enterInfoAndContinue();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstants.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD, reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^the user navigates Premium Payment from Rally Dashboard Page$")
	public void user_navigates_to_premium_payment_from_RallyDashboardPage_Page() throws InterruptedException {
		PaymentsOverview paymentsOverview;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			paymentsOverview = testHarness.navigateToPaymentOverview();
		} else {
			RallyDashboardPage rallyDashboardPage = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);

			paymentsOverview = rallyDashboardPage.navigateToPaymentOverview();
		}
		if (paymentsOverview != null) {
			getLoginScenario().saveBean(PageConstants.PAYMENT_OVERVIEW, paymentsOverview);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}

	}

	/***
	 * 
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@When("^the user logs in TeamH with a registered AMP with following details in AARP site$")
	public void user_logs_inTeamH(DataTable memberAttributes) throws InterruptedException {
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
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

		LoginPage THloginPage = (LoginPage) getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
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
	 * @throws InterruptedException
	 */
	@And("^User validates Premium Payment table$")
	public void user_validates_premium_payment_tale() throws InterruptedException {
		PaymentsOverview paymentsOverview = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstants.PAYMENT_OVERVIEW);

		paymentsOverview.ScrollDownAndSelectRange();
		paymentsOverview.verifyPaymentTable();
	}
}
