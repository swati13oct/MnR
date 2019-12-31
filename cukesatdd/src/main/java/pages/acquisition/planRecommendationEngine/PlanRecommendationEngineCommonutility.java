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
	

		
//Coverage Option Page Function Verification			
		public void coverageOptionpageerror() {
			System.out.println("Plan Type is empty - Error Scenario in Coverage Options Page");
			continueBtn.click();
			Assert.assertTrue(errorMessage.getText().contains("Please"));
		}
		
//Previous Button Functionality for Coverage Options Page
		public void previouspageValidation() {
			System.out.println("Previous page Validation");
			try {
			if(errorMessage.isDisplayed()) {
				validate(pageProgressPercentage, 30);
				Assert.assertTrue(pageProgressPercentage.getText().contains("16% Complete"));
			}else if(pageStepsNumberName.getText().contains("Location")){
				validate(pageProgressPercentage, 30);
				Assert.assertTrue(pageProgressPercentage.getText().contains("8% Complete"));
			}
		}
			catch(Exception e){
				System.out.println("Page is not Visible");
			}
		}

	public void browserBack() {

		driver.navigate().back();
	}
}
