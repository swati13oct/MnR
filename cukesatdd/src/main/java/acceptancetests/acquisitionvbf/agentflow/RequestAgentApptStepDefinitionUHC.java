package acceptancetests.acquisitionvbf.agentflow;

import gherkin.formatter.model.DataTableRow;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.RequestAgentAppointmentPage;
import pages.acquisition.bluelayer.RequestHelpAndInformationPage;
import acceptancetests.acquisitionvbf.common.CommonStepDefinition;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

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
		RequestAgentAppointmentPage requestAgentAppointmentPage = requestHelpAndInformationPage.nagiateToAgentAppointmentRequest();
		if(requestAgentAppointmentPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE, requestAgentAppointmentPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in loading requestAgentAppointmentPage");
		}
		
	}
	
}
