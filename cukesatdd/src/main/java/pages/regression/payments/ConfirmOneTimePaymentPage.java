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

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ConfirmOneTimePaymentPage extends UhcDriver {

	@FindBy(xpath = "//span[contains(@class,'confirmation__number')]")
	private WebElement ConfirmationNumber;

	@FindBy(id = "termError")
	private WebElement TermsCheckRadioButton;
	
	@FindBy(xpath = "//*[@id='custom-page-sub-title']")
	private WebElement thankyouText;
	
	@FindBy(xpath = "(.//*[@class='btn btn--primary'])[2]")
	private WebElement SubmitPaymentButton;

	@FindBy(xpath = "(.//*[@class='btn btn--primary'])[1]")
	private WebElement SubmitNewPaymentRevButton;

	@FindBy(xpath = "(.//*[@class='btn btn--primary disabled']")
	private WebElement MemAuthSubmitPaymentButton;

	@FindBy(xpath = "//button[@class='btn btn--primary' and contains(text(),'submit')]")
	private WebElement MemAuthSubmitPaymentButtonDisabled;

	@FindBy(xpath = "//*[@class='message-block-header']/span")
	private WebElement SuccessPay;

	@FindBy(xpath = "//*[@class='parsys overview']//div[@class='row'][1]//div[@ng-if='models.submitAutomaticFailure']/p[2]")
	private WebElement OneTimePaymentError;

	@FindBy(xpath = "//*[@ng-click='backToPaymentHistoryPage()']")
	private WebElement BackToPaymentHistoryPage;

	@FindBy(xpath = "//*[@id='nav']/button[2]")
	private WebElement iPerceptionAutoPopUp;

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

	@FindBy(xpath = "//a[normalize-space(text())='Make a One-Time Payment']")
	private WebElement MakeOneTimePaymentLink;

	@FindBy(xpath = "//*[contains(text(),'Only one payment request')]")
	private WebElement OnlyOnePaymentRequestMessage;

	public ConfirmOneTimePaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void PaymentsDataVerificationonConfirmationPage()
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

	public OneTimePaymentSuccessPage confirmsPayment() {

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		TermsCheckRadioButton.click();
		System.out.println("Terms and conditions radio button clicked");
		if (SubmitPaymentButton.isEnabled())
			SubmitPaymentButton.click();
		System.out.println("Submit Payment Button clicked");
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("overview")) {
			System.out.println("Title matched");
			OneTimePaymentSuccessPage oneTimePaymentSuccessAarpPage = new OneTimePaymentSuccessPage(driver);
			if (!(oneTimePaymentSuccessAarpPage.getContent()
					.contains("Only one payment request can be submitted per business day"))
					&& !(oneTimePaymentSuccessAarpPage.getContent()
							.contains("Due to a system error, your request cannot be processed at this time"))) {
				return oneTimePaymentSuccessAarpPage;
			} else {
				System.out.println("ERROR in Confirming Payments");
			}
		}
		return null;
	}

	public ConfirmOneTimePaymentPage confirmsAutoPayment() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("In Confirm auto pay method");
		Thread.sleep(2000);

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}
		waitforElement(TermsCheckRadioButton);
		TermsCheckRadioButton.click();
		System.out.println("Terms and conditions radio button clicked");
		Thread.sleep(2000);
		if (SubmitPaymentButton.isEnabled())
			SubmitPaymentButton.click();
		System.out.println("Submit Payment Button clicked");
		Thread.sleep(2000);
		CommonUtility.checkPageIsReady(driver);
		Thread.sleep(5000);
		if (driver.getTitle().equalsIgnoreCase("overview") || driver.getTitle().equalsIgnoreCase("Premium Payments")
				|| driver.getTitle().equalsIgnoreCase("AARP Medicare Plans from UnitedHealthCare - Premium Payments")) {
			System.out.println("Title matched");
			Thread.sleep(8000);
		}
		try {
			if (SuccessPay.getText().contains("Thank you for your payment")) {
				System.out.println("Payment Success Page Reached");
				return new ConfirmOneTimePaymentPage(driver);
			} else if (OneTimePaymentError.getText()
					.contains("only one payment request can be submitted per business day")) {
				System.out.println("Payment error message dispayed");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Payment success page not displayed");
		}
		return new ConfirmOneTimePaymentPage(driver);
	}

	public ConfirmOneTimePaymentPage confirmsNewOTPPayment() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("In new Review method");
		Thread.sleep(2000);

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}
		waitforElement(TermsCheckRadioButton);
		TermsCheckRadioButton.click();
		System.out.println("Terms and conditions radio button clicked");
		Thread.sleep(2000);
		if (SubmitNewPaymentRevButton.isEnabled())
			SubmitNewPaymentRevButton.click();
		System.out.println("Submit Payment Button clicked");
		Thread.sleep(2000);
		CommonUtility.checkPageIsReady(driver);
		Thread.sleep(5000);
		if (driver.getTitle().equalsIgnoreCase("overview") || driver.getTitle().equalsIgnoreCase("Premium Payments")
				|| driver.getTitle().equalsIgnoreCase("AARP Medicare Plans from UnitedHealthCare - Premium Payments")) {
			System.out.println("Title matched");
			Thread.sleep(8000);
		}
		try {
			if (SuccessPay.getText().contains("Thank you for your payment")) {
				System.out.println("Payment Success Page Reached");
				return new ConfirmOneTimePaymentPage(driver);
			} else if (OneTimePaymentError.getText()
					.contains("only one payment request can be submitted per business day")) {
				System.out.println("Payment error message dispayed");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Payment success page not displayed");
		}
		return new ConfirmOneTimePaymentPage(driver);
	}

	public ConfirmOneTimePaymentPage MemAuthConfirmOTP() throws InterruptedException {

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		waitforElement(TermsCheckRadioButton);
		TermsCheckRadioButton.click();
		System.out.println("Terms and conditions radio button clicked");

		// NOTE: submit button is disabled but isEnabled() still return true,
		// check disable from ng-class attribute
		String ngClass = MemAuthSubmitPaymentButtonDisabled.getAttribute("ng-class");
		if (ngClass.contains("disabled")) {
			System.out.println("Submit Payment Button disabled");
			return new ConfirmOneTimePaymentPage(driver);
		} else {
			System.out.println("Submit Payment Button is enabled");
			return null;
		}

		/*
		 * tbd if(!(MemAuthSubmitPaymentButton.isEnabled())) {
		 * System.out.println("Submit Payment Button disabled"); return new
		 * ConfirmOneTimePaymentPage(driver); } else { System.out.println(
		 * "Submit Payment Button is enabled"); return null; }
		 */

	}

	public PaymentHistoryPage ScrollDownToBackButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)", "");
		if (BackToPaymentHistoryPage.isDisplayed()) {
			System.out.println("Now clicking on Back to Payment History button on confirmation page");
			BackToPaymentHistoryPage.click();
			System.out.println("Back to Payment history button has been clicked");
			return new PaymentHistoryPage(driver);
		} else
			return null;
	}

	public ConfirmOneTimePaymentPage ValidateAutoPaymentButton() throws InterruptedException {

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		waitforElement(TermsCheckRadioButton);
		TermsCheckRadioButton.click();
		System.out.println("Terms and conditions radio button clicked");
		try {
			if (!(SubmitPaymentButton.isEnabled())) {
				System.out.println("Submit Payment Button is dsabled as expected");
				return new ConfirmOneTimePaymentPage(driver);
			} else
				return null;
		} catch (Exception e) {
			System.out.println("Submit Payment button not loaded");
			return null;
		}

	}

	public void OneTimeCCverification() {


			validate(ConfirmationNumber);
			PaymentsDataVerificationonConfirmationPage();
			System.out.println("Your Confimation Number is : " + ConfirmationNumber.getText());

	}
	
	public void OneTimeEFTverification() {
		validate(ConfirmationNumber);
		PaymentsDataVerificationonConfirmationPage();
		System.out.println("Your Confimation Number is : " + ConfirmationNumber.getText());
		String verifyConfirmationNumberPresent = ConfirmationNumber.getText();
		if(verifyConfirmationNumberPresent != null)
		{
			System.out.println("Confirmation number was displayed, Test Case is Passed");
		    Assert.assertTrue(true);
		}
		else
		{
			Assert.fail("Confirmation Number was not dispalyed, Test Case if failed");
		}
	}

	
	public void validateEFTSetupVerificationforShip() {
		validate(MakeOneTimePaymentLink);
		PaymentsDataVerificationonConfirmationPage();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Recurring Payments Request Submitted")) {
			System.out.println("User is on Confirmation Page for Setup Recurring for ship");
			} else 
			{
			System.out.println("Confirmation Page for setup recurring not displayed for ship");
			Assert.fail("Confirmation Page for setup recurring not displayed for ship");
			}
		System.out.println("User has sucessfully setup recurring payment for Ship EFT");
	}
	
	@Override
	public void openAndValidate() {
		System.out.println("Openandvalidate method of ConfirmOneTimePaymentPage");
		
	}

}
