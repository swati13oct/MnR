package acceptancetests.acquisitionvbf.common;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Given;
import pages.acquisition.ulayer.AcquisitionHomePage;

/**
 *Functionality:Attend Community Meeting
 */
public class CommonStepDefinitionAARP {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo:user is on AARP medicare acquisition site landing page
	 */
	@Given("^the user is on AARP medicare acquisition site landing page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

}