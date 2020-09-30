package pages.regression.pharmaciesandprescriptions;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.util.CommonUtility;

public class PaymentMethodPage extends PaymentMethodWelement {

	public PaymentMethodPage(WebDriver driver) {
		super(driver);
	}

	public static String nextMonth, nextYear;

	public boolean validateAddPaymentPage() {
		return addPaymentPage.getText().trim().equalsIgnoreCase("Enter your payment method in the form below.");
	}

	public void enterTextInCardHolderName(String valueToBeEntered) {
		cardHolderName.sendKeys(valueToBeEntered);
	}

	public boolean validateCardHolderNameEnteredInNameField(String valueToVerify) {
		return cardHolderName.getAttribute("value").contains(valueToVerify);
	}

	public void enterTextInCardNumber(String valueToBeEntered) {
		cardNumber.sendKeys(valueToBeEntered);
	}

	public boolean validateCardNumberEnteredInCardNumberField(String valueToVerify) {
		return cardNumber.getAttribute("value").contains(valueToVerify);
	}

	public static void currentDate() {
		// Getting the current date value
		LocalDate currentdate = LocalDate.now();
		System.out.println("Current date: " + currentdate);
		nextYear = currentdate.toString().substring(0, 4);
		int year = Integer.parseInt(nextYear) + 1;
		String currentMonth = currentdate.toString().substring(5, 7);
		int month = Integer.parseInt(currentMonth);
		nextMonth = (month <= 12) ? (currentMonth) : ("01");
		nextYear = Integer.toString(year);
		System.out.println("Next Month: " + nextMonth);
		System.out.println("Next Year: " + nextYear);

		// Current date: 2020-09-25
		// Next Month: 01
		// Next Year: 2020
	}

	public void selectMonthExp() {
		currentDate();
		Select month = new Select(driver.findElement(By.xpath("//select[@name='month']")));
		month.selectByVisibleText(nextMonth);
	}

	public void selectYearExp() {
		currentDate();
		Select year = new Select(driver.findElement(By.xpath("//select[@name='year']")));
		year.selectByVisibleText(nextYear);
	}

	public void enterTextInBillingAddressOne(String valueToBeEntered) {
		billingAddressLine1.sendKeys(valueToBeEntered);
	}

	public boolean validateCardNumberEnteredInBillingAddressOne(String valueToVerify) {
		return billingAddressLine1.getAttribute("value").contains(valueToVerify);
	}

	public void enterTextInBillingAddressTwo(String valueToBeEntered) {
		billingAddressLine2.sendKeys(valueToBeEntered);
	}

	public boolean validateCardNumberEnteredInBillingAddressTwo(String valueToVerify) {
		return billingAddressLine2.getAttribute("value").contains(valueToVerify);
	}

	public void enterTextInCity(String valueToBeEntered) {
		city.sendKeys(valueToBeEntered);
	}

	public boolean validateCardNumberEnteredInCity(String valueToVerify) {
		return city.getAttribute("value").contains(valueToVerify);
	}

	public void selectState(String valueToBeEntered) {
		Select year = new Select(stateSelect);
		year.selectByVisibleText(valueToBeEntered);
	}

	public void enterTextInZipCode(String valueToBeEntered) {
		zipCode.sendKeys(valueToBeEntered);
	}

	public boolean validateCardNumberEnteredInZipCode(String valueToVerify) {
		return zipCode.getAttribute("value").contains(valueToVerify);
	}

	public void clickXIconAddPaymentPage() {
		crossIconButtonAddPayment.click();
	}

	public void clickOnCancelCTA() {
		cancelButtonAddpayment.click();
	}

	public void clickSavePaymentMethod() {
		savePaymentMethodButtonAddpayment.click();
		threadsleep(30);
	}

	public boolean validateChangePaymentPage() {
		CommonUtility.waitForPageLoad(driver, changePaymentPage, 120);
		/* CommonUtility.waitForPageLoad(driver, drugNameOnCheckOutPage, 60); */
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Validate Change Payment Page before if condition :: " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("pharmacy/overview.html#/medication-management")) {
			CommonUtility.checkPageIsReady(driver);
			System.out.println("Validate Change Payment Page inside if condition :: " + driver.getCurrentUrl());
			// return changePaymentPage.getText().trim().equalsIgnoreCase("Change Payment");

			return payWithLabel.getText().trim().equalsIgnoreCase("Pay with:");
		}
		return false;
	}

	public boolean validateSuccessMsgForNewCreditCardAdded() {
		return cardAddSuccessMessage.getText().trim().equalsIgnoreCase("Success! You've added a credit card.");
	}

	public boolean validateFirstCardAdded() {
		if (validateChangePaymentPage())
			CommonUtility.waitForElementToDisappear(driver, processThreeDotLoader, 480);
		System.out.println("Number of cards displayed on Change Payment page is :: " + cardList.size());
		return (cardList.size() == 1) ? (true) : (false);
	}

	public void clickBackButtonOnChangePaymentPage() {
		if (driver.getCurrentUrl().contains("pharmacy/overview.html#/medication-management")) {
			backButtonChangePaymentPage.click();
		}
	}

	public void clickAddCardButtonOnChangePaymentPage() {
		System.out.println("Validate Change Payment Page before clicking Add Card :: " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("pharmacy/overview.html#/medication-management")) {
			addCardButtonChangePage.click();
		}
	}

	public void selectCard() {
		// selecting the Radio buttons by Name
		int Size = selectCardChangePage.size();
		boolean bval = false;
		bval = selectCardChangePage.get(0).isSelected();
		if (bval = true) {
			selectCardChangePage.get(1).click();
		} else {
			selectCardChangePage.get(0).click();
		}
	}

	public void editCard() {
		System.out.println("Number of Edit Link displayed on Change Payment Page :: " + editCTAChangePage.size());
		editCTAChangePage.get(0).click();
	}

	public boolean validateEditPaymentPage() {
		return editPaymentPage.getText().trim().equalsIgnoreCase("Edit Payment");
	}

	public boolean validateNameNotEditableEditPaymentPage() {
		return !fNameEditChangePage.getTagName().equalsIgnoreCase("input");
	}

	public boolean validateCardNumberNotEditableEditPaymentPage() {
		return !cardNumberEditChangePage.getTagName().equalsIgnoreCase("input");
	}

	public void closeEditPaymentPage() {
		XIconEditChangePage.click();
	}

	public void cancelEditPaymentPage() {
		cancelPaymentButtonEditChangePage.click();
	}

	public void updateExpirationDate() {
		monthYearExpireEditChangePage.clear();
		int year = Integer.parseInt(nextYear) + 1;
		System.out.println("Update expiration date by current year + 2 year :: " + year);// Update expiration date by
																							// current year + 2 year ::
																							// 2022
		String yearStr = Integer.toString(year);
		String monthYear = nextMonth + "/" + yearStr;
		System.out.println("Update monthYear:: " + monthYear);// Update monthYear:: 09/2022
		// monthYearExpireEditChangePage.sendKeys("09/2025");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='09/2025';", monthYearExpireEditChangePage);
	}

	public void updateBillingAddressOne(String valueToBeEntered) {
		addressLineOneEditChangePage.clear();
		addressLineOneEditChangePage.sendKeys(valueToBeEntered);
	}

	public boolean validateUpdatedBillingAddressOneValue(String valueToVerify) {
		return addressLineOneEditChangePage.getAttribute("value").contains(valueToVerify);
	}

	public void updateBillingAddressTwo(String valueToBeEntered) {
		addressLineTwoEditChangePage.clear();
		addressLineTwoEditChangePage.sendKeys(valueToBeEntered);
	}

	public boolean validateUpdatedBillingAddressTwoValue(String valueToVerify) {
		return addressLineTwoEditChangePage.getAttribute("value").contains(valueToVerify);
	}

	public boolean validateAddAdditionalAddressLineLink() {
		return additionalAddressLineLinkEditChangePage.isDisplayed();
	}

	public boolean validateAddAdditionalAddressLineLinkNotDisplayed() {
		try {
			additionalAddressLineLinkEditChangePage.click();
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	public void clickAddAdditionalAddressLineLink() {
		additionalAddressLineLinkEditChangePage.click();
	}

	public boolean validateSecondAddressTextBoxDisplayed() {
		return addressLineTwoEditChangePage.isDisplayed();
	}

	public void clickSaveAndContinueOnEditPaymentPage() {
		savePaymentEditChangePage.click();
	}

	public boolean validateSuccessMsgForCreditCardUpdated() {
		int size = cardUpdateSuccessMessage.size();
		System.out.println("Count of Card Updated Webelement :: " + size);
		String UpdateCCSuccessMsg = cardUpdateSuccessMessage.get(0).getText();
		System.out.println("Update CC Success Msg :: " + UpdateCCSuccessMsg);
		return UpdateCCSuccessMsg.trim().equalsIgnoreCase("Success! You've updated a credit card.");
	}

	public void selectAnotherCard() {
		WebElement radioButton = driver.findElement(By.xpath("//input[@value='1' and @type='radio']"));
		radioButton.click();
		WebElement select = (WebElement) new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By
				.xpath("/html/body/div[3]/div[1]/main/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/fieldset/div/label[2]/span[1]/span/span/input")));
		select.click();
	}

	public boolean validateMakePrefferedCheckboxDisplayed() {
		try {
			makePreferredCheckbox.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean validateMakePrefferedCheckboxNotSelected() {
		return !makePreferredCheckbox.isSelected();
	}

	public void clickMakeThisPrefferedCardButton() {
		makePreferredCheckbox.click();
	}

	public void clickUseThisCardButton() {
		useThisCardButtonChangePage.click();
	}

	public void clickDeleteCardButton() {
		deletePaymentChangePaymentPage.click();
	}

	public void closeDeleteCardModal() {
		crossIconButtonDeletePayment.click();
	}

	public void cancelDeleteCardModal() {
		cancelButtonDeletePayment.click();
	}

	public void confirmMsgDeletePayment() {
		confirmMsgDeletePayment.click();
	}

	public boolean validateSuccessMsgForCreditCardDeleted() {
		int size = deleteCardSuccessMessage.size();
		System.out.println("Count of Card Deleted Webelement :: " + size);
		String DeleteCCSuccessMsg = deleteCardSuccessMessage.get(0).getText();
		System.out.println("Update CC Success Msg :: " + DeleteCCSuccessMsg);
		return DeleteCCSuccessMsg.trim().equalsIgnoreCase("Success! You've updated a credit card.");
	}
	/*
	 * public boolean validateNoCreditCard() {
	 * 
	 * 
	 * }
	 */

}
