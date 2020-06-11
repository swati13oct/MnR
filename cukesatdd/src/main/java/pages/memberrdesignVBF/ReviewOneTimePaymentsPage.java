/**
 * 
 */
package pages.memberrdesignVBF;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Strings;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

/**
 * @author saduri
 *
 */
public class ReviewOneTimePaymentsPage extends UhcDriver {
	
	public static boolean isBusinessValidation = false;
	
	@FindBy(xpath = "//button[text()='CHANGE CARD']")
	private WebElement ChangeCard;

	@FindBy(xpath = "//button[text()='MAKE PAYMENT']")
	private WebElement MakePaymentButton;

	@FindBy(xpath = "//button[contains(@class,'btn--primary')][contains(text(),'Submit')]")
	private WebElement submitPayment;

	@FindBy(id = "termError")
	private WebElement AgreeCheckBox;

	@FindBy(id = "custom-page-title")
	private WebElement confirmPageHeader;
	
	@FindBy(xpath = "//div[contains(@class,'payments')]//div[contains(@class,'intro_text')][contains(@style,'color:red;')]//*[string-length(normalize-space(text()))>1]")
	private WebElement errorMessage;

	@FindBy(xpath = "//div[contains(@class,'payment-confirm')]//div[contains(@class,'table-body-row')]")
	private List<WebElement> paymentConfirmRows;

	@FindBy(xpath = "//div[contains(@class,'loading-block')]")
	private WebElement loadingBlock;
	
	public ReviewOneTimePaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(AgreeCheckBox);
		validateNew(submitPayment);
		validateNew(ChangeCard);
	}
	
	public ConfirmOneTimePaymentPage selectAgreeAndClickOnMakePayment() {
		
		System.out.println("User is on Review one Time CC Page");
		PaymentsDataVerificationonReviewPage();
		jsClickNew(AgreeCheckBox);
		submitPayment.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitforElementDisapper(By.xpath("//div[contains(@class,'loading-block')]"), 60);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Payment Submitted")) {
			System.out.println("User is on Confirmation Page");
			return new ConfirmOneTimePaymentPage(driver);
		} else if(errorMessage.getText().contains("Only one payment request can be submitted per business day")) {
			System.out.println("Buiness Validation message appears -- "+errorMessage.getText());
			isBusinessValidation = true;
			return null;
		}
		else {
			System.out.println("User is not on Confirmation Page");
			return null;
		}
	}
	@SuppressWarnings("deprecation")
	public void PaymentsDataVerificationonReviewPage() {
		List<WebElement> columnsList = null;
		for (WebElement row : paymentConfirmRows) {
			columnsList = row.findElements(By.tagName("div"));
			for (WebElement column : columnsList) {
				System.out.print(column.getText() + " - ");
				if ((Strings.isNullOrEmpty(column.getText()))) {
					Assert.fail("Coloumn Header or value is null");
				}
			}
		}
	}

}
