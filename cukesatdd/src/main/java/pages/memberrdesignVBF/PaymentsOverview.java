package pages.memberrdesignVBF;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class PaymentsOverview extends UhcDriver {
	// updated element locator
	@FindBy(xpath = "//div[@class='margin-small']//a[@id='onetimepayment' and not(contains(@class,'ng-hide'))]")
	private WebElement OneTimePaymentButton;

	@FindBy(xpath = "//div[@class='margin-small']//a[@id='setupautopayment' and not(contains(@class,'ng-hide'))]")
	private WebElement AutomaticPaymentButton;

	@FindBy(xpath = ".//*[@id='customFields']/div[3]/button")
	private WebElement SearchButton;

	@FindBy(xpath = ".//*[@id='paymentHistoryApp']/div/div/div/div/div[1]/p")
	private WebElement ErrorMessage;

	@FindBy(xpath = "//*[@id='50129808']/a")
	private WebElement Tab1;

	@FindBy(xpath = "//*[@id='22976826']/a")
	private WebElement Tab2;

	@FindBy(xpath = "//*[@id='paymentCustomSearch']/div/span/div/div[2]/div[1]/label")
	private WebElement PaidCheckbox;

	@FindBy(xpath = "//*[@id='paymentCustomSearch']/div/span/div/div[2]/div[2]/label")
	private WebElement UnPaidCheckbox;

	@FindBy(xpath = "//*[@id='paymentHistoryApp']/div[1]/div/div/div/div[3]")
	private WebElement Payments_status_Error;

	@FindBy(id = "paymentTable")
	private WebElement PaymentsTable;

	@FindBy(xpath = "//table[@id='paymentTable']/tbody/tr/th[contains(text(),'Due Date')]")
	private WebElement dueDate;

	@FindBy(xpath = "//table[@id='paymentTable']/tbody/tr/th[contains(text(),'Amount Paid')]")
	private WebElement amountPaid;

	@FindBy(id = "payment-date")
	private WebElement paymentDropdown;

	@FindBy(className = "loading-block")
	public List<WebElement> loadingImages;

	public PaymentsOverview(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		RallyDashboardPage.checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, OneTimePaymentButton, 60);
		validateNew(OneTimePaymentButton);
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public OneTimePaymentsPage navigateToOneTimePaymentpage() throws InterruptedException {
		validateNew(OneTimePaymentButton);
		OneTimePaymentButton.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("onetime/eft/overview.htm")) {
			return new OneTimePaymentsPage(driver);
		}
		return null;
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	public void ScrollDownAndSelectRange() throws InterruptedException {
		scrollToView(paymentDropdown);
		Select dropdown = new Select(paymentDropdown);
		dropdown.selectByVisibleText("Last 24 months");
		if (loadingImages.size() > 0) {
			CommonUtility.waitForElementToDisappear(driver, loadingImages.get(0), 120);
		}
	}

	/***
	 * 
	 */
	public void verifyPaymentTable() {
		scrollToView(PaymentsTable);
		if (PaymentsTable.isDisplayed()) {
			validateNew(dueDate);
			validateNew(amountPaid);
		}
	}

}
