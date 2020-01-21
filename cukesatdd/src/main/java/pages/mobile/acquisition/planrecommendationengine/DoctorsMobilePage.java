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

public class DoctorsMobilePage extends UhcDriver {

	public DoctorsMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}
	String page = "Doctors";
	
	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	// Doctors Page Elements

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
	private WebElement doctorPagePrimaryQuestion;
	
	@FindBy(css = "div legend.primary-question-tex span>sup")
	private WebElement doctorPagePrimaryQuestionMark;
	
	@FindBy(css = "div legend.primary-question-tex .description-text")
	private WebElement doctorPagePrimaryQuestionDecsription;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label")
	private WebElement doctorUHCNetworkOption;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
	private WebElement doctorWantOption;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(4)>label")
	private WebElement doctorLookupOption;

	//Doctors Page Modal popup
	
	@FindBy(css = "#modal div>button[class*='primary button']")
	private WebElement modalFinddoctors;
	
	@FindBy(css = "#modal div button[class*='secondary']")
	private WebElement modalCancel;
	
	// Doctors Page Element Verification Method

	public void doctorspageElements() {
		System.out.println("Travel Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Step 5: Doctors"));
		validate(pageProgressPercentage, 30);
		Assert.assertTrue(pageProgressPercentage.getText().contains("32% Complete"));
		validate(progressbar);
		validate(pageRequiredInfo);
		validate(pageRequiredInfoAsteriskMark);

		validate(doctorPagePrimaryQuestion);
		Assert.assertTrue(doctorPagePrimaryQuestion.getText().contains("doctors"));
		validate(doctorPagePrimaryQuestionMark);
		validate(doctorPagePrimaryQuestionDecsription);
		validate(doctorUHCNetworkOption, 30);
		Assert.assertTrue(doctorUHCNetworkOption.getText().contains("network"));
		validate(doctorWantOption, 30);
		Assert.assertTrue(doctorWantOption.getText().contains("want"));
		validate(doctorLookupOption, 30);
		Assert.assertTrue(doctorLookupOption.getText().contains("lookup"));

		mobileUtils.mobileLocateElementClick(doctorWantOption);
		mobileUtils.mobileLocateElementClick(previousBtn);
		System.out.println("Validationg "+page+" page Previous button functionality");
		mobileUtils.previouspageValidation(page.toUpperCase());
	}

	public void doctorspage(String doctorsSelection, String status) {
		if (status.equals("Positive")) {
			if (doctorsSelection.equalsIgnoreCase("willing to use")) {
				mobileUtils.mobileLocateElementClick(doctorUHCNetworkOption);
				System.out.println("Plan Type " + doctorsSelection + " Clicked");
				mobileUtils.mobileLocateElementClick(continueBtn);
			} else if (doctorsSelection.equalsIgnoreCase("want to use")) {
				mobileUtils.mobileLocateElementClick(doctorWantOption);
				System.out.println("Plan Type " + doctorsSelection + " Clicked");
				mobileUtils.mobileLocateElementClick(continueBtn);
			} else if (doctorsSelection.equalsIgnoreCase("lookup")) {
				mobileUtils.mobileLocateElementClick(doctorLookupOption);
				System.out.println("Plan Type " + doctorsSelection + " Clicked");
				mobileUtils.mobileLocateElementClick(continueBtn);
				doctorlookup();
			}
			System.out.println("Validating " + page + " page Continue button functionality");
			//mobileUtils.nextPageValidation(page.toUpperCase());
		} else {
			if (doctorsSelection.isEmpty()) {
				mobileUtils.mobileLocateElementClick(continueBtn);
				mobileUtils.mobleErrorValidation(page);
			}
		}
	}
	
	public void doctorlookup() {
		mobileUtils.mobileLocateElementClick(modalFinddoctors);
	}

}
