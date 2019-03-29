package acceptancetests.vbfacquisition_deprecated.inquirykit;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.EnquiryKitConfirmationPage;
import pages.acquisition.bluelayer.PDPEnrollementGuidePage;
import pages.acquisition.bluelayer.RequestHelpAndInformationPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

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
	 * @toDo:the user is on the UHC acquisition Site
	 */
	@Given("^the user is on the UHC acquisition Site home page$")
	public void the_user_is_on_uhc_acquisition_site_home_page()
	{

		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	
	}
	
/*	*//**
	 * @toDo:the user navigates to Request More Help and Information page 
	 *//*
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
	}*/
	
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
		EnquiryKitConfirmationPage enquiryKitConfirmationPage = pdpEnrollementGuidePage.submitsRequest();
		if(enquiryKitConfirmationPage!=null){
			if(enquiryKitConfirmationPage.validateConfPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating confirmation page");
		}
	}	
}