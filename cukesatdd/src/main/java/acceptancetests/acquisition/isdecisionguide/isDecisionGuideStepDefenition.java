package acceptancetests.acquisition.isdecisionguide;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.PlanComparePage;
import pages.acquisition.isdecisionguide.DGR_ThankYouPage;
import pages.acquisition.isdecisionguide.IsDecisionGuideStep1;
import pages.acquisition.isdecisionguide.IsDecisionGuideStep2;
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
import pages.acquisition.ulayer.ComparePlansPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.vbfacquisition_deprecated.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
/**
 * @author sdwaraka
 * Functionality:IS - Med Supp Decision Guide for both AAPR and UHC acquisition sites
 */
public class isDecisionGuideStepDefenition {

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
	@Then("^the user clicks on Request a Free Decision Guide on the Raight Rail on VPP PLan Summary Page for Med Supp Plans on AARP site$")
	public void the_user_clicks_on_Request_a_Free_Decision_Guide_on_the_Raight_Rail_on_VPP_PLan_Summary_Page_for_Med_Supp_Plans_on_AARP_site() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		IsDecisionGuideStep1 DecisionGuideStep1Page = plansummaryPage.clickOnRequestADecisionGuide();

		if (DecisionGuideStep1Page != null) {
			System.out.println("Successfully navigated to IS Decision Guide Step 1 Page");
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);
		} else {
			Assert.assertTrue("PROBLEM - Is Decision Guide Step 1 Page is null", false);
		}
	}


	@Then("^the user validates all the required fields for blank validation on Step(\\d+)$")
	public void the_user_validates_all_the_required_fields_for_blank_validation_on_Step(int arg1) throws Throwable {
		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		boolean Validation_Flag = DecisionGuideStep1Page.blankFieldValidation();
		if(!Validation_Flag){
			Assert.assertTrue("PROBLEM - Step 1 Page Blank Field Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);

	}

	@Then("^the user validated all fields for invalid validation on Step(\\d+)$")
	public void the_user_validated_all_fields_for_invalid_validation_on_Step(int arg1) throws Throwable {
		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		boolean Validation_Flag = DecisionGuideStep1Page.invalidFieldValidation();
		if(!Validation_Flag){
			Assert.assertTrue("PROBLEM - Step 1 Page Invalid Data Field Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);

	}

	@Then("^the user validated invalid address error message for next button on Step(\\d+)$")
	public void the_user_validated_invalid_address_error_message_for_next_button_on_Step(int arg1) throws Throwable {
		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		boolean Validation_Flag = DecisionGuideStep1Page.NextBtn_invalidAddressValidation();
		if(!Validation_Flag){
			Assert.assertTrue("PROBLEM - Step 1 Page Invalid Address Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);
	}

	@Then("^the user enters valid information for the following fields$")
	public void the_user_enters_valid_information_for_the_following_fields(DataTable givenAttributes) throws Throwable {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		DecisionGuideStep1Page.enterUserInfoStep1(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);

	}

	@Then("^the user validates address autocomplete on Step(\\d+)$")
	public void the_user_validates_address_autocomplete_on_Step(int arg1) throws Throwable {
		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		boolean Validation_Flag = DecisionGuideStep1Page.Validate_addressAutoComplete();
		if(!Validation_Flag){
			Assert.assertTrue("PROBLEM - Step 1 Page Address Aut Complete Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE1,DecisionGuideStep1Page);
	}

	@Then("^user clicks Next to Navigate to Second Step$")
	public void user_clicks_Next_to_Navigate_to_Step2() throws Throwable {
		IsDecisionGuideStep1 DecisionGuideStep1Page =(IsDecisionGuideStep1) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE1);
		IsDecisionGuideStep2 DecisionGuideStep2Page = DecisionGuideStep1Page.NavigateNext_DGRStep2();
		if (DecisionGuideStep2Page != null) {
			System.out.println("Successfully navigated to IS Decision Guide Step 2 Page");
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE2,DecisionGuideStep2Page);
		} else {
			Assert.assertTrue("PROBLEM - Is Decision Guide Step 2 Page is null", false);
		}

	}
	
	@Then("^the user validates all the required fields for blank validation on Second Step$")
	public void the_user_validates_all_the_required_fields_for_blank_validation_on_Step2() throws Throwable {
		IsDecisionGuideStep2 DecisionGuideStep2Page  =(IsDecisionGuideStep2) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE2);
		boolean Validation_Flag = DecisionGuideStep2Page.blankFieldValidation();
		if(!Validation_Flag){
			Assert.assertTrue("PROBLEM - Step 2 Page Blank Field Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE2,DecisionGuideStep2Page);

	}

	@Then("^the user validated all fields for invalid validation on Second Step$")
	public void the_user_validated_all_fields_for_invalid_validation_on_Step2() throws Throwable {
		IsDecisionGuideStep2 DecisionGuideStep2Page =(IsDecisionGuideStep2) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE2);
		boolean Validation_Flag = DecisionGuideStep2Page.invalidFieldValidation();
		if(!Validation_Flag){
			Assert.assertTrue("PROBLEM - Step 2 Page Invalid Data Field Error Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE2,DecisionGuideStep2Page);

	}


	@Then("^the user provides all valid information for Second Step$")
	public void the_user_provides_all_valid_information_for_Step(DataTable givenAttributes) throws Throwable {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		IsDecisionGuideStep2 DecisionGuideStep2Page =(IsDecisionGuideStep2) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE2);
		DecisionGuideStep2Page.enterUserInfoStep2(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE2,DecisionGuideStep2Page);

	}

	@Then("^the user clicks Submit to submit Decision Guide on AARP site$")
	public void the_user_clicks_Submit_to_submit_Decision_Guide_on_AARP_site() throws Throwable {
		IsDecisionGuideStep2 DecisionGuideStep2Page =(IsDecisionGuideStep2) getLoginScenario().getBean(PageConstants.IS_DECISION_GUIDE_PAGE2);
		DGR_ThankYouPage dgrThankYouPage = DecisionGuideStep2Page.NavigateNext_DGRthankYouPage();
		if (dgrThankYouPage != null) {
			System.out.println("Successfully navigated to IS Decision Guide Step 2 Page");
			getLoginScenario().saveBean(PageConstants.IS_DECISION_GUIDE_PAGE2,dgrThankYouPage);
		} else {
			Assert.assertTrue("PROBLEM - Is Decision Guide Step 2 Page is null", false);
		}

	}

	@Then("^the user validates Thank You Page$")
	public void the_user_validates_Thank_You_Page() throws Throwable {
		
	}

} 


