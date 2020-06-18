package pages.memberrdesignVBF;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class PaymentFormPage extends UhcDriver {

	@FindBy(xpath = "//p[text()='Checking Account Information']")
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

	public PaymentFormPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//button[text()='Edit Payment Information']")
	private WebElement EditPayment;
	
	public ReviewCAOneTimePaymentsPage EnterFiledsOnMakeOneTime(Map<String, String> accountAttributessMap) throws Exception {

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
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, EditPayment, 45);
		if (driver.getTitle().contains("Review Your One-Time Payment Information")) {
			System.out.println("User is on Review Your One-Time Payment Information Page");
			return new ReviewCAOneTimePaymentsPage(driver);
		} else {
			System.out.println("Review Your One-Time Payment Information not displayed");
			return null;
		}
	}
	
	
	
	@FindBy(xpath = "//*[@id='consent']")
	private WebElement readAndAgree;
	
	public ReviewCAOneTimePaymentsPage EnterFiledsOnMakeOneTimeSHIP(Map<String, String> accountAttributessMap) throws Exception {

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
		jsClickNew(readAndAgree);		
		System.out.println("Clicked on Consent Checkbox");
		ContinueButton.click();
		System.out.println("Clicked on Contuine button");
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, EditPayment, 45);
		if (driver.getTitle().contains("Review Your One-Time Payment Information")) {
			System.out.println("User is on Review Your One-Time Payment Information Page");
			return new ReviewCAOneTimePaymentsPage(driver);
		} else {
			System.out.println("Review Your One-Time Payment Information not displayed");
			return null;
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
		validate(ContinueButton);

	}

}