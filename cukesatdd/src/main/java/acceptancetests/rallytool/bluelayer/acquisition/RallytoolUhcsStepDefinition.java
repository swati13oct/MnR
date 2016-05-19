package acceptancetests.rallytool.bluelayer.acquisition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.MAEnrollmentPage;
import pages.acquisition.bluelayer.MAPlanInformationAndForms;
import pages.acquisition.bluelayer.RegistrationHomePage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;

/**
 * @author naggarw2
 *
 */
public class RallytoolUhcsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	
	
	@Given("^user navigates to MA Enrollment Information Tab of Blue Layer Acquisition site$")

	public void user_navigates_MA_Enrollment_Information_Page () {
		
		WebDriver wd = getLoginScenario().getWebDriver();
		MAEnrollmentPage enrollmentpage = new MAEnrollmentPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.MA_ENROLLMENT_PAGE, enrollmentpage);
		
		
	
	
}
	
	@And("^click on the Look up my provider link on MA Enrollment Information Page and rally tool opens up$")
	
	public void user_clicks_providerlink_MAEnrollmentPage () {
		
		MAEnrollmentPage enrollmentpage= (MAEnrollmentPage)getLoginScenario().getBean(PageConstants.MA_ENROLLMENT_PAGE);
		
		Rallytool_Page rallytool = enrollmentpage.MAEnrollmentproviderclick();
		if(rallytool!= null){
			getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
					rallytool);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
		
		
	}
	
	
		
	@Given("^user navigates to MA PLAN INFORMATION AND FORMS of Blue Layer Acquisition site$")
	
	public void user_navigates_MA_PLAN_Information_and_forms_Page () {
		
		WebDriver wd = getLoginScenario().getWebDriver();
		MAPlanInformationAndForms informationandforms = new MAPlanInformationAndForms(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.MA_PLAN_INFORMATION_AND_PLANS_PAGE, informationandforms);
	
	
	}	
	
	
	
	@And("^click on the Look up my provider link on MA PLAN INFORMATION AND FORMS and rally tool opens up$")
	
	public void user_clicks_providerlink_MAPlanInformationAndPlans () {
	
		MAPlanInformationAndForms informationandforms= (MAPlanInformationAndForms)getLoginScenario().getBean(PageConstants.MA_PLAN_INFORMATION_AND_PLANS_PAGE);
	
	Rallytool_Page rallytool = informationandforms.MAPlanInformationproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
	
	}	
	
	@After
	public void tearDown() {
	       WebDriver wd = (WebDriver) getLoginScenario().getBean(
	                    CommonConstants.WEBDRIVER);
	       wd.quit();
	       getLoginScenario().flushBeans();
	}
	
	
	
	
	
}	