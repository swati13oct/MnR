package acceptancetests.acquisition.globalcomponents;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.GlobalBeforeHook;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.acquisition.commonpages.AboutUsAARPPage;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.AgentsnBrokersAARPPage;
import pages.acquisition.commonpages.ContactUsAARPPage;
import pages.acquisition.commonpages.CostBasicsPage;
import pages.acquisition.commonpages.CoverageChoicesPage;
import pages.acquisition.commonpages.DisclaimersAARPPage;
import pages.acquisition.commonpages.EnrollmentBasicsPage;
import pages.acquisition.commonpages.EnterZipCodePage;
import pages.acquisition.commonpages.LearnAboutMedicareHomePage;
import pages.acquisition.commonpages.MedicareAdvantagePartCPlansPage;
import pages.acquisition.commonpages.MedicareEligibilityPage;
import pages.acquisition.commonpages.MedicarePrescriptionDrugPartDPlansPage;
import pages.acquisition.commonpages.MedicareSupplementInsurancePlansPage;
import pages.acquisition.commonpages.MultiCountyModalPage;
import pages.acquisition.commonpages.PrescriptionsProvidersBenefitsPage;
import pages.acquisition.commonpages.PrivacyPolicyAARPPage;
import pages.acquisition.commonpages.SiteMapAARPPage;
import pages.acquisition.commonpages.TermsnConditionsAARPPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;


public class GlobalComponentsCommonStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	private Scenario scenario;
	
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@When("^user accesses global header of the Medicare Plans home page$")
	public void access_global_header_aarp() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateHeaderLinks();
		} else {
			Assertion.fail("Home page not found");
		}
	}

	@Given("^the user is on medicare acquisition site landing page$")
	public void the_user_on__medicare_acquisition_Site(DataTable givenAttributes) {
		
		scenario.log("Sai - 06/15------Need to remove  line 100 later");
		WebDriver wd = getLoginScenario().getWebDriverNew();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String site = memberAttributesMap.get("Site");
		//AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, site);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().openApplicationURL(wd, site);
		if(aquisitionhomepage.returnCookieValue()!= null)
			scenario.log(aquisitionhomepage.returnCookieValue());
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);
		
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, null);
		getLoginScenario().saveBean(DCERedesignCommonConstants.YOUPAYLIST_ALLDRUGS, null);
		if("BLayer".equalsIgnoreCase(site) || site.equalsIgnoreCase("UHC") || site.equalsIgnoreCase("UMS"))
			getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, "UHC_ACQ");
		else
			getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, "AARP_ACQ");

		if (!(MRScenario.environment.equalsIgnoreCase("team-acme"))){
				
				//aquisitionhomepage.validateSubtitle();
		//}
			
		if (MRScenario.environment.equalsIgnoreCase("offline") ||  MRScenario.environment.equalsIgnoreCase("offline-prod") || MRScenario.environment.equalsIgnoreCase("prod")){
			aquisitionhomepage.handleSurveyPopup();
		}
		if (site.equalsIgnoreCase("AARP")) 
		aquisitionhomepage.validateSubtitle();
		}
	}
	

	@When("^user accesses global footer of the Medicare Plans All page$")
	public void access_global_footer_aarp_all_pages() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateGlobalFooterLinks();
		} else {
			Assertion.fail("Home Page not Loading");
		}
	}

	@When("^user verifies the logo$")
	public void user_verifies_the_AARP_logo_on_home_page() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateLogo();
	}

	@And("^user clicks on Sign in link$")
	public void click_signIn_aarp() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.signInheader();
	}

	@And("^user clicks on register link$")
	public void click_register_aarp() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.headerRegisterLink();
	}

	@Then("^user validates visitor profile$")
	public void the_user_validates_visitor_profile_aarp() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validatevisitorprofile();
	}

	@Then("^user validates Subtitle$")
	public void user_validates_Subtitle(DataTable givenAttributes) throws Throwable {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String site = memberAttributesMap.get("Site");
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, site);
		if (site.equalsIgnoreCase("AARP")) {
			aquisitionhomepage.validateSubtitle();
		}
	}

	@Given("^the user navigates to following medicare acquisition site page$")
	public void the_user_navigates_to_following_medicare_acquisition_site_page(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : " + path);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPath(path);
	}

	@Then("^user validates the url for Medicare Supplement Insurance Plans$")
	public void user_validate_the_geotag_and_Medicare_supplement_url(DataTable givenAttributes) throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String state = memberAttributesMap.get("State");
		String code = memberAttributesMap.get("Code");
		String classic = memberAttributesMap.get("ClassicUrl");
		String generic = memberAttributesMap.get("GenericUrl");
		aquisitionhomepage.validateMedupsStateUrl(state,code,classic,generic);
	}
	
	@Then("^the User validates Shop for a Plan Navigation link$")
	public void the_USer_validates_Shop_for_a_Plan_Navigation_links() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateSubNavShopPlanLinks();
		} else {
			Assertion.fail("Home Page not Loading");
		}
	}

	@Then("^the user validates Medicare Education Navigation link$")
	public void the_user_validates_Medicare_Education_Navigation_links() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateSubNavMedEdLinks();
		} else {
			Assertion.fail("Home Page not Loading");
		}
	}

	@Then("^the user validates TFN on page$")
	public void the_user_validates_TFN_on_page(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String tfnXpath = memberAttributesMap.get("TFNxpath");
		String tfnFlag = memberAttributesMap.get("TFNflag");

		// EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (tfnFlag.equalsIgnoreCase("true")) {
			aquisitionhomepage.validateTFNelement(tfnXpath);
		}
	}

	@Then("^the user validate ZipCode Components on page using ZipCode \"([^\"]*)\"$")
	public void the_user_validate_ZipCode_Components_on_page_using_ZipCode(String zipCode) throws Throwable {
		// EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		EnterZipCodePage enterZipCodePage = aquisitionhomepage.enterZipCode();
		enterZipCodePage.validateZipComp(zipCode);
	}

	@Then("^the user enters and validate the fields and clicks on submit$")
	public void the_user_enters_and_validate_the_fields_and_clicks_on_submit() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.enterAndvalidateEmail();
	}

	@When("^user updates the state drop down value on the home page$")
	public void user_vaidates_the_state_drop_down_link_on_home_page(DataTable givenAttributes) throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String state = memberAttributesMap.get("State");
		String code = memberAttributesMap.get("Code");
		aquisitionhomepage.validatestatedropDown(state,code);
		getLoginScenario().saveBean(CommonConstants.STATE_SELECTED, state);
	}

	@When("^user clicks on View all disclaimer information link on the home page$")
	public void user_clicks_on_View_all_disclaimer_information_link_on_home_page() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateDisclaimer();
	}

	@When("^user verifies visit aarp\\.org link on home page$")
	public void user_verifies_visit_aarp_org_link_on_home_page_ulayer() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateVisitAarpOrglink();
	}

	@Then("^user clicks on back to top link of home page$")
	public void user_clicks_on_back_to_top_link_on_home_page() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.backToToplink();
	}

	/**
	 * @toDo:user clicks on Aboutus link from footer
	 */
	@And("^user clicks on Aboutus link from footer of the Medicare Plans home page$")
	public void click_aboutus() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AboutUsAARPPage aboutUsAARPPage = aquisitionhomepage.aboutUsFooterClick();
		if (aboutUsAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_ABOUT_US_PAGE, aboutUsAARPPage);
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Aboutus page not found");
		}
	}

	/**
	 * @toDo:user clicks on contactus link of aboutus
	 */
	@And("^user clicks on contactus link on aboutus page$")
	public void click_contactus() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ContactUsAARPPage contactUsAARPPage = aquisitionhomepage.contactUsFooterClick();
		if (contactUsAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_Contact_US_PAGE, contactUsAARPPage);
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("contactus page not found");
		}
	}

	/**
	 * @toDo:user clicks on sitemap link of contactus
	 */
	@And("^user clicks on sitemap link on contactus page$")
	public void click_sitemap() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		SiteMapAARPPage siteMapAARPPage = aquisitionhomepage.siteMapFooterClick();
		if (siteMapAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_SITE_MAP_PAGE, siteMapAARPPage);

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("sitemap page not found");
		}
	}

	/**
	 * @toDo:user clicks on privacypolicy link of sitemap
	 */
	@And("^user clicks on privacypolicy link on sitemap page$")
	public void click_privacypolicy() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PrivacyPolicyAARPPage privacyPolicyAARPPage = aquisitionhomepage.privacypolicyFooterClick();
		if (privacyPolicyAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_PRIVACY_POLICY_PAGE, privacyPolicyAARPPage);

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("privacypolicy page not found");
		}
	}

	/**
	 * @toDo:user clicks on termsOfuse link of privacypolicy
	 */
	@And("^user clicks on termsOfuse link on privacypolicy page$")
	public void click_termsnconditions() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		TermsnConditionsAARPPage termsnConditionsAARPPage = aquisitionhomepage.termsnconditionsFooterClick();
		if (termsnConditionsAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_TERMS_AND_CONDITIONS_PAGE, termsnConditionsAARPPage);

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("terms&conditions page not found");
		}
	}

	/**
	 * @toDo:user clicks on disclaimers link of terms&conditions
	 */
	@And("^user clicks on disclaimers link on terms&conditions page$")
	public void click_disclaimers() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersAARPPage disclaimersAARPPage = aquisitionhomepage.disclaimersFooterClick();
		if (disclaimersAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_DISCLAIMERS_PAGE, disclaimersAARPPage);

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("disclaimers page not found");
		}
	}

	/**
	 * @toDo:user clicks on agents&brokers link of disclaimers
	 */
	@And("^user clicks on agents&brokers link on disclaimers page$")
	public void click_agentsnbrokers() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AgentsnBrokersAARPPage agentsnBrokersAARPPage = aquisitionhomepage.agentsnbrokersFooterClick();
		if (agentsnBrokersAARPPage != null) {
			getLoginScenario().saveBean(PageConstants.AARP_AGENTS_AND_BROKERS_PAGE, agentsnBrokersAARPPage);

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("agents&brokers page not found");
		}
	}

	/**
	 * @toDo:user clicks on home link of agents&brokers
	 */

	@And("^user verifies home link of agents&brokers page$")
	public void click_home() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AcquisitionHomePage aquisitionHomePageReload = aquisitionhomepage.homeFooterClick();

//		  Assertion.assertTrue("home page not found", aquisitionHomePageReload!= null); 
	}

	@And("^the user clicks on browser back button$")
	public void click_browser_Back_Button() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickBrowserBackButton();

	}

	@And("^the user closes the new browser tab$")
	public void closes_new_browser_tab() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.closeBrowserTab();

	}

	@And("^user clicks on visit aarp.org link in the header$")
	public void click_visitAARP_Link_in_the_header() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickVisitAARPHeaderLink();

	}
	
	@And("^user clicks on visit aarp.org link in the header for cancel$")
	public void click_visitAARP_Link_in_the_header_for_cancel() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickVisitAARPHeaderLinkforcancel();

	}

//	  @And("^user clicks on visit aarp.org link in the header$")
//	  public void click_visitAARP_Link_in_the_header() { 
//		  AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario() .getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		  aquisitionhomepage.clickVisitAARPHeaderLink();
//		  
//	  }
//	  
	@And("^user clicks on visit aarp.org link in the footer$")
	public void click_visitAARP_Link_in_the_footer() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickVisitAARPFooterLink();
	}

//@Then("^the user validates whether sam call value is displayed on the page$")
//public void the_user_validates_whether_TFN_is_displayed_on_the_page() throws Throwable {
//	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
//			.getBean(PageConstants.ACQUISITION_HOME_PAGE);
//	aquisitionhomepage.validateCallSamValue();

//}

	@When("^the user clicks on Medicare Advantage Plans Link$")
	public void the_user_clicks_on_Medicare_Advantage_Plans_Link() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.MedicareAdvantagePlans();

	}

	@When("^the user clicks on Dual Special Needs Plans Link$")
	public void the_user_clicks_on_Dual_Special_Needs_Plans_Link() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.DualSplNeedPlans();
	}

	@When("^the user clicks on Medicare Supplement Insurance Plans Link$")
	public void the_user_clicks_on_Medicare_Supplement_Insurance_Plans_Link() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.Medicaresupplementinsuranceplans();
	}

	@When("^the user clicks on Medicare Prescription Drug Plans Link$")
	public void the_user_clicks_on_Medicare_Prescription_Drug_Plans_Link() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.MedicarePrescriptionDrugPlans();
	}

	@When("^the user clicks on Medicare Education Link$")
	public void the_user_clicks_on_Medicare_Education_Link() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.MedicareEducation();
	}

	@When("^the user clicks on Back to top Link$")
	public void the_user_clicks_on_Back_to_top_Link() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.backtotop();
	}

	@When("^the user clicks on Accessibility Link$")
	public void the_user_clicks_on_Accessibility_Link() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.Accessibility();
	}

	@Then("^user select state for geotargeting from global footer of the Medicare Plans All page$")
	public void user_select_state_for_geotargeting() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.selectStateForGeotargeting();
	}

	@Then("^user check inner page links on the Medicare Education page$")
	public void user_check_inner_page_links(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String pageName = memberAttributesMap.get("PageName");

		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.checkInnerPageLinks(pageName);
	}

	@Then("^user clicks on Medicare Annual Enrollment Period Link and comes back$")
	public void user_clicks_on_Medicare_Annual_Enrollment_Period_Link() {
		PrescriptionsProvidersBenefitsPage benefitsPage = (PrescriptionsProvidersBenefitsPage) getLoginScenario()
				.getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
		benefitsPage.clickMedicareAnnualEnrollment();

	}

	@When("^the user navigates to Medicare Education Page from homepage$")
	public void user_navigates_to_Medicare_Education_Page_from_homepage() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = aquisitionhomepage.clickLearnMoreOnHomePage();
		if (learnAboutMedicareHomePage != null) {
			getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePage);
			System.out.println("Medicare Education Page opened");
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Error in opening Medicare Education Page ");
		}
	}

	@Then("^the user navigates to Prescriptions, Providers and Benefits page$")
	public void the_user_navigates_to_Prescriptions_Providers_and_Benefits_page() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		PrescriptionsProvidersBenefitsPage benefitsPage = learnAboutMedicareHomePage.selectBenifitsEducation();
		if (benefitsPage != null) {
			getLoginScenario().saveBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE, benefitsPage);
			System.out.println("Prescriptions, Providers and Benefits page loaded");
			Assertion.assertTrue(true);
		} else {
			System.out.println("Prescriptions, Providers and Benefits page did not  loaded");
		}

	}

	@Then("^the user navigates to Medicare Cost Basic page$")
	public void the_user_navigates_to_Medicare_Cost_Basic_page() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		CostBasicsPage costBasicsPage = learnAboutMedicareHomePage.navigatetoMedicareCostBasic();
		if (costBasicsPage != null) {
			getLoginScenario().saveBean(PageConstants.COST_BASICS_PAGE, costBasicsPage);
			System.out.println("Cost Basics page loaded");
			Assertion.assertTrue(true);
		} else {
			System.out.println("Cost Basics page did not  loaded");
		}
	}

	@Then("^the user navigates to Medicare Eligibility page$")
	public void the_user_navigates_to_Medicare_Eligibility_page() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		MedicareEligibilityPage eligibilityPage = learnAboutMedicareHomePage.selectMedicareEligibility();
		if (eligibilityPage != null) {
			getLoginScenario().saveBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE, eligibilityPage);
			System.out.println("Medicare Eligibility page loaded");
			Assertion.assertTrue(true);
		} else {
			System.out.println("Medicare Eligibility Page did not loaded");
		}
	}

	@Then("^the user clicks on Coverage Choices link$")
	public void the_user_clicks_on_Coverage_Choices_link() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		CoverageChoicesPage choicesPage = learnAboutMedicareHomePage.clickonCoverageChoicesLink();
		if (choicesPage != null) {
			getLoginScenario().saveBean(PageConstants.COVERAGE_CHOICE_PAGE, choicesPage);
			System.out.println("Coverage Choices page loaded");
			Assertion.assertTrue(true);
		} else {
			System.out.println("Coverage Choices Page did not loaded");
		}

	}

	@Then("^user clicks on  Initial Enrollment Period Link and comes back$")
	public void user_clicks_on_Initial_Enrollment_Period_Link() {

		MedicareEligibilityPage eligibilityPage = (MedicareEligibilityPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
		eligibilityPage.clickOnIEP();

	}

	@Then("^user checks the plan links on left rail of the page$")
	public void user_checks_the_plan_links_on_left_rail_of_the_page() {
		MedicareEligibilityPage eligibilityPage = (MedicareEligibilityPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
		eligibilityPage.checkLeftRailPlanLinks("MA");
		eligibilityPage.checkLeftRailPlanLinks("MS");
		eligibilityPage.checkLeftRailPlanLinks("PDP");
	}

	@Then("^the user clicks on Coverage Choices link on Medicare Eligibility page$")
	public void the_user_clicks_on_Coverage_Choices_link_from_Med_Elegibility() {
		MedicareEligibilityPage eligibilityPage = (MedicareEligibilityPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
		CoverageChoicesPage choicesPage = eligibilityPage.clickonCoverageChoicesLink();
		if (choicesPage != null) {
			getLoginScenario().saveBean(PageConstants.COVERAGE_CHOICE_PAGE, choicesPage);
			System.out.println("Coverage Choices page loaded");
			Assertion.assertTrue(true);
		} else {
			System.out.println("Coverage Choices Page did not loaded");
		}

	}

	@Then("^the user gather medicare info through video$")
	public void the_user_gather_medicare_info_through_video() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.clickToYoutubeVideo();

	}

	@Then("^the user click on video transcript link$")
	public void the_user_click_on_video_transcript_link() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.clickVideoTransciptLink();

	}

	@Then("^the user come back to Med-ed page$")
	public void the_user_come_back_to_Med_ed_page() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.backToMedEdPage();
	}

	@Then("^user clicks on  Medicare Part A and Part B Coverage dropdown$")
	public void user_check_coverage_dropdown() {
		CoverageChoicesPage coverageChoicesPage = (CoverageChoicesPage) getLoginScenario()
				.getBean(PageConstants.COVERAGE_CHOICE_PAGE);
		coverageChoicesPage.checkCoverageDropdownAB();

	}

	@Then("^user clicks on the plan dropdowns$")
	public void user_clicks_on_the_plan_dropdowns() {
		CoverageChoicesPage coverageChoicesPage = (CoverageChoicesPage) getLoginScenario()
				.getBean(PageConstants.COVERAGE_CHOICE_PAGE);
		coverageChoicesPage.checkPlanDropDowns();

	}

	@Then("^the user navigates through learn extra links on Cost Basic page$")
	public void user_navigates_extra_links() {
		CostBasicsPage costBasicsPage = (CostBasicsPage) getLoginScenario().getBean(PageConstants.COST_BASICS_PAGE);
		costBasicsPage.navigatesExtraLinks();
	}

	@Then("^the user check Medicare Savings Program link$")
	public void user_check_Medicare_saving_link() {
		CostBasicsPage costBasicsPage = (CostBasicsPage) getLoginScenario().getBean(PageConstants.COST_BASICS_PAGE);
		costBasicsPage.navigatesToMedicareSaving();
	}

	@Then("^the user click on next article link$")
	public void user_click_next_link() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.clickOnReadNextLink();
	}

	@Then("^the user navigates to plan information page$")
	public void user_navigates_to_plan(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String planType = memberAttributesMap.get("planType");
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		if (planType.equalsIgnoreCase("MA")) {
			MedicareAdvantagePartCPlansPage MAplanPage = learnAboutMedicareHomePage.planSelectionMA();
			if (MAplanPage != null) {
				getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_PAGE, MAplanPage);
				getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
				Assertion.assertTrue(true);
			} else {
				Assertion.fail("MA plan page not loaded");
			}
		} else if (planType.equalsIgnoreCase("MS")) {
			MedicareSupplementInsurancePlansPage MSplanPage = learnAboutMedicareHomePage.planSelectionMS();
			if (MSplanPage != null) {
				getLoginScenario().saveBean(PageConstants.MEDICARE_SUPPLEMENT_INSURANCE_PLANS_PAGE, MSplanPage);
				getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
				Assertion.assertTrue(true);
			} else {
				Assertion.fail("MS plan page not loaded");
			}
		} else if (planType.equalsIgnoreCase("PDP")) {
			MedicarePrescriptionDrugPartDPlansPage PDPplanPage = learnAboutMedicareHomePage.planSelectionPDP();
			if (PDPplanPage != null) {

				getLoginScenario().saveBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_PAGE, PDPplanPage);
				getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
				Assertion.assertTrue(true);
			} else {
				Assertion.fail("PDP plan page not loaded");
			}
		}
	}

	@Then("^user click on see plan in your area link$")
	public void user_click_on_see_plan_in_your_area_link() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.clickOnSeePlanLink();
	}

	@Then("^the user navigates to Enrollment Basics Page$")
	public void the_user_navigates_to_Enrollment_Basics_Page() {

		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		EnrollmentBasicsPage enrollmentBasicsPage = learnAboutMedicareHomePage.clickonEnrollmentBasicLink();
		if (enrollmentBasicsPage != null) {
			getLoginScenario().saveBean(PageConstants.ENROLLMENT_BASICS_PAGE, enrollmentBasicsPage);
		}

	}

	@Then("^the user check the inner links on Enrollment Basic Page$")
	public void check_the_inner_links_on_Enrollment_Basic() {
		EnrollmentBasicsPage enrollmentBasicsPage = (EnrollmentBasicsPage) getLoginScenario()
				.getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
		enrollmentBasicsPage.checkInnerLinks();
	}

	@Then("^the user check Social Security link on Enrollment Basic Page$")
	public void check_the_socaial_security_link_on_Enrollment_Basic() {
		EnrollmentBasicsPage enrollmentBasicsPage = (EnrollmentBasicsPage) getLoginScenario()
				.getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
		enrollmentBasicsPage.clickSocialSecurity();
	}

	@Then("^the user click on see all plan link on Enrollment Basic Page$")
	public void check_the_see_all_plan_link_on_Enrollment_Basic() {
		EnrollmentBasicsPage enrollmentBasicsPage = (EnrollmentBasicsPage) getLoginScenario()
				.getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
		enrollmentBasicsPage.clickSeePlans();
	}

	@Then("^the user hover over and select plan page link$")
	public void the_user_hover_over_and_select_MS_plan_page_link(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String plantype = memberAttributesMap.get("nextplanType");
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.hoverToPlanPage(plantype);
	}

	@Then("^the user hover over Shop for a Plan and validates zipcode component$")
	public void the_user_hover_over_Shop_for_a_Plan_and_validates_zipcode_component() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage.checkZipCompErrorInSubNav() == true) {
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Zip Component not present or Error msg not shown");
	}

	@Then("^the user validate ZipCode Components on SubNav using ZipCode \"([^\"]*)\"$")
	public void the_user_enter_zipcode_and_go_to_Plan_Summary_Page(String zipCode) {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage vppPlanSummaryPage = aquisitionhomepage.checkZipCompSubNavVpp(zipCode);
		if (vppPlanSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppPlanSummaryPage);
			System.out.println("Vpp Plan Summary Page opened Successfully");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error Loading in VPP Plan Summary Page");

	}

	@Then("^the user check Still have a question$")
	public void the_user_check_Still_have_a_question() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.chechStillHaveQues();
	}

	@Then("^the user clicks on View all disclaimer information link in footer$")
	public void clicks_on_View_all_disclaimer_information_link() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickViewDisclaimerInfoLink();
	}

	@Then("^the user validate links in disclaimer information section$")
	public void the_user_validate_links_in_disclaimer_information_section() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.checkLinkContact("english");
		aquisitionhomepage.checkLinkContact("spanish");
		aquisitionhomepage.checkLinkContact("chinese");

	}

	@Then("^the user clicks on Hide all disclaimer information link in footer$")
	public void clicks_on_Hide_all_disclaimer_information_link() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickHideDisclaimerInfoLink();
	}

	@Then("^the user clicks on Complaint Form link in footer$")
	public void the_user_clicks_on_Complaint_Form_link() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickComplaintFormLink();
	}

	@Then("^user select state for geotargeting from global footer on homepage$")
	public void user_select_state_for_geotargeting_on_homepage() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.selectStateForGeotargeting();
	}

	@Then("^the user validates Language assistance links$")
	public void the_user_validates_Language_assistance_links() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateAssistancelink("English");
		aquisitionhomepage.validateAssistancelink("Spanish");
		aquisitionhomepage.validateAssistancelink("Chinese");
	}

	@Then("^the user validates TFN on right rail Medicare Article$")
	public void the_user_validates_TFN_on_right_rail_Medicare_article(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String tfnXpath = memberAttributesMap.get("TFNxpath");
		String tfnFlag = memberAttributesMap.get("TFNflag");

		// EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (tfnFlag.equalsIgnoreCase("true")) {
			aquisitionhomepage.validateTFNelement(tfnXpath);
		}
	}

	@Then("^the user validates TFN on need help section of Shop pages$")
	public void the_user_validates_TFN_on_need_help_section_of_Shop_pages(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String tfnXpath = memberAttributesMap.get("TFNxpath");
		String tfnFlag = memberAttributesMap.get("TFNflag");

		// EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (tfnFlag.equalsIgnoreCase("true")) {
			aquisitionhomepage.validateTFNelement(tfnXpath);
		}

	}

	@Then("^the user validate ZipCode Components on the page using ZipCode \"([^\"]*)\"$")
	public void the_user_validate_ZipCode_Components_on_the_page_using_ZipCode(String zipCode) throws Throwable {
		// EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		EnterZipCodePage enterZipCodePage = aquisitionhomepage.enterZipCode();
		enterZipCodePage.validateZipComp(zipCode);
	}

	@Then("^the user validates TFN on the page$")
	public void the_user_validates_TFN_on_the_page(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String tfnXpath = memberAttributesMap.get("TFNxpath");
		String tfnFlag = memberAttributesMap.get("TFNflag");

		// EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (tfnFlag.equalsIgnoreCase("true")) {
			aquisitionhomepage.validateTFNelement(tfnXpath);
		}
	}

	@Then("^the user clicks on Agent link and validates the correct URL is loaded from article page$")
	public void the_user_clicks_on_Agent_link_and_validates_the_correct_URL_is_loaded_from_articles_page(DataTable arg1)
			throws InterruptedException {
		Map<String, String> inputAttributesMap = parseInputArguments(arg1);
		String myUHCAgentURL = inputAttributesMap.get("UHC Agent URL");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickonFindanAgentlinkfromArticle(myUHCAgentURL);

	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(memberAttributes);
		/*List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		return memberAttributesMap;
	}

	@Then("^user should be navigated to the previous page$")
	public void user_should_be_navigated_to_the_previous_page(DataTable givenAttributes) throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String path = memberAttributesMap.get("PagePath");
		aquisitionhomepage.validatePageNavigated(path);
	}
	
	@Given("^the user hovers over the learn about medicare$")
	public void the_user_hovers_screen_over_the_learnaboutmedicare() throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = acqusitionHomePage.HoveronaLearnMedicare();
		if (learnAboutMedicareHomePage != null) {
			System.out.println("learn about medicare drop down is opened");
			getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePage);
		} else {
			Assert.fail("Issue in selecting a learn about medicare drop down");
		}
	}
		
	@When("^user click on \"([^\"]*)\" link under learn about medicare$")
	public void user_click_on_link_under_learn_about_medicare(String linkName) throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.clickLearnAboutMedicareNavLink(linkName);
		getLoginScenario().saveBean(CommonConstants.LEARNABOUTMEDICARE_LINK, linkName);
	}

	@Then("^user should be navigated to respective medicare education page$")
	public void user_should_be_navigated_to_medicare_education_page() throws Throwable {
		String linkName=(String) getLoginScenario().getBean(CommonConstants.LEARNABOUTMEDICARE_LINK);
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.validateLearnAboutMedicareLinkNavigation(linkName);
	}
	
	@Then("^user enter email and submit in email section$")
	public void user_enter_email_and_submit_in_email_section() throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.validateLearnAboutMedicareEmailSection();
	}
	
	@Then("^the message \"([^\"]*)\" should be displayed in email section$")
	public void the_message_should_be_displayed_in_email_section(String expectedMsg) throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.validateEmailSubmissionMessage(expectedMsg);
	}

	@Then("^the user click on Get a Plan Recommendation Button and gets back to medicare articles page$")
	public void theuserclickonGetaPlanRecommendationButtonandgetsback() throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.clickOnPlanRecommendationButton();
	}
	
	@When("^user click on \"([^\"]*)\" link under shop plans$")
	public void user_click_on_link_under_shop_plan(String linkName) throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.clickFooterLinks(linkName);
		getLoginScenario().saveBean(CommonConstants.FOOTER_LINK, linkName);
	}
	
	@When("^user click on \"([^\"]*)\" link under Tools & Resources$")
	public void user_click_on_link_under_tools(String linkName) throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.clickFooterLinks(linkName);
		getLoginScenario().saveBean(CommonConstants.FOOTER_LINK, linkName);
	}
	
	@When("^user click on \"([^\"]*)\" link under Learn About Medicare$")
	public void user_click_on_link_under_Learn_About_Medicare(String linkName) throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.clickFooterLinks(linkName);
		getLoginScenario().saveBean(CommonConstants.FOOTER_LINK, linkName);
	}
	
	@When("^user click on \"([^\"]*)\" link under more$")
	public void user_click_on_link_under_more(String linkName) throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.clickFooterLinks(linkName);
		getLoginScenario().saveBean(CommonConstants.FOOTER_LINK, linkName);
	}
	
	@Then("^user should be navigated to respective footer links page$")
	public void user_should_be_navigated_to_footer_links_page() throws Throwable {
		String linkName=(String) getLoginScenario().getBean(CommonConstants.FOOTER_LINK);
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		acqusitionHomePage.validateFooterLinksNavigation(linkName);
	}
	
	@When("^user hover over for plan member to click to go to member site$")
	public void hover_plan_Member_to_Click_membersite() {
		scenario.log("Changes made on 6/30- Step added for new Header redesign");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.clickMemberSiteLink();
		} else {
			Assertion.fail("Home page not found");
		}
	}
	
	@When("user validates TFN in header")
	public void user_clicks_on_tfn_in_header() throws InterruptedException {
		scenario.log("Changes made on 7/06- Step added for new Header redesign");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateTfnInHeader();
	}


	@Then("^the user validate facebook button from social share$")
	public void the_user_validate_facebook_button_from_social_share(){
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickOnFacebookShareButton();
	}

	@Then("^the user validate twitter button from social share$")
	public void the_user_validate_twitter_button_from_social_share(){
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickOnTwitterShareButton();
	}


	@Then("^the user validate email button from social share$")
	public void the_user_validate_email_button_from_social_share(){
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateSocialShareEmailButton();
	}

	//Redesigned home page
	
	@When("user enters zipcode and navigates to VPP")
	public void user_enters_zipcode_and_navigates_to_vpp() throws AWTException {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage=aquisitionhomepage.enterAndValidateZipCode();
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	    
	}
	@When("user validates TFN within feature box of hero component")
	public void user_validates_tfn_within_feature_box_of_hero_component(DataTable givenAttributes) {
		
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String TFN = memberAttributesMap.get("TFN");
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.needHelpContentValidation(TFN);
	}
	
	@When("user clicks on shop for Part C plans")
	public void user_clicks_on_shop_for_part_c_plans() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateShopC();
	}
	
	@When("user clicks on shop for Medigap plans")
	public void user_clicks_on_shop_for_medigap_plans() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateMedigap();
	}
	@When("user clicks on shop for Part D plans")
	public void user_clicks_on_shop_for_part_d_plans() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateShopforPartD();
	}
	@When("user clicks on shop for D-SNPs plans")
	public void user_clicks_on_shop_for_d_sn_ps_plans() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateShopForDSNP();
	}
	
	@When("user clicks on shop all plans")
	public void user_clicks_on_shop_all_plans() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateShopAll();
	}
	
	@When("user clicks on get started link and navigates to PRE")
	public void user_clicks_on_get_started_link_and_navigates_to_pre() {
	    AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.getStartedvalidation();
	}
	@When("user clicks on learn more link")
	public void user_clicks_on_learn_more_link() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.learnMorevalidation();
	}
	@When("user clicks on learn more button link and navigates to Medicare Education Home page")
	public void user_clicks_on_learn_more_button_link_and_navigates_to_medicare_education_home_page() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateLearnMoreBtn();
	}
	
	@When("user clicks on Estimate drug costs and navigates to DCE")
	public void user_clicks_on_estimate_drug_costs_and_navigates_to_dce() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateestimateDrugCost();
	}
	
	@When("user clicks on find a provider link")
	public void user_clicks_on_find_a_provider_link() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateFindAProvider();
	}
	
	@When("user validates TFN on page")
	public void user_validates_tfn_on_page(DataTable givenAttributes) {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String tfn = memberAttributesMap.get("TFN");
		aquisitionhomepage.validateQtFNTiming();
		aquisitionhomepage.validateTFN(tfn);
	}
	
	@When("user validates Email capture component")
	public void user_validates_email_capture_component() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateEMail();
	}
	
	@Then("user clicks on cancel link on shop for a plan")
	public void user_clicks_on_cancel_link_on_shop_for_a_plan() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.clickOnCancel();
	}
	@Then("user enters the zipcode and validates the URL")
	public void user_enters_the_zipcode_and_validates_the_url(DataTable givenAttributes) {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String site = memberAttributesMap.get("SiteOnPlan");
		String zipcode = memberAttributesMap.get("ZipCodeOnPlan");
		System.out.println("@@site@@"+site);
		System.out.println("@@zipcode@@"+zipcode);
		aquisitionhomepage.sendZipCodeAndValidateUrl(zipcode,site);
	}
	
	@When("^the user performs Change Location on Plan Summary Page using following MultiCounty Zip information from HomePage$")
	public void the_user_performs_Change_Location_on_Plan_Summary_Page_using_following_MultiCounty_Zip_information_from_HomePage(
			DataTable givenAttributes) throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */

		String zipcode = memberAttributesMap.get("Zip Code");
		System.out.println("@@zip code @@"+zipcode);
		aquisitionhomepage.VPP_ChangeLocationValidateMultiCOuntyPopUp(zipcode);

	}
	@Then("^the user validates the Cancel button for Multi County Pop-up lands on enter Zip code HomePage$")
	public void the_user_validates_the_Cancel_button_for_Multi_COunty_Pop_up_lands_on_enter_Zip_code_HomePage()
			throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		boolean Validation_Flag = aquisitionhomepage.validateMultiCounty_CancelButton();
		Assertion.assertTrue("Validation failed : Cancel button Validation for Multi County Pop-up Failed ",
				Validation_Flag);

	}
	
	@When("^the user clicks on Find plans on vpp using following information from Homepage$")
	public void the_user_clicks_on_Find_plans_on_vpp_using_following_information_from_Homepage(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String county2 = memberAttributesMap.get("County Name2");
		String isMultiCounty2 = memberAttributesMap.get("Is Multi County2");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		plansummaryPage.searchPlansWithCounty(county2, isMultiCounty2);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			if (plansummaryPage.validateVPPPlanSummaryPage()) {
				aquisitionhomepage.clickViewPlansLink();
				Assertion.assertTrue(true);
			}
			else {
				Assertion.fail("Error in validating the Plan Summary Page");
			}
		}
	}

	@Then("^the user clicks on Review Drug Costs to Land on Drug Details HomePage$")
	public void the_user_clicks_on_Review_Drug_Costs_to_Land_on_Drug_DetailsP_HomePage() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		 aquisitionhomepage.navigateToDrugDetailsPage();
	}
	
	@Then("^user enters valid zipcode and county on HomePage$")
	public void user_enter_valid_zipcode_and_county_on_HomePage(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String zipcode = memberAttributesMap.get("ZipCode");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		 aquisitionhomepage.enterZipCodeandcounty(zipcode);
	}
	@Then("^the user validates MedSup TFN Number$")
	public void the_user_validates_TFN(DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		String TFNXpath = inputAttributesMap.get("TFN Xpath");
		String ExpecetdTFNNo = inputAttributesMap.get("TFN No");
//		String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
		aquisitionhomepage.validateMedsupTFNNo(TFNXpath,ExpecetdTFNNo);
	}
	@And("^user validates AARP membership links in medsup header \"([^\"]*)\"$")
	public void hover_over_AARP_Membership_In_Medsup_Header(String linkTexts) throws Exception {
		scenario.log("Changes made on 10/19- Step added for new Medsup Header redesign");
		List<String> navigationLinkOfAARP = Arrays.asList(linkTexts.split(","));
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		// memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			for (String linkText : navigationLinkOfAARP) {
				aquisitionhomepage.validateAARPMembershipLinks(linkText);
			}
		} else {
			Assertion.fail("Join AARP page is not loaded");
		}
	}

	@And("^user clicks on AARP Membership links in the Medsup header for cancel \"([^\"]*)\"$")
	public void hover_over_AARP_Membership_In_Medsup_Header_Cancel(String linkTexts) throws Exception {
		scenario.log("Changes made on 10/19- Step added for new Medsup Header redesign");
		List<String> navigationLinkOfAARP = Arrays.asList(linkTexts.split(","));
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		// memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			for (String linkText : navigationLinkOfAARP) {
				aquisitionhomepage.validateAARPMembershipcancel(linkText);
			}
		} else {
			Assertion.fail("Join AARP page is not loaded");
		}
	}
	
	@Then("^Verify AARP Membership links in header not present on home page$")
	public void verifyAARPMembershipLinksNotPresentOnOtherPage() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.verifyElementNotPresent();
	}
	
	@Then("^user validate affiliate link on header for geo target state$")
	public void Verifiy_affiliate_Link() {
		scenario.log("Changes made on 2/13- Step added for affiliate company name header redesign");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.verifiyAffiliatelink();
	}
	
	@Then("^user validate affiliate for non-geo target states$")
	public void Verifiy_affiliate_Text() {
		scenario.log("Changes made on 2/13- Step added for affiliate label header redesign");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.verifiyAffiliateText();
	}
}

