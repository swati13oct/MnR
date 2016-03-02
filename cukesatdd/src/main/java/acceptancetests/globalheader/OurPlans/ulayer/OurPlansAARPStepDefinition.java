/**
 * 
 */
package acceptancetests.globalheader.OurPlans.ulayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.MedicareAdvantagePlansPage;
import pages.acquisition.ulayer.MedicareAdvantageRequestMoreHelpPage;
import pages.acquisition.ulayer.MedicarePrescriptionDrugPlansPage;
import pages.acquisition.ulayer.MedicareSelectHospitalDirectoryPage;
import pages.acquisition.ulayer.MedicareSupplementInsurancePlansPage;
import pages.acquisition.ulayer.PrescriptionDrugRequestMoreHelpPage;
import pages.acquisition.ulayer.OurPlansPage;
import pages.acquisition.ulayer.SpecialNeedGetEnrollmentInformationPage;
import pages.acquisition.ulayer.PlanSelectorPage;
import pages.acquisition.ulayer.PrescriptionDrugRequestMoreHelpPage;
import pages.acquisition.ulayer.ResumeYourSavedApplicationPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author snagpa4
 *
 */
public class OurPlansAARPStepDefinition {
	
	@Autowired
	MRScenario loginScenario;
	
	

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^user is on the home page of AARP Site$")
	public void the_user_on_AARP_Medicaresolutions_Site() {
		
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@When("^user hovers on Our Plans section of the AARP Medicare Plans home page$")
	public void hover_ourPlans(){
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage != null){
			JSONObject ourPlansDropdownActualJson = aquisitionhomepage
					.accessingOurPlansNav();

			/* Get expected data */
			String fileName = "ourPlansDropdownExpected";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
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

	
	@Then("^user validates all the content and links in the Our Plans drop down$")
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
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		MedicareAdvantagePlansPage medicareAdvantagePlansuhcPage = aquisitionhomepage.medicareAdvantagePlansClick();
		if(medicareAdvantagePlansuhcPage != null){
			getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_UHC_PAGE,
					medicareAdvantagePlansuhcPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in  medicare advantage plans page");
		}
		
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

		
	@And("^user clicks on Medicare Select Hospital Directory link under Medicare Supplement Plans section of our plans drop down from Medicare Supplement Plans page$")
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
	
	
	@And("^user clicks on Resume Your Saved Application link under Medicare Supplement Plans section of our plans drop down from Medicare Select Hospital Directory page$")
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
		
}
