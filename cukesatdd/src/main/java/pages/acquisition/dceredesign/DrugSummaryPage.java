package pages.acquisition.dceredesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.collect.Ordering;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PlanDetailsPage;

public class DrugSummaryPage extends UhcDriver {

	public DrugSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	public WebElement reviewDrugCostPageHeading;

	@FindBy(xpath = "//*[@class='uhc-filter-group']")
	public WebElement planTypeToggle;

	@FindBy(xpath = "//*[text()='Pharmacy:']/..")
	public WebElement pharmacyLink;

	@FindBy(xpath = "//*[@class='column column-12']//*[@class='uhc-select uhc-select--block']")
	public WebElement sortDropdown;

	@FindBy(xpath = "//*[@class='uhc-card__header']//h4")
	public WebElement planCardHeader;

	@FindBy(xpath = "//*[text()='Average Monthly Drug Cost']/following-sibling::div")
	public WebElement avgMonthlyDrugCost;

	@FindBy(xpath = "//*[text()='Monthly Premium']/following-sibling::div")
	public WebElement monthlyPremium;

	// @FindBy(xpath = "//h5[contains(text(), 'Annual
	// Estimated')]//following-sibling::div")
	@FindBy(xpath = "(//div//h5[contains(text(), 'Annual Estimated')])[1]")
	public WebElement annualEstimatedTotal;

	@FindBy(xpath = "//*[text()='Drugs Covered']/following-sibling::div")
	public WebElement drugsCovered;

	@FindBy(xpath = "//*[contains(@id,'averageLinkBtn')]/following-sibling::button")
	public WebElement whyAverageLink;

	@FindBy(xpath = "//*[contains(@id,'includeLinkBtn')]/following-sibling::button")
	public WebElement whatsIncludedLink;

	@FindBy(xpath = "//*[contains(@id,'priceLinkBtn')]")
	public WebElement drugPricingLink;

	@FindBy(xpath = "//button/span[text()='View Drug Costs']")
	public WebElement viewDrugCostBtn;

	@FindBy(xpath = "//button/span[text()='View Plan Details']")
	public WebElement viewPlanDetailsBtn;

	@FindBy(xpath = "//button//span[contains(text(),'Save')]")
	public WebElement saveBtn;

	@FindBy(xpath = "//*[@id='accordion-1-button']")
	public WebElement disclaimer;

	@FindBy(xpath = "//*[@class='heading-4 mb-10 ng-star-inserted']")
	public WebElement planTypeHeading;

	@FindBy(xpath = "//button/span[text()='View Plan Details']")
	public WebElement viewPlanButton;

//	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]//span[contains(text(),'Medicare Advantage Plans')]")
//	public WebElement mapdPlanToggle;
//
//	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]//span[contains(text(),'Medicare Prescription Drug Plans')]")
//	public WebElement pdpPlanToggle;
//
//	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]//span[contains(text(),'Medicare Special Needs Plans')]")
//	public WebElement snpPlanToggle;
	
	@FindBy(xpath = "//label[@for='ma-plans-radio']//span[contains(text(),'Medicare Advantage Plans')]")
	public WebElement mapdPlanToggle;

	@FindBy(xpath = "//label[@for='pdp-plans-radio']//span[contains(text(),'Medicare Prescription Drug Plans')]")
	public WebElement pdpPlanToggle;

	@FindBy(xpath = "//label[@for='snp-plans-radio']//span[contains(text(),'Medicare Special Needs Plans')]")
	public WebElement snpPlanToggle;

	@FindBy(id = "changePharmacyLink")
	public WebElement changePharmacy;

//	@FindBy(id = "selectaPharmacyHeader")
	@FindBy(xpath = "//h3[@id='modal-label'][text()='Select a Pharmacy']")
	public WebElement selectPharmacyHeader;

//	@FindBy(id = "selectPharmcyModalCloseLink")
	@FindBy(id = "cancelicon")
	public WebElement selectPharmacyModalCloseBtn;

	@FindBy(xpath = "//*[@class='uhc-card__content']//*[contains(text(),'We are currently')]")
	public WebElement selectedPharmacyLink;

	@FindBy(id = "milesDropdown")
	public WebElement distanceDrpDown;

	@FindBy(id = "pharmacy-zip-filter")
	public WebElement pharmacyZipcodeSearch;

	@FindBy(xpath = "//*[@class='uhc-card__content']//*[contains(text(),'Search')]")
	public WebElement pharmacySearchBtn;

	@FindBy(xpath = "//*[contains(@id, 'mailSelectPharmacyBtn')]")
	public WebElement preferredMailPharmacy;

	@FindBy(xpath = "//img[contains(@alt, 'OptumRX')]")
	public WebElement optumRxMsg;

	@FindBy(xpath = "//*[@role='list']")
	public WebElement pharmacyListSection;

	@FindBy(id = "matchingLbl")
	public WebElement matchingPharmacyCount;

	@FindBy(id = "sortDropdown")
	public WebElement sortDrpdown;

	@FindBy(id = "paginationBackBtn")
	public WebElement backBtn;

	@FindBy(id = "paginationNextBtn")
	public WebElement nextBtn;

	@FindBy(id = "changePharmacyLink")
	public WebElement changePharmacyLinkDetailsPage;

	@FindBy(xpath = "//*[text()='Return to Profile']")
	public WebElement returnToProfileLink;

	@FindBy(xpath = "//button//span[text()='Back to Profile']")
	public List<WebElement> backToProfileBtn;

	@FindBy(xpath = "//*[@class='plane-name-block']")
	public List<WebElement> planNames;

	@FindBy(xpath = "//*[@id='guest-flow-widget-head']/../..")
	public WebElement dceNBAModal;

	@FindBy(xpath = "//*[@id='guest-flow-widget-head' and text()='Save your work for later']")
	public WebElement dceNBAModalMsg;

	@FindBy(xpath = "//button/*[text()='Create Your Profile']")
	public WebElement dceNBAModalBtn;

	@FindBy(id = "SignIn")
	public WebElement signInBtn;

	@FindBy(xpath = "//*[@id='enrollmentPopup']/..")
	private WebElement savedPlansPopup;

	@FindBy(xpath = "//*[@id='enrollmentPopup']/..//*[@class='uhc-modal__close']")
	private WebElement savedPlansPopupCloseIcon;

	@FindBy(id = "selectPharmacyBtn0")
	private WebElement firstPharmacySelectBtn;

	@FindBy(xpath = "//button/span[text()='Save and Update Drug Costs']")
	private WebElement saveAndUpdateDrugCostBtn;

	@FindBy(xpath = "//*[@id='selectPharmacyBtn0']/..//p/span")
	private WebElement pharmacyNameSelected;

	@FindBy(xpath = "//*[@class='pharmacy-plan-desc']")
	private WebElement pharmacyName;

	@FindBy(xpath = "//*[[@id='modal']/div/div[2]/div/div/div[2]/div/table/tbody/tr[1]/td[2]/span")
	private WebElement drugCoverageNotCoveredDrug;

	@FindBy(xpath = "//*[@id='modal']/div/div[2]/div/div/div[2]/div/table/tbody/tr[1]/td[4]")
	private WebElement youPayNotCoveredDrug;

	@FindBy(xpath = "//*[@id='modal']/div/div[2]/div/div/div[2]/div/table/tbody/tr[2]/td[2]/span")
	private WebElement drugCoverageCoveredDrug;

	@FindBy(xpath = "//*[@id='modal']/div/div[2]/div/div/div[2]/div/table/tbody/tr[2]/td[4]")
	private WebElement youPayCoveredDrug;

	@FindBy(id = "selectdosage")
	private WebElement drugDosage;

	@FindBy(id = "drugquantity")
	private WebElement drugQty;

	@FindBy(id = "new-drug-refill")
	private WebElement drugSupplyLength;

	@FindBy(xpath = "//*[@id='changePharmacyLink0']")
	public WebElement changePharmacyCoverPrescription;

	@FindBy(xpath = "//*[@id='mailSelectPharmacyBtn0']/../../following-sibling::div[1]")
	private WebElement mailOrderPharmacyMsg;

	@FindBy(xpath = "//*[contains(@id,'selectPharmacyBtn')]/../div//span[1]")
	private List<WebElement> pharmacyNameList;

	@FindBy(xpath = "//*[@class='pagination']/../p")
	private WebElement pageNumber;

	@FindBy(xpath = "//*[@id='selectaPharmacy-overlay']//*[@class='field-error-msgfordceui']")
	private WebElement noResultsMessage;

	@FindBy(xpath = "//*[text()='Return to plan summary']")
	public WebElement returnToPlanSummaryLink;

	@FindBy(xpath = "//*[text()='Return to home page']")
	public WebElement returnToHomePageLink;

	@FindBy(id = "inValidZipcodeLbl")
	private WebElement invalidZipCodeMsg;

	@FindBy(xpath = "//*[contains(@class,'keepPharmacyLink')]")
	private WebElement keepUsingPharmacyLink;

	@FindBy(xpath = "//*[@id='modal']")
	private WebElement planSavePopup;

	@FindBy(xpath = "//*[@id='modal']//*[@id='cancelicon']")
	private WebElement closeIconPlanSavePopup;

	@FindBy(xpath = "(//button/span[contains(text(), 'View Plan Details')])[1]")
	public WebElement firstViewPlanDetailsBtn;

	@FindBy(xpath = "//a[@class='uhc-link-button']/span")
	private WebElement breaCrumbLink;

	public static String LIS_MESSAGE_DRUG_PRICING = "If you receive \"Extra Help\" to pay your prescription drugs, this payment stage does not apply to you. Learn more about Extra Help.";

	@Override
	public void openAndValidate() {
		validateNew(reviewDrugCostPageHeading);

	}

	public DrugSummaryPage validateDrugSummaryPage() {
		if (validateNew(reviewDrugCostPageHeading) && validateNew(planTypeToggle) && validateNew(pharmacyLink)
				&& validateNew(planCardHeader) && validateNew(avgMonthlyDrugCost) && validateNew(monthlyPremium)
				&& validateNew(annualEstimatedTotal) && validateNew(drugsCovered) && validateNew(whyAverageLink)
				&& validateNew(whatsIncludedLink) && validateNew(drugPricingLink) && validateNew(viewDrugCostBtn)
				&& validateNew(viewPlanDetailsBtn) && validateNew(saveBtn) && validateNew(disclaimer)) {
			return new DrugSummaryPage(driver);
		}

		return null;
	}

	@FindBy(xpath = "//button[@ng-click='backToDceDrugDetailsOrSummary()']")
	public WebElement backtoDrugEstBtn;

	@FindBy(xpath = "//button[@ng-click='backToPlanSummary()']")
	public WebElement backtoSummaryBtn;

	public void validateDrugandPanButton() {
		validateNew(backtoDrugEstBtn);
		validateNew(backtoSummaryBtn);
	}

	public void clickOnBacktoDrugBtn() {
		validateNew(backtoDrugEstBtn);
		backtoDrugEstBtn.click();
	}

	public void validatePlanDrugDetails(String planName) {
		WebElement PlanName_PlanDetails = driver.findElement(By.xpath("//h1[contains(text(), '" + planName + "')]"));
		CommonUtility.waitForPageLoadNew(driver, PlanName_PlanDetails, 20);
		validateNew(PlanName_PlanDetails);
	}
	
	public void captureFunctionalToolTips(String planName) {
		WebElement WhyAverage = driver.findElement(By.xpath("//h4[contains(text(),'" + planName+ "')]/ancestor::div[contains(@class,'uhc-card_')]/following-sibling::div//*[contains(@aria-describedby , 'averageTooltipContent') and contains(@class , 'link-desk')]"));
		validateNew(WhyAverage);
/*
		scrollToView(WhyAverage);
		jsMouseOver(WhyAverage);
		jsClickNew(WhyAverage);
		WebElement WhyAverageContent = driver.findElement(By.xpath("//h4[contains(text(), '" + planName+ "')]/ancestor::div[contains(@class,'uhc-card_')]/following-sibling::div//*[contains(@id , 'averageLinkBtn')]/following-sibling::*[contains(@id , 'averageTooltipContent')]"));
		validateNew(WhyAverageContent);
		String WhyAverageContentText = WhyAverageContent.getText().trim();
		if (validateNew(WhyAverageContent)) {
			System.out.println("Why Average ToolTip text is present"+WhyAverageContentText);
		} else
			Assertion.fail("Why Average ToolTip text is not present");
		jsMouseOut(WhyAverageContent);
		*/
		WebElement WhatsIncluded = driver.findElement(By.xpath("//h4[contains(text(),'" + planName+ "')]/ancestor::div[contains(@class,'uhc-card_')]/following-sibling::div//*[contains(@aria-describedby , 'includeTooltipContent') and contains(@class , 'link-desk')]"));
		validateNew(WhatsIncluded);
		scrollToView(WhyAverage);
/*		jsMouseOver(WhatsIncluded);
		jsClickNew(WhatsIncluded);
		WebElement WhatsIncludedContent = driver.findElement(By.xpath("//h4[contains(text(), '" + planName+ "')]/ancestor::div[contains(@class,'uhc-card_')]/following-sibling::div//*[contains(@id , 'includeLinkBtn')]/following-sibling::*[contains(@id , 'TooltipContent')]"));
		validateNew(WhatsIncludedContent);
		String WhatsIncludedContentText = WhatsIncludedContent.getText().trim();
		if (validateNew(WhatsIncludedContent)) {
			System.out.println("Whats Included ToolTip text is present"+WhatsIncludedContentText);
		} else
			Assertion.fail("Whats Included ToolTip text is not present");
		jsMouseOut(WhatsIncludedContent);
		*/
		
	}

	public DrugSummaryPage verifyDefaultPlanType(String planType) {
		validateNew(planTypeHeading);
		if (planTypeHeading.getText().contains(planType)) {
			return new DrugSummaryPage(driver);
		}
		return null;
	}

	public void clickOnViewPlan() {
		validateNew(viewPlanButton);
		viewPlanButton.click();
	}

	@FindBy(xpath = "//*[@class='back-to-view-all-pla']")
	public WebElement returnToHomeBtn;

	public void clickOnReturnToHome() {
		try {
			if (savedPlansPopup.isDisplayed()) {
				savedPlansPopupCloseIcon.click();
			}
		} catch (Exception e) {
			System.out.println("Saved Plans modal not displayed");
		}
		validateNew(returnToHomeBtn);
		returnToHomeBtn.click();
	}

	public DrugSummaryPage verifyPDPPlanToggle() {
		pdpPlanToggle.click();
		System.out.println("PDP Plans Toggle is displayed and is Clicked");

		if (planTypeHeading.getText().contains("Medicare Prescription Drug Plans")) {
			System.out.println("PDP Plans displayed for PDP toggle click");
			return new DrugSummaryPage(driver);
		}
		Assertion.fail("PDP Plans NOT displayed for PDP toggle click");
		return null;
	}

	public DrugSummaryPage verifyMAPDPlanToggle() {

		mapdPlanToggle.click();
		System.out.println("MAPD Plans Toggle is displayed and is Clicked");

		if (planTypeHeading.getText().contains("Medicare Advantage Plans")) {
			System.out.println("MAPD Plans displayed for MAPD toggle click");
			return new DrugSummaryPage(driver);
		}
		Assertion.fail("MAPD Plans NOT displayed for MAPD toggle click");
		return null;
	}

	public DrugSummaryPage verifySNPPlanToggle() {
		snpPlanToggle.click();
		System.out.println("SNP Plans Toggle is displayed and is Clicked");

		if (planTypeHeading.getText().contains("Medicare Special Needs Plans")) {
			System.out.println("SNP Plans displayed for SNP toggle click");
			return new DrugSummaryPage(driver);
		}
		Assertion.fail("SNP Plans NOT displayed for SNP toggle click");
		return null;
	}

	@FindBy(id = "priceLinkBtn_0")
	private WebElement viewProceBtn;

	@FindBy(xpath = "//a[contains(text(),'Switch to Generic')]")
	private WebElement switchToGenericBtn;

	@FindBy(xpath = "//span[contains(text(),'Lipitor')]/following::a[contains(@id,'switchToGenericLink')]")
	private WebElement lipitorSwitchToGenericBtn;

	@FindBy(xpath = "//button[contains(@type,'submit')]//*[contains(text(),'Switch to Generic')]")
	private WebElement switchToGenericSubmitBtn;

	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private WebElement drugNames;

	@FindBy(id = "cancelicon")
	private WebElement drugClose;

	@FindBy(xpath = "//label/span[contains(text(),'Medicare Prescription Drug Plans')]")
	private WebElement pdpPlan;

	@FindBy(id = "modal-label")
	private WebElement drugTitle;

	/*
	 * @FindBy(xpath =
	 * "//a[contains(@id,'switchToGenericLink')]/../../span[contains(text(),'"+
	 * drugName+"')]") private WebElement switchToGenericDrugLink;
	 */

	public void clickViewPricing() {
		// validateNew(viewProceBtn);
		// viewProceBtn.click();
		validateNew(drugPricingLink);
		drugPricingLink.click();
	}

	public void clickswitchToGeneric() throws InterruptedException {

		// validateNew(drugTitle);
		validateNew(switchToGenericBtn);
		jsClickNew(switchToGenericBtn);
		validateNew(switchToGenericSubmitBtn);
		jsClickNew(switchToGenericSubmitBtn);
	}

	public void clicklipitorswitchToGeneric() throws InterruptedException {
		Thread.sleep(6000);
		validateNew(drugTitle);
		validateNew(lipitorSwitchToGenericBtn);
		lipitorSwitchToGenericBtn.click();
		validateNew(switchToGenericSubmitBtn);
		switchToGenericSubmitBtn.click();
	}

	public void clickOnPdpPlan() throws InterruptedException {
		Thread.sleep(6000);
		validateNew(pdpPlan);
		pdpPlan.click();
		validateNew(viewProceBtn);
		viewProceBtn.click();
	}

	public void verifyDrugListsUpdated(String genericDrug) throws InterruptedException {
		Thread.sleep(6000);
		validateNew(drugTitle);
		/*
		 * for(int i=0;i<drugNames.size();i++) {
		 * System.out.println(drugNames.get(i).getText()); }
		 */
		validateNew(drugNames);
		System.out.println(drugNames.getText() + "   " + genericDrug);
		Assertion.assertTrue("Drug not switched to generic", drugNames.getText().contains(genericDrug));
		validateNew(drugClose);
		drugClose.click();
	}

	@FindBy(id = "sign-up-modal-header")
	private WebElement createProfilePopup;

	public void savePlan(String planName) {
		try {
			List<String> listOfTestPlans = Arrays.asList(planName.split(","));
			System.out.println(
					"Going to mark the following " + listOfTestPlans.size() + " number of test plans as favorite");
			Thread.sleep(5000);
			for (String plan : listOfTestPlans) {
				// WebElement savePlan =
				// driver.findElement(By.xpath("//*[contains(text(),'"+plan+"')]/following::div[contains(@class,'favorite-plan-container')][1]//img[contains(@src,'unfilled.png')]"));
				WebElement savePlan = driver
						.findElement(By.xpath("//button[contains(@id,'saveBtn') and @aria-label='Save " + plan + "']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", savePlan);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", savePlan);
			}
			/*
			 * if(createProfilePopup.isDisplayed()) { closeProfilePopup.click(); }
			 */

			if (planSavePopup.isDisplayed()) {
				closeIconPlanSavePopup.click();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]/input[@name='plans-filter' and @value='PDP']")
	private WebElement clickPdpplan;

	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]/input[@name='plans-filter' and @value='SNP']")
	private WebElement clickSnpplan;

	@FindBy(xpath = "//div[@class='d-flex align-items-lg-center flex-lg-row']")
	private WebElement alertTextImg;

	public void clickOnPDPPlan() {
		validateNew(clickPdpplan);
		jsClickNew(clickPdpplan);
	}
	public void clickOnMAPDPlan() {
		validateNew(mapdPlanToggle);
		jsClickNew(mapdPlanToggle);
	}

	@FindBy(xpath = "//div[contains(text(),'If you receive')]")
	public WebElement drugPricingDeductText;

	public void verifyTheTextAlert() {

		validateNew(alertTextImg);
		validateNew(viewProceBtn);

	}

	public void verifyDrugPricingText() {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		validateNew(drugTitle);
		//validateNew(switchToGenericBtn);
		validateNew(drugPricingDeductText);
		String DrugPricingMsg = drugPricingDeductText.getText().replaceAll("\u00A0", " ").trim();
//		Assertion.assertTrue("Expected text not displayed on Drug pricing modal", drugPricingDeductText.getText().equals(LIS_MESSAGE_DRUG_PRICING));
		Assertion.assertTrue("Expected text not displayed on Drug pricing modal", DrugPricingMsg.equals(LIS_MESSAGE_DRUG_PRICING));
		validateNew(drugClose);
		jsClickNew(drugClose);
	}

	public void verifyDrugCoverageAndYouPayNotCoveredDrug() {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		validate(drugCoverageNotCoveredDrug);
		validate(youPayNotCoveredDrug);
	}

	public void verifyDrugCoverageAndYouPayCoveredDrug() {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		validate(drugCoverageCoveredDrug);
		validate(youPayCoveredDrug);
	}

	public void clickOnSNPPlan() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		validateNew(clickSnpplan);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", clickSnpplan);
	}

	@FindBy(xpath = "//button[@id='changePharmacyLink']")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//h2[contains(text(), 'Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;

	public DrugDetailsPage clickViewDrugDetailsForPlan(String plantype, String planName) {
		if (plantype.equalsIgnoreCase("MAPD")) {
			validateNew(mapdPlanToggle);
			jsClickNew(mapdPlanToggle);
			System.out.println("MAPD Plan Toggle Clicked");
			WebElement DrugCostsLinkforPlan = driver.findElement(
					By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '" + planName
							+ "')]"));
			validateNew(DrugCostsLinkforPlan);
			jsClickNew(DrugCostsLinkforPlan);
			System.out.println("View Drug Costs Clicked for MAPD Plan : " + planName);

		} else if (plantype.equalsIgnoreCase("PDP")) {
			validateNew(pdpPlanToggle);
			jsClickNew(pdpPlanToggle);
			System.out.println("PDP Plan Toggle Clicked");
			WebElement DrugCostsLinkforPlan = driver.findElement(
					By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '" + planName
							+ "')]"));
			validateNew(DrugCostsLinkforPlan);
			jsClickNew(DrugCostsLinkforPlan);
			System.out.println("View Drug Costs Clicked for PDP Plan : " + planName);

		} else {
			validateNew(snpPlanToggle);
			jsClickNew(snpPlanToggle);
			System.out.println("SNP Plan Toggle Clicked");
			WebElement DrugCostsLinkforPlan = driver.findElement(
					By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '" + planName
							+ "')]"));
			validateNew(DrugCostsLinkforPlan);
			jsClickNew(DrugCostsLinkforPlan);
			System.out.println("View Drug Costs Clicked for SNP Plan : " + planName);
		}
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsHeading, 30);
		if (validateNew(changePharmacy) && validateNew(DrugDetails_DrugCostsHeading)) {
			return new DrugDetailsPage(driver);
		} else {
			Assertion.fail("Drug Details Page is NOT Displayed");
			return null;
		}
	}

	public void clickChangePharmacy() {
		changePharmacy.click();
		validateSelectPharmacyPage();
	}

	// Code change Start - Added by F&F for Change Pharmacy to NC Pharmacy scenario

	@FindBy(xpath = "//*[@class='uhc-button__text'][contains(text(),'Save and Update Drug Costs')]")
	public WebElement saveDrugBtn;

	public void SelectPharmacy(String PharmacytoSelect) {

		List<WebElement> PharmacyName = driver
				.findElements(By.xpath("//button[contains(@id, 'selectPharmacyBtn') and contains(@aria-label, 'Select "
						+ PharmacytoSelect + "')]"));

		jsClickNew(PharmacyName.get(0));
		validateNew(saveDrugBtn);
		saveDrugBtn.click();
	}
 
	@FindBy(xpath = "//*[contains(@class, 'pharmacy-plan-desc')]")
	private WebElement PharmacyNameText;

	public void validatePharmacyName(String PharmacyName) {

		if (validateNew(PharmacyNameText) && PharmacyNameText.getText().contains(PharmacyName)) {
			Assertion.assertTrue("Correct Pharmacy Name is Displayed : " + PharmacyNameText.getText(), true);
		} else {
			Assertion.fail("Correct Pharmacy Name is NOT Displayed : " + PharmacyNameText.getText());
		}
	}

	// Code change End - Added by F&F for Change Pharmacy to NC Pharmacy scenario

	public DrugSummaryPage selectPharmacyModalDisplayed() throws InterruptedException {
		waitforElementNew(selectPharmacyHeader, 30);
		if (validateNew(selectPharmacyHeader)) {
			return new DrugSummaryPage(driver);
		}
		return null;
	}

	public DrugSummaryPage validateSelectPharmacyPage() {
		if (validateNew(selectPharmacyModalCloseBtn) && validateNew(selectedPharmacyLink)
				&& validateNew(distanceDrpDown) && validateNew(pharmacyZipcodeSearch) && validateNew(pharmacySearchBtn)
				&& validateNew(preferredMailPharmacy) && validateNew(pharmacyListSection)
				&& validateNew(matchingPharmacyCount) && validateNew(sortDrpdown) && validateNew(backBtn)
				&& validateNew(nextBtn)) {
			return new DrugSummaryPage(driver);
		}
		return null;
	}

	public void clickViewDrugCostBtn() {
		viewDrugCostBtn.click();
	}
	
	public void viewDrugPricingModal(String planName){
	  WebElement viewDrugPricingLink = driver.findElement(By.xpath("//h4[contains(text(),'" + planName + "')]/ancestor::div[contains(@class,'uhc-card_')]/following-sibling::div//*[contains(@id , 'priceLinkBtn')]"));
	  validateNew(viewDrugPricingLink);
	  jsClickNew(viewDrugPricingLink);
	  validateNew(DrugPricing_Header);
	  validateNew(DrugPricing_CloseBtn);
	  jsClickNew(DrugPricing_CloseBtn);
	  
	}

	public void validatePremiumForPlan(String premium, String plantype, String planName) {
		if (plantype.equalsIgnoreCase("MAPD")) {
			validateNew(mapdPlanToggle);
			jsClickNew(mapdPlanToggle);
			System.out.println("MAPD Plan Toggle Clicked");
		} else if (plantype.equalsIgnoreCase("PDP")) {
			validateNew(pdpPlanToggle);
			jsClickNew(pdpPlanToggle);
			System.out.println("PDP Plan Toggle Clicked");
		} else {
			validateNew(snpPlanToggle);
			jsClickNew(snpPlanToggle);
			System.out.println("SNP Plan Toggle Clicked");
		}
		WebElement PremiumforPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]//ancestor::*[contains(@class, 'uhc-card__header')]//following-sibling::*//*[contains(text(), 'Monthly Premium')]//following-sibling::*[contains(text(), '$')]"));
		validateNew(PremiumforPlan);
		String PremiumDisplayed = PremiumforPlan.getText();
		System.out.println("Premium Displayed for Plan : " + PremiumDisplayed);
		if (!PremiumDisplayed.contains(premium)) {
			Assertion.fail("Expected Premium not displayed, Expected : " + premium + "    Actual Displayed : "
					+ PremiumDisplayed);
		}
	}

	public Map<String, String> captureDrugCosts(String planName) {
		Map<String, String> DrugDetails = new HashMap<String, String>();

		if (planName.contains("PDP"))
			verifyPDPPlanToggle();
		else if (planName.contains("SNP"))
			verifySNPPlanToggle();
		else
			verifyMAPDPlanToggle();
		WebElement drugCosts_AvgMonDrugCost_Amount = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::*[contains(@class,'uhc-card__header')]//following-sibling::*[contains(@class,'uhc-card__content')]//*[contains(text(), 'Average Monthly Drug Cost')]//following-sibling::div[contains(text(), '$')]"));
		WebElement drugCosts_MonthlyPremium_Amount = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::*[contains(@class,'uhc-card__header')]//following-sibling::*[contains(@class,'uhc-card__content')]//*[contains(text(), 'Monthly Premium')]//following-sibling::div[contains(text(), '$')]"));
		WebElement drugCosts_AnnualEstTotal_Amount = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::*[contains(@class,'uhc-card__header')]//following-sibling::*[contains(@class,'uhc-card__content')]//*[contains(text(), 'Annual Estimated')]//following-sibling::div[contains(text(), '$')]"));

		String AVG_MONTHLY = drugCosts_AvgMonDrugCost_Amount.getText();
		String MONTHLY_PREMIUM = drugCosts_MonthlyPremium_Amount.getText();
		String ANNUAL_ESTIMATED_TOTAL = drugCosts_AnnualEstTotal_Amount.getText();
		String COVERED_DRUGS_COUNT = drugsCovered.getText();
		System.out.println("Covered Drug Text : " + COVERED_DRUGS_COUNT);
		DrugDetails.put("AVG_MONTHLY", AVG_MONTHLY);
		DrugDetails.put("MONTHLY_PREMIUM", MONTHLY_PREMIUM);
		DrugDetails.put("ANNUAL_ESTIMATED_TOTAL", ANNUAL_ESTIMATED_TOTAL);
		DrugDetails.put("COVERED_DRUGS_COUNT", COVERED_DRUGS_COUNT);

		return DrugDetails;
	}

	// Code change Start - Added by F&F for Drug Summary Regression Scenario -
	// Switch to Generic

	@FindBy(xpath = "//*[@id='modal-label' and contains(text(), 'Switch to Generic')]")
	public WebElement SwitchPageHeader;

	@FindBy(xpath = "//img[contains(@class,'uhc-modal__close')]")
	public WebElement SwitchPageCloseBtn;

	public SwitchToGeneric clickSwitchGeneric(String brandDrug) {
		CommonUtility.waitForPageLoadNew(driver, DrugPricing_CloseBtn, 20);
		validateNew(DrugPricing_Header);
		WebElement SwitchLink = driver.findElement(
				By.xpath("//*[contains(text(), '" + brandDrug + "')]//following::a[contains(text(), 'Switch ')]"));
		jsClickNew(SwitchLink);
		CommonUtility.waitForPageLoadNew(driver, SwitchPageHeader, 20);
		if (validateNew(SwitchPageHeader) && validateNew(SwitchPageCloseBtn)) {
			return new SwitchToGeneric(driver);
		}
		Assertion.fail("Did not Navigate to Switch To Generic Page");
		return null;
	}

	@FindBy(xpath = "//h3[contains(text(), 'Drug Pricing')]")
	public WebElement DrugPricing_Header;

	@FindBy(xpath = "//*[contains(@id, 'cancelicon')]")
	public WebElement DrugPricing_CloseBtn;

	public void ValidatesDrugsList(String druglistObject) {
		CommonUtility.waitForPageLoadNew(driver, DrugPricing_CloseBtn, 20);
		validateNew(DrugPricing_Header);
		String[] Drugs = druglistObject.split("&");
//		int DrugCount_Total = Drugs.length - 1;			//Commenting because null is handled when drugs are added to druglist array, thus array will only have drug names.
		int DrugCount_Total = Drugs.length;
		String currentAddedDrug;
		int i;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
//		for (i = 1; i <= DrugCount_Total; i++) {		//Druglist array does not have null and only has drug names, hence starting from 0 to array length - 1.
		for (i = 0; i < DrugCount_Total; i++) {	
			currentAddedDrug = Drugs[i];
			System.out.println("Current Added Drug Name : " + currentAddedDrug);
			WebElement DrugName = driver.findElement(By.xpath("//span[contains(text(), '" + currentAddedDrug + "')]"));
			WebElement DrugYouPay = driver.findElement(By.xpath(
					"//span[contains(text(), '" + currentAddedDrug + "')]//following::*[contains(text(), '$')]"));

			if (validateNew(DrugName) && validateNew(DrugYouPay)) {
				System.out
						.println("Drug Summary Page, Drug Pricing Modal -  Validated Drug List for Drug and You Pay : "
								+ currentAddedDrug);
			} else
				Assertion.fail(
						"Drug Summary Page, Drug Pricing Modal -  Validation FAILED for Drug List for Drug and You Pay : "
								+ currentAddedDrug);
		}
		validateNew(DrugPricing_CloseBtn);
		jsClickNew(DrugPricing_CloseBtn);
	}

	@FindBy(xpath = "//h5[contains(text(), 'Drugs Covered')]//following-sibling::*[contains(text(), ' of ')]")
	public WebElement DrugsCoveredText;

	public void ValidateNCPharmacyCoveredDrugs() {

		if (validateNew(DrugsCoveredText)) {
			System.out.println("Drug Summary Page, Drug Covered Text Displayed for Not Covered Pharmacy");
		} else
			Assertion.fail("Drug Summary Page, Drug Covered Text NOT Displayed for Not Covered Pharmacy");
	}

	@FindBy(xpath = "//*[contains(@id, 'pharmacy-zip-filter') or contains(@name, 'zipCode')]")
	public WebElement Pharmacy_ZipCodeTxt;

	@FindBy(xpath = "//*[contains(@id,'selectaPharmacy')]//*[contains(@class, 'uhc-button')][contains(text(), 'Search')]")
	public WebElement Pharmacy_SearchBtn;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]")
	public WebElement Pharmacy_DistanceDropDwn;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '1 Mile')]")
	public WebElement Pharmacy_Distance_Select1Mile;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '2 Mile')]")
	public WebElement Pharmacy_Distance_Select2Mile;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '5 Mile')]")
	public WebElement Pharmacy_Distance_Select5Mile;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '10 Mile')]")
	public WebElement Pharmacy_Distance_Select10Mile;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '15 Mile')]")
	public WebElement Pharmacy_Distance_Select15Mile;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '25 Mile')]")
	public WebElement Pharmacy_Distance_Select25Mile;

	@FindBy(xpath = "//h2[contains(@id, 'matchingLbl')]")
	public WebElement PharmacyCountTxt;

	public void validateZipandDistanceDropDwn(String pharmacyZipCode) {
		validateNew(Pharmacy_DistanceDropDwn);
		System.out.println("Pharmacy Seacth for default Zip " + Pharmacy_ZipCodeTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		Pharmacy_Distance_Select1Mile.click();
		// validateNew(Pharmacy_Distance_Select1Mile);
		jsClickNew(Pharmacy_Distance_Select1Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 1 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		Pharmacy_Distance_Select2Mile.click();
		// validateNew(Pharmacy_Distance_Select2Mile);
		jsClickNew(Pharmacy_Distance_Select2Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 2 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		// validateNew(Pharmacy_Distance_Select5Mile);
		Pharmacy_Distance_Select5Mile.click();
		jsClickNew(Pharmacy_Distance_Select5Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 5 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		// validateNew(Pharmacy_Distance_Select10Mile);
		Pharmacy_Distance_Select10Mile.click();
		jsClickNew(Pharmacy_Distance_Select10Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 10 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		// validateNew(Pharmacy_Distance_Select15Mile);
		Pharmacy_Distance_Select15Mile.click();
		jsClickNew(Pharmacy_Distance_Select15Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 15 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		// validateNew(Pharmacy_Distance_Select25Mile);
		Pharmacy_Distance_Select25Mile.click();
		jsClickNew(Pharmacy_Distance_Select25Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 25 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		validateNew(Pharmacy_ZipCodeTxt);
		Pharmacy_ZipCodeTxt.clear();
		Pharmacy_ZipCodeTxt.sendKeys(pharmacyZipCode);
		validateNew(Pharmacy_SearchBtn);
		Pharmacy_SearchBtn.click();
		System.out.println("Pharmacy Seacth for Zip Expected - " + pharmacyZipCode + "  : Entered : "
				+ Pharmacy_ZipCodeTxt.getText());
		System.out.println("Default Pharmacy Count for Zip - " + pharmacyZipCode + "  : " + PharmacyCountTxt.getText());

	}

	public void clickReturnToPlanSummary() {
//		returnToPlanSummaryLink.click();
		jsClickNew(returnToPlanSummaryLink);
		waitForPageLoadSafari();
	}

	public void clickReturnToHomePage() {
//		returnToHomePageLink.click();
		jsClickNew(returnToHomePageLink);
		waitForPageLoadSafari();
	}

	public PlanDetailsPage clickViewplanDetailsForPlan(String plantype, String planName) {
		// TODO Auto-generated method stub
		if (plantype.equalsIgnoreCase("MAPD")) {
			validateNew(mapdPlanToggle);
			jsClickNew(mapdPlanToggle);
			System.out.println("MAPD Plan Toggle Clicked");
			WebElement PlanDetailsLinkforPlan = driver.findElement(
					By.xpath("//button[contains(@aria-label, 'View Plan Details') and contains(@aria-label, '"
							+ planName + "')]"));
			validateNew(PlanDetailsLinkforPlan);
			jsClickNew(PlanDetailsLinkforPlan);
			System.out.println("View Plan details Clicked for MAPD Plan : " + planName);

		} else if (plantype.equalsIgnoreCase("PDP")) {
			validateNew(pdpPlanToggle);
			jsClickNew(pdpPlanToggle);
			System.out.println("PDP Plan Toggle Clicked");
			WebElement PlanDetailsLinkforPlan = driver.findElement(
					By.xpath("//button[contains(@aria-label, 'View Plan Details') and contains(@aria-label, '"
							+ planName + "')]"));
			validateNew(PlanDetailsLinkforPlan);
			jsClickNew(PlanDetailsLinkforPlan);
			System.out.println("View Plan details Clicked for PDP Plan : " + planName);

		} else {
			validateNew(snpPlanToggle);
			jsClickNew(snpPlanToggle);
			System.out.println("SNP Plan Toggle Clicked");
			WebElement PlanDetailsLinkforPlan = driver.findElement(
					By.xpath("//button[contains(@aria-label, 'View Plan Details') and contains(@aria-label, '"
							+ planName + "')]"));
			validateNew(PlanDetailsLinkforPlan);
			jsClickNew(PlanDetailsLinkforPlan);
			System.out.println("View Plan details Clicked for SNP Plan : " + planName);

		}
		return new PlanDetailsPage(driver);

	}

	public void verifyReturnToProfileDisplayed() {
		try {
			if (returnToProfileLink.isDisplayed()) {
				System.out.println("Return to profile displayed");
			}
		} catch (Exception e) {
			Assertion.fail("Return to profile not displayed");
		}
	}

	public void verifyBackToProfileDisplayed() {
		try {
			if (backToProfileBtn.size() == planNames.size()) {
				System.out.println("Back to profile displayed for each plan card");
			}
		} catch (Exception e) {
			Assertion.fail("Back to profile not displayed for each plan card");
		}
	}

	public void clickBackToProfileBtn() {
		try {
			backToProfileBtn.get(1).click();
			System.out.println("Back to profile clicked");
		} catch (Exception e) {
			Assertion.fail("Back to profile not displayed ");
		}
	}

	public void validateDCENBAModal() {
		if (validateNew(dceNBAModal)) {
			validateNew(dceNBAModalMsg);
			validateNew(dceNBAModalBtn);
			dceNBAModalBtn.click();
			waitforElement(signInBtn);
			Assertion.assertTrue("user not navigated to login page",
					driver.getCurrentUrl().contains("app/index.html#/login"));
		}
	}
	
	public void validateNBAModal() {
		validateNew(dceNBAModal);
		validateNew(dceNBAModalBtn);
	}

	public static String selectedPharmacyName;

	public void saveAndUpdatePharmacy() {
		firstPharmacySelectBtn.click();
		selectedPharmacyName = pharmacyNameSelected.getText();
		System.out.println(selectedPharmacyName);
		saveAndUpdateDrugCostBtn.click();
	}

	public void validateSelectedPharmacy() {
		String pharmacy = pharmacyName.getText().substring(9).trim();
		System.out.println(selectedPharmacyName);
		System.out.println(pharmacy);
		Assertion.assertTrue("Pharmacy not updated", selectedPharmacyName.contains(pharmacy));
	}

	public void clickSwitchToGenericLink(String drugName) {
		WebElement SwitchToGenericLink = driver.findElement(
				By.xpath("//span[contains(text(),'" + drugName + "')]/..//a[contains(@id,'switchToGenericLink')]"));
		waitforElement(SwitchToGenericLink);
		jsClickNew(SwitchToGenericLink);
	}

	public void updateDosageQtySupplyLength() {
		waitforElement(drugDosage);
		Select dosage = new Select(drugDosage);
		dosage.selectByIndex(1);
		drugQty.clear();
		drugQty.sendKeys("100");
		Select supplyLen = new Select(drugSupplyLength);
		supplyLen.selectByIndex(1);
		switchToGenericSubmitBtn.click();
	}

	public void clickChangePharmacyCoverPrescription() {
		validate(changePharmacyCoverPrescription);
		changePharmacyCoverPrescription.click();
		validateSelectPharmacyPage();
	}

	public void selectPreferredMailOrderPharmacy() {
		waitforElement(preferredMailPharmacy);
		preferredMailPharmacy.click();
	}
	@FindBy(xpath = "//button[contains(@id, 'mailSelectPharmacy')][contains(@aria-label, 'OptumRx Mail Service Pharmacy')]")
	public WebElement MailPharmacy;
	public void selectMailOrderPharmacy() {
		jsClickNew(MailPharmacy);
		validateNew(saveDrugBtn);
		saveDrugBtn.click();
	}
	public void validatePreferredMailOrderPharmacyMessage(String expectedMsg) {
		waitforElement(mailOrderPharmacyMsg);
		Assertion.assertTrue("Message for Mail order pharmacy not correct" + expectedMsg + "/n" + mailOrderPharmacyMsg,
				mailOrderPharmacyMsg.getText().trim().equals(expectedMsg));
	}

	public void validateDefaultDistance() {
		Select distance = new Select(distanceDrpDown);
		Assertion.assertTrue("Default distance is not 15 miles",
				distance.getFirstSelectedOption().getText().trim().equals("15 Miles"));
	}

	public void sortPharmacies(String sortOption) {
		Select sort = new Select(sortDrpdown);
		sort.selectByVisibleText(sortOption);
	}

	public void validatePharmaciesAscendingOrder() {
		List<String> pharmacListAfterSort = new ArrayList<String>();
		for (WebElement e : pharmacyNameList) {
			pharmacListAfterSort.add(e.getText());
		}
		System.out.println("After sort" + pharmacListAfterSort);
		Boolean sorted = Ordering.natural().isOrdered(pharmacListAfterSort);
		Assertion.assertTrue("Pharmacies are not sorted in ascending order", sorted);
	}

	public void validatePharmaciesDescendingOrder() {
		List<String> pharmacListAfterSort = new ArrayList<String>();
		for (WebElement e : pharmacyNameList) {
			pharmacListAfterSort.add(e.getText());
		}
		System.out.println("After sort" + pharmacListAfterSort);
		Boolean sorted = Ordering.natural().reverse().isOrdered(pharmacListAfterSort);
		Assertion.assertTrue("Pharmacies are not sorted in ascending order", sorted);
	}

	public void clickNextButton() {
		nextBtn.click();
	}

	public void clickBackButton() {
		backBtn.click();
	}

	public void validateSecondPageDisplayed() {
		String page = pageNumber.getText();
		Pattern p = Pattern.compile("Page (\\d*) of (\\d*)");
		java.util.regex.Matcher m = p.matcher(page);
		if (m.find()) {
			page = m.group(1);
		}
		Assertion.assertTrue("Second page not displayed", page.equals("2"));
	}

	public void validateFirstPageDisplayed() {
		String page = pageNumber.getText();
		Pattern p = Pattern.compile("Page (\\d*) of (\\d*)");
		java.util.regex.Matcher m = p.matcher(page);
		if (m.find()) {
			page = m.group(1);
		}
		Assertion.assertTrue("First page not displayed", page.equals("1"));
	}

	public void searchPharmaciesByZipcode(String zipcode) {
		pharmacyZipcodeSearch.clear();
		pharmacyZipcodeSearch.sendKeys(zipcode);
		pharmacySearchBtn.click();
	}

	public void validateNoResultsMsg(String expectedMsg) {
		waitforElement(noResultsMessage);
		System.out.println(noResultsMessage.getText());
		System.out.println(expectedMsg);
		Assertion.assertTrue("No results message not displayed", noResultsMessage.getText().equals(expectedMsg));
	}

	public void validateInvalidZipCodeMsg(String expectedMsg) {
		waitforElement(invalidZipCodeMsg);
		System.out.println(invalidZipCodeMsg.getText().trim());
		Assertion.assertTrue("Invalid zipcode message not displayed", invalidZipCodeMsg.getText().trim().equals(expectedMsg));
	}

	public void updateDistance(String distanceValue) throws InterruptedException {
		distanceDrpDown.click();
		Select distance = new Select(distanceDrpDown);
		distance.selectByVisibleText(distanceValue);
	}

	@FindBy(xpath = "//*[@id='changePharmacyLink0']")
	public WebElement changePharmacyAltMsg;

	public void clickChangePharmacyFromAltMsg() {
		waitforElement(changePharmacyAltMsg);
		validate(changePharmacyAltMsg);
		jsClickNew(changePharmacyAltMsg);
		//changePharmacyAltMsg.click();
		validateSelectPharmacyPage();
	}

	public void clickViewPlanDetails(String planName) {
		driver.findElement(By.xpath("//*[@class='uhc-card__header']//h4[contains(text(),'" + planName
				+ "')]//../../following-sibling::div//*[text()='View Plan Details']")).click();
	}

	public void validateDefaultPharmacyName(String defaultPharmacy) {
		validateNew(pharmacyName);
		Assertion.assertTrue("Default pharmacy name is not displayed", pharmacyName.getText().contains(defaultPharmacy));
	}

	public void clickKeepUsingPharmacyLink() {
		validateNew(keepUsingPharmacyLink);
		keepUsingPharmacyLink.click();
	}

	public PlanDetailsPage clickViewPlanDetails() {
		validateNew(firstViewPlanDetailsBtn);
		jsClickNew(firstViewPlanDetailsBtn);
		waitForPageLoadSafari();
		return new PlanDetailsPage(driver);
	}
	
    public void validateLISBanner_LISBuydownPlan_DrugSummary(String planName) {
    	WebElement LISBanner = driver.findElement(By.xpath("//h4[contains(text(),'" + planName+ "')]/ancestor::div[contains(@class, 'uhc-card_')]/following-sibling::div//*[contains(text(), 'level of Extra Help')]"));
    	if(validateNew(LISBanner)){
    		WebElement ExtraHelpLink = driver.findElement(By.xpath("//h4[contains(text(),'" + planName+ "')]/ancestor::div[contains(@class, 'uhc-card_')]/following-sibling::div//*[contains(text(), 'Learn more')]"));
    		System.out.println("Clicking on learn more about extra help link");
    		switchToNewTabNew(ExtraHelpLink);
    		CommonUtility.checkPageIsReadyNew(driver);
    		if(driver.getCurrentUrl().contains("extra-help")){
    			WebElement ExtraHelpText = driver.findElement(By.xpath("(//h2//*[contains(text(),'Extra Help')])[1]"));
                validateNew(ExtraHelpText);
                System.out.println("Extra Help page is displayed");
    		}
    		driver.close();
//    		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
    		driver.switchTo().window(CommonConstants.getMainWindowHandle());
    		System.out.println("Navigated back to drug summary page");
    	}
		
	}


	public void validateBreadCrumb(String breadCrumb) {
		Assertion.assertTrue("Expected breadcrumb " + breadCrumb + " is not displayed",
				breaCrumbLink.getText().equals(breadCrumb));
	}

	public void validateOptumRxConsistentDisplay_PharmacyPage() {
		//Zip code for No retail pharmacy results
		String pharmacyZipCode = "89405";
		clickChangePharmacy();
		validateSelectPharmacyPage();
		validateNew(Pharmacy_ZipCodeTxt);
		Pharmacy_ZipCodeTxt.clear();
		Pharmacy_ZipCodeTxt.sendKeys(pharmacyZipCode);
		validateNew(Pharmacy_SearchBtn);
		Pharmacy_SearchBtn.click();
		System.out.println("Pharmacy Seach for Zip Expected - " + pharmacyZipCode + "  : Entered : "
				+ Pharmacy_ZipCodeTxt.getText());
		validateNew(preferredMailPharmacy);
		validateNew(noResultsMessage);
		if (validateNew(Pharmacy_SearchBtn) && validateNew(noResultsMessage)) {
			System.out.println("OptumRx Pharmacy Displayed for Zip not returning any retail Pharmacy results");
			System.out.println("No results message displayed : "+noResultsMessage.getText());
			validateNew(selectPharmacyModalCloseBtn);
			System.out.println("Closing Pharmacy page");
			selectPharmacyModalCloseBtn.click();
			validateDrugSummaryPage();
		}
		else 
			Assertion.fail("Validation Failed : OptunRx NOT display and No Retail Pharmacy Error Message NOT displayed");
	
	}

	
	/*
	 * Adding code for Pharmacy filter validation
	 */

	@FindBy(xpath = "//label[contains(@for, 'pharmacy-name-filter')]")
	public WebElement PharmacyFilterLabel;
	
	@FindBy(xpath = "//input[contains(@id, 'pharmacy-name-filter')]")
	public WebElement PharmacyFilterTxtBx;

	@FindBy(xpath = "//button[contains(@dtmname, 'search')]/*[contains(text(), 'Apply')]")
	public WebElement PharmacyFilterApplyBtn;
	
	@FindBy(xpath = "//*[contains(@class, 'inputGroup')]/button/img")
	public WebElement PharmacyFilterClearTextX;

	@FindBy(xpath = "//*[contains(@id, 'filterError')]")
	public WebElement PharmacyFilterErrorMsg;

	public void validatePharmacyFilterErrormessage() {
		validateNew(PharmacyFilterLabel);
		validateNew(PharmacyFilterTxtBx);
		validateNew(PharmacyFilterApplyBtn);
		PharmacyFilterTxtBx.sendKeys("a");
		System.out.println("FIlter text entered : a");
		validateNew(PharmacyFilterClearTextX);
		System.out.println("X button for Filter text clearing is Displayed");
		jsClickNew(PharmacyFilterClearTextX);
		System.out.println("Clear Text is clicked for Pharmacy Filter");
		Assertion.assertTrue("Pharmacy Filter - Text is not cleared : >>>>>>>>> Validation Failed <<<<<<<<", PharmacyFilterTxtBx.getText().isEmpty());
	}

	public void validateXcleartextPharmacyFilter() {
		validateNew(PharmacyFilterApplyBtn);
		jsClickNew(PharmacyFilterApplyBtn);
		System.out.println("Apply button clicked for Blank filter text");
		validateNew(PharmacyFilterErrorMsg);
		System.out.println("Error Message for Pharmacy Filter is Displayed : >>>>>> "+PharmacyFilterErrorMsg.getText()+ " <<<<<<<");
		Assertion.assertTrue("Pharmacy Error Message NOT Displayed for blank filter text : >>>>>> Validation Failed <<<<<<<", (validateNew(PharmacyFilterErrorMsg) && PharmacyFilterErrorMsg.getText().contains("least two characters")));
	}

	public void ApplyPharmacyFilter(String filterText) {
		validateNew(PharmacyFilterTxtBx);
		PharmacyFilterTxtBx.clear();
		PharmacyFilterTxtBx.sendKeys(filterText);
		System.out.println("FIlter text entered : "+filterText);
		validateNew(PharmacyFilterApplyBtn);
		jsClickNew(PharmacyFilterApplyBtn);
		System.out.println("Apply button clicked for filter text"+filterText);
		for (WebElement PharmacyName : pharmacyNameList) {
			System.out.println("Pharmacy Name : "+PharmacyName.getText());
			if(!PharmacyName.getText().contains(filterText)) {
				Assert.fail("Pharmacy Filter Failed, Pharmacy Name does not match filter text, PharamcyName : "+PharmacyName+ "  Filter Text : "+filterText);
			}
		}
		System.out.println("All Pharmacy have filter text");
	}
}