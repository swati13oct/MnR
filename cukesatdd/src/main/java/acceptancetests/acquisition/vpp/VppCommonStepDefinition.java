package acceptancetests.acquisition.vpp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.commonpages.FindCarePage;
import pages.acquisition.commonpages.ProviderSearchPage;
import pages.acquisition.commonpages.AgentsnBrokersAARPPage;
import pages.acquisition.commonpages.DisclaimersAARPPage;
import pages.acquisition.commonpages.PrivacyPolicyAARPPage;
import pages.acquisition.commonpages.SiteMapAARPPage;
import pages.acquisition.commonpages.ContactUsAARPPage;
import pages.acquisition.commonpages.AboutUsAARPPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.MultiCountyModalPage;

/**
 * Functionality: VPP flow for AARP site
 */

public class VppCommonStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver wd;

	/**
	 * @toDo:user is on medicare acquisition site landing page
	 */

	@Given("^the user is on medicare acquisition site landing page$")
	public void the_user_on__medicaresolutions_Site(DataTable givenAttributes) {
		wd = getLoginScenario().getWebDriverNew();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String site = memberAttributesMap.get("Site");
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, site);
 
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		aquisitionhomepage.validateSubtitle();
	}

	@When("^the user performs plan search using following information$")
	public void zipcode_details_in_aarp_site(DataTable givenAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = null;
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty(zipcode);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	@Then("^the user navigates to the plan details for the given plan type$")
	public void the_user_navigates_to_the_plan_details_for_the_given_plan_type_in_AARP_site(DataTable data)
			throws Throwable {
		wd.manage().window().maximize();
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String planType = memberAttributesRow.get(0).getCells().get(1);
		String planName = memberAttributesRow.get(1).getCells().get(1);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		//plansummaryPage.viewPlanSummary(planType);
		PlanDetailsPage plandetailspage= plansummaryPage.navigateToPlanDetails(planName, planType);
		
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
			getLoginScenario().saveBean(DCERedesignCommonConstants.PLANTYPE, planType);
			getLoginScenario().saveBean(DCERedesignCommonConstants.PLANNAME, planName);

		}

	@And("^the user views the plans of the below plan type$")
	public void user_performs_planSearch_in_aarp_site(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);

	}

	@When("the user selects plan year$")
	public void user_selects_plan_year(DataTable givenAttributes) {

		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planYear = givenAttributesMap.get("Plan Year");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.handlePlanYearSelectionPopup(planYear);
	}

	@Given("^I select \"([^\"]*)\" plans to compare and click on compare plan link$")
	public void i_select_plans_to_compare_and_click_on_compare_plan_link_in_AARP(String planType) throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if (planType.equals("MAPD")) {
			plansummaryPage.checkAllMAPlans();
			System.out.println("Selected All MAPD plans for Plan Compare");
		} else if (planType.equals("PDP")) {
			plansummaryPage.checkAllPDPlans();
			System.out.println("Selected All PDP plans for Plan Compare");
		}
		ComparePlansPage planComparePage = plansummaryPage.clickOnCompareLink(planType);
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@Then("^verify plan compare page is loaded$")
	public void verify_plan_compare_page_is_loaded_on_AARP() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatePlanComparePage();
	}

	@And("^the user views the plans of the below plan type and select Next year$")
	public void user_performs_planSearch_in_aarp_site_next_year(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		if (!plantype.equalsIgnoreCase("MS"))
			plansummaryPage.handlePlanYearSelectionPopup();
	}

	@And("^the user validates plan summary for the below plan$")
	public void user_validates_plan_summary(DataTable planAttributes) throws InterruptedException {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assert.assertTrue("Error loading specific plan summary in VPP plan summary page",
				planSummaryPage.getSpecificPlanInfo(planName));

	}

	@Then("^the user validates marketing bullets of the plan$")
	public void validate_marketingBullets() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		plansummaryPage.validateMarketingBullets(planType, planName);
	}

	/**
	 * @throws InterruptedException
	 * @toDo:user validates add to compare checkbox on Plan Card
	 */
	@Then("^the user validates and clicks Add to compare checkbox for the above selected plan for MA, MAPD , PDP Plans$")
	public void user_validates_addtocompare_aarp() throws InterruptedException {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("SNP")) {
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.validateAndClickAddtoCompare(planType, planName);
			plansummaryPage.compareTextAfterclickingAddtoCompareinAARP(planName);
			plansummaryPage.deselectAddToCompare(planName);
		}
	}

	/**
	 * @toDo:user view plan details of the above selected plan in AARP site and
	 *            validates
	 */
	@Then("^the user views plan details of the above selected plan and validates$")
	public void user_views_plandetails_selected_plan_aarp(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName,planType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		vppPlanSummaryPage.clickOnViewMoreForPlan(PlanName);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Details Page");

	}

	@Then("^the user clicks on back to all plans link and validates its redirection to Plan Summary$")
	public void User_clicks_BackToPlansLink_and_validates_redirection() {

		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		VPPPlanSummaryPage plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPageFromDetailsPage();
		if (plansummaryPage != null) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the Plan Summary Page");
	}

	@Then("^the user validates below plan benefit values for the above selected plan$")
	public void user_validates_planBenefitValues_inAARP(DataTable givenAttributes) {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String primaryCarePhysician = memberAttributesMap.get("Primary Care Physician");
		String specialist = memberAttributesMap.get("Specialist");
		String referralRequired = memberAttributesMap.get("Referral Required");
		String outOfPocketMaximum = memberAttributesMap.get("Out Of Pocket Maximum");
		String prescriptionDrugsTier1 = memberAttributesMap.get("Prescription Drugs, Tier 1");
		String annualDeductible = memberAttributesMap.get("Annual Deductible");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		plansummaryPage.clickOnViewMoreForPlan(planName);
		plansummaryPage.validatePlanPremium(planName, monthlyPremium);
		plansummaryPage.validatePrescriptionDrugsTier1(planName, planType, prescriptionDrugsTier1);
		if (!planType.equals("PDP")) {
			plansummaryPage.validatePrimaryCarePhysicianBenefit(planType, planName, primaryCarePhysician);
			plansummaryPage.validateSpecialistBenefit(planType, planName, specialist);
			plansummaryPage.validateReferrralRequiredBenefit(planName, referralRequired);
			plansummaryPage.validatesOutOfPocketMaximum(planName, outOfPocketMaximum);

		} else {
			plansummaryPage.validateAnnualDeductible(planName, annualDeductible);

		}
	}

	@Then("^the user hover overs the tool tip for Why is my premium 0 and validates the text$")
	public void toolTip_premium0_validateText() throws Throwable {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (planType.equals("MA") || planType.equals("MAPD")) {
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.toolTipForPremium0(planName);
		} else if (planType.equals("PDP")) {
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.toolTipForAnnualDeductible(planName);
		}
	}

	@Then("^the user validates Is my provider covered link$")
	public void user_validates_IsMyProviderCoveredLink_aarp() throws InterruptedException {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		plansummaryPage.clickOnViewMoreForPlan(planName);
		plansummaryPage.validateIsMyProviderCoveredLink(planType, planName);

	}

	@Then("^the user clicks on Enroll Now and validates the Welcome to OLE Page")
	public void user_clicks_enrollInPlan_validates_welcomeOLE() throws InterruptedException {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		WelcomePage welcomeOLEPage = plansummaryPage.Enroll_OLE_Plan(planName, planType);
		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assert.fail("Error Loading Welcome Page for OLE");
		}
	}

	@Then("^the site user clicks on Start Application Button proceed to next pages$")
	public void Start_application_button(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String DateOfBirth = memberAttributesMap.get("DOB");
		String FirstName = memberAttributesMap.get("Firstname");
		String LastName = memberAttributesMap.get("Lastname");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation(DateOfBirth);
		String resumeKey = plansummaryPage.StartApplicationButton(FirstName, LastName);
		getLoginScenario().saveBean(VPPCommonConstants.RESUMEKEY, resumeKey);

	}

	@Then("^user clicks on resume application button$")
	public void click_resume_application(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String DateOfBirth = memberAttributesMap.get("DOB");
		String FirstName = memberAttributesMap.get("Firstname");
		String LastName = memberAttributesMap.get("Lastname");
		// VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage)
		// getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// plansummaryPage.MedSupFormValidation(DateOfBirth);
		System.out.println("***the user clicks on resume application button***");
		VPPPlanSummaryPage plansummaryPage1 = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage1.ResumeApplicationButton(DateOfBirth);

	}

	@And("^the user signs in with optum Id$")
	public void the_user_signs_in_with_optum_Id(DataTable credentials) {
		List<DataTableRow> plannameAttributesRow = credentials.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String username = plannameAttributesMap.get("User Name");
		String password = plannameAttributesMap.get("Password");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.signInOptumId(username, password);
	}

	@Then("^the user validate retrieve application URL$")
	public void the_user_retrieve_application_URL_in_AARPSite(DataTable arg1) throws InterruptedException {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String AARPURL = inputAttributesMap.get("AARP URL");
		String AARPURLSTG = inputAttributesMap.get("AARP URL STG");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if (getLoginScenario().environment.equals("stage")) {
			plansummaryPage.RetrieveURL(AARPURLSTG);
		} else {
			plansummaryPage.RetrieveURL(AARPURL);
		}

	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@Then("^user validates plan count for all plan types on plan summary page$")
	public void user_validates_following_benefits_ui_aarp() {

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assert.assertTrue("Error validating plans in  VPP plan summary page",
				plansummaryPage.validateVPPPlanSummaryPage());
		String SiteName = "AARP_ACQ";
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
	}

	/**
	 * @toDo:user validates the available plans for selected plan types
	 */
	@Then("^the user validates the available plans for selected plan types$")
	public void user_validates_available_plans_aarp() {

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (plansummaryPage.validatePlanNames(planType)) {
			String SiteName = "AARP_ACQ";
			getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error validating availables plans for selected plantype in  VPP plan summary page");
		}
	}

// 	@When("^the user enters zipcode on health plans page$")
// 	public void enters_zipcode_details_in_aarp_site(DataTable givenAttributes) throws InterruptedException {
// 		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
// 		Map<String, String> memberAttributesMap = new HashMap<String, String>();
// 		for (int i = 0; i < memberAttributesRow.size(); i++) {
// 			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
// 					memberAttributesRow.get(i).getCells().get(1));
// 		}
// 		String zipcode = memberAttributesMap.get("Zip Code");
// 		String county = memberAttributesMap.get("County Name");
// 		String isMultiCounty = memberAttributesMap.get("Is Multi County");
// 		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
// 		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
// 		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);


// 		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
// 				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
// 		VPPPlanSummaryPage plansummaryPage = null;
// 		plansummaryPage = aquisitionhomepage.searchPlanOnHealthPlansPage(zipcode, county, isMultiCounty);

// 			String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
// 			if (plansummaryPage.validatePlanNames(planType)) {
// 				String SiteName = "AARP_ACQ";
// 				getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
// 				Assert.assertTrue(true);
// 			} else {
// 				Assert.fail("Error validating availables plans for selected plantype in  VPP plan summary page");
// 			}
// 		}
		
	@When("^the user enters zipcode on health plans page$")
	public void enters_zipcode_details_in_aarp_site(DataTable givenAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = null;
		plansummaryPage = aquisitionhomepage.searchPlanOnHealthPlansPage(zipcode, county, isMultiCounty);

			
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	@Then("^user saves two plans as favorite$")
	public void user_saves_two_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			String savePlanNames = memberAttributesMap.get("Test Plans");
			String planType = memberAttributesMap.get("Plan Type");

			plansummaryPage.savePlans(savePlanNames, planType);
		}
			
			
	@Then("^user gets a create profile prompt$")
	public void user_saves_two_plans_as_favorite_on_AARP_site() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.validateCreateProfilePrompt();
		
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		
	}

	@And("^user click on continue as guest button$")
	public void user_click_on_continue_as_guest_button_on_AARP_site() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		VisitorProfilePage visitorProfilePage = plansummaryPage.continueAsGuest();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);

	}

	@Then("^the user validates the right rail$")
	public void user_validates_rightRail() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateRightRailSection();
	}

	@Then("^the user validates the Need Help Section in the right rail$")
	public void validate_needHelp_rightRail() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateNeedHelpRightRail();
	}

	@Then("^the user validates the TFN in the Need Help Section$")
	public void validate_TFN_inRIghtRail_aarp() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.GetTFNforPlanType();
	}

	@Then("^the user validates and clicks on Find an agent$")
	public void validateAndClick_findAgentInYourArea_RightRail() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateAgentEBRCPage();
	}

	@Then("^the user validates Get a free medicare Guide section in the right rail$")
	public void validate_freeMedicareGuide_rightRail() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateMedicareGuideRightRail();
	}

	@Then("^the user enters the following information in the Get a free medicare Guide section$")
	public void user_enters_necessaryInformation_inGetFreeMedicareGuideSection(DataTable givenAttributes)
			throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		plansummaryPage.enterRequiredFieldsForMedicareGuide(memberAttributesMap);

	}

	@Then("^the user validates Plan Selector Tool section in the right rail$")
	public void validate_planSelectorTool_rightRail() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validatePlanSelectorToolRightRail();
	}

	@Then("^the user validates Plan Selector Page after clicking on Start Plan Selector button$")
	public void user_validate_planSelectorPage_inaarpSite() throws Exception {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validatePlanSelectorPageInRightRail();
	}

	@When("^the user performs Change Location on Plan Summary Page using following MultiCounty Zip information$")
	public void the_user_performs_Change_Location_on_Plan_Summary_Page_using_following_MultiCounty_Zip_information(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		MultiCountyModalPage multiCountyModalPage = plansummaryPage.VPP_ChangeLocationValidateMultiCOuntyPopUp(zipcode);

		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, multiCountyModalPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}

	}

		@Then("^the user validates the following Additional Benefits of Plan for the plan$")
		public void the_user_validates_the_following_Additional_Benefits_of_Plan_for_the_plan_in_AARP(DataTable givenAttributes) throws Throwable {
			List<DataTableRow> additionalBenefits = givenAttributes.getGherkinRows();
      
      PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(additionalBenefits);
		}
		
		@Then("^user saves two ms plans as favorite$")
		public void user_saves_two_ms_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}

//			Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
			String ms_savePlanNames = memberAttributesMap.get("MS Test Plans");

			//----- MS plan type ----------------------------
			plansummaryPage.saveMSPlans(ms_savePlanNames);

		}
		
		@Then("^Navigate to Visitor Profile page$")
		public void navigate_to_Visitor_Profile_page_on_AARP_site() {
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			VisitorProfilePage visitorProfilePage = plansummaryPage.navigateToVisitorProfilePage();
			getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		}
		
		@Then("^user saves all plans as favorite$")
		public void user_saves_all_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}

//			Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
			String savePlanNames = memberAttributesMap.get("Test Plans");
			String planType = memberAttributesMap.get("Plan Type");
			
			plansummaryPage.saveAllPlans(savePlanNames, planType);
		}
		
		

	@Then("^the user validates the Cancel button for Multi County Pop-up lands on enter Zip code Page$")
	public void the_user_validates_the_Cancel_button_for_Multi_COunty_Pop_up_lands_on_enter_Zip_code_Page() throws Throwable {
		MultiCountyModalPage multiCountyModalPage = (MultiCountyModalPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean Validation_Flag = multiCountyModalPage.validateMultiCounty_CancelButton();
		Assert.assertTrue("Validation failed : Cancel button Validation for Multi County Pop-up Failed ",Validation_Flag);

	}

	@When("^verify Call SAM icon is visible$")
	public void verify_Call_SAM_icon_is_visible() throws InterruptedException {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSam();
		/*
		 * if (Aquisitionhomepage != null) {
		 * getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
		 * Aquisitionhomepage); Assert.assertTrue(true);
		 * System.out.println("TFN Widget is Displayed"); } else{
		 * Assert.fail("TFN Widget is NOT Displayed"); }
		 */
	}

	@And("^verify call SAM roll out and contain the text Call a Licensed Insurance Agent$")
	public void verify_call_SAM_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent()
			throws InterruptedException {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSamContent();

	}

	@Then("^user verify the popup and content on the site$")
	public void user_verify_the_popup_and_content_on_the_site() throws InterruptedException {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallpopup();
	}

	@And("^user clicks on About us link from footer of the Medicare Plans home page$")
	public void click_about_us() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AboutUsAARPPage aboutUsAARPPage = aquisitionhomepage.aboutUsFooterClick();
		if (aboutUsAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_ABOUT_US_PAGE, aboutUsAARPPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Aboutus page not found");
		}

	}

	@And("^user clicks on contact us link of aboutus page$")
	public void click_contact_us() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ContactUsAARPPage contactUsAARPPage = aquisitionhomepage.contactUsFooterClick();
		if (contactUsAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_Contact_US_PAGE, contactUsAARPPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("contactus page not found");
		}
	}

	@And("^user clicks on sitemap link of contact us page$")
	public void click_sitemap() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		SiteMapAARPPage siteMapAARPPage = aquisitionhomepage.siteMapFooterClick();
		if (siteMapAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_SITE_MAP_PAGE, siteMapAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("sitemap page not found");
		}
	}

	@And("^user clicks on privacy policy link of sitemap page$")
	public void click_privacypolicy() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PrivacyPolicyAARPPage privacyPolicyAARPPage = aquisitionhomepage.privacypolicyFooterClick();
		if (privacyPolicyAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_PRIVACY_POLICY_PAGE, privacyPolicyAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("privacypolicy page not found");
		}
	}

	@And("^user clicks on disclaimers link of terms & conditions page$")
	public void click_disclaimers() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersAARPPage disclaimersAARPPage = aquisitionhomepage.disclaimersFooterClick();
		if (disclaimersAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_DISCLAIMERS_PAGE, disclaimersAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("disclaimers page not found");
		}
	}

	@And("^user clicks on agents & brokers link of disclaimers page$")
	public void click_agentsnbrokers() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AgentsnBrokersAARPPage agentsnBrokersAARPPage = aquisitionhomepage.agentsnbrokersFooterClick();
		if (agentsnBrokersAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_AGENTS_AND_BROKERS_PAGE, agentsnBrokersAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("agents&brokers page not found");
		}
	}

	@And("^user verifies home link of agents & brokers page$")
	public void click_home() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePage aquisitionHomePageReload = aquisitionhomepage.homeFooterClick();
		Assert.assertTrue("home page not found", aquisitionHomePageReload != null);
	}

	@Then("^the user clicks on Learn More for Rocky Mountain plans$")
	public void the_user_clicks_on_Learn_More__for_Rocky_Mountain_plans(DataTable planAttributes) throws Throwable {

		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.RockyLearnMoreButtonandValidate(planName);
	}

	@Then("^the user clicks on Learn More for people Health plans$")
	public void the_user_clicks_on_Learn_More_for_people_Health_plans(DataTable planAttributes) throws Throwable {

		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.peopleLearnMoreButtonandValidate(planName);
	}
	@Then("^the user validates following PDF link is displayed with correct document code$")
	public void the_user_validates_following_PDF_link_is_displayes_with_correct_document_code(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String PDFtype = memberAttributesMap.get("PDF type");
		String DocumentCode = memberAttributesMap.get("DocumentCode");

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		boolean validationFlag = vppPlanDetailsPage.ValidatePDFlinkIsDisplayed(PDFtype,DocumentCode);
		Assert.assertTrue("Validation failed : Expected text not displayed for riders monthly and yearly premium - ",validationFlag);
	}
	@Then("^the user click on PDF link and validates document code in site URL$")
	public void the_user_click_on_PDF_link_and_validates_document_code_in_site_URL(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String PDFtype = memberAttributesMap.get("PDF type");

		String DocumentCode = memberAttributesMap.get("DocumentCode");
		boolean validationFlag = vppPlanDetailsPage.ClickValidatePDFlink(PDFtype, DocumentCode);
		Assert.assertTrue("Validation failed : Expected Document Code is not Present in the PDF URL ",validationFlag);
	}
	@Then("^the user click on Plan costs tab and validates on site$")
	public void the_user_click_on_Plan_costs_tab_and_validates_in_site(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String yearlyPremium = memberAttributesMap.get("Yearly Premium");

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.clickAndValidatePlanCosts(monthlyPremium,yearlyPremium);
		Assert.assertTrue("Validation failed : Expected text not displayed for monthly and yearly premium - "+monthlyPremium+" "+yearlyPremium,validationFlag);
	}
	@Then("^the user click on Optional Services tab and add the rider on site$")
	public void the_user_click_on_Optional_Services_tab_and_add_the_rider_in_AARP_site(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String optionalRider = memberAttributesMap.get("Optional Rider");

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		String optionalRiderPremium = vppPlanDetailsPage.addOptionalRider(optionalRider);
	}
	@Then("^the user clicks on both top and bottom back to plans link and validate its redirection$")
	public void the_user_clicks_on_both_topand_bottom_back_to_plans_link_and_validate_its_redirection()
			throws InterruptedException {
		// getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
		// vppPlanDetailsPage);
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatetopbacktoplanslink();
		vppPlanDetailsPage.browserBack();
		vppPlanDetailsPage.validatedownbacktoplanslink();

	}

	@Then("^the user view plan details of the above selected plan in site vpp$")
	public void the_user_view_plan_details_of_the_above_selected_plan_in_UMS_site_vpp(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planName = memberAttributesRow.get(0).getCells().get(1);
		String planType = memberAttributesRow.get(1).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(planName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			// if(vppPlanDetailsPage.validatePlanDetailsPage()){
			// Assert.assertTrue(true);
			// }else
			// Assert.fail("Error in validating the Plan Details Page");

		}
	}

	@Then("^the user click on Prescription Drug Benefits and validates$")
	public void the_user_click_on_Prescription_Drug_Benefits_and_validates() throws Throwable {
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.clickAndValidatePrescriptionDrugBenefits();
	}


	@When("^the user validates the pdf section on site$")
	public void userValidatesPDFSection() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatePdfSection(planType);
	}
	@Then("^User clicks on Back to Plans link and navigate back to plan summary$")
	public void User_clicks_BackToPlansLink_and_navigate_back_to_plan_summary() {

		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		VPPPlanSummaryPage plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPageFromDetailsPage();
		if (plansummaryPage != null) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the Plan Summary Page");
	}
	
	@And("^User click on add to compare checkbox and click on view details link$")
	public void user_click_on_compare_checkbox_AARP() {
		VPPPlanSummaryPage vppplansummarypage = (VPPPlanSummaryPage) loginScenario
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.clickCompareChkBox();
		PlanDetailsPage planDetailsPage = vppplansummarypage.clickViewDetails_AddedToCompare();
		if (planDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetailsPage);
		}
	}
	
	@Then("^I uncheck and go back to the vpp page to validate for site$")
	public void uncheck_and_validate_vpp_page() {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) loginScenario.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		plandetailspage.clickCompareBox();
		VPPPlanSummaryPage vppsummarypage = plandetailspage.navigateBackToPlanSummaryPageFromDetailsPage();
			vppsummarypage.verifyPlanComapreCheckboxIsUncheckedforFirstPlan();
	}
	
	
	@Then("^the user click on Dental Cover Popup he must be able to validate plan defaults$")
	public void the_user_click_on_Optional_Services_tab_and_validate_PlanDefaults(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planName = memberAttributesMap.get("Plan Name");

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean optionalRiderFlag;
				if(memberAttributesMap.get("Optional Rider").isEmpty())
					optionalRiderFlag=false;
				else {
					String optionalRiderPremium = vppPlanDetailsPage.addOptionalRider(memberAttributesMap.get("Optional Rider"));
					optionalRiderFlag=true;
				}
		vppPlanDetailsPage.validateDentalPopupDefaults(planName,optionalRiderFlag);
	}
	
	@When("^the user navigates to the plan details page$")
	public void user_navigates_to_plan_details_page(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		System.out.println("Plan name is "+ PlanName+"Plan type is "+planType);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName,planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Details Page");

	}

	@Then("^the user Click on Look up your Provider button on Plan Details Page$")
	public void user_Clicks_on_Look_upyourProvider_button_on_PlanDetailsPage() {

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		ProviderSearchPage providerSearchPage = vppPlanDetailsPage.validateLookUpYourProviderButton();
		if(providerSearchPage!=null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}

	}
	@Then("^the user click on Plan costs tab and validates in site$")
	public void the_user_click_on_Plan_costs_tab_and_validates_in_AARP_site(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String yearlyPremium = memberAttributesMap.get("Yearly Premium");

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.clickAndValidatePlanCosts(monthlyPremium,yearlyPremium);
		Assert.assertTrue("Validation failed : Expected text not displayed for monthly and yearly premium - "+monthlyPremium+" "+yearlyPremium,validationFlag);
	}
		@Then("^the user validates the added drug name on plan summary page for the selected plan$")
		public void verify_drugs_covered_AARP(DataTable Planname) {

			List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
			Map<String, String> plannameAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < plannameAttributesRow.size(); i++) {

				plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
						plannameAttributesRow.get(i).getCells().get(1));
			}
			String planName = plannameAttributesMap.get("Plan Name");
			String drugName = plannameAttributesMap.get("DrugName");

			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			Assert.assertTrue("Drugs coverage Info not updated", plansummaryPage.verifyAddedDrugName(planName,drugName));
		}
		
		@Then("^the user clicks on drug dropdown on plan summary page and navigates to DCE$")
		public void clickOnDrugDropdownAndNavigateToDCE(DataTable Planname) {

			List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
			Map<String, String> plannameAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < plannameAttributesRow.size(); i++) {

				plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
						plannameAttributesRow.get(i).getCells().get(1));
			}
			String planName = plannameAttributesMap.get("Plan Name");
			

			VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			planSummaryPage.navigateToDCEFromDrugDropdown(planName);
		}
		
		@Then("^the user validates the drug cost on plan summary page for the selected plan$")
		public void verify_drug_cost(DataTable Planname) {

			List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
			Map<String, String> plannameAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < plannameAttributesRow.size(); i++) {

				plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
						plannameAttributesRow.get(i).getCells().get(1));
			}
			String annualDrugCost = (String) getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
			String planName = plannameAttributesMap.get("Plan Name");

			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			Assert.assertTrue("Drug cost is displayed incorrectly", plansummaryPage.verifyAddedDrugCost(planName,annualDrugCost));
		}
		@Then("^the user click on Prescription Drug Benefits tab on plan details$")
		public void the_user_click_on_Prescription_Drug_Benefits_and_validates_in_AARP_site() throws Throwable {
			PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			vppPlanDetailsPage.clickAndValidatePrescriptionDrugBenefits();
		}
		
		@Then("^the user verifies the drug information on prescription drug tab$")
		public void the_user_verifies_drug_info_Prescription_Drug(DataTable Attributes) throws Throwable {
			List<DataTableRow> plannameAttributesRow = Attributes.getGherkinRows();
			Map<String, String> plannameAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < plannameAttributesRow.size(); i++) {

				plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
						plannameAttributesRow.get(i).getCells().get(1));
			}
			PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			String annualDrugCost = (String) getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
			String drugName = plannameAttributesMap.get("DrugName");
			vppPlanDetailsPage.validateDrugInfoOnPrescriptionDrugTab(drugName, annualDrugCost);
		}
		
		@Then("^the user clicks on Edit drug on plan details page and navigates to DCE$")
		public void the_user_click_on_EdidDrugLink() throws Throwable {
			PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			GetStartedPage getStartedPage = (GetStartedPage) vppPlanDetailsPage.navigateToDCERedesignEditDrug(); 
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		}
		
		@Then("^the user click on Plan costs tab$")
		public void the_user_click_on_Plan_costs_tab_and_validates_in_AARP_site() throws Throwable {

			PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			vppPlanDetailsPage.clickPlanCosts();
		}
		
		@Then("^the user click on Edit Drugs Link on plan costs tab$")
		public void the_user_click_on_Edit_Drugs_on_Plan_costs_tabe() throws Throwable {

			PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			vppPlanDetailsPage.navigateToDCERedesignFromPlanCostTab();
		}
		
		@Then("^the user verifies the drug information on plan costs tab$")
		public void the_user_verifies_drug_info_on_Plan_Cost() throws Throwable {
			
			PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			String annualDrugCost = (String) getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
			vppPlanDetailsPage.validateDrugInfoOnPlanCostTab(annualDrugCost);
		}
		
	@Then("^verify plan compare checkbox is not visible on plan summary$")
	public void verify_plan_compare_checkbox_is_not_visible_on_plan_summary() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean validationFlag = plansummaryPage.verifyPlanCompareCheckboxNotVisible();
		Assert.assertFalse("Validation failed : UnExpected Plan Compare check is Visible - ", validationFlag);

	}
	@When("^verify Call SAM icon is visible or not on Plan Comapare Page$")
	public void verify_Call_SAM_icon_is_visible_or_not_PlanCompare_Page() throws InterruptedException {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallSam();
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		Assert.assertTrue(true);
		System.out.println("TFN Widget is Displayed");
	}
	@And("^verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare Page$")
	public void verify_Call_SAM_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent_PlanCompare_Page() throws InterruptedException {
				
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallSamContent();
		
	}
	@Then("^user verify the popup and content on Plan Comapare Page$")
	public void user_verify_the_popup_and_content_PlanCompare_Page() throws InterruptedException {
				
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallpopup();	
	}
	@Then("^the user clicks on back on all plan link in Plan Compare page")
	  public void user_clicks_back_to_all_plan_PlanCompare_page() throws InterruptedException{
		  ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE); 
		  VPPPlanSummaryPage plansummaryPage = planComparePage.navigateBackToAllPlans();
			if (plansummaryPage != null) {
					getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
					Assert.assertTrue(true);
					plansummaryPage.handlePlanYearSelectionPopup();
				} 
			else
				Assert.fail("Error in navigating back to Plan Summary Page");
		
	  }
	@Then("^remove one plan from new plan compare page$")
	public void remove_one_plan_from_new_plan_compare_page() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnNewRemoveLink();
	}
	@Then("^click on back to plans on plan compare page$")
	public void click_on_back_to_plans_on_plan_compare_page() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnBacktoPlans();
	}
	@Then("^Verify the Plan compare checkbox should be unchecked for the removed plan$")
	public void verify_the_Plan_compare_checkbox_should_be_unchecked_for_the_removed_plan() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyPlanComapreCheckboxIsUnchecked();
	}
	
	@Given("^I select \"([^\"]*)\" plans and \"([^\"]*)\" plans to compare and click on compare plan link$")
	public void i_select_plans_and_plans_to_compare_and_click_on_compare_plan_link(String planType,
			String Counter) throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		int counter = Integer.parseInt(Counter);
		if (planType.equals("MAPD")) {
			//plansummaryPage.clickonViewPlans();
			plansummaryPage.checkMAPlansOnly(counter);
			System.out.println("Selected All MAPD plans for Plan Compare");
		}

		ComparePlansPage planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@Then("^Click on Add Icon on new Plan Compare and verify it navigates to plan summary page$")
	public void click_on_Add_Icon_newPlanCompare_and_verify_it_navigates_to_plan_summary_page() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnNewAddIcon();
	}
	
	@Then("^Verify newly added plan displayed on new plan compare page$")
	public void verify_newly_added_plan_displayed_on_new_plan_compare_page() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatenewlyAddPlanonNewPlanComapre();
	}

	@Then("^verify Your doctors is loaded with doctor summary on Plan Compare page$")
	public void verify_doctors_covered() {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateDoctors();
	}
	@And("^click on Edit your doctors link and Navigate to Rally page$")
	public void clickONEdityourdocits() throws Exception {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);		
		FindCarePage findCarePage = planComparePage.clickonEditYourDoctors();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
		} else
			Assert.fail("Error in loading the compare plans page");
	}	
	
	@And("^user selects a provider from medical group and retuns to plan compare page$")
	public void selectsproviderfrommedicalGroup() throws Exception {
		FindCarePage findCarePage = (FindCarePage) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPage planComparePage = findCarePage.providerfromMedicalGroup();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}
	@Then("^verify Add doctors is loaded with doctor summary on Plan Compare page$")
	public void verify_Add_doctors_covered() {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateAddDoctors();
	}
	@And("^click on Add your doctors link and Navigate to Rally page$")
	public void clickOnAddyourdocits() throws Exception {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);		
		FindCarePage findCarePage = planComparePage.clickonAddYourDoctors();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
		} else
			Assert.fail("Error in loading the compare plans page");
	}
	
	//New plan compare related
		@And("^I click on Get Started on and Add PrimaryCare PCP from find care page$")
		public void I_click_on_Get_Started_and_Add_PrimaryCarePCP_find_care_page() throws Exception {
			FindCarePage findCarePage = (FindCarePage) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ComparePlansPage planComparePage = findCarePage.providerfromPrimaryCare();
			if (planComparePage != null) {
				getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
				// comparePlansPage.backToVPPPage();
			} else
				Assert.fail("Error in loading the compare plans page");
		}
		@Then("^verify Your Hospital is loaded with doctor summary on Plan Compare page$")
		public void verify_Hospital_covered() {
			ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
					.getBean(PageConstants.PLAN_COMPARE_PAGE);
			planComparePage.validateEditHospitals();
		}
		
		@And("^click on Edit your Hospitals link and Navigate to Rally page$")
		public void clickONEdityourHospitals() throws Exception {
			ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
					.getBean(PageConstants.PLAN_COMPARE_PAGE);		
			FindCarePage findCarePage = planComparePage.clickonEditYourHosptials();
			if (findCarePage != null) {
				getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
			} else
				Assert.fail("Error in loading the compare plans page");
		}	
		
		@And("^user selects a Hospitals from Clinical and retuns to plan compare page$")
		public void selectsproviderfromPrimaryCareClinic() throws Exception {
			FindCarePage findCarePage = (FindCarePage) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ComparePlansPage planComparePage = findCarePage.providerfromPrimaryCareClinicButton();
			if (planComparePage != null) {
				getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
				// comparePlansPage.backToVPPPage();
			} else
				Assert.fail("Error in loading the compare plans page");
		}
		
		@Then("^verify Add Hospitals is loaded without summary on Plan Compare page$")
		public void verify_Add_Hospitals_covered() {
			ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
					.getBean(PageConstants.PLAN_COMPARE_PAGE);
			planComparePage.validateAddHospitals();
		}
		
		@And("^click on Add your Hospitals link and Navigate to Rally page$")
		public void clickOnAddyourHospitals() throws Exception {
			ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
					.getBean(PageConstants.PLAN_COMPARE_PAGE);		
			FindCarePage findCarePage = planComparePage.clickonAddYourHospitals();
			if (findCarePage != null) {
				getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
			} else
				Assert.fail("Error in loading the compare plans page");
		}
		
		@And("^I click on Get Started on and Add Places from Hospitals find care page$")
		public void I_click_on_Get_Started_and_Add_PlacesfromHospitals_find_care_page() throws Exception {
			FindCarePage findCarePage = (FindCarePage) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ComparePlansPage planComparePage = findCarePage.placesfromHospital();
			if (planComparePage != null) {
				getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
				// comparePlansPage.backToVPPPage();
			} else
				Assert.fail("Error in loading the compare plans page");
		}
		@Then("^the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare page$")
		  public void user_clicks_enrollInPlan_newPlanCompare_AARP() throws InterruptedException{
			  ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE); 
			  WelcomePage  welcomeOLEPage = planComparePage.Enroll_OLE_Plancompare();
		   if (welcomeOLEPage != null) {
				getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
			} else {
				Assert.fail("Error Loading Welcome Page for OLE");
			}
		  }
		@Then("^check one plan and add it to plancompare")
		public void check_one_plan_and_add_it_to_plancompare() throws Throwable {
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			plansummaryPage.clickon3rdPlan();
			ComparePlansPage planComparePage = plansummaryPage.clickOnCompareLink();
			if (planComparePage != null) {
				getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
				// comparePlansPage.backToVPPPage();
			} else
				Assert.fail("Error in loading the compare plans page");
		}
}