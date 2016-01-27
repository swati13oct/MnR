package acceptancetests.payments.bluelayer;

import gherkin.formatter.model.DataTableRow;

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
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.ConfirmSetupAutoPaymentPage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.PaymentHistoryPage;
import pages.member.bluelayer.SetupAutoPaymentPage;
import pages.member.bluelayer.SetupAutoPaymentSuccessPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.payments.data.PaymentCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */
public class RecurringPaymentUMSStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered UMS with a planType member for recurring payment in UMS site$")
	public void registered_AMP_with_attributes_payment_rec_aarp(
			DataTable memberAttributes) {

		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);

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
			getLoginScenario()
					.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		AccountHomePage accountHomePage = null;
		if (memberAttributesMap.get("Category").equalsIgnoreCase("Individual")) {
			accountHomePage = (AccountHomePage) loginPage
					.checkLoginSuccessful(memberAttributesMap.get("Category"));
		} else {
			accountHomePage = (AccountHomePage) loginPage
					.checkLoginSuccessful();
		}
		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);
		// get actual
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		System.out.println("accountHomeActualJson=====>"
				+ accountHomeActualJson.toString());
		System.out.println("accountHomeExpectedJson=====>"
				+ accountHomeExpectedJson.toString());

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);
	}

	@When("^the user views payment history for recurring payment in UMS site$")
	public void user_views_payment_history_rec_aarp() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PaymentHistoryPage paymentHistoryPage = accountHomePage
				.navigateToPayments();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject paymentHistoryExpectedJson = paymentHistoryPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				PaymentCommonConstants.PAYMENT_HISTORY_EXPECTED,
				paymentHistoryExpectedJson);

		JSONObject paymentHistoryActualJson = null;
		if (paymentHistoryPage != null) {
			getLoginScenario().saveBean(PageConstants.PAYMENT_HISTORY_PAGE,
					paymentHistoryPage);
			Assert.assertTrue(true);
			paymentHistoryActualJson = paymentHistoryPage.paymentHistoryJson;
		}
		getLoginScenario().saveBean(
				PaymentCommonConstants.PAYMENT_HISTORY_ACTUAL,
				paymentHistoryActualJson);
		System.out.println("paymentHistoryExpectedJson=====>"
				+ paymentHistoryExpectedJson.toString());
		System.out.println("paymentHistoryActualJson=====>"
				+ paymentHistoryActualJson.toString());

		/* Validating payment History page data here */
		try {
			JSONAssert.assertEquals(paymentHistoryExpectedJson,
					paymentHistoryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user setups automatic payment by entering the following bank account information in UMS site$")
	public void setup_auto_payment_aarp(DataTable accountAttributes) {
		List<DataTableRow> accountAttributesRow = accountAttributes
				.getGherkinRows();
		Map<String, String> accountAttributessMap = new HashMap<String, String>();

		for (int i = 0; i < accountAttributesRow.size(); i++) {
			accountAttributessMap.put(accountAttributesRow.get(i).getCells()
					.get(0), accountAttributesRow.get(i).getCells().get(1));
		}

		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		SetupAutoPaymentPage setupAutoPaymentPage = paymentHistoryPage
				.navigateToSetupAutoPayments();
		if (setupAutoPaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.SETUP_AUTO_PAYMENTS_PAGE,
					setupAutoPaymentPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Not Available");
		}

		ConfirmSetupAutoPaymentPage confirmSetupAutoPaymentPage = setupAutoPaymentPage
				.enterPaymentDetails(accountAttributessMap);
		if (confirmSetupAutoPaymentPage != null) {
			getLoginScenario().saveBean(
					PageConstants.CONFIRM_SETUP_PAYMENTS_PAGE,
					confirmSetupAutoPaymentPage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Entered payment Details are wrong");
		}
	}

	@And("^the user confirms to setup recurring payment in UMS site$")
	public void confirms_setup_rec_payment_aarp() {
		ConfirmSetupAutoPaymentPage confirmSetupAutoPaymentPage = (ConfirmSetupAutoPaymentPage) getLoginScenario()
				.getBean(PageConstants.CONFIRM_SETUP_PAYMENTS_PAGE);
		SetupAutoPaymentSuccessPage setupAutoPaymentSuccessPage = confirmSetupAutoPaymentPage
				.confirmsPayment();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject setupRecPaymentSuccessExpectedJson = setupAutoPaymentSuccessPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				PaymentCommonConstants.SETUP_PAYMENT_SUCCESS_EXPECTED,
				setupRecPaymentSuccessExpectedJson);

		JSONObject setupRecPaymentSuccessActualJson = null;
		if (setupAutoPaymentSuccessPage != null) {
			getLoginScenario().saveBean(
					PageConstants.SETUP_PAYMENTS_SUCCESS_PAGE,
					setupAutoPaymentSuccessPage);
			Assert.assertTrue(true);
			setupRecPaymentSuccessActualJson = setupAutoPaymentSuccessPage.setupRecPaymentSuccessJson;
		}

		getLoginScenario().saveBean(
				PaymentCommonConstants.SETUP_PAYMENT_SUCCESS_ACTUAL,
				setupRecPaymentSuccessActualJson);

	}

	@Then("^the user validates the confirmation success page for recurring payment in UMS site$")
	public void user_validates_confirmation_success_rec_payment_aarp() {
		SetupAutoPaymentSuccessPage setupAutoPaymentSuccessPage = (SetupAutoPaymentSuccessPage) getLoginScenario()
				.getBean(PageConstants.SETUP_PAYMENTS_SUCCESS_PAGE);

		JSONObject setupRecPaymentSuccessActualJson = (JSONObject) getLoginScenario()
				.getBean(PaymentCommonConstants.SETUP_PAYMENT_SUCCESS_ACTUAL);
		JSONObject setupRecPaymentSuccessExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PaymentCommonConstants.SETUP_PAYMENT_SUCCESS_EXPECTED);

		System.out.println("setupRecPaymentSuccessExpectedJson=====>"
				+ setupRecPaymentSuccessExpectedJson.toString());
		System.out.println("setupRecPaymentSuccessActualJson=====>"
				+ setupRecPaymentSuccessActualJson.toString());
		/* Validating Recurring payment success page data here */
		try {
			JSONAssert.assertEquals(setupRecPaymentSuccessExpectedJson,
					setupRecPaymentSuccessActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		setupAutoPaymentSuccessPage.logOut();
	}

}
