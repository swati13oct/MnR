package acceptancetests.dashboard.registration;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;

import pages.dashboard.acquisition.RegistrationInformationPage;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;

/**
 * @author akuma103
 * 
 */

public class RegistrationDashboardCreateAccountErrorsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@And("^click on confirm registration$")
	public void clickonconfirmregistration() {
	  	// navigate to registration page
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getAccountConfirmation().click();

	}

	@Then("^error message for blank and incorrect username field appears$")
	public void usernameblankerrormessage() throws InterruptedException {
	  	// navigate to registration page
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		Thread.sleep(1000);
		registrationInformationPage.getincorrectusernameError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getincorrectusernameError().getText().contains("Username"));

	}
	
	
	@Then("^error message for username not unique appears$")
	public void usernamenotuniqueerrormessage() {
	  	// navigate to registration page
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getincorrectusernameError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getincorrectusernameError().getText().contains("Username"));

	}
	
	@Then("^error message for blank password field appears$")
	public void passwordblankerrormessage() {
	  	// navigate to registration page
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getincorrectpasswordError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getincorrectpasswordError().getText().contains("Password"));
	}
	
	@Then("^error message for incorrect password field appears$")
	public void passwordincorrecterrormessage() {
	  	// navigate to registration page
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getincorrectpasswordError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getincorrectpasswordError().getText().contains("Password"));
	}
	
	
	@Then("^error message for confirm password field appears$")
	public void confirmpassworderrormessage() {
	  	// navigate to registration page
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getconfirmpassworderrormessage().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getconfirmpassworderrormessage().getText().contains("Your password and password confirmation"));
	}
	
	@Then("^error message for confirm email field appears$")
	public void confirmemailerrormessage() {
	  	// navigate to registration page
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getconfirmEmailError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getconfirmEmailError().getText().contains("Enter your email address like this"));

	}
	
	@Then("^error message for email field appears$")
	public void emailerrormessage() {
	  	// navigate to registration page
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getemailerrormessage().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getemailerrormessage().getText().contains("email and email confirmation"));

	}

}