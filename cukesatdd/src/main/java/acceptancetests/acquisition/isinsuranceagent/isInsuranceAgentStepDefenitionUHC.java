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
import pages.acquisition.isinsuranceagent.IsInsuranceAgent;
import pages.acquisition.isinsuranceagent.License_ThankYouPage;
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

	@Then("^the user enters and  saves the entered information in Pre entry page for validation on IS Insurance Agent forms on UMS site$")
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

	@Then("^the user enters valid information for the following fields on UMS site for Insurance Agent$")
	public void the_user_enters_valid_information_for_the_following_fields_on_UHC_site(DataTable givenAttributes) throws Throwable {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		IsInsuranceAgent LicenseInsuranceAgentPage =(IsInsuranceAgent) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE);
		LicenseInsuranceAgentPage.enterUserInfoStep1(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE,LicenseInsuranceAgentPage);

	}

	@Then("^the user validates address autocomplete on Licensed Agent on UHC site$")
	public void the_user_validates_address_autocomplete_on_Licensed_Agent_UHC_Step() throws Throwable {
		IsInsuranceAgent LicenseInsuranceAgentPage =(IsInsuranceAgent) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE);
		boolean Validation_Flag = LicenseInsuranceAgentPage.Validate_addressAutoComplete();
		if(!Validation_Flag){
			Assert.assertTrue("PROBLEM -  Address Aut Complete Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE,LicenseInsuranceAgentPage);
	}

	@Then("^the user provides DOB and Phone Number on uhc site$")
	public void the_user_provides_DOB_PhoneNumber_on_UHC_site(DataTable givenAttributes) throws Throwable {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		IsInsuranceAgent LicenseInsuranceAgentPage =(IsInsuranceAgent) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE);
		LicenseInsuranceAgentPage.enterUserInfoStep2(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE,LicenseInsuranceAgentPage);

	}

	@Then("^the user clicks Submit to submit Licensed Insurance Agent on UHC site$")
	public void the_user_clicks_Submit_to_submit_Licensed_Insurance_on_AARP_site() throws Throwable {
		IsInsuranceAgent LicenseInsuranceAgentPage =(IsInsuranceAgent) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE);
		License_ThankYouPage dgrThankYouPage = LicenseInsuranceAgentPage.NavigateNext_LIAthankYouPage();
		if(dgrThankYouPage != null) {
			System.out.println("Successfully navigated to Licensed Insurance Submit Page");
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE,dgrThankYouPage);
		} else {
			Assert.assertTrue("PROBLEM - Licensed Insurance Submit is null", false);
		}

	}

	@Then("^the user validates Thank You Page on Licensed Insurance Agent UHC site$")
	public void the_user_validates_Thank_You_Page_on_Licensed_Agent_AARP_site() throws Throwable {
		
	}
}