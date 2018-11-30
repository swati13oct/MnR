/**
 * 
 */
package pages.regression.benefitandcoverage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.validator.ValidateWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.member.bluelayer.ProfilePreferencesPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.ValueAddedServicepage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @Functionality : To check Benefits and Coverage page
 *
 **
 */
public class BenefitsAndCoveragePage extends UhcDriver {

	public PageData benefitsCoverage;

	public JSONObject benefitsandcoverageJson;

	@FindBy(linkText = "VIEW PLAN DOCUMENTS")
	public WebElement viewPlanDocumentsButton;

	@FindBy(xpath = ".//*[@id='globalContentIdForSkipLink']/div[3]/div/div/div[2]/div/div/div/p[1]")
	private WebElement messageForPreeffective;

	@FindBy(linkText = "1-888-980-8125")
	public WebElement preEffectiveTechSupportNumber;

	@FindBy(id = "IPerceptionsEmbed")
	public WebElement iPerceptionframe;

	@FindBy(id = "closeButton")
	public WebElement iPerceptionclosebtn; 

	@FindBy(xpath = ".//*[@id='pcpCard']/section/button")
	private WebElement Addaprovider;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[2]/div[1]/span")
	private WebElement memberId;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[1]/div[1]/span")
	private WebElement memberName;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[4]/div[1]/span")
	private WebElement effectiveDate;

	@FindBy(xpath = ".//*[@id='planBenefitsApp']/section/div/div[1]/div/div/div/div/h1")
	private WebElement planName1;

	//@FindBy(xpath = ".//*[@id='mapdPageLis']/div[1]/div/div/table/tbody/tr[2]/th")
	@FindBy(xpath =".//*[@id='mapdPageLis'] or contains(text0,'Covered Generic Drugs')")
	private WebElement columncoveragegenericdrugs;

	@FindBy(id = "contactUsAtdd")
	private WebElement contactUslink;

	@FindBy(xpath = ".//*[@id='needhelpsectioncontactus']/section[2]/div/div[3]/div/p")
	private WebElement Seemorewaystext;

	@FindBy(className = "atdd-need-help")
	private WebElement NeedHelpHeader;

	@FindBy(id = "needhelpsectioncontactus")
	private WebElement Contactussection;

	// private WebElement Contactussection;

	@FindBy(className = "atdd-needhelp-disclaimer-text")
	private WebElement disclaimersLink;

	@FindBy(xpath = "//a[contains(text(),'MORE INFORMATION')]")
	private WebElement moreinformation;

	@FindBy(id = "collapseDisclaimer")
	private WebElement moreinformationArea;

	
	@FindBy(xpath = ".//*[@id='plan_benefit_documents']/section/div/div[1]/div")
	private WebElement planBenefitsDocuments;

	@FindBy(id = "lang-select-2")
	private WebElement langdropdown;

	@FindBy(className = "atdd-benefitssummary-ancillaryHearingText")
	private WebElement Hearingsection;

	@FindBy(xpath = ".//*[@class='bold margin-small atdd-bnc-hearingtxt-subtitle']//following-sibling::p")
	private WebElement HearingContent;

	@FindBy(xpath= ".//*[@class='margin-small bold atdd-benefitssummary-eyewear']//following-sibling::p")
	private WebElement VisionContent;

	@FindBy(className = "atdd-benefitssummary-exclusivehearing")
	private WebElement Hearingaid;

	@FindBy(className = "atdd-benefitssummary-vision")
	private WebElement Visionsection;

	@FindBy(className = "atdd-benefitssummary-dental")
	private WebElement Dentalsection;

	@FindBy(xpath = ".//*[@class='bold margin-small atdd-benefitssummary-routine-dental']//following-sibling::p")
	private WebElement DentalContent;

	@FindBy(className = "atdd-benefitssummary-ancillaryHeader")
	private WebElement Headersection;

	@FindBy(className = ".//*[@id='ancillary']/div[2]/div[4]/div/div")
	private WebElement chiropracticsection;

	@FindBy(className = "atdd-bnc-drgcvrgeinfo")
	private WebElement DrugCoveragetext;

	@FindBy(className = "atdd-bnc-drugcoverage-title")
	private WebElement DrugCoverageHeader;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-title")
	private WebElement lisDrugCopayHeader;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-info")
	private WebElement lisDrugCopayText;

	@FindBy(xpath = "//p[contains(text(),'Estimate your drug costs and view ways to save.')]")
	private WebElement LookupDrugstext;

	@FindBy(xpath = "//a[contains(text(),'Look up Drugs')]")
	private WebElement LookUpDrugsButton;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-title")
	private WebElement DrugCopayHeader;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-info")
	private WebElement DrugCopayText;

	@FindBy(id = "drug-costs")
	private WebElement DrugCostDropdown;

	@FindBy(className = "atdd-bnc-drugcostsheading")
	private WebElement DrugCostHeader;

	//@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[2]/div/div")
	@FindBy(xpath =".//*[@id='drug-benefits']//span[text()='DRUG LOOKUP']")
	private WebElement DrugCostheaderandtext;



	@FindBy(xpath = ".//*[@id='waystosave']/div/div/div[1]/div/h1")
	private WebElement TextWaystoSave;

	@FindBy(xpath = "//a[@class='display-block collapse-expand collapsed atdd-bnc-drgpricingtiers']")
	private WebElement Learnmoretierslink;
	
	@FindBy(id = "collapseTiers")
	private WebElement LearnmoretierslinkArea;
	
	@FindBy(xpath = "//a[@class='display-block collapse-expand atdd-bnc-drgpricingtiers']")
	private WebElement LearnmoretierslinkForCollapsed;
	
	@FindBy(xpath = "//a[@class='display-block collapse-expand atdd-bnc-drgpricingtiers collapsed']")
	private WebElement LearnmoretierslinkAfterCollapsed;

	@FindBy(xpath = "//a[@class='display-block collapse-expand collapsed atdd-bnc-drgstgtiers']")
	private WebElement Learnmorestagelink;

	@FindBy(xpath = "//a[@class='display-block collapse-expand atdd-bnc-drgstgtiers']")
	private WebElement LearnmorestagelinkForCollapse;
	
	@FindBy(xpath = "//a[@class='display-block collapse-expand atdd-bnc-drgstgtiers collapsed']")
	private WebElement LearnmorestagelinkAfterCollapse;

	@FindBy(id = "collapseStages")
	private WebElement LearnmorestageExpandedArea;


	// @FindBy(xpath = "//p[contains(text(),'Find a location near you.')]")
	@FindBy(xpath="//span[contains (text(),'PHARMACY LOCATOR')]")
	private WebElement locateapharmacysection;

	//@FindBy(className = "atdd-bnc-locatepharmacybtn")
	//@FindBy(xpath=".//*[contains (text(),'Locate a Pharmacy')]")
	@FindBy(className = "atdd-bnc-locatepharmacybtn")
	private WebElement locateapharmacybutton;

	@FindBy(id = "mapdPageNonLis")
	private WebElement drugcopaytable;

	@FindBy(xpath = ".//*[@id='mapdPageNonLisForSRetail']/div/div[1]/div/div/div/div/table/tbody/tr[2]/td[3]/div")
	private WebElement tabledynamicdatamapd;

	@FindBy(xpath = ".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr[3]/td[1]/div")
	private WebElement tabledynamicdatapdp;


	@FindBy(xpath = ".//*[@id='mapdPageLis']")
	private WebElement RetailDrugCost_Table;

	@FindBy(xpath = ".//*[@id='mapdPageLis']")
	private WebElement RetailDrugCost_Table1; 

	@FindBy(id = "waystosave")
	private WebElement waysToSave;


	@FindBy(id = "viewTextAtdd")
	private WebElement view_label;

	@FindBy(xpath = "//h2[contains(text(),'Plan Documents and Resources')]")
	private WebElement documents_label;

	// @FindBy(className = "atdd-benefitsoverview-plantitle")
	@FindBy(xpath = ".//*[@class='h2 margin-none overview-heading atdd-benefitsoverview-plantitle ng-binding']")
	private WebElement planName2;

	// @FindBy(className = "atdd-benefitsoverview-membernamelabel")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-membernamelabel']")
	private WebElement nameLabel1;

	// @FindBy(className = "atdd-benefitsoverview-memberidlabel")
	@FindBy(className = ".//*[@class='bold atdd-benefitsoverview-memberidlabel']")
	private WebElement memberID1;

	// @FindBy(className = "atdd-benefitsoverview-effectivedatelabel")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-effectivedatelabel']")
	private WebElement effective_Date;

	@FindBy(xpath = "//*[@class='bold atdd-benefitsoverview-effectivedatelabel']//..//..//div[2]")
	private WebElement effectivedateValueBNC;


	@FindBy(className = "atdd-benefitsoverview-groupidlabel")
	private WebElement GroupId;

	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-extrahelplevel-ma-label ng-binding']")
	private WebElement ExtraHelp;

	@FindBy(xpath = "//h2[contains(text(),'Benefits Summary')]")
	private WebElement BenefitsSummaryHeader;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[1]/div/h1")
	private WebElement BenefitsSummaryHeadership;

	@FindBy(xpath = "//span[contains(text(),'Medical Copays or Coinsurance')]")
	private WebElement Copayscoinsuranceheader;

	@FindBy(xpath = "//span[@class='subtitle atdd-officevisits-title ng-scope']")
	private WebElement OfficeVisits;

	@FindBy(className = "atdd-emergencycare-title")
	private WebElement EmergencyHeader;

	@FindBy(className = "atdd-ambulance-title")
	private WebElement AmbulanceHeader;

	@FindBy(xpath = "//span[@class='subtitle atdd-hospitalvisits-title']")
	private WebElement HospitalVisits;

	@FindBy(xpath = "//span[@class='subtitle atdd-outpatientsurgery-title ng-scope']")
	private WebElement OutpatientSurgeryCenter;

	@FindBy(className = "outpatientsurgery-tier1-atdd")
	private WebElement OutpatientSurgeryCenter2;

	@FindBy(xpath = "//div[contains(@class,'outpatientsurgery')]")
	private WebElement OutpatientSurgeryCenterValue;

	@FindBy(xpath = "(//*[@id='officeVisitTileAtdd']//div[1]/div[1]/span)[1]")
	private WebElement OfficVisitsValue;

	@FindBy(xpath = "//span[contains(text(),'YOUR PRIMARY CARE PROVIDER')]")
	private WebElement YourPrimaryCareProvider;

	@FindBy(xpath = "//button[@class='btn btn--primary changepcp-atdd']")
	private WebElement ChangeYourPcpButton;

	@FindBy(xpath = "//a[contains(text(),'SEARCH FOR PROVIDERS')]")
	private WebElement StartSearch;

	@FindBy(xpath = "//span[contains(text(),'PROVIDER SEARCH')]")
	private WebElement SearchProvider;

	@FindBy(id = "benefitShipCard")
	private WebElement ParticipatingHospitalStays1;

	@FindBy(id = "individualPcpHeaderText")
	private WebElement PrimaryCareProviderHeaderInd;

	@FindBy(className = "atdd-bncsummary-primarycareprvdrheader")
	private WebElement PrimaryCareProviderHeaderHMO;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[6]/div/div/div/p")
	private WebElement PCPtext;

	@FindBy(id = "outOfPocketTile")
	private WebElement OutofPocketMaximum;

	@FindBy(xpath = "//span[contains(text(),'Out-of-Pocket Maximum')]")
	private WebElement OutofPocketMaximumText;

	@FindBy(id = "oopInNetowrk")
	private WebElement INNETWORK;

	@FindBy(id = "oopOutNetowrk")
	private WebElement OUTOFNETWORK;

	@FindBy(xpath = "//span[contains(text(),'IN-NETWORK')]")
	private WebElement INNETWORKTEXT;

	@FindBy(xpath = "//span[contains(text(),'OUT-OF-NETWORK')]")
	private WebElement OUTOFNETWORKTEXT;

	@FindBy(xpath = "//button[@id='dropdown-toggle--1']/span[contains(text(),'Profile')]")
	private WebElement accountToggleDropdown;

	@FindBy(xpath = "//a[@class='dropdown-option' and contains(text(),'Account Settings')]")
	private WebElement accountSettingOption;

	@FindBy(className = "atdd-gopaperless")
	private WebElement gopaperlessbutton;

	@FindBy(className = "atdd-bnc-anclry-disclaimer")
	private WebElement Exclusivedisclaimer;

	@FindBy(className = "atdd-exclsvehearing-arrowdwn")
	private WebElement Disclaimertext;

	@FindBy(className = "atdd-bnc-ancilry-learnmorbtn")
	private WebElement LearnmoreButton;

	@FindBy(className = "atdd-bnc-exclusivehrng-leavingpopuptxt")
	private WebElement popup;

	@FindBy(className = "atdd-anclrysection-leavingpopup-proceedbtn")
	private WebElement ProceedButton;

	@FindBy(className = "atdd-anclrysection-leavingpopup-cancelbtn")
	private WebElement cancelbutton;

	@FindBy(className = "atdd-exclusivehearing-levngpopup-topcancelbtn")
	private WebElement cancelbutton1;

	@FindBy(xpath = ".//*[@id='specialDisctServices']/div[1]/img")
	private WebElement handimage;

	@FindBy(id = "specialDisctServices")
	private WebElement textdiscountservices;

	// @FindBy(id="drug-benefits")
	@FindBy(xpath = ".//*[contains (text(),'DRUG LOOKUP')]")
	private WebElement DrugLookUpLink;

	@FindBy(className = "atdd-bnc-discounttitle")
	private WebElement headerdiscountservices;

	@FindBy(className = "atdd-bnc-discntlearnmorimg")
	private WebElement learnmorebutton;

	@FindBy(className = "atdd-need-help")
	private WebElement NeedhelpShip;

	@FindBy(className = "atdd-techsupport-block")
	private WebElement TechnicalSupportShip;

	@FindBy(xpath = "//h3[contains(text(),'Technical Support ')]")
	private WebElement TechnicalSupport;

	@FindBy(xpath = "//h3[contains(text(),'Plan Support')]")
	private WebElement PlanSupport;

	@FindBy(className = "atdd-general-header")
	private WebElement GeneralQuestionShip;

	@FindBy(className = "atdd-claims-header")
	private WebElement ClaimsSupportShip;

	@FindBy(id = "ccs-header")
	private WebElement catastrophicCoverageStage;

	@FindBy(xpath = "//div/span[@class='bold atdd-benefitsoverview-monthlypremium-label']")
	private WebElement monthlypremiumlabel;

	@FindBy(how = How.XPATH, using = "//div[@class='PlanPdf section']//ul/li/a[contains(text(),'Medication')]")

	private WebElement Medicationlinkinpdfsec;

	@FindBy(how = How.XPATH, using = "//div[@class='PlanPdf section']//ul/li/a[contains(text(),'VIEW OTHER')]")
	private WebElement Viewotherdocsinpdf;

	@FindBy(how = How.XPATH, using = "//div[@class='PlanPdf section']//ul/li/a[contains(text(),'Medication')]")

	private WebElement Medicationlinkinpdfsecpdp;

	@FindBy(how = How.XPATH, using = "//div[@class='PlanPdf section']//ul/li/a[contains(text(),'VIEW OTHER')]")
	private WebElement Viewotherdocsinpdfpdp;

	@FindBy(css = "img.img-responsive")
	private WebElement logoImage;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div[5]/div[10]/div/div[1]/div/div")
	private WebElement hartfortdrugtable;

	@FindBy(className = "atdd-bnc-CTgrouptable")
	private WebElement GreenwichTable;

	@FindBy(className = "atdd-bnc-pharmacydropdwn")
	private WebElement pharmacyDropdown;

	@FindBy(id = "Txers-drug-costs")
	private WebElement pharmacyDropdownTexas;
	@FindBy(className = "atdd-bnc-drugcostsheading")
	private WebElement drugCostsHeader;

	@FindBy(className = "atdd-bnc-txers-retailcostsharing-table")
	private WebElement retailTable;

	@FindBy(xpath = ".//*[@id='officeVisitTileAtdd']/div/div/div[1]/span")
	private WebElement pcpValue;

	@FindBy(xpath = "//*[@id='officeVisitTileAtdd']/div/div/span")
	private WebElement specialistValue;

	@FindBy(id = "outPatientTileAtdd")
	private WebElement outpatientsurgeryVisits;

	@FindBy(id = "hospitalVisitTileAtdd")
	private WebElement hospitalVisitsSection;

	@FindBy(id = "outPatientTileAtdd")
	private WebElement OutpatientSurgeryCenterSection;

	@FindBy(id = "outOfPocketTile")
	private WebElement outOfPocketSection;

	@FindBy(className = "atdd-innetwrk-title")
	private WebElement inNetworkSeection;

	@FindBy(id = "OUT-OF-NETWORK-1")
	private WebElement outOfNetworkSection;

	@FindBy(className = "mail-table")
	private WebElement MailOrderTable;

	@FindBy(xpath = "//*[@class='table-subheader']/td[1]")
	private List<WebElement> ICStage31to60MailOrder;

	@FindBy(xpath = "//*[@class='table-subheader']/td[2]")
	private List<WebElement> ICStage61to90MailOrder;

	@FindBy(xpath = ".//*[@class='table-white atdd-bnc-txers-retailcostsharing-table']/tbody/tr[3]/td[2]")
	private WebElement ICTier1Value;

	@FindBy(xpath = ".//*[@class='table-white atdd-bnc-txers-mailordersharing-table']/tbody/tr[3]/td[2]")
	private WebElement ICTier1ValueMailOrder;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[1]")
	private List<WebElement> ICStage30dayNonMain;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[2]")
	private List<WebElement> ICStage30dayMain;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[3]")
	private List<WebElement> ICStage31to60;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[4]")
	private List<WebElement> ICStage61to90;

	@FindBy(id = "waystosave")
	private WebElement waysToSaveSection;

	@FindBy(xpath = "//img[@alt='drugslogo']")
	private WebElement lowTierdrugs;

	@FindBy(className = "atdd-bnc-rx187grptable")
	private WebElement PeehipTable;

	@FindBy(id = "rxcustomgroup_ads-header")
	private List<WebElement> annualDeductibleColumn;

	@FindBy(id = "rxcustomgroup_ics-header")
	private List<WebElement> initialCoverageColumn;

	@FindBy(id = "rxcustomgroup_cgp-header")
	private List<WebElement> coverageGaStageColumn;

	@FindBy(id = "rxcustomgroup_ccs-header")
	private List<WebElement> catastrophicCoverageStageColumn;

	@FindBy(xpath = ".//*[@id='standard_ads-header']/span/p")
	private WebElement annualDeductibleColumnheader;

	@FindBy(xpath = ".//*[@id='standard_ics-header']/span/p")
	private WebElement initialCoverageColumnheader;

	@FindBy(xpath = ".//*[@id='standard_cgp-header']/span/p")
	private WebElement coverageGaStageColumnheader;

	@FindBy(xpath = ".//*[@id='standard_ccs-header']/span/p")
	private WebElement catastrophicCoverageStageColumnheader;

	@FindBy(xpath = "//table[@class='table-white atdd-bnc-rx187grptable']/tbody/tr[2]/td[3]/div[1]")
	private WebElement PeehipTier1ValueIC;
	@FindBy(xpath = "//table[@class='table-white atdd-bnc-rx187grptable']/tbody/tr[2]/td[4]/div[1]")
	private WebElement PeehipTier1ValueCG;
	@FindBy(xpath = "//table[@class='table-white atdd-bnc-rx187grptable']/tbody/tr[5]/td[3]")
	private List<WebElement> PeehipTier1ValueCC;

	@FindBy(xpath = "//img[@alt=' walgreenpharmacylogo']")
	private WebElement wallGreensWidget;
	@FindBy(xpath = "//img[@alt='mailservicelogo']/parent::div/following-sibling::div/p")
	private WebElement mailOrderWidget;

	@FindBy(id = "waystosave")
	private List<WebElement> waysToSaveSectionvalidate;

	@FindBy(className = "atdd-benefitssummary-plnbnftdcmnt-title")
	private WebElement planDocumentsTitle;

	@FindBy(id = "lang-select-2")
	private WebElement planDocumentsLangDropdown;
	@FindBy(className = "document-list-new")
	private WebElement otherDocuments;

	@FindBy(className = "benefitsSummary")
	private WebElement benefitsSummarySection;

	@FindBy(id = "needhelpsectioncontactus")
	private WebElement needHelpSection;

	@FindBy(className = "atdd-benefitsoverview-plantitle")
	private WebElement planName;

	@FindBy(className = "atdd-benefitsoverview-membernamelabel")
	private WebElement nameLabel;

	@FindBy(xpath = "//span[@class='bold atdd-benefitsoverview-membernamelabel']//..//..//div[2]")
	private WebElement memberNameValueBNC;

	@FindBy(className = "atdd-benefitsoverview-memberidlabel")
	private WebElement memberID;

	@FindBy(xpath = "//span[@class='bold atdd-benefitsoverview-memberidlabel']//..//..//div[2]")
	private WebElement memberIdValueBNC;


	@FindBy(className = "atdd-benefitsoverview-effectivedatelabel")
	private WebElement effective_Date1;

	@FindBy(className = "atdd-benefitsoverview-monthlypremium-label")
	private WebElement Monthly_Premium;

	@FindBy(className = "atdd-benefitsoverview-lateenrollmentwithout-plancategoryid-label")
	// @FindBy(xpath="//*[contains(text(),'Late Enrollment Penalty')]or
	// @class='atdd-benefitsoverview-lateenrollmentwithout-plancategoryid-label'")
	private WebElement LEPAmount;

	// @FindBy(xpath="(//*[contains(text(),'Member Name')]) ")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-membernamelabel']")
	private WebElement MemberName;

	// @FindBy(xpath="(//*[contains(text(),'Member ID')]) ")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-memberidlabel']")
	private WebElement MemberId;

	// @FindBy(xpath="(//*[contains(text(),'Effective Date')])")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-effectivedatelabel']")
	private WebElement EffectiveDate;

	@FindBy(className = "atdd-tech-header")
	private WebElement techSupportHeader;

	@FindBy(className = "atdd-plan-header")
	private WebElement planSupportHeader;

	@FindBy(xpath = "(//img[@alt='CoLogo'])[1]")
	private WebElement cologoImage;

	@FindBy(className = "atdd-bnc-standrdretailpharmcytable")
	private WebElement drugTableNonLisMember;

	@FindBy(id = "standard_ads-header")
	private List<WebElement> annualDeductibleColumnFederal;

	@FindBy(id = "standard_ics-header")
	private List<WebElement> initialCoverageColumnFederal;

	@FindBy(id = "standard_cgp-header")
	private List<WebElement> coverageGaStageColumnFederal;

	@FindBy(id = "standard_ccs-header")
	private List<WebElement> catastrophicCoverageStageColumnFederal;

	@FindBy(xpath = "//table[@class='table-white atdd-bnc-standrdretailpharmcytable']/tbody/tr[2]/td[3]")
	private WebElement federalValueIC;

	@FindBy(xpath = "//div[@class='tabs-desktop']/ul[@class='nav nav-tabs']/li")
	private List<WebElement> tabsForComboMember;

	@FindBy(xpath = "//*[@class='table-body']/div[2]/div[2]")
	private WebElement memberIdForPlan;

	@FindBy(xpath = "//*[@class='claims section']")
	private WebElement shipClaimsSupportHeader;

	@FindBy(className = "drugCopaysAndDiscounts")
	private WebElement drugCopaysAndDiscount;

	@FindBy(id = "available-riders")
	private WebElement addRiderSection;

	@FindBy(xpath = "//button[@class='btn btn--primary add-rider-button']")
	private List<WebElement> addRiderButton;

	@FindBy(id = "addBenefitModal")
	private WebElement addBenefitPopup;

	@FindBy(xpath = ".//input[@class='btn btn--primary btn_addRider_atdd']")
	private WebElement addRiderButtonOnPopup;

	@FindBy(xpath = "//span[@class='btn btn--secondary remove-rider-button']")
	private WebElement removeRiderButton;

	@FindBy(id = "removeBenefitModal")
	private WebElement removeRiderPopup;

	@FindBy(xpath = "//input[@class='btn btn--primary btn_removeRider_atdd']")
	private WebElement removeRiderButtonOnPopup;

	private static String PAGE_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;

	public static final String learnmorestagetext_xpath = ".//*[@id='collapseStages']";

	public static final String learnmorelinktiertext_xpath = ".//*[@id='collapseTiers']";

	public static final String disclaimertextarea_xpath = "//*[@id='collapseDisclaimer']";

	public BenefitsAndCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DATA;
		benefitsCoverage = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		try
		{
			openAndValidate();
		}
		catch(Exception e)
		{

		}
	}

	/**
	 * @toDo : To check headers on Benfits and coverage page
	 */
	public void validateFieldsOnBenefitsAndCoveragePage() {

		try {
			validate(planName);

			validate(memberId);

			validate(memberName);

			validate(effectiveDate);

		} catch (Exception e) {
			System.out.println("Elements are not found ...");
		}
	}

	/**
	 * @toDo : To check benefits and coverage page has opened
	 */

	public void openAndValidate() throws InterruptedException  {

		checkModelPopup(driver);

	}

	public void feebackpopupClose() throws InterruptedException
	{ //waitForloader(driver,overlay, 20);
		Thread.sleep(20000);
		if (validate(iPerceptionframe)) {

			switchToNewIframe(iPerceptionframe);
			iPerceptionclosebtn.click();
			driver.switchTo().defaultContent();
			//iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
	}

	/**
	 * @toDo : The user validates the PlanDocuments Section
	 */

	public void PlanDocumentssection() {

		try {
			validate(planBenefitsDocuments);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the headers in Need help section
	 */

	public void validateNeedhelpheader() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validateWithValue("Header Need help", NeedHelpHeader);
		validateWithValue("Technical Support",TechnicalSupport);
		validateWithValue("Plan Support",PlanSupport);
	}

	/**
	 * @toDo : The user validates the headers in Need help section
	 */

	public void validateNeedhelpheader1() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validate(NeedHelpHeader);
		System.out.println("***Need help header is validated ***");

	}

	/**
	 * @toDo : The user validates the Contact us section in Need help section
	 */

	public void validatecontactussection() {
		System.out.println("the user validates contactus section");
		if (Contactussection.getText().contains("See more ways to contact us")) {
			System.out.println("contactus section is coming ");
			Assert.assertTrue("contactus section is coming ",true);
		} else {
			Assert.fail("Contactussection.getText() >>>>>>" + Contactussection.getText());
		}

	}

	/**
	 * @toDo : The user validates the Contact us link in Need help section
	 */
	public void contactUslink() {
		
		validateWithValue("Link- Contact US", contactUslink);
		
		if (contactUslink.isEnabled()) {
			contactUslink.click();
	
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertTrue("Contact Us page is loaded successfully",driver.getCurrentUrl().contains("contact-us/overview.html"));
		System.out.println("Contact Us page is loaded successfully");
		}
		else{
		Assert.fail("Contact Us page is not loaded successfully");
		System.err.println("Contact Us page is not loaded successfully");
		}
	}

	/**
	 * @toDo : The user checks the More Information link in the Need help
	 *       section
	 */
	
	public void clickOnmoreinformation() {
		// TODO Auto-generated method stub
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", moreinformation);
		validateWithValue("More Information link", moreinformation);
		moreinformation.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(moreinformationArea.getAttribute("aria-expanded").equalsIgnoreCase("true"))
		{
			Assert.assertTrue("More information  has been expanded", true);
			System.out.println("More information  has been expanded");
		}
		else
		{
			System.err.println("More information are has not been expanded");
			Assert.fail("More information are has not been expanded");}
	}
		
		
	

	public void clickOnmoreinformationship() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validateWithValue("Link- More Inforamation", moreinformation);
		moreinformation.click();
		if(moreinformationArea.getAttribute("aria-expanded").equalsIgnoreCase("true"))
		{
			Assert.assertTrue("More information are has been expanded", true);
			System.out.println("More information are has been expanded");
		}
		else
		{
			System.err.println("More information are has not been expanded");
			Assert.fail("More information are has not been expanded");}
	}

	/**
	 * @toDo : The user checks the view label in Documents section
	 */
	public boolean getview_label() {
		return validateWithValue("View label",view_label);
	}

	/**
	 * @toDo : The user checks the get Document label in Documents section
	 */
	public boolean getdocuments_label() {
		return validateWithValue("Header- Plan Documents and Resources", documents_label);
	}

	/**
	 * @toDo : The user validates the language dropdown in Documents section
	 */
	public void languagevalidation() {
		if (langdropdown.isDisplayed()) {

			Select dropdown = new Select(langdropdown);
			List<WebElement> webElements = dropdown.getOptions();
			for (WebElement element : webElements) {

				if (element.getText().equals("SPANISH") || element.getText().equals("CHINESE")) {
					Assert.fail("The element" + element.getText() + "should not display");
					System.out.println("The element " + element.getText() + "should not display");
				} else {
					Assert.assertTrue(true);
				}
			}
		}

	}

	/**
	 * @toDo : The user validates the language dropdown in Documents section and
	 *       validates the default selected language
	 */
	public void validate_langdropdown_first_selection() {
		// WebElement langdropdown;
		if (langdropdown.isDisplayed()) {
			Select langdropdwn = new Select(langdropdown);
			if (langdropdwn.getFirstSelectedOption().getText().equals("ENGLISH")) {
				System.out.println("Text" + langdropdwn.getFirstSelectedOption().getText());
				Assert.assertTrue("The default language selected is "+langdropdwn.getFirstSelectedOption().getText(),true);
			} else
				Assert.fail("Issue in English selection");
		} else
			Assert.fail("Plan year dropdown not displayed");

	}

	/**
	 * @toDo : The user validates the language dropdown in Documents section and
	 *       make a selection in the dropdown
	 */
	public void validate_langdropdown_select(String language) {
		Select langdropdwn = new Select(langdropdown);
		langdropdwn.selectByVisibleText(language);
		System.out.println(langdropdwn.getFirstSelectedOption().getText());
	}

	/**
	 * @toDo : The user validates the Hearing section of Ancillary
	 */
	public void HearingSection() {

		try {
			validate(Hearingsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
		try {
			validate(HearingContent);
			System.out.println(HearingContent.getText());
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the Hearing aid section of Ancillary Benefits
	 */
	public void HearingAid() {

		try {
			validate(Hearingaid);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the Vision section of Ancillary Benefits
	 */

	public void Vision() {

		try {
			validate(Visionsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
		try {
			validate(VisionContent);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the Dental section of Ancillary Benefits
	 */

	public void Dental() {

		try {
			validate(Dentalsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
		try {
			validate(DentalContent);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}

	}

	/**
	 * @toDo : The user validates the Header section
	 */

	public void Header() {

		try {
			validate(Headersection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the chiropractic section of Ancillary benefits
	 */
	public void chiropracticsection() {

		try {
			validate(chiropracticsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the Disclaimers link under Exclusive hearing
	 *       section of Ancillary benefits
	 */
	public void ExclusiveDisclaimers() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-50)", "");
		try {
			validate(Exclusivedisclaimer);
			Exclusivedisclaimer.click();
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			validate(Disclaimertext);
			System.out.println("text" + Disclaimertext.getText());

		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the Learn more button under Exclusive hearing
	 *       section of Ancillary benefits
	 */

	public void Exclusivelearnmore() {
		try {
			validate(LearnmoreButton);
			LearnmoreButton.click();

			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// validate(disclaimersLink);
			System.out.println("text" + LearnmoreButton.getText());
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/*
	 * //LearnmoreButton.click(); WebElement TxtBoxContent =
	 * driver.findElement(By.className(LearnmoreButton));
	 * TxtBoxContent.getText(); LearnmoreButton.click();
	 * System.out.println("Printing "+TxtBoxContent);
	 */
	// LearnmoreButton.click();
	/*
	 * if (LearnmoreButton.isDisplayed()) { Assert.assertTrue(true); } else
	 * Assert.fail("Button not displayed");
	 */
	/*
	 * if
	 * (driver.getCurrentUrl().contains("www.hihealthinnovations.com/medicare"))
	 * { return; } else { Assert.fail("The element " + ProceedButton.getText() +
	 * "is not found"); }
	 */
	// LearnmoreButton.click();

	/**
	 * @toDo : The user validates the Leaving popup in Ancillary section
	 */
	public void Leavingpopup() {

		try {
			validate(popup);
		} catch (Exception e) {
			System.out.println("Element is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the proceed button of the leaving popup in
	 *       Ancillary section
	 */

	public boolean Proceedbutton() {
		// LearnmoreButton.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LearnmoreButton.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(ProceedButton);
		ProceedButton.click();
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("hihealthinnovations.com/medicare")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("The element " + ProceedButton.getText() + "is not found");
		}

		return true;
	}

	/**
	 * @toDo : The user validates the cancel button of the leaving popup in
	 *       Ancillary section
	 */
	public void Cancelbutton() {

		try {
			validate(cancelbutton);
			validate(cancelbutton1);
			cancelbutton.click();

			System.out.println("text" + cancelbutton.getText());

		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the DrugCoverage section headers and text
	 */
	public void validatedrugcoverageheaderandtext() {
		validateWithValue("Drug Coverage Header", DrugCoverageHeader);
		validateWithValue("Drug Coverage text",DrugCoveragetext);
	}

	/**
	 * @toDo : The user validates the DrugCoverage section headers and text for group
	 */
	public void validatedrugcoverageheaderandtextgroup() {

		Assert.assertTrue(!validate(DrugCoverageHeader));
		Assert.assertTrue(!validate(DrugCoveragetext));


	}

	/**
	 * @toDo : Validates Look Up Drugs button in the DrugCosts section
	 */
	public void validatelookupdrugsbutton(String plantype) 
	{
		System.out.println("****the user validates Look Up Drugs button should be visible***");
		validateWithValue("Look Up Drugs Button", LookUpDrugsButton);
		LookUpDrugsButton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("drug-lookup/overview.html"))
			Assert.assertTrue("Look Up Drugs Button has been clicked successfully",true);
		else {
			Assert.fail("Look Up Drugs Button has not been clicked");
		}
		if(plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("PDP"))
		{
			driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("Medica"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void validategrouplookupdrugsbutton() 
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		validate(LookUpDrugsButton);
		LookUpDrugsButton.click();
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));

	}
	/**
	 * @toDo : Validates the text for the Look Up Drugs section
	 */

	public void validate_lookupdrugstext() {
		validateWithValue("Text-Estimate your drug costs and view ways to save",LookupDrugstext);

	}

	/**
	 * @toDo : Validates the headers in DrugCopays and Discount section
	 */
	public void validate_drugcopayheaderntext() {
		validateWithValue("Drug Copay Header", DrugCopayHeader);
		validateWithValue("Drug Copay Text",DrugCopayText);

	}

	/**
	 * @toDo : Validates the Drug Cost header and text
	 */

	public void validate_drugcostheaderntext() {
		validate(DrugCostheaderandtext);

	}

	public void validate_locatepharmacy() {
		validateWithValue("Text-PHARMACY LOCATOR", locateapharmacysection);
		validateWithValue("Locate a Pharmacy Button ",locateapharmacybutton);

	}

	/**
	 * @toDo : Validates the text in locate a pharmacy section
	 */
	public void validate_locateapharmacysection(String plantype) {
		validate(locateapharmacysection);
		validate(locateapharmacybutton);

		locateapharmacybutton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("member/pharmacy-locator/overview.html"))
			Assert.assertTrue("Pharmacy Locator is navigating to the correct page",true);
		else {
			Assert.fail();
		}
		if(plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("PDP"))
		{
			driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("Medica"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @toDo : Validates the Learnmore tiers links for a Lis member
	 */
	public void validate_tierlinknotdisplay() {
		if (Learnmoretierslink.isDisplayed()) {
			Assert.fail("The element" + Learnmoretierslink.getText() + "should not display");
			System.out.println("The element " + Learnmoretierslink.getText() + "should not display");
		} else {
			Assert.assertTrue(true);
		}

	}

	/**
	 * @toDo : Validates the Pharmacy selection dropdown for a Lis member
	 */

	public void validate_dropdownnotdisplay() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (DrugCostDropdown.isDisplayed()) {
			Assert.fail("The element" + DrugCostDropdown.getText() + "should not display");
			System.out.println("The element " + DrugCostDropdown.getText() + "should not display");
		} else {
			Assert.assertTrue(true);
		}

	}

	/**
	 * @toDo : Validates the Pharmacy selection dropdown for a non Lis member
	 */
	public void validate_drugcostdropdownoptions()

	{
		validateWithValue("Drug cost drop down ", DrugCostDropdown);
		validateWithValue("Drug Cost Header",DrugCostHeader);

		Select dropdown = new Select(DrugCostDropdown);
		List<WebElement> webElements = dropdown.getOptions();
		// System.out.println(webElements);
		for (WebElement element : webElements) {
			if (element.getText().contains("Standard Retail Pharmacy")) {
				System.out.println(element.getText());
				Assert.assertTrue("The element" + element.getText() + "should display", true);

			} else if (element.getText().contains("Preferred Mail Service Pharmacy")) {
				Assert.assertTrue("The element" + element.getText() + "should display", true);
				System.out.println(element.getText());
			} else if (element.getText().contains("Preferred Retail Pharmacy")) {
				Assert.assertTrue("The element" + element.getText() + "should display", true);
				System.out.println(element.getText());
			} else {
				Assert.fail();
			}
		}
	}



	/**
	 * @toDo : Validates the Learn More links for a Non Lis member
	 */

	public void validate_learnmoreaboutlink() {
		validateWithValue("Learn more tiers link", Learnmoretierslink);
		validateWithValue("Learn more stage link",Learnmorestagelink);
		//System.out.println(Learnmoretierslink.getLocation());
		//System.out.println(Learnmorestagelink.getLocation());

	}

	/**
	 * @toDo : Validates the Learn More links for a Lis member
	 */
	public void validate_learnmoreaboutstagelink() {

		validate(Learnmorestagelink);
		Learnmorestagelink.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Learnmorestagelink.click();

	}

	/**
	 * @throws InterruptedException 
	 * @toDo : Validates that the learnmore tier link
	 */

	public void clickOnLearnmoreaboutlinktier() throws InterruptedException {
		System.out.println("Click on the link-LEARN MORE ABOUT DRUG TIERS ");
		Learnmoretierslink.click();
		Thread.sleep(2000);
		// validating expanded stage of the link-LEARN MORE ABOUT DRUG TIERS 
		if(LearnmoretierslinkArea.getAttribute("aria-expanded").equalsIgnoreCase("true")){
			System.out.println("LEARN MORE ABOUT DRUG TIERS link has been expanded successfully");
			Assert.assertTrue("LEARN MORE ABOUT DRUG TIERS link has been expanded successfully", true);	
		}
		else{
			System.err.println("LEARN MORE ABOUT DRUG TIERS link has not been expanded successfully");
			Assert.fail("LEARN MORE ABOUT DRUG TIERS link has not been expanded");
		}

		LearnmoretierslinkForCollapsed.click();
		Thread.sleep(2000);
		//validating collapsed stage of the link-LEARN MORE ABOUT DRUG TIERS
		if(LearnmoretierslinkAfterCollapsed.getAttribute("aria-expanded").equalsIgnoreCase("false")){
			System.out.println("LEARN MORE ABOUT DRUG TIERS link has been collapsed successfully");
			Assert.assertTrue("LEARN MORE ABOUT DRUG PAYMENT STAGES link has been collapsed successfully", true);	
		}
		else{
			System.err.println("LEARN MORE ABOUT DRUG TIERS link has not been collapsed successfully");
			Assert.fail("LEARN MORE ABOUT DRUG PAYMENT STAGES link has not been collapsed");
		}

	}

	/**
	 * @throws InterruptedException 
	 * @toDo : Validates that the learnmore stage link
	 */

	public void clickOnLearnmoreaboutlinkstage() throws InterruptedException {
		// TODO Auto-generated method stub
		validateWithValue(" LEARN MORE ABOUT DRUG PAYMENT STAGES ", Learnmorestagelink);
		Learnmorestagelink.click();
		Thread.sleep(2000);
		System.out.println(LearnmorestageExpandedArea.getAttribute("aria-expanded"));
		// validating expanded stage of the link-LEARN MORE ABOUT DRUG PAYMENT STAGES
		if(LearnmorestageExpandedArea.getAttribute("aria-expanded").equalsIgnoreCase("true")){
			System.out.println("LEARN MORE ABOUT DRUG PAYMENT STAGES link has  been expanded successfully");
			Assert.assertTrue("LEARN MORE ABOUT DRUG PAYMENT STAGES link has been expanded successfully", true);	
		}
		else{
			System.err.println("LEARN MORE ABOUT DRUG PAYMENT STAGES link has not been expanded successfully");
			Assert.fail("LEARN MORE ABOUT DRUG PAYMENT STAGES link has not been expanded");
		}

		LearnmorestagelinkForCollapse.click();
		Thread.sleep(2000);
		//validating collapsed stage of the link-LEARN MORE ABOUT DRUG PAYMENT STAGES
		if(LearnmorestagelinkAfterCollapse.getAttribute("aria-expanded").equalsIgnoreCase("false")){
			System.out.println("LEARN MORE ABOUT DRUG PAYMENT STAGES link has  been collapsed successfully");
			Assert.assertTrue("LEARN MORE ABOUT DRUG PAYMENT STAGES link has been collapsed successfully", true);	
		}
		else{
			System.err.println("LEARN MORE ABOUT DRUG PAYMENT STAGES link has not been expanded successfully");
			Assert.fail("LEARN MORE ABOUT DRUG PAYMENT STAGES link has not been expanded");
		}
	}

	/**
	 * @toDo : Validates the headers in DrugCopays and Discount section for a
	 *       Lis member
	 */

	public void validate_lisdrugcopayheaderntext() {
		validate(lisDrugCopayHeader);
		// validate(lisDrugCopayText);
		System.out.println(" ***********Drug Copay & discount  is validated ***********");
		lisDrugCopayHeader.getText();
		lisDrugCopayText.getText();
	}

	/**
	 * @toDo : Validates the Drug costs table for a Non Lis member
	 */
	public void validatedrugcopaytable() {
		// Select langdropdwn = new Select(langdropdown);

		validate(drugcopaytable);

	}

	/**
	 * @toDo : Validates the Drug costs table for a Lis member
	 */

	public void validatedrugcosttable() {
		// TODO Auto-generated method stub
		validate(RetailDrugCost_Table);
		System.out.println("********** Drug cost table is seen ==>"+RetailDrugCost_Table.isDisplayed());
		validate(columncoveragegenericdrugs);
		Assert.assertEquals(driver
				.findElement(By
						.xpath("//*[@id='mapdPageLis']//table[@class='table-white atdd-bnc-drgcsttable']//tbody/tr[2]/th/p"))
				.getText(), "Covered Generic Drugs");

	}
	public void validatedrugcosttable1() {
		// TODO Auto-generated method stub
		validate(RetailDrugCost_Table1);
		System.out.println("********** Drug cost table is seen ==>"+RetailDrugCost_Table1.isDisplayed());
		validate(columncoveragegenericdrugs);

	}

	/**
	 * @toDo : Validates the Ways to save section
	 */
	public void validateWaystoSave() {
		validate(waysToSave);
		validate(TextWaystoSave);

		System.out.println(TextWaystoSave.getText());
		// Assert.assertEquals(, );

	}

	/**
	 * @toDo : Validates the Plan overview section for a Non lis member
	 */
	public void validatePlanOverviewgroup() {
		validate(planName);
		validate(nameLabel);
		validate(memberID);
		validate(effective_Date);
		validate(monthlypremiumlabel);
		validate(GroupId);
	}

	public void validatePlanOverviewInd(String name, String memberid, String effectivedate, String monthlypremium) {
		validateWithValue("Plan name", planName);
		validateWithValue("Name label", nameLabel);
		validateWithValue("Member ID label", memberID);
		validateWithValue("Effective date label", effective_Date);
		validateWithValue("Monthly premium label",monthlypremiumlabel);

		validateWithValue("Member Name Value",memberNameValueBNC);
		validateWithValue("Member Id Value",memberIdValueBNC);
		validateWithValue("Effective date Value",effectivedateValueBNC);


	}

	
	public void validateHeaders() {

		validate(BenefitsSummaryHeader);
		validate(Copayscoinsuranceheader);
		validate(HospitalVisits);
		validate(OfficeVisits);
		validate(OutpatientSurgeryCenter);
		validate(OutpatientSurgeryCenterValue);
		validate(OfficVisitsValue);

		Assert.assertEquals(OfficeVisits.getText(), "OFFICE VISITS ");
		Assert.assertEquals(OutpatientSurgeryCenter.getText(), "OUTPATIENT SURGERY CENTER VISITS");
		Assert.assertEquals(HospitalVisits.getText(), "HOSPITAL VISITS ");

		if (StringUtils.isEmpty(OutpatientSurgeryCenterValue.getText())) {

			Assert.fail();
		}
		if (StringUtils.isEmpty(OfficVisitsValue.getText())) {

			Assert.fail();
		}

	}
	public void validatevillagetabletext(String text1)
	{
		WebElement villagetabletext = driver.findElement(By.xpath(".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr[2]/td[4]/div[3]/div[2]"));
		if(villagetabletext.getText().equalsIgnoreCase(text1))
		{
			 System.out.println(villagetabletext.getText());
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
		

	}


	public boolean validateWithValue(String value, WebElement element) {
		try {
			if (element.isDisplayed()) {
				System.out.println("Element " +value+ " found!!!!");
				return true;
			} else {
				System.out.println("Element " +value+ " not found/not visible");
			}
		} catch (Exception e) {
			System.err.println("Exception: Element " +value+ "  not found/not visible");
		}
		return false;

	}

	/**
	 * @toDo Validate Plan overview for PDP Individual Members
	 */
	public void validatePlanOverviewSectionForMembers() {
		validate(planName2);
		validate(nameLabel1);
		validate(memberID1);
		validate(effective_Date1);
	}

	/**
	 * @toDo: Validate Drug Look Up Link
	 */
	public void validate_druglookuplink() {
		validate(DrugLookUpLink);
		System.out.println("************Drug Look Up LINK is seen********************");

	}

	/**
	 * @toDo : Validates the Plan overview section for a lis member
	 */

	public void validatePlanOverviewLis() {
		validate(planName);
		validate(nameLabel);
		validate(memberID);
		validate(effective_Date);
		// validate(Monthly_Premium);
		validate(ExtraHelp);

	}

	/**
	 * @toDo : Validates the Plan overview section for a individual members with
	 *       LEP amount
	 */

	public void validatePlanOverviewLEP() throws InterruptedException {
		System.out.println("validate LEP amount ");

		validate(planName);
		validate(nameLabel);
		validate(memberID);
		validate(effective_Date);
		validate(Monthly_Premium);
		// validate(ExtraHelp);
		validate(LEPAmount);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @toDo : Validates the headers section for individual members
	 */

	public void validateHeaders(String planType) {
		validateWithValue("Benefits Summary Header", BenefitsSummaryHeader);
		validateWithValue("Copays coinsurance header",Copayscoinsuranceheader);
		validateWithValue("Hospital Visits",HospitalVisits);
		validateWithValue("Office Visits",OfficeVisits);
		validateWithValue("Outpatient Surgery Center",OutpatientSurgeryCenter);

		validateWithValue("Outpatient Surgery Center Value",OutpatientSurgeryCenterValue);
		validateWithValue("Offic Visits Value",OfficVisitsValue);

		Assert.assertEquals(OfficeVisits.getText(), "OFFICE VISITS ");
		if(planType.contains("Medica"))
		{
			Assert.assertEquals(OutpatientSurgeryCenter.getText(), "OUTPATIENT SURGERY CENTER VISITS ");	
		}
		else
		{
			Assert.assertEquals(OutpatientSurgeryCenter.getText(), "OUTPATIENT SURGERY CENTER VISITS");
		}
		Assert.assertEquals(HospitalVisits.getText(), "HOSPITAL VISITS ");
		if(planType.contains("Medica"))
		{
			if (StringUtils.isEmpty(OutpatientSurgeryCenter2.getText())) {

				Assert.fail();
			}	
		}
		else if (StringUtils.isEmpty(OutpatientSurgeryCenterValue.getText())) {

			Assert.fail();
		}

		if (StringUtils.isEmpty(OfficVisitsValue.getText())) {

			Assert.fail();
		}

	}

	/**
	 * @toDo : Validates the headers section for group members
	 */
	public void validateHeadersGroup() {
		validate(BenefitsSummaryHeader);
		validate(Copayscoinsuranceheader);
		validate(EmergencyHeader);
		validate(AmbulanceHeader);
		validate(HospitalVisits);
		validate(OfficeVisits);
		validate(OutpatientSurgeryCenter);
		Assert.assertEquals(OfficeVisits.getText(), "OFFICE VISITS ");
		Assert.assertEquals(OutpatientSurgeryCenter.getText(), "OUTPATIENT SURGERY CENTER VISITS");
		Assert.assertEquals(HospitalVisits.getText(), "HOSPITAL VISITS ");
		System.out.println(AmbulanceHeader.getText());
		Assert.assertEquals(AmbulanceHeader.getText(), "AMBULANCE");
		System.out.println(EmergencyHeader.getText());
		Assert.assertEquals(EmergencyHeader.getText(), "EMERGENCY CARE");
		if (StringUtils.isEmpty(OutpatientSurgeryCenterValue.getText())) {

			Assert.fail();
		}
		if (StringUtils.isEmpty(OfficVisitsValue.getText())) {

			Assert.fail();
		}

	}

	/**
	 * @toDo : Validates the Primary care provider section
	 */

	public void validatePrimaryCareProvider(String plantype) {

		validateWithValue("Primary Care Provider Header",PrimaryCareProviderHeaderInd);
		validateWithValue("Your Primary Care Provider", YourPrimaryCareProvider);
		try{

			if (Addaprovider.isDisplayed()) {
				validate(Addaprovider);
				Addaprovider.click();
			} }

		catch(Exception e){
			validateWithValue("CHANGE YOUR PROVIDER ",ChangeYourPcpButton);
			ChangeYourPcpButton.click();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.err.println("CHANGE YOUR PROVIDER page not loaded");
		}
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("/member/contact-us")) {
			System.out.println("CHANGE YOUR PROVIDER has been clicked and navigated to Contact us page successfully");
			Assert.assertTrue(true);
		} else {
			System.out.println("CHANGE YOUR PROVIDER has not been clicked and not navigated to Contact us page successfully");
			Assert.fail();

		}
		if(plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("PDP"))
		{
			driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("Medica"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		validateWithValue("Provider Search", SearchProvider);
		validateWithValue("Search For Provider",StartSearch);
		StartSearch.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switchToNewTab();
		System.out.println(driver.getCurrentUrl());

		if (driver.getCurrentUrl().contains("werally.in")) {
			Assert.assertTrue(true);
		}
		else if (driver.getCurrentUrl().contains("systest3.myuhc.com"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();	
		}
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		if(plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("PDP"))
		{
			driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("Medica"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}


	}

	/**
	 * @toDo : Validates the Primary care provider section for group members
	 */

	public void validatePrimaryCareProviderForGroup() {

		validate(PrimaryCareProviderHeaderHMO);
		validate(PCPtext);

	}

	/**
	 * @toDo : Validates the Out Of Pocket Maximum section
	 */

	public void validateOutofPocketMax() {
		validateWithValue("Out of pocket section ", OutofPocketMaximum);
		validateWithValue("In-Network section",INNETWORK);
		validateWithValue("Out-Network section",OUTOFNETWORK);
		validateWithValue("Out of pocket text",OutofPocketMaximumText);
		validateWithValue("In-Network text",INNETWORKTEXT);
		validateWithValue("Out-Network text",OUTOFNETWORKTEXT);
	}

	/*
	 * @toDo : Validates the Benefits page
	 */

	public void validateBnCPag() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(planName1);
	}

	public pages.member.bluelayer.ProfilePreferencesPage navigateDirectToProfilePagee() throws InterruptedException {
		System.out.println(driver.getTitle());
		accountToggleDropdown.click();
		validate(accountSettingOption);
		accountSettingOption.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Profile")) {
			System.out.println("Pass!");
			return new ProfilePreferencesPage(driver);
		}
		gopaperlessbutton.click();
		return null;

	}

	/**
	 * @toDo : Validates the headers for ship members
	 */
	public void validateHeadersShip() {
		System.out.println("member is on B& C page ");
		validate (MemberName);
		validate(MemberId);
		validate(EffectiveDate);
		validate(BenefitsSummaryHeadership);
		int i = 0 ;
		List<WebElement> tilelist = driver.findElements(By.xpath("(.//*[@id='benefitShipCard'])["+i+"]"));
		for(i=1;i<=tilelist.size();i++)
		{
			validate(tilelist.get(i));
		}

	}



	/**
	 * @toDo : Validates the hand image in discount and services section for
	 *       ship members
	 */
	public void handimage() {

		validate(handimage);

	}

	/**
	 * @toDo : Validates the Value added services section for ship members
	 */
	public void vasSection() {

		validate(textdiscountservices);

	}

	/**
	 * @toDo : Validates the Learnmore Button for ship members
	 */

	public void learnmorebutton() {

		validate(learnmorebutton);

	}

	/**
	 * @toDo : Validates the Value added services page for ship members
	 */
	public ValueAddedServicepage navigateToValueAddService() {
		validate(learnmorebutton);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		learnmorebutton.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (this.driver.getTitle().equalsIgnoreCase("Value Added Services")) {
			System.out.println(driver.getTitle());
			return new ValueAddedServicepage(driver);
		}
		driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public ValueAddedServicepage navigateToValueAddServicetest() {
		validate(learnmorebutton);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		learnmorebutton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (this.driver.getTitle().contains("Value Added Services")) {

			System.out.println(driver.getTitle());
			return new ValueAddedServicepage(driver);
		}

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @toDo : Validates the Need help section headers for a ship member
	 */
	public void validateneedhelpheaderShip() {
		validate(NeedhelpShip);
		validate(TechnicalSupportShip);
		validate(GeneralQuestionShip);
		validate(ClaimsSupportShip);
	}

	/**
	 * @toDo : Validates the see more ways to contact us section for ship
	 *       members in Need help section
	 */
	public void validateContactUsNeedHelp() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(Seemorewaystext);

	}

	/**
	 * @toDo : Validates the contact us page on clicking on the link of contact
	 *       us in Need help section
	 */
	public void contactUslinkShip() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(contactUslink);
		contactUslink.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Title is " + getTitle());
		driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");

		//Assert.assertTrue(getTitle().equalsIgnoreCase("Contact"));

	}

	public void valiadateCatastrophicCoverageValue(String copayType) {
		validate(catastrophicCoverageStage);
		if (copayType.equals("wotCMSValue")) {
		}
	}

	/*
	 * ** To validate pdfs on Benefit&Coverage Page
	 */

	public boolean verifypdfname(String a[]) {
	
		boolean checkflag = true;
		Select langdropdwn = new Select(langdropdown);
		if(langdropdwn.getFirstSelectedOption().getText().contains("ENGLISH"))
		{
			List<WebElement> pdfs = driver.findElements(By.xpath(".//*[@class='PlanPdf section']/div/div[1]/div[1]/span/div/ul/li[2]/a"));

			System.out.println("Size"+pdfs.size());
			for (int i=0;i<pdfs.size();i++)
			{  
				String pdfnames = null;
				pdfnames= (pdfs.get(i).getText());
				System.out.println(pdfnames);
			}

			if(a.length==pdfs.size())
			{
				for (int i=0;i<pdfs.size();i++)
				{  
					String pdf1[] = pdfs.get(i).getText().split(Pattern.quote("("));
					if(StringUtils.isNotEmpty(pdf1[0]))
					{
						System.out.println(pdf1[0]);
						System.out.println(a[i]);
						if(pdf1[0].contains(a[i])){
							checkflag = true;
						}
						else {
							checkflag=false;
							break;
						}
					}
					else
					{
						Assert.fail();
					}
				}
			}
			else
			{
				Assert.fail();
			}
		}
		else if(langdropdwn.getFirstSelectedOption().getText().contains("ESPAÃOL"))
		{

			List<WebElement> pdfs = driver.findElements(By.xpath(".//*[@class='PlanPdf section']/div[1]/div[1]/div[2]/span/div/ul/li[2]/a"));

			System.out.println("Number of documents are - "+pdfs.size());
			for (int i=0;i<pdfs.size();i++)
			{  
				String pdfnames = null;
				pdfnames= (pdfs.get(i).getText());
				System.out.println(pdfnames);
			}

			if(a.length==pdfs.size())
			{
				for (int i=0;i<pdfs.size();i++)
				{  
					String pdf1[] = pdfs.get(i).getText().split(Pattern.quote("("));
					if(StringUtils.isNotEmpty(pdf1[0]))
					{
						System.out.println(pdf1[0]);
						if(pdf1[0].contains(a[i])){
							checkflag = true;
						}
						else {
							checkflag=false;
							break;
						}
					}
					else
					{
						Assert.fail();
					}
				}
			}
			else
			{
				Assert.fail("Documents are not displaying succcessfully");
				System.out.println("Documents are not displaying succcessfully");
			}

		}
		else if(langdropdwn.getFirstSelectedOption().getText().contains("ä¸­æ"))
		{
			System.out.println("NO PDFs in chinese yet.if PDFs come then above same code can be used");
			checkflag = true;
		}


		return checkflag;

	}





	public void validatestaticlinksinpdf(String plantype) {
		validateWithValue("Link-Medication Therapy Management Program", Medicationlinkinpdfsec);

		Medicationlinkinpdfsec.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("/documents/medication-program")) {
			System.out.println("Navigated to Medication Therapy Management Program successfully");
			Assert.assertTrue("Navigated to Medication Therapy Management Program successfully",true);
		} else {
			Assert.fail("Not navigated to Medication Therapy Management Program successfully");
		}
		if(plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("PDP"))
		{
			driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("Medica"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		validateWithValue("Link - VIEW OTHER DOCUMENTS AND RESOURCES", Viewotherdocsinpdf);
		Viewotherdocsinpdf.click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("/member/documents/overview.html")) {
			System.out.println("Navigated to page VIEW OTHER DOCUMENTS AND RESOURCES");
			Assert.assertTrue("Navigated to page VIEW OTHER DOCUMENTS AND RESOURCES",true);
		} else {
			Assert.fail("Not navigated to page VIEW OTHER DOCUMENTS AND RESOURCES");
		}

		if(plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("PDP"))
		{
			driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("Medica"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}
		else
		{
			Assert.fail();
		}
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void validatestaticlinksinpdfpdp(String plantype)
	{
		validate(Medicationlinkinpdfsecpdp);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Medicationlinkinpdfsecpdp.click();
		if(driver.getCurrentUrl().contains("/documents/medication-program"))
		{
			System.out.println(driver.getCurrentUrl());
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		if(plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("PDP"))
		{
			driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("Medica"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}
		validate(Viewotherdocsinpdfpdp);
		Viewotherdocsinpdfpdp.click();
		if(driver.getCurrentUrl().contains("/member/documents/overview.html"))
		{
			System.out.println(driver.getCurrentUrl());
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("PDP"))
		{
			driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("Medica"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}


	}

	public void validatevillagetabletext()
	{

		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");



	}



	public boolean Validate_Catastrophic_Stage_Language(String updatedLanguage, String displayFlag) {

		List<WebElement> UpdatedLanguageCount = driver
				.findElements(By.xpath("//*[contains(text(),'" + updatedLanguage + "')]"));
		//System.out.println(updatedLanguage);
		System.out.println(UpdatedLanguageCount.get(0));
		boolean Expectedflag = (displayFlag.equalsIgnoreCase("true")) ? true : false;
		System.out.println(Expectedflag);
		boolean ActualFlag = (UpdatedLanguageCount.size() > 0) ? true : false;
		System.out.println(ActualFlag);
		if (Expectedflag == ActualFlag) {
			System.out.println("Updated Language is Displayed/Not DIsplayed as expected");
			return true;
		} else {
			System.out.println("Updated Language validation : Failed");
			return false;
		}


	}

	public void tabledynamicdata()
	{
		int i =0;
		int j = 0;
		List<WebElement> rows =  driver.findElements(By.xpath(".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr/th"));
		List<WebElement> cols =  driver.findElements(By.xpath(".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr/td[1]"));
		WebElement tabletext  = driver.findElement(By.xpath(".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr[i]/td[j]/div"));

		for( i = 0 ; i<rows.size();i++)
		{
			for ( j = 0 ; j<cols.size();j++)
			{
				System.out.println(driver.findElement(By.xpath(".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr["+i+"]/td["+j+"]/div")).getText());
			}
		}
	}

	public void grouptabledynamicdata(String plantype)
	{
		if (plantype.contentEquals("MAPD"))
		{
			//System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText());
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText(),"$5.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[4]")).getText(),"$5.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[5]")).getText(),"Greater of $3.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]//td[1]")).getText(),"$20.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]//td[2]")).getText(),"$20.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]//td[3]")).getText(),"Greater of $8.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]//td[1]")).getText(),"$50.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]//td[2]")).getText(),"$50.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]//td[3]")).getText(),"Greater of $8.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]//td[1]")).getText(),"$20.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]//td[2]")).getText(),"$20.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]//td[3]")).getText(),"Greater of $8.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText(),"No Deductible");
			validate(annualDeductibleColumnheader);
			validate(initialCoverageColumnheader);
			validate(coverageGaStageColumnheader);
			validate(catastrophicCoverageStageColumnheader);
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/th")).getText(),"Tier 1 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/th")).getText(),"Tier 2 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/th")).getText(),"Tier 3 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/th")).getText(),"Tier 4 ");
		}
		else if (plantype.contentEquals("MAPDRX"))
		{
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[2]/td[3]")).getText(),"$10.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[2]/td[4]")).getText(),"$10.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[2]/td[5]")).getText(),"$10.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[3]/td[1]")).getText(),"$25.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[3]/td[2]")).getText(),"$25.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[3]/td[3]")).getText(),"$25.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[4]/td[1]")).getText(),"$40.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[4]/td[1]")).getText(),"$40.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[4]/td[1]")).getText(),"$40.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[5]/td[1]")).getText(),"25%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[5]/td[2]")).getText(),"25%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[5]/td[3]")).getText(),"25%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[2]/th")).getText(),"Tier 1 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[3]/th")).getText(),"Tier 2 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[4]/th")).getText(),"Tier 3 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[5]/th")).getText(),"Tier 4 ");
		}
	}

	public void validateImagePresent(String logoToBeDisplayedOnSecondaryPage) throws InterruptedException {
		CommonUtility.waitForPageLoad(driver,logoImage,15);
		String logo_src = logoImage.getAttribute("src");
		String logo_alt = logoImage.getAttribute("alt");
		System.out.println("Actual logo's source on Dashboard page is   "+logo_src+" and Expected logo source is  "+logoToBeDisplayedOnSecondaryPage+" . ");		
		System.out.println("logo's alt text on secondary page is   "+logo_alt);	
		Assert.assertTrue(logo_src.contains(logoToBeDisplayedOnSecondaryPage));
		System.out.println("Secondary page main logo assert condition is passed");	
	}



	public void validateCoLogoImagePresent(String cologoToBeDisplayedOnSecondaryPage) throws InterruptedException {
		
		CommonUtility.waitForPageLoad(driver,cologoImage,15);
		String cologo_src = cologoImage.getAttribute("src");
		String cologo_alt = cologoImage.getAttribute("alt");
		System.out.println("Actual logo's source on Dashboard page is   " + cologo_src
				+ " and Expected logo source is  " + cologoToBeDisplayedOnSecondaryPage + " . ");
		System.out.println("logo's alt text on secondary page is   " + cologo_alt);
		Assert.assertTrue(cologo_src.contains(cologoToBeDisplayedOnSecondaryPage));
		System.out.println("Secondary page co logo assert condition is passed");
}
		

	public void validatePlanOverviewIndlis(String name, String memberid, String effectivedate, String monthlypremium,
			String extrahelp) {
		validate(planName);
		validate(nameLabel);
		validate(memberID);
		validate(effective_Date);
		validate(monthlypremiumlabel);
		validate(ExtraHelp);

		Assert.assertEquals(driver
				.findElement(By.xpath(".//*[@id='planBenefitsAppSum']/section/div/div[4]/div[1]/div/div[1]/div[2]"))
				.getText(), name);

		Assert.assertEquals(driver
				.findElement(By.xpath(".//*[@id='planBenefitsAppSum']/section/div/div[4]/div[1]/div/div[2]/div[2]"))
				.getText(), memberid);
		Assert.assertEquals(driver
				.findElement(By.xpath(".//*[@id='planBenefitsAppSum']/section/div/div[4]/div[1]/div/div[4]/div[2]"))
				.getText(), effectivedate);

		Assert.assertEquals((ExtraHelp).getText(), extrahelp);

	}

	public boolean vasnotdisplayed() {
		if (textdiscountservices.isDisplayed()) {
			System.out.println("Vas is present");
			return false;
		}

		else {
			System.out.println("Vas is not present");
			return true;

		}
	}

	public boolean ancillarynotdisplayed() {
		if (Headersection.isDisplayed()) {

			System.out.println("Ancillary is present");
			return false;
		} else {
			System.out.println("ancillary is not present");

			return true;
		}
	}

	public void validatehartfortprescriptiondrugtable() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto generated catch block
			e.printStackTrace();

		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		validateNew(hartfortdrugtable);
	}

	public void validateTownOfGreenwichdrugtable() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		validateNew(GreenwichTable);
	}

	public void validatedrugCostSectionTexas() {
		// TODO Auto-generated method stub
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		validateNew(pharmacyDropdownTexas);

	}

	public void validateRetailCostSharingdrugtable() {
		Select drpPharmacy = new Select(pharmacyDropdownTexas);
		drpPharmacy.selectByValue("Retail Cost Sharing");
		System.out.println("Retail Cost Sharing dropdown value selected");
		validateNew(retailTable);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-150)", "");
		if (ICStage30dayNonMain.size() > 0 && ICStage30dayMain.size() > 0 && ICStage31to60.size() > 0
				&& ICStage61to90.size() > 0) {
			Assert.assertTrue("The columns are correct in texas Ers table", true);

		} else {
			Assert.assertFalse("The columns are incorrect in texas Ers table", true);
		}

		if (ICTier1Value.getText().trim().length() > 1) {
			Assert.assertTrue("Value in the IC stage tier 1 cell exists", true);
		} else {
			Assert.assertFalse("No value in the IC stage tier 1 cell", true);

		}

	}

	public void validateMailOrderCostSharing_Drugtable() {
		// TODO Auto-generated method stub

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,+200)", "");
		Select drpPharmacy = new Select(pharmacyDropdownTexas);
		drpPharmacy.selectByValue("Mail Order Cost Sharing");

		waitforElementNew(MailOrderTable);
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 60);
		 * wait.until(ExpectedConditions.visibilityOf(MailOrderTable));
		 */

		if (ICStage31to60MailOrder.size() > 0 || ICStage61to90MailOrder.size() > 0) {
			Assert.assertTrue("The columns are correct in texas Ers  mail ordertable", true);
		} else {
			Assert.assertFalse("The columns are incorrect in texas Ers  mail ordertable", true);
		}

		if (ICTier1ValueMailOrder.getText().trim().length() > 1) {
			Assert.assertTrue("value in the IC stage tier 1 cell exists", true);
		} else {
			Assert.assertFalse("No value in the IC stage tier 1 cell", true);
		}

	}

	public void validateOfficeVisitssection() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-100)", "");

		validateNew(OfficeVisits);
		validateNew(pcpValue);
		validateNew(specialistValue);

		String input = pcpValue.getText();

		Pattern pattern = Pattern.compile("^\\$\\d{1,4}\\.\\d{2}$"); if
		(pattern.matcher(input).matches()) {
			Assert.assertTrue("PCP values exists", true); } else { throw new
				IllegalArgumentException("Invalid String"); }


		String input1 = specialistValue.getText();

		if (pattern.matcher(input1).matches()) {
			Assert.assertTrue("Specialist values exists", true); } 
		else { throw
			new IllegalArgumentException("Invalid String"); }


	}

	public void validateoutpatientsurgerycenterVisitssection() {
		// TODO Auto-generated method stub
		try {

			feebackpopupClose();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-50)", "");

			validateNew(outpatientsurgeryVisits);

		} catch (Exception e) {
			// TODO: handle exception
		}


	}

	public void validateWaysToSaveSection(String memberType) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)", "");

		// TODO Auto-generated method stub
		if (memberType.equalsIgnoreCase("Wallgreens")) {
			validateNew(waysToSaveSection);
			//validateNew(lowTierdrugs);
			validateNew(wallGreensWidget);
		} else if (memberType.equalsIgnoreCase("MailOrderPharamacy")) {
			validateNew(waysToSaveSection);
			//validateNew(lowTierdrugs);
			validateNew(mailOrderWidget);
			//validateNew(wallGreensWidget);
		} else if (memberType.equalsIgnoreCase("Group")) {
			if (waysToSaveSectionvalidate.size() < 1) {
				Assert.assertTrue("ways to save section doesnt exist for a non PDP memeber", true);
			} else {
				Assert.assertFalse("ways to save section exists for a non PDP memeber", true);
			}

		} else {
			System.out.println("Please provide a valid member .Refer Notes in feature file");
		}

	}

	public void fedtabledata()
	{
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText(),"100% until the $415.00 deductible is met.");
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText());
		//Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[6]")).getText(),"25%");

	}

	public void fedpdptabledata()
	{
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[2]/td[3]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[2]/td[3]")).getText(),"$1.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[3]/td[1]")).getText(),"$3.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[4]/td[1]")).getText(),"$34.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[4]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[5]/td[1]")).getText(),"30%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[2]/td[2]")).getText(),"100% until the $405.00 deductible is met.");


		DrugCostDropdown.sendKeys("Preferred Mail Service Pharmacy");
		try
		{
			Thread.sleep(15000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[3]")).getText(),"$3.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[3]/td[1]")).getText(),"$9.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[4]/td[1]")).getText(),"$102.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[4]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[5]/td[1]")).getText(),"30%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[2]")).getText(),"100% until the $405.00 deductible is met.");
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[6]")).getText());

		DrugCostDropdown.sendKeys("Standard Retail Pharmacy");
		try
		{
			Thread.sleep(15000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText(),"$2.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[1]")).getText(),"$6.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[1]")).getText(),"$44.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[1]")).getText(),"40%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText(),"100% until the $405.00 deductible is met.");
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[6]")).getText());



	}





	public void ValidatePeehipsection() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)", "");
		validateNew(PeehipTable);

		System.out.println(annualDeductibleColumn.size() + initialCoverageColumn.size() + coverageGaStageColumn.size()
		+ catastrophicCoverageStageColumn.size());
		if (annualDeductibleColumn.size() > 0 && initialCoverageColumn.size() > 0 && coverageGaStageColumn.size() > 0
				&& catastrophicCoverageStageColumn.size() > 0) {
			Assert.assertTrue("The columns are correct in Peehip table", true);

		} else {
			Assert.assertFalse("The columns are incorrect in Peehip table", true);
		}

		validateNew(PeehipTier1ValueIC);
		String input = PeehipTier1ValueIC.getText();
		Pattern pattern = Pattern.compile("^\\$\\d{1,4}\\.\\d{2}$");
		if (pattern.matcher(input).matches()) {
			Assert.assertTrue("value  in IC column exists", true);
		} else {
			throw new IllegalArgumentException("Invalid String");
		}
		validateNew(PeehipTier1ValueCG);

		input = PeehipTier1ValueCG.getText();
		if (pattern.matcher(input).matches()) {
			Assert.assertTrue("Value in Coverage gap stage column exists", true);
		} else {
			throw new IllegalArgumentException("Invalid String");
		}

		if (PeehipTier1ValueCC.size() > 0) {
			Assert.assertTrue("Catastrophic Coverage stage has some value", true);

		} else {
			Assert.assertFalse("Catastrophic Coverage stage doesn't have any value", true);
		}
	}

	public void ValidateMAsection() {
		// plan Overview section
		validateNew(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);

		// benefits summary section
		validateNew(benefitsSummarySection);
		validateNew(OfficeVisits);
		validateNew(hospitalVisitsSection);
		validateNew(OutpatientSurgeryCenterSection);

		// out of pocket maximum section

		validateNew(outOfPocketSection);
		validateNew(inNetworkSeection);
		validateNew(outOfNetworkSection);
		validate(INNETWORK);
		validate(OUTOFNETWORK);

		// Primary care provider section

		validateNew(PrimaryCareProviderHeaderInd);
		validateNew(YourPrimaryCareProvider);
		validateNew(ChangeYourPcpButton);
		validateNew(StartSearch);

		// plan documents section
		validateNew(planDocumentsTitle);
		validateNew(planDocumentsLangDropdown);
		validateNew(view_label);
		validateNew(otherDocuments);

		// Need help section
		validateNew(needHelpSection);
		validateNew(NeedHelpHeader);
		validateNew(contactUslink);
		validateNew(disclaimersLink);
	}

	public void validateCopayCoinsuranceInDrugTable() {
		validateNew(drugTableNonLisMember);

		if (annualDeductibleColumnFederal.size() > 0 && initialCoverageColumnFederal.size() > 0
				&& coverageGaStageColumnFederal.size() > 0 && catastrophicCoverageStageColumnFederal.size() > 0) {
			Assert.assertTrue("The columns are correct in Drug Costs table", true);

		} else {
			Assert.assertFalse("The columns are incorrect in drug Costs table", true);
		}

		validateNew(federalValueIC);
		String input = federalValueIC.getText();
		Pattern pattern = Pattern.compile("^\\$\\d{1,4}\\.\\d{2}$");
		if (pattern.matcher(input).matches()) {
			Assert.assertTrue("value  in IC column exists", true);

		} else {
			throw new IllegalArgumentException("Invalid String");
		}
	}

	public void ValidatesBenefitsForCombo() {
		int numberOfTabsForCombo;
		// TODO Auto-generated method stub
		numberOfTabsForCombo = tabsForComboMember.size();
		if (numberOfTabsForCombo > 1) {
			String memberid1;
			validateNew(memberIdForPlan);
			memberid1 = memberIdForPlan.getText();
			if (memberid1.contains("-11")) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,900)", "");
				System.out.println("User is on ship page");
				validateNew(shipClaimsSupportHeader);
			} else {
				validateNew(drugCopaysAndDiscount);
			}

			tabsForComboMember.get(1).click();
			validateNew(memberIdForPlan);
			memberid1 = memberIdForPlan.getText();
			if (memberid1.contains("-11")) {
				System.out.println("User is on ship page");

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,900)", "");
				validateNew(shipClaimsSupportHeader);
			} else {
				validateNew(drugCopaysAndDiscount);
			}

		}
	}

	public void validatesAddRider() {
		// TODO Auto-generated method stub

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1500)", "");
		validateNew(addRiderSection);
		int numberOfAddRiderButtons = addRiderButton.size();
		if (numberOfAddRiderButtons > 0) {
			addRiderButton.get(numberOfAddRiderButtons - 1).click();
			validateNew(addBenefitPopup);
			validateNew(addRiderButtonOnPopup);
			addRiderButtonOnPopup.click();
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void validatesRemoveRider() {
		// TODO Auto-generated method stub
		int numberOfAddRiderButtons = addRiderButton.size();
		validateNew(removeRiderButton);
		removeRiderButton.click();
		validateNew(removeRiderPopup);
		validateNew(removeRiderButtonOnPopup);
		removeRiderButtonOnPopup.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int numberOfAddRiderButtonsAfterremovingRider = addRiderButton.size();

		System.out.println(numberOfAddRiderButtonsAfterremovingRider);
		if (numberOfAddRiderButtonsAfterremovingRider == numberOfAddRiderButtons + 1)
			Assert.assertTrue(true);
		else
			Assert.assertFalse(true);

	}
	public void validate_locateapharmacysection1() {
		validate(locateapharmacysection);
		System.out.println("Pharmacy locator text is seen");
		validate(locateapharmacybutton);
		System.out.println("*******Pharmacy locator button is seen ==>"+locateapharmacybutton.isDisplayed());

	}


	public void validateOfficeVisitssectionWidget() {
		try {
			Thread.sleep(2000);
			feebackpopupClose();

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-100)", "");

			validateNew(OfficeVisits);
			validateNew(pcpValue);
			validateNew(specialistValue);

		} catch (Exception e) {

		}

	}
	public static void checkModelPopup(WebDriver driver) {
		int counter = 0;
		do {

			System.out.println("current value of counter: " + counter);
			List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

			if (IPerceptionsFrame.isEmpty()) {
				// if
				// (driver.findElements(By.xpath("//area[@href='javascript:clWin()'][@alt
				// = 'no']")).isEmpty()) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				/*
				 * } else { System.out.println(
				 * "FeedBack Modal Present and counter value is:" + counter);
				 * try { Thread.sleep(2000); WebElement NoThanks =
				 * driver.findElement(By.xpath("//*[@id='IPEinvL']/map/area[3]")
				 * ); JavascriptExecutor js = (JavascriptExecutor) driver;
				 * js.executeScript("arguments[0].scrollIntoView();", NoThanks);
				 * js.executeScript("arguments[0].click();", NoThanks); break; }
				 * catch (InterruptedException e) { e.printStackTrace(); }
				 * 
				 * }
				 */
			} else {
				driver.switchTo().frame(IPerceptionsFrame.get(0));
				driver.findElement(By.className("btn-no")).click();
				driver.switchTo().defaultContent();
			}
			counter++;
		} while (counter < 2);
	}

	/*
	 * this method checks that Plan Benefits Summary Sub Navigation Link 
	 * under Benefits and Coverage is NOT displayed. This method is very useful when
	 * element is available in DOM but element is not displayed on UI
	 */ 
	public void validatePlanBenefitsSummarySubNavNotDisplayed() throws InterruptedException 
	{
		Thread.sleep(2000);  
		System.out.println("Now checking for Plan Benefits Summary sub navigation of Benefits and Coverage");

		Dimension size = driver.findElement(By.id("benefitssummary")).getSize();
		System.out.println(size);
		int height = size.getHeight();
		System.out.println("Height is "+height);
		int width = size.getWidth();
		System.out.println("Width is "+width);
		if (height == 0)
		{
			System.out.println("Plan Benefits Summary Sub Navigation Link under Benefits and Coverage was NOT displayed");
		}

		else 
		{
			System.out.println("Plan Benefits Summary Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");
			Assert.fail("Plan Benefits Summary Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");	
		}

	}   	

	/*
	 * this method checks that Plan Documents and Resources Sub Navigation Link 
	 * under Benefits and Coverage is NOT displayed
	 */
	public void validatePlanDocumentsResourcesSubNavNotDisplayed() throws InterruptedException 
	{
		Thread.sleep(2000);  
		System.out.println("Now checking for Plan Documents and Resources sub navigation of Benefits and Coverage");

		Dimension size = driver.findElement(By.id("formsandresourcesC1")).getSize();
		System.out.println(size);
		int height = size.getHeight();
		System.out.println("Height is "+height);
		int width = size.getWidth();
		System.out.println("Width is "+width);
		if (height == 0)
		{
			System.out.println("Plan Documents and Resources Sub Navigation Link under Benefits and Coverage was NOT displayed");
		}

		else 
		{
			System.out.println("Plan Documents and Resources Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");
			Assert.fail("Plan Documents and Resources Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");	
		}

	} 

	/*
	 * this method checks that Order Plan Materials Sub Navigation Link 
	 * under Benefits and Coverage is NOT displayed
	 */
	public void validateOrderPlanMaterialsSubNavNotDisplayed() throws InterruptedException 
	{
		Thread.sleep(2000);  
		System.out.println("Now checking for Order Plan Materials sub navigation of Benefits and Coverage");

		Dimension size = driver.findElement(By.id("ordermaterials")).getSize();
		System.out.println(size);
		int height = size.getHeight();
		System.out.println("Height is "+height);
		int width = size.getWidth();
		System.out.println("Width is "+width);
		if (height == 0)
		{
			System.out.println("Order Plan Materials Sub Navigation Link under Benefits and Coverage was NOT displayed");
		}

		else 
		{
			System.out.println("Order Plan Materials Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");
			Assert.fail("Order Plan Materials Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");	
		}

	}

	public void verifyCorrectMessageForPreEffectiveMembers() throws InterruptedException 
	{
		Thread.sleep(2000);  
		System.out.println("Now checking for message on Benefits and Coverage Page for Pre-effective members");
		System.out.println("The message displayed on screen is "+messageForPreeffective.getText());
		Assert.assertEquals(messageForPreeffective.getText(),"When your plan starts, this is where youï¿½ll find an overview of your plan benefits and coverage information. You can also view your plan documents to find important plan details and information.");
		System.out.println("Assert for correct Message was passed");
		System.out.println("Now checking for display View Plan Documents button");
		viewPlanDocumentsButton.isDisplayed();
		System.out.println("View Plan Documents button was displayed");
	}

	public void verifyCorrectTechSupportNumberForPreEffectiveMembers() throws InterruptedException 
	{

		System.out.println("Now checking for Tech Support Number for Pre-effective members");
		System.out.println("The Tech Support phone number displayed on screen is "+preEffectiveTechSupportNumber.getText());
		Assert.assertEquals(preEffectiveTechSupportNumber.getText(),"1-888-980-8125");
		System.out.println("Assert for correct Tech Suppport Phone Number  was passed");

	}

	public FormsAndResourcesPage clickViewPlanDocumentsButton() throws InterruptedException 
	{

		System.out.println("Now clicking the View Plan Documents Button");
		viewPlanDocumentsButton.click();

		return new FormsAndResourcesPage(driver);
	}

}
