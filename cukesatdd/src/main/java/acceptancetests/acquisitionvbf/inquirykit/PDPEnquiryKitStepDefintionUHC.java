package acceptancetests.acquisitionvbf.inquirykit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisitionvbf.common.CommonStepDefinition;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.EnquiryKitConfirmationPage;
import pages.acquisition.bluelayer.PDPEnrollementGuidePage;
import pages.acquisition.bluelayer.PDPRequestHelpAndInformationPage;

/**
 *Functionality:PDP Enquiry Kit
 */
public class PDPEnquiryKitStepDefintionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	private Map<String, String> memberAttributesMap =null;
	
	private List<DataTableRow> memberAttributesRow = new CommonStepDefinition().getAttributesRow();

	
	/**
	 * @toDo:the user navigates to Request More Help and Information page 
	 */
	@When("^the user navigates to Request More Help and Information page under pdp section in UHC Site$")
	public void the_user_navigates_request_more_help_information_page_uhc()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PDPRequestHelpAndInformationPage pdpRequestHelpAndInformationPage = aquisitionhomepage.navigateToPDPMoreHelpAndInfo();
		if(pdpRequestHelpAndInformationPage!=null){
			getLoginScenario().saveBean(PageConstants.PDP_REQUEST_MORE_HELP_INFORMATION_PAGE, pdpRequestHelpAndInformationPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("ERROR loading pdpRequestHelpAndInformationPage");
		}
	}
	
	/**
	 * @toDo:the user accesses the Request Plan Information and Enrollment Materials 
	 */
	@And("^the user accesses the Request Plan Information and Enrollment Materials in UHC site$")
	public void the_user_accessess_the_pdp_enquiry_kit_uhc()
	{
		PDPRequestHelpAndInformationPage pdpRequestHelpAndInformationPage = (PDPRequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.PDP_REQUEST_MORE_HELP_INFORMATION_PAGE);
		
		PDPEnrollementGuidePage pdpEnrollementGuidePage = pdpRequestHelpAndInformationPage.navigatesToPdpEnquiryKit();
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
	public void the_user_submits_entering_details_order_enrollment_information_uhc(){
		 if(memberAttributesRow.size()>0){
		        for (int i = 0; i < memberAttributesRow.size(); i++) {
		               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),memberAttributesRow.get(i).getCells().get(1));
		        }
	        }
		PDPEnrollementGuidePage pdpEnrollementGuidePage = (PDPEnrollementGuidePage) getLoginScenario().getBean(PageConstants.PDP_ENROLLMENT_GUIDE_PAGE);
		pdpEnrollementGuidePage.entersDetails(memberAttributesMap);
		EnquiryKitConfirmationPage enquiryKitConfirmationPage = pdpEnrollementGuidePage.submitsRequest();
		if(enquiryKitConfirmationPage!=null){
			if(enquiryKitConfirmationPage.validateConfPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating confirmation page");
		}
	}	
}