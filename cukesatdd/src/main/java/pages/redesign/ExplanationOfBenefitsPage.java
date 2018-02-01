package pages.redesign;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.member.redesign.PreferencesPage;
import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class ExplanationOfBenefitsPage extends UhcDriver {

	@FindBy(xpath = ".//*[@id='IPEinvL']/map/area[2]")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "//a[text()='Go to EOB Search page']")
	private WebElement linkEOB;

	@FindBy(id = "eob-type")
	private WebElement EOBTypeRadioButton;

	@FindBy(xpath = ".//span[contains(text(),'Last 18 Months')]")
	private WebElement EOBTypeResult;

	@FindBy(id = "date-range-1")
	private WebElement DateRange;

	@FindBy(xpath = ".//button[@class='btn custom-date-search-btn']")
	private WebElement DateRangeCustomerSearchButton;

	@FindBy(xpath = ".//h2[contains(text(),'Need Help?')]")
	private WebElement NeedHlp;

	@FindBy(xpath = ".//h3[contains(text(),'Technical Support')]")
	private WebElement TechSprt;

	@FindBy(xpath = ".//h3[contains(text(),'Plan Support')]")
	private WebElement PlnSprt;

	@FindBy(xpath = "//*[@id='dashboard']//span[text()='View Your Claims']")
	private WebElement EOBdashboardLink;

	@FindBy(id = "eobC1")
	private WebElement EOBPage;

	@FindBy(xpath = ".//map[@name='IPEMap']/area[@alt='no']")
	private WebElement EOBpopup;

	private static String PAGE_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;

	// private static String PAGE_URL = TeamC_UNPWAssistancePage_URL;

	public ExplanationOfBenefitsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
	}
	/** 
	 * @todo : Navigate to EOB Page
	 */
	public void navigateToEOBPage() throws InterruptedException {
		if (driver.getTitle().equalsIgnoreCase("UnitedHealthcare")) {
			System.out.println("navigated to Homepage!");
			Thread.sleep(5000);
			EOBdashboardLink.click();
			Thread.sleep(5000);

			try {
				if (validate(EOBpopup)) {
					EOBpopup.click();
					System.out.println("EOB Pop Up displayed");
				}
				EOBPage.click();
				Thread.sleep(5000);
			} catch (Exception e) {
				EOBPage.click();
				Thread.sleep(5000);
			}

			Thread.sleep(5000);
			if (driver.getTitle().equalsIgnoreCase("EOB Search")) {
				System.out.println("navigated to EOB page!");
				// return new CommunicationPreferences(driver);
				Assert.assertTrue(true);
			}
		} else {
			try {
				Thread.sleep(10000);
				if (validate(iPerceptionPopUp)) {
					iPerceptionPopUp.click();
					System.out.println("iPerception Pop Up displayed");
				}
				linkEOB.click();
				Thread.sleep(5000);
			} catch (Exception e) {
				linkEOB.click();
				Thread.sleep(5000);
			}
			if (driver.getTitle().equalsIgnoreCase("EOB Search")) {
				System.out.println("navigated to EOB page!");
				// return new CommunicationPreferences(driver);
				Assert.assertTrue(true);
			}
			// return null;
		}
	}
	/** 
	 * @todo : Validate the EOB elements present in the page or not
	 */
	public void validateEOB() throws InterruptedException {

		if (driver.getTitle().equalsIgnoreCase("EOB Search")) {
			System.out.println("navigated to EOB page!");

			// Select EOBType = new Select(EOBTypeRadioButton);
			// EOBType.selectByVisibleText("Medical");

			Select daterange = new Select(DateRange);
			daterange.selectByVisibleText("Last 18 months");

			Thread.sleep(15000);
			if (EOBTypeResult.isDisplayed()) {
				System.out
						.println("EOBtype results are displayed for last 18 Months!");
			} else
				Assert.fail("Results for 18 months are not displayed");

			daterange.selectByVisibleText("Custom Search");
			if (DateRangeCustomerSearchButton.isDisplayed()) {
				System.out.println("Custom Search date fields are displayed!");
			} else
				Assert.fail("Custom search results are not displayed");

			if (NeedHlp.isDisplayed()) {
				if (TechSprt.isDisplayed()) {
					if (PlnSprt.isDisplayed()) {
						System.out.println("Need help details are displayed");
					}
				}
			} else
				Assert.fail("Need Help-Details are not displayed!");

		}
	}
}
