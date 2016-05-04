package acceptancetests.browsercheck.ulayer;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.atdd.data.ulayer.Page;
import acceptancetests.enrollinplan.data.EnrollInPlanCommonConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import acceptancetests.planselector.data.PlanSelectorCommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.ContactUsAARPPage;
import pages.acquisition.ulayer.EnrollPlanInfoPage;
import pages.acquisition.ulayer.MedicareAdvantagePlansPage;
import pages.acquisition.ulayer.MedicareAdvantageRequestMoreHelpPage;
import pages.acquisition.ulayer.PlanInformationPage;
import pages.acquisition.ulayer.PlanSelectorPage;
import pages.acquisition.ulayer.RequestAgentAppointmentPage;
import pages.acquisition.ulayer.RequestHelpAndInformationPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.ZipcodeLookupHomePage;

public class UnsupportedBrowsersAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the AARP site landing page$")
	public void aarp_landing_page() {
		WebDriver wd= getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage=new AcquisitionHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}
	
	@When("^the user is on the AARP home page$")
	public void aarp_home_page() {		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject browserCheckActual = aquisitionhomepage.getBrowserCheck();
		// Get expected data 
		String fileName = "browsercheckexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator
				+ AcquistionCommonConstants.BROWSER_CHECK_FLOW_NAME
				+ File.separator;
		JSONObject browserCheckExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.BROWSER_CHECK_ACTUAL,
				browserCheckActual);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.BROWSER_CHECK_EXPECTED,
				browserCheckExpectedJson);
	}
	
	@Then("^the user validates error message on the browser of AARP site$")
	public void aarp_browser_check() {	
		Capabilities caps = ((RemoteWebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER)).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();	
		System.out.println(browserName);
		Assert.assertEquals("firefox", browserName);
		Assert.assertEquals("28.0", browserVersion);
		System.out.println("Failure");
		JSONObject browserCheckActual = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.BROWSER_CHECK_ACTUAL);
		JSONObject browserCheckExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.BROWSER_CHECK_EXPECTED);		
		System.out.println(browserCheckActual);
		System.out.println(browserCheckExpectedJson);
		try {
			JSONAssert.assertEquals(browserCheckActual,
					browserCheckExpectedJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	@And("^the user clicks on contact us link$")
	public void user_clicks_on_contact_us_link()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ContactUsAARPPage contactUsAARPPage= aquisitionhomepage.contactUsFooterClick();
		if(contactUsAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_Contact_US_PAGE,
					contactUsAARPPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("contactus page not found");
		}
	}
	
	@And("^the user clicks on Planselector link$")
	public void user_clicks_on_Planselector_link()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PlanSelectorPage planselectorAARP= aquisitionhomepage.planselector_click();
		if (planselectorAARP != null)
		{
			getLoginScenario().saveBean(PlanSelectorCommonConstants.PLAN_SELECTOR_PLAN,planselectorAARP);
			Assert.assertTrue(true);
				
		}
		else
		{
			Assert.fail("Plan selector page not found");
		}
	}
	

	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		//getLoginScenario().flushBeans();
	} 
	
	@When("^user hovers on Our Plans section of the AARP Medicare Plans home page$")
	public void hover_ourPlans(){
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage != null){
			JSONObject ourPlansDropdownActualJson = aquisitionhomepage
					.accessingOurPlansNav();

			/* Get expected data */
			String fileName = "ourPlansDropdownExpected";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ AcquistionCommonConstants.HEADER_FLOW_NAME
					+ File.separator;
			JSONObject ourPlansDropdownExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);

			getLoginScenario().saveBean(
					AcquistionCommonConstants.OUR_PLANS_ACTUAL,
					ourPlansDropdownActualJson);
			getLoginScenario().saveBean(
					AcquistionCommonConstants.OUR_PLANS_EXPECTED,
					ourPlansDropdownExpectedJson);
			Assert.assertTrue(true);
			}
			else{
				Assert.fail("Error in Home page");
			}

		
		}
	
	@And("^user clicks on medicare advantage plans link of our plans drop down from home page of U layer$")
	public void click_medicareAdvantage(){
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MedicareAdvantagePlansPage medicareAdvantagePlansuhcPage = aquisitionhomepage.medicareAdvantagePlansClick();
		if(medicareAdvantagePlansuhcPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_UHC_PAGE,
					medicareAdvantagePlansuhcPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  medicare advantage plans page");
		}
		
	}
	@And("^the user navigates to request more help and information in AARP site$")
	public void request_more_help_information()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RequestHelpAndInformationPage requestHelpAndInformationPage = aquisitionhomepage.navigateToMaMoreHelpAndInfo();
		
		getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
	}
	
	@And("^the user navigates to request appointment with an agent in AARP site$")
	public void request_appointment()
	{
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
		RequestAgentAppointmentPage requestAgentAppointmentPage = requestHelpAndInformationPage.nagiateToAgentAppointmentRequest();
		if(requestAgentAppointmentPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE, requestAgentAppointmentPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in loading requestAgentAppointmentPage");
		}
		
	}
	
	@And("^the user hits error url$")
	public void user_hits_error_url()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.start("https://www.awe-dev-a-aarpmedicareplans.uhc.com/500.html");
	}
	
	@And("^the user hits xmlsitemap url $")
	public void user_hits_xmlsitemap_url()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.start("https://www.awe-dev-a-aarpmedicareplans.uhc.com/xmlsitemap.html");
	}
	
	
	@When("^the user clicks on lookup zipcode link in AARP home page$")
	public void clicks_lookup_Zipcode_aarp() {

		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ZipcodeLookupHomePage zipcodeLookupPage = acquisitionHomePage
				.looksupforZipcodes();

		if (zipcodeLookupPage != null) {
			getLoginScenario().saveBean(PageConstants.ZIP_LOOK_UP_HOME_PAGE,
					zipcodeLookupPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing lookupzipcode link ");
		}

	}
	
	@When("^the user performs plan search using following information in AARP site$")
	public void zipcode_details_in_aarp_site( ) {

		/*List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}*/

	//	String zipcode = memberAttributesMap.get("Zip Code");
		//String county = memberAttributesMap.get("County Name");
		String zipcode="80002";
		String county="Adams County";
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.searchPlans(
				zipcode, county);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			/* Get expected data */
			String fileName = "vppPlanSummary";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);

			/* Get actual data */
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);
		}
	}
	
	@And("^the user enters multi county zipcodeums$")
	public void user_enters_multi_county_zipcode ()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		String zipcode="80002";
		String county="Adams County";
		System.out.println("Hi");
		aquisitionhomepage.multiple_county(zipcode);
	}
	
	
	
}
