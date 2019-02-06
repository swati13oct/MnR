package acceptancetests.acquisition.PlanSelector;

import gherkin.formatter.model.DataTableRow;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.PlanSelectorNewPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PlanSelectorStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	
	@Given("^the user is on UHC medicare acquisition site landing page$")
	public void the_user_on_uhc_medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@Given("^the user is on Acquisition AARP medicare site landing page$")
	public void the_user_on_AARP_Site_medicaresolutions() {
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, "Ulayer");

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}


	@When("^user goes to ours plan tab and click on Take the Quiz button$")
	public void user_goes_to_ours_plan_tab_and_click_on_Take_the_Quiz_button() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PlanSelectorNewPage planSelectorNewPage = aquisitionhomepage.quizButton();
		if(planSelectorNewPage != null)
		getLoginScenario().saveBean(PageConstants.PLAN_SELECTOR_NEW_PAGE,
				planSelectorNewPage);
		else
			System.out.println("PST page not displayed");			

	}

	@And("^clicks on get started button and runs questionnaire$")
	public void clicks_on_get_started_button_and_directly_skip_to_results(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		String zipcode = memberAttributesRow.get(0).getCells().get(1); 
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		PlanSelectorNewPage Questionnaire = planSelectorNewPage.quizStartAndRunQuestionnaire(zipcode);
		if(Questionnaire != null)
		getLoginScenario().saveBean(PageConstants.PLAN_SELECTOR_QUESTIONNAIRE,
				Questionnaire);
		else
			System.out.println("Questionaaire not started ");

	}
	
	@And("^I select my Response and go to Next Questionnaire$")
	public void I_click_questionnaire_first() throws Throwable {
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_QUESTIONNAIRE);
		PlanSelectorNewPage Questionnaire2 = planSelectorNewPage.NextQuestion();
		if(Questionnaire2 != null)
			getLoginScenario().saveBean(PageConstants.PLAN_SELECTOR_QUESTIONNAIRE,
					Questionnaire2);
			else
				System.out.println("Questionaaire2 not started ");

	}
	
	@And("^I select my second Response and go directly to results page$")
	public void I_click_questionnaire_second()  throws Throwable {
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_QUESTIONNAIRE);
		PlanSelectorNewPage ResultsPage = planSelectorNewPage.JumpLink();
		if(ResultsPage != null)
			getLoginScenario().saveBean(PageConstants.PLAN_RESULTS_PAGE,
					ResultsPage);
			else
				System.out.println("Plan Results Page not loaded");

	}
	

	@When("^I click plan detail button$")
	public void i_click_plan_detail_button() throws Throwable {
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_RESULTS_PAGE);
		PlanSelectorNewPage PlanDetailsPage = planSelectorNewPage.navigateToPlanDetails();
		if(PlanDetailsPage != null)
			getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE,
					PlanDetailsPage);
			else
				System.out.println("Plan Details Page not loaded");

	}


	@Then("^the user clicks on both top and bottom back to plan options link and validates its redirection$")
	public void i_should_be_brought_back_to_the_plan_selector_results_page() throws Throwable {
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_DETAILS_PAGE);
		planSelectorNewPage.verifyBackToPlanOptionslink();

	}


}
