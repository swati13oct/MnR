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
	@FindBy(xpath = "//div[@class='margin-small']//a[contains(@ng-click,'gotoMakeOneTimePayment()') and not(contains(@class,'ng-hide'))]")
	private WebElement OneTimePaymentButton;

	@FindBy(id = "paymentTable")
	private WebElement PaymentsTable;

	@FindBy(xpath = "//table[@id='paymentTable']/tbody/tr/th[contains(text(),'Due Date')]")
	private WebElement dueDate;

	@FindBy(xpath = "//table[@id='paymentTable']/tbody/tr/th[contains(text(),'Amount Paid')]")
	private WebElement amountPaid;

	@FindBy(xpath = "//ul[@id='menu2']//a[contains(text(),'Last 24 months')]")
	private WebElement menuLast24months;

	//@FindBy(id = "payment-date")
	@FindBy(xpath = ".//button[@id='menubutton']/span")
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
		//Select dropdown = new Select(paymentDropdown);
		//dropdown.selectByVisibleText("Last 24 months");
		//paymentDropdown.click();
		//CommonUtility.waitForPageLoad(driver, menuLast24months, 10);
		jsClickNew(paymentDropdown);
		Thread.sleep(2000);
		menuLast24months.click();		

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
