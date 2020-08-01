package pages.regression.pharmaciesandprescriptions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationsPage extends OrderConfirmationWebElements{

	public OrderConfirmationsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	String dollarAmntRegex="^(\\$)((\\d+)|(\\d{1,3})(\\,\\d{3})*)(\\.\\d{2,})?$";
	
	public boolean validatePageHeader(String expectedVal) {
		return orderConfirmationPageHeader.getText().equalsIgnoreCase(expectedVal);
	}

	public boolean validateOrderSummarySection() {
		return validate(orderSummarySection);
	}
	
	public boolean validateMedicationLineUnderOrderSummary() {
		return validate(orderSummaryMedicationLabel);
	}
	
	public boolean validatePrescriptionNumberUnderOrderSummary() {
		int totalRefillMedication=listOfRefillMedication.size();
		return orderSummaryMedicationLabel.getText().contains(Integer.toString(totalRefillMedication));
	}
	
	public int getOverAllRefillMedicationPriceFromMedicationSectn() {
		int overAllPrice=0;
		for(WebElement ele:listOfRxNumber) {
			int val=Integer.parseInt(ele.getText().substring(1));
			overAllPrice=overAllPrice+val;
		}
		return overAllPrice;
	}
	
	public boolean validateOverAllRefillMedicationAmtUnderOrderSummary() {
		int medicationPriceUndrOrderSummary=Integer.parseInt(orderSummaryMedicationPrice.getText().substring(1));
		int overAllRefillMedicationPrice=getOverAllRefillMedicationPriceFromMedicationSectn();
		return orderSummaryMedicationPrice.getText().matches(dollarAmntRegex) && medicationPriceUndrOrderSummary==overAllRefillMedicationPrice;
	}
	
	public boolean validateShippingLabelUnderOrderSummary() {
		return validate(orderSummaryShippingLabel);
	}
	
	public boolean validateShippingFeeUnderOrderSummary() {
		return validate(orderSummaryShippingFee);
	}
	
	public boolean validateTotalLabelUnderOrderSummary() {
		return validate(orderSummaryTotalLabel);
	}
	
	public boolean validateTotalPriceUnderOrderSummary() {
		return validate(orderSummaryTotalPrice);
	}
	
	public boolean validateDisclaimerUnderOrderSummary() {
		return validate(orderSummaryDisclaimer);
	}
	
	public boolean validateConfirmationMsgUnderOrderSummary() {
		return !orderSummaryConfirmationMsg.getText().isEmpty();
	}
	
	public boolean validateConfirmationAddrssUnderOrderSummary() {
		return !orderSummaryConfirmationShippinAddrss.getText().isEmpty();
	}
	
	public boolean validatePlaceOrderBtnUnderOrderSummary() {
		return validate(orderSummaryPlaceOrderBtn);
	}
	
	public boolean validateShippingAddressSection() {
		return validate(shippingAddressSection);
	}
	
	public boolean validatePreferedShippingAddressLabel() {
		return !shippingpreferredLabel.getText().isEmpty();
	}
	
	public boolean validateShippingAddressContent() {
		return !shippingAddressContent.getText().isEmpty();
	}
	
	public boolean validateChangeShippingAddressBtn() {
		return validate(changeShippingAddrssCTA);
	}
	
	public boolean validatePaymentSection() {
		return validate(paymentSection);
	}
	
	public boolean validatePreferedPaymentLabel() {
		return !paymentPreferredLabel.getText().isEmpty();
	}
	
	public boolean validatePaymentCardType() {
		return validate(paymentCreditCardImage);
	}
	
	public boolean validateChangePaymentBtn() {
		return validate(changePaymentCTA);
	}
	
	public boolean validatePaymentExpiryDate() {
		return !paymentCreditCardExpDate.getText().isEmpty();
	}
	
	public boolean validateCreditCardNumber() {
		return !paymentCreditCardNumber.getText().isEmpty();
	}
	
	/*public boolean validateRefillMedicationName() {
		List<String> listOfMedicationName;
		
		
	}*/
	
	public boolean validateRefillMedicationSection() {
		return validate(refillMedicationSection);
	}
	
	public boolean validatePrescriptionNumberUnderMedicationSectn() {
		int totalRefillMedication=listOfRefillMedication.size();
		return medicationsHeader.getText().contains(Integer.toString(totalRefillMedication));
	}
	
}
