/**
 * 
 */
package pages.acquisition.planRecommendationEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class PlanRecommendationEngineCommonutility extends UhcDriver {

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
	
	@FindBy(css = "#errorMessage>div:nth-child(2)")
	private WebElement errorMessage;
	
	public String currentPageName, previousPageName, previousPagePercentage, nextPageName, nextPagePercentage;
		
// Previous Button Functionality Mobile
		public void previouspageValidation(String pageName) {
			System.out.println("Previous page Validation Mobile");
			findPagedetails(pageName);
			try {
				pageloadcomplete();
				threadsleep(3000);
				Assert.assertTrue(pageStepsNumberName.getText().toUpperCase().contains(previousPageName),
						"Previous page name validation failed");
				Assert.assertTrue(pageProgressPercentage.getText().toUpperCase().contains(previousPagePercentage),"Previous page % validation failed");
			} catch (Exception e) {
				System.out.println("Unable to validate previous button functionality are not Visible");
			}
		}

// Continue Button Functionality Mobile
		public void nextPageValidation(String pageName) {
			System.out.println("Next page Validation Desktop");
			findPagedetails(pageName);
			try {
				pageloadcomplete();
				threadsleep(5000);
				Assert.assertTrue(pageStepsNumberName.getText().toUpperCase().contains(nextPageName),
						"Next page name validation failed");
				Assert.assertTrue(pageProgressPercentage.getText().toUpperCase().contains(nextPagePercentage),"Next page % validation failed");
			} catch (Exception e) {
				System.out.println("Unable to validate Continue button functionality on Next page");
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
				nextPageName = "CARE";
				nextPagePercentage = "24%";
			}else if (currentPageName.contains("CARE")) {
				previousPageName = "SPECIAL";
				previousPagePercentage = "24%";
				nextPageName = "DOCTORS";
				nextPagePercentage = "32%";
			}else if (currentPageName.contains("DOCTORS")) {
				previousPageName = "CARE";
				previousPagePercentage = "32%";
				nextPageName = "DRUG";
				nextPagePercentage = "40%";
			}else if (currentPageName.contains("DRUG")) {
				previousPageName = "DOCTORS";
				previousPagePercentage = "40%";
				nextPageName = "PHARMACY";
				nextPagePercentage = "48%";
			}else if (currentPageName.contains("PHARMACY")) {
				previousPageName = "DRUG";
				previousPagePercentage = "48%";
				nextPageName = "ADDITIONAL";
				nextPagePercentage = "56%";
			}else {
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
