package acceptancetests.acquisition.inquirykit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.EnquiryKitConfirmationPage;
import pages.acquisition.bluelayer.PDPEnrollementGuidePage;
import pages.acquisition.bluelayer.RequestHelpAndInformationPage;

/**
 *Functionality:PDP Enquiry Kit
 */
public class PDPEnquiryKitStepDefintionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	/**
	 * @toDo:the user accesses the Request Plan Information and Enrollment Materials 
	 */
	@And("^the user accesses the Request Plan Information and Enrollment Materials in UHC site$")
	public void the_user_accessess_the_pdp_enquiry_kit_uhc()
	{
		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
		
		PDPEnrollementGuidePage pdpEnrollementGuidePage = requestHelpAndInformationPage.navigatesToPdpEnquiryKit();
		if(pdpEnrollementGuidePage!=null){
			getLoginScenario().saveBean(PageConstants.PDP_ENROLLMENT_GUIDE_PAGE, pdpEnrollementGuidePage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("ERROR loading pdpEnrollementGuidePage");
		}
		
	}
	
	/**
	 * @toDo:the user submits by entering following details in Order Enrollment Information 
	 */
	@And("^the user submits by entering following details in Order Enrollment Information page in UHC Site$")
	public void the_user_submits_entering_details_order_enrollment_information_uhc(DataTable attributes){
		List<DataTableRow> personalAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells()
					.get(0), personalAttributesRow.get(i).getCells().get(1));
		}
		
		
		PDPEnrollementGuidePage pdpEnrollementGuidePage = (PDPEnrollementGuidePage) getLoginScenario().getBean(PageConstants.PDP_ENROLLMENT_GUIDE_PAGE);
		pdpEnrollementGuidePage.entersDetails(personalAttributesMap);
		if (!(MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))) {
		EnquiryKitConfirmationPage enquiryKitConfirmationPage = pdpEnrollementGuidePage.submitsRequest();
		if(enquiryKitConfirmationPage!=null){
				Assert.assertTrue(true);
		}else
			Assert.fail("Not able to submit the form. Confirmation page is null.");
		}
		else {
			System.out.println("Skipping the submit functionality in Offline-Prod/Prod environment");
		}
	}		
	
	/**
	 * @author sdwaraka
	 * To Validate HICN/MBI formats for Medicare ID field in UHC PDP Inquiry Kit flow
	 * @param arg1
	 * @throws Throwable
	 */
	@Then("^the user validates the correct formatting for Medicare ID field in UHC Acq site$")
	public void the_user_validates_the_correct_formatting_for_Medicare_ID_field(DataTable arg1) throws Throwable {
		List<DataTableRow> personalAttributesRow = arg1
				.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells()
					.get(0), personalAttributesRow.get(i).getCells().get(1));
		}
		
		String ValidFormatFlag = personalAttributesMap.get("Valid Format");
		
		PDPEnrollementGuidePage pdpEnrollementGuidePage = (PDPEnrollementGuidePage) getLoginScenario()
				.getBean(PageConstants.PDP_ENROLLMENT_GUIDE_PAGE);
		boolean MedicareValidFlag= ValidFormatFlag.contains("true")?true:false;
		boolean Flag = pdpEnrollementGuidePage
				.ValidateMedicareIDformat(MedicareValidFlag);
		System.out.println("Medicare ID validated - "+Flag);
		
		getLoginScenario().saveBean(
				PageConstants.PDP_ENROLLMENT_GUIDE_PAGE,
				pdpEnrollementGuidePage);
		if (Flag) {
			System.out.println("Medicare ID validation Passed");
				Assert.assertTrue(true);
		} 
		else{
			Assert.fail("ERROR Validating Medicare ID field");
		}
	}
	
	/**
	 * @toDo:user submits by entering following details in Order Enrollment Information page 
	 */
	@And("^user validates error messages when blank form is selected on UHC site$")
	public void the_user_submits_entering_details_order_enrollment_information_uhc(){
		
		PDPEnrollementGuidePage pdpEnrollementGuidePage = (PDPEnrollementGuidePage) getLoginScenario().getBean(PageConstants.PDP_ENROLLMENT_GUIDE_PAGE);
		pdpEnrollementGuidePage.submitForm();
		boolean errorMessagesValidated = pdpEnrollementGuidePage.validateErrorMessages();
		if(errorMessagesValidated){
				Assert.assertTrue(true);
		}else
			Assert.fail("Issue in validating error messages");
	
	}	
	
	/**
	 * @toDo:user submits the form by entering invalid values in Order Enrollment Information page 
	 */
	@And("^user enters the invalid values in blank form on UHC site$")
	public void the_user_submits_entering_invalid_values_order_enrollment_information_aarp(){
		
		PDPEnrollementGuidePage pdpEnrollementGuidePage = (PDPEnrollementGuidePage) getLoginScenario().getBean(PageConstants.PDP_ENROLLMENT_GUIDE_PAGE);
		pdpEnrollementGuidePage.invalidvaluesEntered();
				
		
	} 
	/**
	 * @toDo:user validates the error messages for the invalid values in Order Enrollment Information page 
	 */
	@And("^user validates error message for invalid values on UHC site$")
	public void user_validates_invalid_values_error_message_aarp(){
		PDPEnrollementGuidePage pdpEnrollementGuidePage = (PDPEnrollementGuidePage) getLoginScenario().getBean(PageConstants.PDP_ENROLLMENT_GUIDE_PAGE);
		pdpEnrollementGuidePage.submitForm();
		boolean errorMessagesValidated = pdpEnrollementGuidePage.validateErrorMessages1();
		if(errorMessagesValidated){
				Assert.assertTrue(true);
		}else
			Assert.fail("Issue in validating invalid values error messages");

	}
}