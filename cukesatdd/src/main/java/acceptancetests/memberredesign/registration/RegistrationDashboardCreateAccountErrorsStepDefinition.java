package acceptancetests.memberredesign.registration;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import pages.dashboard_deprecated.acquisition.RegistrationInformationPage;

/**
 * @Functionality : Errors validation on Create Account page
 */

public class RegistrationDashboardCreateAccountErrorsStepDefinition {

                @Autowired
                MRScenario loginScenario;

                public MRScenario getLoginScenario() {
                                return loginScenario;
                }
                /**
                 * @toDo : user click the confirm registration button
                 */
                @And("^click on confirm registration$")
                public void clickonconfirmregistration() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.scroll();
                                registrationInformationPage.getAccountConfirmation().click();

                }
                /**
                 * @toDo : to verify error message for blank user name field
                 */
                @Then("^error message for blank username field appears$")
                public void usernameblankerrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                
                                Thread.sleep(2000);
                                registrationInformationPage.scrollUp();
                                Thread.sleep(2000);
                                registrationInformationPage.getblankusernameError().isDisplayed();
                                Thread.sleep(2000);
                                Assert.assertTrue(registrationInformationPage.getblankusernameError().getText().contains("username"));

                }
                /**
                 * @toDo : to verify error message for incorrect user name
                 */
                @Then("^error message for incorrect username field appears$")
                public void usernameincorrecterrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                
                                Thread.sleep(3000);
                                registrationInformationPage.scrollUp();
                                Thread.sleep(3000);
                                registrationInformationPage.getincorrectusernameError().isDisplayed();
                                Thread.sleep(3000);
                                Assert.assertTrue(registrationInformationPage.getincorrectusernameError().getText().contains("Username"));

                }
                
                /**
                 * @toDo : to verify error message for not unique user name
                 */
                @Then("^error message for username not unique appears$")
                public void usernamenotuniqueerrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(2000);
                                registrationInformationPage.scrollUp();
                                Thread.sleep(2000);
                                registrationInformationPage.getincorrectusernameError().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getincorrectusernameError().getText().contains("Username"));

                }
                /**
                 * @toDo : to verify error message for blank password field
                 */
                @Then("^error message for blank password field appears$")
                public void passwordblankerrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(2000);
                                registrationInformationPage.getblankpasswordError().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getblankpasswordError().getText().contains("password"));
                }
                /**
                 * @toDo : to verify error message for incorrect password
                 */
                @Then("^error message for incorrect password field appears$")
                public void passwordincorrecterrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(2000);
                                registrationInformationPage.getincorrectpasswordError().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getincorrectpasswordError().getText().contains("Password"));
                }
                
                /**
                 * @toDo : to verify error message for confirm password field
                 */
                @Then("^error message for confirm password field appears$")
                public void confirmpassworderrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(2000);
                                registrationInformationPage.getconfirmpassworderrormessage().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getconfirmpassworderrormessage().getText().contains("Your password and password confirmation"));
                }
                /**
                 * @toDo : to verify error message for confirm email address field
                 */
                @Then("^error message for confirm email field appears$")
                public void confirmemailerrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(2000);
                                registrationInformationPage.getconfirmEmailError().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getconfirmEmailError().getText().contains("Your email confirmation and email address"));

                }
                /**
                 * @toDo : to verify error message for blank email field
                 */
                @Then("^error message for email field appears$")
                public void emailerrormessage() throws InterruptedException {
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(2000);
                                registrationInformationPage.getemailerrormessage().isDisplayed();
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getemailerrormessage().getText().contains("Enter your email address like this:"));

                }

}
