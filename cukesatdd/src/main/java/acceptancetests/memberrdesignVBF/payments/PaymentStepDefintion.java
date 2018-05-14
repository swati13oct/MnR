package acceptancetests.memberrdesignVBF.payments;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import pages.memberrdesignVBF.OneTimePaymentsPage;
import pages.memberrdesignVBF.PaymentsOverview;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.ReviewOneTimePaymentsPage;
import pages.memberrdesignVBF.TestHarness;

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
	 * @throws InterruptedException
	 */
	@And("^the user navigates to One Time Payments page$")
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
