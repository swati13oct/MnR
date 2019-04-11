package acceptancetests.acquisition.communityMeeting;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.RequestHelpAndInformationPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

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
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RequestHelpAndInformationPage requestHelpAndInformationPage = aquisitionhomepage.navigateToMaMoreHelpAndInfo();
		
		if(requestHelpAndInformationPage!=null){
			
			if(requestHelpAndInformationPage.validateUhcLink()){
				Assert.assertTrue(true);
				getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
			}else
				Assert.fail("Error in validating Uhc community link");
		}else
			Assert.fail("Error in loading the Request Help and Info Page");
	}

	@When("^the user navigates to community meeting page on UHC site and validates$")
	public void navigateToAattendCommunity()
	{
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
	
				if(requestHelpAndInformationPage.landingOnCommunityPage())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in navigating to the Uhc community page");
				
		
	}
}