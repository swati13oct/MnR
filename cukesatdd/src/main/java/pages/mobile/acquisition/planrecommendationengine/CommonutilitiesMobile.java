/**
 * Desc: Common methods to be accessed throughout the project
 * Author : Murali
 */
package pages.mobile.acquisition.planrecommendationengine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class CommonutilitiesMobile extends UhcDriver {

	public CommonutilitiesMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	// --- From here Common for all page starts ---
	@FindBy(css = ".progress-bar-title>h1")
	private WebElement planSelectorPageTilte;

	@FindBy(css = ".progress-bar-info>h2")
	private WebElement pageStepsNumberName;

	@FindBy(css = "div.progress-bar-value-background")
	private WebElement progressbar;

	@FindBy(css = "div.progress-bar-info>p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "div>.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = ".all-fields-marked-wi>sup")
	private WebElement pageRequiredInfoAsteriskMark;

	@FindBy(css = "div.sam")
	public WebElement footerCallbannerSection;

	@FindBy(css = ".container div>button[class*='primary button']")
	private WebElement continueBtn;

	@FindBy(css = ".container div>button[class*='secondary']")
	private WebElement previousBtn;

	@FindBy(css = "#errorMessage")
	private WebElement errorMessage;

	// --- Common elements Ends above ---

	public String currentPageName, previousPageName, previousPagePercentage, nextPageName, nextPagePercentage;

	public void mobileFindElementBeforeCallBanner(WebElement element, String percentage, int swipeCount,
			boolean swipeUp) {
		try {
			validate(footerCallbannerSection, 30);
			validate(element, 30);
			int locationDifference = 100;
			if (footerCallbannerSection.getLocation().getY() - element.getLocation().getY() < locationDifference
					&& swipeCount > 0) {
				mobileswipe(percentage, swipeUp);
				swipeCount--;
				mobileFindElementBeforeCallBanner(element, percentage, swipeCount, swipeUp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element not visible");
		}
	}

	public void fixPrivateConnectionMobile() {
		try {
			// String URL = "https://self-signed.badssl.com/";
			threadsleep(1000);
			if (driver.findElement(By.cssSelector("body.ssl h1")).getText()
					.contains("Your connection is not private")) {
				driver.findElement(By.cssSelector("button#details-button")).click();
				threadsleep(1000);
				driver.findElement(By.cssSelector("a#proceed-link")).click();
				threadsleep(1000);
				pageloadcomplete();
			}
		} catch (Exception e) {
			System.out.println("No SSL error / Exception");
		}
	}

	public boolean fixLeavingProceedMobile() {
		boolean status = false;
		try {
			threadsleep(500);
			WebElement element = driver.findElement(By.cssSelector("a#proceed"));
			jsClickNew(element);
			threadsleep(1000);
			pageloadcomplete();
			status = true;
		} catch (Exception e) {
			System.out.println("No Leaving Proceed Error");
		}
		return status;
	}

	public void threadsleep(int sec) {
		try {
			Thread.sleep(sec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Function Verification
	public void coverageOptionpageerror() {
		System.out.println("Plan Type is empty - Error Scenario in Coverage Options Page");
		continueBtn.click();
		Assert.assertTrue(errorMessage.getText().contains("Please"));
	}

	// Previous Button Functionality Mobile
	public void previouspageValidation(String pageName) {
		System.out.println("Previous page Validation Mobile");
		findPagedetails(pageName);
		try {
			threadsleep(1500);
			Assert.assertTrue(pageStepsNumberName.getText().toUpperCase().contains(previousPageName),
					"Previous page validation failed");
			Assert.assertTrue(pageProgressPercentage.getText().toUpperCase().contains(previousPagePercentage));
		} catch (Exception e) {
			System.out.println("Unable to validate previous button functionality are not Visible");
		}
	}

	// Continue Button Functionality Mobile
	public void nextPageValidation(String pageName) {
		System.out.println("Next page Validation Mobile");
		findPagedetails(pageName);
		try {
			threadsleep(1500);
			Assert.assertTrue(pageStepsNumberName.getText().toUpperCase().contains(nextPageName),
					"Next page validation failed");
			Assert.assertTrue(pageProgressPercentage.getText().toUpperCase().contains(nextPagePercentage));
		} catch (Exception e) {
			System.out.println("Unable to validate Continue button functionality are not Visible");
		}
	}

	public void findPagedetails(String pageName) {
		currentPageName = pageName.toUpperCase().trim();
		previousPageName = new String();
		previousPagePercentage = new String();
		nextPageName = new String();
		nextPagePercentage = new String();
		// Update the else as else if for each page
		if (currentPageName.contains("COVERAGE")) {
			previousPageName = "LOCATION";
			previousPagePercentage = "8%";
			nextPageName = "SPECIAL";
			nextPagePercentage = "16%";
		} else if (currentPageName.contains("SPECIAL")) {
			previousPageName = "COVERAGE";
			previousPagePercentage = "16%";
			nextPageName = "PERSONAL";
			nextPagePercentage = "32%";
		} else {
			previousPageName = "";
			previousPagePercentage = "";
			nextPageName = "";
			nextPagePercentage = "";
		}
		previousPagePercentage = previousPagePercentage + " COMPLETE";
		nextPagePercentage = nextPagePercentage + " COMPLETE";
	}

	public void browserBack() {
		driver.navigate().back();
	}

}
