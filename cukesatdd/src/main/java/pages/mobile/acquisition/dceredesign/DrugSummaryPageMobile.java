package pages.mobile.acquisition.dceredesign;

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
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.SwitchToGeneric;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;

public class DrugSummaryPageMobile extends UhcDriver {

	public DrugSummaryPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	// @FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	@FindBy(xpath = "//h2[contains(text(),'Review Drug Costs')]")
	public WebElement reviewDrugCostPageHeading;

	@FindBy(xpath = "//*[@id='guest-flow-widget-head']/../..")
	public WebElement dceNBAModal;

	@FindBy(xpath = "//*[@id='guest-flow-widget-head' and text()='Save your work for later']")
	public WebElement dceNBAModalMsg;

	@FindBy(xpath = "//button/*[text()='Create Your Profile']")
	public WebElement dceNBAModalBtn;

	@FindBy(id = "SignIn")
	public WebElement signInBtn;

	// @FindBy(xpath =
	// "//body/div[@id='site-wrapper']/div[3]/div[1]/div[1]/div[1]/app-root[1]/app-dceplansummary[1]/div[1]/div[3]/div[2]/select[1]")
	@FindBy(css = "div[class='uhc-radio-tabs']")
	public WebElement planTypeToggle;

	// @FindBy(xpath = "//span[text()='Pharmacy:']/..")
	@FindBy(css = "#changepharmacymobile h3")
	public WebElement pharmacyLink;

	@FindBy(xpath = "//*[@class='column column-12']//*[@class='uhc-select uhc-select--block']")
	public WebElement sortDropdown;

	@FindBy(xpath = "//*[@class='uhc-card__header']//h4")
	public WebElement planCardHeader;

	// @FindBy(xpath = "//*[text()='Average Monthly Drug
	// Cost']/following-sibling::div")
	@FindBy(xpath = "//p[text()='Average Monthly Drug Cost']/preceding-sibling::p")
	public WebElement avgMonthlyDrugCost;

	// @FindBy(xpath = "//*[text()='Monthly Premium']/following-sibling::div")
	@FindBy(xpath = "//p[contains(text(),'Monthly Premium')]/span")
	public WebElement monthlyPremium;

	// @FindBy(xpath = "//h5[contains(text(), 'Annual
	// Estimated')]//following-sibling::div")
	@FindBy(xpath = "//p[contains(text(), 'Annual Estimated')]/span")
	public WebElement annualEstimatedTotal;

	// @FindBy(xpath = "//*[text()='Drugs Covered']/following-sibling::div")
	@FindBy(xpath = "//p[contains(text(), 'Drugs Covered')]/span/span")
	public WebElement drugsCovered;

	@FindBy(xpath = "//*[contains(@id,'averageLinkBtn')]")
	public WebElement whyAverageLink;

	@FindBy(xpath = "//*[contains(@id,'includeLinkBtn')]")
	public WebElement whatsIncludedLink;

	// @FindBy(xpath = "//*[contains(@id,'priceLinkBtn')]")
	@FindBy(css = "div[class*='d-block'] button[id*='priceLinkBtn']")
	public WebElement drugPricingLink;

	// @FindBy(xpath = "//button/span[text()='View Drug Costs']")
	@FindBy(css = "#buttoncontainer button[aria-label*='View Drug Costs']")
	public WebElement viewDrugCostBtn;

	// @FindBy(xpath = "//button/span[text()='View Plan Details']")
	@FindBy(css = "div[class^='view-details-btn'] > button")
	public WebElement viewPlanDetailsBtn;

	// @FindBy(xpath = "//span[contains(text(),' Save ')]")
	@FindBy(css = "div[class$='card__header'] button[id^='saveBtn']")
	public WebElement saveBtn;

	@FindBy(xpath = "//*[@id='accordion-1-button']")
	public WebElement disclaimer;

	@FindBy(xpath = "(//*[contains(@class,'uhc-card__header')]//p)[1]")
	public WebElement planTypeHeading;

	@FindBy(xpath = "//button/span[text()='View Plan Details']")
	public WebElement viewPlanButton;

	// @FindBy(id = "changePharmacyLink")
	@FindBy(css = "div[class*='d-block'] [id*='changePharmacyLink']")
	public WebElement changePharmacy;

	@FindBy(css = "#modal-label")
	public WebElement selectPharmacyHeader;

	@FindBy(css = "#cancelicon")
	public WebElement selectPharmacyModalCloseBtn;

	@FindBy(xpath = "//*[contains(@class,'modal__content')]//*[contains(text(),'Current Pharmacy')]")
	public WebElement selectedPharmacyLink;

	@FindBy(css = "#milesDropdown")
	public WebElement distanceDrpDown;

	@FindBy(css = "#pharmacy-zip-filter")
	public WebElement pharmacyZipcodeSearch;

	@FindBy(css = "#pharmacyfilter > button")
	public WebElement pharmacySearchBtn;

	@FindBy(css = "#mailSelectPharmacyBtn0")
	public WebElement preferredMailPharmacy;

	@FindBy(id = "optumRxTxt")
	public WebElement optumRxMsg;

	@FindBy(css = "[role='tabpanel'][class^='uhc-list']")
	public WebElement pharmacyListSection;

	@FindBy(css = "div[class*='mobile-filter']")
	public WebElement matchingPharmacyCount;

	@FindBy(css = "#sortDropdown")
	public WebElement sortDrpdown;

	@FindBy(css = "#paginationBackBtn")
	public WebElement backBtn;

	@FindBy(css = "#paginationNextBtn")
	public WebElement nextBtn;

	@FindBy(id = "changePharmacyLink")
	public WebElement changePharmacyLinkDetailsPage;

	@FindBy(xpath = "//*[text()='Return to plan summary']")
	public WebElement returnToPlanSummaryLink;

	@FindBy(css = "#adddrug")
	private WebElement addDrugButton;

	@FindBy(css = "#pdp-plans-radio")
	private WebElement pdpPlanRadioButton;

	@FindBy(css = "#snp-plans-radio")
	private WebElement snpPlanRadioButton;

	@Override
	public void openAndValidate() {
		// validateNew(reviewDrugCostPageHeading);

	}

	public DrugSummaryPageMobile validateDrugSummaryPage() throws InterruptedException {
		boolean validation = false;
		// Commented locators are no longer seen on ui
		// && validateNew(whyAverageLink)
		// && validateNew(whatsIncludedLink)

		scrollToView(reviewDrugCostPageHeading);
		validation = validateNew(reviewDrugCostPageHeading);

		scrollToView(planTypeToggle);
		validation = validation && validateNew(planTypeToggle);

		scrollToView(pharmacyLink);
		validation = validation && validateNew(pharmacyLink);

		scrollToView(planCardHeader);
		validation = validation && validateNew(planCardHeader);

		scrollToView(avgMonthlyDrugCost);
		validation = validation && validateNew(avgMonthlyDrugCost);

		scrollToView(monthlyPremium);
		validation = validation && validateNew(monthlyPremium);

		scrollToView(annualEstimatedTotal);
		validation = validation && validateNew(annualEstimatedTotal);

		scrollToView(drugsCovered);
		validation = validation && validateNew(drugsCovered);

		scrollToView(drugPricingLink);
		validation = validation && validateNew(drugPricingLink);

		scrollToView(viewDrugCostBtn);
		validation = validation && validateNew(viewDrugCostBtn);

		scrollToView(viewPlanDetailsBtn);
		validation = validation && validateNew(viewPlanDetailsBtn);

		scrollToView(saveBtn);
		validation = validation && validateNew(saveBtn);

		scrollToView(disclaimer);
		validation = validation && validateNew(disclaimer);

		if (validation) {
			return new DrugSummaryPageMobile(driver);
		}

		return null;
	}

	public DrugSummaryPageMobile verifyDefaultPlanType(String planType) {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(planTypeHeading);
		validateNew(planTypeHeading);
		if (planTypeHeading.getText().contains(planType)) {
			return new DrugSummaryPageMobile(driver);
		}
		return null;
	}

	public DrugSummaryPageMobile verifyPDPPlanToggle() {

		jsClickNew(pdpPlanToggle);
		if (planTypeHeading.getText().contains("Medicare Prescription Drug Plans")) {
			return new DrugSummaryPageMobile(driver);
		}
		return null;
	}

	// Code change Start - Added by F&F for Change Pharmacy to NC Pharmacy scenario

	// @FindBy(xpath = "//*[@class='uhc-button__text'][contains(text(),'Save and
	// Update Drug Costs')]")
	@FindBy(css = "button[dtmname$='save and update drug costs']")
	public WebElement saveDrugBtn;

	public void SelectPharmacy(String PharmacyName) {

		List<WebElement> selectPharmacyButton = driver
				.findElements(By.xpath("//button[contains(@id, 'selectPharmacyBtn') and contains(@aria-label, 'Select "
						+ PharmacyName + "')]"));

		jsClickNew(selectPharmacyButton.get(selectPharmacyButton.size() - 1));
		validateNew(saveDrugBtn);
		jsClickNew(saveDrugBtn);
		// saveDrugBtn.click();
	}

	@FindBy(xpath = "//*[@class='pharmacy-plan-desc']")
	private WebElement pharmacyName;

	public void validateSelectedPharmacy() {
		String pharmacy = pharmacyName.getText().substring(9).trim();
		System.out.println(selectedPharmacyName);
		System.out.println(pharmacy);
		Assertion.assertTrue("Pharmacy not updated", selectedPharmacyName.contains(pharmacy));
	}

	@FindBy(xpath = "//span[contains(text(),'Preferred Pharmacies')]/parent::label[contains(@class,'uhc-filter')]")
	public WebElement preferredPharmacyTab;

	public void validatePreferredTab() {
		waitforElement(preferredPharmacyTab);
		validate(preferredPharmacyTab);
		preferredPharmacyTab.click();
	}

	public void ValidatesDrugsList(String druglistObject) {
		CommonUtility.waitForPageLoadNew(driver, DrugPricing_CloseBtn, 20);
		validateNew(DrugPricing_Header);
		String[] Drugs = druglistObject.split("&");
		// int DrugCount_Total = Drugs.length - 1; //Commenting because null is handled
		// when drugs are added to druglist array, thus array will only have drug names.
		int DrugCount_Total = Drugs.length;
		String currentAddedDrug;
		int i;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		// for (i = 1; i <= DrugCount_Total; i++) { //Druglist array does not have null
		// and only has drug names, hence starting from 0 to array length - 1.
		for (i = 0; i < DrugCount_Total; i++) {
			currentAddedDrug = Drugs[i];
			System.out.println("Current Added Drug Name : " + currentAddedDrug);
			WebElement DrugName = driver.findElement(By.xpath("//div/p[contains(text(), '" + currentAddedDrug + "')]"));
			WebElement DrugYouPay = driver.findElement(By.xpath(
					"//div/p[contains(text(), '" + currentAddedDrug + "')]//following::*[contains(text(), '$')]"));

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

	@FindBy(id = "selectPharmacyBtn0")
	private WebElement firstPharmacySelectBtn;

	public static String selectedPharmacyName;

	@FindBy(xpath = "//*[@id='selectPharmacyBtn0']/..//p/span")
	private WebElement pharmacyNameSelected;

	@FindBy(xpath = "//button/span[text()='Save and Update Drug Costs']")
	private WebElement saveAndUpdateDrugCostBtn;

	public void saveAndUpdatePharmacy() {
		firstPharmacySelectBtn.click();
		selectedPharmacyName = pharmacyNameSelected.getText();
		System.out.println(selectedPharmacyName);
		saveAndUpdateDrugCostBtn.click();
	}

	@FindBy(xpath = "//*[contains(@class,'keepPharmacyLink')]")
	private WebElement keepUsingPharmacyLink;

	public void clickKeepUsingPharmacyLink() {
		validateNew(keepUsingPharmacyLink);
		keepUsingPharmacyLink.click();
	}

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

	public void validateLISBanner_LISBuydownPlan_DrugSummary(String planName) {
		WebElement LISBanner = driver.findElement(By.xpath("//h4[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'uhc-card_')]/following-sibling::div//*[contains(text(), 'level of Extra Help')]"));
		if (validateNew(LISBanner)) {
			WebElement ExtraHelpLink = driver.findElement(By.xpath("//h4[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'uhc-card_')]/following-sibling::div//*[contains(text(), 'Learn more')]"));
			System.out.println("Clicking on learn more about extra help link");
			switchToNewTabNew(ExtraHelpLink);
			CommonUtility.checkPageIsReadyNew(driver);
			if (driver.getCurrentUrl().contains("extra-help")) {
				WebElement ExtraHelpText = driver.findElement(By.xpath("(//h2//*[contains(text(),'Extra Help')])[1]"));
				validateNew(ExtraHelpText);
				System.out.println("Extra Help page is displayed");
			}
			driver.close();
			// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
			driver.switchTo().window(CommonConstants.getMainWindowHandle());
			System.out.println("Navigated back to drug summary page");
		}

	}

	public void viewDrugPricingModal(String planName) {
		WebElement viewDrugPricingLink = driver.findElement(By.xpath("//h4[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class,'uhc-card_')]/following-sibling::div//*[contains(@id , 'priceLinkBtn')]"));
		validateNew(viewDrugPricingLink);
		jsClickNew(viewDrugPricingLink);
		validateNew(DrugPricing_Header);
		validateNew(DrugPricing_CloseBtn);
		jsClickNew(DrugPricing_CloseBtn);

	}

	public void captureFunctionalToolTips(String planName) {
		WebElement WhyAverage = driver.findElement(By.xpath("//h4[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class,'uhc-card_')]/following-sibling::div//*[contains(@aria-describedby , 'averageTooltipContent') and contains(@class , 'link-desk')]"));
		validateNew(WhyAverage);
		/*
		 * scrollToView(WhyAverage); jsMouseOver(WhyAverage); jsClickNew(WhyAverage);
		 * WebElement WhyAverageContent =
		 * driver.findElement(By.xpath("//h4[contains(text(), '" + planName+
		 * "')]/ancestor::div[contains(@class,'uhc-card_')]/following-sibling::div//*[contains(@id , 'averageLinkBtn')]/following-sibling::*[contains(@id , 'averageTooltipContent')]"
		 * )); validateNew(WhyAverageContent); String WhyAverageContentText =
		 * WhyAverageContent.getText().trim(); if (validateNew(WhyAverageContent)) {
		 * System.out.println("Why Average ToolTip text is present"
		 * +WhyAverageContentText); } else
		 * Assertion.fail("Why Average ToolTip text is not present");
		 * jsMouseOut(WhyAverageContent);
		 */
		WebElement WhatsIncluded = driver.findElement(By.xpath("//h4[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class,'uhc-card_')]/following-sibling::div//*[contains(@aria-describedby , 'includeTooltipContent') and contains(@class , 'link-desk')]"));
		validateNew(WhatsIncluded);
		scrollToView(WhyAverage);
		/*
		 * jsMouseOver(WhatsIncluded); jsClickNew(WhatsIncluded); WebElement
		 * WhatsIncludedContent = driver.findElement(By.xpath("//h4[contains(text(), '"
		 * + planName+
		 * "')]/ancestor::div[contains(@class,'uhc-card_')]/following-sibling::div//*[contains(@id , 'includeLinkBtn')]/following-sibling::*[contains(@id , 'TooltipContent')]"
		 * )); validateNew(WhatsIncludedContent); String WhatsIncludedContentText =
		 * WhatsIncludedContent.getText().trim(); if (validateNew(WhatsIncludedContent))
		 * { System.out.println("Whats Included ToolTip text is present"
		 * +WhatsIncludedContentText); } else
		 * Assertion.fail("Whats Included ToolTip text is not present");
		 * jsMouseOut(WhatsIncludedContent);
		 */

	}

	@FindBy(css = "button[id^='mailSelectPharmacy'][aria-label*='OptumRx Mail Service Pharmacy']")
	public WebElement MailPharmacy;

	public void selectMailOrderPharmacy() {
		jsClickNew(MailPharmacy);
		validateNew(saveDrugBtn);
		jsClickNew(saveDrugBtn);
	}

	@FindBy(xpath = "//a[@class='uhc-link-button']/span")
	private WebElement breaCrumbLink;

	public void validateBreadCrumb(String breadCrumb) {
		Assertion.assertTrue("Expected breadcrumb " + breadCrumb + " is not displayed",
				breaCrumbLink.getText().equals(breadCrumb));
	}

	public void validateXcleartextPharmacyFilter() {
		validateNew(PharmacyFilterApplyBtn);
		jsClickNew(PharmacyFilterApplyBtn);
		System.out.println("Apply button clicked for Blank filter text");
		validateNew(PharmacyFilterErrorMsg);
		System.out.println("Error Message for Pharmacy Filter is Displayed : >>>>>> " + PharmacyFilterErrorMsg.getText()
				+ " <<<<<<<");
		Assertion.assertTrue(
				"Pharmacy Error Message NOT Displayed for blank filter text : >>>>>> Validation Failed <<<<<<<",
				(validateNew(PharmacyFilterErrorMsg)
						&& PharmacyFilterErrorMsg.getText().contains("least two characters")));
	}

	public void ApplyPharmacyFilter(String filterText) {
		validateNew(PharmacyFilterTxtBx);
		PharmacyFilterTxtBx.clear();
		PharmacyFilterTxtBx.sendKeys(filterText);
		System.out.println("FIlter text entered : " + filterText);
		validateNew(PharmacyFilterApplyBtn);
		jsClickNew(PharmacyFilterApplyBtn);
		System.out.println("Apply button clicked for filter text" + filterText);
		for (WebElement PharmacyName : pharmacyNameList) {
			System.out.println("Pharmacy Name : " + PharmacyName.getText());
			if (!PharmacyName.getText().contains(filterText)) {
				Assert.fail("Pharmacy Filter Failed, Pharmacy Name does not match filter text, PharamcyName : "
						+ PharmacyName + "  Filter Text : " + filterText);
			}
		}
		System.out.println("All Pharmacy have filter text");
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
		Assertion.assertTrue("Pharmacy Filter - Text is not cleared : >>>>>>>>> Validation Failed <<<<<<<<",
				PharmacyFilterTxtBx.getText().isEmpty());
	}

	// @FindBy(xpath = "//*[contains(@id,'changePharmacyLink')]")
	@FindBy(css = "#changePharmacyLinkmobile")
	public WebElement changePharmacyAltMsg;

	public void clickChangePharmacyFromAltMsg() throws InterruptedException {
		// waitforElement(changePharmacyAltMsg); next method already waits to validate
		// the presense of element
		validate(changePharmacyAltMsg, 20);
		jsClickNew(changePharmacyAltMsg);
		// changePharmacyAltMsg.click();
		validateSelectPharmacyPage();
	}

	public void clickOnMAPDPlan() {
		validateNew(mapdPlanToggle);
		jsClickNew(mapdPlanToggle);
	}

	// @FindBy(xpath = "//*[contains(@class, 'pharmacy-plan-desc')]")
	@FindBy(css = "#changepharmacymobile h3 > span")
	private WebElement PharmacyNameText;

	public void validatePharmacyName(String PharmacyName) {

		if (validateNew(PharmacyNameText) && PharmacyNameText.getText().contains(PharmacyName)) {
			Assertion.assertTrue("Correct Pharmacy Name is Displayed : " + PharmacyNameText.getText(), true);
		} else {
			Assertion.fail("Correct Pharmacy Name is NOT Displayed : " + PharmacyNameText.getText());
		}
	}

	// @FindBy(xpath = "//h5[contains(text(), 'Drugs
	// Covered')]//following-sibling::*[contains(text(), ' of ')]")
	@FindBy(xpath = "//p[contains(text(), 'Drugs Covered')]//span[contains(text(), ' of ')]")
	public WebElement DrugsCoveredText;

	public void ValidateNCPharmacyCoveredDrugs() {

		if (validateNew(DrugsCoveredText)) {
			System.out.println("Drug Summary Page, Drug Covered Text Displayed for Not Covered Pharmacy");
		} else
			Assertion.fail("Drug Summary Page, Drug Covered Text NOT Displayed for Not Covered Pharmacy");
	}

	public DrugSummaryPageMobile verifySNPPlanToggle() {

		jsClickNew(snpPlanToggle);
		if (planTypeHeading.getText().contains("Medicare Special Needs Plans")) {
			return new DrugSummaryPageMobile(driver);
		}
		return null;
	}

	@FindBy(css = "p #priceLinkBtn_0")
	private WebElement viewProceBtn;

	@FindBy(xpath = "//a[contains(@id,'switchToGenericLink')]")
	private WebElement switchToGenericBtn;

	@FindBy(xpath = "//button[@type='submit']//span[text()='Switch to Generic']")
	private WebElement switchToGenericSubmitBtn;

	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private WebElement drugNames;

	@FindBy(id = "drugPricingTitleTxt")
	private WebElement drugTitle;

	public void clickViewPricing() {
		validate(drugPricingLink);

		jsClickNew(drugPricingLink);
	}

	public void clickswitchToGeneric() throws InterruptedException {
		Thread.sleep(6000);
		validate(drugTitle);
		validate(switchToGenericBtn);

		jsClickNew(switchToGenericBtn);
		validate(switchToGenericSubmitBtn);

		jsClickNew(switchToGenericSubmitBtn);
	}

	public void verifyDrugListsUpdated(String genericDrug) throws InterruptedException {
		Thread.sleep(6000);
		validate(drugTitle);
		/*
		 * for(int i=0;i<drugNames.size();i++) {
		 * System.out.println(drugNames.get(i).getText()); }
		 */
		System.out.println(drugNames);
		Assertion.assertTrue("Drug not switched to generic", drugNames.getText().contains(genericDrug));
	}

	public void clickOnPdpPlan() throws InterruptedException {
		jsClickNew(pdpPlanRadioButton);

		validate(viewProceBtn);
		jsClickNew(viewProceBtn);
	}
	// Switch to Generic

	@FindBy(xpath = "//h2[contains(text(), 'Drug Pricing')]")
	public WebElement DrugPricing_Header;

	@FindBy(xpath = "//*[contains(@id, 'cancelicon')]")
	public WebElement DrugPricing_CloseBtn;

	@FindBy(xpath = "//*[@id='modal-label' and contains(text(), 'Switch to Generic')]")
	public WebElement SwitchPageHeader;

	// @FindBy(xpath = "//img[contains(@class,'uhc-modal__close')]")
	@FindBy(css = "#cancelicon")
	public WebElement SwitchPageCloseBtn;

	public SwitchToGenericMobile clickSwitchGeneric(String brandDrug) {
		CommonUtility.waitForPageLoadNew(driver, DrugPricing_CloseBtn, 20);
		validateNew(DrugPricing_Header);
		WebElement SwitchLink = driver.findElement(

				By.xpath("//*[contains(text(), '" + brandDrug
						+ "')]//following::*[contains(@id, 'switchToGenericLink')]"));

		jsClickNew(SwitchLink);
		CommonUtility.waitForPageLoadNew(driver, SwitchPageHeader, 20);
		if (validateNew(SwitchPageHeader) && validateNew(SwitchPageCloseBtn)) {
			return new SwitchToGenericMobile(driver);
		}
		Assertion.fail("Did not Navigate to Switch To Generic Page");
		return null;
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
				WebElement savePlan = driver.findElement(By.cssSelector("[aria-label='Save " + plan + "']"));
				jsClickNew(savePlan);
			}
			/*
			 * if(createProfilePopup.isDisplayed()) { closeProfilePopup.click(); }
			 */

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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(pdpPlanRadioButton);
		jsClickNew(pdpPlanRadioButton);

	}

	@FindBy(xpath = "//div[contains(text(),'If you qualify for LIS,')]")
	public WebElement drugPricingDeductText;

	public void verifyTheTextAlert() {

		validate(alertTextImg);
		validate(viewProceBtn);
	}

	public void verifyDrugPricingText() {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(drugTitle);
		validate(switchToGenericBtn);
		validate(drugPricingDeductText);

	}

	public void clickOnSNPPlan() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsClickNew(snpPlanRadioButton);
	}

	@FindBy(xpath = "//*[contains(text(), 'Change Pharmacy') or @id='changePharmacyLink']")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//h2[contains(text(), 'Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;

	@FindBy(css = ".uhc-card__content")
	public WebElement DrugDetails_DrugCostsCard;

	@FindBy(xpath = "//body/div[@id='site-wrapper']/div[3]/div[1]/div[1]/div[1]/app-root[1]/app-dceplansummary[1]/div[1]/div[3]/div[2]/select[1]")
	public WebElement ToggleDropDown;

	public void validateDefaultDistance() {
		Select distance = new Select(distanceDrpDown);
		Assertion.assertTrue("Default distance is not 15 miles",
				distance.getFirstSelectedOption().getText().trim().equals("15 Miles"));
	}

	public DrugDetailsPageMobile clickViewDrugDetailsForPlan(String plantype, String planName) {
		if (plantype.equalsIgnoreCase("MAPD")) {
			pageloadcomplete();
			scrollToView(mapdPlanToggle);
			// validateNew(mapdPlanToggle);
			jsClickNew(mapdPlanToggle);
			System.out.println("MAPD Plan Toggle Clicked");
			WebElement DrugCostsLinkforPlan = driver.findElement(
					By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '" + planName
							+ "')]"));
			validateNew(DrugCostsLinkforPlan);
			jsClickNew(DrugCostsLinkforPlan);
			System.out.println("View Drug Costs Clicked for MAPD Plan : " + planName);

		} else if (plantype.equalsIgnoreCase("PDP")) {
			scrollToView(pdpPlanToggle);
			// validateNew(pdpPlanToggle);
			jsClickNew(pdpPlanToggle);
			System.out.println("PDP Plan Toggle Clicked");
			WebElement DrugCostsLinkforPlan = driver.findElement(
					By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '" + planName
							+ "')]"));
			validateNew(DrugCostsLinkforPlan);
			jsClickNew(DrugCostsLinkforPlan);
			System.out.println("View Drug Costs Clicked for PDP Plan : " + planName);

		} else {
			scrollToView(snpPlanToggle);
			// validateNew(snpPlanToggle);
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
		CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsCard, 30);
		if (validateNew(changePharmacy) && validateNew(DrugDetails_DrugCostsCard)) {
			return new DrugDetailsPageMobile(driver);
		} else {
			Assertion.fail("Drug Details Page is NOT Displayed");
			return null;
		}
	}

	public void clickChangePharmacy() {
		// changePharmacy.click(); exception thrown for click on saucelabs -
		// org.openqa.selenium.WebDriverException
		jsClickNew(changePharmacy);
	}

	public DrugSummaryPageMobile selectPharmacyModalDisplayed() throws InterruptedException {
		waitforElementNew(selectPharmacyHeader, 30);
		if (validateNew(selectPharmacyHeader)) {
			return new DrugSummaryPageMobile(driver);
		}
		return null;
	}

	public DrugSummaryPageMobile validateSelectPharmacyPage() throws InterruptedException {
		if (validateNew(selectPharmacyModalCloseBtn) && validateNew(selectedPharmacyLink)
				&& validateNew(distanceDrpDown) && validateNew(pharmacyZipcodeSearch) && validateNew(pharmacySearchBtn)
				&& validateNew(preferredMailPharmacy) && validateNew(pharmacyListSection)
				&& validateNew(matchingPharmacyCount) && validateNew(sortDrpdown) && validateNew(backBtn)
				&& validateNew(nextBtn)) {
			return new DrugSummaryPageMobile(driver);
		}

		return null;
	}

	public DrugDetailsPageMobile clickViewDrugCostBtn() {
		jsClickNew(viewDrugCostBtn);
		CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsCard, 30);
		boolean elementsPresent = false;
		scrollToView(DrugDetails_DrugCostsCard);
		elementsPresent = validateNew(DrugDetails_DrugCostsCard);

		scrollToView(changePharmacy);
		elementsPresent = elementsPresent && validateNew(changePharmacy);

		if (elementsPresent) {
			return new DrugDetailsPageMobile(driver);
		} else {
			Assertion.fail("Drug Details Page is NOT Displayed");
			return null;
		}
	}

	@FindBy(xpath = "//button//span[text()='Back to Profile']")
	public List<WebElement> backToProfileBtn;

	public void clickBackToProfileBtn() {
		try {
			backToProfileBtn.get(1).click();
			System.out.println("Back to profile clicked");
		} catch (Exception e) {
			Assertion.fail("Back to profile not displayed ");
		}
	}

//	@FindBy(xpath = "//*[text()='Return to Profile']")
	@FindBy(css = "a[dtmname='dce:return to profile']")
	public WebElement returnToProfileLink;

	public void verifyReturnToProfileDisplayed() {

		validateNew(returnToProfileLink, 3);
		try {
			if (returnToProfileLink.isDisplayed()) {
				System.out.println("Return to profile displayed");
			}
		} catch (Exception e) {
			Assertion.fail("Return to profile not displayed");
		}
	}
	
	public void clickReturnToProfileLink() {
		if(validateNew(returnToProfileLink)) {
			jsClickNew(returnToProfileLink);
		}
	}

	@FindBy(xpath = "//*[@class='plane-name-block']")
	public List<WebElement> planNames;

	public void verifyBackToProfileDisplayed() {
		try {
			if (backToProfileBtn.size() == planNames.size()) {
				System.out.println("Back to profile displayed for each plan card");
			}
		} catch (Exception e) {
			Assertion.fail("Back to profile not displayed for each plan card");
		}
	}

	public void sortPharmacies(String sortOption) {
		mobileSelectOption(sortDrpdown, sortOption, true);
	}

	@FindBy(xpath = "//*[@id='mailSelectPharmacyBtn0']//parent::div//following-sibling::div[contains(text(), 'OptumRx Home')]")
	private WebElement mailOrderPharmacyMsg;

	public void validatePreferredMailOrderPharmacyMessage(String expectedMsg) {
		waitforElement(mailOrderPharmacyMsg);
		Assertion.assertTrue("Message for Mail order pharmacy not correct" + expectedMsg + "/n" + mailOrderPharmacyMsg,
				mailOrderPharmacyMsg.getText().trim().equals(expectedMsg));
	}

	// @FindBy(xpath =
	// "//label[@for='ma-plans-radio']//span[contains(text(),'Medicare Advantage
	// Plans')]")
	@FindBy(css = "#mapd-plans-radio")
	public WebElement mapdPlanToggle;

	// @FindBy(xpath =
	// "//label[@for='pdp-plans-radio']//span[contains(text(),'Medicare Prescription
	// Drug Plans')]")
	@FindBy(css = "#pdp-plans-radio")
	public WebElement pdpPlanToggle;

	// @FindBy(xpath =
	// "//label[@for='snp-plans-radio']//span[contains(text(),'Medicare Special
	// Needs Plans')]")
	@FindBy(css = "#snp-plans-radio")
	public WebElement snpPlanToggle;

	public void validatePremiumForPlan(String premium, String plantype, String planName) {
		if (plantype.equalsIgnoreCase("MAPD")) {
			scrollToView(mapdPlanToggle);
			// validateNew(mapdPlanToggle,10);
			jsClickNew(mapdPlanToggle);
			System.out.println("MAPD Plan Toggle Clicked");
		} else if (plantype.equalsIgnoreCase("PDP")) {
			scrollToView(pdpPlanToggle);
			// validateNew(pdpPlanToggle,10);
			jsClickNew(pdpPlanToggle);
			System.out.println("PDP Plan Toggle Clicked");
		} else {
			scrollToView(snpPlanToggle);
			// validateNew(snpPlanToggle,10);
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

	public void validateDCENBAModal() {

		scrollToView(dceNBAModal);
		if (validateNew(dceNBAModal)) {
			validateNew(dceNBAModalMsg);
			validateNew(dceNBAModalBtn);

			jsClickNew(dceNBAModalBtn);
			waitforElement(signInBtn);
			Assertion.assertTrue("user not navigated to login page",
					driver.getCurrentUrl().contains("app/index.html#/login"));
		}
	}

	public void verifyReviewDrugCostPageDisplayed() {
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);
		if (validateNew(reviewDrugCostPageHeading)) {
			Assertion.assertTrue("Review drug cost page not displayed", true);
		} else {
			Assertion.assertTrue("Review drug cost page not displayed", false);
		}

	}

	public void selectPreferredMailOrderPharmacy() {
		waitforElement(preferredMailPharmacy);
		// preferredMailPharmacy.click();
		jsClickNew(preferredMailPharmacy);
	}

	@FindBy(xpath = "//*[contains(@id,'selectPharmacyBtn')]/../preceding-sibling::div//p/span[@class='text-bold']")
	private List<WebElement> pharmacyNameList;

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
		jsClickNew(nextBtn);
	}

	// @FindBy(xpath = "//*[@class='pagination']/../p")
	@FindBy(css = "nav[aria-label='Results Pagination'] > p")
	private WebElement pageNumber;

	public void validateSecondPageDisplayed() {
		String page = pageNumber.getText();
		Pattern p = Pattern.compile("Page (\\d*) of (\\d*)");
		java.util.regex.Matcher m = p.matcher(page);
		if (m.find()) {
			page = m.group(1);
		}
		Assertion.assertTrue("Second page not displayed", page.equals("2"));
	}

	public void clickBackButton() {
		jsClickNew(backBtn);
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
		sendkeysMobile(pharmacyZipcodeSearch, zipcode);
		jsClickNew(pharmacySearchBtn);
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

	public Map<String, String> captureDrugCosts(String planName) {
		Map<String, String> DrugDetails = new HashMap<String, String>();

		if (planName.contains("PDP"))
			verifyPDPPlanToggle();
		else if (planName.contains("SNP"))
			verifySNPPlanToggle();
		else
			verifyMAPDPlanToggle();
		
		WebElement drugCosts_AvgMonDrugCost_Amount = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::*[contains(@class,'uhc-card__header')]//following-sibling::*[contains(@class,'uhc-card__content')]//p[contains(text(), 'Average Monthly Drug Cost')]//preceding-sibling::p[contains(text(), '$')]"));
		WebElement drugCosts_MonthlyPremium_Amount = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::*[contains(@class,'uhc-card__header')]//following-sibling::*[contains(@class,'uhc-card__content')]//p[contains(text(), 'Monthly Premium')]/span[contains(text(), '$')]"));
		WebElement drugCosts_AnnualEstTotal_Amount = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::*[contains(@class,'uhc-card__header')]//following-sibling::*[contains(@class,'uhc-card__content')]//p[contains(text(), 'Annual Estimated')]/span[contains(text(), '$')]"));

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

	@FindBy(css = "[class='field-error-msgfordceui'] > span")
	private WebElement noResultsMessage;

	public void validateNoResultsMsg(String expectedMsg) {
		waitforElement(noResultsMessage);
		System.out.println(noResultsMessage.getText());
		System.out.println(expectedMsg);
		Assertion.assertTrue("No results message not displayed", noResultsMessage.getText().equals(expectedMsg));
	}

	@FindBy(css = "#inValidZipcodeLbl")
	private WebElement invalidZipCodeMsg;

	public void validateInvalidZipCodeMsg(String expectedMsg) {
		waitforElement(invalidZipCodeMsg);
		System.out.println(invalidZipCodeMsg.getText().trim());
		if (!invalidZipCodeMsg.getText().contains(expectedMsg)) {
			Assertion.fail(">>>>>> Invalid zipcode message not displayed : " + invalidZipCodeMsg.getText()
					+ "<<<<< ; Expected - " + expectedMsg);
		}
	}

	@FindBy(xpath = "//*[contains(@id, 'pharmacy-zip-filter') or contains(@name, 'zipCode')]")
	public WebElement Pharmacy_ZipCodeTxt;

	@FindBy(xpath = "//*[contains(@id,'selectaPharmacy')]//*[contains(@class, 'uhc-button')][contains(text(), 'Search')]")
	public WebElement Pharmacy_SearchBtn;

	public void validateOptumRxConsistentDisplay_PharmacyPage() {
		// Zip code for No retail pharmacy results
		String pharmacyZipCode = "89405";
		clickChangePharmacy();
		try {
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
				System.out.println("No results message displayed : " + noResultsMessage.getText());
				validateNew(selectPharmacyModalCloseBtn);
				System.out.println("Closing Pharmacy page");
				selectPharmacyModalCloseBtn.click();
				validateDrugSummaryPage();
			} else
				Assertion.fail(
						"Validation Failed : OptunRx NOT display and No Retail Pharmacy Error Message NOT displayed");

		} catch (InterruptedException e) {
			System.out.println("Execption occured while validating pharmacy page");
		}
	}

	public void validateNBAModal() {
		validateNew(dceNBAModal);
		validateNew(dceNBAModalBtn);
	}

	/*
	 * @FindBy(xpath = "//select[contains(@dlassetid,'planselect')]") private
	 * WebElement planToggleDropdown;
	 */

	public PlanDetailsPageMobile clickViewplanDetailsForPlan(String plantype, String planName) {

		/*
		 * String planType = plantype.toUpperCase();
		 * selectFromDropDownByValue(planToggleDropdown, planType);
		 */
		CommonUtility.waitForPageLoadNew(driver, planTypeToggle, 30);
		String planType = plantype.toLowerCase();
		WebElement planTypeOption = driver.findElement(By.cssSelector("input[id^='" + planType + "']"));
		jsClickNew(planTypeOption);
		System.out.println(planType + " Plan Toggle Clicked");

		/*
		 * WebElement PlanDetailsLinkforPlan = driver.findElement(By.xpath(
		 * "//button[contains(@aria-label, 'View Plan Details') and contains(@aria-label, '"
		 * + planName + "')]"));
		 */

		WebElement PlanDetailsLinkforPlan = driver
				.findElement(By.cssSelector("div[class^='view-details'] > button[aria-label$='" + planName + "']"));
		if (validate(PlanDetailsLinkforPlan)) {
			jsClickNew(PlanDetailsLinkforPlan);
			System.out.println("View Plan details Clicked for " + planType + " Plan : " + planName);
		}
		return new PlanDetailsPageMobile(driver);

	}

	@FindBy(xpath = "//button[contains(@dtmname, 'drug pricing:edit drug list')]")
	public WebElement DrugPricingModal_EditDrugs;

	// @FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	@FindBy(css = "#drugsearchmobile")
	public WebElement EnterDrugNameTxt;

	// @FindBy(xpath = "//button[(@id= 'search')]")
	@FindBy(css = "[datatoshow='drugName'] + button")
	public WebElement SearchBtn;

	public BuildYourDrugListMobile clickEditDrugs_DrugPricingModal() {
		pageloadcomplete();
		validateNew(DrugPricingModal_EditDrugs);
		jsClickNew(DrugPricingModal_EditDrugs);
		waitForPageLoadSafari();
		// CommonUtility.waitForPageLoadNew(driver, addDrugButton, 20);
		// if (validateNew(EnterDrugNameTxt) && validateNew(SearchBtn)) {
		if (validateNew(addDrugButton)) {
			return new BuildYourDrugListMobile(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public void clickReturnToPlanSummary() {
		// returnToPlanSummaryLink.click();
		jsClickNew(returnToPlanSummaryLink);
		waitForPageLoadSafari();
	}

	@FindBy(xpath = "//*[@id='enrollmentPopup']/..")
	private WebElement savedPlansPopup;

	@FindBy(xpath = "//*[@id='enrollmentPopup']/..//*[@class='uhc-modal__close']")
	private WebElement savedPlansPopupCloseIcon;

	@FindBy(xpath = "//*[@class='back-to-view-all-pla']")
	public WebElement returnToHomeBtn;

	public void clickOnReturnToHome() {
		try {
			if (savedPlansPopup.isDisplayed()) {
				jsClickNew(savedPlansPopupCloseIcon);
			}
		} catch (Exception e) {
			System.out.println("Saved Plans modal not displayed");
		}
		scrollToView(returnToHomeBtn);
		validateNew(returnToHomeBtn);
		jsClickNew(returnToHomeBtn);
	}

}
