package acceptancetests.acquisition.isinsuranceagent;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

//import pages.acquisition.ulayer.AcquisitionHomePage;
//import pages.acquisition.ulayer.VPPPlanSummaryPage;
//import acceptancetests.vbfacquisition_deprecated.vpp.VPPCommonConstants;
import acceptancetests.acquisition.isdecisionguide.MedSuppCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.isinsuranceagent.IsInsuranceAgent;
import pages.acquisition.isinsuranceagent.License_ThankYouPage;
/**
 * @author Venkata Sai
 * Functionality:Licensed Insurance Agent - Med Supp Decision Guide for both AARP and UHC acquisition sites
 */
public class isInsuranceAgentCommonStepDefenition    {

	
		// TODO Auto-generated constructor stub
	

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	WebDriver wd;
	@Then("^the user enters and  saves the entered information in Pre-entry page for validation on Licensed InsuranceAgent forms$")
	public void the_user_saves_the_entered_information_in_Pre_entry_page_for_validation_on_Licensed_Insurance_Agent_forms(DataTable givenAttributes) throws Throwable {
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
	
	@Then("^the user clicks on Request a Free Insurance Agent on the Raight Rail on VPP PLan Summary Page for Med Supp Plans$")
	public void the_user_clicks_on_Request_a_Free_Insurance_Agent_on_the_Raight_Rail_on_VPP_PLan_Summary_Page_for_Med_Supp_Plans() throws Throwable {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		IsInsuranceAgent InsuranceAgentStep1Page = plansummaryPage.clickOnRequestInsuranceAgent();

		if (InsuranceAgentStep1Page != null) {
			System.out.println("Successfully navigated to Licensed Insuance Agent Page");
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE,InsuranceAgentStep1Page);
		} else {
			Assertion.assertTrue("PROBLEM - Licensed Insuance Agent Page is null", false);
		}
	}

	@Then("^the user enters valid information on Licensed Insurance Agentfor the following fields$")
	public void the_user_enters_valid_information_Licensed_Insurance_Agentfor_the_following_fields(DataTable givenAttributes) throws Throwable {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		IsInsuranceAgent LicenseInsuranceAgentPage =(IsInsuranceAgent) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE);
		LicenseInsuranceAgentPage.enterUserInfoStep1(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE,LicenseInsuranceAgentPage);

	}

	@Then("^the user validates address autocomplete on Licensed Agent$")
	public void the_user_validates_address_autocomplete_on_Licensed_Agent() throws Throwable {
		IsInsuranceAgent LicenseInsuranceAgentPage =(IsInsuranceAgent) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE);
		boolean Validation_Flag = LicenseInsuranceAgentPage.Validate_addressAutoComplete();
		if(!Validation_Flag){
			Assertion.assertTrue("PROBLEM -  Address Aut Complete Validation failed", false);
		}
		else
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE,LicenseInsuranceAgentPage);
	}

	@Then("^the user provides DOB and Phone Number$")
	public void the_user_provides_DOB_PhoneNumber(DataTable givenAttributes) throws Throwable {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		IsInsuranceAgent LicenseInsuranceAgentPage =(IsInsuranceAgent) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE);
		LicenseInsuranceAgentPage.enterUserInfoStep2(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE,LicenseInsuranceAgentPage);

	}

	@Then("^the user clicks Submit to submit Licensed Insurance Agent and validates Thank You Page$")
	public void the_user_clicks_Submit_to_submit_Licensed_Insurance_and_validates_Thank_You_Page() throws Throwable {
		IsInsuranceAgent LicenseInsuranceAgentPage =(IsInsuranceAgent) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE);
		if (!(MRScenario.environment.equalsIgnoreCase("offline")
				|| MRScenario.environment.equalsIgnoreCase("prod"))) {
		License_ThankYouPage dgrThankYouPage = LicenseInsuranceAgentPage.NavigateNext_LIAthankYouPage();
		if(dgrThankYouPage != null) {
			System.out.println("Successfully navigated to Licensed Insurance Submit Page");
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE,dgrThankYouPage);
		} else {
			Assertion.assertTrue("PROBLEM - Licensed Insurance Submit is null", false);
			}
		}
	}
	
	@Then("^the user clicks on Request a Free Insurance Agent$")
	public void the_user_clicks_on_Request_a_Free_Insurance_Agent(DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : "+path);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);	
 //  IsInsuranceAgent licenseInsuranceAgent =(IsInsuranceAgent) getLoginScenario().getBean(PageConstants.IS_INSURANCE_AGENT_PAGE);
	
//	licenseInsuranceAgent.navigateToISPath(path);
		IsInsuranceAgent lispage = aquisitionhomepage.navigateToISPath(path);

		if (lispage != null) {
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE, lispage);

		} else {
			Assertion.fail("Error Loading Insurance Agent page");
		}
	
	}
	
	
	@And("^user click on Insurance agent link on the MedED Pages$")
	public void user_click_on_Insurance_agent_link_MedED_Pages() throws Throwable {
	
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);	
		
		IsInsuranceAgent lispage= aquisitionhomepage.clickISlinkMedEDPages();
		
		if (lispage != null) {
			getLoginScenario().saveBean(PageConstants.IS_INSURANCE_AGENT_PAGE, lispage);

		} else {
			Assert.fail("Error Loading Insurance Agent page");
		}
	}
} 


