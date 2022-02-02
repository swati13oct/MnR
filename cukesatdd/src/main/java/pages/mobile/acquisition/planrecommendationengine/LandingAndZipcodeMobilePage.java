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

public class LandingAndZipcodeMobilePage extends UhcDriver {

	public LandingAndZipcodeMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	String page = CommonutilitiesMobile.locationPageName;
	// Landing Page Elements
	@FindBy(css = "#planSelectorTool")
	private WebElement iframePst;

	@FindBy(css = "div[class*='get-started-banner'] button")
	private WebElement getStartedBtn;
	
	@FindBy(css = "#custom-radio-group>fieldset>legend>span:nth-child(1)")
	private WebElement coverageTitle;

	@FindBy(css = "div[class*='get-started-main-inner'] button")
	private WebElement getStartedBtn1;

	@FindBy(xpath="//h1[contains(@class,'text-display')]")
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

	@FindBy(css = "#progress-bar-title")
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

	@FindBy(css = "#errorMessage")
	private WebElement errorMessage;
	
	@FindBy(css = "iframe[title*=' Survey']")
	private WebElement popupFrame;
	
	@FindBy(css = "button[id*='no']")
	private WebElement popupNo;
	
	@FindBy(xpath = "//select[@id='MultipleCounty']")
	private WebElement PRECounty;

	@Override
	public void openAndValidate() {
		waitforElementVisibilityInTime(getStartedBtn, 30);
	}
	
	public void quizStartAndRunQuestionnaire(String zipcode) throws InterruptedException {
		waitTillElementClickableInTime(getStartedBtn, 45);
		System.out.println("Before clicking GetStarted");
		threadsleep(5000);
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zipcode);
		threadsleep(5000);
		jsClickNew(getStartedBtn);
		threadsleep(2000);
		System.out.println("After clicking GetStarted");
		waitforElementVisibilityInTime(coverageTitle, 30);
	
	}
	
	public void quizStartAndRunQuestionnaireWithCounty(String zip_code, String County) throws Exception {
		
		Thread.sleep(20000);
		driver.switchTo().defaultContent();
		waitTillElementClickableInTime(getStartedBtn, 45);
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zip_code);
		Thread.sleep(2000);
//		zipcodePagemultiCounty();
		waitforElementVisibilityInTime(PRECounty, 45);
		selectFromDropDownByText(driver, PRECounty, County);
		threadsleep(5000);
		jsClickNew(getStartedBtn);
		Thread.sleep(2000);
		waitforElementVisibilityInTime(coverageTitle, 30);
	}
	
	public void landingpage() {
		System.out.println("Validating Title: ");
//		String preBreadcrumbs = (driver.findElement(By.cssSelector("div.breadcrumb"))).getText();
//		Assertion.assertTrue(preBreadcrumbs.contains("Home / Plan Recommendation Engine"));
		String ExpectedTitle = "plan";
		validate(landingpageHeader, 30);
		String ActualTitle = landingpageHeader.getText();
		System.out.println(ActualTitle.equalsIgnoreCase(ExpectedTitle));
		System.out.println("Validating Animation Images: ");
		validate(landingpageAnimationImage, 30);
		System.out.println("Validating Text: ");
/*		validate(landingpageText, 30);
		String ExpectedText = " Answer a few simple questions and get personalized plan recommendations in about 10 minutes. ";
		String ActualText = landingpageText.getText();
		System.out.println(ActualText.equalsIgnoreCase(ExpectedText));*/
		validate(getStartedBtn, 30);
		validate(landingpageMainInner, 30);
		System.out.println("Validating Title in Inner Section: ");
		validate(landingpageInnerTitle, 30);
/*		String ExpectedText1 = "How does this work?";
		String ActualText1 = landingpageInnerTitle.getText();
		System.out.println(ActualText1.equalsIgnoreCase(ExpectedText1));*/
		for(int i=1; i<=3; i++) {
			String landingpageTracker = (driver.findElement(By.xpath("//*[@class='get-started-list']/li[" +i+ "]"))).getText();
			System.out.println(landingpageTracker);
		}
		for(int j=1; j<=2; j++) {
			String landingpageTextPoints = (driver.findElement(By.xpath("//*[@class='get-started-main-inner']//*[@class='your-medicare-id-car mt-2']/li[" +j+ "]/span"))).getText();
			System.out.println(landingpageTextPoints);
		}
		validate(landingpageImage, 30);
		String landingpageLabelText = landingpageLabel.getText();
		System.out.println(landingpageLabelText.contains("It may help to have the following information before getting started:"));
		waitTillElementClickableInTime(getStartedBtn, 45);
	}
	
	public boolean close_Popup() {
		boolean popup_presents = false;
		System.out.println("Checking Popup Status...");
		if(validate(popupNo, 20)) {
			if(validate(popupFrame, 5))
				driver.switchTo().frame(popupFrame);
			threadsleep(1000);
//			popupNo.click();
			jsClickNew(popupNo);
			threadsleep(1000);
			popup_presents = true;
		}
		driver.switchTo().defaultContent();
		return popup_presents;
	}

	public void landingpageElementsmobile() {
		System.out.println("Validating Title: ");
		String ExpectedTitle = "plan";
		validate(landingpageHeader, 30);
		String ActualTitle = landingpageHeader.getText();
		System.out.println(ActualTitle.contains(ExpectedTitle));
		System.out.println("Validating Animation Images: ");
		validate(landingpageAnimationImage, 30);
		System.out.println("Validating Text: ");
		validate(landingpageText, 30);
		mobileswipe("70%", true);
		//String ExpectedText = "plan recommendation";
		//String ActualText = landingpageText.getText();
		//System.out.println(ActualText.contains(ExpectedText));
		validate(getStartedBtn, 30);
		validate(landingpageMainInner, 30);
		System.out.println("Validating Title in Inner Section: ");
		validate(landingpageInnerTitle, 30);
		//String ExpectedText1 = "How does this work?";
		//String ActualText1 = landingpageInnerTitle.getText();
		//System.out.println(ActualText1.equalsIgnoreCase(ExpectedText1));
		for (int i = 1; i <= 3; i++) {
			//String landingpageTracker = (driver.findElement(By.xpath("//*[@class='get-started-list']/li[" + i + "]")))
			//		.getText();
			validate(driver.findElement(By.xpath("//*[@class='get-started-list']/li[" + i + "]")));
			//System.out.println(landingpageTracker);
			if(i<3)
			validate(driver.findElement(By.xpath(
					"//*[@class='get-started-main-inner']//*[@class='your-medicare-id-car mt-2']/li[" + i + "]/span")));
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
		zipCode.clear();

		sendkeysMobile(zipCode, inputdata.get("Zip Code"));
		hidekeypad();
		if (inputdata.get("Is Multi County").equalsIgnoreCase("no")) {
			validate(countyInfo, 20);
//			Assert.assertTrue(countyInfo.getText().toUpperCase().contains(inputdata.get("County Name").toUpperCase()),"County Name Error");
		} else {
			mobileUtils.mobileFindElementBeforeCallBanner(continueBtn, "50%", 5, true);
			validate(multicountyText, 20);
			validate(defaultmultioptioninnerText, 20);
			validate(zipcodePageCountyQuestionMark, 20);
			Assert.assertTrue(defaultmultioptioninnerText.getText().contains("Select"));
			validate(multicountySelect, 20);
			//Select multicounty = new Select(multicountySelect);
			mobileSelectOption(multicountySelect, inputdata.get("County Name"),true);
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
		//driver.navigate().to(driver.getCurrentUrl()+"/plan-recommendation-engine.html");
		//pageloadcomplete();
		///driver.navigate().refresh();
		
		pageloadcomplete();
		mobileUtils.mobileLocateElementClick(getStartedBtn);
		validate(zipCode,30);
	}

	public void validatecontains(String primarystring, String substring) {
		if (!primarystring.matches(substring)) {
			System.out.println("Expected string - " + substring + " is not available in - " + primarystring);
			Assert.assertTrue(false);
		}
	}
	
	public void zipcodeInfoValidationmobile(HashMap<String, String> inputdata) {
		System.out.println("Verify Zip Info");
		validate(zipCode, 20);
		Assert.assertTrue(zipCode.getAttribute("ng-reflect-model").equals(inputdata.get("Zip Code")),"Invalid Zip code");
		if (inputdata.get("Is Multi County").equalsIgnoreCase("no")) {
			validate(countyInfo, 20);
//			Assert.assertTrue(countyInfo.getText().toUpperCase().contains(inputdata.get("County Name").toUpperCase()),"County Name Error");
		} else {
			mobileUtils.mobileFindElementBeforeCallBanner(continueBtn, "50%", 5, true);
			validate(multicountySelect, 20);
			Select multicounty = new Select(multicountySelect);
			Assert.assertTrue(multicounty.getFirstSelectedOption().getText().equalsIgnoreCase(inputdata.get("County Name")),
					"Invalid County Name");
		}
	}

	public void edit_location(String zipcode,String multi,String county) {
		waitforElementVisibilityInTime(zipCode, 45);
		zipCode.clear();
		sendkeysMobile(zipCode, zipcode);
		if(multi.equalsIgnoreCase("Yes")) {
			mobileSelectOption(multicountySelect, county,true);
		}
		threadsleep(3000);
	}

}
