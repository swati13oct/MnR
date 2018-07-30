package acceptancetests.memberrdesignVBF.profileandpreference;

import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.ProfilePreferencesPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author akapoo18
 *
 */
public class ProfileandPreferencesStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
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
	@And("^the user clicks on Edit Preferences for EPMP$")
	public void user_click_editPreferences_link_EPMP() throws InterruptedException {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.clickEditPreferencesButton();

	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^the user clicks on Edit Preferences$")
	public void user_click_editPreferences_link() throws InterruptedException {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		CommunicationPreferencePage communicationPrefPage = ProfilePreferencesPage.clickEditPreferencesButton();
		if (communicationPrefPage != null)
			getLoginScenario().saveBean(PageConstants.COMMUNICATION_PREFERENCE_PAGE, communicationPrefPage);				
			else
				Assert.fail("Error in validating communication preferences page");	
	}
	/**
	 * @toDo : The user clicks on health safe Id password
	 */

	@When("^I click the HEALTHSAFE ID PASSWORD link$")
	public void i_click_the_HEALTHSAFE_ID_PASSWORD_link() throws InterruptedException {

		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateHealthSafeIdLink();
	}

	/**
	 * @toDo : The user should see the breadcrumb in the upper left side
	 */

	@Then("^I should see the breadcrumb  in the upper left side of the page$")
	public void i_should_see_the_breadcrumb_in_the_upper_left_side_of_the_page() throws InterruptedException {

		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateBreadCrumb();

	}

	/**
	 * @toDo : The functionality of Bread crumb
	 */
	@And("^clicking the link should lead me back to the Account Settings page of the member site$")
	public void clicking_the_link_should_lead_me_back_to_the_Account_Settings_page_of_the_Medica_member_site() {
		ProfilePreferencesPage ProfilePreferencesPage = (pages.memberrdesignVBF.ProfilePreferencesPage) getLoginScenario()
				.getBean(PageConstants.ProfilePreferencesPage);

		ProfilePreferencesPage.validateBreadCrumbClick();

	}

}
