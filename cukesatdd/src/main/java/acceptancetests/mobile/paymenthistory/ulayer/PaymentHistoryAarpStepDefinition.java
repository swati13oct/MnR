/**
 * 
 */
package acceptancetests.mobile.paymenthistory.ulayer;

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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.mobile.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.mobile.member.ulayer.BenefitsSummaryPage;
import pages.mobile.member.ulayer.LoginPage;
import pages.mobile.member.ulayer.PaymentHistoryPage;

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

	@When("^the above plantype user logs in mobile$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);

		WebDriver wd = getLoginScenario().getMobileWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
		LoginPage loginPage = (LoginPage)getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
		
		BenefitsSummaryPage benefitsSummaryPage = loginPage.loginWith(userName, pwd);
		
		getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE, benefitsSummaryPage);
		
	}

	@When("^navigate to the new Payment History page$")
	public void i_navigate_to_the_payment_history_page() {
		BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage) getLoginScenario().getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
		
		PaymentHistoryPage newPaymentHistoryPageFlag = benefitsSummaryPage.changeUrlToNewPaymentHistoryPage();

		if (newPaymentHistoryPageFlag!=null) {
			getLoginScenario().saveBean(PageConstants.PAYMENT_HISTORY_PAGE,newPaymentHistoryPageFlag);
			System.out.println("New Payment page got loaded");
			Assert.assertTrue(true);
		} else {
			System.out.println("Error:Loading ion new payment page");
		}

	}
	 @Then("^navigate to the new Payment History page and validate setup automatic payment$")
		public void navigate_to_the_new_Payment_History_page() {

			BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage) getLoginScenario()
					.getBean(PageConstants.BENEFITS_SUMMARY_PAGE);

			boolean flagvalue = benefitsSummaryPage.validateSetupAutomaticPayments();
			if(flagvalue)
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
		
		} 

		@Then("^navigate to the new Payment History page and validate Non setup automatic payment$")
		public void I_navigate_to_the_new_Payment_History_page() {
			BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage) getLoginScenario()
					.getBean(PageConstants.BENEFITS_SUMMARY_PAGE);

			PaymentHistoryPage page = benefitsSummaryPage.changeUrlToNewPaymentHistoryPage();
			String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
			System.out.println(userName + "userName");
			Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
			JSONObject paymentHistoryExpectedJson = expectedDataMap.get(CommonConstants.PAYMENT_HISTORY_MOBILE_ULAYER);

			JSONObject paymentHistoryActualJson = page.paymentHistoryPageJson;
			try {
				JSONAssert.assertEquals(paymentHistoryExpectedJson, paymentHistoryActualJson, true);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		@Then("^navigate to the new Payment History page and validate Credit Balance when the balance is greater than zero$")
		public void I_navigate_to_the_new_Payment_History_page_validate_credit_balance() {
			BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage) getLoginScenario()
					.getBean(PageConstants.BENEFITS_SUMMARY_PAGE);

			PaymentHistoryPage page = benefitsSummaryPage.changeUrlToNewPaymentHistoryPage();
			String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
			System.out.println(userName + "userName");
			Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
			JSONObject paymentHistoryExpectedJson = expectedDataMap.get(CommonConstants.PAYMENT_HISTORY_MOBILE_ULAYER);

			JSONObject paymentHistoryActualJson = page.paymentHistoryPageJson;
			try {
				JSONAssert.assertEquals(paymentHistoryExpectedJson, paymentHistoryActualJson, true);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		 @Then("^navigate to the new Payment History page and validate DTM values for Make A One Time Payment$")
			public void navigate_to_the_new_Payment_History_page_validate_DTM_values_One_Time_Payment() {

			 PaymentHistoryPage planhistorypage = (PaymentHistoryPage) getLoginScenario()
						.getBean(PageConstants.PAYMENT_HISTORY_PAGE);

				//
				boolean flagvalue = planhistorypage.validateOneTimePaymentDtmValues();
				if(flagvalue)
					Assert.assertTrue(true);
				else
					Assert.assertTrue(false);
			
			} 
		 @Then("^navigate to the new Payment History page and validate DTM values for Set Up Automatic Payments$")
			public void navigate_to_the_new_Payment_History_page_validate_DTM_values_Setup_Payment() {

			 PaymentHistoryPage planhistorypage = (PaymentHistoryPage) getLoginScenario()
						.getBean(PageConstants.PAYMENT_HISTORY_PAGE);

				boolean flagvalue = planhistorypage.validateSetupPaymentDtmValues();
				if(flagvalue)
					Assert.assertTrue(true);
				else
					Assert.assertTrue(false);
			
			} 

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
