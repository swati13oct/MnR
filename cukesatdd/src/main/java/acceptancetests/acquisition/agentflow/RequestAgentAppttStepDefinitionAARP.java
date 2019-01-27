package acceptancetests.acquisition.agentflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.RequestAgentAppointmentPage;
import pages.acquisition.ulayer.RequestHelpAndInformationPage;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

/**
 * Functionality: request Agent Appointment
 */

public class RequestAgentAppttStepDefinitionAARP {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @todo : user navigates to request more help and information
	 */
	@When("^the user navigates to request more help and information in AARP site$")
	public void request_more_help_information()
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
	@And("^the user navigates to request appointment with an agent in AARP site and validates page is loaded$")
	public void request_appointment_aarp()
	{
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
		RequestAgentAppointmentPage requestAgentAppointmentPage = requestHelpAndInformationPage.navigateToAgentAppointmentRequest();
		if(requestAgentAppointmentPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE, requestAgentAppointmentPage);
		}else{
			Assert.fail("Error in loading requestAgentAppointmentPage");
		}
		
	}
	
	/**
	 * @todo : user navigates to request appointment with an agent in 
	 */
	@Then("^user validates error messages on submitting blank form on aarp site$")
	public void user_validates_error_messages_on_submitting_blank_form_aarp()
	{
		RequestAgentAppointmentPage requestAgentAppointmentPage = (RequestAgentAppointmentPage) getLoginScenario().getBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE);
		requestAgentAppointmentPage.SubmitForm();
		boolean errorMessageValidated = requestAgentAppointmentPage.validateErrorMessages();
		if(errorMessageValidated){
			Assert.assertTrue(errorMessageValidated);
		}else{
			Assert.fail("Error in loading error messages");
		}
		
	}
	
	@Then("^the user fills the form out and submits the agent appointment application$")
	public void fillOutAndSubmitForm(DataTable attributes) {
		if (!MRScenario.environment.equals("team-ci1")) {
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
	
}
