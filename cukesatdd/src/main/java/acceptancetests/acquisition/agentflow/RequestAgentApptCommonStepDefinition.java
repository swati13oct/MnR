package acceptancetests.acquisition.agentflow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.RequestAgentAppointmentPage;
import pages.acquisition.commonpages.RequestHelpAndInformationPage;
import pages.acquisition.ulayer.ProviderSearchPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;


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
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		
		if(myUHCAgentURL!=null){
			aquisitionhomepage.clickonFindanAgentlink(myUHCAgentURL);
			Assert.assertTrue(true);
		}else
			Assert.fail("Error in loading the UHC Agent Page");
	}
	
	@When("^the user clicks on Agent link and validates the correct URL is loaded for Medsupp page$")
	public void User_navigate_EBRC_Links_through_Medsupp(DataTable arg1) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String myUHCAgentURL = inputAttributesMap.get("UHC Agent URL");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		
		if(myUHCAgentURL!=null){
			aquisitionhomepage.clickonFindanAgentlinkMedsupp(myUHCAgentURL);
			Assert.assertTrue(true);
		}else
			Assert.fail("Error in loading the UHC Agent Page");
	}
	
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}
	
	@When("^the user navigates to request more help and information$")
	public void navigates_request_more_help_information()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RequestHelpAndInformationPage requestHelpAndInformationPage = aquisitionhomepage.navigateToMaMoreHelpAndInfo();
		
		if(requestHelpAndInformationPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
				Assert.assertTrue(true);

		}else
			Assert.fail("Error in loading the Request Help and Info Page");
	}
	
	/**
	 * @todo : user navigates to request appointment with an agent in 
	 */
	@And("^the user navigates to request appointment with an agent and validates page is loaded$")
	public void request_appointment()
	{
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
		RequestAgentAppointmentPage requestAgentAppointmentPage = requestHelpAndInformationPage.navigateToAgentAppointmentRequest();
		if(requestAgentAppointmentPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE, requestAgentAppointmentPage);
		}else{
			Assert.fail("Error in loading requestAgentAppointmentPage");
		}
		
	}
	
	
	@Then("^the user fills the form out and submits the agent appointment$")
	public void fillOutAndSubmitFormappointment(DataTable attributes) {
		
			RequestAgentAppointmentPage requestAgentAppointmentPage = (RequestAgentAppointmentPage) getLoginScenario()
					.getBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE);
			List<DataTableRow> givenAttributesRow = attributes.getGherkinRows();
			Map<String, String> givenAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < givenAttributesRow.size(); i++) {

				givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
						givenAttributesRow.get(i).getCells().get(1));
			}
			boolean isFormSubmitted = requestAgentAppointmentPage.submitAgentAppointment(givenAttributesMap);
			if (isFormSubmitted) {
				System.out.println("Successfully submitted the Appointment form");
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error submitting the form or loading the Confirmation page");
			}
		
			
	}
}