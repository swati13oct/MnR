package acceptancetests.memberrdesignVBF.provider;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.ProviderSearchPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MemberProviderSearchStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
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
