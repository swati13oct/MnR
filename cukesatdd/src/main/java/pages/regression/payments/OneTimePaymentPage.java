package pages.regression.payments;

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
	
	@FindBy(id="review-continue")
	private WebElement continueButton;
	
	@FindBy(className="modal-body")
	private WebElement iPerceptionPopUp;
	
	@FindBy(id ="amountToBePaid")
	private WebElement amountToBePaidField;
	
	@FindBy(xpath="//*[@id='IPEinvL']/map/area[3]")
	private WebElement iPerceptionAutoPopUp;
	
	@FindBy(xpath ="//*[@id='consent']/following-sibling::label[contains(text(),'I have read and agree to the following')]")
	private WebElement electronicsignature;
	
	@FindBy(xpath="//*[@class='overview parsys']//div[@class='row'][3]//div[@class='longform__row'][10]//div[@class='margin-medium']/a[2]")
	private WebElement continueAutoPayButton;



	
	public OneTimePaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	public ConfirmOneTimePaymentPage enterPaymentDetails(Map<String, String> accountAttributessMap) {
		
		accountAttributessMap.get("Amount to be paid");		
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
		otheramountfield.sendKeys("1.12");
		
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
		
		if(driver.getTitle().equalsIgnoreCase("overview") || driver.getTitle().equalsIgnoreCase("AARP Medicare Plans from UnitedHealthCare - overview")){
			return new ConfirmOneTimePaymentPage(driver);
		}
		return null;		
	}	
	
	public ConfirmOneTimePaymentPage enterAutoPaymentDetails(Map<String, String> accountAttributessMap) {
		  
	    String routingNumber = accountAttributessMap.get("Routing number");
	    String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
	    String accountNumber = accountAttributessMap.get("Account number");
	    String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
	    String firstName = accountAttributessMap.get("Account holder first name");
	    String middleName = accountAttributessMap.get("Account holder middle name");
	    String lastName = accountAttributessMap.get("Account holder last name");   
	    
		try{
			Thread.sleep(5000);
			if (iPerceptionPopUp.isDisplayed()) {
				iPerceptionPopUp.click();
			}
		}catch(Exception e)        {
			System.out.println("iPerception Pop Up not displayed");
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
	    
	    electronicsignature.click();	                    
	    continueAutoPayButton.click();
	    System.out.println("Continue button clicked ");
	    
	    try{
			Thread.sleep(5000);
			System.out.println("Thread Woke up");
	    }catch(Exception e)
	    {
	    	System.out.println("thread issue");
	    }
	    
	     System.out.println(driver.getTitle());
	     
	    if(driver.getTitle().equalsIgnoreCase("overview") || driver.getTitle().equalsIgnoreCase("AARP Medicare Plans from UnitedHealthCare - overview")){
	    	System.out.println("Validated review page title");
	            return new ConfirmOneTimePaymentPage(driver);
	    }
	    else{
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
