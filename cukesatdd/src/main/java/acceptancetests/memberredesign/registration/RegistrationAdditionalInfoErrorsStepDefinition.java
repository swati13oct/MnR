
	package acceptancetests.memberredesign.registration;

	import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import junit.framework.Assert;
import pages.dashboard_deprecated.acquisition.RegistrationInformationPage;

	/**
	 * @author 
	 *
	 */

	public class RegistrationAdditionalInfoErrorsStepDefinition {

		
		@Autowired
		MRScenario loginScenario;

		public MRScenario getLoginScenario() {
			return loginScenario;
		}

	@And("^member enter Medicare id in additional information$")
	public void enterMedicareID(DataTable givenAttributes) {
		// get test variables
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
			    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			// get member ID
			String medicare_id = memberAttributesMap.get("Medicare Id");

			RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
					getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);	
			registrationInformationPage.enterMedicareID(medicare_id);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	@Then("^member will get error message for incorrect Medicare id$")
	public void enterMemberID() {

	  	// navigate to registration page
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getIncorrectInfoError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getIncorrectInfoError().getText().contains("invalid"));
		
	}


	@Then("^member will get error message for incorrect Zip/First/Last name$")
	public void existingMemberErrorMessage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getIncorrectInfoError().isDisplayed();
		Assert.assertTrue(registrationInformationPage.getIncorrectInfoError().getText().contains("invalid"));
		
		}

	@Then("^member will get error message for all required field needed$")
	public void inactiveTerminatedErrorMessage() {
		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
		registrationInformationPage.getfieldCompletionError().isDisplayed(); 
		Assert.assertTrue(registrationInformationPage.getfieldCompletionError().getText().contains("Completion"));
		}
	 
	}

