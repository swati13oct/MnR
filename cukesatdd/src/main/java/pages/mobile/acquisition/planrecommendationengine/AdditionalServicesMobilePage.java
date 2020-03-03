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

public class AdditionalServicesMobilePage extends UhcDriver {

	public AdditionalServicesMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Additional";

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

// Additional Services page Elements

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

	@FindBy(css = "#errorMessage")
	private WebElement errorMessage;

	@FindBy(css = ".container div>button[class*='primary button']")
	private WebElement continueBtn;

	@FindBy(css = ".container div>button[class*='secondary']")
	private WebElement previousBtn;

	// --- Common elements Ends above ---

	@FindBy(css = "h2.primary-question-tex")
	private WebElement additionalPagePrimaryQuestion;

	@FindBy(css = "h2.primary-question-tex>sup")
	private WebElement additionalPagePrimaryQuestionMark;

	@FindBy(css = "div>p.description-text")
	private WebElement additionalPagePrimaryQuestionDecsription;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(1)>legend.primary-question-tex")
	private WebElement dentalQuestion;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(1) uhc-radio[ng-reflect-value='Yes']>label")
	private WebElement dentalYes;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(1) uhc-radio[ng-reflect-value='No']>label")
	private WebElement dentalNo;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(1) uhc-alert")
	private WebElement dentalError;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(2)>legend.primary-question-tex")
	private WebElement hearingQuestion;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(2) uhc-radio[ng-reflect-value='Yes']>label")
	private WebElement hearingYes;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(2) uhc-radio[ng-reflect-value='No']>label")
	private WebElement hearingNo;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(2) uhc-alert")
	private WebElement hearingError;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(3)>legend.primary-question-tex")
	private WebElement visionQuestion;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(3) uhc-radio[ng-reflect-value='Yes']>label")
	private WebElement visionYes;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(3) uhc-radio[ng-reflect-value='No']>label")
	private WebElement visionNo;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(3) uhc-alert")
	private WebElement visionError;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(4)>legend.primary-question-tex")
	private WebElement fitnessQuestion;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(4) uhc-radio[ng-reflect-value='Yes']>label")
	private WebElement fitnessYes;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(4) uhc-radio[ng-reflect-value='No']>label")
	private WebElement fitnessNo;

	@FindBy(css = "fieldset.radioGroupOpt:nth-of-type(4) uhc-alert")
	private WebElement fitnessError;

//Additional Page Element Verification Method 

	public void additionalpage() {
		System.out.println("Validating Additional Services Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Step 8: Additional"));
		validate(pageProgressPercentage, 30);
		Assert.assertTrue(pageProgressPercentage.getText().contains("56% Complete"));
		validate(pageRequiredInfo);
		Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		validate(additionalPagePrimaryQuestion);
		Assert.assertTrue(additionalPagePrimaryQuestion.getText().contains("additional"));
		validate(additionalPagePrimaryQuestionMark);
		validate(additionalPagePrimaryQuestionDecsription);
		Assert.assertTrue(additionalPagePrimaryQuestionDecsription.getText().contains("additional"));

		validate(dentalQuestion, 30);
		Assert.assertTrue(dentalQuestion.getText().contains("Dental"));
		validate(hearingQuestion, 30);
		Assert.assertTrue(hearingQuestion.getText().contains("Hearing"));
		validate(visionQuestion, 30);
		Assert.assertTrue(visionQuestion.getText().contains("Vision"));
		validate(fitnessQuestion, 30);
		Assert.assertTrue(fitnessQuestion.getText().contains("Fitness"));

		mobileUtils.mobileLocateElementClick(dentalYes);
		mobileUtils.mobileLocateElementClick(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		mobileUtils.previouspageValidation(page.toUpperCase());
	}

// Selecting additional options in additional Page

	public void additionalpageOptions(String dental, String hearing, String vision, String fitness) {
		System.out.println("Additional option selection in additional Page");
		validate(dentalQuestion);
		validate(hearingQuestion);
		validate(visionQuestion);
		validate(fitnessQuestion);
		if (dental.equalsIgnoreCase("Yes")) {
			mobileUtils.mobileLocateElementClick(dentalYes);
			System.out.println("additional Type Dental " + dental + " Clicked");
		}
		if (dental.equalsIgnoreCase("No")) {
			mobileUtils.mobileLocateElementClick(dentalNo);
			System.out.println("additional Type Dental " + dental + " Clicked");
		}
		if (hearing.equalsIgnoreCase("Yes")) {
			mobileUtils.mobileLocateElementClick(hearingYes);
			System.out.println("additional Type Hearing " + hearing + " Clicked");
		}
		if (hearing.equalsIgnoreCase("No")) {
			mobileUtils.mobileLocateElementClick(hearingNo);
			System.out.println("additional Type Hearing " + hearing + " Clicked");
		}
		if (vision.equalsIgnoreCase("Yes")) {
			mobileUtils.mobileLocateElementClick(visionYes);
			System.out.println("additional Type Vision " + vision + " Clicked");
		}
		if (vision.equalsIgnoreCase("No")) {
			mobileUtils.mobileLocateElementClick(visionNo);
			System.out.println("additional Type Vision " + vision + " Clicked");
		}
		if (fitness.equalsIgnoreCase("Yes")) {
			mobileUtils.mobileLocateElementClick(fitnessYes);
			System.out.println("additional Type Fitness " + fitness + " Clicked");
		}
		if (fitness.equalsIgnoreCase("No")) {
			mobileUtils.mobileLocateElementClick(fitnessNo);
			System.out.println("additional Type Fitness " + fitness + " Clicked");
		}
	}

// Selecting additional options and processed to Additional Service Page

	public void additionalpageFunctional(String additionalOptions) {
		System.out.println("additional Page Functional Operations");
		additionalpageOptions(additionalOptions.split(",")[0], additionalOptions.split(",")[1],
				additionalOptions.split(",")[2], additionalOptions.split(",")[3]);
		mobileUtils.mobileLocateElementClick(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		mobileUtils.nextPageValidation(page.toUpperCase());
	}

//Additional Page Error Function Verification     

	public void additionalpageerror(String additionalOptions) {
		System.out.println("Additional option is not selected - Error Scenario in additional Page");
		mobileUtils.mobileLocateElementClick(continueBtn);
		Assert.assertTrue(dentalError.getText().contains("No"));
		Assert.assertTrue(hearingError.getText().contains("No"));
		Assert.assertTrue(visionError.getText().contains("No"));
		Assert.assertTrue(fitnessError.getText().contains("No"));
		additionalpageOptions(additionalOptions.split(",")[0], additionalOptions.split(",")[1],
				additionalOptions.split(",")[2], additionalOptions.split(",")[3]);
		if (validate(dentalError, 5) == true) {
			System.out.println("Dental Error is not closed");
			Assert.assertTrue(false);
		}
		if (validate(hearingError, 5) == true) {
			System.out.println("Hearing Error is not closed");
			Assert.assertTrue(false);
		}
		if (validate(visionError, 5) == true) {
			System.out.println("Vision Error is not closed");
			Assert.assertTrue(false);
		}
		if (validate(fitnessError, 5) == true) {
			System.out.println("Fitness Error is not closed");
			Assert.assertTrue(false);
		}
		mobileUtils.mobileLocateElementClick(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		mobileUtils.nextPageValidation(page.toUpperCase());
	}

}
