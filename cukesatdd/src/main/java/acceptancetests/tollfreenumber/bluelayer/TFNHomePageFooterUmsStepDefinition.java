/**
 * 
 */
package acceptancetests.tollfreenumber.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.SearchEnginePage;
import pages.acquisition.bluelayer.SearchResultsPage;
import pages.acquisition.ulayer.MaViewPlansAndPricingPage;
import pages.acquisition.ulayer.MsViewPlansAndPricingPage;
import pages.acquisition.ulayer.PdpViewPlansAndPricingPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.atdd.util.CampaignPSC;
import acceptancetests.atdd.util.TFNCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */
public class TFNHomePageFooterUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user navigates to the UMS Home page from any search engine$")
	public void user_navigates_ums_home_page(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String searchEngine = givenAttributesMap.get("Search Engine");
		CampaignPSC campaignPSCs = TFNCommonConstants.UHC_TFN_ATTRIBUTE_MAP
				.get(searchEngine);
		String referer = campaignPSCs.getReferrer();

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean("webDriver", wd);
		SearchEnginePage searchEnginePage = new SearchEnginePage(wd, referer);

		SearchResultsPage searchResultsPage = searchEnginePage.searchParameter(
				"UHC medicare solutions", searchEngine);
		if (searchResultsPage != null) {
			Assert.assertTrue(true);
		} else {
			Assert.fail(" No search results ");
		}
		AcquisitionHomePage acquisitionHomePage = searchResultsPage
				.selectUmsHomePage(searchEngine);
		if (acquisitionHomePage != null) {
			Assert.assertTrue(true);
		} else {
			Assert.fail(" No search results ");
		}

		getLoginScenario().saveBean("acquisitionHomePage", acquisitionHomePage);

	}

	@When("^the user views the UMS Home page$")
	public void user_views_ums_home_page() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean("acquisitionHomePage");
		String footerContent = acquisitionHomePage.selectsHomeFooter();
		getLoginScenario().saveBean("HomeFooterContent", footerContent);
	}

	@Then("^user validates the below data in UMS Home page footer$")
	public void user_validates_data_home_page_footer_ums(DataTable attributes) {
		String footerContent = (String) getLoginScenario().getBean(
				"HomeFooterContent");
		System.out.println("HomeFooterContent" + footerContent);
	}

	@Then("^user navigates to Medicare Advantage page on UMS site$")
	public void user_navigates_medicare_advantage_ums() 
	{
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean("acquisitionHomePage");
		acquisitionHomePage.start("https://www.awe-dev-a-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans.html");

	}
	@When("^the user navigates to View Plans and Pricing for below plan type section in UMS site$")
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
	@Then("^user validates the TFN displayed in UMS site$")
	public void user_validates_data_home_page_footer() {

		String TFNActual = (String) getLoginScenario().getBean(
				TFNCommonConstants.TFN_ACTUAL);
		String TFNExpected = (String) getLoginScenario().getBean(
				TFNCommonConstants.TFN_EXPECTED);

		Assert.assertEquals(TFNExpected, TFNActual);

	}

	
}
