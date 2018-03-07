package acceptancetests.memberrdesignVBF.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.memberrdesignVBF.ProviderSearchPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.LoginPage;
import atdd.framework.MRScenario;

public class MemberProviderSearchStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^I am a authenticated member on the member redesign site for Provider Search$")
	public void I_am_a_authenticated_member_on_the_member_redesign_site(DataTable memberAttributes) {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getmemberRedesignVbfWithDesiredAttributes(desiredAttributes);

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
			getLoginScenario().saveBean(LoginCommonConstants.CATOGERY, category);
		}

	}

	@When("^the above plantype user logs in member area to validate provider search$")
	public void plantype_user_logs_in() throws InterruptedException {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		LoginPage THloginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) THloginPage.loginWith(userName, pwd);
			if (testHarness != null) {
				getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarness);
			} else {
				Assert.fail("Login not successful...");
			}
		} else {

			RallyDashboardPage rallyDashboard = (RallyDashboardPage) THloginPage.loginWith(userName, pwd);
			if (rallyDashboard != null) {
				getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
			} else {
				Assert.fail("Login not successful...");
			}
		}
		/*RallyDashboardPage rallyDashboard = (RallyDashboardPage) THloginPage.loginWith(userName, pwd);
		if (rallyDashboard != null) {
			getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Login not successful...");
		}*/
	}

	@When("^the member navigates to Provider Search page$")
	public void the_member_navigates_to_Provider_Search_page() throws Throwable {
		ProviderSearchPage providerSearchPage = null;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			providerSearchPage = testHarness.navigateToProviderSearch();
		} else {
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			providerSearchPage = rallyDashboard.navigateToProviderSearch();
		}

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.MEM_REDESIGN_PROVIDER_SEARCH_PAGE, providerSearchPage);
		} else {
			Assert.fail("Provider Search page is not loaded");
		}
	}

	@Then("^the member should be able to access provider page$")
	public void the_member_should_be_able_to_access_provider_page() throws Throwable {
		ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
				.getBean(PageConstants.MEM_REDESIGN_PROVIDER_SEARCH_PAGE);
		providerSearchPage.validateZipCodePage();
	}

}
