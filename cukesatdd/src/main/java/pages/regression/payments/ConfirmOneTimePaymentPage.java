package pages.regression.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ConfirmOneTimePaymentPage extends UhcDriver{
	
	@FindBy(id = "termError")
	private WebElement TermsCheckRadioButton;	
	
	@FindBy(xpath = "(.//*[@class='btn btn--primary'])[2]")
	private WebElement SubmitPaymentButton;
	
	@FindBy(xpath = "(.//*[@class='btn btn--primary disabled']")
	private WebElement MemAuthSubmitPaymentButton;
	
	@FindBy(xpath = "//*[@class='message-block-header']/span")
	private WebElement SuccessPay;
	
	@FindBy(xpath ="//*[@class='parsys overview']//div[@class='row'][1]//div[@ng-if='models.submitAutomaticFailure']/p[2]")
	private WebElement OneTimePaymentError;

	@FindBy(xpath = "//*[@class='container--base']/div[@class='container']//button[@ng-click='backToPaymentHistoryPage()']")
	private WebElement BackToPaymentHistoryPage;
	
	@FindBy(xpath="//*[@id='nav']/button[2]")
	private WebElement iPerceptionAutoPopUp;
	
	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

	public ConfirmOneTimePaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	public OneTimePaymentSuccessPage confirmsPayment() {
		
		try {   
	    	  Thread.sleep(2000); 		
	    		driver.switchTo().frame("IPerceptionsEmbed");
	    		System.out.println("iPerception Pop Up is Present");
	    		iPerceptionCloseButton.click();
	    		driver.switchTo().defaultContent();
	    		Thread.sleep(5000);
	    		}
	    		catch (Exception e) {
	    		System.out.println("iPerception Pop Up is not Present");
	    		}
		
		TermsCheckRadioButton.click();
		System.out.println("Terms and conditions radio button clicked");
		if(SubmitPaymentButton.isEnabled())
			SubmitPaymentButton.click();
		     System.out.println("Submit Payment Button clicked");
		CommonUtility.checkPageIsReady(driver);
		if(driver.getTitle().equalsIgnoreCase("overview")){
			System.out.println("Title matched");
			OneTimePaymentSuccessPage oneTimePaymentSuccessAarpPage = new OneTimePaymentSuccessPage(driver);
			if(!(oneTimePaymentSuccessAarpPage.getContent().contains("Only one payment request can be submitted per business day"))  && !(oneTimePaymentSuccessAarpPage.getContent().contains("Due to a system error, your request cannot be processed at this time")))
			{
				return oneTimePaymentSuccessAarpPage;
			}
			else
			{
				System.out.println("ERROR in Confirming Payments");
			}
		}
		return null;		
	}

	
    public ConfirmOneTimePaymentPage confirmsAutoPayment() throws InterruptedException  {
    	
    	System.out.println("In Confirm auto pay method");
    	Thread.sleep(2000);    	
    	
    	try {   
      	  Thread.sleep(2000); 		
      		driver.switchTo().frame("IPerceptionsEmbed");
      		System.out.println("iPerception Pop Up is Present");
      		iPerceptionCloseButton.click();
      		driver.switchTo().defaultContent();
      		Thread.sleep(5000);
      		}
      		catch (Exception e) {
      		System.out.println("iPerception Pop Up is not Present");
      		}
    	 
		waitforElement(TermsCheckRadioButton);
		TermsCheckRadioButton.click();
		System.out.println("Terms and conditions radio button clicked");
		Thread.sleep(2000);
		if(SubmitPaymentButton.isEnabled())
			SubmitPaymentButton.click();
		     System.out.println("Submit Payment Button clicked");
		     Thread.sleep(2000);
		CommonUtility.checkPageIsReady(driver);
		Thread.sleep(5000);
		if(driver.getTitle().equalsIgnoreCase("overview") || driver.getTitle().equalsIgnoreCase("AARP Medicare Plans from UnitedHealthCare - overview")){
			System.out.println("Title matched");
			Thread.sleep(8000);
		}			
		try{
			if(SuccessPay.getText().contains("Thank you for your payment"))
			{
				System.out.println("Payment Success Page Reached");
				return new ConfirmOneTimePaymentPage(driver);			
			}
			else if(OneTimePaymentError.getText().contains("only one payment request can be submitted per business day"))
			{
				System.out.println("Payment error message dispayed");
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Payment success page not displayed");
		}	
		
		return new ConfirmOneTimePaymentPage(driver);
		
	}
    
    public ConfirmOneTimePaymentPage MemAuthConfirmOTP() throws InterruptedException  {
		
    	try {   
      	  Thread.sleep(2000); 		
      		driver.switchTo().frame("IPerceptionsEmbed");
      		System.out.println("iPerception Pop Up is Present");
      		iPerceptionCloseButton.click();
      		driver.switchTo().defaultContent();
      		Thread.sleep(5000);
      		}
      		catch (Exception e) {
      		System.out.println("iPerception Pop Up is not Present");
      		}
    	
 		waitforElement(TermsCheckRadioButton);
 		TermsCheckRadioButton.click();
 		System.out.println("Terms and conditions radio button clicked");
 		if(!(MemAuthSubmitPaymentButton.isEnabled())) 	
 		{
 		     System.out.println("Submit Payment Button disabled");
 		return new ConfirmOneTimePaymentPage(driver);
 		}else
 			return null;
 		     
    }
    
    
    
    public PaymentHistoryPage ScrollDownToBackButton()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)", "");
		
		if(BackToPaymentHistoryPage.isDisplayed())
		{
			BackToPaymentHistoryPage.click();
			return new PaymentHistoryPage(driver);
		}
		else
			return null;
	}
    
     public ConfirmOneTimePaymentPage ValidateAutoPaymentButton() throws InterruptedException  {
    	 
    	 try {   
       	  Thread.sleep(2000); 		
       		driver.switchTo().frame("IPerceptionsEmbed");
       		System.out.println("iPerception Pop Up is Present");
       		iPerceptionCloseButton.click();
       		driver.switchTo().defaultContent();
       		Thread.sleep(5000);
       		}
       		catch (Exception e) {
       		System.out.println("iPerception Pop Up is not Present");
       		}
		
		waitforElement(TermsCheckRadioButton);
		TermsCheckRadioButton.click();
		System.out.println("Terms and conditions radio button clicked");
		try{
		if(!(SubmitPaymentButton.isEnabled()))	{	
		     System.out.println("Submit Payment Button is dsabled as expected");
		     return new ConfirmOneTimePaymentPage(driver);
		}
		else
		  return null;
		}catch(Exception e)
		{
			System.out.println("Submit Payment button not loaded");
			return null;
		}
		     
     }


	@Override
	public void openAndValidate() {
		
		validate(TermsCheckRadioButton);
		
	}


}
