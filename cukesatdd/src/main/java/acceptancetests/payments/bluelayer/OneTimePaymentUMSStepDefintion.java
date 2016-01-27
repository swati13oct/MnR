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
import pages.member.bluelayer.ConfirmOneTimePaymentPage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.OneTimePaymentPage;
import pages.member.bluelayer.OneTimePaymentSuccessPage;
import pages.member.bluelayer.PaymentHistoryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.payments.data.PaymentCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */
public class OneTimePaymentUMSStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered UMS with a planType member in UMS site$")
	public void registered_AMP_with_attributes_payment(
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

	@When("^the user views payment history page in UMS site$")
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

		// get actual data
		JSONObject paymentHistoryActualJson = null;
		if (paymentHistoryPage != null) {
			getLoginScenario().saveBean(PageConstants.PAYMENT_HISTORY_PAGE,
					paymentHistoryPage);
			Assert.assertTrue(true);
			paymentHistoryActualJson = paymentHistoryPage.paymentHistoryJson;
		}

		System.out.println("paymentHistoryActualJson=====>"
				+ paymentHistoryActualJson.toString());
		System.out.println("paymentHistoryExpectedJson=====>"
				+ paymentHistoryExpectedJson.toString());
		try {
			JSONAssert.assertEquals(paymentHistoryExpectedJson,
					paymentHistoryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) paymentHistoryPage
				.navigateToOnetimePayment();
		if (oneTimePaymentPage != null) {
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_PAGE,
					oneTimePaymentPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Not Available");
		}

	}

	@And("^the user makes one time payment in UMS site$")
	public void makes_one_time_payment_aarp(DataTable accountAttributes) {
		List<DataTableRow> accountAttributesRow = accountAttributes
				.getGherkinRows();
		Map<String, String> accountAttributessMap = new HashMap<String, String>();

		for (int i = 0; i < accountAttributesRow.size(); i++) {
			accountAttributessMap.put(accountAttributesRow.get(i).getCells()
					.get(0), accountAttributesRow.get(i).getCells().get(1));
		}

		System.out.println("accountAttributessMap.." + accountAttributessMap);
		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENT_PAGE);
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

	@And("^the user confirms the payment in UMS site$")
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
		// get actual data
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

	@Then("^the user validates the payment successful page in UMS page$")
	public void user_validates_premium_payments_details() {
		OneTimePaymentSuccessPage oneTimePaymentSuccessPage = (OneTimePaymentSuccessPage) getLoginScenario()
				.getBean(PageConstants.ONE_TIME_PAYMENT_SUCCESS_PAGE);

		JSONObject oneTimePaymentSuccessActualJson = (JSONObject) getLoginScenario()
				.getBean(PaymentCommonConstants.ONE_TIME_PAYMENT_SUCCESS_ACTUAL);
		JSONObject oneTimePaymentSuccessExpectedJson = (JSONObject) getLoginScenario()
				.getBean(
						PaymentCommonConstants.ONE_TIME_PAYMENT_SUCCESS_EXPECTED);

		System.out.println("oneTimePaymentSuccessExpectedJson======>"
				+ oneTimePaymentSuccessExpectedJson.toString());
		System.out.println("oneTimePaymentSuccessActualJson======>"
				+ oneTimePaymentSuccessActualJson.toString());

		try {
			JSONAssert.assertEquals(oneTimePaymentSuccessExpectedJson,
					oneTimePaymentSuccessActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		oneTimePaymentSuccessPage.logOut();
	}
}
