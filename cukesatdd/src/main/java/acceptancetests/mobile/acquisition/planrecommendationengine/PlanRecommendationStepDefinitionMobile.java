package acceptancetests.mobile.acquisition.planrecommendationengine;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import pages.mobile.acquisition.planrecommendationengine.SpecialNeedsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.TravelMobilePage;
import pages.mobile.acquisition.planrecommendationengine.AdditionalServicesMobilePage;
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
		readfeaturedata(inputdata);
		HeaderFooterMobile preheaderfootermobile = new HeaderFooterMobile(wd);
		preheaderfootermobile.zipcodeFunctionInShopforaplanHeaderMobile(inputValues.get("Zip Code"));
		preheaderfootermobile.emailFunctionInShopforaplanMobile(inputValues.get("EMail"));
		preheaderfootermobile.enterSearchFunctionHeaderMobile(inputValues.get("Search Key"));
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
		readfeaturedata(inputdata);
		prezipcodemobile.zipcodepageValidationmobile(inputValues);
		System.out.println("hell");
	}

	@Then("^runs questionnaire at zipcode page with invalid data mobile$")
	public void user_runs_questionnaire_zipcodepage_invalid_data_mobile(DataTable inputdata) {
		LandingAndZipcodeMobilePage prezipcodemobile = new LandingAndZipcodeMobilePage(wd);
		readfeaturedata(inputdata);
		prezipcodemobile.zipcodescreenErrorValidationmobile(inputValues);
	}

	@Then("^user validate elements in coverage options page mobile$")
	public void user_check_coveragepage_elements_mobile() {
		CoverageOptionsMobilePage coveragepage = new CoverageOptionsMobilePage(wd);
		coveragepage.coverageOptionpageElementsMobile();
	}

	@Then("^user selects plan type in coverage options page mobile$")
	public void select_plan_type_coverage_page_mobile(DataTable inputdata) throws Throwable {
		readfeaturedata(inputdata);
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
		readfeaturedata(inputdata);
		CoverageOptionsMobilePage coveragepage = new CoverageOptionsMobilePage(wd);
		coveragepage.coverageOptionpageFunctionalMobile(inputValues.get("Plan Type"), false);
		coveragepage.previouspageValidation();
	}

	@Then("^user validate elements in Special Needs page mobile$")
	public void elements_special_page() {
		SpecialNeedsMobilePage specialneedspage = new SpecialNeedsMobilePage(wd);
		specialneedspage.specialNeedspageElements();
	}

	@And("^user selects SNP options in Special Needs Page mobile$")
	public void select_special_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		SpecialNeedsMobilePage specialneedspage = new SpecialNeedsMobilePage(wd);
		String status = "Positive";
		specialneedspage.specialneedspage(inputValues.get("SNP Options"), status);
	}

	@And("^user selects SNP options in Special Needs Page mobile and validate errors$")
	public void select_special_needs_page_errorvalidation(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		SpecialNeedsMobilePage specialneedspage = new SpecialNeedsMobilePage(wd);
		String status = "Negative";
		specialneedspage.specialneedspage(inputValues.get("SNP Options"), status);
	}

	@Then("^user validate elements in Travel page mobile$")
	public void elements_travel_page() {
		TravelMobilePage careawaypage = new TravelMobilePage(wd);
		careawaypage.travelpageElements();
	}

	@And("^user selects Travel options in Travel Page mobile$")
	public void select_travel_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		TravelMobilePage careawaypage = new TravelMobilePage(wd);
		String status = "Positive";
		careawaypage.travelpage(inputValues.get("Travel Options"), status);
	}

	@And("^user selects Travel options in Travel Page mobile and validate errors$")
	public void select_travel_page_errorvalidation(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		TravelMobilePage careawaypage = new TravelMobilePage(wd);
		String status = "Negative";
		careawaypage.travelpage(inputValues.get("Travel Options"), status);
	}

	@Then("^user validate elements in Doctors page mobile$")
	public void elements_doctors_page() {
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		doctorpage.doctorspageElements();
	}

	@Then("^user selects Doctors in Doctors page mobile$")
	public void select_doctors_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		String status = "Positive";
		doctorpage.doctorspage(inputValues.get("Doctors Selection"), inputValues.get("Doctors Search Text"),
				inputValues.get("Multi Doctor"), status);
	}

	@And("^user selects Doctors in Doctors page mobile and validate errors$")
	public void select_doctors_page_errorvalidation(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		String status = "Negative";
		doctorpage.doctorspage(inputValues.get("Doctors Selection"), inputValues.get("Doctors Search Text"),
				inputValues.get("Multi Doctor"), status);
	}

	@And("^user selects Doctors in Doctors page mobile and cancels the selection$")
	public void select_doctors_page_cancelvalidation(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		DoctorsMobilePage doctorpage = new DoctorsMobilePage(wd);
		doctorpage.doctorspageCancel(inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"));
	}

	@Then("^user validate elements in Drug page mobile$")
	public void elements_drug_page() {
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugspageElements();
	}

	@Then("^user selects skip option in Drug page mobile$")
	public void elements_drugskip_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.skipDrugs(inputValues.get("Drug Selection"));
	}

	@Then("^user selects add drug option in Drug page mobile$")
	public void add_drugs_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugsHandlerWithdetails(inputValues.get("Drug Details"));
		drugpage.continueNextpage();
	}

	@Then("^user selects add drug option and cancels the modals in Drug page mobile$")
	public void add_drugs_page_cancelvalidation(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugspageCancel(inputValues.get("Drug Details"));
	}

	@Then("^user validates errors in Drug page mobile$")
	public void add_drugs_page_errorvalidation(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugpagesError(inputValues.get("Drug Details"));
	}

	@Then("^user search and choose a drug in Drug page mobile$")
	public void choose_drugs_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugChoose(inputValues.get("Search Text"),inputValues.get("Drug Details"));
		drugpage.continueNextpage();
	}
	
	@Then("^user selects add drug option without drugs in Drug page mobile$")
	public void add_NoDrug_drugs_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.continueNextpageZeroDrug();
	}
	
	@Then("^user search and not found a drug in Drug page mobile$")
	public void notfound_drugs_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		DrugMobilePage drugpage = new DrugMobilePage(wd);
		drugpage.drugsInitiate(inputValues.get("Drug Selection"));
		drugpage.drugNotFound(inputValues.get("Search Text"));
	}
	
	@Then("^user validate elements in Pharmacy page mobile$")
	public void elements_pharmacy_page() {
		PharmacyMobilePage pharmacypage =  new PharmacyMobilePage(wd);
		pharmacypage.pharmacypageElements();
	}
	
	@Then("^user selects Pharmacy in Pharmacy page mobile$")
	public void select_pharmacy_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PharmacyMobilePage pharmacypage =  new PharmacyMobilePage(wd);
		String status = "Positive";
		pharmacypage.pharmacyFunctional(inputValues.get("Pharmacy Selection"),status);
	}
	
	@And("^user selects Pharmacy in Pharmacy page mobile and validate errors$")
	public void select_pharmacy_page_errorvalidation(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PharmacyMobilePage pharmacypage =  new PharmacyMobilePage(wd);
		String status = "Negative";
		pharmacypage.pharmacyFunctional(inputValues.get("Pharmacy Selection"),status);	
	}
	
	@Then("^user validate elements in additional services page mobile$")
   	public void elements_additional_page() {
   		AdditionalServicesMobilePage additionalpage =  new AdditionalServicesMobilePage(wd);
   		additionalpage.additionalpage();
   	}
   	
	@Then("^user selects additional services option in additional services page mobile$")
   	public void select_additionalServiceOption_additional_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
   		AdditionalServicesMobilePage additionalpage =  new AdditionalServicesMobilePage(wd);
   		additionalpage.additionalpageFunctional(inputValues.get("Additional Option"));
   	}
	
	@Then("^user validates additional services error function in additional services page mobile$")
   	public void select_additional_page_errorvalidation(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
   		AdditionalServicesMobilePage additionalpage =  new AdditionalServicesMobilePage(wd);
   		additionalpage.additionalpageerror(inputValues.get("Additional Option"));
   	}

	@Then("^user validate elements in cost preferences page mobile$")
   	public void elements_costpreferences_page() {
		CostPreferencesMobilePage costpage =  new CostPreferencesMobilePage(wd);
   		costpage.costpreferencepage();
   	}
	
	@Then("^user selects cost preferences option in cost preferences page mobile$")
   	public void select_costPreferenceOption_costpreferences_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		CostPreferencesMobilePage costpage =  new CostPreferencesMobilePage(wd);
   		costpage.costPreferencepageFunctional(inputValues.get("Preference Option"));
   	}
	
	@Then("^user validates cost preferences error function in cost preferences page mobile$")
   	public void select_costpreferences_page_errorvalidation() {
		CostPreferencesMobilePage costpage =  new CostPreferencesMobilePage(wd);
   		costpage.costPreferencepageerror();
   	}
	
	@Then("^user validate elements in loading page mobile$")
   	public void elements_loading_page() {
		LoadingMobilePage loadingpage =  new LoadingMobilePage(wd);
		loadingpage.loadingresultspage();
   	}
	
	public void readfeaturedata(DataTable data) {
		inputRow = new ArrayList(data.getGherkinRows());
		inputValues = new HashMap<String, String>();
		for (int i = 0; i < inputRow.size(); i++) {
			inputValues.put(inputRow.get(i).getCells().get(0), inputRow.get(i).getCells().get(1));
		}
		String temp = inputValues.get("Plan Type");
		if (temp != null && PREflow == "")
			PREflow = temp;
	}

}
