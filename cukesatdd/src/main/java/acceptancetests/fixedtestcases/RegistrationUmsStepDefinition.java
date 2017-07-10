package acceptancetests.fixedtestcases;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
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
import pages.acquisition.bluelayer.RegistrationUMSErrorPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.registration.data.RegistrationConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
	
	
	@Given("^the user is on registration page of UMS site$")
	public void registration_landing_page(DataTable memberAttributes)
	{
		
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String userName = memberAttributesMap.get("User Name");
		
		CommonUtility.deRegister(getLoginScenario(),userName);
		
		WebDriver wd = getLoginScenario().getWebDriver();

		RegistrationHomePage registrationHomePage = new RegistrationHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE,
				registrationHomePage);
	}
	
	@When("^the user registers with below details in UMS site$")
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
		
		
	}
	
	@Then("^the user validates the plan information on plan confirmation page in UMS site$")
	public void validate_planInformation(){
		//TODO
	}
	
	@When("^the user confirms the personal and plan information in UMS site$")
	public void confirm_plan()
	{
		PlanConfirmationPage planConfirmationPage = (PlanConfirmationPage)getLoginScenario().getBean(PageConstants.PLAN_CONFIRMATION_PAGE);
		Object object = planConfirmationPage.confirmPlan();
		getLoginScenario().saveBean(RegistrationConstants.PAGE, object);
		
	}
	
	@And("^the user adds second plan with below information in UMS site$")
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
		
		
		
	}
	
	@Then("^the user validates the the plan information for both plans in UMS site$")
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


	@When("^the user confirms personal and plan information for both plans in UMS site$")
	public void confirm_planInformation_bothPlans()
	{
		PlanConfirmationPage planConfirmationPage = (PlanConfirmationPage)getLoginScenario().getBean(PageConstants.PLAN_CONFIRMATION_PAGE);
		Object object = planConfirmationPage.confirmPlan();
		getLoginScenario().saveBean(RegistrationConstants.PAGE, object);
		
	}

	@And("^the user registers with the following details in UMS site$")
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
		getLoginScenario().saveBean(RegistrationConstants.USER_NAME,
				userName);
		CreateAccountPage createAccountPage = (CreateAccountPage) getLoginScenario().getBean(RegistrationConstants.PAGE);
		RegistrationSuccessPage registrationSuccessPage = createAccountPage.createAccount(memberAttributesMap);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_SUCCESS_PAGE, registrationSuccessPage);
		
		/*Get Actual response*/
		JSONObject registrationSuccessActualJson = registrationSuccessPage.registrationSuccessJson;
		getLoginScenario().saveBean(RegistrationConstants.REGISTRATION_SUCCESS_ACTUAL, registrationSuccessActualJson);
		
	}
	
	@Then("^the user registers successfully in UMS site$")
	public void register_successfully()
	{
		RegistrationSuccessPage registrationSuccessPage = (RegistrationSuccessPage)getLoginScenario().getBean(PageConstants.REGISTRATION_SUCCESS_PAGE);
		if (registrationSuccessPage.validateRegistrationSuccessPage()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading registration success page");
		}

	//	registrationSuccessPage.logOut();

		
	}
	
	@When("^the user registers with dob and memberId in UMS site$")
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
	
	@Then("^the user navigate to error page$")
	public void negativeScenario() {
		RegistrationHomePage registrationHomePage = (RegistrationHomePage) getLoginScenario()
				.getBean(PageConstants.REGISTRATION_HOME_PAGE);
		RegistrationUMSErrorPage registrationUMSErrorPage = registrationHomePage.navigateToErrorPage();
		
		getLoginScenario().saveBean(PageConstants.REGISTRATION_ERROR_PAGE, registrationUMSErrorPage);

		/* Get Actual response */
		JSONObject regErrorActualJson = registrationUMSErrorPage.regErrorPageJson;
		getLoginScenario().saveBean(RegistrationConstants.REG_ERROR_PAGE_ACTUAL, regErrorActualJson);
		
		/* Get Expected response */
		String fileName = "registrationfailure";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY + File.separator + CommonConstants.SITE_BLUELAYER
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

/*	@After("@Registration")
	public void deRegister(){
		String userName = (String) getLoginScenario().getBean(RegistrationConstants.USER_NAME);
		if(null != userName){
			getLoginScenario().removeMember(userName);
		}
	}*/

}
