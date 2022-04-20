package acceptancetests.mobile.acquisition.planrecommendationengine;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.CommonConstantsMobile;
import acceptancetests.data.PageConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;

/**
 * @author Murali - mmurugas
 */

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.planRecommendationEngine.ACQDrugCostEstimatorPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineCommonutility;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineCoverageOptionPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDoctorsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDrugsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineEditResponsePage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineHeaderAndFooter;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineLandingAndZipcodePages;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineNewResultsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineResultsPage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.planrecommendationengine.AdditionalServicesMobilePage;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;
import pages.mobile.acquisition.planrecommendationengine.CostPreferencesMobilePage;
import pages.mobile.acquisition.planrecommendationengine.CoverageOptionsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DoctorsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DrugMobilePage;
import pages.mobile.acquisition.planrecommendationengine.EditResponseMobilePage;
import pages.mobile.acquisition.planrecommendationengine.HeaderFooterMobile;
import pages.mobile.acquisition.planrecommendationengine.LandingAndZipcodeMobilePage;
import pages.mobile.acquisition.planrecommendationengine.LoadingMobilePage;
import pages.mobile.acquisition.planrecommendationengine.PharmacyMobilePage;
import pages.mobile.acquisition.planrecommendationengine.PrioritiesMobilePage;
import pages.mobile.acquisition.planrecommendationengine.ResultsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.NewResultsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.SpecialNeedsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.TravelMobilePage;
import pages.mobile.acquisition.planrecommendationengine.e2e.PlanRecommendationEngineResultsPageMobile;

public class PlanRecommendationStepDefinitionMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;
//	List<DataTableRow> inputRow;
	HashMap<String, String> inputValues;
	public static String PREflow = "";

	public void readfeaturedataMobile(DataTable data) {
		inputValues = new HashMap<String, String>();
		inputValues = DataTableParser.readDataTableAsMaps(data);
		String temp = inputValues.get("Plan Type");
		if (temp != null && PREflow != temp) {
			PREflow = temp;
			//System.out.println("\n\n\n\n\n\n");
			String curID = String.valueOf(Thread.currentThread().getId());
			System.out.println("Current Thread ID is - "+curID+" for the flow "+PREflow);
			//CommonConstants.PRE_FLOW = new LinkedHashMap<String,String>();
			CommonConstantsMobile.PRE_FLOW.put(curID, PREflow);

		}
	}

	public void checkpopup() {
		if (if_offline_prod && !popup_clicked) {
			LandingAndZipcodeMobilePage planSelectorhomepage = new LandingAndZipcodeMobilePage(wd);
			popup_clicked = planSelectorhomepage.close_Popup();
		}
	}

	boolean if_offline_prod = false, popup_clicked = false;

	@Given("^the user is on UHC medicare acquisition site PRE landing page$")
	public void the_user_on_uhc_medicaresolutions_site_mobile(DataTable inputdata) {
		wd = getLoginScenario().getMobileDriver();
		readfeaturedataMobile(inputdata);

		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd, "PRE");
		if_offline_prod = aquisitionhomepage.openPRE(inputValues.get("Site"));
		aquisitionhomepage.fixPrivateConnectionMobile();

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);

		checkpopup();

	}

	@When("^user navigates to PRE landing page mobile$")
	public void user_navigates_PRE_landingpage_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preheaderfootermobile.navigatePRELandingpageMobile();
	}

	@When("^user navigate Plan Recommendation Engine Using Shop From Home in Find Your Plan$")
	public void user_navigates_PRE_landingpage_shoptool_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preheaderfootermobile.navigationToPREViaShopToolsMobile();
	}

	@When("^user navigate to Plan Recommendation Engine and Checking Breadcrumbs$")
	public void user_navigates_to_zipcode_page_mobile() {
		LandingAndZipcodeMobilePage planSelectorhomepage = new LandingAndZipcodeMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorhomepage.landingpage();
	}

	@Then("^user validate elements on landing page of Plan Recommendation Engine$")
	public void user_check_landing_page_Plan_Selector_tool_mobile() {
		// System.out.println("Device Type "+inputValues.get("Device Type"));
		LandingAndZipcodeMobilePage prelandingpagemobile = new LandingAndZipcodeMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		prelandingpagemobile.landingpageElementsmobile();
	}

	@Then("^user validate Header elements and Link Validation of Plan Recommendation Engine$")
	public void user_check_header_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preheaderfootermobile.headerElementsMobile();
	}

	@Then("^user validate Footer elements and Link Validation of Plan Recommendation Engine$")
	public void user_check_Footer_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preheaderfootermobile.footerElementsMobile();
	}

	@Then("^user validate Header and Footer Functionality of Plan Recommendation Engine$")
	public void user_check_header_functionalities_mobile(DataTable inputdata) {
		readfeaturedataMobile(inputdata);
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preheaderfootermobile.zipcodeFunctionInShopforaplanHeaderMobile(inputValues.get("Zip Code"));
		preheaderfootermobile.emailFunctionInShopforaplanMobile(inputValues.get("EMail"));
		// preheaderfootermobile.enterSearchFunctionHeaderMobile(inputValues.get("Search
		// Key"));
	}

	@Then("^user validates zipcode page elements mobile$")
	public void user_check_zipcodepage_elements_mobile() {
		LandingAndZipcodeMobilePage prezipcodemobile = new LandingAndZipcodeMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		prezipcodemobile.zipcodepageElementsmobile();
	}

	@And("^clicks on get started button and runs questionnaire$")
	public void user_runs_questionnaire_zipcodepage_mobile(DataTable inputdata) throws Exception {
		readfeaturedataMobile(inputdata);
		String zipcode = inputValues.get("Zip Code");
		System.out.println("Zipcode is:" + zipcode);
		String county = inputValues.get("CountyDropDown");
		System.out.println("Email is:" + county);
		String isMultiCounty = inputValues.get("Is Multi County");
		System.out.println("Entered Search Key is:" + isMultiCounty);
		checkpopup();

		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);

		LandingAndZipcodeMobilePage planSelectorhomepage = new LandingAndZipcodeMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		if (isMultiCounty.equalsIgnoreCase("NO")) {
			planSelectorhomepage.quizStartAndRunQuestionnaire(zipcode);
		} else {
			planSelectorhomepage.quizStartAndRunQuestionnaireWithCounty(zipcode, county);
		}
	}

	@Then("^clicks on get started button and check error scenarios$")
	public void user_runs_questionnaire_zipcodepage_invalid_data_mobile(DataTable inputdata) {
		LandingAndZipcodeMobilePage prezipcodemobile = new LandingAndZipcodeMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		readfeaturedataMobile(inputdata);
		prezipcodemobile.zipcodescreenErrorValidationmobile(inputValues);
	}

	@Then("^user validate elements in coverage options page$")
	public void user_check_coveragepage_elements_mobile() {
		CoverageOptionsMobilePage coveragepage = new CoverageOptionsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		coveragepage.coverageOptionpageElementsMobile();
	}
	
	@Given("^the user is on flagsmith UHC medicare acquisition site PRE landing page$")
	public void the_user_on_flagsmith_uhc_medicaresolutions_Site(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		wd = getLoginScenario().getMobileDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd,"PRE"); //changed on 3/3/21 as part of AARP/UHC cleanup
		if_offline_prod = aquisitionhomepage.openAEPPRE(inputValues.get("Site"), inputValues.get("User Name"));
		if (MRScenario.environment.contains("digital-uatv2") || MRScenario.environment.contains("digital-devv2")) 
			aquisitionhomepage.fixPrivateConnection();
		
		aquisitionhomepage.loginflagSmithPRE(inputValues.get("Site"), inputValues.get("User Name"));
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		checkpopup();
	}

	@Then("^user selects plan type in coverage options page$")
	public void select_plan_type_coverage_page_mobile(DataTable inputdata) throws Throwable {
		readfeaturedataMobile(inputdata);
		CoverageOptionsMobilePage coveragepage = new CoverageOptionsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String plantype = inputValues.get("Plan Type");
		if (!(plantype.isEmpty())) {
			coveragepage.coverageOptionpageFunctionalMobile(plantype, true);
		} else {
			coveragepage.coverageOptionpageErrormobile();
		}
	}

	@And("^user select planType and continous the page back to previous page$")
	public void previous_coverage_page_mobile(DataTable inputdata) throws Throwable {
		readfeaturedataMobile(inputdata);
		CoverageOptionsMobilePage coveragepage = new CoverageOptionsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		coveragepage.coverageOptionpageFunctionalMobile(inputValues.get("Plan Type"), false);
		coveragepage.previouspageValidation();
	}

	@Then("^user validate elements in Special Needs page$")
	public void elements_special_page_mobile() {
		SpecialNeedsMobilePage specialneedspage = new SpecialNeedsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		specialneedspage.specialNeedspageElements();
	}

	@And("^user selects SNP options in Special Needs Page$")
	public void select_special_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		SpecialNeedsMobilePage specialneedspage = new SpecialNeedsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String status = "Positive";
		specialneedspage.specialneedspage(inputValues.get("SNP Options"), status);
	}

	@And("^user validating error scenario in Special Needs Page$")
	public void select_special_needs_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		SpecialNeedsMobilePage specialneedspage = new SpecialNeedsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String status = "Negative";
		specialneedspage.specialneedspage(inputValues.get("SNP Options"), status);
	}

	@Then("^user validate elements in Doctors page$")
	public void elements_doctors_page_mobile() {
		DoctorsMobilePage doctorpage = new DoctorsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		doctorpage.doctorspageElements();
	}

	@Then("^user selects doctors in doctors page$")
	public void select_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String status = "Positive_NextPageName";
		doctorpage.doctorspage(inputValues.get("Doctors"), inputValues.get("Doctors Search Text"),
				inputValues.get("Multi Doctor"), status);
	}

	@And("^user selects Doctors in Doctors page and cancels the selection$")
	public void select_doctors_page_cancelvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		doctorpage.doctorspageCancel(inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"));
	}

	@Then("^user validate elements in drugs page$")
	public void elements_drug_page_mobile() {
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.drugspageElements();
	}

	@Then("^user selects skip option in Drug page$")
	public void elements_drugskip_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.skipDrugs(inputValues.get("Drug Selection"));
	}

	@Then("^user selects add drug option in Drug page$")
	public void add_drugs_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugsHandlerWithdetails(inputValues.get("Drug Details"));
		drugpage.continueNextpage();
	}

	@Then("^user selects add drug option and cancels the modals in Drug page$")
	public void add_drugs_page_cancelvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugspageCancel(inputValues.get("Drug Details"));
	}

	@Then("^user validates errors in Drug page$")
	public void add_drugs_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.drugpagesError(inputValues.get("Drug Details"));
	}

	@Then("^user search and choose a drug in Drug page$")
	public void choose_drugs_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugChoose(inputValues.get("Search Text"), inputValues.get("Drug Details"));
		drugpage.continueNextpage();
	}

	@Then("^user selects add drug option without drugs in Drug page$")
	public void add_NoDrug_drugs_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.continueNextpageZeroDrug();
	}

	@Then("^user search and not found a drug in Drug page$")
	public void notfound_drugs_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugNotFound(inputValues.get("Search Text"));
	}

	@Then("^user validate elements in additional services page$")
	public void elements_additional_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		AdditionalServicesMobilePage additionalpage = new AdditionalServicesMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		additionalpage.additionalpage(inputValues.get("Drug Selection"));
	}

	@Then("^user selects additional services option in additional services page$")
	public void select_additionalServiceOption_additional_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		AdditionalServicesMobilePage additionalpage = new AdditionalServicesMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		additionalpage.additionalpageFunctional(inputValues.get("Additional Option"));
	}

	@Then("^user validates additional services error function in additional services page$")
	public void select_additional_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		AdditionalServicesMobilePage additionalpage = new AdditionalServicesMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		additionalpage.additionalpageerror(inputValues.get("Additional Option"));
	}
	
	@Then("^user selects add drug option in Drug page without continue next page$")
  	public void add_drugs_page_WithoutContinue(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage planSelectorDrugspage =  new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
  		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
  		planSelectorDrugspage.drugsHandlerWithdetails(inputValues.get("Drug Details"));
  		planSelectorDrugspage.drugnamesList();
  	}

	@Then("^user validate elements in cost preferences page$")
	public void elements_costpreferences_page_mobile() {
		CostPreferencesMobilePage costpage = new CostPreferencesMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		costpage.costpreferencepage();
	}

	@Then("^user selects cost preferences option in cost preferences page$")
	public void select_costPreferenceOption_costpreferences_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		CostPreferencesMobilePage costpage = new CostPreferencesMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		costpage.costPreferencepageFunctional(inputValues.get("Preference Option"));
	}

	@Then("^user validates cost preferences error function in cost preferences page$")
	public void select_costpreferences_page_errorvalidation_mobile() {
		CostPreferencesMobilePage costpage = new CostPreferencesMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		costpage.costPreferencepageerror();
	}

	@Then("^user validate elements in loading results page$")
	public void elements_loading_page_mobile() {
		LoadingMobilePage loadingpage = new LoadingMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		loadingpage.loadingresultspage();
	}
	
	@Then("^user validate elements in PRE results page$")
   	public void elements_new_results_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage planSelectorNewResultspage =  new NewResultsMobilePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		planSelectorNewResultspage.preResultsUI(inputValues.get("Zip Code"),inputValues.get("CountyDropDown"));
   	}

	@Then("^user validate recommendations in results page mobile$")
	public void view_recommendations_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		resultpage.resultsUI(zip, county, r1, r2, false);
	}
	
	@Then("^user validate zipcode saved in PRE session	and reflected in home page$")
    public void zipcode_home_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
        HeaderFooterMobile headerAndFooter =  new HeaderFooterMobile((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
        headerAndFooter.storedZipcode(inputValues.get("Zip Code"));
                    
    }

	@Then("^user validate tie recommendations in results page mobile$")
	public void view_tie_recommendations_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		resultpage.resultsUI(zip, county, r1, r2, true);
	}

	@Given("^user navigates to vpp summary page$")
	public void navigate_vpp_summary_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		resultpage.navigateVPP(inputValues);
	}

	@Then("^user adds Doctors in vpp summary page$")
	public void add_providers_vpp_summary_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		resultpage.addProviderVPP(inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"));
	}

	@Then("^user navigate Doctors lookup session in Doctors page$")
	public void navigate_doctors_lookup_session_mobile() {
		DoctorsMobilePage doctorpage = new DoctorsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		doctorpage.navigateDoctorsmodalsession();
	}

	@When("^user navigates to Zip Code page from vpp mobile$")
	public void user_navigates_to_zipcode_page_fromvpp_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		resultpage.navigatePRE();
		LandingAndZipcodeMobilePage prelandingpage = new LandingAndZipcodeMobilePage(wd);
		prelandingpage.navigatezipcodepagemobile();
	}

	@And("^user verifies doctors session in Doctors page mobile$")
	public void verify_doctors_session_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String multiDoctor = inputValues.get("Multi Doctor");
		resultpage.getProvidersPRE(multiDoctor);
		resultpage.verifyProvidersSession(multiDoctor);
	}

	@Then("^user adds Providers in Doctors page mobile$")
	public void add_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		doctorpage.addProvidersPRE(inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"));
	}

	@And("^user verifies doctors session in VPP page mobile$")
	public void verify_doctors_session_vpp_page_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		resultpage.verifyProviderPREVPP();
	}

	@Then("^user adds drugs in Drug page mobile$")
	public void add_drugsPRE_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.addDrugsPRE(inputValues.get("Drug Details"));
		drugpage.getDrugsdetails();
		drugpage.continueNextpage();
	}

	@And("^user verifies drugs session in VPP page mobile$")
	public void verify_drugs_session_vpp_page_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		resultpage.verifyDrugPREVPP();
	}

	@Then("^user edits Doctors in Doctors page$")
	public void edit_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		doctorpage.editProvider(inputValues.get("Doctors Search Text1"), inputValues.get("Multi Doctor1"),
				inputValues.get("Doctors Search Text2"), inputValues.get("Multi Doctor2"));
	}

	@When("^user navigates to Zip Code page from vpp plans$")
	public void user_navigates_to_zipcode_page_fromvpp_pdp_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		resultpage.navigateVPPPRE();
		LandingAndZipcodeMobilePage prelandingpage = new LandingAndZipcodeMobilePage(wd);
		prelandingpage.navigatezipcodepagemobile();
	}

	@And("^user validte zip info in location page mobile$")
	public void user_validates_zipcodepage_mobile(DataTable inputdata) {
		LandingAndZipcodeMobilePage prezipcodemobile = new LandingAndZipcodeMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		readfeaturedataMobile(inputdata);
		prezipcodemobile.zipcodeInfoValidationmobile(inputValues);
	}

	@When("^user navigates to Zip Code page from vpp plans using startover mobile$")
	public void user_navigates_to_zipcode_page_fromvpp_pdp_startover_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		resultpage.navigateVPPPREStartover();
		LandingAndZipcodeMobilePage prelandingpage = new LandingAndZipcodeMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		prelandingpage.navigatezipcodepagemobile();
	}

	@And("^user verifies existing PRE provider session using startover mobile$")
	public void verify_exisitng_pre_doctors_session_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage docpage = new DoctorsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String multiDoctor = inputValues.get("Multi Doctor");
		docpage.verifyExisitngPREDoclist(multiDoctor);
		docpage.nextPageValidationDoctor();
	}
	
	@Then("^user Validate Zipcode and Plantype using StartApplication in Visitor profile page$")
	public void user_verify_OLE(DataTable givenAttributes) {
		NewResultsMobilePage planSelectorResultspage =  new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.validateOLEDetails(inputValues.get("Zip Code"));
	}

	@And("^user verifies exisitng PRE drug session using startover mobile$")
	public void verify_exisitng_pre_drugs_session_drug_page_mobile() {
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.verifyExisitngPREDruglist();
		drugpage.continueNextpage();
	}

	@Then("^user validte error function in drug option selection page mobile$")
	@Then("^user not selects prescription options in drug page$")
	public void drugs_option_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.chooseOption(inputValues.get("Drug Selection"));
	}

	@Then("^user validate recommendation rankings in results page mobile$")
	public void verify_rankings_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String recom = inputValues.get("Recommendation");
		String plansorder = inputValues.get("Ranking plans Order");
		resultpage.validateRankingPlans(recom, plansorder);
	}

	@Then("^verify continue function on \"([^\"]*)\" page$")
	public void proceed_next_page_mobile(String page) {
		CommonutilitiesMobile mobiletutli = new CommonutilitiesMobile((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		mobiletutli.continueNextpage(page.trim().toUpperCase(), false);
	}

	@And("^user verifies existing PRE provider session using startnow mobile$")
	public void verify_exisitng_pre_doctors_session_doctors_startnow_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage docpage = new DoctorsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String multiDoctor = inputValues.get("Multi Doctor");
		docpage.verifyExisitngPREDoclist(multiDoctor);
		docpage.nextPageNameValidationDoctor();
	}

	@And("^user verifies exisitng PRE drug session using startnow$")
	public void verify_exisitng_pre_drugs_session_drug_startnow_page_mobile() {
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.verifyExisitngPREDruglist();
		drugpage.continueNextpageNameDrug();
	}

	@When("^user validate email plan list from vpp$")
	public void user_sendPlanEmail_fromvpp_pdp_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		String recom = inputValues.get("Recommendation");
		String email = inputValues.get("EmailID");
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		resultpage.sendEmail(recom, email);
	}

	@Then("^user selects Doctors in Doctors page and validate next page name mobile$")
	public void select_doctors_next_page_name_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String status = "Positive_NextPageName";
		doctorpage.doctorspage(inputValues.get("Doctors Selection"), inputValues.get("Doctors Search Text"),
				inputValues.get("Multi Doctor"), status);
	}

	@Then("^user validate UI and API recommendation rankings in results page$")

	public void verify_UIAPI_rankings_results_page_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
//		resultpage.validateUIAPIRecommendations();

		resultpage.validateUIAPIRankingPlans();
	}

	@Then("^user adds Drugs in vpp summary page$")
	public void add_drugs_vpp_summary_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		resultpage.useraddDrugsVPP(inputValues.get("Drug Details"));
	}

	@Then("^user navigate drugs list page and verifies drugs session in Drugs page mobile$")
	public void verifies_drugs_vpp_pre__mobile() {
		DrugMobilePage drugpage = new DrugMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		drugpage.verifyExisitngVPPDruglist();
	}

	@Then("^user verifies \"([^\"]*)\" page$")
	public void verify_vpp_summary_page_mobile(String VPP) {
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		if (VPP.toUpperCase().contains("PRE"))
			resultpage.checkVPP(true);
		else
			resultpage.checkVPP(false);
	}

	@When("^user navigates to PRE landing page menu mobile$")
	public void user_navigates_PRE_landingpage_menu_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preheaderfootermobile.navigatePRELandingpageMenuMobile();
	}

	// Edit Page Mobile
	@Then("^user validate saved values in edit response page$")
	public void check_saved_value_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditMobile.editResponsepage(inputValues);
	}

	@Then("^user return to vpp page using \"([^\"]*)\" from edit response page$")
	public void check_saved_value_editResponse_page(String button) {
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditMobile.returnVPP(button);
	}

	@Then("^user edits values in edit response page$")
	public void edit_saved_value_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditMobile.editUserResponse(inputValues);
	}

	@Then("^user adds doctor in edit response page$")
	public void add_doctor_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditMobile.addDoctorEditResponse(inputValues);
	}

	@Then("^user navigates to edit response page$")
	public void navigate_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);

		EditResponseMobilePage preEditMobile =  new EditResponseMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditMobile.navigateEditResponsePageMobile(inputValues.get("Plan Type"));
   	}


	@Then("^user edits coverage value in edit response page$")
	public void edit_coverage_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditMobile.changeCoverage(inputValues);
	}

	@Then("^user validates coverage value in edit response page$")
	public void validate_coverage_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditMobile.checkCoveragevalue(inputValues);
	}

	@Then("^user selects add drug option in drug page from edit response page$")
	public void add_drug_editResponse_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditMobile.addDrugs(inputValues);
	}

	@Then("^user selects priority in priorities page$")
	public void user_selects_priorities(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PrioritiesMobilePage prioritiesMobile = new PrioritiesMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		prioritiesMobile.prioritiesFunctional(inputValues.get("Priority Option"), inputValues.get("Priorities"));
		prioritiesMobile.continuePriority();
	}
	
	@Then("^user Filter SNP Plantype and validate CSNP Plans Ranking in PRE results page$")
	public void csnp_ranking(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage planSelectorNewResultspage =  new NewResultsMobilePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.sortByFuncWithoutVerify(inputValues.get("Sort PlanType"));
		planSelectorNewResultspage.csnRanking(inputValues.get("SNP Options"));
	}

	@Then("^user validate elements in priorities page$")
	public void user_validate_prioritiesElements() {
		PrioritiesMobilePage prioritiesMobile = new PrioritiesMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		prioritiesMobile.prioritiesElementsMobile();
	}

/////////////////////////////////////////////////////// New Results Page //////////////////////////////

	@Then("^user validates Sort By drop down UI PRE-Result page$")
	public void sortBy() {
		NewResultsMobilePage newResultpage = new NewResultsMobilePage(wd);
		newResultpage.validateSortByElements();
	}

@Then("^user navigates to PRE doctorpage to add providers$")
public void addDoctorLink() {
	NewResultsMobilePage planSelectorNewResultspage =  new NewResultsMobilePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
	planSelectorNewResultspage.addDoctorsLink();
}

@Then("^user navigates to PRE doctorpage to edit providers$")
public void editDoctorLink() {
	NewResultsMobilePage planSelectorNewResultspage =  new NewResultsMobilePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
	planSelectorNewResultspage.editDoctorsLink();
}

@Then("^user updating providers to PRE doctorpage$")
public void providerUpdate(DataTable givenAttributes) {
	readfeaturedataMobile(givenAttributes);
	DoctorsMobilePage doc = new DoctorsMobilePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
	doc.edit_doctor(inputValues.get("Doctors"), inputValues.get("Doctors Search Text"),
			inputValues.get("Multi Doctor"));
}

@And("^user edit doctors in doctors page$")
public void edit_doctor_page(DataTable givenAttributes) throws Throwable {
	readfeaturedataMobile(givenAttributes);
	DoctorsMobilePage planSelectorDoctorspage =  new DoctorsMobilePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
	String doctor = inputValues.get("Doctors");
	String status = "Positive_NextPageName";
	if (!(doctor.isEmpty())) {
		planSelectorDoctorspage.editdoctorspageFunctional(doctor,inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"),status);
	}
}

@Then("^user validates Sort By elements visibility PRE-Result page$")
public void sortBy_Visibility(DataTable givenAttributes) {
	readfeaturedataMobile(givenAttributes);
	NewResultsMobilePage newResultpage =  new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
	newResultpage.optionVisibility(inputValues.get("Visibility Info"));
}

	@Then("^user removed filtered planType and Check Breadcrumbs in PRE-Result page$")
	public void sortBy_Remove() {
		NewResultsMobilePage newResultpage = new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		newResultpage.removeBreadcrumb();
		newResultpage.sortByBreadcrumb();
	}
	
	@Then("^user validates Sort By breadcrumb after Plan Year Toggle in PRE-Result page$")
	public void sortBy_planYear(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage planSelectorNewResultspage =  new NewResultsMobilePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		PlanRecommendationEngineResultsPageMobile planSelectorResultspage =  new PlanRecommendationEngineResultsPageMobile((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.changePlanyear(inputValues.get("Sort PlanYear"));
		planSelectorNewResultspage.sortByBreadcrumb();
	}

	@Then("^user validates Sort By using PlanType in PRE-Result page$")
	public void sortBy_planType(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage newResultpage = new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		newResultpage.sortByFunc(inputValues.get("Sort PlanType"));
	}

	@Then("^user validate pagination in PRE results page$")
	public void pagination_new_results_page_mobile() {
		NewResultsMobilePage newResultpage = new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		newResultpage.validatePagination();
	}

	@Then("^user validate drugDetails in PRE results page$")
	public void drugDetails_new_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage newResultpage = new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		newResultpage.validateDrugInfo(inputValues.get("DrugInfo"), "tile");
	}

@And("^user selects empty doctors in doctors page$")
public void zeroDoctor_doctor_page(DataTable givenAttributes) throws Throwable {
    readfeaturedataMobile(givenAttributes);
    DoctorsMobilePage planSelectorDoctorspage =  new DoctorsMobilePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
    planSelectorDoctorspage.addZeroProviders(inputValues.get("Doctors Search Text"));
 }

@Then("^user validates Sort By dropdown will not display in UI PRE-Result page$")
public void sortBy_No() {
	NewResultsMobilePage planSelectorNewResultspage =  new NewResultsMobilePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
	planSelectorNewResultspage.validateNoSortByElements();
}

@Then("^user validate doctors info in PRE results page$")
	public void doctorDetails_new_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage newResultpage = new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		newResultpage.validateDoctorInfo(inputValues.get("DoctorsInfo"), "tile");
	}

	@Then("^user validate snp info in PRE results page$")
	public void snpDetails_new_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage newResultpage = new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		newResultpage.validateSNPInfo(inputValues.get("SNPInfo"));
	}

	@Then("^user views plan details from results page$")
	public void viewDetails_new_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage planSelectorNewResultspage =  new NewResultsMobilePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.viewPlanInfo(inputValues.get("Plan Info"));
	}

	@Then("^user views learn more from results page$")
	public void learnMore_new_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage newResultpage = new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		newResultpage.learnMore(inputValues.get("Learn More"));
	}

	@Then("^user validate drugCostModal in PRE results page$")
	public void drugDetailsModel_new_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage newResultpage = new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		newResultpage.validateDrugInfo(inputValues.get("DrugInfo"), "model");
	}

	@Then("^user validate showmoreDrug in PRE results page$")
	public void drugShowMore_new_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage newResultpage = new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		newResultpage.validateDrugInfo(inputValues.get("DrugInfo"), "show");
	}
	
	@Then("^user validate WhySeparateModel plan in PRE results page$")
   	public void WhySeparateModel_new_results_page(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage planSelectorNewResultspage =  new NewResultsMobilePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.validateDrugInfo(inputValues.get("DrugInfo"),"whyseparatemodel");
   	}

	@Then("^user validate showmoreDoctor in PRE results page$")
	public void doctorShowMore_new_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage newResultpage = new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		newResultpage.validateDoctorInfo(inputValues.get("DoctorsInfo"), "show");
	}

	@Then("^user clicks on GetStarted button in PRE page$")
	public void PRE_GetStarted_mobile() {
		LandingAndZipcodeMobilePage prelandingpage = new LandingAndZipcodeMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		prelandingpage.navigatezipcodepagemobile();
	}

	@Then("^user navigate to PRE from vpp page$")
	public void PRE_VPP_page_mobile() {
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		resultpage.navigatePRE();
	}

	@Then("^user save recommendation results and validate in VP$")
	public void save_results_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditMobile.validateSaveResults();
	}

	@Then("^user navigate to visitor profile and open PRE Widget$")
	public void pre_Widget_open(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		EditResponseMobilePage preEditMobile = new EditResponseMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditMobile.ValidatePREWidget(inputValues.get("User Type"), inputValues.get("Plan Type"),
				inputValues.get("User Name"), inputValues.get("Password"));
	}

	@Then("^user validate recommendation section in PRE Widget on VP$")
	public void pre_Widget_recom() {
		ResultsMobilePage resultpage = new ResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		resultpage.recomPREWidget();
	}

	@Then("^user do browser back from current page$")
	public void browser_back_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@When("^user navigate Plan Recommendation Engine Using Get Started From Medicare Articles$")
	public void navigate_PRE_tool_MedicareArticles_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@When("^user navigate to Medicare Education and validate Plan Recommendation Engine Widget$")
	public void navigate_MedicareEducation_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@And("^user not selects plan type in coverage options page$")
	public void notselect_plan_type_coverage_page_mobile(DataTable givenAttributes) throws Throwable {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@And("^user select planType and Click previous button to check previous page$")
	public void previous_zipcode_page_mobile(DataTable givenAttributes) {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user validate MA Plan Names in VPP Summary VS Details in results page$")
	public void verify_MA_Plan_names_results_page_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user validate PDP Plan Names in VPP Summary VS Details in results page$")
	public void verify_PDP_Plan_names_results_page_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user validate SNP Plan Names in VPP Summary VS Details in results page$")
	public void verify_SNP_Plan_names_results_page_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user validate future vs current UI and API recommendation rankings in results page$")
	public void verify_Future_UI_API_rankings_results_page_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user save 2 MA plans in vpp summary and Validate in Visitor profile page$")
	public void user_saveplan_mobile(DataTable givenAttributes) {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user Validate Drug and Provider details in Visitor profile page$")
	public void user_verify_drug_provider_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user validate SNP Plan in Enroll page$")
	public void verify_SNP_Plan_names(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		checkpopup();
		NewResultsMobilePage planSelectorNewResultspage =  new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.viewPlanInfo(inputValues.get("Plan Info"));
		planSelectorNewResultspage.validateSNPPlanName();
	}

	@When("^user navigate to Plan Recommendation Engine Tool$")
	public void the_user_external_PRE_mobile(DataTable givenAttributes) {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user validate PDP Plan Names in VPP Details and Click Enroll button in Plan Details page$")
	public void verify_Plan_names_Enroll_page_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user save plans in vpp summary and Validate in Visitor profile page$")
	public void user_verify_saveplan_mobile(DataTable givenAttributes) {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user adds SNP options and Location in edit response page$")
	public void add_snp_editResponse_page_mobile(DataTable givenAttributes) {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@And("^user verifies doctors and continue to next page$")
	public void verify_doctors_continue_page_mobile(DataTable givenAttributes) {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user selects add drug option and comparing DCE and Drug page$")
	public void verify_drugs_dce_drug_page_mobile(DataTable givenAttributes) {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user select plans in VPP Summary and navigate to Plan Compare page$")
	public void verify_Plans_compare_page_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@When("^user navigate to Drug Cost Estimator page$")
	public void navigate_DCE_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@And("^user validate druglist in Drug Cost Estimator page$")
	public void Druglist_DCE_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user validate drugs details from VPP to DCE page$")
	public void drugs_VPP_DCE_page_mobile(DataTable givenAttributes) {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user validate drugs details from DCE to PRE page$")
	public void drugs_DCE_VPP_PRE_page_mobile() {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}

	@Then("^user validate a \"([^\"]*)\" buttons from PRE$")
	public void btn_tab_mobile(String tabtype) {
		System.out.println("This Step is specifically for Desktop.. Ignoring in Mobile Execution");
	}
	
	@Then("^user validates Important Resources section enabled in PRE-Result page$")
	public void Imp_Res(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		NewResultsMobilePage planSelectorNewResultspage =  new NewResultsMobilePage((AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.importantResourceSection(inputValues.get("Resources Links"));
	}

}