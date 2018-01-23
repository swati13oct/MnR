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

	@FindBy(xpath = ".//span[contains(text(),'for the Last 18 Months')]")
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

	private static String PAGE_URL = "https://team-c-medicare.uhc.com/medicare/login/overview.html?testharness=true";

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

	public void navigateToEOBPage() throws InterruptedException {

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
				Assert.fail("Need Help Details are not displayed!");

		}
	}
}
