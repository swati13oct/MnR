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

	@FindBy(id = "termsAgree")
	private WebElement AgreeCheckBox;

	@FindBy(id = "custom-page-title")
	private WebElement confirmPageHeader;

	public ReviewOneTimePaymentPage(WebDriver driver) {
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
	
	public ConfirmOneTimePaymentPage selectAgreeAndClickOnMakePayment() {
		validate(ChangeCard);
		System.out.println("User is on Review one Time CC Page");
		PaymentsDataVerificationonReviewPage();
		jsClickNew(AgreeCheckBox);
		MakePaymentButton.click();
		if (validate(confirmPageHeader)) {
			System.out.println("User is on Confirmation Page");
			return new ConfirmOneTimePaymentPage(driver);
		} else
			return null;
	}

	@Override
	public void openAndValidate() {
		validate(ChangeCard);

	}

}
