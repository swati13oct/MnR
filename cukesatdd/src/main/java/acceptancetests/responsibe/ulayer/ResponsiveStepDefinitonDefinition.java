package acceptancetests.responsibe.ulayer;

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
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.PortfolioPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class ResponsiveStepDefinitonDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
//	@Given("^the user is on the AARP our plans page$")
	@Given("^the user is on the vpp portfolio page$")
	public void user_on_aarp_ourPlans_page(){
		WebDriver wd = getLoginScenario().getWebDriver();
		PortfolioPage ourPlans = new PortfolioPage(wd);
		
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.OUR_PLANS_PAGE, ourPlans);
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
		PortfolioPage ourPlansPage = (PortfolioPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);
		VPPPlanSummaryPage vppPlan = ourPlansPage.enterZipCodeNavigateVPP(zipcode);
		if(vppPlan!=null){
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppPlan);
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
	
	@Then("user clicks on search by address link")
	public void search_by_address() {
		PortfolioPage ourPlansPage = (PortfolioPage) getLoginScenario().getBean(PageConstants.OUR_PLANS_PAGE);
		ourPlansPage.searchbyaddressclick();
		ourPlansPage.validate();
	}
	
}
