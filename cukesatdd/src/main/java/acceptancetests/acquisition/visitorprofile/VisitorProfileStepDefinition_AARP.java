package acceptancetests.acquisition.visitorprofile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.VisitorProfilePage;
/**
 * @author bnaveen4
 * Functionality:Visitor Profile for both AAPR and UHC acquisition sites
 */
public class VisitorProfileStepDefinition_AARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@And("^the user selects the state drop down value in AARP home page$")
	public void the_user_selects_the_state_drop_down_value_in_AARP_home_page(DataTable givenAttributes) {
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
	
	@And("^the user clicks on the shopping cart icon in AARP site$")
	public void the_user_clicks_on_the_shopping_cart_icon_in_AARP_site() {
		AcquisitionHomePage acqHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VisitorProfilePage visitorProfilePage = acqHomePage.navigateToVisitorProfilePage();
		
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	@And("^the user clicks on the add drugs button in the guest profile in AARP site$")
	public void the_user_clicks_on_the_add_drugs_button_in_the_guest_profile_in_AARP_site() {
		
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		DrugCostEstimatorPage dcePage = visitorProfilePage.addDrug();
		
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dcePage);
	}
	
	@And("^the user clicks on the add plans button in the guest profile in AARP site$")
	public void the_user_clicks_on_the_add_plans_button_in_the_guest_profile_in_AARP_site() {
		
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().
				getBean(PageConstants.VISITOR_PROFILE_PAGE);

		AcquisitionHomePage acqPage = visitorProfilePage.addPlan();
		
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, acqPage);
	}
	
	@And("^the user returns to the visitor profile page$")
	public void the_user_returns_to_the_visitor_profile_page() {
		
		DrugCostEstimatorPage dcePage = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		VisitorProfilePage visitorProfilePage = dcePage.retrunToProfile(); 
		
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	
	@And("^the user should be able to see the Drug and pharmacy information in the guest profile page$")
	public void the_user_should_be_able_to_see_the_Drug_and_pharmacy_information_in_the_guest_profile_page(DataTable data) {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedDrugAndPharmacy(drug);
	}
	
	@And("^user validates the added plans on visitor profile page of AARP site$")
	public void user_validates_the_added_plans_on_visitor_profile_page_of_AARP_site(DataTable planNames) {
		List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String savePlanNames = givenAttributesMap.get("MA Test Plans");
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateAddedPlans(savePlanNames);
	}
	
	@And("^the user clicks on the shopping cart icon on DCE page in AARP$")
	public void the_user_clicks_on_the_shopping_cart_icon_on_DCE_page_in_AARP() {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		VisitorProfilePage visitorProfilePage = dce.clickOnShoppingCart();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	@And("^user clicks on plan name in AARP$")
	public void user_clicks_on_plan_name_in_AARP(DataTable planNames) {
		List<DataTableRow> givenAttributesRow = planNames.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String planName = givenAttributesMap.get("MA Test Plans");
		VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario().getBean(PageConstants.VISITOR_PROFILE_PAGE);
		PlanDetailsPage planDetails = visitorProfilePage.navigateToPlanDetails(planName.split(",")[0]);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetails);
	}
} 

