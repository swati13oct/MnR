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
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineCoverageOptionPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineHeaderAndFooter;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineLandingAndZipcodePages;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineSpecialNeedsPage;
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
	
	public void readfeaturedata(DataTable data) {
		inputRow = new ArrayList(data.getGherkinRows());
		inputValues = new HashMap<String, String>();
		for (int i = 0; i < inputRow.size(); i++) {
			inputValues.put(inputRow.get(i).getCells().get(0),
			inputRow.get(i).getCells().get(1));
		}
	}
	
	@Given("^the user is on UHC medicare acquisition site landing page$")
	public void the_user_on_uhc_medicaresolutions_Site() {
		wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

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
	
	@When("^user validate elements on landing page of Plan Recommendation Engine$")
	public void user_check_landing_page_Plan_Selector_tool() {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
		PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages(wd);
		headerAndFooter.navigationToPlanRecommendationEngine();
		headerAndFooter.breadCrumbs();
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
	
	@Then("^user validate Header and Footer elements of Plan Recommendation Engine$")
	public void user_check_header_footer_Plan_Selector_tool() {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
		headerAndFooter.headerElements();
		headerAndFooter.footerElements();
}
	@And("^user validate Header and Footer Functionality of Plan Recommendation Engine$")
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
	
	@Then("^user validates all Links from header and footer desktop$")
	public void user_check_header_Footer_link_validation_mobile() {
		PlanRecommendationEngineHeaderAndFooter headerAndFooter =  new PlanRecommendationEngineHeaderAndFooter(wd);
		headerAndFooter.headerLinkvalidation();
		headerAndFooter.footerLinkvalidation();
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
		}else {
			planSelectorCoverageepage.coverageOptionpageerror();
		}
	}
	
	@And("^user select planType and continous the page back to previous page$")
	public void previous_coverage_page(DataTable givenAttributes) throws Throwable {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage(wd);
		planSelectorCoverageepage.coverageOptionpageFunctional(inputValues.get("Plan Type"));
//		planSelectorCoverageepage.browserBack();
//		planSelectorCoverageepage.previouspageValidation();
	}
	
	@And("^user select planType and Click previous button to check previous page$")
	public void previous_zipcode_page(DataTable givenAttributes) {
		readfeaturedata(givenAttributes);
		PlanRecommendationEngineCoverageOptionPage planSelectorCoverageepage =  new PlanRecommendationEngineCoverageOptionPage(wd);
		planSelectorCoverageepage.coverageOptionpagePreviousButton(inputValues.get("Plan Type"));
		planSelectorCoverageepage.previouspageValidation();
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
		planSelectorSpecialneedspage.specialneedspage(inputValues.get("SNP Options"),inputValues.get("Status"));	
	}
	
	

}
