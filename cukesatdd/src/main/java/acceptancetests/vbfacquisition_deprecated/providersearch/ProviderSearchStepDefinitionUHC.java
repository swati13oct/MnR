package acceptancetests.vbfacquisition_deprecated.providersearch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.vbfacquisition_deprecated.vpp.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;

/**
 * Functionality:ProviderSearch 
 */

public class ProviderSearchStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}
	
	/**
	 * @toDo:user is on UMS medicare acquisition site landing page
	 */
	@Given("^the user is on UMS medicare acquisition site landing page$")
	public void user_UMS_Medicare()
	{
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
	}
	
	/**
	 * @toDo:the user performs plan search using following information in the UMS site
	 */
	@When("^the user performs plan search using following information in the UMS site$")
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
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}
	
	/**
	 * @toDo:the user Click on Show Plans link
	 */
	@When("^the user Click on Show Plans link$")
	public void clickonshowplans(DataTable planTypeAttribute)
	{
		
		List<DataTableRow> planTypeAttributesRow = planTypeAttribute
				.getGherkinRows();
		Map<String, String> planTypeAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < planTypeAttributesRow.size(); i++) {

			planTypeAttributesMap.put(planTypeAttributesRow.get(i).getCells()
					.get(0), planTypeAttributesRow.get(i).getCells().get(1));
		}

		String planType = planTypeAttributesMap.get("PlanType");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		plansummaryPage.viewPlanSummary(planType);
	}
	
		
	/**
	 * @toDo:the user Click on Is my Provider covered link
	 */
	@When("^the user Click on Is my Provider covered link$")
	public void clickonProvidercoveredlink(DataTable Planname )
	{
		List<DataTableRow> plannameAttributesRow = Planname
				.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells()
					.get(0), plannameAttributesRow.get(i).getCells().get(1));
		}
		String planName = plannameAttributesMap.get("PlanName");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		plansummaryPage.clicksOnIsProviderCoveredUms(planName);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
				plansummaryPage);
	
	}
	
	/**
	 * @toDo:Verify X out of Y provider covered information is displayed on Plan Summary page
	 */
	@Then("^Verify X out of Y provider covered information is displayed on Plan Summary page$")
		public void verifyproviderscovered(DataTable Planname)
	{
		
		List<DataTableRow> plannameAttributesRow = Planname
				.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells()
					.get(0), plannameAttributesRow.get(i).getCells().get(1));
		}
		String planName = plannameAttributesMap.get("PlanName");
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if(plansummaryPage.providerinfo(planName))
		{
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
		}
		else {
			Assert.fail("Error Loading Provider search info");
		}
	}
}
	