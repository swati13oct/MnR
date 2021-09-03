package acceptancetests.mobile.acquisition.campaignExternalLinkE2E;

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

import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.CampaignExternalLinks;
import pages.acquisition.commonpages.MedicareSupplementInsurancePlansPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.mobile.acquisition.commonpages.CampaignExternalLinksMobile;

/**
 * Functionality: Validate different Campaign External Links
 */

public class CampaignExternalLinkStepDefinitionMobile {
	
	@Autowired
	MRScenario loginScenario;
	
	

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;
	
	
	
	@Given("^user is on campaign external Links page$")
	public void user_ison_externallinks(DataTable givenAttributes) throws Exception  {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getMobileDriver();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
	
		String url = memberAttributesMap.get("External Link");
		System.out.println("@@campaign external link url@@"+url);
		CampaignExternalLinksMobile campaignExternalLinkspage = new CampaignExternalLinksMobile(wd);

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

		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
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
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
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
	
	@When("^user clicks on Find plans link in Plan Finder section and redirects to PRE page$")
	public void user_clicks_on_Find_plans_link_in_Plan_Finder_section_and_redirects_to_PRE_page() { 
	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
	        .getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
     campaignExternalLinkspage.clickFindPlansLink(); 
	    
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

	@Given("^user is on new campaign external Links page$")
	public void user_ison_externallinksUAT(DataTable givenAttributes) throws Exception  {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap =  DataTableParser.readDataTableAsMaps(givenAttributes);
		/*wd = getLoginScenario().getWebDriverNew();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String url = memberAttributesMap.get("External Link");
		System.out.println("@@Url@@@"+url);
		CampaignExternalLinksMobile campaignExternalLinkspage = new CampaignExternalLinksMobile(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE, campaignExternalLinkspage);

		campaignExternalLinkspage.openUrl(url);

	}
//
//@Given("^the user navigates to new Campaign External links$")
//public void the_user_navigates_to_new_Campaign_External_links(DataTable givenAttributes)
//		throws Throwable {
//	WebDriver wd = getLoginScenario().getWebDriverNew();
//	Map<String, String> memberAttributesMap = new HashMap<String, String>();
//	memberAttributesMap =  DataTableParser.readDataTableAsMaps(givenAttributes);
//	/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
//	Map<String, String> memberAttributesMap = new HashMap<String, String>();
//	for (int i = 0; i < memberAttributesRow.size(); i++) {
//		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
//				memberAttributesRow.get(i).getCells().get(1));
//	}*/
//	String path = memberAttributesMap.get("PagePath");
//	path = path.replace("!", "#");
//	System.out.print("Path to Acq page : " + path);
//	CampaignExternalLinks campaignExternalLinkspage = (CampaignExternalLinks) getLoginScenario()
//			.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
//	campaignExternalLinkspage.navigateToPath(path);
//}
	
	@Then("^user validates Current location and change location$")
	public void user_validates_Current_location_and_change_location(DataTable givenAttributes) throws Throwable {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap =  DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String zipcodeSingle = memberAttributesMap.get("zipcodeSingle");
		String zipcodeMulti = memberAttributesMap.get("zipcodeMulti");
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.validateAARPExternalPageZipCode(zipcodeSingle, zipcodeMulti);
	}


	@Then("^user validates error messages on request an appointment$")
	public void user_validates_error_messages_on_request_an_appointment() throws Throwable {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.validateErrorMsg();
	}

	@Then("^user enters the details on request an appointment$")
	public void user_enters_the_details_on_request_an_appointment() throws Throwable {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.enterdetais();

	}

	@Then("^user clicks on find plans in your area and navigates to shop for a plan$")
	public void user_clicks_on_find_plans_in_your_area_and_navigates_to_shop_for_a_plan() throws Throwable {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.validateFindPlansInyourArea();
		campaignExternalLinkspage.naviagteBack();
	}
	
	@When ("user clicks on Estimate Your Prescription Drug Costs from MA external page")
	public void user_clicks_on_Estimate_Prescription_Drug_Costs_MA_External_page() {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
					.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
			campaignExternalLinkspage.validateDCEExternallinkMA();

}

	@Then("^user clicks on find a doctor and validates the page$")
	public void user_clicks_on_find_a_doctor_and_validates_the_page() throws Throwable {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.validateFindADoc();
		campaignExternalLinkspage.naviagteBack();
	}

	@Then("^user clicks on privacy policy link$")
	public void user_clicks_on_privacy_policy_link() throws Throwable {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.validatePrivacy();
	}

	@Then("^user clicks on accessibility link$")
	public void user_clicks_on_accessibility_link() throws Throwable {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.validateAccess();
	}
	
	@When ("user clicks on Drug cost estimator from external page")
	public void user_clicks_on_Drug_cost_estimator_from_external_page() {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
					.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
			campaignExternalLinkspage.navigateToDCERedesignFromExternaltakeadvantagePage();
	}

	@When("^user clicks on Find Plans and Pricing on take advantage page$")
	public void user_clicks_on_Find_Plans_and_Pricing_on_take_advantage_page() {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.clickFindPlansPricingtakeadvantage();
	}
	
	@Then("^user validates error messages on get more information$")
	public void user_validates_error_messages_on_get_more_information() throws Throwable {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.validateErrorMsgtakeadvantage();
	}
	@Then("^user enters the details on get more information$")
	public void user_enters_the_details_on_get_more_information() throws Throwable {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.enterdetailstakeadvantage();

	}

	@Then("user validates zipcode component and navigates to VPP")
	public void user_validates_zipcode_component_and_navigates_to_vpp() {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.validatezipcodecomponent();
	}

	@Then("user clicks on view plans and pricing and navigates to VPP")
	public void user_clicks_on_view_plans_and_pricing_and_navigates_to_vpp() {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.clickonViewpricingAndNavigatesToVPP();
	}
	
	@Then("user clicks on estimate your prescription drug costs and navigates to DCE")
	public void user_clicks_on_estimate_your_prescrption_drug_costs_and_navigates_to_dce() {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.clickonPrescriptionDrugCostAndNavigatesToDCE();
	}

	@Then("user clicks on estimate drug costs button and navigates to DCE")
	public void user_clicks_on_estimate_drug_costs_button_and_navigates_to_dce() {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.clickonEstimateDrugCostBtnAndNavigatesToDCE();
	}
	@Then("user clicks on start now and navigates to pharmacy page")
	public void user_clicks_on_start_now_and_navigates_to_pharmacy_page() {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.clickonStartNowAndNavigatesToPharmacyPage();
	}
	
	@Then("user clicks on view plans and pricing button and navigates to VPP")
	public void user_clicks_on_view_plans_and_pricing_button_and_navigates_to_vpp() {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.clickonViewPlanPricingBtnAndNavigatesToVPP();
	}
	
	@Then("^user navigate back to external url for prescription drug plan$")
	public void user_navigate_Back_prescription_drug_plan(DataTable givenAttributes) throws Exception  {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
	
		String url = memberAttributesMap.get("External Link");
		CampaignExternalLinksMobile campaignExternalLinkspage = new CampaignExternalLinksMobile(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE, campaignExternalLinkspage);
		
		campaignExternalLinkspage.navigateBacktoExternalurl(url);
	
	}
	
	@When("^user clicks on Find Plans and Pricing to open in same tab$")
	public void user_clicks_on_Find_Plans_and_Pricing_to_open_in_same_tab() {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.clickFindPlansPricing();
	}
	
	@When("^user clicks on Find Plans in your area on MA page$")
	public void user_clicks_on_Find_Plans_in_your_area_on_MA_page() {
		CampaignExternalLinksMobile campaignExternalLinkspage = (CampaignExternalLinksMobile) getLoginScenario()
				.getBean(PageConstants.CAMPAIGN_EXTERNAL_LINKS_PAGE);
		campaignExternalLinkspage.clickFindPlansinyourArea();
	}
	
	
	}

