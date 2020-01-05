/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class CoverageOptionsMobilePage extends UhcDriver {

	public CoverageOptionsMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);

	}

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	
	String page = "Coverage";
	
	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	// Coverage Option page Elements

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
	
	@FindBy(css = ".container div[class*='buttonPanel']>button[class*='primary button']")
	private WebElement continueBtn;

	@FindBy(css = ".container div>button[class*='secondary']")
	private WebElement previousBtn;

	@FindBy(css = "#errorMessage")
	private WebElement errorMessage;

	// --- Common elements Ends above ---

	@FindBy(css = "div legend.primary-question-tex")
	private WebElement coveragePagePrimaryQuestion;

	@FindBy(css = "div legend.primary-question-tex>sup")
	private WebElement coveragePagePrimaryQuestionAsteriskMark;

	// Options
	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label")
	private WebElement plantypeMAPD;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
	private WebElement plantypeMA;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(4)>label")
	private WebElement plantypePDP;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(5)>label")
	private WebElement plantypeNone;

	// Coverage actions elements

	@FindBy(css = "div .radio-checked")
	private WebElement radioselect;

	// Coverage Option Page Element Verification Method

	public void coverageOptionpageElementsMobile() {
		System.out.println("Coverage Option Validating Page: ");
		validate(planSelectorPageTilte,30);
		validate(pageStepsNumberName, 30);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Coverage Option"));
		validate(progressbar, 30);
		validate(pageProgressPercentage, 30);
		Assert.assertTrue(pageProgressPercentage.getText().contains("8% Complete"));
		validate(pageRequiredInfo,30);
		validate(coveragePagePrimaryQuestion,30);
		Assert.assertTrue(coveragePagePrimaryQuestion.getText().contains("coverage"));
		validate(coveragePagePrimaryQuestionAsteriskMark,30);
		Assert.assertTrue(coveragePagePrimaryQuestionAsteriskMark.getText().contains("*"));
		validate(plantypeMAPD, 30);
		Assert.assertTrue(plantypeMAPD.getText().contains("and"));
		mobileswipe("70%", true);
		validate(plantypeMA, 30);
		Assert.assertTrue(plantypeMA.getText().contains("Medical"));
		validate(plantypePDP, 30);
		Assert.assertTrue(plantypePDP.getText().contains("Prescription"));
		validate(plantypeNone, 30);
		Assert.assertTrue(plantypeNone.getText().contains("don't"));
		validate(continueBtn, 30);
		validate(previousBtn, 30);
	}

	// Coverage Option Page Function Verification

	public void coverageOptionpageFunctionalMobile(String planType, boolean proceed) {
		System.out.println("Coverage Page Selections");
		if (planType.equalsIgnoreCase("MAPD")) {
			validate(plantypeMAPD,30);
			plantypeMAPD.click();
		} else if (planType.equalsIgnoreCase("MA")) {
			validate(plantypeMA,30);
			plantypeMA.click();
		} else if (planType.equalsIgnoreCase("PDP")) {
			mobileUtils.mobileFindElementBeforeCallBanner(plantypePDP,"50%",5,true);
			plantypePDP.click();
		} else if (planType.equalsIgnoreCase("NA")) {
			mobileUtils.mobileFindElementBeforeCallBanner(plantypeNone,"50%",5,true);
			plantypeNone.click();
		}
		System.out.println("Plan Type " + planType + " Clicked");
		if (proceed) {
			mobileUtils.mobileFindElementBeforeCallBanner(continueBtn,"50%",5,true);
			continueBtn.click();
			System.out.println("Validating "+page+" page Continue button functionality");
			//mobileUtils.nextPageValidation(page.toUpperCase());
		}
	}

	// Coverage Option Page Function Verification
	public void coverageOptionpageErrormobile() {
		System.out.println("Plan Type is empty - Error Scenario in Coverage Options Page");
		mobileUtils.mobileFindElementBeforeCallBanner(continueBtn,"50%",5,true);
		continueBtn.click();
		Assert.assertTrue(errorMessage.getText().contains("Please"));
	}

	// Previous Button Functionality for Coverage Options Page
		public void previouspageValidation() {
			System.out.println("Previous page Validation");
			if (radioselect.isDisplayed()) {
				mobileUtils.mobileFindElementBeforeCallBanner(previousBtn,"50%",5,true);
				previousBtn.click();
				threadsleep(2000);
				validate(pageProgressPercentage, 30);
				Assert.assertTrue(pageProgressPercentage.getText().contains("8% Complete"));
			}
		}
}
