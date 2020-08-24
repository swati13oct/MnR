package pages.regression.guestPayments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;


/**
 * @author akapoo18
 *
 */
public class OneTimeGuestPaymentWebElements extends UhcDriver{
	
	/**
	 * Lists all the elements of Guest Payments Portal
	 */

	
	public OneTimeGuestPaymentWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	public void openAndValidate() { 
		
	}

	@FindBy(xpath = ".//*[@id='atdd_otheramount_label']/label")
	private WebElement amountRadioButton;

	@FindBy(xpath = "//input[@id='amountInput']")
	private WebElement otheramountfield;

	@FindBy(id = "otherAmount")
	private WebElement otherAmountRadioButton;

	@FindBy(id = "optionsRadios1")
	private WebElement AmountDueTodayButton;
	
	@FindBy(xpath = "//label[@for='optionsRadios10']//input")
	private WebElement CheckingAccountRadioButton;

	@FindBy(xpath = "//label[@for='optionsRadios20']//input")
	private WebElement creditcardRadioButton;

	@FindBy(xpath = "//*[@class='payment-selection__actions']/button")
	private WebElement NextButton;

	@FindBy(id = "div_cardInfo")
	private WebElement EnterCreditInfo;

	@FindBy(id = "amountInput")
	private WebElement otherAmountInput;

	@FindBy(id = "routing-number")
	private WebElement routingNumberField;

	@FindBy(id = "confirm-routing-number")
	private WebElement confirmRoutingNumberField;

	@FindBy(id = "account-number")
	private WebElement accountNumberField;

	@FindBy(id = "confirm-account-number")
	private WebElement confirmAccountNumberField;

	@FindBy(id = "first-name")
	private WebElement firstNameField;

	@FindBy(id = "middle-name")
	private WebElement middleNameField;

	@FindBy(id = "last-name")
	private WebElement lastNameField;

	@FindBy(id = "review-continue")
	private WebElement continueButton;

	@FindBy(className = "modal-body")
	private WebElement iPerceptionPopUp;

	@FindBy(id = "amountToBePaid")
	private WebElement amountToBePaidField;

	@FindBy(xpath = "//*[@id='IPEinvL']/map/area[3]")
	private WebElement iPerceptionAutoPopUp;

	@FindBy(xpath = "//*[@id='consent']/following-sibling::label[contains(text(),'I have read and agree to the following')]")
	private WebElement iHaveReadAndAgreeToTheFollowing;

	// @FindBy(xpath
	// ="//*[@id='consent']/following-sibling::label[contains(text(),'I have
	// read and agree to the following')]")
	@FindBy(xpath = "//*[@id='consent']/following-sibling::label[contains(text(),'Electronic Signature Consent')]")
	private WebElement electronicsignature;

	@FindBy(xpath = "//*[@class='overview parsys']//div[@class='row'][3]//div[@class='longform__row'][10]//div[@class='margin-medium']/a[2]")
	private WebElement continueAutoPayButton;

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

	@FindBy(xpath = "//*[@class='btn btn--secondary cancelbutton cancel-wcag']")
	private WebElement RecurringFormCancel;

	@FindBy(xpath = "//*[@id='paymentOverviewApp']//h2[contains(text(), normalize-space('Premium Payments Overview'))]")
	private WebElement PaymentOverviewtText;

	@FindBy(xpath = "//*[@class='margin-medium']//span//button")
	private WebElement AuthorizeButton;

	@FindBy(id = "btnSubmit")
	private WebElement ProceedButton;

	@FindBy(xpath = "//*[@id='holderName']")
	private WebElement CardHolderName;

	@FindBy(xpath = "//*[@id='accountNumber']")
	private WebElement CreditCardNumberField;

	@FindBy(xpath = "//a[@class='btn btn--primary cancel-btn-modal']")
	private WebElement PaymentCancelModelPopup;

	@FindBy(xpath = "//*[@id='paymentOverviewApp']//div[@class='container']//div[@class='col-md-12']/h2[1]")
	private WebElement PaymentHeading;

	@FindBy(xpath = "//*[@class='page-header']//div[@class='row']//h1")
	private WebElement PageHeader;

	@FindBy(xpath = "//h2[text()='Checking Account Information']")
	private WebElement CheckingAccountInformationHeader;
	
	@FindBy(xpath = "(//button[text()='Edit Payment Information'])[2]")
	private WebElement EditPaymentInformation;
	
	@FindBy(xpath = "//button[@class='btn btn--primary']")
	private WebElement AuthorizeMonthlyPaymentstButton;
	
	@FindBy(id = "termsAgree")
	private WebElement AgreeCheckBox;
	
	@FindBy(xpath = "//p[contains(text(),'The information Only one payment request can be su')]")
	private WebElement moreThanonePaymentError;
	
	@FindBy(id = "memAuthPaymentSubmitError")
	private WebElement csrUnauthorizedErrorMessage;
	
	@FindBy(xpath = "//dt[text()='Next Payment Amount:']")
	private WebElement NextPaymentSummary;

	@FindBy(xpath = "//*[@class='onetime-bill']/div[@class='ng-scope']")
	private WebElement NextPaymentProcess;

	@FindBy(xpath = "//*[@class='dl-horizontal'][2]")
	private WebElement RemainingAmountSummary;
	
	@FindBy(xpath = "//*[@class='dl-horizontal'][2]//dd[@class='onetime-bill ng-binding']")
	private WebElement RemainingAmount;
	
	@FindBy(xpath = "//a[@class='btn btn--primary onetimepayment']")
	private WebElement MakeAPaymentButton;
	
	
	

}

