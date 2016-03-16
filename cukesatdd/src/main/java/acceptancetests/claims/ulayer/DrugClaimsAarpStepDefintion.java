package acceptancetests.claims.ulayer;

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

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.DrugClaimDetailsPage;
import pages.member.ulayer.DrugClaimSummaryPage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.TerminatedHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
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
public class DrugClaimsAarpStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the registered AMP with following attributes in AARP site for drug claims$")
	public void registered_AMP_with_attributes_drug_claims_aarp(
			DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String businessType = null;
		if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")
				|| planType.equalsIgnoreCase("PDP")) {
			businessType = "GOVT";
		} else {
			businessType = "SHIP";
		}
		getLoginScenario().saveBean(ClaimsCommonConstants.BUSINESS_TYPE,
				businessType);

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				if (!memberAttributesMap.get(key).isEmpty()) {
					desiredAttributes.add(memberAttributesMap.get(key));
				}
			}
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
		loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		AccountHomePage accountHomePage = (AccountHomePage) loginPage
				.checkLoginSuccessful();
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

	@When("^the user navigates to claim summary page in AARP site for drug claims$")
	public void user_views_drug_claim_summary_aarp() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		DrugClaimSummaryPage drugClaimSummaryPage = accountHomePage
				.navigateToDrugClaimsSummary();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);

		/*
		 * We are setting claimPeriod 'Last 90 days' because by default claim
		 * period will be Last 90 days when Claim summary page loads first time
		 */
		String claimPeriod = "Last 90 Days";
		JSONObject drugClaimSummaryExpectedJson = drugClaimSummaryPage
				.getExpectedData(expectedDataMap, claimPeriod);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_EXPECTED,
				drugClaimSummaryExpectedJson);

		JSONObject drugClaimSummaryActualJson = null;
		if (drugClaimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					drugClaimSummaryPage);
			Assert.assertTrue(true);
			drugClaimSummaryActualJson = drugClaimSummaryPage.drugClaimsSummaryJson;
		}

		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_ACTUAL,
				drugClaimSummaryActualJson);

		/* Validating Claims for default period i.e. Last 90 days */
		try {
			JSONAssert.assertEquals(drugClaimSummaryExpectedJson,
					drugClaimSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user search drug claims for the following claim period in AARP site$")
	public void user_drug_claims_following_period_aarp(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		String claimPeriod = timeAttributesRow.get(0).getCells().get(0);
		DrugClaimSummaryPage drugClaimSummaryPage = (DrugClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		drugClaimSummaryPage = drugClaimSummaryPage
				.searchDrugClaimsByPeriod(claimPeriod);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);

		JSONObject drugClaimSummaryExpectedJson = drugClaimSummaryPage
				.getExpectedData(expectedDataMap, claimPeriod);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_EXPECTED,
				drugClaimSummaryExpectedJson);

		JSONObject drugClaimSummaryActualJson = null;
		if (drugClaimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					drugClaimSummaryPage);
			Assert.assertTrue(true);
			drugClaimSummaryActualJson = drugClaimSummaryPage.drugClaimsSummaryJson;
		}

		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_ACTUAL,
				drugClaimSummaryActualJson);

	}

	@When("^user searches the drug claims for following time interval in AARP site$")
	public void user_drug_claims_time_interval_aarp(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		String toDate = timeAttributesMap.get(ClaimsCommonConstants.CLAIMS_TO_DATE);
		String fromDate = timeAttributesMap.get(ClaimsCommonConstants.CLAIMS_FROM_DATE);

		DrugClaimSummaryPage drugClaimSummaryPage = (DrugClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		drugClaimSummaryPage = drugClaimSummaryPage
				.searchDrugClaimsByTimeInterval(toDate, fromDate);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);

		JSONObject drugClaimSummaryExpectedJson = drugClaimSummaryPage
				.getExpectedData(expectedDataMap, toDate, fromDate);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_EXPECTED,
				drugClaimSummaryExpectedJson);

		JSONObject drugClaimSummaryActualJson = null;
		if (drugClaimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					drugClaimSummaryPage);
			Assert.assertTrue(true);
			drugClaimSummaryActualJson = drugClaimSummaryPage.drugClaimsSummaryJson;
		}

		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_ACTUAL,
				drugClaimSummaryActualJson);

	}

	@Then("^user validates the drug claims displayed based on the selection in AARP site$")
	public void validates_drug_claims_summary_aarp() {

		JSONObject drugClaimSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_ACTUAL);
		JSONObject drugClaimSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_EXPECTED);

		/* Validating Claims-Summary */
		try {
			JSONAssert.assertEquals(drugClaimSummaryExpectedJson,
					drugClaimSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@When("^user views drug claim details for individual claim in AARP site$")
	public void user_views_drug_claims_details_aarp() {
		DrugClaimSummaryPage drugClaimSummaryPage = (DrugClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		String firstRxNumber = drugClaimSummaryPage.getRxNumber();

		DrugClaimDetailsPage drugClaimDetailsPage = drugClaimSummaryPage
				.getDrugClaimDetail();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject drugClaimDetailsExpectedJson = drugClaimDetailsPage
				.getExpectedData(expectedDataMap, firstRxNumber);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_DETAILS_EXPECTED,
				drugClaimDetailsExpectedJson);

		JSONObject drugClaimDetailsActualJson = null;
		if (drugClaimDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_DETAILS_PAGE,
					drugClaimDetailsPage);
			Assert.assertTrue(true);
			drugClaimDetailsActualJson = drugClaimDetailsPage.drugClaimDetailJson;
		}
		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_DETAILS_ACTUAL,
				drugClaimDetailsActualJson);

	}

	@Then("^user validates the following drug claim details for a claim in AARP site$")
	public void user_validates_drug_claim_details_aarp() {
		DrugClaimDetailsPage drugClaimDetailsPage = (DrugClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_DETAILS_PAGE);

		JSONObject drugClaimDetailsActualJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.DRUG_CLAIM_DETAILS_ACTUAL);
		JSONObject drugClaimDetailsExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.DRUG_CLAIM_DETAILS_EXPECTED);

		/* Validating Claims details for a specific claim */
		try {
			JSONAssert.assertEquals(drugClaimDetailsExpectedJson,
					drugClaimDetailsActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		drugClaimDetailsPage.logOut();
	}

	/*******************************************************
	      Below steps are Terminated member specific
	 ******************************************************/

	@Given("^the registered AMP with following attributes for terminated members in AARP site for drug claims$")
	public void registered_AMP_with_attributes_drug_claims_terminated_aarp(
			DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String BusinessType = null;
		if (memberAttributesMap.get("Plan Type").equalsIgnoreCase("MA")
				|| memberAttributesMap.get("Plan Type")
				.equalsIgnoreCase("MAPD")
				|| memberAttributesMap.get("Plan Type").equalsIgnoreCase("PDP")) {
			BusinessType = "GOVT";
		} else {
			BusinessType = "SHIP";
		}
		getLoginScenario().saveBean("Business Type", BusinessType);
		getLoginScenario().saveBean("Plan Type",
				memberAttributesMap.get("Plan Type"));
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				if (!memberAttributesMap.get(key).isEmpty()) {
					desiredAttributes.add(memberAttributesMap.get(key));
				}
			}
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
		loginPage.loginWith(userName, pwd);

		TerminatedHomePage TerminatedHomePage = (TerminatedHomePage) loginPage
				.checkLoginSuccessful();
		if (TerminatedHomePage != null) {
			getLoginScenario().saveBean(PageConstants.TERMINATED_HOME_PAGE,
					TerminatedHomePage);
			Assert.assertTrue(true);
		}

		else {
			Assert.fail("Login was not successful");
		}
	}

	@When("^the user navigates to drug claim summary page for terminated members in AARP site for drug claims$")
	public void user_views_drug_claim_summary_terminated_aarp() {
		TerminatedHomePage TerminatedHomePage = (TerminatedHomePage) getLoginScenario()
				.getBean(PageConstants.TERMINATED_HOME_PAGE);
		DrugClaimSummaryPage drugClaimSummaryPage = TerminatedHomePage
				.navigateToDrugClaimsSummary();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);

		/*
		 * We are setting claimPeriod 'Last 90 days' because by default claim
		 * period will be Last 90 days when Claim summary page loads first time
		 */
		String claimPeriod = "Last 90 Days";
		JSONObject drugClaimSummaryExpectedJson = drugClaimSummaryPage
				.getExpectedData(expectedDataMap, claimPeriod);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_EXPECTED,
				drugClaimSummaryExpectedJson);

		JSONObject drugClaimSummaryActualJson = null;
		if (drugClaimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					drugClaimSummaryPage);
			Assert.assertTrue(true);
			drugClaimSummaryActualJson = drugClaimSummaryPage.drugClaimsSummaryJson;
		}

		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_ACTUAL,
				drugClaimSummaryActualJson);

		/* Validating Claims for default period i.e. Last 90 days */
		try {
			JSONAssert.assertEquals(drugClaimSummaryExpectedJson,
					drugClaimSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user search drug claims for the following claim period for terminated members in AARP site$")
	public void user_drug_claims_following_period_terminated_aarp(
			DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		String claimPeriod = timeAttributesRow.get(0).getCells().get(0);

		DrugClaimSummaryPage drugClaimSummaryPage = (DrugClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean("Plan Type");

		drugClaimSummaryPage = drugClaimSummaryPage.searchDrugClaimsByPeriod(
				claimPeriod, planType);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);

		JSONObject drugClaimSummaryExpectedJson = drugClaimSummaryPage
				.getExpectedData(expectedDataMap, claimPeriod);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_EXPECTED,
				drugClaimSummaryExpectedJson);

		JSONObject drugClaimSummaryActualJson = null;
		if (drugClaimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					drugClaimSummaryPage);
			Assert.assertTrue(true);
			drugClaimSummaryActualJson = drugClaimSummaryPage.drugClaimsSummaryJson;
		}

		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_ACTUAL,
				drugClaimSummaryActualJson);

	}

	@When("^user searches the drug claims for following time interval for terminated members in AARP site$")
	public void user_drug_claims_time_interval_terminated_aarp(
			DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		String toDate = timeAttributesMap.get("Claims To Date");
		String fromDate = timeAttributesMap.get("Claims From Date");

		DrugClaimSummaryPage drugClaimSummaryPage = (DrugClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean("Plan Type");
		drugClaimSummaryPage = drugClaimSummaryPage
				.searchDrugClaimsByTimeInterval(toDate, fromDate, planType);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);

		JSONObject drugClaimSummaryExpectedJson = drugClaimSummaryPage
				.getExpectedData(expectedDataMap, toDate, fromDate);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_EXPECTED,
				drugClaimSummaryExpectedJson);

		JSONObject drugClaimSummaryActualJson = null;
		if (drugClaimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					drugClaimSummaryPage);
			Assert.assertTrue(true);
			drugClaimSummaryActualJson = drugClaimSummaryPage.drugClaimsSummaryJson;
		}

		getLoginScenario().saveBean(
				ClaimsCommonConstants.DRUG_CLAIM_SUMMARY_ACTUAL,
				drugClaimSummaryActualJson);

		/* Validating Claims for entered Claim period */
		try {
			JSONAssert.assertEquals(drugClaimSummaryExpectedJson,
					drugClaimSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}
}
