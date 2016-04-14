package acceptancetests.planselector.ulayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.PlanSelectorPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.planselector.data.PlanSelectorCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

/**
 * @author pagarwa5
 *
 */

public class PlanSelectorAARPStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the AARP medicare site landing page$")
	public void landing_page_aarpsite() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
	}
	
	@When("^the user clicks on takeaquiz button to select the plan for AARP site$")
	public void planselector() {
	
		
		AcquisitionHomePage homepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PlanSelectorPage objPlanSelectorJson = homepage.planselector();		 
		if (objPlanSelectorJson != null) {
		
			
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER + File.separator
					+ PlanSelectorCommonConstants.PLAN_SELECTOR_PLAN + File.separator;
			JSONObject learnaboutplansExpectedJson = MRScenario.readExpectedJson(PlanSelectorCommonConstants.PLAN_SELECTOR_PLAN, directory);
			System.out.println("learnaboutplansExpectedJson=="+learnaboutplansExpectedJson.toString());
			System.out.println("objPlanSelectorJson=="+objPlanSelectorJson.planselectorJson.toString());
			
			
			getLoginScenario().saveBean(PlanSelectorCommonConstants.PLAN_SELECTOR_EXPECTED,learnaboutplansExpectedJson);
			getLoginScenario().saveBean(PlanSelectorCommonConstants.PLAN_SELECTOR_ACTUAL,objPlanSelectorJson.planselectorJson);
					
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing planselector page ");
		}
		
	}
	
	@Then("^the user validates the planselector is opened with right page content for AARP site$")
	public void validate_planselector() {
		JSONObject expectedJson = (JSONObject) getLoginScenario()
				.getBean(PlanSelectorCommonConstants.PLAN_SELECTOR_EXPECTED);
		JSONObject actualJson = (JSONObject) getLoginScenario()
				.getBean(PlanSelectorCommonConstants.PLAN_SELECTOR_ACTUAL);
		
		System.out.println("then learnaboutplansExpectedJson=="+expectedJson.toString());
		System.out.println("then objPlanSelectorJson=="+actualJson.toString());
		
		try {
			JSONAssert.assertEquals(expectedJson,actualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	    
	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		if (wd != null) {
			wd.quit();
		}

		getLoginScenario().flushBeans();
	}
}