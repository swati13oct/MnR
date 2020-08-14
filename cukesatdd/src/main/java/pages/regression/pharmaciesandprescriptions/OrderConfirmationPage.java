package pages.regression.pharmaciesandprescriptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
		return validate(ShippingMethodOrderConfirmation);
	}
	
	public boolean validateShippingAddress() {
		return validate(ShippingAddressOrderConfirmation);
	}	
	
	public boolean validatePaymentMethod() {
		return validate(PaymentMethodOrderConfirmation);
	}
	
	public boolean validateOrderTotal() {
		return validate(OrderTotalOrderConfirmation);
	}
	
	public boolean validateOrderTotalDisclaimer() {
		return validate(PriceDisclaimerOrderconfirmation);
	}
	
	public boolean validateEstimatedDeliveryDate() {
		return validate(EstimatedDeliveryDateOrderConfirmation);
	}
	
	public boolean validateMedicationSection() {
		return validate(MedicationSectionOrderConfirmation);
	}
	
	public boolean validateDrugNameAndStrength() {
		return validate(DrugNameSizeOrderConfirmation);
	}
	
	public boolean validateDaySupply() {
		return validate(DrugQuantityOrderConfirmation);
	}

	public boolean validateDrugPrice() {
		return validate(rxPriceOrderConfirmation);
	}
	
	public boolean validateRxNumber() {
		return validate(RXNumberOrderConfirmation);
	}
	
	public boolean validateRxProviderName() {
		return validate(RXProviderNameOrderConfirmation);
	}
	
	public boolean validateRxRefillsLeft() {
		return validate(RefillsRemaianingOrderConfirmation);
	}
	
	public boolean clickGoToPnPPage() {
		return validate(GoBackToPnPPageOrderConfirmation);
	}
	
	public boolean validateEstimationDateAlertMsg() {
		return validate(EstimationDateAlertMessage);
	}
	
}
