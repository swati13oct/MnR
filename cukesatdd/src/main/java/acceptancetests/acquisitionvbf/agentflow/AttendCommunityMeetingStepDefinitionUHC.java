package acceptancetests.acquisitionvbf.agentflow;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.RequestHelpAndInformationPage;

/**
 *Functionality: Attend Community Meeting
 */
public class AttendCommunityMeetingStepDefinitionUHC {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	
	
	/**
	 * @toDo: user navigates to request more help and information page
	 */
	@When("^the user navigates to request more help and information page in UHC site and validates$")
	public void request_more_help_information()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstantsMnR.ACQUISITION_HOME_PAGE);
		RequestHelpAndInformationPage requestHelpAndInformationPage = aquisitionhomepage.navigateToMaMoreHelpAndInfo();
		
		if(requestHelpAndInformationPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
			if(requestHelpAndInformationPage.validateUhcLink())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the Uhc community link");
		}else
			Assert.fail("Error in loading the Request Help and Info Page");
	}

}