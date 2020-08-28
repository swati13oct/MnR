package pages.regression.guestPayments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Strings;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.login.HSIDLoginPage;

/**
 * @author akapoo18
 *
 */
public class confirmOneTimeGuestPaymentsPage extends UhcDriver {

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

	@FindBy(xpath = " //h1[@id='custom-page-title']")
	private WebElement ConfirmationText; 

	@FindBy(xpath = "//div[contains(@class,'payment-confirm-table')]//div[contains(@class,'table-body-row')]")
	private List<WebElement> paymentConfirmRows;
	
	@FindBy(xpath = "//div[contains(@class,'confirmationText')]//*[contains(@class,'confirmation__number')][string-length(text())=9]")
	private WebElement confirmationNumber;

	@FindBy(xpath = "")
	private WebElement confirmationPageHeader;

	@FindBy(xpath = "")
	private WebElement thankyouPaymentmessage;

	@FindBy(xpath = "")
	private WebElement staticContentBelowHeader;

	@FindBy(xpath = "")
	private WebElement emailAddressText;

	@FindBy(xpath = "")
	private WebElement emailTextField;

	@FindBy(xpath = "")
	private WebElement sendEmailButton;

	@FindBy(xpath = "")
	private WebElement signinIframeHeader;

	@FindBy(xpath = "")
	private WebElement signinIframeBodytext;

	@FindBy(xpath = "")
	private WebElement signinButton;

	@FindBy(xpath = "")
	private WebElement registerNowURL;

	@FindBy(xpath = "")
	private WebElement paymentReceiptHeader;

	@FindBy(xpath = "")
	private WebElement printReceiptURL;

	@FindBy(xpath = "")
	private WebElement planNameonReceipt;

	@FindBy(xpath = "")
	private WebElement memberNameOnReceipt;

	@FindBy(xpath = "")
	private WebElement idOnReceipt;

	@FindBy(xpath = "")
	private WebElement amountPaidOnReceipt;

	@FindBy(xpath = "")
	private WebElement textDescribingCloseButton;

	@FindBy(xpath = "")
	private WebElement closeWindowButton;

	@FindBy(xpath = "")
	private WebElement emailSuccessMessage;

	@FindBy(xpath = "")
	private WebElement anotherEmailReceipt;

	@FindBy(xpath = "")
	private WebElement cancelButton;

	public confirmOneTimeGuestPaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		try {
			openAndValidate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void openAndValidate() throws InterruptedException {
	
		
	}

	public void PaymentsDataVerificationonConfirmationPage()
	{
		List<WebElement> columnsList = null;
		for (WebElement row : paymentConfirmRows) {
			System.out.println();
			columnsList = row.findElements(By.tagName("div"));

			for (WebElement column : columnsList) {
				System.out.print(column.getText() + " - ");
				if ((Strings.isNullOrEmpty(column.getText()))) {
					Assert.fail(">>>>>>>Column Header or value is Null in the payments Receipt table on the Payments confirmation page<<<<<<<<<");
				}
			}
		}
	}

	public void validatePaymentConfirmationPage() {

		Assert.assertTrue("PROBLEM - unable to locate Header",confirmOneTimeGuestPaymentsPage(confirmationPageHeader));
		Assert.assertTrue("PROBLEM - unable to locate Thanks for your payment! message",confirmOneTimeGuestPaymentsPage(thankyouPaymentmessage));
		Assert.assertTrue("PROBLEM - unable to locate Body text below header",confirmOneTimeGuestPaymentsPage(staticContentBelowHeader));
		Assert.assertTrue("PROBLEM - unable to locate Email address for receipt text ",confirmOneTimeGuestPaymentsPage(emailAddressText));
		Assert.assertTrue("PROBLEM - unable to locate Email address text field",confirmOneTimeGuestPaymentsPage(emailTextField));
		Assert.assertTrue("PROBLEM - unable to locate send email Button",confirmOneTimeGuestPaymentsPage(sendEmailButton));
		Assert.assertTrue("PROBLEM - unable to locate Sign in Iframe Header",confirmOneTimeGuestPaymentsPage(signinIframeHeader));
		Assert.assertTrue("PROBLEM - unable to locate Body text below header",confirmOneTimeGuestPaymentsPage(signinIframeBodytext));
		Assert.assertTrue("PROBLEM - unable to locate Sign in Button",confirmOneTimeGuestPaymentsPage(signinButton));
		Assert.assertTrue("PROBLEM - unable to locate Register Now URL Link",confirmOneTimeGuestPaymentsPage(registerNowURL));
		Assert.assertTrue("PROBLEM - unable to locate Payment Receipt Header",confirmOneTimeGuestPaymentsPage(paymentReceiptHeader));
		Assert.assertTrue("PROBLEM - unable to locate Print receipt URL Link",confirmOneTimeGuestPaymentsPage(printReceiptURL));
		Assert.assertTrue("PROBLEM - unable to locate Plan name on receipt",confirmOneTimeGuestPaymentsPage(planNameonReceipt));
		Assert.assertTrue("PROBLEM - unable to locate Member name on receipt",confirmOneTimeGuestPaymentsPage(memberNameOnReceipt));
		Assert.assertTrue("PROBLEM - unable to locate Member ID on receipt",confirmOneTimeGuestPaymentsPage(idOnReceipt));
		Assert.assertTrue("PROBLEM - unable to locate Amount paid on receipt",confirmOneTimeGuestPaymentsPage(amountPaidOnReceipt));
		Assert.assertTrue("PROBLEM - unable to locate static text above Close Button",confirmOneTimeGuestPaymentsPage(textDescribingCloseButton));
		Assert.assertTrue("PROBLEM - unable to locate Close Button",confirmOneTimeGuestPaymentsPage(closeWindowButton));
		
	}

	public confirmOneTimeGuestPaymentsPage enterEmailAndClickSend(String emailAddress) {

		System.out.println(">>>>>>>>>>>>Entering Email address<<<<<<<<<<<<<<<<<<<");
		emailTextField.sendKeys(emailAddress);

		sendEmailButton.click();
		System.out.println(">>>>>>>Send button clicked<<<<<<<");

		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, confirmationPageHeader, 45);

		if (driver.getTitle().contains("Confirm")) {
			System.out.println(">>>>>>>>>>Confirm Payments page is displayed<<<<<<<<<<");
			return new confirmOneTimeGuestPaymentsPage(driver);
		} else {
				System.out.println(">>>>>>>>>Confirm Payments page is not displayed<<<<<<<<<<");
				return null;
		}

	}

	public void emailSuccessAndClickEnterAnotherEmail() {

		Assert.assertTrue("PROBLEM - unable to locate Success message for Email Receipt",confirmOneTimeGuestPaymentsPage(emailSuccessMessage));
		System.out.println(">>>>>>>>>Email Receipt Success Message Displayed<<<<<<<<<<");

		anotherEmailReceipt.click();
		System.out.println(">>>>>>>>Another Email Receipt Link clicked<<<<<<<<<<<");

		validatePaymentConfirmationPage();

	}

	public void clickOnSignInLink() {

		signinButton.click();
		System.out.println(">>>>>>Sign In button is clicked<<<<<<");

		if (driver.getTitle().contains("medicare.uhc.com")) {
			System.out.println(">>>>>>>>User Navigated Member Sign In Page<<<<<<<<<<<");
		} else {
			System.out.println(">>>>>>>>>Member Sign In Page is not displayed<<<<<<<<<<");
		}

	}

	public void clickOnRegisterNowLink() {

		registerNowURL.click();
		System.out.println(">>>>>>Register Now Link is clicked<<<<<<");

		if (driver.getTitle().contains("Register")) {
			System.out.println(">>>>>>>>User Navigated Member Register Now Page<<<<<<<<<<<");
		} else {
			System.out.println(">>>>>>>>>Register Now Page is not displayed<<<<<<<<<<");
		}

	}

	public void clickAndValidatePrintReceiptLink() {

		printReceiptURL.click();
		CommonUtility.waitForPageLoadNew(driver, confirmationPageHeader, 45);
		System.out.println(">>>>>>Print Payment receipt Link is clicked<<<<<<");

		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(newTab.size());
		//note: Use the list of window handles to switch between windows
		driver.switchTo().window(newTab.get(newTab.size()-1));
		CommonUtility.checkPageIsReady(driver);

		String pdfUrl = driver.getCurrentUrl();
		System.out.println(" pdf url: '" + pdfUrl+"'");
		Assert.assertTrue("PROBLEM - actual URL doesn't contain '.pdf'.  Actual URL='"+pdfUrl+"'", pdfUrl.contains(".pdf"));

//		if (driver.getTitle().contains("Print Receipt")) {
//			System.out.println(">>>>>>>>User Navigated on Print pdf receipt Page<<<<<<<<<<<");
//		}
		cancelButton.click();

		if (driver.getTitle().contains("Confirm")) {
			System.out.println(">>>>>>>>>>Confirm Payments page is displayed<<<<<<<<<<");

		} else {
			System.out.println(">>>>>>>>>Confirm Payments page is not displayed<<<<<<<<<<");

		}

	}
}
