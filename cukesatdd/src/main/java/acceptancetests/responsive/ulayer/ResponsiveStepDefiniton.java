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
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.PortfolioPage;
import pages.acquisition.ulayer.ResponsivePlanSummary;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class ResponsiveStepDefiniton {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
//	@Given("^the user is on the AARP our plans page$")
	@Given("^the user is on the vpp portfolio page$")
	public void user_on_aarp_ourPlans_page(){
		WebDriver wd = getLoginScenario().getWebDriver();
		PortfolioPage portfoliopage = new PortfolioPage(wd);
		
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.PORTFOLIO_PAGE, portfoliopage);
	}
	
	@Then("^the user performs plan serach using zipcode and validate plan count$")
	public void zipcode_details_in_aarp_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("ZipCode");
		String county = memberAttributesMap.get("CountyName");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		PortfolioPage portfoliopage  = (PortfolioPage) getLoginScenario()
				.getBean(PageConstants.PORTFOLIO_PAGE);
		ResponsivePlanSummary responsiveplansummary = portfoliopage.searchPlans(
				zipcode, county);

		if (responsiveplansummary != null) {
			getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY,
					responsiveplansummary);
			/* Get expected data */
			String fileName = "vppPlanSummary";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			System.out.println("fileName expected"+fileName);
			System.out.println("directory expected"+directory);
			
			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);

			/* Get actual data */
			JSONObject planSummaryActualJson = responsiveplansummary.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);
			System.out.println("plansummary actual json"+planSummaryActualJson);
			System.out.println("plansummary expected json"+planSummaryExpectedJson);
		}
	}


@Then("^user validates plan count for all plan types on plan summary page in AARP site$")
public void user_validates_following_benefits_ui_aarp() {
	JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
			.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
	JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
			.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
	try {
		JSONAssert.assertEquals(planSummaryExpectedJson,
				planSummaryActualJson, true);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
@And ("^the user validates plan highlight and provider search$")
public void user_validates_planHighlights_poviderLink(){
	ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	planSummary.validatePlanHighlights();
	}
}
