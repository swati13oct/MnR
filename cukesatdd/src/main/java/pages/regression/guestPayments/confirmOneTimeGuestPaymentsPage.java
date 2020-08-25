package pages.regression.guestPayments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
		
		

		
	}



}
