/**
 * 
 */
package pages.memberrdesignVBF;

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
public class OneTimePaymentsPage extends UhcDriver {

	/*
	 * @FindBy(xpath = ".//*[@id='otheramt']") private WebElement
	 * otherAmountRadio;
	 * 
	 * @FindBy(id = "other-amount-number") private WebElement otherAmountNumber;
	 * 
	 * @FindBy(id = "routing-number") private WebElement routingNumberField;
	 * 
	 * @FindBy(id = "confirm-routing-number") private WebElement
	 * confirmRoutingNumberField;
	 * 
	 * @FindBy(id = "account-number") private WebElement accountNumberField;
	 * 
	 * @FindBy(id = "confirm-account-number") private WebElement
	 * confirmAccountNumberField;
	 * 
	 * @FindBy(id = "first-name") private WebElement firstNameField;
	 * 
	 * @FindBy(id = "last-name") private WebElement lastNameField;
	 * 
	 * @FindBy(id = "review-continue") private WebElement reviewContinue;
	 * 
	 * @FindBy(xpath =
	 * ".//*[@id='atdd_electronicsignature_label']//label[@for='consent']")
	 * private WebElement electronicSignatureCheck;
	 */

	@FindBy(id = "otherAmount")
	private WebElement OtherAmountButton;

	@FindBy(xpath = "//section[contains(@class,'payment-selection')]//aside[contains(@class,'info-panel')]")
	private WebElement PaymentSummaryCard;

	@FindBy(xpath = "//aside[contains(@class,'info-panel')]//*[@id='info-panel__title'][contains(text(),'Payment Summary')]")
	private WebElement PaymentSummaryCardHeader;

	@FindBy(xpath = "//aside[contains(@class,'info-panel')]//div[contains(@class,'info-panel__body')]//dl[contains(@class,'dl-horizontal')]/dt[contains(text(),'Remaining Amount:')]/following-sibling::dd[contains(@class,'onetime-bill')][contains(text(),'$')]")
	private WebElement PaymentSummaryCardRemainingAmt;

	@FindBy(id = "otherAmount")
	private WebElement otherAmountRadioButton;

	@FindBy(id = "amountInput")
	private WebElement otherAmountInput;

	@FindBy(id = "optionsRadios20")
	private WebElement creditcardRadioButton;

	@FindBy(id = "optionsRadios10")
	private WebElement CheckingAccountRadioButton;

	@FindBy(xpath = "//form//div[@class='payment-selection__actions']/button[contains(@class,'payment-selection__btn')]")
	private WebElement NextButton;

	@FindBy(xpath = "//div[contains(@class,'loading-block')]")
	private WebElement loadingBlock;

	@FindBy(xpath = "//p[text()='Checking Account Information']")
	private WebElement CheckingAccountInformationHeader;

	@FindBy(xpath = "//input[@id='amountInput']")
	private WebElement otheramountfield;
	
	public OneTimePaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, otheramountfield, 30);
		validateNew(PaymentSummaryCard);
		validateNew(PaymentSummaryCardHeader);
		validateNew(PaymentSummaryCardRemainingAmt);
	}

	public void selectAndEnterAmount(String otherAmount) {
		validateNew(otherAmountRadioButton);
		otherAmountRadioButton.click();
		sendkeysNew(otherAmountInput, otherAmount);
		System.out.println("User selected Other amount option and Entered amount : " + otherAmount);
	}

	public void selectCreditCardOption() {
		validateNew(creditcardRadioButton);
		creditcardRadioButton.click();
		System.out.println("User selects Credit Card Option");
	}

	public void selectCheckingAccountOption() {
		validate(CheckingAccountRadioButton);
		CheckingAccountRadioButton.click();
		System.out.println("User selects Checking Account Option");
	}

	public CreditCardUPGPage clickOnNextButton() {
		NextButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitforElementDisapper(By.xpath("//div[contains(@class,'loading-block')]"), 60);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Payment")) {
			System.out.println("Navigated to UPG Credit card page");
			return new CreditCardUPGPage(driver);
		} else {
			System.out.println("UPG is not displayed");
			return null;
		}
	}

	public PaymentFormPage clickContuineButton() {
		validate(otheramountfield);
		NextButton.click();
		System.out.println("User Click on Next button on one time page");
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, CheckingAccountInformationHeader, 45);
		if (validate(CheckingAccountInformationHeader)) {
			System.out.println("Navigated to EFT form page");
			return new PaymentFormPage(driver);
		} else {
			System.out.println("Form Page is not displayed");
			return null;
		}
	}
}
