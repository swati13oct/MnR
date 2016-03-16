package acceptancetests.learnaboutplans.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.LearnAboutMedicarePage;
import pages.acquisition.ulayer.PlanSelectorPage;
import pages.acquisition.ulayer.PrepareforInitialEnrollmentPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.learnaboutplans.data.LearnAboutPlansCommonConstants;
import acceptancetests.lookupzipcode.data.ZipLookupCommonConstants;
import acceptancetests.planselector.data.PlanSelectorCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */

public class LearnAboutPlansAarpStepDefinition {

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
	
	@When("^the user picks a topic in learn more widget for AARP site$")
	public void learnaboutplans(DataTable addressAttributes) {
        
		AcquisitionHomePage homepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,homepage);
		
		List<DataTableRow> addressAttributesRow = addressAttributes.getGherkinRows();
		Map<String, String> addressAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < addressAttributesRow.size(); i++) {
		addressAttributesMap.put(addressAttributesRow.get(i).getCells().get(0), addressAttributesRow.get(i).getCells().get(1));
		}
		
		String picktopic = addressAttributesMap.get("picktopic");
		System.out.println("picktopic=="+picktopic);
		Object objPickTopicJson = homepage.learnmoreaboutplan(picktopic);
		String fileName = null;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator + LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS
				+ File.separator ;
		if(objPickTopicJson !=null){
			
			System.out.println("objPickTopicJson=="+objPickTopicJson.getClass().toString());
			
			if(objPickTopicJson.getClass().toString().contains("LearnAboutMedicarePage")){
			 fileName ="learnaboutmedicare";
			 LearnAboutMedicarePage obj = (LearnAboutMedicarePage) objPickTopicJson;
			 getLoginScenario().saveBean(LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS_ACTUAL,obj.learnaboutMedicareJson);
			
			} else if(objPickTopicJson.getClass().toString().contains("PrepareforInitialEnrollmentPage")){
				fileName = "initialenroll";
				PrepareforInitialEnrollmentPage obj = (PrepareforInitialEnrollmentPage) objPickTopicJson;
				 getLoginScenario().saveBean(LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS_ACTUAL,obj.initalenrollJson);
				
			}

				JSONObject expectedJson = MRScenario.readExpectedJson(fileName, directory);
				getLoginScenario().saveBean(LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS_EXPECTED,expectedJson);
				Assert.assertTrue(true);
			} else{
				Assert.fail("Error accessing the page ");
			}
	}
	
	@Then("^the user validates the content on the page in AARP site$")
	public void validates_zipcodes() {
		JSONObject expectedJson = (JSONObject) getLoginScenario()
				.getBean(LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS_EXPECTED);
		JSONObject actualJson = (JSONObject) getLoginScenario()
				.getBean(LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS_ACTUAL);
				System.out.println("expectedJson===>"
				+ expectedJson.toString());
		System.out.println("actualJson===>"
				+ actualJson.toString());
			try {
			JSONAssert.assertEquals(expectedJson,
					actualJson, true);
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