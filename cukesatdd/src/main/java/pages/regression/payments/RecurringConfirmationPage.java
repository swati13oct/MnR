package pages.regression.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class RecurringConfirmationPage extends UhcDriver {

	@FindBy(xpath = "//div[@class='col-md-12']//h2//span")
	private WebElement RequestSubmittedHeader;

	@FindBy(xpath = "//a[normalize-space(text())='Make a One-Time Payment']")
	private WebElement MakeOneTimePaymentLink;

	@FindBy(xpath = "//span[contains(@class,'confirmation__number')]")
	private WebElement ConfirmationNumber;

	public RecurringConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void validateEFTRecurrVerification() {
		validate(ConfirmationNumber);
		System.out.println("Your Confimation Number is : " + ConfirmationNumber.getText());
	}

	public void validateCCRecurrVerification() {
		validate(ConfirmationNumber);
		System.out.println("Your Confimation Number is : " + ConfirmationNumber.getText());
	}

	@Override
	public void openAndValidate() {
		validate(MakeOneTimePaymentLink);
	}
}
