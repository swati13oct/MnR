package pages.memberrdesignVBF;

import java.util.Map;

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

	@FindBy(xpath = "//div[@id='policy_info']/*[starts-with(@id,'p_policy')]//*[string-length(text())>1]")
	private WebElement planNameInfoPanel;
	
	@FindBy(xpath = "//button[text()='CHANGE CARD']")
	private WebElement ChangeCard;
	
	public CreditCardUPGPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ReviewOneTimePaymentsPage EnterFiledsOnCC(Map<String, String> accountAttributessMap) {
		String Name = accountAttributessMap.get("Name");
		String CreditCardNumber = accountAttributessMap.get("CreditCardNumber");
		String ExpMonth = accountAttributessMap.get("Month");
		String ExpYr = accountAttributessMap.get("Year");

		EnterName.sendKeys(Name);
		EnterAccountNumber.sendKeys(CreditCardNumber);
		selectFromDropDownByText(driver, SelectMonth, ExpMonth);
		selectFromDropDownByText(driver, SelectYear, ExpYr);
		ProceedButton.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, ChangeCard, 45);
		if (driver.getTitle().contains("Review")) {
			System.out.println("Review One Time Payment page displayed");
			return new ReviewOneTimePaymentsPage(driver);
		} else {
			System.out.println("Review One Time Payment not displayed");
			return null;
		}
	}

	

	@Override
	public void openAndValidate() {
		validateNew(EnterCreditInfo);
		validateNew(EnterName);
		validateNew(EnterAccountNumber);
		validateNew(MemberInfoPanel);
		validateNew(PlanInfoPanel);
		validateNew(planNameInfoPanel);


	}
	

}
