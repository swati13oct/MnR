package acceptancetests.acquisition.vpp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;

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
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.ComparePlansPageBlayer;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.bluelayer.FindCarePage;
import pages.acquisition.bluelayer.MultiCountyModalPage;
import pages.acquisition.bluelayer.PlanComparePage;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.bluelayer.ProviderSearchPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import pages.acquisition.bluelayer.VisitorProfilePage;
import pages.acquisition.bluelayer.ZipcodeLookupHomePage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.ulayer.ComparePlansPage;

/**
 * Functionality: VPP UHC site
 */

public class VppStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo:user is on the uhcmedicaresolutions site landing page
	 */
	@Given("^the user is on the uhcmedicaresolutions site landing page$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriverNew();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	/**
	 * @toDo : the user enters the zip code to search plans
	 */
	@When("^the user performs plan search using following information in UMS site$")
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
	
	@When("^the user enters zipcode on health plans page in UMS site$")
	public void enters_zipcode_details_in_UMS_site(DataTable givenAttributes) {
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

	/**
	 * @toDo : the user enters the zip code to search plans on team-c
	 */
	@When("^the user performs plan search TeamC using following information in UMS site$")
	public void zipcode_details_in_TeamC_site(DataTable givenAttributes) {

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

		/*
		 * TeamCAcqHome aquisitionhomepage = (TeamCAcqHome) getLoginScenario()
		 * .getBean(PageConstants.ACQUISITION_HOME_PAGE);
		 */
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		// VPPPlanSummaryPage plansummaryPage =
		// aquisitionhomepage.searchPlans(zipcode, county);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			if (plansummaryPage.validateVPPPlanSummaryPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the Plan Summary Page");

		}

	}

	/**
	 * @throws InterruptedException
	 * @toDo:user views plans of the below plan type
	 */
	@When("user views plans of the below plan type in UMS site$")
	public void user_performs_planSearch_in_UMS_site(DataTable givenAttributes) throws InterruptedException {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		plansummaryPage.handlePlanYearSelectionPopup();
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, "UHC_ACQ");
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
	}
	
	
	@When("user views plans of the below plan type in UMS site for current year$")
	public void user_performs_planSearch_in_UMS_site_current_year(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		plansummaryPage.viewPlanSummary(plantype);
		plansummaryPage.CheckClick_CurrentYear_Plans();
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, "UHC_ACQ");
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
	}
	
	@When("user views plans of the below plan type in UMS site for next year$")
	public void user_performs_planSearch_in_UMS_site_next_year(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		plansummaryPage.viewPlanSummary(plantype);
		plansummaryPage.CheckClick_NextYear_Plans();
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, "UHC_ACQ");
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
	}
	

	@Then("^the user validates the Enroll Now Button present for the plan type$")
	public void Enroll_now_button_validation(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String PlanPremium = vppPlanSummaryPage.EnrollmentValidation(PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);

	}

	@Then("^the user validates the Enroll Now Button present for the Chronic plan type$")
	public void Chronic_Enroll_now_button_validation(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		WelcomePage welcomePage = vppPlanSummaryPage.EnrollmentValidationChronic(PlanName);
		getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);

	}

	/**
	 * @toDo:user view plan details of the above selected plan
	 */
	@Then("^the user view plan details of the above selected plan in UMS site and validates$")
	public void user_views_plandetails_selected_plan_ums(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		vppPlanSummaryPage.clickOnViewMoreForPlan(planName);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(planName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		} else
			Assert.fail("Error in validating the Plan Details Page");
	}

	@Then("^the user validates following PDF link is displayes with correct document code for UHC$")
	public void the_user_validates_following_PDF_link_is_displayes_with_correct_document_code_for_UHC(DataTable givenAttributes) throws Throwable {
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
	
	@Then("^the user click on PDF link and validates document code in URL for UHC$")
	public void the_user_click_on_PDF_link_and_validates_document_code_in_URL_for_UHC(DataTable givenAttributes) throws Throwable {
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
	
	@When("^the user validates the pdf section for uhc$")
	public void userValidatesPDFSection() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatePdfSection(planType);
	}
	
	@Then("^the user validates the document code is present in the PDF for UHC$")
	public void the_user_click_on_PDF_link_and_validates_document_code_in_PDF_for_UHC(DataTable givenAttributes) throws Throwable {
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
		boolean validationFlag = vppPlanDetailsPage.ClickValidatePDFText_ForDocCode(PDFtype, DocumentCode);
		Assert.assertTrue("Validation failed : Expected Document Code is not Present in the PDF Text ",validationFlag);

	}

	@Then("^the user view plan details of the above selected plan in UMS site vpp$")
	public void the_user_view_plan_details_of_the_above_selected_plan_in_UMS_site_vpp(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName,planType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Details Page");
	}
	
	@Then("^the user view plan details of the first plan in the given plan type in UMS site vpp$")
	public void the_user_view_plan_details_of_the_first_plan_in_UMS_site_vpp() {
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToFirstPlanForPlanDetails(planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Details Page");
	}


	@Then("^the user clicks on both top and bottom back to plans link and validates its redirection$")
	public void the_user_clicks_on_both_topand_bottom_back_to_plans_link_and_validates_its_redirection()
			throws InterruptedException {
		// getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
		// vppPlanDetailsPage);
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatetopbacktoplanslink();
		vppPlanDetailsPage.browserBack();
		vppPlanDetailsPage.validatedownbacktoplanslink();

	}

	/**
	 * @toDo:access the vpp page
	 */
	@When("^I access the vpp page$")
	public void I_access_the_vpp_page(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		AcquisitionHomePage acqhomepage = (AcquisitionHomePage) loginScenario
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage vppplansummarypage = acqhomepage.navigateToVpp(zipcode);
		if (vppplansummarypage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppplansummarypage);

		}
	}

	/**
	 * @toDo:click on add to compare checkbox and click on view details
	 */
	@And("^I click on add to compare checkbox and click on view details link$")
	public void I_click_on_compare_checkbox() {
		VPPPlanSummaryPage vppplansummarypage = (VPPPlanSummaryPage) loginScenario
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.clickonViewPlans();
		vppplansummarypage.clickCompareChkBox();
		PlanDetailsPage plandetailspage = vppplansummarypage.clickViewDetails();
		if (plandetailspage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		}
	}

	/**
	 * @toDo:select pdp plans and go to view details page
	 */
	@And("^I select pdp plans and go to view details page$")
	public void I_select_pdp_plans_and_go_to_view_details_page() {
		VPPPlanSummaryPage vppplansummarypage = (VPPPlanSummaryPage) loginScenario
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.clickOnPDPPlans();
		PlanDetailsPage plandetailspage = vppplansummarypage.clickViewDetailsPDP();
		if (plandetailspage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
		}
	}

	/**
	 * @toDo:check compare box and verify right info is shown
	 */
	@Then("^I check compare box and verify right info is shown$")
	public void I_check_compare_box_and_verify() {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) loginScenario.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		if (plandetailspage.validateCompareBoxPDP()) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the compare checkbox message and/or link");
	}

	/**
	 * @toDo:user clicks on add to compare box and validates that info shows 2
	 *            plans added
	 */
	@Then("^the user clicks on add to compare box and validates that info shows 2 plans added$")
	public void I_check_compare_box_and_verify_2_plans() {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) loginScenario.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		if (plandetailspage.validate2PlansAdded()) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the compare checkbox message and/or link");
	}

	/**
	 * @toDo:uncheck and recheck the compare box and verify the message and link
	 *               exists
	 */
	@Then("^I uncheck and recheck the compare box and verify the message and link exists$")
	public void verifyPlanDetailsPage() {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) loginScenario.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		if (plandetailspage.validateCompareBox()) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the compare checkbox message and/or link");
	}

	/**
	 * @toDo:uncheck and go back to the vpp page to validate
	 */
	@Then("^I uncheck and go back to the vpp page to validate$")
	public void uncheck_and_validate_vpp_page() {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) loginScenario.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		plandetailspage.clickCompareBox();
		VPPPlanSummaryPage vppsummarypage = plandetailspage.navigateBackToPlanSummaryPage();
		if (vppsummarypage != null) {
			if (vppsummarypage.verifyCompareCheckBoxesAreUnchecked())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating that the checkboxes are unchecked");
		} else
			Assert.fail("Error in loading the vpp plan summary page");
	}

	/**
	 * @toDo:isAlertPresent
	 */
	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@Then("^the user selects plans to add to plan compare and navigates to Plan compare page in UHC site$")
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
		String SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);
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
		PlanComparePage comparePlansPage = planSummaryPage.selectplantocompare(PlanType, PlanName);

		if (comparePlansPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, comparePlansPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Compare Page");

	}

	/**
	 * @toDo:select all 3 plans to compare in MA and click on compare plan link
	 */
	@And("^I select all 3 plans to compare in MA and click on compare plan link in UHS site$")
	public void I_select_all_3_plans_to_compare() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickonViewPlans();
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.checkAllMAPlans();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageBlayer comparePlansPageblayer = plansummaryPage.clickOnCompareLink();
		if (comparePlansPageblayer != null) {
			getLoginScenario().saveBean(PageConstants.TeamC_Plan_Compare_Page, comparePlansPageblayer);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	/**
	 * @toDo:user validate the print and email link option in plan compare
	 */
	@When("^the user validate the print and email link option in plan compare in UHS site$")
	public void user_validate_print_and_email_link_option_in_plan_compare() {

		ComparePlansPageBlayer comparePlansPage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		comparePlansPage.validateprintandemail();
	}

	/**
	 * @toDo:the user validating email and print option in plan compare
	 */
	@Then("^the user validating email and print option in plan compare in UHS site$")
	public void user_validating_print_and_email_option_in_plan_compare() {

		ComparePlansPageBlayer comparePlansPage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		comparePlansPage.validatingprintandemail();
	}

	/**
	 * @toDo:user validate thank you message in plan compare
	 */
	@When("^the user validate thank you message in plan compare in UHS site$")
	public void user_validate_thank_you_message_in_plan_compare() {

		ComparePlansPageBlayer comparePlansPage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		comparePlansPage.validatingthankyoumessage();
	}

	/**
	 * @toDo:user clicks on back to all plans link and validate all three plans
	 *            are selected
	 */

	@Then("^the user clicks on back to all plans link and validates all three plans are selected$")
	public void the_user_clicks_on_back_to_plans_link_and_validates_plans_are_selected() {

		ComparePlansPageBlayer comparePlansPage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		comparePlansPage.validatetopbacktoplanslink();
	}

	@Then("^the user validates the following Additional Benefits Plan details for the plan in UMS$")
	public void the_user_validates_the_following_Plan_details_for_the_plan(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String benefitType = memberAttributesMap.get("Benefit Type");
		String expectedText = memberAttributesMap.get("Expected Text");
		System.out.println("Validating the following Additional benefits : " + benefitType);

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(benefitType,
				expectedText);
		Assert.assertTrue("Validation failed : Expected text not displayed for Additional Benefit - " + benefitType,
				validationFlag);
	}

	@Then("^the user validates the following Medical Benefits Plan details for the plan in UMS$")
	public void the_user_validates_the_following_Medical_benefits_Plan_details_for_the_plan(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String benefitType = memberAttributesMap.get("Benefit Type");
		String expectedText = memberAttributesMap.get("Expected Text");
		System.out.println("Validating the following Medical benefits : " + benefitType);

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.validatingMedicalBenefitTextInPlanDetails(benefitType,
				expectedText);
		Assert.assertTrue("Validation failed : Expected text not displayed for Medical Benefit - " + benefitType,
				validationFlag);

	}

	/**
	 * @toDo:user validates plan count for all plan types on plan summary page
	 */
	@Then("^user validates plan count for all plan types on plan summary page in the UMS site$")
	public void user_validates_following_benefits_ui_ums() {

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assert.assertTrue("Error validating plans in  VPP plan summary page",
				plansummaryPage.validateVPPPlanSummaryPage());
	}

	/**
	 * @toDo:user view plan details of the above selected plan
	 */
	@Then("^User clicks on Back to Plans link and navigate back to plan summary in UMS site$")
	public void User_clicks_BackToPlansLink_and_navigate_back_to_plan_summary_in_UMS_site() {

		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		VPPPlanSummaryPage plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPage();
		if (plansummaryPage != null) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the Plan Summary Page");
	}

	/**
	 * @toDo:click on add to compare checkbox and click on view details
	 */
	@And("^User click on add to compare checkbox and click on view details link on UMS$")
	public void user_click_on_compare_checkbox_ums() {
		VPPPlanSummaryPage vppplansummarypage = (VPPPlanSummaryPage) loginScenario
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.clickCompareChkBox();
		PlanDetailsPage plandetailspage = vppplansummarypage.clickViewDetails_AddedToCompare();
		if (plandetailspage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, plandetailspage);
			plandetailspage.clickCompareBox();
		}
	}

	// Steps added to validate Cancel button on Multi County pop-up on Home,
	// SubNav and VPP plan search
	@When("^the user performs plan search using following MultiCounty Zip information in the UHC site$")
	public void the_user_performs_plan_search_using_following_MultiCounty_Zip_information_in_the_UHC_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MultiCountyModalPage multiCountyModalPage = aquisitionhomepage.ValidateMultiCOuntyPopUp(zipcode);

		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, multiCountyModalPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}

	}

	@Then("^the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page in UHC$")
	public void the_user_validates_the_Cancel_button_for_Multi_COunty_Pop_up_lands_on_enter_Zip_code_Page()
			throws Throwable {
		MultiCountyModalPage multiCountyModalPage = (MultiCountyModalPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean Validation_Flag = multiCountyModalPage.validateMultiCounty_CancelButton();
		Assert.assertTrue("Validation failed : Cancel button Validation for Multi County Pop-up Failed ",
				Validation_Flag);

	}

	@When("^the user performs plan search using following MultiCounty Zip in Header Sub Nav in the UHC site$")
	public void the_user_performs_plan_search_using_following_MultiCounty_Zip_in_Header_Sub_Nav_in_the_UHC_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MultiCountyModalPage multiCountyModalPage = aquisitionhomepage.SubNav_ValidateMultiCOuntyPopUp(zipcode);

		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, multiCountyModalPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	@When("^the user performs Change Location on Plan Summary Page using following MultiCounty Zip information in the UHC site$")
	public void the_user_performs_Change_Location_on_Plan_Summary_Page_using_following_MultiCounty_Zip_information_in_the_UHC_site(
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

	@Then("^the user validates the VPP Promo right rail widjet$")
	public void user_validates_the_VPP_promo_widjet(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		// String planType = (String)
		// getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.validatePromoWidjet(planName);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		} else
			Assert.fail("Error in validating the Plan Details Page");
	}

	/**
	 * @toDo:select all 3 plans to compare and click on compare plan link
	 */
	@And("^I select all 3 plans to compare and click on compare plan link in UHC$")
	public void I_select_all_3_plans_to_compare_UHC() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		plansummaryPage.checkAllMAPlans();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageBlayer planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@Given("^I select \"([^\"]*)\" plans to compare and click on compare plan link in UHC$")
	public void i_select_plans_to_compare_and_click_on_compare_plan_link_in_UHC(String planType) throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if (planType.equals("MAPD")) {
			plansummaryPage.clickonViewPlans();
			plansummaryPage.checkAllMAPlans();
			System.out.println("Selected All MAPD plans for Plan Compare");
		} else if (planType.equals("PDP")) {
			plansummaryPage.clickOnPDPPlans();
			plansummaryPage.clickCompareChkBoxPDP();
			System.out.println("Selected All PDP plans for Plan Compare");
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageBlayer planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@And("^I Click on DCE link on Plan compare$")
	public void I_Click_On_DCE_link_on_Plan_Compare() {
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DrugCostEstimatorPage drugCostEstimatorPage = planComparePage.clickonDCE();
		if (drugCostEstimatorPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, drugCostEstimatorPage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@And("^I Click on Look up your doctor link on Plan compare$")
	public void I_Click_on_Look_up_your_doctor_link_on_Plan_compare() throws InterruptedException {
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FindCarePage findCarePage = planComparePage.clickonLookUpYourDoctor();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@And("^I click on Get Started on and Add Provider from find care page$")
	public void I_click_on_Get_Started_and_Add_Provider_from_find_care_page() throws Exception {
		FindCarePage findCarePage = (FindCarePage) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageBlayer planComparePage = findCarePage.getstarted();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@Then("^Verify provider is count is updated on plan compare page$")
	public void Verify_provider_is_count_is_updated_on_plan_compare_page() throws Exception {
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		planComparePage.verifyProvidercount();
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
	}

	/**
	 * @toDo:the user is on UHC medicare acquisition site VPP Plan Summary page
	 *           after hits Campaign URL
	 */
	@Given("^the user is on UHC medicare acquisition site VPP Plan Summary page after hits Campaign URL$")
	public void the_user_on_aarpmedicareplans_Campaign_landing_page() throws Throwable {

		String County = "St. Louis County";
		String ZipCode = "63043";
		String PlanYear = "2020";
		String SiteName = "UHC_ACQ";

		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);

		String OLE_Campaign_URL = "https://stage-uhcmedicaresolutions.uhc.com/health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731#/plan-summary <>";

		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		VPPPlanSummaryPage vppPlanSummaryPage = new VPPPlanSummaryPage(wd, OLE_Campaign_URL, true);
		if (vppPlanSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppPlanSummaryPage);
			System.out.println("OLE Campaign Landing Page Displayed");
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the OLE Campaign Landing");
	}

	@Then("^the user validates the following Medical Benefits for the plan in Plan Compare Page on UHC$")
	public void the_user_validates_the_following_Medical_benefits_for_the_plan_in_Plan_Compare_Page(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String benefitType = memberAttributesMap.get("Benefit Type");
		String expectedText = memberAttributesMap.get("Expected Text");
		String PlanName = memberAttributesMap.get("Plan Name");
		System.out.println("Validating the following Medical benefits on Plan Compare Page : " + benefitType);

		PlanComparePage comparePlansPage = (PlanComparePage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		boolean validationFlag = comparePlansPage.validatingMedicalBenefitTextInPlanDetails(benefitType, expectedText,
				PlanName);
		Assert.assertTrue("Validation failed : Expected text not displayed for Medical Benefit - " + benefitType,
				validationFlag);

	}

	// vvv note: added for US1598162
	public Map<String, String> prepareTestInput(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}


	@Then("^user validates selected plans can be saved as favorite on UHC site$")
	public void user_validates_selected_plan_can_be_saved_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");

		// ----- MA plan type ----------------------------
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateAbilityToSavePlans(ma_savePlanNames, planType);

		// ----- PDP plan type ---------------------------
		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateAbilityToSavePlans(pdp_savePlanNames, planType);

		// ----- SNp plan type ---------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateAbilityToSavePlans(snp_savePlanNames, planType);
	}

	@Then("^user saves two plans as favorite on UHC site$")
	public void user_saves_two_plans_as_favorite_on_UHC_site(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");

		// ----- MA plan type ----------------------------
		String planType = memberAttributesMap.get("Plan Type");
		//plansummaryPage.viewPlanSummary(planType);
		//plansummaryPage.CheckClick_CurrentYear_Plans();
		plansummaryPage.savePlans(ma_savePlanNames, planType);
	}

	@Then("^user gets a create profile prompt on UHC site$")
	public void user_saves_two_plans_as_favorite_on_UHC_site() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.validateCreateProfilePrompt();

		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

	}

	@And("^user click on continue as guest button on UHC site$")
	public void user_click_on_continue_as_guest_button_on_UHC_site() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		VisitorProfilePage visitorProfilePage = plansummaryPage.continueAsGuest();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);

	}

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change from Home on UHC site$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Home_on_AARP_site(
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
			Assert.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType); 
	}

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change from Shop For a Plan on UHC site$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Shop_For_a_Plan_on_AARP_site(
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

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode("90210", "Los Angeles County", "NO");

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else {
			Assert.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
		plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode(zipcode, county, isMultiCounty);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			// System.out.println("TEST - loaded plansummary page for
			// zipcode='"+zipcode+"'");
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType); 
	}

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change within VPP page on UHC site$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_within_VPP_page_on_AARP_site(
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

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode("90210", "Los Angeles County",
				"NO");

		if (plansummaryPage != null) {
			System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
			plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode(zipcode, county, isMultiCounty);
		} else {
			Assert.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType); 
	}

	@Then("^user validates ability to unsave a saved plan on UHC site$")
	public void user_validates_ability_to_unsave_a_saved_plan_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ma_plans = memberAttributesMap.get("MA Test Plans");
		String pdp_plans = memberAttributesMap.get("PDP Test Plans");
		String snp_plans = memberAttributesMap.get("SNP Test Plans");

		// note: the second plan in the list will be unsaved
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		System.out.println("Proceed to unsave the " + planType + " second plan from the input");
		plansummaryPage.validateAbilityToUnSavePlans(ma_plans, planType);

		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		System.out.println("Proceed to unsave the " + planType + " second plan from the input");
		plansummaryPage.validateAbilityToUnSavePlans(pdp_plans, planType);

		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		System.out.println("Proceed to unsave the " + planType + " second plan from the input"); 
		plansummaryPage.validateAbilityToUnSavePlans(snp_plans, planType); 
	}

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change from Home on UHC site$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Home_on_AARP_site(
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
			Assert.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " unsaved plan(s) are still unsaved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " unsaved plan(s) are still unsaved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " unsaved plan(s) are still unsaved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(snp_savePlanNames, planType); 
	}

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change from Shop For a Plan on UHC site$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Shop_For_a_Plan_on_AARP_site(
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

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode("90210", "Los Angeles County", "NO");

		if (plansummaryPage != null) {
			System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
			plansummaryPage = plansummaryPage.navagateToShopAPlanAndFindZipcode(zipcode, county, isMultiCounty);
		} else {
			Assert.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(snp_savePlanNames, planType); 
	}

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change within VPP page on UHC site$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_within_VPP_page_on_AARP_site(
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

		System.out.println("Proceed to click 'Change Zipcode' and enter different zip code");
		plansummaryPage = plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode("90210", "Los Angeles County",
				"NO");

		if (plansummaryPage != null) {
			System.out.println("Proceed to click 'Change Zipcode' and enter original zip code");
			plansummaryPage = plansummaryPage.navagateToChangeZipcodeOptionToChangeZipcode(zipcode, county,
					isMultiCounty);
			if (plansummaryPage == null) {
				Assert.assertTrue("PROBLEM - plansummaryPage is null", false);
			}
		} else {
			Assert.assertTrue("PROBLEM - plansummaryPage is null", false);
		}

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateOnePlanSavedOnePlanUnsaved(snp_savePlanNames, planType); 
	}

	@Then("^user validates email option on UHC site$")
	public void user_validates_email_option_on_AARP_site() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// ----- MA plan type -----------------------------
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOptionExistOnPage(planType);
		// ----- PDP plan type ----------------------------
		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOptionExistOnPage(planType);
		// ----- SNP plan type ----------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOptionExistOnPage(planType);
	}

	@Then("^user validates print option on UHC site$")
	public void user_validates_print_option_on_AARP_site() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// ----- MA plan type -----------------------------
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOptionExistOnPage(planType);
		// ----- PDP plan type ----------------------------
		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOptionExistOnPage(planType);
		// ----- SNP plan type ----------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOptionExistOnPage(planType);
	}

	@Then("^user validates email functionality with invalid and valid email address on UHC site$")
	public void user_validates_email_functionality_on_AARP_site() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// ----- MA plan type -----------------------------
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOption(planType);
		// ----- PDP plan type ----------------------------
		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOption(planType);
		// ----- SNP plan type ----------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateEmailOption(planType);
	}

	@Then("^user validates print functionality on UHC site$")
	public void user_validates_print_functionality_on_AARP_site() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// ----- MA plan type -----------------------------
		String planType = "MA";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOption(planType);
		// ----- PDP plan type ----------------------------
		planType = "PDP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOption(planType);
		// ----- SNP plan type ----------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePrintOption(planType);
	}

	@Then("^user closes the original tab and open new tab for UHC site$")
	public void user_closes_the_original_tab_and_open_new_tab_for_AARP_site() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.closeOriginalTabAndOpenNewTab();
	}

	@Then("^user validates plans remain saved within same session for UHC site$")
	public void user_validates_plans_remain_saved_within_same_session(DataTable givenAttributes) {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");

		// ----- MA plan type ---------------------------
		String planType = "MA";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(ma_savePlanNames, planType);

		// ----- PDP plan type --------------------------
		planType = "PDP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);

		// ----- SNP plan type --------------------------
		planType = "SNP";
		System.out.println("Proceed to validate " + planType + " saved plan(s) are still saved");
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType); 
	}
	// ^^^ note: added for US1598162

	@Then("^the UHC user clicks on Start Application Button proceed to next pages for getting resume application key")
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
		String zipcode = memberAttributesMap.get("Zipcode");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation(DateOfBirth,zipcode);
		String resumeKey = plansummaryPage.StartApplicationButton(FirstName, LastName);
		getLoginScenario().saveBean(VPPCommonConstants.RESUMEKEY, resumeKey);

	}

	@Then("^the user clicks on resume application button")
	public void click_resume_application()throws Throwable {
		
		System.out.println("***the user clicks on resume application button***");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.ResumeApplicationButton();

	}
	
	@Then("^the user navigates to next page to locate resume application button")
	public void click_resume_application(DataTable givenAttributes)throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String DateOfBirth = memberAttributesMap.get("DOB");
		String zipcode = memberAttributesMap.get("Zipcode");
		System.out.println("***the user clicks on resume application button***");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation_2ndTime(DateOfBirth, zipcode);
		plansummaryPage.ResumeApplicationButton();

	}

	@Then("^the user will navigate to locate resume application button")
	public void click_resume_application_3(DataTable givenAttributes)throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String DateOfBirth = memberAttributesMap.get("DOB");
		String zipcode = memberAttributesMap.get("Zipcode");
		System.out.println("***the user clicks on resume application button***");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation(DateOfBirth, zipcode);
		plansummaryPage.ResumeApplicationButton();

	}

	@Then("^the user enters data to resume the application")
	public void enters_data_to_resume_application(DataTable givenAttributes) throws Throwable {
		System.out.println("***the user enters data to resume the application***");
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String applicationType = memberAttributesMap.get("applicationType");
		String DOB = memberAttributesMap.get("DOB");
		String zipcode = memberAttributesMap.get("zipcode");

		String ApplicationID = (String) getLoginScenario().getBean(VPPCommonConstants.RESUMEKEY);

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		/*if (applicationType.equalsIgnoreCase("Retrieve")) {
			ApplicationID = memberAttributesMap.get("ApplicationID");
		}*/
		plansummaryPage.EnterDataForResumeApp(ApplicationID, DOB, zipcode);

	}

	@Then("^The user validates the resume application processed")
	public void resume_application_processed(DataTable givenAttributes) throws Throwable {
		System.out.println("***The user validates the resume application processed***");
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String FirstName = memberAttributesMap.get("Firstname");
		String LastName = memberAttributesMap.get("Lastname");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.ResumeApplicationButtonValidation(FirstName, LastName);

	}

	@Then("^The user validates the Retrive application")
	public void retrive_application_processed(DataTable givenAttributes) throws Throwable {
		System.out.println("***The user validates the Retrive application***");
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String ApplicationID = memberAttributesMap.get("ApplicationID");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.RetrieveApplicationButtonValidation(ApplicationID);

	}

	@And("^I Click on DCE link on Plan compare for UHC$")
	public void I_Click_On_DCE_link_on_Plan_Compare_for_UHC() {
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DrugCostEstimatorPage drugCostEstimatorPage = planComparePage.clickonDCE();
		if (drugCostEstimatorPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, drugCostEstimatorPage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@Then("^the user validate the print and email links on the plan Details Page on uhc site")
	public void user_validate_print_and_email_links_on_the_plan_Details_Page() {

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatePrintandEmailOnPlanDetails();
	}

	/**
	 * @toDo:the user validates the functionality of email and print buttons on
	 *           the plan Details Page
	 */
	@Then("^the user validates the functionality of email and print buttons on the plan Details Page on uhc site$")
	public void user_validates_the_functionality_of_emailandprintbuttons_on_the_plan_Details_Page() {

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatingFunctionalityOfPrintandEmailOnPlanDetails();

	}

	@Then("^the user Click on Look up your Provider button in UMS site$")
	public void user_Clicks_on_Look_upyourProvider_button_on_PlanDetailsPage() {

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		ProviderSearchPage providerSearchPage = vppPlanDetailsPage.validateLookUpYourProviderButton();
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}
	}

	@Then("^user validates Drug information is reflected on plan compare page in UHC$")
	public void user_validates_Drug_information_is_reflected_on_plan_compare_page_in_UHC() throws Exception {
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		planComparePage.verifyDCEAmount();
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
	}

	@When("^the user performs plan search using Standalone Zipcode information in the UHC site$")
	public void the_user_performs_plan_search_using_Standalone_Zipcode_information_in_the_UHC_site(
			DataTable givenAttributes) throws Throwable {
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

		String PlanType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		String PlanName = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME);

		WelcomePage welcomePage;
		if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
			welcomePage = aquisitionhomepage.ZipcodeSearchToOLEWithOutCounty(zipcode, PlanName);
		} else {
			welcomePage = aquisitionhomepage.ZipcodeSearchToOLEWithCounty(zipcode, county, PlanName);
		}
		Thread.sleep(7000);
		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
		} else {
			Assert.fail("Error Loading OLE Welcome page");
		}
	}

	
	
	@When("^verify Call SAM icon is visible or not on Plan Comapare on UHC site$")
	public void verify_Call_SAM_icon_is_visible_or_not_PlanCompare_UHC_Site() throws InterruptedException {
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		ComparePlansPageBlayer PlanComparePage = planComparePage.validateCallSam();
		if (PlanComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, PlanComparePage);
			Assert.assertTrue(true);
			System.out.println("TFN Widget is Displayed");
		}
		else{
			Assert.fail("TFN Widget is NOT Displayed");
		}
	}
	
	
	@And("^verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare on UHC site$")
	public void verify_Call_SAM_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent_PlanCompare_UHC() throws InterruptedException {
				
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallSamContent();
		
	}
	
	
	@Then("^user verify the popup and content on Plan Comapare on UHC site$")
	public void user_verify_the_popup_and_content_PlanCompare_UHC() throws InterruptedException {
				
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallpopup();	
	}
	
	@When("^verify Chat SAM icon is visible or not on Plan Comapare on UHC site$")
	public void verify_Chat_SAM_icon_is_visible_or_not_PlanCompare_UHC() throws InterruptedException {
				
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		ComparePlansPageBlayer ChatIcon  = planComparePage.validateChatSam();
		if (ChatIcon != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, ChatIcon);
			Assert.assertTrue(true);
			System.out.println("TFN Widget is Displayed");
		}
		else{
			Assert.fail("TFN Widget is NOT Displayed");
		}
	}
	
	@And("^verify Chat SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare on UHC site$")
	public void verify_Chat_SAM_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent_PlanCompare_UHC() throws InterruptedException {
				
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateChatSamContent();
		
	}
	
	
	@Then("^user verify the Chat original state on UHC site$")
	public void user_verify_the_Chat_original_state_PlanCompare_UHC() throws InterruptedException {
				
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateChatSam();
	}
	@Then("^the user validates the following Additional Benefits of Plan for the plan in UMS$")
	public void the_user_validates_the_following_Additional_Benefits_of_Plan_for_the_plan_in_UMS(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> additionalBenefits = givenAttributes.getGherkinRows();

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(additionalBenefits);
	}

	@Then("^the user validates the following Medical Benefits of Plan for the plan in UMS$")
	public void the_user_validates_the_following_Medical_Benefits_of_Plan_for_the_plan_in_UMS(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> medicalBenefits = givenAttributes.getGherkinRows();

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatingMedicalBenefitTextInPlanDetails(medicalBenefits);
		// Assert.assertTrue("Validation failed : Expected text not displayed
		// for Additional Benefit - "+benefitType,validationFlag);
	}

	@Then("^the user click on Plan costs tab and validates$")
	public void the_user_click_on_Plan_costs_tab_and_validates(DataTable givenAttributes) throws Throwable {
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
		boolean validationFlag = vppPlanDetailsPage.clickAndValidatePlanCosts(monthlyPremium, yearlyPremium);
		Assert.assertTrue("Validation failed : Expected text not displayed for monthly and yearly premium - "
				+ monthlyPremium + " " + yearlyPremium, validationFlag);
	}
	
	@Then("^the user click on Prescription Drug Benefits and validates in UHC site$")
	public void the_user_click_on_Prescription_Drug_Benefits_and_validates_in_UHC_site() throws Throwable {
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.clickAndValidatePrescriptionDrugBenefits();
	}

	@Then("^the user click on Optional Services tab and add the rider$")
	public void the_user_click_on_Optional_Services_tab_and_add_the_rider(DataTable givenAttributes) throws Throwable {
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

	@Then("^the user click on Plan costs tab and validate riders monthly and yearly premium$")
	public void the_user_click_on_Plan_costs_tab_and_validate_riders_monthly_and_yearly_premium(
			DataTable givenAttributes) throws Throwable {
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

		boolean validationFlag = vppPlanDetailsPage.clickAndValidateOptionalRiderPremiums(monthlyPremium,
				yearlyPremium);
		Assert.assertTrue("Validation failed : Expected text not displayed for riders monthly and yearly premium - "
				+ monthlyPremium + " " + yearlyPremium, validationFlag);
	}

	@When("^the user checks for AEP CUrrent year plans link and clicks to view current year plans on UHC$")
	public void the_user_views_currentyearlink_clicksLink() throws Throwable {

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.CheckClick_CurrentYear_Plans();
	}

	
	@Then("^verify plan compare page is loaded on UHC$")
	public void verify_plan_compare_page_is_loaded_on_UHC() throws Throwable {
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatePlanComparePage();
	}	
	
	@Then("^remove one plan from plan compare page for UHC$")
	public void remove_one_plan_from_plan_compare_page_for_UHC() throws Throwable {
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnRemoveLink();
	}
	
	@Then("^click on back to plans on plan compare page for UHC$")
	public void click_on_back_to_plans_on_plan_compare_page_for_UHC() throws Throwable {
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnBacktoPlans();
	}
	
	@Then("^Verify the Plan compare checkbox should be unchecked for the removed plan for UHC$")
	public void verify_the_Plan_compare_checkbox_should_be_unchecked_for_the_removed_plan_for_UHC() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyPlanComapreCheckboxIsUnchecked();
	}
	
	@Given("^I select \"([^\"]*)\" plans and \"([^\"]*)\" plans to compare and click on compare plan link in UHC$")
	public void i_select_plans_and_plans_to_compare_and_click_on_compare_plan_link_in_UHC(String planType, String Counter) throws Throwable {
	VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
    int counter=Integer.parseInt(Counter);
	if (planType.equals("MAPD")) {
		plansummaryPage.clickonViewPlans();
		plansummaryPage.checkMAPlansOnly(counter);
		System.out.println("Selected All MAPD plans for Plan Compare");
	} 
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ComparePlansPageBlayer planComparePage = plansummaryPage.clickOnCompareLink();
	if (planComparePage != null) {
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		// comparePlansPage.backToVPPPage();
	} else
		Assert.fail("Error in loading the compare plans page");
}
	
	@Then("^Click on Add Icon and verify it navigates to plan summary page for UHC$")
	public void click_on_Add_Icon_and_verify_it_navigates_to_plan_summary_page_for_UHC() throws Throwable {
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnAddIcon();		
	}
	
	@Then("^check one plan and add it to plancompare for UHC$")
	public void check_one_plan_and_add_it_to_plancompare_for_UHC() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickon3rdPlan();
		ComparePlansPageBlayer planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}
	
	@Then("^Verify newly added plan displayed on plan compare page for UHC$")
    public void verify_newly_added_plan_displayed_on_plan_compare_page_for_UHC() throws Throwable {
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatenewlyAddPlan();
    }

	@Then("^user select and unselect one plan for plan compare and verify second plan checkbox autoselected and click on plan compare$")
	public void user_select_and_unselect_one_plan_for_plan_compare() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.checkOneCheckboxVerifyAutoSelection("true");
		plansummaryPage.checkOneCheckboxVerifyAutoSelection("false");
		
	}
	
	@Then("^verify plan compare checkbox is not visible on plan summary on UHC$")
	public void verify_plan_compare_checkbox_is_not_visible_on_plan_summary_on_UHC() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean validationFlag = plansummaryPage.verifyPlanCompareCheckboxNotVisible();
		Assert.assertFalse("Validation failed : UnExpected Plan Compare check is Visible - ",validationFlag);

	}
	
	@Then("^the user clicks on Enroll in plan for UHC site and validates the Welcome to OLE Page on Plan Compare")
	  public void user_clicks_enrollInPlan_PlanCompare_UHC() throws InterruptedException{
		ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE); 
		  WelcomePage  welcomeOLEPage = planComparePage.Enroll_OLE_Plan_UHC();
	   if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assert.fail("Error Loading Welcome Page for OLE");
		}
	  }
	
	@Then("^the user clicks on Plan details link in Plan Compare page on UHC")
	  public void user_clicks_planDetails_PlanCompare_UHC() throws InterruptedException{
		  ComparePlansPageBlayer planComparePage = (ComparePlansPageBlayer) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE); 
		  ComparePlansPageBlayer vppPlanDetailsPage=planComparePage.navigateToPlanDetail();
			if (vppPlanDetailsPage != null) {
					getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
					Assert.assertTrue(true);
				} 
			else
				Assert.fail("Error in Loading the Plan Details Page");
		
	  }

	@When("^verify Call sticky action menu icon is visible or not$")
	public void verify_Call_sticky_action_menu_icon_is_visible_or_not() throws InterruptedException {
				
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePage Aquisitionhomepage = aquisitionhomepage.validateCallSam();
		if (Aquisitionhomepage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, Aquisitionhomepage);
			Assert.assertTrue(true);
			System.out.println("TFN Widget is Displayed");
		}
		else{
			Assert.fail("TFN Widget is NOT Displayed");
		}
	}
	
	@And("^verify Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent$")
	public void verify_Call_sticky_action_menu_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent() throws InterruptedException {
				
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSamContent();
	}
		
	@Then("^user verify the popup and content in popup$")
	public void user_verify_the_popup_and_content_in_popup() throws InterruptedException {
				
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallpopup();
		
	}
	
	@When("^verify Chat sticky action menu icon is visible or not$")
	public void verify_Chat_sticky_action_menu_icon_is_visible_or_not() throws InterruptedException {
				
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePage Aquisitionhomepage = aquisitionhomepage.validateCallSam();
		if (Aquisitionhomepage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, Aquisitionhomepage);
			Assert.assertTrue(true);
			System.out.println("TFN Widget is Displayed");
		}
		else{
			Assert.fail("TFN Widget is NOT Displayed");
		}
	}
	
	
	@And("^verify Chat sticky action menu roll out and contain the text Call a Licensed Insurance Agent$")
	public void verify_Chat_sticky_action_menu_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent() throws InterruptedException {
				
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSamContent();
		
	}
	
	@Then("^user verify the Chat at its original state$")
	public void user_verify_the_Chat_at_its_original_state() throws InterruptedException {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSam();
	}
	
	@When("^the user clicks on Lookup zipcode on UHC$")
	public void the_user_clicks_on_Lookup_zipcode_on_UHC() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ZipcodeLookupHomePage zipcodeLookuphomePage = aquisitionhomepage.looksupforZipcodes();
		getLoginScenario().saveBean(PageConstants.ZIP_LOOK_UP_HOME_PAGE, zipcodeLookuphomePage);
	}

	@Then("^verify find a zipcode popup displpayed and Enter values and click on LookupZipcode on uhc$")
	public void verify_find_a_zipcode_popup_displpayed_and_Enter_values_and_click_on_LookupZipcode_on_uhc(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String address = memberAttributesMap.get("Address");
		String city = memberAttributesMap.get("City");
		String state = memberAttributesMap.get("State");

		ZipcodeLookupHomePage zipcodeLookuphomePage = (ZipcodeLookupHomePage) getLoginScenario()
				.getBean(PageConstants.ZIP_LOOK_UP_HOME_PAGE);
		zipcodeLookuphomePage.enterAddressDetails(address, city, state);
	}

	@When("^the user performs plan search using following information in the uhc site$")
	public void lookUpzipcode_details_in_UMS_site(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = null;
		if (isMultiCounty.contains("YES")) {
			plansummaryPage = aquisitionhomepage.searchPlansCounty(county);
		} else {
			plansummaryPage = aquisitionhomepage.searchPlansNoCounty();
		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			if (plansummaryPage.validateVPPPlanSummaryPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the Plan Summary Page");

		}

	}	
	
	@Then("^user clicks on Change Zip code link in UMS site$")
	public void user_clicks_on_Change_Zip_code_link_in_UMS_site() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickOnChangeZipCode();
	}

	@Then("^user clicks on Select by Address and Enter fileds in UMS Site$")
	public void user_clicks_on_Select_by_Address_and_Enter_fileds_in_UMS_Site(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String address = memberAttributesMap.get("Address");
		String city = memberAttributesMap.get("City");
		String state = memberAttributesMap.get("State");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.enterAddressDetails(address, city, state);
	}

	@When("^the user clicks on Find plans on vpp using following information in the UMS site$")
	public void the_user_clicks_on_Find_plans_on_vpp_using_following_information_in_the_UMS_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String county2 = memberAttributesMap.get("County Name2");
		String isMultiCounty2 = memberAttributesMap.get("Is Multi County2");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.searchPlansCounty(county2, isMultiCounty2);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			if (plansummaryPage.validateVPPPlanSummaryPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the Plan Summary Page");

		}
	}
	
} 
