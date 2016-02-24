/**
 * 
 */
package acceptancetests.globalheader.bluelayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.MedicareAdvantagePlansuhcPage;
import pages.acquisition.bluelayer.MedicareAdvantageRequestMoreHelpPage;
import pages.acquisition.bluelayer.MedicarePrescriptionDrugPlansuhcPage;
import pages.acquisition.bluelayer.MedicareSelectHospitalDirectoryPage;
import pages.acquisition.bluelayer.MedicareSpecialNeedsPlansuhcPage;
import pages.acquisition.bluelayer.MedicareSupplementPlansuhcPage;
import pages.acquisition.bluelayer.OurPlansPage;
import pages.acquisition.bluelayer.PlanSelectorPage;
import pages.acquisition.bluelayer.PrescriptionDrugRequestMoreHelpPage;
import pages.acquisition.bluelayer.ResumeYourSavedApplicationPage;
import pages.acquisition.bluelayer.SpecialNeedGetEnrollmentInformationPage;
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
 * @author rkodumur
 *
 */
public class OurPlansDropdownUmsStepDefinition {
	
	@Autowired
	MRScenario loginScenario;
	
	

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^user is on the home page of UMS Site$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
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
	
	@And("^user clicks on Medicare Select Hospital Directory link under Medicare Supplement Plans section of our plans drop down from Medicare Supplement Plans page$")
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
	@After
    public void tearDown() {
           WebDriver wd = (WebDriver) getLoginScenario().getBean(
                        CommonConstants.WEBDRIVER);
           wd.quit();
           getLoginScenario().flushBeans();
    }
	
}
