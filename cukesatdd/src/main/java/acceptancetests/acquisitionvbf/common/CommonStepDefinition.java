package acceptancetests.acquisitionvbf.common;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Given;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.AcquisitionHomePage;

/**
 *Functionality:Attend Community Meeting
 */
public class CommonStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public static WebDriver webDriverObj;
	
	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	
	public void setWebDriverObj() {		
		webDriverObj =getLoginScenario().getWebDriver();		
	}

	/**
	 * @toDo:user is on AARP medicare acquisition site landing page
	 */
	@Given("^the user is on AARP medicare acquisition site landing page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		setWebDriverObj();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(webDriverObj);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, webDriverObj);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	/**
	 * @toDo:user is on blayer medicare
	 */
	@Given("^the user is on the UHC medicare solutions site landing page$")
	public void the_user_is_on_UMS_medicare_site_landing_page() {
		
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	
		
	}
	

}