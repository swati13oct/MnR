/**
 * 
 */
package acceptancetests.deprecated.fixedtestcases;

import gherkin.formatter.model.DataTableRow;
import pages.deprecated.acquisition.bluelayer.AcquisitionHomePage;
import pages.deprecated.acquisition.bluelayer.EnquiryKitConfirmationPage;
import pages.deprecated.acquisition.bluelayer.PDPEnrollementGuidePage;
import pages.deprecated.acquisition.bluelayer.PDPRequestHelpAndInformationPage;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;

/**
 * @author pperugu
 * */
public class PDPEnquiryKitUhcStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	
	@Given("^the user is on the UHC acquisition Site home page$")
	public void the_user_is_on_uhc_acquisition_site_home_page()
	{

		WebDriver wd = getLoginScenario().getWebDriverNew();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	
	}
	
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
