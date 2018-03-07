package acceptancetests.deprecated.fixedtestcases;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.deprecated.acquisition.bluelayer.AboutUsPage;
import pages.deprecated.acquisition.bluelayer.AcquisitionHomePage;
import pages.deprecated.acquisition.bluelayer.AgentsAndBrokersPage;
import pages.deprecated.acquisition.bluelayer.ContactUsUmsPage;
import pages.deprecated.acquisition.bluelayer.DisclaimersPage;
import pages.deprecated.acquisition.bluelayer.PrivacyPolicyUmsPage;
import pages.deprecated.acquisition.bluelayer.SiteMapUMSPage;
import pages.deprecated.acquisition.bluelayer.TermsOfUseUmsPage;

/**
 * @author saduri
 *
 */
public class GlobalHeaderFooterUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the UHC Medicaresolutions Site$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriverNew();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
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

			System.out.println(globalFooterActual);
			if (aquisitionhomepage.validateFooterLinks(globalFooterActual)) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error in validating foooter links check ");
			}
		}
		else{
			Assert.fail("Error in Home page");
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
		}
		else{
			Assert.fail("Error in Agents and brokers page");
		}

	}

	@And("^user verifies home link of agents&brokers page bluelayer$")
	public void user_clicks_on_home_link_of_agents_brokers_page_bluelayer() {
		AgentsAndBrokersPage agentsAndBrokersPage  = (AgentsAndBrokersPage) getLoginScenario()
				.getBean(PageConstants.AGENTS_AND_BROKERS_PAGE);
		if (agentsAndBrokersPage.validatHomeLink()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating Home link ");
		}
	}
}
