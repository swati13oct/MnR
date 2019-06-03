/**
 * 
 */
package pages.memberrdesignVBF;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class ReviewCAOneTimePaymentsPage extends UhcDriver {

	public static boolean isBusinessValidation = false;

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

	@FindBy(xpath = "//div[contains(@class,'payments')]//div[contains(@class,'intro_text')][contains(@style,'color:red;')]//*[string-length(normalize-space(text()))>1]")
	private WebElement errorMessage;

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

	@FindBy(id = "form_routingNumber")
	private WebElement Error1;

	@FindBy(xpath = "//*[@id='paymentOverviewApp']//div[@class='container']//div[@class='col-md-12']/h2[1]")
	private WebElement PaymentHeading;

	@FindBy(xpath = "//*[@class='page-header']//div[@class='row']//h1")
	private WebElement PageHeader;

	@FindBy(xpath = "//p[text()='Checking Account Information']")
	private WebElement CheckingAccountInformationHeader;

	@FindBy(xpath = "//button[text()='Edit Payment Information']")
	private WebElement EditPaymentInformation;

	@FindBy(xpath = "//button[@class='btn btn--primary']")
	private WebElement AuthorizeMonthlyPaymentstButton;

	@FindBy(xpath = "//*[@id='termsAgree']")
	private WebElement AgreeCheckBox;

	@FindBy(xpath = "//button[@class='btn btn--primary']")
	private WebElement ContinueButton;
	@FindBy(xpath = "//button[text()='Edit Payment Information']")
	private WebElement EditPayment;

	public ReviewCAOneTimePaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(EditPayment);
	}

	public void PaymentsDataVerificationonReviewPage() {
		List<WebElement> rowsList = driver.findElements(By.xpath("//div[@class='table-body-row']"));
		List<WebElement> columnsList = null;
		for (WebElement row : rowsList) {
			System.out.println();
			columnsList = row.findElements(By.tagName("div"));

			for (WebElement column : columnsList) {
				System.out.print(column.getText() + " - ");

			}
		}
	}

	public ReviewCAOneTimePaymentsPage EnterFiledsOnMakeOneTime(Map<String, String> accountAttributessMap)
			throws Exception {

		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

		routingNumberField.sendKeys(routingNumber);
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);
		accountNumberField.sendKeys(accountNumber);
		confirmAccountNumberField.sendKeys(confirmAccountNumber);
		firstNameField.sendKeys(firstName);
		middleNameField.sendKeys(middleName);
		lastNameField.sendKeys(lastName);
		ContinueButton.click();
		System.out.println("Clicked on Contuine button");
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, EditPayment, 45);
		if (driver.getTitle().contains("Review Your One-Time Payment Information")) {
			System.out.println("User is on Review Your One-Time Payment Information Page");
			return new ReviewCAOneTimePaymentsPage(driver);
		} else {
			System.out.println("Review Your One-Time Payment Information not displayed");
			return null;
		}
	}

	public ConfirmOneTimePaymentPage selectAgreeAndClickOnSubmitPaymentsforOneTime() {
		validate(EditPaymentInformation);
		System.out.println("User is on Review Review Your Automatic Payments Information Page");
		PaymentsDataVerificationonReviewPage();
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Authorize Monthly Payments button");

		waitforElementDisapper(By.xpath("//div[contains(@class,'loading-block')]"), 60);
		CommonUtility.checkPageIsReadyNew(driver);

		if (driver.getTitle().contains("One-Time Payment Submitted")) {
			System.out.println("User is on Confirmation Page for One time payment");
			return new ConfirmOneTimePaymentPage(driver);
		} else if (errorMessage.getText().contains("Only one payment request can be submitted per business day")) {
			System.out.println("Buiness Validation message appears -- " + errorMessage.getText());
			isBusinessValidation = true;
			return null;
		} else {
			System.out.println("User is not on Confirmation Page");
			return null;
		}
	}

	public ConfirmOneTimePaymentPage selectAgreeAndClickOnSubmitPaymentsforOneTimeSHIP() {
		validate(EditPaymentInformation);
		System.out.println("User is on Review Review Your Automatic Payments Information Page");
		PaymentsDataVerificationonReviewPage();
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Authorize Monthly Payments button");

		waitforElementDisapper(By.xpath("//div[contains(@class,'loading-block')]"), 60);
		CommonUtility.checkPageIsReadyNew(driver);

		if (driver.getTitle().contains("One-Time Payment Submitted")) {
			System.out.println("User is on Confirmation Page for One time payment");
			return new ConfirmOneTimePaymentPage(driver);
		} else {
			System.out.println("User is not on Confirmation Page");
			return null;
		}
	}

}