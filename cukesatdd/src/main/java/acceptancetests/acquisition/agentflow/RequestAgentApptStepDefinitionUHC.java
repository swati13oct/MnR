package acceptancetests.acquisition.agentflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.RequestAgentAppointmentPage;
import pages.acquisition.bluelayer.RequestHelpAndInformationPage;
import pages.acquisition.bluelayer.RequestMailedInformationUHC;

/**
 *Functionality: Agent Flow
 */
public class RequestAgentApptStepDefinitionUHC {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	/**
	 * @toDo: user navigates to request more help and information in 
	 */
	@When("^the user navigates to request more help and information in UHC site$")
	public void request_more_help_information()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RequestHelpAndInformationPage requestHelpAndInformationPage = aquisitionhomepage.navigateToMaMoreHelpAndInfo();
		
		if(requestHelpAndInformationPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
			Assert.assertTrue(true);
		}else
			Assert.fail("Error in loading the Help and Info Page");
	}
	
	/**
	 * @toDo: request appointment with an agent in UHC site 
	 */
	@And("^the user navigates to request appointment with an agent in UHC site and validates page loaded$")
	public void request_appointment()
	{
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
		RequestAgentAppointmentPage requestAgentAppointmentPage = requestHelpAndInformationPage.navigateToAgentAppointmentRequest();
		if(requestAgentAppointmentPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE, requestAgentAppointmentPage);
			System.out.println("Request agent appointment page loaded");
		}
		else{
			Assert.fail("Error in loading requestAgentAppointmentPage");
		}
		
	}
	
	@Then("^the user fills the form out and submits the uhc agent appointment application$")
	public void fillOutAndSubmitForm(DataTable attributes) {
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
	
	/**
	 * @todo : user navigates to request appointment with an agent in 
	 */
	@Then("^user validates error messages on submitting blank form on UHC site$")
	public void user_validates_error_messages_on_submitting_blank_form_uhc()
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
	
	@When("^the user navigates to the request mailed information in UHC site and validates page is loaded$")
	public void the_user_navigates_to_the_request_mailed_information_in_UHC_site_and_validates_page_is_loaded() throws Throwable {
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
		RequestMailedInformationUHC requestmailedinformationuhc = requestHelpAndInformationPage.navigateToRequestMailedinformationUHC();
		if(requestmailedinformationuhc!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_MAILED_INFORMATION_UHC, requestmailedinformationuhc);
		}else{
			Assert.fail("Error in loading requestAgentAppointmentPage");
		}
	}

	@When("^the user fills the Enrollment guide plan form and validate the order confirmation page in UHC site$")
	public void the_user_fills_the_Enrollment_guide_plan_form_and_validate_the_order_confirmation_page_in_UHC_site(DataTable attributes) throws Throwable {
		if (!MRScenario.environment.equalsIgnoreCase("offline")) {
			RequestMailedInformationUHC requestmailedinformationUHC = (RequestMailedInformationUHC) getLoginScenario()
					.getBean(PageConstants.REQUEST_MAILED_INFORMATION_UHC);
			List<DataTableRow> givenAttributesRow = attributes.getGherkinRows();
			Map<String, String> givenAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < givenAttributesRow.size(); i++) {

				givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
						givenAttributesRow.get(i).getCells().get(1));
			}
			boolean isFormSubmitted = requestmailedinformationUHC.submitAgentAppointmentUHC(givenAttributesMap);
			if (isFormSubmitted) {
				System.out.println("Successfully submitted the Appointment form");
				Assert.assertTrue(true);
			} else {
				Assert.fail("Error submitting the form or loading the Confirmation page");
			}
		} else {
			System.out.println("Skipping the submit functionality in Offline-Prod environment");
		}
	}
	
	@Then("^user validates the breadcrumb title on the request appointment page on the UHC site$")
	public void user_validates_the_breadcrumb_title_on_the_request_appointment_page_on_the_UHC_site() throws Throwable {
		RequestAgentAppointmentPage requestAgentAppointmentPage = (RequestAgentAppointmentPage) getLoginScenario().getBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE);
		boolean breadcrumb = requestAgentAppointmentPage.validateBreadcrumb();
		if(breadcrumb){
			Assert.assertTrue(breadcrumb);
		}else{
			Assert.fail("Error with the breadcrumb text displayed");
		}
	}
	
}
