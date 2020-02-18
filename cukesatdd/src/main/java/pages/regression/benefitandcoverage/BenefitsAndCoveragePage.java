/**
 * 
 */
package pages.regression.benefitandcoverage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.member_deprecated.bluelayer.ProfilePreferencesPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.ValueAddedServicepage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import pages.regression.payments.PaymentHistoryPage;
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

	@FindBy(xpath="//*[@id='plandeductiblecard2']")
	private WebElement MedicalDeductibleCard2;

	@FindBy(xpath = "//a[contains(text(),'VIEW PLAN DOCUMENTS')]/ancestor::p/preceding-sibling::p")
	private WebElement messageForPreeffective;

	@FindBy(xpath = "//p[contains(@ng-if, 'preEffective == true') or (contains(@ng-if, 'preEffective != true') and contains(@ng-if, 'businessType ==') )]")
	public WebElement preEffectiveTechSupportNumber;

	@FindBy(xpath = "//p[contains(text(),'1-800-523-5880')]")
	public WebElement preEffectiveClaimsSupportNumber;

	@FindBy(xpath = "//h3[@class='needhelp h4 margin-none atdd-claims-header']")
	public WebElement preEffectiveClaimsSupportHeader;

	@FindBy(id = "IPerceptionsEmbed")
	public WebElement iPerceptionframe;

	@FindBy(id = "closeButton")
	public WebElement iPerceptionclosebtn; 

	@FindBy(xpath = ".//*[@id='pcpCard']/section/button")
	private WebElement Addaprovider;

	@FindBy(xpath = "//*[contains(@id,'planBenefitsApp')]//*[contains(@class,'memberidlabel')]")
	private WebElement memberId;

	@FindBy(xpath = "//*[contains(@id,'planBenefitsApp')]//*[contains(@class,'membernamelabel')]")
	private WebElement memberName;

	@FindBy(xpath = "//*[contains(@id,'planBenefitsApp')]//*[contains(@class,'effectivedatelabel')]")
	private WebElement effectiveDate;

	@FindBy(xpath = ".//*[@id='planBenefitsApp']/section/div/div[1]/div/div/div/div/h1")
	private WebElement planName1;

	//@FindBy(xpath =".//*[@id='mapdPageLis'] or contains(text0,'Covered Generic Drugs')")
	@FindBy(xpath = ".//*[@id='mapdPageLis']/div[1]/div/div/table/tbody/tr[2]/th")
	private WebElement columncoveragegenericdrugs;

	@FindBy(id = "contactUsAtdd")
	private WebElement contactUslink;

	@FindBy(xpath = ".//*[@id='seeMoreWaysAtdd']")
	private WebElement Seemorewaystext;

	@FindBy(xpath = ".//*[contains(@class,'atdd-need-help')]")
	private WebElement NeedHelpHeader;

	@FindBy(id = "needhelpsectioncontactus")
	private WebElement Contactussection;

	// private WebElement Contactussection;

	@FindBy(xpath = ".//*[contains(@class,'atdd-needhelp-disclaimer-text')]")
	private WebElement disclaimersLink;

	@FindBy(xpath = "//a[contains(text(),'MORE INFORMATION')]")
	private WebElement moreinformation;

	@FindBy(id = "collapseDisclaimer")
	private WebElement moreinformationArea;


	@FindBy(xpath = ".//*[contains(@class,'planBenefitDocumentsContainer section')]//*[contains(@class,'planBenefitDocumentsContainer')]")
	private WebElement planBenefitsDocuments;

	@FindBy(id = "lang-select-2")
	private WebElement langdropdown;

	@FindBy(xpath = "//span[contains(text(),'HEARING')]")
	private WebElement Hearingsection;

	@FindBy(xpath = ".//*[@class='bold margin-small atdd-bnc-hearingtxt-subtitle']//following-sibling::p")
	private WebElement HearingContent;

	@FindBy(xpath= ".//*[@class='margin-small bold atdd-benefitssummary-eyewear']//following-sibling::p")
	private WebElement VisionContent;

	@FindBy(xpath = "//*[@id='ancillary']//h4[@class='h4 margin-extra-small atdd-benefitssummary-exclusivehearing']")
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

	@FindBy(xpath = "//p[@class='atdd-bnc-drugcoverage-title' or @class='atdd-bnc-drgcvrgeinfo' ]")
	private WebElement DrugCoveragetext_pdpIndi;

	@FindBy(className = "atdd-bnc-drugcoverage-title")
	private WebElement DrugCoverageHeader;

	@FindBy(xpath = "//h2[@class='atdd-bnc-drgcopaysdiscounts-title']")
	private WebElement lisDrugCopayHeader;

	@FindBy(xpath = "//p[contains(text(),'Your plan premium is calculated based on the plan')]")
	private WebElement lisDrugCopayHeadertext;

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
	private WebElement drugCostDropdownHiding;

	@FindBy(id = "drug-costs")
	private WebElement drugCostDropdown;

	@FindBy(className = "atdd-bnc-drugcostsheading")
	private WebElement DrugCostHeader;

	//@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[2]/div/div")
	@FindBy(xpath =".//*[@id='drug-benefits']//span[text()='DRUG LOOKUP']")
	private WebElement DrugCostheaderandtext;

	@FindBy(xpath ="//p[@class='atdd-bnc-lookupdrugs-info']")
	private WebElement drugLookUPText;

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

	@FindBy(xpath = "//*[contains(@class,'atdd-bnc-drgstgtiers')]")
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

	@FindBy(id = "preferredRetailBenefit")
	private WebElement preferredRetailBenefitTableIndipdp;

	@FindBy(xpath = ".//*[contains(@id,'mapdPageLis')]")
	private WebElement RetailDrugCost_Table;

	@FindBy(id = "mapdPageNonLisForSRetail")
	private WebElement RetailDrugCost_TableNONLIS;

	@FindBy(xpath = ".//*[@id='mapdPageLis']")
	private WebElement RetailDrugCost_Table1; 

	@FindBy(id = "mapdPageNonLisForPMail")
	private WebElement preferedMail_Table1PDP;

	@FindBy(id = "mapdPageNonLisForSRetail")
	private WebElement standardDetail_Table1PDP;


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
	@FindBy(xpath = ".//*[contains(@class,'bold atdd-benefitsoverview-effectivedatelabel')]")
	private WebElement effective_Date;

	@FindBy(xpath = "//*[@class='bold atdd-benefitsoverview-effectivedatelabel']//..//..//div[2]")
	private WebElement effectivedateValueBNC;


	@FindBy(xpath = ".//*[contains(@class, 'atdd-benefitsoverview-groupidlabel')]")
	private WebElement GroupId;

	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-extrahelplevel-ma-label ng-binding']")
	private WebElement ExtraHelp;

	@FindBy(xpath = "//h2[contains(text(),'Benefits Summary')]")
	private WebElement BenefitsSummaryHeader;

	@FindBy(xpath = "//h2[contains(text(),'Benefits Summary')]")
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

	@FindBy(xpath = "//*[@class='outpatientsurgery-atdd ng-binding ng-scope' or @class='table-body-cell outpatientsurgery-tier1-atdd ng-binding']")
	private WebElement OutpatientSurgeryCenterValue;

	@FindBy(xpath = "//*[@id='officeVisitTileAtdd']/div/div/div[1]/span")
	private WebElement OfficVisitsValue;

	@FindBy(xpath = "//span[contains(text(),'YOUR PRIMARY CARE PROVIDER')]")
	private WebElement YourPrimaryCareProvider;

	@FindBy(xpath = "//button[contains(@class,'btn btn--primary changepcp-atdd')]")
	private WebElement ChangeYourPcpButton;

	@FindBy(xpath = "//a[contains(text(),'SEARCH FOR PROVIDERS')]")
	private WebElement StartSearch;

	@FindBy(xpath = "//span[contains(text(),'PROVIDER SEARCH')]")
	private WebElement SearchProvider;

	@FindBy(id = "benefitShipCard")
	private WebElement ParticipatingHospitalStays1;

	@FindBy(id = "individualPcpHeaderText")
	private WebElement PrimaryCareProviderHeaderInd;

	@FindBy(xpath = "//*[contains(@class, 'atdd-bncsummary-primarycareprvdrheader')]")
	private WebElement PrimaryCareProviderHeaderHMO;

	@FindBy(xpath = "//div[@id='groupMapdPpoText' or @id='groupMapdHmoText']")
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

	@FindBy(xpath = "//a[contains(text(),'View all additional benefits')]")
	private WebElement ViewAllAncillaryBnFtLink;

	@FindBy(className = "atdd-exclsvehearing-arrowdwn")
	private WebElement Disclaimertext;

	@FindBy(xpath = "//a[@class='btn btn--secondary margin-small atdd-bnc-ancilry-learnmorbtn']")
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

	@FindBy(xpath = "//h3[contains(text(),'Technical Support')]")
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

	@FindBy(xpath = "//*[@class='table-white atdd-bnc-CTgrouptable']")
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

	@FindBy(xpath = "//*[@id='officeVisitTileAtdd']/div//div[1]/span[1]")
	private WebElement pcpValue;

	@FindBy(xpath = "//*[@id='officeVisitTileAtdd']/div/div/div[2]/span")
	private WebElement specialistValue;

	@FindBy(xpath="//*[@id='plandeductiblecard1']")
	private WebElement MedicalDeductibleCard1;

	@FindBy(xpath="//*[@id='plandeductible1AEMvalue']")
	private WebElement NoDeductible1Text;

	@FindBy(xpath="//*[@id='plandeductible2servicevalue']")
	private WebElement Deductible2Text;

	@FindBy(xpath="//*[@id='plandeductible1servicevalue']")
	private WebElement Deductible1Text;

	@FindBy(id = "outPatientTileAtdd")
	private WebElement outpatientsurgeryVisits;

	@FindBy(id = "hospitalVisitTileAtdd")
	private WebElement hospitalVisitsSection;

	@FindBy(id = "outPatientTileAtdd")
	private WebElement OutpatientSurgeryCenterSection;

	@FindBy(id = "outOfPocketTile")
	private WebElement outOfPocketSection;

	//@FindBy(id = "IN-NETWORK-1")
	@FindBy(xpath = "(//div[@class='outofpocketdme parbase section'])[1]")
	private WebElement inNetworkSection;

	@FindBy(id = "OUT-OF-NETWORK-1")
	private WebElement outOfNetworkSection;

	@FindBy(xpath = "//table[@class='table-white atdd-bnc-txers-mailordersharing-table']")
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

	@FindBy(xpath = "//strong[contains(text(),'Lower-tier Drugs')]")
	private WebElement lowTierdrugsText;

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

	@FindBy(xpath = "//h1[contains(text(),'Plan Documents & Resources')]")
	private WebElement docsAndResourcesHeader;

	@FindBy(xpath = "//h1[contains(text(),'Order Plan Materials')]")
	private WebElement orderMaterialsHeader;

	@FindBy(xpath ="//*[contains(@class,'plan_benefit_documents_forms_amd_resources')]//li[contains(@class,' updateSessionLoopContent else clearfix MAPD_govt_false_71710697_2019')]")
	private List<WebElement> mapdPdfLinks;

	@FindBy(xpath ="//*[contains(@class,'plan_benefit_documents_forms_amd_resources')]//li[contains(@class,'updateLanguagePdfs_Content clearfix PDP_govt_false_49144037_2019 showElement')]")
	private List<WebElement> pdpPdfLinks;

	@FindBy(xpath = ".//*[@id='standard_ads-header']/span/p")
	private WebElement annualDeductibleColumnheader;

	@FindBy(xpath = ".//*[@id='standard_ics-header']/span/p")
	private WebElement initialCoverageColumnheader;

	@FindBy(xpath = ".//*[@id='standard_cgp-header']/span/p")
	private WebElement coverageGaStageColumnheader;

	@FindBy(xpath = ".//*[@id='standard_ccs-header']/span/p")
	private WebElement catastrophicCoverageStageColumnheader;

	@FindBy(id = "submit-order-materials")
	private WebElement submitOrderBtn;

	@FindBy(id = "notShipRadio")
	private WebElement radioBtnsSectionNonShip;

	@FindBy(id = "shipRadio")
	private WebElement radioBtnsSectionShip;

	@FindBy(id = "premiumpayment_3")
	private WebElement paymentsTab;

	@FindBy(xpath= "//h1[contains(text(), 'Premium Payments')]")
	private WebElement paymentsHeader;

	@FindBy(xpath= "//*[contains(@class,'card')]//*[contains(@dtmid,'cta_ordermaterials')]")
	private WebElement planDocsAndResourcesBtn;

	@FindBy(xpath = "//table[@class='table-white atdd-bnc-rx187grptable']/tbody/tr[2]/td[3]/div[1]")
	private WebElement PeehipTier1ValueIC;
	@FindBy(xpath = "//table[@class='table-white atdd-bnc-rx187grptable']/tbody/tr[2]/td[4]/div[1]")
	private WebElement PeehipTier1ValueCG;
	@FindBy(xpath = "//table[@class='table-white atdd-bnc-rx187grptable']/tbody/tr[5]/td[3]")
	private List<WebElement> PeehipTier1ValueCC;

	@FindBy(xpath = "//img[@alt=' walgreenpharmacylogo']")
	private WebElement wallGreensWidget;

	@FindBy(xpath = "//p[contains(text(),'Walgreens Preferred Retail Pharmacy')]")
	private WebElement wallGreensWidgetText;

	@FindBy(xpath = "//img[@alt='mailservicelogo']")
	private WebElement PreferredMailServicePharmacyLogo;

	@FindBy(xpath = "//img[@alt='retailpharmacylogo']")
	private WebElement retailpharmacylogo;


	@FindBy(xpath = "(//p[contains(text(),'Preferred Mail Service Pharmacy')])[3]")
	private WebElement PreferredMailServicePharmacyText;

	@FindBy(xpath = "(//p[contains(text(),' Preferred Retail Pharmacy')])[1]")
	private WebElement PreferredRetailPharmacyText;

	@FindBy(xpath = "//img[@alt='mailservicelogo']/parent::div/following-sibling::div/p")
	private WebElement mailOrderWidget;

	@FindBy(xpath = "//a[contains(text(),'VIEW PLAN DOCUMENTS')]")
	private WebElement viewPlanDocsBtn;

	//@FindBy(id = "waystosave")
	@FindBy(xpath="//div[@id='waystosave']")
	private List<WebElement> waysToSaveSectionvalidate;

	@FindBy(xpath = "//*[contains(@class,'atdd-benefitssummary-plnbnftdcmnt-title')]")
	private WebElement planDocumentsTitle;

	@FindBy(id = "lang-select-2")
	private WebElement planDocumentsLangDropdown;

	@FindBy(xpath = "//*[contains(@class, 'document-list-new margin-none')]//*[contains(text(),'VIEW OTHER DOCUMENTS')]")
	private WebElement viewDocsAndResourcesLink;

	@FindBy(xpath = "//*[contains(@class, 'document-list-new margin-none')]//*[contains(text(),'View other documents')]")
	private WebElement viewDocsAndResourcesLinkShip;

	@FindBy(id = "benefitsSummary")
	private WebElement benefitsSummarySection;

	@FindBy(id = "formsandresourcesC1")
	private WebElement formsAndResourcesTab;

	@FindBy(id = "needhelpsectioncontactus")
	private WebElement needHelpSection;

	@FindBy(xpath= "//*[contains(@class, 'h2 margin-none overview-heading atdd-benefitsoverview-plantitle ng-binding')]")
	private WebElement planName;

	@FindBy(xpath = "//*[contains(@class, 'bold atdd-benefitsoverview-membernamelabel')]")
	private WebElement nameLabel;

	@FindBy(xpath = "//span[@class='bold atdd-benefitsoverview-membernamelabel']//..//..//div[2]")
	private WebElement memberNameValueBNC;

	@FindBy(xpath = "//*[contains(@class, 'bold atdd-benefitsoverview-memberidlabel')]")
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

	@FindBy(xpath = "//*[contains(@class, 'table-white atdd-bnc-standrdretailpharmcytable')]")
	private WebElement drugTableNonLisMember;

	@FindBy(id = "standard_ads-header")
	private List<WebElement> annualDeductibleColumnFederal;

	@FindBy(id = "standard_ics-header")
	private List<WebElement> initialCoverageColumnFederal;

	@FindBy(id = "standard_cgp-header")
	private List<WebElement> coverageGaStageColumnFederal;

	@FindBy(id = "standard_ccs-header")
	private List<WebElement> catastrophicCoverageStageColumnFederal;

	@FindBy(xpath = "//table/tbody/tr[2]/td[2]/div[1]")
	private WebElement federalValueIC;

	@FindBy(xpath = "//div[@class='tabs-desktop']/ul[@class='nav nav-tabs']/li")
	private List<WebElement> tabsForComboMember;

	@FindBy(xpath = "//*[@class='table-body']/div[2]/div[2]")
	private WebElement memberIdForPlan;

	@FindBy(xpath = "//*[@class='claims section']")
	private WebElement shipClaimsSupportHeader;

	@FindBy(className = "drugCopaysAndDiscounts")
	private WebElement drugCopaysAndDiscount;

	@FindBy(xpath = "//*[contains(@class, 'drugCoPaysDiscountsParsys parsys')]")
	private WebElement drugCopaysAndDiscountSection;

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

	@FindBy(xpath = "//*[contains(@id,'ordermaterials')]")
	private WebElement orderMaterialsTab;

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
	@FindBy(xpath="//h4[@class='h4 margin-extra-small atdd-benefitssummary-exclusivehearing']")
	private WebElement ssupExclusiveHearingSavings;

	@FindBy(xpath="//*[@class='subtitle atdd-benefitssummary-vision']")
	private WebElement ssupVision;

	@FindBy(xpath="//*[@class='subtitle atdd-benefitssummary-dental']")
	private WebElement ssupDental;

	@FindBy(xpath="//a[@class='siteLeavingPopup']/parent::p/parent::div")
	private WebElement accessDrugsBenfitsBlock;

	@FindBy(xpath="//a[@class='siteLeavingPopup']/parent::p/parent::div/h3")
	private WebElement accessDrugsBenfitsBlockHeader;

	@FindBy(xpath="//a[@class='siteLeavingPopup']/parent::p/a")
	private WebElement accessDrugsBenfitsBlockExpressScriptsLink;

	@FindBy(css="div.siteleaving-popup-footer>div")
	private WebElement siteLeavingPopUp;

	@FindBy(css="div.siteleaving-popup-footer a#cancelbtn")
	private WebElement siteLeavingPopUpCancelBtn;

	@FindBy(css="div.siteleaving-popup-footer a#proceedbtn")
	private WebElement siteLeavingPopUpProceedBtn;

	@FindBy(xpath= "//*[@id='pcpCard2']/div/a")
	private WebElement providersearchlink;

	@FindBy(xpath= "//p[contains(text(),'Preferred Retail Pharmacy Drug Costs')]")
	private WebElement PreferredRetailPharmacyDrugCostsText;

	@FindBy(xpath= "//p[contains(text(),'Preferred Retail Pharmacy Drug Costs')]//..//p[2]")
	private WebElement PreferredRetailPharmacyDrugCostsTextLine;

	@FindBy(xpath= "//p[contains(text(),'Preferred Retail Pharmacy Drug Costs')]//..//p[2]")
	private WebElement PreferredRetailPharmacyDrugCostsTextLinePDP;

	@FindBy(xpath= "//p[contains(text(),'Preferred Mail Service Pharmacy Drug Costs')]")
	private WebElement PreferredMailServicePharmacyDrugCostsText;

	@FindBy(xpath= "//p[contains(text(),'Preferred Mail Service Pharmacy Drug Costs')]//..//p[2]")
	private WebElement PreferredMailServicePharmacyDrugCostsTextLine;

	@FindBy(xpath= "//p[contains(text(),'Preferred Mail Service Pharmacy Drug Costs')]//..//p[2]")
	private WebElement PreferredMailServicePharmacyDrugCostsTextLinePDP;

	@FindBy(xpath= "//p[contains(text(),'Standard Network Pharmacy Retail Drug Costs')]")
	private WebElement StandardNetworkPharmacyRetailDrugCostsText;

	@FindBy(xpath= "//p[contains(text(),'Standard Network Pharmacy Retail Drug Costs')]//..//p[2]")
	private WebElement StandardNetworkPharmacyRetailDrugCostsTextLine;

	@FindBy(xpath= "//p[contains(text(),'Standard Network Pharmacy Retail Drug Costs')]//..//p[2]")
	private WebElement StandardNetworkPharmacyRetailDrugCostsTextLinePDP;

	@FindBy(xpath= "//p[contains(text(),'Standard Network Pharmacy Retail Drug Costs')]//..//p[2]")
	private WebElement StandardNetworkPharmacyRetailDrugCostsTextLineVellage;

	@FindBy(id= "officeVisitTileAtdd")
	private WebElement officeVisitSection;

	@FindBy(id= "hospitalVisitTileAtdd")
	private WebElement hospitalVisitSection;

	@FindBy(id= "outPatientTileAtdd")
	private WebElement outPatientSection;

	@FindBy(xpath= "(//div[@class='outofpocketdme parbase section'])[2]")
	private WebElement outNetworkSection;

	@FindBy(xpath= "//h2[contains(text(),'Prescription Drug Costs')]")
	private WebElement PrescriptionDrugCostsrkSectionHeaderONRally;

	@FindBy(xpath= "(//a[contains(text(),'View all benefits')])[1]")
	private WebElement ViewAllBenefitsLinkONRally;

	@FindBy(xpath= "(//*[contains(@class,'planBenefitDocumentsContainer')]/div[2]//*[contains(@class,'PlanPdf section')][1]//li[2]/a")
	private WebElement pdfLink1;

	@FindBy(xpath= "(//*[contains(@class,'planBenefitDocumentsContainer')]/div[2]//*[contains(@class,'PlanPdf section')][2]//li[2]/a")
	private WebElement pdfLink2;

	@FindBy(xpath = "//*[@id='49144037']")
	protected WebElement pdpNavTab;

	@FindBy(xpath = "//*[@id='49144037']//*[contains(text(),'Prescription')]")
	protected WebElement pdpNavTabOrderMaterials;

	@FindBy(xpath = "//*[@id='15825500']//*[contains(text(),'Supplement')]")
	protected WebElement medsuppNavTabOrderMaterials;

	@FindBy(xpath = "//*[@id='15825500']")
	protected WebElement medsuppNavTab;

	@FindBy(xpath = "//*[@id='71710697']")
	protected WebElement mapdNavTab;
	
	@FindBy(xpath = "//*[@id='ancillary']//h4[@class='h4 color-blue medium margin-small atdd-benefitssummary-ancillaryHeader']")
	protected WebElement ancillaryBenefitsHeader;
	
	@FindBy(xpath = "//*[@id='ancillary']//p[contains(text(),'Benefits available as part of your group plan.')]")
	protected WebElement ancillaryBenefitsHeaderText;
	

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
		//String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DATA;
		//benefitsCoverage = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		openAndValidate();


	}

	/**
	 * @toDo : To check headers on Benfits and coverage page
	 */
	public void validateFieldsOnBenefitsAndCoveragePage() {

		try {
			validateNew(planName);

			validateNew(memberId);

			validateNew(memberName);

			validateNew(effectiveDate);

		} catch (Exception e) {
			System.out.println("Elements are not found ...");
		}
	}

	/**
	 * @toDo : To check benefits and coverage page has opened
	 */

	public void openAndValidate() {

		checkModelPopup(driver);
		validateFieldsOnBenefitsAndCoveragePage();

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
			validateNew(planBenefitsDocuments);
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
		validateNew(NeedHelpHeader);
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
			Thread.sleep(4000);
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
			System.err.println("More information aria has not been expanded");
			Assert.fail("More information aria has not been expanded");}
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
		return validateWithValue("Header- Plan Material", documents_label);
	}

	public void languagevalidation() {
		if (langdropdown.isDisplayed()) {

			Select dropdown = new Select(langdropdown);
			List<WebElement> webElements = dropdown.getOptions();
			for (WebElement element : webElements) {

				if (element.getText().equals("SPANISH") || element.getText().equals("CHINESE")) {
					Assert.fail("The element" + element.getText() + "should not display");
					System.out.println("The element " + element.getText() + "should not display");
				} else {
					Assert.assertTrue("Spanish and Chinese language are not display in dropdown as expected", true);
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


	public void Select_langdropdown_selection(String language) {
		if (langdropdown.isDisplayed()) {
			Select langdropdwn = new Select(langdropdown);
			int languageindex = Integer.parseInt(language);
			langdropdwn.selectByIndex(languageindex);
			System.out.println("The selected language  is " + langdropdwn.getFirstSelectedOption().getText());
			Assert.assertTrue("The selected language  is "+langdropdwn.getFirstSelectedOption().getText(),true);
		} else
			Assert.fail("Issue in language selection");
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

	public void validate_drugCostDropdown_select() {
		Select drugCostdropdwn = new Select(drugCostDropdown);
		System.out.println(drugCostdropdwn.getFirstSelectedOption().getText());
		if(drugCostdropdwn.getFirstSelectedOption().getText().equalsIgnoreCase("Preferred Retail Pharmacy")){

			Assert.assertTrue("The Prefererd Retail Pharmacy should come by default in dropdown", true);
			System.out.println("The Prefererd Retail Pharmacy should come by default in dropdown");
		}
		else{
			Assert.fail("The Prefererd Retail Pharmacy is not displaying by default in dropdown");
			System.err.println("The Prefererd Retail Pharmacy is not displaying by default in dropdown");

		}
	}


	public void validate_drugCostDropdownzIndividualMAPD_select() {
		scrollToView(drugCostDropdown);
		Select drugCostdropdwn = new Select(drugCostDropdown);
		System.out.println(drugCostdropdwn.getFirstSelectedOption().getText());
		if(drugCostdropdwn.getFirstSelectedOption().getText().equalsIgnoreCase("Standard Retail Pharmacy")){

			Assert.assertTrue("The Prefererd Retail Pharmacy should come by default in dropdown", true);
			System.out.println("The Prefererd Retail Pharmacy should come by default in dropdown");
		}
		else{
			Assert.fail("The Prefererd Retail Pharmacy is not displaying by default in dropdown");
			System.err.println("The Prefererd Retail Pharmacy is not displaying by default in dropdown");

		}
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
			validateNew(chiropracticsection);
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
			validateNew(Exclusivedisclaimer);
			Exclusivedisclaimer.click();
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			validateNew(Disclaimertext);
			System.out.println("Disclaimers' text:" + Disclaimertext.getText());

		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void VIEW_ALL_ANCILLARY_BENEFITS() throws InterruptedException {
	 
		validateNew(ancillaryBenefitsHeader);
		validateNew(ancillaryBenefitsHeaderText);
	
	}

	public void  rally_dashboardValues() throws InterruptedException {
		driver.get("https://member.int.uhc.com/retiree/dashboard");
		Thread.sleep(4000);
		try {
			validateNew(PrescriptionDrugCostsrkSectionHeaderONRally);
			validateNew(ViewAllBenefitsLinkONRally);
			Assert.assertTrue("Prescription DrugCost Section Header and View All Benefits Link are displaying on the Rally page", true);
		} catch (Exception e) {
			Assert.fail("Prescription DrugCost Section Header and View All Benefits Link are not displaying on the Rally page");
		}
	}


	/**
	 * @return 
	 * @toDo : The user validates the Learn more button under Exclusive hearing
	 *       section of Ancillary benefits
	 */

	public void Exclusivelearnmore() {
		
			validateNew(LearnmoreButton);
			LearnmoreButton.click();

			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));*/
			System.out.println(driver.getCurrentUrl());
			if (driver.getCurrentUrl().contains("uhchearing.com")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Not able to navigate to UHC Hearing site");
			}

		
	}

	/*
	 * //LearnmoreButton.click(); WebElement TxtBoxContent =
	 * driver.findElement(By.className(LearnmoreButton));
	 * TxtBoxContent.getText(); LearnmoreButton.click();
	 * System.out.println("Printing "+TxtBoxContent);
	 
	// LearnmoreButton.click();
	
	 * if (LearnmoreButton.isDisplayed()) { Assert.assertTrue(true); } else
	 * Assert.fail("Button not displayed");
	 
	
	 * if
	 * (driver.getCurrentUrl().contains("www.hihealthinnovations.com/medicare"))
	 * { return; } else { Assert.fail("The element " + ProceedButton.getText() +
	 * "is not found"); }
	 
	// LearnmoreButton.click();

	*//**
	 * @toDo : The user validates the Leaving popup in Ancillary section
	 *//*
	public void Leavingpopup() {

		try {
			validate(popup);
		} catch (Exception e) {
			System.out.println("Element is not found ...");
		}
	}

	*//**
	 * @toDo : The user validates the proceed button of the leaving popup in
	 *       Ancillary section
	 *//*

	public boolean Proceedbutton() {
		// LearnmoreButton.click();
	
		LearnmoreButton.click();
		
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("uhchearing.com")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Not able to navigate to UHC Hearing site");
		}

		return true;
	}

	*//**
	 * @toDo : The user validates the cancel button of the leaving popup in
	 *       Ancillary section
	 *//*
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
*/
	/**
	 * @toDo : The user validates the DrugCoverage section headers and text
	 */
	public void validatedrugcoverageheaderandtext() {
		validateWithValue("Drug Coverage Header", DrugCoverageHeader);
		validateWithValue("Drug Coverage text",DrugCoveragetext);
	}

	public void validatedrugcoverageheaderandtext_pdplis() {
		validateWithValue("Drug Coverage Header", DrugCoverageHeader);
		validateWithValue("Drug Coverage text",DrugCoveragetext_pdpIndi);
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
/*		LookUpDrugsButton.click();
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
		}*/

	}

	public void validategrouplookupdrugsbutton() 
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		validateNew(LookUpDrugsButton);
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
		validateWithValue("DRUG LOOKUP",DrugCostheaderandtext);

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

		/*locateapharmacybutton.click();
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
		}*/

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
			e1.printStackTrace();
		}
		try {
			if (drugCostDropdownHiding.isDisplayed()) {
				Assert.fail("The element" + drugCostDropdownHiding.getText() + "should not display");
				System.out.println("The element " + drugCostDropdownHiding.getText() + "should not display");
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
	public void validate_drugCostDropdownoptions()

	{
		validateWithValue("Drug cost drop down ", drugCostDropdown);
		validateWithValue("Drug Cost Header",DrugCostHeader);
        scrollToView(drugCostDropdown);
		Select dropdown = new Select(drugCostDropdown);
		List<WebElement> webElements = dropdown.getOptions();

		for (WebElement element : webElements) {
			System.out.println(">>>>>>>>>>>>>>>Drug Costs dropdown option being validated <<<<<<<<<<<<<<<<<<: "+element.getText());
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
		Assert.assertTrue("Could not find the Learn more about drug link", Learnmorestagelink.getText().contains("LEARN MORE ABOUT DRUG PAYMENT STAGES"));
		//tbd Learnmorestagelink.click();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Learnmorestagelink);
		js.executeScript("arguments[0].click();", Learnmorestagelink); 

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
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
		LearnmorestagelinkForCollapse.click();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
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
		validateWithValue("LIS header", lisDrugCopayHeader);
		validateWithValue("LIS header text", lisDrugCopayHeadertext);
		//tbd validateWithValue("Text-Drug Copays & Discounts", lisDrugCopayText);

		/*
		 * boolean checkText=true; try { lisDrugCopayText.isDisplayed(); System.out.
		 * println("located the lisDrugCopayText element via the xpath for non-PDP user"
		 * ); } catch (Exception e) { checkText=false; System.out.
		 * println("Unable to locate the lisDrugCopayText element via the xpath for non-PDP user"
		 * ); } if (!checkText) { try { pdp_lisDrugCopayText.isDisplayed();
		 * checkText=true; System.out.
		 * println("located the lisDrugCopayText element via the xpath for PDP user"); }
		 * catch (Exception e2) { System.out.
		 * println("Unable to locate the lisDrugCopayText element via the xpath for PDP user either"
		 * ); } }
		 * Assert.assertTrue("Element lisDrugCopayText expected but not found!!!!",
		 * checkText);
		 */

		System.out.println(" ***********LIS header and text is validated***********");
	}

	/**
	 * @toDo : Validates the Drug costs table for a Non Lis member
	 */
	public void validatedrugcopaytable() {
		// Select langdropdwn = new Select(langdropdown);

		validate(drugcopaytable);

	}

	/**
	 * @toDo : validateNews the Drug costs table for a Lis member
	 */

	public void validatedrugcosttable() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_Table, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_Table);
		validateNew(RetailDrugCost_Table);
		System.out.println("********** Drug cost table is seen ==>"+RetailDrugCost_Table.isDisplayed());
		validate(columncoveragegenericdrugs);
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
		validateNew(waysToSave);
		validateNew(TextWaystoSave);

		System.out.println(TextWaystoSave.getText());
		// Assert.assertEquals(, );

	}

	/**
	 * @toDo : Validates the Plan overview section for a Non lis member
	 */
	public void validatePlanOverviewgroup() {

		validateWithValue("Plan name", planName);
		validateWithValue("Name label", nameLabel);
		validateWithValue("Member ID label", memberID);
		validateWithValue("Group id label",GroupId);
		validateWithValue("Effective date label", effective_Date);
		validateWithValue("Extra Help Level ",ExtraHelp);
		//below verifies values of the lavel

		if(!memberNameValueBNC.getText().equalsIgnoreCase("") && !memberIdValueBNC.getText().equalsIgnoreCase("") 
				&& !effectivedateValueBNC.getText().equalsIgnoreCase("")&& !GroupId.getText().equalsIgnoreCase("")){
			Assert.assertTrue("Values of plan overview is displaying", true);
			System.out.println("Values of plan overview is displaying");
		}
		else{  

			Assert.assertFalse("Values of plan overview are not displaying", true);
			System.out.println("Values of plan overview are not displaying");
		}
	}
	/**
	 * @toDo : Validates the Plan overview section for a Non lis member
	 */
	public void validatePlanOverviewNonLISIndi() {

		validateWithValue("Plan name", planName);
		validateWithValue("Name label", nameLabel);
		validateWithValue("Member ID label", memberID);
		validateWithValue("Effective date label", effective_Date);
		validateWithValue("Extra Help Level ",ExtraHelp);
		//below verifies values of the lavel

		if(!memberNameValueBNC.getText().equalsIgnoreCase("") && !memberIdValueBNC.getText().equalsIgnoreCase("") 
				&& !effectivedateValueBNC.getText().equalsIgnoreCase("")){
			Assert.assertTrue("Values of plan overview is displaying", true);
			System.out.println("Values of plan overview is displaying");
		}
		else{  

			Assert.assertFalse("Values of plan overview are not displaying", true);
			System.out.println("Values of plan overview are not displaying");
		}
	}

	public void validatePlanOverviewgroupNONLIS() {
		CommonUtility.waitForPageLoadNew(driver, planName, 30);
		validateWithValue("Plan name", planName);
		validateWithValue("Name label", nameLabel);
		validateWithValue("Member ID label", memberID);
		validateWithValue("Group id label",GroupId);
		validateWithValue("Effective date label", effective_Date);
		//below verifies values of the lavel

		if(!memberNameValueBNC.getText().equalsIgnoreCase("") && !memberIdValueBNC.getText().equalsIgnoreCase("") 
				&& !effectivedateValueBNC.getText().equalsIgnoreCase("")&& !GroupId.getText().equalsIgnoreCase("")){
			Assert.assertTrue("Values of plan overview is displaying", true);
			System.out.println("Values of plan overview is displaying");
		}
		else{  

			Assert.assertFalse("Values of plan overview are not displaying", true);
			System.out.println("Values of plan overview are not displaying");
		}
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
		validateNew(Copayscoinsuranceheader);
		validateNew(HospitalVisits);
		validateNew(OfficeVisits);
		validateNew(OutpatientSurgeryCenter);
		validateNew(OutpatientSurgeryCenterValue);
		validateNew(OfficVisitsValue);

		Assert.assertEquals(OfficeVisits.getText(), "OFFICE VISITS ");
		Assert.assertTrue(OutpatientSurgeryCenter.getText().contains("OUTPATIENT"));
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
		validateWithValue("Plan name", planName2);
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
		validateNew(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);
		// validateNew(Monthly_Premium);
		validateNew(ExtraHelp);

	}

	/**
	 * @toDo : Validates the Plan overview section for a individual members with
	 *       LEP amount
	 */

	public void validatePlanOverviewLEP() throws InterruptedException {
		System.out.println("validate LEP amount ");

		validate(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);
		validateNew(Monthly_Premium);
		validate(ExtraHelp);
		validateNew(LEPAmount);
	

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
			Assert.assertTrue("OUTPATIENT field text was changed or not found" ,OutpatientSurgeryCenter.getText().contains("OUTPATIENT"));
			Assert.assertTrue("Hospital Visits field text was changed or not found" ,HospitalVisits.getText().contains("HOSPITAL CARE"));

			if (StringUtils.isEmpty(OutpatientSurgeryCenterValue.getText())) {
				Assert.fail("Problem>>>>>>>>>>>>>.Outpatient Surgery Center Value is not displaying<<<<<<<<<<<<<<<<<<<<<<<<<<");
			}
			if (StringUtils.isEmpty(OfficVisitsValue.getText())) {
				System.out.println(">>>>>>>>>>Office Visits value is not displaying<<<<<<<<<<<<<<<<<<<<");
				Assert.fail();
			}
		}
	}

	/**
	 * @toDo : Validates the headers section for group members
	 */
	public void validateHeadersGroup() {

		validateWithValue("Header-Benefits Summary", BenefitsSummaryHeader);
		validateWithValue("Header- Medical Copays or Coinsurance", Copayscoinsuranceheader);
		validateWithValue("Header-EMERGENCY CARE", EmergencyHeader);
		validateWithValue("Header-AMBULANCE", BenefitsSummaryHeader);
		validateWithValue("Header-Ambulance Header", AmbulanceHeader);
		validateWithValue("Header-Hospital Visits", HospitalVisits);
		validateWithValue("Header-Office Visits", OfficeVisits);
		validateWithValue("Header-Outpatient Surgery Center", OutpatientSurgeryCenter);
		Assert.assertEquals(OfficeVisits.getText(), "OFFICE VISITS ");
		Assert.assertTrue(OutpatientSurgeryCenter.getText().contains("OUTPATIENT HOSPITAL SERVICES"));
		Assert.assertTrue(HospitalVisits.getText().contains("HOSPITAL"));
		System.out.println(AmbulanceHeader.getText());
		Assert.assertEquals(AmbulanceHeader.getText(), "AMBULANCE");
		System.out.println(EmergencyHeader.getText());
		Assert.assertEquals(EmergencyHeader.getText(), "EMERGENCY CARE");
		if (StringUtils.isEmpty(OutpatientSurgeryCenterValue.getText())) {
			System.out.println(">>>>>>>>>>Outpatient Surgery Center Value is blank<<<<<<<<<<<<<<<<<<<<");
			Assert.fail();
		}
		if (StringUtils.isEmpty(OfficVisitsValue.getText())) {
			System.out.println(">>>>>>>>>>Office Visits value is blank<<<<<<<<<<<<<<<<<<<<");
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
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}

		validateNew(SearchProvider);
		validateWithValue("Provider Search", SearchProvider);
		validateWithValue("SEARCH FOR PROVIDERS",StartSearch);
		StartSearch.click();

		switchToNewTab();
		System.out.println(driver.getCurrentUrl());

		if (driver.getCurrentUrl().contains("werally.in")) {
			Assert.assertTrue(true);
		}
		else if (driver.getCurrentUrl().contains("systest3.myuhc.com"))
		{
			Assert.assertTrue(true);
		}
		else{
			System.out.println("Problem Spotted>>>>>>>>>Unable to navigate to Provider Search Page<<<<<<<<<<<<<<<");
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
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}


	}

	/**
	 * @toDo : Validates the Primary care provider section for group members
	 */

	public void validatePrimaryCareProviderForGroup() {

		validateNew(PrimaryCareProviderHeaderHMO);
		validateNew(PCPtext);
	}

	/**
	 * @toDo : validateNews the Out Of Pocket Maximum section
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
		validateNew(planName1);
	}

	public pages.member_deprecated.bluelayer.ProfilePreferencesPage navigateDirectToProfilePagee() throws InterruptedException {
		System.out.println(driver.getTitle());
		accountToggleDropdown.click();
		validateNew(accountSettingOption);
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
	 * @param benefitsExpectedCount 
	 * @toDo : Validates the headers for ship members
	 */
	public void validateHeadersShip(String benefitsExpectedCount) {

		validateNew(MemberName);
		validateNew(MemberId);
		validateNew(EffectiveDate);
		validateNew(BenefitsSummaryHeadership);
		int i = 0;
		int benefitsCountExpected = Integer.parseInt(benefitsExpectedCount);	
		List<WebElement> tilelist = driver.findElements(By.xpath(".//*[@id='benefitShipCard']"));
		int benefitsActualCount=tilelist.size();
		for(i=0;i<tilelist.size();i++)
		{
			validateNew(tilelist.get(i));
		}
		Assert.assertTrue("PROBLEM -Benfits count doesn't Match."
				+ "Expected='"+benefitsExpectedCount+"' | Actual='"+benefitsActualCount,benefitsCountExpected==benefitsActualCount);

	}



	/**
	 * @toDo : Validates the hand image in discount and services section for
	 *       ship members
	 */
	public void handimage() {

		validateNew(handimage);

	}

	/**
	 * @toDo : Validates the Value added services section for ship members
	 */
	public void vasSection() {

		validateNew(textdiscountservices);

	}

	/**
	 * @toDo : Validates the Learnmore Button for ship members
	 */

	public void learnmorebutton() {

		validateNew(learnmorebutton);

	}

	/**
	 * @toDo : Validates the Value added services page for ship members
	 */
	public ValueAddedServicepage navigateToValueAddService() {
		validateNew(learnmorebutton);
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
		validateNew(learnmorebutton);
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
		validateNew(NeedhelpShip);
		validateNew(TechnicalSupportShip);
		validateNew(GeneralQuestionShip);
		validateNew(ClaimsSupportShip);
	}

	/**
	 * @toDo : Validates the see more ways to contact us section for ship
	 *       members in Need help section
	 */
	public void validateContactUsNeedHelp() {

		validateNew(needHelpSection);
		validateNew(Seemorewaystext);

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
		validateNew(contactUslink);
		/*contactUslink.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Title is " + getTitle());
		driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
*/
		//Assert.assertTrue(getTitle().equalsIgnoreCase("Contact"));

	}

	public void valiadateCatastrophicCoverageValue(String copayType) {
		validateNew(catastrophicCoverageStage);
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
			List<WebElement> pdfs = driver.findElements(By.xpath("//div/span/div/ul/li[@class=' clearfix']/a"));
			System.out.println(">>>>>>>>>>>>.Size of Pdf's<<<<<<<<<<<<<<<< "+pdfs.size());
			for (int i=0;i<pdfs.size();i++)
			{  
				String pdfnames = null;
				pdfnames= (pdfs.get(i).getText());
				System.out.println(">>>>>>>>>>PDF visible<<<<<<<: "+pdfnames);
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
						if((pdf1[0]).toLowerCase().contains((a[i]).toLowerCase())){
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

			List<WebElement> pdfs = driver.findElements(By.xpath("//div/span/div/ul/li[@class=' clearfix']/a"));

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
		else if(langdropdwn.getFirstSelectedOption().getText().contains("ä¸­æ"))
		{
			System.out.println("NO PDFs in chinese yet.if PDFs come then above same code can be used");
			checkflag = true;
		}


		return checkflag;

	}
	
	/*
	 * ** To validate pdfs on Benefit&Coverage Page - whether pdf has content or not
	 */
	public boolean verifyDocContent(String a[]) {

		boolean checkflag = true;
		Select langdropdwn = new Select(langdropdown);
		if(langdropdwn.getFirstSelectedOption().getText().contains("ENGLISH"))	{
			List<WebElement> pdfs = driver.findElements(By.xpath("//div/span/div/ul/li[@class=' clearfix']/a"));
			validateEachPdfContent(pdfs);
		} else if(langdropdwn.getFirstSelectedOption().getText().contains("ESPAÃOL")) {
			List<WebElement> pdfs = driver.findElements(By.xpath("//div/span/div/ul/li[@class=' clearfix']/a"));
			validateEachPdfContent(pdfs);
		} else if(langdropdwn.getFirstSelectedOption().getText().contains("ä¸­æ")) {
			System.out.println("NO PDFs in chinese yet.if PDFs come then above same code can be used");
			checkflag = true;
		}
		return checkflag;

	}
	
	public void validateEachPdfContent(List<WebElement> pdfs) {
		for (WebElement pdf: pdfs) {
			String targetDocName=pdf.getText();
			//note: need to switch tab and then close tab when done with validation
			String winHandleBefore = driver.getWindowHandle();
			ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int beforeClicked_numTabs=beforeClicked_tabs.size();	

			pdf.click();
			
			CommonUtility.checkPageIsReady(driver);
			System.out.println("Clicked the doc link...");

			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();
			Assert.assertTrue("PROBLEM - Did not get expected new tab after clicking '"+targetDocName+"' link", (afterClicked_numTabs-beforeClicked_numTabs)==1);
			driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			CommonUtility.checkPageIsReady(driver);
			sleepBySec(5);
			String actUrl=driver.getCurrentUrl();
			//note: validate page content
			validatePageContent(targetDocName, actUrl);			
			driver.close();
			driver.switchTo().window(winHandleBefore);
		}
	}
	
	public void validatePageContent(String targetDocName, String actUrl) {
		//note: validate page content
		if (actUrl.contains(".pdf")) {
			try {
				URL TestURL = new URL(driver.getCurrentUrl());
				BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
				PDDocument document = PDDocument.load(TestFile);
				String PDFText = new PDFTextStripper().getText(document);
				System.out.println("PDF text : "+PDFText);
				Assert.assertTrue("PROBLEM - '"+targetDocName+"' PDF content is either null or empty", PDFText!=null && !PDFText.equals(""));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				Assert.assertTrue("PROBLEM - unable to validate pdf '"+targetDocName+"' content - MalformedURLException", false);
			} catch (IOException e) {
				Assert.assertTrue("PROBLEM - unable to validate pdf '"+targetDocName+"' content - MalformedURLException", false);
			}
			System.out.println("Verified PDF '"+targetDocName+"' content is not null or empty");
		} else {
			//note: for html or any url that's not pdf related
			Assert.assertTrue("PROBLEM - unable to locate page header text element on the landing page for doc '"+targetDocName+"'", validate(generalPgHeader,0));
			System.out.println("Verified page '"+targetDocName+"' content contains some kind of header element, i.e. page is not empty");
		}							
	}

	
	@FindBy(xpath="//h1")
	protected WebElement generalPgHeader;

	public void validatestaticlinksinpdf(String plantype) {
		validateWithValue("Link-Medication Therapy Management Program", Medicationlinkinpdfsec);
/*
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
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
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
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		}
		else if (plantype.equalsIgnoreCase("PCP"))
		{
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
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
		}*/

	}
	public void validatestaticlinksinpdfpdp(String plantype)
	{
		String targetDocName="Medication Therapy management Program";
		System.out.println("Proceed to validate '"+targetDocName+"' link");
		validateNew(Medicationlinkinpdfsecpdp);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Medicationlinkinpdfsecpdp.click();
		String expectedUrl="/documents/medication-program";
		String actualUrl=driver.getCurrentUrl();
		validatePageContent(targetDocName, actualUrl);
		Assert.assertTrue("PROBLEM - '"+targetDocName+"' destination URL not as expected. Expected to contain '"+expectedUrl+"' | Actual = '"+actualUrl+"'", actualUrl.contains(expectedUrl));
		navigateToBenefitsPg(plantype);		System.out.println("Go back to Benefits page...");
		if(plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("PDP")) {
			driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
		} else if (plantype.equalsIgnoreCase("Medica"))	{
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		} else if (plantype.equalsIgnoreCase("PCP"))	{
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}
		CommonUtility.checkPageIsReady(driver);
		System.out.println("landing URL is ="+driver.getCurrentUrl());

		targetDocName="VIEW OTHER DOCUMENTS AND RESOURCES";
		System.out.println("Proceed to validate '"+targetDocName+"' link");
		validateNew(Viewotherdocsinpdfpdp);
		Viewotherdocsinpdfpdp.click();
		expectedUrl="/member/documents/overview.html";
		actualUrl=driver.getCurrentUrl();
		validatePageContent(targetDocName, actualUrl);
		Assert.assertTrue("PROBLEM - '"+targetDocName+"' destination URL not as expected. Expected to contain '"+expectedUrl+"' | Actual = '"+actualUrl+"'", actualUrl.contains(expectedUrl));
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		navigateToBenefitsPg(plantype);
	}

	public void navigateToBenefitsPg(String plantype) {
		System.out.println("Go back to Benefits page...");
		if(plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("PDP")) {
			driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
		} else if (plantype.equalsIgnoreCase("Medica"))	{
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		} else if (plantype.equalsIgnoreCase("PCP")) {
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}
		CommonUtility.checkPageIsReady(driver);
		System.out.println("landing URL is ="+driver.getCurrentUrl());

	}
	
	public void validatevillagetabletext1()
	{
		String cellText="no more than 37% for generic drugs or 25% for brand name drugs";
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


			validateNew(annualDeductibleColumnheader);
			validateNew(initialCoverageColumnheader);
			validateNew(coverageGaStageColumnheader);
			validateNew(catastrophicCoverageStageColumnheader);
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
		String TableData="Standard Network Pharmacy Retail Drug Costs\n"
		        +"Copay *\n"
				+"footnote\n"
				+"Initial Coverage Stage *\n"
				+"footnote\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"$5.00 copay\n"
				+"$5.00 copay\n"
				+"After your total drug costs reach $4,020, the plan continues to pay its share of the cost of your drugs and you pay your share of the cost.\n"
				+"When your total out-of-pocket costs for Part D prescription drugs reach $6,350, you will pay a $0 copay for your drugs for the rest of the plan year.\n"
				+"Tier 2\n"
				+"$25.00 copay\n"
				+"$25.00 copay\n"
				+"Tier 3\n"
				+"$40.00 copay\n"
				+"$40.00 copay\n"
				+"Tier 4\n"
				+"$40.00 copay\n"
				+"$40.00 copay";

		if(hartfortdrugtable.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>   The Expected table value is    <<<<<<<<<<<<     \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+hartfortdrugtable.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}


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
		String TableData="Standard Network Pharmacy Retail Drug Costs\n"
		        +"Copay *\n"
				+"footnote\n"
				+"Initial Coverage Stage *\n"
				+"footnote\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"$5.00 copay\n"
				+"$5.00 copay\n"
				+"After your total drug costs reach $4,020, the plan continues to pay its share of the cost of your drugs and you pay your share of the cost.\n"
				+"When your total out-of-pocket costs for Part D prescription drugs reach $6,350, you will pay a $0 copay for your drugs for the rest of the plan year.\n"
				+"Tier 2\n"
				+"$5.00 copay\n"
				+"$5.00 copay\n"
				+"Tier 3\n"
				+"$20.00 copay\n"
				+"$20.00 copay\n"
				+"Tier 4\n"
				+"$35.00 copay\n"
				+"$35.00 copay\n"
				+"Tier 5\n"
				+"$35.00 copay\n"
				+"$35.00 copay";

		if(GreenwichTable.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>   The Expected table value is    <<<<<<<<<<<<     \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+GreenwichTable.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}


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
		String TableData= "Annual Prescription Deductible Initial Coverage Stage Coverage Gap Stage Catastrophic Coverage Stage\n"
				+"30-day supply (non-maintenance drugs) 30-day supply (maintenance drugs*) 31- to 60-day supply** 61- to 90-day supply**\n"
				+"Tier 1\n"
				+"You pay 100% of costs until $50 deductible is met*\n"
				+"$10 copay\n"
				+"$10 copay\n"
				+"$20 copay\n"
				+"$30 copay\n"
				+"After your total drug costs reach $4,020, the plan covers all formulary drugs through the coverage gap at the same copays listed under the Initial Coverage Stage\n"
				+"When your out-of-pocket costs reach the $6,350 limit for the plan year, you move to the Catastrophic Coverage Stage.  In this stage, you will continue to pay the same cost share that you paid in the Initial Coverage Stage.\n"
				+"The catastrophic coverage will go toward Part D covered medications.\n"
				+"Tier 2\n"
				+"$35 copay\n"
				+"$45 copay\n"
				+"$70 copay\n"
				+"$105 copay\n"
				+"Tier 3\n"
				+"$60 copay\n"
				+"$75 copay\n"
				+"$120 copay\n"
				+"$180 copay";


		System.out.println("Expected table  is >>>>>>>>>>>>>"+"\n"+TableData.toString());
		System.out.println("Actual table value is >>>>>>>>>> "+"\n"+retailTable.getText());

		if(retailTable.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}
	/*JavascriptExecutor jse = (JavascriptExecutor) driver;
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

		}*/


	public void validateMailOrderCostSharing_Drugtable() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,+200)", "");
		Select drpPharmacy = new Select(pharmacyDropdownTexas);
		drpPharmacy.selectByValue("Mail Order Cost Sharing");
		Thread.sleep(5000);
		waitforElementNew(MailOrderTable);
		String TableData= "Annual Prescription Deductible Initial Coverage Stage Coverage Gap Stage Catastrophic Coverage Stage\n"
				+"31- to 60-day supply 61- to 90-day supply\n"
				+"Tier 1 :\n"
				+"You pay 100% of costs until $50 deductible is met*\n"
				+"$20 copay\n"
				+"$30 copay\n"
				+"After your total drug costs reach $4,020, the plan covers all formulary drugs through the coverage gap at the same copays listed under the Initial Coverage Stage\n"
				+"When your out-of-pocket costs reach the $6,350 limit for the plan year, you move to the Catastrophic Coverage Stage.  In this stage, you will continue to pay the same cost share that you paid in the Initial Coverage Stage.\n"
				+"The catastrophic coverage will go toward Part D covered medications.\n"
				+"Tier 2 :\n"
				+"$70 copay\n"
				+"$105 copay\n"
				+"Tier 3 :\n"
				+"$120 copay\n"
				+"$180 copay";
		//+"* Please see Additional Drug Coverage for a list of the plan’s maintenance drugs. ERS is continuing to offer additional coverage on some prescription drugs that are normally excluded from coverage on your Formulary. Please see your Additional Drug Coverage list for more information.";

		System.out.println(">>>>>>>>>>>>>>Expected table  is >>>>>>>>>>>>>"+"\n"+TableData.toString());
		System.out.println(">>>>>>>>>>>>>>>Actual table value is >>>>>>>>>> "+"\n"+MailOrderTable.getText());

		if(MailOrderTable.getText().trim().equals(TableData.toString().trim())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		/*	if (ICStage31to60MailOrder.size() > 0 || ICStage61to90MailOrder.size() > 0) {
			Assert.assertTrue("The columns are correct in texas Ers  mail ordertable", true);
		} else {
			Assert.assertFalse("The columns are incorrect in texas Ers  mail ordertable", true);
		}

		if (ICTier1ValueMailOrder.getText().trim().length() > 1) {
			Assert.assertTrue("value in the IC stage tier 1 cell exists", true);
		} else {
			Assert.assertFalse("No value in the IC stage tier 1 cell", true);
		}*/

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
		System.out.println("PCP value to be validated: "+ input);

		Pattern pattern = Pattern.compile("^\\d{1,4}\\.\\d{2}\\%$"); if
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

	public void OutpatientSurgeryCentervisits_withprovidertiering(){
		//Sardar Start
		//String TableData="OUTPATIENT SURGERY CENTER VISITS \n"
		//	+"Type 1: $75.00\n"
		//+"Type 2:  $150.00";
		String TableData="OUTPATIENT";
		if(outPatientSection.getText().contains(TableData.toString())){
			//Sardar End
			Assert.assertTrue("The data in the outPatient section is displaying correctly", true);
			System.out.println("The data in the outPatient section  is displaying correctly");  
		}
		else{
			System.err.println("The data in the outPatient section  is not displaying correctly");
			Assert.fail("The data in the outPatient section is not displaying correctly");
		}}

	public void outpatientcenterwithoutprovidertier(){

		//Sardar Start
		//String TableData="OUTPATIENT SURGERY CENTER VISITS\n"
		//            +"20.00%";
		//if(outPatientSection.getText().equals(TableData.toString())){
		String TableData="OUTPATIENT";
		if(outPatientSection.getText().contains(TableData.toString())){
			//Sardar End

			Assert.assertTrue("Problem>>>>>>>>>>>>>>>>The data in the outPatient section is displaying correctly", true);
			System.out.println("Problem>>>>>>>>>>>>>>>>The data in the outPatient section  is displaying correctly");  
		}
		else{
			System.err.println("Problem>>>>>>>>>>>>>>>>The data in the outPatient section  is not displaying correctly");
			Assert.fail("Problem>>>>>>>>>>>>>>>>The data in the outPatient section is not displaying correctly");
		}}

	public void validateWaysToSaveSection(String planType, String memberType) {
		/*
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0,800)", "");
		 */
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", waysToSaveSection);

		if(planType.equalsIgnoreCase("PDP")){
			if (memberType.contains("Wallgreens")) {

				validateNew(waysToSaveSection);
				validateNew(lowTierdrugs);    
				validateWithValue("Lower-tier Drugs",lowTierdrugsText);        //validate Lower-tier Drugs
				validateNew(wallGreensWidget);
				validateWithValue("Walgreens Preferred Retail Pharmacy", wallGreensWidgetText);             //validate Walgreens Preferred Retail Pharmacy

				validateNew(PreferredMailServicePharmacyLogo);
				validateWithValue("Preferred Mail Service Pharmacy", PreferredMailServicePharmacyText); 



			} else if (memberType.contains("MailOrderPharamacy")) {
				validateNew(waysToSaveSection);
				validateNew(lowTierdrugs);    
				validateWithValue("Lower-tier Drugs",lowTierdrugsText);        //validate Lower-tier Drugs

				validateNew(retailpharmacylogo);
				validateWithValue("Preferred Retail Pharmacy", PreferredRetailPharmacyText);

				validateNew(PreferredMailServicePharmacyLogo);
				validateWithValue("Preferred Mail Service Pharmacy", PreferredMailServicePharmacyText); 
			}	
		} else  {
			//note: by default there will be one id=waystosave element on the page regardless memberType, so check to see it's less than 2 instead of 1
			if (waysToSaveSectionvalidate.size() < 2) {
				Assert.assertTrue("ways to save section doesnt exist for a non PDP memeber", true);
			} else {
				Assert.assertFalse("ways to save section exists for a non PDP memeber", true);
			}
		}


	}

	public void fedtabledata()
	{


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


		drugCostDropdown.sendKeys("Preferred Mail Service Pharmacy");
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

		drugCostDropdown.sendKeys("Standard Retail Pharmacy");
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
		// special character is not validating
		//validatePeehiptableValues();
	}

	//note: Dec2018 - handle SSUP case
	//public void ValidateMAsection() {
	public void validateBncPageSections(String planType) {
		if (planType.equalsIgnoreCase("SSUP")) {
			System.out.println("proceed to locate senior supplement plan tab and click it");
			WebElement ssupTab=driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//li[2]"));
			if (ssupTab.isDisplayed()) {
				ssupTab.click();
				System.out.println("located senior supplement plan tab and clicked it");
				//validateNew(ssupExclusiveHearingSavings);
				//validateNew(ssupVision); 
				//validateNew(ssupDental);
				// benefits summary section
				validateNew(benefitsSummarySection);
				validateNew(officeVisitSection);
				validateNew(hospitalVisitsSection);
				validateNew(OutpatientSurgeryCenterSection);

				// out of pocket maximum section

				validateNew(outOfPocketSection);
				validateNew(inNetworkSection);
				validateNew(outOfNetworkSection);

			
			} 
		} else if (planType.equalsIgnoreCase("MEDSUPP")|| planType.equalsIgnoreCase("SHIP")) {
			if(validateNew(medsuppNavTab))
				medsuppNavTab.click();
			System.out.println("located medicare supplement plan tab and clicked it");	

		} else if(planType.contains("MA")){
			if(validate(mapdNavTab))
				mapdNavTab.click();

			// benefits summary section
			validateNew(benefitsSummarySection);
			validateNew(officeVisitSection);
			validateNew(hospitalVisitsSection);
			validateNew(OutpatientSurgeryCenterSection);

			// out of pocket maximum section

			validateNew(outOfPocketSection);
			validateNew(inNetworkSection);
			validateNew(outOfNetworkSection);

			// PCP section
			validateNew(PrimaryCareProviderHeaderInd);
			validateNew(YourPrimaryCareProvider);
			validateNew(ChangeYourPcpButton);
			validateNew(StartSearch);
			//validateNew(drugCostDropdown);
			//validateNew(drugCopaysAndDiscountSection);

			System.out.println();

		} else if(planType.equalsIgnoreCase("PDP")){
			if(validate(pdpNavTab))
				pdpNavTab.click();
			validateNew(drugCostDropdown);
			validateNew(drugCopaysAndDiscountSection);
		}

		// plan Overview section
		validateNew(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);

		// plan documents section
		validateNew(planDocumentsTitle);
		validateNew(planDocumentsLangDropdown);
		validateNew(view_label);

		// Need help section
		validateNew(needHelpSection);
		validateNew(NeedHelpHeader);
		validateNew(contactUslink);
		validateNew(moreinformation);
	}

	public void validateCopayCoinsuranceInDrugTable() {
		//note: Dec2018 - wait for the element to show up before validation

		validateNew(drugTableNonLisMember);

		if (annualDeductibleColumnFederal.size() > 0 && initialCoverageColumnFederal.size() > 0
				&& coverageGaStageColumnFederal.size() > 0 && catastrophicCoverageStageColumnFederal.size() > 0) {
			Assert.assertTrue("The columns are correct in Drug Costs table", true);

		} else {
			Assert.assertFalse("The columns are incorrect in drug Costs table", true);
		}

		validateNew(federalValueIC);
		String input = federalValueIC.getText();
		System.out.println(">>>>>>>>Value in the Initial Coverage Stage is:"+input);
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
				validateNew(MemberName);
				validateNew(MemberId);
				validateNew(EffectiveDate);
				validateNew(BenefitsSummaryHeadership);
				
				System.out.println(">>>>>>>>>Validating the benefits for a Ship Plan<<<<<<<<<<<<");
				List<WebElement> tilelist = driver.findElements(By.xpath(".//*[@id='benefitShipCard']"));
				int benefitsActualCount=tilelist.size();
				for(int i=0;i<tilelist.size();i++)
				{
					validateNew(tilelist.get(i));
				}
				Assert.assertTrue("PROBLEM -No Benefit ship Card Present",benefitsActualCount>0);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,900)", "");
				validateNew(shipClaimsSupportHeader);
				
				
			} else {
				System.out.println(">>>>>>>>>>Validating the benefits of a Federal Plan of a combo Member<<<<<<<<<<<<");
				validateNew(drugCopaysAndDiscount);
			}

			tabsForComboMember.get(1).click();
			validateNew(memberIdForPlan);
			memberid1 = memberIdForPlan.getText();
			if (memberid1.contains("-11")) {
				validateNew(MemberName);
				validateNew(MemberId);
				validateNew(EffectiveDate);
				validateNew(BenefitsSummaryHeadership);
				
				System.out.println(">>>>>>>>>Validating the benefits for a Ship Plan<<<<<<<<<<<<");
				List<WebElement> tilelist = driver.findElements(By.xpath(".//*[@id='benefitShipCard']"));
				int benefitsActualCount=tilelist.size();
				for(int i=0;i<tilelist.size();i++)
				{
					validateNew(tilelist.get(i));
				}
				Assert.assertTrue("PROBLEM -No Benefit ship Card Present",benefitsActualCount>0);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,900)", "");
				validateNew(shipClaimsSupportHeader);
			} else {
				System.out.println(">>>Validating the benefits of a Federal Plan of a combo Member<<<<<<<<");
				validateNew(drugCopaysAndDiscount);
			}

		}
		else{
			Assert.fail(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Member is not a Combo user.Please replace the user<<<<<<<<<<<<<<<<<<<<<,, ");
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
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int numberOfAddRiderButtons = addRiderButton.size();
		CommonUtility.waitForPageLoadNew(driver, removeRiderButton, 20);
		validateNew(removeRiderButton);
		removeRiderButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CommonUtility.waitForPageLoadNew(driver, removeRiderPopup, 20);
		validateNew(removeRiderPopup);
		validateNew(removeRiderButtonOnPopup);
		removeRiderButtonOnPopup.click();

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int numberOfAddRiderButtonsAfterremovingRider = addRiderButton.size();

		System.out.println(numberOfAddRiderButtonsAfterremovingRider);
		if (numberOfAddRiderButtonsAfterremovingRider == numberOfAddRiderButtons + 1)
			Assert.assertTrue("Add and remove Rider is successfully done",true);
		else
			Assert.assertFalse("Add and remove Rider is not successfully done",true);

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

	/*
	 * this method checks that Plan Benefits Summary Sub Navigation Link 
	 * under Benefits and Coverage is NOT displayed. This method is very useful when
	 * element is available in DOM but element is not displayed on UI
	 */ 
	public void validatePlanBenefitsSummarySubNavNotDisplayed() throws InterruptedException 
	{

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
	public void validateOrderPlanMaterialsSubNavNotDisplayed() 
	{

		System.out.println("Now checking for Order Plan Materials sub navigation of Benefits and Coverage");

		if (!orderMaterialsTab.isDisplayed())
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
		CommonUtility.waitForPageLoadNew(driver, viewPlanDocsBtn, 20);
		System.out.println("View Plan Documents button was displayed");
		System.out.println("Now checking for message on Benefits and Coverage Page for Pre-effective members");
		System.out.println("The message displayed on screen is "+messageForPreeffective.getText());
		if(!messageForPreeffective.getText().contains("When your plan starts,"))
			Assert.fail("Correct message is not displayed");


	}

	public void verifyCorrectTechSupportNumberForPreEffectiveMembers(String technicalPhNo) throws InterruptedException 
	{

		System.out.println("Now checking for Tech Support Number for Pre-effective members");
		System.out.println("The Tech Support phone number displayed on screen is "+preEffectiveTechSupportNumber.getText());
		Assert.assertEquals(preEffectiveTechSupportNumber.getText(),technicalPhNo);
		System.out.println("Assert for correct Tech Suppport Phone Number  was passed");

	}

	public void verifyClaimSupportSupportNumberNOTDisplayedForSHIPPreEffectiveMembers() throws InterruptedException 
	{

		System.out.println("Now checking for Claim Support Number for SHIP Pre-effective members");
		try {
			preEffectiveClaimsSupportNumber.isDisplayed();                            	  
			System.out.println("Claim Support Number for SHIP Pre-effective members was displayed");
			Assert.fail("Claim Support Number for SHIP Pre-effective members was displayed, Test step is failed due to it");
		} catch (Exception e) {
			System.out.println("Claim Support Number for SHIP Pre-effective members was NOT displayed, Test step is passed due to it");
		}

	}

	public void verifyClaimSupportSupportHeaderInNeedHelpNOTDisplayedForSHIPPreEffectiveMembers() throws InterruptedException 
	{

		System.out.println("Now checking for Claim Support Header in Need Help Section for SHIP Pre-effective members");
		try {
			preEffectiveClaimsSupportHeader.isDisplayed();
			System.out.println("Claim Support Header in Need Help Section for SHIP Pre-effective members was displayed");
			Assert.fail("Claim Support Header in Need Help Sectionr for SHIP Pre-effective members was displayed, Test step is failed due to it");
		} catch (Exception e) {
			System.out.println("Claim Support Header in Need Help Section for SHIP Pre-effective members was NOT displayed, Test step is passed due to it");
		}

	}

	public FormsAndResourcesPage clickViewPlanDocumentsButton() throws InterruptedException 
	{
		CommonUtility.waitForPageLoadNew(driver, viewPlanDocumentsButton, 45);
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

	/**
	 * Validate the Access your Drug Benefits 
	 * @return
	 */
	public boolean validateAccessDrugsBenfitsBlock() {
		boolean bAccessDrugsBenfitsBlockValidation = true;
		if(validateNew(accessDrugsBenfitsBlock) && validate(accessDrugsBenfitsBlockHeader) && validate(accessDrugsBenfitsBlockExpressScriptsLink)){
			bAccessDrugsBenfitsBlockValidation = true;
		}else
			bAccessDrugsBenfitsBlockValidation = false;
		return bAccessDrugsBenfitsBlockValidation;
	}

	/**
	 * Validate the Access your Drug Benefits 
	 * @return
	 */
	public boolean validateSiteLeavingPopUp() {
		boolean bAccessDrugsBenfitsBlockValidation = true;
		if(validate(siteLeavingPopUp)){
			bAccessDrugsBenfitsBlockValidation = true;
		}else
			bAccessDrugsBenfitsBlockValidation = false;
		return bAccessDrugsBenfitsBlockValidation;
	}

	/**
	 * Validate the Access your Drug Benefits 
	 * @return
	 */
	public boolean validateSiteLeavingPopUpCancelFlow() {
		accessDrugsBenfitsBlockExpressScriptsLink.click();
		waitforElement(siteLeavingPopUp);
		boolean bAccessDrugsBenfitsBlockValidation = false;
		jsClickNew(siteLeavingPopUpCancelBtn);
		if(driver.findElements(By.cssSelector("div.siteleaving-popup-footer>div")).size()>0){
			bAccessDrugsBenfitsBlockValidation = true;
		}else
			bAccessDrugsBenfitsBlockValidation = false;
		return bAccessDrugsBenfitsBlockValidation;
	}

	/**
	 * Validate the Access your Drug Benefits 
	 * @return
	 */
	public boolean validateSiteLeavingPopUpProceedFlow() {
		accessDrugsBenfitsBlockExpressScriptsLink.click();
		waitforElement(siteLeavingPopUp);
		boolean bAccessDrugsBenfitsBlockValidation = true;
		jsClickNew(siteLeavingPopUpProceedBtn);
		if(driver.getWindowHandles().size()>0) {
			bAccessDrugsBenfitsBlockValidation=true;
			Assert.assertTrue(driver.getWindowHandles().size()>0);
		}else {
			bAccessDrugsBenfitsBlockValidation=false;
		}
		return bAccessDrugsBenfitsBlockValidation;
	}

	public void validate_provider_search_link() {
		driver.navigate().to("https://stage-mymedicareaccount.uhc.com/pcp/member/benefits/overview.html");
		waitforElement(providersearchlink);
		validateNew(providersearchlink);

		String ParentWindow = driver.getTitle();
		providersearchlink.click();
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> handles1 = driver.getWindowHandles();
		for (String windowHandle : handles1) {
			if (!windowHandle.equals(ParentWindow)) {
				driver.switchTo().window(windowHandle);
				String title = driver.getTitle();
				System.out.println("Window title is : " + title);
				if (title.contains("Medical | Find Care")) {
					System.out.println("user is on provider search page");							
					break;
				}
			} else {
				System.out.println("Not found Expected window");
				driver.switchTo().window(ParentWindow);
			}

		}

	}

	public void validatedrugcosttableMAPDLIS4() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_Table, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_Table);

		if(RetailDrugCost_Table.getText().contains("Annual Deductible Stage")&&RetailDrugCost_Table.getText().contains("Initial Coverage Stage")){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}

	}
	public void validatedrugcosttablePDPLIS3() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_Table, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_Table);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", RetailDrugCost_Table);
		String mapdGroupTable= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Covered Generic Drugs\n"
				+"No Deductible\n"
				+"$0.00\n"
				+"$0.00\n"
				+"All Other Covered Drugs\n"
				+"$0.00\n"
				+"$0.00";
		System.out.println("the hardcoded value" +mapdGroupTable);
		System.out.println("the hardcoded value" +RetailDrugCost_Table.getText());
		if(RetailDrugCost_Table.getText().equals(mapdGroupTable.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<< \n" +mapdGroupTable);
			System.out.println(">>>>>>>>>>>>>The Actual Table value is<<<<<<<<<<<<<<<<<<<< \n" +RetailDrugCost_Table.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}

	}

	public void validatedrugcosttableMAPD_NONLIS() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_TableNONLIS, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_TableNONLIS);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP NON LIS USER", RetailDrugCost_TableNONLIS);
		String mapdGroupTable= "Additional Drug Coverage\n"
				+"Annual Deductible Stage \n"
				+"Initial Coverage Stage \n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage \n"
				+"Tier 1 \n"
				+"No Deductible\n"
				+"$3.00\n"
				+"$3.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2 \n"
				+"$28.00\n"
				+"You pay 25% of the total cost for generic drugs and 25% of the cost (plus a portion of the dispensing fee) for brand name drugs.\n"
				+"Tier 3 \n"
				+"$55.00\n"
				+"Tier 4 \n"
				+"$55.00";
		if(RetailDrugCost_TableNONLIS.getText().equals(mapdGroupTable.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<< \n"+mapdGroupTable.toString());
			System.out.println(">>>>>>>>>>>>>The Actual Table value is<<<<<<<<<<<<<<<<<<<< \n"+RetailDrugCost_TableNONLIS.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}

	}


	public void validatedrugcosttablePDPGroupLIS1() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_Table, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_Table);
		validateWithValue("Drug cost table is diplaying for PDP GROUP LIS 1", RetailDrugCost_Table);
		String mapdGroupTable= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Covered Generic Drugs\n"
				+"$0.00\n"
				+"$3.60\n"
				+"$0.00\n"
				+"All Other Covered Drugs\n"
				+"$8.95\n"
				+"$0.00";

		if(RetailDrugCost_Table.getText().equals(mapdGroupTable.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else {
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<<"+mapdGroupTable.toString());
			System.out.println(">>>>>>>>>>>>>The Actual Table value is<<<<<<<<<<<<<<<<<<<<"+RetailDrugCost_Table.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}

	}
	public void validatedrugcosttablePDPGroup_NONLIS() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_TableNONLIS, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_TableNONLIS);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", RetailDrugCost_TableNONLIS);
		String mapdGroupTable= "Additional Drug Coverage\n"
				+"Annual Deductible Stage \n"
				+"Initial Coverage Stage \n"
				+"Coverage Gap Stage \n"
				+"Catastrophic Coverage Stage \n"
				+"Tier 1 \n"
				+"No Deductible\n"
				+"$10.00\n"
				+"$10.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2 \n"
				+"$20.00\n"
				+"$20.00\n"
				+"Tier 3\n"
				+"$35.00\n"
				+"$35.00\n"
				+"Tier 4\n"
				+"$35.00\n"
				+"$35.00";


		if(RetailDrugCost_TableNONLIS.getText().equals(mapdGroupTable.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<<"+mapdGroupTable.toString());
			System.out.println(">>>>>>>>>>>>>The Actual Table value is<<<<<<<<<<<<<<<<<<<<"+RetailDrugCost_TableNONLIS.getText());
			System.err.println(">>>>>>>>Problem<<<<<<<<<<<<<<<The data in the drug cost table is not displaying correctly<<<<<<<<<<<<<");
			Assert.fail(">>>>>>>>Problem<<<<<<<<<<<<<<<The data in the drug cost table is not displaying correctly<<<<<<<<<<<<<<<<<<<<<");
		}

	}

	public void validatedrugcosttablePDPIndi_NONLIS() throws InterruptedException {
		preferredRetailBenefitTableIndipdp();
		preferredMailBenefitTableIndipdp();
		standardRetailBenefitTableIndipdp3();
	}

	public void preferredRetailBenefitTableIndipdp(){
		CommonUtility.waitForPageLoad(driver, preferredRetailBenefitTableIndipdp, 15);
		validateWithValue("Drug cost table", preferredRetailBenefitTableIndipdp);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No deductible.\n"
				+"$0.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$5.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 3\n"
				+"100% until the $435.00 deductible is met.*\n"
				+"$40.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"32%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"25%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"*Once you reach the Coverage Gap Stage, you pay co-pays or co-insurance defined by your plan for all Tier 1 through Tier 5 drugs regardless of whether your full deductible has been met.";


		if(preferredRetailBenefitTableIndipdp.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>>>>>>>The Expected table value is-<<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is-<<<<<<<<<<<<<   \n"+preferredRetailBenefitTableIndipdp.getText());

			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Preferred Retail Pharmacy Drug Costs Text", PreferredRetailPharmacyDrugCostsText);
		validateWithValue("Preferred Retail Pharmacy DrugCosts Text Line", PreferredRetailPharmacyDrugCostsTextLinePDP);
	}
	public void preferredMailBenefitTableIndipdp() throws InterruptedException{
		scrollToView(drugCostDropdown);
		Select drugCostdropdwn = new Select(drugCostDropdown);
		drugCostdropdwn.selectByVisibleText("Preferred Mail Service Pharmacy");

		CommonUtility.waitForPageLoad(driver, preferedMail_Table1PDP, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", preferedMail_Table1PDP);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", preferedMail_Table1PDP);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No deductible.\n"
				+"$0.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$15.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 3\n"
				+"100% until the $435.00 deductible is met.*\n"
				+"$120.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"32%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"25%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"*Once you reach the Coverage Gap Stage, you pay copays or coinsurance defined by your plan for all Tier 1 through Tier 5 drugs regardless of whether your full deductible has been met.";


		if(preferedMail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+preferedMail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Preferred Mail Service Pharmacy Drug Costs", PreferredMailServicePharmacyDrugCostsText);
		validateWithValue("Preferred Mail Service Pharmacy Drug Costs Text Line", PreferredMailServicePharmacyDrugCostsTextLinePDP);

	}
	public void standardRetailBenefitTableIndipdp3() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		drugCostdropdwn.selectByVisibleText("Standard Retail Pharmacy");
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$15.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$20.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 3\n"
				+"$435.00\n"
				+"$47.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"33%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"25%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"*Once you reach the Coverage Gap Stage, you pay copays or coinsurance defined by your plan for all Tier 1 through Tier 5 drugs regardless of whether your full deductible has been met.";


		if(standardDetail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<<< \n- "+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+standardDetail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Standard Network Pharmacy Retail Drug Text", StandardNetworkPharmacyRetailDrugCostsText);
		validateWithValue("Standard Network Pharmacy Retail Drug Text Line", StandardNetworkPharmacyRetailDrugCostsTextLinePDP);
	}

	public void validatevillagetabletext() throws InterruptedException{
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_TableNONLIS, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_TableNONLIS);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", RetailDrugCost_TableNONLIS);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$3.00\n"
				+"no more than 37% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.40 for a generic drug or a drug that is treated like a generic and $8.50 for all other drugs.\n"
				+"Tier 2\n"
				+"$7.00\n"
				+"no more than 37% for generic drugs or 25% for brand name drugs \n"
				+"Tier 3\n"
				+"$45.00\n"
				+"no more than 37% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$95.00\n"
				+"no more than 37% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"33%\n"
				+"no more than 37% for generic drugs or 25% for brand name drugs";


		if(RetailDrugCost_TableNONLIS.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{

			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+RetailDrugCost_TableNONLIS.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Standard Network Pharmacy Retail Drug Text", StandardNetworkPharmacyRetailDrugCostsText);
		validateWithValue("Standard Network Pharmacy Retail Drug Text Line", StandardNetworkPharmacyRetailDrugCostsTextLineVellage);
	}

	public void validatevillageCopaySection() throws InterruptedException{
		officeVisitSection();
		hospitalVisitSection();
		outPatientSection();
		inNetworkSection();
		outNetworkSection();


	}

	public void officeVisitSection(){
		String TableData= "OFFICE VISITS \n"
				+"Primary care provider:\n"
				+"$0.00\n\n"

+"Specialist:\n"
+"$40.00";

		if(officeVisitSection.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the Office visit section is displaying correctly", true);
			System.out.println("The data in the Office visit section  is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual value is- <<<<<<<<<<<<< \n"+officeVisitSection.getText());
			System.err.println("The data in the Office visit section  is not displaying correctly");
			Assert.fail("The data in the Office visit section is not displaying correctly");
		}}
	public void hospitalVisitSection(){
		String TableData= "INPATIENT HOSPITAL CARE \n"
				+"days 1 - 8 : $225.00 Copay per day\n"
				+"days 9 - 90 : $0.00 Copay per day";
		System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<<- "+TableData.toString());
		System.out.println(">>>>>>>>>>The Actual table value is<<<<<<<<<<<<<- "+hospitalVisitSection.getText());

		if(hospitalVisitSection.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the hospital Visit Section is displaying correctly", true);
			System.out.println("The data in the hospital Visit Section  is displaying correctly");  
		}
		else{
			System.err.println(">>>>>>>>>>>The data in the hospital Visit Section  is not displaying correctly<<<<<<<<<");
			Assert.fail(">>>>>>>>>>>>>>>>>>The data in the hospital Visit Section is not displaying correctly<<<<<<<<<<");
		}}



	public void outPatientSection(){
		String TableData="OUTPATIENT\n"
				+"Type 1: $150.00\n"
				+"Type 2:  $275.00";
		if(outPatientSection.getText().contains(TableData.toString())){
			Assert.assertTrue("The data in the outPatient section is displaying correctly", true);
			System.out.println("The data in the outPatient section  is displaying correctly");  
		}
		else{
			System.err.println("The data in the outPatient section  is not displaying correctly");
			Assert.fail("The data in the outPatient section is not displaying correctly");
		}}
	public void inNetworkSection(){
		String TableData= "IN-NETWORK\n"
				+"$3,400.00";
		System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
		System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+inNetworkSection.getText());

		if(inNetworkSection.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the InNetwork section is displaying correctly", true);
			System.out.println("The data in the InNetwork section  is displaying correctly");  
		}
		else{
			System.err.println("The data in the InNetwork section  is not displaying correctly");
			Assert.fail("The data in the InNetwork Section is not displaying correctly");
		}}

	public void outNetworkSection(){
		String TableData= "OUT-OF-NETWORK\n"

+"N/A";
		System.out.println(">>>>>>>>>The Expected value is<<<<<<<<<<<< \n"+TableData.toString());
		System.out.println(">>>>>>>>>>>>>>>>>>>The Actual value is- <<<<<<<<<<<<< \n"+outNetworkSection.getText());

		if(outNetworkSection.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the out Network Section is displaying correctly", true);
			System.out.println("The data in the out Network Section  is displaying correctly");  
		}
		else{
			System.err.println("The data in the Oout Network Section  is not displaying correctly");
			Assert.fail("The data in the out Network Section is not displaying correctly");
		}}

	public void validatePeehiptableValues(){
		String TableData= "Annual Deductible Stage Initial Coverage Stage Coverage Gap Stage Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$6.00\n"
				+"$6.00\n"
				+"Your share of the cost for a covered drug will be either co-insurance or a copay, whichever is the lesser amount between:\n"
				+"either — $6.00\n"
				+"or — 5% co-insurance on the cost of the drug OR a co-pay of $3.40 for a generic drug or a drug that is treated like a generic and $8.50 for all other drugs, whichever is the larger amount.\n"
				+"Tier 2\n"
				+"$40.00\n"
				+"$40.00\n"
				+"Your share of the cost for a covered drug will be either co-insurance or a copay, whichever is the lesser amount between:\n"
				+"either — $40.00\n"
				+"or — 5% co-insurance on the cost of the drug OR a co-pay of $3.40 for a generic drug or a drug that is treated like a generic and $8.50 for all other drugs, whichever is the larger amount.\n"
				+"Tier 3\n"
				+"$60.00\n"
				+"$60.00\n"
				+"Your share of the cost for a covered drug will be either co-insurance or a copay, whichever is the lesser amount between:\n"
				+"either — $60.00\n"
				+"or — 5% co-insurance on the cost of the drug OR a co-pay of $3.40 for a generic drug or a drug that is treated like a generic and $8.50 for all other drugs, whichever is the larger amount.\n"
				+"Tier 4\n"
				+"$60.00\n"
				+"$60.00\n"
				+"Your share of the cost for a covered drug will be either co-insurance or a copay, whichever is the lesser amount between:\n"
				+"either — $60.00\n"
				+"or — 5% co-insurance on the cost of the drug OR a co-pay of $3.40 for a generic drug or a drug that is treated like a generic and $8.50 for all other drugs, whichever is the larger amount.";

		if(PeehipTable.getText().toString().equals(TableData.toString())){
			Assert.assertTrue("The data in the table is displaying correctly", true);
			System.out.println("The data in the table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+PeehipTable.getText());

			System.err.println("The data in the table is not displaying correctly");
			Assert.fail("The data in the table is not displaying correctly");
		}}



	public void validategroupdrugtableMAPD() throws InterruptedException{
		standardRetailBenefitTableIndiMAPD();
		preferredMailBenefitTableIndiMAPD();
	}



	public void standardRetailBenefitTableIndiMAPD() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		drugCostdropdwn.selectByVisibleText("Standard Retail Pharmacy");

		String TableData="Annual Deductible Stage\n"
				+"Initial Coverage Stage\n" 
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$3.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$10.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 3\n"
				+"$150.00\n"
				+"$45.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$95.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"30%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"*Once you reach the Coverage Gap Stage, you pay copays or coinsurance defined by your plan for all Tier 1 through Tier 5 drugs regardless of whether your full deductible has been met.";


		if(standardDetail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+standardDetail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Standard Network Pharmacy Retail Drug Text", StandardNetworkPharmacyRetailDrugCostsText);
		validateWithValue("Standard Network Pharmacy Retail Drug Text Line", StandardNetworkPharmacyRetailDrugCostsTextLine);
	}

	public void preferredMailBenefitTableIndiMAPD() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		drugCostdropdwn.selectByVisibleText("Preferred Mail Service Pharmacy");

		CommonUtility.waitForPageLoad(driver, preferedMail_Table1PDP, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", preferedMail_Table1PDP);
		validateWithValue("Drug cost table", preferedMail_Table1PDP);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No deductible.\n"
				+"$0.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$0.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 3\n"
				+"100% until the $150.00 deductible is met.*\n"
				+"$125.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$275.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"30%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"*Once you reach the Coverage Gap Stage, you pay copays or coinsurance defined by your plan for all Tier 1 through Tier 5 drugs regardless of whether your full deductible has been met.";


		if(preferedMail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+preferedMail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Preferred Mail Service Pharmacy Drug Costs", PreferredMailServicePharmacyDrugCostsText);
		validateWithValue("Preferred Mail Service Pharmacy Drug Costs Text Line", PreferredMailServicePharmacyDrugCostsTextLine);
	}

	public void validategroupdrugtableMedica() throws InterruptedException{
		standardRetailBenefitTableIndiMedica();
		preferredMailBenefitTableIndiMedica();
	}
	public void preferredMailBenefitTableIndiMedica() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		Thread.sleep(2000);
		drugCostdropdwn.selectByVisibleText("Preferred Mail Service Pharmacy");
		Thread.sleep(2000);

		CommonUtility.waitForPageLoad(driver, preferedMail_Table1PDP, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", preferedMail_Table1PDP);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", preferedMail_Table1PDP);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Tier 3\n"
				+"$80.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$185.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"33%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs";


		if(preferedMail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+preferedMail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}

	}
	public void standardRetailBenefitTableIndiMedica() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		Thread.sleep(2000);
		drugCostdropdwn.selectByVisibleText("Standard Retail Pharmacy");
		Thread.sleep(2000);
		String TableData= "Additional Drug Coverage\n"
		        +"Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Tier 3\n"
				+"$30.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$65.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"33%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs";

		if(standardDetail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< "+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+standardDetail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}



	public void validategroupdrugtablePCP() throws InterruptedException{
		standardRetailBenefitTableIndiPCP();
		preferredMailBenefitTableIndiPCP();
	}
	public void preferredMailBenefitTableIndiPCP() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		Thread.sleep(2000);
		drugCostdropdwn.selectByVisibleText("Preferred Mail Service Pharmacy");
		Thread.sleep(2000);

		CommonUtility.waitForPageLoad(driver, preferedMail_Table1PDP, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", preferedMail_Table1PDP);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", preferedMail_Table1PDP);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Tier 3\n"
				+"$131.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$290.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"33%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs";

		if(preferedMail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+preferedMail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}

	}
	public void standardRetailBenefitTableIndiPCP() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		Thread.sleep(2000);
		drugCostdropdwn.selectByVisibleText("Standard Retail Pharmacy");
		Thread.sleep(2000);
		String TableData= "Additional Drug Coverage\n"
		        +"Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$10.00\n"
				+"$10.00\n"
				+"Tier 3\n"
				+"$47.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$100.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"33%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs";
		
		if(standardDetail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+standardDetail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}

	public void validatedrugcosttableMapdLIS() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		drugCostdropdwn.selectByVisibleText("Standard Retail Pharmacy");
		Thread.sleep(2000);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Covered Generic Drugs\n"
				+"No Deductible\n"
				+"$3.60\n"
				+"$0.00\n"
				+"All Other Covered Drugs\n"
				+"$8.95\n"
				+"$0.00";
		System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
		System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+RetailDrugCost_Table.getText());

		if(RetailDrugCost_Table.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}

	public void validatePrimaryCareProviderSection() {

		validateNew(PrimaryCareProviderHeaderInd);
		validateNew(YourPrimaryCareProvider);
		validateNew(ChangeYourPcpButton);
		validateNew(SearchProvider);
		validateNew(StartSearch);
	}

	public void validatePdfLinks(String planType){
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(planType.equalsIgnoreCase("MAPD")){

			if(mapdPdfLinks.size()!=0){
				System.out.println(" PDF links size:"+ mapdPdfLinks.size());
			}else
				Assert.fail("No PDFs found");

		}else if(planType.equalsIgnoreCase("PDP")){

			if(pdpPdfLinks.size()!=0){
				System.out.println(" PDF links size:"+ pdpPdfLinks.size());
			}else
				Assert.fail("No PDFs found");
		}

	}

	public void navigateToDocumentsAndResourcesPage(String planType){
		if(planType.equalsIgnoreCase("SHIP")||planType.equalsIgnoreCase("MEDSUPP")){
			validateNew(viewDocsAndResourcesLinkShip);
			viewDocsAndResourcesLinkShip.click();
		}
		else{
			validateNew(viewDocsAndResourcesLink);
			viewDocsAndResourcesLink.click();
		}
		if(!validateNew(docsAndResourcesHeader))
			Assert.fail("Error in loading the documents and resources page");		
	}

	public void navigateToOrderPlanMaterialsPage(){
		validateNew(orderMaterialsTab);
		orderMaterialsTab.click();
	}

	public void validateOrderPlanMaterialsPage(String planType){
		if(planType.equalsIgnoreCase("MEDSUPP") || planType.equalsIgnoreCase("SHIP")){
			validateNew(radioBtnsSectionShip);
		}else
			validateNew(radioBtnsSectionNonShip);

		validateNew(submitOrderBtn);
		validateNew(planDocsAndResourcesBtn);
	}

	public PaymentHistoryPage navigateToPaymentsPage(){
		paymentsTab.click();

		if(validateNew(paymentsHeader))
			return new PaymentHistoryPage(driver);
		return null;
	}

	public void validatePlanNavTab(String planType) {

		if(planType.equalsIgnoreCase("MAPD")||planType.equalsIgnoreCase("MA")){
			if(validate(mapdNavTab))
				mapdNavTab.click();	
		}else if(planType.equalsIgnoreCase("PDP")&&validate(pdpNavTab)){
			pdpNavTab.click();
		}else if((planType.equalsIgnoreCase("MEDSUPP")||planType.equalsIgnoreCase("SHIP"))){
			if(validate(medsuppNavTab))
				medsuppNavTab.click();
		}		
	}

	public void validatePlanNavTabOrderMaterialsPage(String planType) {

		if(planType.equalsIgnoreCase("MAPD")||planType.equalsIgnoreCase("MA")){
			if(validate(mapdNavTab))
				mapdNavTab.click();	
		}else if(planType.equalsIgnoreCase("PDP")&&validate(pdpNavTab)){
			pdpNavTabOrderMaterials.click();
		}else if((planType.equalsIgnoreCase("MEDSUPP")||planType.equalsIgnoreCase("SHIP"))){
			if(validate(medsuppNavTab))
				medsuppNavTabOrderMaterials.click();
		}

	}

	public void validateNavTabs() {
		validateNew(benefitsSummarySection);
		validateNew(formsAndResourcesTab);
		validateNew(orderMaterialsTab);
	}

	public void clickPlanDocsAndResourcesTab(){
		formsAndResourcesTab.click();
		validateNew(docsAndResourcesHeader);
	}

	public void clickOrderMaterialsNavTab() {
		orderMaterialsTab.click();
		validateNew(orderMaterialsHeader);	
	}
	
	public void sleepBySec(int sec) {
		System.out.println("Sleeping for '"+sec+"' sec");
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}




