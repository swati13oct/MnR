package acceptancetests.mypcp;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.mypcp.AboutUsPage;
import pages.mypcp.ContactUsPage;
import pages.mypcp.SignInPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;

public class MyPcpLoginStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the My PCP site landing page$")
	public void landing_page_pcp_site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		SignInPage myPcpSignInPage = new SignInPage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.MYPCP_SIGN_IN_PAGE,
				myPcpSignInPage);
	}
	
	@When("^the user navigate to About Us Page$")
	public void about_us_page() {		
		SignInPage myPcpSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_SIGN_IN_PAGE);
		
		AboutUsPage pcpAboutUsPage = myPcpSignInPage
				.navigateToAboutUs();
		getLoginScenario().saveBean(PageConstants.MYPCP_ABOUT_US_PAGE,
				pcpAboutUsPage);
		
	}
	
	@And("^the user navigate to Contact Us Page$")
	public void contact_us_page() {
		
		AboutUsPage pcpAboutUsPage = (AboutUsPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_ABOUT_US_PAGE);
		
		ContactUsPage pcpContactUsPage = pcpAboutUsPage.navigateToContactUs();
		
		getLoginScenario().saveBean(PageConstants.MYPCP_CONTACT_US_PAGE,
				pcpContactUsPage);
		
	}
	
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
