package acceptancetests.memberrdesignVBF.drugcostestimator;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.DrugCostEstimatorPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DrugcostestimatorUhcStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@When("^I access the page containing the DCE tool$")
	public void I_access_the_page_containing_the_DCE_tool() throws InterruptedException {
		DrugCostEstimatorPage dcePage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			dcePage = testHarness.navigateToDCEPage();
		} else {
			RallyDashboardPage rallyDashBoard = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			dcePage = rallyDashBoard.navigateToDCEPage();
		}
		if (null != dcePage) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE_VBF, dcePage);
		}

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^I navigate to step2 page$")
	public void I_navigate_to_step2_page() throws InterruptedException {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE_VBF);
		dce.navigateToStep2();

	}

	/***
	 * 
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@And("^I enter a US other territory zip code and click select$")
	public void I_enter_a_US_other_territory_zip_code_and_click_select(DataTable memberAttributes)
			throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("USOTZipcode");
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE_VBF);
		dce.pharmacyInformation(zipcode);
	}

	/***
	 * 
	 */
	@Then("^I should see preferred mail service radio button under pharmacy type$")
	public void I_should_see_preferred_mail_service_radio_button_under_pharmacy_type() {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE_VBF);
		dce.validatePreferredMailServiceRD();

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^I select first pharmacy from standard network pharmacy type$")
	public void I_select_this_pharmacy_from_standard_network_pharmacy_type() throws InterruptedException {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE_VBF);
		dce.selectPharmacyType("Standard Network");
		dce.select_first_pharmacy();

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@Then("^I should see that total estimated annual drug costs in summary section matches with left rail value$")
	public void I_should_see_that_total_estimated_annual_drug_costs_in_summary_section_matches_with_left_rail_value()
			throws InterruptedException {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE_VBF);

		dce.validateTotalEstimatedAnnualDrugCosts();

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^I navigate to step3 page$")
	public void I_navigate_to_step3_page() throws InterruptedException {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE_VBF);
		dce.navigateToStep3();

	}

	/***
	 * 
	 */
	@Then("I should be presented the option to switch to the generic option")
	public void I_should_be_presented_the_option_to_switch_to_the_generic_option() {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE_VBF);
		dce.validateSwitchGenericOption();
	}

	/***
	 * 
	 * @param data
	 * @throws InterruptedException
	 */
	@And("^I have added a drug to my drug list and a generic equivalent is available for the drug I have selected$")
	public void I_have_added_a_drug_to_my_drug_list_and_a_generic_equivalent_is_available_for_the_drug_I_have_selected(
			DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE_VBF);
		dce.deleteAllDrugs();
		dce.addDrug(drug);
	}

}
