package acceptancetests.acquisition.dce;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.dce.ulayer.DCETestHarnessPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AddDrugDetails;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.SavingsOppurtunity;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
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
public class DCEAcqStepDefinitionAARP {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	/**
	 * @toDo:
	 */
	
	/**
	 * @toDo:
	 */
	@When("^I access the acquisition DCE tool from home page$")
	public void I_access_the_DCE_tool_home_page() throws InterruptedException {

		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DrugCostEstimatorPage dcePage = (DrugCostEstimatorPage) acquisitionHomePage.navigateToDCEToolFromHome();
		if (null != dcePage) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dcePage);
		} else
			Assert.fail("DCE page object not loaded");
	}
	
	/**
	 * @toDo:
	 */
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

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickonViewPlans();
		PlanDetailsPage plandetailspage = plansummaryPage.navigateToPlanDetails(planName, planType);
		DrugCostEstimatorPage dce = plandetailspage.navigateToDCE();
		if(dce!=null){
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
			
		}
	}

	/**
	 * @toDo:
	 */
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
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		DrugCostEstimatorPage dce = plansummaryPage.navigateToDCE(plantype);
		if(dce!=null){
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	/**
	 * @toDo:
	 */
	@When("^I have added a drug to my drug list$")
	public void I_have_added_a_drug_to_my_drug_list(DataTable data) throws InterruptedException {
		
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
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
	@And("^user selects drug details$")
	public void user_selects_drug_details(DataTable data) throws InterruptedException {
		
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String drug = memberAttributesMap.get("Drug");
		String dosage = memberAttributesMap.get("Dosage");
		String quantity = memberAttributesMap.get("Quantity");
		String frequency = memberAttributesMap.get("Frequency");
		dosage = drug+" "+dosage;
		AddDrugDetails DrugDetails = (AddDrugDetails) getLoginScenario().getBean(PageConstants.ADD_DRUG_DETAILS);
		DrugDetails.selectDosage(dosage);
		DrugDetails.selectQnty(quantity);
		DrugDetails.selectFrequency(frequency);		
	}
	
	/**
	 * @toDo:
	 */
	@When("^user successfully adds drug$")
	public void user_successfully_adds_drug(DataTable data) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String isBranded = memberAttributesMap.get("Is Branded Drug");
		String drug = memberAttributesMap.get("Drug");
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
		dce.validateAddedDrug(drug);
	}
	
	/**
	 * @toDo:
	 */
	@And("^I navigate to step2 page$")
	public void I_navigate_to_step2_page_aarp () throws InterruptedException
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
		
		DrugCostEstimatorPage dce =  (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		
		dce.pharmacyInformation(zipcode,radius);
	}
	
	/**
	 * @toDo:
	 */
	@When("^I select the first pharmacy$")
	public void I_select_the_drug() throws InterruptedException {

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.select_first_pharmacy();
		
	}
	
	/**
	 * @toDo:
	 */
	@And("I navigate back to plan details page and verify correct message shows when clicked on compare check box")
	public void navigateToPlanDetailsPage(){
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		PlanDetailsPage plandetailspage = dce.clickOnReturnLink();
		
		if(plandetailspage!=null){
			if(plandetailspage.validateCompareBoxMessage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the correct compare box message");
		}else
			Assert.fail("Error in loading the plan details page");
	}
	
	@Then("^I navigate to step3 page and validate for DCE homepage flow$")
	public void I_navigate_to_step3_page(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep3();
		Assert.assertTrue("Error:the drug did not display on step 3 page", dce.validateStep3FromHomePage(drug));
	}

	/**
	 * @toDo:
	 */
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
	
	/**
	 * @toDo:
	 */
	@Then("^I switch to generic drug and validate$")
	public void I_switch_to_generic_drug_and_validate() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickSwitchNow();
	}
	
	/**
	 * @toDo:
	 */
	@Then("^I switch the year to 2017 and change zipcode and verify that the pharmacy previously selected isn't there$")
	public void switchYearandCheckPharmacy(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zipcode");
		String radius = memberAttributesMap.get("Radius");
		
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		boolean yearBtnExists = dce.yearBtnExists();
		if(yearBtnExists){
			dce.switchYear();		
			dce.pharmacyInformation(zipcode,radius);
			if(!dce.isPharmacyStillSelected())
				Assert.assertTrue(true);
			else
				Assert.fail("The pharmacy is still selected. It shouldn't be there.");
		}
		
	}	
	
	@And("^I hover or click on Our Plans in the top navigation and enter zipcode Ulayer$")
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
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppPage);
		}else{
			System.out.println("===========Page not returned============");
			Assert.fail();
		}
	}
	
	@And("^the user clicks on return link to navigate to plan summary$")
	public void clickOnReturnLink(){
		DrugCostEstimatorPage dcePage = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dcePage.clickReturnToSummaryLink();
	}
	
	@Then("^I should be directed to the VPP Plan Summary Page Ulayer and I should see the Plan Count Overlay populated appropriately$")
	public void should_be_directed_to_the_VPP_Plan_Summary_Page(){
		VPPPlanSummaryPage vppPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppPage.validatePlanSummary();
	}
	
	@Then("^user enters zipcode on step3 and validate plan summary page$")
	public void user_enters_zipcode_on_step3_and_validate_plan_summary_aarp(DataTable data){
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String zip = memberAttributesRow.get(0).getCells().get(1);
		String county = memberAttributesRow.get(1).getCells().get(1);
		DrugCostEstimatorPage dcePage = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		VPPPlanSummaryPage vppPlanSummaryPage= dcePage.validateMultiCountyPopup(zip,county);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppPlanSummaryPage);
	}
	
	/**
	 * @throws InterruptedException
	 * @toDo:user validates plan summary for the below plan
	 */
	@And("^user validates drug cost in medical benefit section in the AARP site$")
	public void user_validates_drug_cost_in_medical_benefit_section_aarp(DataTable planAttributes) throws InterruptedException {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assert.assertTrue("Error loading specific plan summary in VPP plan summary page",
				planSummaryPage.getSpecificPlanInfo(planName));
		planSummaryPage.clickOnViewMoreForPlan(planName);
		planSummaryPage.validateMedicalBenefitDrugSection(planName);
	}
	
	@Then("^user validates drug added on prescription drug benefits tab in AARP$")
	public void user_validates_drug_added_on_prescription_drug_benefits_tab_AARP(DataTable drug){
		List<DataTableRow> givenAttributesRow = drug.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String drugName = givenAttributesMap.get("Drug");
		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		planDetailsPage.validatedAddedDrug(drugName);
	}
	
	/*verify DCE flow from Ulayer home page hover over*/
	@When("^I click on Drug Cost Estimator link from Shop for a plan hover over for AARP site$")
	public void i_click_on_Drug_Cost_Estimator_link_from_Shop_for_a_plan_hover_over_for_ums_site() {
		
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) acquisitionHomePage.navigationDrugCostEstimator();
				
		if(dce!=null){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}
	/** user is on the Medicare Site landing page for DCE Testharness*/
	@Given("^the user is on the Acquisition Site DCE TestHarness page$")
	public void validateUserIsOnDCETestharnessPage(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		String TestharnessPage = inputAttributesMap.get("TestHarnessPage");
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd,siteName,TestharnessPage);
		String testSiteUrl=aquisitionhomepage.getTestSiteUrl();
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL,testSiteUrl);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		DCETestHarnessPage dceTestHarnessPage = (DCETestHarnessPage) aquisitionhomepage.GetDCEtestHarnessPage();
		getLoginScenario().saveBean(PageConstants.DCE_TESTHARNESS_PAGE,dceTestHarnessPage);
	}
	
	@When("^the user enters following information in the Acquisition Site DCE TestHarness page$")
	public void the_user_enters_following_information_in_the_Acquisition_Site_DCE_TestHarness_page(DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String planName = inputAttributesMap.get("Plan Name");
		DCETestHarnessPage dceTestHarnessPage = (DCETestHarnessPage) loginScenario.getBean(PageConstants.DCE_TESTHARNESS_PAGE);
		dceTestHarnessPage.enterZipandSearch(ZipCode);
		if(isMultutiCounty.equalsIgnoreCase("YES")) {
			dceTestHarnessPage.SelectCounty(CountyName);
		}
		dceTestHarnessPage.selectPlan(planName);
		DrugCostEstimatorPage dce = dceTestHarnessPage.StartDCE();
		if(dce!=null){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	
	@Then("^the user validates Local Storage for Zip, added drugs and Pharmacy details$")
	public void the_user_validates_the_added_drugs_on_See_your_Estimated_Costs_page_in_AARP_site(DataTable DCEAttributes) throws Throwable {
		Map<String, String> DCEAttributesMap=parseInputArguments(DCEAttributes);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validateLocalStorage(DCEAttributesMap);
	}
}
