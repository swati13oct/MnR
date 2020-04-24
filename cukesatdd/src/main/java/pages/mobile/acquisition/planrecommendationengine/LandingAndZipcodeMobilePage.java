/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import atdd.framework.UhcDriver;

import pages.mobile.acquisition.planrecommendationengine.HeaderFooterMobile;

public class LandingAndZipcodeMobilePage extends UhcDriver {

	public LandingAndZipcodeMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	String page = "Step 1: Location";
	// Landing Page Elements
	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	@FindBy(css = "div[class*='get-started-banner'] button")
	private WebElement getStartedBtn;

	@FindBy(css = "div[class*='get-started-main-inner'] button")
	private WebElement getStartedBtn1;

	@FindBy(css = "h1[class^='text-display']")
	private WebElement landingpageHeader;

	@FindBy(css = "div[class*='get-started-banner'] img")
	private WebElement landingpageAnimationImage;

	@FindBy(css = "div[class*='get-started-main-inner'] img")
	private WebElement landingpageImage;

	@FindBy(css = "div[class*='get-started-banner'] p")
	private WebElement landingpageText;

	@FindBy(css = "div[class*='get-started-main-inner']")
	private WebElement landingpageMainInner;

	@FindBy(css = "div[class*='get-started-main-inner'] h2")
	private WebElement landingpageInnerTitle;

	@FindBy(css = "div[class*='get-started-main-inner'] h3")
	public WebElement landingpageLabel;

	// ZipCode Elements
	// Default Page elements
	@FindBy(css = "nav>.breadcrumb")
	private WebElement breadCrumb;

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
	private WebElement pageRequiredInfoMark;

	@FindBy(css = "div>.primary-question-tex")
	private WebElement zipcodePageQuestion;

	@FindBy(css = "div>.primary-question-tex>sup")
	private WebElement zipcodePageQuestionMark;

	@FindBy(css = "#referenceTxt")
	private WebElement zipcodeTextLabel;

	@FindBy(css = "input#zip-code")
	private WebElement zipCode;

	@FindBy(css = ".container div>button[class*='primary button']")
	private WebElement continueBtn;

	@FindBy(css = "div.sam")
	public WebElement footerCallbannerSection;

	// zip code actions elements
	@FindBy(css = "#zipInfo")
	private WebElement countyInfo;

	@FindBy(css = "label[for='MultipleCounty']")
	private WebElement multicountyText;

	@FindBy(css = "#MultipleCounty")
	private WebElement multicountySelect;

	@FindBy(css = "#MultipleCounty > option:nth-child(1)")
	private WebElement defaultmultioptioninnerText;

	@FindBy(css = "label[for='MultipleCounty']>sup")
	private WebElement zipcodePageCountyQuestionMark;

	@FindBy(id = "errorMessage")
	private WebElement errorMessage;

	@Override
	public void openAndValidate() {
		waitforElementVisibilityInTime(getStartedBtn, 30);
	}

	public void landingpageElementsmobile() {
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
			String landingpageTracker = (driver.findElement(By.xpath("//*[@class='get-started-list']/li[" + i + "]")))
					.getText();
			System.out.println(landingpageTracker);
			String landingpageTextPoints = (driver.findElement(By.xpath(
					"//*[@class='get-started-main-inner']//*[@class='your-medicare-id-car mt-2']/li[" + i + "]/span")))
							.getText();
			System.out.println(landingpageTextPoints);
		}
		mobileUtils.mobileFindElementBeforeCallBanner(getStartedBtn1, "50%", 5, true);
		validate(landingpageImage, 30);
		validate(landingpageLabel, 30);
		waitTillElementClickableInTime(getStartedBtn1, 30);
	}

	public void zipcodepageElementsmobile() {
		validate(breadCrumb, 30);
		validate(planSelectorPageTilte, 30);
		validate(pageStepsNumberName, 30);
		validate(progressbar, 30);
		validate(pageProgressPercentage, 30);
		mobileUtils.currentPageValidation(page.toUpperCase());
		validate(pageRequiredInfo, 30);
		validate(pageRequiredInfoMark, 30);
		validate(zipcodePageQuestion, 30);
		validate(zipcodePageQuestionMark, 30);
		validate(zipcodeTextLabel, 30);
		validate(zipCode, 30);
		validate(continueBtn, 30);
	}

	public void zipcodepageValidationmobile(HashMap<String, String> inputdata) {
		mobileactionsendkeys(zipCode, inputdata.get("Zip Code"));
		if (inputdata.get("Is Multi County").equalsIgnoreCase("no")) {
			hidekeypad();
			validate(countyInfo, 20);
			Assert.assertTrue(countyInfo.getText().toUpperCase().contains(inputdata.get("County Name").toUpperCase()),
					"County Name Error");
		} else {
			mobileUtils.mobileFindElementBeforeCallBanner(continueBtn, "50%", 5, true);
			validate(multicountyText, 20);
			validate(defaultmultioptioninnerText, 20);
			validate(zipcodePageCountyQuestionMark, 20);
			Assert.assertTrue(defaultmultioptioninnerText.getText().contains("Select"));
			validate(multicountySelect, 20);
			Select multicounty = new Select(multicountySelect);
			mobileSelectOption(multicounty, inputdata.get("County Name"));
		}
		mobileUtils.mobileLocateElementClick(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		mobileUtils.nextPageValidation(page.toUpperCase());
	}

	public void zipcodescreenErrorValidationmobile(HashMap<String, String> inputdata) {
		mobileactionsendkeys(zipCode, inputdata.get("Zip Code"));
		hidekeypad();
		if (inputdata.get("Is Multi County").equalsIgnoreCase("yes")) {
			validate(multicountySelect, 20);
		}
		mobileUtils.mobileLocateElementClick(continueBtn);
		mobileUtils.mobleErrorValidation(page);
	}

	public void navigatezipcodepagemobile() {
		HeaderFooterMobile header = new HeaderFooterMobile(driver);
		header.navigatePRELandingpageMobile();
		
		//driver.navigate().to(driver.getCurrentUrl()+"/plan-recommendation-engine.html");
		//pageloadcomplete();
		///driver.navigate().refresh();
		
		pageloadcomplete();
		//validate(getStartedBtn, 30);
		mobileUtils.mobileLocateElementClick(getStartedBtn);
	}

	public void validatecontains(String primarystring, String substring) {
		if (!primarystring.matches(substring)) {
			System.out.println("Expected string - " + substring + " is not available in - " + primarystring);
			Assert.assertTrue(false);
		}
	}

}
