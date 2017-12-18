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
import pages.member.redesign.DeregisterPage;
import pages.member.redesign.GoGreenSplashPage;
import pages.member.redesign.NewLoginPage;
import pages.member.redesign.NewRegistrationPage;
import pages.member.redesign.PreferencesPage;
import pages.member.redesign.RegistrationConfirmationPage;
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
		
		@Given("^I am a member on the member redesign login page$")
		public void I_am_a_member_on_the_member_redesign_login_page(DataTable givenAttributes) {

			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
			    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			// get parameter username and password
			String userName = memberAttributesMap.get("Username");
			String passWord = memberAttributesMap.get("Password");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + passWord);
			WebDriver wd = getLoginScenario().getWebDriver();
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

			NewLoginPage loginPage = new NewLoginPage(wd);
			
			TestHarnessPage testHarnessPage = (TestHarnessPage) loginPage.loginWith(userName, passWord);

			if (testHarnessPage != null) {
				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
				getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE,testHarnessPage);
				Assert.assertTrue(true);
			}
			
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE,
					testHarnessPage);
		}
		
		@When("^the user navigates to preferences page to access go green$")
		public void the_user_navigates_to_preferences_page_to_access_go_green() {
			
			TestHarnessPage testHarnessPage = (TestHarnessPage) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			
			PreferencesPage preferencesPage = testHarnessPage.navigateToPreferencesPage();
			
			if(preferencesPage != null)				
				getLoginScenario().saveBean(PageConstants.PREFERENCES_PAGE,
						preferencesPage);
		}
		
		@Given("^I am a Federal member on the member redesign registration page$")
		public void i_am_a_Federal_member_on_the_member_redesign_registration_page(DataTable givenAttributes) {

			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> registrationData = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
				registrationData.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			
			String username = registrationData.get("Username");
			
			WebDriver wd = getLoginScenario().getWebDriver();
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			
			// deregister the user for subsequent registration
	    	DeregisterPage deregisterPage = new DeregisterPage(wd);
	    	deregisterPage.deregisterUser(username);
	    	
			NewRegistrationPage registrationPage = new NewRegistrationPage(wd);
			
			RegistrationConfirmationPage registerConfirmationPage = (RegistrationConfirmationPage) registrationPage.registerWith(registrationData);
			
			GoGreenSplashPage goGreenSplashPage = (GoGreenSplashPage) registerConfirmationPage.goToHomePage();

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
			PreferencesPage preferencesPage = (PreferencesPage) getLoginScenario().getBean(PageConstants.PREFERENCES_PAGE);
			
			preferencesPage.selectpaperlessprefereneces();
			
			if(preferencesPage != null)				
				getLoginScenario().saveBean(PageConstants.PREFERENCES_PAGE,
						preferencesPage);
		}
		
		@Then("^the preferences should be saved$")
		public void the_preferences_should_be_saved()
		{
			PreferencesPage preferencesPage = (PreferencesPage) getLoginScenario().getBean(PageConstants.PREFERENCES_PAGE);
			
			preferencesPage.savePreferences();
			
			if(preferencesPage != null)				
				getLoginScenario().saveBean(PageConstants.PREFERENCES_PAGE,
						preferencesPage);
			
		}
		@Then("^the user validates confirmation message on go green confirmation page$")
		public void the_user_validates_confirmation_message_on_go_green_confirmation_page()
		{
			PreferencesPage preferencesPage = (PreferencesPage) getLoginScenario().getBean(PageConstants.PREFERENCES_PAGE);
			
			preferencesPage.validateConfirmationMessage();
			
			if(preferencesPage != null)				
				getLoginScenario().saveBean(PageConstants.PREFERENCES_PAGE,
						preferencesPage);
		}
		
		@Then("^the user click the save preferences without agree terms and conditions$")
		public void the_user_click_the_save_preferences_without_agree_terms_and_conditions()
		{
			PreferencesPage preferencesPage = (PreferencesPage) getLoginScenario().getBean(PageConstants.PREFERENCES_PAGE);
			
			preferencesPage.savePreferences();
			
			if(preferencesPage != null)				
				getLoginScenario().saveBean(PageConstants.PREFERENCES_PAGE,
						preferencesPage);
			
		}
		
		@Then("^the user should see the error message$")
		public void the_user_should_see_the_error_message()
		{
			PreferencesPage preferencesPage = (PreferencesPage) getLoginScenario().getBean(PageConstants.PREFERENCES_PAGE);
			
			preferencesPage.validateErrorMessage();
			
			if(preferencesPage != null)				
				getLoginScenario().saveBean(PageConstants.PREFERENCES_PAGE,
						preferencesPage);
		}
		
		@And("^validate the plan name$")
		public void validate_the_plan_name(DataTable givenAttributes)
		{
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
			    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			// get parameter username and password
			String planName = memberAttributesMap.get("PlanName");
			
			GoGreenSplashPage goGreenSplashPage = (GoGreenSplashPage) getLoginScenario().getBean(PageConstants.GO_GREEN_SPLASH_PAGE);
			
			goGreenSplashPage.validatePlanName(planName);
			
			if(goGreenSplashPage != null)				
				getLoginScenario().saveBean(PageConstants.GO_GREEN_SPLASH_PAGE,
						goGreenSplashPage);
		}
	}

