package acceptancetests.memberredesign.registration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import junit.framework.Assert;
import pages.dashboard_deprecated.acquisition.DeregisterPage;
import pages.dashboard_deprecated.acquisition.RegistrationInformationPage;
import pages.member_deprecated.redesign.NewLoginPage;

/**
 * Functionality: Registration flow validation
 */

@SuppressWarnings("deprecation")
public class RegistrationDashboardStepDefinition {
	
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	/**
	 * @toDo : user is on the sign in page
	 */
	@Given("^the member is on sign in page$")
	public void signInPage() {
			// init Web Driver
		    WebDriver wd = getLoginScenario().getWebDriver();
		    getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		  
		// create Sign In context
		NewLoginPage newLoginPage = new NewLoginPage(wd);
		getLoginScenario().saveBean(PageConstants.NEW_LOGIN_PAGE, newLoginPage);
			
			
	}
	
	/**
	 * @toDo : registration page navigation when clicking the register button
	 */
	@Given("^User click on the register button$")
	public void clickRegisterButton() throws InterruptedException {
		
        WebDriver wd = loginScenario.getWebDriver();
        loginScenario.saveBean(CommonConstants.WEBDRIVER, wd);
        
          
        // create Sign In context
        NewLoginPage newLoginPage = new NewLoginPage(wd);
       
        
        newLoginPage.navigateToNewDashboardUrls();
        getLoginScenario().saveBean(PageConstants.NEW_LOGIN_PAGE, newLoginPage);
		
		
		newLoginPage.navigateToRegistration();
		Thread.sleep(4000);
		RegistrationInformationPage registrationInformationPage = new RegistrationInformationPage(newLoginPage.driver);
		 getLoginScenario().saveBean(PageConstants.REGISTRATION_INFORMATION_PAGE,registrationInformationPage);
	}
	
	/**
	 * @toDo : user gives member value in the member id field
	 */
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
		Thread.sleep(3000);
		registrationInformationPage.scroll();
		Thread.sleep(2000);
		//registrationInformationPage.waitForRegistrationInformationPage();
		registrationInformationPage.enterMemberID(memberId);
	}

	/**
	 * @toDo : user selects dob from the drop down
	 */
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
		
		registrationInformationPage.scroll();
		Thread.sleep(4000);
		registrationInformationPage.getEnterMonth().click();
		registrationInformationPage.enterMonth(month);
		Thread.sleep(2000);
		registrationInformationPage.pressEnterMonth();
		Thread.sleep(2000);
		registrationInformationPage.getEnterDay().click();
		registrationInformationPage.enterDay(day);
		Thread.sleep(2000);
		registrationInformationPage.pressEnterDay();
		Thread.sleep(2000);
		registrationInformationPage.getEnterYear().click();
		registrationInformationPage.enterYear(year);
		Thread.sleep(2000);
		registrationInformationPage.pressEnterYear();
		
		
	}

	/**
	 * @toDo : user clicks next button on the registrations first step
	 */
	@When("^member click Next$")
	public void clickNext() throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.scroll();
		Thread.sleep(2000);
		registrationInformationPage.clickNext();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @toDo : navigation to the plan information page
	 */
	@Then("^member will be navigated to registration plan information page$")
	public void RegistrationPlanInformation() throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		Thread.sleep(6000);
		//Assert.assertTrue(registrationInformationPage.currentUrl().contains("memberRegistration-Step2"));
		registrationInformationPage.waitForPlanInformationPage();
		registrationInformationPage.getStepTwoText().isDisplayed();
	}

	/**
	 * @toDo : plan name validation
	 */
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
		registrationInformationPage.scroll();
		String actualPlanName = registrationInformationPage.getPlanName().getText();
		System.out.println(actualPlanName);
		Assert.assertEquals(expectedPlanName, actualPlanName);
	}

	/**
	 * @toDo : member id validation
	 */
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
		//Assert.assertEquals(expectedmemberId, actualmemberId);
		
		Assert.assertTrue(actualmemberId.contains(expectedmemberId));
	}

	/**
	 * @toDo : member name validation
	 */
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

	/**
	 * @toDo : date of birth value validation
	 */
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

	/**
	 * @toDo : previous button displays
	 */
	@And("^Previous button is displayed$")
	public void previousButtonIsDisplayed() throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		Thread.sleep(1000);
		registrationInformationPage.getPreviousButton().isDisplayed();
	}

	/**
	 * @toDo : next button displays
	 */
	@And("^Next button is displayed$")
	public void nextButtonIsDisplayed() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getNextButton().isDisplayed();

	}

	/**
	 * @toDo : user verifies by clicking the previous button
	 */
	@When("^member clicks on previous button$")
	public void member_clicks_on_previous_button() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.clickPreviousButtuon();

	}

	/**
	 * @toDo : user verifies by clicking the next button
	 */
	@When("^member clicks on next button$")
	public void member_clicks_on_next_button() throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);

		registrationInformationPage.scroll();
		Thread.sleep(4000);
		registrationInformationPage.clickNext();
	/*	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * @toDo : navigation to the create account page
	 */
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

	/**
	 * @toDo : verifies the previously entered member id and dob values
	 */
	@SuppressWarnings("deprecation")
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
		//String expectedmemberid = memberAttributesMap.get("Plan Member ID");
		// get expected member dob
		String expectedmemberdob = memberAttributesMap.get("Date of birth");
		// System.out.println("expected member name is" +expectedmemberid);
		// System.out.println("expected member dob is" +expectedmemberdob);

		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		// get actual member id
		//String actualmemberid = registrationInformationPage.getMemberID()
			//	.getAttribute("value");
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

	/**
	 * @toDo : navigation to additional information
	 */
	@Then("^the member navigate to additional information section$")
	public void VerifyAdditionInformtionSeaction() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getAdditionalInfoHeader().isEnabled();
	}

	/**
	 * @toDo : user enter additional info
	 */
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

	/**
	 * @toDo : verifies the existing member error message
	 */
	@SuppressWarnings("deprecation")
	@Then("^the member validate existing member error message$")
	public void existingMemberErrorMessage() throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		Thread.sleep(10000);
		registrationInformationPage.getExistingMemberError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getExistingMemberError()
				.toString().contains("existing"));
	}

	/**
	 * @toDo : verifies the inactive or terminated member error message
	 */
	@SuppressWarnings("deprecation")
	@Then("^the member validate inactive or terminated error message$")
	public void inactiveTerminatedErrorMessage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getInactiveTerminatedError().isDisplayed();
		Assert.assertTrue(registrationInformationPage
				.getInactiveTerminatedError().toString().contains("inactive"));
	}

	/**
	 * @toDo : verifies the future effective error message
	 */
	@SuppressWarnings("deprecation")
	@Then("^the member validate future effective error message$")
	public void futureEffectiveErrorMessage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getFutureEffectiveError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getFutureEffectiveError()
				.toString().contains("future"));

	}

	/**
	 * @toDo : verifies the member not found error message
	 */
	@SuppressWarnings("deprecation")
	@Then("^the member validate member not found error message$")
	public void memberNotFoundErrorMessage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getmemberNotFoundError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getmemberNotFoundError()
				.toString().contains("Not_Found"));
	}

	/**
	 * @toDo : Additional plan info displays - this will be an invalid scenario
	 */
	@Then("^the member navigate to the Additional Plans section is displayed on Plan Information page$")
	public void VerifyAdditionPlanInformtionSeaction() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getAdditionalPlanInfoHeader().isDisplayed();

	}

	/**
	 * @toDo : verifies the pffs member error message
	 */
	@SuppressWarnings("deprecation")
	@Then("the member validates pffs member error message$")
	public void pffsMemberErrorMessage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getpffsError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getpffsError().toString().contains("errorPffsMember"));

	}
	
	/**
	 * @toDo : user gives valid data on the create account page
	 */
	@Then("The member land on create account enters the valid data to create account$")
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
		Thread.sleep(3000);
		registrationInformationPage.waitForCreatePageAccountPage();
		Thread.sleep(3000);
		registrationInformationPage.enterUserNameToCreateAccount(userName);
		registrationInformationPage.enterPasswordToCreateAccount(password);
		registrationInformationPage.scroll();
		registrationInformationPage.enterConfirmPasswordToCreateAccount(confirmPassword);
		registrationInformationPage.enterEmailToCreateAccount(email);
		registrationInformationPage.enterConfirmEmailToCreateAccount(confirmEmail);
	}
	
	/**
	 * @toDo : user is on the registration page
	 */
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
    	System.out.println("here i m");
    	deregisterPage.navigateToDeregisterUrls();
    	Thread.sleep(10000);
    	deregisterPage.deregisterUser(userName);
    	Thread.sleep(5000);
    	
		// create registration context
        NewLoginPage newLoginPage = new NewLoginPage(wd);
       
        
        newLoginPage.navigateToNewDashboardUrls();
        getLoginScenario().saveBean(PageConstants.NEW_LOGIN_PAGE, newLoginPage);
		
		
		newLoginPage.navigateToRegistration();
		
		RegistrationInformationPage registrationInformationPage = new RegistrationInformationPage(newLoginPage.driver);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_INFORMATION_PAGE,registrationInformationPage);
		}

	/**
	 * @toDo : account confirmation page displays
	 */
	@Then("^member navigate to plan confirmation page$")
	public void validateAccountConfirmationPage() throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		Thread.sleep(3000);
		registrationInformationPage.getAccConfirmationHeading().isDisplayed();
		registrationInformationPage.getAccConfirmationText().isDisplayed();
		registrationInformationPage.getPrintLink().isDisplayed();
		registrationInformationPage.getGoToMyAccountButton().isDisplayed();
	}
		
	/**
	 * @toDo : verifies members information populated on the account information page
	 */
	@SuppressWarnings("deprecation")
	@And("^Verify correct first name is displayed$")
	public void VerifyAccountConfirmation_firstname(DataTable givenAttributes) throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		registrationInformationPage.waitForAccountConfirmationPage();
		String expectedFirstName = memberAttributesMap.get("FIRST_NAME");
		Thread.sleep(3000);
		String actualFirstName = registrationInformationPage.getMemberFirstName().getText().toString();
		Assert.assertEquals(expectedFirstName,actualFirstName);
	
	}
		/**
		 * @toDo : verifies members information populated on the account information page
		 */
		@SuppressWarnings("deprecation")
		@And("^Verify correct last name is displayed$")
		public void VerifyAccountConfirmation_lastname(DataTable givenAttributes) throws InterruptedException {
			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
					.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
			List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			
			}
		String expectedLastName = memberAttributesMap.get("LAST_NAME");
		Thread.sleep(3000);
		String actualLastName = registrationInformationPage.getMemberLastName().getText().toString();
		Assert.assertEquals(expectedLastName,actualLastName);
			}
		
		/**
		 * @toDo : verifies members information populated on the account information page
		 */
		@SuppressWarnings("deprecation")
		@And("^verify correct member information is displayed$")
		public void VerifyAccountConfirmation_information(DataTable givenAttributes) throws InterruptedException {
			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
					.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
			List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}
		String expectedUserName = memberAttributesMap.get("CREATE_ACCOUNT_USER_NAME");
		String ExpectedEmail = memberAttributesMap.get("CREATE_ACCOUNT_EMAIL");
		
		String dateOfBirth = memberAttributesMap.get("Date of birth");
		String[] splitDate = dateOfBirth.split("-");
		String month = splitDate[0];
		String day = splitDate[1];
		String year = splitDate[2];
		String expectedDateOfBirth = month + "/" + day + "/" + year;
			


		String actualUserName = registrationInformationPage.getUserName().getText().toString();
		String actualEmail = registrationInformationPage.getEmailAddress().getText().toString();
		String actualDateOfBirth = registrationInformationPage.getMemberDoB().getText();
	
		Assert.assertEquals(expectedUserName,actualUserName);
		Assert.assertEquals(ExpectedEmail,actualEmail);
		Assert.assertEquals(expectedDateOfBirth,actualDateOfBirth);
		
	}
	
	
	
	/**
	 * @toDo : verifies the member id required fields error message
	 */
	@Then("^the member validate member id required error message$")
	public void memberIdRequiredErrorMessage() {
			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
					.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
			registrationInformationPage.getMemberIdBlankError();			
	}

	/**
	 * @toDo : verifies the dob required fields error message
	 */
	@Then("^the member validate dob required error message$")
	public void dobRequiredErrorMessage() {
			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
					.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
			registrationInformationPage.getDobBlankError();
	}

	/**
	 * @toDo : verifies the 13 or younger age error message
	 */
	@Then("^the member validate dob fields thirteen years or younger error message$")
	public void ageLessThanThirteen() {
			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
					.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
			registrationInformationPage.getAgeLessError();
	}

	/**
	 * @toDo : verifies the snp error message
	 */
	@Then("^the member validate snp error message$")
	public void snpRequiredErrorMessage() {
			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
					.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
			registrationInformationPage.getSnpMemberError();
	}
	

}