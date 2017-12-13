package acceptancetests.payments.ulayer.onetimepayment;

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
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.ConfirmOneTimePaymentPage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.OneTimePaymentPage;
import pages.member.ulayer.OneTimePaymentPageSubmitted;
import pages.member.ulayer.OneTimePaymentSuccessPage;
import pages.member.ulayer.OneTimePaymentsPage;
import pages.member.ulayer.PaymentHistoryPage;
import pages.member.ulayer.PaymentsOverview;
import pages.member.ulayer.RallyDashboard;
import pages.member.ulayer.ReviewOneTimePaymentsPage;
import pages.member.ulayer.TeamCLoginUlayerPayments;
import pages.member.ulayer.TeamHLoginUlayer;
import pages.member.ulayer.TestHarness;
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
	
	
	@And("^the user makes one time payment in AARP site by entering required details$")
	public void makes_one_time_payment_required_details(DataTable accountAttributes) {
		List<DataTableRow> accountAttributesRow = accountAttributes
				.getGherkinRows();
		Map<String, String> accountAttributessMap = new HashMap<String, String>();

		for (int i = 0; i < accountAttributesRow.size(); i++) {
			accountAttributessMap.put(accountAttributesRow.get(i).getCells()
					.get(0), accountAttributesRow.get(i).getCells().get(1));
		}

		System.out.println("accountAttributessMap.." + accountAttributessMap);
		

		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage)getLoginScenario().getBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage =  oneTimePaymentsPage.enterAllPaymentDetails(accountAttributessMap);
		if(reviewOneTimePaymentsPage != null){
			getLoginScenario().saveBean(PageConstants.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("one time payments dashboard page not found");
		}	
	}
	
	@And("^the user confirms the values in AARP site$")
	public void makes_one_time_payment_required_details(){
		ReviewOneTimePaymentsPage reviewoneTimePaymentsPage = (ReviewOneTimePaymentsPage)getLoginScenario().getBean(PageConstants.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		//OneTimePaymentSuccessPage onetimePaymentsSuccessPage = reviewoneTimePaymentsPage.validateValues();
		ReviewOneTimePaymentsPage onetimePaymentsSuccessPage = reviewoneTimePaymentsPage.validateValues();
		if(onetimePaymentsSuccessPage != null){
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENT_SUCCESS_PAGE,
					onetimePaymentsSuccessPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Review success dashboard page not found");
		}	
	}
	
	@Then("^the user validates the One Time Payment Submitted successfull page$")
	public void Payment_success_page() throws InterruptedException{		
		ReviewOneTimePaymentsPage onetimePaymentsSuccessPage = (ReviewOneTimePaymentsPage )getLoginScenario().getBean(PageConstants.ONE_TIME_PAYMENT_SUCCESS_PAGE);
		ReviewOneTimePaymentsPage OneTimePaymentSubmittedValidation = onetimePaymentsSuccessPage.validateOTPSubmittedPageValues();
				if(OneTimePaymentSubmittedValidation != null){	
			Assert.assertTrue(true);
		}else {
			Assert.fail("One Time Payments Submitted dashboard page not found");
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
	
	@Given("^the user is on the AARP medicare site login page$")
	public void user_login_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	}
	
	@Given("^the user is on the Team-H AARP medicare site login page$")
	public void user_TeamHlogin_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		TeamHLoginUlayer THloginPage = new TeamHLoginUlayer(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);
	}
	
	@Given("^the user is on the Team-C AARP medicare site login page$")
	public void user_TeamClogin_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		TeamCLoginUlayerPayments THloginPage = new TeamCLoginUlayerPayments(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);
	}
	
	@Given("^the user is on the AARP medicare site login page and has already done one time payment for the day$")
	public void user_Payment_done()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		
		wd.manage().deleteAllCookies();
		System.out.println("Cookie cleared");
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
	
	@When("^the user logs in TeamH with a registered AMP with following details in AARP site$")
	public void user_logs_inTeamH(DataTable memberAttributes) throws InterruptedException
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
		
		TeamHLoginUlayer loginPage = (TeamHLoginUlayer)getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
		//TestHarness TestHarn = (TestHarness) loginPage.loginWith(userName, pwd);
		//AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		
		RallyDashboard RallyDB = (RallyDashboard) loginPage.loginWith(userName, pwd);
		
		
		if (RallyDB != null) {
			getLoginScenario().saveBean(PageConstants.Rally_Dashboard,
					RallyDB);
			Assert.assertTrue(true);
			/*JSONObject accountHomeActualJson = TestHarn.accountHomeJson;
			getLoginScenario().saveBean(
					LoginCommonConstants.ACCOUNT_HOME_ACTUAL,
					accountHomeActualJson);*/
			
			/* Get expected data 
			Map<String, JSONObject> expectedDataMap = loginScenario
					.getExpectedJson(userName);
			JSONObject accountHomeExpectedJson = accountHomePage
					.getExpectedData(expectedDataMap);
			getLoginScenario().saveBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED,
					accountHomeExpectedJson);*/
	
	
	}

	}
	
	
	@When("^the user logs in TeamC with a registered AMP with following details in AARP site$")
	public void user_logs_inTeamC(DataTable memberAttributes) throws InterruptedException
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
		
		TeamCLoginUlayerPayments loginPage = (TeamCLoginUlayerPayments)getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		Thread.sleep(25000);
		
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			/*Assert.assertTrue(true);
			JSONObject accountHomeActualJson = accountHomePage.accountHomeJson;	*/	
	
	}

	}
	
	@And("^the user navigates to TestHarness Page$")
	public void user_navigates_to_TestHarness_page()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		TestHarness testHarness = accountHomePage.navigateToTestHarnesspage();
		if(testHarness!= null){
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE,
					testHarness);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Test Harness page not found");
		}
		
	}
	
	@And("^the user navigates to Team-h TestHarness Page$")
	public void user_navigates_to_TeamHTestHarness_page()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		TestHarness testHarness = accountHomePage.navigateToTeamHTestHarnesspage();
		if(testHarness!= null){
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE,
					testHarness);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Test Harness page not found");
		}
		
	}
	
	
	@And("^the user navigates to Team-c TestHarness Page$")
	public void user_navigates_to_TeamC_TestHarness_page()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		TestHarness testHarness = accountHomePage.navigateToTeamCTestHarnesspage();
		if(testHarness!= null){
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE,
					testHarness);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Test Harness page not found");
		}
		
	}
	
	
	@And("^the user navigates to PaymentOverview Page$")
	public void user_navigates_to_PaymentOverview_Page()
	{
		TestHarness testHarness = (TestHarness)getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
		PaymentsOverview paymentsOverview = testHarness.navigateToPaymentOverview();
		if(paymentsOverview!= null){
			getLoginScenario().saveBean(PageConstants.PAYMENT_OVERVIEW,
					paymentsOverview);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}
		
	}
	
	@And("^the user navigates to Stage PaymentOverview Page$")
	public void user_navigates_to_TeamHPaymentOverview_Page() throws InterruptedException
	{
		//TestHarness testHarness = (TestHarness)getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
		Thread.sleep(20000);
		RallyDashboard RDB = (RallyDashboard)getLoginScenario().getBean(PageConstants.Rally_Dashboard );
		PaymentsOverview paymentsOverview = RDB.navigateToPaymentOverview();
		Thread.sleep(2000);
		if(paymentsOverview!= null){
			getLoginScenario().saveBean(PageConstants.PAYMENT_OVERVIEW,
					paymentsOverview);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}
		
	}
	
	
	@And("^the user navigates to TeamCPaymentOverview Page$")
	public void user_navigates_to_TeamCPaymentOverview_Page()
	{
		TestHarness testHarness = (TestHarness)getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
		PaymentsOverview paymentsOverview = testHarness.navigateToTeamCPaymentOverview();
		if(paymentsOverview!= null){
			getLoginScenario().saveBean(PageConstants.PAYMENT_OVERVIEW,
					paymentsOverview);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}
		
	}
	
	
	
	@And("^the user navigates to One Time Payments page$")
	public void user_navigates_to_one_time_payments()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage.navigateToOneTimePaymentsPage();
		if(oneTimePaymentsPage!= null){
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
		
	}
	
	/*@And("^the user navigates to Team H One Time Payments page$")
	public void user_navigates_to_TeamH_one_time_payments() throws InterruptedException
	{
		PaymentsOverview accountHomePage = (PaymentsOverview)getLoginScenario().getBean(PageConstants.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage.navigateToOneTimePaymentpage();
		if(oneTimePaymentsPage!= null){
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
		
	}
	*/
	
	@And("^user lands on payment overview page validates the tabs for combo members$")
	public void user_validates_Tabs() throws InterruptedException
	{
		PaymentsOverview accountHomePage = (PaymentsOverview)getLoginScenario().getBean(PageConstants.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage.navigateToOneTimePaymentpage();
		if(oneTimePaymentsPage!= null){
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
		
	}
	
	@And("^user unchecks paid and unpaid checkbox and validates the result$")
	public void user_validates_paid_unpaid_results() throws InterruptedException
	{
		PaymentsOverview accountHomePage = (PaymentsOverview)getLoginScenario().getBean(PageConstants.PAYMENT_OVERVIEW);
		PaymentsOverview oneTimePaymentsPage = accountHomePage.UnselectPaidUnpaidCheck();
		if(oneTimePaymentsPage!= null){
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("issue with paid unpaid checkbox");
		}
		
	}
	
	
	@And("^the user navigates to Team H One Time Payments page$")
	public void user_validates_TeamH_Payment_overview() throws InterruptedException
	{
		PaymentsOverview accountHomePage = (PaymentsOverview)getLoginScenario().getBean(PageConstants.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage.navigateToOneTimePaymentpage();
		if(oneTimePaymentsPage!= null){
			getLoginScenario().saveBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
		
	}
	
	@And("^the user navigates to Team H Automatic Payments page$")
	public void user_validates_TeamHAuto_Payment_overview() throws InterruptedException
	{
		PaymentsOverview accountHomePage = (PaymentsOverview)getLoginScenario().getBean(PageConstants.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage.navigateToAutoPaymentpage();
		if(oneTimePaymentsPage!= null){
			getLoginScenario().saveBean(PageConstants.AUTOMATIC_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
		
	}
	
	
	@And("^the user enters details and click on continue button on One Time Payments Page for Dashboard$")
	public void user_clicks_and_navigates_to_Review_page() throws InterruptedException
	{
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage)getLoginScenario().getBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.enterInfoAndContinue();
		if(reviewOneTimePaymentsPage != null){
			getLoginScenario().saveBean(PageConstants.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("one time payments dashboard page not found");
		}		
	}
	
	
	@And("^the user enters details and click on continue button on Automatic Payments Page for Dashboard$")
	public void user_clicks_AutoPay_and_navigates_to_Review_page() throws InterruptedException
	{
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage)getLoginScenario().getBean(PageConstants.AUTOMATIC_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.AutoenterInfoAndContinue();
		if(reviewOneTimePaymentsPage != null){
			getLoginScenario().saveBean(PageConstants.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("one time payments dashboard page not found");
		}		
	}
	
	@And("^user lands on Review One time Payments Page and navigates to OTP Submitted Page$")
	public void Review_OneTime_Payment_Navigation_to_OTPSubmitted() throws InterruptedException
	{
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage)getLoginScenario().getBean(PageConstants.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		OneTimePaymentPageSubmitted OTPSubmitted = reviewOneTimePaymentsPage.navigateToOTPSubmittedPage();
		Thread.sleep(1000);
		if(OTPSubmitted != null){
			getLoginScenario().saveBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE,
					OTPSubmitted);
			Assert.assertTrue(true);
		}else {
			Assert.fail("OTP Submitted page not found");
		}		
	}

	
	@Then("^user lands on Review One time Payments Page and validates one payment per day error message$")
	public void One_Payment_Per_Day_Error() throws InterruptedException
	{
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage)getLoginScenario().getBean(PageConstants.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage OTPError = reviewOneTimePaymentsPage.ValidateOnePaymentPerDayErrorMessage();
		Thread.sleep(1000);
		if(OTPError != null){
			getLoginScenario().saveBean(PageConstants.ONE_PAYMENT_PER_DAY_ERROR_MESSAGE,
					OTPError);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Error message not validated");
		}		
	}
	
	@Then("^the user lands on OneTime Payment Submitted Page and validates PDF link$")
	public void OneTime_payment_SubmittedPage()	{
		
		OneTimePaymentPageSubmitted OTPSubmitted = (OneTimePaymentPageSubmitted)getLoginScenario().getBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		OneTimePaymentPageSubmitted PDFValidation = OTPSubmitted.ValidatePDFLink();
		if(PDFValidation != null){
			getLoginScenario().saveBean(PageConstants.PDF_LINK,
					PDFValidation);
			Assert.assertTrue(true);
		}else {
			Assert.fail("PDF Link not found");
		}		
		
	}
	
	@Then("^the user lands on OneTime Payment Submitted Page and validates Payment Amount and Member Name$")
	public void OTP_SubmittedPage_Validations() throws InterruptedException	{
		
		OneTimePaymentPageSubmitted OTPSubmitted = (OneTimePaymentPageSubmitted)getLoginScenario().getBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		Thread.sleep(2000);
		OneTimePaymentPageSubmitted PaymentAmount = OTPSubmitted.ValidatePaymentAmount();
		OneTimePaymentPageSubmitted MemberName = OTPSubmitted.ValidateMemberName();
		if(PaymentAmount != null){
			getLoginScenario().saveBean(PageConstants.PAYMENT_AMOUNT,
					PaymentAmount);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Payment Amount not found");
		}		
		
		if(MemberName != null){
			getLoginScenario().saveBean(PageConstants.MEMBER_NAME,
					MemberName);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Member name not found");
		}
		
	}
	
	@Then("^the user lands on OneTime Payment Submitted Page and validates Timestamp$")
	public void OTP_SubmittedPage_Timestamp() throws InterruptedException	{
		
		OneTimePaymentPageSubmitted OTPSubmitted = (OneTimePaymentPageSubmitted)getLoginScenario().getBean(PageConstants.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		Thread.sleep(2000);
		OneTimePaymentPageSubmitted Timestamp = OTPSubmitted.ValidateTimeStamp();		
		if(Timestamp != null){
			getLoginScenario().saveBean(PageConstants.TIMESTAMP,
					Timestamp);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Payment Amount not found");
		}		
	}
	
	
	@And("^the user enters details without clicking checkbox and clicks on continue button on OTP Page for Dashboard$")
	public void user_continueswithoutCheckbox()
	{
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage)getLoginScenario().getBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.enterInfoWithoutCheckBoxAndContinue();
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPagechkbox = oneTimePaymentsPage.errorMessagechkBox();
		if(reviewOneTimePaymentsPage != null){
			getLoginScenario().saveBean(PageConstants.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("one time payments dashboard page not found");
		}		
		
	}
	
	@And("^the user clicks on cancel button on OTP Page and validates title$")
	public void user_clicks_cancel_button()
	{
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage)getLoginScenario().getBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.CancelButton();		
		if(reviewOneTimePaymentsPage != null){
			getLoginScenario().saveBean(PageConstants.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("one time payments dashboard page not found");
		}		
		
	}
	
	@Then("^user validates the Payment History Page$")
	public void user_validates_Payment_History_PageDetails() {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage)getLoginScenario().getBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage.HistoryPageValidation();		
		if(reviewOneTimePaymentsPage != null){
			getLoginScenario().saveBean(PageConstants.PAYMENT_HISTORY_PAGE,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("one time payments dashboard page not found");
		}		
	}
	
	
	@Then("^user lands on Review One time Payments Page and validates the amount and routing number values$")
	public void review_onetime_payments_validation()
	{
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage)getLoginScenario().getBean(PageConstants.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		JSONObject reviewOneTimeActual = reviewOneTimePaymentsPage.reviewOneTimeValues();
		/* Get expected data */
		String fileName = "reviewonetimeexpected";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator
				+ PaymentCommonConstants.ONE_TIME_PAYMENTS_FLOW_NAME
				+ File.separator;
		JSONObject reviewOneTimeExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				PaymentCommonConstants.ONE_TIME_PAYMENTS_ACTUAL,
				reviewOneTimeActual);
		getLoginScenario().saveBean(
				PaymentCommonConstants.ONE_TIME_PAYMENTS_EXPECTED,
				reviewOneTimeExpectedJson);
			
		System.out.println("reviewOneTimeActual---->" + reviewOneTimeActual);
		System.out.println("reviewOneTimeExpectedJson---->" + reviewOneTimeExpectedJson); 
		
		try {
			JSONAssert.assertEquals(reviewOneTimeExpectedJson, reviewOneTimeActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@And("^the user clicks on cancel button on Review Payments Page and validates payments history page$")
	public void user_clicks_cancelbtn_onOnetimePaymentPage()
	{
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage)getLoginScenario().getBean(PageConstants.ONE_TIME_PAYMENTS_DASHBOARD);
		OneTimePaymentPage reviewOneTimePaymentsPage = oneTimePaymentsPage.onetimepagecancelbtn();
	}
}
