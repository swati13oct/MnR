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

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class PlanSelectorNewPages extends UhcDriver {

	public PlanSelectorNewPages(WebDriver driver) {
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
	
	@FindBy(xpath = "//*[@class='get-started-banner']//p")
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
	private WebElement zipcodePageTilte;
	
	@FindBy(xpath = "//*[@class='progress-bar-info']/h1")
	private WebElement pageStepsNumberName;
	
	@FindBy(xpath = "//*[@class='progress-bar-info']/div")
	private WebElement pageProgressPercentage;
	
	@FindBy(xpath = "//*[@class='all-fields-marked-wi']")
	private WebElement pageRequiredInfo;
	
	@FindBy(xpath = "//*[@class='all-fields-marked-wi']/sup")
	private WebElement pageRequiredInfoMark;
	
	@FindBy(xpath = "//*[@for='zip-code']")
	private WebElement zipcodePageQuestion;
	
	@FindBy(xpath = "//*[@for='zip-code']/sup")
	private WebElement zipcodePageQuestionMark;
	
	@FindBy(xpath = "//*[@class='mt-4']/label[2]")
	private WebElement zipcodeTextLabel;
	
	@FindBy(xpath = "//*[@for='MultipleCounty']")
	private WebElement zipcodePageCountyQuestion;
	
	@FindBy(xpath = "//*[@for='MultipleCounty']/sup")
	private WebElement zipcodePageCountyQuestionMark;
	
	
//Coverage Page Elements		
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;
	
	@FindBy(id = "custom-radio-group")
	private WebElement coverageTitle;
	
	
//Landing Page Element Verification Method 
	
	public void landingpage() {
		System.out.println("Validating Title: ");
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
		validate(countyInfo);
		continueBtn.click();
		waitforElementNew(coverageTitle);
		Assert.assertTrue(coverageTitle.getText().contains("What type of coverage are you looking for?"));
	
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
		waitforElementNew(coverageTitle);
		Assert.assertTrue(coverageTitle.getText().contains("What type of coverage are you looking for?"));
		waitforElementVisibilityInTime(previousBtn, 45);
		previousBtn.click();
		waitforElementNew(zipcodePageTilte);
		Assert.assertTrue(zipcodePageTilte.getText().contains("Get help finding a plan"));
	}
	
	public void zipcodePage() {
		boolean hidden;
		System.out.println("Validating ZipcodePage Elements");
		waitforElementNew(zipcodePageTilte);
		Assert.assertTrue(zipcodePageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		waitforElementNew(pageRequiredInfo);
		Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		waitforElementNew(pageRequiredInfoMark);
		Assert.assertTrue(pageRequiredInfoMark.getText().contains("*"));
		waitforElementNew(zipcodePageQuestion);
		Assert.assertTrue(zipcodePageQuestion.getText().contains("What is your Zip Code?"));
		waitforElementNew(zipcodePageQuestionMark);
		Assert.assertTrue(zipcodePageQuestionMark.getText().contains("*"));
		hidden = (driver.findElement(By.xpath("//*[@id='zip-code']")).getAttribute("placeholder") == "Enter ZIP Code") ? true : false;
		System.out.println("Value of Enter Zipcode field is : "+ hidden +" in Zip Code page");
		System.out.println((hidden != true) ? "Ener Zip Code Text is displayed" : "Ener Zip Code Text not displaying");
		
	}
	
	public void zipcodePagemultiCounty() {
			waitforElementVisibilityInTime(zipcodeTextLabel, 45);
			Assert.assertTrue(zipcodeTextLabel.getText().contains("Plans are specific to your area"));
			waitforElementNew(zipcodePageCountyQuestion);
			Assert.assertTrue(zipcodePageCountyQuestion.getText().contains("Please select your County? *"));
			waitforElementNew(zipcodePageCountyQuestionMark);
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
		continueBtn.click();
		waitforElementNew(errorMessage);
		int size = zipcodeid.length();
		System.out.println("ZipCode Size is :"+size);
		if(size<5 && size!=0) {
			Assert.assertTrue(errorMessage.getText().contains("Please enter complete five digits for zip code"));
		}else if(size==0)	{
			Assert.assertTrue(errorMessage.getText().contains("Please enter a valid zip code"));
		}else{
			Assert.assertTrue(errorMessage.getText().contains("Please enter valid zipcode."));
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
		waitforElementNew(errorMessage);
		Assert.assertTrue(errorMessage.getText().contains("Please select County"));
	}

	public void browserBack() {

		driver.navigate().back();
	}
}
