package acceptancetests.member.redesign.bluelayer;

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
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.dce.bluelayer.DrugCostEstimatorPage;
import pages.memberredesign.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;

public class MemberRedesignUmcStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^I am a authenticated member on the member redesign site$")
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
	
	@When("^the above plantype user logs in UMS Site Desktop$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		String category = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		LoginPage loginPage = new LoginPage(wd);
		loginPage.loginToTeamhTestHarness();
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.thloginWith(userName, pwd,category);
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
	
	}
	
	@When("^I view the global navigation$")
	public void I_view_the_global_navigation() throws InterruptedException {
	    // Express the Regexp above with the code you wish you had
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
		AccountHomePage accountHomePage = new AccountHomePage(wd);
		getLoginScenario().saveBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE, accountHomePage);
	}

	@Then("^I should be able to see and use the Home tab$")
	public void I_should_be_able_to_see_and_use_the_Home_tab() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateHeader();
	}

	@Then("^I should be able to see and use the Find Care & Costs tab$")
	public void I_should_be_able_to_see_and_use_the_Find_Care_Costs_tab() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateFindCareCostTab();
	}

	@Then("^I should be able to see and use the Claims tab$")
	public void I_should_be_able_to_see_and_use_the_Claims_tab() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateClaims();

	}

	@Then("^clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation$")
	public void clicking_on_the_Claims_tab_should_allow_me_to_see_links_for_the_Claims_Summary_tab_and_Explanation_of_Benefits_tab_on_the_second_level_navigation() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateClaimsL2Tabs();
	}

	@Then("^then click the Claims Summary tab and I should be directed to the Claims Summary Page$")
	public void then_click_the_Claims_Summary_tab() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.clickClaimsSummary();
	}


	@Then("^then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page$")
	public void then_click_the_Explanation_of_Benefits_tab() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.clickeob();
	}

	@Then("^I should be able to see and use the Coverage & Benefits tab$")
	public void I_should_be_able_to_see_and_use_the_Coverage_Benefits_tab() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateCoverageBenefits();
	}

	@Then("^clicking on the Coverage & Benefits tab should allow me to see links for the Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation$")
	public void clicking_on_the_Coverage_Benefits_tab_should_allow_me_to_see_links_for_the_Benefits_Summary_tab_the_Forms_Resources_tab_and_Explanation_of_Benefits_tab_on_the_second_level_navigation() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateCoverageBenefitsL2Tabs();

	}

	@Then("^then click the Benefits Summary tab and I should be directed to the Benefits Summary Page$")
	public void then_click_the_Benefits_Summary_tab_and_I_should_be_directed_to_the_Benefits_Summary_Page() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.clickBenefitsSummary();

	}


	@Then("^then click the Forms & Resources tab and I should be directed to the Forms & Resources Page$")
	public void then_click_the_Forms_Resources_tab_and_I_should_be_directed_to_the_Forms_Resources_Page() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.clickFormsResources();
	}


	@Then("^then click the Order Materials tab and I should be directed to the Order Materials Page$")
	public void then_click_the_Order_Materials_tab_and_I_should_be_directed_to_the_Order_Materials_Page() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.clickOrderMaterials();

	}

	@Then("^I should be able to see and use the Premium Payments tab$")
	public void I_should_be_able_to_see_and_use_the_Premium_Payments_tab() {
	    // Express the Regexp above with the code you wish you had

	}

	@Then("^upon clicking the Premium Payments tab I should navigate to the Premium Payments Overview Page$")
	public void upon_clicking_the_Premium_Payments_tab_I_should_navigate_to_the_Premium_Payments_Overview_Page() {
	    // Express the Regexp above with the code you wish you had

	}

	@Then("^I should be able to see and use the help button$")
	public void I_should_be_able_to_see_and_use_the_help_button() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateHelp();

	}
	
	@Then("^I should be able to see and use the Account/Profile dropdown and its options$")
	public void I_should_be_able_to_see_and_use_the_Account_Profile_dropdown_and_its_options() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateAccountProfile();

	}

}
