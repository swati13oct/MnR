package acceptancetests.mobile.acquisition.dceredesign;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
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
import pages.acquisition.dceredesign.SwitchToGeneric;
import pages.acquisition.dceredesign.TellUsAboutDrug;
import pages.acquisition.ole.CancelOLEModal;
import pages.acquisition.ole.WelcomePage;
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
import pages.mobile.acquisition.dceredesign.SwitchToGenericMobile;
import pages.mobile.acquisition.dceredesign.TellUsAboutDrugMobile;
import pages.mobile.acquisition.dceredesign.ZipCodeAndPlanYearCapturePageMobile;
import pages.mobile.acquisition.ole.CancelOLEModalMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;

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
		/*AppiumDriver wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		// aquisitionhomepage.openPRE();

		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);*/
		
		
		
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String site = memberAttributesMap.get("Site");
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd, site);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		aquisitionhomepage.fixPrivateConnectionMobile();
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);

		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, null);
		getLoginScenario().saveBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS, null);
		if ("BLayer".equalsIgnoreCase(site) || site.equalsIgnoreCase("UHC") || site.equalsIgnoreCase("UMS"))
			getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, "UHC_ACQ");
		else
			getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, "AARP_ACQ");

		if (site.equalsIgnoreCase("AARP") || !MRScenario.environment.equalsIgnoreCase("team-acme"))
			aquisitionhomepage.validateSubtitle();
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
		String testSiteUrl = (String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		String currentEnvTime = drugDetailsPage.getAcqTestEnvSysTime(testSiteUrl);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_TIME, currentEnvTime);
		String[] tmpDateAndTime = currentEnvTime.split(" ");
		String[] tmpDate = tmpDateAndTime[0].split("/");
		String envMonth = tmpDate[0];
		System.out.println("TEST - sysTimeMonth = " + envMonth);
		String envTimeYear = tmpDate[tmpDate.length - 1];
		System.out.println("TEST - sysTimeYear = " + envTimeYear);
		drugDetailsPage.validateDefaultPED(envTimeYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR, envTimeYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_MONTH, envMonth);
	}

	@Then("^the user validates Reset effective date$")
	public void the_user_validates_Reset_effective_date() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String envTimeYear = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR);
		drugDetailsPage.validateResetEffectiveDate(envTimeYear);
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

		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

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

	@Then("^user verifies Drug List on DCE Summary Page - Drug Pricing Modal$")
	public void the_user_validates_druglist_Drugs_DrugSummaryPage() throws Throwable {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		drugSummaryPage.ValidatesDrugsList(druglist);

	}

	@When("^user saves and updates pharmacy from list$")
	public void user_saves_and_updates_pharmacy_from_list() {
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		drugSummaryPage.saveAndUpdatePharmacy();
	}

	@Then("^user clears the existing drugs in Visitor profile$")
	public void user_clears_the_existing_drugs_in_visitor_profile() {
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.clearDrugs();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfile);
	}

	@Then("^user clears the provider in visitor profile page$")
	public void user_clears_the_provider_in_visitor_profile_page() {
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.clearProvider();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfile);
	}

	@When("^user updates the distance to \"([^\"]*)\" from drug details$")
	public void user_updates_the_distance_to_drug_details(String distance) throws InterruptedException {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.updateDistanceDrugDetails(distance);
	}

	@Then("^the user cancels enrollment and navigates to homepage$")
	public void the_user_cancels_enrollment() throws Throwable {
		WelcomePageMobile welcomePage = (WelcomePageMobile) getLoginScenario()
				.getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		CancelOLEModalMobile cancelOLEmodal = welcomePage.OpenCancelOLE();
		if (cancelOLEmodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE, cancelOLEmodal);
			System.out.println("OLE Cancellation Modal is Displayed");
			cancelOLEmodal.leaveApplication();
		} else
			Assertion.fail("OLE Cancellation Modal is NOT Displayed");
	}

	@Then("^the user clicks on site logo on drug detail Page and returns back to Acquisition Home Page$")
	public void user_clicks_site_logo_on_drugdetail_returns_Acquisition_home_page(DataTable attributes)
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
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String siteName = memberAttributesMap.get("Site");
		drugDetailsPage.clickingSiteLogoDrugDetail(siteName);

	}

	@Then("^the user clicks on Drug cost estimator link and validates Drug Details Page$")
	public void user_clicks_DCELink_and_validates_drugdetail_page() {
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateBackToDceLink();
		DrugDetailsPageMobile drugDetailsPage = visitorProfile.clickBackToDCELink();
		if (null != drugDetailsPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
		} else
			Assertion.fail("Drug Details page not loaded");
	}

	@Then("^the user validates the LIS Banner for the below LIS Buydown plan on Drug Summary Page$")
	public void the_user_validates_LISBanner_for_LISBuydown_Plan(DataTable Planname) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*
		 * List<DataTableRow> memberAttributesRow = Planname.getGherkinRows(); for (int
		 * i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateLISBanner_LISBuydownPlan_DrugSummary(planName);

	}

	@Then("^the user validates View Drug Pricing modal for the given plan$")
	public void user_validates_ViewDrugPricing_modal(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		String planName = memberAttributesMap.get("Plan Name");
		drugSummaryPage.viewDrugPricingModal(planName);
	}

	@Then("^the user validates functional tool tips for the given plan$")
	public void the_user_validates_functional_tool_tips_for_Given_plan(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for(int
		 * i=0 ; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0) ,
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String planName = memberAttributesMap.get("Plan Name");
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.captureFunctionalToolTips(planName);

	}

	@Then("^the user validates Non-LIS text for coverages stages popups on DCE details page$")
	public void the_user_validates_NonLIS_text_for_coverages_stages_popups_on_DCE_details_page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDrugStageInfoModals_NonLISbuydownPlans();
	}

	@Then("^the user validates correct Copay section view and LIS message for LIS Non Buydown Plan on DCE details Page$")
	public void the_user_validates_correct_Copay_section_view_and_LIS_message_for_LIS_NonBuydown_Plan_on_DCE_details_Page()
			throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateLISonly_CopaySection_LISAlert();
	}

	@When("^user should verify the drug extra qualification in drug pricing popup$")
	public void user_should_verify_the_drug_extra_qualification_in_drug_pricing_popup_in_AARP() {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.verifyDrugPricingText();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^the user applies pharmacy filter for following text on Standard pharmacies Tab, Details page - Change Pharmacy Page$")
	public void the_user_applies_pharmacy_filter_for_following_text_on_Standard_pharmacies_Tab_Details_page_Change_Pharmacy_Page(
			DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String FilterText = memberAttributesMap.get("PharmacyFilterText");
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateStandardTab();
		drugDetailsPage.ApplyPharmacyFilter(FilterText);
	}

	@Then("^the user applies pharmacy filter for following text on Preferred pharmacies Tab, Details page - Change Pharmacy Page$")
	public void the_user_applies_pharmacy_filter_for_following_text_on_Preferred_pharmacies_Tab_Details_page_Change_Pharmacy_Page(
			DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String FilterText = memberAttributesMap.get("PharmacyFilterText");
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validatePreferredTab();
		drugDetailsPage.ApplyPharmacyFilter(FilterText);
	}

	@Then("^the user validates Pharmacy Filter - Error message and x cancel function is working on Details page - Change Pharmacy Page$")
	public void the_user_validates_Pharmacy_Filter_Error_message_and_x_cancel_function_is_working_on_Details_page_Change_Pharmacy_Page()
			throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validatePharmacyFilterErrormessage();
		drugDetailsPage.validateXcleartextPharmacyFilter();
	}

	@Then("^the user applies pharmacy filter for following text on Summary page - Change Pharmacy Page$")
	public void the_user_applies_pharmacy_filter_for_following_text_on_Summary_page_Change_Pharmacy_Page(
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
		String FilterText = memberAttributesMap.get("PharmacyFilterText");
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.ApplyPharmacyFilter(FilterText);
	}

	/**
	 * Adding steps to validate filter on change Pharmacy page
	 * 
	 * @throws Throwable
	 */

	@Then("^the user validates Pharmacy Filter - Error message and x cancel function is working on Summary page - Change Pharmacy Page$")
	public void the_user_validates_Pharmacy_Filter_Error_message_and_x_cancel_function_is_working_on_Summary_page_Change_Pharmacy_Page()
			throws Throwable {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validatePharmacyFilterErrormessage();
		drugSummaryPage.validateXcleartextPharmacyFilter();
	}

	@Then("^the user validates PLan Toggle on Drug Summary Page$")
	public void the_user_validates_PLan_Toggle_on_Drug_Summary_Page() throws Throwable {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.verifyPDPPlanToggle();
		drugSummaryPage.verifySNPPlanToggle();
		drugSummaryPage.verifyMAPDPlanToggle();

	}

	@Then("^user save SNP plan as favorite on drug summary page AARP site$")
	public void user_saves_snp_plan_as_favorite_on_drug_summary_AARP_site(DataTable givenAttributes)
			throws InterruptedException {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * String PlanName = memberAttributesRow.get(0).getCells().get(1);
		 */
		List<List<String>> memberAttributesRow = givenAttributes.asLists();
		String PlanName = memberAttributesRow.get(0).get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.clickOnSNPPlan();
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user save PDP plan as favorite on drug summary page AARP site$")
	public void user_saves_pdp_plan_as_favorite_on_drug_summary_AARP_site(DataTable givenAttributes)
			throws InterruptedException {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * String PlanName = memberAttributesRow.get(0).getCells().get(1);
		 */
		List<List<String>> memberAttributesRow = givenAttributes.asLists();
		String PlanName = memberAttributesRow.get(0).get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.clickOnPDPPlan();
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user saves MAPD plan as favorite on drug summary page AARP site$")
	public void user_saves_plan_as_favorite_on_drug_summary_AARP_site(DataTable givenAttributes)
			throws InterruptedException {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * String PlanName = memberAttributesRow.get(0).getCells().get(1);
		 */
		List<List<String>> memberAttributesRow = givenAttributes.asLists();
		String PlanName = memberAttributesRow.get(0).get(1);
		System.out.println("Plan name" + PlanName);
		drugSummaryPage.clickOnMAPDPlan();
		drugSummaryPage.savePlan(PlanName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
		/*
		 * VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
		 * .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE); List<DataTableRow>
		 * memberAttributesRow = givenAttributes.getGherkinRows(); String PlanName =
		 * memberAttributesRow.get(0).getCells().get(1); System.out.println("Plan name"
		 * + PlanName); plansummaryPage.savePlan(PlanName);
		 */
	}

	@Then("^the user validates Estimated Drug Cost for the following plan to DCE details page estimated Drug Costs$")
	public void the_user_validates_estimated_drug_cost_for_plan_on_compare_page_to_DCEdetails_page_captured_estimated_drug_cost(
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
		String Expected_Estimated_Drug_Cost = (String) getLoginScenario()
				.getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		planComparePage.validateEstimatedDrugCostForPlan(planName, Expected_Estimated_Drug_Cost);

	}

	@Then("^user click on standard tab from drug details$")
	public void user_click_on_standard_tab_from_drug_details() {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateStandardTab();
	}

	@Then("^user verify details page change pharmacy modal for preferred tab$")
	public void user_verify_details_page_change_pharmacy_modal_for_preferred_tab() {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validatePreferredTab();
	}

	@When("^user clicks on Keep Using This Pharmacy link on change pharmacy modal$")
	public void user_click_on_keep_using_pharmacy_link_on_change_pharmacy_modal() throws InterruptedException {
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		drugSummaryPage.clickKeepUsingPharmacyLink();
	}

	@Then("^the pharmacy name should be updated on summary page$")
	public void the_pharmacy_name_should_be_updated_on_summary_page() {
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		drugSummaryPage.validateSelectedPharmacy();
	}

	@When("^user search with correct zipcode$")
	public void user_search_with_correct_zipcode(DataTable attributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String zipCode = memberAttributesMap.get("ZipCode");
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		drugSummaryPage.searchPharmaciesByZipcode(zipCode);
	}

	@Then("^verify the default tab displayed on VPP details page$")
	public void verify_the_default_tab_displayed_on_VPP_details_page(DataTable attributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String tabName = memberAttributesMap.get("TabName");
		PlanDetailsPageMobile planDetails = new PlanDetailsPageMobile(wd);
		planDetails.validateDefaultTab(tabName);
	}

	@Then("^the user validates distance dropdown and Zipcode change on Summary page - Change Pharmacy Page$")
	public void the_user_validates_distance_dropdown_and_Zipcode_change_on_Summary_page_Change_Pharmacy_Page(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*
		 * List<DataTableRow> memberAttributesRow = arg1.getGherkinRows(); for (int i =
		 * 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PharmacyZipCode = memberAttributesMap.get("PharmacyZipCode");
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateZipandDistanceDropDwn(PharmacyZipCode);
	}

	@Then("^the user selects Mail Pharmacy and returns to DCE Summary page$")
	public void the_user_selects_Mail_Pharmacy_and_returns_to_DCE_Summary_page() throws Throwable {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.selectMailOrderPharmacy();
		// getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary,
		// drugSummaryPage);
		String pharmacy = "OptumRx Mail Service Pharmacy";
		drugSummaryPage.validatePharmacyName(pharmacy);
		getLoginScenario().saveBean(PageConstants.PHARMACY_NAME, pharmacy);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@And("^user clicks on change pharmacy link on alert message from plan card on drug summary page$")
	public void user_clicks_on_change_pharmacy_link_on_alert_message_from_plan_card_on_drug_summary_page()
			throws InterruptedException {
		// DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.clickChangePharmacyFromAltMsg();
	}

	@Then("^the user validates Covered Drug display for NC Pharmacy selection$")
	public void the_user_validates_Covered_Drug_display_for_NC_Pharmacy_selection() throws Throwable {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.ValidateNCPharmacyCoveredDrugs();
	}

	@Then("^the user selects following pharmacy and returns to DCE Summary page$")
	public void the_user_selects_following_pharmacy_and_returns_to_DCE_Summary_page(DataTable givenAttributes)
			throws Throwable {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String PharmacytoSelect = memberAttributesMap.get("SelectPharmacy");
		drugSummaryPage.SelectPharmacy(PharmacytoSelect);
		drugSummaryPage.validatePharmacyName(PharmacytoSelect);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^no results message should be displayed from drug details$")
	public void no_results_message_should_be_displayed_from_drug_details(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*
		 * List<DataTableRow> memberAttributesRow = attributes.getGherkinRows(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String message = memberAttributesMap.get("NoResultsMessage");
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateNoResultsMsgDrugDetails(message);
	}

	@When("^user search with zipcode with no pharamacies from drug details$")
	public void user_search_with_zipcode_with_no_pharamacies_from_drug_details(DataTable attributes) throws Throwable {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		String zipCode = memberAttributesMap.get("ZipCode");
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.searchPharmaciesByZipcodeDrugDetails(zipCode);
	}

	@Then("^the user validates LIS text for coverages stages popups on DCE details page$")
	public void the_user_validates_LIS_text_for_coverages_stages_popups_on_DCE_details_page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDrugStageInfoModals_LISbuydownPlans();
	}

	@Then("^the user validates non zero costs for Not covered Drugs for LIS Buydown on DCE details Page$")
	public void the_user_validates_non_zero_costs_for_Not_covered_Drugs_for_LIS_Buydown_on_DCE_details_Page(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*
		 * List<DataTableRow> memberAttributesRow = arg1.getGherkinRows(); for (int i =
		 * 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String NotCoveredDrug = memberAttributesMap.get("NotCoveredDrug");
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateLISBuyDown_NotCoveredDrugCost(NotCoveredDrug);
	}

	@Then("^the user validates Monthly Costs are not displayed for LIS Buydown plan on DCE details Page$")
	public void the_user_validates_Monthly_Costs_are_not_displayed_for_LIS_Buydown_plan_on_DCE_details_Page()
			throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateLISBuyDown_MonthlyCostsNotDisplayed();
	}

	@Then("^the user validates zero costs for following Covered generic drug for LIS Buydown on DCE details Page$")
	public void the_user_validates_zero_costs_for_following_Covered_generic_drug_for_LIS_Buydown_on_DCE_details_Page(
			DataTable arg1) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*
		 * List<DataTableRow> memberAttributesRow = arg1.getGherkinRows(); for (int i =
		 * 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String CoveredDrug = memberAttributesMap.get("CoveredDrug");
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateLISBuyDown_CoveredDrugCost(CoveredDrug);
	}

	@Then("^the user Validates Drug you pay on DCE details page to Compare page Drug Info Modal$")
	public void the_user_validates_drugyoupay_onDCEdetails_toCompareDrugInfoModal() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		String drugYouPaylist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS);
		drugDetailsPage.validateDrugListYouPay_FromComparePage(druglist, drugYouPaylist);
	}

	@Then("^the user closes the Drug Info Modal on Plan Compare page$")
	public void the_user_closes_the_Drug_Info_Modal_on_Plan_Compare_page() throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.CloseDrugInfoModal();
	}

	@Then("^the user clicks on Edit Drug link and validates user lands on DCE Build Drug List Page$")
	public void the_user_clicks_on_Edit_Drug_link_and_validates_user_lands_on_DCE_Build_Drug_List_Page()
			throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		BuildYourDrugListMobile DCEbuildDrugList = planComparePage.clickonEdityourDrug();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}

	@Then("^the user clicks on View Plan Compare button and validates Plan Compare page, Drug Info Modal$")
	public void the_user_clicks_on_View_Plan_Compare_button_and_validates_Plan_Compare_page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		String drugYouPaylist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS);
		drugDetailsPage.validateDrugListYouPay_FromComparePage(druglist, drugYouPaylist);
		ComparePlansPageMobile planComparePage = drugDetailsPage
				.clickViewPlanCompareBtn_ReturnToCompare_ViewDrugModal();
		if (null != planComparePage) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else
			Assertion.fail("VPP Plan Compare not loaded");
	}

	@When("^user should verify the Extra help on SNP plan type$")
	public void user_should_verify_the_Extra_help_in_AARP() {
		// DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.clickOnSNPPlan();
		drugSummaryPage.verifyTheTextAlert();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@When("^user click on PDP plan to view drug pricing$")
	public void User_click_on_PDP_plan_in_AARP() throws Throwable {
		// DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.clickOnPdpPlan();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^the user validates Switch to generic for following Brand Drug to Generic from Drug Summary - Drug Pricing Modal$")
	public void the_user_validates_Switch_to_generic_for_following_Brand_Drug_to_Generic_drug_from_Summary_Page(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String BrandDrug = memberAttributesMap.get("Brand Drug");
		String GenericDrug = memberAttributesMap.get("Generic Drug");
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		SwitchToGenericMobile switchToGenericPage = drugSummaryPage.clickSwitchGeneric(BrandDrug);
		switchToGenericPage.validateSwitchPage(GenericDrug, BrandDrug);
		drugSummaryPage = switchToGenericPage.ClickSwitch_ReturnSummaryPage();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		druglist = druglist.replace(BrandDrug, GenericDrug);
		System.out.println("Drugs List : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);

		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@And("^the user clicks on Return to details link on Drug Details page$")
	public void the_user_clicks_on_returnlink_DrugDetails() {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		PlanDetailsPageMobile planDetailsPage = drugDetailsPage.clickReturnToDetailsLink();
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetailsPage);

	}

	@When("^user click on View Drug Pricing Modal$")
	public void User_click_on_View_Drug_Pricing_Modal_in_AARP() throws Throwable {

		// DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.clickViewPricing();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^the user verifies the drug information on plan costs tab$")
	public void the_user_verifies_drug_info_on_Plan_Cost() throws Throwable {

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String annualDrugCost = (String) getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		vppPlanDetailsPage.validateDrugInfoOnPlanCostTab(annualDrugCost);
	}

	@Then("^the user click on Edit Drugs Link on plan costs tab$")
	public void the_user_click_on_Edit_Drugs_on_Plan_costs_tabe() throws Throwable {

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		BuildYourDrugListMobile DCEbuildDrugList = vppPlanDetailsPage.navigateToDCERedesignFromPlanCostTab();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}

	@Then("^the user click on Plan costs tab$")
	public void user_click_Plan_costs_tab_and_validates_in_AARP_site() throws Throwable {

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.clickPlanCosts();
	}

	@Then("^the user clicks on Remove button on Drug List page on DCE to delete drug$")
	public void the_user_clicks_on_RemoveBtn(DataTable Attributes) throws Throwable {
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

		DCEbuildDrugList.clickOnRemoveButton(drug);

	}

	@Then("^the user clicks on Edit drug on plan details page and navigates to DCE$")
	public void the_user_click_on_EdidDrugLink() throws Throwable {
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) vppPlanDetailsPage
				.navigateToDCERedesignEditDrug();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
	}

	@Then("^the user click on Prescription Drug Benefits tab on plan details$")
	public void the_user_click_on_Prescription_Drug_Benefits_and_validates_in_AARP_site() throws Throwable {
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.clickAndValidatePrescriptionDrugBenefits();
	}

	@And("^the user clicks on Edit your drug list link on drug details page$")
	public void the_user_clicks_on_editDrugLink_on_DrugDetails() {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		BuildYourDrugListMobile buildDrugList = drugDetailsPage.clickOnEditDrugListLink();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}

	@Then("^the user clicks on drug dropdown on plan summary page and navigates to DCE$")
	public void clickOnDrugDropdownAndNavigateToDCE(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*
		 * List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows(); for
		 * (int i = 0; i < plannameAttributesRow.size(); i++) {
		 * 
		 * plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
		 * plannameAttributesRow.get(i).getCells().get(1)); }
		 */
		String planType = plannameAttributesMap.get("Plan Type");
		String planName = plannameAttributesMap.get("Plan Name");

		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		DrugDetailsPageMobile drugDetailsPage = planSummaryPage.navigateToDCEFromDrugDropdown(planType, planName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates the drug cost on plan summary page for the selected plan$")
	public void verify_drug_cost(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*
		 * List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows(); for
		 * (int i = 0; i < plannameAttributesRow.size(); i++) {
		 * 
		 * plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
		 * plannameAttributesRow.get(i).getCells().get(1)); }
		 */
		String annualDrugCost = (String) getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		String planName = plannameAttributesMap.get("Plan Name");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assertion.assertTrue("Drug cost is displayed incorrectly",
				plansummaryPage.verifyAddedDrugCost(planName, annualDrugCost));
	}

	@Then("^the user validates Drug List in Monthly Drug Costs by Stage Section on Drug Details Page$")
	public void the_user_validates_druglist_monthly_drug_costs_stage_DrugDetailsPage() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		drugDetailsPage.ValidatesDrugsList_MonthlyDrugStage(druglist);

	}

	@Then("^the user Validates All Tier info and Drug Limits details displayed in Important Information Section on Drug Details Page$")
	public void the_user_validates_tiers_drugLimits_importantInfo_DrugDetailsPage() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.ValidatesDrugsTier_Limits_ImportantInfo();
	}

	@Then("^the user clicks on Review Drug Costs button to Land on Drug Summary Page$")
	public void the_user_click_Review_Drug_Costs_button_to_Land_on_Drug_Summary_Page() throws Throwable {
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugSummaryPageMobile drugSummaryPage = DCEbuildDrugList.navigateToDrugSummay();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^the user Validates All Tier info and Drug Limits displayed on Your Drugs Section on Drug Details Page$")
	public void the_user_validates_tiers_drugLimits_yourDrugs_DrugDetailsPage() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.ValidatesDrugsTier_LimitsDisplayed();
	}

	@Then("^the user validates Drug Recommendation section is not Displayed after adding twenty five drugs$")
	public void the_user_validates_Drug_Recommendation_section_does_not_dispaly() throws Throwable {
		BuildYourDrugListMobile buildYourDrugsListPage = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);
		buildYourDrugsListPage.validateDrugRecommendationSectionNOTdisplayed(druglist);
	}

	@Then("^the user tries to add following drug over cabinet limit and validates error modal$")
	public void the_user_searches_and_adds_and_validates_drug_cabinet_limit(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String drugName = memberAttributesMap.get("DrugName");
		System.out.println(drugName);
		BuildYourDrugListMobile buildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		buildDrugList.SearchValidate_DrugCountError(drugName);
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

	@Then("^the user searches and adds the following Drug to Drug List$")
	public void the_user_searches_and_adds_the_following_Drug_to_Drug_Lists(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();

		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String drugName = memberAttributesMap.get("DrugName");
		System.out.println(drugName);
		BuildYourDrugListMobile buildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrugMobile tellUsAboutDrug = buildDrugList.SearchaddDrug(drugName);
		buildDrugList = tellUsAboutDrug.ClickAddDrug();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);

		System.out.println("Drugs List : " + druglist);

		// if (druglist.isEmpty()) {
		if (StringUtils.isEmpty(druglist)) {
			druglist = drugName;
		} else {
			druglist = druglist + "&" + drugName;
		}
		System.out.println("Drugs List after Drug " + drugName + " , Added : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
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
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates planName matches plan Name in VPP$")
	public void the_user_validates_planName_matches_plan_Name_in_VPP() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		drugDetailsPage.validatePlanName(PlanName);
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