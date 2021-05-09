package acceptancetests.acquisition.visitorprofile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.DrugCostEstimatorPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.commonpages.VisitorProfileTestHarnessPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.GetStartedPage;

/**
 * @author bnaveen4 Functionality:Visitor Profile for both AAPR and UHC
 *         acquisition sites
 */
public class VisitorProfileStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@And("^the user selects the state drop down value in home page$")
	public void the_user_selects_the_state_drop_down_value_in_AARP_home_page(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String state = givenAttributesMap.get("State");
		AcquisitionHomePage acqHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

//		CommonConstants.SELECTED_STATE = state;
		CommonConstants.setSelectedState(state);

		acqHomePage.selectState(state);
	}

	@And("^the user clicks on the shopping cart icon$")
	public void the_user_clicks_on_the_shopping_cart_icon_in_AARP_site() {
		AcquisitionHomePage acqHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VisitorProfilePage visitorProfilePage = acqHomePage.navigateToVisitorProfilePage();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@And("^the user clicks on the add drugs button in the profile$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_profile_in_AARP_site() {

		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		GetStartedPage dcePage = visitorProfilePage.addDrug_DCERedesign();

		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dcePage);
	}

	@And("^the user clicks on the add plans button in the profile$")
	public void the_user_clicks_on_the_add_plans_button_in_the_profile_in_AARP_site() throws Exception {

		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		AcquisitionHomePage acqPage = visitorProfilePage.addPlan();

		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acqPage);
	}

	@And("^the user clicks on the add plans button in the profile in agent mode$")
	public void the_user_clicks_on_the_add_plans_button_in_the_profile_in_agent_mode_in_AARP_site() throws Exception {

		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		VPPPlanSummaryPage planSummary = visitorProfilePage.addPlanForMember();
		planSummary.handlePlanYearSelectionPopup();

		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, planSummary);
	}

	@And("^the user returns to the visitor profile page$")
	public void the_user_returns_to_the_visitor_profile_page() {

		DrugCostEstimatorPage dcePage = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		VisitorProfilePage visitorProfilePage = dcePage.retrunToProfile();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@And("^the user should be able to see the Drug information in the guest profile page$")
	public void the_user_should_be_able_to_see_the_Drug_information_in_the_guest_profile_page(DataTable data) {
		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);*/
		List<List<String>> memberAttributesRow = data.asLists();
		String drug = memberAttributesRow.get(0).get(1);
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedDrugAndPharmacy(drug);
	}

	@And("^user validates the added plans on visitor profile page$")
	public void user_validates_the_added_plans_on_visitor_profile_page_of_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String savePlanNames = givenAttributesMap.get("Test Plans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
//		visitorProfile.validateAddedPlans(savePlanNames);
		visitorProfile.validateAddedPlansNew(savePlanNames);
	}

	@And("^user validates the added Ms plans on visitor profile page$")
	public void user_validates_the_added_Ms_plans_on_visitor_profile_page_of_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String savePlanNames = givenAttributesMap.get("MS Test Plans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedMsPlans(savePlanNames);
	}

	@And("^the user should be able to see all the added Drugs information in the guest profile page$")
	public void the_user_should_be_able_to_see_all_the_added_Drugs_information_in_the_guest_profile_page(
			DataTable data) {
		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drugList = memberAttributesRow.get(0).getCells().get(1);*/
		List<List<String>> memberAttributesRow = data.asLists();
		String drugList = memberAttributesRow.get(0).get(1);
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedDrugs(drugList);
	}

	@And("^user validate pdf link$")
	public void user_validate_pdf_link_on_AARP_Site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String savePlanNames = givenAttributesMap.get("MS Test Plans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedPlansPDFLinks(savePlanNames);
	}

	@And("^the user clicks on the shopping cart icon on DCE page$")
	public void the_user_clicks_on_the_shopping_cart_icon_on_DCE_page_in_AARP() {
		GetStartedPage dce = (GetStartedPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_GetStarted);
		VisitorProfilePage visitorProfilePage = dce.clickOnShoppingCart();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@And("^user clicks on plan name$")
	public void user_clicks_on_plan_name_in_AARP(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = givenAttributesMap.get("Test Plans");
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		PlanDetailsPage planDetails = visitorProfilePage.navigateToPlanDetails(planName.split(",")[0]);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetails);
	}

	@And("^user delets the added plans on visitor profile page$")
	public void user_delets_the_added_plans_on_visitor_profile_page_of_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String savedPlanNames = givenAttributesMap.get("Test Plans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deletePlans(savedPlanNames);
	}

	@And("^user delets all the added drugs on visitor profile page$")
	public void user_delets_all_the_added_drugs_on_visitor_profile_page_of_AARP_site() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deleteAllDrugs();
	}

	@And("^user clicks on Edit Drug and Pharmacy on visitor profile page$")
	public void user_clicks_on_Edit_Drug_and_Pharmacy_on_visitor_profile_page() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		BuildYourDrugList DCEbuildDrugList = visitorProfile.clickOnEditDrugAndPharmacy();
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, DCEbuildDrugList);
	}

	@And("^user delets all the added providers on visitor profile page$")
	public void user_delets_all_the_added_providers_on_visitor_profile_page_of_AARP_site(DataTable Planname) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("PlanName");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deleteProviders();
	}

	@Then("^Verify X out of Y provider covered information is displayed on visitor profile page$")
	public void verify_providers_covered_ulayer_visitor_profile(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("PlanName");

		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validteProviderinfo(planName);
	}

	@And("^the user signs in with optum Id credentials$")
	public void the_user_signs_in_with_optum_Id_credentials_in_AARP_site(DataTable credentials) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(credentials);
		/*List<DataTableRow> plannameAttributesRow = credentials.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String username = plannameAttributesMap.get("User Name");
		String password = plannameAttributesMap.get("Password");

		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.signIn(username, password);
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfile);
	}

	@And("^enroll In Plan should not be clickable on Visitor Profile page in Agent mode$")
	public void next_button_should_not_be_clickable_on_OLE_welcome_page_in_Agent_mode() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		Assertion.assertTrue(visitorProfile.validateEnrollInPlanIsClickable());
	}

	@And("^user verifies plan count on shopping cart Icon$")
	public void user_validates_plan_count_on_shopping_cart_Icon_on_AARP_site(DataTable givenAttributes) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> plannameAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planCount = plannameAttributesMap.get("Plans Count");
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.validatePlanCountOnCartIcon(planCount);
	}

	@And("^user switch back to Vp Testharness Page$")
	public void user_switch_back_to_Vp_Testharness_Page_on_AARP_site() {
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.switchBackToVPTestharness();
	}

	@And("^user Enters Plan id and click on delete plan to Delete plan in Visitor Profile$")
	public void user_EntersPlanidandclickondeleteplantoDeleteplaninVisitorProfile_on_AARP_site(
			DataTable givenAttributes) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> plannameAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planID = plannameAttributesMap.get("Plan ID");
		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		// VisitorProfilePage visitorProfilePage =
		// vpTestHarnessPage.DeleteplaninVisitorProfile(planID);
		// getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE,
		// visitorProfilePage);
	}

	@And("^user selects four plans to compare from visitor Profile$")
	public void user_clicks_compare_plans_from_visitor_Profile_on_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String comparePlans = givenAttributesMap.get("Test Plans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		ComparePlansPage planComparePage = visitorProfile.planCompare(comparePlans);
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
		/*List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String comparePlans = givenAttributesMap.get("Test Plans");
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatePlansAddedonPlancompareforVisitorProfile(comparePlans);
	}

	@And("^the user back to VPP plan summary page$")
	public void the_user_back_to_VPP_plan_summary_page_in_aarp() {

		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);

		VPPPlanSummaryPage planSummary = visitorProfilePage.backToPlans();

		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, planSummary);
	}

	@And("^validate OLE details$")
	public void validate_OLE_details(DataTable oleDetails) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(oleDetails);
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateOLEDetails(givenAttributesMap);

	}

	@And("^the user cancel the enrollment$")
	public void the_user_cance_the_enrollments(DataTable cancelOLEDetails) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(cancelOLEDetails);
		/*List<DataTableRow> plannameAttributesRow = cancelOLEDetails.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("Plan Name");

		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.cancelEnrollment(planName);
	}

	@And("^user delets the added Ms plans on visitor profile page$")
	public void user_delets_the_added_ms_plans_on_visitor_profile_page_of_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String savedPlanNames = givenAttributesMap.get("MS_testPlans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deleteMSPlans(savedPlanNames);
	}

	@And("^user validates the added plans on new visitor profile page$")
	public void user_validates_the_added_plans_on_new_visitor_profile_page(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String savePlanNames = givenAttributesMap.get("Test Plans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedPlansNew(savePlanNames);
	}

	@Then("^the user clicks on the enter drug information button from plan card on Visitor Profile page$")
	public void the_user_clicks_on_the_enter_drug_information_button_from_plan_card_on_VP_page() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.clickAddDrugsPlancardNew();
	}

	@Then("^user should see back to drug cost estimator link on visitor profile page$")
	public void user_should_see_back_to_drug_cost_estimator_link_on_visitor_profile_page() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateBackToDceLink();
	}

	@Then("^the user clicks on Drug cost estimator link and validates Drug Details Page$")
	public void user_clicks_DCELink_and_validates_drugdetail_page() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateBackToDceLink();
		DrugDetailsPage drugDetailsPage = visitorProfile.clickBackToDCELink();
		if (null != drugDetailsPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
		} else
			Assertion.fail("Drug Details page not loaded");
	}

	@When("^user clicks on edit drugs button from plan card$")
	public void user_clicks_on_edit_drugs_button_from_plan_card() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.clickEditDrugsPlancard();
	}

	@When("^user clicks on edit drugs button globally$")
	public void user_clicks_on_edit_drugs_button_globally() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.clickEditDrugs();
	}

	@And("^user validates the added plans on new visitor profile page of AARP site$")
	public void user_validates_the_added_plans_on_new_visitor_profile_page_of_AARP_site(DataTable planNames) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planNames);
		/*List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String savePlanNames = givenAttributesMap.get("Test Plans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedPlansNew(savePlanNames);
	}

	@Then("^the user clicks on the enter drug information button from plan card to navigate to DCE Redesign$")
	public void the_user_clicks_on_the_enter_drug_information_button_from_plan_card_to_navigate_to_DCE_Redesign() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.clickAddDrugsPlancardNew();
	}

	@And("^the user navigates to Visitor profile page$")
	public void the_user_navigates_to_visitor_profile_page() {
		AcquisitionHomePage acqHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VisitorProfilePage visitorProfilePage = acqHomePage.navigateToNewVisitorProfilePage();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@And("^the user login with optum Id credentials$")
	public void the_user_login_with_optum_Id_credentials(DataTable credentials) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(credentials);
		/*List<DataTableRow> plannameAttributesRow = credentials.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String username = plannameAttributesMap.get("User Name");
		String password = plannameAttributesMap.get("Password");
		WebDriver driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		VisitorProfilePage visitorProfile = new VisitorProfilePage(driver);
		System.out.println("credentials" + username + password);
		visitorProfile.logIn(username, password);
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfile);
	}

	@Then("^user clears the existing drugs in Visitor profile$")
	public void user_clears_the_existing_drugs_in_visitor_profile() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.clearDrugs();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfile);
	}

	@Then("^user clears the provider in visitor profile page$")
	public void user_clears_the_provider_in_visitor_profile_page() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.clearProvider();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfile);
	}

	@And("^user clicks on home menu from Visitor profile page$")
	public void user_clicks_on_home_from_visitor_profile_page() {
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		AcquisitionHomePage acquisitionHomePage = visitorProfilePage.clickHomeMenu();
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, acquisitionHomePage);
	}

	@Then("^user verify breadcrumb \"([^\"]*)\" on the visitor profile page$")
	public void user_verify_breadcrumb_on_the_visitor_profile_page(String breadcrumb) {
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.verifyBreadCrumb(breadcrumb);
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	@Then("^the user deletes all the added drugs from profile page$")
	public void user_deletes_all_the_added_drugs_from_profile_page(DataTable drugList) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(drugList);
		/*List<DataTableRow> givenAttributesRow = drugList.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String drugs = givenAttributesMap.get("DrugName");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deleteAllDrugs(drugs);
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfile);
	}
	
	@Then("^Verify X out of Y provider covered information is displayed on legacy visitor profile page$")
	public void verify_providers_covered_legacy_visitor_profile(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("PlanName");

		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		Assertion.assertTrue(visitorProfile.legacyProviderinfo(planName));
	}
	
	@And("^validate the new profile header$")
	public void validate_the_new_profile_header(DataTable data) {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateNewHeader(data);
		
	}
}
