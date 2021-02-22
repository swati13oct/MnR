package acceptancetests.acquisition.vpp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.vppforaep.AepPlanDetailsPage;
import pages.acquisition.vppforaep.AepVppPlanSummaryPage;
import pages.acquisition.vppforaep.DCEdatechangePage;

/**
 * Functionality: VPP flow for AARP site 
 */

public class AepVppStepDefinitionUlayer {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public static final String CurrentYear = "2019";
	public static final String NextYear = "2020";

	/**
	 * @toDo:user is on AARP medicare acquisition site landing page
	 */

	@Then("^the user is on team-f dce date change url and changes DCE server date to following date$")
	public void the_user_changes_the_DCE_server_date_to_the_following_date(DataTable arg1) throws Throwable {
		WebDriver wd = getLoginScenario().getWebDriver();
		DCEdatechangePage dceDateChangePage = new DCEdatechangePage(wd);
		List<DataTableRow> datechangerow = arg1
				.getGherkinRows();
		Map<String, String> DateChangeMap = new HashMap<String, String>();
		for (int i = 0; i < datechangerow.size(); i++) {

			DateChangeMap.put(datechangerow.get(i).getCells()
					.get(0), datechangerow.get(i).getCells().get(1));
		}

		String DCEdate = DateChangeMap.get("DCE Date");
		boolean ValidationStatus = dceDateChangePage.setAndValidate_DCEserverDate(DCEdate);
		if(ValidationStatus){
			getLoginScenario().saveBean(VPPCommonConstants.AEP_FLAG, "true");
			Thread.sleep(5000);
			wd.close();
			wd.quit();
		}
		else
			Assert.fail("DCE date change failed");
	}


	@Then("^the user validates Current year and next year links in VPP$")
	public void the_user_validates_Current_year_and_next_year_links_in_VPP() throws Throwable {
		pages.acquisition.ulayer.VPPPlanSummaryPage plansummaryPage = (pages.acquisition.ulayer.VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String AEP_Flag = "true";
		getLoginScenario().saveBean(VPPCommonConstants.AEP_FLAG, AEP_Flag);

		System.out.println("Next Year : "+NextYear);
		System.out.println("Current Year : "+CurrentYear);

		if (AEP_Flag.contains("true")){
			AepVppPlanSummaryPage aepVppPlanSummarypage = plansummaryPage.validate_aepPlanYearLinks(CurrentYear, NextYear );
			if(aepVppPlanSummarypage!=null){
				getLoginScenario().saveBean(VPPCommonConstants.CURRENT_YEAR, CurrentYear);
				getLoginScenario().saveBean(VPPCommonConstants.NEXT_YEAR, NextYear);
				getLoginScenario().saveBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE, aepVppPlanSummarypage);
			}
			else
				Assert.fail("VPP Page for AEP Period is not Displayed");
		}
	}

	@Then("^the user validates Current year and next year links in Blayer VPP$")
	public void the_user_validates_Current_year_and_next_year_links_in_VPP_BlueLayer() throws Throwable {
		pages.acquisition.bluelayer.VPPPlanSummaryPage plansummaryPage = (pages.acquisition.bluelayer.VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String AEP_Flag = "true";
		getLoginScenario().saveBean(VPPCommonConstants.AEP_FLAG, AEP_Flag);

		System.out.println("Next Year : "+NextYear);
		System.out.println("Current Year : "+CurrentYear);

		if (AEP_Flag.contains("true")){
			AepVppPlanSummaryPage aepVppPlanSummarypage = plansummaryPage.validate_aepPlanYearLinks(CurrentYear, NextYear );
			if(aepVppPlanSummarypage!=null){
				getLoginScenario().saveBean(VPPCommonConstants.CURRENT_YEAR, CurrentYear);
				getLoginScenario().saveBean(VPPCommonConstants.NEXT_YEAR, NextYear);
				getLoginScenario().saveBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE, aepVppPlanSummarypage);
			}
			else
				Assert.fail("VPP Page for AEP Period is not Displayed");
		}
	}

	@Then("^the user validates Next year Plan summary Page for pre-AEP for below plan$")
	public void the_user_validates_Next_year_Plan_summary_Page_for_pre_AEP_for_below_plan(DataTable arg1) throws Throwable {
		List<DataTableRow> planNamerow = arg1
				.getGherkinRows();
		Map<String, String> PlanNameMap = new HashMap<String, String>();
		for (int i = 0; i < planNamerow.size(); i++) {

			PlanNameMap.put(planNamerow.get(i).getCells()
					.get(0), planNamerow.get(i).getCells().get(1));
		}
		String PlanName = PlanNameMap.get("NextYear Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.NEXTYEAR_PLAN_NAME, PlanName);
		AepVppPlanSummaryPage aepVppPlanSummarypage = (AepVppPlanSummaryPage) getLoginScenario().getBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE);

		boolean ValidationStatus = aepVppPlanSummarypage.Validate_preAEP_NextYearPlanSummary(PlanName);
		getLoginScenario().saveBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE, aepVppPlanSummarypage);
		Assert.assertTrue("Validation failed - Enroll button displayed for next year pre-AEP Plan Summary Page", ValidationStatus);;
	}

	@When("^the user view plan details of the Next Year plan$")
	public void user_views_plandetails_nextYear_plan_aarp() {
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.NEXTYEAR_PLAN_NAME);

		AepVppPlanSummaryPage aepPlanSummaryPage = (AepVppPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE);

		String planType = (String)getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		AepPlanDetailsPage aepPlanDetailsPage = aepPlanSummaryPage
				.navigateToPlanDetails(PlanName, planType);

		if (aepPlanDetailsPage != null) 
			getLoginScenario().saveBean(PageConstants.AEP_VPP_PLAN_DETAILS_PAGE,
					aepPlanDetailsPage);
		else
			Assert.fail("Error in validating the Plan Details Page for AEP");
	}

	@When("^the user view plan details of the Current Year plan$")
	public void user_views_plandetails_currentYear_plan_aarp() {
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.CURRENTYEAR_PLAN_NAME);

		AepVppPlanSummaryPage aepPlanSummaryPage = (AepVppPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE);

		String planType = (String)getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		AepPlanDetailsPage aepPlanDetailsPage = aepPlanSummaryPage
				.navigateToPlanDetails(PlanName, planType);

		if (aepPlanDetailsPage != null) 
			getLoginScenario().saveBean(PageConstants.AEP_VPP_PLAN_DETAILS_PAGE,
					aepPlanDetailsPage);
		else
			Assert.fail("Error in validating the Plan Details Page for AEP");
	}

	@Then("^the user validates Next year Plan details Page for pre-AEP$")
	public void the_user_validates_Next_year_Plan_details_Page_for_pre_AEP() throws Throwable {
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.NEXTYEAR_PLAN_NAME);
		String NextYear = (String) getLoginScenario().getBean(VPPCommonConstants.NEXT_YEAR);

		AepPlanDetailsPage aepPlanDetailsPage = (AepPlanDetailsPage) getLoginScenario().getBean(PageConstants.AEP_VPP_PLAN_DETAILS_PAGE);
		boolean ValidationStatus = aepPlanDetailsPage.Validate_preAEP_NextYearPlanDetails(PlanName, NextYear);
		Assert.assertTrue("Validation failed - Enroll button displayed for next year pre-AEP Plan Details Page", ValidationStatus);;

	}

	@Then("^the user returns to Plan Summary page$")
	public void the_user_returns_to_Plan_Summary_page() throws Throwable {
		AepPlanDetailsPage aepPlanDetailsPage = (AepPlanDetailsPage) getLoginScenario().getBean(PageConstants.AEP_VPP_PLAN_DETAILS_PAGE);
		AepVppPlanSummaryPage aepPlanSummaryPage = aepPlanDetailsPage.navigateToPlanSummaryPage();
		if(aepPlanSummaryPage!=null){
			getLoginScenario().saveBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE, aepPlanSummaryPage);
		}
		else
			Assert.fail("VPP Page for AEP Period is not Displayed");
	}

	@Then("^the user validates Current year Plan Summary Page for pre-AEP$")
	public void the_user_validates_Current_year_Plan_Summary_Page_for_pre_AEP(DataTable arg1) throws Throwable {
		List<DataTableRow> planNamerow = arg1
				.getGherkinRows();
		Map<String, String> PlanNameMap = new HashMap<String, String>();
		for (int i = 0; i < planNamerow.size(); i++) {

			PlanNameMap.put(planNamerow.get(i).getCells()
					.get(0), planNamerow.get(i).getCells().get(1));
		}
		String PlanName = PlanNameMap.get("CurrentYear Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.CURRENTYEAR_PLAN_NAME, PlanName);
		AepVppPlanSummaryPage aepVppPlanSummarypage = (AepVppPlanSummaryPage) getLoginScenario().getBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE);
		String CurrentYear = (String) getLoginScenario().getBean(VPPCommonConstants.CURRENT_YEAR);
		aepVppPlanSummarypage.ClickCurrentYearLink();
		boolean ValidationStatus = aepVppPlanSummarypage.Validate_preAEP_AEP_CurrentYearPlanSummary(PlanName);
		getLoginScenario().saveBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE, aepVppPlanSummarypage);
		Assert.assertTrue("Validation failed - Enroll button NOT displayed for Current year pre-AEP Plan Summary Page", ValidationStatus);;
	}

	@Then("^the user validates Current year Plan Details Page for pre-AEP$")
	public void the_user_validates_Current_year_Plan_Details_Page_for_pre_AEP() throws Throwable {
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.CURRENTYEAR_PLAN_NAME);
		String CurrentYear = (String) getLoginScenario().getBean(VPPCommonConstants.CURRENT_YEAR);

		AepPlanDetailsPage aepPlanDetailsPage = (AepPlanDetailsPage) getLoginScenario().getBean(PageConstants.AEP_VPP_PLAN_DETAILS_PAGE);
		boolean ValidationStatus = aepPlanDetailsPage.Validate_preAEP_CurrentYearPlanDetails(PlanName, CurrentYear);
		Assert.assertTrue("Validation failed - Enroll button is NOT displayed for next year pre-AEP Plan Details Page", ValidationStatus);;
	}

	@Then("^the user validates Next year Plan summary Page for AEP enrollment period for below plan$")
	public void the_user_validates_Next_year_Plan_summary_Page_for_AEP_enrollment_period_for_below_plan(DataTable arg1) throws Throwable {
		List<DataTableRow> planNamerow = arg1
				.getGherkinRows();
		Map<String, String> PlanNameMap = new HashMap<String, String>();
		for (int i = 0; i < planNamerow.size(); i++) {

			PlanNameMap.put(planNamerow.get(i).getCells()
					.get(0), planNamerow.get(i).getCells().get(1));
		}
		String PlanName = PlanNameMap.get("NextYear Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.NEXTYEAR_PLAN_NAME, PlanName);
		AepVppPlanSummaryPage aepVppPlanSummarypage = (AepVppPlanSummaryPage) getLoginScenario().getBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE);

		boolean ValidationStatus = aepVppPlanSummarypage.Validate_AEP_NextYearPlanSummary(PlanName);
		getLoginScenario().saveBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE, aepVppPlanSummarypage);
		Assert.assertTrue("Validation failed - Enroll button displayed for next year pre-AEP Plan Summary Page", ValidationStatus);;
	}

	@Then("^the user validates Next year Plan details Page for AEP enrollment period$")
	public void the_user_validates_Next_year_Plan_details_Page_for_AEP_enrollment_period() throws Throwable {
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.NEXTYEAR_PLAN_NAME);
		String NextYear = (String) getLoginScenario().getBean(VPPCommonConstants.NEXT_YEAR);

		AepPlanDetailsPage aepPlanDetailsPage = (AepPlanDetailsPage) getLoginScenario().getBean(PageConstants.AEP_VPP_PLAN_DETAILS_PAGE);
		boolean ValidationStatus = aepPlanDetailsPage.Validate_AEP_NextYearPlanDetails(PlanName, NextYear);
		Assert.assertTrue("Validation failed - Enroll button displayed for next year pre-AEP Plan Details Page", ValidationStatus);;


	}

	@Then("^the user validates Current year Plan Summary Page for AEP enrollment period$")
	public void the_user_validates_Current_year_Plan_Summary_Page_for_AEP_enrollment_period(DataTable arg1) throws Throwable {
		List<DataTableRow> planNamerow = arg1
				.getGherkinRows();
		Map<String, String> PlanNameMap = new HashMap<String, String>();
		for (int i = 0; i < planNamerow.size(); i++) {

			PlanNameMap.put(planNamerow.get(i).getCells()
					.get(0), planNamerow.get(i).getCells().get(1));
		}
		String PlanName = PlanNameMap.get("CurrentYear Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.CURRENTYEAR_PLAN_NAME, PlanName);
		AepVppPlanSummaryPage aepVppPlanSummarypage = (AepVppPlanSummaryPage) getLoginScenario().getBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE);
		String CurrentYear = (String) getLoginScenario().getBean(VPPCommonConstants.CURRENT_YEAR);
		aepVppPlanSummarypage.ClickCurrentYearLink();
		boolean ValidationStatus = aepVppPlanSummarypage.Validate_preAEP_AEP_CurrentYearPlanSummary(PlanName);
		getLoginScenario().saveBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE, aepVppPlanSummarypage);
		Assert.assertTrue("Validation failed - Enroll button NOT displayed for Current year pre-AEP Plan Summary Page", ValidationStatus);;

	}

	@Then("^the user validates Current year Plan Details Page for AEP enrollment period$")
	public void the_user_validates_Current_year_Plan_Details_Page_for_AEP_enrollment_period() throws Throwable {
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.CURRENTYEAR_PLAN_NAME);
		String CurrentYear = (String) getLoginScenario().getBean(VPPCommonConstants.CURRENT_YEAR);

		AepPlanDetailsPage aepPlanDetailsPage = (AepPlanDetailsPage) getLoginScenario().getBean(PageConstants.AEP_VPP_PLAN_DETAILS_PAGE);
		boolean ValidationStatus = aepPlanDetailsPage.Validate_preAEP_CurrentYearPlanDetails(PlanName, CurrentYear);
		Assert.assertTrue("Validation failed - Enroll button is NOT displayed for next year pre-AEP Plan Details Page", ValidationStatus);;

	}

	@Then("^the user validates Current year Plan Summary Page for Non enrollment period$")
	public void the_user_validates_Current_year_Plan_Summary_Page_for_Non_enrollment_period() throws Throwable {
		AepVppPlanSummaryPage aepVppPlanSummarypage = (AepVppPlanSummaryPage) getLoginScenario().getBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE);
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.CURRENTYEAR_PLAN_NAME);
		String CurrentYear = (String) getLoginScenario().getBean(VPPCommonConstants.CURRENT_YEAR);
		aepVppPlanSummarypage.ClickCurrentYearLink();
		boolean ValidationStatus = aepVppPlanSummarypage.Validate_PostAEP_AEP_CurrentYearPlanSummary(PlanName);
		getLoginScenario().saveBean(PageConstants.AEP_VPP_PLAN_SUMMARY_PAGE, aepVppPlanSummarypage);
		Assert.assertTrue("Validation failed - Enroll button NOT displayed for Current year pre-AEP Plan Summary Page", ValidationStatus);;

	}

	@Then("^the user validates Current year Plan Details Page for Non enrollment period$")
	public void the_user_validates_Current_year_Plan_Details_Page_for_Non_enrollment_period() throws Throwable {
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.CURRENTYEAR_PLAN_NAME);
		String CurrentYear = (String) getLoginScenario().getBean(VPPCommonConstants.CURRENT_YEAR);

		AepPlanDetailsPage aepPlanDetailsPage = (AepPlanDetailsPage) getLoginScenario().getBean(PageConstants.AEP_VPP_PLAN_DETAILS_PAGE);
		boolean ValidationStatus = aepPlanDetailsPage.Validate_PostAEP_CurrentYearPlanDetails(PlanName, CurrentYear);
		Assert.assertTrue("Validation failed - Enroll button is NOT displayed for next year pre-AEP Plan Details Page", ValidationStatus);;
	}



}