/**
 * 
 */
package pages.regression.benefitandcoverage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.member.bluelayer.ProfilePreferencesPage;
import pages.regression.benefitandcoverage.ValueAddedServicepage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
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

	@FindBy(className = "atdd-needhelp-disclaimer-text")
	private WebElement moreinformation;

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

	@FindBy(className = "atdd-bnc-lookupdrugs-info")
	private WebElement LookupDrugstext;

	@FindBy(className = "atdd-bnc-lookupdrugbtn")
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

	@FindBy(className = "atdd-bnc-drgpricingtiers")
	private WebElement Learnmoretierslink;

	@FindBy(className = "atdd-bnc-drgstgtiers")
	private WebElement Learnmorestagelink;

	    @FindBy(className = "atdd-bnc-locatephrmcy-info")
		//@FindBy(xpath=".//*[contains (text(),'PHARMACY LOCATOR')]")
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

@FindBy(xpath = "(//div[@id='plan_benefit_documents']/section[2]//ul/li[not (contains(@class,'ng-hide'))])[1]")
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

	@FindBy(className = "atdd-benefitsoverview-groupidlabel")
	private WebElement GroupId;

	@FindBy(xpath = ".//*[@class='bold atdd-benefitsoverview-extrahelplevel-ma-label ng-binding']")
	private WebElement ExtraHelp;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[1]/div/div/h1")
	private WebElement BenefitsSummaryHeader;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[1]/div/h1")
	private WebElement BenefitsSummaryHeadership;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[2]/div/div/div[1]/div/h3/b/span")
	private WebElement Copayscoinsuranceheader;

	@FindBy(className = "atdd-officevisits-title")
	private WebElement OfficeVisits;

	@FindBy(className = "atdd-emergencycare-title")
	private WebElement EmergencyHeader;

	@FindBy(className = "atdd-ambulance-title")
	private WebElement AmbulanceHeader;

	@FindBy(className = "atdd-hospitalvisits-title")
	private WebElement HospitalVisits;

	@FindBy(className = "atdd-outpatientsurgery-title")
	private WebElement OutpatientSurgeryCenter;
	
	@FindBy(className = "outpatientsurgery-tier1-atdd")
	private WebElement OutpatientSurgeryCenter2;
	
    @FindBy(xpath = ".//*[@id='outPatientTileAtdd']/div/div")
	private WebElement OutpatientSurgeryCenterValue;

	@FindBy(xpath = ".//*[@id='officeVisitTileAtdd']/div/section/div[1]/span")
	private WebElement OfficVisitsValue;

	@FindBy(id = "pcpCard")
	private WebElement YourPrimaryCareProvider;

	@FindBy(className = "changepcp-atdd")
	private WebElement ChangeYourPcpButton;

	@FindBy(id = "pcpCard2")
	private WebElement SearchProvider;

	@FindBy(className = "start-search-atdd")
	private WebElement StartSearch;

	@FindBy(id = "benefitShipCard")
	private WebElement ParticipatingHospitalStays1;

	@FindBy(id = "individualPcpHeaderText")
	private WebElement PrimaryCareProviderHeaderInd;

	@FindBy(className = "atdd-bncsummary-primarycareprvdrheader")
	private WebElement PrimaryCareProviderHeaderHMO;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[6]/div/div/div/p")
	private WebElement PCPtext;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[5]/div/div[1]/div/div/div/div/h3/span")
	private WebElement OutofPocketMaximum;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[5]/div/div[1]/div/div/div/div/p")
	private WebElement OutofPocketMaximumText;

	@FindBy(id = "oopInNetowrk")
	private WebElement INNETWORK;

	@FindBy(id = "oopOutNetowrk")
	private WebElement OUTOFNETWORK;

	@FindBy(xpath = ".//*[@id='oopInNetowrk']/section/div/h1")
	private WebElement INNETWORKTEXT;

	@FindBy(xpath = ".//*[@id='oopOutNetowrk']/section/div/h1")
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

	@FindBy(className = "atdd-tech-header")
	private WebElement TechnicalSupport;

	@FindBy(className = "atdd-plan-header")
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

	@FindBy(xpath = ".//*[@id='officeVisitTileAtdd']/div/section/div[1]/span")
	private WebElement pcpValue;

	@FindBy(xpath = "//*[@id='officeVisitTileAtdd']/div/section/span")
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

	@FindBy(className = "atdd-outnetwrktitle")
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

	@FindBy(className = "atdd-benefitsoverview-memberidlabel")
	private WebElement memberID;

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
		// openAndValidate();
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

	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : benefitsCoverage.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(benefitsCoverage.getExpectedData().get(key));
			/*
			 * if (elements.size() == 1) { validate(elements.get(0)); try {
			 * jsonObject.put(key, elements.get(0).getText());
			 * //System.out.println("Text"+elements.get(0).getText()); } catch
			 * (JSONException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } else if (elements.size() > 1) {
			 */
			JSONArray jsonArray = new JSONArray();
			for (WebElement element : elements) {

				// validate(element);
				try {
					JSONObject jsonObjectForArray = new JSONObject();
					jsonObjectForArray.put(benefitsCoverage.getExpectedData().get(key).getElementName(),
							element.getText());
					jsonArray.put(jsonObjectForArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				jsonObject.put(key, jsonArray);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		benefitsandcoverageJson = jsonObject;

		System.out.println("BenefitsCoverageJson----->" + benefitsandcoverageJson);

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
		validate(NeedHelpHeader);
		validate(TechnicalSupport);
		validate(PlanSupport);
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
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Contactussection.getText().contains("See more ways to contact us")) {
			System.out.println("contactus section is coming ");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Contactussection.getText() >>>>>>" + Contactussection.getText());
		}

	}

	/**
	 * @toDo : The user validates the Contact us link in Need help section
	 */
	public void contactUslink() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(contactUslink);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		if (contactUslink.isEnabled()) {
			contactUslink.click();
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue(driver.getCurrentUrl().contains("contact-us/overview.html"));
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		validate(moreinformation);
		moreinformation.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnmoreinformationship() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validate(moreinformation);
		moreinformation.click();
	}

	/**
	 * @toDo : The user checks the view label in Documents section
	 */
	public boolean getview_label() {
		return validate(view_label);
	}

	/**
	 * @toDo : The user checks the get Document label in Documents section
	 */
	public boolean getdocuments_label() {
		return validate(documents_label);
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
				Assert.assertTrue(true);
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
		validate(DrugCoverageHeader);
		validate(DrugCoveragetext);
	}
	
	/**
	 * @toDo : The user validates the DrugCoverage section headers and text for group
	 */
	public void validatedrugcoverageheaderandtextgroup() {
	
		if(DrugCoverageHeader.isDisplayed())
		{
			Assert.fail("Drug coverage should not display");
		}
		else
		{
			Assert.assertTrue(true);
		}
		if(DrugCoveragetext.isDisplayed())
		{
			Assert.fail("Drug coverage should not display");
		}
		else
		{
			Assert.assertTrue(true);
		}
		
	}

	/**
	 * @toDo : Validates Look Up Drugs button in the DrugCosts section
	 */
	public void validatelookupdrugsbutton(String plantype) 
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
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("drug-lookup/overview.html"))
			Assert.assertTrue(true);
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
			Thread.sleep(30000);
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
		validate(LookupDrugstext);

	}

	/**
	 * @toDo : Validates the headers in DrugCopays and Discount section
	 */
	public void validate_drugcopayheaderntext() {
		validate(DrugCopayHeader);
		validate(DrugCopayText);

	}

	/**
	 * @toDo : Validates the Drug Cost header and text
	 */

	public void validate_drugcostheaderntext() {
		validate(DrugCostheaderandtext);

	}
	
	public void validate_locatepharmacy() {
		validate(locateapharmacysection);
		validate(locateapharmacybutton);
		System.out.println("*******Pharmacy locator button is seen ==>"+locateapharmacybutton.isDisplayed());

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
			Assert.assertTrue(true);
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
		validate(DrugCostDropdown);
		validate(DrugCostHeader);

		if (DrugCostDropdown.isDisplayed()) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) { // TODO Auto-generated catch
												// block
				e1.printStackTrace();
			}
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

	}

	/**
	 * @toDo : Validates the Learn More links for a Non Lis member
	 */

	public void validate_learnmoreaboutlink() {
		validate(Learnmoretierslink);
		validate(Learnmorestagelink);
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
	 * @toDo : Validates that the learnmore tier link
	 */

	public void clickOnLearnmoreaboutlinktier() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Learnmoretierslink.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Learnmoretierslink.click();

	}

	/**
	 * @toDo : Validates that the learnmore stage link
	 */

	public void clickOnLearnmoreaboutlinkstage() {
		// TODO Auto-generated method stub
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
		validate(planName);
		validate(nameLabel);
		validate(memberID);
		validate(effective_Date);
		validate(monthlypremiumlabel);
		System.out.println(driver
				.findElement(By.xpath(".//*[@id='planBenefitsAppSum']/section/div/div[4]/div[1]/div/div[1]/div[2]"))
				.getText());

		Assert.assertEquals(driver
				.findElement(By.xpath(".//*[@id='planBenefitsAppSum']/section/div/div[4]/div[1]/div/div[1]/div[2]"))
				.getText(), name);
		Assert.assertEquals(driver
				.findElement(By.xpath(".//*[@id='planBenefitsAppSum']/section/div/div[4]/div[1]/div/div[2]/div[2]"))
				.getText(), memberid);
		Assert.assertEquals(driver
				.findElement(By.xpath(".//*[@id='planBenefitsAppSum']/section/div/div[4]/div[1]/div/div[4]/div[2]"))
				.getText(), effectivedate);

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

		validate(BenefitsSummaryHeader);
		validate(Copayscoinsuranceheader);
		validate(HospitalVisits);
		validate(OfficeVisits);
		validate(OutpatientSurgeryCenter);
		validate(OutpatientSurgeryCenterValue);
		validate(OfficVisitsValue);

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

		validate(PrimaryCareProviderHeaderInd);
		validate(YourPrimaryCareProvider);
		if (Addaprovider.isDisplayed()) {

			validate(Addaprovider);

			Addaprovider.click();
		} else {
			validate(ChangeYourPcpButton);
			ChangeYourPcpButton.click();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("/member/contact-us")) {
			Assert.assertTrue(true);
		} else {
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

		validate(SearchProvider);
		validate(StartSearch);
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
		validate(OutofPocketMaximum);
		validate(INNETWORK);
		validate(OUTOFNETWORK);
		validate(OutofPocketMaximumText);
		validate(INNETWORKTEXT);
		validate(OUTOFNETWORKTEXT);
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
			Thread.sleep(30000);
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
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
        else if(langdropdwn.getFirstSelectedOption().getText().contains("SPANISH"))
        {
        	
        	List<WebElement> pdfs = driver.findElements(By.xpath(".//*[@class='PlanPdf section']/div[1]/div[1]/div[2]/span/div/ul/li[2]/a"));
    		
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
        else if(langdropdwn.getFirstSelectedOption().getText().contains("CHINESE"))
        {
        	System.out.println("NO PDFs in chinese yet.if PDFs come then above same code can be used");
        	checkflag = true;
        }
		
		
           return checkflag;
          
    }

			



	public void validatestaticlinksinpdf(String plantype) {
		validate(Medicationlinkinpdfsec);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Medicationlinkinpdfsec.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("/documents/medication-program")) {
			System.out.println(driver.getCurrentUrl());
			Assert.assertTrue(true);
		} else {
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
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		validate(Viewotherdocsinpdf);
		Viewotherdocsinpdf.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("/member/documents/overview.html")) {
			System.out.println(driver.getCurrentUrl());
			Assert.assertTrue(true);
		} else {
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
	else
	{
		Assert.fail();
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

 public void grouptabledynamicdata()
 {
    Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[2]/td[3]")).getText(),"$10.00");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[2]/td[4]")).getText(),"$10.00");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[2]/td[5]")).getText(),"$10.00");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[3]/td[1]")).getText(),"$20.00");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[3]/td[2]")).getText(),"$20.00");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[3]/td[3]")).getText(),"$20.00");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[4]/td[1]")).getText(),"$35.00");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[4]/td[2]")).getText(),"$35.00");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[4]/td[3]")).getText(),"$35.00");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[5]/td[1]")).getText(),"25%");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[5]/td[2]")).getText(),"25%");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[5]/td[3]")).getText(),"25%");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[2]/td[2]")).getText(),"No Deductible");
	System.out.println(annualDeductibleColumn.size() + initialCoverageColumn.size() + coverageGaStageColumn.size()
			+ catastrophicCoverageStageColumn.size());
	if (annualDeductibleColumn.size() > 0 && initialCoverageColumn.size() > 0 && coverageGaStageColumn.size() > 0
			&& catastrophicCoverageStageColumn.size() > 0) {
		Assert.assertTrue("The columns are correct in Peehip table", true);

	} else {
		Assert.assertFalse("The columns are incorrect in Peehip table", true);
	}
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[2]/th")).getText(),"Tier 1 ");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[3]/th")).getText(),"Tier 2 ");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[4]/th")).getText(),"Tier 3 ");
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='drug-benefits']/div[5]/div[4]/div/div[1]/div/div/table/tbody/tr[5]/th")).getText(),"Tier 4 ");
	
}
 
public void validateImagePresent(String logoToBeDisplayedOnSecondaryPage) {
	
	String logo_src = logoImage.getAttribute("src");
	String logo_alt = logoImage.getAttribute("alt");
	System.out.println("Actual logo's source on Dashboard page is   "+logo_src+" and Expected logo source is  "+logoToBeDisplayedOnSecondaryPage+" . ");		
	System.out.println("logo's alt text on secondary page is   "+logo_alt);	
	Assert.assertTrue(logo_src.contains(logoToBeDisplayedOnSecondaryPage));
	System.out.println("Secondary page main logo assert condition is passed");	
}

		

	public void validateCoLogoImagePresent(String cologoToBeDisplayedOnSecondaryPage) {

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

}
