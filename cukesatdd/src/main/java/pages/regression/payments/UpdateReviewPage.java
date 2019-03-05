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
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import atdd.framework.UhcDriver;

public class UpdateReviewPage extends UhcDriver {

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

	@FindBy(xpath = "//div[@class='col-md-12']//h1")
	private WebElement ConfirmationPageHeading;

	public UpdateReviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void PaymentsDataVerificationOnUpdateReviewPage() {
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

	public UpdateConfirmationPage selectAgreeAndClickOnContinueforEFT() {
		validate(EditPaymentInformation);
		System.out.println("User is on Payment Method Update Page");
		PaymentsDataVerificationOnUpdateReviewPage();
		System.out.println("Going to scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Continue button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Recurring Payments Request Submitted")) {
			System.out.println("Navigated to Recurring Payments Request Submitted page");
			return new UpdateConfirmationPage(driver);
		} else {
			System.out.println("Recurring Payments Request Submitted not displayed");
			return null;
		}
	}

	public UpdateConfirmationPage selectAgreeAndClickOnContinueforCC() {
		validate(ChangeCard);
		System.out.println("User is on Payment Method Update Page");
		PaymentsDataVerificationOnUpdateReviewPage();
		System.out.println("Going to scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Contuine button");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Your Updated Payment Method")) {
			System.out.println("User is on Confirmation Page for Update Recurring");
			return new UpdateConfirmationPage(driver);
		} else {
			System.out.println("Confirmation Page for Update not displayed");
			return null;
		}
	}

	public UpdateConfirmationPage selectAgreeAndClickOnContinueforEFTForShip() {
		validate(EditPaymentInformation);
		PaymentsDataVerificationOnUpdateReviewPage();
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
			return new UpdateConfirmationPage(driver);
		} else {
			System.out.println("Confirmation Page for Update not displayed for ship");
			return null;
		}
	}

	public UpdateConfirmationPage selectAgreeAndClickOnContinueforStopForShip() {
		System.out.println("User is on Cancel recurring Page for ship");
		PaymentsDataVerificationOnUpdateReviewPage();
		System.out.println("Going to scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Continue button");
		if (driver.getTitle().contains("Cancel Recurring Payments")) {
			System.out.println("User is on Cancel Recurring Payments Confirmation Page for Update Recurring");
			return new UpdateConfirmationPage(driver);
		} else {
			System.out.println("Cancel Recurring Payments Confirmation Page for Update Recurring not displayed");
			return null;
		}
	}

	public UpdateConfirmationPage selectAgreeAndClickOnContinueforStopRecurringForFed() {
		System.out.println("User is on Payment Method Update Page");
		PaymentsDataVerificationOnUpdateReviewPage();
		System.out.println("Going to scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Continue button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Cancel Automatic Payments")) {
			System.out.println("User is on Cancel Automatic Payments Confirmation Page for Update Recurring");
			return new UpdateConfirmationPage(driver);
		} else {
			System.out.println("Cancel Automatic Payments Confirmation Page for Update Recurring not displayed");
			return null;
		}
	}

	@Override
	public void openAndValidate() {
		validate(ReviewPageTitle);
		if (ReviewPageTitle.getText().contains("Review Payment Method Update")) {
			System.out.println("User is on Review Payment Method Update Page");
		} else if (ReviewPageTitle.getText().contains("Cancel Automatic Payments")) {
			System.out.println("User is on Cancel Automatic Payments Page");
		} else if (ReviewPageTitle.getText().contains("Cancel Recurring Payments")) {
			System.out.println("User is on Cancel Recurring Payments for ship");
		} else {
			System.out.println("User is unable to navigate to Review Payment Method Update Page");
		}

	}

}
