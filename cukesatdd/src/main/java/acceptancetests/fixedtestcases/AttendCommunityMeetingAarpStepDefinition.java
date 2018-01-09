/**
 * 
 */
package acceptancetests.fixedtestcases;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class AttendCommunityMeetingAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the AARP acquisition site home page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage acquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		if(acquisitionhomepage!=null){
			if(acquisitionhomepage.validateAllElementsOnPage())
				getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
						acquisitionhomepage);
			else
				Assert.fail("Page Loading error: not able to validate the elements on the page");
		}
	}
	
	@When("^the user navigates to request more help and information page in AARP site and validates$")
	public void request_more_help_information()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RequestHelpAndInformationPage requestHelpAndInformationPage = aquisitionhomepage.navigateToMaMoreHelpAndInfo();
		
		if(requestHelpAndInformationPage!=null){
			if(requestHelpAndInformationPage.validateHelpandInfoPage()){
				getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
				if(requestHelpAndInformationPage.validateUhcLink())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating the Uhc community link");
			}else
				Assert.fail("Page Loading Error: not able to validate the elements on the page");
		}else
			Assert.fail("Page Loading error: null exception");
	}	
	
	
	

}
