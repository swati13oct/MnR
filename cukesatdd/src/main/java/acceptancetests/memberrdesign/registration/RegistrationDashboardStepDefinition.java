package acceptancetests.memberrdesign.registration;

import gherkin.formatter.model.DataTableRow;
import javafx.scene.control.ScrollToEvent;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import pages.dashboard.member.ulayer.RallyDashboardPage;
import pages.member.bluelayer.DeregisterPage;
import pages.member.bluelayer.RegistrationInformationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
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
	public void enterMemberID(DataTable givenAttributes) throws InterruptedException {
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
		//Thread.sleep(20000);

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
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);*/
		/*registrationInformationPage.scroll();
		Thread.sleep(2000);*/
		//Thread.sleep(2000);
		registrationInformationPage.getEnterMonth().click();
		//Thread.sleep(1000);
		registrationInformationPage.enterMonth(month);
		//Thread.sleep(1000);
		registrationInformationPage.clickMonthresults();
		//Thread.sleep(2000);
		registrationInformationPage.getEnterDay().click();
		registrationInformationPage.enterMonth(day);
		//Thread.sleep(1000);
		registrationInformationPage.clickDayResults();
		//Thread.sleep(2000);
		registrationInformationPage.getEnterYear().click();
		registrationInformationPage.enterMonth(year);
		//Thread.sleep(1000);
		registrationInformationPage.clickYearResults();
		
	}

	@When("^member click Next$")
	public void clickNext() throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.scroll();
		registrationInformationPage.clickNext();

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
		registrationInformationPage.waitForPlanInformationPage();
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
		
		/*Thread.sleep(2000);
		registrationInformationPage.scroll();
		Thread.sleep(4000);*/
		registrationInformationPage.clickNext();
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
	public void inactiveTerminatedErrorMessage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getInactiveTerminatedError().isDisplayed();
		Assert.assertTrue(registrationInformationPage
				.getInactiveTerminatedError().toString().contains("inactive"));
	}

	@Then("^the member validate future effective error message$")
	public void futureEffectiveErrorMessage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
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
	public void enterCreateAccountData(DataTable givenAttributes) throws InterruptedException {
		
		
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
		getLoginScenario().saveBean(CommonConstants.ACCOUNT_USER_NAME, userName);
		registrationInformationPage.waitForCreatePageAccountPage();
		
		registrationInformationPage.enterUserNameToCreateAccount(userName);
		registrationInformationPage.enterPasswordToCreateAccount(password);
		//registrationInformationPage.scroll();
		registrationInformationPage.enterConfirmPasswordToCreateAccount(confirmPassword);
		registrationInformationPage.enterEmailToCreateAccount(email);
		registrationInformationPage.enterConfirmEmailToCreateAccount(confirmEmail);
	}
	
	@Given("^the member is on registration page of redesign portal$")
	public void RegistrationPage(DataTable givenAttributes) throws InterruptedException {
    	// init Web Driver
    	WebDriver wd = loginScenario.getWebDriver();
    	loginScenario.saveBean(CommonConstants.WEBDRIVER, wd);
    	
		// get test variables
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		// get member ID
		String userName = memberAttributesMap.get("CREATE_ACCOUNT_USER_NAME");
		


    	// deregister the user for subsequent registration
    	DeregisterPage deregisterPage = new DeregisterPage(wd);
    	deregisterPage.deregisterUser(userName);
    	Thread.sleep(5000);
    	
		// create registration context
		RegistrationInformationPage registrationInformationPage = new RegistrationInformationPage(
				wd);
		getLoginScenario().saveBean(
				PageConstants.REGISTRATION_INFORMATION_PAGE,
				registrationInformationPage);

		}

	@Then("^member lands on account confirmation page$")
	public void validateAccountConfirmationPage() throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		Thread.sleep(3000);
		registrationInformationPage.getAccConfirmationHeading().isDisplayed();
		registrationInformationPage.getAccConfirmationText().isDisplayed();
		registrationInformationPage.getPrintLink().isDisplayed();
		registrationInformationPage.getGoToMyAccountButton().isDisplayed();
	}
		
	
	@SuppressWarnings("deprecation")
	@Then("^Verify that correct information is displayed on Account Confirmation page$")
	public void VerifyAccountConfirmation_page(DataTable givenAttributes) throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		/*String expectedFirstName = memberAttributesMap.get("FIRST_NAME");
		String expectedLastName = memberAttributesMap.get("LAST_NAME");*/
		String expectedUserName = memberAttributesMap.get("CREATE_ACCOUNT_USER_NAME");
		String ExpectedEmail = memberAttributesMap.get("CREATE_ACCOUNT_EMAIL");
		
		String dateOfBirth = memberAttributesMap.get("Date of birth");
		String[] splitDate = dateOfBirth.split("-");
		String month = splitDate[0];
		String day = splitDate[1];
		String year = splitDate[2];
		String expectedDateOfBirth = month + "/" + day + "/" + year;
			
		registrationInformationPage.waitForAccountConfirmationPage();
	/*	String actualFirstName = registrationInformationPage.getMemberFirstName().getText().toString();
		String actualLastName = registrationInformationPage.getMemberLastName().getText().toString();*/
		String actualUserName = registrationInformationPage.getUserName().getText().toString();
		String actualEmail = registrationInformationPage.getEmailAddress().getText().toString();
		String actualDateOfBirth = registrationInformationPage.getMemberDoB().getText();
/*		Assert.assertEquals(expectedFirstName,actualFirstName);
		Assert.assertEquals(expectedLastName,actualLastName);*/
		Assert.assertEquals(expectedUserName,actualUserName);
		Assert.assertEquals(ExpectedEmail,actualEmail);
		Assert.assertEquals(expectedDateOfBirth,actualDateOfBirth);
		
	}
	 @And("^click on confirm registration$")
     public void clickonconfirmregistration() throws InterruptedException {
                     // navigate to registration page
                     RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                     getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                     registrationInformationPage.scroll();
                     registrationInformationPage.getAccountConfirmation().click();

     }
	 
	 @And("^User successfully navigates to RallyDasboard page$")
     public void user_navigates_to_rallydasboard_page() throws InterruptedException {
                     // navigate to registration page
                     RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                     getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                     
                     RallyDashboardPage rallyDashboard = registrationInformationPage.navigateToRallyDashboardPage();
         
         			if (rallyDashboard == null) {
         				Assert.fail("User -- "+getLoginScenario().getBean(CommonConstants.ACCOUNT_USER_NAME)+ " navigation to dashboard page failed.");
         			}
     }

}