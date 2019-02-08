package pages.regression.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class UpdateReviewPage extends UhcDriver {

	@FindBy(xpath = "//button[text()='Edit Payment Information']")
	private WebElement EditPaymentInformation;

	@FindBy(xpath = "//button[text()='CHANGE CARD']")
	private WebElement ChangeCard;

	@FindBy(xpath = "//button[text()='Authorize Monthly Payments']")
	private WebElement AuthorizeMonthlyPaymentstButton;

	@FindBy(xpath = "//button[text()='CONTINUE' or text()='Continue']")
	private WebElement ContinueButton;

	@FindBy(id = "custom-page-title")
	private WebElement ReviewPageTitle;

	@FindBy(id = "termsAgree")
	private WebElement AgreeCheckBox;

	@FindBy(xpath = "//a[normalize-space(text())='Make a One-Time Payment']")
	private WebElement MakeOneTimePaymentLink;

	public UpdateReviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public UpdateConfirmationPage selectAgreeAndClickOnContinueforEFT() {
		validate(EditPaymentInformation);
		System.out.println("User is on Payment Method Update Page");
		jsClickNew(AgreeCheckBox);
		ContinueButton.click();
		System.out.println("Clicked on Continue button");
		if (validate(MakeOneTimePaymentLink)) {
			System.out.println("User is on Confirmation Page for Update Recurring");
			return new UpdateConfirmationPage(driver);
		} else
			return null;
	}

	public UpdateConfirmationPage selectAgreeAndClickOnContinueforCC() {
		validate(ChangeCard);
		System.out.println("User is on Payment Method Update Page");
		jsClickNew(AgreeCheckBox);
		ContinueButton.click();
		System.out.println("Clicked on Contuine button");
		if (validate(MakeOneTimePaymentLink)) {
			System.out.println("User is on Confirmation Page for Update Recurring");
			return new UpdateConfirmationPage(driver);
		} else
			return null;
	}

	@Override
	public void openAndValidate() {
		validate(ReviewPageTitle);
		if (ReviewPageTitle.getText().contains("Review Payment Method Update")) {
			System.out.println("User is on Review Payment Method Update Page");
		}else{
			System.out.println("User is unable to navigate to Review Payment Method Update Page");
		}

	}

}
