package acceptancetests.vbfacquisition.footer;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AboutUsPage;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AgentsAndBrokersPage;
import pages.acquisition.bluelayer.ContactUsUmsPage;
import pages.acquisition.bluelayer.DisclaimersPage;
import pages.acquisition.bluelayer.PrivacyPolicyUmsPage;
import pages.acquisition.bluelayer.SiteMapUMSPage;
import pages.acquisition.bluelayer.TermsOfUseUmsPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 *Functionality: Global Header Footer
 */
public class GlobalHeaderFooterStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo:the user is on the UHC Medicaresolutions Site
	 */
	@Given("^the user is on the UHC Medicaresolutions Site$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

	/**
	 * @toDo:user accesses global footer
	 */
	@When("^user accesses global footer UHC Medicaresolutions Site$")
	public void the_user_accesses_GlobalFooter_UHC_Medicaresolutions_Site() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage != null){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in Home page");
		}

	}

	/**
	 * @toDo:user clicks on Sitemap link from home page footer
	 */
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

	/**
	 * @toDo:user clicks on Aboutus link from home page footer
	 */
	@And("^the user clicks on Aboutus link from home page footer UHC Medicaresolutions Site$")
	public void user_clicks_Aboutus_links_ums() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AboutUsPage aboutUsPage = aquisitionhomepage.aboutUsClick();
		if(aboutUsPage != null){
			getLoginScenario().saveBean(PageConstants.ABOUT_US_PAGE,
					aboutUsPage);
			Assert.assertTrue(true);

		}else{
			Assert.fail("Error in Aboutus page");

		}

	}

	/**
	 * @toDo:user clicks on Contactus link from about us page footer 
	 */
	@And("^the user clicks on Contactus link from about us page footer UHC Medicaresolutions Site$")
	public void user_clicks_Contactus_link_ums() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ContactUsUmsPage contactUsUmsPage = aquisitionhomepage.contactUsClick();
		if(contactUsUmsPage != null){
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactUsUmsPage);
			Assert.assertTrue(true);

		}
		else{
			Assert.fail("Error in Contact us page");
		}

	}

	/**
	 * @toDo:user clicks on Privacy Policy link from Contactus page footer 
	 */
	@And("^the user clicks on Privacy Policy link from Contactus page footer UHC Medicaresolutions Site$")
	public void user_clicks_PrivacyPolicy_link_ums() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PrivacyPolicyUmsPage privacyPolicyUmsPage = aquisitionhomepage.privacyPolicyClick();
		if(privacyPolicyUmsPage != null){
			getLoginScenario().saveBean(PageConstants.PRIVACY_POLICY_PAGE,
					privacyPolicyUmsPage);
			Assert.assertTrue(true);

		}
		else{
			Assert.fail("Error in Private policy page");
		}

	}

	/**
	 * @toDo:user clicks on Terms of use link from Privacy Policy page footer
	 */
	@And("^the user clicks on Terms of use link from Privacy Policy page footer UHC Medicaresolutions Site$")
	public void user_clicks_TermsOfUse_link_ums() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		TermsOfUseUmsPage termsOfUseUmsPage = aquisitionhomepage.termsOfUseClick();
		if(termsOfUseUmsPage != null){
			getLoginScenario().saveBean(PageConstants.TERMS_OF_USE_PAGE,
					termsOfUseUmsPage);
			Assert.assertTrue(true);

		}
		else{
			Assert.fail("Error in terms of use page");
		}

	}

	/**
	 * @toDo:user clicks on Disclaimers link from Terms of use page footer
	 */
	@And("^the user clicks on Disclaimers link from Terms of use page footer UHC Medicaresolutions Site$")
	public void user_clicks_Disclaimers_link_ums() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersPage disclaimersPage = aquisitionhomepage.disclaimersClick();
		if(disclaimersPage != null){
			getLoginScenario().saveBean(PageConstants.DISCLAIMERS_PAGE,
					disclaimersPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}


	}

	/**
	 * @toDo:user clicks on Agents & Brokers link from Disclaimers page footer
	 */
	@And("^the user clicks on Agents & Brokers link from Disclaimers page footer UHC Medicaresolutions Site$")
	public void user_clicks_AgentsAndBrokers_link_ums() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AgentsAndBrokersPage agentsAndBrokersPage = aquisitionhomepage.agentsAndBrokersClick();
		if(agentsAndBrokersPage != null){
			getLoginScenario().saveBean(PageConstants.AGENTS_AND_BROKERS_PAGE,
					agentsAndBrokersPage);
		}
		else{
			Assert.fail("Error in Agents and brokers page");
		}

	}

	/**
	 * @toDo:user verifies home link of agents&brokers
	 */
	@And("^user verifies home link of agents&brokers page bluelayer$")
	public void user_clicks_on_home_link_of_agents_brokers_page_bluelayer() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePage aquisitionHomePageReload = aquisitionhomepage.homeFooterClick();
		Assert.assertTrue("home page not found", aquisitionHomePageReload!= null);
	}
}
