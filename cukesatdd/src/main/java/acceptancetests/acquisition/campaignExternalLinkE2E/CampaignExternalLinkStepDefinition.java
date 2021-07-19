package acceptancetests.acquisition.campaignExternalLinkE2E;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.CampaignExternalLinks;
import pages.acquisition.commonpages.MedicareSupplementInsurancePlansPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineCoverageOptionPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDrugsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineHeaderAndFooter;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineResultsPage;
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
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
	
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
	
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
			String zipcode = memberAttributesMap.get("Zip Code");
			CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
					.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
			
			
			
			AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnmedicareplans11Link(zipcode);
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
		}
	
	@Then("^the user validate links and other options on morganstanley external link page$")
	public void validate_linkson_ExternalPage_morganstanley(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = memberAttributesMap.get("TFN No");

		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);

		campaignExternalLinkspage.validateMorganStanleyExternalPage(TFNXpath, ExpectedTFNNo);
		getLoginScenario().saveBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO, ExpectedTFNNo);
	}
	
	
	@Then("^the user validate links and other options on medicare prescription drug external link page$")
	public void validate_linkson_ExternalPage_pdp(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = memberAttributesMap.get("TFN No");

		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);

		campaignExternalLinkspage.validateMedicarePrescriptionDrugExternalPage(TFNXpath, ExpectedTFNNo);
		getLoginScenario().saveBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO, ExpectedTFNNo);
	}
	
	@Then("^User able to land on Shop for a plan page in new tab$")
	public void the_user_clicks_on_plan_and_pricing_button_on_external_link_page() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnPlanandPricingBtn();
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
	}
	
	@Then("^the user clicks on Estimate your drug costs to land on Drug cost page from External link$")
	public void the_user_clicks_on_Estimate_Drug_Cost_button_on_external_link_page() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		GetStartedPage getStartedPage = campaignExternalLinkspage.estimateDrugCostButton();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}
	
	@When("^user click on Estimate your Drug Cost button under Look up your drugs title$")
	public void the_user_clicks_on_Look_up_drug_button_on_external_link_page() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		GetStartedPage getStartedPage = campaignExternalLinkspage.lookUpDrugButton();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}
	
	@Then("^the user navigate back to external link of aarp medicare plans11 page$")
	public void navigate_back_aarp_medicare11_page(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
	
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

	@When("user clicks on Start Now to get start the Pharmacy flow from external page")
	public void user_clicks_on_Start_Now_to_Get_Started_Pharmacy_Flow() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		PharmacySearchPage pharmacySearchPage = campaignExternalLinkspage.navigateToPharmacyGetStarted();
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
	}

	@Then("^the user clicks on Get Help Finding a Plan button on Morgan Stanley external link page$")
	public void the_user_clicks_on_Get_Help_Finding_a_Plan_button_on_Morgan_Stanley_external_link_page() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnGetHelpFindingAPlanBtn();
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
	}

	@When("^the user performs plan search using following information on Morgan Stanley external link page$")
	public void the_user_performs_plan_search_using_following_information_on_Morgan_Stanley_external_link_page(
			DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		VPPPlanSummaryPage plansummaryPage = null;
		campaignExternalLinkspage.enterZipcodeFindPlan(zipcode);

		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = campaignExternalLinkspage.searchPlansWithOutCountyForMorganStanley(zipcode);
		} else {
			plansummaryPage = campaignExternalLinkspage.searchPlanswithCountyForMorganStanley(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	@When("^the user should be able to see \"([^\"]*)\" expanded by default$")
	public void the_user_should_be_able_to_see_expanded_by_default(String planType) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyDefaultPlanType(planType);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

	}

	@And("^the user enters following details on Pharmacy search page$")
	public void the_user_enters_following_details_on_Pharmacy_search_page(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String zipcode = memberAttributesMap.get("Zip Code");
		String distance = memberAttributesMap.get("Distance");
		String county = memberAttributesMap.get("County Name");

		if (county == null)
			county = "None";

		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.DISTANCE, distance);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.COUNTY, county);

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);

		List<String> noteList = new ArrayList<String>();
		noteList.add("");
		noteList.add("===== TEST NOTE ================================================");

		
		
		  String testSiteUrl = "https://www.aarpmedicareplans.com/"; 
		/*
		 * String currentEnvTime = pharmacySearchPage.getAcqTestEnvSysTime(testSiteUrl);
		 * 
		 * 
		 * noteList.add("test run at stage time =" + currentEnvTime);
		 * 
		 * getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_TIME,
		 * currentEnvTime);
		 * 
		 * String[] tmpDateAndTime = currentEnvTime.split(" "); String[] tmpDate =
		 * tmpDateAndTime[0].split("/"); String envTimeYear = tmpDate[tmpDate.length -
		 * 1]; System.out.println("TEST - sysTimeYear=" + envTimeYear);
		 * 
		 * getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR,
		 * envTimeYear);
		 */
		  
		  	String timeStr = "";
			String winHandleBefore = wd.getWindowHandle();
			System.out.println("Proceed to open a new blank tab to check the system time");
			// tbd String urlGetSysTime=testSiteUrl+
			// "/DCERestWAR/dcerest/profiledetail/bConnected";
			String urlGetSysTime = testSiteUrl + "/PlanBenefitsWAR/profiledetail/aarp";
			System.out.println("test env URL for getting time: " + urlGetSysTime);
			// open new tab
			JavascriptExecutor js = (JavascriptExecutor) wd;
			js.executeScript("window.open('" + urlGetSysTime + "','_blank');");
			//String winHandleAfter = wd.getWindowHandle();
			for (String winHandle : wd.getWindowHandles()) {
				
				wd.switchTo().window(winHandle);
				if(wd.getTitle().equalsIgnoreCase(""))
					break;
				}
			
			Thread.sleep(2000);
			WebElement currentSysTimeElement = wd.findElement(By.xpath("//body"));
			String currentSysTimeStr = currentSysTimeElement.getText();
			System.out.println("currentSysTimeStr=" + currentSysTimeStr);
			JSONParser parser = new JSONParser();
			org.json.simple.JSONObject jsonObj;
			try {
				jsonObj = (org.json.simple.JSONObject) parser.parse(currentSysTimeStr);
				org.json.simple.JSONObject sysTimeJsonObj = (org.json.simple.JSONObject) jsonObj;

				org.json.simple.JSONObject dataObj = (org.json.simple.JSONObject) sysTimeJsonObj.get("data");
				timeStr = (String) dataObj.get("systemDate");
			} catch (ParseException e) {
				e.printStackTrace();
				Assertion.assertTrue("PROBLEM - unable to find out the system time", false);
			}
			wd.close();
			wd.switchTo().window(winHandleBefore);
		
			String[] tmpDateAndTime = timeStr.split(" "); 
			String[] tmpDate =tmpDateAndTime[0].split("/"); 
			String envTimeYear = tmpDate[tmpDate.length - 1]; 
			System.out.println("TEST - sysTimeYear=" + envTimeYear);
		 

		List<String> testNote = pharmacySearchPage.enterZipDistanceDetails(zipcode, distance, county);
		noteList.addAll(testNote);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE, noteList);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR, envTimeYear);

	}

	@Then("^the user clicks on View Plans and Pricing button on PDP external page$")
	public void the_user_clicks_on_View_Plans_and_Pricing_button_on_PDP_external_page(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		VPPPlanSummaryPage plansummaryPage = null;
		campaignExternalLinkspage.viewPlansAndPricing();

		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = campaignExternalLinkspage.searchPlansWithOutCountyForPDPExternalPage(zipcode);
		} else {
			plansummaryPage = campaignExternalLinkspage.searchPlanswithCountyForPDPExternalPage(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}

	}

	@Then("^the user clicks on View Plans and Pricing link on PDP external page$")
	public void the_user_clicks_on_View_Plans_and_Pricing_link_on_PDP_external_page(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		VPPPlanSummaryPage plansummaryPage = null;
		campaignExternalLinkspage.linkToViewPlansAndPricing();

		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = campaignExternalLinkspage.searchPlansWithOutCountyForPDPExternalPage(zipcode);
		} else {
			plansummaryPage = campaignExternalLinkspage.searchPlanswithCountyForPDPExternalPage(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}

	}
	

@When("^user clicks on Find Plans and Pricing to open a new tab in lower env$")
public void user_clicks_on_Find_Plans_and_Pricing_to_open_a_new_tab_in_lower_env() {
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	String env=MRScenario.environment;
	campaignExternalLinkspage.updateHrefUrlVPP_Script1(env);
	campaignExternalLinkspage.clickFindPlansPricing();
}

@When ("user clicks on Estimate Your Prescription Drug Costs for lower env")
public void user_clicks_on_Estimate_Prescription_Drug_for_lower_env() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		String env=MRScenario.environment;
		campaignExternalLinkspage.updateHrefUrlDCE_Script1(env);
		campaignExternalLinkspage.navigateToDCERedesignFromExternalPage();

}

@When ("user clicks on Start Now to get start the PRE flow external page for lower env")
public void user_clicks_on_Start_Now_PRE_Flow__lower_env() {
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		String env=MRScenario.environment;
		campaignExternalLinkspage.updateHrefUrlPRE_Script1(env);
		campaignExternalLinkspage.navigateToPREGetStarted();
	}

@Given("^User able to land on Shop for a plan page in new tab in lower env$")
public void user_able_to_land_on_Shop_for_a_plan_page_in_new_tab_in_lower_env()  {
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	String env=MRScenario.environment;
	campaignExternalLinkspage.updateHrefUrlVPP_Script7(env);
	AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnPlanandPricingBtn();
	getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
}

@Then("^the user clicks on Estimate your drug costs to land on Drug cost page from External link in lower env$")
public void the_user_clicks_on_Estimate_Drug_Cost_button_on_external_link_page_in_lower_env() {
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	String env=MRScenario.environment;
	campaignExternalLinkspage.updateHrefUrlDCE_Script7(env);
	GetStartedPage getStartedPage = campaignExternalLinkspage.estimateDrugCostButton();
	if (null != getStartedPage) {
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
	} else
		Assert.fail("DCE Redesign page object not loaded");
}

@When("^user click on Estimate your Drug Cost button under Look up your drugs title in lower env$")
public void the_user_clicks_on_Look_up_drug_button_on_external_link_page_lower_env() {
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	String env=MRScenario.environment;
	campaignExternalLinkspage.updateHrefUrlDCE_Script7_1(env);
	GetStartedPage getStartedPage = campaignExternalLinkspage.lookUpDrugButton();
	if (null != getStartedPage) {
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
	} else
		Assert.fail("DCE Redesign page object not loaded");
}

@When("user clicks on Start Now to start the Pharmacy flow from external page in lower env")
public void user_clicks_on_Start_Now_to_Get_Started_lower_env() {
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	String env=MRScenario.environment;
	campaignExternalLinkspage.updateHrefUrlPharmacy_Script7(env);
	PharmacySearchPage pharmacySearchPage = campaignExternalLinkspage.navigateToPharmacyGetStarted();
	getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
}

@Then("^the user clicks on View Plans and Pricing button on PDP external page in lower env$")
public void the_user_clicks_on_View_Plans_and_Pricing_button_on_PDP_external_page_lower_env(DataTable givenAttributes) {
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * Map<String, String> memberAttributesMap = new HashMap<String, String>(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
	String zipcode = memberAttributesMap.get("Zip Code");
	String county = memberAttributesMap.get("County Name");
	String isMultiCounty = memberAttributesMap.get("Is Multi County");
	getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	VPPPlanSummaryPage plansummaryPage = null;
	
	String env=MRScenario.environment;
	campaignExternalLinkspage.updateHrefUrlVPP_Script7_1(env);
	campaignExternalLinkspage.viewPlansAndPricing();

	if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
		plansummaryPage = campaignExternalLinkspage.searchPlansWithOutCountyForPDPExternalPage(zipcode);
	} else {
		plansummaryPage = campaignExternalLinkspage.searchPlanswithCountyForPDPExternalPage(zipcode, county);
	}

	if (plansummaryPage != null) {
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

	} else {
		Assert.fail("Error Loading VPP plan summary page");
	}

}

@Then("^the user navigate back to aarp medicare plans11 page privacy link in lower env$")
public void navigate_aarp_medicare11_privacy_links_lower_env() throws InterruptedException {

		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		String env=MRScenario.environment;
		campaignExternalLinkspage.updateHrefUrlPrivacyLink_Script7(env);
		AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnmedicareplans11PrivacyLink();
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
	}

@Then("^the user validate aarp medicare plans11 page external link in lower env$")
public void validate_linkson_aarp_medicare_plans11_page_lower_env(DataTable givenAttributes) throws InterruptedException {
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * Map<String, String> memberAttributesMap = new HashMap<String, String>(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String zipcode = memberAttributesMap.get("Zip Code");
		
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		
		String env=MRScenario.environment;
		campaignExternalLinkspage.updateHrefUrlVPP_Script6(env);
		
		AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnmedicareplans11Link(zipcode);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
	}

@Then("^the user navigate back to aarp medicare plans11 privacy link in lower env$")
public void navigate_aarp_medicare11_privacy_links_in_lower_env() throws InterruptedException {

		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		String env=MRScenario.environment;
		campaignExternalLinkspage.updateHrefUrlPrivacyLink_Script6(env);
		AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnmedicareplans11PrivacyLink();
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
	}

@Then("^the user clicks on Learn About Medicare button on external link page in lower env$")
public void the_user_clicks_on_Learn_About_Medicare_button_on_external_link_page_lower_env() {
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	String env=MRScenario.environment;
	campaignExternalLinkspage.updateHrefUrlLearnMore_Script5(env);
	AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnLearnAboutMedicareBtn();
	getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
}

@Then("^the user clicks on Get Help Finding a Plan button on external link page in lower env$")
public void the_user_clicks_on_Get_Help_Finding_a_Plan_button_on_external_link_page_lower_env() {
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	String env=MRScenario.environment;
	campaignExternalLinkspage.updateHrefUrlGetHelp_Script5(env);
	AcquisitionHomePage acquisitionHomePage = campaignExternalLinkspage.clickOnGetHelpFindingAPlanBtn();
	getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acquisitionHomePage);
}

@When("^the user performs plan search using following information on Morgan Stanley external link page in lower env$")
public void the_user_performs_plan_search_using_following_information_on_Morgan_Stanley_external_link_page_lower_env(
		DataTable givenAttributes) {
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * Map<String, String> memberAttributesMap = new HashMap<String, String>(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
	String zipcode = memberAttributesMap.get("Zip Code");
	String county = memberAttributesMap.get("County Name");
	String isMultiCounty = memberAttributesMap.get("Is Multi County");
	getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	String env=MRScenario.environment;
	campaignExternalLinkspage.updateHrefUrlVPP_Script5(env);
	
	VPPPlanSummaryPage plansummaryPage = null;
	campaignExternalLinkspage.enterZipcodeFindPlan(zipcode);

	if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
		plansummaryPage = campaignExternalLinkspage.searchPlansWithOutCountyForMorganStanley(zipcode);
	} else {
		plansummaryPage = campaignExternalLinkspage.searchPlanswithCountyForMorganStanley(zipcode, county);
	}

	if (plansummaryPage != null) {
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

	} else {
		Assert.fail("Error Loading VPP plan summary page");
	}
}

@And("^user clicks on get started to start questionnaire$")
public void clicks_on_get_started_button_to_start_questionaire(DataTable givenAttributes) throws Throwable {
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		System.out.println("Zipcode is:"+zipcode);
		String county = memberAttributesMap.get("CountyDropDown");
		System.out.println("Email is:"+county);
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		System.out.println("Entered Search Key is:"+isMultiCounty);
		
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);
		
		CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	if (isMultiCounty.equalsIgnoreCase("NO")) {
		campaignExternalLinkspage.startQuestionnaire(zipcode);
	} else {
		campaignExternalLinkspage.startQuestionnaireWithCounty(zipcode, county);
	}
}

@And("^user select plantype in the coverage options page$")
public void select_plan_type_coverage_page(DataTable givenAttributes) throws Throwable {
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	String plantype = memberAttributesMap.get("Plan Type");
	if (!(plantype.isEmpty())) {
		campaignExternalLinkspage.selectCoverageOption(plantype);
	}
}

@Then("^user select add drug option in the Drug page$")
	public void select_add_drugs_option(DataTable givenAttributes) {
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	campaignExternalLinkspage.drugsInitiate(memberAttributesMap.get("Drug Selection"));
	campaignExternalLinkspage.drugsHandlerWithdetails(memberAttributesMap.get("Drug Details"));
	campaignExternalLinkspage.continueNextpage();
	}

@Then("^user validate loading results page$")
	public void user_validate_results_page() {
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	campaignExternalLinkspage.resultsloadingpage();
	}

@Then("^user validates plan recommendations in the results page$")
	public void view_recommendations_results_page(DataTable givenAttributes) {
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	String zip = memberAttributesMap.get("Zip Code");
	String county = memberAttributesMap.get("County Name");
	campaignExternalLinkspage.resultsUI(zip,county);
	}


@When("^the user click on view plan in results page$")
public void user_clicks_on_view_plans_in_results_page() {
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	campaignExternalLinkspage.clickViewResults();

}

@And("^User clicks on Back to Plans on detail page$")
public void user_clicks_on_Back_To_Plan() {
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	campaignExternalLinkspage.backToPlans();

}
@And("^the user clicks the plans of the below plan type$")
public void user_performs_planSearch_in_aarp_site(DataTable givenAttributes) {
	Map<String, String> givenAttributesMap = new HashMap<String, String>();
	givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
	/*
	 * List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows(); for
	 * (int i = 0; i < givenAttributesRow.size(); i++) {
	 * 
	 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
	 * givenAttributesRow.get(i).getCells().get(1)); }
	 */

	String plantype = givenAttributesMap.get("Plan Type");
	WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
	System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
	getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);

	campaignExternalLinkspage.viewPlanSummary(plantype);

}

@Then("^the user views plan details for selected plan and validates$")
public void user_views_plandetails_selected_plan_aarp(DataTable givenAttributes) {
	/*
	 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	 * String PlanName = memberAttributesRow.get(0).getCells().get(1);
	 */
	String PlanName = givenAttributes.cell(0, 1);
	getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	String PlanPremium = campaignExternalLinkspage.getPlanPremium(PlanName, planType);
	//getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
	campaignExternalLinkspage.clickOnViewMoreForPlan(PlanName);
	CampaignExternalLinks campaignExternalLinkspagevppDetails = campaignExternalLinkspage.navigateToPlanDetails(PlanName, planType);
	if (campaignExternalLinkspage != null) {
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE,  campaignExternalLinkspagevppDetails);
		Assertion.assertTrue(true);
	} else
		Assertion.fail("Error in Loading the Plan Details Page");

}

@Then("^the user clicks on Enroll Now in Details Page to start the OLE flow on the site$")
public void the_user_clicks_on_Enroll_Now_in_Plan_Details_Page_to_start_the_OLE_flow() throws Throwable {
	String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
	String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);

	String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
			//(String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
	String County = "";
			//(String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
	String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	String TFN;
	CampaignExternalLinks campaignExternalLinks = (CampaignExternalLinks) getLoginScenario()
			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
	TFN = campaignExternalLinks.GetTFNforPlanType();
	WelcomePage welcomePage = campaignExternalLinks.Enroll_OLE_Plan(PlanName);
	// }
	String PlanPremium = "";
			//(String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM);
	getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
	getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
	getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
	getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
	// getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
	getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
	getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
	System.out.println("Plan Name is : " + PlanName);
	System.out.println("Plan Type is : " + PlanType);
	System.out.println("Plan Zip Code is : " + ZipCode);
	System.out.println("Plan County Name is : " + County);
	System.out.println("Plan Plan Premium is : " + PlanPremium);
	System.out.println("TFN for Plan Type is : " + TFN);
	System.out.println("Plan Year is : " + PlanYear);
	// System.out.println("OLE is being started from Acquisition Site : "+SiteName);
	if (welcomePage != null) {

		getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
		System.out.println("OLE Welcome Page is Displayed");
		Assertion.assertTrue(true);
	} else
		Assertion.fail("Error in validating the OLE Welcome Page");

}

}
