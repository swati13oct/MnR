/**
 * 
 */
package pages.acquisition.planSelectorEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class PlanSelectorCoverageOptionPage extends UhcDriver {

	public PlanSelectorCoverageOptionPage(WebDriver driver) {
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
	
	@FindBy(xpath = "//*[@class='progress-bar-info']/div")
	private WebElement pageProgressPercentage;
	
	@FindBy(id = "custom-radio-group")
	private WebElement coverageTitle;
	
	@FindBy(xpath = "//label[@class='radio-label']/div[contains(text(),'Medical and prescription drug')]")
	private WebElement SelectcoverageOptions;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;

//Coverage Option Page Element Verification Method 
	
		public void coverageOptionpage() {
			System.out.println("Coverage Option Validating Page: ");
			waitforElementNew(planSelectorPageTilte);
			Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
			waitforElementNew(pageStepsNumberName, 30);
			Assert.assertTrue(pageStepsNumberName.getText().contains("Step 2: Coverage Option"));
			waitforElementNew(pageProgressPercentage, 30);
			Assert.assertTrue(pageProgressPercentage.getText().contains("8% Complete"));
			waitforElementNew(coverageTitle);
			Assert.assertTrue(coverageTitle.getText().contains("What type of coverage are you looking for?"));
		}

	public void browserBack() {

		driver.navigate().back();
	}
}
