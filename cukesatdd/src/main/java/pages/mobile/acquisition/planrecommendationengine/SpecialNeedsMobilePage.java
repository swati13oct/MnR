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

public class SpecialNeedsMobilePage extends UhcDriver {

	public SpecialNeedsMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	String page = CommonutilitiesMobile.specialNeedsPageName;

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	// Special Needs Page Elements

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

	@FindBy(css="#errorMessage>p")
	private WebElement errorMessage;

	@FindBy(xpath="//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(css = ".container div>button[class*='secondary']")
	private WebElement previousBtn;

	// --- Common elements Ends above ---

	@FindBy(css = "div legend.primary-question-tex")
	private WebElement specialNeedsPagePrimaryQuestion;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(1) span.labelCheck")
	private WebElement snpMedicaid;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(2) span.labelCheck")
	private WebElement snpConditions;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(3) span.labelCheck")
	private WebElement snpNursinghome;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(4) span.labelCheck")
	private WebElement snpNone;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(1) uhc-accordion .accordion-header")
	private WebElement snpMedicaidAccordion;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(2) uhc-accordion .accordion-header")
	private WebElement snpConditionsAccordion;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(3) uhc-accordion .accordion-header")
	private WebElement snpNursinghomeAccordion;

	@FindBy(css="uhc-checkbox-group>fieldset>div:nth-child(2) div:nth-child(1) uhc-accordion>div .accordion-header>div:nth-child(1)>svg")
	private WebElement snpMedicaidAccordionCarrot;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(2) uhc-accordion svg")
	private WebElement snpConditionsAccordionCarrot;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(3) uhc-accordion svg")
	private WebElement snpNursinghomeAccordionCarrot;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(1) uhc-accordion .accordion-title>span")
	private WebElement snpMedicaidAccordionMoreInfo;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(2) uhc-accordion .accordion-title>span")
	private WebElement snpConditionsAccordionMoreInfo;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(3) uhc-accordion .accordion-title>span")
	private WebElement snpNursinghomeAccordionMoreInfo;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(1) uhc-accordion .accordion-content p:nth-child(1)")
	private WebElement snpMedicaidAccordionMoreInfo1stPara;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(2) uhc-accordion .accordion-content p:nth-child(1)")
	private WebElement snpConditionsAccordionMoreInfo1stPara;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(3) uhc-accordion .accordion-content p:nth-child(1)")
	private WebElement snpNursinghomeAccordionMoreInfo1stPara;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(1) uhc-accordion .accordion-content p:nth-child(2)")
	private WebElement snpMedicareAccordionMoreInfo2ndPara;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(2) uhc-accordion .accordion-content p:nth-child(2)")
	private WebElement snpConditionsAccordionMoreInfo2ndPara;

	@FindBy(css = "uhc-checkbox-group div:nth-of-type(3) uhc-accordion .accordion-content p:nth-child(2)")
	private WebElement snpNursinghomeAccordionMoreInfo2ndPara;

	@FindBy(css = "uhc-checkbox.checkbox-checked")
	private WebElement checkedSNP;

	// Special Needs Page Element Verification Method
	public void specialNeedspageElements() {
		System.out.println("Special Needs Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		mobileUtils.currentPageValidation(page.toUpperCase());
		validate(pageRequiredInfo);
		validate(specialNeedsPagePrimaryQuestion);
		//Assertion.assertTrue(specialNeedsPagePrimaryQuestion.getText().contains("situations"));
		validate(snpMedicaid, 30);
		//Assertion.assertTrue(snpMedicaid.getText().contains("Medicaid"));
		validate(snpConditions, 30);
		//Assertion.assertTrue(snpConditions.getText().contains("following"));
		validate(snpNursinghome, 30);
		//Assertion.assertTrue(snpNursinghome.getText().contains("facility"));
		validate(snpNone, 30);
		//Assertion.assertTrue(snpNone.getText().contains("None"));
		mobileUtils.mobileLocateElement(previousBtn);
		jsClickNew(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		mobileUtils.previousPageValidation(page.toUpperCase());
	}

	// Splitting the input options and selecting it and Verifying the More Then
	// Clicking on Continue Button
	public void specialneedspage(String options, String status) {
		if (status.equals("Positive")) {
			String snpoptions[] = options.split(",");
			for (String option : snpoptions) {
				specialNeedspageFunctional(option);
				specialNeedsOptionsMoreInfo(option);
			}
			jsClickNew(continueBtn);
		} else {
			if (options.isEmpty()) {
				jsClickNew(continueBtn);
				validate(errorMessage, 30);
				Assert.assertTrue(errorMessage.getText().contains("No"));
			} else if (options.toUpperCase().contains("NONE")) {
				String snpoptions[] = options.split(",");
				for (String option : snpoptions) {
					specialNeedspageFunctional(option);
				}
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
			jsClickNew(snpMedicaid);
			System.out.println("Plan Type " + SNPType + " Clicked");
		} else if (SNPType.equalsIgnoreCase("Chronic")) {
			jsClickNew(snpConditions);
			System.out.println("Plan Type " + SNPType + " Clicked");
		} else if (SNPType.equalsIgnoreCase("Nursing")) {
			jsClickNew(snpNursinghome);
			System.out.println("Plan Type " + SNPType + " Clicked");
		} else if (SNPType.equalsIgnoreCase("None")) {
			jsClickNew(snpNone);
			System.out.println("Plan Type " + SNPType + " Clicked");
		}
	}

	// Verify the More Information for SNP Options
	public void specialNeedsOptionsMoreInfo(String SNPType) {
		if (SNPType.equalsIgnoreCase("Medicaid")) {
			if (snpMedicaidAccordion.isDisplayed()) {
				Assert.assertTrue(snpMedicaidAccordionMoreInfo.getText().contains("More"));
				Assert.assertTrue(snpMedicaidAccordionMoreInfo1stPara.getText().contains("D-SNP"));
				//Assertion.assertTrue(snpMedicareAccordionMoreInfo2ndPara.getText().contains("toll free"));
			//	mobileUtils.mobileFindElementBeforeCallBanner(snpMedicaidAccordionCarrot, "50%", 10, true);
				validateNew(snpMedicaidAccordionCarrot);
				snpMedicaidAccordionCarrot.click();
			} else {
				System.out.println("Accordion is not displayed for  " + SNPType + " .");
			}
		} else if (SNPType.equalsIgnoreCase("condition")) {
			if (snpConditionsAccordion.isDisplayed()) {
				Assert.assertTrue(snpConditionsAccordionMoreInfo.getText().contains("More"));
				Assert.assertTrue(snpConditionsAccordionMoreInfo1stPara.getText().contains("C-SNP"));
				//Assertion.assertTrue(snpConditionsAccordionMoreInfo2ndPara.getText().contains("toll free"));
				//mobileUtils.mobileFindElementBeforeCallBanner(snpConditionsAccordionCarrot, "50%", 10, true);
				validateNew(snpConditionsAccordionCarrot);
				snpConditionsAccordionCarrot.click();
			} else {
				System.out.println("Accordion is not displayed for  " + SNPType + " .");
			}
		} else if (SNPType.equalsIgnoreCase("facility")) {
			if (snpNursinghomeAccordion.isDisplayed()) {
				Assert.assertTrue(snpNursinghomeAccordionMoreInfo.getText().contains("More"));
				Assert.assertTrue(snpNursinghomeAccordionMoreInfo1stPara.getText().contains("I-SNP"));
				//Assertion.assertTrue(snpNursinghomeAccordionMoreInfo2ndPara.getText().contains("toll free"));
			//	mobileUtils.mobileFindElementBeforeCallBanner(snpNursinghomeAccordionCarrot, "50%", 10, true);
				validateNew(snpNursinghomeAccordionCarrot);
				snpNursinghomeAccordionCarrot.click();
			} else {
				System.out.println("Accordion is not displayed for  " + SNPType + " .");
			}
		}
	}

	public void edit_specialneeds(String options) {
		String snpoptions[] = options.split(",");
		for (String option : snpoptions) {
			specialNeedspageFunctional(option);
			specialNeedsOptionsMoreInfo(option);
		}
	}
}
