package pages.regression.pharmaciesandprescriptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.memberredesign.pharmaciesandprescriptions.RefillCheckoutSummaryStepDefinition;

public class OrderConfirmationPage extends OrderConfirmationWebElements {
	
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateOrderConfirmationThankyouMessage() {
		return validate(ThankyouMessageOrderConfirmation,30);
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
	
	public boolean validateShippingMethod() {
		if(validate(ShippingMethodOrderConfirmation)) {
			String shippingMethodExpected =": Standard Shipping - Free";
			String shippingMethodActual=ShippingMethodOrderConfirmation.getText();
			System.out.println("shippingMethodActual" + shippingMethodActual.substring(shippingMethodActual.indexOf(":")));
			if(shippingMethodExpected.equalsIgnoreCase(shippingMethodActual.substring(shippingMethodActual.indexOf(":")))) {
				return true;
			}
		}		
		return false;
	}
	
	public boolean validateShippingAddress() {
		if(validate(ShippingAddressOrderConfirmation)) {
			boolean flag = ShippingAddressOrderConfirmation.getText().isEmpty();
			if(flag) {
				return false;
			}
		}
		return true;
	}	
	
	public boolean validatePaymentMethod() {
		return validate(PaymentMethodOrderConfirmation);		
	}
	
	public boolean validatePaymentMethodType() {
		return !PaymentMethodTypeOrderConfirmation.getText().isEmpty();
	}
	
	public boolean validatePaymentMethodNumber() {
		return !PaymentMethodNumberOrderConfirmation.getText().isEmpty();
	}
	
	public boolean validateOrderTotal() {
		if(validate(OrderTotalOrderConfirmation)) {
			return !OrderTotalOrderConfirmation.getText().isEmpty();
		}
		return false;		
	}
	
	public boolean validateOrderTotalDisclaimer() {
		if(validate(PriceDisclaimerOrderconfirmation)) {
			return !PriceDisclaimerOrderconfirmation.getText().isEmpty();
		}
		return false;
	}
	
	public boolean validateEstimatedDeliveryDate() {
		if(validate(EstimatedDeliveryDateOrderConfirmation)) {
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
		System.out.println("Medication Name" + medicationNameAndStrength);
		return validate(DrugNameSizeOrderConfirmation, 40)
				&& medicationNameAndStrength.trim().equalsIgnoreCase(DrugNameSizeOrderConfirmation.getText().trim());
	}
	
	public boolean validateDaySupply() {
		return validate(DrugQuantityOrderConfirmation);
	}

	public boolean validateDrugPrice() {
		scrollToView(rxPriceOrderConfirmation);
		return validate(rxPriceOrderConfirmation,10);
	}
	
	public boolean validateRxNumber() {
		scrollToView(RXNumberOrderConfirmation);
		return validate(RXNumberOrderConfirmation,10);
	}
	
	public boolean validateRxProviderName() {
		scrollToView(RXProviderNameOrderConfirmation);
		return validate(RXProviderNameOrderConfirmation,10);
	}
	
	public boolean validateRxRefillsLeft() {
		scrollToView(RefillsRemaianingOrderConfirmation);
		return validate(RefillsRemaianingOrderConfirmation,10);
	}
	
	public void clickGoToPnPPage() {
		scrollToView(GoBackToPnPPageOrderConfirmation);
		GoBackToPnPPageOrderConfirmation.click();
	}
	
}
