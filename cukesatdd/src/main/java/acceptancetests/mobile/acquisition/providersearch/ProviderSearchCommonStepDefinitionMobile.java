package acceptancetests.mobile.acquisition.providersearch;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import io.cucumber.java.en.Then;
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

}
