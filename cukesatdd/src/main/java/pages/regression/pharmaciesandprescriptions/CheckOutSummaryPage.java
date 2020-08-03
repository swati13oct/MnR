package pages.regression.pharmaciesandprescriptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckOutSummaryPage extends CheckOutSummaryWebElements {

	public CheckOutSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	String dollarAmntRegex = "^(\\$)((\\d+)|(\\d{1,3})(\\,\\d{3})*)(\\.\\d{2,})?$";
	String expireDateRegex = "^((0[1-9])|(1[0-2]))\\/(\\d{2})$";
	String cardDetailRegex = "^[a-zA-Z]*\\s[*]{4}\\s[0-9]{4}$";
	String cardTypeRegex = "^[a-zA-Z]*$";
	String medicationsRegex = "^[a-zA-Z]*\\s[(][0-9]*[)]$";

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
		int totalRefillMedication = listOfPrescriptions.size();
		return (orderSummaryMedicationLabel.getText().contains(Integer.toString(totalRefillMedication))
				&& orderSummaryMedicationLabel.getText().matches(medicationsRegex));
	}

	public int getOverAllMedicationPriceFromMedicationSectn() {
		int overAllPrice = 0;
		for (WebElement ele : listOfPrice) {
			int val = Integer.parseInt(ele.getText().substring(1));
			overAllPrice = overAllPrice + val;
		}
		return overAllPrice;
	}

	public boolean validateOverAllMedicationAmtUnderOrderSummary() {
		int medicationPriceUndrOrderSummary = Integer.parseInt(orderSummaryMedicationPrice.getText().substring(1));
		int overAllRefillMedicationPrice = getOverAllMedicationPriceFromMedicationSectn();
		return orderSummaryMedicationPrice.getText().matches(dollarAmntRegex)
				&& medicationPriceUndrOrderSummary == overAllRefillMedicationPrice;
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
		return validate(paymentCreditCardImage) && paymentCreditCardImage.getAttribute("alt").matches(cardTypeRegex);
	}

	public boolean validateChangePaymentBtn() {
		return validate(changePaymentCTA);
	}

	public boolean validateCardExpiryDate() {
		return !paymentCreditCardExpDate.getText().isEmpty()
				&& paymentCreditCardExpDate.getText().matches(expireDateRegex);
	}

	public boolean validateCreditCardNumber() {
		return !paymentCreditCardNumber.getText().isEmpty()
				&& paymentCreditCardNumber.getText().matches(cardDetailRegex);
	}

	/*
	 * public boolean validateRefillMedicationName() { List<String>
	 * listOfMedicationName;
	 * 
	 * 
	 * }
	 */

	public boolean validateMedicationSection() {
		return validate(medicationsSection);
	}

	public boolean validatePrescriptionNumberUnderMedicationSectn() {
		int totalMedication = listOfPrescriptions.size();
		return medicationsHeader.getText().contains(Integer.toString(totalMedication)) && medicationsHeader.getText().matches(medicationsRegex);
	}

	public boolean validateRemoveItemFromOrderCTA() {
		for (WebElement ele : listOfRemoveItemFromOrderCTA) {
			if (!(validate(ele) && ele.getTagName().equals("button"))) {
				return false;
			}
		}
		return true;
	}

	public void clickPlaceOrderBtn() {
		validate(orderSummaryPlaceOrderBtn);
		orderSummaryPlaceOrderBtn.click();
	}
}
