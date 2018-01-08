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
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;

/**
* @author sarora29
* 
 */

public class RegistrationDashboardCreateAccountErrorsStepDefinition {

                @Autowired
                MRScenario loginScenario;

                public MRScenario getLoginScenario() {
                                return loginScenario;
                }
                
                @And("^click on confirm registration$")
                public void clickonconfirmregistration() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.scroll();
                                registrationInformationPage.getAccountConfirmation().click();

                }

                @Then("^error message for blank username field appears$")
                public void usernameblankerrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                
                                
                                registrationInformationPage.getblankusernameError().isDisplayed();
                                Thread.sleep(2000);
                                Assert.assertTrue(registrationInformationPage.getblankusernameError().getText().contains("username"));

                }
                
                @Then("^error message for incorrect username field appears$")
                public void usernameincorrecterrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                
                                
                                registrationInformationPage.getincorrectusernameError().isDisplayed();
                                Thread.sleep(2000);
                                Assert.assertTrue(registrationInformationPage.getincorrectusernameError().getText().contains("Username"));

                }
                
                
                @Then("^error message for username not unique appears$")
                public void usernamenotuniqueerrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                
                                registrationInformationPage.getincorrectusernameError().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getincorrectusernameError().getText().contains("Username"));

                }
                
                @Then("^error message for blank password field appears$")
                public void passwordblankerrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                
                                registrationInformationPage.getblankpasswordError().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getblankpasswordError().getText().contains("password"));
                }
                
                @Then("^error message for incorrect password field appears$")
                public void passwordincorrecterrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                
                                registrationInformationPage.getincorrectpasswordError().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getincorrectpasswordError().getText().contains("Password"));
                }
                
                
                @Then("^error message for confirm password field appears$")
                public void confirmpassworderrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                
                                registrationInformationPage.getconfirmpassworderrormessage().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getconfirmpassworderrormessage().getText().contains("Your password and password confirmation"));
                }
                
                @Then("^error message for confirm email field appears$")
                public void confirmemailerrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                
                                registrationInformationPage.getconfirmEmailError().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getconfirmEmailError().getText().contains("Your email confirmation and email address"));

                }
                
                @Then("^error message for email field appears$")
                public void emailerrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                
                                registrationInformationPage.getemailerrormessage().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getemailerrormessage().getText().contains("Enter your email address like this:"));

                }

}
