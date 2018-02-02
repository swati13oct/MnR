package acceptancetests.acquisitionvbf.deprecated;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;







import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;



import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality:
 */
public class MemberProviderSearchStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}
	
	@Given("^the user is on the UMS medicare member site login page$")
	public void user_login_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		
	}

	@When("^the user logs in with a registered AMP with following details in UMS site$")
		public void Login(DataTable memberAttributes) {
		
		
			List<DataTableRow> memberAttributesRow = memberAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
	
				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			
			String category = memberAttributesMap.get("Member Type");
	
			Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
			List<String> desiredAttributes = new ArrayList<String>();
			for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
					.hasNext();) {
				{
					String key = iterator.next();
					desiredAttributes.add(memberAttributesMap.get(key));
				}
	
			}
			System.out.println("desiredAttributes.." + desiredAttributes);
			Map<String, String> loginCreds = loginScenario
					.getUMSMemberWithDesiredAttributes(desiredAttributes);
			
			String userName = null;
			String pwd = null;
			if (loginCreds == null) {
				// no match found
				System.out.println("Member Type data could not be setup !!!");
				Assert.fail("unable to find a " + desiredAttributes + " member");
			} else {
				userName = loginCreds.get("user");
				pwd = loginCreds.get("pwd");
				System.out.println("User is..." + userName);
				System.out.println("Password is..." + pwd);
				getLoginScenario()
				.saveBean(LoginCommonConstants.USERNAME, userName);
				getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
			}
	
			WebDriver wd = getLoginScenario().getWebDriver();
			LoginPage loginPage = new LoginPage(wd);
			System.out.println(desiredAttributes.get(1));
			AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd,category);
	
			if (accountHomePage != null) {
				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
				getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
						accountHomePage);
				Assert.assertTrue(true);
			}else{
				Assert.fail("Account Home page not displayed for the user "+userName);
			}
		}

		@Then("^the user click on providers button under my Resource Section$")
		public void navigate_to_myResourceSection()
		{
			AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			accountHomePage.navigate_ProviderSearchBlayerUnderMyResourceSection();
		}
		
		@Then("^the user navigate to Panel navigation and click on provider search in Blayer$")
		public void navigate_to_PanelnavigationProvider()
		{			
			AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			accountHomePage.panelNavigation();
		}		
		
		@Then("^the user navigate to Plan Summary page  and click on provider search in Blayer$")
		public void navigate_to_PlanSummaryPage()
		{
			AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			accountHomePage.providerSearchRHandWidgetBlayer();
		}		
		
		@Then("^the user navigate to Benefits and Coverage page and click on provider search Blayer$")
		public void navigate_to_BenefitsandCoveragePage()
		{
			AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			accountHomePage.BenefitsandCoverageProviderSearch();
		}
		
		@Then("^the user navigate to Benefits and Coverage page and click on provider search in PCP Section Blayer$")
		public void navigate_to_BenefitsandCoveragePageinPCP()
		{
			AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			accountHomePage.providerSearchLinkinPCPSection();
		}
		
		@Then("^the user navigate to Claims page and click on provider search  EOB Blayer$")
		public void navigate_to_ClaimsPageBlayer()
		{
			AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			accountHomePage.providerSearchLinkInClaimsPageEOB();
		}
		
		@Then("^the user navigate to PHR  page and expand my Doctors and my Facility and click on provider search Blayer$")
		public void navigate_to_PHRpage()
		{
			AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			accountHomePage.PHR();
		}

		@Then("^the user navigate to Forms and Resources page and click on provider search Blayer$")
		public void navigate_to_FormsandResourcespageBlayer()
		{
			AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			accountHomePage.FormsandResourcesLinkinPlanSummaryPageBlayer();
		}
		
}