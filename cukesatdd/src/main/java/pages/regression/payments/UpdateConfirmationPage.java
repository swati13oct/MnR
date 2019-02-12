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

public class UpdateConfirmationPage extends UhcDriver {

	@FindBy(xpath = "//div[@class='col-md-12']//h2//span")
	private WebElement RequestSubmittedHeader;

	@FindBy(xpath = "//a[normalize-space(text())='Make a One-Time Payment']")
	private WebElement MakeOneTimePaymentLink;

	@FindBy(xpath = "//span[contains(@class,'confirmation__number')]")
	private WebElement ConfirmationNumber;

	public UpdateConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public void UpdatePaymentsDataVerificationonConfirmationPage()
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

	public void validateEFTUpdateVerification() {
		validate(ConfirmationNumber);
		UpdatePaymentsDataVerificationonConfirmationPage();
		System.out.println("Your Confimation Number is : " + ConfirmationNumber.getText());
	}

	public void validateCCUpdateVerification() {
		validate(ConfirmationNumber);
		UpdatePaymentsDataVerificationonConfirmationPage();
		System.out.println("Your Confimation Number is : " + ConfirmationNumber.getText());
	}

	
	public void validateEFTUpdateVerificationforShip() {
		validate(MakeOneTimePaymentLink);
		UpdatePaymentsDataVerificationonConfirmationPage();
		System.out.println("User has sucessfully setup recurring payment for Ship EFT");
	}
	
	public void validateStopRevurringVerificationforShip() {
		validate(MakeOneTimePaymentLink);
		UpdatePaymentsDataVerificationonConfirmationPage();
		System.out.println("User has sucessfully setup recurring payment for Ship EFT");
	}
	@Override
	public void openAndValidate() {
		validate(MakeOneTimePaymentLink);
	}
}
