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

	@FindBy(id = "onetimepayment")
	private WebElement OneTimePaymentButton;
	
	@FindBy(id = "setupautopayment")
	private WebElement AutomaticPaymentButton;
	
	@FindBy(xpath=".//*[@id='customFields']/div[3]/button")
	private WebElement SearchButton;
	
	@FindBy(xpath=".//*[@id='paymentHistoryApp']/div/div/div/div/div[1]/p")
	private WebElement ErrorMessage;
	
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
	
	public OneTimePaymentsPage navigateToOneTimePaymentpage()
	{
		if(OneTimePaymentButton.isEnabled()){
			OneTimePaymentButton.click();
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
	
	public PaymentsOverview VerifyErrorMessage()
	{		
		if(ErrorMessage.getText().contains("Please re-enter the date")){
			return new PaymentsOverview(driver);
		}
		return null;
	}
	
}
