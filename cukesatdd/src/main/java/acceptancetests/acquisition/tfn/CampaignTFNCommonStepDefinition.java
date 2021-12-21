package acceptancetests.acquisition.tfn;

/**
 * @author sdwaraka
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
//import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineLandingAndZipcodePages;
import pages.acquisition.tfn.CampaignTFNPage;

public class CampaignTFNCommonStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(memberAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		return memberAttributesMap;
	}

	private WebDriver driver;

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
		HashMap<String, String> tfnCookieValue = tfnPage.retrieveTFNcookie();
		getLoginScenario().saveBean(CommonConstants.PSC_CODE, tfnCookieValue.get("PSC Code"));
		getLoginScenario().saveBean(CommonConstants.SRC_CODE, tfnCookieValue.get("Source Code"));
		getLoginScenario().saveBean(CommonConstants.FED_TFN, tfnCookieValue.get("Fed TFN"));
		getLoginScenario().saveBean(CommonConstants.MEDSUP_TFN, tfnCookieValue.get("Medsup TFN"));
	}

	WebDriver wd;

	@Then("^the user validates PSC code$")
	public void the_user_validates_PSC_code(DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String pscCode = inputAttributesMap.get("PSC Code");
		wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE,
				(new CampaignTFNPage(wd)));
		String actualPscCode = (String) getLoginScenario().getBean(CommonConstants.PSC_CODE);
		tfnPage.validatePSCcode(pscCode, actualPscCode);
	}

	@Then("^the user navigates to following MA Plan Page URL and validate Federal TFN$")
	public void the_user_navigates_to_following_MA_Plan_Page_URL_and_validate_Federal_TFN(DataTable arg1)
			throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("MA URL");
		// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		// tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user navigates to following MedEd Plan Page URL and validate Federal TFN$")
	public void the_user_navigates_MedEd_Page_and_validates_federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("MedEd URL");
		// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		// tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user navigate to following PDP Plan Page URL and validate Federal TFN$")
	public void the_user_navigate_to_following_PDP_Plan_Page_URL_and_validate_Federal_TFN(DataTable arg1)
			throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("PDP URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user navigate to following SNP Plan page URL and validate Federal TFN$")
	public void the_user_navigate_to_following_SNP_Plan_page_URL_and_validate_Federal_TFN(DataTable arg1)
			throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("SNP URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user navigate to following Med Supp Plan URL and validate MedSupp TFN$")
	public void the_user_navigate_to_following_Med_Supp_Plan_URL_and_validate_MedSupp_TFN(DataTable arg1)
			throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("MedSupp URL");
		// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		// tfnPage.validateMedSuppTFN(TFN_Xpath);
		// tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Given("^the user is on AARP medicare acquisition site from Campaign Traffic$")
	public void the_user_lands_on_AARP_from_Campaign_Traffic(DataTable arg1) throws Throwable {
		driver = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		// driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(driver);
		// getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		String EnvironmentUrl = aquisitionhomepage.fetchEnvironmentUrls();
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("Campaign URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		tfnPage.navigateToCampaignURL(URLpath, EnvironmentUrl);
	}

	@Given("^the user is on following acquisition site from Campaign Traffic$")
	public void the_user_is_on_following_acquisition_site_from_Campaign_Traffic(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String Acq_Site = inputAttributesMap.get("Site");
		String CampaignPath = inputAttributesMap.get("Campaign URL");
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		// wd.manage().deleteAllCookies();
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.OpenPath(Acq_Site, CampaignPath);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, tfnPage);

	}

	@Given("^user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page$")
	public void user_is_on_Google_and_search_AARP_Medicare_Advantage_Plan_to_navigate_to_AARP_page() throws Exception {

		String url = "https://www.google.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		// wd.manage().deleteAllCookies();
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.openUrl(url);
		tfnPage.googleSearchAARP();

		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
	}

	@Given("^user is on Yahoo and search AARP Medicare Advantage Plan to navigate to AARP page$")
	public void user_is_on_Yahoo_and_search_AARP_Medicare_Advantage_Plan_to_navigate_to_AARP_page() throws Throwable {

		String url = "https://www.Yahoo.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		// wd.manage().deleteAllCookies();
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

		// wd.manage().deleteAllCookies();
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.openUrl(url);
		tfnPage.BingSearchAARP();

		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);

	}

	@Given("^user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page$")
	public void user_is_on_Google_and_search_UHC_Medicare_Advantage_Plan_to_navigate_to_UHC_page() throws Exception {

		String url = "https://www.google.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		// wd.manage().deleteAllCookies();
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
		// wd.manage().deleteAllCookies();
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
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String Acq_Site = inputAttributesMap.get("Site");
		String URLpath = inputAttributesMap.get("MA URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.OpenPath(Acq_Site, URLpath);
		tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user validates TFN on the particular deeplink URL page$")
	public void the_user_validates_TFN_on_deeplink(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.validateMedSuppTFN(TFN_Xpath);
	}

	@Then("^the user validates Federal TFN for PDP Plan Summary Page$")
	public void the_user_validates_TFN_on_PDP_PlanSummary(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToPDPPlans();
		tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user navigates to MA Plan Details Page and validates Federal TFN$")
	public void the_user_navigates_to_MA_Plan_Details_Page_and_validates_Federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		String expectedTfnNumber = (String) getLoginScenario().getBean(CommonConstants.FED_TFN);
		String Zip = inputAttributesMap.get("Zip Code");
		tfnPage.HomepagePlanSearch(Zip);
		// tfnPage.HomepagePlanSearchOLE(Zip);
		String PlanType = "MA";
		tfnPage.ViewPlanSummary(PlanType);
		tfnPage.NavigateToPlanDetails(PlanType);
		String TFNXpath_PlanDetails = "(//a[contains(@class, 'tel')])[3]";
		// tfnPage.validateFederalTFN(TFNXpath_PlanDetails);
		tfnPage.validateFederalTFNNo(TFNXpath_PlanDetails, expectedTfnNumber);

	}

	@Then("^the user navigates to PDP Plan Details Page and validates Federal TFN$")
	public void the_user_navigates_to_PDP_Plan_Details_Page_and_validates_Federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.NavigateToHome();
		String Zip = inputAttributesMap.get("Zip Code");
		tfnPage.HomepagePlanSearch(Zip);
		String PlanType = "PDP";
		tfnPage.ViewPlanSummary(PlanType);
		tfnPage.NavigateToPlanDetails(PlanType);
		String TFNXpath_PlanDetails = "(//a[contains(@class, 'tel')])[3]";
		tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@Then("^the user navigates to SNP Plan Details Page and validates Federal TFN$")
	public void the_user_navigates_to_SNP_Plan_Details_Page_and_validates_Federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.NavigateToHome();
		String Zip = inputAttributesMap.get("Zip Code");
		tfnPage.HomepagePlanSearch(Zip);
		String PlanType = "SNP";
		tfnPage.ViewPlanSummary(PlanType);
		tfnPage.NavigateToPlanDetails(PlanType);
		String TFNXpath_PlanDetails = "//a[contains(@class, 'tel')]";
		tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@Then("^the user navigates to MA OLE Page and validates Federal TFN$")
	public void the_user_navigates_to_MA_OLE_Page_and_validates_Federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.NavigateToHome();
		String Zip = inputAttributesMap.get("Zip Code");
		tfnPage.HomepagePlanSearch(Zip);
		String PlanType = "MA";
		tfnPage.ViewPlanSummary(PlanType);
		tfnPage.handlePlanYearSelectionPopup();
		tfnPage.NavigateToOLE(PlanType);
		String TFNXpath_PlanDetails = "//a[contains(@class, 'tel') and contains(@href, 'tel')]";
		tfnPage.validateFederalTFN(TFNXpath_PlanDetails);
	}

	@Then("^the user navigates to PDP OLE Page and validates Federal TFN$")
	public void the_user_navigates_to_PDP_OLE_Page_and_validates_Federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.NavigateToHome();
		String Zip = inputAttributesMap.get("Zip Code");
		tfnPage.HomepagePlanSearch(Zip);
		String PlanType = "PDP";
		tfnPage.ViewPlanSummary(PlanType);
		tfnPage.handlePlanYearSelectionPopup();
		tfnPage.NavigateToOLE(PlanType);
		String TFNXpath_PlanDetails = "//a[contains(@class, 'tel') and contains(@href, 'tel')]";
		tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@Then("^the user navigates to SNP OLE Page and validates Federal TFN$")
	public void the_user_navigates_to_SNP_OLE_Page_and_validates_Federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.NavigateToHome();
		String Zip = inputAttributesMap.get("Zip Code");
		tfnPage.HomepagePlanSearch(Zip);
		String PlanType = "SNP";
		tfnPage.ViewPlanSummary(PlanType);
		tfnPage.handlePlanYearSelectionPopup();
		tfnPage.NavigateToOLE(PlanType);
		String TFNXpath_PlanDetails = "//a[contains(@class, 'tel') and contains(@href, 'tel')]";
		tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@Then("^the user navigates to Medsupp Plans in VPP and validates Medsupp TFN$")
	public void the_user_navigates_to_Medsupp_VPP_and_validates_Medsupp_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.NavigateToHome();
		String Zip = inputAttributesMap.get("Zip Code");
		tfnPage.HomepagePlanSearch(Zip);
		String PlanType = "MS";
		tfnPage.ViewPlanSummary(PlanType);
		// String TFNXpath_PlanDetails = "//*[contains(@class,'tel right')]";
		// String TFNXpath_PlanDetails=inputAttributesMap.get("TFN Xpath");
		// tfnPage.validateMedSuppTFN(TFNXpath_PlanDetails);

	}

	@Then("^the user navigates to following memeber signin page and navigate to view medicare plans link AARP$")
	public void the_user_navigates_to_following_memeber_signin_page_AARP(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String memberSignINURL = inputAttributesMap.get("Member Signin URL");
		String memberSignINSTAGEURL = inputAttributesMap.get("Member Signin URL STG");
		String memberSignINOFFLINEURL = inputAttributesMap.get("Member Signin URL Offline");
		/*
		 * if (!(MRScenario.environment.equalsIgnoreCase("offline") ||
		 * MRScenario.environment.equalsIgnoreCase("prod") ||
		 * MRScenario.environment.equalsIgnoreCase("stage"))) {
		 */
		// AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(driver);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		if (getLoginScenario().environment.equalsIgnoreCase("stage")) {
			aquisitionhomepage.clickonmemberSignInStagelink(memberSignINSTAGEURL);
		} else if (getLoginScenario().environment.equalsIgnoreCase("prod")) {
			aquisitionhomepage.clickonmemberSignInlink(memberSignINURL);
		} else if (getLoginScenario().environment.equalsIgnoreCase("offline")) {
			aquisitionhomepage.clickonmemberSignInOfflinelink(memberSignINOFFLINEURL);
		} else {
			Assertion.fail("Error in loading the UHC Agent Page");
		}
		// }
	}

	@Then("^the user validate the sam icons tfn with federal TFN on Acquistion page$")
	public void the_user_validate_sam_icons_tfn_with_Federal_TFN() throws Throwable {
		// Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String TFN_Xpath = "//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]";
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		// tfnPage.navigateToUrl(URLpath);
		tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user navigates to following  Medicare Education Page URL and validate Federal TFN$")
	public void the_user_navigates_to_following_Medicare_Education_Page_URL_and_validate_Federal_TFN(DataTable arg1)
			throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("MEDICARE URL");
		// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		// tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@And("^the user clicks on the shopping cart icon in AARP site for campaign TFN$")
	public void the_user_clicks_on_the_shopping_cart_icon_in_AARP_site_Campaign_TFN() {

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.NavigateToHome();

		AcquisitionHomePage acqHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		// VisitorProfilePage visitorProfilePage =
		// acqHomePage.navigateToVisitorProfilePage();

		// getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE,
		// visitorProfilePage);
		String TFNXpath_PlanDetails = "//a[contains(@class, 'tel') and contains(@href, 'tel')]";
		tfnPage.validateFederalTFN(TFNXpath_PlanDetails);
	}

	@Then("^the user navigates to following  DCE Page URL and validate Federal TFN$")
	public void the_user_navigates_to_following_DCE_Page_URL_and_validate_Federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("DCE URL");
		String TFN_Xpath = "//button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')]";
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		// tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user navigates to shop pages Page and validates Federal TFN$")
	public void the_user_navigates_to_shop_Page_and_validates_Federal_TFN(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("SHOPPAGES URL");
		// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");

		// String TFN_Xpath = "(//a[contains(@class, 'tel')])[1] ";
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.NavigateToHome();
		tfnPage.navigateToUrl(URLpath);
		// tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user navigates to homepage validates Federal TFN$")
	public void the_user_navigates_to_homePage_and_validates_Federal_TFN() throws Throwable {
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.NavigateToHome();
		// String TFN_Xpath =
		// "//button[@id='sam-call-button']//span[contains(@class,'sam__button__text
		// desktop')]";
		// tfnPage.validateFederalTFN(TFN_Xpath);

	}

	@Given("^the user is on AARP medicare acquisition site from External Link and Land on MA Plans$")
	public void the_user_lands_on_AARP_from_External_Link_Landon_MA_Plans(DataTable arg1) throws Throwable {
		/*
		 * driver = getLoginScenario().getWebDriverNew();
		 * getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver); //driver =
		 * (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		 * AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(driver);
		 * //getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		 * getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
		 * aquisitionhomepage); String EnvironmentUrl =
		 * aquisitionhomepage.fetchEnvironmentUrls(); Map<String, String>
		 * inputAttributesMap=parseInputArguments(arg1); String URLpath =
		 * inputAttributesMap.get("Campaign URL"); //String TFN_Xpath =
		 * "//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]"
		 * ; CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		 * getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		 * tfnPage.navigateToCampaignURL(URLpath , EnvironmentUrl); // String PlanType =
		 * "MA"; //tfnPage.ViewPlanSummary(PlanType);
		 * //tfnPage.NavigateToPlanDetails(PlanType); //String TFNXpath_PlanDetails =
		 * "//a[contains(@class, 'tel')]";
		 * //tfnPage.validateFederalTFN(TFNXpath_PlanDetails);
		 */

		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		String EnvironmentUrl = aquisitionhomepage.fetchEnvironmentUrls();
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("Campaign URL");
		CampaignTFNPage tfnPage = new CampaignTFNPage(wd);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		tfnPage.navigateToCampaignURL(URLpath, EnvironmentUrl);
	}

	@And("^the user signs in with optum Id credentials for campaign TFN$")
	public void the_user_signs_in_with_optum_Id_credentials_in_AARP_site_campaign_tfn(DataTable credentials) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(credentials);
		/*
		 * List<DataTableRow> plannameAttributesRow = credentials.getGherkinRows(); for
		 * (int i = 0; i < plannameAttributesRow.size(); i++) {
		 * 
		 * plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
		 * plannameAttributesRow.get(i).getCells().get(1)); }
		 */
		String username = plannameAttributesMap.get("User Name");
		String password = plannameAttributesMap.get("Password");

		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.signIn(username, password);
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfile);
	}

	@Given("^the user is on AARP medicare acquisition site from External Link and Land on PDP Plans$")
	public void the_user_lands_on_AARP_from_External_Link_Landon_PDP_Plans(DataTable arg1) throws Throwable {
		/*
		 * driver = getLoginScenario().getWebDriverNew();
		 * getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver); //driver =
		 * (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		 * AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(driver);
		 * //getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		 * getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
		 * aquisitionhomepage); String EnvironmentUrl =
		 * aquisitionhomepage.fetchEnvironmentUrls(); Map<String, String>
		 * inputAttributesMap=parseInputArguments(arg1); String URLpath =
		 * inputAttributesMap.get("Campaign URL"); //String TFN_Xpath =
		 * "//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]"
		 * ; CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		 * getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		 * tfnPage.navigateToCampaignURL(URLpath , EnvironmentUrl);
		 */

		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("MA URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		String Zip = "10001";
		tfnPage.HomepagePlanSearch(Zip);
		String PlanType = "PDP";
		tfnPage.ViewPlanSummary(PlanType);
		tfnPage.handlePlanYearSelectionPopup();
		tfnPage.NavigateToOLE(PlanType);
		String TFNXpath_PlanDetails = "//a[contains(@class, 'tel')]";
		tfnPage.validateFederalTFN(TFNXpath_PlanDetails);
	}

	@Given("^the user is on AARP medicare acquisition site from External Link and Land on DCE Page$")
	public void the_user_lands_on_AARP_from_External_Link_Landon_DCE_Page(DataTable arg1) throws Throwable {
		driver = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		// driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(driver);
		// getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		// String EnvironmentUrl = aquisitionhomepage.fetchEnvironmentUrls();
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("Campaign URL");
		// String TFN_Xpath =
		// "//button[@id='sam-call-button']//span[contains(@class,'sam__button__text
		// desktop')]";
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		// tfnPage.navigateToCampaignURL(URLpath , EnvironmentUrl);
		String TFNXpath_PlanDetails = "//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]";
		tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@Then("^the user selects View plan details for following plantype and PlanName for DCE Page$")
	public void the_user_selects_View_plan_details_for_following_plantype_and_PlanName_DCE_Page(DataTable attributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String plantype = memberAttributesMap.get("Plan Type");
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPage plansummaryPage = (DrugSummaryPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		PlanDetailsPage plandetailspage = plansummaryPage.clickViewplanDetailsForPlan(plantype, planName);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		String TFNXpath_PlanDetails = "//a[contains(@class, 'tel')]";
		tfnPage.validateFederalTFN(TFNXpath_PlanDetails);
		// getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
		// plandetailspage);
		getLoginScenario().saveBean(DCERedesignCommonConstants.PLANTYPE, plantype);
		getLoginScenario().saveBean(DCERedesignCommonConstants.PLANNAME, planName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, planName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);

		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);

	}

	@Given("^the user is on AARP medicare acquisition site from External Link start now and Land on pharmary locator$")
	public void the_user_lands_on_AARP_from_External_Link_start_now_Landon_pharmacy_locator(DataTable arg1)
			throws Throwable {
		driver = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		// driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(driver);
		// getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		// String EnvironmentUrl = aquisitionhomepage.fetchEnvironmentUrls();
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("Campaign URL");
		// String TFN_Xpath =
		// "//button[@id='sam-call-button']//span[contains(@class,'sam__button__text
		// desktop')]";
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		// tfnPage.navigateToCampaignURL(URLpath , EnvironmentUrl);
		String TFNXpath_PlanDetails = "//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]";
		tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@Given("^the user is on following acquisition site from External Link and land on MA Page$")
	public void the_user_is_on_following_acquisition_site_from_External_Site_Land_MA(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String Acq_Site = inputAttributesMap.get("Site");
		String CampaignPath = inputAttributesMap.get("Campaign URL");
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		// wd.manage().deleteAllCookies();
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.OpenPath(Acq_Site, CampaignPath);
		String TFNXpath_PlanDetails = "//a[contains(@class, 'tel')]";
		tfnPage.validateFederalTFN(TFNXpath_PlanDetails);
	}

	@Then("^the user navigate to following MedED Pages URL and validate Federal TFN$")
	public void the_user_navigate_to_following_MedED_Pages_URL_and_validate_Federal_TFN(DataTable arg1)
			throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("MedEd URL");
		// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		// tfnPage.validateMedSuppTFN(TFN_Xpath);
		// tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Given("^user is on Yahoo and search AARP Medicare Advantage Plan and  navigate to AARP shop pages$")
	public void user_is_on_Yahoo_and_search_AARP_Medicare_Advantage_Plan_to_navigate_to_AARP_shoppage()
			throws Throwable {

		String url = "https://www.Yahoo.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		// wd.manage().deleteAllCookies();
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.openUrl(url);
		tfnPage.YahooSearchAARPShopPages();

		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);

	}

	@Then("^the user navigates to plan tab on VPP and validates Federal TFN$")
	public void the_user_navigates_to_plan_tab_on_VPP_and_validates_Federal_TFN(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PlanType = memberAttributesMap.get("Plan Type");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		String Zip = memberAttributesMap.get("Zip Code");
		tfnPage.HomepagePlanSearch(Zip);
		tfnPage.ViewPlanSummary(PlanType);
		tfnPage.NavigateToPlanDetails(PlanType);
		// String TFNXpath_PlanDetails = "//a[contains(@class, 'tel')]";
		// tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@Then("^the user navigates to Plan Details Page for any plan and validates Federal TFN$")
	public void the_user_navigates_to_Plan_Details_Page_any_plan_and_validates_Federal_TFN(DataTable attributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PlanType = memberAttributesMap.get("Plan Type");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		// tfnPage.ViewPlanSummary(PlanType);
		tfnPage.NavigateToPlanDetails(PlanType);
		// String TFNXpath_PlanDetails = memberAttributesMap.get("TFN Xpath");
		// tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@Then("^the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN$")
	public void the_user_navigates_to_Plan_Details_Page_any_plan_Enroll_and_validates_Federal_TFN(DataTable attributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PlanType = memberAttributesMap.get("Plan Type");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		// tfnPage.ViewPlanSummary(PlanType);
		// tfnPage.NavigateToPlanDetails(PlanType);
		tfnPage.NavigateToOLEEnroll(PlanType);
		// String TFNXpath_PlanDetails = memberAttributesMap.get("TFN Xpath");
		// tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@When("^the user performs plan search using Shop Pages for campaign Links$")
	public void Standalone_zipcode_details_shop_camapign_TFN(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		VPPPlanSummaryPage plansummaryPage = null;
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = tfnPage.searchPlansWithOutCountyShopEnroll(zipcode);
		} else {
			plansummaryPage = tfnPage.searchPlansShopEnroll(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@When("^the user performs plan search using Medicare articles pages for campaign Links$")
	public void Standalone_zipcode_details_shop_camapign_TFN_medicare_article(DataTable givenAttributes)
			throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		VPPPlanSummaryPage plansummaryPage = null;
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = tfnPage.searchPlansWithOutCountyArticlePage(zipcode);
		} else {
			plansummaryPage = tfnPage.searchPlansShopArticlePage(zipcode, county);
		}
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@Then("^the user validates TFN Number$")
	public void the_user_validates_TFN(DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		String TFNXpath = inputAttributesMap.get("TFN Xpath");
		String ExpecetdTFNNo = inputAttributesMap.get("TFN No");
		// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		tfnPage.validateFederalTFNNo(TFNXpath, ExpecetdTFNNo);
	}

	@Then("^the user navigates to plan tab for any plan$")
	public void the_user_navigates_to_Plan_tab_plan(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PlanType = memberAttributesMap.get("Plan Type");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.ViewPlanSummary(PlanType);
		// tfnPage.NavigateToPlanDetails(PlanType);
	}

	@Then("^the user navigates back to page$")
	public void the_user_navigates_back_page() throws Throwable {

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.validatebackpage();
	}

	@Then("^the user enter zipcode in homepage$")
	public void the_user_enter_zipcode(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PlanType = memberAttributesMap.get("Plan Type");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		String Zip = memberAttributesMap.get("Zip Code");
		tfnPage.HomepagePlanSearch(Zip);
		VPPPlanSummaryPage plansummaryPage = tfnPage.ViewPlanSummary(PlanType);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	}

	@Then("^the user navigates to Plan Details Page for DCE Flow$")
	public void the_user_navigates_to_Plan_Details_Page_DCE_FLOW(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PlanType = memberAttributesMap.get("Plan Type");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		// tfnPage.ViewPlanSummary(PlanType);
		tfnPage.NavigateToPlanDetailsdce(PlanType);
		// String TFNXpath_PlanDetails = memberAttributesMap.get("TFN Xpath");
		// tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@Then("^click on DCE Link on Pharmacy$")
	public void clickonDCELink_Pharmacy_page() throws InterruptedException {
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		// tfnPage.ViewPlanSummary(PlanType);
		tfnPage.NavigateToDCE();
	}

	@Then("^the user navigates to Plan Details Page for any SNP plan for Enroll and validates Federal TFN$")
	public void the_user_navigates_to_Plan_Details_Page_any_SNP_plan_Enroll_and_validates_Federal_TFN(
			DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PlanType = memberAttributesMap.get("Plan Type");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		// tfnPage.ViewPlanSummary(PlanType);
		// tfnPage.NavigateToPlanDetails(PlanType);
		tfnPage.NavigateToOLEEnrollDSNP(PlanType);
		// String TFNXpath_PlanDetails = memberAttributesMap.get("TFN Xpath");
		// tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@Then("^the user enter zipcode in homepage for External Links$")
	public void the_user_enter_zipcode_External_Link(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PlanType = memberAttributesMap.get("Plan Type");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		String Zip = memberAttributesMap.get("Zip Code");
		tfnPage.HomepagePlanSearchExternalLinks(Zip);
		// tfnPage.ViewPlanSummary(PlanType);

	}

	@Then("^the user Enroll for any plan on plan summary page$")
	public void the_user_enroll_for_plan_summary_page(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PlanType = memberAttributesMap.get("Plan Type");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		// tfnPage.ViewPlanSummary(PlanType);
		// tfnPage.NavigateToPlanDetails(PlanType);
		tfnPage.EnrollonVPPPage(PlanType);
		// String TFNXpath_PlanDetails = memberAttributesMap.get("TFN Xpath");
		// tfnPage.validateFederalTFN(TFNXpath_PlanDetails);

	}

	@Then("^the user navigates to following External Email Links$")
	public void the_user_navigates_External_Email_links(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("Email URL");
		// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateToUrl(URLpath);
		tfnPage.validateRefreshpage();
		// tfnPage.validateFederalTFN(TFN_Xpath);
	}

	@Then("^the user navigates to refresh page$")
	public void the_user_navigates_refresh_page() throws Throwable {

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.validateRefreshpage();
	}

	@Then("^the site user fills all the details in MedsuppPage for TFN$")
	public void user_fills_all_details_medsupp_TFN(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String DateOfBirth = memberAttributesMap.get("DOB");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.MedSupFormValidationTFN(DateOfBirth);
		
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
	}
	
	@Then("^the site user clicks on Start Application Button and proceed few Pages$")
	public void Start_application_button_proceed_next_few_pages(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */

		// String DateOfBirth = memberAttributesMap.get("DOB");
		String FirstName = memberAttributesMap.get("Firstname");
		String LastName = memberAttributesMap.get("Lastname");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.StartApplicationTFN(FirstName, LastName);
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpecetdTFNNo = memberAttributesMap.get("TFN No");
		// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		tfnPage.validateFederalTFNNo(TFNXpath, ExpecetdTFNNo);
		tfnPage.CancelApplicationTFN(FirstName, LastName);

		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, tfnPage);
	}

	@Then("^the user navigates to Homepage$")
	public void the_user_navigates_to_Homepage() throws Throwable {
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.NavigateToHome();

	}

	@Then("^the user close and reopen the broswer$")
	public void the_user_close_reopen_broswer() {
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		// CampaignTFNPage tfnPage = (CampaignTFNPage)
		// getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.closeOriginalTabAndOpenNewTab();
	}

	@When("^the user clicks on Agent link for MedsuppPage$")
	public void the_user_clicks_on_Agent_Link_MedSup(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		String TFNXpath = inputAttributesMap.get("TFN Xpath");
		String ExpecetdTFNNo = inputAttributesMap.get("TFN No");
		String zipCode = inputAttributesMap.get("Zip Code");

		boolean isAddInfoLinkVisible = CommonUtility.waitAndVerifyIfElementVisibleOnPage(driver, By.xpath(
				"//img[contains(@class,'d-lg-inline-block')]//following-sibling::p//a[@dtmid='cta_acq_ms_vpp']"), 20);
	boolean assertionToFailOrPass = (isAddInfoLinkVisible && zipCode.equals("90210")
				|| !isAddInfoLinkVisible && zipCode.equals("10001")) ? true
						: (isAddInfoLinkVisible && zipCode.equals("10001")
								|| !isAddInfoLinkVisible && zipCode.equals("90210")) ? false : true;

		//Assert.assertTrue(assertionToFailOrPass,
			//	"*** imsPlan4HeadingVisible/Invisible : '" + msPlan4Heading + "' for zipCode : '" + zipCode + "'");

		if (isAddInfoLinkVisible) {
			tfnPage.clickAgentLinkMedsup4(TFNXpath, ExpecetdTFNNo);
		} else

			// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
			// tfnPage.validateFederalTFNNo(TFNXpath,ExpecetdTFNNo);
			tfnPage.clickOnAgentLinkMedSup(TFNXpath, ExpecetdTFNNo);

	}

	@Then("^the user clicks on decision guide for MedsuppPge$")
	public void User_navigate_through_Medsupp_EBRC(DataTable dataTable) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(dataTable);
		String zipCode = inputAttributesMap.get("Zip Code");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);

		boolean isMedsup4DOBVisible = CommonUtility.waitAndVerifyIfElementVisibleOnPage(driver,
				By.xpath("//input[@id='dateOfBirth']"), 20);

		boolean assertionToFailOrPass = (isMedsup4DOBVisible && zipCode.equals("90210")
				|| !isMedsup4DOBVisible && zipCode.equals("10001")) ? true
						: (isMedsup4DOBVisible && zipCode.equals("10001")
								|| !isMedsup4DOBVisible && zipCode.equals("90210")) ? false : true;

		//Assert.assertTrue(assertionToFailOrPass,
		//		"*** isAddInfoLinkVisible Visible/Invisible : '" + isAddInfoLinkVisible + "' for zipCode : '" + zipCode + "'");

		if (isMedsup4DOBVisible) {
			tfnPage.decisionGuidenotPresent();
		} else
		{
			// if(myUHCAgentURL!=null){
			tfnPage.decisionGuide();
		// Assertion.assertTrue(true);
		// }else
		// Assertion.fail("Error in loading the UHC Agent Page");
	}
	}
	@When("^the user performs plan search using Shop Pages for Medsupp Page$")
	public void Shop_Standalone_zipcode_details_MedsuppPage(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		VPPPlanSummaryPage plansummaryPage = null;
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = tfnPage.searchPlansWithOutCountyShopEnrollMedsupp(zipcode);
		} else {
			plansummaryPage = tfnPage.searchPlansShopEnrollMedsupp(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@Then("^the user navigate to Pharmacy page$")
	public void user_navigate_pharmacy_page(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */

		String zipcode = memberAttributesMap.get("Zip Code");
		String distance = memberAttributesMap.get("Distance");
		String county = memberAttributesMap.get("County Name");
		String planName = memberAttributesMap.get("Plan Name");

		if (county == null)
			county = "None";

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.enterZipDistanceDetails(zipcode, distance, county, planName);

	}

	@Given("^the user is on UHC medicare solutions acquisition site from Campaign Traffic$")
	public void the_user_lands_on_UHC_from_Campaign_Traffic(DataTable arg1) throws Throwable {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		String EnvironmentUrl = aquisitionhomepage.fetchEnvironmentUrlsUMS();
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("Campaign URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = new CampaignTFNPage(wd);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		tfnPage.navigateToCampaignURL(URLpath, EnvironmentUrl);
	}

	@Then("^the user navigates to following memeber signin page and navigate to view medicare plans link UHC$")
	public void the_user_navigates_to_following_memeber_signin_page_UHC(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String memberSignINURL = inputAttributesMap.get("Member Signin URL");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		if (memberSignINURL != null) {
			aquisitionhomepage.clickonmemberSignInlink(memberSignINURL);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in loading the UHC Agent Page");
		// tfnPage.validateFederalTFN(TFN_Xpath);

	}

	@Then("^user clicks on back to plans link to navigate plan summary$")
	public void User_clicks_BackToPlansLink_and_navigate_back_to_plan_summary() {
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.navigateBackToPlanSummaryPageFromDetailsPage();
	}

	@Given("^the user is on AARP External Link and Land on MA Plans$")
	public void the_user_is_on_AARP_from_External_Link_Landon_MA_Plans(DataTable arg1) throws Throwable {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(driver);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		String EnvironmentUrl = aquisitionhomepage.fetchEnvironmentUrls();
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("Campaign URL");
		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		tfnPage.navigateToCampaignURL(URLpath, EnvironmentUrl);
	}

	@Given("^the user is on UHC acquisition site from Campaign Traffic$")
	public void the_user_is_on_UHC_from_Campaign_Traffic(DataTable arg1) throws Throwable {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		String EnvironmentUrl = aquisitionhomepage.fetchEnvironmentUrlsUMS();
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String URLpath = inputAttributesMap.get("Campaign URL");
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		tfnPage.navigateToCampaignURL(URLpath, EnvironmentUrl);
	}

	@Given("^user opens Google in new tab and search AARP Medicare Advantage Plan to navigate to AARP page$")
	public void user_opens_tab_to_access_AARP_page() throws Exception {

		String url = "https://www.google.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		// wd.manage().deleteAllCookies();
		
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.openURLNewTabAARP(url);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
	}

	@Given("^user opens Google in new tab and search UHC Medicare Advantage Plan to navigate to UHC page$")
	public void user_opens_tab_to_access_UHC_page() throws Exception {

		String url = "https://www.google.com/";
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		// wd.manage().deleteAllCookies();
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, driver);
		tfnPage.openURLNewTabUHC(url);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
	}

	@Then("the user validates Fed TFN")
	public void the_user_validates_fed_tfn(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String expectedFedTFN = inputAttributesMap.get("TFN No");
		wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE,
				(new CampaignTFNPage(wd)));
		String actualFedTFN = (String) getLoginScenario().getBean(CommonConstants.FED_TFN);
		tfnPage.validateFedTFNNo(expectedFedTFN, actualFedTFN);
	}

	@Then("the user validates MedSup TFN")
	public void the_user_validates_med_sup_tfn(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String expectedMedsupTFN = inputAttributesMap.get("TFN No");
		wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE,
				(new CampaignTFNPage(wd)));
		String actualMedsupTFN = (String) getLoginScenario().getBean(CommonConstants.MEDSUP_TFN);
		tfnPage.validateMedsupTFNNo(expectedMedsupTFN, actualMedsupTFN);
	}

	@Then("^the user validates TFN Number in header and SAM icon$")
	public void the_user_validates_TFN_number_in_header_and_SAM_icon() throws Throwable {
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.validateTFNHeaderAndSAMIcon();
	}

	@Then("the user validates source code")
	public void the_user_validates_source_code(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String expectedSrcCode = inputAttributesMap.get("sourceCode");
		wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE,
				(new CampaignTFNPage(wd)));
		String actualSrcCode = (String) getLoginScenario().getBean(CommonConstants.SRC_CODE);
		tfnPage.validateSourceCode(expectedSrcCode, actualSrcCode);
	}
	@Then("^the user fills all the details in MedsuppPage for TFN$")
	public void user_fills_all_details_medsupp_Form_TFN(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */

		String DateOfBirth = memberAttributesMap.get("DOB");
		String zipCode = memberAttributesMap.get("Zip Code");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		boolean isAddInfoLinkVisible = CommonUtility.waitAndVerifyIfElementVisibleOnPage(driver, By.xpath(
				"//img[contains(@class,'d-lg-inline-block')]//following-sibling::p//a[@dtmid='cta_acq_ms_vpp']"), 20);
		boolean assertionToFailOrPass = false;

		assertionToFailOrPass = (isAddInfoLinkVisible && zipCode.equals("90210")
				|| !isAddInfoLinkVisible && zipCode.equals("10001")) ? true
						: (isAddInfoLinkVisible && zipCode.equals("10001")
								|| !isAddInfoLinkVisible && zipCode.equals("90210")) ? false : true;

		Assert.assertTrue(assertionToFailOrPass,
				"*** isMedsup4DOB Visible/Invisible : '" + isAddInfoLinkVisible + "' for zipCode : '" + zipCode + "'");

		if (isAddInfoLinkVisible) {
			tfnPage.addInfoAndMedSupFormTFN();
		} else {
			tfnPage.MedSupFormValidationTFN(DateOfBirth);

			getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		}
	}
	
	@Then("^the user click on back to previous page on Request a Free Decision Guide$")
	public void user_click_on_previous_Page_On_Decision_Guide(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String zipCode = memberAttributesMap.get("Zip Code");

		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		boolean isMedsup4DOB = CommonUtility.waitAndVerifyIfElementVisibleOnPage(driver, By.xpath(
				"//*[@id='dateOfBirth']"), 20);
		boolean assertionToFailOrPass = false;

		assertionToFailOrPass = (isMedsup4DOB && zipCode.equals("90210")
				|| !isMedsup4DOB && zipCode.equals("10001")) ? true
						: (isMedsup4DOB && zipCode.equals("10001")
								|| !isMedsup4DOB && zipCode.equals("90210")) ? false : true;

		Assert.assertTrue(assertionToFailOrPass,
				"*** isMedsup4DOB Visible/Invisible : '" + isMedsup4DOB + "' for zipCode : '" + zipCode + "'");

		if (isMedsup4DOB) {
			tfnPage.backtoPreviousDGMedsup4();
		} else {
			tfnPage.backtoPreviousDGMedsup3();

			getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		}
	}

	@And("^user click on Start Application in MS plan$")
	public void the_user_clicks_on_Start_MS_OLE(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		//String TFNXpath = inputAttributesMap.get("TFN Xpath");
		//String ExpecetdTFNNo = inputAttributesMap.get("TFN No");
		String zipCode = inputAttributesMap.get("Zip Code");

		boolean msPlansHeading = CommonUtility.waitAndVerifyIfElementVisibleOnPage(driver, By.xpath(
				"//h1[contains(normalize-space(),'AARP® Medicare Supplement Insurance Plans insured by UnitedHealthcare')]"), 20);
	boolean assertionToFailOrPass = (msPlansHeading && zipCode.equals("90210")
				|| !msPlansHeading && zipCode.equals("10001")) ? true
						: (msPlansHeading && zipCode.equals("10001")
								|| !msPlansHeading && zipCode.equals("90210")) ? false : true;

		Assert.assertTrue(assertionToFailOrPass,
			"*** imsPlan4HeadingVisible/Invisible : '" + msPlansHeading + "' for zipCode : '" + zipCode + "'");

		if (msPlansHeading) {
			tfnPage.clickStartMS4Ole();
		} else

			// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
			// tfnPage.validateFederalTFNNo(TFNXpath,ExpecetdTFNNo);
			tfnPage.clickStartMS3Ole();

	}

	@And("^user click on Cancel Application in MS plan$")
	public void the_user_clicks_on_Cancel_MS_OLE(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		//String TFNXpath = inputAttributesMap.get("TFN Xpath");
		//String ExpecetdTFNNo = inputAttributesMap.get("TFN No");
		String zipCode = inputAttributesMap.get("Zip Code");

		boolean isMedsup4DOB = CommonUtility.waitAndVerifyIfElementVisibleOnPage(driver, By.xpath(
				"//*[@id='dateOfBirth']"), 20);
	boolean assertionToFailOrPass = (isMedsup4DOB && zipCode.equals("90210")
				|| !isMedsup4DOB && zipCode.equals("10001")) ? true
						: (isMedsup4DOB && zipCode.equals("10001")
								|| !isMedsup4DOB && zipCode.equals("90210")) ? false : true;

		Assert.assertTrue(assertionToFailOrPass,
			"*** isMedsupDOBVisible/invisible : '" + isMedsup4DOB + "' for zipCode : '" + zipCode + "'");

		if (isMedsup4DOB) {
			tfnPage.clickCancelMS4Ole();
		} else

			// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
			// tfnPage.validateFederalTFNNo(TFNXpath,ExpecetdTFNNo);
			tfnPage.clickCancelMS3Ole();

	}
	
	@And("^user click on View Plan Details in MS plan$")
	public void the_user_clicks_on_View_Plan_Detials_in_MS_Plan(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		//String TFNXpath = inputAttributesMap.get("TFN Xpath");
		//String ExpecetdTFNNo = inputAttributesMap.get("TFN No");
		String zipCode = inputAttributesMap.get("Zip Code");

		boolean msPlansHeading = CommonUtility.waitAndVerifyIfElementVisibleOnPage(driver, By.xpath(
				"//h1[contains(normalize-space(),'AARP® Medicare Supplement Insurance Plans insured by UnitedHealthcare')]"), 20);
	boolean assertionToFailOrPass = (msPlansHeading && zipCode.equals("90210")
				|| !msPlansHeading && zipCode.equals("10001")) ? true
						: (msPlansHeading && zipCode.equals("10001")
								|| !msPlansHeading&& zipCode.equals("90210")) ? false : true;

		Assert.assertTrue(assertionToFailOrPass,
			"*** imsPlan4HeadingVisible/Invisible : '" + msPlansHeading + "' for zipCode : '" + zipCode + "'");

		if (msPlansHeading) {
			tfnPage.ms4ViewPlanDetails();
		} else

			// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
			// tfnPage.validateFederalTFNNo(TFNXpath,ExpecetdTFNNo);
			tfnPage.ms3ViewPlanDetails();

}
	
	@And("^user click on Back to Plan in MS Plan Details$")
	public void the_user_clicks_on_Back_to_All_Plan_From_MS_Detail_Page(DataTable arg1) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		//String TFNXpath = inputAttributesMap.get("TFN Xpath");
		//String ExpecetdTFNNo = inputAttributesMap.get("TFN No");
		String zipCode = inputAttributesMap.get("Zip Code");

		boolean msPlansDetailsBackToAllPlans = CommonUtility.waitAndVerifyIfElementVisibleOnPage(driver, By.xpath(
				"//a[@class='uhc-link-button back-to-plans' and normalize-space()='Back to plan list']"), 20);
	boolean assertionToFailOrPass = (msPlansDetailsBackToAllPlans && zipCode.equals("90210")
				|| !msPlansDetailsBackToAllPlans && zipCode.equals("10001")) ? true
						: (msPlansDetailsBackToAllPlans && zipCode.equals("10001")
								|| !msPlansDetailsBackToAllPlans&& zipCode.equals("90210")) ? false : true;

		Assert.assertTrue(assertionToFailOrPass,
			"*** msBacktoPlanListvisible/invisible : '" + msPlansDetailsBackToAllPlans + "' for zipCode : '" + zipCode + "'");

		if (msPlansDetailsBackToAllPlans) {
			tfnPage.ms4BackToPlanList();
		} else

			// String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
			// tfnPage.validateFederalTFNNo(TFNXpath,ExpecetdTFNNo);
			tfnPage.ms3BackToAllPlans();

}
	@Given("^the user retrieves TFNSessionCookie and Federal and MedSupp TFN on LP$")
	public void the_user_retrieves_TFNSessionCookie_and_Federal_and_MedSupp_TFN_on_LP() throws Throwable {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		HashMap<String, String> tfnCookieValue = tfnPage.retrieveTFNcookieLP();
		getLoginScenario().saveBean(CommonConstants.PSC_CODE, tfnCookieValue.get("PSC Code"));
		getLoginScenario().saveBean(CommonConstants.SRC_CODE, tfnCookieValue.get("Source Code"));
		getLoginScenario().saveBean(CommonConstants.FED_TFN, tfnCookieValue.get("Fed TFN"));
		getLoginScenario().saveBean(CommonConstants.MEDSUP_TFN, tfnCookieValue.get("Medsup TFN"));
	}
	
	
}