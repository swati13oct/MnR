package acceptancetests.acquisition.isinsuranceagent;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.PlanComparePage;
import pages.acquisition.isinsuranceagent.IsInsuranceAgentStep1;
import pages.acquisition.isinsuranceagent.IsInsuranceAgentStep2;
import pages.acquisition.ole.AuthorizationPage;
import pages.acquisition.ole.CancelOLEModal;
import pages.acquisition.ole.CoverageInformationPage;
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
import pages.acquisition.ole.UseAndDisclosureAuthorizationPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.ComparePlansPageBlayer;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import acceptancetests.vbfacquisition_deprecated.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * @author sdwaraka
 * Functionality:IS - Med Supp Decision Guide for both AARP and UHC acquisition sites
 */
public class isInsuranceAgentStepDefenitionUHC    {

	
		// TODO Auto-generated constructor stub
	

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	/**
	 * @author sdwaraka
	 * Steps for IS Decision Guide ATDDs
	 * @param planAttributes
	 * @throws Throwable
	 */ 
	
	//F266875 - IS Decision Guide Agency Feature : Adding new Step to Navigate to Step 1 page for IS Decision Guide.
	/*
		
	@Then("^the user enters valid information for the pre entry form on UMS site for Insurance Agent$")
	public void the_user_enters_valid_information_for_the_pre_entry_form_on_UMS_site_Insurance_Agent(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String dateOfBirth= memberAttributesMap.get("DOB");
		//String zipcode= memberAttributesMap.get("zipcode");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		//plansummaryPage.MedSupFormValidation(dateOfBirth,zipcode);
		plansummaryPage.MedSupFormValidation(dateOfBirth);
		
	}
	@Then("^the user enters and  saves the entered information in Pre entry page for validation on IS Insurance Agent forms on UMS site $")
	public void the_user_saves_the_entered_information_in_Pre_entry_page_for_validation_on_IS_Insurance_Agent_form_on_UMS_site(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String dateOfBirth= memberAttributesMap.get("DOB");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Map<String, String> PreEntryPageInfo = new HashMap<String, String>();
		PreEntryPageInfo = plansummaryPage.CapturePreEntryPageInfo(dateOfBirth);
		String DOBEntered = PreEntryPageInfo.get("DOB");
		String part_A_Month_Entered = PreEntryPageInfo.get("part_A_Month_Entered");
		String part_A_Year_Entered = PreEntryPageInfo.get("part_A_Year_Entered");
		String part_B_Month_Entered = PreEntryPageInfo.get("part_B_Month_Entered");
		String part_B_Year_Entered = PreEntryPageInfo.get("part_B_Year_Entered");
		String start_Date_Entered = PreEntryPageInfo.get("startDateEntered");

		getLoginScenario().saveBean(MedSuppCommonConstants.DOB, DOBEntered);
		getLoginScenario().saveBean(MedSuppCommonConstants.PARTA_MONTH, part_A_Month_Entered);
		getLoginScenario().saveBean(MedSuppCommonConstants.PARTA_YEAR, part_A_Year_Entered);
		getLoginScenario().saveBean(MedSuppCommonConstants.PARTB_MONTH, part_B_Month_Entered);
		getLoginScenario().saveBean(MedSuppCommonConstants.PARTB_YEAR, part_B_Year_Entered);
		getLoginScenario().saveBean(MedSuppCommonConstants.START_DATE, start_Date_Entered);
	}

	@Then("^the user validates Insurance Agent Step (\\d+) page info is same as the saved information from Pre-entry page on UMS site for Insurance Agent$")
	public void the_user_validates_Insurance_Agent_Step_page_info_is_same_as_the_saved_information_from_Pre_entry_page_on_UMS_site_for_Insurance_Agent(int arg1) throws Throwable {
		IsInsuranceAgentStep2 InsuranceAgentStep2Page = (IsInsuranceAgentStep2) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE2);
		String DOBEntered = (String) getLoginScenario().getBean(MedSuppCommonConstants.DOB);
		String part_A_Month_Entered = (String) getLoginScenario().getBean(MedSuppCommonConstants.PARTA_MONTH);
		String part_A_Year_Entered = (String) getLoginScenario().getBean(MedSuppCommonConstants.PARTA_YEAR);
		String part_B_Month_Entered = (String) getLoginScenario().getBean(MedSuppCommonConstants.PARTB_MONTH);
		String part_B_Year_Entered = (String) getLoginScenario().getBean(MedSuppCommonConstants.PARTB_YEAR);
		String start_Date_Entered = (String) getLoginScenario().getBean(MedSuppCommonConstants.START_DATE);
		Map<String, String> EnteredData = new HashMap<String, String>();

		EnteredData.put("DOB",DOBEntered);
		EnteredData.put("part_A_Month_Entered",part_A_Month_Entered);
		EnteredData.put("part_A_Year_Entered",part_A_Year_Entered);
		EnteredData.put("part_B_Month_Entered",part_B_Month_Entered);
		EnteredData.put("part_B_Year_Entered",part_B_Year_Entered);
		EnteredData.put("startDateEntered",start_Date_Entered);
		InsuranceAgentStep2Page.validatePreEntryPageData(EnteredData);

	}
	
	@Then("^the user clicks on Request a Free Insurance Agent on the Raight Rail on VPP PLan Summary Page for Med Supp Plans on UHC site$")
	public void the_user_clicks_on_Request_a_Free_Insurance_Agent_on_the_Raight_Rail_on_VPP_PLan_Summary_Page_for_Med_Supp_Plans_on_UHC_site() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		IsInsuranceAgentStep2 InsuranceAgentStep2Page = plansummaryPage.clickOnRequestInsuranceAgent();

		if (InsuranceAgentStep2Page != null) {
			System.out.println("Successfully navigated to IS Decision Guide Step 1 Page");
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE2,InsuranceAgentStep2Page);
		} else {
			Assert.assertTrue("PROBLEM - Is Insurance Agent Step 1 Page is null", false);
		}
	}


	@Then("^the user validates all the required fields for blank validation on Step(\\d+) on UMS site for Insurance Agent$")
	public void the_user_validates_all_the_required_fields_for_blank_validation_on_Step(int arg1) throws Throwable {
		IsInsuranceAgentStep2 InsuranceAgentStep2Page =(IsInsuranceAgentStep2) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE2);
		boolean Validation_Flag = InsuranceAgentStep2Page.blankFieldValidation();
		if(!Validation_Flag){
			Assert.assertTrue("PROBLEM - Step 1 Page Blank Field Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE2,InsuranceAgentStep2Page);

	}

	@Then("^the user validated all fields for invalid validation on Step(\\d+) on UMS site for Insurance Agent$")
	public void the_user_validated_all_fields_for_invalid_validation_on_Step(int arg1) throws Throwable {
		IsInsuranceAgentStep2 InsuranceAgentStep2Page =(IsInsuranceAgentStep2) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE2);
		boolean Validation_Flag = InsuranceAgentStep2Page.invalidFieldValidation();
		if(!Validation_Flag){
			Assert.assertTrue("PROBLEM - Step 1 Page Invalid Data Field Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE2,InsuranceAgentStep2Page);

	}

	@Then("^the user validated invalid address error message for next button on Step(\\d+) on UMS site for Insurance Agent$")
	public void the_user_validated_invalid_address_error_message_for_next_button_on_Step(int arg1) throws Throwable {
		IsInsuranceAgentStep1  InsuranceAgentStep2Page =(IsInsuranceAgentStep1) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE2);
		boolean Validation_Flag =  InsuranceAgentStep2Page.NextBtn_invalidAddressValidation();
		if(!Validation_Flag){
			Assert.assertTrue("PROBLEM - Step 1 Page Invalid Address Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE2, InsuranceAgentStep2Page);
	}

	@Then("^the user enters valid information for the following fields on UMS site for Insurance Agent$")
	public void the_user_enters_valid_information_for_the_following_fields_on_UMS_site_for_Insurance_Agent(DataTable givenAttributes) throws Throwable {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		IsInsuranceAgentStep2 InsuranceAgentStep2Page = (IsInsuranceAgentStep2) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE2);
		InsuranceAgentStep2Page.enterUserInfoStep2(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE2,InsuranceAgentStep2Page);

	}

	@Then("^the user validates address autocomplete on Step(\\d+) on UMS site for Insurance Agent$")
	public void the_user_validates_address_autocomplete_on_Step(int arg1) throws Throwable {
		IsInsuranceAgentStep1 InsuranceAgentStep1Page = (IsInsuranceAgentStep1) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE2);
		boolean Validation_Flag = InsuranceAgentStep1Page.Validate_addressAutoComplete();
		if(!Validation_Flag){
			Assert.assertTrue("PROBLEM - Step 1 Page Address Aut Complete Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE2,InsuranceAgentStep1Page);
	}

	
	@Then("^the user clicks Submit to submit Insurance Agent on UMS site for Insurance Agent$")
	public void the_user_clicks_Submit_to_submit_Insurance_Agent_on_UMS_site() throws Throwable {
		IsInsuranceAgentStep2 InsuranceAgentStep2Page =(IsInsuranceAgentStep2) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE2);
		pages.acquisition.isinsuranceagent.DGR_ThankYouPage dgrThankYouPage = InsuranceAgentStep2Page.NavigateNext_DGRthankYouPage();
		if (dgrThankYouPage != null) {
			System.out.println("Successfully navigated to IS Insurance Agent Page");
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE2,dgrThankYouPage);
		} else {
			Assert.assertTrue("PROBLEM - Is IS Insurance Agent Page is null", false);
		}

	}

	@Then("^the user validates Thank You Page on UMS site for Insurance Agent$")
	public void the_user_validates_Thank_You_Page_on_UMS_site_for_Insurance_Agent() throws Throwable {
		
	}
*/
} 


