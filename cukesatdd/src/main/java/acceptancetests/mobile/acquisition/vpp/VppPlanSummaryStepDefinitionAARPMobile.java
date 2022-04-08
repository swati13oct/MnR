package acceptancetests.mobile.acquisition.vpp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

//import pages.acquisition.ulayer.keywordSearch;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.ComparePlansPageMobile;
import pages.mobile.acquisition.commonpages.KeywordSearchAARPMobile;
import pages.mobile.acquisition.commonpages.MultiCountyModalPageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;

import pages.mobile.acquisition.dce.ulayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;

/**
 * Functionality: VPP flow for AARP site
 */

public class VppPlanSummaryStepDefinitionAARPMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	//AppiumDriver wd;

	/**
	 * @toDo:user is on AARP medicare acquisition site landing page
	 */
	@Given("^the user is on the AARP medicare acquisition site landing page$")
	public void the_user_on_aarp_medicareplans_Site() {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}
	
	/**
	 * @toDo:Verify provider covered information is displayed on Plan
	 *              Summary page
	 */
/*	@Then("^Verify provider name is displayed on Plan Summary page Ulayer$")
	public void verify_provider_covered_ulayer(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		String planName = plannameAttributesMap.get("PlanName");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String providerFromRally = (String) getLoginScenario().getBean(VPPCommonConstants.SAVED_PROVIDER_RALLY);
		plansummaryPage.verifyproviderName(planName, providerFromRally);
	}
*/
	@Then("^the user validates the pharmacy drug cost on plan compare page for the selected plan$")
	public void verify_Pharmacy_drug_cost_PlanCompare(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		String planName = plannameAttributesMap.get("Plan Name");
		String networkType = plannameAttributesMap.get("NetworkType");
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		
		planComparePage.verifyAddedDrugPharmacyCompareCost(planName, networkType);

	}
	
	@Then("^the user validates the pharmacy drug cost on plan summary page for the selected plan$")
	public void verify_Pharmacy_drug_cost(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		String planName = plannameAttributesMap.get("Plan Name");
		String networkType = plannameAttributesMap.get("NetworkType");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
				plansummaryPage.verifyAddedDrugPharmacySummaryCost(planName, networkType );
	}
	
	@Then("^the user validates the pharmacy drug cost on plan details page for the selected plan$")
	public void verify_Pharmacy_drug_cost_PlanDetails(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		String planName = plannameAttributesMap.get("Plan Name");
		String networkType = plannameAttributesMap.get("NetworkType");
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		
		vppPlanDetailsPage.verifyAddedDrugPharmacyDetailsCost(planName, networkType);

	}
	
	 @Then("^the user selects pharmacy on Drug details page$")
	    public void the_user_selects_pharmacy_on_Drug_details_page(DataTable givenAttributes) throws InterruptedException {
	        DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
	        getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	        Map<String, String> memberAttributesMap = new HashMap<String, String>();
	        memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
	        String pharmacyZipCode = memberAttributesMap.get("PharmacyZipCode");
	        String distance = memberAttributesMap.get("Distance");
	        String pharmacyName = memberAttributesMap.get("PharmacyName");
	        drugDetailsPage.EnterPharmacyDetailsPage(pharmacyZipCode, distance, pharmacyName);
	        
	    }

//	/**
//	 * @throws InterruptedException
//	 * @toDo: user performs plan search using following information
//	 */
//	@When("^the user does plan search using the following information in the AARP site$")
//	public void zipcode_details_in_aarp_site(DataTable givenAttributes) throws InterruptedException {
//
//		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
//		Map<String, String> memberAttributesMap = new HashMap<String, String>();
//		for (int i = 0; i < memberAttributesRow.size(); i++) {
//
//			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
//					memberAttributesRow.get(i).getCells().get(1));
//		}
//
//		String zipcode = memberAttributesMap.get("Zip Code");
//		String county = memberAttributesMap.get("County Name");
//		String isMultiCounty = memberAttributesMap.get("Is Multi County");
//		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
//		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
//		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);
//
//		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
//				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		VPPPlanSummaryPageMobile plansummaryPage = null;
//		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
//			plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty(zipcode);
//		} else {
//			plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);
//		}
//
//		if (plansummaryPage != null) {
//			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
//
//		} else {
//			Assertion.fail("Error Loading VPP plan summary page");
//		}
//	}

	/**
	 * @toDo:user views the plans of the below plan type
	 */
	@And("^the user views plans of the below plan type in AARP site$")
	public void user_performs_planSearch_in_aarp_site(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		
		

		String plantype = givenAttributesMap.get("Plan Type");
		getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE, plantype);
		System.out.println("Select PlanType to view Plans for entered Zip " + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
	
	}

	List<String> allPlanNames = null;

	@When("^user clicks on Continue Enrollment button in AARP Site$")
	public void user_clicks_on_Continue_Enrollment_button_in_aarp_Site() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		allPlanNames = plansummaryPage.getAllPlanNames();
		plansummaryPage.clickContinueEnrollmentBtn();
	}

	@Then("^user saves plan as favorite on AARP site$")
	public void user_saves_plan_as_favorite_on_aarp_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		System.out.println("Plan name" + PlanName);
		plansummaryPage.savePlan(PlanName);
	}

	/**
	 * @throws InterruptedException 
	 * @toDo:user view plan details of the above selected plan in AARP site and
	 *            validates
	 */
	@Then("^the user view plan details of the above selected plan in AARP site and validate$")
	public void user_views_plandetails_selected_plan_aarp(DataTable givenAttributes) throws InterruptedException {
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName, planType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);

		PlanDetailsPageMobile vppPlanDetailsPageMobileMobile = vppPlanSummaryPage.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPageMobileMobile != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPageMobileMobile);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in Loading the Plan Details Page");

	}

	/**
	 * @throws InterruptedException
	 * @toDo:user validates add to compare checkbox on Plan Card
	 */
	@Then("^the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans$")
	public void user_validates_addtocompare_aarp() throws InterruptedException {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("SNP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.validateAndClickAddtoCompareinAARP(planType, planName);
			plansummaryPage.compareTextAfterclickingAddtoCompareinAARP(planName);
			plansummaryPage.deselectAddToCompareinAARP(planName);
		}
	}

	/**
	 * @toDo:user validates the available plans for selected plan types
	 */
	@Then("^the user validates available plans for selected plan types in the AARP site$")
	public void user_validates_available_plans_aarp() {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		int planCount = (int) getLoginScenario().getBean(VPPCommonConstants.PLAN_COUNT); 
		if (plansummaryPage.validatePlanNames(planType)) {
			String SiteName = "AARP_ACQ";
			getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Error validating availables plans for selected plantype in  VPP plan summary page");
		}
	}

	/**
	 * @throws InterruptedException
	 * @toDo:user validates plan summary for the below plan
	 */
	@And("^the user validates plan summary for the below plan in AARP site$")
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
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.pageloadcomplete();
		Assertion.assertTrue("Error loading specific plan summary in VPP plan summary page",
				planSummaryPage.getSpecificPlanInfo(planName));
	}
	// =================

	/*
	 * @Then("^the user view plan details of the above selected plan in AARP site vpp$"
	 * ) public void
	 * the_user_view_plan_details_of_the_above_selected_plan_in_UMS_site_vpp(
	 * DataTable givenAttributes) {
	 * 
	 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	 * String planName = memberAttributesRow.get(0).getCells().get(1); String
	 * planType = memberAttributesRow.get(1).getCells().get(1);
	 * getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
	 * VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile)
	 * getLoginScenario() .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	 * 
	 * PlanDetailsPageMobileMobile vppPlanDetailsPageMobileMobile =
	 * vppPlanSummaryPage.navigateToPlanDetails(planName, planType); if
	 * (vppPlanDetailsPageMobileMobile != null) {
	 * getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
	 * vppPlanDetailsPageMobileMobile); // if(vppPlanDetailsPageMobileMobile.validatePlanDetailsPageMobileMobile()){ //
	 * Assertion.assertTrue(true); // }else //
	 * Assertion.fail("Error in validating the Plan Details Page");
	 * 
	 * } }
	 */
	/*
	 * @Then("^the user clicks on both top and bottom back to plans link and validates its redirection AARP$"
	 * ) public void
	 * the_user_clicks_on_both_topand_bottom_back_to_plans_link_and_validates_its_redirection
	 * () throws InterruptedException { //
	 * getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, //
	 * vppPlanDetailsPageMobileMobile); PlanDetailsPageMobileMobile vppPlanDetailsPageMobileMobile = (PlanDetailsPageMobileMobile)
	 * getLoginScenario() .getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
	 * vppPlanDetailsPageMobileMobile.validatetopbacktoplanslink();
	 * vppPlanDetailsPageMobileMobile.browserBack();
	 * vppPlanDetailsPageMobileMobile.validatedownbacktoplanslink();
	 * 
	 * }
	 */

	/*
	 * @Then("^the user selects plans to add to plan compare and navigates to Plan compare page$"
	 * ) public void
	 * the_user_selects_plans_to_add_to_plan_compare_and_navigates_to_Plan_compare_page(
	 * DataTable planAttributes) throws Throwable {
	 * 
	 * List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
	 * Map<String, String> givenAttributesMap = new HashMap<String, String>(); for
	 * (int i = 0; i < givenAttributesRow.size(); i++) {
	 * 
	 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
	 * givenAttributesRow.get(i).getCells().get(1)); } String PlanName =
	 * givenAttributesMap.get("Plan Name"); // String PlanName = (String) //
	 * getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
	 * 
	 * String PlanYear = "2018"; String PlanPremium; String ZipCode = (String)
	 * getLoginScenario().getBean(VPPCommonConstants.ZIPCODE); String County =
	 * (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY); String
	 * PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	 * String TFN; String SiteName = "AARP_ACQ";
	 * 
	 * VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
	 * .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE); TFN =
	 * planSummaryPage.GetTFNforPlanType();
	 * 
	 * PlanPremium = planSummaryPage.getPlanPremium(PlanName);
	 * getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
	 * getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
	 * getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
	 * getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
	 * getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
	 * getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
	 * getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM,
	 * PlanPremium); getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
	 * System.out.println("Plan Name is : " + PlanName);
	 * System.out.println("Plan Type is : " + PlanType);
	 * System.out.println("Plan Zip Code is : " + ZipCode);
	 * System.out.println("Plan County Name is : " + County);
	 * System.out.println("Plan Plan Premium is : " + PlanPremium);
	 * System.out.println("TFN for Plan Type is : " + TFN);
	 * System.out.println("Plan Year is : " + PlanYear);
	 * System.out.println("OLE is being started from Acquisition Site : " +
	 * SiteName);
	 * 
	 * ComparePlansPage comparePlansPage =
	 * planSummaryPage.selectplantocompare(PlanType); if (comparePlansPage != null)
	 * { getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE,
	 * comparePlansPage); Assertion.assertTrue(true); } else
	 * Assertion.fail("Error in Loading the Plan Compare Page"); }
	 * 
	 * @Then("^the user validate the print and email links on the plan Details Page$"
	 * ) public void user_validate_print_and_email_links_on_the_plan_Details_Page()
	 * {
	 * 
	 * PlanDetailsPageMobileMobile vppPlanDetailsPageMobileMobile = (PlanDetailsPageMobileMobile) getLoginScenario()
	 * .getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
	 * vppPlanDetailsPageMobileMobile.validatePrintandEmailOnPlanDetails(); }
	 */

	/**
	 * @toDo:the user validates the functionality of email and print buttons on the
	 *           plan Details Page
	 */
	/*
	 * @Then("^the user validates the functionality of email and print buttons on the plan Details Page$"
	 * ) public void
	 * user_validates_the_functionality_of_emailandprintbuttons_on_the_plan_Details_Page
	 * () {
	 * 
	 * PlanDetailsPageMobileMobile vppPlanDetailsPageMobileMobile = (PlanDetailsPageMobileMobile) getLoginScenario()
	 * .getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
	 * vppPlanDetailsPageMobileMobile.validatingFunctionalityOfPrintandEmailOnPlanDetails();
	 * 
	 * }
	 * 
	 * @When("^the user performs zipcode search using widget following information in the AARP site$"
	 * ) public void
	 * the_user_performs_zipcode_search_using_widget_following_information_in_the_AARP_site(
	 * DataTable givenAttributes) throws Throwable { List<DataTableRow>
	 * memberAttributesRow = givenAttributes.getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String zipcode = memberAttributesMap.get("Zip Code"); String county =
	 * memberAttributesMap.get("County Name");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	 * 
	 * AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
	 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
	 * 
	 * VPPPlanSummaryPageMobile plansummaryPage =
	 * aquisitionhomepage.ZipcodeSearch(zipcode);
	 * 
	 * if (plansummaryPage != null) {
	 * getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
	 * plansummaryPage); } else {
	 * Assertion.fail("Error Loading VPP plan summary page"); } }
	 * 
	 * @When("^the user performs zipcode search to welcome OLE Page using widget on the AARP site$"
	 * ) public void
	 * the_user_performs_zipcode_search_to_welcome_OLE_Page_using_widget_on_the_AARP_site(
	 * DataTable givenAttributes) throws Throwable { List<DataTableRow>
	 * memberAttributesRow = givenAttributes.getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String zipcode = memberAttributesMap.get("Zip Code"); String county =
	 * memberAttributesMap.get("County Name");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	 * 
	 * AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
	 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
	 * 
	 * WelcomePage welcomeOLEPage = aquisitionhomepage.ZipcodeSearchToOLE(zipcode);
	 * 
	 * if (welcomeOLEPage != null) {
	 * getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
	 * } else { Assertion.fail("Error Loading Welcome Page for OLE"); } }
	 * 
	 * @When("^the user goes to MA Landing and performs zipcode search using widget following information in the AARP site$"
	 * ) public void
	 * the_user_goes_to_MA_Landing_and_performs_zipcode_search_using_widget_following_information_in_the_AARP_site(
	 * DataTable givenAttributes) throws Throwable { List<DataTableRow>
	 * memberAttributesRow = givenAttributes.getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String zipcode = memberAttributesMap.get("Zip Code"); String county =
	 * memberAttributesMap.get("County Name");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	 * 
	 * AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
	 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
	 * 
	 * aquisitionhomepage.OurPlanMALanding(); VPPPlanSummaryPageMobile plansummaryPage =
	 * aquisitionhomepage.ZipcodeSearch(zipcode);
	 * 
	 * if (plansummaryPage != null) {
	 * getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
	 * plansummaryPage); } else {
	 * Assertion.fail("Error Loading VPP plan summary page"); } }
	 * 
	 * @When("^the user goes to PDP Landing and performs zipcode search using widget following information in the AARP site$"
	 * ) public void
	 * the_user_goes_to_PDP_Landing_and_performs_zipcode_search_using_widget_following_information_in_the_AARP_site(
	 * DataTable givenAttributes) throws Throwable { List<DataTableRow>
	 * memberAttributesRow = givenAttributes.getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String zipcode = memberAttributesMap.get("Zip Code"); String county =
	 * memberAttributesMap.get("County Name");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	 * 
	 * AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
	 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
	 * 
	 * aquisitionhomepage.OurPlansPDPLanding(); VPPPlanSummaryPageMobile plansummaryPage =
	 * aquisitionhomepage.ZipcodeSearch(zipcode);
	 * 
	 * if (plansummaryPage != null) {
	 * getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
	 * plansummaryPage); } else {
	 * Assertion.fail("Error Loading VPP plan summary page"); } }
	 * 
	 * @When("^the user goes to MA Landing and performs zipcode search using widget to welcome OLE Page using widget on the AARP site$"
	 * ) public void
	 * the_user_goes_to_MA_Landing_and_performs_zipcode_search_using_widget_to_welcome_OLE_Page_using_widget_on_the_AARP_site(
	 * DataTable givenAttributes) throws Throwable { List<DataTableRow>
	 * memberAttributesRow = givenAttributes.getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String zipcode = memberAttributesMap.get("Zip Code"); String county =
	 * memberAttributesMap.get("County Name");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	 * 
	 * AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
	 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
	 * aquisitionhomepage.OurPlanMALanding(); WelcomePage welcomeOLEPage =
	 * aquisitionhomepage.ZipcodeSearchToOLE(zipcode);
	 * 
	 * if (welcomeOLEPage != null) {
	 * getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
	 * } else { Assertion.fail("Error Loading OLE Welcome page"); } }
	 * 
	 * @When("^the user goes to MA selects Special Need Plans and performs zipcode search using widget to welcome OLE Page using widget on the AARP site$"
	 * ) public void
	 * the_user_goes_to_MA_selects_Special_Need_Plans_and_performs_zipcode_search_using_widget_to_welcome_OLE_Page_using_widget_on_the_AARP_site(
	 * DataTable givenAttributes) throws Throwable { List<DataTableRow>
	 * memberAttributesRow = givenAttributes.getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String zipcode = memberAttributesMap.get("Zip Code"); String county =
	 * memberAttributesMap.get("County Name");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	 * 
	 * AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
	 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE); WelcomePage
	 * welcomeOLEPage =
	 * aquisitionhomepage.SpecialNeedPlansZipcodeSearchToOLE(zipcode);
	 * 
	 * if (welcomeOLEPage != null) {
	 * getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
	 * } else { Assertion.fail("Error Loading OLE Welcome page"); } }
	 * 
	 * @When("^the user goes to PDP Landing and performs zipcode search using widget to welcome OLE Page using widget on the AARP site$"
	 * ) public void
	 * the_user_goes_to_PDP_Landing_and_performs_zipcode_search_using_widget_to_welcome_OLE_Page_using_widget_on_the_AARP_site(
	 * DataTable givenAttributes) throws Throwable { List<DataTableRow>
	 * memberAttributesRow = givenAttributes.getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String zipcode = memberAttributesMap.get("Zip Code"); String county =
	 * memberAttributesMap.get("County Name");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	 * 
	 * AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
	 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
	 * aquisitionhomepage.OurPlansPDPLanding(); WelcomePage welcomeOLEPage =
	 * aquisitionhomepage.ZipcodeSearchToOLE(zipcode);
	 * 
	 * if (welcomeOLEPage != null) {
	 * getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
	 * } else { Assertion.fail("Error Loading OLE Welcome page"); } }
	 */
	/*
	 * @Then("^the user validates the following Plan details for the plan$") public
	 * void the_user_validates_the_following_Plan_details_for_the_plan(DataTable
	 * givenAttributes) throws Throwable { List<DataTableRow> memberAttributesRow =
	 * givenAttributes.getGherkinRows(); Map<String, String> memberAttributesMap =
	 * new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String benefitType = memberAttributesMap.get("Benefit Type"); String
	 * expectedText = memberAttributesMap.get("Expected Text");
	 * System.out.println("Validating the following Additional benefits : "
	 * +benefitType);
	 * 
	 * PlanDetailsPageMobileMobile vppPlanDetailsPageMobileMobile = (PlanDetailsPageMobileMobile) getLoginScenario()
	 * .getBean(PageConstants.VPP_PLAN_DETAILS_PAGE); boolean validationFlag =
	 * vppPlanDetailsPageMobileMobile.validatingAdditionalBenefitTextInPlanDetails(benefitType,
	 * expectedText); Assertion.
	 * assertTrue("Validation failed : Expected text not displayed for Additional Benefit - "
	 * +benefitType,validationFlag);
	 * 
	 * if (welcomeOLEPage != null) {
	 * getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
	 * } else { Assertion.fail("Error Loading OLE Welcome page"); } }
	 */
	// Steps added to validate Cancel button on Multi County pop-up on Home, SubNav
	// and VPP plan search
	/*
	 * @When("^the user performs plan search using following MultiCounty Zip information in the AARP site$"
	 * ) public void
	 * the_user_performs_plan_search_using_following_MultiCounty_Zip_information_in_the_AARP_site
	 * (DataTable givenAttributes) throws Throwable { List<DataTableRow>
	 * memberAttributesRow = givenAttributes .getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells() .get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String zipcode = memberAttributesMap.get("Zip Code");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * 
	 * AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
	 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
	 * MultiCountyModalPage multiCountyModalPage =
	 * aquisitionhomepage.ValidateMultiCOuntyPopUp( zipcode);
	 * 
	 * if (multiCountyModalPage != null) {
	 * getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
	 * multiCountyModalPage); } else {
	 * Assertion.fail("Error Loading VPP plan summary page"); }
	 * 
	 * } // Steps added to validate Cancel button on Multi County pop-up on Home,
	 * SubNav and VPP plan search
	 * 
	 * @Then("^the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page$"
	 * ) public void
	 * the_user_validates_the_Cancel_button_for_Multi_COunty_Pop_up_lands_on_enter_Zip_code_Page
	 * () throws Throwable { MultiCountyModalPage multiCountyModalPage =
	 * (MultiCountyModalPage) getLoginScenario()
	 * .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE); boolean Validation_Flag =
	 * multiCountyModalPage.validateMultiCounty_CancelButton(); Assertion.
	 * assertTrue("Validation failed : Cancel button Validation for Multi County Pop-up Failed "
	 * ,Validation_Flag);
	 * 
	 * } // Steps added to validate Cancel button on Multi County pop-up on Home,
	 * SubNav and VPP plan search
	 * 
	 * @When("^the user performs plan search using following MultiCounty Zip in Header Sun Nav in the AARP site$"
	 * ) public void
	 * the_user_performs_plan_search_using_following_MultiCounty_Zip_in_Header_Sun_Nav_in_the_AARP_site
	 * (DataTable givenAttributes) throws Throwable { List<DataTableRow>
	 * memberAttributesRow = givenAttributes .getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells() .get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String zipcode = memberAttributesMap.get("Zip Code");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * 
	 * AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
	 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
	 * MultiCountyModalPage multiCountyModalPage =
	 * aquisitionhomepage.SubNav_ValidateMultiCOuntyPopUp( zipcode);
	 * 
	 * if (multiCountyModalPage != null) {
	 * getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
	 * multiCountyModalPage); } else {
	 * Assertion.fail("Error Loading VPP plan summary page"); } }
	 */
	// Steps added to validate Cancel button on Multi County pop-up on Home, SubNav
	// and VPP plan search

	/*
	 * @When("^the user performs Change Location on Plan Summary Page using following MultiCounty Zip information in the AARP site$"
	 * ) public void
	 * the_user_performs_Change_Location_on_Plan_Summary_Page_using_following_MultiCounty_Zip_information_in_the_AARP_site
	 * (DataTable givenAttributes) throws Throwable { List<DataTableRow>
	 * memberAttributesRow = givenAttributes .getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells() .get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String zipcode = memberAttributesMap.get("Zip Code");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
	 * .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE); MultiCountyModalPage
	 * multiCountyModalPage =
	 * plansummaryPage.VPP_ChangeLocationValidateMultiCOuntyPopUp( zipcode);
	 * 
	 * if (multiCountyModalPage != null) {
	 * getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
	 * multiCountyModalPage); } else {
	 * Assertion.fail("Error Loading VPP plan summary page"); } }
	 */

	@Then("^the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site")
	public void User_clicks_BackToPlansLink_and_validates_redirection_in_AARP_site() {

		PlanDetailsPageMobile planDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPageFromDetailsPage();
		// VPPPlanSummaryPageMobile plansummaryPage =
		// planDetailsPage.navigateBackToPlanSummaryPage();

		// VPPPlanSummaryPageMobile plansummaryPage =
		// planDetailsPage.navigateBackToPlanSummaryPage();

		if (plansummaryPage != null) {
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the Plan Summary Page");
	}

	@Then("^the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site$")
	public void User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_aarp() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("MA")) {
		DrugCostEstimatorPageMobile drugCostEstimatorPage = (DrugCostEstimatorPageMobile) getLoginScenario()
					.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
			drugCostEstimatorPage.navigateBackToPlanSummaryPage();

		}
	}

	/*
	 * @When("^the user goes to PDP Landing and performs zipcode search using widget to welcome OLE Page using widget on the AARP site$"
	 * ) public void
	 * the_user_goes_to_PDP_Landing_and_performs_zipcode_search_using_widget_to_welcome_OLE_Page_using_widget_on_the_AARP_site(
	 * DataTable givenAttributes) throws Throwable { List<DataTableRow>
	 * memberAttributesRow = givenAttributes.getGherkinRows(); Map<String, String>
	 * memberAttributesMap = new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String zipcode = memberAttributesMap.get("Zip Code"); String county =
	 * memberAttributesMap.get("County Name");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	 * 
	 * AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
	 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
	 * aquisitionhomepage.OurPlansPDPLanding(); WelcomePage welcomeOLEPage =
	 * aquisitionhomepage.ZipcodeSearchToOLE(zipcode);
	 * 
	 * if (welcomeOLEPage != null) {
	 * getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
	 * } else { Assertion.fail("Error Loading OLE Welcome page"); } }
	 * 
	 * @Then("^the user validates the following Plan details for the plan$") public
	 * void the_user_validates_the_following_Plan_details_for_the_plan(DataTable
	 * givenAttributes) throws Throwable { List<DataTableRow> memberAttributesRow =
	 * givenAttributes.getGherkinRows(); Map<String, String> memberAttributesMap =
	 * new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * 
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); }
	 * 
	 * String benefitType = memberAttributesMap.get("Benefit Type"); String
	 * expectedText = memberAttributesMap.get("Expected Text");
	 * System.out.println("Validating the following Additional benefits : "
	 * +benefitType);
	 * 
	 * PlanDetailsPageMobileMobile vppPlanDetailsPageMobileMobile = (PlanDetailsPageMobileMobile) getLoginScenario()
	 * .getBean(PageConstants.VPP_PLAN_DETAILS_PAGE); boolean validationFlag =
	 * vppPlanDetailsPageMobileMobile.validatingAdditionalBenefitTextInPlanDetails(benefitType,
	 * expectedText); Assertion.
	 * assertTrue("Validation failed : Expected text not displayed for Additional Benefit - "
	 * +benefitType,validationFlag);
	 * 
	 * }
	 */
	@Then("^the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site$")
	public void the_user_clicks_enterDrugInformation_validates_dceHomePage_AARP() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("MA")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			pages.mobile.acquisition.dce.ulayer.DrugCostEstimatorPageMobile drugCostEstimatorPage = plansummaryPage.navigateToDCE(planName);
			if (drugCostEstimatorPage != null) {
				getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, drugCostEstimatorPage);

			} else {
				Assertion.fail("Error Loading DCE page");
			}

		}
	}

	@Then("^the user validates Add to compare checkbox is not present for DSNP Plans in AARP$")
	public void addToCompareNotPresentForDSNP() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (planType.equals("SNP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.validateAddToCompareNotPresentForDSNP(planName);
		}
	}

	@Then("^the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site$")
	public void user_validatesPopup_learnMoreAboutExtraHelp_aarp() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("MA")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			// String planName = (String)
			// getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.validatesLearnMoreAboutExtraHelpPopup();
		}
	}
	
	@Then("^user clicks on view plan details button and validates plan name start application button and benefit link$")
	public void user_clicks_on_view_plan_details_button_and_validates_plan_name_start_application_button_and_benefit_link()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		boolean result = plansummaryPage.validateFieldsOnPlanDetails();
		Assertion.assertTrue("plan name start application button and benefit link are validated", result);
		System.out.println("plan name start application button and benefit link are validated");

	}
	
	@And("^user clicks on compare button and navigate to plan compare page for \"([^\"]*)\" time$")
	public void user_clicks_on_compare_button_and_navigate_to_plan_compare_page(String attempt,
			DataTable givenAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 *
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */

		String totalPlans = givenAttributesMap.get("No Of Plans To Compare");
		int total_plans = Integer.parseInt(totalPlans);

		String navigateToCompare = givenAttributesMap.get("Navigate To Compare");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		boolean result = plansummaryPage.clickAndVerifyNavigateToPage("Compare", total_plans, attempt,
				navigateToCompare);
		Assertion.assertTrue("On clicking compare button user is navigated to plan compare page", result);
		System.out.println("user clicks on compare button and navigate to plan compare page");

	}
	
	@And("^user clicks on save button and saves to plan cart for \"([^\"]*)\" time$")
	public void user_clicks_on_save_button_and_saves_to_plan_cart(String attempt, DataTable givenAttributes)
			throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 *
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */

		String totalPlans = givenAttributesMap.get("No Of Plans To Compare");
		int total_plans = Integer.parseInt(totalPlans);

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean result = plansummaryPage.clickAndVerifyNavigateToPage("Save", total_plans, attempt, "Yes");
		Assertion.assertTrue("On clicking save button user is navigated to save plan page", result);
		System.out.println("user clicks on save button and saves to plan cart");

	}
	
	@Then("^user clicks on View plan button link and navigate back to vpp summary page of medsupp$")
	public void user_clicks_on_View_plan_button_link_and_navigate_back_to_vpp_summary_page_of_medsupp()
			throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean result = plansummaryPage.clickAndVerifyNavigateToPage("View Plan", 1, "first", "Yes");
		Assertion.assertTrue("On clicking View Plan button user is navigated to plan summary page", result);
		System.out.println("user clicks on View plan button link and navigate back to vpp summary page of medsupp");
	}
	
	@Then("^user clicks on Save icon for all the plans and validate count in cart should match to plans$")
	public void user_clicks_on_Save_icon_for_all_the_plans_and_match_count(DataTable givenAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 *
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */

		String noOfPlansSavedOnComparePage = givenAttributesMap.get("No Of Saved Plans On Compare Page");
		int savedPlanCountOfComparePage = Integer.parseInt(noOfPlansSavedOnComparePage);

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean result = plansummaryPage.verifyPlanCount(savedPlanCountOfComparePage);
		Assertion.assertTrue("Plan count is matched", result);
		System.out.println("Plan count is matched");
	}
	
	@And("^user clicks on view saved plans land on shopper profile page$")
	public void user_clicks_on_view_saved_plans_land_on_shopper_profile_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		boolean result = plansummaryPage.clickOnSavedPlansAndNavigateToShopperProfile();
		Assertion.assertTrue("user land on shopper profile page", result);
		System.out.println("user land on shopper profile page");

	}

	@Then("^the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site$")
	public void user_validatesAndClickslearnMoreAboutExtraHelp_aarp() throws InterruptedException {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		plansummaryPage.validateAndClickLearnMoreAboutExtraHelpInAARP(planType, planName);
	}

	@Then("^the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans$")
	public void user_validates_IsMyProviderCoveredLink_aarp() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("PDP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.clickOnViewMoreForPlan(planName);
			plansummaryPage.validateIsMyProviderCoveredLinkInAarp(planType, planName);
		}
	}

	@Then("^the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans$")
	public void user_clicks_IsMyProviderCoveredLink_aarp() throws InterruptedException {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("PDP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.ValidateclicksOnIsProviderCovered(planName);
		}
	}

	@Then("^the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page")
	public void user_clicks_enrollInPlan_validates_welcomeOLE() throws InterruptedException {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		WelcomePageMobile welcomeOLEPage = plansummaryPage.Enroll_OLE_Plan(planName, planType);
		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assertion.fail("Error Loading Welcome Page for OLE");
		}
	}

	@Then("^the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans$")
	public void user_validates_planBenefitValues_inAARP(DataTable givenAttributes) {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (!planType.equals("PDP")) {
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
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.clickOnViewMoreForPlan(planName);
			plansummaryPage.validatePlanPremium(planName, monthlyPremium);
			plansummaryPage.validatePrimaryCarePhysicianBenefit(planType, planName, primaryCarePhysician);
			plansummaryPage.validateSpecialistBenefit(planType, planName, specialist);
			plansummaryPage.validateReferrralRequiredBenefit(planName, referralRequired);
			plansummaryPage.validatesOutOfPocketMaximum(planName, outOfPocketMaximum);
			plansummaryPage.validatePrescriptionDrugsTier1(planName, planType, prescriptionDrugsTier1);
		} else
			System.out.println("Benefits are not applicable for PDP Plans");
	}

	@Then("^the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans$")
	public void user_validates_planBenefitValues_PDP_AARP(DataTable givenAttributes) {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (planType.equals("PDP")) {
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
			/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}*/
			String monthlyPremium = memberAttributesMap.get("Monthly Premium");
			String annualDeductible = memberAttributesMap.get("Annual Deductible");
			String prescriptionDrugsTier1 = memberAttributesMap.get("Prescription Drugs, Tier 1");
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.validatePlanPremium(planName, monthlyPremium);
			plansummaryPage.validateAnnualDeductible(planName, annualDeductible);
			plansummaryPage.validatePrescriptionDrugsTier1(planName, planType, prescriptionDrugsTier1);
		} else
			System.out.println("Benefits are not applicable for MA, MAPD and DSNP Plans");
	}

	@Then("^the user validates marketing bullets of the plan in AARP site$")
	public void validate_marketingBullets() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		plansummaryPage.validateMarketingBullets(planType, planName);
	}

	@Then("^the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site$")
	public void toolTip_premium0_validateText_inAARP() throws Throwable {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (planType.equals("MA") || planType.equals("MAPD")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.toolTipForPremium0(planName);
		}
	}

	@Then("^the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site$")
	public void toolTip_annualDeductible_inAARP() throws Throwable {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (planType.equals("PDP")) {
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
			plansummaryPage.toolTipForAnnualDeductible(planName);
		}
	}



	@Then("^the user validates the Need Help Section in the right rail$")
	public void validate_needHelp_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateNeedHelpRightRail();
	}

	@Then("^the user validates the TFN in the Need Help Section$")
	public void validate_TFN_inRIghtRail_aarp() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.GetTFNforPlanType();
	}

	@Then("^the user validates and clicks on Find an agent$")
	public void validateAndClick_findAgentInYourArea_RightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateAgentEBRCPage();
	}

	@Then("^the user validates Get a free medicare Guide section in the right rail$")
	public void validate_freeMedicareGuide_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateMedicareGuideRightRail();
	}

	@Then("^the user enters the following information in the Get a free medicare Guide section$")
	public void user_enters_necessaryInformation_inGetFreeMedicareGuideSection(DataTable givenAttributes)
			throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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

	@Then("^the user validates Need More Information section in the right rail$")
	public void validate_needMoreInformation_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateNeedMoreInformationRightRail();
	}

	@Then("^the user validates Medicare Plans Video Guide Page after clicking Choose a video link$")
	public void validate_andClick_ChooseAVideo() throws InterruptedException {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateMedicareVideoGuideRightRail();
	}

	@Then("^the user validates Plan Selector Tool section in the right rail$")
	public void validate_planSelectorTool_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validatePlanSelectorToolRightRail();
	}

	@Then("^the user validates Plan Selector Page after clicking on Start Plan Selector button$")
	public void user_validate_planSelectorPage_inaarpSite() throws Exception {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validatePlanSelectorPageInRightRail();
	}

	/**
	 * @toDo:user is on AARP medicare acquisition site landing page
	 */
	@Given("^the potential user is on AARP medicare acquisition site landing page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^the member validates the search engine$")
	public void I_validate_search_box() throws InterruptedException {

		AcquisitionHomePageMobile acquisitionHomePage = (AcquisitionHomePageMobile) loginScenario
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acquisitionHomePage.searchfield();
		KeywordSearchAARPMobile newkeywordsearchpage = new KeywordSearchAARPMobile(acquisitionHomePage.driver);
		getLoginScenario().saveBean(PageConstants.Keyword_Search, newkeywordsearchpage);
	}

	@Then("^the member lands on the result pag$")
	public void I_land_on_result_page() {
		{

			KeywordSearchAARPMobile newkeywordsearchpage = (KeywordSearchAARPMobile) loginScenario
					.getBean(PageConstants.Keyword_Search);
			newkeywordsearchpage.url();
			if (newkeywordsearchpage != null)
				getLoginScenario().saveBean(PageConstants.Keyword_Search, newkeywordsearchpage);

		}

	}

	@Then("^the user clicks on Learn More AARP for Rocky Mountain plans$")
	public void the_user_clicks_on_Learn_More_for_AARP_for_Rocky_Mountain_plans(DataTable planAttributes)
			throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.RockyLearnMoreButtonandValidate(planName);
	}

	@Then("^the user clicks on Learn More AARP for people Health plans$")
	public void the_user_clicks_on_Learn_More_for_AARP_for_people_Health_plans(DataTable planAttributes)
			throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		planSummaryPage.peopleLearnMoreButtonandValidate(planName);
	}

	@Then("^user should be able to see the Select Plan for Enroll Modal with saved plans in AARP site$")
	public void user_should_be_able_to_see_Select_Plan_for_Enroll_Modal_with_Saved_plans_in_aarp_site(
			DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		System.out.println("Plan name" + PlanName);
		plansummaryPage.verifySelectPlanForEnrollModalForSavedPlans(PlanName);
	}

	@Then("^user should be able to see the Select Plan for Enroll Modal with all plans in AARP site$")
	public void user_should_be_able_to_see_the_Select_Plan_for_Enroll_Modal_with_all_plans_in_aarp_site(DataTable arg1)
			throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifySelectPlanForEnrollModalForAllPlans(allPlanNames);
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

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.enterAddressDetails(address, city, state);
	}
	
	@When("^verify Call SAM icon is visible$")
	public void verify_Call_SAM_icon_is_visible() throws InterruptedException {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
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
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		MultiCountyModalPageMobile multiCountyModalPage = plansummaryPage.VPP_ChangeLocationValidateMultiCOuntyPopUp(zipcode);

		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, multiCountyModalPage);
		} else {
			Assertion.fail("Error Loading VPP plan summary page");
		}

	}

	@When("^the user clicks on Find plans on vpp using following information$")
	public void the_user_clicks_on_Find_plans_on_vpp_using_following_information(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		
		getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		
		String county2 = memberAttributesMap.get("County Name2");
		String isMultiCounty2 = memberAttributesMap.get("Is Multi County2");
		

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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
	
	@And("^user clicks on heart icon and save two heart icon plans$")
	public void user_clicks_on_heart_icon_and_save_two_heart_icon_plans(DataTable givenAttributes) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 *
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */

		String planCount = memberAttributesMap.get("No Of Plans To Save");
		int number = Integer.parseInt(planCount);

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		boolean result = plansummaryPage.savePlansOnSummaryPage(number);
		Assertion.assertTrue("user saved two heart icon plans", result);
		System.out.println("user saved two heart icon plans");

	}	
	
	@Then("^the user validates the right rail$")
	public void user_validates_rightRail() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateRightRailSection();
	}

}
