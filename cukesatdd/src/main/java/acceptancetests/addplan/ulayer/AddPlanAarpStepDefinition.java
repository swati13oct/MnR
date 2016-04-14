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
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.plansummary.data.PlanSummaryCommonConstants;
import acceptancetests.registration.data.RegistrationConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class AddPlanAarpStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the AARP medicare site registration page$")
	public void registration_homePage(){
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		RegistrationHomePage registrationHomePage = new RegistrationHomePage(wd);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE, registrationHomePage);
	}
	
	@When("^the user registers in AARP site with following details$")
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
		getLoginScenario().saveBean(RegistrationConstants.DATE_OF_BIRTH, dateOfbirth);
		
		RegistrationHomePage registrationHomePage = (RegistrationHomePage) getLoginScenario().getBean(PageConstants.REGISTRATION_HOME_PAGE);
		PlanConfirmationPage planConfirmationPage = registrationHomePage
				.registerWith(memberId, dateOfbirth);
		getLoginScenario().saveBean(PageConstants.PLAN_CONFIRMATION_PAGE, planConfirmationPage);
		
		/*Get Actual response*/
		JSONObject planConfirmationActualJson = planConfirmationPage.planConfirmationJson;
		getLoginScenario().saveBean(RegistrationConstants.PLAN_CONFIRMATION_ACTUAL, planConfirmationActualJson);
		
		/*Get Expected response*/
		String key = memberId + "_" + dateOfbirth;
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(key);
		JSONObject planConfirmationExpectedJson = expectedDataMap
				.get(CommonConstants.PLAN_CONFIRMATION);
		JSONObject registrationCommonExpected = expectedDataMap.get(CommonConstants.REGISTRATION_COMMON);
		getLoginScenario().saveBean(RegistrationConstants.REGSITRATION_COMMON_EXPECTED, registrationCommonExpected);
		
		planConfirmationExpectedJson = CommonUtility.mergeJson(planConfirmationExpectedJson, registrationCommonExpected);
		getLoginScenario().saveBean(RegistrationConstants.PLAN_CONFIRMATION_EXPECTED, planConfirmationExpectedJson);

	}
	
	@Then("^the user validates the plan information on plan confirmation page in AARP site$")
	public void validate_planInformation(){
		JSONObject planConfirmationActualJson = (JSONObject)getLoginScenario().getBean(RegistrationConstants.PLAN_CONFIRMATION_ACTUAL);
		System.out.println("planConfirmationActualJson for first plan------------>"+planConfirmationActualJson);
		
		JSONObject planConfirmationExpectedJson = (JSONObject)getLoginScenario().getBean(RegistrationConstants.PLAN_CONFIRMATION_EXPECTED);
		System.out.println("planConfirmationExpectedJson for first plan------------>"+planConfirmationExpectedJson);
		
		try {
			JSONAssert.assertEquals(planConfirmationExpectedJson, planConfirmationActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = userAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		
		String userName = memberAttributesMap.get("Create a username");
		getLoginScenario().saveBean(AddplanConstants.USERNAME, userName);
		
		CreateAccountPage createAccountPage = (CreateAccountPage) getLoginScenario().getBean(PageConstants.CREATE_ACCOUNT_PAGE);
		RegistrationSuccessPage registrationSuccessPage = createAccountPage.createAccount(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_SUCCESS_PAGE, registrationSuccessPage);
		
		/*Get Actual response*/
		JSONObject registrationSuccessActualJson = registrationSuccessPage.registrationSuccessJson;
		getLoginScenario().saveBean(RegistrationConstants.REGISTRATION_SUCCESS_ACTUAL, registrationSuccessActualJson);
		
		/*Get expected response*/
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject registrationCommonExpected = (JSONObject)getLoginScenario().getBean(RegistrationConstants.REGSITRATION_COMMON_EXPECTED);
		JSONObject registrationSuccessExpectedJson = registrationSuccessPage
				.getExpectedData(expectedDataMap, registrationCommonExpected);
		
		getLoginScenario().saveBean(RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED, registrationSuccessExpectedJson);


	}
	
	@Then("^the user registers successfully in AARP site$")
	public void register_successfully()
	{
		JSONObject registrationSuccessActualJson =(JSONObject) getLoginScenario().getBean(RegistrationConstants.REGISTRATION_SUCCESS_ACTUAL);
		System.out.println("registrationSuccessActualJson----->"+registrationSuccessActualJson);
		
		JSONObject registrationSuccessExpectedJson =(JSONObject) getLoginScenario().getBean(RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED);
		System.out.println("registrationSuccessExpectedJson----->"+registrationSuccessExpectedJson);
		
		try {
			JSONAssert.assertEquals(registrationSuccessExpectedJson, registrationSuccessActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RegistrationSuccessPage registrationSuccessPage = (RegistrationSuccessPage)getLoginScenario().getBean(PageConstants.REGISTRATION_SUCCESS_PAGE);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_SUCCESS_PAGE, registrationSuccessPage);
		
	}

	@When("^the user navigates to homepage in AARP site$")
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
		
		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);
		
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

		

	}

	@Then("^the user validates account home page in AARP site$")
	public void validate_accountHome(){
		
		JSONObject accountHomePageActualJson =(JSONObject) getLoginScenario().getBean(AddplanConstants.ACCOUNT_HOME_ACTUAL);
		System.out.println("accountHomePageActualJson----->"+accountHomePageActualJson);
		
		JSONObject accountHomePageExpectedJson =(JSONObject) getLoginScenario().getBean(AddplanConstants.ACCOUNT_HOME_EXPECTED);
		System.out.println("accountHomePageExpectedJson----->"+accountHomePageExpectedJson);
		
		/* Validation */
		try {
			JSONAssert.assertEquals(accountHomePageExpectedJson,
					accountHomePageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	@When("^the user navigates to myPlans in AARP site$")
	public void performs_add_plan() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PlanSummaryPage planSummaryPage = accountHomePage
				.navigateToPlanSummary();
		
		
		JSONObject planSummaryActualJson = null;
		if (planSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_SUMMARY_PAGE,
					planSummaryPage);
			planSummaryActualJson = planSummaryPage.planSummaryJson;
			
			Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario().getBean(CommonConstants.EXPECTED_DATA_MAP);
			JSONObject planSummaryExpectedJson = planSummaryPage
					.getExpectedData(expectedDataMap);
			getLoginScenario().saveBean(
					PlanSummaryCommonConstants.PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);
			getLoginScenario().saveBean(
					PlanSummaryCommonConstants.PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);
			getLoginScenario().saveBean(PageConstants.PLAN_SUMMARY_PAGE,
					planSummaryPage);
			
		}
		
		
	}

	@Then("^the user validates plan summary page in AARP site$")
	public void validate_planSummary()
	{
		JSONObject planSummaryActualJson =(JSONObject) getLoginScenario().getBean(PlanSummaryCommonConstants.PLAN_SUMMARY_ACTUAL);
		System.out.println("planSummaryActualJson----->"+planSummaryActualJson);
		
		JSONObject planSummaryExpectedJson =(JSONObject) getLoginScenario().getBean(PlanSummaryCommonConstants.PLAN_SUMMARY_EXPECTED);
		System.out.println("planSummaryExpectedJson----->"+planSummaryExpectedJson);
		
		/* Validation */
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	@And("^the user adds the plan with following details in AARP site$")
	public void add_a_plan(DataTable userAttributes) {
		String newPlanMemberId = userAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario().getBean(CommonConstants.EXPECTED_DATA_MAP);
		PlanSummaryPage myPlanPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SUMMARY_PAGE);
		AddPlanPopUpPage addPlanPopUp = myPlanPage.clickAddPlan();
		ConfirmPlanDetailsPage confirmPlanDetailsPage = addPlanPopUp
				.addNewPlan(newPlanMemberId);
		if (confirmPlanDetailsPage != null) {
			
			
			try {
				JSONObject confirmPlanDetailsExpectedJson = confirmPlanDetailsPage.getExpectedJson(expectedDataMap);
				System.out.println("confirmPlanDetailsExpectedJson---->"+confirmPlanDetailsExpectedJson);
				
				JSONObject confirmPlanDetailsActualJson = confirmPlanDetailsPage.addPlanConfirmationJson;
				System.out.println("confirmPlanDetailsActualJson---->"+confirmPlanDetailsActualJson);
				JSONAssert.assertEquals(confirmPlanDetailsExpectedJson, confirmPlanDetailsActualJson, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		/*SecondPlanWithDocumentsPopupPage secondPlanWithDocumentsPopup = confirmPlanDetailsPage.confirm();
		
		SecondPlanInfoPopupPage secondPlanInfoPopup = secondPlanWithDocumentsPopup.confirm();
		
		AccountHomePage accountHomePage = secondPlanInfoPopup.navigateToAccountHome();

		/* Getting Expected data */
		
		
		

		/*JSONObject accountHomePageActualJson = null;
		if (accountHomePage != null) {
			accountHomePageActualJson = accountHomePage.accountHomeJson;
			
			JSONObject accountHomePageExpectedJson = accountHomePage
					.getAdditionalPlanExpectedData(expectedDataMap);
			
			getLoginScenario().saveBean(AddplanConstants.ACCOUNT_HOME_EXPECTED,
					accountHomePageExpectedJson);
			
			getLoginScenario().saveBean(AddplanConstants.ACCOUNT_HOME_ACTUAL,
					accountHomePageActualJson);

			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
		}*/
		

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
