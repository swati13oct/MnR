package pages.regression.planDocumentsAndResources;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import atdd.framework.UhcDriver;
import org.openqa.selenium.support.PageFactory;

public class PlanDocumentsAndResourcesWebElements extends UhcDriver  {

	int forceTimeoutInMin=5;

	@FindBy (xpath= "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li")
	protected List<WebElement> comboTabs;	

	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	protected WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	protected WebElement needHelp_TechSupp;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	protected WebElement needHelp_TechSupp_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	protected WebElement needHelp_TechSupp_ph;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	protected WebElement needHelp_TechSupp_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	protected WebElement needHelp_TechSupp_wkdyHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	protected WebElement needHelp_TechSupp_wkndHrs;

	//note: need help - general section
	@FindBy(xpath="//div[contains(@class,'general section')]")
	protected WebElement needHelp_GenQue;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[1]//img")
	protected WebElement needHelp_GenQue_img;

	@FindBy(xpath="//div[contains(@class,'general section')]/div/div/p[1]")
	protected WebElement needHelp_GenQue_ph;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[2]")
	protected WebElement needHelp_GenQue_tty;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[3]")
	protected WebElement needHelp_GenQue_wkdyHrs;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[4]")
	protected WebElement needHelp_GenQue_wkndHrs;

	//note: need help - claims section
	@FindBy(xpath="//div[contains(@class,'claims section')]")
	protected WebElement needHelp_ClaimsSupp;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[1]//img")
	protected WebElement needHelp_ClaimsSupp_img;

	@FindBy(xpath="//div[contains(@class,'claims section')]/div/div/div/p[1]")
	protected WebElement needHelp_ClaimsSupp_ph;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[2]")
	protected WebElement needHelp_ClaimsSupp_tty;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[3]")
	protected WebElement needHelp_ClaimsSupp_wkdyHrs;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[4]")
	protected WebElement needHelp_ClaimsSupp_wkndHrs;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	protected WebElement needHelp_PlanSupp;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	protected WebElement needHelp_PlanSupp_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	protected WebElement needHelp_PlanSupp_ph;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	protected WebElement needHelp_PlanSupp_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	protected WebElement needHelp_PlanSupp_wkdyHrs;

	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	protected WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	protected WebElement needHelp_contactUsLink;

	@FindBy(xpath="//div[contains(@class,'tabs')]//li[contains(@onchange,'togglePlanTypeName') and contains(@class,'active')]//a[contains(text(),'Prescription') and contains(text(),'Medical')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//div[contains(@class,'tabs')]//li[contains(@onchange,'togglePlanTypeName') and contains(@class,'active')]//a[contains(text(),'Supplement')]") 
	
	protected WebElement comboTab_SHIP;
	@FindBy(xpath="//div[contains(@class,'tabs')]//li[contains(@onchange,'togglePlanTypeName')]//a[contains(text(),'Prescription') and not(contains(text(),'Medical'))]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//div[contains(@class,'tabs')]//li[contains(@onchange,'togglePlanTypeName')]//a[contains(text(),'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSP;

	@FindBy(xpath="//div[contains(@class,'overview')]/div[contains(@class,'formsAndResourcesNotification base_tools_component section')]//strong[contains(text(),'This page contains PDF documents')]")
	protected WebElement adobePdfDocText;

	@FindBy(xpath="//div[contains(@class,'overview')]/div[contains(@class,'formsAndResourcesNotification base_tools_component section')]//a")
	protected WebElement adobeLink;

	@FindBy(id="artEXPOiFrame")
	protected List<WebElement> IPerceptionsSmileySurveyFrame;

	@FindBy(xpath="//div[@id='expoIconSection']//button[@id='expoBtnClose']")
	protected WebElement closeBtn;
	
	public PlanDocumentsAndResourcesWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() throws InterruptedException {

	}

	@FindBy(xpath="//body")
	protected WebElement apiResponseJson;
	
	//--------------------------
	@FindBy(xpath="//h1[contains(@class,'heading')]")
	protected WebElement pageHeader;
	
	@FindBy(xpath="//div[(contains(@class,'planMaterial') or contains(@class,'UHC_GROUP_PDP')) and not(contains(@class,'ng-hide'))]//h2")
	protected WebElement sectionHeader_PM;
	
	//--------------------------
	@FindBy(xpath="//p[contains(@class,'siteleaving')]")
	protected WebElement siteLeavingPopup;
	
	@FindBy(xpath="//a[contains(@id,'proceedbtn')]")
	protected WebElement siteLeavingPopup_proceedBtn;

	@FindBy(xpath="//a[contains(@id,'cancelbtn')]")
	protected WebElement siteLeavingPopup_cancelBtn;

	//--------------------------
	@FindBy(xpath="//div[contains(@class,'Membership_Materials') and not(contains(@class,'ng-hide'))]//h2[contains(text(),'Membership Materials')]")
	protected WebElement sectionHeader_MM;
	
	@FindBy(xpath="//div[contains(@class,'annualNotice') and not(contains(@class,'ng-hide'))]//h2[contains(text(),'Annual Notice of Changes Document')]")
	protected WebElement sectionHeader_ANOC;
	
	@FindBy(xpath="//div[contains(@class,'Directories') and not(contains(@class,'ng-hide'))]//div[contains(@class,'sectionWise_div') and not(contains(@style,'display: none;'))]")
	protected List<WebElement> listOfSections_PD;
	
	//note: careful updating this xpath, it's currently covering for multiple user types
    @FindBy(xpath="//div[contains(@class,'Directories') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'Provider_Dir') or contains(@class,'Pharmacy_Dir') or contains(@class,'PharmacyDirectory') or contains(@class,'ProviderDirectory') or contains(@class,'Annual') or contains(@class,'Header_')) and not(contains(@class,'ng-hide'))]//h2")
	protected WebElement sectionHeader_PD;
	
	@FindBy(xpath="//div[contains(@class,'mydocument') and not(contains(@class,'ng-hide'))]//h2")
	protected WebElement sectionHeader_MD;
	
	@FindBy(xpath="//div[contains(@class,'EOB') and not(contains(@class,'ng-hide'))]//h2")
	protected WebElement sectionHeader_EOB;	
	
	@FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/h2[contains(text(),'Explanation of Benefits')]")
	protected WebElement eobPgHeader;
	
	@FindBy(xpath="//div[contains(@class,'formsAndResourcesDocList') and not(contains(@class,'ng-hide'))]//h2")
	protected WebElement sectionHeader_FnR;	
	
	@FindBy(xpath="//div[contains(@class,'renewmagazine') and not(contains(@class,'ng-hide'))]//h2")
	protected WebElement sectionHeader_RM;	
	
	@FindBy(xpath="//div[contains(@class,'renewmagazine') and not(contains(@class,'ng-hide'))]//img")
	protected WebElement renewMagazineImg_RM;

	//--------------------------
	@FindBy(xpath="//h1[contains(text(),'Order Plan Materials')]")
	protected WebElement orderPlanPgHeader;
	
	//note: xpath is generalized to be used by different type of users, careful if updating this
	@FindBy(xpath="//div[(contains(@class,'planMaterial') or contains(@class,'Plan_Doc')) and not(contains(@class,'ng-hide'))]//div[(contains(@class,'PlanDocumentsActive') or contains(@class,'Plan_Documents_active')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'ORDER PLAN MATERIALS')]")
	protected WebElement orderPlanMaterialsLnk_PM;

	@FindBy(xpath="//div[(contains(@class,'planMaterial') or contains(@class,'Plan_Doc')) and not(contains(@class,'ng-hide'))]//div[(contains(@class,'PlanDocumentsActive') or contains(@class,'Plan_Documents_active')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'ORDER PLAN MATERIALS')]//img")
	protected WebElement orderPlanMaterialsImg_PM;
	
	@FindBy(xpath="//div[(contains(@class,'planMaterial') or contains(@class,'Plan Doc')) and not(contains(@class,'ng-hide'))]//div[(contains(@class,'PlanDocumentsActive') or contains(@class,'Plan'))and not(contains(@class,'ng-hide'))]//a[contains(text(),'VIEW MEMBER ID CARD')]")
	protected WebElement viewMemberIdCardLnk_PM;
	
	@FindBy(xpath="//div[(contains(@class,'planMaterial') or contains(@class,'Plan Doc')) and not(contains(@class,'ng-hide'))]//div[(contains(@class,'PlanDocumentsActive') or contains(@class,'Plan'))and not(contains(@class,'ng-hide'))]//a[contains(text(),'VIEW MEMBER ID CARD')]//img")
	protected WebElement viewMemberIdCardImg_PM;
	
	//--------------------------
	@FindBy(xpath="//div[contains(@class,'otherPages') and not(contains(@class,'ng-hide'))]//li[contains(@class,'quickLink') and not(contains(@style,'display: none;'))]//a[contains(@dtmname,'plan materials')]")
	protected WebElement jumpLink_PM;
	
	//@FindBy(xpath="//div[contains(@class,'otherPages') and not(contains(@class,'ng-hide'))]//li[contains(@class,'quickLink') and not(contains(@style,'display: none;'))]//a[@dtmid='cta_quicklink_mm']")
	//note: careful updating this xpath, it's currently covering for multiple user types
	@FindBy(xpath="//div[contains(@class,'otherPages') and not(contains(@class,'ng-hide'))]//li[contains(@class,'quickLink') and not(contains(@style,'display: none;'))]//a[contains(@dtmname,'welcome guide') or contains(@dtmname,'membership materials')]")
	protected WebElement jumpLink_MM;
	
	@FindBy(xpath="//div[contains(@class,'otherPages') and not(contains(@class,'ng-hide'))]//li[contains(@class,'quickLink') and not(contains(@style,'display: none;'))]//a[contains(@dtmname,'annual notice of change')]")
	protected WebElement jumpLink_ANOC;

	@FindBy(xpath="//div[contains(@class,'otherPages') and not(contains(@class,'ng-hide'))]//li[contains(@class,'quickLink') and not(contains(@style,'display: none;'))]//a[contains(@dtmname,'annual directories')]")
	protected WebElement jumpLink_PD;

	@FindBy(xpath="//div[contains(@class,'otherPages') and not(contains(@class,'ng-hide'))]//li[contains(@class,'quickLink') and not(contains(@style,'display: none;'))]//a[contains(@dtmname,'my documents')]")
	protected WebElement jumpLink_MD;

	@FindBy(xpath="//div[contains(@class,'otherPages') and not(contains(@class,'ng-hide'))]//li[contains(@class,'quickLink') and not(contains(@style,'display: none;'))]//a[contains(@dtmname,'explanation of benefits')]")
	protected WebElement jumpLink_EOB;

	@FindBy(xpath="//div[contains(@class,'otherPages') and not(contains(@class,'ng-hide'))]//li[contains(@class,'quickLink') and not(contains(@style,'display: none;'))]//a[contains(@dtmname,'forms and resources')]")
	protected WebElement jumpLink_FnR;

	@FindBy(xpath="//div[contains(@class,'otherPages') and not(contains(@class,'ng-hide'))]//li[contains(@class,'quickLink') and not(contains(@style,'display: none;'))]//a[contains(@dtmname,'renew magazine')]")
	protected WebElement jumpLink_RM;

	//--------------------------
	//note: this set works after year switch to 2020
	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'Pharmacy_Provider') or contains(@class,'Provider') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Provider Search')]")
	protected WebElement providerSearch_link_PD;

	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'Pharmacy_Provider') or contains(@class,'Provider') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Provider Search')]//img")
	protected WebElement providerSearch_link_img;
	
	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'Pharmacy_Provider') or contains(@class,'Provider') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Provider Search')]//following-sibling::p")
	protected List<WebElement> providerSearch_instr_PD;
	
	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'Pharmacy_Provider') or contains(@class,'Pharmacy')  or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Pharmacy Locator')]")
	protected WebElement pharmacyLocator_link_PD;

	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'Pharmacy_Provider') or contains(@class,'Pharmacy')  or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Pharmacy Locator')]//img")
	protected WebElement pharmacyLocator_link_img;

	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'Pharmacy_Provider') or contains(@class,'Pharmacy')  or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Pharmacy Locator')]//following-sibling::p")
	protected List<WebElement> pharmacyLocator_instr_PD;


	//--------------------------
	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'AD_Individual') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Provider Search')]")
	protected WebElement ind_providerSearch_link_PD;

	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'AD_Individual') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Provider Search')]//img")
	protected WebElement ind_providerSearch_link_img;
	
	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'AD_Individual') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Provider Search')]//following-sibling::p")
	protected List<WebElement> ind_providerSearch_instr_PD;
	
	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'calloutBoth_AD_Individual') or contains(@class,'PharmacyLocatorCallout_AD') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Pharmacy Locator')]")
	protected WebElement ind_pharmacyLocator_link_PD;

	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'calloutBoth_AD_Individual') or contains(@class,'PharmacyLocatorCallout_AD') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Pharmacy Locator')]//img")
	protected WebElement ind_pharmacyLocator_link_img;

	@FindBy(xpath="//div[contains(@class,'Directories_') and not(contains(@class,'ng-hide'))]//div[(contains(@class,'calloutBoth_AD_Individual') or contains(@class,'PharmacyLocatorCallout_AD') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Pharmacy Locator')]//following-sibling::p")
	protected List<WebElement> ind_pharmacyLocator_instr_PD;

	//----
	@FindBy(xpath="//div[(contains(@class,'otherPages') and contains(@class,'Directories_')) and not(contains(@class,'ng-hide'))]//div[(contains(@class,'AD_Group') or contains(@class,'PharmacyLocatorCallout_AD') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Provider')]")
	protected WebElement grp_providerSearch_link_PD;

	@FindBy(xpath="//div[(contains(@class,'otherPages') and contains(@class,'Directories_')) and not(contains(@class,'ng-hide'))]//div[(contains(@class,'AD_Group') or contains(@class,'PharmacyLocatorCallout_AD') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Provider')]//img")
	protected WebElement grp_providerSearch_link_img;
	
	@FindBy(xpath="//div[(contains(@class,'otherPages') and contains(@class,'Directories_')) and not(contains(@class,'ng-hide'))]//div[(contains(@class,'AD_Group') or contains(@class,'PharmacyLocatorCallout_AD') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Provider')]//following-sibling::p")
	protected List<WebElement> grp_providerSearch_instr_PD;
	
	@FindBy(xpath="//div[(contains(@class,'otherPages') and contains(@class,'Directories_')) and not(contains(@class,'ng-hide'))]//div[(contains(@class,'calloutBoth_AD_Group') or contains(@class,'PharmacyLocatorCallout_AD') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Pharmacy Locator')]")
	protected WebElement grp_pharmacyLocator_link_PD;

	@FindBy(xpath="//div[(contains(@class,'otherPages') and contains(@class,'Directories_')) and not(contains(@class,'ng-hide'))]//div[(contains(@class,'calloutBoth_AD_Group') or contains(@class,'PharmacyLocatorCallout_AD') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Pharmacy Locator')]//img")
	protected WebElement grp_pharmacyLocator_link_img;

	@FindBy(xpath="//div[(contains(@class,'otherPages') and contains(@class,'Directories_')) and not(contains(@class,'ng-hide'))]//div[(contains(@class,'calloutBoth_AD_Group') or contains(@class,'PharmacyLocatorCallout_AD') or contains(@class,'_PE')) and not(contains(@class,'ng-hide'))]//a[contains(text(),'Pharmacy Locator')]//following-sibling::p")
	protected List<WebElement> grp_pharmacyLocator_instr_PD;
	
	//--------------------------
	@FindBy(xpath="//h3[contains(text(),'My Documents')]")
	protected WebElement myDocumentsPgHeader;
	
	@FindBy(xpath="//div[contains(@class,'mydocument')]//a[contains(text(),'Search Documents')]")
	protected WebElement myDocumentLink_MD;

	//note: careful updating this xpath, it's currently covering for multiple user types
	@FindBy(xpath="//div[contains(@ng-show,'evaluateAEM_Segments') and contains(@class,'EOB') and not(contains(@class,'ng-hide')) and not(contains(@class,'PDP'))]//div[contains(@class,'explanationbenefits')]//a[contains(text(),'MEDICAL')]")
	protected WebElement searchMedicalEobHistoryLink_EOB;

	//note: careful updating this xpath, it's currently covering for multiple user types
	@FindBy(xpath="//div[contains(@ng-show,'evaluateAEM_Segments') and contains(@class,'EOB') and not(contains(@class,'ng-hide'))]//div[contains(@class,'explanationbenefits')]//a[contains(text(),'DRUG')]")
	protected WebElement searchDrugEobHistoryLink_EOB;

	@FindBy(xpath="//div[contains(@ng-show,'evaluateAEM_Segments') and contains(@class,'EOB') and not(contains(@class,'ng-hide'))]//div[contains(@class,'explanationbenefits')]//a[contains(text(),'SEARCH EOB HISTORY') or contains(text(),'VIEW EOB STATEMENTS')]")
	protected WebElement searchEobHistoryLink_EOB;

	@FindBy(xpath = "//*[@id='myDocButtonText']")
	protected WebElement myDocumentSection;
	//--------------------------
	@FindBy(xpath="//div[contains(@class,'renewmagazine') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Current Issue')]")
	protected WebElement currentIssueLink_RM;
	
	@FindBy(xpath="//div[contains(@class,'renewmagazine') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Previous Issue')]")
	protected WebElement previousIssueLink_RM;
	
	//--------------------------
	@FindBy(xpath="//div[contains(@class,'planMaterial') and not(contains(@class,'ng-hide'))]//select")
	protected WebElement langDropDown_PM;
	
	@FindBy(xpath="//div[contains(@class,'WelcomeKit') and not(contains(@class,'ng-hide'))]//select")
	protected WebElement langDropDown_MM;
	
	@FindBy(xpath="//div[contains(@class,'annualNotice') and not(contains(@class,'ng-hide'))]//select")
	protected WebElement langDropDown_ANOC;

	@FindBy(xpath="//div[contains(@class,'Directories') and not(contains(@class,'ng-hide'))]//select")
	protected WebElement langDropDown_PD;

	//--------------------------
	@FindBy(xpath="//div[contains(@class,'planMaterial') and not(contains(@class,'ng-hide'))]//div[contains(@class,'Footer')]//*[contains(text(),'Looking')]")
	protected WebElement footer_PM;

	@FindBy(xpath="//div[contains(@class,'planMaterial') and not(contains(@class,'ng-hide'))]//div[contains(@class,'Footer')]//a[1]")
	protected WebElement footer_formsAndResources_link_PM;

	@FindBy(xpath="//div[contains(@class,'planMaterial') and not(contains(@class,'ng-hide'))]//div[contains(@class,'Footer')]//a[2]")
	protected WebElement footer_fnr_myDocument_PM;
	
	//--------------------------
	//note: forms and resources section
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a/span[contains(text(),'Prescription Drug Mail Order Form')]")
	protected WebElement presDrugMailOrdeForm_sectionPD_FnR;
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a/span[contains(text(),'Premium Payment Information')]")
	protected WebElement premiumPaymentInfo_sectionPP_FnR;
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'How to read your bill')]")
	protected WebElement howToReadYourBill_link_PP_FnR;
	//- href="/Individual/How_To_Read_Your_Bill.pdf" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Electronic Funds Transfer')]")
	protected WebElement electronicFundsTransfer_link_PP_FnR;
	//- href="/Individual/EFT_Form.pdf" 

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Premium Deduction from Social Security Payment Form')]")
	protected WebElement premiumDeduction_link_PP_FnR;
	//- href="/Individual/Premium_Deduction_Form.pdf" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a/span[contains(text(),'Reimbursement Form')]")
	protected WebElement reimbursementForms_sectionRF_FnR;
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Medical Reimbursement Form (Online)')]")
	protected WebElement medReimbFormOnline_link_RF_FnR;
	//- href="/content/medicare/member/documents/medical-reimbursement-form.html" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Medical Reimbursement Form (PDF)')]")
	protected WebElement medReimbFormPdf_link_RF_FnR;
	//- href="/content/dam/UCP/Individual/Medical_Reimbursement_Form.pdf" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Prescription Drug Reimbursement Form')]")
	protected WebElement presDrugReimbForm_link_RF_FnR;
	//- href="/content/dam/UCP/Individual/Drug_Reimbursement_Form_MAPD.pdf" 

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Prescription Mail Order Form') and contains(text(),'Preferred Mail Service Pharmacy through OptumRx')]")
	protected WebElement presMailOrderForm_link_RF_FnR;
	//- href="/content/dam/UCP/Individual/OptumRx_Home_Delivery_Form.pdf"
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a/span[contains(text(),'Authorization Forms')]")
	protected WebElement authorizationFormsAndInfo_sectionAF_FnR;
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'How to appoint a representative')]")
	protected WebElement howToAppointRepresentative_link_AF_FnR;
	//- href="/content/medicare/member/documents/appoint-representative.html"

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Appointment of Representative Form')]")
	protected WebElement appointRepresentative_link_AF_FnR;
	//- href="http://www.cms.gov/Medicare/CMS-Forms/CMS-Forms/CMS-Forms-Items/CMS012207.html">

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Authorization to Share Personal Information Form')]")
	protected WebElement authSharePersonalInfoForm_link_AF_FnR;
	//- href="/content/medicare/member/documents/release-personal-information.html" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a/span[contains(text(),'Medication Authorization Forms') or contains(text(),'Medication Authorization forms')]")
	protected WebElement medicationAuthForm_sectionMA_FnR;
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Drug-specific Prior Authorization Request Form')]")
	protected WebElement drugSpecficPriorAuthReq_link_MA_FnR;
	//- href="/optumrx-priorauth"
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Medication Prior Authorization Request Form')]")
	protected WebElement medPriorAuthReq_link_MA_FnR;
	//- href="/Individual/Medication_Prior_Authorization_Request_Form.pdf" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Medicare Part D Coverage Determination Request Form')]")
	protected WebElement medPartDCovDeteReq_link_MA_FnR;
	//- href="/Individual/Medicare_PartD_Coverage_Determination_Request_Form.pdf" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Redetermination Request Form')]")
	protected WebElement redeterminationReq_link_MA_FnR;
	//- href="/Individual/Redetermination_Request_Form.pdf" 

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a/span[contains(text(),'Other Resources')]")
	protected WebElement otherResources_orSection_fnr;

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Appeals and Grievances') and contains(text(),'Medicare Advantage Plans')]")
	protected WebElement appealsAndGrievMedAdvPlan_link_OR_FnR;
	//- href="/content/medicare/member/documents/appeals-ma.html"
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Medicare Plan Appeals') and contains(text(),'Grievances Form (Online)')]")
	protected WebElement medPlanAppeAndGrievFormOnline_link_OR_FnR;
	//- href="/content/medicare/member/documents/appeals-and-grievances.html" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Medicare Plan Appeals') and contains(text(),'Grievances Form') and not(contains(text(),'Online'))]")
	protected WebElement medPlanAppeAndGrievFormPdf_link_OR_FnR;
	//- href="/Individual/Medicare_Appeals_Grievances_Form.pdf" 

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Commitment to quality')]")
	protected WebElement commitmentToQuality_link_OR_FnR;
	//- href="/Individual/Commitment_to_Quality.pdf"

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'UnitedHealthcare Medicare Advantage Coverage Summaries')]")
	protected WebElement uhcMedAdvCvgSum_link_OR_FnR;
	//- href="https://www.unitedhealthcareonline.com/b2c/CmaAction.do?channelId=ff12754af31f7210VgnVCM1000002f10b10a____">
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Step Therapy for Part B Drugs')]")
	protected WebElement stepThreapyPartB_link_OR_FnR;
	//- href="/content/medicare/member/documents/part-b-step-therapy.html" 

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Member rights and responsibilities')]")
	protected WebElement memberRightsAndResp_link_OR_FnR;
	//- href="/content/medicare/member/documents/rights-responsibilities.html" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Potential for Contract Termination')]")
	protected WebElement potentialForContractTerm_link_OR_FnR;
	//- href="/Individual/PotentialContractTermination_UHC.pdf"
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Prescription drug coverage determinations and appeals')]")
	protected WebElement presDrugCvgDetermination_link_OR_FnR;
	//- href="/content/medicare/member/documents/appeals-mapd-pdp.html" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Prescription Drug Transition Process')]")
	protected WebElement presDrugTransitionProcess_link_OR_FnR;
	//- href="/content/medicare/member/documents/drug-transition.html" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Medication Therapy Management (MTM) Program')]")
	protected WebElement medTherapyMgmt_link_OR_FnR;
	//- href="/content/medicare/member/documents/medication-program-mapd-pdp.html" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Declaration of Prior Prescription Drug Coverage Form')]")
	protected WebElement declarationPriorPrescDrugCvg_link_OR_FnR;
	//- href="/Individual/Declaration_Prior_Drug_Coverage_Form.pdf" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Seasonal flu shot information')]")
	protected WebElement seasonalFluShot_link_OR_FnR;
	//- href="/content/medicare/member/documents/flu-shot-info.html" 

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Emergency Room Copayment Waiver Request')]")
	protected WebElement emergencyRoomCopayWavierReq_link_OR_FnR;
	//- href="/content/dam/UCP/Group/2019/Group-CT/CT_ER_COPAY_WAIVER_MAPD_FINAL.pdf" 

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Naturopathy Provider Directory')]")
	protected WebElement naturopathyProvider_link_OR_FnR;
	//- href="/content/dam/UCP/Group/Naturopathy_Provider_Directory_StofCT.pdf" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Coverage determinations and appeals')]")
	protected WebElement coveDeteAndAppeDrugCondAndLimiAndQualAssuPoli_link_OR_FnR;
	//- href="/content/medicare/member/documents/appeals-mapd-pdp.html"

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Appeals and Grievances') and contains(text(),'Senior Supplement Plans')]")
	protected WebElement appeAndGrieSeniSuppPlan_link_OR_FnR;
	//- href="/content/medicare/member/documents/appeals-ssup.html"

	//---DI_FnR
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a/span[contains(text(),'Disenrollment')]")
	protected WebElement disenrollmentInfo_sectionDI_FnR;
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Disenrollment Form (Online)')]")
	protected WebElement disenrollmentFormOnline_link_DI_FnR;
	//- href="https://www.docusign.net/member/PowerFormSigning.aspx?PowerFormId=832677cc-ee97-4e0e-9955-b36f8919b18b"
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Disenrollment Form') and not(contains(text(),'Online'))]")
	protected WebElement disenrollmentFormForm_link_DI_FnR;
	//- href="/Individual/Disenrollment_Form_MAPD.pdf" 
	
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Disenrollment rights and responsibilities')]")
	protected WebElement disenrolmentRightAndResponsibilities_link_DI_FnR;
	//- href="/content/medicare/member/documents/disenrollment-rights.html

	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'MA/MAPD opt-out form')]")
	protected WebElement maMapdOptOutForm_link_DI_FnR;
	//- href="/content/dam/UCP/Group/MAPD_Opt_Out_Request_Form.pdf"

	//---SHIP_FnR
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Electronic Funds Transfer (EFT) form')]")
	protected WebElement elecFundTran_link_SHIP_FnR;
	//- href="/content/dam/UCP/SHIP/eft_content.pdf"
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Privacy Authorization form')]")
	protected WebElement privAuthForm_link_SHIP_FnR;
	//- href="/content/dam/UCP/SHIP/privacy_authorization.pdf"
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Alternate Payer Authorization form')]")
	protected WebElement altePayeAuthForm_link_SHIP_FnR;
	//- href="/content/dam/UCP/SHIP/Alternate_Payer_Authorization.pdf"
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Third Party Designee form')]")
	protected WebElement thirPartDesiForm_link_SHIP_FnR;
	//- href="/content/dam/UCP/SHIP/LA26838ST_ThirdPartyDesignee.pdf"
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'Part A Deductible Hospital Waiver list')]")
	protected WebElement partADeduHospWaivList_link_SHIP_FnR;
	//- href="/content/dam/UCP/SHIP/Part_A_Deductible_Waiver_Hospital_Directory.pdf"
	@FindBy(xpath="//div[contains(@class,'FormsAndResources') and not(contains(@class,'ng-hide'))]//a[contains(text(),'How to File a Claim')]")
	protected WebElement howToFileAClaim_link_SHIP_FnR;
	//- href="/content/dam/UCP/SHIP/CLMSUPB.pdf"
	
	@FindBy(xpath="//h1")
	protected WebElement generalPgHeader;

	//---------------------------------
	@FindBy(xpath="//input[@id='location']")
	protected WebElement providerSearchPg_zipcodeInputField;
	
	@FindBy(xpath="//div[contains(@class,'backToTop') and not(contains(@style,'display: none'))]//a")
	protected WebElement backToTopLink;
	
	@FindBy(xpath="//div[@class='container']//img")
	protected List<WebElement> currentIssueImgList;
	
	@FindBy(xpath="//h3[text()='My Documents']")
	protected WebElement myDocPgHeader;
	
	@FindBy(xpath="//h1[contains(text(),'Past Issues')]")
	protected WebElement prevIssPgHeader;
	
}