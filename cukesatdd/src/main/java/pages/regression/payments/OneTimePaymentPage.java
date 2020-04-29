package pages.regression.payments;

import java.util.List;
import java.util.Map;

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
import pages.regression.testharness.TestHarness;

/**
 * @author pperugu
 *
 */
public class OneTimePaymentPage extends UhcDriver {

	@FindBy(xpath = ".//*[@id='atdd_otheramount_label']/label")
	private WebElement amountRadioButton;

	@FindBy(xpath = "//input[@id='amountInput']")
	private WebElement otheramountfield;

	@FindBy(id = "otherAmount")
	private WebElement otherAmountRadioButton;

	@FindBy(id = "optionsRadios1")
	private WebElement AmountDueTodayButton;
	
	@FindBy(xpath = "//label[@for='optionsRadios10']//input")
	private WebElement CheckingAccountRadioButton;

	@FindBy(xpath = "//label[@for='optionsRadios20']//input")
	private WebElement creditcardRadioButton;

	@FindBy(xpath = "//*[@class='payment-selection__actions']/button")
	private WebElement NextButton;

	@FindBy(id = "div_cardInfo")
	private WebElement EnterCreditInfo;

	@FindBy(id = "amountInput")
	private WebElement otherAmountInput;

	@FindBy(id = "routing-number")
	private WebElement routingNumberField;

	@FindBy(id = "confirm-routing-number")
	private WebElement confirmRoutingNumberField;

	@FindBy(id = "account-number")
	private WebElement accountNumberField;

	@FindBy(id = "confirm-account-number")
	private WebElement confirmAccountNumberField;

	@FindBy(id = "first-name")
	private WebElement firstNameField;

	@FindBy(id = "middle-name")
	private WebElement middleNameField;

	@FindBy(id = "last-name")
	private WebElement lastNameField;

	@FindBy(id = "review-continue")
	private WebElement continueButton;

	@FindBy(className = "modal-body")
	private WebElement iPerceptionPopUp;

	@FindBy(id = "amountToBePaid")
	private WebElement amountToBePaidField;

	@FindBy(xpath = "//*[@id='IPEinvL']/map/area[3]")
	private WebElement iPerceptionAutoPopUp;

	@FindBy(xpath = "//*[@id='consent']/following-sibling::label[contains(text(),'I have read and agree to the following')]")
	private WebElement iHaveReadAndAgreeToTheFollowing;

	// @FindBy(xpath
	// ="//*[@id='consent']/following-sibling::label[contains(text(),'I have
	// read and agree to the following')]")
	@FindBy(xpath = "//*[@id='consent']/following-sibling::label[contains(text(),'Electronic Signature Consent')]")
	private WebElement electronicsignature;

	@FindBy(xpath = "//*[@class='overview parsys']//div[@class='row'][3]//div[@class='longform__row'][10]//div[@class='margin-medium']/a[2]")
	private WebElement continueAutoPayButton;

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

	@FindBy(xpath = "//*[@class='btn btn--secondary cancelbutton cancel-wcag']")
	private WebElement RecurringFormCancel;

	@FindBy(xpath = "//*[@id='paymentOverviewApp']//h2[contains(text(), normalize-space('Premium Payments Overview'))]")
	private WebElement PaymentOverviewtText;

	@FindBy(xpath = "//*[@class='margin-medium']//span//button")
	private WebElement AuthorizeButton;

	@FindBy(id = "btnSubmit")
	private WebElement ProceedButton;

	@FindBy(xpath = "//*[@id='holderName']")
	private WebElement CardHolderName;

	@FindBy(xpath = "//*[@id='accountNumber']")
	private WebElement CreditCardNumberField;

	@FindBy(xpath = "//a[@class='btn btn--primary cancel-btn-modal']")
	private WebElement PaymentCancelModelPopup;

	@FindBy(id = "form_routingNumber")
	private WebElement Error1;

	@FindBy(xpath = "//*[@id='paymentOverviewApp']//div[@class='container']//div[@class='col-md-12']/h2[1]")
	private WebElement PaymentHeading;

	@FindBy(xpath = "//*[@class='page-header']//div[@class='row']//h1")
	private WebElement PageHeader;

	@FindBy(xpath = "//h2[text()='Checking Account Information']")
	private WebElement CheckingAccountInformationHeader;
	
	@FindBy(xpath = "//button[text()='Edit Payment Information']")
	private WebElement EditPaymentInformation;
	
	@FindBy(xpath = "//button[@class='btn btn--primary']")
	private WebElement AuthorizeMonthlyPaymentstButton;
	
	@FindBy(id = "termsAgree")
	private WebElement AgreeCheckBox;
	
	@FindBy(xpath = "/html/body/div[2]/div/main/div[2]/div[3]/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[3]/div/p")
	private WebElement moreThanonePaymentError;
	
	@FindBy(id = "memAuthPaymentSubmitError")
	private WebElement csrUnauthorizedErrorMessage;
	
	
	public OneTimePaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//openAndValidate();
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

	public OneTimePaymentPage ErrorMessageValidation() {

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
		System.out.println("will click on Authorize button");
		AuthorizeButton.click();
		try {
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,650)", "");
		} catch (Exception e) {
		}
		AuthorizeButton.click();
		try {
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,650)", "");
		} catch (Exception e) {
		}
		AuthorizeButton.click();
		if (Error1.getText().contains("Please enter a valid Routing Number"))
			return new OneTimePaymentPage(driver);
		else
			return null;

	}

	public void selectAndEnterAmount(String otherAmount) {
		TestHarness.checkForIPerceptionModel(driver);
		validate(otherAmountRadioButton);
		TestHarness.checkForIPerceptionModel(driver);
		otherAmountRadioButton.click();
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
		TestHarness.checkForIPerceptionModel(driver);
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
		TestHarness.checkForIPerceptionModel(driver);
		validate(EditPaymentInformation);
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
		System.out.println("Title of the page is "+title);
		
		if (driver.getTitle().contains("Your One-Time Payment Is Being Processed")) {
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
		System.out.println("Clicked on Contuine button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Recurring Payments Request Submitted")) {
			System.out.println("User is on Confirmation Page for Setup Recurring for ship");
			return new ConfirmOneTimePaymentPage(driver);
		} else {
			System.out.println("Confirmation Page for setup recurring not displayed for ship");
			return null;
		}
	}
	
	public void errorForSecondPayment() {
		String errorMessage= moreThanonePaymentError.getText();
		if (errorMessage.contains("Only one payment request can be submitted per business day")) 
		{
			System.out.println("Error message displayed on the page is "+errorMessage);
			System.out.println("Correct error message is displayed on the page, Test Passed");
			
		} else {
			Assert.fail();
		}

	}

	public void validateErrorMessageUnauthorized() {
		String errorMessage= csrUnauthorizedErrorMessage.getText();
		if (errorMessage.contains("You not authorised to submit the information and proceed to the next page")) 
		{
			System.out.println("Error message displayed on the page is "+errorMessage);
			System.out.println("Correct error message is displayed on the page, Test Passed");
			
		} else {
			Assert.fail();
		}

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
}