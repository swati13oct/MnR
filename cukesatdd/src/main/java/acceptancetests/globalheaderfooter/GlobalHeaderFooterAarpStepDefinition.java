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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.acquisition.ulayer.AboutUsAARPPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AgentsnBrokersAARPPage;
import pages.acquisition.ulayer.ContactUsAARPPage;
import pages.acquisition.ulayer.DisclaimersAARPPage;
import pages.acquisition.ulayer.DiscoverMoreResourcesPage;
import pages.acquisition.ulayer.ExploreChangingPlansPage;
import pages.acquisition.ulayer.LearnAboutMedicarePage;
import pages.acquisition.ulayer.LoginAssistancePage;
import pages.acquisition.ulayer.MedicareAdvantagePlansPage;
import pages.acquisition.ulayer.MedicareAdvantageRequestMoreHelpPage;
import pages.acquisition.ulayer.MedicarePrescriptionDrugPlansPage;
import pages.acquisition.ulayer.MedicareSelectHospitalDirectoryPage;
import pages.acquisition.ulayer.MedicareSupplementInsurancePlansPage;
import pages.acquisition.ulayer.OurPlansPage;
import pages.acquisition.ulayer.PlanSelectorPage;
import pages.acquisition.ulayer.PrepareforInitialEnrollmentPage;
import pages.acquisition.ulayer.PrescriptionDrugRequestMoreHelpPage;
import pages.acquisition.ulayer.PrivacyPolicyAARPPage;
import pages.acquisition.ulayer.RegistrationHomePage;
import pages.acquisition.ulayer.ResumeYourSavedApplicationPage;
import pages.acquisition.ulayer.SiteMapAARPPage;
import pages.acquisition.ulayer.TermsnConditionsAARPPage;
import pages.member.ulayer.AccountHomePage;

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
	public void the_user_on_AARP_Medicareplans_Site() {
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
	public void click_aboutus() throws InterruptedException {
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
	
	@When("^user accesses brand section of the AARP Medicare Plans home page$")
	public void access_brand_section() {
		
	}
	@Then("^user validates all the links in brand section$")
	public void validate_all_links_brand_section(){
		
		JSONObject headerActualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.HEADER_ACTUAL);

		JSONObject headerExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.HEADER_EXPECTED);

		System.out.println("headerActualJson---->" + headerActualJson);
		System.out.println("headerExpectedJson---->" + headerExpectedJson);
		try {
			JSONAssert.assertEquals(headerExpectedJson, headerActualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@And("^user clicks on Important Disclosures link of AARP Medicare Plans home page$")
	public void click_importantDisclosures() {
		
	}
	
	@And("^user clicks on AARP logo on Disclaimer page$")
	public void click_logo() {
		DisclaimersAARPPage  disclaimersAARPPage  = (DisclaimersAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_DISCLAIMERS_PAGE);
		AcquisitionHomePage aquisitionhomepage = disclaimersAARPPage.logoClick();
		if(aquisitionhomepage!= null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Home page not found");
		}
	}
	
	@And("^user clicks on our plans link in navigation section on AARP Medicareplns Site page$")
	public void user_clicks_OurPlans_navigation_aarp() {
		
		
	}
	
	@And("^user clicks text  in global search field in navigation section on AARP Medicareplans Site page$")
	public void user_clicks_GlobalSearchField_navigation_aarp() {
		
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
	
	@And("^user clicks on visit AARP org link of Home page$")
	public void click_visitAARP_org() {
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean pagefound = aquisitionhomepage.visitAARPOrgClick();
		if(pagefound!=null && pagefound==true ){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Home page not found");
		}
				
	}
	
	/*@After
    public void tearDown() {
           WebDriver wd = (WebDriver) getLoginScenario().getBean(
                        CommonConstants.WEBDRIVER);
           wd.quit();
           getLoginScenario().flushBeans();
    }*/
	
	@When("^user hovers on Our Plans section of the AARP Medicare Plans home page$")
	public void hover_ourPlans(){
		
	

		
		}
	
	@Then("^user validates all the content and links in the Our Plans dropdown$")
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
	
	@And("^user clicks on medicare advantage plans link of our plans drop down from home page of U layer$")
	public void click_medicareAdvantage(){
	
	}
	
	@And("^user clicks on medicare advantage Request Personal Help & Information link of our plans drop down from medicare advantage plans page of U layer$")
	public void click_medicareAdvantage_requestHelpInformation(){
		MedicareAdvantagePlansPage medicareAdvantagePlansPage = (MedicareAdvantagePlansPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_UHC_PAGE);
		MedicareAdvantageRequestMoreHelpPage medicareAdvantageRequestMoreHelpPage = medicareAdvantagePlansPage.requestPersonalhelpInformationClick();
		if(medicareAdvantageRequestMoreHelpPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_REQUEST_MORE_HELP_PAGE,
					medicareAdvantageRequestMoreHelpPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  medicare advantage Request more information page");
		}
		
	}
	
	@And("^user clicks on Medicare Prescription Drug Plans link of our plans dropdown from medicare advantage Request More Information page of U layer$")
	public void click_prescriptionDrugPlans(){
		MedicareAdvantageRequestMoreHelpPage medicareAdvantageRequestMoreHelpPage= (MedicareAdvantageRequestMoreHelpPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ADVANTAGE_REQUEST_MORE_HELP_PAGE);
		MedicarePrescriptionDrugPlansPage medicarePrescriptionDrugPlansuhcPage = medicareAdvantageRequestMoreHelpPage.prescriptionDrugPlansLinkClick();
		if(medicarePrescriptionDrugPlansuhcPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_UHC_PAGE,
					medicarePrescriptionDrugPlansuhcPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  Prescription Drug plans page");
		}
		
	}


	@And("^user clicks on Prescription Drug Request Personal Help & Information link of our plans drop down from Medicare Prescription Drug Plans page U layer$")
	public void click_prescriptionDrug_requestHelpInformation(){
		MedicarePrescriptionDrugPlansPage medicarePrescriptionDrugPlansPage= (MedicarePrescriptionDrugPlansPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_UHC_PAGE);
		PrescriptionDrugRequestMoreHelpPage prescriptionDrugRequestMoreHelpPage = medicarePrescriptionDrugPlansPage.requestPersonalhelpInformationClick();
		if(prescriptionDrugRequestMoreHelpPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_REQUEST_MORE_HELP_PAGE,
					prescriptionDrugRequestMoreHelpPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  Prescription Drug Request more information page");
		}
		
	}
	
	@And("^user clicks on Medicare Supplement Plans link of our plans drop down from Prescription Drug Request more information page Ulayer$")
	public void click_medicareSupplementPlans(){
		PrescriptionDrugRequestMoreHelpPage prescriptionDrugRequestMoreHelpPage= (PrescriptionDrugRequestMoreHelpPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_REQUEST_MORE_HELP_PAGE);
		MedicareSupplementInsurancePlansPage medicareSupplementPlansuhcPage = prescriptionDrugRequestMoreHelpPage.medicareSupplementPlansLinkClick();
		if(medicareSupplementPlansuhcPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_UHC_PAGE,
					medicareSupplementPlansuhcPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  medicare supplement plans page");
		}
		
	}

		
	@And("^user clicks on Medicare Select Hospital Directory link under Medicare Supplement Plans section of our plans drop down from Medicare Supplement Plans page in AARP site$")
	public void click_medicareSelectHospitalDirectory(){
		MedicareSupplementInsurancePlansPage medicareSupplementInsurancePlansPage= (MedicareSupplementInsurancePlansPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_UHC_PAGE);
		MedicareSelectHospitalDirectoryPage medicareSelectHospitalDirectoryPage = medicareSupplementInsurancePlansPage.medicareSelectHosipitalDirectoryClick();
		if(medicareSelectHospitalDirectoryPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_SELECT_HOSPITAL_DIRECTORY_PAGE,
					medicareSelectHospitalDirectoryPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  Medicare Select Hospital Directory page");
		}
		
	}
	
	
	@And("^user clicks on Resume Your Saved Application link under Medicare Supplement Plans section of our plans drop down from Medicare Select Hospital Directory page in AARP site$")
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
	
	@When("^I hover over the Our Plans button$")
	public void the_user_hover_on_ourplans_link() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		aquisitionhomepage.hoverourplanslink();
		
	}
	
	@Then("^drop down column 1 should appear with the following in order - Find all plans in your area header, Enter ZIP field, Find Plans button, Need Help content, Need Help Link, Find right plan header, take quiz button$")
	
	public void the_user_accesses_OurPlansDropdown_link() {

		
	
	}
	
	
	
	@Then("^user validates all the content and links in the Our Plans drop down on home page of AARP site$")
	public void validate_ourPlans_dropdown(){
		JSONObject ourplansdropdownactualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.OUR_PLANS_DROPDOWN_ACTUAL);

		JSONObject ourplansdropdownexpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.OUR_PLANS_DROPDOWN_EXPECTED);

		System.out.println("ourPlansDropdownActualJson---->" + ourplansdropdownactualJson);
		System.out.println("ourPlansDropdownExpectedJson---->" + ourplansdropdownexpectedJson);
		try {
			JSONAssert.assertEquals(ourplansdropdownexpectedJson,  ourplansdropdownactualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@When("^I click find ZIP link$")
	
	public void the_user_clicks_on_lookupzipcodelink() {
		
		

	}
	

	

	
	@When("^I DON'T enter a ZIP and I click Find Plans button$")
	
	public void user_click_findplans_button_without_zip() {
		
		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);
	
		
		ourPlansPage.findplansbuttonclick2();
		
		Assert.assertTrue(true);


	
	}
	
	
	@Then("^error message should be appeard$")
	
	
	public void error_message_should_get_appear() {
		

		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);
		
		  ourPlansPage.ErrorMessage();
		
		
	}
	
	
	@When("^I DON'T enter 5 numbers in the ZIP and I click Find Plans button$")
	
	public void user_enter_lessthan5numbersinZIP() {
	
		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);
	
	
	
	Boolean value= ourPlansPage.clicktextfield();
	if (value != null && value == true) {
		Assert.assertTrue(true);
	} else {
		Assert.fail("failed");
	}
	
	 
		
	}
	
	@Then("^error message should appear$")
	
	public void error_message() {
		
		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);

		ourPlansPage.errormessage();
	}
	
	
	@When("^I enter 5 numbers and I click Find Plans button$")
	
	
	public void user_enters_correct_zip_code() {
		
		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);
		
		ourPlansPage.correctzipcode();
			
	}
		
	@Then("^I am navigated to view plans link$")
	
	public void viewplanslink() {
		
		OurPlansPage ourPlansPage = (OurPlansPage) getLoginScenario()
				.getBean(PageConstants.OUR_PLANS_PAGE);
		
		ourPlansPage.findplansbuttonclick2();  // meed to change the name
		getLoginScenario().saveBean(PageConstants.OUR_PLANS_PAGE,
				ourPlansPage);
		Assert.assertTrue(true);

		
		}
	
	@And("^user clicks on Take the quiz button from our plans drop down of U layer$")
	public void click_takeQuiz(){
		ResumeYourSavedApplicationPage resumeYourSavedApplicationPage = (ResumeYourSavedApplicationPage) getLoginScenario()
				.getBean(PageConstants.RESUME_YOUR_SAVED_APPLICATION_PAGE);
		PlanSelectorPage planSelectorPage = resumeYourSavedApplicationPage.takeQuizButtonClick();
		if(planSelectorPage != null){
			getLoginScenario().saveBean(PageConstants.PLAN_SELECTOR_PAGE,
					planSelectorPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in Plan Selector page");
		}
		
	}
	
	/*@Then("^user validates all the content and links in the Our Plans drop down$")
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
*/
	@When("^the header is rendered, the Already a Member button should display in it's inactive state on the Brand section of AARP site$")
	public void validate_button_inactive()
	{
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean state = aquisitionhomepage.validate_alreadyPlanMemberButton_inactive();
		if(state!=null && state==true ){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Already a Member button is not inactive");
		}
	}
	
	@When("^user accesses Medicare Education section AARP Medicareplans Site$")
	public void medicare_education() {
		
		
	}
	
	@And("^user clicks on LearnAboutMedicare link by hovering on Medicare Education of the AARP Medicare Plans home page$")
	public void click_learnaboutmedicare() {
		
		}
			
		
	
	
	@And("^user clicks on ExploreChangingPlans link by hovering on Medicare Education of the AARP Medicare Plans home page$")
	public void click_exploreChangingPlans() {
		LearnAboutMedicarePage learnAboutMedicarePage  = (LearnAboutMedicarePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		ExploreChangingPlansPage exploreChangingPlansPage = learnAboutMedicarePage.exploreChangingPlansClick();
		if(exploreChangingPlansPage!= null){
			getLoginScenario().saveBean(PageConstants.EXPLORE_CHANGING_PLANS_PAGE,
					exploreChangingPlansPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Explore Changing Plans page not found");
		}
			
		
	}
	
	@And("^user clicks on PrepareForInitialEnrollment link by hovering on Medicare Education of the AARP Medicare Plans home page$")
	public void click_prepareForInitialEnrollment() {
		ExploreChangingPlansPage exploreChangingPlansPage  = (ExploreChangingPlansPage) getLoginScenario()
				.getBean(PageConstants.EXPLORE_CHANGING_PLANS_PAGE);
		PrepareforInitialEnrollmentPage prepareforInitialEnrollmentPage = exploreChangingPlansPage.prepareForInitialEnrollmentClick();
		if(prepareforInitialEnrollmentPage!= null){
			getLoginScenario().saveBean(PageConstants.PREPARE_FOR_INITIAL_ENROLLMENT_PAGE,
					prepareforInitialEnrollmentPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Prepare for Initial Enrollment page not found");
		}
			
		
	}
	
	@And("^user clicks on DiscoverMoreResources link by hovering on Medicare Education of the AARP Medicare Plans home page$")
	public void click_discoverMoreResources() {
		PrepareforInitialEnrollmentPage prepareforInitialEnrollmentPage  = (PrepareforInitialEnrollmentPage) getLoginScenario()
				.getBean(PageConstants.PREPARE_FOR_INITIAL_ENROLLMENT_PAGE);
		DiscoverMoreResourcesPage discoverMoreResourcesPage = prepareforInitialEnrollmentPage.discoverMoreResourcesClick();
		if(discoverMoreResourcesPage!= null){
			getLoginScenario().saveBean(PageConstants.DISCOVER_MORE_RESOURCES_PAGE,
					discoverMoreResourcesPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Discover More Resources page not found");
		}
			
		
	}
	
	
	
	@Then("^the user validates all links in the medicare education drop down of AARP site$")
	public void user_validate_medicare_education_links_aarp() {

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
	
	@And("^user clicks on Already a member button in its inactive state on the Brand section of AARP site$")
	public void click_alreadyPlanMember()
	{
		
	}
	
	@And("^user clicks on user name, password text field in the Already a plan member drop down of AARP site$")
	public void click_field()
	{
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value=aquisitionhomepage.validate_textField();
		if(value!=null && value==true ){
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}
		
	}
	
	@And("^user clicks on forgot your username or password link of AARP site$")
	public void click_forgotUsernamePassword()
	{
		
			
	}
	
	@And("^user switches back to acquisition home page of AARP Site$")
	public void backToHomePage()
	{
		LoginAssistancePage loginAssistancePage  = (LoginAssistancePage) getLoginScenario()
				.getBean(PageConstants.LOGIN_ASSISTANCE_PAGE);
		AcquisitionHomePage aquisitionhomepage = loginAssistancePage.switchBack();
		if(aquisitionhomepage!= null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
			
		} else {
			Assert.fail("Home page not found");
		}
		
	}
	
	@And("^user clicks on register here link of AARP site$")
	public void click_registerHere()
	{
		
		
	}
	
	@Then("^user validates all the elements in the Already a plan member drop down of AARP site$")
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
	
	
	@When("^the user clicks on Already a member button on the Brand section of AARP site$")
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
	
	@And("^user enters invalid user name, password text field in the Already a plan member drop down of AARP site$")
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
	
	@Then("^user clicks on sign in button and validate the error message in Already a plan member drop down of AARP site$")
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
	
	@And("^user enters valid user name, password text field in the Already a plan member drop down of AARP site$")
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
	
	@Then("^user clicks on sign in button and validates if it is landed on member my account home page of AARP site$")
	public void clickSignInForValidCreds() {
		

	}
	
	
	@And("^user reloads the AARP site page and accesses, validates  active state of Already a member dropdown and checks for cookie timer and cookie in browser of AARP site$")
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
	
	@Then("^user waits for the time mentioned in the cookie timer and validates if the already member dropdown is inactive in AARP site$")
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
	
	@Then("^user clicks on the page and validates if the timer has stopped in browser of AARP site$")
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
	
	@Then ("^the user validates cobrowsing model window$")
	public void user_validates_cobrowsing_model_window()
	{
		System.out.println("hello, i am in cobrowsing function");
	}

}
