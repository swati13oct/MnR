package acceptancetests.mobile.acquisition.dceredesign;

import java.util.List;
import io.appium.java_client.AppiumDriver;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.ComparePlansPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;
//import pages.mobile.acquisition.ulayer.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;

/**
 * Functionality:DCE Acquisition
 */
public class DCEACQVPPPlanCompareMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	//AppiumDriver wd;
	
	@And("^the user click on return to plan summary from Drug Details Page to return to VPP Plan Summary$")
	public void the_user_clicks_on_returnlink_to_vpp_planSummary_DrugDetails() {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		VPPPlanSummaryPageMobile plansummaryPage = drugDetailsPage.ClickReturnToBtnToVPPSummary();
		if (null != plansummaryPage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	
	@Then("^user saves plan as favorite on vpp summary page$")
	public void user_saves_plan_as_favorite_on_UMS_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		System.out.println("Plan name" + PlanName);
		plansummaryPage.savePlan(PlanName);
	}
	
	@When("^user clicks view drug cost button$")
	public void user_clicks_view_drug_cost_button_in_AARP() throws InterruptedException {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		/*drugSummaryPage.clickViewDrugCostBtn();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);*/
		DrugDetailsPageMobile drugDetailsPage = drugSummaryPage.clickViewDrugCostBtn();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Given("^user is on AARP site$")
	public void the_user_on__medicaresolutions_Site(DataTable givenAttributes) {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		//aquisitionhomepage.openPRE();
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^I access the DCE Redesign from Plan compare page$")
	public void the_user_navigates_to_dce_from_plan_compare_site() throws Throwable {
		ComparePlansPageMobile planComparepage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		GetStartedPageMobile getStartedPage = planComparepage.navigateToDCERedesign();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^the user clicks on return to compare link on build drug list page to returns to plan compare$")
	public void the_user_Clicks_button_to_VPP_Plan_Compare_Page_from_Drug_details_Page() throws Throwable {
		BuildYourDrugListMobile buildDrugListPage = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		ComparePlansPageMobile planComparePage = buildDrugListPage.returnToPlanComparePage();
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

	}

	@Then("^the user validates drug is displayed on the plan compare page$")
	public void the_userValidatesDrugInfo(DataTable attributes) throws Throwable {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
//		List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();

//		String drug = memberAttributesRow.get(0).getCells().get(1);
		String drug = attributes.cell(0, 1);
		planComparePage.validateDrugInfo(drug);
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

	}

}
