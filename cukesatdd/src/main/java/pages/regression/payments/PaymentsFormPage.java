package pages.regression.payments;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class PaymentsFormPage extends UhcDriver {

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

	public PaymentsFormPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ReviewAutomaticPage EnterFiledsOnCC(Map<String, String> accountAttributessMap) {

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
		AuthorizeButton.click();
		System.out.println("Clicked on Authorize button");
		if (ReviewPageHeading.getText().contains("Review Your Automatic Payments Information")) {
			System.out.println("User is on Review Your Automatic Payments Information Page");
			return new ReviewAutomaticPage(driver);
		} else {
			System.out.println("Review Your Automatic Payments Information not displayed");
			return null;
		}
	}

	@Override
	public void openAndValidate() {
		validate(CheckingAccountInformationHeader);

	}

}
