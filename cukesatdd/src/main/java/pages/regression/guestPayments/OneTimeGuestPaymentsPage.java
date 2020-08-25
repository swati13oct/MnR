package pages.regression.guestPayments;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Strings;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.memberrdesignVBF.ReviewOneTimePaymentsPage;
import pages.regression.testharness.TestHarness;

/**
 * @author akapoo18
 *
 */
public class OneTimeGuestPaymentsPage extends OneTimeGuestPaymentWebElements {

	public OneTimeGuestPaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}



	public boolean guestPaymentsValidate(WebElement element) {
		long timeoutInSec=0;
		return guestPaymentsValidate(element, timeoutInSec);
	} 
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean guestPaymentsValidate(WebElement element, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	} 

	
	public void PaymentsDataVerificationonReviewPage() {
		List<WebElement> rowsList = driver.findElements(By.xpath("//div[@class='table-body-row']"));
		List<WebElement> columnsList = null;
		for (WebElement row : rowsList) {
			System.out.println();
			columnsList = row.findElements(By.tagName("div"));

			for (WebElement column : columnsList) {
				System.out.print(column.getText() + " - ");
				if ((Strings.isNullOrEmpty(column.getText()))) {
					Assert.fail("Coloumn Header or value is null");
				}
			}
		}
	}
	
	
	public ConfirmOneTimePaymentPage enterPaymentDetails(Map<String, String> accountAttributessMap) {

		String Amount = accountAttributessMap.get("Amount to be paid");
		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

		/*
		 * if(amountRadioButton.isSelected() &&
		 * amountDisplayed.getText().equalsIgnoreCase("$0.00")) { //TODO:: if
		 * first radio button is selected?? }
		 */

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		waitforElement(amountRadioButton);
		validate(amountRadioButton);
		amountRadioButton.click();

		otheramountfield.click();

		otheramountfield.clear();
		otheramountfield.sendKeys(Amount);

		routingNumberField.click();
		routingNumberField.clear();
		routingNumberField.sendKeys(routingNumber);

		confirmRoutingNumberField.click();
		confirmRoutingNumberField.clear();
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);

		accountNumberField.click();
		accountNumberField.clear();
		accountNumberField.sendKeys(accountNumber);

		confirmAccountNumberField.click();
		confirmAccountNumberField.clear();
		confirmAccountNumberField.sendKeys(confirmAccountNumber);

		firstNameField.click();
		firstNameField.clear();
		firstNameField.sendKeys(firstName);

		middleNameField.click();
		middleNameField.clear();
		middleNameField.sendKeys(middleName);

		lastNameField.click();
		lastNameField.clear();
		lastNameField.sendKeys(lastName);

		electronicsignature.click();
		continueButton.click();

		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println(e);
		}

		if (driver.getTitle().equalsIgnoreCase("Review Payment") || driver.getTitle().equalsIgnoreCase("overview")
				|| driver.getTitle().equalsIgnoreCase("AARP Medicare Plans from UnitedHealthCare - overview")
				|| driver.getTitle().equalsIgnoreCase("Review Your One-Time Payment Information")) {
			return new ConfirmOneTimePaymentPage(driver);
		}
		return null;
	}

	public ConfirmOneTimePaymentPage enterNewPagePaymentDetails(Map<String, String> accountAttributessMap) {

		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

		/*
		 * if(amountRadioButton.isSelected() &&
		 * amountDisplayed.getText().equalsIgnoreCase("$0.00")) { //TODO:: if
		 * first radio button is selected?? }
		 */

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		waitforElement(routingNumberField);

		routingNumberField.click();
		routingNumberField.clear();
		routingNumberField.sendKeys(routingNumber);

		confirmRoutingNumberField.click();
		confirmRoutingNumberField.clear();
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);

		accountNumberField.click();
		accountNumberField.clear();
		accountNumberField.sendKeys(accountNumber);

		confirmAccountNumberField.click();
		confirmAccountNumberField.clear();
		confirmAccountNumberField.sendKeys(confirmAccountNumber);

		firstNameField.click();
		firstNameField.clear();
		firstNameField.sendKeys(firstName);

		middleNameField.click();
		middleNameField.clear();
		middleNameField.sendKeys(middleName);

		lastNameField.click();
		lastNameField.clear();
		lastNameField.sendKeys(lastName);

		AuthorizeButton.click();

		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println(e);
		}

		/*
		 * if(driver.getTitle().equalsIgnoreCase("Review Payment") ||
		 * driver.getTitle().equalsIgnoreCase("overview") ||
		 * driver.getTitle().equalsIgnoreCase(
		 * "AARP Medicare Plans from UnitedHealthCare - overview") ||
		 * driver.getTitle().equalsIgnoreCase(
		 * "Review Your One-Time Payment Information") ||
		 * driver.getTitle().contains(
		 * "Review Your Automatic Payments Information for Medicare Prescription Drug Plan"
		 * )){ System.out.println("match ho gaya"); return new
		 * ConfirmOneTimePaymentPage(driver); }
		 */

		if (PageHeader.isDisplayed()) {
			return new ConfirmOneTimePaymentPage(driver);
		}

		return null;
	}

	public ConfirmOneTimePaymentPage enterNewPageCCDetails(Map<String, String> accountAttributessMap) {

		String Name = accountAttributessMap.get("Name");
		String CreditCardNumber = accountAttributessMap.get("CreditCardNumber");

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		CardHolderName.clear();
		CardHolderName.sendKeys(Name);

		CreditCardNumberField.click();
		CreditCardNumberField.clear();
		CreditCardNumberField.sendKeys(CreditCardNumber);

		Select Month = new Select(driver.findElement(By.name("month")));
		Month.selectByVisibleText("04");

		Select Year = new Select(driver.findElement(By.name("year")));
		Year.selectByVisibleText("2019");

		ProceedButton.click();

		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println(e);
		}

		return new ConfirmOneTimePaymentPage(driver);
		/*
		 * if(PageHeader.isDisplayed()) { return new
		 * ConfirmOneTimePaymentPage(driver); }
		 * 
		 * return null;
		 */
	}

	public ConfirmOneTimePaymentPage enterAutoPaymentDetails(Map<String, String> accountAttributessMap) {

		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		waitforElement(routingNumberField);

		routingNumberField.click();
		routingNumberField.clear();
		routingNumberField.sendKeys(routingNumber);

		confirmRoutingNumberField.click();
		confirmRoutingNumberField.clear();
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);

		accountNumberField.click();
		accountNumberField.clear();
		accountNumberField.sendKeys(accountNumber);

		confirmAccountNumberField.click();
		confirmAccountNumberField.clear();
		confirmAccountNumberField.sendKeys(confirmAccountNumber);

		firstNameField.click();
		firstNameField.clear();
		firstNameField.sendKeys(firstName);

		middleNameField.click();
		middleNameField.clear();
		middleNameField.sendKeys(middleName);

		lastNameField.click();
		lastNameField.clear();
		lastNameField.sendKeys(lastName);

		// electronicsignature.click();
		iHaveReadAndAgreeToTheFollowing.click();
		continueAutoPayButton.click();
		System.out.println("Continue button clicked ");

		try {
			Thread.sleep(5000);
			System.out.println("Thread Woke up");
		} catch (Exception e) {
			System.out.println("thread issue");
		}

		System.out.println(driver.getTitle());

		if ((driver.getTitle().contains("Review Your") && driver.getTitle().contains("Payments Information"))
				|| driver.getTitle().equalsIgnoreCase("overview")
				|| driver.getTitle().equalsIgnoreCase("Premium Payments")
				|| driver.getTitle().equalsIgnoreCase("AARP Medicare Plans from UnitedHealthCare - Premium Payments")) {
			System.out.println("Validated review page title");
			return new ConfirmOneTimePaymentPage(driver);
		} else {
			return null;
		}
	}

	public PaymentHistoryPage CancelPayments() {
		System.out.println("In Cancel payment method");

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println("Going to scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println("will click on cancel button");
		RecurringFormCancel.click();
		waitforElement(PaymentCancelModelPopup);
		PaymentCancelModelPopup.click();
		waitforElement(PaymentOverviewtText);
		if (PaymentOverviewtText.isDisplayed())
			return new PaymentHistoryPage(driver);
		else
			return null;

	}

	public PaymentHistoryPage CancelPaymentsOneTime() {
		System.out.println("In Cancel payment method for OneTime");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println("Going to scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println("will click on cancel button");
		RecurringFormCancel.click();
		waitforElement(PaymentCancelModelPopup);
		PaymentCancelModelPopup.click();
		waitforElement(PaymentOverviewtText);
		if (PaymentOverviewtText.isDisplayed())
			return new PaymentHistoryPage(driver);
		else
			return null;
	}

	    public void selectAndEnterAmount(String otherAmount) {
		TestHarness.checkForIPerceptionModel(driver);
		validate(otherAmountRadioButton);
		otherAmountRadioButton.click();
		otherAmountInput.clear();
		otherAmountInput.sendKeys(otherAmount);
		System.out.println("User selected Other amount option and Entered amount : " + otherAmount);
	}

	public void selectAmountDueToday() {
		validate(AmountDueTodayButton);
		AmountDueTodayButton.click();
		System.out.println("User selected Amount due today");
	}

	public void selectCreditCardOption() {
		validate(creditcardRadioButton);
		creditcardRadioButton.click();
		System.out.println("User selects Credit Card Option");

	}
	
	public void selectCheckingAccountOption() {
		validate(CheckingAccountRadioButton);
		CheckingAccountRadioButton.click();
		System.out.println("User selects Checking Account Option");

	}

	public CreditCardUPGPage clickOnNextButton() {
		validate(otheramountfield);
		NextButton.click();
		System.out.println("User Click on Next button on one time page");
		try {
			Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Payment")) {
			System.out.println("Navigated to UPG Credit card page");
			return new CreditCardUPGPage(driver);
		} else {
			System.out.println("UPG is not displayed");
			return null;
		}
	}
	
	
	public PaymentsFormPage clickOnContuineButton() {
		validate(otheramountfield);
		TestHarness.checkForIPerceptionModel(driver);
		NextButton.click();
		System.out.println("User Click on Next button on one time page");
		try {
			Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (validate(CheckingAccountInformationHeader)) {
			System.out.println("Navigated to EFT form page");
			return new PaymentsFormPage(driver);
		} else {
			System.out.println("EFT Form Page is not displayed");
			return null;
		}
	}
	
	
	public ConfirmOneTimePaymentPage selectAgreeAndClickOnSubmitPaymentsforOneTime() {
		CommonUtility.waitForPageLoad(driver, EditPaymentInformation, 10);
		TestHarness.checkForIPerceptionModel(driver);
		System.out.println("User is on Review Review Your Automatic Payments Information Page");
		PaymentsDataVerificationonReviewPage();
		jsClickNew(AgreeCheckBox);
		TestHarness.checkForIPerceptionModel(driver);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Submit button on Review Payment page");
		try {
			Thread.sleep(10000);
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current URL is  "+driver.getCurrentUrl());
			} catch (InterruptedException e) {
			System.out.println("Catch block URL is "+driver.getCurrentUrl());
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReadyNew(driver);
		String title = driver.getTitle();
		System.out.println("Current title of the page is "+title);
				
		//WARNING  Please add your condition if you have to , do not comment someone else code/////
		if ((driver.getTitle().contains("Your One-Time Payment Is Being Processed")) || (driver.getTitle().contains("Your payment has been submitted"))  )
		{
			System.out.println("Title of the page is "+title+", User is on Confirmation Page for One time payment");
			return new ConfirmOneTimePaymentPage(driver);
		} else {
			System.out.println("Confirmation Page for one time payment was not displayed");
			return null;
		}
	}
	
	public ConfirmOneTimePaymentPage selectAgreeAndClickOnContinueforEFTForShip() {
		validate(EditPaymentInformation);
		PaymentsDataVerificationonReviewPage();
		System.out.println("User is on review Payment Page");
		System.out.println("Going to scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Authorize Payments button");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}		
		CommonUtility.waitForPageLoad(driver, MakeAPaymentButton, 20);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Recurring Payments Request Submitted")) {
			System.out.println("User is on Confirmation Page for Setup Recurring for ship");
			return new ConfirmOneTimePaymentPage(driver);
		} else {
			System.out.println("Confirmation Page for setup recurring not displayed for ship");
			Assert.fail("Confirmation Page for setup recurring not displayed for ship");
			return null;
		}
	}
	
	public ConfirmOneTimePaymentPage errorForSecondPayment() {
		CommonUtility.waitForPageLoad(driver, moreThanonePaymentError, 20);
		String errorMessage= moreThanonePaymentError.getText();
		if (errorMessage.contains("Only one payment request can be submitted per business day")) 
		{
			System.out.println("Error message displayed on the page is "+errorMessage);
			System.out.println("Correct error message is displayed on the page, Test Passed");
			
		} else {
			Assert.fail();
			return null;
		}
		return new ConfirmOneTimePaymentPage(driver); 
	}

	public void validateErrorMessageUnauthorized() {
		
		System.out.println("Scrolling to Submit button to view the Error Message");
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", AuthorizeMonthlyPaymentstButton); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String errorMessage= csrUnauthorizedErrorMessage.getText();
		if (errorMessage.contains("You not authorised to submit the information and proceed to the next page")) 
		{
			System.out.println("Error message displayed on the page is "+errorMessage);
			System.out.println("Correct error message is displayed on the page, Test Passed");
			
		} else {
			Assert.fail();
		}

	}
	
	public OneTimePaymentPage BalanceSummaryValidation() {

		
		System.out.println("in new method for summary validation");
		try {
			if (NextPaymentSummary.isDisplayed() && RemainingAmountSummary.isDisplayed()) {
				System.out.println("Next Payment due is : " + NextPaymentProcess.getText());
				System.out.println("Remaining amount due is : " + RemainingAmount.getText());
				return new OneTimePaymentPage(driver);
			}
		} catch (Exception e) {
			if (NextPaymentProcess.isDisplayed() && RemainingAmountSummary.isDisplayed()) {
				System.out.println("Next Payment due is : " + NextPaymentProcess.getText());
				System.out.println("Remaining amount due is : " + RemainingAmount.getText());
				return new OneTimePaymentPage(driver);
			} else
				return null;
		}

		return null;
	}

	
	@Override
	public void openAndValidate() {
		validate(routingNumberField);
		validate(confirmRoutingNumberField);
		validate(accountNumberField);
		validate(confirmAccountNumberField);
		validate(firstNameField);
		validate(middleNameField);
		validate(lastNameField);
		validate(continueButton);
	}
	/**
	 * For iPerception Model
	 * @param driver
	 */
	public static void checkForIPerceptionModel(WebDriver driver) {
		int counter = 0;
		do {
			System.out.println("current value of counter: " + counter);
			List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

			if (IPerceptionsFrame.isEmpty()) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			} else {
				driver.switchTo().frame(IPerceptionsFrame.get(0));
				driver.findElement(By.className("btn-no")).click();
				driver.switchTo().defaultContent();
			}
			counter++;
		} while (counter < 2);
	}

	public ConfirmOneTimePaymentPage DoNotselectAgreeAndClickOnSubmitPaymentsforOneTime() {
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, EditPaymentInformation, 10);
		checkForIPerceptionModel(driver);
		System.out.println("User is on Review Review Your Automatic Payments Information Page");
		PaymentsDataVerificationonReviewPage();
		jsClickNew(AgreeCheckBox);
		checkForIPerceptionModel(driver);
		validate(AuthorizeMonthlyPaymentstButton);
		//AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Submit button on Review Payment page");
		try {
			Thread.sleep(10000);
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current URL is  "+driver.getCurrentUrl());
			} catch (InterruptedException e) {
			System.out.println("Catch block URL is "+driver.getCurrentUrl());
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReadyNew(driver);
		String title = driver.getTitle();
		System.out.println("Current title of the page is "+title);
		
		//if (driver.getTitle().contains("Your One-Time Payment Is Being Processed")) {
		if (driver.getTitle().contains("Review Payment")) {
			System.out.println("Title of the page is "+title+", User is on Confirmation Page for One time payment");
			return new ConfirmOneTimePaymentPage(driver);
		} else {
			System.out.println("Confirmation Page for one time payment was not displayed");
			return null;
		}
	}


//***********************Code For Predators start here****************
	
	public void validateHeaderAndPageElements() {

		Assert.assertTrue("PROBLEM - unable to locate the One time payments Header",guestPaymentsValidate(guestPaymentsHeader));
		Assert.assertTrue("PROBLEM - unable to locate the text below the header on One time payments Page",guestPaymentsValidate(oneTimePaymentTextBelowHeader));
		Assert.assertTrue("PROBLEM - unable to locate select a Payment Header",guestPaymentsValidate(selectAPaymentHeader));
		Assert.assertTrue("PROBLEM - unable to locate Past Amount Due Radio Button",guestPaymentsValidate(pastAmountDueRadioButton));
		Assert.assertTrue("PROBLEM - unable to locate Past Amount due value",guestPaymentsValidate(pastAmountValue));
		Assert.assertTrue("PROBLEM - unable to locate Past Amount and Current Charges Radio Button",guestPaymentsValidate(pastAmountCurrentChargesRadioButton));
		Assert.assertTrue("PROBLEM - unable to locate  Past Amount and Current Charges value",guestPaymentsValidate(pastAmountCurrentChargesValue));
		Assert.assertTrue("PROBLEM - unable to locate other Amount Radio Button",guestPaymentsValidate(otherAmountRadioButton));
		Assert.assertTrue("PROBLEM - unable to locate other Amount Text Field",guestPaymentsValidate(otherAmountTextField));
		Assert.assertTrue("PROBLEM - unable to locate choose A Payment Heading",guestPaymentsValidate(chooseAPaymentHeading));
		Assert.assertTrue("PROBLEM - unable to locate credit card Radio Button",guestPaymentsValidate(creditcardRadioButton));
		Assert.assertTrue("PROBLEM - unable to locate eft Checking Radio Button",guestPaymentsValidate(eftCheckingRadioButton));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Plan Name",guestPaymentsValidate(sideWidgetPlanName));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Member Name Label",guestPaymentsValidate(sideWidgetMemberNameLabel));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Member Name Value",guestPaymentsValidate(sideWidgetMemberNameValue));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Member ID Label",guestPaymentsValidate(sideWidgetMemberIDLabel));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Member ID Value",guestPaymentsValidate(sideWidgetMemberIDValue));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Payment Details Label",guestPaymentsValidate(sideWidgetPaymentDetailsLabel));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Payment Details Value",guestPaymentsValidate(sideWidgetPaymentDetailsValue));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Total You Pay Label",guestPaymentsValidate(sideWidgetTotalYouPayLabel));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Total You Pay Value",guestPaymentsValidate(sideWidgetTotalYouPayValue));
		
	
	}

	

	public void selectAmountDueAndCreditCard() {
		// TODO Auto-generated method stub
		
		pastAmountDueRadioButton.click();
		System.out.println(">>>>>>>>Past Amount due radio button is clicked<<<<<<<<<<<");
		
		creditcardRadioButton.click();
		System.out.println(">>>>>>>>>>>Credit Card Option is selected<<<<<<<<<<<<<<<<<<<<<<");
		
		validateTheAddCardDetailsIframeforCreditCard();
	}


	private void validateTheAddCardDetailsIframeforCreditCard() {

		Assert.assertTrue("PROBLEM - unable to locate Name On Card TextField",guestPaymentsValidate(nameOnCardTextField));
		Assert.assertTrue("PROBLEM - unable to locate Card Number Text Field",guestPaymentsValidate(cardNumberTextField));
		Assert.assertTrue("PROBLEM - unable to locate Expiration Month Dropdown",guestPaymentsValidate(expirationMonthDropdown));
		Assert.assertTrue("PROBLEM - unable to locate Expiration Year Dropdown ",guestPaymentsValidate(expirationYearDropdown));
		Assert.assertTrue("PROBLEM - unable to locate Review And Submit Button",guestPaymentsValidate(reviewAndSubmitButton));
	
	}



	public ReviewOneTimeGuestPaymentsPage enterCCDetails(Map<String, String> accountAttributessMap) {

		String Name = accountAttributessMap.get("Name");
		String CreditCardNumber = accountAttributessMap.get("CreditCardNumber");
		String ExpMonth = accountAttributessMap.get("Month");
		String ExpYr = accountAttributessMap.get("Year");
		
		System.out.println(">>>>>>>>>>>>Entering Card Holder's Name<<<<<<<<<<<<<<<<<<<");
		nameOnCardTextField.sendKeys(Name);
		
		System.out.println(">>>>>>>>>>>>Entering Credit Card Number<<<<<<<<<<<<<<<<<<<");
		cardNumberTextField.sendKeys(CreditCardNumber);
		
		System.out.println(">>>>>>>>>>>>Entering Expiration Month<<<<<<<<<<<<<<<<<<<");
		selectFromDropDownByText(driver, expirationMonthDropdown, ExpMonth);
		
		System.out.println(">>>>>>>>>>>>Entering Expiration Year<<<<<<<<<<<<<<<<<<<");
		selectFromDropDownByText(driver, expirationYearDropdown, ExpYr);
		
		reviewAndSubmitButton.click();
		System.out.println(">>>>>>>Review and Submit button is clicked<<<<<<<");
		
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, reviewAndSubmitPageHeader, 45);
		
		if (driver.getTitle().contains("Review")) {
			System.out.println(">>>>>>>>>>Review Guest Payments page is displayed<<<<<<<<<<");
			return new ReviewOneTimeGuestPaymentsPage(driver);
		} else {
			System.out.println(">>>>>>>>>Review Guest Payments page is not displayed<<<<<<<<<<");
			return null;
		}
		
	}




}