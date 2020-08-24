package pages.regression.guestPayments;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Strings;
import com.itextpdf.text.log.SysoCounter;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ReviewOneTimePaymentPage extends UhcDriver {

	@FindBy(xpath = "//button[text()='CHANGE CARD']")
	private WebElement ChangeCard;

	@FindBy(xpath = "//button[text()='MAKE PAYMENT']")
	private WebElement MakePaymentButton;

	@FindBy(xpath = "//div[@class='col-md-12']/button[@class='btn btn--primary']")
	private WebElement ContinueButton;

	@FindBy(id = "termsAgree")
	private WebElement AgreeCheckBox;

	@FindBy(id = "custom-page-title")
	private WebElement confirmPageHeader;

	@FindBy(xpath = "//*[contains(text(),'Only one payment request')]")
	private WebElement OnlyOnePaymentRequestMessage;
	
	public ReviewOneTimePaymentPage(WebDriver driver) {
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

	public ConfirmOneTimePaymentPage selectAgreeAndClickOnMakePayment() {
		validate(ChangeCard);
		System.out.println("User is on Review one Time CC Page");
		PaymentsDataVerificationonReviewPage();
		jsClickNew(AgreeCheckBox);
		ContinueButton.click();
		try {
			Thread.sleep(20000);
			System.out.println(driver.getCurrentUrl());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.getTitle().contains("One-Time Payment Submitted")) {
			System.out.println("User is on Confirmation Page");
			return new ConfirmOneTimePaymentPage(driver);
		} else {

			System.out.println("User is not on Confirmation Page");
			return null;
		}
	}

	@Override
	public void openAndValidate() {
		validate(ChangeCard);

	}
	

/**
 * Member Auth Payments - Error Validation
 * @author sdwaraka
 * @param errorMessageExpected
 * @return
 */
	@FindBy(id = "memAuthPaymentSubmitError")
	private WebElement CSR_Error_Message;
	
	public boolean Validate_Error_selectAgreeAndClickOnMakePayment(String errorMessageExpected) {
		validate(ChangeCard);
		System.out.println("User is on Review one Time CC Page");
		jsClickNew(AgreeCheckBox);
		ContinueButton.click();
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

		public ConfirmOneTimePaymentPage DoNotselectAgreeAndClickOnMakePayment() {
		validate(ChangeCard);
		System.out.println("User is on Review one Time CC Page");
		PaymentsDataVerificationonReviewPage();		
		validate(ContinueButton);		
		try {
			Thread.sleep(20000);
			System.out.println(driver.getCurrentUrl());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		if (driver.getTitle().contains("One-Time Payment Information")) {
			System.out.println("User is on Confirmation Page");
			return new ConfirmOneTimePaymentPage(driver);
		} else {

			System.out.println("User is not on Confirmation Page");
			return null;
		}
	}

}
