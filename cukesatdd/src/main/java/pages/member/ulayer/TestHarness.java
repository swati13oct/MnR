package pages.member.ulayer;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.member.bluelayer.ConfirmOneTimePaymentPage;

public class TestHarness extends UhcDriver{
	
	
	@FindBy(xpath="//a[contains(.,'Go to Payments page')]")
	private WebElement PaymentPage;
	
	/*@FindBy(linkText="Go to Payments page")
	private WebElement TeamHPaymentPage;*/	
	/*@FindBy(xpath="/html/body/div[2]/div[3]/div[2]/div/table/tbody/tr[8]/td[2]/a") 
	private WebElement TeamHPaymentPage;*/	
	
	/*@FindBy(xpath="//table[@class='componentTable']/tbody/tr[8]/td[2]/a")                  
	private WebElement TeamHPaymentPage;*/
	
	@FindBy(xpath="//a[contains(.,'Go to Payments page')]")                  
	private WebElement TeamHPaymentPage;
	
	@FindBy(linkText="Go to payment link page")
	private WebElement TeamCPaymentPage;
	

	
	public TestHarness(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(PaymentPage);		
	}	
	
	public PaymentsOverview navigateToPaymentOverview()
	{
		System.out.println("Inside navigateToPaymentOverview functions");
		if(PaymentPage.isEnabled()){
			PaymentPage.click();
			System.out.println("Go tp Payment link clicked");
			//Implementing direct navigation as PaymentLink in test harness is not getting clicked via selenium
			//driver.get("https://team-h-medicare.uhc.com/content/medicare/member/payments/overview.html");
			return new PaymentsOverview(driver);
		}
		return null;
	}
	
	public PaymentsOverview navigateToTeamHPaymentOverview() throws InterruptedException
	{
		System.out.println("Inside navigateToTeamHPaymentOverview functions");
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(15000);
		if(TeamHPaymentPage.isEnabled()){
			TeamHPaymentPage.click();
			System.out.println("Go to Payment link clicked");
			//Implementing direct navigation as PaymentLink in test harness is not getting clicked via selenium
			driver.get("https://team-h-medicare.uhc.com/content/medicare/member/payments/overview.html");
			return new PaymentsOverview(driver);
		}
		return null;
	}
	
	public PaymentsOverview navigateToTeamCPaymentOverview()
	{
		if(TeamCPaymentPage.isEnabled()){
			TeamCPaymentPage.click();
			return new PaymentsOverview(driver);
		}
		return null;
	}
	
}
