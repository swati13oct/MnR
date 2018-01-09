/*package acceptancetests.tollfreenumber.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.GoogleSearchEnginePage;
import pages.acquisition.ulayer.GoogleSearchResultsPage;
import acceptancetests.atdd.util.CampaignPSC;
import acceptancetests.atdd.util.TFNCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/*
 * @author pperugu
 *
 
public class TFNHomePageFooterAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user navigates to the AARP Home page from any search engine$")
	public void user_navigates_aarp_home_page(DataTable givenAttributes)
	{
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells()
					.get(0), givenAttributesRow.get(i).getCells().get(1));
		}
		
		String searchEngine = givenAttributesMap.get("Search Engine");
		CampaignPSC campaignPSCs = TFNCommonConstants.AARP_TFN_ATTRIBUTE_MAP.get(searchEngine);
		String referer = campaignPSCs.getReferrer();
		
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean("webDriver", wd);
		GoogleSearchEnginePage searchEnginePage = new GoogleSearchEnginePage(wd,referer);
		
		GoogleSearchResultsPage searchResultsPage = searchEnginePage.searchParameter("aarp medicare plans",searchEngine);
		if (searchResultsPage != null) {
			Assert.assertTrue(true);
		} else {
			Assert.fail(" No search results ");
		}
		AcquisitionHomePage acquisitionHomePage = searchResultsPage.selectAarpHomePage(searchEngine);
		if (acquisitionHomePage != null) {
			Assert.assertTrue(true);
		} else {
			Assert.fail(" No search results ");
		}
		
		getLoginScenario().saveBean("acquisitionHomePage", acquisitionHomePage);
		
	}
	
	@When("^the user views the AARP Home page$")
	public void user_views_aarp_home_page()
	{
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario().getBean("acquisitionHomePage");
		String footerContent = acquisitionHomePage.selectsHomeFooter();
		getLoginScenario().saveBean("HomeFooterContent", footerContent);
	}
 
	@Then("^user validates the below data in Aarp Home page footer$")
	public void user_validates_data_home_page_footer(DataTable attributes)
	{
		String footerContent = (String) getLoginScenario().getBean("HomeFooterContent");
		System.out.println("HomeFooterContent"+footerContent);
	}
	
	@After
	public void tearDown()
	{

		WebDriver wd = (WebDriver) getLoginScenario().getBean("webDriver");
		wd.close();
		wd.quit();
	}

}
*/