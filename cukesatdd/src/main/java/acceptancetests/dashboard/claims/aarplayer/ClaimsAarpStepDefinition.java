package acceptancetests.dashboard.claims.aarplayer;

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

import com.google.common.base.Verify;
import com.thoughtworks.selenium.webdriven.commands.GetText;
import com.thoughtworks.selenium.webdriven.commands.GetValue;

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
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.RetireesOfSelectedPlans;
import pages.dashboard.member.ulayer.ClaimSummarypage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.ClaimSummaryPage;
import pages.member.ulayer.LoginPage;

public class ClaimsAarpStepDefinition {
	@Autowired
	MRScenario loginScenario;
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();

	public MRScenario getLoginScenario() {
				return loginScenario;
	}
	
	@Given("^I am an AMS member on the redesigned member site$")
	public void i_am_an_arrp_member_on_the_member_site(DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		//Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String businessType = null;
		//String domain = memberAttributesMap.get("domain");
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
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				if (!memberAttributesMap.get(key).isEmpty()) {
					desiredAttributes.add(memberAttributesMap.get(key));
				}
			}
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);
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
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);			
		}
		WebDriver wd = getLoginScenario().getWebDriver();
		//getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		/*JSONObject accountHomeActualJson = null;
	
		 Get expected data 
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);
*/
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
			//accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		/*try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}*/

		//getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,expectedDataMap);

	}

@When("^i navigate to the Claims Summary page in AMS site$")	
	 public void i_navigate_to_member_redesign_claims_page(){
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
	ClaimSummarypage newClaimsSummaryPage = accountHomePage.navigateToClaimsSummaryPage(loginScenario.getWebDriver());
	getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	if(newClaimsSummaryPage == null){
		System.out.println("Error:Loading on new claims detail page");
		Assert.fail();
	}
	else{
		System.out.println("Claims detail page loaded succesfully");
		getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}			
	
  }
@Then("^i can view a Page Header in Claims Sumamry page in AMS site$")
public void validate_the_header()
  {
	/*ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	newClaimsSummaryPage.validateHeader();*/
	
}

@And("^a View Claims for dropdown menu that defaults to last 90 days in Claims Sumamry page in AMS site$")
public void validate_viewClaimsForm_dropdown(){
	//String planType = memberAttributesMap.get("Plan Type");
	ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);	
	Assert.assertEquals("Last 90 Days", claimSummarypage.validateViewClaimsFromDropDown());
	
}

@And("^a Claim type dropdown in Claims Sumamry page in AMS site$")
public void validate_claim_type_drop_down(){
	
	String planType = memberAttributesMap.get("Plan Type");
	ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	
	Assert.assertTrue(claimSummarypage.validateClaimType(planType));
	
}

@And("^all Body Copy on the page in Claims Sumamry page in AMS site$")
public void validate_body_copay(){
	
ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	
	Assert.assertTrue(claimSummarypage.verifyCopyText());

	
}

@Then ("^I can view all Body Copy on the page in AMS site$")
public void validate_claims_table_body_copy_text(){
	
	ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	Assert.assertTrue(claimSummarypage.verifyCopyText2());

}


@And("^dynamic text with the number of claims and search criteria, or date range for custom search$")
public void validate_dynamic_nuber_of_claims_text(){
	
	ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	Assert.assertTrue(claimSummarypage.verifyDynamicText());
}


@And ("^a Claims Table with pagination in AMS site$")

public void validate_claims_table_and_pagination(){
	
	ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	Assert.assertTrue(claimSummarypage.verifyClaimsTableAndPagination());
	
}

@Then("^I can view an Explanation of Benefits component with the Medical and/or Prescription Drug EOB search buttons based on my plan type$")
public void validate_EOB_medical_or_Prescription(DataTable memberAttributes){
	
	List<DataTableRow> memberAttributesRow = memberAttributes
			.getGherkinRows();
	//Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	String planType = memberAttributesMap.get("Plan Type");
	String domain  = memberAttributesMap.get("Domain");
	
ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	
	Assert.assertTrue(claimSummarypage.validteEobfordifferentDomainType(domain, planType));
	
	
	
	
}




}



 
 