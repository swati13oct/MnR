package pages.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ConfirmOneTimePaymentPage extends UhcDriver{
	
	@FindBy(id = "termError")
	private WebElement TermsCheckRadioButton;
	
	
	@FindBy(xpath = "(.//*[@class='btn btn--primary'])[2]")
	private WebElement SubmitPaymentButton;

	public ConfirmOneTimePaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	public OneTimePaymentSuccessPage confirmsPayment() {
		
		TermsCheckRadioButton.click();
		System.out.println("Terms and conditions radio button clicked");
		if(SubmitPaymentButton.isEnabled())
			SubmitPaymentButton.click();
		     System.out.println("Submit Payment Button clicked");
		CommonUtility.checkPageIsReady(driver);
		if(driver.getTitle().equalsIgnoreCase("overview")){
			System.out.println("Title matched");
			OneTimePaymentSuccessPage oneTimePaymentSuccessAarpPage = new OneTimePaymentSuccessPage(driver);
			if(!(oneTimePaymentSuccessAarpPage.getContent().contains("Only one payment request can be submitted per business day"))  && !(oneTimePaymentSuccessAarpPage.getContent().contains("Due to a system error, your request cannot be processed at this time")))
			{
				return oneTimePaymentSuccessAarpPage;
			}
			else
			{
				System.out.println("ERROR in Confirming Payments");
			}
		}
		return null;
		
	}


	@Override
	public void openAndValidate() {
		
		validate(TermsCheckRadioButton);
		
	}


}
