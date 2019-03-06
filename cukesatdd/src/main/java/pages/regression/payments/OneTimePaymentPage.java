package pages.regression.payments;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import atdd.framework.UhcDriver;

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

	@FindBy(xpath = "//*[@class='btn btn--secondary cancelbutton']")
	private WebElement RecurringFormCancel;

	@FindBy(xpath = "//*[@class='modal-footer']/a[1]")
	private WebElement RecurringFormCancelPopup;

	@FindBy(xpath = "(//*[@id='paymentOverviewApp']//div[@class='container']//div[@class='col-md-12']/h2)[1]")
	private WebElement PaymentOverviewtText;

	@FindBy(xpath = "(//*[@class='margin-medium']/span)[2]/a")
	private WebElement AuthorizeButton;

	@FindBy(id = "btnSubmit")
	private WebElement ProceedButton;

	@FindBy(xpath = "//*[@id='holderName']")
	private WebElement CardHolderName;

	@FindBy(xpath = "//*[@id='accountNumber']")
	private WebElement CreditCardNumberField;

	@FindBy(xpath = "(//*[@class='modal-content']//div[@class='modal-footer'])[1]/a[1]")
	private WebElement PaymentCancelPopup;

	@FindBy(id = "form_routingNumber")
	private WebElement Error1;

	@FindBy(xpath = "//*[@id='paymentOverviewApp']//div[@class='container']//div[@class='col-md-12']/h2[1]")
	private WebElement PaymentHeading;

	@FindBy(xpath = "//*[@class='page-header']//div[@class='row']//h1")
	private WebElement PageHeader;

	public OneTimePaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
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

	public OneTimePaymentPage CancelPayments() {
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
		waitforElement(RecurringFormCancelPopup);
		RecurringFormCancelPopup.click();
		waitforElement(PaymentOverviewtText);
		if (PaymentOverviewtText.isDisplayed())
			return new OneTimePaymentPage(driver);
		else
			return null;

	}

	public OneTimePaymentPage CancelPaymentsOneTime() {
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
		waitforElement(PaymentCancelPopup);
		PaymentCancelPopup.click();
		waitforElement(PaymentHeading);
		if (PaymentHeading.getText().contains("Premium Payments Overview")) {
			System.out.println("Payment Overview page displayed");
			return new OneTimePaymentPage(driver);
		} else
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
		validate(otherAmountRadioButton);
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

	@Override
	public void openAndValidate() {

		validate(otheramountfield);
		validate(amountToBePaidField);
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