package acceptancetests.mobile.login.mymedica;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.mobile.member.mymedica.AboutUsPage;
import pages.mobile.member.mymedica.ContactUsPage;
import pages.mobile.member.mymedica.SignInPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;

public class LoginMyMedicaStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the My MEDICA mobile site landing page$")
	public void landing_page_medica_site() {
		WebDriver wd = getLoginScenario().getMobileWebDriver();

		SignInPage myMedicaSignInPage = new SignInPage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.MYMEDICA_SIGN_IN_PAGE,
				myMedicaSignInPage);
	}

	@When("^the user navigate to my medica mobile site About Us Page$")
	public void about_us_page() {
		SignInPage myMedicaSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYMEDICA_SIGN_IN_PAGE);

		AboutUsPage medicaAboutUsPage = myMedicaSignInPage.navigateToAboutUs();
		getLoginScenario().saveBean(PageConstants.MYMEDICA_ABOUT_US_PAGE,
				medicaAboutUsPage);

	}

	@And("^the user navigate to my medica mobile site Contact Us Page$")
	public void contact_us_page() {

		AboutUsPage medicaAboutUsPage = (AboutUsPage) getLoginScenario()
				.getBean(PageConstants.MYMEDICA_ABOUT_US_PAGE);

		ContactUsPage medicaContactUsPage = medicaAboutUsPage
				.navigateToContactUs();

		getLoginScenario().saveBean(PageConstants.MYMEDICA_CONTACT_US_PAGE,
				medicaContactUsPage);

	}
	
	@And("^the user navigate to my medica mobile site Access your account Page$")
	public void access_your_account_page() {

	ContactUsPage myMedicaContactUsPage = (ContactUsPage) getLoginScenario()
	.getBean(PageConstants.MYMEDICA_CONTACT_US_PAGE);

	SignInPage myMedicaSignInPage = myMedicaContactUsPage.navigateToSignIn();

	getLoginScenario().saveBean(PageConstants.MYMEDICA_SIGN_IN_PAGE,
	myMedicaSignInPage);
	}
	
	
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		//wd.quit();
		getLoginScenario().flushBeans();
	}
}
