/**
 * 
 */
package acceptancetests.deprecated.sanity.ulayer;

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

import acceptancetests.deprecated.atdd.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.acquisition.PageConstants;
import acceptancetests.deprecated.pdpenquirykit.data.EnquiryKitCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.EnquiryKitConfirmationPage;
import pages.acquisition.ulayer.PDPEnrollementGuidePage;
import pages.acquisition.ulayer.PDPRequestHelpAndInformationPage;

/**
 * @author pperugu
 * */
public class PDPEnquiryKitAarpStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	
	@Given("^the user is on the AARP Medicare Site landing page$")
	public void the_user_on_aarp_medicare_site_landing_page()
	{

		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	
	}
	
	@When("^the user navigates to Request More Help and Information page under pdp section in AARP Site$")
	public void the_user_navigates_request_more_help_information_page_aarp()
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
	
	@And("^the user accesses the Request Plan Information and Enrollment Materials in AARP site$")
	public void the_user_accessess_the_pdp_enquiry_kit_aarp()
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
	
	@And("^the user submits by entering following details in Order Enrollment Information page in AARP Site$")
	public void the_user_submits_entering_details_order_enrollment_information_aarp(DataTable attributes){
		List<DataTableRow> personalAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells()
					.get(0), personalAttributesRow.get(i).getCells().get(1));
		}
		
		String firstName = personalAttributesMap.get("First name");
		String lastName = personalAttributesMap.get("Last name");
		
		PDPEnrollementGuidePage pdpEnrollementGuidePage = (PDPEnrollementGuidePage) getLoginScenario().getBean(PageConstants.PDP_ENROLLMENT_GUIDE_PAGE);
		pdpEnrollementGuidePage.entersDetails(personalAttributesMap);
		EnquiryKitConfirmationPage enquiryKitConfirmationPage = pdpEnrollementGuidePage.submitsRequest();
		if(enquiryKitConfirmationPage!=null){
			
			JSONObject enquiryKitConfirmationActualJson = enquiryKitConfirmationPage.enquiryKitConfirmationJson;
			getLoginScenario().saveBean(
					EnquiryKitCommonConstants.ENQUIRY_KIT_ACTUAL,
					enquiryKitConfirmationActualJson);
			
			/* Get expected data */
			String fileName = lastName+"_"+firstName;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + EnquiryKitCommonConstants.ENQUIRY_KIT
					+ File.separator ;
			JSONObject enquiryKitConfirmationExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					EnquiryKitCommonConstants.ENQUIRY_KIT_EXPECTED,
					enquiryKitConfirmationExpectedJson);	
		}
	}
	
	@Then("^the user validates the inquiry kit confirmation page in AARP site$")
	public void user_validates_enquiry_kit_confirmation_page_aarp()
	{
		JSONObject enquiryKitConfirmationExpectedJson = (JSONObject) getLoginScenario().getBean(
				EnquiryKitCommonConstants.ENQUIRY_KIT_EXPECTED);
		
		JSONObject enquiryKitConfirmationActualJson = (JSONObject) getLoginScenario().getBean(
				EnquiryKitCommonConstants.ENQUIRY_KIT_ACTUAL);
		
		
		try {
			JSONAssert.assertEquals(enquiryKitConfirmationExpectedJson,
					enquiryKitConfirmationActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
