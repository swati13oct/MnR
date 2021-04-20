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
import pages.acquisition.commonpages.PlanRecommendationEngineCommonutility;

public class PlanRecommendationEnginePrioritiesPageMobile extends UhcDriver {

	public PlanRecommendationEnginePrioritiesPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		}

	String page = "Priorities";

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

// Priorities page Elements

	@FindBy(css = "#progress-bar-title")
	private WebElement planSelectorPageTilte;

	@FindBy(xpath = "//*[@class='progress-bar-info']/h2")
	private WebElement pageStepsNumberName;

	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "h3.primary-question-tex")
	private WebElement priorityTitle;

	@FindBy(css = "p.description-text")
	private WebElement priorityDescription;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;

	@FindBy(css = "select#topPriority")
	private WebElement topSelect;
	
	@FindBy(css = "select#secondPriority")
	private WebElement secondSelect;
	
	@FindBy(css = "button.addAnotherLink")
	private WebElement addAnotherLink;
	
	public void prioritiesElements() {
		System.out.println("Validating Priorities Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		desktopCommonUtils.currentPageValidation(page.toUpperCase());
		validate(priorityTitle);
		validate(priorityDescription);
		validate(continueBtn);
		validate(previousBtn);
		Assert.assertTrue(validate(topSelect, 30));
		validate(addAnotherLink, 30);
		jsClickNew(addAnotherLink);
		Assert.assertTrue(validate(secondSelect, 30));
		jsClickNew(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		desktopCommonUtils.previousPageValidation(page.toUpperCase());
	}

// Selecting Priority options

	public void priorityOptions(boolean top,String value) {
		System.out.println("Priorities option selection");
		if (top) {
			selectFromDropDownByText(driver, topSelect, value);
			System.out.println("Top Priority value " + value + " selected");
		} else {
			if(validate(addAnotherLink)) {
				jsClickNew(addAnotherLink);
				threadsleep(1000);
			}
			selectFromDropDownByText(driver, secondSelect, value);
			System.out.println("Second Priority value " + value + " selected");
		}
	}
	
	public void priorityOptions2nd(String value) {
		System.out.println("Priorities 2nd option alone selection");
		String mandatoryOpt1 = "Doctors",mandatoryOpt2 = "Health Cost",defaultVal = "Select Priority";
		if (value.toLowerCase().contains(mandatoryOpt1.toLowerCase())) {
			selectFromDropDownByText(driver, topSelect, mandatoryOpt2);
			System.out.println("Top Priority value " + mandatoryOpt2 + " selected");
		} else {
			selectFromDropDownByText(driver, topSelect, mandatoryOpt1);
			System.out.println("Top Priority value " + mandatoryOpt1 + " selected");
		}
		if (validate(addAnotherLink)) {
			jsClickNew(addAnotherLink);
			threadsleep(1000);
		}
		selectFromDropDownByText(driver, secondSelect, value);
		System.out.println("Second Priority value " + value + " selected");
		selectFromDropDownByText(driver, topSelect, defaultVal);
		System.out.println("Top Priority value " + defaultVal + " selected");
	}

	public void prioritiesFunctional(String option,String value) {
		if(option.equalsIgnoreCase("Both")) {
			priorityOptions(true,value.split(",")[0].trim());
			priorityOptions(false,value.split(",")[1].trim());
		}
		else if(option.equalsIgnoreCase("1st")) {
			priorityOptions(true,value.split(",")[0].trim());
		}
		else if(option.equalsIgnoreCase("2nd")) {
			priorityOptions2nd(value.split(",")[1].trim());
		}
		else {
			System.out.println("Not selecting Priorities");
		}
	}
	
	public void continuePriority() {
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
	}

}
