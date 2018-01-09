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
import pages.member.bluelayer.SecondPlanInfoPage;
import acceptancetests.addplan.data.AddplanConstants;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
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
	
	@Given("^the user is on the UHC medicare site registration page$")
	public void registration_homePage(){
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		RegistrationHomePage registrationHomePage = new RegistrationHomePage(wd);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE, registrationHomePage);
	}

	
	@When("^the user registers in UHC site with a group plan and following details$")
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
		
		String category = "Group";
		getLoginScenario().saveBean(CommonConstants.CATEGORY, category);
		
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
	
	@Then("^the user validates the plan information on plan confirmation page in UHC site$")
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
	
	@When("^the user confirms the plan details in UHC site$")
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

	@And("^the user performs add no other plan in UHC site$")
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


	@And("^the user registers with following details in UHC site$")
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
		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
		JSONObject registrationCommonExpected = (JSONObject)getLoginScenario().getBean(RegistrationConstants.REGSITRATION_COMMON_EXPECTED);
		JSONObject registrationSuccessExpectedJson = registrationSuccessPage
				.getExpectedData(expectedDataMap, registrationCommonExpected);
		
		getLoginScenario().saveBean(RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED, registrationSuccessExpectedJson);


	}
	
	@Then("^the user registers successfully in UHC site$")
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
	
	
	@When("^the user navigates to homepage in UHC site$")
	public void navigates_to_homePage() {
		RegistrationSuccessPage registrationSuccessPage = (RegistrationSuccessPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_SUCCESS_PAGE);
		String category =(String) getLoginScenario().getBean(CommonConstants.CATEGORY);
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

	@Then("^the user validates account home page in UHC site$")
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
	
	@When("^the user navigates to myPlans in UHC site$")
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

	@Then("^the user validates plan summary page in UHC site$")
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


	@And("^the user adds the plan with following details in UHC site$")
	public void add_a_plan(DataTable userAttributes) {
		String newPlanMemberId = userAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		PlanSummaryPage myPlanPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SUMMARY_PAGE);
		AddPlanPopUpPage addPlanPopUp = myPlanPage.clickAddPlan();
		ConfirmPlanDetailsPage confirmPlanDetailsPage = addPlanPopUp
				.addNewPlan(newPlanMemberId);
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario().getBean(CommonConstants.EXPECTED_DATA_MAP);
		if (confirmPlanDetailsPage != null) {
			getLoginScenario().saveBean(
					PageConstants.CONFIRM_PLAN_DETAILS_PAGE,
					confirmPlanDetailsPage);
			JSONObject confirmPlanDetailsActual = confirmPlanDetailsPage.addPlanConfirmationJson;
			JSONObject confirmPlanDetailsExpected = confirmPlanDetailsPage.getExpectedData(expectedDataMap);
			
			try {
				JSONAssert.assertEquals(confirmPlanDetailsExpected, confirmPlanDetailsActual, true);
			} catch (JSONException e) {
				System.out.println("Assertion Error, comparing confirmPlanDetails json"+e);
			}
		} 
		
		String category = (String)getLoginScenario().getBean(CommonConstants.CATEGORY);
		SecondPlanInfoPage secondPlanInfoPage = confirmPlanDetailsPage.confirm();
		
		/*Comparing actual and expected information of second plan added */
		JSONObject secondPlanInfoActualJson = secondPlanInfoPage.secondPlanInfoJson;
		System.out.println("secondPlanInfoActualJson---->"+secondPlanInfoActualJson);
		
		JSONObject secondPlanInfoExpectedJson = secondPlanInfoPage.getExpectedData(expectedDataMap);
		System.out.println("secondPlanInfoExpectedJson---->"+secondPlanInfoExpectedJson);
		try {
			JSONAssert.assertEquals(secondPlanInfoExpectedJson, secondPlanInfoActualJson, true);
		} catch (JSONException e) {
			System.out.println("Assertion Error, comparing secondPlanInfo json"+e);
		}
		
		AccountHomePage accountHomePage = secondPlanInfoPage.navigateToAccountHome(category);
		
		/* Getting Expected data */
		

		JSONObject accountHomePageActualJson = null;
		if (accountHomePage != null) {
			accountHomePageActualJson = accountHomePage.accountHomeJson;
			
			getLoginScenario().saveBean(AddplanConstants.ACCOUNT_HOME_ACTUAL,
					accountHomePageActualJson);

			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			JSONObject accountHomePageExpectedJson = accountHomePage
					.getAdditionalPlanExpectedData(expectedDataMap);
			getLoginScenario().saveBean(AddplanConstants.ACCOUNT_HOME_EXPECTED,
					accountHomePageExpectedJson);
		}
		

	}

	

	@Then("^the user validates the plan names of both the plan added in UHC site$")
	public void validates_plandetails_ums() {
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

}
