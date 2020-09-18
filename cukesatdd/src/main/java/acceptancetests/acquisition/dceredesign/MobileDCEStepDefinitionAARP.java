package acceptancetests.acquisition.dceredesign;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.dce.ulayer.DCETestHarnessPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AddDrugDetails;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.SavingsOppurtunity;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.mobile.acquisition.bluelayer.AcquisitionHomePageMobile;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality:DCE Acquisition
 */
public class MobileDCEStepDefinitionAARP {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;
	
	@Given("^the user is on AARP medicare acquisition site landing page Mobile$")
	public void the_user_on_uhc_medicaresolutions_site_mobile() {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openPRE();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@Given("^the user navigates to following AARP medicare acquisition site page Mobile$")
	public void the_user_navigates_to_following_AARP_medicare_acquisition_site_page_Mobile(DataTable arg1) throws Throwable {
	}

	@Then("^the user validates Get Started Page Mobile$")
	public void the_user_validates_Get_Started_Page_Mobile() throws Throwable {
	}

	@Then("^the user clicks on Build Drug List to navigate to Step (\\d+) Mobile$")
	public void the_user_clicks_on_Build_Drug_List_to_navigate_to_Step_Mobile(int arg1) throws Throwable {
	}

}
