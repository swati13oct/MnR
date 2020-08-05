package pages.regression.payments;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
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
	
	@FindBy(xpath = "//button[@class='btn btn--secondary cancelbutton cancel-wcag']")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//a[@class='btn btn--primary cancel-btn-modal']")
	private WebElement cancelButtonOnModal;
	
	@FindBy(id = "routingNumErr")
	private WebElement Error1;
	
	@FindBy(id = "confirmRoutingNumErr")
	private WebElement Error2;
	
	@FindBy(id = "accountNumErr")
	private WebElement Error3;
	
	@FindBy(id = "confirmAccNumErr")
	private WebElement Error4;
	
	@FindBy(id = "firstNameErr")
	private WebElement Error5;
	
	@FindBy(id = "lastNameErr")
	private WebElement Error6;
	

	public PaymentsFormPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ReviewAutomaticPage EnterFiledsOnEFTforSetup(Map<String, String> accountAttributessMap) throws Exception {
checkForIPerceptionModel(driver);
		CommonUtility.checkPageIsReadyNew(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		
		//WARNING  Please add your condition if you have to , do not comment someone else code/////
		if ((driver.getTitle().contains("Review Your Recurring Payments Information")) || (driver.getCurrentUrl().contains("payments/onetime"))) 
		{
			System.out.println("User is on Review Your Recurring Payments Information Page");
			return new OneTimePaymentPage(driver);
		} 
		else {
			System.out.println("Review Your Recurring Payments Information not displayed");
			return null;
		}
	}

	@Override
	public void openAndValidate() {
		validate(routingNumberField);

	}

	public PaymentHistoryPage clickonCancelButton() {
		checkForIPerceptionModel(driver);
		CommonUtility.checkPageIsReadyNew(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.waitForPageLoad(driver, cancelButton, 20);
		System.out.println("Clicking on cancel button of Update Checking Account or One Time Payment EFT form");
		System.out.println("Scrolling to Cancel Button");
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", cancelButton);
		jse2.executeScript("window.scrollBy(0,-50)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cancelButton.click();
		CommonUtility.waitForPageLoad(driver, cancelButtonOnModal, 20);
		System.out.println("Clicking on cancel button of modal  - Update Checking Account EFT form or One Time Payment EFT form");
		cancelButtonOnModal.click();
		CommonUtility.checkPageIsReadyNew(driver);
		try {
			System.out.println("Waiting for 10 seconds to go back to Payment Overview page");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if ((driver.getCurrentUrl().contains("payments/overview.html")) || (driver.getCurrentUrl().contains("payments/overview-new.html")))
				{
			System.out.println("User is on Payment Overview Page after clicking cancel");
			return new PaymentHistoryPage(driver);
				}
		else {
			System.out.println("Payment Overview Page was not displayed on clicking cancel");
			Assert.fail("Payment Overview Page was not displayed on clicking cancel");
		}
		return null;
	}
	
	public PaymentsFormPage ErrorMessageValidation() {

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		
		System.out.println("Scrolling to Continue Button");
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", ContinueButton); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Clicking on  on Continue button");
		ContinueButton.click();
		System.out.println("Scrolling to top of page for error messages");
		JavascriptExecutor jse3 = (JavascriptExecutor)driver;
		jse3.executeScript("arguments[0].scrollIntoView()", Error1); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Text on Error1 is "+Error1.getText());
		System.out.println("Text on Error2 is "+Error2.getText());
		System.out.println("Text on Error3 is "+Error3.getText());
		System.out.println("Text on Error4 is "+Error4.getText());
		System.out.println("Text on Error5 is "+Error5.getText());
		System.out.println("Text on Error6 is "+Error6.getText());
		
		if ((Error1.getText().contains("Your routing number is either missing or was entered incorrectly. Please review and re-enter your Routing number."))			
	         && (Error2.getText().contains("The information in the Confirm routing number field is either missing or was entered incorrectly. Please review and re-enter your Routing number."))
	         && (Error3.getText().contains("Your account number is either missing or was entered incorrectly. Please review and re-enter your account number."))
	         && (Error4.getText().contains("The information in the Confirm account number field is either missing or was entered incorrectly. Please review and re-enter your account number."))	
	         && (Error5.getText().contains("The account holder's first name is either missing or was entered incorrectly. Please review and re-enter your first name."))
	         && (Error6.getText().contains("The account holder's last name is either missing or was entered incorrectly. Please review and re-enter your last name."))
				)
		{
			System.out.println("The error messages were correct , test case is passed");
			return new PaymentsFormPage(driver);
		}
		else
		{
			Assert.fail("The error messages were not correct , test case failed");
			return null;
		}
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
	public PaymentHistoryPage clickonCancelButton1() {	
		checkForIPerceptionModel(driver);
		CommonUtility.checkPageIsReadyNew(driver);
		validate(cancelButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cancelButton.click();
		CommonUtility.waitForPageLoad(driver, cancelButtonOnModal, 20);
		System.out.println("Clicking on cancel button of modal  - Update Checking Account EFT form or One Time Payment EFT form");
		cancelButtonOnModal.click();
		CommonUtility.checkPageIsReadyNew(driver);
		try {
			System.out.println("Waiting for 10 seconds to go back to Payment Overview page");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (driver.getCurrentUrl().contains("payments/overview"))
				{
			System.out.println("User is on Payment Overview Page after clicking cancel");
			return new PaymentHistoryPage(driver);
				}
		else {
			System.out.println("Payment Overview Page was not displayed on clicking cancel");
			Assert.fail("Payment Overview Page was not displayed on clicking cancel");
		}
		return null;
	}
	
}