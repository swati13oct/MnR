package acceptancetests.registration.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
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
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.registration.data.RegistrationConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */
public class RegistrationAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on registration page of AARP site$")
	public void registration_landing_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();

		RegistrationHomePage registrationHomePage = new RegistrationHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE,
				registrationHomePage);
	}
	
	@When("^the user registers with below details in AARP site$")
	public void user_registers(DataTable memberAttributes)
	{
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
	
	@When("^the user confirms the personal and plan information for the first plan in AARP site$")
	public void confirm_plan()
	{
		PlanConfirmationPage planConfirmationPage = (PlanConfirmationPage)getLoginScenario().getBean(PageConstants.PLAN_CONFIRMATION_PAGE);
		Object object = planConfirmationPage.confirmPlan();
		getLoginScenario().saveBean(RegistrationConstants.PAGE, object);
		
	}
	
	@And("^the user adds second plan with below information in AARP site$")
	public void add_second_plan(DataTable memberAttributes){
		

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String addditionaPlanId = memberAttributesMap.get("Additional Plan Member ID");
		AdditionalPlanPage additionalPlanPage = (AdditionalPlanPage)getLoginScenario().getBean(RegistrationConstants.PAGE);
		PlanConfirmationPage planConfirmationPage = additionalPlanPage.addAnotherPlan(addditionaPlanId);
		
		/*Get Actual response*/
		JSONObject planConfirmationActualJson = planConfirmationPage.planConfirmationJson;
		getLoginScenario().saveBean(RegistrationConstants.PLAN_CONFIRMATION_ACTUAL, planConfirmationActualJson);
		
		/*Get Expected response*/
		JSONObject firstPlanInformationExpected = (JSONObject) getLoginScenario().getBean(RegistrationConstants.PLAN_CONFIRMATION_EXPECTED);
		String dateOfBirth = (String)getLoginScenario().getBean(RegistrationConstants.DATE_OF_BIRTH);
		String key = addditionaPlanId + "_" + dateOfBirth;
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(key);
		JSONObject secondPlanInformationExpected = expectedDataMap
				.get(CommonConstants.PLAN_CONFIRMATION);
		JSONObject registrationCommonExpected = (JSONObject)getLoginScenario().getBean(RegistrationConstants.REGSITRATION_COMMON_EXPECTED);
		secondPlanInformationExpected = CommonUtility.mergeJson(secondPlanInformationExpected, registrationCommonExpected);
		System.out.println("secondPlanInformationExpected---->"+secondPlanInformationExpected);
		
		JSONObject planConfirmationExpectedJson = CommonUtility.concatenateJsons(firstPlanInformationExpected,secondPlanInformationExpected);
		System.out.println("planConfirmationExpectedJson for both plans---->"+planConfirmationExpectedJson);
		getLoginScenario().saveBean(RegistrationConstants.PLAN_CONFIRMATION_EXPECTED, planConfirmationExpectedJson);
		
		
	}
	
	@Then("^the user validates the the plan information for both plans in AARP site$")
	public void validate_both_planInformation()
	{
		JSONObject planConfirmationActualJson = (JSONObject)getLoginScenario().getBean(RegistrationConstants.PLAN_CONFIRMATION_ACTUAL);
		System.out.println("planConfirmationActualJson for both plans------------>"+planConfirmationActualJson);
		
		JSONObject planConfirmationExpectedJson = (JSONObject)getLoginScenario().getBean(RegistrationConstants.PLAN_CONFIRMATION_EXPECTED);
		System.out.println("planConfirmationExpectedJson for both plans------------>"+planConfirmationExpectedJson);
		
		try {
			JSONAssert.assertEquals(planConfirmationExpectedJson, planConfirmationActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("^the user confirms personal and plan information for both plans in AARP site$")
	public void confirm_planInformation_bothPlans()
	{
		PlanConfirmationPage planConfirmationPage = (PlanConfirmationPage)getLoginScenario().getBean(PageConstants.PLAN_CONFIRMATION_PAGE);
		Object object = planConfirmationPage.confirmPlan();
		getLoginScenario().saveBean(RegistrationConstants.PAGE, object);
		
	}
	
	@And("^the user registers with the following details in AARP site$")
	public void create_account(DataTable memberAttributes){
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		
		String userName = memberAttributesMap.get("Create a username");

		
		CreateAccountPage createAccountPage = (CreateAccountPage) getLoginScenario().getBean(RegistrationConstants.PAGE);
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
	
	@Then("^the user registers successfully with both the plans in AARP site$")
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
		registrationSuccessPage.logOut();
		
	}
	
	@Given("^the details of user to be registered in AARP site$")
	public void user_registered_with_details(DataTable memberAttributes) {

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
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
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

	@When("^the user confirms plan details in AARP site$")
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

	@When("^the user adds ship plan in AARP site$")
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

		String addditionaPlanId = memberAttributesMap
				.get("Additional Plan Member ID");
		
		PlanConfirmationPage planConfirmationPage = (PlanConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_CONFIRMATION_PAGE);

		AdditionalPlanPage additionalPlanPage = (AdditionalPlanPage) planConfirmationPage
				.confirmPlan();

		planConfirmationPage = additionalPlanPage
				.addAnotherPlan(addditionaPlanId);
		if (planConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_CONFIRMATION_PAGE,
					planConfirmationPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Additional Plan Confirmation Failed");
		}

	}

	/*@And("^the user registers with the following details in AARP site$")
	public void user_registers_with_provided_details(DataTable userAttributes) {
		 fetching given attributes with which the user registers 
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

		getLoginScenario().saveBean(
				RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED,
				registrationSuccessExpectedJson);
		getLoginScenario().saveBean(
				RegistrationConstants.REGISTRATION_SUCCESS_ACTUAL,
				registrationSuccessActualJson);

	}*/

	@Then("^the user registers successfully for both the plans in AARP site$")
	public void user_registers_successfully_both_plans() {

		RegistrationSuccessPage registrationSuccessPage = (RegistrationSuccessPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_SUCCESS_PAGE);

		JSONObject registrationSuccessExpectedJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED);

		JSONObject registrationSuccessActualJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.REGISTRATION_SUCCESS_ACTUAL);

		/* Validation */
		try {
			JSONAssert.assertEquals(registrationSuccessExpectedJson,
					registrationSuccessActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		registrationSuccessPage.logOut();

	}

	@Then("^the user registers successfully in AARP site$")
	public void user_registers_successfully() {

		RegistrationSuccessPage registrationSuccessPage = (RegistrationSuccessPage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_SUCCESS_PAGE);

		JSONObject registrationSuccessExpectedJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.REGISTRATION_SUCCESS_EXPECTED);

		JSONObject registrationSuccessActualJson = (JSONObject) getLoginScenario()
				.getBean(RegistrationConstants.REGISTRATION_SUCCESS_ACTUAL);

		/* Validation */
		try {
			JSONAssert.assertEquals(registrationSuccessExpectedJson,
					registrationSuccessActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		registrationSuccessPage.logOut();

	}


	/*@And("^the user confirms personal and plan information for both plans in AARP site$")
	public void user_confirms_plan_information_both_plans() {

		PlanConfirmationPage planConfirmationPage = (PlanConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_CONFIRMATION_PAGE);

		CreateAccountPage createAccountPage = (CreateAccountPage) planConfirmationPage
				.confirmPlan();

		if (createAccountPage != null) {
			getLoginScenario().saveBean(PageConstants.CREATE_ACCOUNT_PAGE,
					createAccountPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Additional Plan Confirmation Failed");
		}
	}*/

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
