package acceptancetests.deprecated.fixedtestcases;

import gherkin.formatter.model.DataTableRow;
import pages.deprecated.acquisition.bluelayer.AcquisitionHomePage;
import pages.deprecated.acquisition.bluelayer.VPPPlanSummaryPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.acquisition.PageConstants;
import acceptancetests.deprecated.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



/**
 * @author Ga1000
 * 
 */

public class BlayerPlanDetailsRightRailUMSStepDefination{

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}
	
	@Given("^the user is on the UMS Blayer medicare acquisition site landing page$")
	public void user_UMS_Medicare()
	{
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
	}
	
	@When("^the user performs plan search using the following information in the Blayer UMS site$")
	public void zipcode_details_in_UMS_site(DataTable givenAttributes) 
	{
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

	
	@When("^the user Click on Show Plans link the Blayer$")
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
		plansummaryPage = plansummaryPage.viewPlanSummary(planType);
		
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	
	@When("^the user Click on viewPlanandCoverageDetails$")
	public void clickonViewPlansAndCoverageDetails()
	{
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		plansummaryPage.clickOnViewPlansAndCoverageLink();
		
		
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
		
	
	}
	
	@When("^the user validates all fields in medical Benifits and Programs$")
	public void the_user_validates_all_fields_in_medical_benefits()
	
	{
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateAllFields();
	}
	
	
	
	@Then("^the user validates 4 tabs$")
	public void the_user_validates_4_tabs(DataTable serviceTypeAttribute){
		
		
		String Tabs = serviceTypeAttribute.getGherkinRows().get(0).getCells().get(0);
				
		System.out.println(Tabs);
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	
		plansummaryPage.selectTabs();
		
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
		
	}
	
	@Then("^the user validates the right rail widgets")
	public void the_user_validates_right_rail_widgets()
	{
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateRightRail();
	}
	
	
	

}
	

		
		
		
	
	

