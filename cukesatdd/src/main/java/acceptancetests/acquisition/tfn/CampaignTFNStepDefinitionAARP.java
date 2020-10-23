package acceptancetests.acquisition.tfn;

/**
 * @author sdwaraka
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.tfn.CampaignTFNPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.GlobalWebElements;
import pages.acquisition.ulayer.UlayerTFNPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class CampaignTFNStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	
	WebDriver driver;
	@Given("^the user Starts WebDriver$")
	public void Start_WebDriver() {
		driver = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);

	}
	 
	@Given("^the user retrieves TFNSessionCookie and Federal and MedSupp TFN$")
	public void the_user_retrieves_TFNSessionCookie_and_Federal_and_MedSupp_TFN() throws Throwable {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		tfnPage.retrieveTFNcookie();
	}

	@Then("^the user validates PSC code$")
	public void the_user_validates_PSC_code(DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String pscCode = inputAttributesMap.get("PSC Code");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.validatePSCcode(pscCode);
	}


	@Then("^the user navigates to following MA Plan Page URL and validate Federal TFN$")
	public void the_user_navigates_to_following_MA_Plan_Page_URL_and_validate_Federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("MA URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		tfnPage.validateFederalTFN(TFN_Xpath);
	}
	
	@Then("^the user navigates to following MedEd Plan Page URL and validate Federal TFN$")
	public void the_user_navigates_MedEd_Page_and_validates_federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("MedEd URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		tfnPage.validateFederalTFN(TFN_Xpath);	
	}

	@Then("^the user navigate to following PDP Plan Page URL and validate Federal TFN$")
	public void the_user_navigate_to_following_PDP_Plan_Page_URL_and_validate_Federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("PDP URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user navigate to following SNP Plan page URL and validate Federal TFN$")
	public void the_user_navigate_to_following_SNP_Plan_page_URL_and_validate_Federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("SNP URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user navigate to following Med Supp Plan URL and validate MedSupp TFN$")
	public void the_user_navigate_to_following_Med_Supp_Plan_URL_and_validate_MedSupp_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("MedSupp URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		tfnPage.validateMedSuppTFN(TFN_Xpath);
	}

	@Given("^the user is on AARP medicare acquisition site from Campaign Traffic$")
	public void the_user_lands_on_AARP_from_Campaign_Traffic(DataTable arg1) throws Throwable  {
		driver = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		//driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(driver);
		//getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		String EnvironmentUrl = aquisitionhomepage.fetchEnvironmentUrls();
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("Campaign URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		tfnPage.navigateToCampaignURL(URLpath , EnvironmentUrl);
	}
	

@Given("^the user is on following acquisition site from Campaign Traffic$")
public void the_user_is_on_following_acquisition_site_from_Campaign_Traffic(DataTable arg1) throws Throwable {
	Map<String, String> inputAttributesMap=parseInputArguments(arg1);
	String Acq_Site = inputAttributesMap.get("Site");
	String CampaignPath = inputAttributesMap.get("Campaign URL");
	driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

	//wd.manage().deleteAllCookies();
	CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
	tfnPage.OpenPath(Acq_Site, CampaignPath);

}

	@Given("^user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page$")
	public void user_is_on_Google_and_search_AARP_Medicare_Advantage_Plan_to_navigate_to_AARP_page() throws Exception  {

		String url = "https://www.google.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		//wd.manage().deleteAllCookies();
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		tfnPage.openUrl(url);
		tfnPage.googleSearchAARP();

		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
	}

	@Given("^user is on Yahoo and search AARP Medicare Advantage Plan to navigate to AARP page$")
	public void user_is_on_Yahoo_and_search_AARP_Medicare_Advantage_Plan_to_navigate_to_AARP_page() throws Throwable {

		String url = "https://www.Yahoo.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		//wd.manage().deleteAllCookies();
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.openUrl(url);
		tfnPage.YahooSearchAARP();

		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);

	}
	
	
	

	@Given("^user is on Bing and search AARP Medicare Advantage Plan to navigate to navigate to AARP page$")
	public void user_is_on_Bing_and_search_AARP_Medicare_Advantage_Plan_to_navigate_to_AARP_page() throws Throwable {

		String url = "https://www.bing.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		//wd.manage().deleteAllCookies();
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.openUrl(url);
		tfnPage.BingSearchAARP();

		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);

	}
	
	
	@Given("^user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page$")
	public void user_is_on_Google_and_search_UHC_Medicare_Advantage_Plan_to_navigate_to_UHC_page() throws Exception  {

		String url = "https://www.google.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		//wd.manage().deleteAllCookies();
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.openUrl(url);
		tfnPage.googleSearchUHC();

		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
	}

	@Given("^user is on Yahoo and search UHC Medicare Advantage Plan to navigate to UHC page$")
	public void user_is_on_Yahoo_and_search_UHC_Medicare_Advantage_Plan_to_navigate_to_UHC_page() throws Throwable {

		String url = "https://www.Yahoo.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		//wd.manage().deleteAllCookies();
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.openUrl(url);
		tfnPage.YahooSearchUHC();

		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);

	}
	
	
	

	@Given("^user is on Bing and search UHC Medicare Advantage Plan to navigate to navigate to UHC page$")
	public void user_is_on_Bing_and_search_UHC_Medicare_Advantage_Plan_to_navigate_to_UHC_page() throws Throwable {

		String url = "https://www.bing.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.openUrl(url);
		tfnPage.BingSearchUHC();

		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);

	}
	
	@Then("^the user opens MA Plan Page URL and validates federal TFN$")
	public void the_user_opens_MA_Plan_Page_URL(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String Acq_Site = inputAttributesMap.get("Site");
		String URLpath = inputAttributesMap.get("MA URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.OpenPath(Acq_Site, URLpath);
		tfnPage.validateFederalTFN(TFN_Xpath);
	}
	
	@Then("^the user validates TFN on the particular deeplink URL page$")
	public void the_user_validates_TFN_on_deeplink(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.validateMedSuppTFN(TFN_Xpath);
	}
	
	@Then("^the user validates Federal TFN for PDP Plan Summary Page$")
	public void the_user_validates_TFN_on_PDP_PlanSummary(DataTable arg1) throws Throwable {
	Map<String, String> inputAttributesMap=parseInputArguments(arg1);
	String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	tfnPage.navigateToPDPPlans();
	tfnPage.validateFederalTFN(TFN_Xpath);
	}
	

@Then("^the user navigates to MA Plan Details Page and validates Federal TFN$")
public void the_user_navigates_to_MA_Plan_Details_Page_and_validates_Federal_TFN() throws Throwable {
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	String Zip = "90210";
	tfnPage.HomepagePlanSearch(Zip);
	String PlanType = "MA";
	tfnPage.ViewPlanSummary(PlanType);
	tfnPage.NavigateToPlanDetails(PlanType);
	String TFNXpath_PlanDetails = "//a[contains(@class, 'tel')]";
	tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

}

@Then("^the user navigates to PDP Plan Details Page and validates Federal TFN$")
public void the_user_navigates_to_PDP_Plan_Details_Page_and_validates_Federal_TFN() throws Throwable {
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	tfnPage.NavigateToHome();
	String Zip = "90210";
	tfnPage.HomepagePlanSearch(Zip);
	String PlanType = "PDP";
	tfnPage.ViewPlanSummary(PlanType);
	tfnPage.NavigateToPlanDetails(PlanType);
	String TFNXpath_PlanDetails = "//a[contains(@class, 'tel')]";
	tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

}

@Then("^the user navigates to SNP Plan Details Page and validates Federal TFN$")
public void the_user_navigates_to_SNP_Plan_Details_Page_and_validates_Federal_TFN() throws Throwable {
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	tfnPage.NavigateToHome();
	String Zip = "80210";
	tfnPage.HomepagePlanSearch(Zip);
	String PlanType = "SNP";
	tfnPage.ViewPlanSummary(PlanType);
	tfnPage.NavigateToPlanDetails(PlanType);
	String TFNXpath_PlanDetails = "//a[contains(@class, 'tel')]";
	tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

}

@Then("^the user navigates to MA OLE Page and validates Federal TFN$")
public void the_user_navigates_to_MA_OLE_Page_and_validates_Federal_TFN() throws Throwable {
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	tfnPage.NavigateToHome();
	String Zip = "90210";
	tfnPage.HomepagePlanSearch(Zip);
	String PlanType = "MA";
	tfnPage.ViewPlanSummary(PlanType);
	tfnPage.NavigateToOLE(PlanType);
	String TFNXpath_PlanDetails = "//a[contains(@class, 'tel') and contains(@href, 'tel')]";
	tfnPage.validateFederalTFN(TFNXpath_PlanDetails);
}

@Then("^the user navigates to PDP OLE Page and validates Federal TFN$")
public void the_user_navigates_to_PDP_OLE_Page_and_validates_Federal_TFN() throws Throwable {
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	tfnPage.NavigateToHome();
	String Zip = "90210";
	tfnPage.HomepagePlanSearch(Zip);
	String PlanType = "PDP";
	tfnPage.ViewPlanSummary(PlanType);
	tfnPage.NavigateToOLE(PlanType);
	String TFNXpath_PlanDetails = "//a[contains(@class, 'tel') and contains(@href, 'tel')]";
	tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

}

@Then("^the user navigates to SNP OLE Page and validates Federal TFN$")
public void the_user_navigates_to_SNP_OLE_Page_and_validates_Federal_TFN() throws Throwable {
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	tfnPage.NavigateToHome();
	String Zip = "80210";
	tfnPage.HomepagePlanSearch(Zip);
	String PlanType = "SNP";
	tfnPage.ViewPlanSummary(PlanType);
	tfnPage.handlePlanYearSelectionPopup();
	tfnPage.NavigateToOLE(PlanType);
	String TFNXpath_PlanDetails = "//a[contains(@class, 'tel') and contains(@href, 'tel')]";
	tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

}

@Then("^the user navigates to Medsupp Plans in VPP and validates Medsupp TFN$")
public void the_user_navigates_to_Medsupp_VPP_and_validates_Medsupp_TFN() throws Throwable {
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	tfnPage.NavigateToHome();
	String Zip = "90210";
	tfnPage.HomepagePlanSearch(Zip);
	String PlanType = "MS";
	tfnPage.ViewPlanSummary(PlanType);
	String TFNXpath_PlanDetails = "//*[contains(@class,'tel right')]";
	tfnPage.validateMedSuppTFN(TFNXpath_PlanDetails);
			
		
}
}











