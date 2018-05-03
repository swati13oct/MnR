package acceptancetests.memberredesign.header;

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
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard_deprecated.member.drugcostestimator.blayer.DrugCostEstimatorPage;
import pages.memberredesign_deprecated.bluelayer.AccountHomePage;
import pages.memberredesign_deprecated.bluelayer.LoginPage;

/**
 * Functionality : Covers step definition methods related to member redesign Header section
 */
public class MemberRedesignHeaderStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo : Finds authenticated user to login
	 * @param memberAttributes
	 */
	@Given("^I am a authenticated member on the member redesign site Header$")
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

	/**
	 * @toDo : user gets logged in to new member site
	 */
	@When("^the above plantype user logs in UMS Site Desktop Header$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		String category = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		LoginPage loginPage = new LoginPage(wd);
		//loginPage.loginToStageTestHarness();
		getLoginScenario().saveBean(PageConstantsMnR.LOGIN_PAGE, loginPage);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.thloginWith(userName, pwd,category);
		getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE, accountHomePage);

	}

	/**
	 * @toDo : View Global Navigation Header
	 * @throws InterruptedException
	 */
	@When("^I view the global navigation Header$")
	public void I_view_the_global_navigation() throws InterruptedException {
		// Express the Regexp above with the code you wish you had
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
		AccountHomePage accountHomePage = new AccountHomePage(wd);
		getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE, accountHomePage);
	}

	/**
	 *  @toDO : see and checks Header
	 */
	@Then("^I should be able to see and use the Home tab Header$")
	public void I_should_be_able_to_see_and_use_the_Home_tab() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateHeader();
	}

	/**
	 *  @toDo : see and validate Find care and cost tab header
	 */
	@Then("^I should be able to see and use the Find Care & Costs tab Header$")
	public void I_should_be_able_to_see_and_use_the_Find_Care_Costs_tab() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateFindCareCostTab();
	}

	/**
	 *  @toDo : see and validate Claims tab Header
	 */
	@Then("^I should be able to see and use the Claims tab Header$")
	public void I_should_be_able_to_see_and_use_the_Claims_tab() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateClaims();

	}

	/**
	 * @toDo : Clicks on Claims tab and see for claims summary tab and Explanation of Benefits tab on second navigation level 
	 */
	@Then("^clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation Header$")
	public void clicking_on_the_Claims_tab_should_allow_me_to_see_links_for_the_Claims_Summary_tab_and_Explanation_of_Benefits_tab_on_the_second_level_navigation() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateClaimsL2Tabs();
	}

	/**
	 * @toDo : Clicks on claims summary tab and navigate to claims summary page
	 */
	@Then("^then click the Claims Summary tab and I should be directed to the Claims Summary Page Header$")
	public void then_click_the_Claims_Summary_tab() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.checkModelPopup();
		accountHomePage.clickClaimsSummary();
	}

	/**
	 * @toDo : Clicks on Explanation of Benefits tab and navigate to xplanation of Benefits Page
	 */
	@Then("^then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page Header$")
	public void then_click_the_Explanation_of_Benefits_tab() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.checkModelPopup();
		accountHomePage.clickeob();
	}

	/**
	 * @toDo : See and validate Coverage & Benefits tab
	 */
	@Then("^I should be able to see and use the Coverage & Benefits tab Header$")
	public void I_should_be_able_to_see_and_use_the_Coverage_Benefits_tab() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateCoverageBenefits();
	}

	/**
	 *  @toDo : Clicks on Coverage & Benefits tab and see links for Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation
	 */
	@Then("^clicking on the Coverage & Benefits tab should allow me to see links for the Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation Header$")
	public void clicking_on_the_Coverage_Benefits_tab_should_allow_me_to_see_links_for_the_Benefits_Summary_tab_the_Forms_Resources_tab_and_Explanation_of_Benefits_tab_on_the_second_level_navigation() {
		// Express the Regexp above with the code you wish you had
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		//accountHomePage.validateCoverageBenefitsL2Tabs();

	}
	/**
	 * @toDo : clicks  Benefits Summary tab and Navigate to Benefits Summary Page
	 */
	@Then("^then click the Benefits Summary tab and I should be directed to the Benefits Summary Page Header$")
	public void then_click_the_Benefits_Summary_tab_and_I_should_be_directed_to_the_Benefits_Summary_Page() {
		// Express the Regexp above with the code you wish you had
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		//accountHomePage.clickBenefitsSummary();

	}

	/**
	 *  @toDo : clicks on Forms & Resources tab and Navigate to the Forms & Resources Page
	 */
	@Then("^then click the Forms & Resources tab and I should be directed to the Forms & Resources Page Header$")
	public void then_click_the_Forms_Resources_tab_and_I_should_be_directed_to_the_Forms_Resources_Page() {
		// Express the Regexp above with the code you wish you had
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		//accountHomePage.clickFormsResources();
	}

	/**
	 *  @toDo : click on Order Materials tab and navigate to Order Materials Page
	 */
	@Then("^then click the Order Materials tab and I should be directed to the Order Materials Page Header$")
	public void then_click_the_Order_Materials_tab_and_I_should_be_directed_to_the_Order_Materials_Page() {
		// Express the Regexp above with the code you wish you had
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		//accountHomePage.clickOrderMaterials();

	}

	/**
	 *  @toDo : See and click on Premium payment 
	 */
	@Then("^I should be able to see and use the Premium Payments tab Header$")
	public void I_should_be_able_to_see_and_use_the_Premium_Payments_tab() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.clickPremiumPayment();
	}

	/**
	 *  @toDo : clicks on Premium Payments tab and navigate to the Premium Payments Overview Page
	 */
	@Then("^upon clicking the Premium Payments tab I should navigate to the Premium Payments Overview Page Header$")
	public void upon_clicking_the_Premium_Payments_tab_I_should_navigate_to_the_Premium_Payments_Overview_Page() {
		// Express the Regexp above with the code you wish you had

	}
	/**
	 *  @toDo : See and Validate Help button present on header
	 */
	@Then("^I should be able to see and use the help button Header$")
	public void I_should_be_able_to_see_and_use_the_help_button() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateHelp();

	}

	/**
	 * @toDo : see and validates the Account/Profile dropdown and its options 
	 */
	@Then("^I should be able to see and use the Account/Profile dropdown and its options Header$")
	public void I_should_be_able_to_see_and_use_the_Account_Profile_dropdown_and_its_options() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateAccountProfile();

	}

	/**
	 *  @toDo : From Member page i see footer section and validate claims , check pop up and validate footer section
	 */
	@When("^I am on the member page then I should be able to see the footer sections Header$")
	public void I_am_on_the_member_page_then_I_should_be_able_to_see_the_footer_sections() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateClaimsL2Tabs();
		accountHomePage.checkModelPopup();
		accountHomePage.validateFooterSection();
	}

	/**
	 *  @toDo : Check for Member support and validate its link under it
	 */
	@When("^Member Support and links under it should be displayed Header$")
	public void Member_Support_and_links_under_it_should_be_displayed() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateMemberSupport();
	}

	/**
	 * @toDo : Check for quick links and validate its link under it
	 */
	@When("^Quick links and links under it should be displayed Header$")
	public void Quick_links_and_links_under_it_should_be_displayed() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateQuickLinks();
	}

	/**
	 *  @toDo : Access to Rally Provider Search Tool and checks for Saved option under Quick Links
	 */
	@When("^I have access to the Rally Provider Search Tool and I see the Saved option under Quick Links Header$")
	public void I_have_access_to_the_Rally_Provider_Search_Tool_and_I_see_the_Saved_option_under_Quick_Links() {
		// Express the Regexp above with the code you wish you had
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE);
		accountHomePage.validateSavedLink();
	}

}
