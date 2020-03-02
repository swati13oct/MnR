/**
* 
 */
package pages.acquisition.planRecommendationEngine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class PlanRecommendationEngineCostPreferencesPage extends UhcDriver {

	public PlanRecommendationEngineCostPreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Cost";

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

// Drugs page Elements

	@FindBy(xpath = "//*[@class='progress-bar-title']/h1")
	private WebElement planSelectorPageTilte;

	@FindBy(xpath = "//*[@class='progress-bar-info']/h2")
	private WebElement pageStepsNumberName;

	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "div.row.pb-1>div>uhc-radio-group>fieldset>legend.primary-question-tex>span:nth-child(2)")
	private WebElement pharmacyTitle;

	@FindBy(css = "div.row.pb-1>div>uhc-radio-group>fieldset>legend.primary-question-tex>span:nth-child(3)")
	private WebElement pharmacyTitleInfo;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;

	// --- Common elements Ends above ---

	@FindBy(css = "p.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label>span.radio-label-content")
	private WebElement lowerPremium;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
	private WebElement higherPremium;

	@FindBy(css = "#errorMessage")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[contains(@class,'radio-checked')]")
	private WebElement radioselect;

//Pharmacy Page Element Verification Method 

	public void costpreferencepage() {
		System.out.println("Validating Cost Preference Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Step 9: Health"));
		validate(pageProgressPercentage, 30);
		Assert.assertTrue(pageProgressPercentage.getText().contains("64% Complete"));
		validate(pageRequiredInfo);
		Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		validate(pharmacyTitle);
		Assert.assertTrue(pharmacyTitle.getText().contains("cost"));
		validate(pharmacyTitleInfo);
		Assert.assertTrue(pharmacyTitleInfo.getText().contains("cost"));
		validate(lowerPremium, 30);
		Assert.assertTrue(lowerPremium.getText().contains("lower"));
		validate(higherPremium, 30);
		Assert.assertTrue(higherPremium.getText().contains("higher"));
		previousBtn.click();
		System.out.println("Validating " + page + " page Previous button functionality");
		desktopCommonUtils.previouspageValidation(page.toUpperCase());
	}

// Selecting Cost preference options

	public void costPreferencepageOptions(String costpreferenceoption) {
		System.out.println("Pharmacy option selection in Pharmacy Page");
		if (costpreferenceoption.equalsIgnoreCase("Lower")) {
			validate(lowerPremium);
			lowerPremium.click();
			System.out.println("Pharmacy Type " + costpreferenceoption + " Clicked");
		} else if (costpreferenceoption.equalsIgnoreCase("Higher")) {
			validate(higherPremium);
			higherPremium.click();
			System.out.println("Pharmacy Type " + costpreferenceoption + " Clicked");
		}
	}
// Selecting Cost Preference options and processed to Cost Preference Page

	public void costPreferencepageFunctional(String preference) {
		System.out.println("Pharmacy Page Functional Operations");
		costPreferencepageOptions(preference);
		continueBtn.click();
		System.out.println("Validating " + page + " page Continue button functionality");
		//desktopCommonUtils.nextPageValidation(page.toUpperCase());
	}

//Cost Preference Page Error Function Verification     

	public void costPreferencepageerror() {
		System.out.println("Cost Preference type is not selected - Error Scenario in Cost Preference Page");
		continueBtn.click();
		Assert.assertTrue(errorMessage.getText().contains("No"));
	}

}
