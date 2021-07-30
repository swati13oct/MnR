package acceptancetests.acquisition.planRecommendationEngine;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.PlanSelectorNewPage;
import pages.acquisition.planRecommendationEngine.ACQDrugCostEstimatorPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineAdditionalServicesPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineCommonutility;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineCostPreferencesPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineCoverageOptionPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDoctorsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDrugsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineEditResponsePage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineHeaderAndFooter;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineLandingAndZipcodePages;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineNewResultsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEnginePharmacyPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEnginePrioritiesPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineResultsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineSpecialNeedsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineTravelPage;

public class PlanRecommendationEngineStepDefinition {

	@Autowired
	
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
//	WebDriver wd;
//	List<DataTableRow> inputRow;
	HashMap<String, String> inputValues;
	public String PREflow="";
	
	public void readfeaturedata(DataTable data) {
		inputValues = new HashMap<String, String>();
		inputValues = DataTableParser.readDataTableAsMaps(data);
		String temp = inputValues.get("Plan Type");
		if (temp != null && PREflow != temp) {
			PREflow = temp;
			//System.out.println("\n\n\n\n\n\n");
			String curID = String.valueOf(Thread.currentThread().getId());
			System.out.println("Current Thread ID is - "+curID+" for the flow "+PREflow);
			//CommonConstants.PRE_FLOW = new LinkedHashMap<String,String>();
			CommonConstants.PRE_FLOW.put(curID, PREflow);
		}
	}
	
	boolean if_offline_prod = false, popup_clicked = false;
	@Given("^the user is on UHC medicare acquisition site PRE landing page$")
	public void the_user_on_uhc_medicaresolutions_Site(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd,"PRE"); //changed on 3/3/21 as part of AARP/UHC cleanup
		if_offline_prod = aquisitionhomepage.openPRE(inputValues.get("Site"));
//		aquisitionhomepage.fixPrivateConnection();
		
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		checkpopup();
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
			checkpopup();
			
			getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
			getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
			getLoginScenario().saveBean(VPPCommonConstants.IS_MULTICOUNTY, isMultiCounty);
			
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		if (isMultiCounty.equalsIgnoreCase("NO")) {
			planSelectorhomepage.quizStartAndRunQuestionnaire(zipcode);
		} else {
			planSelectorhomepage.quizStartAndRunQuestionnaireWithCounty(zipcode, county);
		}
	}
	
	@When("^user navigate to Plan Recommendation Engine and Checking Breadcrumbs$")
	public void user_navigate_PRE_Breadcrumbs() throws InterruptedException {
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorhomepage.landingpage();
	}
	
	@Then("^user validate elements on landing page of Plan Recommendation Engine$")
	public void user_check_landing_page_Plan_Selector_tool() throws InterruptedException {
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorhomepage.landingpage();
	}

	
	@When("^user navigate Plan Recommendation Engine Using Shop From Home in Find Your Plan$")
	public void navigate_Plan_Selector_tool() {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		headerAndFooter.navigationToPlanRecommendationEngineViaShopTools();
//		headerAndFooter.breadCrumbs();
}
	
	@When("^user navigate Plan Recommendation Engine Using Get Started From Medicare Articles$")
	public void navigate_PRE_tool_MedicareArticles() {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		headerAndFooter.navigationToPlanRecommendationEngineViaMedicareArticles();
}
	
	@When("^user navigate to Medicare Education and validate Plan Recommendation Engine Widget$")
	public void navigate_MedicareEducation() {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		headerAndFooter.navigationToPlanRecommendationEngineViaMedicareEducation();
}
	
	@Then("^user validate Header elements and Link Validation of Plan Recommendation Engine$")
	public void user_check_header_Plan_Selector_tool() {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		headerAndFooter.headerElements();
		headerAndFooter.headerLinkvalidation();
	}
	@Then("^user validate Footer elements and Link Validation of Plan Recommendation Engine$")
	public void user_check_header_footer_Plan_Selector_tool() throws Exception {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		headerAndFooter.footerElements();
		headerAndFooter.footerLinkvalidation();
	}
	@Then("^user validate Header and Footer Functionality of Plan Recommendation Engine$")
	public void user_check_header_footer_Actions_Plan_Selector_tool(DataTable givenAttributes) throws Throwable{
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String actualpageurl = wd.getCurrentUrl();
		readfeaturedata(givenAttributes);
		String zipcode = inputValues.get("Zip Code");
		System.out.println("Zipcode is:"+zipcode);
		String email = inputValues.get("EMail");
		System.out.println("Email is:"+email);
		String searchKey = inputValues.get("Search Key");
		System.out.println("Entered Search Key is:"+searchKey);
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		headerAndFooter.zipcodeFunctionInShopforaplan(zipcode);
		Thread.sleep(5000);
		headerAndFooter.emailFunctionInShopforaplan(email);
		Thread.sleep(5000);
		if(actualpageurl.contains("uhcmedicaresolutions")){
			headerAndFooter.enterSearchFunction(searchKey);
			Thread.sleep(5000);	
		}
	}
	
	@And("^clicks on get started button and check error scenarios$")
	public void clicks_on_get_started_button_and_check_error_scenarios(DataTable givenAttributes) throws Throwable {
		readfeaturedata(givenAttributes);
		String zipcode = inputValues.get("Zip Code");
		String county = inputValues.get("CountyDropDown");
		String isMultiCounty = inputValues.get("Is Multi County");
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
//		headerAndFooter.breadCrumbs();
		if (isMultiCounty.equalsIgnoreCase("NO")) {
			planSelectorhomepage.getStartedAndRunInvalidzipcode(zipcode);
		} else {
			planSelectorhomepage.getStartedAndRunzipcodeWithCounty(zipcode, county);
		}
			
	}
	
	@And("^user validate elements in coverage options page$")
	public void elements_coverage_page() {
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
//		headerAndFooter.breadCrumbs();
		planSelectorCoverageepage.coverageOptionpage();
		
	}
	
	@And("^user selects plan type in coverage options page$")
	public void select_plan_type_coverage_page(DataTable givenAttributes) throws Throwable {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String plantype = inputValues.get("Plan Type");
		if (!(plantype.isEmpty())) {
			planSelectorCoverageepage.coverageOptionpageFunctional(plantype);
		}
	}
	
	@And("^user not selects plan type in coverage options page$")
	public void notselect_plan_type_coverage_page(DataTable givenAttributes) throws Throwable {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String plantype = inputValues.get("Plan Type");
		if (plantype.isEmpty()) {
			planSelectorCoverageepage.coverageOptionpageerror();
		}
	}
	
	@And("^user select planType and continous the page back to previous page$")
	public void previous_coverage_page(DataTable givenAttributes) throws Throwable {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorCoverageepage.coverageOptionpageFunctional(inputValues.get("Plan Type"));
	}
	
	@And("^user select planType and Click previous button to check previous page$")
	public void previous_zipcode_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorCoverageepage.coverageOptionpagePreviousButton(inputValues.get("Plan Type"));
	}
	
	@Then("^user validate elements in Special Needs page$")
	public void elements_special_page() {
		PlanRecommendationEngineSpecialNeedsPage planSelectorSpecialneedspage =  new PlanRecommendationEngineSpecialNeedsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorSpecialneedspage.specialNeedspage();
	}
	
	@And("^user selects SNP options in Special Needs Page")
	public void select_special_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineSpecialNeedsPage planSelectorSpecialneedspage =  new PlanRecommendationEngineSpecialNeedsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String status = "Positive";
		planSelectorSpecialneedspage.specialneedspage(inputValues.get("SNP Options"),status);	
	}
	
	@And("^user validating error scenario in Special Needs Page")
	public void error_special_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineSpecialNeedsPage planSelectorSpecialneedspage =  new PlanRecommendationEngineSpecialNeedsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String status = "Negative";
		planSelectorSpecialneedspage.specialneedspage(inputValues.get("SNP Options"),status);	
	}
	
	@And("^user validate elements in doctors page$")
    public void elements_doctor_page() {
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
                    PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
//                    headerAndFooter.breadCrumbs();
                    planSelectorDoctorspage.doctorspageElements();
                    
    }
    
    @And("^user selects doctors in doctors page$")
    public void select_plan_type_doctor_page(DataTable givenAttributes) throws Throwable {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
                    String doctor = inputValues.get("Doctors");
                    String status = "Positive_NextPageName";
                    if (!(doctor.isEmpty())) {
                                    planSelectorDoctorspage.doctorspageFunctional(inputValues.get("Doctors"),inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"),status);
                    }
    }
    
    @And("^user not selects doctors in doctors page$")
    public void notselect_doctor_type_doctor_page(DataTable givenAttributes) throws Throwable {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
                    String doctor = inputValues.get("Doctors");
                    if (doctor.isEmpty()) {
                                    planSelectorDoctorspage.doctorspageerror();
                    }
    }
    
    @And("^user select doctors and continous the page back from Doctors to previous page$")
    public void previous_doctors_page(DataTable givenAttributes) throws Throwable {
                    readfeaturedata(givenAttributes);
                    String status = "Positive_NextPageName";
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
                    planSelectorDoctorspage.doctorspageFunctional(inputValues.get("Doctors"),inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"),status);
    }
    
    @And("^user select doctors and Click previous button from Doctors to check previous page$")
    public void previous_travel_page(DataTable givenAttributes) {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
                    planSelectorDoctorspage.doctorspagePreviousButton(inputValues.get("Doctors"));
    }
    
    @And("^user validating error scenario in doctors Page")
    public void error_doctor_page(DataTable givenAttributes) {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
                    planSelectorDoctorspage.doctorspageerror();             
    }
    
    @And("^user selects Doctors in Doctors page and cancels the selection$")
	public void select_doctors_page_cancelvalidation(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorDoctorspage.doctorspageCancel(inputValues.get("Doctors Search Text"), inputValues.get("Multi Doctor"));
	}
    
    @And("^user validate elements in drugs page$")
    public void elements_drugs_page() {
    				PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
                    PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
//                    headerAndFooter.breadCrumbs();
                    planSelectorDrugspage.drugspage();
                    
    }
    
       @And("^user selects skip option in Drug page$")
    public void select_prescription_drug_page(DataTable givenAttributes) throws Throwable {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
                    String drug = inputValues.get("Drug Selection");
                    	planSelectorDrugspage.skipDrugs(drug);
                    	
    }
       
       @Then("^user selects add drug option in Drug page$")
   	public void add_drugs_page(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
   		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
   		planSelectorDrugspage.drugsHandlerWithdetails(inputValues.get("Drug Details"));
   		planSelectorDrugspage.continueNextpage();
   	}
       
       @Then("^user selects add drug option in Drug page without continue next page$")
      	public void add_drugs_page_WithoutContinue(DataTable givenAttributes) {
      		readfeaturedata(givenAttributes);
      		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
      		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
      		planSelectorDrugspage.drugsHandlerWithdetails(inputValues.get("Drug Details"));
      		planSelectorDrugspage.drugnamesList();
      	}
       
       @Then("^user selects add drug option and cancels the modals in Drug page$")
   	public void add_drugs_page_cancelvalidation(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
   		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
   		planSelectorDrugspage.drugspageCancel(inputValues.get("Drug Details"));
   	}
       
       @Then("^user validates errors in Drug page$")
   	public void add_drugs_page_errorvalidation(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
   		planSelectorDrugspage.drugpagesError(inputValues.get("Drug Details"));
   	}
       
       @Then("^user search and choose a drug in Drug page$")
   	public void choose_drugs_page(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
   		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
   		planSelectorDrugspage.drugChoose(inputValues.get("Search Text"),inputValues.get("Drug Details"));
   		planSelectorDrugspage.continueNextpage();
   	}
       
       @Then("^user selects add drug option without drugs in Drug page$")
   	public void add_NoDrug_drugs_page(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
   		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
   		planSelectorDrugspage.continueNextpageZeroDrug();
   	}
       
       @Then("^user selects add drug option and comparing DCE and Drug page$")
      	public void verify_drugs_dce_drug_page(DataTable givenAttributes) {
      		readfeaturedata(givenAttributes);
      		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
      		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
      		planSelectorDrugspage.comparingDrugwithDCE();
      	}
      	
      	@Then("^user verify drug list are same in DCE VS Drug page$")
      	public void verify_drugs_dce_vs_drug_page(DataTable givenAttributes) {
      		readfeaturedata(givenAttributes);
      		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
      		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
      		planSelectorDrugspage.comparingDrugsDCEvsPRE();
      	}
       
       @Then("^user selects add drug option and verifying the drugs in Drug page$")
     	public void verify_drugs_page(DataTable givenAttributes) {
     		readfeaturedata(givenAttributes);
     		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
     		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
     		planSelectorDrugspage.comparingDrugsStartOver();
     	}
    
       @And("^user not selects prescription options in drug page$")
    public void notselect_prescription_opt_drug_page(DataTable givenAttributes) throws Throwable {
                    readfeaturedata(givenAttributes);
                    PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
                    String drug = inputValues.get("Drug Selection");
                    if (drug.isEmpty()) {
                    	planSelectorDrugspage.drugspageerror();
                    }
    }
       
       @Then("^user search and not found a drug in Drug Page$")
   	public void notfound_drugs_page(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
   		planSelectorDrugspage.drugsInitiate(inputValues.get("Drug Selection"));
   		planSelectorDrugspage.drugNotFound(inputValues.get("Search Text"));
   	}
       
   	@Then("^user validate elements in additional services page$")
   	public void elements_additional_page(DataTable givenAttributes) {
   		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineAdditionalServicesPage planSelectorAdditionalpage =  new PlanRecommendationEngineAdditionalServicesPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
   		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
//   		headerAndFooter.breadCrumbs();
   		planSelectorAdditionalpage.additionalpage(inputValues.get("Drug Selection"));
   	}
   	
	@Then("^user selects additional services option in additional services page$")
   	public void select_additionalServiceOption_additional_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineAdditionalServicesPage planSelectorAdditionalpage =  new PlanRecommendationEngineAdditionalServicesPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
   		planSelectorAdditionalpage.additionalpageFunctional(inputValues.get("Additional Option"));
   	}
	
	@Then("^user validates additional services error function in additional services page$")
   	public void noselect_additionalServiceOption_additional_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
   		PlanRecommendationEngineAdditionalServicesPage planSelectorAdditionalpage =  new PlanRecommendationEngineAdditionalServicesPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
   		planSelectorAdditionalpage.additionalpageerror(inputValues.get("Additional Option"));
   	}

	@Then("^user validate elements in cost preferences page$")
   	public void elements_costpreferences_page() {
		PlanRecommendationEngineCostPreferencesPage planSelectorPreferencespage =  new PlanRecommendationEngineCostPreferencesPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
//   		headerAndFooter.breadCrumbs();
   		planSelectorPreferencespage.costpreferencepage();
   	}
	
	@Then("^user selects cost preferences option in cost preferences page$")
   	public void select_costPreferenceOption_costpreferences_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCostPreferencesPage planSelectorPreferencespage =  new PlanRecommendationEngineCostPreferencesPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
   		planSelectorPreferencespage.costPreferencepageFunctional(inputValues.get("Preference Option"));
   	}
	
	@Then("^user validates cost preferences error function in cost preferences page$")
	public void noselect_costPreferenceOption_costpreferences_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCostPreferencesPage planSelectorPreferencespage = new PlanRecommendationEngineCostPreferencesPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String preference = inputValues.get("Preference Option");
		if (preference.isEmpty()) {
			planSelectorPreferencespage.costPreferencepageerror();
		}
	}
	
	@Then("^user validate elements in loading results page$")
   	public void elements_results_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
//   		headerAndFooter.breadCrumbs();
   		planSelectorResultspage.resultsloadingpage();
   	}
	
	@Then("^user validate recommendations in results page$")
   	public void view_recommendations_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		checkpopup();
		planSelectorResultspage.resultsUI(zip,county,r1,r2,false);
   	}
	
	@Then("^user validate tie recommendations in results page$")
   	public void view_tie_recommendations_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String r1 = inputValues.get("1st Recommendation");
		String r2 = inputValues.get("2nd Recommendation");
		checkpopup();
		planSelectorResultspage.resultsUI(zip,county,r1,r2,true);
   	}
	
	@Then("^user validate drugs details from PRE to VPP page$")
	public void view_drugs_PRE_VPP_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.drugsDetailsPREtoVPP();
	}
	
	@Then("^user validate removed drugs details updated from VPP to PRE page$")
	public void view_removed_drugs_VPP_PRE_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.removedDrugsDetailsVPPtoPRE();
	}
	
	@Then("^user navigate to PRE using StartNow button and verify drugs details in PRE page$")
	public void startnow_PRE_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.startnowtilldrugs();
	}
	
	@Then("^user proceed page navigation till VPP page after Start Now button$")
	public void view_VPP_StartNow_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.startNowFullFlow(inputValues.get("Plan Type"));
	}
	
	@Then("^user validate drugs details from DCE to PRE page$")
	public void drugs_DCE_VPP_PRE_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.DrugsDetailsVPPtoPRE();
	}
	
	@Then("^user validate drugs details from VPP to DCE page$")
	public void drugs_VPP_DCE_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.DrugsDetailsVPPtoDCE(inputValues.get("Drugs Name"));
	}
	
	@And("^user navigates to vpp summary page$")
   	public void navigate_vpp_summary_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String zip = inputValues.get("Zip Code");
		planSelectorResultspage.navigateVPP(inputValues);
		checkpopup();
   	}
	
	@Then("^user adds Doctors in vpp summary page$")
   	public void add_providers_vpp_summary_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		planSelectorResultspage.addProviderVPP(inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"));
//		planSelectorResultspage.vppToPre();
   	}
	
	@Then("^user navigate to PRE from vpp page$")
   	public void PRE_VPP_page() {
		checkpopup();
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.vppToPre();
   	}
	
	@Then("^user clicks on GetStarted button in PRE page$")
   	public void PRE_GetStarted() {
		checkpopup();
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorhomepage.navigatezipcodepage();
   	}
	
	@Then("^user navigate Doctors lookup session in Doctors page$")
	public void navigate_doctors_lookup_session() {
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorDoctorspage.navigateDoctorsmodalsession();
	}
	
	@And("^user verifies doctors session in Doctors page$")
   	public void verify_doctors_session_doctors_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String multiDoctor = inputValues.get("Multi Doctor");
		planSelectorResultspage.getProvidersPRE(multiDoctor);
		planSelectorResultspage.verifyProvidersSession(multiDoctor);
   	}
	
	@And("^user verifies doctors and continue to next page$")
   	public void verify_doctors_continue_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String multiDoctor = inputValues.get("Multi Doctor");
		planSelectorDoctorspage.getcontinue(multiDoctor);
   	}
	
	
	@When("^user navigates to Zip Code page from vpp plans$")
	public void user_navigates_to_zipcode_page_fromvpp_pdp() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		planSelectorResultspage.DCEtoPRE();
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorhomepage.navigatezipcodepage();
	}
	
	@And("^user validte zip info in location page$")
	public void user_validates_zipcodepage(DataTable inputdata) {
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		readfeaturedata(inputdata);
		planSelectorhomepage.zipcodeInfoValidation(inputValues);
	}
	
	@And("^user verifies Start Over doctors session in Doctors page$")
   	public void verify_StartOver_doctors_session_doctors_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String multiDoctor = inputValues.get("Multi Doctor");
		planSelectorResultspage.getProvidersPRE(multiDoctor);
		planSelectorResultspage.verifyDoctorsSession(multiDoctor);
   	}
	
	@Then("^user adds Providers in Doctors page$")
	public void add_doctors_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorDoctorspage.addProvidersPRE(inputValues.get("Doctors Search Text"),inputValues.get("Multi Doctor"));
	}
	
	@And("^user verifies doctors session in VPP page$")
   	public void verify_doctors_session_vpp_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.verifyProviderPREVPP();
   	}
	
	@Then("^user edits Doctors in Doctors page$")
	public void edit_doctors_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorDoctorspage.editProvider(inputValues.get("Doctors Search Text1"), inputValues.get("Multi Doctor1"),
				inputValues.get("Doctors Search Text2"), inputValues.get("Multi Doctor2"));
	}
	
	@Then("^user navigates to VPP Summary Page$")
   	public void startNow_vpp_summary_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String isMultiCounty = inputValues.get("Is Multi County");
		planSelectorResultspage.countyandViewPlan(zip,county,isMultiCounty);
   	}
	
	@Then("^user validate zipcode and County in location page using StartNow$")
   	public void zipcode_location_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String isMultiCounty = inputValues.get("Is Multi County");
		checkpopup();
		planSelectorResultspage.vppToPre();
		planSelectorResultspage.validateZipcodePage(zip,county,isMultiCounty);
   	}
	
	@Then("^user navigate to PRE and validate zipcode using Start Over$")
   	public void zipcode_Doc_Drug_pre(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String zip = inputValues.get("Zip Code");
		String county = inputValues.get("County Name");
		String isMultiCounty = inputValues.get("Is Multi County");
		checkpopup();
		planSelectorResultspage.vppToPreStartOver();
		planSelectorResultspage.validateZipcodePage(zip,county,isMultiCounty);
   	}
	
	@Then("^user validate recommendation rankings in results page$")
   	public void verify_rankings_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String recom = inputValues.get("Recommendation");
		String plansorder = inputValues.get("Ranking plans Order");
		planSelectorResultspage.validateRankingPlans(recom,plansorder);
   	}
	
	@Then("^verify continue function on \"([^\"]*)\" page$")
    public void proceed_next_page(String page) {
     PlanRecommendationEngineCommonutility commonutli =  new PlanRecommendationEngineCommonutility((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
     commonutli.continueNextpage(page.trim().toUpperCase(),false);
    }
	
	@And("^user verifies existing PRE provider session using startnow$")
   	public void verify_exisitng_pre_doctors_session_doctors_startnow_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		String multiDoctor = inputValues.get("Multi Doctor");
		planSelectorDoctorspage.verifyExisitngPREDoclist(multiDoctor);
		planSelectorDoctorspage.nextPageNameValidationDoctor();
   	}
	
	@And("^user verifies exisitng PRE drug session using startnow$")
   	public void verify_exisitng_pre_drugs_session_drug_startnow_page() {
		PlanRecommendationEngineDrugsPage planSelectorDrugspage =  new PlanRecommendationEngineDrugsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorDrugspage.verifyExisitngPREDruglist();
		planSelectorDrugspage.continueNextpageNameDrug();
   	}
	
	@When("^user validate email plan list from vpp$")
	public void user_sendPlanEmail_fromvpp_pdp(DataTable givenAttributes) {
		checkpopup();
		readfeaturedata(givenAttributes);
		String recom = inputValues.get("Recommendation");
		String email = inputValues.get("EmailID");
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.sendEmail(recom,email);
	}
	
	@Then("^user selects Doctors in Doctors page and validate next page name$")
	public void select_doctors_next_page_name() {
		PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorDoctorspage.navigateDoctorsmodalsession();
	}
	
	@Then("^user validate UI and API recommendation rankings in results page$")
   	public void verify_UI_API_rankings_results_page() throws JSONException {
		checkpopup();
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.validateUIAPIRankingPlans();
   	}
	
	@Then("^user verifies \"([^\"]*)\" page$")
	public void verify_vpp_summary_page_mobile(String VPP) {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		if (VPP.toUpperCase().contains("PRE"))
			planSelectorResultspage.checkVPP(true);
		else
			planSelectorResultspage.checkVPP(false);
	}
	
	@Then("^user validate MA Plan Names in VPP Summary VS Details in results page$")
   	public void verify_MA_Plan_names_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.viewPlanInfo(inputValues.get("planInfo"));
		planSelectorNewResultspage.browserBack();
	}
	
	@Then("^user validate PDP Plan Names in VPP Summary VS Details in results page$")
   	public void verify_PDP_Plan_names_results_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		planSelectorResultspage.validatePDPPlanNamesSummaryAndDetails();
	}
	
	@Then("^user validate SNP Plan Names in VPP Summary VS Details in results page$")
   	public void verify_SNP_Plan_names_results_page() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		planSelectorResultspage.validateSNPPlanNamesSummaryAndDetails();
	}
	
	@Then("^user validate SNP Plan in Enroll page$")
   	public void verify_SNP_Plan_names(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		checkpopup();
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.viewPlanInfo(inputValues.get("planInfo"));
		planSelectorResultspage.validateSNPPlanName();
	}
	
	@Then("^user adds Drugs in vpp summary page$")
   	public void add_drugs_vpp_summary_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		planSelectorResultspage.useraddDrugsVPP(inputValues.get("Drug Details"));
   	}
	
	@Then("^user navigate from VPP to DCE tool$")
   	public void vpp_pre() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		planSelectorResultspage.userPreDCE();
   	}
	
	@Then("^user validate future vs current UI and API recommendation rankings in results page$")
   	public void verify_Future_UI_API_rankings_results_page() throws JSONException {
		checkpopup();
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.checkPlanyear("future");
		planSelectorResultspage.validateUIAPIRecommendations();
		planSelectorResultspage.validateUIAPIRankingPlans();
		planSelectorResultspage.changePlanyear("current");
		// Toggling back and validating as future year only have values stored in storage
		planSelectorResultspage.changePlanyear("future");
		planSelectorResultspage.validateUIAPIRecommendations();
		planSelectorResultspage.validateUIAPIRankingPlans();
   	}
	
	public void checkpopup() {
		if(if_offline_prod && !popup_clicked) {
			PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
			popup_clicked = planSelectorhomepage.close_Popup();
		}
	}
	
	@Then("^user validate saved values in edit response page$")
   	public void check_saved_value_editResponse_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.editResponsepage(inputValues);
   	}
	
	@Then("^user return to vpp page using \"([^\"]*)\" from edit response page$")
   	public void check_saved_value_editResponse_page(String button) {
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.returnVPP(button);
   	}
	
	@Then("^user edits values in edit response page$")
   	public void edit_saved_value_editResponse_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		preEditpage.editUserResponse(inputValues);
   	}
	
	@Then("^user adds doctor in edit response page$")
   	public void add_doctor_editResponse_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.addDoctorEditResponse(inputValues);
   	}
	
	@Then("^user navigates to edit response page$")
   	public void navigate_editResponse_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.navigateEditResponsePage(inputValues.get("Plan Type"));
   	}

	@Then("^user edits coverage value in edit response page$")
   	public void edit_coverage_editResponse_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.changeCoverage(inputValues);
   	}
	
	@Then("^user validates coverage value in edit response page$")
   	public void validate_coverage_editResponse_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.checkCoveragevalue(inputValues);
   	}
	
	@Then("^user adds SNP options and Location in edit response page$")
   	public void add_snp_editResponse_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.addSNPEditResponse(inputValues);
		preEditpage.addLocationEditResponse(inputValues);
   	}
	
	@Then("^user selects add drug option in drug page from edit response page$")
   	public void add_drug_editResponse_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.addDrugs(inputValues);
   	}
	
	@Then("^user save plans in vpp summary and Validate in Visitor profile page$")
	public void user_verify_saveplan(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.changePlanyear(inputValues.get("Plan Year"));
		planSelectorResultspage.validateSavePlan(inputValues.get("Plan Info"),inputValues.get("Plan Year"));
	}
	
	@Then("^user save 2 MA plans in vpp summary and Validate in Visitor profile page$")
	public void user_saveplan(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.changePlanyear(inputValues.get("Plan Year"));
		planSelectorResultspage.validateSavePlan(inputValues.get("Plan Info"),inputValues.get("Plan Year"));
	}
	
	@Then("^user Validate Drug and Provider details in Visitor profile page$")
	public void user_verify_drug_provider() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.validateDrugProvider();
	}
	
	@Given("^the user is on external acquisition site landing page$")
	public void the_user_on_external_Site(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd,"PRE");
		if_offline_prod = aquisitionhomepage.openExternalLinkPRE(inputValues.get("Site Name"));
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		checkpopup();
	}
	
	@When("^user navigate to Plan Recommendation Engine Tool$")
	public void the_user_external_PRE(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		planSelectorResultspage.navigatePRE(inputValues);
	}
	
	@Then("^user selects priority in priorities page$")
	public void user_selects_priorities(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEnginePrioritiesPage priorities =  new PlanRecommendationEnginePrioritiesPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		priorities.prioritiesFunctional(inputValues.get("Priority Option"),inputValues.get("Priorities"));
		priorities.continuePriority();
	}

	@Then("^user validate elements in priorities page$")
	public void user_validate_prioritiesElements() {
		PlanRecommendationEnginePrioritiesPage priorities =  new PlanRecommendationEnginePrioritiesPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		priorities.prioritiesElements();
	}
	
	@Then("^user validate PDP Plan Names in VPP Details and Click Enroll button in Plan Details page$")
   	public void verify_Plan_names_Enroll_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.viewPlanInfo(inputValues.get("planInfo"));
		planSelectorResultspage.validatePDPPlanNamesAndEnroll();
	}
	
	@When("^user navigate to Drug Cost Estimator page$")
	public void navigate_DCE() {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		headerAndFooter.navigationToDrugCostEstimatorViaShopTools();
	}
	
	@And("^user validate druglist in Drug Cost Estimator page$")
	public void Druglist_DCE() {
		ACQDrugCostEstimatorPage dceDrugs =  new ACQDrugCostEstimatorPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		dceDrugs.getDruglist();
	}
	
	@Then("^user adds Drugs in Drug Cost Estimator page$")
   	public void add_drugs_DCE_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		dce.useraddDrugsDCEWithoutVPP(inputValues.get("Drug Details"));
   	}
	
	@Then("^user validate navigate to Get a Plan Recomendation page$")
	public void navigate_PRE() {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		headerAndFooter.navigationToPlanRecommendationEngine();
	}
	
	@Then("^user save recommendation results and validate in VP$")
   	public void save_results() {
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		preEditpage.validateSaveResults();
	}
	
	@Then("^user navigate to visitor profile and open PRE Widget$")
    public void pre_Widget_open(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.ValidatePREWidget(inputValues.get("User Type"),inputValues.get("Plan Type"), inputValues.get("User Name"),inputValues.get("Password"));
		planSelectorResultspage.ValidatePREWithoutMSPlan(inputValues.get("User Type"));
    }
	
	@And("^user Click on Getstarted in PRE Home Page and Continue till Covergae page$")
    public void I_click_questionnaire_first() {
        PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
        planSelectorhomepage.getStartedContinueZipcode();
    }
	
	@Then("^user select plans in VPP Summary and navigate to Plan Compare page$")
   	public void verify_Plans_compare_page() {
		checkpopup();
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.validateMAPlanNamesPlanCompare();
	}
	
	@And("^user validate buttons in SaveResult Model and PRE Widget in VP$")
	public void btn_SaveResult_Widget(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.navigateSaveResultsPage();
		preEditpage.PRESaveResultModelBtn();
		preEditpage.ValidatePREWidget(inputValues.get("User Type"),inputValues.get("Plan Type"), inputValues.get("User Name"),inputValues.get("Password"));
	}
	
	@Then("^user creates a \"([^\"]*)\" tab from PRE$")
   	public void create_tab(String tabtype) {
		PlanRecommendationEngineCommonutility commonutli =  new PlanRecommendationEngineCommonutility((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
//		commonutli.creatingTab(tabtype.toUpperCase());
   	}
	
	@Then("^user validate recommendation section in PRE Widget on VP$")
    public void pre_Widget_recom() {
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		preEditpage.recomPREWidget();
    }
	
	@Then("^user validate a \"([^\"]*)\" buttons from PRE$")
   	public void btn_tab(String tabtype) {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
			planSelectorResultspage.validateLinks(tabtype);
   	}
	
	@Then("^user navigate to visitor profile with saving MS plan$")
    public void Guest_Profile_MSPlan(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorResultspage.SavingMsplan();
		preEditpage.shoppingcartNavigation(inputValues.get("User Type"),inputValues.get("Plan Type"), inputValues.get("User Name"),inputValues.get("Password"));
		planSelectorResultspage.ValidatePREWithMSPlan();
    }
	
	@When("^user Sigin visitor profile from PRE$")
	public void sign_vp(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.SignIn(inputValues.get("User Name"),inputValues.get("Password"));
	}
	
	@Then("^user do browser back from current page$")
   	public void browser_back() {
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
			planSelectorResultspage.browserBack();
   	}
	
	/////////////////////////////////////////////////////// New Results Page //////////////////////////////
	
	@Then("^user validate elements in PRE results page$")
   	public void elements_new_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		checkpopup();
		planSelectorNewResultspage.preResultsUI(inputValues.get("Zip Code"),inputValues.get("CountyDropDown"));
   	}
	
	@Then("^user validate pagination in PRE results page$")
   	public void pagination_new_results_page() {
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		//checkpopup();
		planSelectorNewResultspage.validatePagination();
		//planSelectorNewResultspage.findPlan();
   	}
	
	@Then("^user validate drugDetails in PRE results page$")
   	public void drugDetails_new_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		//checkpopup();
		planSelectorNewResultspage.validateDrugInfo(inputValues.get("DrugInfo"),"tile");
   	}
	
	@Then("^user validate doctors info in PRE results page$")
   	public void doctorDetails_new_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		//checkpopup();
		planSelectorNewResultspage.validateDoctorInfo(inputValues.get("DoctorsInfo"),"tile");
   	}
	
	@And("^user selects empty doctors in doctors page$")
    public void zeroDoctor_doctor_page(DataTable givenAttributes) throws Throwable {
        readfeaturedata(givenAttributes);
        PlanRecommendationEngineDoctorsPage planSelectorDoctorspage =  new PlanRecommendationEngineDoctorsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
        planSelectorDoctorspage.addZeroProviders(inputValues.get("Doctors Search Text"));
     }
	
	@Then("^user validate snp info in PRE results page$")
   	public void snpDetails_new_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.validateSNPInfo(inputValues.get("SNPInfo"));
   	}
	
	@Then("^user views plan details from results page$")
   	public void viewDetails_new_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.viewPlanInfo(inputValues.get("planInfo"));
   	}
	
	@Then("^user views learn more from results page$")
   	public void learnMore_new_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.learnMore(inputValues.get("Learn More"));
   	}

	@Then("^user validate drugCostModal in PRE results page$")
   	public void drugDetailsModel_new_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.validateDrugInfo(inputValues.get("DrugInfo"),"model");
   	}
	
	@Then("^user validate showmoreDrug in PRE results page$")
   	public void drugShowMore_new_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.validateDrugInfo(inputValues.get("DrugInfo"),"show");
   	}
	
	@Then("^user validate showmoreDoctor in PRE results page$")
   	public void doctorShowMore_new_results_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.validateDoctorInfo(inputValues.get("DoctorsInfo"),"show");
   	}
	
	@Then("^user navigate to visitor profile without saving MS plan$")
    public void Guest_Profile_NoMSPlan(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineResultsPage planSelectorResultspage =  new PlanRecommendationEngineResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		PlanRecommendationEngineEditResponsePage preEditpage =  new PlanRecommendationEngineEditResponsePage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		preEditpage.ValidatePREWidget(inputValues.get("User Type"),inputValues.get("Plan Type"), inputValues.get("User Name"),inputValues.get("Password"));
		planSelectorResultspage.ValidatePREWithoutMSPlan(inputValues.get("User Type"));
    }
	
	@Then("^the user do poc$")
   	public void poc_new_results_page() {
		PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		planSelectorNewResultspage.poc();
   	}

	
}
