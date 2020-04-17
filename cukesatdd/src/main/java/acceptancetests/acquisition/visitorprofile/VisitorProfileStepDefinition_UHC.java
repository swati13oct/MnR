package acceptancetests.acquisition.visitorprofile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.bluelayer.VisitorProfilePage;
import pages.acquisition.bluelayer.VisitorProfileTestHarnessPage;
/**
 * @author bnaveen4
 * Functionality:Visitor Profile for both AAPR and UHC acquisition sites
 */
public class VisitorProfileStepDefinition_UHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@And("^the user selects the state drop down value in UHC home page$")
	public void the_user_selects_the_state_drop_down_value_in_UHC_home_page(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String state = givenAttributesMap.get("State");
		AcquisitionHomePage acqHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		acqHomePage.selectState(state);
	}
	
	@And("^the user clicks on the shopping cart icon in UHC site$")
	public void the_user_clicks_on_the_shopping_cart_icon_in_UHC_site() {
		AcquisitionHomePage acqHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VisitorProfilePage visitorProfilePage = acqHomePage.navigateToVisitorProfilePage();
		
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	
	@And("^the user clicks on the add drugs button in the guest profile in UHC site$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_guest_profile_in_UHC_site() {
		
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		DrugCostEstimatorPage dcePage = visitorProfilePage.addDrug();
		
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dcePage);
	}
	
	@And("^the user validates the plan year buttons are present or not and chooses the plan year in UHC$")
	public void the_user_validates_planyear_buttons_in_the_guest_profile_in_UHC_site(DataTable givenAttributes) {
		
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planYear = memberAttributesRow.get(0).getCells().get(1);

		visitorProfilePage.validateAndChoosePlanYear(planYear);
		
	}
	
	
	@And("^the user clicks on the add plans button in the guest profile in UHC site$")
	public void the_user_clicks_on_the_add_plans_button_in_the_guest_profile_in_UHC_site() {
		
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		AcquisitionHomePage acqPage = visitorProfilePage.addPlan();
		
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acqPage);
	}
	
	@And("^the user returns to the visitor profile page in UHC$")
	public void the_user_returns_to_the_visitor_profile_page_in_UHC() {
		
		DrugCostEstimatorPage dcePage = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		VisitorProfilePage visitorProfilePage = dcePage.retrunToProfile(); 
		
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	
	@And("^the user should be able to see the Drug and pharmacy information in the profile page on UHC$")
	public void the_user_should_be_able_to_see_the_Drug_and_pharmacy_information_in_the_guest_profile_page_on_UHC(DataTable data) {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedDrugAndPharmacy(drug);
	}
	
	@And("^user validates the added plans on visitor profile page of UHC site$")
	public void user_validates_the_added_plans_on_visitor_profile_page_of_UHC_site(DataTable planNames) {
		List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String savePlanNames = givenAttributesMap.get("Test Plans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedPlans(savePlanNames);
	}
	
	@And("^user validates the added MS plans on visitor profile page of UHC site$")
	public void user_validates_the_MS_added_plans_on_visitor_profile_page_of_UHC_site(DataTable planNames) {
		List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String savePlanNames = givenAttributesMap.get("MS Test Plans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedMsPlans(savePlanNames);
	}
	
	@And("^the user clicks on the shopping cart icon on DCE page$")
	public void the_user_clicks_on_the_shopping_cart_icon_on_DCE_page() {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		VisitorProfilePage visitorProfilePage = dce.clickOnShoppingCart();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	@And("^user clicks on plan name of UHC site$")
	public void user_clicks_on_plan_name(DataTable planNames) {
		List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String planName = givenAttributesMap.get("Test Plans");
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		PlanDetailsPage planDetails = visitorProfilePage.navigateToPlanDetails(planName.split(",")[0]);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetails);
	}
	
	@And("^the user signs in with optum Id credentials in UHC site$")
	public void the_user_signs_in_with_optum_Id_credentials_in_UHC_site(DataTable credentials) {
		List<DataTableRow> plannameAttributesRow = credentials.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String username = plannameAttributesMap.get("User Name");
		String password = plannameAttributesMap.get("Password");
		
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.signIn(username, password);
	}
	
	@And("^user delets all the added drugs on visitor profile page of UHC site$")
	public void user_delets_all_the_added_drugs_on_visitor_profile_page_of_UHC_site() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deleteAllDrugs();
	}
	
	@And("^user delets the added plans on visitor profile page of UHC site$")
	public void user_delets_the_added_plans_on_visitor_profile_page_of_UHC_site(DataTable planNames) {
		List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String savedPlanNames = givenAttributesMap.get("testPlans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deletePlans(savedPlanNames);
	}
	
	@And("^user verifies plan count on shopping cart Icon on UHC site$")
	public void user_validates_plan_count_on_shopping_cart_Icon_on_UHC_site(DataTable givenAttributes) {
		List<DataTableRow> plannameAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String planCount = plannameAttributesMap.get("Plans Count");
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.validatePlanCountOnCartIcon(planCount);
	}
	
	@And("^user switch back to Vp Testharness Page on UHC site$")
	public void user_switch_back_to_Vp_Testharness_Page_on_UHC_site() {
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.switchBackToVPTestharness();
	}

	@And("^user Enters Plan id and click on delete plan to Delete plan in Visitor Profile on UHC site$")
	public void user_EntersPlanidandclickondeleteplantoDeleteplaninVisitorProfile_on_UHC_site(
			DataTable givenAttributes) {
		List<DataTableRow> plannameAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String planID = plannameAttributesMap.get("Plan ID");
		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePage visitorProfilePage = vpTestHarnessPage.DeleteplaninVisitorProfile(planID);
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
} 


