package acceptancetests.mymedica;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.mymedica.AboutUsPage;
import pages.mymedica.ContactUsPage;
import pages.mymedica.SignInPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;

public class MyMedicaLoginStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the My MEDICA site landing page$")
	public void landing_page_medica_site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		SignInPage myMedicaSignInPage = new SignInPage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.MYMEDICA_SIGN_IN_PAGE,
				myMedicaSignInPage);
	}

	@When("^the user navigate to my medica About Us Page$")
	public void about_us_page() {
		SignInPage myMedicaSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYMEDICA_SIGN_IN_PAGE);

		AboutUsPage medicaAboutUsPage = myMedicaSignInPage.navigateToAboutUs();
		getLoginScenario().saveBean(PageConstants.MYMEDICA_ABOUT_US_PAGE,
				medicaAboutUsPage);

	}

	@And("^the user navigate to my medica Contact Us Page$")
	public void contact_us_page() {

		AboutUsPage medicaAboutUsPage = (AboutUsPage) getLoginScenario()
				.getBean(PageConstants.MYMEDICA_ABOUT_US_PAGE);

		ContactUsPage medicaContactUsPage = medicaAboutUsPage
				.navigateToContactUs();

		getLoginScenario().saveBean(PageConstants.MYMEDICA_CONTACT_US_PAGE,
				medicaContactUsPage);

	}
	
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}
}
