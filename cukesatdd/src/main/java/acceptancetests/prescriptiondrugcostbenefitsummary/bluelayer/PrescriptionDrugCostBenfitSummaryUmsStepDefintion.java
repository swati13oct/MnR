/**
 * 
 */
package acceptancetests.prescriptiondrugcostbenefitsummary.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
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

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.DrugCostandBenefitSummaryPage;
import pages.member.bluelayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.prescriptiondrugcostbenefitsummary.data.DrugCostBenefitsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */
public class PrescriptionDrugCostBenfitSummaryUmsStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered UHC with following details for Drug Costs & Benefits Summary flow$")
	public void registered_UMS_with_attributes_payment(
			DataTable memberAttributes) {

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

		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);
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
		loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		AccountHomePage accountHomePage = (AccountHomePage) loginPage
				.checkLoginSuccessful();
		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		/* get actual data */
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}
		System.out.println("accountHomeActualJson====>"
				+ accountHomeActualJson.toString());
		System.out.println("accountHomeExpectedJson====>"
				+ accountHomeExpectedJson.toString());

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);

	}

	@When("^the user navigates to Prescription Drug Costs & Benefits Summary in my menu in UMS site$")
	public void user_views_plan_summary_ums() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		DrugCostandBenefitSummaryPage drugCostandBenefitSummaryPage = accountHomePage
				.navigateToPrescriptionDrugCostPage();

		/* Get expected data */

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
			getLoginScenario().saveBean(
					DrugCostBenefitsCommonConstants.DRUG_COST_BENEFIT_ACTUAL,
					drugCostBenefitSummaryActualJson);
		}

	}

	@Then("^the user validates prescription drug cost and benefit summary page in UMS site$")
	public void user_validates_drugcost_benefit_summary_ums() {
		DrugCostandBenefitSummaryPage drugCostandBenefitSummaryPage = (DrugCostandBenefitSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_BENEFITS_SUMMARY_PAGE);

		JSONObject drugCostBenefitSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(
						DrugCostBenefitsCommonConstants.DRUG_COST_BENEFIT_EXPECTED);
		JSONObject drugCostBenefitSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(
						DrugCostBenefitsCommonConstants.DRUG_COST_BENEFIT_ACTUAL);

		System.out.println("drugCostBenefitSummaryExpectedJson====>"
				+ drugCostBenefitSummaryExpectedJson.toString());
		System.out.println("drugCostBenefitSummaryActualJson====>"
				+ drugCostBenefitSummaryActualJson.toString());

		/* Validating */
		try {
			JSONAssert.assertEquals(drugCostBenefitSummaryExpectedJson,
					drugCostBenefitSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		drugCostandBenefitSummaryPage.logOut();
	}

}
