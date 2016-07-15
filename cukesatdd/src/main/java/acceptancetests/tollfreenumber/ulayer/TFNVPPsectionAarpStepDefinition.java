package acceptancetests.tollfreenumber.ulayer;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.BingSearchEnginePage;
import pages.acquisition.ulayer.BingSearchResultsPage;
import pages.acquisition.ulayer.GoogleSearchEnginePage;
import pages.acquisition.ulayer.GoogleSearchResultsPage;
import pages.acquisition.ulayer.MaViewPlansAndPricingPage;
import pages.acquisition.ulayer.MsViewPlansAndPricingPage;
import pages.acquisition.ulayer.PdpViewPlansAndPricingPage;
import pages.acquisition.ulayer.YahooSearchEnginePage;
import pages.acquisition.ulayer.YahooSearchResultsPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.atdd.util.TFNCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */
public class TFNVPPsectionAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user navigates to the AARP Home page from any search engine$")
	public void user_navigates_aarp_home_page(DataTable givenAttributes) {

		String searchEngine = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		getLoginScenario().saveBean(TFNCommonConstants.SEARCH_ENGINE,
				searchEngine);

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		if (searchEngine.contains("google")) {

			GoogleSearchEnginePage searchEnginePage = new GoogleSearchEnginePage(
					wd);
			GoogleSearchResultsPage searchResultsPage = searchEnginePage
					.searchParameter("aarp medicare plans");
			if (searchResultsPage != null) {
				Assert.assertTrue(true);
			} else {
				Assert.fail(" No search results ");
			}
			AcquisitionHomePage acquisitionHomePage = searchResultsPage
					.selectAarpHomePage();
			if (acquisitionHomePage != null) {
				Assert.assertTrue(true);
			} else {
				Assert.fail(" No search results ");
			}

			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acquisitionHomePage);

		}

		if (searchEngine.contains("yahoo")) {

			YahooSearchEnginePage searchEnginePage = new YahooSearchEnginePage(
					wd);
			YahooSearchResultsPage searchResultsPage = searchEnginePage
					.searchParameter("aarp medicare plans");
			if (searchResultsPage != null) {
				Assert.assertTrue(true);
			} else {
				Assert.fail(" No search results ");
			}
			AcquisitionHomePage acquisitionHomePage = searchResultsPage
					.selectAarpHomePage();
			if (acquisitionHomePage != null) {
				Assert.assertTrue(true);
			} else {
				Assert.fail(" No search results ");
			}
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acquisitionHomePage);
		}

		if (searchEngine.contains("bing")) {

			BingSearchEnginePage searchEnginePage = new BingSearchEnginePage(wd);
			BingSearchResultsPage searchResultsPage = searchEnginePage
					.searchParameter("aarp medicare plans from unitedhealthcare");
			if (searchResultsPage != null) {
				Assert.assertTrue(true);
			} else {
				Assert.fail(" No search results ");
			}
			AcquisitionHomePage acquisitionHomePage = searchResultsPage
					.selectAarpHomePage();
			if (acquisitionHomePage != null) {
				Assert.assertTrue(true);
			} else {
				Assert.fail(" No search results ");
			}
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acquisitionHomePage);
		}

	}

	@When("^the user navigates to View Plans and Pricing for below plan type section in AARP site$")
	public void user_navigates_view_plans_pricing_plantype_aarp(
			DataTable givenattribute) {
		String planType = givenattribute.getGherkinRows().get(0).getCells()
				.get(0);
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		String searchEngine = (String) getLoginScenario().getBean(
				TFNCommonConstants.SEARCH_ENGINE);

		Object vppPage = acquisitionHomePage.navigatesToVppSection(planType);

		String fileName = "vpp";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER + File.separator
				+ TFNCommonConstants.TFN_FLOW_NAME + File.separator;

		if (vppPage.getClass().toString().contains("Ma")) {
			MaViewPlansAndPricingPage maViewPlansAndPricingPage = (MaViewPlansAndPricingPage) vppPage;
			getLoginScenario().saveBean(PageConstants.MA_VPP_PAGE,
					maViewPlansAndPricingPage);

			String TFNActual = maViewPlansAndPricingPage.getTfnDisplayed();
			String TFNExpected = maViewPlansAndPricingPage.getTfnExpected(
					fileName, directory, searchEngine);

			getLoginScenario().saveBean(TFNCommonConstants.TFN_ACTUAL,
					TFNActual);
			getLoginScenario().saveBean(TFNCommonConstants.TFN_EXPECTED,
					TFNExpected);

		}
		if (vppPage.getClass().toString().contains("Pdp")) {
			PdpViewPlansAndPricingPage pdpViewPlansAndPricingPage = (PdpViewPlansAndPricingPage) vppPage;
			getLoginScenario().saveBean(PageConstants.PDP_VPP_PAGE,
					pdpViewPlansAndPricingPage);

			String TFNActual = pdpViewPlansAndPricingPage.getTfnDisplayed();
			String TFNExpected = pdpViewPlansAndPricingPage.getTfnExpected(
					fileName, directory, searchEngine);

			getLoginScenario().saveBean(TFNCommonConstants.TFN_ACTUAL,
					TFNActual);
			getLoginScenario().saveBean(TFNCommonConstants.TFN_EXPECTED,
					TFNExpected);
		}
		if (vppPage.getClass().toString().contains("Ms")) {
			MsViewPlansAndPricingPage msViewPlansAndPricingPage = (MsViewPlansAndPricingPage) vppPage;
			getLoginScenario().saveBean(PageConstants.MS_VPP_PAGE,
					msViewPlansAndPricingPage);

			String TFNActual = msViewPlansAndPricingPage.getTfnDisplayed();
			String TFNExpected = msViewPlansAndPricingPage.getTfnExpected(
					fileName, directory, searchEngine);

			getLoginScenario().saveBean(TFNCommonConstants.TFN_ACTUAL,
					TFNActual);
			getLoginScenario().saveBean(TFNCommonConstants.TFN_EXPECTED,
					TFNExpected);
		}

	}

	@Then("^user validates the TFN displayed$")
	public void user_validates_data_home_page_footer() {

		String TFNActual = (String) getLoginScenario().getBean(
				TFNCommonConstants.TFN_ACTUAL);
		String TFNExpected = (String) getLoginScenario().getBean(
				TFNCommonConstants.TFN_EXPECTED);

		Assert.assertEquals(TFNExpected, TFNActual);

	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
