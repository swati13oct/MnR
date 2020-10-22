package acceptancetests.acquisition.vpp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import pages.acquisition.commonpages.ProviderSearchPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.ole.MedicareInformationPage;
import pages.acquisition.ole.PersonalInformationPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineResultsPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.commonpages.ComparePlansPage;


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
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd,site);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
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
	public void the_user_navigates_to_the_plan_details_for_the_given_plan_type_in_AARP_site(DataTable data) throws Throwable {
		wd.manage().window().maximize();
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String planType = memberAttributesRow.get(0).getCells().get(1);
		String planName=memberAttributesRow.get(1).getCells().get(1);
		VPPPlanSummaryPage plansummaryPage =  new VPPPlanSummaryPage(wd);
		plansummaryPage.viewPlanSummary(planType);
		PlanDetailsPage plandetailspage= (PlanDetailsPage)plansummaryPage.navigateToPlanDetails(planName, planType);
		if(plandetailspage!=null){
			getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE, plandetailspage);
			getLoginScenario().saveBean(DCERedesignCommonConstants.PLANTYPE, planType);
			getLoginScenario().saveBean(DCERedesignCommonConstants.PLANNAME, planName);

		}
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
	
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
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
		if(!plantype.equalsIgnoreCase("MS"))
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
			String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName, planType);
			getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);

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
			}else if (planType.equals("PDP")) {
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
		public void Start_application_button(DataTable givenAttributes) throws Throwable{
			List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}

			String DateOfBirth = memberAttributesMap.get("DOB");
			String FirstName = memberAttributesMap.get("Firstname");
			String LastName = memberAttributesMap.get("Lastname");
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			plansummaryPage.MedSupFormValidation(DateOfBirth);
			String resumeKey = plansummaryPage.StartApplicationButton(FirstName, LastName);
			getLoginScenario().saveBean(VPPCommonConstants.RESUMEKEY, resumeKey);

		}
		@Then("^user clicks on resume application button$")
		public void click_resume_application(DataTable givenAttributes) throws Throwable{
			List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}

			String DateOfBirth = memberAttributesMap.get("DOB");
			String FirstName = memberAttributesMap.get("Firstname");
			String LastName = memberAttributesMap.get("Lastname");
			//VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			//plansummaryPage.MedSupFormValidation(DateOfBirth);
			System.out.println("***the user clicks on resume application button***");
			VPPPlanSummaryPage plansummaryPage1 = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
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
			
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			plansummaryPage.signInOptumId(username, password);
		}
		/*@Then("^user validates the resume application URL$")
		public void resume_application_processed(DataTable givenAttributes) throws Throwable{
			System.out.println("***The user validates the resume application processed***");
			List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}
			String FirstName = memberAttributesMap.get("Firstname");
			String LastName = memberAttributesMap.get("Lastname");
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			plansummaryPage.ResumeApplicationButtonValidation(FirstName, LastName);

		}*/
		@Then("^the user validate retrieve application URL$")
		public void the_user_retrieve_application_URL_in_AARPSite(DataTable arg1) throws InterruptedException {
			Map<String, String> inputAttributesMap=parseInputArguments(arg1);
			String AARPURL = inputAttributesMap.get("AARP URL");
			String AARPURLSTG=inputAttributesMap.get("AARP URL STG");
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			if(getLoginScenario().environment.equals("stage")){
				plansummaryPage.RetrieveURL(AARPURLSTG);
			}else{
				plansummaryPage.RetrieveURL(AARPURL);
			}

		}
		public Map<String, String> parseInputArguments(DataTable memberAttributes) {
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
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
			plansummaryPage = aquisitionhomepage.searchPlanOnHealthPlansPage(zipcode,county,isMultiCounty);
			
			
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
		
		@When("^the user performs plan search using Shop Pages$")
		public void Standalone_zipcode_details(DataTable givenAttributes) throws InterruptedException {
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
				plansummaryPage = aquisitionhomepage.searchPlansWithOutCountyShopEnroll(zipcode);
			} else {
				plansummaryPage = aquisitionhomepage.searchPlansShopEnroll(zipcode, county);
			}
			
			if (plansummaryPage != null) {
				getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

			} else {
				Assert.fail("Error Loading VPP plan summary page");
			}
		}
	@When("^the user performs plan search using Standalone information in EnrollPage$")
	public void Standalone_Shop_details_in_aarp_site_Enroll(DataTable givenAttributes) throws InterruptedException {
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
			plansummaryPage = aquisitionhomepage.searchPlansWithOutCountyShop(zipcode);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlansShop(zipcode, county);
		}
		
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}
	@When("^the user Click on Is my Provider covered links$")
	public void clickonProvidercoveredlinks(DataTable Planname ){
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
		
		ProviderSearchPage providerSearchPage = plansummaryPage.clicksOnIsProviderCovered(planName);
		if(providerSearchPage!=null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}
	
	}
	}
	@When("^user selects a multiple providers and retuns to VPP page$")
	public void user_selects_a_multiple_providers_and_retuns_to_VPP_page() {
	{
		ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
				.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
		VPPPlanSummaryPage plansummaryPage = providerSearchPage.MultipleselectsProvider();
		Assert.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);

	}
	}
	
	@Given("^the user navigates to following acquisition site page$")
	public void the_user_navigates_to_medicare_acquisition_site_page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : "+path);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPath(path);
	}
	
	@Then("^User store the information provided from rally to vpp page$")
	public void user_store_the_information_provided_from_rally_to_vpp(DataTable givenAttributes) {
	
	List<DataTableRow> givenAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> givenAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < givenAttributesRow.size(); i++) {

		givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
				givenAttributesRow.get(i).getCells().get(1));
	}

	String planName = givenAttributesMap.get("PlanName");

	VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	
	/*ArrayList<String> providers = plansummaryPage.providerinforetreive(planName);
	plansummaryPage.setStringList(providers);
	Assert.assertFalse("Providers not added",providers.isEmpty());
	
	//Adding Line for Marketing bullet points
	VPPPlanSummaryPage plansummaryPage1 = (VPPPlanSummaryPage) getLoginScenario()
			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	ArrayList<String> vppmarketingBullets =plansummaryPage1.validate_marketing_details(planName);
	plansummaryPage1.setStringList(vppmarketingBullets);
	Assert.assertFalse("Providers not added",vppmarketingBullets.isEmpty());
	System.out.println("List of MarketingBullets in OLE page is: " + vppmarketingBullets);
	// Line End for Marketing bullet points
	*/
	ArrayList<String> providers = plansummaryPage.providerinforetreive(planName);
	Assert.assertFalse("Providers not added",providers.isEmpty());
	System.out.println("List of Providers in OLE page is: " + providers);
	ArrayList<String> vppmarketingBullets =plansummaryPage.validate_marketing_details(planName);
	Assert.assertFalse("Marketing Bullets not added",vppmarketingBullets.isEmpty());
	System.out.println("List of MarketingBullets in OLE page is: " + vppmarketingBullets);
    Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    map.put("Provider", providers);
    map.put("MarketingBullet", vppmarketingBullets);
    plansummaryPage.setMap(map);
    


	}
		
	@Given("^the user navigates to following Campaign acquisition site page$")
	public void the_user_navigates_to_following_medicare_acquisition_site(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : "+path);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);	
		
		aquisitionhomepage.navigateToPath(path);
		VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(wd);		
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}
	
	@When("the user selects plan year for PRE Flow$")
	public void user_selects_plan_year_for_PRE_Flow(DataTable givenAttributes) {
		
		   List<DataTableRow> givenAttributesRow = givenAttributes
		         .getGherkinRows();
		   Map<String, String> givenAttributesMap = new HashMap<String, String>();
		   for (int i = 0; i < givenAttributesRow.size(); i++) {
		      givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		            givenAttributesRow.get(i).getCells().get(1));
		   }
		   
		   
		   String planYear = givenAttributesMap.get("Plan Year");
		  // VPPPlanSummaryPage plansummaryPage = null;
		 // VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(wd);
		  VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		   getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		   
		   plansummaryPage.handlePlanYearSelectionPopup(planYear);
		 // getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		  getLoginScenario().saveBean(VPPCommonConstants.PLAN_YEAR, planYear);

		}
	
	@Then("^the user validates the available plans for selected plan types PRE$")
	public void user_validates_available_plans_aarp_PRE(DataTable givenAttributes) {

		List<DataTableRow> givenAttributesRow = givenAttributes
		         .getGherkinRows();
		   Map<String, String> givenAttributesMap = new HashMap<String, String>();
		   for (int i = 0; i < givenAttributesRow.size(); i++) {
		      givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		            givenAttributesRow.get(i).getCells().get(1));
		   }
		   
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = givenAttributesMap.get("Plan Type");
		//String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (plansummaryPage.validatePlanNames(planType)) {
			//String SiteName = "AARP_ACQ";
			//getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
			  getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error validating availables plans for selected plantype in  VPP plan summary page");
		}
	}
}