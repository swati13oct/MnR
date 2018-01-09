package acceptancetests.claims.bluelayer;

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
import pages.member.bluelayer.ClaimDetailsPage;
import pages.member.bluelayer.ClaimSummaryPage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.TerminatedHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */
public class MedicalClaimsUmsStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the registered UHC with following attributes in UMS site for medical claims$")
	public void registered_UMS_with_attributes_medical_claims_UMS(
			DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
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
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd,category);
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

		System.out.println("accountHomeActualJson=====>"
				+ accountHomeActualJson.toString());
		System.out.println("accountHomeExpectedJson=====>"
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

	@When("^the user navigates to claim summary page in UMS site$")
	public void user_views_claim_summary_ums() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ClaimSummaryPage claimSummaryPage = accountHomePage
				.navigateToMedicalClaimsSummary();
		if (claimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
					claimSummaryPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("claimSummaryPage Not Available");
		}

	}

	@Given("^the registered terminated members with following attributes in UMS site for medical claims$")
	public void registered_UMS_with_attributes_medical_claims_terminated_UMS(
			DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		
		getLoginScenario().saveBean("Category", category);
		getLoginScenario().saveBean("Plan Type",
				memberAttributesMap.get("Plan Type"));

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			String key = iterator.next();
			if (!memberAttributesMap.get(key).isEmpty()) {
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		String[] memberArr = null;// TODO:loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);

		String user = memberArr[0];
		String pwd = memberArr[1];

		if (user == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			System.out.println("User is..." + user);
			System.out.println("Password is..." + pwd);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, user);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean("webDriver", wd);

		LoginPage loginPage = new LoginPage(wd);
		TerminatedHomePage terminatedHomePage = (TerminatedHomePage) 	loginPage.loginWith(user, pwd, category);
		if (terminatedHomePage != null) {
			getLoginScenario().saveBean(PageConstants.TERMINATED_HOME_PAGE,
					terminatedHomePage);
			Assert.assertTrue(true);
		}

		else {
			Assert.fail("Login was not successful");
		}
	}

	@When("^the user navigates to claim summary page for terminated members in UMS site$")
	public void user_views_claim_summary_ums_terminated() {
		TerminatedHomePage terminatedHomePage = (TerminatedHomePage) getLoginScenario()
				.getBean(PageConstants.TERMINATED_HOME_PAGE);
		ClaimSummaryPage claimSummaryPage = terminatedHomePage
				.navigateToClaimsSummary();
		if (claimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
					claimSummaryPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("claimSummaryPage Not Available");
		}

	}

	@And("^user searches the claims for the following period in UMS site$")
	public void user_claims_following_period_ums(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.CLAIM_SUMMARY_PAGE);
		claimSummaryPage = claimSummaryPage
				.searchClaimsByPeriod(timeAttributesMap);
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject claimSummaryExpectedJson = claimSummaryPage.getExpectedData(
				expectedDataMap, timeAttributesMap.get("Claim Period"));

		getLoginScenario().saveBean(
				ClaimsCommonConstants.CLAIM_SUMMARY_EXPECTED,
				claimSummaryExpectedJson);

		// get actual data
		JSONObject claimSummaryActualJson = null;
		if (claimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
					claimSummaryPage);
			Assert.assertTrue(true);
			claimSummaryActualJson = claimSummaryPage.claimSummaryJson;
			getLoginScenario().saveBean(
					ClaimsCommonConstants.CLAIM_SUMMARY_ACTUAL,
					claimSummaryActualJson);
		}

	}

	@When("^user searches the medical claims for following time interval in UMS site$")
	public void user_claims_time_interval_ums(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.CLAIM_SUMMARY_PAGE);
		claimSummaryPage = claimSummaryPage
				.searchClaimsByTimeInterval(timeAttributesMap);
		if (claimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
					claimSummaryPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("claimSummaryPage Not Available");
		}
		getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
				claimSummaryPage);

	}

	@And("^user validates the medical claims for the selected time period in UMS site$")
	public void validates_claims_Summary_ums() {

		JSONObject claimSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.CLAIM_SUMMARY_ACTUAL);
		JSONObject claimSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.CLAIM_SUMMARY_EXPECTED);

		System.out.println("claimSummaryExpectedJson======>"
				+ claimSummaryExpectedJson.toString());
		System.out.println("claimSummaryActualJson======>"
				+ claimSummaryActualJson.toString());

		try {
			JSONAssert.assertEquals(claimSummaryExpectedJson,
					claimSummaryActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@When("^user views medical claim details for individual claim in UMS site$")
	public void user_claims_details_ums() {
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.CLAIM_SUMMARY_PAGE);
		ClaimDetailsPage claimDetailsPage = claimSummaryPage.getClaimDetail();
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject claimDetailsExpectedJson = claimDetailsPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.CLAIM_DETAILS_EXPECTED,
				claimDetailsExpectedJson);

		// get actual data
		JSONObject claimDetailsActualJson = null;
		if (claimDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.CLAIM_DETAILS_PAGE,
					claimDetailsPage);
			Assert.assertTrue(true);
			claimDetailsActualJson = claimDetailsPage.claimsDetailsJson;
			getLoginScenario().saveBean(
					ClaimsCommonConstants.CLAIM_DETAILS_ACTUAL,
					claimDetailsActualJson);
		}

	}

	@Then("^user validates the medical claim details for a claim in UMS site$")
	public void user_validates_medical_claim_details_ums() {
		ClaimDetailsPage claimDetailsPage = (ClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.CLAIM_DETAILS_PAGE);
		JSONObject claimDetailsActualJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.CLAIM_DETAILS_ACTUAL);
		JSONObject claimDetailsExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ClaimsCommonConstants.CLAIM_DETAILS_EXPECTED);

		System.out.println("claimDetailsExpectedJson======>"
				+ claimDetailsExpectedJson.toString());
		System.out.println("claimDetailsActualJson======>"
				+ claimDetailsActualJson.toString());

		try {
			JSONAssert.assertEquals(claimDetailsExpectedJson,
					claimDetailsActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		claimDetailsPage.logout();
	}
	
@Given("registered member to login in UMS site$")
	
	public void registered_member_UMS(DataTable memberAttributes){
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String category = memberAttributesMap.get("Member Type");

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

		getLoginScenario().saveBean(CommonConstants.CATEGORY, category);

		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd,category);
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
		}
		
	}
	
	@Then("user validate add a plan link is not displayed for albama members$")
	
	 public void user_validates_addaplan_link()
    {
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario().getBean(PageConstants.CLAIM_SUMMARY_PAGE);
				

		
		boolean flagValue=claimSummaryPage.validateaddaplanlink();
		if(!flagValue){
			System.out.println("add a plan link is not displayed");
			Assert.assertTrue(true);
		}else{
			System.out.println("add a plan link is not displayed");
			Assert.assertTrue(false);
}
}

}

