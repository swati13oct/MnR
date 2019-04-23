package acceptancetests.acquisition.PlanSelector;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.PlanSelectorNewPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
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


	@When("^user scrolls down to Plan selector on VPP page on right rail widget$")
	public void user_scrolls_down_PST_rightRail() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PlanSelectorNewPage planSelectorNewPage = aquisitionhomepage.PSTButton();
		if(planSelectorNewPage != null)
		getLoginScenario().saveBean(PageConstants.PLAN_SELECTOR_NEW_PAGE,
				planSelectorNewPage);
		else
			System.out.println("PST page not displayed");			

	}
	
	@When("^user scrolls down to Plan selector on VPP detail page on right rail widget$")
	public void user_scrolls_down_PST_detail_rightRail() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		System.out.println(aquisitionhomepage);
		PlanSelectorNewPage planSelectorNewPage = aquisitionhomepage.PSTButton();
		if(planSelectorNewPage != null)
		getLoginScenario().saveBean(PageConstants.PLAN_SELECTOR_NEW_PAGE,
				planSelectorNewPage);
		else
			System.out.println("PST page not displayed");			

	}
	
	
	@Then("^the user view plan details of the above selected plan in UMS site for DST$")
	public void user_views_plandetails_selected_plan_ums(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		AcquisitionHomePage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetailsDST(planName, planType);
		System.out.println(vppPlanDetailsPage);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			} else
				Assert.fail("Error in validating the Plan Details Page");
		}
	
	
	@When("^user goes to ours plan tab and click on Plan Selector button$")
	public void user_goes_to_ours_plan_tab_and_click_on_Plan_Selector_button() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PlanSelectorNewPage planSelectorNewPage = aquisitionhomepage.quizButton();
		if(planSelectorNewPage != null)
		getLoginScenario().saveBean(PageConstants.PLAN_SELECTOR_NEW_PAGE,
				planSelectorNewPage);
		else {
			System.out.println("PST page not displayed");
		Assert.fail("PST page not displayed");
		}

	}

	@And("^clicks on get started button and runs questionnaire$")
	public void clicks_on_get_started_button_and_directly_skip_to_results(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("CountyDropDown");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			planSelectorNewPage.quizStartAndRunQuestionnaire(zipcode);
		} else {
			 planSelectorNewPage.quizStartAndRunQuestionnaireWithCounty(zipcode, county);
		}				
	}
	
	@And("^I select my Response and go to Next Questionnaire$")
	public void I_click_questionnaire_first() throws Throwable {
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		planSelectorNewPage.NextQuestion();
	}
	
	@And("^I select my second Response and go directly to results page$")
	public void I_click_questionnaire_second()  throws Throwable {
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		boolean isResultsPage = planSelectorNewPage.JumpLink();
		Assert.assertTrue("Plan Results Page not loaded", isResultsPage);
	}
	

	@When("^I click plan detail button$")
	public void i_click_plan_detail_button() throws Throwable {
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		boolean isPlanDetailsPage = planSelectorNewPage.navigateToPlanDetails();
		Assert.assertTrue("Plan Details Page is not loaded", isPlanDetailsPage);

	}


	@Then("^the user clicks on both top and bottom back to plan options link and validates its redirection$")
	public void i_should_be_brought_back_to_the_plan_selector_results_page() throws Throwable {
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		planSelectorNewPage.verifyBackToPlanOptionslink();

	}


}
