package acceptancetests.deprecated.enrollinplan.ulayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.deprecated.atdd.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.acquisition.PageConstants;
import acceptancetests.deprecated.atdd.util.CommonUtility;
import acceptancetests.deprecated.enrollinplan.data.EnrollInPlanCommonConstants;
import acceptancetests.deprecated.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
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

	@Before
	public void setup(){
		/*
		 * Format(MM-DD-YYYY) Pre-AEP Test
		 */
		//String date = "09-30-2016";
		//CommonUtility.changeMRRestTime(getLoginScenario(), date);
		//CommonUtility.changePartDTime(getLoginScenario(), date);
	}
	
	@Given("^the user is on AARP medicare site landing page OLE aarp$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		wd.get("https://www.awe-test-a-aarpmedicareplans.uhc.com");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

	@When("^user performs plan search using following information in AARP site OLE aarp$")
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
//			if(plansummaryPage.validateVPPPlanSummaryPage())
//				Assert.assertTrue(true);
//			else
//				Assert.fail("Error in validating the Plan Summary Page");
		}
	}

	@And("^the user views plans of the below plan type in AARP site OLE aarp$")
	public void user_performs_planSearch_in_aarp_site(DataTable givenAttributes) throws InterruptedException {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER); //
		String plantype = givenAttributesMap.get("Plan Type"); 
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPage plansummaryPage = new VPPPlanSummaryPage(wd);//VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,wd);
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);
		  // WebDriver wd = getLoginScenario().getWebDriver();
           List<WebElement> view2017Plans = wd.findElements(By.linkText("View 2017 Plans"));
   		if(view2017Plans.size()>0){
   			if(view2017Plans.get(0).isDisplayed()){
   				view2017Plans.get(0).click();
   				try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
   				
   			}
   		}

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			
		}
	}

	@And("^the user enrolls for the below plan in AARP site OLE aarp$")
	public void user_enrolls_for_plan(DataTable planAttributes) {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String planName = planAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(EnrollInPlanCommonConstants.PLAN_NAME,
				planName);

		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		IntroductionInformationPage enrollPlanInfoPage = new IntroductionInformationPage(wd);
		
		enrollPlanInfoPage = planSummaryPage.clicksOnEnrollInplanLink(planName);
		if (enrollPlanInfoPage != null) {

			getLoginScenario().saveBean(PageConstants.INTRODUCTION_INFORMATION_PAGE,enrollPlanInfoPage);

		}

	}

	@And("^the user navigates to introduction information step in AARP site OLE aarp$")
	public void the_user_navigates_into_information_step_aarp() {
		IntroductionInformationPage introInformationPage = (IntroductionInformationPage) getLoginScenario()
				.getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);

		if (introInformationPage != null) {
			
			if(introInformationPage.validateIntroPage()){
				Assert.assertTrue(true);
			}//else 
				//Assert.fail("Error in validating the Introduction Information Page");
		} else {
			Assert.fail("ERROR loading IntroInformationPage");
		}

	}


	@And("^the user fill following information in introduction information step in AARP site OLE aarp$")
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
		getLoginScenario().saveBean(PageConstants.INTRODUCTION_INFORMATION_PAGE,introInformationPage);

	}

	@And("^the user navigates to beneficiary information step in AARP site OLE aarp$")
	public void the_user_navigates_beneficiary_information_step_aarp() {
		IntroductionInformationPage introInformationPage = (IntroductionInformationPage) getLoginScenario()
				.getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);

		BeneficiaryInformationPage beneficiaryInformationPage = introInformationPage.navigatesToNextStep();
		getLoginScenario().saveBean(PageConstants.BENEFICIARY_INFORMATION_PAGE,beneficiaryInformationPage);

		if (beneficiaryInformationPage != null) {
			
			if(beneficiaryInformationPage.validateBeneficiaryPage()){
				Assert.assertTrue(true);
			}else
				Assert.fail("Error in validating the Beneficiary Page");
			
		} else {
			Assert.fail("ERROR loading BeneficiaryInformationPage");
		}

	}


	@And("^the user fill following information in beneficiary information step in AARP site OLE aarp$")
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
	
	@And("^the user navigates to sep step in AARP site OLE aarp$")
	public void user_navigates_to_sep_step(){
		BeneficiaryInformationPage beneficiaryInformationPage = (BeneficiaryInformationPage) getLoginScenario()
				.getBean(PageConstants.BENEFICIARY_INFORMATION_PAGE);
		
		SpecialElectionPeriodPage specialElectionPeriodPage = beneficiaryInformationPage.navigatesToStep2Part2();		
		
		getLoginScenario().saveBean(PageConstants.SPECIAL_ELECTION_PERIOD_PAGE,	specialElectionPeriodPage);	
		
		if(specialElectionPeriodPage != null){
			
			if(specialElectionPeriodPage.validateSEPPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the Selection Election Page");
		} else {
			Assert.fail("ERROR loading SEPInformationPage");
		}
		
	}

	@And("^the user select no for Special Election Period OLE aarp$")
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

	@And("^the user select yes for Special Election Period OLE aarp$")
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
	
	@And("^the user navigates to esrd step in AARP site OLE aarp$")	
	public void the_user_navigates_esrd_information_step_aarp() {
		ESRDPage esrdPage = (ESRDPage) getLoginScenario().getBean(PageConstants.ESRD_PAGE);		

		if (esrdPage != null) {
			
			if(esrdPage.validateESRDPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the ESRD Page");
			
		} else {
			Assert.fail("ERROR loading esrdInformationActual");
		}

	}

	@And("^the user fill following information in esrd information step in AARP site OLE aarp$")
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
    
    @And("^the user navigates to prescription drug coverage step in AARP site OLE aarp$")
    public void the_user_navigates_prescription_drug_coverage_information_step_aarp() {
          
          PrescriptionDrugCoveragePage pdcPage = (PrescriptionDrugCoveragePage) getLoginScenario().getBean(PageConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE);
          if (pdcPage != null) {
           
        	  	if(pdcPage.validatePDCPage())
        	  		Assert.assertTrue(true);
        	  	else
        	  		Assert.fail("Error in validating the ESRD Page");
          } else {
                 Assert.fail("ERROR loading pdcActual");
          }

    }

    @And("^the user fill following information in prescription drug coverage step in AARP site OLE aarp$")
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
    
    @And("^the user navigates to long term care step in AARP site OLE aarp$")
    public void the_user_navigates_long_term_care_information_step_aarp() {
          LongTermCarePage ltcPage = (LongTermCarePage) getLoginScenario().getBean(PageConstants.LONG_TERM_CARE_PAGE);
          if (ltcPage != null) {
                 
        	  	if(ltcPage.validateLTCPage())
        	  		Assert.assertTrue(true);
        	  	else
        	  		Assert.fail("Error in validating the Long Term Care Page");
          } else {
                 Assert.fail("ERROR loading ltcActual");
          }

    }

    @And("^the user fill following information in long term care step in AARP site OLE aarp$")
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

    @And("^the user navigates to medicaid step in AARP site OLE aarp$")
    public void the_user_navigates_to_medicaid_aarp_information_step_aarp() {
    
          MedicaidPage medicaidPage = (MedicaidPage) getLoginScenario().getBean(PageConstants.MEDICAID_PAGE);
          if (medicaidPage != null) {
                 
        	  if(medicaidPage.validateMedicadePage())
      	  		Assert.assertTrue(true);
      	  	  else
      	  		Assert.fail("Error in validating the Medicaid Page");
        	  
          } else {
                 Assert.fail("ERROR loading medicaidActual");
          }

    }

    @And("^the user fill following information in medicaid step in AARP site OLE aarp$")
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
    
    
    @And("^the user navigates to other health insurance step in AARP site OLE aarp$")
    public void the_user_navigates_to_other_health_insurance_aarp_information_step_aarp() {
          OtherHealthInsurancePage othPage = (OtherHealthInsurancePage) getLoginScenario().getBean(PageConstants.OTHER_HEALTH_INSURANCE_PAGE);
    
          if (othPage != null) {
                
        	  	if(othPage.validateOTHPage())
        	  		Assert.assertTrue(true);
        	  	 else
        	  		Assert.fail("Error in validating the Other Health Insurance Page");
          } else {
                 Assert.fail("ERROR loading othActual");
          }

    }

    @And("^the user fill following information in other health insurance step in AARP site OLE aarp$")
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


    @And("^the user navigates to primary care provider step in AARP site OLE aarp$")
    public void the_user_navigates_to_primary_care_provider_aarp_information_step_aarp() {
          PrimaryCareProviderPage pcpPage = (PrimaryCareProviderPage) getLoginScenario().getBean(PageConstants.PRIMARY_CARE_PROVIDER_PAGE);
       if(pcpPage!=null){
			if(pcpPage.validatePCPPage())
		  		Assert.assertTrue(true);
		  	 else
		  		Assert.fail("Error in validating the Primacy Care Provider Page");
		 }else
			 Assert.fail("Error in loading the Primacy Care Provider Page");
          
          PlanPaymentOptions ppoPage = pcpPage.clickdisclaimer();
          
          if(ppoPage!= null){
  			getLoginScenario().saveBean(PageConstants.PLAN_PAYMENT_OPTION_PAGE,
  					ppoPage);
  			
  			Assert.assertTrue(true);
  		} else {
  			Assert.fail("Payment Page not found");
  		}
    }


    
   @And("^the user navigates to plan payment options step in AARP site OLE aarp$")
   public void the_user_navigates_to_plan_payment_options_aarp_information_step_aarp() {
	   
	   PlanPaymentOptions ppoPage = (PlanPaymentOptions) getLoginScenario().getBean(PageConstants.PLAN_PAYMENT_OPTION_PAGE);
	   if(ppoPage!=null){
		   if(ppoPage.validatePPOPage())
		  		Assert.assertTrue(true);
		  	 else
		  		Assert.fail("Error in validating the Plan Payment Options Page");
	   }else
		   Assert.fail("Error in loading the Plan Payment Options Page");
	   
	   OptionalRidersPage optriders = ppoPage.clickdisclaimerbutton();
	   
	   if(optriders!= null){
 			getLoginScenario().saveBean(PageConstants.OPTIONAL_RIDERS_PAGE,
 					optriders);
 			
 			Assert.assertTrue(true);
 		} else {
 			Assert.fail("Rider Page not found");
 		}
	   
                 
   }

    @And("^the user fill following information in plan payment options step in AARP site OLE aarp$")
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
    
    
    @And("^the user navigates to optional Riders step in AARP site OLE aarp$")
    public void the_user_navigates_to_optional_riders_aarp_information_step_aarp() {
          OptionalRidersPage optPage = (OptionalRidersPage) getLoginScenario().getBean(PageConstants.OPTIONAL_RIDERS_PAGE);
          WebDriver driver = (WebDriver) getLoginScenario().getBean(
  				CommonConstants.WEBDRIVER);
          JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(316, 0)");
          try {
  			Thread.sleep(5000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
          
          
          if (optPage != null) {
   
        	  	if(optPage.validateOptionalRidersPage()){
        	  		Assert.assertTrue(true);
        	  	}else
        	  		Assert.fail("Error in validating the Riders Page");
          } else {
                 Assert.fail("ERROR loading optActual");
          }

    }

    @And("^the user fill following information in optional Riders step in AARP site OLE aarp$")
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
    
    @And("^the user navigates to proposed effective date page OLE aarp$")
	public void user_navigates_to_proposed_effective_date_page(){
		
		ProposedEffectiveDatePage pedPage = (ProposedEffectiveDatePage) getLoginScenario().getBean(PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE);
		
		if(pedPage != null){
			
			if(pedPage.validateEffectiveDatePage()){
    	  		Assert.assertTrue(true);
    	  	}else
    	  		Assert.fail("Error in validating the Riders Page");
			
		} else {
			Assert.fail("ERROR loading PED Page");
		}
		
		
		
	}

	@And("^the user selects proposed effective date OLE aarp$")
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
		
		proposedEffectiveDatePage.selectTheDate();
		 String plantype = pedAttributesMap.get("Plan Type");
		 ReviewAndSubmitPage revSubmitPage = proposedEffectiveDatePage.clickOnSaveAndContinue(plantype);
		getLoginScenario().saveBean(PageConstants.PROPOSED_EFFECTIVE_DATE_PAGE,	proposedEffectiveDatePage);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getLoginScenario().saveBean(PageConstants.REVIEW_APPLICATION_PAGE, revSubmitPage);
		
	}
    @And("^the user navigates to review and submit application step in AARP site OLE aarp$")
    public void user_navigates_review_and_submit_application_aarp(DataTable reviewAttributes) {
          ReviewAndSubmitPage revSubmitPage = (ReviewAndSubmitPage) getLoginScenario()
                        .getBean(PageConstants.REVIEW_APPLICATION_PAGE);
          List<DataTableRow> reviewAttributesRow = reviewAttributes.getGherkinRows();
          Map<String, String> reviewAttributesMap = new HashMap<String, String>();
          for (int i = 0; i < reviewAttributesRow.size(); i++) {
                 reviewAttributesMap.put(reviewAttributesRow.get(i).getCells()
                              .get(0), reviewAttributesRow.get(i).getCells().get(1));
          }
          
          String plantype = reviewAttributesMap.get("Plan Type");
          if(revSubmitPage != null){
              
        	  if(revSubmitPage.validateReviewPage(plantype)){
      	  		Assert.assertTrue(true);
      	  	  }else
      	  		Assert.fail("Error in validating the Review Application Page");
          } else {
                 Assert.fail("ERROR loading Review Application Page");
          }
    
    }
    
    @And("^the user reviews the information on review and submit application step in AARP site OLE aarp$")
    public void user_reviews_the_information_review_and_submit_applcation_aarp(DataTable personalAttributes) {
    IntroductionInformationPage introPage = (IntroductionInformationPage) getLoginScenario().getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);
     ReviewAndSubmitPage reviewandSubmitPage = (ReviewAndSubmitPage) getLoginScenario().getBean(PageConstants.REVIEW_APPLICATION_PAGE);

     List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
     Map<String, String> personalAttributesMap = new HashMap<String, String>();
     for (int i = 0; i < personalAttributesRow.size(); i++) {
            personalAttributesMap.put(personalAttributesRow.get(i).getCells()
                         .get(0), personalAttributesRow.get(i).getCells().get(1));
     }
     
          String plantype = personalAttributesMap.get("Plan Type");
          reviewandSubmitPage.selectauthRepresentative(personalAttributesMap);
          reviewandSubmitPage.stmtofunderstanding(personalAttributesMap);
          ConfirmationPage confirmationPage = reviewandSubmitPage.navigatesToNextStep();
          getLoginScenario().saveBean(PageConstants.CONFIRMATION_PAGE,confirmationPage);
          getLoginScenario().saveBean(PageConstants.REVIEW_APPLICATION_PAGE,reviewandSubmitPage);
   
     
    }
	
	@Then("^the user navigates to Confirmation Page OLE aarp$")
	public void user_navigates_to_Confirmation_Page(){

		ConfirmationPage confirmationPage = (ConfirmationPage) getLoginScenario().getBean(PageConstants.CONFIRMATION_PAGE);

		if(confirmationPage != null){
			
			if(confirmationPage.validateConfirmationPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the Confirmation Page");
		} else {
			Assert.fail("ERROR loading Confirmation Page");
		}		
	}
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		CommonUtility.resetMRRestTime(getLoginScenario());
		CommonUtility.resetPartDTime(getLoginScenario());
		getLoginScenario().flushBeans();
	}

	

}
