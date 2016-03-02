/**
 * 
 */
package acceptancetests.ourplansdropdown.ulayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.ElementData;
import pages.acquisition.ulayer.AcquisitionHomePage;

import pages.acquisition.ulayer.OurPlansPage;
//import pages.acquisition.ulayer.DisclaimersAARPPage;
//import pages.acquisition.ulayer.OurPlansPage;
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
public class OurPlansDropdownAarpStepDefination {
	
	@Autowired
	
	MRScenario loginScenario;
	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^I am a user who has navigated to a page on the ULAYER acquistion site$")
	public void the_user_on_AARP_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@When("^I hover over the Our Plans button$")
	public void the_user_hover_on_ourplans_link() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		aquisitionhomepage.hoverourplanslink();
		
	}
	
	@Then("^drop down column 1 should appear with the following in order - Find all plans in your area header, Enter ZIP field, Find Plans button, Need Help content, Need Help Link, Find right plan header, take quiz button$")
	
	public void the_user_accesses_OurPlansDropdown_link() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage != null){
		JSONObject ourplansdropdownactualJson = aquisitionhomepage
				.accessingOurPlanslink();

		
		
		/* Get expected data */
		String fileName = "ourplansdropdownexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator
				+ AcquistionCommonConstants.HEADER_FLOW_NAME
				+ File.separator;
		JSONObject ourplansdropdownexpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.OUR_PLANS_DROPDOWN_ACTUAL,
				ourplansdropdownactualJson);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.OUR_PLANS_DROPDOWN_EXPECTED,
				ourplansdropdownexpectedJson);
		
		Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in Home page");
		}

	
	}
	
	@Then("^user validates all the content and links in the Our Plans drop down$")
	public void validate_ourPlans_dropdown(){
		JSONObject ourplansdropdownactualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.OUR_PLANS_DROPDOWN_ACTUAL);

		JSONObject ourplansdropdownexpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.OUR_PLANS_DROPDOWN_EXPECTED);

		System.out.println("ourPlansDropdownActualJson---->" + ourplansdropdownactualJson);
		System.out.println("ourPlansDropdownExpectedJson---->" + ourplansdropdownexpectedJson);
		try {
			JSONAssert.assertEquals(ourplansdropdownexpectedJson,  ourplansdropdownactualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@When("^I click find ZIP link$")
	
	public void the_user_clicks_on_lookupzipcodelink() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	
		OurPlansPage ourPlansPage = aquisitionhomepage.lookupzipcodeclick();
		if(ourPlansPage != null){
			getLoginScenario().saveBean(PageConstants.OUR_PLANS_PAGE,
					ourPlansPage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Error in page");
		}

	}
	

	

	
	@When("^I DON'T enter a ZIP and I click Find Plans button$")
	
	public void user_click_findplans_button_without_zip() {
		
		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);
	
		
		ourPlansPage.findplansbuttonclick2();
		
		Assert.assertTrue(true);


	
	}
	
	
	@Then("^error message should be appeard$")
	
	
	public void error_message_should_get_appear() {
		

		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);
		
		  ourPlansPage.ErrorMessage();
		
		
	}
	
	
	@When("^I DON'T enter 5 numbers in the ZIP and I click Find Plans button$")
	
	public void user_enter_lessthan5numbersinZIP() {
	
		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);
	
	
	
	Boolean value= ourPlansPage.clicktextfield();
	if (value != null && value == true) {
		Assert.assertTrue(true);
	} else {
		Assert.fail("failed");
	}
	
	 
		
	}
	
	@Then("^error message should appear$")
	
	public void error_message() {
		
		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);

		ourPlansPage.errormessage();
	}
	
	
	@When("^I enter 5 numbers and I click Find Plans button$")
	
	
	public void user_enters_correct_zip_code() {
		
		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);
		
		ourPlansPage.correctzipcode();
			
	}
		
	@Then("^I am navigated to view plans link$")
	
	public void viewplanslink() {
		
		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);
		
		ourPlansPage.findplansbuttonclick2();  // meed to change the name
		getLoginScenario().saveBean(PageConstants.OUR_PLANS_PAGE,
				ourPlansPage);
		Assert.assertTrue(true);

		
		}
	

	
	
	

	
	
	
	
}	
	