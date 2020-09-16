package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import atdd.framework.MRScenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChangeShippingAddressStepDef {

	@Autowired
	MRScenario loginScenario;

	public static List<Object> listOfMedicationDetail = new ArrayList<>();
	public static String MedicationName = "";
	public static String MedicatioNameToBeSearchedOnP_P;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@When("^user select the Change Shipping Address link$")
	public void user_select_the_Change_Shipping_Address_link() throws Throwable {

	}

	@Then("^user will view the \"([^\"]*)\" page$")
	public void user_will_view_the__page(String expectedVal) throws Throwable {

	}

	@When("^user selects an address using the radio buttons$")
	public void user_selects_an_address_using_the_radio_buttons() throws Throwable {

	}

	@When("^user select the Use this Address button$")
	public void user_select_the_Use_this_Address_button() throws Throwable {

	}

	@Then("^user will the Shipping Address match the one user selected$")
	public void user_will_the_Shipping_Address_match_the_one_user_selected() throws Throwable {

	}

	@When("^user clicks on Edit link for editable address$")
	public void user_clicks_on_Edit_link_for_editable_address() throws Throwable {

	}

	@Then("^user will view \"([^\"]*)\" in a full page modal$")
	public void user_will_view_in_a_full_page_modal(String expectedVal) throws Throwable {

	}

	@When("^user type in any of the address lines$")
	public void user_type_in_any_of_the_address_lines() throws Throwable {

	}

	@Then("^user will see the changes reflected on the page$")
	public void user_will_see_the_changes_reflected_on_the_page() throws Throwable {

	}

	@When("^user select the link to add an additional address line$")
	public void user_select_the_link_to_add_an_additional_address_line() throws Throwable {

	}

	@Then("^user will see a second address line box appear on the page$")
	public void user_will_see_a_second_address_line_box_appear_on_the_page() throws Throwable {

	}

	@Then("^user will be able to enter text into it$")
	public void user_will_be_able_to_enter_text_into_it() throws Throwable {

	}

	@Then("^user wont view the add an additional address line link$")
	public void user_wont_view_the_add_an_additional_address_line_link() throws Throwable {

	}

	@When("^user select the X in the corner of the page$")
	public void user_select_the_X_in_the_corner_of_the_page() throws Throwable {

	}

	@Then("^user will return to the \"([^\"]*)\" page$")
	public void user_will_return_to_the_page(String expectedVal) throws Throwable {

	}

	@Then("^user will see the address user was editing is unchanged$")
	public void user_will_see_the_address_user_was_editing_is_unchanged() throws Throwable {

	}

	@When("^user select the Cancel button$")
	public void user_select_the_Cancel_button() throws Throwable {

	}

	@When("^user select Save and continue$")
	public void user_select_Save_and_continue() throws Throwable {

	}

	@Then("^user will see the address user was editing reflect the changes user made$")
	public void user_will_see_the_address_user_was_editing_reflect_the_changes_user_made() throws Throwable {

	}

	@When("^user clicks on Add Address Btn$")
	public void user_clicks_on_Add_Address_Btn() throws Throwable {

	}

	@Then("^user will view Add Address in a full page modal$")
	public void user_will_view_Add_Address_in_a_full_page_modal() throws Throwable {

	}

	@Then("^user will not see the address user was adding$")
	public void user_will_not_see_the_address_user_was_adding() throws Throwable {

	}

	@Then("^user will see the address user added in the list of shipping addresses$")
	public void user_will_see_the_address_user_added_in_the_list_of_shipping_addresses() throws Throwable {

	}

}
