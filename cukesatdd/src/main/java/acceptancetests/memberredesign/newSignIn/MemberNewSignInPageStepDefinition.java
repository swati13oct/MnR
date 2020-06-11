package acceptancetests.memberredesign.newSignIn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard_deprecated.member.ulayer.MemberNewSignInPage;
import pages.dashboard_deprecated.member.ulayer.NewMemebrRegistrationPage;
import pages.dashboard_deprecated.member.ulayer.UsernamePasswordAssistancePage;
import pages.member_deprecated.ulayer.LoginPage;


public class MemberNewSignInPageStepDefinition {
	@Autowired
	MRScenario loginScenario;


	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	WebDriver driver;

	@Given("^I am a  member on the sign-in page$")
	public void I_am_a_memebr_on_the_signin_page () throws Exception {

		WebDriver wd = getLoginScenario().getWebDriver();
		LoginPage login_page = new LoginPage(wd);
		login_page.navigateToNewDashboardUrl();
		MemberNewSignInPage sign_Page = (MemberNewSignInPage) login_page.loginPageObject();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstantsMnR.NEW_SIGN_PAGE,sign_Page);

	}

	@When("^I have not entred any thing in both username and password fields$")
	public void i_press_the_signin_button() {		

		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstantsMnR.NEW_SIGN_PAGE);		
		sign_Page.clearUnAndPwfields();		
	}

	@Then("^I should get the error message on both fields$")
	public void I_should_get_the_error_message_on_both_fields() {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstantsMnR.NEW_SIGN_PAGE);	
		System.out.println("Both UN and PW fields are Empty");
		System.out.println("Validating the Username and Password Error messages ===========>"+ (sign_Page.validateUsernamePswdError()));
	}

	@When("^I have not entred any thing in  username  field$")
	public void I_have_not_entred_any_thing_in_username_field() {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstantsMnR.NEW_SIGN_PAGE);
		sign_Page.onlypasswerdEntred();

	}

	@Then("^I should get the error message on username field$")
	public void I_should_get_the_error_message_on_username_field() {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstantsMnR.NEW_SIGN_PAGE);
		System.out.println("only password entred");
		System.out.println("validating the Username error =======>"+ sign_Page.validateUsernameError()); 
	}

	@When("^I have not entred any thing in password field$")
	public void I_have_not_entred_any_thing_in_password_field() {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstantsMnR.NEW_SIGN_PAGE);
		sign_Page.onlyUsernameEntred();

	}

	@Then("^I should get the error message on password field$")
	public void I_should_get_the_error_message_on_password_field() {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstantsMnR.NEW_SIGN_PAGE);
		System.out.println("Only Username Entred ");
		System.out.println("validating the password error message ========>" + sign_Page.validatepassworderror()); 

	}

	@When("^I click on the forgot your username and password link on signin page$")
	public void clickUsernamePasswordLink() throws InterruptedException {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstantsMnR.NEW_SIGN_PAGE);
		UsernamePasswordAssistancePage usernamePasswordAssistancePage = sign_Page.clickForgotUsernamePasswordLink();
		getLoginScenario().saveBean(PageConstantsMnR.USERNAME_PASSWORD_ASSISTANCE_PAGE,usernamePasswordAssistancePage);

	}

	@Then("^I should be taken to Username and Password Assistance page$")
	public void verifyUsernamePasswordAssistancePage() {
		UsernamePasswordAssistancePage usernamePasswordAssistancePage =  (UsernamePasswordAssistancePage) getLoginScenario().getBean(PageConstantsMnR.USERNAME_PASSWORD_ASSISTANCE_PAGE);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(usernamePasswordAssistancePage.currentUrl().contains("identityassistance"));
	}

	@And("^siteID should be passed to the URL of Username and Password Assistance page$")

	public void verifySiteID (DataTable SITEID) throws Exception {

		List<DataTableRow> AttributesRow = SITEID
				.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap .put(AttributesRow.get(i).getCells()
					.get(0), AttributesRow.get(i).getCells().get(1));
		}
		String siteID = urlAttributesMap.get("SiteID");
		UsernamePasswordAssistancePage usernamePasswordAssistancePage =  (UsernamePasswordAssistancePage) getLoginScenario().getBean(PageConstantsMnR.USERNAME_PASSWORD_ASSISTANCE_PAGE);
		Assert.assertTrue(usernamePasswordAssistancePage.currentUrl().contains(siteID));
		String PAGE_URL = usernamePasswordAssistancePage.currentUrl().toString();
		System.out.println("Actual SiteID in the URL is "+PAGE_URL);
		System.out.println("Expected SiteID in the URL is "+siteID);
	}
	@When("^the user click on registration page$")
	public void the_user_click_on_registration_page() {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstantsMnR.NEW_SIGN_PAGE);

		NewMemebrRegistrationPage newMemebrRegistrationPage =  sign_Page.clickRegisterbutton();
		getLoginScenario().saveBean(PageConstantsMnR.NEW_REGISTRATION_PAGE,newMemebrRegistrationPage);

	}

	@Then("^I should be taken to the new Registration page$")
	public void I_should_be_taken_to_the_new_Registration_page() {
		NewMemebrRegistrationPage NewMemebrRegistrationPage =  (NewMemebrRegistrationPage) getLoginScenario().getBean(PageConstantsMnR.NEW_REGISTRATION_PAGE);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(NewMemebrRegistrationPage.currentUrl().contains("member-registration"));
	}



	@Then("^I should see the SiteID that i have passed on the New Registration page$")
	public void I_should_see_the_SiteID_that_i_have_passed_on_the_New_Registration_page(DataTable regsiteID) {	   

		List<DataTableRow> AttributesRow = regsiteID
				.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap .put(AttributesRow.get(i).getCells()
					.get(0), AttributesRow.get(i).getCells().get(1));
		}
		String regsiteID1 = urlAttributesMap.get("RegSiteID");

		NewMemebrRegistrationPage NewMemebrRegistrationPage =  (NewMemebrRegistrationPage) getLoginScenario().getBean(PageConstantsMnR.NEW_REGISTRATION_PAGE);

		Assert.assertTrue(NewMemebrRegistrationPage.currentUrl().contains(regsiteID1));
		System.err.println("Actual SiteID in the URL is "+driver.getCurrentUrl());
		System.err.println("Expected SiteID in the URL is "+regsiteID1);

	}
}







