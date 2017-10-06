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
	
	
	@FindBy(linkText="Go to Payments page")
	private WebElement PaymentPage;
	
	@FindBy(linkText="Go to Payments page")
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
		if(PaymentPage.isEnabled()){
			PaymentPage.click();
			return new PaymentsOverview(driver);
		}
		return null;
	}
	
	public PaymentsOverview navigateToTeamHPaymentOverview() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(5000);
		if(TeamHPaymentPage.isEnabled()){
			TeamHPaymentPage.click();
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
