/**
 * 
 */
package acceptancetests.plancompare.ulayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.PlanComparePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.plancompare.data.PlanCompareCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */
public class PlanCompareAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	
	
	@Before
	public void setup(){
		/*
		 * Format(MM-DD-YYYY) As plancompare page comes up in AEP period only,
		 * so hardcoded the below date
		 */
		String date = "09-29-2016";
		CommonUtility.changeMRRestTime(getLoginScenario(), date);
		CommonUtility.changePartDTime(getLoginScenario(), date);
	}

	@Given("^registered member for plan compare in AARP Site$")
	public void login_with_member(DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();

		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario
				.getAMPMemberWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario()
			.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);

		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
	JSONObject accountHomeActualJson = null;
		
		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
		accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);

	}

	@When("^the user navigates to plan compare page in AARP site$")
	public void the_user_navigates_plan_compare_aarp() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);

		PlanComparePage planComparePage = accountHomePage
				.navigateToPlanCompare();
		if (planComparePage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE,
					planComparePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("ERROR: loading planComparePage");
		}

	

	}



	@Then("^the user validates plan benefits for the same plan in current year and next year in AARP site$")
	public void validates_plan_benefits_for_same_plan_current_and_next_year_aarp() {

		PlanComparePage planComparePage = (PlanComparePage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);

		/* Get expected data */
		JSONObject planCompareActualJson = null;

		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		String key = PlanCompareCommonConstants.DEFAULT_COMPARISION;
		JSONObject planCompareExpectedJson = planComparePage.getExpectedData(
				expectedDataMap, key);

		/* Actual data */
		planCompareActualJson = planComparePage.planCompareJson;

		System.out.println("planCompareActualJson=====>"
				+ planCompareActualJson);
		System.out.println("planCompareExpectedJson=====>"
				+ planCompareExpectedJson);

		/* Validations */
		try {
			JSONAssert.assertEquals(planCompareExpectedJson,
					planCompareActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user selects a plan from next year plan choices dropdown in AARP site$")
	public void user_selects_plan_next_year_plan_choices_dropdown_aarp(
			DataTable memberAttributes) {

		String planName = memberAttributes.getGherkinRows().get(0).getCells()
				.get(0);

		PlanComparePage planComparePage = (PlanComparePage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);

		planComparePage = planComparePage.selectsPlanFromChoices(planName);

		if (planComparePage != null) {
			/* Get expected data */

			@SuppressWarnings("unchecked")
			Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
			.getBean(CommonConstants.EXPECTED_DATA_MAP);
			JSONObject planCompareExpectedJson = planComparePage
					.getExpectedData(expectedDataMap, planName);

			getLoginScenario().saveBean(
					PlanCompareCommonConstants.PLAN_COMPARE_EXPECTED,
					planCompareExpectedJson);

			/* Actual data */
			JSONObject planCompareActualJson = null;
			planCompareActualJson = planComparePage.planCompareJson;

			getLoginScenario().saveBean(
					PlanCompareCommonConstants.PLAN_COMPARE_ACTUAL,
					planCompareActualJson);

			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE,
					planComparePage);

		}

	}

	@Then("^the user validates plan benefits for the plans in current year and next year in AARP site$")
	public void validates_plan_benefits_for_plans_current_and_next_year_aarp() {

		PlanComparePage planComparePage = (PlanComparePage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);

		JSONObject planCompareActualJson = (JSONObject) getLoginScenario()
				.getBean(PlanCompareCommonConstants.PLAN_COMPARE_ACTUAL);

		JSONObject planCompareExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PlanCompareCommonConstants.PLAN_COMPARE_EXPECTED);

		System.out.println("planCompareActualJson=====>"
				+ planCompareActualJson);
		System.out.println("planCompareExpectedJson=====>"
				+ planCompareExpectedJson);

		/* Validations */
		try {
			JSONAssert.assertEquals(planCompareExpectedJson,
					planCompareActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		planComparePage.logOut();

	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		CommonUtility.resetMRRestTime(getLoginScenario());
		CommonUtility.resetPartDTime(getLoginScenario());
		getLoginScenario().flushBeans();
	}

}
