/**
 * 
 */
package pages.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author tpravee2
 *
 */
public class AutomaticPaymentsPage extends UhcDriver{
	

	
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
	
	@FindBy(xpath=".//*[text()='Edit Payment Information ']") 
	private WebElement editPayment; 
	 
	@FindBy(xpath="//div[contains(./text(),'Payment')][contains(./text(),'Date')]/../div[2]/span") 
	private WebElement paymentDate; 
	 
	@FindBy(xpath="//a[contains(text(),'cancel  ')]") 
	private WebElement cancelbtn; 

	@FindBy(xpath="//*[text()='Cancel']")
	private WebElement automaticpagecancelbtn;
	
	@FindBy(xpath="//*[text()='continue']")
	private WebElement reviewContinue;	
	
	@FindBy(xpath="//label[@for='consent']")
	private WebElement electronicSignatureCheck;
	
	@FindBy(className = "error-count")
	private WebElement ErrorMessageChkbox;
	
	public AutomaticPaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(paymentDate);
		validate(routingNumberField);
		validate(confirmRoutingNumberField);
		validate(accountNumberField);
		validate(confirmAccountNumberField);
		validate(firstNameField);
		validate(lastNameField);
		validate(electronicSignatureCheck);
		validate(reviewContinue);
		
	}

	public ReviewAutomaticPaymentsPage enterInfoAndContinue() throws InterruptedException {
		Thread.sleep(2000);
		routingNumberField.sendKeys("123123000");
		confirmRoutingNumberField.sendKeys("123123000");
		accountNumberField.sendKeys("1234");
		confirmAccountNumberField.sendKeys("1234");
		firstNameField.sendKeys("Fn");
		lastNameField.sendKeys("Ln");
		Thread.sleep(2000);
		electronicSignatureCheck.click();
		Thread.sleep(2000);
		reviewContinue.click();
		if(driver.getTitle().equalsIgnoreCase("Member Claims") || driver.getTitle().equalsIgnoreCase("eftpayments")){
			return new ReviewAutomaticPaymentsPage(driver);
		}
		return null;
	}
	
	public ReviewAutomaticPaymentsPage enterInfoWithoutCheckBoxAndContinue() {
		routingNumberField.sendKeys("123123000");
		confirmRoutingNumberField.sendKeys("123123000");
		accountNumberField.sendKeys("1234");
		confirmAccountNumberField.sendKeys("1234");
		firstNameField.sendKeys("Fn");
		lastNameField.sendKeys("Ln");		
		reviewContinue.click();
		if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
			return new ReviewAutomaticPaymentsPage(driver);
		}
		return null;
	}
	
	
	public ReviewAutomaticPaymentsPage errorMessagechkBox()
	{
		if(ErrorMessageChkbox.getText().contains("errors found in the form")){
			return new ReviewAutomaticPaymentsPage(driver);
		}
		return null;
	}
	
	

	
	
	public ReviewAutomaticPaymentsPage cancelbtn(){
		cancelbtn.click();
		System.out.println("Navigated to payment history");		
		return null;
		
	}
	
	public AutomaticPaymentPage automaticpagecancelbtn(){
		automaticpagecancelbtn.click();
		if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
			return new AutomaticPaymentPage(driver);
		}
		return null;
		
	
	}
	
	public ReviewAutomaticPaymentsPage editPaymentbtn(){
		editPayment.click();
		boolean editbtn = validate(editPayment);
		System.out.println(editbtn);
		if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
			return new ReviewAutomaticPaymentsPage(driver);
		}
		return null;
		
	}
	
	
}
