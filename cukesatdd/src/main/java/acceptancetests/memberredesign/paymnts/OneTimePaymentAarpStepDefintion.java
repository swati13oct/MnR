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
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import pages.dashboard.eob.EOBPage;

import pages.member.bluelayer.DashboardPage;
import pages.member.redesign.MemberAuthLoginPage;
import pages.member.redesign.MemberSearchPage;
import pages.member.redesign.NewLoginPage;

import pages.member.ulayer.LoginPage;
import pages.member.ulayer.OneTimePaymentPageSubmitted;
import pages.member.ulayer.OneTimePaymentsPage;
import pages.member.ulayer.PaymentsOverview;
import pages.member.ulayer.RallyDashboard;
import pages.member.ulayer.ReviewOneTimePaymentsPage;
import pages.member.ulayer.TeamCLoginUlayerPayments;
import pages.member.ulayer.TeamHLoginUlayer;
import pages.member.ulayer.TestHarness;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.accounthomepage.AccountHomePage;
//import pages.regression.payments.AccountHomePage;
import pages.regression.payments.ConfirmOneTimePaymentPage;
import pages.regression.payments.OneTimePaymentPage;
import pages.regression.payments.OneTimePaymentSuccessPage;
import pages.regression.payments.PaymentHistoryPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.memberredesign.paymnts.PaymentCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
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
	public void registered_AMP_with_attribute_payments(DataTable memberAttributes) throws InterruptedException{
		//get the required parameters from the feature files
				WebDriver wd = getLoginScenario().getWebDriver();
				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
				List<DataTableRow> memberAttributesRow = memberAttributes
						.getGherkinRows();
				Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
				for (int i = 0; i < memberAttributesRow.size(); i++) {

					memberAttributesMap.put(memberAttributesRow.get(i).getCells()
							.get(0), memberAttributesRow.get(i).getCells().get(1));
				}

				String category = memberAttributesMap.get("Member Type");

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
					getLoginScenario()
					.saveBean(LoginCommonConstants.USERNAME, userName);
					getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, password);
					getLoginScenario().saveBean(LoginCommonConstants.CATOGERY, category);
				}
				NewLoginPage newloginpage = new NewLoginPage(wd);
				//NewLoginPage paymenthistory = (NewLoginPage).loginWith(userName, password);
				DashboardPage dashboardpage = (DashboardPage) newloginpage.loginWith(userName, password);
				//DashboardPage.loginWith(userName, password);
				
		        if (dashboardpage != null) {
		        	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		        	getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARDPAGE, dashboardpage);
		        }

	}
	@Then("^the user navigates to payment history$")
	public void user_views_payment_history() throws InterruptedException {		
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
		pages.redesign.PaymentHistoryPage paymentHistoryPage = accountHomePage.navigateToPaymentHistoryPage();
					
		 //PaymentHistoryPage paymenthistory = PaymentHis
      if (paymentHistoryPage!=null){
    	     	  getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
			System.out.println("user is on one time payment page"); 
      }	

	}
	
	@When("^the user navigates to Recurring payment history$")
	public void user_views_Recurring_payment_history() throws InterruptedException {
		pages.regression.accounthomepage.AccountHomePage AHPage = (pages.regression.accounthomepage.AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		AHPage = AHPage.navigateToAutoPaymentHistoryPage();
		
      if (AHPage!=null){
    	     	  getLoginScenario().saveBean(PageConstants.DashPage, AHPage);
			System.out.println("User is on Recurring Payment History");
      }
      
	}
	
	@Then("^User Scrolls down to validate Payment History and Scrolls up$")
	public void Validate_History_Payment() throws InterruptedException{
		pages.regression.accounthomepage.AccountHomePage AHPage = (pages.regression.accounthomepage.AccountHomePage) getLoginScenario().getBean(PageConstants.DashPage);
		PaymentHistoryPage paymentHistoryPage = AHPage.scrollDownAndUp();
		if (paymentHistoryPage!=null){
	     	  getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
		System.out.println("user has scrolled up"); 
}
	}
	
	
	@And("^the user clicks on Make One Time Payment button$")
		public void click_on_OTP_btn(){
			PaymentHistoryPage paymenthistory = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.Payments_History_Page);
			OneTimePaymentPage oneTimePayment = paymenthistory.OTPbtn();
			
			if(oneTimePayment!=null){
				getLoginScenario().saveBean(PageConstants.One_Time_Payments_Page, oneTimePayment);
				System.out.println("user is on one time payment page");	
			}
			
		}
	

	@And("^the user clicks on Edit Automatic Payment button$")
	public void click_on_Recurring_btn(){
		PaymentHistoryPage paymenthistory = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.Payments_History_Page);
		OneTimePaymentPage oneTimePayment = paymenthistory.AutoPay();
		
		if(oneTimePayment!=null){
			getLoginScenario().saveBean(PageConstants.One_Time_Payments_Page, oneTimePayment);
			System.out.println("user is on one time payment page");	
		}
		
	}	
	
	
	@And("^the user makes one time payment in AARP site$")
	public void makes_one_time_payment_aarp(DataTable givenAttributes) {
			
		
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
		    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		
		OneTimePaymentPage oneTimePayment = (OneTimePaymentPage) getLoginScenario().getBean(PageConstants.One_Time_Payments_Page);
		
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = oneTimePayment.enterPaymentDetails(memberAttributesMap);

		

		getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,confirmOneTimePaymentPage);

	}
	
	@And("^the user makes auto payment in AARP site$")
	public void makes_auto_payment_aarp(DataTable givenAttributes) {			
		
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
		    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}		
		
		OneTimePaymentPage oneTimePayment = (OneTimePaymentPage) getLoginScenario().getBean(PageConstants.One_Time_Payments_Page);
		
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = oneTimePayment.enterAutoPaymentDetails(memberAttributesMap);
		

		getLoginScenario().saveBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,confirmOneTimePaymentPage);

	}

	
	@And("^the user confirms the payment in AARP site$")
	public void confirms_payment_aarp() {
		ConfirmOneTimePaymentPage confirmOneTimePaymentsuccesspage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		OneTimePaymentSuccessPage oneTimePaymentSuccessPage = confirmOneTimePaymentsuccesspage
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
					PageConstantsMnR.ONE_TIME_PAYMENT_SUCCESS_PAGE,
					oneTimePaymentSuccessPage);
			Assert.assertTrue(true);
			oneTimePaymentSuccessActualJson = oneTimePaymentSuccessPage.oneTimePaymentSuccessJson;
		}

		getLoginScenario().saveBean(
				PaymentCommonConstants.ONE_TIME_PAYMENT_SUCCESS_ACTUAL,
				oneTimePaymentSuccessActualJson);

	}
	
	@And("^the user confirms the Autopayment in UHC site$")
	public void confirms_payment_uhc() throws InterruptedException {
		ConfirmOneTimePaymentPage confirmOneTimePaymentsuccesspage = (ConfirmOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);	
		
		ConfirmOneTimePaymentPage oneTimePaymentSuccessPage = confirmOneTimePaymentsuccesspage.confirmsAutoPayment();
        
		if (oneTimePaymentSuccessPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.ONE_TIME_PAYMENT_SUCCESS_PAGE,
					oneTimePaymentSuccessPage);
			Assert.assertTrue(true);
	}
		else
			System.out.println("Encountered More than one Payment per Business day error");
	}
	

	@And("^the user moves to Go to Payment History Page button$")
	public void Go_toPayment_History_page() throws InterruptedException{
		ConfirmOneTimePaymentPage oneTimePaymentSuccessPageScroll = (ConfirmOneTimePaymentPage) getLoginScenario().getBean(PageConstantsMnR.ONE_TIME_PAYMENT_SUCCESS_PAGE);
		PaymentHistoryPage paymentHistoryPage = oneTimePaymentSuccessPageScroll.ScrollDownToBackButton();
		if (paymentHistoryPage!=null){
	     	  getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
		System.out.println("user has reached back"); 
}
	}

	
	
	@And("^the user confirms the values in AARP site$")
	public void makes_one_time_payment_required_details() {	
 		ConfirmOneTimePaymentPage confirmOneTimePayPage =  (ConfirmOneTimePaymentPage) getLoginScenario()
 				.getBean(PageConstants.Review_OneTime_Page);
 		
 		confirmOneTimePayPage.confirmsPayment();
		if (confirmOneTimePayPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.ONE_TIME_PAYMENT_SUCCESS_PAGE,
					confirmOneTimePayPage);
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
	public void makes_one_time_payment_required_details(
			DataTable accountAttributes) {
		List<DataTableRow> accountAttributesRow = accountAttributes
				.getGherkinRows();
		Map<String, String> accountAttributessMap = new HashMap<String, String>();

		for (int i = 0; i < accountAttributesRow.size(); i++) {
			accountAttributessMap.put(accountAttributesRow.get(i).getCells()
					.get(0), accountAttributesRow.get(i).getCells().get(1));
		}

		System.out.println("accountAttributessMap.." + accountAttributessMap);

		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage
				.enterAllPaymentDetails(accountAttributessMap);
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
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

		LoginPage loginPage = (LoginPage) getLoginScenario().getBean(
				PageConstantsMnR.LOGIN_PAGE);
		pages.regression.accounthomepage.AccountHomePage accountHomePage = (AccountHomePage) loginPage
				.loginWith(userName, pwd);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,
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
			getLoginScenario().saveBean(
					LoginCommonConstants.ACCOUNT_HOME_EXPECTED,
					accountHomeExpectedJson);

		}

	}
	
	

	@When("^the user logs in TeamH with a registered AMP with following details in AARP site$")
	public void user_logs_inTeamH(DataTable memberAttributes)
			throws InterruptedException {
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

		TeamHLoginUlayer loginPage = (TeamHLoginUlayer) getLoginScenario()
				.getBean(PageConstantsMnR.LOGIN_PAGE);
		// TestHarness TestHarn = (TestHarness) loginPage.loginWith(userName,
		// pwd);
		// AccountHomePage accountHomePage = (AccountHomePage)
		// loginPage.loginWith(userName, pwd);

		RallyDashboard RallyDB = (RallyDashboard) loginPage.loginWith(userName,
				pwd);

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
	public void TimeStampTheSpartans_user_logs_inTeamH(
			DataTable memberAttributes) throws InterruptedException {
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

		TeamHLoginUlayer loginPage = (TeamHLoginUlayer) getLoginScenario()
				.getBean(PageConstantsMnR.LOGIN_PAGE);
		// TestHarness TestHarn = (TestHarness) loginPage.loginWith(userName,
		// pwd);
		// AccountHomePage accountHomePage = (AccountHomePage)
		// loginPage.loginWith(userName, pwd);

		RallyDashboard RallyDB = (RallyDashboard) loginPage.loginWith(userName,
				pwd);

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
	public void user_logs_inTeamC(DataTable memberAttributes)
			throws InterruptedException {
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

		TeamCLoginUlayerPayments loginPage = (TeamCLoginUlayerPayments) getLoginScenario()
				.getBean(PageConstantsMnR.LOGIN_PAGE);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage
				.loginWith(userName, pwd);
		Thread.sleep(25000);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,
					accountHomePage);
			/*
			 * Assert.assertTrue(true); JSONObject accountHomeActualJson =
			 * accountHomePage.accountHomeJson;
			 */

		}

	}

	





	@And("^the user navigates to PaymentOverview Page$")
	public void user_navigates_to_PaymentOverview_Page() {
		TestHarness testHarness = (TestHarness) getLoginScenario().getBean(
				PageConstantsMnR.TEST_HARNESS_PAGE);
		PaymentsOverview paymentsOverview = testHarness
				.navigateToPaymentOverview();
		if (paymentsOverview != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_OVERVIEW,
					paymentsOverview);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}

	}

	@And("^the user navigates to Stage PaymentOverview Page$")
	public void user_navigates_to_TeamHPaymentOverview_Page()
			throws InterruptedException {
		// TestHarness testHarness =
		// (TestHarness)getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
		Thread.sleep(20000);
		RallyDashboard RDB = (RallyDashboard) getLoginScenario().getBean(
				PageConstantsMnR.Rally_Dashboard);
		PaymentsOverview paymentsOverview = RDB.navigateToPaymentOverview();
		Thread.sleep(2000);
		if (paymentsOverview != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_OVERVIEW,
					paymentsOverview);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}

	}
	
	/**
	 * @todo : User clicks on payment option in global header and is taken to paymnet overview page 
	 */
	@And("^TimeStampTheSpartans the user navigates to Stage PaymentOverview Page$")
	public void TimeStampTheSpartans_user_navigates_to_TeamHPaymentOverview_Page()
			throws InterruptedException {
		// TestHarness testHarness =
		// (TestHarness)getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
		Thread.sleep(20000);
		RallyDashboard RDB = (RallyDashboard) getLoginScenario().getBean(
				PageConstantsMnR.Rally_Dashboard);
		PaymentsOverview paymentsOverview = RDB.navigateToPaymentOverview();
		Thread.sleep(2000);
		if (paymentsOverview != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_OVERVIEW,
					paymentsOverview);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}

	}

	@And("^the user navigates to TeamCPaymentOverview Page$")
	public void user_navigates_to_TeamCPaymentOverview_Page() {
		TestHarness testHarness = (TestHarness) getLoginScenario().getBean(
				PageConstantsMnR.TEST_HARNESS_PAGE);
		PaymentsOverview paymentsOverview = testHarness
				.navigateToTeamCPaymentOverview();
		if (paymentsOverview != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_OVERVIEW,
					paymentsOverview);
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
	 * (PageConstantsMnR.PAYMENT_OVERVIEW); OneTimePaymentsPage oneTimePaymentsPage
	 * = accountHomePage.navigateToOneTimePaymentpage();
	 * if(oneTimePaymentsPage!= null){
	 * getLoginScenario().saveBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD,
	 * oneTimePaymentsPage); Assert.assertTrue(true); } else {
	 * Assert.fail("one time payments dashboard page not found"); }
	 * 
	 * }
	 */

	@And("^user lands on payment overview page validates the tabs for combo members$")
	public void user_validates_Tabs() throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage
				.navigateToOneTimePaymentpage();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
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
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage
				.navigateToOneTimePaymentpage();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}
	
	@And("^user unchecks paid and unpaid checkbox and validates the result$")
	public void user_validates_paid_unpaid_results()
			throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		PaymentsOverview oneTimePaymentsPage = accountHomePage
				.UnselectPaidUnpaidCheck();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("issue with paid unpaid checkbox");
		}

	}
	
	/** 
	 * @todo : User chacks paid and unpaid results 
	 */	
	@And("^TimeStampTheSpartans user unchecks paid and unpaid checkbox and validates the result$")
	public void TimeStampTheSpartans_user_validates_paid_unpaid_results()
			throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		PaymentsOverview oneTimePaymentsPage = accountHomePage
				.UnselectPaidUnpaidCheck();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("issue with paid unpaid checkbox");
		}

	}

	@And("^the user navigates to Team H One Time Payments page$")
	public void user_validates_TeamH_Payment_overview()
			throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage
				.navigateToOneTimePaymentpage();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	/**
	 * @todo : User arrives at OneTimePayment page form
	 */
	@And("^TimeStampTheSpartans the user navigates to Team H One Time Payments page$")
	public void TimeStampTheSpartans_user_validates_TeamH_Payment_overview()
			throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage
				.navigateToOneTimePaymentpage();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}
	
	/**
	 * User is Taken to Automatic Payments page form
	 */
	@And("^TimeStampTheSpartans the user navigates to Team H Automatic Payments page$")
	public void TimeStampTheSpartans_user_validates_TeamHAuto_Payment_overview()
			throws InterruptedException {
		PaymentsOverview accountHomePage = (PaymentsOverview) getLoginScenario()
				.getBean(PageConstantsMnR.PAYMENT_OVERVIEW);
		OneTimePaymentsPage oneTimePaymentsPage = accountHomePage
				.navigateToAutoPaymentpage();
		if (oneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.AUTOMATIC_PAYMENTS_DASHBOARD,
					oneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	@And("^the user enters details and click on continue button on One Time Payments Page for Dashboard$")
	public void user_clicks_and_navigates_to_Review_page()
			throws InterruptedException {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage
				.enterInfoAndContinue();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}
	
	/**
	 * User Enters the required details and click on continue to see review page
	 */	
	@And("^TimeStampTheSpartans the user enters details and click on continue button on One Time Payments Page for Dashboard$")
	public void TimeStampTheSpartans_user_clicks_and_navigates_to_Review_page()
			throws InterruptedException {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage
				.enterInfoAndContinue();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}
	@And("^the user enters details and click on continue button on Automatic Payments Page for Dashboard$")
	public void user_clicks_AutoPay_and_navigates_to_Review_page()
			throws InterruptedException {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.AUTOMATIC_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage
				.enterInfoAndContinue();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}

	/**
	 * User enters details on Automatic Payments form and navigates to AutomaticPaymentsReview page
	 */
	@And("^TimeStampTheSpartans the user enters details and click on continue button on Automatic Payments Page for Dashboard$")
	public void TimeStampTheSpartans_user_clicks_AutoPay_and_navigates_to_Review_page()
			throws InterruptedException {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.AUTOMATIC_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage
				.enterInfoAndContinue();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}

	/**
	 * @todo : User Lands on Review one time payment page , slects the checkbox and continue to One time Payment Submitted page
	 */	
	@And("^TimeStampTheSpartans user lands on Review One time Payments Page and navigates to OTP Submitted Page$")
	public void Review_OneTime_Payment_Navigation_to_OTPSubmitted()
			throws InterruptedException {
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		OneTimePaymentPageSubmitted OTPSubmitted = reviewOneTimePaymentsPage
				.navigateToOTPSubmittedPage();
		Thread.sleep(1000);
		if (OTPSubmitted != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE, OTPSubmitted);
			Assert.assertTrue(true);
		} else {
			Assert.fail("OTP Submitted page not found");
		}
	}

/*	@And("^user lands on Review One time Payments Page and navigates to Review Submitted Page$")
	public void Review_OneTime_Payment_Navigation_to_ReviewSubmitted()
			throws InterruptedException {
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		OneTimePaymentPageSubmitted OTPSubmitted = reviewOneTimePaymentsPage
				.navigateToReviewSubmittedPage();
		Thread.sleep(1000);
		if (OTPSubmitted != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE, OTPSubmitted);
			Assert.assertTrue(true);
		} else {
			Assert.fail("OTP Submitted page not found");
		}
	}
	
	*//**
	 * User is on Review Automatic payments page, checks the electronic signature box and move to Submit Page
	 *//*
	@And("^TimeStampTheSpartans user lands on Review Automatic Payments Page and navigates to Review Submitted Page$")
	public void TimeStampTheSpartans_Review_OneTime_Payment_Navigation_to_ReviewSubmitted()
			throws InterruptedException {
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		OneTimePaymentPageSubmitted OTPSubmitted = reviewOneTimePaymentsPage
				.navigateToReviewSubmittedPage();
		Thread.sleep(1000);
		if (OTPSubmitted != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE, OTPSubmitted);
			Assert.assertTrue(true);
		} else {
			Assert.fail("OTP Submitted page not found");
		}
	}*/

	@Then("^user lands on Review One time Payments Page and validates one payment per day error message$")
	public void One_Payment_Per_Day_Error() throws InterruptedException {
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage OTPError = reviewOneTimePaymentsPage
				.ValidateOnePaymentPerDayErrorMessage();
		Thread.sleep(1000);
		if (OTPError != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.ONE_PAYMENT_PER_DAY_ERROR_MESSAGE, OTPError);
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
		ReviewOneTimePaymentsPage OTPError = reviewOneTimePaymentsPage
				.ValidateOnePaymentPerDayErrorMessage();
		Thread.sleep(1000);
		if (OTPError != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.ONE_PAYMENT_PER_DAY_ERROR_MESSAGE, OTPError);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error message not validated");
		}
	}

	@Then("^the user lands on OneTime Payment Submitted Page and validates PDF link$")
	public void OneTime_payment_SubmittedPage() {

		OneTimePaymentPageSubmitted OTPSubmitted = (OneTimePaymentPageSubmitted) getLoginScenario()
				.getBean(PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		OneTimePaymentPageSubmitted PDFValidation = OTPSubmitted
				.ValidatePDFLink();
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
		OneTimePaymentPageSubmitted PaymentAmount = OTPSubmitted
				.ValidatePaymentAmount();
		OneTimePaymentPageSubmitted MemberName = OTPSubmitted
				.ValidateMemberName();
		if (PaymentAmount != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_AMOUNT,
					PaymentAmount);
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
		OneTimePaymentPageSubmitted Timestamp = OTPSubmitted
				.ValidateTimeStamp();
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
	public void TimeStampTheSpartans_OTP_SubmittedPage_Timestamp()
			throws InterruptedException {

		OneTimePaymentPageSubmitted OTPSubmitted = (OneTimePaymentPageSubmitted) getLoginScenario()
				.getBean(PageConstantsMnR.CONFIRM_ONE_TIME_PAYMENT_PAGE);
		Thread.sleep(2000);
		OneTimePaymentPageSubmitted Timestamp = OTPSubmitted
				.ValidateTimeStamp();
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
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage
				.enterInfoWithoutCheckBoxAndContinue();
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPagechkbox = oneTimePaymentsPage
				.errorMessagechkBox();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	@And("^the user clicks on cancel button on OTP Page and validates title$")
	public void user_clicks_cancel_button() {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage
				.CancelButton();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}

	}

	@Then("^user validates the Payment History Page$")
	public void user_validates_Payment_History_PageDetails() {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = oneTimePaymentsPage
				.HistoryPageValidation();
		if (reviewOneTimePaymentsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PAYMENT_HISTORY_PAGE,
					reviewOneTimePaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("one time payments dashboard page not found");
		}
	}

	@Then("^user lands on Review One time Payments Page and validates the amount and routing number values$")
	public void review_onetime_payments_validation() {
		ReviewOneTimePaymentsPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.REVIEW_ONE_TIME_PAYMENTS_DASHBOARD);
		JSONObject reviewOneTimeActual = reviewOneTimePaymentsPage
				.reviewOneTimeValues();
		/* Get expected data */
		String fileName = "reviewonetimeexpected";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER + File.separator
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
		System.out.println("reviewOneTimeExpectedJson---->"
				+ reviewOneTimeExpectedJson);

		try {
			JSONAssert.assertEquals(reviewOneTimeExpectedJson,
					reviewOneTimeActual, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^the user clicks on cancel button on Review Payments Page and validates payments history page$")
	public void user_clicks_cancelbtn_onOnetimePaymentPage() {
		OneTimePaymentsPage oneTimePaymentsPage = (OneTimePaymentsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ONE_TIME_PAYMENTS_DASHBOARD);
		OneTimePaymentPage reviewOneTimePaymentsPage = oneTimePaymentsPage
				.onetimepagecancelbtn();
	}
}
