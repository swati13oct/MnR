package pages.member_deprecated.ulayer;

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
public class SetupAutoPaymentPage extends UhcDriver{
	
	
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
	
	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div/div/form/div/div/div[2]/div/div[3]/a")			
	private WebElement continueButton;

	public SetupAutoPaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	public ConfirmSetupAutoPaymentPage enterPaymentDetails(Map<String, String> accountAttributessMap) {
		
		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

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
				
		continueButton.click();
		
		if(driver.getTitle().equalsIgnoreCase("Recurring Payment")){
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
