/**
 * 
 */
package acceptancetests.providersearch.ulayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.ProviderSearchPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.providersearch.data.ProviderSearchCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

/**
 * @author pperugu
 *
 */
public class ProviderSearchAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the AARP Medicare Site landing page$")
	public void registered_member_located_pharmacy_aarp() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		AcquisitionHomePage acqusitionHomePage = new AcquisitionHomePage(wd);

		if (acqusitionHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acqusitionHomePage);
			Assert.assertTrue(true);
		}
	}

	@When("^the user launhes PO7 tool from home page in AARP Site$")
	public void user_views_pharmacy_locator_aarp() {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ProviderSearchPage providerSearchPage = acqusitionHomePage
				.launchesPo7();

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE,
					providerSearchPage);
			JSONObject providerSearchActualJson = providerSearchPage.providerSearchJson;
			getLoginScenario().saveBean(
					ProviderSearchCommonConstants.PROVIDER_SEARCH_ACTUAL,
					providerSearchActualJson);

			String fileName = "providersearch";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ ProviderSearchCommonConstants.PROVIDER_SEARCH_FLOW
					+ File.separator;

			JSONObject providerSearchExpectedJson = MRScenario
					.readExpectedJson(fileName, directory);
			getLoginScenario().saveBean(
					ProviderSearchCommonConstants.PROVIDER_SEARCH_EXPECTED,
					providerSearchExpectedJson);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load providerSearchPage");
		}

	}

	@Then("^the user validates the title of the provider search page displayed.$")
	public void user_validates_available_pharmacies_aarp() {

		JSONObject providerSearchActualJson = (JSONObject) getLoginScenario()
				.getBean(ProviderSearchCommonConstants.PROVIDER_SEARCH_ACTUAL);
		JSONObject providerSearchExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ProviderSearchCommonConstants.PROVIDER_SEARCH_EXPECTED);

		System.out.println("providerSearchActualJson:::"
				+ providerSearchActualJson);
		System.out.println("providerSearchExpectedJson:::"
				+ providerSearchExpectedJson);

		try {
			JSONAssert.assertEquals(providerSearchExpectedJson,
					providerSearchActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
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
