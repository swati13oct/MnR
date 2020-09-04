package acceptancetests.memberredesign.pharmaciesandprescriptions;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import pages.regression.pharmaciesandprescriptions.CheckOutSummaryPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RefillCheckoutSummaryStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public static List<Object> listOfMedicationDetail = new ArrayList<>();
	public static String MedicationName = "";
	public static String MedicatioNameToBeSearchedOnP_P;

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

	@Then("^user views the Medications section$")
	public void user_views_the_Medications_section() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = new CheckOutSummaryPage(null);
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		checkoutSumaryPg = pnpPg.navigateToCheckOutSummaryPage();
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
		Assert.assertTrue("PROBLEM - Medications Section not available", checkoutSumaryPg.validateMedicationSection());
	}

	@And("^User will see the number of medications in my order indicated in the header$")
	public void User_will_see_the_number_of_medications_in_my_order_indicated_in_the_header() throws Throwable {

	}

	@And("^user views the Rx number$")
	public void user_views_the_Rx_number() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateMedicationName();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@And("^user views the provider$")
	public void user_views_the_provider() throws Throwable {

	}

	@And("^user views the remaining refills$")
	public void user_views_the_remaining_refills() throws Throwable {

	}

	@When("^user clicks Refill All Medications button$")
	public void user_clicks_Refill_All_Medications_button() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnViewAllMedicationsLink();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@Then("^user sees the different shipments indicated$")
	public void user_sees_the_different_shipments_indicated() throws Throwable {

	}

	@And("^user sees the estimated delivery date for each shipment$")
	public void user_sees_the_estimated_delivery_date_for_each_shipment() throws Throwable {

	}

	@Then("^user sees the auto refill line populate for any eligible medication$")
	public void user_sees_the_auto_refill_line_populate_for_any_eligible_medication() throws Throwable {

	}

	@And("^user sees an information icon$")
	public void user_sees_an_information_icon() throws Throwable {

	}

	// ********************************************

	@Then("^user will see \"([^\"]*)\" Page$")
	public void user_will_see_Complete_Your_Refill_Page(String expectedPage) throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = new CheckOutSummaryPage(null);
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		checkoutSumaryPg = pnpPg.navigateToCheckOutSummaryPage();
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
		Assert.assertTrue("PROBLEM - " + expectedPage + " Page not available",
				checkoutSumaryPg.validateCheckoutPageHeader(expectedPage));
	}

	@Then("^user will see the number of medications in my order indicated in the header$")
	public void user_will_see_the_number_of_medications_in_my_order_indicated_in_the_header() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Number of Medication not available in the header",
				checkoutSumaryPg.validatePrescriptionNumberUnderMedicationSectn());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user sees a Remove Item From Order CTA$")
	public void user_sees_a_Remove_Item_From_Order_CTA() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Remove Item From Order CTA not available",
				checkoutSumaryPg.validateRemoveItemFromOrderCTA());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user views the \"([^\"]*)\" page$")
	public void user_views_the_Complete_Your_Refill_page(String expectedPage) throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = new CheckOutSummaryPage(null);
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		checkoutSumaryPg = pnpPg.navigateToCheckOutSummaryPage();
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
		Assert.assertTrue("PROBLEM - " + expectedPage + " Page not available",
				checkoutSumaryPg.validateCheckoutPageHeader(expectedPage));
	}

	@When("^user view the Order summary section$")
	public void user_view_the_Order_summary_section() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Order Summary Section not available",
				checkoutSumaryPg.validateOrderSummarySection());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see the line item Medications$")
	public void user_will_see_the_line_item_Medications() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Line Item Medication under Order Summary not available",
				checkoutSumaryPg.validateMedicationLineUnderOrderSummary());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see the number of prescriptions included in the order$")
	public void user_will_see_the_number_of_prescriptions_included_in_the_order() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Number of Prescription not included in the order",
				checkoutSumaryPg.validatePrescriptionNumberUnderOrderSummary());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see the total price of all medications in the order$")
	public void user_will_see_the_total_price_of_all_medications_in_the_order() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Prescription value under Order Summary not available",
				checkoutSumaryPg.validateOverAllMedicationAmtUnderOrderSummary());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see the line item Shipping$")
	public void user_will_see_the_line_item_Shipping() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Shipping Line Item under Order Summary not available",
				checkoutSumaryPg.validateShippingLabelUnderOrderSummary());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see the price of the shipping$")
	public void user_will_see_the_price_of_the_shipping() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -Shipping Price under Order Summary  not available",
				checkoutSumaryPg.validateShippingFeeUnderOrderSummary());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see the price total$")
	public void user_will_see_the_price_total() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Total Label under Order Summary not available",
				checkoutSumaryPg.validateTotalLabelUnderOrderSummary());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);

	}

	@Then("^the total will include medication and shipping cost$")
	public void the_total_will_include_medication_and_shipping_cost() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Total Cost Value not available",
				checkoutSumaryPg.validateTotalPriceUnderOrderSummary());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see a disclaimer related to estimated order total$")
	public void user_will_see_a_disclaimer_related_to_estimated_order_total() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Disclaimer under Order Summary not available",
				checkoutSumaryPg.validateDisclaimerUnderOrderSummary());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see a message about shipping address$")
	public void user_will_see_a_message_about_shipping_address() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Confirmation Message not available",
				checkoutSumaryPg.validateConfirmationMsgUnderOrderSummary());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);

	}

	@Then("^user will see shipping address$")
	public void user_will_see_shipping_address() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Confirm Shipping Address not available",
				checkoutSumaryPg.validateConfirmationAddrssUnderOrderSummary());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);

	}

	@When("^user view the Payment section$")
	public void user_view_the_Payment_section() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Payment Section not available", checkoutSumaryPg.validatePaymentSection());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);

	}

	@Then("^user will see Preferred payment method$")
	public void user_will_see_Preferred_payment_method() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Preferred Payment Method not available",
				checkoutSumaryPg.validatePreferredPaymentMethod());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);

	}

	@Then("^user will see the card type$")
	public void user_will_see_the_card_type() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Card Type not available", checkoutSumaryPg.validatePaymentCardType());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see the last four digits of the card number$")
	public void user_will_see_the_last_four_digits_of_the_card_number() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Card Number not available", checkoutSumaryPg.validateCreditCardNumber());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will view the card expiration date$")
	public void user_will_view_the_card_expiration_date() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Card Expiration Date not available", checkoutSumaryPg.validateCardExpiryDate());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will view the marker Preferred Credit Card$")
	public void user_will_view_the_marker_Preferred_Credit_Card() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Preferred Credit Card Marker not available",
				checkoutSumaryPg.validatePreferedPaymentLabel());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see a Change Payment CTA$")
	public void user_will_see_a_Change_Payment_CTA() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Change Payment not available", checkoutSumaryPg.validateChangePaymentBtn());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user view the Shipping Address section$")
	public void user_view_the_Shipping_Address_section() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Shipping Address Section not available",
				checkoutSumaryPg.validateShippingAddressSection());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see Preferred shipping address$")
	public void user_will_see__Preferred_shipping_address() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Preferred Shipping Address not available",
				checkoutSumaryPg.validateShippingAddressContent());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will view the Preferred Address label$")
	public void user_will_view_the_Preferred_Address_label() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Preferred Address label not available",
				checkoutSumaryPg.validatePreferedShippingAddressLabel());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will view the Change Shipping address CTA$")
	public void user_will_view_the_Change_Shipping_address_CTA() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Change Shipping Address CTA not available",
				checkoutSumaryPg.validateChangeShippingAddressBtn());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see Place Order Btn$")
	public void user_will_see_Place_Order_Btn() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Place Order Button not available",
				checkoutSumaryPg.validatePlaceOrderBtnUnderOrderSummary());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user will view the section above Place Order Btn$")
	public void user_will_view_the_section_above_Place_Order_Btn() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Confirmation Section not available",
				checkoutSumaryPg.validateConfirmationSection());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user validates the medication name and strength$")
	public void user_validates_the_medication_name_and_strength() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Medication Name and Strength not available",
				checkoutSumaryPg.validateMedicationNameAndStrength());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user validates the price$")
	public void user_validates_the_price() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Medication price not available", checkoutSumaryPg.validateMedicationPrice());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user validates the day supply$")
	public void user_validates_the_day_supply() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -Day Supply not available", checkoutSumaryPg.validateDaySupply());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user validates the Rx number$")
	public void user_validates_the_Rx_number() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Rx Number not available", checkoutSumaryPg.validateRxNumber());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user validates the provider$")
	public void user_validates_the_provider() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Provider Name not available", checkoutSumaryPg.validateProviderName());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user validates the remaining refills$")
	public void user_validates_the_remaining_refills() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Remaining Refills not available", checkoutSumaryPg.validateRefillsRemaining());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user fetches medication information and clicks on Refill Medication call to action button$")
	public void user_clicks_Refill_Medication_call_to_action_button() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.waitTillMedCabLoads();
		pnpPg.clickOnViewAllMedicationsLink();
		List<Integer> indexOfRefillMedication = pnpPg.getListOfIndexForRefillMedicationOnMyMed();
		int countOfPage = Integer.parseInt(pnpPg.getCountOfMyMedPage());
		for (int i = 0; i < countOfPage; i++) {
			if (indexOfRefillMedication.size() == 0 && i != countOfPage - 1) {
				pnpPg.clickOnNextPageArrow();
				indexOfRefillMedication = pnpPg.getListOfIndexForRefillMedicationOnMyMed();
			}
		}
		/*
		 * while (indexOfRefillMedication.size() == 0) { pnpPg.clickOnNextPageArrow();
		 * indexOfRefillMedication = pnpPg.getListOfIndexForRefillMedicationOnMyMed(); }
		 */
		listOfMedicationDetail = pnpPg.fetchesMedicationInformationFrRefill();
		int medicationToBeClicked = (int) listOfMedicationDetail.get(listOfMedicationDetail.size() - 1);
		pnpPg.clickOnRefillMedicationCTABasedOnIndex(medicationToBeClicked);

		/*
		 * pnpPg.waitTillMedCabLoads(); listOfMedicationDetail =
		 * pnpPg.fetchesMedicationInformationFrRefill(); int medicationToBeClicked =
		 * (int) listOfMedicationDetail.get(listOfMedicationDetail.size() - 1);
		 * pnpPg.clickOnRefillMedicationCTABasedOnIndex(medicationToBeClicked);
		 */
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will be brought to the \"([^\"]*)\" page for that medication$")
	public void user_will_be_brought_to_the_Complete_page_for_that_medication(String expectedPage) throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = new CheckOutSummaryPage(null);
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		checkoutSumaryPg = pnpPg.navigateToCheckOutSummaryPage();
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
		Assert.assertTrue("PROBLEM - " + expectedPage + " Page not available",
				checkoutSumaryPg.validateCheckoutPageHeader(expectedPage));
	}

	@When("^user clicks Refill All Medication call to action button$")
	public void user_clicks_Refill_All_Medication_call_to_action_button() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		checkoutSumaryPg.clickOnRefillALLMedicationCTA();
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user medications are grouped into more than one shipment$")
	public void user_medications_are_grouped_into_more_than_one_shipment() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -Medications are not grouped into more than one shipment",
				checkoutSumaryPg.validateShippingContainer());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see the different shipments indicated$")
	public void user_will_see_the_different_shipments_indicated() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -Different Shipments indicated are not available",
				checkoutSumaryPg.validateShipmentIndicated());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see the estimated delivery date for each shipment$")
	public void user_will_see_the_estimated_delivery_date_for_each_shipment() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -Estimated Delivery Date for each shipment not available",
				checkoutSumaryPg.validateEstimateDeliveryDate());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see the auto refill line populate for any eligible medication$")
	public void user_will_see_the_auto_refill_line_populate_for_any_eligible_medication() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -Auto Refill Line Populate not available for eligible medication",
				checkoutSumaryPg.validateAutoRefill());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user clicks on Place Order Btn$")
	public void user_clicks_on_Place_Order_Btn() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		checkoutSumaryPg.clickPlaceOrderBtn();
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see the Order Confirmation Page$")
	public void user_will_see_the_Order_Confirmation_Page() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Order Confirmation Page not available",
				checkoutSumaryPg.validateConfirmationPageHeader());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user fetches medication informations and clicks on Renew Medication call to action button$")
	public void user_fetches_medication_informations_clicks_Renew_Medication_call_to_action_button() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.waitTillMedCabLoads();
		pnpPg.clickOnViewAllMedicationsLink();
		List<Integer> indexOfRenewMedication = pnpPg.getListOfIndexForRenewMedicationOnMyMed();
		int countOfPage = Integer.parseInt(pnpPg.getCountOfMyMedPage());
		for (int i = 0; i < countOfPage; i++) {
			if (indexOfRenewMedication.size() == 0 && i != countOfPage - 1) {
				pnpPg.clickOnNextPageArrow();
				indexOfRenewMedication = pnpPg.getListOfIndexForRenewMedicationOnMyMed();
			}
		}
		listOfMedicationDetail = pnpPg.fetchesMedicationInformationFrRenew();
		int medicationToBeClicked = (int) listOfMedicationDetail.get(listOfMedicationDetail.size() - 1);
		pnpPg.clickOnRenewMedicationCTABasedOnIndex(medicationToBeClicked);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@When("^user clicks Refill Medication call to action button to navigate to checkout page$")
	public void user_clicks_Refill_Medication_call_to_action_button_to_navigate_to_checkout_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.waitTillMedCabLoads();
		pnpPg.clickOnViewAllMedicationsLink();
		List<Integer> indexOfRefillMedication = pnpPg.getListOfIndexForRefillMedicationOnMyMed();
		int countOfPage = Integer.parseInt(pnpPg.getCountOfMyMedPage());
		for (int i = 0; i < countOfPage; i++) {
			if (indexOfRefillMedication.size() == 0 && i != countOfPage - 1) {
				pnpPg.clickOnNextPageArrow();
				indexOfRefillMedication = pnpPg.getListOfIndexForRefillMedicationOnMyMed();
			}
		}

		/*
		 * while (indexOfRefillMedication.size() == 0) { pnpPg.clickOnNextPageArrow();
		 * indexOfRefillMedication = pnpPg.getListOfIndexForRefillMedicationOnMyMed(); }
		 */
		listOfMedicationDetail = pnpPg.fetchesMedicationInformationFrRefill();
		int medicationToBeClicked = (int) listOfMedicationDetail.get(listOfMedicationDetail.size() - 1);
		pnpPg.clickOnRefillMedicationCTABasedOnIndex(medicationToBeClicked);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@When("^user view the bottom of Skyline Complete Your Refill Component$")
	public void user_view_the_bottom_of_Skyline_Complete_Your_Refill_Component() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Disclaimer Message not available below SkyLine Component",
				checkoutSumaryPg.validateDisclaimerAvailableBelowSkyLineComponent());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will view the disclaimer message$")
	public void user_will_view_the_disclaimer_message() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Disclaimer Message not available", checkoutSumaryPg.validateDisclaimerMessage());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);

	}

	@Then("^disclaimer will remind the user that \"([^\"]*)\" is fulfilling the order$")
	public void disclaimer_will_remind_the_user_that_is_fulfilling_the_order(String expectedMsg) throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - OptumRx is not fulfilling the order",
				checkoutSumaryPg.validateOptumRxDisclaimerMessage(expectedMsg));
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

}
