package acceptancetests.mobile.acquisition.agentRecommendationEngine;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mobile.acquisition.commonpages.AREAgentLoginSearchMobile;
import pages.mobile.acquisition.commonpages.AREPlanRankingMobile;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;


public class AgentRecommendationEngineStepDefinition {

	@Autowired

	MRScenario loginScenario;
	
	AppiumDriver Wd;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

//	AppiumDriver wd;
//	List<DataTableRow> inputRow;
	HashMap<String, String> inputValues;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void readfeaturedata(DataTable data) {
//		inputRow = new ArrayList(data.getGherkinRows());
		inputValues = new HashMap<String, String>();
		/*for (int i = 0; i < inputRow.size(); i++) {
			inputValues.put(inputRow.get(i).getCells().get(0), inputRow.get(i).getCells().get(1));
		}*/
		inputValues = DataTableParser.readDataTableAsMaps(data);
	}

	@Given("^the agent is on shopper profile login page$")
	public void the_agent_on_shopperprofile_login_site() {
		
		
		Wd = (AppiumDriver) getLoginScenario().getMobileDriver();
	
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(Wd, "ARE"); //changed on 3/3/21 as part of AARP/UHC cleanup
		aquisitionhomepage.openTelesalesAgentPortal();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, Wd);
	}

	@When("^agent login to shopper profile$")
	public void agent_login(DataTable givenAttributes) {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		readfeaturedata(givenAttributes);
		AREAgentLoginSearchMobile ARESearch = new AREAgentLoginSearchMobile(wd);
		ARESearch.login(inputValues.get("User Name"), inputValues.get("Password"));
	}

	@And("^agent is looking for an profile and cloaksIn$")
	public void agent_search_cloakIn(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREAgentLoginSearchMobile ARESearch = new AREAgentLoginSearchMobile(wd);
		ARESearch.searchProfile(inputValues.get("Email"));
	}

	@Then("^agent validates plan ranking drop down UI plancompare page$")
	public void agent_verify_planrankingUI() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.confirmAlert(60);
		planRank.validateUIElements();
	}
	
	@Then("^agent validates plan ranking drop down not displaying in plancompare page$")
	public void agent_verify_NoplanrankingUI() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.validateUIPlanRanking();
	}

	@Then("^user adds Drugs in plan compare page$")
	public void add_drugs_plan_compare_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile addDrug = new AREPlanRankingMobile(wd);
		addDrug.agentaddDrugsPlanCompare(inputValues.get("Drug Details"));
	}

	@Then("^user verify Drugs added in plan compare page vs DCE$")
	public void drugs_plan_compare_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile addDrug = new AREPlanRankingMobile(wd);
		//addDrug.DrugsInPlanCompare(inputValues.get("Drugs Names"));
		//addDrug.DeleteinDCE(inputValues.get("Drugs Names"));
		//addDrug.returnToPlanCompare();
		addDrug.checkDeleteAllDrugs();
	}

	@When("^user adds providers in plan compare page$")
	public void add_provider_plan_compare_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile addProvider = new AREPlanRankingMobile(wd);
		addProvider.agentaddProvidersPlanCompare(inputValues.get("Doctors"));
	}

	@Then("^user verify added Providers in plan compare page vs Werally$")
	public void doc_plan_compare_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile addDrug = new AREPlanRankingMobile(wd);
		//addDrug.DoctorsInPlanCompare(inputValues.get("Doctors Names"));
		//addDrug.DeleteinWerally(inputValues.get("Delete Doctors"));
		addDrug.checkDeleteAllDoctors();
	}

	@Then("^agent validates view plan details in plancompare page$")
	public void agent_verify_viewplandetails() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.validateViewPlanDetails();
	}

	@Then("^agent validates save plans in plancompare page$")
	public void agent_verify_saveplan(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.validateSavePlan(inputValues.get("Plan Year"));
	}

	@Then("^agent validates enroll plans in plancompare page$")
	public void agent_verify_enroll() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.validateEnrollPlan();
	}

	@Then("^agent validates ranking plans order in plancompare page$")
	public void agent_verify_rankin_planorder(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.verifyRankingOrder(inputValues.get("ZIP"), inputValues.get("Ranking Options"),
				inputValues.get("Current Plan"), inputValues.get("ChangeIn Order"),
				inputValues.get("Expected Plans Order"));
	}
	
	@Then("^agent selects county and plan year in plancompare page$")
	public void agent_changePlanYear(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.checkCountyPlanYear(inputValues.get("Multi County"), inputValues.get("Plan Year"));
	}
	
	@Then("^agent validates information cleared in session storge$")
	public void agent_verify_clear_Session(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.verifyClearSession(inputValues.get("ZIP"));
	}
	
	@Then("^agent validates selected information saved in session storge$")
	public void agent_verify_saved_Session(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.verifySavedSession(inputValues.get("ZIP"), inputValues.get("Ranking Options"), inputValues.get("Ranking Options1"));
	}
	
	@Then("^agent validates Drug and Doctors in session storge$")
	public void agent_verify_drug_Doc_Session(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.verifyDrugDoc(inputValues.get("Ranking Options"), inputValues.get("Expected Plans Order"), inputValues.get("Current Plan"));
	}
	
	@When("^Agent fetch original PlanOrder in plancompare page$")
	public void original_planOrder(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.checkDeleteAllDoctors();
		planRank.checkDeleteAllDrugs();
		planRank.OriginalPlanOrder(inputValues.get("Ranking Options"));
	}
	
	@Then("^agent get plandetails after editing Drugs in plancompare$")
	public void agent_getPlanDetails(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.rankingplancomparion(inputValues.get("Current Plan"),inputValues.get("ChangeIn Order"),inputValues.get("Expected Plans Order"));
	}
	
	@Then("^Apply ranking and get plans names in plancompare page$")
	public void agent_apply_getPlanDetails(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.applyRankingGetplanNames(inputValues.get("Ranking Options"));
	}
	
	@Then("^agent verify Drug option disabled and Original Plans Order in plancompare page$")
	public void agent_DrugDisbale_PlanDetails(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.disableDrugOriginalPlans(inputValues.get("Current Plan"),inputValues.get("ChangeIn Order1"),inputValues.get("Ranking Options"),inputValues.get("Expected Plans Order"));
	}
	
	@Then("^agent validates auto ranking for plan year change in plancompare page$")
	public void agent_autorankin_planyear(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.verifyAutoRankingPlanYear(inputValues.get("Plan Year"),inputValues.get("ZIP"), inputValues.get("Ranking Options"),
				inputValues.get("Current Plan"), inputValues.get("ChangeIn Order"),
				inputValues.get("Expected Plans Order"));
	}
	
	@Then("^agent deletes and adds plan in plancompare page$")
	public void agent_delete_add_plan(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.verifyDeleteAddPlan(inputValues.get("ZIP"),inputValues.get("Ranking Options"),
				inputValues.get("Current Plan"), inputValues.get("ChangeIn Order"),
				inputValues.get("Expected Plans Order"));
	}
	
	@Then("^agent verifies year$")
	public void agent_verifies_planyear(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.checkYear(inputValues.get("Plan Year"));
	}
	
	@Then("^agent validates Estimated Annual Medical Cost in plancompare page$")
	public void agent_verifies_estimateMCE(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.estimateMedicalCost(inputValues.get("Estimate MedicalCost"));
	}
	
	@Then("^agent validates ranking option is not present in plan ranking drop down$")
	public void agent_verifies_Option(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AREPlanRankingMobile planRank = new AREPlanRankingMobile(wd);
		planRank.optionCheck(inputValues.get("Ranking Options"),false);
	}

}