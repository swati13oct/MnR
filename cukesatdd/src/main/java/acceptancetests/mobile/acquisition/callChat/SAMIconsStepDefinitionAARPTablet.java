package acceptancetests.mobile.acquisition.callChat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.ShopForPlanNavigationPage;
import pages.acquisition.tfn.CampaignTFNPage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.CampaignTFNPageMobile;
import pages.mobile.acquisition.commonpages.ShopForPlanNavigationPageMobile;

public class SAMIconsStepDefinitionAARPTablet {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	//AppiumDriver wd;

	@Given("^the user is on the AARP medicare site landing page on Tablet$")
	public void the_user_is_on_the_AARP_medicare_site_landing_page_on_Tablet() {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}
	
	@Then("^the user validates TFN Number on Right Rail Plan Details page$")
	public void validate_TFN_On_Right_Rail_plan_details_page(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = (String) getLoginScenario().getBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);


		aquisitionhomepage.validateTFNNoonRightRailForPlanDetailsPage(TFNXpath, ExpectedTFNNo);
	
	}
	
	@Then("^the user validates TFN Number on Right Rail OLE page$")
	public void validate_TFN_On_Right_Rail_OLE_page(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = (String) getLoginScenario().getBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);


		aquisitionhomepage.validateTFNNoonRightRailForOLE(TFNXpath, ExpectedTFNNo);
	
	}

	@Given("^user opens the page to validate on AARP Tablet$")
	public void user_opens_the_page_to_validate_on_AARP_Tablet(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String pagename = memberAttributesMap.get("pagename");
		System.out.println(pagename);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPage(pagename);
	}

	@Then("^the user validates whether call icon is visible on AARP Tablet$")
	public void the_user_validates_whether_call_icon_is_visible_on_AARP_Tablet() throws InterruptedException {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSamOnTablet();
		aquisitionhomepage.validateCallSamContentOnTablet();
		AcquisitionHomePageMobile returnval = aquisitionhomepage.validateCallpopupOnTablet();
		if (returnval == null) {
			Assertion.fail("No TFN found");
		} else {
			Assertion.assertTrue(true);
		}

	}

	@Then("^the user validates whether chat icon is visible on AARP Tablet$")
	public void the_user_validates_whether_chat_icon_is_visible_on_AARP_Tablet() throws InterruptedException {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatSamOnTablet();
		aquisitionhomepage.validateChatSamContentOnTablet();
		aquisitionhomepage.verifyChatpopupOnTablet();
	}
	
	@Then("^user opens the page to validate M&R Sites$")
	public void the_user_opens_the_page_to_validate_Sites(DataTable givenAttributes) throws InterruptedException {
		
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		/*List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}*/

		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String pagename = memberAttributesMap.get("pagename");
		
		System.out.println(pagename);
	
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPage(pagename);
	}
	
	@Then("^user validates whether chat Agent is not Available")
	public void the_user_validates_whether_chat_Agent_is_not_visible() throws Throwable {
	boolean flag= false;
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	flag=aquisitionhomepage.validateChatNonHours();

		Assertion.assertTrue("Chat Icon is visible in Non-Chat Hours",flag);
		
	}
	
	/*@And("^click on provider search link on shop pages$")
	public void click_on_provider_search_link_on_shop_pages() throws Throwable {
		ShopForPlanNavigationPageMobile shopaplan = (ShopForPlanNavigationPageMobile) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		shopaplan.providersearch();
	}*/
	
	@Then("^the user validates proactive chat popup")
	public void the_user_validates_proactive_chat_popup() throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	
		aquisitionhomepage.validateProActiveChatpopupconnect();
		
		
	}
	
	@Then("^user opens the page to validate$")
	public void the_user_opens_the_page_to_validate(DataTable givenAttributes) throws InterruptedException {
		
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		
		String pagename = memberAttributesMap.get("pagename");
		
		System.out.println(pagename);
	
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPage(pagename);
	}
	
	@Then("^the user validates SAM icons on the page$")
	public void the_user_validates_SAM_icons_on_the_page(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpecetdTFNNo = (String) getLoginScenario().getBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO);
		//aquisitionhomepage.validateChatSam();
		System.out.println("Chat ICON is not visible in mobile, so skipping this step");
		//aquisitionhomepage.validateCallpopuponapage(TFNXpath, ExpecetdTFNNo);

	}
	
	@Then("^the user validates TFN Number on Zipcode component$")
	public void the_user_validates_TFN_Number_on_Zipcode_component(DataTable givenAttributes)
			throws InterruptedException {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String TFNXpath = memberAttributesMap.get("TFN Xpath");
		String ExpectedTFNNo = (String) getLoginScenario().getBean(CommonConstants.CAMPAIGN_EXTERNAL_LINK_TFNNO);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		aquisitionhomepage.validateTFNNoonZipCodeComponent(TFNXpath, ExpectedTFNNo);
		CampaignTFNPageMobile tfnPage=new CampaignTFNPageMobile(wd);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE,tfnPage);
	}
}
