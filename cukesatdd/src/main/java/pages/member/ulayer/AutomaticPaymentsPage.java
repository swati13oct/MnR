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
	
	
	
	@FindBy(xpath="//div[@id='atdd_electronicsignature_label']/div/fieldset/label")
	private WebElement electronicSignatureCheck;
	
	public AutomaticPaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
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
		routingNumberField.sendKeys("123123000");
		confirmRoutingNumberField.sendKeys("123123000");
		accountNumberField.sendKeys("1234");
		confirmAccountNumberField.sendKeys("1234");
		firstNameField.sendKeys("Fn");
		lastNameField.sendKeys("Ln");
		electronicSignatureCheck.click();
		reviewContinue.click();
		if(driver.getTitle().equalsIgnoreCase("review-one-time-payments")){
			return new ReviewOneTimePaymentsPage(driver);
		}
		return null;
	}
	

	

}
