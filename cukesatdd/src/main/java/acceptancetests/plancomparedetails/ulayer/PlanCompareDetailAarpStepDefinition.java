/**
 * 
 */
package acceptancetests.plancomparedetails.ulayer;

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
import pages.member.ulayer.PlanCompareDetails;
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
public class PlanCompareDetailAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
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

	@And("^the user selects a plan from next year plan choice in AARP site$")
	public void user_selects_plan_next_year_plan_choice_aarp() {


		PlanComparePage planComparePage = (PlanComparePage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);

		PlanCompareDetails planCompareDetails = planComparePage.selectNextYearPlan();
		
		if (planCompareDetails != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_DETAILS, planCompareDetails);
			Assert.assertTrue(true);
		}
	}

	@Then("^the user validates preferred network for next year in AARP site$")
	public void validates_plan_benefits_for_plans_current_and_next_year_aarp() {
		
		PlanCompareDetails planCompareDetails = (PlanCompareDetails) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_DETAILS);

		Assert.assertTrue(planCompareDetails.isPreferredNetwork());
	}
	
	@Then("^the user validates preferred network for next year MAPD in AARP site$")
	public void the_user_validates_preferred_network_for_next_year_MAPD_in_AARP_site() {
		PlanCompareDetails planCompareDetails = (PlanCompareDetails) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_DETAILS);

		Assert.assertTrue(planCompareDetails.isPreferredNetworkMAPD());
	}

	@Then("^the user validates pharmacy saver for next year MAPD in AARP site$")
	public void the_user_validates_pharmacy_saver_for_next_year_MAPD_in_AARP_site() {
		PlanCompareDetails planCompareDetails = (PlanCompareDetails) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_DETAILS);

		Assert.assertTrue(planCompareDetails.isPharmacySaver());
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
