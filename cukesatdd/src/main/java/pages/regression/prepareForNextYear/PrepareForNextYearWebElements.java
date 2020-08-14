package pages.regression.prepareForNextYear;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import atdd.framework.UhcDriver;

public class PrepareForNextYearWebElements  extends UhcDriver {

	public PrepareForNextYearWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate(){
	}

	@FindBy(tagName = "arcade-header") 
	protected WebElement shadowRootHeader;

	@FindBy(tagName = "arcade-footer") 
	protected WebElement shadowRootFooter;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//[contains(@id,'findcare')]")
	protected WebElement findCareTopMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'claims')]")
	protected WebElement claimsTopMenuLnk;

	@FindBy(xpath="//header[contains(@class,'sub-nav-header')]//a[contains(@track,'explanation')]")
	protected WebElement eobTopSubMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'coveragebenefits')]")
	protected WebElement benefitsTopMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'formsandresources')]")
	protected WebElement planDocTopMenuLnk;

	@FindBy(xpath="//a[contains(@id,'myDoc')]")
	protected WebElement myDocLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'order')]")
	protected WebElement orderTopMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'payment')]")
	protected WebElement paymentTopMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'pharmacies')]")
	protected WebElement pnpTopMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'health')]")
	protected WebElement hwTopMenuLnk;

	@FindBy(xpath="//a[contains(text(),'Go to EOB')]")
	protected WebElement testharnessTblEobLnk;

	@FindBy(xpath="//a[contains(text(),'Go to Pharmacy')]")
	protected WebElement testharnessTblPharmacyLocatorLnk;

	@FindBy(xpath="//a[contains(text(),'Go to DCE')]")
	protected WebElement testharnessTblDceLnk;

	@FindBy(xpath="//a[@id='contactUsAtdd']")
	protected WebElement ContactUsLnk;

	@FindBy(xpath = "//*[@ng-src='/images/icons/icon-pharmacy-locator.svg']")
	protected WebElement pharmacySearchLink;

	@FindBy(xpath = "//span[contains (text(), 'Look up Drugs')]")
	protected WebElement drugLookup;

	@FindBy(xpath="//header[@class='section-header']//a[contains(@class,'pharmacy-locator')]")
	protected WebElement section_pharmacySearchLink;

	@FindBy(xpath="//input[@id='zipcodeTxt']")
	protected WebElement pharmacySearchPgZipcodeField;

	@FindBy(xpath="//header[@class='section-header']//a[contains(@class,'drug-lookup')]")
	protected WebElement section_drugLocator;
	
	@FindBy(xpath = "//h1[contains(text(),'Drug')]")
	public WebElement dcePgHeaderTxt;

	
	@FindBy(xpath="//a[contains(@class,'btn') and contains(text(),'VIEW PLAN')]")
	protected WebElement preeff_goToPlanDocBtn;

	@FindBy(xpath="//button[contains(@id,'accountprofile') and @aria-expanded='false']")
	protected WebElement acctProfileBtn_closed;

	@FindBy(xpath="//button[contains(@id,'accountprofile') and @aria-expanded='true']")
	protected WebElement acctProfileBtn_expanded;

	@FindBy(xpath="//a[contains(@id,'accsettings')]")
	protected WebElement acctSettingsLnk;


	@FindBy(xpath= "//button[@id='accountprofile']")
	protected WebElement testHarn_AcctProfBtn;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//div[contains(@class,'dropdown') and contains(@class,'open')]//a[contains(@id,'ihr')]")
	protected WebElement testHarn_desktop_AcctProf_IHRLnk;

	//--------------------------
	@FindBy(xpath="//p[contains(@class,'siteleaving')]")
	protected WebElement siteLeavingPopup;

	@FindBy(xpath="//a[contains(@id,'proceedbtn')]")
	protected WebElement siteLeavingPopup_proceedBtn;

	@FindBy(xpath="//a[contains(@id,'cancelbtn')]")
	protected WebElement siteLeavingPopup_cancelBtn;

	@FindBy(xpath="//*[contains(text(),'Sorry')]")
	protected WebElement sorryError;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[not(contains(text(),'Supplement')) and not(contains(text(),'Prescription')) and contains(text(),'Medicare')]") 
	protected WebElement comboTab_MA;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[not(contains(text(),'Supplement')) and not(contains(text(),'Prescription')) and contains(text(),'Medicare')]") 
	protected WebElement comboTab_MA_planDoc;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Prescription') and contains(text(),'Medicare')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Prescription') and contains(text(),'Medicare')]") 
	protected WebElement comboTab_MAPD_planDoc;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Supplement')]") 
	protected WebElement comboTab_SHIP;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Supplement')]") 
	protected WebElement comboTab_SHIP_planDoc;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Hospital Indemnity')]") 
	protected WebElement comboTab_SHIP_HIP;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Hospital Indemnity')]") 
	protected WebElement comboTab_SHIP_HIP_planDoc;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(.,'Prescription') and not(contains(text(),'Medicare'))]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Prescription') and not(contains(text(),'Medicare'))]") 
	protected WebElement comboTab_PDP_planDoc;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSP;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Senior Supplement Plan')]")
	protected WebElement comboTab_SSP_planDoc;

	@FindBy(xpath="//div[contains(@class,'loading-block') and contains(@style,'block')]")
	protected WebElement loadingSpinner;

	@FindBy(xpath="//a[@id='preparefornextyear']")
	protected WebElement prepareForNextYearTab;
	
	@FindBy(xpath="//h1[contains(text(),'Prepare for Next Year')]")
	protected WebElement prepareForNextYearPgHeader;
	
	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]")
	protected WebElement tl_section;
	
	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//h2[contains(text(),'Dates to Remember')]")
	protected WebElement tl_sectionHeader;

	@FindBy(xpath="//h3[contains(text(),'Dates to Remember')]")
	protected WebElement tbd_tl_sectionHeader;
	
	@FindBy(xpath="//a[contains(text(),'RETURN TO PREVIOUS PAGE')]")
	protected WebElement returnToPrevPgLnk;
	
	@FindBy(xpath="//h1[contains(text(),'Plan Benefits Summary')]")
	protected WebElement benefitsPgHeaderText;
	
	@FindBy(xpath="//div[@class='loading-block' and contains(@style,'none')]")
	protected WebElement noLoadingSpinner;
	
	@FindBy(xpath="//div[@class='loading-block' and contains(@style,'display')]")
	protected WebElement loadingSpinnerOnScreen;
	
	@FindBy(xpath="//section[contains(@class,'disclaimer')]//strong[contains(text(),'This page contains PDF documents')]")
	protected WebElement adobePdfDocText;

	@FindBy(xpath="//section[contains(@class,'disclaimer')]//strong[contains(text(),'This page contains PDF documents')]/../a")
	protected WebElement adobeLink;

	@FindBy(xpath = "//a[contains(@id, 'proceedbtn')]")
	protected WebElement siteLeavingProceedButton;

	@FindBy(xpath = "//a[contains(@id, 'cancelbtn')]")
	protected WebElement siteLeavingCancelButton;

	//note: milestone1 for individual -------------------------------------
	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='September 15']")
	protected WebElement tl_milestone1Date_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='September 15']/../span[contains(@class,'date-content')]")
	protected WebElement tl_milestone1Text_ind;

	//tbd @FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='September 15']")
	//tbd protected WebElement tbd_tl_milestone1Date;

	//tbd @FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='September 15']/../label[contains(@class,'date-content')]")
	//tbd protected WebElement tbd_tl_milestone1Text;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][1]")
	protected WebElement tl_milestone1Line_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][1]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone1Dot_noBlue_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][1]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone1Dot_blue_ind;

	//note: milestone2 for individual -------------------------------------
	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='October 1']")
	protected WebElement tl_milestone2Date_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='October 1']/../span[contains(@class,'date-content')]")
	protected WebElement tl_milestone2Text_ind;

	//tbd @FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='October 1']")
	//tbd protected WebElement tbd_tl_milestone2Date;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='October 1']//span[contains(@class,'date-content')]")
	protected WebElement tbd_tl_milestone2Text;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][2]")
	protected WebElement tl_milestone2Line_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][2]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone2Dot_noBlue_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][2]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone2Dot_blue_ind;

	//note: milestone3 for individual -------------------------------------
	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='October 15']")
	protected WebElement tl_milestone3Date_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='October 15']/../span[contains(@class,'date-content')]")
	protected WebElement tl_milestone3Text_ind;

	//tbd @FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='October 15']")
	//tbd protected WebElement tbd_tl_milestone3Date;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='October 15']//span[contains(@class,'date-content')]")
	protected WebElement tbd_tl_milestone3Text;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][3]")
	protected WebElement tl_milestone3Line_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][3]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone3Dot_noBlue_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][3]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone3Dot_blue_ind;

	//note: milestone4 for individual -------------------------------------
	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='December 7']")
	protected WebElement tl_milestone4Date_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='December 7']/../span[contains(@class,'date-content')]")
	protected WebElement tl_milestone4Text_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='December 7']//span[contains(@class,'date-content')]")
	protected WebElement tl_milestone4Text_ind2;

	//tbd @FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='December 7']")
	//tbd protected WebElement tbd_tl_milestone4Date;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='December 7']//span[contains(@class,'date-content')]")
	protected WebElement tbd_tl_milestone4Text;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][4]")
	protected WebElement tl_milestone4Line_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][4]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone4Dot_noBlue_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][4]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone4Dot_blue_ind;

	//note: milestone5 for individual -------------------------------------
	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='January 1']")
	protected WebElement tl_milestone5Date_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='January 1']/../span[contains(@class,'date-content')]")
	protected WebElement tl_milestone5Text_ind;

	protected WebElement tl_milestone5Text_ind2;

	//tbd @FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='January 1']")
	//tbd protected WebElement tbd_tl_milestone5Date;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='January 1']//span[contains(@class,'date-content')]")
	protected WebElement tbd_tl_milestone5Text;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][5]")
	protected WebElement tl_milestone5Line_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][5]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone5Dot_noBlue_ind;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][3]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone5Dot_blue_ind;
	
	//note: milestone1 for sar -------------------------------------
	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='October 1']")
	protected WebElement tl_milestone1Date_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='October 1']/../span[contains(@class,'date-content')]")
	protected WebElement tl_milestone1Text_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][1]")
	protected WebElement tl_milestone1Line_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][1]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone1Dot_noBlue_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][1]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone1Dot_blue_sars;

	//note: milestone2 for sar -------------------------------------
	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='October 15']")
	protected WebElement tl_milestone2Date_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='October 15']/../span[contains(@class,'date-content')]")
	protected WebElement tl_milestone2Text_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][2]")
	protected WebElement tl_milestone2Line_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][2]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone2Dot_noBlue_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][2]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone2Dot_blue_sars;

	//note: milestone3 for dar -------------------------------------
	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='January 1']")
	protected WebElement tl_milestone3Date_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//span[text()='January 1']/../span[contains(@class,'date-content')]")
	protected WebElement tl_milestone3Text_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][3]")
	protected WebElement tl_milestone3Line_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][3]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone3Dot_noBlue_sars;

	@FindBy(xpath="//div[contains(@class,'Timeline') and not(contains(@class,'ng-hide'))]//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][3]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone3Dot_blue_sars;
	

	// note Find updates section -------------------------------
	@FindBy(xpath="//div[contains(@class,'findupdates')]")
	protected WebElement ind_findUpdatesSection;

	@FindBy(xpath="//div[contains(@class,'findupdates')]//h3")
	protected WebElement ind_findUpdatesSection_header;
	
	@FindBy(xpath="//div[contains(@class,'findupdates')]//p")
	protected WebElement ind_findUpdatesSection_text;

	@FindBy(xpath="//div[contains(@class,'Findupdates_Group')]")
	protected WebElement grp_findUpdatesSection;

	@FindBy(xpath="//div[contains(@class,'Findupdates_Group')]//h3")
	protected WebElement grp_findUpdatesSection_header;
	
	@FindBy(xpath="//div[contains(@class,'Findupdates_Group')]//p")
	protected WebElement grp_findUpdatesSection_text;

	@FindBy(xpath="//div[contains(@class,'findupdates_sar')]")
	protected WebElement sars_findUpdatesSection;

	@FindBy(xpath="//div[contains(@class,'findupdates_sar')]//h3")
	protected WebElement sars_findUpdatesSection_header;
	
	@FindBy(xpath="//div[contains(@class,'findupdates_sar')]//p")
	protected WebElement sars_findUpdatesSection_text;

	//note: ind - review plan changes
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub')]")
	protected WebElement ind_revPlnChgSec;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub') and not(contains(@class,'green'))]//span[contains(@class,'circle')]")
	protected WebElement ind_revPlnChgSec_circle_noGreen1;
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and not(contains(@class,'green'))]")
	protected WebElement ind_revPlnChgSec_circle_noGreen2;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub') and contains(@class,'green')]//span[contains(@class,'circle')]")
	protected WebElement ind_revPlnChgSec_circle_green1;
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and contains(@class,'green')]")
	protected WebElement ind_revPlnChgSec_circle_green2;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//h3")
	protected WebElement ind_revPlnChgSec_header;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//p//strong[contains(text(), 'September 30')]")
	protected WebElement indrevPlnChgSec_text;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]")
	protected WebElement ind_revPlnChgSec_docSec;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//select")
	protected WebElement ind_revPlnChgSec_docSec_langDropdown;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//select//option[@lang='en']")
	protected WebElement ind_revPlnChgSec_lang_en;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//select//option[@lang='es']")
	protected WebElement ind_revPlnChgSec_lang_es;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//select//option[@lang='zh']")
	protected WebElement ind_revPlnChgSec_lang_zh;

	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//select//option[@lang='en' and contains(@style,'block')]")
	protected WebElement ind_revPlnChgSec_lang_en_ava;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//select//option[@lang='es' and contains(@style,'block')]")
	protected WebElement ind_revPlnChgSec_lang_es_ava;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//select//option[@lang='zh' and contains(@style,'block')]")
	protected WebElement ind_revPlnChgSec_lang_zh_ava;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//i[contains(@class,'checkmarkSection') and not(contains(@class,'greenColor'))]")
	protected WebElement ind_revPlnChgSec_docSec_checkMark_noGreen;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//i[contains(@class,'checkmarkSection') and contains(@class,'greenColor')]")
	protected WebElement ind_revPlnChgSec_docSec_checkMark_green;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Compare your current plan')]")
	protected WebElement ind_revPlnChgSec_docSec_cmpYurCurrPlnLnk;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Compare your current plan')]/../i")
	protected WebElement ind_revPlnChgSec_docSec_cmpYurCurrPlnLnk_arrow;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//span[contains(text(),'or open')]")
	protected WebElement ind_revPlnChgSec_docSec_befAnocOr;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//span[contains(text(),'or open')]/../i")
	protected WebElement ind_revPlnChgSec_docSec_aftAnoc_arrow;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//span[contains(text(),'or open')]/*[name()='svg']")
	protected WebElement ind_revPlnChgSec_docSec_aftAnoc_svg;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Annual Notice of Changes')]")
	protected WebElement ind_revPlnChgSec_docSec_anoc_en;

	//tbd @FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'PDF')]/../i")
	//tbd protected WebElement ind_revPlnChgSec_docSec_anoc_bf_arrow;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Aviso')]")
	protected WebElement ind_revPlnChgSec_docSec_anoc_es;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Aviso')]/../i")
	protected WebElement ind_revPlnChgSec_docSec_anoc_es_arrow;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Aviso')]/*[name()='svg']")
	protected WebElement ind_revPlnChgSec_docSec_anoc_es_svg;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]")
	protected WebElement ind_revPlnChgSec_docSec_anoc_zh;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnChgSec_docSec_anoc_zh_arrow;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/*[name()='svg']")
	protected WebElement ind_revPlnChgSec_docSec_anoc_zh_svg;

	// individual - reivew plan materials

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub')]")
	protected WebElement ind_revPlnMatlsSec;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub') and not(contains(@class,'green'))]//span[contains(@class,'circle')]")
	protected WebElement ind_revPlnMatlsSec_circle_noGreen;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub') and contains(@class,'green')]//span[contains(@class,'circle')]")
	protected WebElement ind_revPlnMatlsSec_circle_green;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//h3")
	protected WebElement ind_revPlnMatlsSec_header;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//p//strong[contains(text(), 'October 15')]")
	protected WebElement indrevPlnMatlsSec_text;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplanmain')]")
	protected WebElement ind_revPlnMatlsSec_docSec;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//select")
	protected WebElement ind_revPlnMatlsSec_docSec_langDropdown;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//select//option[@lang='en']")
	protected WebElement ind_revPlnMatlsSec_lang_en;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//select//option[@lang='es']")
	protected WebElement ind_revPlnMatlsSec_lang_es;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//select//option[@lang='zh']")
	protected WebElement ind_revPlnMatlsSec_lang_zh;
	

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//select//option[@lang='en' and contains(@style,'block')]")
	protected WebElement ind_revPlnMatlsSec_lang_en_ava;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//select//option[@lang='es' and contains(@style,'block')]")
	protected WebElement ind_revPlnMatlsSec_lang_es_ava;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//select//option[@lang='zh' and contains(@style,'block')]")
	protected WebElement ind_revPlnMatlsSec_lang_zh_ava;
	
	//note: Review Plan Materials - Benefits
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplanmain')]//i[contains(@class,'checkmarkSection') and not(contains(@class,'greenColor'))]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_checkMark_noGreen;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplanmain')]//i[contains(@class,'checkmarkSection') and contains(@class,'greenColor')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_checkMark_green;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']//h4[contains(text(),'Review your plan benefits')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_Header;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']//h4[contains(text(),'Review your plan benefits')]/../div/p[contains(text(),'Find a complete list of')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_Text;

	//note: Review Plan Materials - Benefits - EOC
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(text(),'Evidence of Coverage')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_en;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(text(),'Evidence of Coverage')]/../i")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_en_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(text(),'Evidence of Coverage')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_en_svg;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(text(),'Comprobante de')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_es;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(text(),'Comprobante de')]/../i")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_es_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(text(),'Comprobante de')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_es_svg;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[contains(@class,'EOC')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_zh;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[contains(@class,'EOC')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_zh_arrow;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[contains(@class,'EOC')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_zh_svg;
	
	//note: Review Plan Materials - Prescription
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//i[contains(@class,'checkmarkSection') and not(contains(@class,'greenColor'))]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_checkMark_noGreen;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//i[contains(@class,'checkmarkSection') and contains(@class,'greenColor')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_checkMark_green;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'review-section')]//h4[contains(text(),'Review your Prescription drug')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_header;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'review-section')]//h4[contains(text(),'Review your Prescription drug')]/../div/p[contains(text(),'You can look up which drugs')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_text;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'formul') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Drug Search')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_drugSrchLnk;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'formul') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Drug Search')]/../i")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_drugSrchLnk_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'formul') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Drug Search')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_drugSrchLnk_svg;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Comprehensive Formulary')]/../span[contains(text(),'or open')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_en_OR;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Comprehensive Formulary')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_en;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Comprehensive Formulary')]/../i")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_en_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Comprehensive Formulary')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_en_svg;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Formulario')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_es;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Formulario')]/../i")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_es_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Formulario')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_es_svg;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'formulery')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_zh;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'formulery')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_zh_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'formulery')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_zh_svg;
	
	//note: Review Plan Materials - Provider Info
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//i[contains(@class,'checkmarkSection') and not(contains(@class,'greenColor'))]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_checkMark_noGreen;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//i[contains(@class,'checkmarkSection') and contains(@class,'greenColor')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_checkMark_green;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//div[contains(@class,'review-section')]//h4[contains(text(),'Review provider information')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_header;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//div[contains(@class,'review-section')]//h4[contains(text(),'Review provider information')]/../div/p[contains(text(),'See if your providers')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_text;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Search for Providers')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_provSrchLnk;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Search for Providers')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_provSrchLnk_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Search for Providers')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_provSrchLnk_svg;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Search for Providers')]/../span[contains(text(),'or open')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_en_OR;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Provider Directory')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_en;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Provider Directory')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_en_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Provider Directory')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_en_svg;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Directorio')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_es;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Directorio')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_es_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Directorio')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_es_svg;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[contains(@data-ng-if,'1027')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_zh;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[contains(@data-ng-if,'1027')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_zh_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[contains(@data-ng-if,'1027')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_zh_svg;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Vendor Information Sheet')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_en;
		
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Vendor Information Sheet')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_en_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Vendor Information Sheet')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_en_svg;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Informaci')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_es;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Informaci')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_es_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Informaci')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_es_svg;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//div[contains(@class,'provider')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_zh;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//div[contains(@class,'provider')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_zh_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//div[contains(@class,'provider')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_zh_svg;

	//note: Review Plan Materials - Pharmacy Info
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//i[contains(@class,'checkmarkSection') and not(contains(@class,'greenColor'))]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_checkMark_noGreen;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//i[contains(@class,'checkmarkSection') and contains(@class,'greenColor')]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_checkMark_green;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//div[contains(@class,'review-section')]//h4[contains(text(),'Review pharmacy information')]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_header;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//div[contains(@class,'review-section')]//h4[contains(text(),'Review pharmacy information')]/../div/p[contains(text(),'Review the')]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_text;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//div[contains(@class,'harmacy') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Find a Pharmacy')]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_pharSrchLnk;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//div[contains(@class,'harmacy') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Find a Pharmacy')]/../i")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_pharSrchLnk_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//a[contains(text(),'Pharmacy Directory Information')]/../span[contains(text(),'or open')]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_en_OR;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//a[contains(text(),'Pharmacy Directory Information')]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_en;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//a[contains(text(),'Pharmacy Directory Information')]/../i")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_en_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//a[contains(text(),'Pharmacy Directory Information')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_en_svg;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//a[contains(text(),'Informaci')]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_es;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//a[contains(text(),'Informaci')]/../i")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_es_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//a[contains(text(),'Informaci')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_es_svg;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//div[contains(@class,'Pharmacy')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_zh;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//div[contains(@class,'Pharmacy')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_zh_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//div[contains(@class,'Pharmacy')]//div[contains(@data-ng-if,'zh')]//a[contains(text(),'PDF')]/*[name()='svg']")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_zh_svg;

	//note: Compare plans online
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'review-sub')]")
	protected WebElement ind_compPlnsSec;
	
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and not(contains(@class,'green'))]")
	protected WebElement ind_compPlnsSec_circle_noGreen;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and contains(@class,'green')]")
	protected WebElement ind_compPlnsSec_circle_green;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//h3")
	protected WebElement ind_compPlnsSec_header;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//p//strong[contains(text(), 'October 1')]")
	protected WebElement ind_compPlnsSec_text;
	
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec;
	
	//note: Compare plans online - Learn about other plan choices
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices')]//i[contains(@class,'checkmarkSection') and not(contains(@class,'greenColor'))]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_checkMark_noGreen;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices')]//i[contains(@class,'checkmarkSection') and contains(@class,'greenColor')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_checkMark_green;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices_ind')]//h4[contains(text(),'Learn about')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_header;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices_ind')]//h4[contains(text(),'Learn about')]/../div/p[contains(text(),'If you are happy with your current plan')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_text;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices_ind')]//a[contains(text(),'Skip this step')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_skipThisLnk;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices_ind')]//a[contains(text(),'Skip this step')]/../i")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_skipThisLnk_arrow;
	
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices_ind')]//a[contains(text(),'Skip this step')]/*[name()='svg']")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_skipThisLnk_svg;
	
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices_ind')]//a[contains(text(),'Compare with')]/../span[contains(text(),'or')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_OR;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices_ind')]//a[contains(text(),'Compare with')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk;
	
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices_ind')]//a[contains(text(),'Compare with')]/../i")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_arrow;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices_ind')]//a[contains(text(),'Compare with')]/*[name()='svg']")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_svg;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices_ind')]//p[contains(text(),'You have selected')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_selectedPlan_text;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Ind')]//div[contains(@class,'planchoices_ind')]//p[contains(text(),'You have selected')]/strong")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_selectedPlan_planName;

	//note: Enroll in the plan that works for you
	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'review-sub')]")
	protected WebElement ind_enrolPlnSec;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and not(contains(@class,'green'))]")
	protected WebElement ind_enrolPlnSec_circle_noGreen;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and contains(@class,'green')]")
	protected WebElement ind_enrolPlnSec_circle_green;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//h3")
	protected WebElement ind_enrolPlnSec_header;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//p//strong[contains(text(), 'October 15')]")
	protected WebElement ind_enrolPlnSec_text;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'anocavailable')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec;
	
	//note: Enroll in the plan that works for you - Choose your plan
	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'anocavailable')]//i[contains(@class,'checkmarkSection') and not(contains(@class,'greenColor'))]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_checkMark_noGreen;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'anocavailable')]//i[contains(@class,'checkmarkSection') and contains(@class,'greenColor')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_checkMark_green;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'anocavailable')]//h4[contains(text(),'Choose your plan')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_header;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'anocavailable')]//h4[contains(text(),'Choose your plan')]/../div/p[contains(text(),'Decide if you want to stay')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_text;

	//note: Enroll in the plan that works for you - Choose your plan - Stay in plan
	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//a[contains(text(),'Stay in current plan')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//a[contains(text(),'Stay in current plan ')]/../i[1]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk_arrow;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//a[contains(text(),'Stay in current plan ')]/*[name()='svg']")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk_svg;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//p[1]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_OR;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//a[contains(text(),'Compare with')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//a[contains(text(),'Compare with')]/../i")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_arrow;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//a[contains(text(),'Compare with')]/*[name()='svg']")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_svg;
	
	//note: Enroll in the plan that works for you - Choose your plan - You selected Plan Name
	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'newplan_id1')]//p[contains(text(),'You selected')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_seleNewPln_text;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'newplan_id1')]//p[contains(text(),'You selected')]/strong")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_seleNewPln_planName;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//p[2]//a[contains(text(),'Compare with')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_seleNewPln_compNewPlnsLnk;
	
	//note: Enroll in the plan that works for you - Choose your plan - You will stay in your current plan
	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'currentplan') and not(contains(@class,'ng-hide'))]//p[contains(text(),'You will stay in')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInCurrPln_text;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_ind')]//div[contains(@class,'currentplan') and not(contains(@class,'ng-hide'))]//p[contains(text(),'You will stay in')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInCurrPln_planName;

	
	
	//note: aarp acq site zipcode input box
	@FindBy(xpath="//input[@id='cta-zipcode']")
	protected WebElement zipCodeField_acq;
	
	//note: provider search page
	@FindBy(xpath="//h1/span[contains(text(),'Enter')]")
	protected WebElement providerSearchHeaderTxt;
	
	//note: Drug Search page
	@FindBy(xpath="//h1[contains(@class,'h1')]")
	protected WebElement dceHeader;
	
	//note: Pharmacy Locator page
	@FindBy(xpath = "//h1[contains(@id, 'pharmacylocatorheader')]")
	protected WebElement pharmacyHeader;
	
	//note: Acq compare plan
	@FindBy(xpath="//div[contains(@class,'plan-overview-wrapper')]")
	protected WebElement acqPlanOverviewBox;
	
	//note: Acq popup exit
	@FindBy(xpath="//button[contains(text(),'Exit')]")
	protected WebElement acqPopupExit;
	
	//=======================================================================================
	//note: group - review plan documents
	//note: should not have
	@FindBy(xpath="//div[contains(@class,'Compareplansonline') and not(contains(@class,'ng-hide'))]")
	protected WebElement grp_comparePlanOnlineSection;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan') and not(contains(@class,'ng-hide'))]")
	protected WebElement grp_enrollPlanSection;

	//note: review plan documents section
	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']")
	protected WebElement grp_reviewPlanDocsSection;
	
	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub') and not(contains(@class,'green'))]//span[@class='circle']")
	protected WebElement grp_reviewPlanDocs_circle_noGreen;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub') and contains(@class,'green')]//span[@class='circle']")
	protected WebElement grp_reviewPlanDocs_circle_green;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//h3")
	protected WebElement grp_reviewPlanDocs_header;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//p[contains(text(),'Read your plan documents to make sure')]")
	protected WebElement grp_reviewPlanDocs_text;
	
	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]")
	protected WebElement grp_reviewPlanDocs_docSection;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//select")
	protected WebElement grp_reviewPlanDocs_docSection_langDropdown;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//select//option[@lang='en' and contains(@style,'block')]")
	protected WebElement grp_reviewPlanDocs_lang_en_ava;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//select//option[@lang='es' and contains(@style,'block')]")
	protected WebElement grp_reviewPlanDocs_lang_es_ava;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//select//option[@lang='zh' and contains(@style,'block')]")
	protected WebElement grp_reviewPlanDocs_lang_zh_ava;
	
	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//select//option[@lang='en']")
	protected WebElement grp_reviewPlanDocs_lang_en;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//select//option[@lang='es']")
	protected WebElement grp_reviewPlanDocs_lang_es;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//select//option[@lang='zh']")
	protected WebElement grp_reviewPlanDocs_lang_zh;
	
	//note: Subsection - Review your plan changes for next year
	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'annualNoticeDocuments ')]/div[contains(@class,'anocavailable')]//i[contains(@class,'checkmarkSection') and not(contains(@class,'greenColor'))]")
	protected WebElement grp_revPlnDocsSec_plnChngSec_checkMark_noGreen;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'annualNoticeDocuments ')]/div[contains(@class,'anocavailable')]//i[contains(@class,'checkmarkSection') and contains(@class,'greenColor')]")
	protected WebElement grp_revPlnDocsSec_plnChngSec_checkMark_green;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'annualNoticeDocuments ')]/div[contains(@class,'anocavailable')]//h4")
	protected WebElement grp_revPlnDocsSec_plnChngSec_Header;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'annualNoticeDocuments ')]//div[contains(@class,'Review_PlanCh_Group')]//a[contains(text(),'Annual')]")
	protected WebElement grp_revPlnDocsSec_plnChngSec_anoc_en;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'annualNoticeDocuments ')]//div[contains(@class,'Review_PlanCh_Group')]//a[contains(text(),'Annual')]/../i")
	protected WebElement grp_revPlnDocsSec_plnChngSec_anoc_en_arrow;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'annualNoticeDocuments ')]//div[contains(@class,'Review_PlanCh_Group')]//a[contains(text(),'Annual')]/*[name()='svg']")
	protected WebElement grp_revPlnDocsSec_plnChngSec_anoc_en_svg;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'annualNoticeDocuments ')]//div[contains(@class,'Review_PlanCh_Group')]//a[contains(text(),'Evidence')]")
	protected WebElement grp_revPlnDocsSec_plnChngSec_eoc_en;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'annualNoticeDocuments ')]//div[contains(@class,'Review_PlanCh_Group')]//a[contains(text(),'Evidence')]/../i")
	protected WebElement grp_revPlnDocsSec_plnChngSec_eoc_en_arrow;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'annualNoticeDocuments ')]//div[contains(@class,'Review_PlanCh_Group')]//a[contains(text(),'Evidence')]/*[name()='svg']")
	protected WebElement grp_revPlnDocsSec_plnChngSec_eoc_en_svg;

	//note: review pharmacy information section
	@FindBy(xpath="//div[contains(@class,'ReviewPharmacy_Group')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']")
	protected WebElement grp_reviewPharInfoSection;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPharmacy_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and not(contains(@class,'green'))]")
	protected WebElement grp_reviewPharInfo_circle_noGreen;

	@FindBy(xpath="//div[contains(@class,'ReviewPharmacy_Group')]//div[contains(@class,'reviewplans')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and contains(@class,'green')]")
	protected WebElement grp_reviewPharInfo_circle_green;

	@FindBy(xpath="//div[contains(@class,'ReviewPharmacy_Group')]//h3")
	protected WebElement grp_reviewPharInfo_header;

	@FindBy(xpath="//div[contains(@class,'ReviewPharmacy_Group')]//p[contains(text(),'Pharmacy Locator to see')]")
	protected WebElement grp_reviewPharInfo_text;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPharmacy_Group')]//div[contains(@class,'pharmacyLink_group')]")
	protected WebElement grp_reviewPharInfo_docSection;

	//note: Subsection - Review your pharmacy information for next year
	@FindBy(xpath="//div[contains(@class,'ReviewPharmacy_Group')]//div[contains(@class,'pharmacyLink_group')]//a[contains(text(),'Find a Pharmacy')]/../i")
	protected WebElement grp_revPlnDocsSec_pharInfoSec_pharSrchLnk_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPharmacy_Group')]//div[contains(@class,'pharmacyLink_group')]//a[contains(text(),'Find a Pharmacy')]//i")
	protected WebElement grp_revPlnDocsSec_pharInfoSec_pharSrchLnk_arrow2;

	@FindBy(xpath="//div[contains(@class,'ReviewPharmacy_Group')]//div[contains(@class,'pharmacyLink_group')]//a[contains(text(),'Find a Pharmacy')]/*[name()='svg']")
	protected WebElement grp_revPlnDocsSec_pharInfoSec_pharSrchLnk_svg;

	@FindBy(xpath="//div[contains(@class,'ReviewPharmacy_Group')]//div[contains(@class,'pharmacyLink_group')]//a[contains(text(),'Find a Pharmacy')]")
	protected WebElement grp_revPlnDocsSec_pharInfoSec_pharSrchLnk;

	//=======================================================================================
	//note: SAR - Compare plan Enroll Plan
	@FindBy(xpath="//div[contains(@class,'Compareplansonline') and not(contains(@class,'ng-hide'))]")
	protected WebElement sars_comparePlanOnlineSection;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan') and not(contains(@class,'ng-hide'))]")
	protected WebElement sars_enrollPlanSection;

	//note: Compare plans online
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'review-sub')]")
	protected WebElement sars_compPlnsSec;
	
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and not(contains(@class,'green'))]")
	protected WebElement sars_compPlnsSec_circle_noGreen;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and contains(@class,'green')]")
	protected WebElement sars_compPlnsSec_circle_green;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//h3")
	protected WebElement sars_compPlnsSec_header;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//p//strong[contains(text(), 'October 1')]")
	protected WebElement sars_compPlnsSec_text;
	
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices')]")
	protected WebElement sars_compPlnsSec_lrnOthPlnSec;
	
	//note: Compare plans online - Learn about other plan choices
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices_sars')]//i[contains(@class,'checkmarkSection') and not(contains(@class,'greenColor'))]")
	protected WebElement sars_compPlnsSec_lrnOthPlnSec_checkMark_noGreen;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices_sars')]//i[contains(@class,'checkmarkSection') and contains(@class,'greenColor')]")
	protected WebElement sars_compPlnsSec_lrnOthPlnSec_checkMark_green;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices_sars')]//h4[contains(text(),'Learn about')]")
	protected WebElement sars_compPlnsSec_lrnOthPlnSec_header;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices_sars')]//h4[contains(text(),'Learn about')]/../div/p[contains(text(),'Check coverage and costs of plans in your area')]")
	protected WebElement sars_compPlnsSec_lrnOthPlnSec_text;

	//tbd @FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices_sars')]//a[contains(text(),'Skip this step')]")
	//tbd protected WebElement sars_compPlnsSec_lrnOthPlnSec_skipThisLnk;

	//tbd @FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices_sars')]//a[contains(text(),'Skip this step')]/../i")
	//tbd protected WebElement sars_compPlnsSec_lrnOthPlnSec_skipThisLnk_arrow;
	
	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices_sars')]//a[contains(text(),'Compare with')]/../span[contains(text(),'or')]")
	protected WebElement sars_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_OR;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices_sars')]//a[contains(text(),'Compare with')]")
	protected WebElement sars_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices_sars')]//a[contains(text(),'Compare with')]/../i")
	protected WebElement sars_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_arrow;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices_sars')]//p[contains(text(),'You have selected')]")
	protected WebElement sars_compPlnsSec_lrnOthPlnSec_selectedPlan_text;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline_Sars')]//div[contains(@class,'planchoices_sars')]//p[contains(text(),'You have selected')]/strong")
	protected WebElement sars_compPlnsSec_lrnOthPlnSec_selectedPlan_planName;

	//note: Enroll in the plan that works for you
	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'review-sub')]")
	protected WebElement sars_enrolPlnSec;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and not(contains(@class,'green'))]")
	protected WebElement sars_enrolPlnSec_circle_noGreen;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'review-sub')]//span[contains(@class,'circle') and contains(@class,'green')]")
	protected WebElement sars_enrolPlnSec_circle_green;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//h3")
	protected WebElement sars_enrolPlnSec_header;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//p//strong[contains(text(), 'October 1')]")
	protected WebElement sars_enrolPlnSec_text;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'anocavailable')]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec;
	
	//note: Enroll in the plan that works for you - Choose your plan
	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'anocavailable')]//i[contains(@class,'checkmarkSection') and not(contains(@class,'greenColor'))]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_checkMark_noGreen;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'anocavailable')]//i[contains(@class,'checkmarkSection') and contains(@class,'greenColor')]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_checkMark_green;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'anocavailable')]//h4[contains(text(),'Choose your plan')]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_header;

	//tbd @FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'anocavailable')]//h4[contains(text(),'Choose your plan')]/../div/p[contains(text(),'Decide if you want to stay')]")
	//tbd protected WebElement sars_enrolPlnSec_choYurPlnSec_text;

	//note: Enroll in the plan that works for you - Choose your plan - Stay in plan
	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//a[contains(text(),'Stay in current plan')]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_stayInPlnLnk;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//a[contains(text(),'Stay in current plan ')]/../i[1]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_stayInPlnLnk_arrow;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//p[1]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_OR;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//a[contains(text(),'Compare with')]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//a[contains(text(),'Compare with')]/../i")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_arrow;

	//note: Enroll in the plan that works for you - Choose your plan - You selected Plan Name
	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'newplan_id1')]//p[contains(text(),'You selected')]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_seleNewPln_text;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'newplan_id1')]//p[contains(text(),'You selected')]/strong")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_seleNewPln_planName;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//p[2]//a[contains(text(),'Compare with')]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_seleNewPln_compNewPlnsLnk;
	
	//note: Enroll in the plan that works for you - Choose your plan - You will stay in your current plan
	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'currentplan') and not(contains(@class,'ng-hide'))]//p[contains(text(),'You will stay in')]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_stayInCurrPln_text;

	@FindBy(xpath="//div[contains(@class,'Enrollplan_Sars')]//div[contains(@class,'currentplan') and not(contains(@class,'ng-hide'))]//p[contains(text(),'You will stay in')]")
	protected WebElement sars_enrolPlnSec_choYurPlnSec_stayInCurrPln_planName;

	//=======================================================================================
	@FindBy(xpath="//div[@ng-if='error' and contains(text(),'system error')]")
	protected WebElement systemError;
	
	//=======================================================================================
	//note: bookmark related
	@FindBy(xpath="//div[@id='error_block']//p")
	protected WebElement bookmarkErrMsg;
	
	@FindBy(xpath="//div[@id='error_block']//a[contains(text(),'HOME PAGE') or contains(text(),'Home Page')  or contains(text(),'Home page')]")
	protected WebElement bookmarkErrPgGoBackHome;
	
}