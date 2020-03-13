package acceptancetests.acquisition.globalcomponents;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AboutUsAARPPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AgentsnBrokersAARPPage;
import pages.acquisition.ulayer.ContactUsAARPPage;
import pages.acquisition.ulayer.DisclaimersAARPPage;
import pages.acquisition.ulayer.PrivacyPolicyAARPPage;
import pages.acquisition.ulayer.SiteMapAARPPage;
import pages.acquisition.ulayer.TermsnConditionsAARPPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality:Global Header Footer 
 */
public class GlobalComponentsStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

@When("^user verifies and clicks on home link of agents&brokers page ulayer$")
public void user_verifies_and_clicks_on_home_link_of_agents_brokers_page_ulayer() throws Throwable {
	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
			.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	AcquisitionHomePage aquisitionHomePageReload = aquisitionhomepage.homeFooterClick();
	Assert.assertTrue("home page not found", aquisitionHomePageReload!= null);
}

@When("^user vaidates the state drop down link on home page$")
public void user_vaidates_the_state_drop_down_link_on_home_page() throws Throwable {
	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
			.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	aquisitionhomepage.validateStateDropDown();
	}

@When("^user clicks on View all disclaimer information link on home page$")
public void user_clicks_on_View_all_disclaimer_information_link_on_home_page() throws Throwable {
	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
			.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	aquisitionhomepage.validateDisclaimer();
}

@When("^user verifies visit aarp\\.org link on home page ulayer$")
public void user_verifies_visit_aarp_org_link_on_home_page_ulayer() throws Throwable {
	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
			.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	aquisitionhomepage.validateVisitAarpOrglink();
}

@Then("^user clicks on back to top link on home page$")
public void user_clicks_on_back_to_top_link_on_home_page() throws Throwable {
	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
			.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	aquisitionhomepage.backToToplink();
}

}
