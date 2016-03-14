/**
 * 
 */
package acceptancetests.globalheaderfooter;

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
import pages.acquisition.bluelayer.DiscoverMoreResourcesuhcPage;
import pages.acquisition.bluelayer.ExploreChangingPlansuhcPage;
import pages.acquisition.bluelayer.LearnAboutMedicareuhcPage;
import pages.acquisition.bluelayer.LoginAssistancePage;
import pages.acquisition.bluelayer.MedicareAdvantagePlansuhcPage;
import pages.acquisition.bluelayer.MedicareAdvantageRequestMoreHelpPage;
import pages.acquisition.bluelayer.MedicarePrescriptionDrugPlansuhcPage;
import pages.acquisition.bluelayer.MedicareSelectHospitalDirectoryPage;
import pages.acquisition.bluelayer.MedicareSpecialNeedsPlansuhcPage;
import pages.acquisition.bluelayer.MedicareSupplementPlansuhcPage;
import pages.acquisition.bluelayer.OurPlansPage;
import pages.acquisition.bluelayer.PlanSelectorPage;
import pages.acquisition.bluelayer.PrepareForInitialEnrollmentuhcPage;
import pages.acquisition.bluelayer.PrescriptionDrugRequestMoreHelpPage;
import pages.acquisition.bluelayer.PrivacyPolicyUmsPage;
import pages.acquisition.bluelayer.RegistrationHomePage;
import pages.acquisition.bluelayer.ResumeYourSavedApplicationPage;
import pages.acquisition.bluelayer.SiteMapUMSPage;
import pages.acquisition.bluelayer.SpecialNeedGetEnrollmentInformationPage;
import pages.acquisition.bluelayer.TermsOfUseUmsPage;
import pages.member.bluelayer.AccountHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

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
		WebDriver wd = getLoginScenario().getWebDriver();

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

		/* Get expected data */
		String fileName = "globalfooterexpected";
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
	
	@And("^user clicks on home link of agents&brokers page bluelayer$")
	public void click_home() {
		AgentsAndBrokersPage agentsAndBrokersPage  = (AgentsAndBrokersPage) getLoginScenario()
				.getBean(PageConstants.AGENTS_AND_BROKERS_PAGE);
		AcquisitionHomePage aquisitionhomepage = agentsAndBrokersPage.homeFooterClick();
		if(aquisitionhomepage!= null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("home page not found");
		}
	}
	
/* Navigariton link Section Test Cases -  Start - Column 2 links */
	
	@And("^user clicks on medicare advantage plans link from footer of the uhc medicare solutions home page$")
	public void click_medicare_advantage_plans() {
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MedicareAdvantagePlansuhcPage medicareAdvantagePlansuhcPage = aquisitionhomepage.medicareAdvantagePlansClick();
		if(medicareAdvantagePlansuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_UHC_PAGE,
					medicareAdvantagePlansuhcPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("medicare advantage page not found");
		}
	}
	
	@And("^user clicks on medicare supplement insurance plans link from footer of the medicare advantage plans page bluelayer$")
	public void click_medicare_supplement_plans() {
		MedicareAdvantagePlansuhcPage medicareAdvantagePlansuhcPage  = (MedicareAdvantagePlansuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_UHC_PAGE);
		MedicareSupplementPlansuhcPage medicareSupplementPlansuhcPage = medicareAdvantagePlansuhcPage.medicareSupplementPlansClick();
		if(medicareSupplementPlansuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_UHC_PAGE,
					medicareSupplementPlansuhcPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("medicare supplement page not found");
		}
	}
	
	@And("^user clicks on medicare prescription drug plans link from footer of the medicare supplement plans page bluelayer$")
	public void click_medicare_prescription_drug_plans() {
		MedicareSupplementPlansuhcPage medicareSupplementPlansuhcPage  = (MedicareSupplementPlansuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_UHC_PAGE);
		MedicarePrescriptionDrugPlansuhcPage medicarePrescriptionDrugPlansuhcPage = medicareSupplementPlansuhcPage.medicarePrescriptionDrugPlansClick();
		if(medicarePrescriptionDrugPlansuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_UHC_PAGE,
					medicarePrescriptionDrugPlansuhcPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("medicare prescription drug plans page not found");
		}
	}
	
	@And("^user clicks on medicare special needs plans link from footer of the medicare supplement plans page bluelayer$")
	public void click_medicare_special_needs_plans() {
		MedicarePrescriptionDrugPlansuhcPage medicarePrescriptionDrugPlansuhcPage   = (MedicarePrescriptionDrugPlansuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_UHC_PAGE);
		MedicareSpecialNeedsPlansuhcPage medicareSpecialNeedsPlansuhcPage = medicarePrescriptionDrugPlansuhcPage.medicareSpecialNeedsPlansClick();
		if(medicareSpecialNeedsPlansuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_SPECIAL_NEEDS_PLANS_UHC_PAGE,
					medicareSpecialNeedsPlansuhcPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("medicare special needs plans page not found");
		}
	}
	
	@And("^user clicks on Learn About Medicare link from footer of the medicare special needs plans page bluelayer$")
	public void click_learn_about_medicare() {
		MedicareSpecialNeedsPlansuhcPage medicareSpecialNeedsPlansuhcPage   = (MedicareSpecialNeedsPlansuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_SPECIAL_NEEDS_PLANS_UHC_PAGE);
		LearnAboutMedicareuhcPage learnAboutMedicareuhcPage = medicareSpecialNeedsPlansuhcPage.learnAboutMedicareFooterClick();
		if(learnAboutMedicareuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_LEARN_ABOUT_MEDICARE_UHC_PAGE,
					learnAboutMedicareuhcPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("Learn About medicare page not found");
		}
	}
	
	@And("^user clicks on Prepare For Initial Enrollment link from footer of the Learn About Medicare page bluelayer$")
	public void click_prepare_for_initial_enrollment() {
		LearnAboutMedicareuhcPage learnAboutMedicareuhcPage   = (LearnAboutMedicareuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_LEARN_ABOUT_MEDICARE_UHC_PAGE);
		PrepareForInitialEnrollmentuhcPage prepareForInitialEnrollmentuhcPage = learnAboutMedicareuhcPage.prepareForInitialEnrollmentFooterClick();
		if(prepareForInitialEnrollmentuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_PREPARE_FOR_INITIAL_ENROLLMENT_UHC_PAGE,
					prepareForInitialEnrollmentuhcPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("prepare for initial enrollment page not found");
		}
	}
	
	@And("^user clicks on Explore Changing plans link from footer of the Prepare For Initial Enrollment page bluelayer$")
	public void click_explore_changing_plans() {
		PrepareForInitialEnrollmentuhcPage prepareForInitialEnrollmentuhcPage   = (PrepareForInitialEnrollmentuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_PREPARE_FOR_INITIAL_ENROLLMENT_UHC_PAGE);
		ExploreChangingPlansuhcPage exploreChangingPlansuhcPage = prepareForInitialEnrollmentuhcPage.exploreChangingPlansFooterClick();
		if(exploreChangingPlansuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_EXPLORE_CHANGING_PLANS_UHC_PAGE,
					exploreChangingPlansuhcPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("Explore changing plans page not found");
		}
	}
	
	@And("^user clicks on Discover More Resources link from footer of the Explore Changing plans page bluelayer$")
	public void click_discover_more_resources() {
		ExploreChangingPlansuhcPage exploreChangingPlansuhcPage  = (ExploreChangingPlansuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_EXPLORE_CHANGING_PLANS_UHC_PAGE);
		DiscoverMoreResourcesuhcPage discoverMoreResourcesuhcPage = exploreChangingPlansuhcPage.discoverMoreResourcesFooterClick();
		if(discoverMoreResourcesuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_DISCOVER_MORE_RESOURCES_UHC_PAGE,
					discoverMoreResourcesuhcPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("Discover More Resources page not found");
		}
	}
	
	@And("^user clicks on Home link from footer of the discover more resources page bluelayer$")
	public void click_home_from_discover_more_resources() {
		DiscoverMoreResourcesuhcPage discoverMoreResourcesuhcPage  = (DiscoverMoreResourcesuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_DISCOVER_MORE_RESOURCES_UHC_PAGE);
		AcquisitionHomePage acquisitionHomePage = discoverMoreResourcesuhcPage.acquisitionHomeFooterClick();
		if(acquisitionHomePage!= null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acquisitionHomePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Aboutus page not found");
		}
			
		
	}
	
/* Dislaimer Information Section*/
	
	@And("^user clicks on view disclaimer information section links from footer of the UHC Medicare Solutions home page$")
	public void click_view_disclaimer_information() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage = aquisitionhomepage.veiwAllDisclaimerLinkSectionLinksClick();
		if(aquisitionhomepage!= null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Home page not found");
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
	
	@When("^user accesses global header UHC Medicaresolutions Site$")
	public void the_user_accesses_GlobalHeader_UHC_Medicaresolutions_Site() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage != null){
		JSONObject globalHeaderActual = aquisitionhomepage
				.accessingGlobalHeader();

		/* Get expected data */
		String fileName = "globalheaderexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator
				+ AcquistionCommonConstants.GLOBAL_HEADER_FLOW_NAME
				+ File.separator;
		JSONObject globalHeaderExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.GLOBAL_HEADER_ACTUAL,
				globalHeaderActual);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.GLOBAL_HEADER_EXPECTED,
				globalHeaderExpectedJson);
		Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in Home page");
		}

	}
	
	@And("^user clicks on the Important Disclosures link on UHC Medicaresolutions Site page$")
	public void user_clicks_ImportantDisclaimers_link_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersPage disclaimersPage = aquisitionhomepage.importantDisclaimersClick();
		if(disclaimersPage != null){
			getLoginScenario().saveBean(PageConstants.DISCLAIMERS_PAGE,
					disclaimersPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
	@And("^user clicks on the UnitedHealthCare logo on UHC Medicaresolutions Site page$")
	public void user_clicks_UnitedHealthCare_logo_ums() {
		
		DisclaimersPage disclaimersPage = (DisclaimersPage) getLoginScenario()
				.getBean(PageConstants.DISCLAIMERS_PAGE);
		AcquisitionHomePage aquisitionhomepage = disclaimersPage.unitedHealthCareLogoClick();
		if(aquisitionhomepage != null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
	@And("^user clicks on home link in navigation section on UHC Medicaresolutions Site page$")
	public void user_clicks_HomeLink_navigation_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage = aquisitionhomepage.navigationSectionHomeLinkClick();
		if(aquisitionhomepage != null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
/*	
	@And("^user clicks on Our Plans link in navigation section on UHC Medicaresolutions Site page$")
	public void user_clicks_OurPlans_navigation_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		OurPlansPage ourPlansPage = aquisitionhomepage.navigationSectionOurPlansLinkClick();
		if(ourPlansPage != null){
			getLoginScenario().saveBean(PageConstants.OUR_PLANS_PAGE,
					ourPlansPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}*/
	
		
	@And("^user clicks text  in global search field in navigation section on UHC Medicaresolutions Site page$")
	public void user_clicks_GlobalSearchField_navigation_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean searchResult = aquisitionhomepage.navigationSectionEnterSearchClick();
		
		
		if(searchResult != null && searchResult){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
	@Then("^user validates the Brand Section items on UHC Medicaresolutions Site page$")
	public void user_validate_BrandSection_links_ums() {

		JSONObject globalHeaderActual = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.GLOBAL_HEADER_ACTUAL);

		JSONObject globalHeaderExpected = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.GLOBAL_HEADER_EXPECTED);

		System.out.println("globalHeaderActual---->" + globalHeaderActual);
		System.out.println("globalHeaderExpected---->" + globalHeaderExpected);
		try {
			JSONAssert.assertEquals(globalHeaderExpected, globalHeaderActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@When("^the header is rendered, the Already a Member button should display in it's inactive state on the Brand section of UMS site$")
	public void access_brand_section() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean state = acquisitionHomePage
				.validate_alreadyPlanMemberButton_inactive();
		if (state != null && state == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Already a Member button is not inactive");
		}

	}

	@And("^user clicks on Already a member button in its inactive state on the Brand section of UMS site$")
	public void click_alreadyPlanMember() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean state = acquisitionHomePage
				.validate_alreadyPlanMemberButton_active();
		// getting actual json object
		JSONObject alreadyPlanMemberActualJson = acquisitionHomePage
				.getAlreadyPlanMemberJSON();
		/* Get expected data */
		String fileName = "alreadyPlanMemberExpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + AcquistionCommonConstants.HEADER_FLOW_NAME
				+ File.separator;
		JSONObject alreadyPlanMemberExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.ALREADY_PLAN_MEMBER_ACTUAL,
				alreadyPlanMemberActualJson);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.ALREADY_PLAN_MEMBER_EXPECTED,
				alreadyPlanMemberExpectedJson);

		if (state != null && state == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Already a Member button dropdown is not displayed");
		}
	}

	@And("^user clicks on user name, password text field in the Already a plan member drop down of UMS site$")
	public void click_field() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = acquisitionHomePage.validate_textField();
		if (value != null && value == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}

	@And("^user clicks on forgot your username or password link of UMS site$")
	public void click_forgotUsernamePassword() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		LoginAssistancePage loginAssistancePage = acquisitionHomePage
				.forgotUsernamePasswordClick();
		if (loginAssistancePage != null) {
			getLoginScenario().saveBean(PageConstants.LOGIN_ASSISTANCE_PAGE,
					loginAssistancePage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Login Assistance page not found");
		}

	}

	@And("^user switches back to acquisition home page of UMS Site$")
	public void backToHomePage() {
		LoginAssistancePage loginAssistancePage = (LoginAssistancePage) getLoginScenario()
				.getBean(PageConstants.LOGIN_ASSISTANCE_PAGE);
		AcquisitionHomePage acquisitionHomePage = loginAssistancePage
				.switchBack();
		if (acquisitionHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acquisitionHomePage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Home page not found");
		}

	}
	
	@And("^user clicks on register here link of UMS site$")
	public void click_registerHere()
	{
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RegistrationHomePage registrationHomePage=acquisitionHomePage.registerHereLinkClick();
		if(registrationHomePage!= null){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Registration page not found");
		}
		
	}
	@Then("^user validates all the elements in the Already a plan member drop down of UMS site$")
	public void validate_allElements()
	{
		JSONObject alreadyPlanMemberActualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.ALREADY_PLAN_MEMBER_ACTUAL);

		JSONObject alreadyPlanMemberExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.ALREADY_PLAN_MEMBER_EXPECTED);

		System.out.println("alreadyPlanMemberActualJson---->" + alreadyPlanMemberActualJson);
		System.out.println("alreadyPlanMemberExpectedJson---->" + alreadyPlanMemberExpectedJson);
		try {
			JSONAssert.assertEquals(alreadyPlanMemberExpectedJson, alreadyPlanMemberActualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@When("^the user clicks on Already a member button on the Brand section of UMS site$")
	public void click_alreadyMember()
	{
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean alreadyMemberFlag=aquisitionhomepage.validate_alreadyPlanMemberButton_active();
		if(alreadyMemberFlag!= null && alreadyMemberFlag){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Already member dropdown not displayed");
		}
		
	}
	
	@And("^user enters invalid user name, password text field in the Already a plan member drop down of UMS site$")
	public void entersInvalidCredentials() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		/*List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();*/
		Boolean value = aquisitionhomepage.enterInvalidUserNamePassword();
		if (value != null && value == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@Then("^user clicks on sign in button and validate the error message in Already a plan member drop down of UMS site$")
	public void clickSignInForInvalidCreds() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = aquisitionhomepage.checkErrorMessage();
		if (value != null && value == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@And("^user enters valid user name, password text field in the Already a plan member drop down of UMS site$")
	public void entersValidCredentials() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		/*List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();*/
		Boolean value = aquisitionhomepage.enterValidUserNamePassword();
		if (value != null && value == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@Then("^user clicks on sign in button and validates if it is landed on member my account home page of UMS site$")
	public void clickSignInForValidCreds() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AccountHomePage accountHomePage = aquisitionhomepage.signInValid();
		if (accountHomePage != null) {
			getLoginScenario().saveBean(acceptancetests.atdd.data.member.PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@When("^user hovers on Our Plans section of the UHC Medicare Solutions home page$")
	public void hover_ourPlans(){
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage != null){
			JSONObject ourPlansDropdownActualJson = aquisitionhomepage
					.accessingOurPlansNav();

			/* Get expected data */
			String fileName = "ourPlansDropdownExpected";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator
					+ AcquistionCommonConstants.HEADER_FLOW_NAME
					+ File.separator;
			JSONObject ourPlansDropdownExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);

			getLoginScenario().saveBean(
					AcquistionCommonConstants.OUR_PLANS_ACTUAL,
					ourPlansDropdownActualJson);
			getLoginScenario().saveBean(
					AcquistionCommonConstants.OUR_PLANS_EXPECTED,
					ourPlansDropdownExpectedJson);
			Assert.assertTrue(true);
			}
			else{
				Assert.fail("Error in Home page");
			}

		
		}
	@Then("^user validates all the content and links in the Our Plans drop down from home page of blue layer$")
	public void validate_ourPlan_nav(){
		JSONObject ourPlansDropdownActualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.OUR_PLANS_ACTUAL);

		JSONObject ourPlansDropdownExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.OUR_PLANS_EXPECTED);

		System.out.println("ourPlansDropdownActualJson---->" + ourPlansDropdownActualJson);
		System.out.println("ourPlansDropdownExpectedJson---->" + ourPlansDropdownExpectedJson);
		try {
			JSONAssert.assertEquals(ourPlansDropdownExpectedJson, ourPlansDropdownActualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@And("^user clicks on medicare advantage plans link of our plans drop down from home page of blue layer$")
	public void click_medicareAdvantage(){
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MedicareAdvantagePlansuhcPage medicareAdvantagePlansuhcPage = aquisitionhomepage.headerMedicareAdvantageClick();
		if(medicareAdvantagePlansuhcPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_UHC_PAGE,
					medicareAdvantagePlansuhcPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  medicare advantage plans page");
		}
		
	}
	
	@And("^user clicks on medicare advantage Request Personal Help & Information link of our plans drop down from medicare advantage plans page of blue layer$")
	public void click_medicareAdvantage_requestHelpInformation(){
		MedicareAdvantagePlansuhcPage medicareAdvantagePlansuhcPage = (MedicareAdvantagePlansuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_UHC_PAGE);
		MedicareAdvantageRequestMoreHelpPage medicareAdvantageRequestMoreHelpPage = medicareAdvantagePlansuhcPage.requestPersonalhelpInformationClick();
		if(medicareAdvantageRequestMoreHelpPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_REQUEST_MORE_HELP_PAGE,
					medicareAdvantageRequestMoreHelpPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  medicare advantage Request more information page");
		}
		
	}
	
	@And("^user clicks on Medicare Prescription Drug Plans link of our plans dropdown from medicare advantage Request More Information page of blue layer$")
	public void click_prescriptionDrugPlans(){
		MedicareAdvantageRequestMoreHelpPage medicareAdvantageRequestMoreHelpPage= (MedicareAdvantageRequestMoreHelpPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ADVANTAGE_REQUEST_MORE_HELP_PAGE);
		MedicarePrescriptionDrugPlansuhcPage medicarePrescriptionDrugPlansuhcPage = medicareAdvantageRequestMoreHelpPage.prescriptionDrugPlansLinkClick();
		if(medicarePrescriptionDrugPlansuhcPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_UHC_PAGE,
					medicarePrescriptionDrugPlansuhcPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  Prescription Drug plans page");
		}
		
	}
	
	@And("^user clicks on Prescription Drug Request Personal Help & Information link of our plans drop down from Medicare Prescription Drug Plans page blue layer$")
	public void click_prescriptionDrug_requestHelpInformation(){
		MedicarePrescriptionDrugPlansuhcPage medicarePrescriptionDrugPlansuhcPage= (MedicarePrescriptionDrugPlansuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_UHC_PAGE);
		PrescriptionDrugRequestMoreHelpPage prescriptionDrugRequestMoreHelpPage = medicarePrescriptionDrugPlansuhcPage.requestPersonalhelpInformationClick();
		if(prescriptionDrugRequestMoreHelpPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_REQUEST_MORE_HELP_PAGE,
					prescriptionDrugRequestMoreHelpPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  Prescription Drug Request more information page");
		}
		
	}
	
	@And("^user clicks on Medicare Supplement Plans link of our plans drop down from Prescription Drug Request more information page bluelayer$")
	public void click_medicareSupplementPlans(){
		PrescriptionDrugRequestMoreHelpPage prescriptionDrugRequestMoreHelpPage= (PrescriptionDrugRequestMoreHelpPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_REQUEST_MORE_HELP_PAGE);
		MedicareSupplementPlansuhcPage medicareSupplementPlansuhcPage = prescriptionDrugRequestMoreHelpPage.medicareSupplementPlansLinkClick();
		if(medicareSupplementPlansuhcPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_UHC_PAGE,
					medicareSupplementPlansuhcPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  medicare supplement plans page");
		}
		
	}
	
	@And("^user clicks on Medicare Select Hospital Directory link under Medicare Supplement Plans section of our plans drop down from Medicare Supplement Plans page in UMS site$")
	public void click_medicareSelectHospitalDirectory(){
		MedicareSupplementPlansuhcPage medicareSupplementPlansuhcPage= (MedicareSupplementPlansuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_UHC_PAGE);
		MedicareSelectHospitalDirectoryPage medicareSelectHospitalDirectoryPage = medicareSupplementPlansuhcPage.medicareSelectHosipitalDirectoryClick();
		if(medicareSelectHospitalDirectoryPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_SELECT_HOSPITAL_DIRECTORY_PAGE,
					medicareSelectHospitalDirectoryPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  Medicare Select Hospital Directory page");
		}
		
	}
	
	@And("^user clicks on Resume Your Saved Application link under Medicare Supplement Plans section of our plans drop down from Medicare Select Hospital Directory page in UMS site$")
	public void click_resumeYourSavedApplication(){
		MedicareSelectHospitalDirectoryPage medicareSelectHospitalDirectoryPage= (MedicareSelectHospitalDirectoryPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_SELECT_HOSPITAL_DIRECTORY_PAGE);
		ResumeYourSavedApplicationPage resumeYourSavedApplicationPage = medicareSelectHospitalDirectoryPage.resumeYourSavedApplicationClick();
		if(resumeYourSavedApplicationPage != null){
			getLoginScenario().saveBean(PageConstants.RESUME_YOUR_SAVED_APPLICATION_PAGE,
					resumeYourSavedApplicationPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  Resume Your Saved Application page");
		}
		
	}
	
	@And("^user clicks on medicare special needs plan from UHC Medicare Solutions home page$")
	public void click_specialNeedPlans(){
		WebDriver wd =(WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);		
		wd.navigate().back();
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MedicareSpecialNeedsPlansuhcPage  medicareSpecialNeedsPlansuhcPage = aquisitionhomepage.medicareSpecialNeedPlansLinkClick();
		if(medicareSpecialNeedsPlansuhcPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_SPECIAL_NEEDS_PLANS_UHC_PAGE,
					medicareSpecialNeedsPlansuhcPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in Medicare Special Need plans page");
		}
		
	}
	
	@And("^user clicks on get enrollment information link from medicare special needs plan page of bluelayer$")
	public void click_getEnrollmentInformation(){
		
		MedicareSpecialNeedsPlansuhcPage  medicareSpecialNeedsPlansuhcPage = (MedicareSpecialNeedsPlansuhcPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_SPECIAL_NEEDS_PLANS_UHC_PAGE);
		SpecialNeedGetEnrollmentInformationPage specialNeedGetEnrollmentInformationPage= medicareSpecialNeedsPlansuhcPage.getEnrollmentInformationLinkClick();
		if(specialNeedGetEnrollmentInformationPage != null){
			getLoginScenario().saveBean(PageConstants.SPECIAL_NEEDS_GET_ENROLMENT_INFO_PAGE,
					specialNeedGetEnrollmentInformationPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in Get Enrollment Information page");
		}
		
	}
	
	@And("^user clicks on Take the quiz button from our plans drop down of blue layer$")
	public void click_takeQuiz(){
		SpecialNeedGetEnrollmentInformationPage specialNeedGetEnrollmentInformationPage = (SpecialNeedGetEnrollmentInformationPage) getLoginScenario()
				.getBean(PageConstants.SPECIAL_NEEDS_GET_ENROLMENT_INFO_PAGE);
		PlanSelectorPage planSelectorPage = specialNeedGetEnrollmentInformationPage.takeQuizButtonClick();
		if(planSelectorPage != null){
			getLoginScenario().saveBean(PageConstants.PLAN_SELECTOR_PAGE,
					planSelectorPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in Plan Selector page");
		}
		
	}
	
	@And("^user clicks the zipcode text field of ourplan drop down blue layer$")
	public void click_zipcodeField()
	{
		PlanSelectorPage planSelectorPage   = (PlanSelectorPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_PAGE);
		Boolean value=planSelectorPage.validate_textField();
		if(value!=null && value==true ){
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}
		
	}
	
	@And("^user clicks on lookup zipcode link of our plan drop down blue layer$")
	public void click_lookupzipLink(){
		PlanSelectorPage planSelectorPage   = (PlanSelectorPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SELECTOR_PAGE);
		
		Boolean isPopupOpened=planSelectorPage.lookupzipLinkClick();
		
		if(isPopupOpened!=null && isPopupOpened==true ){
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}
		
	}
	
	@And("^user enter the below zipcode from home page in blue layer$")
	public void enter_zipcode(DataTable givenAttributes)
	{
		String zipCode = givenAttributes
				.getGherkinRows().get(0).getCells().get(0);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage != null){
			JSONObject ourPlansDropdownActualJson = aquisitionhomepage.enterZipCode(zipCode);

			/* Get expected data */
			String fileName = "ourPlansDropdownErrorExpected";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator
					+ AcquistionCommonConstants.HEADER_FLOW_NAME
					+ File.separator;
			JSONObject ourPlansDropdownExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);

			getLoginScenario().saveBean(
					AcquistionCommonConstants.OUR_PLANS_ACTUAL,
					ourPlansDropdownActualJson);
			getLoginScenario().saveBean(
					AcquistionCommonConstants.OUR_PLANS_EXPECTED,
					ourPlansDropdownExpectedJson);
			Assert.assertTrue(true);
			}
			else{
				Assert.fail("Error in Home page");
			}

		
		}
	
	@When("^user accesses Medicare Education section UHC Medicare Solutions Site$")
	public void medicare_education() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject medicareEducationDropDowmActual = aquisitionhomepage.accessMedicareEducationDropDown();
		/* Get expected data */
		String fileName = "medicareeducationdropdownexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator
				+ AcquistionCommonConstants.MEDICARE_EDUCATION_DROP_DOWN_NAME
				+ File.separator;
		JSONObject medicareEducationDropDownExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.MEDICARE_EDUCATION_DROP_DOWN_ACTUAL,
				medicareEducationDropDowmActual);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.MEDICARE_EDUCATION_DROP_DOWN_EXPECTED,
				medicareEducationDropDownExpectedJson);
	
	}
	
	@And("^user clicks on LearnAboutMedicare link by hovering on Medicare Education of the UHC Medicare Solutions home page$")
	public void click_learnaboutmedicare() {
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		LearnAboutMedicareuhcPage learnAboutMedicareuhcPage = aquisitionhomepage.learnAboutMedicareClick();
		if(learnAboutMedicareuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE,
					learnAboutMedicareuhcPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Learn about us page not found");
		}
		
	}
	
	@And("^user clicks on ExploreChangingPlans link by hovering on Medicare Education of the UHC Medicare Solutions home page$")
	public void click_exploreChangingPlans() {
		LearnAboutMedicareuhcPage learnAboutMedicarePage  = (LearnAboutMedicareuhcPage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		ExploreChangingPlansuhcPage exploreChangingPlansuhcPage = learnAboutMedicarePage.exploreChangingPlansClick();
		if(exploreChangingPlansuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.EXPLORE_CHANGING_PLANS_PAGE,
					exploreChangingPlansuhcPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Explore Changing Plans page not found");
		}
			
		
	}
	
	@And("^user clicks on PrepareForInitialEnrollment link by hovering on Medicare Education of the UHC Medicare Solutions home page$")
	public void click_prepareForInitialEnrollment() {
		ExploreChangingPlansuhcPage exploreChangingPlansPage  = (ExploreChangingPlansuhcPage) getLoginScenario()
				.getBean(PageConstants.EXPLORE_CHANGING_PLANS_PAGE);
		PrepareForInitialEnrollmentuhcPage prepareforInitialEnrollmentuhcPage = exploreChangingPlansPage.prepareForInitialEnrollmentClick();
		if(prepareforInitialEnrollmentuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.PREPARE_FOR_INITIAL_ENROLLMENT_PAGE,
					prepareforInitialEnrollmentuhcPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Prepare for Initial Enrollment page not found");
		}
			
		
	}
	
	@And("^user clicks on DiscoverMoreResources link by hovering on Medicare Education of the UHC Medicare Solutions home page$")
	public void click_discoverMoreResources() {
		PrepareForInitialEnrollmentuhcPage prepareforInitialEnrollmentuhcPage  = (PrepareForInitialEnrollmentuhcPage) getLoginScenario()
				.getBean(PageConstants.PREPARE_FOR_INITIAL_ENROLLMENT_PAGE);
		DiscoverMoreResourcesuhcPage discoverMoreResourcesuhcPage = prepareforInitialEnrollmentuhcPage.discoverMoreResourcesClick();
		if(discoverMoreResourcesuhcPage!= null){
			getLoginScenario().saveBean(PageConstants.DISCOVER_MORE_RESOURCES_PAGE,
					discoverMoreResourcesuhcPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Discover More Resources page not found");
		}
			
		
	}
	
	@Then("^the user validates all links in the medicare education drop down of UMS site$")
	public void user_validate_medicare_education_links_ums() {

		JSONObject medicareEducationDropDowmActual = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.MEDICARE_EDUCATION_DROP_DOWN_ACTUAL);

		JSONObject medicareEducationDropDownExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.MEDICARE_EDUCATION_DROP_DOWN_EXPECTED);

		System.out.println("medicareEducationDropDowmActual---->" + medicareEducationDropDowmActual);
		System.out.println("medicareEducationDropDownExpectedJson---->" + medicareEducationDropDownExpectedJson);
		try {
			JSONAssert.assertEquals(medicareEducationDropDownExpectedJson, medicareEducationDropDowmActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Then("^the user validates the error message displayed$")
	public void validate_errorMessage(){
		JSONObject ourPlansDropdownActualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.OUR_PLANS_ACTUAL);

		JSONObject ourPlansDropdownExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.OUR_PLANS_EXPECTED);

		System.out.println("ourPlansDropdownActualJson---->" + ourPlansDropdownActualJson);
		System.out.println("ourPlansDropdownExpectedJson---->" + ourPlansDropdownExpectedJson);
		try {
			JSONAssert.assertEquals(ourPlansDropdownExpectedJson, ourPlansDropdownActualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@And("^user clicks on findplans button by providing below valid zipcode$")
	public void click_findPlan(DataTable givenAttributes)
	{
		String zipCode = givenAttributes
				.getGherkinRows().get(0).getCells().get(0);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		OurPlansPage ourPlansPage = aquisitionhomepage.findPlanButtonClick(zipCode);
		if(ourPlansPage != null){
			getLoginScenario().saveBean(PageConstants.OUR_PLANS_PAGE,
					ourPlansPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in Plan Selector page");
		}
	}
	
	@And("^user reloads the UMS site page and accesses, validates  active state of Already a member dropdown and checks for cookie timer and cookie in browser of UMS site$")
	public void alreadyMemberActiveStateValidation() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = aquisitionhomepage.alreadyMemberActiveValid();
		if (value != null && value) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@Then("^user waits for the time mentioned in the cookie timer and validates if the already member dropdown is inactive in UMS site$")
	public void cookietimerValidation() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = aquisitionhomepage.cookieTimerValid();
		if (value != null && !value) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@Then("^user clicks on the page and validates if the timer has stopped in browser of UMS site$")
	public void timerStopValidation() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = aquisitionhomepage.stopTimerValid();
		if (value != null && value) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}

}
