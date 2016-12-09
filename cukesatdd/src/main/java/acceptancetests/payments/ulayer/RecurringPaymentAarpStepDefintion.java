package acceptancetests.payments.ulayer;

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

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.AutomaticPaymentsPage;
import pages.member.ulayer.ConfirmSetupAutoPaymentPage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.OneTimePaymentsPage;
import pages.member.ulayer.PaymentHistoryPage;
import pages.member.ulayer.SetupAutoPaymentPage;
import pages.member.ulayer.SetupAutoPaymentSuccessPage;
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
public class RecurringPaymentAarpStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP with a planType member in AARP site$")
	public void registered_AMP_with_attributes_payment_rec_aarp(
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
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		
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

	@When("^the user views payment history in AARP site$")
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
			System.out.println("actual payment history JSON:: "
					+ paymentHistoryActualJson);
		}
		getLoginScenario().saveBean(
				PaymentCommonConstants.PAYMENT_HISTORY_ACTUAL,
				paymentHistoryActualJson);

		/*Validating payment History page data here*/
		try {
			JSONAssert.assertEquals(paymentHistoryExpectedJson,
					paymentHistoryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		

	}

	@And("^the user setups automatic payment by entering the following bank account information in AARP site$")
	public void setup_auto_payment_aarp(DataTable accountAttributes) {
		List<DataTableRow> accountAttributesRow = accountAttributes
				.getGherkinRows();
		Map<String, String> accountAttributessMap = new HashMap<String, String>();

		for (int i = 0; i < accountAttributesRow.size(); i++) {
			accountAttributessMap.put(accountAttributesRow.get(i).getCells()
					.get(0), accountAttributesRow.get(i).getCells().get(1));
		}
		
		PaymentHistoryPage paymentHistoryPage= (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		String businessType = (String) getLoginScenario().getBean(
				PaymentCommonConstants.BUSINESS_TYPE);
		
		SetupAutoPaymentPage setupAutoPaymentPage = paymentHistoryPage
				.navigateToSetupAutoPayments(businessType);
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

	@And("^the user confirms to setup recurring payment in AARP site$")
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

	@Then("^the user validates the confirmation success page for recurring payment in AARP site$")
	public void user_validates_confirmation_success_rec_payment_aarp() {
		SetupAutoPaymentSuccessPage setupAutoPaymentSuccessPage = (SetupAutoPaymentSuccessPage) getLoginScenario()
				.getBean(PageConstants.SETUP_PAYMENTS_SUCCESS_PAGE);

		JSONObject setupRecPaymentSuccessActualJson = (JSONObject) getLoginScenario()
				.getBean(PaymentCommonConstants.SETUP_PAYMENT_SUCCESS_ACTUAL);
		JSONObject setupRecPaymentSuccessExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PaymentCommonConstants.SETUP_PAYMENT_SUCCESS_EXPECTED);

		/*Validating Recurring payment success page data here*/
		try {
			JSONAssert.assertEquals(setupRecPaymentSuccessExpectedJson,
					setupRecPaymentSuccessActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		setupAutoPaymentSuccessPage.logOut();
	}
	
	@Given("^the user is on the AARP medicare site login page$")
	public void user_login_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	}
	
	@When("^the user logs in with a registered AMP with following details in AARP site$")
	public void user_logs_in(DataTable memberAttributes)
	{
		/* Reading the given attribute from feature file */
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

		Map<String,String> loginCreds = loginScenario
				.getAMPMemberWithDesiredAttributes(desiredAttributes);
		
		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a "+ desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd );
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}
		
		LoginPage loginPage = (LoginPage)getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		
		
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			JSONObject accountHomeActualJson = accountHomePage.accountHomeJson;
			getLoginScenario().saveBean(
					LoginCommonConstants.ACCOUNT_HOME_ACTUAL,
					accountHomeActualJson);
			
			/* Get expected data */
			Map<String, JSONObject> expectedDataMap = loginScenario
					.getExpectedJson(userName);
			JSONObject accountHomeExpectedJson = accountHomePage
					.getExpectedData(expectedDataMap);
			getLoginScenario().saveBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED,
					accountHomeExpectedJson);
	
	
	}

	}
	
	@And("^the user navigates to Automatic Payments page$")
	public void user_navigates_to_onw_time_payments()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		AutomaticPaymentsPage automaticPaymentsPage = accountHomePage.navigateToAutomaticPaymentsPage();
		if(automaticPaymentsPage!= null){
			Assert.assertTrue(true);
		} else {
			Assert.fail("automatic payments dashboard page not found");
		}
		
	}
	
	
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
