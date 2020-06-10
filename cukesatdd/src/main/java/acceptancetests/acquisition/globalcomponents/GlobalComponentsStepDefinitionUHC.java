package acceptancetests.acquisition.globalcomponents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

/**
 * Functionality: Global Header Footer
 */
public class GlobalComponentsStepDefinitionUHC {

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
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	/**
	 * @toDo:user accesses global footer
	 */
	@When("^user accesses global footer UHC Medicaresolutions Site$")
	public void the_user_accesses_GlobalFooter_UHC_Medicaresolutions_Site() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {

			aquisitionhomepage.validateFooterLinks();
		} else {
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
		if (siteMapUMSPage != null) {
			getLoginScenario().saveBean(PageConstants.SITE_MAP_PAGE, siteMapUMSPage);
			Assert.assertTrue(true);
		} else {
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
		if (aboutUsPage != null) {
			getLoginScenario().saveBean(PageConstants.ABOUT_US_PAGE, aboutUsPage);
			Assert.assertTrue(true);

		} else {
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
		if (contactUsUmsPage != null) {
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE, contactUsUmsPage);
			Assert.assertTrue(true);

		} else {
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
		if (privacyPolicyUmsPage != null) {
			getLoginScenario().saveBean(PageConstants.PRIVACY_POLICY_PAGE, privacyPolicyUmsPage);
			Assert.assertTrue(true);

		} else {
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
		if (termsOfUseUmsPage != null) {
			getLoginScenario().saveBean(PageConstants.TERMS_OF_USE_PAGE, termsOfUseUmsPage);
			Assert.assertTrue(true);

		} else {
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
		if (disclaimersPage != null) {
			getLoginScenario().saveBean(PageConstants.DISCLAIMERS_PAGE, disclaimersPage);
			Assert.assertTrue(true);
		} else {
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
		if (agentsAndBrokersPage != null) {
			getLoginScenario().saveBean(PageConstants.AGENTS_AND_BROKERS_PAGE, agentsAndBrokersPage);
		} else {
			Assert.fail("Error in Agents and brokers page");
		}

	}

	/**
	 * @toDo:user verifies home link of agents&brokers
	 *//*
		 * @And("^user verifies home link of agents&brokers page bluelayer$") public
		 * void user_clicks_on_home_link_of_agents_brokers_page_bluelayer() {
		 * AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)
		 * getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
		 * 
		 * AcquisitionHomePage aquisitionHomePageReload =
		 * aquisitionhomepage.homeFooterClick();
		 * Assert.assertTrue("home page not found", aquisitionHomePageReload!= null); }
		 */
	/**
	 * @toDo:user clicks on Request Assistance and validates modal window
	 */
	@And("^user clicks on Request Assistance and validates modal window bluelayer$")
	public void user_clicks_on_Request_Assistance_and_validates_modal_window_blayer() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickRequestAsistancce();
	}

	@When("^user accesses global header of the UHC Medicare Solutions home page$")
	public void access_global_header_uhc() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateHeaderLinks();
		} else {
			Assert.fail("Home page not found");
		}
	}

	@When("^user verifies the UHC logo on home page on UHC site$")
	public void user_verifies_the_uhc_logo_on_home_page() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateUHClogo();
	}

	@And("^user clicks on Sign in link on home page on UHC site$")
	public void click_signIn_uhc() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.signInheader();
	}

	@And("^user clicks on register link on home page on UHC site$")
	public void click_register_uhc() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.headerRegisterLink();
	}

	@When("^user verifies home link of agents&brokers page bluelayer$")
	public void user_verifies_and_clicks_on_home_link_of_agents_brokers_page_blayer() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePage aquisitionHomePageReload = aquisitionhomepage.homeFooterClick();
		Assert.assertTrue("home page not found", aquisitionHomePageReload != null);
	}

@When("^user vaidates the state drop down link on home page in UHC$")
public void user_vaidates_the_state_drop_down_link_on_home_page_in_UHC() throws Throwable {
	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
			.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	aquisitionhomepage.validateStateDropDown();
}

@When("^user clicks on View all disclaimer information link on home page in UHC$")
public void user_clicks_on_View_all_disclaimer_information_link_on_home_page_in_UHC() throws Throwable {
	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
			.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	aquisitionhomepage.validateDisclaimer();
}


	@Then("^user clicks on back to top link on home page on UHC site$")
	public void user_clicks_on_back_to_top_link_on_home_page_uhc() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.backToToplink();
	}

	@Given("^the user navigates to following UHC medicare acquisition site page$")
	public void the_user_navigates_to_following_uhc_medicare_acquisition_site_page(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : " + path);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPath(path);
	}

	/**
	 * @toDo:user accesses global footer
	 */
	@When("^user accesses global footer of the UHC Medicare Solutions All page$")
	public void access_global_footer_uhc_all_pages() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateGlobalFooterLinks();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}

	@Then("^the USer validates Shop for a Plan Navigation links on UHC site$")
	public void the_USer_validates_Shop_for_a_Plan_Navigation_links_uhc() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateSubNavShopPlanLinks();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}

	@Then("^the user validates Medicare Education Navigation links on UHC site$")
	public void the_user_validates_Medicare_Education_Navigation_links_uhc() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateSubNavMedEdLinks();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}

	@Then("^the user validates TFN on page on UHC site$")
	public void the_user_validates_TFN_on_page_uhc(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String tfnXpath = memberAttributesMap.get("TFNxpath");
		String tfnFlag = memberAttributesMap.get("TFNflag");

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (tfnFlag.equalsIgnoreCase("true")) {
			aquisitionhomepage.validateTFNelement(tfnXpath);
		}
	}

	@Then("^the user validates Pro-active Chat on UHC site$")
	public void the_user_validates_Pro_active_Chat_uhc() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatProActive();
		aquisitionhomepage.validateProActiveChatpopup();

	}

	@Then("^the user validates SAM Call Icon on UHC site$")
	public void the_user_validates_SAM_Call_Icon_uhc() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSam();
		aquisitionhomepage.validateCallSamContent();
		aquisitionhomepage.validateCallpopup();
	}

	@Then("^the user validates SAM re-active Chat on UHC site$")
	public void the_user_validates_SAM_re_active_Chat_uhc() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatSam();
		aquisitionhomepage.validateChatSamContent();
		aquisitionhomepage.validateChatpopup();

	}

	@Then("^user validates visitor profile on home page on UHC site$")
	public void the_user_validates_visitor_profile_uhc() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validatevisitorprofile();
	}

}
