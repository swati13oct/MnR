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

public class RegistrationDashboardStepDefinition {

                @Autowired
                MRScenario loginScenario;

                public MRScenario getLoginScenario() {
                                return loginScenario;
                }

                @Given("^the member is on registration page of new portal part of redesign$")
                public void navigateToRegistrationRedesignPage() {
                                // navigate to Registration page
                                WebDriver wd = getLoginScenario().getWebDriver();
                                getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

                                // create registration context
                                RegistrationInformationPage registrationInformationPage = new RegistrationInformationPage(
                                                                wd);
                                getLoginScenario().saveBean(
                                                                PageConstants.REGISTRATION_INFORMATION_PAGE,
                                                                registrationInformationPage);

                }

                @When("^the member enter the member ID into Member ID field$")
                public void enterMemberID(DataTable givenAttributes) {
                                // get test variables
                                List<DataTableRow> memberAttributesRow = givenAttributes
                                                                .getGherkinRows();
                                Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                .get(0), memberAttributesRow.get(i).getCells().get(1));
                                }

                                // get member ID
                                String memberId = memberAttributesMap.get("Plan Member ID");
                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                try {
                                                Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                                registrationInformationPage.enterMemberID(memberId);
                }

                @When("^member enter date of birth in the date of birth dropdown$")
                public void enterDate(DataTable givenAttributes) throws InterruptedException {
                                // get test variables
                                List<DataTableRow> memberAttributesRow = givenAttributes
                                                                .getGherkinRows();
                                Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                .get(0), memberAttributesRow.get(i).getCells().get(1));
                                }

                                // get date of birth
                                String dateOfBirth = memberAttributesMap.get("Date of birth");
                                String[] splitDate = dateOfBirth.split("-");
                                String month = splitDate[0];
                                String day = splitDate[1];
                                String year = splitDate[2];

                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                try {
                                                Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                     
                     
                                registrationInformationPage.getEnterMonth().click();
                                registrationInformationPage.enterMonth(month);
                                Thread.sleep(1000);
                                registrationInformationPage.clickMonthresults();
                                
                                registrationInformationPage.getEnterDay().click();
                                registrationInformationPage.enterMonth(day);
                                Thread.sleep(1000);
                                registrationInformationPage.clickDayResults();
                                
                                registrationInformationPage.getEnterYear().click();
                                registrationInformationPage.enterMonth(year);
                                Thread.sleep(1000);
                                registrationInformationPage.clickYearResults();
                                
                }

                @When("^member click Next$")
                public void clickNext() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.clickNext();
                                Thread.sleep(2000);

                                try {
                                                Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                }

                @Then("^member will be navigated to registration plan information page$")
                public void RegistrationPlanInformation() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                // Assert.assertTrue(registrationInformationPage.currentUrl().contains("memberRegistration-Step2"));
                                registrationInformationPage.getStepTwoText().isDisplayed();
                }

                @Then("^Verify correct plan name is displayed$")
                public void verifyRegistrationPlanInformation(DataTable givenAttributes) throws InterruptedException {
                                // get test variables
                                List<DataTableRow> memberAttributesRow = givenAttributes
                                                                .getGherkinRows();
                                Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                .get(0), memberAttributesRow.get(i).getCells().get(1));
                                }

                                // get plan name
                                String expectedPlanName = memberAttributesMap.get("Plan name");
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                try {
                                                Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                                Thread.sleep(1000);
                                String actualPlanName = registrationInformationPage.getPlanName().getText();
                                System.out.println(actualPlanName);
                                Assert.assertEquals(expectedPlanName, actualPlanName);
                }

                @And("^correct member ID value is displayed$")
                public void correctMemberIDValueisdisplayed(DataTable givenAttributes) {
                                // get test variables
                                List<DataTableRow> memberAttributesRow = givenAttributes
                                                                .getGherkinRows();
                                Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                .get(0), memberAttributesRow.get(i).getCells().get(1));
                                }

                                // get expected member ID
                                String expectedmemberId = memberAttributesMap.get("Plan Member ID");
                                // System.out.println("expected member id is" +expectedmemberId);
                                // get actual member id from portal
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                String actualmemberId = registrationInformationPage.getMemberNumber()
                                                                .getText();
                                // System.out.println("actual member id is" +actualmemberId);
                                Assert.assertEquals(expectedmemberId, actualmemberId);
                }

                @And("^correct Member name value is displayed$")
                public void correctMemberNameValueisdisplayed(DataTable givenAttributes) {
                                // get test variables
                                List<DataTableRow> memberAttributesRow = givenAttributes
                                                                .getGherkinRows();
                                Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                .get(0), memberAttributesRow.get(i).getCells().get(1));
                                }

                                // get expected member name
                                String expectedmembername = memberAttributesMap.get("Member name");
                                // System.out.println("expected member name is" +expectedmembername);
                                // get actual member name from portal
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                String actualmembername = registrationInformationPage.getMemberName()
                                                                .getText();
                                // System.out.println("actual member id is" +actualmembername);
                                Assert.assertEquals(expectedmembername, actualmembername);
                }

                @And("^correct Member date of birth value is displayed$")
                public void correctMemberDatePfBirthValueisdisplayed(
                                                DataTable givenAttributes) {
                                // get test variables
                                List<DataTableRow> memberAttributesRow = givenAttributes
                                                                .getGherkinRows();
                                Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                .get(0), memberAttributesRow.get(i).getCells().get(1));
                                }

                                // get date of birth
                                String dateOfBirth = memberAttributesMap.get("Date of birth");
                                String[] splitDate = dateOfBirth.split("-");
                                String month = splitDate[0];
                                String day = splitDate[1];
                                String year = splitDate[2];
                                String expectedformattedDateOfBirth = month + "/" + day + "/" + year;
                                // System.out.println("expected member dob is"
                                // +expectedformattedDateOfBirth);

                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);

                                String actualDateOfBirth = registrationInformationPage.getPMemberDob()
                                                                .getText();
                                // System.out.println("actual member dob is" +actualDateOfBirth);
                                Assert.assertEquals(expectedformattedDateOfBirth, actualDateOfBirth);

                }

                @And("^Previous button is displayed$")
                public void previousButtonIsDisplayed() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(1000);
                                registrationInformationPage.getPreviousButton().isDisplayed();
                }

                @And("^Next button is displayed$")
                public void nextButtonIsDisplayed() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.getNextButton().isDisplayed();

                }

                @When("^member clicks on previous button$")
                public void member_clicks_on_previous_button() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.clickPreviousButtuon();

                }

                @When("^member clicks on next button$")
                public void member_clicks_on_next_button() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.clickNext();
                                Thread.sleep(5000);
                }

                @Then("^the member navigate to the create account page$")
                public void navigateToCreateAccountPage() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                try {
                                                Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }

                                registrationInformationPage.getStepThreeText().isDisplayed();

                }

                @Then("^Member ID and Date of birth is prepopulated with previously entered values.$")
                public void Member_ID_and_Date_of_birth_is_prepopulated_with_previously_entered_values(
                                                DataTable givenAttributes) {
                                // get test variables
                                List<DataTableRow> memberAttributesRow = givenAttributes
                                                                .getGherkinRows();
                                Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                .get(0), memberAttributesRow.get(i).getCells().get(1));
                                }
                                // get expected member id
                                String expectedmemberid = memberAttributesMap.get("Plan Member ID");
                                // get expected member dob
                                String expectedmemberdob = memberAttributesMap.get("Date of birth");
                                // System.out.println("expected member name is" +expectedmemberid);
                                // System.out.println("expected member dob is" +expectedmemberdob);

                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);

                                try {
                                                Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }

                                // get actual member id
                                String actualmemberid = registrationInformationPage.getMemberID()
                                                                .getAttribute("value");
                                // System.out.println("actual member id is" +actualmemberid);
                                // get actual member dob month
                                String actualmemberdobmm = registrationInformationPage.getEnterMonth()
                                                                .getAttribute("value");
                                // System.out.println("actual member dob month is" +actualmemberdobmm);

                                // get actual member dob day
                                String actualmemberdobday = registrationInformationPage.getEnterDay()
                                                                .getAttribute("value");
                                // System.out.println("actual member dob day is" +actualmemberdobday);

                                // get actual member dob year
                                String actualmemberdobyear = registrationInformationPage.getEnterYear()
                                                                .getAttribute("value");
                                // System.out.println("actual member dob year is" +actualmemberdobyear);

                                String memberDateOfBirth = actualmemberdobmm + "-" + actualmemberdobday
                                                                + "-" + actualmemberdobyear;
                                // System.out.println("actual memberDateOfBirth is" +memberDateOfBirth);
                                Assert.assertEquals(expectedmemberdob, memberDateOfBirth);

                }

                @Then("^the member navigate to additional information section$")
                public void VerifyAdditionInformtionSeaction() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.getAdditionalInfoHeader().isEnabled();
                }

                @Then("^member enter additional information$")
                public void enterAdditionalInformation(DataTable givenAttributes) {
                                // get test variables
                                List<DataTableRow> memberAttributesRow = givenAttributes
                                                                .getGherkinRows();
                                Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                .get(0), memberAttributesRow.get(i).getCells().get(1));
                                }
                                // get member ID
                                String zipCode = memberAttributesMap.get("Zip Code");
                                String fName = memberAttributesMap.get("First Name");
                                String lName = memberAttributesMap.get("Last Name");
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.enterZip(zipCode);
                                registrationInformationPage.enterFirstName(fName);
                                registrationInformationPage.enterLastName(lName);

                }

                @Then("^the member validate existing member error message$")
                public void existingMemberErrorMessage() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.getExistingMemberError().isDisplayed();
                                Assert.assertTrue(registrationInformationPage.getExistingMemberError()
                                                                .toString().contains("existing"));
                }

                @Then("^the member validate inactive or terminated error message$")
                public void inactiveTerminatedErrorMessage() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(5000);
                                registrationInformationPage.getInactiveTerminatedError().isDisplayed();
                                Assert.assertTrue(registrationInformationPage
                                                                .getInactiveTerminatedError().toString().contains("inactive"));
                }

                @Then("^the member validate future effective error message$")
                public void futureEffectiveErrorMessage() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(2000);
                                registrationInformationPage.getFutureEffectiveError().isDisplayed();
                                Assert.assertTrue(registrationInformationPage.getFutureEffectiveError()
                                                                .toString().contains("future"));

                }

                @Then("^the member validate member not found error message$")
                public void memberNotFoundErrorMessage() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.getmemberNotFoundError().isDisplayed();
                                Assert.assertTrue(registrationInformationPage.getmemberNotFoundError()
                                                                .toString().contains("Not_Found"));
                }

                @Then("^the member navigate to the Additional Plans section is displayed on Plan Information page$")
                public void VerifyAdditionPlanInformtionSeaction() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.getAdditionalPlanInfoHeader().isDisplayed();

                }

                @Then("the member validates pffs member error message$")
                public void pffsMemberErrorMessage() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.getpffsError().isDisplayed();
                                Assert.assertTrue(registrationInformationPage.getpffsError().toString().contains("errorPffsMember"));

                }
                
                
                @And("The member land on create account enters the valid data to create account$")
                public void enterCreateAccountData(DataTable givenAttributes) {
                                
                                
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                List<DataTableRow> memberAttributesRow = givenAttributes
                                                                .getGherkinRows();
                                Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                .get(0), memberAttributesRow.get(i).getCells().get(1));
                                }
                                
                                
                                String userName = memberAttributesMap.get("CREATE_ACCOUNT_USER_NAME");
                                String password = memberAttributesMap.get("CREATE_ACCOUNT_PASSWORD");
                                String confirmPassword = memberAttributesMap.get("CREATE_ACCOUNT_CONFIRM_PASSWORD");
                                String email = memberAttributesMap.get("CREATE_ACCOUNT_EMAIL");
                                String confirmEmail = memberAttributesMap.get("CREATE_ACCOUNT_CONFIRM_EMAIL");
                                registrationInformationPage.waitForCreatePageAccountPage();
                                registrationInformationPage.enterUserNameToCreateAccount(userName);
                                registrationInformationPage.enterPasswordToCreateAccount(password);
                                registrationInformationPage.enterConfirmPasswordToCreateAccount(confirmPassword);
                                registrationInformationPage.enterEmailToCreateAccount(email);
                                registrationInformationPage.enterConfirmEmailToCreateAccount(confirmEmail);
                }
                
                /*           @And("^click in confirm registration and account confirmation screen appears$")
                                public void getAccountConfirmationScreen(){
                                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
                                                                                .getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                                registrationInformationPage.clickNext();
                                                try {
                                                                Thread.sleep(5000);
                                                } catch (InterruptedException e) {
                                                                // TODO Auto-generated catch block
                                                                e.printStackTrace();
                                                }
                                registrationInformationPage.getAccountConfirmation().click();
                                                
                                }*/

}
