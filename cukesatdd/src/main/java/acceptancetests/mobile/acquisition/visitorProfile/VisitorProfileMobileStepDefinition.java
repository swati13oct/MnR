
package acceptancetests.mobile.acquisition.visitorProfile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

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
import pages.mobile.acquisition.commonpages.ComparePlansPageMobile;
import pages.mobile.acquisition.commonpages.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.ProfileSearch;
import pages.mobile.acquisition.commonpages.ShopperProfileAgentLogin;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfileTestHarnessPageMobile;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;

/**
 * @author bnaveen4 Functionality:Visitor Profile for both AAPR and UHC
 *         acquisition sites
 */
public class VisitorProfileMobileStepDefinition {

	@Autowired
	MRScenario loginScenario;

	// AppiumDriver wd;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^I am an agent logged into the cloak in tool$")
	public void i_am_an_agent_logged_into_the_cloak_in_tool(DataTable userData) {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(userData);
		/*
		 * List<DataTableRow> givenAttributesRow = userData.getGherkinRows(); for (int i
		 * = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
		String userName = givenAttributesMap.get("User Name");
		String password = givenAttributesMap.get("Password");

		AppiumDriver wd = (AppiumDriver) getLoginScenario().getMobileDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		ShopperProfileAgentLogin shopperProfilePage = new ShopperProfileAgentLogin(wd);
		getLoginScenario().saveBean(PageConstants.SHOPPER_PROFILE_PAGE, shopperProfilePage);

		ProfileSearch profileSearch = shopperProfilePage.doAgentLogin(userName, password);
		getLoginScenario().saveBean(PageConstants.PROFILE_SEARCH, profileSearch);

	}

	@And("^the user selects the state drop down value in home page mobile$")
	public void the_user_selects_the_state_drop_down_value_in_AARP_home_pages(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */

		String state = givenAttributesMap.get("State");
		AcquisitionHomePageMobile acqHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		// CommonConstants.SELECTED_STATE = state;
		CommonConstants.setSelectedState(state);

		acqHomePage.selectState(state);
	}

	@And("^the user selects the state drop down value in home page$")
	public void user_select_the_state_drop_down_value_in_AARP_home_pages(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */

		String state = givenAttributesMap.get("State");
		AcquisitionHomePageMobile acqHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		// CommonConstants.SELECTED_STATE = state;
		CommonConstants.setSelectedState(state);

		acqHomePage.selectState(state);
	}

	@And("^user delets the added plans on visitor profile page$")
	public void user_delets_the_added_plans_on_visitor_profile_page_of_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*
		 * List<DataTableRow> givenAttributesRow = planNames.getGherkinRows(); for (int
		 * i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
		String savedPlanNames = givenAttributesMap.get("Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
//		visitorProfile.deletePlans(savedPlanNames);
		visitorProfile.deletePlans(planYear, savedPlanNames);
	}
	
	@And("^the user clicks on the shopping cart icon$")
	public void the_user_clicks_on_the_shopping_cart_icon_in_AARP_site() {
		AcquisitionHomePageMobile acqHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VisitorProfilePageMobile visitorProfilePage = acqHomePage.navigateToVisitorProfilePage();
		
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@And("^the user clicks on the add drugs button to navigate to DCE Redesign on the profile page mobile$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_profile_to_DCE_Redesign_in_AARP_site1()
			throws InterruptedException {
		VisitorProfilePageMobile VisitorProfilePageMobile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		GetStartedPageMobile GetStartedPageMobile = VisitorProfilePageMobile.addDrug_DCERedesign();
		if (null != GetStartedPageMobile) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, GetStartedPageMobile);
		} else
			Assertion.fail("DCE Redesign page object not loaded");

	}

	@And("^the user clicks on the add drugs button in the profile$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_profile_in_AARP_site() {

		VisitorProfilePageMobile VisitorProfilePageMobile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		GetStartedPageMobile dcePage = VisitorProfilePageMobile.addDrug_DCERedesign();

		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dcePage);
	}

	@And("^the user clicks on the add plans button in the profile$")
	public void the_user_clicks_on_the_add_plans_button_in_the_profile_in_AARP_site() throws Exception {

		VisitorProfilePageMobile VisitorProfilePageMobile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		AcquisitionHomePageMobile acqPage = VisitorProfilePageMobile.addPlan();

		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acqPage);
	}

	@And("^the user clicks on the add plans button in the profile in agent mode$")
	public void the_user_clicks_on_the_add_plans_button_in_the_profile_in_agent_mode_in_AARP_site() throws Exception {

		VisitorProfilePageMobile VisitorProfilePageMobile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		VPPPlanSummaryPageMobile planSummary = VisitorProfilePageMobile.addPlanForMember();
		planSummary.handlePlanYearSelectionPopup();

		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, planSummary);
	}

	@When("^the user enters zipcode on health plans page$")
	public void enters_zipcode_details_in_aarp_site(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("county");
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

	// @Then("^Navigate to Visitor Profile page$")
	// public void navigate_to_Visitor_Profile_page() {
	// ComparePlansPageMobile comparePlansPage = (ComparePlansPageMobile)
	// getLoginScenario()
	// .getBean(PageConstants.PLAN_COMPARE_PAGE);
	// getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
	// VisitorProfilePageMobile VisitorProfilePageMobile =
	// comparePlansPage.navigateToVisitorProfilePageMobile();
	// getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE,
	// VisitorProfilePageMobile);
	// }

	@Then("^Navigate to Visitor Profile page$")
	public void navigate_to_Visitor_Profile_page_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		VisitorProfilePageMobile VisitorProfilePageMobile = plansummaryPage.navigateToVisitorProfilePage();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, VisitorProfilePageMobile);
	}

	@And("^the user returns to the visitor profile page$")
	public void the_user_returns_to_the_visitor_profile_page() {

		DrugCostEstimatorPageMobile dcePage = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		VisitorProfilePageMobile VisitorProfilePageMobile = dcePage.retrunToProfile();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, VisitorProfilePageMobile);
	}

	@And("^the user should be able to see the Drug information in the guest profile page$")
	public void the_user_should_be_able_to_see_the_Drug_information_in_the_guest_profile_page(DataTable data) throws InterruptedException {
		/*
		 * List<DataTableRow> memberAttributesRow = data.getGherkinRows(); String drug =
		 * memberAttributesRow.get(0).getCells().get(1);
		 */
		String drug = data.cell(0, 1);
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedDrugAndPharmacy(drug);
	}

	@And("^user validates the added plans on visitor profile page$")
	public void user_validates_the_added_plans_on_visitor_profile_page_of_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*
		 * List<DataTableRow> givenAttributesRow = planNames.getGherkinRows(); for (int
		 * i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
		String savePlanNames = givenAttributesMap.get("Test Plans");
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
//		visitorProfile.validateAddedPlans(savePlanNames);
		visitorProfile.validateAddedPlans(savePlanNames);
	}

	@And("^user validates the added Ms plans on visitor profile page$")
	public void user_validates_the_added_Ms_plans_on_visitor_profile_page_of_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		String savePlanNames = givenAttributesMap.get("MS Test Plans");
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedMsPlans(savePlanNames);
	}

	@And("^the user should be able to see all the added Drugs information in the guest profile page$")
	public void the_user_should_be_able_to_see_all_the_added_Drugs_information_in_the_guest_profile_page(
			DataTable data) {
		String drugList = data.cell(0, 1);
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedDrugs(drugList);
	}

	@And("^user validate pdf link$")
	public void user_validate_pdf_link_on_AARP_Site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		String savePlanNames = givenAttributesMap.get("MS Test Plans");
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedPlansPDFLinks(savePlanNames);
	}

	@And("^the user clicks on the shopping cart icon on DCE page$")
	public void the_user_clicks_on_the_shopping_cart_icon_on_DCE_page_in_AARP() {
		GetStartedPageMobile dce = (GetStartedPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		VisitorProfilePageMobile VisitorProfilePageMobile = dce.clickOnShoppingCart();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, VisitorProfilePageMobile);
	}

	@And("^user clicks on plan name$")
	public void user_clicks_on_plan_name_in_AARP(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		String planName = givenAttributesMap.get("Test Plans");
		VisitorProfilePageMobile VisitorProfilePageMobile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		PlanDetailsPageMobile planDetails = VisitorProfilePageMobile.navigateToPlanDetails(planName.split(",")[0]);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetails);
		System.out.println(planDetails);
	}

	@Then("^user saves two ms plans as favorite mobile$")
	public void user_saves_two_ms_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String ms_savePlanNames = memberAttributesMap.get("MS Test Plans");

		plansummaryPage.saveMSPlans(ms_savePlanNames);

	}

	@Then("^the user validates the following Additional Benefits of Plan for the plan$")
	public void the_user_validates_the_following_Additional_Benefits_of_Plan_for_the_plan_in_AARP(
			DataTable givenAttributes) throws Throwable {

		List<List<String>> additionalBenefits = givenAttributes.asLists();
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(additionalBenefits);
	}

	// @And("^user deletes the added plans on visitor profile page$")
	// public void
	// user_delets_the_added_plans_on_visitor_profile_page_of_AARP_site(DataTable
	// planNames) {
	// List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
	// Map<String, String> givenAttributesMap = new HashMap<String, String>();
	// for (int i = 0; i < givenAttributesRow.size(); i++) {
	//
	// givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
	// givenAttributesRow.get(i).getCells().get(1));
	// }
	// String savedPlanNames = givenAttributesMap.get("Test Plans");
	// VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile)
	// getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
	// visitorProfile.deletePlans(savedPlanNames);
	// }

	@Then("^user saves two plans as favorite$")
	public void user_saves_two_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String savePlanNames = memberAttributesMap.get("Test Plans");
		String planType = memberAttributesMap.get("Plan Type");

		plansummaryPage.savePlans(savePlanNames, planType);
	}

	@Then("^user gets a create profile prompt$")
	public void user_saves_two_plans_as_favorite_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.validateCreateProfilePrompt();

		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

	}

	@And("^user click on continue as guest button$")
	public void user_click_on_continue_as_guest_button_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		VisitorProfilePageMobile VisitorProfilePageMobile = plansummaryPage.continueAsGuest();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, VisitorProfilePageMobile);

	}

	@And("^user delets all the added drugs on visitor profile page$")
	public void user_delets_all_the_added_drugs_on_visitor_profile_page_of_AARP_site() {
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deleteAllDrugs();
	}

	@And("^user clicks on Edit Drug and Pharmacy on visitor profile page$")
	public void user_clicks_on_Edit_Drug_and_Pharmacy_on_visitor_profile_page() {
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		BuildYourDrugListMobile DCEbuildDrugList = visitorProfile.clickOnEditDrugAndPharmacy();
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, DCEbuildDrugList);
	}

	@And("^user delets all the added providers on visitor profile page$")
	public void user_delets_all_the_added_providers_on_visitor_profile_page_of_AARP_site(DataTable Planname) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*
		 * List<DataTableRow> plannameAttributesRow = Planname .getGherkinRows(); for
		 * (int i = 0; i < plannameAttributesRow.size(); i++) {
		 * 
		 * plannameAttributesMap.put(plannameAttributesRow.get(i).getCells() .get(0),
		 * plannameAttributesRow.get(i).getCells().get(1)); }
		 */
		String planName = plannameAttributesMap.get("PlanName");
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deleteProviders(planName);
	}

	@Then("^Verify X out of Y provider covered information is displayed on visitor profile page$")
	public void verify_providers_covered_ulayer_visitor_profile(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*
		 * List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows(); for
		 * (int i = 0; i < plannameAttributesRow.size(); i++) {
		 *
		 * plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
		 * plannameAttributesRow.get(i).getCells().get(1)); }
		 */
		String planName = plannameAttributesMap.get("PlanName");

		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		String providerFromRally = (String) getLoginScenario().getBean(VPPCommonConstants.SAVED_PROVIDER_RALLY);
		visitorProfile.validateProviderinfo(planName, providerFromRally);
	}

	@And("^the user signs in with optum Id credentials$")
	public void the_user_signs_in_with_optum_Id_credentials_in_AARP_site(DataTable credentials) {
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

		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.signIn(username, password);
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfile);
	}

	@And("^enroll In Plan should not be clickable on Visitor Profile page in Agent mode$")
	public void next_button_should_not_be_clickable_on_OLE_welcome_page_in_Agent_mode() {
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		Assertion.assertTrue(visitorProfile.validateEnrollInPlanIsClickable());
	}

	@And("^user verifies plan count on shopping cart Icon$")
	public void user_validates_plan_count_on_shopping_cart_Icon_on_AARP_site(DataTable givenAttributes) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> plannameAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < plannameAttributesRow.size(); i++) {
		 * 
		 * plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
		 * plannameAttributesRow.get(i).getCells().get(1)); }
		 */
		String planCount = plannameAttributesMap.get("Plans Count");
		VisitorProfilePageMobile VisitorProfilePageMobile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		VisitorProfilePageMobile.validatePlanCountOnCartIcon(planCount);
	}

	@And("^user switch back to Vp Testharness Page$")
	public void user_switch_back_to_Vp_Testharness_Page_on_AARP_site() {
		VisitorProfilePageMobile VisitorProfilePageMobile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		VisitorProfilePageMobile.switchBackToVPTestharness();
	}

	@And("^user Enters Plan id and click on delete plan to Delete plan in Visitor Profile$")
	public void user_EntersPlanidandclickondeleteplantoDeleteplaninVisitorProfile_on_AARP_site(
			DataTable givenAttributes) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> plannameAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < plannameAttributesRow.size(); i++) {
		 * 
		 * plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
		 * plannameAttributesRow.get(i).getCells().get(1)); }
		 */
		String planID = plannameAttributesMap.get("Plan ID");
		VisitorProfileTestHarnessPageMobile vpTestHarnessPage = (VisitorProfileTestHarnessPageMobile) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		// VisitorProfilePageMobile VisitorProfilePageMobile =
		// vpTestHarnessPage.DeleteplaninVisitorProfile(planID);
		// getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE,
		// VisitorProfilePageMobile);
	}

	@And("^user selects four plans to compare from visitor Profile$")
	public void user_clicks_compare_plans_from_visitor_Profile_on_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*
		 * List<DataTableRow> givenAttributesRow = planNames.getGherkinRows(); for (int
		 * i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
		String comparePlans = givenAttributesMap.get("Test Plans");
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		ComparePlansPageMobile planComparePage = visitorProfile.planCompare(comparePlans);
		if (planComparePage != null) {
			loginScenario.saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else {
			Assertion.fail("Error Loading on Plan Compare page");
		}
	}

	@And("^verify the plans on plan compare page$")
	public void verify_the_plans_on_plan_compare_page_on_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*
		 * List<DataTableRow> givenAttributesRow = planNames.getGherkinRows(); for (int
		 * i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
		String comparePlans = givenAttributesMap.get("Test Plans");
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatePlansAddedonPlancompareforVisitorProfile(comparePlans);
	}

	@And("^the user back to VPP plan summary page$")
	public void the_user_back_to_VPP_plan_summary_page_in_aarp() {

		VisitorProfilePageMobile VisitorProfilePageMobile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		VPPPlanSummaryPageMobile planSummary = VisitorProfilePageMobile.backToPlans();

		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, planSummary);
	}

	@And("^validate OLE details$")
	public void validate_OLE_details(DataTable oleDetails) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(oleDetails);
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateOLEDetails(givenAttributesMap);

	}

	@And("^the user cancel the enrollment$")
	public void the_user_cance_the_enrollments(DataTable cancelOLEDetails) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(cancelOLEDetails);
		/*
		 * List<DataTableRow> plannameAttributesRow = cancelOLEDetails.getGherkinRows();
		 * for (int i = 0; i < plannameAttributesRow.size(); i++) {
		 * 
		 * plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
		 * plannameAttributesRow.get(i).getCells().get(1)); }
		 */
		String planName = plannameAttributesMap.get("Plan Name");

		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.cancelEnrollment(planName);
	}
	
	@When("^user clicks on Add drugs button globally on shopper profile page$")
	public void user_clicks_on_add_drugs_button_globally() {
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.clickAddDrugsBtn();
	}

	@When("^the user Import Drugs and Doctors$")
	public void the_user_clicks_on_Import_Drugs_and_Doctors(DataTable data) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(data);
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.importDrugsAndDoctors(givenAttributesMap);

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	@Then("^user clicks on ms plan details button$")
	public void user_clicks_on_ms_plan_details_button(DataTable plan) {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(plan);
		String planName = plannameAttributesMap.get("MS Plan");
		visitorProfilePage.clickOnMSPlanDetailsPage(planName);
	}

	@Then("^user validates MS plan details$")
	public void user_validates_MS_plan_details() {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.validateMSPlanDetailsPage();
	}

	@Then("^user clicks on Back to Profile link$")
	public void user_Clicks_Back_To_Profile() {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.clickOnBackToProfile();
	}

	@Then("^user clicks on ms start application button$")
	public void user_clicks_on_ms_start_application_button(DataTable plan) {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(plan);
		String planName = plannameAttributesMap.get("MS Plan");
		visitorProfilePage.clickOnMStartApplication(planName);
	}

	@Then("^user validates MS Start application page$")
	public void user_validates_MS_Start_Application_Page() {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.validateMSStartApplicationPage();
	}

	@Then("^user close MS application page$")
	public void user_close_MS_Application_Page() {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.clickOnCloseMSApplication();
	}

	@Then("^user clicks on ms Learn More link$")
	public void user_clicks_on_ms_learn_more_link(DataTable plan) {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(plan);
		String planName = plannameAttributesMap.get("MS Plan");
		visitorProfilePage.clickOnMLearnMore(planName);
	}

	@Then("^user validates MS Learn More page$")
	public void user_validates_MS_learn_more_Page() {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.validateMSLearnMorePage();
	}

	@Then("^user clicks on MS Add your Information link$")
	public void user_clicks_on_ms_add_your_info_link(DataTable plan) {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(plan);
		String planName = plannameAttributesMap.get("MS Plan");
		visitorProfilePage.clickOnMSAddYourInformation(planName);

	}

	@Then("^user validates MS Add your Information page$")
	public void user_validates_MS_add_your_info_Page() {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.validateMSAddYourInfoPage();
	}

	@Then("^user validates MS SP Profile page with Import, PRE and ComponentCode$")
	public void user_validates_MS_SP_Page(DataTable componentCode) {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(componentCode);
		String ComponentCode = plannameAttributesMap.get("Component Code");
		visitorProfilePage.validateMSSP4ProfilePage(ComponentCode);
	}

	@And("^user delets the added Ms plans on visitor profile page$")
	public void user_delets_the_added_ms_plans_on_visitor_profile_page_of_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		String savedPlanNames = givenAttributesMap.get("MS_testPlans");
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.removeMSPlans(savedPlanNames);
	}
}