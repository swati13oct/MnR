package acceptancetests.acquisition.communityMeeting;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.When;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.RequestHelpAndInformationPage;

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
		
		if(requestHelpAndInformationPage!=null && requestHelpAndInformationPage.validateHelpandInfoPage()){
			
				if(requestHelpAndInformationPage.validateUhcLink()){
					getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
					Assert.assertTrue(true);
				}else
					Assert.fail("Error in navigating to the Uhc community page");
		}else
			Assert.fail("Loading error for Request More Help and Info Page: null exception");
	}	
	
	@When("^the user navigates to community meeting page on AARP site and validates$")
	public void navigateToAattendCommunity()
	{
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
	
				if(requestHelpAndInformationPage.landingOnCommunityPage())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in navigating to the Uhc community page");
		
	}
	@When("^the user validates elements on the page$")
	public void validate_elements(){
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
		if(requestHelpAndInformationPage.validatelementsonCommunitymeeting());
		
		
	}
}