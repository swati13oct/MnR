package acceptancetests.fixedtestcases;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;

/**
 * @author pperugu
 *
 */

public class DceVppUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on blayer medicare acq site landing page$")
	public void the_user_is_on_UMS_medicare_site_landing_page() {
		
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		
	}
	
	@When("^I access the acquisition DCE tool from home page on ums site$")
	public void I_access_the_DCE_tool_home_page() throws InterruptedException {

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) loginScenario.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToDCEToolFromHome();;
	}
	
	@When("^I access the vpp page using below zipcode on ums site$")
	public void I_access_the__vpp_page(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.navigateToVpp(zipcode);
		if(plansummaryPage!=null){
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}
	}
	
	
	@And("^I choose the 2017 plan and go to DCE page$")
	public void choosing2017Plan(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean yearBtnVppPageExists = plansummaryPage.yearBtnExists();
		loginScenario.saveBean(CommonConstants.YEAR_BUTTON_VPPPAGE, yearBtnVppPageExists);
		plansummaryPage.clickOnViewPlans(plantype);
		if(yearBtnVppPageExists){
			plansummaryPage.choose2017Plans();
		}
		DrugCostEstimatorPage dce = plansummaryPage.navigateToDCE(plantype);
		if(dce!=null){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	@And("^I access the DCE tool$")
	public void accessDCETool(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickOnViewPlans(plantype);
		DrugCostEstimatorPage dce = plansummaryPage.navigateToDCE(plantype);
		if(dce!=null){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	@And("^I access the DCE tool after adding drug$")
	public void accessDCEToolAfterDrugAdded(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		DrugCostEstimatorPage dce = plansummaryPage.navigateToDCEAfterDrugAdded(plantype);
		if(dce!=null){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	
	@When("^I have added a drug to my drug list on ums site$")
	public void I_have_added_a_drug_to_my_drug_list(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) loginScenario.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
			dce.addDrug(drug.split(" ")[0]);

	}

	@And("^I navigate to step2 page on ums site$")
	public void I_navigate_to_step2_page () throws InterruptedException
	{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep2();
	}
	@And("^the user selects the pharmacy tab information$")
	public void navigate_drugcostestimator_pharmacytab(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zipcode");
		String radius = memberAttributesMap.get("Radius");
		
		DrugCostEstimatorPage dce =  (DrugCostEstimatorPage) loginScenario.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		
		dce.pharmacyInformation(zipcode,radius);
	}
	
	@Then("^I validate preferred retail pharmacy type is displayed$")
	public void validatePreferredRetailPharmacy(){
		DrugCostEstimatorPage dce =  (DrugCostEstimatorPage) loginScenario.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		if(dce.verifyPharmacyRetailExists()){
			Assert.assertTrue(true);
		}else
			Assert.fail("Error in validating that the pharmacy retail pharmacy type exists");
	}
	
	@Then("^I validate pharmacy saver pharmacy type is displayed$")
	public void validatePharmacySaverPharmacy(){
		DrugCostEstimatorPage dce =  (DrugCostEstimatorPage) loginScenario.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		boolean isYear2017 = (Boolean)loginScenario.getBean(CommonConstants.YEAR_BUTTON_VPPPAGE);
		if(isYear2017){
			if(dce.verifyPharmacySaverExists()){
				Assert.assertTrue(true);
			}else
				Assert.fail("Error in validating that the pharmacy retail pharmacy type exists");
		}
	}
	
	@When("^I select the first pharmacy on there$")
	public void I_select_the_drug() throws InterruptedException {

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.select_first_pharmacy();

	}
	
	@And("I click on the return link")
	public void clickOnReturnLink(){
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		AcquisitionHomePage acqhomepage = dce.clickOnReturnLnk();
		
	}
	
	@Then("I verify that the drug is still there")
	public void verifyDrugIsStillThere(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String drugName = memberAttributesMap.get("Drug");
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		if(dce.isDrugPresent(drugName))
			Assert.assertTrue(true);
		else
			Assert.fail("Error in validating that the drug is still there");
	}
	
	@Then("^I navigate to step3 page and validate the drug info$")
	public void I_navigate_to_step_page(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep3();
	   if(dce.validateDrugOnStep3(drug))
		   Assert.assertTrue(true);
	   else
		   Assert.fail("Error:the drug did not display on step 3 page"); 
	}
	
	@Then("^I switch to generic drug and validate on ums site$")
	public void I_switch_to_generic_drug_and_validate() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickSwitchNow();
	}

}
