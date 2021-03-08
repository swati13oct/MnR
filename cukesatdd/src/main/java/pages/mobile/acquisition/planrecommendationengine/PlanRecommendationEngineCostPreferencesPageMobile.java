/**
* 
 */
package pages.mobile.acquisition.planrecommendationengine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;

public class PlanRecommendationEngineCostPreferencesPageMobile extends UhcDriver {

	public PlanRecommendationEngineCostPreferencesPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePageMobile.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Cost Preferences";

	PlanRecommendationEngineCommonutilityMobile desktopCommonUtils = new PlanRecommendationEngineCommonutilityMobile(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

// Cost Preferences page Elements

	@FindBy(css = "#progress-bar-title")
	private WebElement planSelectorPageTilte;

	@FindBy(xpath = "//*[@class='progress-bar-info']/h2")
	private WebElement pageStepsNumberName;

	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "div legend.primary-question-tex")
	private WebElement preferencesTitle;
	
	@FindBy(css = "div legend.primary-question-tex span>sup")
	private WebElement costPagePrimaryQuestionMark;

	@FindBy(css = "div legend.primary-question-tex .description-text")
	private WebElement preferencesTitleInfo;

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

//Cost Preferences Page Element Verification Method 

	public void costpreferencepage() {
		System.out.println("Validating Cost Preference Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
//		Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		desktopCommonUtils.currentPageValidation(page.toUpperCase());
		validate(pageRequiredInfo);
//		Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		validate(preferencesTitle);
//		Assert.assertTrue(preferencesTitle.getText().contains("cost"));
		validate(costPagePrimaryQuestionMark);
		validate(preferencesTitleInfo);
//		Assert.assertTrue(preferencesTitleInfo.getText().contains("cost"));
		validate(lowerPremium, 30);
//		Assert.assertTrue(lowerPremium.getText().contains("lower"));
		validate(higherPremium, 30);
//		Assert.assertTrue(higherPremium.getText().contains("higher"));
		previousBtn.click();
		System.out.println("Validating " + page + " page Previous button functionality");
		desktopCommonUtils.previousPageValidation(page.toUpperCase());
	}

// Selecting Cost preference options

	public void costPreferencepageOptions(String costpreferenceoption) {
		System.out.println("Cost Preferences option selection in Cost Preferences Page");
		if (costpreferenceoption.equalsIgnoreCase("Lower")) {
			validate(lowerPremium);
			//lowerPremium.click();
			jsClickNew(lowerPremium);
			System.out.println("Cost Preferences Type " + costpreferenceoption + " Clicked");
		} else if (costpreferenceoption.equalsIgnoreCase("Higher")) {
			validate(higherPremium);
			//higherPremium.click();
			jsClickNew(higherPremium);
			System.out.println("Cost Preferences Type " + costpreferenceoption + " Clicked");
		}
	}
// Selecting Cost Preference options and processed to Cost Preference Page

	public void costPreferencepageFunctional(String preference) {
		System.out.println("Cost Preferences Page Functional Operations");
		costPreferencepageOptions(preference);
		jsClickNew(continueBtn);
		//continueBtn.click();
		System.out.println("Validating " + page + " page Continue button functionality");	
		}

//Cost Preference Page Error Function Verification     

	public void costPreferencepageerror() {
		System.out.println("Cost Preference type is not selected - Error Scenario in Cost Preference Page");
		continueBtn.click();
		desktopCommonUtils.desktopErrorValidation(page);
	}
	
	public void edit_cost(String preference) {
		costPreferencepageOptions(preference);
	}


}
