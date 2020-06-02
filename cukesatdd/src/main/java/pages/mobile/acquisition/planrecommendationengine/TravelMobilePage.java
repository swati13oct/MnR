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

public class TravelMobilePage extends UhcDriver {

	public TravelMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	String page = CommonutilitiesMobile.travelPageName;

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	// Care Away Page Elements

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
	private WebElement travelPagePrimaryQuestion;

	@FindBy(css = "div legend.primary-question-tex span>sup")
	private WebElement travelPagePrimaryQuestionMark;

	@FindBy(css = "div legend.primary-question-tex .description-text")
	private WebElement travelPagePrimaryQuestionDecsription;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(1) span.labelCheck")
	private WebElement travelOftenOption;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(2) span.labelCheck")
	private WebElement travelAnotherPartOption;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(3) span.labelCheck")
	private WebElement travelRegularHealthOption;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(4) span.labelCheck")
	private WebElement travelNoneOption;

	// Travel Page Element Verification Method
	public void travelpageElements() {
		System.out.println("Travel Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		mobileUtils.currentPageValidation(page.toUpperCase());
		validate(progressbar);
		validate(pageRequiredInfo);
		validate(pageRequiredInfoAsteriskMark);
		validate(travelPagePrimaryQuestion);
		//Assert.assertTrue(travelPagePrimaryQuestion.getText().contains("your life"));
		validate(travelPagePrimaryQuestionMark);
		validate(travelPagePrimaryQuestionDecsription);
		validate(travelOftenOption, 30);
		//Assert.assertTrue(travelOftenOption.getText().contains("travel"));
		validate(travelAnotherPartOption, 30);
		//Assert.assertTrue(travelAnotherPartOption.getText().contains("another part"));
		validate(travelRegularHealthOption, 30);
		//Assert.assertTrue(travelRegularHealthOption.getText().contains("care away"));
		validate(travelNoneOption, 30);
		//Assert.assertTrue(travelNoneOption.getText().contains("None"));
		mobileUtils.mobileLocateElementClick(travelAnotherPartOption);
		mobileUtils.mobileLocateElementClick(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		mobileUtils.previousPageValidation(page.toUpperCase());
	}

	// Splitting the input options and selecting it and Verifying the More Then
	// Clicking on Continue Button
	public void travelpage(String options, String status) {
		if (status.equals("Positive")) {
			String traveloptions[] = options.split(",");
			for (String option : traveloptions) {
				travelpageFunctional(option);
			}
			mobileUtils.mobileLocateElementClick(continueBtn);
			System.out.println("Validating " + page + " page Continue button functionality");
			mobileUtils.nextPageValidation(page.toUpperCase());
		} else {
			if (options.isEmpty()) {
				mobileUtils.mobileLocateElementClick(continueBtn);
				mobileUtils.mobleErrorValidation(page);
			} else if (options.toUpperCase().contains("NONE")) {
				String traveloptions[] = options.split(",");
				for (String option : traveloptions) {
					travelpageFunctional(option);
				}
				mobileUtils.mobileLocateElementClick(continueBtn);
				mobileUtils.mobleErrorValidation(page);
			}
		}
	}

	// Travel Page Function Verification
	public void travelpageFunctional(String travelType) {
		System.out.println("Travel Option " + travelType + " Selection");
		if (travelType.equalsIgnoreCase("withinUS")) {
			mobileUtils.mobileLocateElementClick(travelOftenOption);
			System.out.println("Plan Type " + travelType + " Clicked");
		} else if (travelType.equalsIgnoreCase("outsideUS")) {
			mobileUtils.mobileLocateElementClick(travelAnotherPartOption);
			System.out.println("Plan Type " + travelType + " Clicked");
		} else if (travelType.equalsIgnoreCase("Regular")) {
			mobileUtils.mobileLocateElementClick(travelRegularHealthOption);
			System.out.println("Plan Type " + travelType + " Clicked");
		} else if (travelType.equalsIgnoreCase("None")) {
			mobileUtils.mobileLocateElementClick(travelNoneOption);
			System.out.println("Plan Type " + travelType + " Clicked");
		}
	}

}
