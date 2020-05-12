package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.deeplinkPages.PaymentsDeeplinkLoginPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsWebElements;

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

	@When("^a P&P notification is activated$")
	public void a_P_P_notification_is_activated() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotification();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^I must see that message at the top of the P&P page$")
	public void i_must_see_that_message_at_the_top_of_the_P_P_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationPosition();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}
	
	@When("^user navigate to any other page$")
	public void user_navigate_to_any_other_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNavigationToWhatsNewPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
    @Then("^P&P notification will not be displayed on other pages$")
	public void P_P_notification_will_not_be_displayed_on_Other_pages() throws Throwable {
    	PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationNotDisplayedOnOtherPages();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}
     
    @When("^user navigates back to P&P page$")
	public void user_navigates_back_to_P_P_page() throws Throwable {
    	PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.navigateBackToPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}
    
	@Then("^this message will only appear on the main P&P page$")
	public void this_message_will_only_appear_on_the_main_P_P_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotification();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);	    
	}

	@When("^I click the cross icon to close the notification$")
	public void i_click_the_cross_icon_to_close_the_notification(String arg1) throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.closePharmacies_PrescriptionNotification();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^it will remove the notification from the top of the P&P page$")
	public void it_will_remove_the_notification_from_the_top_of_the_P_P_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationNotDisplayedOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^that removal will persist until member logs out$")
	public void that_removal_will_persist_until_member_logs_out() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePersistanceOfRemovalOfPharmacies_PrescriptionNotificationOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
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
	
	@Then("^user view What's New Call To Action$")
	public void user_view_What_s_New_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateWhatsNewCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates an image for What's New Call To Action$")
	public void user_validates_an_image_for_What_s_New_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateImageWhatsNewCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates a title for What's New Call To Action$")
	public void user_validates_a_title_for_What_s_New_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateTitleWhatsNewCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates a description for What's New Call To Action$")
	public void user_validates_a_description_for_What_s_New_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDescriptionWhatsNewCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@When("^user validates header section content$")
	public void user_validates_header_section_content() throws Throwable {
	   
	    
	}

	@When("^user validates pharmacies text content$")
	public void user_validates_pharmacies_text_content() throws Throwable {
	   
	    
	}

	@When("^user validates pharmacies tiles section content$")
	public void user_validates_pharmacies_tiles_section_content() throws Throwable {
	   
	    
	}

	@Then("^user validates the Find and Price text content displayed first within that section$")
	public void user_validates_the_Find_and_Price_text_content_displayed_first_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePositionOfCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates the Pharmacy Locator text content displayed second within that section$")
	public void user_validates_the_Pharmacy_Locator_text_content_displayed_second_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePositionOfCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates the Refill Home Delivery text content displayed third within that section$")
	public void user_validates_the_Refill_Home_Delivery_text_content_displayed_third_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePositionOfCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates the What's New text content displayed fourth within that section$")
	public void user_validates_the_What_s_New_text_content_displayed_fourth_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePositionOfCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	    
	}

	@Then("^user validates the Refill Home Delivery text content DID NOT display third within that section$")
	public void user_validates_the_Refill_Home_Delivery_text_content_DID_NOT_display_third_within_that_section() throws Throwable {
	   
	    
	}

	@When("^I click on the Find and Price call to action$")
	public void i_click_on_the_Find_and_Price_call_to_action() throws Throwable {
	   
	    
	}

	@Then("^I will be directed to the Drug Estimator Tool \\(current state version\\)$")
	public void i_will_be_directed_to_the_Drug_Estimator_Tool_current_state_version() throws Throwable {
	   
	    
	}

	@When("^user clicks on Find and Price Call To Action$")
	public void user_clicks_on_Find_and_Action_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnFindAndPriceCallToAction();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user navigates to Optum Rx Drug pricing Page using Single Sign On\\(SSO\\) on new tab$")
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

	@When("^user Navigates to Pharmacy Locator tool \\(current state version\\)$")
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

	@When("^user clicks on What's New call to action$")
	public void user_clicks_on_What_s_New_call_to_action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickWhatsNewCallToAction();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);	    
	}

	@Then("^user will be directed to the What's New page$")
	public void user_navigates_to_the_What_s_New_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNavigationToWhatsNewPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}

	@Then("^user validates the header on What's New Page$")
	public void user_validates_the_header_on_What_s_New_Page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationNotDisplayedOnOtherPages();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	    
	}


}
