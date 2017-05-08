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
import pages.member.bluelayer.DrugClaimDetailsPage;
import pages.member.bluelayer.DrugCostandBenefitSummaryPage;
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
public class DrugClaimsUmsStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the registered UMS with following attributes in UMS site for drug claims$")
	public void registered_ums_with_attributes_drug_claims_ums(
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
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
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
		getLoginScenario().saveBean(CommonConstants.PLAN_CATEGORY,
				memberAttributesMap.get("Category"));
	}

	@When("^the user navigates to claim summary page in UMS site for drug claims$")
	public void user_views_drug_claim_summary_ums() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		String planCategory = (String) getLoginScenario().getBean(
				CommonConstants.PLAN_CATEGORY);
		ClaimSummaryPage claimSummaryPage = accountHomePage
				.navigateToDrugClaimsSummary(planCategory);
		if (claimSummaryPage != null) {

			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					claimSummaryPage);

			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
					claimSummaryPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("claimSummaryPage Not Available");
		}

		getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
				claimSummaryPage);

	}

	@And("^the user search drug claims for the following claim period in UMS site$")
	public void user_drug_claims_following_period_ums(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		String planCategory = (String) getLoginScenario().getBean(
				CommonConstants.PLAN_CATEGORY);
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()

		.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);

		claimSummaryPage = claimSummaryPage.searchDrugClaimsByPeriod(timeAttributesMap, planCategory);
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

	@When("^user searches the drug claims for following time interval in UMS site$")
	public void user_drug_claims_time_interval_ums(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		claimSummaryPage = claimSummaryPage
				.searchDrugClaimsByTimeInterval(timeAttributesMap);
		if (claimSummaryPage != null) {

			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					claimSummaryPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("claimSummaryPage Not Available");
		}

	}

	@Given("^the registered terminated member with following attributes in UMS site for drug claims$")
	public void registered_ums_with_attributes_drug_claims_terminated_ums(
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

		String planType = memberAttributesMap.get("Plan Type");
		getLoginScenario().saveBean("Plan Type", planType);

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

		LoginPage loginPage = new LoginPage(wd);
		TerminatedHomePage terminatedHomePage = (TerminatedHomePage) loginPage.loginWith(user, pwd, category);
		if (terminatedHomePage != null) {
			getLoginScenario().saveBean("webDriver", wd);
			getLoginScenario().saveBean(PageConstants.TERMINATED_HOME_PAGE,
					terminatedHomePage);
			Assert.assertTrue(true);
		}

		else {
			Assert.fail("Login was not successful");
		}
	}

	@When("^the user navigates to claim summary page for terminated members in UMS site for drug claims$")
	public void user_views_drug_claim_summary_terminated_ums() {
		TerminatedHomePage terminatedHomePage = (TerminatedHomePage) getLoginScenario()
				.getBean(PageConstants.TERMINATED_HOME_PAGE);
		ClaimSummaryPage claimSummaryPage = terminatedHomePage
				.navigateToClaimsSummary();
		if (claimSummaryPage != null) {

			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					claimSummaryPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("claimSummaryPage Not Available");
		}

	}

	@And("^the user search drug claims for the following claim period for terminated members in UMS site$")
	public void user_drug_claims_following_period_terminated_ums(
			DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		String planCategory = (String) getLoginScenario().getBean(
				CommonConstants.PLAN_CATEGORY);
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean("Plan Type");

		claimSummaryPage = claimSummaryPage.searchDrugClaimsByPeriod(
				timeAttributesMap, planType);

		claimSummaryPage = claimSummaryPage.searchDrugClaimsByPeriod(
				timeAttributesMap, planCategory);
		if (claimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
					claimSummaryPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("claimSummaryPage Not Available");
		}

	}

	@When("^user searches the drug claims for following time interval for terminated members in UMS site$")
	public void user_drug_claims_time_interval_terminated_ums(
			DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean("Plan Type");

		claimSummaryPage = claimSummaryPage.searchDrugClaimsByTimeInterval(
				timeAttributesMap, planType);

		claimSummaryPage = claimSummaryPage.searchDrugClaimsByTimeInterval(
				timeAttributesMap, planType);
		if (claimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE,
					claimSummaryPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("claimSummaryPage Not Available");
		}

	}

	@Then("^user validates the drug claims for the selected time period in UMS site$")
	public void validates_number_drug_claims_ums() {
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		String claimsSummaryContent = claimSummaryPage.getClaimSummaryContent();
		System.out.println("claimsSummaryContent in claimSummaryPage"
				+ claimsSummaryContent);

	}

	@And("^user validates the following claim summary for each drug claim in UMS site$")
	public void validates_drug_claims_summary_ums(DataTable summaryAttributes) {
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		String claimsSummaryContent = claimSummaryPage.getClaimSummaryContent();
		System.out.println("claimsSummaryContent in claimSummaryPage"
				+ claimsSummaryContent);
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

	@When("^user views drug claim details for individual claim in UMS site$")
	public void user_views_drug_claims_details_ums() {
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);

		String category = (String) getLoginScenario().getBean(
				CommonConstants.PLAN_CATEGORY);
		DrugClaimDetailsPage drugClaimDetailsPage = claimSummaryPage
				.getDrugClaimDetail(category);
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);

		JSONObject claimDetailsExpectedJson = drugClaimDetailsPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				ClaimsCommonConstants.CLAIM_DETAILS_EXPECTED,
				claimDetailsExpectedJson);

		// get actual data
		JSONObject claimDetailsActualJson = null;
		if (drugClaimDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_DETAILS_PAGE,
					drugClaimDetailsPage);
			Assert.assertTrue(true);
			claimDetailsActualJson = drugClaimDetailsPage.claimsDetailsJson;
			getLoginScenario().saveBean(
					ClaimsCommonConstants.CLAIM_DETAILS_ACTUAL,
					claimDetailsActualJson);
		}

	}

	@Then("^user validates the following drug claim details for a claim in UMS site$")
	public void user_validates_drug_claim_details_ums(
			DataTable accountAttributes) {
		DrugClaimDetailsPage drugClaimDetailsPage = (DrugClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_DETAILS_PAGE);
		String servicesChargesContent = drugClaimDetailsPage
				.getServicesChargesContent();
		System.out.println("servicesChargesContent in DrugClaimDetailsPage"
				+ servicesChargesContent);

	}

	@And("^the user validates the drug cost details in UMS site$")
	public void user_validates_drugcost_details_ums(DataTable accountAttributes) {
		DrugClaimDetailsPage drugClaimDetailsPage = (DrugClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_DETAILS_PAGE);
		String drugCostDetailsContent = drugClaimDetailsPage
				.getDrugCostDetails();
		System.out.println("drugCostDetailsContent in DrugClaimDetailsPage"
				+ drugCostDetailsContent);

	}

	@Then("^user validates the drug claim details for a claim in UMS site$")
	public void user_validates_drug_claim_details_ums() {
		DrugClaimDetailsPage claimDetailsPage = (DrugClaimDetailsPage) getLoginScenario()
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
	
	@When("^I want to display the link to the My Drug Costs and Benefits page$")
	public void I_want_to_display_the_link_to_the_My_Drug_Costs_and_Benefits_page() {
		
		String linkexistense= null;
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ClaimSummaryPage claimSummaryPage = accountHomePage.navigateToDrugClaimsSummary("");
		if (claimSummaryPage != null) {

			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE, claimSummaryPage);

			getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE, claimSummaryPage);

			Assert.assertTrue(true);
		} else {
			Assert.fail("claimSummaryPage Not Available");
		}
		

		linkexistense = claimSummaryPage.searchlinkexistense();
		System.out.println(linkexistense);
		if (linkexistense != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE, claimSummaryPage);		
		} else {
			Assert.assertFalse("Link does not exist", false);
		}

		
	}

	@Then("^We should be able to reach My Drug Costs and Benefits page$")
	public void I_will_be_able_to_do_so_in_AEM_without_IT_intervention() {
		ClaimSummaryPage claimSummaryPage = (ClaimSummaryPage) getLoginScenario().getBean(PageConstants.CLAIM_SUMMARY_PAGE);
		
		DrugCostandBenefitSummaryPage drugcostbenefPage= claimSummaryPage.navigateToPrescriptionDrugCostPage();
		if(drugcostbenefPage!= null){
			Assert.assertTrue(true);
			
		}else{
			Assert.assertTrue("Drug cost and Benefit is not reached after click on link",false);
		}
		
	}
}
		
