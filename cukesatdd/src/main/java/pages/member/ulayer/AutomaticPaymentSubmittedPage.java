package pages.member.ulayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class AutomaticPaymentSubmittedPage extends UhcDriver{
	
	@FindBy(xpath="//button[contains(text(), 'View As PDF')]")
	private WebElement ViewPDFLink;
	
	/*@FindBy(xpath=".//*[contains(text(),'Payment Type')]/following-sibling::div/span")
	private WebElement PaymentType;
	*/
	
	@FindBy(xpath=".//*[@id='generatePdf']/div[1]/div/div/div/div[2]/div[1]/div[2]/span[1]")
	private WebElement PaymentType;
	
	@FindBy(xpath=".//*[contains(text(),'Payment Date')]/following-sibling::div/span")
	private WebElement TimeStamp;
	
	@FindBy(xpath=".//*[contains(text(),'Payment Amount')]/following-sibling::div/span")
	private WebElement PaymentAmount;
	
	
	public AutomaticPaymentSubmittedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);		
		openAndValidate();
	}	

	@Override
	public void openAndValidate() {
		validate(ViewPDFLink);	
	}

	public AutomaticPaymentSubmittedPage ValidatePDFLink()
	{
		if(ViewPDFLink.isEnabled()){
			ViewPDFLink.click();
			return new AutomaticPaymentSubmittedPage(driver);
		}
		return null;
	}
	
	public AutomaticPaymentSubmittedPage ValidatePaymentType()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(PaymentType.getText().equalsIgnoreCase("EFT-Checking (Automatic)")){
			System.out.println("Payment Type Matched");
			return new AutomaticPaymentSubmittedPage(driver);
		}
		return null;
	}
	
	public AutomaticPaymentSubmittedPage ValidatePaymentAmount()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(PaymentAmount.getText().equalsIgnoreCase("test amount")){
			System.out.println("Payment Amount Matched");
			return new AutomaticPaymentSubmittedPage(driver);
		}
		return null;
	}
	
	public AutomaticPaymentSubmittedPage ValidateTimeStamp() throws InterruptedException
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");		 
		Date date = new Date();		 
		String date1= dateFormat.format(date);
		System.out.println("System Time Stamp is : "+date1);
		Thread.sleep(2000);
		System.out.println("OTP Page submitted Timestamp is: "+TimeStamp.getText());
		
		if(TimeStamp.getText().equals(date1)){	
			System.out.println("Timestamp matched");
			return new AutomaticPaymentSubmittedPage(driver);
		}
		return null;
	}
	

}
