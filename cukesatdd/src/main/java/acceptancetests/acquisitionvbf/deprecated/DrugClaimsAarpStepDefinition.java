package acceptancetests.acquisitionvbf.deprecated;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.DrugClaimSummaryPage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.PlanSummaryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality:
 */
public class DrugClaimsAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	@Given("^the user is on the AARP login page$")
    public void uhc_login_page(){
                   WebDriver wd = getLoginScenario().getWebDriver();
                   getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

                   LoginPage loginPage = new LoginPage(wd);
                   getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
                   
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

			LoginPage loginpage = (LoginPage) getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
			AccountHomePage accountHomePage = (AccountHomePage) loginpage.loginWith(userName, pwd);
			
			if (accountHomePage != null) {
				getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
						accountHomePage);
				
				if(accountHomePage.validateAccountHome())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating the Account Home Page");
				
			}

		}
	@When("^the user navigates to plan summary page and validates claims info$")
	public void user_navigates_to_plan_summary_ums() {
		
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		
		PlanSummaryPage planSummaryPage = accountHomePage.navigateToPlanSummary();
		
		if(planSummaryPage!=null){
			getLoginScenario().saveBean(PageConstants.PLAN_SUMMARY_PAGE, planSummaryPage);
			Assert.assertTrue(true);
			
			if(planSummaryPage.validateClaims()){
				Assert.assertTrue(true);
			}else
				Assert.fail("Error in validating the claims on Plan Summary Page");
		}
	}
	@When("^the user navigates to claim summary page in AARP site for drug claims$")
	public void user_views_drug_claim_summary_aarp() {
		PlanSummaryPage planSummaryPage = (PlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.PLAN_SUMMARY_PAGE);
		DrugClaimSummaryPage drugClaimSummaryPage = planSummaryPage
				.navigateToDrugClaimsSummary();

		if (drugClaimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					drugClaimSummaryPage);
			Assert.assertTrue(true);
		}

	}

	@And("^the user search drug claims for the following claim period in AARP site$")
	public void user_drug_claims_following_period_aarp(DataTable timeAttributes) {

		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		String claimPeriod = timeAttributesRow.get(0).getCells().get(1);
		DrugClaimSummaryPage drugClaimSummaryPage = (DrugClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		drugClaimSummaryPage = drugClaimSummaryPage
				.searchDrugClaimsByPeriod(claimPeriod);

		if (drugClaimSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE,
					drugClaimSummaryPage);
			Assert.assertTrue(true);
		}
	}

	@Then("^user validates the drug claims displayed based on the selection in AARP site$")
	public void validates_drug_claims_summary_aarp() {
		DrugClaimSummaryPage drugClaimSummaryPage = (DrugClaimSummaryPage) getLoginScenario()
				.getBean(PageConstants.DRUG_CLAIM_SUMMARY_PAGE);
		
		if(drugClaimSummaryPage!=null){
			if(drugClaimSummaryPage.validateRxClaims()){
				Assert.assertTrue(true);
				System.out.println("Claims were found");
			}else
				Assert.fail("Error in validating claims ");
		}
		
	}
}

