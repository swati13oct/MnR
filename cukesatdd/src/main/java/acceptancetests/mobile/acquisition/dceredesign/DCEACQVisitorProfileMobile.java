package acceptancetests.mobile.acquisition.dceredesign;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.dceredesign.TellUsAboutDrug;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.VisitorProfilePage;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;
import pages.mobile.acquisition.dceredesign.TellUsAboutDrugMobile;
import pages.mobile.acquisition.dceredesign.ZipCodeAndPlanYearCapturePageMobile;
import pages.mobile.acquisition.ulayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.ulayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.ulayer.VisitorProfilePageMobile;
//import pages.mobile.acquisition.ulayer.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality:DCE Acquisition
 */
public class DCEACQVisitorProfileMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;

	/**
	 * @toDo:user is on medicare acquisition site landing page
	 */

	@Given("^user is on AARP site$")
	public void the_user_on__medicaresolutions_Site(DataTable givenAttributes) {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@And("^the user clicks on the shopping cart icon$")
	public void the_user_clicks_on_the_shopping_cart_icon_on_DCE_page_in_AARP() {
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		VisitorProfilePageMobile visitorProfilePage = dce.clickOnShoppingCart();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@And("^user goto DCE redesign profile page via add drug button$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_profile_to_DCE_Redesign_in_AARP_site() {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		GetStartedPageMobile getStartedPage = visitorProfilePage.addDrug_DCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");

	}
	
	@Then("^end user goto GetStarted button and click on it$")
	public void the_user_verify_Get_Started_Page() throws Throwable {
		wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		GetStartedPageMobile DCEgetStarted = new GetStartedPageMobile(wd);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, DCEgetStarted);

	}
	
	@Then("^enduser navigate to build drug list by clicking on build drug list$")
	public void the_user_clicks_on_Build_Drug_List_to_navigate_to_Build_DrugList() throws Throwable {
		GetStartedPageMobile DCEgetStarted = (GetStartedPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		BuildYourDrugListMobile DCEbuildDrugList = DCEgetStarted.clickAddsDrugs();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		druglist = "";
		System.out.println("Setting Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}
	
	@Then("^the user searches and adds the following Drug to Drug List$")
	public void the_user_searches_and_adds_the_following_Drug_to_Drug_List(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String drugName = memberAttributesMap.get("DrugName");
		System.out.println(drugName);
		BuildYourDrugListMobile buildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrugMobile tellUsAboutDrug = buildDrugList.SearchaddDrugs(drugName);
		buildDrugList = tellUsAboutDrug.ClickAddDrug();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		druglist = druglist + "&" + drugName;
		System.out.println("Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}
	
	@Then("^enduser land on ZipEntry page by clicking on Review Drung Costs$")
	public void the_user_clicks_on_Add_Drug() throws Throwable {
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = DCEbuildDrugList.navigateToZipEntryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}
	
	@Then("^enduser provide zipcode and select county$")
	public void user_enter_valid_zipcode_and_county_in_AARP(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = memberAttributesMap.get("ZipCode");
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.enterZipCodeandcounty(zipcode);
	}

	
	@Then("^user click on continue button$")
	public void user_clicks_on_continue_button_ZipENtryPage_in_AARP() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		DrugSummaryPage drugSummaryPage = zipCodePlanYearPage.clickContinueBtn();
		// zipCodePlanYearPage.verifyLoadScreen();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}


	@Given("^the user clicks on the add drugs button to navigate to DCE Redesign on the profile page$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_profile_to_DCE_Redesign_in_AARP_site1() {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		GetStartedPageMobile getStartedPage = visitorProfilePage.addDrug_DCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");

	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}