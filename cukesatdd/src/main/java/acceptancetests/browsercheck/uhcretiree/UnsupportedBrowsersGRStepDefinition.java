package acceptancetests.browsercheck.uhcretiree;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.GroupHomePage;
import pages.acquisition.uhcretiree.SelectFormularyPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class UnsupportedBrowsersGRStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the GR site landing page$")
	public void landing_page_grsite() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE,
				aquisitionhomepage);
		
	}
	
	@When("^the user is on the drug lookup page$")
	public void gr_drug_lookup_page() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE);
		SelectFormularyPage selectFormularyPage = aquisitionhomepage.prescriptionsDrugLink();
		
		JSONObject browserCheckActual =  selectFormularyPage.getBrowserCheck();
		// Get expected data 
		String fileName = "browsercheckexpected";
		String directory = CommonConstants.RETIREE_EXPECTED_DIRECTORY
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
	
	
	@When("^the user select a group to launch group home page$")
	public void gr_select_group(DataTable userAttributes) {
		//TO:DO
		String groupName = userAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE);
		
		GroupHomePage groupHomePage = aquisitionhomepage.selectGroupFromList(groupName);
		
		JSONObject browserCheckActual = groupHomePage.getBrowserCheck();
		
		// Get expected data 
				String fileName = "browsercheckexpected";
				String directory = CommonConstants.RETIREE_EXPECTED_DIRECTORY
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
	
	@Then("^the user validates the error message on the browser$")
	public void gr_error_browser_check() {
		//TO:DO
		Capabilities caps = ((RemoteWebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER)).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();		
		Assert.assertEquals("firefox", browserName);
		Assert.assertEquals("28.0", browserVersion);		
		JSONObject browserCheckActual = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.BROWSER_CHECK_ACTUAL);
		JSONObject browserCheckExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.BROWSER_CHECK_EXPECTED);		
		try {
			JSONAssert.assertEquals(browserCheckActual,
					browserCheckExpectedJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}
