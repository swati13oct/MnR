package acceptancetests.mobile.acquisition.globalComponents;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;
import pages.mobile.acquisition.commonpages.AboutUsAARPPageMobile;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.AgentsnBrokersAARPPageMobile;
import pages.mobile.acquisition.commonpages.ContactUsAARPPageMobile;
import pages.mobile.acquisition.commonpages.CostBasicsPageMobile;
import pages.mobile.acquisition.commonpages.CoverageChoicesPageMobile;
import pages.mobile.acquisition.commonpages.DisclaimersAARPPageMobile;
import pages.mobile.acquisition.commonpages.EnrollmentBasicsPageMobile;
import pages.mobile.acquisition.commonpages.LearnAboutMedicareHomePageMobile;
import pages.mobile.acquisition.commonpages.MedicareAdvantagePartCPlansPageMobile;
import pages.mobile.acquisition.commonpages.MedicareEligibilityPageMobile;
import pages.mobile.acquisition.commonpages.MedicarePrescriptionDrugPartDPlansPageMobile;
import pages.mobile.acquisition.commonpages.MedicareSupplementInsurancePlansPageMobile;
import pages.mobile.acquisition.commonpages.PrescriptionsProvidersBenefitsPageMobile;
import pages.mobile.acquisition.commonpages.PrivacyPolicyAARPPageMobile;
import pages.mobile.acquisition.commonpages.ProviderSearchPageMobile;
import pages.mobile.acquisition.commonpages.SiteMapAARPPageMobile;
import pages.mobile.acquisition.commonpages.TermsnConditionsAARPPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;


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
		AcquisitionHomePageMobile aquisitionhomepage  = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AboutUsAARPPageMobile aboutUsAARPPage = aquisitionhomepage.aboutUsFooterClick();
		if(aboutUsAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_ABOUT_US_PAGE,
					aboutUsAARPPage);
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

		
		
		
		
		@Then("^user select state for geotargeting from global footer of the Medicare Plans All page$")
		public void user_select_state_for_geotargeting() {
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			learnAboutMedicareHomePage.selectStateForGeotargeting();
		}

		@Then("^user check inner page links on the Medicare Education page$")
		public void user_check_inner_page_links(DataTable givenAttributes) {
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}
			String pageName = memberAttributesMap.get("PageName");

			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			learnAboutMedicareHomePage.checkInnerPageLinks(pageName);
		}

		@Then("^user clicks on Medicare Annual Enrollment Period Link and comes back$")
		public void user_clicks_on_Medicare_Annual_Enrollment_Period_Link() {
			PrescriptionsProvidersBenefitsPageMobile benefitsPage = (PrescriptionsProvidersBenefitsPageMobile) getLoginScenario()
					.getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
			benefitsPage.clickMedicareAnnualEnrollment();

		}

		@When("^the user navigates to Medicare Education Page from homepage$")
		public void user_navigates_to_Medicare_Education_Page_from_homepage() {
			AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
					.getBean(PageConstants.ACQUISITION_HOME_PAGE);
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = aquisitionhomepage.clickLearnMoreOnHomePage();
			if (learnAboutMedicareHomePage != null) {
				getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePage);
				System.out.println("Medicare Education Page opened");
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error in opening Medicare Education Page ");
			}
		}

		@Then("^the user navigates to Prescriptions, Providers and Benefits page$")
		public void the_user_navigates_to_Prescriptions_Providers_and_Benefits_page() {
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			PrescriptionsProvidersBenefitsPageMobile benefitsPage = learnAboutMedicareHomePage.selectBenifitsEducation();
			if (benefitsPage != null) {
				getLoginScenario().saveBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE, benefitsPage);
				System.out.println("Prescriptions, Providers and Benefits page loaded");
				Assert.assertTrue(true);
			} else {
				System.out.println("Prescriptions, Providers and Benefits page did not  loaded");
			}

		}

		@Then("^the user navigates to Medicare Cost Basic page$")
		public void the_user_navigates_to_Medicare_Cost_Basic_page() {
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			CostBasicsPageMobile costBasicsPage = learnAboutMedicareHomePage.navigatetoMedicareCostBasic();
			if (costBasicsPage != null) {
				getLoginScenario().saveBean(PageConstants.COST_BASICS_PAGE, costBasicsPage);
				System.out.println("Cost Basics page loaded");
				Assert.assertTrue(true);
			} else {
				System.out.println("Cost Basics page did not  loaded");
			}
		}

		@Then("^the user navigates to Medicare Eligibility page$")
		public void the_user_navigates_to_Medicare_Eligibility_page() {
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			MedicareEligibilityPageMobile eligibilityPage = learnAboutMedicareHomePage.selectMedicareEligibility();
			if (eligibilityPage != null) {
				getLoginScenario().saveBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE, eligibilityPage);
				System.out.println("Medicare Eligibility page loaded");
				Assert.assertTrue(true);
			} else {
				System.out.println("Medicare Eligibility Page did not loaded");
			}
		}

		@Then("^the user clicks on Coverage Choices link$")
		public void the_user_clicks_on_Coverage_Choices_link() {
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			CoverageChoicesPageMobile choicesPage = learnAboutMedicareHomePage.clickonCoverageChoicesLink();
			if (choicesPage != null) {
				getLoginScenario().saveBean(PageConstants.COVERAGE_CHOICE_PAGE, choicesPage);
				System.out.println("Coverage Choices page loaded");
				Assert.assertTrue(true);
			} else {
				System.out.println("Coverage Choices Page did not loaded");
			}

		}

		@Then("^user clicks on  Initial Enrollment Period Link and comes back$")
		public void user_clicks_on_Initial_Enrollment_Period_Link() {

			MedicareEligibilityPageMobile eligibilityPage = (MedicareEligibilityPageMobile) getLoginScenario()
					.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
			eligibilityPage.clickOnIEP();

		}

		@Then("^user checks the plan links on left rail of the page$")
		public void user_checks_the_plan_links_on_left_rail_of_the_page() {
			MedicareEligibilityPageMobile eligibilityPage = (MedicareEligibilityPageMobile) getLoginScenario()
					.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
			eligibilityPage.checkLeftRailPlanLinks("MA");
			eligibilityPage.checkLeftRailPlanLinks("MS");
			eligibilityPage.checkLeftRailPlanLinks("PDP");
		}

		@Then("^the user clicks on Coverage Choices link on Medicare Eligibility page$")
		public void the_user_clicks_on_Coverage_Choices_link_from_Med_Elegibility() {
			MedicareEligibilityPageMobile eligibilityPage = (MedicareEligibilityPageMobile) getLoginScenario()
					.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
			CoverageChoicesPageMobile choicesPage = eligibilityPage.clickonCoverageChoicesLink();
			if (choicesPage != null) {
				getLoginScenario().saveBean(PageConstants.COVERAGE_CHOICE_PAGE, choicesPage);
				System.out.println("Coverage Choices page loaded");
				Assert.assertTrue(true);
			} else {
				System.out.println("Coverage Choices Page did not loaded");
			}

		}

		@Then("^the user gather medicare info through video$")
		public void the_user_gather_medicare_info_through_video() {
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			learnAboutMedicareHomePage.clickToYoutubeVideo();

		}

		@Then("^the user click on video transcript link$")
		public void the_user_click_on_video_transcript_link() {
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			learnAboutMedicareHomePage.clickVideoTransciptLink();

		}

		@Then("^the user come back to Med-ed page$")
		public void the_user_come_back_to_Med_ed_page() {
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			learnAboutMedicareHomePage.backToMedEdPage();
		}

		@Then("^user clicks on  Medicare Part A and Part B Coverage dropdown$")
		public void user_check_coverage_dropdown() {
			CoverageChoicesPageMobile coverageChoicesPage = (CoverageChoicesPageMobile) getLoginScenario()
					.getBean(PageConstants.COVERAGE_CHOICE_PAGE);
			coverageChoicesPage.checkCoverageDropdownAB();

		}

		@Then("^user clicks on the plan dropdowns$")
		public void user_clicks_on_the_plan_dropdowns() {
			CoverageChoicesPageMobile coverageChoicesPage = (CoverageChoicesPageMobile) getLoginScenario()
					.getBean(PageConstants.COVERAGE_CHOICE_PAGE);
			coverageChoicesPage.checkPlanDropDowns();

		}

		@Then("^the user navigates through learn extra links on Cost Basic page$")
		public void user_navigates_extra_links() {
			CostBasicsPageMobile costBasicsPage = (CostBasicsPageMobile) getLoginScenario().getBean(PageConstants.COST_BASICS_PAGE);
			costBasicsPage.navigatesExtraLinks();
		}

		@Then("^the user check Medicare Savings Program link$")
		public void user_check_Medicare_saving_link() {
			CostBasicsPageMobile costBasicsPage = (CostBasicsPageMobile) getLoginScenario().getBean(PageConstants.COST_BASICS_PAGE);
			costBasicsPage.navigatesToMedicareSaving();
		}

		@Then("^the user click on next article link$")
		public void user_click_next_link() {
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			learnAboutMedicareHomePage.clickOnReadNextLink();
		}

		@Then("^the user navigates to plan information page$")
		public void user_navigates_to_plan(DataTable givenAttributes) {
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}
			String planType = memberAttributesMap.get("planType");
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			if (planType.equalsIgnoreCase("MA")) {
				MedicareAdvantagePartCPlansPageMobile MAplanPage = learnAboutMedicareHomePage.planSelectionMA();
				if (MAplanPage != null) {
					getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_PAGE, MAplanPage);
					getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
					Assert.assertTrue(true);
				} else {
					Assert.fail("MA plan page not loaded");
				}
			} else if (planType.equalsIgnoreCase("MS")) {
				MedicareSupplementInsurancePlansPageMobile MSplanPage = learnAboutMedicareHomePage.planSelectionMS();
				if (MSplanPage != null) {
					getLoginScenario().saveBean(PageConstants.MEDICARE_SUPPLEMENT_INSURANCE_PLANS_PAGE, MSplanPage);
					getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
					Assert.assertTrue(true);
				} else {
					Assert.fail("MS plan page not loaded");
				}
			} else if (planType.equalsIgnoreCase("PDP")) {
				MedicarePrescriptionDrugPartDPlansPageMobile PDPplanPage = learnAboutMedicareHomePage.planSelectionPDP();
				if (PDPplanPage != null) {

					getLoginScenario().saveBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_PAGE, PDPplanPage);
					getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
					Assert.assertTrue(true);
				} else {
					Assert.fail("PDP plan page not loaded");
				}
			}
		}

		@Then("^user click on see plan in your area link$")
		public void user_click_on_see_plan_in_your_area_link() {
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			learnAboutMedicareHomePage.clickOnSeePlanLink();
		}

		@Then("^the user navigates to Enrollment Basics Page$")
		public void the_user_navigates_to_Enrollment_Basics_Page() {

			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			EnrollmentBasicsPageMobile enrollmentBasicsPage = learnAboutMedicareHomePage.clickonEnrollmentBasicLink();
			if (enrollmentBasicsPage != null) {
				getLoginScenario().saveBean(PageConstants.ENROLLMENT_BASICS_PAGE, enrollmentBasicsPage);
			}

		}

		@Then("^the user check the inner links on Enrollment Basic Page$")
		public void check_the_inner_links_on_Enrollment_Basic() {
			EnrollmentBasicsPageMobile enrollmentBasicsPage = (EnrollmentBasicsPageMobile) getLoginScenario()
					.getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
			enrollmentBasicsPage.selectStateForGeotargeting();
			enrollmentBasicsPage.checkInnerLinks();
			enrollmentBasicsPage.clickSocialSecurity();
		}

		@Then("^the user check Social Security link on Enrollment Basic Page$")
		public void check_the_socaial_security_link_on_Enrollment_Basic() {
			EnrollmentBasicsPageMobile enrollmentBasicsPage = (EnrollmentBasicsPageMobile) getLoginScenario()
					.getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
			enrollmentBasicsPage.clickSocialSecurity();
		}

		@Then("^the user click on see all plan link on Enrollment Basic Page$")
		public void check_the_see_all_plan_link_on_Enrollment_Basic() {
			EnrollmentBasicsPageMobile enrollmentBasicsPage = (EnrollmentBasicsPageMobile) getLoginScenario()
					.getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
			enrollmentBasicsPage.clickSeePlans();
		}
		
		@Then("^the user clicks on Estimate Drug Costs Link from Benefit Page to land on DCE Redesign$")
		public void the_user_clicks_on_Estimate_Drug_Costs_Link_from_Benefit_page_to_land_on_DCE_Redesign()
				throws Throwable {
			PrescriptionsProvidersBenefitsPageMobile benefitsPage = (PrescriptionsProvidersBenefitsPageMobile) getLoginScenario()
					.getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);

			GetStartedPageMobile getStartedPage = benefitsPage.clickDCERedesignLinkonMedEdPage();
			if (null != getStartedPage) {
				getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
			} else
				Assert.fail("DCE Redesign page object not loaded");
		}

		@Then("the user click on return to MEdEd page from Get Started Page")
		public void user_click_to_return_to_MedEd_page() {
			GetStartedPageMobile getStartedPage = (GetStartedPageMobile) getLoginScenario()
					.getBean(PageConstants.DCE_Redesign_GetStarted);
			PrescriptionsProvidersBenefitsPageMobile benefitsPage = getStartedPage.clickReturnToAcqHomePAge();
			if (null != benefitsPage) {
				getLoginScenario().saveBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE, benefitsPage);
			} else
				Assert.fail("Benefit Page not loaded");
		}
		
		@When("^the user click on Provider Search on the Benefit Page$")
		public void providerSearch_details_in_aarp_site_from_BenefitPage() {
			
			PrescriptionsProvidersBenefitsPageMobile benefitsPage= (PrescriptionsProvidersBenefitsPageMobile)getLoginScenario().getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
			
			ProviderSearchPageMobile providerSearchPage = benefitsPage.clicksOnRallyToolFromMedEdPage();

			if (providerSearchPage != null) {
				getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
			} else {
				Assert.fail("Error Loading Rally tool from Home Page");
			}
		}
		
		@Then("user go back to MedEd page from Rally tool")
		public void user_go_back_to_MedEd_page() {  
			ProviderSearchPageMobile  providerSearchPage  = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			
			AcquisitionHomePageMobile acquisitionHomePage=providerSearchPage.returnToAcqHomePage();
		
		}

		@Then("^the user check Still have a question$")
		public void the_user_check_Still_have_a_question() {
			LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
					.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
			learnAboutMedicareHomePage.chechStillHaveQues();
		}

}

