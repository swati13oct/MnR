package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.regression.pharmaciesandprescriptions.CheckOutSummaryPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.pharmaciesandprescriptions.ShippingAddressPage;

public class ChangeShippingAddressStepDef {

	@Autowired
	MRScenario loginScenario;

	public static List<Object> listOfMedicationDetail = new ArrayList<>();
	public static String MedicationName = "";
	public static String MedicatioNameToBeSearchedOnP_P;
	public static String addressOnCheckoutSummaryPage;
	public static String addressOnChangeShippingAddressPage;
	public static String userSelectedEditableAddressOnChangeShippingAddressPage;
	public String dummyData = "Test";
	public static String userSelectedNonPreferedAddressOnChangeShippingAddressPage;
	public static String addressLine1, addressLine2;
	public static int countOfAddress;
	public static int indexOfAddessAdded;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@When("^user select the Change Shipping Address link$")
	public void user_select_the_Change_Shipping_Address_link() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		// addressOnCheckoutSummaryPage = checkoutSumaryPg.getShippingAddress();
		checkoutSumaryPg.clickOnChangeShippingAddressCTA();
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will view the \"([^\"]*)\" page$")
	public void user_will_view_the__page(String expectedVal) throws Throwable {
		ShippingAddressPage shippingAddressPg = new ShippingAddressPage(null);
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		shippingAddressPg = checkoutSumaryPg.navigateToChangeShippingAddressPage();
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
		Assert.assertTrue("PROBLEM - " + expectedVal + " Page not available",
				shippingAddressPg.validateShippingPageHeader(expectedVal, 0));
	}

	@When("^user selects an address using the radio buttons$")
	public void user_selects_an_address_using_the_radio_buttons() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		addressOnChangeShippingAddressPage = shippingAddressPg.selectRadioBtnAndfetchSelectedAddress();
		System.out.println("Shipping Address selected on Shipping Page " + addressOnChangeShippingAddressPage);
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user select the Use this Address button$")
	public void user_select_the_Use_this_Address_button() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		shippingAddressPg.clickOnUseThisAddressCTA();
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will the Shipping Address match the one user selected$")
	public void user_will_the_Shipping_Address_match_the_one_user_selected() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		addressOnCheckoutSummaryPage = checkoutSumaryPg.getShippingAddress();
		System.out.println("Shipping Address on CheckOut page after changing" + addressOnCheckoutSummaryPage);

		Assert.assertTrue(
				"PROBLEM - Address selected on ChangeShipping Address Page not matching on CheckOut Summary Page",
				addressOnCheckoutSummaryPage.equals(addressOnChangeShippingAddressPage));
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user clicks on Edit link for editable address$")
	public void user_clicks_on_Edit_link_for_editable_address() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		userSelectedEditableAddressOnChangeShippingAddressPage = shippingAddressPg
				.clickOnEditLinkAndfetchtheAddressVal();
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will view \"([^\"]*)\" in a full page modal$")
	public void user_will_view_in_a_full_page_modal(String expectedVal) throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		Assert.assertTrue("PROBLEM - " + expectedVal + " Page not available",
				shippingAddressPg.validateShippingPageHeader(expectedVal, 1));
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user type in any of the address lines$")
	public void user_type_in_any_of_the_address_lines(DataTable dt) throws Throwable {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		addressLine1 = list.get(0).get("AddressLine1");
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		shippingAddressPg.enterTextInAddressLine1Field(addressLine1);
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will see the changes reflected on the page$")
	public void user_will_see_the_changes_reflected_on_the_page() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		Assert.assertTrue("PROBLEM - Value entered in AddressLine1 Field not reflecting on Page",
				shippingAddressPg.validateAddressEnteredInAddressLine1Field(addressLine1));
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user select the link to add an additional address line$")
	public void user_select_the_link_to_add_an_additional_address_line() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		shippingAddressPg.clickOnAddressLine2Link();
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will see a second address line box appear on the page$")
	public void user_will_see_a_second_address_line_box_appear_on_the_page() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		Assert.assertTrue("PROBLEM -  AddressLine2 Field not appearing on Page",
				shippingAddressPg.validateAddressLine2Field());
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will be able to enter text into it$")
	public void user_will_be_able_to_enter_text_into_it(DataTable dt) throws Throwable {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		addressLine2 = list.get(0).get("AddressLine2");
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		shippingAddressPg.enterTextInAddressLine2Field(addressLine2);
		Assert.assertTrue("PROBLEM - Value entered in AddressLine2 Field not reflecting on Page",
				shippingAddressPg.validateAddressEnteredInAddressLine2Field(addressLine2));
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user wont view the add an additional address line link$")
	public void user_wont_view_the_add_an_additional_address_line_link() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		Assert.assertTrue("PROBLEM - Additional Address Line link is appearing on page",
				shippingAddressPg.validateAddressLine2LinkNtAvailable());
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user select the X in the corner of the page$")
	public void user_select_the_X_in_the_corner_of_the_page() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		shippingAddressPg.clickOnXIcon();
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will return to the \"([^\"]*)\" page$")
	public void user_will_return_to_the_page(String expectedVal) throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		Assert.assertTrue("PROBLEM - " + expectedVal + " Page not available",
				shippingAddressPg.validateShippingPageHeader(expectedVal, 0));
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will see the address user was editing is unchanged$")
	public void user_will_see_the_address_user_was_editing_is_unchanged() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		Assert.assertTrue("PROBLEM - Address user was editing got changed",
				!userSelectedEditableAddressOnChangeShippingAddressPage.contains(addressLine2));
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user select the Cancel button$")
	public void user_select_the_Cancel_button() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		shippingAddressPg.clickOnCancelCTA();
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user select Save and continue$")
	public void user_select_Save_and_continue() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		shippingAddressPg.clickOnSaveAndContinueCTA();
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will see the address user was editing reflect the changes user made$")
	public void user_will_see_the_address_user_was_editing_reflect_the_changes_user_made() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		Assert.assertTrue("PROBLEM - Success message not appearing after clicking on Save And Continue",
				shippingAddressPg.validateSuccessMessageAfterSavingAndEditingAddress("edited"));
		Assert.assertTrue("PROBLEM - Address not edited after clicking on Save And Continue",
				shippingAddressPg.getAddressValBasedOnIndex(indexOfAddessAdded).contains(addressLine2.toUpperCase()));

		/*
		 * userSelectedEditableAddressOnChangeShippingAddressPage = shippingAddressPg
		 * .clickOnEditLinkAndfetchtheAddressVal();
		 * Assert.assertTrue("PROBLEM - Address user was editing got changed",
		 * !userSelectedEditableAddressOnChangeShippingAddressPage.contains(dummyData));
		 */
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user clicks on Add Address Btn$")
	public void user_clicks_on_Add_Address_Btn() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		countOfAddress = shippingAddressPg.countOfAddressOnChangeShippingPage();
		shippingAddressPg.clickOnAddAddressCTA();
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	/*
	 * @Then("^user will view Add Address in a full page modal$") public void
	 * user_will_view_Add_Address_in_a_full_page_modal() throws Throwable {
	 * ShippingAddressPage shippingAddressPg = (ShippingAddressPage)
	 * getLoginScenario() .getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
	 * Assert.assertTrue("PROBLEM - " + expectedVal + " Page not available",
	 * shippingAddressPg.validateShippingPageHeader(expectedVal, 0));
	 * getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE,
	 * shippingAddressPg); }
	 */

	@Then("^user will not see the address user was adding$")
	public void user_will_not_see_the_address_user_was_adding() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		Assert.assertTrue("PROBLEM - Address got added after user clicks on X or Cancel Button",
				shippingAddressPg.validateAddressNotAdded(countOfAddress));
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will see the address user added in the list of shipping addresses$")
	public void user_will_see_the_address_user_added_in_the_list_of_shipping_addresses() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		/*
		 * Assert.assertTrue("PROBLEM - Address user was editing got changed",
		 * !userSelectedEditableAddressOnChangeShippingAddressPage.contains(dummyData));
		 */
		Assert.assertTrue("PROBLEM - Success message not appearing after clicking on Save And Continue",
				shippingAddressPg.validateSuccessMessageAfterSavingAndEditingAddress("added"));
		Assert.assertFalse("PROBLEM - Address not added after clicking on Save And Continue",
				shippingAddressPg.validateAddressNotAdded(countOfAddress));
		indexOfAddessAdded = shippingAddressPg.getIndexValOfNewAddressAdded(addressLine1);
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user select an address that is not a preferred address$")
	public void user_select_an_address_that_is_not_a_preferred_address() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		userSelectedNonPreferedAddressOnChangeShippingAddressPage = shippingAddressPg
				.selectAnAddressWhichIsNotPreferedAndfetchAddressDetails();
		System.out
				.println("Address before making prefered " + userSelectedNonPreferedAddressOnChangeShippingAddressPage);
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will see the \"([^\"]*)\" checkbox appear$")
	public void user_will_see_the_checkbox_appear(String expectedVal) throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		Assert.assertTrue("Problem : " + expectedVal + " checkbox not appearing on page",
				shippingAddressPg.validateMakeMyPreferedAddressCheckBox(expectedVal));
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user select the preferred address checkbox$")
	public void user_select_the_preferred_address_checkbox() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		shippingAddressPg.clickOnMakePreferedCheckBox();
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will see that address displayed as the preferred address$")
	public void user_will_see_that_address_displayed_as_the_preferred_address() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		addressOnCheckoutSummaryPage = checkoutSumaryPg.getShippingAddress();
		Assert.assertTrue("Problem :  Prefered address not appearing on CheckOut page",
				addressOnCheckoutSummaryPage.equals(userSelectedNonPreferedAddressOnChangeShippingAddressPage)
						&& checkoutSumaryPg.validatePreferedShippingAddressLabel());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	/*
	 * @When("^user select the Refill All Medications CTA on MY Medications Page$")
	 * public void user_select_the_Refill_All_Medications_CTAon MY Medications Page
	 */

	@When("^user enters value in city field$")
	public void user_enters_value_in_city_field(DataTable dt) throws Throwable {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		String city = list.get(0).get("City");
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		shippingAddressPg.enterTextInCityField(city);
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user select value from state dropdown$")
	public void user_select_value_from_state_dropdown(DataTable dt) throws Throwable {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		String state = list.get(0).get("State");
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		shippingAddressPg.selectState(state);
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user enters value in zipcode field$")
	public void user_enters_value_in_zipcode_field(DataTable dt) throws Throwable {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		String zipCode = list.get(0).get("ZipCode");
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		shippingAddressPg.enterZipCodeInZipCodeField(zipCode);
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user clicks on Edit link for editable address after user added$")
	public void user_clicks_on_Edit_link_for_editable_address_after_user_added() throws Throwable {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);

		System.out.println("Index of AddressAdded " + indexOfAddessAdded);
		userSelectedEditableAddressOnChangeShippingAddressPage = shippingAddressPg
				.clickOnEditLinkBasedOnIndex(indexOfAddessAdded);
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user clicks on Delete this Address CTA$")
	public void user_clicks_on_Delete_this_Address_CTA() {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);

		// userSelectedEditableAddressOnChangeShippingAddressPage =
		shippingAddressPg.clickOnDeleteThisAddressCTA();
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@When("^user clicks on Yes CTA on Delete Confirmation Modal$")
	public void user_clicks_on_Yes_CTA_on_Delete_Confirm_Page() {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);

		// userSelectedEditableAddressOnChangeShippingAddressPage =
		shippingAddressPg.clickOnYesDeleteConfirmation();
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will see Delete Confirmation Modal$")
	public void user_will_see_Delete_Confirmation_Modal() {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);

		// userSelectedEditableAddressOnChangeShippingAddressPage =
		Assert.assertTrue("Problem : Delete Confirmation Model not appearing",
				shippingAddressPg.validateDeleteConfirmMessage());

		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will see address is deleted$")
	public void user_will_see_address_is_deleted() {
		ShippingAddressPage shippingAddressPg = (ShippingAddressPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE);
		Assert.assertTrue("PROBLEM - Success message not appearing after clicking on Delete this Address CTA",
				shippingAddressPg.validateSuccessMessageAfterSavingAndEditingAddress("deleted"));
		// userSelectedEditableAddressOnChangeShippingAddressPage =
		Assert.assertTrue("Problem : Address is not deleted",
				shippingAddressPg.validateDeletedAddressNotAppearing(addressLine1));
		getLoginScenario().saveBean(PageConstants.CHANGE_SHIPPING_ADDRESS_PAGE, shippingAddressPg);
	}

	@Then("^user will see success message that the address is deleted$")
	public void user_will_see_success_message_that_the_address_is_deleted() {


		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateMessageAddressDeleted();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

}
