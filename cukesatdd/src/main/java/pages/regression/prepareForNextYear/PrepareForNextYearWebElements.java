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

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'findcare')]")
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

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Prescription') and not(contains(text(),'Medicare'))]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Prescription') and not(contains(text(),'Medicare'))]") 
	protected WebElement comboTab_PDP_planDoc;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSP;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Senior Supplement Plan')]")
	protected WebElement comboTab_SSP_planDoc;
	
	@FindBy(xpath="//a[@id='preparefornextyear']")
	protected WebElement prepareForNextYearTab;
	
	@FindBy(xpath="//h1[contains(text(),'Prepare for Next Year')]")
	protected WebElement prepareForNextYearPgHeader;
	
	@FindBy(xpath="//div[contains(@class,'timeline section')]")
	protected WebElement tl_section;
	
	@FindBy(xpath="//h3[contains(text(),'Dates to Remember')]")
	protected WebElement tl_sectionHeader;

	@FindBy(xpath="//a[contains(text(),'RETURN TO PREVIOUS PAGE')]")
	protected WebElement returnToPrevPgLnk;
	
	@FindBy(xpath="//h1[contains(text(),'Plan Benefits Summary')]")
	protected WebElement benefitsPgHeaderText;
	
	@FindBy(xpath="//div[@class='loading-block' and contains(@style,'none')]")
	protected WebElement noLoadingSpinner;
	
	@FindBy(xpath="//section[contains(@class,'disclaimer')]//strong[contains(text(),'This page contains PDF documents')]")
	protected WebElement adobePdfDocText;

	@FindBy(xpath="//section[contains(@class,'disclaimer')]//strong[contains(text(),'This page contains PDF documents')]/../a")
	protected WebElement adobeLink;

	
	//note: milestone1 -------------------------------------
	@FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='September 15']")
	protected WebElement tl_milestone1Date;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='September 15']/../label[contains(@class,'date-content')]")
	protected WebElement tl_milestone1Text;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][1]")
	protected WebElement tl_milestone1Line;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][1]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone1Dot_noBlue;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][1]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone1Dot_blue;

	//note: milestone2 -------------------------------------
	@FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='October 1']")
	protected WebElement tl_milestone2Date;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='October 1']/../label[contains(@class,'date-content')]")
	protected WebElement tl_milestone2Text;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][2]")
	protected WebElement tl_milestone2Line;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][2]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone2Dot_noBlue;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][2]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone2Dot_blue;

	//note: milestone3 -------------------------------------
	@FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='October 15']")
	protected WebElement tl_milestone3Date;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='October 15']/../label[contains(@class,'date-content')]")
	protected WebElement tl_milestone3Text;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][3]")
	protected WebElement tl_milestone3Line;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][3]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone3Dot_noBlue;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][3]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone3Dot_blue;

	//note: milestone4 -------------------------------------
	@FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='December 7']")
	protected WebElement tl_milestone4Date;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='December 7']/../label[contains(@class,'date-content')]")
	protected WebElement tl_milestone4Text;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][4]")
	protected WebElement tl_milestone4Line;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][4]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone4Dot_noBlue;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][4]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone4Dot_blue;

	//note: milestone5 -------------------------------------
	@FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='January 1']")
	protected WebElement tl_milestone5Date;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//label[text()='January 1']/../label[contains(@class,'date-content')]")
	protected WebElement tl_milestone5Text;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][5]")
	protected WebElement tl_milestone5Line;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][5]//div[contains(@class,'stepper-circle') and not(contains(@class,'stepper-circle-blue'))]//i")
	protected WebElement tl_milestone5Dot_noBlue;

	@FindBy(xpath="//div[contains(@class,'timeline section')]//div[contains(@class,'outer-div')][3]//div[contains(@class,'stepper-circle') and contains(@class,'stepper-circle-blue')]//i")
	protected WebElement tl_milestone5Dot_blue;

	// note Find updates section -------------------------------
	@FindBy(xpath="//div[contains(@class,'findupdates')]")
	protected WebElement findUpdatesSection;

	@FindBy(xpath="//div[contains(@class,'findupdates')]//h3")
	protected WebElement findUpdatesSection_header;
	
	@FindBy(xpath="//div[contains(@class,'findupdates')]//p")
	protected WebElement findUpdatesSection_text;

	//note: ind - review plan changes
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']")
	protected WebElement ind_revPlnChgSec;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']//span[@class='circle']")
	protected WebElement ind_revPlnChgSec_circle;

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
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//i[contains(@class,'checkmarkSection')]")
	protected WebElement ind_revPlnChgSec_docSec_checkMark;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Compare your current plan')]")
	protected WebElement ind_revPlnChgSec_docSec_cmpYurCurrPlnLnk;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Compare your current plan')]/../i")
	protected WebElement ind_revPlnChgSec_docSec_cmpYurCurrPlnLnk_arrow;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//span[contains(text(),'or open')]")
	protected WebElement ind_revPlnChgSec_docSec_befAnocOr;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//span[contains(text(),'or open')]/../i")
	protected WebElement ind_revPlnChgSec_docSec_aftAnoc_arrow;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Annual Notice of Changes')]")
	protected WebElement ind_revPlnChgSec_docSec_anoc_en;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Annual Notice of Changes')]/../i")
	protected WebElement ind_revPlnChgSec_docSec_anoc_en_arrow;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Aviso')]")
	protected WebElement ind_revPlnChgSec_docSec_anoc_es;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(text(),'Aviso')]/../i")
	protected WebElement ind_revPlnChgSec_docSec_anoc_es_arrow;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]")
	protected WebElement ind_revPlnChgSec_docSec_anoc_zh;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnChgSec_docSec_anoc_zh_arrow;

	// individual - reivew plan materials

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']")
	protected WebElement ind_revPlnMatlsSec;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']//span[@class='circle']")
	protected WebElement ind_revPlnMatlsSec_circle;

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
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplanmain')]//i[contains(@class,'checkmarkSection')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_checkMark;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']//h4[contains(text(),'Review your plan benefits')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_Header;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']//h4[contains(text(),'Review your plan benefits')]/../div/p[contains(text(),'Find a complete list of')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_Text;

	//note: Review Plan Materials - Benefits - EOC
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(text(),'Evidence of Coverage')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_en;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(text(),'Evidence of Coverage')]/../i")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_en_arrow;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(text(),'Comprobante de')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_es;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(text(),'Comprobante de')]/../i")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_es_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_zh;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'reviewplans')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnMatlsSec_plnBeneSec_eoc_zh_arrow;
	
	//note: Review Plan Materials - Prescription
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//i[contains(@class,'checkmarkSection')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_checkMark;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'review-section')]//h4[contains(text(),'Review your Prescription drug')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_header;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'review-section')]//h4[contains(text(),'Review your Prescription drug')]/../div/p[contains(text(),'You can look up which drugs')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_text;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'formul') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Drug Search')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_drugSrchLnk;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//div[contains(@class,'formul') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Drug Search')]/../i")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_drugSrchLnk_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Comprehensive Formulary')]/../span[contains(text(),'or open')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_en_OR;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Comprehensive Formulary')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_en;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Comprehensive Formulary')]/../i")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_en_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Formulario')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_es;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(text(),'Formulario')]/../i")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_es_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_zh;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'prescription_mapd_pdp')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnMatlsSec_presDrugSec_cf_zh_arrow;

	//note: Review Plan Materials - Provider Info
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//i[contains(@class,'checkmarkSection')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_checkMark;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//div[contains(@class,'review-section')]//h4[contains(text(),'Review provider information')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_header;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//div[contains(@class,'review-section')]//h4[contains(text(),'Review provider information')]/../div/p[contains(text(),'See if your providers')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_text;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Search for Providers')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_provSrchLnk;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Search for Providers')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_provSrchLnk_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Provider Directory')]/../span[contains(text(),'or open')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_en_OR;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Provider Directory')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_en;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Provider Directory')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_en_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Directorio')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_es;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Directorio')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_es_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_zh;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_pr_zh_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Vendor Information Sheet')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_en;
	
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Vendor Information Sheet')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_en_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Informaci')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_es;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(text(),'Informaci')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_es_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_zh;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'Reviewprovider_MA_MAPD')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnMatlsSec_provInfoSec_ve_zh_arrow;

	//note: Review Plan Materials - Pharmacy Info
	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//i[contains(@class,'checkmarkSection')]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_checkMark;

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

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//a[contains(text(),'Informaci')]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_es;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//a[contains(text(),'Informaci')]/../i")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_es_arrow;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_zh;

	@FindBy(xpath="//div[contains(@class,'ReviewPlanMaterials_Ind')]//div[contains(@class,'pharmacy_MAPD_PDP')]//a[contains(@ng-if,'zh') and contains(text(),'PDF')]/../i")
	protected WebElement ind_revPlnMatlsSec_pharInfoSec_ph_zh_arrow;

	//note: Compare plans online
	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//div[@class='review-sub']")
	protected WebElement ind_compPlnsSec;
	
	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//div[@class='review-sub']//span[@class='circle']")
	protected WebElement ind_compPlnsSec_circle;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//h3")
	protected WebElement ind_compPlnsSec_header;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//p//strong[contains(text(), 'October 1')]")
	protected WebElement ind_compPlnsSec_text;
	
	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//div[contains(@class,'planchoices')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec;
	
	//note: Compare plans online - Learn about other plan choices
	@FindBy(xpath="//div[contains(@class,'otherPages Compareplansonline')]//div[contains(@class,'planchoices')]//i[contains(@class,'checkmarkSection')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_checkMark;

	@FindBy(xpath="//div[contains(@class,'otherPages Compareplansonline')]//div[contains(@class,'planchoices')]//h4[contains(text(),'Learn about other plan choices')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_header;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//div[contains(@class,'planchoices')]//h4[contains(text(),'Learn about other plan choices')]/../div/p[contains(text(),'If you are happy with your current plan')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_text;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//div[contains(@class,'planchoices')]//a[contains(text(),'Skip this step')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_skipThisLnk;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//div[contains(@class,'planchoices')]//a[contains(text(),'Skip this step')]/../i")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_skipThisLnk_arrow;
	
	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//div[contains(@class,'planchoices')]//a[contains(text(),'Skip this step')]/../span[contains(text(),'or open')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_OR;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//div[contains(@class,'planchoices')]//a[contains(text(),'Compare for')]")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk;

	@FindBy(xpath="//div[contains(@class,'Compareplansonline')]//div[contains(@class,'planchoices')]//a[contains(text(),'Compare for')]/../i")
	protected WebElement ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_arrow;

	//note: Enroll in the plan that works for you
	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//div[@class='review-sub']")
	protected WebElement ind_enrolPlnSec;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//div[@class='review-sub']//span[@class='circle']")
	protected WebElement ind_enrolPlnSec_circle;

	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//h3")
	protected WebElement ind_enrolPlnSec_header;

	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//p//strong[contains(text(), 'October 15')]")
	protected WebElement ind_enrolPlnSec_text;
	
	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//div[contains(@class,'anocavailable')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec;
	
	//note: Enroll in the plan that works for you - Choose your plan
	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//div[contains(@class,'anocavailable')]//i[contains(@class,'checkmarkSection')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_checkMark;

	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//div[contains(@class,'anocavailable')]//h4[contains(text(),'Choose your plan')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_header;

	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//div[contains(@class,'anocavailable')]//h4[contains(text(),'Choose your plan')]/../div/p[contains(text(),'Decide if you want to stay')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_text;

	//note: Enroll in the plan that works for you - Choose your plan - Stay in plan
	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//a[contains(text(),'Stay in current plan')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk;

	@FindBy(xpath="//div[contains(@class,'enrollinaPlan')]//a[contains(text(),'Stay in current plan ')]/../i[1]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk_arrow;
	
	@FindBy(xpath="//div[contains(@class,'enrollinaPlan')]//p[1]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_OR;

	@FindBy(xpath="//div[contains(@class,'enrollinaPlan')]//p[1]//a[contains(text(),'Compare for')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk;

	@FindBy(xpath="//div[contains(@class,'enrollinaPlan')]//p[1]//a[contains(text(),'Compare for')]/../i[2]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_arrow;

	//note: Enroll in the plan that works for you - Choose your plan - You selected Plan Name
	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//div[contains(@class,'newplan')]//p[contains(text(),'You selected Plan Name')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_seleNewPln_text;

	@FindBy(xpath="//div[contains(@class,'enrollinaPlan')]//p[2]//a[contains(text(),'Compare for')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_seleNewPln_compNewPlnsLnk;
	
	//note: Enroll in the plan that works for you - Choose your plan - You will stay in your current plan
	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//div[contains(@class,'currentplan') and not(contains(@class,'ng-hide'))]//p[contains(text(),'You will stay in')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInCurrPln_text;

	@FindBy(xpath="//div[contains(@class,'Enrollplan')]//div[contains(@class,'currentplan') and not(contains(@class,'ng-hide'))]//p[contains(text(),'You will stay in')]")
	protected WebElement ind_enrolPlnSec_choYurPlnSec_stayInCurrPln_planName;
	
	//note: aarp acq site zipcode input box
	@FindBy(xpath="//input[@id='cta-zipcode']")
	protected WebElement zipCodeField_acq;
	
	//note: provider search page
	@FindBy(xpath="//h1[contains(text(),'What')]")
	protected WebElement providerSearchHeaderTxt;
	
	//note: Drug Search page
	@FindBy(xpath="//h1[contains(@class,'heading')]")
	protected WebElement dceHeader;
	
	//note: Pharmacy Locator page
	@FindBy(xpath = "//h1[contains(@id, 'pharmacylocatorheader')]")
	protected WebElement pharmacyHeader;
	
	
	/* TODO
	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][3]")
	protected WebElement comparePlanOnline;
	
	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][3]//i[contains(@class,'circle')]")
	protected WebElement comparePlanOnline_circle;
	
	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][3]//div[@class='review-section']//h4[text()='Compare plans online']")
	protected WebElement comparePlanOnline_header;
	
	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][3]//p[@class='review-section-text']")
	protected WebElement comparePlanOnline_text;

	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][4]")
	protected WebElement enrollInPlan;
	
	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][4]//i[contains(@class,'circle')]")
	protected WebElement enrollInPlan_circle;
	
	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][4]//div[@class='review-section']//h4[text()='Enroll in the plan that works for you']")
	protected WebElement enrollInPlan_header;
	
	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][4]//p[@class='review-section-text']")
	protected WebElement enrollInPlan_text;
	*/
	
	//TODO
	//note: group - review plan changes
	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplansMain')]//div[@class='review-sub']")
	protected WebElement grp_reviewPlanChangesSection;
	
	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'reviewplansMain')]//div[@class='review-sub']//span[@class='circle']")
	protected WebElement grp_reviewPlanChanges_circle;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//h3")
	protected WebElement grp_reviewPlanChanges_header;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//p//strong[contains(text(), 'September 30')]")
	protected WebElement grp_reviewPlanChanges_text;
	
	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'documentsMain')]")
	protected WebElement grp_reviewPlanChanges_docSection;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'documentsMain')]//select")
	protected WebElement grp_reviewPlanChanges_docSection_langDropdown;

	@FindBy(xpath="//div[contains(@class,'Reviewplandocuments_Group')]//div[contains(@class,'documentsMain')]//i[contains(@class,'checkmarkSection')]")
	protected WebElement grp_reviewPlanChanges_docSection_checkMark;
	

	@FindBy(xpath="//div[@id='error_block']//p")
	protected WebElement bookmarkErrMsg;
	
	@FindBy(xpath="//div[@id='error_block']//a[contains(text(),'HOME PAGE') or contains(text(),'Home Page')  or contains(text(),'Home page')]")
	protected WebElement bookmarkErrPgGoBackHome;
	
}