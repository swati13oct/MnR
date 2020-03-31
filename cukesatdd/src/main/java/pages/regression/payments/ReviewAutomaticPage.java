package pages.regression.payments;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	@FindBy(xpath = "//button[@class='btn btn--primary']")
	private WebElement AuthorizeMonthlyPaymentstButton;

	@FindBy(xpath = "//button[@class='btn btn--primary' and (text()='CONTINUE' or text()='Continue')]")
	private WebElement ContinueButton;

	@FindBy(id = "custom-page-title")
	private WebElement ReviewPageTitle;

	@FindBy(id = "termsAgree")
	private WebElement AgreeCheckBox;

	@FindBy(xpath = "//a[normalize-space(text())='Make a One-Time Payment']")
	private WebElement MakeOneTimePaymentLink;

	@FindBy(xpath = "//*[contains(text(),'Only one payment request')]")
	private WebElement OnlyOnePaymentRequestMessage;



	public ReviewAutomaticPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void PaymentsDataVerificationonReviewPage() {
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
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Authorize Monthly Payments button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Automatic Payments Request Submitted")) {
			System.out.println("User is on Confirmation Page for Recurring");
			return new RecurringConfirmationPage(driver);
		} else {
			System.out.println("Confirmation Page for Recurring not displayed");
			return null;
		}
	}

	public RecurringConfirmationPage selectAgreeAndClickOnContinueforCC() {
		validate(ChangeCard);
		System.out.println("User is on Review Review Your Automatic Payments Information Page");
		PaymentsDataVerificationonReviewPage();
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Contuine button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Your Automatic Payments")) {
			System.out.println("User is on Confirmation Page for Recurring");
			return new RecurringConfirmationPage(driver);
		} else {
			System.out.println("Confirmation Page for Recurring not displayed");
			return null;
		}
	}
	
	
	public RecurringConfirmationPage selectAgreeAndClickOnContinueforEFTForShip() {
		validate(EditPaymentInformation);
		PaymentsDataVerificationonReviewPage();
		System.out.println("User is on Payment Method Update Page");
		System.out.println("Going to scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Contuine button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Your Updated Payment Method")) {
			System.out.println("User is on Confirmation Page for Update Recurring for ship");
			return new RecurringConfirmationPage(driver);
		} else {
			System.out.println("Confirmation Page for Update not displayed for ship");
			return null;
		}
	}

	@Override
	public void openAndValidate() {
		validate(ReviewPageTitle);
		if (ReviewPageTitle.getText().contains("Review Recurring Payments")) {
			System.out.println("User is on Review Recurring Payments Page");

		}

	}
	
	/**
	 * Member Auth Payments - Error Validation
	 * @author sdwaraka
	 * @param errorMessageExpected
	 * @return
	 */
	
	@FindBy(id = "memAuthPaymentCancelSubmitError")
	private WebElement CSR_Error_Message;

	public boolean Validate_Error_selectAgreeAndClickOnMakePayment(String errorMessageExpected) {
		validate(ChangeCard);
		System.out.println("User is on Review Recurring Paymenst Page");
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		try {
			Thread.sleep(20000);
			System.out.println(driver.getCurrentUrl());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Expected Member Auth Error Message  : "+errorMessageExpected);

		if(validate(CSR_Error_Message) && CSR_Error_Message.getText().contains(errorMessageExpected)){
			System.out.println("Expected Member Auth Error Message is displayed : "+CSR_Error_Message.getText());
			return true;
		}
		return false;
	}

	public boolean validate_onlyOnePaymentRequest_Message() {

		// TODO Auto-generated method stub
		if(validate(OnlyOnePaymentRequestMessage)){
			System.out.println("Only one payment request message displayed :  ===>  "+OnlyOnePaymentRequestMessage.getText());
			return true;
		}
		return false;
	}


}
