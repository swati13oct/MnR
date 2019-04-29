/**
 * 
 */
package pages.member_deprecated.ulayer;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.regression.payments.OneTimePaymentPage;
import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class OneTimePaymentsPage extends UhcDriver{
	
		
	@FindBy(xpath="//*[@id='atdd_otheramount_label']")
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
	
	@FindBy(xpath = "//div[@class='longform__row']//div[@class='margin-medium']/a[2]")
	private WebElement AutoreviewContinue;

        @FindBy(className = "error-count")
        private WebElement ErrorMessageChkbox;

        @FindBy(xpath ="//*[text()='cancel ']")
        private WebElement onetimecancelbtn;

        @FindBy(xpath="//div[@id='atdd_electronicsignature_label']/div/fieldset/label")
        private WebElement electronicSignatureCheck;
        
        @FindBy(xpath="//fieldset[@class='checkbox-block margin-small']/label")
        private WebElement AutoEsignaturecheck;        
        
        @FindBy(xpath="//*[text()='Edit Payment Information']") 
         private WebElement editPaymentInfo; 
        
        @FindBy(linkText="CANCEL")
         private WebElement CancelButton;
        
        @FindBy(xpath=".//*[@id='paymentHistoryApp']/div/div/div/div/h1")
         private WebElement PaymentHistoryText;      
        
        @FindBy(id = "middle-name")
        private WebElement middleNameField;        
        
        @FindBy(id="review-continue")                        
        private WebElement continueButton;
        
        @FindBy(xpath = "//*[@id='atdd_otheramount_label']/label")                        
        private WebElement otherAmtRadioButton;
        
        @FindBy(id = "other-amount-number")
        private WebElement amountToBePaidField;

	public OneTimePaymentsPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		//openAndValidate();
	}

	@Override
	public void openAndValidate() throws InterruptedException {
		Thread.sleep(3000);
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
                Thread.sleep(6000);
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollBy(0,100)", "");
                Thread.sleep(2000);
                otherAmountRadio.click();
                Thread.sleep(2000);
                otherAmountNumber.sendKeys("56.00");
                routingNumberField.sendKeys("123123000");
                confirmRoutingNumberField.sendKeys("123123000");
                accountNumberField.sendKeys("1234");
                confirmAccountNumberField.sendKeys("1234");
                firstNameField.sendKeys("Test");
                lastNameField.sendKeys("MA");
                Thread.sleep(1000);
                electronicSignatureCheck.click();
                Thread.sleep(2000);                
                jse.executeScript("window.scrollBy(0,150)", "");
                Thread.sleep(5000);
                reviewContinue.click();
                Thread.sleep(2000);
                if(driver.getTitle().equalsIgnoreCase("overview") || driver.getTitle().equalsIgnoreCase("onetimepayments")){
                        return new ReviewOneTimePaymentsPage(driver);
                }
                return null;
        }
        
        
        
        public ReviewOneTimePaymentsPage AutoenterInfoAndContinue() throws InterruptedException {
                Thread.sleep(6000);                
                routingNumberField.sendKeys("123123000");
                confirmRoutingNumberField.sendKeys("123123000");
                accountNumberField.sendKeys("1234");
                confirmAccountNumberField.sendKeys("1234");
                firstNameField.sendKeys("Test");
                lastNameField.sendKeys("MA");
                Thread.sleep(1000);
                AutoEsignaturecheck.click();
                Thread.sleep(2000);
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollBy(0,150)", "");
                Thread.sleep(5000);
                AutoreviewContinue.click();
                Thread.sleep(2000);
                if(driver.getTitle().equalsIgnoreCase("overview") || driver.getTitle().equalsIgnoreCase("onetimepayments")){
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
                if(driver.getTitle().equalsIgnoreCase("payments-client")){
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
                if(driver.getTitle().equalsIgnoreCase("payments-client")){
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