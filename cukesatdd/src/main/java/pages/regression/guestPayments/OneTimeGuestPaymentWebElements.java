package pages.regression.guestPayments;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import atdd.framework.UhcDriver;



/**
 * @author akapoo18
 *
 */
public class OneTimeGuestPaymentWebElements extends UhcDriver{
	
	/**
	 * Lists all the elements of One Time Payments Page on Guest Portal
	 */

	
	public OneTimeGuestPaymentWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	public void openAndValidate() { 
		
	}


	@FindBy(xpath = "//a[@class='btn btn--primary onetimepayment']")
	public WebElement guestPaymentsHeader;
	
	@FindBy(xpath = "")
	public WebElement oneTimePaymentTextBelowHeader;
	
	@FindBy(xpath = "")
	public WebElement selectAPaymentHeader;
	
	@FindBy(xpath = "")
	public WebElement pastAmountDueRadioButton;
	
	@FindBy(xpath = "")
	public WebElement pastAmountValue;
	
	@FindBy(xpath = "")
	public WebElement pastAmountCurrentChargesRadioButton;
	
	@FindBy(xpath = "")
	public WebElement pastAmountCurrentChargesValue;
	
	@FindBy(xpath = "")
	public WebElement otherAmountRadioButton;
	
	@FindBy(xpath = "")
	public WebElement otherAmountTextField;
	
	@FindBy(xpath = "")
	public WebElement chooseAPaymentHeading;
	
	@FindBy(xpath = "")
	public WebElement creditcardRadioButton;
	
	@FindBy(xpath = "")
	public WebElement eftCheckingRadioButton;
	
	@FindBy(xpath = "")
	public WebElement sideWidgetPlanName;
	
	@FindBy(xpath = "")
	public WebElement sideWidgetMemberNameLabel;
	
	@FindBy(xpath = "")
	public WebElement sideWidgetMemberNameValue;
	
	@FindBy(xpath = "")
	public WebElement sideWidgetMemberIDLabel;
	
	@FindBy(xpath = "")
	public WebElement sideWidgetMemberIDValue;
	
	@FindBy(xpath = "")
	public WebElement sideWidgetPaymentDetailsLabel;
	
	@FindBy(xpath = "")
	public WebElement sideWidgetPaymentDetailsValue;
	
	@FindBy(xpath = "")
	public WebElement sideWidgetTotalYouPayLabel;

	@FindBy(xpath = "")
	public WebElement sideWidgetTotalYouPayValue;
	
	@FindBy(xpath = "")
	public WebElement nameOnCardTextField ;
	
	@FindBy(xpath = "")
	public WebElement cardNumberTextField;
	
	@FindBy(xpath = "")
	public WebElement expirationMonthDropdown;

	@FindBy(xpath = "")
	public WebElement expirationYearDropdown;
	
	@FindBy(xpath = "")
	public WebElement reviewAndSubmitButton;
	
	@FindBy(xpath = "")
	public WebElement reviewAndSubmitPageHeader;

	@FindBy(xpath = "")
	public WebElement bankHoldersNameTextField;

	@FindBy(xpath = "")
	public WebElement routingNumberTextField;

	@FindBy(xpath = "")
	public WebElement accountNumberTextField;

	@FindBy(xpath = "")
	public WebElement exceedAnnualerrorMessage;

	@FindBy(xpath = "")
	public WebElement exceed1errorMessage;

	@FindBy(xpath = "")
	public WebElement noEftAccountInfo;

}

