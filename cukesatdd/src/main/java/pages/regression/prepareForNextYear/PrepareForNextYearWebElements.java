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

	//note: ind
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']")
	protected WebElement ind_reviewPlanChangesSection;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'reviewplans')]//div[@class='review-sub']//span[@class='circle']")
	protected WebElement ind_reviewPlanChanges_circle;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//h3")
	protected WebElement ind_reviewPlanChanges_header;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//p//strong[contains(text(), 'September 30')]")
	protected WebElement ind_reviewPlanChanges_text;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]")
	protected WebElement ind_reviewPlanChanges_docSection;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//select")
	protected WebElement ind_reviewPlanChanges_docSection_langDropdown;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//select//option[@lang='en']")
	protected WebElement ind_lang_english;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//select//option[@lang='es']")
	protected WebElement ind_lang_spanish;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//select//option[@lang='zh']")
	protected WebElement ind_lang_chinese;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//i[contains(@class,'checkmarkSection')]")
	protected WebElement ind_reviewPlanChanges_docSection_checkMark;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@class,'anocavailable')]//a[contains(text(),'Compare your current plan')]")
	protected WebElement ind_reviewPlanChanges_docSection_preCompareYourCurrentPlanLnk;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@class,'anocavailable')]//div[@class='orText']")
	protected WebElement ind_reviewPlanChanges_docSection_preOrTextForAnoc;
	
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@class,'anocavailable')]//div[@data-ng-if='displayanaoc']//div[contains(@class,'review-section-inner') and contains(text(),'Open Annual Notice of Changes')]")
	protected WebElement ind_reviewPlanChanges_docSection_preGrayAnoc;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@class,'anocavailable')]//div[@data-ng-if='displayanaoc']//div[contains(@class,'review-section-inner') and contains(text(),'Open Annual Notice of Changes')]//span[contains(text(),'Available by 9/30')]")
	protected WebElement ind_reviewPlanChanges_docSection_preBlueBySept30;
	
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@class,'anocdocument')]//a[contains(text(),'Compare your current plan')]")
	protected WebElement ind_reviewPlanChanges_docSection_activeCompareYourCurrentPlanLnk;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@class,'anocdocument')]//span[contains(text(),'or')]")
	protected WebElement ind_reviewPlanChanges_docSection_activeOrTextForAnoc;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@class,'anocdocument')]//span[contains(text(),'or')]/../i")
	protected WebElement ind_reviewPlanChanges_docSection_arrowAfterActiveAnoc;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@class,'anocdocument')]//a[contains(text(),'Annual Notice of Changes')]")
	protected WebElement ind_reviewPlanChanges_docSection_activeAnoc_us;
	
	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@class,'anocdocument')]//a[contains(text(),'Aviso')]")
	protected WebElement ind_reviewPlanChanges_docSection_activeAnoc_es;

	@FindBy(xpath="//div[contains(@class,'reviewplanchanges_IND')]//div[contains(@class,'documentsMain')]//div[contains(@class,'anocdocument')]//a[contains(text(),'Aviso')]")
	protected WebElement ind_reviewPlanChanges_docSection_activeAnoc_zh;
	
	@FindBy(xpath="//*[contains(text(),'Coming soon')]")
	protected WebElement comingSoonText;

	//note: group
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
	

	/* TODO

	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][2]")
	protected WebElement reviewPlanMaterials;
	
	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][2]//i[contains(@class,'circle')]")
	protected WebElement reviewPlanMaterials_circle;
	
	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][2]//div[@class='review-section']//h4[text()='Review plan materials']")
	protected WebElement reviewPlanMaterials_header;
	
	@FindBy(xpath="//div[contains(@class,'next-year-section')]//div[@class='step-section'][2]//p[@class='review-section-text']")
	protected WebElement reviewPlanMaterials_text;
	
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
	@FindBy(xpath="//div[@id='error_block']//p")
	protected WebElement bookmarkErrMsg;
	
	@FindBy(xpath="//div[@id='error_block']//a[contains(text(),'Home Page')]")
	protected WebElement bookmarkErrPgGoBackHome;
	
}