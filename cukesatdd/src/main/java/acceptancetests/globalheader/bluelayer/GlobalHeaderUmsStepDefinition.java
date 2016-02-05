/**
 * 
 */
package acceptancetests.globalheader.bluelayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.DisclaimersPage;
import pages.acquisition.bluelayer.OurPlansPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

/**
 * @author saduri
 *
 */
public class GlobalHeaderUmsStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the UHC Medicaresolutions Site$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@When("^user accesses global header UHC Medicaresolutions Site$")
	public void the_user_accesses_GlobalHeader_UHC_Medicaresolutions_Site() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage != null){
		JSONObject globalHeaderActual = aquisitionhomepage
				.accessingGlobalHeader();

		/* Get expected data */
		String fileName = "globalheaderexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator
				+ AcquistionCommonConstants.GLOBAL_HEADER_FLOW_NAME
				+ File.separator;
		JSONObject globalHeaderExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.GLOBAL_HEADER_ACTUAL,
				globalHeaderActual);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.GLOBAL_HEADER_EXPECTED,
				globalHeaderExpectedJson);
		Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in Home page");
		}

	}
	
	@And("^user clicks on the Important Disclosures link on UHC Medicaresolutions Site page$")
	public void user_clicks_ImportantDisclaimers_link_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersPage disclaimersPage = aquisitionhomepage.importantDisclaimersClick();
		if(disclaimersPage != null){
			getLoginScenario().saveBean(PageConstants.DISCLAIMERS_PAGE,
					disclaimersPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
	@And("^user clicks on the UnitedHealthCare logo on UHC Medicaresolutions Site page$")
	public void user_clicks_UnitedHealthCare_logo_ums() {
		
		DisclaimersPage disclaimersPage = (DisclaimersPage) getLoginScenario()
				.getBean(PageConstants.DISCLAIMERS_PAGE);
		AcquisitionHomePage aquisitionhomepage = disclaimersPage.unitedHealthCareLogoClick();
		if(aquisitionhomepage != null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
	@And("^user clicks on home link in navigation section on UHC Medicaresolutions Site page$")
	public void user_clicks_HomeLink_navigation_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage = aquisitionhomepage.navigationSectionHomeLinkClick();
		if(aquisitionhomepage != null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
	@And("^user clicks on Our Plans link in navigation section on UHC Medicaresolutions Site page$")
	public void user_clicks_OurPlans_navigation_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		OurPlansPage ourPlansPage = aquisitionhomepage.navigationSectionOurPlansLinkClick();
		if(ourPlansPage != null){
			getLoginScenario().saveBean(PageConstants.OUR_PLANS_PAGE,
					ourPlansPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
		
	@And("^user clicks text  in global search field in navigation section on UHC Medicaresolutions Site page$")
	public void user_clicks_GlobalSearchField_navigation_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean searchResult = aquisitionhomepage.navigationSectionEnterSearchClick();
		
		
		if(searchResult != null && searchResult){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
	@Then("^user validates the Brand Section items on UHC Medicaresolutions Site page$")
	public void user_validate_BrandSection_links_ums() {

		JSONObject globalHeaderActual = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.GLOBAL_HEADER_ACTUAL);

		JSONObject globalHeaderExpected = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.GLOBAL_HEADER_EXPECTED);

		System.out.println("globalHeaderActual---->" + globalHeaderActual);
		System.out.println("globalHeaderExpected---->" + globalHeaderExpected);
		try {
			JSONAssert.assertEquals(globalHeaderExpected, globalHeaderActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
