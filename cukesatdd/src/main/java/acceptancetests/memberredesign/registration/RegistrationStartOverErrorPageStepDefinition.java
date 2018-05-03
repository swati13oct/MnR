
package acceptancetests.memberredesign.registration;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.dashboard_deprecated.acquisition.RegistrationInformationPage;

/**
 *Functionality: Start over link validation on the registration flow
 */
public class RegistrationStartOverErrorPageStepDefinition {
                @Autowired
                MRScenario loginScenario;

                public MRScenario getLoginScenario() {
                                return loginScenario;
                }              
                /**
                 * @toDo : verifying the start over link on existing member error page
                 */
                @When("^member click on start over link on  existing member page$")
                public void clickStartOverLinkExistingMemberPage() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(5000);
                                registrationInformationPage.clickExistingStartOver();

                }
                /**
                 * @toDo : navigation to the personal information page
                 */
                @Then("^the member navigate to the personal Information page$")
                public void navigateToRegistrationPersonalInformationPage() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(5000);
                                registrationInformationPage.getStepOneText().isDisplayed();
                                

                }
                /**
                 * @toDo : to check that the previously info is not retained
                 */
                @Then("^no previously information is retained$")
                public void previousInformationNotRetained() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(5000);
                                Assert.assertTrue(registrationInformationPage.getMemberID().getText().isEmpty());
                                //Assert.assertTrue(registrationInformationPage.getMemberID().getAttribute("value").isEmpty());
                }
                /**
                 * @toDo : verifying the help link on existing member message page
                 */
                @When("^member click on username and password help link on existing member page$")
                public void clickUsernameAndPasswordHelpLink() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.clickUserNameAndPasswordLink();
                }
                /**
                 * @toDo : navigation to the username and password help page
                 */
                @Then("^the member navigate to the username and password help page$")
                public void navigateToUsernameAndPasswordHelpPage() {
                             /*   RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);*/
                }
                /**
                 * @throws InterruptedException 
                 * @toDo : verifying the sign in link on existing member error page
                 */
                @When("^member click on Sign in link on existing member page$")
                public void clickSignInLink() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                               Thread.sleep(2000);
                                registrationInformationPage.clickSignInWithExistingLink();
                }
                /**
                 * @toDo : navigation to the sign in page from existing member error page
                 */
                @Then("^the member navigate to the Sign in page$")
                public void navigateToSignInPage() {
                                /*RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);*/
                }
                /**
                 * @toDo : verifying the start over link on future effective error page
                 */
                @When("^member click on start over link on future effective page$")
                public void clickStartOverLinkFutureEffectivePage() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(5000);
                                
                                registrationInformationPage.clickFutureStartOver();
                                Thread.sleep(2000);

                }
                /**
                 * @toDo : verifying the start over link on inactive or termed error page
                 */
                @When("^member click on start over link on inactive or terminated error page$")
                public void clickStartOverLinkInactiveTerminatedPage() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(5000);
                                
                                registrationInformationPage.clickInactiveStartOver();
                                Thread.sleep(2000);
                }
                /**
                 * @toDo : verifying the start over link on member not found error page
                 */
                @When("^member click on start over link on member not found error page$")
                public void clickStartOverLinkMemberNotFoundPage() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.clickNotFoundStartOver();
                }

                
} 

