package pages.regression.pharmaciesandprescriptions;

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
	
	@FindBy(css=".DRUG_PRICING_TILE_Group #pharmacyTileLinkId")
	protected WebElement LookUpDrugsButton;
	
	@FindBy(css=".MEDICINE_CABINET_TILE #pharmacyTileLinkId")
	protected WebElement orderPrescriptionsButton;
	
	@FindBy(css=".ORDER_STATUS_TILE #pharmacyTileLinkId")
	protected WebElement checkDelieryStatusButton;
	
	@FindBy(css=".BENEFITS_INFORMATION #pharmacyTileLinkId")
	protected WebElement drugCostSummaryButton;
	
	@FindBy(id ="page_title")
	protected WebElement BenefitsInformationHeaderOptumRx;
	
	@FindBy(id ="page_title")
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
	
	//************************************************************************
		//F436319
		//@FindBy(xpath="//div[@class='sc-LzLsE iVLzSR sc-LzLLC ebMTfg']")--> updated
		//@FindBy(xpath="//div[@class='sc-LzLsE iVLzSR sc-LzLLD ebVpJp']")--> Updated
		@FindBy(xpath="//div[@class='sc-LzLsE iVLzSR sc-LzLMg emWRhd']")		
		protected WebElement PnPNotification;
		
		@FindBy(xpath="//span[@data-test-component='text']//span")
		protected WebElement PnPNotificationCloseBtn;
		
		@FindBy(xpath="//span[@data-test-component='text']//span")
		protected WebElement PnPNotificationPosition;
				
		@FindBy(xpath="(//*[@id='FindAndPriceADrug_svg__a']/.)[1]")
		protected WebElement findPrescriotionImage;
		
		@FindBy(xpath="(//h2[contains(text(),'Find')])[1]")
		protected WebElement findPrescriptionTitle;
		
		@FindBy(xpath="(//p[contains(text(),'Look up')])[1]")
		protected WebElement findPrescriptionDesc;
				
		@FindBy(xpath="//*[@id='PharmacyLocator_svg__a']")
		protected WebElement pharmacyLocatorImage;
		
		@FindBy(xpath="//h2[contains(text(),'Pharmacy')]")
		protected WebElement pharmacyLocatorTitle;
		
		@FindBy(xpath="//p[contains(text(),'Find a pharmacy')]")
		protected WebElement pharmacyLocatorDesc;
		
		@FindBy(xpath="//*[@id='CheckOrderStatus_svg__a']")
		protected WebElement managePresciptionImage;
		
		@FindBy(xpath="//h2[contains(text(),'Manage')]")
		protected WebElement managePrescriptionTitle;
		
		@FindBy(xpath="//p[contains(text(),'Refill')]")
		protected WebElement managePrescriptionDesc;	
		
		@FindBy(xpath="//p[contains(text(),'Check')]/ancestor::button//div[@class='sc-LzLMh enfnLm']/*")
		protected WebElement whatsNewImage;
		
		@FindBy(xpath="//h2[contains(text(),'Whats')]")
		protected WebElement whatsNewTitle;	

		@FindBy(xpath="//p[contains(text(),'Check Out')]")
		protected WebElement whatsNewDesc;
		
		// Call to Action Buttons	
		
		@FindBy(xpath="(//h2[contains(text(),'Find')]/ancestor::button)[1]")
		protected WebElement findPrescriptionsCallToActnBtn;

		@FindBy(xpath="//h2[contains(text(),'Pharmacy')]/ancestor::button")
		protected WebElement pharmacyLocatorCallToActnBtn;

		@FindBy(xpath="//h2[contains(text(),'Manage')]/ancestor::button")
		protected WebElement managePrescriptionCallToActnBtn;
		
		@FindBy(xpath="//h2[contains(text(),'Whats')]/ancestor::button")
		protected WebElement whatsNewCallToActnBtn;
		
		@FindBy(xpath="//h1[@class='sc-LzLrZ faEGzK']")
		protected WebElement whatsNewPageHeader;
		
		@FindBy(xpath="")
		protected WebElement OptumRxDrugPricePageHeader;
		
		@FindBy(xpath="")
		protected WebElement PharmacyLocatorToolHeader;
		
		@FindBy(xpath="")
		protected WebElement OptumRxMedicineCabinetHeader;

	   //Medicine Cabinet
	    @FindBy(xpath="//div[contains(text(),'Current Medications')]")
	    protected WebElement CurrentMedicationsHeader;

	    @FindBy(xpath="//div[@class='sc-LzLtN ijGRvz']")
     	protected List<WebElement> SixMedications;

     	@FindBy(xpath="//div[@class='")
	    protected List<WebElement> AssociatedCallToAction;

    	@FindBy(xpath="//a[contains(text(),'View all ')]")
     	protected WebElement ViewAllMedications;

	    @FindBy(xpath="//h1[contains(text(),'My Drugs')]")
	    protected WebElement MyMedicationsPageHeader;

	    // identical class

	   @FindBy(xpath="//div[@class='sc-LzLtN ijGRvz']")
	   protected WebElement MedicationName;

	   @FindBy(xpath="/html/body/div[3]/div[1]/main/div/div[2]/div/div[2]/div/div[1]/div[1]/img")
	   protected WebElement Image;

	   @FindBy(xpath="//a[contains(text(),'mg')]")
	   protected WebElement Strength;


	   @FindBy(xpath="//div[@class='sc-LzLtQ ikghia']")
	   protected WebElement PriceMemberPaid;


     	@FindBy(xpath="//div[@class='sc-LzLtN ijGRvz']")
	    protected WebElement PharmacyLastFilled;


	    @FindBy(xpath="//div[@class='sc-LzLtP ijXKDR']")
	     protected WebElement DayOfSupply;



	    @FindBy(xpath="")
	    protected WebElement OrderStatus;


     	@FindBy(xpath="")
    	protected WebElement RelevantCallToAction;


	    @FindBy(xpath="")
	    protected WebElement InfoOnRemainingRefills;


	    @FindBy(xpath="")
	    protected WebElement PhoneNumber;



	   @FindBy(xpath="//span[contains(text(),'Overview')]")
	   protected WebElement Overview;


     	@FindBy(xpath="//span[contains(text(),'')]")
	    protected WebElement NumberInParenthesis;

     	@FindBy(xpath="//span[contains(text(),'Medication appearance subject to change')]")
    	protected WebElement Disclaimer;

     	@FindBy(xpath="//span[contains(text(),'Request received')]")
    	protected List<WebElement> RequestReceived;

	    @FindBy(xpath="//span[contains(text(),'OptumRx')]")
	    protected List<WebElement> OptumRx;

	    @FindBy(xpath="//span[contains(text(),'OptumRx')]")
	    protected List<WebElement> Processing;

	    @FindBy(xpath="(//div[@class='sc-LzLtT hBUvHG'])[last()]")
	    protected WebElement HalfHarveyBall;

	    @FindBy(xpath="")
		protected WebElement oneFourthHarveyBall;

    	@FindBy(xpath="//span[contains(text(),'Refill')]")
    	protected WebElement RefillMedications;

	    @FindBy(xpath="//span[contains(text(),'Renew')]")
	    protected WebElement RenewMedications;








//************************Added By Naresh***********************************************************
     	
     	@FindBy(xpath="//a[@data-testid='medication-data-name']")
     	protected List<WebElement> listOfDrugName;
     	
     	@FindBy(xpath="//img[@class='sc-LzLtg ebebwo']")
     	protected List<WebElement> listOfDrugImage;
     	
     	@FindBy(xpath="//div[@data-testid='medication-data-refills-left']")
     	protected List<WebElement> listOfMedicineStrength;
     	
     	@FindBy(xpath="//div[@data-testid='medication-data-refills-left']")
     	protected List<WebElement> listOfRefillsLeft;
     	
     	@FindBy(xpath="//div[@data-testid='medication-data-day-supply']")
     	protected List<WebElement> listOfDaysSupply;
     	
     	@FindBy(xpath="//div[@data-testid='medication-data-you-paid']")
     	protected List<WebElement> listOfYouPaid;
     	
     	@FindBy(xpath="//div[@class='sc-LzLuB inbXFg']")
     	protected List<WebElement> listOfPharmacyName;
     	
     	@FindBy(xpath="//span[@data-testid='medication-data-order-status']")
     	protected List<WebElement> listOfOrderStatus;
     	
     	@FindBy(xpath="//a[contains(@data-testid,'medication-action') and not(contains(@data-testid,'learn-more'))]//button")
     	protected List<WebElement> listOfCallToActionOnMedication;
     	
     	@FindBy(xpath="")
     	protected WebElement contactPharmacyNumber;
     	
     	@FindBy(xpath="//div[@data-testid='medication-status-percent-0']")
     	protected List<WebElement> listOfHarveyBall;
   
     	public List<String> getDrugNameListValue(){
     		List<String> listOfDrug=new ArrayList<>();
     		for(WebElement ele:listOfDrugName) {
     			listOfDrug.add(ele.getText());
     		}
     		return listOfDrug;
     	}
     	
     	public boolean validateFieldValueContent(List<WebElement> listOfWebElement) {
     		for(WebElement ele:listOfWebElement) {
     			if(ele.getText().isEmpty()) {
     				return false;
     			}
     		}
     		return true; 
     	}
     	
     	public boolean validateMedicineStrengthFieldValue() {
     		for(WebElement ele:listOfMedicineStrength) {
     			if(ele.getText().isEmpty()) {
     				return false;
     			}
     		}
     		return true; 
     	}
     	
     	public List<Integer> getListOfIndexForRetailPharmacy() {
     		List<Integer> listOfIndex = new ArrayList<>();
     		for(int i=0; i<listOfPharmacyName.size();i++) {
     			if(!listOfPharmacyName.get(i).getText().equals("OptumRx")) {
     				listOfIndex.add(i);
     			}
     		}
     		return listOfIndex;
     	}
     	
     	public List<Integer> getListOfIndexForHDPharmacy() {
     		List<Integer> listOfIndex = new ArrayList<>();
     		for(int i=0; i<listOfPharmacyName.size();i++) {
     			if(listOfPharmacyName.get(i).getText().equals("OptumRx")) {
     				listOfIndex.add(i);
     			}
     		}
     		return listOfIndex;
     	}
     	
     	List<String> listOfCallToActionForHDMedicine;
     	
     	public boolean validateCallToActionsForHDDrug() {
     		List<Integer> listOfIndex=getListOfIndexForHDPharmacy();
     		for(Integer val:listOfIndex) {
     		if(!listOfCallToActionForHDMedicine.contains(listOfCallToActionOnMedication.get(val).getText())){
     			return false;
     		}
     		}
     		return true;
     	}
     	
     	public boolean validateContactPharmacyButtonForRetailDrug(String expectedButtonValue) {
     		List<Integer> listOfIndex=getListOfIndexForRetailPharmacy();
     		for(Integer val:listOfIndex) {
         		if(!(listOfCallToActionOnMedication.get(val).getText().equals(expectedButtonValue) && listOfCallToActionOnMedication.get(val).getTagName().equals("button"))){
         			return false;
         		}
         		}
         		return true;
     	}
     	
     	public void clickOnContactPharmacy() {
     		List<Integer> listOfIndex=getListOfIndexForRetailPharmacy();
     		Random rand = new Random();
     		int rand_int = rand.nextInt(listOfIndex.size());
     		listOfCallToActionOnMedication.get(listOfIndex.get(rand_int));
     	}
     	
     	//Need to add the Regex for Number 
     	public boolean validateContactPharmacyPopUpHavingNumber() {
     		String contactNumber=contactPharmacyNumber.getText();
     		return !contactNumber.isEmpty() && contactNumber.matches("");
     	}
     	
     	@FindBy(xpath="")
     	protected List<WebElement> listOfExtrnalLinkOnHold;
     	
     	
     	
    // ********************* Kiran ************************	
     	@FindBy(xpath="(//span[text()='LEARN MORE']/parent::button)[1]")
     	protected WebElement LearnMoreBtn_CurrentMedication;
     	
     	@FindBy(xpath="(//span[text()='LEARN MORE']/parent::button)[1]//parent::a//parent::div//parent::div//parent::div/preceding-sibling::div//a[@data-testid='medication-data-name']")
     	protected WebElement FirstCurrentMedication;
     	
     	@FindBy(xpath="//h1[@class='sc-LzLrZ faEGzK sc-LzLPX eA-DpTF']")
     	protected WebElement MedicationName_OnDrugInfoPage;
     	
     	@FindBy(xpath="")
     	protected WebElement nextPageArrow;


}
