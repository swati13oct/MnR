package pages.regression.payments;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class CreditCardUPGPage extends UhcDriver {

	@FindBy(id = "div_cardInfo")
	private WebElement EnterCreditInfo;

	@FindBy(id = "holderName")
	private WebElement EnterName;

	@FindBy(id = "accountNumber")
	private WebElement EnterAccountNumber;

	@FindBy(id = "month")
	private WebElement SelectMonth;

	@FindBy(id = "year")
	private WebElement SelectYear;

	@FindBy(id = "btnSubmit")
	private WebElement ProceedButton;

	@FindBy(id = "btnCancel")
	private WebElement BackButton;

	@FindBy(id = "div_memberInfoPanel")
	private WebElement MemberInfoPanel;

	@FindBy(id = "div_purchaseInfoPanel")
	private WebElement PlanInfoPanel;

	@FindBy(xpath = "//div[@class='col-md-12']//h1")
	private WebElement ReviewPageHeading;

	public CreditCardUPGPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ReviewOneTimePaymentPage EnterFiledsOnCC(Map<String, String> accountAttributessMap) {
		String Name = accountAttributessMap.get("Name");
		String CreditCardNumber = accountAttributessMap.get("CreditCardNumber");
		String ExpMonth = accountAttributessMap.get("Month");
		String ExpYr = accountAttributessMap.get("Year");

		EnterName.sendKeys(Name);
		EnterAccountNumber.sendKeys(CreditCardNumber);
		selectFromDropDownByText(driver, SelectMonth, ExpMonth);
		selectFromDropDownByText(driver, SelectYear, ExpYr);
		ProceedButton.click();
		if (ReviewPageHeading.getText().contains("Review One Time Payment")) {
			System.out.println("Review One Time Payment page displayed");
			return new ReviewOneTimePaymentPage(driver);
		} else {
			System.out.println("Review One Time Payment not displayed");
			return null;
		}
	}

	public ReviewAutomaticPage EnterFiledsOnCCforREC(Map<String, String> accountAttributessMap) {
		String Name = accountAttributessMap.get("Name");
		String CreditCardNumber = accountAttributessMap.get("CreditCardNumber");
		String ExpMonth = accountAttributessMap.get("Month");
		String ExpYr = accountAttributessMap.get("Year");

		EnterName.sendKeys(Name);
		EnterAccountNumber.sendKeys(CreditCardNumber);
		selectFromDropDownByText(driver, SelectMonth, ExpMonth);
		selectFromDropDownByText(driver, SelectYear, ExpYr);
		ProceedButton.click();
		if (ReviewPageHeading.getText().contains("Review Recurring Payments")) {
			System.out.println("Review Recurring Payments displayed");
			return new ReviewAutomaticPage(driver);
		} else {
			System.out.println("Review Recurring Payments not displayed");
			return null;
		}
	}
	
	public UpdateReviewPage EnterFiledsOnCCforUpdateREC(Map<String, String> accountAttributessMap) {
		String Name = accountAttributessMap.get("Name");
		String CreditCardNumber = accountAttributessMap.get("CreditCardNumber");
		String ExpMonth = accountAttributessMap.get("Month");
		String ExpYr = accountAttributessMap.get("Year");

		EnterName.sendKeys(Name);
		EnterAccountNumber.sendKeys(CreditCardNumber);
		selectFromDropDownByText(driver, SelectMonth, ExpMonth);
		selectFromDropDownByText(driver, SelectYear, ExpYr);
		ProceedButton.click();
		if (ReviewPageHeading.getText().contains("Review Payment Method Update")) {
			System.out.println("Review Payment Method Update displayed");
			return new UpdateReviewPage(driver);
		} else {
			System.out.println("Review Payment Method Update not displayed");
			return null;
		}
	}
	
	
	@Override
	public void openAndValidate() {
		validate(EnterCreditInfo);
		validate(EnterName);
		validate(EnterAccountNumber);
		validate(SelectMonth);
		validate(SelectYear);
		validate(ProceedButton);
		validate(BackButton);
		validate(MemberInfoPanel);
		validate(PlanInfoPanel);

	}

}