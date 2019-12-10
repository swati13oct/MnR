package acceptancetests.mobile.acquisition.planselectorengine;

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
import pages.mobile.acquisition.planrecommendationengine.HeaderFooterMobile;
import pages.mobile.acquisition.planrecommendationengine.LandingAndZipcodeMobilePages;
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

public class PlanSelectorStepDefinitionMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	AppiumDriver wd;
	List<DataTableRow> inputRow;
	Map<String, String> inputValues;
	
	@Given("^the user is on UHC medicare acquisition site mobile$")
	public void the_user_on_uhc_medicaresolutions_site_mobile(DataTable inputdata) {
		inputRow = new ArrayList(inputdata.getGherkinRows());
		inputValues = new HashMap<String, String>();
		for (int i = 0; i < inputRow.size(); i++) {
			inputValues.put(inputRow.get(i).getCells().get(0),
			inputRow.get(i).getCells().get(1));
		}

		System.out.println("Given device : "+inputValues.get("Device Name"));
		wd = getLoginScenario().getMobileDriver(inputValues.get("Device Name"));
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,aquisitionhomepage);
	}
	
	@When("^user navigates to PRE landing page mobile$")
	public void user_navigates_PRE_landingpage_mobile(){
	HeaderFooterMobile planSelectorheaderfootermobile =  new HeaderFooterMobile(wd);
	planSelectorheaderfootermobile.navigatePRELandingpageMobile();
}
	
	@When("^user navigates to PRE landing page via shop tool mobile$")
	public void user_navigates_PRE_landingpage_shoptool_mobile(){
		HeaderFooterMobile planSelectorheaderfootermobile =  new HeaderFooterMobile(wd);
	planSelectorheaderfootermobile.navigationToPREViaShopToolsMobile();
}
	
	@Then("^user validate elements on landing page of Plan Recommendation Engine mobile$")
	public void user_check_landing_page_Plan_Selector_tool_mobile() {
		//System.out.println("Device Type "+inputValues.get("Device Type"));
		LandingAndZipcodeMobilePages planSelectorhomepagemobile =  new LandingAndZipcodeMobilePages(wd);
		planSelectorhomepagemobile.landingpagemobile();
}
	
	@Then("^user validate presence of Header and Footer elements on landing page mobile$")
	public void user_check_header_Footer_mobile() {
		HeaderFooterMobile planSelectorheaderfootermobile =  new HeaderFooterMobile(wd);
		planSelectorheaderfootermobile.headerElementsMobile();
		planSelectorheaderfootermobile.footerElementsMobile();
}
	@Then("^user validate Header and Footer Functionality of Plan Recommendation Engine mobile$")
	public void user_check_header_Footer_functionalities_mobile() {
		HeaderFooterMobile planSelectorheaderfootermobile =  new HeaderFooterMobile(wd);
		planSelectorheaderfootermobile.zipcodeFunctionInShopforaplanHeaderMobile(inputValues.get("Zip Code"));
		planSelectorheaderfootermobile.emailFunctionInShopforaplanMobile(inputValues.get("EMail"));
		planSelectorheaderfootermobile.enterSearchFunctionHeaderMobile(inputValues.get("Search Key"));
		planSelectorheaderfootermobile.backtoTopFunctionMobile();
	}
	
	@Then("^user validates all Links from header and footer mobile$")
	public void user_check_header_Footer_link_validation_mobile() {
		HeaderFooterMobile planSelectorheaderfootermobile =  new HeaderFooterMobile(wd);
		planSelectorheaderfootermobile.headerLinkvalidationMobile();
		planSelectorheaderfootermobile.footerLinkvalidationMobile();
	}

}
