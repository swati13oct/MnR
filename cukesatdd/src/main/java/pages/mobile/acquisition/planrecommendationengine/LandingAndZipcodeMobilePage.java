/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

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

	
	
	public void navigatePage(String pagename) {
		HeaderFooterMobile header = new HeaderFooterMobile(driver);
		header.navigatePRELandingpageMobile();
		validate(getStartedBtn, 30);
		getStartedBtn.click();
	}
	
	public void validatecontains(String primarystring, String substring) {
		if (!primarystring.matches(substring)) {
			System.out.println("Expected string - " + substring + " is not available in - " + primarystring);
			Assert.assertTrue(false);
		}
	}
}
