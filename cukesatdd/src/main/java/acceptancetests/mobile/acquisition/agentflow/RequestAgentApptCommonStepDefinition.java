package acceptancetests.mobile.acquisition.agentflow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.LearnAboutMedicareHomePageMobile;
import pages.mobile.acquisition.commonpages.RequestAgentAppointmentPageMobile;
import pages.mobile.acquisition.commonpages.RequestHelpAndInformationPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;


//import pages.acquisition.ulayer.VPPPlanSummaryPageMobile;


/**
 *Functionality: Agent Flow
 */
public class RequestAgentApptCommonStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	/**
	 * @toDo: user navigates to request more help and information in 
	 */
	@When("^the user clicks on Agent link and validates the correct URL is loaded$")
	public void User_navigate_EBRC_Links(DataTable arg1) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String myUHCAgentURL = inputAttributesMap.get("UHC Agent URL");
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		
		if(myUHCAgentURL!=null){
			aquisitionhomepage.clickonFindanAgentlink(myUHCAgentURL);
			Assertion.assertTrue(true);
		}else
			Assertion.fail("Error in loading the UHC Agent Page");
	}
	
	@When("^the user clicks on Agent link and validates the correct URL is loaded for Medsupp page$")
	public void User_navigate_EBRC_Links_through_Medsupp(DataTable arg1) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String myUHCAgentURL = inputAttributesMap.get("UHC Agent URL");
	//	AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		if(plansummaryPage!=null){
			plansummaryPage.clickonFindanAgentlinkMedsupp(myUHCAgentURL);
			Assertion.assertTrue(true);
		}else
			Assertion.fail("Error in loading the UHC Agent Page");
	}
	
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		/*List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}*/
		memberAttributesMap = DataTableParser.readDataTableAsMaps(memberAttributes);
		return memberAttributesMap;
	}
	
	@When("^the user navigates to request more help and information$")
	public void navigates_request_more_help_information()
	{
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RequestHelpAndInformationPageMobile requestHelpAndInformationPage = aquisitionhomepage.navigateToMaMoreHelpAndInfo();
		
		if(requestHelpAndInformationPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
				Assertion.assertTrue(true);

		}else
			Assertion.fail("Error in loading the Request Help and Info Page");
	}
	
	/**
	 * @todo : user navigates to request appointment with an agent in 
	 */
	@And("^the user navigates to request appointment with an agent and validates page is loaded$")
	public void request_appointment()
	{
		RequestHelpAndInformationPageMobile requestHelpAndInformationPage = (RequestHelpAndInformationPageMobile) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
		RequestAgentAppointmentPageMobile requestAgentAppointmentPage = requestHelpAndInformationPage.navigateToAgentAppointmentRequest();
		if(requestAgentAppointmentPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE, requestAgentAppointmentPage);
		}else{
			Assertion.fail("Error in loading requestAgentAppointmentPage");
		}
		
	}
	
	
	@Then("^the user fills the form out and submits the agent appointment$")
	public void fillOutAndSubmitFormappointment(DataTable attributes) {
		
		RequestAgentAppointmentPageMobile requestAgentAppointmentPage = (RequestAgentAppointmentPageMobile) getLoginScenario()
					.getBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE);
			Map<String, String> givenAttributesMap = new HashMap<String, String>();
			/*List<DataTableRow> givenAttributesRow = attributes.getGherkinRows();
			for (int i = 0; i < givenAttributesRow.size(); i++) {

				givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
						givenAttributesRow.get(i).getCells().get(1));
			}*/
			givenAttributesMap = DataTableParser.readDataTableAsMaps(attributes);
			boolean isFormSubmitted = requestAgentAppointmentPage.submitAgentAppointment(givenAttributesMap);
			if (isFormSubmitted) {
				System.out.println("Successfully submitted the Appointment form");
				Assertion.assertTrue(true);
			} else {
				Assertion.fail("Error submitting the form or loading the Confirmation page");
			}
		
			
	}

	
//	@Then("^the user click on Request more Information$")
//	public void click_on_Request_more_information() throws Throwable {
//		AcquisitionHomePageMobile requestAgentAppointmentPage = (AcquisitionHomePageMobile)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		RequestHelpAndInformationPage ContactusPage =requestAgentAppointmentPage.RequestLinkOnShopPlan();
//	//	RequestAgentAppointmentPage ContactusPage = requestAgentAppointmentPage.RequestLinkOnShopPlan();
//		if (ContactusPage != null)
//			getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, ContactusPage);
//		else
//			System.out.println("Error in loading requestAgentAppointmentPage");
//	}
//	
	@When("^the user clicks on Agent link and validates the correct URL is loaded from Med Ed Page$")
	public void User_navigate_EBRC_Links_from_MedEd(DataTable arg1) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String myUHCAgentURL = inputAttributesMap.get("UHC Agent URL");
		
		LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage=(LearnAboutMedicareHomePageMobile)getLoginScenario().getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);		
		if(myUHCAgentURL!=null){
			learnAboutMedicareHomePage.clickonFindanAgentlinkfromMedEd(myUHCAgentURL);
			Assertion.assertTrue(true);
		}else
			Assertion.fail("Error in loading the UHC Agent Page");
	}
	
}

