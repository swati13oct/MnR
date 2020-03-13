package acceptancetests.acquisition.globalcomponents;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AboutUsPage;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AgentsAndBrokersPage;
import pages.acquisition.bluelayer.ContactUsUmsPage;
import pages.acquisition.bluelayer.DisclaimersPage;
import pages.acquisition.bluelayer.PrivacyPolicyUmsPage;
import pages.acquisition.bluelayer.SiteMapUMSPage;
import pages.acquisition.bluelayer.TermsOfUseUmsPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality: Global Header Footer
 */
public class GlobalComponentsStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}


@When("^user verifies and clicks on home link of agents&brokers page ulayer UHC$")
public void user_verifies_and_clicks_on_home_link_of_agents_brokers_page_ulayer() throws Throwable {
}

@When("^user vaidates the state drop down link on home page UHC$")
public void user_vaidates_the_state_drop_down_link_on_home_page() throws Throwable {
}

@When("^user clicks on View all disclaimer information link on home page UHC$")
public void user_clicks_on_View_all_disclaimer_information_link_on_home_page() throws Throwable {
}

@When("^user verifies visit aarp\\.org link on home page ulayer UHC$")
public void user_verifies_visit_aarp_org_link_on_home_page_ulayer() throws Throwable {
}

@Then("^user clicks on back to top link on home page UHC$")
public void user_clicks_on_back_to_top_link_on_home_page() throws Throwable {
}

}
