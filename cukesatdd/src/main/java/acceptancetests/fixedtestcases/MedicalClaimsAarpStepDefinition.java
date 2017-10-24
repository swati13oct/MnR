package acceptancetests.fixedtestcases;

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

import pages.member.ulayer.ClaimSummaryPage;
import pages.member.ulayer.PlanSummaryPage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.MedicalClaimDetailsPage;
import pages.member.ulayer.MedicalClaimSummaryPage;
import pages.member.ulayer.TerminatedHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;

/**
 * @author pperugu
 *
 */
public class MedicalClaimsAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the AARPM site login page$")
    public void aarp_login_page(){
                   WebDriver wd = getLoginScenario().getWebDriver();
                   getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

                   LoginPage loginPage = new LoginPage(wd);
                   getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
                   
    }

	@When("^the registered AMP with following attributes in AARP site for medical claims$")
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

		LoginPage loginPage = (LoginPage) getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);

		if (accountHomePage != null) {
			
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			if(accountHomePage.validateAccountHome())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the Account Home Page");

		}

	}
	@When("^the user navigates to plan summary page in AARP site and validates$")
	public void user_navigates_to_plan_summary_ums() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		
		PlanSummaryPage planSummaryPage = new PlanSummaryPage(wd);
		getLoginScenario().saveBean(PageConstants.PLAN_SUMMARY_PAGE,wd);
		planSummaryPage = accountHomePage.navigateToPlanSummary();
		
		if(planSummaryPage!=null){
			getLoginScenario().saveBean(PageConstants.PLAN_SUMMARY_PAGE, planSummaryPage);
			Assert.assertTrue(true);
			
			if(planSummaryPage.validateClaims()){
				Assert.assertTrue(true);
			}else
				Assert.fail("Error in validating the claims on Plan Summary Page");
		}
	}

	@When("^the user navigates to claim summary page in AARP site$")
	public void user_views_claim_summary_aarp() {

		PlanSummaryPage planSummaryPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SUMMARY_PAGE);
		
		MedicalClaimSummaryPage medicalClaimSummaryPage = planSummaryPage.navigateToMedicalClaimsSummary();

		if (medicalClaimSummaryPage != null) {
			getLoginScenario().saveBean(
					PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE,
					medicalClaimSummaryPage);
			Assert.assertTrue(true);
		}else {
			Assert.fail("claimSummaryPage Not Available");
		}
	}

	@And("^user searches the claims for the following claim period in AARP site$")
	public void user_claims_following_period_aarp(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		String claimPeriod = timeAttributesMap.get("Claim Period");
		MedicalClaimSummaryPage medicalClaimSummaryPage = (MedicalClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE);
		medicalClaimSummaryPage = medicalClaimSummaryPage
				.searchClaimsByPeriod(claimPeriod);

		if (medicalClaimSummaryPage != null) {
			getLoginScenario().saveBean(
					PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE,
					medicalClaimSummaryPage);
			Assert.assertTrue(true);
		}

	}

	
	@Then("^user validates the medical claims displayed based on the selection in AARP site$")
	public void validates__medical_claims_summary_aarp(DataTable timeAttributes) {
		MedicalClaimSummaryPage medicalClaimSummaryPage = (MedicalClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE);
		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		
		if(medicalClaimSummaryPage.validateClaims()){
			Assert.assertTrue(true);
			System.out.println("Claims were found in the following time range: "+timeAttributesMap.get("Claim Period"));
			
		}else
			Assert.fail("Claims were not found in the following time range: "+timeAttributesMap.get("Claim Period"));
	}

	@And("^user views the claim details for the first medical claim in AARP site and validates$")
	public void user_views_claims_details_aarp() {
		MedicalClaimSummaryPage medicalClaimSummaryPage = (MedicalClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.MEDICAL_CLAIM_SUMMARY_PAGE);
		MedicalClaimDetailsPage medicalClaimDetailPage = medicalClaimSummaryPage
				.getClaimDetail();
		
		if (medicalClaimDetailPage != null) {
			getLoginScenario().saveBean(
					PageConstants.MEDICAL_CLAIM_DETAILS_PAGE,
					medicalClaimDetailPage);
			Assert.assertTrue(true);
			if(medicalClaimDetailPage.validateMoreInfo()){
				Assert.assertTrue(true);
				System.out.println("More Info link has the appropriate elements");
			}else
				Assert.fail("Could not verify the More Info elements");
		}
	
	}
/*	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		CommonUtility.resetMRRestTime(getLoginScenario());
		CommonUtility.resetPartDTime(getLoginScenario());
		getLoginScenario().flushBeans();
	}*/

}

