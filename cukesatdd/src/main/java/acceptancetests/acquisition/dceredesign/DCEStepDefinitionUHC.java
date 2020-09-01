package acceptancetests.acquisition.dceredesign;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.VisitorProfilePage;
import pages.acquisition.dce.ulayer.DCETestHarnessPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AddDrugDetails;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.SavingsOppurtunity;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
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
 * Functionality:DCE Acquisition
 */
public class DCEStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver driver;

	@Then("^the user validates Get Started Page for UHC$")
	public void the_user_validates_Get_Started_Page_UHC() throws Throwable {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		GetStartedPage DCEgetStarted = new GetStartedPage(driver);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEgetStarted);

	}

/*	@Then("^the user clicks on Build Drug List to navigate to Step (\\d+)$")
	public void the_user_clicks_on_Build_Drug_List_to_navigate_to_Step(int arg1) throws Throwable {
		GetStartedPage DCEgetStarted = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		BuildYourDrugList DCEbuildDrugList = DCEgetStarted.clickAddsDrugs();

	}*/

	@When("^the user clicks on Add drugs button on UHC$")
	public void the_user_clicks_on_Add_drugs_button_UHC() {
		GetStartedPage DCEgetStarted = (GetStartedPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEgetStarted.clickAddDrugsBtn();
		// getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture,
		// zipCodePlanYearPage);
	}

	@When("^adds drugs in drug list page on UHC$")
	public void adds_drugs_in_drug_list_page_UHC(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String drugName = memberAttributesMap.get("DrugName");
		System.out.println("zipcode" + drugName);
		BuildYourDrugList buildDrugList = new BuildYourDrugList(driver);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
		buildDrugList.addDrugs(drugName);
	}

	@Then("^plan year dropdown should be displayed during AEP on UHC$")
	public void plan_year_dropdown_should_be_displayed_during_AEP_UHC() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validatePlanYearDrpDownAEP();
	}

	@Then("^plan year dropdown should not be displayed during Non AEP in UHC$")
	public void plan_year_dropdown_should_not_be_displayed_during_NonAEP_period_UHC() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validatePlanYearDrpDownNonAEP();
	}

	@Then("^user should be navigated to UHC, zipcode and plan year capture page for Non AEP$")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page_for_Non_AEP() {
		/*ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();*/
		ZipCodePlanYearCapturePage zipCodePlanYearPage = new ZipCodePlanYearCapturePage(driver);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@Then("^user should be navigated to zipcode and plan year capture page for AEP on UHC$")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page_for_AEP_UHC() {
		// ZipCodePlanYearCapturePage zipCodePlanYearPage=(ZipCodePlanYearCapturePage)
		// getLoginScenario().getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		// zipCodePlanYearPage.validateZipCodePlanYearCapturePageAEP();
		ZipCodePlanYearCapturePage zipCodePlanYearPage = new ZipCodePlanYearCapturePage(driver);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@Then("^user enter invalid zipcode on UHC$")
	public void user_enter_invalid_zipcode_UHC(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String invalidzipcode = memberAttributesMap.get("inValidzipCode");
		System.out.println("zipcode" + invalidzipcode);
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.enterZipCode(invalidzipcode);
	}

	@Then("^user enters valid zipcode and county on UHC$")
	public void user_enter_valid_zipcode_UHC(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = memberAttributesMap.get("ZipCode");
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.enterZipCodeandcounty(zipcode);
	}

	@When("^user selects plan year on UHC$")
	public void user_selects_plan_year_UHC() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.selectPlanYear();
	}

	@When("^user clicks on continue button on UHC$")
	public void user_clicks_on_continue_button_UHC() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.clickContinueBtn();
	}

	@Then("^user should be navigated to Review drug cost estimate page on UHC$")
	public void user_should_be_navigated_to_Review_drug_cost_estimate_page_UHC() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.verifyReviewDrugCostPageDisplayed();
	}
	
	
	@When("^user should be able to see Medicare Advantage plan by default on UHC$")
	public void user_should_be_able_to_see_Medicare_Advantage_plan_by_default_UHC() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.verifyDefaultPlanType();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user clicks view drug cost button in UHC$")
	public void user_clicks_view_drug_cost_button_in_UHC() throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickViewDrugCostBtn();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	
    @When("^user should verify the Extra help in UHC$")
	public void user_should_verify_the_Extra_help_in_UHC() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickOnSNPPlan();
		drugSummaryPage.verifyTheTextAlert();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user should verify the drug extra qualification in drug pricing popup in UHC$")
	public void user_should_verify_the_drug_extra_qualification_in_drug_pricing_popup_in_UHC() {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.verifyDrugPricingText();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	@When("^user clicks on change pharmacy link from details page in UHC$")
	public void user_clicks_on_change_pharmacy_link_from_details_page_in_UHC() throws InterruptedException {
		DrugDetailsPage drugDetailsPage = new DrugDetailsPage(driver);
		drugDetailsPage.clickChangePharmacyLinkDetailsPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	@Then("^details page change pharmacy modal should be displayed in UHC$")
	public void details_page_change_pharmacy_modal_should_be_displayed_in_UHC() throws InterruptedException {
		DrugDetailsPage drugDetailsPage = new DrugDetailsPage(driver);
		drugDetailsPage.selectPharmacyModalDisplayed();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	@Then("^user verify details page change pharmacy modal in UHC$")
	public void user_verify_details_page_change_pharmacy_modal_in_UHC() throws InterruptedException {
		DrugDetailsPage drugDetailsPage = new DrugDetailsPage(driver);
		drugDetailsPage.validateSelectPharmacyPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}
	
	@When("^user click on View Drug Pricing Modal in UHC$")
	public void User_click_on_View_Drug_Pricing_Modal_in_UHC() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickViewPricing();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user click on Switch To Generic in UHC$")
	public void User_click_on_Switch_To_Generic_in_UHC() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickswitchToGeneric();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user verify drug can switch to generic drug in UHC$")
	public void user_verify_drug_can_switch_to_generic_drug_UHC(DataTable givenAttributes) throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String drugName = memberAttributesMap.get("DrugName");
		System.out.println(drugName);
		
		drugSummaryPage.verifyDrugListsUpdated(drugName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, drugSummaryPage);
	}

	@Then("^user saves plan as favorite on drug summary UHC site$")
	public void user_saves_plan_as_favorite_on_drug_summary_UHC_site(DataTable givenAttributes) throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
		/*VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		plansummaryPage.savePlan(PlanName);*/
	}
	
	@Then("^user save PDP plan as favorite on drug summary page UHC site$")
	public void user_saves_pdp_plan_as_favorite_on_drug_summary_UHC_site(DataTable givenAttributes) throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.clickOnPDPPlan();
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@Then("^user save SNP plan as favorite on drug summary page UHC site$")
	public void user_saves_snp_plan_as_favorite_on_drug_summary_UHC_site(DataTable givenAttributes) throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.clickOnSNPPlan();
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user should be able to toggle between plan types on UHC$")
	public void user_should_be_able_to_toggle_between_plan_types_UHC() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.verifyPDPPlanToggle();
		drugSummaryPage.verifySNPPlanToggle();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user verify the drug summary page on UHC$")
	public void user_verify_the_drug_summary_page_uhc() throws InterruptedException {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateDrugSummaryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^error message should be displayed on UHC$")
	public void error_message_should_be_displayed_UHC() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validateZipCodeErrorMessage();
	}

	@When("^clicks on Review drug cost button on UHC$")
	public void clicks_on_Review_drug_cost_button_UHC() {
		BuildYourDrugList buildDrugList = (BuildYourDrugList) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		buildDrugList.clickReviewDrugCostBtn();
	}

	@Then("^user should be navigated to zipcode and plan year capture page for AEP on UHC")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page_for_AEP_in_UHC() {
		/*
		 * ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage)
		 * getLoginScenario()
		 * .getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		 * zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		 */

		ZipCodePlanYearCapturePage zipCodePlanYearPage = new ZipCodePlanYearCapturePage(driver);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@Then("^load screen should be displayed on UHC$")
	public void load_screen_should_be_displayed_on_uhc() {
		ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		// zipCodePlanYearPage.verifyLoadScreen();
	}
	
	@When("^user clicks on change pharmacy link from summary page in UHC$")
	public void user_clicks_on_change_pharmacy_link_from_summary_page_in_UHC() throws InterruptedException  {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickChangePharmacy();
	}

	@Then("^change pharmacy modal should be displayed in UHC$")
	public void change_pharmacy_modal_should_be_displayed_in_UHC() throws InterruptedException  {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.selectPharmacyModalDisplayed();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user verify change pharmacy modal in UHC$")
	public void user_verify_change_pharmacy_modal_in_UHC() throws InterruptedException  {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.validateSelectPharmacyPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
}