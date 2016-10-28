package acceptancetests.mypcpregistration;

import gherkin.formatter.model.DataTableRow;
import pages.member.ulayer.PaymentHistoryPage;
import pages.mypcp.AccountHomePage;
import pages.mypcp.CreateAccountPage;
import pages.mypcp.PlanConfirmationPage;
import pages.mypcp.RegistrationHomePage;
import pages.mypcp.RegistrationSuccessPage;
import pages.mypcp.SignInPage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.plansummary.data.PlanSummaryCommonConstants;
import acceptancetests.registration.data.RegistrationConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author kchaudh3
 *
 */

public class MyPCPRegistrationStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public WebDriver wd;

	@Given("^the user is on registration page of My PCP site$")
	public void registration_landing_page() {
		wd = getLoginScenario().getChromeDriver();
		wd.manage().window().maximize();

		SignInPage myPcpSignInPage = new SignInPage(wd);
		RegistrationHomePage registrationHomePage = new RegistrationHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE, registrationHomePage);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE, registrationHomePage);
	}

	@When("^the user registers with below details in My PCP site$")
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
		String fileName = "950592474_12-12-1946";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY + File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + CommonConstants.FLOW_NAME + File.separator;
		JSONObject registrationJson = MRScenario.readExpectedJson(fileName, directory);
		getLoginScenario().saveBean(RegistrationConstants.PLAN_CONFIRMATION_EXPECTED, registrationJson);
	}

	@Then("^the user validates the plan information on plan confirmation page in My PCP site$")
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

	@When("^the user confirms the personal and plan information in My PCP site$")
	public void confirm_plan() {
		PlanConfirmationPage planConfirmationPage = (PlanConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_CONFIRMATION_PAGE);
		Object object = planConfirmationPage.confirmPlan();
		getLoginScenario().saveBean(RegistrationConstants.PAGE, object);

	}

	@And("^the user registers with the following details in My PCP site$")
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
		String fileName = "blpcp_012";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY + File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + CommonConstants.REGISTRATION + File.separator + CommonConstants.REGISTRATION_SUCCESS
				+ File.separator;
		JSONObject registrationSuccessJson = MRScenario.readExpectedJson(fileName, directory);

		getLoginScenario().saveBean(RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED, registrationSuccessJson);
	}

	@Then("^the user registers successfully in My PCP site$")
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

	@Then("^the user navigates to My Account home page in My PCP site$")
	public void navigateToAccountHome() {

		RegistrationSuccessPage regSuccessPage = (RegistrationSuccessPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_SUCCESS_PAGE);
		AccountHomePage accountHomePage = regSuccessPage.navigateToHomePage(null);
		wd.quit();
	}

}
