package pages.regression.guestPayments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

	@FindBy(xpath = "//h1[contains(text(),'Payment Submitted')]")
	private WebElement confirmationPageHeader;

	@FindBy(xpath = "//h2[contains(text(),'Thanks')]")
	private WebElement thankyouPaymentmessage;

	@FindBy(xpath = "//p[contains(text(),'confirmation email')]")
	private WebElement staticContentBelowHeader;

	@FindBy(xpath = "//label[contains(@for,'emailID')]")
	private WebElement emailAddressText;

	@FindBy(xpath = "//input[contains(@placeholder,'Input text')]")
	private WebElement emailTextField;

	@FindBy(xpath = "//button[contains(@class,'send-button-wrap')]")
	private WebElement sendEmailButton;

	@FindBy(xpath = "//h1[contains(text(),'recurring' )]")
	private WebElement signinIframeHeader;

	@FindBy(xpath = "//p[contains(text(),'Sign In” or “Register' )]")
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


	public boolean guestPaymentsValidate(WebElement element) {
		long timeoutInSec=0;
		return guestPaymentsValidate(element, timeoutInSec);
	} 
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean guestPaymentsValidate(WebElement element, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
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

		Assert.assertTrue("PROBLEM - unable to locate Header",guestPaymentsValidate(confirmationPageHeader));
		Assert.assertTrue("PROBLEM - unable to locate Thanks for your payment! message",guestPaymentsValidate(thankyouPaymentmessage));
		Assert.assertTrue("PROBLEM - unable to locate Body text below header",guestPaymentsValidate(staticContentBelowHeader));
		Assert.assertTrue("PROBLEM - unable to locate Email address for receipt text ",guestPaymentsValidate(emailAddressText));
		Assert.assertTrue("PROBLEM - unable to locate Email address text field",guestPaymentsValidate(emailTextField));
		Assert.assertTrue("PROBLEM - unable to locate send email Button",guestPaymentsValidate(sendEmailButton));
		Assert.assertTrue("PROBLEM - unable to locate Sign in Iframe Header",guestPaymentsValidate(signinIframeHeader));
		Assert.assertTrue("PROBLEM - unable to locate Body text below header",guestPaymentsValidate(signinIframeBodytext));
		Assert.assertTrue("PROBLEM - unable to locate Sign in Button",guestPaymentsValidate(signinButton));
		Assert.assertTrue("PROBLEM - unable to locate Register Now URL Link",guestPaymentsValidate(registerNowURL));
		Assert.assertTrue("PROBLEM - unable to locate Payment Receipt Header",guestPaymentsValidate(paymentReceiptHeader));
		Assert.assertTrue("PROBLEM - unable to locate Print receipt URL Link",guestPaymentsValidate(printReceiptURL));
		Assert.assertTrue("PROBLEM - unable to locate Plan name on receipt",guestPaymentsValidate(planNameonReceipt));
		Assert.assertTrue("PROBLEM - unable to locate Member name on receipt",guestPaymentsValidate(memberNameOnReceipt));
		Assert.assertTrue("PROBLEM - unable to locate Member ID on receipt",guestPaymentsValidate(idOnReceipt));
		Assert.assertTrue("PROBLEM - unable to locate Amount paid on receipt",guestPaymentsValidate(amountPaidOnReceipt));
		Assert.assertTrue("PROBLEM - unable to locate static text above Close Button",guestPaymentsValidate(textDescribingCloseButton));
		Assert.assertTrue("PROBLEM - unable to locate Close Button",guestPaymentsValidate(closeWindowButton));
		
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

		Assert.assertTrue("PROBLEM - unable to locate Success message for Email Receipt",guestPaymentsValidate(emailSuccessMessage));
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
