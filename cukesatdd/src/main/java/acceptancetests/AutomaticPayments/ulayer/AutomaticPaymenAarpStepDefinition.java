package acceptancetests.AutomaticPayments.ulayer;

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
import pages.member.ulayer.AutomaticPaymentPage;
import pages.member.ulayer.AutomaticPaymentSubmittedPage;
import pages.member.ulayer.AutomaticPaymentSuccessPage;
import pages.member.ulayer.AutomaticPaymentsPage;
import pages.member.ulayer.ConfirmAutomaticPaymentPage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.OneTimePaymentPage;
import pages.member.ulayer.OneTimePaymentSuccessPage;
import pages.member.ulayer.OneTimePaymentsPage;
import pages.member.ulayer.PaymentHistoryPage;
import pages.member.ulayer.PaymentsOverview;
import pages.member.ulayer.ReviewAutomaticPaymentsPage;
import pages.member.ulayer.ReviewOneTimePaymentsPage;
import pages.member.ulayer.TeamHLoginUlayer;
import pages.member.ulayer.TestHarness;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.payments.data.PaymentCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author tpravee2
 *
 */
public class AutomaticPaymenAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
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
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		
		
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			/*JSONObject accountHomeActualJson = accountHomePage.accountHomeJson;
			getLoginScenario().saveBean(
					LoginCommonConstants.ACCOUNT_HOME_ACTUAL,
					accountHomeActualJson);
			
			 Get expected data 
			Map<String, JSONObject> expectedDataMap = loginScenario
					.getExpectedJson(userName);
			JSONObject accountHomeExpectedJson = accountHomePage
					.getExpectedData(expectedDataMap);
			getLoginScenario().saveBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED,
					accountHomeExpectedJson);*/
	
	
	}

	}
	
	@And("^the user navigates to Automatic Payments page$")
	public void user_navigates_to_automatic_payments()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		AutomaticPaymentsPage automaticPaymentsPage = accountHomePage.navigateToAutomaticPaymentsPage();
		if(automaticPaymentsPage!= null){
			getLoginScenario().saveBean(PageConstants.AUTOMATIC_PAYMENTS_DASHBOARD,
					automaticPaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("automatic payments dashboard page not found");
		}
		
	}
	
	@And("^the user navigates to TestHarness Page$")
	public void user_navigates_to_TestHarness_Page()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		TestHarness testHarness = accountHomePage.navigateToTestHarnesspage();
		if(testHarness!= null){
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE,
					testHarness);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Test Harness Page not found");
		}
		
	}
	
	/*@And("^the user navigates to Team-h TestHarness Page$")
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
		
	}*/
	
	
	@And("^the user navigates to PaymentOverview Page$")
	public void user_navigates_to_PaymentOverview_Page() throws InterruptedException
	{
		TestHarness testHarness = (TestHarness)getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
		Thread.sleep(2000);
		PaymentsOverview paymentsOverview = testHarness.navigateToPaymentOverview();
		if(paymentsOverview!= null){
			getLoginScenario().saveBean(PageConstants.PAYMENT_OVERVIEW,
					paymentsOverview);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview Page not found");
		}
		
	}
	
	@And("^the user navigates to TeamHPaymentOverview Page$")
	public void user_navigates_to_TeamHPaymentOverview_Page() throws InterruptedException
	{
		TestHarness testHarness = (TestHarness)getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
		PaymentsOverview paymentsOverview = testHarness.navigateToTeamHPaymentOverview();
		if(paymentsOverview!= null){
			getLoginScenario().saveBean(PageConstants.PAYMENT_OVERVIEW,
					paymentsOverview);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Payment Overview page not found");
		}
		
	}
	
	
	@And("^the user scrolls down and selects custom range from Drop down$")
	public void user_selects_custom_date_range() throws InterruptedException
	{
		PaymentsOverview paymentsOverview = (PaymentsOverview)getLoginScenario().getBean(PageConstants.PAYMENT_OVERVIEW);
		PaymentsOverview CustomRange = paymentsOverview.ScrollDownAndSelectRange();
		if(CustomRange!= null){
			getLoginScenario().saveBean(PageConstants.CUSTOM_RANGE,
					CustomRange);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Issue with custom Date Range");
		}
		
	}
	
	@Then("^user clicks on Search and gets error message$")
	public void user_sees_error_message() throws InterruptedException
	{
		PaymentsOverview paymentsOverview = (PaymentsOverview)getLoginScenario().getBean(PageConstants.CUSTOM_RANGE);
		PaymentsOverview ErrorMessage = paymentsOverview.VerifyErrorMessage();
		if(ErrorMessage!= null){
			getLoginScenario().saveBean(PageConstants.DATE_ERROR_MESSAGE,
					ErrorMessage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error Message not Displayed");
		}
		
	}
	
	
	
	@And("^the user navigates to Automatic Payments page from Payments Overview Page$")
	public void user_navigates_to_automatic_payments_from_paymentsOverview() throws InterruptedException
	{
		PaymentsOverview paymentsOverview = (PaymentsOverview)getLoginScenario().getBean(PageConstants.PAYMENT_OVERVIEW);
		AutomaticPaymentsPage automaticPaymentsPage = paymentsOverview.navigateToAutomaticPaymentpage();
		if(automaticPaymentsPage!= null){
			getLoginScenario().saveBean(PageConstants.AUTOMATIC_PAYMENTS_DASHBOARD,
					automaticPaymentsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("automatic payments page not found");
		}
		
	}
	
	@And("^the user enters details and click on continue button on Automatic Payments Page for Dashboard$")
	public void user_clicks_continue() throws InterruptedException
	{
		AutomaticPaymentsPage automaticPaymentsPage = (AutomaticPaymentsPage)getLoginScenario().getBean(PageConstants.AUTOMATIC_PAYMENTS_DASHBOARD);
		Thread.sleep(3000);
		ReviewAutomaticPaymentsPage reviewAutomaticPaymentsPage = automaticPaymentsPage.enterInfoAndContinue();
		if(reviewAutomaticPaymentsPage != null){
			getLoginScenario().saveBean(PageConstants.REVIEW_AUTOMATIC_PAYMENTS_DASHBOARD,
					reviewAutomaticPaymentsPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("automatic payments dashboard page not found");
		}		
		
	}
	
	@And("^the user lands on Review Automatic Payments Page and clicks on Submit button$")
	public void Review_Automatic_paymentPage() throws InterruptedException
	{
		ReviewAutomaticPaymentsPage reviewAutomaticPage = (ReviewAutomaticPaymentsPage)getLoginScenario().getBean(PageConstants.REVIEW_AUTOMATIC_PAYMENTS_DASHBOARD);
		AutomaticPaymentSubmittedPage automaticPaymentSubmittedPage = reviewAutomaticPage.navigatetoPaymentSubmittedPage();
		if(automaticPaymentSubmittedPage != null){
			getLoginScenario().saveBean(PageConstants.CONFIRM_AUTOMATIC_PAYMENT_PAGE,
					automaticPaymentSubmittedPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Review Automatic Payment Page not found");
		}		
		
	}
	
	
	@Then("^the user lands on Automatic Payment Submitted Page and validates PDF link$")
	public void Automatic_payment_SubmittedPage()
	{
		//ReviewAutomaticPaymentsPage reviewAutomaticPaymentsPage = (ReviewAutomaticPaymentsPage)getLoginScenario().getBean(PageConstants.CONFIRM_AUTOMATIC_PAYMENT_PAGE);
		AutomaticPaymentSubmittedPage automaticPaymentSubmittedPage = (AutomaticPaymentSubmittedPage)getLoginScenario().getBean(PageConstants.CONFIRM_AUTOMATIC_PAYMENT_PAGE);
		AutomaticPaymentSubmittedPage PDFValidation = automaticPaymentSubmittedPage.ValidatePDFLink();
		if(PDFValidation != null){
			getLoginScenario().saveBean(PageConstants.PDF_LINK,
					PDFValidation);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Payment Submitted Page not found");
		}		
		
	}
	
	@Then("^the user lands on Automatic Payment Submitted Page and validates Timestamp, Payment Type and Payment Amount$")
	public void Automatic_payment_SubmittedPage_Validations() throws InterruptedException
	{
		//ReviewAutomaticPaymentsPage reviewAutomaticPaymentsPage = (ReviewAutomaticPaymentsPage)getLoginScenario().getBean(PageConstants.CONFIRM_AUTOMATIC_PAYMENT_PAGE);
		AutomaticPaymentSubmittedPage automaticPaymentSubmittedPage = (AutomaticPaymentSubmittedPage)getLoginScenario().getBean(PageConstants.CONFIRM_AUTOMATIC_PAYMENT_PAGE);
		AutomaticPaymentSubmittedPage PaymentTypeValidation = automaticPaymentSubmittedPage.ValidatePaymentType();
		AutomaticPaymentSubmittedPage TimeStampValidation = automaticPaymentSubmittedPage.ValidateTimeStamp();
		AutomaticPaymentSubmittedPage PaymentAmountValidation = automaticPaymentSubmittedPage.ValidatePaymentAmount();
		if(PaymentTypeValidation != null){
			getLoginScenario().saveBean(PageConstants.PAYMENT_TYPE,
					PaymentTypeValidation);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Payment Submitted Page not found");
		}
		
		if(TimeStampValidation != null){
			getLoginScenario().saveBean(PageConstants.TIMESTAMP,
					TimeStampValidation);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Payment Submitted Page not found");
		}
		
		if(PaymentAmountValidation != null){
			getLoginScenario().saveBean(PageConstants.PAYMENT_AMOUNT,
					PaymentAmountValidation);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Payment Submitted Page not found");
		}
		
	}
	
	
	@Then("^the user presses Back To Payment History button on Automatic Payment Submitted page and validates it$")
	public void Automatic_payment_SuccessPage()
	{
		ReviewAutomaticPaymentsPage reviewAutomaticPaymentsPage = (ReviewAutomaticPaymentsPage)getLoginScenario().getBean(PageConstants.CONFIRM_AUTOMATIC_PAYMENT_PAGE);
		ReviewAutomaticPaymentsPage PaymentsHistoryPage = reviewAutomaticPaymentsPage.navigatetoPaymentHistoryDashboard();
		if(PaymentsHistoryPage != null){
			getLoginScenario().saveBean(PageConstants.DASHBOARD_PAYMENT_HISTORY_PAGE,
					PaymentsHistoryPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Payment history confirmation page not found");
		}		
		
	}	
	
	@Then("^user lands on Review Automatic Payments Page and validates the payments page$")
	public void review_automatic_payments_validation()
	{
		ReviewAutomaticPaymentsPage reviewAutomaticPage = (ReviewAutomaticPaymentsPage)getLoginScenario().getBean(PageConstants.REVIEW_AUTOMATIC_PAYMENTS_DASHBOARD);
		JSONObject reviewautomaticActual = reviewAutomaticPage.reviewAutomaticValues();
		/* Get expected data */
		String fileName = "reviewautomaticexpected";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator
				+ PaymentCommonConstants.AUTOMATIC_PAYMENTS_FLOW_NAME
				+ File.separator;
		JSONObject reviewAutomaticExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				PaymentCommonConstants.AUTOMATIC_PAYMENTS_ACTUAL,
				reviewautomaticActual);
		getLoginScenario().saveBean(
				PaymentCommonConstants.AUTOMATIC_PAYMENTS_EXPECTED,
				reviewAutomaticExpectedJson);
			
		System.out.println("reviewAutomaticTimeActual---->" + reviewautomaticActual);
		System.out.println("reviewAutomaticExpectedJson---->" + reviewAutomaticExpectedJson); 
		
		try {
			JSONAssert.assertEquals(reviewAutomaticExpectedJson, reviewautomaticActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@And("^the user clicks on cancel button and validate payment history$")
	public void user_clicks_cancel()
	{
		AutomaticPaymentsPage automaticPaymentsPage = (AutomaticPaymentsPage)getLoginScenario().getBean(PageConstants.AUTOMATIC_PAYMENTS_DASHBOARD);
		ReviewAutomaticPaymentsPage reviewAutomaticPaymentsPage = automaticPaymentsPage.cancelbtn();
		
	}
	
	@And("^the user clicks on cancel button in automatic payment page and validate payment history$")
	public void user_clicks_cancelbtn_onAutomaticPaymentsPage()
	{
		AutomaticPaymentsPage automaticPaymentsPage = (AutomaticPaymentsPage)getLoginScenario().getBean(PageConstants.AUTOMATIC_PAYMENTS_DASHBOARD);
		AutomaticPaymentPage reviewAutomaticPaymentsPage = automaticPaymentsPage.automaticpagecancelbtn();
	}
	
	@And("the user validate edit payment information on review automatic payment page$")
	public void user_clicks_editPaymentinfobtn(){
		AutomaticPaymentsPage automaticPaymentsPage = (AutomaticPaymentsPage)getLoginScenario().getBean(PageConstants.AUTOMATIC_PAYMENTS_DASHBOARD);
		ReviewAutomaticPaymentsPage reviewAutomaticPaymentsPage = automaticPaymentsPage.editPaymentbtn();
		/*if(reviewAutomaticPaymentsPage != null){
			getLoginScenario().saveBean(PageConstants.REVIEW_AUTOMATIC_PAYMENTS_DASHBOARD, reviewAutomaticPaymentsPage);
			Assert.assertTrue(true);
		}else{
			Assert.fail("autoamtic payments dashbaord page not found");
		}*/
		}
	
	@And("^the user clicks on Continue button in automatic payment page without clicking checkbox$")
	public void user_continueswithoutCheckbox()
	{
		AutomaticPaymentsPage automaticPaymentsPage = (AutomaticPaymentsPage)getLoginScenario().getBean(PageConstants.AUTOMATIC_PAYMENTS_DASHBOARD);
		ReviewAutomaticPaymentsPage reviewautomaticPaymentsPage = automaticPaymentsPage.enterInfoWithoutCheckBoxAndContinue();
		ReviewAutomaticPaymentsPage reviewautomaticPaymentsPagechkbox = automaticPaymentsPage.errorMessagechkBox();
		if(reviewautomaticPaymentsPage != null){
			getLoginScenario().saveBean(PageConstants.REVIEW_AUTOMATIC_PAYMENTS_DASHBOARD,
					reviewautomaticPaymentsPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("Automatic payments dashboard page not found");
		}
		
		
	}
	
	}
