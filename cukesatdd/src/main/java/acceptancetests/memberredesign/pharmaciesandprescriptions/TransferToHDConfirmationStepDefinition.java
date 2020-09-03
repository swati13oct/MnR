package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import atdd.framework.MRScenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

public class TransferToHDConfirmationStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@When("^user fetches medication information and clicks on Transfer to HD Medication call to action button$")
	public void user_fetches_medication_information_and_clicks_on_Transfer_to_HD_Medication_call_to_action_button() throws Throwable {
		
	}

	@Then("^user will click on Place Order btn on Checkout Transfer Page$")
	public void user_will_click_on_Place_Order_btn_on_Checkout_Transfer_Page() throws Throwable {
	    
	}

	@Then("^user will see Transfer order confirmation page$")
	public void user_will_see_Transfer_order_confirmation_page() throws Throwable {
	    
	}

	@Then("^the page should be refreshed so that the status of this transfer request is updated per this transfer transaction$")
	public void the_page_should_be_refreshed_so_that_the_status_of_this_transfer_request_is_updated_per_this_transfer_transaction() throws Throwable {
	   
	}
}