/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine.e2e;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import io.appium.java_client.AppiumDriver;
import pages.acquisition.commonpages.AcquisitionHomePage;

public class PlanRecommendationEngineLandingAndZipcodeMobilePages extends UhcDriver {

	public PlanRecommendationEngineLandingAndZipcodeMobilePages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
		waitforElementVisibilityInTime(getStartedBtn, 30);

	}

	String page = "Location";

	PlanRecommendationEngineCommonutilityMobile desktopCommonUtils = new PlanRecommendationEngineCommonutilityMobile(
			driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	// Landing page Elements

	@FindBy(css = "div[class*='get-started-banner'] button")
	private WebElement getStartedBtn;

	@FindBy(css = "div[class*='get-started-main-inner'] button")
	private WebElement getStartedBtn1;

	@FindBy(xpath = "//*[contains(text(),'Get Help Finding a Plan')]")
	private WebElement landingpageHeader;

	@FindBy(xpath = "//*[@class='get-started-banner']//img[@class='mb-3 mb-0-lg']")
	private WebElement landingpageAnimationImage;

	@FindBy(xpath = "//*[@class='get-started-main-inner']//img[@class='mb-3 mb-0-lg']")
	private WebElement landingpageImage;

	@FindBy(xpath = "//*[@id='answer-a-few-simple']")
	private WebElement landingpageText;

	@FindBy(className = "get-started-main-inner")
	private WebElement landingpageMainInner;

	@FindBy(xpath = "//*[contains(@class,'get-started-main-inner')]/div[1]/div/h2")
	private WebElement landingpageInnerTitle;

	@FindBy(xpath = "//*[contains(@class,'get-started-main-inner')]/div[3]/div/h3")
	public WebElement landingpageLabel;

	// ZipCode Elements

	@FindBy(id = "zip-code")
	private WebElement zipCode;

	@FindBy(css = "#MultipleCounty")
	private WebElement multicountySelect;

	@FindBy(id = "zipInfo")
	private WebElement countyInfo;

	@FindBy(id = "MultipleCounty")
	private WebElement PRECounty;

	@FindBy(css = "#MultipleCounty > option:nth-child(1)")
	private WebElement PRECountyInnerText;

	@FindBy(xpath = "//*[@id='CoverageType_Idontknow_Option_7_Lable']/following-sibling ::label")
	private WebElement TypeOfCoverageOption;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(id = "errorMessage")
	private WebElement errorMessage;

	@FindBy(css = "#progress-bar-title")
	private WebElement planSelectorPageTilte;

	@FindBy(xpath = "//*[@class='progress-bar-info']/h2")
	private WebElement pageStepsNumberName;

	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "div>.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = ".all-fields-marked-wi>sup")
	private WebElement pageRequiredInfoMark;

	@FindBy(css = ".row>div>div:nth-child(3)>label.primary-question-tex")
	private WebElement zipcodePageQuestion;

	@FindBy(xpath = "//*[@for='zip-code']/sup")
	private WebElement zipcodePageQuestionMark;

	@FindBy(css = "#referenceTxt")
	private WebElement zipcodeTextLabel;

	@FindBy(xpath = "//*[@for='MultipleCounty']")
	private WebElement zipcodePageCountyQuestion;

	@FindBy(xpath = "//*[@for='MultipleCounty']/sup")
	private WebElement zipcodePageCountyQuestionMark;

	// Coverage Page Elements
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;

	@FindBy(css = "#custom-radio-group>fieldset>legend>span:nth-child(1)")
	private WebElement coverageTitle;

	// Landing Page Element Verification Method

	public void landingpage() {

		System.out.println("Validating Animation Images: ");
		validate(landingpageAnimationImage, 30);
		System.out.println("Validating Text: ");
		validate(landingpageText, 30);
		mobileswipe("70%", true);

		for (int i = 1; i <= 3; i++) {
			String landingpageTracker = (driver.findElement(By.xpath("//*[@class='get-started-list']/li[" + i + "]")))
					.getText();
			System.out.println(landingpageTracker);
		}
		for (int j = 1; j <= 2; j++) {
			String landingpageTextPoints = (driver.findElement(By.xpath(
					"//*[@class='get-started-main-inner']//*[@class='your-medicare-id-car mt-2']/li[" + j + "]/span")))
							.getText();
			System.out.println(landingpageTextPoints);
		}
		validate(landingpageImage, 30);
		String landingpageLabelText = landingpageLabel.getText();
		System.out.println(
				landingpageLabelText.contains("It may help to have the following information before getting started:"));
		waitTillElementClickableInTime(getStartedBtn1, 45);
	}

	public void navigatezipcodepage() {
		pageloadcomplete();
		// if (!getStartedBtn.isDisplayed()) {
		// MobileMenuAndGetPlanRecom();
		// scrollToView(getStartedBtn);
		// jsClickNew(getStartedBtn);
		// } else
		// pageloadcomplete();
		// scrollToView(getStartedBtn);
		// jsClickNew(getStartedBtn);
		// // getStartedBtn.click();
		validate(zipCode, 30);
	}

	// SingleCounty Method Mobile
	public void quizStartsAndRunQuestionnaire(String zipcode) throws InterruptedException {
		pageloadcomplete();
		validateNew(getStartedBtn, 10);
		if (getStartedBtn.isDisplayed()) {
			jsClickNew(getStartedBtn);
			System.out.println("After clicking GetStarted");
			zipcodePage();
			waitforElementVisibilityInTime(zipCode, 45);

			// sendkeys(zipCode, zipcode);
			sendkeysMobile(zipCode, zipcode);

			waitforElementVisibilityInTime(countyInfo, 45);
			threadsleep(5000);
			jsClickNew(continueBtn);
			waitforElementVisibilityInTime(coverageTitle, 30);
			Assert.assertTrue(coverageTitle.getText().contains("coverage"));
		} else {

			System.out.println("After clicking GetStarted");
			zipcodePage();
			waitforElementVisibilityInTime(zipCode, 45);

			// sendkeys(zipCode, zipcode);
			sendkeysMobile(zipCode, zipcode);

			waitforElementVisibilityInTime(countyInfo, 45);
			threadsleep(5000);
			jsClickNew(continueBtn);
			waitforElementVisibilityInTime(coverageTitle, 30);
			Assert.assertTrue(coverageTitle.getText().contains("coverage"));
		}

	}

	// SingleCounty Method
	public void quizStartAndRunQuestionnaire(String zipcode) throws InterruptedException {

		System.out.println("Before clicking GetStarted");
		// MobileMenu();
		scrollToView(getStartedBtn);
		jsClickNew(getStartedBtn);
		System.out.println("After clicking GetStarted");
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zipcode);
		waitforElementVisibilityInTime(countyInfo, 45);
		threadsleep(5000);
		jsClickNew(continueBtn);
		waitforElementVisibilityInTime(coverageTitle, 30);
		// Assert.assertTrue(coverageTitle.getText().contains("coverage"));

	}

	// MultiCounty Method
	public void quizStartAndRunQuestionnaireWithCounty(String zip_code, String County) throws Exception {

		Thread.sleep(20000);
		// driver.switchTo().defaultContent();
		// switchToNewIframe(iframePst);
		// waitTillElementClickableInTime(getStartedBtn, 45);
		// waitTillElementClickableInTime(getStartedBtn1, 45);
		jsClickNew(getStartedBtn);
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeysMobile(zipCode, zip_code);
		// sendkeys(zipCode, zip_code);
		Thread.sleep(2000);
		zipcodePagemultiCounty();
		waitforElementVisibilityInTime(PRECounty, 45);
		selectFromDropDownByText(driver, PRECounty, County);
		threadsleep(5000);
		jsClickNew(continueBtn);
		waitforElementVisibilityInTime(coverageTitle, 30);
		/*
		 * Assert.assertTrue(coverageTitle.getText().contains("coverage"));
		 * waitforElementVisibilityInTime(previousBtn, 45); previousBtn.click();
		 * validate(planSelectorPageTilte);
		 * Assert.assertTrue(planSelectorPageTilte.getText().
		 * contains("Get help finding a plan"));
		 */
	}

	public void zipcodePage() {
		boolean hidden;
		System.out.println("Validating ZipcodePage Elements");
		/*
		 * String preBreadcrumbs =
		 * (driver.findElement(By.cssSelector("div.breadcrumb"))).getText();
		 * Assert.assertTrue(preBreadcrumbs.contains("Home / Plan Recommendation Engine"
		 * ));
		 */
		validate(planSelectorPageTilte);
		// Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding
		// a plan"));
		validate(pageStepsNumberName, 30);
		// Assert.assertTrue(pageStepsNumberName.getText().contains("Step 1:
		// Location"));
		// validate(pageProgressPercentage, 30);

		scrollToView(pageProgressPercentage);
		Assert.assertTrue(pageProgressPercentage.getText().contains("0% Complete"));
		validate(pageRequiredInfo);
		Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		validate(pageRequiredInfoMark);
		Assert.assertTrue(pageRequiredInfoMark.getText().contains("*"));
		validate(zipcodePageQuestion);
		Assert.assertTrue(zipcodePageQuestion.getText().contains("ZIP"));
		validate(zipcodePageQuestionMark);
		Assert.assertTrue(zipcodePageQuestionMark.getText().contains("*"));

		System.out.println(
				"************" + driver.findElement(By.xpath("//*[@id='zip-code']")).getAttribute("placeholder"));
		hidden = (driver.findElement(By.xpath("//*[@id='zip-code']")).getAttribute("placeholder") == "Enter ZIP Code")
				? true
				: false;
		System.out.println("Value of Enter Zipcode field is : " + hidden + " in Zip Code page");
		System.out.println((hidden != true) ? "Ener Zip Code Text is displayed" : "Enter Zip Code Text not displaying");

	}

	public void zipcodePagemultiCounty() {
		waitforElementVisibilityInTime(zipcodeTextLabel, 45);
		Assert.assertTrue(zipcodeTextLabel.getText().contains("Plans are specific to your area"));
		validate(zipcodePageCountyQuestion);
		Assert.assertTrue(zipcodePageCountyQuestion.getText().contains("County"));
		validate(zipcodePageCountyQuestionMark);
		Assert.assertTrue(zipcodePageCountyQuestionMark.getText().contains("*"));
		waitforElementVisibilityInTime(PRECounty, 45);
		// Assert.assertTrue(PRECountyInnerText.getText().contains("Select County "));
	}

	// Error Scenario's
	public void getStartedAndRunInvalidzipcode(String zipcodeid) throws InterruptedException {

		waitTillElementClickableInTime(getStartedBtn, 45);
		waitTillElementClickableInTime(getStartedBtn1, 45);
		getStartedBtn.click();
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zipcodeid);
		waitforElementVisibilityInTime(continueBtn, 45);
		continueBtn.click();
		desktopCommonUtils.desktopErrorValidation(page);
	}

	// Feedback PopUp
	@FindBy(css = "iframe[title*=' Survey']")
	private WebElement popupFrame;

	@FindBy(css = "button[id*='no']")
	private WebElement popupNo;

	public boolean close_Popup() {
		boolean popup_presents = false;
		System.out.println("Checking Popup Status...");
		if (validate(popupNo, 20)) {
			if (validate(popupFrame, 5))
				driver.switchTo().frame(popupFrame);
			threadsleep(1000);
			popupNo.click();
			threadsleep(1000);
			popup_presents = true;
		}
		driver.switchTo().defaultContent();
		return popup_presents;
	}

	// Error Scenario's for multiCounty
	public void getStartedAndRunzipcodeWithCounty(String zip_code, String County) throws Exception {

		waitTillElementClickableInTime(getStartedBtn, 45);
		waitTillElementClickableInTime(getStartedBtn1, 45);
		getStartedBtn.click();
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		//sendkeys(zipCode, zip_code);
		sendkeysMobile(zipCode, zip_code);
		Thread.sleep(2000);
		zipcodePagemultiCounty();
		continueBtn.click();
		desktopCommonUtils.desktopErrorValidation(page);
	}

	public void edit_location(String zipcode, String multi, String county) {
		waitforElementVisibilityInTime(zipCode, 45);
		zipCode.clear();
		sendkeys(zipCode, zipcode);
		if (multi.equalsIgnoreCase("Yes")) {
			waitforElementVisibilityInTime(PRECounty, 45);
			selectFromDropDownByText(driver, PRECounty, county);
		}
		threadsleep(3000);
	}

	public void browserBack() {

		driver.navigate().back();
	}

	public void zipcodeInfoValidation(HashMap<String, String> inputdata) {
		System.out.println("Verify Zip Info");
		validate(zipCode, 20);
		Assert.assertTrue(zipCode.getAttribute("ng-reflect-model").equals(inputdata.get("Zip Code")),
				"Invalid Zip code");
		if (inputdata.get("Is Multi County").equalsIgnoreCase("no")) {
			validate(countyInfo, 20);
			Assert.assertTrue(
					countyInfo.getText().toUpperCase().contains(inputdata.get("CountyDropDown").toUpperCase()),
					"County Name Error");
		} else {
			validate(multicountySelect, 20);
			Select multicounty = new Select(multicountySelect);
			Assert.assertTrue(
					multicounty.getFirstSelectedOption().getText().equalsIgnoreCase(inputdata.get("CountyDropDown")),
					"Invalid County Name");
		}
	}
}
