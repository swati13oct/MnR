package acceptancetests.mobile.login.mypcp;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.mobile.member.mypcp.AboutUsPage;
import pages.mobile.member.mypcp.ContactUsPage;
import pages.mobile.member.mypcp.SignInPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;

public class LoginMyPcpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the My PCP mobile site landing page$")
	public void landing_page_pcp_site() {
		WebDriver wd = getLoginScenario().getMobileWebDriver();
		

		SignInPage myPcpSignInPage = new SignInPage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.MYPCP_SIGN_IN_PAGE,
				myPcpSignInPage);
	}
	
	@When("^the user navigate to My PCP mobile site About Us Page$")
	public void about_us_page() {		
		SignInPage myPcpSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_SIGN_IN_PAGE);
		
		AboutUsPage pcpAboutUsPage = myPcpSignInPage
				.navigateToAboutUs();
		getLoginScenario().saveBean(PageConstants.MYPCP_ABOUT_US_PAGE,
				pcpAboutUsPage);
		
	}
	
	@And("^the user navigate to My PCP mobile site Contact Us Page$")
	public void contact_us_page() {
		
		AboutUsPage pcpAboutUsPage = (AboutUsPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_ABOUT_US_PAGE);
		
		ContactUsPage pcpContactUsPage = pcpAboutUsPage.navigateToContactUs();
		
		getLoginScenario().saveBean(PageConstants.MYPCP_CONTACT_US_PAGE,
				pcpContactUsPage);
		
	}
	
	@And("^the user navigate to My PCP mobile site Access Your Account Page$")
	public void access_your_account_page() {
		
		ContactUsPage pcpContactUsPage = (ContactUsPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_CONTACT_US_PAGE);
		
		SignInPage pcpSignInPage = pcpContactUsPage.navigateToSignIn();
		
		getLoginScenario().saveBean(PageConstants.MYPCP_SIGN_IN_PAGE,
				pcpSignInPage);
		
	}
	
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}



}
