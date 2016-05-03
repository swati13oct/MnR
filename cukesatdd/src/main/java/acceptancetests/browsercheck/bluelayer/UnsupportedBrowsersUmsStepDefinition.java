package acceptancetests.browsercheck.bluelayer;

import gherkin.formatter.model.DataTableRow;

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

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.ContactUsUmsPage;
import pages.acquisition.bluelayer.PlanSelectorPage;
import pages.acquisition.bluelayer.RequestAgentAppointmentPage;
import pages.acquisition.bluelayer.RequestHelpAndInformationPage;
import pages.acquisition.bluelayer.ZipcodeLookupHomePage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.EnrollPlanInfoPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
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

public class UnsupportedBrowsersUmsStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the UMS site landing page$")
	public void landing_page_umssite() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@When("^the user is on the home page$")
	public void ums_home_page() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject browserCheckActual = aquisitionhomepage.getBrowserCheck();
		// Get expected data 
		String fileName = "browsercheckexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
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
	
	@Then("^the user validates error message on the browser$")
	public void ums_browser_check() {
		Capabilities caps = ((RemoteWebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER)).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();		
		Assert.assertEquals("firefox", browserName);
		Assert.assertEquals("28.0", browserVersion);
		System.out.println("Blue layer failure");
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
	
	@When("^the user clicks on contact us link on UMS site$")
	public void user_clicks_contactus_UMS()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ContactUsUmsPage contactusUmspage= aquisitionhomepage.contactUsFooterClick();
		if (contactusUmspage!=null)
		{
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE, contactusUmspage);
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail("Contact us error");
		}
		
	}
	@And("^the user clicks on Planselector link on UMS site$")
	public void user_clicks_on_Planselector_link_uhc()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PlanSelectorPage planSelectorPage = aquisitionhomepage.planselector_click();
		
		if (planSelectorPage != null)
		{
			getLoginScenario().saveBean(PlanSelectorCommonConstants.PLAN_SELECTOR_PLAN,planSelectorPage);
			Assert.assertTrue(true);
				
		}
		else
		{
			Assert.fail("Plan selector page not found");
		}
	}
	
	@And("^the user navigates to request more help and information in UMS site$")
	public void request_more_help_information()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RequestHelpAndInformationPage requestHelpAndInformationPage = aquisitionhomepage.navigateToMaMoreHelpAndInfo();
		
		getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
	}
	
	@And("^the user navigates to request appointment with an agent in UMS site$")
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
	
	@And("^the user hits uhcerror url$")
	public void user_hits_error_url()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.start("https://www.awe-dev-a-uhcmedicaresolutions.uhc.com/500.html");
	}
	
	@And("^the user hits xmlsitemapuhc url $")
	public void user_hits_xmlsitemapuhc_url()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.start("https://www.awe-dev-a-uhcmedicaresolutions.uhc.com/xmlsitemap.html");
	}
	
	@When("^the user clicks on lookup zipcode link in UMS home page$")
	public void clicks_lookup_Zipcode_aarp() {

		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		pages.acquisition.bluelayer.ZipcodeLookupHomePage zipcodeLookupPage = acquisitionHomePage.looksupforZipcodes();

		if (zipcodeLookupPage != null) {
			getLoginScenario().saveBean(PageConstants.ZIP_LOOK_UP_HOME_PAGE,
					zipcodeLookupPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error accessing lookupzipcode link ");
		}

	}
	
	@When("^the user performs plan search using following information in UMS site$")
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
	
	@And("^the user enters multi county zipcode ums$")
	public void user_enters_multi_county_zipcode ()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		String zipcode="80002";
		String county="Adams County";
		System.out.println("Hi");
		aquisitionhomepage.multiple_county(zipcode);
	}
	
	
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		//getLoginScenario().flushBeans();
	}
	
}
