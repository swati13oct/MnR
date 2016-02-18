/**
 * 
 */
package acceptancetests.agentappointment.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
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
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

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

	@Given("^the user is on the AARP medicare site landing page$")
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
		
		getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
	}
	
	@And("^the user navigates to request appointment with an agent in AARP site$")
	public void request_appointment()
	{
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
		RequestAgentAppointmentPage requestAgentAppointmentPage = requestHelpAndInformationPage.nagiateToAgentAppointmentRequest();
		
		getLoginScenario().saveBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE, requestAgentAppointmentPage);
	}
	
	@And("^the user provides below personal details to request an appointment with an agent in AARP site$")
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
		
		/*Get Actual Data*/
		JSONObject agentConfirmationActualJson = agentAppointmentConfirmationPage.agentConfirmationJson;
		getLoginScenario().saveBean(RequestAgentAppointmentConstants.AGENT_CONFIRMATION_ACTUAL, agentConfirmationActualJson);
		
		/*Get Expected Data*/
		JSONObject agentConfirmationExpectedJson = agentAppointmentConfirmationPage.getExpectedData();
		getLoginScenario().saveBean(RequestAgentAppointmentConstants.AGENT_CONFIRMATION_EXPECTED, agentConfirmationExpectedJson);
		
		
	}
	
	@Then("^the user validates the confirmation page in AARP site$")
	public void validate_agent_confirmation()
	{
		JSONObject agentConfirmationActualJson = (JSONObject) getLoginScenario().getBean(RequestAgentAppointmentConstants.AGENT_CONFIRMATION_ACTUAL);
		JSONObject agentConfirmationExpectedJson = (JSONObject) getLoginScenario().getBean(RequestAgentAppointmentConstants.AGENT_CONFIRMATION_EXPECTED);
		
		try {
			JSONAssert.assertEquals(agentConfirmationExpectedJson, agentConfirmationActualJson, true);
		} catch (JSONException e) {
			System.out.println("Excpetion occurred while comparing agent appointment confirmation"+e);
		}
	}
	
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
	}
}
