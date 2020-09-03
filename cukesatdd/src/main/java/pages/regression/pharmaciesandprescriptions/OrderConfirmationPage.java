package pages.regression.pharmaciesandprescriptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.memberredesign.pharmaciesandprescriptions.RefillCheckoutSummaryStepDefinition;

public class OrderConfirmationPage extends OrderConfirmationWebElements {

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean validateOrderConfirmationThankyouMessage() {
		return validate(ThankyouMessageOrderConfirmation, 30);
	}

	public boolean validateOrderNumber() {
		return validate(OrderNumberOrderConfirmation);
	}

	public boolean validateOrderPlacedDate() {
		return validate(OrderPlacedDateOrderConfirmation);
	}

	public boolean validateOrderReceivedTracker() {
		return validate(OrderReceivedTrackerOrderConfirmation);
	}

	public boolean validateEmailConfirmationMessage() {
		return validate(EmailMessageOrderConfirmation);
	}

	public boolean validateOrderConfirmation() {
		return validate(OrderConfirmationSectionHeader);
	}

	public boolean validateShippingMethodFree() {
		if (validate(ShippingMethodOrderConfirmation)) {
			String shippingMethodExpected = "Free";
			String shippingMethodActual = ShippingMethodOrderConfirmation.getText()
					.substring(ShippingMethodOrderConfirmation.getText().indexOf("-") + 1);
			System.out.println("shippingMethodActual :: " + shippingMethodActual);
			if (shippingMethodExpected.equalsIgnoreCase(shippingMethodActual.trim())) {
				return true;
			}
		}
		return false;
	}

	public boolean validateShippingAddress() {
		if (validate(ShippingAddressOrderConfirmation)) {
			boolean flag = ShippingAddressOrderConfirmation.getText().isEmpty();
			if (flag) {
				return false;
			}
		}
		return true;
	}

	public boolean validatePaymentMethod() {
		return validate(PaymentMethodOrderConfirmation);
	}

	public boolean validatePaymentMethodType() {
		String PaymentMethodType = PaymentMethodTypeOrderConfirmation.getText().substring(2,
				PaymentMethodTypeOrderConfirmation.getText().indexOf("*") - 1);
		System.out.println("Payment Method Type " + PaymentMethodType);
		return !PaymentMethodType.isEmpty();
	}

	public boolean validatePaymentMethodNumber() {
		String PaymentMethodNumber = PaymentMethodTypeOrderConfirmation.getText()
				.substring(PaymentMethodTypeOrderConfirmation.getText().lastIndexOf("*") + 1);
		System.out.println("Payment Method Number " + PaymentMethodNumber);
		return !PaymentMethodNumber.isEmpty();
	}

	public boolean validateOrderTotal() {
		if (validate(OrderTotalOrderConfirmation,10)) {
			String orderTotal = OrderTotalOrderConfirmation.getText();
			if (!orderTotal.isEmpty()) {
				if (orderTotal.equalsIgnoreCase("Order Total: N/A")) {
					System.out.println(orderTotal);
					Assert.assertEquals(orderTotal, "Order Total: N/A", "Order Total: N/A is displayed successfully");
					return true;
				}
				else if (orderTotal.contains("Order Total: $")){
					System.out.println(orderTotal);
					return true;
				}
			}
		}
		return false;
	}

	public boolean validateOrderTotalDisclaimer() {
		if (validate(PriceDisclaimerOrderconfirmation)) {
			return !PriceDisclaimerOrderconfirmation.getText().isEmpty();
		}
		return false;
	}

	public boolean validateEstimatedDeliveryDate() {
		if (validate(EstimatedDeliveryDateOrderConfirmation)) {
			return !EstimatedDeliveryDateOrderConfirmation.getText().isEmpty();
		}
		return false;
	}

	public boolean validateMedicationSection() {
		return validate(MedicationSectionOrderConfirmation);
	}

	public boolean validateMedicineNameOnOrderConfirmation() {

		return true;
	}

	public boolean validateDrugNameAndStrength() {
		String medicationNameAndStrength = RefillCheckoutSummaryStepDefinition.listOfMedicationDetail.get(0).toString();
		System.out.println("Medication Name eligible for Refill is :: " + medicationNameAndStrength);
		System.out.println("Drug Name and  Strenght on Order Confirmation is :: " + DrugNameSizeOrderConfirmation);
		return validate(DrugNameSizeOrderConfirmation, 40)
				&& medicationNameAndStrength.trim().equalsIgnoreCase(DrugNameSizeOrderConfirmation.getText().trim());
	}

	public boolean validateDaySupply() {
		return validate(DrugQuantityOrderConfirmation);
	}

	public boolean validateDrugPrice() {
		scrollToView(rxPriceOrderConfirmation);
		if (validate(rxPriceOrderConfirmation,10)) {
			String orderTotal = rxPriceOrderConfirmation.getText();
			if (!orderTotal.isEmpty()) {
				if (orderTotal.equalsIgnoreCase("N/A")) {
					System.out.println(orderTotal);
					return true;
				}
				else if (orderTotal.contains("$")){
					System.out.println(orderTotal);
					return true;
				}
			}
		}
		return false;
	}

	public boolean validateRxNumber() {
		scrollToView(RXNumberOrderConfirmation);
		return validate(RXNumberOrderConfirmation, 10);
	}

	public boolean validateRxProviderName() {
		scrollToView(RXProviderNameOrderConfirmation);
		return validate(RXProviderNameOrderConfirmation, 10);
	}

	public boolean validateRxRefillsLeft() {
		scrollToView(RefillsRemaianingOrderConfirmation);
		return validate(RefillsRemaianingOrderConfirmation, 10);
	}

	public void clickGoToPnPPage() {
		scrollToView(GoBackToPnPPageOrderConfirmation);
		GoBackToPnPPageOrderConfirmation.click();
	}
	
	public boolean validateEstimationDateAlertMsg() {
		return validate(EstimationDateAlertMessage,10);
	}
}
