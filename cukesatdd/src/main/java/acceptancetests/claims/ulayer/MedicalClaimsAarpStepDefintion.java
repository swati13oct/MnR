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
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.MedicalClaimDetailsPage;
import pages.member.ulayer.MedicalClaimSummaryPage;
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
public class MedicalClaimsAarpStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the registered AMP with following attributes in AARP site for medical claims$")
	public void registered_AMP_with_attributes_medical_claims_aarp(
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
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
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

	@When("^the user navigates to claim summary page in AARP site$")
	public void user_views_claim_summary_aarp() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MedicalClaimSummaryPage medicalClaimSummaryPage = accountHomePage
				.navigateToMedicalClaimsSummary();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);

		/*
		 * We are setting claimPeriod 'Last 90 days' because by default claim
		 * period will be Last 90 days when Claim summary page loads first time
		 */
		String claimPeriod = ClaimsCommonConstants.LAST_90_DAYS;
		JSONObject medicalClaimSummaryExpectedJson = medicalClaimSummaryPage
				.getExpectedData(expectedDataMap, claimPeriod);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.MEDICAL_CLAIM_SUMMARY_EXPECTED,
				medicalClaimSummaryExpectedJson);

		JSONObject medicalClaimSummaryActualJson = null;
		if (medicalClaimSummaryPage != null) {
			getLoginScenario().saveBean(
					PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE,
					medicalClaimSummaryPage);
			Assert.assertTrue(true);
			medicalClaimSummaryActualJson = medicalClaimSummaryPage.medicalClaimsSummaryJson;
		}

		getLoginScenario().saveBean(
				ClaimsCommonConstants.MEDICAL_CLAIM_SUMMARY_ACTUAL,
				medicalClaimSummaryActualJson);

		/* Validating Medical Claims for default period i.e. Last 90 days */
		try {
			JSONAssert.assertEquals(medicalClaimSummaryExpectedJson,
					medicalClaimSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@And("^user searches the claims for the following claim period in AARP site$")
	public void user_claims_following_period_aarp(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		String claimPeriod = timeAttributesRow.get(0).getCells().get(0);
		MedicalClaimSummaryPage medicalClaimSummaryPage = (MedicalClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE);
		medicalClaimSummaryPage = medicalClaimSummaryPage
				.searchClaimsByPeriod(claimPeriod);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);

		JSONObject medicalClaimSummaryExpectedJson = medicalClaimSummaryPage
				.getExpectedData(expectedDataMap, claimPeriod);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.MEDICAL_CLAIM_SUMMARY_EXPECTED,
				medicalClaimSummaryExpectedJson);

		JSONObject medicalClaimSummaryActualJson = null;
		if (medicalClaimSummaryPage != null) {
			getLoginScenario().saveBean(
					PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE,
					medicalClaimSummaryPage);
			Assert.assertTrue(true);
			medicalClaimSummaryActualJson = medicalClaimSummaryPage.medicalClaimsSummaryJson;
		}

		getLoginScenario().saveBean(
				ClaimsCommonConstants.MEDICAL_CLAIM_SUMMARY_ACTUAL,
				medicalClaimSummaryActualJson);

	}

	@When("^user searches the medical claims for following time interval in AARP site$")
	public void user_claims_time_interval_aarp(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}

		String toDate = timeAttributesMap
				.get(ClaimsCommonConstants.CLAIMS_TO_DATE);
		String fromDate = timeAttributesMap
				.get(ClaimsCommonConstants.CLAIMS_FROM_DATE);

		MedicalClaimSummaryPage medicalClaimSummaryPage = (MedicalClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE);

		medicalClaimSummaryPage = medicalClaimSummaryPage
				.searchClaimsByTimeInterval(toDate, fromDate);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);

		JSONObject medicalClaimSummaryExpectedJson = medicalClaimSummaryPage
				.getExpectedData(expectedDataMap, toDate, fromDate);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.MEDICAL_CLAIM_SUMMARY_EXPECTED,
				medicalClaimSummaryExpectedJson);

		JSONObject medicalClaimSummaryActualJson = null;
		if (medicalClaimSummaryPage != null) {
			getLoginScenario().saveBean(
					PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE,
					medicalClaimSummaryPage);
			Assert.assertTrue(true);
			medicalClaimSummaryActualJson = medicalClaimSummaryPage.medicalClaimsSummaryJson;
		}

		getLoginScenario().saveBean(
				ClaimsCommonConstants.MEDICAL_CLAIM_SUMMARY_ACTUAL,
				medicalClaimSummaryActualJson);

	}

	@Then("^user validates the medical claims displayed based on the selection in AARP site$")
	public void validates__medical_claims_summary_aarp() {

		JSONObject medicalClaimSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.MEDICAL_CLAIM_SUMMARY_ACTUAL);
		JSONObject medicalClaimSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.MEDICAL_CLAIM_SUMMARY_EXPECTED);

		/* Validating Claims-Summary */
		try {
			JSONAssert.assertEquals(medicalClaimSummaryExpectedJson,
					medicalClaimSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^user views the claim details for the first medical claim in AARP site$")
	public void user_views_claims_details_aarp() {
		MedicalClaimSummaryPage medicalClaimSummaryPage = (MedicalClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE);
		MedicalClaimDetailsPage medicalClaimDetailPage = medicalClaimSummaryPage
				.getClaimDetail();

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject medicalClaimDetailsExpectedJson = medicalClaimDetailPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.MEDICAL_CLAIM_DETAILS_EXPECTED,
				medicalClaimDetailsExpectedJson);

		JSONObject medicalClaimDetailsActualJson = null;
		if (medicalClaimDetailPage != null) {
			getLoginScenario().saveBean(
					PageConstants.MEDICAL_CLAIM_DETAILS_PAGE,
					medicalClaimDetailPage);
			Assert.assertTrue(true);
			medicalClaimDetailsActualJson = medicalClaimDetailPage.medicalClaimDetailsJson;
		}
		getLoginScenario().saveBean(
				ClaimsCommonConstants.MEDICAL_CLAIM_DETAILS_ACTUAL,
				medicalClaimDetailsActualJson);

	}

	@Then("^user validates the following claim details in AARP site$")
	public void user_validates_claim_details_aarp() {
		MedicalClaimDetailsPage medicalClaimDetailPage = (MedicalClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.MEDICAL_CLAIM_DETAILS_PAGE);

		JSONObject medicalClaimDetailsActualJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.MEDICAL_CLAIM_DETAILS_ACTUAL);
		JSONObject medicalClaimDetailsExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.MEDICAL_CLAIM_DETAILS_EXPECTED);

		/* Validating Claims-Details */
		try {
			JSONAssert.assertEquals(medicalClaimDetailsExpectedJson,
					medicalClaimDetailsActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		medicalClaimDetailPage.logOut();

	}

	/*******************************************************
	 * Below steps are Terminated member specific
	 ******************************************************/

	@Given("^the registered terminated plan member with following attributes in AARP site for medical claims$")
	public void registered_AMP_with_attributes_medical_claims_terminated_aarp(
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
		TerminatedHomePage TerminatedHomePage = (TerminatedHomePage)loginPage.loginWith(userName, pwd);

		
		if (TerminatedHomePage != null) {
			getLoginScenario().saveBean(PageConstants.TERMINATED_HOME_PAGE,
					TerminatedHomePage);
			Assert.assertTrue(true);
		}

		else {
			Assert.fail("Login was not successful");
		}
	}

	@When("^the user navigates to claim summary page for terminated members in AARP site$")
	public void user_views_claim_summary_terminated_aarp() {
		TerminatedHomePage terminatedHomePage = (TerminatedHomePage) getLoginScenario()
				.getBean(PageConstants.TERMINATED_HOME_PAGE);
		MedicalClaimSummaryPage medicalClaimSummaryPage = terminatedHomePage
				.navigateToMedicalClaimsSummary();
		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);

		/*
		 * We are setting claimPeriod 'Last 90 days' because by default claim
		 * period will be Last 90 days when Claim summary page loads first time
		 */
		String claimPeriod = "Last 90 Days";
		JSONObject medicalClaimSummaryExpectedJson = medicalClaimSummaryPage
				.getExpectedData(expectedDataMap, claimPeriod);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.MEDICAL_CLAIM_SUMMARY_EXPECTED,
				medicalClaimSummaryExpectedJson);

		JSONObject medicalClaimSummaryActualJson = null;
		if (medicalClaimSummaryPage != null) {
			getLoginScenario().saveBean(
					PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE,
					medicalClaimSummaryPage);
			Assert.assertTrue(true);
			medicalClaimSummaryActualJson = medicalClaimSummaryPage.medicalClaimsSummaryJson;
		}

		getLoginScenario().saveBean(
				ClaimsCommonConstants.MEDICAL_CLAIM_SUMMARY_ACTUAL,
				medicalClaimSummaryActualJson);

		/* Validating Medical Claims for default period i.e. Last 90 days */
		try {
			JSONAssert.assertEquals(medicalClaimSummaryExpectedJson,
					medicalClaimSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
