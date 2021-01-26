package acceptancetests.mobile.acquisition.planrecommendationengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDrugsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineEditResponsePage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineHeaderAndFooter;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEnginePrioritiesPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineResultsPage;
import pages.mobile.acquisition.bluelayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.planrecommendationengine.CoverageOptionsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DoctorsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DrugMobilePage;
import pages.mobile.acquisition.planrecommendationengine.HeaderFooterMobile;
import pages.mobile.acquisition.planrecommendationengine.LandingAndZipcodeMobilePage;
import pages.mobile.acquisition.planrecommendationengine.LoadingMobilePage;
import pages.mobile.acquisition.planrecommendationengine.PharmacyMobilePage;
import pages.mobile.acquisition.planrecommendationengine.PrioritiesMobilePage;
import pages.mobile.acquisition.planrecommendationengine.ResultsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.SpecialNeedsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.TravelMobilePage;
import pages.mobile.acquisition.planrecommendationengine.ACQDrugCostEstimatorPage;
import pages.mobile.acquisition.planrecommendationengine.AdditionalServicesMobilePage;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;
import pages.mobile.acquisition.planrecommendationengine.CostPreferencesMobilePage;
import pages.mobile.acquisition.planrecommendationengine.EditResponseMobilePage;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.mobile.acquisition.vpp.VPPCommonConstantsMobile;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Harshal Ahire
 */

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.mobile.acquisition.bluelayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.bluelayer.PlanSelectorNewPageMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineAdditionalServicesPageMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineCommonutilityMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineCostPreferencesPageMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineCoverageOptionPageMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineDoctorsPageMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineDrugsPageMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineEditResponsePageMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineHeaderAndFooterMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineLandingAndZipcodeMobilePages;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEnginePharmacyPageMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEnginePrioritiesPageMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineResultsPageMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineSpecialNeedsPageMobile;
import pages.mobile.acquisition.planrecommendationengine.PlanRecommendationEngineTravelPageMobile;

public class PlanRecommendationStepDefinitionMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;
	List<DataTableRow> inputRow;
	HashMap<String, String> inputValues;
	public static String PREflow = "";

	public void readfeaturedataMobile(DataTable data) {
		inputRow = new ArrayList(data.getGherkinRows());
		inputValues = new HashMap<String, String>();
		for (int i = 0; i < inputRow.size(); i++) {
			inputValues.put(inputRow.get(i).getCells().get(0), inputRow.get(i).getCells().get(1));
		}
		String temp = inputValues.get("Plan Type");
		if (temp != null && PREflow != temp) {
			PREflow = temp;
			System.out.println("Current PRE Flow : " + PREflow);
		}
	}
	
	@And("^user validate druglist in Drug Cost Estimator page$")
	public void Druglist_DCE() {
		ACQDrugCostEstimatorPage dceDrugs =  new ACQDrugCostEstimatorPage(wd);
		dceDrugs.getDruglist();
	}
	
	@Then("^user verify drug list are same in DCE VS Drug page$")
  	public void verify_drugs_dce_vs_drug_page(DataTable givenAttributes) {
  		readfeaturedataMobile(givenAttributes);
  		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage =  new PlanRecommendationEngineDrugsPageMobile(wd);
  		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
  		planSelectorDrugspage.comparingDrugsDCEvsPRE();
  	}
	
	@Then("^user validate navigate to Get a Plan Recomendation page$")
	public void navigate_PRE() {
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter =  new PlanRecommendationEngineHeaderAndFooterMobile(wd);
		headerAndFooter.navigationToPlanRecommendationEngine();
	}
	
	@When("^user validate navigate to Drug Cost Estimator page$")
	public void navigate_DCE() {
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter =  new PlanRecommendationEngineHeaderAndFooterMobile(wd);
		headerAndFooter.navigationToDrugCostEstimatorViaShopTools();
	}

	@Then("^user save recommendation results and validate in VP$")
   	public void save_results(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineEditResponsePageMobile preEditpage =  new PlanRecommendationEngineEditResponsePageMobile(wd);
		checkpopup();
		preEditpage.validateSaveResults(inputValues.get("Plan Type"));
	}
	

	@Then("^user selects priority in priorities page$")
	public void user_selects_priorities(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEnginePrioritiesPageMobile priorities =  new PlanRecommendationEnginePrioritiesPageMobile(wd);
		priorities.prioritiesFunctional(inputValues.get("Priority Option"),inputValues.get("Priorities"));
		priorities.continuePriority();
	}

	@Then("^user validate drugs details from VPP to DCE page$")
	public void drugs_VPP_DCE_page() {
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage =  new PlanRecommendationEngineResultsPageMobile(wd);
		planSelectorResultspage.DrugsDetailsVPPtoDCE();
	}
	
	
	@Given("^the user is on UHC medicare acquisition site mobile$")
	public void the_user_on_uhc_medicaresolutions_site_mobile() {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openPRE();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^user navigates to PRE landing page mobile$")
	public void user_navigates_PRE_landingpage_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile(wd);
		preheaderfootermobile.navigatePRELandingpageMobile();
	}

	@When("^user navigates to PRE landing page via shop tool mobile$")
	public void user_navigates_PRE_landingpage_shoptool_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile(wd);
		preheaderfootermobile.navigationToPREViaShopToolsMobile();
	}

	@When("^user navigates to Zip Code page mobile$")
	public void user_navigates_to_zipcode_page_mobile() {
		HeaderFooterMobile header = new HeaderFooterMobile(wd);
		header.navigatePRELandingpageMobile();
		LandingAndZipcodeMobilePage prelandingpage = new LandingAndZipcodeMobilePage(wd);
		prelandingpage.navigatezipcodepagemobile();
	}

	@When("^user navigates to \"([^\\\"]*)\" page mobile$")
	public void user_navigates_to_given_page_mobile(String pageName, DataTable inputdata) {
		// LandingAndZipcodeMobilePage prelandingpage = new
		// LandingAndZipcodeMobilePage(wd);
		// prelandingpage.navigatepagemobile(pageName);
	}

	@Then("^user validate elements on landing page of Plan Recommendation Engine mobile$")
	public void user_check_landing_page_Plan_Selector_tool_mobile() {
		// System.out.println("Device Type "+inputValues.get("Device Type"));
		LandingAndZipcodeMobilePage prelandingpagemobile = new LandingAndZipcodeMobilePage(wd);
		prelandingpagemobile.landingpageElementsmobile();
	}

	@Then("^user validate presence of Header elements on landing page mobile$")
	public void user_check_header_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile(wd);
		preheaderfootermobile.headerElementsMobile();
	}

	@Then("^user validate presence of Footer elements on landing page mobile$")
	public void user_check_Footer_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile(wd);
		preheaderfootermobile.footerElementsMobile();
	}

	@Then("^user validate Header Functionality of Plan Recommendation Engine mobile$")
	public void user_check_header_functionalities_mobile(DataTable inputdata) {
		readfeaturedataMobile(inputdata);
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile(wd);
		preheaderfootermobile.zipcodeFunctionInShopforaplanHeaderMobile(inputValues.get("Zip Code"));
		preheaderfootermobile.emailFunctionInShopforaplanMobile(inputValues.get("EMail"));
		// preheaderfootermobile.enterSearchFunctionHeaderMobile(inputValues.get("Search
		// Key"));
	}

	@Then("^user validate Footer Functionality of Plan Recommendation Engine mobile$")
	public void user_check_Footer_functionalities_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile(wd);
		preheaderfootermobile.backtoTopFunctionMobile();
	}

	@Then("^user validates all Links from header mobile$")
	public void user_check_header_link_validation_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile(wd);
		preheaderfootermobile.headerLinkvalidationMobile();
	}

	@Then("^user validates all Links from footer mobile$")
	public void user_check_Footer_link_validation_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile(wd);
		preheaderfootermobile.footerLinkvalidationMobile();
	}

	@Then("^user validates zipcode page elements mobile$")
	public void user_check_zipcodepage_elements_mobile() {
		LandingAndZipcodeMobilePage prezipcodemobile = new LandingAndZipcodeMobilePage(wd);
		prezipcodemobile.zipcodepageElementsmobile();
	}

	@And("^runs questionnaire at zipcode page mobile$")
	public void user_runs_questionnaire_zipcodepage_mobile(DataTable inputdata) {
		LandingAndZipcodeMobilePage prezipcodemobile = new LandingAndZipcodeMobilePage(wd);
		readfeaturedataMobile(inputdata);
		prezipcodemobile.zipcodepageValidationmobile(inputValues);
	}

	@Then("^runs questionnaire at zipcode page with invalid data mobile$")
	public void user_runs_questionnaire_zipcodepage_invalid_data_mobile(DataTable inputdata) {
		LandingAndZipcodeMobilePage prezipcodemobile = new LandingAndZipcodeMobilePage(wd);
		readfeaturedataMobile(inputdata);
		prezipcodemobile.zipcodescreenErrorValidationmobile(inputValues);
	}

	@Then("^user validate elements in coverage options page mobile$")
	public void user_check_coveragepage_elements_mobile() {
		CoverageOptionsMobilePage coveragepage = new CoverageOptionsMobilePage(wd);
		coveragepage.coverageOptionpageElementsMobile();
	}

	@Then("^user selects plan type in coverage options page mobile$")
	public void select_plan_type_coverage_page_mobile(DataTable inputdata) throws Throwable {
		readfeaturedataMobile(inputdata);
		CoverageOptionsMobilePage coveragepage = new CoverageOptionsMobilePage(wd);
		String plantype = inputValues.get("Plan Type");
		if (!(plantype.isEmpty())) {
			coveragepage.coverageOptionpageFunctionalMobile(plantype, true);
		} else {
			coveragepage.coverageOptionpageErrormobile();
		}
	}

	@And("^user select planType and continous the page back to previous page mobile$")
	public void previous_coverage_page_mobile(DataTable inputdata) throws Throwable {
		readfeaturedataMobile(inputdata);
		CoverageOptionsMobilePage coveragepage = new CoverageOptionsMobilePage(wd);
		coveragepage.coverageOptionpageFunctionalMobile(inputValues.get("Plan Type"), false);
		coveragepage.previouspageValidation();
	}

	@Then("^user validate elements in Special Needs page mobile$")
	public void elements_special_page_mobile() {
		SpecialNeedsMobilePage specialneedspage = new SpecialNeedsMobilePage(wd);
		specialneedspage.specialNeedspageElements();
	}

	@And("^user selects SNP options in Special Needs Page mobile$")
	public void select_special_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		SpecialNeedsMobilePage specialneedspage = new SpecialNeedsMobilePage(wd);
		String status = "Positive";
		specialneedspage.specialneedspage(inputValues.get("SNP Options"), status);
	}

	@And("^user selects SNP options in Special Needs Page and validate errors mobile$")
	public void select_special_needs_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		SpecialNeedsMobilePage specialneedspage = new SpecialNeedsMobilePage(wd);
		String status = "Negative";
		specialneedspage.specialneedspage(inputValues.get("SNP Options"), status);
	}

	@Then("^user validate elements in Travel page mobile$")
	public void elements_travel_page_mobile() {
		TravelMobilePage careawaypage = new TravelMobilePage(wd);
		careawaypage.travelpageElements();
	}

	@And("^user selects Travel options in Travel Page mobile$")
	public void select_travel_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		TravelMobilePage careawaypage = new TravelMobilePage(wd);
		String status = "Positive";
		careawaypage.travelpage(inputValues.get("Travel Options"), status);
	}

	@And("^user selects Travel options in Travel Page and validate errors mobile$")
	public void select_travel_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		TravelMobilePage careawaypage = new TravelMobilePage(wd);
		String status = "Negative";
		careawaypage.travelpage(inputValues.get("Travel Options"), status);
	}

	@Then("^user validate elements in Doctors page mobile$")
	public void elements_doctors_page_mobile() {
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		doctorpage.doctorspageElements();
	}

	@Then("^user selects Doctors in Doctors page mobile$")
	public void select_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		String status = "Positive";
		doctorpage.doctorspage(inputValues.get("Doctors Selection"), inputValues.get("Doctors Search Text"),
				inputValues.get("Multi Doctor"), status);
	}

	@And("^user selects Doctors in Doctors page and validate errors mobile$")
	public void select_doctors_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		String status = "Negative";
		doctorpage.doctorspage(inputValues.get("Doctors Selection"), inputValues.get("Doctors Search Text"),
				inputValues.get("Multi Doctor"), status);
	}

	@And("^user selects Doctors in Doctors page and cancels the selection mobile$")
	public void select_doctors_page_cancelvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		doctorpage.doctorspageCancel(inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"));
	}

	@Then("^user validate elements in Drug page mobile$")
	public void elements_drug_page_mobile() {
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugspageElements();
	}

	@Then("^user selects skip option in Drug page mobile$")
	public void elements_drugskip_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.skipDrugs(inputValues.get("Drug Selection"));
	}

	@Then("^user selects add drug option in Drug page mobile$")
	public void add_drugs_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugsHandlerWithdetails(inputValues.get("Drug Details"));
		drugpage.continueNextpage();
	}

	@Then("^user selects add drug option and cancels the modals in Drug page mobile$")
	public void add_drugs_page_cancelvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugspageCancel(inputValues.get("Drug Details"));
	}

	@Then("^user validates errors in Drug page mobile$")
	public void add_drugs_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugpagesError(inputValues.get("Drug Details"));
	}

	@Then("^user search and choose a drug in Drug page mobile$")
	public void choose_drugs_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugChoose(inputValues.get("Search Text"), inputValues.get("Drug Details"));
		drugpage.continueNextpage();
	}

	@Then("^user selects add drug option without drugs in Drug page mobile$")
	public void add_NoDrug_drugs_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.continueNextpageZeroDrug();
	}

	@Then("^user search and not found a drug in Drug page mobile$")
	public void notfound_drugs_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugNotFound(inputValues.get("Search Text"));
	}

	@Then("^user validate elements in Pharmacy page mobile$")
	public void elements_pharmacy_page_mobile() {
		PharmacyMobilePage pharmacypage = new PharmacyMobilePage(wd);
		pharmacypage.pharmacypageElements();
	}

	@Then("^user selects Pharmacy in Pharmacy page mobile$")
	public void select_pharmacy_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PharmacyMobilePage pharmacypage = new PharmacyMobilePage(wd);
		String status = "Positive";
		pharmacypage.pharmacyFunctional(inputValues.get("Pharmacy Selection"), status);
	}

	@And("^user selects Pharmacy in Pharmacy page and validate errors mobile$")
	public void select_pharmacy_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PharmacyMobilePage pharmacypage = new PharmacyMobilePage(wd);
		String status = "Negative";
		pharmacypage.pharmacyFunctional(inputValues.get("Pharmacy Selection"), status);
	}

	@Then("^user validate elements in additional services page mobile$")
	public void elements_additional_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		AdditionalServicesMobilePage additionalpage = new AdditionalServicesMobilePage(wd);
		additionalpage.additionalpage(inputValues.get("Drug Selection"));
	}

	@Then("^user selects additional services option in additional services page mobile$")
	public void select_additionalServiceOption_additional_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		AdditionalServicesMobilePage additionalpage = new AdditionalServicesMobilePage(wd);
		additionalpage.additionalpageFunctional(inputValues.get("Additional Option"));
	}

	@Then("^user validates additional services error function in additional services page mobile$")
	public void select_additional_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		AdditionalServicesMobilePage additionalpage = new AdditionalServicesMobilePage(wd);
		additionalpage.additionalpageerror(inputValues.get("Additional Option"));
	}

	@Then("^user validate elements in cost preferences page mobile$")
	public void elements_costpreferences_page_mobile() {
		CostPreferencesMobilePage costpage = new CostPreferencesMobilePage(wd);
		costpage.costpreferencepage();
	}

	@Then("^user selects cost preferences option in cost preferences page mobile$")
	public void select_costPreferenceOption_costpreferences_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		CostPreferencesMobilePage costpage = new CostPreferencesMobilePage(wd);
		costpage.costPreferencepageFunctional(inputValues.get("Preference Option"));
	}

	@Then("^user validates cost preferences error function in cost preferences page mobile$")
	public void select_costpreferences_page_errorvalidation_mobile() {
		CostPreferencesMobilePage costpage = new CostPreferencesMobilePage(wd);
		costpage.costPreferencepageerror();
	}

	@Then("^user validate elements in loading page mobile$")
	public void elements_loading_page_mobile() {
		LoadingMobilePage loadingpage = new LoadingMobilePage(wd);
		loadingpage.loadingresultspage();
	}

	@Then("^user validate recommendations in results page mobile$")
	public void view_recommendations_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		resultpage.resultsUI(zip, county, r1, r2, false);
	}

	@Then("^user validate tie recommendations in results page mobile$")
	public void view_tie_recommendations_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		resultpage.resultsUI(zip, county, r1, r2, true);
	}

	@Given("^user navigates to vpp summary page mobile$")
	public void navigate_vpp_summary_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		resultpage.navigateVPP(inputValues);
	}

	@Then("^user adds Doctors in vpp summary page mobile$")
	public void add_providers_vpp_summary_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		resultpage.addProviderVPP(inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"));
	}

	@Then("^user navigate Doctors lookup session in Doctors page mobile$")
	public void navigate_doctors_lookup_session_mobile() {
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		doctorpage.navigateDoctorsmodalsession();
	}

	@When("^user navigates to Zip Code page from vpp mobile$")
	public void user_navigates_to_zipcode_page_fromvpp_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		resultpage.navigatePRE();
		LandingAndZipcodeMobilePage prelandingpage = new LandingAndZipcodeMobilePage(wd);
		prelandingpage.navigatezipcodepagemobile();
	}

	@And("^user verifies doctors session in Doctors page mobile$")
	public void verify_doctors_session_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		resultpage.getProvidersPRE(multiDoctor);
		resultpage.verifyProvidersSession(multiDoctor);
	}

	@Then("^user adds Providers in Doctors page mobile$")
	public void add_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		doctorpage.addProvidersPRE(inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"));
	}

	@And("^user verifies doctors session in VPP page mobile$")
	public void verify_doctors_session_vpp_page_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		resultpage.verifyProviderPREVPP();
	}

	@Then("^user adds drugs in Drug page mobile$")
	public void add_drugsPRE_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.addDrugsPRE(inputValues.get("Drug Details"));
		drugpage.getDrugsdetails();
		drugpage.continueNextpage();
	}

	@And("^user verifies drugs session in VPP page mobile$")
	public void verify_drugs_session_vpp_page_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		resultpage.verifyDrugPREVPP();
	}

	@Then("^user edits Doctors in Doctors page mobile$")
	public void edit_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		doctorpage.editProvider(inputValues.get("Doctors Search Text1"), inputValues.get("Multi Doctor1"),
				inputValues.get("Doctors Search Text2"), inputValues.get("Multi Doctor2"));
	}

	@When("^user navigates to Zip Code page from vpp plans mobile$")
	public void user_navigates_to_zipcode_page_fromvpp_pdp_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		resultpage.navigateVPPPRE();
		LandingAndZipcodeMobilePage prelandingpage = new LandingAndZipcodeMobilePage(wd);
		prelandingpage.navigatezipcodepagemobile();
	}

	@And("^user validte zip info in location page mobile$")
	public void user_validates_zipcodepage_mobile(DataTable inputdata) {
		LandingAndZipcodeMobilePage prezipcodemobile = new LandingAndZipcodeMobilePage(wd);
		readfeaturedataMobile(inputdata);
		prezipcodemobile.zipcodeInfoValidationmobile(inputValues);
	}

	@When("^user navigates to Zip Code page from vpp plans using startover mobile$")
	public void user_navigates_to_zipcode_page_fromvpp_pdp_startover_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		resultpage.navigateVPPPREStartover();
		LandingAndZipcodeMobilePage prelandingpage = new LandingAndZipcodeMobilePage(wd);
		prelandingpage.navigatezipcodepagemobile();
	}

	@And("^user verifies existing PRE provider session using startover mobile$")
	public void verify_exisitng_pre_doctors_session_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage docpage = new DoctorsMobilePage(wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		docpage.verifyExisitngPREDoclist(multiDoctor);
		docpage.nextPageValidationDoctor();
	}

	@And("^user verifies exisitng PRE drug session using startover mobile$")
	public void verify_exisitng_pre_drugs_session_drug_page_mobile() {
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.verifyExisitngPREDruglist();
		drugpage.continueNextpage();
	}

	@Then("^user validte error function in drug option selection page mobile$")
	public void drugs_option_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.chooseOption(inputValues.get("Drug Selection"));
	}

	@Then("^user validate recommendation rankings in results page mobile$")
	public void verify_rankings_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		String recom = inputValues.get("Recommendation");
		String plansorder = inputValues.get("Ranking plans Order");
		resultpage.validateRankingPlans(recom, plansorder);
	}

	@Then("^verify continue function on \"([^\"]*)\" page mobile$")
	public void proceed_next_page_mobile(String page) {
		CommonutilitiesMobile mobiletutli = new CommonutilitiesMobile(wd);
		mobiletutli.continueNextpage(page.trim().toUpperCase(), false);
	}

	@And("^user verifies existing PRE provider session using startnow mobile$")
	public void verify_exisitng_pre_doctors_session_doctors_startnow_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage docpage = new DoctorsMobilePage(wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		docpage.verifyExisitngPREDoclist(multiDoctor);
		docpage.nextPageNameValidationDoctor();
	}

	@And("^user verifies exisitng PRE drug session using startnow mobile$")
	public void verify_exisitng_pre_drugs_session_drug_startnow_page_mobile() {
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.verifyExisitngPREDruglist();
		drugpage.continueNextpageNameDrug();
	}

	@When("^user validate email plan list from vpp mobile$")
	public void user_sendPlanEmail_fromvpp_pdp_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		String recom = inputValues.get("Recommendation");
		String email = inputValues.get("EmailID");
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		resultpage.sendEmail(recom, email);
	}

	@Then("^user selects Doctors in Doctors page and validate next page name mobile$")
	public void select_doctors_next_page_name_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		String status = "Positive_NextPageName";
		doctorpage.doctorspage(inputValues.get("Doctors Selection"), inputValues.get("Doctors Search Text"),
				inputValues.get("Multi Doctor"), status);
	}

	@Then("^user validate UI and API recommendation rankings in results page mobile$")
	public void verify_UIAPI_rankings_results_page_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		resultpage.validateUIAPIRecommendations();
		resultpage.validateUIAPIRankingPlans();
	}

	@Then("^user adds Drugs in vpp summary page mobile$")
	public void add_drugs_vpp_summary_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		resultpage.useraddDrugsVPP(inputValues.get("Drug Details"));
	}

	@Then("^user navigate drugs list page and verifies drugs session in Drugs page mobile$")
	public void verifies_drugs_vpp_pre__mobile() {
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.verifyExisitngVPPDruglist();
	}

	@Then("^user verifies \"([^\"]*)\" page mobile$")
	public void verify_vpp_summary_page_mobile(String VPP) {
		ResultsMobilePage resultpage = new ResultsMobilePage(wd);
		if (VPP.toUpperCase().contains("PRE"))
			resultpage.checkVPP(true);
		else
			resultpage.checkVPP(false);
	}

	@Then("^user verifies \"([^\"]*)\" page$")
	public void verify_vpp_summary_page_mobile1(String VPP) {
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		if (VPP.toUpperCase().contains("PRE"))
			planSelectorResultspage.checkVPP(true);
		else
			planSelectorResultspage.checkVPP(false);
	}
	
	@Then("^user adds Drugs in Drug Cost Estimator page$")
   	public void add_drugs_DCE_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(wd);
		dce.useraddDrugsDCEWithoutVPP(inputValues.get("Drug Details"));
   	}

	@When("^user navigates to PRE landing page menu mobile$")
	public void user_navigates_PRE_landingpage_menu_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile(wd);
		preheaderfootermobile.navigatePRELandingpageMenuMobile();
	}

	// Edit Page Mobile
	@Then("^user validate saved values in edit response page mobile$")
	public void check_saved_value_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage(wd);
		preEditMobile.editResponsepage(inputValues);
	}

	@Then("^user return to vpp page using \"([^\"]*)\" from edit response page mobile$")
	public void check_saved_value_editResponse_page(String button) {
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage(wd);
		preEditMobile.returnVPP(button);
	}

	@Then("^user edits values in edit response page mobile$")
	public void edit_saved_value_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage(wd);
		preEditMobile.editUserResponse(inputValues);
	}

	@Then("^user adds doctor in edit response page mobile$")
	public void add_doctor_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage(wd);
		preEditMobile.addDoctorEditResponse(inputValues);
	}

	@Then("^user navigates to edit response page mobile$")
	public void navigate_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage(wd);
		preEditMobile.navigateEditResponsePageMobile(inputValues);
	}

	@Then("^user edits coverage value in edit response page mobile$")
	public void edit_coverage_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage(wd);
		preEditMobile.changeCoverage(inputValues);}


	@Then("^user validate elements in priorities page mobile$")
	public void user_validate_prioritiesElements() {
		PrioritiesMobilePage prioritiesMobile =  new PrioritiesMobilePage(wd);
		prioritiesMobile.prioritiesElementsMobile();

	}

	@Then("^user validates coverage value in edit response page mobile$")
	public void validate_coverage_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage(wd);
		preEditMobile.checkCoveragevalue(inputValues);
	}

	@Then("^user selects add drug option in drug page from edit response page mobile$")
	public void add_drug_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage(wd);
		preEditMobile.addDrugs(inputValues);
	}

	boolean if_offline_prod = false, popup_clicked = false;

	@Given("^the user is on UHC medicare acquisition site landing page$")
	public void the_user_on_uhc_medicaresolutions_Site() {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		// AcquisitionHomePageMobile aquisitionhomepage = new
		// AcquisitionHomePageMobile(wd, "PRE", true);
		// if_offline_prod = aquisitionhomepage.openMobileURL();
		aquisitionhomepage.openMobileURL();
		// aquisitionhomepage.fixPrivateConnection();
		checkpopup();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	/*
	 * @Given("^the user is on UHC medicare acquisition site landing page$") public
	 * void the_user_on_uhc_medicaresolutions_Site() { wd =
	 * getLoginScenario().getMobileDriver(); AcquisitionHomePageMobile
	 * aquisitionhomepage = new AcquisitionHomePageMobile(wd); //
	 * aquisitionhomepage.openPRE(); aquisitionhomepage.openMobileURL(); //
	 * aquisitionhomepage.openVPPPage();
	 * aquisitionhomepage.fixPrivateConnectionMobile();
	 * getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	 * getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
	 * aquisitionhomepage); }
	 */

	@And("^clicks on get started button and runs questionnaire$")
	public void clicks_on_get_started_button_and_directly_skip_to_results(DataTable givenAttributes) throws Throwable {

		readfeaturedataMobile(givenAttributes);

		String zipcode = inputValues.get("Zip Code");
		System.out.println("Zipcode is:" + zipcode);
		String county = inputValues.get("CountyDropDown");
		System.out.println("Email is:" + county);
		String isMultiCounty = inputValues.get("Is Multi County");
		System.out.println("Entered Search Key is:" + isMultiCounty);
		checkpopup();
		PlanRecommendationEngineLandingAndZipcodeMobilePages planSelectorhomepage = new PlanRecommendationEngineLandingAndZipcodeMobilePages(
				(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		if (isMultiCounty.equalsIgnoreCase("NO")) {
			planSelectorhomepage.quizStartsAndRunQuestionnaire(zipcode);
		} else {
			planSelectorhomepage.quizStartAndRunQuestionnaireWithCounty(zipcode, county);
		}
	}

	@And("^clicks on get started button and runs questionnaires$")
	public void clicks_on_get_started_button_and_directly_skip_to_results1(DataTable givenAttributes) throws Throwable {

		readfeaturedataMobile(givenAttributes);

		String zipcode = inputValues.get("Zip Code");
		System.out.println("Zipcode is:" + zipcode);
		String county = inputValues.get("CountyDropDown");
		System.out.println("Email is:" + county);
		String isMultiCounty = inputValues.get("Is Multi County");
		System.out.println("Entered Search Key is:" + isMultiCounty);
		checkpopup();
		PlanRecommendationEngineLandingAndZipcodeMobilePages planSelectorhomepage = new PlanRecommendationEngineLandingAndZipcodeMobilePages(
				(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		if (isMultiCounty.equalsIgnoreCase("NO")) {
			planSelectorhomepage.quizStartsAndRunQuestionnaire(zipcode);
		} else {
			planSelectorhomepage.quizStartAndRunQuestionnaireWithCounty(zipcode, county);
		}
	}
	
	@And("^I select my Response and go to Next Questionnaire$")
	public void I_click_questionnaire_first() throws Throwable {
		PlanSelectorNewPageMobile planSelectorNewPage = (PlanSelectorNewPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		planSelectorNewPage.NextQuestion();
	}

	@And("^I select my second Response and go directly to results page$")
	public void I_click_questionnaire_second() throws Throwable {
		PlanSelectorNewPageMobile planSelectorNewPage = (PlanSelectorNewPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		boolean isResultsPage = planSelectorNewPage.JumpLink();
		Assert.assertTrue("Plan Results Page not loaded", isResultsPage);
	}

	@When("^I click plan detail button$")
	public void i_click_plan_detail_button() throws Throwable {
		String County = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.COUNTY);
		PlanSelectorNewPageMobile planSelectorNewPage = (PlanSelectorNewPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		boolean isPlanDetailsPage = planSelectorNewPage.navigateToPlanDetails(County);
		Assert.assertTrue("Plan Details Page is not loaded", isPlanDetailsPage);

	}

	@Then("^the user clicks on both top and bottom back to plan options link and validates its redirection$")
	public void i_should_be_brought_back_to_the_plan_selector_results_page() throws Throwable {
		PlanSelectorNewPageMobile planSelectorNewPage = (PlanSelectorNewPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		planSelectorNewPage.verifyBackToPlanOptionslink();

	}

	@When("^user navigate to Plan Recommendation Engine and Checking Breadcrumbs$")
	public void user_navigate_PRE_Breadcrumbs() throws InterruptedException {
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		headerAndFooter.navigationToPlanRecommendationEngineViaShopTools();
		// headerAndFooter.breadCrumbs();

	}

	@When("^user navigate Plan Recommendation Engine Using Shop From Home in Find Your Plan$")
	public void navigate_Plan_Selector_tool() {
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);

		headerAndFooter.navigationToPlanRecommendationEngineViaShopTools();

		/// headerAndFooter.breadCrumbs();
	}

	@Then("^user validate elements on landing page of Plan Recommendation Engine$")
	public void user_check_landing_page_Plan_Selector_tool() throws InterruptedException {
		PlanRecommendationEngineLandingAndZipcodeMobilePages planSelectorhomepage = new PlanRecommendationEngineLandingAndZipcodeMobilePages(
				wd);
		planSelectorhomepage.landingpage();
	}

	@Then("^user validate Header elements and Link Validation of Plan Recommendation Engine$")
	public void user_check_header_Plan_Selector_tool() {
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		headerAndFooter.headerElements();
		headerAndFooter.headerLinkvalidation();
	}

	@Then("^user validate Footer elements and Link Validation of Plan Recommendation Engine$")
	public void user_check_header_footer_Plan_Selector_tool() throws Exception {
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		headerAndFooter.footerElements();
		headerAndFooter.footerLinkvalidation();
	}

	@Then("^user validate Header and Footer Functionality of Plan Recommendation Engine$")
	public void user_check_header_footer_Actions_Plan_Selector_tool(DataTable givenAttributes) throws Throwable {
		String actualpageurl = wd.getCurrentUrl();
		readfeaturedataMobile(givenAttributes);
		String zipcode = inputValues.get("Zip Code");
		System.out.println("Zipcode is:" + zipcode);
		String email = inputValues.get("EMail");
		System.out.println("Email is:" + email);
		String searchKey = inputValues.get("Search Key");
		System.out.println("Entered Search Key is:" + searchKey);
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		headerAndFooter.zipcodeFunctionInShopforaplan(zipcode);
		Thread.sleep(5000);
		headerAndFooter.emailFunctionInShopforaplan(email);
		Thread.sleep(5000);
		if (actualpageurl.contains("uhcmedicaresolutions")) {
			headerAndFooter.enterSearchFunction(searchKey);
			Thread.sleep(5000);
		}
		headerAndFooter.backtoTopFunction();
	}

	@And("^clicks on get started button and check error scenarios$")
	public void clicks_on_get_started_button_and_check_error_scenarios(DataTable givenAttributes) throws Throwable {
		readfeaturedataMobile(givenAttributes);
		String zipcode = inputValues.get("Zip Code");
		String county = inputValues.get("CountyDropDown");
		String isMultiCounty = inputValues.get("Is Multi County");
		PlanRecommendationEngineLandingAndZipcodeMobilePages planSelectorhomepage = new PlanRecommendationEngineLandingAndZipcodeMobilePages(
				wd);
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		// headerAndFooter.breadCrumbs();
		if (isMultiCounty.equalsIgnoreCase("NO")) {
			planSelectorhomepage.getStartedAndRunInvalidzipcode(zipcode);
		} else {
			planSelectorhomepage.getStartedAndRunzipcodeWithCounty(zipcode, county);
		}

	}

	@And("^user validate elements in coverage options page$")
	public void elements_coverage_page() {
		PlanRecommendationEngineCoverageOptionPageMobile planSelectorCoverageepage = new PlanRecommendationEngineCoverageOptionPageMobile(
				wd);
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		// headerAndFooter.breadCrumbs();
		planSelectorCoverageepage.coverageOptionpage();

	}

	@And("^user selects plan type in coverage options page$")
	public void select_plan_type_coverage_page(DataTable givenAttributes) throws Throwable {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineCoverageOptionPageMobile planSelectorCoverageepage = new PlanRecommendationEngineCoverageOptionPageMobile(
				wd);
		String plantype = inputValues.get("Plan Type");
		if (!(plantype.isEmpty())) {
			planSelectorCoverageepage.coverageOptionpageFunctional(plantype);
		}
	}

	@And("^user not selects plan type in coverage options page$")
	public void notselect_plan_type_coverage_page(DataTable givenAttributes) throws Throwable {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineCoverageOptionPageMobile planSelectorCoverageepage = new PlanRecommendationEngineCoverageOptionPageMobile(
				wd);
		String plantype = inputValues.get("Plan Type");
		if (plantype.isEmpty()) {
			planSelectorCoverageepage.coverageOptionpageerror();
		}
	}

	@And("^user select planType and continous the page back to previous page$")
	public void previous_coverage_page(DataTable givenAttributes) throws Throwable {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineCoverageOptionPageMobile planSelectorCoverageepage = new PlanRecommendationEngineCoverageOptionPageMobile(
				wd);
		planSelectorCoverageepage.coverageOptionpageFunctional(inputValues.get("Plan Type"));
	}

	@And("^user select planType and Click previous button to check previous page$")
	public void previous_zipcode_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineCoverageOptionPageMobile planSelectorCoverageepage = new PlanRecommendationEngineCoverageOptionPageMobile(
				wd);
		planSelectorCoverageepage.coverageOptionpagePreviousButton(inputValues.get("Plan Type"));
	}

	@Then("^user validate elements in Special Needs page$")
	public void elements_special_page() {
		PlanRecommendationEngineSpecialNeedsPageMobile planSelectorSpecialneedspage = new PlanRecommendationEngineSpecialNeedsPageMobile(
				wd);
		planSelectorSpecialneedspage.specialNeedspage();
	}

	@And("^user selects SNP options in Special Needs Page")
	public void select_special_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineSpecialNeedsPageMobile planSelectorSpecialneedspage = new PlanRecommendationEngineSpecialNeedsPageMobile(
				wd);
		String status = "Positive";
		planSelectorSpecialneedspage.specialneedspage(inputValues.get("SNP Options"), status);
	}

	@And("^user validating error scenario in Special Needs Page")
	public void error_special_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineSpecialNeedsPageMobile planSelectorSpecialneedspage = new PlanRecommendationEngineSpecialNeedsPageMobile(
				wd);
		String status = "Negative";
		planSelectorSpecialneedspage.specialneedspage(inputValues.get("SNP Options"), status);
	}

	@Then("^user validate elements in Travel page$")
	public void elements_travel_page() {
		PlanRecommendationEngineTravelPageMobile planSelectorTravelpage = new PlanRecommendationEngineTravelPageMobile(
				wd);
		planSelectorTravelpage.travelPageElement();
	}

	@And("^user selects Travel options in Care Away From Home Page")
	public void select_travel_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineTravelPageMobile planSelectorTravelpage = new PlanRecommendationEngineTravelPageMobile(
				wd);
		String status = "Positive";
		planSelectorTravelpage.travelpage(inputValues.get("Travel Options"), status);
	}

	@And("^user validating error scenario in Care Away From Home Page")
	public void error_travel_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineTravelPageMobile planSelectorTravelpage = new PlanRecommendationEngineTravelPageMobile(
				wd);
		String status = "Negative";
		planSelectorTravelpage.travelpage(inputValues.get("Travel Options"), status);
	}

	@And("^user validate elements in doctors page$")
	public void elements_doctor_page() {
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		// headerAndFooter.breadCrumbs();
		planSelectorDoctorspage.doctorspageElements();

	}

	@And("^user selects doctors in doctors page$")
	public void select_plan_type_doctor_page(DataTable givenAttributes) throws Throwable {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		String doctor = inputValues.get("Doctors");
		String status = "Positive_NextPageName";
		if (!(doctor.isEmpty())) {
			planSelectorDoctorspage.doctorspageFunctional(inputValues.get("Doctors"),
					inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"), status);
		}
	}

	@And("^user not selects doctors in doctors page$")
	public void notselect_doctor_type_doctor_page(DataTable givenAttributes) throws Throwable {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		String doctor = inputValues.get("Doctors");
		if (doctor.isEmpty()) {
			planSelectorDoctorspage.doctorspageerror();
		}
	}

	@And("^user select doctors and continous the page back from Doctors to previous page$")
	public void previous_doctors_page(DataTable givenAttributes) throws Throwable {
		readfeaturedataMobile(givenAttributes);
		String status = "Positive_NextPageName";
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		planSelectorDoctorspage.doctorspageFunctional(inputValues.get("Doctors"),
				inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"), status);
	}

	@And("^user select doctors and Click previous button from Doctors to check previous page$")
	public void previous_travel_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		planSelectorDoctorspage.doctorspagePreviousButton(inputValues.get("Doctors"));
	}

	@And("^user validating error scenario in doctors Page")
	public void error_doctor_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		planSelectorDoctorspage.doctorspageerror();
	}

	@And("^user selects Doctors in Doctors page and cancels the selection$")
	public void select_doctors_page_cancelvalidation(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		planSelectorDoctorspage.doctorspageCancel(inputValues.get("Doctors Search Text"),
				inputValues.get("Multi Doctor"));
	}

	@And("^user validate elements in drugs page$")
	public void elements_drugs_page() {
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		headerAndFooter.breadCrumbs();
		planSelectorDrugspage.drugspage();

	}

	@And("^user selects skip option in Drug page$")
	public void select_prescription_drug_page(DataTable givenAttributes) throws Throwable {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		String drug = inputValues.get("Drug Selection");
		planSelectorDrugspage.skipDrugs(drug);

	}

	@Then("^user selects add drug option in Drug page$")
	public void add_drugs_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
		planSelectorDrugspage.drugsHandlerWithdetails(inputValues.get("Drug Details"));
		planSelectorDrugspage.continueNextpage();
	}

	@Then("^user selects add drug option and cancels the modals in Drug page$")
	public void add_drugs_page_cancelvalidation(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
		planSelectorDrugspage.drugspageCancel(inputValues.get("Drug Details"));
	}

	@Then("^user validates errors in Drug page$")
	public void add_drugs_page_errorvalidation(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		planSelectorDrugspage.drugpagesError(inputValues.get("Drug Details"));
	}

	@Then("^user search and choose a drug in Drug page$")
	public void choose_drugs_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
		planSelectorDrugspage.drugChoose(inputValues.get("Search Text"), inputValues.get("Drug Details"));
		planSelectorDrugspage.continueNextpage();
	}

	@Then("^user selects add drug option without drugs in Drug page$")
	public void add_NoDrug_drugs_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
		planSelectorDrugspage.continueNextpageZeroDrug();
	}

	@Then("^user selects add drug option and comparing DCE and Drug page$")
	public void verify_drugs_dce_drug_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
		planSelectorDrugspage.comparingDrugwithDCE();
	}

	@Then("^user selects add drug option and verifying the drugs in Drug page$")
	public void verify_drugs_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
		planSelectorDrugspage.comparingDrugsStartOver();
	}

	@And("^user not selects prescription options in drug page$")
	public void notselect_prescription_opt_drug_page(DataTable givenAttributes) throws Throwable {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		String drug = inputValues.get("Drug Selection");
		if (drug.isEmpty()) {
			planSelectorDrugspage.drugspageerror();
		}
	}

	@Then("^user search and not found a drug in Drug Page$")
	public void notfound_drugs_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
		planSelectorDrugspage.drugNotFound(inputValues.get("Search Text"));
	}

	@And("^user validate elements in pharmacy page$")
	public void elements_pharmacy_page() {
		PlanRecommendationEnginePharmacyPageMobile planSelectorPharmacyepage = new PlanRecommendationEnginePharmacyPageMobile(
				wd);
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		// headerAndFooter.breadCrumbs();
		planSelectorPharmacyepage.pharmacypage();

	}

	@And("^user selects pharmacy option in pharmacy page$")
	public void select_pharmacy_option_pharmacy_page(DataTable givenAttributes) throws Throwable {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEnginePharmacyPageMobile planSelectorPharmacyepage = new PlanRecommendationEnginePharmacyPageMobile(
				wd);
		String pharmacytype = inputValues.get("Pharmacy Type");
		if (!(pharmacytype.isEmpty())) {
			planSelectorPharmacyepage.doctorspageFunctional(pharmacytype);
		}
	}

	@And("^user not selects pharmacy option in pharmacy page$")
	public void notselect_pharmacy_option_pharmacy_page(DataTable givenAttributes) throws Throwable {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEnginePharmacyPageMobile planSelectorPharmacyepage = new PlanRecommendationEnginePharmacyPageMobile(
				wd);
		String pharmacytype = inputValues.get("Pharmacy Type");
		if (pharmacytype.isEmpty()) {
			planSelectorPharmacyepage.pharmacypageerror();
		}
	}

	@And("^user select pharmacy option and Click previous button to check previous page$")
	public void previous_pharmacy_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEnginePharmacyPageMobile planSelectorPharmacyepage = new PlanRecommendationEnginePharmacyPageMobile(
				wd);
		planSelectorPharmacyepage.pharmacypagePreviousButton(inputValues.get("Pharmacy Type"));
	}

	@Then("^user validate elements in additional services page$")
	public void elements_additional_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineAdditionalServicesPageMobile planSelectorAdditionalpage = new PlanRecommendationEngineAdditionalServicesPageMobile(
				wd);
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		// headerAndFooter.breadCrumbs();
		planSelectorAdditionalpage.additionalpage(inputValues.get("Drug Selection"));
	}

	@Then("^user selects additional services option in additional services page$")
	public void select_additionalServiceOption_additional_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineAdditionalServicesPageMobile planSelectorAdditionalpage = new PlanRecommendationEngineAdditionalServicesPageMobile(
				wd);
		planSelectorAdditionalpage.additionalpageFunctional(inputValues.get("Additional Option"));
	}

	@Then("^user validates additional services error function in additional services page$")
	public void noselect_additionalServiceOption_additional_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineAdditionalServicesPageMobile planSelectorAdditionalpage = new PlanRecommendationEngineAdditionalServicesPageMobile(
				wd);
		planSelectorAdditionalpage.additionalpageerror(inputValues.get("Additional Option"));
	}

	@Then("^user validate elements in cost preferences page$")
	public void elements_costpreferences_page() {
		PlanRecommendationEngineCostPreferencesPageMobile planSelectorPreferencespage = new PlanRecommendationEngineCostPreferencesPageMobile(
				wd);
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		// headerAndFooter.breadCrumbs();
		planSelectorPreferencespage.costpreferencepage();
	}

	@Then("^user selects cost preferences option in cost preferences page$")
	public void select_costPreferenceOption_costpreferences_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineCostPreferencesPageMobile planSelectorPreferencespage = new PlanRecommendationEngineCostPreferencesPageMobile(
				wd);
		planSelectorPreferencespage.costPreferencepageFunctional(inputValues.get("Preference Option"));
	}

	@Then("^user validates cost preferences error function in cost preferences page$")
	public void noselect_costPreferenceOption_costpreferences_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineCostPreferencesPageMobile planSelectorPreferencespage = new PlanRecommendationEngineCostPreferencesPageMobile(
				wd);
		String preference = inputValues.get("Preference Option");
		if (preference.isEmpty()) {
			planSelectorPreferencespage.costPreferencepageerror();
		}
	}

	@Then("^user validate elements in loading results page$")
	public void elements_results_page() {
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		PlanRecommendationEngineHeaderAndFooterMobile headerAndFooter = new PlanRecommendationEngineHeaderAndFooterMobile(
				wd);
		// headerAndFooter.MobileMenu();
		// headerAndFooter.breadCrumbs();
		planSelectorResultspage.resultsloadingpage();
	}

	@Then("^user validate recommendations in results page$")
	public void view_recommendations_results_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		checkpopup();
		planSelectorResultspage.resultsUI(zip, county, r1, r2, false);
	}

	@Then("^user validate tie recommendations in results page$")
	public void view_tie_recommendations_results_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		checkpopup();
		planSelectorResultspage.resultsUI(zip, county, r1, r2, true);
	}

	@Then("^user validate drugs details from PRE to VPP page$")
	public void view_drugs_PRE_VPP_page() {
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.drugsDetailsPREtoVPP();
		//planSelectorResultspage.MobileMenu();
	}

	@Then("^user validate removed drugs details updated from VPP to PRE page$")
	public void view_removed_drugs_VPP_PRE_page() {
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.removedDrugsDetailsVPPtoPRE();
	}

	@Then("^user navigate to PRE using StartNow button and verify drugs details in PRE page$")
	public void startnow_PRE_page() {
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.startnowtilldrugs();
	}

	@Then("^user proceed page navigation till VPP page after Start Now button$")
	public void view_VPP_StartNow_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.startNowFullFlow(inputValues.get("Plan Type"));
	}

	@Then("^user validate drugs details from DCE to VPP and PRE page$")
	public void drugs_DCE_VPP_PRE_page() {
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.DrugsDetailsVPPtoPRE();
	}

	@And("^user navigates to vpp summary page$")
	public void navigate_vpp_summary_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		String zip = inputValues.get("Zip Code");
		planSelectorResultspage.navigateVPP(zip);
		checkpopup();
	}

	@Then("^user adds Doctors in vpp summary page$")
	public void add_providers_vpp_summary_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		checkpopup();
		planSelectorResultspage.addProviderVPP(inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"));
		planSelectorResultspage.vppToPre();
	}

	@Then("^user navigate Doctors lookup session in Doctors page$")
	public void navigate_doctors_lookup_session() {
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		planSelectorDoctorspage.navigateDoctorsmodalsession();
	}

	@And("^user verifies doctors session in Doctors page$")
	public void verify_doctors_session_doctors_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		planSelectorResultspage.getProvidersPRE(multiDoctor);
		planSelectorResultspage.verifyProvidersSession(multiDoctor);
	}

	@When("^user navigates to Zip Code page from vpp plans$")
	public void user_navigates_to_zipcode_page_fromvpp_pdp() {
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.vppToPre();
		planSelectorResultspage.MobileMenuAndGetStarted();
		PlanRecommendationEngineLandingAndZipcodeMobilePages planSelectorhomepage = new PlanRecommendationEngineLandingAndZipcodeMobilePages(
				wd);
		planSelectorhomepage.navigatezipcodepage();
	}

	@And("^user validte zip info in location page$")
	public void user_validates_zipcodepage(DataTable inputdata) {
		PlanRecommendationEngineLandingAndZipcodeMobilePages planSelectorhomepage = new PlanRecommendationEngineLandingAndZipcodeMobilePages(
				wd);
		readfeaturedataMobile(inputdata);
		planSelectorhomepage.zipcodeInfoValidation(inputValues);
	}

	@And("^user verifies Start Over doctors session in Doctors page$")
	public void verify_StartOver_doctors_session_doctors_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		planSelectorResultspage.getProvidersPRE(multiDoctor);
		planSelectorResultspage.verifyDoctorsSession(multiDoctor);
	}

	@Then("^user adds Providers in Doctors page$")
	public void add_doctors_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		planSelectorDoctorspage.addProvidersPRE(inputValues.get("Doctors Search Text"),
				inputValues.get("Multi Doctor"));

	}

	@And("^user verifies doctors session in VPP page$")
	public void verify_doctors_session_vpp_page() {
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.verifyProviderPREVPP();
	}

	@Then("^user edits Doctors in Doctors page$")
	public void edit_doctors_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		planSelectorDoctorspage.editProvider(inputValues.get("Doctors Search Text1"), inputValues.get("Multi Doctor1"),
				inputValues.get("Doctors Search Text2"), inputValues.get("Multi Doctor2"));
	}

	@Then("^user navigates to VPP Summary Page$")
	public void startNow_vpp_summary_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String isMultiCounty = inputValues.get("Is Multi County");
		planSelectorResultspage.countyandViewPlan(zip, county, isMultiCounty);
	}

	@Then("^user validate zipcode and County in location page using StartNow$")
	public void zipcode_location_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String isMultiCounty = inputValues.get("Is Multi County");
		//planSelectorResultspage.vppToPre();
		planSelectorResultspage.MobileMenuAndGetStarted();
		planSelectorResultspage.validateZipcodePage(zip, county, isMultiCounty);
	}

	@Then("^user navigate to PRE and validate zipcode using Start Over$")
	public void zipcode_Doc_Drug_pre(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String isMultiCounty = inputValues.get("Is Multi County");
		
		planSelectorResultspage.vppToPreStartOver();
		planSelectorResultspage.validateZipcodePage(zip, county, isMultiCounty);
	}

	@Then("^user validate recommendation rankings in results page$")
	public void verify_rankings_results_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		String recom = inputValues.get("Recommendation");
		String plansorder = inputValues.get("Ranking plans Order");
		planSelectorResultspage.validateRankingPlans(recom, plansorder);
	}

	@Then("^verify continue function on \"([^\"]*)\" page$")
	public void proceed_next_page(String page) {
		PlanRecommendationEngineCommonutilityMobile commonutli = new PlanRecommendationEngineCommonutilityMobile(wd);
		commonutli.continueNextpage(page.trim().toUpperCase(), false);
	}

	@And("^user verifies existing PRE provider session using startnow$")
	public void verify_exisitng_pre_doctors_session_doctors_startnow_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		planSelectorDoctorspage.verifyExisitngPREDoclist(multiDoctor);
		planSelectorDoctorspage.nextPageNameValidationDoctor();
	}

	@And("^user verifies exisitng PRE drug session using startnow$")
	public void verify_exisitng_pre_drugs_session_drug_startnow_page() {
		PlanRecommendationEngineDrugsPageMobile planSelectorDrugspage = new PlanRecommendationEngineDrugsPageMobile(wd);
		planSelectorDrugspage.verifyExisitngPREDruglist();
		planSelectorDrugspage.continueNextpageNameDrug();
	}

	@When("^user validate email plan list from vpp$")
	public void user_sendPlanEmail_fromvpp_pdp(DataTable givenAttributes) {
		checkpopup();
		readfeaturedataMobile(givenAttributes);
		String recom = inputValues.get("Recommendation");
		String email = inputValues.get("EmailID");
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.sendEmail(recom, email);
	}

	@Then("^user selects Doctors in Doctors page and validate next page name$")
	public void select_doctors_next_page_name() {
		PlanRecommendationEngineDoctorsPageMobile planSelectorDoctorspage = new PlanRecommendationEngineDoctorsPageMobile(
				wd);
		planSelectorDoctorspage.navigateDoctorsmodalsession();
	}

	@Then("^user validate UI and API recommendation rankings in results page$")
	public void verify_UI_API_rankings_results_page() {
		checkpopup();
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.validateUIAPIRecommendations();
		planSelectorResultspage.validateUIAPIRankingPlans();
	}

	@Then("^user validate MA Plan Names in VPP Summary VS Details in results page$")
	public void verify_MA_Plan_names_results_page() {
		checkpopup();
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.validateMAPlanNamesSummaryAndDetails();
	}

	@Then("^user validate PDP Plan Names in VPP Summary VS Details in results page$")
	public void verify_PDP_Plan_names_results_page() {
		checkpopup();
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.validatePDPPlanNamesSummaryAndDetails();
	}

	@Then("^user validate SNP Plan Names in VPP Summary VS Details in results page$")
	public void verify_SNP_Plan_names_results_page() {
		checkpopup();
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.validateSNPPlanNamesSummaryAndDetails();
	}

	@Then("^user adds Drugs in vpp summary page$")
	public void add_drugs_vpp_summary_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		checkpopup();
		planSelectorResultspage.useraddDrugsVPP(inputValues.get("Drug Details"));
	}

	@Then("^user validate future vs current UI and API recommendation rankings in results page$")
	public void verify_Future_UI_API_rankings_results_page() {
		checkpopup();
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage = new PlanRecommendationEngineResultsPageMobile(
				wd);
		planSelectorResultspage.checkPlanyear("future");
		planSelectorResultspage.validateUIAPIRecommendations();
		planSelectorResultspage.validateUIAPIRankingPlans();
		planSelectorResultspage.changePlanyear("current");
		// Toggling back and validating as future year only have values stored in
		// storage
		planSelectorResultspage.changePlanyear("future");
		planSelectorResultspage.validateUIAPIRecommendations();
		planSelectorResultspage.validateUIAPIRankingPlans();
	}

	public void checkpopup() {
		if (if_offline_prod && !popup_clicked) {
			PlanRecommendationEngineLandingAndZipcodeMobilePages planSelectorhomepage = new PlanRecommendationEngineLandingAndZipcodeMobilePages(
					wd);
			popup_clicked = planSelectorhomepage.close_Popup();
		}
	}
}