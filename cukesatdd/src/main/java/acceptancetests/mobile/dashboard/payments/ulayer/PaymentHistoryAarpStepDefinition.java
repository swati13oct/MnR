/**
 * 
 */
package acceptancetests.mobile.dashboard.payments.ulayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.mobile.login.data.LoginCommonConstants;
import acceptancetests.atdd.data.mobile.member.PageConstants;
import acceptancetests.atdd.mobile.data.CommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.member.ulayer.PaymentHistoryPage;
import pages.mobile.member.ulayer.BenefitsSummaryPage;
import pages.mobile.member.ulayer.LoginPage;

/**
 * @author njain112
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
			getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, pwd);
		}

	}

	@When("^the above plantype user logs in mobile site$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);

		WebDriver wd = getLoginScenario().getMobileWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage loginPage = new LoginPage(wd);
		
		BenefitsSummaryPage benefitsSummaryPage = loginPage.loginWith(userName, pwd);
		
		/*Get expected data*/
		Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject benefitsSummaryExpectedJson = benefitsSummaryPage.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_SUMMARY_EXPECTED, benefitsSummaryExpectedJson);
		
		JSONObject benefitsSummaryActualJson =  null;
		if ((benefitsSummaryPage!= null)) 
		{
			getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE, benefitsSummaryPage);
			benefitsSummaryActualJson = benefitsSummaryPage.benefitsSummaryJson;
			getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_SUMMARY_ACTUAL, benefitsSummaryActualJson);
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
	}

	@Then("^I navigate to the Payment History page in AARP site$")
	public void i_navigate_to_the_payment_history_page() {
		BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage) getLoginScenario().getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
		PaymentHistoryPage paymentHistoryPage = benefitsSummaryPage.navigateToNewPaymentHistoryPage();
		
		if(paymentHistoryPage == null){
			System.out.println("Error:Loading ion new payment page");
			Assert.fail();
		}
		else{
			/* Get expected data */
			Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario().getBean(CommonConstants.EXPECTED_DATA_MAP); 
			JSONObject paymentHistoryExpectedJson = paymentHistoryPage
					.getExpectedData(expectedDataMap);
			System.out.println("page loaded succesfully");
			getLoginScenario().saveBean(PageConstants.PAYMENT_HISTORY_PAGE, paymentHistoryPage);
			getLoginScenario().saveBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON, paymentHistoryExpectedJson);
		}

	}
	@And("^I can view a Payment History header_text in AARP site$")
	public void view_payment_history_header_and_text(){
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario().getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON); 
		paymentHistoryPage.validatePaymentHistoryHeaderAndText(newPaymentHistoryExpectedJson);
	}
	
	@And("^I can view a View Payments For dropdown menu and first selected option is Last 90 days in AARP site$")
	public void view_payments_for_dropdown_menu_and_first_selected_option_is_last_90_days(){
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario().getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON); 
		paymentHistoryPage.validateViewPaymentsForDropdownLabelAndDefaultValue(newPaymentHistoryExpectedJson);
	}
	
	@And("^I can view all the expected options in the dropdown in AARP site$")
	public void can_view_all_the_expected_options_in_the_dropdown(){
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario().getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON); 
		paymentHistoryPage.validateViewPaymentsForDropdown(newPaymentHistoryExpectedJson);
	}
	
	@And("^I can view a View Payments For Custom Search when I have selected Custom Search and options are coming in AARP site$")
	public void I_can_view_a_when_I_have_selected_Custom_Search_and_options_are_coming(DataTable dataAttributes) {
			List<DataTableRow> dataAttributesRow = dataAttributes
					.getGherkinRows();
			Map<String, String> dataAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < dataAttributesRow.size(); i++) {

				dataAttributesMap.put(dataAttributesRow.get(i).getCells()
						.get(0), dataAttributesRow.get(i).getCells().get(1));
			}

			String fromDate = dataAttributesMap.get("Start Date");
			String toDate = dataAttributesMap.get("End Date");
			
			PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
			JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario().getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON); 
			paymentHistoryPage.validateCustomSearchOptions(newPaymentHistoryExpectedJson,fromDate,toDate);
		}
	

	
	@And("^I can view a Payment table columns in AARP site$")
	public void I_can_view_a_payment_table_columns() {
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
		JSONObject newPaymentHistoryExpectedJson = (JSONObject) getLoginScenario().getBean(CommonConstants.NEW_PAYMENT_HISTORY_EXPECTED_JSON); 
		paymentHistoryPage.validatePaymentHistoryTableData(newPaymentHistoryExpectedJson);
	}
	
	
	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
