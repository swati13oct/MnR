package pages.member.bluelayer;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class SetupAutoPaymentPage extends UhcDriver {

	@FindBy(name = "routingNumber")
	private WebElement routingNumberField;

	@FindBy(name = "confirmRoutingNumber")
	private WebElement confirmRoutingNumberField;

	@FindBy(name = "accountNumber")
	private WebElement accountNumberField;

	@FindBy(name = "confirmAccountNumber")
	private WebElement confirmAccountNumberField;

	@FindBy(name = "firstName")
	private WebElement firstNameField;

	@FindBy(name = "middleName")
	private WebElement middleNameField;

	@FindBy(name = "lastName")
	private WebElement lastNameField;

	@FindBy(xpath = "//a[@class='iso_footerBTNGreyNew']")
	private WebElement continueButton;

	public SetupAutoPaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ConfirmSetupAutoPaymentPage enterPaymentDetails(
			Map<String, String> accountAttributessMap) {

		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap
				.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap
				.get("Confirm account number");
		String firstName = accountAttributessMap
				.get("Account holder first name");
		String middleName = accountAttributessMap
				.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");
		sendkeys(routingNumberField, routingNumber);
		sendkeys(confirmRoutingNumberField, confirmRoutingNumber);
		sendkeys(accountNumberField, accountNumber);
		sendkeys(confirmAccountNumberField, confirmAccountNumber);
		sendkeys(firstNameField, firstName);
		sendkeys(middleNameField, middleName);
		sendkeys(lastNameField, lastName);
		continueButton.click();

		if (this.driver.getTitle().equalsIgnoreCase("Recurring Payment")) {
			return new ConfirmSetupAutoPaymentPage(driver);
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

}
