package acceptancetests.acquisitionhome.ulayer;

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
import pages.acquisition.ulayer.ZipcodeLookupPage;
import pages.acquisition.ulayer.ZipcodeSelectionPage;
import acceptancetests.acquisitionhome.data.HomeCommonConstants;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.lookupzipcode.data.ZipLookupCommonConstants;
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

public class AcquisitionHomeAarpStepDefinition {

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

	@When("^the user clicks on lookup zipcode link from AARP home page$")
	public void clicks_lookup_Zipcode_aarp() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

				
		ZipcodeLookupPage zipcodeLookupPage = aquisitionhomepage
				.lookupmodal();		 
		

		if (zipcodeLookupPage != null) {
			getLoginScenario().saveBean(PageConstants.ZIP_LOOK_UP_PAGE,
					zipcodeLookupPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing lookupzipcode link ");
		}

	}
	
	
	@And("^the user searches for zipcodes by entering the following Address and city and State details for AARP site$")
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

		ZipcodeLookupPage zipcodeLookupAarpPage = (ZipcodeLookupPage) getLoginScenario().getBean(PageConstants.ZIP_LOOK_UP_PAGE);
		
		ZipcodeSelectionPage zipcodeSelectionPage = zipcodeLookupAarpPage.enterAddressDetails(address, city, state);
		
		System.out.println("zipcodeSelectionExpectedJson line 101===>"
				+zipcodeSelectionPage.zipSelectionJson.toString());
		
		getLoginScenario().saveBean(PageConstants.ZIP_SELECTION_PAGE,zipcodeSelectionPage);
		/* Get expected data */
		String fileName = address;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator + HomeCommonConstants.ACQ_HOME_DIRECTORY
				+ File.separator + state + File.separator + city
				+ File.separator;

		JSONObject zipcodeSelectionExpectedJson = MRScenario.readExpectedJson(fileName, directory);
		getLoginScenario().saveBean(ZipLookupCommonConstants.ZIP_SELECTION_EXPECTED,zipcodeSelectionExpectedJson);
		
		JSONObject zipcodeSelectionActualJson = zipcodeSelectionPage.zipSelectionJson;
		getLoginScenario().saveBean(
				ZipLookupCommonConstants.ZIP_SELECTION_ACTUAL,
				zipcodeSelectionActualJson);

	}

	
	@Then("^the user validates the list of zip codes$")
	public void validate_zipcodeList() {
		JSONObject zipcodeSelectionExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ZipLookupCommonConstants.ZIP_SELECTION_EXPECTED);
		JSONObject zipcodeSelectionActualJson = (JSONObject) getLoginScenario()
				.getBean(ZipLookupCommonConstants.ZIP_SELECTION_ACTUAL);
		System.out.println("zipcodeSelectionActualJson===>"
				+ zipcodeSelectionActualJson.toString());
		System.out.println("zipcodeSelectionExpectedJson===>"
				+ zipcodeSelectionExpectedJson.toString());
		try {
			JSONAssert.assertEquals(zipcodeSelectionExpectedJson,
					zipcodeSelectionActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	@When("^the user enters a zipcode in findplans textfield$")
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
	
	
	@Then("^the user validates the findplans new page is opened with specific title$")
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
	
	@When("^the user enters a zipcode in learnfindplans textfield$")
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
		
System.out.println("findplanfield=="+findplanPage.toString());
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
	
	@When("^the user picks a topic in learn more widget$")
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
	

	@Then("^the user validates the new page is opened with specific title$")
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
	
	@When("^the user clicks on takeaquiz button$")
	public void takeaquiz(DataTable addressAttributes) {
		List<DataTableRow> addressAttributesRow = addressAttributes.getGherkinRows();
		Map<String, String> addressAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < addressAttributesRow.size(); i++) {
			addressAttributesMap.put(addressAttributesRow.get(i).getCells().get(0), addressAttributesRow.get(i).getCells().get(1));
		}
		AcquisitionHomePage homepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,homepage);
		String pageTitle = addressAttributesMap.get("pageTitle");
		
		JSONObject objPickTopicJson = homepage.takequiz();		 
		
		if (objPickTopicJson != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,objPickTopicJson);
		
		
			try {
				getLoginScenario().saveBean(HomeCommonConstants.HOME_EXPECTED,new JSONObject().put("takequizTitle", pageTitle));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			getLoginScenario().saveBean(HomeCommonConstants.HOME_ACTUAL,objPickTopicJson);
			
			System.out.println("objPickTopicJson=="+objPickTopicJson.toString());
			
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing lookupzipcode link ");
		}
		
	}
	

	@Then("^the user validates the takeaquiz page is opened with specific title$")
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
	
	@When("^the user clicks on whychooseuhc button$")
	public void whychooseuhc(DataTable addressAttributes) {
		List<DataTableRow> addressAttributesRow = addressAttributes.getGherkinRows();
		Map<String, String> addressAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < addressAttributesRow.size(); i++) {
			addressAttributesMap.put(addressAttributesRow.get(i).getCells().get(0), addressAttributesRow.get(i).getCells().get(1));
		}
		AcquisitionHomePage homepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,homepage);
		
		
		String objchooseuhcPageTitle = addressAttributesMap.get("whychooseuhcPageTitle");
				
		System.out.println("objchooseuhcTitle=="+objchooseuhcPageTitle);
		
		JSONObject objChoseUhcJson = homepage.chooseuhc();		 
		
		if (objChoseUhcJson != null) {
			try {
				getLoginScenario().saveBean(HomeCommonConstants.HOME_EXPECTED,new JSONObject().put("whychooseuhcTitle", objchooseuhcPageTitle +" | AARP® Medicare Plans from UnitedHealthcare®"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			getLoginScenario().saveBean(HomeCommonConstants.HOME_ACTUAL,objChoseUhcJson);
			
			System.out.println("objPickTopicJson=="+objChoseUhcJson.toString());
			
		} 
		
	}
	
	@Then("^the user validates the whychooseuhc page is opened with specific title$")
	public void validate_whychooseuhc_Title() {
		
		JSONObject homeExpectedJson = (JSONObject) getLoginScenario()
				.getBean(HomeCommonConstants.HOME_EXPECTED);
		
		JSONObject homeActualJson = (JSONObject) getLoginScenario()
				.getBean(HomeCommonConstants.HOME_ACTUAL);
		System.out.println("zipcodeSelectionActualJson===>"
				+ homeActualJson.toString());
		System.out.println("zipcodeSelectionExpectedJson===>"
				+ homeExpectedJson.toString());
		try {
			JSONAssert.assertEquals(homeExpectedJson,homeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@After
	public void tearDown() {
		
		WebDriver wd = (WebDriver) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		wd.quit();
		getLoginScenario().flushBeans();
	}
}
