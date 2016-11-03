package acceptancetests.registration.ulayer;

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

import pages.acquisition.ulayer.AdditionalPlanPage;
import pages.acquisition.ulayer.CreateAccountPage;
import pages.acquisition.ulayer.PlanConfirmationPage;
import pages.acquisition.ulayer.RegistrationAARPErrorPage;
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
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		RegistrationHomePage registrationHomePage = new RegistrationHomePage(wd);
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
	
	@When("^the user confirms the personal and plan information in AARP site$")
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
	
	@When("^the user registers with dob and memberId in AARP site$")
	public void user_register(DataTable memberAttributes)
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
	}
	
	@Then("^the user navigate to registration error page of AARP site$")
	public void negativeScenario_aarp() {
		RegistrationHomePage registrationHomePage = (RegistrationHomePage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_HOME_PAGE);
		RegistrationAARPErrorPage registrationAARPErrorPage = registrationHomePage.navigateToErrorPage();
		
		getLoginScenario().saveBean(PageConstants.REGISTRATION_ERROR_PAGE, registrationAARPErrorPage);

		/* Get Actual response */
		JSONObject regErrorActualJson = registrationAARPErrorPage.regErrorPageJson;
		getLoginScenario().saveBean(RegistrationConstants.REG_ERROR_PAGE_ACTUAL, regErrorActualJson);
		
		/* Get Expected response */
		String fileName = "registrationfailure";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY + File.separator + CommonConstants.SITE_ULAYER
				+ File.separator + CommonConstants.REG_FAILURE_FLOW_NAME + File.separator;
		JSONObject registrationFailureExpectedJson = MRScenario.readExpectedJson(fileName, directory);
		getLoginScenario().saveBean(RegistrationConstants.REG_FAILURE_EXPECTED, registrationFailureExpectedJson);

	}
	
	@Then("^the user validate registration error message of AARP site$")
	public void validate_ErrorMessage_aarp() {
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
	
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
