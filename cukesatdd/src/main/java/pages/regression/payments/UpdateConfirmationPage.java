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

	@FindBy(xpath = "//*[contains(text(),'Payment Method:')]")
	private WebElement PaymentMethod;
	
	@FindBy(xpath = " //h1[@id='custom-page-title']")
	private WebElement ConfirmationText; 

	public UpdateConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void UpdatePaymentsDataVerificationonConfirmationPage() {
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
		validate(PaymentMethod);
		UpdatePaymentsDataVerificationonConfirmationPage();
		System.out.println("Your Confimation Number is : " + PaymentMethod.getText());
	}

	public void validateCCUpdateVerification() {
		validate(PaymentMethod);
		UpdatePaymentsDataVerificationonConfirmationPage();
		System.out.println("Your Confimation Number is : " + PaymentMethod.getText());
	}

	public void validateEFTUpdateVerificationforShip() {
		/*validate(MakeOneTimePaymentLink);
		UpdatePaymentsDataVerificationonConfirmationPage();
		System.out.println("User has sucessfully setup recurring payment for Ship EFT");*/
			validate(ConfirmationText);
			System.out.println("Your confirmation text is : " + ConfirmationText.getText());
			UpdatePaymentsDataVerificationonConfirmationPage();		
			String verifyConfirmationTextPresent = ConfirmationText.getText();		
			if(verifyConfirmationTextPresent.contains("Recurring Payment Request Submitted")){	
			System.out.println("Update Recurring for Checking Account for Ship Member text displayed is :- " + ConfirmationText.getText());
			System.out.println("Recurring paymnet submitted was displayed, Test Case is Passed");
		    Assert.assertTrue(true);
				}
				else
				{
					Assert.fail("Recurring paymnet submitted was not dispalyed, Test Case if failed");
				}		
		}
	

	public void validateStopRevurringVerificationforShip() {
		validate(MakeOneTimePaymentLink);
		UpdatePaymentsDataVerificationonConfirmationPage();
		System.out.println("User has sucessfully canceled recurring payment for ship");
	}

	public void validateStopRevurringVerificationforFed() {
		if(ConfirmationNumber.isDisplayed()) {
		validate(ConfirmationNumber);
		validate(PaymentMethod);
		UpdatePaymentsDataVerificationonConfirmationPage();
		System.out.println("User has sucessfully canceled recurring payment for Federal");
		Assert.assertTrue("User has sucessfully canceled recurring payment for Federal", true);
		}
		else {
			System.out.println("User has not canceled recurring payment for Federal");
			Assert.assertTrue("User has not canceled recurring payment for Federal", false);
		}
	}

	@Override
	public void openAndValidate() {
		validate(MakeOneTimePaymentLink);
	}
}
