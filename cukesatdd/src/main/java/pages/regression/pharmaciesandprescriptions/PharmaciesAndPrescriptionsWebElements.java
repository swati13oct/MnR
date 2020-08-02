package pages.regression.pharmaciesandprescriptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import atdd.framework.UhcDriver;

/**
 * Functionality : WebElements for Pharmacies & Prescriptions page
 */
public class PharmaciesAndPrescriptionsWebElements extends UhcDriver {
	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	protected WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	protected WebElement needHelp_TechicalSupportSection;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	protected WebElement needHelp_TechicalSupport_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	protected WebElement needHelp_TechicalSupport_phone;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	protected WebElement needHelp_TechicalSupport_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	protected WebElement needHelp_TechicalSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	protected WebElement needHelp_TechicalSupport_wkEndHrs;

	//note: need help - general section
	@FindBy(xpath="//div[contains(@class,'general section')]")
	protected WebElement needHelp_GeneralQuestionsSection;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[1]//img")
	protected WebElement needHelp_GeneralQuestions_img;

	@FindBy(xpath="//div[contains(@class,'general section')]/div/div/p[1]")
	protected WebElement needHelp_GeneralQuestions_phone;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[2]")
	protected WebElement needHelp_GeneralQuestions_tty;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[3]")
	protected WebElement needHelp_GeneralQuestions_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[4]")
	protected WebElement needHelp_GeneralQuestions_wkEndHrs;

	//note: need help - claims section
	@FindBy(xpath="//div[contains(@class,'claims section')]")
	protected WebElement needHelp_ClaimsSupportSection;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[1]//img")
	protected WebElement needHelp_ClaimsSupport_img;

	@FindBy(xpath="//div[contains(@class,'claims section')]/div/div/div/p[1]")
	protected WebElement needHelp_ClaimsSupport_phone;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[2]")
	protected WebElement needHelp_ClaimsSupport_tty;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[3]")
	protected WebElement needHelp_ClaimsSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[4]")
	protected WebElement needHelp_ClaimsSupport_wkEndHrs;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	protected WebElement needHelp_PlanSupportSection;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	protected WebElement needHelp_PlanSupport_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	protected WebElement needHelp_PlanSupport_phone;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	protected WebElement needHelp_PlanSupport_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	protected WebElement needHelp_PlanSupport_wkDayHrs;

	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	protected WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	protected WebElement needHelp_contactUsLink;
	
	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	protected WebElement comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan') and not(contains(.,'Med'))]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSUP;

	@FindBy(xpath="//h1[contains(text(),'Pharmacies & Prescriptions for')]")
	protected WebElement pgHeader;

	@FindBy(xpath="//div[@class='pharmaciesText']")
	protected WebElement pharmaciesText;

	//note: Compare drug pricing
	@FindBy(xpath="//div[(contains(@class,'DRUGPRICINGTILE') or contains(@class,'DRUG_PRICING_TILE_Group'))and not(contains(@class,'ng-hide'))]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_compDrugPricingHeaderTxt;

	@FindBy(xpath="//div[(contains(@class,'DRUGPRICINGTILE') or contains(@class,'DRUG_PRICING_TILE_Group'))and not(contains(@class,'ng-hide'))]//img")
	protected WebElement pTile_compDrugPricingImg;

	@FindBy(xpath="//div[(contains(@class,'DRUGPRICINGTILE') or contains(@class,'DRUG_PRICING_TILE_Group'))and not(contains(@class,'ng-hide'))]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_compDrugPricingLnk;

	//note: Find a network pharmacy
	@FindBy(xpath="//div[contains(@id,'idName2')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_findNtkPharmacyHeaderTxt;

	@FindBy(xpath="//div[contains(@id,'idName2')]//img")
	protected WebElement pTile_findNtkPharmacyImg;

	@FindBy(xpath="//div[contains(@id,'idName2')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_findNtkPharmacyLnk;

	//note: Order prescription refills
	@FindBy(xpath="//div[contains(@class,'MEDICINE_CABINET_TILE')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_orderPresRefillsHeaderTxt;

	@FindBy(xpath="//div[contains(@class,'MEDICINE_CABINET_TILE')]//img")
	protected WebElement pTile_orderPresRefillsImg;

	@FindBy(xpath="//div[contains(@class,'MEDICINE_CABINET_TILE')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_orderPresRefillsLnk;

	//note: Check home delivery order status
	@FindBy(xpath="//div[contains(@class,'ORDER_STATUS_TILE')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_chkHomeDeliOrderStatusHeaderTxt;

	@FindBy(xpath="//div[contains(@class,'ORDER_STATUS_TILE')]//img")
	protected WebElement pTile_chkHomeDeliOrderStatusImg;

	@FindBy(xpath="//div[contains(@class,'ORDER_STATUS_TILE')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_chkHomeDeliOrderStatusLnk;

	//note: Prescription Benefits Information
	@FindBy(xpath="//div[contains(@class,'BENEFITS_INFORMATION')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_presBenfitInfoHeaderTxt;

	@FindBy(xpath="//div[contains(@class,'BENEFITS_INFORMATION')]//img")
	protected WebElement pTile_presBenfitInfoImg;

	@FindBy(xpath="//div[contains(@class,'BENEFITS_INFORMATION')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_presBenfitInfoLnk;

	@FindBy(xpath="//div[contains(@class,'planmaterials')]//img")
	protected WebElement viewPlanMaterialsImg;

	@FindBy(xpath="//div[contains(@class,'planmaterials')]//a")
	protected WebElement viewPlanMaterialsLnk;
	
	@FindBy(xpath = "//p[contains(text(),'Find out if your drugs are covered, estimate costs')]")
	protected WebElement LookUpDrugsButton;
	
	@FindBy(xpath ="//p[contains(text(),'Refill your prescriptions with home delivery')]")
	protected WebElement orderPrescriptionsButton;
	
	@FindBy(css=".ORDER_STATUS_TILE #pharmacyTileLinkId")
	protected WebElement checkDelieryStatusButton;
	
	@FindBy(xpath ="//p[contains(text(),'View your prescription drug spending to date')]")
	protected WebElement drugCostSummaryButton;
	
	@FindBy(xpath = "//h1")
	protected WebElement BenefitsInformationHeaderOptumRx;
	
	@FindBy(xpath = "//h1")
	protected WebElement searchForADrugHeaderOptumRx;
	
	@FindBy(id ="page_title")
	protected WebElement welcometextinheaderOptumRx;
	
	@FindBy(id ="page_title")
	protected WebElement orderStatusTextInHeaderOptumRx;
	
	
	public PharmaciesAndPrescriptionsWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}
	
	// F436319
	@FindBy(xpath = "//div[@data-testid='global-alert-banner']")
	protected WebElement PnPNotification;

	@FindBy(xpath = "//div[@data-testid='global-alert-banner']//div//div//button[@data-testid='global-alert-banner-close-button']//span[1]")
	protected WebElement PnPNotificationCloseBtn;

	@FindBy(xpath = "//span[@data-test-component='text']//span")
	protected WebElement PnPNotificationPosition;

	@FindBy(xpath = "//*[@data-testid='price-drugs-CTA-external-icon']")
	protected WebElement FindAndPriceExternalIcon;

	@FindBy(xpath = "//h1[text()='What medication can we help you find?']")
	protected WebElement DrugEstimatorToolPageHeader;

	@FindBy(xpath = "//*[@data-testid='order-prescription-CTA-external-icon']")
	protected WebElement OrderPrescriptionExternalIcon;

	@FindBy(xpath = "//*[@data-testid='medication-cost-summary-CTA-external-icon']")
	protected WebElement MedicationCostSummaryExternalIcon;

	// Drug Lookup Call to Action
	@FindBy(xpath = "//div[@data-testid='price-drugs-CTA']")
	protected WebElement DrugLookupCallToActnBtn;

	@FindBy(xpath = "//div[@data-testid='price-drugs-CTA']")
	protected WebElement FindAndPriceCallToActnBtn;

	@FindBy(xpath = "//div[@data-testid='price-drugs-CTA-icon']")
	protected WebElement DrugLookupCTAImg;

	@FindBy(xpath = "//div[@data-testid='price-drugs-CTA-icon']")
	protected WebElement FindAndPriceCTAImg;

	@FindBy(xpath = "//h2[@data-testid='price-drugs-CTA-title']")
	protected WebElement DrugLookupCTATitle;

	@FindBy(xpath = "//h2[@data-testid='price-drugs-CTA-title']")
	protected WebElement FindAndPriceCTATitle;

	@FindBy(xpath = "//p[@data-testid='price-drugs-CTA-description']")
	protected WebElement DrugLookupCTADescription;

	@FindBy(xpath = "//p[@data-testid='price-drugs-CTA-description']")
	protected WebElement FindAndPriceCTADescription;

	// Pharmacy Locator

	@FindBy(xpath = "//div[@data-testid='find-pharmacy-CTA']")
	protected WebElement PharmacyLocatorCallToActnBtn;

	@FindBy(xpath = "//div[@data-testid='find-pharmacy-CTA-icon']")
	protected WebElement PharmacyLocatorCTAImg;

	@FindBy(xpath = "//h2[@data-testid='find-pharmacy-CTA-title']")
	protected WebElement PharmacyLocatorCTATitle;

	@FindBy(xpath = "//p[@data-testid='find-pharmacy-CTA-description']")
	protected WebElement PharmacyLocatorCTADescription;

	// Order Prescription
	@FindBy(xpath = "//div[@data-testid='order-prescription-CTA']")
	protected WebElement OrderPrescriptionCallToActnBtn;

	@FindBy(xpath = "//div[@data-testid='order-prescription-CTA-icon']")
	protected WebElement OrderPrescriptionCTAImg;

	@FindBy(xpath = "//h2[@data-testid='order-prescription-CTA-title']")
	protected WebElement OrderPrescriptionCTATitle;

	@FindBy(xpath = "//p[@data-testid='order-prescription-CTA-description']")
	protected WebElement OrderPrescriptionCTADescription;

	// Drug Cost Summary
	@FindBy(xpath = "//div[@data-testid='medication-cost-summary-CTA']")
	protected WebElement DrugCostSummaryCallToActnBtn;

	@FindBy(xpath = "//div[@data-testid='medication-cost-summary-CTA-icon']")
	protected WebElement DrugCostSummaryCTAImg;

	@FindBy(xpath = "//h2[@data-testid='medication-cost-summary-CTA-title']")
	protected WebElement DrugCostSummaryCTATitle;

	@FindBy(xpath = "//p[@data-testid='medication-cost-summary-CTA-description']")
	protected WebElement DrugCostSummaryCTADescription;

	@FindBy(xpath = "//div[@data-testid='anoc-CTA']")
	protected WebElement ANOCCallToActnBtn;

	@FindBy(xpath = "//h2[text()='Prepare for Next Year']")
	protected WebElement ANOCPageHeader;

	@FindBy(xpath = "")
	protected WebElement OptumRxDrugPricePageHeader;

	@FindBy(xpath = "//div[text()='Choose a plan year to find in-network pharmacies.']")
	protected WebElement HeaderOnChoosePlanYearPage;

	@FindBy(xpath = "(//button/span[text()='Go back to previous page'])[1]")
	protected WebElement BackButtonOnChoosePlanYearPage;

	@FindBy(xpath = "(//main/div/div/div[1]/div/div/div[1]/div/div[4]/text()")
	protected WebElement DescriptiveContentOnChoosePlanYearPage;

	@FindBy(xpath = "//button[@data-testid='pharmacy-locator-2020-CTA-button']")
	protected WebElement PharmacyLocator2020CTA;

	@FindBy(xpath = "//button[@data-testid='pharmacy-locator-2021-CTA-button']")
	protected WebElement PharmacyLocator2021CTA;

	@FindBy(xpath = "//h2[text()='Common Questions']")
	protected WebElement FAQSectionOnChoosePlanYearPage;

	@FindBy(xpath = "//h2[text()='Need Help?  ']")
	protected WebElement NeedHelpSectionOnChoosePlanYearPage;

	@FindBy(xpath = "//button[text()='MORE INFORMATION']")
	protected WebElement MoreInformationSectionOnChoosePlanYearPage;

	@FindBy(xpath = "//div[2]/footer")
	protected WebElement GlobalFooterSectionOnChoosePlanYearPage;

	@FindBy(xpath = "//*[@data-testid='pharmacy-locator-2020-CTA-external-icon']")
	protected WebElement PharmacyLocator2020CTAExternalIcon;

	@FindBy(xpath = "//button[@data-component='BackButton']")
	protected WebElement BackButtonOnPharmacyLocatorPageByRally;

	@FindBy(xpath = "//h2[text()='Results for ']")
	protected WebElement HeaderOnPharmacyLocatorPageByRally;

	@FindBy(id = "pharmacylocatorheader_id")
	protected WebElement HeaderLegacyPharmacyLocatorPage;

	@FindBy(xpath = "")
	protected WebElement OptumRxMedicineCabinetHeader;

	@FindBy(xpath = "//h1[@id='page_title' and contains(text(),'My Prescriptions')]]")
	protected WebElement OptumRxManagePrescriptionHeader;

	@FindBy(xpath = "//h1[@id='page_title' and contains(text(),'Benefits Information')]")
	protected WebElement OptumRxBenefitsInformationHeader;

}