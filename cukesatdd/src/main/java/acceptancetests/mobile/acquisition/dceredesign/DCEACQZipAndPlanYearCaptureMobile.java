package acceptancetests.mobile.acquisition.dceredesign;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.dceredesign.TellUsAboutDrug;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.VisitorProfilePage;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;
import pages.mobile.acquisition.dceredesign.TellUsAboutDrugMobile;
import pages.mobile.acquisition.dceredesign.ZipCodeAndPlanYearCapturePageMobile;
import pages.mobile.acquisition.ulayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.ulayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.ulayer.PlanDetailsPageMobile;
import pages.mobile.acquisition.ulayer.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.ulayer.VisitorProfilePageMobile;
//import pages.mobile.acquisition.ulayer.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality:DCE Acquisition
 */
public class DCEACQZipAndPlanYearCaptureMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;

	@When("^clicks on Review drug cost button$")
	public void clicks_on_Review_drug_cost_button() {
		BuildYourDrugListMobile buildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		buildDrugList.clickReviewDrugCostBtn();
	}

	@Then("^user should be navigated to zipcode and plan year capture page for AEP$")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page_for_AEP_in_AARP() {
		/*
		 * ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage)
		 * getLoginScenario()
		 * .getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		 * zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		 */

		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = new ZipCodeAndPlanYearCapturePageMobile(wd);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@Then("^plan year dropdown should be displayed during AEP$")
	public void plan_year_dropdown_should_be_displayed_during_AEP_in_AARP() {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validatePlanYearDrpDownAEP();
	}

	@When("^the user clicks on Add drugs button$")
	public void the_user_clicks_on_Add_drugs_button() {
		GetStartedPageMobile DCEgetStarted = (GetStartedPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		DCEgetStarted.clickAddDrugsBtn();
		// getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture,
		// zipCodePlanYearPage);
	}

	@When("^adds drugs in drug list page$")
	public void adds_drugs_in_drug_list_page(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String drugName = memberAttributesMap.get("DrugName");
		System.out.println("zipcode" + drugName);
		BuildYourDrugListMobile buildDrugList = new BuildYourDrugListMobile(wd);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
		buildDrugList.addDrugs(drugName);
	}
	
	@When("^user selects plan year$")
	public void user_selects_plan_year_in_AARP() {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.selectPlanYear();
	}
	
	@Then("^load screen should be displayed$")
	public void load_screen_should_be_displayed_in_AARP() {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		// zipCodePlanYearPage.verifyLoadScreen();
	}
	
	@Then("^user should be navigated to Review drug cost estimate page$")
	public void user_should_be_navigated_to_Review_drug_cost_estimate_page_in_AARP() {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.verifyReviewDrugCostPageDisplayed();
	}

	@When("^user enter invalid zipcode$")
	public void user_enter_invalid_zipcode_in_AARP(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String invalidzipcode = memberAttributesMap.get("inValidzipCode");
		System.out.println("zipcode" + invalidzipcode);
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.enterZipCode(invalidzipcode);
	}
	
	@Then("^error message should be displayed$")
	public void error_message_should_be_displayed_in_AARP() {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validateZipCodeErrorMessage();
	}
	
	@Then("^the user validates whether call icon is visible$")
	public void the_user_validates_whether_callicon_isvisible_on_UHC() throws InterruptedException {
		
	AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSam();
		//aquisitionhomepage.validateCallSamContent();
		aquisitionhomepage.validateCallpopup();
		/*
		 * if(returnval==null){ Assert.fail("No TFN found"); }else{
		 * Assert.assertTrue(true); }
		 */
	}
	
	@Then("^the user validates whether chat icon is visible")
	public void the_user_validates_whether_chaticon_isvisible() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatSam();
		aquisitionhomepage.verifyChatpopup();
		//aquisitionhomepage.validateChatpopupconnect();	
		
	}
	

}
