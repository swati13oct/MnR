package acceptancetests.dtmtests;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

/**
 * @author gumeshna
 *
 */

public class DTMvalidationStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the AARP medicare site landing page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@When("^user accesses global footer of the AARP Medicare Plans home page$")
	public void access_global_footer() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject globalFooterActual = aquisitionhomepage.accessGlobalFooter();
		/* Get expected data */
		String fileName = "globalfooterexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator
				+ AcquistionCommonConstants.GLOBAL_FOOTER_FLOW_NAME
				+ File.separator;
		JSONObject globalFooterExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.GLOBAL_FOOTER_ACTUAL,
				globalFooterActual);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.GLOBAL_FOOTER_EXPECTED,
				globalFooterExpectedJson);
		
		try {
			JSONAssert.assertEquals(globalFooterActual, globalFooterActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Then("^the user validates the DTM tags for links in footer section of the AARP Medicare Plans home page$")
	public void validates_dtm_tags_in_footer_section() throws Exception
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject actaulFooterDTMjson = aquisitionhomepage.validatesDTMTags();
		
		/* Get expected data */
		String fileName = "dtm_globalfooterexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator +CommonConstants.SITE_ULAYER
				+ File.separator
				+ AcquistionCommonConstants.GLOBAL_FOOTER_FLOW_NAME
				+ File.separator;
		JSONObject expectedFooterDTMjson = MRScenario.readExpectedJson(
				fileName, directory);
		
		try {
			JSONAssert.assertEquals(expectedFooterDTMjson, actaulFooterDTMjson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}


	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

}
