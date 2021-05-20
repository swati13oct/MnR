package acceptancetests.mobile.acquisition.callChat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;

public class SAMIconsStepDefinitionUHCTablet {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	//AppiumDriver wd;
	
	@Given("^the user is on the UHC medicare site landing page on Tablet$")
	public void the_user_is_on_the_UHC_medicare_site_landing_page_on_Tablet() throws Throwable {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@Given("^user opens the page to validate on UHC Tablet$")
	public void user_opens_the_page_to_validate_on_UHC_Tablet(DataTable givenAttributes) {
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

	@Then("^the user validates whether call icon is visible on UHC Tablet$")
	public void the_user_validates_whether_call_icon_is_visible_on_UHC_Tablet() throws InterruptedException {
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

	@Then("^the user validates whether chat icon is visible on UHC Tablet$")
	public void the_user_validates_whether_chat_icon_is_visible_on_UHC_Tablet() throws InterruptedException {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatSamOnTablet();
		aquisitionhomepage.validateChatSamContentOnTablet();
		aquisitionhomepage.verifyChatpopupOnTablet();
	}

}
