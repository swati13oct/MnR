package acceptancetests.responsive.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.PortfolioPageUhc;
import pages.acquisition.bluelayer.ResponsivePlanSummaryUhc;
import pages.acquisition.ulayer.ResponsivePlanDetails;
import pages.acquisition.ulayer.ResponsivePlanSummary;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.table.DataTable;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;

public class ResponsiveUhcStepDefiniton {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the vpp portfolio page$")
	public void user_on_aarp_ourPlans_page(){
		WebDriver wd = getLoginScenario().getWebDriver();
		PortfolioPageUhc ourPlans = new PortfolioPageUhc(wd);
		
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants. PORTFOLIO_PAGE_UHC, ourPlans);
	}
	
	@Then("^the user performs plan search using zipcode$")
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
		PortfolioPageUhc PortfolioPageUhc = (PortfolioPageUhc) getLoginScenario()
				.getBean(PageConstants. PORTFOLIO_PAGE_UHC);
		ResponsivePlanSummaryUhc vppPlan = PortfolioPageUhc.searchPlans(zipcode, county);
		if(vppPlan!=null){
			getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC, vppPlan);
		}else{
			Assert.fail();
		}
	}
	
	@Then("^user validates plan count for all plan types on plan summary page in AARP site$")
	public void user_validates_following_benefits_ui_aarp() {
	       JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
	                     .getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
	       JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
	                     .getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
	       /*try {
	              JSONAssert.assertEquals(planSummaryExpectedJson,
	                           planSummaryActualJson, true);
	       } catch (JSONException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	       }*/
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

		String planType = memberAttributesMap.get("PlanType");
		System.out.println(planType);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);

		ResponsivePlanSummaryUhc plansummaryPage = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);	
		
		ResponsivePlanSummaryUhc vppPlan =	plansummaryPage.viewPlanSummary(planType);
		if(vppPlan!=null){
			getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC, vppPlan);
		}else{
			Assert.fail();
		}
	}
	
	
	@And ("^the user validates plan highlights$")
	public void user_validates_planHighlights_poviderLink(){
		ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
		planSummary.validatePlanHighlights();
	
}
	@And("^User click on Enroll in plan link on plan detail page")

	public void userclickenrollbuttononplandetail(DataTable givenAttributes){
		
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planName = memberAttributesMap.get("PlanName");
		System.out.println(planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
		planSummary.clicksOnEnrollInplanLink(planName);
	
}
}