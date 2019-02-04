package pages.regression.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class ReviewAutomaticPage extends UhcDriver {

	@FindBy(xpath = "//button[text()='Edit Payment Information']")
	private WebElement EditPaymentInformation;

	@FindBy(xpath = "//button[text()='CHANGE CARD']")
	private WebElement ChangeCard;

	@FindBy(xpath = "//button[text()='Authorize Monthly Payments']")
	private WebElement AuthorizeMonthlyPaymentstButton;

	@FindBy(xpath = "//button[text()='CONTINUE']")
	private WebElement ContinueButton;

	@FindBy(id = "custom-page-title")
	private WebElement ReviewPageTitle;

	@FindBy(id = "termsAgree")
	private WebElement AgreeCheckBox;

	@FindBy(xpath = "//a[normalize-space(text())='Make a One-Time Payment']")
	private WebElement MakeOneTimePaymentLink;

	public ReviewAutomaticPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public RecurringConfirmationPage selectAgreeAndClickOnAuthorizeMonthyPaymentsforEFT() {
		validate(EditPaymentInformation);
		System.out.println("User is on Review Review Your Automatic Payments Information Page");
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Authorize Monthly Payments button");
		if (validate(MakeOneTimePaymentLink)) {
			System.out.println("User is on Confirmation Page for Recurring");
			return new RecurringConfirmationPage(driver);
		} else
			return null;
	}

	public RecurringConfirmationPage selectAgreeAndClickOnAuthorizeMonthyPaymentsforCC() {
		validate(ChangeCard);
		System.out.println("User is on Review Review Your Automatic Payments Information Page");
		jsClickNew(AgreeCheckBox);
		ContinueButton.click();
		System.out.println("Clicked on Contuine button");
		if (validate(MakeOneTimePaymentLink)) {
			System.out.println("User is on Confirmation Page for Recurring");
			return new RecurringConfirmationPage(driver);
		} else
			return null;
	}

	@Override
	public void openAndValidate() {
		validate(ReviewPageTitle);
		if (ReviewPageTitle.getText().contains("Review Recurring Payments")) {
			System.out.println("User is on Review Recurring Payments Page");

		}

	}

}
