package acceptancetests.acquisition.callChat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.commonpages.AcquisitionHomePage;

public class SAMIconsCommonStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	WebDriver wd;
	/**
	 * @Functionality:SAM Icons
	 */
	@Then("^user opens the page to validate$")
	public void the_user_opens_the_page_to_validate(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String pagename = memberAttributesMap.get("pagename");

		System.out.println(pagename);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPage(pagename);
	}

	@Then("^the user validates whether call icon is visible$")
	public void the_user_validates_whether_callicon_isvisible() throws InterruptedException {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSam();
		// aquisitionhomepage.validateCallSamContent();
		aquisitionhomepage.validateCallpopup();
		/*
		 * if(returnval==null){ Assert.fail("No TFN found"); }else{
		 * Assert.assertTrue(true); }
		 */
	}

	@Then("^the user validates whether chat icon is visible")
	public void the_user_validates_whether_chaticon_isvisible() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatSam();
		aquisitionhomepage.verifyChatpopup();
		// aquisitionhomepage.validateProActiveChatpopupconnect();
		aquisitionhomepage.validateChatpopupconnect();

	}

	@Then("^the user validates proactive chat popup")
	public void the_user_validates_proactive_chat_popup() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		aquisitionhomepage.validateProActiveChatpopupconnect();

	}

	@Then("^user validates whether chat Agent is not Available")
	public void the_user_validates_whether_chat_Agent_is_not_visible() throws Throwable {
		boolean flag = false;
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		flag = aquisitionhomepage.validateChatNonHours();

		Assert.assertTrue("Chat Icon is visible in Non-Chat Hours", flag);

	}

	@Then("^user opens the page to validate M&R Sites$")
	public void the_user_opens_the_page_to_validate_Sites(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String pagename = memberAttributesMap.get("pagename");

		System.out.println(pagename);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPage(pagename);
	}

	@And("^user clicks on Sign in link on home page on site$")
	public void click_signIn() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.signInheader();
	}

	@And("^user clicks on register link on home page site$")
	public void click_register() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.headerRegisterLink();
	}

	@Then("^user validates visitor profile on home page site$")
	public void the_user_validates_visitor_profile() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validatevisitorprofile();
	}


	@Then("^the user validates SAM icons on the page$")
	public void the_user_validates_SAM_icons_on_the_page(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		
		wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE,(new AcquisitionHomePage(wd)));

		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpecetdTFNNo = (String) getLoginScenario().getBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO);
		//aquisitionhomepage.validateChatSam();
		aquisitionhomepage.validateCallpopuponapage(TFNXpath, ExpecetdTFNNo);

	}
	
	@Then("^the user validates TFN Number on Right Rail$")
	public void validate_TFN_On_Right_Rail(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = (String) getLoginScenario().getBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO);
		wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE, (new AcquisitionHomePage(wd)));


		aquisitionhomepage.validateTFNNoonRightRail(TFNXpath, ExpectedTFNNo);
	
	}

	@Then("^the user validates TFN Number in Still have Questions section at bottom of page$")
	public void the_user_validates_TFN_Number_in_Still_have_Questions_section_at_bottom_of_page(
			DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpecetdTFNNo = (String) getLoginScenario().getBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO);
		aquisitionhomepage.validatefootercallussection(TFNXpath, ExpecetdTFNNo);

	}

	@Then("^the user validates SAM icons on Medsupp page$")
	public void the_user_validates_SAM_icons_on_medsupp_page(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE, (new AcquisitionHomePage(wd)));

		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpecetdTFNNo = (String) getLoginScenario().getBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO);
		aquisitionhomepage.validateChatSam();
		aquisitionhomepage.validateCallpopuponMedsupppage(TFNXpath, ExpecetdTFNNo);

	}
	
	@Then("^the user validates SAM icons on Medsupp page from External page$")
	public void the_user_validates_SAM_icons_on_medsupp_page_from_external_page(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpecetdTFNNo = memberAttributesMap.get("TFN No");
		//aquisitionhomepage.validateChatSam();
		aquisitionhomepage.validateCallpopuponMedsupppage(TFNXpath, ExpecetdTFNNo);

	}

	
	@Then("^the user validates SAM icons on privacy page$")
	public void the_user_validates_SAM_icons_on_privacy_Page(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE,(new AcquisitionHomePage(wd)));

		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpecetdTFNNo = memberAttributesMap.get("TFN No");
		aquisitionhomepage.validateChatSam();
		aquisitionhomepage.validateCallpopuponaprivacypage(TFNXpath, ExpecetdTFNNo);

	}

	@Then("^the user validates TFN Number in Still have Questions section at bottom of Medsupp page$")
	public void the_user_validates_TFN_Number_in_Still_have_Questions_section_at_bottom_of_Medsupp_page(
			DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpecetdTFNNo = (String) getLoginScenario().getBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO);
		aquisitionhomepage.validateMedsuppfootercallussection(TFNXpath, ExpecetdTFNNo);
	}

	@Then("^the user validates TFN Number on Right Rail for Medsupp page$")
	public void the_user_validates_TFN_Number_on_Right_Rail_for_Medsupp_page(DataTable givenAttributes)
			throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = (String) getLoginScenario().getBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE, (new AcquisitionHomePage(wd)));

		aquisitionhomepage.validateTFNNoonRightRailforMedsupp(TFNXpath, ExpectedTFNNo);

	}
	
	@Then("^the user validates TFN Number on Right Rail OLE page$")
	public void validate_TFN_On_Right_Rail_OLE_page(DataTable givenAttributes) throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = (String) getLoginScenario().getBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO);
		wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE, (new AcquisitionHomePage(wd)));


		aquisitionhomepage.validateTFNNoonRightRailOLE(TFNXpath, ExpectedTFNNo);
	
	}

}
