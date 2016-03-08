package acceptancetests.acquisitionhome.blayer;

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
import pages.acquisition.bluelayer.ZipcodeSelectionPage;
import pages.acquisition.bluelayer.ZipcodeLookupPage;
import acceptancetests.acquisitionhome.data.HomeCommonConstants;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */

public class AcquisitionHomeUMSStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the UMS medicare site landing page$")
	public void landing_page_umssite() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

	@When("^the user clicks on lookup zipcode link from UMS home page$")
	public void clicks_lookup_Zipcode_aarp() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
				
		ZipcodeLookupPage zipcodeLookupPage = aquisitionhomepage.lookupmodal();		 
		

		if (zipcodeLookupPage != null) {
			getLoginScenario().saveBean(PageConstants.ZIP_LOOK_UP_PAGE,
					zipcodeLookupPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing lookupzipcode link ");
		}

	}
	
	
	@And("^the user searches for zipcodes by entering the following Address and city and State details for UMS site$")
	public void enters_addres_city_state_details_aarp(
			DataTable addressAttributes) {
		List<DataTableRow> addressAttributesRow = addressAttributes
				.getGherkinRows();
		Map<String, String> addressAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < addressAttributesRow.size(); i++) {
			addressAttributesMap.put(addressAttributesRow.get(i).getCells()
					.get(0), addressAttributesRow.get(i).getCells().get(1));
		}

		String address = addressAttributesMap.get("Address");
		String city = addressAttributesMap.get("City");
		String state = addressAttributesMap.get("State");

		ZipcodeLookupPage zipcodeLookupAarpPage = (ZipcodeLookupPage) getLoginScenario()
				.getBean(PageConstants.ZIP_LOOK_UP_PAGE);
		
		ZipcodeSelectionPage zipcodeSelectionPage = zipcodeLookupAarpPage.enterAddressDetails(address, city, state);
		String fileName = address;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator + HomeCommonConstants.ACQ_HOME_DIRECTORY
				+ File.separator + state + File.separator + city
				+ File.separator;
		JSONObject zipcodeSelectionExpectedJson = MRScenario.readExpectedJson(fileName, directory);
		if (zipcodeSelectionPage != null) {
			getLoginScenario().saveBean(PageConstants.ZIP_SELECTION_PAGE,
					zipcodeSelectionPage);
			/* Get expected data */
				
			
			getLoginScenario().saveBean(HomeCommonConstants.ZIP_SELECTION_EXPECTED,zipcodeSelectionExpectedJson);
	
			JSONObject zipcodeSelectionActualJson = zipcodeSelectionPage.zipSelectionJson;
			getLoginScenario().saveBean(HomeCommonConstants.ZIP_SELECTION_ACTUAL,zipcodeSelectionActualJson);
		}
//		}else{
//			try {
//				System.out.println("zipcodeSelectionExpectedJson.getString=="+zipcodeSelectionExpectedJson);
//				JSONAssert.assertEquals(zipcodeSelectionExpectedJson.getString("homePageTitle"),zipcodeLookupAarpPage.getTitle(), true);
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}

	}

	
	@Then("^the user validates the list of zip codes in UMS site$")
	public void validate_zipcodeList() {
		AcquisitionHomePage homepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject zipcodeSelectionExpectedJson = (JSONObject) getLoginScenario()
				.getBean(HomeCommonConstants.ZIP_SELECTION_EXPECTED);
		
		JSONObject zipcodeSelectionActualJson = (JSONObject) getLoginScenario()
				.getBean(HomeCommonConstants.ZIP_SELECTION_ACTUAL);
		if(zipcodeSelectionActualJson !=null){
			
				try {
					JSONAssert.assertEquals(zipcodeSelectionExpectedJson,
							zipcodeSelectionActualJson, true);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}else{
			try {
				JSONAssert.assertEquals(zipcodeSelectionExpectedJson.getString("homePageTitle"),homepage.getTitle(), true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("zipcodeSelectionActualJson===>"
				+ zipcodeSelectionActualJson.toString());
		System.out.println("zipcodeSelectionExpectedJson===>"
				+ zipcodeSelectionExpectedJson.toString());
		
	}
	
	@When("^the user enters a zipcode in findplans textfield in UMS site$")
	public void users_enters_findplanszipcode(DataTable addressAttributes) {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
		List<DataTableRow> addressAttributesRow = addressAttributes
				.getGherkinRows();
		Map<String, String> addressAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < addressAttributesRow.size(); i++) {
			addressAttributesMap.put(addressAttributesRow.get(i).getCells()
					.get(0), addressAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = addressAttributesMap.get("zipcode");

		JSONObject findplanPage = aquisitionhomepage.findplanfield(zipcode,"findplans");		 
		

		if (zipcode != null) {
			try {
				getLoginScenario().saveBean(HomeCommonConstants.HOME_EXPECTED,new JSONObject().put("findplanTitle", "Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(true);
			getLoginScenario().saveBean(HomeCommonConstants.HOME_ACTUAL,findplanPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing lookupzipcode link ");
		}

	}
	
	
	@Then("^the user validates the findplans new page is opened with specific title in UMS site$")
	public void validate_Title_findplans() {
		
		JSONObject homeExpectedJson = (JSONObject) getLoginScenario()
				.getBean(HomeCommonConstants.HOME_EXPECTED);
		JSONObject homeActualJson = (JSONObject) getLoginScenario()
				.getBean(HomeCommonConstants.HOME_ACTUAL);
		
		try {
			JSONAssert.assertEquals(homeExpectedJson,
					homeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	@When("^the user enters a zipcode in learnfindplans textfield in UMS site$")
	public void users_enters_learnfindplanszipcode(DataTable addressAttributes) {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
		List<DataTableRow> addressAttributesRow = addressAttributes
				.getGherkinRows();
		Map<String, String> addressAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < addressAttributesRow.size(); i++) {
			addressAttributesMap.put(addressAttributesRow.get(i).getCells()
					.get(0), addressAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = addressAttributesMap.get("zipcode");

		JSONObject findplanPage = aquisitionhomepage.findplanfield(zipcode,"learnfindplans");		 
		

		if (zipcode != null) {
			try {
				getLoginScenario().saveBean(HomeCommonConstants.HOME_EXPECTED,new JSONObject().put("findplanTitle", "Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(true);
			getLoginScenario().saveBean(HomeCommonConstants.HOME_ACTUAL,findplanPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing lookupzipcode link ");
		}

	}
	
	@When("^the user picks a topic in learn more widget in UMS site$")
	public void learnmorewidget(DataTable addressAttributes) {
		
		AcquisitionHomePage homepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,homepage);
		
		List<DataTableRow> addressAttributesRow = addressAttributes.getGherkinRows();
		Map<String, String> addressAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < addressAttributesRow.size(); i++) {
			addressAttributesMap.put(addressAttributesRow.get(i).getCells().get(0), addressAttributesRow.get(i).getCells().get(1));
		}

		String picktopic = addressAttributesMap.get("Pickatopic");
		System.out.println("picktopic=="+picktopic);
		
		JSONObject objPickTopicJson = homepage.pickatopic(picktopic);		 
		
		if (objPickTopicJson != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,objPickTopicJson);
		
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + HomeCommonConstants.ACQ_HOME_DIRECTORY;

			JSONObject homeExpectedJson = MRScenario.readExpectedJson(CommonConstants.ACQ_HOME_PAGE_DATA, directory);
			getLoginScenario().saveBean(HomeCommonConstants.HOME_EXPECTED,homeExpectedJson);

			getLoginScenario().saveBean(HomeCommonConstants.HOME_ACTUAL,objPickTopicJson);
			
			System.out.println("homeActualJson=="+objPickTopicJson.toString());
			try {
				System.out.println("homeexpectedJson=="+homeExpectedJson.getString("topicselectTitle").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing lookupzipcode link ");
		}
		
	}
	

	@Then("^the user validates the new page is opened with specific title in UMS site$")
	public void validate_Title() {
		
		JSONObject homeExpectedJson = (JSONObject) getLoginScenario()
				.getBean(HomeCommonConstants.HOME_EXPECTED);
		JSONObject homeActualJson = (JSONObject) getLoginScenario()
				.getBean(HomeCommonConstants.HOME_ACTUAL);
		
		try {
			JSONAssert.assertEquals(homeExpectedJson.getString("topicselectTitle").toString(),
					homeActualJson.toString(), true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	@When("the user clicks on takeaquiz in UMS site$")
	public void takeaquiz() {
		
		AcquisitionHomePage homepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,homepage);
		
		
		AcquisitionHomePage objPickTopicJson = homepage.takequiz();		 
		
		if (objPickTopicJson != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,objPickTopicJson);
		
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + HomeCommonConstants.ACQ_HOME_DIRECTORY;

			JSONObject homeExpectedJson = MRScenario.readExpectedJson(CommonConstants.ACQ_HOME_PAGE_DATA, directory);
			getLoginScenario().saveBean(HomeCommonConstants.HOME_EXPECTED,homeExpectedJson);

			JSONObject homeActualJson = objPickTopicJson.homeJson;
			getLoginScenario().saveBean(HomeCommonConstants.HOME_ACTUAL,homeActualJson);
			
			System.out.println("homeActualJson=="+homeActualJson.toString());
			System.out.println("homeexpectedJson=="+homeExpectedJson.toString());
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing lookupzipcode link ");
		}
		
	}
	

	@Then("^the user validates the takeaquiz page is opened with specific title in UMS site$")
	public void validate_takeaquiz_Title() {
		
		JSONObject homeExpectedJson = (JSONObject) getLoginScenario()
				.getBean(HomeCommonConstants.HOME_EXPECTED);
		
		JSONObject homeActualJson = (JSONObject) getLoginScenario()
				.getBean(HomeCommonConstants.HOME_ACTUAL);
		System.out.println("zipcodeSelectionActualJson===>"
				+ homeExpectedJson.toString());
		System.out.println("zipcodeSelectionExpectedJson===>"
				+ homeActualJson.toString());
		try {
			JSONAssert.assertEquals(homeExpectedJson.getString("takequizTitle"),
					homeActualJson.getString("takequizTitle"), true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	
	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}
}
