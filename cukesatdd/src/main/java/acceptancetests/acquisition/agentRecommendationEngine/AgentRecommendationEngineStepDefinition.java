package acceptancetests.acquisition.agentRecommendationEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.agentRecommendationEngine.AREAgentLoginSearch;
import pages.acquisition.agentRecommendationEngine.AREPlanRanking;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class AgentRecommendationEngineStepDefinition {

	@Autowired

	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver wd;
	List<DataTableRow> inputRow;
	HashMap<String, String> inputValues;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void readfeaturedata(DataTable data) {
		inputRow = new ArrayList(data.getGherkinRows());
		inputValues = new HashMap<String, String>();
		for (int i = 0; i < inputRow.size(); i++) {
			inputValues.put(inputRow.get(i).getCells().get(0), inputRow.get(i).getCells().get(1));
		}
	}

	@Given("^the agent is on shopper profile login page$")
	public void the_agent_on_shopperprofile_login_site() {
		wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, "ARE", true);
		aquisitionhomepage.openTelesalesAgentPortal();
		aquisitionhomepage.fixPrivateConnection();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@When("^agent login to shopper profile$")
	public void agent_login(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AREAgentLoginSearch ARESearch = new AREAgentLoginSearch(wd);
		ARESearch.login(inputValues.get("User Name"), inputValues.get("Password"));
	}

	@And("^agent is looking for an profile and cloaksIn$")
	public void agent_search_cloakIn(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AREAgentLoginSearch ARESearch = new AREAgentLoginSearch(wd);
		ARESearch.searchProfile(inputValues.get("Email"));
	}

	@Then("^agent validates plan ranking drop down UI plancompare page$")
	public void agent_verify_planrankingUI() {
		AREPlanRanking planRank = new AREPlanRanking(wd);
		planRank.validateUIElements();
	}

	@Then("^user adds Drugs in plan compare page$")
	public void add_drugs_plan_compare_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AREPlanRanking addDrug = new AREPlanRanking(wd);
		addDrug.agentaddDrugsPlanCompare(inputValues.get("Drug Details"));
	}

	@Then("^user verify Drugs added in plan compare page vs DCE$")
	public void drugs_plan_compare_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AREPlanRanking addDrug = new AREPlanRanking(wd);
		addDrug.DrugsInPlanCompare(inputValues.get("Drugs Names"));
		addDrug.DeleteinDCE(inputValues.get("Drugs Names"));
	}

	@When("^user adds providers in plan compare page$")
	public void add_provider_plan_compare_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AREPlanRanking addProvider = new AREPlanRanking(wd);
		addProvider.agentaddProvidersPlanCompare(inputValues.get("Doctors"));
	}

	@Then("^user verify added Providers in plan compare page vs Werally$")
	public void doc_plan_compare_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AREPlanRanking addDrug = new AREPlanRanking(wd);
		addDrug.DoctorsInPlanCompare(inputValues.get("Doctors Names"));
		addDrug.DeleteinWerally(inputValues.get("Delete Doctors"));
	}

	@Then("^agent validates view plan details in plancompare page$")
	public void agent_verify_viewplandetails() {
		AREPlanRanking planRank = new AREPlanRanking(wd);
		planRank.validateViewPlanDetails();
	}

	@Then("^agent validates save plans in plancompare page$")
	public void agent_verify_saveplan() {
		AREPlanRanking planRank = new AREPlanRanking(wd);
		planRank.validateSavePlan();
	}

	@Then("^agent validates enroll plans in plancompare page$")
	public void agent_verify_enroll() {
		AREPlanRanking planRank = new AREPlanRanking(wd);
		planRank.validateEnrollPlan();
	}

	@Then("^agent validates ranking plans order in plancompare page$")
	public void agent_verify_rankin_planorder(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AREPlanRanking planRank = new AREPlanRanking(wd);
		planRank.verifyRankingOrder(inputValues.get("ZIP"), inputValues.get("Ranking Options"),
				inputValues.get("Current Plan"), inputValues.get("ChangeIn Order"),
				inputValues.get("Expected Plans Order"));
	}
	
	@Then("^agent selects county and plan year in plancompare page$")
	public void agent_changePlanYear(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		AREPlanRanking planRank = new AREPlanRanking(wd);
		planRank.checkCountyPlanYear(inputValues.get("Multi County"), inputValues.get("Plan Year"));
	}

}
