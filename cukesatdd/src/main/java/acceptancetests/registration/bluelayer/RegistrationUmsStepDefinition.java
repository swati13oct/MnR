package acceptancetests.registration.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AdditionalPlanPage;
import pages.acquisition.bluelayer.CreateAccountPage;
import pages.acquisition.bluelayer.PlanConfirmationPage;
import pages.acquisition.bluelayer.RegistrationHomePage;
import pages.acquisition.bluelayer.RegistrationSuccessPage;
import acceptancetests.addplan.data.AddplanConstants;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.registration.data.RegistrationConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */
public class RegistrationUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the following details with which the member registers in UMS site$")
	public void user_registered_with_details_UMS(DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String memberId = memberAttributesMap.get("Plan Member ID");
		String dateOfbirth = memberAttributesMap.get("Date of birth");
		getLoginScenario().saveBean(RegistrationConstants.DATE_OF_BIRTH,
				dateOfbirth);
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		RegistrationHomePage registrationHomePage = new RegistrationHomePage(wd);

		PlanConfirmationPage planConfirmationPage = registrationHomePage
				.registerWith(memberId, dateOfbirth);

		/* Get expected data */
		String key = memberId + "_" + dateOfbirth;
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(key);
		JSONObject planConfirmationExpectedJson = planConfirmationPage
				.getExpectedData(expectedDataMap);

		JSONObject planConfirmationActualJson = null;
		if (planConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_CONFIRMATION_PAGE,
					planConfirmationPage);
			Assert.assertTrue(true);
			planConfirmationActualJson = planConfirmationPage.planConfirmationJson;
		}
		System.out.println("planConfirmationExpectedJson====>"
				+ planConfirmationExpectedJson.toString());
		System.out.println("planConfirmationActualJson======>"
				+ planConfirmationActualJson.toString());
		/* Validation */
		try {
			JSONAssert.assertEquals(planConfirmationExpectedJson,
					planConfirmationActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);
	}

	@When("^the user confirms plan details in UMS site$")
	public void user_confirms_personal_plan_details() {
		PlanConfirmationPage planConfirmationPage = (PlanConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_CONFIRMATION_PAGE);

		CreateAccountPage createAccountPage = (CreateAccountPage) planConfirmationPage
				.confirmPlan();

		if (createAccountPage != null) {
			getLoginScenario().saveBean(PageConstants.CREATE_ACCOUNT_PAGE,
					createAccountPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Plan Confirmation Failed");
		}
	}

	@When("^the user provides additional Member Id in UMS site$")
	public void user_provides_the_additionalplan(DataTable planAttributes) {
		/*
		 * fetching given attributes i.e. additional plan details for
		 * registration
		 */
		List<DataTableRow> memberAttributesRow = planAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String dateofBirth = (String) getLoginScenario().getBean(RegistrationConstants.DATE_OF_BIRTH);
		String addditionaPlanId = memberAttributesMap
				.get("Additional Plan Member ID");

		PlanConfirmationPage planConfirmationPage = (PlanConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_CONFIRMATION_PAGE);

		AdditionalPlanPage additionalPlanUMSPage = (AdditionalPlanPage) planConfirmationPage
				.confirmPlan();

		planConfirmationPage = additionalPlanUMSPage
				.addAnotherPlan(addditionaPlanId);
		
		
		/* Get expected data */
		String key = addditionaPlanId + "_" + dateofBirth;
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(key);
		JSONObject planConfirmationExpectedJson = planConfirmationPage
				.getExpectedData(expectedDataMap);

		JSONObject planConfirmationActualJson = null;
		if (planConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_CONFIRMATION_PAGE,
					planConfirmationPage);
			Assert.assertTrue(true);
			planConfirmationActualJson = planConfirmationPage.planConfirmationJson;
		}
		System.out.println("planConfirmationExpectedJson====>"
				+ planConfirmationExpectedJson.toString());
		System.out.println("planConfirmationActualJson======>"
				+ planConfirmationActualJson.toString());
		/* Validation */
		try {
			JSONAssert.assertEquals(planConfirmationExpectedJson,
					planConfirmationActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user confirm personal and plan information for both plans in UMS site$")
	public void user_confirms_plan_information_both_plans() {

		PlanConfirmationPage planConfirmationUMSPage = (PlanConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_CONFIRMATION_PAGE);

		CreateAccountPage createAccountUMSPage = (CreateAccountPage) planConfirmationUMSPage
				.confirmPlan();

		if (createAccountUMSPage != null) {
			getLoginScenario().saveBean(PageConstants.CREATE_ACCOUNT_PAGE,
					createAccountUMSPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Additional Plan Confirmation Failed");
		}
	}

	@And("^the user registers with the following details in UMS site$")
	public void user_registers_with_provided_details(DataTable userAttributes) {
		/* fetching given attributes with which the user registers */
		List<DataTableRow> memberAttributesRow = userAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		CreateAccountPage createAccountPage = (CreateAccountPage) getLoginScenario()
				.getBean(PageConstants.CREATE_ACCOUNT_PAGE);
		
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		RegistrationSuccessPage registrationSuccessPage = createAccountPage
				.createAccount(memberAttributesMap);
		String user = memberAttributesMap.get("Create a username");
		getLoginScenario().saveBean(AddplanConstants.USERNAME, user);
		JSONObject registrationSuccessExpectedJson = registrationSuccessPage
				.getExpectedData(expectedDataMap);
		JSONObject registrationSuccessActualJson = null;
		if (registrationSuccessPage != null) {
			getLoginScenario().saveBean(
					PageConstants.REGISTRATION_SUCCESS_PAGE,
					registrationSuccessPage);
			Assert.assertTrue(true);
			registrationSuccessActualJson = registrationSuccessPage.registrationSuccessJson;

		}

		getLoginScenario().saveBean(
				RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED,
				registrationSuccessExpectedJson);
		getLoginScenario().saveBean(
				RegistrationConstants.REGISTRATION_SUCCESS_ACTUAL,
				registrationSuccessActualJson);

	}

	@Then("^user registers successfully in UMS site$")
	public void user_registers_successfully() {

		RegistrationSuccessPage registrationSuccessPage = (RegistrationSuccessPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_SUCCESS_PAGE);

		JSONObject registrationSuccessExpectedJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED);

		JSONObject registrationSuccessActualJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.REGISTRATION_SUCCESS_ACTUAL);

		System.out.println("registrationSuccessExpectedJson======>"
				+ registrationSuccessExpectedJson.toString());
		System.out.println("registrationSuccessActualJson=======>"
				+ registrationSuccessActualJson.toString());

		/* Validation */
		try {
			JSONAssert.assertEquals(registrationSuccessExpectedJson,
					registrationSuccessActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		registrationSuccessPage.logOut();

	}
	
	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
