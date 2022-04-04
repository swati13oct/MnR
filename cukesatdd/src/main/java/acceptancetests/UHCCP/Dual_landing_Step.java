package acceptancetests.UHCCP;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UHCCP.Contact_Us_Page;
import pages.UHCCP.Dual_Landing_Page;
import pages.UHCCP.GlobalElements_Page;

public class Dual_landing_Step {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public WebDriver driver;

	@Then("User clicks on Medicare dual from Contact us hover over")
	public void user_clicks_on_contact_us_button_for_dual_landing_form() throws Throwable {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		GlobalElements_Page globalElements = new GlobalElements_Page(driver);
		Contact_Us_Page contactUsPage = globalElements.medicareDual();
		getLoginScenario().saveBean(PageConstants.UHCCP_CONTACT_US_PAGE, contactUsPage);
	}

	@Then("User clicks on form link to meet an Agent in Contact Us Page")
	public void user_clicks_on_following_form_button_for_dual_landing_form() throws Throwable {
		Contact_Us_Page contactUsPage = (Contact_Us_Page) getLoginScenario()
				.getBean(PageConstants.UHCCP_CONTACT_US_PAGE);
		Dual_Landing_Page dualLandingPage = contactUsPage.meetAnAgentForm();
		getLoginScenario().saveBean(PageConstants.UHCCP_DUAL_lANDING_PAGE, dualLandingPage);
	}

	@Then("user fills the Contact Request form in Dual Landing page")
	public void user_fills_the_contact_request_form_in_dual_landing_page(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		Map<String, String> contactFormMap = new HashMap<String, String>();
		contactFormMap.put("First Name", memberAttributesMap.get("First Name"));
		contactFormMap.put("Last Name", memberAttributesMap.get("Last Name"));
		contactFormMap.put("Address1", memberAttributesMap.get("Address1"));
		contactFormMap.put("Address2", memberAttributesMap.get("Address2"));
		contactFormMap.put("City", memberAttributesMap.get("City"));
		contactFormMap.put("State", memberAttributesMap.get("State"));
		contactFormMap.put("Zip Code", memberAttributesMap.get("Zip Code"));
		contactFormMap.put("Email", memberAttributesMap.get("Email"));
		contactFormMap.put("Phone No.", memberAttributesMap.get("Phone No."));
		Dual_Landing_Page dualLandingPage = (Dual_Landing_Page) getLoginScenario()
				.getBean(PageConstants.UHCCP_DUAL_lANDING_PAGE);

		dualLandingPage.fillContactForm(contactFormMap);

	}

	@Then("user clicks on Submit Request for Contact Request form in Dual Landing page")
	public void user_clicks_on_submit_request_for_contact_request_form_in_dual_landing_page() {
		Dual_Landing_Page dualLandingPage = (Dual_Landing_Page) getLoginScenario()
				.getBean(PageConstants.UHCCP_DUAL_lANDING_PAGE);
		boolean result = dualLandingPage.clickSubmitRequest();
		Assertion.assertTrue("Contact Request Form on Dual Landing page is successfull", result);
	}

}
