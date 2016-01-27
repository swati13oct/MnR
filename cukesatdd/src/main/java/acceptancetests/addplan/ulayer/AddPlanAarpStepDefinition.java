package acceptancetests.addplan.ulayer;

/**
 * @author pperugu
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

import pages.acquisition.ulayer.AdditionalPlanPage;
import pages.acquisition.ulayer.CreateAccountPage;
import pages.acquisition.ulayer.PlanConfirmationPage;
import pages.acquisition.ulayer.RegistrationHomePage;
import pages.acquisition.ulayer.RegistrationSuccessPage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.AddPlanPopUpPage;
import pages.member.ulayer.ConfirmPlanDetailsPage;
import pages.member.ulayer.PlanSummaryPage;
import acceptancetests.addplan.data.AddplanConstants;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class AddPlanAarpStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the details of user to be registered in AARP site$")
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

		/* Starting the webdriver */
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean("webDriver", wd);

		RegistrationHomePage registrationHomePage = new RegistrationHomePage(wd);

		PlanConfirmationPage planConfirmationPage = registrationHomePage
				.registerWith(memberId, dateOfbirth);

		/* Get expected data */
		String key = memberId + "_" + dateOfbirth;
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(key);
		JSONObject planConfirmationExpectedJson = expectedDataMap
				.get(CommonConstants.PLAN_CONFIRMATION);

		JSONObject planConfirmationActualJson = null;
		if (planConfirmationPage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.PLAN_CONFIRMATION_PAGE,
					planConfirmationPage);
			Assert.assertTrue(true);
			planConfirmationActualJson = planConfirmationPage.planConfirmationJson;
		} else {
			Assert.fail(" Member Validation Failed ");
		}

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

	@When("^the user confirms the plan details in AARP site$")
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
	}

	@And("^the user performs add no other plan in AARP site$")
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

	@And("^the user registers with following details in AARP site$")
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
		JSONObject registrationSuccessExpectedJson = expectedDataMap
				.get(CommonConstants.REGISTRATION);
		JSONObject registrationSuccessActualJson = null;
		if (registrationSuccessPage != null) {
			getLoginScenario().saveBean(
					PageConstants.REGISTRATION_SUCCESS_PAGE,
					registrationSuccessPage);
			Assert.assertTrue(true);
			registrationSuccessActualJson = registrationSuccessPage.registrationSuccessJson;

		} else {
			Assert.fail(" Account Creation Failed");
		}

		/* Validation */
		try {
			JSONAssert.assertEquals(registrationSuccessExpectedJson,
					registrationSuccessActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user navigates to homepage in AARP site$")
	public void navigates_to_homePage() {
		RegistrationSuccessPage registrationSuccessPage = (RegistrationSuccessPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_SUCCESS_PAGE);
		AccountHomePage accountHomePage = registrationSuccessPage
				.navigateToHomePage();
		/* Getting Expected data */
		String user = (String) getLoginScenario().getBean(
				AddplanConstants.USERNAME);
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(user);
		JSONObject accountHomePageExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

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

		/* Validation */
		try {
			JSONAssert.assertEquals(accountHomePageExpectedJson,
					accountHomePageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user navigates to myPlans in AARP site$")
	public void performs_add_plan() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PlanSummaryPage planSummaryPage = accountHomePage
				.navigateToPlanSummary();
		if (planSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_SUMMARY_PAGE,
					planSummaryPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" unsuccessfully navigated to Add Plan Page");
		}

	}

	@And("^the user adds the plan with following details in AARP site$")
	public void add_a_plan(DataTable userAttributes) {
		String newPlanMemberId = userAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		PlanSummaryPage myPlanPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SUMMARY_PAGE);
		AddPlanPopUpPage addPlanPopUp = myPlanPage.clickAddPlan();
		ConfirmPlanDetailsPage confirmPlanDetailsPage = addPlanPopUp
				.addNewPlan(newPlanMemberId);
		if (confirmPlanDetailsPage != null) {
			getLoginScenario().saveBean(
					PageConstants.CONFIRM_PLAN_DETAILS_PAGE,
					confirmPlanDetailsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("plan added unsuccessfully");
		}
		AccountHomePage accountHomePage = confirmPlanDetailsPage.confirm();

		/* Getting Expected data */
		String user = (String) getLoginScenario().getBean(
				AddplanConstants.USERNAME);
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(user);
		JSONObject accountHomePageExpectedJson = accountHomePage
				.getAdditionalPlanExpectedData(expectedDataMap);

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

	@And("^the user validates the plan names of both the plan added$")
	public void validates_plandetails_aarp() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);

		JSONObject accountHomePageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AddplanConstants.ACCOUNT_HOME_EXPECTED);
		JSONObject accountHomePageActualJson = (JSONObject) getLoginScenario()
				.getBean(AddplanConstants.ACCOUNT_HOME_ACTUAL);

		/* Validation */
		try {
			JSONAssert.assertEquals(accountHomePageExpectedJson,
					accountHomePageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		accountHomePage.logOut();
	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();

	}

}
