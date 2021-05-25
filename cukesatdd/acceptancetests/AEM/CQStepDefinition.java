package acceptancetests.AEM;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AEM.CQLoginPage;
import pages.AEM.CQPage;


/**
 *Functionality: Acquisition SEO for AARP
 */
public class CQStepDefinition {
	
	//Use Atomic integer for thread safety, refer RetryAnalyzer
	int iRedirectionCounter = 0;

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}	
	
	/**
	 *@toDo: login with user details
	 */
	@Given("^the user is on the AEM login page and logs in$")
	public void user_Login(DataTable data) 
	{
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		/*List<DataTableRow> AttributesRow = data
				.getGherkinRows();
		
		for (int i = 0; i < AttributesRow.size(); i++) {

			memberAttributesMap .put(AttributesRow.get(i).getCells()
					.get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String username = memberAttributesMap.get("Username");
		String password = memberAttributesMap.get("Password");
		
		CQLoginPage cqLoginPage = new CQLoginPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.CQ_LOGIN_PAGE, cqLoginPage);
		
		CQPage cqPage = cqLoginPage.login(username, password);
		getLoginScenario().saveBean(PageConstants.CQ_PAGE, cqPage);
		
	}
	
	@And("^the user navigates to ole pages on AEM and validates$")
	public void validateCQ_OLEPages(){
		CQPage cqPage = (CQPage) getLoginScenario().getBean(PageConstants.CQ_PAGE);
		cqPage.validateOLEPages();
	}
	
	@And("^the user navigates to vpp pages on AEM and validates$")
	public void validateCQ_VPPPages(){
		CQPage cqPage = (CQPage) getLoginScenario().getBean(PageConstants.CQ_PAGE);
		cqPage.validateVPPPages();
	}
	
	@And("^the user navigates to acquisition pages on AEM and validates$")
	public void validateCQ_AcqPages(){
		CQPage cqPage = (CQPage) getLoginScenario().getBean(PageConstants.CQ_PAGE);
		cqPage.validateAcqPages();
	}

	@And("^the user navigates to member pages on AEM and validates$")
	public void validateCQ_member_Pages(){
		CQPage cqPage = (CQPage) getLoginScenario().getBean(PageConstants.CQ_PAGE);
		cqPage.validateMemberPages();
	}
	
	@Given("^the user login in AEM")
	public void the_user_login_in_AEM(DataTable data) {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(data);
		/*List<DataTableRow> AttributesRow = data
				.getGherkinRows();
		
		for (int i = 0; i < AttributesRow.size(); i++) {

			memberAttributesMap .put(AttributesRow.get(i).getCells()
					.get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String username = memberAttributesMap.get("Username");
		String password = memberAttributesMap.get("Password");
		
		CQLoginPage cqLoginPage = new CQLoginPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.CQ_LOGIN_PAGE, cqLoginPage);
		
		CQPage cqPage = cqLoginPage.login(username, password);
		getLoginScenario().saveBean(PageConstants.CQ_PAGE, cqPage);
		
	}
	
	@Then("^the user nagivates to Data Layer Page$")
	public void the_user_nagivates_to_Data_Layer_Page() {
		CQPage cqPage=(CQPage)getLoginScenario().getBean(PageConstants.CQ_PAGE);
		cqPage.navigateToDataLayerUrl();
	}
	
	@Then("^the user validates the static tab components$")
	public void the_user_validates_the_static_tab_components(DataTable data) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(data);
		/*List<DataTableRow> AttributesRow = data
				.getGherkinRows();
		
		for (int i = 0; i < AttributesRow.size(); i++) {

			memberAttributesMap .put(AttributesRow.get(i).getCells()
					.get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		String url = memberAttributesMap.get("StaticURL");
		CQPage cqPage=(CQPage)getLoginScenario().getBean(PageConstants.CQ_PAGE);
		cqPage.validateDataLayerStaticTab(url);
	}
	
	@Then("^the user validates the Dynamic Apps tab components$")
	public void the_user_validates_the_Dynamic_Apps_tab_components() {
		CQPage cqPage=(CQPage)getLoginScenario().getBean(PageConstants.CQ_PAGE);
		cqPage.validateDataLayerDynamicTab();		
	}
	
}