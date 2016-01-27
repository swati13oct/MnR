package acceptancetests.lookupzipcode.ulayer;

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
import pages.acquisition.ulayer.OurPlansPage;
import pages.acquisition.ulayer.ZipcodeLookupPage;
import pages.acquisition.ulayer.ZipcodeSelectionPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.lookupzipcode.data.ZipLookupCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */
public class LookupZipcodeAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@When("^the user clicks on lookup zipcode link from AARP home page$")
	public void clicks_lookup_Zipcode_aarp() {

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean("webDriver", wd);

		AcquisitionHomePage acquisitionHomePage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				acquisitionHomePage);
		ZipcodeLookupPage zipcodeLookupPage = acquisitionHomePage
				.looksupforZipcodes();

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

		ZipcodeLookupPage zipcodeLookupAarpPage = (ZipcodeLookupPage) getLoginScenario()
				.getBean(PageConstants.ZIP_LOOK_UP_PAGE);
		ZipcodeSelectionPage zipcodeSelectionPage = zipcodeLookupAarpPage
				.enterAddressDetails(address, city, state);

		if (zipcodeSelectionPage != null) {
			getLoginScenario().saveBean(PageConstants.ZIP_SELECTION_PAGE,
					zipcodeSelectionPage);
			/* Get expected data */
			String fileName = address;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + ZipLookupCommonConstants.LOOK_UP_ZIPCODE
					+ File.separator + state + File.separator + city
					+ File.separator;

			JSONObject zipcodeSelectionExpectedJson = MRScenario
					.readExpectedJson(fileName, directory);
			getLoginScenario().saveBean(
					ZipLookupCommonConstants.ZIP_SELECTION_EXPECTED,
					zipcodeSelectionExpectedJson);

			JSONObject zipcodeSelectionActualJson = zipcodeSelectionPage.zipSelectionJson;
			getLoginScenario().saveBean(
					ZipLookupCommonConstants.ZIP_SELECTION_ACTUAL,
					zipcodeSelectionActualJson);
		}
	}

	@When("^the user clicks on lookup zipcode link in our plans page in AARP$")
	public void clicks_lookup_Zipcode_ourplan_aarp() {

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		OurPlansPage ourPlansPage = new OurPlansPage(wd);

		getLoginScenario().saveBean(PageConstants.OUR_PLANS_PAGE, ourPlansPage);
		ZipcodeLookupPage zipcodeLookupPage = ourPlansPage.looksupforZipcodes();

		if (zipcodeLookupPage != null) {
			getLoginScenario().saveBean(PageConstants.ZIP_LOOK_UP_PAGE,
					zipcodeLookupPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing lookupzipcode link ");
		}

	}

	@And("^the user searches for zipcodes by entering the following Address and city and State details through our plans page for AARP site$")
	public void enters_addres_city_state_details_ourplans_aarp(
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

		ZipcodeLookupPage zipcodeLookupPage = (ZipcodeLookupPage) getLoginScenario()
				.getBean(PageConstants.ZIP_LOOK_UP_PAGE);
		ZipcodeSelectionPage zipcodeSelectionPage = zipcodeLookupPage
				.enterAddressDetailsplansPage(address, city, state);

		if (zipcodeSelectionPage != null) {
			getLoginScenario().saveBean(PageConstants.ZIP_SELECTION_PAGE,
					zipcodeSelectionPage);
			/* Get expected data */
			String fileName = address;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + ZipLookupCommonConstants.LOOK_UP_ZIPCODE
					+ File.separator + state + File.separator + city
					+ File.separator;

			JSONObject zipcodeSelectionExpectedJson = MRScenario
					.readExpectedJson(fileName, directory);
			getLoginScenario().saveBean(
					ZipLookupCommonConstants.ZIP_SELECTION_EXPECTED,
					zipcodeSelectionExpectedJson);

			JSONObject zipcodeSelectionActualJson = zipcodeSelectionPage.zipSelectionJson;
			getLoginScenario().saveBean(
					ZipLookupCommonConstants.ZIP_SELECTION_ACTUAL,
					zipcodeSelectionActualJson);
		}
	}

	@Then("^the user validates list of ZIP codes in AARP site$")
	public void validates_zipcodes() {
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
