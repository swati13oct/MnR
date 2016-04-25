package acceptancetests.browsercheck.ulayer;

import java.io.File;

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
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import acceptancetests.planselector.data.PlanSelectorCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.ContactUsAARPPage;
import pages.acquisition.ulayer.PlanSelectorPage;

public class UnsupportedBrowsersAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the AARP site landing page$")
	public void aarp_landing_page() {
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
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
	
}
