package acceptancetests.memberredesign.healthandwellness;

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
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.member.drugcostestimator.blayer.DrugCostEstimatorPage;
import pages.memberredesign.bluelayer.AccountHomePage;
import pages.memberredesign.bluelayer.HealthAndWellness;
import pages.memberredesign.bluelayer.LoginPage;

public class MemberRedesignHealthnWellnessStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^I am a authenticated member on the member redesign site HW$")
	public void I_am_a_authenticated_member_on_the_member_redesign_site(DataTable memberAttributes) {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
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
			getLoginScenario().saveBean(LoginCommonConstants.CATOGERY, category);
		}
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);

	}
	
	@When("^the above plantype user logs in UMS Site Desktop HW$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		String category = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		LoginPage loginPage = new LoginPage(wd);
		loginPage.loginToStageTestHarness();
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.thloginWith(userName, pwd,category);
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
	
	}
	
	@When("^I view the global navigation HW$")
	public void I_view_the_global_navigation() throws InterruptedException {
	    // Express the Regexp above with the code you wish you had
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		//DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		//dce.changeUrlToNewDCEPage();
		//AccountHomePage accountHomePage = new AccountHomePage(wd);
		//getLoginScenario().saveBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE, accountHomePage);
		HealthAndWellness healthnWellnessPage = new HealthAndWellness(wd);
		getLoginScenario().saveBean(PageConstants.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE, healthnWellnessPage);
	}
	
	@When("^then click the health and wellness tab HW$")
	public void then_click_the_health_and_wellness_tab() {
	    // Express the Regexp above with the code you wish you had
		HealthAndWellness healthnWellnessPage = (HealthAndWellness) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickHealthnWellnessTab();
	}

	@When("^I should see the H&W Generic dashboard and lifestyle,learning and rewards L2 tabs HW$")
	public void I_should_see_the_H_W_Generic_dashboard_and_tabs() {
	    // Express the Regexp above with the code you wish you had
		HealthAndWellness healthnWellnessPage = (HealthAndWellness) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.validateHnWDashboardnL2Tabs();

	}


	@When("^then click the Lifestyle tab and I should be directed to Lifestyle Page HW$")
	public void then_click_the_Lifestyle_tab_and_I_should_be_directed_to_Lifestyle_Page() {
	    // Express the Regexp above with the code you wish you had
		HealthAndWellness healthnWellnessPage = (HealthAndWellness) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickLifestyleTab();
		healthnWellnessPage.validateLifestylePage();

	}

	@When("^then click the Learning tab and I should be directed to Learning Page HW$")
	public void then_click_the_Learning_tab_and_I_should_be_directed_to_Learning_Page() {
	    // Express the Regexp above with the code you wish you had
		HealthAndWellness healthnWellnessPage = (HealthAndWellness) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickLearningTab();
		healthnWellnessPage.validateLearningPage();

	}

	@When("^then click the Rewards tab and I should be directed to Rewards Page HW$")
	public void then_click_the_Rewards_tab_and_I_should_be_directed_to_Rewards_Page() {
	    // Express the Regexp above with the code you wish you had

	}

	

}
