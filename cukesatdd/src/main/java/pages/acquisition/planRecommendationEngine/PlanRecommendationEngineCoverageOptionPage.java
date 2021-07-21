/**
 * 
 */
package pages.acquisition.planRecommendationEngine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pages.acquisition.commonpages.GlobalWebElements;

public class PlanRecommendationEngineCoverageOptionPage extends GlobalWebElements {

	public PlanRecommendationEngineCoverageOptionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Coverage";

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

// Coverage Option page Elements

	@FindBy(css = "#progress-bar-title")
	private WebElement planSelectorPageTilte;

	@FindBy(xpath = "//*[@class='progress-bar-info']/h2")
	private WebElement pageStepsNumberName;

	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "div.row.pb-1>div>uhc-radio-group>fieldset>legend.primary-question-tex")
	private WebElement coverageTitle;

	@FindBy(xpath = "//label[@class='radio-label']/div[contains(text(),'Medical and prescription drug')]")
	private WebElement SelectcoverageOptions;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;

	@FindBy(css = "p.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label>span.radio-label-content")
	private WebElement plantypeMAPD;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
	private WebElement plantypeMA;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(4)>label")
	private WebElement plantypePDP;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(5)>label")
	private WebElement plantypeNone;

	@FindBy(css = "#errorMessage>span:nth-child(2)")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[contains(@class,'radio-checked')]")
	private WebElement radioselect;

//Coverage Option Page Element Verification Method 

	public void coverageOptionpage() {
		System.out.println("Coverage Option Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
//		Assertion.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		desktopCommonUtils.currentPageValidation(page.toUpperCase());
		validate(pageRequiredInfo);
//		Assertion.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		validate(coverageTitle);
//		Assertion.assertTrue(coverageTitle.getText().contains("coverage"));
		validate(plantypeMAPD, 30);
//		Assertion.assertTrue(plantypeMAPD.getText().contains("and"));
		validate(plantypeMA, 30);
//		Assertion.assertTrue(plantypeMA.getText().contains("Medical"));
		validate(plantypePDP, 30);
//		Assertion.assertTrue(plantypePDP.getText().contains("Prescription"));
		validate(plantypeNone, 30);
//		Assertion.assertTrue(plantypeNone.getText().contains("don't"));
//		previousBtn.click();
		jsClickNew(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		desktopCommonUtils.previousPageValidation(page.toUpperCase());
	}

//Coverage Option Page Function Verification		

	public void coverageOptionpageFunctional(String planType) {
		System.out.println("Functional Operations");
		chooseCoverageOption(planType);
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
//		desktopCommonUtils.nextPageValidation(page.toUpperCase());
	}

//Coverage option page - Select Plantype and click on Previous Button	

	public void coverageOptionpagePreviousButton(String planType) {
		System.out.println("Functional Operations");
		chooseCoverageOption(planType);
		if (radioselect.isDisplayed()) {
			validate(pageProgressPercentage, 30);
			Assert.assertTrue(pageProgressPercentage.getText().contains("11% Complete"));
		} else {
			System.out.println("Plan Type not selected in Coverage Options Page");
		}
		previousBtn.click();
		System.out.println("Validating " + page + " page Previous button functionality");
		desktopCommonUtils.previousPageValidation(page.toUpperCase());
	}

//Coverage Option Page Function Verification			
	public void coverageOptionpageerror() {
		System.out.println("Plan Type is empty - Error Scenario in Coverage Options Page");
//		continueBtn.click();
		jsClickNew(continueBtn);
		desktopCommonUtils.desktopErrorValidation(page);
	}

	public void browserBack() {

		driver.navigate().back();
	}
	
	public void chooseCoverageOption(String planType) {
		if (planType.equalsIgnoreCase("MAPD")) {
			validate(plantypeMAPD);
//			plantypeMAPD.click();						//E2E : updated to jsClickNew as .click does not work in Safari13 
			jsClickNew(plantypeMAPD);
			System.out.println("Plan Type " + planType + " Clicked");
		} else if (planType.equalsIgnoreCase("MA")) {
			validate(plantypeMA);
//			plantypeMA.click();
			jsClickNew(plantypeMA);
			System.out.println("Plan Type " + planType + " Clicked");
		} else if (planType.equalsIgnoreCase("PDP")) {
			validate(plantypePDP);
//			plantypePDP.click();
			jsClickNew(plantypePDP);
			System.out.println("Plan Type " + planType + " Clicked");
		} else if (planType.equalsIgnoreCase("None")) {
			validate(plantypeNone);
//			plantypeNone.click();
			jsClickNew(plantypeNone);
			System.out.println("Plan Type " + planType + " Clicked");
		}
	}

}
