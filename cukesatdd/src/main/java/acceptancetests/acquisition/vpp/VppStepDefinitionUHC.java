package acceptancetests.acquisition.vpp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisitionvbf.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.PlanComparePage;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;

/**
 * Functionality: VPP UHC site
 */

public class VppStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo:user is on the uhcmedicaresolutions site landing page
	 */
	@Given("^the user is on the uhcmedicaresolutions site landing page$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}


	/**
	 * @toDo : the user enters the zip code to search plans
	 */
	@When("^the user performs plan search using following information in UMS site$")
	public void zipcode_details_in_UMS_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

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
	 * @throws InterruptedException 
	 * @toDo:user views plans of the below plan type
	 */
	@When("user views plans of the below plan type in UMS site$")
	public void user_performs_planSearch_in_UMS_site(DataTable givenAttributes) throws InterruptedException {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Thread.sleep(7000);
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, "UHC_ACQ");
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error validating availables plans for selected plantype in  VPP plan summary page");
		}
	}
	
	/**
	 * @toDo:user view plan details of the above selected plan
	 */
	@Then("^the user view plan details of the above selected plan in UMS site and validates$")
	public void user_views_plandetails_selected_plan_ums(DataTable givenAttributes) {
		
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
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
		
		@Then("^the user view plan details of the above selected plan in UMS site vpp$")
		public void the_user_view_plan_details_of_the_above_selected_plan_in_UMS_site_vpp(DataTable givenAttributes) {
			
			List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			String PlanName = memberAttributesRow.get(0).getCells().get(1); 
					getLoginScenario().saveBean(
					VPPCommonConstants.PLAN_NAME,PlanName);
			VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName);
			getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);

			PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName);
			if (vppPlanDetailsPage != null) {
				getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
						vppPlanDetailsPage);
				Assert.assertTrue(true);
			}
			else
				Assert.fail("Error in Loading the Plan Details Page");	
		}

		@Then("^the user clicks on both top and bottom back to plans link and validates its redirection$")
		public void the_user_clicks_on_both_topand_bottom_back_to_plans_link_and_validates_its_redirection() throws InterruptedException {
//			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
//					vppPlanDetailsPage);
			PlanDetailsPage vppPlanDetailsPage =  ( PlanDetailsPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			vppPlanDetailsPage.validatetopbacktoplanslink();
			vppPlanDetailsPage.browserBack();
			vppPlanDetailsPage.validatedownbacktoplanslink();
			
			}
	
	/**
	 * @toDo:access the vpp page
	 */
	@When("^I access the vpp page$")
	public void I_access_the_vpp_page(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

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
	@Then("^the user selects plans to add to plan compare and navigates to Plan compare page in UHC site$")
	public void the_user_selects_plans_to_add_to_plan_compare_and_navigates_to_Plan_compare_page(DataTable planAttributes) throws Throwable {
		
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PlanName = givenAttributesMap.get("Plan Name");
		//String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);

		String PlanYear = "2018"; 
		String PlanPremium;
		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String TFN;
		String SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		TFN = planSummaryPage.GetTFNforPlanType();
		PlanPremium = planSummaryPage.getPlanPremium(PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : "+PlanName);
		System.out.println("Plan Type is : "+PlanType);
		System.out.println("Plan Zip Code is : "+ZipCode);
		System.out.println("Plan County Name is : "+County);
		System.out.println("Plan Plan Premium is : "+PlanPremium);
		System.out.println("TFN for Plan Type is : "+TFN);
		System.out.println("Plan Year is : "+PlanYear);
		System.out.println("OLE is being started from Acquisition Site : "+SiteName);
		PlanComparePage comparePlansPage = planSummaryPage.selectplantocompare(PlanType);
		
		
		if (comparePlansPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE,comparePlansPage);
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Error in Loading the Plan Compare Page");
		
	}

	
}