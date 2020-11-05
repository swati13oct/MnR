package acceptancetests.mobile.acquisition.siteSearch;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AboutUsPage;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AddDrugDetails;
import pages.acquisition.bluelayer.ContactUsUmsPage;
import pages.acquisition.bluelayer.DisclaimersPage;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.bluelayer.PrivacyPolicyUmsPage;
import pages.acquisition.bluelayer.ProviderSearchPage;
import pages.acquisition.bluelayer.SavingsOppurtunity;
import pages.acquisition.bluelayer.SiteMapUMSPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.emailAndPrint.EmailAndPrintUtil;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.VPPTestHarnessPage;
import pages.acquisition.ulayer.keywordSearchAARP;
import pages.mobile.acquisition.bluelayer.AboutUsPageMobile;
import pages.mobile.acquisition.bluelayer.ContactUsUmsPageMobile;
import pages.mobile.acquisition.bluelayer.DisclaimersPageMobile;
import pages.mobile.acquisition.bluelayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.bluelayer.PlanDetailsPageMobile;
import pages.mobile.acquisition.bluelayer.PrivacyPolicyUmsPageMobile;
import pages.mobile.acquisition.bluelayer.ProviderSearchPageMobile;
import pages.mobile.acquisition.bluelayer.SiteMapUMSPageMobile;
import pages.mobile.acquisition.commonpages.PharmacySearchPageMobile;
import pages.mobile.acquisition.dce.bluelayer.AddDrugDetailsMobile;
import pages.mobile.acquisition.dce.bluelayer.SavingsOppurtunityMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.emailAndPrint.EmailAndPrintUtilMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;
import pages.mobile.acquisition.ulayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.ulayer.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.ulayer.VPPTestHarnessPageMobile;
//import pages.acquisition.ulayer.keywordSearch;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality: VPP flow for AARP site
 */

public class SiteSearchMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;
	
	
	
	/** user is on the AARP Medicare Site landing page */
	@Given("^the user is on the Acquisition Site landing page and navigate to pharmacy search page$")
	public void validateUserIsOnAcquisitionSiteNavToPharmacySearch(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd,siteName);
		String testSiteUrl=aquisitionhomepage.getTestSiteUrl();
		System.out.println("TEST - testSiteUrl="+testSiteUrl);
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL,testSiteUrl);
		
		aquisitionhomepage.selectState("Select State"); //note: default it to no state selected for predictable result
		System.out.println("Unselected state on home page for more predictable result");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		PharmacySearchPageMobile pharmacySearchPage= aquisitionhomepage.navigateToPharmacyLocator();
		//PharmacySearchPage pharmacySearchPage=new PharmacySearchPage(aquisitionhomepage.driver);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE,
				pharmacySearchPage);

	}
	
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}
	

}
