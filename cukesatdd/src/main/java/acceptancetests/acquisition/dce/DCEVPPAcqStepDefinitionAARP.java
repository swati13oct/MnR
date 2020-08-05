package acceptancetests.acquisition.dce;

import gherkin.formatter.model.DataTableRow;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.ComparePlansPageBlayer;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AddDrugDetails;
import pages.acquisition.ulayer.ComparePlansPage;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.SavingsOppurtunity;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality:DCE Acquisition
 */
public class DCEVPPAcqStepDefinitionAARP {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	WebDriver wd;
	
	/*DCE cost Estimator*/
	String cost;
	
	/*Prescription Drug tab*/
	String estimatedTotalAnnualCost;
	
	/*Plan Cost tab*/
	String planCostTabEstimatedTotalAnnualCost;
	
	/**
	 * @toDo:user is on AARP medicare acquisition site landing page
	 */
	@Given("^the user is on the AARP medicare site landing page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^user performs plan search using following information in the AARP site$")
	public void zipcode_details_in_aarp_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County");
		String aep = memberAttributesMap.get("aep");
		String currentyear = memberAttributesMap.get("currentyear");
		
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.navigateToVpp(
				zipcode);
		
		if(aep.equalsIgnoreCase("yes")){
			if(currentyear.equalsIgnoreCase("yes")){
				
			}else{
				
			}
			
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	/**
	 * @toDo:user validates plan count for all plan types on plan summary page 
	 */
	@Then("^validates plan count for all plan types on plan summary page in the AARP site$")
	public void user_validates_following_benefits_ui_aarp() {

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if (plansummaryPage.validateVPPPlanSummaryPage()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error validating plans in  VPP plan summary page");
		}
	}
		
	/**
	 * @throws InterruptedException 
	 * @toDo:
	 */
	@And("^user access DCE tool on aarp site$")
	public void accessDCETool(DataTable attributes) throws InterruptedException{
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		String planName = memberAttributesMap.get("PlanName");
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.viewPlanSummary(plantype);
		//DrugCostEstimatorPage dce=plansummaryPage.navigateToDCEFromVPP(plantype,planName);
		DrugCostEstimatorPage dce=plansummaryPage.navigatetoDCEVPP(planName);
		if(dce!=null){
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	/**
	 * @toDo:
	 */
	@And("^I verify the plan name in AARP$")
	public void verifyPlanName(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planname = memberAttributesMap.get("Plan Name");

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.verifyplanname(planname);
		if(dce!=null){
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	@Then("^user adds drug to drug cost estimator flow for the given plan name in AARP site$")
	public void the_user_adds_below_drugs_to_drug_cost_estimator_flow_for_the_given_plan_name_on_AARP_site(DataTable data) throws Throwable {
		
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(1).getCells().get(1);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		boolean isDrugPresent = dce.isDrugPresent(drug);
		if(!isDrugPresent){
			AddDrugDetails addDrugDetails= dce.addDrug(drug.split(" ")[0]);
			if (null != addDrugDetails) {
				getLoginScenario().saveBean(PageConstants.ADD_DRUG_DETAILS, addDrugDetails);
			} else
				Assert.fail("Drug Details content not loaded");
		}

	}
	
	
	/**
	 * @toDo:
	 */
	@And("^selects drug details in ums site$")
	public void user_selects_drug_details(DataTable data) throws InterruptedException {
		
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		String quantity = memberAttributesRow.get(1).getCells().get(1);
		String frequency = memberAttributesRow.get(2).getCells().get(1);

		AddDrugDetails DrugDetails = (AddDrugDetails) getLoginScenario().getBean(PageConstants.ADD_DRUG_DETAILS);
		
	/*	if(drug.equalsIgnoreCase("Lipitor"))
			DrugDetails.selectDosageAttribute("//li[@data-index='1']");*/
			
		DrugDetails.selectDosageAttribute(drug);
		DrugDetails.selectQnty(quantity);
		DrugDetails.selectFrequency(frequency);		
	}
	
	/**
	 * @toDo:
	 */
	/**/
	@And("^selects drug details for other drugs in ums site$")
	public void user_selects_drug_details_for_other_drugs(DataTable data) throws InterruptedException {
		
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		String quantity = memberAttributesRow.get(1).getCells().get(1);
		String frequency = memberAttributesRow.get(2).getCells().get(1);

		AddDrugDetails DrugDetails = (AddDrugDetails) getLoginScenario().getBean(PageConstants.ADD_DRUG_DETAILS);
		
	/*	if(drug.equalsIgnoreCase("Lipitor"))
			DrugDetails.selectDosageAttribute("//li[@data-index='1']");*/
			
		DrugDetails.selectDosageAttribute(drug);
		DrugDetails.selectQnty(quantity);
		DrugDetails.selectFrequency(frequency);	
		
		DrugDetails.continueAddDrugDetailsModNoSaving();
	
	}
	@When("^user successfully adds drug in the ums site$")
	public void user_successfully_adds_drug(DataTable data) throws InterruptedException {

		AddDrugDetails DrugDetails = (AddDrugDetails) getLoginScenario().getBean(PageConstants.ADD_DRUG_DETAILS);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		
		
		//SavingsOppurtunity savingsOppurtunity = DrugDetails.continueAddDrugDetailsModWithSaving();
		
		DrugDetails.continueAddDrugDetailsModNoSaving();
		SavingsOppurtunity savingsOppurtunity=new SavingsOppurtunity(wd);
		dce = savingsOppurtunity.savedrugbutton();
		
		if (null != savingsOppurtunity) {
			getLoginScenario().saveBean(PageConstants.SAVING_OPPORTUNITY, savingsOppurtunity);
		}
		
		/*
		String drug = memberAttributesMap.get("Drug Name1");
		AddDrugDetails DrugDetails = (AddDrugDetails) getLoginScenario().getBean(PageConstants.ADD_DRUG_DETAILS);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		if (isBranded.trim().equalsIgnoreCase("YES")) {

			SavingsOppurtunity savingsOppurtunity = DrugDetails.continueAddDrugDetailsModWithSaving();
			//savingsOppurtunity.switchToGeneric();
			dce = savingsOppurtunity.savedrugbutton();

		} else {
			dce = DrugDetails.continueAddDrugDetailsModNoSaving();
		}
		Assert.assertTrue("Drug not added", null != dce);
		dce.validateAddedDrug(drug);*/
	}
	
	// Only for Saver Pop-up from DCE test Harness
	@When("^user successfully adds drug in the AMS site for TestHarness$")
	public void user_successfully_adds_drug_TestHarness(DataTable data) throws InterruptedException {

		AddDrugDetails DrugDetails = (AddDrugDetails) getLoginScenario().getBean(PageConstants.ADD_DRUG_DETAILS);
		//SavingsOppurtunity savingsOppurtunity = DrugDetails.continueAddDrugDetailsModWithSaving();
		SavingsOppurtunity savingsOppurtunity = DrugDetails.continueAddDrugDetailsModWithSaving();
		DrugCostEstimatorPage dce = savingsOppurtunity.savedrugbutton();
		
		if (null != dce) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	@And("^then user adds other drugs$")
	public void then_user_adds_other_drugs(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		
		int count=memberAttributesRow.size();
		
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		
		
		for(int i=0; i<count;i++) {
			dce.addDrugs(1, memberAttributesRow.get(0).getCells().get((i+1)));
			
		}
		
		
		
		
		//SavingsOppurtunity savingsOppurtunity = DrugDetails.continueAddDrugDetailsModWithSaving();
		
		
		
		/*
		String drug = memberAttributesMap.get("Drug Name1");
		AddDrugDetails DrugDetails = (AddDrugDetails) getLoginScenario().getBean(PageConstants.ADD_DRUG_DETAILS);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		if (isBranded.trim().equalsIgnoreCase("YES")) {

			SavingsOppurtunity savingsOppurtunity = DrugDetails.continueAddDrugDetailsModWithSaving();
			//savingsOppurtunity.switchToGeneric();
			dce = savingsOppurtunity.savedrugbutton();

		} else {
			dce = DrugDetails.continueAddDrugDetailsModNoSaving();
		}
		Assert.assertTrue("Drug not added", null != dce);
		dce.validateAddedDrug(drug);*/
	}
	

	@Then("^the user clicks on the Pick a pharmacy button in the DCE flow in AARP site$")
	public void the_user_clicks_on_the_Pick_a_pharmacy_button_in_the_DCE_flow_in_AARP_site() throws Throwable {
		
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		
		dce.pickAPharmacy();
	}

	@When("^the user selects the pharmacy type and distance in AARP site$")
	public void the_user_selects_the_pharmacy_type_and_distance_in_AARP_site(DataTable data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacyType = memberAttributesRow.get(0).getCells().get(1);
		String distance = memberAttributesRow.get(1).getCells().get(1);
		
		
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		
		dce.selectRadius(dce.getMilesSelection(),distance);
		dce.selectPharmacyType(pharmacyType);
				
		
	}

	@Then("^the user selects a pharmacy from the list of pharmacies in AARP site$")
	public void the_user_selects_a_pharmacy_from_the_list_of_pharmacies_in_AARP_site(DataTable data) throws Throwable {
		
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacyName = memberAttributesRow.get(0).getCells().get(1);
		
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
	    dce.verifyPharmacyResults();
	   for(int i=0;i<dce.getLstPharmacyNames().size();i++)
	    if(dce.getLstPharmacyNames().get(i).getText().toLowerCase().contains(pharmacyName.toLowerCase())) {
	    	dce.getLstSelectPharmacy().get(i).click();
	    	break;
	    	    }	    	
	   
	   dce.clickButtonViewCost();
	}

	@Then("^the user validates the added drugs on See your Estimated Costs page in AARP site$")
	public void the_user_validates_the_added_drugs_on_See_your_Estimated_Costs_page_in_AARP_site(DataTable data) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		
		cost=dce.getCostText().getText();
		/*if(cost.contains("$"))
			cost=cost.split("$")[1];*/
		
		String drug = null;
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		for(int i=0;i<memberAttributesRow.size();i++) {
			drug=memberAttributesRow.get(i).getCells().get(1).toLowerCase().trim();
			if(dce.getHdrDrugName().get(i).getText().toLowerCase().trim().split(" ")[0].contains(drug.split(" ")[0].trim().toLowerCase()))
				Assert.assertTrue(dce.getHdrDrugName().get(i).getText().toLowerCase().trim() +"is found",true);
				else 
					Assert.assertTrue(dce.getHdrDrugName().get(i).getText().toLowerCase().trim() +"isn't found",false);
		}
		
		
		//dce.validateTotalEstimatedAnnualDrugCosts(totalAnnualDrugCost);
	}

	@When("^the user clicks on Edit Drug List link in AARP site$")
	public void the_user_clicks_on_Edit_Drug_List_link_in_AARP_site() throws Throwable {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickEditDrugList();
		
		
	    
	}

	@Then("^Enter your drugs page is displayed to the user in AARP site$")
	public void enter_your_drugs_page_is_displayed_to_the_user_in_AARP_site() throws Throwable {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		
		Assert.assertEquals("Find A Pharamcy line is not present, pick a pharmacy section isn't displayed", true,
				dce.getLblCreateAListOfThePrescriptionDrug().isDisplayed());
		
	}

	@Then("^User click on Switch now to select the Generic of the Brand drug added in AARP site$")
	public void user_click_on_Switch_now_to_select_the_Generic_of_the_Brand_drug_added_in_AARP_site() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickSwitchNUpdateAll();
		
		
		
		
	}

	@Then("^the user change the pharmacy type and select new pharmacy in AARP site$")
	public void the_user_change_the_pharmacy_type_and_select_new_pharmacy_in_AARP_site(DataTable data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacyType = memberAttributesRow.get(0).getCells().get(1);
		
		
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.selectPharmacyType(pharmacyType);
		dce.clickButtonViewCost();
	}
	
	@Then("^the user clicks on Back to Plans button in AARP site and Navigates to Plan Compare$")
	public void the_user_clicks_on_Back_to_Plans_button_in_AARP_site_and_Navigates_to_Plan_Compare() throws Throwable {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		ComparePlansPage planComparePage = dce.clickBtnBackToPlancompare();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
	}
	}
	
	@Then("^the user clicks on Back to Plans button in AARP site and Navigates to new Plan Compare$")
	public void the_user_clicks_on_Back_to_Plans_button_in_AARP_site_and_Navigates_to_new_Plan_Compare() throws Throwable {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		ComparePlansPage planComparePage = dce.clickBtnBackTonewPlancomparenew();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		}
	}

	@Then("^the user clicks on Back to Plans button in AARP site$")
	public void the_user_clicks_on_Back_to_Plans_button_in_AARP_site() throws Throwable {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickBtnBackToPlans();
	}
	
	@Then("^the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site$")
	public void the_user_clicks_on_Back_to_Plans_button_on_See_Your_Estimated_Costs_page_in_AARP_site() throws Throwable {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickBtnBackToPlansNavigateToDetails();
	}
	
	
	/*Cost comparison for prescription drugs*/
	@Then("^user verifies annual drug cost in the prescription drug tab of AARP site$")
	public void user_verifies_drug_cost_in_AARP_site(DataTable data) throws Throwable {
	
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String planType = memberAttributesRow.get(0).getCells().get(1);
		PlanDetailsPage plandetailspage= new PlanDetailsPage(wd,planType);
		
		estimatedTotalAnnualCost=plandetailspage.costComparisonPrescriptionDrugFromDCE();
		
		if(cost.trim().contains(estimatedTotalAnnualCost))
			Assert.assertTrue("It's a match on on prescription drug tab and Drug CostEstimator page",true);
		else
		Assert.assertTrue("Cost mismatch on prescription drug tab and drug CostEstimator page",false);
		
		//plandetailspage.navigateBackToPlanSummaryPageFromDetailsPage();
		
		getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE, plandetailspage);
		
	}
	
	/*Cost comparison for Plan Costs Tab*/
	@Then("^user verifies annual drug cost in the Plan Cost tab of AARP site$")
	public void user_verifies_annual_drug_cost_in_the_Plan_Cost_tab_of_AARP_site(DataTable data) throws Throwable {
	
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String planType = memberAttributesRow.get(0).getCells().get(1);
		PlanDetailsPage plandetailspage= new PlanDetailsPage(wd,planType);
		
		planCostTabEstimatedTotalAnnualCost=plandetailspage.costComparisonCostTabFromDCE();
		
		if(cost.trim().contains(planCostTabEstimatedTotalAnnualCost))
			Assert.assertTrue("It's a match on on prescription drug tab and Drug CostEstimator page",true);
		else
		Assert.assertTrue("Cost mismatch on prescription drug tab and drug CostEstimator page",false);
		
		//plandetailspage.navigateBackToPlanSummaryPageFromDetailsPage();
		
		getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE, plandetailspage);
		
	}
	
	/*Back To All Plans on prescription drug tab*/
	@Then("^the user clicks on Back to All Plans button present on details page in AARP site$")
	public void the_user_clicks_on_Back_to_All_Plans_button_present_AARP_sit() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.PLAN_DETAILS_PAGE);
			
		plandetailspage.navigateBackToPlanSummaryPageFromDetailsPage();
		
	}

	@Then("^user validates Drug information is reflected on plan summary page in AARP site$")
	public void user_validates_Drug_information_is_reflected_on_plan_summary_page_in_AARP_site(DataTable data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		
		String planName=memberAttributesRow.get(0).getCells().get(1);
		VPPPlanSummaryPage plansummaryPage =  new VPPPlanSummaryPage(wd);
			System.out.println(cost);
			System.out.println(plansummaryPage.getValEstimatedAnnualDrugCostValue(planName).getText().trim());
			
		if(cost.trim().contains(plansummaryPage.estimatedAnnualDrugCostVPP(planName)))
				Assert.assertTrue("It's a match on on VPP and Drug CostEstimator page",true);
		else
			Assert.assertTrue("Cost mismatch on VPP and drug CostEstimator page",false);
	}

	@Then("^the user navigates to the plan details for the given plan type in AARP site$")
	public void the_user_navigates_to_the_plan_details_for_the_given_plan_type_in_AARP_site(DataTable data) throws Throwable {
		wd.manage().window().maximize();
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String planType = memberAttributesRow.get(0).getCells().get(1);
		String planName=memberAttributesRow.get(1).getCells().get(1);
		VPPPlanSummaryPage plansummaryPage =  new VPPPlanSummaryPage(wd);
		plansummaryPage.viewPlanSummary(planType);
		PlanDetailsPage plandetailspage= (PlanDetailsPage)plansummaryPage.navigateToPlanDetails(planName, planType);
		if(plandetailspage!=null){
			getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE, plandetailspage);
		}
		
		
	}

	@Then("^the user navigates to Presciption Drug Benefits tab in AARP site$")
	public void the_user_navigates_to_Presciption_Drug_Benefits_tab_in_AARP_site() throws Throwable {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.PLAN_DETAILS_PAGE);
		DrugCostEstimatorPage dce =	(DrugCostEstimatorPage)plandetailspage.navigateToDCE();
		if(dce!=null){
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}


	@When("^the user clicks on Edit Pharmacy link in AARP site$")
	public void the_user_clicks_on_Edit_Pharmacy_link_in_AARP_site() throws Throwable {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validateEditDrugAndPharmacyLinks();
		dce.clickEditPharmacy();
	}

	@Then("^Pick a Pharmcy page is displayed to the user in AARP site$")
	public void pick_a_Pharmcy_page_is_displayed_to_the_user_in_AARP_site() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		
		Assert.assertEquals("Find A Pharamcy line is not present, pick a pharmacy section isn't displayed", true,
				dce.getLblFindAPharmacy().isDisplayed());
	}

	@Then("^the user navigates to Plan Costs tab in AARP site$")
	public void the_user_navigates_to_Plan_Costs_tab_in_AARP_site() throws Throwable {
		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.PLAN_DETAILS_PAGE);
				DrugCostEstimatorPage dce =	planDetailsPage.navigateToDCEThroughPlanCost();
		if(dce!=null){
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}

}