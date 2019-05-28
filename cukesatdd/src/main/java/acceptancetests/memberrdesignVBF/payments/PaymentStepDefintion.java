package acceptancetests.memberrdesignVBF.payments;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.OneTimePaymentsPage;
import pages.memberrdesignVBF.PaymentsOverview;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.ReviewOneTimePaymentsPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.ConfirmOneTimePaymentPage;
import pages.memberrdesignVBF.CreditCardUPGPage;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

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
	
	@When("^user selects other amount and enters \"([^\"]*)\" and selects credit card and click on Next button$")
	public void user_selects_other_amount_and_enters_and_selects_credit_card_and_click_on_Next_button(
			String otherAmountvalue) throws Throwable {
		OneTimePaymentsPage oneTimePaymentPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD);
		oneTimePaymentPage.selectAndEnterAmount(otherAmountvalue);
		oneTimePaymentPage.selectCreditCardOption();
		CreditCardUPGPage creditCardPaymentPage = oneTimePaymentPage.clickOnNextButton();
		if (creditCardPaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.Credit_Card_Payments_Page, creditCardPaymentPage);
			System.out.println("User is on UPG Credit cards page");

		}
		else {
			Assert.fail("User is not on UPG Credit cards page");
		}
	}
	
	@Then("^user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed$")
	public void user_Navigates_to_UPG_payment_page_and_Enter_Mandatory_fields_and_click_on_Proceed(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		CreditCardUPGPage creditCardPaymentPage = (CreditCardUPGPage) getLoginScenario()
				.getBean(PageConstants.Credit_Card_Payments_Page);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = creditCardPaymentPage.EnterFiledsOnCC(memberAttributesMap);
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstants.Review_OneTime_Payments_Page, reviewOneTimePaymentsPage);
			System.out.println("User is on Review One time payments page");

		}
	}
	
	@Then("^user navigates to payment overview screen and selects agreements and click on Make one time payemnt$")
	public void user_navigates_to_payment_overview_screen_and_selects_agreements_and_click_on_Make_one_time_payemnt()
			throws Throwable {
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstants.Review_OneTime_Payments_Page);
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = reviewOneTimePaymentsPage
				.selectAgreeAndClickOnMakePayment();
		if (confirmOneTimePaymentPage != null || (null == confirmOneTimePaymentPage && ReviewOneTimePaymentsPage.isBusinessValidation)) {
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_PAGE, confirmOneTimePaymentPage);
			System.out.println("User is on Review One time payments page");
		}
		else if(null == confirmOneTimePaymentPage && (!ReviewOneTimePaymentsPage.isBusinessValidation)) {
			System.out.println("Error in navigation to Confirmation page!!!");
			Assert.fail("Error in navigation to Confirmation page!!!");
		}
	}
	
	@Then("^User navigates to payment confirmation page for CC flow$")
	public void user_navigates_to_payment_confirmation_page_for_CC_flow() throws Throwable {
		if(!ReviewOneTimePaymentsPage.isBusinessValidation) {
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENT_PAGE);
		confirmOneTimePaymentPage.OneTimeCCverification();
		}
		else {
			System.out.println("Skipping confirmation page validation due to business validation message!!!");
		}
	}
}
