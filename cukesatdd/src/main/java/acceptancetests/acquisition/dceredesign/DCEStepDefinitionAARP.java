package acceptancetests.acquisition.dceredesign;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.dce.ulayer.DCETestHarnessPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AddDrugDetails;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.SavingsOppurtunity;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality:DCE Acquisition
 */
public class DCEStepDefinitionAARP {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	WebDriver driver;

	@Then("^the user validates Get Started Page$")
	public void the_user_validates_Get_Started_Page() throws Throwable {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		GetStartedPage DCEgetStarted = new GetStartedPage(driver);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_BuildDrugList, DCEgetStarted);
		
	}

	@Then("^the user clicks on Build Drug List to navigate to Step (\\d+)$")
	public void the_user_clicks_on_Build_Drug_List_to_navigate_to_Step(int arg1) throws Throwable {
		GetStartedPage DCEgetStarted =(GetStartedPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		BuildYourDrugList DCEbuildDrugList = DCEgetStarted.clickAddsDrugs();
		
	}

	@When("^user clicks on Next: Review Drug Costs button$")
	public void user_clicks_on_Next_Review_Drug_Costs_button(){

	}
	
	@Then("^load screen should be displayed$")
	public void load_screen_should_be_displayed(){

	}
	
	@Then("^user should be navigated to zipcode and plan year capture page$")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page(){
	    
	}

	@Then("^zipcode field should be visible$")
	public void zipcode_field_should_be_visible() {
	    
	}
	
	@Then("^user enter invalid zipcode$")
	public void user_enter_invalid_zipcode(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String invalidzipcode = memberAttributesMap.get("inValidzipCode");
		GetStartedPage DCEgetStarted =(GetStartedPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEgetStarted.validateZipCodeErrorMessage(invalidzipcode);
	}
	
	@Then("^user enters valid zipcode and county$")
	public void user_enter_valid_zipcode(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = memberAttributesMap.get("ZipCode");
		GetStartedPage DCEgetStarted =(GetStartedPage) getLoginScenario().getBean(PageConstants.DCE_Redesign_BuildDrugList);
		DCEgetStarted.enterZipCodeandcounty(zipcode);
	}

	@Then("^County dropdown should be visible$")
	public void county_dropdown_should_be_visible() {
		
	    
	}
	
	@Then("^user select the county from drop down$")
	public void user_should_be_selected_county() {
	    
	}
	
	

	@Then("^user verify plan year dropdown$")
	public void user_verify_plan_year_dropdown() {
	   
	}

	@Then("^Continue button should be displayed$")
	public void continue_button_should_be_displayed() {
	   
	}

}
