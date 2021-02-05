package acceptancetests.acquisition.campaignExternalLinkE2E;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.CampaignExternalLinks;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.tfn.CampaignTFNPage;

/**
 * Functionality: Validate different Campaign External Links
 */

public class CampaignExternalLinkStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver wd;
	
	
	
	@Given("^user is on campaign external Links page$")
	public void user_ison_externallinks(DataTable givenAttributes) throws Exception  {
		wd = getLoginScenario().getWebDriverNew();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
	
		String url = memberAttributesMap.get("External Link");
		CampaignExternalLinks campaignExternalLinkspage = new CampaignExternalLinks(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE, campaignExternalLinkspage);
		
		campaignExternalLinkspage.openUrl(url);
	
	}
	/*Added the below step for Scenario 6 in
	 * */
	@Then("^the user validate aarp medicare plans11 page external link$")
	public void validate_linkson_aarp_ExternalPage_medicare_plans(DataTable givenAttributes) throws InterruptedException {
	
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
			String zipcode = memberAttributesMap.get("Zip Code");
			CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
					.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
			
			campaignExternalLinkspage.clickOnmedicareplans11Link(zipcode);
		}
	
	@Then("^the user validate morganstanley page external link$")
	public void validate_linkson_ExternalPage_morganstanley() throws InterruptedException {
	
			CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
					.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
			
			campaignExternalLinkspage.clickOnMorganstanleyLinks();
		}
	@Then("^the user navigate back to external link of aarp medicare plans11 page$")
	public void navigate_back_aarp_medicare11() throws InterruptedException {
	
			CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
					.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
			
			campaignExternalLinkspage.clickOnmedicareplans11PrivacyLink();
		}
}

