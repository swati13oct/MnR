package acceptancetests.mobile.acquisition.dceredesign;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;
import pages.mobile.acquisition.dceredesign.TellUsAboutDrugMobile;
import pages.mobile.acquisition.dceredesign.ZipCodeAndPlanYearCapturePageMobile;
//import pages.mobile.acquisition.ulayer.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;

/**
 * Functionality:DCE Acquisition
 */
public class DCEACQDrugSummaryMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

//	AppiumDriver wd;

	/**
	 * @toDo:user is on medicare acquisition site landing page
	 */

	@Given("^the user navigates to following AARP medicare acquisition site page$")
	public void the_user_navigates_to_following_AARP_medicare_acquisition_site_page(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : " + path);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPath(path);
	}

	@When("^I access the acquisition DCE tool from home page$")
	public void I_access_the_DCE_tool_home_page() throws InterruptedException {

		AcquisitionHomePageMobile acquisitionHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DrugCostEstimatorPageMobile dcePage = (DrugCostEstimatorPageMobile) acquisitionHomePage
				.navigateToDCEToolFromHome();
		if (null != dcePage) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dcePage);
		} else
			Assertion.fail("DCE page object not loaded");
	}

	/**
	 * @toDo:user is on AARP medicare acquisition site landing page
	 */
	@Given("^the user is on the AARP medicare site landing page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		// aquisitionhomepage.openPRE();

		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^the user navigates to following medicare acquisition site page$")
	public void the_user_navigates_to_following_AARP_medicare_acquisition_page(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : " + path);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPath(path);
	}

	@When("^user verify the drug summary page$")
	public void user_verify_the_drug_summary_page() throws InterruptedException {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateDrugSummaryPage();
	}

	@Then("^the user validates Get Started Page for UHC$")
	public void the_user_validates_Get_Started_Page_UHC() throws Throwable {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		GetStartedPageMobile DCEgetStarted = new GetStartedPageMobile(wd);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEgetStarted);

	}

	@When("^the user clicks on Add drugs button on UHC$")
	public void the_user_clicks_on_Add_drugs_button_UHC() {
		GetStartedPageMobile DCEgetStarted = (GetStartedPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEgetStarted.clickAddDrugsBtn();
		// getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture,
		// zipCodePlanYearPage);
	}

	@When("^adds drugs in drug list page on UHC$")
	public void adds_drugs_in_drug_list_page_UHC(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String drugName = memberAttributesMap.get("DrugName");
		System.out.println("zipcode" + drugName);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		BuildYourDrugListMobile buildDrugList = new BuildYourDrugListMobile(wd);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
		buildDrugList.addDrugs(drugName);
	}

	@When("^clicks on Review drug cost button on UHC$")
	public void clicks_on_Review_drug_cost_button_UHC() {
		BuildYourDrugListMobile buildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = buildDrugList.navigateToZipEntryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@Then("^user should be navigated to UHC, zipcode and plan year capture page for Non AEP$")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page_for_Non_AEP() {
		/*
		 * ZipCodePlanYearCapturePage zipCodePlanYearPage = (ZipCodePlanYearCapturePage)
		 * getLoginScenario()
		 * .getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		 * zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		 */
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = new ZipCodeAndPlanYearCapturePageMobile(wd);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@When("^user enters valid zipcode and county on UHC$")
	public void user_enter_valid_zipcode_UHC(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String zipcode = memberAttributesMap.get("ZipCode");
		String county = memberAttributesMap.get("county");
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.enterZipCodeandcounty(zipcode);
	}

	@When("^user clicks on continue button on UHC$")
	public void user_clicks_on_continue_button_UHC() {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.clickContinueBtn();
	}

	@Then("^load screen should be displayed on UHC$")
	public void load_screen_should_be_displayed_on_uhc() {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		// zipCodePlanYearPage.verifyLoadScreen();
	}

	@Then("^user should be navigated to Review drug cost estimate page on UHC$")
	public void user_should_be_navigated_to_Review_drug_cost_estimate_page_UHC() {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.verifyReviewDrugCostPageDisplayed();
	}

	@Then("^user verify the drug summary page on UHC$")
	public void user_verify_the_drug_summary_page_uhc() throws InterruptedException {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		drugSummaryPage.validateDrugSummaryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user should be able to see Medicare Advantage plan by default$")
	public void user_should_be_able_to_see_Medicare_Advantage_plan_by_default() throws Throwable {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		drugSummaryPage.verifyDefaultPlanType();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^verify DCE NBA is displayed on drug summary page$")
	public void verify_dce_NBA_is_displayed_on_summary_page() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);

		drugSummaryPage.validateDCENBAModal();
	}
	
	@When("^user clicks on change pharmacy link from summary page$")
	public void user_clicks_on_change_pharmacy_link_from_summary_page_in_AARP() throws InterruptedException {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.clickChangePharmacy();
	}
	
	@Then("^change pharmacy modal should be displayed$")
	public void change_pharmacy_modal_should_be_displayed_in_AARP() throws InterruptedException {
		DrugSummaryPageMobile drugSummaryPage =  (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.selectPharmacyModalDisplayed();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user verify change pharmacy modal$")
	public void user_verify_change_pharmacy_modal_in_AARP() throws InterruptedException {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateSelectPharmacyPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
		
	}
	@Then("^user verify the default distance on change pharmacy modal$")
	public void user_verify_the_default_distance_on_change_pharmacy_modal() {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateDefaultDistance();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	@Then("^the message \"([^\"]*)\" should be displayed on change pharmacy modal$")
	public void the_message_should_be_displayed_on_change_pharmacy_modal(String mailOrderPharmacyMessage) {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validatePreferredMailOrderPharmacyMessage(mailOrderPharmacyMessage);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user sort the pharmacy list by \"([^\"]*)\"$")
	public void user_sort_the_pharmacy_list_by(String sortOption) {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.sortPharmacies(sortOption);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@Then("^pharmacy list should be displayed in ascending order$")
	public void pharmacy_list_should_be_displayed_in_ascending_order() {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validatePharmaciesAscendingOrder();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^pharmacy list should be displayed in descending order$")
	public void pharmacy_list_should_be_displayed_in_descending_order() {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validatePharmaciesDescendingOrder();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	@When("^user selects Preferred mail order pharmacy$")
	public void user_selects_Preferred_mail_order_pharmacy() {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.selectPreferredMailOrderPharmacy();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	@When("^user clicks on next button on change pharmacy modal$")
	public void user_clicks_on_next_button_on_change_pharmacy_modal() {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.clickNextButton();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user should be navigated to second page of pharmacy list$")
	public void user_should_be_navigated_to_second_page_of_pharmacy_list() {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateSecondPageDisplayed();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@Then("^user should be navigated to first page of pharmacy list$")
	public void user_should_be_navigated_to_first_page_of_pharmacy_list() {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateFirstPageDisplayed();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}
	
	@When("^user search with zipcode with no pharamacies$")
	public void user_search_with_zipcode_with_no_pharamacies(DataTable attributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String zipCode = memberAttributesMap.get("ZipCode");
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.searchPharmaciesByZipcode(zipCode);
	}
	
	@Then("^no results message should be displayed$")
	public void no_results_message_should_be_displayed(DataTable attributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String message = memberAttributesMap.get("NoResultsMessage");
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateNoResultsMsg(message);
	}

	@When("^user search with incorrect zipcode$")
	public void user_search_with_incorrect_zipcode(DataTable attributes) {
		List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String zipCode = memberAttributesMap.get("ZipCode");
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.searchPharmaciesByZipcode(zipCode);
	}

	@Then("^error message \"([^\"]*)\" should be displayed on change pharmacy modal$")
	public void error_message_should_be_displayed_on_change_pharmacy_modal(String errorMessage) {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateInvalidZipCodeMsg(errorMessage);
	}



	@When("^user clicks on back button on change pharmacy modal$")
	public void user_clicks_on_back_button_on_change_pharmacy_modal() {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile)getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.clickBackButton();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}



}