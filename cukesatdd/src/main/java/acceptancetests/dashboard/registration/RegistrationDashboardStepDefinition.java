package acceptancetests.dashboard.registration;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.dashboard.acquisition.DeregisterPage;
import pages.dashboard.acquisition.RegistrationInformationPage;
import pages.member.redesign.NewLoginPage;
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

@SuppressWarnings("deprecation")
public class RegistrationDashboardStepDefinition {
	
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the member is on sign in page$")
	public void signInPage() {
			// init Web Driver
		    WebDriver wd = getLoginScenario().getWebDriver();
		    getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		  
		// create Sign In context
		NewLoginPage newLoginPage = new NewLoginPage(wd);
		getLoginScenario().saveBean(PageConstants.NEW_LOGIN_PAGE, newLoginPage);
			
			
	}
	
	@Given("^User click on the register button$")
	public void clickRegisterButton() throws InterruptedException {
		NewLoginPage newLoginPage = (NewLoginPage) getLoginScenario().getBean(PageConstants.NEW_LOGIN_PAGE);
		Thread.sleep(4000);
		newLoginPage.navigateToRegistration();
		
		RegistrationInformationPage registrationInformationPage = new RegistrationInformationPage(newLoginPage.driver);
		 getLoginScenario().saveBean(PageConstants.REGISTRATION_INFORMATION_PAGE,registrationInformationPage);
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
		Thread.sleep(3000);
		registrationInformationPage.scroll();
		Thread.sleep(2000);
		//registrationInformationPage.waitForRegistrationInformationPage();
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
		
		registrationInformationPage.scroll();
		Thread.sleep(2000);
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
		Thread.sleep(6000);
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
		//Assert.assertEquals(expectedmemberId, actualmemberId);
		
		Assert.assertTrue(actualmemberId.contains(expectedmemberId));
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
		
		Thread.sleep(2000);
		registrationInformationPage.scroll();
		Thread.sleep(4000);
		registrationInformationPage.clickNext();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@SuppressWarnings("deprecation")
	@Then("^the member validate existing member error message$")
	public void existingMemberErrorMessage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getExistingMemberError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getExistingMemberError()
				.toString().contains("existing"));
	}

	@SuppressWarnings("deprecation")
	@Then("^the member validate inactive or terminated error message$")
	public void inactiveTerminatedErrorMessage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getInactiveTerminatedError().isDisplayed();
		Assert.assertTrue(registrationInformationPage
				.getInactiveTerminatedError().toString().contains("inactive"));
	}

	@SuppressWarnings("deprecation")
	@Then("^the member validate future effective error message$")
	public void futureEffectiveErrorMessage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getFutureEffectiveError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getFutureEffectiveError()
				.toString().contains("future"));

	}

	@SuppressWarnings("deprecation")
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

	@SuppressWarnings("deprecation")
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
		NewLoginPage newLoginPage = new NewLoginPage(wd);
		getLoginScenario().saveBean(PageConstants.NEW_LOGIN_PAGE, newLoginPage);
		NewLoginPage newloginPage = (NewLoginPage) getLoginScenario().getBean(PageConstants.NEW_LOGIN_PAGE);
		Thread.sleep(4000);
		newloginPage.navigateToRegistration();
		RegistrationInformationPage registrationInformationPage = new RegistrationInformationPage(newLoginPage.driver);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_INFORMATION_PAGE,registrationInformationPage);
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
		String expectedFirstName = memberAttributesMap.get("FIRST_NAME");
		String expectedLastName = memberAttributesMap.get("LAST_NAME");
		String expectedUserName = memberAttributesMap.get("CREATE_ACCOUNT_USER_NAME");
		String ExpectedEmail = memberAttributesMap.get("CREATE_ACCOUNT_EMAIL");
		
		String dateOfBirth = memberAttributesMap.get("Date of birth");
		String[] splitDate = dateOfBirth.split("-");
		String month = splitDate[0];
		String day = splitDate[1];
		String year = splitDate[2];
		String expectedDateOfBirth = month + "/" + day + "/" + year;
			
		Thread.sleep(3000);
		String actualFirstName = registrationInformationPage.getMemberFirstName().getText().toString();
		String actualLastName = registrationInformationPage.getMemberLastName().getText().toString();
		String actualUserName = registrationInformationPage.getUserName().getText().toString();
		String actualEmail = registrationInformationPage.getEmailAddress().getText().toString();
		String actualDateOfBirth = registrationInformationPage.getMemberDoB().getText();
		Assert.assertEquals(expectedFirstName,actualFirstName);
		Assert.assertEquals(expectedLastName,actualLastName);
		Assert.assertEquals(expectedUserName,actualUserName);
		Assert.assertEquals(ExpectedEmail,actualEmail);
		Assert.assertEquals(expectedDateOfBirth,actualDateOfBirth);
		
	}
	
	@Then("^the member validate member id required error message$")
	public void memberIdRequiredErrorMessage() {
			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
					.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
			registrationInformationPage.getMemberIdBlankError();			
	}

	@Then("^the member validate dob required error message$")
	public void dobRequiredErrorMessage() {
			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
					.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
			registrationInformationPage.getDobBlankError();
	}

	@Then("^the member validate dob fields thirteen years or younger error message$")
	public void ageLessThanThirteen() {
			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
					.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
			registrationInformationPage.getAgeLessError();
	}

	@Then("^the member validate snp error message$")
	public void snpRequiredErrorMessage() {
			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
					.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
			registrationInformationPage.getSnpMemberError();
	}

}