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
import pages.member.ulayer.DashboardPaymentOverview;
import pages.member.ulayer.LoginPage;
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

		
		if (accountHomePage!= null) {
			Map<String,JSONObject> expectedDataMap = loginScenario
					.getExpectedJson(userName);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
			getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
		}
	}

	@Then("^I navigate to the Payment History page in AARP Site$")
	public void i_navigate_to_the_payment_history_page() 
	{
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		//System.out.println("testing");
		PaymentHistoryPage NewPaymentHistoryPge = accountHomePage.changeUrlToNewPaymentHistoryPage();
		
		if(NewPaymentHistoryPge == null){
			System.out.println("Error:Loading ion new payment page");
			Assert.fail();
		}
		else{
			/* Get expected data */
			Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario().getBean(CommonConstants.EXPECTED_DATA_MAP); 
			JSONObject newPaymentHistoryExpectedJson = NewPaymentHistoryPge
					.getExpectedData(expectedDataMap);
			System.out.println("page loaded succesfully");
			getLoginScenario().saveBean(PageConstants.PAYMENT_HISTORY_PAGE, NewPaymentHistoryPge);
			getLoginScenario().saveBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON, newPaymentHistoryExpectedJson);
		}
	}
	
	@And("^I can view a Payment History header_text in AARP Site$")
	public void view_payment_history_header_and_text(){
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario().getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON); 
		paymentHistoryPage.validatePaymentHistoryHeaderAndText(newPaymentHistoryExpectedJson);
	}
	
	@And("^I can view a View Payments For dropdown menu and first selected option is Last 90 days in AARP Site$")
	public void view_payments_for_dropdown_menu_and_first_selected_option_is_last_90_days(){
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario().getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON); 
		paymentHistoryPage.validateViewPaymentsForDropdownLabelAndDefaultValue(newPaymentHistoryExpectedJson);
	}
	
	@And("^I can view all the expected options in the dropdown of view payment dropdown menu in AARP Site$")
	public void can_view_all_the_expected_options_in_the_dropdown(){
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario().getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON); 
		paymentHistoryPage.validateViewPaymentsForDropdown(newPaymentHistoryExpectedJson);
	}
	
	@And("^I can view a View Payments For Custom Search when I have selected Custom Search and options are coming in AARP Site$")
	public void I_can_view_a_when_I_have_selected_Custom_Search_and_options_are_coming(DataTable dataAttributes) {
			List<DataTableRow> dataAttributesRow = dataAttributes
					.getGherkinRows();
			Map<String, String> dataAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < dataAttributesRow.size(); i++) {

				dataAttributesMap.put(dataAttributesRow.get(i).getCells()
						.get(0), dataAttributesRow.get(i).getCells().get(1));
			}

			String fromDate = dataAttributesMap.get("start date");
			String toDate = dataAttributesMap.get("end date");
			
			PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
			JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario().getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON); 
			paymentHistoryPage.validateCustomSearchOptions(newPaymentHistoryExpectedJson,fromDate,toDate);
		}
	
	@And("^I can view a Payment table header in AARP Site$")
	public void I_can_view_a_payment_table_header() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario().getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON); 
		paymentHistoryPage.validatePaymentHistoryTableHeader(newPaymentHistoryExpectedJson);
		paymentHistoryPage.validatefiltertext(newPaymentHistoryExpectedJson);
		//paymentHistoryPage.validateCustomSearchfiltertext(newPaymentHistoryExpectedJson);
	}
	
	@And("^I can view a Payment table columns in AARP Site$")
	public void I_can_view_a_payment_table_columns() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario().getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON); 
		paymentHistoryPage.validatePaymentHistoryTableColumns(newPaymentHistoryExpectedJson);
	}
	
	
	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}
	
	@Then("^validate Payment Method value$")
	public void validatePaymentMethodValue(){
	DashboardPaymentOverview dashboardPaymentOverview = (DashboardPaymentOverview) getLoginScenario().getBean(PageConstants.DASHBOARD_PAYMENT_HISTORY_PAGE);
	JSONObject paymentHistoryActualJson = dashboardPaymentOverview.paymentOverviewJson;
        /*Get expected response*/
        String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
        Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
        JSONObject paymentHistoryExpectedJson = expectedDataMap.get(CommonConstants.PAYMENT_HISTORY);
        try {
               JSONAssert.assertEquals(paymentHistoryExpectedJson, paymentHistoryActualJson, true);
        } catch (JSONException e) {
               e.printStackTrace();
        }
	}

}
