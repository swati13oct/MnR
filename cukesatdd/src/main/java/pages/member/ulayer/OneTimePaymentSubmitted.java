package pages.member.ulayer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author agoyal24
 */

public class OneTimePaymentSubmitted extends UhcDriver {

	@FindBy(xpath="//div[@id='atdd_reviewonetime_label']/div[3]/div[2]/span")
	private WebElement amountPayed;
	
	@FindBy(xpath="//div[@id='atdd_reviewonetime_label']/div[4]/div[2]/span")
	private WebElement routingNumber;
	
	@FindBy(xpath="//*[@id='atdd_reviewonetime_label']/div[5]/div[2]/span")
	private WebElement AccountNumber;
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div/div[1]/div/div/div[5]/div[2]/span")
	private WebElement AccountNumberPaymentSubmittedPage;
	
	@FindBy(xpath="//*[@id='atdd_reviewonetime_label']/div[6]/div[2]/span")
	private WebElement AccountHolderName;
	
	@FindBy(xpath="//*[@id='atdd_reviewonetime_label']/div[6]/div[2]/span")
	private WebElement AccountHolderNamePaymentSubmittedpage;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[3]/div/div/div/button")
	private WebElement SubmitButton;
	
	@FindBy(xpath="html/body/div[2]/div/div[2]/div/div/div[1]/div/div/div[1]/div[2]/span")
	private WebElement PaymentType;

	public OneTimePaymentSubmitted(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(amountPayed);
		validate(routingNumber);
	}
	
	
	public OneTimePaymentSubmitted validateOTPSubmittedPageValues() {			
		   if(AccountNumberPaymentSubmittedPage.getText().equalsIgnoreCase("1234567890")){
			   System.out.println("Account number value matched on Submitted Page");			   
		   }
		   else{		  
			  Assert.fail("Account number Value does not match " +AccountNumber.getText());
		   }		   
		   if(AccountHolderNamePaymentSubmittedpage.getText().equalsIgnoreCase("first second third")){
			   System.out.println("Account Holder Name value matched on Submitted Page");			   
		   }
		   else{		  
			  Assert.fail("Account Holder Name Value does not match "+AccountHolderName.getText());
		   }
		   if(PaymentType.getText().equalsIgnoreCase("EFT-Checking (One-Time)")){
			   System.out.println("Payment Type Value mtached");
		   }else{
			   Assert.fail("Payment Type not matched "+ PaymentType.getText());			  
		   }
		    return new OneTimePaymentSubmitted (driver);
		}
	
}
