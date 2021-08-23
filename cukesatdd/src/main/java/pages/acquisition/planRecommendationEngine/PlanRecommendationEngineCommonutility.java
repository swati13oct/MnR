/**
 * 
 */
package pages.acquisition.planRecommendationEngine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.acquisition.planRecommendationEngine.PlanRecommendationEngineStepDefinition;
import acceptancetests.data.CommonConstants;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.GlobalWebElements;

public class PlanRecommendationEngineCommonutility extends GlobalWebElements {

	public Actions actions = new Actions(driver);

	public PlanRecommendationEngineCommonutility(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);

	}

	String flow;

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	// Coverage Option page Elements

	@FindBy(xpath = "//*[@class='progress-bar-title']/h1")
	private WebElement planSelectorPageTilte;

	@FindBy(xpath = "//*[@class='progress-bar-info']/h2")
	private WebElement pageStepsNumberName;

	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;

	@FindBy(css = "p.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = "#errorMessage")
	private WebElement errorMessage;

	public String currentPageName, currrentPagePercentage, previousPageName, previousPagePercentage, nextPageName,
			nextPagePercentage;

	// Current page percentage validation Desktop
	public void currentPageValidation(String pageName) {
		System.out.println("Current page Validation Desktop");
		findPagedetails(pageName);
		try {
			pageloadcomplete();
			threadsleep(3000);
			Assert.assertTrue(pageStepsNumberName.getText().toUpperCase().contains(pageName.toUpperCase()),
					"Current page name validation failed");
			Assert.assertTrue(pageProgressPercentage.getText().toUpperCase().contains(currrentPagePercentage),
					"Current page % validation failed");
		} catch (Exception e) {
			System.out.println("Unable to validate Current page functionality or not Visible");
		}
	}

	// Previous Button Functionality Desktop
	public void previousPageValidation(String pageName) {
		System.out.println("Previous page Validation Desktop");
		findPagedetails(pageName);
		try {
			pageloadcomplete();
			threadsleep(3000);
			Assert.assertTrue(pageStepsNumberName.getText().toUpperCase().contains(previousPageName.toUpperCase()),
					"Previous page name validation failed");
			Assert.assertTrue(pageProgressPercentage.getText().toUpperCase().contains(previousPagePercentage),
					"Previous page % validation failed");
		} catch (Exception e) {
			System.out.println("Unable to validate previous button functionality or not Visible");
		}
	}

	// Continue Button Functionality Desktop
	public void nextPageValidation(String pageName) {
		System.out.println("Next page Validation Desktop");
		findPagedetails(pageName);
		if (nextPageName.contains("NULL") == false) {
			try {
				pageloadcomplete();
				threadsleep(1000);
				try {
					waitTextPresent(pageStepsNumberName, nextPageName, 20);
				} catch (Exception e) {
					Assert.assertTrue(false, "Next page name validation failed");
				}
				Assert.assertTrue(pageProgressPercentage.getText().toUpperCase().contains(nextPagePercentage),
						"Next page % validation failed");
			} catch (Exception e) {
				System.out.println("Unable to validate Continue button functionality on Next page");
			}
		}
	}

	public void waitTextPresent(WebElement element, String text, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void findPagedetails(String pageName) {
		String curID = String.valueOf(Thread.currentThread().getId());
		flow = CommonConstants.PRE_FLOW.get(String.valueOf(Thread.currentThread().getId()));//PlanRecommendationEngineStepDefinition.PREflow;
		System.out.println("**** Current Thread ID is - "+curID+" for the flow "+flow+" ****");
		currentPageName = pageName.toUpperCase().trim();
		currrentPagePercentage = new String();
		previousPageName = new String();
		previousPagePercentage = new String();
		nextPageName = new String();
		nextPagePercentage = new String();
		// Update the else and else if for each page
		if (flow.equalsIgnoreCase("PDP")) {
			if (currentPageName.contains("LOCATION")) {
				nextPageName = "Coverage";
				nextPagePercentage = "11%";
				currrentPagePercentage = "0%";
			}
			if (currentPageName.contains("COVERAGE")) {
				previousPageName = "Location";
				previousPagePercentage = "11%";
				nextPageName = "Drug";
				nextPagePercentage = "50%";
				currrentPagePercentage = "11%";
			}
			if (currentPageName.contains("DRUG")) {
				previousPageName = "Coverage";
				previousPagePercentage = "50%";
				nextPageName = "NULL";
				nextPagePercentage = "NULL";
				currrentPagePercentage = "50%";
			}
		} else {
			if (currentPageName.contains("LOCATION")) {
				nextPageName = "Coverage";
				nextPagePercentage = "11%";
				currrentPagePercentage = "0%";
			}
			if (currentPageName.contains("COVERAGE")) {
				previousPageName = "Location";
				previousPagePercentage = "11%";
				nextPageName = "Special";
				nextPagePercentage = "22%";
				currrentPagePercentage = "11%";
				if (flow.equalsIgnoreCase("MA")) {
					nextPagePercentage = "25%";
				}
				if (flow.equalsIgnoreCase("PDPTOMAPD")) {
					nextPagePercentage = "33%";
				}
			} else if (currentPageName.contains("SPECIAL")) {
				previousPageName = "Coverage";
				previousPagePercentage = "22%";
				nextPageName = "Doctor";
				nextPagePercentage = "33%";
				currrentPagePercentage = "22%";
				if (flow.equalsIgnoreCase("MA")) {
					previousPagePercentage = "25%";
					currrentPagePercentage = "25%";
					nextPagePercentage = "38%";
				}
				if (flow.equalsIgnoreCase("PDPTOMAPD")) {
					nextPagePercentage = "44%";
				}
			} else if (currentPageName.contains("DOCTOR")) {
				previousPageName = "Special";
				previousPagePercentage = "33%";
				nextPageName = "Drug";
				nextPagePercentage = "44%";
				currrentPagePercentage = "33%";
				if (flow.equalsIgnoreCase("MA")) {
					previousPagePercentage = "38%";
					currrentPagePercentage = "38%";
					nextPageName = "Services";
					nextPagePercentage = "50%";
				}
				if (flow.equalsIgnoreCase("PDPTOMAPD")) {
					nextPagePercentage = "56%";
				}
			} else if (currentPageName.contains("DRUG")) {
				previousPageName = "Doctor";
				previousPagePercentage = "44%";
				currrentPagePercentage = "44%";
				nextPageName = "Services";
				nextPagePercentage = "56%";
			} else if (currentPageName.contains("SERVICES")) {
				previousPageName = "Drug";
				previousPagePercentage = "56%";
				nextPageName = "Cost";
				nextPagePercentage = "67%";
				currrentPagePercentage = "56%";
				if (flow.equalsIgnoreCase("MA")) {
					previousPageName = "Doctor";
					previousPagePercentage = "50%";
					currrentPagePercentage = "50%";
					nextPagePercentage = "63%";
				}
			} else if (currentPageName.contains("COST")) {
				previousPageName = "Services";
				previousPagePercentage = "67%";
				nextPageName = "Priorities";
				nextPagePercentage = "78%";
				currrentPagePercentage = "67%";
				if (flow.equalsIgnoreCase("MA")) {
					previousPagePercentage = "63%";
					currrentPagePercentage = "63%";
					nextPagePercentage = "75%";
				}
			} else if (currentPageName.contains("PRIORITIES")) {
				previousPageName = "Cost";
				previousPagePercentage = "78%";
				nextPageName = "NULL";
				nextPagePercentage = "NULL";
				currrentPagePercentage = "78%";
				if (flow.equalsIgnoreCase("MA")) {
					previousPagePercentage = "75%";
					currrentPagePercentage = "75%";
				}
			} else {
				previousPageName = "";
				previousPagePercentage = "";
				nextPageName = "";
				nextPagePercentage = "";
			}
		}
		previousPagePercentage = previousPagePercentage + " COMPLETE";
		nextPagePercentage = nextPagePercentage + " COMPLETE";
		currrentPagePercentage = currrentPagePercentage + " COMPLETE";
	}

	public void desktopErrorValidation(String pagename) {
		System.out.println("Error Validation");
		validate(errorMessage, 30);
		Assert.assertTrue(errorMessage.getText().toUpperCase().contains("PLEASE")
				|| (errorMessage.getText().toUpperCase().contains("NO"))
				|| (errorMessage.getText().toUpperCase().contains("ZIP")));
		Assert.assertTrue(pageStepsNumberName.getText().toUpperCase().contains(pagename.toUpperCase()));
	}

	public void browserBack() {
		driver.navigate().back();
	}

	public void continueNextpage(String page, boolean percentageValidation) {
		System.out.println("Clicking continue from page : " + page);
		threadsleep(1000);
		validate(continueBtn);
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		if (percentageValidation)
			nextPageValidation(page.toUpperCase());
		else
			nextPageNameValidation(page.toUpperCase());
	}

	public void nextPageNameValidation(String pageName) {
		System.out.println("Next page Validation Desktop");
		if(pageName.equalsIgnoreCase("LOCATION")) {
			System.out.println("Plan Type not mentioned in flow");
			nextPageName = "Coverage";
			nextPagePercentage = "11%";}
		else
			findPagedetails(pageName);
		if (nextPageName.contains("NULL") == false) {
			try {
				pageloadcomplete();
				threadsleep(1000);
				try {
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.textToBePresentInElement(pageStepsNumberName, nextPageName));
				} catch (Exception e) {
					Assert.assertTrue(false, "Next page name validation failed");
				}
			} catch (Exception e) {
				System.out.println("Unable to validate Continue button functionality on Next page");
			}
		}
	}

	public void MouseOver(WebElement element, String browser) {
		System.out.println("Browser Name: " + browser);
		if (browser.equals("chrome") || browser.equals("IE") || browser.equals("edge"))
			actions.clickAndHold(element).build().perform();
		else {
			// actions.moveToElement(element).click().build().perform();
			jsMouseOver(element); // E2E: Actions class does not work in Safari, hence using javascript to perform
									// the action.
		}
	}
}