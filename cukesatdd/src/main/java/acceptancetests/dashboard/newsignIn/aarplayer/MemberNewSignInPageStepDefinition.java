package acceptancetests.dashboard.newsignIn.aarplayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.member.ulayer.ClaimSummarypage;
import pages.dashboard.member.ulayer.MemberNewSignInPage;
import pages.dashboard.member.ulayer.UsernamePasswordAssistancePage;


public class MemberNewSignInPageStepDefinition {
	@Autowired
	MRScenario loginScenario;


	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	WebDriver driver;

	@Given("^I am a  member on the sign-in page$")
	public void I_am_a_memebr_on_the_signin_page (DataTable Url) throws Exception {

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		List<DataTableRow> AttributesRow = Url
				.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap .put(AttributesRow.get(i).getCells()
					.get(0), AttributesRow.get(i).getCells().get(1));
		}
		String url = urlAttributesMap.get("URL");
		wd.get(url);

		MemberNewSignInPage sign_Page = new MemberNewSignInPage(wd);
		sign_Page.validateNewSignPage();
		if (sign_Page != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.NEW_SIGN_PAGE,sign_Page);
			Assert.assertTrue(true);
		}

	}

	@When("^I have not entred any thing in both username and password fields$")
	public void i_press_the_signin_button() {		
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstants.NEW_SIGN_PAGE);	
		sign_Page.clearUnAndPwfields();		
		/*
		 */

	}
	@Then("^I should get the error message on both fields$")
	public void I_should_get_the_error_message_on_both_fields() {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstants.NEW_SIGN_PAGE);	

		System.out.println("Both UN and PW fields are Empty");
		System.out.println("Validating the Username and Password Error messages ===========>"+ (sign_Page.validateUsernameError() && sign_Page.validatepassworderror()));
	}

	@When("^I have not entred any thing in  username  field$")
	public void I_have_not_entred_any_thing_in_username_field() {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstants.NEW_SIGN_PAGE);
		sign_Page.onlypasswerdEntred();

	}

	@Then("^I should get the error message on username field$")
	public void I_should_get_the_error_message_on_username_field() {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstants.NEW_SIGN_PAGE);
		System.out.println("only password entred");
		System.out.println("validating the Username error =======>"+ sign_Page.validateUsernameError()); 
	}

	@When("^I have not entred any thing in password field$")
	public void I_have_not_entred_any_thing_in_password_field() {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstants.NEW_SIGN_PAGE);
		sign_Page.onlyUsernameEntred();

	}

	@Then("^I should get the error message on password field$")
	public void I_should_get_the_error_message_on_password_field() {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstants.NEW_SIGN_PAGE);
		System.out.println("Only Username Entred ");
		System.out.println("validating the password error message ========>" + sign_Page.validatepassworderror()); 

	}
	
	@When("^I click on the forgot your username and password link on signin page$")
	public void clickUsernamePasswordLink() throws InterruptedException {
		MemberNewSignInPage sign_Page =  ( MemberNewSignInPage) getLoginScenario().getBean(PageConstants.NEW_SIGN_PAGE);
		UsernamePasswordAssistancePage usernamePasswordAssistancePage = sign_Page.clickForgotUsernamePasswordLink();
		getLoginScenario().saveBean(PageConstants.USERNAME_PASSWORD_ASSISTANCE_PAGE,usernamePasswordAssistancePage);
		
		}
		
	@Then("^I should be taken to Username and Password Assistance page$")
	public void verifyUsernamePasswordAssistancePage() {
		UsernamePasswordAssistancePage usernamePasswordAssistancePage =  (UsernamePasswordAssistancePage) getLoginScenario().getBean(PageConstants.USERNAME_PASSWORD_ASSISTANCE_PAGE);
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
		UsernamePasswordAssistancePage usernamePasswordAssistancePage =  (UsernamePasswordAssistancePage) getLoginScenario().getBean(PageConstants.USERNAME_PASSWORD_ASSISTANCE_PAGE);
		Assert.assertTrue(usernamePasswordAssistancePage.currentUrl().contains(siteID));
		String PAGE_URL = usernamePasswordAssistancePage.currentUrl().toString();
		System.out.println("Actual SiteID in the URL is "+PAGE_URL);
		System.out.println("Expected SiteID in the URL is "+siteID);
		    }
}
	






