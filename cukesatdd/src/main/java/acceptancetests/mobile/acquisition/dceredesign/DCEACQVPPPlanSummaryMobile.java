package acceptancetests.mobile.acquisition.dceredesign;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
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
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
//import pages.mobile.acquisition.commonpages.GetStartedPageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
//import pages.mobile.acquisition.ulayer.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.TellUsAboutDrugMobile;

/**
 * Functionality:DCE Acquisition
 */
public class DCEACQVPPPlanSummaryMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	// AppiumDriver wd;

	/**
	 * @toDo:user is on medicare acquisition site landing page
	 */

	@Given("^the enduser is on medicare acquisition site landing page$")
	public void the_user_on__medicaresolutions_Site(DataTable givenAttributes) {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		// aquisitionhomepage.openPRE();
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^the enduser performs plan search using following information$")
	public void enters_zipcode_details_in_UMS_site(DataTable givenAttributes) {
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

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = null;
		plansummaryPage = aquisitionhomepage.searchPlanOnHealthPlansPage(zipcode, county, isMultiCounty);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}

	}

	@Then("^the enduser navigates to the plan details for the given plan type in AARP site-$")
	public void the_user_navigates_to_the_plan_details_for_the_given_plan_type_in_AARP_site(DataTable data)
			throws Throwable {
		// wd.manage().window().maximize();
		/*
		 * List<DataTableRow> memberAttributesRow = data.getGherkinRows(); String
		 * planType = memberAttributesRow.get(0).getCells().get(1); String planName =
		 * memberAttributesRow.get(1).getCells().get(1);
		 */
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String planType = data.cell(0, 1);
		String planName = data.cell(1, 1);
		VPPPlanSummaryPageMobile plansummaryPage = new VPPPlanSummaryPageMobile(wd);
		// plansummaryPage.viewPlanSummary(planType);
		PlanDetailsPageMobile plandetailspage = plansummaryPage.navigateToPlanDetails(planName, planType);
		if (plandetailspage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE, plandetailspage);
			getLoginScenario().saveBean(DCERedesignCommonConstants.PLANTYPE, planType);
			getLoginScenario().saveBean(DCERedesignCommonConstants.PLANNAME, planName);

		}

	}

	@And("^enduser access the DCE Redesign from Plan Details for the plan$")
	public void the_user_navigates_to_Presciption_Drug_Benefits_tab_in_AARP_site() throws Throwable {
		PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_DETAILS_PAGE);
		GetStartedPageMobile getStartedPage = plandetailspage.navigateToDCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^the enduser validates Get Started Page$")
	public void the_user_validates_Get_Started_Page() throws Throwable {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		GetStartedPageMobile DCEgetStarted = new GetStartedPageMobile(wd);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, DCEgetStarted);

	}

	@Then("^the enduser clicks on Build Drug List to navigate to Build Drug List Page$")
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

	@Then("^the enduser searches and adds the following Drug to Drug List$")
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

	@Then("^the enduser clicks on Review Drug Costs to Land on Drug DetailsP Page$")
	public void the_user_clicks_on_Review_Drug_Costs_to_Land_on_Drug_DetailsP_Page() throws Throwable {
		BuildYourDrugListMobile DCEbuildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugDetailsPageMobile drugDetailsPage = DCEbuildDrugList.navigateToDrugDetailsPage();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the enduser validates planName matches plan Name in VPP$")
	public void the_user_validates_planName_matches_plan_Name_in_VPP() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		String PlanName = (String) getLoginScenario().getBean(DCERedesignCommonConstants.PLANNAME);
		drugDetailsPage.validatePlanName(PlanName);
	}

	@Then("^the enduser Captures Drug costs on Drug Details Page$")
	public void the_user_Captures_Drug_costs_on_Drug_Details_Page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		Map<String, String> DrugCosts = drugDetailsPage.CaptureDrugCosts();
		String AVG_MONTHLY = DrugCosts.get("AVG_MONTHLY");
		String MONTHLY_PREMIUM = DrugCosts.get("MONTHLY_PREMIUM");
		String ANNUAL_ESTIMATED_TOTAL = DrugCosts.get("ANNUAL_ESTIMATED_TOTAL");
		String COVERED_DRUGS_COUNT = DrugCosts.get("COVERED_DRUGS_COUNT");

		System.out.println(DrugCosts);
		getLoginScenario().saveBean(DCERedesignCommonConstants.AVG_MONTHLY, AVG_MONTHLY);
		getLoginScenario().saveBean(DCERedesignCommonConstants.MONTHLY_PREMIUM, MONTHLY_PREMIUM);
		getLoginScenario().saveBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL, ANNUAL_ESTIMATED_TOTAL);
		getLoginScenario().saveBean(DCERedesignCommonConstants.AVG_MONTHLY, COVERED_DRUGS_COUNT);
	}

	@Then("^the enduser validates Drug Costs section$")
	public void the_user_validates_Drug_Costs_section() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDrugCosts();
	}

	@Then("^the enduser validates Your Drugs sections$")
	public void the_user_validates_Your_Drugs_sections() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateYourDrugs();
	}

	@Then("^the enduser validates Monthly Drug Costs by Stage Section$")
	public void the_user_validates_Monthly_Drug_Costs_by_Stage_Section() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateMonthlyCostStage();
	}

	@Then("^the enduser validates link to Drug Summary Page$")
	public void the_user_validates_link_to_Drug_Summary_Page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		DrugSummaryPageMobile drugSummaryPage = drugDetailsPage.ClickLinktoNavigatetoDrugSummary();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);

	}

	@Then("^the enduser Clicks button to VPP Plan Details Page from Drug Details Page$")
	public void the_user_Clicks_button_to_VPP_Plan_Details_Page_from_Drug_Details_Page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		String PlanName = (String) getLoginScenario().getBean(DCERedesignCommonConstants.PLANNAME);
		PlanDetailsPageMobile plandetailspage = drugDetailsPage.ClickandNavigate_VPPPlanDetails(PlanName);
		if (null != plandetailspage) {
			getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE, plandetailspage);
		} else
			Assertion.fail("VPP Plan Details not loaded");

	}

	@Then("^the enduser validates Important information section$")
	public void the_user_validates_Important_information_section() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateImportantInfo();
	}

	@Then("^the enduser validates Estimated Annual Drug Costs on Prescription Drug Costs Tab on Plan Details Page$")
	public void the_user_validates_Estimated_Drug_Costs_on_Prescription_Drug_Costs_Tab_on_Plan_Details_Page()
			throws Throwable {
		PlanDetailsPageMobile plandetailspage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_DETAILS_PAGE);
		String EstimatedDrugCosts = plandetailspage.costComparisonPrescriptionDrugFromDCE();
		String cost = (String) getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		if (cost.trim().contains(EstimatedDrugCosts))
			Assertion.assertTrue("It's a match on on prescription drug tab and Drug CostEstimator page; Expected : "
					+ cost + "; Actual : " + EstimatedDrugCosts, true);
		else
			Assertion.assertTrue("Cost mismatch on prescription drug tab and drug CostEstimator page; Expected : "
					+ cost + "; Actual : " + EstimatedDrugCosts, false);

	}
	///

	@When("^the user views the plans of the below plan type and select Next year$")
	public void user_performs_planSearch_in_aarp_site_next_year(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */

		String plantype = givenAttributesMap.get("Plan Type");
		System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		if (!plantype.equalsIgnoreCase("MS"))
			plansummaryPage.handlePlanYearSelectionPopup();
	}

	@When("^I access the DCE Redesign from Plan Summary for mentioned plan$")
	public void accessDCERign_PlanSummaryforPlan(DataTable attributes) {
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
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		// plansummaryPage.viewPlanSummary(plantype);

		GetStartedPageMobile getStartedPage = plansummaryPage.navigateToDCERedesignFromVPPPlanCard(plantype, planName);

		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@And("^user clicks on get started button on NBA$")
	public void user_click_Get_started_button_on_NBA() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickGetStartedBtnOnNba();
	}
}
