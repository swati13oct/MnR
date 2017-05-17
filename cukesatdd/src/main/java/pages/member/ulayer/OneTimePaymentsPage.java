/**
 * 
 */
package pages.member.ulayer;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class OneTimePaymentsPage extends UhcDriver{
	
		
	@FindBy(xpath="//div[@id='atdd_otheramount_label']/label")
	private WebElement otherAmountRadio;
	
	@FindBy(id = "other-amount-number")
	private WebElement otherAmountNumber;
	
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
	
	@FindBy(id = "last-name")
	private WebElement lastNameField;
	
	
	@FindBy(id = "review-continue")
	private WebElement reviewContinue;
	

	@FindBy(className = "error-count")
	private WebElement ErrorMessageChkbox;

	@FindBy(xpath ="//*[text()='cancel ']")
	private WebElement onetimecancelbtn;

	
	@FindBy(xpath="//div[@id='atdd_electronicsignature_label']/div/fieldset/label")
	private WebElement electronicSignatureCheck;
	
	@FindBy(xpath="//*[text()='Edit Payment Information']") 
	 private WebElement editPaymentInfo; 
	
	@FindBy(linkText="CANCEL")
	 private WebElement CancelButton;
	
	@FindBy(xpath=".//*[@id='paymentHistoryApp']/div/div/div/div/h1")
	 private WebElement PaymentHistoryText;
	
	@FindBy(name = "amount")
	private WebElement amountRadioButton;	
	
	@FindBy(id = "middle-name")
	private WebElement middleNameField;	
	
	@FindBy(id="review-continue")			
	private WebElement continueButton;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div/div/form/div/div/div[2]/div/table[1]/tbody/tr[1]/td[2]")			
	private WebElement amountDisplayed;
	
	@FindBy(xpath = "//*[@id='atdd_otheramount_label']/label")			
	private WebElement otherAmtRadioButton;
	
	@FindBy(id = "other-amount-number")
	private WebElement amountToBePaidField;

	public OneTimePaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(otherAmountRadio);
		validate(otherAmountNumber);
		validate(routingNumberField);
		validate(confirmRoutingNumberField);
		validate(accountNumberField);
		validate(confirmAccountNumberField);
		validate(firstNameField);
		validate(lastNameField);
		validate(electronicSignatureCheck);
		validate(reviewContinue);
		
	}

	public ReviewOneTimePaymentsPage enterInfoAndContinue() throws InterruptedException {
		otherAmountRadio.click();
		otherAmountNumber.sendKeys("56.00");
		routingNumberField.sendKeys("123123000");
		confirmRoutingNumberField.sendKeys("123123000");
		accountNumberField.sendKeys("1234");
		confirmAccountNumberField.sendKeys("1234");
		firstNameField.sendKeys("Test");
		lastNameField.sendKeys("MA");
		electronicSignatureCheck.click();
		reviewContinue.click();
		Thread.sleep(2000);
		if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
			return new ReviewOneTimePaymentsPage(driver);
		}
		return null;
	}
	
	public ReviewOneTimePaymentsPage enterInfoWithoutCheckBoxAndContinue() {
		otherAmountRadio.click();
		otherAmountNumber.sendKeys("56.00");
		routingNumberField.sendKeys("123123000");
		confirmRoutingNumberField.sendKeys("123123000");
		accountNumberField.sendKeys("1234");
		confirmAccountNumberField.sendKeys("1234");
		firstNameField.sendKeys("Fn");
		lastNameField.sendKeys("Ln");
		//electronicSignatureCheck.click();
		reviewContinue.click();
		if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
			return new ReviewOneTimePaymentsPage(driver);
		}
		return null;
	}
	
	public ReviewOneTimePaymentsPage errorMessagechkBox()
	{
		if(ErrorMessageChkbox.getText().contains("errors found in the form")){
			return new ReviewOneTimePaymentsPage(driver);
		}
		return null;
	}
	
	public ReviewOneTimePaymentsPage CancelButton() {
		CancelButton.click();		
		if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
			return new ReviewOneTimePaymentsPage(driver);
		}
		return null;
	}
	
	
	public ReviewOneTimePaymentsPage HistoryPageValidation(){
		if(PaymentHistoryText.getText().contains("Payment History")){
			return new ReviewOneTimePaymentsPage(driver);
		}
		return null;
	}
	
	public ReviewOneTimePaymentsPage editPaymentInfobtn(){
		editPaymentInfo.click();
		if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
			return new ReviewOneTimePaymentsPage(driver);
		}
		return null;
	}
	
	public OneTimePaymentPage onetimepagecancelbtn(){
		onetimecancelbtn.click();
		if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
			return new OneTimePaymentPage(driver);
		}
		return null;	
	
	}

	
public ReviewOneTimePaymentsPage enterAllPaymentDetails(Map<String, String> accountAttributessMap) {
		
		String amount = accountAttributessMap.get("Amount to be paid");
		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");
	
		
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
		
		electronicSignatureCheck.click();
				
		continueButton.click();
		
		if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
			return new ReviewOneTimePaymentsPage(driver);
		}
		return null;
		
	}
	
}
