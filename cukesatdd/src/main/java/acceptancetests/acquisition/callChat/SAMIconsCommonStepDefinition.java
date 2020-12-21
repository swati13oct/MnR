package acceptancetests.acquisition.callChat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

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
	
	/**
	 * @Functionality:SAM Icons
	 */
	@Then("^user opens the page to validate$")
	public void the_user_opens_the_page_to_validate(DataTable givenAttributes) throws InterruptedException {
		
		List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
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
		//aquisitionhomepage.validateCallSamContent();
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
		aquisitionhomepage.validateProActiveChatpopupconnect();
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
	boolean flag= false;
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	flag=aquisitionhomepage.validateChatNonHours();

		Assert.assertTrue("Chat Icon is visible in Non-Chat Hours",flag);
		
	}
	
			
	@Then("^user opens the page to validate M&R Sites$")
	public void the_user_opens_the_page_to_validate_Sites(DataTable givenAttributes) throws InterruptedException {
		
		List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
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
}
