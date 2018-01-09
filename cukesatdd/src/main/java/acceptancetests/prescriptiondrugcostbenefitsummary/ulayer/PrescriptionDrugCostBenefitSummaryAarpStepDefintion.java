/**
 * 
 */
package acceptancetests.prescriptiondrugcostbenefitsummary.ulayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.DrugCostandBenefitSummaryPage;
import pages.member.ulayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.prescriptiondrugcostbenefitsummary.data.DrugCostBenefitsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */
public class PrescriptionDrugCostBenefitSummaryAarpStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP with following details for Drug Costs & Benefits Summary flow$")
	public void registered_AMP_with_attributes_payment(
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

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		

		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
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

	@When("^the user clicks Prescription Drug Costs & Benefits Summary in my menu in AARP site$")
	public void user_views_plan_summary_aarp() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		DrugCostandBenefitSummaryPage drugCostandBenefitSummaryPage = accountHomePage
				.navigateToPrescriptionDrugCostPage();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject drugCostBenefitSummaryExpectedJson = drugCostandBenefitSummaryPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				DrugCostBenefitsCommonConstants.DRUG_COST_BENEFIT_EXPECTED,
				drugCostBenefitSummaryExpectedJson);

		JSONObject drugCostBenefitSummaryActualJson = null;
		if (drugCostandBenefitSummaryPage != null) {
			getLoginScenario().saveBean(
					PageConstants.DRUG_COST_BENEFITS_SUMMARY_PAGE,
					drugCostandBenefitSummaryPage);
			Assert.assertTrue(true);
			drugCostBenefitSummaryActualJson = drugCostandBenefitSummaryPage.drugCostBenefitSummaryJson;
		}
		getLoginScenario().saveBean(
				DrugCostBenefitsCommonConstants.DRUG_COST_BENEFIT_ACTUAL,
				drugCostBenefitSummaryActualJson);
	}

	@Then("^the user validates prescription drug cost and benefit summary page in AARP site$")
	public void user_validates_drugcost_benefit_summary_aarp() {
		DrugCostandBenefitSummaryPage drugCostandBenefitSummaryPage = (DrugCostandBenefitSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_BENEFITS_SUMMARY_PAGE);

		JSONObject drugCostBenefitSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(
						DrugCostBenefitsCommonConstants.DRUG_COST_BENEFIT_EXPECTED);
		JSONObject drugCostBenefitSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(
						DrugCostBenefitsCommonConstants.DRUG_COST_BENEFIT_ACTUAL);

		/* Validating */
		try {
			JSONAssert.assertEquals(drugCostBenefitSummaryExpectedJson,
					drugCostBenefitSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		drugCostandBenefitSummaryPage.logOut();
	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean("webDriver");
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
