package acceptancetests.addplan.bluelayer;

/**
 * @author pagarwa5
 * 
 * 
 */

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
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.AddPlanPopUpPage;
import pages.member.bluelayer.ConfirmPlanDetailsPage;
import pages.member.bluelayer.PlanSummaryPage;
import acceptancetests.addplan.data.AddplanConstants;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.plansummary.data.PlanSummaryCommonConstants;
import acceptancetests.registration.data.RegistrationConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class AddPlanUmsStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the details of user to be registered in UMS site$")
	public void register_a_member(DataTable memberAttributes) {
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
		String category = null;
		try {
			if (planConfirmationActualJson.get(RegistrationConstants.PLAN_NAME)
					.toString().contains(CommonConstants.GROUP)
					|| planConfirmationActualJson
							.get(RegistrationConstants.PLAN_NAME).toString()
							.contains("Supplement"))
				category = CommonConstants.GROUP;
			else {
				category = CommonConstants.INDIVIDUAL;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		getLoginScenario().saveBean(CommonConstants.CATEGORY, category);
		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);
		getLoginScenario().saveBean(RegistrationConstants.DATE_OF_BIRTH,
				dateOfbirth);
	}

	@When("^the user confirms the plan details in UMS site$")
	public void user_confirms_personal_plan_details() {
		PlanConfirmationPage planConfirmationPage = (PlanConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_CONFIRMATION_PAGE);

		AdditionalPlanPage additionalPlanPage = (AdditionalPlanPage) planConfirmationPage
				.confirmPlan();
		if (additionalPlanPage != null) {
			getLoginScenario().saveBean(PageConstants.ADDITIONAL_PLAN_PAGE,
					additionalPlanPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Plan Confirmation Failed");
		}

		/*
		 * CreateAccountPage createAccountPage = (CreateAccountPage)
		 * planConfirmationPage .confirmPlan();
		 * 
		 * if (createAccountPage != null) {
		 * getLoginScenario().saveBean(PageConstants.CREATE_ACCOUNT_PAGE,
		 * createAccountPage); Assert.assertTrue(true); } else {
		 * Assert.fail("Plan Confirmation Failed"); }
		 */
	}

	@And("^the user performs add no other plan in UMS site$")
	public void user_provides_the_additionalplan() {
		AdditionalPlanPage additionalPlanPage = (AdditionalPlanPage) getLoginScenario()
				.getBean(PageConstants.ADDITIONAL_PLAN_PAGE);
		CreateAccountPage createAccountPage = additionalPlanPage
				.addNoOtherPlan();
		if (createAccountPage != null) {
			getLoginScenario().saveBean(PageConstants.CREATE_ACCOUNT_PAGE,
					createAccountPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Additional Plan Confirmation Failed");
		}
	}

	@And("^the user registers with following details in UMS site$")
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

		RegistrationSuccessPage registrationSuccessPage = createAccountPage
				.createAccount(memberAttributesMap);
		String user = memberAttributesMap.get("Create a username");
		getLoginScenario().saveBean(AddplanConstants.USERNAME, user);

		/* Expected data setup */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject registrationSuccessExpectedJson = registrationSuccessPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED,
				registrationSuccessExpectedJson);
		JSONObject registrationSuccessActualJson = null;

		if (registrationSuccessPage != null) {
			getLoginScenario().saveBean(
					PageConstants.REGISTRATION_SUCCESS_PAGE,
					registrationSuccessPage);
			Assert.assertTrue(true);
			registrationSuccessActualJson = registrationSuccessPage.registrationSuccessJson;
			getLoginScenario().saveBean(
					RegistrationConstants.REGISTRATION_SUCCESS_ACTUAL,
					registrationSuccessActualJson);

		}
		System.out.println("registrationSuccessActualJson====>"
				+ registrationSuccessActualJson.toString());
		System.out.println("registrationSuccessExpectedJson====>"
				+ registrationSuccessExpectedJson.toString());

		/* Validation */
		try {
			JSONAssert.assertEquals(registrationSuccessExpectedJson,
					registrationSuccessActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user navigates to homepage in UMS site$")
	public void navigates_to_homePage() {

		RegistrationSuccessPage registrationSuccessPage = (RegistrationSuccessPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_SUCCESS_PAGE);
		String category = (String) getLoginScenario().getBean(
				CommonConstants.CATEGORY);
		AccountHomePage accountHomePage = registrationSuccessPage
				.navigateToHomePage(category);

		/* Getting Expected data */
		String user = (String) getLoginScenario().getBean(
				AddplanConstants.USERNAME);
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(user);
		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);
		JSONObject accountHomePageExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(AddplanConstants.ACCOUNT_HOME_EXPECTED,
				accountHomePageExpectedJson);

		JSONObject accountHomePageActualJson = null;
		if (accountHomePage != null) {
			Assert.assertTrue(true);
			accountHomePageActualJson = accountHomePage.accountHomeJson;
			getLoginScenario().saveBean(AddplanConstants.ACCOUNT_HOME_ACTUAL,
					accountHomePageActualJson);
		}
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
				accountHomePage);

		/* Validation */
		try {
			JSONAssert.assertEquals(accountHomePageExpectedJson,
					accountHomePageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user navigates to myplans in UMS site$")
	public void performs_add_plan() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		String category = (String) getLoginScenario().getBean(
				CommonConstants.CATEGORY);
		PlanSummaryPage planSummaryPage = accountHomePage
				.navigateToPlanSummary(category);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject planSummaryExpectedJson = planSummaryPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				PlanSummaryCommonConstants.PLAN_SUMMARY_EXPECTED,
				planSummaryExpectedJson);

		JSONObject planSummaryActualJson = null;
		if (planSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_SUMMARY_PAGE,
					planSummaryPage);
			Assert.assertTrue(true);
			planSummaryActualJson = planSummaryPage.planSummaryJson;
			getLoginScenario().saveBean(
					PlanSummaryCommonConstants.PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);
		}

		/* Validation */
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user adds the plan with following details in UMS site$")
	public void add_a_plan(DataTable userAttributes) {

		String newPlanMemberId = userAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		PlanSummaryPage myPlanPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SUMMARY_PAGE);
		String dateOfbirth = (String) getLoginScenario().getBean(
				RegistrationConstants.DATE_OF_BIRTH);

		AddPlanPopUpPage addPlanPopUp = myPlanPage.clickAddPlan();
		ConfirmPlanDetailsPage addPlanConfirmationPage = addPlanPopUp
				.addNewPlan(newPlanMemberId);

		/* Get expected data */
		String key = newPlanMemberId + "_" + dateOfbirth;
		System.out.println("add plan key :: " + key);
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(key);
		JSONObject addPlanConfirmationExpectedJson = addPlanConfirmationPage
				.getExpectedData(expectedDataMap);

		JSONObject addPlanConfirmationActualJson = null;
		if (addPlanConfirmationPage != null) {
			getLoginScenario().saveBean(
					PageConstants.CONFIRM_PLAN_DETAILS_PAGE,
					addPlanConfirmationPage);
			Assert.assertTrue(true);
			addPlanConfirmationActualJson = addPlanConfirmationPage.addPlanConfirmationJson;
		}
		System.out.println("addPlanConfirmationExpectedJson====>"
				+ addPlanConfirmationExpectedJson.toString());
		System.out.println("addPlanConfirmationActualJson======>"
				+ addPlanConfirmationActualJson.toString());
		/* Validation */
		try {
			JSONAssert.assertEquals(addPlanConfirmationExpectedJson,
					addPlanConfirmationActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		String category = null;
		try {
			if (addPlanConfirmationActualJson
					.get(RegistrationConstants.PLAN_NAME).toString()
					.contains(CommonConstants.GROUP)
					|| addPlanConfirmationActualJson
							.get(RegistrationConstants.PLAN_NAME).toString()
							.contains("Supplement"))
				category = CommonConstants.GROUP;
			else {
				category = CommonConstants.INDIVIDUAL;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.CATEGORY, category);

		AccountHomePage accountHomePage = addPlanConfirmationPage
				.confirm(category);

		/* Getting Expected data */
		String user = (String) getLoginScenario().getBean(
				AddplanConstants.USERNAME);
		Map<String, JSONObject> expectedDataUserMap = loginScenario
				.getExpectedJson(user);
		JSONObject accountHomePageExpectedJson = accountHomePage
				.getAdditionalPlanExpectedData(expectedDataUserMap);

		JSONObject accountHomePageActualJson = null;
		if (accountHomePage != null) {
			Assert.assertTrue(true);
			accountHomePageActualJson = accountHomePage.accountHomeJson;
		}
		getLoginScenario().saveBean(AddplanConstants.ACCOUNT_HOME_EXPECTED,
				accountHomePageExpectedJson);
		getLoginScenario().saveBean(AddplanConstants.ACCOUNT_HOME_ACTUAL,
				accountHomePageActualJson);

		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
				accountHomePage);

	}

	@Then("^the user validates the plan names of both the plan added in UMS site$")
	public void confirmPlanDetails() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);

		JSONObject accountHomePageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AddplanConstants.ACCOUNT_HOME_EXPECTED);
		JSONObject accountHomePageActualJson = (JSONObject) getLoginScenario()
				.getBean(AddplanConstants.ACCOUNT_HOME_ACTUAL);

		System.out.println("accountHomePageActualJson====>"
				+ accountHomePageActualJson.toString());
		System.out.println("accountHomePageExpectedJson====>"
				+ accountHomePageExpectedJson.toString());

		/* Validation */
		try {
			JSONAssert.assertEquals(accountHomePageExpectedJson,
					accountHomePageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		accountHomePage.logOut();

	}

}
