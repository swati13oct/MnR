package acceptancetests.acquisition.dce;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import pages.acquisition.dce.bluelayer.DCETestHarnessPage;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.bluelayer.SavingsOppurtunity;
import pages.acquisition.bluelayer.AddDrugDetails;
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
 *Functionality: DCE Acquisition 
 */
public class DCEAcqStepDefinitionUHC {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
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
	 * @toDo:access the acquisition DCE tool from home page
	 */
	@When("^I access the acquisition DCE tool from home page on ums site$")
	public void I_access_the_DCE_tool_home_page() throws InterruptedException {

		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DrugCostEstimatorPage dcePage = (DrugCostEstimatorPage) acquisitionHomePage.navigateToDCEToolFromHome();
		if(null!=dcePage){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dcePage);
		}else
			Assert.fail("DCE page object not loaded");
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
		//plansummaryPage.clickOnViewPlans(plantype);
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
			Assert.assertTrue(true);
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
	 * @toDo:navigate to step2 page
	 */
	@And("^I navigate to step2 page on ums site$")
	public void I_navigate_to_step2_page_in_ums () throws InterruptedException
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
	
	@And("^the user clicks on return link to navigate to plan summary in UHC$")
	public void clickOnPlanSummaryReturnLink(){
		DrugCostEstimatorPage dcePage = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dcePage.clickReturnToSummaryLink();
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

		String drugName = memberAttributesMap.get("Drug").toUpperCase();
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
	
	@Then("^I navigate to step3 page and validate drug info for DCE homepage flow uhc$")
	public void I_navigate_to_step3_page(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep3();
		Assert.assertTrue("Error:the drug did not display on step 3 page", dce.validateDrugOnStep3FromHomePageFlow(drug));
	}
	
	/**
	 * @toDo:
	 */
	@And("^user selects drug details in ums site$")
	public void user_selects_drug_details_in_ums(DataTable data) throws InterruptedException {
		
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
	@When("^user successfully adds drug in ums site$")
	public void user_successfully_adds_drug_in_ums(DataTable data) throws InterruptedException {

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
	
	@Then("^user enters zipcode on step3 and validate plan summary page in uhc$")
	public void user_enters_zipcode_on_step3_and_validate_plan_summary_uhc(DataTable data){
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String zip = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dcePage = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		VPPPlanSummaryPage vppPlanSummaryPage= dcePage.enterZipcodeAndNavigateToPlanSummary(zip);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppPlanSummaryPage);
	}
	
	/**
	 * @throws InterruptedException
	 * @toDo:user validates plan summary for the below plan
	 */
	@And("^user validates drug cost in medical benefit section in the UMS site$")
	public void user_validates_drug_cost_in_medical_benefit_section_UHC(DataTable planAttributes) throws InterruptedException {
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
		planSummaryPage.validateMedicalBenefitDrugSection(planName);
	}
	
	@Then("^user validates drug added on prescription drug benefits tab in UMS$")
	public void user_validates_drug_added_on_prescription_drug_benefits_tab_UHC(DataTable drug){
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
	
	/*verify DCE flow from Blue Layer home page hover over*/
	@When("^I click on Drug Cost Estimator link from Shop for a plan hover over for ums site$")
	public void i_click_on_Drug_Cost_Estimator_link_from_Shop_for_a_plan_hover_over_for_ums_site() {
		
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) acquisitionHomePage.navigationDrugCostEstimator();
		
		
		if(dce!=null){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}
	
	/** user is on the Medicare Site landing page for DCE Testharness*/
	@Given("^the user is on the UMS Acquisition Site DCE TestHarness page$")
	public void validateUserIsOnUMS_DCETestharnessPage(DataTable inputAttributes) {
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
	
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}
	
	@When("^the user enters following information in the UMS Acquisition Site DCE TestHarness page$")
	public void the_user_enters_following_information_in_the_UMS_Site_DCE_TestHarness_page(DataTable inputAttributes) throws Throwable {
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
	@Then("^the user validates Local Storage for Zip, added drugs and Pharmacy details for UHC$")
	public void the_user_validates_the_added_drugs_on_See_your_Estimated_Costs_page_in_AARP_site(DataTable DCEAttributes) throws Throwable {
		Map<String, String> DCEAttributesMap=parseInputArguments(DCEAttributes);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validateLocalStorage(DCEAttributesMap);
	}
}
