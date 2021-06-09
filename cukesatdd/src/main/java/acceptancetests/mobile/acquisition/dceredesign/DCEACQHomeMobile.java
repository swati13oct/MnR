package acceptancetests.mobile.acquisition.dceredesign;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
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
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.ProviderSearchPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.dceredesign.TellUsAboutDrug;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.ComparePlansPageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.ProviderSearchPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;
//import pages.mobile.acquisition.ulayer.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.TellUsAboutDrugMobile;
import pages.mobile.acquisition.dceredesign.ZipCodeAndPlanYearCapturePageMobile;

/**
 * Functionality:DCE Acquisition
 */
public class DCEACQHomeMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;

	/**
	 * @toDo:user is on medicare acquisition site landing page
	 */

	@Given("^the user is on medicare acquisition site landing page$")
	public void the_user_on__medicaresolutions_Site(DataTable givenAttributes) {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		// aquisitionhomepage.openPRE();

		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@Then("^the user clicks on Edit button on Drug List page on DCE$")
	public void the_user_clicks_on_EditButton(DataTable Attributes) throws Throwable {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		/*
		 * List<DataTableRow> plannameAttributesRow = Attributes.getGherkinRows(); for
		 * (int i = 0; i < plannameAttributesRow.size(); i++) {
		 * 
		 * plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
		 * plannameAttributesRow.get(i).getCells().get(1)); }
		 */
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Attributes);
		String drug = plannameAttributesMap.get("DrugName");
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);

		TellUsAboutDrugMobile tellUsAboutDrugPage = DCEbuildDrugList.clickOnEditButton(drug);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_TellUsAboutDrug, tellUsAboutDrugPage);

	}

	@Then("^the user verifies the added pharmacy on prescription drug tab$")
	public void the_user_verifies_pharmacy_on_prescription_drug_tab() throws Throwable {
		PlanDetailsPageMobile planDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String pharmacyName = (String) getLoginScenario().getBean(PageConstants.PHARMACY_NAME);
		planDetailsPage.verifyPharmacyAdded(pharmacyName);

	}

	@Then("^the user validates correct Copay section view and LIS message for LIS Buydown Plan on DCE details Page$")
	public void the_user_validates_correct_Copay_section_view_and_LIS_message_for_LIS_Buydown_Plan_on_DCE_details_Page()
			throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateLISBuyDown_CopaySection_LISAlert();
	}

	@Then("^the user verifies the drug information on prescription drug tab$")
	public void the_user_verifies_drug_info_Prescription_Drug(DataTable Attributes) throws Throwable {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Attributes);
		/*
		 * List<DataTableRow> plannameAttributesRow = Attributes.getGherkinRows(); for
		 * (int i = 0; i < plannameAttributesRow.size(); i++) {
		 * 
		 * plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
		 * plannameAttributesRow.get(i).getCells().get(1)); }
		 */
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String annualDrugCost = (String) getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		String drugName = plannameAttributesMap.get("DrugName");
		vppPlanDetailsPage.validateDrugInfoOnPrescriptionDrugTab(drugName, annualDrugCost);
	}

	@Then("^the user validates default view for Plan Effective Date$")
	public void the_user_validates_default_view_for_Plan_Effective_Date() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDefaultPED();
	}

	@Then("^the user validates Reset effective date$")
	public void the_user_validates_Reset_effective_date() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateResetEffectiveDate();
	}

	@Then("^the user validate no bar is displayed for November and December$")
	public void the_user_validate_no_bar_is_displayed_for_November_and_December() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateNoBarChartDisplayforNovDec();

	}

	@Then("^the user validates Change effective date modal and display after changing effective date$")
	public void the_user_validates_Change_effective_date_modal_and_display_after_changing_effective_date()
			throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String envMonth = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_SYSTEM_MONTH);
		drugDetailsPage.validateChangePEDandModalandChangeDisplay();
	}

	@Then("^the user validates Change effective date Dropdown$")
	public void the_user_validates_Change_effective_date_Dropdown() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String testSiteUrl = (String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		String currentEnvTime = drugDetailsPage.getAcqTestEnvSysTime(testSiteUrl);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_TIME, currentEnvTime);
		String[] tmpDateAndTime = currentEnvTime.split(" ");
		String[] tmpDate = tmpDateAndTime[0].split("/");
		String envMonth = tmpDate[0];
		System.out.println("TEST - sysTimeMonth = " + envMonth);
		String envTimeYear = tmpDate[tmpDate.length - 1];
		System.out.println("TEST - sysTimeYear = " + envTimeYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR, envTimeYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_MONTH, envMonth);
		drugDetailsPage.validateChangePEDDropDwn(envMonth, envTimeYear);

	}

	@Then("^the user compares drug costs for drug details and drug summary pages$")
	public void the_user_compares_drug_costs_for_drug_details_and_drug_summary() throws Throwable {
		String drugSummaryAvgMonthly = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.AVG_MONTHLY_DRUG_SUMMARY);
		String drugSummaryMonthlyPremium = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.MONTHLY_PREMIUM_DRUG_SUMMARY);
		String drugSummaryAnnualEstimated = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL_DRUG_SUMMARY);
		String drugSummaryDrugCount = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.COVERED_DRUGS_COUNT_DRUG_SUMMARY);
		String drugDetailsAvgMonthly = (String) getLoginScenario().getBean(DCERedesignCommonConstants.AVG_MONTHLY);
		String drugDetailsMonthlyPremium = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.MONTHLY_PREMIUM);
		String drugDetailsAnnualEstimated = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		String drugDetailsDrugCount = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.COVERED_DRUGS_COUNT);

		if (drugSummaryAvgMonthly.equals(drugDetailsAvgMonthly)
				&& drugSummaryMonthlyPremium.equals(drugDetailsMonthlyPremium)
				&& drugSummaryAnnualEstimated.equals(drugDetailsAnnualEstimated)
				&& drugDetailsDrugCount.equals(drugSummaryDrugCount))
			System.out.println("Drug costs mathced");
		else
			Assertion.fail("Drug costs between drug details and drug summary didn't match");

	}

	@Then("^the user Captures Drug costs on Drug Summary Page for the given plan$")
	public void the_user_Captures_Drug_costs_on_Drug_Summary_Page_For_Given_Plan(DataTable attributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		Map<String, String> DrugCosts = drugSummaryPage.captureDrugCosts(planName);
		String AVG_MONTHLY = DrugCosts.get("AVG_MONTHLY");
		String MONTHLY_PREMIUM = DrugCosts.get("MONTHLY_PREMIUM");
		String ANNUAL_ESTIMATED_TOTAL = DrugCosts.get("ANNUAL_ESTIMATED_TOTAL");
		String COVERED_DRUGS_COUNT = DrugCosts.get("COVERED_DRUGS_COUNT");
		System.out.println(DrugCosts);
		getLoginScenario().saveBean(DCERedesignCommonConstants.AVG_MONTHLY_DRUG_SUMMARY, AVG_MONTHLY);
		getLoginScenario().saveBean(DCERedesignCommonConstants.MONTHLY_PREMIUM_DRUG_SUMMARY, MONTHLY_PREMIUM);
		getLoginScenario().saveBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL_DRUG_SUMMARY,
				ANNUAL_ESTIMATED_TOTAL);
		getLoginScenario().saveBean(DCERedesignCommonConstants.COVERED_DRUGS_COUNT_DRUG_SUMMARY, COVERED_DRUGS_COUNT);

	}

	@Then("^the user changes the supply length$")
	public void the_user_changesSupplyLength(DataTable Attributes) throws Throwable {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		/*
		 * List<DataTableRow> plannameAttributesRow = Attributes.getGherkinRows(); for
		 * (int i = 0; i < plannameAttributesRow.size(); i++) {
		 * 
		 * plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
		 * plannameAttributesRow.get(i).getCells().get(1)); }
		 */
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Attributes);
		String supplyLength = plannameAttributesMap.get("Supply Length");
		TellUsAboutDrugMobile tellUsAboutDrugPage = (TellUsAboutDrugMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_TellUsAboutDrug);
		tellUsAboutDrugPage.selectSupplyLength(supplyLength);
		BuildYourDrugListMobile DCEbuildDrugList = tellUsAboutDrugPage.ClickAddDrug();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}

	@Then("^the user selects the following drug recommendation and validates Drug Search page is displayed and add drug$")
	public void the_user_selects_the_following_drug_recommendation_and_validates_Drug_Search_page_is_displayed_and_add_drug(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String drugName = memberAttributesMap.get("SelectDrugRecommendation");
		System.out.println(drugName);
		BuildYourDrugListMobile buildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);

		boolean drugRecommendationDisplayed;
		drugRecommendationDisplayed = buildDrugList.ClickAddDrugRecommended(drugName);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		System.out.println("Drugs List : " + druglist);
		if (drugRecommendationDisplayed) {
			String DrugName = wd.findElement(By.xpath("//h4[contains(text(), '" + drugName + "')]")).getText();
			// if (druglist.isEmpty()) {
			if (StringUtils.isEmpty(druglist)) {
				System.out.println("Added Drug : " + DrugName + ", for Drug recommendation : " + drugName);
				druglist = DrugName;
			} else {
				druglist = druglist + "&" + DrugName;
			}
			System.out.println("Drugs List after Drug " + DrugName + " , Added : " + druglist);
		} else {
			System.out.println("Drug Recommendation is not displayed : Drug is not added");
		}
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}

	@Then("^the user clicks on Review Drug Costs button to Land on Drug Summary Page$")
	public void the_user_click_Review_Drug_Costs_button_to_Land_on_Drug_Summary_Page() throws Throwable {
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugSummaryPageMobile drugSummaryPage = DCEbuildDrugList.navigateToDrugSummay();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user should be able to see Back to profile button on details page$")
	public void user_should_able_to_see_Back_to_profile_button_on_details_page() {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.verifyBackToProfileBtnDisplayed();
	}

	@And("^the user clicks on DCE button to return to Review Drug cost page$")
	public void the_user_clicks_on_DCE_return_Review_Drug_cost_page() throws Throwable {
		PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		DrugDetailsPageMobile drugDetailsPage = plandetailspage.returnToReviewDrugCost();

	}

	@Then("^user validates planName matches plan Name in Drug Details pages$")
	public void the_user_validates_matches_planname_in_Drug_Details() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanDrugDetails(PlanName);
	}

	@Then("^user navigates to Review drug costs page$")
	public void user_navigates_to_Review_drug_costs_page() {
		BuildYourDrugListMobile buildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugSummaryPageMobile drugSummaryPage = buildDrugList.verifyReviewDrugCostPage();
		if (null != drugSummaryPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@When("^the user clicks on NBA to navigate to DCE Redesign page$")
	public void the_user_clicks_on_NBA_to_navigate_to_DCE_Redesign_page(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String planType = memberAttributesMap.get("Plan Type");
		String planName = memberAttributesMap.get("Plan Name");

		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		GetStartedPageMobile getStartedPage = planSummaryPage.navigateToDCEFromNBA(planType, planName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
	}

	@Then("^user verify details page change pharmacy modal$")
	public void user_verify_details_page_change_pharmacy_modal_in_AARP() throws InterruptedException {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateSelectPharmacyPage();
		drugDetailsPage.clickDistanceMiledropdown();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@When("^I access the acquisition DCE Redesign from home page$")
	public void I_access_the_DCE_redesign_home_page() throws InterruptedException {

		AcquisitionHomePageMobile acquisitionHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		GetStartedPageMobile getStartedPage = acquisitionHomePage.navigateToDCERedesignFromHome();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^the user validates GetStarted Page$")
	public void the_user_validates_Get_Started_Page() throws Throwable {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		GetStartedPageMobile DCEgetStarted = new GetStartedPageMobile(wd);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, DCEgetStarted);

	}

	@Then("^the user clicks on Build Drug List to navigate to Build Drug List Page$")
	public void the_user_clicks_on_Build_Drug_List_to_navigate_to_Build_DrugList() throws Throwable {
		GetStartedPageMobile DCEgetStarted = (GetStartedPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
		BuildYourDrugListMobile DCEbuildDrugList = DCEgetStarted.clickAddsDrugs();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		// druglist = "";
		System.out.println("Setting Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}

	@Then("^end user searches and adds the following Drug to Drug List$")
	public void the_user_searches_and_adds_the_following_Drug_to_Drug_List(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
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

	@Then("^the user validates all added drugs in DrugList$")
	public void the_user_validates_all_added_drugs_in_DrugList() throws Throwable {
		BuildYourDrugListMobile buildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		buildDrugList.ValidateAddedDrugsList(druglist);
	}

	@Then("^the user clicks on Review Drug Costs to Land on Zip Entry Page$")
	public void the_user_clicks_on_Review_Drug_Costs_to_Land_on_Zip_Entry_Page() throws Throwable {
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = DCEbuildDrugList.navigateToZipEntryPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@When("^user enters valid zip and county$")
	public void user_enter_valid_zipcode_and_county_in_AARP(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String zipcode = memberAttributesMap.get("ZipCode");
		String county = memberAttributesMap.get("county");
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.enterZipCodeandcounty(zipcode);
	}

	@And("^user clicks on continue button in Zip Entry Page$")
	public void user_clicks_on_continue_button_ZipENtryPage_in_AARP() {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		DrugSummaryPageMobile drugSummaryPage = zipCodePlanYearPage.clickContinueBtn();
		// zipCodePlanYearPage.verifyLoadScreen();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, drugSummaryPage);
	}

	@Then("^the user selects View Drug details for following plantype and PlanName$")
	public void the_user_selects_View_Drug_details_for_following_plantype_and_PlanName(DataTable attributes)
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
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		DrugDetailsPageMobile drugDetailsPage = drugSummaryPage.clickViewDrugDetailsForPlan(plantype, planName);
		getLoginScenario().saveBean(DCERedesignCommonConstants.PLANTYPE, plantype);
		getLoginScenario().saveBean(DCERedesignCommonConstants.PLANNAME, planName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates planName matches plan Name in VPP$")
	public void the_user_validates_planName_matches_plan_Name_in_VPP() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		String PlanName = (String) getLoginScenario().getBean(DCERedesignCommonConstants.PLANNAME);
		drugDetailsPage.validatePlanName(PlanName);
		getLoginScenario().saveBean(DCERedesignCommonConstants.PLANNAME, PlanName);
	}

	@Then("^the user validates Drug Costs section$")
	public void the_user_validates_Drug_Costs_section() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDrugCosts();
	}

	@Then("^the user validates Your Drugs sections$")
	public void the_user_validates_Your_Drugs_sections() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateYourDrugs();
	}

	@Then("^the user validates Monthly Drug Costs by Stage Section$")
	public void the_user_validates_Monthly_Drug_Costs_by_Stage_Section() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateMonthlyCostStage();
	}

	@Then("^the user validates Important information section$")
	public void the_user_validates_Important_information_section() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateImportantInfo();
	}

	@Then("^the user validates Monthly Drug Costs by Stage Info Modals$")
	public void the_user_validates_Monthly_Drug_Costs_by_Stage_Info_Modals() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDrugStageInfoModals();
	}

	@Then("^the user validates link to Drug Summary Page$")
	public void the_user_validates_link_to_Drug_Summary_Page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		DrugSummaryPageMobile drugSummaryPage = drugDetailsPage.ClickLinktoNavigatetoDrugSummary();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);

	}

	@Then("^the user validates Drug Recommendation section$")
	public void the_user_validates_Drug_Recommendation_section() throws Throwable {
		BuildYourDrugListMobile buildYourDrugsListPage = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		buildYourDrugsListPage.validateDrugRecommendationSection(druglist);
	}

	@Then("^the user enters following information in Request Plan Information Guide$")
	public void the_user_enters_following__information_in_Request_Plan_Information_Guide(DataTable givenAttributes)
			throws Throwable {
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
		String EmailAddress = memberAttributesMap.get("Email");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.RequestPlanIInformation(FirstName, LastName, EmailAddress);

	}

	/**
	 * @toDo: user Enters a zipcode
	 */
	@When("^the user enters the zipcode and counts the plan$")
	public void user_enters_the_zipcode_and_counts_plans(DataTable givenAttributes) {

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
		String plancount = memberAttributesMap.get("Plancount");
		String planYear = memberAttributesMap.get("Year");

		ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
				.getBean(PageConstants.PROVIDER_SEARCH_PAGE);

		int intPlanCounts = providerSearchPage.entersZipcodeAndPlancount(zipcode, planYear);
		int strplancount = Integer.parseInt(plancount);
		System.out.println("expected==" + strplancount + "===actual==" + intPlanCounts);
		if (intPlanCounts != strplancount) {
			Assertion.fail("Plan count is not matching");
		}

	}

	@When("^user saves below plan$")
	public void user_saves_below_plan(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String savePlanNames = memberAttributesMap.get("Plan Name");
		String planType = memberAttributesMap.get("Plan Type");
		plansummaryPage.savePlans(savePlanNames, planType);
	}

	@Then("^the user verify the Retail chain pharmacy on detail page$")
	public void the_user_verify_the_Retail_chain_pharmacy_on_detail_page() throws Throwable {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugDetailsPageMobile drugDetailPage = new DrugDetailsPageMobile(wd);
		drugDetailPage.validateRetailChainPharmacy();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailPage);
	}

	@Then("^the user clicks on Back to Compare link and validates Plan Compare page, Drug Info Modal$")
	public void the_user_clicks_on_Back_to_Compare_link_and_validates_Plan_Compare_page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		ComparePlansPageMobile planComparePage = drugDetailsPage
				.clickViewBackCompareLink_ReturnToCompare_ViewDrugModal();
		if (null != planComparePage) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else
			Assertion.fail("VPP Plan Compare not loaded");
	}

	@Then("^the user clicks on View Drug Information link for the following Plan and lands on DCE details$")
	public void the_user_clicks_on_View_Drug_Information_link_for_the_following_Plan_and_lands_on_DCE_details(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*
		 * List<DataTableRow> memberAttributesRow = arg1.getGherkinRows(); for (int i =
		 * 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String planName = memberAttributesMap.get("PlanName");
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		planComparePage.clickViewDrugInfoLinkForPlan(planName);
		String drugYouPaylist = planComparePage.validateDrugListCaptureDrugYouPay(druglist);
		DrugDetailsPageMobile drugDetailsPage = planComparePage.clickDrugCostDetails_DrugInfoModal();
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);

		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS, drugYouPaylist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@When("^user clicks on Keep Using This Pharmacy on change pharmacy page")
	public void user_clicks_on_keep_using_pharmacy() throws InterruptedException {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateAndClickKeepPharm();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates all added Drugs on Plan Compare$")
	public void the_user_validates_all_added_Drugs_on_Plan_Compare() throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		planComparePage.ValidatesAddedDrugsList(druglist);
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

	}

	@And("^the user navigates to Visitor profile page$")
	public void the_user_navigates_to_visitor_profile_page() {
		AcquisitionHomePageMobile acqHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VisitorProfilePageMobile visitorProfilePage = acqHomePage.navigateToNewVisitorProfilePage();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@Then("^the user verify and edit the Pharmacy from vpp detail page$")
	public void the_user_verify_and_edit_the_Pharmacy_from_vpp_detail_page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.vppdetails_clickEditPharmacy();
	}

	@Then("^verify DCE NBA is displayed on drug details page$")
	public void verify_dce_NBA_is_displayed_on_drug_details_page() {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDCENBAModal();
	}

	@Then("^User validates planName matches plan Name in DCE detail page in AARP$")
	public void the_user_validates_matches_planname() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanDrugDetails(PlanName);
	}

	@When("^user validate \"([^\"]*)\" pharmacy on detail page")
	public void user_validate_pharmacy_on_detail_page(String pharmacyName) throws InterruptedException {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDefaultPharmacyName(pharmacyName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user verify the drug cost estimator and view plan summary on VPP detail page in AARP$")
	public void the_user_verify_the_drug_cost_estimator() throws Throwable {
		Thread.sleep(10000);
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.validateDrugandPanButton();
	}

	@Then("^the user click on drug cost estimator on vpp plan detail page in AARP$")
	public void the_user_click_on_drug_cost_estimator() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.clickOnBacktoDrugBtn();
	}

}