package acceptancetests.mobile.acquisition.providersearch;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.ProviderSearchPage;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.ProviderSearchPageMobile;

public class ProviderSearchCommonStepDefinitionMobile {
	
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}
	
	@Then("^user should be redirected to Provider search Rally page$")
	public void user_should_be_redirected_to_Provider_search_Rally_page() throws Throwable {
		ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
				.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
		providerSearchPage.verifyProviderSearchRallyPageDisplayed();
	}
	
	@When("^user selects a Behaviour and returns to VPP page$")
	public void user_selects_a_Behaviour_and_returns_to_VPP_page() {
		ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
				.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
//		VPPPlanSummaryPageMobile plansummaryPage = providerSearchPage.selectsBehaviour();
//		Assertion.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);
		String savedProvider = providerSearchPage.selectsBehaviour();
		getLoginScenario().saveBean(VPPCommonConstants.SAVED_PROVIDER_RALLY,savedProvider);
	}
	
	@When("^user selects a Dental and retuns to VPP page$")
	public void user_selects_a_Dental_and_retuns_to_VPP_page() {
		ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
				.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
//		VPPPlanSummaryPageMobile plansummaryPage = providerSearchPage.selectsDental();
//		Assertion.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);
		String savedProvider = providerSearchPage.selectsDental();
		getLoginScenario().saveBean(VPPCommonConstants.SAVED_PROVIDER_RALLY,savedProvider);
	}
	
	@When("^user click on Finish Retun button on rally page navigates to plan details page$")
	public void userclickonFinishRetunbuttononrallypagenavigatestoplandetailspage() {
		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			PlanDetailsPageMobile planDetailsPage = providerSearchPage.navigatebacktoPlanDetails();
			Assertion.assertTrue("Not able to return to Plan Details page", planDetailsPage != null);

		}
	}

}
