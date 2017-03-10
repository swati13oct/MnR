/**
 * 
 */
package acceptancetests.ordermaterials.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.OrderplanmaterialsPage;
import pages.member.ulayer.PlanMaterialConfirmationPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.ordermaterials.data.OrderPlanMaterialsCommonConstants;
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
public class OrderPlanMaterialsAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP member with following attributes$")
	public void registered_member_orderplanmaterials_aarp(
			DataTable memberAttributes) {

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
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);
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
	
	@When("^the user views order materials in AARP site$")
	public void views_order_materials_in_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage
				.navigateToOrderPlanMaterialsAarpPage();
		if (orderPlanMaterialsPage != null) {
			getLoginScenario().saveBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE,
					orderPlanMaterialsPage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Error in loading  orderPlanMaterialsPage");
		}
	}

	@And("^the user selects an option from the orderp list in AARP site$")
	public void user_selects_member_materials(DataTable givenAttributes) {

		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String option = givenAttributesMap.get("Option");
				
		PlanMaterialConfirmationPage planMaterialConfirmationPage = orderPlanMaterialsPage.selectsOption(option);
		
		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario().getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject planMaterialConfirmationExpectedJson = planMaterialConfirmationPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				OrderPlanMaterialsCommonConstants.PLAN_MATERIALS_CONFIRMATION_EXPECTED,
				planMaterialConfirmationExpectedJson);
		
		JSONObject planMaterialConfirmationActualJson = null;
		if (planMaterialConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_MATERIALS_CONFIRMATION_PAGE,
					planMaterialConfirmationPage);
			Assert.assertTrue(true);
			planMaterialConfirmationActualJson = planMaterialConfirmationPage.planMaterialsConfirmationJson;
		}
		
		getLoginScenario().saveBean(
				OrderPlanMaterialsCommonConstants.PLAN_MATERIALS_CONFIRMATION_ACTUAL,
				planMaterialConfirmationActualJson);
		
	}

	@Then("^the user validates the plan materials under plan document section in AARP site$")
	public void validates_plan_materials_plan_document_section_ums() {
		PlanMaterialConfirmationPage planMaterialConfirmationPage = (PlanMaterialConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_MATERIALS_CONFIRMATION_PAGE);
	
		JSONObject planMaterialsConfirmationActualJson = (JSONObject) getLoginScenario().getBean("planMaterialsConfirmationActualJson");
		JSONObject planMaterialsConfirmationExpectedJson = (JSONObject) getLoginScenario().getBean("planMaterialsConfirmationExpectedJson");
		try {
			JSONAssert.assertEquals(planMaterialsConfirmationExpectedJson,
					planMaterialsConfirmationActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		planMaterialConfirmationPage.logOut();

	}

	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		if(wd!=null){
			wd.quit();
		}
		getLoginScenario().flushBeans();
	}

	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}