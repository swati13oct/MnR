/**
 * 
 */
package acceptancetests.fixedtestcases;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AboutUsAARPPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AgentsnBrokersAARPPage;
import pages.acquisition.ulayer.ContactUsAARPPage;
import pages.acquisition.ulayer.DisclaimersAARPPage;
import pages.acquisition.ulayer.PrivacyPolicyAARPPage;
import pages.acquisition.ulayer.SiteMapAARPPage;
import pages.acquisition.ulayer.TermsnConditionsAARPPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * @author saduri
 *
 */
public class GlobalHeaderFooterAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^user is on acquisition home page of AARP Site$")
	public void user_is_on_acquisition_home_page_of_AARP_Site() {
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
		if(aquisitionhomepage != null){
			JSONObject globalFooterActual = aquisitionhomepage.accessGlobalFooter();
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

	@And("^user clicks on Aboutus link from footer of the AARP Medicare Plans home page$")
	public void click_aboutus() {
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AboutUsAARPPage aboutUsAARPPage = aquisitionhomepage.aboutUsFooterClick();
		if(aboutUsAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_ABOUT_US_PAGE,
					aboutUsAARPPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Aboutus page not found");
		}


	}

	@And("^user clicks on contactus link of aboutus page$")
	public void click_contactus() {
		AboutUsAARPPage aboutUsAARPPage  = (AboutUsAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_ABOUT_US_PAGE);
		ContactUsAARPPage contactUsAARPPage = aboutUsAARPPage.contactUsFooterClick();
		if(contactUsAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_Contact_US_PAGE,
					contactUsAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("contactus page not found");
		}
	}

	@And("^user clicks on sitemap link of contactus page$")
	public void click_sitemap() {
		ContactUsAARPPage contactUsAARPPage  = (ContactUsAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_Contact_US_PAGE);
		SiteMapAARPPage siteMapAARPPage = contactUsAARPPage.siteMapFooterClick();
		if(siteMapAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_SITE_MAP_PAGE,
					siteMapAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("sitemap page not found");
		}
	}
	@And("^user clicks on privacypolicy link of sitemap page$")
	public void click_privacypolicy() {
		SiteMapAARPPage siteMapAARPPage  = (SiteMapAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_SITE_MAP_PAGE);
		PrivacyPolicyAARPPage privacyPolicyAARPPage = siteMapAARPPage.privacypolicyFooterClick();
		if(privacyPolicyAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_PRIVACY_POLICY_PAGE,
					privacyPolicyAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("privacypolicy page not found");
		}
	}

	@And("^user clicks on termsOfuse link of privacypolicy page$")
	public void click_termsnconditions() {
		PrivacyPolicyAARPPage privacyPolicyAARPPage  = (PrivacyPolicyAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_PRIVACY_POLICY_PAGE);
		TermsnConditionsAARPPage termsnConditionsAARPPage = privacyPolicyAARPPage.termsnconditionsFooterClick();
		if(termsnConditionsAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_TERMS_AND_CONDITIONS_PAGE,
					termsnConditionsAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("terms&conditions page not found");
		}
	}

	@And("^user clicks on disclaimers link of terms&conditions page$")
	public void click_disclaimers() {
		TermsnConditionsAARPPage termsnConditionsAARPPage  = (TermsnConditionsAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_TERMS_AND_CONDITIONS_PAGE);
		DisclaimersAARPPage disclaimersAARPPage = termsnConditionsAARPPage.disclaimersFooterClick();
		if(disclaimersAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_DISCLAIMERS_PAGE,
					disclaimersAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("disclaimers page not found");
		}
	}

	@And("^user clicks on agents&brokers link of disclaimers page$")
	public void click_agentsnbrokers() {
		DisclaimersAARPPage disclaimersAARPPage  = (DisclaimersAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_DISCLAIMERS_PAGE);
		AgentsnBrokersAARPPage agentsnBrokersAARPPage = disclaimersAARPPage.agentsnbrokersFooterClick();
		if(agentsnBrokersAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_AGENTS_AND_BROKERS_PAGE,
					agentsnBrokersAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("agents&brokers page not found");
		}
	}

	@And("^user clicks on home link of agents&brokers page$")
	public void click_home() {
		AgentsnBrokersAARPPage agentsnBrokersAARPPage  = (AgentsnBrokersAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_AGENTS_AND_BROKERS_PAGE);
		AcquisitionHomePage aquisitionhomepage = agentsnBrokersAARPPage.homeFooterClick();
		if(aquisitionhomepage!= null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("home page not found");
		}
	}	
	
	@And("^user verifies home link of agents&brokers page ulayer$")
	public void user_clicks_on_home_link_of_agents_brokers_page_ulayer() {
		AgentsnBrokersAARPPage agentsAndBrokersPage  = (AgentsnBrokersAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_AGENTS_AND_BROKERS_PAGE);
		if (agentsAndBrokersPage.validatHomeLink()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating Home link ");
		}
	}
}
