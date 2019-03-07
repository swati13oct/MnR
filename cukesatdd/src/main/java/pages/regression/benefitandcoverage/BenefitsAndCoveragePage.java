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
import cucumber.api.DataTable;

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

	//@FindBy(xpath =".//*[@id='mapdPageLis'] or contains(text0,'Covered Generic Drugs')")
	@FindBy(xpath = ".//*[@id='mapdPageLis']/div[1]/div/div/table/tbody/tr[2]/th")
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

	@FindBy(xpath = "//span[contains(text(),'HEARING')]")
	private WebElement Hearingsection;

	@FindBy(xpath = ".//*[@class='bold margin-small atdd-bnc-hearingtxt-subtitle']//following-sibling::p")
	private WebElement HearingContent;

	@FindBy(xpath= ".//*[@class='margin-small bold atdd-benefitssummary-eyewear']//following-sibling::p")
	private WebElement VisionContent;

	@FindBy(xpath = "//h4[contains(text(),'Exclusive hearing savings')]")
	private WebElement Hearingaid;

	@FindBy(xpath = "//span[contains(text(),'VISION')]")
	private WebElement Visionsection;

	@FindBy(xpath = "//span[contains(text(),'DENTAL')]")
	private WebElement Dentalsection;

	@FindBy(xpath = ".//*[@class='bold margin-small atdd-benefitssummary-routine-dental']//following-sibling::p")
	private WebElement DentalContent;

	@FindBy(xpath = "//h4[contains(text(),'ADDITIONAL BENEFITS')]")
	private WebElement Headersection;

	@FindBy(xpath="//a[@class='btn btn--secondary atdd-bnc-optumRx']")
	private WebElement optumRxBtn;

	@FindBy(className = ".//*[@id='ancillary']/div[2]/div[4]/div/div")
	private WebElement chiropracticsection;

	@FindBy(className = "atdd-bnc-drgcvrgeinfo")
	private WebElement DrugCoveragetext;

	@FindBy(xpath = "//p[@class='atdd-bnc-drugcoverage-title']")
	private WebElement DrugCoveragetext_pdp;

	@FindBy(className = "atdd-bnc-drugcoverage-title")
	private WebElement DrugCoverageHeader;

	@FindBy(xpath = "//h2[@class='atdd-bnc-drgcopaysdiscounts-title']")
	private WebElement lisDrugCopayHeader;

	@FindBy(xpath = "//div[@class='drugCopaysAndDiscounts section'][1]//div[@class='drugCopayHeaderParsys parsys section']//p[@class='atdd-bnc-drgcopaysdiscounts-info']")
	private WebElement lisDrugCopayText;

	@FindBy(xpath = "//div[@class='drugCopaysAndDiscounts section'][1]//div[@class='drugCopayHeaderParsys parsys section']//p[2]")
	private WebElement pdp_lisDrugCopayText;

	@FindBy(xpath = "//p[contains(text(),'Estimate your drug costs and view ways to save.')]")
	private WebElement LookupDrugstext;

	@FindBy(xpath = "//a[contains(text(),'Look up Drugs')]")
	private WebElement LookUpDrugsButton;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-title")
	private WebElement DrugCopayHeader;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-info")
	private WebElement DrugCopayText;

	@FindBy(xpath = "//div[contains(@class, 'ng-hide')]//select[@id='drug-costs']")
	private WebElement DrugCostDropdownHiding;

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

	@FindBy(xpath = "//a[@class='display-block collapse-expand collapsed atdd-bnc-drgpricingtiers']")
	private WebElement LearnMoreDrugPricingTiersLink;

	@FindBy(xpath = "//div[@class='margin-extra-small display-block ng-hide']//a[@class='display-block collapse-expand collapsed atdd-bnc-drgpricingtiers']")
	private WebElement LearnMoreDrugPricingTiersLink_hidden_pdpLis;

	@FindBy(xpath = "//div[@class='margin-extra-small display-block']//a[@class='display-block collapse-expand collapsed atdd-bnc-drgpricingtiers']")
	private WebElement LearnMoreDrugPricingTiersLink_visble_pdpLis;

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

               //tbd @FindBy(xpath = "//h2[contains(text(),'Plan Documents and Resources')]")
               @FindBy(xpath = "//h2[contains(text(),'Plan Materials')]")
	private WebElement documents_label;

	// @FindBy(className = "atdd-benefitsoverview-plantitle")
	@FindBy(xpath = ".//*[@class='h2 margin-none overview-heading atdd-benefitsoverview-plantitle ng-binding']")
	private WebElement planName2;

	// @FindBy(className = "atdd-benefitsoverview-membernamelabel")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-membernamelabel']")
	private WebElement nameLabel1;

	// @FindBy(className = "atdd-benefitsoverview-memberidlabel")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-memberidlabel']")
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

	@FindBy(xpath = "//div[@class='table-body-cell outpatientsurgery-tier1-atdd ng-binding']")
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

	@FindBy(xpath = "//div[@class='col-md-8 margin-small']//div[@class='benefitsSummary parbase']//h3//span")
	private WebElement OutofPocketMaximum;

	@FindBy(xpath = "//span[contains(text(),'Out-of-Pocket Maximum')]")
	private WebElement OutofPocketMaximumText;

	@FindBy(id = "oopInNetowrk")
	private WebElement INNETWORK;

	@FindBy(id = "oopOutNetowrk")
	private WebElement OUTOFNETWORK;

	@FindBy(xpath = "//*[contains(text(),'IN-NETWORK')]")
	private WebElement INNETWORKTEXT;

	@FindBy(xpath = "//*[contains(text(),'OUT-OF-NETWORK')]")
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

	@FindBy(xpath = "(//*[@id='officeVisitTileAtdd']/div//div[1]/span)[1]")
	private WebElement pcpValue;

	@FindBy(xpath = "(//*[@id='officeVisitTileAtdd']/div//div[1]/span)[2]")
	private WebElement specialistValue;

	@FindBy(id = "outPatientTileAtdd")
	private WebElement outpatientsurgeryVisits;

	@FindBy(id = "hospitalVisitTileAtdd")
	private WebElement hospitalVisitsSection;

	@FindBy(id = "outPatientTileAtdd")
	private WebElement OutpatientSurgeryCenterSection;

	@FindBy(xpath = "//div[@class='col-md-8 margin-small']//div[@class='benefitsSummary parbase']")
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

	@FindBy(xpath = ".//*[@class='table-white atdd-bnc-txers-mailordersharing-table']/tbody/tr[3]/td[1]//div[not(contains(@class,'ng-hide'))]")
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

	//@FindBy(id = "waystosave")
	@FindBy(xpath="//div[@id='waystosave']")
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


	@FindBy(xpath = "//span[@class='bold atdd-benefitsoverview-effectivedatelabel']")
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

	//backtotop
	//*[@id="backToTopContainer"]/a/span/p
	@FindBy(xpath = "(//*[@id='backToTopContainer']/a/span/p)[1]")
	private WebElement linkBackToTop;

	@FindBy(xpath = "(//*[@id='backToTopContainer']/a/span/p)[2]")
	private WebElement linkBackToTop_copy;

	//MAPD_UHC jump links

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']//*/li[1]/a[contains(text(),'Medical Copays or Coinsurance')]")
	private WebElement jmpLinkToMedicalCopaysOrCoinsurance;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']//*/li[2]/a[contains(text(),'Out-of-Pocket Maximum')]")
	private WebElement jmpLinkToOutofPocketMaximum;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']//*/li[3]/a[contains(text(),'Primary Care Provider')]")
	private WebElement jmpLinkToPrimaryCareProvider;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']//*/li[5]/a[contains(text(),'Drug Copays & Discounts')]")
	private WebElement jmpLinkToDrugCopaysAndDiscounts;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']//*/li[6]/a[contains(text(),'Drug Coverage')]")
	private WebElement jmpLinkToDrugCoverage;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']//*/li[7]/a[contains(text(),'Plan Documents and Resources')]")
	private WebElement jmpLinkToPlanDocumentsAndResources;

	// MA user
	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]//*/div[6]//*/ul/li[4]/a")
	private WebElement jmpLinkToPlanDocumentsAndResourcesMA;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[2]//*/div[2]//*/div[6]//*/ul/li[1]/a")
	private WebElement jmpLinkToMedicalCopaysOrCoinsuranceMA;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[2]/div/div[2]/div/div[6]//*/ul/li[2]/a")
	private WebElement jmpLinkToOutofPocketMaximumMA;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[2]//*/div[2]//*/div[6]//*/ul/li[3]/a")
	private WebElement jmpLinkToPrimaryCareProviderMA;

	@FindBy(xpath = "//*[@class='jumplinks']//ul/li[4]")
	private WebElement jmpLinkToPlanDocumentsAndResourcesMAGroup;

	@FindBy(xpath = "//*[@class='jumplinks']//ul/li[1]")
	private WebElement jmpLinkToMedicalCopaysOrCoinsuranceMAGroup;

	@FindBy(xpath = "//*[@class='jumplinks']//ul/li[2]")
	private WebElement jmpLinkToOutofPocketMaximumMAGroup;

	@FindBy(xpath = "//*[@class='jumplinks']//ul/li[3]")
	private WebElement jmpLinkToPrimaryCareProviderMAGroup;

	@FindBy(xpath = "(//*[@id='globalContentIdForSkipLink']//*/li[4]/a)[1]")
	private WebElement jmpLinkToOptionalServicesRiders;

	@FindBy(xpath = "(//*[contains(text(),'Out-of-Pocket Maximum')])[2]")
	private WebElement outOfPocketSectionHeader;

	private static String PAGE_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;

	@FindBy(xpath = "//*[@id='drug-benefits']//*/h2")
	private WebElement DrugCopaysAndDiscountsSectionHeader;

	@FindBy(xpath = "//*[@id='drugCoverage']//*/span")
	private WebElement DrugCoverageSectionHeader;

	@FindBy(xpath = "//*[@id='plan_benefit_documents']//*/h2")
	private WebElement PlanDocumentsAndResourcesSectionHeader;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']//*[@class='jumplinks']//li")
	private List<WebElement> directorySection;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[2]//*/div[2]/div/div[2]/div/div[1]//*//ul/li")
	private List<WebElement> directorySectionMedSupp;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[2]/div/div[2]/div/div[4]//*/ul/li")
	private List<WebElement> directorySectionPDP;

	@FindBy(xpath = "//*[@id='avail-riders']//*/h2")
	private WebElement OptionalServicesRidersSectionHeader;            

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[2]/div/div[2]//*/div[6]//*/ul/li[5]/a")
	private WebElement jmpLinkToOptionalServicesRidersMA;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[2]//*/div[2]//*/div[1]//*/ul/li[1]/a")
	private WebElement jmpLinkToBenefitSummaryMedSupp;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[2]//*/div[2]//*/div[1]//*/ul/li[2]/a")
	private WebElement jmpLinkToDiscountsAndServicesMedSupp;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[2]//*/div[2]//*/div[1]//*//ul/li[3]/a")
	private WebElement jmpLinkToPlanDocumentsAndResourcesMedSupp;

	@FindBy(xpath = "//*[@id='benefitsSummary']/div[1]//*/section/div[1]/div/h2")
	private WebElement benefitsSummarySectionHeader;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[4]//*//ul/li[1]/a")
	private WebElement jmpLinkToDrugCopaysAndDiscountsPDP;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[2]/div/div[2]/div/div[4]//*/ul/li[2]/a")
	private WebElement jmpLinkToDrugCoveragePDP;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[2]/div/div[2]/div/div[4]//*//ul/li[3]")
	private WebElement jmpLinkToPlanDocumentsAndResourcesPDP;

	@FindBy(xpath = "//*[@class='jumplinks']//li[1]")
	private WebElement jmpLinkToDrugCopaysAndDiscountsPDPUHC;

	@FindBy(xpath = "//*[@class='jumplinks']//li[2]")
	private WebElement jmpLinkToPlanDocumentsAndResourcesPDPUHC;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]//*/div[4]//*/ul/li[4]/a")
	private WebElement jmpLinkToWaysToSaveMoneyPDP;

	@FindBy(xpath = "//*[@id=\"waystosave\"]//*/h2")
	private WebElement waysToSaveMoneySectionHeader;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[2]//*/div[2]//*/div[8]//*/ul/li[4]/a")
	private WebElement jmpLinkToadditionalBenefits;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[2]//div[2]/div/div[8]//ul/li[6]/a")
	private WebElement jmpLinkToPlanDocumentsAndResourcesMAPDGroup;

	@FindBy(xpath = "//*[@id='ancillary']/div/div/div/div/div/div[1]/div/h4")
	private WebElement additionalBenefitsSectionHeader;

	@FindBy(xpath = "//*[@id='primary-care-provider-atdd']")
	private WebElement primaryCareProviderSectionHeaderGroup;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/*//div/div[8]/div/div/div/div/ul/li")
	private List<WebElement> directorySectionMAPDGroup;

	@FindBy(xpath = "//*[@class='jumplinks']//li[1]")
	private WebElement jmpLinkToMedicalCopaysOrCoinsuranceSSUP;

	@FindBy(xpath = "//*[@class='jumplinks']//li[2]")
	private WebElement jmpLinkToOutofPocketMaximumSSUP;

	@FindBy(xpath = "//*[@class='jumplinks']//li[3]")
	private WebElement jmpLinkToPrimaryCareProviderSSUP;

	@FindBy(xpath = "//*[@class='jumplinks']//li[4]")
	private WebElement jmpLinkToPlanDocumentsAndResourcesSSUP;

	@FindBy(xpath = "(//*[@class='PlanPdf section'])[2]//span[@class='document-list-new margin-none']//li[@class=' clearfix']//span[@class='ng-binding ng-scope'][2]")
	private WebElement PDFUpdatedText;

	//note: add to support SSUP
	@FindBy(xpath="//*[@class='subtitle atdd-bnc-exclusivehearing-subtitle']")
	private WebElement ssupExclusiveHearingSavings;

	@FindBy(xpath="//*[@class='subtitle atdd-benefitssummary-vision']")
	private WebElement ssupVision;

	@FindBy(xpath="//*[@class='subtitle atdd-benefitssummary-dental']")
	private WebElement ssupDental;

	public WebElement getLinkBackToTop_copy() {
		return linkBackToTop_copy;
	}

	public WebElement getJmpLinkToDrugCopaysAndDiscountsPDPUHC() {
		return jmpLinkToDrugCopaysAndDiscountsPDPUHC;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesPDPUHC() {
		return jmpLinkToPlanDocumentsAndResourcesPDPUHC;
	}

	public WebElement getJmpLinkToMedicalCopaysOrCoinsuranceSSUP() {
		return jmpLinkToMedicalCopaysOrCoinsuranceSSUP;
	}

	public WebElement getJmpLinkToOutofPocketMaximumSSUP() {
		return jmpLinkToOutofPocketMaximumSSUP;
	}

	public WebElement getJmpLinkToPrimaryCareProviderSSUP() {
		return jmpLinkToPrimaryCareProviderSSUP;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesSSUP() {
		return jmpLinkToPlanDocumentsAndResourcesSSUP;
	}

	public WebElement getPrimaryCareProviderSectionHeaderGroup() {
		return primaryCareProviderSectionHeaderGroup;
	}

	public WebElement getAdditionalBenefitsSectionHeader() {
		return additionalBenefitsSectionHeader;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesMAPDGroup() {
		return jmpLinkToPlanDocumentsAndResourcesMAPDGroup;
	}

	public WebElement getJmpLinkToadditionalBenefits() {
		return jmpLinkToadditionalBenefits;
	}

	public List<WebElement> getDirectorySectionPDP() {
		return directorySection;
	}

	public List<WebElement> getDirectorySectionSSUP() {
		return directorySection;
	}

	public WebElement getWaysToSaveMoneySectionHeader() {
		return waysToSaveMoneySectionHeader;
	}

	public WebElement getJmpLinkToDrugCopaysAndDiscountsPDP() {
		return jmpLinkToDrugCopaysAndDiscountsPDP;
	}

	public WebElement getJmpLinkToDrugCoveragePDP() {
		return jmpLinkToDrugCoveragePDP;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesPDP() {
		return jmpLinkToPlanDocumentsAndResourcesPDP;
	}

	public WebElement getJmpLinkToWaysToSaveMoneyPDP() {
		return jmpLinkToWaysToSaveMoneyPDP;
	}

	public List<WebElement> getDirectorySection(String memberType) {
		// if (memberType.equalsIgnoreCase("Individual"))
		return directorySection;
		// else
		// return directorySectionMAPDGroup;

	}

	public List<WebElement> getDirectorySection(String planType, String memberType) {
		int planId=0;
		/*     Menu                                                     
		 * 1-MAPD
		 * 2-MA
		 * 3-MedSupp
		 * 4-PDP
		 * 5-SSUP
		 *  
		 */

		if(planType.equalsIgnoreCase("MAPD"))
			planId=1;
		if(planType.equalsIgnoreCase("MA"))
			planId=2;
		if(planType.equalsIgnoreCase("MedSupp"))
			planId=3;
		if(planType.equalsIgnoreCase("PDP"))
			planId=4;
		if(planType.equalsIgnoreCase("SSUP"))
			planId=5;


		switch (planId) {

		case 1:

			return getDirectorySection(memberType);

		case 2:
			return getDirectorySectionMA();

		case 3:
			return getDirectorySectionMedSupp();

		case 4:
			return getDirectorySectionPDP();

		case 5:
			return getDirectorySectionSSUP();

		default:
			System.out.println("Plan Not Found");
			break;
		}

		return null;
	}

	public List<WebElement> getDirectorySectionMA() {

		return directorySection;

	}

	public List<WebElement> getDirectorySectionMedSupp() {
		return directorySectionMedSupp;
	}

	public WebElement getTextdiscountservices() {
		return textdiscountservices;
	}

	public WebElement getBenefitsSummarySectionHeader() {
		return benefitsSummarySectionHeader;
	}

	public WebElement getJmpLinkToBenefitSummaryMedSupp() {
		return jmpLinkToBenefitSummaryMedSupp;
	}

	public WebElement getJmpLinkToDiscountsAndServicesMedSupp() {
		return jmpLinkToDiscountsAndServicesMedSupp;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesMedSupp() {
		return jmpLinkToPlanDocumentsAndResourcesMedSupp;
	}

	public WebElement getJmpLinkToMedicalCopaysOrCoinsuranceMA(String memberType) {
		if (memberType.equalsIgnoreCase("Individual"))
			return jmpLinkToMedicalCopaysOrCoinsuranceMA;
		else
			return jmpLinkToMedicalCopaysOrCoinsuranceMAGroup;
	}

	public WebElement getJmpLinkToOutofPocketMaximumMA(String memberType) {
		if (memberType.equalsIgnoreCase("Individual"))
			return jmpLinkToOutofPocketMaximumMA;
		else
			return jmpLinkToOutofPocketMaximumMAGroup;
	}

	public WebElement getJmpLinkToPrimaryCareProviderMA(String memberType) {
		if (memberType.equalsIgnoreCase("Individual"))
			return jmpLinkToPrimaryCareProviderMA;
		else
			return jmpLinkToPrimaryCareProviderMAGroup;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesMA(String memberType) {
		if (memberType.equalsIgnoreCase("Individual"))
			return jmpLinkToPlanDocumentsAndResourcesMA;
		else
			return jmpLinkToPlanDocumentsAndResourcesMAGroup;
	}

	public WebElement getJmpLinkToOptionalServicesRiders(String planType) {
		int planId=0;
		/*     Menu                                                     
		 * 1-MAPD
		 * 2-MA
		 * 3-MedSupp
		 * 4-PDP
		 * 5-SSUP
		 *  
		 */

		if(planType.equalsIgnoreCase("MAPD"))
			planId=1;
		if(planType.equalsIgnoreCase("MA"))
			planId=2;
		/*                          if(planType.equalsIgnoreCase("MedSupp"))
                                             planId=3;
                              if(planType.equalsIgnoreCase("PDP"))
                                             planId=4;
                              if(planType.equalsIgnoreCase("SSUP"))
                                             planId=5;*/



		switch (planId) {

		case 1:
			return jmpLinkToOptionalServicesRiders;

		case 2:
			return jmpLinkToOptionalServicesRidersMA;

		default:
			System.out.println("Plan Not Found");
			break;
		}

		return null;
	}

	public WebElement getJmpLinkToOptionalServicesRiders() {
		return jmpLinkToOptionalServicesRiders;
	}

	public WebElement getOptionalServicesRidersSectionHeader() {
		return OptionalServicesRidersSectionHeader;
	}

	public WebElement getLinkBackToTop() {
		return linkBackToTop;
	}

	public List<WebElement> getDirectorySection() {
		return directorySection;
	}

	public WebElement getDrugCoverageSectionHeader() {
		return DrugCoverageSectionHeader;
	}

	public WebElement getPlanDocumentsAndResourcesSectionHeader() {
		return PlanDocumentsAndResourcesSectionHeader;
	}



	public WebElement getDrugCopaysAndDiscountsSectionHeader() {
		return DrugCopaysAndDiscountsSectionHeader;
	}

	public WebElement getOutOfPocketSectionHeader() {
		return outOfPocketSectionHeader;
	}

	public WebElement getJmpLinkToMedicalCopaysOrCoinsurance() {
		return jmpLinkToMedicalCopaysOrCoinsurance;
	}

	public WebElement getJmpLinkToOutofPocketMaximum() {
		return jmpLinkToOutofPocketMaximum;
	}

	public WebElement getJmpLinkToPrimaryCareProvider() {
		return jmpLinkToPrimaryCareProvider;
	}

	public WebElement getJmpLinkToDrugCopaysAndDiscounts() {
		return jmpLinkToDrugCopaysAndDiscounts;
	}

	public WebElement getJmpLinkToDrugCoverage() {
		return jmpLinkToDrugCoverage;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResources() {
		return jmpLinkToPlanDocumentsAndResources;
	}

	public WebElement getCopayscoinsuranceheader() {
		return Copayscoinsuranceheader;
	}

	public WebElement getPrimaryCareProviderHeaderInd() {
		return PrimaryCareProviderHeaderInd;
	}

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
			validateWithValue("HEARING", Hearingsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
		try {
			validateWithValue("Hearing Content", HearingContent);
			System.out.println(HearingContent.getText());
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the Hearing aid section of Ancillary Benefits
	 */
	public void HearingAid() {
		validateWithValue("Exclusive hearing savings", Hearingaid);
	}

	/**
	 * @toDo : The user validates the Vision section of Ancillary Benefits
	 */

	public void Vision() {
		validateWithValue("VISION header", Visionsection);
		validateWithValue("Vision Content",VisionContent);
	}

	/**
	 * @toDo : The user validates the Dental section of Ancillary Benefits
	 */

	public void Dental() {
		validateWithValue("DENTAL header", Dentalsection);
		validateWithValue("Dental Content",DentalContent);
	}

	/**
	 * @toDo : The user validates the Header section
	 */

	public void Header() {
		validateWithValue("ADDITIONAL BENEFITS", Headersection);
		if(Headersection.isDisplayed()){
			Assert.assertTrue("ADDITIONAL BENEFITS header is displaying", true);
		}
		else{
			Assert.fail("ADDITIONAL BENEFITS header is notdisplaying");
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

	public void validatedrugcoverageheaderandtext_pdplis() {
		validateWithValue("Drug Coverage Header", DrugCoverageHeader);
		validateWithValue("Drug Coverage text",DrugCoveragetext_pdp);
	}

	/**
	 * @toDo : The user validates the DrugCoverage section headers and text for group
	 */
	public void validatedrugcoverageheaderandtextgroup() {

		System.out.println(validate(DrugCoverageHeader));

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
		validateWithValue("PHARMACY LOCATOR",locateapharmacysection);
		validateWithValue("LOCATE A PHARMACY button",locateapharmacybutton);

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
		/* tbd
                              if (Learnmoretierslink.isDisplayed()) {
                                             Assert.fail("The element" + Learnmoretierslink.getText() + "should not display");
                                             System.out.println("The element " + Learnmoretierslink.getText() + "should not display");
                              } else {
                                             Assert.assertTrue(true);
                              } 
		 */
		try {
			if (LearnMoreDrugPricingTiersLink.isDisplayed()) {
				Assert.fail("The element" + LearnMoreDrugPricingTiersLink.getText() + "should not display");
				System.out.println("The element " + LearnMoreDrugPricingTiersLink.getText() + "should not display");
			} else {
				Assert.assertTrue(true);
			}
		} catch (NoSuchElementException e) {
			System.out.println("The element Learn More Durg Pricing Tiers Link is not displayed. "+e);
			Assert.assertTrue(true);
		}
	}

	public void validate_tierlinknotdisplay_pdpLis() {
		//note: for pdp lis user, this element will display in dom but it will not be visible on page (i.e. hidden)
		try {
			if (LearnMoreDrugPricingTiersLink_hidden_pdpLis.isDisplayed()) {
				Assert.assertTrue("The element 'Learn more about drug tiers' should not be visible on page", true);
			} 
		} catch (NoSuchElementException e) {
			if (LearnMoreDrugPricingTiersLink_visble_pdpLis.isDisplayed()) {
				Assert.assertTrue("The element 'Learn more about drug tiers' should have been hidden on page", false);
			} else {
				// neither of the elements are located so assume the element doesn't exist
				Assert.assertTrue("The element 'Learn more about drug tiers' should not be visible/hidden on page", true);
			}

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
		/* tbd
                              if (DrugCostDropdown.isDisplayed()) {
                                             Assert.fail("The element" + DrugCostDropdown.getText() + "should not display");
                                             System.out.println("The element " + DrugCostDropdown.getText() + "should not display");
                              } else {
                                             Assert.assertTrue(true);
                              }
		 */
		try {
			if (DrugCostDropdownHiding.isDisplayed()) {
				Assert.fail("The element" + DrugCostDropdownHiding.getText() + "should not display");
				System.out.println("The element " + DrugCostDropdownHiding.getText() + "should not display");
			} else {
				Assert.assertTrue(true);
			}
		} catch (NoSuchElementException e) {
			System.out.println("The element Drug Cost Dropdown is not displayed " + e);
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

		validateWithValue("LEARN MORE ABOUT DRUG PAYMENT STAGES link",Learnmorestagelink);
		Learnmorestagelink.click();
		try {
			Thread.sleep(2000);
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
			Assert.assertTrue("LEARN MORE ABOUT DRUG TIERS link has been collapsed successfully", true);          
		}
		else{
			System.err.println("LEARN MORE ABOUT DRUG TIERS link has not been collapsed successfully");
			Assert.fail("LEARN MORE ABOUT DRUG TIERS link has not been collapsed");
		}

	}

	/**
	 * @throws InterruptedException 
	 * @toDo : Validates that the learnmore stage link
	 */

	public void clickOnLearnmoreaboutlinkstage() throws InterruptedException {
		// TODO Auto-generated method stub
		validateWithValue(" LEARN MORE ABOUT DRUG PAYMENT STAGES ", Learnmorestagelink);
		//tbd Learnmorestagelink.click();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Learnmorestagelink);
		js.executeScript("arguments[0].click();", Learnmorestagelink); 
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
		validateWithValue("Header-Drug Copays & Discounts", lisDrugCopayHeader);
		//tbd validateWithValue("Text-Drug Copays & Discounts", lisDrugCopayText);

		boolean checkText=true;
		try {
			lisDrugCopayText.isDisplayed();
			System.out.println("located the lisDrugCopayText element via the xpath for non-PDP user");
		} catch (Exception e) {
			checkText=false;
			System.out.println("Unable to locate the lisDrugCopayText element via the xpath for non-PDP user");
		}
		if (!checkText) {
			try {
				pdp_lisDrugCopayText.isDisplayed();
				checkText=true;
				System.out.println("located the lisDrugCopayText element via the xpath for PDP user");
			} catch (Exception e2) {
				System.out.println("Unable to locate the lisDrugCopayText element via the xpath for PDP user either");
			} 
		}
		Assert.assertTrue("Element lisDrugCopayText expected but not found!!!!", checkText);

		System.out.println(" ***********Drug Copay & discount  is validated ***********");
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
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_Table, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_Table);

		// TODO Auto-generated method stub
		validate(RetailDrugCost_Table);
		System.out.println("********** Drug cost table is seen ==>"+RetailDrugCost_Table.isDisplayed());
		validate(columncoveragegenericdrugs);
		//Assert.assertEquals(driver
		//                           .findElement(By
		//                                                         .xpath("//*[@id='mapdPageLis']//table[@class='table-white atdd-bnc-drgcsttable']//tbody/tr[2]/th/p"))
		//                           .getText(), "Covered Generic Drugs");

		//note: Dec2018 - updated xpath and the way to get the text
		String targetXpath=".//*[@id='mapdPageLis']/div[1]/div/div/table/tbody/tr[2]/th/p";
		WebElement targetElement=driver.findElement(By.xpath(targetXpath));
		Assert.assertEquals(targetElement.getAttribute("innerHTML"), "Covered Generic Drugs");
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
				Assert.assertTrue("Element " +value+ " not found!!!!", true);
				return true;
			} else {
				System.out.println("Element " +value+ " not found/not visible");
				Assert.fail("Element " +value+ " not found/not visible");
			}
		} catch (Exception e) {
			System.err.println("Exception: Element " +value+ "  not found/not visible");
			Assert.fail("Element " +value+ " not found/not visible");
		}
		return false;

	}

	public boolean validateNotDisplay(String value, WebElement element) {
		//note: validate element doesn't exist/display on the page
		try {
			if (element.isDisplayed()) {
				System.out.println("Element " +value+ " found");
				Assert.assertTrue("Element " +value+ " not found", false);
			} else {
				System.out.println("Element " +value+ " not found/not visible");
				Assert.assertTrue("Element " +value+ " found/visible", true);
			}
		} catch (Exception e) {
			System.err.println("Exception: Element " +value+ "  not found/not visible");
			Assert.assertTrue("Element " +value+ " found/not visible", true);
		}
		return false;

	}

	/**
	 * @toDo Validate Plan overview for PDP Individual Members
	 */
	public void validatePlanOverviewSectionForMembers() {
		validateWithValue("Paln name", planName2);
		validateWithValue("Member Name: label", nameLabel1);
		validateWithValue("Member ID: label", memberID1);
		validateWithValue("Effective Date: label",effective_Date1);
	}

	/**
	 * @toDo: Validate Drug Look Up Link
	 */
	public void validate_druglookuplink() {
		validateWithValue("DRUG LOOKUP header",DrugLookUpLink);
		validateWithValue("Look Up Drugs Button", LookUpDrugsButton);
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
		//note: for PDP user, there will be NO Benefits Summary Header section
		if (planType.equalsIgnoreCase("PDP")) {
			System.out.println("User has planType=PDP, validate should not have Benefits Summary section at all");
			validateNotDisplay("Benefits Summary Header", BenefitsSummaryHeader);
			validateNotDisplay("Copays coinsurance header",Copayscoinsuranceheader);
		} else {
			validateWithValue("Benefits Summary Header", BenefitsSummaryHeader);

			validateWithValue("Copays coinsurance header",Copayscoinsuranceheader);
			validateWithValue("Hospital Visits",HospitalVisits);
			validateWithValue("Office Visits",OfficeVisits);
			validateWithValue("Outpatient Surgery Center",OutpatientSurgeryCenter);

			validateWithValue("Outpatient Surgery Center Value",OutpatientSurgeryCenterValue);
			validateWithValue("Offic Visits Value",OfficVisitsValue);

			Assert.assertEquals(OfficeVisits.getText(), "OFFICE VISITS ");
			if(planType.contains("Medica") || planType.contains("PCP"))
			{
				System.out.println(OutpatientSurgeryCenter.getText());
				Assert.assertEquals(OutpatientSurgeryCenter.getText(), "OUTPATIENT SURGERY CENTER VISITS ");
			}
			else
			{
                           System.out.println(OutpatientSurgeryCenter.getText());
                           Assert.assertTrue("Text for Outpatinet Surgery Center is not as expected.", OutpatientSurgeryCenter.getText().contains("OUTPATIENT SURGERY CENTER VISITS"));
                           //Assert.assertEquals(OutpatientSurgeryCenter.getText(), "OUTPATIENT SURGERY CENTER VISITS ");
			}
			System.out.println(HospitalVisits.getText());
			Assert.assertEquals(HospitalVisits.getText(), "HOSPITAL VISITS ");
			if(planType.contains("Medica"))
			{
				System.out.println(OutpatientSurgeryCenter2.getText());
				if (StringUtils.isEmpty(OutpatientSurgeryCenter2.getText())) {

					Assert.fail();
				}              
			}
			else if (StringUtils.isEmpty(OutpatientSurgeryCenterValue.getText())) {

				Assert.fail("Outpatient Surgery Center Value is not displaying");
			}

			if (StringUtils.isEmpty(OfficVisitsValue.getText())) {

				Assert.fail();
			}

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
			Thread.sleep(7000);
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
		/*validateWithValue("In-Network section",INNETWORK);
                              validateWithValue("Out-Network section",OUTOFNETWORK);*/
		//INNETWORK and OUTOFNETWORK has been changed in one section


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
			List<WebElement> pdfs = driver.findElements(By.xpath(".//div[@class='PlanPdf section']//div[contains(@ng-show, 'planProfileInfo.employerGroupIndicator')]//li[not(contains(@class,'ng-hide'))]//a"));

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
						if((pdf1[0]).contains(a[i])){
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
		else if(langdropdwn.getFirstSelectedOption().getText().contains("ESPAÃ‘OL"))
		{

			List<WebElement> pdfs = driver.findElements(By.xpath(".//div[@class='PlanPdf section']//div[contains(@ng-show, 'planProfileInfo.employerGroupIndicator')]//li[not(contains(@class,'ng-hide'))]//a"));

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
		else if(langdropdwn.getFirstSelectedOption().getText().contains("ä¸¬æ–‡"))
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
		String cellText="no more than 37% for generic drugs or 25% for brand name drugs";
		//tbd  Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(text(),'"+cellText+"')])[1]")).getText(),cellText);
		//tbd validateWithValue(cellText,driver.findElement(By.xpath("(//div[contains(text(),'"+cellText+"')])[1]")));
		System.out.println("TEST-"+driver.findElement(By.xpath("//table//tr[2]/td[4]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//table//tr[2]/td[4]")).getText(),cellText);
		validateWithValue(cellText,driver.findElement(By.xpath("//table//tr[2]/td[4]")));


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
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText(),"$7.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[4]")).getText(),"$7.00");
			// Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[5]")).getText(),"Greater of $3.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]//td[1]")).getText(),"$15.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]//td[2]")).getText(),"$15.00");
			// Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]//td[3]")).getText(),"Greater of $8.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]//td[1]")).getText(),"$15.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]//td[2]")).getText(),"$15.00");
			// Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]//td[3]")).getText(),"Greater of $8.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]//td[1]")).getText(),"$100.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]//td[2]")).getText(),"$100.00");
			// Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]//td[3]")).getText(),"Greater of $8.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText(),"No Deductible");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//td[7]")).getText(),"$3.40 copay for all generic drugs and $8.50 copay for brand name drugs.");


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
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[5]/td[1]")).getText(),"25% coinsurance with a $100.00 maximum");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[5]/td[2]")).getText(),"25% coinsurance with a $100.00 maximum");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[5]/td[3]")).getText(),"25% coinsurance with a $100.00 maximum");
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
		validateWithValue("Paln name", planName2);
		validateWithValue("Member Name: label", nameLabel1);
		validateWithValue("Member ID: label", memberID1);
		validateWithValue("Effective Date: label",effective_Date1);
		validateWithValue("monthly Premium",monthlypremiumlabel);
		validateWithValue("Extra Help", ExtraHelp);

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

	//note: Dec2018 - modified to handle NoSuchElement Exception
	public boolean ancillarynotdisplayed() {
		try {
			if (Headersection.isDisplayed()) {

				System.out.println("Ancillary is present");
				return false;
			} else {
				System.out.println("ancillary is not present");

				return true;
			}
		} catch (NoSuchElementException e) {
			System.out.println("ancillary is not present");
			return true;
		}
	}

	public boolean optumRxLinkdisplayed() {
		if (optumRxBtn.isDisplayed()) {
			System.out.println("Optum Rx button is present");
			return true;
		} else {
			System.out.println("Optum Rx button is not present");
			return false;
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
		//note Dec2018 - wait for element to load before validation
		CommonUtility.waitForPageLoad(driver, pharmacyDropdownTexas, 5);
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
		//note: Dec2018 - wait for element to load before validation
		CommonUtility.waitForPageLoad(driver, OfficeVisits, 5);

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
		} else if (memberType.equalsIgnoreCase("Group") || memberType.equalsIgnoreCase("withoutWaysToSave_BnC")) {
			//note: by default there will be one id=waystosave element on the page regardless memberType, so check to see it's less than 2 instead of 1
			if (waysToSaveSectionvalidate.size() < 2) {
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
		/* tbd 
                             System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText());
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText(),"25%");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[1]")).getText(),"25%");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[1]")).getText(),"25%");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[1]")).getText(),"25%");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
                              System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText());
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText(),"100% until the $415.00 deductible is met.");
                              System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText());
                              //Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[6]")).getText(),"25%");
		 */
		//System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText(),"$4.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[1]")).getText(),"$10.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[2]")).getText(),"$47.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[3]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[1]")).getText(),"$95.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[1]")).getText(),"29%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[1]")).getText(),"100% until the $215.00 deductible is met.*");
		//System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText());
		//Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[6]")).getText(),"25%");

	}

	public void fedpdptabledata()
	{
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[2]/td[3]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[2]/td[3]")).getText(),"$0.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[3]/td[1]")).getText(),"$5.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[4]/td[2]")).getText(),"$30.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[4]/td[3]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[5]/td[1]")).getText(),"32%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[4]/td[1]")).getText(),"100% until the $415.00 deductible is met.*");


		DrugCostDropdown.sendKeys("Preferred Mail Service Pharmacy");
		try
		{
			Thread.sleep(15000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		/*
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
		 */
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[3]")).getText(),"$0.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[3]/td[1]")).getText(),"$15.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[4]/td[2]")).getText(),"$90.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[4]/td[3]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[5]/td[1]")).getText(),"32%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[4]/td[1]")).getText(),"100% until the $415.00 deductible is met.*");
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

		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText(),"$15.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[1]")).getText(),"$20.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[2]")).getText(),"$45.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[3]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[1]")).getText(),"33%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[1]")).getText(),"100% until the $415.00 deductible is met.*");
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

	//note: Dec2018 - handle SSUP case
	//public void ValidateMAsection() {
	public void ValidateMAsection(String planType) {
		if (planType.equalsIgnoreCase("SSUP")) {
			System.out.println("proceed to locate senior supplement plan tab and click it");
			WebElement ssupTab=driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//li[2]"));
			if (ssupTab.isDisplayed()) {
				ssupTab.click();
				System.out.println("located senior supplement plan tab and clicked it");
			} 
		} 

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
		if (planType.equalsIgnoreCase("SSUP")) {
			System.out.println("For SSUP case");
			validateNew(ssupExclusiveHearingSavings);
			validateNew(ssupVision); 
			validateNew(ssupDental);
		} else {
			System.out.println("For non SSUP case");
			validateNew(PrimaryCareProviderHeaderInd);
			validateNew(YourPrimaryCareProvider);
			validateNew(ChangeYourPcpButton);
			validateNew(StartSearch);
		}

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
		//note: Dec2018 - wait for the element to show up before validation
		CommonUtility.waitForPageLoad(driver, drugTableNonLisMember, 5);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", drugTableNonLisMember);

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


	public void verifyPresenceOfJumpLinksMAPD(String rider, String planType, String memberType) {
		CommonUtility.waitForPageLoad(driver, logoImage, 15);
		Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
				getJmpLinkToMedicalCopaysOrCoinsurance().isDisplayed());
		Assert.assertTrue("jmpLinkToOutofPocketMaximum isn't displayed",
				getJmpLinkToOutofPocketMaximum().isDisplayed());
		Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
				getJmpLinkToPrimaryCareProvider().isDisplayed());
		if (rider.toString().trim().equals("Rider"))
			Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
					getJmpLinkToOptionalServicesRiders(planType).isDisplayed());
		Assert.assertTrue("jmpLinkToDrugCopaysAndDiscounts isn't displayed",
				getJmpLinkToDrugCopaysAndDiscounts().isDisplayed());

		if (memberType.equalsIgnoreCase("Individual")) {
			Assert.assertTrue("jmpLinkToDrugCoverage isn't displayed", getJmpLinkToDrugCoverage().isDisplayed());
			Assert.assertTrue("jmpLinkToPlanDocumentsAndResources isn't displayed",
					getJmpLinkToPlanDocumentsAndResources().isDisplayed());
		} else {
			Assert.assertTrue("jmpLinkToDrugCoverage isn't displayed", getJmpLinkToadditionalBenefits().isDisplayed()); // for
			// group
			// member
			Assert.assertTrue("jmpLinkToDrugCoverage isn't displayed",
					getJmpLinkToPlanDocumentsAndResourcesMAPDGroup().isDisplayed());

		}

		System.out.println("All Jump links are displayed for the MAPD Plan");

	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsMAPD(String rider, String planType, String memberType) {

		clicksOnLinkAndBackToTop(getJmpLinkToMedicalCopaysOrCoinsurance(), getCopayscoinsuranceheader());
		clicksOnLinkAndBackToTop(getJmpLinkToOutofPocketMaximum(), getOutOfPocketSectionHeader());
		if (rider.toString().trim().equals("Rider"))
			clicksOnLinkAndBackToTop(getJmpLinkToOptionalServicesRiders(planType),
					getOptionalServicesRidersSectionHeader());
		clicksOnLinkAndBackToTop(getJmpLinkToDrugCopaysAndDiscounts(), getDrugCopaysAndDiscountsSectionHeader());

		if (memberType.equalsIgnoreCase("Individual")) {
			clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProvider(), getPrimaryCareProviderHeaderInd());
			clicksOnLinkAndBackToTop(getJmpLinkToDrugCoverage(), getDrugCoverageSectionHeader());
			clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResources(),
					getPlanDocumentsAndResourcesSectionHeader());
		} else {
			clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProvider(), getPrimaryCareProviderSectionHeaderGroup());
			clicksOnLinkAndBackToTop(getJmpLinkToadditionalBenefits(), getAdditionalBenefitsSectionHeader()); // for
			// group
			// member
			clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesMAPDGroup(),
					getPlanDocumentsAndResourcesSectionHeader());

		}

		System.out.println("All sections are present for the MAPD Plan");

	}

	// For MA Plan
	public void verifyPresenceOfJumpLinksMA(String rider, String planType, String memberType) {
		CommonUtility.waitForPageLoad(driver, logoImage, 15);
		Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
				getJmpLinkToMedicalCopaysOrCoinsuranceMA(memberType).isDisplayed());
		Assert.assertTrue("jmpLinkToOutofPocketMaximum isn't displayed",
				getJmpLinkToOutofPocketMaximumMA(memberType).isDisplayed());
		Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
				getJmpLinkToPrimaryCareProviderMA(memberType).isDisplayed());
		if (rider.toString().trim().equals("Rider"))
			Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
					getJmpLinkToOptionalServicesRiders(planType).isDisplayed());
		Assert.assertTrue("jmpLinkToDrugCopaysAndDiscounts isn't displayed",
				getJmpLinkToPlanDocumentsAndResourcesMA(memberType).isDisplayed());
		/*
		 * Assert.assertTrue("jmpLinkToDrugCoverage isn't displayed",
		 * getJmpLinkToDrugCoverage().isDisplayed());
		 * Assert.assertTrue("jmpLinkToPlanDocumentsAndResources isn't displayed",
		 * getJmpLinkToPlanDocumentsAndResources().isDisplayed());
		 */
		System.out.println("All Jump links are displayed for the MA Plan");

	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsMA(String rider, String planType, String memberType) {

		clicksOnLinkAndBackToTop(getJmpLinkToMedicalCopaysOrCoinsuranceMA(memberType), getCopayscoinsuranceheader());
		clicksOnLinkAndBackToTop(getJmpLinkToOutofPocketMaximumMA(memberType), getOutOfPocketSectionHeader());

		if (memberType.equalsIgnoreCase("Individual"))
			clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProviderMA(memberType), getPrimaryCareProviderHeaderInd());
		else
			clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProviderMA(memberType),
					getPrimaryCareProviderSectionHeaderGroup());

		if (rider.toString().trim().equals("Rider"))
			clicksOnLinkAndBackToTop(getJmpLinkToOptionalServicesRiders(planType),
					getOptionalServicesRidersSectionHeader());
		/*
		 * clicksOnLinkAndBackToTop(getJmpLinkToDrugCopaysAndDiscounts(),
		 * getDrugCopaysAndDiscountsSectionHeader());
		 * clicksOnLinkAndBackToTop(getJmpLinkToDrugCoverage(),
		 * getDrugCoverageSectionHeader());
		 */
		clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesMA(memberType),
				getPlanDocumentsAndResourcesSectionHeader());
		System.out.println("All sections are present for the MA Plan");

	}

	// MedSupp

	public void verifyPresenceOfJumpLinksMedSupp(String rider, String planType, String memberType) {
		CommonUtility.waitForPageLoad(driver, logoImage, 15);
		Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
				getJmpLinkToBenefitSummaryMedSupp().isDisplayed());
		Assert.assertTrue("jmpLinkToOutofPocketMaximum isn't displayed",
				getJmpLinkToDiscountsAndServicesMedSupp().isDisplayed());
		Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
				getJmpLinkToPlanDocumentsAndResourcesMedSupp().isDisplayed());

		System.out.println("All Jump links are displayed for the MedSupp Plan");

	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsMedSupp(String rider, String planType, String memberType) {

		clicksOnLinkAndBackToTop(getJmpLinkToBenefitSummaryMedSupp(), getBenefitsSummarySectionHeader());
		clicksOnLinkAndBackToTop(getJmpLinkToDiscountsAndServicesMedSupp(), getTextdiscountservices());
		clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesMedSupp(),
				getPlanDocumentsAndResourcesSectionHeader());

		System.out.println("All sections are present for the MedSupp Plan");

	}

	// PDP

	public void verifyPresenceOfJumpLinksPDP(String rider, String planType, String memberType, String Identifier) {
		CommonUtility.waitForPageLoad(driver, logoImage, 15);

		if (Identifier.contains("UHC")) {
			Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
					getJmpLinkToDrugCopaysAndDiscountsPDPUHC().isDisplayed());

			Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
					getJmpLinkToPlanDocumentsAndResourcesPDPUHC().isDisplayed());
		} else {
			Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
					getJmpLinkToDrugCopaysAndDiscountsPDP().isDisplayed());
			Assert.assertTrue("JmpLinkToDrugCoveragePDP isn't displayed", getJmpLinkToDrugCoveragePDP().isDisplayed());
			Assert.assertTrue("JmpLinkToPlanDocumentsAndResourcesPDP isn't displayed",
					getJmpLinkToPlanDocumentsAndResourcesPDP().isDisplayed());
			Assert.assertTrue("JmpLinkToWaysToSaveMoneyPDP isn't displayed",
					getJmpLinkToWaysToSaveMoneyPDP().isDisplayed());
		}
		System.out.println("All Jump links are displayed for the PDP Plan");

	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsPDP(String rider, String planType, String memberType,
			String Identifier) {

		if (Identifier.contains("UHC")) {
			clicksOnLinkAndBackToTop(getJmpLinkToDrugCopaysAndDiscountsPDPUHC(),
					getDrugCopaysAndDiscountsSectionHeader());
			clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesPDPUHC(),
					getPlanDocumentsAndResourcesSectionHeader());
		} else {

			clicksOnLinkAndBackToTop(getJmpLinkToDrugCopaysAndDiscountsPDP(), getDrugCopaysAndDiscountsSectionHeader());
			clicksOnLinkAndBackToTop(getJmpLinkToDrugCoveragePDP(), getDrugCoverageSectionHeader());
			clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesPDP(),
					getPlanDocumentsAndResourcesSectionHeader());
			clicksOnLinkAndBackToTop(getJmpLinkToWaysToSaveMoneyPDP(), getWaysToSaveMoneySectionHeader());
		}
		System.out.println("All sections are present for the PDP Plan");

	}

	// SSUP
	public void verifyPresenceOfJumpLinksSSUP(String rider, String planType, String memberType) {
		CommonUtility.waitForPageLoad(driver, logoImage, 15);
		Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
				getJmpLinkToMedicalCopaysOrCoinsuranceSSUP().isDisplayed());
		Assert.assertTrue("jmpLinkToOutofPocketMaximum isn't displayed",
				getJmpLinkToOutofPocketMaximumSSUP().isDisplayed());
		Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
				getJmpLinkToPrimaryCareProviderSSUP().isDisplayed());
		Assert.assertTrue("jmpLinkToDrugCopaysAndDiscounts isn't displayed",
				getJmpLinkToPlanDocumentsAndResourcesSSUP().isDisplayed());

		System.out.println("All Jump links are displayed for SSUP Plan");

	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsSSUP(String rider, String planType, String memberType) {

		clicksOnLinkAndBackToTop(getJmpLinkToMedicalCopaysOrCoinsuranceSSUP(), getCopayscoinsuranceheader());
		clicksOnLinkAndBackToTop(getJmpLinkToOutofPocketMaximumSSUP(), getOutOfPocketSectionHeader());

		/*
		 * if(memberType.equalsIgnoreCase("Individual"))
		 * clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProviderSSUP(),
		 * getPrimaryCareProviderHeaderInd()); else
		 */
		clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProviderSSUP(), getPrimaryCareProviderSectionHeaderGroup());

		clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesSSUP(),
				getPlanDocumentsAndResourcesSectionHeader());
		System.out.println("All sections are present for SSUP Plan");

	}

	// SSUP ends here


	public void verifyElementPresence(WebElement element) {
		Assert.assertTrue("Section/Link isn't displayed",element.isDisplayed());
		System.out.println(element.getText());     
	}

	public void clicksOnLinkAndBackToTop(WebElement element_1,WebElement element_2 ) {
		element_1.click();

		try {
			Thread.sleep(1000);        //Added sleep to mimic user interaction 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyElementPresence(element_2);
		try {
			getLinkBackToTop_copy().click();
		}catch(Exception ex){
			getLinkBackToTop().click();

		}
		try {
			Thread.sleep(1000);                          //Added sleep to mimic user interaction 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void directoryLinksCount(int linkCount, String rider, String planType, String memberType) {
		int count = 0;
		if (planType.equals("MA") || planType.equals("MAPD")) {
			if (memberType.equalsIgnoreCase("Individual")) {

				count = getDirectorySection(planType, memberType).size() - 1;
				if (rider.toString().trim().equals("Rider"))
					count += 1;

			} else if (memberType.equalsIgnoreCase("Group")) {
				if (planType.equals("MAPD"))
					count = getDirectorySection(planType, memberType).size();
				else
					count = getDirectorySection(planType, memberType).size()-1;
			}
			else
				count = getDirectorySection(planType, memberType).size();
		} else
			count = getDirectorySection(planType, memberType).size();
		System.out.println("The link count is " + count);
		Assert.assertTrue("Irrelevant links are present", count == linkCount);
		System.out.println("No irrelevant links found");

	}



	public boolean ValidatePDFTextSection() {

		try{
			Thread.sleep(5000);
		}catch(Exception e)
		{
			System.out.println(e);
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2900)", "");
		System.out.println("Page scrolled down");
		try{
			Thread.sleep(2000);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		if(PDFUpdatedText.getText().contains("Updated"))
		{                     
			Assert.assertTrue("The UpdatedText is present", true);
			return true;
		} else {
			Assert.assertFalse("The UpdatedText is not present", true);
			return false;
		}

	}

	//Added for March Release 2019 - Medical Deductible Cards

	@FindBy(xpath="//*[@id='plandeductiblecard1']")
	private WebElement MedicalDeductibleCard1;

	@FindBy(xpath="//*[@id='plandeductible1AEMvalue']")
	private WebElement NoDeductible1Text;

	@FindBy(xpath="//*[@id='plandeductible2servicevalue']")
	private WebElement Deductible2Text;

	@FindBy(xpath="//*[@id='plandeductible1servicevalue']")
	private WebElement Deductible1Text;


	@FindBy(xpath="//*[@id='plandeductiblecard2']")
	private WebElement MedicalDeductibleCard2;

	public boolean ValidateBnCNoDeductible() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean Validation_Flag = true;
		if(validate(MedicalDeductibleCard1)){
			if(!NoDeductible1Text.getText().contains("$")){
				System.out.println("No $ Amount is displayed for Member with No Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+NoDeductible1Text.getText());
				Validation_Flag = true;
			}
			else{
				System.out.println("Validation Failed -  $ Amount is displayed for Member with No Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+NoDeductible1Text.getText());
				Validation_Flag = false;

			}
		}
		else{
			System.out.println("Validation Failed - Medical Deductible Card is NOT Displayed for Group MA/MAPD Member");
			Validation_Flag = false;

		}
		return Validation_Flag;
	}

	public boolean ValidateBnCSingleDeductible(String deductibleAmount1) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean Validation_Flag = true;
		if(validate(MedicalDeductibleCard1)){
			if(Deductible1Text.getText().contains(deductibleAmount1)){
				System.out.println("Expected $ Amount "+deductibleAmount1+" is displayed for Member with Single Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+Deductible1Text.getText());
				Validation_Flag = true;
			}
			else{
				System.out.println("Validation Failed -  Expected Deductible Amount is NOT displayed for Member with Single Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+Deductible1Text.getText());
				Validation_Flag = false;

			}
		}
		else{
			System.out.println("Validation Failed - Medical Deductible Card is NOT Displayed for Group MA/MAPD Member");
			Validation_Flag = false;

		}
		return Validation_Flag;
	}

	public boolean ValidateBnC_DualDeductible(String deductibleAmount1, String deductibleAmount2) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean Validation_Flag = true;
		if(validate(MedicalDeductibleCard1) && validate(MedicalDeductibleCard2) ){
			if(Deductible1Text.getText().contains(deductibleAmount1) && Deductible2Text.getText().contains(deductibleAmount2)){
				System.out.println("Expected $ Amount "+deductibleAmount1+" AND "+deductibleAmount2+" is displayed for Member with Dual Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+Deductible1Text.getText());
				System.out.println("Text displayed in Deductible2 Card : "+Deductible2Text.getText());
				Validation_Flag = true;
			}
			else{
				System.out.println("Validation Failed -  Expected Deductible Amount is NOT displayed for Member with Dual Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+Deductible1Text.getText());
				System.out.println("Text displayed in Deductible2 Card : "+Deductible2Text.getText());
				Validation_Flag = false;

			}
		}
		else{
			System.out.println("Validation Failed - Both Medical Deductible Card is NOT Displayed for Group MA/MAPD Member with Dual Deductible");
			Validation_Flag = false;

		}
		return Validation_Flag;
	}


}
