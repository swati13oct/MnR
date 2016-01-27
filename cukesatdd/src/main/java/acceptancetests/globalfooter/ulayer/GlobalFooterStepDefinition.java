/**
 * 
 */
package acceptancetests.globalfooter.ulayer;
import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AboutUsAARPPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AgentsnBrokersAARPPage;
import pages.acquisition.ulayer.ContactUsAARPPage;
import pages.acquisition.ulayer.DisclaimersAARPPage;
import pages.acquisition.ulayer.PrivacyPolicyAARPPage;
import pages.acquisition.ulayer.SiteMapAARPPage;
import pages.acquisition.ulayer.TermsnConditionsAARPPage;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;

/**
 * @author rkodumur
 *
 */
public class GlobalFooterStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^user is on the AARP Medicare Plans home page$")
	public void the_user_on_AARP_Medicareplans_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean("webDriver", wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@When("^user accesses global footer of the AARP Medicare Plans home page$")
	public void access_global_footer() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject globalFooterActual = aquisitionhomepage.accessGlobalFooter();
		/* Get expected data */
		String fileName = "globalfooter";
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
	
	@And("^user clicks on terms&conditions link of privacypolicy page$")
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
	
	@Then("^the user validates all links in the global footer of AARP site$")
	public void user_validate_following_links_aarp() {

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
	

}
