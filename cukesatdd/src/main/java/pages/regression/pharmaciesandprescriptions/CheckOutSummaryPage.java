package pages.regression.pharmaciesandprescriptions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	String cardDetailNameRegex = "^[a-zA-Z]*$";
	String cardDetailRegex = "^[0-9]{4}$";
	String cardTypeRegex = "^[a-zA-Z]*$";
	String medicationsRegex = "^[a-zA-Z]*\\s[(][0-9]*[)]$";

	public boolean validateCheckoutPageHeader(String expectedVal) {
		return orderCheckoutPageHeader.getText().equalsIgnoreCase(expectedVal);
	}

	public boolean validateCheckoutPageHeader() {
		return orderCheckoutPageHeader.getText().equalsIgnoreCase("Transfer to Home Delivery");
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
			if (!(ele.getText().equalsIgnoreCase("N/A"))) {
				float val = Float.parseFloat(ele.getText().substring(1));
				overAllPrice = overAllPrice + val;
			}
		}
		return overAllPrice;
	}

	public boolean validateOverAllMedicationAmtUnderOrderSummary() {
		String medicationPrice = orderSummaryMedicationPrice.getText();
		System.out.println("Medication Price :" + medicationPrice);
		if (!(medicationPrice.equals("N/A"))) {
			float medicationPriceUndrOrderSummary = Float.parseFloat(medicationPrice.substring(1));
			// int medicationPriceUndrOrderSummary =
			// Float.parseInt(medicationPrice.substring(1));
			float overAllRefillMedicationPrice = getOverAllMedicationPriceFromMedicationSectn();
			// int overAllRefillMedicationPrice =
			// getOverAllMedicationPriceFromMedicationSectn();
			return medicationPrice.matches(dollarAmntRegex)
					&& medicationPriceUndrOrderSummary == overAllRefillMedicationPrice;

		}
		return !medicationPrice.isEmpty();
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
			System.out.println("Inside the Shipping Fee Method");
			String shippingMethod = shippingDrpDownVal.getText();
			String shippingFee = orderSummaryShippingFee.getText();
			String[] arry = shippingMethod.split("-");
			if (!arry[1].trim().equalsIgnoreCase("Free")) {
				return shippingFee.equals(arry[1].trim()) && shippingFee.matches(dollarAmntRegex);
			}
			return shippingFee.equalsIgnoreCase(arry[1].trim());
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
		if (!shippingPrice.trim().equalsIgnoreCase("Free") && !(medicationPrice.equalsIgnoreCase("N/A"))) {
			return Integer.parseInt(totalPrice.substring(1)) == (Integer.parseInt(medicationPrice.substring(1))
					+ Integer.parseInt(shippingPrice.substring(1))) && totalPrice.matches(dollarAmntRegex);
		} else if (shippingPrice.trim().equalsIgnoreCase("Free") && !medicationPrice.equalsIgnoreCase("N/A")) {
			return totalPrice.trim().equals(medicationPrice.trim()) && totalPrice.matches(dollarAmntRegex);

		} else if (!shippingPrice.trim().equalsIgnoreCase("Free") && medicationPrice.equalsIgnoreCase("N/A")) {
			return totalPrice.trim().equals(shippingPrice.trim()) && totalPrice.matches(dollarAmntRegex);
		}
		return totalPrice.trim().equals(medicationPrice.trim());
	}

	public boolean validateDisclaimerUnderOrderSummary() {
		return validate(orderSummaryDisclaimer, 20);
	}

	public boolean validateConfirmationMsgUnderOrderSummary() {
		return validate(orderSummaryConfirmationMsg, 20) && !orderSummaryConfirmationMsg.getText().isEmpty();
	}

	public boolean validateConfirmationAddrssUnderOrderSummary() {
		return validate(orderSummaryConfirmationShippinAddrss, 20)
				&& !orderSummaryConfirmationShippinAddrss.getText().isEmpty();
	}

	public boolean validatePlaceOrderBtnUnderOrderSummary() {
		return validate(orderSummaryPlaceOrderBtn, 20);
	}

	public boolean validateShippingAddressSection() {
		return validate(shippingAddressSection, 20);
	}

	public boolean validatePreferedShippingAddressLabel() {
		return validate(shippingpreferredLabel, 20) && !shippingpreferredLabel.getText().isEmpty();
	}

	public boolean validateShippingAddressContent() {
		return validate(shippingAddressContent, 20) && !shippingAddressContent.getText().isEmpty();
	}

	public boolean validateChangeShippingAddressBtn() {
		return validate(changeShippingAddrssCTA, 20);
	}

	public boolean validatePaymentSection() {
		scrollToView(paymentSection);
		return validate(paymentSection, 20);
	}

	public boolean validatePreferedPaymentLabel() {
		scrollToView(paymentSection);
		return validate(paymentPreferredLabel, 20) && !paymentPreferredLabel.getText().isEmpty();
	}

	public boolean validatePaymentCardType() {
		scrollToView(paymentSection);
		return validate(paymentCreditCardImage, 20)
				&& paymentCreditCardImage.getAttribute("alt").trim().matches(cardTypeRegex);
	}

	public boolean validateChangePaymentBtn() {
		return validate(changePaymentCTA, 20);
	}

	public boolean validateCardExpiryDate() {
		return validate(paymentCreditCardExpDate, 20) && !paymentCreditCardExpDate.getText().isEmpty()
				&& paymentCreditCardExpDate.getText().trim().matches(exireDateRegexAlongwithTex);
	}

	public boolean validateCreditCardNumber() {
		String cardDetail = paymentCreditCardNumber.getText();
		String[] arrayVal = cardDetail.split(" ");
		return !paymentCreditCardNumber.getText().isEmpty()
				&& arrayVal[arrayVal.length - 1].trim().matches(cardDetailRegex)
				&& arrayVal[0].trim().matches(cardDetailNameRegex);
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

	public boolean validatePrescriptionNumberUnderMedicationIsMoreThanOne() {
		validate(prescriptionContainer, 30);
		int totalMedication = listOfPrescriptions.size();
		if (totalMedication > 1) {
			return true;
		} else {
			return false;
		}
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
		CommonUtility.waitForPageLoad(driver, orderSummaryPlaceOrderBtn, 30);
		validate(orderSummaryPlaceOrderBtn, 20);
		Actions actions = new Actions(driver);
		actions.moveToElement(orderSummaryPlaceOrderBtn);
		actions.click().build().perform();

		/*
		 * orderSummaryPlaceOrderBtn.click(); orderSummaryPlaceOrderBtn.click();
		 */
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
		// return listOfPrice.get(listOfPrice.size() -
		// 1).getText().trim().matches(dollarAmntRegex);

		/*
		 * String medicationPrice =
		 * RefillCheckoutSummaryStepDefinition.listOfMedicationDetail.get(3).toString();
		 * return
		 * medicationPrice.trim().equalsIgnoreCase(listOfPrice.get(listOfPrice.size() -
		 * 1).getText().trim());
		 */
		return !(listOfPrice.get(listOfPrice.size() - 1).getText().isEmpty());

	}

	public boolean validateDaySupply() {
		String daySupply = RefillCheckoutSummaryStepDefinition.listOfMedicationDetail.get(2).toString();
		String [] array=daySupply.split("\n");
		return listOfDaySupply.get(listOfDaySupply.size() - 1).getText().trim().contains(array[0].trim());
	}

	public boolean validateRefillsRemaining() {
		String refillRemainings = RefillCheckoutSummaryStepDefinition.listOfMedicationDetail.get(1).toString();
		String [] array=refillRemainings.split("\n");
		//int refillRemainingsFromMedCab = Integer.parseInt(refillRemainings);
		int refillRemainingsFromMedCab = Integer.parseInt(array[0]);
		String refillRemainingFrmCheckOutPage = listOfRefillRemaining.get(listOfRefillRemaining.size() - 1).getText();
		String[] arrayVal = refillRemainingFrmCheckOutPage.split(":");
		int refillRemainingsOnCheckOutPage = Integer.parseInt(arrayVal[1].trim());
		return refillRemainingsFromMedCab == refillRemainingsOnCheckOutPage;
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
		String [] array=daySupply.split("\n");
		return listOfDaySupply.get(listOfDaySupply.size() - 1).getText().trim().contains(array[0].trim());
	}

	public boolean validateShippingAlternateDate() {
		validate(shippingAlternateMsg, 20);
		return !shippingAlternateMsg.getText().isEmpty();
	}

	public OrderConfirmationPage navigateToOrderConfirmationPage() {
		CommonUtility.waitForPageLoad(driver, ThankyouMessageOrderConfirmation, 50);
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Current URL val : " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("/pharmacy/overview.html#/medication-management")) {
			CommonUtility.checkPageIsReady(driver);
			return new OrderConfirmationPage(driver);
		}
		return null;
	}

	public void clickPlaceOrderBtnOnCheckOutRenewPage() {
		CommonUtility.waitForPageLoad(driver, orderSummaryPlaceOrderBtn, 30);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		if (wait.until(ExpectedConditions.textToBePresentInElement(shippingMethodForRenew, "Standard"))) {
			validate(orderSummaryPlaceOrderBtn, 20);
			Actions actions = new Actions(driver);
			actions.moveToElement(orderSummaryPlaceOrderBtn);
			actions.click().build().perform();
		}
		/*
		 * orderSummaryPlaceOrderBtn.click(); orderSummaryPlaceOrderBtn.click();
		 */
	}

	public boolean validateShippingFeeUnderOrderSummaryForRenew() {
		// String shippingMethod = shippingDrpDownVal.getText();
		// int count = 0;

		WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.textToBePresentInElement(shippingDrpDownVal,
		// "Standard"));

		/*
		 * while (!shippingMethod.contains("Standard")) { shippingMethod =
		 * shippingDrpDownVal.getText(); count++; if (count > 10) { break; } }
		 */
		if (wait.until(ExpectedConditions.textToBePresentInElement(shippingMethodForRenew, "Standard"))) {
			String shippingMethod = shippingMethodForRenew.getText();
			String shippingFee = orderSummaryShippingFee.getText();
			String[] arry = shippingMethod.split("-");
			if (!arry[1].trim().equalsIgnoreCase("Free")) {
				return shippingFee.equalsIgnoreCase(arry[1].trim()) && shippingFee.matches(dollarAmntRegex);
			}
			return shippingFee.equalsIgnoreCase(arry[1].trim());
		}
		return false;
	}

	public boolean validateDisclaimerAvailableBelowSkyLineComponent() {
		return validate(disclaimerBelowSkyLineComponent, 10);
	}

	public boolean validateDisclaimerMessage() {
		return validate(disclaimerMessage) && !disclaimerMessage.getText().isEmpty();
	}

	public boolean validateOptumRxDisclaimerMessage(String expectedVal) {
		return disclaimerMessage.getText().contains(expectedVal);
	}

	public String getShippingAddress() {
		return shippingAddressContent.getText();
	}

	public void clickOnChangeShippingAddressCTA() {
		changeShippingAddrssCTA.click();
	}

	public ShippingAddressPage navigateToChangeShippingAddressPage() {
		CommonUtility.waitForPageLoad(driver, changeShippingAddressHeader, 50);
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Current URL val : " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("/pharmacy/overview.html#/medication-management")) {
			CommonUtility.checkPageIsReady(driver);
			return new ShippingAddressPage(driver);
		}
		return null;
	}

	public void clickOnAddPayment() {
		addPaymentCTA.click();
	}

	public void clickOnChangePayment() {
		changePaymentCTA.click();
	}

	public PaymentMethodPage navigateToAddPaymentMethodPage() {
		CommonUtility.waitForPageLoad(driver, addPaymentPage, 50);
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Current URL val : " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("https://uhgpghpp-stg.optum.com/")) {
			CommonUtility.checkPageIsReady(driver);
			return new PaymentMethodPage(driver);
		}
		return null;
	}

	public boolean validateNoPaymentCard() {
		return noPaymentMethod.isDisplayed();
	}

	public PaymentMethodPage navigateToChangePaymentMethodPage() {
		CommonUtility.waitForPageLoad(driver, changePaymentPage, 50);
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Current URL val before if condition inside navigateToChangePaymentMethodPage() is : "
				+ driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("pharmacy/overview.html#/medication-management")) {
			System.out.println("Current URL val inside if condition inside navigateToChangePaymentMethodPage() is "
					+ driver.getCurrentUrl());
			CommonUtility.checkPageIsReady(driver);
			return new PaymentMethodPage(driver);
		}
		return null;
	}

	public boolean validateNotDisplayedAsPreffered() {
		try {
			paymentPreferredLabel.isDisplayed();
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	public boolean validateAutoRefillField() {
		return medicationEligibleForAutoRefillEnrollment.size() > 0;
	}

	public boolean validateAutoRefillOffUnCheckedBox() {
		System.out.println("Auto Refill OFF Count :: " + autoRefillOffLabel.size());
		return autoRefillOffLabel.size() > 0;
	}

	public boolean validateAutoRefillOnCheckedBox() {
		System.out.println("Auto Refill ON Count :: " + autoRefillOnLabel.size());
		return autoRefillOnLabel.size() > 0;
	}
	
	public boolean validateAutoRefillOffCheckedBox() {
		System.out.println("Auto Refill Off Count :: " + autoRefillOffLabel.size());
		return autoRefillOffLabel.size() > 0;
	}

	public void deselectAutorefillCheckbox() {
		if (validateAutoRefillOnCheckedBox()) {
			autoRefillOnLabel.get(0).click();
			System.out.println("Auto Refill On checkbox is deselected");
		}
	}
	
	//Kiran
	public void selectAutorefillCheckbox() {
		autoRefillOFFCheckbox.click();
		/*if (validateAutoRefillOnCheckedBox()) {			
			autoRefillOFFCheckbox.get(0).click();
			
			System.out.println("Auto Refill OFF checkbox is selected");
		}*/
	}

	public boolean validateAutoRefillDisenrollmentPage() {
		return validate(autoRefillDisenrollmentPage, 30);
	}
		
	public boolean validateAutoRefillEnrollmentPage() {
		return validate(autoRefillEnrollmentPage, 30);
	}

	public void ContinueOrCancelAutorefillOn() {
		cancelAutoRefillPage.click();
	}
	
	public void enrollAutorefillCheckbox() {
		changeAutoRefillEnrollment.click();
	}
	
	public void stopAutorefillCheckbox() {
		changeAutoRefillEnrollment.click();
	}
	
	
}