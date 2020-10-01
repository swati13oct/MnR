package pages.regression.pharmaciesandprescriptions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Functionality : WebElements for Pharmacies & Prescriptions page
 */
public class PharmaciesAndPrescriptionsWebElements extends UhcDriver {

	// note: need help section
	@FindBy(xpath = "//h2[contains(@class,'atdd-need-help')]")
	protected WebElement needHelp_SectionHeader;

	// note: need help - technical section
	@FindBy(xpath = "//div[contains(@class,'technical section')]")
	protected WebElement needHelp_TechicalSupportSection;

	@FindBy(xpath = "//div[contains(@class,'technical section')]//p[1]//img")
	protected WebElement needHelp_TechicalSupport_img;

	@FindBy(xpath = "//div[contains(@class,'technical section')]/div/div/p[1]")
	protected WebElement needHelp_TechicalSupport_phone;

	@FindBy(xpath = "//div[contains(@class,'technical section')]//p[2]")
	protected WebElement needHelp_TechicalSupport_tty;

	@FindBy(xpath = "//div[contains(@class,'technical section')]//p[3]")
	protected WebElement needHelp_TechicalSupport_wkDayHrs;

	@FindBy(xpath = "//div[contains(@class,'technical section')]//p[4]")
	protected WebElement needHelp_TechicalSupport_wkEndHrs;

	// note: need help - general section
	@FindBy(xpath = "//div[contains(@class,'general section')]")
	protected WebElement needHelp_GeneralQuestionsSection;

	@FindBy(xpath = "//div[contains(@class,'general section')]//p[1]//img")
	protected WebElement needHelp_GeneralQuestions_img;

	@FindBy(xpath = "//div[contains(@class,'general section')]/div/div/p[1]")
	protected WebElement needHelp_GeneralQuestions_phone;

	@FindBy(xpath = "//div[contains(@class,'general section')]//p[2]")
	protected WebElement needHelp_GeneralQuestions_tty;

	@FindBy(xpath = "//div[contains(@class,'general section')]//p[3]")
	protected WebElement needHelp_GeneralQuestions_wkDayHrs;

	@FindBy(xpath = "//div[contains(@class,'general section')]//p[4]")
	protected WebElement needHelp_GeneralQuestions_wkEndHrs;

	// note: need help - claims section
	@FindBy(xpath = "//div[contains(@class,'claims section')]")
	protected WebElement needHelp_ClaimsSupportSection;

	@FindBy(xpath = "//div[contains(@class,'claims section')]//p[1]//img")
	protected WebElement needHelp_ClaimsSupport_img;

	@FindBy(xpath = "//div[contains(@class,'claims section')]/div/div/div/p[1]")
	protected WebElement needHelp_ClaimsSupport_phone;

	@FindBy(xpath = "//div[contains(@class,'claims section')]//p[2]")
	protected WebElement needHelp_ClaimsSupport_tty;

	@FindBy(xpath = "//div[contains(@class,'claims section')]//p[3]")
	protected WebElement needHelp_ClaimsSupport_wkDayHrs;

	@FindBy(xpath = "//div[contains(@class,'claims section')]//p[4]")
	protected WebElement needHelp_ClaimsSupport_wkEndHrs;

	// note: need help - plan support
	@FindBy(xpath = "//div[contains(@class,'plan section')]")
	protected WebElement needHelp_PlanSupportSection;

	@FindBy(xpath = "//div[contains(@class,'plan section')]//p[1]//img")
	protected WebElement needHelp_PlanSupport_img;

	@FindBy(xpath = "//div[contains(@class,'plan section')]/div/div/p[1]")
	protected WebElement needHelp_PlanSupport_phone;

	@FindBy(xpath = "//div[contains(@class,'plan section')]//p[2]")
	protected WebElement needHelp_PlanSupport_tty;

	@FindBy(xpath = "//div[contains(@class,'plan section')]//p[3]")
	protected WebElement needHelp_PlanSupport_wkDayHrs;

	// note: need help - more ways
	@FindBy(xpath = "//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	protected WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath = "//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	protected WebElement needHelp_contactUsLink;

	@FindBy(xpath = "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]")
	protected WebElement comboTab_MAPD;

	@FindBy(xpath = "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]")
	protected WebElement comboTab_SHIP;

	@FindBy(xpath = "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan') and not(contains(.,'Med'))]")
	protected WebElement comboTab_PDP;

	@FindBy(xpath = "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]")
	protected WebElement comboTab_SSUP;

	@FindBy(xpath = "//h1[contains(text(),'Pharmacies & Prescriptions for')]")
	protected WebElement pgHeader;

	@FindBy(xpath = "//div[@class='pharmaciesText']")
	protected WebElement pharmaciesText;

	// note: Compare drug pricing
	@FindBy(xpath = "//div[(contains(@class,'DRUGPRICINGTILE') or contains(@class,'DRUG_PRICING_TILE_Group'))and not(contains(@class,'ng-hide'))]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_compDrugPricingHeaderTxt;

	@FindBy(xpath = "//div[(contains(@class,'DRUGPRICINGTILE') or contains(@class,'DRUG_PRICING_TILE_Group'))and not(contains(@class,'ng-hide'))]//img")
	protected WebElement pTile_compDrugPricingImg;

	@FindBy(xpath = "//div[(contains(@class,'DRUGPRICINGTILE') or contains(@class,'DRUG_PRICING_TILE_Group'))and not(contains(@class,'ng-hide'))]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_compDrugPricingLnk;

	// note: Find a network pharmacy
	@FindBy(xpath = "//div[contains(@id,'idName2')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_findNtkPharmacyHeaderTxt;

	@FindBy(xpath = "//div[contains(@id,'idName2')]//img")
	protected WebElement pTile_findNtkPharmacyImg;

	@FindBy(xpath = "//div[contains(@id,'idName2')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_findNtkPharmacyLnk;

	// note: Order prescription refills
	@FindBy(xpath = "//div[contains(@class,'MEDICINE_CABINET_TILE')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_orderPresRefillsHeaderTxt;

	@FindBy(xpath = "//div[contains(@class,'MEDICINE_CABINET_TILE')]//img")
	protected WebElement pTile_orderPresRefillsImg;

	@FindBy(xpath = "//div[contains(@class,'MEDICINE_CABINET_TILE')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_orderPresRefillsLnk;

	// note: Check home delivery order status
	@FindBy(xpath = "//div[contains(@class,'ORDER_STATUS_TILE')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_chkHomeDeliOrderStatusHeaderTxt;

	@FindBy(xpath = "//div[contains(@class,'ORDER_STATUS_TILE')]//img")
	protected WebElement pTile_chkHomeDeliOrderStatusImg;

	@FindBy(xpath = "//div[contains(@class,'ORDER_STATUS_TILE')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_chkHomeDeliOrderStatusLnk;

	// note: Prescription Benefits Information
	@FindBy(xpath = "//div[contains(@class,'BENEFITS_INFORMATION')]//div[@class='pharmaciesTileHead']")
	protected WebElement pTile_presBenfitInfoHeaderTxt;

	@FindBy(xpath = "//div[contains(@class,'BENEFITS_INFORMATION')]//img")
	protected WebElement pTile_presBenfitInfoImg;

	@FindBy(xpath = "//div[contains(@class,'BENEFITS_INFORMATION')]//div[@class='pharmacyTileLink']")
	protected WebElement pTile_presBenfitInfoLnk;

	@FindBy(xpath = "//div[contains(@class,'planmaterials')]//img")
	protected WebElement viewPlanMaterialsImg;

	@FindBy(xpath = "//div[contains(@class,'planmaterials')]//a")
	protected WebElement viewPlanMaterialsLnk;

	// @FindBy(css = ".DRUG_PRICING_TILE_Group #pharmacyTileLinkId")
	@FindBy(xpath = "//p[contains(text(),'Find out if your drugs are covered, estimate costs')]")
	protected WebElement LookUpDrugsButton;

	// @FindBy(css = ".MEDICINE_CABINET_TILE #pharmacyTileLinkId")
	@FindBy(xpath = "//p[contains(text(),'Refill your prescriptions with home delivery')]")
	protected WebElement orderPrescriptionsButton;

	@FindBy(css = ".ORDER_STATUS_TILE #pharmacyTileLinkId")
	protected WebElement checkDelieryStatusButton;

	// @FindBy(css = ".BENEFITS_INFORMATION #pharmacyTileLinkId")
	@FindBy(xpath = "//p[contains(text(),'View your prescription drug spending to date')]")
	protected WebElement drugCostSummaryButton;

	// @FindBy(id = "page_title")
	@FindBy(xpath = "//h1")
	protected WebElement BenefitsInformationHeaderOptumRx;

	// @FindBy(id = "page_title")
	@FindBy(xpath = "//h1")
	protected WebElement searchForADrugHeaderOptumRx;

	@FindBy(id = "page_title")
	protected WebElement welcometextinheaderOptumRx;

	@FindBy(id = "page_title")
	protected WebElement orderStatusTextInHeaderOptumRx;

	public PharmaciesAndPrescriptionsWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	@FindBy(xpath = "(//*[@id='FindAndPriceADrug_svg__a']/.)[1]")
	protected WebElement findPrescriotionImage;

	@FindBy(xpath = "//h2[@data-testid='price-drugs-CTA-title' and contains(text(),'Find and Price a Medication')]")
	protected WebElement findPrescriptionTitle;

	@FindBy(xpath = "//a[@data-testid='medication-action-learn-more']")
	protected List<WebElement> sixMedications;

	@FindBy(xpath = "//a[contains(text(),'LEARN MORE')]")
	protected List<WebElement> tenMedications;

	@FindBy(xpath = "//p[@data-testid='price-drugs-CTA-description' and contains(text(),'Find out if your drugs are covered, estimate costs and ways to help save money.')]")
	protected WebElement findPrescriptionDesc;

	@FindBy(xpath = "//*[@id='PharmacyLocator_svg__a']")
	protected WebElement pharmacyLocatorImage;

	@FindBy(xpath = "//h2[@data-testid='find-pharmacy-CTA-title' and contains(text(),'Pharmacy Locator')]")
	protected WebElement pharmacyLocatorTitle;

	@FindBy(xpath = "//p[@data-testid='find-pharmacy-CTA-description' and contains(text(),'Find a network pharmacy near you.')]")
	protected WebElement pharmacyLocatorDesc;

	@FindBy(xpath = "//*[@id='CheckOrderStatus_svg__a']")
	protected WebElement managePresciptionImage;

	@FindBy(xpath = "//h2[@data-testid='order-prescription-CTA-title' and contains(text(),'Order')]//span[contains(text(),'Prescriptions')]")
	protected WebElement managePrescriptionTitle;

	@FindBy(xpath = "//p[@data-testid='order-prescription-CTA-description' and contains(text(),'Refill your prescriptions with home delivery')]")
	protected WebElement managePrescriptionDesc;

	@FindBy(xpath = "//p[contains(text(),'Check')]/ancestor::button//div[@class='sc-LzLMh enfnLm']/*")
	protected WebElement whatsNewImage;

	@FindBy(xpath = "//h2[contains(text(),'Whats')]")
	protected WebElement whatsNewTitle;

	@FindBy(xpath = "//p[contains(text(),'Check Out')]")
	protected WebElement whatsNewDesc;

	// Call to Action Buttons

	@FindBy(xpath = "(//h2[contains(text(),'Find')]/ancestor::button)[1]")
	protected WebElement findPrescriptionsCallToActnBtn;

	@FindBy(xpath = "//h2[contains(text(),'Pharmacy')]/ancestor::button")
	protected WebElement pharmacyLocatorCallToActnBtn;

	@FindBy(xpath = "//h2[contains(text(),'Manage')]/ancestor::button")
	protected WebElement managePrescriptionCallToActnBtn;

	@FindBy(xpath = "//h2[contains(text(),'Whats')]/ancestor::button")
	protected WebElement whatsNewCallToActnBtn;

	@FindBy(xpath = "//h1[@class='sc-LzLrZ faEGzK']")
	protected WebElement whatsNewPageHeader;

	@FindBy(xpath = "//h1[text()='My Prescriptions']")
	protected WebElement OptumRxMyPrescriptionHeader;

	@FindBy(xpath = "")
	protected WebElement PharmacyLocatorToolHeader;

	@FindBy(xpath = "//h1[text()='Order status']")
	protected WebElement OptumRxOrderStatusHeader;

	// Medicine Cabinet
	@FindBy(xpath = "//*[@data-testid='medcab-title']")
	protected WebElement CurrentMedicationsHeader;

	@FindBy(xpath = "//div[@class='sc-LzLtN ijGRvz']")
	protected List<WebElement> SixMedications;

	@FindBy(xpath = "//span[@data-test-component='text']")
	protected List<WebElement> AssociatedCallToAction;

	@FindBy(xpath = "//div[@data-testid='medication-status-percent-50']")
	protected List<WebElement> halfHarveyBall;

	@FindBy(xpath = "//div[@data-testid='medication-status-percent-0']")
	protected WebElement emptyHarveyBall;

	@FindBy(xpath = "//h1[contains(text(),'Order Status')]")
	protected WebElement orderStatusPageHeader;

	//@FindBy(xpath = "//*[contains(text(),'My Med')]/..//a[@data-testid='view-all-meds-CTA']")
	
	@FindBy(xpath = "//a[@data-testid='view-all-meds-CTA' and contains(text(),'View All Medications')]")
	protected WebElement ViewAllMedications;

	@FindBy(xpath = "//span[contains(text(),'Remove Item from Order')]")
	protected WebElement removeItemFromOrderLink;

	@FindBy(xpath = "//a[@data-testid='refill-all-meds']")
	protected List<WebElement> refillAllMedications;

	@FindBy(id = "shipping-method-select-element")
	protected WebElement standarShipping;

	@FindBy(xpath = "//li[contains(text(),'Two-day Shipping - $6.00')]")
	protected WebElement twoDayShipping;

	@FindBy(xpath = "//li[contains(text(),'Expedited Shipping - $12.50')]")
	protected WebElement expeditedShipping;

	@FindBy(id = "shipping-method-select-element")
	protected WebElement selectShippingMethod;

	@FindBy(xpath = "//*[contains(@data-testid,'refill-all-message')]")
	protected WebElement refillAllMedicationsExplanation;

	@FindBy(xpath = "//span[@data-test-total-medications='9']")
	protected WebElement totalMedicationsInCurrenMedications;

	//

	@FindBy(xpath = "//h1[contains(text(),'My Medications')]")
	protected WebElement MyMedicationsPageHeader;

	// identical class

	@FindBy(xpath = "//div[@class='sc-LzLtN ijGRvz']")
	protected WebElement MedicationName;

	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div/div[2]/div/div[2]/div/div[1]/div[1]/img")
	protected WebElement Image;

	@FindBy(xpath = "//a[contains(text(),'mg')]")
	protected WebElement Strength;

	@FindBy(xpath = "//div[@class='sc-LzLtQ ikghia']")
	protected WebElement PriceMemberPaid;

	@FindBy(xpath = "//div[@class='sc-LzLtN ijGRvz']")
	protected WebElement PharmacyLastFilled;

	@FindBy(xpath = "//div[@class='sc-LzLtP ijXKDR']")
	protected WebElement DayOfSupply;

	@FindBy(xpath = "")
	protected WebElement OrderStatus;

	@FindBy(xpath = "")
	protected WebElement RelevantCallToAction;

	@FindBy(xpath = "")
	protected WebElement InfoOnRemainingRefills;

	@FindBy(xpath = "")
	protected WebElement PhoneNumber;

	@FindBy(xpath = "//span[contains(text(),'Track Status')]")
	protected List<WebElement> trackStatusButton;

	@FindBy(xpath = "//span[contains(text(),'delivered')]")
	protected List<WebElement> delivered;

	@FindBy(xpath = "//span[contains(text(),'VIEW ORDER')]")
	protected List<WebElement> viewOrder;

	@FindBy(xpath = "//button[contains(@data-testid,'medication-action-contact-pharmacy')]")
	protected List<WebElement> contactPharmacyBtn;


	@FindBy(xpath = "//span[contains(text(),'Overview')]")
	protected WebElement Overview;

	@FindBy(xpath = "//h4[@data-testid='section__header']")
	protected WebElement NumberInParenthesis;

	@FindBy(xpath = "//h2[@data-testid='section__header']")
	protected List<WebElement> NumberInParenthesisRefillAll;

	@FindBy(xpath = "//p[contains(text(),'1-800-721-0627')]")
	protected WebElement technicalSupportNumber;

	@FindBy(xpath = "//p[contains(text(),'1-844-876-6177')]")
	protected WebElement planSupportNumber;

	@FindBy(xpath = "//*[@id='needhelpsectioncontactus']/div/section/div/div[2]/div/div/div[1]/div/div/p[3]")
	protected WebElement planSupportHours;

	@FindBy(xpath = "//*[@id='needhelpsectioncontactus']/div/section/div/div[2]/div/div/div[2]/div/div/p[3]")
	protected WebElement technicalSupportHours;

	@FindBy(xpath = "//div[contains(text(),'Medication appearance subject to change')]")
	protected List<WebElement> Disclaimer;

	@FindBy(xpath = "//span[contains(text(),'Request received')]")
	protected List<WebElement> RequestReceived;

	@FindBy(xpath = "//div[contains(text(),'OptumRx')]")
	protected List<WebElement> optumRx;

	@FindBy(xpath = "//span[@tabindex='-1']")
	protected WebElement totalMedicationsInMyMed;

	@FindBy(xpath = "//span[contains(text(),'processing')]")
	protected List<WebElement> Processing;

	@FindBy(xpath = "//h1[contains(text(),'Transfer to Home Delivery')]")
	protected WebElement transferToHDHeader;

	@FindBy(xpath = "//span[contains(text(),'request received')]")
	protected List<WebElement> requestReceived;

	@FindBy(xpath = "//span[contains(text(),'request placed')]")
	protected List<WebElement> requestPlaced;

	@FindBy(xpath = "//span[contains(text(),'Your order is in the pharmacy processing')]")
	protected WebElement  processingMessage;

	@FindBy(xpath = "//div[contains(text(),'Estimated Delivery Date: Pending')]")
	protected WebElement requestPlacedPending;

	@FindBy(xpath = "//span[contains(text(),'-')]")
	protected List<WebElement> requestPlacedNoOrderNumber;

	@FindBy(xpath = "//span[contains(text(),'order received')]")
	protected List<WebElement> orderReceived;

	@FindBy(xpath = "//div[@data-testid='medication-status-percent-50']")
	protected WebElement isHalfHarveyBall;

	@FindBy(xpath = "//div[@data-testid='medication-status-percent-25']")
	protected List<WebElement> oneFourthHarveyBall;

	@FindBy(xpath = "//span[contains(text(),'Refill')]")
	protected WebElement RefillMedications;

	@FindBy(xpath = "//span[contains(text(),'Renew')]")
	protected WebElement RenewMedications;

	// ************************Added By
	// Naresh***********************************************************

	/*
	 * @FindBy(xpath = "//a[@class='sc-fzXfNk coqaOW sc-LzLut ivhIFO']") protected
	 * List<WebElement> listOfDrugName;
	 */
	@FindBy(xpath = "//a[@data-testid='medication-data-name']")
	protected List<WebElement> listOfDrugName;

	@FindBy(xpath = "//a[@data-testid='medication-data-name']/span")
	protected List<WebElement> listOfDrugNameText;

	@FindBy(xpath = "//img[@data-testid='medication-data-image']")
	protected List<WebElement> listOfDrugImage;

	@FindBy(xpath = "//a[@data-testid='medication-data-name']/..//span")
	protected List<WebElement> listOfMedicineStrength;

	@FindBy(xpath = "//div[@data-testid='medication-data-refills-left']")
	protected List<WebElement> listOfRefillsLeft;

	@FindBy(xpath = "//div[@data-testid='medication-data-day-supply']")
	protected List<WebElement> listOfDaysSupply;

	@FindBy(xpath = "//div[@data-testid='medication-data-you-paid']")
	protected List<WebElement> listOfYouPaid;

	@FindBy(xpath = "//div[@data-testid='medication-data-pharmacy-name']")
	protected List<WebElement> listOfPharmacyName;

	@FindBy(xpath = "//span[@data-testid='medication-data-order-status']")
	protected List<WebElement> listOfOrderStatus;

	@FindBy(xpath = "//span[@data-testid='medication-data-order-status']/span")
	protected List<WebElement> listOfOrderStatusText;

	// a[contains(@data-testid,'medication-action') and
	// not(contains(@data-testid,'learn-more'))]//button
	@FindBy(xpath = "//button[@class='sc-fzXfMB bzINfC sc-LzLvg iyuslm']//span[@class='sc-fzXfMC lesaNV' and not(text()='LEARN MORE')]")
	protected List<WebElement> listOfCallToActionOnMedication;

	//// button[@data-testid='medication-action-track' or
	//// @data-testid='medication-action-contact-pharmacy']
	//// button[@class='sc-fzXfMB bzINfC sc-LzLvg iyuslm']//span[@class='sc-fzXfMC
	//// lesaNV' and not(text()='LEARN MORE')]/ancestor::button
	// button[@aria-label='Track prescription status' or
	//// @data-testid='medication-action-contact-pharmacy']
	// button[@data-testid='medication-action-track' or
	//// @data-testid='medication-action-contact-pharmacy']
	// button[contains(@data-testid,'medication-action')]
	// button[@aria-label='Track prescription status' or
	//// @data-testid='medication-action-contact-pharmacy' or
	//// @data-testid='medication-action-resolve-hold']
	@FindBy(xpath = "//button[contains(@data-testid,'medication-action')]/span[1]")
	protected List<WebElement> listOfCallToActionOnMedicationBtn;

	@FindBy(xpath = "//button[contains(@data-testid,'medication-action')]")
	protected List<WebElement> listOfCallToActionOnMedicationButton;

	@FindBy(xpath = "//button[@aria-label='Track prescription status']")
	protected List<WebElement> listOfCallToActionForHDDrug;

	@FindBy(xpath = "//button[@data-testid='medication-action-contact-pharmacy']")
	protected List<WebElement> listOfCallToActionForRetailDrug;

	@FindBy(xpath = "//a[contains(@data-testid,'medication-action') and not(contains(@data-testid,'get-pricing'))]//button")
	protected List<WebElement> listOfTrackCallToAction;

	@FindBy(xpath = "//button[@data-testid='medication-action-resolve-hold']")
	protected List<WebElement> listForResolveHoldCallToActn;

	@FindBy(xpath = "//p[@data-testid='pharmacy-phone-number']")
	protected WebElement contactPharmacyNumber;

	@FindBy(xpath = "//div[contains(@data-testid,'medication-status-percent')]")
	protected List<WebElement> listOfHarveyBall;

	@FindBy(xpath = "//span[text()='Loading&ellipsis;']")
	protected WebElement loading;

	@FindBy(xpath = "//h2[@data-test-component='title' and text()='Contact Pharmacy']")
	protected WebElement contactPharmacyPopUp;

	@FindBy(xpath = "//*[contains(@data-testid,'medication-action') and not(contains(@data-testid,'learn-more'))]/span[1]")
	protected List<WebElement> listOfCallToActnForActiveMedication;

	@FindBy(xpath = "//*[contains(@data-testid,'medication-action') and not(contains(@data-testid,'get-pricing'))]")
	protected List<WebElement> listOfCTAWithoutSpanTag;

	public List<String> getDrugNameListValue() {
		List<String> listOfDrug = new ArrayList<>();
		for (WebElement ele : listOfDrugName) {
			listOfDrug.add(ele.getText());
		}
		return listOfDrug;
	}

	public boolean validateFieldValueContent(List<WebElement> listOfWebElement) {
		for (WebElement ele : listOfWebElement) {
			if (ele.getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public boolean validateMedicineStrengthFieldValue() {
		for (WebElement ele : listOfMedicineStrength) {
			if (ele.getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public List<Integer> getListOfIndexForRetailPharmacy() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfPharmacyName.size(); i++) {
			if (!listOfPharmacyName.get(i).getText().equals("OptumRx")) {
				listOfIndex.add(i);
			}
		}
		return listOfIndex;
	}

	public List<Integer> getListOfIndexForHDPharmacy() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfPharmacyName.size(); i++) {
			if (listOfPharmacyName.get(i).getText().equals("OptumRx")) {
				listOfIndex.add(i);
			}
		}
		return listOfIndex;
	}

	List<String> listOfCallToActionForHDMedicine;

	public boolean validateCallToActionsForHDDrug() {
		List<Integer> listOfIndex = getListOfIndexForHDPharmacy();
		for (Integer val : listOfIndex) {
			if (!listOfCallToActionForHDMedicine.contains(listOfCallToActionOnMedication.get(val).getText())) {
				return false;
			}
		}
		return true;
	}

	public boolean validateContactPharmacyButtonForRetailDrug(String expectedButtonValue) {
		List<Integer> listOfIndex = getListOfIndexForRetailPharmacy();
		for (Integer val : listOfIndex) {
			if (!(listOfCallToActionOnMedication.get(val).getText().equals(expectedButtonValue)
					&& listOfCallToActionOnMedication.get(val).getTagName().equals("button"))) {
				return false;
			}
		}
		return true;
	}

	public void clickOnContactPharmacy() {
		List<Integer> listOfIndex = getListOfIndexForRetailPharmacy();
		Random rand = new Random();
		int rand_int = rand.nextInt(listOfIndex.size());
		listOfCallToActionOnMedication.get(listOfIndex.get(rand_int));
	}

	// Need to add the Regex for Number
	public boolean validateContactPharmacyPopUpHavingNumber() {
		String contactNumber = contactPharmacyNumber.getText();
		return !contactNumber.isEmpty() && contactNumber.matches("");
	}

	@FindBy(xpath = "")
	protected List<WebElement> listOfExtrnalLinkOnHold;

	// ********************* Kiran ************************
	@FindBy(xpath = "//h1[@class='sc-LzLtS ikxaqs']") // ask for DataTestId attribute
	protected WebElement MedicationName_OnDrugInfoPage;

	@FindBy(xpath = "//a[@data-testid='pagination-next']")
	protected WebElement nextPageArrow;

	@FindBy(xpath = "//div[contains(text(),'My Medications (')]")
	protected WebElement myMedicationsHeader;

	@FindBy(xpath = "//h1[contains(text(),'Pharmacy Overview')]")
	protected WebElement pharmacyOverview;

	@FindBy(xpath = "//a[@data-testid='medication-action-learn-more']")
	protected List<WebElement> listOfLearnMore;

	@FindBy(xpath = "//a[@data-testid='medication-action-get-pricing']")
	protected List<WebElement> listOfGetPricing;

	@FindBy(xpath = "")
	protected List<WebElement> listOfHDMedication;// need to update by Kiran

	@FindBy(xpath = "//a[@data-testid='medication-action-refill']")
	protected List<WebElement> listOfRefillMedication;

	@FindBy(xpath = "//a[@data-testid='medication-action-renew']")
	protected List<WebElement> listOfRenewMedication;

	@FindBy(xpath = "//*[contains(text(),'request placed')]")
	protected List<WebElement> listOfRequestPlaced;

	@FindBy(xpath = "//*[contains(text(),'order received')]")
	protected List<WebElement> listOfOrderReceived;

	@FindBy(xpath = "//*[contains(text(),'processing')]")
	protected List<WebElement> listOfProcessing;

	@FindBy(xpath = "//button[@data-testid='medication-action-resolve-hold']")
	protected List<WebElement> listOfResolveHold;

	@FindBy(xpath = "//*[@data-testid='medication-action-track']")
	protected List<WebElement> listOfTrackStatus;

	@FindBy(xpath = "//button[@data-testid='medication-action-view-order']")
	protected List<WebElement> listOfViewOrder;

	@FindBy(xpath = "//a[@data-testid='medication-action-view-order-cancelled']")
	protected List<WebElement> listOfViewOrderCancelled;

	List<Integer> listOfIndex = new ArrayList<>();
	Random rand = new Random();
	int rand_int;
	private static String DrugName;
	private static String DrugNameLearnMore;

	public String getDrugName() {
		return DrugName;
	}

	public String getDrugNameLearnMore() {
		return DrugNameLearnMore;
	}

	public List<Integer> getListOfIndexForDrugName() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfDrugName.size(); i++) {
			listOfIndex.add(i);
		}
		return listOfIndex;
	}

	public boolean properUseTab() {

		if (properUseTab.getText().contains("Proper Use")) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnActiveMedicationDisplayedOnCurrentMedications() {
		List<Integer> listOfIndex = getListOfIndexForDrugName();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfIndex.size());
		listOfDrugName.get(listOfIndex.get(rand_int)).click();
		DrugName = listOfDrugName.get(listOfIndex.get(rand_int)).getText();
		System.out.println("Clicked on Active Medication :: " + DrugName);
	}

	public List<Integer> getListOfIndexForLearnMore() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfLearnMore.size(); i++) {
			listOfIndex.add(i);
		}
		return listOfIndex;
	}

	public void clickOnLearnMoreButtonDisplayedOnCurrentMedications() {
		List<Integer> listOfIndex = getListOfIndexForLearnMore();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfIndex.size());
		listOfLearnMore.get(listOfIndex.get(rand_int)).click();
		// need to find the drug name
		// DrugNameLearnMore = listOfLearnMore.get(listOfIndex.get(rand_int));
	}

	public void clickOnGetPricingButtonDisplayedOnCurrentMedications() {
		List<Integer> listOfIndex = getListOfIndexForLearnMore();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfIndex.size());
		listOfGetPricing.get(listOfIndex.get(rand_int)).click();

	}

	public List<Integer> getListOfIndexForRefillMedication() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfRefillMedication.size(); i++) {
			listOfIndex.add(i);
		}
		return listOfIndex;
	}

	public boolean clickProceedButton() {

		waitforElement(siteLeavingPopUp);
		boolean proceeding = true;
		jsClickNew(siteLeavingPopUpProceedBtn);
		if (driver.getWindowHandles().size() > 0) {
			proceeding = true;
			Assert.assertTrue(driver.getWindowHandles().size() > 0);
		} else {
			proceeding = false;
		}
		return proceeding;
	}

	public boolean clickYesButton() {

		waitforElement(removeYesPopUp);
		boolean proceeding = true;
		jsClickNew(removePopUpYesBtn);
		if (driver.getWindowHandles().size() > 0) {
			proceeding = true;
			Assert.assertTrue(driver.getWindowHandles().size() > 0);
		} else {
			proceeding = false;
		}
		return proceeding;
	}

	public boolean clickXButton() {

		waitforElement(removeXPopUpBtn);
		boolean proceeding = true;
		jsClickNew(removeXPopUpBtn);
		if (driver.getWindowHandles().size() > 0) {
			proceeding = true;
			Assert.assertTrue(driver.getWindowHandles().size() > 0);
		} else {
			proceeding = false;
		}
		return proceeding;
	}

	public boolean clickRemoveCancelButton() {

		waitforElement(removePopUpCancelBtn);
		boolean proceeding = true;
		jsClickNew(removePopUpCancelBtn);
		if (driver.getWindowHandles().size() > 0) {
			proceeding = true;
			Assert.assertTrue(driver.getWindowHandles().size() > 0);
		} else {
			proceeding = false;
		}
		return proceeding;
	}

	public boolean clickCancelButton() {

		waitforElement(siteLeavingPopUp);
		boolean canceling = true;
		jsClickNew(siteLeavingPopUpCancelBtn);
		if (driver.getWindowHandles().size() > 0) {
			canceling = true;
			Assert.assertTrue(driver.getWindowHandles().size() > 0);
		} else {
			canceling = false;
		}
		return canceling;
	}

	public void clickManageAtWalgreens() {

		Random rand = new Random();
		rand_int = rand.nextInt(listOfManageAtWalgreens.size());
		listOfManageAtWalgreens.get(rand_int).click();
	}

	public void clickTransferAtWalgreens() {

		Random rand = new Random();
		rand_int = rand.nextInt(listOfTransferAtWalgreens.size());
		listOfTransferAtWalgreens.get(rand_int).click();
	}

	public void clickGetPricingWalgreems() {

		walgreensGetPricing.click();

	}

	public void clickOnRefillMedicationCTAOnCurrentMedications() {
		// List<Integer> listOfIndex = getListOfIndexForRefillMedication();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfRefillMedication.size());
		listOfRefillMedication.get(rand_int).click();
	}

	public List<Integer> getListOfIndexForRenewMedication() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfRenewMedication.size(); i++) {
			listOfIndex.add(i);
		}
		return listOfIndex;
	}

	public void clickOnRenewMedicationCTAOnCurrentMedications() {
		// List<Integer> listOfIndex = getListOfIndexForRenewMedication();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfRenewMedication.size());
		listOfRenewMedication.get(rand_int).click();
	}

	public List<Integer> getListOfIndexForResolveHold() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfResolveHold.size(); i++) {
			listOfIndex.add(i);
		}
		return listOfIndex;
	}

	public void clickOnResolveHoldCTAOnCurrentMedications() {
		// List<Integer> listOfIndex = getListOfIndexForResolveHold();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfResolveHold.size());
		listOfResolveHold.get(rand_int).click();
	}

	public List<Integer> getListOfIndexForTrackStatus() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfTrackStatus.size(); i++) {
			listOfIndex.add(i);
		}
		return listOfIndex;
	}

	public void viewTrackStatusCTAOnCurrentMedications() {
		List<Integer> listOfIndex = getListOfIndexForTrackStatus();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfIndex.size());
		listOfTrackStatus.get(listOfIndex.get(rand_int));
	}

	public void clickOnTrackStatusCTAOnCurrentMedications() {
		List<Integer> listOfIndex = getListOfIndexForTrackStatus();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfIndex.size());
		listOfTrackStatus.get(listOfIndex.get(rand_int)).click();
	}

	// F436319
	@FindBy(xpath = "//*[@data-testid='global-alert-banner-Expanded Access to Care, Support and Resources for COVID-19']")
	protected WebElement PnPNotification;

	public List<Integer> getListOfIndexForManageAtWalgreens() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfManageAtWalgreens.size(); i++) {
			listOfIndex.add(i);
		}
		return listOfIndex;
	}

	@FindBy(xpath = "//*[@data-testid='global-alert-banner-Expanded Access to Care, Support and Resources for COVID-19']//div//div//button[@data-testid='global-alert-banner--close-button']")
	protected WebElement PnPNotificationCloseBtn;

	public List<Integer> getListOfIndexForTransferToWalgreens() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfTransferAtWalgreens.size(); i++) {
			listOfIndex.add(i);
		}
		return listOfIndex;
	}

	public List<Integer> getListOfIndexForViewOrder() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfViewOrder.size(); i++) {
			listOfIndex.add(i);
		}
		return listOfIndex;
	}

	public List<Integer> getListOfIndexForViewOrderCancelled() {
		List<Integer> listOfIndex = new ArrayList<>();
		for (int i = 0; i < listOfViewOrderCancelled.size(); i++) {
			listOfIndex.add(i);
		}
		return listOfIndex;
	}

	@FindBy(xpath = "//span[@data-test-component='text']//span")
	protected WebElement PnPNotificationPosition;

	public void ViewManageAtWalgreens() {
		List<Integer> listOfIndex = getListOfIndexForManageAtWalgreens();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfIndex.size());
		listOfManageAtWalgreens.get(listOfIndex.get(rand_int));
	}

	public void ViewTransferToWalgreens() {
		List<Integer> listOfIndex = getListOfIndexForTransferToWalgreens();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfIndex.size());
		listOfTransferAtWalgreens.get(listOfIndex.get(rand_int));
	}

	public void ViewOrderCTAOnCurrentMedications() {
		List<Integer> listOfIndex = getListOfIndexForViewOrder();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfIndex.size());
		listOfViewOrder.get(listOfIndex.get(rand_int));
	}

	public void clickOnViewOrderCTAOnCurrentMedications() {
		List<Integer> listOfIndex = getListOfIndexForViewOrder();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfIndex.size());
		listOfViewOrder.get(listOfIndex.get(rand_int)).click();
	}

	public void clickOnViewOrderCancelled() {
		List<Integer> listOfIndex = getListOfIndexForViewOrderCancelled();
		Random rand = new Random();
		rand_int = rand.nextInt(listOfIndex.size());
		listOfViewOrderCancelled.get(listOfIndex.get(rand_int)).click();
	}

	public void clickRefillMedicationsCTA() {
		// pnpValidate(RefillMedications);
		RefillMedications.click();
	}

	public boolean sixActivePrescription() {
		if (sixMedications.size() == 6) {
			return true;
		} else {
			return false;
		}
	}

	@FindBy(xpath = "//*[@data-testid='price-drugs-CTA-external-icon']")
	protected WebElement FindAndPriceExternalIcon;

	@FindBy(xpath = "//input[@data-component=\"SearchBarInput\"]")
	protected WebElement DrugEstimatorToolPageSearchBar;

	@FindBy(xpath = "//*[@data-testid='order-prescription-CTA-external-icon']")
	protected WebElement OrderPrescriptionExternalIcon;

	public boolean tenActivePrescription() {

		System.out.println(tenMedications.size() + "lllllllllllllllllllllllllllllllllllll");

		if (tenMedications.size() == 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean moreThanTenActivePrescription() {

		// String numberTXT =
		// totalMedicationsInMyMed.get(totalMedicationsInMyMed.size()-1).getText();
		// int number = Integer.parseInt(numberTXT.replaceAll("[^0-9]", ""));

		String numberTXT = totalMedicationsInMyMed.getAttribute("data-test-total-medications");
		System.out.println(numberTXT + "9999999999999999999999");
		int number = Integer.parseInt(numberTXT.replaceAll("[^0-9]", ""));

		if (number > 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean externalLink() {
		if (externalLink.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOrderProcessing() {
		if (Processing.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean transferToHDHeaderDisplayed() {
		if (validate(transferToHDHeader)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTransfer2HDCTA() {
		if (listOfTransferToHDCTA.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOptumRX() {
		if (optumRx.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRequestReceived() {
		if (requestReceived.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOrderReceived() {
		if (orderReceived.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRequestPlaced() {
		if (requestPlaced.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isProcessingMessageDispplayed() {
		if (processingMessage.getText().contains("pharmacy processing")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRequestPlacedPending() {
		if (requestPlacedPending.getText().contains("Pending")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRequestPlacedOrderNumber() {
		if (requestPlacedNoOrderNumber.size()>=3) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isHalfHarveyBall() {
		if (halfHarveyBall.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOneFourthHarveyBall() {
		if (oneFourthHarveyBall.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean associatedCallToAction() {
		if (AssociatedCallToAction.get(AssociatedCallToAction.size() - 1).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateTrackStatusBtn() {
		if (trackStatusButton.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateDeliveredStatus() {
		if (delivered.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean viewOrderButton() {
		if (viewOrder.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean contactPharmacyButton() {
		if (contactPharmacyBtn.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}


	public boolean alphaNumeric() {
		boolean containsDigit = false;
		String s = NumberInParenthesisRefillAll.get(0).getText();
		if (s != null && !s.isEmpty()) {
			for (char c : s.toCharArray()) {
				if (containsDigit = Character.isDigit(c)) {
					break;
				}
			}
		}
		return containsDigit;
	}

	public boolean corredpondingMedicationsNumbers() {
		String numberTXT = NumberInParenthesisRefillAll.get(0).getText();
		int number = Integer.parseInt(numberTXT.replaceAll("[^0-9]", ""));
		String totalNumber = totalMedicationsInCurrenMedications.getAttribute("data-test-total-medications");
		int number2 = Integer.parseInt(totalNumber.replaceAll("[^0-9]", ""));

		if (number == number2) {

			return true;
		} else {

			return false;
		}
	}

	public boolean corredpondingRefillMedicationsNumbers() {


		String numberTXT = NumberInParenthesisRefillAll.get(0).getText();
		int number = Integer.parseInt(numberTXT.replaceAll("[^0-9]", ""));

		if (number>0) {

			return true;
		} else {

			return false;
		}
	}


	public boolean validateNeedHelpsPhoneNumbers() {

		String techNumber="1-800-721-0627";
		String planNumber="1-844-876-6177";

		if (techNumber.equals(technicalSupportNumber.getText()) && planNumber.equals(planSupportNumber.getText())) {

			return true;
		} else {

			return false;
		}
	}

	public boolean validateNeedHelpsHoursOfOperations() {

		String Hours1="7 a.m. - 10 p.m. CT, 7 days a week";
		String Hours2="8 a.m. - 8 p.m. local time, Monday - Friday";

		if (planSupportHours.getText().equals(Hours1) && technicalSupportHours.getText().equals(Hours2)) {

			return true;
		} else {

			return false;
		}
	}

	public boolean disclaimer() {
		if (Disclaimer.get(Disclaimer.size() - 1).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	@FindBy(xpath = "//button[@data-testid='medication-action-resolve-hold']")
	protected List<WebElement> listOfResolveHoldBtn;

	@FindBy(xpath = "//div[text()=' On Hold: Action Required']/..//div[@data-testid='medication-data-pharmacy-name']")
	protected List<WebElement> listOfHDMedicationHavingHold;

	@FindBy(xpath = "//div[text()=' On Hold: Action Required']")
	protected List<WebElement> listOfOnHoldMsg;

	@FindBy(xpath = "//*[text()='Important']/..")
	protected List<WebElement> listOfHoldWarningSymbol;

	// button[@data-testid='medication-action-resolve-hold']//*[@aria-label='external
	// link']
	@FindBy(xpath = "//button[@data-testid='medication-action-resolve-hold']//*[3]")
	protected List<WebElement> listOfExternalLinkOnResolveHldBtn;

	@FindBy(xpath = "//div[contains(@data-testid,'medication-status-percent')]//*[@id='WhiteCheck_svg__a']")
	protected List<WebElement> listOfCheckMarkOnFullHarveyBall;

	@FindBy(xpath = "//strong[@data-testid='display-meds-ratio-a']")
	protected WebElement drugsAvailableOnMyMedication;

	@FindBy(xpath = "//strong[@data-testid='display-meds-ratio-b']")
	protected WebElement totaldrugsAvailableOnMyMedication;

	// (////div[@class='sc-LzLrp iewWRX']//div//strong)[2]

	// rgb(172, 43, 0)

	@FindBy(xpath = "//div[@data-test-is-informational-hold='true']/ancestor::div[1]/..//a")
	protected List<WebElement> listOfmedicationHavingInformationalHold;

	@FindBy(xpath = "//button[@data-testid='medication-action-refill']")
	protected List<WebElement> listOfRefillMedicationBtn;

	@FindBy(xpath = "//button[@data-testid='medication-action-renew']")
	protected List<WebElement> listOfRenewMedicationBtn;
	
	@FindBy(xpath="//a[@data-testid='medication-action-refill']/ancestor::div[@data-testid]//div[@data-testid='medication-data-pharmacy-name']")
	protected List<WebElement> listOfPharmacyEligibleFrRefill;

	@FindBy(xpath = "//a[@data-testid='medication-action-renew']/ancestor::div[@data-testid]//div[@data-testid='medication-data-pharmacy-name']")
	protected List<WebElement> listOfPharmacyEligibleFrRenew;

	@FindBy(xpath = "//button[@data-testid='medication-action-resolve-hold']/ancestor::div[@data-testid]//div[@data-testid='medication-data-pharmacy-name']")
	protected List<WebElement> listOfPharmacyEligibleFrHold;

	@FindBy(xpath = "//span[text()='Proper Use']")
	protected WebElement properUseTab;

	// walgreens related

	@FindBy(xpath = "//button[@data-testid='medication-action-refill']/ancestor::div[@data-testid]//div[@data-testid='walgreens']")
	protected List<WebElement> walgreens;

	@FindBy(xpath = "//*[contains(@data-testid,'csa__address__successMessage')]")
	protected WebElement addressDeleteMessage;

	@FindBy(xpath="//a[@data-testid='manage-at-walgreens']")
	protected List<WebElement> listOfManageAtWalgreens;

	@FindBy(xpath = "//*[@data-testid='walgreens-external-icon']")
	protected List<WebElement> externalLink;

	@FindBy(css = "div.siteleaving-popup-footer>div")
	protected WebElement siteLeavingPopUp;

	@FindBy(css = "div.siteleaving-popup-footer a#cancelbtn")
	protected WebElement siteLeavingPopUpCancelBtn;

	@FindBy(css = "div.siteleaving-popup-footer a#proceedbtn")
	protected WebElement siteLeavingPopUpProceedBtn;

	@FindBy(xpath = "//div[contains(text(),'Submit request')]")
	protected WebElement submitRequestBtn;

	@FindBy(xpath = "//h1[@data-testid='confirm__delete__message']")
	protected WebElement removeYesPopUp;

	@FindBy(xpath = "//div[@data-testid='confirm__delete__close']//button")
	protected WebElement removeXPopUpBtn;

	@FindBy(xpath = "//button[@data-testid='confirm__delete__yes']")
	protected WebElement removePopUpYesBtn;

	@FindBy(xpath = "//button[@data-testid='confirm__delete__cancel']")
	protected WebElement removePopUpCancelBtn;

	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div/div/div[2]/div/div/div[3]/div[3]/div[2]/div[1]/div[2]/div[2]")
	protected WebElement walgreensRefillsLeft;

	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div/div/div[2]/div/div/div[3]/div[3]/div[2]/div[2]/div[1]/a")
	protected WebElement walgreensGetPricing;

	@FindBy(xpath = "//button[@data-testid='transfer-at-walgreens']")
	protected List<WebElement> listOfTransferAtWalgreens;

	@FindBy(xpath = "//div[@data-testid='medication-data-pharmacy-name']/ancestor::div[@data-testid]//div[text()='Refills left']")
	protected List<WebElement> listofHDMedicationHavingRefillLeftField;

	@FindBy(xpath = "//div[@data-testid='medication-data-pharmacy-name']/ancestor::div[@data-testid]//div[@data-testid='medication-data-refills-left']")
	protected List<WebElement> listofHDMedicationHavingRefillLeftVal;

	// div[@data-testid='medication-data-pharmacy-name']/ancestor::div[@data-testid]//div[@data-testid='medication-data-refills-left']

	@FindBy(xpath = "//*[@data-testid='medication-cost-summary-CTA-external-icon']")
	protected WebElement MedicationCostSummaryExternalIcon;

	// Drug Lookup Call to Action
	/*@FindBy(xpath = "//div[@data-testid='price-drugs-CTA']")
	protected WebElement DrugLookupCallToActnBtn;*/

	/*@FindBy(xpath = "//div[@data-testid='price-drugs-CTA-icon']")
	protected WebElement DrugLookupCTAImg;*/
	
	/*@FindBy(xpath = "//h2[@data-testid='price-drugs-CTA-title']")
	protected WebElement DrugLookupCTATitle;*/
	
	/*@FindBy(xpath = "//p[@data-testid='price-drugs-CTA-description']")
	protected WebElement DrugLookupCTADescription;*/

	@FindBy(xpath = "//div[@data-testid='price-drugs-CTA']")
	protected WebElement FindAndPriceCallToActnBtn;
	
	@FindBy(xpath = "//div[@data-testid='price-drugs-CTA-icon']")
	protected WebElement FindAndPriceCTAImg;

	@FindBy(xpath = "//h2[@data-testid='price-drugs-CTA-title' and contains(text(),'Find & Price a Medication')]")
	protected WebElement FindAndPriceCTATitle;

	@FindBy(xpath = "//p[@data-testid='price-drugs-CTA-description' and contains(text(),'Find out if your drugs are covered, estimate costs and ways to help save money.')]")
	protected WebElement FindAndPriceCTADescription;

	// Pharmacy Locator

	@FindBy(xpath = "//div[@data-testid='find-pharmacy-CTA']")
	protected WebElement PharmacyLocatorCallToActnBtn;

	@FindBy(xpath = "//div[@data-testid='find-pharmacy-CTA-icon']")
	protected WebElement PharmacyLocatorCTAImg;

	@FindBy(xpath = "//h2[@data-testid='find-pharmacy-CTA-title' and contains(text(),'Pharmacy Locator')]")
	protected WebElement PharmacyLocatorCTATitle;

	@FindBy(xpath = "//p[@data-testid='find-pharmacy-CTA-description' and contains(text(),'Find a network pharmacy near you.')]")
	protected WebElement PharmacyLocatorCTADescription;

	// Order Prescription
	@FindBy(xpath = "//div[@data-testid='order-prescription-CTA']")
	protected WebElement OrderPrescriptionCallToActnBtn;

	@FindBy(xpath = "//div[@data-testid='order-prescription-CTA-icon']")
	protected WebElement OrderPrescriptionCTAImg;

	@FindBy(xpath = "//h2[@data-testid='order-prescription-CTA-title' and contains(text(),'Order')]/span[contains(text(),'Prescriptions')]")
	protected WebElement OrderPrescriptionCTATitle;

	@FindBy(xpath = "//p[@data-testid='order-prescription-CTA-description' and contains(text(),'Refill your prescriptions with home delivery')]")
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
	
	@FindBy(xpath = "//div[@data-testid='ANOC-CTA']")
	protected WebElement ANOCCallToActnBtn;

	@FindBy(xpath = "//div[@data-testid='ANOC-CTA-icon']")
	protected WebElement ANOCCTAImg;	

	@FindBy(xpath = "//h2[@data-testid='ANOC-CTA-title']")
	protected WebElement ANOCCTATitle;
	
	@FindBy(xpath = "//p[@data-testid='ANOC-CTA-description']")
	protected WebElement ANOCCTADescription;	

	@FindBy(xpath = "//h2[text()='Prepare for Next Year']")
	protected WebElement ANOCPageHeader;
	
	@FindBy(xpath="//*[@data-testid='ANOC-CTA-external-icon']")
	protected WebElement ANOCExternalIcon;

	@FindBy(xpath="//span[contains(text(),'View Current Medications')]")
	protected WebElement viewCurrentMedicationsBtn;

	@FindBy(xpath = "")
	protected WebElement OptumRxDrugPricePageHeader;

	@FindBy(xpath = "//div[text()='Choose a plan year to find in-network pharmacies.']")
	protected WebElement HeaderOnChoosePlanYearPage;

	@FindBy(xpath = "//main/div[2]/div[1]/div/div/div[1]/div/div[2]/button[@data-testid='back-button']")
	protected WebElement BackButtonOnChoosePlanYearPage;

	@FindBy(xpath = "//div[@data-testid='pharmacy-locator-subheading' and contains(text(),'You can search our directory of current covered pharmacies or view next year')]")
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

	@FindBy(xpath = "//footer[contains(@class,'footerContainer')]")
	protected WebElement GlobalFooterSectionOnChoosePlanYearPage;

	@FindBy(xpath = "//*[@data-testid='pharmacy-locator-2020-CTA-external-icon']")
	protected WebElement PharmacyLocator2020CTAExternalIcon;

	@FindBy(xpath = "//button[@data-component='BackButton']")
	protected WebElement BackButtonOnPharmacyLocatorPageByRally;

	@FindBy(xpath = "//div[contains(@data-testid,'header__icon__left')]/button")
	protected WebElement backButtonOnTransfer2HD;

	@FindBy(xpath = "//button[@data-component='SearchBarSubmitButton']")
	protected WebElement SearchButtonPharmacyLocatorPageByRally;

	@FindBy(id = "zipcodeTxt")
	protected WebElement zipCodeTextBoxLegacyPharmacyLocatorPage;

	@FindBy(xpath = "")
	protected WebElement OptumRxMedicineCabinetHeader;

	@FindBy(xpath = "//h1[@id='page_title' and contains(text(),'My Prescriptions')]")
	protected WebElement OptumRxManagePrescriptionHeader;

	@FindBy(xpath = "//h1[@id='page_title' and contains(text(),'Benefits Information')]")
	protected WebElement OptumRxBenefitsInformationHeader;

	@FindBy(xpath = "//a[@data-testid='medication-action-refill']/ancestor::div[@data-testid]//*[@data-testid='medication-data-you-paid']")
	protected List<WebElement> listOfAmntPaidEligibleFrRefill;
	
	@FindBy(xpath = "//a[@data-testid='medication-action-renew']/ancestor::div[@data-testid]//*[@data-testid='medication-data-you-paid']")
	protected List<WebElement> listOfAmntPaidEligibleFrRenew;
	
	@FindBy(xpath = "//a[@data-testid='medication-action-refill']/ancestor::div[@data-testid]//*[@data-testid='medication-data-name']")
	protected List<WebElement> listOfMedicationEligibleFrRefill;
	
	@FindBy(xpath = "//a[@data-testid='medication-action-renew']/ancestor::div[@data-testid]//*[@data-testid='medication-data-name']")
	protected List<WebElement> listOfMedicationEligibleFrRenew;

	@FindBy(xpath = "//*[@data-testid='medication-data-order-status']/ancestor::div[@data-testid]//*[@data-testid='medication-data-name']")
	protected List<WebElement> listOfMedicationRequestPlaced;

	@FindBy(xpath = "//*[@data-testid='medication-data-order-status']/ancestor::div[@data-testid]//*[@data-testid='medication-data-name']")
	protected List<WebElement> listOfMedicationProcessing;

	@FindBy(xpath = "//a[@data-testid='medication-action-refill']/ancestor::div[@data-testid]//*[@data-testid='medication-data-refills-left']")
	protected List<WebElement> listOfRefillLeftEligibleFrRefill;

	@FindBy(xpath = "//a[@data-testid='medication-action-refill']/ancestor::div[@data-testid]//*[@data-testid='medication-data-day-supply']")
	protected List<WebElement> listOfDaySupplyEligibleFrRefill;

	@FindBy(xpath = "//a[@data-testid='medication-action-renew']/ancestor::div[@data-testid]//*[@data-testid='medication-data-day-supply']")
	protected List<WebElement> listOfDaySupplyEligibleFrRenew;

	@FindBy(xpath = "//*[@data-testid='medication-data-order-status']/ancestor::div[@data-testid]//*[@data-testid='medication-data-day-supply']")
	protected List<WebElement> listOfDaySupplyEligibleFrRequestPlaced;
	
	@FindBy(xpath = "//button/span[@data-test-component='text' and contains(text(),'Try Again')]")
	protected WebElement tryAgainMedCabTimeOut;
	
	@FindBy(xpath = "//div[@data-testid='header__title']//h1")
	protected WebElement orderCheckoutPageHeader;
	
	@FindBy(xpath="//div[@data-is-refill-eligible]")
	protected List<WebElement> listOfHDMedicationHavingRefillflag;
	
	@FindBy(xpath = "//*[@data-testid='os__shipping__estimatedDate']")
	protected WebElement estimatedDateOnCheckOutPage;
	
	@FindBy(xpath = "//*[@data-testid='rx__drugNameSize']")
	protected WebElement drugNameOnCheckOutPage;

	@FindBy(xpath = "//*[@data-testid='os__shipping__estimatedDate']")
	protected WebElement estimatedDeliveryDate;

	@FindBy(xpath = "//*[@data-testid='csa__address__successMessage']")
	protected WebElement removedMessage;

	@FindBy(xpath = "//*[@data-testid='section__content']")
	protected WebElement zeroPrescriptionMessage;

	@FindBy(xpath="//div[@data-testid='medication-data-pharmacy-name' and (contains(text(),'OptumRx'))]/ancestor::div[@data-testid]")
	protected List<WebElement> listOfMedicationSectionFromOptum;
	
	@FindBy(xpath="//div[@data-testid='medication-data-pharmacy-name' and not(contains(text(),'OptumRx'))]/ancestor::div[@data-testid]")
	protected List<WebElement> listOfMedicationSectionNotFrmOptum;
	
	@FindBy(xpath="//div[@data-testid='pagination-next-disabled']")
	protected WebElement nextPaginationDisabled;
	
	@FindBy(xpath="(//span[@data-testid='pagination-description']//strong)[2]")
	protected WebElement totalNumberOfPage;
	
	@FindBy(xpath="//a[@data-testid='medication-action-transfer']")
	protected List<WebElement> listOfTransferToHDCTA;
	
	@FindBy(xpath="//a[@data-testid='medication-action-transfer']/ancestor::div[@data-testid]//div[@data-testid='medication-data-pharmacy-name']")
	protected List<WebElement> listOfRetailPharmacyNameEligibleForTransferToHD;
	
	@FindBy(xpath="//a[@data-testid='medication-action-transfer']/ancestor::div[@data-testid]//a[@data-testid='medication-data-name']")
	protected List<WebElement> listOfRetailMedEligibleForTransferToHD;
	
	@FindBy(xpath="//a[@data-testid='medication-action-transfer']/ancestor::div[@data-testid]//div[@data-testid='medication-data-day-supply']")
	protected List<WebElement> listOfDaySupplyEligibleForTransferToHD;
	
	@FindBy(xpath = "//*[contains(text(),'shipped')]")
	protected List<WebElement> listOfShipped;
	
	public boolean isOrderShipped() {
		if (listOfShipped.size() >= 0) {
			System.out.println("Order Shipped Medication Found");
			return true;
		} else {
			return false;
		}
	}
	
	@FindBy(xpath = "//div[@data-testid='medication-status-percent-75']")
	protected List<WebElement> threeFourthHarveyBall;
	
	public boolean isThreeFourthHarveyBall() {
		if (threeFourthHarveyBall.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@FindBy(xpath = "//*[@data-testid='step__label']//span[@data-testid='step__completed']/ancestor::span//span[text()='Shipped']")
	protected WebElement ShippedOrderTracker;
	
	
}
