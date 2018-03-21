package acceptancetests.memberrdesignVBF.contactus;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.ContactUsPage;
import pages.memberrdesignVBF.LoginPage;

public class ContactusRedesignStepDefinition {
	/**
	 * 
	 */
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 * @param givenAttributes
	 * @throws InterruptedException
	 */
	@Given("^registered UMS member with following attributes$")
	public void registered_member_orderplanmaterials_ums(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		// get parameter username and password
		String userName = memberAttributesMap.get("UserName");
		String passWord = memberAttributesMap.get("Password");
		System.out.println("User is..." + userName);
		System.out.println("Password is..." + passWord);
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage THloginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) THloginPage.loginWith(userName, passWord);
			if (testHarness != null) {
				getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarness);
			} else {
				Assert.fail("Login not successful...");
			}
		} else {

			RallyDashboardPage rallyDashboard = (RallyDashboardPage) THloginPage.loginWith(userName, passWord);
			if (rallyDashboard != null) {
				getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
			} else {
				Assert.fail("Login not successful...");
			}
		}
	}

	/***
	 * 
	 */
	@When("^the user navigates to contact us page in UHC site$")
	public void validates_contactUs_Redesign_Page() {
		ContactUsPage contactUsPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			contactUsPage = testHarness.navigateToContactUsPage();

		} else {
			RallyDashboardPage rallyDashboardPage = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);

			contactUsPage = rallyDashboardPage.navigateToContactUsPage();
		}
		if (contactUsPage != null)
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE, contactUsPage);
	}

	/***
	 * 
	 */
	@Then("^user validates Group secure email widget  in redesign contact us page$")
	public void user_validates_email_widget_func() {
		ContactUsPage contactusPage = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validateEmailWidgetfunctionality();

	}

	/***
	 * 
	 */
	@Then("^user validates secure email widget UI in redesign contact us page$")
	public void user_validates_secure_email_widget_UI_in_redesign_contact_us_page() {
		ContactUsPage contactus = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactus.validateEmailWidgetSection();

	}

	/***
	 * 
	 */
	@Then("^user validates clickToCallButton display on contactUS redesign page$")
	public void validates_clickToCall_widget() {
		ContactUsPage contactusPage = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validates_clickToCall_widget();
	}

	/***
	 * 
	 */
	@And("^user clicks on Request Confirmation Click$")
	public void RequestcallConfimration_click() {
		ContactUsPage contactusPage = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.reqCallclickConformation();
	}

}
