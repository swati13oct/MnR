package acceptancetests.memberredesign.Preferences;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import pages.regression.profileandpreferences.CommunicationPreferencePage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/** Functionality: Profile And Preferences page */
public class PreferencesStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Then("^the user validates headers on Preferences page")
	public void uservalidatesgogreenheader() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPrefPage.validateheader();
	}

	@Then("^the user validates the presence of Plan Name on Communication Preferences Page")
	public void UserValidatesPlanName() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		String planName = (String) getLoginScenario().getBean(CommonConstants.PLAN_NAME_ON_PROFILE_PAGE);
		communicationPrefPage.validatePlanName(planName);
	}

	@Then("^the user validate the presence of Plan Name on Communication Preferences Page for Ship$")
	public void UserValidatesPlanNameForShip() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		String planName = (String) getLoginScenario().getBean(CommonConstants.PLAN_NAME_ON_PROFILE_PAGE);
		communicationPrefPage.validatePlanNameForShip(planName);
	}

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

	@Then("^the user validates the I have read checkbox and check it")
	public void UserValidatesCheckbox() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPrefPage.validateCheckbox();
	}

	@Then("^the user validates the Save Preferences Button")
	public void UserValidatesSavePreferences() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPrefPage.validateSavePreferences();
	}

	@Then("^the user validates the presence of Back links on Preferences page$")
	public void UserValidatesBacktoPNPlink() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		ProfileandPreferencesPage profilePage = communicationPrefPage.validateBacktoPNPlink();
		Assert.assertTrue("PROBLEM - Back link to Profile page is not working", profilePage != null);
	}

	@Then("^the user validates the presence of Back links on ship Preferences page$")
	public void UserValidatesBacktoProfilePagelinkForShip() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		ProfileandPreferencesPage profilePage = communicationPrefPage.validateBacktoPNPlinkForShip();
		Assert.assertTrue("PROBLEM - Back link to Profile page is not working", profilePage != null);
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
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.validateEmailUpdateOnIframe();
	}

	@Then("^the user validates the headers and labels of the communication preferences section for SHIP")
	public void the_user_validates_headers_and_labels_of_the_communication_preferences_section_for_SHIP() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.validateGoGreenSectionForShip();
	}

	@Then("^the user validates the update preferences functionality for ship")
	public void validate_update_preferences_functionality_for_ship() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
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
				communicationPrefPage.validateBacktoPNPlink();
			} else {
				communicationPrefPage.switchToFrameOnPreferences();
				communicationPrefPage.changeAndVerifyOnlinePreference();
			}
			communicationPrefPage.validateBacktoPNPlink();
			communicationPrefPage.switchTabForComboMember();
			if (!communicationPrefPage.validateifEPMPIframeIsPresent()) {
				communicationPrefPage.validateGoGreenSectionForShip();
			} else {
				communicationPrefPage.switchToFrameOnPreferences();
				communicationPrefPage.changeAndVerifyOnlinePreference();
			}
		}
	}

	@Then("^the user validates the Note Section on Preferences Page")
	public void UserValidatesNoteSection() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.validateNoteSection();
	}

	@And("^the user click Terms and Conditions check box$")
	public void userClickCheckBox() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.clickCheckBoxShip();
	}

	@And("^the user click on the Save Preferences button")
	public void userClickSave() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.clickSaveBtnShip();
	}

	@And("^the user edit preference again")
	public void editPrefAgain() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.editPrefAgain();
	}

	@Then("^a popup is displayed and validate the popup select Yes and submit")
	public void validatePopup() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.validatePopUp();
	}

	@And("^the user validate the success message")
	public void validateSuccessMsg() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.validateSuccessText();
	}
}
