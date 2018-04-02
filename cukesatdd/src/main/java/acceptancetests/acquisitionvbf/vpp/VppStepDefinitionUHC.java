package acceptancetests.acquisitionvbf.vpp;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import acceptancetests.acquisitionvbf.common.CommonStepDefinition;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality: VPP UHC site
 */

public class VppStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	private Map<String, String> memberAttributesMap =new CommonStepDefinition().getAttributesMap();
	
	private List<DataTableRow> memberAttributesRow = new CommonStepDefinition().getAttributesRow();


	/**
	 * @toDo : the user enters the zip code to search plans
	 */
	@When("^the user performs plan search using following information in UMS site$")
	public void zipcode_details_in_UMS_site() {
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

		}

	}
	
	/**
	 * @toDo:user views plans of the below plan type
	 */
	@When("user views plans of the below plan type in UMS site$")
	public void user_performs_planSearch_in_UMS_site() {
		String plantype = memberAttributesMap.get("Plan Type");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			
		}

	}
	
	/**
	 * @toDo:user view plan details of the above selected plan
	 */
	@Then("^the user view plan details of the above selected plan in UMS site and validates$")
	public void user_views_plandetails_selected_plan_ums() {
		
	
		String planName = memberAttributesRow.get(0).getCells().get(1); 
				getLoginScenario().saveBean(
				VPPCommonConstants.PLAN_NAME,planName);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(planName);
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
	 * @toDo:access the vpp page
	 */
	@When("^I access the vpp page$")
	public void I_access_the_vpp_page() throws InterruptedException {
		String zipcode = memberAttributesMap.get("Zip Code");
		AcquisitionHomePage acqhomepage = (AcquisitionHomePage) loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage vppplansummarypage = acqhomepage.navigateToVpp(zipcode);
		if(vppplansummarypage!=null){
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppplansummarypage);
			
		}
	}
	
	/**
	 * @toDo:click on add to compare checkbox and click on view details 
	 */
	@And("^I click on add to compare checkbox and click on view details link$")
	public void I_click_on_compare_checkbox(){
		VPPPlanSummaryPage vppplansummarypage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.clickonViewPlans();
		vppplansummarypage.clickCompareChkBox();
		PlanDetailsPage plandetailspage = vppplansummarypage.clickViewDetails();
		if(plandetailspage!=null){
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		}
	}
	
	/**
	 * @toDo:select pdp plans and go to view details page
	 */
	@And("^I select pdp plans and go to view details page$")
	public void I_select_pdp_plans_and_go_to_view_details_page(){
		VPPPlanSummaryPage vppplansummarypage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.clickOnPDPPlans();
		PlanDetailsPage plandetailspage = vppplansummarypage.clickViewDetailsPDP();
		if(plandetailspage!=null){
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		}
	}
	
	/**
	 * @toDo:check compare box and verify right info is shown
	 */
	@Then("^I check compare box and verify right info is shown$")
	public void I_check_compare_box_and_verify(){
		PlanDetailsPage plandetailspage = (PlanDetailsPage) loginScenario.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		if(plandetailspage.validateCompareBoxPDP()){
			Assert.assertTrue(true);
		}else
			Assert.fail("Error in validating the compare checkbox message and/or link");
	}
	
	/**
	 * @toDo:user clicks on add to compare box and validates that info shows 2 plans added
	 */
	@Then("^the user clicks on add to compare box and validates that info shows 2 plans added$")
	public void I_check_compare_box_and_verify_2_plans(){
		PlanDetailsPage plandetailspage = (PlanDetailsPage) loginScenario.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		if(plandetailspage.validate2PlansAdded()){
			Assert.assertTrue(true);
		}else
			Assert.fail("Error in validating the compare checkbox message and/or link");
	}
	
	/**
	 * @toDo:uncheck and recheck the compare box and verify the message and link exists
	 */
	@Then("^I uncheck and recheck the compare box and verify the message and link exists$")
	public void verifyPlanDetailsPage(){
		PlanDetailsPage plandetailspage = (PlanDetailsPage) loginScenario.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		if(plandetailspage.validateCompareBox()){
			Assert.assertTrue(true);
		}else
			Assert.fail("Error in validating the compare checkbox message and/or link");
	}
	
	/**
	 * @toDo:uncheck and go back to the vpp page to validate
	 */
	@Then("^I uncheck and go back to the vpp page to validate$")
	public void uncheck_and_validate_vpp_page(){
		PlanDetailsPage plandetailspage = (PlanDetailsPage) loginScenario.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		plandetailspage.clickCompareBox();
		VPPPlanSummaryPage vppsummarypage = plandetailspage.backtoPlanSummaryPage();
		if(vppsummarypage!=null){
			if(vppsummarypage.verifyCompareCheckBoxesAreUnchecked())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating that the checkboxes are unchecked");
		}else
			Assert.fail("Error in loading the vpp plan summary page");
	}
	
	/**
	 * @toDo:isAlertPresent
	 */
	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
}