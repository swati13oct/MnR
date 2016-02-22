/**
 * 
 */
package acceptancetests.headernavigation.bluelayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.DiscoverMoreResourcesuhcPage;
import pages.acquisition.bluelayer.ExploreChangingPlansuhcPage;
import pages.acquisition.bluelayer.LearnAboutMedicareuhcPage;
import pages.acquisition.bluelayer.PrepareForInitialEnrollmentuhcPage;
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
public class MedicareEducationUmsStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^user is on the UHC Medicare Solutions home page$")
	public void the_user_on_UMS_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
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
	
	/*@After
    public void tearDown() {
           WebDriver wd = (WebDriver) getLoginScenario().getBean(
                        CommonConstants.WEBDRIVER);
           wd.quit();
           getLoginScenario().flushBeans();
    }*/
	
	

}
