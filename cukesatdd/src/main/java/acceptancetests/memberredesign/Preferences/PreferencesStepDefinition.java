package acceptancetests.memberredesign.Preferences;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.member_deprecated.bluelayer.LoginPage2;
import pages.memberrdesignVBF.ProfilePreferencesPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimSummarypage;
import pages.regression.profileandpreferences.CommunicationPreferencePage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import pages.regression.testharness.TestHarness;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality: Profile And Preferences page
 */
public class PreferencesStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}


	/**
	 * @toDo : Validates the headers on Go green page
	 */
	@Then("^the user validates headers on Preferences page")
	public void uservalidatesgogreenheader() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);

		communicationPrefPage.validateheader();
	}

	
	
	/***
	 * 
	 */
	@Then("^the user validates the presence of Plan Name on Communication Preferences Page")
	public void UserValidatesPlanName() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);

		String planName=(String) getLoginScenario().getBean(CommonConstants.PLAN_NAME_ON_PROFILE_PAGE);
		communicationPrefPage.validatePlanName(planName);

	}

	@Then("^the user validate the presence of Plan Name on Communication Preferences Page for Ship$")
	public void UserValidatesPlanNameForShip() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);

		String planName=(String) getLoginScenario().getBean(CommonConstants.PLAN_NAME_ON_PROFILE_PAGE);
		communicationPrefPage.validatePlanNameForShip(planName);

	}
	

	/**
	 * @toDo : Validates the Go green button in Communication Preferences
	 *       section
	 */
	@Then("^the user validates the iframe on Communication Preferences Page")
	public void uservalidatesgogreenpagerouting() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);

		communicationPrefPage.validategogreenbutton();
	}
	
	
	@Then("^the user validates that the iframe is not present for a ship member")
	public void uservalidatesIframeForAShipMember() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);

		communicationPrefPage.validateIframeForAShipMember();
	}
	
	
	
	/**
	 * @toDo : Validates the I have read checkbox on Go green page
	 */
	@Then("^the user validates the I have read checkbox and check it")
	public void UserValidatesCheckbox() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPrefPage.validateCheckbox();

	}
	/**
	 * @toDo : Validates the save preferences functionality on Go green page
	 */
	@Then("^the user validates the Save Preferences Button")
	public void UserValidatesSavePreferences() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPrefPage.validateSavePreferences();

	}
/**
	 * @toDo : Validates the presence of Back to Profile and Preferences links
	 *       on Go green page
	 */
	@Then("^the user validates the presence of Back links on Preferences page$")
	public void UserValidatesBacktoPNPlink() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		ProfileandPreferencesPage profilePage=communicationPrefPage.validateBacktoPNPlink();
		if (profilePage == null) {
			Assert.fail("Back link to Profile page is not working");
		}
	}

	/**
	 * @toDo : Validates the presence of Back link to Profile page from
	 *       on Go green page
	 */
	@Then("^the user validates the presence of Back links on ship Preferences page$")
	public void UserValidatesBacktoProfilePagelinkForShip() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		ProfileandPreferencesPage profilePage=communicationPrefPage.validateBacktoPNPlinkForShip();
		if (profilePage == null) {
			Assert.fail("Back link to Profile page is not working");
		}
	}
	

	 
	@Then("^the user changes the online preference and saves the change")
	public void userChangesOnlinePref() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);

		Assert.assertTrue("Communication preference online preference changed and verified",
				communicationPrefPage.changeAndVerifyOnlinePreference());
	}
	
	 
	@Then("^the user validates the functionality of updating the email on the iframe")
	public void userChangesEmailOnTheIframs() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage)getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);

		communicationPreferencesPage.validateEmailUpdateOnIframe();
	}

	/**
	 * @toDo : Validates the headers and labels of the communication preferences section for SHIP
	 */

	@Then("^the user validates the headers and labels of the communication preferences section for SHIP")
	public void the_user_validates_headers_and_labels_of_the_communication_preferences_section_for_SHIP() {
		
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage)getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		
		communicationPreferencesPage.validateGoGreenSectionForShip();

	}
	
	
	/**
	 * @toDo : Validates the ship preferences update functionality
	 */

	@Then("^the user validates the update preferences functionality for ship")
	public void validate_update_preferences_functionality_for_ship() {
		
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage)getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		
		communicationPreferencesPage.validateUpdatePreferencesForShip();

	}
	

	
	@And("^I should see the combo tabs on Preferences page and user validates the elements on individual tabs$")
	public void iShouldSeeTheComboTabsOnPreferencesPageAndUserValidatesTheElementsOnIndividualTabs() {

		
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

		CommunicationPreferencePage communicationPrefPage = profilePreferencesPage
				.navigateToCommunicationPreferencePage();
		
		if (communicationPrefPage != null) {
			if (!communicationPrefPage.validateifEPMPIframeIsPresent()) {
				communicationPrefPage.validateGoGreenSectionForShip();
			} else {
				communicationPrefPage.switchToFrameOnPreferences();
				communicationPrefPage.changeAndVerifyOnlinePreference();
			}
			communicationPrefPage.switchTabForComboMember();
			if (!communicationPrefPage.validateifEPMPIframeIsPresent()) {
				communicationPrefPage.validateGoGreenSectionForShip();
			} else {
				communicationPrefPage.switchToFrameOnPreferences();
				communicationPrefPage.changeAndVerifyOnlinePreference();
			}

		}

	}
	
	/**
	 * @toDo : Validates the Note section on Go green page
	 */
	@Then("^the user validates the Note Section on Preferences Page")
	public void UserValidatesNoteSection() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage)getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		
		communicationPreferencesPage.validateNoteSection();

	}

}
