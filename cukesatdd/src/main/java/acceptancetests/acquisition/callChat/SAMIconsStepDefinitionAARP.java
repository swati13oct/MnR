package acceptancetests.acquisition.callChat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.AcquisitionHomePage;

/**
 *Functionality:Global Header Footer 
 */
public class SAMIconsStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Then("^user opens the page to validate on AARP$")
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


	@Then("^the user validates whether call icon is visible on AARP$")
	public void the_user_validates_whether_callicon_isvisible_on_UHC() throws InterruptedException {
		
	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSam();
		aquisitionhomepage.validateCallSamContent();
		aquisitionhomepage.validateCallpopup();
		/*
		 * if(returnval==null){ Assert.fail("No TFN found"); }else{
		 * Assert.assertTrue(true); }
		 */
	}
	
	
	@Then("^the user validates whether chat icon is visible on AARP")
	public void the_user_validates_whether_chaticon_isvisible_on_UHC() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatSam();
		aquisitionhomepage.verifyChatpopup();
		//aquisitionhomepage.validateChatpopupconnect();	
		
	}

	@Then("^the user validates whether chat Agent is Available on AARP")
	public void the_user_validates_whether_chat_Agent_is_visible_on_UHC() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatSam();
		aquisitionhomepage.verifyChatpopup();
		aquisitionhomepage.validateChatpopupconnect();	
		
	}

	@Then("^user validates whether chat Agent is not Available on AARP")
	public void the_user_validates_whether_chat_Agent_is_not_visible_on_UHC() throws Throwable {
	boolean flag= false;
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	flag=aquisitionhomepage.validateChat();

		Assert.assertTrue("Chat Icon is visible in Non-Chat Hours",flag);
		
	}

}
