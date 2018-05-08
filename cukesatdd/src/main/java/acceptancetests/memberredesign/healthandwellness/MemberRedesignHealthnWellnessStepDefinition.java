package acceptancetests.memberredesign.healthandwellness;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.java.en.When;
//import pages.dashboard.member.drugcostestimator.blayer.DrugCostEstimatorPage;
//import pages.memberredesign.bluelayer.AccountHomePage;
//import pages.memberredesign.bluelayer.HealthAndWellness;
import pages.regression.healthandwellness.HealthAndWellnessPage;
//import pages.memberredesign.bluelayer.LoginPage;

/**
 * Functionality : Covers step definition methods related to member redesign Health and Wellness page .
 */
public class MemberRedesignHealthnWellnessStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo : Finds authenticated user to login with Health n Wellness rewards
	 * @param memberAttributes
	 */
	/*@Given("^I am a authenticated member on the member redesign site HW$")
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
*/
	/**
	 * @toDo : User gets logged in to member site
	 */
	/*@When("^the above plantype user logs in UMS Site Desktop HW$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		String category = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		//LoginPage loginPage = new LoginPage(wd);
		//loginPage.loginToStageTestHarness();
		getLoginScenario().saveBean(PageConstantsMnR.LOGIN_PAGE, loginPage);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.thloginWith(userName, pwd,category);
		getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);

	}
*/
	/**
	 * @toDo : View Health n Wellness Global Navigation
	 * @throws InterruptedException
	 */
	@When("^I view the global navigation HW$")
	public void I_view_the_global_navigation() throws InterruptedException {
		// Express the Regexp above with the code you wish you had
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		//DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		//dce.changeUrlToNewDCEPage();
		//AccountHomePage accountHomePage = new AccountHomePage(wd);
		//getLoginScenario().saveBean(PageConstants.MEM_REDESIGN_ACCOUNT_HOME_PAGE, accountHomePage);
		HealthAndWellnessPage healthnWellnessPage = new HealthAndWellnessPage(wd);
		getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE, healthnWellnessPage);
	}

	/**
	 * @toDo : Clicks on Health and Wellness Tab
	 */
	@When("^then click the health and wellness tab HW$")
	public void then_click_the_health_and_wellness_tab() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickHealthnWellnessTab();
	}

	/**
	 * @toDo : See health n Wellness Generic dashboard and lifestyle , learning and rewards level 2 tabs
	 */
	@When("^I should see the H&W Generic dashboard and lifestyle,learning and rewards L2 tabs HW$")
	public void I_should_see_the_H_W_Generic_dashboard_and_tabs() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.validateHnWDashboardnL2Tabs();

	}

	/**
	 * @toDo : Clicks on Lifestyle tab and navigate to lifestyle page
	 */
	@When("^then click the Lifestyle tab and I should be directed to Lifestyle Page HW$")
	public void then_click_the_Lifestyle_tab_and_I_should_be_directed_to_Lifestyle_Page() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickLifestyleTab();
		healthnWellnessPage.validateLifestylePage();

	}

	/**
	 * @toDo : Clicks on Learning tab and navigate to learning page.
	 */
	@When("^then click the Learning tab and I should be directed to Learning Page HW$")
	public void then_click_the_Learning_tab_and_I_should_be_directed_to_Learning_Page() {
		// Express the Regexp above with the code you wish you had
		HealthAndWellnessPage healthnWellnessPage = (HealthAndWellnessPage) getLoginScenario().getBean(PageConstantsMnR.MEM_REDESIGN_HEALTH_AND_WELLNESS_PAGE);
		healthnWellnessPage.clickLearningTab();
		healthnWellnessPage.validateLearningPage();

	}

	@When("^then click the Rewards tab and I should be directed to Rewards Page HW$")
	public void then_click_the_Rewards_tab_and_I_should_be_directed_to_Rewards_Page() {
		// Express the Regexp above with the code you wish you had

	}



}
