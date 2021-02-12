package acceptancetests.acquisition.campaignExternalLinkE2E;

import java.util.HashMap;
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
import pages.acquisition.commonpages.MedicareSupplementInsurancePlansPage;

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
			
			
			
			AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnmedicareplans11Link(zipcode);
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
		}
	
	@Then("^the user validate links and other options on morganstanley external link page$")
	public void validate_linkson_ExternalPage_morganstanley(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = memberAttributesMap.get("TFN No");

		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);

		campaignExternalLinkspage.validateMorganStanleyExternalPage(TFNXpath, ExpectedTFNNo);
		getLoginScenario().saveBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO, ExpectedTFNNo);
	}
	
	
	@Then("^the user validate links and other options on medicare prescription drug external link page$")
	public void validate_linkson_ExternalPage_pdp(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = memberAttributesMap.get("TFN No");

		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);

		campaignExternalLinkspage.validateMedicarePrescriptionDrugExternalPage(TFNXpath, ExpectedTFNNo);
		getLoginScenario().saveBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO, ExpectedTFNNo);
	}
	
	@Then("^User able to land  Shop for a plan page in new tab$")
	public void the_user_clicks_on_plan_and_pricing_button_on_external_link_page() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnPlanandPricingBtn();
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
	}
	
	
	@Then("^the user navigate back to external link of aarp medicare plans11 page$")
	public void navigate_back_aarp_medicare11_page(DataTable givenAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
			String zipcode = memberAttributesMap.get("Zip Code");
			CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
					.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	
			AcquisitionHomePage acquisitionHomePage = 	campaignExternalLinkspage.clickOnmedicareplans11backLink(zipcode);

			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
		}
	
	@When("^user clicks on Find Plans and Pricing to open a new tab$")
	public void user_clicks_on_Find_Plans_and_Pricing_to_open_a_new_tab() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.clickFindPlansPricing();
	}

	@Then("^user should be navigated on Shop for a plan page$")
	public void user_should_be_navigated_on_Shop_for_a_plan_page() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		AcquisitionHomePage acquisitionHomePage=campaignExternalLinkspage.validateShopForPlanLoaded();
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
	}

	@Then("^the user clicks on Learn About Medicare button on Morgan Stanley external link page$")
	public void the_user_clicks_on_Learn_About_Medicare_button_on_Morgan_Stanley_external_link_page() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnLearnAboutMedicareBtn();
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
	}
	
	@Then("^user verify TFN on AARP external links page$")
	public void user_verify_TFN_on_AARP_external_links_page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = memberAttributesMap.get("TFN No");
		String ExpectedWorkingHrs = memberAttributesMap.get("Working hrs");

		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.validateAARPExternalPage(TFNXpath, ExpectedTFNNo,ExpectedWorkingHrs);
		getLoginScenario().saveBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO, ExpectedTFNNo);
	}
	
	@Then("^the user navigate back to aarp medicare plans11 page privacy link$")
	public void navigate_aarp_medicare11_privacy_links() throws InterruptedException {
	
			CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
					.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
			
			AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnmedicareplans11PrivacyLink();
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
		}
	
	@Then("^the user validate links and other options on aarp medicare plans11 external link page$")
	public void validate_linkson_ExternalPage_aarp_medicare_plans11(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = memberAttributesMap.get("TFN No");

		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);

		campaignExternalLinkspage.validateAARPMedicarePlans11ExternalPage(TFNXpath, ExpectedTFNNo);
		getLoginScenario().saveBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO, ExpectedTFNNo);
	}
	
	@Then("^user navigate back to external url for medicare advatnatge plan$")
	public void user_vavigate_Bakc_externallinks(DataTable givenAttributes) throws Exception  {
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
		
		campaignExternalLinkspage.navigateBacktoExternalurl(url);
	
	}
	@When("^user clicks on Find Plans in your area to open a new tab$")
	public void user_clicks_on_Find_Plans_in_your_Area_to_open_a_new_tab() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.clickFindPlansinyourArea();
	}
	

@Then("^user closes current tab and navigate to previous tab$")
public void user_closes_current_tab_and_navigate_to_previous_tab() {
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	campaignExternalLinkspage.closeCurrentTabSwitchToParentTab();
}

	@When("^the user clicks on Medicare Education Supplement Insurance Plans Link$")
	public void the_user_clicks_on_Medicare_Supplement_Insurance_Plans_Link() throws Throwable {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		MedicareSupplementInsurancePlansPage medicareSupplementInsurancePlansPage = campaignExternalLinkspage
				.medicareSupplementInsurancePlans();
		getLoginScenario().saveBean(PageConstants.MEDICARE_SUPPLEMENT_INSURANCE_PLANS_PAGE,
				medicareSupplementInsurancePlansPage);
	}
	@When ("user clicks on Estimate Your Prescription Drug Costs from external page")
	public void user_clicks_on_Estimate_Prescription_Drug_Costto_open_a_new_tab() {
			CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
					.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
			campaignExternalLinkspage.navigateToDCERedesignFromExternalPage();

}
	@When ("user clicks on Start Now to get start the PRE flow from external page")
	public void user_clicks_on_Start_Now_to_Get_Started_PRE_Flow() {
			CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
					.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
			campaignExternalLinkspage.navigateToPREGetStarted();
		}

}

