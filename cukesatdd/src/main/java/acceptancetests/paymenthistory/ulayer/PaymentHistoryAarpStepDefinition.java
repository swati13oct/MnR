/**
 * 
 */
package acceptancetests.paymenthistory.ulayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

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
import gherkin.formatter.model.DataTableRow;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.DashboardPaymentOverview;
import pages.member.ulayer.LoginPage;

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

	@When("^the above plantype user logs in$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);

		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);

		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}
	}

	@Then("^I navigate to the new Payment History page$")
	public void i_navigate_to_the_payment_history_page() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		DashboardPaymentOverview dashboardPaymentOverview = accountHomePage.changeUrlToNewPaymentHistoryPage();

		if (null != dashboardPaymentOverview) {
			System.out.println("New Payment page got loaded");
			Assert.assertTrue(true);
		} else {
			System.out.println("Error:Loading ion new payment page");
		}

	}
	
	
	@And("^I navigate to the new Payment History page$")
	public void i_navigate_to_the_payment_history_page1() {
		
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		DashboardPaymentOverview dashboardPaymentOverview = accountHomePage.changeUrlToNewPaymentHistoryPage();
		if (null != dashboardPaymentOverview) {
			
			System.out.println("New Payment history page got loaded");
			getLoginScenario().saveBean(PageConstants.DASHBOARD_PAYMENT_HISTORY_PAGE,
					dashboardPaymentOverview);
		} else {
			System.out.println("Error:Loading ion new payment page");
		}
	}
	
	
	@Then("^I can view a Premium Payments Overview section with the Payment Method I have selected displayed on desktop$")
	public void i_can_view_premium_payments_overview_payment_method() {	
		DashboardPaymentOverview dashboardPaymentOverview = (DashboardPaymentOverview) getLoginScenario().getBean(PageConstants.DASHBOARD_PAYMENT_HISTORY_PAGE);

		if (null !=dashboardPaymentOverview) {
			
			if(dashboardPaymentOverview.validatePaymentMethod()==true)
			{
			System.out.println("Payment method found");
			Assert.assertTrue(true);
		} else {
			System.out.println("Error:Payment method test fail");
		}
		}

	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
