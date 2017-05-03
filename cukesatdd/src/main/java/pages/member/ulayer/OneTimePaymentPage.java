package pages.member.ulayer;

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
public class OneTimePaymentPage extends UhcDriver{

	@FindBy(name = "amount")
	private WebElement amountRadioButton;
	
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
	
	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div/div/form/div/div/div[2]/div/table[1]/tbody/tr[1]/td[2]")			
	private WebElement amountDisplayed;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div/div/form/div/div/div[2]/div/table[1]/tbody/tr[2]/td[1]/input")			
	private WebElement otherAmtRadioButton;
	
	@FindBy(id = "amountToBePaid")
	private WebElement amountToBePaidField;
	
	public OneTimePaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	public ConfirmOneTimePaymentPage enterPaymentDetails(Map<String, String> accountAttributessMap) {
		
		String amount = accountAttributessMap.get("Amount to be paid");
		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");
		
		/*if(amountRadioButton.isSelected() && amountDisplayed.getText().equalsIgnoreCase("$0.00"))
		{
			//TODO:: if first radio button is selected??
		}*/
		
		otherAmtRadioButton.click();
		
		amountToBePaidField.clear();
		amountToBePaidField.click();
		amountToBePaidField.sendKeys(amount);
		
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
		
		if(driver.getTitle().equalsIgnoreCase("Make Online Payment")){
			return new ConfirmOneTimePaymentPage(driver);
		}
		return null;
		
	}




	
	
	
	
	@Override
	public void openAndValidate() {
		
		validate(otherAmtRadioButton);
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
