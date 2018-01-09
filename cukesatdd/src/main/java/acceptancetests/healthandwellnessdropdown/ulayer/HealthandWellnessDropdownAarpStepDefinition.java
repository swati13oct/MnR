/**
 * 
 */
package acceptancetests.healthandwellnessdropdown.ulayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.HealthCentersPage;
import pages.acquisition.ulayer.HealthLivingPage;
import pages.acquisition.ulayer.HealthManagementProgramPage;
import pages.acquisition.ulayer.HealthToolsPage;
import pages.acquisition.ulayer.LoginAssistancePage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.DiscoverMoreResourcesPage;
import pages.acquisition.ulayer.ExploreChangingPlansPage;
import pages.acquisition.ulayer.LearnAboutMedicarePage;
import pages.acquisition.ulayer.PrepareforInitialEnrollmentPage;
import pages.acquisition.ulayer.PrescriptionDrugPage;
import pages.acquisition.ulayer.RegistrationHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

/**
 * @author naggarw2
 *
 */
public class HealthandWellnessDropdownAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	
	
	
	
	
	@Given("^I am a user of ULAYER site$")
	public void the_user_on_AARP_Medicareplans_Site() {
		
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	
	@When("^I hover on Health and Wellness link$")

	public void the_user_hover_on_healthandwellness_link() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		aquisitionhomepage.hoverhealthandwellnesslink();
		
	}
	
	
	
	@Then("^user validates all the links present under Health And Wellness$")
	
	public void the_user_accesses_HealthAndWellnessDropdown_link() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage != null){
		JSONObject healthandwellnessdropdownactualJson = aquisitionhomepage
				.accessinghealthandwellnesslink();
		
			
		/* Get expected data */
	
	
		String fileName = "healthandwellnessdropdownexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator
				+ AcquistionCommonConstants.HEADER_FLOW_NAME
				+ File.separator;
		JSONObject healthandwellnessdropdownexpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.HEALTH_AND_WELLNESS_DROPDOWN_ACTUAL,
				healthandwellnessdropdownactualJson);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.HEALTH_AND_WELLNESS_DROPDOWN_EXPECTED,
				healthandwellnessdropdownexpectedJson);
		
		Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  page");
		}

	
	}
	
	
	
	@And("^I click Forgot user name or password link$")
	
	public void user_clicks_forgot_username_or_password_link() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		LoginAssistancePage loginAssistancePage = aquisitionhomepage.forgotusernameandpasswordclick();
		if(loginAssistancePage!= null){
		getLoginScenario().saveBean(PageConstants.LOGIN_ASSISTANCE_PAGE,
				loginAssistancePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Username Assistance Page not found");
		}
		
	}
	
	@Then("^user will switch back on home page$")
	
	public void user_switches_back_on_home_page() {
		
		LoginAssistancePage loginAssistancePage  = (LoginAssistancePage) getLoginScenario()
				.getBean(PageConstants.LOGIN_ASSISTANCE_PAGE);
		loginAssistancePage.switchBack();
		
		
	}
	

	
	@And("^when I click register here link$")
	
	public void user_clicks_register_link() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		RegistrationHomePage registrationHomePage= aquisitionhomepage.registerHereClick();
		if(registrationHomePage!= null){
			getLoginScenario().saveBean(PageConstants.REGISTRATION_PAGE,
					registrationHomePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Registration page not found");
		}
		
	}
	
	@Then("^user will switch back on home page again$")
	
	public void user_switches_back_on_home_page_again() {
		
		RegistrationHomePage registrationHomePage  = (RegistrationHomePage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_PAGE);
		registrationHomePage.switchBack();
		
		
	}
	
	
	
	@And("^when I click Top Health Centers link$")
	
	public void user_clicks_tophealthcenterslink_on_acq_page() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		HealthCentersPage healthcenterspage = aquisitionhomepage.healthcentersclick();
		if(healthcenterspage!= null){
			getLoginScenario().saveBean(PageConstants.HEALTH_CENTERS_PAGE,
					healthcenterspage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Health Centers page not found ");
		}
		
	
	}	
	
	@And("^when I click Health Management Programs link$")
	
	public void user_clicks_Health_Management_Program_Link() {
		
		HealthCentersPage healthcenterspage = (HealthCentersPage) getLoginScenario()
				.getBean(PageConstants.HEALTH_CENTERS_PAGE);
		
		HealthManagementProgramPage healthmanagementprogram = healthcenterspage.HealthManagementProgramClick();
		if(healthmanagementprogram!= null){
			getLoginScenario().saveBean(PageConstants.HEALTH_MANAGEMENT_PROGRAM_PAGE,
					healthmanagementprogram);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Health Managemtn Program page not found ");
		}
		
	}
	
	
	@And("^when I click Tools for Healthy Living link$")
	
	public void user_clicks_Health_Living_Link() {
		
		HealthManagementProgramPage healthmanagementprogram = (HealthManagementProgramPage) getLoginScenario()
				.getBean(PageConstants.HEALTH_MANAGEMENT_PROGRAM_PAGE);
		
		HealthLivingPage healthyliving = healthmanagementprogram.healthylivingclick();
		
		if(healthyliving!= null){
			getLoginScenario().saveBean(PageConstants.HEALTH_LIVING_PAGE,
					healthyliving);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Health Living Program page not found ");
		}
		
		
	}
		
	@And("^when I click Health Search Tools link$")
	
	public void user_clicks_Health_Search_Tools_Link() {
		
		HealthLivingPage healthyliving = (HealthLivingPage) getLoginScenario()
				.getBean(PageConstants.HEALTH_LIVING_PAGE);
		
		HealthToolsPage healthtools = healthyliving.HealthToolsClick();
		
		
		if(healthtools!= null){
			getLoginScenario().saveBean(PageConstants.HEALTH_TOOLS_PAGE,
					healthtools);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Health tools page not found ");
		}
		
	}
	
	@And("^when I click Prescription Drug Tools link$")
	
	public void user_clicks_Prescription_Drug_Tools_Link() {
		
		HealthToolsPage healthtools = (HealthToolsPage) getLoginScenario()
				.getBean(PageConstants.HEALTH_TOOLS_PAGE);
		
		PrescriptionDrugPage prescriptiondrug = healthtools.PrescriptionDrugToolsClick();
		
		
		if(prescriptiondrug!= null){
			getLoginScenario().saveBean(PageConstants.PRESCRIPTION_DRUG_TOOLS_PAGE,
					prescriptiondrug);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Health tools page not found ");
		}
		
	}
	
	@Then("^user validates all the content and links in the Health and wellness drop down$")
	public void validate_healthandwellness_dropdown(){
		JSONObject healthandwellnessdropdownactualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.HEALTH_AND_WELLNESS_DROPDOWN_ACTUAL);

		JSONObject healthandwellnessdropdownexpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.HEALTH_AND_WELLNESS_DROPDOWN_EXPECTED);

		System.out.println("healthandwellnessdropdownactualJson---->" + healthandwellnessdropdownactualJson);
		System.out.println("healthandwellnessdropdownexpectedJson---->" + healthandwellnessdropdownexpectedJson);
		try {
			JSONAssert.assertEquals(healthandwellnessdropdownexpectedJson,  healthandwellnessdropdownactualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
			
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
