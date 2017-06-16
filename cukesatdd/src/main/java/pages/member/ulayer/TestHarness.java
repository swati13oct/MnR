package pages.member.ulayer;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.member.bluelayer.ConfirmOneTimePaymentPage;

public class TestHarness extends UhcDriver{
	
	
	@FindBy(linkText="Go to Payments page")
	private WebElement PaymentPage;
	
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
	
	
}
