package acceptancetests.payments.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.ConfirmOneTimePaymentPage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.OneTimePaymentPage;
import pages.member.ulayer.OneTimePaymentSuccessPage;
import pages.member.ulayer.PaymentHistoryPage;
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
 * @author pperugu
 *
 */
public class OneTimePaymentAarpStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AARP with a planType member for AARP site$")
	public void registered_AMP_with_attributes_payment(
			DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();

		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		String planType = desiredAttributes.get(0);
		String businessType = null;
		if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")
				|| planType.equalsIgnoreCase("PDP")) {
			businessType = "GOVT";
		} else {
			businessType = "SHIP";
		}
		getLoginScenario().saveBean(PaymentCommonConstants.BUSINESS_TYPE,
				businessType);

		Map<String, String> loginCreds = loginScenario
				.getAMPMemberWithDesiredAttributes(desiredAttributes);

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
		getLoginScenario().saveBean("webDriver", wd);

		LoginPage loginPage = new LoginPage(wd);
		loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		AccountHomePage accountHomePage = (AccountHomePage) loginPage
				.checkLoginSuccessful();
		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);

	}

	@When("^the user views payment history$")
	public void user_views_payment_history() {
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
			System.out.println("actual payment history JSON:: "
					+ paymentHistoryActualJson);
		}

		getLoginScenario().saveBean(
				PaymentCommonConstants.PAYMENT_HISTORY_ACTUAL,
				paymentHistoryActualJson);

		try {
			JSONAssert.assertEquals(paymentHistoryExpectedJson,
					paymentHistoryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user makes one time payment in AARP site$")
	public void makes_one_time_payment_aarp(DataTable accountAttributes) {
		List<DataTableRow> accountAttributesRow = accountAttributes
				.getGherkinRows();
		Map<String, String> accountAttributessMap = new HashMap<String, String>();

		for (int i = 0; i < accountAttributesRow.size(); i++) {
			accountAttributessMap.put(accountAttributesRow.get(i).getCells()
					.get(0), accountAttributesRow.get(i).getCells().get(1));
		}

		System.out.println("accountAttributessMap.." + accountAttributessMap);

		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		String businessType = (String) getLoginScenario().getBean(
				PaymentCommonConstants.BUSINESS_TYPE);

		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) paymentHistoryPage
				.navigateToOnetimePayment(businessType);
		if (oneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_PAGE,
					oneTimePaymentPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Not Available");
		}

		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = oneTimePaymentPage
				.enterPaymentDetails(accountAttributessMap);
		if (confirmOneTimePaymentPage != null) {
			getLoginScenario().saveBean(
					PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE,
					confirmOneTimePaymentPage);
			Assert.assertTrue(true);
		}

		else {
			Assert.fail("Entered payment Details are wrong");
		}

	}

	@And("^the user confirms the payment in AARP site$")
	public void confirms_payment_aarp() {
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		OneTimePaymentSuccessPage oneTimePaymentSuccessPage = confirmOneTimePaymentPage
				.confirmsPayment();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject oneTimePaymentSuccessExpectedJson = oneTimePaymentSuccessPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				PaymentCommonConstants.ONE_TIME_PAYMENT_SUCCESS_EXPECTED,
				oneTimePaymentSuccessExpectedJson);

		JSONObject oneTimePaymentSuccessActualJson = null;
		if (oneTimePaymentSuccessPage != null) {
			getLoginScenario().saveBean(
					PageConstants.ONE_TIME_PAYMENT_SUCCESS_PAGE,
					oneTimePaymentSuccessPage);
			Assert.assertTrue(true);
			oneTimePaymentSuccessActualJson = oneTimePaymentSuccessPage.oneTimePaymentSuccessJson;
		}

		getLoginScenario().saveBean(
				PaymentCommonConstants.ONE_TIME_PAYMENT_SUCCESS_ACTUAL,
				oneTimePaymentSuccessActualJson);

	}

	@Then("^the user validates the payment successful page$")
	public void user_validates_premium_payments_details() {
		OneTimePaymentSuccessPage oneTimePaymentSuccessPage = (OneTimePaymentSuccessPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENT_SUCCESS_PAGE);

		JSONObject oneTimePaymentSuccessActualJson = (JSONObject) getLoginScenario()
				.getBean(PaymentCommonConstants.ONE_TIME_PAYMENT_SUCCESS_ACTUAL);
		JSONObject oneTimePaymentSuccessExpectedJson = (JSONObject) getLoginScenario()
				.getBean(
						PaymentCommonConstants.ONE_TIME_PAYMENT_SUCCESS_EXPECTED);

		try {
			JSONAssert.assertEquals(oneTimePaymentSuccessExpectedJson,
					oneTimePaymentSuccessActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		oneTimePaymentSuccessPage.logOut();
	}
}
