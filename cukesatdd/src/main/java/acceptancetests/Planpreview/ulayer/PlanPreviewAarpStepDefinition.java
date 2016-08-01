/**
 * 
 */
package acceptancetests.Planpreview.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.HealthCentersPage;
import pages.acquisition.ulayer.HealthLivingPage;
import pages.acquisition.ulayer.HealthManagementProgramPage;
import pages.acquisition.ulayer.HealthToolsPage;
import pages.acquisition.ulayer.LoginAssistancePage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.DiscoverMoreResourcesPage;
import pages.acquisition.ulayer.ExploreChangingPlansPage;
import pages.acquisition.ulayer.LearnAboutMedicarePage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.PlanPreviewPage;
import pages.acquisition.ulayer.PrepareforInitialEnrollmentPage;
import pages.acquisition.ulayer.PrescriptionDrugPage;
import pages.acquisition.ulayer.ProviderSearchPage;
import pages.acquisition.ulayer.RegistrationHomePage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.ZipcodeLookupHomePage;
import pages.acquisition.ulayer.ZipcodeSelectionHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import acceptancetests.lookupzipcode.data.ZipLookupCommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pgrover1
 *
 */
public class PlanPreviewAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the Plan Preview Page of AARP medicare site landing page$")
	public void the_user_on_aarp_medicare_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();
		//System.out.println("reached");
		PlanPreviewPage planPreviewpage= new PlanPreviewPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE,planPreviewpage);
		
	}

	@When("^the user validates the multicounty popup on ulayer$")
	public void zipcode_details_in_aarp_site(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		PlanPreviewPage planpreviewPage= (PlanPreviewPage)getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		 planpreviewPage.searchPlans(zipcode, county);

		
	}
	
	@When("^the user clicks on lookup zipcode link in Planpreview  page$")
	public void clicks_lookup_Zipcode_aarp() {

		PlanPreviewPage planpreviewPage = (PlanPreviewPage) getLoginScenario().getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
//		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ZipcodeLookupHomePage zipcodeLookupPage = planpreviewPage
				.looksupforZipcodes();

		if (zipcodeLookupPage != null) {
			getLoginScenario().saveBean(PageConstants.ZIP_LOOK_UP_HOME_PAGE,
					zipcodeLookupPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing lookupzipcode link ");
		}

	}
	
	/*@And("^the user searches for zipcodes by entering the following Address and city and State details for AARP site$")
	public void enters_addres_city_state_details_aarp(
			DataTable addressAttributes) {
	List<DataTableRow> addressAttributesRow = addressAttributes
				.getGherkinRows();
		Map<String, String> addressAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < addressAttributesRow.size(); i++) {
			addressAttributesMap.put(addressAttributesRow.get(i).getCells()
					.get(0), addressAttributesRow.get(i).getCells().get(1));
		}

		String address = addressAttributesMap.get("Address");
		String city = addressAttributesMap.get("City");
		String state = addressAttributesMap.get("State");

		ZipcodeLookupHomePage zipcodeLookupAarpPage = (ZipcodeLookupHomePage) getLoginScenario()
				.getBean(PageConstants.ZIP_LOOK_UP_HOME_PAGE);
		ZipcodeSelectionHomePage zipcodeSelectionPage = zipcodeLookupAarpPage
				.enterAddressDetails(address, city, state);

		if (zipcodeSelectionPage != null) {
			getLoginScenario().saveBean(PageConstants.ZIP_SELECTION_HOME_PAGE,
					zipcodeSelectionPage);
			/ Get expected data 
			String fileName = address;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + ZipLookupCommonConstants.LOOK_UP_ZIPCODE
					+ File.separator + state + File.separator + city
					+ File.separator;

			JSONObject zipcodeSelectionExpectedJson = MRScenario
					.readExpectedJson(fileName, directory);
			getLoginScenario().saveBean(
					ZipLookupCommonConstants.ZIP_SELECTION_EXPECTED,
					zipcodeSelectionExpectedJson);

			JSONObject zipcodeSelectionActualJson = zipcodeSelectionPage.zipSelectionhomeJson;
			getLoginScenario().saveBean(
					ZipLookupCommonConstants.ZIP_SELECTION_ACTUAL,
					zipcodeSelectionActualJson);
		}
	}*/
	
	@When("^user select the below  plan$")
	public void user_validates_plan_selector_dropdown(DataTable givenAttributes)
	{
			List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String planName = memberAttributesMap.get("PlanName");
		String planType = memberAttributesMap.get("PlanType");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
		PlanPreviewPage planpreviewPage = (PlanPreviewPage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
			
		
		planpreviewPage.validatesplandropdown(planName);
	}
	
	@Then("^user validates the provider search and locate pharmacy link$")
	public void user_validates_provider_and_pharmacy_locator()
	{
//		List<DataTableRow> memberAttributesRow = givenAttributes
//				.getGherkinRows();
//		Map<String, String> memberAttributesMap = new HashMap<String, String>();
//		for (int i = 0; i < memberAttributesRow.size(); i++) {
//
//			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
//					.get(0), memberAttributesRow.get(i).getCells().get(1));
//		}
		
//		String plantype= memberAttributesMap.get("PlanType");
		String plantype=(String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		System.out.println(plantype);
		PlanPreviewPage planpreviewPage = (PlanPreviewPage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		
		planpreviewPage.validateprovider_pharmacylink(plantype);
	}
	
	@Then("^user clicks on locate pharmacy$")
	public void user_click_to_locate_pharmacy()
	{
		
		
		String plantype = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanPreviewPage planpreviewPage = (PlanPreviewPage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		if (plantype.equalsIgnoreCase("MA"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			planpreviewPage.navigatetopharmacylink(plantype);
		}
	}
	
	@Then("^user validates the plan year dropdown$")
	public void user_validates_planyear_dropdown()
	{
		PlanPreviewPage planpreviewPage = (PlanPreviewPage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		
		planpreviewPage.validate_planyeardropdown();
	}
	
	@And("^user click on provider link$")
	public void user_click_provider_link()
	{
		PlanPreviewPage planpreviewPage= (PlanPreviewPage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		Rallytool_Page rallyPage= planpreviewPage.navigatetoRally();
		if (rallyPage==null)
		{
			Assert.fail("Issue in launching Rally tool");
			
		}
			
		
	}
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
	
			


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
