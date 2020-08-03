package acceptancetests.memberrdesignVBF.registration;

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
import pages.memberrdesignVBF.DeregisterPage;
import pages.memberrdesignVBF.LoginPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.RegistrationInformationPage;

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

	/***
	 * 
	 * @param givenAttributes
	 * @throws InterruptedException
	 */
	@When("^the member enter the member ID into Member ID field$")
	public void enterMemberID(DataTable givenAttributes) throws InterruptedException {
		// get test variables
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		// get member ID
		String memberId = memberAttributesMap.get("Plan Member ID");
		// navigate to registration page
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.enterMemberID(memberId);
	}

	/***
	 * 
	 * @param givenAttributes
	 * @throws InterruptedException
	 */
	@When("^member enter date of birth in the date of birth dropdown$")
	public void enterDate(DataTable givenAttributes) throws InterruptedException {
		// get test variables
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		// get date of birth
		String dateOfBirth = memberAttributesMap.get("Date of birth");
		String[] splitDate = dateOfBirth.split("-");
		String month = splitDate[0];
		String day = splitDate[1];
		String year = splitDate[2];

		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getEnterMonth().click();
		registrationInformationPage.enterMonth(month);
		registrationInformationPage.clickMonthresults();
		registrationInformationPage.getEnterDay().click();
		registrationInformationPage.enterMonth(day);
		registrationInformationPage.clickDayResults();
		registrationInformationPage.getEnterYear().click();
		registrationInformationPage.enterMonth(year);
		registrationInformationPage.clickYearResults();

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
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

	/***
	 * 
	 */
	@Then("^member will be navigated to registration plan information page$")
	public void RegistrationPlanInformation() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.waitForPlanInformationPage();
		Assert.assertTrue("Check member details", registrationInformationPage.getStepTwoText().isDisplayed());
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@When("^member clicks on next button$")
	public void member_clicks_on_next_button() throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.clickNext();
	}

	/***
	 * 
	 * @param givenAttributes
	 * @throws InterruptedException
	 */
	@And("The member land on create account enters the valid data to create account$")
	public void enterCreateAccountData(DataTable givenAttributes) throws InterruptedException {

		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
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
		registrationInformationPage.enterConfirmPasswordToCreateAccount(confirmPassword);
		registrationInformationPage.enterEmailToCreateAccount(email);
		registrationInformationPage.enterConfirmEmailToCreateAccount(confirmEmail);
	}

	/***
	 * 
	 * @param givenAttributes
	 * @throws InterruptedException
	 */
	@Given("^the member is on registration page of redesign portal$")
	public void RegistrationPage(DataTable givenAttributes) throws InterruptedException {
		// init Web Driver
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		// get test variables
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		// get member ID
		String userName = memberAttributesMap.get("CREATE_ACCOUNT_USER_NAME");

		// deregister the user for subsequent registration
		DeregisterPage deregisterPage = new DeregisterPage(wd);
		deregisterPage.deregisterUser(userName);

		// create registration context
		LoginPage THloginPage = new LoginPage(wd);
		RegistrationInformationPage registrationInformationPage = THloginPage.navigateToRegistrationPage();
		if (null != registrationInformationPage)
			getLoginScenario().saveBean(PageConstants.REGISTRATION_INFORMATION_PAGE, registrationInformationPage);
		else
			Assert.fail("Registration page is not loaded");

	}

	/***
	 * 
	 * @param givenAttributes
	 * @throws InterruptedException
	 */
	@SuppressWarnings("deprecation")
	@Then("^Verify that correct information is displayed on Account Confirmation page$")
	public void VerifyAccountConfirmation_page(DataTable givenAttributes) throws InterruptedException {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String expectedUserName = memberAttributesMap.get("CREATE_ACCOUNT_USER_NAME");
		String ExpectedEmail = memberAttributesMap.get("CREATE_ACCOUNT_EMAIL");

		String dateOfBirth = memberAttributesMap.get("Date of birth");
		String[] splitDate = dateOfBirth.split("-");
		String month = splitDate[0];
		String day = splitDate[1];
		String year = splitDate[2];
		String expectedDateOfBirth = month + "/" + day + "/" + year;

		registrationInformationPage.waitForAccountConfirmationPage();
		String actualUserName = registrationInformationPage.getUserName().getText().toString();
		String actualEmail = registrationInformationPage.getEmailAddress().getText().toString();
		String actualDateOfBirth = registrationInformationPage.getMemberDoB().getText();
		Assert.assertEquals(expectedUserName, actualUserName);
		Assert.assertEquals(ExpectedEmail, actualEmail);
		Assert.assertEquals(expectedDateOfBirth, actualDateOfBirth);

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^click on confirm registration$")
	public void clickonconfirmregistration() throws InterruptedException {
		// navigate to registration page
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.scroll();
		registrationInformationPage.getAccountConfirmation().click();

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^User successfully navigates to RallyDasboard page$")
	public void user_navigates_to_rallydasboard_page() throws InterruptedException {

		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			System.out.println(
					"@@@Skipping navigation to home page as rallyDashboard is not integrated to this environment@@@");
		} else {
			// navigate to registration page
			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) getLoginScenario()
					.getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);

			RallyDashboardPage rallyDashboard = registrationInformationPage.navigateToRallyDashboardPage();

			if (rallyDashboard == null) {
				Assert.fail("User -- " + getLoginScenario().getBean(CommonConstants.ACCOUNT_USER_NAME)
						+ " navigation to dashboard page failed.");
			}
		}

	}
}