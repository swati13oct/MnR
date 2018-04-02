package acceptancetests.acquisitionvbf.providersearch;

import gherkin.formatter.model.DataTableRow;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import acceptancetests.acquisitionvbf.common.CommonStepDefinition;
import acceptancetests.acquisitionvbf.vpp.VPPCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality:ProviderSearch 
 */

public class ProviderSearchStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}
	
	private Map<String, String> memberAttributesMap =null;
	
	private List<DataTableRow> memberAttributesRow = new CommonStepDefinition().getAttributesRow();

	/**
	 * @toDo:the user performs plan search using following information in the UMS site
	 */
	@When("^the user performs plan search using following information in the UMS site$")
	public void zipcode_details_in_UMS_site() {
		 if(memberAttributesRow.size()>0){
		        for (int i = 0; i < memberAttributesRow.size(); i++) {
		               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),memberAttributesRow.get(i).getCells().get(1));
		        }
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
	public void clickonshowplans()
	{
		 if(memberAttributesRow.size()>0){
		        for (int i = 0; i < memberAttributesRow.size(); i++) {
		               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),memberAttributesRow.get(i).getCells().get(1));
		        }
	        }
		String planType = memberAttributesMap.get("PlanType");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		plansummaryPage = plansummaryPage.viewPlanSummary(planType);
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
		
	}
	
		
	/**
	 * @toDo:the user Click on Is my Provider covered link
	 */
	@When("^the user Click on Is my Provider covered link$")
	public void clickonProvidercoveredlink()
	{
		 if(memberAttributesRow.size()>0){
		        for (int i = 0; i < memberAttributesRow.size(); i++) {
		               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),memberAttributesRow.get(i).getCells().get(1));
		        }
	        }
		String planName = memberAttributesMap.get("PlanName");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		plansummaryPage.clicksOnIsProviderCoveredB(planName);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
				plansummaryPage);
	
	}
	
	/**
	 * @toDo:Verify X out of Y provider covered information is displayed on Plan Summary page
	 */
	@Then("^Verify X out of Y provider covered information is displayed on Plan Summary page$")
		public void verifyproviderscovered()
	{
		
		 if(memberAttributesRow.size()>0){
		        for (int i = 0; i < memberAttributesRow.size(); i++) {
		               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),memberAttributesRow.get(i).getCells().get(1));
		        }
	        }
		String planName = memberAttributesMap.get("PlanName");
		
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
	