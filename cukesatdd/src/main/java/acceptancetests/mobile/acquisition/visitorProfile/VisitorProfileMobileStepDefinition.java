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
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.DrugCostEstimatorPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.commonpages.VisitorProfileTestHarnessPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
/**
 * @author bnaveen4
 * Functionality:Visitor Profile for both AAPR and UHC acquisition sites
 */
public class VisitorProfileMobileStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@And("^the user selects the state drop down value in home page mobile$")
	public void the_user_selects_the_state_drop_down_value_in_AARP_home_pages(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String state = givenAttributesMap.get("State");
		AcquisitionHomePageMobile acqHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

//		CommonConstants.SELECTED_STATE  = state; 
		CommonConstants.setSelectedState(state);
		
		acqHomePage.selectState(state);
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
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deletePlans(savedPlanNames);
	}
	
	@And("^the user clicks on the shopping cart icon mobile$")
	public void the_user_clicks_on_the_shopping_cart_icon_in_AARP_site() {
		AcquisitionHomePageMobile acqHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VisitorProfilePageMobile visitorProfilePage = acqHomePage.navigateToVisitorProfilePage();
		
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	@And("^the user clicks on the add drugs button to navigate to DCE Redesign on the profile page mobile$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_profile_to_DCE_Redesign_in_AARP_site1() throws InterruptedException {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		GetStartedPageMobile getStartedPage = visitorProfilePage.addDrug_DCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");

	}	
	
	
	@And("^the user clicks on the add drugs button in the profile$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_profile_in_AARP_site() {
		
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		GetStartedPage dcePage = visitorProfilePage.addDrug_DCERedesign();
		
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dcePage);
	}
	
	@And("^the user clicks on the add plans button in the profile$")
	public void the_user_clicks_on_the_add_plans_button_in_the_profile_in_AARP_site() throws Exception {
		
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		AcquisitionHomePageMobile acqPage = visitorProfilePage.addPlan();
		
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acqPage);
	}
	
	@And("^the user clicks on the add plans button in the profile in agent mode$")
	public void the_user_clicks_on_the_add_plans_button_in_the_profile_in_agent_mode_in_AARP_site() throws Exception {
		
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		VPPPlanSummaryPage planSummary = visitorProfilePage.addPlanForMember();
		planSummary.handlePlanYearSelectionPopup();
		
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, planSummary);
	}
	
	@When("^the user enters zipcode on health plans page$")
	public void enters_zipcode_details_in_aarp_site(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
	
//	@Then("^Navigate to Visitor Profile page$")
//	public void navigate_to_Visitor_Profile_page() {
//		ComparePlansPageMobile comparePlansPage = (ComparePlansPageMobile) getLoginScenario()
//				.getBean(PageConstants.PLAN_COMPARE_PAGE);
//		getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
//		VisitorProfilePageMobile visitorProfilePage = comparePlansPage.navigateToVisitorProfilePage();
//		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
//	}
	
	@Then("^Navigate to Visitor Profile page$")
	public void navigate_to_Visitor_Profile_page_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		VisitorProfilePageMobile visitorProfilePage = plansummaryPage.navigateToVisitorProfilePage1();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	
	@And("^the user returns to the visitor profile page$")
	public void the_user_returns_to_the_visitor_profile_page() {
		
		DrugCostEstimatorPage dcePage = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		VisitorProfilePage visitorProfilePage = dcePage.retrunToProfile(); 
		
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	
	@And("^the user should be able to see the Drug information in the guest profile page$")
	public void the_user_should_be_able_to_see_the_Drug_information_in_the_guest_profile_page(DataTable data) {
		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);*/
		String drug = data.cell(0, 1);
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
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
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedPlans(savePlanNames);
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
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedMsPlans(savePlanNames);
	}
	
	@And("^the user should be able to see all the added Drugs information in the guest profile page$")
	public void the_user_should_be_able_to_see_all_the_added_Drugs_information_in_the_guest_profile_page(DataTable data) {
		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drugList = memberAttributesRow.get(0).getCells().get(1);*/
		String drugList = data.cell(0, 1);
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
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
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedPlansPDFLinks(savePlanNames);
	}
	
	@And("^the user clicks on the shopping cart icon on DCE page$")
	public void the_user_clicks_on_the_shopping_cart_icon_on_DCE_page_in_AARP() {
		GetStartedPageMobile dce = (GetStartedPageMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_GetStarted);
		VisitorProfilePageMobile visitorProfilePage = dce.clickOnShoppingCart();
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
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		PlanDetailsPageMobile planDetails = visitorProfilePage.navigateToPlanDetails(planName.split(",")[0]);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetails);
		System.out.println(planDetails);
	}
	
	
	@Then("^user saves two ms plans as favorite mobile$")
	public void user_saves_two_ms_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}*/

//		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ms_savePlanNames = memberAttributesMap.get("MS Test Plans");

		//----- MS plan type ----------------------------
		plansummaryPage.saveMSPlans(ms_savePlanNames);

	}
	@Then("^the user validates the following Additional Benefits of Plan for the plan$")
	public void the_user_validates_the_following_Additional_Benefits_of_Plan_for_the_plan_in_AARP(DataTable givenAttributes) throws Throwable {
//		List<DataTableRow> additionalBenefits = givenAttributes.getGherkinRows();
		List<List<String>> additionalBenefits = givenAttributes.asLists();
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		System.out.println("vapp plan details page"+ PageConstants.VPP_PLAN_DETAILS_PAGE+ vppPlanDetailsPage);
		vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(additionalBenefits);
	}
	
	
//	@And("^user deletes the added plans on visitor profile page$")
//	public void user_delets_the_added_plans_on_visitor_profile_page_of_AARP_site(DataTable planNames) {
//		List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
//		Map<String, String> givenAttributesMap = new HashMap<String, String>();
//		for (int i = 0; i < givenAttributesRow.size(); i++) {
//
//			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
//					givenAttributesRow.get(i).getCells().get(1));
//		}
//		String savedPlanNames = givenAttributesMap.get("Test Plans");
//		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
//		visitorProfile.deletePlans(savedPlanNames);
//	}
	
	@Then("^user saves two plans as favorite$")
	public void user_saves_two_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}*/
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

		VisitorProfilePageMobile visitorProfilePage = plansummaryPage.continueAsGuest();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);

	}
	@And("^user delets all the added drugs on visitor profile page$")
	public void user_delets_all_the_added_drugs_on_visitor_profile_page_of_AARP_site() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deleteAllDrugs();
	}
	
	@And("^user clicks on Edit Drug and Pharmacy on visitor profile page$")
	public void user_clicks_on_Edit_Drug_and_Pharmacy_on_visitor_profile_page() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		BuildYourDrugList DCEbuildDrugList = visitorProfile.clickOnEditDrugAndPharmacy();
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, DCEbuildDrugList);
	}
	
	@And("^user delets all the added providers on visitor profile page$")
	public void user_delets_all_the_added_providers_on_visitor_profile_page_of_AARP_site(DataTable Planname) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname
				.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells()
					.get(0), plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("PlanName");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deleteProviders(planName);
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

		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		Assertion.assertTrue("Provider coverage Info not updated", visitorProfile.providerinfo(planName));
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
		
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.signIn(username, password);
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfile);
	}
	
	@And("^enroll In Plan should not be clickable on Visitor Profile page in Agent mode$")
	public void next_button_should_not_be_clickable_on_OLE_welcome_page_in_Agent_mode() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
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
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
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
		//VisitorProfilePage visitorProfilePage = vpTestHarnessPage.DeleteplaninVisitorProfile(planID);
		//getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
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
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		
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
		
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		VPPPlanSummaryPageMobile planSummary = visitorProfilePage.backToPlans();
		
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, planSummary);
		System.out.println("afaknfkanfklnasknfkanfklanssfka"+planSummary);
	}
	
	@And("^validate OLE details$")
	public void validate_OLE_details(DataTable oleDetails) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(oleDetails);
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
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
		
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.cancelEnrollment(planName);
	}
} 



