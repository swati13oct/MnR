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

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class PlanRecommendationEngineLandingAndZipcodePages extends UhcDriver {

	public PlanRecommendationEngineLandingAndZipcodePages(WebDriver driver) {
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

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

//Landing page Elements

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
	
	@FindBy(xpath = "//*[@id='answer-a-few-simple']")
	private WebElement landingpageText;
		
	@FindBy(className = "get-started-main-inner")
	private WebElement landingpageMainInner;
	
	@FindBy(xpath = "//*[contains(@class,'get-started-main-inner')]/div[1]/div/h2")
	private WebElement landingpageInnerTitle;
	
	@FindBy(xpath = "//*[contains(@class,'get-started-main-inner')]/div[3]/div/h3")
	public WebElement landingpageLabel;

//ZipCode Elements

	@FindBy(id = "zip-code")
	private WebElement zipCode;
	
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
	
	@FindBy(xpath = "//*[@class='progress-bar-title']/h1")
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
	
	
//Coverage Page Elements		
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;
	
	@FindBy(css = "#custom-radio-group>fieldset>legend>span:nth-child(2)")
	private WebElement coverageTitle;
	
	
//Landing Page Element Verification Method 
	
	public void landingpage() {
		System.out.println("Validating Title: ");
		String preBreadcrumbs = (driver.findElement(By.cssSelector("div.breadcrumb"))).getText();
		Assert.assertTrue(preBreadcrumbs.contains("Home / Plan Recommendation Engine"));
		String ExpectedTitle = "Get help finding an insurance plan";
		validate(landingpageHeader, 30);
		String ActualTitle = landingpageHeader.getText();
		System.out.println(ActualTitle.equalsIgnoreCase(ExpectedTitle));
		System.out.println("Validating Animation Images: ");
		validate(landingpageAnimationImage, 30);
		System.out.println("Validating Text: ");
		validate(landingpageText, 30);
		String ExpectedText = " Answer a few simple questions and get personalized plan recommendations in about 10 minutes. ";
		String ActualText = landingpageText.getText();
		System.out.println(ActualText.equalsIgnoreCase(ExpectedText));
		validate(getStartedBtn, 30);
		validate(landingpageMainInner, 30);
		System.out.println("Validating Title in Inner Section: ");
		validate(landingpageInnerTitle, 30);
		String ExpectedText1 = "How does this work?";
		String ActualText1 = landingpageInnerTitle.getText();
		System.out.println(ActualText1.equalsIgnoreCase(ExpectedText1));
		for(int i=1; i<=3; i++) {
			String landingpageTracker = (driver.findElement(By.xpath("//*[@class='get-started-list']/li[" +i+ "]"))).getText();
			System.out.println(landingpageTracker);
			String landingpageTextPoints = (driver.findElement(By.xpath("//*[@class='get-started-main-inner']//*[@class='your-medicare-id-car mt-2']/li[" +i+ "]/span"))).getText();
			System.out.println(landingpageTextPoints);
		}
		validate(landingpageImage, 30);
		String landingpageLabelText = landingpageLabel.getText();
		System.out.println(landingpageLabelText.contains("It may help to have the following information before getting started:"));
		waitTillElementClickableInTime(getStartedBtn1, 45);
	}
	
	
//SingleCounty Method
	public void quizStartAndRunQuestionnaire(String zipcode) throws InterruptedException {

		// switchToNewIframe(iframePst);
		// waitTillElementClickableInTime(getStartedBtn, 30);
		//AcquisitionHomePage.clickIfElementPresentInTime(driver, proactiveChatExitBtn,5);
		waitTillElementClickableInTime(getStartedBtn, 45);
		waitTillElementClickableInTime(getStartedBtn1, 45);
		getStartedBtn.click();
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zipcode);
		validate(countyInfo,30);
		continueBtn.click();
		validate(coverageTitle);
		Assert.assertTrue(coverageTitle.getText().contains("coverage"));
	
	}

//	MultiCounty Method
	public void quizStartAndRunQuestionnaireWithCounty(String zip_code, String County) throws Exception {
		
		Thread.sleep(20000);
		driver.switchTo().defaultContent();
//		switchToNewIframe(iframePst);
		waitTillElementClickableInTime(getStartedBtn, 45);
		waitTillElementClickableInTime(getStartedBtn1, 45);
		getStartedBtn.click();
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zip_code);
		Thread.sleep(2000);
		zipcodePagemultiCounty();
		waitforElementVisibilityInTime(PRECounty, 45);
		selectFromDropDownByText(driver, PRECounty, County);
		continueBtn.click();
		validate(coverageTitle);
		Assert.assertTrue(coverageTitle.getText().contains("coverage"));
		waitforElementVisibilityInTime(previousBtn, 45);
/*		previousBtn.click();
		validate(planSelectorPageTilte);
		Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));*/
	}
	
	public void zipcodePage() {
		boolean hidden;
		System.out.println("Validating ZipcodePage Elements");
		String preBreadcrumbs = (driver.findElement(By.cssSelector("div.breadcrumb"))).getText();
		Assert.assertTrue(preBreadcrumbs.contains("Home / Plan Recommendation Engine"));
		validate(planSelectorPageTilte);
		Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Step 1: Location"));
		validate(pageProgressPercentage, 30);
		Assert.assertTrue(pageProgressPercentage.getText().contains("0% Complete"));
		validate(pageRequiredInfo);
		Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		validate(pageRequiredInfoMark);
		Assert.assertTrue(pageRequiredInfoMark.getText().contains("*"));
		validate(zipcodePageQuestion);
		Assert.assertTrue(zipcodePageQuestion.getText().contains("ZIP"));
		validate(zipcodePageQuestionMark);
		Assert.assertTrue(zipcodePageQuestionMark.getText().contains("*"));
		hidden = (driver.findElement(By.xpath("//*[@id='zip-code']")).getAttribute("placeholder") == "Enter ZIP Code") ? true : false;
		System.out.println("Value of Enter Zipcode field is : "+ hidden +" in Zip Code page");
		System.out.println((hidden != true) ? "Ener Zip Code Text is displayed" : "Ener Zip Code Text not displaying");
		
	}
	
	public void zipcodePagemultiCounty() {
			waitforElementVisibilityInTime(zipcodeTextLabel, 45);
			Assert.assertTrue(zipcodeTextLabel.getText().contains("Plans are specific to your area"));
			validate(zipcodePageCountyQuestion);
			Assert.assertTrue(zipcodePageCountyQuestion.getText().contains("County? *"));
			validate(zipcodePageCountyQuestionMark);
			Assert.assertTrue(zipcodePageCountyQuestionMark.getText().contains("*"));
			waitforElementVisibilityInTime(PRECounty, 45);
			Assert.assertTrue(PRECountyInnerText.getText().contains("Select County "));
	}

//Error Scenario's	
	public void getStartedAndRunInvalidzipcode(String zipcodeid) throws InterruptedException {

		waitTillElementClickableInTime(getStartedBtn, 45);
		waitTillElementClickableInTime(getStartedBtn1, 45);
		getStartedBtn.click();
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zipcodeid);
		waitforElementVisibilityInTime(continueBtn, 45);
		continueBtn.click();
		waitforElementVisibilityInTime(errorMessage, 45);
		validate(errorMessage);
		int size = zipcodeid.length();
		System.out.println("ZipCode Size is :"+size);
		if(size<5 && size!=0) {
			Assert.assertTrue(errorMessage.getText().contains("Please"));
		}else if(size==0)	{
			Assert.assertTrue(errorMessage.getText().contains("Please"));
		}else{
			Assert.assertTrue(errorMessage.getText().contains("Please"));
		}	
	}
	
//Error Scenario's for multiCounty	
public void getStartedAndRunzipcodeWithCounty(String zip_code, String County) throws Exception {
		
		waitTillElementClickableInTime(getStartedBtn, 45);
		waitTillElementClickableInTime(getStartedBtn1, 45);
		getStartedBtn.click();
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zip_code);
		Thread.sleep(2000);
		zipcodePagemultiCounty();
		continueBtn.click();
		validate(errorMessage);
		Assert.assertTrue(errorMessage.getText().contains("Please"));
	}

	public void browserBack() {

		driver.navigate().back();
	}
}
