package acceptancetests.memberrdesignVBF.common;

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
import gherkin.formatter.model.DataTableRow;
import pages.memberrdesignVBF.LoginPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.SecurityQuestionsPage;
import pages.memberrdesignVBF.TestHarness;

public class CommonStepDefinition {
	@Autowired
	MRScenario loginScenario;
	String category = null;
	WebDriver wd = null;
	private static Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();

	public CommonStepDefinition(MRScenario loginScenario) {
		this.loginScenario = loginScenario;

	}

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 * @param memberAttributes
	 */
	/*@Given("^I am a authenticated member on the member redesign site for Direct Login$")
	public void I_am_a_authenticated_member_on_the_member_redesign_site(DataTable memberAttributes) {
		memberAttributesMap.clear();

		CommonStepDefinition.storeAttributesInMap(memberAttributes);
		List<String> desiredAttributes = CommonStepDefinition.storeMapAttributesInList();
		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);
		
		String userName = null;
		String pwd = null;
		if (null == loginCreds) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}
	}/*

	/***
	 * 
	 * @throws InterruptedException
	 */
	/*@When("^the above plantype user logs in member redesign for Direct Login$")
	public void plantype_user_logs_in(DataTable memberattributes) throws InterruptedException {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		launchBrowser();
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		if ("YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
			SecurityQuestionsPage securityQuestionsPage = (SecurityQuestionsPage) loginPage.loginWith(userName, pwd);
			if (securityQuestionsPage != null) {
				getLoginScenario().saveBean(PageConstants.SECURITY_QUESTIONS_PAGE, securityQuestionsPage);
			} else {
				Assert.fail("securityQuestionsPage is not displayed...");
			}
			i_enter_the_security_questions(memberattributes);
		} else {
			if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
				TestHarness testHarness = (TestHarness) loginPage.loginWithLegacy(userName, pwd);
				if (testHarness != null) {
					getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarness);
				} else {
					Assert.fail("Login not successful...");
				}
			} else {

				RallyDashboardPage rallyDashboard = (RallyDashboardPage) loginPage.loginWithLegacy(userName, pwd);
				if (rallyDashboard != null) {
					getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
				} else {
					Assert.fail("Login not successful...");
				}
			}
		}
	}

	public void i_enter_the_security_questions(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String friendname = memberAttributesMap.get("friendname");
		String favouritecolor = memberAttributesMap.get("favouritecolor");
		String PhoneNumber = memberAttributesMap.get("PhoneNumber");

		SecurityQuestionsPage securityQuestionsPage = (SecurityQuestionsPage) getLoginScenario()
				.getBean(PageConstants.SECURITY_QUESTIONS_PAGE);

		securityQuestionsPage.validateTheSecurityQues(friendname, favouritecolor, PhoneNumber);
	}

	@Then("^member should navigate to Home page$")
	public void member_should_navigate_to_home_page() throws InterruptedException {
		if ("YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
			LoginPage loginPage = (LoginPage) getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
			getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
			if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
				TestHarness testHarness = (TestHarness) loginPage.navigateToHomePage();
				if (testHarness != null) {
					getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarness);
				} else {
					Assert.fail("Login not successful...");
				}
			} else {

				RallyDashboardPage rallyDashboard = (RallyDashboardPage) loginPage.navigateToHomePage();
				if (rallyDashboard != null) {
					getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
				} else {
					Assert.fail("Login not successful...");
				}
			}
		} else {
			Assert.assertTrue("Skipping this functionality as already done in previous step!!!", true);
		}
	}

	public static Map<String, String> storeAttributesInMap(DataTable memberAttributes) {

		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			System.out.println("Key to store in Map:" + memberAttributesRow.get(i).getCells().get(0));
			System.out.println("Value to store in Map:" + memberAttributesRow.get(i).getCells().get(1));
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		return memberAttributesMap;
	}

	public static List<String> storeMapAttributesInList() {
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		return desiredAttributes;
	}

	public static Map<String, String> getMemberAttributeMap() {
		return memberAttributesMap;
	}

	public void launchBrowser() {
		if ("offline-stage".equalsIgnoreCase(MRScenario.environment)){
			wd = getLoginScenario().getWebDriverNew();
		}else{
		wd = getLoginScenario().getWebDriverNew();
	
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		CommonStepDefinition commonStepDefinition = new CommonStepDefinition(loginScenario);
		getLoginScenario().saveBean(CommonConstants.COMMONSTEPDEFINITIONMEMVBF, commonStepDefinition);

	}*/
	/***
	 * 
	 */
	/*@Then("^I should see Need Help section at the bottom$")
	public void I_should_see_nned_help_section_at_botom() {
		// Express the Regexp above with the code you wish you had
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			testHarness.validateNeedHelpSection();
		} else {
		RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
				.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
		rallyDashboard.validateNeedHelpSection();
		}

	}*/
}
