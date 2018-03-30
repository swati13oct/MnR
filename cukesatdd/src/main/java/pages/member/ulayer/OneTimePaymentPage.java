

package pages.member.ulayer;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.dashboard.eob.EOBPage;

/**
 * @author pperugu
 *
 */
public class OneTimePaymentPage extends UhcDriver{

	@FindBy(xpath = ".//*[@id='atdd_otheramount_label']/label")
	private WebElement amountRadioButton;
	
	@FindBy(id = "other-amount-number")
	private WebElement otheramountfield;
	
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
	

	
	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div/div/form/div/div/div[2]/div/table[1]/tbody/tr[1]/td[2]")			
	private WebElement amountDisplayed;
	
	@FindBy(xpath ="//*[@id='atdd_electronicsignature_label']/div/fieldset/label")
	private WebElement electrosign;
	
	@FindBy(id="review-continue")
	private WebElement continueButton;
	
	@FindBy(className="modal-body")
	private WebElement iPerceptionPopUp;
	

	
	@FindBy(id ="amountToBePaid")
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
		
		try{
			if (iPerceptionPopUp.isDisplayed()) {
				iPerceptionPopUp.click();
			}
		}catch(Exception e)        {
			System.out.println("iPerception Pop Up not displayed");
		}

		waitforElement(amountRadioButton);
		validate(amountRadioButton);
		amountRadioButton.click();
		
	
		
		
		
		
		otheramountfield.click();
		
		otheramountfield.clear();
		otheramountfield.click();
		otheramountfield.sendKeys(amount);
		
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
		
		electrosign.click();				
		continueButton.click();
		
		if(driver.getTitle().equalsIgnoreCase("Make Online Payment")){
			return new ConfirmOneTimePaymentPage(driver);
		}
		return null;
		
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
