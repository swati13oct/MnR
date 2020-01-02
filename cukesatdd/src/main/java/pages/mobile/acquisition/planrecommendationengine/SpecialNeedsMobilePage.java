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

public class SpecialNeedsMobilePage extends UhcDriver {

	public SpecialNeedsMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}
	String page = "Special Needs";
	
	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	// Special Needs Page Elements

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
	private WebElement specialNeedsPagePrimaryQuestion;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(1)>uhc-checkbox>label>span.checkbox-label-content>span:nth-child(2)")
	private WebElement snpMedicaid;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(2)>uhc-checkbox>label>span.checkbox-label-content>span:nth-child(2)")
	private WebElement snpConditions;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(3)>uhc-checkbox>label>span.checkbox-label-content>span:nth-child(2)")
	private WebElement snpNursinghome;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(4)>uhc-checkbox>label>span.checkbox-label-content>span:nth-child(2)")
	private WebElement snpNone;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(1)>uhc-accordion>div .accordion-header")
	private WebElement snpMedicaidAccordion;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(2)>uhc-accordion>div .accordion-header")
	private WebElement snpConditionsAccordion;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(3)>uhc-accordion>div .accordion-header")
	private WebElement snpNursinghomeAccordion;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(1)>uhc-accordion>div .accordion-header>div:nth-child(1)>svg")
	private WebElement snpMedicaidAccordionCarrot;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(2)>uhc-accordion>div .accordion-header>div:nth-child(1)>svg")
	private WebElement snpConditionsAccordionCarrot;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(3)>uhc-accordion>div .accordion-header>div:nth-child(1)>svg")
	private WebElement snpNursinghomeAccordionCarrot;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(1)>uhc-accordion>div .accordion-header>div:nth-child(2)>span")
	private WebElement snpMedicaidAccordionMoreInfo;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(2)>uhc-accordion>div .accordion-header>div:nth-child(2)>span")
	private WebElement snpConditionsAccordionMoreInfo;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(3)>uhc-accordion>div .accordion-header>div:nth-child(2)>span")
	private WebElement snpNursinghomeAccordionMoreInfo;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(1)>uhc-accordion>div .accordion-content>span>p:nth-child(1)")
	private WebElement snpMedicaidAccordionMoreInfo1stPara;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(2)>uhc-accordion>div .accordion-content>span>p:nth-child(1)")
	private WebElement snpConditionsAccordionMoreInfo1stPara;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(3)>uhc-accordion>div .accordion-content>span>p:nth-child(1)")
	private WebElement snpNursinghomeAccordionMoreInfo1stPara;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(1)>uhc-accordion>div .accordion-content>span>p:nth-child(2)")
	private WebElement snpMedicareAccordionMoreInfo2ndPara;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(2)>uhc-accordion>div .accordion-content>span>p:nth-child(2)")
	private WebElement snpConditionsAccordionMoreInfo2ndPara;

	@FindBy(css = "uhc-checkbox-group>div:nth-child(3)>uhc-accordion>div .accordion-content>span>p:nth-child(2)")
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
		Assert.assertTrue(pageStepsNumberName.getText().contains("Step 3: Special Needs"));
		validate(pageProgressPercentage, 30);
		Assert.assertTrue(pageProgressPercentage.getText().contains("16% Complete"));
		validate(pageRequiredInfo);
		validate(specialNeedsPagePrimaryQuestion);
		Assert.assertTrue(specialNeedsPagePrimaryQuestion.getText().contains("situations"));
		validate(snpMedicaid, 30);
		Assert.assertTrue(snpMedicaid.getText().contains("Medicaid"));
		validate(snpConditions, 30);
		Assert.assertTrue(snpConditions.getText().contains("following"));
		validate(snpNursinghome, 30);
		Assert.assertTrue(snpNursinghome.getText().contains("facility"));
		validate(snpNone, 30);
		Assert.assertTrue(snpNone.getText().contains("None"));
		mobileUtils.mobileFindElementBeforeCallBanner(previousBtn,"50%",5,true);
		previousBtn.click();
		System.out.println("Validationg "+page+" page Previous button functionality");
		mobileUtils.previouspageValidation(page.toUpperCase());
	}

	// Splitting the input options and selecting it and Verifying the More Then Clicking on Continue Button
	public void specialneedspage(String options, String status) {
		if (status.equals("Positive")) {
			String snpoptions[] = options.split(",");
			for (String option : snpoptions) {
				specialNeedspageFunctional(option);
				specialNeedsOptionsMoreInfo(option);
			}
			continueBtn.click();
			System.out.println("Validating "+page+" page Continue button functionality");
			mobileUtils.nextPageValidation(page.toUpperCase());
		} else {
			if (options.isEmpty()) {
				continueBtn.click();
				validate(errorMessage, 30);
				Assert.assertTrue(errorMessage.getText().contains("Please"));
			} else if (options.contains("None")) {
				String snpoptions[] = options.split(",");
				for (String option : snpoptions) {
					specialNeedspageFunctional(option);
				}
				continueBtn.click();
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
			snpMedicaid.click();
			System.out.println("Plan Type " + SNPType + " Clicked");
		} else if (SNPType.equalsIgnoreCase("condition")) {
			validate(snpConditions);
			snpConditions.click();
			System.out.println("Plan Type " + SNPType + " Clicked");
		} else if (SNPType.equalsIgnoreCase("facility")) {
			validate(snpNursinghome);
			snpNursinghome.click();
			System.out.println("Plan Type " + SNPType + " Clicked");
		} else if (SNPType.equalsIgnoreCase("None")) {
			validate(snpNone);
			snpNone.click();
			System.out.println("Plan Type " + SNPType + " Clicked");
		}
	}

	// Verify the More Information for SNP Options

	public void specialNeedsOptionsMoreInfo(String SNPType) {
		if (SNPType.equalsIgnoreCase("Medicaid")) {
			if (snpMedicaidAccordion.isDisplayed()) {
				validate(snpMedicaidAccordionCarrot, 30);
				Assert.assertTrue(snpMedicaidAccordionMoreInfo.getText().contains("More"));
				Assert.assertTrue(snpMedicaidAccordionMoreInfo1stPara.getText().contains("D-SNP"));
				Assert.assertTrue(snpMedicareAccordionMoreInfo2ndPara.getText().contains("toll free"));
				snpMedicaidAccordionCarrot.click();
			} else {
				System.out.println("Accordion is not displayed for  " + SNPType + " .");
			}
		} else if (SNPType.equalsIgnoreCase("condition")) {
			if (snpConditionsAccordion.isDisplayed()) {
				validate(snpConditionsAccordionCarrot, 30);
				Assert.assertTrue(snpConditionsAccordionMoreInfo.getText().contains("More"));
				Assert.assertTrue(snpConditionsAccordionMoreInfo1stPara.getText().contains("C-SNP"));
				Assert.assertTrue(snpConditionsAccordionMoreInfo2ndPara.getText().contains("toll free"));
				snpConditionsAccordionCarrot.click();
			} else {
				System.out.println("Accordion is not displayed for  " + SNPType + " .");
			}
		} else if (SNPType.equalsIgnoreCase("facility")) {
			if (snpNursinghomeAccordion.isDisplayed()) {
				validate(snpNursinghomeAccordionCarrot, 30);
				Assert.assertTrue(snpNursinghomeAccordionMoreInfo.getText().contains("More"));
				Assert.assertTrue(snpNursinghomeAccordionMoreInfo1stPara.getText().contains("I-SNP"));
				Assert.assertTrue(snpNursinghomeAccordionMoreInfo2ndPara.getText().contains("toll free"));
				snpNursinghomeAccordionCarrot.click();
			} else {
				System.out.println("Accordion is not displayed for  " + SNPType + " .");
			}
		}
	}

}
