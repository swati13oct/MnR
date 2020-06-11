package acceptancetests.vbfacquisition_deprecated.agentflow;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Given;
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
	 * @toDo: user lands on the acquisition page
	 */
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