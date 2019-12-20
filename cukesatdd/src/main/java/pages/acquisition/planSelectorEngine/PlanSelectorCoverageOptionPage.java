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

import acceptancetests.util.CommonUtility;
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
	
	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;
	
	@FindBy(css = "div.row.pb-1>div>fieldset>legend.primary-question-tex")
	private WebElement coverageTitle;
	
	@FindBy(xpath = "//label[@class='radio-label']/div[contains(text(),'Medical and prescription drug')]")
	private WebElement SelectcoverageOptions;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;
	
	@FindBy(css = "p.all-fields-marked-wi")
	private WebElement pageRequiredInfo;
	
	@FindBy(css = "#custom-radio-group>uhc-radio:nth-child(1)>label")
	private WebElement plantypeMAPD;
	
	@FindBy(css = "#custom-radio-group>uhc-radio:nth-child(2)>label")
	private WebElement plantypeMA;
	
	@FindBy(css = "#custom-radio-group>uhc-radio:nth-child(3)>label")
	private WebElement plantypePDP;
	
	@FindBy(css = "#custom-radio-group>uhc-radio:nth-child(4)>label")
	private WebElement plantypeNone;
	
	@FindBy(css = "#errorMessage>div:nth-child(2)")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//*[contains(@class,'radio-checked')]")
	private WebElement radioselect;

//Coverage Option Page Element Verification Method 
	
		public void coverageOptionpage() {
			System.out.println("Coverage Option Validating Page: ");
			String currentPageUrl = driver.getCurrentUrl();	
			currentPageUrl.contains("/coverageOption");
			validate(planSelectorPageTilte);
			Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
			validate(pageStepsNumberName, 30);
			Assert.assertTrue(pageStepsNumberName.getText().contains("Step 2: Coverage Option"));
			validate(pageProgressPercentage, 30);
			Assert.assertTrue(pageProgressPercentage.getText().contains("8% Complete"));
			validate(pageRequiredInfo);
			Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
			validate(coverageTitle);
			Assert.assertTrue(coverageTitle.getText().contains("coverage"));
			validate(plantypeMAPD, 30);
			Assert.assertTrue(plantypeMAPD.getText().contains("and"));
			validate(plantypeMA, 30);
			Assert.assertTrue(plantypeMA.getText().contains("Medical"));
			validate(plantypePDP, 30);
			Assert.assertTrue(plantypePDP.getText().contains("Prescription"));
			validate(plantypeNone, 30);
			Assert.assertTrue(plantypeNone.getText().contains("don't"));
			
		}
		
//Coverage Option Page Function Verification		
		
		public void coverageOptionpageFunctional(String planType) {
			System.out.println("Functional Operations");
			if (planType.equalsIgnoreCase("MAPD")) {
				validate(plantypeMAPD);
				plantypeMAPD.click();
				System.out.println("Plan Type "+planType +" Clicked");
			}else if (planType.equalsIgnoreCase("MA")) {
				validate(plantypeMA);
				plantypeMA.click();
				System.out.println("Plan Type "+planType +" Clicked");
			}else if (planType.equalsIgnoreCase("PDP")) {
				validate(plantypePDP);
				plantypePDP.click();
				System.out.println("Plan Type "+planType +" Clicked");
			}else if (planType.equalsIgnoreCase("NA")) {
				validate(plantypeNone);
				plantypeNone.click();
				System.out.println("Plan Type "+planType +" Clicked");
			}			
			continueBtn.click();
			
		}
		
//Coverage option page - Select Plantype and click on Previous Button	
		
		public void coverageOptionpagePreviousButton(String planType) {
			System.out.println("Functional Operations");
			if (planType.equalsIgnoreCase("MAPD")) {
				validate(plantypeMAPD);
				plantypeMAPD.click();
				System.out.println("Plan Type "+planType +" Clicked");
			}else if (planType.equalsIgnoreCase("MA")) {
				validate(plantypeMA);
				plantypeMA.click();
				System.out.println("Plan Type "+planType +" Clicked");
			}else if (planType.equalsIgnoreCase("PDP")) {
				validate(plantypePDP);
				plantypePDP.click();
				System.out.println("Plan Type "+planType +" Clicked");
			}else if (planType.equalsIgnoreCase("NA")) {
				validate(plantypeNone);
				plantypeNone.click();
				System.out.println("Plan Type "+planType +" Clicked");
			}
			if(radioselect.isDisplayed()) {
				validate(pageProgressPercentage, 30);
				Assert.assertTrue(pageProgressPercentage.getText().contains("8% Complete"));
			}else {
				System.out.println("Plan Type not selected in Coverage Options Page");
			}
			previousBtn.click();
			
		}
		
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
			if(radioselect.isDisplayed()) {
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
