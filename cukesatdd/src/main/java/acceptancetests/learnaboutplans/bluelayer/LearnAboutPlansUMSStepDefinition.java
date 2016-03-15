package acceptancetests.learnaboutplans.bluelayer;

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

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.LearnAboutMedicareuhcPage;
import pages.acquisition.bluelayer.PrepareForInitialEnrollmentuhcPage;
import pages.acquisition.ulayer.PrepareforInitialEnrollmentPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.learnaboutplans.data.LearnAboutPlansCommonConstants;
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

public class LearnAboutPlansUMSStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the UMS medicare site landing page$")
	public void landing_page_aarpsite() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
	}
	
	@When("^the user picks a topic in learn more widget for UMS site$")
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
		Object objPickTopicJson = homepage.pickatopic(picktopic);
		String fileName = null;
		if(objPickTopicJson !=null){
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS
					+ File.separator ;
			System.out.println("objPickTopicJson=="+objPickTopicJson.getClass().toString());
			
			if(objPickTopicJson.getClass().toString().contains("LearnAboutMedicareuhcPage")){
			 fileName ="learnaboutmedicare";
			 LearnAboutMedicareuhcPage obj = (LearnAboutMedicareuhcPage) objPickTopicJson;
			 getLoginScenario().saveBean(LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS_ACTUAL,obj.learnaboutMedicareuhcJson);
			 System.out.println("actual==" +obj.learnaboutMedicareuhcJson.toString());
			} else if(objPickTopicJson.getClass().toString().contains("PrepareForInitialEnrollmentuhcPage")){
				fileName = "initialenroll";
				PrepareForInitialEnrollmentuhcPage obj = (PrepareForInitialEnrollmentuhcPage) objPickTopicJson;
				 getLoginScenario().saveBean(LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS_ACTUAL,obj.initalenrolluhcJson);
				 System.out.println("actual==" +obj.initalenrolluhcJson.toString());
				
			}

				JSONObject expectedJson = MRScenario.readExpectedJson(fileName, directory);
				getLoginScenario().saveBean(LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS_EXPECTED,expectedJson);
				System.out.println("expected==" +expectedJson.toString());
				Assert.assertTrue(true);
		} else{
			Assert.fail("Error accessing the page ");
		}
		
	}
	
	@Then("^the user validates the content on the page in UMS site$")
	public void validates_zipcodes() {
		JSONObject expectedJson = (JSONObject) getLoginScenario()
				.getBean(LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS_EXPECTED);
		JSONObject actualJson = (JSONObject) getLoginScenario()
				.getBean(LearnAboutPlansCommonConstants.LEARN_ABOUT_PLANS_ACTUAL);
				
				System.out.println("expectedJson===>"
				+ expectedJson.toString());
		System.out.println("actualJson>"
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