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
import pages.acquisition.ulayer.DiscoverMoreResourcesPage;
import pages.acquisition.ulayer.ExploreChangingPlansPage;
import pages.acquisition.ulayer.LearnAboutMedicarePage;
import pages.acquisition.ulayer.MedicareAdvantagePlansPage;
import pages.acquisition.ulayer.MedicarePrescriptionDrugPlansPage;
import pages.acquisition.ulayer.MedicareSupplementInsurancePlansPage;
import pages.acquisition.ulayer.PrepareforInitialEnrollmentPage;
import pages.acquisition.ulayer.PrivacyPolicyAARPPage;
import pages.acquisition.ulayer.SiteMapAARPPage;
import pages.acquisition.ulayer.TermsnConditionsAARPPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

/**
 * @author rkodumur
 *
 */
public class GlobalFooterAARPStepDefinition {
	
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
		String fileName = "globalfooterexpected";
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
	
	
	/* Navigation link Section Test Cases -  Start - Column 1*/
	/*@And("^user clicks on visit aarp org link from footer of the AARP Medicare Plans home page$")
	public void clicks_visit_aarp_org() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage!= null){
			GlobalFooterWebElements.aarpOrgLink.click();
			Assert.assertTrue(true);
		} else {
			Assert.fail("home page not found");
		}
		
	}*/
	
	
	/* Navigation link Section Test Cases -  Start - Column 2 links */
	
	@And("^user clicks on medicare advantage plan link from footer of the AARP Medicare Plans home page$")
	public void click_medicare_advantage_plans() {
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MedicareAdvantagePlansPage medicareAdvantagePlansPage = aquisitionhomepage.medicareAdvantagePlansClick();
		if(medicareAdvantagePlansPage!= null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_PAGE,
					medicareAdvantagePlansPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("home page not found");
		}
	}
	
	@And("^user clicks on medicare supplement insurance plans link from footer of the AARP Medicare Plans home page$")
	public void click_supplement_insurance_plans() {
		MedicareAdvantagePlansPage medicareAdvantagePlanPage  = (MedicareAdvantagePlansPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_PAGE);
		MedicareSupplementInsurancePlansPage medicareSupplementInsurancePlansPage = medicareAdvantagePlanPage.medicareSupplementFooterClick();
		if(medicareSupplementInsurancePlansPage!= null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_SUPPLEMENT_INSURANCE_PLANS_PAGE,
					medicareSupplementInsurancePlansPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("home page not found");
		}
	}
	
	@And("^user clicks on medicare prescription drug plans from footer of the AARP Medicare Plans home page$")
	public void medicare_prescription_drug_plans() {
		MedicareSupplementInsurancePlansPage medicareSupplementInsurancePlansPage  = (MedicareSupplementInsurancePlansPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_SUPPLEMENT_INSURANCE_PLANS_PAGE);
		MedicarePrescriptionDrugPlansPage medicarePrescriptionDrugPlansPage = medicareSupplementInsurancePlansPage.medicarePrescriptionFooterClick();
		if(medicarePrescriptionDrugPlansPage!= null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_PAGE,
					medicarePrescriptionDrugPlansPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("home page not found");
		}
	}
	
	
	
	/* Navigation link Section Test Cases -  Start - Column 3 links  */
	@And("^user clicks on learn about medicare link from footer of the AARP Medicare Plans home page$")
	public void learn_about_medicare() {
		MedicarePrescriptionDrugPlansPage medicarePrescriptionDrugPlansPage  = (MedicarePrescriptionDrugPlansPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_PAGE);
		LearnAboutMedicarePage learnAboutMedicarePage = medicarePrescriptionDrugPlansPage.learnAboutMedicareFooterClick();
		if(learnAboutMedicarePage!= null){
			getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE,
					learnAboutMedicarePage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("home page not found");
		}
	}
	
	@And("^user clicks on prepare for initial enrollment link from footer of the AARP Medicare Plans home page$")
	public void prepare_for_initial_enrollment() {
		LearnAboutMedicarePage learnAboutMedicarePage  = (LearnAboutMedicarePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		PrepareforInitialEnrollmentPage prepareforInitialEnrollmentPage = learnAboutMedicarePage.prepareforInitialEnrollmentFooterClick();
		if(prepareforInitialEnrollmentPage!= null){
			getLoginScenario().saveBean(PageConstants.PREPARE_FOR_INITIAL_ENROLLMENT_PAGE,
					prepareforInitialEnrollmentPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("home page not found");
		}
	}
	
	@And("^user clicks on explore changing plans link from footer of the AARP Medicare Plans home page$")
	public void explore_changing_plans() {
		PrepareforInitialEnrollmentPage prepareforInitialEnrollmentPage  = (PrepareforInitialEnrollmentPage) getLoginScenario()
				.getBean(PageConstants.PREPARE_FOR_INITIAL_ENROLLMENT_PAGE);
		ExploreChangingPlansPage exploreChangingPlansPage = prepareforInitialEnrollmentPage.exploreChangingPlansFooterClick();
		if(exploreChangingPlansPage!= null){
			getLoginScenario().saveBean(PageConstants.EXPLORE_CHANGING_PLANS_PAGE,
					exploreChangingPlansPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("home page not found");
		}
	}
	
	
	@And("^user clicks on discover more resources link from footer of the AARP Medicare Plans home page$")
	public void discover_more_resources() {
		ExploreChangingPlansPage exploreChangingPlansPage  = (ExploreChangingPlansPage) getLoginScenario()
				.getBean(PageConstants.EXPLORE_CHANGING_PLANS_PAGE);
		DiscoverMoreResourcesPage discoverMoreResourcesPage = exploreChangingPlansPage.discoverMoreResourcesFooterClick();
		if(discoverMoreResourcesPage!= null){
			getLoginScenario().saveBean(PageConstants.DISCOVER_MORE_RESOURCES_PAGE,
					discoverMoreResourcesPage);
			
			Assert.assertTrue(true);
		} else {
			Assert.fail("home page not found");
		}
	}
	
	
	
	
	@And("^user clicks on Home link from footer of the discover more resources page$")
	public void click_home_from_discover_more_resources() {
		DiscoverMoreResourcesPage discoverMoreResourcesPage  = (DiscoverMoreResourcesPage) getLoginScenario()
				.getBean(PageConstants.DISCOVER_MORE_RESOURCES_PAGE);
		AcquisitionHomePage acquisitionHomePage = discoverMoreResourcesPage.acquisitionHomeFooterClick();
		if(acquisitionHomePage!= null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acquisitionHomePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Aboutus page not found");
		}
			
		
	}

	
/* Dislaimer Information Section*/
	
	@And("^user clicks on view disclaimer information section links from footer of the AARP Medicare Plans home page$")
	public void click_view_disclaimer_information() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage = aquisitionhomepage.veiwAllDisclaimerLinkSectionLinksClick();
		if(aquisitionhomepage!= null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Aboutus page not found");
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
