package pages.member.ulayer;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import atdd.framework.UhcDriver;
import pages.member.bluelayer.ConfirmOneTimePaymentPage;

public class PaymentsOverview extends UhcDriver{

	@FindBy(xpath="//div[@class='margin-small']//a[@id='onetimepayment']")
	private WebElement OneTimePaymentButton;
	
	@FindBy(xpath = "//div[@id='paymentOverviewApp']//span[@class='payment-method-btn'][2]/a")
	private WebElement AutomaticPaymentButton;
	
	@FindBy(xpath = "//*[@id='editAutomaticPaymentsModal']/div/div/div[3]/a[1]/span")
	private WebElement SetUpNewAutoPayment;	
	
	@FindBy(xpath=".//*[@id='customFields']/div[3]/button")
	private WebElement SearchButton;
	
	@FindBy(xpath=".//*[@id='paymentHistoryApp']/div/div/div/div/div[1]/p")
	private WebElement ErrorMessage;
	
	@FindBy(xpath="//*[@id='50129808']/a")	
	private WebElement Tab1;
	
	@FindBy(xpath="//*[@id='22976826']/a")
	private WebElement Tab2;
	
	@FindBy(xpath="//*[@id='paymentCustomSearch']/div/span/div/div[2]/div[1]/label")
	private WebElement PaidCheckbox;
	
	@FindBy(xpath="//*[@id='paymentCustomSearch']/div/span/div/div[2]/div[2]/label")
	private WebElement UnPaidCheckbox;
	
	@FindBy(xpath="//*[@id='paymentHistoryApp']/div[1]/div/div/div/div[3]")	              
	private WebElement Payments_status_Error;
	
	@FindBy(xpath="//*[@id='IPEinvL']/map/area[3]")	              
	private WebElement Popup;
	
	
	public PaymentsOverview(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	

	@Override
	public void openAndValidate() {		
		validate(OneTimePaymentButton);
		validate(AutomaticPaymentButton);
	}	
	
	public AutomaticPaymentsPage navigateToAutomaticPaymentpage() throws InterruptedException
	{
		Thread.sleep(5000);
		if(AutomaticPaymentButton.isEnabled()){
			AutomaticPaymentButton.click();
			return new AutomaticPaymentsPage(driver);
		}
		return null;
	}
	
	public OneTimePaymentsPage navigateToOneTimePaymentpage() throws InterruptedException
	{
		Thread.sleep(8000);
		if(Popup.isDisplayed())
		{
			Popup.click();
		}
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(5000);
		if(OneTimePaymentButton.isEnabled()){
			OneTimePaymentButton.click();
			return new OneTimePaymentsPage(driver);
		}
		return null;
	}
	
	
	public OneTimePaymentsPage navigateToAutoPaymentpage() throws InterruptedException
	{
		Thread.sleep(8000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(9000);
		if(AutomaticPaymentButton.isEnabled()){
			AutomaticPaymentButton.click();
			Thread.sleep(2000);
			SetUpNewAutoPayment.click();
			return new OneTimePaymentsPage(driver);
		}
		return null;
	}
	
	public OneTimePaymentsPage TabValidation()
	{
		if(Tab1.isEnabled() && Tab2.isEnabled()){
			Tab1.click();
			Tab2.click();
			return new OneTimePaymentsPage(driver);
		}
		return null;
	}
	
	public PaymentsOverview ScrollDownAndSelectRange() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)", "");
		System.out.println("Scrolled Down");
		Thread.sleep(2000);
		Select dropdown = new Select(driver.findElement(By.id("payment-date")));
		dropdown.selectByIndex(5);
		System.out.println("Custom Date range Selected");
		
		if(SearchButton.isEnabled()){
			SearchButton.click();
			return new PaymentsOverview(driver);
		}
		return null;
	}
	
	
	public PaymentsOverview UnselectPaidUnpaidCheck() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)", "");
		System.out.println("Scrolled Down");
		Thread.sleep(2000);
		PaidCheckbox.click();
		UnPaidCheckbox.click();
		Thread.sleep(2000);
		System.out.println(Payments_status_Error.getText());
		if(Payments_status_Error.getText().contains("Select Paid, Unpaid or both for the payment status you want to view")){
			return new PaymentsOverview(driver);
		}
		return null;
	}
	
	
	public PaymentsOverview VerifyErrorMessage()
	{		
		if(ErrorMessage.getText().contains("Please re-enter the date")){
			return new PaymentsOverview(driver);
		}
		return null;
	}
	
}
