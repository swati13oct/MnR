package pages.regression.benefitandcoverage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @Functionality : To check Benefits and Coverage page
 */
public class BenefitsAndCoverageWebElements extends UhcDriver {

	@FindBy(linkText = "VIEW PLAN DOCUMENTS")
	protected WebElement viewPlanDocumentsButton;

	@FindBy(xpath="//*[@id='plandeductiblecard2']")
	protected WebElement MedicalDeductibleCard2;

	@FindBy(xpath = "//a[contains(text(),'VIEW PLAN DOCUMENTS')]/ancestor::p/preceding-sibling::p")
	protected WebElement messageForPreeffective;

	@FindBy(xpath = "//p[contains(@ng-if, 'preEffective == true') or (contains(@ng-if, 'preEffective != true') and contains(@ng-if, 'businessType ==') )]")
	protected WebElement preEffectiveTechSupportNumber;

	@FindBy(xpath = "//p[contains(text(),'1-800-523-5880')]")
	protected WebElement preEffectiveClaimsSupportNumber;

	@FindBy(xpath = "//h3[@class='needhelp h4 margin-none atdd-claims-header']")
	protected WebElement preEffectiveClaimsSupportHeader;

	@FindBy(id = "IPerceptionsEmbed")
	protected WebElement iPerceptionframe;

	@FindBy(id = "closeButton")
	protected WebElement iPerceptionclosebtn; 

	@FindBy(xpath = ".//*[@id='pcpCard']/section/button")
	protected WebElement Addaprovider;

	@FindBy(xpath = "//*[contains(@id,'planBenefitsApp')]//*[contains(@class,'memberidlabel')]")
	protected WebElement memberId;

	@FindBy(xpath = "//*[contains(@id,'planBenefitsApp')]//*[contains(@class,'membernamelabel')]")
	protected WebElement memberName;

	@FindBy(xpath = "//*[contains(@id,'planBenefitsApp')]//*[contains(@class,'effectivedatelabel')]")
	protected WebElement effectiveDate;

	@FindBy(xpath = ".//*[@id='planBenefitsApp']/section/div/div[1]/div/div/div/div/h1")
	protected WebElement planName1;

	//@FindBy(xpath =".//*[@id='mapdPageLis'] or contains(text0,'Covered Generic Drugs')")
	@FindBy(xpath = ".//*[@id='mapdPageLis']/div[1]/div/div/table/tbody/tr[2]/th")
	protected WebElement columncoveragegenericdrugs;

	@FindBy(id = "contactUsAtdd")
	protected WebElement contactUslink;

	@FindBy(xpath = ".//*[@id='seeMoreWaysAtdd']")
	protected WebElement Seemorewaystext;

	@FindBy(xpath = ".//*[contains(@class,'atdd-need-help')]")
	protected WebElement NeedHelpHeader;

	@FindBy(id = "needhelpsectioncontactus")
	protected WebElement Contactussection;

	// protected WebElement Contactussection;

	@FindBy(xpath = ".//*[contains(@class,'atdd-needhelp-disclaimer-text')]")
	protected WebElement disclaimersLink;

	@FindBy(xpath = "//a[contains(text(),'MORE INFORMATION')]")
	protected WebElement moreinformation;

	@FindBy(id = "collapseDisclaimer")
	protected WebElement moreinformationArea;


	@FindBy(xpath = ".//*[contains(@class,'planBenefitDocumentsContainer section')]//*[contains(@class,'planBenefitDocumentsContainer')]")
	protected WebElement planBenefitsDocuments;

	@FindBy(id = "lang-select-2")
	protected WebElement langdropdown;

	@FindBy(xpath = "//span[contains(text(),'HEARING')]")
	protected WebElement Hearingsection;

	@FindBy(xpath = ".//*[@class='bold margin-small atdd-bnc-hearingtxt-subtitle']//following-sibling::p")
	protected WebElement HearingContent;

	@FindBy(xpath= ".//*[@class='margin-small bold atdd-benefitssummary-eyewear']//following-sibling::p")
	protected WebElement VisionContent;

	@FindBy(xpath = "//*[@id='ancillary']//h4[@class='h4 margin-extra-small atdd-benefitssummary-exclusivehearing']")
	protected WebElement Hearingaid;

	@FindBy(xpath = "//span[contains(text(),'VISION')]")
	protected WebElement Visionsection;

	@FindBy(xpath = "//span[contains(text(),'DENTAL')]")
	protected WebElement Dentalsection;

	@FindBy(xpath = ".//*[@class='bold margin-small atdd-benefitssummary-routine-dental']//following-sibling::p")
	protected WebElement DentalContent;

	@FindBy(xpath = "//h4[contains(text(),'ADDITIONAL BENEFITS')]")
	protected WebElement Headersection;

	@FindBy(xpath="//a[@class='btn btn--secondary atdd-bnc-optumRx']")
	protected WebElement optumRxBtn;

	@FindBy(className = ".//*[@id='ancillary']/div[2]/div[4]/div/div")
	protected WebElement chiropracticsection;

	@FindBy(className = "atdd-bnc-drgcvrgeinfo")
	protected WebElement DrugCoveragetext;

	@FindBy(xpath = "//p[@class='atdd-bnc-drugcoverage-title']")
	protected WebElement DrugCoveragetext_pdp;

	@FindBy(xpath = "//p[@class='atdd-bnc-drugcoverage-title' or @class='atdd-bnc-drgcvrgeinfo' ]")
	protected WebElement DrugCoveragetext_pdpIndi;

	@FindBy(className = "atdd-bnc-drugcoverage-title")
	protected WebElement DrugCoverageHeader;

	@FindBy(xpath = "//h2[@class='atdd-bnc-drgcopaysdiscounts-title']")
	protected WebElement lisDrugCopayHeader;

	@FindBy(xpath = "//p[contains(text(),'Your plan premium is calculated based on the plan')]")
	protected WebElement lisDrugCopayHeadertext;

	@FindBy(xpath = "//div[@class='drugCopaysAndDiscounts section'][1]//div[@class='drugCopayHeaderParsys parsys section']//p[@class='atdd-bnc-drgcopaysdiscounts-info']")
	protected WebElement lisDrugCopayText;

	@FindBy(xpath = "//div[@class='drugCopaysAndDiscounts section'][1]//div[@class='drugCopayHeaderParsys parsys section']//p[2]")
	protected WebElement pdp_lisDrugCopayText;

	@FindBy(xpath = "//p[contains(text(),'Estimate your drug costs and view ways to save.')]")
	protected WebElement LookupDrugstext;

	@FindBy(xpath = "//a[contains(text(),'Look up Drugs')]")
	protected WebElement LookUpDrugsButton;
	
	@FindBy(xpath = "//span[contains(text(),'DRUG LOOKUP')]")
	protected WebElement LookUpDrugsButtonSection;
	

	@FindBy(xpath = "//a[contains(text(),'VIEW DETAILS AT OPTUMRX.COM')]")
	protected WebElement viewDetailsAtOptumrxLink;	
	
	@FindBy(xpath = "//p[contains(text(),'PRESCRIPTION DRUG COST SUMMARY')]")
	protected WebElement viewDetailsAtOptumrxLinkSection;	
	
	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-title")
	protected WebElement DrugCopayHeader;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-info")
	protected WebElement DrugCopayText;

	@FindBy(xpath = "//div[contains(@class, 'ng-hide')]//select[@id='drug-costs']")
	protected WebElement drugCostDropdownHiding;

	@FindBy(id = "drug-costs")
	protected WebElement drugCostDropdown;

	@FindBy(className = "atdd-bnc-drugcostsheading")
	protected WebElement DrugCostHeader;

	//@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[2]/div/div")
	@FindBy(xpath =".//*[@id='drug-benefits']//span[text()='DRUG LOOKUP']")
	protected WebElement DrugCostheaderandtext;

	@FindBy(xpath ="//p[@class='atdd-bnc-lookupdrugs-info']")
	protected WebElement drugLookUPText;

	@FindBy(xpath = ".//*[@id='waystosave']/div/div/div[1]/div/h1")
	protected WebElement TextWaystoSave;

	@FindBy(xpath = "//a[@class='display-block collapse-expand collapsed atdd-bnc-drgpricingtiers']")
	protected WebElement Learnmoretierslink;

	@FindBy(xpath = "//a[@class='display-block collapse-expand collapsed atdd-bnc-drgpricingtiers']")
	protected WebElement LearnMoreDrugPricingTiersLink;

	@FindBy(xpath = "//div[@class='margin-extra-small display-block ng-hide']//a[@class='display-block collapse-expand collapsed atdd-bnc-drgpricingtiers']")
	protected WebElement LearnMoreDrugPricingTiersLink_hidden_pdpLis;

	@FindBy(xpath = "//div[@class='margin-extra-small display-block']//a[@class='display-block collapse-expand collapsed atdd-bnc-drgpricingtiers']")
	protected WebElement LearnMoreDrugPricingTiersLink_visble_pdpLis;

	@FindBy(id = "collapseTiers")
	protected WebElement LearnmoretierslinkArea;

	@FindBy(xpath = "//a[@class='display-block collapse-expand atdd-bnc-drgpricingtiers']")
	protected WebElement LearnmoretierslinkForCollapsed;

	@FindBy(xpath = "//a[@class='display-block collapse-expand atdd-bnc-drgpricingtiers collapsed']")
	protected WebElement LearnmoretierslinkAfterCollapsed;

	@FindBy(xpath = "//*[contains(@class,'atdd-bnc-drgstgtiers')]")
	protected WebElement Learnmorestagelink;

	@FindBy(xpath = "//a[@class='display-block collapse-expand atdd-bnc-drgstgtiers']")
	protected WebElement LearnmorestagelinkForCollapse;

	@FindBy(xpath = "//a[@class='display-block collapse-expand atdd-bnc-drgstgtiers collapsed']")
	protected WebElement LearnmorestagelinkAfterCollapse;

	@FindBy(xpath="//div[@id='collapseStages']")
	//@FindBy(id = "collapseStages")
	protected WebElement LearnmorestageExpandedArea;


	// @FindBy(xpath = "//p[contains(text(),'Find a location near you.')]")
	@FindBy(xpath="//span[contains (text(),'PHARMACY LOCATOR')]")
	protected WebElement locateapharmacysection;

	//@FindBy(className = "atdd-bnc-locatepharmacybtn")
	//@FindBy(xpath=".//*[contains (text(),'Locate a Pharmacy')]")
	@FindBy(className = "atdd-bnc-locatepharmacybtn")
	protected WebElement locateapharmacybutton;

	@FindBy(id = "mapdPageNonLis")
	protected WebElement drugcopaytable;

	@FindBy(xpath = ".//*[@id='mapdPageNonLisForSRetail']/div/div[1]/div/div/div/div/table/tbody/tr[2]/td[3]/div")
	protected WebElement tabledynamicdatamapd;

	@FindBy(xpath = ".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr[3]/td[1]/div")
	protected WebElement tabledynamicdatapdp;

	@FindBy(id = "preferredRetailBenefit")
	protected WebElement preferredRetailBenefitTableIndipdp;

	@FindBy(xpath = ".//*[contains(@id,'mapdPageLis')]")
	protected WebElement RetailDrugCost_Table;

	@FindBy(id = "mapdPageNonLisForSRetail")
	protected WebElement RetailDrugCost_TableNONLIS;

	@FindBy(xpath = ".//*[@id='mapdPageLis']")
	protected WebElement RetailDrugCost_Table1; 

	@FindBy(id = "mapdPageNonLisForPMail")
	protected WebElement preferedMail_Table1PDP;

	@FindBy(id = "mapdPageNonLisForSRetail")
	protected WebElement standardDetail_Table1PDP;


	@FindBy(id = "waystosave")
	protected WebElement waysToSave;


	@FindBy(id = "viewTextAtdd")
	protected WebElement view_label;

	@FindBy(xpath = "//h2[contains(text(),'Plan Materials')]")
	protected WebElement documents_label;

	// @FindBy(className = "atdd-benefitsoverview-plantitle")
	@FindBy(xpath = ".//*[@class='h2 margin-none overview-heading atdd-benefitsoverview-plantitle ng-binding']")
	protected WebElement planName2;

	// @FindBy(className = "atdd-benefitsoverview-membernamelabel")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-membernamelabel']")
	protected WebElement nameLabel1;

	// @FindBy(className = "atdd-benefitsoverview-memberidlabel")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-memberidlabel']")
	protected WebElement memberID1;

	// @FindBy(className = "atdd-benefitsoverview-effectivedatelabel")
	@FindBy(xpath = ".//*[contains(@class,'bold atdd-benefitsoverview-effectivedatelabel')]")
	protected WebElement effective_Date;

	@FindBy(xpath = "//*[@class='bold atdd-benefitsoverview-effectivedatelabel']//..//..//div[2]")
	protected WebElement effectivedateValueBNC;


	@FindBy(xpath = ".//*[contains(@class, 'atdd-benefitsoverview-groupidlabel')]")
	protected WebElement GroupId;

	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-extrahelplevel-ma-label ng-binding']")
	protected WebElement ExtraHelp;

	@FindBy(xpath = "//h2[contains(text(),'Benefits Summary')]")
	protected WebElement BenefitsSummaryHeader;

	@FindBy(xpath = "//h2[contains(text(),'Benefits Summary')]")
	protected WebElement BenefitsSummaryHeadership;

	@FindBy(xpath = "//span[contains(text(),'Medical Copays or Coinsurance')]")
	protected WebElement Copayscoinsuranceheader;

	@FindBy(xpath = "//span[@class='subtitle atdd-officevisits-title ng-scope']")
	protected WebElement OfficeVisits;

	@FindBy(className = "atdd-emergencycare-title")
	protected WebElement EmergencyHeader;

	@FindBy(className = "atdd-ambulance-title")
	protected WebElement AmbulanceHeader;

	@FindBy(xpath = "//span[@class='subtitle atdd-hospitalvisits-title']")
	protected WebElement HospitalVisits;

	@FindBy(xpath = "//span[@class='subtitle atdd-outpatientsurgery-title ng-scope']")
	protected WebElement OutpatientSurgeryCenter;

	@FindBy(xpath = "//div[@class='table-body-cell outpatientsurgery-tier1-atdd ng-binding']")
	protected WebElement OutpatientSurgeryCenter2;

	@FindBy(xpath = "//*[@class='outpatientsurgery-atdd ng-binding ng-scope' or @class='table-body-cell outpatientsurgery-tier1-atdd ng-binding']")
	protected WebElement OutpatientSurgeryCenterValue;

	@FindBy(xpath = "//*[@id='officeVisitTileAtdd']/div/div/div[1]/span")
	protected WebElement OfficVisitsValue;

	@FindBy(xpath = "//span[contains(text(),'YOUR PRIMARY CARE PROVIDER')]")
	protected WebElement YourPrimaryCareProvider;

	@FindBy(xpath = "//button[contains(@class,'btn btn--primary changepcp-atdd')]")
	protected WebElement ChangeYourPcpButton;

	@FindBy(xpath = "//a[contains(text(),'SEARCH FOR PROVIDERS')]")
	protected WebElement StartSearch;

	@FindBy(xpath = "//span[contains(text(),'PROVIDER SEARCH')]")
	protected WebElement SearchProvider;

	@FindBy(id = "benefitShipCard")
	protected WebElement ParticipatingHospitalStays1;

	@FindBy(id = "individualPcpHeaderText")
	protected WebElement PrimaryCareProviderHeaderInd;

	@FindBy(xpath = "//*[contains(@class, 'atdd-bncsummary-primarycareprvdrheader')]")
	protected WebElement PrimaryCareProviderHeaderHMO;

	@FindBy(xpath = "//div[@id='groupMapdPpoText' or @id='groupMapdHmoText']")
	protected WebElement PCPtext;

	@FindBy(xpath = "//div[@class='col-md-8 margin-small']//div[@class='benefitsSummary parbase']//h3//span")
	protected WebElement OutofPocketMaximum;

	@FindBy(xpath = "//span[contains(text(),'Out-of-Pocket Maximum')]")
	protected WebElement OutofPocketMaximumText;

	@FindBy(id = "oopInNetowrk")
	protected WebElement INNETWORK;

	@FindBy(id = "oopOutNetowrk")
	protected WebElement OUTOFNETWORK;

	@FindBy(xpath = "//*[contains(text(),'IN-NETWORK')]")
	protected WebElement INNETWORKTEXT;

	@FindBy(xpath = "//*[contains(text(),'OUT-OF-NETWORK')]")
	protected WebElement OUTOFNETWORKTEXT;

	@FindBy(xpath = "//button[@id='dropdown-toggle--1']/span[contains(text(),'Profile')]")
	protected WebElement accountToggleDropdown;

	@FindBy(xpath = "//a[@class='dropdown-option' and contains(text(),'Account Settings')]")
	protected WebElement accountSettingOption;

	@FindBy(className = "atdd-gopaperless")
	protected WebElement gopaperlessbutton;

	@FindBy(className = "atdd-bnc-anclry-disclaimer")
	protected WebElement Exclusivedisclaimer;

	@FindBy(xpath = "//a[contains(text(),'View all additional benefits')]")
	protected WebElement ViewAllAncillaryBnFtLink;

	@FindBy(className = "atdd-exclsvehearing-arrowdwn")
	protected WebElement Disclaimertext;

	@FindBy(xpath = "//a[@class='btn btn--secondary margin-small atdd-bnc-ancilry-learnmorbtn']")
	protected WebElement LearnmoreButton;

	@FindBy(className = "atdd-bnc-exclusivehrng-leavingpopuptxt")
	protected WebElement popup;

	@FindBy(className = "atdd-anclrysection-leavingpopup-proceedbtn")
	protected WebElement ProceedButton;

	@FindBy(className = "atdd-anclrysection-leavingpopup-cancelbtn")
	protected WebElement cancelbutton;

	@FindBy(className = "atdd-exclusivehearing-levngpopup-topcancelbtn")
	protected WebElement cancelbutton1;

	@FindBy(xpath = ".//*[@id='specialDisctServices']/div[1]/img")
	protected WebElement handimage;

	@FindBy(id = "specialDisctServices")
	protected WebElement textdiscountservices;

	// @FindBy(id="drug-benefits")
	@FindBy(xpath = ".//*[contains (text(),'DRUG LOOKUP')]")
	protected WebElement DrugLookUpLink;

	@FindBy(className = "atdd-bnc-discounttitle")
	protected WebElement headerdiscountservices;

	@FindBy(className = "atdd-bnc-discntlearnmorimg")
	protected WebElement learnmorebutton;

	@FindBy(className = "atdd-need-help")
	protected WebElement NeedhelpShip;

	@FindBy(xpath = "//h3[contains(text(),'Technical Support')]")
	protected WebElement TechnicalSupportShip;

	@FindBy(xpath = "//h3[contains(text(),'Technical Support ')]")
	protected WebElement TechnicalSupport;

	@FindBy(xpath = "//h3[contains(text(),'Plan Support')]")
	protected WebElement PlanSupport;

	@FindBy(className = "atdd-general-header")
	protected WebElement GeneralQuestionShip;

	@FindBy(className = "atdd-claims-header")
	protected WebElement ClaimsSupportShip;

	@FindBy(id = "ccs-header")
	protected WebElement catastrophicCoverageStage;

	@FindBy(xpath = "//div/span[@class='bold atdd-benefitsoverview-monthlypremium-label']")
	protected WebElement monthlypremiumlabel;

	@FindBy(how = How.XPATH, using = "//div[@class='PlanPdf section']//ul/li/a[contains(text(),'Medication')]")

	protected WebElement Medicationlinkinpdfsec;

	@FindBy(how = How.XPATH, using = "//div[@class='PlanPdf section']//ul/li/a[contains(text(),'VIEW OTHER')]")
	protected WebElement Viewotherdocsinpdf;

	@FindBy(how = How.XPATH, using = "//div[@class='PlanPdf section']//ul/li/a[contains(text(),'Medication')]")

	protected WebElement Medicationlinkinpdfsecpdp;

	@FindBy(how = How.XPATH, using = "//div[@class='PlanPdf section']//ul/li/a[contains(text(),'VIEW OTHER')]")
	protected WebElement Viewotherdocsinpdfpdp;

	@FindBy(css = "img.img-responsive")
	protected WebElement logoImage;

	@FindBy(xpath = "//*[@class='table-white atdd-bnc-CTgrouptable']")
	protected WebElement hartfortdrugtable;

	@FindBy(className = "atdd-bnc-CTgrouptable")
	protected WebElement GreenwichTable;

	@FindBy(className = "atdd-bnc-pharmacydropdwn")
	protected WebElement pharmacyDropdown;

	@FindBy(id = "Txers-drug-costs")
	protected WebElement pharmacyDropdownTexas;
	@FindBy(className = "atdd-bnc-drugcostsheading")
	protected WebElement drugCostsHeader;

	@FindBy(className = "atdd-bnc-txers-retailcostsharing-table")
	protected WebElement retailTable;

	@FindBy(xpath = "//*[@id='officeVisitTileAtdd']/div//div[1]/span[1]")
	protected WebElement pcpValue;

	@FindBy(xpath = "//*[@id='officeVisitTileAtdd']/div/div/div[2]/span")
	protected WebElement specialistValue;

	@FindBy(xpath="//*[@id='plandeductiblecard1']")
	protected WebElement MedicalDeductibleCard1;

	@FindBy(xpath="//*[@id='plandeductible1AEMvalue']")
	protected WebElement NoDeductible1Text;

	@FindBy(xpath="//*[@id='plandeductible2servicevalue']")
	protected WebElement Deductible2Text;

	@FindBy(xpath="//*[@id='plandeductible1servicevalue']")
	protected WebElement Deductible1Text;

	@FindBy(id = "outPatientTileAtdd")
	protected WebElement outpatientsurgeryVisits;

	@FindBy(id = "hospitalVisitTileAtdd")
	protected WebElement hospitalVisitsSection;

	@FindBy(id = "outPatientTileAtdd")
	protected WebElement OutpatientSurgeryCenterSection;

	@FindBy(id = "outOfPocketTile")
	protected WebElement outOfPocketSection;

	//@FindBy(id = "IN-NETWORK-1")
	@FindBy(xpath = "(//div[@class='outofpocketdme parbase section'])[1]")
	protected WebElement inNetworkSection;

	@FindBy(id = "OUT-OF-NETWORK-1")
	protected WebElement outOfNetworkSection;

	@FindBy(xpath = "//table[@class='table-white atdd-bnc-txers-mailordersharing-table']")
	protected WebElement MailOrderTable;

	@FindBy(xpath = "//*[@class='table-subheader']/td[1]")
	protected List<WebElement> ICStage31to60MailOrder;

	@FindBy(xpath = "//*[@class='table-subheader']/td[2]")
	protected List<WebElement> ICStage61to90MailOrder;

	@FindBy(xpath = ".//*[@class='table-white atdd-bnc-txers-retailcostsharing-table']/tbody/tr[3]/td[2]")
	protected WebElement ICTier1Value;

	@FindBy(xpath = ".//*[@class='table-white atdd-bnc-txers-mailordersharing-table']/tbody/tr[3]/td[1]//div[not(contains(@class,'ng-hide'))]")
	protected WebElement ICTier1ValueMailOrder;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[1]")
	protected List<WebElement> ICStage30dayNonMain;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[2]")
	protected List<WebElement> ICStage30dayMain;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[3]")
	protected List<WebElement> ICStage31to60;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[4]")
	protected List<WebElement> ICStage61to90;

	@FindBy(id = "waystosave")
	protected WebElement waysToSaveSection;

	@FindBy(xpath = "//img[@alt='drugslogo']")
	protected WebElement lowTierdrugs;

	@FindBy(xpath = "//strong[contains(text(),'Lower-tier Drugs')]")
	protected WebElement lowTierdrugsText;

	@FindBy(className = "atdd-bnc-rx187grptable")
	protected WebElement PeehipTable;

	@FindBy(id = "rxcustomgroup_ads-header")
	protected List<WebElement> annualDeductibleColumn;

	@FindBy(id = "rxcustomgroup_ics-header")
	protected List<WebElement> initialCoverageColumn;

	@FindBy(id = "rxcustomgroup_cgp-header")
	protected List<WebElement> coverageGaStageColumn;

	@FindBy(id = "rxcustomgroup_ccs-header")
	protected List<WebElement> catastrophicCoverageStageColumn;

	@FindBy(xpath = "//h1[contains(text(),'Plan Documents & Resources')]")
	protected WebElement docsAndResourcesHeader;

	@FindBy(xpath = "//h1[contains(text(),'Order Plan Materials')]")
	protected WebElement orderMaterialsHeader;

	@FindBy(xpath ="//*[contains(@class,'plan_benefit_documents_forms_amd_resources')]//li[contains(@class,' updateSessionLoopContent else clearfix MAPD_govt_false_71710697_2019')]")
	protected List<WebElement> mapdPdfLinks;

	@FindBy(xpath ="//*[contains(@class,'plan_benefit_documents_forms_amd_resources')]//li[contains(@class,'updateLanguagePdfs_Content clearfix PDP_govt_false_49144037_2019 showElement')]")
	protected List<WebElement> pdpPdfLinks;

	@FindBy(xpath = ".//*[@id='standard_ads-header']/span/p")
	protected WebElement annualDeductibleColumnheader;

	@FindBy(xpath = ".//*[@id='standard_ics-header']/span/p")
	protected WebElement initialCoverageColumnheader;

	@FindBy(xpath = ".//*[@id='standard_cgp-header']/span/p")
	protected WebElement coverageGaStageColumnheader;

	@FindBy(xpath = ".//*[@id='standard_ccs-header']/span/p")
	protected WebElement catastrophicCoverageStageColumnheader;

	@FindBy(id = "submit-order-materials")
	protected WebElement submitOrderBtn;

	@FindBy(id = "notShipRadio")
	protected WebElement radioBtnsSectionNonShip;

	@FindBy(id = "shipRadio")
	protected WebElement radioBtnsSectionShip;

	@FindBy(id = "premiumpayment_3")
	protected WebElement paymentsTab;

	@FindBy(xpath= "//h1[contains(text(), 'Premium Payments')]")
	protected WebElement paymentsHeader;

	@FindBy(xpath= "//*[contains(@class,'card')]//*[contains(@dtmid,'cta_ordermaterials')]")
	protected WebElement planDocsAndResourcesBtn;

	@FindBy(xpath = "//table[@class='table-white atdd-bnc-rx187grptable']/tbody/tr[2]/td[3]/div[1]")
	protected WebElement PeehipTier1ValueIC;
	@FindBy(xpath = "//table[@class='table-white atdd-bnc-rx187grptable']/tbody/tr[2]/td[4]/div[1]")
	protected WebElement PeehipTier1ValueCG;
	@FindBy(xpath = "//table[@class='table-white atdd-bnc-rx187grptable']/tbody/tr[5]/td[3]")
	protected List<WebElement> PeehipTier1ValueCC;

	@FindBy(xpath = "//img[@alt=' walgreenpharmacylogo']")
	protected WebElement wallGreensWidget;

	@FindBy(xpath = "//p[contains(text(),'Walgreens Preferred Retail Pharmacy')]")
	protected WebElement wallGreensWidgetText;

	@FindBy(xpath = "//img[@alt='mailservicelogo']")
	protected WebElement PreferredMailServicePharmacyLogo;

	@FindBy(xpath = "//img[@alt='retailpharmacylogo']")
	protected WebElement retailpharmacylogo;


	@FindBy(xpath = "(//p[contains(text(),'Preferred Mail Service Pharmacy')])[3]")
	protected WebElement PreferredMailServicePharmacyText;

	@FindBy(xpath = "(//p[contains(text(),' Preferred Retail Pharmacy')])[1]")
	protected WebElement PreferredRetailPharmacyText;

	@FindBy(xpath = "//img[@alt='mailservicelogo']/parent::div/following-sibling::div/p")
	protected WebElement mailOrderWidget;

	@FindBy(xpath = "//a[contains(text(),'VIEW PLAN DOCUMENTS')]")
	protected WebElement viewPlanDocsBtn;

	//@FindBy(id = "waystosave")
	@FindBy(xpath="//div[@id='waystosave']")
	protected List<WebElement> waysToSaveSectionvalidate;

	@FindBy(xpath = "//*[contains(@class,'atdd-benefitssummary-plnbnftdcmnt-title')]")
	protected WebElement planDocumentsTitle;

	@FindBy(id = "lang-select-2")
	protected WebElement planDocumentsLangDropdown;

	@FindBy(xpath = "//*[contains(@class, 'document-list-new margin-none')]//*[contains(text(),'VIEW OTHER DOCUMENTS')]")
	protected WebElement viewDocsAndResourcesLink;

	@FindBy(xpath = "//*[contains(@class, 'document-list-new margin-none')]//*[contains(text(),'View other documents')]")
	protected WebElement viewDocsAndResourcesLinkShip;

	@FindBy(id = "benefitsSummary")
	protected WebElement benefitsSummarySection;

	@FindBy(id = "formsandresourcesC1")
	protected WebElement formsAndResourcesTab;

	@FindBy(id = "needhelpsectioncontactus")
	protected WebElement needHelpSection;

	@FindBy(xpath= "//*[contains(@class, 'h2 margin-none overview-heading atdd-benefitsoverview-plantitle ng-binding')]")
	protected WebElement planName;

	@FindBy(xpath = "//*[contains(@class, 'bold atdd-benefitsoverview-membernamelabel')]")
	protected WebElement nameLabel;

	@FindBy(xpath = "//span[@class='bold atdd-benefitsoverview-membernamelabel']//..//..//div[2]")
	protected WebElement memberNameValueBNC;

	@FindBy(xpath = "//*[contains(@class, 'bold atdd-benefitsoverview-memberidlabel')]")
	protected WebElement memberID;

	@FindBy(xpath = "//span[@class='bold atdd-benefitsoverview-memberidlabel']//..//..//div[2]")
	protected WebElement memberIdValueBNC;


	@FindBy(xpath = "//span[@class='bold atdd-benefitsoverview-effectivedatelabel']")
	protected WebElement effective_Date1;

	@FindBy(className = "atdd-benefitsoverview-monthlypremium-label")
	protected WebElement Monthly_Premium;

	@FindBy(className = "atdd-benefitsoverview-lateenrollmentwithout-plancategoryid-label")
	// @FindBy(xpath="//*[contains(text(),'Late Enrollment Penalty')]or
	// @class='atdd-benefitsoverview-lateenrollmentwithout-plancategoryid-label'")
	protected WebElement LEPAmount;

	// @FindBy(xpath="(//*[contains(text(),'Member Name')]) ")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-membernamelabel']")
	protected WebElement MemberName;

	// @FindBy(xpath="(//*[contains(text(),'Member ID')]) ")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-memberidlabel']")
	protected WebElement MemberId;

	// @FindBy(xpath="(//*[contains(text(),'Effective Date')])")
	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-effectivedatelabel']")
	protected WebElement EffectiveDate;

	@FindBy(className = "atdd-tech-header")
	protected WebElement techSupportHeader;

	@FindBy(className = "atdd-plan-header")
	protected WebElement planSupportHeader;

	@FindBy(xpath = "(//img[@alt='CoLogo'])[1]")
	protected WebElement cologoImage;

	@FindBy(xpath = "//*[contains(@class, 'table-white atdd-bnc-standrdretailpharmcytable')]")
	protected WebElement drugTableNonLisMember;

	@FindBy(id = "standard_ads-header")
	protected List<WebElement> annualDeductibleColumnFederal;

	@FindBy(id = "standard_ics-header")
	protected List<WebElement> initialCoverageColumnFederal;

	@FindBy(id = "standard_cgp-header")
	protected List<WebElement> coverageGaStageColumnFederal;

	@FindBy(id = "standard_ccs-header")
	protected List<WebElement> catastrophicCoverageStageColumnFederal;

	@FindBy(xpath = "//table/tbody/tr[2]/td[2]/div[1]")
	protected WebElement federalValueIC;

	@FindBy(xpath = "//div[@class='tabs-desktop']/ul[@class='nav nav-tabs']/li")
	protected List<WebElement> tabsForComboMember;

	@FindBy(xpath = "//*[@class='table-body']/div[2]/div[2]")
	protected WebElement memberIdForPlan;

	@FindBy(xpath = "//*[@class='claims section']")
	protected WebElement shipClaimsSupportHeader;

	@FindBy(className = "drugCopaysAndDiscounts")
	protected WebElement drugCopaysAndDiscount;

	@FindBy(xpath = "//*[contains(@class, 'drugCoPaysDiscountsParsys parsys')]")
	protected WebElement drugCopaysAndDiscountSection;

	@FindBy(id = "available-riders")
	protected WebElement addRiderSection;

	@FindBy(xpath = "//button[@class='btn btn--primary add-rider-button']")
	protected List<WebElement> addRiderButton;

	@FindBy(id = "addBenefitModal")
	protected WebElement addBenefitPopup;

	@FindBy(xpath = ".//input[@class='btn btn--primary btn_addRider_atdd']")
	protected WebElement addRiderButtonOnPopup;

	@FindBy(xpath = "//span[@class='btn btn--secondary remove-rider-button']")
	protected WebElement removeRiderButton;

	@FindBy(id = "removeBenefitModal")
	protected WebElement removeRiderPopup;

	@FindBy(xpath = "//input[@class='btn btn--primary btn_removeRider_atdd']")
	protected WebElement removeRiderButtonOnPopup;

	//backtotop
	@FindBy(xpath = "//div[contains(@class,'backToTop') and not(contains(@style,'none'))]//a/span/p[contains(text(),'Back To Top')]")
	protected WebElement linkBackToTop;

	@FindBy(xpath = "(//*[@id='backToTopContainer']/a/span/p)[2]")
	protected WebElement linkBackToTop_copy;

	//MAPD_UHC jump links
	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*/li[1]/a[contains(text(),'Medical Copays or Coinsurance')]")
	protected WebElement jmpLinkToMedicalCopaysOrCoinsurance;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*/li[2]/a[contains(text(),'Out-of-Pocket Maximum')]")
	protected WebElement jmpLinkToOutofPocketMaximum;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*/li[3]/a[contains(text(),'Primary Care Provider')]")
	protected WebElement jmpLinkToPrimaryCareProvider;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*/li[5]/a[contains(text(),'Drug Copays & Discounts')]")
	protected WebElement jmpLinkToDrugCopaysAndDiscounts;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*/li[6]/a[contains(text(),'Drug Coverage')]")
	protected WebElement jmpLinkToDrugCoverage;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*/li[7]/a[contains(text(),'Plan Materials')]")
	protected WebElement jmpLinkToPlanDocumentsAndResources;

	// MA user
	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*/div[6]//*/ul/li[4]/a")
	protected WebElement jmpLinkToPlanDocumentsAndResourcesMA;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[2]//*/div[2]//*/div[2]//*/div[6]//*/ul/li[1]/a")
	protected WebElement jmpLinkToMedicalCopaysOrCoinsuranceMA;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[2]//*/div[2]/div/div[2]/div/div[6]//*/ul/li[2]/a")
	protected WebElement jmpLinkToOutofPocketMaximumMA;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[2]//*/div[2]//*/div[2]//*/div[6]//*/ul/li[3]/a")
	protected WebElement jmpLinkToPrimaryCareProviderMA;

	@FindBy(xpath = "//*[@class='jumplinks']//ul/li[4]")
	protected WebElement jmpLinkToPlanDocumentsAndResourcesMAGroup;

	@FindBy(xpath = "//*[@class='jumplinks']//ul/li[1]")
	protected WebElement jmpLinkToMedicalCopaysOrCoinsuranceMAGroup;

	@FindBy(xpath = "//*[@class='jumplinks']//ul/li[2]")
	protected WebElement jmpLinkToOutofPocketMaximumMAGroup;

	@FindBy(xpath = "//*[@class='jumplinks']//ul/li[3]")
	protected WebElement jmpLinkToPrimaryCareProviderMAGroup;

	@FindBy(xpath = "(//*[@id='benefits-quickLinksParsys']//*/li[4]/a)[1]")
	protected WebElement jmpLinkToOptionalServicesRiders;

	@FindBy(xpath = "(//*[contains(text(),'Out-of-Pocket Maximum')])[2]")
	protected WebElement outOfPocketSectionHeader;

	@FindBy(xpath = "//*[@id='drug-benefits']//*/h2")
	protected WebElement DrugCopaysAndDiscountsSectionHeader;

	@FindBy(xpath = "//*[@id='drugCoverage']//*/span")
	protected WebElement DrugCoverageSectionHeader;

	@FindBy(xpath = "//*[@id='plan_benefit_documents']//*/h2")
	protected WebElement PlanDocumentsAndResourcesSectionHeader;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*[@class='jumplinks']//li[not(contains(@style,'none'))]")
	protected List<WebElement> directorySection;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[1]//ul//li")
	protected List<WebElement> directorySectionMedSupp;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[2]//*/div[2]/div/div[2]/div/div[4]//*/ul/li[not(contains(@style,'none'))]")
	protected List<WebElement> directorySectionPDP;

	@FindBy(xpath = "//*[@id='avail-riders']//*/h2")
	protected WebElement OptionalServicesRidersSectionHeader;            

	@FindBy(xpath = "(//*[@id='benefits-quickLinksParsys']//*/li[5]/a)[1]")
	protected WebElement jmpLinkToOptionalServicesRidersMA;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[1]//ul//li[1]")
	protected WebElement jmpLinkToBenefitSummaryMedSupp;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[1]//ul//li[2]")
	protected WebElement jmpLinkToDiscountsAndServicesMedSupp;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[1]//ul//li[3]")
	protected WebElement jmpLinkToPlanDocumentsAndResourcesMedSupp;

	@FindBy(xpath = "//*[@id='benefitsSummary']/div[1]//*/section/div[1]/div/h2")
	protected WebElement benefitsSummarySectionHeader;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[1]//ul/li[1]")
	protected WebElement jmpLinkToDrugCopaysAndDiscountsPDP;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[1]//ul/li[2]")
	protected WebElement jmpLinkToDrugCoveragePDP;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[1]//ul/li[3]")
	protected WebElement jmpLinkToPlanDocumentsAndResourcesPDP;

	@FindBy(xpath = "//*[@class='jumplinks']//li[1]")
	protected WebElement jmpLinkToDrugCopaysAndDiscountsPDPUHC;

	@FindBy(xpath = "//*[@class='jumplinks']//li[2]")
	protected WebElement jmpLinkToPlanDocumentsAndResourcesPDPUHC;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[1]//ul/li[4]")
	protected WebElement jmpLinkToWaysToSaveMoneyPDP;

	@FindBy(xpath = "//*[@id=\"waystosave\"]//*/h2")
	protected WebElement waysToSaveMoneySectionHeader;

	@FindBy(xpath = "//*[@id='benefits-benefits-quickLinksParsys']/div[2]//*/div[2]//*/div[8]//*/ul/li[4]/a")
	protected WebElement jmpLinkToadditionalBenefits;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/div[2]//div[2]/div/div[8]//ul/li[6]/a")
	protected WebElement jmpLinkToPlanDocumentsAndResourcesMAPDGroup;

	@FindBy(xpath = "//*[@id='ancillary']/div/div/div/div/div/div[1]/div/h4")
	protected WebElement additionalBenefitsSectionHeader;

	@FindBy(xpath = "//*[(@id='primary-care-provider-atdd') or (@id='individualPcpHeaderText')]")
	protected WebElement primaryCareProviderSectionHeaderGroup;

	@FindBy(xpath = "//*[contains(@id,'ordermaterials')]")
	protected WebElement orderMaterialsTab;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']/*//div/div[8]/div/div/div/div/ul/li")
	protected List<WebElement> directorySectionMAPDGroup;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*/div[2]//*/ul/li[1]/a")
	protected WebElement jmpLinkToMedicalCopaysOrCoinsuranceSSUP;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*/div[2]//*/ul/li[2]/a")
	protected WebElement jmpLinkToOutofPocketMaximumSSUP;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*/div[2]//*/ul/li[3]/a")
	protected WebElement jmpLinkToPrimaryCareProviderSSUP;

	@FindBy(xpath = "//*[@id='benefits-quickLinksParsys']//*/div[2]//*/ul/li[4]/a")
	protected WebElement jmpLinkToPlanDocumentsAndResourcesSSUP;

	@FindBy(xpath = "(//*[@class='PlanPdf section'])[2]//span[@class='document-list-new margin-none']//li[@class=' clearfix']//span[@class='ng-binding ng-scope'][2]")
	protected WebElement PDFUpdatedText;

	//note: add to support SSUP
	@FindBy(xpath="//h4[@class='h4 margin-extra-small atdd-benefitssummary-exclusivehearing']")
	protected WebElement ssupExclusiveHearingSavings;

	@FindBy(xpath="//*[@class='subtitle atdd-benefitssummary-vision']")
	protected WebElement ssupVision;

	@FindBy(xpath="//*[@class='subtitle atdd-benefitssummary-dental']")
	protected WebElement ssupDental;

	@FindBy(xpath="//a[@class='siteLeavingPopup']/parent::p/parent::div")
	protected WebElement accessDrugsBenfitsBlock;

	@FindBy(xpath="//a[@class='siteLeavingPopup']/parent::p/parent::div/h3")
	protected WebElement accessDrugsBenfitsBlockHeader;

	@FindBy(xpath="//a[@class='siteLeavingPopup']/parent::p/a")
	protected WebElement accessDrugsBenfitsBlockExpressScriptsLink;

	@FindBy(css="div.siteleaving-popup-footer>div")
	protected WebElement siteLeavingPopUp;

	@FindBy(css="div.siteleaving-popup-footer a#cancelbtn")
	protected WebElement siteLeavingPopUpCancelBtn;

	@FindBy(css="div.siteleaving-popup-footer a#proceedbtn")
	protected WebElement siteLeavingPopUpProceedBtn;

	@FindBy(xpath= "//*[@id='pcpCard2']/div/a")
	protected WebElement providersearchlink;

	@FindBy(xpath= "//p[contains(text(),'Preferred Retail Pharmacy Drug Costs')]")
	protected WebElement PreferredRetailPharmacyDrugCostsText;

	@FindBy(xpath= "//p[contains(text(),'Preferred Retail Pharmacy Drug Costs')]//..//p[2]")
	protected WebElement PreferredRetailPharmacyDrugCostsTextLine;

	@FindBy(xpath= "//p[contains(text(),'Preferred Retail Pharmacy Drug Costs')]//..//p[2]")
	protected WebElement PreferredRetailPharmacyDrugCostsTextLinePDP;

	@FindBy(xpath= "//p[contains(text(),'Preferred Mail Service Pharmacy Drug Costs')]")
	protected WebElement PreferredMailServicePharmacyDrugCostsText;

	@FindBy(xpath= "//p[contains(text(),'Preferred Mail Service Pharmacy Drug Costs')]//..//p[2]")
	protected WebElement PreferredMailServicePharmacyDrugCostsTextLine;

	@FindBy(xpath= "//p[contains(text(),'Preferred Mail Service Pharmacy Drug Costs')]//..//p[2]")
	protected WebElement PreferredMailServicePharmacyDrugCostsTextLinePDP;

	@FindBy(xpath= "//p[contains(text(),'Standard Network Pharmacy Retail Drug Costs')]")
	protected WebElement StandardNetworkPharmacyRetailDrugCostsText;

	@FindBy(xpath= "//p[contains(text(),'Standard Network Pharmacy Retail Drug Costs')]//..//p[2]")
	protected WebElement StandardNetworkPharmacyRetailDrugCostsTextLine;

	@FindBy(xpath= "//p[contains(text(),'Standard Network Pharmacy Retail Drug Costs')]//..//p[2]")
	protected WebElement StandardNetworkPharmacyRetailDrugCostsTextLinePDP;

	@FindBy(xpath= "//p[contains(text(),'Standard Network Pharmacy Retail Drug Costs')]//..//p[2]")
	protected WebElement StandardNetworkPharmacyRetailDrugCostsTextLineVellage;

	@FindBy(id= "officeVisitTileAtdd")
	protected WebElement officeVisitSection;

	@FindBy(id= "hospitalVisitTileAtdd")
	protected WebElement hospitalVisitSection;

	@FindBy(id= "outPatientTileAtdd")
	protected WebElement outPatientSection;

	@FindBy(xpath= "(//div[@class='outofpocketdme parbase section'])[2]")
	protected WebElement outNetworkSection;

	@FindBy(xpath= "//h2[contains(text(),'Prescription Drug Costs')]")
	protected WebElement PrescriptionDrugCostsrkSectionHeaderONRally;

	@FindBy(xpath= "(//a[contains(text(),'View all benefits')])[1]")
	protected WebElement ViewAllBenefitsLinkONRally;

	@FindBy(xpath= "(//*[contains(@class,'planBenefitDocumentsContainer')]/div[2]//*[contains(@class,'PlanPdf section')][1]//li[2]/a")
	protected WebElement pdfLink1;

	@FindBy(xpath= "(//*[contains(@class,'planBenefitDocumentsContainer')]/div[2]//*[contains(@class,'PlanPdf section')][2]//li[2]/a")
	protected WebElement pdfLink2;

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
	
	@FindBy(xpath="//p[contains(@class,'siteleaving')]")
	protected WebElement siteLeavingPopup;
	
	@FindBy(xpath="//a[contains(@id,'proceedbtn')]")
	protected WebElement siteLeavingPopup_proceedBtn;

	@FindBy(xpath="//a[contains(@id,'cancelbtn')]")
	protected WebElement siteLeavingPopup_cancelBtn;

	@FindBy(xpath="//h1")
	protected WebElement generalPgHeader;
	
	@FindBy(linkText = "Express Scripts")
	protected WebElement expressScriptsLink;
	
	@FindBy(xpath = "//h3[contains(text(),'Access your Drug Benefits')]")
	protected WebElement accessYourDrugBenefitsHeader;	
	
	@FindBy(id = "proceedbtn")
	protected WebElement proceedButtonExpressScriptsSSOSiteLeavingPopup;
	
	@FindBy(xpath = "//div[@class='intlogo']")
	protected WebElement ExpressScriptsLogo;

	@FindBy(xpath = "//a[@id='intlogo']")
	protected WebElement ExpressScriptsLogoPROD;
	
	@FindBy(xpath = "//h1")
	protected WebElement BenefitsInformationHeaderOptumRx;
	
	@FindBy(xpath = "//h1")
	protected WebElement searchForADrugHeaderOptumRx;
	
	@FindBy(linkText = "VIEW YOUR CURRENT PRESCRIPTION DRUG COST SUMMARY AT OPTUMRX.COM")
	protected WebElement viewYourCurrentPrescriptionDrugCostSummaryLink;

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

	@FindBy(xpath = "//*[@class='tabs-desktop']//a[contains(.,'Medicare Supplement Insurance Plan')]")
	protected WebElement ShipTab;
	
	@FindBy(xpath = "//*[@class='tabs-desktop']//a[contains(.,'Senior Supplement Plan')]")
	protected WebElement SSUPTab;

	
	public BenefitsAndCoverageWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void openAndValidate() throws InterruptedException {
	}

}
