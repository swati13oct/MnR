package acceptancetests.mobile.acquisition.ole;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ole.AuthorizationPage;
import pages.acquisition.ole.CancelOLEModal;
import pages.acquisition.ole.LearnMoreModal;
import pages.acquisition.ole.LeavingOLEmodal;
import pages.acquisition.ole.MedicareInformationPage;
import pages.acquisition.ole.OLEconfirmationPage;
import pages.acquisition.ole.PersonalInformationPage;
import pages.acquisition.ole.PlanPremiumPage;
import pages.acquisition.ole.PrelimineryQuestionsPage;
import pages.acquisition.ole.PrimaryCarePhysicianPage;
import pages.acquisition.ole.ProposedEffectiveDatePage;
import pages.acquisition.ole.ReviewSubmitPage;
import pages.acquisition.ole.SpecialElectionPeriodPage;
import pages.acquisition.ole.SupplementalBenefitsPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.mobile.acquisition.ulayer.ReviewAndSubmitPageMobile;
import pages.mobile.acquisition.ulayer.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.bluelayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;
import pages.mobile.acquisition.planrecommendationengine.CoverageOptionsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DoctorsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DrugMobilePage;
import pages.mobile.acquisition.planrecommendationengine.HeaderFooterMobile;
import pages.mobile.acquisition.planrecommendationengine.LandingAndZipcodeMobilePage;
import pages.mobile.acquisition.planrecommendationengine.LoadingMobilePage;
import pages.mobile.acquisition.planrecommendationengine.PharmacyMobilePage;
import pages.mobile.acquisition.planrecommendationengine.ResultsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.SpecialNeedsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.TravelMobilePage;
import pages.mobile.acquisition.planrecommendationengine.AdditionalServicesMobilePage;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;
import pages.mobile.acquisition.planrecommendationengine.CostPreferencesMobilePage;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OLEStepDefinitionMobile {

	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;


	@Then("^the user clicks on Enroll Now for AARP site to start the OLE flow mobile$")
	public void the_user_clicks_on_Enroll_Now_to_start_the_OLE_flow(DataTable planAttributes) throws Throwable {

		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PlanName = givenAttributesMap.get("Plan Name");
		//String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);

		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR); 
		String PlanPremium = "";
		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String TFN;
		String SiteName;
		SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);	
		System.out.println("sitename---------- : "+SiteName);		System.out.println("PLAN_TYPE---------- : "+PlanType+County);

		//-----------------------------------------------------------------------------------------------------
		WelcomePageMobile welcomePage;
			VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile)getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			System.out.println("sitename---------- : "+SiteName);
			TFN = planSummaryPage.GetTFNforPlanType();
			System.out.println("sitename---------- : "+PlanName);
			//PlanPremium = planSummaryPage.getPlanPremium(PlanName);
			
		welcomePage = planSummaryPage.Enroll_OLE_Plan(PlanName,PlanType);
			System.out.println("sitename---------- : "+PlanName);
		 //--------------------------------------------------------------------------------------------------------------------
		
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

		/*if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Error in validating the OLE Welcome Page");*/
	}
	
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
	
	@Then("^the user validates TFN in Welcome OLE Right Rail$")
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
	@Then("^the user validates the Plan details in Preliminary Questions Pag OLE Right Rail$")
	public void the_user_validates_the_Plan_details_in_Preliminary_Questions_Pag_OLE_Right_Rail() throws Throwable {
		String alreadyEnrolled = (String) getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG);
		boolean alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		if(alreadyEnrolled_Flag){
			System.out.println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "+alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
			getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
			Assert.assertTrue(true);
		}
		else{
			PrelimineryQuestionsPage prelimineryQuestionsPage = (PrelimineryQuestionsPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE);
			Map<String, String> PlanDetailsMap = new HashMap<String, String>();
			PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
			PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
			PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
			PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
			PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));

			boolean Validation_Status = prelimineryQuestionsPage.validate_plan_details(PlanDetailsMap);
			if(Validation_Status){
				System.out.println("Plan Details Validation in OLE Premliminary Questions PAGE : "+Validation_Status+" - Validation Passed");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE, prelimineryQuestionsPage);
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Plan Details Validation in OLE Premliminary Questions PAGE : "+Validation_Status);
				Assert.fail();
			}
		}
	}
	
	@Then("^the user answers following questions in Medicare Information Page$")
	public void the_user_answers_following_questions_in_Coverage_and_Health_Information_Page(DataTable arg1) throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			List<DataTableRow> personalAttributesRow = arg1.getGherkinRows();
			Map<String, String> QuestionMap = new HashMap<String, String>();
			for (int i = 0; i < personalAttributesRow.size(); i++) {
				QuestionMap.put(personalAttributesRow.get(i)
						.getCells().get(0), personalAttributesRow.get(i)
						.getCells().get(1));
			}
			/*		String PDPquestionFlag = QuestionMap.get("PDP Question");
		String LongTermQuestionFlag = QuestionMap.get("LongTerm Question");
			 */
			MedicareInformationPage medInformationPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
			boolean areQuestionsAnswered = medInformationPage.answer_following_questions(QuestionMap);
			if (areQuestionsAnswered) {

			/*
			 * getLoginScenario().saveBean(OLE_PageConstants.OLE_COVERAGE_INFO_PAGE,
			 * medInformationPage);
			 */
				System.out.println("Coverage and Health Information Page : Data entered");
			}
			else
				Assert.fail("Coverage and Health Information Page : Data entry FAILED");
		//}

	}
	@Then("^the user navigates to SEP Page$")
	public void the_user_navigates_to_SEP_Page(DataTable Medicareoptions) throws Throwable {
		/*	
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
			SpecialElectionPeriodPage specialElectionPeriodPage = personalInformationPage.navigate_to_SEP_page(arg1, null);


			if (specialElectionPeriodPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,
						specialElectionPeriodPage);
				System.out.println("OLE SEP Page is Displayed");
				Assert.assertTrue(true);
			}
			else
				Assert.fail("OLE SEP Page is NOT Displayed");
		//}*/
		
		List<DataTableRow> givenAttributesRow = Medicareoptions.getGherkinRows();
		Map<String, String> MedicareDetailsMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			MedicareDetailsMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		SpecialElectionPeriodPage specialElectionPeriodPage = personalInformationPage.navigate_to_SEP_page(MedicareDetailsMap);
		if (specialElectionPeriodPage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,
					specialElectionPeriodPage);
			System.out.println("OLE SEP Page is Displayed");
			
		getLoginScenario().saveBean(oleCommonConstants.PARTA_EFFECTIVE, MedicareDetailsMap.get("PartA Date"));
		getLoginScenario().saveBean(oleCommonConstants.PARTB_EFFECTIVE, MedicareDetailsMap.get("PartB Date"));
			Assert.assertTrue(true);
		}
		else
			Assert.fail("OLE SEP Page is NOT Displayed");
		}
	

	@Then("^the user validates the Plan details in SEP Page OLE Right Rail$")
	public void the_user_validates_the_Plan_details_in_SEP_Page_OLE_Right_Rail() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);

			Map<String, String> PlanDetailsMap = new HashMap<String, String>();
			PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
			PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
			PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
			PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
			PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));

			boolean Validation_Status = specialElectionPeriodPage.validate_plan_details(PlanDetailsMap);
			if(Validation_Status){
				System.out.println("Plan Details Validation in OLE SEP PAGE : "+Validation_Status+" - Validation Passed");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE, specialElectionPeriodPage);
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Plan Details Validation in OLE SEP PAGE : "+Validation_Status);
				Assert.fail();
			}
		//}
	}

	@Then("^the user validates TFN in Right Rail on SEP Page$")
	public void the_user_validates_TFN_in_Right_Rail_on_SEP_Page() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
			String TFN = (String) getLoginScenario().getBean(oleCommonConstants.OLE_TFN);
			boolean Validation_Status = specialElectionPeriodPage.ValidateTFNMedicareInfo(TFN);
			if(Validation_Status){
				System.out.println("TFN, Wunderman Validation in OLE SEP PAGE : "+Validation_Status+" - Validation Passed");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE, specialElectionPeriodPage);
				Assert.assertTrue(true);
			}
			else{
				System.out.println("TFN, Wunderman Validation in OLE SEP PAGE : "+Validation_Status);
				Assert.fail();
			}
		//}
	}

	@Then("^the user validates Leave OLE modal for SEP Page$")
	public void the_user_validates_Leave_OLE_modal_for_SEP_Page() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
			LeavingOLEmodal leaveOLEmodal = specialElectionPeriodPage.OpenLeaveOLEmodal();
			if (leaveOLEmodal != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_LEAVING_MODAL_PAGE,
						leaveOLEmodal);
				System.out.println("Leave OLE modal - Back to OLE ");
			}
			else
				Assert.fail("Leave OLE Modal is NOT Displayed");

			specialElectionPeriodPage = (SpecialElectionPeriodPage) leaveOLEmodal.returntoOLE();
			if (specialElectionPeriodPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,
						specialElectionPeriodPage);
				System.out.println("Back to OLE Application page - OLE SEP Page is Displayed");
			}
			else
				Assert.fail("Back to OLE Application page - OLE SEP Page is NOT Displayed");
		//}
	}
	@Then("^the user selects the following options for SEP Page$")
	public void the_user_selects_the_following_options_for_SEP_Page(DataTable SEPoptions) throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			List<DataTableRow> personalAttributesRow = SEPoptions.getGherkinRows();
			Map<String, String> SEPoptionsFlagMap = new HashMap<String, String>();
			for (int i = 0; i < personalAttributesRow.size(); i++) {
				SEPoptionsFlagMap.put(personalAttributesRow.get(i)
						.getCells().get(0), personalAttributesRow.get(i)
						.getCells().get(1));
			}
			String Selectoptions = SEPoptionsFlagMap.get("Select Options");
			String optionsData = SEPoptionsFlagMap.get("Option Data");

			SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
			specialElectionPeriodPage = specialElectionPeriodPage.select_option_and_enter_data(Selectoptions, optionsData);
			if (specialElectionPeriodPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,
						specialElectionPeriodPage);
				System.out.println("OLE SEP page Options Selected : Next Button enabled");
			}
			else
				Assert.fail("OLE SEP page Options NOT Selected : Next Button NOT enabled");

		//}
	}
	
	@Then("^the user navigates to Proposed Effective Date Page$")
	public void the_user_navigates_to_Proposed_Effective_Date_Page() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
		SpecialElectionPeriodPage sepPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
			ProposedEffectiveDatePage proposedEffectiveDatePage = sepPage.navigate_to_Proposed_Effective_Date_Page();
			if (proposedEffectiveDatePage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_PROPOSED_EFF_DATE_PAGE,
						proposedEffectiveDatePage);
				System.out.println("OLE Proposed Effective Date Page is Displayed");
			}
			else
				Assert.fail("OLE Proposed Effective Date Page is NOT Displayed");
		//}
	}


	@Then("^the user validates Proposed Effective Date is Displayed$")
	public void the_user_validates_proposed_effective_date_display() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			ProposedEffectiveDatePage proposedEffectiveDatePage  = (ProposedEffectiveDatePage) getLoginScenario().getBean(OLE_PageConstants.OLE_PROPOSED_EFF_DATE_PAGE);
			boolean Validation_Status = proposedEffectiveDatePage.validate_proposed_effective_date_options();
			if(Validation_Status){
				System.out.println("Proposed Effective Date display : Validation Passed");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_PROPOSED_EFF_DATE_PAGE, proposedEffectiveDatePage);
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Proposed Effective Date display : Validation Failed");
				Assert.fail();
			}
		//}
	}
	
	@Then("^the user validates PCP page for MA and MAPD PFFS plans$")
	public void the_user_validates_PCP_page_for_MD_and_MAPD_PFFS_plans() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			PrimaryCarePhysicianPage pcpPage = (PrimaryCarePhysicianPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE);
			String planType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
			String planName = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME);
			if(!planType.contentEquals("PDP") && planName.contains("PFFS")){
				System.out.println("Validating Provider Contact Information for PFFS plans");
				boolean Validation_Status = pcpPage.validate_provider_contact_info_in_PCP();
				if(Validation_Status){
					System.out.println("PFFS plan Provider Contact Information Section : Validation Passed");
					getLoginScenario().saveBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE,
							pcpPage);
					Assert.assertTrue(true);
				}
				else{
					System.out.println("PFFS plan Provider Contact Information Section : Validation Failed");
					Assert.fail();
				}
			}
		//}
	}
	
	@Then("^the user validates the Plan and Member details on Review and Submit Page$")
	public void the_user_validates_the_Plan_and_Member_details_on_Review_and_Submit_Page() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			ReviewSubmitPage reviewSubmitPage = (ReviewSubmitPage) getLoginScenario().getBean(OLE_PageConstants.OLE_REVIEW_SUBMIT_PAGE);
			Map<String, String> DetailsMap = new HashMap<String, String>();
			DetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
			DetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
			DetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
			DetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
			DetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));
			DetailsMap.put("First Name", (String) getLoginScenario().getBean(oleCommonConstants.FIRST_NAME));
			DetailsMap.put("Last Name", (String) getLoginScenario().getBean(oleCommonConstants.LAST_NAME));
			DetailsMap.put("Card Type", (String) getLoginScenario().getBean(oleCommonConstants.CARD_TYPE));
			DetailsMap.put("Medicare Number", (String) getLoginScenario().getBean(oleCommonConstants.MEDICARE_NUMBER));
			DetailsMap.put("PartA Date", (String) getLoginScenario().getBean(oleCommonConstants.PARTA_EFFECTIVE));
			DetailsMap.put("PartB Date", (String) getLoginScenario().getBean(oleCommonConstants.PARTB_EFFECTIVE));

			DetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
			DetailsMap.put("DOB", (String) getLoginScenario().getBean(oleCommonConstants.DOB));
			DetailsMap.put("Gender", (String) getLoginScenario().getBean(oleCommonConstants.GENDER));
			DetailsMap.put("Perm_Street", (String) getLoginScenario().getBean(oleCommonConstants.PERM_STREET));
			DetailsMap.put("Perm_city", (String) getLoginScenario().getBean(oleCommonConstants.PERM_CITY));
			DetailsMap.put("MAILING_QUESTION", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_QUESTION));
			DetailsMap.put("Mailing_Street", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_STREET));
			DetailsMap.put("Mailing_City", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_CITY));
			DetailsMap.put("Mailing_State", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_STATE));
			DetailsMap.put("Mailing_Zip", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_ZIP));
			DetailsMap.put("Email", (String) getLoginScenario().getBean(oleCommonConstants.EMAIL));
			
			DetailsMap.put("Prescription Name", (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_COVERAGE_NAME));
			DetailsMap.put("PD Group Number", (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_GROUP_NUMBER));
			DetailsMap.put("PD Member Number", (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_GROUP_NUMBER));
			DetailsMap.put("Health Insurance Name", (String) getLoginScenario().getBean(oleCommonConstants.HEALTH_INSURANCE_NAME));
			DetailsMap.put("Group Number", (String) getLoginScenario().getBean(oleCommonConstants.GROUP_NUMBER));
			DetailsMap.put("Member Number", (String) getLoginScenario().getBean(oleCommonConstants.MEMBER_NUMBER));
	
			boolean Validation_Status = reviewSubmitPage.all_plan_and_member_details(DetailsMap);
			if(Validation_Status){
				System.out.println("Review and Submit Page : All Plan and Member Details Validated");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_REVIEW_SUBMIT_PAGE,
						reviewSubmitPage);
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Review and Submit Page : All Plan and Member Details  NOT validated");
				Assert.fail();
			}
		//}
	}
	

	@Then("^the user navigates to Review and Submit Page$")
	public void the_user_navigates_to_Review_and_Submit_Page() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			AuthorizationPage authorizationPage = (AuthorizationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE);
			ReviewSubmitPage reviewSubmitPage = authorizationPage.navigate_to_Review_Submit_Page();
			if (reviewSubmitPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_REVIEW_SUBMIT_PAGE,
						reviewSubmitPage);
				System.out.println("OLE Review and Submit page is Displayed");
			}
			else
				Assert.fail("OLE Review and Submit page is NOT Displayed");
		//}
	}
	
	@Then("^the user validates required fields for Authorization Page$")
	public void the_user_validates_required_fields_for_Authorization_Page() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			AuthorizationPage authorizationPage = (AuthorizationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE);
			boolean Validation_Status = authorizationPage.validate_required_field();
			if(Validation_Status){
				System.out.println("Authorization Page : Required fields Validated, Required data entered");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE,
						authorizationPage);
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Authorization Page : Required fields NOT validated");
				Assert.fail("Authorization Page : Required fields NOT validated");
			}
		//}
	}

	@Then("^the user navigates to Authorization Page for plan as per following rider options$")
	public void the_user_navigates_to_authorization(DataTable Flags) {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			List<DataTableRow> personalAttributesRow = Flags.getGherkinRows();
			Map<String, String> RiderFlagMap = new HashMap<String, String>();
			for (int i = 0; i < personalAttributesRow.size(); i++) {
				RiderFlagMap.put(personalAttributesRow.get(i)
						.getCells().get(0), personalAttributesRow.get(i)
						.getCells().get(1));
			}
			String RiderFlag = RiderFlagMap.get("Rider Flag");
			if(RiderFlag.contains("true")){
				SupplementalBenefitsPage ridersPage = (SupplementalBenefitsPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SUPPLEMENTAL_BENEFITS_PAGE);
				AuthorizationPage authorizationPage = ridersPage.navigate_to_Authorization_Page();
				if (authorizationPage != null) {

					getLoginScenario().saveBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE,
							authorizationPage);
					System.out.println("OLE Authorization page is Displayed for Plan with Rider");
				}
				else
					Assert.fail("OLE Authorization page is NOT Displayed for Plan with Rider");

			}
			else{
				PlanPremiumPage  planPremiumPage = (PlanPremiumPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PLAN_PREMIUM_PAGE);
				AuthorizationPage authorizationPage = planPremiumPage.navigate_to_Authorization_Page();
				if (authorizationPage != null) {

					getLoginScenario().saveBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE,
							authorizationPage);
					System.out.println("OLE Authorization page is Displayed for Plan without Rider");
				}
				else
					Assert.fail("OLE Authorization page is NOT Displayed for Plan without Rider");
			}
		//}
	}
	
	@Then("^the user navigates to Optional Benefits Page for following plans with available Riders$")
	public void the_user_navigates_to_optional_rider_Page(DataTable Flags) {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
		
			List<DataTableRow> personalAttributesRow = Flags.getGherkinRows();
			Map<String, String> RiderFlagMap = new HashMap<String, String>();
			for (int i = 0; i < personalAttributesRow.size(); i++) {
				RiderFlagMap.put(personalAttributesRow.get(i)
						.getCells().get(0), personalAttributesRow.get(i)
						.getCells().get(1));
			}
			String RiderFlag = RiderFlagMap.get("Rider Flag");
			if(RiderFlag.contains("true")){
				PlanPremiumPage  planPremiumPage = (PlanPremiumPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PLAN_PREMIUM_PAGE);
				SupplementalBenefitsPage ridersPage = planPremiumPage.navigate_to_Supplemental_Riders_Page();
				if (ridersPage != null) {

					getLoginScenario().saveBean(OLE_PageConstants.OLE_SUPPLEMENTAL_BENEFITS_PAGE,
							ridersPage);
					System.out.println("OLE Supplemental Benefits page is Displayed");
				}
				else
					Assert.fail("OLE Supplemental Benefits page is NOT Displayed");

			}
		//}
	}
	
	@Then("^the user navigates to Monthly Plan Premium Page$")
	public void the_user_navigates_to_Monthly_Plan_Premium_Page() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			String planType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
			PrimaryCarePhysicianPage pcpPage = (PrimaryCarePhysicianPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE);

			if(!planType.contentEquals("PDP")){
				PlanPremiumPage  planPremiumPage = (PlanPremiumPage) pcpPage.navigate_to_Plan_Premium_Page();
				if (planPremiumPage != null) {

					getLoginScenario().saveBean(OLE_PageConstants.OLE_PLAN_PREMIUM_PAGE,
							planPremiumPage);
					System.out.println("PCP Page is not Displayed : OLE Monthly Plan Premium Page is Displayed for Plantype : "+planType);
				}
				else
					Assert.fail("OLE Monthly Plan Premium Page is NOT Displayed for Plantype : "+planType);
			}
		//}
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
	
	@Then("^the user validates Learn more modal for Welcome OLE$")
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

		welcomePage = (WelcomePage) learnMoremodal.returntoOLE();
		if (welcomePage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("Back to OLE Application page - Welcome Page is Displayed");
		}
		else
			Assert.fail("Back to OLE Application page - Welcome Page is NOT Displayed");
	}
	
	@Then("^the user validates Leave OLE modal for Welcome OLE$")
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

		welcomePage = (WelcomePage) leaveOLEmodal.returntoOLE();
		if (welcomePage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("Back to OLE Application page - Welcome Page is Displayed");
		}
		else
			Assert.fail("Back to OLE Application page - Welcome Page is NOT Displayed");

	}	
	
	@Then("^the user validates cancellation modal for Welcome OLE$")
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

		welcomePage = (WelcomePage) cancelOLEmodal.returntoOLE();
		if (welcomePage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("Back to OLE Application page - Welcome Page is Displayed");
		}
		else
			Assert.fail("Back to OLE Application page - Welcome Page is NOT Displayed");
	}
	
	@Then("^the user navigates to Personal Information Page$")
	public void the_user_navigates_to_Personal_Information_Page() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
			PersonalInformationPage personalInformationPage = welcomePage.navigate_to_Personal_Information_page();

			if (personalInformationPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
						personalInformationPage);
				System.out.println("OLE Personal Information Page is Displayed");
				Assert.assertTrue(true);
			}
			else
				Assert.fail("OLE Personal Information Page is NOT Displayed");
		//}
	}
	
	@Then("^the user enters following required information in Personal Information Page$")
	public void the_user_enters_following_required_information_in_Personal_Information_Page(DataTable arg1) throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			List<DataTableRow> givenAttributesRow = arg1.getGherkinRows();
			Map<String, String> MemberDetailsMap = new HashMap<String, String>();
			for (int i = 0; i < givenAttributesRow.size(); i++) {
				MemberDetailsMap.put(givenAttributesRow.get(i).getCells().get(0),
						givenAttributesRow.get(i).getCells().get(1));
			}
			PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
			boolean isFormFilled = personalInformationPage.enter_member_details(MemberDetailsMap);
			if (isFormFilled) {
				getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
						personalInformationPage);
				System.out.println("OLE Personal Information Page - All required Member Details are entered");
				getLoginScenario().saveBean(oleCommonConstants.FIRST_NAME, MemberDetailsMap.get("First Name"));
				getLoginScenario().saveBean(oleCommonConstants.LAST_NAME, MemberDetailsMap.get("Last Name"));
				getLoginScenario().saveBean(oleCommonConstants.DOB, MemberDetailsMap.get("DOB"));
				getLoginScenario().saveBean(oleCommonConstants.GENDER, MemberDetailsMap.get("Gender"));
				getLoginScenario().saveBean(oleCommonConstants.PERM_STREET, MemberDetailsMap.get("Perm_Street"));
				getLoginScenario().saveBean(oleCommonConstants.PERM_CITY, MemberDetailsMap.get("Perm_city"));
				getLoginScenario().saveBean(oleCommonConstants.MAILING_QUESTION, MemberDetailsMap.get("Mailing Address Question"));
				getLoginScenario().saveBean(oleCommonConstants.MAILING_STREET, MemberDetailsMap.get("Mailing_Street"));
				getLoginScenario().saveBean(oleCommonConstants.MAILING_CITY, MemberDetailsMap.get("Mailing_City"));
				getLoginScenario().saveBean(oleCommonConstants.MAILING_STATE, MemberDetailsMap.get("Mailing_State"));
				getLoginScenario().saveBean(oleCommonConstants.MAILING_ZIP, MemberDetailsMap.get("Mailing_Zip"));
				getLoginScenario().saveBean(oleCommonConstants.EMAIL, MemberDetailsMap.get("Email"));
				Assert.assertTrue(true);
			}
			else
				Assert.fail("OLE Personal Information Page - Adding Member Details Failed");
		//}
	}

	@Then("^the user validates the Plan details in Personal Information Page OLE Right Rail$")
	public void the_user_validates_the_Plan_details_in_Personal_Information_Page_OLE_Right_Rail() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
			Map<String, String> PlanDetailsMap = new HashMap<String, String>();
			PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
			PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
			PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
			PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
			PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));

			boolean Validation_Status = personalInformationPage.validate_plan_details(PlanDetailsMap);
			if(Validation_Status){
				System.out.println("Plan Details Validation in OLE Personal Information PAGE : "+Validation_Status+" - Validation Passed");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE, personalInformationPage);
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Plan Details Validation in OLE Personal Information PAGE : "+Validation_Status);
				Assert.fail();
			}
		//}
	}
	

	@Then("^the user validates the Member details dynamic display in Personal Information Page$")
	public void the_user_validates_the_Member_details_in_Personal_Information_Page_OLE_Right_Rail() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
			Map<String, String> MemberDetailsMap = new HashMap<String, String>();
			MemberDetailsMap.put("First Name", (String) getLoginScenario().getBean(oleCommonConstants.FIRST_NAME));
			MemberDetailsMap.put("Last Name", (String) getLoginScenario().getBean(oleCommonConstants.LAST_NAME));
			MemberDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
			MemberDetailsMap.put("Mailing_State", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_STATE));
			boolean Validation_Status = personalInformationPage.validate_member_details(MemberDetailsMap);
			if(Validation_Status){
				System.out.println("Member Details Validation in OLE Personal Information PAGE : - Validation Passed");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE, personalInformationPage);
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Member Details Validation in OLE Personal Information PAGE : - Validation Failed");
				Assert.fail();
			}
		//}
	}


	@Then("^the user navigates to Medicare Information Page$")
	public void the_user_navigates_to_Medicare_Information_Page() throws Throwable {
		PersonalInformationPage personalInfoPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		MedicareInformationPage medicareInfoPage = personalInfoPage.navigate_to_medicare_info_page();
		if (medicareInfoPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Medicare Information Page is Displayed");
			Assert.assertTrue(true);
		}
		else
			Assert.fail("OLE Medicare Information Page is NOT Displayed");
	}
	
	
	@Then("^the user enters following required Medicare Information$")
	public void the_user_enters_Medicare_Details_in_medicare_info_page(DataTable planAttributes) throws Throwable {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> MedicareDetailsMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			MedicareDetailsMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String CardType = MedicareDetailsMap.get("Card Type");
		if(CardType.contains("HICN")){
			Random rnd = new Random();
			int n = 100000000 + rnd.nextInt(900000000);
			String MedicareNumber = Integer.toString(n)+"C";
			MedicareDetailsMap.put("Medicare Number", MedicareNumber);
			
			}
		else if(CardType.contains("RRID")){
			Random rnd = new Random();
			int n = 100000000 + rnd.nextInt(900000000);
			String MedicareNumber = "RID"+Integer.toString(n);
			MedicareDetailsMap.put("Medicare Number", MedicareNumber);
		
			}
		String SSNflag = MedicareDetailsMap.get("SSN Flag");
		if(SSNflag.contains("true")){
			MedicareDetailsMap.put("SSN Number", "123456789");
		}
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);

		boolean isInformationFilled = medicareInfoPage.enter_required_Medicare_details(MedicareDetailsMap);
		if (isInformationFilled) {

		//	getLoginScenario().saveBean(oleCommonConstants.FIRST_NAME, MedicareDetailsMap.get("First Name"));
		//	getLoginScenario().saveBean(oleCommonConstants.LAST_NAME, MedicareDetailsMap.get("Last Name"));
			getLoginScenario().saveBean(oleCommonConstants.MEDICARE_NUMBER, MedicareDetailsMap.get("Medicare Number"));
			getLoginScenario().saveBean(oleCommonConstants.CARD_TYPE, MedicareDetailsMap.get("Card Type"));
		//	getLoginScenario().saveBean(oleCommonConstants.PARTA_EFFECTIVE, MedicareDetailsMap.get("PartA Date"));
		//	getLoginScenario().saveBean(oleCommonConstants.PARTB_EFFECTIVE, MedicareDetailsMap.get("PartB Date"));
			getLoginScenario().saveBean(oleCommonConstants.SSN_FLAG, MedicareDetailsMap.get("SSN Flag"));
			getLoginScenario().saveBean(oleCommonConstants.SSN_NUMBER, MedicareDetailsMap.get("SSN Number"));

			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Medicare Information Page, Medicare Info is entered and Next Button is enabled");
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Medicare Info data entry failed");
	}
	

	@Then("^the user validates the Plan details in Medicare Info OLE Right Rail")
	public void the_user_validates_the_Plan_details_in_Medicare_Info_OLE_Right_Rail() throws Throwable {
		MedicareInformationPage MedicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);

		Map<String, String> PlanDetailsMap = new HashMap<String, String>();
		PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
		PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
		PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
		PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
		PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));

		boolean Validation_Status = MedicareInfoPage.validate_plan_details(PlanDetailsMap);
		if(Validation_Status){
			System.out.println("Plan Details Validation in OLE Medicare Information  PAGE : "+Validation_Status+" - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, MedicareInfoPage);
			Assert.assertTrue(true);
		}
		else{
			System.out.println("Plan Details Validation in OLE Medicare Information PAGE : "+Validation_Status);
			Assert.fail();
		}
	}

	@Then("^the user validates requierd ESRD on Medicare Info Page$")
	public void the_user_validates_requierd_fields_for_Preliminary_Questions_Page(DataTable Flags) throws Throwable {


		List<DataTableRow> personalAttributesRow = Flags.getGherkinRows();
		Map<String, String> PreliminaryFlagsMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {
			PreliminaryFlagsMap.put(personalAttributesRow.get(i)
					.getCells().get(0), personalAttributesRow.get(i)
					.getCells().get(1));
		}
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			String MedicaidNumber = PreliminaryFlagsMap.get("MedicaidNumber");
			String PlanType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
			String planName = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME);
			//String planyear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);
			String planYear = PreliminaryFlagsMap.get("Plan Year");
			
			MedicareInformationPage medInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
			boolean Validation_Status = medInfoPage.validate_Required_Fields(PlanType, MedicaidNumber,planName,planYear);
			if(Validation_Status){
				System.out.println("Preliminary Questions Validation for required fields in OLE Preliminary Questions PAGE - Validation Passed : "+Validation_Status);
				getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, medInfoPage);
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Preliminary Questions Validation for required fields in OLE Preliminary Questions PAGE - Validation Failed : "+Validation_Status);
				Assert.fail();
			}
		//}
	}
	
	@Then("^the user validates the dispalyed sections for the Plan Type in Medicare Information Page$")
	public void the_user_validates_the_dispalyed_sections_for_the_Plan_Type_in_Coverage_and_Health_Information_Page() throws Throwable {
		/*
		 * String alreadyEnrolled = (String)
		 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
		 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		 * if(alreadyEnrolled_Flag){ System.out.
		 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
		 * +alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
		 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
		 * Assert.assertTrue(true); } else{
		 */
			MedicareInformationPage medInformationPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
			String PlanType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
			boolean Validation_Status = medInformationPage.validate_CoverageInfo_Questions_for_planType(PlanType);
			if(Validation_Status){
				System.out.println("Plan Type Questions Validation in OLE Coverage and Health PAGE : Validation Passed");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, medInformationPage);
				Assert.assertTrue(true);
			}
			else{
				System.out.println("Plan Type Questions Validation in OLE Coverage and Health PAGE : Validation Failed");
				Assert.fail();
			}
		//}
	}
	

@Then("^the user validates the long term questions in Medicare Information Page$")
public void the_user_validates_the_long_term_questions_in_Medicare_Information_Page(DataTable arg1) throws Throwable {
		
	List<DataTableRow> givenAttributesRow = arg1.getGherkinRows();
		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			MemberDetailsMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		boolean medicareInfoPageLongTerm = medicareInfoPage.answer_following_questionsLongTerm(MemberDetailsMap);
		if (medicareInfoPageLongTerm) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Other Insurance Questions in Medicare Information Page - All required Member Details are entered");
			getLoginScenario().saveBean(oleCommonConstants.HEALTH_INSURANCE_NAME, MemberDetailsMap.get("Health Insurance Name"));
			getLoginScenario().saveBean(oleCommonConstants.GROUP_NUMBER, MemberDetailsMap.get("Group Number"));
			getLoginScenario().saveBean(oleCommonConstants.MEMBER_NUMBER, MemberDetailsMap.get("Member Number"));
			Assert.assertTrue(true);
		}
		else
			Assert.fail("OLE Other Insurance Questions in Medicare Information Page - Adding Member Details Failed");
	}

@Then("^the user validates the Prescription drug coverage questions in Medicare Information Page$")
public void the_user_validates_the_Prescription_drugcoverage_questions_in_Medicare_Information_Page(DataTable arg1) throws Throwable {
		
	List<DataTableRow> givenAttributesRow = arg1.getGherkinRows();
		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			MemberDetailsMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		boolean medicareInfoPageLongTerm = medicareInfoPage.answer_following_questions_PrescriptionCoverage(MemberDetailsMap);
		if (medicareInfoPageLongTerm) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Prescription drug coverage Questions in Medicare Information Page - All required Member Details are entered");
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_COVERAGE_NAME, MemberDetailsMap.get("Prescription Name"));
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_GROUP_NUMBER, MemberDetailsMap.get("PD Group Number"));
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_MEMBER_NUMBER, MemberDetailsMap.get("PD Member Number"));
			Assert.assertTrue(true);
		}
		else
			Assert.fail("OLE Other Insurance Questions in Medicare Information Page - Adding Member Details Failed");
	}


@Then("^the user clicks on Submit Enrollment to complete enrollment$")
public void the_user_clicks_on_Submit_Enrollment_to_complete_enrollment() throws Throwable {
	/*
	 * String alreadyEnrolled = (String)
	 * getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG); boolean
	 * alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true")) ? true :
	 * false; if (alreadyEnrolled_Flag) { System.out.
	 * println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "
	 * + alreadyEnrolled + "  :  " + alreadyEnrolled_Flag + " - Validation Passed");
	 * getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,
	 * "true"); Assert.assertTrue(true); } else {
	 */
		if (!(MRScenario.environment.equalsIgnoreCase("offline")
				|| MRScenario.environment.equalsIgnoreCase("prod"))) {
			ReviewAndSubmitPageMobile reviewSubmitPage = (ReviewAndSubmitPageMobile) getLoginScenario()
					.getBean(OLE_PageConstants.OLE_REVIEW_SUBMIT_PAGE);
			OLEconfirmationPage oleConfirmationPage = reviewSubmitPage.submitEnrollment();
			if (oleConfirmationPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE, oleConfirmationPage);
				System.out.println("OLE Confirmation Page is Displayed");
			} else {
				getLoginScenario().saveBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE, oleConfirmationPage);
				System.out.println("OLE Confirmation Page is NOT Displayed : OLE Submission Failed");				}
		} else {
			System.out.println("Skipping the submit functionality in Offline-Prod environment");
		}
	//}
}

}