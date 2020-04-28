package pages.regression.payments;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.regression.testharness.TestHarness;

public class PaymentsFormPage extends UhcDriver {

	@FindBy(xpath = "//*[text()='Checking Account Information']")
	private WebElement CheckingAccountInformationHeader;

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

	@FindBy(xpath = "//button[text()='Authorize']")
	private WebElement AuthorizeButton;

	@FindBy(xpath = "//div[@class='col-md-12']//h1")
	private WebElement ReviewPageHeading;

	@FindBy(xpath = "//*[@id='consent']/following-sibling::label")
	private WebElement ElectronicSignatureInput;

	@FindBy(xpath = "//button[@class='btn btn--primary']")
	private WebElement ContinueButton;

	public PaymentsFormPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ReviewAutomaticPage EnterFiledsOnEFTforSetup(Map<String, String> accountAttributessMap) throws Exception {

		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

		
		routingNumberField.sendKeys(routingNumber);
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);
		accountNumberField.sendKeys(accountNumber);
		confirmAccountNumberField.sendKeys(confirmAccountNumber);
		firstNameField.sendKeys(firstName);
		middleNameField.sendKeys(middleName);
		lastNameField.sendKeys(lastName);
		ContinueButton.click();
		System.out.println("Clicked on Contuine button");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Review Your Automatic Payments Information")) {
			System.out.println("User is on Review Your Automatic Payments Information Page");
			return new ReviewAutomaticPage(driver);
		} else {
			System.out.println("Review Your Automatic Payments Information Page not displayed");
			return null;
		}
	}

	public UpdateReviewPage EnterFiledsOnEFTforUpdate(Map<String, String> accountAttributessMap) {

		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

		routingNumberField.sendKeys(routingNumber);
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);
		accountNumberField.sendKeys(accountNumber);
		confirmAccountNumberField.sendKeys(confirmAccountNumber);
		firstNameField.sendKeys(firstName);
		middleNameField.sendKeys(middleName);
		lastNameField.sendKeys(lastName);
		ContinueButton.click();
		System.out.println("Clicked on Contuine button");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Review Your Automatic Payments Update")) {
			System.out.println("User is on Review Your Automatic Payments Update Page");
			return new UpdateReviewPage(driver);
		} else {
			System.out.println("Review Your Automatic Payments Update Page not displayed");
			return null;
		}
	}

	public UpdateReviewPage EnterFiledsOnEFTforUpdateForShip(Map<String, String> accountAttributessMap) {

		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

		routingNumberField.sendKeys(routingNumber);
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);
		accountNumberField.sendKeys(accountNumber);
		confirmAccountNumberField.sendKeys(confirmAccountNumber);
		firstNameField.sendKeys(firstName);
		middleNameField.sendKeys(middleName);
		lastNameField.sendKeys(lastName);
		ElectronicSignatureInput.click();
		ContinueButton.click();
		System.out.println("Clicked on Authorize button");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Review Your Recurring Payments Update")) {
			System.out.println("User is on Review Your Recurring Payments Page");
			return new UpdateReviewPage(driver);
		} else {
			System.out.println("Review Your Recurring Payments not displayed");
			return null;
		}
	}
	
	public OneTimePaymentPage EnterFiledsOnMakeOneTime(Map<String, String> accountAttributessMap) throws Exception {

		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");
		TestHarness.checkForIPerceptionModel(driver);
		routingNumberField.sendKeys(routingNumber);
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);
		accountNumberField.sendKeys(accountNumber);
		confirmAccountNumberField.sendKeys(confirmAccountNumber);
		firstNameField.sendKeys(firstName);
		middleNameField.sendKeys(middleName);
		lastNameField.sendKeys(lastName);
		TestHarness.checkForIPerceptionModel(driver);
		ContinueButton.click();
		System.out.println("Clicked on Contuine button");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Review Payment")) {
			System.out.println("User is on Review Payment Page");
			return new OneTimePaymentPage(driver);
		} else {
			System.out.println("Review Payment Page was not displayed");
			return null;
		}
	}
	
	public OneTimePaymentPage EnterFiledsOnSetupEFTforShip(Map<String, String> accountAttributessMap) throws Exception {

		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

		routingNumberField.sendKeys(routingNumber);
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);
		accountNumberField.sendKeys(accountNumber);
		confirmAccountNumberField.sendKeys(confirmAccountNumber);
		firstNameField.sendKeys(firstName);
		middleNameField.sendKeys(middleName);
		lastNameField.sendKeys(lastName);
		jsClickNew(ElectronicSignatureInput);
		ContinueButton.click();
		System.out.println("Clicked on Contuine button");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Review Your Recurring Payments Information")) {
			System.out.println("User is on Review Your Recurring Payments Information Page");
			return new OneTimePaymentPage(driver);
		} else {
			System.out.println("Review Your Recurring Payments Information not displayed");
			return null;
		}
	}

	@Override
	public void openAndValidate() {
		validate(routingNumberField);

	}

}