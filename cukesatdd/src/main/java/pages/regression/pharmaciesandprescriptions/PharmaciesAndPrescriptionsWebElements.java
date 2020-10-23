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
	
	@FindBy(xpath = "//div[@data-testid='price-drugs-CTA']")
	protected WebElement FindAndPriceCallToActnBtn;
	
	//note: pre-eff 
	@FindBy(xpath="//div/p[contains(@class,'date')]")
	protected WebElement planStartDate;
	
	@FindBy(xpath="//div[@class='plan-links']//div[@class='links-section'][1]//div[contains(@class,'pre-pharmacies')]//p")
	protected WebElement drugCostLnk;

	@FindBy(xpath="//div[@class='plan-links']//div[@class='links-section'][1]//div[contains(@class,'pre-pharmacies')]//img")
	protected WebElement drugCostImg;

	@FindBy(xpath="//div[@class='plan-links']//div[@class='links-section'][2]//div[contains(@class,'pre-pharmacies')]//p")
	protected WebElement pharmacyLocatorLnk;

	@FindBy(xpath="//div[@class='plan-links']//div[@class='links-section'][2]//div[contains(@class,'pre-pharmacies')]//img")
	protected WebElement pharmacyLocatorImg;

	@FindBy(xpath="//div[@class='plan-links']//div[@class='links-section'][3]//div[contains(@class,'pre-pharmacies')]//p")
	protected WebElement memDocLnk;

	@FindBy(xpath="//div[@class='plan-links']//div[@class='links-section'][3]//div[contains(@class,'pre-pharmacies')]//img")
	protected WebElement memDocImg;

	@FindBy(xpath="//h1[contains(@class,'h1') or contains(@class,'heading')]")
	protected WebElement dceHeader;
	
	@FindBy(xpath="//h1[contains(text(),'Pharmacy')]")
	protected WebElement phaLocHeader;
	  
	@FindBy(xpath="//h1[contains(@class,'heading')]")
	protected WebElement memDocHeader;

	@FindBy(xpath="//div[@class='important-note-section']//a[contains(text(),'Contact us')]")
	protected WebElement contactUsLnk;
	
	@FindBy(xpath="//h3[contains(text(),'Technical Support')]")
	protected WebElement contactUsTechSupp;
	
	@FindBy(xpath="//button[contains(text(),'Exit')]")
	protected WebElement acqPopupExit;
	
	@FindBy(xpath="//div[@class='important-note-section']//h3[contains(text(),'Important Note')]")
	protected WebElement impNoteSecHead;

	@FindBy(xpath="//div[@class='important-note-section']//p[contains(text(),'Be sure')]")
	protected WebElement impNoteSecTxt;

	@FindBy(xpath="//div[@class='important-note-section']//img")
	protected WebElement impNoteSecImg;

	@FindBy(xpath="//div[@class='footer-information']//h3[contains(text(),'Come back soon')]")
	protected WebElement comBckSecHead;

	@FindBy(xpath="//div[@class='footer-information']//p[contains(text(),'You can save money')]")
	protected WebElement comBckSecTxt;

	@FindBy(xpath="//div[@class='footer-information']//img")
	protected WebElement comBckSecImg;

	@FindBy(xpath="//div[@class='footer-information']//div[contains(@class,'medicinecabinet')]//h3[contains(text(),'Your medicine cabinet')]")
	protected WebElement medCabSecHead;

	@FindBy(xpath="//div[@class='footer-information']//div[contains(@class,'medicinecabinet')]//p[contains(text(),'You can view a list')]")
	protected WebElement medCabSecTxt;

	@FindBy(xpath="//div[@class='footer-information']//div[contains(@class,'find_price')]//h3[contains(text(),'Find and price a medication')]")
	protected WebElement priMedSecHead;

	@FindBy(xpath="//div[@class='footer-information']//div[contains(@class,'find_price')]//p[contains(text(),'You can price')]")
	protected WebElement priMedSecTxt;

	@FindBy(xpath="//div[@class='footer-information']//div[contains(@class,'home_delivery')]//h3[contains(text(),'Home delivery management')]")
	protected WebElement delivMgmtSecHead;

	@FindBy(xpath="//div[@class='footer-information']//div[contains(@class,'home_delivery')]//p[contains(text(),'You can manage your')]")
	protected WebElement delivMgmtSecTxt;

	@FindBy(xpath="//div[@class='footer-information']//div[contains(@class,'find_pharmacy')]//h3[contains(text(),'Find a pharmacy near you')]")
	protected WebElement findPharSecHead;

	@FindBy(xpath="//div[@class='footer-information']//div[contains(@class,'find_pharmacy')]//p[contains(text(),'You will be able to search')]")
	protected WebElement findPharSecTxt;
	
	@FindBy(xpath="//h1[contains(text(),'Get the most')]")
	protected WebElement pnpHeader_preeff;
	
	public PharmaciesAndPrescriptionsWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}

}
