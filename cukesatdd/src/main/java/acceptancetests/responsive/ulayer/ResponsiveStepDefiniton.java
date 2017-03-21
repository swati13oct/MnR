package acceptancetests.responsive.ulayer;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.PortfolioPage;
import pages.acquisition.ulayer.ResponsivePlanDetails;
import pages.acquisition.ulayer.ResponsivePlanSummary;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class ResponsiveStepDefiniton {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the vpp portfolio page$")
	public void user_on_aarp_ourPlans_page(){
		WebDriver wd = getLoginScenario().getWebDriver();
		PortfolioPage ourPlans = new PortfolioPage(wd);
		
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants. PORTFOLIO_PAGE, ourPlans);
	}
	
	@Then("^the user performs plan serach using zipcode$")
	public void user_planSearch_with_zipcode(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		String county = memberAttributesMap.get("County");
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		PortfolioPage portfolioPage = (PortfolioPage) getLoginScenario()
				.getBean(PageConstants. PORTFOLIO_PAGE);
		ResponsivePlanSummary vppPlan = portfolioPage.searchPlans(zipcode, county);
		if(vppPlan!=null){
			getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE, vppPlan);
		}else{
			Assert.fail();
		}
	}
	
	@And("^verifies the zipcode on VPP page$")
	public void user_validates_VPPPage(){
		 VPPPlanSummaryPage vppPlan= (VPPPlanSummaryPage) getLoginScenario()
				 .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		 //validate with JSON
		 System.out.println("JSON validation starts");
		 /* Get expected data */
			String fileName = "vppPlanSummary";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
					+ File.separator + getLoginScenario().getBean(VPPCommonConstants.ZIPCODE) 
					+ File.separator + getLoginScenario().getBean(VPPCommonConstants.COUNTY)
					+ File.separator;
			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);

			/* Get actual data */
			JSONObject planSummaryActualJson = vppPlan.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);
			System.out
			.println("planSummaryActualJson---->" + planSummaryActualJson);
	System.out.println("planSummaryExpectedJson---->"
			+ planSummaryExpectedJson);

	try {
		JSONAssert.assertEquals(planSummaryExpectedJson,
				planSummaryActualJson, true);
	} catch (JSONException e) {
		e.printStackTrace();
	}
		}
	@Then("^the user navigates to the following plan type$")
	public void planType_details_in_aarp_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planType = memberAttributesMap.get("Plan Type");
		System.out.println(planType);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);

		ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);	
		
		ResponsivePlanSummary vpp =	plansummaryPage.viewPlanSummary(planType);
		if(vpp!=null){
			getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE, vpp);
		}else{
			Assert.fail();
		}
	}
	//US501386 - Plan Highlights 
	@And ("^the user validates plan highlight and provider search$")
	public void user_validates_planHighlights_poviderLink(){
		ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		planSummary.validatePlanHighlights();
 	}
	@Then("^user clicks on search by address link$")
	public void search_by_address() {
		PortfolioPage portfolioPage = (PortfolioPage) getLoginScenario().getBean(PageConstants. PORTFOLIO_PAGE);
		portfolioPage.searchbyaddressclick();
		portfolioPage.validate();
	}
	@And("^the user navigates to plan details page$")
	public void the_user_navigates_to_plan_details_page(DataTable givenAttributes) {
		ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes 
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planName = memberAttributesMap.get("Plan Name");
		System.out.println(planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
 		ResponsivePlanDetails planDetails =  plansummaryPage.viewPlanDetails(planName);
 		getLoginScenario().saveBean(PageConstants.RESPONSIVE_DETAILS_PAGE, planDetails);
 	}
	
	@And("^the user select plan to compare in AARP site")
	public void the_user_select_plan_to_compare() throws InterruptedException{
		PortfolioPage portfolioPage = (PortfolioPage) getLoginScenario().getBean(PageConstants. PORTFOLIO_PAGE);
		portfolioPage.selectAddToCompareCheckboxes();
		//portfolioPage.validate();
	}
	
	@And("^the user click compare plans in AARP site")
	public void the_user_click_compare_plans_to_compare(){
		PortfolioPage portfolioPage = (PortfolioPage) getLoginScenario().getBean(PageConstants. PORTFOLIO_PAGE);
		portfolioPage.comparePlanslnk();
		//portfolioPage.validate();
	}
	
	@And("^the user click plan view details link on compare in AARP site")
	public void the_user_click_plan_viewdetails_link(){
		PortfolioPage portfolioPage = (PortfolioPage) getLoginScenario().getBean(PageConstants. PORTFOLIO_PAGE);
		portfolioPage.viewdetailslnk();
		
	}
	
	@And("^the user remove plan link on compare page in AARP site")
	public void the_user_remove_plan_link(){
		PortfolioPage portfolioPage = (PortfolioPage) getLoginScenario().getBean(PageConstants. PORTFOLIO_PAGE);
		portfolioPage.removePlanlnk();
		
	}
	
	@And("^the user selects desired plan to compare$")
	public void user_clicks_on_plans_to_compare(DataTable givenAttributes){
		
		List<DataTableRow> memberAttributesRow = givenAttributes 
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planName1 = memberAttributesMap.get("Plan 1");
		String planName2 = memberAttributesMap.get("Plan 2");
		System.out.println(planName1);
		System.out.println(planName2);
		ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		plansummaryPage.selectPlansToCompareTwoPlans(planName1, planName2);				
	}
	@Then("^the user validates medical benefits$")
	public void user_validates_medical_benefits(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes 
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String monthlyPremium1 = memberAttributesMap.get("MP Plan1");
		String monthlyPremium2 = memberAttributesMap.get("MP Plan2");
		String outofpocket1 = memberAttributesMap.get("Oop Plan1");
		String outofpocket2 = memberAttributesMap.get("Oop Plan2");
		ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateMedicalBenefitsTable(monthlyPremium1, monthlyPremium2, outofpocket1, outofpocket2);
		
	}
	
	
}
