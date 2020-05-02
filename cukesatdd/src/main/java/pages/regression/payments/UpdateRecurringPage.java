package pages.regression.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class UpdateRecurringPage extends UhcDriver {

	@FindBy(id = "custom-page-title")
	private WebElement PageTitle;

	@FindBy(xpath = "//h2[text()='Helpful Reminders']")
	private WebElement HelpfulRemindersPanel;

	@FindBy(id = "optionsRadios10")
	private WebElement CheckingAccountRadioButton;

	@FindBy(id = "optionsRadios20")
	private WebElement CreditDebitRadioButton;

	@FindBy(id = "optionsRadios30")
	private WebElement CancelPaymentRadioBtn;
	
	@FindBy(xpath = "//label[@for='optionsRadios30' and not(attribute::class)]")
	private WebElement CanceltRadioBtnShip;

	@FindBy(xpath = "//button[@class='btn btn--primary payment-selection__btn']")
	private WebElement NextButton;

	@FindBy(xpath = "//button[text()='Back To Overview']")
	private WebElement BackToOverviewButton;

	@FindBy(xpath = "//*[text()='Checking Account Information']")
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
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("User is on Update Automatic Payments Page");
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

		System.out.println("User is on setup Automatic Recurring Page");
		CreditDebitRadioButton.click();
		System.out.println("clicked on Credit/Debit radio button");
		NextButton.click();
		System.out.println("clicked on Next button");

		try {
			Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Payment")) {
			System.out.println("Navigated to UPG Credit card page");
			return new CreditCardUPGPage(driver);
		} else {
			System.out.println("UPG is not displayed");
			return null;
		}
	}

	public UpdateReviewPage selectStopRecurringClickOnNextforShip() {
		System.out.println("User is on Update Automatic Recurring Page");
		CanceltRadioBtnShip.click();
		System.out.println("clicked on Checking account radio button");
		NextButton.click();
		System.out.println("clicked on Next button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Cancel Recurring Payments")) {
			System.out.println("Navigated to Cancel Recurring Payments page");
			return new UpdateReviewPage(driver);
		} else {
			System.out.println("Cancel Recurring Payments not displayed");
			return null;
		}
	}

	public UpdateReviewPage selectCancelAutomaticPaymentsAndClicksNext() {
		System.out.println("User is on Update Automatic Recurring Page");
		CancelPaymentRadioBtn.click();
		System.out.println("clicked on Cancel Payment radio button");
		NextButton.click();
		System.out.println("clicked on Next button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Cancel Automatic Payments")) {
			System.out.println("Navigated to Cancel Automatic Payments page");
			return new UpdateReviewPage(driver);
		} else {
			System.out.println("Cancel Automatic Payments not displayed");
			return null;
		}
	}

	@Override
	public void openAndValidate() {
		validate(PageTitle);
		if (PageTitle.getText().contains("Update Automatic Payments")) {
			System.out.println("User is on Update Automatic Payments Page");
		} else {
			System.out.println("User is unable to navigate to Update Automatic Payments Page");
		}

	}
}
