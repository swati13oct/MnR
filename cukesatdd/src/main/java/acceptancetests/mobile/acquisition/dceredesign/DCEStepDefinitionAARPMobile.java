package acceptancetests.mobile.acquisition.dceredesign;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
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
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.ole.WelcomePage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.ComparePlansPageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.dce.ulayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.TellUsAboutDrugMobile;
import pages.mobile.acquisition.dceredesign.ZipCodeAndPlanYearCapturePageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;

public class DCEStepDefinitionAARPMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	//AppiumDriver wd;

	@Given("^the user is on AARP medicare acquisition site landing page in mobile$")
	public void the_user_is_on_AARP_medicare_acquisition_site_landing_page_in_mobile() throws Throwable {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^the user navigates to following AARP medicare acquisition site page in mobile$")
	public void the_user_navigates_to_following_AARP_medicare_acquisition_site_page_in_mobile(
			DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : " + path);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPage(path);
	}

	@Then("^the user validates Get Started Page in mobile$")
	public void the_user_validates_Get_Started_Page_in_mobile() {
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = new ZipCodeAndPlanYearCapturePageMobile(wd);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@When("^the user clicks on Add drugs button in mobile$")
	public void the_user_clicks_on_Add_drugs_button_in_mobile() throws Throwable {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.clickAddDrugsBtn();
	}

	@Then("^user should be navigated to zipcode and plan year capture page for NonAEP in mobile$")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page_for_NonAEP_in_mobile() throws Throwable {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
	}

	@Then("^plan year dropdown should be not displayed during NonAEP in mobile$")
	public void plan_year_dropdown_should_not_be_displayed_during_AEP_in_mobile() throws Throwable {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validatePlanYearDrpDownNonAEP();
	}

	@And("^the user click on return to plan summary on DCE summary page$")
	public void the_user_clicks_on_return_to_plan_summary() {
		GetStartedPageMobile getStartedPage = (GetStartedPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		VPPPlanSummaryPageMobile plansummaryPage = getStartedPage.ClickReturnToPlanSummary();
		if (null != plansummaryPage) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}
	
	@When("^user toggle to PDP plan type on drug summary page$")
    public void user_toggle_to_PDP_plan_type_on_drug_summary_page() {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
        DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
        drugSummaryPage.verifyPDPPlanToggle();
    }
	
	@Then("^the user validates Not Covered Pharmacy message DCE Summary Page plan card$")
    public void the_user_validates_drug_pricing_message_for_notcovered_Pharmacy_selection_dce_summary_page() throws Throwable {
        DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
                .getBean(PageConstants.DCE_Redesign_DrugSummary);
        drugSummaryPage.ValidateNotCoveredPharMessage();
    }
	
	@When("^user toggle to SNP plan type on drug summary page$")
    public void user_toggle_to_SNP_plan_type_on_drug_summary_page() {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
        DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
        drugSummaryPage.verifySNPPlanToggle();
    }

	@Then("^user save the plan on drug detail page$")
	public void user_save_the_plan_on_drug_detail_page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);

		drugDetailsPage.savePlan();
	}
	
	@Then("^the user clicks on Enroll in plan and validates the Welcome to OLE Page$")
    public void the_user_clicks_on_Enroll_in_plan_and_validates_the_Welcome_to_OLE_Page() throws Throwable {
        DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
        WelcomePageMobile welcomepage = drugDetailsPage.clickEnrollinPlanbtn();
        if (null != welcomepage) {
            getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomepage);
        } else
            Assertion.fail("Welcome page  not loaded");
    }

	@Then("^the user searches and adds the following Drug for following quantity, frequency and Supplylength to Drug List$")
	public void the_user_searches_and_adds_the_following_Drug_for_following_quantity_frequency_and_Supplylength_to_Drug_List(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String drugName = memberAttributesMap.get("DrugName");
		String drugQuantity = memberAttributesMap.get("Quantity");
		String drugFrequency = memberAttributesMap.get("Frequency");
		String drugSupplyLen = memberAttributesMap.get("SupplyLen");
		System.out.println("DrugName" + drugName);
		System.out.println("Quantiry" + drugQuantity);
		System.out.println("Frequency" + drugFrequency);
		System.out.println("SupplyLength" + drugSupplyLen);
		BuildYourDrugListMobile buildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		TellUsAboutDrugMobile tellUsAboutDrug = buildDrugList.SearchaddDrugs(drugName);
		tellUsAboutDrug.selectQuantity(drugQuantity);
		tellUsAboutDrug.selectFrequency(drugFrequency);
		tellUsAboutDrug.selectSupplyLength(drugSupplyLen);
		buildDrugList = tellUsAboutDrug.ClickAddDrug();
		String druglist = (String) getLoginScenario().getBean(DCERedesignCommonConstants.DRUGLIST);

		System.out.println("Drugs List : " + druglist);

		// if (druglist.isEmpty()) {
		if (StringUtils.isEmpty(druglist)) {
			druglist = drugName;
		} else {
			druglist = druglist + "&" + drugName;
		}
		System.out.println("Drugs List after Drug " + drugName + " , Added : " + druglist);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, druglist);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildDrugList);
	}
	
	@Then("^the user validates 100-day Supply Messaging for Eligible Plan$")
    public void the_user_validates_100_day_Supply_Messaging_for_Eligible_Plan() throws Throwable {
        DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
                .getBean(PageConstants.DCE_Redesign_DrugDetails);
        drugDetailsPage.validate100DayInYourDrugs();
    }
	
	@When("^user should be able to toggle between plan types$")
    public void user_should_be_able_to_toggle_between_plan_types() throws InterruptedException {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
        DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
        drugSummaryPage.verifyPDPPlanToggle();
        drugSummaryPage.verifySNPPlanToggle();
        getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
    }
	
	@Then("^the user verify the default Retail chain pharmacy on drug summary page$")
    public void the_user_verify_the_default_Retail_chain_pharmacy_on_drug_summary_page(DataTable attributes) {
        Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
        memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
		/*List<DataTableRow> memberAttributesRow = attributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
        AppiumDriver wd = getLoginScenario().getMobileDriver();
        String pharmacyName = memberAttributesMap.get("DefaultPharmacy");
        DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
        drugSummaryPage.validateDefaultPharmacyName(pharmacyName);
    }

	@Then("^the user validates qty, frequency and Supply Length for following drug in DrugList Page$")
	public void the_user_validates_qty_frequency_and_Supply_Length_for_following_drug_in_DrugList_Page(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String drugName = memberAttributesMap.get("DrugName");
		String drugQuantity = memberAttributesMap.get("Quantity");
		String drugFrequency = memberAttributesMap.get("Frequency");
		String drugSupplyLen = memberAttributesMap.get("SupplyLen");
		System.out.println("DrugName : " + drugName);
		System.out.println("Quantiry : " + drugQuantity);
		System.out.println("Frequency : " + drugFrequency);
		System.out.println("SupplyLength : " + drugSupplyLen);
		BuildYourDrugListMobile buildDrugList = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		buildDrugList.validateDetailsForDrug(drugName, drugQuantity, drugFrequency, drugSupplyLen);

	}
	
	@When("^clicks on Review drug cost button to land on drug summary page$")
	public void clicks_on_Review_drug_cost_for_drug_summary_Page() {
		BuildYourDrugListMobile buildYourDrugListMobile = (BuildYourDrugListMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DrugSummaryPageMobile drugSummaryPageMobile = buildYourDrugListMobile.navigateToDrugSummaryPage();
		
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPageMobile);
	}
	
	@Then("^the user clicks view plan details button for first plan from Drug Summary Page$")
	public void the_user_clicks_plan_details_button_on_Drug_Details_Page() throws Throwable {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		
		PlanDetailsPageMobile planDetailsPage = drugSummaryPage.clickViewPlanDetails();
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, planDetailsPage);
		
	}
	
	@And("^the user clicks on DCE link to land on DCE Redesign from PDP Shop page$")
	public void the_user_clicks_on_DCE_link_to_land_on_DCE_Redesign_from_PDP_Shop_page() throws Throwable {
		AcquisitionHomePageMobile acquisitionHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		GetStartedPageMobile getStartedPage = acquisitionHomePage.clickDCERedesignLinkonShopPDPpage();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^the user validates OptumRx consistently displays on DCE Summary - Pharmacy Page$")
	public void the_user_validates_OptumRx_consistently_displays_on_DCE_Summary_Pharmacy_Page() throws Throwable {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateOptumRxConsistentDisplay_PharmacyPage();

	}
	
	@And("the user selects the sort by under your drugs")
	public void the_user_selects_the_sort_by_under_your_drugs(DataTable givenAttributes){
		Map<String, String> givenAttributesMap = new LinkedHashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String sortBy = givenAttributesMap.get("Sort By");
		System.out.println("Sort by to Select : "+sortBy);
		 DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
	                .getBean(PageConstants.DCE_Redesign_DrugDetails);
		 drugDetailsPage.validateDrugSortBy(sortBy);
		 getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
	}

	@Then("^the user verifies NBA modal for creating profile on drug summary page$")
	public void user_verifies_NBAmodal_creating_profile_on_drug_summary() {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateNBAModal();
	}
	
	@Then("the user clicks edit drugs on Compare page to land on Build Drug List Page")
	public void the_user_clicks_edit_drugs_on_compare_page_to_land_on_build_drug_list_page() {
		ComparePlansPageMobile planComparepage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		BuildYourDrugListMobile buildYourDrugList = planComparepage.clickonEdityourDrug();
		if (null != buildYourDrugList) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, buildYourDrugList);
		} else
			Assertion.fail("DCE Redesign page object not loaded");

	}
	
	@Then("the user validates default Plan type on DCE Summary page as follows")
    public void the_user_validates_default_plan_type_on_dce_summary_page_as_follows(DataTable givenAttributes) {
        Map<String, String> memberAttributesMap = new HashMap<String, String>();
        memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

        String planType = memberAttributesMap.get("Plan Type");
        System.out.println(planType);
        String PlanTypeText = "";
        if (planType.contains("MA")) {
            PlanTypeText = "Medicare Advantage Plan";
        } else if (planType.contains("PDP")) {
            PlanTypeText = "Prescription Drug Plan";
        } else {
            PlanTypeText = "Special Needs Plan";
        }
        DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
        drugSummaryPage.verifyDefaultPlanType(PlanTypeText);
        getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
    }
	
	@Then("the user clicks Return to Compare on DCE Summary Page to return to Compare page")
    public void the_user_clicks_return_to_compare_on_dce_summary_page_to_return_to_compare_page() {
        DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
        ComparePlansPageMobile comparePlansPlans = drugSummaryPage.ClickReturnToCompare();
    }

	@Then("^the user validates OptumRx consistently displays on DCE Details - Pharmacy Page$")
	public void the_user_validates_OptumRx_consistently_displays_on_DCE_Details_Pharmacy_Page() throws Throwable {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateOptumRxConsistentDisplay_PharmacyPage();
	}

	@Then("^the user validates qty, frequency and Supply Length for following drug in DCE Details Page$")
	public void the_user_validates_qty_frequency_and_Supply_Length_for_following_drug_in_DCE_Details_Page(DataTable givenAttributes) throws Throwable {
		
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		
		
		String drugName = memberAttributesMap.get("DrugName");
		String drugQuantity = memberAttributesMap.get("Quantity");
		String drugFrequency = memberAttributesMap.get("Frequency");
		String drugSupplyLen = memberAttributesMap.get("SupplyLen");
		System.out.println("DrugName : "+drugName);
		System.out.println("Quantiry : "+drugQuantity);
		System.out.println("Frequency : "+drugFrequency);
		System.out.println("SupplyLength : "+drugSupplyLen);
		
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateDetailsForDrugInYourDrugs(drugName,drugQuantity,drugFrequency,drugSupplyLen);}
	
	@When("^user selects plan year for OLE$")
	public void user_selects_plan_year(DataTable givenAttributes) {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String planYear = givenAttributesMap.get("Plan Year");
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = (ZipCodeAndPlanYearCapturePageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.selectPlanYearOLE(planYear);
	}
	
	@Then("^the user validates the dynamic error message displayed for filter that has no result$")
	public void the_user_validates_the_dynamic_error_message_displayed_for_filter_that_has_no_result(DataTable givenAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String pharmacyErrorType = givenAttributesMap.get("PharmacyErrorType");

		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.validateDynamicErrorMessageDisplay(pharmacyErrorType);
	}
	
	 @Then("^the user applies pharmacy filter for following text on Details page - Change Pharmacy Page$")
	    public void the_user_applies_pharmacy_filter_for_following_text_on_Details_page_Change_Pharmacy_Page(DataTable attributes) throws Throwable {
	        Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	        memberAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
	        String FilterText = memberAttributesMap.get("PharmacyFilterText");
	        DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
	                .getBean(PageConstants.DCE_Redesign_DrugDetails);
	        drugDetailsPage.ApplyPharmacyFilter(FilterText);
	    }
	 
	 @And("user verify the drug details page")
     public void user_verify_the_drug_details_page() {
    	 DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugDetails);
         drugDetailsPage.validateDrugDetailsPage();
         getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails, drugDetailsPage);
     }
	 
	 @When("user clicks on Return to profile link on summary page")
     public void user_clicks_on_return_to_profile_link_on_summary_page() {
    	 DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
                 .getBean(PageConstants.DCE_Redesign_DrugSummary);
    	 drugSummaryPage.clickReturnToProfile();
      }

}
