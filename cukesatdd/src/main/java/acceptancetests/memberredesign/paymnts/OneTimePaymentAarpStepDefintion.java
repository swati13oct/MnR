package acceptancetests.memberredesign.paymnts;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member_deprecated.bluelayer.DashboardPage;
import pages.member_deprecated.redesign.NewLoginPage;
import pages.member_deprecated.ulayer.LoginPage;
import pages.member_deprecated.ulayer.OneTimePaymentPageSubmitted;
import pages.member_deprecated.ulayer.OneTimePaymentsPage;
import pages.member_deprecated.ulayer.PaymentsOverview;
import pages.member_deprecated.ulayer.RallyDashboard;
import pages.member_deprecated.ulayer.ReviewOneTimePaymentsPage;
import pages.member_deprecated.ulayer.TeamCLoginUlayerPayments;
import pages.member_deprecated.ulayer.TeamHLoginUlayer;
import pages.regression.testharness.*;
import pages.regression.IDCardPage.IDCardPage;
import pages.regression.accounthomepage.AccountHomePage;
//import pages.regression.payments.AccountHomePage;
import pages.regression.payments.ConfirmOneTimePaymentPage;
import pages.regression.payments.CreditCardUPGPage;
import pages.regression.payments.OneTimePaymentPage;
import pages.regression.payments.OneTimePaymentSuccessPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.payments.PaymentsFormPage;
import pages.regression.payments.RecurringConfirmationPage;
import pages.regression.payments.ReviewAutomaticPage;
import pages.regression.payments.ReviewOneTimePaymentPage;
import pages.regression.payments.SetUpRecurringPage;
import pages.regression.payments.UpdateConfirmationPage;
import pages.regression.payments.UpdateRecurringPage;
import pages.regression.payments.UpdateReviewPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author pperugu
 * 
 */
public class OneTimePaymentAarpStepDefintion {

	@Autowired
	MRScenario loginScenario;
	
	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP with for payments flow$")
	public void registered_AMP_with_attribute_payments(DataTable memberAttributes) throws InterruptedException {
		// get the required parameters from the feature files
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String password = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			password = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + password);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, password);
			getLoginScenario().saveBean(LoginCommonConstants.CATOGERY, category);
		}
		NewLoginPage newloginpage = new NewLoginPage(wd);
		// NewLoginPage paymenthistory = (NewLoginPage).loginWith(userName,
		// password);
		DashboardPage dashboardpage = (DashboardPage) newloginpage.loginWith(userName, password);
		// DashboardPage.loginWith(userName, password);

		if (dashboardpage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARDPAGE, dashboardpage);
		}

	}

	@Then("^the user navigates to payment history$")
	public void user_views_payment_history() throws InterruptedException {
		AccountHomePage accountHomePage;	

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			PaymentHistoryPage paymentHistoryPage = testHarness.navigateToPaymentFromTestHarnessPage(); 
			if (paymentHistoryPage != null) {
				getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
				System.out.println("user is on payments page");
			} 
		}else {

			accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			PaymentHistoryPage paymentHistoryPage = accountHomePage.navigateToPaymentHistoryPage();
			if (paymentHistoryPage != null) {
				getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
				System.out.println("user is on payments page");
			}
		}

	}

	@And("^the user clicks on One Time Payment button$")
	public void click_on_OneTimePayment_btn() throws InterruptedException {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		OneTimePaymentPage oneTimePayment = paymentHistoryPage.OTPbtn();

		if (oneTimePayment != null) {
			getLoginScenario().saveBean(PageConstants.One_Time_Payments_Page, oneTimePayment);
			System.out.println("user is on one time payment page");
		}

	}

/*	@When("^the user navigates to Recurring payment history$")
	public void user_views_Recurring_payment_history() throws InterruptedException {
		pages.regression.accounthomepage.AccountHomePage AHPage = (pages.regression.accounthomepage.AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		AHPage = AHPage.navigateToAutoPaymentHistoryPage();

		if (AHPage != null) {
			getLoginScenario().saveBean(PageConstants.DashPage, AHPage);
			System.out.println("User is on Recurring Payment History");
		}

	}*/

	@When("^the user navigates to Ship Recurring payment history$")
	public void user_Ship_Recurring_payment_history() throws InterruptedException {
		pages.regression.accounthomepage.AccountHomePage AHPage = (pages.regression.accounthomepage.AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		AHPage = AHPage.navigateToSHIPAutoPaymentHistoryPage();

		if (AHPage != null) {
			getLoginScenario().saveBean(PageConstants.DashPage, AHPage);
			System.out.println("User is on Recurring Payment History");
		}

	}

	
	@When("^the user navigates to Ship tab and validates the amount$")
	public void ship_tab_amount_validation() throws InterruptedException {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		
		    paymentHistoryPage.navigateToSHIPTab();
			getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
				 
	}

	@Then("^User Scrolls down and validate that Payment History Section and scrolls up$")
	public void Validate_History_Payment() throws InterruptedException {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		
		paymentHistoryPage.scrollDownAndUp();
		
		if (paymentHistoryPage != null) {
			getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
			System.out.println("user has scrolled up");
		}
	}

	@Then("^User Scrolls down to validate Payment History Section$")
	public void Validate_History_Payment_section() throws InterruptedException {
		pages.regression.accounthomepage.AccountHomePage AHPage = (pages.regression.accounthomepage.AccountHomePage) getLoginScenario()
				.getBean(PageConstants.DashPage);
		PaymentHistoryPage paymentHistoryPage = AHPage.validtaePaymentHistorySection();
		System.out.println("found the value");
		if (paymentHistoryPage != null) {
			getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
			System.out.println("user has scrolled up");
		}
	}

/*	@And("^the user clicks on Make One Time Payment button$")
	public void click_on_OTP_btn() throws InterruptedException {

		PaymentHistoryPage paymenthistory = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		OneTimePaymentPage oneTimePayment = paymenthistory.OTPbtn();

		if (oneTimePayment != null) {
			getLoginScenario().saveBean(PageConstants.One_Time_Payments_Page, oneTimePayment);
			System.out.println("user is on one time payment page");
		}

	}*/

	@And("^the user clicks on Edit Automatic Payment button$")
	public void click_on_Recurring_btn() {
		PaymentHistoryPage paymenthistory = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		OneTimePaymentPage oneTimePayment = paymenthistory.AutoPay();

		if (oneTimePayment != null) {
			getLoginScenario().saveBean(PageConstants.One_Time_Payments_Page, oneTimePayment);
			System.out.println("user is on one time payment page");
		}

	}

	@And("^the user clicks on New flow Edit Automatic Payment button$")
	public void click_on_Recurring_Payment_btn() {
		PaymentHistoryPage paymenthistory = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		PaymentHistoryPage PHoneTimePayment = paymenthistory.AutoPayNew();

		if (PHoneTimePayment != null) {
			getLoginScenario().saveBean(PageConstants.NEW_CC_BUTTON, PHoneTimePayment);
			System.out.println("user is on one time payment page");
		}

	}

	@And("^the user clicks on New flow Edit CC Automatic Payment button$")
	public void click_on_Recurring_Payment_btn_CC() {
		PaymentHistoryPage paymenthistory = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		PaymentHistoryPage PHoneTimePayment = paymenthistory.AutoPayNewCC();
		if (PHoneTimePayment != null) {
			getLoginScenario().saveBean(PageConstants.NEW_CC_BUTTON, PHoneTimePayment);
			System.out.println("user is on one time payment page");
		}

	}

	@And("^the user clicks on New flow OneTime Payment button$")
	public void click_on_OneTime_Payment_btn() {
		PaymentHistoryPage paymenthistory = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		PaymentHistoryPage PHoneTimePayment = paymenthistory.OneTimePayNew();

		if (PHoneTimePayment != null) {
			getLoginScenario().saveBean(PageConstants.NEW_CC_BUTTON, PHoneTimePayment);
			System.out.println("user is on one time payment page");
		}

	}

	
	@And("^the user selects the Setup AutoCreditCard option on New page$")
	public void click_on_SetupCCA_Auto_Payment_btn() {
		PaymentHistoryPage paymenthistory = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.NEW_CC_BUTTON);
		OneTimePaymentPage oneTimePayment = paymenthistory.SetUpCCbtn();

		if (oneTimePayment != null) {
			getLoginScenario().saveBean(PageConstants.One_Time_Payments_Page, oneTimePayment);
			System.out.println("user is on Automatic payment page");
		}
	}

	@And("^the user selects the Checking account option on New page OTP$")
	public void click_on_Checking_account_Payment_btn_OTP() {
		PaymentHistoryPage paymenthistory = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.NEW_CC_BUTTON);
		OneTimePaymentPage oneTimePayment = paymenthistory.CheckingAccountbtnOTP();

		if (oneTimePayment != null) {
			getLoginScenario().saveBean(PageConstants.One_Time_Payments_Page, oneTimePayment);

		}

	}

	@And("^the user validates the Payment Summary option on New page OTP$")
	public void validate_Payment_Summary_Payment_on_OTP() {
		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.One_Time_Payments_Page);
		oneTimePaymentPage.BalanceSummaryValidation();

		if (oneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.One_Time_Payments_Page, oneTimePaymentPage);
			
		}

	}

	@And("^the user clicks on cancel button in One time EFT or Recurring EFT flow$")
	public void click_on_Cancel_payment_btn() {
		
		PaymentsFormPage paymentsFormPage = (PaymentsFormPage) getLoginScenario()
				.getBean(PageConstants.Payments_Form_Page);
		         paymentsFormPage.clickonCancelButton();
		
		}
			
	@And("^the user clicks on Authorize button to validate error message$")
	public void click_on_Authorize_button() {
		
		PaymentsFormPage paymentsFormPage = (PaymentsFormPage) getLoginScenario()
				.getBean(PageConstants.Payments_Form_Page);
		paymentsFormPage.ErrorMessageValidation();
		
	}

	@And("^the user clicks on MemAuth Edit Automatic Payment button$")
	public void click_on_MemAuth_Recurring_btn() {
		PaymentHistoryPage paymenthistory = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		OneTimePaymentPage oneTimePayment = paymenthistory.MemAuthAutoPay();

		if (oneTimePayment != null) {
			getLoginScenario().saveBean(PageConstants.One_Time_Payments_Page, oneTimePayment);
			System.out.println("user is not able to click autopay");
		} else {
			System.out.println("user is able to click autopay");
		}

	}

	@And("^the user makes one time payment and navigate futher$")
	public void makes_one_time_payment_aarp(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		OneTimePaymentPage oneTimePayment = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.One_Time_Payments_Page);
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = oneTimePayment.enterPaymentDetails(memberAttributesMap);
		if (confirmOneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD, confirmOneTimePaymentPage);
			System.out.println("Payment details entered and moved successfully to next page");
		} else {
			System.out.println("Object issue - unable to obtain the confirmOneTimePaymentPage");
		}
	}

	@And("^the user makes one time payment in new flow and navigate further$")
	public void makes_one_time_payment_aarp_new_flow(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		OneTimePaymentPage oneTimePayment = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.One_Time_Payments_Page);
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = oneTimePayment
				.enterNewPagePaymentDetails(memberAttributesMap);
		if (confirmOneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD, confirmOneTimePaymentPage);
			System.out.println("Payment details entered and moved successfully to next page");
		} else {
			System.out.println("Object issue - unable to obtain the confirmOneTimePaymentPage");
		}
	}

	@And("^the user makes Auto payment in CC flow and navigate further$")
	public void makes_Auto_payment_CC_flow(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		OneTimePaymentPage oneTimePayment = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.One_Time_Payments_Page);
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = oneTimePayment.enterNewPageCCDetails(memberAttributesMap);
		if (confirmOneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD, confirmOneTimePaymentPage);
			System.out.println("Payment CC details entered and moved successfully to next page");
		} else {
			System.out.println("Object issue - unable to obtain the confirmOneTimePaymentPage");
		}
	}

	@And("^the user makes auto payment in AARP site$")
	public void makes_auto_payment_aarp(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		OneTimePaymentPage oneTimePayment = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.One_Time_Payments_Page);
		ConfirmOneTimePaymentPage confirmAutoPaymentPaymentPage = oneTimePayment
				.enterAutoPaymentDetails(memberAttributesMap);

		if (confirmAutoPaymentPaymentPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					confirmAutoPaymentPaymentPage);
			System.out.println("Payment details entered and moved successfully to next page");
		} else {
			System.out.println("Object issue - unable to obtain the confirmAutoPaymentPaymentPage");
		}
	}

	@And("^the user confirms the payment in AARP site$")
	public void confirmspayment_uhc() throws InterruptedException {
		ConfirmOneTimePaymentPage confirmOneTimePaymentsuccesspage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		ConfirmOneTimePaymentPage oneTimePaymentSuccessPage = confirmOneTimePaymentsuccesspage.confirmsAutoPayment();
		if (oneTimePaymentSuccessPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENT_SUCCESS_PAGE, oneTimePaymentSuccessPage);
			Assert.assertTrue(true);
		} else
			System.out.println("Encountered More than one Payment per Business day error");
	}

	@And("^the user confirms the Autopayment in UHC site$")
	public void confirms_payment_uhc() throws InterruptedException {

		Thread.sleep(2000);
		ConfirmOneTimePaymentPage confirmOneTimePaymentsuccesspage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);

		ConfirmOneTimePaymentPage oneTimePaymentSuccessPage = confirmOneTimePaymentsuccesspage.confirmsAutoPayment();

		if (oneTimePaymentSuccessPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENT_SUCCESS_PAGE, oneTimePaymentSuccessPage);
			Assert.assertTrue(true);
		} else
			System.out.println("Encountered More than one Payment per Business day error");
	}

	@And("^the user confirms the New flow OneTimePayment in UHC site$")
	public void confirms_One_time_payment_uhc() throws InterruptedException {

		Thread.sleep(2000);
		ConfirmOneTimePaymentPage confirmOneTimePaymentsuccesspage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);

		ConfirmOneTimePaymentPage oneTimePaymentSuccessPage = confirmOneTimePaymentsuccesspage.confirmsNewOTPPayment();

		if (oneTimePaymentSuccessPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENT_SUCCESS_PAGE, oneTimePaymentSuccessPage);
			Assert.assertTrue(true);
		} else
			System.out.println("Encountered More than one Payment per Business day error");
	}

	@And("^the user is displayed with an error message that he is not authorized$")
	public void errormessagedisplayed_unauthorized() throws InterruptedException {
		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENT_PAGE);
		oneTimePaymentPage.validateErrorMessageUnauthorized();
			}

	
	@And("^the user is displayed with an error message on Edit Recurring EFT Review that he is not authorized$")
	public void errormessagedisplayedEditEFT_unauthorized() throws InterruptedException {
		UpdateReviewPage updateReviewPage = (UpdateReviewPage) getLoginScenario()
				.getBean(PageConstants.Update_Review_Page);
		updateReviewPage.validateErrorMessageUnauthorized();
			}
	
	
	@And("^the user confirms the AutoPay Disabled for Memauth$")
	public void confirms_payment_DisableButton() throws InterruptedException {
		ConfirmOneTimePaymentPage confirmOneTimePaymentsuccesspage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);

		ConfirmOneTimePaymentPage oneTimePaymentSuccessPage = confirmOneTimePaymentsuccesspage
				.ValidateAutoPaymentButton();

		if (oneTimePaymentSuccessPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENT_SUCCESS_PAGE, oneTimePaymentSuccessPage);
			Assert.assertTrue(true);
		} else
			System.out.println("Issue with Button enablement");
	}

	@And("^the user moves to Go to Payment History Page button$")
	public void Go_toPayment_History_page()  {
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		
		PaymentHistoryPage paymentHistoryPage = confirmOneTimePaymentPage.ScrollDownToBackButton();
			
			if (paymentHistoryPage != null) {
			getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
			System.out.println("User is on Payment History Page");
		}
	}

	@And("^the user confirms the values in AARP site$")
	public void makes_one_time_payment_required_details() {
		ConfirmOneTimePaymentPage confirmOneTimePayPage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.Review_OneTime_Page);

		confirmOneTimePayPage.confirmsPayment();
		if (confirmOneTimePayPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENT_SUCCESS_PAGE, confirmOneTimePayPage);
			Assert.assertTrue(true);
		}

	}

	@Then("^the user validates the One Time Payment Submitted successfull page$")
	public void Payment_success_page() throws InterruptedException {
		ReviewOneTimePaymentsPage onetimePaymentsSuccessPage = (ReviewOneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENT_SUCCESS_PAGE);
		ReviewOneTimePaymentsPage OneTimePaymentSubmittedValidation = onetimePaymentsSuccessPage
				.validateOTPSubmittedPageValues();
		if (OneTimePaymentSubmittedValidation != null) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("One Time Payments Submitted dashboard page not found");
		}
	}

	@And("^the user makes one time payment in AARP site by entering required details$")
	public void makes_one_time_payment_required_details(DataTable accountAttributes) {
		List<DataTableRow> accountAttributesRow = accountAttributes.getGherkinRows();
		Map<String, String> accountAttributessMap = new HashMap<String, String>();

		for (int i = 0; i < accountAttributesRow.size(); i++) {
			accountAttributessMap.put(accountAttributesRow.get(i).getCells().get(0),
					accountAttributesRow.get(i).getCells().get(1));
		}

		System.out.println("accountAttributessMap.." + accountAttributessMap);

		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage
				.enterAllPaymentDetails(accountAttributessMap);
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD, reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}

	@Then("^the user validates the payment successful page$")
	public void user_validates_premium_payments_details() {
		OneTimePaymentSuccessPage oneTimePaymentSuccessPage = (OneTimePaymentSuccessPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENT_SUCCESS_PAGE);

		JSONObject oneTimePaymentSuccessActualJson = (JSONObject) getLoginScenario()
				.getBean(PaymentCommonConstants.ONE_TIME_PAYMENT_SUCCESS_ACTUAL);
		JSONObject oneTimePaymentSuccessExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PaymentCommonConstants.ONE_TIME_PAYMENT_SUCCESS_EXPECTED);

		try {
			JSONAssert.assertEquals(oneTimePaymentSuccessExpectedJson, oneTimePaymentSuccessActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		oneTimePaymentSuccessPage.logOut();
	}

	@Given("^the user is on the AARP medicare site login page$")
	public void user_login_page() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstantsMnR.LOGIN_PAGE, loginPage);
	}

	@Given("^the user is on the Team-H AARP medicare site login page$")
	public void user_TeamHlogin_page() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		TeamHLoginUlayer THloginPage = new TeamHLoginUlayer(wd);
		getLoginScenario().saveBean(PageConstantsMnR.LOGIN_PAGE, THloginPage);
	}

	/**
	 * @todo : User is taken to Stage login page
	 */
	@Given("^TimeStampTheSpartans the user is on the Team-H AARP medicare site login page$")
	public void TimeStampTheSpartans_user_TeamHlogin_page() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		TeamHLoginUlayer THloginPage = new TeamHLoginUlayer(wd);
		getLoginScenario().saveBean(PageConstantsMnR.LOGIN_PAGE, THloginPage);
	}

	@Given("^the user is on the Team-C AARP medicare site login page$")
	public void user_TeamClogin_page() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		TeamCLoginUlayerPayments THloginPage = new TeamCLoginUlayerPayments(wd);
		getLoginScenario().saveBean(PageConstantsMnR.LOGIN_PAGE, THloginPage);
	}

	@Given("^the user is on the AARP medicare site login page and has already done one time payment for the day$")
	public void user_Payment_done() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstantsMnR.LOGIN_PAGE, loginPage);

		wd.manage().deleteAllCookies();
		System.out.println("Cookie cleared");
	}

	@When("^the user logs in with a registered AMP with following details in AARP site$")
	public void user_logs_in(DataTable memberAttributes) {
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

		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);

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

		LoginPage loginPage = (LoginPage) getLoginScenario().getBean(PageConstantsMnR.LOGIN_PAGE);
		pages.regression.accounthomepage.AccountHomePage accountHomePage = (AccountHomePage) loginPage
				.loginWith(userName, pwd);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
			Assert.assertTrue(true);
			JSONObject accountHomeActualJson = accountHomePage.accountHomeJson;
			getLoginScenario().saveBean(LoginCommonConstants.ACCOUNT_HOME_ACTUAL, accountHomeActualJson);

			/* Get expected data */
			Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
			JSONObject accountHomeExpectedJson = accountHomePage.getExpectedData(expectedDataMap);
			getLoginScenario().saveBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED, accountHomeExpectedJson);

		}

	}

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

		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);

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

		TeamHLoginUlayer loginPage = (TeamHLoginUlayer) getLoginScenario().getBean(PageConstantsMnR.LOGIN_PAGE);
		// TestHarness TestHarn = (TestHarness) loginPage.loginWith(userName,
		// pwd);
		// AccountHomePage accountHomePage = (AccountHomePage)
		// loginPage.loginWith(userName, pwd);

		RallyDashboard RallyDB = (RallyDashboard) loginPage.loginWith(userName, pwd);

		if (RallyDB != null) {
			getLoginScenario().saveBean(PageConstantsMnR.Rally_Dashboard, RallyDB);
			Assert.assertTrue(true);
			/*
			 * JSONObject accountHomeActualJson = TestHarn.accountHomeJson;
			 * getLoginScenario().saveBean(
			 * LoginCommonConstants.ACCOUNT_HOME_ACTUAL, accountHomeActualJson);
			 */

			/*
			 * Get expected data Map<String, JSONObject> expectedDataMap =
			 * loginScenario .getExpectedJson(userName); JSONObject
			 * accountHomeExpectedJson = accountHomePage
			 * .getExpectedData(expectedDataMap);
			 * getLoginScenario().saveBean(LoginCommonConstants
			 * .ACCOUNT_HOME_EXPECTED, accountHomeExpectedJson);
			 */

		}

	}

	/**
	 * @todo : User logs in with the data from table and reached to Home page
	 */
	@When("^TimeStampTheSpartans the user logs in TeamH with a registered AMP with following details in AARP site$")
	public void TimeStampTheSpartans_user_logs_inTeamH(DataTable memberAttributes) throws InterruptedException {
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

		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);

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

		TeamHLoginUlayer loginPage = (TeamHLoginUlayer) getLoginScenario().getBean(PageConstantsMnR.LOGIN_PAGE);
		// TestHarness TestHarn = (TestHarness) loginPage.loginWith(userName,
		// pwd);
		// AccountHomePage accountHomePage = (AccountHomePage)
		// loginPage.loginWith(userName, pwd);

		RallyDashboard RallyDB = (RallyDashboard) loginPage.loginWith(userName, pwd);

		if (RallyDB != null) {
			getLoginScenario().saveBean(PageConstantsMnR.Rally_Dashboard, RallyDB);
			Assert.assertTrue(true);
			/*
			 * JSONObject accountHomeActualJson = TestHarn.accountHomeJson;
			 * getLoginScenario().saveBean(
			 * LoginCommonConstants.ACCOUNT_HOME_ACTUAL, accountHomeActualJson);
			 */

			/*
			 * Get expected data Map<String, JSONObject> expectedDataMap =
			 * loginScenario .getExpectedJson(userName); JSONObject
			 * accountHomeExpectedJson = accountHomePage
			 * .getExpectedData(expectedDataMap);
			 * getLoginScenario().saveBean(LoginCommonConstants
			 * .ACCOUNT_HOME_EXPECTED, accountHomeExpectedJson);
			 */

		}

	}

	@When("^the user logs in TeamC with a registered AMP with following details in AARP site$")
	public void user_logs_inTeamC(DataTable memberAttributes) throws InterruptedException {
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

		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);

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

		TeamCLoginUlayerPayments loginPage = (TeamCLoginUlayerPayments) getLoginScenario()
				.getBean(PageConstantsMnR.LOGIN_PAGE);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		Thread.sleep(25000);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
			/*
			 * Assert.assertTrue(true); JSONObject accountHomeActualJson =
			 * accountHomePage.accountHomeJson;
			 */

		}

	}

	@And("^the user navigates to PaymentOverview Page$")
	public void user_navigates_to_PaymentOverview_Page() throws InterruptedException {
		TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
		PaymentHistoryPage paymentsHistoryPage = testHarness.navigateToPaymentOverview();
		if (paymentsHistoryPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_HISTORY_PAGE, paymentsHistoryPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}

	}

	@And("^the user navigates to Stage PaymentOverview Page$")
	public void user_navigates_to_TeamHPaymentOverview_Page() throws InterruptedException {
		// TestHarness testHarness =
		// (TestHarness)getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
		Thread.sleep(20000);
		RallyDashboard RDB = (RallyDashboard) getLoginScenario().getBean(PageConstantsMnR.Rally_Dashboard);
		PaymentsOverview paymentsOverview = RDB.navigateToPaymentOverview();
		Thread.sleep(2000);
		if (paymentsOverview != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_OVERVIEW, paymentsOverview);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}

	}

	/**
	 * @todo : User clicks on payment option in global header and is taken to
	 *       paymnet overview page
	 */
	@And("^TimeStampTheSpartans the user navigates to Stage PaymentOverview Page$")
	public void TimeStampTheSpartans_user_navigates_to_TeamHPaymentOverview_Page() throws InterruptedException {
		// TestHarness testHarness =
		// (TestHarness)getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
		Thread.sleep(20000);
		RallyDashboard RDB = (RallyDashboard) getLoginScenario().getBean(PageConstantsMnR.Rally_Dashboard);
		PaymentsOverview paymentsOverview = RDB.navigateToPaymentOverview();
		Thread.sleep(2000);
		if (paymentsOverview != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_OVERVIEW, paymentsOverview);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}

	}

	@And("^the user navigates to TeamCPaymentOverview Page$")
	public void user_navigates_to_TeamCPaymentOverview_Page() {
		TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
		PaymentHistoryPage paymentHistoryPage = testHarness.navigateToTeamCPaymentOverview();
		if (paymentHistoryPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_HISTORY_PAGE, paymentHistoryPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}

	}

	/*
	 * @And("^the user navigates to Team H One Time Payments page$") public void
	 * user_navigates_to_TeamH_one_time_payments() throws InterruptedException {
	 * PaymentsOverview accountHomePage =
	 * (PaymentsOverview)getLoginScenario().getBean
	 * (PageConstantsMnR.PAYMENT_OVERVIEW); OneTimePaymentsPage
	 * oneTimePaymentsPage = accountHomePage.navigateToOneTimePaymentpage();
	 * if(oneTimePaymentsPage!= null){
	 * getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD,
	 * oneTimePaymentsPage); Assert.assertTrue(true); } else { Assert.fail(
	 * "one time payments dashboard page not found"); }
	 * 
	 * }
	 */

	@And("^user lands on payment overview page validates the tabs for combo members$")
	public void user_validates_Tabs() throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage.navigateToOneTimePaymentpage();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD, oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	/**
	 * @todo : user validate payments overview for combo members
	 */
	@And("^TimeStampTheSpartans user lands on payment overview page validates the tabs for combo members$")
	public void TimeStampTheSpartans_user_validates_Tabs() throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage.navigateToOneTimePaymentpage();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD, oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	@And("^user unchecks paid and unpaid checkbox and validates the result$")
	public void user_validates_paid_unpaid_results() throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		PaymentsOverview oneTimePaymentsPage = accountHomePage.UnselectPaidUnpaidCheck();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD, oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("issue with paid unpaid checkbox");
		}

	}

	/**
	 * @todo : User chacks paid and unpaid results
	 */
	@And("^TimeStampTheSpartans user unchecks paid and unpaid checkbox and validates the result$")
	public void TimeStampTheSpartans_user_validates_paid_unpaid_results() throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		PaymentsOverview oneTimePaymentsPage = accountHomePage.UnselectPaidUnpaidCheck();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD, oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("issue with paid unpaid checkbox");
		}

	}

	@And("^the user navigates to Team H One Time Payments page$")
	public void user_validates_TeamH_Payment_overview() throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage.navigateToOneTimePaymentpage();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD, oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	/**
	 * @todo : User arrives at OneTimePayment page form
	 */
	@And("^TimeStampTheSpartans the user navigates to Team H One Time Payments page$")
	public void TimeStampTheSpartans_user_validates_TeamH_Payment_overview() throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage.navigateToOneTimePaymentpage();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD, oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	/**
	 * User is Taken to Automatic Payments page form
	 */
	@And("^TimeStampTheSpartans the user navigates to Team H Automatic Payments page$")
	public void TimeStampTheSpartans_user_validates_TeamHAuto_Payment_overview() throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage.navigateToAutoPaymentpage();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.AUTOMATIC_PAYMENTS_DASHBOARD, oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	@And("^the user enters details and click on continue button on One Time Payments Page for Dashboard$")
	public void user_clicks_and_navigates_to_Review_page() throws InterruptedException {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.enterInfoAndContinue();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD, reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}

	/**
	 * User Enters the required details and click on continue to see review page
	 */
	@And("^TimeStampTheSpartans the user enters details and click on continue button on One Time Payments Page for Dashboard$")
	public void TimeStampTheSpartans_user_clicks_and_navigates_to_Review_page() throws InterruptedException {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.enterInfoAndContinue();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD, reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}

	@And("^the user enters details and click on continue button on Automatic Payments Page for Dashboard$")
	public void user_clicks_AutoPay_and_navigates_to_Review_page() throws InterruptedException {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.AUTOMATIC_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.enterInfoAndContinue();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD, reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}

	/**
	 * User enters details on Automatic Payments form and navigates to
	 * AutomaticPaymentsReview page
	 */
	@And("^TimeStampTheSpartans the user enters details and click on continue button on Automatic Payments Page for Dashboard$")
	public void TimeStampTheSpartans_user_clicks_AutoPay_and_navigates_to_Review_page() throws InterruptedException {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.AUTOMATIC_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.enterInfoAndContinue();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD, reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}

	/**
	 * @todo : User Lands on Review one time payment page , slects the checkbox
	 *       and continue to One time Payment Submitted page
	 */
	@And("^TimeStampTheSpartans user lands on Review One time Payments Page and navigates to OTP Submitted Page$")
	public void Review_OneTime_Payment_Navigation_to_OTPSubmitted() throws InterruptedException {
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		OneTimePaymentPageSubmitted OTPSubmitted = reviewOneTimePaymentsPage.navigateToOTPSubmittedPage();
		Thread.sleep(1000);
		if (OTPSubmitted != null) {
			getLoginScenario().saveBean(PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE, OTPSubmitted);
			Assert.assertTrue(true);
		} else {
			Assert.fail("OTP Submitted page not found");
		}
	}

	/*
	 * @And(
	 * "^user lands on Review One time Payments Page and navigates to Review Submitted Page$"
	 * ) public void Review_OneTime_Payment_Navigation_to_ReviewSubmitted()
	 * throws InterruptedException { ReviewOneTimePaymentsPage
	 * reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage)
	 * getLoginScenario()
	 * .getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
	 * OneTimePaymentPageSubmitted OTPSubmitted = reviewOneTimePaymentsPage
	 * .navigateToReviewSubmittedPage(); Thread.sleep(1000); if (OTPSubmitted !=
	 * null) { getLoginScenario().saveBean(
	 * PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE, OTPSubmitted);
	 * Assert.assertTrue(true); } else { Assert.fail(
	 * "OTP Submitted page not found"); } }
	 * 
	 *//**
		 * User is on Review Automatic payments page, checks the electronic
		 * signature box and move to Submit Page
		 *//*
		 * @And(
		 * "^TimeStampTheSpartans user lands on Review Automatic Payments Page and navigates to Review Submitted Page$"
		 * ) public void
		 * TimeStampTheSpartans_Review_OneTime_Payment_Navigation_to_ReviewSubmitted
		 * () throws InterruptedException { ReviewOneTimePaymentsPage
		 * reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage)
		 * getLoginScenario()
		 * .getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		 * OneTimePaymentPageSubmitted OTPSubmitted = reviewOneTimePaymentsPage
		 * .navigateToReviewSubmittedPage(); Thread.sleep(1000); if
		 * (OTPSubmitted != null) { getLoginScenario().saveBean(
		 * PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE, OTPSubmitted);
		 * Assert.assertTrue(true); } else { Assert.fail(
		 * "OTP Submitted page not found"); } }
		 */

	@Then("^user lands on Review One time Payments Page and validates one payment per day error message$")
	public void One_Payment_Per_Day_Error() throws InterruptedException {
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage OTPError = reviewOneTimePaymentsPage.ValidateOnePaymentPerDayErrorMessage();
		Thread.sleep(1000);
		if (OTPError != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_PAYMENT_PER_DAY_ERROR_MESSAGE, OTPError);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error message not validated");
		}
	}

	/**
	 * This step validates the error message for more than one payment per day
	 */
	@Then("^TimeStampTheSpartans user lands on Review One time Payments Page and validates one payment per day error message$")
	public void TimeStampTheSpartans_One_Payment_Per_Day_Error() throws InterruptedException {
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage OTPError = reviewOneTimePaymentsPage.ValidateOnePaymentPerDayErrorMessage();
		Thread.sleep(1000);
		if (OTPError != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ONE_PAYMENT_PER_DAY_ERROR_MESSAGE, OTPError);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error message not validated");
		}
	}

	@Then("^the user lands on OneTime Payment Submitted Page and validates PDF link$")
	public void OneTime_payment_SubmittedPage() {

		OneTimePaymentPageSubmitted OTPSubmitted = (OneTimePaymentPageSubmitted) getLoginScenario()
				.getBean(PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		OneTimePaymentPageSubmitted PDFValidation = OTPSubmitted.ValidatePDFLink();
		if (PDFValidation != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PDF_LINK, PDFValidation);
			Assert.assertTrue(true);
		} else {
			Assert.fail("PDF Link not found");
		}

	}

	@Then("^the user lands on OneTime Payment Submitted Page and validates Payment Amount and Member Name$")
	public void OTP_SubmittedPage_Validations() throws InterruptedException {

		OneTimePaymentPageSubmitted OTPSubmitted = (OneTimePaymentPageSubmitted) getLoginScenario()
				.getBean(PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		Thread.sleep(2000);
		OneTimePaymentPageSubmitted PaymentAmount = OTPSubmitted.ValidatePaymentAmount();
		OneTimePaymentPageSubmitted MemberName = OTPSubmitted.ValidateMemberName();
		if (PaymentAmount != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_AMOUNT, PaymentAmount);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Amount not found");
		}

		if (MemberName != null) {
			getLoginScenario().saveBean(PageConstantsMnR.MEMBER_NAME, MemberName);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Member name not found");
		}

	}

	@Then("^the user lands on OneTime Payment Submitted Page and validates Timestamp$")
	public void OTP_SubmittedPage_Timestamp() throws InterruptedException {

		OneTimePaymentPageSubmitted OTPSubmitted = (OneTimePaymentPageSubmitted) getLoginScenario()
				.getBean(PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		Thread.sleep(2000);
		OneTimePaymentPageSubmitted Timestamp = OTPSubmitted.ValidateTimeStamp();
		if (Timestamp != null) {
			getLoginScenario().saveBean(PageConstantsMnR.TIMESTAMP, Timestamp);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Amount not found");
		}
	}

	/**
	 * User reaches the OnetimePaymentSubmittedPage and validates Timestamp
	 */
	@Then("^TimeStampTheSpartans the user lands on OneTime Payment Submitted Page and validates Timestamp$")
	public void TimeStampTheSpartans_OTP_SubmittedPage_Timestamp() throws InterruptedException {

		OneTimePaymentPageSubmitted OTPSubmitted = (OneTimePaymentPageSubmitted) getLoginScenario()
				.getBean(PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		Thread.sleep(2000);
		OneTimePaymentPageSubmitted Timestamp = OTPSubmitted.ValidateTimeStamp();
		if (Timestamp != null) {
			getLoginScenario().saveBean(PageConstantsMnR.TIMESTAMP, Timestamp);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Amount not found");
		}
	}

	@And("^the user enters details without clicking checkbox and clicks on continue button on OTP Page for Dashboard$")
	public void user_continueswithoutCheckbox() {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.enterInfoWithoutCheckBoxAndContinue();
		oneTimePaymentsPage.errorMessagechkBox();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD, reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	@And("^the user clicks on cancel button on OTP Page and validates title$")
	public void user_clicks_cancel_button() {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.CancelButton();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD, reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	@Then("^user validates the Payment History Page$")
	public void user_validates_Payment_History_PageDetails() {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.HistoryPageValidation();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_HISTORY_PAGE, reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}

	@Then("^user lands on Review One time Payments Page and validates the amount and routing number values$")
	public void review_onetime_payments_validation() {
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		JSONObject reviewOneTimeActual = reviewOneTimePaymentsPage.reviewOneTimeValues();
		/* Get expected data */
		String fileName = "reviewonetimeexpected";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY + File.separator + CommonConstants.SITE_ULAYER
				+ File.separator + PaymentCommonConstants.ONE_TIME_PAYMENTS_FLOW_NAME + File.separator;
		JSONObject reviewOneTimeExpectedJson = MRScenario.readExpectedJson(fileName, directory);

		getLoginScenario().saveBean(PaymentCommonConstants.ONE_TIME_PAYMENTS_ACTUAL, reviewOneTimeActual);
		getLoginScenario().saveBean(PaymentCommonConstants.ONE_TIME_PAYMENTS_EXPECTED, reviewOneTimeExpectedJson);

		System.out.println("reviewOneTimeActual---->" + reviewOneTimeActual);
		System.out.println("reviewOneTimeExpectedJson---->" + reviewOneTimeExpectedJson);

		try {
			JSONAssert.assertEquals(reviewOneTimeExpectedJson, reviewOneTimeActual, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^the user clicks on cancel button on Review Payments Page and validates payments history page$")
	public void user_clicks_cancelbtn_onOnetimePaymentPage() {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		oneTimePaymentsPage.onetimepagecancelbtn();
	}

	@When("^the user clicks on Premium Payments on Header$")
	public void the_user_clicks_on_Premium_Payments_on_Header() throws Throwable {

		AccountHomePage accountHomePage;

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			PaymentHistoryPage paymentHistoryPage = testHarness.navigateToPaymentFromTestHarnessPage();
			if (paymentHistoryPage != null) {
				getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
				System.out.println("User is on Payment overview screen");
			}
		}else {

			accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			PaymentHistoryPage paymentHistoryPage = accountHomePage.navigateToPaymentHistoryPage();
			if (paymentHistoryPage != null) {
				getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
				System.out.println("User is on Payment overview screen");
			}
		}
	}

	@When("^user clicks on Make one time payment on payment overview page$")
	public void user_clicks_on_Make_one_time_payment_on_payment_overview_page() throws Throwable {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);

		OneTimePaymentPage oneTimePaymentPage=null;
		if(null !=paymentHistoryPage){
			
			oneTimePaymentPage = paymentHistoryPage.clickOnMakeOneTimePayment();
		}

		if (oneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.One_Time_Payments_Page, oneTimePaymentPage);
			System.out.println("User is on Make one time payment screen");
		}
	}

	@When("^user selects other amount and enters \"([^\"]*)\" and selects credit card and click on Next button$")
	public void user_selects_other_amount_and_enters_and_selects_credit_card_and_click_on_Next_button(
			String otherAmountvalue) throws Throwable {
		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.One_Time_Payments_Page);

		CreditCardUPGPage creditCardPaymentPage=null;
		if(oneTimePaymentPage!=null) {
			oneTimePaymentPage.selectAndEnterAmount(otherAmountvalue);
			oneTimePaymentPage.selectCreditCardOption();
			creditCardPaymentPage = oneTimePaymentPage.clickOnNextButton();
		}
		if (creditCardPaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.Credit_Card_Payments_Page, creditCardPaymentPage);
			System.out.println("User is on UPG Credit cards page");

		}
	}
	
	@When("^user selects other amount and enters \"([^\"]*)\" and selects Checking Account and click on Next button$")
	public void user_selects_other_amount_and_enters_and_selects_Checking_Account_and_click_on_Next_button(
			String otherAmountvalue) throws Throwable {
		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.One_Time_Payments_Page);
		oneTimePaymentPage.selectAndEnterAmount(otherAmountvalue);
		oneTimePaymentPage.selectCheckingAccountOption();
		PaymentsFormPage paymentsFormPage = oneTimePaymentPage.clickOnContuineButton();
		if (paymentsFormPage != null) {
			getLoginScenario().saveBean(PageConstants.Payments_Form_Page, paymentsFormPage);
			System.out.println("User is on One time EFT Payment Form Page");

		}
	}

	@When("^user selects Amount due today and selects credit card and click on Next button$")
	public void user_selects_Amount_due_today_and_selects_credit_card_and_click_on_Next_button() throws Throwable {
		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.One_Time_Payments_Page);

		CreditCardUPGPage creditCardPaymentPage=null;

		if(oneTimePaymentPage!=null){

			oneTimePaymentPage.selectAmountDueToday();
			oneTimePaymentPage.selectCreditCardOption();

			creditCardPaymentPage = oneTimePaymentPage.clickOnNextButton();
		}





		if (creditCardPaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.Credit_Card_Payments_Page, creditCardPaymentPage);
			System.out.println("User is on UPG Credit cards page");
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

		ReviewOneTimePaymentPage reviewOneTimePaymentsPage=null;
		if(creditCardPaymentPage!=null) {

		 reviewOneTimePaymentsPage = creditCardPaymentPage.EnterFiledsOnCC(memberAttributesMap);
		}
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstants.Review_OneTime_Payments_Page, reviewOneTimePaymentsPage);
			System.out.println("User is on Review One time payments page");

		}
	}

	@Then("^user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed for Recurring$")
	public void user_Navigates_to_UPG_payment_page_and_Enter_Mandatory_fields_and_click_on_Proceed_for_Recurring(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		CreditCardUPGPage creditCardPaymentPage = (CreditCardUPGPage) getLoginScenario()
				.getBean(PageConstants.Credit_Card_Payments_Page);
		ReviewAutomaticPage reviewAutomaticPage = creditCardPaymentPage.EnterFiledsOnCCforREC(memberAttributesMap);
		if (reviewAutomaticPage != null) {
			getLoginScenario().saveBean(PageConstants.Review_Automatic_Page, reviewAutomaticPage);
			System.out.println("User is on Review Recurring Payments page");

		}
	}

	@Then("^user navigates to payment overview screen and selects agreements and click on Make one time payemnt$")
	public void user_navigates_to_payment_overview_screen_and_selects_agreements_and_click_on_Make_one_time_payemnt()
			throws Throwable {
		ReviewOneTimePaymentPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.Review_OneTime_Payments_Page);

		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = reviewOneTimePaymentsPage
				.selectAgreeAndClickOnMakePayment();
		if (confirmOneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_PAGE, confirmOneTimePaymentPage);
			System.out.println("User is on Review One time payments page");
			getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG,"false");

			Assert.assertTrue(true);
		}else {

			boolean Validation_Status =reviewOneTimePaymentsPage.validate_onlyOnePaymentRequest_Message();

			if(Validation_Status) {
				System.out.println("Only one payment request message is Displayed in review one time PAGE : " + Validation_Status + " - Validation Passed");
				getLoginScenario().saveBean(PageConstants.Review_OneTime_Payments_Page, reviewOneTimePaymentsPage);
				getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG, "true");
				Assert.assertTrue(true);
			}else{
				System.out.println("Only one payment request message is NOT Displayed in review one time PAGE : "+Validation_Status);
				Assert.fail();
			}

		}







	}

	@Then("^User navigates to payment confirmation page for CC flow$")
	public void user_navigates_to_payment_confirmation_page_for_CC_flow() throws Throwable {

		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(PageConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Only one payment request message is Displayed in in review one time PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); }else {
		 */
			ConfirmOneTimePaymentPage confirmOneTimePaymentPage = (ConfirmOneTimePaymentPage) getLoginScenario()
					.getBean(PageConstants.ONE_TIME_PAYMENT_PAGE);
			confirmOneTimePaymentPage.OneTimeCCverification();
			Assert.assertTrue("One time Payment submission for Credit card Other amount is successfully done",true);
	//	}
	}

	@Given("^user clicks on Set up Automatic payments on payment overview page$")
	public void user_clicks_on_Set_up_Automatic_payments_on_payment_overview_page() throws Throwable {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);


		SetUpRecurringPage setupRecurringPage = paymentHistoryPage.clickOnSetUPAutomaticPayment();
		if (setupRecurringPage != null) {
			getLoginScenario().saveBean(PageConstants.SetUp_Recurring_Page, setupRecurringPage);
			System.out.println("User is on Setup Recurring Payments screen");
		}
	}

	@Given("^user selects checking Account on Setup Automatic recurring payments page and Click on Next$")
	public void user_selects_checking_Account_on_Setup_Automatic_recurring_payments_page_and_Click_on_Next()
			throws Throwable {
		SetUpRecurringPage setupRecurringPage = (SetUpRecurringPage) getLoginScenario()
				.getBean(PageConstants.SetUp_Recurring_Page);
		PaymentsFormPage paymentsFormPage = setupRecurringPage.selectCheckingAccountAndClickOnNext();
		if (paymentsFormPage != null) {
			getLoginScenario().saveBean(PageConstants.Payments_Form_Page, paymentsFormPage);
			System.out.println("User is on Form Page for Checking account");
		}
	}

	@Given("^user selects CreditDebit Card on Setup Automatic recurring payments page and Click on Next$")
	public void user_selects_CreditDebit_Card_on_Setup_Automatic_recurring_payments_page_and_Click_on_Next()
			throws Throwable {
		SetUpRecurringPage setupRecurringPage = (SetUpRecurringPage) getLoginScenario()
				.getBean(PageConstants.SetUp_Recurring_Page);
		CreditCardUPGPage creditCardPaymentPage = setupRecurringPage.selectCCAndClickOnNext();
		if (creditCardPaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.Credit_Card_Payments_Page, creditCardPaymentPage);
			System.out.println("User is on UPG Page");
		}
	}

	@Given("^user Enters all Mandatory fields on form page and click on Authorize button$")
	public void user_Enters_all_Mandatory_fields_on_form_page_and_click_on_Authorize_button(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		PaymentsFormPage paymentsFormPage = (PaymentsFormPage) getLoginScenario()
				.getBean(PageConstants.Payments_Form_Page);
		ReviewAutomaticPage reviewAutomaticPage = paymentsFormPage.EnterFiledsOnEFTforSetup(memberAttributesMap);
		if (reviewAutomaticPage != null) {
			getLoginScenario().saveBean(PageConstants.Review_Automatic_Page, reviewAutomaticPage);
			System.out.println("User is on Review Automatic payment for Checking account");
		}

	}
	
	@Given("^user Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA$")
	public void user_Enters_all_Mandatory_fields_on_form_page_and_click_on_Authorize_button_for_Make_one_time_CA(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		PaymentsFormPage paymentsFormPage = (PaymentsFormPage) getLoginScenario()
				.getBean(PageConstants.Payments_Form_Page);
		OneTimePaymentPage oneTimePaymentPage = paymentsFormPage.EnterFiledsOnMakeOneTime(memberAttributesMap);
		if (oneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_PAGE, oneTimePaymentPage);
			System.out.println("User is on Review payment page for Checking account");
		}

	}
	
	@Given("^user navigates to Review Your One-Time Payment Information and selects agreements and click on Submit Button for Make One Time$")
	public void user_navigates_to_Review_Your_One_Time_Payment_Information_and_selects_agreements_and_click_on_Submit_Button_for_Make_One_Time()
			throws Throwable {
		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENT_PAGE);
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = oneTimePaymentPage
				.selectAgreeAndClickOnSubmitPaymentsforOneTime();
		if (confirmOneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE, confirmOneTimePaymentPage);
			System.out.println("User is on One time confirmation page for Checking account");
		}
	}

	@Given("^user navigates to review your Automatic screen and selects agreements and click on Authorize Monthly payments Button for EFT$")
	public void user_navigates_to_review_your_Automatic_screen_and_selects_agreements_and_click_on_Authorize_Monthly_payments_Button_for_EFT()
			throws Throwable {
		ReviewAutomaticPage reviewAutomaticPage = (ReviewAutomaticPage) getLoginScenario()
				.getBean(PageConstants.Review_Automatic_Page);
		RecurringConfirmationPage recurringConfirmationPage = reviewAutomaticPage
				.selectAgreeAndClickOnAuthorizeMonthyPaymentsforEFT();
		if (recurringConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.Recurring_Confirmation_Page, recurringConfirmationPage);
			System.out.println("User is on recurring confirmation page for Checking account");
			getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG,"false");

			Assert.assertTrue(true);
		}else {

			boolean Validation_Status =reviewAutomaticPage.validate_onlyOnePaymentRequest_Message();

			if(Validation_Status) {
				System.out.println("Only one payment request message is Displayed in review one time PAGE : " + Validation_Status + " - Validation Passed");
				getLoginScenario().saveBean(PageConstants.Review_Automatic_Page, reviewAutomaticPage);
				getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG, "true");
				Assert.assertTrue(true);
			}else{
				System.out.println("Only one payment request message is NOT Displayed in review one time PAGE : "+Validation_Status);
				Assert.fail();
			}

		}
	}

	@Given("^user navigates to Review Payment Method Update screen and selects agreements and click on Authorize Monthly payments Button for EFT$")
	public void user_navigates_to_Review_Payment_Method_Update_screen_and_selects_agreements_and_click_on_Authorize_Monthly_payments_Button_for_EFT()
			throws Throwable {
		UpdateReviewPage updateReviewPage = (UpdateReviewPage) getLoginScenario()
				.getBean(PageConstants.Update_Review_Page);
		UpdateConfirmationPage updateConfirmationPage = updateReviewPage.selectAgreeAndClickOnContinueforEFT();
		if (updateConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Confirmation_Page, updateConfirmationPage);
			System.out.println("User is on Update confirmation page for Checking account");
			getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG,"false");

			Assert.assertTrue(true);
		} else {

			boolean Validation_Status =updateReviewPage.validate_onlyOnePaymentRequest_Message();

			if(Validation_Status) {
				System.out.println("Only one payment request message is Displayed in review one time PAGE : " + Validation_Status + " - Validation Passed");
				getLoginScenario().saveBean(PageConstants.Update_Review_Page, updateReviewPage);
				getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG, "true");
				Assert.assertTrue(true);
			}else{
				System.out.println("Only one payment request message is NOT Displayed in review one time PAGE : "+Validation_Status);
				Assert.fail();
			}

		}
	}

	@Given("^CSR navigates to Review Payment Method Update screen and selects agreements and click on Authorize Monthly payments Button for EFT$")
	public void CSR_navigates_to_Review_Payment_Method_Update_screen_and_selects_agreements_and_click_on_Authorize_Monthly_payments_Button_for_EFT()
			throws Throwable {
		UpdateReviewPage updateReviewPage = (UpdateReviewPage) getLoginScenario()
				.getBean(PageConstants.Update_Review_Page);
		UpdateConfirmationPage updateConfirmationPage = updateReviewPage.selectAgreeAndClickOnContinueforEFT();
		if (updateConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Confirmation_Page, updateConfirmationPage);
			System.out.println("User is on Update confirmation page for Checking account");
			getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG,"false");

			Assert.assertTrue(true);
		} else {

			boolean Validation_Status =updateReviewPage.validate_onlyOnePaymentRequest_Message();

			if(Validation_Status) {
				System.out.println("Only one payment request message is Displayed in review one time PAGE : " + Validation_Status + " - Validation Passed");
				getLoginScenario().saveBean(PageConstants.Update_Review_Page, updateReviewPage);
				getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG, "true");
				Assert.assertTrue(true);
			}else{
				System.out.println("Only one payment request message is NOT Displayed in review one time PAGE : "+Validation_Status);
				
			}

		}
	}
	
	@Given("^user navigates to review your Automatic screen and selects agreements and click on Authorize Monthly payments Button for CC$")
	public void user_navigates_to_review_your_Automatic_screen_and_selects_agreements_and_click_on_Authorize_Monthly_payments_Button_for_CC()
			throws Throwable {
		ReviewAutomaticPage reviewAutomaticPage = (ReviewAutomaticPage) getLoginScenario()
				.getBean(PageConstants.Review_Automatic_Page);
		RecurringConfirmationPage recurringConfirmationPage = reviewAutomaticPage.selectAgreeAndClickOnContinueforCC();
		if (recurringConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.Recurring_Confirmation_Page, recurringConfirmationPage);
			System.out.println("User is on recurring confirmation page for CC");
		}
	}

	@Then("^User navigates to payment confirmation page and verifies ConfirmationNo for EFT$")
	public void user_navigates_to_payment_confirmation_page_and_verifies_ConfirmationNo_for_EFT() throws Throwable {

		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(PageConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){
		 * System.out.println("Only one payment request message is Displayed  : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); }else {
		 */
			RecurringConfirmationPage recurringConfirmationPage = (RecurringConfirmationPage) getLoginScenario()
					.getBean(PageConstants.Recurring_Confirmation_Page);
			recurringConfirmationPage.validateEFTRecurrVerification();
			Assert.assertTrue(true);
	//	}
	}
	
	@Then("^User navigates to payment confirmation page and verifies ConfirmationNo for One time$")
	public void user_navigates_to_payment_confirmation_page_and_verifies_ConfirmationNo_for_One_time() throws Throwable {
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		String verifyConfirmationNumberPresent = confirmOneTimePaymentPage.OneTimeEFTverification();
		getLoginScenario().saveBean(PageConstants.CONFIRMATION_NUMBER, verifyConfirmationNumberPresent);
				
		//getLoginScenario().saveBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE, confirmOneTimePaymentPage);
		//Updated the row above (changed the constant to use Oracle deletion statement
		getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_PAGE, confirmOneTimePaymentPage);

	}

	@Then("^User navigates to payment confirmation page and verifies ConfirmationNo for CC$")
	public void user_navigates_to_payment_confirmation_page_and_verifies_ConfirmationNo_for_CC() throws Throwable {
		RecurringConfirmationPage recurringConfirmationPage = (RecurringConfirmationPage) getLoginScenario()
				.getBean(PageConstants.Recurring_Confirmation_Page);
		recurringConfirmationPage.validateCCRecurrVerification();

	}

	@Given("^user clicks on Update Automatic payments on payment overview page$")
	public void user_clicks_on_Update_Automatic_payments_on_payment_overview_page() throws Throwable {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		UpdateRecurringPage updateRecurringPage = paymentHistoryPage.clickOnEditAutomaticPayment();
		if (updateRecurringPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Recurring_Page, updateRecurringPage);
			}
	}

	@Given("^user clicks on Stop Automatic payments and clicks on next for Federal$")
	public void user_clicks_on_Stop_Automatic_payments_and_clicks_on_next_for_Federal() throws Throwable {
		UpdateRecurringPage updateRecurringPage = (UpdateRecurringPage) getLoginScenario()
				.getBean(PageConstants.Update_Recurring_Page);
		UpdateReviewPage updateReviewPage = updateRecurringPage.selectCancelAutomaticPaymentsAndClicksNext();
		if (updateReviewPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Review_Page, updateReviewPage);
			System.out.println("User is on Review Recurring Payments screen");
		}

	}

	@Then("^user navigates to Review Payment Method Update screen for Stop Recurring Payments for Federal$")
	public void user_navigates_to_Review_Payment_Method_Update_screen_for_Stop_recurring_payments_page_for_Federal()
			throws Throwable {
		UpdateReviewPage updateReviewPage = (UpdateReviewPage) getLoginScenario()
				.getBean(PageConstants.Update_Review_Page);
		UpdateConfirmationPage updateConfirmationPage = updateReviewPage
				.selectAgreeAndClickOnContinueforStopRecurringForFed();
		if (updateConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Confirmation_Page, updateConfirmationPage);
			System.out.println("User is on Confirmation Payment Method Update Page Payments screen");
		}
	}

	@Given("^user selects checking Account on Update Automatic recurring payments page and Click on Next$")
	public void user_selects_checking_Account_on_Update_Automatic_recurring_payments_page_and_Click_on_Next()
			throws Throwable {
		UpdateRecurringPage updateRecurringPage = (UpdateRecurringPage) getLoginScenario()
				.getBean(PageConstants.Update_Recurring_Page);
		PaymentsFormPage paymentsFormPage = updateRecurringPage.selectCheckingAccountAndClickOnNext();
		if (paymentsFormPage != null) {
			getLoginScenario().saveBean(PageConstants.Payments_Form_Page, paymentsFormPage);
			System.out.println("User is on Form Page for Checking account");
		}
	}

	@Given("^user Enters all Mandatory fields on form page and click on Authorize button for Update Recurring$")
	public void user_Enters_all_Mandatory_fields_on_form_page_and_click_on_Authorize_button_for_Update_Recurring(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		PaymentsFormPage paymentsFormPage = (PaymentsFormPage) getLoginScenario()
				.getBean(PageConstants.Payments_Form_Page);
		UpdateReviewPage updateReviewPage = paymentsFormPage.EnterFiledsOnEFTforUpdate(memberAttributesMap);
		if (updateReviewPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Review_Page, updateReviewPage);
			System.out.println("User is on Update Review Automatic payment for Checking account");
		}

	}

	@Then("^User navigates to payment confirmation page and verifies ConfirmationNo for EFT for Update Recurring$")
	public void user_navigates_to_payment_confirmation_page_and_verifies_ConfirmationNo_for_EFT_for_Update_Recurring()
			throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(PageConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){
		 * System.out.println("Only one payment request message is Displayed  : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); }else {
		 */

			UpdateConfirmationPage updateConfirmationPage = (UpdateConfirmationPage) getLoginScenario()
					.getBean(PageConstants.Update_Confirmation_Page);
			updateConfirmationPage.validateEFTUpdateVerification();
			Assert.assertTrue("Update Recurring for Checking Account is done",true);
	//	}
	}

	@Given("^user selects CreditDebit Card on Update Automatic recurring payments page and Click on Next$")
	public void user_selects_CreditDebit_Card_on_Update_Automatic_recurring_payments_page_and_Click_on_Next()
			throws Throwable {
		UpdateRecurringPage updateRecurringPage = (UpdateRecurringPage) getLoginScenario()
				.getBean(PageConstants.Update_Recurring_Page);
		CreditCardUPGPage creditCardPaymentPage = updateRecurringPage.selectCCAndClickOnNext();
		if (creditCardPaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.Credit_Card_Payments_Page, creditCardPaymentPage);
			System.out.println("User is on UPG Page");
		}
	}

	@Then("^user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed for Update Recurring$")
	public void user_Navigates_to_UPG_payment_page_and_Enter_Mandatory_fields_and_click_on_Proceed_for_Update_Recurring(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		CreditCardUPGPage creditCardPaymentPage = (CreditCardUPGPage) getLoginScenario()
				.getBean(PageConstants.Credit_Card_Payments_Page);
		UpdateReviewPage updateReviewPage = creditCardPaymentPage.EnterFiledsOnCCforUpdateREC(memberAttributesMap);
		if (updateReviewPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Review_Page, updateReviewPage);
			System.out.println("User is on Update Review Payments page");

		}
	}

	@Given("^user navigates to Review Payment Method Update screen and selects agreements and click on Authorize Monthly payments Button for CC$")
	public void user_navigates_to_Review_Payment_Method_Update_screen_and_selects_agreements_and_click_on_Authorize_Monthly_payments_Button_for_CC()
			throws Throwable {
		UpdateReviewPage updateReviewPage = (UpdateReviewPage) getLoginScenario()
				.getBean(PageConstants.Update_Review_Page);
		UpdateConfirmationPage updateConfirmationPage = updateReviewPage.selectAgreeAndClickOnContinueforCC();
		if (updateConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Confirmation_Page, updateConfirmationPage);
			System.out.println("User is on Update Confirmation for CC");
		}
	}

	@Then("^User navigates to payment confirmation page and verifies ConfirmationNo for CC for Update Recurring$")
	public void user_navigates_to_payment_confirmation_page_and_verifies_ConfirmationNo_for_CC_for_Update_Recurring()
			throws Throwable {
		UpdateConfirmationPage updateConfirmationPage = (UpdateConfirmationPage) getLoginScenario()
				.getBean(PageConstants.Update_Confirmation_Page);
		updateConfirmationPage.validateCCUpdateVerification();

	}

	@Given("^user Enters all Mandatory fields on form page and click on Electronic Signature and click on Contuine for Update Recurring for Ship$")
	public void user_Enters_all_Mandatory_fields_on_form_page_and_click_on_Electronic_Signature_and_click_on_Contuine_for_Update_Recurring_for_Ship(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		PaymentsFormPage paymentsFormPage = (PaymentsFormPage) getLoginScenario()
				.getBean(PageConstants.Payments_Form_Page);
		UpdateReviewPage updateReviewPage = paymentsFormPage.EnterFiledsOnEFTforUpdateForShip(memberAttributesMap);
		if (updateReviewPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Review_Page, updateReviewPage);
			System.out.println("User is on Update Review Automatic payment for Checking account");
		}

	}
	
	@Given("^user Enters all Mandatory fields on form page and click on Electronic Signature and click on Contuine for Setup Recurring for Ship$")
	public void user_Enters_all_Mandatory_fields_on_form_page_and_click_on_Electronic_Signature_and_click_on_Contuine_for_setup_Recurring_for_Ship(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		PaymentsFormPage paymentsFormPage = (PaymentsFormPage) getLoginScenario()
				.getBean(PageConstants.Payments_Form_Page);
		OneTimePaymentPage oneTimePaymentPage = paymentsFormPage.EnterFiledsOnSetupEFTforShip(memberAttributesMap);
		if (oneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_PAGE, oneTimePaymentPage);
		}

	}

	@Given("^user clicks on Update Automatic payments on payment overview page for Ship$")
	public void user_clicks_on_Update_Automatic_payments_on_payment_overview_page_for_Ship() throws Throwable {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		UpdateRecurringPage updateRecurringPage = paymentHistoryPage.clickOnEditAutomaticPaymentforShip();
		if (updateRecurringPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Recurring_Page, updateRecurringPage);
			System.out.println("User is on Setup Recurring Payments screen");
		}
	}
	
	
	@Given("^user clicks on Setup Automatic payments on payment overview page for Ship$")
	public void user_clicks_on_setup_Automatic_payments_on_payment_overview_page_for_Ship() throws Throwable {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		PaymentsFormPage paymentsFormPage = paymentHistoryPage.clickOnsetupAutomaticPaymentforShip();
		if (paymentsFormPage != null) {
			getLoginScenario().saveBean(PageConstants.Payments_Form_Page, paymentsFormPage);
			System.out.println("User is on Setup Recurring Payments screen");
		}
	}
	
	@Given("^user navigates to Review Your Payment screen and selects agreements and click on Contuine Button for EFT Ship$")
	public void user_navigates_to_Review_Your_Payment_screen_and_selects_agreements_and_click_on_Contuine_Button_for_EFT_Ship()
			throws Throwable {
		
			OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENT_PAGE);
			ConfirmOneTimePaymentPage confirmOneTimePaymentPage = oneTimePaymentPage.selectAgreeAndClickOnContinueforEFTForShip();
		if (confirmOneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE, confirmOneTimePaymentPage);
			System.out.println("User is on recurring confirmation page for Checking account");
		}
	}

	@Given("^user navigates to Review Payment Method Update screen and selects agreements and click on Contuine Button for EFT Ship$")
	public void user_navigates_to_Review_Payment_Method_Update_screen_and_selects_agreements_and_click_on_Contuine_Button_for_EFT_Ship()
			throws Throwable {
		UpdateReviewPage updateReviewPage = (UpdateReviewPage) getLoginScenario()
				.getBean(PageConstants.Update_Review_Page);
		UpdateConfirmationPage updateConfirmationPage = updateReviewPage.selectAgreeAndClickOnContinueforEFTForShip();
		if (updateConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Confirmation_Page, updateConfirmationPage);
			System.out.println("User is on recurring confirmation page for Checking account");
		}
	}
	
	@Then("^User navigates to payment confirmation page and verifies sucessful EFT for setup Recurring for Ship$")
	public void user_navigates_to_payment_confirmation_page_and_verifies_sucessful_EFT_for_setup_Recurring_for_Ship()
			throws Throwable {
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		confirmOneTimePaymentPage.validateEFTSetupVerificationforShip();

	}

	@Then("^User navigates to payment confirmation page and verifies sucessful EFT for Update Recurring for Ship$")
	public void user_navigates_to_payment_confirmation_page_and_verifies_sucessful_EFT_for_Update_Recurring_for_Ship()
			throws Throwable {
		UpdateConfirmationPage updateConfirmationPage = (UpdateConfirmationPage) getLoginScenario()
				.getBean(PageConstants.Update_Confirmation_Page);
		updateConfirmationPage.validateEFTUpdateVerificationforShip();

	}

	@Given("^user selects Stop Automatic Recurring Payments and Click on Next$")
	public void user_selects_Stop_Automatic_Recurring_Payments_and_Click_on_Next() throws Throwable {
		UpdateRecurringPage updateRecurringPage = (UpdateRecurringPage) getLoginScenario()
				.getBean(PageConstants.Update_Recurring_Page);
		UpdateReviewPage updateReviewPage = updateRecurringPage.selectStopRecurringClickOnNextforShip();
		if (updateReviewPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Review_Page, updateReviewPage);
			System.out.println("User is on Update review page");
		}
	}

	@Given("^user navigates to Review Payment Method Update screen and selects agreements and click on Contuine Button for Stop recurring Ship$")
	public void user_navigates_to_Review_Payment_Method_Update_screen_and_selects_agreements_and_click_on_Contuine_Button_for_Stop_recurring_Ship()
			throws Throwable {
		UpdateReviewPage updateReviewPage = (UpdateReviewPage) getLoginScenario()
				.getBean(PageConstants.Update_Review_Page);
		UpdateConfirmationPage updateConfirmationPage = updateReviewPage.selectAgreeAndClickOnContinueforStopForShip();
		if (updateConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.Update_Confirmation_Page, updateConfirmationPage);
			System.out.println("User is on recurring confirmation page for Checking account");
		}
	}

	@Then("^User navigates to payment confirmation page and verifies sucessful Stop Recurring for Ship$")
	public void user_navigates_to_payment_confirmation_page_and_verifies_sucessful_Stop_Recurring_for_Ship()
			throws Throwable {
		UpdateConfirmationPage updateConfirmationPage = (UpdateConfirmationPage) getLoginScenario()
				.getBean(PageConstants.Update_Confirmation_Page);
		updateConfirmationPage.validateStopRevurringVerificationforShip();

	}

	@Then("^User navigates to payment confirmation page and verifies sucessful Stop Recurring for Federal$")
	public void user_navigates_to_payment_confirmation_page_and_verifies_sucessful_Stop_Recurring_for_Federal()
			throws Throwable {
		UpdateConfirmationPage updateConfirmationPage = (UpdateConfirmationPage) getLoginScenario()
				.getBean(PageConstants.Update_Confirmation_Page);
		updateConfirmationPage.validateStopRevurringVerificationforFed();

	}
	// vvv note: added for F247601 Payment History SHIP testing
	@Then("^user validates payment history section header exists$")
	public void user_validates_payment_history_section_header_exists() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validatePaymentHistoryHeaderExists();
	}
	
	@Then("^user validates date range default is Last 90 days$")
	public void user_validates_date_range_default_is_Last_90_days() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validatePaymentHistoryDateRageDefault();
	}

	@Then("^user validates default payment status selected option$")
	public void user_validates_Paid_status_check_box_is_checked() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validateDefaultPaymentStatusOption();
	}
	
	@Then("^user validates payment table includes the most recent Payment Date information$")
	public void user_validates_payment_table_includes_the_most_recent_Payment_Date_information() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validateDefaultPaymentTable();
	}

	@Then("^user validates total date range options available$")
	public void user_validates_total_date_range_options_available() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validateTotalDateRangeOptions();
	}
	
	@Then("^user validates nonCustomSearch date range options$")
	public void user_validates_nonCustomSearch_date_range_options() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validateNonCustomeSearchDateRangeOptions();
	}
	
	@Then("^user validates LEARN MORE ABOUT YOUR PAYMENT HISTORY link$")
	public void user_validates_LEARN_MORE_ABOUT_YOUR_PAYMENT_HISTORY_link() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validateLeanrMoreLink();
	}
	
	@Then("^user validates custom search with valid input$")
	public void user_validates_custom_search_with_valid_input() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validateValidCustomSearch();
	}
	
	@Then("^user validates error message for custom search with to date earlier than from date$")
	public void user_validates_error_message_for_custom_search_with_to_date_earlier_than_from_date() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validateErrorToEarlierThanFromCustomSearch();
	}
	
	@Then("^user validates error message for custom search with no dates selected$")
	public void user_validates_error_message_for_custom_search_with_no_dates_selected() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validateErrorNoDateSelectedCustomSearch();
	}

	@Then("^user validates error message for custom search with From and To date more than 24 months apart$")
	public void user_validates_error_message_for_custom_search_with_From_and_To_date_more_than_24_months_apart() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validateErrorMoreThan24MonthsApartSelectedCustomSearch();
	}

	@Then("^user validates only paid rows display when paid selected$")
	public void user_validates_only_paid_rows_display_according_to_selected_checkbox() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validateOnlyPaidOptionSelected();
	}
	
	@Then("^user validates only unpaid rows display when unpaid selected$")
	public void user_validates_only_unpaid_rows_display_according_to_selected_checkbox() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validateOnlyUnpaidOptionSelected();
	}	
	
	/*@Then("^user expands show payment history for supplement insurance plan section$")
	public void user_expands_show_payment_history_for_supplement_insurance_plan_section() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validatePaymentHistoryForSupplementInsurancePlan();
	}	*/
	
	@Then("^user validates download PDF for monthly bill PDF$")
	public void user_validates_download_Link_for_monthly_bill_PDF() throws Throwable {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		paymentHistoryPage.validatePDFDownloadLink();
	}
	// ^^^ note: added for F247601 Payment History SHIP testing	
	
	public static void checkForIPerceptionModel(WebDriver driver) {
		int counter = 0;
		do {
			System.out.println("current value of counter: " + counter);
			List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

			if (IPerceptionsFrame.isEmpty()) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			} else {
				driver.switchTo().frame(IPerceptionsFrame.get(0));
				driver.findElement(By.className("btn-no")).click();
				driver.switchTo().defaultContent();
			}
			counter++;
		} while (counter < 2);
	}
	
	@And("^the error is displayed on review payment page for second payment$")
	public void error_displayed_second_payment() throws InterruptedException {

		Thread.sleep(2000);
		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENT_PAGE);

		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = oneTimePaymentPage.errorForSecondPayment();
	    getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_PAGE, confirmOneTimePaymentPage);
	
		
	}
	
	@When("^user clicks on Federal Plan Tab$")
	public void userClicksOnFederalPlanTab() throws InterruptedException {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.Payments_History_Page);
		
		    paymentHistoryPage.navigateToFedTab();
			getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
				 
	}
	
	@And("^delete confirmation number GPS for recurring payment$")
	public void DeleterecurringPaymentRecord(DataTable givenAttributes) throws InterruptedException{
		System.out.println("******delete confirmation number GPS for recurring payment*****");
		List<DataTableRow> paymentTypeRow = givenAttributes.getGherkinRows();
		Map<String, String> paymentTypeMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < paymentTypeRow.size(); i++) {
			paymentTypeMap.put(paymentTypeRow.get(i).getCells().get(0),
					paymentTypeRow.get(i).getCells().get(1));
		}
		Thread.sleep(2000); 
		RecurringConfirmationPage recurringConfirmationPage = (RecurringConfirmationPage) getLoginScenario()
				.getBean(PageConstants.Recurring_Confirmation_Page);
		recurringConfirmationPage.deletePaymetnRecordFromGPS(paymentTypeMap);
	}
	
	@And("^the user delete recurring payment record from GPS so that he can run recurring payment again$")
	public void DeletePaymentRecord(DataTable givenAttributes) throws InterruptedException{
		System.out.println("******Trying to delete recurring payment record from GPS so that he can run recurring payment again*****");
		List<DataTableRow> paymentTypeRow = givenAttributes.getGherkinRows();
		Map<String, String> paymentTypeMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < paymentTypeRow.size(); i++) {
			paymentTypeMap.put(paymentTypeRow.get(i).getCells().get(0),
					paymentTypeRow.get(i).getCells().get(1));
		}
		Thread.sleep(2000); 
		
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENT_PAGE);
		
		confirmOneTimePaymentPage.deletePaymetnRecordFromGPS(paymentTypeMap);

		
	}
	
	@And("^Exception the user delete recurring payment record from GPS so that he can run recurring payment again$")
	public void DeletePaymentRecordforexception(DataTable givenAttributes) throws InterruptedException{
		System.out.println("******Trying to delete recurring payment record from GPS so that he can run recurring payment again*****");
		List<DataTableRow> paymentTypeRow = givenAttributes.getGherkinRows();
		Map<String, String> paymentTypeMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < paymentTypeRow.size(); i++) {
			paymentTypeMap.put(paymentTypeRow.get(i).getCells().get(0),
					paymentTypeRow.get(i).getCells().get(1));
		}
		Thread.sleep(2000); 
		
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENT_PAGE);
		String confirmationnumberfromPageConstant = (String)getLoginScenario().getBean(PageConstants.CONFIRMATION_NUMBER);
		System.out.println("Value of confirmation number from Page Constants is "+confirmationnumberfromPageConstant);
		confirmOneTimePaymentPage.deletePaymetnRecordFromGPSforexception(paymentTypeMap,confirmationnumberfromPageConstant);

		
	}
	
	@When("^user SHIP selects other amount and enters \"([^\"]*)\" and selects Checking Account and click on Next button$")
	public void user_selects_other_amount_and(
			String otherAmountvalue) throws Throwable {
		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.One_Time_Payments_Page);
		oneTimePaymentPage.selectAndEnterAmount(otherAmountvalue);
		PaymentsFormPage paymentsFormPage = oneTimePaymentPage.clickOnContuineButton();
		if (paymentsFormPage != null) {
			getLoginScenario().saveBean(PageConstants.Payments_Form_Page, paymentsFormPage);
			System.out.println("User is on One time EFT Payment Form Page");

		}
}
	
	@Given("^user SHIP Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA$")
	public void SHIP_Enters_all_Mandatory_fields_on_form_page_and_click_on_Authorize_button_for_Make_one_time_CA(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		PaymentsFormPage paymentsFormPage = (PaymentsFormPage) getLoginScenario()
				.getBean(PageConstants.Payments_Form_Page);
		OneTimePaymentPage oneTimePaymentPage = paymentsFormPage.EnterFiledsOnSetupEFTforShip(memberAttributesMap); 
		if (oneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_PAGE, oneTimePaymentPage);
			System.out.println("User is on Review payment page for Checking account");
		}

	}
	@Then("^SHIP User navigates to payment confirmation page and verifies ConfirmationNo for One time$")
	public void user_navigates_to_payment_confirmation_page_and_verifies_ConfirmationNo_for_SHIP() throws Throwable {
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE);
				confirmOneTimePaymentPage.OneTimeEFTverificationSHIP();		
		getLoginScenario().saveBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE, confirmOneTimePaymentPage);		
		getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_PAGE, confirmOneTimePaymentPage);


	}
	@Given("^user navigates to review your Automatic screen and selects agreements and click on cancel Button for EFT$")
	public void user_navigates_to_review_your_Automatic_screen_and_selects_agreements_and_click_on_cancel_Button_for_EFT()
			throws Throwable {
		ReviewAutomaticPage reviewAutomaticPage = (ReviewAutomaticPage) getLoginScenario()
				.getBean(PageConstants.Review_Automatic_Page);
		RecurringConfirmationPage recurringConfirmationPage = reviewAutomaticPage
				.selectAndClickCancelOnEFT();
	
}
	@Then("^user navigates to payment overview screen$")
	public void user_navigates_to_payment_overview_screen()
			throws Throwable {
		ReviewOneTimePaymentPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.Review_OneTime_Payments_Page);

		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = reviewOneTimePaymentsPage
				.DoNotselectAgreeAndClickOnMakePayment();
		if (confirmOneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_PAGE, confirmOneTimePaymentPage);
			System.out.println("User is on Review One time payments page");
			getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG,"false");

			Assert.assertTrue(true);
		}else {

			boolean Validation_Status =reviewOneTimePaymentsPage.validate_onlyOnePaymentRequest_Message();

			if(Validation_Status) {
				System.out.println("Only one payment request message is Displayed in review one time PAGE : " + Validation_Status + " - Validation Passed");
				getLoginScenario().saveBean(PageConstants.Review_OneTime_Payments_Page, reviewOneTimePaymentsPage);
				getLoginScenario().saveBean(PageConstants.ALREADY_ENROLLED_FLAG, "true");
				Assert.assertTrue(true);
			}else{
				System.out.println("Only one payment request message is NOT Displayed in review one time PAGE : "+Validation_Status);
				Assert.fail();
			}

		}
	}
	@Given("^user navigates to Review Your One-Time Payment Information$")
	public void user_navigates_to_Review_Your_One_Time_Payment_Information()
			throws Throwable {
		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENT_PAGE);
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = oneTimePaymentPage
				.DoNotselectAgreeAndClickOnSubmitPaymentsforOneTime();
		if (confirmOneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE, confirmOneTimePaymentPage);
			System.out.println("User is on One time confirmation page for Checking account");
		}
	}
	
	@And("^the user clicks on cancel button in One time EFT or Recurring EFT$")
	public void click_on_Cancel_btn() {		
	PaymentsFormPage paymentsFormPage = (PaymentsFormPage) getLoginScenario()
			.getBean(PageConstants.Payments_Form_Page);
	         paymentsFormPage.clickonCancelButton1();
	
	}
	
	@Given("^user navigates to review your Automatic screen and selects agreements for EFT$")
	public void user_navigates_to_review_your_Automatic_screen_and_selects_agreements()
			throws Throwable {
		ReviewAutomaticPage reviewAutomaticPage = (ReviewAutomaticPage) getLoginScenario()
				.getBean(PageConstants.Review_Automatic_Page);
		RecurringConfirmationPage recurringConfirmationPage = reviewAutomaticPage
				.selectAgreeAndnoClickOnAuthorizeMonthyPaymentsforEFT();
	
}
	@Given("^user navigates to review your Automatic screen and selects agreements for CC$")
	public void user_navigates_to_review_your_Automatic_screen_and_selects_agreements_CC()
			throws Throwable {
		ReviewAutomaticPage reviewAutomaticPage = (ReviewAutomaticPage) getLoginScenario()
				.getBean(PageConstants.Review_Automatic_Page);
		RecurringConfirmationPage recurringConfirmationPage = reviewAutomaticPage.selectAgreeAndnoClickOnContinueforCC();
		if (recurringConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.Recurring_Confirmation_Page, recurringConfirmationPage);
			System.out.println("User is on recurring confirmation page for CC");
		}
	}
	
}
