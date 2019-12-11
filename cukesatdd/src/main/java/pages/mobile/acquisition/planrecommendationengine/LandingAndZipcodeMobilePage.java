/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import acceptancetests.data.PageConstants;
import acceptancetests.mobile.acquisition.planrecommendationengine.PlanRecommendationStepDefinitionMobile;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;

import pages.mobile.acquisition.planrecommendationengine.HeaderFooterMobile;

public class LandingAndZipcodeMobilePage extends UhcDriver {

	public LandingAndZipcodeMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Landing Page Elements
	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	@FindBy(xpath = "//*[contains(@class,'get-started-banner')]//button[contains(text(),'Get Started')]")
	private WebElement getStartedBtn;

	@FindBy(xpath = "//*[contains(@class,'get-started-main-inner')]//button[contains(text(),'Get Started')]")
	private WebElement getStartedBtn1;

	@FindBy(xpath = "//h1[contains(@class,'text-display')]")
	private WebElement landingpageHeader;

	@FindBy(xpath = "//*[@class='get-started-banner']//img[@class='mb-3 mb-0-lg']")
	private WebElement landingpageAnimationImage;

	@FindBy(xpath = "//*[@class='get-started-main-inner']//img[@class='mb-3 mb-0-lg']")
	private WebElement landingpageImage;

	@FindBy(xpath = "//*[@class='get-started-banner']//p")
	private WebElement landingpageText;

	@FindBy(className = "get-started-main-inner")
	private WebElement landingpageMainInner;

	@FindBy(xpath = "//*[contains(@class,'get-started-main-inner')]//h2[@class='get-started-main-title how-does-this-work']")
	private WebElement landingpageInnerTitle;

	@FindBy(xpath = "//*[@class='get-started-main-inner']//h3[contains(@class,'it-may-help-to-have')]")
	public WebElement landingpageLabel;

	// ZipCode Elements
		//Default Page elements
		@FindBy(css = "nav>.breadcrumb")
		private WebElement breadCrumb;
	
		@FindBy(css = ".progress-bar-title>h1")
		private WebElement planSelectorPageTilte;
		
		@FindBy(css = ".progress-bar-info>h2")
		private WebElement pageStepsNumberName;
		
		@FindBy(css = "div.progress-bar-value-background")
		private WebElement progressbar;
		
		@FindBy(css = "div>.all-fields-marked-wi")
		private WebElement pageRequiredInfo;
		
		@FindBy(css = ".all-fields-marked-wi>sup")
		private WebElement pageRequiredInfoMark;
		
		@FindBy(css = "div>.primary-question-tex")
		private WebElement zipcodePageQuestion;
		
		@FindBy(css = "div>.primary-question-tex>sup")
		private WebElement zipcodePageQuestionMark;
		
		@FindBy(css = "#referenceTxt")
		private WebElement zipcodeTextLabel;
		
		@FindBy(id = "zip-code")
		private WebElement zipCode;
		
		@FindBy(css = ".container div>button[class*='primary button']")
		private WebElement continueBtn;

		// zip code actions elements
		@FindBy(id = "zipInfo")
		private WebElement countyInfo;
		
		@FindBy(css = "label[for='MultipleCounty']")
		private WebElement multicountyText;
		
		@FindBy(id = "MultipleCounty")
		private WebElement multicountySelect;
		
		@FindBy(css = "#MultipleCounty > option:nth-child(1)")
		private WebElement defaultmultioptioninnerText;

		@FindBy(css = "label[for='MultipleCounty']>sup")
		private WebElement zipcodePageCountyQuestionMark;
		
		@FindBy(id = "errorMessage")
		private WebElement errorMessage;

		
		
		
	//Coverage Page Elements		
		
		@FindBy(xpath = "//*[@id='CoverageType_Idontknow_Option_7_Lable']/following-sibling ::label")
		private WebElement TypeOfCoverageOption;
		
		@FindBy(xpath = "//button[contains(text(),'Previous')]")
		private WebElement previousBtn;
		
		@FindBy(css = "div.row.pb-1>div>label.primary-question-tex")
		private WebElement coverageTitle;
		
	
	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
		waitforElementVisibilityInTime(getStartedBtn, 30);
	}

	public void landingpagemobile() {
		System.out.println("Validating Title: ");
		String ExpectedTitle = "insurance plan";
		validate(landingpageHeader, 30);
		String ActualTitle = landingpageHeader.getText();
		System.out.println(ActualTitle.contains(ExpectedTitle));
		System.out.println("Validating Animation Images: ");
		validate(landingpageAnimationImage, 30);
		System.out.println("Validating Text: ");
		validate(landingpageText, 30);
		mobileswipe("70%", true);
		String ExpectedText = "plan recommendation";
		String ActualText = landingpageText.getText();
		System.out.println(ActualText.contains(ExpectedText));
		validate(getStartedBtn, 30);
		validate(landingpageMainInner, 30);
		System.out.println("Validating Title in Inner Section: ");
		validate(landingpageInnerTitle, 30);
		String ExpectedText1 = "How does this work?";
		String ActualText1 = landingpageInnerTitle.getText();
		System.out.println(ActualText1.equalsIgnoreCase(ExpectedText1));
		for (int i = 1; i <= 3; i++) {
			String landingpageTracker = (driver.findElement(By.xpath("//*[@class='get-started-list']/li[" + i + "]"))).getText();
			System.out.println(landingpageTracker);
			String landingpageTextPoints = (driver.findElement(By.xpath("//*[@class='get-started-main-inner']//*[@class='your-medicare-id-car mt-2']/li[" + i + "]/span"))).getText();
			System.out.println(landingpageTextPoints);
		}
		mobileswipe("70%", true);
		validate(landingpageImage, 30);
		validate(landingpageLabel, 30);
		waitTillElementClickableInTime(getStartedBtn1, 45);
	}

	public void zipcodepageelementsmobile() {
		validate(breadCrumb, 30);
		validate(planSelectorPageTilte, 30);
		validate(pageStepsNumberName, 30);
		validate(progressbar, 30);
		validate(pageRequiredInfo, 30);
		validate(pageRequiredInfoMark, 30);
		validate(zipcodePageQuestion, 30);
		validate(zipcodePageQuestionMark, 30);
		validate(zipcodeTextLabel, 30);
		validate(zipCode, 30);
		validate(continueBtn, 30);
	}
	
	public void zipcodepagevalidationmobile(HashMap<String,String> inputdata) {
		zipCode.sendKeys(inputdata.get("Zip Code"));
		hidekeypad();
		if(inputdata.get("Is Multi County").equalsIgnoreCase("no")){
			validate(countyInfo, 20);
			Assert.assertTrue(countyInfo.getText().contains(inputdata.get("County Name")));
		}
		else {
			validate(multicountyText,20);
			validate(defaultmultioptioninnerText,20);
			validate(zipcodePageCountyQuestionMark,20);
			Assert.assertTrue(defaultmultioptioninnerText.getText().contains("Select"));
			validate(multicountySelect,20);
			Select multicounty = new Select(multicountySelect);
			multicounty.selectByVisibleText(inputdata.get("CountyDropDown"));
			mobileswipe("40%", true);
		}
		continueBtn.click();
		threadsleep(2000);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Coverage Option"));
	}
	
	public void zipcodescreenerrorvalidationmobile(HashMap<String,String> inputdata) {
		zipCode.sendKeys(inputdata.get("Zip Code"));
		hidekeypad();
		if(inputdata.get("Is Multi County").equalsIgnoreCase("yes")) {
			validate(multicountySelect,20);
			mobileswipe("40%", true);
		}
		continueBtn.click();
		mobileswipe("40%", false);
		validate(errorMessage, 20);
		Assert.assertTrue(errorMessage.getText().contains("Please"));
		threadsleep(2000);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Location"));
	}
	
	public void navigatepagemobile(String pagename) {
		HeaderFooterMobile header = new HeaderFooterMobile(driver);
		header.navigatePRELandingpageMobile();
		mobileswipe("50%", true);
		validate(getStartedBtn, 30);
		getStartedBtn.click();
	}
	
	public void validatecontains(String primarystring, String substring) {
		if (!primarystring.matches(substring)) {
			System.out.println("Expected string - " + substring + " is not available in - " + primarystring);
			Assert.assertTrue(false);
		}
	}
	
	public void threadsleep(int sec) {
		try {
			Thread.sleep(sec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
