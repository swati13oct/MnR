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


	@FindBy(xpath = "//h1[contains(text(),'Make a One-Time Payment')]")
	public WebElement guestPaymentsHeader;
	
	@FindBy(xpath = "")
	public WebElement oneTimePaymentTextBelowHeader;
	
	@FindBy(xpath = "//h3[contains(text(),'Select a Payment Amount')]")
	public WebElement selectAPaymentHeader;
	
	@FindBy(xpath = "//p[contains(text(),'Past Amount Due')]")
	public WebElement pastAmountDueRadioButton;
	
	@FindBy(xpath = "//h2[@class='uhc-tempo-header__h2 token-font-family-heading-three token-color-gray-dark-base m-0 pad34']/parent::*//p[contains(text(),'Past Amount Due')]")
	public WebElement pastAmountValue;
	
	@FindBy(id = "pastAmountAndCurentChargesFound")
	public WebElement pastAmountCurrentChargesRadioButton;
	
	@FindBy(xpath = "")
	public WebElement pastAmountCurrentChargesValue;
	
	@FindBy(xpath = "//p[contains(text(),'Other Amount')]")
	public WebElement otherAmountRadioButton;
	
	@FindBy(id = "otherAmount")
	public WebElement otherAmountTextField;
	
	@FindBy(xpath = "")
	public WebElement chooseAPaymentHeading;
	
	@FindBy(xpath = "//input[@name='paymentMethod'][@value='CC ']")
	public WebElement creditcardRadioButton;
	
	@FindBy(xpath = "//input[@name='paymentMethod'][@value='EFT']")
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
	
	@FindBy(xpath = "//*[@id='holderName']")
	public WebElement nameOnCardTextField ;
	
	@FindBy(xpath = "//*[@id='accountNumber']")
	public WebElement cardNumberTextField;
	
	@FindBy(xpath = "//*[@id='month']")
	public WebElement expirationMonthDropdown;

	@FindBy(xpath = "//*[@id='year']")
	public WebElement expirationYearDropdown;
	
	@FindBy(xpath = "//button[contains(text(),'Review and Submit')]")
	public WebElement reviewAndSubmitButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Review and Submit')]")
	public WebElement reviewAndSubmitPageHeader;

	@FindBy(xpath = "//*[@id='bankHolFirstName']")
	public WebElement bankHoldersFirstNameTextField;

	@FindBy(xpath = "//*[@id='bankHolMiddleName']")
	public WebElement bankHoldersMiddletNameTextField;

	@FindBy(xpath = "//*[@id='bankHolLastName']")
	public WebElement bankHoldersLastNameTextField;

	@FindBy(xpath = "//input[@id='routNumber']")
	public WebElement routingNumberTextField;

	@FindBy(xpath = "//input[@id='accountNum']")
	public WebElement accountNumberTextField;

	@FindBy(xpath = "//div[2][contains(text(),'Cannot exceed annual remaining amount')]")
	public WebElement exceedAnnualerrorMessage;

	@FindBy(xpath = "//div[2][contains(text(),'Amount must exceed $1.00')]")
	public WebElement exceed1errorMessage;

	@FindBy(xpath = "")
	public WebElement noEftAccountInfo;

}

