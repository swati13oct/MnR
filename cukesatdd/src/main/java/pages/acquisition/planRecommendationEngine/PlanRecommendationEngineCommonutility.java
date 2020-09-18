/**
 * 
 */
package pages.acquisition.planRecommendationEngine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.acquisition.planRecommendationEngine.PlanRecommendationEngineStepDefinition;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class PlanRecommendationEngineCommonutility extends UhcDriver {
	
	Actions actions = new Actions(driver);

	public PlanRecommendationEngineCommonutility(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
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
	
// 	Current page percentage validation Desktop
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
						waitTextPresent(pageStepsNumberName,nextPageName,20);
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
		
		public void waitTextPresent(WebElement element,String text,int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		}

		public void findPagedetails(String pageName) {
			flow = PlanRecommendationEngineStepDefinition.PREflow;
			currentPageName = pageName.toUpperCase().trim();
			currrentPagePercentage = new String();
			previousPageName = new String();
			previousPagePercentage = new String();
			nextPageName = new String();
			nextPagePercentage = new String();
			// Update the else as else if for each page
			if (currentPageName.contains("LOCATION")) {
				nextPageName = "Coverage";
				nextPagePercentage = "10%";
				currrentPagePercentage = "0%";
			}// Update the else and else if for each page
			if (flow.equalsIgnoreCase("PDP")) {
				if (currentPageName.contains("COVERAGE")) {
					previousPageName = "Location";
					previousPagePercentage = "10%";
					nextPageName = "Drug";
					nextPagePercentage = "20%";
					currrentPagePercentage = "10%";
				}
				if (currentPageName.contains("DRUG")) {
					previousPageName = "Coverage";
					previousPagePercentage = "20%";
					nextPageName = "Pharmacy";
					nextPagePercentage = "53%";
					currrentPagePercentage = "20%";
					if (currentPageName.contains("SKIP")) {
						nextPageName = "NULL";
						nextPagePercentage = "NULL";
						return;
					}
				}
				if (currentPageName.contains("PHARMACY")) {
					previousPageName = "Drug";
					previousPagePercentage = "53%";
					nextPageName = "NULL";
					nextPagePercentage = "NULL";
					currrentPagePercentage = "53%";
					return;
				}
			} else {
				if (currentPageName.contains("COVERAGE")) {
					previousPageName = "Location";
					previousPagePercentage = "10%";
					nextPageName = "Special";
					nextPagePercentage = "20%";
					currrentPagePercentage = "10%";
				} else if (currentPageName.contains("SPECIAL")) {
					previousPageName = "Coverage";
					previousPagePercentage = "20%";
					nextPageName = "Travel";
					nextPagePercentage = "30%";
					currrentPagePercentage = "20%";
					if (flow.equalsIgnoreCase("MA")) {
						nextPagePercentage = "33%";
					}
				} else if (currentPageName.contains("TRAVEL") || currentPageName.contains("CARE AWAY")) {
					previousPageName = "Special";
					previousPagePercentage = "30%";
					nextPageName = "Doctor";
					nextPagePercentage = "40%";
					currrentPagePercentage = "30%";
					if (flow.equalsIgnoreCase("MA")) {
						previousPagePercentage = "33%";
						nextPagePercentage = "46%";
						currrentPagePercentage = "33%";
					}
				} else if (currentPageName.contains("DOCTOR")) {
					previousPageName = "Travel";
					previousPagePercentage = "40%";
					nextPageName = "Drug";
					nextPagePercentage = "50%";
					currrentPagePercentage = "40%";
					if (flow.equalsIgnoreCase("MA")) {
						previousPagePercentage = "46%";
						nextPageName = "Additional";
						nextPagePercentage = "59%";
						currrentPagePercentage = "46%";
					}
				} else if (currentPageName.contains("DRUG")) {
					previousPageName = "Doctor";
					previousPagePercentage = "60%";
					nextPageName = "Additional";
					nextPagePercentage = "70%";
					currrentPagePercentage = "60%";
					if (currentPageName.contains("SKIP"))
						if ((flow.equalsIgnoreCase("MAPD") || flow.equalsIgnoreCase("NONE"))) {
							nextPageName = "Additional";
							nextPagePercentage = "70%";
						}
				} else if (currentPageName.contains("PHARMACY")) {
					previousPageName = "Drug";
					previousPagePercentage = "60%";
					nextPageName = "Additional";
					nextPagePercentage = "70%";
					currrentPagePercentage = "60%";
				} else if (currentPageName.contains("ADDITIONAL")) {
					previousPageName = "Drug";
					previousPagePercentage = "70%";
					nextPageName = "Cost";
					nextPagePercentage = "80%";
					currrentPagePercentage = "70%";
					if (flow.equalsIgnoreCase("MA")) {
						previousPageName = "Doctor";
						previousPagePercentage = "59%";
						nextPagePercentage = "72%";
						currrentPagePercentage = "59%";
					}
					if (currentPageName.contains("SKIP")) {
						previousPageName = "Drug";
						previousPagePercentage = "60%";
					}
				} else if (currentPageName.contains("COST")) {
					previousPageName = "Additional";
					previousPagePercentage = "80%";
					nextPageName = "NULL";
					nextPagePercentage = "NULL";
					currrentPagePercentage = "80%";
					if (flow.equalsIgnoreCase("MA")) {
						previousPagePercentage = "72%";
						currrentPagePercentage = "72%";
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
					|| (errorMessage.getText().toUpperCase().contains("ZIP"))
					);
			Assert.assertTrue(pageStepsNumberName.getText().toUpperCase().contains(pagename.toUpperCase()));
		}

	public void browserBack() {

		driver.navigate().back();
	}
	
	public void continueNextpage(String page,boolean percentageValidation) {
		System.out.println("Clicking continue from page : "+page);
		threadsleep(1000);
		validate(continueBtn);
		continueBtn.click();
		System.out.println("Validating " + page + " page Continue button functionality");
		if(percentageValidation)
			nextPageValidation(page.toUpperCase());
		else
			nextPageNameValidation(page.toUpperCase());
	}
	
	public void nextPageNameValidation(String pageName) {
		System.out.println("Next page Validation Mobile");
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
		System.out.println("Browser Name: "+browser);
		if(browser.equals("chrome") || browser.equals("IE") || browser.equals("edge")) 
			actions.clickAndHold(element).build().perform();
		else {
			actions.moveToElement(element).click().build().perform();
			}
	}
}
