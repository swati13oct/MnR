package acceptancetests.alreadymember.bluelayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.LoginAssistancePage;
import pages.acquisition.bluelayer.RegistrationHomePage;
import pages.member.bluelayer.AccountHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;

		
/**
* @author saduri
*
*/
public class AlreadyMemberUmsStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the UHC Medicaresolutions Site$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
	}

	
	@Then("^the Already a Member button should display in it's inactive state light blue button$")
	public void access_brand_section() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		//to show a button is active or inactive use boolean
		Boolean state = acquisitionHomePage
				.validate_alreadyPlanMemberButton_inactive();
		if (state != null && state == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Already a Member button is active"); }
		 }
		
		
	/*	
	@And ("^user clicks Already a member button in its inactive state$")
	public void click_inactive_alreadyPlanMember_ums() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean state = acquisitionHomePage
				.validate_alreadyPlanMemberButton_active();
		// getting actual json object
		JSONObject alreadyPlanMemberActualJson = acquisitionHomePage
				.getAlreadyPlanMemberJSON();
		// Get expected data 
		String fileName = "alreadyPlanMemberExpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + AcquistionCommonConstants.HEADER_FLOW_NAME
				+ File.separator;
		JSONObject alreadyPlanMemberExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.ALREADY_PLAN_MEMBER_ACTUAL,
				alreadyPlanMemberActualJson);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.ALREADY_PLAN_MEMBER_EXPECTED,
				alreadyPlanMemberExpectedJson);

		if (state != null && state == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Already a Member button dropdown is not displayed"); }
		}
	*/
			
	@And ("^user clicks and enters invalid user ID or password in the fields$")
		public void invalid_values () {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = acquisitionHomePage.signin_error();
		if (value != null && value==true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed"); 
			}
		}
	
	@And ("^user clicks sign in button$")
		public void signin_click() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean errorMessage = acquisitionHomePage.signinErrorValidation();
		if(errorMessage != null && errorMessage){
			Assert.assertTrue(true);
		} else {
			Assert.fail("signin button error message not displayed"); }
		}
				

	
		
	@And ("^user clicks on forgot your username or password link of UMS site$")
		public void click_forgotUsernamePassword() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		LoginAssistancePage loginAssistancePage = acquisitionHomePage
				.forgotUsernamePasswordClick();
		if (loginAssistancePage != null) {
			getLoginScenario().saveBean(PageConstants.LOGIN_ASSISTANCE_PAGE,
					loginAssistancePage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Login Assistance page not found");
		}

	}
	@And ("^user switches back to acquisition home page of UMS Site$")
	public void backToHomePage() {
		LoginAssistancePage loginAssistancePage = (LoginAssistancePage) getLoginScenario()
				.getBean(PageConstants.LOGIN_ASSISTANCE_PAGE);
		AcquisitionHomePage acquisitionHomePage = loginAssistancePage
				.switchBack();
		if (acquisitionHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acquisitionHomePage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Home page not found");
		}

	}
	@And ("^user clicks on register here link of UMS site$")
	public void click_registerHere()	{
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RegistrationHomePage registrationHomePage=acquisitionHomePage.registerHereLinkClick();
		if(registrationHomePage!= null){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Registration page not found");
			
		}
		

	
	}
	
	@And ("^user switches back to acquisition home page of UMS Site from Registration page$")
	public void backToHomePageFromRegistration() {
		RegistrationHomePage registrationHomePage = (RegistrationHomePage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_PAGE);
		AcquisitionHomePage acquisitionHomePage = registrationHomePage
				.switchBack();
		if (acquisitionHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acquisitionHomePage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Home page not found");
		}

	}

	/*@Given("^the user is on the UHC Medicaresolutions HomePage$")
	public void UHC_Medicaresolutions_Homepage() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
	}*/
	

		
		
		@Then ("^user clicks on Already a member button in its inactive state on the Brand section of UMS site$")
		public void user_on_brandsection_of_UMS (){			
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
					.getBean(PageConstants.ACQUISITION_HOME_PAGE);
			Boolean state = acquisitionHomePage
					.validate_alreadyPlanMemberButton_active();
			// getting actual json object
			JSONObject alreadyPlanMemberActualJson = acquisitionHomePage
					.getAlreadyPlanMemberJSON();
			// Get expected data 
			String fileName = "alreadyPlanMemberExpected";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + AcquistionCommonConstants.HEADER_FLOW_NAME
					+ File.separator;
			JSONObject alreadyPlanMemberExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);

			getLoginScenario().saveBean(
					AcquistionCommonConstants.ALREADY_PLAN_MEMBER_ACTUAL,
					alreadyPlanMemberActualJson);
			getLoginScenario().saveBean(
					AcquistionCommonConstants.ALREADY_PLAN_MEMBER_EXPECTED,
					alreadyPlanMemberExpectedJson);

			if (state != null && state == true) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Already a Member button dropdown is not displayed"); }
			}
		
	
	@And ("^user enters a valid user id or password$")
	public void Sign_in_with_validvalues(){
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
					.getBean(PageConstants.ACQUISITION_HOME_PAGE);
			Boolean value = acquisitionHomePage.signin_successful();
			if (value != null && value==true) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("failed"); 
				}
			}
	
	@And ("^user clicks sign in button after entering valid credentials$")
	public void signin_click_successful() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AccountHomePage accountHomePage = acquisitionHomePage.signinClick();
		if(accountHomePage != null){
			getLoginScenario().saveBean(acceptancetests.atdd.data.member.PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("signin button not clickable"); }
		}
	
		
	

	@Then ("^user should be logged into their account and land on their home page$")
		public void Signin_successfully() {
			JSONObject alreadyPlanMemberActualJson = (JSONObject) getLoginScenario()
					.getBean(AcquistionCommonConstants.ALREADY_PLAN_MEMBER_ACTUAL);

			JSONObject alreadyPlanMemberExpectedJson = (JSONObject) getLoginScenario()
					.getBean(AcquistionCommonConstants.ALREADY_PLAN_MEMBER_EXPECTED);

			System.out.println("alreadyPlanMemberActualJson---->" + alreadyPlanMemberActualJson);
			System.out.println("alreadyPlanMemberExpectedJson---->" + alreadyPlanMemberExpectedJson);
			try {
				JSONAssert.assertEquals(alreadyPlanMemberExpectedJson, alreadyPlanMemberActualJson,
						true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	
		
	}
	

	
	
	



	
		
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
