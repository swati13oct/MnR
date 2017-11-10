/**
 * 
 */
package pages.member.ulayer;

import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

/**
 * @author saduri
 *
 */
public class ReviewOneTimePaymentsPage extends UhcDriver{
	
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
	
	@FindBy(xpath="html/body/div[2]/div/div[2]/div/div/div[1]/div/div/div[6]/div[2]/span")
	private WebElement AccountHolderNamePaymentSubmittedpage;
	
	@FindBy(id="termError")
	private WebElement Legalcheckbox;
	
	//@FindBy(xpath="/html/body/div[2]/div/div/div/div/div/div/div[2]/div[3]/div/div/div/button")
	@FindBy(xpath="//button[contains(text(), 'Authorize monthly Payments')][1]")
	private WebElement SubmitButton;
	
	@FindBy(xpath="html/body/div[2]/div/div[2]/div/div/div[1]/div/div/div[1]/div[2]/span")
	private WebElement PaymentType;
	
	/*@FindBy(xpath="/html/body/div[2]/div[3]/div[2]/div/div[1]/div/div/div[2]/div[1]/div/div/div/div[3]/div/p[2]")	               
	private WebElement OTPError;*/
	
	@FindBy(xpath="//div[@class='payments']//div[@class='col-md-12']//div[@class='ng-scope'][3]/div/p[2]")	               
	private WebElement OTPError;
	
	private PageData reviewOneTime;
	
	public JSONObject reviewOneTimeJson;
	
	
	public ReviewOneTimePaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(amountPayed);
		validate(routingNumber);
	}

	
	public ReviewOneTimePaymentsPage validateValues() {
	   if(AccountNumber.getText().equalsIgnoreCase("1234567890"))
	   {
		   System.out.println("Account number value matched on Review Page");
		   Assert.assertTrue(true);
	   }
	   else
	   {		  
		  Assert.fail("Account number Value does not match"+AccountNumber.getText());
	   }
	   
	   if(AccountHolderName.getText().equalsIgnoreCase("first second third"))
	   {
		   System.out.println("Account Holder Name value matched on Review Page");
		   Assert.assertTrue(true);
	   }
	   else
	   {		  
		  Assert.fail("Account number Value does not match"+AccountHolderName.getText());
	   }
	    Legalcheckbox.click();
	    System.out.println("Legal terms checkbox clicked");
	    SubmitButton.click();	
	    System.out.println("Submit Button clicked");
	    if(driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")){
			return new ReviewOneTimePaymentsPage(driver);
		}
	    return null;
	}
	
	
	public OneTimePaymentPageSubmitted navigateToOTPSubmittedPage() throws InterruptedException {
		
		Thread.sleep(2000);	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		Legalcheckbox.click();
		System.out.println("Checkbox clicked");		
		Thread.sleep(2000);		
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		SubmitButton.click();
		System.out.println("Submit Button clicked");
	    Thread.sleep(5000);
		 if(driver.getTitle().equalsIgnoreCase("overview") || driver.getTitle().equalsIgnoreCase("onetimepayments") ){
				return new OneTimePaymentPageSubmitted(driver);
			}
		    return null;
	}
	
	
public ReviewOneTimePaymentsPage ValidateOnePaymentPerDayErrorMessage() throws InterruptedException {
		
	    Thread.sleep(2000);	
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,300)", "");
	    Thread.sleep(2000);
	    Legalcheckbox.click();
	    System.out.println("Checkbox clicked");		
	    Thread.sleep(2000);		
	    jse.executeScript("window.scrollBy(0,250)", "");
	    Thread.sleep(2000);
	    SubmitButton.click();
	    System.out.println("Submit Button clicked");
        Thread.sleep(5000);
		 if(OTPError.getText().contains("Only one payment request can be submitted per business day") || OTPError.getText().contains("Due to a system error, your request cannot be processed at this time")){
				return new ReviewOneTimePaymentsPage(driver);
			}
		    return null;
	}
	
	
	public ReviewOneTimePaymentsPage validateOTPSubmittedPageValues() {			
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
		    return new ReviewOneTimePaymentsPage(driver);
		}
	
	
	public JSONObject reviewOneTimeValues() {
		String fileName = CommonConstants.REVIEW_ONE_TIME_PAGE_DATA;
		reviewOneTime = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : reviewOneTime.getExpectedData().keySet()) {
			WebElement element = findElement(reviewOneTime.getExpectedData().get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		reviewOneTimeJson = jsonObject;

		return reviewOneTimeJson;
	}

}
