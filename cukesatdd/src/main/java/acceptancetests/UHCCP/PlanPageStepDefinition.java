package acceptancetests.UHCCP;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.UHCCP.PlanDetailsPage;
import pages.UHCCP.PlanSummaryPage;
import pages.UHCCP.UHCCPHomePage;

public class PlanPageStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public WebDriver driver;

	@When("the user performs plan search in UHCCP homepage")
	public void the_user_performs_plan_search_in_uhccp_homepage(DataTable givenAttributes) throws InterruptedException {

		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String planName = memberAttributesMap.get("Plan Name");
		String planType = memberAttributesMap.get("Plan Type");
		String planYear = memberAttributesMap.get("Plan Year");

		getLoginScenario().saveBean(UHCCPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(UHCCPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(UHCCPCommonConstants.IS_MULTICOUNTY, isMultiCounty);
		getLoginScenario().saveBean(UHCCPCommonConstants.PLAN_NAME, planName);
		getLoginScenario().saveBean(UHCCPCommonConstants.PLAN_TYPE, planType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, planYear);

		UHCCPHomePage uhccpHomePage = new UHCCPHomePage(driver);
		PlanSummaryPage planSummaryPage = null;

		if (("NO").equalsIgnoreCase(isMultiCounty.trim()))
			planSummaryPage = uhccpHomePage.searchPlansWithOutCounty(zipcode);
		else
			planSummaryPage = uhccpHomePage.searchPlansWithCounty(zipcode, planName, county);

		if (planSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.UHCCP_PLAN_SUMMARY_PAGE, planSummaryPage);

		} else {
			Assertion.fail("Error Loading UHCCP Plan summary page");
		}

	}

	@When("User views Plan Details of the below Plan")
	public void user_views_plan_details_of_the_below_plan_name(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		
//		String planName = memberAttributesMap.get("Plan Name");

		PlanSummaryPage planSummaryPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.UHCCP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(UHCCPCommonConstants.PLAN_NAME);
		
		PlanDetailsPage planDetailsPage = planSummaryPage.navigateToPlanDetails(planName);

		getLoginScenario().saveBean(PageConstants.UHCCP_PLAN_DETAILS_PAGE, planDetailsPage);
	}
	
	@When("validates the total number of results displayed on header")
	public void validates_the_total_number_of_results_displayed_on_header() {
	    
	}
	@When("validates the total count of results from Filter section")
	public void validates_the_total_count_of_results_from_filter_section() {
	    
	}
	@When("validates the total count of plan card in default state")
	public void validates_the_total_count_of_plan_card_in_default_state() {
	    
	}
	@When("selects a filter and validates the plan card based on filter")
	public void selects_a_filter_and_validates_the_plan_card_based_on_filter() {
	    
	}

}
