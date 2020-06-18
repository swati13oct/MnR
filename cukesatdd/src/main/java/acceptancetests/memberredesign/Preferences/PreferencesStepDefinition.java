package acceptancetests.memberredesign.Preferences;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.regression.profileandpreferences.CommunicationPreferencePage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;

/** Functionality: Profile And Preferences page */
public class PreferencesStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Then("^the user validates headers on Preferences page$")
	public void uservalidatesgogreenheader() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPrefPage.validateheader();
	}

	@Then("^the user validates the presence of Plan Name on Communication Preferences Page$")
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

	@Then("^the user validates the iframe on Communication Preferences Page$")
	public void uservalidatesgogreenpagerouting() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPrefPage.validategogreenbutton();
	}

	@Then("^the user validates that the iframe is not present for a ship member$")
	public void uservalidatesIframeForAShipMember() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPrefPage.validateIframeForAShipMember();
	}

	@Then("^the user validates the I have read checkbox and check it$")
	public void UserValidatesCheckbox() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPrefPage.validateCheckbox();
	}

	@Then("^the user validates the Save Preferences Button$")
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

	@Then("^the user changes the online preference and saves the change$")
	public void userChangesOnlinePref() {
		CommunicationPreferencePage communicationPrefPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		Assert.assertTrue("Communication preference online preference changed and verified",
				communicationPrefPage.changeAndVerifyOnlinePreference());
	}

	@Then("^the user validates the functionality of updating the email on the iframe$")
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

	@Then("^the user validates the update preferences functionality for ship$")
	public void validate_update_preferences_functionality_for_ship() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.validateUpdatePreferencesForShip();
	}

	@And("^I should see the combo tabs on Preferences page and user validates the elements on individual tabs$")
	public void iShouldSeeTheComboTabsOnPreferencesPageAndUserValidatesTheElementsOnIndividualTabs() {
		ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
		Assert.assertTrue("PROLEM - expect more than one plan for combo user, please check test data", profilePreferencesPage.getNumPlanTabComboPlans()>1);
		for (int x=0; x<profilePreferencesPage.getNumPlanTabComboPlans(); x++) {
			String planName=profilePreferencesPage.getComboTabPlanType(x);
			if (planName.toUpperCase().contains("SENIOR SUPPLEMENT PLAN")) {
				System.out.println("This tab is for SSUP plan, proceed to validate no preferences");
				profilePreferencesPage.validateNoCommunicationPreferences();
				return;
			}
			System.out.println("This tab is for plan='"+planName+"', proceed to validate preferences");
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
				if ((x+1) == profilePreferencesPage.getNumPlanTabComboPlans())
					System.out.println("This tab is the last tab, testing is done");
				else {
					System.out.println("Click next tab to get ready for next plan validation");
					communicationPrefPage.switchTabForComboMember(x+1);
				} 
			}
		}
	}

	@Then("^the user validates the Note Section on Preferences Page$")
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

	@And("^the user click on the Save Preferences button$")
	public void userClickSave() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.clickSaveBtnShip();
	}

	@And("^the user edit preference again$")
	public void editPrefAgain() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.editPrefAgain();
	}

	@Then("^a popup is displayed and validate the popup select Yes and submit$")
	public void validatePopup(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planName = memberAttributesMap.get("Plan Name");
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.validatePopUp(planName);
	}

	@And("^the user validate the success message$")
	public void validateSuccessMsg() {
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.validateSuccessText();
	}
	
	@Then("^I can validate the segment ID value in localStorage on preference page$")
	public void validates_segmentid(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planMemType = memberAttributesMap.get("Plan Type");
		String expectedSegmentId = memberAttributesMap.get("Segment ID");
		String[] tmp=planMemType.split("_");
		Assert.assertTrue("PROBLEM - planType formation is not as expected.  Exepct <planType>_<AARP/UHC>__GOGreen_Profilepref", tmp.length>1);
		String planType=tmp[0];
		String memberType=tmp[1];
		CommunicationPreferencePage communicationPreferencesPage = (CommunicationPreferencePage) getLoginScenario()
				.getBean(PageConstantsMnR.COMMUNICATION_PREFERENCE_PAGE);
		communicationPreferencesPage.validateSegmentId(planType, memberType, expectedSegmentId);
	}
	
	public static Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}	

}
