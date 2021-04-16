/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;

public class PlanRecommendationEngineSpecialNeedsPageMobile extends UhcDriver {

	public PlanRecommendationEngineSpecialNeedsPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Special";

	PlanRecommendationEngineCommonutilityMobile desktopCommonUtils = new PlanRecommendationEngineCommonutilityMobile(
			driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	// Special Needs Page Elements

	@FindBy(css = "#progress-bar-title")
	private WebElement planSelectorPageTilte;

	@FindBy(xpath = "//*[@class='progress-bar-info']/h2")
	private WebElement pageStepsNumberName;

	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "uhc-checkbox-group>fieldset>legend>span:nth-child(2)")
	private WebElement coverageTitle;

	@FindBy(css = "div>fieldset>legend.primary-question-tex>sup")
	private WebElement coverageTitleRedAsterisk;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(xpath = "//label[@for='currentYear']")
	private WebElement currentYearbtn;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;

	@FindBy(css = "p.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(2)>uhc-checkbox>label>span.checkbox-label-content>span.labelCheck")
	private WebElement snpMedicaid;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(3)>uhc-checkbox>label>span.checkbox-label-content>span.labelCheck")
	private WebElement snpConditions;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(4)>uhc-checkbox>label>span.checkbox-label-content>span.labelCheck")
	private WebElement snpNursinghome;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(5)>uhc-checkbox>label>span.checkbox-label-content>span.labelCheck")
	private WebElement snpNone;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(2)>uhc-accordion>div .accordion-header")
	private WebElement snpMedicaidAccordion;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(3)>uhc-accordion>div .accordion-header")
	private WebElement snpConditionsAccordion;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(4)>uhc-accordion>div .accordion-header")
	private WebElement snpNursinghomeAccordion;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(2)>uhc-accordion>div .accordion-header>div:nth-child(1)>svg")
	private WebElement snpMedicaidAccordionCarrot;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(3)>uhc-accordion>div .accordion-header>div:nth-child(1)>svg")
	private WebElement snpConditionsAccordionCarrot;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(4)>uhc-accordion>div .accordion-header>div:nth-child(1)>svg")
	private WebElement snpNursinghomeAccordionCarrot;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(2)>uhc-accordion>div .accordion-header>div:nth-child(2)>span")
	private WebElement snpMedicaidAccordionMoreInfo;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(3)>uhc-accordion>div .accordion-header>div:nth-child(2)>span")
	private WebElement snpConditionsAccordionMoreInfo;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(4)>uhc-accordion>div .accordion-header>div:nth-child(2)>span")
	private WebElement snpNursinghomeAccordionMoreInfo;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(2)>uhc-accordion>div .accordion-content>span>p:nth-child(1)")
	private WebElement snpMedicaidAccordionMoreInfo1stPara;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(3)>uhc-accordion>div .accordion-content>span>p:nth-child(1)")
	private WebElement snpConditionsAccordionMoreInfo1stPara;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(4)>uhc-accordion>div .accordion-content>span>p:nth-child(1)")
	private WebElement snpNursinghomeAccordionMoreInfo1stPara;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(2)>uhc-accordion>div .accordion-content>span>p:nth-child(2)")
	private WebElement snpMedicareAccordionMoreInfo2ndPara;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(3)>uhc-accordion>div .accordion-content>span>p:nth-child(2)")
	private WebElement snpConditionsAccordionMoreInfo2ndPara;

	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(4)>uhc-accordion>div .accordion-content>span>p:nth-child(2)")
	private WebElement snpNursinghomeAccordionMoreInfo2ndPara;

	@FindBy(css = "#errorMessage>span:nth-child(2)")
	private WebElement errorMessage;

	@FindBy(css = "uhc-checkbox.checkbox-checked")
	private WebElement checkedSNP;

	// Special Needs Page Element Verification Method

	public void specialNeedspage() {
		System.out.println("Special Needs Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		// Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding
		// a plan"));
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		desktopCommonUtils.currentPageValidation(page.toUpperCase());
		validate(pageRequiredInfo);
		// Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with
		// "), " are required");
		validate(coverageTitle);
		// Assert.assertTrue(coverageTitle.getText().contains("situations"));
		validate(snpMedicaid, 30);
		// Assert.assertTrue(snpMedicaid.getText().contains("Medicaid"));
		validate(snpConditions, 30);
		// Assert.assertTrue(snpConditions.getText().contains("following"));
		validate(snpNursinghome, 30);
		// Assert.assertTrue(snpNursinghome.getText().contains("facility"));
		validate(snpNone, 30);
		// Assert.assertTrue(snpNone.getText().contains("None"));
		previousBtn.click();
		System.out.println("Validationg " + page + " page Previous button functionality");
		desktopCommonUtils.previousPageValidation(page.toUpperCase());
	}

	// Splitting the input options and selecting it and Verifying the More
	// Information Content
	// Then Clicking on Continue Button
	public void specialneedspage(String options, String status) {
		if (status.equals("Positive")) {
			String snpoptions[] = options.split(",");
			for (String option : snpoptions) {
				specialNeedspageFunctional(option);
				specialNeedsOptionsMoreInfo(option);
			}
			//continueBtn.click();
			jsClickNew(continueBtn);
		} else {
			if (options.isEmpty()) {
				//continueBtn.click();
				jsClickNew(continueBtn);
				validate(errorMessage, 30);
				Assert.assertTrue(errorMessage.getText().contains("No"));
			} else if (options.contains("None")) {
				String snpoptions[] = options.split(",");
				for (String option : snpoptions) {
					specialNeedspageFunctional(option);
				}
				// continueBtn.click();
				jsClickNew(continueBtn);
				validate(errorMessage, 30);
				Assert.assertTrue(errorMessage.getText().contains("Please"));
			}
		}
	}

	// Special Needs Page Function Verification

	public void specialNeedspageFunctional(String SNPType) {
		System.out.println("SNP Option " + SNPType + " Selection");
		if (SNPType.equalsIgnoreCase("Medicaid")) {
			validate(snpMedicaid);
			//snpMedicaid.click();
			jsClickNew(snpMedicaid);
			System.out.println("Plan Type " + SNPType + " Clicked");
		} else if (SNPType.equalsIgnoreCase("chronic")) {
			scrollToView(snpConditions);
			validate(snpConditions);
			//snpConditions.click();
			jsClickNew(snpConditions);
			System.out.println("Plan Type " + SNPType + " Clicked");
		} else if (SNPType.equalsIgnoreCase("nursing")) {
			validate(snpNursinghome);
			// snpNursinghome.click();
			jsClickNew(snpNursinghome);
			System.out.println("Plan Type " + SNPType + " Clicked");
			waitTillElementClickableInTime(snpNursinghomeAccordionCarrot, 3000);
		} else if (SNPType.equalsIgnoreCase("None")) {
			validate(snpNone);
			scrollToView(snpNone);
			jsClickNew(snpNone);
			// snpNone.click();
			System.out.println("Plan Type " + SNPType + " Clicked");
		}

	}

	// Verify the More Information for SNP Options

	public void specialNeedsOptionsMoreInfo(String SNPType) {
		if (SNPType.equalsIgnoreCase("Medicaid")) {
			if (snpMedicaidAccordion.isDisplayed()) {
				validate(snpMedicaidAccordionCarrot, 40);
				Assert.assertTrue(snpMedicaidAccordionMoreInfo.getText().contains("More"));
				// Assert.assertTrue(snpMedicaidAccordionMoreInfo1stPara.getText().contains("D-SNP"));
				// Assert.assertTrue(snpMedicareAccordionMoreInfo2ndPara.getText().contains("toll
				// free"));
				scrollToView(snpMedicaidAccordionCarrot);
				validate(snpMedicaidAccordionCarrot, 40);
				//snpMedicaidAccordionCarrot.click();
				// jsClickNew(snpMedicaidAccordionCarrot);
			} else {
				System.out.println("Accordion is not displayed for  " + SNPType + " .");
			}
		} else if (SNPType.equalsIgnoreCase("chronic")) {
			if (snpConditionsAccordion.isDisplayed()) {
				validate(snpConditionsAccordionCarrot, 40);
				Assert.assertTrue(snpConditionsAccordionMoreInfo.getText().contains("More"));
				// Assert.assertTrue(snpConditionsAccordionMoreInfo1stPara.getText().contains("C-SNP"));
				// Assert.assertTrue(snpConditionsAccordionMoreInfo2ndPara.getText().contains("toll
				// free"));
				scrollToView(snpConditionsAccordionCarrot);
				// snpConditionsAccordionCarrot.click();
				//jsClickNew(snpConditionsAccordionCarrot);
				// jsClickNew(snpConditionsAccordionCarrot);
			} else {
				System.out.println("Accordion is not displayed for  " + SNPType + " .");
			}
		} else if (SNPType.equalsIgnoreCase("nursing")) {
			if (snpNursinghomeAccordion.isDisplayed()) {
				validate(snpNursinghomeAccordionCarrot, 40);
				Assert.assertTrue(snpNursinghomeAccordionMoreInfo.getText().contains("More"));
				// Assert.assertTrue(snpNursinghomeAccordionMoreInfo1stPara.getText().contains("I-SNP"));
				// Assert.assertTrue(snpNursinghomeAccordionMoreInfo2ndPara.getText().contains("toll
				// free"));
				scrollToView(snpNursinghomeAccordionCarrot);
				//snpNursinghomeAccordionCarrot.click();
				//jsClickNew(snpNursinghomeAccordionCarrot);
			} else {
				System.out.println("Accordion is not displayed for  " + SNPType + " .");
			}
		}
	}

	public void browserBack() {

		driver.navigate().back();
	}
	
	public void edit_specialneeds(String options) {
		String snpoptions[] = options.split(",");
		for (String option : snpoptions) {
			specialNeedspageFunctional(option);
			specialNeedsOptionsMoreInfo(option);
		}
	}
}