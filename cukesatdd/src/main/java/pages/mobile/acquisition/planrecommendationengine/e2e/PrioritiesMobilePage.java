/**
* 
 */
package pages.mobile.acquisition.planrecommendationengine.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class PrioritiesMobilePage extends UhcDriver {

	public PrioritiesMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	String page = CommonutilitiesMobile.prioritiesPageName;

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

	@FindBy(css = ".container div>button[class*='primary button']")
	private WebElement continueBtn;

	@FindBy(css = ".container div>button[class*='secondary']")
	private WebElement previousBtn;

	// --- Common elements Ends above ---

	@FindBy(css = "h3.primary-question-tex")
	private WebElement priorityTitle;

	@FindBy(css = "p.description-text")
	private WebElement priorityDescription;

	@FindBy(css = "div legend.primary-question-tex")
	private WebElement costPagePrimaryQuestion;

	@FindBy(css = "div legend.primary-question-tex span>sup")
	private WebElement costPagePrimaryQuestionMark;

	@FindBy(css = "select#topPriority")
	private WebElement topSelect;

	@FindBy(css = "select#secondPriority")
	private WebElement secondSelect;

	@FindBy(css = "button.addAnotherLink")
	private WebElement addAnotherLink;

	// Priorities Page Element Verification Method
	public void prioritiesElementsMobile() {
		System.out.println("Validating Cost Preference Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		mobileUtils.currentPageValidation(page.toUpperCase());
		validate(priorityTitle);
		validate(priorityDescription);
		validate(continueBtn);
		validate(previousBtn);
		Assert.assertTrue(validate(topSelect, 30));
		validate(addAnotherLink, 30);
		mobileUtils.mobileLocateElementClick(addAnotherLink);
		Assert.assertTrue(validate(secondSelect, 30));
		mobileUtils.mobileLocateElement(previousBtn);
		mobileUtils.mobileLocateElementClick(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		mobileUtils.previousPageValidation(page.toUpperCase());
	}

	// Selecting Priority options

	public void priorityOptions(boolean top, String value) {
		System.out.println("Priorities option selection");
		if (top) {
			mobileSelectOption(topSelect, value, true);
			System.out.println("Top Priority value " + value + " selected");
		} else {
			if (validate(addAnotherLink)) {
				mobileUtils.mobileLocateElementClick(addAnotherLink);
				threadsleep(1000);
			}
			mobileSelectOption(secondSelect, value, true);
			System.out.println("Second Priority value " + value + " selected");
		}
	}

	public void priorityOptions2nd(String value) {
		System.out.println("Priorities 2nd option alone selection");
		String mandatoryOpt1 = "Doctors",mandatoryOpt2 = "Health Cost",defaultVal = "Select Priority";
		if (value.toLowerCase().contains(mandatoryOpt1.toLowerCase())) {
			mobileSelectOption(topSelect, mandatoryOpt2, true);
			System.out.println("Top Priority value " + mandatoryOpt2 + " selected");
		} else {
			mobileSelectOption(topSelect, mandatoryOpt1, true);
			System.out.println("Top Priority value " + mandatoryOpt1 + " selected");
		}
		if (validate(addAnotherLink)) {
			mobileUtils.mobileLocateElementClick(addAnotherLink);
			threadsleep(1000);
		}
		mobileSelectOption(secondSelect, value, true);
		System.out.println("Second Priority value " + value + " selected");
		mobileSelectOption(topSelect, defaultVal, true);
		System.out.println("Second Priority value " + defaultVal + " selected");
	}
	
	public void prioritiesFunctional(String option, String value) {
		if (option.equalsIgnoreCase("Both")) {
			priorityOptions(true, value.split(",")[0].trim());
			priorityOptions(false, value.split(",")[1].trim());
		} else if (option.equalsIgnoreCase("1st")) {
			priorityOptions(true, value.split(",")[0].trim());
		} else if (option.equalsIgnoreCase("2nd")) {
			priorityOptions2nd(value.split(",")[1].trim());
		} else {
			System.out.println("Not selecting Priorities");
		}
	}

	public void continuePriority() {
		mobileUtils.mobileLocateElementClick(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
	}

}