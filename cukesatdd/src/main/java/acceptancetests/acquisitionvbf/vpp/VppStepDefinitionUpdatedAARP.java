package acceptancetests.acquisitionvbf.vpp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisitionvbf.common.CommonStepDefinition;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.ComparePlansPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

/**
 * Functionality: VPP flow for AARP site 
 */

public class VppStepDefinitionUpdatedAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	private Map<String, String> memberAttributesMap =new CommonStepDefinition().getAttributesMap();
	
	private List<DataTableRow> memberAttributesRow = new CommonStepDefinition().getAttributesRow();
	
	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user performs plan search using following information in the AARP site$")
	public void zipcode_details_in_aarp_site() {
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.searchPlans(
				zipcode, county);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			if(plansummaryPage.validateVPPPlanSummaryPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the Plan Summary Page");
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	/**
	 * @toDo:user validates plan count for all plan types on plan summary page 
	 */
	@Then("^user validates plan count for all plan types on plan summary page in the AARP site$")
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
	 * @toDo:user views the plans of the below plan type 
	 */
	@And("^the user views the plans of the below plan type in AARP site$")
	public void user_performs_planSearch_in_aarp_site() {
		String plantype = memberAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
		} else {
			Assert.fail("Error loading plans of desired plantype in  VPP plan summary page");
		}

	}
	
	/**
	 * @toDo:select all 3 plans to compare in MA and click on compare plan  link
	 */
	@And("^I select all 3 plans to compare in MA and click on compare plan link$")
	public void I_select_all_3_plans_to_compare(){
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickonViewPlans();
		plansummaryPage.checkAllMAPlans();
		ComparePlansPage comparePlansPage = plansummaryPage.clickOnCompareLink();
		if(comparePlansPage != null){
			getLoginScenario().saveBean(PageConstants.TeamC_Plan_Compare_Page, comparePlansPage);
			comparePlansPage.backToVPPPage();
		}else
			Assert.fail("Error in loading the compare plans page");
	}
	
	/**
	 * @toDo:click back to all plans button and verify that all 3 plans are still selected
	 */
	@Then("^I click back to all plans button and verify that all 3 plans are still selected$")
	public void verifyAllPlansStillSelected(){
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickonViewPlans();
		if(plansummaryPage.validateAllPlansChecked()){
			Assert.assertTrue(true);
		}else
			Assert.fail("Error in validating all plans are still selected");
		
	}
	
	/**
	 * @toDo:user view plan details of the above selected plan in AARP site and validates
	 */
	@When("^the user view plan details of the above selected plan in AARP site and validates$")
	public void user_views_plandetails_selected_plan_aarp() {
		
		String planName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(
				VPPCommonConstants.PLAN_NAME,planName);
	
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String)getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage
				.navigateToPlanDetails(planName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
					vppPlanDetailsPage);
			if(vppPlanDetailsPage.validatePlanDetailsPage()){
				Assert.assertTrue(true);
			}else
				Assert.fail("Error in validating the Plan Details Page");
		
		}
	}

	/**
	 * @toDo:user validates the available plans for selected plan types
	 */
	@Then("^the user validates the available plans for selected plan types in the AARP site$")
	public void user_validates_available_plans_aarp() {

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_TYPE);
		if (plansummaryPage.validatePlanNames(planType)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error validating availables plans for selected plantype in  VPP plan summary page");
		}
	}

	/**
	 * @toDo:user validates plan summary for the below plan
	 */
	@And("^the user validates plan summary for the below plan in the AARP site$")
	public void user_validates_plan_summary() {
		
		String planName = memberAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		if (planSummaryPage.getSpecificPlanInfo(planName)) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					planSummaryPage);
		} else {
			Assert.fail("Error loading specific plan summary in VPP plan summary page");
		}

	}
}
