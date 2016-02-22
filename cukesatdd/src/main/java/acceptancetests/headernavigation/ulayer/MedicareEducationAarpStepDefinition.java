/**
 * 
 */
package acceptancetests.headernavigation.ulayer;

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
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

/**
 * @author saduri
 *
 */
public class MedicareEducationAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^user is on the AARP Medicare Plans home page$")
	public void the_user_on_AARP_Medicareplans_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@When("^user accesses Medicare Education section AARP Medicareplans Site$")
	public void our_plans() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject medicareEducationDropDowmActual = aquisitionhomepage.accessMedicareEducationDropDown();
		/* Get expected data */
		String fileName = "medicareeducationdropdownexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
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
	
	@And("^user clicks on LearnAboutMedicare link by hovering on Medicare Education of the AARP Medicare Plans home page$")
	public void click_learnaboutmedicare() {
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		LearnAboutMedicarePage learnAboutMedicarePage = aquisitionhomepage.learnAboutMedicareClick();
		if(learnAboutMedicarePage!= null){
			getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE,
					learnAboutMedicarePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Learn about us page not found");
		}
			
		
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
	
	/*@After
    public void tearDown() {
           WebDriver wd = (WebDriver) getLoginScenario().getBean(
                        CommonConstants.WEBDRIVER);
           wd.quit();
           getLoginScenario().flushBeans();
    }*/

	

}


