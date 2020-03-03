/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class PharmacyMobilePage extends UhcDriver {

	public PharmacyMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Pharmacy";

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	// drugs Page Elements

	// --- From here Common for all page starts ---
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
	private WebElement pharmacyPagePrimaryQuestion;

	@FindBy(css = "div legend.primary-question-tex span>sup")
	private WebElement pharmacyPagePrimaryQuestionMark;

	@FindBy(css = "div legend.primary-question-tex .description-text")
	private WebElement pharmacyPagePrimaryQuestionDecsription;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label")
	private WebElement pharmacyOnlineOption;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
	private WebElement pharmacyRetailOption;

	// Drugs Page Element Verification Method
	public void pharmacypageElements() {
		System.out.println("Pharmacy Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Step 7: Pharmacy"));
		validate(pageProgressPercentage, 30);
		Assert.assertTrue(pageProgressPercentage.getText().contains("48% Complete"));
		validate(progressbar);
		validate(pageRequiredInfo);
		validate(pageRequiredInfoAsteriskMark);
		validate(pharmacyPagePrimaryQuestion);
		Assert.assertTrue(pharmacyPagePrimaryQuestion.getText().contains("pharmacy"));
		validate(pharmacyPagePrimaryQuestionMark);
		validate(pharmacyPagePrimaryQuestionMark);
		validate(pharmacyOnlineOption, 30);
		Assert.assertTrue(pharmacyOnlineOption.getText().contains("Online"));
		validate(pharmacyRetailOption, 30);
		Assert.assertTrue(pharmacyRetailOption.getText().contains("Retail"));
		mobileUtils.mobileLocateElementClick(pharmacyOnlineOption);
		mobileUtils.mobileLocateElementClick(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		mobileUtils.previouspageValidation(page.toUpperCase());
	}
	
	public void chooseOption(String pharamacySelection) {
		if (!(pharamacySelection.isEmpty())) {
			if (pharamacySelection.equalsIgnoreCase("Online")) {
				mobileUtils.mobileLocateElementClick(pharmacyOnlineOption);
				System.out.println("Plan Type " + pharamacySelection + " Clicked");
			} else if (pharamacySelection.equalsIgnoreCase("Retail")) {
				mobileUtils.mobileLocateElementClick(pharmacyOnlineOption);
				System.out.println("Plan Type " + pharamacySelection + " Clicked");
			}
		}else {
				mobileUtils.mobileLocateElementClick(continueBtn);
				mobileUtils.mobleErrorValidation(page);
		}
	}
	
	public void pharmacyFunctional(String pharamacySelection, String status) {
		chooseOption(pharamacySelection);
		mobileUtils.mobileLocateElementClick(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		//mobileUtils.nextPageValidation(page.toUpperCase());
	}
	
}
