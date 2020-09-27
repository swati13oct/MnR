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


	@FindBy(xpath = "//h1[contains(text(),'Make a One-time Payment')]")
	public WebElement guestPaymentsHeader;
	

	@FindBy(xpath = "//h3[contains(text(),'Select a Payment Amount')]")
	public WebElement selectAPaymentHeader;
	
	@FindBy(id = "pastAmountDueFound")
	public WebElement pastAmountDueRadioButton;
	
	@FindBy(xpath = "//h2[@class='uhc-tempo-header__h2 token-font-family-heading-three token-color-gray-dark-base m-0 pad34']/parent::*//p[contains(text(),'Past Amount Due')]")
	public WebElement pastAmountValue;
	
	@FindBy(id = "pastAmountAndCurentChargesFound")
	public WebElement pastAmountCurrentChargesRadioButton;
	
	@FindBy(xpath ="//div[2]/div/div[2]/h2/text()[2]")
	public WebElement pastAmountCurrentChargesValue;
	
	@FindBy(id = "otherAmount")
	public WebElement otherAmountRadioButton;
	
	@FindBy(xpath = "//*[@class='input-group-t']/input")
	public WebElement otherAmountTextField;
	
	@FindBy(xpath = "//h3[contains(text(),'Choose a Payment Method')]")
	public WebElement chooseAPaymentHeading;
	
	@FindBy(xpath = "//input[@name='paymentMethod'][@value='CC']")
	public WebElement creditcardRadioButton;
	
	@FindBy(xpath = "//input[@name='paymentMethod'][@value='EFT']")
	public WebElement eftCheckingRadioButton;
	
	@FindBy(xpath = "//*[@id='paymentsummary']//p[contains(text(),'Plan:')]")
	public WebElement sideWidgetPlanName;
	
	@FindBy(xpath = "//*[@id='paymentsummary']//p[contains(text(),'Member name:')]")
	public WebElement sideWidgetMemberNameLabel;
	
	@FindBy(xpath = "//*[@id='paymentsummary']//p[contains(text(),'Member name:')]//following::p[1]")
	public WebElement sideWidgetMemberNameValue;
	
	@FindBy(xpath = "//*[@id='paymentsummary']//p[contains(text(),'ID:')]")
	public WebElement sideWidgetMemberIDLabel;
	
	@FindBy(xpath = "//*[@id='paymentsummary']//p[contains(text(),'ID:')]//following::p[1]")
	public WebElement sideWidgetMemberIDValue;
	
	@FindBy(xpath = "//*[@id='paymentsummary']//p[contains(text(),'Payment details:')]")
	public WebElement sideWidgetPaymentDetailsLabel;
	
	@FindBy(xpath = "//*[@id='paymentsummary']//p[contains(text(),'Payment details:')]//following::p[1]")
	public WebElement sideWidgetPaymentDetailsValue;
	
	@FindBy(xpath = "//*[@id='paymentsummary']//p[contains(text(),'Total You Pay')]")
	public WebElement sideWidgetTotalYouPayLabel;

	@FindBy(xpath = "//*[@id='paymentsummary']//p[contains(text(),'Total You Pay')]//following::p[1]")
	public WebElement sideWidgetTotalYouPayValue;
	
	@FindBy(xpath = "//iframe[@class='frame-area']")
	public WebElement ccAndEftIframe ;

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

	@FindBy(xpath = "//*[@class='alert-body']//div[contains(text(),'errors have been found')]")
	public WebElement noEftAccountInfo;

}

