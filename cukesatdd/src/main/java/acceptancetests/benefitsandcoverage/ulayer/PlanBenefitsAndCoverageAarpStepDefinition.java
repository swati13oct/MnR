/**
 * 
 */
package acceptancetests.benefitsandcoverage.ulayer;


import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.PlanBenefitsCoveragePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;


/**
 * @author pagarwa5
 *
 */
public class PlanBenefitsAndCoverageAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP with following details for plan benefits and coverage flow in AARP site$")
	public void login_with_member(DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String,String> loginCreds = loginScenario
				.getAMPMemberWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a "+ desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd );
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}


		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;

		/*Get expected data*/
		Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage.getExpectedData(expectedDataMap);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson, accountHomeActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);

	}

	@Given("^registered member to login in AARP site$")
	public void registered_member_AARP(DataTable memberAttributes){
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

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
		}

			}

	@When("^the user navigates to plan benefits and coverage in AARP site$")
	public void views_benefits_and_Coverage() {
		Map<String,JSONObject> expectedDataMap =(Map<String, JSONObject>) getLoginScenario().getBean(CommonConstants.EXPECTED_DATA_MAP);
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PlanBenefitsCoveragePage bncPage = accountHomePage.navigateToBnC();
		JSONObject benefitsExpectedJson = bncPage.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED, benefitsExpectedJson);
		JSONObject benefitsActualJson = bncPage.planBenefitsCoverageJson;
		System.out.println("benefitsExpectedJson---->"+benefitsExpectedJson);
		System.out.println("benefitsActualJson---->"+benefitsActualJson);
		getLoginScenario().saveBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL, benefitsActualJson);
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE,bncPage);

		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, bncPage);

	}

	@When("^the user navigates to benefits and coverage page under my plans in AARP site$")
	public void benefits_and_coverage_AARP(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PlanBenefitsCoveragePage bncPage = accountHomePage.navigateToBnC();
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, bncPage);		
	}


	@Then("^the user validates benefits and coverage of the member in AARP site$")
	public void details_validation() {
		PlanBenefitsCoveragePage bncPage = (PlanBenefitsCoveragePage)getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		JSONObject benefitsActualJson = (JSONObject) getLoginScenario().getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL);
		JSONObject benefitsExpectedJson = (JSONObject) getLoginScenario().getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED);
		try {
			JSONAssert.assertEquals(benefitsExpectedJson, benefitsActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bncPage.logOut();

	}
	
	@Then("^the user validates pharmacy saver widget in AARP site$")
	public void pharmacy_saver_widget_AARP(){
		PlanBenefitsCoveragePage bncPage = (PlanBenefitsCoveragePage)getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		bncPage.validatePharmacySaverWidget();
		bncPage.logOut();
	}
	
	@Then("^the user validates drug cost table in AARP site$")
	public void drug_cost_table_AARP(){
		/*List<DataTableRow> preferredRetailAttributesRow = preferredAttributes
				.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < preferredRetailAttributesRow.size(); i++) {

			personalAttributesMap.put(preferredRetailAttributesRow.get(i).getCells()
					.get(0), preferredRetailAttributesRow.get(i).getCells().get(1));
		}

		String benefit = personalAttributesMap.get("Benefit");*/
		PlanBenefitsCoveragePage bncPage = (PlanBenefitsCoveragePage)getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		bncPage.validateStandardDrugCostTable();
		bncPage.validatePrefferedRetailDrugCostTable();
		bncPage.logOut();
		
	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
	}
}
