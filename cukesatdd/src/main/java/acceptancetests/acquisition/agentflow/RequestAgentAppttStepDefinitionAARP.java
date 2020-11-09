package acceptancetests.acquisition.agentflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.RequestAgentAppointmentPage;
import pages.acquisition.ulayer.RequestHelpAndInformationPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
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
	
	
	@Then("^the user fills the form out and submits the agent appointment application$")
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
			@Then("^the user clicks on View plan details link for each plan type and validate find agent link for all plans$")
			public void the_user_clicks_on_View_plan_details_link_for_each_plan_type_and_validate_find_agent_link_for_allplans(DataTable attributes) {
				
				VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
						.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
				
					List<String> planNameList = attributes.asList(String.class);
					//click on ma view plan
					//click on plan detail
					//click on contact agent
					//click on back to vpp
					//click on back to all plan
					//click on next plan
					boolean isContactAgentPageDisplayed = plansummaryPage.validateContactAgentPage(planNameList);
					if (isContactAgentPageDisplayed) {
						System.out.println("Successfully validated contact agent page for all plan types");
						Assert.assertTrue(true);
					} else {
						Assert.fail("Error in validating contact agent page for all plan types");
					}
			}				

			
	}
	
	
	
}
