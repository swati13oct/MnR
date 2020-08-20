package acceptancetests.memberredesign.guestPayments;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

import pages.regression.guestPayments.OneTimeGuestPaymentsPage;
import pages.regression.guestPayments.guestPaymentsLogin;
import pages.regression.login.HSIDLoginPage;

/**
 * Step definitions for Guest Payments Page on the Member site.
 */
public class guestPaymentsLoginStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver wd;

	public static Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@Given("^I am on the Welcome Page of M&R Guest Premium Payment portal$")
	public void the_user_on_LoginPage(DataTable givenAttributes) {
		wd = getLoginScenario().getWebDriver();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String siteName = memberAttributesRow.get(0).getCells().get(1);
		guestPaymentsLogin guestPaymentsLogin = new guestPaymentsLogin(wd, siteName);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE, guestPaymentsLogin);
	}

	@Then("^I validate all the header and page elements$")
	public void the_user_verifies_headerAndBody() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario()
				.getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.validateHeaderAndBody();

	}

	@When("^I click on link Help me find my id link$")
	public void the_user_clicks_on_helpMeFindMYID() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario()
				.getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.validateFindMyID();

	}

	@Then("^I will enter my Member ID and Date of birth$")
	public void the_user_entered_MemberID_DateOfBirth(DataTable memberAttributes) {

		Map<String, String> memberAttributesMap = parseInputArguments(memberAttributes);
		String memberID = memberAttributesMap.get("Member ID");
		String dob = memberAttributesMap.get("Date of Birth");

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario()
				.getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.enterIDandBirthDate(memberID, dob);

	}

	@Then("^I will click Next to proceed to the Make a One-time payment page$")

	public void the_user_clicked_NextButton() {
		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario()
				.getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = guestPaymentsLogin.clickNext();

		Assert.assertTrue("PROBLEM - One Time Guest Payments Page is not Displayed", oneTimeGuestPaymentsPage != null);
		getLoginScenario().saveBean(PageConstants.One_Time_Guest_Payments_Page, oneTimeGuestPaymentsPage);
	}

	@Then("^I click on the sign in link and navigate to Member Portal sign in page$")

	public void the_user_clicks_SignIn() {

		guestPaymentsLogin guestPaymentsLogin =  (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		HSIDLoginPage  HSIDLoginPage=guestPaymentsLogin.clickOnSignInLink();

	}

	@Then("^I will see the Logo specific to my plan and the Sign in button$")

	public void verify_logo_and_signIn() {


	

	}

	@Then("^I click on Next button leaving Member ID and Date of birth blank$")

	public void the_user_Clicks_Next_Button() {

		guestPaymentsLogin guestPaymentsLogin =  (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.clicksNextButton();

	}

	@Then("^I will get an error message$")

	public void the_user_gets_Error() {

		guestPaymentsLogin guestPaymentsLogin =  (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.checkErrorMessage();

	}

	@Then("^I will get an Error that match cannot be found in GPS$")

	public void the_user_gets_match_Error() {

		guestPaymentsLogin guestPaymentsLogin =  (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.checkErrorMessageFromGPS();

	}

	@Then("^I will click on the Next Button and navigate to an Error page$")

	public void the_user_clicks_Next_to_land_Error_Page() {

		guestPaymentsLogin guestPaymentsLogin =  (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin = guestPaymentsLogin.clickAndLandOnErrorPage();
		Assert.assertTrue("PROBLEM - One Time Guest Payments Page is not Displayed", guestPaymentsLogin != null);
	}

	@Then("^I will be instructed to call the number on the back of my ID$")

	public void the_user_verifies_details_on_Error_Page() {

		guestPaymentsLogin guestPaymentsLogin =  (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.verifyDetailsOnErrorPage();

	}

	@Then("^I will not see the sign in link to the authenticated M&R member site$")

	public void signIn_Button_should_not_be_present() {

		guestPaymentsLogin guestPaymentsLogin =  (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.verifySignInLinkShouldNotBePresent();

	}
	

}
