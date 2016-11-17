package acceptancetests.mobile.login.mypcp;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.mobile.member.mypcp.AboutUsPage;
import pages.mobile.member.mypcp.ContactUsPage;
import pages.mobile.member.mypcp.PasswordAssistancePage;
import pages.mobile.member.mypcp.RegistrationHomePage;
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
	
	@Given("^the user is on registration page of My PCP mobile site1$")
	public void registration_landing_page() {
		/*WebDriver wd = getLoginScenario().getMobileWebDriver();
		wd.manage().window().maximize();*/

		SignInPage myPcpSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_SIGN_IN_PAGE);
		RegistrationHomePage registrationHomePage = myPcpSignInPage.navigateToRegistrationHomePage();

		//getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE, registrationHomePage);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE, registrationHomePage);
	}
	
	@Given("^the user clicks on back button from  My PCP mobile site registration page$")
	public void go_back_landing_page() {
		/*WebDriver wd = getLoginScenario().getMobileWebDriver();
		wd.manage().window().maximize();*/
		SignInPage myPcpSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_SIGN_IN_PAGE);
		SignInPage loginPage = myPcpSignInPage.navigateToLoginPage();
		
		getLoginScenario().saveBean(PageConstants.MYPCP_SIGN_IN_PAGE,
				loginPage);
		//PasswordAssistancePage passwordAssistancePage = myPcpSignInPage.navigateToPasswordAssistancePage();

		//getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	//	getLoginScenario().saveBean(PageConstants.PASSWORD_ASSISTANCE_PAGE, passwordAssistancePage);
	//	getLoginScenario().saveBean(PageConstants.PASSWORD_ASSISTANCE_PAGE, passwordAssistancePage);
	}
	
	
	
	@Given("^the user is on password assistance page of My PCP mobile site1$")
	public void password_assistance_landing_page() {
		/*WebDriver wd = getLoginScenario().getMobileWebDriver();
		wd.manage().window().maximize();*/
		SignInPage myPcpSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_SIGN_IN_PAGE);
		PasswordAssistancePage passwordAssistancePage = myPcpSignInPage.navigateToPasswordAssistancePage();

		//getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.PASSWORD_ASSISTANCE_PAGE, passwordAssistancePage);
		getLoginScenario().saveBean(PageConstants.PASSWORD_ASSISTANCE_PAGE, passwordAssistancePage);
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
	




}
