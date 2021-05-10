package acceptancetests.acquisition.vpp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AboutUsAARPPage;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.AgentsnBrokersAARPPage;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.ContactUsAARPPage;
import pages.acquisition.commonpages.DisclaimersAARPPage;
import pages.acquisition.commonpages.FindCarePage;
import pages.acquisition.commonpages.MultiCountyModalPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.PrivacyPolicyAARPPage;
import pages.acquisition.commonpages.ProviderSearchPage;
import pages.acquisition.commonpages.ShopForPlanNavigationPage;
import pages.acquisition.commonpages.SiteMapAARPPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.vpp.VppCommonPage;
import pages.acquisition.commonpages.LearnAboutMedicareHomePage;

/**
 * Functionality: VPP flow for AARP site
 */

public class VppCommonStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

//	WebDriver wd;
	public String PREflow = "";

	/**
	 * @toDo:user is on medicare acquisition site landing page
	 */

//	@Given("^the user is on medicare acquisition site landing page$")
//	public void the_user_on__medicaresolutions_Site(DataTable givenAttributes) {
//		wd = getLoginScenario().getWebDriverNew();
//		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
//		Map<String, String> memberAttributesMap = new HashMap<String, String>();
//		for (int i = 0; i < memberAttributesRow.size(); i++) {
//			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
//					memberAttributesRow.get(i).getCells().get(1));
//		}
//		String site = memberAttributesMap.get("Site");
//		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, site);
//
//		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
//		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
//		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, " ");
//		getLoginScenario().saveBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS, " ");
//
//		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, site);
//		if (site.equalsIgnoreCase("AARP"))
//			aquisitionhomepage.validateSubtitle();
//	}

	@Given("^the user is on medicare acquisition site landing page fro campaign Traffic$")
	public void the_user_on__medicaresolutions_Site_campaign_Traffic(DataTable givenAttributes) {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String site = memberAttributesMap.get("Site");
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, site);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, " ");
		getLoginScenario().saveBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS, " ");

		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, site);
		if (site.equalsIgnoreCase("AARP")) 
		aquisitionhomepage.validateSubtitle();
	}
	@When("^the user performs plan search using following information$")
	public void zipcode_details_in_aarp_site(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@Then("^the user navigates to the plan details for the given plan type$")
	public void the_user_navigates_to_the_plan_details_for_the_given_plan_type_in_AARP_site(DataTable data)
			throws Throwable {
//		wd.manage().window().maximize(); //Can be handled from MRScenario
		//Remove the commented code
		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String planType = memberAttributesRow.get(0).getCells().get(1);
		String planName = memberAttributesRow.get(1).getCells().get(1);*/
		
		//Value from a datatable column can be fetched using asLists approach
		List<List<String>> memberAttributesRow = data.asLists();
		String planType = memberAttributesRow.get(0).get(1);
		String planName = memberAttributesRow.get(1).get(1);
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// plansummaryPage.viewPlanSummary(planType);
		PlanDetailsPage plandetailspage = plansummaryPage.navigateToPlanDetails(planName, planType);

		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);

	}

	@And("^the user views the plans of the below plan type$")
	public void user_performs_planSearch_in_aarp_site(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String plantype = givenAttributesMap.get("Plan Type");
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);

	}

	@When("the user selects plan year$")
	public void user_selects_plan_year(DataTable givenAttributes) {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planYear = givenAttributesMap.get("Plan Year");

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
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
			Assertion.fail("Error in loading the compare plans page");
	}
	
	@Given("^I select \"([^\"]*)\" plans to compare$")
	public void i_select_plans_to_compare(String planType) throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if (planType.equals("MAPD")) {
			plansummaryPage.checkAllMAPlans();
			System.out.println("Selected All MAPD plans for Plan Compare");
		} else if (planType.equals("PDP")) {
			plansummaryPage.checkAllPDPlans();
			System.out.println("Selected All PDP plans for Plan Compare");
		}
		
	}

	@Then("^verify plan compare page is loaded$")
	public void verify_plan_compare_page_is_loaded_on_AARP() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatePlanComparePage();
	}

	@And("^the user views the plans of the below plan type and select Next year$")
	public void user_performs_planSearch_in_aarp_site_next_year(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

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
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assertion.assertTrue("Error loading specific plan summary in VPP plan summary page",
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
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName, planType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		vppPlanSummaryPage.clickOnViewMoreForPlan(PlanName);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in Loading the Plan Details Page");

	}

	@Then("^the user clicks on back to all plans link and validates its redirection to Plan Summary$")
	public void User_clicks_BackToPlansLink_and_validates_redirection() {

		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		VPPPlanSummaryPage plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPageFromDetailsPage();
		if (plansummaryPage != null) {
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the Plan Summary Page");
	}

	@Then("^the user validates below plan benefit values for the above selected plan$")
	public void user_validates_planBenefitValues_inAARP(DataTable givenAttributes) {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
			Assertion.fail("Error Loading Welcome Page for OLE");
		}
	}

	@Then("^the site user clicks on Start Application Button proceed to next pages$")
	public void Start_application_button(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String DateOfBirth = memberAttributesMap.get("DOB");
		String FirstName = memberAttributesMap.get("Firstname");
		String LastName = memberAttributesMap.get("Lastname");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation(DateOfBirth);
		String resumeKey = plansummaryPage.StartApplicationButton(FirstName, LastName);
		getLoginScenario().saveBean(VPPCommonConstants.RESUMEKEY, resumeKey);

	}

	@Then("^the site user clicks on View Plans Button proceed to View Plans Page$")
	public void the_site_user_clicks_on_View_Plans_Button_proceed_to_View_Plans_Page_button(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String DateOfBirth = memberAttributesMap.get("DOB");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation(DateOfBirth);
	}

	@And("^user clicks on compare button and navigate to plan compare page for \"([^\"]*)\" time$")
	public void user_clicks_on_compare_button_and_navigate_to_plan_compare_page(String attempt,
			DataTable givenAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String totalPlans = givenAttributesMap.get("No Of Plans To Compare");
		int total_plans = Integer.parseInt(totalPlans);

		String navigateToCompare = givenAttributesMap.get("Navigate To Compare");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		boolean result = plansummaryPage.clickAndVerifyNavigateToPage("Compare", total_plans, attempt,
				navigateToCompare);
		Assertion.assertTrue("On clicking compare button user is navigated to plan compare page", result);
		System.out.println("user clicks on compare button and navigate to plan compare page");

	}

	@And("^user clicks on add more plans for comparing$")
	public void user_clicks_on_add_more_plans_for_comparing() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean result = plansummaryPage.addTwoMorePlansForComparing();
		Assertion.assertTrue("User successfully add two more plans", result);
		System.out.println("User successfully add two more plans");

	}

	@And("^user clicks on save button and saves to plan cart for \"([^\"]*)\" time$")
	public void user_clicks_on_save_button_and_saves_to_plan_cart(String attempt, DataTable givenAttributes)
			throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String totalPlans = givenAttributesMap.get("No Of Plans To Compare");
		int total_plans = Integer.parseInt(totalPlans);

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean result = plansummaryPage.clickAndVerifyNavigateToPage("Save", total_plans, attempt, "Yes");
		Assertion.assertTrue("On clicking save button user is navigated to save plan page", result);
		System.out.println("user clicks on save button and saves to plan cart");

	}

	@Then("^user clicks on Edit Your Information link and navigate back to micro form$")
	public void user_clicks_on_Edit_Your_Information_link_and_navigate_back_to_micro_form() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean result = plansummaryPage.clickAndVerifyNavigateToPage("Information", 1, "first", "Yes");
		Assertion.assertTrue("On clicking Edit Your Information link and navigate back to micro form", result);
		System.out.println("user clicks on Edit Your Information link and navigate back to micro form");
	}

	@Then("^user clicks on View plan button link and navigate back to vpp summary page of medsupp$")
	public void user_clicks_on_View_plan_button_link_and_navigate_back_to_vpp_summary_page_of_medsupp()
			throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean result = plansummaryPage.clickAndVerifyNavigateToPage("View Plan", 1, "first", "Yes");
		Assertion.assertTrue("On clicking View Plan button user is navigated to plan summary page", result);
		System.out.println("user clicks on View plan button link and navigate back to vpp summary page of medsupp");
	}

	@Then("^user clicks on Save icon for all the plans and validate count in cart should match to plans$")
	public void user_clicks_on_Save_icon_for_all_the_plans_and_match_count(DataTable givenAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String noOfPlansSavedOnComparePage = givenAttributesMap.get("No Of Saved Plans On Compare Page");
		int savedPlanCountOfComparePage = Integer.parseInt(noOfPlansSavedOnComparePage);

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean result = plansummaryPage.verifyPlanCount(savedPlanCountOfComparePage);
		Assertion.assertTrue("Plan count is matched", result);
		System.out.println("Plan count is matched");
	}

	@Then("^user saves more than two plans on summary page navigate to compare page and validate that saved plans are displayed$")
	public void user_validate_saved_plans_on_compare() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean result = plansummaryPage.verifyPlanSavedOnSummaryAreDisplayedOnCompare();
		Assertion.assertTrue("Plans saved on summary page are displayed on compare page", result);
		System.out.println("Plans saved on summary page are displayed on compare page");
	}

	@And("^user clicks on heart icon and save two heart icon plans$")
	public void user_clicks_on_heart_icon_and_save_two_heart_icon_plans(DataTable givenAttributes) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String planCount = memberAttributesMap.get("No Of Plans To Save");
		int number = Integer.parseInt(planCount);

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		boolean result = plansummaryPage.savePlansOnSummaryPage(number);
		Assertion.assertTrue("user saved two heart icon plans", result);
		System.out.println("user saved two heart icon plans");

	}

	@And("^user clicks on view saved plans land on shopper profile page$")
	public void user_clicks_on_view_saved_plans_land_on_shopper_profile_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		boolean result = plansummaryPage.clickOnSavedPlansAndNavigateToShopperProfile();
		Assertion.assertTrue("user land on shopper profile page", result);
		System.out.println("user land on shopper profile page");

	}

	@Then("^user validate all fields are editable and view plan and cancel buttons are visible$")
	public void user_validate_all_fields_are_editable_and_view_plan_and_cancel_buttons_are_visible() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		boolean result = plansummaryPage.validateAllFieldsEditable();
		Assertion.assertTrue("all fields are editable and view plan and cancel buttons are visible", result);
		System.out.println("all fields are editable and view plan and cancel buttons are visible");

	}

	@Then("^user clicks on view plan details button and validates plan name start application button and benefit link$")
	public void user_clicks_on_view_plan_details_button_and_validates_plan_name_start_application_button_and_benefit_link()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		boolean result = plansummaryPage.validateFieldsOnPlanDetails();
		Assertion.assertTrue("plan name start application button and benefit link are validated", result);
		System.out.println("plan name start application button and benefit link are validated");

	}

	@Then("^user clicks on compare plans link and validates plan name start application button and benefit link$")
	public void user_clicks_on_compare_plans_link_and_validates_plan_name_start_application_button_and_benefit_link()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		boolean result = plansummaryPage.validateFieldsOnPlanCompare();
		Assertion.assertTrue("plan name start application button and benefit link are validated", result);
		System.out.println("plan name start application button and benefit link are validated");

	}

	@Then("^user clicks on resume application button$")
	public void click_resume_application(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

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
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(credentials);
		/*List<DataTableRow> plannameAttributesRow = credentials.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
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
		memberAttributesMap = DataTableParser.readDataTableAsMaps(memberAttributes);
		/*List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		return memberAttributesMap;
	}

	@Then("^user validates plan count for all plan types on plan summary page$")
	public void user_validates_following_benefits_ui_aarp() {

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assertion.assertTrue("Error validating plans in  VPP plan summary page",
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
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Error validating availables plans for selected plantype in  VPP plan summary page");
		}
	}

	@When("^the user enters zipcode on health plans page$")
	public void enters_zipcode_details_in_aarp_site(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@Then("^user saves two plans as favorite$")
	public void user_saves_two_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, (new VPPPlanSummaryPage(wd)));
		plansummaryPage.validateRightRailSection();
	}

	@Then("^the user validates the Need Help Section in the right rail$")
	public void validate_needHelp_rightRail() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, (new VPPPlanSummaryPage(wd)));
		plansummaryPage.validateNeedHelpRightRail();
	}

	@Then("^the user validates the TFN in the Need Help Section$")
	public void validate_TFN_inRIghtRail_aarp() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, (new VPPPlanSummaryPage(wd)));
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
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		MultiCountyModalPage multiCountyModalPage = plansummaryPage.VPP_ChangeLocationValidateMultiCOuntyPopUp(zipcode);

		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, multiCountyModalPage);
		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}

	}

	@Then("^the user validates the following Additional Benefits of Plan for the plan$")
	public void the_user_validates_the_following_Additional_Benefits_of_Plan_for_the_plan_in_AARP(
			DataTable givenAttributes) throws Throwable {
//		List<DataTableRow> additionalBenefits = givenAttributes.getGherkinRows();
		List<List<String>> additionalBenefits = givenAttributes.asLists();

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(additionalBenefits);
	}

	@Then("^user saves two ms plans as favorite$")
	public void user_saves_two_ms_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		// Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ms_savePlanNames = memberAttributesMap.get("MS Test Plans");

		// ----- MS plan type ----------------------------
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

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		// Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String savePlanNames = memberAttributesMap.get("Test Plans");
		String planType = memberAttributesMap.get("Plan Type");

		plansummaryPage.saveAllPlans(savePlanNames, planType);
	}

	@When("^the user performs plan search using Shop Pages$")
	public void Standalone_zipcode_details(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@When("^the user performs plan search using Standalone information in EnrollPage$")
	public void Standalone_Shop_details_in_aarp_site_Enroll(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@When("^the user Click on Is my Provider covered links$")
	public void clickonProvidercoveredlinks(DataTable Planname) {
		{
			Map<String, String> plannameAttributesMap = new HashMap<String, String>();
			plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
			/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
			for (int i = 0; i < plannameAttributesRow.size(); i++) {

				plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
						plannameAttributesRow.get(i).getCells().get(1));
			}*/
			String planName = plannameAttributesMap.get("PlanName");
			getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

			ProviderSearchPage providerSearchPage = plansummaryPage.clicksOnIsProviderCovered(planName);
			if (providerSearchPage != null) {
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
			Assertion.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);

		}
	}

	@Given("^the user navigates to following acquisition site page$")
	public void the_user_navigates_to_medicare_acquisition_site_page(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : " + path);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPath(path);
	}

	@Then("^User store the information provided from rally to vpp page$")
	public void user_store_the_information_provided_from_rally_to_vpp(DataTable givenAttributes) {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("PlanName");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		/*
		 * ArrayList<String> providers = plansummaryPage.providerinforetreive(planName);
		 * plansummaryPage.setStringList(providers);
		 * Assertion.assertFalse("Providers not added",providers.isEmpty());
		 * 
		 * //Adding Line for Marketing bullet points VPPPlanSummaryPage plansummaryPage1
		 * = (VPPPlanSummaryPage) getLoginScenario()
		 * .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE); ArrayList<String>
		 * vppmarketingBullets =plansummaryPage1.validate_marketing_details(planName);
		 * plansummaryPage1.setStringList(vppmarketingBullets);
		 * Assertion.assertFalse("Providers not added",vppmarketingBullets.isEmpty());
		 * System.out.println("List of MarketingBullets in OLE page is: " +
		 * vppmarketingBullets); // Line End for Marketing bullet points
		 */
		ArrayList<String> providers = plansummaryPage.providerinforetreive(planName);
		Assertion.assertFalse("Providers not added", providers.isEmpty());
		System.out.println("List of Providers in OLE page is: " + providers);
		ArrayList<String> vppmarketingBullets = plansummaryPage.validate_marketing_details(planName);
		Assertion.assertFalse("Marketing Bullets not added", vppmarketingBullets.isEmpty());
		System.out.println("List of MarketingBullets in OLE page is: " + vppmarketingBullets);
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		map.put("Provider", providers);
		map.put("MarketingBullet", vppmarketingBullets);
		plansummaryPage.setMap(map);

	}

	@Given("^the user navigates to following Campaign acquisition site page$")
	public void the_user_navigates_to_following_medicare_acquisition_site(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String path = memberAttributesMap.get("PagePath");
		//String plantype = memberAttributesMap.get("Plan Type");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : " + path);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.navigateToPathNew(path);
		//Thread.sleep(5000);
		//VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(wd);
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		//	getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@When("the user selects plan year for PRE Flow$")
	public void user_selects_plan_year_for_PRE_Flow(DataTable givenAttributes) {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planYear = givenAttributesMap.get("Plan Year");
		// VPPPlanSummaryPage plansummaryPage = null;
		// VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(wd);
		VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(
				(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		// getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
		// plansummaryPage);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_YEAR, planYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, planYear);

	}

	@Then("^the user validates the available plans for selected plan types PRE$")
	public void user_validates_available_plans_aarp_PRE(DataTable givenAttributes) {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = givenAttributesMap.get("Plan Type");
		String site = givenAttributesMap.get("Site");
		
		// String planType = (String)
		// getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (plansummaryPage.validatePlanNames(planType)) {
			// String SiteName = "AARP_ACQ";
			// getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
			getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
			getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, site);
			
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Error validating availables plans for selected plantype in  VPP plan summary page");
		}
	}

	@Then("^the user validates the Cancel button for Multi County Pop-up lands on enter Zip code Page$")
	public void the_user_validates_the_Cancel_button_for_Multi_COunty_Pop_up_lands_on_enter_Zip_code_Page()
			throws Throwable {
		MultiCountyModalPage multiCountyModalPage = (MultiCountyModalPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean Validation_Flag = multiCountyModalPage.validateMultiCounty_CancelButton();
		Assertion.assertTrue("Validation failed : Cancel button Validation for Multi County Pop-up Failed ",
				Validation_Flag);

	}

	@When("^verify Call SAM icon is visible$")
	public void verify_Call_SAM_icon_is_visible() throws InterruptedException {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSam();
		/*
		 * if (Aquisitionhomepage != null) {
		 * getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
		 * Aquisitionhomepage); Assertion.assertTrue(true);
		 * System.out.println("TFN Widget is Displayed"); } else{
		 * Assertion.fail("TFN Widget is NOT Displayed"); }
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
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Aboutus page not found");
		}

	}

	@And("^user clicks on contact us link of aboutus page$")
	public void click_contact_us() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ContactUsAARPPage contactUsAARPPage = aquisitionhomepage.contactUsFooterClick();
		if (contactUsAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_Contact_US_PAGE, contactUsAARPPage);
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("contactus page not found");
		}
	}

	@And("^user clicks on sitemap link of contact us page$")
	public void click_sitemap() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		SiteMapAARPPage siteMapAARPPage = aquisitionhomepage.siteMapFooterClick();
		if (siteMapAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_SITE_MAP_PAGE, siteMapAARPPage);

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("sitemap page not found");
		}
	}

	@And("^user clicks on privacy policy link of sitemap page$")
	public void click_privacypolicy() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PrivacyPolicyAARPPage privacyPolicyAARPPage = aquisitionhomepage.privacypolicyFooterClick();
		if (privacyPolicyAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_PRIVACY_POLICY_PAGE, privacyPolicyAARPPage);

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("privacypolicy page not found");
		}
	}

	@And("^user clicks on disclaimers link of terms & conditions page$")
	public void click_disclaimers() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersAARPPage disclaimersAARPPage = aquisitionhomepage.disclaimersFooterClick();
		if (disclaimersAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_DISCLAIMERS_PAGE, disclaimersAARPPage);

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("disclaimers page not found");
		}
	}

	@And("^user clicks on agents & brokers link of disclaimers page$")
	public void click_agentsnbrokers() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AgentsnBrokersAARPPage agentsnBrokersAARPPage = aquisitionhomepage.agentsnbrokersFooterClick();
		if (agentsnBrokersAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_AGENTS_AND_BROKERS_PAGE, agentsnBrokersAARPPage);

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("agents&brokers page not found");
		}
	}

	@And("^user verifies home link of agents & brokers page$")
	public void click_home() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePage aquisitionHomePageReload = aquisitionhomepage.homeFooterClick();
		Assertion.assertTrue("home page not found", aquisitionHomePageReload != null);
	}

	@Then("^the user clicks on Learn More for Rocky Mountain plans$")
	public void the_user_clicks_on_Learn_More__for_Rocky_Mountain_plans(DataTable planAttributes) throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.RockyLearnMoreButtonandValidate(planName);
	}

	@Then("^the user clicks on Learn More for people Health plans$")
	public void the_user_clicks_on_Learn_More_for_people_Health_plans(DataTable planAttributes) throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.peopleLearnMoreButtonandValidate(planName);
	}

	@Then("^the user validates following PDF link is displayed with correct document code$")
	public void the_user_validates_following_PDF_link_is_displayes_with_correct_document_code(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String PDFtype = memberAttributesMap.get("PDF type");
		String DocumentCode = memberAttributesMap.get("DocumentCode");

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		boolean validationFlag = vppPlanDetailsPage.ValidatePDFlinkIsDisplayed(PDFtype, DocumentCode);
		Assertion.assertTrue("Validation failed : Expected text not displayed for riders monthly and yearly premium - ",
				validationFlag);
	}

	@Then("^the user click on PDF link and validates document code in site URL$")
	public void the_user_click_on_PDF_link_and_validates_document_code_in_site_URL(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String PDFtype = memberAttributesMap.get("PDF type");

		String DocumentCode = memberAttributesMap.get("DocumentCode");
		boolean validationFlag = vppPlanDetailsPage.ClickValidatePDFlink(PDFtype, DocumentCode);
		Assertion.assertTrue("Validation failed : Expected Document Code is not Present in the PDF URL ", validationFlag);
	}

	@Then("^the user click on Plan costs tab and validates on site$")
	public void the_user_click_on_Plan_costs_tab_and_validates_in_site(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String yearlyPremium = memberAttributesMap.get("Yearly Premium");

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.clickAndValidatePlanCosts(monthlyPremium, yearlyPremium);
		Assertion.assertTrue("Validation failed : Expected text not displayed for monthly and yearly premium - "
				+ monthlyPremium + " " + yearlyPremium, validationFlag);
	}

	@Then("^the user click on Optional Services tab and add the rider on site$")
	public void the_user_click_on_Optional_Services_tab_and_add_the_rider_in_AARP_site(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

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
		//Remove the commented code 
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planName = memberAttributesRow.get(0).getCells().get(1);
		String planType = memberAttributesRow.get(1).getCells().get(1);*/
		
		//Add code to fetch the value of a DataTable column directly using cell(rowNum, columnNum)
		String planName = givenAttributes.cell(0, 1);		//row 0, column 1
		String planType = givenAttributes.cell(1, 1);		//row 1, column 1
		
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(planName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			// if(vppPlanDetailsPage.validatePlanDetailsPage()){
			// Assertion.assertTrue(true);
			// }else
			// Assertion.fail("Error in validating the Plan Details Page");

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
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the Plan Summary Page");
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
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = memberAttributesMap.get("Plan Name");

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean optionalRiderFlag;
		if (memberAttributesMap.get("Optional Rider").isEmpty())
			optionalRiderFlag = false;
		else {
			String optionalRiderPremium = vppPlanDetailsPage
					.addOptionalRider(memberAttributesMap.get("Optional Rider"));
			optionalRiderFlag = true;
		}
		vppPlanDetailsPage.validateDentalPopupDefaults(planName, optionalRiderFlag);
	}

	@When("^the user navigates to the plan details page$")
	public void user_navigates_to_plan_details_page(DataTable givenAttributes) {
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		System.out.println("Plan name is " + PlanName + "Plan type is " + planType);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in Loading the Plan Details Page");

	}

	@Then("^the user Click on Look up your Provider button on Plan Details Page$")
	public void user_Clicks_on_Look_upyourProvider_button_on_PlanDetailsPage() {

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		ProviderSearchPage providerSearchPage = vppPlanDetailsPage.validateLookUpYourProviderButton();
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}

	}

	@Then("^the user click on Plan costs tab and validates in site$")
	public void the_user_click_on_Plan_costs_tab_and_validates_in_AARP_site(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String yearlyPremium = memberAttributesMap.get("Yearly Premium");

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.clickAndValidatePlanCosts(monthlyPremium, yearlyPremium);
		Assertion.assertTrue("Validation failed : Expected text not displayed for monthly and yearly premium - "
				+ monthlyPremium + " " + yearlyPremium, validationFlag);
	}

	@Then("^the user validates the added drug name on plan summary page for the selected plan$")
	public void verify_drugs_covered_AARP(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("Plan Name");
		String drugName = plannameAttributesMap.get("DrugName");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assertion.assertTrue("Drugs coverage Info not updated", plansummaryPage.verifyAddedDrugName(planName, drugName));
	}

	@Then("^the user clicks on drug dropdown on plan summary page and navigates to DCE$")
	public void clickOnDrugDropdownAndNavigateToDCE(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planType = plannameAttributesMap.get("Plan Type");
		String planName = plannameAttributesMap.get("Plan Name");

		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		DrugDetailsPage drugDetailsPage = planSummaryPage.navigateToDCEFromDrugDropdown(planType, planName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user validates the drug cost on plan summary page for the selected plan$")
	public void verify_drug_cost(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String annualDrugCost = (String) getLoginScenario().getBean(DCERedesignCommonConstants.ANNUAL_ESTIMATED_TOTAL);
		String planName = plannameAttributesMap.get("Plan Name");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assertion.assertTrue("Drug cost is displayed incorrectly",
				plansummaryPage.verifyAddedDrugCost(planName, annualDrugCost));
	}

	@Then("^the user validates the added drug name on plan summary page for a selected plan$")
	public void verify_drugs_added_VPP(DataTable givenAttributes) {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String planType = memberAttributesMap.get("Plan Type");
		String planName = memberAttributesMap.get("Plan Name");
		String drugName = memberAttributesMap.get("DrugName");

		String temp = memberAttributesMap.get("Plan Type");
		if (temp != null && PREflow != temp) {
			PREflow = temp;
			System.out.println("Current PRE Flow : " + PREflow);
		}

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assertion.assertTrue("Drugs coverage Info not updated",
				plansummaryPage.verifyAllAddedDrugName(planType, planName, drugName));
	}

	@Then("^the user click on Prescription Drug Benefits tab on plan details$")
	public void the_user_click_on_Prescription_Drug_Benefits_and_validates_in_AARP_site() throws Throwable {
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.clickAndValidatePrescriptionDrugBenefits();
	}

	@Then("^the user verifies the drug information on prescription drug tab$")
	public void the_user_verifies_drug_info_Prescription_Drug(DataTable Attributes) throws Throwable {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Attributes);
		/*List<DataTableRow> plannameAttributesRow = Attributes.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
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
		BuildYourDrugList DCEbuildDrugList = (BuildYourDrugList) vppPlanDetailsPage.navigateToDCERedesignEditDrug();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
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
		BuildYourDrugList DCEbuildDrugList = vppPlanDetailsPage.navigateToDCERedesignFromPlanCostTab();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEbuildDrugList);
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
		Assertion.assertFalse("Validation failed : UnExpected Plan Compare check is Visible - ", validationFlag);

	}

	@When("^verify Call SAM icon is visible or not on Plan Comapare Page$")
	public void verify_Call_SAM_icon_is_visible_or_not_PlanCompare_Page() throws InterruptedException {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallSam();
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		Assertion.assertTrue(true);
		System.out.println("TFN Widget is Displayed");
	}

	@And("^verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare Page$")
	public void verify_Call_SAM_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent_PlanCompare_Page()
			throws InterruptedException {

		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallSamContent();

	}

	@Then("^user verify the popup and content on Plan Comapare Page$")
	public void user_verify_the_popup_and_content_PlanCompare_Page() throws InterruptedException {

		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallpopup();
	}

	@Then("^the user clicks on back on all plan link in Plan Compare page")
	public void user_clicks_back_to_all_plan_PlanCompare_page() throws InterruptedException {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		VPPPlanSummaryPage plansummaryPage = planComparePage.navigateBackToAllPlans();
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			Assertion.assertTrue(true);
			plansummaryPage.handlePlanYearSelectionPopup();
		} else
			Assertion.fail("Error in navigating back to Plan Summary Page");

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
	public void i_select_plans_and_plans_to_compare_and_click_on_compare_plan_link(String planType, String Counter)
			throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// int counter = Integer.parseInt(Counter);
//		if (planType.equals("MAPD")) {
//			// plansummaryPage.clickonViewPlans();
//			plansummaryPage.checkMAPlansOnly(Counter);
//			System.out.println("Selected All MAPD plans for Plan Compare");
//		}
//		else
		plansummaryPage.checkPlansForCompare(Counter,planType);
		
		ComparePlansPage planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
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
			Assertion.fail("Error in loading the compare plans page");
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
			Assertion.fail("Error in loading the compare plans page");
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
			Assertion.fail("Error in loading the compare plans page");
	}

	// New plan compare related
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
			Assertion.fail("Error in loading the compare plans page");
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
			Assertion.fail("Error in loading the compare plans page");
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
			Assertion.fail("Error in loading the compare plans page");
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
			Assertion.fail("Error in loading the compare plans page");
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
			Assertion.fail("Error in loading the compare plans page");
	}

	@Then("^the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare page$")
	public void user_clicks_enrollInPlan_newPlanCompare_AARP() throws InterruptedException {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		WelcomePage welcomeOLEPage = planComparePage.Enroll_OLE_Plancompare();
		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assertion.fail("Error Loading Welcome Page for OLE");
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
			Assertion.fail("Error in loading the compare plans page");
	}

	@Then("^user validates selected plans can be saved as favorite$")
	public void user_validates_selected_plan_can_be_saved_as_favorite(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = memberAttributesMap.get("Plan Year");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_YEAR, planYear);
		// ----- MA plan type ----------------------------
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateAbilityToSavePlans(ma_savePlanNames, planType);
		// plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);
		// //commented out because the previous line already validates after saving plan

		// ----- PDP plan type ---------------------------
		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateAbilityToSavePlans(pdp_savePlanNames, planType);
		// plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);
		// //commented out because the previous line already validates after saving plan

		// ----- SNP plan type ---------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateAbilityToSavePlans(snp_savePlanNames, planType);
		// plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType);
		// //commented out because the previous line already validates after saving plan
	}

	// vvv note: added for US1598162
	public Map<String, String> prepareTestInput(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		return memberAttributesMap;
	}

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change from Home page$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Home_page(
			DataTable givenAttributes) throws InterruptedException {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		System.out.println("Proceed to click Home button to enter zip code again");
		plansummaryPage.clickHomeButton();

		System.out.println("First go to a totally different zipcode = 90210");
		plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty("90210");

		System.out.println("Then go back to the test zipcode");
		plansummaryPage.clickHomeButton();
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty(zipcode);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			// System.out.println("TEST - loaded plansummary page for
			// zipcode='"+zipcode+"'");
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		// plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		// plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType);
	}

	@Then("^user validates ability to unsave a saved plan$")
	public void user_validates_ability_to_unsave_a_saved_plan(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ma_plans = memberAttributesMap.get("MA Test Plans");
		String pdp_plans = memberAttributesMap.get("PDP Test Plans");
		String snp_plans = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);
		// note: the second plan in the list will be unsaved
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		System.out.println("Proceed to unsave the " + planType + " second plan from the input");
		plansummaryPage.validateAbilityToUnSavePlans(ma_plans, planType);

		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		System.out.println("Proceed to unsave the " + planType + " second plan from the input");
		plansummaryPage.validateAbilityToUnSavePlans(pdp_plans, planType);

		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		System.out.println("Proceed to unsave the " + planType + " second plan from the input");
		plansummaryPage.validateAbilityToUnSavePlans(snp_plans, planType);
	}

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change from Home page$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Home_page(
			DataTable givenAttributes) throws InterruptedException {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		System.out.println("Proceed to click Home button to enter zip code again");
		plansummaryPage.clickHomeButton();

		System.out.println("First go to a totally different zipcode = 90210");
		plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty("90210");

		System.out.println("Then go back to the test zipcode");
		plansummaryPage.clickHomeButton();
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty(zipcode);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			// System.out.println("TEST - loaded plansummary page for
			// zipcode='"+zipcode+"'");
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " unsaved plan(s) are still unsaved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " unsaved plan(s) are still unsaved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " unsaved plan(s) are still unsaved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(snp_savePlanNames, planType);
	}

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change from Shop For a Plan Page$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Shop_For_a_Plan_Page(
			DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode("90210", "Los Angeles County", "NO");

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
		plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode(zipcode, county, isMultiCounty);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			// System.out.println("TEST - loaded plansummary page for
			// zipcode='"+zipcode+"'");
		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType);
	}

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change from Shop For a Plan Page$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Shop_For_a_Plan_Page(
			DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode("90210", "Los Angeles County", "NO");

		if (plansummaryPage != null) {
			System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
			plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode(zipcode, county, isMultiCounty);
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(snp_savePlanNames, planType);
	}

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change within VPP page$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_within_VPP_page(
			DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode("90210", "Los Angeles County",
				"NO");

		if (plansummaryPage != null) {
			System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
			plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode(zipcode, county, isMultiCounty);
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType);
	}

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change within VPP page$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_within_VPP(
			DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode("90210", "Los Angeles County",
				"NO");

		if (plansummaryPage != null) {
			System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
			plansummaryPage = plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode(zipcode, county,
					isMultiCounty);
			if (plansummaryPage == null) {
				Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
			}
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(snp_savePlanNames, planType);
	}

	@Then("^user closes the original tab and open new tab$")
	public void user_closes_the_original_tab_and_open_new_tab() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.closeOriginalTabAndOpenNewTab();
	}

	@Then("^user validates plans remain saved within same session$")
	public void user_validates_plans_remain_saved_within_same_session(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");

		String planYear = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		// planType="SNP";
		// System.out.println("Proceed to validate "+planType+" saved plan(s) are still
		// saved");
		// plansummaryPage.viewPlanSummary(planType);
		// plansummaryPage.handlePlanYearSelectionPopup();
		// plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType);
	}

	@Then("^the user enter the searchValue in the search text box and hits enter$")
	public void the_user_enter_the_searchValue_in_the_search_text_box_and_hits_enter(DataTable inputvalue)
			throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		urlAttributesMap = DataTableParser.readDataTableAsMaps(inputvalue);
		/*List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();

		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String InputValue = urlAttributesMap.get("search Value");
		System.out.println("Search value" + InputValue);
		Thread.sleep(3000);

		aquisitionhomepage.enterSearchtextvalue(InputValue);

	}

	@Then("^the user should see fifteen results before pagination$")
	public void the_user_should_see_fifteen_results_before_pagination() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateFifteenResults();

	}

	@Then("^the user validates count of results aganist the total shown at top of the page$")
	public void the_user_validates_count_of_results_aganist_the_total_shown_at_top_of_the_page() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCountResults();

	}

	@Then("^the user validates pagination and results displayed$")
	public void the_user_validates_pagination_and_results_displayed() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validatePaginationofSearchResults();
	}

	@Then("^the user validates the secondary search by providing newsearchvalue in the text box$")
	public void the_user_validates_the_secondary_search_by_providing_newsearchvalue_in_the_text_box(
			DataTable inputvalue) throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		urlAttributesMap = DataTableParser.readDataTableAsMaps(inputvalue);
		/*List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String InputValue = urlAttributesMap.get("NewSearchValue");
		System.out.println("NewSearchValue" + InputValue);
		Thread.sleep(3000);

		aquisitionhomepage.enterSecondarySearchValue(InputValue);

	}

	@Then("^the user clear secondary search box and insert new search value$")
	public void the_user_clear_secondary_search_box_and_insert_new_search_value(DataTable inputvalue) throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		urlAttributesMap = DataTableParser.readDataTableAsMaps(inputvalue);
		/*List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();

		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String InputValue = urlAttributesMap.get("New Search Value");
		System.out.println("New Search Value" + InputValue);
		Thread.sleep(3000);
		aquisitionhomepage.insertValueIntoSecondSearchBox(InputValue);

	}

	@Then("^the user validates Error message$")
	public void the_user_validates_Error_message(DataTable inputvalue) throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		urlAttributesMap = DataTableParser.readDataTableAsMaps(inputvalue);
		/*List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String error = urlAttributesMap.get("Error");
		String newSearchValue = urlAttributesMap.get("NewSearchValue");
		System.out.println("Error : " + error);
		Thread.sleep(3000);
		aquisitionhomepage.validateErrorMsg(error, newSearchValue);
	}

	@Then("^the user clicks on the united health care medicare solutions link$")
	public void the_user_clicks_on_the_united_health_care_medicare_solutions_link() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickUnitedHealthcareMedicareSolutions();

	}

	@Then("^the user validates the \"([^\"]*)\"$")
	public void the_user_validates_the(String url) throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateUrl(url);
	}

	@Then("^the user validates Error message on page$")
	public void the_user_validates_pagination_and_results_displayed(DataTable inputvalue) throws Throwable {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		urlAttributesMap = DataTableParser.readDataTableAsMaps(inputvalue);
		/*List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String error = urlAttributesMap.get("Error");
		String newSearchValue = urlAttributesMap.get("NewSearchValue");
		System.out.println("Error : " + error);
		Thread.sleep(3000);
		aquisitionhomepage.validateErrorMsg(error, newSearchValue);
	}

	/** user is on the AARP Medicare Site landing page */
	@Given("^the user is on Acquisition Site landing page and navigate to pharmacy search page$")
	public void validateUserIsOnAcquisitionSiteNavToPharmacySearch(DataTable givenAttributes) {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String site = memberAttributesMap.get("Site");
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, site);
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		System.out.println("TEST - testSiteUrl=" + testSiteUrl);
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);

		// aquisitionhomepage.selectState("Select State"); // note: default it to no
		// state selected for predictable result
		System.out.println("Unselected state on home page for more predictable result");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		PharmacySearchPage pharmacySearchPage = aquisitionhomepage.navigateToPharmacyLocator();
		// PharmacySearchPage pharmacySearchPage=new
		// PharmacySearchPage(aquisitionhomepage.driver);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
	}

	@When("^the user clicks on NBA to navigate to DCE Redesign page$")
	public void the_user_clicks_on_NBA_to_navigate_to_DCE_Redesign_page(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String planType = memberAttributesMap.get("Plan Type");
		String planName = memberAttributesMap.get("Plan Name");

		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		GetStartedPage getStartedPage = planSummaryPage.navigateToDCEFromNBA(planType, planName);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
	}

	@Then("^the site user fills all the details in MedsuppPage$")
	public void user_fills_all_details_medsupp(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String DateOfBirth = memberAttributesMap.get("DOB");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation(DateOfBirth);
		
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, plansummaryPage);
	}

	@Then("^the site user clicks on continue application until confirmaion page$")
	public void conitnue_application_until_confirmation_page(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String Medicarenumber = memberAttributesMap.get("MedicareNumber");
		String DateOfBirth = memberAttributesMap.get("DOB");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String submitconfirmation = plansummaryPage.continueApplicationuntilSubmitPage(Medicarenumber);
		getLoginScenario().saveBean(VPPCommonConstants.SUBMITCONFIRMATION, submitconfirmation);

	}

	@Then("^the site user validates the RightRails Links on Medsupp Page$")
	public void user_validate_rightrail_links_medsupp_page() throws Throwable {
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * Map<String, String> memberAttributesMap = new HashMap<String, String>(); for
		 * (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); } String urGuideURL =
		 * memberAttributesMap.get("UR Guide URL"); String GuideYourHealthURL =
		 * memberAttributesMap.get("Guide Your Health URL"); String OutlineCoverageURL =
		 * memberAttributesMap.get("Outline Coverage URL"); String PlanOverviewLink =
		 * memberAttributesMap.get("Plan overview URL"); String RulesandDisclosureLink=
		 * memberAttributesMap.get("Rules and Disclosure URL");
		 */
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		// if(urGuideURL!=null){
		plansummaryPage.medsuppOLERightRail();
		plansummaryPage.medsuppOLERightRailGuideourhealth();
	//	plansummaryPage.medsuppOLERightRailoutlinecoverage();
		plansummaryPage.medsuppOLERightRailplanoverview();
		plansummaryPage.medsuppOLERightRailRulesDisclose();
		plansummaryPage.medsuppOLERightRailEnrollmentDiscount();
		//plansummaryPage.medsuppOLERightRailLearnmore();

		// Assertion.assertTrue(true);
		// }else
		// Assertion.fail("Error in loading the yourguide Page");

	}

	@Then("^the site user clicks on Start Application Button and proceed Next$")
	public void Start_application_button_proceed_next(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		// String DateOfBirth = memberAttributesMap.get("DOB");
		String FirstName = memberAttributesMap.get("Firstname");
		String LastName = memberAttributesMap.get("Lastname");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String submitconfirmation = plansummaryPage.StartApplication(FirstName, LastName);
		getLoginScenario().saveBean(VPPCommonConstants.SUBMITCONFIRMATION, submitconfirmation);

	}

	@Then("^user validate the plandetails on medsupp plans$")
	public void user_validate_plandetails_medsupp_page() throws Throwable {

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.medsuppOLEplandetails();
		plansummaryPage.medsuppOLERightRail();
		plansummaryPage.medsuppOLERightRailGuideourhealth();
		// plansummaryPage.medsuppOLERightRailoutlinecoverage();
		plansummaryPage.medsuppOLERightRailplanoverview();
		plansummaryPage.medsuppOLERightRailRulesDisclose();
		plansummaryPage.medsuppOLERightRailEnrollmentDiscount();
	//	plansummaryPage.medsuppOLERightRailLearnmore();
	}

	@Then("^agent saves two plans as favorite for user$")
	public void agent_saves_two_plans_as_favorite_on_AARP_site_for_user(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String savePlanNames = memberAttributesMap.get("Test Plans");
		String planType = memberAttributesMap.get("Plan Type");

		switch (planType) {
		case "MAPD":
			plansummaryPage.savePlans(savePlanNames, planType);
			break;
		case "MA":
			plansummaryPage.savePlans(savePlanNames, planType);
			break;
		case "SNP":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.savePlans(savePlanNames, planType);
			break;
		case "PDP":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.savePlans(savePlanNames, planType);
			break;

		default:
			break;
		}
	}

	@When("user views plans of the below plan type$")
	public void user_view_plans_of_plantype(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String plantype = givenAttributesMap.get("Plan Type");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
	}

	// NBA

	@And("^user Verify and click perform on Next Best Action Modal for Get Started$")
	public void user_Verify_Next_Best_Action_Modal_for_MAPD_plan_and_click_on_Get_Started() {
		VPPPlanSummaryPage vppplansummarypage = (VPPPlanSummaryPage) loginScenario
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.validateNBAButton("Get Started");
		vppplansummarypage.clickOnButtonInPlanSummaryPage("Get Started");
	}

	List<String> allPlanNames = null;

	@When("^user clicks on Continue Enrollment button on summary page$")
	public void user_clicks_on_Continue_Enrollment_button_in_aarp_Site() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		allPlanNames = plansummaryPage.getAllPlanNames(planType);
		plansummaryPage.clickContinueEnrollmentBtn();

	}

	@Then("^user should be able to see the Select Plan for Enroll Modal with all plans on vpp summary page$")
	public void user_should_be_able_to_see_the_Select_Plan_for_Enroll_Modal_with_all_plans_in_UMS_site()
			throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifySelectPlanForEnrollModalForAllPlans(allPlanNames);

	}

	@When("^user clicks on Enroll in plan button on the select plan modal on vpp summary page$")
	public void user_clicks_on_Enroll_in_plan_button_on_the_select_plan_modal() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		WelcomePage welcomepage = (WelcomePage) plansummaryPage.clickEnrollPlanBtnOnSelectPlanModal();
		getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,welcomepage);
	}

	@Then("^user should be navigated to OLE page$")
	public void user_should_be_navigated_to_OLE_page() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateNavigatedToOle();
	}

	@Then("^user saves plan as favorite on vpp summary page$")
	public void user_saves_plan_as_favorite_on_UMS_site(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		System.out.println("Plan name" + PlanName);
		plansummaryPage.savePlan(PlanName);
	}

	@And("^user click on view saved plans button$")
	public void user_click_on_view_saved_plans_button() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		VisitorProfilePage visitorProfilePage = plansummaryPage.viewSavedPlans();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@Then("^user should see the Get started NBA on VPP$")
	public void user_should_see_the_Get_started_NBA() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNextBestActionModalForDrugCostAuthenticated();
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	}

	@When("^user clicks on Saved items on NBA$")
	public void user_clicks_on_Saved_items() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickSavedItems();
	}

	@Then("^user should be navigated to visitor profile page$")
	public void user_should_be_navigated_to_visitor_profile_page() throws Throwable {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateVisitorProfilePage();
	}

	@And("^user clicks on get started button on NBA$")
	public void user_click_Get_started_button_on_NBA() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickGetStartedBtnOnNba();
	}

	@And("^user validate Find a Provider NBA on VPP|user be able to see the Find a Provider NBA on VPP$")
	public void user_validate_Find_a_Provider_NBA_on_VPP() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateProviderNBA();
	}

	@When("^user clicks on Find a Provider button on NBA$")
	public void user_clicks_on_Find_a_provider_button_on_NBA() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		ProviderSearchPage providerSearchPage = (ProviderSearchPage) plansummaryPage
				.clickNextBestActionModalFindMyDoctorsBtn();
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}
	}

	@Then("^user should be able to see the NBA modal to Enroll Plan on the VPP summary page$")
	public void user_should_be_able_to_see_the_NBA_modal_to_Enroll_Plan_on_the_VPP_summary_page() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNextBestActionModalForEnrollPlan();
	}

	@When("^the user performs plan search from home page$")
	public void the_user_performs_plan_search_from_home_page(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
			plansummaryPage = aquisitionhomepage.searchPlansShop(zipcode, county);
		}
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}

	@Then("^user should be able to see the NBA modal to add providers on the VPP summary page$")
	public void user_should_be_able_to_see_the_NBA_modal_to_add_providers_on_the_VPP_summary_page() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNextBestActionModalForProviderSearch();
	}

	@When("^user clicks on Find My Doctor button$")
	public void user_clicks_on_Find_My_Doctor_button() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		ProviderSearchPage providerSearchPage = (ProviderSearchPage) plansummaryPage
				.clickNextBestActionModalFindMyDoctorsBtn();
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}
	}

	@Then("^the user enters following information in Request Plan Information Guide$")
	public void the_user_enters_following__information_in_Request_Plan_Information_Guide(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		// String DateOfBirth = memberAttributesMap.get("DOB");
		String FirstName = memberAttributesMap.get("Firstname");
		String LastName = memberAttributesMap.get("Lastname");
		String EmailAddress = memberAttributesMap.get("Email");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.RequestPlanIInformation(FirstName, LastName, EmailAddress);

	}

	@Then("^the user clicks on back on all plan linnk in Plan Compare page")
	public void user_clicks_back_to_all_plan_PlanCompare_AARP() throws InterruptedException {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		VPPPlanSummaryPage plansummaryPage = planComparePage.navigateBackToAllPlans();
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			Assertion.assertTrue(true);
			plansummaryPage.handlePlanYearSelectionPopup();
		} else
			Assertion.fail("Error in navigating back to Plan Summary Page");

	}

	@Then("^remove \"([^\"]*)\" plan from new plan compare page$")
	public void remove_plan_from_new_plan_compare_page_for_UHC(String planIndices) throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnSelectedRemoveLink(planIndices);
	}

	@Then("^validate optional service riders section on compare page is not shown$")
	public void validate_optional_service_riders_section_on_compare_page_is_not_shown() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateOptionalRidersSectionHidden();
	}

	@Then("^validate all available plans are shown on click of view all plans$")
	public void validate_all_plans_are_shown() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateAllPlansShown();
	}

	@Then("^validate OON Toggle is displayed on medical and additional benefits$")
	public void validate_OON_Toggle_is_displayed_on_medical_and_additional_benefits() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateOONDDisplayed();
	}

	@Then("^Validate OON Toggle is not displayed when there are no OON Plans Available$")
	public void validate_OON_Toggle_is_not_displayed_when_there_are_no_OON_Plans_Available() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateOONNotDisplayed();
	}

	@Then("^validate view locations popup on compare page$")
	public void validate_view_locations_popup_on_compare_page() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateViewLocation();
	}

	@Given("^I select \"([^\"]*)\" plans and \"([^\"]*)\" plans to compare$")
	public void i_select_plans_for_compare(String planType, String Counter) throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.checkPlansForCompare(Counter, planType);
	}

	@Then("^click add to compare checkbox on plan details page and navigate to compare page$")
	public void click_add_to_compare_checkbox_on_plan_details_page_and_navigate_to_compare_page() throws Throwable {
		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		ComparePlansPage planComparePage = planDetailsPage.addToCompareAndNavigate();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else
			Assertion.fail("Error in loading the compare plans page");
	}

	@When("^user clicks on Select a plan button on NBA$")
	public void user_clicks_on_select_a_plan_button_on_NBA() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		System.out.println("plan ytpe" +planType);
		allPlanNames = plansummaryPage.getAllPlanNames(planType);
		plansummaryPage.clickSelectPlanButton();
	}

	@Then("^user should be able to see the Select Plan for Enroll Modal with all plans$")
	public void user_should_be_able_to_see_the_Select_Plan_for_Enroll_Modal_with_all_plans() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifySelectPlanForEnrollModalForallPlans(allPlanNames);
	}

	@Then("^user saves plan as favorite on VPP$")
	public void user_saves_plan_as_favorite_on_VPP(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		System.out.println("Plan name" + PlanName);
		plansummaryPage.savePlan(PlanName);
	}

	@Then("^user should be able to see the Select Plan for Enroll Modal with saved plans$")
	public void user_should_be_able_to_see_Select_Plan_for_Enroll_Modal_with_Saved_plans(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		System.out.println("Plan name" + PlanName);
		plansummaryPage.verifySelectPlanForEnrollModalForSavedPlans(PlanName);
	}

	@Then("^user removes existing saved plans in visitor profile$")
	public void user_removed_existing_saved_plans() {
		VisitorProfilePage visitorProfile = (VisitorProfilePage) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.deletePlans();
	}

	@Then("^user should be able to see the continue enrollment modal$")
	public void user_should_be_able_to_see_the_continue_enrollment_modal() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNextBestActionModalForContinueEnrollment();
	}

	@When("^user clicks on continue enrollment button$")
	public void user_clicks_on_continue_enrollment_button() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickNextBestActionModalContinueEnrollmentBtn();
	}

	@Then("^user should navigated to enrollment page$")
	public void user_should_navigated_to_enrollment_page() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNavigationToOLEPage();
	}

	@Then("^user should be able to see the continue enrollment modal for multiple plan$")
	public void user_should_be_able_to_see_the_continue_enrollment_modal_for_multiple_plan() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNextBestActionModalForContinueEnrollmentMultiplePlans();
	}

	@Then("^continue enrollment button should be displayed for each plan$")
	public void continue_enrollment_button_should_be_displayed_for_each_plan() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateContinueEnrollmentModal();
	}

	@When("^user clicks on continue enrollment button on the modal$")
	public void user_clicks_on_continue_enrollment_button_on_the_modal() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickContinueEnrollmentBtnOnModal();
	}

	@Then("^the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare")
	public void user_clicks_enrollInPlan_newPlanCompare() throws InterruptedException {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		WelcomePage welcomeOLEPage = planComparePage.Enroll_OLE_Plancompare();
		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assertion.fail("Error Loading Welcome Page for OLE");
		}
	}

	@Then("^the user clicks on Plan details link in new Plan Compare page")
	public void user_clicks_planDetails_newPlanCompare() throws InterruptedException {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		PlanDetailsPage vppPlanDetailsPage = planComparePage.navigateToPlanDetailfromplanCompare();
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in Loading the Plan Details Page");

	}

	@Then("^Click on view more plans for right navigaton$")
	public void Clickonviewmoreplansforrightnavigatonon() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateViewMoreplansComparePage();
	}

	@Then("^Click on view less plans for left navigaton$")
	public void Clickonviewlessplansforrightnavigatonon() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateViewlessplansComparePage();
	}

	@Given("^remove one plan from \"([^\"]*)\" new plan compare and verify remove icon is disabled page$")
	public void removeoneplanfrom_compare_plan_link(String Counter) throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.CounterNewRemoveLink(Counter);
	}

	@Then("^Click on Dental Flyer Link$")
	public void clickonDentalFlyerLink(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String PDFtype = memberAttributesMap.get("PDF LINK");
		String DocCode = memberAttributesMap.get("DocumentCode");
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.CounterDentalFlyerLink(PDFtype, DocCode);
	}

	@When("^user removes drugs from plan card$")
	public void user_removes_drugs_from_plan_card() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.removeDrugsFromPlanCard();
	}

	@When("^user removes provider from plan card$")
	public void user_removes_provider_from_plan_card() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.removeProvidersFromPlanCard();
	}
	
	@Then("^the user validate on medsupp plans confirmation page$")
	public void User_validate_medsupp_plans_confirmation_page() throws Throwable {
		
		if (!(MRScenario.environment.equalsIgnoreCase("offline")
				|| MRScenario.environment.equalsIgnoreCase("prod"))) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	
		plansummaryPage.medsuppOLEPlanOverview();
		plansummaryPage.medsuppOLEBenefitsTable();
		plansummaryPage.medsuppOLERulesandDisclosures();
		plansummaryPage.medsuppOLEHealthInsurance();
		plansummaryPage.medsuppOLEAARPSupplementPlans();
	//	plansummaryPage.medsuppOLEPrintandSaveApplication();
		plansummaryPage.medsuppOLEViewPrescriptionDrugPlans();
	
		}
	}
	
	@When("^the user performs plan search using learn about medicare Pages$")
	public void learn_about_medicare_zipcode_details(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
			plansummaryPage = aquisitionhomepage.searchPlansWithOutCountyLearnMedicareMedsupp(zipcode);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlansLearnMedicareMedsupp(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}
	
	@Given("^the user navigates to following Campaign acquisition site page for External Links$")
	public void the_user_navigates_to_following_medicare_acquisition_site_for_External_Links(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String path = memberAttributesMap.get("PagePath");
		String plantype = memberAttributesMap.get("Plan Type");
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : " + path);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		aquisitionhomepage.navigateToPath(path);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(wd);
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
			getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
			getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
			getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}
	
	@Then("^the user enters following information in Request Plan Information Guide through Shop Pages$")
	public void the_user_enters_following__information_in_Request_Plan_Information_Guide_through_shop_pages(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/		
		String EmailAddress = memberAttributesMap.get("Email");
		ShopForPlanNavigationPage shopaplan = (ShopForPlanNavigationPage) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		//ShopPage shopPage = 
				shopaplan.RequestPlanIInformationshoppages(EmailAddress);
		//getLoginScenario().saveBean(PageConstants.SHOP_PAGE, shopPage);

	}
	@Then("^user changes zipcode within VPP page$")
	public void User_Change_ZipCode_VPP_page(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		
		if (plansummaryPage != null) {
			System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
			plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode(zipcode, county, isMultiCounty);
		} else {
			Assertion.assertTrue("PROBLEM - plansummaryPage is null", false);
		}
	}
	@When("^the user performs plan search using Shop Pages for DSNP Plans$")
	public void Standalone_zipcode_details_dsnp_plans(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
			plansummaryPage = aquisitionhomepage.searchPlansWithOutCountyShopDSNPEnroll(zipcode);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlansShopDSNPEnroll(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}
	@Then("^the user picks each example from excel to validate Plan Document PDFs and reports into excel$")
	public void the_user_ExceldataValidation_PDF_link_and_validates_document_code_in_PDFtext_URL(DataTable givenAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String ExcelName = givenAttributesMap.get("ExcelFile");
		String ExcelNameDocLog = givenAttributesMap.get("ExcelFileDocLog");
		String sheetName = givenAttributesMap.get("WorkSheetName");
		String sheetNameDocLog = "Doc Log";
		String siteType = givenAttributesMap.get("Site");
		System.out.println("Set of TFNs from Sheet : "+sheetName);
		
		WebDriver wd = getLoginScenario().getWebDriverNew();
		 getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
		//Getting Date
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		Date RunDate = new Date();
		String DateCreated = dateFormat.format(RunDate);
		String parentDirectory = null;
		Sheet sheetDocLog = null;
		parentDirectory = new java.io.File(".").getCanonicalPath();
		String InputFilePath = parentDirectory+"/src/main/resources/database/PlanDocs/"+ExcelName+".xls";
		String InputFilePathDocLog = parentDirectory+"/src/main/resources/database/PlanDocs/MADocLog.xls";
		String InputFilePathDocLogPDP = parentDirectory+"/src/main/resources/database/PlanDocs/PDPDocLog.xls";

		String OutputFilePath = parentDirectory+"/target/PDFvalidation_Results_"+sheetName+"_"+siteType+"_"+DateCreated+".xls";
		
		//Reading the input file
		File InputFile = new File(InputFilePath);
		FileInputStream inputStream = new FileInputStream(InputFile);
		Workbook workbook = new HSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		
		//Reading the MADocLog file
		File InputFileDocLog = new File(InputFilePathDocLog);
		FileInputStream inputStreamDocLog = new FileInputStream(InputFileDocLog);
		Workbook workbookDocLog = new HSSFWorkbook(inputStreamDocLog);
		Sheet sheetDocLogMA = workbookDocLog.getSheet(sheetNameDocLog);
		int lastRowDocLogMA = sheetDocLogMA.getLastRowNum();
		
		//Reading the PDPDocLog file
		File InputFileDocLogPDP = new File(InputFilePathDocLogPDP);
		FileInputStream inputStreamDocLogPDP = new FileInputStream(InputFileDocLogPDP);
		Workbook workbookDocLogPDP = new HSSFWorkbook(inputStreamDocLogPDP);
		Sheet sheetDocLogPDP = workbookDocLogPDP.getSheet(sheetNameDocLog);
		int lastRowDocLogPDP = sheetDocLogPDP.getLastRowNum();
		
		//Creating the results excel book
		Workbook ResultWorkbook = new HSSFWorkbook();
		Sheet ResultsSheet = ResultWorkbook.createSheet(sheetName);
		
		
		//Creating styles to use to highlight cells with colors
		CellStyle stylePassed = ResultWorkbook.createCellStyle();
		stylePassed.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		stylePassed.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		CellStyle styleFailed = ResultWorkbook.createCellStyle();
		styleFailed.setFillForegroundColor(IndexedColors.RED.getIndex());
		styleFailed.setFillPattern(CellStyle.SOLID_FOREGROUND);
		try {
			 PlanDetailsPage planDetailsPage = null;
			 String currentCellValue = "";
			 String currentColName = "";
			 System.out.println(sheetName+ " SAUCE URL: "+ getLoginScenario().returnJobURL());
			 HashMap <String, Integer> colNamesMapMA = new HashMap<String, Integer>(); 
			 HashMap <String, Integer> colNamesMapPDP = new HashMap<String, Integer>(); 
			 
			
			
				 HSSFRow rowDocLog1 = (HSSFRow) sheetDocLogMA.getRow(0);
				 Iterator<Cell> cellIteratorDocLog = rowDocLog1.cellIterator();
				 HSSFRow rowDocLogPDP = (HSSFRow) sheetDocLogPDP.getRow(0);
				 Iterator<Cell> cellIteratorDocLogPDP = rowDocLog1.cellIterator();
				 
				 String header = "";
	             int ci =0, ci1=0;
	             //loops around column headers for MADoclog file and puts the header names in a map with an integer for each
	             while(cellIteratorDocLog.hasNext()) {
	            	 HSSFCell cell = (HSSFCell) cellIteratorDocLog.next();
	            	 if(cell.getStringCellValue()!=null)
	            		 header = cell.getStringCellValue().replaceAll("\n", "").replaceAll("\\s+", "");
	            	 try {
	            		 //System.out.println("header "+ci+" : "+header);
	            	 colNamesMapMA.put(header, ci);
	            	 }catch (Exception e) {
	            		 System.out.println("Error in getting cell values from Doc log headers");
	            	 }
	            	 ci++;
	             }
	             //loops around column headers for PDPDoclog file and puts the header names in a map with an integer for each
	             header = "";
	             while(cellIteratorDocLogPDP.hasNext()) {
	            	 HSSFCell cell = (HSSFCell) cellIteratorDocLogPDP.next();
	            	 if(cell.getStringCellValue()!=null)
	            		 header = cell.getStringCellValue().replaceAll("\n", "").replaceAll("\\s+", "");
	            	 try {
	            		 //System.out.println("header "+ci+" : "+header);
	            	 colNamesMapPDP.put(header, ci1);
	            	 }catch (Exception e) {
	            		 System.out.println("Error in getting cell values from Doc log headers");
	            	 }
	            	 ci1++;
	             }
	             
	             
	             int docTypeColIndex = 0;
	             int langColIndex = 0;
	             int componentCodeIndex =0;
	             int planIDIndexDocLog = 0;
	             int planNameIndexDocLog = 0;
	             int yearIndexDocLog = 0;
	             
	         //getting the respective col numbers for the following headers in MADocLog
             int docTypeColIndexMA = colNamesMapMA.get("DocType");
             int langColIndexMA = colNamesMapMA.get("OCP/ODP");
             int componentCodeIndexMA = colNamesMapMA.get("ComponentorKitCode(MA/PDP/OCPMA&PDP);FileNameorKitCode(MS/OCPMS)");
             int planIDIndexDocLogMA = colNamesMapMA.get("Contract-PBP-SegmentID");
             int planNameIndexDocLogMA = colNamesMapMA.get("DocumentDescription");
             int yearIndexDocLogMA = colNamesMapMA.get("Year");
             
             //getting the respective col numbers for the following headers in PDPDocLog
             int docTypeColIndexPDP = colNamesMapPDP.get("DocType");
             int langColIndexPDP = colNamesMapPDP.get("OCP/ODP");
             int componentCodeIndexPDP = colNamesMapPDP.get("ComponentorKitCode(MA/PDP/OCPMA&PDP);FileNameorKitCode(MS/OCPMS)");
             int planIDIndexDocLogPDP = colNamesMapPDP.get("Contract-PBP-SegmentID");
             int planNameIndexDocLogPDP = colNamesMapPDP.get("DocumentDescription");
             int yearIndexDocLogPDP = colNamesMapMA.get("Year");
			 String  planType = "";
			 for(int rowIndex=0; rowIndex<=lastRow; rowIndex++)
	            {
				 
				 	int cellIndex = 0;
				 	
				 	HSSFRow row = (HSSFRow) sheet.getRow(rowIndex);
	                Iterator<Cell> cellIterator = row.cellIterator();
	                HSSFRow resultsRow = (HSSFRow) ResultsSheet.createRow(rowIndex);
	              
	                //looping through columns until an empty column is found
	                while (cellIterator.hasNext()) 
	                {
	                	 HashMap <Boolean, String> resultMap = new HashMap<Boolean, String>(); 
	                	 boolean valueMatches = true; 
	                	 
	                	 HSSFCell cell = (HSSFCell) cellIterator.next();
			             
	                	 try {
	                		 currentCellValue = cell.getStringCellValue();
	                		 currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue();
	                	 }catch (Exception e) {
	                		 System.out.println("Error getting value for "+sheetName+ " Row "+rowIndex +" Cell "+cell);
	                		 System.out.println(e);
	                	 }
		                 HSSFCell newCell = (HSSFCell) resultsRow.createCell(cellIndex); 
						 if(rowIndex==0) {
							 newCell.setCellValue(cell.getStringCellValue()); 
							 
						 }
						 if(rowIndex!=0) { //skip the header row
							 if(cellIndex==0) { 
								 
								  System.out.println("Validating "+sheetName+ " Row "+rowIndex+" ************************************************************");
								  new VppCommonPage(wd,siteType,currentCellValue);  //gets the partial deeplink fromt the excel and appends it with the environment URL and navigates to plan details page	
								  planDetailsPage = new PlanDetailsPage(wd);
							 }
							 
							 //based on the column headers, determines the equivalent name of the pdf in the doclog file and the language for that pdf to match in the doclog file
							 ArrayList<String> docLangList = planDetailsPage.getDocNameAndLanguage(currentColName);
							 int rowIndexOfDocCode = 0; String planId= "", planYear ="", planName = "";
							 
							 if(currentColName.equalsIgnoreCase("plan id"))
								 planId = cell.getStringCellValue();
							 else if(currentColName.equalsIgnoreCase("plan type"))
								 planType = cell.getStringCellValue();
							 else if(currentColName.equalsIgnoreCase("year"))
								 planYear = cell.getStringCellValue();
							 else if(currentColName.equalsIgnoreCase("plan name"))
								 planName = cell.getStringCellValue();
								 
							 boolean flag = false; String failedMessage = "";
							 if(!(currentColName.contains("Link")||currentColName.contains("Year")||currentColName.equalsIgnoreCase("zipcode")||currentColName.equalsIgnoreCase("county")||currentColName.equalsIgnoreCase("plan name")||currentColName.equalsIgnoreCase("fips")||currentColName.equalsIgnoreCase("plan type")||currentColName.equalsIgnoreCase("plan id"))){ 
							  resultMap = planDetailsPage.clickAndValidatePDFText_URL(currentColName); //method returns true/false value along with the document code in hashmap
							   
							  	if(resultMap.containsKey(true) && (resultMap.get(true).equalsIgnoreCase("NA")||currentColName.contains("Step Therapy") || currentColName.contains("Prior Auth") ||currentColName.contains("Formulary Additions")||currentColName.contains("Formulary Deletions"))) {
							  		newCell.setCellStyle(stylePassed);
							  		newCell.setCellValue(resultMap.get(true));
							  	}else if (resultMap.containsKey(true)) {// if the validatePDF returns True
							  	
							  		int lastRowDocLog = 0;
							  		String compCode = resultMap.get(true);
									  		if(planType.equalsIgnoreCase("PDP")) {
									  			lastRowDocLog = lastRowDocLogPDP;
									  			sheetDocLog = sheetDocLogPDP;
									  			docTypeColIndex = docTypeColIndexPDP;
									  			langColIndex = langColIndexPDP;
									  			componentCodeIndex = componentCodeIndexPDP;
									  			planIDIndexDocLog = planIDIndexDocLogPDP;
									  			planNameIndexDocLog = planNameIndexDocLogPDP;
									  			yearIndexDocLog = yearIndexDocLogPDP;
									  		}else {
									  			lastRowDocLog = lastRowDocLogMA;
									  			sheetDocLog = sheetDocLogMA; 
									  			docTypeColIndex = docTypeColIndexMA;
									  			langColIndex = langColIndexMA;
									  			componentCodeIndex = componentCodeIndexMA;
									  			planIDIndexDocLog = planIDIndexDocLogMA;
									  			planNameIndexDocLog = planNameIndexDocLogMA;
									  			yearIndexDocLog = yearIndexDocLogMA;
									  		}
	
							  				
											//loops through all of the rows in the DOCLog (either PDP or MA based on plantype) excel file for the column that contains the component code and checks if the code exists. if it does, then it returns the index of that row 
									  		for(int rowIndexDocLog=1; rowIndexDocLog<=lastRowDocLog ; rowIndexDocLog++) {
									  			 String cellValueOfCompCode = sheetDocLog.getRow(rowIndexDocLog).getCell(componentCodeIndex).getStringCellValue();
									  			if(cellValueOfCompCode.contains(compCode)){
									  				rowIndexOfDocCode = rowIndexDocLog;break;
									  			}		
											  }
									  		double yearDocLog=0; String planYearDocLog = "";
									  		String docTypeDocLog = sheetDocLog.getRow(rowIndexOfDocCode).getCell(docTypeColIndex).getStringCellValue(); // document type value from the doclog file
									  		String langDocLog = sheetDocLog.getRow(rowIndexOfDocCode).getCell(langColIndex).getStringCellValue(); //language value from doclog file
									  		String planIDDocLog = sheetDocLog.getRow(rowIndexOfDocCode).getCell(planIDIndexDocLog).getStringCellValue(); //plan id from the doclog file
									  		String planNameDocLog = sheetDocLog.getRow(rowIndexOfDocCode).getCell(planNameIndexDocLog).getStringCellValue(); //plan name from the doclog file
									  		
									  		// if plan year cell contains a numeric value then converts to a string 
									  		if(sheetDocLog.getRow(rowIndexOfDocCode).getCell(yearIndexDocLog).getCellType() == Cell.CELL_TYPE_NUMERIC) {
									  			yearDocLog = sheetDocLog.getRow(rowIndexOfDocCode).getCell(yearIndexDocLog).getNumericCellValue(); //plan year from the doclog file
									  			planYearDocLog = String.valueOf(yearDocLog);
									  			planYearDocLog = planYearDocLog.substring(0, planYearDocLog.indexOf("."));
									  		}else {
									  			planYearDocLog  = sheetDocLog.getRow(rowIndexOfDocCode).getCell(yearIndexDocLog).getStringCellValue();
									  		}
									  		//checks if the doc type matches for this component code
									  		 if(docTypeDocLog.contains(docLangList.get(0))){
									  			 //checks if the language matches for this component code
										  			if(langDocLog.contains(docLangList.get(1))){
										  				//checks if plan id matches for the component code
											  				if(planIDDocLog.contains(planId)) {
											  					//checks if plan name matches for the component code
											  						if(planNameDocLog.contains(planName)) {
											  							//checks if plan year matches the component code
											  								if(planYearDocLog.contains(planYear)) {
											  									flag = true;
															  					newCell.setCellStyle(stylePassed);
																				newCell.setCellValue(resultMap.get(true));
											  								}else {
											  									failedMessage = "Failed to match the component code with the plan year: "+planYearDocLog;
															  					newCell.setCellStyle(styleFailed);
															  					newCell.setCellValue(resultMap.get(true)+ ": "+failedMessage);
											  								}
											  						}else {
											  							failedMessage = "Failed to match the component code with the plan name: "+planNameDocLog;
													  					newCell.setCellStyle(styleFailed);
													  					newCell.setCellValue(resultMap.get(true)+ ": "+failedMessage);
											  						}
											  					
													  		 }else{// else for plan id check
													  			 failedMessage = "Failed to match the component code with the plan ID: "+planIDDocLog;
											  					newCell.setCellStyle(styleFailed);
											  					newCell.setCellValue(resultMap.get(true)+ ": "+failedMessage);
													  		 }
												  	}else { //else for language check in the DOclog
												  		failedMessage =  "Failed to match the component code with the Language: "+langDocLog;
										  				newCell.setCellStyle(styleFailed);
										  				newCell.setCellValue(resultMap.get(true)+ ": "+failedMessage);
												  	}
									  		 }else { //else for document code check in the doclog
									  			 failedMessage = "Failed to match the component code with the document type: "+docTypeDocLog;
									  		 	newCell.setCellStyle(styleFailed);
									  		 	newCell.setCellValue(resultMap.get(true)+ ": "+failedMessage);
									  		 }
									  		 
									  		 if(failedMessage!= "")
									  			 System.out.println("Excel comparison Failed: "+failedMessage);
									  		 else
									  			 System.out.println("Excel comparison Passed for "+ resultMap.get(true));
									  		 
								  	} else { //else for if the valiatePDF method returns false
								  		newCell.setCellStyle(styleFailed);
								  		newCell.setCellValue(resultMap.get(false));
								  	}
							  /*if (resultMap.containsKey(true)) {
									newCell.setCellStyle(stylePassed);
									newCell.setCellValue(resultMap.get(true));
								} else {
									newCell.setCellStyle(styleFailed);
									newCell.setCellValue(resultMap.get(false));
								
								}*/
							 }else { //else for if the columns are the first few columns where validation is not needed. e.x link, plan name, etc.
								 newCell.setCellValue(cell.getStringCellValue());
							 }
						 }
						 
						 cellIndex++;
	                
	                }// while loop end
	            }// for loop end
			File OutputFile = new File(OutputFilePath);
			FileOutputStream outputStream = new FileOutputStream(OutputFile);
			ResultWorkbook.write(outputStream);
			inputStream.close();
			outputStream.flush();			
			outputStream.close();
		} catch (Exception e) {
			File OutputFile = new File(OutputFilePath);
			FileOutputStream outputStream = new FileOutputStream(OutputFile);
			ResultWorkbook.write(outputStream);
			inputStream.close();
			outputStream.flush();
			outputStream.close();
			e.printStackTrace();
		}

	}
	
	@Then("^the user clicks on compare plans button on plan details page and navigate to compare page$")
	public void clicks__compare_plans_button_on_plan_details_page_and_navigate_to_compare_page() throws Throwable {
		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		ComparePlansPage planComparePage = planDetailsPage.navigateToPlanCompare();
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		
	}
	
	@Then("^the user quits the session$")
	public void user_ends_current_session() throws Throwable {
		WebDriver wd  =(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
	}
	
	@Then("^user should be navigated to VPP summary page$")
	public void user_should_be_navigated_to_VPP_summary_page() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateVPPSummaryPage();
	}
	@Then("^user should be navigated to VPP detail page$")
	public void user_should_be_navigated_to_VPP_details_page() throws Throwable {
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validateVPPDetailsPage();
	}
	
	@Then("^user should be able to see the NBA modal to add drugs on the VPP summary page$")
	public void user_should_be_able_to_see_the_NBA_modal_to_add_drugs_on_the_VPP_summary_page() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNextBestActionModalForDrugCost();
	}
	
	@Then("^user verify NBA is not displayed on the VPP page$")
	public void user_verify_NBA_is_not_displayed_on_the_VPP_page() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyNBAModalNotDisplayed();
	}
	
	@Then("^the site user clicks on continue application until confirmaion page for vpp pages$")
	public void conitnue_application_until_confirmation_page_vpp_page(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String Medicarenumber = memberAttributesMap.get("MedicareNumber");
		String DateOfBirth = memberAttributesMap.get("DOB");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String submitconfirmation = plansummaryPage.continueApplicationuntilSubmitPagevpppages(Medicarenumber);
		getLoginScenario().saveBean(VPPCommonConstants.SUBMITCONFIRMATION, submitconfirmation);

	}
	
	@Then("^verify all links on plan compare page is loaded$")
	public void verify_alllinks_on_plan_compare_page_is_loaded_on_AARP() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateALLFiledsPlanComparePage();
	}
	
	@Then("^verify view all plan button is not displayed$")
	public void verifyviewallplanbuttonisnotdisplayed() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateViewALLplanButtonNotDisplayed();
	}
	
	@And("^I click on Add Places from Hospitals find care page$")
	public void I_click_on_Add_Hospitals_on_plan_compare_and_Add_PlacesfromHospitals_find_care_page() throws Exception {
		FindCarePage findCarePage = (FindCarePage) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPage planComparePage = findCarePage.HospitalPlaces();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assertion.fail("Error in loading the compare plans page");
	}
	
	@Then("^user click on close button on Drug info Modal popup")
	public void user_clicks_close_plan_PlanCompare_page() throws InterruptedException {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.dceModelClosepopup();
	}
	
	@Then("^validate all subtabs displayed on plan details$")
	public void validateplandetaillinks() throws Throwable {
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatealllinksonPlanDetails();
	}
	
	@Then("^User click on provider link on Medical tab and navigates to rally page$")
	public void user_EditProvider_on_PlanDetailsPage() {

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		ProviderSearchPage providerSearchPage = vppPlanDetailsPage.validateEditDocotrsProviderButton();
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}

	}

	@Then("^user clicks on Change Zip code link$")
	public void user_clicks_on_Change_Zip_code_link() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickOnChangeZipCode();
	}

	@When("^the user clicks on Find plans on vpp using following information$")
	public void the_user_clicks_on_Find_plans_on_vpp_using_following_information(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String county2 = memberAttributesMap.get("County Name2");
		String isMultiCounty2 = memberAttributesMap.get("Is Multi County2");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.searchPlansCounty(county2, isMultiCounty2);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			if (plansummaryPage.validateVPPPlanSummaryPage())
				Assertion.assertTrue(true);
			else
				Assertion.fail("Error in validating the Plan Summary Page");

		}
	}
	
	@Then("^the user click the Email Plan List envelope icon or text on Plan summary page")
	public void the_user_click_the_Email_Plan_List_envelope_icon_or_text_on_Plan_summary_page() throws InterruptedException {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickOnEmailField();
	}
	
	@Then("^user want the email address associated to my profile prepopulated in the text box on plan summary page")
	public void user_want_the_email_address_associated_to_my_profile_prepopulated_in_the_text_box_on_plan_summary_page(DataTable givenAttributes) throws InterruptedException {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String email = memberAttributesMap.get("User Name");
		plansummaryPage.validatePrepopulatedEmail(email);
	}
	
	@Then("^the user click the Email Plan List envelope icon or text on Plan details page")
	public void the_user_click_the_Email_Plan_List_envelope_icon_or_text_on_Plan_details_page() throws InterruptedException {
		PlanDetailsPage planDetails = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		planDetails.clickOnEmailField();
	}
	
	@Then("^user want the email address associated to my profile prepopulated in the text box on plan detail page")
	public void user_want_the_email_address_associated_to_my_profile_prepopulated_in_the_text_box_on_plan_detail_page(DataTable givenAttributes) throws InterruptedException {
		PlanDetailsPage planDetails = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String email = memberAttributesMap.get("User Name");
		planDetails.validatePrepopulatedEmail(email);
	}
	
	@Then("^the user click the Email Plan List envelope icon or text on Plan compare page")
	public void the_user_click_the_Email_Plan_List_envelope_icon_or_text_on_Plan_compare_page() throws InterruptedException {
		ComparePlansPage planCompare = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planCompare.clickOnEmailField();
	}
	
	@Then("^user want the email address associated to my profile prepopulated in the text box on plan compare page")
	public void user_want_the_email_address_associated_to_my_profile_prepopulated_in_the_text_box_on_plan_compare_page(DataTable givenAttributes) throws InterruptedException {
		ComparePlansPage planCompare = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String email = memberAttributesMap.get("User Name");
		planCompare.validatePrepopulatedEmail(email);
	}
	
	@Then("^user clicks on Select by Address and Enter fileds$")
	public void user_clicks_on_Select_by_Address_and_Enter_fileds(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String address = memberAttributesMap.get("Address");
		String city = memberAttributesMap.get("City");
		String state = memberAttributesMap.get("State");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.enterAddressDetails(address, city, state);
	}

	@Then("^I save \"([^\"]*)\" plans and \"([^\"]*)\" plans and verify the count update on shopping cart$")
	public void i_save_plans_and_verify_plan_count(String planType, String Counter)
			throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		switch(planType.toUpperCase()){
		case "MAPD":
		case "MA":
			plansummaryPage.savePlansOnSummaryAndVerifyCountOnCart(Counter,"MA");break;
			default: plansummaryPage.savePlansOnSummaryAndVerifyCountOnCart(Counter,planType.toUpperCase());break;
		}
	}	
	@Then("^I validate view more and view less links on plan summary$")
	public void i_validate_viewMore_and_viewLess()
			throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateViewMoreAndLessLinks();
	}	
	
	@Then("^I validate \"([^\"]*)\" plans with names \"([^\"]*)\" are listed correctly on summary page")
	public void I_validate_planNames_on_planSummary(String planType, String planNames)
	throws Throwable {
	VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
	.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	plansummaryPage.validatePlanNames(planType,planNames) ;
	}
	
	@When("^the user performs plan search using following information using external link$")
	public void zipcode_details_in_aarp_external_site(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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
			plansummaryPage = aquisitionhomepage.searchPlansWithOutCountyForExternalLink(zipcode);
		} else {
			plansummaryPage = aquisitionhomepage.externalsearchPlans(zipcode, county);
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}
	}
	
	@When("^user clicks on Add to compare checkbox on plan detail page$")
	public void user_clicks_on_compare_checknox_on_plan_details_page() throws Throwable {
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.clickCompareBox();
	}
	
	@Then("^verify the Add to compare checkbox is checked for selected plan$")
	public void verify_the_Add_to_compare_checkbox_is_checked_for_selected_plan(DataTable givenAttributes) {

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String planIndex = memberAttributesMap.get("Plan index");
		String plantype=(String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		System.out.println("plan type"+plantype);
		plansummaryPage.verifyPlanCompareCheckboxIsChecked(planIndex,plantype);
	}

	@When("^user select \"([^\"]*)\" plans to compare$")
	public void user_select_plans_to_compare(String planIndex)  {		
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String plantype=(String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		plansummaryPage.addPlanToCompareByIndex(planIndex,plantype);
		
	}
	
	@Then("^user clicks on compare button$")
	public void user_clicks_on_compare_button() {
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		ComparePlansPage planComparePage = plansummaryPage.clickCompareButton();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);

		} else
			Assertion.fail("Error in loading the compare plans page");
	}
	
	@Then("^the user enter the searchValue in the search text box$")
	public void the_user_enter_the_searchValue_in_the_search_text_box(DataTable inputvalue)
			throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		urlAttributesMap = DataTableParser.readDataTableAsMaps(inputvalue);
		/*List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String InputValue = urlAttributesMap.get("search Value");
		System.out.println("Search value" + InputValue);
		Thread.sleep(3000);
		aquisitionhomepage.enterSiteSearchValue(InputValue);

	}
	
	@Then("^the user should see the auto complete suggestions$")
	public void the_user_should_see_the_auto_complete_suggestions() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateAutoCompleteSuggestion();
	}

	@Then("^the user clicks on the first auto complete suggestion$")
	public void the_user_clicks_on_the_first_auto_complete_suggestion(){
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickFirstSuggestion();
	}
	
	@Then("^the user enter the secondary searchValue in the search text box$")
	public void the_user_enter_the_secondary_searchValue_in_the_search_text_box(
			DataTable inputvalue) throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		urlAttributesMap = DataTableParser.readDataTableAsMaps(inputvalue);
		/*List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String InputValue = urlAttributesMap.get("NewSearchValue");
		System.out.println("NewSearchValue" + InputValue);
		Thread.sleep(3000);

		aquisitionhomepage.enterSecondarySiteSearchValue(InputValue);
	}
	
	@Then("^the user should see the auto complete suggestions site search page$")
	public void the_user_should_see_the_auto_complete_suggestions_site_search_page() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateAutoCompleteSuggestionSiteSearchPage();
	}
	
	@Then("^the user clicks on the first auto complete suggestion site search page$")
	public void the_user_clicks_on_the_first_auto_complete_suggestion_site_search_page(){
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickFirstSuggestionSiteSearch();
	}

	@And("^the user views the plans of the below plan type for shop pages$")
	public void user_performs_planSearch_in_aarp_sites_on_shop_pages(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String plantype = givenAttributesMap.get("Plan Type");
		System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
	//	if (!(MRScenario.environment.equalsIgnoreCase("offline")
	//			|| MRScenario.environment.equalsIgnoreCase("prod") || MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.equalsIgnoreCase("team-acme"))) {
			
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		if (!plantype.equalsIgnoreCase("MS"))
			plansummaryPage.handlePlanYearSelectionPopup();
		}
	//}
	@Then("^user clicks on Learn About Medicare$")
	public void user_clicks_on_Learn_About_Medicare() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) aquisitionhomepage
				.openLearnAboutMedicarePage();

		getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePage);

	}

	@Then("^Validate user Land on MEDED Page and validate links$")
	public void validate_user_Land_on_MEDED_Page_and_validate_links() throws Throwable {

	}

	@Then("^Navigate back to previous window$")
	public void navigate_back_to_previous_window() throws Throwable {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String originalHandle = wd.getWindowHandle();
		    for(String handle : wd.getWindowHandles()) {
		        if (!handle.equals(originalHandle)) {
		            wd.switchTo().window(handle);
		            wd.close();
		        }
		    }
		    wd.switchTo().window(originalHandle);
	}

	@Then("^validate group plan marketting Bullets$")
	public void validate_group_plans_markettingBullets() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
				plansummaryPage.validateGroupPlanMArkettingBullets() ;
	}
}
