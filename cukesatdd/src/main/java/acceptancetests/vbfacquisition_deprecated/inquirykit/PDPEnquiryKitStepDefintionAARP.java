package acceptancetests.vbfacquisition_deprecated.inquirykit;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.EnquiryKitConfirmationPage;
import pages.acquisition.ulayer.PDPEnrollementGuidePage;
import pages.acquisition.ulayer.PDPRequestHelpAndInformationPage;
import pages.acquisition.ulayer.RequestHelpAndInformationPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
/**
 *Functionality:PDP EnquiryKit
 */
public class PDPEnquiryKitStepDefintionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo:the user is on the AARP acquisition Site home 
	 */	
	@Given("^the user is on the AARP acquisition Site home page$")
	public void the_user_on_aarp_medicare_site_landing_page()
	{

		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	
	}
	
	/**
	 * @toDo:user navigates to Request More Help and Information page under pdp section 
	 */
	@When("^the user navigates to Request More Help and Information page under pdp section in AARP Site$")
	public void the_user_navigates_request_more_help_information_page_aarp()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RequestHelpAndInformationPage requestHelpAndInformationPage = aquisitionhomepage.navigateToMaMoreHelpAndInfo();
		if(requestHelpAndInformationPage!=null){
			getLoginScenario().saveBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE, requestHelpAndInformationPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("ERROR loading pdpRequestHelpAndInformationPage");
		}
	}
	
	/**
	 * @toDo:the user accesses the Request Plan Information and Enrollment Materials 
	 */
//	@And("^the user accesses the Request Plan Information and Enrollment Materials in AARP site$")
//	public void the_user_accessess_the_pdp_enquiry_kit_aarp()
//	{
//		RequestHelpAndInformationPage requestHelpAndInformationPage = (RequestHelpAndInformationPage) getLoginScenario().getBean(PageConstants.REQUEST_MORE_HELP_INFORMATION_PAGE);
//		
//		PDPEnrollementGuidePage pdpEnrollementGuidePage = requestHelpAndInformationPage.navigatesToPdpEnquiryKit();
//		if(pdpEnrollementGuidePage!=null){
//			getLoginScenario().saveBean(PageConstants.PDP_ENROLLMENT_GUIDE_PAGE, pdpEnrollementGuidePage);
//			Assert.assertTrue(true);
//		}
//		else{
//			Assert.fail("ERROR loading pdpEnrollementGuidePage");
//		}
//		
//	}
	
	/**
	 * @toDo:user submits by entering following details in Order Enrollment Information page 
	 */
	@And("^the user submits by entering following details in Order Enrollment Information page in AARP Site$")
	public void the_user_submits_entering_details_order_enrollment_information_aarp(DataTable attributes){
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
	

	
	