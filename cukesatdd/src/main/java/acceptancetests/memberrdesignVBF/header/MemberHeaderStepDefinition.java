package acceptancetests.memberrdesignVBF.header;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.memberrdesignVBF.BenefitsAndCoveragePage;
import pages.memberrdesignVBF.ClaimSummarypage;
import pages.memberrdesignVBF.FormsAndResourcesPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;

public class MemberHeaderStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 */
	@Then("^I should be able to see and use the Home tab$")
	public void I_should_be_able_to_see_and_use_the_Home_tab() {
		if (("NO").equalsIgnoreCase(MRScenario.isTestHarness)) {
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			rallyDashboard.validateHomeTab();
		} else {
			Assert.assertTrue("Skipping navigation to home tab as RallyDashboard is not integrated", true);
		}

	}

	/***
	 * 
	 */
	@Then("^I should be able to see and use the Find Care & Costs tab$")
	public void I_should_be_able_to_see_and_use_the_Find_Care_Costs_tab() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			Assert.assertTrue("Skipping Find Care and Cost validation in test harness", true);
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateFindCareCostTab();
		}
	}

	/***
	 * 
	 */
	@Then("^I should be able to see and use the Claims tab$")
	public void I_should_be_able_to_see_and_use_the_Claims_tab() {
		ClaimSummarypage claimSummarypage;
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			claimSummarypage = testHarness.panelNavigateToClaimsSummaryPage();
		} else {
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			claimSummarypage = rallyDashboard.panelNavigateToClaimsSummaryPage();
		}
		if (claimSummarypage != null) {
			getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, claimSummarypage);

		} else {
			Assert.fail("Claim Summary page is not loaded");
		}
	}

	/***
	 * 
	 */
	@Then("^clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation$")
	public void clicking_on_the_Claims_tab_should_allow_me_to_see_links_for_the_Claims_Summary_tab_and_Explanation_of_Benefits_tab_on_the_second_level_navigation() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			testHarness.validateClaimsL2Tabs();
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateClaimsL2Tabs();
		}
	}

	/***
	 * 
	 */
	@Then("^then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page$")
	public void then_click_the_Explanation_of_Benefits_tab() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			testHarness.validateEobL2Tab();
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateEobL2Tab();
		}
	}

	/***
	 * 
	 */
	@Then("^I should be able to see and use the Coverage & Benefits tab$")
	public void I_should_be_able_to_see_and_use_the_Coverage_Benefits_tab() {
		// Express the Regexp above with the code you wish you had
		BenefitsAndCoveragePage benefitsAndCoveragePage = null;
				if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
					TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			 benefitsAndCoveragePage = testHarness.validateBnCNaviation();
				}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		benefitsAndCoveragePage = rallyDashboard.validateBnCNaviation();
				}
		if (null == benefitsAndCoveragePage) {
			Assert.fail("Benefits Summary page is not loaded");
		}

	}

	/***
	 * 
	 */
	@Then("^clicking on the Coverage & Benefits tab should allow me to see links for the Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation$")
	public void clicking_on_the_Coverage_Benefits_tab_should_allow_me_to_see_links_for_the_Benefits_Summary_tab_the_Forms_Resources_tab_and_Explanation_of_Benefits_tab_on_the_second_level_navigation() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
	 testHarness.validateCoverageBenefitsL2Tabs();
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateCoverageBenefitsL2Tabs();
		}

	}

	/***
	 * 
	 */
	@Then("^then click the Forms & Resources tab and I should be directed to the Forms & Resources Page$")
	public void then_click_the_Forms_Resources_tab_and_I_should_be_directed_to_the_Forms_Resources_Page() {
		// Express the Regexp above with the code you wish you had
		FormsAndResourcesPage FormsAndResourcesPage = null;
				if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
					TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
					FormsAndResourcesPage = testHarness.clickFormsAndResourcesTab();
				}else{
		  RallyDashboardPage rallyDashboard = (RallyDashboardPage)
		  getLoginScenario() .getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		  FormsAndResourcesPage =  rallyDashboard.clickFormsAndResourcesTab();
				}
			if (null == FormsAndResourcesPage) {
				Assert.fail("Forms and Resources page is not loaded");
			}

	}

	/***
	 * 
	 */
	@Then("^then click the Order Materials tab and I should be directed to the Order Materials Page$")
	public void then_click_the_Order_Materials_tab_and_I_should_be_directed_to_the_Order_Materials_Page() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			testHarness.validateOrderPlanMaterialsPage();
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateOrderPlanMaterialsPage();
		}

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@Then("^upon clicking the Premium Payments tab I should navigate to the Premium Payments Overview Page$")
	public void upon_clicking_the_Premium_Payments_tab_I_should_navigate_to_the_Premium_Payments_Overview_Page()
			throws InterruptedException {
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			testHarness.validatePremiumPaymentPage();
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validatePremiumPaymentPage();
		}
	}

	/***
	 * 
	 */
	@Then("^I should be able to see and use the help button$")
	public void I_should_be_able_to_see_and_use_the_help_button() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			testHarness.validateContactUsPage();
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateContactUsPage();
		}
	}

	/***
	 * 
	 */
	@Then("^I should be able to see and use the Account/Profile dropdown and its options$")
	public void I_should_be_able_to_see_and_use_the_Account_Profile_dropdown_and_its_options() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			testHarness.validateAccountProfile();
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateAccountProfile();
		}

	}

	/***
	 * 
	 */
	@Then("^I should be able to see and use Health and Wellness page$")
	public void I_should_be_able_to_see_and_use_health_and_wellness_page() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			Assert.assertTrue("Skipping Health and Wellness functionality in test harness", true);
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateHealthnWellnessPage();
		}

	}

	/***
	 * 
	 */
	@And("^I am on the member page then I should be able to see the footer sections$")
	public void I_am_on_the_member_page_then_I_should_be_able_to_see_the_footer_sections() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			testHarness.validateFooterSection();
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateFooterSection();
		}
	}

	/***
	 * 
	 */
	@And("^Member Support and links under it should be displayed$")
	public void Member_Support_and_links_under_it_should_be_displayed() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			testHarness.validateMemberSupport();
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateMemberSupport();
		}
	}

	/***
	 * 
	 */
	@And("^Quick links and links under it should be displayed$")
	public void Quick_links_and_links_under_it_should_be_displayed() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			testHarness.validateQuickLinks();
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateQuickLinks();
		}
	}

	/***
	 * 
	 */
	@And("^I have access to the Rally Provider Search Tool and I see the Saved option under Quick Links$")
	public void I_have_access_to_the_Rally_Provider_Search_Tool_and_I_see_the_Saved_option_under_Quick_Links() {
		// Express the Regexp above with the code you wish you had
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			Assert.assertTrue("Skipping Saved validation in footer as Rally Provider Search tool is not integrated", true);
		}else{
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateSavedLink();
		}
	}

}
	