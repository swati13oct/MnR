package acceptancetests.mobile.acquisition.dceredesign;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.dceredesign.TellUsAboutDrug;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.VisitorProfilePage;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;
import pages.mobile.acquisition.dceredesign.TellUsAboutDrugMobile;
import pages.mobile.acquisition.dceredesign.ZipCodeAndPlanYearCapturePageMobile;
import pages.mobile.acquisition.ulayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.ulayer.ComparePlansPageMobile;
import pages.mobile.acquisition.ulayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.ulayer.PlanDetailsPageMobile;
import pages.mobile.acquisition.ulayer.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.ulayer.VisitorProfilePageMobile;
//import pages.mobile.acquisition.ulayer.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality:DCE Acquisition
 */
public class DCEACQVPPPlanCompareMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;

	@Given("^I select \"([^\"]*)\" plans to compare and click on compare plan link$")
	public void i_select_plans_to_compare_and_click_on_compare_plan_link_in_AARP(String planType) throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if (planType.equals("MAPD")) {
			plansummaryPage.checkAllMAPlans();
			System.out.println("Selected All MAPD plans for Plan Compare");
		} else if (planType.equals("PDP")) {
			plansummaryPage.checkAllPDPlans();
			System.out.println("Selected All PDP plans for Plan Compare");
		}
		ComparePlansPageMobile planComparePage = plansummaryPage.clickOnCompareLinkAARP(planType);
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			
		} else
			Assert.fail("Error in loading the compare plans page");
	}
	
	
	@When("^I access the DCE Redesign from Plan compare page$")
	public void the_user_navigates_to_dce_from_plan_compare_site() throws Throwable {
		ComparePlansPageMobile planComparepage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		GetStartedPageMobile getStartedPage = planComparepage.navigateToDCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}
	
	@Then("^the user clicks on return to compare link on build drug list page to returns to plan compare$")
	public void the_user_Clicks_button_to_VPP_Plan_Compare_Page_from_Drug_details_Page() throws Throwable {
		BuildYourDrugListMobile buildDrugListPage = (BuildYourDrugListMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		ComparePlansPageMobile planComparePage = buildDrugListPage.returnToPlanComparePage();
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

	}
	
	
	@Then("^the user validates drug is displayed on the plan compare page$")
	public void the_userValidatesDrugInfo(DataTable attributes) throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		
		String drug = memberAttributesRow.get(0).getCells().get(1);
		planComparePage.validateDrugInfo(drug);
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

	}

}
