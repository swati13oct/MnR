/**
* 
 */
package pages.acquisition.planRecommendationEngine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.commonpages.GlobalWebElements;

public class PlanRecommendationEngineCostPreferencesPage extends GlobalWebElements {

	public PlanRecommendationEngineCostPreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Cost Preferences";

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

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

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label>span.radio-container")
	private WebElement lowerPremium;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label span.radio-container")
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
//		Assertion.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		desktopCommonUtils.currentPageValidation(page.toUpperCase());
		validate(pageRequiredInfo);
//		Assertion.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		validate(preferencesTitle);
//		Assertion.assertTrue(preferencesTitle.getText().contains("cost"));
		validate(costPagePrimaryQuestionMark);
		validate(preferencesTitleInfo);
//		Assertion.assertTrue(preferencesTitleInfo.getText().contains("cost"));
		validate(lowerPremium, 30);
//		Assertion.assertTrue(lowerPremium.getText().contains("lower"));
		validate(higherPremium, 30);
//		Assertion.assertTrue(higherPremium.getText().contains("higher"));
		previousBtn.click();
		System.out.println("Validating " + page + " page Previous button functionality");
		desktopCommonUtils.previousPageValidation(page.toUpperCase());
	}

// Selecting Cost preference options

	public void costPreferencepageOptions(String costpreferenceoption) {
		System.out.println("Cost Preferences option selection in Cost Preferences Page");
		if (costpreferenceoption.equalsIgnoreCase("Lower")) {
			validate(lowerPremium);
			jsClickNew(lowerPremium);
			System.out.println("Cost Preferences Type " + costpreferenceoption + " Clicked");
		} else if (costpreferenceoption.equalsIgnoreCase("Higher")) {
			validate(higherPremium);
			jsClickNew(higherPremium);
			System.out.println("Cost Preferences Type " + costpreferenceoption + " Clicked");
		}
	}
// Selecting Cost Preference options and processed to Cost Preference Page

	public void costPreferencepageFunctional(String preference) {
		System.out.println("Cost Preferences Page Functional Operations");
		costPreferencepageOptions(preference);
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
	}

//Cost Preference Page Error Function Verification     

	public void costPreferencepageerror() {
		System.out.println("Cost Preference type is not selected - Error Scenario in Cost Preference Page");
		jsClickNew(continueBtn);
		desktopCommonUtils.desktopErrorValidation(page);
	}

	public void edit_cost(String preference) {
		costPreferencepageOptions(preference);
	}

}
