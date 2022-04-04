package acceptancetests.UHCCP;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import pages.UHCCP.UHCCPHomePage;
import pages.acquisition.commonpages.AcquisitionHomePage;

public class GlobalStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public WebDriver driver;

	@Given("User is on the UHCCP landing page")
	public void user_is_on_the_uhccp_landing_page() {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage uhccpHomePage = (AcquisitionHomePage) getLoginScenario().openApplicationURL(wd, "UHCCP");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.UHCCP_HOME_PAGE, uhccpHomePage);
	}
	
	@When("the user selects language")
	public void the_user_selects_language(DataTable givenAttributes) {
		driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		String lang = memberAttributesMap.get("Language");
		
		UHCCPHomePage uhccpHomePage = new UHCCPHomePage(driver);
		uhccpHomePage.selectLang(lang);
		getLoginScenario().saveBean(PageConstants.UHCCP_HOME_PAGE, uhccpHomePage);
	}

}
