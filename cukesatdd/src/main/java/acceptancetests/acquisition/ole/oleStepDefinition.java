package acceptancetests.acquisition.ole;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisitionvbf.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ole.CancelOLEModal;
import pages.acquisition.ole.LearnMoreModal;
import pages.acquisition.ole.LeavingOLEmodal;
import pages.acquisition.ole.MedicareInformationPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.BeneficiaryInformationPage;
import pages.acquisition.ulayer.ComparePlansPage;
import pages.acquisition.ulayer.ConfirmationPage;
import pages.acquisition.ulayer.ESRDPage;
import pages.acquisition.ulayer.IntroductionInformationPage;
import pages.acquisition.ulayer.LongTermCarePage;
import pages.acquisition.ulayer.MedicaidPage;
import pages.acquisition.ulayer.OptionalRidersPage;
import pages.acquisition.ulayer.OtherHealthInsurancePage;
import pages.acquisition.ulayer.PDPEnrollementGuidePage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.PlanPaymentOptions;
import pages.acquisition.ulayer.PrescriptionDrugCoveragePage;
import pages.acquisition.ulayer.PrimaryCareProviderPage;
import pages.acquisition.ulayer.ProposedEffectiveDatePage;
import pages.acquisition.ulayer.ReviewAndSubmitPage;
import pages.acquisition.ulayer.SpecialElectionPeriodPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

/**
 * @author sdwaraka
 * Functionality:OLE Common Tool for both AAPR and UHC acquisition sites
 */
public class oleStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	
	/**
	 * @author sdwaraka
	 * 
	 * @param planAttributes
	 * @throws Throwable
	 */
	@Given("^the user lands on OLE Welcome Page wity following Plan Details$")
	public void the_user_lands_on_OLE_Welcome_Page_wity_following_Plan_Details(DataTable planAttributes) throws Throwable {
		
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PlanName = givenAttributesMap.get("Plan Name");
		String PlanPremium = givenAttributesMap.get("Premium");
		String County = givenAttributesMap.get("County Name");
		String ZipCode = givenAttributesMap.get("Zip Code");
		String PlanType = givenAttributesMap.get("Plan Type");
		String PlanYear = "2018"; 
		String SiteName =  "AARP_ACQ";
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		
		//Hard Coding OLE Welcome Page URL for Build Validation Test
		String OLE_URL = "https://www.team-f-aarpmedicareplans.ose-elr-core.optum.com/content/aarpmedicareplans/en/enrollment.html";
		
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		WelcomePage welcomePage = new WelcomePage(wd, OLE_URL);
		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Error in validating the OLE Welcome Page");
	}

	
	
	/**
	 * @author sdwaraka
	 * To start Enroll Now and land on Welcome Page from Plan Summary Page of VPP
	 * @param planAttributes
	 * @throws Throwable
	 */
	@Then("^the user clicks on Enroll Now for AARP site to start the OLE flow$")
	public void the_user_clicks_on_Enroll_Now_to_start_the_OLE_flow(DataTable planAttributes) throws Throwable {
		
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PlanName = givenAttributesMap.get("Plan Name");
		//String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);

		String PlanYear = "2018"; 
		String PlanPremium;
		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String TFN;
		String SiteName = "AARP_ACQ";
			
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		TFN = planSummaryPage.GetTFNforPlanType();
		
		PlanPremium = planSummaryPage.getPlanPremium(PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : "+PlanName);
		System.out.println("Plan Type is : "+PlanType);
		System.out.println("Plan Zip Code is : "+ZipCode);
		System.out.println("Plan County Name is : "+County);
		System.out.println("Plan Plan Premium is : "+PlanPremium);
		System.out.println("TFN for Plan Type is : "+TFN);
		System.out.println("Plan Year is : "+PlanYear);
		System.out.println("OLE is being started from Acquisition Site : "+SiteName);
		
		WelcomePage welcomePage = planSummaryPage.Enroll_OLE_Plan(PlanName);
		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Error in validating the OLE Welcome Page");
	}
	
	/**
	 * @author sdwaraka
	 * To start Enroll Now and land on Welcome Page from Plan Details Page of VPP
	 * @param planAttributes
	 * @throws Throwable
	 */
	@Then("^the user clicks on Enroll Now in Plan Details Page to start the OLE flow$")
	public void the_user_clicks_on_Enroll_Now_in_Plan_Details_Page_to_start_the_OLE_flow() throws Throwable {
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String PlanYear = "2018"; 
		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String TFN;
		String SiteName = "AARP_ACQ";
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		
			
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		TFN = vppPlanDetailsPage.GetTFNforPlanType();
		String PlanPremium = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM);
		//PlanPremium = vppPlanDetailsPage.getPlanPremium(PlanName);
		//getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : "+PlanName);
		System.out.println("Plan Type is : "+PlanType);
		System.out.println("Plan Zip Code is : "+ZipCode);
		System.out.println("Plan County Name is : "+County);
		System.out.println("Plan Plan Premium is : "+PlanPremium);
		System.out.println("TFN for Plan Type is : "+TFN);
		System.out.println("Plan Year is : "+PlanYear);
		System.out.println("OLE is being started from Acquisition Site : "+SiteName);
		
		WelcomePage welcomePage = vppPlanDetailsPage.Enroll_OLE_Plan(PlanName);
		if (welcomePage != null) {
			
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Error in validating the OLE Welcome Page");
	}
	

@Then("^the user clicks on Enroll Now in Plan Compare Page for the following Plan to start the OLE flow$")
public void the_user_get_Plan_Details_for_the_following_Plan(DataTable planAttributes) throws Throwable {
	List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
	Map<String, String> givenAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < givenAttributesRow.size(); i++) {

		givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
				givenAttributesRow.get(i).getCells().get(1));
	}
	String PlanName = givenAttributesMap.get("Plan Name");
	ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario().getBean(PageConstants.PLAN_COMPARE_PAGE);
	
	WelcomePage welcomePage = comparePlansPage.Enroll_OLE_Plan(PlanName);
	if (welcomePage != null) {
		
		getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
				welcomePage);
		System.out.println("OLE Welcome Page is Displayed");
		Assert.assertTrue(true);
	}
	else
		Assert.fail("Error in validating the OLE Welcome Page");
	
}
	
	/**
	 * @author sdwaraka
	 * To Validate the Plan Details carried forward from VPP on Welcome Page of VPP
	 * @param planAttributes
	 * @throws Throwable
	 */
	@Then("^the user validates the Plan details on OLE$")
	public void the_user_validates_the_Plan_details_on_OLE() throws Throwable {
		
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		Map<String, String> PlanDetailsMap = new HashMap<String, String>();
		PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
		PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
		PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
		PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
		PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));
		
		boolean Validation_Status = welcomePage.validate_plan_details(PlanDetailsMap);
		if(Validation_Status){
			System.out.println("Plan Details Validation in OLE PAGE : "+Validation_Status+" - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			Assert.assertTrue(true);
		}
		else{
			System.out.println("Plan Details Validation in OLE PAGE : "+Validation_Status);
			Assert.fail();
		}
	}

	@Then("^the user validates TFN in Right Rail$")
	public void the_user_validates_TFN_in_Right_Rail() throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		String TFN = (String) getLoginScenario().getBean(oleCommonConstants.OLE_TFN);
		boolean Validation_Status = welcomePage.ValidateTFN(TFN);
		if(Validation_Status){
			System.out.println("TFN, Wunderman Validation in OLE PAGE : "+Validation_Status+" - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			Assert.assertTrue(true);
		}
		else{
			System.out.println("TFN, Wunderman Validation in OLE PAGE : "+Validation_Status);
			Assert.fail();
		}
	}


	@Then("^the user validates Learn more modal for OLE$")
	public void the_user_validates_Learn_more_modal_for_OLE() throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		LearnMoreModal learnMoremodal = welcomePage.OpenLearnMore();
		if (learnMoremodal != null) {
			
			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					learnMoremodal);
			System.out.println("OLE Learn More Modal is Displayed");
		}
		else
			Assert.fail("OLE Learn More Modal is NOT Displayed");
		
		welcomePage = learnMoremodal.returntoOLE();
		if (welcomePage != null) {
			
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("Back to OLE Application page - Welcome Page is Displayed");
		}
		else
			Assert.fail("Back to OLE Application page - Welcome Page is NOT Displayed");
	}

	@Then("^the user validates cancellation modal for OLE$")
	public void the_user_validates_cancellation_modal_for_OLE() throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		CancelOLEModal cancelOLEmodal = welcomePage.OpenCancelOLE();
		if (cancelOLEmodal != null) {
			
			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					cancelOLEmodal);
			System.out.println("OLE Cancellation Modal is Displayed");
		}
		else
			Assert.fail("OLE Cancellation Modal is NOT Displayed");
		
		welcomePage = cancelOLEmodal.returntoOLE();
		if (welcomePage != null) {
			
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("Back to OLE Application page - Welcome Page is Displayed");
		}
		else
			Assert.fail("Back to OLE Application page - Welcome Page is NOT Displayed");
	}

	@Then("^the user validates Leave OLE modal for OLE$")
	public void the_user_validates_Leave_OLE_modal_for_OLE() throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		LeavingOLEmodal leaveOLEmodal = welcomePage.OpenLeaveOLEmodal();
		if (leaveOLEmodal != null) {
			
			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					leaveOLEmodal);
			System.out.println("Leave OLE modal - Back to OLE ");
		}
		else
			Assert.fail("Leave OLE Modal is NOT Displayed");
		
		welcomePage = leaveOLEmodal.returntoOLE();
		if (welcomePage != null) {
			
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("Back to OLE Application page - Welcome Page is Displayed");
		}
		else
			Assert.fail("Back to OLE Application page - Welcome Page is NOT Displayed");

	}


	@Then("^the user validates and selects the Disclaimer Checkbox$")
	public void the_user_validates_and_selects_the_Disclaimer_Checkbox() throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		boolean Validation_Status = welcomePage.validateDisclaimerCheckBox();
		if(Validation_Status){
			System.out.println("Disclaimer agreement Checkbox Validation : "+Validation_Status);
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			Assert.assertTrue(true);
		}
		else{
			System.out.println("Disclaimer agreement Checkbox Validation : "+Validation_Status);
			Assert.fail();
		}
	}

	@Then("^the user navigates to Medicare Information Page$")
	public void the_user_navigates_to_Medicare_Information_Page() throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		MedicareInformationPage medicareInfoPage = welcomePage.navigate_to_medicare_info_page();
		if (medicareInfoPage != null) {
			
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Medicare Information Page is Displayed");
			Assert.assertTrue(true);
		}
		else
			Assert.fail("OLE Medicare Information Page is NOT Displayed");
	}

	@Then("^the user validates Medicare Information Page required fields$")
	public void the_user_validates_Medicare_Information_Page_required_fields() throws Throwable {
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		boolean Validation_Status = medicareInfoPage.validate_required_fields();
		if(Validation_Status){
			System.out.println("Medicare Information Page required fields : "+Validation_Status);
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, medicareInfoPage);
			Assert.assertTrue(true);
		}
		else{
			System.out.println("Medicare Information Page required fields : "+Validation_Status);
			Assert.fail();
		}
	}

}
