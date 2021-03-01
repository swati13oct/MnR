package acceptancetests.acquisition.footer;

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
import pages.acquisition.ulayer.GlobalWebElements;
import pages.acquisition.ulayer.TermsnConditionsAARPPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


/**
 *Functionality:Global Header Footer 
 */
public class GlobalHeaderFooterStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo:user is on acquisition home
	 */

}
