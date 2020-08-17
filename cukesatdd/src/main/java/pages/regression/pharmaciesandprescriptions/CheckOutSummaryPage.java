package pages.regression.pharmaciesandprescriptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.memberredesign.pharmaciesandprescriptions.MedicineCabinetStepDefinition;
import acceptancetests.memberredesign.pharmaciesandprescriptions.RefillCheckoutSummaryStepDefinition;
import acceptancetests.util.CommonUtility;

public class CheckOutSummaryPage extends CheckOutSummaryWebElements {

	public CheckOutSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	String dollarAmntRegex = "^(\\$)((\\d+)|(\\d{1,3})(\\,\\d{3})*)(\\.\\d{2,})?$";
	String expireDateRegex = "^(0[1-9]|1[0-2])\\/?([0-9]{4}|[0-9]{2})$";
	String exireDateRegexAlongwithTex = "^[a-zA-Z]*\\s[a-zA-Z]*\\s(0[1-9]|1[0-2])\\/?([0-9]{4}|[0-9]{2})$";
	// String cardDetailRegex = "^[a-zA-Z]*\\s[*]{4}\\s[0-9]{4}$";
	String cardDetailRegex = "^[0-9]{4}$";
	String cardTypeRegex = "^[a-zA-Z]*$";
	String medicationsRegex = "^[a-zA-Z]*\\s[(][0-9]*[)]$";

	public boolean validateCheckoutPageHeader(String expectedVal) {
		return orderCheckoutPageHeader.getText().equalsIgnoreCase(expectedVal);
	}

	public boolean validateOrderSummarySection() {
		return validate(orderSummarySection, 20);
	}

	public boolean validateMedicationLineUnderOrderSummary() {
		return validate(orderSummaryMedicationLabel, 20);
	}

	public boolean validatePrescriptionNumberUnderOrderSummary() {
		String medicationLabel = orderSummaryMedicationLabel.getText();
		int totalRefillMedication = listOfPrescriptions.size();
		return (medicationLabel.contains(Integer.toString(totalRefillMedication))
				&& medicationLabel.matches(medicationsRegex));
	}

	public float getOverAllMedicationPriceFromMedicationSectn() {
		/*
		 * int overAllPrice = 0; for (WebElement ele : listOfPrice) { int val =
		 * Integer.parseInt(ele.getText().substring(1)); overAllPrice = overAllPrice +
		 * val; }
		 */

		float overAllPrice = 0;
		for (WebElement ele : listOfPrice) {
			float val = Float.parseFloat(ele.getText().substring(1));
			overAllPrice = overAllPrice + val;
		}
		return overAllPrice;
	}

	public boolean validateOverAllMedicationAmtUnderOrderSummary() {
		String medicationPrice = orderSummaryMedicationPrice.getText();
		float medicationPriceUndrOrderSummary = Float.parseFloat(medicationPrice.substring(1));
		// int medicationPriceUndrOrderSummary =
		// Float.parseInt(medicationPrice.substring(1));
		float overAllRefillMedicationPrice = getOverAllMedicationPriceFromMedicationSectn();
		// int overAllRefillMedicationPrice =
		// getOverAllMedicationPriceFromMedicationSectn();
		return medicationPrice.matches(dollarAmntRegex)
				&& medicationPriceUndrOrderSummary == overAllRefillMedicationPrice;
	}

	public boolean validateShippingLabelUnderOrderSummary() {
		return validate(orderSummaryShippingLabel, 20);
	}

	public boolean validateShippingFeeUnderOrderSummary() {
		// String shippingMethod = shippingDrpDownVal.getText();
		// int count = 0;

		WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.textToBePresentInElement(shippingDrpDownVal,
		// "Standard"));

		/*
		 * while (!shippingMethod.contains("Standard")) { shippingMethod =
		 * shippingDrpDownVal.getText(); count++; if (count > 10) { break; } }
		 */
		if (wait.until(ExpectedConditions.textToBePresentInElement(shippingDrpDownVal, "Standard"))) {
			String shippingMethod = shippingDrpDownVal.getText();
			String shippingFee = orderSummaryShippingFee.getText();
			String[] arry = shippingMethod.split("-");
			if (!arry[1].trim().equals("Free")) {
				return shippingFee.equals(arry[1].trim()) && shippingFee.matches(dollarAmntRegex);
			}
			return shippingFee.equals(arry[1].trim());
		}
		return false;
	}

	public boolean validateTotalLabelUnderOrderSummary() {
		return validate(orderSummaryTotalLabel, 20);
	}

	public boolean validateTotalPriceUnderOrderSummary() {
		String medicationPrice = orderSummaryMedicationPrice.getText();
		String shippingPrice = orderSummaryShippingFee.getText();
		String totalPrice = orderSummaryTotalPrice.getText();
		if (!shippingPrice.trim().equals("Free")) {
			return Integer.parseInt(totalPrice.substring(1)) == (Integer.parseInt(medicationPrice.substring(1))
					+ Integer.parseInt(shippingPrice.substring(1)));
		}
		return totalPrice.equals(totalPrice) && totalPrice.matches(dollarAmntRegex);
	}

	public boolean validateDisclaimerUnderOrderSummary() {
		return validate(orderSummaryDisclaimer, 20);
	}

	public boolean validateConfirmationMsgUnderOrderSummary() {
		return !orderSummaryConfirmationMsg.getText().isEmpty();
	}

	public boolean validateConfirmationAddrssUnderOrderSummary() {
		return !orderSummaryConfirmationShippinAddrss.getText().isEmpty();
	}

	public boolean validatePlaceOrderBtnUnderOrderSummary() {
		return validate(orderSummaryPlaceOrderBtn, 20);
	}

	public boolean validateShippingAddressSection() {
		return validate(shippingAddressSection, 20);
	}

	public boolean validatePreferedShippingAddressLabel() {
		return !shippingpreferredLabel.getText().isEmpty();
	}

	public boolean validateShippingAddressContent() {
		return !shippingAddressContent.getText().isEmpty();
	}

	public boolean validateChangeShippingAddressBtn() {
		return validate(changeShippingAddrssCTA, 20);
	}

	public boolean validatePaymentSection() {
		return validate(paymentSection, 20);
	}

	public boolean validatePreferedPaymentLabel() {
		return !paymentPreferredLabel.getText().isEmpty();
	}

	public boolean validatePaymentCardType() {
		return validate(paymentCreditCardImage)
				&& paymentCreditCardImage.getAttribute("alt").trim().matches(cardTypeRegex);
	}

	public boolean validateChangePaymentBtn() {
		return validate(changePaymentCTA, 20);
	}

	public boolean validateCardExpiryDate() {
		return !paymentCreditCardExpDate.getText().isEmpty()
				&& paymentCreditCardExpDate.getText().trim().matches(exireDateRegexAlongwithTex);
	}

	public boolean validateCreditCardNumber() {
		String cardDetail = paymentCreditCardNumber.getText();
		String[] arrayVal = cardDetail.split(" ");
		return !paymentCreditCardNumber.getText().isEmpty()
				&& arrayVal[arrayVal.length - 1].trim().matches(cardDetailRegex);
	}

	/*
	 * public boolean validateRefillMedicationName() { List<String>
	 * listOfMedicationName;
	 * 
	 * 
	 * }
	 */

	public boolean validateMedicationSection() {
		return validate(medicationsSection, 20);
	}

	public boolean validatePrescriptionNumberUnderMedicationSectn() {
		validate(prescriptionContainer, 30);
		int totalMedication = listOfPrescriptions.size();
		return medicationsHeader.getText().contains(Integer.toString(totalMedication))
				&& medicationsHeader.getText().matches(medicationsRegex);
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
		CommonUtility.waitForPageLoad(driver, orderSummaryPlaceOrderBtn,30);
		validate(orderSummaryPlaceOrderBtn, 20);
		Actions actions = new Actions(driver);
		actions.moveToElement(orderSummaryPlaceOrderBtn);
		actions.click().build().perform();
		/*orderSummaryPlaceOrderBtn.click();
		orderSummaryPlaceOrderBtn.click();*/
	}

	public boolean validatePreferredPaymentMethod() {
		return validate(preferredPaymentMethod, 20);
	}

	public boolean validateConfirmationSection() {
		return validate(orderSummaryConfirmationSection, 20);
	}

	public boolean validateMedicationNameAndStrength() {
		String medicationNameAndStrength = RefillCheckoutSummaryStepDefinition.listOfMedicationDetail.get(0).toString();
		System.out.println("Medication Name" + medicationNameAndStrength);
		/*
		 * int size=listOfDrugName.size(); int count=0; while(size==0) {
		 * size=listOfDrugName.size();
		 * 
		 * 
		 * }
		 */
		/*
		 * System.out.println("Med Name on Refill Page" +
		 * listOfDrugName.get(listOfDrugName.size() - 1).getText().trim()); return
		 * medicationNameAndStrength.trim()
		 * .equalsIgnoreCase(listOfDrugName.get(listOfDrugName.size() -
		 * 1).getText().trim());
		 */
		return validate(drugNameOnCheckOutPage, 40)
				&& medicationNameAndStrength.trim().equalsIgnoreCase(drugNameOnCheckOutPage.getText().trim());

	}

	public boolean validateMedicationPrice() {
		// String medicationPrice =
		// RefillCheckoutSummaryStepDefinition.listOfMedicationDetail.get(3).toString();
		return listOfPrice.get(listOfPrice.size() - 1).getText().trim().matches(dollarAmntRegex);
	}

	public boolean validateDaySupply() {
		String daySupply = RefillCheckoutSummaryStepDefinition.listOfMedicationDetail.get(2).toString();
		return listOfDaySupply.get(listOfDaySupply.size() - 1).getText().trim().contains(daySupply.trim());
	}

	public boolean validateRefillsRemaining() {
		String refillRemainings = RefillCheckoutSummaryStepDefinition.listOfMedicationDetail.get(1).toString();
		int refillRemainingsFromMedCab = Integer.parseInt(refillRemainings);
		String refillRemainingFrmCheckOutPage = listOfRefillRemaining.get(listOfRefillRemaining.size() - 1).getText();
		String[] arrayVal = refillRemainingFrmCheckOutPage.split(":");
		int refillRemainingsOnCheckOutPage = Integer.parseInt(arrayVal[1].trim());
		return refillRemainingsFromMedCab == refillRemainingsOnCheckOutPage + 1;
	}

	public boolean validateRxNumber() {
		return !listOfRxNumber.get(listOfRxNumber.size() - 1).getText().isEmpty();
	}

	public boolean validateProviderName() {
		return !listOfProviderName.get(listOfProviderName.size() - 1).getText().isEmpty();
	}

	public boolean validateShippingContainer() {
		return listOfShipmentContainers.size() > 1;
	}

	public boolean validateShipmentIndicated() {
		int shippingContainer = listOfShipmentContainers.size();
		return listOfShippingShipments.size() == shippingContainer;
	}

	public boolean validateEstimateDeliveryDate() {
		int shippingContainer = listOfShipmentContainers.size();
		return listfOfEstimatedDate.size() == shippingContainer;
	}

	public boolean validateAutoRefill() {
		return listOfAutoRefillCTA.size() > 0;
	}

	public void clickOnRefillALLMedicationCTA() {
		refillAllMedicationCTA.click();
	}

	public boolean validateConfirmationPageHeader() {
		return validate(orderConfirmationPageHeader, 20);
	}

	public boolean validateDaySupplyForRenew() {
		String daySupply = RefillCheckoutSummaryStepDefinition.listOfMedicationDetail.get(1).toString();
		return listOfDaySupply.get(listOfDaySupply.size() - 1).getText().trim().contains(daySupply.trim());
	}

	public boolean validateShippingAlternateDate() {
		validate(shippingAlternateMsg, 20);
		return !shippingAlternateMsg.getText().isEmpty();
	}
	
	public OrderConfirmationPage navigateToOrderConfirmationPage() {
		//CommonUtility.waitForPageLoad(driver, ThankyouMessageOrderConfirmation, 40);
		CommonUtility.checkPageIsReady(driver);
		if (driver.getCurrentUrl().contains("order-confirmation")) {
			CommonUtility.checkPageIsReady(driver);
			return new OrderConfirmationPage(driver);
		}
		return null;
	}
}