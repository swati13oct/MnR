package acceptancetests.memberrdesignVBF.contactus;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.ContactUsPage;

public class ContactusStepDefinition {
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
		else
			Assert.fail("Contact Us page not loaded!!!");
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
