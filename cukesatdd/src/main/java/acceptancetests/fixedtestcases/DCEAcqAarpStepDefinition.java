/**
 * 
 */
package acceptancetests.fixedtestcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;

import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;




/**
 * @author pjaising
 *
 */
public class DCEAcqAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on ulayer medicare acq site landing page$")
	public void the_user_is_on_AARP_medicare_site_landing_page() {
		
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
	}
	
	@When("^I access the acquisition DCE tool from home page$")
	public void I_access_the_DCE_tool_home_page() throws InterruptedException {

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) loginScenario.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToDCEToolFromHome();;
	}
	
	@When("^I access the vpp page using below zipcode on aarp site$")
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
	
	@And("^I go to the view plan details page and access DCE flow from prescription drugs tab$")
	public void clickOnViewPlanDetailsAndGoTODCE(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planName = memberAttributesMap.get("Plan Name");
		String planType = memberAttributesMap.get("Plan Type");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickonViewPlans();
		PlanDetailsPage plandetailspage = plansummaryPage.navigateToPlanDetails(planName, planType);
		DrugCostEstimatorPage dce = plandetailspage.navigateToDCE();
		if(dce!=null){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
			
		}
	}

	
	@And("^I access the DCE tool on aarp site$")
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
		DrugCostEstimatorPage dce = plansummaryPage.navigateToDCE(plantype);
		if(dce!=null){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	@When("^I have added a drug to my drug list$")
	public void I_have_added_a_drug_to_my_drug_list(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) loginScenario.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		boolean isDrugPresent = dce.isDrugPresent(drug);
		if(!isDrugPresent){
			dce.addDrug(drug.split(" ")[0]);
		}

	}

	@And("^I navigate to step2 page$")
	public void I_navigate_to_step2_page () throws InterruptedException
	{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep2();
	}
	@And("^the user selects the pharmacy tab information like miles, zipcode and pharmacy type$")
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
	
	@When("^I select the first pharmacy$")
	public void I_select_the_drug() throws InterruptedException {

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.select_first_pharmacy();
		
	}
	
	@And("I navigate back to plan summary page")
	public void navigateToPlanSummaryPage(){
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		VPPPlanSummaryPage vppplansummarypage = dce.clickOnReturnLink();
		if(vppplansummarypage!=null){
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppplansummarypage);
		}else
			Assert.fail("Error in loading the vpp summary page");
	}

	@Then("I navigate to view plan details page and click on add to compare box under prescription drugs tab and verify correct message")
	public void navigateToPlanDetailsPageAndVerify(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planName = memberAttributesMap.get("Plan Name");
		String planType = memberAttributesMap.get("Plan Type");
		VPPPlanSummaryPage vppsummarypage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		PlanDetailsPage plandetailspage = vppsummarypage.navigateToPlanDetails(planName, planType);
		if(plandetailspage!=null){
			if(plandetailspage.validateCompareBoxMessage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the correct compare box message");
		}else
			Assert.fail("Error in loading the plan details page");
	}

	
	@Then("^I navigate to step3 page and validate$")
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
	
	@Then("^I switch to generic drug and validate$")
	public void I_switch_to_generic_drug_and_validate() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickSwitchNow();
	}
	

}
