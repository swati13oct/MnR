/**
 * 
 */
package acceptancetests.agentappointment.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AgentAppointmentConfirmationPage;
import pages.acquisition.bluelayer.RequestAgentAppointmentPage;
import pages.acquisition.bluelayer.RequestHelpAndInformationPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import acceptancetests.agentappointment.data.RequestAgentAppointmentConstants;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
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
public class RequestAgentAppointmentUhcStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the UHC medicare site landing page$")
	public void the_user_on_uhc_medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@When("^the user navigates to request more help and information in UHC site$")
	public void request_more_help_information()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RequestHelpAndInformationPage requestHelpAndInformationPage = aquisitionhomepage.navigateToMaMoreHelpAndInfo();
		
		getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
	}
	
	@And("^the user navigates to request appointment with an agent in UHC site$")
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
	
	@And("^the user provides below personal details to request an appointment with an agent in UHC site$")
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
	
	@Then("^the user validates the confirmation page in UHC site$")
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
	
	@When("^the user performs plan search using following information in UMS site$")
	public void zipcode_details_in_UMS_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.searchPlans(
				zipcode, county);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			// Get expected data
			String fileName = "vppPlanSummary";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);

			// Get actual data
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);

		}

	}
	
	@Then("^user validates plan count for all plan types on plan summary page in UMS site$")
	public void user_validates_following_benefits_ui_UMS() {
		JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
		JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
		System.out.println("planSummaryActualJson===>"
				+ planSummaryActualJson.toString());
		System.out.println("planSummaryExpectedJson===>"
				+ planSummaryExpectedJson.toString());
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@When("user views plans of the below plan type in UMS site$")
	public void user_performs_planSearch_in_UMS_site(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			// Get actual data
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);

			// Get expected data
			String fileName = null;
			if (plantype.equalsIgnoreCase("MA")
					|| plantype.equalsIgnoreCase("MAPD")) {
				fileName = "maplans";
			} else if (plantype.equalsIgnoreCase("PDP")) {
				fileName = "pdpplans";
			} else if (plantype.equalsIgnoreCase("SNP")) {
				fileName = "snpplans";
			} else {
				fileName = "msplans";
			}

			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);
		}

	}
	
	@Then("^the user validates the available plans for selected plan types in UMS site$")
	public void user_validates_available_plans_UMS() {
		JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
		JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
		System.out.println("planSummaryActualJson====>"
				+ planSummaryActualJson.toString());
		System.out.println("planSummaryExpectedJson====>"
				+ planSummaryExpectedJson.toString());
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("^the user navigates to Meet with an Agent in UHC site$")
	public void user_navigate_meet_with_an_agent_widget() {
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		RequestAgentAppointmentPage requestAgentAppointmentPage = plansummaryPage.nagiateToRequetAnAppointmentPage();
		if(requestAgentAppointmentPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_AGENT_APPOINTMENT_PAGE, requestAgentAppointmentPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in loading requestAgentAppointmentPage");
		}
	}
	
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
	}
}
