package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.pharmaciesandprescriptions.CheckOutSummaryPage;
import pages.regression.pharmaciesandprescriptions.PaymentMethodPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.pharmaciesandprescriptions.ShippingAddressPage;
import pages.regression.testharness.TestHarness;

public class RefillChangePaymentMethodStepDefination {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public static String cardHolderName, cardNumber, billingAddress1, billingAddress2, city, state, monthExp, yearExp,
			zipCode, updateBillingAddress1, updateBillingAddress2;

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@When("^user select Add Payment$")
	public void user_select_Add_Payment() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		checkoutSumaryPg.clickOnAddPayment();
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will view Add Payment in a full page modal$")
	public void user_will_view_Add_Payment_in_a_full_page_modal() throws Throwable {
		PaymentMethodPage paymentMethodPg = new PaymentMethodPage(null);
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		paymentMethodPg = checkoutSumaryPg.navigateToAddPaymentMethodPage();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		Assert.assertTrue("PROBLEM - Add Payment Page not available", paymentMethodPg.validateAddPaymentPage());
	}

	@Then("^user will be able to type cardHolderName$")
	public void user_will_be_able_to_type_cardHolderName(DataTable arg1) throws Throwable {
		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		cardHolderName = list.get(0).get("cardHolderName");
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.enterTextInCardHolderName(cardHolderName);
		Assert.assertTrue("PROBLEM - Value entered in Card Holder Field not reflecting on Page",
				paymentMethodPg.validateCardHolderNameEnteredInNameField(cardHolderName));
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will be able to type cardNumber$")
	public void user_will_be_able_to_type_cardNumber(DataTable arg1) throws Throwable {
		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		cardNumber = list.get(0).get("cardNumber");
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.enterTextInCardNumber(cardNumber);
		Assert.assertTrue("PROBLEM - Value entered in Card Number Field not reflecting on Page",
				paymentMethodPg.validateCardNumberEnteredInCardNumberField(cardNumber));
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will be able to type monthExp$")
	public void user_will_be_able_to_type_monthExp() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.selectMonthExp();
	}

	@Then("^user will be able to type yearExp$")
	public void user_will_be_able_to_type_yearExp() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.selectYearExp();
	}

	@Then("^user will be able to type billingAddressOne$")
	public void user_will_be_able_to_type_billingAddressOne(DataTable arg1) throws Throwable {
		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		billingAddress1 = list.get(0).get("billingAddressOne");
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.enterTextInBillingAddressOne(billingAddress1);
		Assert.assertTrue("PROBLEM - Value entered in Billing Address 1 Field not reflecting on Page",
				paymentMethodPg.validateCardNumberEnteredInBillingAddressOne(billingAddress1));
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will be able to type billingAddressTwo$")
	public void user_will_be_able_to_type_billingAddressTwo(DataTable arg1) throws Throwable {
		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		billingAddress2 = list.get(0).get("billingAddressTwo");
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.enterTextInBillingAddressTwo(billingAddress2);
		Assert.assertTrue("PROBLEM - Value entered in Billing Address 2 Field not reflecting on Page",
				paymentMethodPg.validateCardNumberEnteredInBillingAddressTwo(billingAddress2));
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will be able to type city$")
	public void user_will_be_able_to_type_city(DataTable arg1) throws Throwable {
		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		city = list.get(0).get("city");
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.enterTextInCity(city);
		Assert.assertTrue("PROBLEM - Value entered in City Field not reflecting on Page",
				paymentMethodPg.validateCardNumberEnteredInCity(city));
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will be able to type state$")
	public void user_will_be_able_to_type_state(DataTable arg1) throws Throwable {
		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		state = list.get(0).get("state");
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.selectState(state);
	}

	@Then("^user will be able to type zipCode$")
	public void user_will_be_able_to_type_zipCode(DataTable arg1) throws Throwable {
		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		zipCode = list.get(0).get("zipCode");
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.enterTextInZipCode(zipCode);
		Assert.assertTrue("PROBLEM - Value entered in Zip Code Field not reflecting on Page",
				paymentMethodPg.validateCardNumberEnteredInZipCode(zipCode));
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@When("^user select the X in the corner of the Add Payment page$")
	public void user_select_the_X_in_the_corner_of_the_Add_Payment_page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.clickXIconAddPaymentPage();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will not see the card added to Payment section on checkout summary page$")
	public void user_will_not_see_the_card_added_to_Payment_section_on_checkout_summary_page() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
		Assert.assertTrue("PROBLEM - There is no payment on file field not reflecting on checkout summary Page",
				checkoutSumaryPg.validateNoPaymentCard());
	}

	@When("^user select Save Payment Method on Add Payment Page$")
	public void user_select_Save_Payment_Method_on_Add_Payment_Page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.clickSavePaymentMethod();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will view the Change Payment page$")
	public void user_will_view_the_Change_Payment_page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		Assert.assertTrue("PROBLEM - Change Payment Page not available", paymentMethodPg.validateChangePaymentPage());
	}

	@Then("^user will view a success message for new credit card added$")
	public void user_will_view_a_success_message_for_new_credit_card_added() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		Assert.assertTrue("PROBLEM - Success Message for new credit card add is not displayed on change payment page",
				paymentMethodPg.validateSuccessMsgForNewCreditCardAdded());
	}

	@Then("^user will see the first card added in the list of payment methods$")
	public void user_will_see_the_first_card_added_in_the_list_of_payment_methods() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		Assert.assertTrue("PROBLEM - First card not added after clicking on Save And Continue",
				paymentMethodPg.validateFirstCardAdded());
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@When("^user select the Cancel button of the Add Payment page$")
	public void user_select_the_Cancel_button_of_the_Add_Payment_page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.clickOnCancelCTA();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@When("^user navigate back to Checkout Summary page$")
	public void user_navigate_back_to_Checkout_Summary_page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.clickBackButtonOnChangePaymentPage();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will see the card added to Payment section on checkout summary page$")
	public void user_will_see_the_card_added_to_Payment_section_on_checkout_summary_page() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, checkoutSumaryPg);
		Assert.assertTrue("PROBLEM -Payment Section is displayed on Checkout Summary Page",
				checkoutSumaryPg.validatePaymentSection());
		Assert.assertTrue("PROBLEM -New card addedd is not displayed on Checkout Summary Page",
				checkoutSumaryPg.validatePaymentSection());
	}

	@Then("^user will see the card as Preffered card$")
	public void user_will_see_the_card_as_Preffered_card() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, checkoutSumaryPg);
		Assert.assertTrue("PROBLEM -New card addedd is not displayed on Checkout Summary Page",
				checkoutSumaryPg.validatePreferedPaymentLabel());
	}

	@When("^user select Change Payment$")
	public void user_select_Change_Payment() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
		checkoutSumaryPg.clickOnChangePayment();
	}

	@Then("^user will view Change Payment in a full page modal$")
	public void user_will_view_Change_Payment_in_a_full_page_modal() throws Throwable {
		PaymentMethodPage paymentMethodPg = new PaymentMethodPage(null);
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		paymentMethodPg = checkoutSumaryPg.navigateToChangePaymentMethodPage();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		Assert.assertTrue("PROBLEM - Change Payment Page not available", paymentMethodPg.validateChangePaymentPage());
	}

	@When("^user select Add Card on Change Payment Page$")
	public void user_select_Add_Card_on_Change_Payment_Page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		paymentMethodPg.clickAddCardButtonOnChangePaymentPage();
	}

	@Then("^user will not see the new card added in list on Change Payment page$")
	public void user_will_not_see_the_new_card_added_in_list_on_Change_Payment_page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		Assert.assertTrue("PROBLEM - new card not added to Change Payment Page",
				paymentMethodPg.validateFirstCardAdded());
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user have selected a card$")
	public void user_have_selected_a_card() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.selectCard();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@When("^user select the edit link$")
	public void user_select_the_edit_link() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.editCard();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will view Edit Payment in a full-page modal$")
	public void user_will_view_Edit_Payment_in_a_full_page_modal() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		Assert.assertTrue("PROBLEM - Not able to view Edit Payment Page", paymentMethodPg.validateEditPaymentPage());
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user view name field is not editable$")
	public void user_view_name_field_is_not_editable() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		Assert.assertTrue("PROBLEM - User able to Edit Name field on Edit Payment Page",
				paymentMethodPg.validateNameNotEditableEditPaymentPage());
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user view card number field is not editable$")
	public void user_view_card_number_field_is_not_editable() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		Assert.assertTrue("PROBLEM - User able to Edit Name field on Edit Payment Page",
				paymentMethodPg.validateCardNumberNotEditableEditPaymentPage());
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@When("^user select the X in the corner of the Edit Payment page$")
	public void user_select_the_X_in_the_corner_of_the_Edit_Payment_page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.closeEditPaymentPage();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@When("^user select the Cancel button of the Edit Payment page$")
	public void user_select_the_Cancel_button_of_the_Edit_Payment_page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.cancelEditPaymentPage();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@When("^user type in the expiration date field$")
	public void user_type_in_the_expiration_date_field() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.updateExpirationDate();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@When("^user type in the Billing Address fields$")
	public void user_type_in_the_Billing_Address_fields(DataTable arg1) throws Throwable {
		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		updateBillingAddress1 = list.get(0).get("billingAddressOne");
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.updateBillingAddressOne(updateBillingAddress1);
		Assert.assertTrue("PROBLEM - Value entered in Billing Address line 1 is not reflecting on Page",
				paymentMethodPg.validateUpdatedBillingAddressOneValue(updateBillingAddress1));
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@When("^user select the link to add an additional address line on Edit Payment Page$")
	public void user_select_the_link_to_add_an_additional_address_line_on_Edit_Payment_Page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		Assert.assertTrue("PROBLEM - User unable to view Add Additional Address line link",
				paymentMethodPg.validateAddAdditionalAddressLineLink());
		paymentMethodPg.clickAddAdditionalAddressLineLink();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will see a second address line box appear on the page on Edit Payment Page$")
	public void user_will_see_a_second_address_line_box_appear_on_the_page_on_Edit_Payment_Page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		Assert.assertTrue("PROBLEM - User unable to view Second Address line textbox",
				paymentMethodPg.validateSecondAddressTextBoxDisplayed());
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will be able to enter text into additional address line field on Edit Payment Page$")
	public void user_will_be_able_to_enter_text_into_additional_address_line_field_on_Edit_Payment_Page(DataTable arg1)
			throws Throwable {
		List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
		updateBillingAddress2 = list.get(0).get("billingAddressTwo");
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.updateBillingAddressTwo(updateBillingAddress2);
		Assert.assertTrue("PROBLEM - Value entered in Billing Address line 2 is not reflecting on Page",
				paymentMethodPg.validateUpdatedBillingAddressTwoValue(updateBillingAddress2));
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will not be able to view the add an additional address line link on Edit Payment Page$")
	public void user_will_not_be_able_to_view_the_add_an_additional_address_line_link_on_Edit_Payment_Page()
			throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		Assert.assertTrue("PROBLEM - User able to view Add Additional Address line link",
				paymentMethodPg.validateAddAdditionalAddressLineLinkNotDisplayed());
	}

	@When("^user select Save and continue on Edit Payment Page$")
	public void user_select_Save_and_continue_on_Edit_Payment_Page() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.clickSaveAndContinueOnEditPaymentPage();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will view a success message for credit card updated$")
	public void user_will_view_a_success_message_for_credit_card_updated() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		Assert.assertTrue("PROBLEM - Success Message for credit card updated is not displayed on change payment page",
				paymentMethodPg.validateSuccessMsgForCreditCardUpdated());
	}

	@Then("^user have selected another editable payment method that is not my preferred card$")
	public void user_have_selected_another_editable_payment_method_that_is_not_my_preferred_card() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		paymentMethodPg.selectAnotherCard();
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

	@Then("^user will see the Make this my preferred card checkbox appear$")
	public void user_will_see_the_Make_this_my_preferred_card_checkbox_appear() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		paymentMethodPg.selectAnotherCard();
		Assert.assertTrue("PROBLEM -  Make this my preffered card checkbox is not displayed",
				paymentMethodPg.validateMakePrefferedCheckboxDisplayed());
	}

	@When("^user do not select the Make this my preferred card checkbox$")
	public void user_do_not_select_the_Make_this_my_preferred_card_checkbox() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		paymentMethodPg.validateMakePrefferedCheckboxNotSelected();

	}

	@When("^user select the Use this Card button$")
	public void user_select_the_Use_this_Card_button() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		paymentMethodPg.clickUseThisCardButton();
	}

	@Then("^user will see my Payment method match the one user selected$")
	public void user_will_see_my_Payment_method_match_the_one_user_selected() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -  Make this my preffered card checkbox is not displayed",
				checkoutSumaryPg.validateCreditCardNumber());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will not see that payment method displayed as the preferred card$")
	public void user_will_not_see_that_payment_method_displayed_as_the_preferred_card() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -  Make this my preffered card checkbox is not displayed",
				checkoutSumaryPg.validateNotDisplayedAsPreffered());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user select the Make this my preferred card checkbox$")
	public void user_select_the_Make_this_my_preferred_card_checkbox() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		paymentMethodPg.clickMakeThisPrefferedCardButton();
	}

	@Then("^user will see that payment method displayed as the preferred card$")
	public void user_will_see_that_payment_method_displayed_as_the_preferred_card() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -  Make this my preffered card checkbox is not displayed",
				checkoutSumaryPg.validatePreferedPaymentLabel());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user select Delete this Card$")
	public void user_select_Delete_this_Card() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		paymentMethodPg.clickDeleteCardButton();
	}

	@When("^user select Cancel button Delete confirmation full page modal$")
	public void user_select_Cancel_button_Delete_confirmation_full_page_modal() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		paymentMethodPg.cancelDeleteCardModal();
	}

	@Then("^user will return to the Edit Payment in a full page modal$")
	public void user_will_return_to_the_Edit_Payment_in_a_full_page_modal() throws Throwable {

	}

	@When("^user select X button Delete confirmation full page modal$")
	public void user_select_X_button_Delete_confirmation_full_page_modal() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		paymentMethodPg.closeDeleteCardModal();
	}

	@When("^user select yes on Delete confirmation full page modal$")
	public void user_select_yes_on_Delete_confirmation_full_page_modal() throws Throwable {
		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		paymentMethodPg.confirmMsgDeletePayment();
	}

	@Then("^user will view a success message for credit card deleted$")
	public void user_will_view_a_success_message_for_credit_card_deleted() throws Throwable {

		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
		Assert.assertTrue("PROBLEM - Success Message for credit card Deleted is not displayed on change payment page",
				paymentMethodPg.validateSuccessMsgForCreditCardDeleted());
	}

	@Then("^user will not see the card that got deleted$")
	public void user_will_not_see_the_card_that_got_deleted() throws Throwable {

		PaymentMethodPage paymentMethodPg = (PaymentMethodPage) getLoginScenario()
				.getBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE);
		getLoginScenario().saveBean(PageConstants.CHANGE_PAYMENT_METHOD_PAGE, paymentMethodPg);
	}

}
