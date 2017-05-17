package pages.member.ulayer;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.member.bluelayer.ConfirmOneTimePaymentPage;

public class PaymentsOverview extends UhcDriver{

	@FindBy(id = "onetimepayment")
	private WebElement OneTimePaymentButton;
	
	@FindBy(id = "setupautopayment")
	private WebElement AutomaticPaymentButton;
	
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
	
	public AutomaticPaymentsPage navigateToAutomaticPaymentpage()
	{
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
	
}
