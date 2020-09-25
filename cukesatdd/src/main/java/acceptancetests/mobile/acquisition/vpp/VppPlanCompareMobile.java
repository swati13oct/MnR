package acceptancetests.mobile.acquisition.vpp;

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

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
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
import io.appium.java_client.AppiumDriver;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.tfn.CampaignTFNPage;
import pages.acquisition.ulayer.AboutUsAARPPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AddDrugDetails;
import pages.acquisition.ulayer.ComparePlansPage;
import pages.acquisition.ulayer.ContactUsAARPPage;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.FindCarePage;
import pages.acquisition.ulayer.MultiCountyModalPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.ProviderSearchPage;
import pages.acquisition.ulayer.RequestHelpAndInformationPage;
import pages.acquisition.ulayer.RequestMailedInformation;
import pages.acquisition.ulayer.SavingsOppurtunity;
import pages.acquisition.ulayer.SiteMapAARPPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.VPPTestHarnessPage;
import pages.acquisition.ulayer.VisitorProfilePage;
import pages.acquisition.ulayer.VisitorProfileTestHarnessPage;
import pages.acquisition.ulayer.ZipcodeLookupHomePage;
import pages.mobile.acquisition.bluelayer.SiteMapUMSPageMobile;
import pages.mobile.acquisition.ulayer.AboutUsAARPPageMobile;
import pages.mobile.acquisition.ulayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.ulayer.AddDrugDetailsMobile;
import pages.mobile.acquisition.ulayer.AgentsnBrokersAARPPageMobile;
import pages.mobile.acquisition.ulayer.ComparePlansPageMobile;
import pages.mobile.acquisition.ulayer.ContactUsAARPPageMobile;
import pages.mobile.acquisition.ulayer.DisclaimersAARPPageMobile;
import pages.mobile.acquisition.ulayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.ulayer.MultiCountyModalPageMobile;
import pages.mobile.acquisition.ulayer.PlanDetailsPageMobile;
import pages.mobile.acquisition.ulayer.PrivacyPolicyAARPPageMobile;
import pages.mobile.acquisition.ulayer.ProviderSearchPageMobile;
import pages.mobile.acquisition.ulayer.SavingsOppurtunityMobile;
import pages.mobile.acquisition.ulayer.SiteMapAARPPageMobile;
import pages.mobile.acquisition.ulayer.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.ulayer.VisitorProfilePageMobile;

/**
 * Functionality: VPP flow for AARP site
 */

public class VppPlanCompareMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;

	/**
	 * @toDo:user is on AARP medicare acquisition site landing page
	 */
	@Given("^the user is on AARP medicare acquisition site landing page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		// aquisitionhomepage.openVPPPage();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	/**
	 * @toDo:user user selects a provider
	 */
	@When("^user selects a provider and retuns to VPP page in ulayer$")
	public void user_selects_provider_and_return_vpp_page_ulayer() {
		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			VPPPlanSummaryPageMobile plansummaryPage = providerSearchPage.selectsProvider();
			Assert.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);

		}
	}

	/**
	 * @toDo:Verify X out of Y provider covered information is displayed on Plan
	 *              Summary page
	 */
	@Then("^Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer$")
	public void verify_providers_covered_ulayer(DataTable Planname) {

		List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String planName = plannameAttributesMap.get("PlanName");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyproviderName(planName);
	}

	
	@When("^user selects a Hospitals and retuns to VPP page in ulayer$")
	public void user_selects_Hospitals_and_return_vpp_page_ulayer() {
		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			VPPPlanSummaryPageMobile plansummaryPage = providerSearchPage.selectsHospitals();
			Assert.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);

		}
	}
	/**
	 * @toDo:user Click on Is my Provider covered link
	 */
	@When("^the user Click on Is my Provider covered link Ulayer$")
	public void clickonProvidercoveredlink(DataTable Planname) {
		{
			List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
			Map<String, String> plannameAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < plannameAttributesRow.size(); i++) {

				plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
						plannameAttributesRow.get(i).getCells().get(1));
			}
			String planName = plannameAttributesMap.get("PlanName");
			getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
			VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

			ProviderSearchPageMobile providerSearchPage = plansummaryPage.clicksOnIsProviderCovered(planName);
			if (providerSearchPage != null) {
				getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
			}

		}
	}

	/**
	 * @throws InterruptedException
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user performs plan search using following information in the AARP site$")
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

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = null;
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
	 * @toDo:user clicks on contactus link of aboutus
	 */
	@And("^user clicks on contactus link of aboutus page$")
	public void click_contactus() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ContactUsAARPPageMobile contactUsAARPPage = aquisitionhomepage.contactUsFooterClick();
		if (contactUsAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_Contact_US_PAGE, contactUsAARPPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("contactus page not found");
		}
	}

	/**
	 * @toDo:user clicks on sitemap link of contactus
	 */
	@And("^user clicks on sitemap link of contactus page$")
	public void click_sitemap() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		SiteMapUMSPageMobile siteMapAARPPage = aquisitionhomepage.siteMapFooterClick();
		if (siteMapAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_SITE_MAP_PAGE, siteMapAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("sitemap page not found");
		}
	}

	/**
	 * @toDo:user clicks on Aboutus link from footer
	 */
	@And("^user clicks on Aboutus link from footer of the AARP Medicare Plans home page$")
	public void click_aboutus() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AboutUsAARPPageMobile aboutUsAARPPage = aquisitionhomepage.aboutUsFooterClick();
		if (aboutUsAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_ABOUT_US_PAGE, aboutUsAARPPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Aboutus page not found");
		}

	}

	@When("^the user enters zipcode on health plans page in the AARP site$")
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

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = null;
		plansummaryPage = aquisitionhomepage.searchPlanOnHealthPlansPage(zipcode, county, isMultiCounty);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	/*
	 * @When("^the user adds plan from plan search using following information in the AARP site$"
	 * ) public void
	 * the_user_adds_plan_from_plan_search_using_following_information_in_the_AARP_site
	 * (DataTable givenAttributes) {
	 * 
	 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	 * Map<String, String> memberAttributesMap = new HashMap<String, String>(); for
	 * (int i = 0; i < memberAttributesRow.size(); i++) {
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); } String zipcode =
	 * memberAttributesMap.get("Zip Code"); String county =
	 * memberAttributesMap.get("County Name"); String isMultiCounty =
	 * memberAttributesMap.get("Is Multi County");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	 * getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY,
	 * isMultiCounty); AcquisitionHomePage aquisitionhomepage =
	 * (AcquisitionHomePage) getLoginScenario()
	 * .getBean(PageConstants.ACQUISITION_HOME_PAGE); VPPPlanSummaryPage
	 * plansummaryPage = null; if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
	 * plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty(zipcode); }
	 * else { plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county); }
	 * if (plansummaryPage != null) {
	 * getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
	 * plansummaryPage); } else {
	 * Assert.fail("Error Loading VPP plan summary page"); } }
	 */

	/**
	 * @toDo:user validates plan count for all plan types on plan summary page
	 */
	@Then("^user validates plan count for all plan types on plan summary page in the AARP site$")
	public void user_validates_following_benefits_ui_aarp() {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assert.assertTrue("Error validating plans in  VPP plan summary page",
				plansummaryPage.validateVPPPlanSummaryPage());
		String SiteName = "AARP_ACQ";
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
	}

	/**
	 * @toDo:user views the plans of the below plan type
	 */
	@And("^the user views the plans of the below plan type in AARP site$")
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
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		if (!plantype.equalsIgnoreCase("MS"))
			plansummaryPage.handlePlanYearSelectionPopup();
	}

	/**
	 * @toDo:user views the plans of the below plan type and select current year for
	 *            AEP
	 */

	@And("^the user views the plans of the below plan type in AARP site and select Current year$")
	public void user_performs_planSearch_in_aarp_site_current_year(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		plansummaryPage.CheckClick_CurrentYear_Plans();
	}

	@And("^the user views the plans of the below plan type in AARP site and select Next year$")
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
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		if (!plantype.equalsIgnoreCase("MS"))
			plansummaryPage.handlePlanYearSelectionPopup();
	}

	/**
	 * @toDo:
	 */
	/**/
	@And("^selects drug details for other drugs in ums site$")
	public void user_selects_drug_details_for_other_drugs(DataTable data) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		String quantity = memberAttributesRow.get(1).getCells().get(1);
		String frequency = memberAttributesRow.get(2).getCells().get(1);

		AddDrugDetailsMobile DrugDetails = (AddDrugDetailsMobile) getLoginScenario()
				.getBean(PageConstants.ADD_DRUG_DETAILS);

		/*
		 * if(drug.equalsIgnoreCase("Lipitor"))
		 * DrugDetails.selectDosageAttribute("//li[@data-index='1']");
		 */

		DrugDetails.selectDosageAttribute(drug);
		DrugDetails.selectQnty(quantity);
		DrugDetails.selectFrequency(frequency);

		DrugDetails.continueAddDrugDetailsModNoSaving();

	}

	@Then("^user adds drug to drug cost estimator flow for the given plan name in AARP site$")
	public void the_user_adds_below_drugs_to_drug_cost_estimator_flow_for_the_given_plan_name_on_AARP_site(
			DataTable data) throws Throwable {

		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(1).getCells().get(1);
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		boolean isDrugPresent = dce.isDrugPresent(drug);
		if (!isDrugPresent) {
			AddDrugDetailsMobile addDrugDetails = dce.addDrug(drug.split(" ")[0]);
			if (null != addDrugDetails) {
				getLoginScenario().saveBean(PageConstants.ADD_DRUG_DETAILS, addDrugDetails);
			} else
				Assert.fail("Drug Details content not loaded");
		}

	}

	@And("^the user clicks on return link to navigate to plan summary$")
	public void clickOnReturnLink() {
		DrugCostEstimatorPageMobile dcePage = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dcePage.clickReturnToSummaryLink();
	}

	@And("^the user clicks on Back to Plans button in AARP site and Navigates to new Plan Compare$")
	public void the_user_clicks_on_Back_to_Plans_button_in_AARP_site_and_Navigates_to_new_Plan_Compare()
			throws Throwable {
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		ComparePlansPageMobile planComparePage = dce.clickBtnBackTonewPlancomparenew();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		}
	}

	@Then("^the user validates the added drugs on See your Estimated Costs page in AARP site$")
	public void the_user_validates_the_added_drugs_on_See_your_Estimated_Costs_page_in_AARP_site(DataTable data)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		/* DCE cost Estimator */
		String cost;
		cost = dce.getCostText().getText();
		/*
		 * if(cost.contains("$")) cost=cost.split("$")[1];
		 */

		String drug = null;
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			drug = memberAttributesRow.get(i).getCells().get(1).toLowerCase().trim();
			if (dce.getHdrDrugName().get(i).getText().toLowerCase().trim().split(" ")[0]
					.contains(drug.split(" ")[0].trim().toLowerCase()))
				Assert.assertTrue(dce.getHdrDrugName().get(i).getText().toLowerCase().trim() + "is found", true);
			else
				Assert.assertTrue(dce.getHdrDrugName().get(i).getText().toLowerCase().trim() + "isn't found", false);
		}

		// dce.validateTotalEstimatedAnnualDrugCosts(totalAnnualDrugCost);
	}

	@Then("^the user selects a pharmacy from the list of pharmacies in AARP site$")
	public void the_user_selects_a_pharmacy_from_the_list_of_pharmacies_in_AARP_site(DataTable data) throws Throwable {

		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacyName = memberAttributesRow.get(0).getCells().get(1);

		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.verifyPharmacyResults();
		for (int i = 0; i < dce.getLstPharmacyNames().size(); i++)
			if (dce.getLstPharmacyNames().get(i).getText().toLowerCase().contains(pharmacyName.toLowerCase())) {
				dce.getLstSelectPharmacy().get(i).click();
				break;
			}

		dce.clickButtonViewCost();
	}

	@Then("^the user clicks on the Pick a pharmacy button in the DCE flow in AARP site$")
	public void the_user_clicks_on_the_Pick_a_pharmacy_button_in_the_DCE_flow_in_AARP_site() throws Throwable {

		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		dce.pickAPharmacy();
	}

	@When("^the user selects the pharmacy type and distance in AARP site$")
	public void the_user_selects_the_pharmacy_type_and_distance_in_AARP_site(DataTable data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacyType = memberAttributesRow.get(0).getCells().get(1);
		String distance = memberAttributesRow.get(1).getCells().get(1);

		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		dce.selectRadius(dce.getMilesSelection(), distance);
		dce.selectPharmacyType(pharmacyType);

	}

	/**
	 * @toDo:
	 */
	@When("^user successfully adds drug$")
	public void user_successfully_adds_drug(DataTable data) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String isBranded = memberAttributesMap.get("Is Branded Drug");
		String drug = memberAttributesMap.get("Drug");
		AddDrugDetailsMobile DrugDetails = (AddDrugDetailsMobile) getLoginScenario()
				.getBean(PageConstants.ADD_DRUG_DETAILS);
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		if (isBranded.trim().equalsIgnoreCase("YES")) {

			SavingsOppurtunityMobile savingsOppurtunity = DrugDetails.continueAddDrugDetailsModWithSaving();
			// savingsOppurtunity.switchToGeneric();
			dce = savingsOppurtunity.savedrugbutton();

		} else {
			dce = DrugDetails.continueAddDrugDetailsModNoSaving();
		}
		Assert.assertTrue("Drug not added", null != dce);
		dce.validateAddedDrug(drug);
	}

	/**
	 * @toDo:
	 */
	@And("^selects drug details in ums site$")
	public void user_selects_drug_details(DataTable data) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		String quantity = memberAttributesRow.get(1).getCells().get(1);
		String frequency = memberAttributesRow.get(2).getCells().get(1);

		AddDrugDetailsMobile DrugDetails = (AddDrugDetailsMobile) getLoginScenario()
				.getBean(PageConstants.ADD_DRUG_DETAILS);

		/*
		 * if(drug.equalsIgnoreCase("Lipitor"))
		 * DrugDetails.selectDosageAttribute("//li[@data-index='1']");
		 */

		DrugDetails.selectDosageAttribute(drug);
		DrugDetails.selectQnty(quantity);
		DrugDetails.selectFrequency(frequency);
	}

	@When("^user successfully adds drug in the ums site$")
	public void user_successfully_adds_drugs(DataTable data) throws InterruptedException {

		AddDrugDetailsMobile DrugDetails = (AddDrugDetailsMobile) getLoginScenario()
				.getBean(PageConstants.ADD_DRUG_DETAILS);
		DrugCostEstimatorPageMobile dce = (DrugCostEstimatorPageMobile) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		// SavingsOppurtunity savingsOppurtunity =
		// DrugDetails.continueAddDrugDetailsModWithSaving();

		DrugDetails.continueAddDrugDetailsModNoSaving();
		SavingsOppurtunityMobile savingsOppurtunity = new SavingsOppurtunityMobile(wd);
		dce = savingsOppurtunity.savedrugbutton();

		if (null != savingsOppurtunity) {
			getLoginScenario().saveBean(PageConstants.SAVING_OPPORTUNITY, savingsOppurtunity);
		}

		/*
		 * String drug = memberAttributesMap.get("Drug Name1"); AddDrugDetails
		 * DrugDetails = (AddDrugDetails)
		 * getLoginScenario().getBean(PageConstants.ADD_DRUG_DETAILS);
		 * DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
		 * .getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE); if
		 * (isBranded.trim().equalsIgnoreCase("YES")) {
		 * 
		 * SavingsOppurtunity savingsOppurtunity =
		 * DrugDetails.continueAddDrugDetailsModWithSaving();
		 * //savingsOppurtunity.switchToGeneric(); dce =
		 * savingsOppurtunity.savedrugbutton();
		 * 
		 * } else { dce = DrugDetails.continueAddDrugDetailsModNoSaving(); }
		 * Assert.assertTrue("Drug not added", null != dce);
		 * dce.validateAddedDrug(drug);
		 */
	}

	/**
	 * @toDo:
	 */
	@And("^I access the DCE tool on aarp site$")
	public void accessDCETool(DataTable attributes) {
		List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		pages.mobile.acquisition.dce.ulayer.DrugCostEstimatorPageMobile dce = plansummaryPage.navigateToDCE(plantype);
		if (dce != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
		}
	}

	@And("the user selects plan year$")
	public void the_user_selects_plan_year(DataTable givenAttributes) {

		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planYear = givenAttributesMap.get("Plan Year");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.handlePlanYearSelectionPopup(planYear);
	}

	@And("^the user selects plan year for AARP site$")
	public void user_selects_plan_year_AARP(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planYear = givenAttributesMap.get("Plan Year");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.handlePlanYearSelectionPopup(planYear);
	}

	/**
	 * @toDo:select multiple plans to compare in MA and click on compare plan link
	 */
	@And("^I select multiple plans to compare in MA and click on compare plan link$")
	public void I_select_all_3_plans_to_compare(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String plantype = givenAttributesMap.get("plan type");
		int plansForCompare = 0;
		if (plantype.equalsIgnoreCase("MedicareAdvantage")) {
			plansummaryPage.clickonViewPlans();
			plansummaryPage.handlePlanYearSelectionPopup();
			plansForCompare = plansummaryPage.checkAllMAPlans();
		} else {
			plansummaryPage.clickOnPDPPlans();
			plansummaryPage.handlePlanYearSelectionPopup();
			plansForCompare = plansummaryPage.checkAllPDPlans();
		}
		getLoginScenario().saveBean(PageConstants.plansForCompare, String.valueOf(plansForCompare));
		ComparePlansPageMobile comparePlansPage = plansummaryPage.clickOnCompareLinkAARP(plantype);
		if (comparePlansPage != null) {
			getLoginScenario().saveBean(PageConstants.TeamC_Plan_Compare_Page, comparePlansPage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	/**
	 * @toDo:user validate the print and email link option in plan compare
	 */
	@When("^the user validate the print and email link option in plan compare$")
	public void user_validate_print_and_email_link_option_in_plan_compare() {

		ComparePlansPageMobile comparePlansPage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		comparePlansPage.validateprintandemail();
	}

	/**
	 * @toDo:the user validating email and print option in plan compare
	 */
	@Then("^the user validating email and print option in plan compare$")
	public void user_validating_print_and_email_option_in_plan_compare() {

		ComparePlansPageMobile comparePlansPage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		comparePlansPage.validatingprintandemail();
	}

	/**
	 * @toDo:click back to all plans button and verify that all plans are still
	 *             selected
	 */
	@Then("^I click back to all plans button and verify that all plans are still selected$")
	public void verifyAllPlansStillSelected() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String plansForCompare = (String) getLoginScenario().getBean(PageConstants.plansForCompare);

		plansummaryPage.clickonBackToAllPlans();
		if (plansummaryPage.validateAllPlansChecked(plansForCompare)) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating all plans are still selected");
	}

	/**
	 * @toDo:user view plan details of the above selected plan in AARP site and
	 *            validates
	 */
	@When("^the user view plan details of the above selected plan in AARP site and validates$")
	public void user_views_plandetails_selected_plan_aarp(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String PlanPremium = vppPlanSummaryPage.getPlanPremium(PlanName, planType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		vppPlanSummaryPage.clickOnViewMoreForPlan(PlanName);
		PlanDetailsPageMobile vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Details Page");

	}

	@Then("^the user view plan details of the first plan in the given plan type in AARP site and validates$")
	public void user_views_plandetails_selected_plantype_aarp() {
		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanDetailsPageMobile vppPlanDetailsPage = vppPlanSummaryPage.navigateToFirstPlanForPlanDetails(planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Details Page");

	}

	@When("^the user validates the pdf section$")
	public void userValidatesPDFSection() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatePdfSection(planType);
	}

	@Then("^User clicks on Back to Plans link and navigate back to plan summary in AARP site$")
	public void User_clicks_BackToPlansLink_and_navigate_back_to_plan_summary_in_AARP_site() {

		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		VPPPlanSummaryPage plansummaryPage = planDetailsPage.navigateBackToPlanSummaryPageFromDetailsPage();
		if (plansummaryPage != null) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the Plan Summary Page");
	}

	@And("^User click on add to compare checkbox and click on view details link on AARP$")
	public void user_click_on_compare_checkbox_AARP() {
		VPPPlanSummaryPage vppplansummarypage = (VPPPlanSummaryPage) loginScenario
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppplansummarypage.clickCompareChkBox();
		PlanDetailsPage planDetailsPage = vppplansummarypage.clickViewDetails_AddedToCompare();
		if (planDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetailsPage);
		}
	}

	@Then("^I uncheck and go back to the vpp page to validate for AARP$")
	public void uncheck_and_validate_vpp_page_for_AARP() {
		PlanDetailsPage plandetailspage = (PlanDetailsPage) loginScenario.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		plandetailspage.clickCompareBox();
		VPPPlanSummaryPage vppsummarypage = plandetailspage.navigateBackToPlanSummaryPageFromDetailsPage();
		vppsummarypage.verifyPlanComapreCheckboxIsUncheckedforFirstPlan();
	}

	/**
	 * @toDo:user validates the available plans for selected plan types
	 */
	@Then("^the user validates the available plans for selected plan types in the AARP site$")
	public void user_validates_available_plans_aarp() {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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

	/**
	 * @throws InterruptedException
	 * @toDo:user validates plan summary for the below plan
	 */
	@And("^the user validates plan summary for the below plan in the AARP site$")
	public void user_validates_plan_summary(DataTable planAttributes) throws InterruptedException {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assert.assertTrue("Error loading specific plan summary in VPP plan summary page",
				plansummaryPage.getSpecificPlanInfo(planName));
	}

	@Then("^the user view plan details of the above selected plan in AARP site vpp$")
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

	@Then("^the user clicks on both top and bottom back to plans link and validates its redirection AARP$")
	public void the_user_clicks_on_both_topand_bottom_back_to_plans_link_and_validates_its_redirection()
			throws InterruptedException {
		// getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
		// vppPlanDetailsPage);
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatetopbacktoplanslink();
		vppPlanDetailsPage.browserBack();
		vppPlanDetailsPage.validatedownbacktoplanslink();

	}

	@Then("^the user selects plans to add to plan compare and navigates to Plan compare page$")
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

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		TFN = plansummaryPage.GetTFNforPlanType();

		PlanPremium = plansummaryPage.getPlanPremium(PlanName, PlanType);
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

		ComparePlansPageMobile comparePlansPage = plansummaryPage.selectplantocompare(PlanType, PlanName);
		if (comparePlansPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, comparePlansPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Compare Page");
	}

	@Then("^the user validate the print and email links on the plan Details Page$")
	public void user_validate_print_and_email_links_on_the_plan_Details_Page() {

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatePrintandEmailOnPlanDetails();
	}

	/**
	 * @toDo:the user validates the functionality of email and print buttons on the
	 *           plan Details Page
	 */
	@Then("^the user validates the functionality of email and print buttons on the plan Details Page$")
	public void user_validates_the_functionality_of_emailandprintbuttons_on_the_plan_Details_Page() {

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
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

	@Then("^the user validates the following Additional Benefits Plan details for the plan$")
	public void the_user_validates_the_following_Additional_Benefits_Plan_details_for_the_plan(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String benefitType = memberAttributesMap.get("Benefit Type");
		String expectedText = memberAttributesMap.get("Expected Text");
		System.out.println("Validating the following Additional benefits : " + benefitType);

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(benefitType,
				expectedText);
		Assert.assertTrue("Validation failed : Expected text not displayed for Additional Benefit - " + benefitType,
				validationFlag);
	}

	@Then("^the user validates the following Medical Benefits Plan details for the plan$")
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

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.validatingMedicalBenefitTextInPlanDetails(benefitType,
				expectedText);
		Assert.assertTrue("Validation failed : Expected text not displayed for Medical Benefit - " + benefitType,
				validationFlag);

	}

	@Then("^the user validates the following Medical Benefits for the plan in Plan Compare Page$")
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
		System.out.println("Validating the following Medical benefits on Plan Compare : " + benefitType);

		ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		boolean validationFlag = comparePlansPage.validatingMedicalBenefitTextInPlanDetails(benefitType, expectedText,
				PlanName);
		Assert.assertTrue("Validation failed : Expected text not displayed for Medical Benefit - " + benefitType,
				validationFlag);

	}

	// Steps added to validate Cancel button on Multi County pop-up on Home, SubNav
	// and VPP plan search
	@When("^the user performs plan search using following MultiCounty Zip information in the AARP site$")
	public void the_user_performs_plan_search_using_following_MultiCounty_Zip_information_in_the_AARP_site(
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
	// Steps added to validate Cancel button on Multi County pop-up on Home, SubNav
	// and VPP plan search

	@Then("^the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page$")
	public void the_user_validates_the_Cancel_button_for_Multi_COunty_Pop_up_lands_on_enter_Zip_code_Page()
			throws Throwable {
		MultiCountyModalPage multiCountyModalPage = (MultiCountyModalPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean Validation_Flag = multiCountyModalPage.validateMultiCounty_CancelButton();
		Assert.assertTrue("Validation failed : Cancel button Validation for Multi County Pop-up Failed ",
				Validation_Flag);

	}
	// Steps added to validate Cancel button on Multi County pop-up on Home, SubNav
	// and VPP plan search

	@When("^the user performs plan search using following MultiCounty Zip in Header Sun Nav in the AARP site$")
	public void the_user_performs_plan_search_using_following_MultiCounty_Zip_in_Header_Sun_Nav_in_the_AARP_site(
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
	// Steps added to validate Cancel button on Multi County pop-up on Home, SubNav
	// and VPP plan search

	@When("^the user performs Change Location on Plan Summary Page using following MultiCounty Zip information in the AARP site$")
	public void the_user_performs_Change_Location_on_Plan_Summary_Page_using_following_MultiCounty_Zip_information_in_the_AARP_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		MultiCountyModalPageMobile multiCountyModalPage = plansummaryPage
				.VPP_ChangeLocationValidateMultiCOuntyPopUp(zipcode);

		if (multiCountyModalPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, multiCountyModalPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
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
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); } String zipcode =
	 * memberAttributesMap.get("Zip Code"); String county =
	 * memberAttributesMap.get("County Name");
	 * getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
	 * getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
	 * AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)
	 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
	 * aquisitionhomepage.OurPlansPDPLanding(); WelcomePage welcomeOLEPage =
	 * aquisitionhomepage.ZipcodeSearchToOLE(zipcode); if (welcomeOLEPage != null) {
	 * getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
	 * } else { Assert.fail("Error Loading OLE Welcome page"); } }
	 * 
	 * @Then("^the user validates the following Plan details for the plan$") public
	 * void the_user_validates_the_following_Plan_details_for_the_plan(DataTable
	 * givenAttributes) throws Throwable { List<DataTableRow> memberAttributesRow =
	 * givenAttributes.getGherkinRows(); Map<String, String> memberAttributesMap =
	 * new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); } String benefitType =
	 * memberAttributesMap.get("Benefit Type"); String expectedText =
	 * memberAttributesMap.get("Expected Text");
	 * System.out.println("Validating the following Additional benefits : "
	 * +benefitType); PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage)
	 * getLoginScenario() .getBean(PageConstants.VPP_PLAN_DETAILS_PAGE); boolean
	 * validationFlag =
	 * vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(benefitType,
	 * expectedText); Assert.
	 * assertTrue("Validation failed : Expected text not displayed for Additional Benefit - "
	 * +benefitType,validationFlag); }
	 */
	@Then("^User validates the VPP promowidjet for specifc plans$")
	public void User_validates_the_promo_widjet(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		vppPlanSummaryPage.validatePromoWidjetAArp(planName);
		if (vppPlanSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanSummaryPage);
		} else
			Assert.fail("Error in validating the Plan Details Page");

	}

	/**
	 * @toDo:the user is on AARP medicare acquisition site VPP Plan Summary page
	 *           after hits Campaign URL
	 */
	@Given("^the user is on AARP medicare acquisition site VPP Plan Summary page after hits Campaign URL$")
	public void the_user_on_aarpmedicareplans_Campaign_landing_page() throws Throwable {

		String County = "St. Louis County";
		String ZipCode = "63043";
		String PlanYear = "2020";
		String SiteName = "AARP_ACQ";

		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);

		String OLE_Campaign_URL = "https://stage-aarpmedicareplans.uhc.com/health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731#/plan-summary <>";

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

	@Given("^the user is on AARP medicare acquisition site VPP page after hits Campaign URL$")
	public void the_user_on_aarp_Campaign_landing_page() throws Throwable {

		String County = "St. Louis County";
		String ZipCode = "63043";
		String PlanYear = "2020";
		String SiteName = "AARP_ACQ";

		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);

		String OLE_Campaign_URL = "https://www.team-acme-aarpmedicareplans.ocp-elr-core-nonprod.optum.com/health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731#/plan-summary <>";

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

	@When("^the user navigates to the plan Details page$")
	public void user_navigates_to_plan_details_page(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		System.out.println("Plan name is " + PlanName + "Plan type is " + planType);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName, planType);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Details Page");

	}

	@Then("^the user Click on Look up your Provider button$")
	public void user_Clicks_on_Look_upyourProvider_button_on_PlanDetailsPage() {

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		ProviderSearchPage providerSearchPage = vppPlanDetailsPage.validateLookUpYourProviderButton();
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}

	}

	/**
	 * @toDo:select all 3 plans to compare and click on compare plan link
	 */
	@And("^I select all 3 plans to compare and click on compare plan link in AARP$")
	public void I_select_all_3_plans_to_compare_AARP() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.checkAllMAPlans();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPageMobile planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@And("^I select \"([^\"]*)\" plans to compare and click on compare plan link in AARP$")
	public void i_select_plans_to_compare_and_click_on_compare_plan_link_in_AARP(String planType) throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if (planType.equals("MAPD")) {
			// plansummaryPage.clickonViewPlans();
			plansummaryPage.checkAllMAPlans();
			System.out.println("Selected All MAPD plans for Plan Compare");
		} else if (planType.equals("PDP")) {
			// plansummaryPage.clickOnPDPPlans();
			plansummaryPage.checkAllPDPlans();
			System.out.println("Selected All PDP plans for Plan Compare");
		}
		ComparePlansPageMobile planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@And("^I Click on DCE link on Plan compare for AARP$")
	public void I_Click_On_DCE_link_on_Plan_Compare_for_AARP() {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
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

	@And("^I Click on Look up your doctor link on Plan compare in AARP$")
	public void I_Click_on_Look_up_your_doctor_link_on_Plan_compare_in_AARP() throws InterruptedException {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
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

	@And("^I click on Get Started on and Add Provider from find care page in AARP$")
	public void I_click_on_Get_Started_and_Add_Provider_from_find_care_page_in_AARP() throws Exception {
		FindCarePage findCarePage = (FindCarePage) getLoginScenario().getBean(PageConstants.FIND_CARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComparePlansPage planComparePage = findCarePage.getstarted();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@Then("^Verify provider is count is updated on plan compare page in AARP$")
	public void Verify_provider_is_count_is_updated_on_plan_compare_page() throws Exception {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
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

	@Then("^user validates Drug information is reflected on plan compare page in AARP$")
	public void user_validates_Drug_information_is_reflected_on_plan_compare_page_in_AARP() throws Exception {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
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

	@Then("^user validates selected plans can be saved as favorite on AARP site$")
	public void user_validates_selected_plan_can_be_saved_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateAbilityToSavePlans(pdp_savePlanNames, planType);
		// plansummaryPage.validatePlansAreSaved(pdp_savePlanNames, planType);
		// //commented out because the previous line already validates after saving plan

		// ----- SNP plan type ---------------------------
		planType = "SNP";
		plansummaryPage.viewPlanSummary(planType);
		plansummaryPage.handlePlanYearSelectionPopup();
		plansummaryPage.validateAbilityToSavePlans(snp_savePlanNames, planType);
		// plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType);
		// //commented out because the previous line already validates after saving plan
	}

	@Then("^user saves two plans as favorite on AARP site$")
	public void user_saves_two_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String savePlanNames = memberAttributesMap.get("Test Plans");
		String planType = memberAttributesMap.get("Plan Type");

		// ----- MA plan type ----------------------------
		// plansummaryPage.viewPlanSummary(planType);
		// plansummaryPage.CheckClick_CurrentYear_Plans();

		switch (planType) {
		case "MAPD":
			plansummaryPage.viewPlanSummary(planType);
			if (!planType.equalsIgnoreCase("MS"))
				plansummaryPage.handlePlanYearSelectionPopup();
			plansummaryPage.savePlans(savePlanNames, planType);
			break;
		case "MA":
			plansummaryPage.viewPlanSummary(planType);
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

	@Then("^user saves two ms plans as favorite on AARP site$")
	public void user_saves_two_ms_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String ms_savePlanNames = memberAttributesMap.get("MS Test Plans");

		// ----- MS plan type ----------------------------
		plansummaryPage.saveMSPlans(ms_savePlanNames);

	}

	@Then("^user gets a create profile prompt on AARP site$")
	public void user_saves_two_plans_as_favorite_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.validateCreateProfilePrompt();

		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

	}

	@And("^user click on continue as guest button on AARP site$")
	public void user_click_on_continue_as_guest_button_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		VisitorProfilePageMobile visitorProfilePage = plansummaryPage.continueAsGuest();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);

	}

	@And("^user click on Sign In from the Popup on AARP site$")
	public void user_click_on_Sign_In_On_Popup_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		VisitorProfilePageMobile visitorProfilePage = plansummaryPage.continueAsGuest();

		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);

	}

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change from Home on AARP site$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Home_on_AARP_site(
			DataTable givenAttributes) throws InterruptedException {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
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

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change from Shop For a Plan on AARP site$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Shop_For_a_Plan_on_AARP_site(
			DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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

	@Then("^user validates saved favorite plans will be stored within same session after zipcode change within VPP page on AARP site$")
	public void user_validates_saved_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_within_VPP_page_on_AARP_site(
			DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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
			Assert.assertTrue("PROBLEM - plansummaryPage is null", false);
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

	@Then("^user validates ability to unsave a saved plan on AARP site$")
	public void user_validates_ability_to_unsave_a_saved_plan_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change from Home on AARP site$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Home_on_AARP_site(
			DataTable givenAttributes) throws InterruptedException {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String ma_savePlanNames = memberAttributesMap.get("MA Test Plans");
		String pdp_savePlanNames = memberAttributesMap.get("PDP Test Plans");
		String snp_savePlanNames = memberAttributesMap.get("SNP Test Plans");
		String planYear = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
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

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change from Shop For a Plan on AARP site$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_from_Shop_For_a_Plan_on_AARP_site(
			DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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
			Assert.assertTrue("PROBLEM - plansummaryPage is null", false);
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

	@Then("^user validates unsave favorite plans will be stored within same session after zipcode change within VPP page on AARP site$")
	public void user_validates_unsave_favorite_plans_will_be_stored_within_same_session_after_zipcode_change_within_VPP_page_on_AARP_site(
			DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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
				Assert.assertTrue("PROBLEM - plansummaryPage is null", false);
			}
		} else {
			Assert.assertTrue("PROBLEM - plansummaryPage is null", false);
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

	@Then("^user validates email option on AARP site$")
	public void user_validates_email_option_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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

	@Then("^user validates print option on AARP site$")
	public void user_validates_print_option_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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

	@Then("^user validates email functionality with invalid and valid email address on AARP site$")
	public void user_validates_email_functionality_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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

	@Then("^user validates print functionality on AARP site$")
	public void user_validates_print_functionality_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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

	@Then("^user closes the original tab and open new tab for AARP site$")
	public void user_closes_the_original_tab_and_open_new_tab_for_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.closeOriginalTabAndOpenNewTab();
	}

	@Then("^user validates plans remain saved within same session for AARP site$")
	public void user_validates_plans_remain_saved_within_same_session(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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
		// planType="SNP";
		// System.out.println("Proceed to validate "+planType+" saved plan(s) are still
		// saved");
		// plansummaryPage.viewPlanSummary(planType);
		// plansummaryPage.handlePlanYearSelectionPopup();
		// plansummaryPage.validatePlansAreSaved(snp_savePlanNames, planType);
	}
	// ^^^ note: added for US1598162

	@When("^the user navigates to the request mailed information in AARP site and validates page is loaded$")
	public void the_user_navigates_to_the_request_mailed_information_in_AARP_site_and_validates_page_is_loaded()
			throws Throwable {
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario()
				.getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
		RequestMailedInformation requestmailedinformation = requestHelpAndInformationPage
				.navigateToRequestMailedinformation();
		if (requestmailedinformation != null) {
			getLoginScenario().saveBean(PageConstants.REQUEST_MAILED_INFORMATION, requestmailedinformation);
		} else {
			Assert.fail("Error in loading requestAgentAppointmentPage");
		}
	}

	@When("^the user fills the Enrollment guide plan form and validate the order confirmation page$")
	public void the_user_fills_the_Enrollment_guide_plan_form_and_validate_the_order_confirmation_page(
			DataTable attributes) throws Throwable {
		if (!MRScenario.environment.equalsIgnoreCase("offline")) {
			RequestMailedInformation requestmailedinformation = (RequestMailedInformation) getLoginScenario()
					.getBean(PageConstants.REQUEST_MAILED_INFORMATION);
			List<DataTableRow> givenAttributesRow = attributes.getGherkinRows();
			Map<String, String> givenAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < givenAttributesRow.size(); i++) {

				givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
						givenAttributesRow.get(i).getCells().get(1));
			}
			boolean isFormSubmitted = requestmailedinformation.submitAgentAppointment(givenAttributesMap);
			if (isFormSubmitted) {
				System.out.println("Successfully submitted the Appointment form");
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error submitting the form or loading the Confirmation page");
			}
		} else {
			System.out.println("Skipping the submit functionality in Offline-Prod environment");
		}
	}

	@Then("^the AARP site user clicks on Start Application Button proceed to next pages for getting resume application key")
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
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.MedSupFormValidation(DateOfBirth);
		String resumeKey = plansummaryPage.StartApplicationButton(FirstName, LastName);
		getLoginScenario().saveBean(VPPCommonConstants.RESUMEKEY, resumeKey);

	}

	@Then("^user clicks on resume application button in the AARP site")
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

	@And("^the user signs in with optum Id credentials to resume application in AARP site$")
	public void the_user_signs_in_with_optum_Id_credentials_resume_application_in_AARP_site(DataTable credentials) {
		List<DataTableRow> plannameAttributesRow = credentials.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String username = plannameAttributesMap.get("User Name");
		String password = plannameAttributesMap.get("Password");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		// plansummaryPage.signIn(username, password);
	}

	@Then("^user enters data to resume the application in the AARP site")
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

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		if (applicationType.equalsIgnoreCase("Retrive")) {
			ApplicationID = memberAttributesMap.get("ApplicationID");
		}
		plansummaryPage.EnterDataForResumeApp(ApplicationID, DOB, zipcode);

	}

	@Then("^user validates the resume application processed in the AARP site")
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
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.ResumeApplicationButtonValidation(FirstName, LastName);

	}

	@Then("^user validates the Retrive application in the AARP site")
	public void retrive_application_processed(DataTable givenAttributes) throws Throwable {
		System.out.println("***The user validates the Retrive application***");
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String ApplicationID = memberAttributesMap.get("ApplicationID");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.RetrieveApplicationButtonValidation(ApplicationID);

	}

	@When("^the user performs plan search using Standalone Zipcode information in the AARP site$")
	public void the_user_performs_plan_search_using_Standalone_Zipcode_information_in_the_AARP_site(
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

	@Then("^the user validates the following Additional Benefits of Plan for the plan in AARP$")
	public void the_user_validates_the_following_Additional_Benefits_of_Plan_for_the_plan_in_AARP(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> additionalBenefits = givenAttributes.getGherkinRows();

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatingAdditionalBenefitTextInPlanDetails(additionalBenefits);
	}

	@Then("^the user validates the following Medical Benefits of Plan for the plan in AARP$")
	public void the_user_validates_the_following_Medical_Benefits_of_Plan_for_the_plan_in_AARP(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> medicalBenefits = givenAttributes.getGherkinRows();

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validatingMedicalBenefitTextInPlanDetails(medicalBenefits);
		// Assert.assertTrue("Validation failed : Expected text not displayed for
		// Additional Benefit - "+benefitType,validationFlag);
	}

	@Then("^the user click on Plan costs tab and validates in AARP site$")
	public void the_user_click_on_Plan_costs_tab_and_validates_in_AARP_site(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String yearlyPremium = memberAttributesMap.get("Yearly Premium");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		boolean validationFlag = vppPlanDetailsPage.clickAndValidatePlanCosts(monthlyPremium, yearlyPremium);
		Assert.assertTrue("Validation failed : Expected text not displayed for monthly and yearly premium - "
				+ monthlyPremium + " " + yearlyPremium, validationFlag);
	}

	@Then("^the user click on Prescription Drug Benefits and validates in AARP site$")
	public void the_user_click_on_Prescription_Drug_Benefits_and_validates_in_AARP_site() throws Throwable {
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.clickAndValidatePrescriptionDrugBenefits();
	}

	@Then("^the user click on Optional Services tab and add the rider in AARP site$")
	public void the_user_click_on_Optional_Services_tab_and_add_the_rider_in_AARP_site(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String optionalRider = memberAttributesMap.get("Optional Rider");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		String optionalRiderPremium = vppPlanDetailsPage.addOptionalRider(optionalRider);
	}

	@Then("^the user click on Plan costs tab and validate riders monthly and yearly premium in AARP site$")
	public void the_user_click_on_Plan_costs_tab_and_validate_riders_monthly_and_yearly_premium_in_AARP_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String yearlyPremium = memberAttributesMap.get("Yearly Premium");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		boolean validationFlag = vppPlanDetailsPage.clickAndValidateOptionalRiderPremiums(monthlyPremium,
				yearlyPremium);
		Assert.assertTrue("Validation failed : Expected text not displayed for riders monthly and yearly premium - "
				+ monthlyPremium + " " + yearlyPremium, validationFlag);
	}

	@When("^the user navigates to Pharmacy locator page from VPP plan details page$")
	public void the_user_navigates_to_pl_page_through_vpp() {
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String county = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String ismulticounty = (String) getLoginScenario().getBean(VPPCommonConstants.IS_MULTICOUNTY);
		PharmacySearchPage pharmacySearchPage = vppPlanDetailsPage.navigateToPharmacySearchPage(county, ismulticounty);
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@Then("^the user validates following PDF link is displayes with correct document code$")
	public void the_user_validates_following_PDF_link_is_displayes_with_correct_document_code(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String PDFtype = memberAttributesMap.get("PDF type");
		String DocumentCode = memberAttributesMap.get("DocumentCode");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		boolean validationFlag = vppPlanDetailsPage.ValidatePDFlinkIsDisplayed(PDFtype, DocumentCode);
		Assert.assertTrue("Validation failed : Expected text not displayed for riders monthly and yearly premium - ",
				validationFlag);

	}

	@Then("^the user click on PDF link and validates document code in URL$")
	public void the_user_click_on_PDF_link_and_validates_document_code_in_URL(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String PDFtype = memberAttributesMap.get("PDF type");

		String DocumentCode = memberAttributesMap.get("DocumentCode");
		boolean validationFlag = vppPlanDetailsPage.ClickValidatePDFlink(PDFtype, DocumentCode);
		Assert.assertTrue("Validation failed : Expected Document Code is not Present in the PDF URL ", validationFlag);

	}

	@Then("^the user validates the document code is present in the PDF$")
	public void the_user_click_on_PDF_link_and_validates_document_code_in_PDF(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String PDFtype = memberAttributesMap.get("PDF type");

		String DocumentCode = memberAttributesMap.get("DocumentCode");
		boolean validationFlag = vppPlanDetailsPage.ClickValidatePDFText_ForDocCode(PDFtype, DocumentCode);
		Assert.assertTrue("Validation failed : Expected Document Code is not Present in the PDF Text ", validationFlag);

	}

	@When("^the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP$")
	public void the_user_views_currentyearlink_clicksLink() throws Throwable {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.CheckClick_CurrentYear_Plans();
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, "2019");
	}

	@When("^the user checks for AEP CUrrent year plans link and clicks to view next year plans on AARP$")
	public void the_user_views_nextyearlink_clicksLink() throws Throwable {

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.CheckClick_NextYear_Plans();
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, "2020");
	}

	@When("^the user validate thank you message in plan compare in AARP site$")
	public void user_validate_thank_you_message_in_plan_compare() {

		ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		comparePlansPage.validatingthankyoumessage();
	}

	@When("^verify Call SAM icon is visible or not$")
	public void verify_Call_SAM_icon_is_visible_or_not() throws InterruptedException {

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

	@And("^verify Call SAM roll out and contain the text Call a Licensed Insurance Agent$")
	public void verify_Call_SAM_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent()
			throws InterruptedException {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSamContent();

	}

	@Then("^user verify the popup and content$")
	public void user_verify_the_popup_and_content() throws InterruptedException {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallpopup();
	}

	@When("^verify Chat SAM icon is visible or not$")
	public void verify_Chat_SAM_icon_is_visible_or_not() throws InterruptedException {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatSam();
		/*
		 * if (Aquisitionhomepage != null) {
		 * getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
		 * Aquisitionhomepage); Assert.assertTrue(true);
		 * System.out.println("Chat Widget is Displayed"); } else{
		 * Assert.fail("Chat Widget is NOT Displayed"); }
		 */
	}

	@And("^verify Chat SAM roll out and contain the text Call a Licensed Insurance Agent$")
	public void verify_Chat_SAM_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent()
			throws InterruptedException {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatSamContent();

	}

	@Then("^the user clicks on Enroll Now for AARP site from Plan Details$")
	public void the_user_clicks_on_Enroll_Now_for_AARP_site_from_Plan_Details() throws Throwable {

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
	}

	@Then("^verify plan compare page is loaded on AARP$")
	public void verify_plan_compare_page_is_loaded_on_AARP() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatePlanComparePage();
	}

	@Then("^user verify the Chat original state on Plan Comapare$")
	public void user_verify_the_Chat_original_state_Plan_Comapare() throws InterruptedException {

		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateChatSam();

	}

	@Then("^the user clicks on Enroll in plan for AARP site and validates the Welcome to OLE Page on new Plan Compare")
	public void user_clicks_enrollInPlan_newPlanCompare_AARP() throws InterruptedException {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		WelcomePage welcomeOLEPage = planComparePage.Enroll_OLE_Plancompare();
		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assert.fail("Error Loading Welcome Page for OLE");
		}
	}

	@Then("^the user clicks on Plan details link in new Plan Compare page for AARP")
	public void user_clicks_planDetails_newPlanCompare_AARP() throws InterruptedException {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		PlanDetailsPage vppPlanDetailsPage = planComparePage.navigateToPlanDetailfromplanCompare();
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in Loading the Plan Details Page");

	}

	@Then("^the user clicks on back on all plan linnk in Plan Compare page")
	public void user_clicks_back_to_all_plan_PlanCompare_AARP() throws InterruptedException {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = planComparePage.navigateBackToAllPlans();
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			Assert.assertTrue(true);
			plansummaryPage.handlePlanYearSelectionPopup();
		} else
			Assert.fail("Error in navigating back to Plan Summary Page");

	}

	@When("^verify Call SAM icon is visible or not on Plan Comapare$")
	public void verify_Call_SAM_icon_is_visible_or_not_PlanCompare() throws InterruptedException {
		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallSam();
		getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		Assert.assertTrue(true);
		System.out.println("TFN Widget is Displayed");
	}

	@And("^verify Call SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare$")
	public void verify_Call_SAM_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent_PlanCompare()
			throws InterruptedException {

		ComparePlansPageMobile planComparePage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallSamContent();

	}

	@Then("^user verify the popup and content on Plan Comapare$")
	public void user_verify_the_popup_and_content_PlanCompare() throws InterruptedException {

		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateCallpopup();
	}

	@When("^verify Chat SAM icon is visible or not on Plan Comapare$")
	public void verify_Chat_SAM_icon_is_visible_or_not_PlanCompare() throws InterruptedException {

		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		ComparePlansPage PlanComparePage = planComparePage.validateChatSam();
		if (PlanComparePage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, PlanComparePage);
			Assert.assertTrue(true);
			System.out.println("TFN Widget is Displayed");
		} else {
			Assert.fail("TFN Widget is NOT Displayed");
		}
	}

	@And("^verify Chat SAM roll out and contain the text Call a Licensed Insurance Agent on Plan Comapare$")
	public void verify_Chat_SAM_roll_out_and_contain_the_text_Call_a_Licensed_Insurance_Agent_PlanCompare()
			throws InterruptedException {

		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateChatSamContent();

	}

	@Then("^user verify the Chat original state$")
	public void user_verify_the_Chat_original_state_PlanCompare() throws InterruptedException {

		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateChatSam();

	}

	@And("^click on back to plans on plan compare page for AARP$")
	public void click_on_back_to_plans_on_plan_compare_page_for_AARP() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnBacktoPlans();
	}

	@Then("^Verify the Plan compare checkbox should be unchecked for the removed plan for AARP$")
	public void verify_the_Plan_compare_checkbox_should_be_unchecked_for_the_removed_plan_for_AARP() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyPlanComapreCheckboxIsUnchecked();
	}

	@And("^I select \"([^\"]*)\" plans and \"([^\"]*)\" plans to compare and click on compare plan link in AARP$")
	public void i_select_plans_and_plans_to_compare_and_click_on_compare_plan_link_in_AARP(String planType,
			String Counter) throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		int counter = Integer.parseInt(Counter);
		if (planType.equals("MAPD")) {
			// plansummaryPage.clickonViewPlans();
			plansummaryPage.checkMAPlansOnly(counter);
			System.out.println("Selected All MAPD plans for Plan Compare");
		}

		ComparePlansPageMobile planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@And("^check one plan and add it to plancompare for AARP")
	public void check_one_plan_and_add_it_to_plancompare_for_AARP() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickon3rdPlan();
		ComparePlansPageMobile planComparePage = plansummaryPage.clickOnCompareLink();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@Then("^verify plan compare checkbox is not visible on plan summary on AARP$")
	public void verify_plan_compare_checkbox_is_not_visible_on_plan_summary_on_AARP() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		boolean validationFlag = plansummaryPage.verifyPlanCompareCheckboxNotVisible();
		Assert.assertFalse("Validation failed : UnExpected Plan Compare check is Visible - ", validationFlag);

	}

	@Then("^user select and unselect one plan for plan compare and verify second plan checkbox autoselected and click on plan compare for AARP$")
	public void user_select_and_unselect_one_plan_for_plan_compare_for_AARP() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.checkOneCheckboxVerifyAutoSelection("true");
		plansummaryPage.checkOneCheckboxVerifyAutoSelection("false");

	}

	@When("^the user clicks on Lookup zipcode on AARP$")
	public void the_user_clicks_on_Lookup_zipcode_on_AARP() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ZipcodeLookupHomePage zipcodeLookuphomePage = aquisitionhomepage.looksupforZipcodes();
		getLoginScenario().saveBean(PageConstants.ZIP_LOOK_UP_HOME_PAGE, zipcodeLookuphomePage);
	}

	@Then("^verify find a zipcode popup displpayed and Enter values and click on LookupZipcode on AARP$")
	public void verify_find_a_zipcode_popup_displpayed_and_Enter_values_and_click_on_LookupZipcode_on_AARP(
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

	@When("^the user performs plan search using following information in the aarp site$")
	public void lookUpzipcode_details_in_aarp_site(DataTable givenAttributes) {
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
	
	@When("^the user performs plan search using following information$")
	public void lookUpzipcode_details_in_aarp_sites(DataTable givenAttributes) throws InterruptedException {
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

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = null;
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


	@Then("^user clicks on Change Zip code link in AARP site$")
	public void user_clicks_on_Change_Zip_code_link_in_UMS_site() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickOnChangeZipCode();
	}

	@Then("^user clicks on Select by Address and Enter fileds in AARP Site$")
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

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.enterAddressDetails(address, city, state);
	}

	@When("^the user clicks on Find plans on vpp using following information in the AARP site$")
	public void the_user_clicks_on_Find_plans_on_vpp_using_following_information_in_the_AARP_site(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String county2 = memberAttributesMap.get("County Name2");
		String isMultiCounty2 = memberAttributesMap.get("Is Multi County2");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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

	/** user is on the Medicare Site landing page for VPP Testharness */
	@Given("^the user is on VPP TestHarness page for AARP$")
	public void validateUserIsOnUMS_VPPTestharnessPage_for_AARP(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		String TestharnessPage = inputAttributesMap.get("TestHarnessPage");
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, siteName, TestharnessPage);
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) aquisitionhomepage.GetVPPTestHarnessPage();
		getLoginScenario().saveBean(PageConstants.VPP_TESTHARNESS_PAGE, vppTestHarnessPage);
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

	@When("^the user enters following information in the AARP Acquisition Site VPPZipcode TestHarness page$")
	public void the_user_enters_following_information_in_the_AARP_Site_VPPZipcode_TestHarness_page(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");

		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterVppZipcode(ZipCode);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCounty(CountyName);
		}
		VPPPlanSummaryPage planSummaryPage = vppTestHarnessPage.navigateToVPP();
		if (planSummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, planSummaryPage);
		}
	}

	@When("^the user clicks on Lookup zipcode and enters following information in the AARP Acquisition Site VPPZipcode TestHarness page$")
	public void the_user_clicks_on_Lookup_zipcode_and_enters_following_information_in_the_AARP_Site_VPPZipcode_TestHarness_page(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String Address = inputAttributesMap.get("Address");
		String City = inputAttributesMap.get("City");
		String State = inputAttributesMap.get("State");

		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterAddressDetails(Address, City, State);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCounty(CountyName);
		}
		VPPPlanSummaryPage planSummaryPage = vppTestHarnessPage.navigateToVPP();
		if (planSummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, planSummaryPage);
		}
	}

	@When("^the user click on Go botton without entering Zipcode and enters zipcode from shop for a plan on the AARP Acquisition Site VPPZipcode TestHarness page$")
	public void user_enters_zipcodefromshopforaplan_on_the_AARP_AcquisitionSiteVPPZipcodeTestHarnesspage(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");

		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		VPPPlanSummaryPage planSummaryPage = vppTestHarnessPage.navigateToShopPlanenterZipcodeToVPP(ZipCode, CountyName,
				isMultutiCounty);
		if (planSummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, planSummaryPage);
		}
	}

	@When("^the user enters zipcode on plan summary deep link and clik on deeplink navigates to VPP plan summary for AARP$")
	public void user_enters_zipcode_on_plan_summary_deep_link_and_clik_on_deeplink_navigates_to_VPP_plan_summary_for_AARP(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterZipcodeforPlanSummaryDeepLink(ZipCode);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCounty(CountyName);
		}
		VPPPlanSummaryPage plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}
	}

	@When("^the user enters Mandatory fields on plan summary email deeplink and clik on deeplink navigates to VPP plan summary for AARP$")
	public void user_enters_Mandatory_fields_on_plan_summary_email_deeplink_and_clik_on_deeplink_navigates_to_VPP_plan_summary_for_AARP(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String Deeplink = inputAttributesMap.get("Deeplink");
		String PlanType = inputAttributesMap.get("Plan Type");
		String PlanYear = inputAttributesMap.get("Year");

		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterEmailPlanSummaryDeepLink(ZipCode, Deeplink, PlanType, PlanYear);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCounty(CountyName);
		}
		VPPPlanSummaryPage plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}
	}

	@When("^the user enters Mandatory fields on plan compare deeplink and clik on deeplink navigates to VPP plan Compare for AARP$")
	public void user_enters_Mandatory_fields_on_plan_compare_email_deeplink_and_clik_on_deeplink_navigates_to_VPP_plan_Compare_for_AARP(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String ExpiryDate = inputAttributesMap.get("Expiry Date");
		String ContractPBP = inputAttributesMap.get("ContractPBP");
		String PlanYear = inputAttributesMap.get("Plan Year");
		String PlanType = inputAttributesMap.get("Plan Type");
		String fisCountyCode = inputAttributesMap.get("fisCountyCode");

		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterEmailPlanCompareDeepLink(ZipCode, ContractPBP, ExpiryDate, PlanType, PlanYear,
				fisCountyCode);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCounty(CountyName);
		}
		ComparePlansPage planComparePage = vppTestHarnessPage.navigateToPlanCompare();
		if (planComparePage != null) {
			loginScenario.saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		}
	}

	@When("^the user enters Mandatory fields on plan details deeplink and clik on deeplink navigates to VPP plan details for AARP$")
	public void user_enters_Mandatory_fields_on_plan_details_email_deeplink_and_clik_on_deeplink_navigates_to_VPP_plan_details_for_AARP(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String Deeplink = inputAttributesMap.get("Deeplink");
		String ContractPBP = inputAttributesMap.get("ContractPBP");
		String PlanYear = inputAttributesMap.get("Plan Year");
		String fisCountyCode = inputAttributesMap.get("fisCountyCode");
		String plantype = inputAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterEmailPlanDetailsDeepLink(ZipCode, ContractPBP, PlanYear, Deeplink, fisCountyCode);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCountyforplanDetails(CountyName);
		}
		PlanDetailsPage vppPlanDetailsPage = vppTestHarnessPage.navigateToPlanDetails();
		if (vppPlanDetailsPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		}
	}

	@Then("^the user view plan details of the above selected plan in AARP site and validates from Deeplink$")
	public void user_views_plandetails_selected_plan_AARP_form_deepLink(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.verifyPlanName(planName);

	}

	@When("^the user enters Mandatory fields on plan selector deeplink and clik on deeplink navigates to VPP plan details for AARP$")
	public void user_enters_Mandatory_fields_on_plan_selector_email_deeplink_and_clik_on_deeplink_navigates_to_VPP_plan_details_for_AARP(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String ContractNum = inputAttributesMap.get("ContractNum");
		String SegmentID = inputAttributesMap.get("Segment ID");
		String PbpNumber = inputAttributesMap.get("PbpNumber");
		String PlanYear = inputAttributesMap.get("Plan Year");
		String CountyCode = inputAttributesMap.get("CountyCode");
		String UserGroup = inputAttributesMap.get("User Group");
		String plantype = inputAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterEmailPlanSelectorDeepLink(ContractNum, CountyCode, PbpNumber, SegmentID, PlanYear,
				ZipCode, UserGroup, isMultutiCounty, CountyName);
		PlanDetailsPage vppPlanDetailsPage = vppTestHarnessPage.navigateToPlanDetails();
		if (vppPlanDetailsPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		}
	}

	@When("^the user enters Mandatory fields on MedSup deeplink and clik on deeplink navigates to VPP plan details for AARP$")
	public void user_enters_Mandatory_fields_on_MedSup_email_deeplink_and_clik_on_deeplink_navigates_to_VPP_plan_details_for_AARP(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String uri = inputAttributesMap.get("URI");
		String mpbed = inputAttributesMap.get("MPBED");
		String ebrc = inputAttributesMap.get("EBRC");
		String dpsd = inputAttributesMap.get("DPSD");
		String intref = inputAttributesMap.get("Intref");
		String mpaed = inputAttributesMap.get("MPAED");
		String genderCode = inputAttributesMap.get("GenderCode");
		String tobaccoUser = inputAttributesMap.get("TobaccoUser");
		String dob = inputAttributesMap.get("DOB");

		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterMedSupDetailsDeepLink(ZipCode, ebrc, intref, mpbed, dpsd, mpaed, dob, uri, genderCode,
				tobaccoUser);
		vppTestHarnessPage.navigateToMedSupPlans();
		getLoginScenario().saveBean(PageConstants.VPP_TESTHARNESS_PAGE, vppTestHarnessPage);
	}

	@And("^the user validates plan summary for the below plan in AARP site for Medsup Deeplink$")
	public void user_validates_plan_summary_AARP_for_medsup_deepLink(DataTable planAttributes)
			throws InterruptedException {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.validateMedSupSpecificPlanInfo(planName);
	}

	@And("^the user enters Mandatory fields on ProviderSearch Navigates to provider Page for AARP$")
	public void user_enters_Mandatory_fields_on_ProviderSearch_Navigates_to_provider_Page_for_AARP(
			DataTable planAttributes) throws Exception {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String zipCode = givenAttributesMap.get("Zip Code");
		String planYear = givenAttributesMap.get("Plan Year");
		String planID = givenAttributesMap.get("Plan ID");
		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		ProviderSearchPage providerSearchPage = vppTestHarnessPage.enterMandatoryFieldsToProviderSearch(zipCode, planID,
				planYear);
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}
	}

	@And("^user click on LaunhVPP on testharness page and navigated to VPP on AARP$")
	public void user_click_on_LaunhVPP_on_testharness_page_and_navigated_to_VPP_on_AARP() throws InterruptedException {
		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.clickOnLaunchVVP();
		VPPPlanSummaryPage plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}

	}

	@And("^user selects helper mode for Navigate to VPP with Providers data on AARP$")
	public void user_selects_helper_mode_for_NavigatetoVPPwith_Providers_data_on_AARP() throws Exception {

		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.navigatetoVPPwithProvidersdata();
		VPPPlanSummaryPage plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}
	}

	@When("^the user enters following information in the AARP Acquisition Site VPPDCE TestHarness page$")
	public void the_user_enters_following_information_in_the_AARP_Site_VPPDCE_TestHarness_page(
			DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ZipCode = inputAttributesMap.get("Zip Code");
		String CountyName = inputAttributesMap.get("County Name");
		String isMultutiCounty = inputAttributesMap.get("Is Multi County");
		String planName = inputAttributesMap.get("Plan Name");
		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.enterZipandSearch(ZipCode);
		if (isMultutiCounty.equalsIgnoreCase("YES")) {
			vppTestHarnessPage.SelectCountyDCE(CountyName);
		}
		vppTestHarnessPage.selectPlan(planName);
	}

	@And("^user selects helper mode for Redirect to VPP from DCE on AARP$")
	public void user_selects_helper_mode_for_Redirect_to_VPP_from_DCE_on_AARP() throws Exception {
		VPPTestHarnessPage vppTestHarnessPage = (VPPTestHarnessPage) loginScenario
				.getBean(PageConstants.VPP_TESTHARNESS_PAGE);
		vppTestHarnessPage.redirecttoVPPfromDCE();
		VPPPlanSummaryPage plansummaryPage = vppTestHarnessPage.navigateToVPP();
		if (plansummaryPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		}
	}

	@Then("^Verify X out of Y drugs covered information is displayed on Plan Summary page AARP$")
	public void verify_drugs_covered_AARP(DataTable Planname) {

		List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String planName = plannameAttributesMap.get("PlanName");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assert.assertTrue("Drugs coverage Info not updated", plansummaryPage.druginfo(planName));
	}

	@Then("^Navigate to Visitor Profile page on AARP site$")
	public void navigate_to_Visitor_Profile_page_on_AARP_site() {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		VisitorProfilePageMobile visitorProfilePage = plansummaryPage.navigateToVisitorProfilePage();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	/** user is on the Medicare Site landing page for Visitorprofile Testharness */
	@Given("^the user is on VistorProfile TestHarness page for AARP$")
	public void validateUserIsOnAARP_VPTestharnessPage_for_AARP(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		String TestharnessPage = inputAttributesMap.get("TestHarnessPage");
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, siteName, TestharnessPage);
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) aquisitionhomepage
				.GetVisitorProfileTestHarnessPage();
		getLoginScenario().saveBean(PageConstants.VP_TESTHARNESS_PAGE, vpTestHarnessPage);
	}

	@And("^user selects helper mode for Save plans in Guest profile to VP with plans data on AARP$")
	public void user_selects_helper_mode_for_Save_plans_in_Guest_profile_to_VP_with_plans_data_on_AARP()
			throws Exception {

		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePage visitorProfilePage = vpTestHarnessPage.NavigateToVP_from_SaveplansinGuestprofileLink();

		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assert.fail("Error Loading on visitor Profile page");
		}
	}

	@And("^user Enters Fields and selects helper mode for Save plans in Authenticated profile to VP with plans data on AARP$")
	public void user_Enters_Fields_and_selects_helper_mode_for_Save_plans_in_Guest_profile_to_VP_with_plans_data_on_AARP(
			DataTable inputAttributes) throws Exception {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String uuid = inputAttributesMap.get("UUID");
		String isguest = inputAttributesMap.get("IsGuest");
		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePage visitorProfilePage = vpTestHarnessPage
				.NavigateToVP_from_SaveplansinauthenticatedprofileLink(uuid, isguest);

		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assert.fail("Error Loading on visitor Profile page");
		}
	}

	@And("^user selects helper mode for Launch Visitor Profile with Drugs and Pharmacy in Visitor Profile on AARP site$")
	public void user_selects_helper_mode_for_LaunchVisitorProfilewithDrugsandPharmacyinVisitorProfile_on_AARP()
			throws Exception {

		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePage visitorProfilePage = vpTestHarnessPage
				.NavigateToVP_from_LaunchVPwithDrugandPharmacyInfoLink();

		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assert.fail("Error Loading on visitor Profile page");
		}
	}

	@And("^user selects helper mode for Launch Visitor Profile with Providers in Visitor Profile on AARP site$")
	public void user_selects_helper_mode_for_LaunchVisitorProfilewithProvidersinVisitorProfile_on_AARP()
			throws Exception {

		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePage visitorProfilePage = vpTestHarnessPage.NavigateToVP_from_LaunchVPwithProvidersLink();
		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assert.fail("Error Loading on visitor Profile page");
		}
	}

	@And("^user selects plan to compare from visitor Profile on AARP site$")
	public void user_selectsplantoComparefromVisitorProfile_on_AARP(DataTable inputAttributes) throws Exception {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String Plancompare = inputAttributesMap.get("Plan compare");
		String Zipcode = inputAttributesMap.get("Zip Code");
		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		ComparePlansPage planComparePage = vpTestHarnessPage.NavigateToPlanCompareFromVpTest(Zipcode, Plancompare);

		if (planComparePage != null) {
			loginScenario.saveBean(PageConstants.PLAN_COMPARE_PAGE, planComparePage);
		} else {
			Assert.fail("Error Loading on Plan Compare page");
		}

	}

	@Then("^verify plans added in plan compare on visitor Profile for AARP$")
	public void verify_plans_addedin_plan_compare_on_visitor_Profile_forAARP() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatePlansAddedonPlancompareforVisitorProfile();
	}

	@And("^user Enters plan info to land on plan details from visitor Profile on AARP site$")
	public void user_EntersplaninfotolandonplandetailsfromvisitorProfileonAARPsite(DataTable inputAttributes)
			throws Exception {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String ContractNo = inputAttributesMap.get("Contract Number");
		String PbpNo = inputAttributesMap.get("PBP Number");
		String SegId = inputAttributesMap.get("Segment ID");
		String CountyCD = inputAttributesMap.get("County code");
		String product = inputAttributesMap.get("Product");
		String year = inputAttributesMap.get("Plan Year");
		String Zipcode = inputAttributesMap.get("Zip Code");

		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		PlanDetailsPage vppPlanDetailsPage = vpTestHarnessPage.NavigateToPlanDetailsFromVpTest(Zipcode, ContractNo,
				PbpNo, SegId, CountyCD, product, year);

		if (vppPlanDetailsPage != null) {
			loginScenario.saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		} else {
			Assert.fail("Error Loading on Plan Details Page page");
		}
	}

	@And("^user selects helper mode for Launch OLE for Guest profile on AARP$")
	public void user_selects_helper_mode_for_Launch_OLE_for_Guest_profile_on_AARP(DataTable givenAttributes)
			throws Exception {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		String isMultiCounty = memberAttributesMap.get("Is Multi County");
		String PlanName = memberAttributesMap.get("Plan Name");
		String PlanYear = memberAttributesMap.get("Plan Year");
		String PlanType = memberAttributesMap.get("Plan Type");

		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, zipcode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, county);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);

		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		WelcomePage welcomePage = vpTestHarnessPage.NavigateToOLEfromVP();
		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
		} else {
			Assert.fail("Error Loading OLE Welcome page");
		}
	}

	@And("^user selects Delete Drug and Pharamcy on the Authenticated profile on AARP site$")
	public void user_selects_DeleteDrugandPharamcyontheAuthenticatedprofile_on_AARP() throws Exception {

		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePage visitorProfilePage = vpTestHarnessPage.DeleteDrugAndPharamacy();

		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assert.fail("Error Loading on visitor Profile page");
		}
	}

	@And("^user selects Delete Provider on the Authenticated profile on AARP site$")
	public void user_selects_DeleteProviderontheAuthenticatedprofile_on_AARP() throws Exception {

		VisitorProfileTestHarnessPage vpTestHarnessPage = (VisitorProfileTestHarnessPage) loginScenario
				.getBean(PageConstants.VP_TESTHARNESS_PAGE);
		VisitorProfilePage visitorProfilePage = vpTestHarnessPage.DeleteProvider();

		if (visitorProfilePage != null) {
			loginScenario.saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
		} else {
			Assert.fail("Error Loading on visitor Profile page");
		}
	}

	@Then("^the user enter the searchValue in the search text box and hits enter$")
	public void the_user_enter_the_searchValue_in_the_search_text_box_and_hits_enter(DataTable inputvalue)
			throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}
		String InputValue = urlAttributesMap.get("search Value");
		System.out.println("Search value" + InputValue);
		Thread.sleep(3000);

		aquisitionhomepage.enterSearchtextvalue(InputValue);

	}

	@Then("^the user validates the secondary search by providing newsearchvalue in the text box$")
	public void the_user_validates_the_secondary_search_by_providing_newsearchvalue_in_the_text_box(
			DataTable inputvalue) throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}
		String InputValue = urlAttributesMap.get("NewSearchValue");
		System.out.println("NewSearchValue" + InputValue);
		Thread.sleep(3000);

		aquisitionhomepage.enterSecondarySearchValue(InputValue);

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

	@Then("^the user validates Error message$")
	public void the_user_validates_pagination_and_results_displayed(DataTable inputvalue) throws Throwable {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}
		String error = urlAttributesMap.get("Error");
		String newSearchValue = urlAttributesMap.get("NewSearchValue");
		System.out.println("Error : " + error);
		Thread.sleep(3000);
		aquisitionhomepage.validateErrorMsg(error, newSearchValue);
	}

	@Then("^the user clear secondary search box and insert new search value$")
	public void the_user_clea_seacondary_search_box_and_insert_new_search_value(DataTable inputvalue) throws Exception {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		List<DataTableRow> AttributesRow = inputvalue.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap.put(AttributesRow.get(i).getCells().get(0), AttributesRow.get(i).getCells().get(1));
		}
		String InputValue = urlAttributesMap.get("New Search Value");
		System.out.println("New Search Value" + InputValue);
		Thread.sleep(3000);
		aquisitionhomepage.insertValueIntoSecondSearchBox(InputValue);

	}

	@Then("^the user picks each example from excel to validate Plan Document PDFs and reports into excel$")
	public void the_user_ExceldataValidation_PDF_link_and_validates_document_code_in_PDFtext_URL(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String ExcelName = givenAttributesMap.get("ExcelFile");
		String SheetName = givenAttributesMap.get("WorkSheetName");
		System.out.println("Set of TFNs from Sheet : " + SheetName);
		// Getting Date
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		Date RunDate = new Date();
		String DateCreated = dateFormat.format(RunDate);
		String parentDirectory = null;
		parentDirectory = new java.io.File(".").getCanonicalPath();
		String InputFilePath = parentDirectory + "/src/main/resources/database/PlanDocs/" + ExcelName + ".xls";
		String OutputFilePath = parentDirectory + "/target/PDFvalidation_Results_" + SheetName + "_" + DateCreated
				+ ".xls";
		// Reading Excel.xls file
		File InputFile = new File(InputFilePath);
		FileInputStream inputStream = new FileInputStream(InputFile);
		Workbook workbook = new HSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(SheetName);
		int lastRow = sheet.getLastRowNum();
		Workbook ResultWorkbook = new HSSFWorkbook();
		Sheet ResultsSheet = ResultWorkbook.createSheet(SheetName);
		// Setting First Row for Results excel
		Row resultsRow = ResultsSheet.createRow(0);
		resultsRow.createCell(0).setCellValue((String) "Zipcode");
		resultsRow.createCell(1).setCellValue((String) "PlanName");
		resultsRow.createCell(2).setCellValue((String) "pdfType");
		resultsRow.createCell(3).setCellValue((String) "docCode");
		resultsRow.createCell(4).setCellValue((String) "Plan Summary Loaded PASS/FAIL");
		resultsRow.createCell(5).setCellValue((String) "Plan Details Loaded PASS/FAIL");

		resultsRow.createCell(6).setCellValue((String) "PDF Link Validated PASS/FAIL");
		resultsRow.createCell(7).setCellValue((String) "PDF URL/Text validated PASS/FAIL");
		// Looping over entire row
		try {
			for (int i = 1; i <= lastRow; i++) {
				// Get input data Row
				Row row = sheet.getRow(i);
				double zipcodeint = row.getCell(0).getNumericCellValue();

				String zipcode = String.valueOf(zipcodeint);
				String isMultiCounty = row.getCell(1).getStringCellValue().trim();
				String county = row.getCell(2).getStringCellValue().trim();
				String plantype = row.getCell(3).getStringCellValue().trim();
				String planName = row.getCell(4).getStringCellValue().trim();
				String pdfType = row.getCell(5).getStringCellValue().trim();
				String docCode = row.getCell(6).getStringCellValue().trim();

				System.out.println("Excel data Row # : " + i);

				System.out.println("Zipcode : " + zipcode);
				System.out.println("Plan Type : " + plantype);
				System.out.println("Plan Name : " + planName);
				System.out.println("PDF Type : " + pdfType);
				System.out.println("Document Code : " + docCode);

				// Create Results Row
				resultsRow = ResultsSheet.createRow(i);
				resultsRow.createCell(0).setCellValue((String) zipcode);
				resultsRow.createCell(1).setCellValue((String) planName);
				resultsRow.createCell(2).setCellValue((String) pdfType);
				resultsRow.createCell(3).setCellValue((String) docCode);

				WebDriver wd = getLoginScenario().getWebDriverNew();
				AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

				getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
				getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
				getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

				VPPPlanSummaryPage plansummaryPage = null;
				if (("NO").equalsIgnoreCase(isMultiCounty.trim())) {
					plansummaryPage = aquisitionhomepage.searchPlansWithOutCounty(zipcode);
				} else {
					plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);
				}

				if (plansummaryPage != null) {
					resultsRow.createCell(4).setCellValue((String) "PASS");

				} else {
					resultsRow.createCell(4).setCellValue((String) "FAIL");
				}

				plansummaryPage.viewPlanSummary(plantype);
				plansummaryPage.CheckClick_CurrentYear_Plans();

				PlanDetailsPage vppPlanDetailsPage = plansummaryPage.navigateToPlanDetails(planName, plantype);
				if (vppPlanDetailsPage != null) {
					resultsRow.createCell(5).setCellValue((String) "PASS");
				} else
					resultsRow.createCell(5).setCellValue((String) "FAIL");
				boolean pdfLinkFlag = vppPlanDetailsPage.ValidatePDFlinkIsDisplayed(pdfType, docCode);
				if (pdfLinkFlag) {
					resultsRow.createCell(6).setCellValue((String) "PASS");
				} else
					resultsRow.createCell(6).setCellValue((String) "FAIL");
				boolean pdfFlag = vppPlanDetailsPage.ClickValidatePDFText_URL_ForDocCode(pdfType, docCode);
				if (pdfFlag) {
					resultsRow.createCell(7).setCellValue((String) "PASS");
				} else
					resultsRow.createCell(7).setCellValue((String) "FAIL");

				// wd.close();
				wd.quit();
				// getLoginScenario().nullifyWebDriverNew();

			}
			File OutputFile = new File(OutputFilePath);
			FileOutputStream outputStream = new FileOutputStream(OutputFile);
			ResultWorkbook.write(outputStream);
			inputStream.close();
			outputStream.flush();

			outputStream.close();

			// softAssertions.assertAll();
		} catch (Exception e) {
			File OutputFile = new File(OutputFilePath);
			FileOutputStream outputStream = new FileOutputStream(OutputFile);
			ResultWorkbook.write(outputStream);
			inputStream.close();
			outputStream.flush();
			outputStream.close();
			// softAssertions.assertAll();
			e.printStackTrace();
		}

	}

	@And("^the user views the plans of the below plan type$")
	public void user_performs_planSearch_in_aarp_sites(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(plantype);
		if(!plantype.equalsIgnoreCase("MS"))
			plansummaryPage.handlePlanYearSelectionPopup();
	}
	
	@Then("^agent saves two plans as favorite on AARP site for user$")
	public void agent_saves_two_plans_as_favorite_on_AARP_site_for_user(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
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

	@Then("^user saves all plans as favorite on AARP site$")
	public void user_saves_all_plans_as_favorite_on_AARP_site(DataTable givenAttributes) {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		Map<String, String> memberAttributesMap = prepareTestInput(givenAttributes);
		String savePlanNames = memberAttributesMap.get("Test Plans");
		String planType = memberAttributesMap.get("Plan Type");

		switch (planType) {
		case "MAPD":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.saveAllPlans(savePlanNames, planType);
			break;
		case "MA":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.saveAllPlans(savePlanNames, planType);
			break;
		case "SNP":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.saveAllPlans(savePlanNames, planType);
			break;
		case "PDP":
			plansummaryPage.viewPlanSummary(planType);
			plansummaryPage.saveAllPlans(savePlanNames, planType);
			break;

		default:
			break;
		}
	}

	// New plan compare related
	@And("^I click on Get Started on and Add PrimaryCare PCP from find care page in AARP$")
	public void I_click_on_Get_Started_and_Add_PrimaryCarePCP_find_care_page_in_AARP() throws Exception {
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

	@Then("^remove one plan from new plan compare page for AARP$")
	public void remove_one_plan_from_new_plan_compare_page_for_AARP() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnNewRemoveLink();
	}

	@Then("^Click on Add Icon on new Plan Compare and verify it navigates to plan summary page for AARP$")
	public void click_on_Add_Icon_newPlanCompare_and_verify_it_navigates_to_plan_summary_page_for_AARP()
			throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.clickOnNewAddIcon();
	}

	@Then("^Verify newly added plan displayed on new plan compare page for AARP$")
	public void verify_newly_added_plan_displayed_on_new_plan_compare_page_for_AARP() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validatenewlyAddPlanonNewPlanComapre();
	}

	@Then("^verify Your doctors is loaded with doctor summary on Plan Compare page AARP$")
	public void verify_doctors_covered_ulayer() {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateDoctors();
	}

	@Then("^verify Your Hospital is loaded with doctor summary on Plan Compare page AARP$")
	public void verify_Hospital_covered_ulayer() {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateEditHospitals();
	}

	@Then("^verify Add doctors is loaded with doctor summary on Plan Compare page AARP$")
	public void verify_Add_doctors_covered_ulayer() {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateAddDoctors();
	}

	@Then("^verify Add Hospitals is loaded without summary on Plan Compare page AARP$")
	public void verify_Add_Hospitals_covered_ulayer() {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateAddHospitals();
	}

	@And("^click on Add your doctors link and Navigate to Rally page for AARP$")
	public void clickOnAddyourdocits_AARP() throws Exception {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		FindCarePage findCarePage = planComparePage.clickonAddYourDoctors();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@And("^click on Add your Hospitals link and Navigate to Rally page for AARP$")
	public void clickOnAddyourHospitals_AARP() throws Exception {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		FindCarePage findCarePage = planComparePage.clickonAddYourHospitals();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@And("^click on Edit your doctors link and Navigate to Rally page for AARP$")
	public void clickONEdityourdocits_AARP() throws Exception {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		FindCarePage findCarePage = planComparePage.clickonEditYourDoctors();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@And("^click on Edit your Hospitals link and Navigate to Rally page for AARP$")
	public void clickONEdityourHospitals_AARP() throws Exception {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		FindCarePage findCarePage = planComparePage.clickonEditYourHosptials();
		if (findCarePage != null) {
			getLoginScenario().saveBean(PageConstants.FIND_CARE_PAGE, findCarePage);
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@When("^user selects a provider from medical group and retuns to plan compare page in AARP$")
	public void selectsproviderfrommedicalGroupforAARP() throws Exception {
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

	@When("^user selects a Hospitals from Clinical and retuns to plan compare page in AARP$")
	public void selectsproviderfromPrimaryCareClinicforAARP() throws Exception {
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

	@And("^I click on Get Started on and Add Places from Hospitals find care page in AARP$")
	public void I_click_on_Get_Started_and_Add_PlacesfromHospitals_find_care_page_in_AARP() throws Exception {
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

	@Then("^verify Edit your Drugs is loaded with Drugs summary on Plan Compare page AARP$")
	public void verify_Edit_your_Drugswithsummary_covered_ulayer() {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateEditDrugs();
	}

	@And("^click on Edit Drug link on plan compare for AARP site$")
	public void clickonEditDruglinkonplancompareforAARPsite() {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DrugCostEstimatorPage drugCostEstimatorPage = planComparePage.clickonEdityourDrugs();
		if (drugCostEstimatorPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, drugCostEstimatorPage);
			// comparePlansPage.backToVPPPage();
		} else
			Assert.fail("Error in loading the compare plans page");
	}

	@Then("^Click on view more plans for right navigaton on AARP$")
	public void ClickonviewmoreplansforrightnavigatononAARP() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateViewMoreplansComparePage();
	}

	@Then("^Click on view less plans for left navigaton on AARP$")
	public void ClickonviewlessplansforrightnavigatononAARP() throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.validateViewlessplansComparePage();
	}

	@Then("^remove one plan from \"([^\"]*)\" new plan compare and verify remove icon is disabled page for AARP$")
	public void removeoneplanfrom_compare_plan_link_in_AARP(String Counter) throws Throwable {
		ComparePlansPage planComparePage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		planComparePage.CounterNewRemoveLink(Counter);
	}

	@And("^the user signs in with optum Id in medsup flow$")
	public void the_user_signs_in_with_optum_Id(DataTable credentials) {
		List<DataTableRow> plannameAttributesRow = credentials.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String username = plannameAttributesMap.get("User Name");
		String password = plannameAttributesMap.get("Password");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.signInOptumId(username, password);
	}

	@Then("^the user validate retrieve application URL in AARP Site$")
	public void the_user_retrieve_application_URL_in_AARPSite(DataTable arg1) throws InterruptedException {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String AARPURL = inputAttributesMap.get("AARP URL");
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.RetrieveURL(AARPURL);

	}

	/**
	 * @toDo:user clicks on privacypolicy link of sitemap
	 */
	@And("^user clicks on privacypolicy link of sitemap page$")
	public void click_privacypolicy() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PrivacyPolicyAARPPageMobile privacyPolicyAARPPage = aquisitionhomepage.privacypolicyFooterClick();
		if (privacyPolicyAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_PRIVACY_POLICY_PAGE, privacyPolicyAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("privacypolicy page not found");
		}
	}

	/**
	 * @toDo:user clicks on disclaimers link of terms&conditions
	 */
	@And("^user clicks on disclaimers link of terms&conditions page$")
	public void click_disclaimers() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersAARPPageMobile disclaimersAARPPage = aquisitionhomepage.disclaimersFooterClick();
		if (disclaimersAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_DISCLAIMERS_PAGE, disclaimersAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("disclaimers page not found");
		}
	}

	/**
	 * @toDo:user clicks on agents&brokers link of disclaimers
	 */
	@And("^user clicks on agents&brokers link of disclaimers page$")
	public void click_agentsnbrokers() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AgentsnBrokersAARPPageMobile agentsnBrokersAARPPage = aquisitionhomepage.agentsnbrokersFooterClick();
		if (agentsnBrokersAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_AGENTS_AND_BROKERS_PAGE, agentsnBrokersAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("agents&brokers page not found");
		}
	}

	/**
	 * @toDo:user clicks on home link of agents&brokers
	 */

	@And("^user verifies home link of agents&brokers page ulayer$")
	public void click_home() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePageMobile aquisitionHomePageReload = aquisitionhomepage.homeFooterClick();
		Assert.assertTrue("home page not found", aquisitionHomePageReload != null);
	}

	@Then("^the user click on Dental Cover Popup he must be able to validate plan defaults in AARP$")
	public void the_user_click_on_Optional_Services_tab_and_validate_PlanDefaults(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planName = memberAttributesMap.get("Plan Name");

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
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
}