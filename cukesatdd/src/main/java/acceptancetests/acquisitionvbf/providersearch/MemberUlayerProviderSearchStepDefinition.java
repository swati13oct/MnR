package acceptancetests.acquisitionvbf.providersearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality: 
 */
public class MemberUlayerProviderSearchStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}
	

	@Given("^the user is on the AARP Member medicare site loginn page$")
	public void user_login_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	}

	
	@When("^the user logs in with a registered AMP with following details in AARP sites$")
	public void user_logs_in(DataTable memberAttributes)
	{
		
			/* Reading the given attribute from feature file */
			List<List<String>> dataTable = memberAttributes.raw();
			List<String> desiredAttributes = new ArrayList<String>();
			for (List<String> data : dataTable) {
				desiredAttributes.add(data.get(0));
			}
			System.out.println("desiredAttributes.." + desiredAttributes);
			Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);
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
			AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);

			if (accountHomePage != null) {
				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
				getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
						accountHomePage);
				Assert.assertTrue(true);
			}else{
				Assert.fail("Account Home page not displayed ");
			}
		
		}
		@Then("^the user click on  providers button on the Plan Summary page$")
	public void navigate_to_ProviderSearch()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		accountHomePage.navigate_ProviderSearch();
	
		}
	
	@Then("^the user navigate to Panel navigation and click on provider search$")
	public void navigate_to_PanelNavigation()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		accountHomePage.panelNavigation();
	}
	
	
	@Then("^the user navigate to Plan Summary page  and click on provider search$")
	public void navigate_to_PlanSummaryPage()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		accountHomePage.providerSearchRHandWidget();
	}
	
	@Then("^the user navigate to Benefits and Coverage page and click on provider search$")
	public void navigate_to_BenefitsandCoveragePage()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		accountHomePage.BenefitsandCoverageProviderSearch();
	}
	
	@Then("^the user navigate to Benefits and Coverage page and click on provider search in PCP Section$")
	public void navigate_to_BenefitsandCoveragePageinPCP()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		accountHomePage.providerSearchLinkinPCPSection();
	}
	
	@Then("^the user navigate to Claims page and click on provider search$")
	public void navigate_to_ClaimsPage()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		accountHomePage.providerSearchLinkinClaimsPage();
	}
	
	@Then("^the user navigate to Forms and Resources page and click on provider search$")
	public void navigate_to_FormsandResourcespage()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		accountHomePage.FormsandResourcesLinkinPlanSummaryPage();
	}
	
	
	
	@Then("^the user navigate to PHR  page and expand my Doctors and my Facility and click on provider search$")
	public void navigate_to_PHRpage()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		accountHomePage.PHR();
	}
}