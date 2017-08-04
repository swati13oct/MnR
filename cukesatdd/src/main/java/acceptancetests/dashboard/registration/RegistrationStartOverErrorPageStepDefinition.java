package acceptancetests.dashboard.registration;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.dashboard.acquisition.RegistrationInformationPage;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;

public class RegistrationStartOverErrorPageStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}	
	
	@When("^member click on start over link on  existing member page$")
	public void clickStartOverLinkExistingMemberPage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.clickExistingStartOver();

	}

	@Then("^the member navigate to the personal Information page$")
	public void navigateToRegistrationPersonalInformationPage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getStepOneText().isDisplayed();
		

	}

	@Then("^no previously information is retained$")
	public void previousInformationNotRetained() throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		Assert.assertTrue(registrationInformationPage.getMemberID().getAttribute("value").isEmpty());
		Assert.assertTrue(registrationInformationPage.getEnterDay().getAttribute("value").isEmpty());
		Assert.assertTrue(registrationInformationPage.getEnterMonth().getAttribute("value").isEmpty());
		Assert.assertTrue(registrationInformationPage.getEnterYear().getAttribute("value").isEmpty());

	}

	@When("^member click on username and password help link on existing member page$")
	public void clickUsernameAndPasswordHelpLink() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.clickSignInWithExistingLink();
	}

	@Then("^the member navigate to the username and password help page$")
	public void navigateToUsernameAndPasswordHelpPage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	}

	@When("^member click on Sign in link on existing member page$")
	public void clickSignInLink() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.clickUserNameAndPasswordLink();
	}

	@Then("^the member navigate to the Sign in page$")
	public void navigateToSignInPage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	}
	
	@When("^member click on start over link on future effective page$")
	public void clickStartOverLinkFutureEffectivePage() throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		Thread.sleep(1000);
		registrationInformationPage.clickFutureStartOver();

	}
	
	@When("^member click on start over link on inactive or terminated error page$")
	public void clickStartOverLinkInactiveTerminatedPage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.clickInactiveStartOver();
	}
	
	@When("^member click on start over link on member not found error page$")
	public void clickStartOverLinkMemberNotFoundPage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.clickNotFoundStartOver();
	}

	
}
