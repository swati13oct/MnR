package acceptancetests.acquisitionvbf.agentflow;

import gherkin.formatter.model.DataTableRow;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.RequestHelpAndInformationPage;
import acceptancetests.acquisitionvbf.common.CommonStepDefinition;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.When;

/**
 *Functionality:Attend Community Meeting
 */
public class AttendCommunityMeetingStepDefinitionAARP {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo: user navigates to request more help and information page
	 */
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