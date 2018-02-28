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

/**
 * @author pperugu
 *
 */
public class OneTimePaymentPageSubmitted extends UhcDriver{
	
	@FindBy(xpath="//button[contains(text(), 'View As PDF')]")
	private WebElement ViewPDFLink;
	
	@FindBy(xpath=".//*[contains(text(),'Payment Amount')]/following-sibling::div/span")
	private WebElement PaymentAmount;
	
	@FindBy(xpath=".//*[contains(text(),'Member Name')]/following-sibling::div/span")
	//@FindBy(xpath=".//*[@id='generatePdf']/div[1]/div/div/div[8]/div[2]/span")
	private WebElement MemberName;
	
	/*@FindBy(xpath=".//*[contains(text(),'Payment Date')]/following-sibling::div/span")
	private WebElement TimeStamp;*/
	
	@FindBy(xpath="//*[@id='generatePdf']//div[@class='table-body-row'][2]/div[@class='table-body-cell'][2]")
	private WebElement TimeStamp;
	
	public OneTimePaymentPageSubmitted(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);		
		//openAndValidate();
	}	

	@Override
	public void openAndValidate() {
		validate(ViewPDFLink);	
	}

	public OneTimePaymentPageSubmitted ValidatePDFLink()
	{
		if(ViewPDFLink.isEnabled()){
			ViewPDFLink.click();
			return new OneTimePaymentPageSubmitted(driver);
		}
		return null;
	}
	
	public OneTimePaymentPageSubmitted ValidatePaymentAmount() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(PaymentAmount.getText().equalsIgnoreCase("$56.00")){	
			System.out.println("Payment Amount matched");
			return new OneTimePaymentPageSubmitted(driver);
		}
		return null;
	}
	
	public OneTimePaymentPageSubmitted ValidateMemberName() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(MemberName.getText().equalsIgnoreCase("FCEEBB FEAEBED")){
			System.out.println("Member Name matched");
			return new OneTimePaymentPageSubmitted(driver);
		}
		return null;
	}
	
	public OneTimePaymentPageSubmitted ValidateTimeStamp() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");		 
		Date date = new Date();		 
		String date1= dateFormat.format(date);
		System.out.println("System Time Stamp is : "+date1);
		Thread.sleep(2000);
		System.out.println("OTP Page submitted Timestamp is: "+TimeStamp.getText());
		return new OneTimePaymentPageSubmitted(driver);
		/*if(TimeStamp.getText().contains(date1)){	
			System.out.println("Timestamp matched");
			return new OneTimePaymentPageSubmitted(driver);
		}
		return null;*/
	}

}

