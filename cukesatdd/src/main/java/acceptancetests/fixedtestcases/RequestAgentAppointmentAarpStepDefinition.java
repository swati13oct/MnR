/**
 * 
 */
package acceptancetests.fixedtestcases;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AgentAppointmentConfirmationPage;
import pages.acquisition.ulayer.RequestAgentAppointmentPage;
import pages.acquisition.ulayer.RequestHelpAndInformationPage;
import acceptancetests.agentappointment.data.RequestAgentAppointmentConstants;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;

/**
 * @author pjaising
 *
 */
public class RequestAgentAppointmentAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the AARP acquisition site landing page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@When("^the user navigates to request more help and information in AARP site$")
	public void request_more_help_information()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RequestHelpAndInformationPage requestHelpAndInformationPage = aquisitionhomepage.navigateToMaMoreHelpAndInfo();
		
		if(requestHelpAndInformationPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
			if(requestHelpAndInformationPage.validateHelpandInfoPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the Request Help and Info Page");
		}else
			Assert.fail("Error in loading the Request Help and Info Page");
	}
	@And("^the user navigates to request appointment with an agent in AARP site$")
	public void request_appointment()
	{
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
		RequestAgentAppointmentPage requestAgentAppointmentPage = requestHelpAndInformationPage.nagiateToAgentAppointmentRequest();
		if(requestAgentAppointmentPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE, requestAgentAppointmentPage);
			if(requestAgentAppointmentPage.validateRequestApptPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the requestAgentAppointmentPage");
		}
		else{
			Assert.fail("Error in loading requestAgentAppointmentPage");
		}
		
	}
	
	@And("^the user provides below personal details to request an appointment with an agent in AARP site and validates confirmation page$")
	public void enter_personal_details(DataTable userAttributes)
	{
		/* Reading the given attribute from feature file */
		List<DataTableRow> userAttributesRow = userAttributes
				.getGherkinRows();
		Map<String, String> userAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < userAttributesRow.size(); i++) {

			userAttributesMap.put(userAttributesRow.get(i).getCells()
					.get(0), userAttributesRow.get(i).getCells().get(1));
		}
		
		RequestAgentAppointmentPage requestAgentAppointmentPage = (RequestAgentAppointmentPage) getLoginScenario().getBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE);
		AgentAppointmentConfirmationPage agentAppointmentConfirmationPage = requestAgentAppointmentPage.requestAgentAppointment(userAttributesMap);
		
		if(agentAppointmentConfirmationPage!=null){
				Assert.assertTrue(true);
		}else
			Assert.fail("Error in loading the Confirmation page");
		
	}
	

}
