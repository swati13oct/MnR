package pages.regression.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class SetUpRecurringPage extends UhcDriver {

	@FindBy(xpath = "//h2[text()='Helpful Reminders']")
	private WebElement HelpfulRemindersPanel;

	@FindBy(id = "optionsRadios10")
	private WebElement CheckingAccountRadioButton;

	@FindBy(id = "optionsRadios20")
	private WebElement CreditDebitRadioButton;

	@FindBy(xpath = "//div[@class='payment-selection__actions']//button[contains(@class,'btn btn--primary')]")
	private WebElement NextButton;

	@FindBy(xpath = "//button[text()='Back To Overview']")
	private WebElement BackToOverviewButton;

	@FindBy(xpath = "//p[text()='Checking Account Information']")
	private WebElement CheckingAccountInformationHeader;

	@FindBy(id = "div_cardInfo")
	private WebElement EnterCreditInfo;

	@FindBy(id = "routing-number")
	private WebElement RoutingNumberField;
	public SetUpRecurringPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public PaymentsFormPage selectCheckingAccountAndClickOnNext() {
		CheckingAccountRadioButton.click();
		System.out.println("clicked on Checking account radio button");
		NextButton.click();
		System.out.println("clicked on Next button");
		if (validate(RoutingNumberField)) {
			System.out.println("User is on Form Page for EFT");
			return new PaymentsFormPage(driver);
		} else
			return null;
	}

	public CreditCardUPGPage selectCCAndClickOnNext() {
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

	@Override
	public void openAndValidate() {
		if (driver.getTitle().contains("Set Up Automatic Payments")) {
			System.out.println("Set Up Automatic Payments page");
		} else
			System.out.println("Set Up Automatic Payments not displayed");
	}
}
