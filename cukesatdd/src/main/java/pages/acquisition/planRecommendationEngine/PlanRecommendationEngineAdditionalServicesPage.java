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
import pages.acquisition.commonpages.AcquisitionHomePage;

public class PlanRecommendationEngineAdditionalServicesPage extends UhcDriver {

	public PlanRecommendationEngineAdditionalServicesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Additional Services";

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

// Additional Services page Elements

	@FindBy(css = "#progress-bar-title")
	private WebElement planSelectorPageTilte;

	@FindBy(xpath = "//*[@class='progress-bar-info']/h2")
	private WebElement pageStepsNumberName;

	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "h2.primary-question-tex")
	private WebElement additionalTitle;

	@FindBy(css = "div>p.description-text")
	private WebElement additionalTitleInfo;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;

	// --- Common elements Ends above ---

	@FindBy(css = "p.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = "div.ng-star-inserted:nth-of-type(1)>fieldset.radioGroupOpt:nth-of-type(1)>legend.primary-question-tex")
	private WebElement dentalQuestion;

	@FindBy(css = "div.ng-star-inserted:nth-of-type(1)>fieldset.radioGroupOpt:nth-of-type(1) uhc-radio:nth-child(1)")
	private WebElement dentalYes;
	
	@FindBy(css = "div.ng-star-inserted:nth-of-type(1)>fieldset.radioGroupOpt:nth-of-type(1) uhc-radio:nth-child(2)")
	private WebElement dentalNo;
	
	@FindBy(css = "div.ng-star-inserted:nth-of-type(1)>fieldset.radioGroupOpt:nth-of-type(1) uhc-alert")
	private WebElement dentalError;
	
	@FindBy(css = "div.ng-star-inserted:nth-of-type(2)>fieldset.radioGroupOpt:nth-of-type(1)>legend.primary-question-tex")
	private WebElement hearingQuestion;

	@FindBy(css = "div.ng-star-inserted:nth-of-type(2)>fieldset.radioGroupOpt:nth-of-type(1) uhc-radio:nth-child(1)")
	private WebElement hearingYes;
	
	@FindBy(css = "div.ng-star-inserted:nth-of-type(2)>fieldset.radioGroupOpt:nth-of-type(1) uhc-radio:nth-child(2)")
	private WebElement hearingNo;
	
	@FindBy(css = "div.ng-star-inserted:nth-of-type(2)>fieldset.radioGroupOpt:nth-of-type(1) uhc-alert")
	private WebElement hearingError;
	
	@FindBy(css = "div.ng-star-inserted:nth-of-type(3)>fieldset.radioGroupOpt:nth-of-type(1)>legend.primary-question-tex")
	private WebElement visionQuestion;

	@FindBy(css = "div.ng-star-inserted:nth-of-type(3)>fieldset.radioGroupOpt:nth-of-type(1) uhc-radio:nth-child(1)")
	private WebElement visionYes;
	
	@FindBy(css = "div.ng-star-inserted:nth-of-type(3)>fieldset.radioGroupOpt:nth-of-type(1) uhc-radio:nth-child(2)")
	private WebElement visionNo;
	
	@FindBy(css = "div.ng-star-inserted:nth-of-type(3)>fieldset.radioGroupOpt:nth-of-type(1) uhc-alert")
	private WebElement visionError;
	
	@FindBy(css = "div.ng-star-inserted:nth-of-type(4)>fieldset.radioGroupOpt:nth-of-type(1)>legend.primary-question-tex")
	private WebElement fitnessQuestion;

	@FindBy(css = "div.ng-star-inserted:nth-of-type(4)>fieldset.radioGroupOpt:nth-of-type(1) uhc-radio:nth-child(1)")
	private WebElement fitnessYes;
	
	@FindBy(css = "div.ng-star-inserted:nth-of-type(4)>fieldset.radioGroupOpt:nth-of-type(1) uhc-radio:nth-child(2)")
	private WebElement fitnessNo;
	
	@FindBy(css = "div.ng-star-inserted:nth-of-type(4)>fieldset.radioGroupOpt:nth-of-type(1) uhc-alert")
	private WebElement fitnessError;
	
//Additional Page Element Verification Method 

	public void additionalpage(String drugInfo) {
		System.out.println("Validating Additional Services Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
//		Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		desktopCommonUtils.currentPageValidation(page.toUpperCase());
		validate(pageRequiredInfo);
//		Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		validate(additionalTitle);
//		Assert.assertTrue(additionalTitle.getText().contains("additional"));
		validate(additionalTitleInfo);
//		Assert.assertTrue(additionalTitleInfo.getText().contains("additional"));
		
		validate(dentalQuestion, 30);
		Assert.assertTrue(dentalQuestion.getText().contains("Dental"));
		validate(hearingQuestion, 30);
		Assert.assertTrue(hearingQuestion.getText().contains("Hearing"));
		validate(visionQuestion, 30);
		Assert.assertTrue(visionQuestion.getText().contains("Vision"));
		validate(fitnessQuestion, 30);
		Assert.assertTrue(fitnessQuestion.getText().contains("Fitness"));
		
		previousBtn.click();
		System.out.println("Validating " + page + " page Previous button functionality");
		if(drugInfo.toUpperCase().contains("NO"))
			desktopCommonUtils.previousPageValidation(page.toUpperCase()+"skip");
		else
			desktopCommonUtils.previousPageValidation(page.toUpperCase());
	}

// Selecting additional options in additional Page

	public void additionalpageOptions(String dental,String hearing,String vision,String fitness) {
		System.out.println("Additional option selection in additional Page");
		validate(dentalQuestion);
		validate(hearingQuestion);
		validate(visionQuestion);
		validate(fitnessQuestion);
		if (dental.equalsIgnoreCase("Yes")) {
			dentalYes.click();
			System.out.println("additional Type Dental " + dental + " Clicked");
		}
		if (dental.equalsIgnoreCase("No")) {
			dentalNo.click();
			System.out.println("additional Type Dental " + dental + " Clicked");
		}
		if (hearing.equalsIgnoreCase("Yes")) {
			hearingYes.click();
			System.out.println("additional Type Hearing " + hearing + " Clicked");
		}
		if (hearing.equalsIgnoreCase("No")) {
			hearingNo.click();
			System.out.println("additional Type Hearing " + hearing + " Clicked");
		}
		if (vision.equalsIgnoreCase("Yes")) {
			visionYes.click();
			System.out.println("additional Type Vision " + vision + " Clicked");
		}
		if (vision.equalsIgnoreCase("No")) {
			visionNo.click();
			System.out.println("additional Type Vision " + vision + " Clicked");
		}
		if (fitness.equalsIgnoreCase("Yes")) {
			fitnessYes.click();
			System.out.println("additional Type Fitness " + fitness + " Clicked");
		}
		if (fitness.equalsIgnoreCase("No")) {
			fitnessNo.click();
			System.out.println("additional Type Fitness " + fitness + " Clicked");
		}
	}
// Selecting additional options and processed to Additional Service Page

	public void additionalpageFunctional(String additionalOptions) {
		System.out.println("additional Page Functional Operations");
		additionalpageOptions(additionalOptions.split(",")[0],additionalOptions.split(",")[1],additionalOptions.split(",")[2],additionalOptions.split(",")[3]);
		continueBtn.click();
		System.out.println("Validating " + page + " page Continue button functionality");
		desktopCommonUtils.nextPageValidation(page.toUpperCase());
	}

//Additional Page Error Function Verification     

	public void additionalpageerror(String additionalOptions) {
		System.out.println("Additional option is not selected - Error Scenario in Additional Page");
		continueBtn.click();
		Assert.assertTrue(dentalError.getText().toUpperCase().contains("NO"));
		Assert.assertTrue(hearingError.getText().toUpperCase().contains("NO"));
		Assert.assertTrue(visionError.getText().toUpperCase().contains("NO"));
		Assert.assertTrue(fitnessError.getText().toUpperCase().contains("NO"));
		scrollToView(additionalTitleInfo);
		additionalpageOptions(additionalOptions.split(",")[0],additionalOptions.split(",")[1],additionalOptions.split(",")[2],additionalOptions.split(",")[3]);
		if(validate(dentalError,5)==true) {
			System.out.println("Dental Error is not closed");
			Assert.assertTrue(false);
		}
		if(validate(hearingError,5)==true) {
			System.out.println("Hearing Error is not closed");
			Assert.assertTrue(false);
		}
		if(validate(visionError,5)==true) {
			System.out.println("Vision Error is not closed");
			Assert.assertTrue(false);
		}
		if(validate(fitnessError,5)==true) {
			System.out.println("Fitness Error is not closed");
			Assert.assertTrue(false);
		}
	continueBtn.click();
	System.out.println("Validating " + page + " page Continue button functionality");
	desktopCommonUtils.nextPageValidation(page.toUpperCase());
	}

}
