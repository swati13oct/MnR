package acceptancetests.acquisition.planRecommendationEngine;

import gherkin.formatter.model.DataTableRow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
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
import pages.mobile.acquisition.planrecommendationengine.DrugMobilePage;
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
		aquisitionhomepage.fixPrivateConnection();
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
		headerAndFooter.navigationToPlanRecommendationEngine();
//		headerAndFooter.breadCrumbs();
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
//		headerAndFooter.breadCrumbs();
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
		//headerAndFooter.breadCrumbs();
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
//                    headerAndFooter.breadCrumbs();
                    planSelectorDoctorspage.doctorspage();
                    
    }
    
    @And("^user selects doctors in doctors page$")
    public void select_plan_type_doctor_page(DataTable givenAttributes) throws Throwable {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
                    String doctor = inputValues.get("Doctors");
                    if (!(doctor.isEmpty())) {
                                    planSelectorDoctorspage.doctorspageFunctional(inputValues.get("Doctors"),inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"));
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
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage(wd);
                    planSelectorDoctorspage.doctorspageFunctional(inputValues.get("Doctors"),inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"));
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
                    PlanRecommendationEngineTravelPage planSelectorTravelpage =  new PlanRecommendationEngineTravelPage(wd);
                    String status = "Negative";
                    planSelectorTravelpage.travelpage(inputValues.get("Doctors"),status);                
    }
    
    @And("^user validate elements in drugs page$")
    public void elements_drugs_page() {
    				PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage(wd);
                    PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
//                    headerAndFooter.breadCrumbs();
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
//   		headerAndFooter.breadCrumbs();
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
   	public void elements_additional_page() {
   		PlanRecommendationEngineAdditionalServicesPage planSelectorAdditionalpage =  new PlanRecommendationEngineAdditionalServicesPage(wd);
   		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
//   		headerAndFooter.breadCrumbs();
   		planSelectorAdditionalpage.additionalpage();
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
//   		headerAndFooter.breadCrumbs();
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
//   		headerAndFooter.breadCrumbs();
   		planSelectorResultspage.resultsloadingpage();
   	}
}
