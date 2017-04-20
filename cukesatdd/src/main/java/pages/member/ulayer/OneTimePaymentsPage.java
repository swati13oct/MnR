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
	
	@FindBy(xpath ="//*[text()='cancel ']")
	private WebElement onetimecancelbtn;
	
	@FindBy(xpath="//div[@id='atdd_electronicsignature_label']/div/fieldset/label")
	private WebElement electronicSignatureCheck;
	
	@FindBy(xpath="//*[text()='Edit Payment Information']") 
	 private WebElement editPaymentInfo; 

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

	public ReviewOneTimePaymentsPage enterInfoAndContinue() {
		otherAmountRadio.click();
		otherAmountNumber.sendKeys("56.00");
		routingNumberField.sendKeys("123123000");
		confirmRoutingNumberField.sendKeys("123123000");
		accountNumberField.sendKeys("1234");
		confirmAccountNumberField.sendKeys("1234");
		firstNameField.sendKeys("Fn");
		lastNameField.sendKeys("Ln");
		electronicSignatureCheck.click();
		reviewContinue.click();
		if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
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

}
