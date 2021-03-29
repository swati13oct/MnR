package acceptancetests.AEM;

import gherkin.formatter.model.DataTableRow;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.AEM.CQPage;
import pages.AEM.*;


/**
 *Functionality: Acquisition SEO for AARP
 */
public class CQStepDefinition {
	
	static int iRedirectionCounter = 0;

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
		List<DataTableRow> AttributesRow = data
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		
		for (int i = 0; i < AttributesRow.size(); i++) {

			memberAttributesMap .put(AttributesRow.get(i).getCells()
					.get(0), AttributesRow.get(i).getCells().get(1));
		}
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
		List<DataTableRow> AttributesRow = data
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		
		for (int i = 0; i < AttributesRow.size(); i++) {

			memberAttributesMap .put(AttributesRow.get(i).getCells()
					.get(0), AttributesRow.get(i).getCells().get(1));
		}
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
		List<DataTableRow> AttributesRow = data
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		
		for (int i = 0; i < AttributesRow.size(); i++) {

			memberAttributesMap .put(AttributesRow.get(i).getCells()
					.get(0), AttributesRow.get(i).getCells().get(1));
		}
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