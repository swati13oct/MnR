package acceptancetests.deprecated.fixedtestcases;

import gherkin.formatter.model.DataTableRow;
import pages.deprecated.member.ulayer.AccountHomePage;
import pages.deprecated.member.ulayer.LoginPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;





public class MemberUlayerProviderSearchStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}
	

	@Given("^the user is on the AARP Member medicare site loginn page$")
	public void user_login_page()
	{
		WebDriver wd = getLoginScenario().getWebDriverNew();
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
			//Map<String, String> loginCreds = new HashedMap();
			//loginCreds.put("user", "q1_apr_ulayer_479");
			//loginCreds.put("pwd","Password@1" );
			
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

			WebDriver wd = getLoginScenario().getWebDriverNew();

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
			/* Get expected data */
			/*Map<String, JSONObject> expectedDataMap = loginScenario
					.getExpectedJson(userName);
			JSONObject accountHomeExpectedJson = accountHomePage
					.getExpectedData(expectedDataMap);

			if (accountHomePage != null) {
				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
				getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
						accountHomePage);
				Assert.assertTrue(true);
				accountHomeActualJson = accountHomePage.accountHomeJson;
			}
			try {
				JSONAssert.assertEquals(accountHomeExpectedJson,
						accountHomeActualJson, true);
			} catch (JSONException e) {
				e.printStackTrace();
			}

			getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
					expectedDataMap);*/
		}
		@Then("^the user click on  providers button on the Plan Summary page$")
	public void navigate_to_ProviderSearch()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		accountHomePage.navigate_ProviderSearch();
		/*if(accountHomePage!= null){
            getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
            		accountHomePage);
            Assert.assertTrue(true);
             }
		else {
            Assert.fail(" Rally page not found");
             }*/
		}
	
	@Then("^the user navigate to Panel navigation and click on provider search$")
	public void navigate_to_PanelNavigation()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		/*accountHomePage.panelNavigation();*/
	}
	
	
	@Then("^the user navigate to Plan Summary page  and click on provider search$")
	public void navigate_to_PlanSummaryPage()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		/*accountHomePage.providerSearchRHandWidget();*/
	}
	
	@Then("^the user navigate to Benefits and Coverage page and click on provider search$")
	public void navigate_to_BenefitsandCoveragePage()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		/*accountHomePage.BenefitsandCoverageProviderSearch();*/
	}
	
	@Then("^the user navigate to Benefits and Coverage page and click on provider search in PCP Section$")
	public void navigate_to_BenefitsandCoveragePageinPCP()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		/*accountHomePage.providerSearchLinkinPCPSection();*/
	}
	
	@Then("^the user navigate to Claims page and click on provider search$")
	public void navigate_to_ClaimsPage()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		/*accountHomePage.providerSearchLinkinClaimsPage();*/
	}
	
	@Then("^the user navigate to Forms and Resources page and click on provider search$")
	public void navigate_to_FormsandResourcespage()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		/*accountHomePage.FormsandResourcesLinkinPlanSummaryPage();*/
	}
	
	
	
	@Then("^the user navigate to PHR  page and expand my Doctors and my Facility and click on provider search$")
	public void navigate_to_PHRpage()
	{
		AccountHomePage accountHomePage = (AccountHomePage)getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		/*accountHomePage.PHR();*/
	}
	
	
	
	
	

           
    }






	
	

	/*@After("@BlayerProviderSearch")
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
	}*/
	
	

