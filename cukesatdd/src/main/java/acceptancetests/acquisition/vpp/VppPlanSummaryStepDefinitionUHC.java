package acceptancetests.acquisition.vpp;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

//import pages.acquisition.dce.ulayer.DrugCostEstimatorPage;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.KeywordSearch;
import pages.acquisition.ulayer.ComparePlansPage;
import pages.acquisition.ulayer.MultiCountyModalPage;
import pages.acquisition.ulayer.OurPlansPage;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.ulayer.ProviderSearchPage;
import pages.acquisition.ulayer.keywordSearchAARP;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
//import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality: VPP flow for AARP site
 */

public class VppPlanSummaryStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo:user is on UMS medicare acquisition site landing page
	 */
	@Given("^the user is on uhcmedicaresolutions site landing page$")
	public void the_user_on_uhc_medicareplans_Site() {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user does plan search using the following information in UMS site$")
	public void zipcode_details_in_UMS_site(DataTable givenAttributes) {

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

	
	/**
	 * @toDo:user views the plans of the below plan type
	 */
	@And("^the user views plans of the below plan type in UMS site$")
	public void user_performs_planSearch_in_ums_site(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		System.out.println("Select PlanType to view Plans for entered Zip " + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		}

	
     /**
	 * @toDo:user view plan details of the above selected plan in AARP site and
	 *            validates
	 */
	@Then("^the user view plan details of the above selected plan in UMS site and validate$")
	public void user_views_plandetails_selected_plan_ums(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		/*String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);*/
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Details Page");

	}
	/**
	 * @throws InterruptedException 
	 * @toDo:user validates add to compare checkbox on Plan Card
	 */
	@Then("^the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans$")
	 public void user_validates_addtocompare_ums() throws InterruptedException {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if(!planType.equals("SNP")){
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		plansummaryPage.validateAndClickAddtoCompareinUMS(planType, planName);	
		plansummaryPage.compareTextAfterclickingAddtoCompareinUMS(planName);
		plansummaryPage.deselectAddToCompareinAARP(planName);
	}
	}
	/**
	 * @toDo:user validates the available plans for selected plan types
	 */
	/*@And("^the user validates available plans for selected plan types in the UMS site$")
	public void user_validates_available_plans_ums() {

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
*/
	/**
	 * @throws InterruptedException
	 * @toDo:user validates plan summary for the below plan
	 */
	@And("^the user validates plan summary for the below plan in UMS site$")
	public void user_validates_plan_summary_ums(DataTable planAttributes) throws InterruptedException {
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
	// =================
	
	

	/*@Then("^the user view plan details of the above selected plan in AARP site vpp$")
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
*/
	/*@Then("^the user clicks on both top and bottom back to plans link and validates its redirection AARP$")
	public void the_user_clicks_on_both_topand_bottom_back_to_plans_link_and_validates_its_redirection()
			throws InterruptedException {
		// getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
		// vppPlanDetailsPage);
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatetopbacktoplanslink();
		vppPlanDetailsPage.browserBack();
		vppPlanDetailsPage.validatedownbacktoplanslink();

	}*/

	/*@Then("^the user selects plans to add to plan compare and navigates to Plan compare page$")
	public void the_user_selects_plans_to_add_to_plan_compare_and_navigates_to_Plan_compare_page(
			DataTable planAttributes) throws Throwable {

		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PlanName = givenAttributesMap.get("Plan Name");
		// String PlanName = (String)
		// getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);

		String PlanYear = "2018";
		String PlanPremium;
		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String TFN;
		String SiteName = "AARP_ACQ";

		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		TFN = planSummaryPage.GetTFNforPlanType();

		PlanPremium = planSummaryPage.getPlanPremium(PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : " + PlanName);
		System.out.println("Plan Type is : " + PlanType);
		System.out.println("Plan Zip Code is : " + ZipCode);
		System.out.println("Plan County Name is : " + County);
		System.out.println("Plan Plan Premium is : " + PlanPremium);
		System.out.println("TFN for Plan Type is : " + TFN);
		System.out.println("Plan Year is : " + PlanYear);
		System.out.println("OLE is being started from Acquisition Site : " + SiteName);

		ComparePlansPage comparePlansPage = planSummaryPage.selectplantocompare(PlanType);
		if (comparePlansPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, comparePlansPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Compare Page");
	}

	@Then("^the user validate the print and email links on the plan Details Page$")
	public void user_validate_print_and_email_links_on_the_plan_Details_Page() {

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatePrintandEmailOnPlanDetails();
	}*/

	/**
	 * @toDo:the user validates the functionality of email and print buttons on
	 *           the plan Details Page
	 */
	/*@Then("^the user validates the functionality of email and print buttons on the plan Details Page$")
	public void user_validates_the_functionality_of_emailandprintbuttons_on_the_plan_Details_Page() {

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatingFunctionalityOfPrintandEmailOnPlanDetails();

	}

	@When("^the user performs zipcode search using widget following information in the AARP site$")
	public void the_user_performs_zipcode_search_using_widget_following_information_in_the_AARP_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.ZipcodeSearch(zipcode);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	@When("^the user performs zipcode search to welcome OLE Page using widget on the AARP site$")
	public void the_user_performs_zipcode_search_to_welcome_OLE_Page_using_widget_on_the_AARP_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		WelcomePage welcomeOLEPage = aquisitionhomepage.ZipcodeSearchToOLE(zipcode);

		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assert.fail("Error Loading Welcome Page for OLE");
		}
	}

	@When("^the user goes to MA Landing and performs zipcode search using widget following information in the AARP site$")
	public void the_user_goes_to_MA_Landing_and_performs_zipcode_search_using_widget_following_information_in_the_AARP_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		aquisitionhomepage.OurPlanMALanding();
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.ZipcodeSearch(zipcode);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	@When("^the user goes to PDP Landing and performs zipcode search using widget following information in the AARP site$")
	public void the_user_goes_to_PDP_Landing_and_performs_zipcode_search_using_widget_following_information_in_the_AARP_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		aquisitionhomepage.OurPlansPDPLanding();
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.ZipcodeSearch(zipcode);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	@When("^the user goes to MA Landing and performs zipcode search using widget to welcome OLE Page using widget on the AARP site$")
	public void the_user_goes_to_MA_Landing_and_performs_zipcode_search_using_widget_to_welcome_OLE_Page_using_widget_on_the_AARP_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.OurPlanMALanding();
		WelcomePage welcomeOLEPage = aquisitionhomepage.ZipcodeSearchToOLE(zipcode);

		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assert.fail("Error Loading OLE Welcome page");
		}
	}

	@When("^the user goes to MA selects Special Need Plans and performs zipcode search using widget to welcome OLE Page using widget on the AARP site$")
	public void the_user_goes_to_MA_selects_Special_Need_Plans_and_performs_zipcode_search_using_widget_to_welcome_OLE_Page_using_widget_on_the_AARP_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		WelcomePage welcomeOLEPage = aquisitionhomepage.SpecialNeedPlansZipcodeSearchToOLE(zipcode);

		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assert.fail("Error Loading OLE Welcome page");
		}
	}

	@When("^the user goes to PDP Landing and performs zipcode search using widget to welcome OLE Page using widget on the AARP site$")
	public void the_user_goes_to_PDP_Landing_and_performs_zipcode_search_using_widget_to_welcome_OLE_Page_using_widget_on_the_AARP_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.OurPlansPDPLanding();
		WelcomePage welcomeOLEPage = aquisitionhomepage.ZipcodeSearchToOLE(zipcode);

		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assert.fail("Error Loading OLE Welcome page");
		}
	}
	*/
	/*@Then("^the user validates the following Plan details for the plan$")
	public void the_user_validates_the_following_Plan_details_for_the_plan(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String benefitType = memberAttributesMap.get("Benefit Type");
		String expectedText = memberAttributesMap.get("Expected Text");
		System.out.println("Validating the following Additional benefits : "+benefitType);
		
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(benefitType, expectedText);
		Assert.assertTrue("Validation failed : Expected text not displayed for Additional Benefit - "+benefitType,validationFlag);
	
			if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assert.fail("Error Loading OLE Welcome page");
		}
	}	*/
	// Steps added to validate Cancel button on Multi County pop-up on Home, SubNav and VPP plan search
	/*@When("^the user performs plan search using following MultiCounty Zip information in the AARP site$")
	public void the_user_performs_plan_search_using_following_MultiCounty_Zip_information_in_the_AARP_site(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MultiCountyModalPage multiCountyModalPage = aquisitionhomepage.ValidateMultiCOuntyPopUp(
				zipcode);

		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					multiCountyModalPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}

	}
	// Steps added to validate Cancel button on Multi County pop-up on Home, SubNav and VPP plan search

	@Then("^the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page$")
	public void the_user_validates_the_Cancel_button_for_Multi_COunty_Pop_up_lands_on_enter_Zip_code_Page() throws Throwable {
		MultiCountyModalPage multiCountyModalPage = (MultiCountyModalPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean Validation_Flag = multiCountyModalPage.validateMultiCounty_CancelButton();
		Assert.assertTrue("Validation failed : Cancel button Validation for Multi County Pop-up Failed ",Validation_Flag);

	}
	// Steps added to validate Cancel button on Multi County pop-up on Home, SubNav and VPP plan search

	@When("^the user performs plan search using following MultiCounty Zip in Header Sun Nav in the AARP site$")
	public void the_user_performs_plan_search_using_following_MultiCounty_Zip_in_Header_Sun_Nav_in_the_AARP_site(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MultiCountyModalPage multiCountyModalPage = aquisitionhomepage.SubNav_ValidateMultiCOuntyPopUp(
				zipcode);

		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					multiCountyModalPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
}*/
	// Steps added to validate Cancel button on Multi County pop-up on Home, SubNav and VPP plan search

	/*@When("^the user performs Change Location on Plan Summary Page using following MultiCounty Zip information in the AARP site$")
	public void the_user_performs_Change_Location_on_Plan_Summary_Page_using_following_MultiCounty_Zip_information_in_the_AARP_site(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		MultiCountyModalPage multiCountyModalPage = plansummaryPage.VPP_ChangeLocationValidateMultiCOuntyPopUp(
				zipcode);

		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					multiCountyModalPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}*/
	
	@Then("^the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site$")
    public void User_clicks_BackToPlansLink_and_validates_redirection_in_UMS_site() {

		
		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		pages.acquisition.bluelayer.VPPPlanSummaryPage plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPage();
        //VPPPlanSummaryPage plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPage(); 
		
		//VPPPlanSummaryPage plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPage();
		
		if (plansummaryPage != null) {
				Assert.assertTrue(true);
			} else
				Assert.fail("Error in validating the Plan Summary Page");
		}
	

   @Then("^the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site$")
   public void User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_ums() {
	   String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	   if(!planType.equals("MA")){
	   DrugCostEstimatorPage drugCostEstimatorPage = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
	   drugCostEstimatorPage.clickReturnToSummaryLink();
	   
	   }  
   }
/*	@When("^the user goes to PDP Landing and performs zipcode search using widget to welcome OLE Page using widget on the AARP site$")
	public void the_user_goes_to_PDP_Landing_and_performs_zipcode_search_using_widget_to_welcome_OLE_Page_using_widget_on_the_AARP_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.OurPlansPDPLanding();
		WelcomePage welcomeOLEPage = aquisitionhomepage.ZipcodeSearchToOLE(zipcode);

		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assert.fail("Error Loading OLE Welcome page");
		}
	}
	
	@Then("^the user validates the following Plan details for the plan$")
	public void the_user_validates_the_following_Plan_details_for_the_plan(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String benefitType = memberAttributesMap.get("Benefit Type");
		String expectedText = memberAttributesMap.get("Expected Text");
		System.out.println("Validating the following Additional benefits : "+benefitType);
		
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(benefitType, expectedText);
		Assert.assertTrue("Validation failed : Expected text not displayed for Additional Benefit - "+benefitType,validationFlag);
	
	}	*/
  /* @Then("^the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS site$")
     public void the_user_clicks_enterDrugInformation_validates_dceHomePage_UMS(){
	   String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	   if(!planType.equals("MA")){
	   VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	   String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
	   DrugCostEstimatorPage drugCostEstimatorPage = plansummaryPage.navigatetoDCEPage(planName);
	   if (drugCostEstimatorPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE , drugCostEstimatorPage);

		} else {
			Assert.fail("Error Loading DCE page");
		}
	   }
   }*/
   
   @Then("^the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site$")
   public void the_user_clicks_enterDrugInformation_validates_dceHomePage_UMS() throws Throwable {
	   String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	   if(!planType.equals("MA")){
	   VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	   String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
	   DrugCostEstimatorPage drugCostEstimatorPage = plansummaryPage.navigatetoDCEPage(planName);
	   if (drugCostEstimatorPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE , drugCostEstimatorPage);

		} else {
			Assert.fail("Error Loading DCE page");
		}
	   }
       
   }

   
   @Then("^the user validates Add to compare checkbox is not present for DSNP Plans in UMS$")
   public void addToCompareNotPresentForDSNP(){
	   String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	   if(planType.equals("SNP")){
	   VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	   String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
	   plansummaryPage.validateAddToCompareNotPresentForDSNP(planName); 
	   }
   }
   
   @Then("^the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site$") 
   public void user_validatesPopup_learnMoreAboutExtraHelp_ums() {
	   String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		  if (!planType.equals("MA")){
	   VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	   //String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		plansummaryPage.validatesLearnMoreAboutExtraHelpPopup();
		  }   
  }
   @Then("^the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site$")
   public void user_validatesAndClickslearnMoreAboutExtraHelp_aarp() throws InterruptedException {
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		plansummaryPage.validateAndClickLearnMoreAboutExtraHelpInUMS(planType, planName);	 
}
  @Then("^the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site$")
  public void user_validates_IsMyProviderCoveredLink_UMS() {
	  String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	  if(!planType.equals("PDP")){
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
		.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE); 
	  String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
	  plansummaryPage.clickOnViewMoreForPlan(planName);
	  plansummaryPage.validateIsMyProviderCoveredLinkInUMS(planType,planName);	  
	  }
  }
  
  @Then("^the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site$")
  public void user_clicks_IsMyProviderCoveredLink_ums() throws InterruptedException {
	  String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	  if(!planType.equals("PDP")){
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE); 
	  String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
	  plansummaryPage.clicksOnIsProviderCoveredUMS(planName);  
	  }
  }


  
  @Then("^the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page")
  public void user_clicks_enrollInPlan_validates_welcomeOLE() throws InterruptedException{
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE); 
	  String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);	
	  String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
   WelcomePage  welcomeOLEPage = plansummaryPage.Enroll_OLE_Plan(planName,planType);
   if (welcomeOLEPage != null) {
		getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
	} else {
		Assert.fail("Error Loading Welcome Page for OLE");
	}
  }
  @Then("^the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans$")
  public void user_validates_planBenefitValues_inUMS(DataTable givenAttributes){
	  String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	  if (!planType.equals("PDP")){ 
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
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);		
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		plansummaryPage.clickOnViewMoreForPlan(planName);
		plansummaryPage.validatePlanPremium(planName ,monthlyPremium);
		plansummaryPage.validatePrimaryCarePhysicianBenefit(planType ,planName , primaryCarePhysician);
		plansummaryPage.validateSpecialistBenefit(planType ,planName , specialist);
		plansummaryPage.validateReferrralRequiredBenefit(planName ,referralRequired);
		plansummaryPage.validatesOutOfPocketMaximum(planName , outOfPocketMaximum);
		plansummaryPage.validatePrescriptionDrugsTier1(planName,planType,prescriptionDrugsTier1);	
	  }
	  else
		 System.out.println("Benefits are not applicable for PDP Plans"); 
  }
  
  @Then("^the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans$")
  public void user_validates_planBenefitValues_PDP_AARP(DataTable givenAttributes) {
	  String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	  if (planType.equals("PDP")){
	  List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	  Map<String, String> memberAttributesMap = new HashMap<String, String>();
	  for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
	    String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String annualDeductible = memberAttributesMap.get("Annual Deductible");
		String prescriptionDrugsTier1 = memberAttributesMap.get("Prescription Drugs, Tier 1");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		plansummaryPage.validatePlanPremium(planName ,monthlyPremium);
		plansummaryPage.validateAnnualDeductible(planName ,annualDeductible);
		plansummaryPage.validatePrescriptionDrugsTier1(planName,planType,prescriptionDrugsTier1);
	  }
	  else
		  System.out.println("Benefits are not applicable for MA, MAPD and DSNP Plans");
  }
  
  @Then("^the user validates marketing bullets of the plan in UMS Site$")
   public void validate_marketingBullets() {
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);  
	  String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
	  String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	  plansummaryPage.validateMarketingBullets(planType , planName);
  }
  
  @Then("^the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site$")
  public void toolTip_premium0_validateText_inUMS() throws Throwable {
	  String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	  if(planType.equals("MA") || planType.equals("MAPD")){
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);  
     String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
	  plansummaryPage.toolTipForPremium0(planName);
  }
 }
 
 @Then("^the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site$")
 public void toolTip_annualDeductible_inUMS() throws Throwable {
	  String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
	  if(planType.equals("PDP")){
		  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);  
	      String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		  plansummaryPage.toolTipForAnnualDeductible(planName);  
	  }
 }
  
  @Then("^the user validates the right rail in UMS Site$")
  public void user_validates_rightRail(){
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	  plansummaryPage.validateRightRailSection();
  }
  
  @Then("^the user validates the Need Help Section in the right rail in ums Site$")
  public void validate_needHelp_rightRail(){
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	  plansummaryPage.validateNeedHelpRightRail();	   
  }
  
  @Then("^the user validates the TFN in the Need Help Section in ums Site$")
  public void validate_TFN_inRIghtRail_aarp(){
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	  plansummaryPage.GetTFNforPlanType();
  }
  
  @Then("^the user validates and clicks on Find an agent in your area link in ums Site$")
  public void validateAndClick_findAgentInYourArea_RightRail(){
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	  plansummaryPage.validateAgentEBRCPage();
  }
  
  @Then("^the user validates Get a free medicare Guide section in the right rail in ums Site$")
  public void validate_freeMedicareGuide_rightRail() {
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	  plansummaryPage.validateMedicareGuideRightRail();	
  }
  
  @Then("^the user enters the following information in the Get a free medicare Guide section in ums Site$")
  public void user_enters_necessaryInformation_inGetFreeMedicareGuideSection(DataTable givenAttributes) throws Throwable {
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
  
  @Then("^the user validates Need More Information section in the right rail in ums Site$")
  public void validate_needMoreInformation_rightRail() {
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	  plansummaryPage.validateNeedMoreInformationRightRail();
  }
  
  @Then("^the user validates Medicare Plans Video Guide Page after clicking Choose a video link in ums Site$")
  public void validate_andClick_ChooseAVideo() throws InterruptedException {
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	  plansummaryPage.validateMedicareVideoGuideRightRail();
  }
  
  @Then("^the user validates Plan Selector Tool section in the right rail in ums Site$")
  public void validate_planSelectorTool_rightRail(){
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	  plansummaryPage.validatePlanSelectorToolRightRail();
  }
  
  @Then("^the user validates Plan Selector Page after clicking on Start Plan Selector button in ums Site$")
  public void user_validate_planSelectorPage_inaarpSite(){
	  VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	  plansummaryPage.validatePlanSelectorPageInRightRail();
  }
  @When("^the member validates the search box$")
	public void I_validate_search_box() throws InterruptedException {

		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Thread.sleep(10000);
		//acquisitionHomePage.searchfield(acquisitionHomePage.driver);
		KeywordSearch kws = acquisitionHomePage.searchfield();
		getLoginScenario().saveBean(PageConstants.Keyword_Search, kws);
	}
	@Then("^the member lands on the result page$")
	public void I_land_on_result_page(){
		KeywordSearch kws = (KeywordSearch) getLoginScenario().getBean(PageConstants.Keyword_Search);
		kws.url();		
		if(kws != null)				
			getLoginScenario().saveBean(PageConstants.Keyword_Search,
					kws);			
		
	}
	/**
	 * @toDo:user is on the uhcmedicaresolutions site landing page
	 */
	@Given("^the potential user is on the uhcmedicaresolutions site landing page$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}
} 
