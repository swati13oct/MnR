package pages.regression.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class UpdateRecurringPage extends UhcDriver {

	@FindBy(xpath = "//h2[text()='Helpful Reminders']")
	private WebElement HelpfulRemindersPanel;

	@FindBy(id = "optionsRadios10")
	private WebElement CheckingAccountRadioButton;

	@FindBy(id = "optionsRadios20")
	private WebElement CreditDebitRadioButton;
	
	@FindBy(id = "optionsRadios30")
	private WebElement CancelPaymentRadioBtn;
	

	@FindBy(xpath = "//button[text()='Next']")
	private WebElement NextButton;

	@FindBy(xpath = "//button[text()='Back To Overview']")
	private WebElement BackToOverviewButton;

	@FindBy(xpath = "//p[text()='Checking Account Information']")
	private WebElement CheckingAccountInformationHeader;
	
	@FindBy(xpath = "//p[text()='Checking Account Information']")
	private WebElement ReviewStopRecurringPageHeading;
	
	@FindBy(xpath = "//div[@class='col-md-12']//h1")
	private WebElement UpdateReviewPageHeading;	

	@FindBy(id = "div_cardInfo")
	private WebElement EnterCreditInfo;

	public UpdateRecurringPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public PaymentsFormPage selectCheckingAccountAndClickOnNext() {
		validate(HelpfulRemindersPanel);
		System.out.println("User is on Update Automatic Recurring Page");
		CheckingAccountRadioButton.click();
		System.out.println("clicked on Checking account radio button");
		NextButton.click();
		System.out.println("clicked on Next button");
		if (validate(CheckingAccountInformationHeader)) {
			System.out.println("User is on Form Page for EFT");
			return new PaymentsFormPage(driver);
		} else
			return null;
	}

	public CreditCardUPGPage selectCCAndClickOnNext() {
		validate(HelpfulRemindersPanel);
		System.out.println("User is on setup Automatic Recurring Page");
		CreditDebitRadioButton.click();
		System.out.println("clicked on Credit/Debit radio button");
		NextButton.click();
		System.out.println("clicked on Next button");
		if (validate(EnterCreditInfo)) {
			System.out.println("User is on UPG Page");
			return new CreditCardUPGPage(driver);
		} else
			return null;
	}
	
	public UpdateReviewPage selectStopRecurringClickOnNext() {
		validate(HelpfulRemindersPanel);
		System.out.println("User is on Update Automatic Recurring Page");
		CheckingAccountRadioButton.click();
		System.out.println("clicked on Checking account radio button");
		NextButton.click();
		System.out.println("clicked on Next button");
		waitforElement(UpdateReviewPageHeading);
		if (validate(UpdateReviewPageHeading)) {
			System.out.println("User is on Update Review Page for ship");
			return new UpdateReviewPage(driver);
		} else
			return null;
	}

	
	public UpdateReviewPage selectCancelAutomaticPaymentsAndClicksNext() {
		validate(HelpfulRemindersPanel);
		System.out.println("User is on Update Automatic Recurring Page");
		CancelPaymentRadioBtn.click();
		System.out.println("clicked on Cancel Payment radio button");
		NextButton.click();
		System.out.println("clicked on Next button");
		waitforElement(UpdateReviewPageHeading);
		if (validate(UpdateReviewPageHeading)) {
			System.out.println("User is on Review Page");
			return new UpdateReviewPage(driver);
		} else
			return null;
	}
	@Override
	public void openAndValidate() {
		validate(HelpfulRemindersPanel);

	}
}
