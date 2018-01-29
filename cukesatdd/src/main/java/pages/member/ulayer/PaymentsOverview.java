package pages.member.ulayer;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.dashboard.member.ulayer.RallyDashboardPage;
import pages.member.bluelayer.ConfirmOneTimePaymentPage;

public class PaymentsOverview extends UhcDriver{
// updated element locator
	@FindBy(xpath="//div[@class='margin-small']//a[@id='onetimepayment' and not(contains(@class,'ng-hide'))]")
	private WebElement OneTimePaymentButton;
	/*@FindBy(xpath="//div[@class='margin-small']//a[@id='onetimepayment']")
	private WebElement OneTimePaymentButton;*/
	
	@FindBy(xpath="//div[@class='margin-small']//a[@id='setupautopayment' and not(contains(@class,'ng-hide'))]")
	private WebElement AutomaticPaymentButton;
	/*@FindBy(xpath = "//div[@id='paymentOverviewApp']//span[@class='payment-method-btn'][2]/a")
	private WebElement AutomaticPaymentButton;*/
	
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
	
	@FindBy(id="paymentTable")	              
	private WebElement PaymentsTable;
	
	@FindBy(xpath="//table[@id='paymentTable']/tbody/tr/th[contains(text(),'Due Date')]")	              
	private WebElement dueDate;
	
	@FindBy(xpath="//table[@id='paymentTable']/tbody/tr/th[contains(text(),'Amount Paid')]")	              
	private WebElement amountPaid;
	
	@FindBy(id="payment-date")	              
	private WebElement paymentDropdown;
	
	@FindBy(className = "loading-block")
	public List<WebElement> loadingImages;
	
	public PaymentsOverview(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	

	@Override
	public void openAndValidate() {	
		RallyDashboardPage.checkModelPopup(driver);
		CommonUtility.waitForPageLoad(driver, OneTimePaymentButton, 60);
		validate(OneTimePaymentButton);
		//validate(AutomaticPaymentButton);
	}	
	
	public AutomaticPaymentsPage navigateToAutomaticPaymentpage() throws InterruptedException
	{
		Thread.sleep(30000);
		waitforElement(AutomaticPaymentButton, 20000);
		if(AutomaticPaymentButton.isEnabled()){
			AutomaticPaymentButton.click();
			return new AutomaticPaymentsPage(driver);
		}
		return null;
	}
	
	public OneTimePaymentsPage navigateToOneTimePaymentpage() throws InterruptedException
	{
		/*JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(15000L);*/
		validate(OneTimePaymentButton);
			OneTimePaymentButton.click();
			CommonUtility.checkPageIsReady(driver);
			if(driver.getCurrentUrl().contains("onetime/eft/overview.htm")){
			return new OneTimePaymentsPage(driver);
			}
		return null;
	}
	
	
	public OneTimePaymentsPage navigateToAutoPaymentpage() throws InterruptedException
	{
		Thread.sleep(8000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(5000);
		if(AutomaticPaymentButton.isEnabled()){
			AutomaticPaymentButton.click();
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
	
	public void ScrollDownAndSelectRange() throws InterruptedException
	{
		/*Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)", "");
		System.out.println("Scrolled Down");
		Thread.sleep(2000);*/
		scrollToView(paymentDropdown);
		Select dropdown = new Select(paymentDropdown);
		dropdown.selectByVisibleText("Last 24 months");
		if(loadingImages.size()>0){
			CommonUtility.waitForElementToDisappear(driver, loadingImages.get(0), 120);
			}
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
	
	public void verifyPaymentTable()
	{		
		scrollToView(PaymentsTable);
		if(PaymentsTable.isDisplayed()){
			validate(dueDate);
			validate(amountPaid);
		}
	}
	
}
