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
import pages.member.ulayer.AutomaticPaymentSuccessPage;
import pages.member.ulayer.AutomaticPaymentsPage;
import pages.member.ulayer.ConfirmAutomaticPaymentPage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.OneTimePaymentPage;
import pages.member.ulayer.OneTimePaymentSuccessPage;
import pages.member.ulayer.OneTimePaymentsPage;
import pages.member.ulayer.PaymentHistoryPage;
import pages.member.ulayer.ReviewAutomaticPaymentsPage;
import pages.member.ulayer.ReviewOneTimePaymentsPage;
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
	
	@And("^the user enters details and click on continue button on One Time Payments Page for  Dashboard$")
	public void user_clicks_continue()
	{
		AutomaticPaymentsPage automaticPaymentsPage = (AutomaticPaymentsPage)getLoginScenario().getBean(PageConstants.AUTOMATIC_PAYMENTS_DASHBOARD);
		ReviewAutomaticPaymentsPage reviewAutomaticPaymentsPage = automaticPaymentsPage.enterInfoAndContinue();
		if(reviewAutomaticPaymentsPage != null){
			getLoginScenario().saveBean(PageConstants.REVIEW_AUTOMATIC_PAYMENTS_DASHBOARD,
					reviewAutomaticPaymentsPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("automatic payments dashboard page not found");
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
}
