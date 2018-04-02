package acceptancetests.acquisitionvbf.enrollinplan;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.BeneficiaryInformationPage;
import pages.acquisition.ulayer.ConfirmationPage;
import pages.acquisition.ulayer.ESRDPage;
import pages.acquisition.ulayer.IntroductionInformationPage;
import pages.acquisition.ulayer.LongTermCarePage;
import pages.acquisition.ulayer.MedicaidPage;
import pages.acquisition.ulayer.OptionalRidersPage;
import pages.acquisition.ulayer.OtherHealthInsurancePage;
import pages.acquisition.ulayer.PlanPaymentOptions;
import pages.acquisition.ulayer.PrescriptionDrugCoveragePage;
import pages.acquisition.ulayer.PrimaryCareProviderPage;
import pages.acquisition.ulayer.ProposedEffectiveDatePage;
import pages.acquisition.ulayer.ReviewAndSubmitPage;
import pages.acquisition.ulayer.SpecialElectionPeriodPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.acquisitionvbf.common.CommonStepDefinition;
import acceptancetests.acquisitionvbf.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality:EnrollInPlan
 */
public class EnrollInPlanStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	private Map<String, String> memberAttributesMap =new CommonStepDefinition().getAttributesMap();
	
	private List<DataTableRow> memberAttributesRow = new CommonStepDefinition().getAttributesRow();

	/**
	 * @toDo:user performs plan search using following information
	 */
	@When("^user performs plan search using following information in AARP site OLE$")
	public void zipcode_details_in_aarp_site() {

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
			if (plansummaryPage.validateVPPPlanSummaryPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the Plan Summary Page");
		}
	}

	/**
	 * @toDo:user views plans of the below plan type 
	 */
	@And("^the user views plans of the below plan type in AARP site OLE$")
	public void user_performs_planSearch_in_aarp_site() {
		
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER); //
		String plantype = memberAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(wd);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, wd);
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);

		}
	}

	/**
	 * @toDo:user enrolls for the below plan
	 */
	@And("^the user enrolls for the below plan in AARP site OLE$")
	public void user_enrolls_for_plan() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		String planName = memberAttributesRow.get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(EnrollInPlanCommonConstants.PLAN_NAME,
				planName);

		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		IntroductionInformationPage enrollPlanInfoPage = new IntroductionInformationPage(
				wd);

		enrollPlanInfoPage = planSummaryPage.clicksOnEnrollInplanLink(planName);
		if (enrollPlanInfoPage != null) {

			getLoginScenario().saveBean(
					PageConstants.INTRODUCTION_INFORMATION_PAGE,
					enrollPlanInfoPage);

		}

	}

	/**
	 * @toDo:user navigates to introduction information step
	 */
	@And("^the user navigates to introduction information step in AARP site OLE$")
	public void the_user_navigates_into_information_step_aarp() {
		IntroductionInformationPage introInformationPage = (IntroductionInformationPage) getLoginScenario()
				.getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);

		if (introInformationPage != null) {

			if (introInformationPage.validateIntroPage()) {
				Assert.assertTrue(true);
			} else
				Assert.fail("Error in validating the Introduction Information Page");
		} else {
			Assert.fail("ERROR loading IntroInformationPage");
		}

	}

	/**
	 * @toDo:user fill following information in introduction information 
	 */
	@And("^the user fill following information in introduction information step in AARP site OLE$")
	public void user_fill_information_introduction_information_aarp() {


		IntroductionInformationPage introInformationPage = (IntroductionInformationPage) getLoginScenario()
				.getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);
		introInformationPage
				.entersmedicareinsuranceInformation(memberAttributesMap);
		getLoginScenario().saveBean(
				PageConstants.INTRODUCTION_INFORMATION_PAGE,
				introInformationPage);

	}

	/**
	 * @toDo:user navigates to beneficiary information step
	 */
	@And("^the user navigates to beneficiary information step in AARP site OLE$")
	public void the_user_navigates_beneficiary_information_step_aarp() {
		IntroductionInformationPage introInformationPage = (IntroductionInformationPage) getLoginScenario()
				.getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);
		
		BeneficiaryInformationPage beneficiaryInformationPage = introInformationPage
				.navigatesToNextStep();
		
		getLoginScenario().saveBean(
				PageConstants.BENEFICIARY_INFORMATION_PAGE,
				beneficiaryInformationPage);

		boolean hasEnrolled = introInformationPage.hasEnrolledInLast24hrs();
		getLoginScenario().saveBean(EnrollInPlanCommonConstants.HAS_ENROLLED,
				hasEnrolled);

		if (!hasEnrolled) {
			if (beneficiaryInformationPage != null) {

				if (beneficiaryInformationPage.validateBeneficiaryPage()) {
					Assert.assertTrue(true);
				} else
					Assert.fail("Error in validating the Beneficiary Page");

			} else {
				Assert.fail("ERROR loading BeneficiaryInformationPage");
			}

		}
		else{
			Assert.assertTrue("Already Enrolled",true);
		}

	}

	/**
	 * @toDo:user fill following information in beneficiary information 
	 */
	@And("^the user fill following information in beneficiary information step in AARP site OLE$")
	public void user_fill_information_beneficiary_information_aarp(
			) {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			
			BeneficiaryInformationPage beneficiaryInformationPage = (BeneficiaryInformationPage) getLoginScenario()
					.getBean(PageConstants.BENEFICIARY_INFORMATION_PAGE);
			beneficiaryInformationPage
					.entersPersonalInformation(memberAttributesMap);

			getLoginScenario().saveBean(
					PageConstants.BENEFICIARY_INFORMATION_PAGE,
					beneficiaryInformationPage);
		}

	}

	/**
	 * @toDo:user navigates to sep step 
	 */
	@And("^the user navigates to sep step in AARP site OLE$")
	public void user_navigates_to_sep_step() {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			BeneficiaryInformationPage beneficiaryInformationPage = (BeneficiaryInformationPage) getLoginScenario()
					.getBean(PageConstants.BENEFICIARY_INFORMATION_PAGE);

			SpecialElectionPeriodPage specialElectionPeriodPage = beneficiaryInformationPage
					.navigatesToStep2Part2();

			getLoginScenario().saveBean(
					PageConstants.SPECIAL_ELECTION_PERIOD_PAGE,
					specialElectionPeriodPage);

			if (specialElectionPeriodPage != null) {

				if (specialElectionPeriodPage.validateSEPPage())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating the Selection Election Page");
			} else {
				Assert.fail("ERROR loading SEPInformationPage");
			}
		}

	}
	
	/**
	 * @toDo:user select no for Special Election Period 
	 */
	@And("^the user select no for Special Election Period OLE$")
	public void user_selects_no_for_SEPQuestion() {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			

			SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario()
					.getBean(PageConstants.SPECIAL_ELECTION_PERIOD_PAGE);

			specialElectionPeriodPage.noForSEPQuestion();

			getLoginScenario().saveBean(
					PageConstants.SPECIAL_ELECTION_PERIOD_PAGE,
					specialElectionPeriodPage);

			String plantype = memberAttributesMap.get("Plan Type");
			if (plantype.equalsIgnoreCase("MA")
					|| plantype.equalsIgnoreCase("MAPD")) {
				ESRDPage esrdpage = specialElectionPeriodPage
						.navigatesToNextStepMAorMAPD();
				getLoginScenario().saveBean(PageConstants.ESRD_PAGE, esrdpage);
			} else {
				PrescriptionDrugCoveragePage pdcPage = specialElectionPeriodPage
						.navigatesToNextStepPDP();
				getLoginScenario().saveBean(
						PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE, pdcPage);

			}
		}
	}

	/**
	 * @toDo:user select yes for Special Election Period 
	 */
	@And("^the user select yes for Special Election Period OLE$")
	public void user_selects_yes_for_SEPQuestion() {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			
			SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario()
					.getBean(PageConstants.SPECIAL_ELECTION_PERIOD_PAGE);

			specialElectionPeriodPage.yesForSEPQuestion(memberAttributesMap);

			getLoginScenario().saveBean(
					PageConstants.SPECIAL_ELECTION_PERIOD_PAGE,
					specialElectionPeriodPage);

			String plantype = memberAttributesMap.get("Plan Type");
			if (plantype.equalsIgnoreCase("MA")
					|| plantype.equalsIgnoreCase("MAPD")) {
				ESRDPage esrdpage = specialElectionPeriodPage
						.navigatesToNextStepMAorMAPD();
				getLoginScenario().saveBean(PageConstants.ESRD_PAGE, esrdpage);
			} else {
				PrescriptionDrugCoveragePage pdcPage = specialElectionPeriodPage
						.navigatesToNextStepPDP();
				getLoginScenario().saveBean(
						PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE, pdcPage);

			}

		}
	}

	/**
	 * @toDo:user navigates to esrd step in AARP site OLE
	 */
	@And("^the user navigates to esrd step in AARP site OLE$")
	public void the_user_navigates_esrd_information_step_aarp() {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			ESRDPage esrdPage = (ESRDPage) getLoginScenario().getBean(
					PageConstants.ESRD_PAGE);

			if (esrdPage != null) {

				if (esrdPage.validateESRDPage())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating the ESRD Page");

			} else {
				Assert.fail("ERROR loading esrdInformationActual");
			}

		}
	}

	/**
	 * @toDo:user fill following information in esrd information step
	 */
	@And("^the user fill following information in esrd information step in AARP site OLE$")
	public void user_fill_information_esrd_information_aarp(
			) {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			
			ESRDPage esrdPage = (ESRDPage) getLoginScenario().getBean(
					PageConstants.ESRD_PAGE);
			esrdPage.entersESRDInformation(memberAttributesMap);

			getLoginScenario().saveBean(PageConstants.ESRD_PAGE, esrdPage);

			PrescriptionDrugCoveragePage pdcPage = esrdPage
					.navigatesToNextStep();
			getLoginScenario().saveBean(
					PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE, pdcPage);
		}

	}

	/**
	 * @toDo:user navigates to prescription drug coverage step
	 */
	@And("^the user navigates to prescription drug coverage step in AARP site OLE$")
	public void the_user_navigates_prescription_drug_coverage_information_step_aarp() {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			PrescriptionDrugCoveragePage pdcPage = (PrescriptionDrugCoveragePage) getLoginScenario()
					.getBean(PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE);
			if (pdcPage != null) {

				if (pdcPage.validatePDCPage())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating the ESRD Page");
			} else {
				Assert.fail("ERROR loading pdcActual");
			}
		}

	}

	/**
	 * @toDo: fill following information in prescription drug coverage
	 */
	@And("^the user fill following information in prescription drug coverage step in AARP site OLE$")
	public void user_fill_information_prescription_drug_coverage_aarp(
			) {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			
			PrescriptionDrugCoveragePage pdcPage = (PrescriptionDrugCoveragePage) getLoginScenario()
					.getBean(PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE);
			pdcPage.enterspdcInformation(memberAttributesMap);

			getLoginScenario().saveBean(
					PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE, pdcPage);
			LongTermCarePage ltcPage = pdcPage.navigatesToNextStep();
			getLoginScenario().saveBean(PageConstants.LONG_TERM_CARE_PAGE,
					ltcPage);
		}
	}

	/**
	 * @toDo:user navigates to long term care step 
	 */
	@And("^the user navigates to long term care step in AARP site OLE$")
	public void the_user_navigates_long_term_care_information_step_aarp() {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			LongTermCarePage ltcPage = (LongTermCarePage) getLoginScenario()
					.getBean(PageConstants.LONG_TERM_CARE_PAGE);
			if (ltcPage != null) {

				if (ltcPage.validateLTCPage())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating the Long Term Care Page");
			} else {
				Assert.fail("ERROR loading ltcActual");
			}
		}

	}

	/**
	 * @toDo:user fill following information in long term care step
	 */
	@And("^the user fill following information in long term care step in AARP site OLE$")
	public void user_fill_information_long_term_care_aarp(
			) {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			
			LongTermCarePage ltcPage = (LongTermCarePage) getLoginScenario()
					.getBean(PageConstants.LONG_TERM_CARE_PAGE);
			ltcPage.enterslongtermInformation(memberAttributesMap);

			getLoginScenario().saveBean(PageConstants.LONG_TERM_CARE_PAGE,
					ltcPage);

			String plantype = memberAttributesMap.get("Plan Type");
			if (plantype.equalsIgnoreCase("MA")
					|| plantype.equalsIgnoreCase("MAPD")) {
				MedicaidPage medicaidPage = ltcPage
						.navigatesToNextStepMAorMAPD();
				getLoginScenario().saveBean(PageConstants.MEDICAID_PAGE,
						medicaidPage);
			} else {
				PlanPaymentOptions ppoPage = ltcPage.navigatesToNextStepPDP();
				getLoginScenario().saveBean(
						PageConstants.PLAN_PAYMENT_OPTION_PAGE, ppoPage);
			}
		}
	}

	/**
	 * @toDo:user navigates to medicaid step
	 */
	@And("^the user navigates to medicaid step in AARP site OLE$")
	public void the_user_navigates_to_medicaid_aarp_information_step_aarp() {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			MedicaidPage medicaidPage = (MedicaidPage) getLoginScenario()
					.getBean(PageConstants.MEDICAID_PAGE);
			if (medicaidPage != null) {

				if (medicaidPage.validateMedicadePage())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating the Medicaid Page");

			} else {
				Assert.fail("ERROR loading medicaidActual");
			}
		}

	}

	/**
	 * @toDo:user fill following information in medicaid step 
	 */
	@And("^the user fill following information in medicaid step in AARP site OLE$")
	public void user_fill_information_medicaid_aarp_step_aarp(
			) {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			
			MedicaidPage medicaidPage = (MedicaidPage) getLoginScenario()
					.getBean(PageConstants.MEDICAID_PAGE);
			medicaidPage.entersmedicaidInformation(memberAttributesMap);

			getLoginScenario().saveBean(PageConstants.MEDICAID_PAGE,
					medicaidPage);

			String plantype = memberAttributesMap.get("Plan Type");
			if (plantype.equalsIgnoreCase("MA")
					|| plantype.equalsIgnoreCase("MAPD")) {
				OtherHealthInsurancePage othPage = medicaidPage
						.navigatesToNextStepMAorMAPD();
				getLoginScenario().saveBean(
						PageConstants.OTHER_HEALTH_INSURANCE_PAGE, othPage);
			} else {
				PlanPaymentOptions ppoPage = medicaidPage
						.navigatesToNextStepPDP();
				getLoginScenario().saveBean(
						PageConstants.PLAN_PAYMENT_OPTION_PAGE, ppoPage);
			}
		}

	}

	/**
	 * @toDo:user navigates to other health insurance step
	 */
	@And("^the user navigates to other health insurance step in AARP site OLE$")
	public void the_user_navigates_to_other_health_insurance_aarp_information_step_aarp() {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			OtherHealthInsurancePage othPage = (OtherHealthInsurancePage) getLoginScenario()
					.getBean(PageConstants.OTHER_HEALTH_INSURANCE_PAGE);

			if (othPage != null) {

				if (othPage.validateOTHPage())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating the Other Health Insurance Page");
			} else {
				Assert.fail("ERROR loading othActual");
			}
		}

	}

	/**
	 * @toDo:user fill following information in other health insurance 
	 */
	@And("^the user fill following information in other health insurance step in AARP site OLE$")
	public void user_fill_information_other_health_insurance_aarp_step_aarp(
			) {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
		
			OtherHealthInsurancePage othPage = (OtherHealthInsurancePage) getLoginScenario()
					.getBean(PageConstants.OTHER_HEALTH_INSURANCE_PAGE);
			othPage.entersotherhealthinsurInformation(memberAttributesMap);

			getLoginScenario().saveBean(
					PageConstants.OTHER_HEALTH_INSURANCE_PAGE, othPage);

			PrimaryCareProviderPage pcpPage = othPage.navigatesToNextStep();
			getLoginScenario().saveBean(
					PageConstants.PRIMARY_CARE_PROVIDER_PAGE, pcpPage);

		}
	}

	/**
	 * @toDo: user navigates to primary care provider step 
	 */
	@And("^the user navigates to primary care provider step in AARP site OLE$")
	public void the_user_navigates_to_primary_care_provider_aarp_information_step_aarp() {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			PrimaryCareProviderPage pcpPage = (PrimaryCareProviderPage) getLoginScenario()
					.getBean(PageConstants.PRIMARY_CARE_PROVIDER_PAGE);
			if (pcpPage != null) {
				if (pcpPage.validatePCPPage())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating the Primacy Care Provider Page");
			} else
				Assert.fail("Error in loading the Primacy Care Provider Page");

			PlanPaymentOptions ppoPage = pcpPage.clickdisclaimer();

			if (ppoPage != null) {
				getLoginScenario().saveBean(
						PageConstants.PLAN_PAYMENT_OPTION_PAGE, ppoPage);

				Assert.assertTrue(true);
			} else {
				Assert.fail("Payment Page not found");
			}
		}
	}

	/**
	 * @toDo:user navigates to plan payment options 
	 */
	@And("^the user navigates to plan payment options step in AARP site OLE$")
	public void the_user_navigates_to_plan_payment_options_aarp_information_step_aarp() {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			PlanPaymentOptions ppoPage = (PlanPaymentOptions) getLoginScenario()
					.getBean(PageConstants.PLAN_PAYMENT_OPTION_PAGE);
			if (ppoPage != null) {
				if (ppoPage.validatePPOPage())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating the Plan Payment Options Page");
			} else
				Assert.fail("Error in loading the Plan Payment Options Page");

			OptionalRidersPage optriders = ppoPage.clickdisclaimerbutton();

			if (optriders != null) {
				getLoginScenario().saveBean(PageConstants.OPTIONAL_RIDERS_PAGE,
						optriders);

				Assert.assertTrue(true);
			} else {
				Assert.fail("Rider Page not found");
			}
		}
	}

	/**
	 * @toDo:user fill following information in plan payment options
	 */
	@And("^the user fill following information in plan payment options step in AARP site OLE$")
	public void user_fill_information_plan_payment_options_aarp_step_aarp(
		) {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
		
			
			PlanPaymentOptions ppoPage = (PlanPaymentOptions) getLoginScenario()
					.getBean(PageConstants.PLAN_PAYMENT_OPTION_PAGE);

			String plantype = memberAttributesMap.get("Plan Type");
			ppoPage.clickplanproviderInformation(memberAttributesMap);

			if (plantype.equalsIgnoreCase("MA")
					|| plantype.equalsIgnoreCase("MAPD")) {
				OptionalRidersPage optriders = ppoPage
						.navigatesToNextStepMAPDorMA();
				getLoginScenario().saveBean(PageConstants.OPTIONAL_RIDERS_PAGE,
						optriders);
			} else {
				ProposedEffectiveDatePage pedobj = ppoPage
						.navigatesToNextStepPDP();
				getLoginScenario().saveBean(
						PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE, pedobj);

			}
		}
	}

	/**
	 * @toDo:user navigates to optional Riders step 
	 */
	@And("^the user navigates to optional Riders step in AARP site OLE$")
	public void the_user_navigates_to_optional_riders_aarp_information_step_aarp() {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			OptionalRidersPage optPage = (OptionalRidersPage) getLoginScenario()
					.getBean(PageConstants.OPTIONAL_RIDERS_PAGE);
			if (optPage != null) {

				if (optPage.validateOptionalRidersPage()) {
					Assert.assertTrue(true);
				} else
					Assert.fail("Error in validating the Riders Page");
			} else {
				Assert.fail("ERROR loading optActual");
			}
		}

	}

	/**
	 * @toDo:user fill following information in optional Riders 
	 */
	@And("^the user fill following information in optional Riders step in AARP site OLE$")
	public void user_fill_information_optional_riders_aarp_step_aarp(
			) {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
		
			OptionalRidersPage optPage = (OptionalRidersPage) getLoginScenario()
					.getBean(PageConstants.OPTIONAL_RIDERS_PAGE);
			optPage.entersOptionalRiderInformation(memberAttributesMap);

			ProposedEffectiveDatePage pedPage = optPage.navigatesToNextStep();
			getLoginScenario().saveBean(
					PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE, pedPage);
		}
	}

	/**
	 * @toDo:user navigates to proposed effective date page
	 */
	@And("^the user navigates to proposed effective date page OLE$")
	public void user_navigates_to_proposed_effective_date_page() {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			ProposedEffectiveDatePage pedPage = (ProposedEffectiveDatePage) getLoginScenario()
					.getBean(PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE);

			if (pedPage != null) {

				if (pedPage.validateEffectiveDatePage()) {
					Assert.assertTrue(true);
				} else
					Assert.fail("Error in validating the Riders Page");

			} else {
				Assert.fail("ERROR loading PED Page");
			}
		}

	}

	/**
	 * @toDo:user selects proposed effective date OLE
	 */
	@And("^the user selects proposed effective date OLE$")
	public void user_selects_proposed_effective_date() {

		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
		

			ProposedEffectiveDatePage proposedEffectiveDatePage = (ProposedEffectiveDatePage) getLoginScenario()
					.getBean(PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE);

			proposedEffectiveDatePage.selectTheDate();
			String plantype = memberAttributesMap.get("Plan Type");
			ReviewAndSubmitPage revSubmitPage = proposedEffectiveDatePage
					.clickOnSaveAndContinue(plantype);
			getLoginScenario().saveBean(
					PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE,
					proposedEffectiveDatePage);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			getLoginScenario().saveBean(PageConstants.REVIEW_APPLICATION_PAGE,
					revSubmitPage);
		}
	}

	/**
	 * @toDo:user navigates to review and submit application step 
	 */
	@And("^the user navigates to review and submit application step in AARP site OLE$")
	public void user_navigates_review_and_submit_application_aarp(
			) {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			ReviewAndSubmitPage revSubmitPage = (ReviewAndSubmitPage) getLoginScenario()
					.getBean(PageConstants.REVIEW_APPLICATION_PAGE);
			

			String plantype = memberAttributesMap.get("Plan Type");
			if (revSubmitPage != null) {

				if (revSubmitPage.validateReviewPage(plantype)) {
					Assert.assertTrue(true);
				} else
					Assert.fail("Error in validating the Review Application Page");
			} else {
				Assert.fail("ERROR loading Review Application Page");
			}
		}
	}

	/**
	 * @toDo:user reviews the information on review and submit application step 
	 */
	@And("^the user reviews the information on review and submit application step in AARP site OLE$")
	public void user_reviews_the_information_review_and_submit_applcation_aarp(
			) {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);

		if (!hasEnrolled) {
			
			ReviewAndSubmitPage reviewandSubmitPage = (ReviewAndSubmitPage) getLoginScenario()
					.getBean(PageConstants.REVIEW_APPLICATION_PAGE);

			reviewandSubmitPage.selectauthRepresentative(memberAttributesMap);
			reviewandSubmitPage.stmtofunderstanding(memberAttributesMap);
			ConfirmationPage confirmationPage = reviewandSubmitPage
					.navigatesToNextStep();
			Boolean errorMessage = reviewandSubmitPage.validateErrorMessage();
			getLoginScenario().saveBean(EnrollInPlanCommonConstants.HAS_ERROR_MESSAGE, errorMessage);
			getLoginScenario().saveBean(PageConstants.CONFIRMATION_PAGE,
					confirmationPage);
			getLoginScenario().saveBean(PageConstants.REVIEW_APPLICATION_PAGE,
					reviewandSubmitPage);

		}
	}

	/**
	 * @toDo:user navigates to Confirmation Page
	 */
	@Then("^the user navigates to Confirmation Page OLE$")
	public void user_navigates_to_Confirmation_Page() {
		boolean hasEnrolled = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ENROLLED);
		boolean hasErrorMessage = (Boolean) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.HAS_ERROR_MESSAGE);
		if (!hasEnrolled) {
			if(!hasErrorMessage) {
			ConfirmationPage confirmationPage = (ConfirmationPage) getLoginScenario()
					.getBean(PageConstants.CONFIRMATION_PAGE);

				if (confirmationPage != null) {

					if (confirmationPage.validateConfirmationPage())
						Assert.assertTrue(true);
					else
						Assert.fail("Error in validating the Confirmation Page");
				} else {
					Assert.fail("ERROR loading Confirmation Page");
				}
			}
		}
	}

}
