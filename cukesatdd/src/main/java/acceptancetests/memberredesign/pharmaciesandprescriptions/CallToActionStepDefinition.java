package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.util.CommonUtility;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.deeplinkPages.PaymentsDeeplinkLoginPage;
import pages.regression.login.HSIDLoginPage;
import pages.regression.login.HsidRegistrationPersonalCreateAccount;
import pages.regression.login.LoginPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsWebElements;
import pages.regression.testharness.TestHarness;

public class CallToActionStepDefinition {


	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}
	
	@Given("^login with following details logins in the uhc rx portal$")
	public void login_with_following_details_logins_in_the_uhc_rx_portal(DataTable memberAttribute) throws Throwable{
			List<DataTableRow> memberAttributesRow = memberAttribute
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			String category = memberAttributesMap.get("Member Type");
			Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
			List<String> desiredAttributes = new ArrayList<String>();
			for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
					.hasNext();) {
				{
					String key = iterator.next();
					desiredAttributes.add(memberAttributesMap.get(key));
				}
			}
			System.out.println("desiredAttributes.." + desiredAttributes);

			Map<String, String> loginCreds = loginScenario
					.getUMSMemberWithDesiredAttributes(desiredAttributes);
			String userName = null;
			String pwd = null;
			if (loginCreds == null) {
				// no match found
				System.out.println("Member Type data could not be setup !!!");
				Assert.fail("unable to find a " + desiredAttributes + " member");
			} else {
				userName = loginCreds.get("user");
				pwd = loginCreds.get("pwd");
				System.out.println("User is..." + userName);
				System.out.println("Password is..." + pwd);
				getLoginScenario()
						.saveBean(LoginCommonConstants.USERNAME, userName);
				getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
			}

			WebDriver wd = getLoginScenario().getWebDriver();
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			LoginPage loginPage = new LoginPage(wd);
			TestHarness testHarnessPage=null;
			try {
					testHarnessPage = (TestHarness) loginPage.loginWithLegacy(userName, pwd);
				}
			catch (UnhandledAlertException ae) {
				System.out.println("Exception: "+ae);
				Assert.assertTrue("***** Error in loading  Redesign Account Landing Page ***** Got Alert text : There was an error while processing login", false);
			}
			Assert.assertTrue("PROBLEM - Login not successful...",testHarnessPage != null);
			getLoginScenario().saveBean(PageConstantsMnR.TEST_HARNESS_PAGE,testHarnessPage);
	}
	
	@When("^user navigates to the pharmacies and prescriptions page from testharness page$")
	public void navigate_PnP_page() throws Throwable{
		PharmaciesAndPrescriptionsPage pnpPg = new PharmaciesAndPrescriptionsPage(null);
			if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
				TestHarness testHarness = (TestHarness) getLoginScenario()
						.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
				pnpPg = testHarness.navigateToPharAndPresFromTestHarnessPageNew();
				getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
			} else {
				AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
						.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
				pnpPg = accountHomePage.navigateToPharmaciesAndPrescriptions();
				if (pnpPg==null) //note: try secondary page before giving up
					pnpPg = accountHomePage.navigateToPharmaciesAndPrescriptionsFromSecondaryPg();
			}
			Assert.assertTrue("PROBLEM - unable to navigate to Pharmacies & Prescriptions page", 
					pnpPg != null);
		
	}
	

	@When("^a PnP notification is activated$")
	public void A_P_n_P_notification_is_activated() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotification();
		//getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^I must see that message at the top of the PnP page$")
	public void i_must_see_that_message_at_the_top_of_the_P_P_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationPosition();
		//getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}
	
	@When("^user navigate to any other page$")
	public void user_navigate_to_any_other_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickWhatsNewCallToAction();
		pnpPg.validateNavigationToWhatsNewPage();
		//getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
    @Then("^PnP notification will not be displayed on other pages$")
	public void P_P_notification_will_not_be_displayed_on_Other_pages() throws Throwable {
    	PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationNotDisplayedOnOtherPages();
		//getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}
     
    @When("^user navigates back to PnP page$")
	public void user_navigates_back_to_P_P_page() throws Throwable {
    	PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.navigateBackToPnPPage();
		//getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}
    
	@Then("^this message will only appear on the main PnP page$")
	public void this_message_will_only_appear_on_the_main_P_P_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotification();
		//getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);	    
	}

	@When("^I click the cross icon to close the notification$")
	public void i_click_the_cross_icon_to_close_the_notification() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.closePharmacies_PrescriptionNotification();
		//getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	    

	@Then("^it will remove the notification from the top of the PnP page$")
	public void it_will_remove_the_notification_from_the_top_of_the_P_P_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationNotDisplayedOnPnPPage();
		//getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^that removal will persist until member logs out$")
	public void that_removal_will_persist_until_member_logs_out() throws Throwable {
		// below is for when user navigate to call to action - whats new
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickWhatsNewCallToAction();
		pnpPg.validateNavigationToWhatsNewPage();
		pnpPg.navigateBackToPnPPage();
		pnpPg.validatePersistanceOfRemovalOfPharmacies_PrescriptionNotificationOnPnPPage();
		
	    
		//below is for user click on browser back button
		pnpPg.navigateBackToPnPPage();
		pnpPg.validatePersistanceOfRemovalOfPharmacies_PrescriptionNotificationOnPnPPage();
		
		
		//below is for user click on PNP tab
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		pnpPg = accountHomePage.navigateToPharmaciesAndPrescriptions();
		if (pnpPg==null) 
			pnpPg = accountHomePage.navigateToPharmaciesAndPrescriptionsFromSecondaryPg();
		pnpPg.validatePersistanceOfRemovalOfPharmacies_PrescriptionNotificationOnPnPPage();
			    
	}

	@Then("^user view Find and Price Call To Action$")
	public void user_view_Find_and_Price_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateFindAndPriceCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates an image for Find and Price Call To Action$")
	public void user_validates_an_image_for_Find_and_Price_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateImageFindAndPriceCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^user validates a title for Find and Price Call To Action$")
	public void user_validates_a_title_for_Find_and_Price_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateTitleFindAndPriceCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^user validates a description for Find and Price Call To Action$")
	public void user_validates_a_description_for_Find_and_Price_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDescriptionFindAndPriceCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}
	
	@Then("^user view Pharmacy Locator Call To Action$")
	public void user_view_Pharmacy_Locator_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacyLocatorCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates an image for Pharmacy Locator Call To Action$")
	public void user_validates_an_image_Pharmacy_Locator_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateImagePharmacyLocatorCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^user validates a title for Pharmacy Locator Call To Action$")
	public void user_validates_a_title_Pharmacy_Locator_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateTitlePharmacyLocatorCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^user validates a description for Pharmacy Locator Call To Action$")
	public void user_validates_a_description_Pharmacy_Locator_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDescriptionPharmacyLocatorCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}
	
	@Then("^user view Refill Home Delivery Call To Action$")
	public void user_view_Refill_Home_Delivery_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateRefillHomeDeliveryCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^user validates an image for Refill Home Delivery Call To Action$")
	public void user_validates_an_image_for_Refill_Home_Delivery_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateImageRefillHomeDeliveryCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates a title for Refill Home Delivery Call To Action$")
	public void user_validates_a_title_for_Refill_Home_Delivery_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateTitleRefillHomeDeliveryCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates a description for Refill Home Delivery Call To Action$")
	public void user_validates_a_description_for_Refill_Home_Delivery_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDescriptionRefillHomeDeliveryCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}
	
	@Then("^user view Whats New Call To Action$")
	public void user_view_Whats_New_call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateWhatsNewCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates an image for Whats New Call To Action$")
	public void user_validates_an_image_for_Whats_New_call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateImageWhatsNewCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates a title for Whats New Call To Action$")
	public void user_validates_a_title_for_Whats_New_call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateTitleWhatsNewCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates a description for Whats New Call To Action$")
	public void user_validates_a_description_for_Whats_New_call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDescriptionWhatsNewCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates the Find and Price text content displayed first within that section$")
	public void user_validates_the_Find_and_Price_text_content_displayed_first_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePositionOfCallToActionOnPnPPage(0,"Find");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates the Pharmacy Locator text content displayed second within that section$")
	public void user_validates_the_Pharmacy_Locator_text_content_displayed_second_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePositionOfCallToActionOnPnPPage(1,"Pharmacy");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates the Refill Home Delivery text content displayed third within that section$")
	public void user_validates_the_Refill_Home_Delivery_text_content_displayed_third_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePositionOfCallToActionOnPnPPage(2,"Manage");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	  
	    
	}

	@Then("^user validates the Whats New text content displayed fourth within that section$")
	public void user_validates_the_whats_New_text_content_displayed_fourth_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePositionOfCallToActionOnPnPPage(3,"Whats");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	        
	}
	
	@Then("^user validates the Whats New text content displayed third within that section$")
	public void user_validates_the_whats_New_text_content_displayed_third_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePositionOfCallToActionOnPnPPage(2,"Whats");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	        
	}

	@Then("^user validates the Refill Home Delivery text content DID NOT display third within that section$")
	public void user_validates_the_Refill_Home_Delivery_text_content_DID_NOT_display_third_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateWhatsNewCallToActionNOTDisplayedOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	      
	}

	@When("^I click on the Find and Price call to action$")
	public void i_click_on_the_Find_and_Price_call_to_action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnFindAndPriceCallToAction();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
		    
	}

	@Then("^I will be directed to the Drug Estimator Tool current state version$")
	public void i_will_be_directed_to_the_Drug_Estimator_Tool_current_state_version() throws Throwable {
	   //
		//code for validating DET page header
	    
	}

	@When("^user clicks on Find and Price Call To Action$")
	public void user_clicks_on_Find_and_Action_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnFindAndPriceCallToAction();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user navigates to Optum Rx Drug pricing Page using Single Sign On SSO on new tab$")
	public void user_navigates_to_Optum_Rx_Drug_pricing_Page_using_Single_Sign_On_SSO_on_new_tab() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNavigationToOptumRxDrugPricingPageOnNewTab();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);    
	}

	@When("^user clicks on Pharmacy Locator call to action displayed second within that section$")
	public void user_clicks_on_Pharmacy_Locator_call_to_action_displayed_second_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnPharmacyLocatorCallToAction();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@When("^user Navigates to Pharmacy Locator tool current state version$")
	public void user_Navigates_to_Pharmacy_Locator_tool_current_state_version() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNavigationToPharmacyLocatorToolPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@When("^I click on the Refill Home Delivery call to action$")
	public void i_click_on_the_Refill_Home_Delivery_call_to_action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnRefillHomeDeliveryCallToAction();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^I will SSO to OptumRx Medicine Cabinet on new tab$")
	public void i_will_SSO_to_OptumRx_Medicine_Cabinet() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNavigationToOptumRxMedicineCabinetOnNewTab();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^user validates pharmacies titles section content$")
	public void user_validates_pharmacies_titles_section_content() throws Throwable {
	   
	    
	}

	@When("^user clicks on Whats New call to action$")
	public void user_clicks_on_Whats_New_call_to_action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickWhatsNewCallToAction();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);	    
	}

	@Then("^user will be directed to the Whats New page$")
	public void user_navigates_to_the_Whats_New_Page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNavigationToWhatsNewPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^user validates the header on Whats New Page$")
	public void user_validates_the_header_on_Whats_New_Page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationNotDisplayedOnOtherPages();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}


}
