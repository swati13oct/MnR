/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
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

	@FindBy(css = "div>.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = ".all-fields-marked-wi>sup")
	private WebElement pageRequiredInfoAsteriskMark;
	// --- Common elements Ends above ---

	@FindBy(css = "div legend.primary-question-tex")
	private WebElement coveragePagePrimaryQuestion;

	@FindBy(css = "div legend.primary-question-tex>sup")
	private WebElement coveragePagePrimaryQuestionAsteriskMark;

	// Options
	@FindBy(css = "#custom-radio-group>uhc-radio:nth-child(1)>label")
	private WebElement plantypeMAPD;

	@FindBy(css = "#custom-radio-group>uhc-radio:nth-child(2)>label")
	private WebElement plantypeMA;

	@FindBy(css = "#custom-radio-group>uhc-radio:nth-child(3)>label")
	private WebElement plantypePDP;

	@FindBy(css = "#custom-radio-group>uhc-radio:nth-child(4)>label")
	private WebElement plantypeNone;

	@FindBy(css = ".container div>button[class*='primary button']")
	private WebElement continueBtn;

	@FindBy(css = ".container div>button[class*='secondary']")
	private WebElement previousBtn;

	// Coverage actions elements

	@FindBy(css = "#errorMessage")
	private WebElement errorMessage;

	@FindBy(css = "div .radio-checked")
	private WebElement radioselect;

	// Coverage Option Page Element Verification Method

	public void coverageOptionpageElementsMobile() {
		System.out.println("Coverage Option Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/coverageOption");
		waitforElementNew(planSelectorPageTilte);
		waitforElementNew(pageStepsNumberName, 30);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Coverage Option"));
		waitforElementNew(progressbar, 30);
		waitforElementNew(pageRequiredInfo);
		waitforElementNew(coveragePagePrimaryQuestion);
		Assert.assertTrue(coveragePagePrimaryQuestion.getText().contains("coverage"));
		waitforElementNew(coveragePagePrimaryQuestionAsteriskMark);
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
			waitforElementNew(plantypeMAPD);
			plantypeMAPD.click();
		} else if (planType.equalsIgnoreCase("MA")) {
			waitforElementNew(plantypeMA);
			plantypeMA.click();
		} else if (planType.equalsIgnoreCase("PDP")) {
			waitforElementNew(plantypePDP);
			plantypePDP.click();
		} else if (planType.equalsIgnoreCase("NA")) {
			waitforElementNew(plantypeNone);
			plantypeNone.click();
		}
		System.out.println("Plan Type " + planType + " Clicked");
		if (proceed) {
			continueBtn.click();
			threadsleep(2000);
			String currentPageUrl = driver.getCurrentUrl();
			Assert.assertTrue(currentPageUrl.contains("/result"));
		}
	}

	// Coverage Option Page Function Verification
	public void coverageOptionpageErrormobile() {
		System.out.println("Plan Type is empty - Error Scenario in Coverage Options Page");
		continueBtn.click();
		Assert.assertTrue(errorMessage.getText().contains("Please"));
	}

	// Previous Button Functionality for Coverage Options Page
	public void previouspageValidation() {
		System.out.println("Previous page Validation");
		if (radioselect.isDisplayed()) {
			previousBtn.click();
			threadsleep(2000);
			String currentPageUrl = driver.getCurrentUrl();
			Assert.assertTrue(currentPageUrl.contains("/location"));
		}
	}

}
