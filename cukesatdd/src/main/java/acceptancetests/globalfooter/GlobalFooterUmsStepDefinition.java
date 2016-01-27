/**
 * 
 */
package acceptancetests.globalfooter;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AboutUsPage;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AgentsAndBrokersPage;
import pages.acquisition.bluelayer.ContactUsUmsPage;
import pages.acquisition.bluelayer.DisclaimersPage;
import pages.acquisition.bluelayer.PrivacyPolicyUmsPage;
import pages.acquisition.bluelayer.SiteMapUMSPage;
import pages.acquisition.bluelayer.TermsOfUseUmsPage;
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
public class GlobalFooterUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the UHC Medicaresolutions Site$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean("webDriver", wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

	@When("^user accesses global footer UHC Medicaresolutions Site$")
	public void the_user_accesses_GlobalFooter_UHC_Medicaresolutions_Site() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage != null){
		JSONObject globalFooterActual = aquisitionhomepage
				.accessingGlobalFooter();

		/* Get expected data */
		String fileName = "globalfooter";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
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
		Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in Home page");
		}

	}

	@Then("^the user validates links in the global footer in UHC Medicaresolutions Site$")
	public void user_validate_following_links_ums() {

		JSONObject globalFooterActual = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.GLOBAL_FOOTER_ACTUAL);

		JSONObject globalFooterExpected = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.GLOBAL_FOOTER_EXPECTED);

		System.out.println("globalFooterActual---->" + globalFooterActual);
		System.out.println("globalFooterExpected---->" + globalFooterExpected);
		try {
			JSONAssert.assertEquals(globalFooterExpected, globalFooterActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@And("^the user clicks on Sitemap link from home page footer UHC Medicaresolutions Site$")
	public void user_clicks_Sitemap_links_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		SiteMapUMSPage siteMapUMSPage = aquisitionhomepage.siteMapFooterClick();
		if(siteMapUMSPage != null){
		getLoginScenario().saveBean(PageConstants.SITE_MAP_PAGE,
				siteMapUMSPage);
		Assert.assertTrue(true);
		}else{
			Assert.fail("Error in Site map page");
			
		}
	}
	
	
	
	@And("^the user clicks on Aboutus link from home page footer UHC Medicaresolutions Site$")
	public void user_clicks_Aboutus_links_ums() {
		
		SiteMapUMSPage siteMapUMSPage = (SiteMapUMSPage) getLoginScenario()
				.getBean(PageConstants.SITE_MAP_PAGE);
		AboutUsPage aboutUsPage = siteMapUMSPage.aboutUsClick();
		if(aboutUsPage != null){
		getLoginScenario().saveBean(PageConstants.ABOUT_US_PAGE,
				aboutUsPage);
		Assert.assertTrue(true);
		
		}else{
			Assert.fail("Error in Aboutus page");
			
		}
		
	}
	
	
	
	@And("^the user clicks on Contactus link from about us page footer UHC Medicaresolutions Site$")
	public void user_clicks_Contactus_link_ums() {
		
		AboutUsPage aboutUsPage = (AboutUsPage) getLoginScenario()
				.getBean(PageConstants.ABOUT_US_PAGE);
		ContactUsUmsPage contactUsUmsPage = aboutUsPage.contactUsClick();
		if(contactUsUmsPage != null){
		getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
				contactUsUmsPage);
		Assert.assertTrue(true);
		
		}
		else{
			Assert.fail("Error in Contact us page");
		}
		
	}
	
	@And("^the user clicks on Privacy Policy link from Contactus page footer UHC Medicaresolutions Site$")
	public void user_clicks_PrivacyPolicy_link_ums() {
		
		ContactUsUmsPage contactUsUmsPage = (ContactUsUmsPage) getLoginScenario()
				.getBean(PageConstants.CONTACT_US_PAGE);
		PrivacyPolicyUmsPage privacyPolicyUmsPage = contactUsUmsPage.privacyPolicyClick();
		if(privacyPolicyUmsPage != null){
		getLoginScenario().saveBean(PageConstants.PRIVACY_POLICY_PAGE,
				privacyPolicyUmsPage);
		Assert.assertTrue(true);
		
		}
		else{
			Assert.fail("Error in Private policy page");
		}
		
	}
	
	@And("^the user clicks on Terms of use link from Privacy Policy page footer UHC Medicaresolutions Site$")
	public void user_clicks_TermsOfUse_link_ums() {
		
		PrivacyPolicyUmsPage privacyPolicyUmsPage = (PrivacyPolicyUmsPage) getLoginScenario()
				.getBean(PageConstants.PRIVACY_POLICY_PAGE);
		TermsOfUseUmsPage termsOfUseUmsPage = privacyPolicyUmsPage.termsOfUseClick();
		if(termsOfUseUmsPage != null){
		getLoginScenario().saveBean(PageConstants.TERMS_OF_USE_PAGE,
				termsOfUseUmsPage);
		Assert.assertTrue(true);
		
		}
		else{
			Assert.fail("Error in terms of use page");
		}
		
	}
	
	@And("^the user clicks on Disclaimers link from Terms of use page footer UHC Medicaresolutions Site$")
	public void user_clicks_Disclaimers_link_ums() {
		
		TermsOfUseUmsPage termsOfUseUmsPage = (TermsOfUseUmsPage) getLoginScenario()
				.getBean(PageConstants.TERMS_OF_USE_PAGE);
		DisclaimersPage disclaimersPage = termsOfUseUmsPage.disclaimersClick();
		if(disclaimersPage != null){
			getLoginScenario().saveBean(PageConstants.DISCLAIMERS_PAGE,
					disclaimersPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
			
		
		}
	
	@And("^the user clicks on Agents & Brokers link from Disclaimers page footer UHC Medicaresolutions Site$")
	public void user_clicks_AgentsAndBrokers_link_ums() {
		
		DisclaimersPage disclaimersPage = (DisclaimersPage) getLoginScenario()
				.getBean(PageConstants.DISCLAIMERS_PAGE);
		AgentsAndBrokersPage agentsAndBrokersPage = disclaimersPage.agentsAndBrokersClick();
		if(agentsAndBrokersPage != null){
			getLoginScenario().saveBean(PageConstants.AGENTS_AND_BROKERS_PAGE,
					agentsAndBrokersPage);
			
			JSONObject agentsAndBrokersActualJson = agentsAndBrokersPage.agentsAndBrokers();
			
			/* Get expected data */
			String fileName = "agentsandbrokers";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator
					+ AcquistionCommonConstants.AGENTS_AND_BROKERS_FLOW_NAME
					+ File.separator;
			JSONObject agentsAndBrokersExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);

			getLoginScenario().saveBean(
					AcquistionCommonConstants.AGENTS_AND_BROKERS_ACTUAL,
					agentsAndBrokersActualJson);
			getLoginScenario().saveBean(
					AcquistionCommonConstants.AGENTS_AND_BROKERS_EXPECTED,
					agentsAndBrokersExpectedJson);
			Assert.assertTrue(true);
			
		}
		else{
			Assert.fail("Error in Agents and brokers page");
		}
		
		}
	
	@Then("^the user validates sections on Agents & Brokers page$")
	public void user_validate_AgentsAndBrokers_links_ums() {

		JSONObject agentsAndBrokersActualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.AGENTS_AND_BROKERS_ACTUAL);

		JSONObject agentsAndBrokersExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.AGENTS_AND_BROKERS_EXPECTED);

		System.out.println("agentsAndBrokersActualJson---->" + agentsAndBrokersActualJson);
		System.out.println("agentsAndBrokersExpectedJson---->" + agentsAndBrokersExpectedJson);
		try {
			JSONAssert.assertEquals(agentsAndBrokersExpectedJson, agentsAndBrokersActualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
		
		
	
	
	

}
