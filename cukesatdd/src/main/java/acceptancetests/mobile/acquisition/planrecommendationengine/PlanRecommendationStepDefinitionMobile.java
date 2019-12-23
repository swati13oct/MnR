package acceptancetests.mobile.acquisition.planrecommendationengine;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.PlanSelectorNewPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import pages.acquisition.bluelayer.PlanSelectorPage;
import pages.mobile.acquisition.bluelayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.planrecommendationengine.CoverageOptionsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.HeaderFooterMobile;
import pages.mobile.acquisition.planrecommendationengine.LandingAndZipcodeMobilePage;
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

public class PlanRecommendationStepDefinitionMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	AppiumDriver wd;
	List<DataTableRow> inputRow;
	HashMap<String, String> inputValues;
	
	@Given("^the user is on UHC medicare acquisition site mobile$")
	public void the_user_on_uhc_medicaresolutions_site_mobile() {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,aquisitionhomepage);
	}
	
	@When("^user navigates to PRE landing page mobile$")
	public void user_navigates_PRE_landingpage_mobile(){
	HeaderFooterMobile preheaderfootermobile =  new HeaderFooterMobile(wd);
	preheaderfootermobile.navigatePRELandingpageMobile();
}
	
	@When("^user navigates to PRE landing page via shop tool mobile$")
	public void user_navigates_PRE_landingpage_shoptool_mobile(){
		HeaderFooterMobile preheaderfootermobile =  new HeaderFooterMobile(wd);
		preheaderfootermobile.navigationToPREViaShopToolsMobile();
}
	
	@When("^user navigates to Zip Code page mobile$")
	public void user_navigates_to_zipcode_page_mobile(){
		LandingAndZipcodeMobilePage prelandingpage =  new LandingAndZipcodeMobilePage(wd);
		prelandingpage.navigatezipcodepagemobile();
}
	
	@When("^user navigates to \"([^\\\"]*)\" page mobile$")
	public void user_navigates_to_given_page_mobile(String pageName,DataTable inputdata){
		//LandingAndZipcodeMobilePage prelandingpage =  new LandingAndZipcodeMobilePage(wd);
		//prelandingpage.navigatepagemobile(pageName);
}
	
	@Then("^user validate elements on landing page of Plan Recommendation Engine mobile$")
	public void user_check_landing_page_Plan_Selector_tool_mobile() {
		//System.out.println("Device Type "+inputValues.get("Device Type"));
		LandingAndZipcodeMobilePage prelandingpagemobile =  new LandingAndZipcodeMobilePage(wd);
		prelandingpagemobile.landingpageElementsmobile();
}
	
	@Then("^user validate presence of Header elements on landing page mobile$")
	public void user_check_header_mobile() {
		HeaderFooterMobile preheaderfootermobile =  new HeaderFooterMobile(wd);
		preheaderfootermobile.headerElementsMobile();
}
	
	@Then("^user validate presence of Footer elements on landing page mobile$")
	public void user_check_Footer_mobile() {
		HeaderFooterMobile preheaderfootermobile =  new HeaderFooterMobile(wd);
		preheaderfootermobile.footerElementsMobile();
}
	
	@Then("^user validate Header Functionality of Plan Recommendation Engine mobile$")
	public void user_check_header_functionalities_mobile(DataTable inputdata) {
		readfeaturedata(inputdata);
		HeaderFooterMobile preheaderfootermobile =  new HeaderFooterMobile(wd);
		preheaderfootermobile.zipcodeFunctionInShopforaplanHeaderMobile(inputValues.get("Zip Code"));
		preheaderfootermobile.emailFunctionInShopforaplanMobile(inputValues.get("EMail"));
		preheaderfootermobile.enterSearchFunctionHeaderMobile(inputValues.get("Search Key"));
	}
	
	@Then("^user validate Footer Functionality of Plan Recommendation Engine mobile$")
	public void user_check_Footer_functionalities_mobile() {
		HeaderFooterMobile preheaderfootermobile =  new HeaderFooterMobile(wd);
		preheaderfootermobile.backtoTopFunctionMobile();
	}
	
	@Then("^user validates all Links from header mobile$")
	public void user_check_header_link_validation_mobile() {
		HeaderFooterMobile preheaderfootermobile =  new HeaderFooterMobile(wd);
		preheaderfootermobile.headerLinkvalidationMobile();
	}
	
	@Then("^user validates all Links from footer mobile$")
	public void user_check_Footer_link_validation_mobile() {
		HeaderFooterMobile preheaderfootermobile =  new HeaderFooterMobile(wd);
		preheaderfootermobile.footerLinkvalidationMobile();
	}
	
	@Then("^user validates zipcode page elements mobile$")
	public void user_check_zipcodepage_elements_mobile() {
		LandingAndZipcodeMobilePage prezipcodemobile =  new LandingAndZipcodeMobilePage(wd);
		prezipcodemobile.zipcodepageElementsmobile();
	}
	
	@And("^runs questionnaire at zipcode page mobile$")
	public void user_runs_questionnaire_zipcodepage_mobile(DataTable inputdata) {
		LandingAndZipcodeMobilePage prezipcodemobile =  new LandingAndZipcodeMobilePage(wd);
		readfeaturedata(inputdata);
		prezipcodemobile.zipcodepageValidationmobile(inputValues);
	}
	
	@Then("^runs questionnaire at zipcode page with invalid data mobile$")
	public void user_runs_questionnaire_zipcodepage_invalid_data_mobile(DataTable inputdata) {
		LandingAndZipcodeMobilePage prezipcodemobile =  new LandingAndZipcodeMobilePage(wd);
		readfeaturedata(inputdata);
		prezipcodemobile.zipcodescreenErrorValidationmobile(inputValues);
	}
	
	@Then("^user validate elements in coverage options page mobile$")
	public void user_check_coveragepage_elements_mobile() {
		CoverageOptionsMobilePage coveragepage =  new CoverageOptionsMobilePage(wd);
		coveragepage.coverageOptionpageElementsMobile();
	}
	
	@Then("^user selects plan type in coverage options page mobile$")
	public void select_plan_type_coverage_page_mobile(DataTable inputdata) throws Throwable {
		readfeaturedata(inputdata);
		CoverageOptionsMobilePage coveragepage =  new CoverageOptionsMobilePage(wd);
		String plantype = inputValues.get("Plan Type");
		if (!(plantype.isEmpty())) {
			coveragepage.coverageOptionpageFunctionalMobile(plantype,true);
		}else {
			coveragepage.coverageOptionpageErrormobile();
		}
	}
	
	@And("^user select planType and continous the page back to previous page mobile$")
	public void previous_coverage_page_mobile(DataTable inputdata) throws Throwable {
		readfeaturedata(inputdata);
		CoverageOptionsMobilePage coveragepage =  new CoverageOptionsMobilePage(wd);
		coveragepage.coverageOptionpageFunctionalMobile(inputValues.get("Plan Type"),false);
		coveragepage.previouspageValidation();
	}
	
	public void readfeaturedata(DataTable data) {
		inputRow = new ArrayList(data.getGherkinRows());
		inputValues = new HashMap<String, String>();
		for (int i = 0; i < inputRow.size(); i++) {
			inputValues.put(inputRow.get(i).getCells().get(0),
			inputRow.get(i).getCells().get(1));
		}
	}
	
}
