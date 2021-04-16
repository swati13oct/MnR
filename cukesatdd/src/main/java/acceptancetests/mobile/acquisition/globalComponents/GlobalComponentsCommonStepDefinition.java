package acceptancetests.mobile.acquisition.globalComponents;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;
import pages.acquisition.commonpages.EnterZipCodePage;
import pages.acquisition.commonpages.AgentsnBrokersAARPPage;
import pages.acquisition.commonpages.ContactUsAARPPage;
import pages.acquisition.commonpages.DisclaimersAARPPage;
import pages.acquisition.commonpages.PrivacyPolicyAARPPage;
import pages.acquisition.commonpages.SiteMapAARPPage;
import pages.acquisition.commonpages.TermsnConditionsAARPPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.mobile.acquisition.commonpages.AboutUsAARPPageMobile;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.AgentsnBrokersAARPPageMobile;
import pages.mobile.acquisition.commonpages.ContactUsAARPPageMobile;
import pages.mobile.acquisition.commonpages.DisclaimersAARPPageMobile;
import pages.mobile.acquisition.commonpages.PrivacyPolicyAARPPageMobile;
import pages.mobile.acquisition.commonpages.SiteMapAARPPageMobile;
import pages.mobile.acquisition.commonpages.TermsnConditionsAARPPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.acquisition.commonpages.AboutUsAARPPage;
import pages.acquisition.commonpages.AcquisitionHomePage;



public class GlobalComponentsCommonStepDefinition {
	
	@Autowired
	MRScenario loginScenario;
	
	AppiumDriver wd;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@When("^user accesses global header of the Medicare Plans home page$")
	public void access_global_header_aarp() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateHeaderLinks();
		} else {
			Assert.fail("Home page not found");
		}
	}
	
	@When("^user accesses global footer of the Medicare Plans All page$")
	public void access_global_footer_aarp_all_pages() {

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateGlobalFooterLinks();
			//aquisitionhomepage.clickBrowserBackButton();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}
	
	@When("^user verifies the logo on home page$")
	public void user_verifies_the_AARP_logo_on_home_page() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateLogo();		
	}

	@And("^user clicks on Sign in link on home page$")
	public void click_signIn_aarp() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.signInheader();		
	}
	
	@And("^user clicks on register link on home page$")
	public void click_register_aarp() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.headerRegisterLink();
	}
	
	@Then("^user validates visitor profile on home page$")
	public void the_user_validates_visitor_profile_aarp() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		//aquisitionhomepage.MenuCrossMobile.click();
		
		aquisitionhomepage.validatevisitorprofile();
	}
	
	
	/* verify DCE flow from Ulayer home page hover over */
	@When("^I click on DCE Redesign link from Shop for a plan hover over$")
	public void i_click_on_DCE_Redesign_link_from_Shop_for_a_plan_hover_over_for_ums_site() {
		AcquisitionHomePageMobile acquisitionHomePage = (AcquisitionHomePageMobile) loginScenario
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acquisitionHomePage.MobileMenuAccessDCE();
		GetStartedPageMobile getStartedPage = acquisitionHomePage.navigateToDCERedesignFromSubNav();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assert.fail("DCE Redesign page object not loaded");
	}

//	@Given("^the user navigates to following medicare acquisition site page$")
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
	
	@Then("^the User validates Shop for a Plan Navigation link$")
	public void the_USer_validates_Shop_for_a_Plan_Navigation_links() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		if (aquisitionhomepage != null) {
			
			aquisitionhomepage.validateSubNavShopPlanLinks();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}
	
	@Then("^the user validates Medicare Education Navigation link$")
	public void the_user_validates_Medicare_Education_Navigation_links() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateSubNavMedEdLinks();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}
	
	@Then("^the user validates TFN on the page$") 
	public void the_user_validates_TFN_on_page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String tfnXpath = memberAttributesMap.get("TFNxpath");
		String tfnFlag = memberAttributesMap.get("TFNflag");

		//EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(tfnFlag.equalsIgnoreCase("true")) {
			aquisitionhomepage.validateTFNelement(tfnXpath);
		}
	}
	
	@Then("^the user validate ZipCode Components on the page using ZipCode \"([^\"]*)\"$") 
	public void the_user_validate_ZipCode_Components_on_page_using_ZipCode(String zipCode) throws Throwable {
		//EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
				AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
						.getBean(PageConstants.ACQUISITION_HOME_PAGE);
				pages.mobile.acquisition.commonpages.EnterZipCodePage enterZipCodePage=aquisitionhomepage.enterZipCode();
				enterZipCodePage.validateZipComp(zipCode);
	}
	
	@When("^user vaidates the state drop down link on the home page$")
	public void user_vaidates_the_state_drop_down_link_on_home_page() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateStateDropDown();
	}
	
	@When("^user clicks on View all disclaimer information link on the home page$")
	public void user_clicks_on_View_all_disclaimer_information_link_on_home_page() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateDisclaimer();
	}
	
	@When("^user verifies visit aarp.org link on home page$")
	public void user_verifies_visit_aarp_org_link_on_home_page_ulayer() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateVisitAarpOrglink();
	}
	
	@Then("^user clicks on back to top link of home page$")
	public void user_clicks_on_back_to_top_link_on_home_page() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.backToToplink();
	}
	
	
	
	
	@And("^user clicks on Aboutus link from footer of the Medicare Plans home page$")
	public void click_aboutus() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AboutUsAARPPageMobile aboutUsAARPPage = aquisitionhomepage.aboutUsFooterClick();
		if (aboutUsAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_ABOUT_US_PAGE, aboutUsAARPPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Aboutus page not found");
		}
	}
	

	@And("^user clicks on contactus link on aboutus page$")
	public void click_contactus() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ContactUsAARPPageMobile contactUsAARPPage = aquisitionhomepage.contactUsFooterClick();
		if (contactUsAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_Contact_US_PAGE, contactUsAARPPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("contactus page not found");
		}
	}

	
	@And("^user clicks on sitemap link on contactus page$")
	public void click_sitemap() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		SiteMapAARPPageMobile siteMapAARPPage = aquisitionhomepage.siteMapFooterClick();
		if(siteMapAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_SITE_MAP_PAGE,
					siteMapAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("sitemap page not found");
		}
	}
	

	@And("^user clicks on privacypolicy link on sitemap page$")
	public void click_privacypolicy() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PrivacyPolicyAARPPageMobile privacyPolicyAARPPage = aquisitionhomepage.privacypolicyFooterClick();
		if(privacyPolicyAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_PRIVACY_POLICY_PAGE,
					privacyPolicyAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("privacypolicy page not found");
		}
	}

	
	@And("^user clicks on termsOfuse link on privacypolicy page$")
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

	@And("^user clicks on disclaimers link on terms&conditions page$")
	public void click_disclaimers() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersAARPPageMobile disclaimersAARPPage = aquisitionhomepage.disclaimersFooterClick();
		if(disclaimersAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_DISCLAIMERS_PAGE,
					disclaimersAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("disclaimers page not found");
		}
	}

	@And("^user clicks on agents&brokers link on disclaimers page$")
	public void click_agentsnbrokers() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AgentsnBrokersAARPPageMobile agentsnBrokersAARPPage = aquisitionhomepage.agentsnbrokersFooterClick();
		if(agentsnBrokersAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_AGENTS_AND_BROKERS_PAGE,
					agentsnBrokersAARPPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("agents&brokers page not found");
		}
	}


	  @And("^user verifies home link of agents&brokers page$")
	  public void click_home() { 
		  AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
		  getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
		  AcquisitionHomePageMobile aquisitionHomePageReload =
		  aquisitionhomepage.homeFooterClick();
		  Assert.assertTrue("home page not found", aquisitionHomePageReload!= null); 
	  }

	  @And("^the user clicks on browser back button$")
	  public void click_browser_Back_Button() { 
		  AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)
		  getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
		  aquisitionhomepage.clickBrowserBackButton();
		  
	  }
	  
	  @Then("^the user clicks on Agent link and validates the correct URL is loaded from article page$")
		public void the_user_clicks_on_Agent_link_and_validates_the_correct_URL_is_loaded_from_articles_page(DataTable arg1)
				throws InterruptedException {
			Map<String, String> inputAttributesMap = parseInputArguments(arg1);
			String myUHCAgentURL = inputAttributesMap.get("UHC Agent URL");
			AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
					.getBean(PageConstants.ACQUISITION_HOME_PAGE);
			aquisitionhomepage.clickonFindanAgentlinkfromArticle(myUHCAgentURL);

		}
	  public Map<String, String> parseInputArguments(DataTable memberAttributes) {
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}
			return memberAttributesMap;
		}

		@Then("^the user validates TFN on need help section of Shop pages$")
		public void the_user_validates_TFN_on_need_help_section_of_Shop_pages(DataTable givenAttributes) throws Throwable {
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}
			String tfnXpath = memberAttributesMap.get("TFNxpath");
			String tfnFlag = memberAttributesMap.get("TFNflag");

			// EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
			AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
					.getBean(PageConstants.ACQUISITION_HOME_PAGE);
			if (tfnFlag.equalsIgnoreCase("true")) {
				aquisitionhomepage.validateTFNelement(tfnXpath);
			}

		}
		@Then("^the user validates TFN on right rail Medicare Article$")
		public void the_user_validates_TFN_on_right_rail_Medicare_article(DataTable givenAttributes) throws Throwable {
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}
			String tfnXpath = memberAttributesMap.get("TFNxpath");
			String tfnFlag = memberAttributesMap.get("TFNflag");

			// EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
			AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
					.getBean(PageConstants.ACQUISITION_HOME_PAGE);
			if (tfnFlag.equalsIgnoreCase("true")) {
				aquisitionhomepage.validateTFNelement(tfnXpath);
			}
		}

}

