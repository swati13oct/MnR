package acceptancetests.mymedicaregistration;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.mymedica.AccountHomePage;
import pages.mymedica.CreateAccountPage;
import pages.mymedica.ErrorPage;
import pages.mymedica.PlanConfirmationPage;
import pages.mymedica.RegistrationHomePage;
import pages.mymedica.RegistrationSuccessPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.registration.data.RegistrationConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author kchaudh3
 *
 */

public class MyMedicaRegistrationStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver wd;

	@Given("^the user is on registration page of My Medica site$")
	public void registration_landing_page() {
		wd = getLoginScenario().getWebDriver();
		wd.manage().window().maximize();
		RegistrationHomePage registrationHomePage = new RegistrationHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE, registrationHomePage);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE, registrationHomePage);
	}

	@When("^the user registers with below details in My Medica site$")
	public void user_registers(DataTable memberAttributes) {
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String memberid1 = memberAttributesMap.get("Plan Member ID");
		String dateOfbirth = memberAttributesMap.get("Date of birth");
		getLoginScenario().saveBean(RegistrationConstants.DATE_OF_BIRTH, dateOfbirth);

		RegistrationHomePage registrationHomePage = (RegistrationHomePage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_HOME_PAGE);
		PlanConfirmationPage planConfirmationPage = registrationHomePage.registerWith(memberid1, dateOfbirth);
		getLoginScenario().saveBean(PageConstants.PLAN_CONFIRMATION_PAGE, planConfirmationPage);

		/* Get Actual response */
		JSONObject planConfirmationActualJson = planConfirmationPage.planConfirmationJson;
		getLoginScenario().saveBean(RegistrationConstants.PLAN_CONFIRMATION_ACTUAL, planConfirmationActualJson);

		/* Get Expected response */
		String fileName = "968993858_11-11-1945";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY + File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + CommonConstants.FLOW_NAME + File.separator;
		JSONObject registrationJson = MRScenario.readExpectedJson(fileName, directory);
		getLoginScenario().saveBean(RegistrationConstants.PLAN_CONFIRMATION_EXPECTED, registrationJson);
	}

	@Then("^the user validates the plan information on plan confirmation page in My Medica site$")
	public void validate_planInformation() {
		JSONObject planConfirmationActualJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.PLAN_CONFIRMATION_ACTUAL);
		System.out.println("planConfirmationActualJson for first plan------------>" + planConfirmationActualJson);

		JSONObject planConfirmationExpectedJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.PLAN_CONFIRMATION_EXPECTED);
		System.out.println("planConfirmationExpectedJson for first plan------------>" + planConfirmationExpectedJson);

		try {
			JSONAssert.assertEquals(planConfirmationExpectedJson, planConfirmationActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^the user confirms the personal and plan information in My Medica site$")
	public void confirm_plan() {
		PlanConfirmationPage planConfirmationPage = (PlanConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_CONFIRMATION_PAGE);
		Object object = planConfirmationPage.confirmPlan();
		getLoginScenario().saveBean(RegistrationConstants.PAGE, object);

	}

	@And("^the user registers with the following details in My Medica site$")
	public void create_account(DataTable memberAttributes) {
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String userName = memberAttributesMap.get("Create a username");

		CreateAccountPage createAccountPage = (CreateAccountPage) getLoginScenario()
				.getBean(RegistrationConstants.PAGE);
		RegistrationSuccessPage registrationSuccessPage = createAccountPage.createAccount(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_SUCCESS_PAGE, registrationSuccessPage);

		/* Get Actual response */
		JSONObject registrationSuccessActualJson = registrationSuccessPage.registrationSuccessJson;
		getLoginScenario().saveBean(RegistrationConstants.REGISTRATION_SUCCESS_ACTUAL, registrationSuccessActualJson);

		/* Get expected response */
		String fileName = "mmc_blayer003";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY + File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + CommonConstants.REGISTRATION + File.separator + CommonConstants.REGISTRATION_SUCCESS
				+ File.separator;
		JSONObject registrationSuccessJson = MRScenario.readExpectedJson(fileName, directory);

		getLoginScenario().saveBean(RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED, registrationSuccessJson);
	}

	@Then("^the user registers successfully in My Medica site$")
	public void register_successfully() {
		JSONObject registrationSuccessActualJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.REGISTRATION_SUCCESS_ACTUAL);

		System.out.println("registrationSuccessActualJson----->" + registrationSuccessActualJson);

		JSONObject registrationSuccessExpectedJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED);
		System.out.println("registrationSuccessExpectedJson----->" + registrationSuccessExpectedJson);

		try {
			JSONAssert.assertEquals(registrationSuccessExpectedJson, registrationSuccessActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@When("^the user navigate to error page$")
	public void negativeScenario() {
		RegistrationHomePage registrationHomePage = (RegistrationHomePage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_HOME_PAGE);
		ErrorPage errorPage = registrationHomePage.navigateToErrorPage();
		
		getLoginScenario().saveBean(PageConstants.REGISTRATION_ERROR_PAGE, errorPage);

		/* Get Actual response */
		JSONObject regErrorActualJson = errorPage.regErrorPageJson;
		getLoginScenario().saveBean(RegistrationConstants.REG_ERROR_PAGE_ACTUAL, regErrorActualJson);
		
		/* Get Expected response */
		String fileName = "registrationfailure";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY + File.separator + CommonConstants.SITE_MYMEDICA
				+ File.separator + CommonConstants.REG_FAILURE_FLOW_NAME + File.separator;
		JSONObject registrationFailureExpectedJson = MRScenario.readExpectedJson(fileName, directory);
		getLoginScenario().saveBean(RegistrationConstants.REG_FAILURE_EXPECTED, registrationFailureExpectedJson);

	}
	
	@Then("^the user validate error message$")
	public void validate_ErrorMessage() {
		JSONObject regErrorActualJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.REG_ERROR_PAGE_ACTUAL);
		System.out.println("regErrorActualJson ------------>" + regErrorActualJson);

		JSONObject registrationFailureExpectedJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.REG_FAILURE_EXPECTED);
		System.out.println("registrationFailureExpectedJson ----------->" + registrationFailureExpectedJson);

		try {
			JSONAssert.assertEquals(regErrorActualJson, registrationFailureExpectedJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Then("^the user navigates to My Account home page in My Medica site$")
	public void navigateToAccountHome() {

		RegistrationSuccessPage regSuccessPage = (RegistrationSuccessPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_SUCCESS_PAGE);
		AccountHomePage accountHomePage = regSuccessPage.navigateToHomePage();
		wd.quit();
	}

}