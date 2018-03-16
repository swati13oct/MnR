package acceptancetests.memberrdesignVBF.profileandpreference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.LoginPage;
import pages.memberrdesignVBF.ProfilePreferencesPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.DataTable;

/**
 * @author akapoo18
 *
 */
public class ProfileandPreferencesStepDefinition {

	@Autowired
	MRScenario loginScenario;

	private String userName = null;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@Given("^registered member with following details for Profile and Preferences flow$")
	public void login_with_member(DataTable memberAttributes) throws InterruptedException {
		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();

		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getmemberRedesignVbfWithDesiredAttributes(desiredAttributes);
		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			this.userName = userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		// Inserting new code fr Rally Dashboard
		LoginPage THloginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) THloginPage.loginWith(userName, pwd);
			if (testHarness != null) {
				getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarness);
			} else {
				Assert.fail("Login not successful...");
			}
		} else {

			RallyDashboardPage rallyDashboard = (RallyDashboardPage) THloginPage.loginWith(userName, pwd);
			if (rallyDashboard != null) {
				getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
			} else {
				Assert.fail("Login not successful...");
			}
		}
	}

	/***
	 * 
	 */
	@And("^the user validates the Plan Name, Member name, Member ID and account section in UMS site")
	public void user_Validates_FED_PROFILE_MEMBERNAME_ID_AccountProfile() {
		ProfilePreferencesPage ProfilePreferencesPage = (ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		if (ProfilePreferencesPage == null) {
			System.out.println(" Variable is NULL");
		}
		ProfilePreferencesPage.validatePlanNameMemberidNameAcountProfile();

	}

	/***
	 * 
	 */
	@Then("^the user validates the presence of Plan Name")
	public void UserValidatePlanName() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validatePlanName();

	}

	/***
	 * 
	 */
	@Then("^the user validates the presence of Communication preferences header")
	public void UserValidatescommunicationpreferencesheader() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validatecommunicationpreferencesheader();

	}

	/***
	 * 
	 */
	@Then("^the user validates the presence of Back to Profile and Preferences links")
	public void UserValidatesBacktoPNPlink() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateBacktoPNPlink();

	}

	/***
	 * 
	 */
	@Then("^the user validates the Note section")
	public void UserValidatesNoteSection() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateNoteSection();

	}

	/***
	 * 
	 */
	@Then("^the user validates the Save Preferences Button")
	public void UserValidatesSavePreferences() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateSavePreferences();

	}

	/***
	 * 
	 */
	@Then("^the user validates the Go Green Header")
	public void UserValidatesGoGreenHeader() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateGoGreenHeader();

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^the user navigates to Rally Dashboard Page for profile and preference$")
	public void user_navigates_to_RallyDashboardPage_Page() throws InterruptedException {
		ProfilePreferencesPage ProfilePreferencesPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			ProfilePreferencesPage = testHarness.navigateDirectToProfilePage();
		} else {
			RallyDashboardPage rallyDashboardPage = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			ProfilePreferencesPage = rallyDashboardPage.navigateDirectToProfilePage();
		}
		if (ProfilePreferencesPage != null) {
			getLoginScenario().saveBean(PageConstants.ProfilePreferencesPage, ProfilePreferencesPage);
		}
		if (ProfilePreferencesPage == null) {
			System.out.println(" Variable is NULL!");

		}

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^the user clicks on Edit Preferences$")
	public void user_click_editPreferences_link() throws InterruptedException {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.clickEditPreferencesButton();

	}

}
