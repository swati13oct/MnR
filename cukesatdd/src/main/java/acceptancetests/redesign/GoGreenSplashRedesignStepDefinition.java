package acceptancetests.redesign;



import java.util.LinkedHashMap;
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
import pages.member.redesign.ContactUsPage;
import pages.member.redesign.GoGreenSplashPage;
import pages.member.redesign.NewLoginPage;
import pages.member.redesign.NewRegistrationPage;
import pages.member.redesign.TestHarnessPage;

public class GoGreenSplashRedesignStepDefinition {
	/**
	 * 
	 */
		@Autowired
		MRScenario loginScenario;

		public MRScenario getLoginScenario() {
			return loginScenario;
		}
		
		@Given("^I am a Federal member on the member redesign registration page$")
		public void i_am_a_Federal_member_on_the_member_redesign_registration_page(DataTable givenAttributes) {

			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
			    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			// get parameter username and password
			String memberId = memberAttributesMap.get("MemberId");
			String dob = memberAttributesMap.get("DOB");
			WebDriver wd = getLoginScenario().getWebDriver();
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

			NewRegistrationPage registrationPage = new NewRegistrationPage(wd);
			
			GoGreenSplashPage goGreenSplashPage = (GoGreenSplashPage) registrationPage.registerWith(memberId, dob);

			getLoginScenario().saveBean(PageConstants.GO_GREEN_SPLASH_PAGE,goGreenSplashPage);
		}
		
		@When("^the user navigates to go green splash page$")
		public void the_user_navigates_to_go_green_splash_page() {
			
			GoGreenSplashPage goGreenSplashPage = (GoGreenSplashPage) getLoginScenario().getBean(PageConstants.GO_GREEN_SPLASH_PAGE);
			
			if(goGreenSplashPage != null)				
				getLoginScenario().saveBean(PageConstants.GO_GREEN_SPLASH_PAGE,
						goGreenSplashPage);
		}
		
		@Then("^the user selects the paperless prefereneces$")
		public void the_user_selects_the_paperless_prefereneces()
		{
			GoGreenSplashPage goGreenSplashPage = (GoGreenSplashPage) getLoginScenario().getBean(PageConstants.GO_GREEN_SPLASH_PAGE);
			
			goGreenSplashPage.selectpaperlessprefereneces();
			
			if(goGreenSplashPage != null)				
				getLoginScenario().saveBean(PageConstants.GO_GREEN_SPLASH_PAGE,
						goGreenSplashPage);
		}
		
		@Then("^the preferences should be saved$")
		public void the_preferences_should_be_saved()
		{
			GoGreenSplashPage goGreenSplashPage = (GoGreenSplashPage) getLoginScenario().getBean(PageConstants.GO_GREEN_SPLASH_PAGE);
			
			goGreenSplashPage.savePreferences();
			
			if(goGreenSplashPage != null)				
				getLoginScenario().saveBean(PageConstants.GO_GREEN_SPLASH_PAGE,
						goGreenSplashPage);
			
		}
		@Then("^the user validates confirmation message on go green confirmation page$")
		public void the_user_validates_confirmation_message_on_go_green_confirmation_page()
		{
			GoGreenSplashPage goGreenSplashPage = (GoGreenSplashPage) getLoginScenario().getBean(PageConstants.GO_GREEN_SPLASH_PAGE);
			
			goGreenSplashPage.validateConfirmationMessage();
			
			if(goGreenSplashPage != null)				
				getLoginScenario().saveBean(PageConstants.GO_GREEN_SPLASH_PAGE,
						goGreenSplashPage);
		}
		
		@Then("^the user click the save preferences without agree terms and conditions$")
		public void the_user_click_the_save_preferences_without_agree_terms_and_conditions()
		{
			GoGreenSplashPage goGreenSplashPage = (GoGreenSplashPage) getLoginScenario().getBean(PageConstants.GO_GREEN_SPLASH_PAGE);
			
			goGreenSplashPage.savePreferences();
			
			if(goGreenSplashPage != null)				
				getLoginScenario().saveBean(PageConstants.GO_GREEN_SPLASH_PAGE,
						goGreenSplashPage);
			
		}
		
		@Then("^the user should see the error message$")
		public void the_user_should_see_the_error_message()
		{
			GoGreenSplashPage goGreenSplashPage = (GoGreenSplashPage) getLoginScenario().getBean(PageConstants.GO_GREEN_SPLASH_PAGE);
			
			goGreenSplashPage.validateErrorMessage();
			
			if(goGreenSplashPage != null)				
				getLoginScenario().saveBean(PageConstants.GO_GREEN_SPLASH_PAGE,
						goGreenSplashPage);
		}
	}

