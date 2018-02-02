package acceptancetests.memberrdesign.login;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.member.ulayer.ProviderSearchPage;
import pages.dashboard.member.ulayer.RallyDashboardPage;
import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.member.ulayer.TeamHLoginUlayer;
import pages.member.ulayer.TestHarness;
import atdd.framework.MRScenario;

public class MemberLoginStepDefinition {
	@Autowired
	MRScenario loginScenario;
	String category = null;
	WebDriver wd = null;
	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^I am a authenticated member on the member redesign site for Direct Login$")
	public void I_am_a_authenticated_member_on_the_member_redesign_site(DataTable memberAttributes) {
		wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		category = memberAttributesMap.get("Member Type");

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

	}
	
	@When("^the above plantype user logs in member redesign for Direct Login$")
	public void plantype_user_logs_in() throws InterruptedException {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		
		TeamHLoginUlayer THloginPage = new TeamHLoginUlayer(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);
		if(("YES").equalsIgnoreCase(MRScenario.isTestHarness)){
			TestHarness testHarness = (TestHarness) THloginPage.loginWith(userName, pwd);
			if (testHarness != null) {
				getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE,
						testHarness);		}
			else{
				Assert.fail("Login not successful...");
			}
		}
		else{
			
		
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) THloginPage.loginWith(userName, pwd);
		if (rallyDashboard != null) {
			getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE,
					rallyDashboard);		}
		else{
			Assert.fail("Login not successful...");
		}
		}
		
	}
	
	@Then("^User should be able to validate Dashboard elements$")
	public void user_validate_dashboard_elements() throws InterruptedException {
		
		if("YES".equalsIgnoreCase(MRScenario.isTestHarness)){
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			
			testHarness.validateTestHarnessElements(category);
		}else{
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario().getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			validateURLNavigation();
		rallyDashboard.validateDashboardElements(category);	
		}
	}
	
	@And("^User should be ale to navigate to secondary page$")
	public void user_validate_seconday_page_navigation() throws InterruptedException {
		BenefitsAndCoveragePage benefitsAndCoveragePage = null;
		if("YES".equalsIgnoreCase(MRScenario.isTestHarness)){
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			
			benefitsAndCoveragePage = testHarness.navigateDirectToBnCPag();
		}else{
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario().getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			benefitsAndCoveragePage = rallyDashboard.navigateDirectToBnCPag();
		}
		
		if (benefitsAndCoveragePage == null) {			
			Assert.fail("BnC page is not loaded");
		}
	}
	
	public void validateURLNavigation()  {
		System.out.println("Current category: "+category);

		System.out.println("Current URL: "+wd.getCurrentUrl());
		switch(category){
		case "UhcMapdInd": 
			Assert.assertTrue(wd.getCurrentUrl().contains("/medicare/dashboard"));
		break;
		case "AARPMapdInd": 
			Assert.assertTrue(wd.getCurrentUrl().contains("/aarp/dashboard"));
		break;
		case "GroupRetireeMapd": 
			Assert.assertTrue(wd.getCurrentUrl().contains("/retiree/dashboard"));
		break;

		case "Ship": 
			Assert.assertTrue(wd.getCurrentUrl().contains("/aarp/dashboard"));
		break;
		case "PCP": 
			Assert.assertTrue(wd.getCurrentUrl().contains("/pcp/dashboard"));
		break;
		case "Medica": 
			Assert.assertTrue(wd.getCurrentUrl().contains("/medica/dashboard"));
		break;
		default: System.out.println("Please specifiy a specific member type ");
		
}

	}
	
}
