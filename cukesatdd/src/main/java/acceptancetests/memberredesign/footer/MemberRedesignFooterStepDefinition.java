package acceptancetests.memberredesign.footer;

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
import pages.memberredesign.bluelayer.LoginPage;

public class MemberRedesignFooterStepDefinition {
	
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
		loginPage.loginToStageTestHarness();;
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.thloginWith(userName, pwd,category);
		getLoginScenario().saveBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE, accountHomePage);
	
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
	
	@When("^I am on the member page then I should be able to see the footer sections$")
	public void I_am_on_the_member_page_then_I_should_be_able_to_see_the_footer_sections() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.checkModelPopup();
		accountHomePage.validateClaimsL2Tabs();
		accountHomePage.checkModelPopup();
		accountHomePage.validateFooterSection();
	}

	@When("^Member Support and links under it should be displayed$")
	public void Member_Support_and_links_under_it_should_be_displayed() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateMemberSupport();
	}

	@When("^Quick links and links under it should be displayed$")
	public void Quick_links_and_links_under_it_should_be_displayed() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateQuickLinks();
	}

	@When("^I have access to the Rally Provider Search Tool and I see the Saved option under Quick Links$")
	public void I_have_access_to_the_Rally_Provider_Search_Tool_and_I_see_the_Saved_option_under_Quick_Links() {
	    // Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateSavedLink();
	}

}
