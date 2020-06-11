package acceptancetests.vbfacquisition_deprecated.dce;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.vbfacquisition_deprecated.bluelayer.AcquisitionHomePage;
import pages.vbfacquisition_deprecated.bluelayer.DrugCostEstimatorPage;
import pages.vbfacquisition_deprecated.bluelayer.VPPPlanSummaryPage;

/**
 *Functionality: DCE Acquisition 
 */
public class DCEAcqStepDefinitionUHC {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	/**
	 * @toDo:user is on blayer medicare
	 */
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
	
	/**
	 * @toDo:access the acquisition DCE tool from home page
	 */
	@When("^I access the acquisition DCE tool from home page on ums site$")
	public void I_access_the_DCE_tool_home_page() throws InterruptedException {

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) loginScenario.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToDCEToolFromHome();
	}
	
	/**
	 * @toDo:access the vpp page using below zipcode
	 */
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
	
	/**
	 * @toDo:choose the 2017 plan and go to DCE
	 */
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
		
		
		plansummaryPage.clickOnViewPlans(plantype);
		boolean yearBtnVppPageExists = plansummaryPage.yearBtnExists();
		loginScenario.saveBean(CommonConstants.YEAR_BUTTON_VPPPAGE, yearBtnVppPageExists);
		if(yearBtnVppPageExists){
			plansummaryPage.choose2017Plans();
		}
		DrugCostEstimatorPage dce = plansummaryPage.navigateToDCE(plantype);
		if(dce!=null){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	/**
	 * @toDo:access the DCE 
	 */
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
	
	/**
	 * @toDo:access the DCE tool after adding drug
	 */
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
	
	/**
	 * @toDo:ave added a drug to my drug list on ums site
	 */
	@When("^I have added a drug to my drug list on ums site$")
	public void I_have_added_a_drug_to_my_drug_list(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) loginScenario.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
			dce.addDrug(drug.split(" ")[0]);
			
			dce.aepyearselection();

	}

	/**
	 * @toDo:navigate to step2 page
	 */
	@And("^I navigate to step2 page on ums site$")
	public void I_navigate_to_step2_page () throws InterruptedException
	{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep2();
	}
	
	/**
	 * @toDo:user selects the pharmacy tab information
	 */
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
	
	/**
	 * @toDo:validate preferred retail pharmacy type is displayed
	 */
	@Then("^I validate preferred retail pharmacy type is displayed$")
	public void validatePreferredRetailPharmacy(){
		DrugCostEstimatorPage dce =  (DrugCostEstimatorPage) loginScenario.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		if(dce.verifyPharmacyRetailExists()){
			Assert.assertTrue(true);
		}else
			Assert.fail("Error in validating that the pharmacy retail pharmacy type exists");
	}
	
	/**
	 * @toDo:validate pharmacy saver pharmacy type is displayed
	 */
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
	
	/**
	 * @toDo:select the first pharmacy on there
	 */
	@When("^I select the first pharmacy on there$")
	public void I_select_the_drug() throws InterruptedException {

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.select_first_pharmacy();

	}
	
	/**
	 * @toDo:click on the return link
	 */
	@And("I click on the return link")
	public void clickOnReturnLink(){
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		AcquisitionHomePage acqhomepage = dce.clickOnReturnLink();
		System.out.println(acqhomepage);
	}
	
	/**
	 * @toDo:verify that the drug is still there
	 */
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
	
	/**
	 * @toDo:navigate to step3 page and validate the drug info
	 */
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
	
	@Then("^I navigate to step3 page and validate drug info for DCE homepage flow uhc$")
	public void I_navigate_to_step3_page(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep3();
	   if(dce.validateDrugOnStep3FromHomePageFlow(drug))
		   Assert.assertTrue(true);
	   else
		   Assert.fail("Error:the drug did not display on step 3 page"); 
	}
	
	/**
	 * @toDo:switch to generic drug and validate on ums site
	 */
	@Then("^I switch to generic drug and validate on ums site$")
	public void I_switch_to_generic_drug_and_validate() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickSwitchNow();
	}
	
	@And("^I hover or click on Our Plans in the top navigation and enter zipcode Blayer$")
	public void hover_on_Our_Plans_in_the_top_navigation(DataTable givenAttributes){
		DrugCostEstimatorPage dcePage = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipCode = memberAttributesMap.get("Zip Code");
		VPPPlanSummaryPage vppPage = dcePage.mouseHoverOurPlans(zipCode);
		if(vppPage!=null){
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppPage);
		}else{
			System.out.println("===========Page not returned============");
			Assert.fail();
		}
	}
	
	@Then("^I should be directed to the VPP Plan Summary Page Blayer and I should see the Plan Count Overlay populated appropriately$")
	public void should_be_directed_to_the_VPP_Plan_Summary_Page(){
		VPPPlanSummaryPage vppPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppPage.validatePlanSummary();
	}
	
}
