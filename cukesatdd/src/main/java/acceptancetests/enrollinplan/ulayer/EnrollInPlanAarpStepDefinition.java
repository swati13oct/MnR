package acceptancetests.enrollinplan.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AdditionalInformationPage;
import pages.acquisition.ulayer.BeneficiaryInformationPage;
import pages.acquisition.ulayer.ESRDPage;
import pages.acquisition.ulayer.EnrollmentConfirmationPage;
import pages.acquisition.ulayer.IntroductionInformationPage;
import pages.acquisition.ulayer.LongTermCarePage;
import pages.acquisition.ulayer.MedicaidPage;
import pages.acquisition.ulayer.OptionalRidersPage;
import pages.acquisition.ulayer.OtherHealthInsurancePage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.PlanInformationPage;
import pages.acquisition.ulayer.PlanPaymentOptions;
import pages.acquisition.ulayer.PrescriptionDrugCoveragePage;
import pages.acquisition.ulayer.PrimaryCareProviderPage;
import pages.acquisition.ulayer.ProposedEffectiveDatePage;
import pages.acquisition.ulayer.ReviewAndSubmitPage;
import pages.acquisition.ulayer.ReviewApplicationPage;
import pages.acquisition.ulayer.SpecialElectionPeriodPage;
import pages.acquisition.ulayer.SubmitApplicationPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.enrollinplan.data.EnrollInPlanCommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */

public class EnrollInPlanAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on AARP medicare site landing page$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

	@When("^user performs plan search using following information in AARP site$")
	public void zipcode_details_in_aarp_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
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
			/* Get expected data */
			String fileName = "vppPlanSummary";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);

			/* Get actual data */
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);

			try {
				JSONAssert.assertEquals(planSummaryExpectedJson,
						planSummaryActualJson, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@And("^the user views plans of the below plan type in AARP site$")
	public void user_performs_planSearch_in_aarp_site(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			/* Get actual data */
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);

			/* Get expected data */
			String fileName = null;
			if (plantype.equalsIgnoreCase("MA")
					|| plantype.equalsIgnoreCase("MAPD")) {
				fileName = "maplans";
			} else {
				fileName = plantype.toLowerCase() + "plans";
			}
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);

			try {
				JSONAssert.assertEquals(planSummaryExpectedJson,
						planSummaryActualJson, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@And("^the user enrolls for the below plan in AARP site$")
	public void user_enrolls_for_plan(DataTable planAttributes) {

		String planName = planAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(EnrollInPlanCommonConstants.PLAN_NAME,
				planName);

		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/*IntroductionInformationPage enrollPlanInfoPage = planSummaryPage
				.clicksOnEnrollInplanLink(planName);*/
		/*if (enrollPlanInfoPage != null) {

			 Get actual data 
			JSONObject enrollPlanInfoActual = enrollPlanInfoPage.enrollPlanInfoJson;
			System.out.println("enrollPlanInfoActual::"+enrollPlanInfoActual);

			 Get expected data 
			String fileName = planName;
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ EnrollInPlanCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
					+ File.separator
					+ EnrollInPlanCommonConstants.ENROLL_PLAN_INFO
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject enrollPlanInfoExpected = MRScenario.readExpectedJson(
					fileName, directory);

			try {
				JSONAssert.assertEquals(enrollPlanInfoExpected,
						enrollPlanInfoActual, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

			//IntroductionInformationPage introInformationPage = enrollPlanInfoPage.continuesEnrollment(planName);
		IntroductionInformationPage introInfoPage = planSummaryPage
				.clicksOnEnrollInplanLink(planName);
			getLoginScenario().saveBean(PageConstants.INTRODUCTION_INFORMATION_PAGE,introInfoPage);
		//}

	}

	@And("^the user navigates to introduction information step in AARP site$")
	public void the_user_navigates_into_information_step_aarp() {
		IntroductionInformationPage introInformationPage = (IntroductionInformationPage) getLoginScenario()
				.getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);

		if (introInformationPage != null) {
			/* Get actual data */
			JSONObject introInformationActual = introInformationPage.introductionInformationJson;

			/* Get expected data */
			String planName = (String) getLoginScenario().getBean(
					EnrollInPlanCommonConstants.PLAN_NAME);
			
			System.out.println("introInformationActual :::::::::"+introInformationActual);

			String fileName = planName;
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);

			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
					+ File.separator
					+ EnrollInPlanCommonConstants.INTRODUCTION_INFORMATION
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject introInformationExpected = MRScenario.readExpectedJson(fileName, directory);

			introInformationExpected = mergeWithCommonExpectedData(fileName, introInformationExpected);

			System.out.println("introInformationExpected:::"
					+ introInformationExpected);
			System.out.println("introInformationActual:::"
					+ introInformationActual);

			try {
				JSONAssert.assertEquals(introInformationExpected,
						introInformationActual, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Assert.fail("ERROR loading IntroInformationPage");
		}

	}


	@And("^the user fill following information in introduction information step in AARP site$")
	public void user_fill_information_introduction_information_aarp(
			DataTable personalAttributes) {

		List<DataTableRow> personalAttributesRow = personalAttributes
				.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells().get(0), personalAttributesRow.get(i).getCells().get(1));
		}
		IntroductionInformationPage introInformationPage = (IntroductionInformationPage) getLoginScenario()
				.getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);
		introInformationPage.entersmedicareinsuranceInformation(personalAttributesMap);
		//introInformationPage.navigatesToNextStep();
		getLoginScenario().saveBean(PageConstants.INTRODUCTION_INFORMATION_PAGE,introInformationPage);

	}

	@And("^the user navigates to beneficiary information step in AARP site$")
	public void the_user_navigates_beneficiary_information_step_aarp() {
		IntroductionInformationPage introInformationPage = (IntroductionInformationPage) getLoginScenario()
				.getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);

		BeneficiaryInformationPage beneficiaryInformationPage = introInformationPage.navigatesToNextStep();
		getLoginScenario().saveBean(PageConstants.BENEFICIARY_INFORMATION_PAGE,beneficiaryInformationPage);

		if (beneficiaryInformationPage != null) {
			/* Get actual data */
			JSONObject beneficiaryInformationActual = beneficiaryInformationPage.beneficiaryInformationJson;

			/* Get expected data */
			String planName = (String) getLoginScenario().getBean(
					EnrollInPlanCommonConstants.PLAN_NAME);

			String fileName = planName;
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);

			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
					+ File.separator
					+ EnrollInPlanCommonConstants.BENEFICIARY_INFORMATION
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject beneInformationExpected = MRScenario.readExpectedJson(fileName, directory);

			//	beneInformationExpected = mergeWithCommonExpectedData(fileName, beneInformationExpected);

			System.out.println("introInformationExpected:::"
					+ beneInformationExpected);
			System.out.println("introInformationActual:::"
					+ beneficiaryInformationActual);

			try {
				JSONAssert.assertEquals(beneInformationExpected,
						beneficiaryInformationActual, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Assert.fail("ERROR loading BeneficiaryInformationPage");
		}

	}


	@And("^the user fill following information in beneficiary information step in AARP site$")
	public void user_fill_information_beneficiary_information_aarp(
			DataTable personalAttributes) {

		List<DataTableRow> personalAttributesRow = personalAttributes
				.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells()
					.get(0), personalAttributesRow.get(i).getCells().get(1));
		}
		BeneficiaryInformationPage beneficiaryInformationPage = (BeneficiaryInformationPage) getLoginScenario()
				.getBean(PageConstants.BENEFICIARY_INFORMATION_PAGE);
		beneficiaryInformationPage.entersPersonalInformation(personalAttributesMap);

		getLoginScenario().saveBean(PageConstants.BENEFICIARY_INFORMATION_PAGE,	beneficiaryInformationPage);

	}
	
	@And("^the user navigates to sep step in AARP site$")
	public void user_navigates_to_sep_step(){
		BeneficiaryInformationPage beneficiaryInformationPage = (BeneficiaryInformationPage) getLoginScenario()
				.getBean(PageConstants.BENEFICIARY_INFORMATION_PAGE);
		
		SpecialElectionPeriodPage specialElectionPeriodPage = beneficiaryInformationPage.navigatesToStep2Part2();		
		
		getLoginScenario().saveBean(PageConstants.SPECIAL_ELECTION_PERIOD_PAGE,	specialElectionPeriodPage);	
		
		if(specialElectionPeriodPage != null){
			/* Get actual data */
			JSONObject sepInformationActual = specialElectionPeriodPage.sepInformationJson;

			/* Get expected data */
			String planName = (String) getLoginScenario().getBean(
					EnrollInPlanCommonConstants.PLAN_NAME);

			String fileName = planName;
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);

			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
					+ File.separator
					+ EnrollInPlanCommonConstants.SEP_INFORMATION
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject sepInformationExpected = MRScenario.readExpectedJson(fileName, directory);

			//	beneInformationExpected = mergeWithCommonExpectedData(fileName, beneInformationExpected);

			System.out.println("sepInformationExpected:::"
					+ sepInformationExpected);
			System.out.println("sepInformationActual:::"
					+ sepInformationActual);

			try {
				JSONAssert.assertEquals(sepInformationExpected,
						sepInformationActual, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Assert.fail("ERROR loading SEPInformationPage");
		}
		
	}

	@And("^the user select no for Special Election Period$")
	public void user_selects_no_for_SEPQuestion(DataTable SEPAttributes){
		
		List<DataTableRow> personalAttributesRow = SEPAttributes
				.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells()
					.get(0), personalAttributesRow.get(i).getCells().get(1));
		}

		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario()
				.getBean(PageConstants.SPECIAL_ELECTION_PERIOD_PAGE);

		specialElectionPeriodPage.noForSEPQuestion();
		
		getLoginScenario().saveBean(PageConstants.SPECIAL_ELECTION_PERIOD_PAGE,	specialElectionPeriodPage);	
		
		String plantype = personalAttributesMap.get("Plan Type");
		if(plantype.equalsIgnoreCase("MA")||plantype.equalsIgnoreCase("MAPD")){
			ESRDPage esrdpage= specialElectionPeriodPage.navigatesToNextStepMAorMAPD();
			getLoginScenario().saveBean(PageConstants.ESRD_PAGE,esrdpage);
			} else{
			PrescriptionDrugCoveragePage pdcPage = specialElectionPeriodPage.navigatesToNextStepPDP();
			getLoginScenario().saveBean(PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE,pdcPage);			
			
		}		
	}

	@And("^the user select yes for Special Election Period$")
	public void user_selects_yes_for_SEPQuestion(DataTable SEPAttributes){		
		
		List<DataTableRow> SEPAttributesRow = SEPAttributes
				.getGherkinRows();
		Map<String, String> SEPAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < SEPAttributesRow.size(); i++) {

			SEPAttributesMap.put(SEPAttributesRow.get(i).getCells()
					.get(0), SEPAttributesRow.get(i).getCells().get(1));
		}
		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario()
				.getBean(PageConstants.SPECIAL_ELECTION_PERIOD_PAGE);

		specialElectionPeriodPage.yesForSEPQuestion(SEPAttributesMap);
		
        getLoginScenario().saveBean(PageConstants.SPECIAL_ELECTION_PERIOD_PAGE,	specialElectionPeriodPage);	
		
		String plantype = SEPAttributesMap.get("Plan Type");
		if(plantype.equalsIgnoreCase("MA")||plantype.equalsIgnoreCase("MAPD")){
			ESRDPage esrdpage= specialElectionPeriodPage.navigatesToNextStepMAorMAPD();
			getLoginScenario().saveBean(PageConstants.ESRD_PAGE,esrdpage);
			} else{
			PrescriptionDrugCoveragePage pdcPage = specialElectionPeriodPage.navigatesToNextStepPDP();
			getLoginScenario().saveBean(PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE,pdcPage);			
			
		}

		

		
	}
	
	@And("^the user navigates to esrd step in AARP site$")	
	public void the_user_navigates_esrd_information_step_aarp() {
		ESRDPage esrdPage = (ESRDPage) getLoginScenario().getBean(PageConstants.ESRD_PAGE);		

		if (esrdPage != null) {
			/* Get actobj=ual data */
			JSONObject esrdActual = esrdPage.esrdInformationJson;

			/* Get expected data */
			String planName = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.PLAN_NAME);

			String fileName = planName;
			String zipcode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);

			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
					+ File.separator
					+ EnrollInPlanCommonConstants.ESRD_INFORMATION
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject esrdExpected = MRScenario.readExpectedJson(fileName, directory);

				System.out.println("esrdInformationExpected:::"+ esrdExpected);
			System.out.println("esrdInformationActual:::"	+ esrdActual);

			try {
				JSONAssert.assertEquals(esrdExpected,	esrdActual, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Assert.fail("ERROR loading esrdInformationActual");
		}

	}

	@And("^the user fill following information in esrd information step in AARP site$")
    public void user_fill_information_esrd_information_aarp(DataTable personalAttributes) {

          List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
          Map<String, String> personalAttributesMap = new HashMap<String, String>();
          for (int i = 0; i < personalAttributesRow.size(); i++) {
                 personalAttributesMap.put(personalAttributesRow.get(i).getCells()
                              .get(0), personalAttributesRow.get(i).getCells().get(1));
          }
          ESRDPage esrdPage = (ESRDPage) getLoginScenario().getBean(PageConstants.ESRD_PAGE);
          esrdPage.entersESRDInformation(personalAttributesMap);

          getLoginScenario().saveBean(PageConstants.ESRD_PAGE,esrdPage);
          
          PrescriptionDrugCoveragePage pdcPage = esrdPage.navigatesToNextStep();
           getLoginScenario().saveBean(PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE,pdcPage);

    }      
    
    @And("^the user navigates to prescription drug coverage step in AARP site$")
    public void the_user_navigates_prescription_drug_coverage_information_step_aarp() {
          
          PrescriptionDrugCoveragePage pdcPage = (PrescriptionDrugCoveragePage) getLoginScenario().getBean(PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE);
          if (pdcPage != null) {
                 /* Get actual data */
                 JSONObject pdcActual = pdcPage.prescriptionDrugCoverageInformationJson;

                 /* Get expected data */
                 String planName = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.PLAN_NAME);

                 String fileName = planName;
                 String zipcode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
                 String county = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);

                 String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
                              + File.separator + CommonConstants.SITE_ULAYER
                              + File.separator
                              + VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
                              + File.separator
                              + EnrollInPlanCommonConstants.PDC_INFORMATION
                              + File.separator + zipcode + File.separator + county
                              + File.separator;
                 JSONObject pdcExpected = MRScenario.readExpectedJson(fileName, directory);

                        System.out.println("pdcExpected:::"+ pdcExpected);
                 System.out.println("pdcActual:::" + pdcActual);

                 try {
                        JSONAssert.assertEquals(pdcExpected,    pdcActual, true);
                 } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                 }
          } else {
                 Assert.fail("ERROR loading pdcActual");
          }

    }

    @And("^the user fill following information in prescription drug coverage step in AARP site$")
    public void user_fill_information_prescription_drug_coverage_aarp(DataTable personalAttributes) {

          List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
          Map<String, String> personalAttributesMap = new HashMap<String, String>();
          for (int i = 0; i < personalAttributesRow.size(); i++) {
                 personalAttributesMap.put(personalAttributesRow.get(i).getCells()
                              .get(0), personalAttributesRow.get(i).getCells().get(1));
          }
          PrescriptionDrugCoveragePage pdcPage = (PrescriptionDrugCoveragePage) getLoginScenario().getBean(PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE);
          pdcPage.enterspdcInformation(personalAttributesMap);

           getLoginScenario().saveBean(PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE,pdcPage);
          LongTermCarePage ltcPage = pdcPage.navigatesToNextStep();
           getLoginScenario().saveBean(PageConstants.LONG_TERM_CARE_PAGE,ltcPage);
    }
    
    @And("^the user navigates to long term care step in AARP site$")
    public void the_user_navigates_long_term_care_information_step_aarp() {
          LongTermCarePage ltcPage = (LongTermCarePage) getLoginScenario().getBean(PageConstants.LONG_TERM_CARE_PAGE);
          if (ltcPage != null) {
                 /* Get actual data */
                 JSONObject ltcActual = ltcPage.longtermcareInformationJson;

                 /* Get expected data */
                 String planName = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.PLAN_NAME);

                 String fileName = planName;
                 String zipcode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
                 String county = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);

                 String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
                              + File.separator + CommonConstants.SITE_ULAYER
                              + File.separator
                              + VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
                              + File.separator
                              + EnrollInPlanCommonConstants.LTC_INFORMATION
                              + File.separator + zipcode + File.separator + county
                              + File.separator;
                 JSONObject ltcExpected = MRScenario.readExpectedJson(fileName, directory);

                        System.out.println("ltcExpected:::"+ ltcExpected);
                 System.out.println("ltcActual:::" + ltcActual);

                 try {
                        JSONAssert.assertEquals(ltcExpected,    ltcActual, true);
                 } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                 }
          } else {
                 Assert.fail("ERROR loading ltcActual");
          }

    }

    @And("^the user fill following information in long term care step in AARP site$")
    public void user_fill_information_long_term_care_aarp(DataTable personalAttributes) {

          List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
          Map<String, String> personalAttributesMap = new HashMap<String, String>();
          for (int i = 0; i < personalAttributesRow.size(); i++) {
                 personalAttributesMap.put(personalAttributesRow.get(i).getCells()
                              .get(0), personalAttributesRow.get(i).getCells().get(1));
          }
          LongTermCarePage ltcPage = (LongTermCarePage) getLoginScenario().getBean(PageConstants.LONG_TERM_CARE_PAGE);
          ltcPage.enterslongtermInformation(personalAttributesMap);

           getLoginScenario().saveBean(PageConstants.LONG_TERM_CARE_PAGE,ltcPage);
          
          String plantype = personalAttributesMap.get("Plan Type");          
           if(plantype.equalsIgnoreCase("MA")||plantype.equalsIgnoreCase("MAPD")){
                 MedicaidPage medicaidPage = ltcPage.navigatesToNextStepMAorMAPD();
                 getLoginScenario().saveBean(PageConstants.MEDICAID_PAGE,medicaidPage);
          } else{
                 PlanPaymentOptions ppoPage = ltcPage.navigatesToNextStepPDP();
                 getLoginScenario().saveBean(PageConstants.PLAN_PAYMENT_OPTION_PAGE,ppoPage);
          }

    }

    @And("^the user navigates to medicaid step in AARP site$")
    public void the_user_navigates_to_medicaid_aarp_information_step_aarp() {
    
          MedicaidPage medicaidPage = (MedicaidPage) getLoginScenario().getBean(PageConstants.MEDICAID_PAGE);
          if (medicaidPage != null) {
                 /* Get actual data */
                 JSONObject medicaidActual = medicaidPage.medicaidInformationJson;

                 /* Get expected data */
                 String planName = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.PLAN_NAME);

                 String fileName = planName;
                 String zipcode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
                 String county = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);

                 String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
                              + File.separator + CommonConstants.SITE_ULAYER
                              + File.separator
                              + VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
                              + File.separator
                              + EnrollInPlanCommonConstants.MEDICAID_INFORMATION
                              + File.separator + zipcode + File.separator + county
                              + File.separator;
                 JSONObject medicaidExpected = MRScenario.readExpectedJson(fileName, directory);

                        System.out.println("medicaidExpected:::"+ medicaidExpected);
                 System.out.println("medicaidActual:::"  + medicaidActual);

                 try {
                        JSONAssert.assertEquals(medicaidExpected,       medicaidActual, true);
                 } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                 }
          } else {
                 Assert.fail("ERROR loading medicaidActual");
          }

    }

    @And("^the user fill following information in medicaid step in AARP site$")
    public void user_fill_information_medicaid_aarp_step_aarp(DataTable personalAttributes) {

          List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
          Map<String, String> personalAttributesMap = new HashMap<String, String>();
          for (int i = 0; i < personalAttributesRow.size(); i++) {
                 personalAttributesMap.put(personalAttributesRow.get(i).getCells()
                              .get(0), personalAttributesRow.get(i).getCells().get(1));
          }
          MedicaidPage medicaidPage = (MedicaidPage) getLoginScenario().getBean(PageConstants.MEDICAID_PAGE);
          medicaidPage.entersmedicaidInformation(personalAttributesMap);

           getLoginScenario().saveBean(PageConstants.MEDICAID_PAGE,medicaidPage);
          
          String plantype = personalAttributesMap.get("Plan Type");          
           if(plantype.equalsIgnoreCase("MA")||plantype.equalsIgnoreCase("MAPD")){
                 OtherHealthInsurancePage othPage = medicaidPage.navigatesToNextStepMAorMAPD();
                 getLoginScenario().saveBean(PageConstants.OTHER_HEALTH_INSURANCE_PAGE,othPage);
          } else{
                 PlanPaymentOptions ppoPage = medicaidPage.navigatesToNextStepPDP();
                 getLoginScenario().saveBean(PageConstants.PLAN_PAYMENT_OPTION_PAGE,ppoPage);
          }

    }
    
    
    @And("^the user navigates to other health insurance step in AARP site$")
    public void the_user_navigates_to_other_health_insurance_aarp_information_step_aarp() {
          OtherHealthInsurancePage othPage = (OtherHealthInsurancePage) getLoginScenario().getBean(PageConstants.OTHER_HEALTH_INSURANCE_PAGE);
    
          if (othPage != null) {
                 /* Get actual data */
                 JSONObject othActual = othPage.otherhealthinsuranceInformationJson;

                 /* Get expected data */
                 String planName = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.PLAN_NAME);

                 String fileName = planName;
                 String zipcode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
                 String county = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);

                 String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
                              + File.separator + CommonConstants.SITE_ULAYER
                              + File.separator
                              + VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
                              + File.separator
                              + EnrollInPlanCommonConstants.OTH_INFORMATION
                              + File.separator + zipcode + File.separator + county
                              + File.separator;
                 JSONObject othExpected = MRScenario.readExpectedJson(fileName, directory);

                        System.out.println("othExpected:::"+ othExpected);
                 System.out.println("othActual:::" + othActual);

                 try {
                        JSONAssert.assertEquals(othExpected,    othActual, true);
                 } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                 }
          } else {
                 Assert.fail("ERROR loading othActual");
          }

    }

    @And("^the user fill following information in other health insurance step in AARP site$")
    public void user_fill_information_other_health_insurance_aarp_step_aarp(DataTable personalAttributes) {

          List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
          Map<String, String> personalAttributesMap = new HashMap<String, String>();
          for (int i = 0; i < personalAttributesRow.size(); i++) {
                 personalAttributesMap.put(personalAttributesRow.get(i).getCells()
                              .get(0), personalAttributesRow.get(i).getCells().get(1));
          }
          OtherHealthInsurancePage othPage = (OtherHealthInsurancePage) getLoginScenario().getBean(PageConstants.OTHER_HEALTH_INSURANCE_PAGE);
          othPage.entersotherhealthinsurInformation(personalAttributesMap);

           getLoginScenario().saveBean(PageConstants.OTHER_HEALTH_INSURANCE_PAGE,othPage);
          
          PrimaryCareProviderPage pcpPage = othPage.navigatesToNextStep();
                 getLoginScenario().saveBean(PageConstants.PRIMARY_CARE_PROVIDER_PAGE,pcpPage);

    }


    @And("^the user navigates to primary care provider step in AARP site$")
    public void the_user_navigates_to_primary_care_provider_aarp_information_step_aarp() {
          PrimaryCareProviderPage pcpPage = (PrimaryCareProviderPage) getLoginScenario().getBean(PageConstants.PRIMARY_CARE_PROVIDER_PAGE);
          IntroductionInformationPage introPage = (IntroductionInformationPage) getLoginScenario().getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);

          String premium="";
          try {
                 premium = introPage.introductionInformationJson.get("premium").toString();
                 if(premium.equalsIgnoreCase("$0.00 a month")){
                        OptionalRidersPage optPage= (OptionalRidersPage) pcpPage.navigatesToNextStep(premium);
                               getLoginScenario().saveBean(PageConstants.OPTIONAL_RIDERS_PAGE,optPage);
                 }else{
                        PlanPaymentOptions ppoPage= (PlanPaymentOptions) pcpPage.navigatesToNextStep(premium);
                        getLoginScenario().saveBean(PageConstants.PLAN_PAYMENT_OPTION_PAGE,ppoPage);
                 }
          } catch (JSONException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
          }
          
    
    }


    
    @And("^the user navigates to plan payment options step in AARP site$")
    public void the_user_navigates_to_plan_payment_options_aarp_information_step_aarp() {
          IntroductionInformationPage introPage = (IntroductionInformationPage) getLoginScenario().getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);

          String premium="";
          try {
                 premium = introPage.introductionInformationJson.get("premium").toString();
                 if(!premium.equalsIgnoreCase("$0.00 a month")){
          PlanPaymentOptions ppoPage = (PlanPaymentOptions) getLoginScenario().getBean(PageConstants.PLAN_PAYMENT_OPTION_PAGE);

    
                                     if (ppoPage != null) {
                                            /* Get actual data */
                                            JSONObject ppoActual = ppoPage.planpaymentInformationJson;
                        
                                            /* Get expected data */
                                            String planName = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.PLAN_NAME);
                        
                                            String fileName = planName;
                                            String zipcode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
                                            String county = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
                        
                                            String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
                                                         + File.separator + CommonConstants.SITE_ULAYER
                                                         + File.separator
                                                         + VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
                                                         + File.separator
                                                         + EnrollInPlanCommonConstants.PPO_INFORMATION
                                                         + File.separator + zipcode + File.separator + county
                                                         + File.separator;
                                            JSONObject ppoExpected = MRScenario.readExpectedJson(fileName, directory);
                        
                                                   System.out.println("ppoExpected:::"+ ppoExpected);
                                            System.out.println("ppoActual:::" + ppoActual);
                        
                                            try {
                                                   JSONAssert.assertEquals(ppoExpected,    ppoActual, true);
                                            } catch (JSONException e) {
                                                  // TODO Auto-generated catch block
                                                  e.printStackTrace();
                                            }
                                     } else {
                                            Assert.fail("ERROR loading ppoActual");
                                     }
                 
                 }
                 }catch(JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                 }
    }

    @And("^the user fill following information in plan payment options step in AARP site$")
    public void user_fill_information_plan_payment_options_aarp_step_aarp(DataTable personalAttributes) {

    List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
    Map<String, String> personalAttributesMap = new HashMap<String, String>();
    for (int i = 0; i < personalAttributesRow.size(); i++) {
    personalAttributesMap.put(personalAttributesRow.get(i).getCells()
    .get(0), personalAttributesRow.get(i).getCells().get(1));
    }
    IntroductionInformationPage introPage = (IntroductionInformationPage) getLoginScenario().getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);
    PlanPaymentOptions ppoPage = (PlanPaymentOptions) getLoginScenario().getBean(PageConstants.PLAN_PAYMENT_OPTION_PAGE);

    String premium="";
    try {
    premium = introPage.introductionInformationJson.get("premium").toString();
    if(!premium.equalsIgnoreCase("$0.00 a month")){

    String plantype = personalAttributesMap.get("Plan Type");
    ppoPage.clickplanproviderInformation(personalAttributesMap);
    if(plantype.equalsIgnoreCase("MA")||plantype.equalsIgnoreCase("MAPD")){
    OptionalRidersPage optriders=ppoPage.navigatesToNextStepMAPDorMA();

    getLoginScenario().saveBean(PageConstants.OPTIONAL_RIDERS_PAGE,optriders);
    }else{
    ProposedEffectiveDatePage pedobj=ppoPage.navigatesToNextStepPDP();
    getLoginScenario().saveBean(PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE,pedobj);

    }
    }
    }catch(JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }

    }
    
    
    @And("^the user navigates to optional Riders step in AARP site$")
    public void the_user_navigates_to_optional_riders_aarp_information_step_aarp() {
          OptionalRidersPage optPage = (OptionalRidersPage) getLoginScenario().getBean(PageConstants.OPTIONAL_RIDERS_PAGE);


          if (optPage != null) {
                 /* Get actual data */
                 JSONObject optActual = optPage.optionalridersInformationJson;

                 /* Get expected data */
                 String planName = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.PLAN_NAME);

                 String fileName = planName;
                 String zipcode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
                 String county = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);

                 String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
                              + File.separator + CommonConstants.SITE_ULAYER
                              + File.separator
                              + VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
                              + File.separator
                              + EnrollInPlanCommonConstants.OPT_INFORMATION
                              + File.separator + zipcode + File.separator + county
                              + File.separator;
                 JSONObject optExpected = MRScenario.readExpectedJson(fileName, directory);

                        System.out.println("ppoExpected:::"+ optExpected);
                 System.out.println("optActual:::" + optActual);

                 try {
                        JSONAssert.assertEquals(optExpected,optActual, true);
                 } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                 }
          } else {
                 Assert.fail("ERROR loading optActual");
          }

    }

    @And("^the user fill following information in optional Riders step in AARP site$")
    public void user_fill_information_optional_riders_aarp_step_aarp(DataTable personalAttributes) {

          List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
          Map<String, String> personalAttributesMap = new HashMap<String, String>();
          for (int i = 0; i < personalAttributesRow.size(); i++) {
                 personalAttributesMap.put(personalAttributesRow.get(i).getCells()
                              .get(0), personalAttributesRow.get(i).getCells().get(1));
          }
          OptionalRidersPage optPage = (OptionalRidersPage) getLoginScenario().getBean(PageConstants.OPTIONAL_RIDERS_PAGE);
          optPage.entersOptionalRiderInformation(personalAttributesMap);

          ProposedEffectiveDatePage pedPage= optPage.navigatesToNextStep();
           getLoginScenario().saveBean(PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE,pedPage);

    }
    
    @And("^the user navigates to proposed effective date page$")
	public void user_navigates_to_proposed_effective_date_page(){
		
    	/*OptionalRidersPage optPage = (OptionalRidersPage) getLoginScenario().getBean(PageConstants.OPTIONAL_RIDERS_PAGE);
		
		ProposedEffectiveDatePage pedPage = optPage.navigatesToNextStep();*/
		
    	ProposedEffectiveDatePage pedPage = (ProposedEffectiveDatePage) getLoginScenario().getBean(PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE);
		
		if(pedPage != null){
			/* Get actual data */
			JSONObject pedActual = pedPage.pedJson;

			/* Get expected data */
			String planName = (String) getLoginScenario().getBean(
					EnrollInPlanCommonConstants.PLAN_NAME);

			String fileName = planName;
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);

			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
					+ File.separator
					+ EnrollInPlanCommonConstants.PED
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject pedExpected = MRScenario.readExpectedJson(fileName, directory);

			System.out.println("PEDExpected:::"
					+ pedExpected);
			System.out.println("PEDActual:::"
					+ pedActual);

			try {
				JSONAssert.assertEquals(pedExpected,
						pedActual, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Assert.fail("ERROR loading PED Page");
		}
		
		
		
	}

	@And("^the user selects proposed effective date$")
	public void user_selects_proposed_effective_date(DataTable pedAttributes){
		
		List<DataTableRow> pedAttributesRow = pedAttributes
				.getGherkinRows();
		Map<String, String> pedAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < pedAttributesRow.size(); i++) {

			pedAttributesMap.put(pedAttributesRow.get(i).getCells()
					.get(0), pedAttributesRow.get(i).getCells().get(1));
		}

		ProposedEffectiveDatePage proposedEffectiveDatePage = (ProposedEffectiveDatePage) getLoginScenario()
				.getBean(PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE);
		
		proposedEffectiveDatePage.selectTheDate(pedAttributesMap);
		 String plantype = pedAttributesMap.get("Plan Type");
		proposedEffectiveDatePage.clickOnSaveAndContinue(plantype);
		getLoginScenario().saveBean(PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE,	proposedEffectiveDatePage);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ReviewAndSubmitPage revSubmitPage = proposedEffectiveDatePage.clickOnSaveAndContinue(plantype);
		getLoginScenario().saveBean(PageConstants.REVIEW_APPLICATION_PAGE, revSubmitPage);
		
	}
    @And("^the user navigates to review and submit application step in AARP site$")
    public void user_navigates_review_and_submit_application_aarp() {
          ReviewAndSubmitPage revSubmitPage = (ReviewAndSubmitPage) getLoginScenario()
                        .getBean(PageConstants.REVIEW_APPLICATION_PAGE);
          
          if(revSubmitPage != null){
                 /* Get actual data */
                 JSONObject reviewSubmitActual = revSubmitPage.reviewApplicationJson;

                 /* Get expected data */
                 String planName = (String) getLoginScenario().getBean(EnrollInPlanCommonConstants.PLAN_NAME);

                 String fileName = planName;
                 String zipcode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
                 String county = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);

                 String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
                              + File.separator + CommonConstants.SITE_ULAYER
                              + File.separator
                              + VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
                              + File.separator
                              + EnrollInPlanCommonConstants.REVIEW_APPLICATION
                              + File.separator + zipcode + File.separator + county
                              + File.separator;
                 JSONObject reviewSubmitExpected = MRScenario.readExpectedJson(fileName, directory);

                 System.out.println("reviewSubmitExpected:::"+ reviewSubmitExpected);
                 System.out.println("reviewSubmitActual:::"+ reviewSubmitActual);

                 try {
                        JSONAssert.assertEquals(reviewSubmitExpected,reviewSubmitActual, true);
                 } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                 }
          } else {
                 Assert.fail("ERROR loading PED Page");
          }
    
    }
    
    @And("^the user reviews the information on review and submit application step in AARP site$")
    public void user_reviews_the_information_review_and_submit_applcation_aarp(DataTable personalAttributes) {
    IntroductionInformationPage introPage = (IntroductionInformationPage) getLoginScenario().getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);
     ReviewAndSubmitPage reviewandSubmitPage = (ReviewAndSubmitPage) getLoginScenario().getBean(PageConstants.REVIEW_APPLICATION_PAGE);

     List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
     Map<String, String> personalAttributesMap = new HashMap<String, String>();
     for (int i = 0; i < personalAttributesRow.size(); i++) {
            personalAttributesMap.put(personalAttributesRow.get(i).getCells()
                         .get(0), personalAttributesRow.get(i).getCells().get(1));
     }
     
     try {
          String premium = introPage.introductionInformationJson.get("premium").toString();
          String plantype = personalAttributesMap.get("Plan Type");
            reviewandSubmitPage.editReviewAndSubmitIntroduction(reviewandSubmitPage,premium,plantype);
            reviewandSubmitPage.selectauthRepresentative(personalAttributesMap);
          reviewandSubmitPage.stmtofunderstanding(personalAttributesMap);
     reviewandSubmitPage.navigatesToNextStep();
     getLoginScenario().saveBean(PageConstants.REVIEW_APPLICATION_PAGE,reviewandSubmitPage);
     }catch(JSONException e){
          
     }
     
    }



	@And("^the user navigates to Additional Information step in AARP site$")
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

			/* Get expected data */
			String fileName = planName;
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);

			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
					+ File.separator
					+ EnrollInPlanCommonConstants.ADDITIONAL_INFORMATION
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject additionalInformationExpected = MRScenario
					.readExpectedJson(fileName, directory);

			additionalInformationExpected = mergeWithCommonExpectedData(
					fileName, additionalInformationExpected);

			System.out.println("additionalInformationExpected:::"
					+ additionalInformationExpected);
			System.out.println("additionalInformationActual:::"
					+ additionalInformationActual);

			try {
				JSONAssert.assertEquals(additionalInformationExpected,
						additionalInformationActual, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Assert.fail("ERROR loading AdditionalInformationPage");
		}

	}

	@And("^the user reviews the personal and plan data by naviagting to Review application step in AARP site$")
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

			/* Get expected data */
			String fileName = planName;
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);

			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
					+ File.separator
					+ EnrollInPlanCommonConstants.REVIEW_APPLICATION
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject reviewApplicationExpected = MRScenario.readExpectedJson(
					fileName, directory);

			System.out.println("additionalInformationExpected:::"
					+ reviewApplicationExpected);
			System.out.println("additionalInformationActual:::"
					+ reviewApplicationActual);

			try {
				JSONAssert.assertEquals(reviewApplicationExpected,
						reviewApplicationActual, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@And("^the user navigates to submit application step in AARP site$")
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

			String fileName = planName;
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);

			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
					+ File.separator
					+ EnrollInPlanCommonConstants.SUBMIT_APPLICATION
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject submitApplicationExpected = MRScenario.readExpectedJson(
					fileName, directory);

			System.out.println("submitApplicationExpected:::"
					+ submitApplicationExpected);
			System.out.println("submitApplicationActual:::"
					+ submitApplicationActual);

			try {
				JSONAssert.assertEquals(submitApplicationExpected,
						submitApplicationActual, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@And("^the user selects \"I am the applicant listed on this enrollment application\" for the question \"What is your relationship to the applicant listed on this enrollment application\" in AARP site$")
	public void user_selects_applicant_for_relationship_question() {
		SubmitApplicationPage submitApplicationPage = (SubmitApplicationPage) getLoginScenario()
				.getBean(PageConstants.SUBMIT_APPLICATION_PAGE);
		submitApplicationPage.selectsAsApplicant();
		getLoginScenario().saveBean(PageConstants.SUBMIT_APPLICATION_PAGE,
				submitApplicationPage);
	}

	@And("^the user submits application by selecting agree to the Statement of Understanding in AARP site$")
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
			String planName = (String) getLoginScenario().getBean(
					EnrollInPlanCommonConstants.PLAN_NAME);

			String fileName = planName;
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);

			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
					+ File.separator
					+ EnrollInPlanCommonConstants.ENROLLMENT_CONFIRMATION
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject enrollmentConfirmationExpected = MRScenario
					.readExpectedJson(fileName, directory);

			getLoginScenario().saveBean(
					EnrollInPlanCommonConstants.ENROLLMENT_CONFIRMATION_ACTUAL,
					enrollmentConfirmationActual);
			getLoginScenario()
			.saveBean(
					EnrollInPlanCommonConstants.ENROLLMENT_CONFIRMATION_EXPECTED,
					enrollmentConfirmationExpected);

		}

	}

	@Then("^the user validates the enrollment application confimation in AARP site$")
	public void user_validates_enrollment_application_confirmation_aarp() {

		JSONObject enrollmentConfirmationActual = (JSONObject) getLoginScenario()
				.getBean(
						EnrollInPlanCommonConstants.ENROLLMENT_CONFIRMATION_ACTUAL);
		JSONObject enrollmentConfirmationExpected = (JSONObject) getLoginScenario()
				.getBean(
						EnrollInPlanCommonConstants.ENROLLMENT_CONFIRMATION_EXPECTED);

		System.out.println("enrollmentConfirmationExpected:::"
				+ enrollmentConfirmationExpected);
		System.out.println("enrollmentConfirmationActual:::"
				+ enrollmentConfirmationActual);

		try {
			JSONAssert.assertEquals(enrollmentConfirmationExpected,
					enrollmentConfirmationActual, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JSONObject mergeWithCommonExpectedData(String fileName,
			JSONObject toJson) {

		String zipcode = (String) getLoginScenario().getBean(
				VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				VPPCommonConstants.COUNTY);
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER + File.separator
				+ EnrollInPlanCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
				+ File.separator + EnrollInPlanCommonConstants.COMMON_DATA
				+ File.separator + zipcode + File.separator + county
				+ File.separator;
		JSONObject commonExpectedJson = MRScenario.readExpectedJson(fileName,
				directory);

		toJson = CommonUtility.mergeJson(toJson, commonExpectedJson);

		return toJson;

	}

	@And("^the user click on enroll link  for the below plan in AARP site$")
	public void user_clicks_on_enroll_link(DataTable planAttributes)
	{
		String planName = planAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(EnrollInPlanCommonConstants.PLAN_NAME,
				planName);

		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		PlanInformationPage planInfoPage = planSummaryPage.navigatetoEnrollInplanLink(planName);
		if (planInfoPage!=null)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail("Error in loading Step 1");
		}
	}

	@When("^the user view plan details of the above selected plan in AARP site$")
	public void user_views_plandetails_selected_plan_aarp() {
		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);
		String zipcode = (String) getLoginScenario().getBean(
				VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				VPPCommonConstants.COUNTY);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String)getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage
				.navigateToPlanDetails(planName, planType);
		if (vppPlanDetailsPage != null) {
			System.out.println("Hello");
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
					vppPlanDetailsPage);
			/* Get actual data */
			JSONObject planDetailsActualJson = vppPlanDetailsPage.vppPlanDetailsJson;
			System.out.println("planDetailsActualJson---->"
					+ planDetailsActualJson);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_DETAIL_ACTUAL,
					planDetailsActualJson);

			/* Get expected data */
			String fileName = planName;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.VPP_PLAN_DETAILS_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject planDetailsExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_DETAIL_EXPECTED,
					planDetailsExpectedJson);

		}
		else
		{
			Assert.fail("Issue in plan details page");
		}
	}

	@And("^the user click on enroll button on plan details for the below plan in AARP site$")
	public void user_click_enroll_plan_detals()
	{
		PlanDetailsPage vppPlanDetailsPage= (PlanDetailsPage)getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);

		PlanInformationPage planinfo= vppPlanDetailsPage.navigatetoenrollinplanlink(planName);
		if (planinfo!=null)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail("Error in loading Step 1 from vpp plan details");
		}

	}

	@And("^the user validates the plan summary for the below plan in AARP site$")
	public void user_validates_plan_summary(DataTable planAttributes) {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/* get actual data for a particular plan */
		JSONObject planSummaryActualJson = planSummaryPage
				.getPlanSummaryActualData(planName);

		/* Get expected data */
		String fileName = planName;
		String zipcode = (String) getLoginScenario().getBean(
				VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				VPPCommonConstants.COUNTY);
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER + File.separator
				+ VPPCommonConstants.VPP_PLAN_FLOW_NAME + File.separator
				+ zipcode + File.separator + county + File.separator;
		JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		System.out
		.println("planSummaryActualJson---->" + planSummaryActualJson);
		System.out.println("planSummaryExpectedJson---->"
				+ planSummaryExpectedJson);

		/*try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}*/

	}
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

}
