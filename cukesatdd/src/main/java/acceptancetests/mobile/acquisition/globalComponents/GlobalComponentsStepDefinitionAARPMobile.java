package acceptancetests.mobile.acquisition.globalComponents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.mobile.acquisition.commonpages.EnterZipCodePage;
import pages.mobile.acquisition.ulayer.AboutUsAARPPageMobile;
import pages.mobile.acquisition.ulayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.ulayer.AgentsnBrokersAARPPageMobile;
import pages.mobile.acquisition.ulayer.ContactUsAARPPageMobile;
import pages.mobile.acquisition.ulayer.DisclaimersAARPPageMobile;
import pages.mobile.acquisition.ulayer.PrivacyPolicyAARPPageMobile;
import pages.mobile.acquisition.ulayer.SiteMapAARPPageMobile;
import pages.mobile.acquisition.ulayer.TermsnConditionsAARPPageMobile;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

/**
 *Functionality:Global Header Footer 
 */
public class GlobalComponentsStepDefinitionAARPMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	
	AppiumDriver wd;
	
	
	@Given("^user is on acquisition home page of AARP Site$")
	public void user_is_on_acquisition_home_page_of_AARP_Site() {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		// aquisitionhomepage.openPRE();
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	/**
	 * @toDo:user accesses global footer
	 */
	@When("^user accesses global footer of the AARP Medicare Plans home page$")
	public void access_global_footer_aarp() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateFooterLinks();
		} else {
			Assert.fail("Home page not found");
		}
	}

	/**
	 * @toDo:user clicks on Aboutus link from footer 
	 */
//	@And("^user clicks on Aboutus link from footer of the AARP Medicare Plans home page$")
//	public void click_aboutus() {
//		AcquisitionHomePageMobile aquisitionhomepage  = (AcquisitionHomePageMobile) getLoginScenario()
//				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		AboutUsAARPPageMobile aboutUsAARPPage = aquisitionhomepage.aboutUsFooterClick();
//		if(aboutUsAARPPage!= null){
//			getLoginScenario().saveBean(PageConstants.AARP_ABOUT_US_PAGE,
//					aboutUsAARPPage);
//			Assert.assertTrue(true);
//		} else {
//			Assert.fail("Aboutus page not found");
//		}
//
//
//	}

	/**
	 * @toDo:user clicks on contactus link of aboutus
	 */
//	@And("^user clicks on contactus link of aboutus page$")
//	public void click_contactus() {
//		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
//				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		ContactUsAARPPageMobile contactUsAARPPage = aquisitionhomepage.contactUsFooterClick();
//		if (contactUsAARPPage != null) {
//			getLoginScenario().saveBean(PageConstants.AARP_Contact_US_PAGE, contactUsAARPPage);
//			Assert.assertTrue(true);
//		} else {
//			Assert.fail("contactus page not found");
//		}
//	}

	/**
	 * @toDo:user clicks on sitemap link of contactus
	 */
//	@And("^user clicks on sitemap link of contactus page$")
//	public void click_sitemap() {
//		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
//				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		SiteMapAARPPageMobile siteMapAARPPage = aquisitionhomepage.siteMapFooterClick1();
//		if(siteMapAARPPage!= null){
//			getLoginScenario().saveBean(PageConstants.AARP_SITE_MAP_PAGE,
//					siteMapAARPPage);
//
//			Assert.assertTrue(true);
//		} else {
//			Assert.fail("sitemap page not found");
//		}
//	}
	
	/**
	 * @toDo:user clicks on privacypolicy link of sitemap
	 */
//	@And("^user clicks on privacypolicy link of sitemap page$")
//	public void click_privacypolicy() {
//		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
//				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		PrivacyPolicyAARPPageMobile privacyPolicyAARPPage = aquisitionhomepage.privacypolicyFooterClick();
//		if(privacyPolicyAARPPage!= null){
//			getLoginScenario().saveBean(PageConstants.AARP_PRIVACY_POLICY_PAGE,
//					privacyPolicyAARPPage);
//
//			Assert.assertTrue(true);
//		} else {
//			Assert.fail("privacypolicy page not found");
//		}
//	}

	/**
	 * @toDo:user clicks on termsOfuse link of privacypolicy
	 */
	@And("^user clicks on termsOfuse link of privacypolicy page$")
	public void click_termsnconditions() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		TermsnConditionsAARPPageMobile termsnConditionsAARPPage = aquisitionhomepage.termsnconditionsFooterClick();
		if(termsnConditionsAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_TERMS_AND_CONDITIONS_PAGE,
					termsnConditionsAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("terms&conditions page not found");
		}
	}

	/**
	 * @toDo:user clicks on disclaimers link of terms&conditions
	 */
//	@And("^user clicks on disclaimers link of terms&conditions page$")
//	public void click_disclaimers() {
//		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
//				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		DisclaimersAARPPageMobile disclaimersAARPPage = aquisitionhomepage.disclaimersFooterClick();
//		if(disclaimersAARPPage!= null){
//			getLoginScenario().saveBean(PageConstants.AARP_DISCLAIMERS_PAGE,
//					disclaimersAARPPage);
//
//			Assert.assertTrue(true);
//		} else {
//			Assert.fail("disclaimers page not found");
//		}
//	}

	/**
	 * @toDo:user clicks on agents&brokers link of disclaimers
	 */
//	@And("^user clicks on agents&brokers link of disclaimers page$")
//	public void click_agentsnbrokers() {
//		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
//				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		AgentsnBrokersAARPPageMobile agentsnBrokersAARPPage = aquisitionhomepage.agentsnbrokersFooterClick();
//		if(agentsnBrokersAARPPage!= null){
//			getLoginScenario().saveBean(PageConstants.AARP_AGENTS_AND_BROKERS_PAGE,
//					agentsnBrokersAARPPage);
//
//			Assert.assertTrue(true);
//		} else {
//			Assert.fail("agents&brokers page not found");
//		}
//	}

	/**
	 * @toDo:user clicks on home link of agents&brokers
	 */
	
//	  @And("^user verifies home link of agents&brokers page ulayer$")
//	  public void click_home() { 
//		  AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
//		  getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		  AcquisitionHomePageMobile aquisitionHomePageReload =
//		  aquisitionhomepage.homeFooterClick();
//		  Assert.assertTrue("home page not found", aquisitionHomePageReload!= null); 
//	  }
	 	
	
	
	/**
	 * @toDo:user clicks on Request Assistance and validates modal window
	 */
	@And("^user clicks on Request Assistance and validates modal window ulayer$")
	public void user_clicks_on_Request_Assistance_and_validates_modal_window_ulayer() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickRequestAsistancce();
	}
	
	@When("^user accesses global header of the AARP Medicare Plans home page$")
	public void access_global_header_aarp() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateHeaderLinks();
		} else {
			Assert.fail("Home page not found");
		}
	}
	
	@When("^user verifies the AARP logo on home page$")
	public void user_verifies_the_AARP_logo_on_home_page() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateAARPlogo();		
	}

	@And("^user clicks on Sign in link on home page in aarp$")
	public void click_signIn_aarp() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.signInheader();		
	}
	
	@And("^user clicks on register link on home page in aarp$")
	public void click_register_aarp() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.headerRegisterLink();
	}
	
	@When("^user verifies and clicks on home link of agents&brokers page ulayer$")
	public void user_verifies_and_clicks_on_home_link_of_agents_brokers_page_ulayer() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePageMobile aquisitionHomePageReload = aquisitionhomepage.homeFooterClick();
		Assert.assertTrue("home page not found", aquisitionHomePageReload!= null);
	}

	@When("^user vaidates the state drop down link on home page$")
	public void user_vaidates_the_state_drop_down_link_on_home_page() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateStateDropDown();
	}

	@When("^user clicks on View all disclaimer information link on home page$")
	public void user_clicks_on_View_all_disclaimer_information_link_on_home_page() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateDisclaimer();
	}

	@When("^user verifies visit aarp\\.org link on home page ulayer$")
	public void user_verifies_visit_aarp_org_link_on_home_page_ulayer() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateVisitAarpOrglink();
	}

	@Then("^user clicks on back to top link on home page$")
	public void user_clicks_on_back_to_top_link_on_home_page() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.backToToplink();
	}
//	@Given("^the user navigates to following AARP medicare acquisition site page$")
//	public void the_user_navigates_to_following_AARP_medicare_acquisition_site_page(DataTable givenAttributes) throws Throwable {
//		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
//		Map<String, String> memberAttributesMap = new HashMap<String, String>();
//		for (int i = 0; i < memberAttributesRow.size(); i++) {
//			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
//					memberAttributesRow.get(i).getCells().get(1));
//		}
//		String path = memberAttributesMap.get("PagePath");
//		path = path.replace("!", "#");
//		System.out.print("Path to Acq page : "+path);
//		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
//				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		aquisitionhomepage.navigateToPath(path);
//	}
	/**
	 * @toDo:user accesses global footer
	 */
	@When("^user accesses global footer of the AARP Medicare Plans All page$")
	public void access_global_footer_aarp_all_pages() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateGlobalFooterLinks();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}

	@Then("^the USer validates Shop for a Plan Navigation links$")
	public void the_USer_validates_Shop_for_a_Plan_Navigation_links() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateSubNavShopPlanLinks();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}

	@Then("^the user validates Medicare Education Navigation links$")
	public void the_user_validates_Medicare_Education_Navigation_links() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateSubNavMedEdLinks();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}

	@Then("^the user validates TFN on page$") 
	public void the_user_validates_TFN_on_page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String tfnXpath = memberAttributesMap.get("TFNxpath");
		String tfnFlag = memberAttributesMap.get("TFNflag");

		//EnterZipCodePageMobile enterZipCodePage= new EnterZipCodePageMobile(driver);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(tfnFlag.equalsIgnoreCase("true")) {
			aquisitionhomepage.validateTFNelement(tfnXpath);
		}
	}
	@Then("^the user validate ZipCode Components on page using ZipCode \"([^\"]*)\"$") 
	public void the_user_validate_ZipCode_Components_on_page_using_ZipCode(String zipCode) throws Throwable {
		//EnterZipCodePageMobile enterZipCodePage= new EnterZipCodePageMobile(driver);
				AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
						.getBean(PageConstants.ACQUISITION_HOME_PAGE);
				EnterZipCodePage enterZipCodePage=aquisitionhomepage.enterZipCode();
				enterZipCodePage.validateZipComp(zipCode);
	}
	
	@Then("^the user enters and validate the fields and clicks on submit$")
	public void the_user_enters_and_validate_the_fields_and_clicks_on_submit() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.enterAndvalidateEmail();
	}
	
	@Then("^the user validates Pro-active Chat$")
	public void the_user_validates_Pro_active_Chat() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatProActive();
		aquisitionhomepage.validateProActiveChatpopup();	
		
	}

	@Then("^the user validates SAM Call Icon$")
	public void the_user_validates_SAM_Call_Icon() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSam();
		aquisitionhomepage.validateCallSamContent();
		aquisitionhomepage.validateCallpopup();	
	}

	@Then("^the user validates SAM re-active Chat$")
	public void the_user_validates_SAM_re_active_Chat() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatSam();
		aquisitionhomepage.validateChatSamContent();
		aquisitionhomepage.validateChatpopup();	
		
	}
	
	@Then("^user validates visitor profile on home page in aarp$")
	public void the_user_validates_visitor_profile_aarp() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validatevisitorprofile();
	}
	@Then("^the user validates chat Icon$")
	public void the_user_validates_chat_Icon() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatIcon();
	}
}
