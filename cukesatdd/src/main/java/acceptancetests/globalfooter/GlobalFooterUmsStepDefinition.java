/**
 * 
 */
package acceptancetests.globalfooter;

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
import pages.acquisition.bluelayer.MedicareAdvantagePlansuhcPage;
import pages.acquisition.bluelayer.MedicarePrescriptionDrugPlansuhcPage;
import pages.acquisition.bluelayer.MedicareSpecialNeedsPlansuhcPage;
import pages.acquisition.bluelayer.MedicareSupplementPlansuhcPage;
import pages.acquisition.bluelayer.PrepareForInitialEnrollmentuhcPage;
import pages.acquisition.bluelayer.PrivacyPolicyUmsPage;
import pages.acquisition.bluelayer.SiteMapUMSPage;
import pages.acquisition.bluelayer.TermsOfUseUmsPage;
import pages.acquisition.ulayer.DiscoverMoreResourcesPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

/**
 * @author saduri
 *
 */
public class GlobalFooterUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the UHC Medicaresolutions Site$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean("webDriver", wd);
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
	
	@And("^user clicks on view disclaimer information link from footer of the UHC Medicare Solutions home page$")
	public void click_view_disclaimer_information() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject homePageDisclaimerActualJson = aquisitionhomepage.accessViewAllDisclaimerInformation();
		/* Get expected data */
		String fileName = "viewalldisclaimer";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator
				+ AcquistionCommonConstants.VIEW_ALL_DISCLAIMER_NAME
				+ File.separator;
		JSONObject viewAllDisclaimerExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.VIEW_ALL_DISCLAIMER_ACTUAL,
				homePageDisclaimerActualJson);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.VIEW_ALL_DISCLAIMER_EXPECTED,
				viewAllDisclaimerExpectedJson);
	}
	
	@Then("^user validates content on view disclaimer information link from footer of the UHC Medicare Solutions home page$")
	public void validates_content_on_show_view_disclaimer(){
		
		JSONObject homePageDisclaimerActualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.VIEW_ALL_DISCLAIMER_ACTUAL);

		JSONObject viewAllDisclaimerExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.VIEW_ALL_DISCLAIMER_EXPECTED);

		System.out.println("homePageDisclaimerActualJson---->" + homePageDisclaimerActualJson);
		System.out.println("viewAllDisclaimerExpectedJson---->" + viewAllDisclaimerExpectedJson);
		try {
			JSONAssert.assertEquals(viewAllDisclaimerExpectedJson, homePageDisclaimerActualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@And("^user clicks on hide disclaimer information link from footer of the UHC Medicare Solutions home page$")
	public void hide_disclaimer_information(){
		
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage)getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject homePageDisclaimerHideActualJson = acquisitionHomePage.accessViewAllDisclaimerHideInformation();
		/* Get expected data */
		String fileName = "hidedisclaimer";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator
				+ AcquistionCommonConstants.VIEW_ALL_DISCLAIMER_NAME
				+ File.separator;
		JSONObject hideDisclaimerExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.HIDE_DISCLAIMER_ACTUAL,
				homePageDisclaimerHideActualJson);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.HIDE_DISCLAIMER_EXPECTED,
				hideDisclaimerExpectedJson);
		
	}
	
	@Then("^user validates content on clicking hide disclaimer information link from footer of the UHC Medicare Solutions home page$")
	public void validates_content_on_hide_disclaimer(){
		
		JSONObject homePageDisclaimerHideActualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.HIDE_DISCLAIMER_ACTUAL);

		JSONObject hideDisclaimerExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.HIDE_DISCLAIMER_EXPECTED);

		System.out.println("homePageDisclaimerHideActualJson---->" + homePageDisclaimerHideActualJson);
		System.out.println("hideDisclaimerExpectedJson---->" + hideDisclaimerExpectedJson);
		try {
			JSONAssert.assertEquals(hideDisclaimerExpectedJson, homePageDisclaimerHideActualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	@Then("^the user validates sections on Agents & Brokers page$")
	public void user_validate_AgentsAndBrokers_links_ums() {

		JSONObject agentsAndBrokersActualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.AGENTS_AND_BROKERS_ACTUAL);

		JSONObject agentsAndBrokersExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.AGENTS_AND_BROKERS_EXPECTED);

		System.out.println("agentsAndBrokersActualJson---->" + agentsAndBrokersActualJson);
		System.out.println("agentsAndBrokersExpectedJson---->" + agentsAndBrokersExpectedJson);
		try {
			JSONAssert.assertEquals(agentsAndBrokersExpectedJson, agentsAndBrokersActualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
		
		
	
	
	

}
