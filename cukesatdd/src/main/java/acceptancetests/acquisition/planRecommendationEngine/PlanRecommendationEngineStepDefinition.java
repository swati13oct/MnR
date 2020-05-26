package acceptancetests.acquisition.planRecommendationEngine;

import gherkin.formatter.model.DataTableRow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.MedicareAdvantagePartCPlansPage;
import pages.acquisition.bluelayer.MedicareEligibilityPage;
import pages.acquisition.bluelayer.MedicarePrescriptionDrugPartDPlansPage;
import pages.acquisition.bluelayer.PlanSelectorNewPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import pages.acquisition.bluelayer.PlanSelectorPage;
import pages.acquisition.planRecommendationEngine.ACQDrugCostEstimatorPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineAdditionalServicesPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineCommonutility;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineCostPreferencesPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineCoverageOptionPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDoctorsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDrugsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineHeaderAndFooter;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineLandingAndZipcodePages;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEnginePharmacyPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineResultsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineSpecialNeedsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineTravelPage;
import pages.acquisition.ulayer.AddDrugDetails;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.SavingsOppurtunity;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PlanRecommendationEngineStepDefinition {

	@Autowired
	
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	WebDriver wd;
	List<DataTableRow> inputRow;
	HashMap<String, String> inputValues;
	public static String PREflow="";
	
	public void readfeaturedata(DataTable data) {
		inputRow = new ArrayList(data.getGherkinRows());
		inputValues = new HashMap<String, String>();
		for (int i = 0; i < inputRow.size(); i++) {
			inputValues.put(inputRow.get(i).getCells().get(0),
			inputRow.get(i).getCells().get(1));
		}
		String temp = inputValues.get("Plan Type");
		if (temp != null && PREflow != temp) {
			PREflow = temp;
			System.out.println("Current PRE Flow : "+PREflow);
		}
	}
	
	@Given("^the user is on UHC medicare acquisition site landing page$")
	public void the_user_on_uhc_medicaresolutions_Site() {
		wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd,"PRE",true);
		aquisitionhomepage.openPRE();
//		aquisitionhomepage.fixPrivateConnection();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@Given("^the user is on Acquisition AARP medicare site landing page$")
	public void the_user_on_AARP_Site_medicaresolutions() {
		wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, "Ulayer");

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}


	@When("^user scrolls down to Plan selector on VPP page on right rail widget$")
	public void user_scrolls_down_PST_rightRail() throws Throwable {
		//AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
			//	.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		
		PlanSelectorNewPage planSelectorNewPage = aquisitionhomepage.PSTButton();
		if(planSelectorNewPage != null)
		getLoginScenario().saveBean(PageConstants.PLAN_SELECTOR_NEW_PAGE,
				planSelectorNewPage);
		else
			System.out.println("PST page not displayed");			

	}
	
	@When("^user scrolls down to Plan selector on VPP detail page on right rail widget$")
	public void user_scrolls_down_PST_detail_rightRail() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		System.out.println(aquisitionhomepage);
		PlanSelectorNewPage planSelectorNewPage = aquisitionhomepage.PSTButton();
		if(planSelectorNewPage != null)
		getLoginScenario().saveBean(PageConstants.PLAN_SELECTOR_NEW_PAGE,
				planSelectorNewPage);
		else
			System.out.println("PST page not displayed");			

	}
	
	
	@Then("^the user view plan details of the above selected plan in UMS site for DST$")
	public void user_views_plandetails_selected_plan_ums(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String planName = memberAttributesRow.get(0).getCells().get(1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		AcquisitionHomePage vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetailsDST(planName, planType);
		System.out.println(vppPlanDetailsPage);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			} else
				Assert.fail("Error in validating the Plan Details Page");
		}
	
	
	@When("^user goes to ours plan tab and click on Plan Selector button$")
	public void user_goes_to_ours_plan_tab_and_click_on_Plan_Selector_button() throws Throwable {
		AcquisitionHomePage aquisitionhomepage= (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PlanSelectorNewPage planSelectorNewPage = aquisitionhomepage.quizButton();
		if(planSelectorNewPage != null)
		getLoginScenario().saveBean(PageConstants.PLAN_SELECTOR_NEW_PAGE,
				planSelectorNewPage);
		else {
			System.out.println("PST page not displayed");
		Assert.fail("PST page not displayed");
		}

	}
		@And("^clicks on get started button and runs questionnaire$")
	public void clicks_on_get_started_button_and_directly_skip_to_results(DataTable givenAttributes) throws Throwable {
			readfeaturedata(givenAttributes);
			String zipcode = inputValues.get("Zip Code");
			System.out.println("Zipcode is:"+zipcode);
			String county = inputValues.get("CountyDropDown");
			System.out.println("Email is:"+county);
			String isMultiCounty = inputValues.get("Is Multi County");
			System.out.println("Entered Search Key is:"+isMultiCounty);
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		if (isMultiCounty.equalsIgnoreCase("NO")) {
			planSelectorhomepage.quizStartAndRunQuestionnaire(zipcode);
		} else {
			planSelectorhomepage.quizStartAndRunQuestionnaireWithCounty(zipcode, county);
		}
	}
	
	@And("^I select my Response and go to Next Questionnaire$")
	public void I_click_questionnaire_first() throws Throwable {
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		planSelectorNewPage.NextQuestion();
	}
	
	@And("^I select my second Response and go directly to results page$")
	public void I_click_questionnaire_second()  throws Throwable {
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		boolean isResultsPage = planSelectorNewPage.JumpLink();
		Assert.assertTrue("Plan Results Page not loaded", isResultsPage);
	}
	

	@When("^I click plan detail button$")
	public void i_click_plan_detail_button() throws Throwable {
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		boolean isPlanDetailsPage = planSelectorNewPage.navigateToPlanDetails(County);
		Assert.assertTrue("Plan Details Page is not loaded", isPlanDetailsPage);

	}


	@Then("^the user clicks on both top and bottom back to plan options link and validates its redirection$")
	public void i_should_be_brought_back_to_the_plan_selector_results_page() throws Throwable {
		PlanSelectorNewPage planSelectorNewPage = (PlanSelectorNewPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_NEW_PAGE);
		planSelectorNewPage.verifyBackToPlanOptionslink();

	}
	
	@When("^user navigate to Plan Recommendation Engine and Checking Breadcrumbs$")
	public void user_navigate_PRE_Breadcrumbs() throws InterruptedException {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
//		headerAndFooter.navigationToPlanRecommendationEngine();
		headerAndFooter.breadCrumbs();
	}
	
	@Then("^user validate elements on landing page of Plan Recommendation Engine$")
	public void user_check_landing_page_Plan_Selector_tool() throws InterruptedException {
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages(wd);
		planSelectorhomepage.landingpage();
	}

	
	@When("^user navigate Plan Recommendation Engine Using Get Help Choosing in Tools$")
	public void navigate_Plan_Selector_tool() {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages(wd);
		headerAndFooter.navigationToPlanRecommendationEngineViaShopTools();
		headerAndFooter.breadCrumbs();
		planSelectorhomepage.landingpage();
}
	
	@Then("^user validate Header elements and Link Validation of Plan Recommendation Engine$")
	public void user_check_header_Plan_Selector_tool() {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
		headerAndFooter.headerElements();
		headerAndFooter.headerLinkvalidation();
	}
	@Then("^user validate Footer elements and Link Validation of Plan Recommendation Engine$")
	public void user_check_header_footer_Plan_Selector_tool() throws Exception {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
		headerAndFooter.footerElements();
		headerAndFooter.footerLinkvalidation();
	}
	@Then("^user validate Header and Footer Functionality of Plan Recommendation Engine$")
	public void user_check_header_footer_Actions_Plan_Selector_tool(DataTable givenAttributes) throws Throwable{
		String actualpageurl = wd.getCurrentUrl();
		readfeaturedata(givenAttributes);
		String zipcode = inputValues.get("Zip Code");
		System.out.println("Zipcode is:"+zipcode);
		String email = inputValues.get("EMail");
		System.out.println("Email is:"+email);
		String searchKey = inputValues.get("Search Key");
		System.out.println("Entered Search Key is:"+searchKey);
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
		headerAndFooter.zipcodeFunctionInShopforaplan(zipcode);
		Thread.sleep(5000);
		headerAndFooter.emailFunctionInShopforaplan(email);
		Thread.sleep(5000);
		if(actualpageurl.contains("uhcmedicaresolutions")){
			headerAndFooter.enterSearchFunction(searchKey);
			Thread.sleep(5000);	
		}
		headerAndFooter.backtoTopFunction();
	}
	
	@And("^clicks on get started button and check error scenarios$")
	public void clicks_on_get_started_button_and_check_error_scenarios(DataTable givenAttributes) throws Throwable {
		readfeaturedata(givenAttributes);
		String zipcode = inputValues.get("Zip Code");
		String county = inputValues.get("CountyDropDown");
		String isMultiCounty = inputValues.get("Is Multi County");
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages(wd);
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
		headerAndFooter.breadCrumbs();
		if (isMultiCounty.equalsIgnoreCase("NO")) {
			planSelectorhomepage.getStartedAndRunInvalidzipcode(zipcode);
		} else {
			planSelectorhomepage.getStartedAndRunzipcodeWithCounty(zipcode, county);
		}
			
	}
	
	@And("^user validate elements in coverage options page$")
	public void elements_coverage_page() {
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage(wd);
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
		headerAndFooter.breadCrumbs();
		planSelectorCoverageepage.coverageOptionpage();
		
	}
	
	@And("^user selects plan type in coverage options page$")
	public void select_plan_type_coverage_page(DataTable givenAttributes) throws Throwable {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage(wd);
		String plantype = inputValues.get("Plan Type");
		if (!(plantype.isEmpty())) {
			planSelectorCoverageepage.coverageOptionpageFunctional(plantype);
		}
	}
	
	@And("^user not selects plan type in coverage options page$")
	public void notselect_plan_type_coverage_page(DataTable givenAttributes) throws Throwable {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage(wd);
		String plantype = inputValues.get("Plan Type");
		if (plantype.isEmpty()) {
			planSelectorCoverageepage.coverageOptionpageerror();
		}
	}
	
	@And("^user select planType and continous the page back to previous page$")
	public void previous_coverage_page(DataTable givenAttributes) throws Throwable {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage(wd);
		planSelectorCoverageepage.coverageOptionpageFunctional(inputValues.get("Plan Type"));
	}
	
	@And("^user select planType and Click previous button to check previous page$")
	public void previous_zipcode_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage(wd);
		planSelectorCoverageepage.coverageOptionpagePreviousButton(inputValues.get("Plan Type"));
	}
	
	@Then("^user validate elements in Special Needs page$")
	public void elements_special_page() {
		PlanRecommendationEngineSpecialNeedsPage planSelectorSpecialneedspage =  new PlanRecommendationEngineSpecialNeedsPage(wd);
		planSelectorSpecialneedspage.specialNeedspage();
	}
	
	@And("^user selects SNP options in Special Needs Page")
	public void select_special_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineSpecialNeedsPage planSelectorSpecialneedspage =  new PlanRecommendationEngineSpecialNeedsPage(wd);
		String status = "Positive";
		planSelectorSpecialneedspage.specialneedspage(inputValues.get("SNP Options"),status);	
	}
	
	@And("^user validating error scenario in Special Needs Page")
	public void error_special_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineSpecialNeedsPage planSelectorSpecialneedspage =  new PlanRecommendationEngineSpecialNeedsPage(wd);
		String status = "Negative";
		planSelectorSpecialneedspage.specialneedspage(inputValues.get("SNP Options"),status);	
	}
	
	@Then("^user validate elements in Travel page$")
	public void elements_travel_page() {
		PlanRecommendationEngineTravelPage planSelectorTravelpage =  new PlanRecommendationEngineTravelPage(wd);
		planSelectorTravelpage.travelPageElement();
	}
	
	@And("^user selects Travel options in Care Away From Home Page")
	public void select_travel_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineTravelPage planSelectorTravelpage =  new PlanRecommendationEngineTravelPage(wd);
		String status = "Positive";
		planSelectorTravelpage.travelpage(inputValues.get("Travel Options"),status);	
	}
	
	@And("^user validating error scenario in Care Away From Home Page")
	public void error_travel_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineTravelPage planSelectorTravelpage =  new PlanRecommendationEngineTravelPage(wd);
		String status = "Negative";
		planSelectorTravelpage.travelpage(inputValues.get("Travel Options"),status);	
	}
	
	@And("^user validate elements in doctors page$")
    public void elements_doctor_page() {
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
                    PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
                    headerAndFooter.breadCrumbs();
                    planSelectorDoctorspage.doctorspageElements();
                    
    }
    
    @And("^user selects doctors in doctors page$")
    public void select_plan_type_doctor_page(DataTable givenAttributes) throws Throwable {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
                    String doctor = inputValues.get("Doctors");
                    String status = "Positive_NextPageName";
                    if (!(doctor.isEmpty())) {
                                    planSelectorDoctorspage.doctorspageFunctional(inputValues.get("Doctors"),inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"),status);
                    }
    }
    
    @And("^user not selects doctors in doctors page$")
    public void notselect_doctor_type_doctor_page(DataTable givenAttributes) throws Throwable {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
                    String doctor = inputValues.get("Doctors");
                    if (doctor.isEmpty()) {
                                    planSelectorDoctorspage.doctorspageerror();
                    }
    }
    
    @And("^user select doctors and continous the page back from Doctors to previous page$")
    public void previous_doctors_page(DataTable givenAttributes) throws Throwable {
                    readfeaturedata(givenAttributes);
                    String status = "Positive_NextPageName";
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
                    planSelectorDoctorspage.doctorspageFunctional(inputValues.get("Doctors"),inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"),status);
    }
    
    @And("^user select doctors and Click previous button from Doctors to check previous page$")
    public void previous_travel_page(DataTable givenAttributes) {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
                    planSelectorDoctorspage.doctorspagePreviousButton(inputValues.get("Doctors"));
    }
    
    @And("^user validating error scenario in doctors Page")
    public void error_doctor_page(DataTable givenAttributes) {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
                    planSelectorDoctorspage.doctorspageerror();             
    }
    
    @And("^user selects Doctors in Doctors page and cancels the selection$")
	public void select_doctors_page_cancelvalidation(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
		planSelectorDoctorspage.doctorspageCancel(inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"));
	}
    
    @And("^user validate elements in drugs page$")
    public void elements_drugs_page() {
    				PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
                    PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
                    headerAndFooter.breadCrumbs();
                    planSelectorDrugspage.drugspage();
                    
    }
    
       @And("^user selects skip option in Drug page$")
    public void select_prescription_drug_page(DataTable givenAttributes) throws Throwable {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
                    String drug = inputValues.get("Drug Selection");
                    	planSelectorDrugspage.skipDrugs(drug);
                    	
    }
       
       @Then("^user selects add drug option in Drug page$")
   	public void add_drugs_page(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
   		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
   		planSelectorDrugspage.drugsHandlerWithdetails(inputValues.get("Drug Details"));
   		planSelectorDrugspage.continueNextpage();
   	}
       
       @Then("^user selects add drug option and cancels the modals in Drug page$")
   	public void add_drugs_page_cancelvalidation(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
   		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
   		planSelectorDrugspage.drugspageCancel(inputValues.get("Drug Details"));
   	}
       
       @Then("^user validates errors in Drug page$")
   	public void add_drugs_page_errorvalidation(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
   		planSelectorDrugspage.drugpagesError(inputValues.get("Drug Details"));
   	}
       
       @Then("^user search and choose a drug in Drug page$")
   	public void choose_drugs_page(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
   		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
   		planSelectorDrugspage.drugChoose(inputValues.get("Search Text"),inputValues.get("Drug Details"));
   		planSelectorDrugspage.continueNextpage();
   	}
       
       @Then("^user selects add drug option without drugs in Drug page$")
   	public void add_NoDrug_drugs_page(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
   		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
   		planSelectorDrugspage.continueNextpageZeroDrug();
   	}
       
       @Then("^user selects add drug option and comparing DCE and Drug page$")
      	public void verify_drugs_dce_drug_page(DataTable givenAttributes) {
      		readfeaturedata(givenAttributes);
      		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
      		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
      		planSelectorDrugspage.comparingDrugwithDCE();
      	}
       
       @Then("^user selects add drug option and verifying the drugs in Drug page$")
     	public void verify_drugs_page(DataTable givenAttributes) {
     		readfeaturedata(givenAttributes);
     		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
     		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
     		planSelectorDrugspage.comparingDrugsStartOver();
     	}
    
       @And("^user not selects prescription options in drug page$")
    public void notselect_prescription_opt_drug_page(DataTable givenAttributes) throws Throwable {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
                    String drug = inputValues.get("Drug Selection");
                    if (drug.isEmpty()) {
                    	planSelectorDrugspage.drugspageerror();
                    }
    }
       
       @Then("^user search and not found a drug in Drug Page$")
   	public void notfound_drugs_page(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
   		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
   		planSelectorDrugspage.drugNotFound(inputValues.get("Search Text"));
   	}
       
       @And("^user validate elements in pharmacy page$")
   	public void elements_pharmacy_page() {
    	PlanRecommendationEnginePharmacyPage planSelectorPharmacyepage =  new PlanRecommendationEnginePharmacyPage(wd);
   		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
   		headerAndFooter.breadCrumbs();
   		planSelectorPharmacyepage.pharmacypage();
   		
   	}
   	
   	@And("^user selects pharmacy option in pharmacy page$")
   	public void select_pharmacy_option_pharmacy_page(DataTable givenAttributes) throws Throwable {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEnginePharmacyPage planSelectorPharmacyepage =  new PlanRecommendationEnginePharmacyPage(wd);
   		String pharmacytype = inputValues.get("Pharmacy Type");
   		if (!(pharmacytype.isEmpty())) {
   			planSelectorPharmacyepage.doctorspageFunctional(pharmacytype);
   		}
   	}
   	
   	@And("^user not selects pharmacy option in pharmacy page$")
   	public void notselect_pharmacy_option_pharmacy_page(DataTable givenAttributes) throws Throwable {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEnginePharmacyPage planSelectorPharmacyepage =  new PlanRecommendationEnginePharmacyPage(wd);
   		String pharmacytype = inputValues.get("Pharmacy Type");
   		if (pharmacytype.isEmpty()) {
   			planSelectorPharmacyepage.pharmacypageerror();
   		}
   	}
   	
   	@And("^user select pharmacy option and Click previous button to check previous page$")
   	public void previous_pharmacy_page(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEnginePharmacyPage planSelectorPharmacyepage =  new PlanRecommendationEnginePharmacyPage(wd);
   		planSelectorPharmacyepage.pharmacypagePreviousButton(inputValues.get("Pharmacy Type"));
   	}
	
   	@Then("^user validate elements in additional services page$")
   	public void elements_additional_page(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineAdditionalServicesPage planSelectorAdditionalpage =  new PlanRecommendationEngineAdditionalServicesPage(wd);
   		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
   		headerAndFooter.breadCrumbs();
   		planSelectorAdditionalpage.additionalpage(inputValues.get("Drug Selection"));
   	}
   	
	@Then("^user selects additional services option in additional services page$")
   	public void select_additionalServiceOption_additional_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineAdditionalServicesPage planSelectorAdditionalpage =  new PlanRecommendationEngineAdditionalServicesPage(wd);
   		planSelectorAdditionalpage.additionalpageFunctional(inputValues.get("Additional Option"));
   	}
	
	@Then("^user validates additional services error function in additional services page$")
   	public void noselect_additionalServiceOption_additional_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineAdditionalServicesPage planSelectorAdditionalpage =  new PlanRecommendationEngineAdditionalServicesPage(wd);
   		planSelectorAdditionalpage.additionalpageerror(inputValues.get("Additional Option"));
   	}

	@Then("^user validate elements in cost preferences page$")
   	public void elements_costpreferences_page() {
		PlanRecommendationEngineCostPreferencesPage planSelectorPreferencespage =  new PlanRecommendationEngineCostPreferencesPage(wd);
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
   		headerAndFooter.breadCrumbs();
   		planSelectorPreferencespage.costpreferencepage();
   	}
	
	@Then("^user selects cost preferences option in cost preferences page$")
   	public void select_costPreferenceOption_costpreferences_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCostPreferencesPage planSelectorPreferencespage =  new PlanRecommendationEngineCostPreferencesPage(wd);
   		planSelectorPreferencespage.costPreferencepageFunctional(inputValues.get("Preference Option"));
   	}
	
	@Then("^user validates cost preferences error function in cost preferences page$")
	public void noselect_costPreferenceOption_costpreferences_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCostPreferencesPage planSelectorPreferencespage = new PlanRecommendationEngineCostPreferencesPage(wd);
		String preference = inputValues.get("Preference Option");
		if (preference.isEmpty()) {
			planSelectorPreferencespage.costPreferencepageerror();
		}
	}
	
	@Then("^user validate elements in loading results page$")
   	public void elements_results_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
   		headerAndFooter.breadCrumbs();
   		planSelectorResultspage.resultsloadingpage();
   	}
	
	@Then("^user validate recommendations in results page$")
   	public void view_recommendations_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		planSelectorResultspage.resultsUI(zip,county,r1,r2,false);
   	}
	
	@Then("^user validate tie recommendations in results page$")
   	public void view_tie_recommendations_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		planSelectorResultspage.resultsUI(zip,county,r1,r2,true);
   	}
	
	@Then("^user validate drugs details from PRE to VPP page$")
	public void view_drugs_PRE_VPP_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		planSelectorResultspage.drugsDetailsPREtoVPP();
	}
	
	@Then("^user validate removed drugs details updated from VPP to PRE page$")
	public void view_removed_drugs_VPP_PRE_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		planSelectorResultspage.removedDrugsDetailsVPPtoPRE();
	}
	
	@Then("^user navigate to PRE using StartNow button and verify drugs details in PRE page$")
	public void startnow_PRE_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		planSelectorResultspage.startnowtilldrugs();
	}
	
	@Then("^user proceed page navigation till VPP page after Start Now button$")
	public void view_VPP_StartNow_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		planSelectorResultspage.startNowFullFlow(inputValues.get("Plan Type"));
	}
	
	@Then("^user validate drugs details from DCE to VPP and PRE page$")
	public void drugs_DCE_VPP_PRE_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		planSelectorResultspage.DrugsDetailsVPPtoPRE();
	}
	
	@And("^user navigates to vpp summary page$")
   	public void navigate_vpp_summary_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		String zip = inputValues.get("Zip Code");
		planSelectorResultspage.navigateVPP(zip);
   	}
	
	@When("^I have added a drug to my drug list$")
	public void I_have_added_a_drug_to_my_drug_list(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(wd);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		planSelectorResultspage.vppToDCE();
		String drug = inputValues.get("Drug");
		boolean isDrugPresent = dce.isDrugPresent(drug);
		if(!isDrugPresent)
			dce.addDrug(drug);
		else
			Assert.fail("Drug Details content not loaded");
	}

	/**
	 * @toDo:
	 */
	@And("^user selects drug details in drugs page$")
	public void user_select_drugs(DataTable givenAttributes){
		readfeaturedata(givenAttributes);
		String drug = inputValues.get("Drug");
		String dosage = inputValues.get("Dosage");
		String quantity = inputValues.get("Quantity");
		String frequency = inputValues.get("Frequency");
		String dosages = drug+" "+dosage;
		ACQDrugCostEstimatorPage DrugDetails = new ACQDrugCostEstimatorPage(wd);
		DrugDetails.selectDosage(dosages);
		DrugDetails.selectQnty(quantity);
		DrugDetails.selectFrequency(frequency);		
	}
	
	/**
	 * @toDo:
	 */
	@When("^user successfully adds drug$")
	public void user_successfully_adds_drug(DataTable givenAttributes){
		readfeaturedata(givenAttributes);
		String isBranded = inputValues.get("Is Branded Drug");
		String drug = inputValues.get("Drug");
		ACQDrugCostEstimatorPage DrugDetails = new ACQDrugCostEstimatorPage(wd);
		if (isBranded.trim().equalsIgnoreCase("YES")) {
			DrugDetails.continueAddDrugDetailsModWithSaving();
		} else {
			DrugDetails.continueAddDrugDetailsModNoSaving();
		}
		Assert.assertTrue("Drug not added", null != DrugDetails);
		DrugDetails.validateAddedDrug(drug);
	}
	
	/**
	 * @toDo:
	 */
	@And("^I navigate to step2 page$")
	public void I_navigate_to_step2_page_aarp () 	{
		ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(wd);
		dce.navigateToStep2();
	}
	
	
	@When("^I select the first pharmacy$")
	public void I_select_the_drug() {
		ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(wd);
		dce.select_first_pharmacy();
		
	}
	
	@Then("^I navigate to step3 page and validate$")
	public void I_navigate_to_step_page(DataTable givenAttributes)  {
		readfeaturedata(givenAttributes);
		String drug = inputValues.get("Drug");
		ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(wd);
		dce.navigateToStep3();
	   if(dce.validateDrugOnStep3(drug))
		   Assert.assertTrue(true);
	   else
		   Assert.fail("Error:the drug did not display on step 3 page"); 
	}
	
	@And("^the user clicks on return link to navigate to plan summary$")
	public void clickOnReturnLink(){
		ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(wd);
		dce.clickReturnToSummaryLink();
	}
	
	@Then("^user adds Doctors in vpp summary page$")
   	public void add_providers_vpp_summary_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		planSelectorResultspage.addProviderVPP(inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"));
		planSelectorResultspage.vppToPre();
   	}
	
	@Then("^user navigate Doctors lookup session in Doctors page$")
	public void navigate_doctors_lookup_session() {
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
		planSelectorDoctorspage.navigateDoctorsmodalsession();
	}
	
	@And("^user verifies doctors session in Doctors page$")
   	public void verify_doctors_session_doctors_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		planSelectorResultspage.getProvidersPRE(multiDoctor);
		planSelectorResultspage.verifyProvidersSession(multiDoctor);
   	}
	
	@When("^user navigates to Zip Code page from vpp plans$")
	public void user_navigates_to_zipcode_page_fromvpp_pdp() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		planSelectorResultspage.vppToPre();
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages(wd);
		planSelectorhomepage.navigatezipcodepage();
	}
	
	@And("^user validte zip info in location page$")
	public void user_validates_zipcodepage(DataTable inputdata) {
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages(wd);
		readfeaturedata(inputdata);
		planSelectorhomepage.zipcodeInfoValidation(inputValues);
	}
	
	@And("^user verifies Start Over doctors session in Doctors page$")
   	public void verify_StartOver_doctors_session_doctors_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		planSelectorResultspage.getProvidersPRE(multiDoctor);
		planSelectorResultspage.verifyDoctorsSession(multiDoctor);
   	}
	
	@Then("^user adds Providers in Doctors page$")
	public void add_doctors_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
		planSelectorDoctorspage.addProvidersPRE(inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"));
	}
	
	@And("^user verifies doctors session in VPP page$")
   	public void verify_doctors_session_vpp_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		planSelectorResultspage.verifyProviderPREVPP();
   	}
	
	@Then("^user edits Doctors in Doctors page$")
	public void edit_doctors_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
		planSelectorDoctorspage.editProvider(inputValues.get("Doctors Search Text1"), inputValues.get("Multi Doctor1"),
				inputValues.get("Doctors Search Text2"), inputValues.get("Multi Doctor2"));
	}
	
	@Then("^user navigates to VPP Summary Page$")
   	public void startNow_vpp_summary_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String isMultiCounty = inputValues.get("Is Multi County");
		planSelectorResultspage.countyandViewPlan(zip,county,isMultiCounty);
   	}
	
	@Then("^user validate zipcode and County in location page using StartNow$")
   	public void zipcode_location_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String isMultiCounty = inputValues.get("Is Multi County");
		planSelectorResultspage.vppToPre();
		planSelectorResultspage.validateZipcodePage(zip,county,isMultiCounty);
   	}
	
	@Then("^user navigate to PRE and validate zipcode using Start Over$")
   	public void zipcode_Doc_Drug_pre(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String isMultiCounty = inputValues.get("Is Multi County");
		planSelectorResultspage.vppToPreStartOver();
		planSelectorResultspage.validateZipcodePage(zip,county,isMultiCounty);
   	}
	
	@Then("^user validate recommendation rankings in results page$")
   	public void verify_rankings_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		String recom = inputValues.get("Recommendation");
		String plansorder = inputValues.get("Ranking plans Order");
		planSelectorResultspage.validateRankingPlans(recom,plansorder);
   	}
	
	@Then("^verify continue function on \"([^\"]*)\" page$")
   	public void proceed_next_page(String page) {
		PlanRecommendationEngineCommonutility commonutli =  new PlanRecommendationEngineCommonutility(wd);
		commonutli.continueNextpage(page.trim().toUpperCase(),false);
   	}
	
	@And("^user verifies existing PRE provider session using startnow$")
   	public void verify_exisitng_pre_doctors_session_doctors_startnow_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
		String multiDoctor = inputValues.get("Multi Doctor");
		planSelectorDoctorspage.verifyExisitngPREDoclist(multiDoctor);
		planSelectorDoctorspage.nextPageNameValidationDoctor();
   	}
	
	@And("^user verifies exisitng PRE drug session using startnow$")
   	public void verify_exisitng_pre_drugs_session_drug_startnow_page() {
		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
		planSelectorDrugspage.verifyExisitngPREDruglist();
		planSelectorDrugspage.continueNextpageNameDrug();
   	}
	
	@When("^user validate email plan list from vpp$")
	public void user_sendPlanEmail_fromvpp_pdp(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		String recom = inputValues.get("Recommendation");
		String email = inputValues.get("EmailID");
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
		planSelectorResultspage.sendEmail(recom,email);
	}
	
	@Then("^user selects Doctors in Doctors page and validate next page name$")
	public void select_doctors_next_page_name(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
		String status = "Positive_NextPageName";
		planSelectorDoctorspage.doctorspageFunctional(inputValues.get("Doctors Selection"), inputValues.get("Doctors Search Text"),
				inputValues.get("Multi Doctor"), status);
	}
	
	@Then("^user validate UI and API recommendation rankings in results page$")
   	public void verify_UI_API_rankings_results_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage(wd);
//		planSelectorResultspage.validateUIAPIRecommendations();
		planSelectorResultspage.validateUIAPIRankingPlans();
   	}
}
