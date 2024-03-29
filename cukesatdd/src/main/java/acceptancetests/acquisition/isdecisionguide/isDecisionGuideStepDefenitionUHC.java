package acceptancetests.acquisition.isdecisionguide;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.isdecisionguide.DGR_ThankYouPage;
import pages.acquisition.isdecisionguide.IsDecisionGuideStep1;
import pages.acquisition.isdecisionguide.IsDecisionGuideStep2;
/**
 * @author sdwaraka
 * Functionality:IS - Med Supp Decision Guide for both AARP and UHC acquisition sites
 */
public class isDecisionGuideStepDefenitionUHC    {

	
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
	
		
	@Then("^the user enters valid information for the pre entry form on UMS site$")
	public void the_user_enters_valid_information_for_the_pre_entry_form_on_UMS_site(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String dateOfBirth= memberAttributesMap.get("DOB");
		//String zipcode= memberAttributesMap.get("zipcode");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		//plansummaryPage.MedSupFormValidation(dateOfBirth,zipcode);
		plansummaryPage.MedSupFormValidation(dateOfBirth);
		
	}
	@Then("^the user enters and  saves the entered information in Pre entry page for validation on IS forms on UMS site$")
	public void the_user_saves_the_entered_information_in_Pre_entry_page_for_validation_on_IS_form_on_UMS_site(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
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

	@Then("^the user validates Decision Guide Step (\\d+) page info is same as the saved information from Pre-entry page on UMS site$")
	public void the_user_validates_Decision_Guide_Step_page_info_is_same_as_the_saved_information_from_Pre_entry_page_on_UMS_site(int arg1) throws Throwable {
		IsDecisionGuideStep2 DecisionGuideStep2Page = (IsDecisionGuideStep2) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE2);
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
		DecisionGuideStep2Page.validatePreEntryPageData(EnteredData);

	}
	
	@Then("^the user clicks on Request a Free Decision Guide on the Raight Rail on VPP PLan Summary Page for Med Supp Plans on UHC site$")
	public void the_user_clicks_on_Request_a_Free_Decision_Guide_on_the_Raight_Rail_on_VPP_PLan_Summary_Page_for_Med_Supp_Plans_on_UHC_site() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		IsDecisionGuideStep1 DecisionGuideStep1Page = plansummaryPage.clickOnRequestADecisionGuide();

		if (DecisionGuideStep1Page != null) {
			System.out.println("Successfully navigated to IS Decision Guide Step 1 Page");
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);
		} else {
			Assertion.assertTrue("PROBLEM - Is Decision Guide Step 1 Page is null", false);
		}
	}


	@Then("^the user validates all the required fields for blank validation on Step(\\d+) on UMS site$")
	public void the_user_validates_all_the_required_fields_for_blank_validation_on_Step(int arg1) throws Throwable {
		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		boolean Validation_Flag = DecisionGuideStep1Page.blankFieldValidation();
		if(!Validation_Flag){
			Assertion.assertTrue("PROBLEM - Step 1 Page Blank Field Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);

	}

	@Then("^the user validated all fields for invalid validation on Step(\\d+) on UMS site$")
	public void the_user_validated_all_fields_for_invalid_validation_on_Step(int arg1) throws Throwable {
		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		boolean Validation_Flag = DecisionGuideStep1Page.invalidFieldValidation();
		if(!Validation_Flag){
			Assertion.assertTrue("PROBLEM - Step 1 Page Invalid Data Field Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);

	}

	@Then("^the user validated invalid address error message for next button on Step(\\d+) on UMS site$")
	public void the_user_validated_invalid_address_error_message_for_next_button_on_Step(int arg1) throws Throwable {
		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		boolean Validation_Flag = DecisionGuideStep1Page.NextBtn_invalidAddressValidation();
		if(!Validation_Flag){
			Assertion.assertTrue("PROBLEM - Step 1 Page Invalid Address Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);
	}

	@Then("^the user enters valid information for the following fields on UMS site$")
	public void the_user_enters_valid_information_for_the_following_fields_on_UMS_site(DataTable givenAttributes) throws Throwable {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		DecisionGuideStep1Page.enterUserInfoStep1(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);

	}

	@Then("^the user validates address autocomplete on Step(\\d+) on UMS site$")
	public void the_user_validates_address_autocomplete_on_Step(int arg1) throws Throwable {
		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		boolean Validation_Flag = DecisionGuideStep1Page.Validate_addressAutoComplete();
		if(!Validation_Flag){
			Assertion.assertTrue("PROBLEM - Step 1 Page Address Aut Complete Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);
	}

	@Then("^user clicks Next to Navigate to Second Step on UMS site$")
	public void user_clicks_Next_to_Navigate_to_Second_Step_on_UMS_site() throws Throwable {
		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		IsDecisionGuideStep2 DecisionGuideStep2Page = DecisionGuideStep1Page.NavigateNext_DGRStep2();
		if (DecisionGuideStep2Page != null) {
			System.out.println("Successfully navigated to IS Decision Guide Step 2 Page");
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE2,DecisionGuideStep2Page);
		} else {
			Assertion.assertTrue("PROBLEM - Is Decision Guide Step 2 Page is null", false);
		}

	}
	
	@Then("^the user validates all the required fields for blank validation on Second Step on UMS site$")
	public void the_user_validates_all_the_required_fields_for_blank_validation_on_Second_Step_on_UMS_site() throws Throwable {
		IsDecisionGuideStep2 DecisionGuideStep2Page  =(IsDecisionGuideStep2) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE2);
		boolean Validation_Flag = DecisionGuideStep2Page.blankFieldValidation();
		if(!Validation_Flag){
			Assertion.assertTrue("PROBLEM - Step 2 Page Blank Field Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE2,DecisionGuideStep2Page);

	}

	@Then("^the user validated all fields for invalid validation on Second Step on UMS site$")
	public void the_user_validated_all_fields_for_invalid_validation_on_Second_Step_on_UMS_site() throws Throwable {
		IsDecisionGuideStep2 DecisionGuideStep2Page =(IsDecisionGuideStep2) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE2);
		boolean Validation_Flag = DecisionGuideStep2Page.invalidFieldValidation();
		if(!Validation_Flag){
			Assertion.assertTrue("PROBLEM - Step 2 Page Invalid Data Field Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE2,DecisionGuideStep2Page);

	}


	@Then("^the user provides all valid information for Second Step on UMS site$")
	public void the_user_provides_all_valid_information_for_Second_Step_on_UMS_site(DataTable givenAttributes) throws Throwable {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		IsDecisionGuideStep2 DecisionGuideStep2Page =(IsDecisionGuideStep2) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE2);
		DecisionGuideStep2Page.enterUserInfoStep2(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE2,DecisionGuideStep2Page);

	}

	@Then("^the user clicks Submit to submit Decision Guide on UMS site$")
	public void the_user_clicks_Submit_to_submit_Decision_Guide_on_UMS_site() throws Throwable {
		IsDecisionGuideStep2 DecisionGuideStep2Page =(IsDecisionGuideStep2) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE2);
		DGR_ThankYouPage dgrThankYouPage = DecisionGuideStep2Page.NavigateNext_DGRthankYouPage();
		if (dgrThankYouPage != null) {
			System.out.println("Successfully navigated to IS Decision Guide Step 2 Page");
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE2,dgrThankYouPage);
		} else {
			Assertion.assertTrue("PROBLEM - Is Decision Guide Step 2 Page is null", false);
		}

	}

	@Then("^the user validates Thank You Page on UMS site$")
	public void the_user_validates_Thank_You_Page_on_UMS_site() throws Throwable {
		
	}

} 


