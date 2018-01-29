package acceptancetests.memberrdesign.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.eob.EOBPage;
import pages.dashboard.member.ulayer.ProviderSearchPage;
import pages.dashboard.member.ulayer.RallyDashboardPage;
import pages.member.ulayer.TeamHLoginUlayer;
import atdd.framework.MRScenario;

public class MemberProviderSearchStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^I am a authenticated member on the member redesign site for Provider Search$")
	public void I_am_a_authenticated_member_on_the_member_redesign_site(DataTable memberAttributes) {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
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
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); 
				iterator.hasNext();) {
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
		}
		/*DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);*/

	}
	
	@When("^the above plantype user logs in member area to validate provider search$")
	public void plantype_user_logs_in() throws InterruptedException {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		String category = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		
		TeamHLoginUlayer THloginPage = new TeamHLoginUlayer(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) THloginPage.loginWith(userName, pwd);
		if (rallyDashboard != null) {
			getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE,
					rallyDashboard);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Login not successful...");
		}
	}
	
	@When("^the member navigates to Provider Search page$")
	public void the_member_navigates_to_Provider_Search_page() throws Throwable {
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario().getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		ProviderSearchPage providerSearchPage = rallyDashboard.navigateToProviderSearch();	
		
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.MEM_REDESIGN_PROVIDER_SEARCH_PAGE,
					providerSearchPage);
		}
		else{
			Assert.fail("Provider Search page is not loaded");
		}
	}

	@Then("^the member should be able to access provider page$")
	public void the_member_should_be_able_to_access_provider_page() throws Throwable {
		ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_PROVIDER_SEARCH_PAGE);
		providerSearchPage.validateZipCodePage();	
	}

}
