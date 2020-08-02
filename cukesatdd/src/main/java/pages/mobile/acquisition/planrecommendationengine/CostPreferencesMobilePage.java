/**
* 
 */
package pages.mobile.acquisition.planrecommendationengine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class CostPreferencesMobilePage extends UhcDriver {

	public CostPreferencesMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	String page = CommonutilitiesMobile.costPreferencesPageName;

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	// --- From here Common for all page starts ---
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
	private WebElement pageRequiredInfoAsteriskMark;

	@FindBy(css = "div.sam")
	public WebElement footerCallbannerSection;

	@FindBy(css = "#errorMessage")
	private WebElement errorMessage;

	@FindBy(css = ".container div>button[class*='primary button']")
	private WebElement continueBtn;

	@FindBy(css = ".container div>button[class*='secondary']")
	private WebElement previousBtn;

	// --- Common elements Ends above ---

	@FindBy(css = "div legend.primary-question-tex")
	private WebElement costPagePrimaryQuestion;

	@FindBy(css = "div legend.primary-question-tex span>sup")
	private WebElement costPagePrimaryQuestionMark;

	@FindBy(css = "div legend.primary-question-tex .description-text")
	private WebElement costPagePrimaryQuestionDecsription;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label>span.radio-label-content")
	private WebElement lowerPremium;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
	private WebElement higherPremium;

	// Cost Preferences Page Element Verification Method
	public void costpreferencepage() {
		System.out.println("Validating Cost Preference Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		//Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		mobileUtils.currentPageValidation(page.toUpperCase());
		validate(pageRequiredInfo);
		//Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		validate(costPagePrimaryQuestion);
		//Assert.assertTrue(costPagePrimaryQuestion.getText().contains("cost"));
		validate(costPagePrimaryQuestionMark);
		validate(costPagePrimaryQuestionDecsription);
		//Assert.assertTrue(costPagePrimaryQuestionDecsription.getText().contains("cost"));
		validate(lowerPremium, 30);
		//Assert.assertTrue(lowerPremium.getText().contains("lower"));
		validate(higherPremium, 30);
		//Assert.assertTrue(higherPremium.getText().contains("higher"));
		mobileUtils.mobileLocateElementClick(higherPremium);
		mobileUtils.mobileLocateElementClick(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		mobileUtils.previousPageValidation(page.toUpperCase());
	}

	// Selecting Cost preference options
	public void costPreferencepageOptions(String costpreferenceoption) {
		System.out.println("Cost Preferences option selection in Cost Preferences Page");
		if (costpreferenceoption.equalsIgnoreCase("Lower")) {
			validate(lowerPremium);
			mobileUtils.mobileLocateElementClick(lowerPremium);
			System.out.println("Cost Preferences Type " + costpreferenceoption + " Clicked");
		} else if (costpreferenceoption.equalsIgnoreCase("Higher")) {
			validate(higherPremium);
			mobileUtils.mobileLocateElementClick(higherPremium);
			System.out.println("Cost Preferences Type " + costpreferenceoption + " Clicked");
		}
	}

	// Selecting Cost Preference options and processed to Cost Preference Page
	public void costPreferencepageFunctional(String preference) {
		System.out.println("Cost Preferences Page Functional Operations");
		costPreferencepageOptions(preference);
		mobileUtils.mobileLocateElementClick(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
	}

	// Cost Preference Page Error Function Verification
	public void costPreferencepageerror() {
		System.out.println("Cost Preference type is not selected - Error Scenario in Cost Preference Page");
		mobileUtils.mobileLocateElementClick(continueBtn);
		mobileUtils.mobleErrorValidation(page);
	}

}
