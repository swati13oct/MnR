package acceptancetests.mobile.acquisition.planrecommendationengine;

/**
 * @author Murali - mmurugas
 */

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.mobile.acquisition.bluelayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.planrecommendationengine.CoverageOptionsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DoctorsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DrugMobilePage;
import pages.mobile.acquisition.planrecommendationengine.HeaderFooterMobile;
import pages.mobile.acquisition.planrecommendationengine.LandingAndZipcodeMobilePage;
import pages.mobile.acquisition.planrecommendationengine.LoadingMobilePage;
import pages.mobile.acquisition.planrecommendationengine.PharmacyMobilePage;
import pages.mobile.acquisition.planrecommendationengine.ResultsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.SpecialNeedsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.TravelMobilePage;
import pages.mobile.acquisition.planrecommendationengine.AdditionalServicesMobilePage;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;
import pages.mobile.acquisition.planrecommendationengine.CostPreferencesMobilePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PlanRecommendationStepDefinitionMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;
	List<DataTableRow> inputRow;
	HashMap<String, String> inputValues;
	public static String PREflow="";

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
		//preheaderfootermobile.enterSearchFunctionHeaderMobile(inputValues.get("Search Key"));
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
		drugpage.drugChoose(inputValues.get("Search Text"),inputValues.get("Drug Details"));
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
		PharmacyMobilePage pharmacypage =  new PharmacyMobilePage(wd);
		pharmacypage.pharmacypageElements();
	}
	
	@Then("^user selects Pharmacy in Pharmacy page mobile$")
	public void select_pharmacy_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PharmacyMobilePage pharmacypage =  new PharmacyMobilePage(wd);
		String status = "Positive";
		pharmacypage.pharmacyFunctional(inputValues.get("Pharmacy Selection"),status);
	}
	
	@And("^user selects Pharmacy in Pharmacy page and validate errors mobile$")
	public void select_pharmacy_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		PharmacyMobilePage pharmacypage =  new PharmacyMobilePage(wd);
		String status = "Negative";
		pharmacypage.pharmacyFunctional(inputValues.get("Pharmacy Selection"),status);	
	}
	
	@Then("^user validate elements in additional services page mobile$")
   	public void elements_additional_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
   		AdditionalServicesMobilePage additionalpage =  new AdditionalServicesMobilePage(wd);
   		additionalpage.additionalpage(inputValues.get("Drug Selection"));
   	}
   	
	@Then("^user selects additional services option in additional services page mobile$")
   	public void select_additionalServiceOption_additional_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
   		AdditionalServicesMobilePage additionalpage =  new AdditionalServicesMobilePage(wd);
   		additionalpage.additionalpageFunctional(inputValues.get("Additional Option"));
   	}
	
	@Then("^user validates additional services error function in additional services page mobile$")
   	public void select_additional_page_errorvalidation_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
   		AdditionalServicesMobilePage additionalpage =  new AdditionalServicesMobilePage(wd);
   		additionalpage.additionalpageerror(inputValues.get("Additional Option"));
   	}

	@Then("^user validate elements in cost preferences page mobile$")
   	public void elements_costpreferences_page_mobile() {
		CostPreferencesMobilePage costpage =  new CostPreferencesMobilePage(wd);
   		costpage.costpreferencepage();
   	}
	
	@Then("^user selects cost preferences option in cost preferences page mobile$")
   	public void select_costPreferenceOption_costpreferences_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		CostPreferencesMobilePage costpage =  new CostPreferencesMobilePage(wd);
   		costpage.costPreferencepageFunctional(inputValues.get("Preference Option"));
   	}
	
	@Then("^user validates cost preferences error function in cost preferences page mobile$")
   	public void select_costpreferences_page_errorvalidation_mobile() {
		CostPreferencesMobilePage costpage =  new CostPreferencesMobilePage(wd);
   		costpage.costPreferencepageerror();
   	}
	
	@Then("^user validate elements in loading page mobile$")
   	public void elements_loading_page_mobile() {
		LoadingMobilePage loadingpage =  new LoadingMobilePage(wd);
		loadingpage.loadingresultspage();
   	}
	
	@Then("^user validate recommendations in results page mobile$")
   	public void view_recommendations_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		resultpage.resultsUI(zip,county,r1,r2,false);
   	}
	
	@Then("^user validate tie recommendations in results page mobile$")
   	public void view_tie_recommendations_results_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		resultpage.resultsUI(zip,county,r1,r2,true);
   	}
	
	@Given("^user navigates to vpp summary page mobile$")
   	public void navigate_vpp_summary_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
		resultpage.navigateVPP(inputValues);
   	}
	
	@Then("^user adds Doctors in vpp summary page mobile$")
   	public void add_providers_vpp_summary_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
		resultpage.addProviderVPP(inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"));
   	}
	
	@Then("^user navigate Doctors lookup session in Doctors page mobile$")
	public void navigate_doctors_lookup_session_mobile() {
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		doctorpage.navigateDoctorsmodalsession();
	}
	
	@When("^user navigates to Zip Code page from vpp mobile$")
	public void user_navigates_to_zipcode_page_fromvpp_mobile() {
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
		resultpage.navigatePRE();
		LandingAndZipcodeMobilePage prelandingpage = new LandingAndZipcodeMobilePage(wd);
		prelandingpage.navigatezipcodepagemobile();
	}
	
	@And("^user verifies doctors session in Doctors page mobile$")
   	public void verify_doctors_session_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		resultpage.getProvidersPRE(multiDoctor);
		resultpage.verifyProvidersSession(multiDoctor);
   	}
	
	@Then("^user adds Providers in Doctors page mobile$")
	public void add_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		doctorpage.addProvidersPRE(inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"));
	}
	
	@And("^user verifies doctors session in VPP page mobile$")
   	public void verify_doctors_session_vpp_page_mobile() {
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
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
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
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
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
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
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
		resultpage.navigateVPPPREStartover();
		LandingAndZipcodeMobilePage prelandingpage = new LandingAndZipcodeMobilePage(wd);
		prelandingpage.navigatezipcodepagemobile();
	}
	
	@And("^user verifies existing PRE provider session using startover mobile$")
   	public void verify_exisitng_pre_doctors_session_doctors_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage docpage =  new DoctorsMobilePage(wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		docpage.verifyExisitngPREDoclist(multiDoctor);
		docpage.nextPageValidationDoctor();
   	}
	
	@And("^user verifies exisitng PRE drug session using startover mobile$")
   	public void verify_exisitng_pre_drugs_session_drug_page_mobile() {
		DrugMobilePage drugpage =  new DrugMobilePage(wd);
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
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
		String recom = inputValues.get("Recommendation");
		String plansorder = inputValues.get("Ranking plans Order");
		resultpage.validateRankingPlans(recom,plansorder);
   	}
	
	@Then("^verify continue function on \"([^\"]*)\" page mobile$")
   	public void proceed_next_page_mobile(String page) {
		CommonutilitiesMobile mobiletutli =  new CommonutilitiesMobile(wd);
		mobiletutli.continueNextpage(page.trim().toUpperCase(),false);
   	}
	
	@And("^user verifies existing PRE provider session using startnow mobile$")
   	public void verify_exisitng_pre_doctors_session_doctors_startnow_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		DoctorsMobilePage docpage =  new DoctorsMobilePage(wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		docpage.verifyExisitngPREDoclist(multiDoctor);
		docpage.nextPageNameValidationDoctor();
   	}
	
	@And("^user verifies exisitng PRE drug session using startnow mobile$")
   	public void verify_exisitng_pre_drugs_session_drug_startnow_page_mobile() {
		DrugMobilePage drugpage =  new DrugMobilePage(wd);
		drugpage.verifyExisitngPREDruglist();
		drugpage.continueNextpageNameDrug();
   	}
	
	@When("^user validate email plan list from vpp mobile$")
	public void user_sendPlanEmail_fromvpp_pdp_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		String recom = inputValues.get("Recommendation");
		String email = inputValues.get("EmailID");
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
		resultpage.sendEmail(recom,email);
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
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
		resultpage.validateUIAPIRecommendations();
		resultpage.validateUIAPIRankingPlans();
   	}
	
	@Then("^user adds Drugs in vpp summary page mobile$")
   	public void add_drugs_vpp_summary_page_mobile(DataTable givenAttributes) {
		readfeaturedataMobile(givenAttributes);
		ResultsMobilePage resultpage =  new ResultsMobilePage(wd);
		resultpage.useraddDrugsVPP(inputValues.get("Drug Details"));
   	}
	
	@Then("^user navigate drugs list page and verifies drugs session in Drugs page mobile$")
   	public void verifies_drugs_vpp_pre__mobile() {
		DrugMobilePage drugpage =  new DrugMobilePage(wd);
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
	
	@When("^user navigates to PRE landing page menu mobile$")
	public void user_navigates_PRE_landingpage_menu_mobile() {
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile(wd);
		preheaderfootermobile.navigatePRELandingpageMenuMobile();
	}
	
	public void readfeaturedataMobile(DataTable data) {
		inputRow = new ArrayList(data.getGherkinRows());
		inputValues = new HashMap<String, String>();
		for (int i = 0; i < inputRow.size(); i++) {
			inputValues.put(inputRow.get(i).getCells().get(0), inputRow.get(i).getCells().get(1));
		}
		String temp = inputValues.get("Plan Type");
		if (temp != null && PREflow != temp) {
			PREflow = temp;
			System.out.println("Current PRE Flow : "+PREflow);
		}
	}

}
