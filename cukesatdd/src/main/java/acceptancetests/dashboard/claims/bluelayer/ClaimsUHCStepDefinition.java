package acceptancetests.dashboard.claims.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.dashboard.member.blayer.ClaimsSummary;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;

public class ClaimsUHCStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^I am an UHC member on the redesigned member site$")
	public void i_am_an_uhc_member_on_the_member_site(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		String planType = memberAttributesMap.get("Plan Type");

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
			getLoginScenario().saveBean(LoginCommonConstants.CATOGERY, category);
			getLoginScenario().saveBean(LoginCommonConstants.PLANTYPE, planType);
		}

		/*String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		String category = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);*/
		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);

		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd,category);
		if (accountHomePage != null) {
			Map<String, JSONObject> expectedDataMap = loginScenario
					.getExpectedJson(userName);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
			getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
		}

	}

	
	@When("^I navigate to the Claims Summary page in UHC site$")
	public void navigate_to_Claims_Summary_page_UHC(){
		/*AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ClaimsSummary newClaimsSummaryPage = accountHomePage.navigateToClaimsSummaryPage();			

		if(newClaimsSummaryPage == null){
			System.out.println("Error:Loading on new claims detail page");
			
		}
		else{
			System.out.println("Claims detail page loaded succesfully");
			getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
		}
		
		String planType = (String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		newClaimsSummaryPage.navigateToRequiredPlan(planType);*/

	}

	@Then("^I can view a Page Header in Claims Sumamry page in UHC site$")
	public void validate_the_header()
	{
		ClaimsSummary newClaimsSummaryPage = (ClaimsSummary) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
				
		newClaimsSummaryPage.validateHeader();

	}

	@And("^View Claims for dropdown menu that defaults to last 90 days in Claims Sumamry page in UHC site$")
	public void validate_viewClaimsForm_dropdown(){
		//String planType = memberAttributesMap.get("Plan Type");
		ClaimsSummary claimSummarypage = (ClaimsSummary) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);	
		Assert.assertEquals("Last 90 Days", claimSummarypage.validateViewClaimsFromDropDown());

	}

	@And("^Claim type dropdown in Claims Sumamry page in UHC site$")
	public void validate_claim_type_drop_down(){

		String planType = (String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		ClaimsSummary claimSummarypage = (ClaimsSummary) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validateClaimType(planType));

	}

	@And("^all Body Copy on the page in Claims Sumamry page in UHC site$")
	public void validate_body_copay(){

		ClaimsSummary claimSummarypage = (ClaimsSummary) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.verifyCopyText());


	}

	@Then ("^I can view all Body Copy on the page in UHC site$")
	public void validate_claims_table_body_copy_text(){

		ClaimsSummary claimSummarypage = (ClaimsSummary) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyCopyText2());

	}


	@And("^dynamic text with the number of claims and search criteria, or date range for custom search in UHC site$")
	public void validate_dynamic_nuber_of_claims_text(){

		ClaimsSummary claimSummarypage = (ClaimsSummary) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyDynamicText());
	}


	@And ("^a Claims Table with pagination in UHC site$")

	public void validate_claims_table_and_pagination(){

		ClaimsSummary claimSummarypage = (ClaimsSummary) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyClaimsTableAndPagination());

	}

	@Then("^I can view an Explanation of Benefits component with the Medical and/or Prescription Drug EOB search buttons based on my plan type in UHC site$")
	public void validate_EOB_medical_or_Prescription(DataTable memberAttributes){
		List<DataTableRow> givenAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String domain = givenAttributesMap.get("Domain");
		String planType = (String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);


		ClaimsSummary claimSummarypage = (ClaimsSummary) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validteEobfordifferentDomainType(domain, planType));

	}

	@Then("^I can view the Learn More About Your Cost Breakdown section in UHC site$")
	public void validate_learn_more_about_section(){
		ClaimsSummary claimSummarypage = (ClaimsSummary) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validateLearnmoreaboutsection());


	}

	@Then("^I can view and validate the download my data button in UHC site$")
	public void validate_bownload_my_data_button(){

		ClaimsSummary claimSummarypage = (ClaimsSummary) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.validateDownloadMyDataButton());

	}
}
