package acceptancetests.acquisitionvbf.enrollinplan;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AdditionalInformationPage;
import pages.acquisition.bluelayer.BeneficiaryInformationPage;
import pages.acquisition.bluelayer.EnrollPlanInfoPage;
import pages.acquisition.bluelayer.EnrollmentConfirmationPage;
import pages.acquisition.bluelayer.PlanInformationPage;
import pages.acquisition.bluelayer.ReviewApplicationPage;
import pages.acquisition.bluelayer.SubmitApplicationPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import acceptancetests.acquisitionvbf.common.CommonStepDefinition;
import acceptancetests.acquisitionvbf.vpp.VPPCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality: Enroll In Plan
 */
public class EnrollInPlanStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	private Map<String, String> memberAttributesMap =null;
	
	private List<DataTableRow> memberAttributesRow = new CommonStepDefinition().getAttributesRow();
	
	/**
	 * @toDo:user performs plan search using following information
	 */
	@When("^user performs plan search using following information in UHC site$")
	public void zipcode_details_in_uhc_site(DataTable givenAttributes) {
		if(memberAttributesRow.size()>0){
		        for (int i = 0; i < memberAttributesRow.size(); i++) {
		               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),memberAttributesRow.get(i).getCells().get(1));
		        }
	        }
		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.searchPlans(
				zipcode, county);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			if (plansummaryPage.validatePlanSummary()) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error in validating available plans check ");
			}
		}
	}

	/**
	 * @toDo:user views plans of the below plan type
	 */
	@And("^the user views plans of the below plan type in UHC site$")
	public void user_performs_planSearch_in_aarp_site() {
		if(memberAttributesRow.size()>0){
	        for (int i = 0; i < memberAttributesRow.size(); i++) {
	               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),memberAttributesRow.get(i).getCells().get(1));
	        }
        }
		String plantype = memberAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			if (plansummaryPage.validateAvailablePlans(plantype)) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error in validating available plans check ");
			}
		}
	}

	/**
	 * @toDo: user enrolls for the below plan 
	 */
	@And("^the user enrolls for the below plan in UHC site$")
	public void user_enrolls_for_plan() {
		String planName = memberAttributesRow.get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(EnrollInPlanCommonConstants.PLAN_NAME,
				planName);
		String zipcode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);

		String zipCountyInfo = zipcode +" ("+county+")";

		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		EnrollPlanInfoPage enrollPlanInfoPage = planSummaryPage.clicksOnEnrollInplanLink(planName);
		if (enrollPlanInfoPage != null) {
			if (enrollPlanInfoPage.validatePlanChoosenforEnroll(planName,zipCountyInfo)) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error in validating choosen plan for enroll in check ");
			}

			PlanInformationPage planInformationPage = enrollPlanInfoPage.continuesEnrollment(planName);
			getLoginScenario().saveBean(PageConstants.PLAN_INFORMATION,
					planInformationPage);
		
			if (planInformationPage != null) {
		} else {
			Assert.fail("ERROR loading PlanInformationPage");
		}
		}

	}

	/**
	 * @toDo:user select the answer of this question Do you have End-Stage Renal Disease
	 */
	@And("^the user select the answer of this question Do you have End-Stage Renal Disease in UHC site$")
	public void user_selects_answer_esrd_question() {
		String answer = memberAttributesRow.get(0).getCells().get(0);
		String planName = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.PLAN_NAME);
		if(planName.contains("HMO")){
			PlanInformationPage planInformationPage = (PlanInformationPage) getLoginScenario()
					.getBean(PageConstants.PLAN_INFORMATION);
			planInformationPage.asnwersESRDQuestion(answer);
			getLoginScenario().saveBean(PageConstants.PLAN_INFORMATION,
					planInformationPage);
		}
	}
	
	/**
	 * @toDo:user navigates to Benefit information 
	 */
	@And("^the user navigates to Benefit information step in UHC site$")
	public void the_user_navigates_benefit_information_step_aarp() {

		PlanInformationPage planInformationPage = (PlanInformationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_INFORMATION);
		BeneficiaryInformationPage beneficiaryInformationPage = planInformationPage
				.navigateToNextStep();
		getLoginScenario().saveBean(PageConstants.BENEFICIARY_INFORMATION_PAGE,
				beneficiaryInformationPage);
		if (beneficiaryInformationPage != null) {
			/* Get actual data */
			JSONObject beneficiaryInformationActual = beneficiaryInformationPage.getBeneficiaryActualData();
			System.out
			.println("beneficiaryInformationActual---->" + beneficiaryInformationActual);

			/* Get expected data */
			String planName = (String) getLoginScenario().getBean(
					EnrollInPlanCommonConstants.PLAN_NAME);


			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);
			String zipCountyInfo = zipcode +" ("+county+")";

			if(beneficiaryInformationPage.validateBeneficiaryPage(beneficiaryInformationActual,planName,zipCountyInfo)){
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error in validating beneficiary information page check ");
			}	
		} else {
			Assert.fail("ERROR loading BeneficiaryInformationPage");
		}

	}

	/**
	 * @toDo:user fill following information in beneficiary information
	 */
	@And("^the user fill following information in beneficiary information step in UHC site$")
	public void user_fill_information_beneficiary_information_aarp(
			) {
		if(memberAttributesRow.size()>0){
	        for (int i = 0; i < memberAttributesRow.size(); i++) {
	               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),memberAttributesRow.get(i).getCells().get(1));
	        }
        }
		String name = memberAttributesMap.get("First Name") + " "+ memberAttributesMap.get("Middle Initial") +". "+memberAttributesMap.get("Last Name");
		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_NAME,
				name);
		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_DOB,
				memberAttributesMap.get("Birth Date"));

		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_GENDER,
				memberAttributesMap.get("Gender"));

		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_MCARENUMBER,
				memberAttributesMap.get("Medicare Claim Number").replaceAll("-", ""));

		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_ADDRESS,
				memberAttributesMap.get("Address"));

		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_APARTMENT,
				memberAttributesMap.get("Apartment"));

		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_CITY,
				memberAttributesMap.get("City"));

		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_ADDRESSPREFERENCE,
				memberAttributesMap.get("Same Mailing Address"));

		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_PHNUMBER,
				memberAttributesMap.get("Main Phone Number").replaceAll("-", ""));

		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_OTHERPHNUMBER,
				memberAttributesMap.get("Other Phone Number").replaceAll("-", ""));

		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_EMAILADDRESS,
				memberAttributesMap.get("Email Address"));

		getLoginScenario().saveBean(EnrollInPlanCommonConstants.ENROLLER_LANGUAGEPREFERENCE,
				memberAttributesMap.get("Language Preference"));

		BeneficiaryInformationPage beneficiaryInformationPage = (BeneficiaryInformationPage) getLoginScenario()
				.getBean(PageConstants.BENEFICIARY_INFORMATION_PAGE);
		beneficiaryInformationPage
		.entersPersonalInformation(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.BENEFICIARY_INFORMATION_PAGE,
				beneficiaryInformationPage);

	}

	/**
	 * @toDo:user navigates to Additional Information step
	 */
	@And("^the user navigates to Additional Information step in UHC site$")
	public void user_navigates_additional_information_aarp() {

		BeneficiaryInformationPage beneficiaryInformationPage = (BeneficiaryInformationPage) getLoginScenario()
				.getBean(PageConstants.BENEFICIARY_INFORMATION_PAGE);
		String planName = (String) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.PLAN_NAME);

		AdditionalInformationPage additionalInformation = beneficiaryInformationPage
				.navigatesToNextStep(planName);
		getLoginScenario().saveBean(PageConstants.ADDITIONAL_INFORMATION_PAGE,
				additionalInformation);
		if (additionalInformation != null) {
			/* Get actual data */
			JSONObject additionalInformationActual = additionalInformation.additionalInformationJson;
			System.out
			.println("additionalInformationActual---->" + additionalInformationActual);
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);
			String zipCountyInfo = zipcode +" ("+county+")";

			if(additionalInformation.validateAdditionalInformationPage(additionalInformationActual,planName,zipCountyInfo)){
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error in validating additional information page check ");
			}	
		} else {
			Assert.fail("ERROR loading AdditionalInformationPage");
		}

	}

	/**
	 * @toDo:user select the answer for special election period in Additional Information
	 */
	@And("^the user select the answer for special election period in Additional Information$")
	public void user_selects_special_election_period_in_additional_information_page() {
		String answer = memberAttributesRow.get(0).getCells().get(0);
		AdditionalInformationPage additionalInformationPage = (AdditionalInformationPage) getLoginScenario()
				.getBean(PageConstants.ADDITIONAL_INFORMATION_PAGE);
		additionalInformationPage.answerSpecialElectionQuestion(answer);
	}
	
	/**
	 * @toDo:user select the answer for prescription drug coverage in Additional Information
	 */
	@And("^the user select the answer for prescription drug coverage in Additional Information$")
	public void the_user_select_the_answer_for_prescription_drug_coverage_in_Additional_Information() {
		String answer = memberAttributesRow.get(0).getCells().get(0);
		AdditionalInformationPage additionalInformationPage = (AdditionalInformationPage) getLoginScenario()
				.getBean(PageConstants.ADDITIONAL_INFORMATION_PAGE);
		additionalInformationPage.answerPrescriptionDrugCoverageQuestion(answer);
	}
	
	/**
	 * @toDo:user select the answer for long-term care facility question in Additional Information
	 */
	@And("^the user select the answer for long-term care facility question in Additional Information$")
	public void the_user_select_the_answer_for_long_term_care_facility_question_in_Additional_Information() {
		String answer =memberAttributesRow.get(0).getCells().get(0);
		AdditionalInformationPage additionalInformationPage = (AdditionalInformationPage) getLoginScenario()
				.getBean(PageConstants.ADDITIONAL_INFORMATION_PAGE);
		additionalInformationPage.answerLongTermCareQuestion(answer);
	}
	
	/**
	 * @toDo:user select the answer for medicaid program question in Additional Information
	 */
	@And("^the user select the answer for medicaid program question in Additional Information$")
	public void the_user_select_the_answer_for_medicaid_program_question_in_Additional_Information() {
		String answer = memberAttributesRow.get(0).getCells().get(0);
		AdditionalInformationPage additionalInformationPage = (AdditionalInformationPage) getLoginScenario()
				.getBean(PageConstants.ADDITIONAL_INFORMATION_PAGE);
		additionalInformationPage.answerMedicaidProgramQuestion(answer);
	}
	
	/**
	 * @toDo:user select the answer for other health insurance question in Additional Information
	 */
	@And("^the user select the answer for other health insurance question in Additional Information$")
	public void the_user_select_the_answer_for_other_health_insurance_question_in_Additional_Information() {
		String answer = memberAttributesRow.get(0).getCells().get(0);
		AdditionalInformationPage additionalInformationPage = (AdditionalInformationPage) getLoginScenario()
				.getBean(PageConstants.ADDITIONAL_INFORMATION_PAGE);
		additionalInformationPage.answerOtherHealthInsuranceQuestion(answer);
	}
	
	/**
	 * @toDo:user select the answer for this question in supplemental benefits
	 */
	@And("^the user select the answer for this question \"([^\"]*)\" in supplemental benefits$")
	public void the_user_select_the_answer_for_this_question_in_supplemental_benefits(String question) {
		String answer = memberAttributesRow.get(0).getCells().get(0);
		AdditionalInformationPage additionalInformationPage = (AdditionalInformationPage) getLoginScenario()
				.getBean(PageConstants.ADDITIONAL_INFORMATION_PAGE);
		additionalInformationPage.answerDentalSupplementQuestion(answer);
	}
	
	/**
	 * @toDo:user checks for Primary Care Provider by clicking on look up your provider link
	 */
	@And("^the user checks for Primary Care Provider by clicking on look up your provider link$")
	public void user_checks_primary_care_provider_by_clicking_on_look_up_your_provider_link(){
		AdditionalInformationPage additionalInformationPage = (AdditionalInformationPage) getLoginScenario()
				.getBean(PageConstants.ADDITIONAL_INFORMATION_PAGE);
		String planName = (String) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.PLAN_NAME);
		
		if(additionalInformationPage.validateProviderSearch(planName)){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating provider search page");
		}
	}

	
	/**
	 * @toDo:user select option for plan payment options
	 */
	@And("the user select option for plan payment options$")
	public void user_select_payment_options() {
		String answer = memberAttributesRow.get(0).getCells().get(0);
		AdditionalInformationPage additionalInformationPage = (AdditionalInformationPage) getLoginScenario()
				.getBean(PageConstants.ADDITIONAL_INFORMATION_PAGE);
		additionalInformationPage.answerPaymentOptionsQuestion(answer);
	}

	/**
	 * @toDo:user fill broker id
	 */
	@And("^the user fill broker id$")
	public void user_fill_agent_or_broker_id() {
		String brokerId = memberAttributesRow.get(0).getCells().get(0);
		AdditionalInformationPage additionalInformationPage = (AdditionalInformationPage) getLoginScenario()
				.getBean(PageConstants.ADDITIONAL_INFORMATION_PAGE);
		additionalInformationPage.provideBrokerid(brokerId);
	}

	/**
	 * @toDo:user reviews the personal and plan data by navigating to Review application 
	 */
	@And("^the user reviews the personal and plan data by navigating to Review application step in UHC site$")
	public void user_reviews_personal_plan_data_on_review_application_page_aarp() {
		AdditionalInformationPage additionalInformationPage = (AdditionalInformationPage) getLoginScenario()
				.getBean(PageConstants.ADDITIONAL_INFORMATION_PAGE);
		String planName = (String) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.PLAN_NAME);
		
		ReviewApplicationPage reviewApplication = additionalInformationPage
				.navigatesToNextStep(planName);
		getLoginScenario().saveBean(PageConstants.REVIEW_APPLICATION_PAGE,
				reviewApplication);
		if (reviewApplication != null) {
			/* Get actual data */
			JSONObject reviewApplicationActual = reviewApplication.reviewApplicationJson;
			System.out
			.println("reviewApplicationActual---->" + reviewApplicationActual);

			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);
			String zipCountyInfo = zipcode +" ("+county+")";
			String name = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_NAME);
			String gender = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_GENDER);
			String address = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_ADDRESS);
			String addressPreference = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_ADDRESSPREFERENCE);
			String dob = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_DOB);
			String city = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_CITY);
			String apartment = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_APARTMENT);
			String emailAddress = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_EMAILADDRESS);
			String languagePreference = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_LANGUAGEPREFERENCE);
			String mcareNumber = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_MCARENUMBER);
			String phNumber = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_PHNUMBER);
			String otherPhNumber = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.ENROLLER_OTHERPHNUMBER);


			if(	reviewApplication.validateReviewApplicationPage(reviewApplicationActual, planName, zipCountyInfo,
					name, dob, gender, city, address, apartment, addressPreference, emailAddress, 
					phNumber, otherPhNumber, mcareNumber, languagePreference)){
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error in validating review application page check ");
			}
		}
	}

	/**
	 * @toDo:user navigates to submit application step
	 */
	@And("^the user navigates to submit application step in UHC site$")
	public void user_navigates_submit_application_aarp() {
		ReviewApplicationPage reviewApplication = (ReviewApplicationPage) getLoginScenario()
				.getBean(PageConstants.REVIEW_APPLICATION_PAGE);
		SubmitApplicationPage submitApplicationPage = reviewApplication
				.navigatesToNextStep();
		getLoginScenario().saveBean(PageConstants.SUBMIT_APPLICATION_PAGE,
				submitApplicationPage);
		if (submitApplicationPage != null) {
			/* Get actual data */
			JSONObject submitApplicationActual = submitApplicationPage.submitApplicationJson;

			/* Get expected data */
			String planName = (String) getLoginScenario().getBean(
					EnrollInPlanCommonConstants.PLAN_NAME);
			System.out
			.println("submitApplicationActual---->" + submitApplicationActual);
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);
			String zipCountyInfo = zipcode +" ("+county+")";

			if(submitApplicationPage.validateSubmitApplicationPage(submitApplicationActual, planName, zipCountyInfo)){
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error in validating submit application page check ");
			}

		}
	}

	/**
	 * @toDo:user selects I am the applicant listed on this enrollment application
	 */
	@And("^the user selects \"I am the applicant listed on this enrollment application\" for the question \"What is your relationship to the applicant listed on this enrollment application\" in UHC site$")
	public void user_selects_applicant_for_relationship_question() {
		SubmitApplicationPage submitApplicationPage = (SubmitApplicationPage) getLoginScenario()
				.getBean(PageConstants.SUBMIT_APPLICATION_PAGE);
		submitApplicationPage.selectsAsApplicant();
		getLoginScenario().saveBean(PageConstants.SUBMIT_APPLICATION_PAGE,
				submitApplicationPage);
	}

	/**
	 * @toDo:user submits application by selecting agree to the Statement of Understanding
	 */
	@And("^the user submits application by selecting agree to the Statement of Understanding in UHC site$")
	public void user_submits_application_aarp() {
		SubmitApplicationPage submitApplicationPage = (SubmitApplicationPage) getLoginScenario()
				.getBean(PageConstants.SUBMIT_APPLICATION_PAGE);
		EnrollmentConfirmationPage enrollmentConfirmationPage = submitApplicationPage
				.submitsApplication();
		getLoginScenario().saveBean(PageConstants.ENROLLMENT_CONFIRMATION_PAGE,
				enrollmentConfirmationPage);
		if (enrollmentConfirmationPage != null) {
			/* Get actual data */
			JSONObject enrollmentConfirmationActual = enrollmentConfirmationPage.enrollmentConfirmationJson;

			/* Get expected data */
			System.out
			.println("enrollmentConfirmationActual---->" + enrollmentConfirmationActual);
			getLoginScenario().saveBean(
					EnrollInPlanCommonConstants.ENROLLMENT_CONFIRMATION_ACTUAL,
					enrollmentConfirmationActual);

		}

	}

	/**
	 * @toDo:the user validates the enrollment application confirmation 
	 */
	@Then("^the user validates the enrollment application confirmation in UHC site$")
	public void user_validates_enrollment_application_confirmation_aarp() {

		EnrollmentConfirmationPage enrollmentConfirmationPage = (EnrollmentConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ENROLLMENT_CONFIRMATION_PAGE);

		JSONObject enrollmentConfirmationActual = (JSONObject) getLoginScenario()
				.getBean(EnrollInPlanCommonConstants.ENROLLMENT_CONFIRMATION_ACTUAL);
		String planName = (String) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.PLAN_NAME);
		
		String zipcode = (String) getLoginScenario().getBean(
				VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				VPPCommonConstants.COUNTY);
		String zipCountyInfo = zipcode +" ("+county+")";
		if(enrollmentConfirmationPage.validateEnrollmentConfirmationPage(enrollmentConfirmationActual, planName, zipCountyInfo)){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating submit application page check ");
		}

	}

	/**
	 * @toDo:isAlertPresent
	 */
	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

}