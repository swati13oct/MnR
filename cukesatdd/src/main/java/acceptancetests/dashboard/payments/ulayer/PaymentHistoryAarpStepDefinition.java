/**
 * 
 */
package acceptancetests.dashboard.payments.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
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

import pages.dashboard.member.ulayer.PaymentHistoryPage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import pages.mobile.member.ulayer.BenefitsSummaryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author sunya
 *
 */
public class PaymentHistoryAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^I am an AARP Individual member on the Dashboard site$")
	public void i_am_an_aarp_individual_member_on_the_dashboard_site(DataTable memberAttributes) {
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

	}

	@When("^the above plantype user logs in AARP Site$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);

		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);

		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);

		if (accountHomePage != null) {
			Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
			getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
		}
	}

	@Then("^I navigate to the Payment History page in AARP Site$")
	public void i_navigate_to_the_payment_history_page() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		// System.out.println("testing");
		PaymentHistoryPage NewPaymentHistoryPge = accountHomePage.changeUrlToNewPaymentHistoryPage();

		if (NewPaymentHistoryPge == null) {
			System.out.println("Error:Loading ion new payment page");
			Assert.fail();
		} else {
			/* Get expected data */
			Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
					.getBean(CommonConstants.EXPECTED_DATA_MAP);
			JSONObject newPaymentHistoryExpectedJson = NewPaymentHistoryPge.getExpectedData(expectedDataMap);
			System.out.println("page loaded succesfully");
			getLoginScenario().saveBean(PageConstants.PAYMENT_HISTORY_PAGE, NewPaymentHistoryPge);
			getLoginScenario().saveBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON,
					newPaymentHistoryExpectedJson);
		}
	}

	@And("^I can view a Payment History header_text in AARP Site$")
	public void view_payment_history_header_and_text() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON);
		paymentHistoryPage.validatePaymentHistoryHeaderAndText(newPaymentHistoryExpectedJson);
	}

	@And("^I can view a View Payments For dropdown menu and first selected option is Last 90 days in AARP Site$")
	public void view_payments_for_dropdown_menu_and_first_selected_option_is_last_90_days() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON);
		paymentHistoryPage.validateViewPaymentsForDropdownLabelAndDefaultValue(newPaymentHistoryExpectedJson);
	}

	@And("^I can view all the expected options in the dropdown of view payment dropdown menu in AARP Site$")
	public void can_view_all_the_expected_options_in_the_dropdown() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON);
		paymentHistoryPage.validateViewPaymentsForDropdown(newPaymentHistoryExpectedJson);
	}

	@And("^I can view a View Payments For Custom Search when I have selected Custom Search and options are coming in AARP Site$")
	public void I_can_view_a_when_I_have_selected_Custom_Search_and_options_are_coming(DataTable dataAttributes) {
		List<DataTableRow> dataAttributesRow = dataAttributes.getGherkinRows();
		Map<String, String> dataAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < dataAttributesRow.size(); i++) {

			dataAttributesMap.put(dataAttributesRow.get(i).getCells().get(0),
					dataAttributesRow.get(i).getCells().get(1));
		}

		String fromDate = dataAttributesMap.get("start date");
		String toDate = dataAttributesMap.get("end date");

		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON);
		paymentHistoryPage.validateCustomSearchOptions(newPaymentHistoryExpectedJson, fromDate, toDate);
	}

	@And("^I can view a Payment table header in AARP Site$")
	public void I_can_view_a_payment_table_header() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON);
		paymentHistoryPage.validatePaymentHistoryTableHeader(newPaymentHistoryExpectedJson);
		paymentHistoryPage.validatefiltertext(newPaymentHistoryExpectedJson);
		// paymentHistoryPage.validateCustomSearchfiltertext(newPaymentHistoryExpectedJson);
	}

	@And("^I can view a Payment table columns in AARP Site$")
	public void I_can_view_a_payment_table_columns() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON);
		paymentHistoryPage.validatePaymentHistoryTableColumns(newPaymentHistoryExpectedJson);
	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

	@Then("^validate Payment Method value$")
	public void validatePaymentMethodValue() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject paymentHistoryActualJson = paymentHistoryPage.paymentHistoryJson;
		/* Get expected response */
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject paymentHistoryExpectedJson = expectedDataMap.get(CommonConstants.PAYMENT_HISTORY);
		try {
			JSONAssert.assertEquals(paymentHistoryExpectedJson, paymentHistoryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Given("^I am an AARP  Individual member on the Dashboard site who has NOT previously setup automatic payments$")
	public void i_am_an_aarp_individual_member_on_the_dashboard_site_not_previuosly_setup_automatic_payment(
			DataTable memberAttributes) {
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

		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			Assert.fail("unable to find a " + desiredAttributes + " member");

		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

	}

	@And("^I navigate to the Payment History page$")
	public void when_i_navigate_to_the_payment_history_page() {
		// plantype_user_logs_in();
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PaymentHistoryPage paymentHistoryPage = accountHomePage.changeUrlToNewPaymentHistoryPage();
		if (null != paymentHistoryPage) {

			System.out.println("New Payment history page got loaded");
			getLoginScenario().saveBean(PageConstants.DASHBOARD_PAYMENT_HISTORY_PAGE, paymentHistoryPage);
		} else {
			System.out.println("Error:Loading ion new payment page");
		}
	}

	@Then("^I can view a button Make a One-Time Payment$")
	public void i_can_view_button_make_one_time_payment() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_PAYMENT_HISTORY_PAGE);

		if (null != paymentHistoryPage) {

			if (paymentHistoryPage.validateMakeOneTimePaymentButtonView() == true) {
				Assert.assertTrue(true);
			} else {
				Assert.assertFalse(true);
				;
			}
		}

	}

	@And("^a button Set Up Automatic Payments$")
	public void a_button_setup_automatic_payment() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_PAYMENT_HISTORY_PAGE);

		if (null != paymentHistoryPage) {

			if (paymentHistoryPage.validateMakeOneTimePaymentButtonView() == true) {
				Assert.assertTrue(true);
			} else {
				Assert.assertFalse(true);
			}
		}

	}

	@And("^a button Edit Automatic Payments$")
	public void a_button_edit_automatic_payment() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_PAYMENT_HISTORY_PAGE);

		if (null != paymentHistoryPage) {

			if (paymentHistoryPage.validateMakeOneTimePaymentButtonView() == true) {
				Assert.assertTrue(true);
			} else {
				Assert.assertFalse(true);
			}
		}

	}

	@Given("^I am an AARP Individual member on the Dashboard site in mobile site$")
	public void I_am_an_aarp_individual_member_on_the_dashboard_site_mobile_site(DataTable memberAttributes) {
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

	}

	@When("^the above plantype user logs in mobile in AARP Site$")
	public void plantype_user_logs_in_mobile() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);

		WebDriver wd = getLoginScenario().getMobileWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		pages.mobile.member.ulayer.LoginPage loginPage = (pages.mobile.member.ulayer.LoginPage) getLoginScenario()
				.getBean(PageConstants.LOGIN_PAGE);

		BenefitsSummaryPage benefitsSummaryPage = loginPage.loginWith(userName, pwd);

		getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE, benefitsSummaryPage);

	}

	@When("^navigate to the new Payment History page in mobile site$")
	public void I_navigate_to_the_payment_history_page() {
		BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_SUMMARY_PAGE);

		PaymentHistoryPage newPaymentHistoryPageFlag = benefitsSummaryPage.changeUrlToNewPaymentHistoryPage();

		if (newPaymentHistoryPageFlag != null) {
			getLoginScenario().saveBean(PageConstants.DASHBOARD_PAYMENT_HISTORY_PAGE, newPaymentHistoryPageFlag);
			System.out.println("New Payment page got loaded");
			Assert.assertTrue(true);
		} else {
			System.out.println("Error:Loading ion new payment page");
		}

	}

	@Then("^validate setup automatic payment$")
	public void validate_setup_automatic_payment() {

		PaymentHistoryPage newPaymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_PAYMENT_HISTORY_PAGE);

		boolean flagvalue = newPaymentHistoryPage.validateSetupAutomaticPayments();
		if (flagvalue)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

	}

	@Then("^validate Non setup automatic payment$")
	public void validate_Non_setup_account_payment() {
		PaymentHistoryPage newPaymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);

		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		System.out.println(userName + "userName");
		Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject paymentHistoryExpectedJson = expectedDataMap.get(CommonConstants.PAYMENT_HISTORY_MOBILE_ULAYER);

		JSONObject paymentHistoryActualJson = newPaymentHistoryPage.paymentHistoryJson;
		try {
			JSONAssert.assertEquals(paymentHistoryExpectedJson, paymentHistoryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Then("^validate Credit Balance when the balance is greater than zero$")
	public void I_navigate_to_the_new_Payment_History_page_validate_credit_balance() {
		PaymentHistoryPage newPaymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		System.out.println(userName + "userName");
		Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject paymentHistoryExpectedJson = expectedDataMap.get(CommonConstants.PAYMENT_HISTORY_MOBILE_ULAYER);

		JSONObject paymentHistoryActualJson = newPaymentHistoryPage.paymentHistoryJson;
		try {
			JSONAssert.assertEquals(paymentHistoryExpectedJson, paymentHistoryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Then("^validate DTM values for Make A One Time Payment$")
	public void navigate_to_the_new_Payment_History_page_validate_DTM_values_One_Time_Payment() {

		PaymentHistoryPage planhistorypage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		boolean flagvalue = planhistorypage.validateOneTimePaymentDtmValues();
		if (flagvalue)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

	}

	@Then("^validate DTM values for Set Up Automatic Payments$")
	public void navigate_to_the_new_Payment_History_page_validate_DTM_values_Setup_Payment() {

		PaymentHistoryPage planhistorypage = (PaymentHistoryPage) getLoginScenario()
				.getBean(PageConstants.PAYMENT_HISTORY_PAGE);

		boolean flagvalue = planhistorypage.validateSetupPaymentDtmValues();
		if (flagvalue)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

	}

}
