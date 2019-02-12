package pages.regression.payments;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Strings;

import atdd.framework.UhcDriver;

public class ReviewAutomaticPage extends UhcDriver {

	@FindBy(xpath = "//button[text()='Edit Payment Information']")
	private WebElement EditPaymentInformation;

	@FindBy(xpath = "//button[text()='CHANGE CARD']")
	private WebElement ChangeCard;

	@FindBy(xpath = "//button[text()='Authorize Monthly Payments']")
	private WebElement AuthorizeMonthlyPaymentstButton;

	@FindBy(xpath = "//button[@class='btn btn--primary' and (text()='CONTINUE' or text()='Continue')]")
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

	
	public void PaymentsDataVerificationonReviewPage()
	{
		List<WebElement> rowsList = driver.findElements(By.xpath("//div[@class='table-body-row']"));
		List<WebElement> columnsList = null;
		for (WebElement row : rowsList) {
			System.out.println();
			columnsList = row.findElements(By.tagName("div"));

			for (WebElement column : columnsList) {
				System.out.print(column.getText() + " - ");
				if ((Strings.isNullOrEmpty(column.getText()))) {
					Assert.fail("Coloumn Header or value is null");
				}
			}
		}
	}
	
	public RecurringConfirmationPage selectAgreeAndClickOnAuthorizeMonthyPaymentsforEFT() {
		validate(EditPaymentInformation);
		System.out.println("User is on Review Review Your Automatic Payments Information Page");
		PaymentsDataVerificationonReviewPage();
		jsClickNew(AgreeCheckBox);
		ContinueButton.click();
		System.out.println("Clicked on Authorize Monthly Payments button");
		if (validate(MakeOneTimePaymentLink)) {
			System.out.println("User is on Confirmation Page for Recurring");
			return new RecurringConfirmationPage(driver);
		} else
			return null;
	}

	public RecurringConfirmationPage selectAgreeAndClickOnContinueforCC() {
		validate(ChangeCard);
		System.out.println("User is on Review Review Your Automatic Payments Information Page");
		PaymentsDataVerificationonReviewPage();
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
