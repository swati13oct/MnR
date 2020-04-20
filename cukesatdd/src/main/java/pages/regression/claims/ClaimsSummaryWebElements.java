package pages.regression.claims;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** WebElements for Claims Summary page */
public class ClaimsSummaryWebElements extends ClaimsBase {

	public ClaimsSummaryWebElements(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openAndValidate() throws InterruptedException {
	}

	@FindBy(xpath="//a[contains(text(),'My Claims')]")
	protected WebElement claimsTabTopMenu;

	@FindBy(xpath="//a[contains(text(),'Premium Payments')]")
	protected WebElement pymtTabTopMenu;

	@FindBy (xpath = ".//*[@id='errorMsg']/div/p")
	protected WebElement rxErrMsg;

	@FindBy(xpath = "//div[@class='claim-results']//table[not (contains(@class,'ng-hide'))]//tbody//tr[2]//a[text()='MORE INFO']")
	protected WebElement claimsTblMoreInfoLnk;

	@FindBy(css = ".claimDetTableMainSection")
	protected WebElement claimsDetlTblMainSect;

	@FindBy(xpath="//button[@id='all-claims-print-claims-btn']")
	protected WebElement claimsSummPrntBtn;

	@FindBy(xpath="//a[contains(text(),'Explanation of Benefits')]")
	protected WebElement eob_claims;

	@FindBy(xpath="//h1[contains(text(),'Explanation of Benefits')]")
	protected WebElement eob_header;

	@FindBy(xpath="//p[contains(text(),'EOBs for your plan are currently not available on this site. We apologize for the inconvenience.')]")
	protected WebElement eob_errMsg;

	@FindBy(xpath ="//*[@id='atddUhcPagination']/li[3]/a")
	protected WebElement paginationRtArrow;

	@FindBy(xpath =".//*[@id='dateCustomSearchAtdd']")
	protected WebElement custSrch;

	@FindBy(xpath = ".//*[@id='claim-type']/option[2]")
	protected WebElement PrescriptionDrug;

	@FindBy(xpath = "//div[contains(@class,'shipCompSection')]//select[@name='document-date']")
	protected WebElement ship_claimsDropdown;	

	@FindBy(xpath = "//div[contains(@class,'fedCompSection')]//select[@name='document-date']")
	protected WebElement fed_claimsDropdown;	

	@FindBy(xpath="//div[@id='tableAtddFed']//div[contains(text(),'Prescription Drug')]")
	protected WebElement pdp_drug;

	@FindBy (xpath =".//*[@id='claim-type']/option[1]")
	protected WebElement medical;

	@FindBy (xpath = "//div[@class='medical-claims']//h2[@ng-bind-html='planName']/parent::div//*[@id='document-date']//option[contains(@value,'24 months')]")
	protected WebElement last24months;

	@FindBy(xpath="//b[contains(text(),'Claim Type')]/../../../../div[contains(text(),'Medical')]")
	protected WebElement ma_medicalClaimsTypTxt;

	@FindBy(xpath="//b[contains(text(),'Claim Type')]/../../../../div[contains(text(),'Prescription')]")
	protected WebElement pdp_drugClaimsTypTxt;

	@FindBy(xpath = "//a[@id = 'contactUsAtdd']")
	protected WebElement contactUsLnk;

	@FindBy(xpath="//*[@id='custom_from_date_ship']")
	protected WebElement shipFrom;

	@FindBy(xpath="//*[@id='custom_to_date_ship']")
	protected WebElement shipTo;

	@FindBy(xpath="//button[@id='customsearchbuttonShipBtn']")
	protected WebElement ship_custSrchBtn;

	@FindBy (xpath ="(//*[text()='Search'])[1]")
	protected WebElement srchBtn;

	@FindBy (xpath="//*[@id='custom_from_date_fed']")
	protected WebElement fedFrom;

	@FindBy (xpath="//*[@id='custom_to_date_fed']")
	protected WebElement fedTo;

	@FindBy(xpath = "//div[contains(@class,'preeffeciveParsys')]//p")
	protected WebElement preEffMsg;

	@FindBy(xpath = "//p[contains(@ng-if, 'preEffective == true') or (contains(@ng-if, 'preEffective != true') and contains(@ng-if, 'businessType ==') )]")
	protected WebElement preEffTechSuppNum;

	@FindBy(xpath = "//h1")
	protected WebElement pgHeader;

	@FindBy(xpath="//div[contains(@class,'shipCompSection')]//h2")
	protected WebElement ship_subPgHeader;

	@FindBy(xpath = ".//*[@id='planNameFed']")
	protected WebElement planName;

	@FindBy(xpath="//ul[@ng-repeat='planName in shipPlansList']//li")
	protected WebElement ship_planName;

	@FindBy (id="learnmoresummarytoggle")
	protected WebElement lrnMoreAbtClaimsTog;

	@FindBy(xpath="//div[contains(@class,'LearnMoreAboutYour') and not(contains(@class,'ng-hide'))]") 
	protected WebElement lrnMoreAbtClaimsContent;

	@FindBy(xpath="//div[@class='pgno_pgnation_wrap']")	
	protected WebElement summPgPagination;

	@FindBy (xpath ="//div[@ng-hide='phipError']//div[@class='customsegments parbase section'][1]//p[contains(text(), 'Medical EOB')]")
	protected WebElement medicalEobTxt;

	@FindBy (xpath="(//p[contains(text(),'Prescription Drug EOB')])[1]/ancestor::div[1]")
	protected WebElement drugEobTxt;

	@FindBy (xpath = "//div[@class='summaryParsys parsys']/div/div[not (contains(@class,'ng-hide'))][1]//p[text()='Prescription Drug EOB']/following::a[contains(@class,'btn btn--secondary')][1]")
	protected WebElement rxEobTxt;

	@FindBy (xpath="//span[text()='Ship EOB']/parent::a")
	protected WebElement shipClaimsEobTxt;

	@FindBy(id = "atddPagination")
	protected WebElement claimSummPagination;

	@FindBy (xpath= ".//*[@id='validDivErr']")
	protected WebElement srchErrMsg;

	@FindBy (xpath=".//*[@id='downloadHypLinkAtdd']")
	protected WebElement dnldMyDataBtn;

	@FindBy(xpath=".//*[@id='siteleaving-popup-overlay']/div/div[1]/p[1]")
	protected WebElement dnldPopup_leavingSite; 

	@FindBy(id="proceedbtn")
	protected WebElement dnldPopup_proceedBtn;

	@FindBy(id="cancelbtn")
	protected WebElement dnldPopup_cancelBtn;

	@FindBy (css = ".ng-scope>p>span")
	protected WebElement shipDateRngErrMsg;

	@FindBy (id="errorMsg")
	protected WebElement phip_errMsg;

	@FindBy (xpath ="//*[@id='futureDateErrorDivErr']/p/span")
	protected WebElement fromDateLaterThanToDateErr;

	@FindBy  (xpath =".//*[@id='prescriptionDrug']/tbody/tr[1]/th[7]/p")
	protected WebElement rxNumInClaimsTbl;

	@FindBy(xpath="//label[@for='fed-document-date']")
	protected WebElement viewClaimsFromLbl;

	@FindBy(xpath="//label[@id='viewClaimsShipAtdd']")
	protected WebElement ship_viewClaimsFromLbl;

	@FindBy(id="fed-document-date")
	protected WebElement srchClaimsRngDropdown;

	@FindBy(id="document-date")
	protected WebElement ship_srchClaimsRngDropdown;

	@FindBy(xpath="//label[@for='claim-type']")
	protected WebElement claimsTypLbl;

	@FindBy(xpath="//label[@for='provider-type']")
	protected WebElement ship_claimsTypLbl;

	@FindBy(id="claim-type")
	protected WebElement claimsTypDropdown;

	@FindBy(id="claim-provider")
	protected WebElement ship_claimsTypDropdown;

	@FindBy(xpath="//div[@id='tableAtddFed']//div[contains(@class,'table-body-cell') and contains(text(),'Medical')]")
	protected WebElement claimsTypMedicalOnly;

	@FindBy(xpath="//div[@id='tableAtddFed']//div[contains(@class,'table-body-cell') and contains(text(),'Prescription Drug')]")
	protected WebElement claimsTypDrugOnly;

	@FindBy(xpath="//div[contains(@class,'ReviewYourClaimsLanguage') and not(contains(@class,'ng-hide'))]")
	protected WebElement reviewClaimsTxt;

	@FindBy(xpath="//div[contains(@class,'GeneralContentSHIP') and not(contains(@class,'ng-hide'))]")
	protected WebElement ship_reviewClaimsTxt;

	@FindBy(xpath=".//*[@id='atddPagination']/p")
	protected WebElement claimSummPaginationTxt;

	@FindBy(id="numDays1")
	protected WebElement youHave1;

	@FindBy(id="numDays2")
	protected WebElement youHave2;

	@FindBy(id="numDays3")
	protected WebElement youHave3;
	
	@FindBy(xpath="//h3[not(contains(@class,'ng-hide'))]//span[contains(@class,'days-title')]")
	protected WebElement youHave4;

	@FindBy(xpath=".//*[@id='globalContentIdForSkipLink']/div[3]/div[1]/div/div/div/div[2]/div/div[1]/section/div[2]/section/div/div/div/div/div/div/div[1]/p")
	protected WebElement pcpTxt;

	@FindBy(xpath="//*[@class='otherPages ReviewYourClaimsLanguage']//p")
	protected WebElement fed_clamsSummCpTxt;

	@FindBy(xpath="//div[contains(@class,'GeneralContentSHIP')]//p")
	protected WebElement ship_clamsSummCpTxt;

	@FindBy(xpath="//button[@id='all-claims-download-btn']")
	protected WebElement claimsSummDnldBtn;

	@FindBy(xpath="//div[@id='twoValidDivErr']//p//span") 
	protected WebElement errGrThanTwoYrs;

	@FindBy(xpath="//div[@id='validDivErr']//p//span") 
	protected WebElement errGrThan24mon;

	@FindBy(xpath="//div[contains(@class,'shipCompSection')]//p[contains(@id,'validShipDivErr')]/..//p[2]//span")
	protected WebElement ship_errGrThan24mon;

	@FindBy(xpath=".//*[@id='ship']")
	protected WebElement ship_claimsTbl;

	@FindBy(xpath="//div[contains(@class,'shipCompSection')]//div[contains(@ng-if,'futureDateError')]//p//span")
	protected WebElement ship_errFromDateLaterThanToDate;

	@FindBy(xpath="//div[contains(@class,'EOBComponentMA') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Medical')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	protected WebElement medicalEob_MA;
	@FindBy(xpath="//div[contains(@class,'EOBComponentMA') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Prescription')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	protected WebElement drugEob_MA;

	@FindBy(xpath="//div[contains(@class,'EOBComponentMAPD') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Medical')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	protected WebElement medicalEob_MAPD;
	@FindBy(xpath="//div[contains(@class,'EOBComponentMAPD') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Prescription')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	protected WebElement drugEob_MAPD;

	@FindBy(xpath="//div[contains(@class,'EOBComponentPDP') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Medical')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	protected WebElement medicalEob_PDP;
	@FindBy(xpath="//div[contains(@class,'EOBComponentPDP') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Prescription')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	protected WebElement drugEob_PDP;

	@FindBy(xpath="//div[contains(@class,'EOBComponentSHIP') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Ship')]/../p[contains(text(),'VIEW EOB STATEMENT')]")
	protected WebElement ship_eob;

	@FindBy(xpath="//a//span[text()='keyboard_arrow_left']")
	protected WebElement ltArrowBtn;
	@FindBy(xpath="//a//span[text()='keyboard_arrow_right']")
	protected WebElement rtArrowBtn;

	@FindBy(xpath="//li[contains(@class,'prevLink') and contains(@class,'disabled')]")
	protected WebElement disabled_prevBtn;
	@FindBy(xpath="//li[contains(@class,'nextLink') and contains(@class,'disabled')]")
	protected WebElement disabled_nextBtn;
	
	@FindBy(xpath="//div[@id='atddPagination']//p[contains(text(),'items found. Displaying 1 to')]")
	protected WebElement itemsFoundDispTxt;

	@FindBy(xpath="//p[contains(text(),'Not the claims you were expecting? Select a different date range to search again.')]")
	protected WebElement notTheClaimsYouWereExp;

	@FindBy(xpath="//div[@id='prefix-overlay-step1']")
	protected WebElement makeTheMostPopup;

	@FindBy(xpath="//div[contains(@class,'EOBComponent') and not(contains(@class,'ng-hide'))]//*[contains(text(),'SEARCH')]")
	protected WebElement srchAnyEobHistTxt;

	@FindBy(xpath="//div[contains(@class,'EOBComponent') and not(contains(@class,'ng-hide'))]//*[contains(text(),'VIEW EOB')]")
	protected WebElement srchEobStatTxt;

	@FindBy(xpath="//p[contains(text(),'View your current prescription drug cost summary at')]//a[contains(text(),'OptumRx.com')]")
	protected WebElement viewCurrDrugCostTxt;

	@FindBy(xpath="//a[contains(text(),'OptumRx.com')]")
	protected WebElement viewCurrDrugCostLnk;

	@FindBy(xpath="//div[@id='datesEmptyErrorContent']//p//span")
	protected WebElement errMtyDates;

	@FindBy(xpath="//div//p[@id='datesEmptyErrorDivErr']/../p/span")
	protected WebElement ship_errMtyDates;

	@FindBy(xpath="//div[@class='otherPages EOBpagedescriptionPDP']//p[contains(text(),'Your monthly EOB shows a summary of the claims we ')]")
	protected WebElement msgEob_PDP;

	@FindBy(id = "claims_1")
	protected WebElement claimsPgLnk;

	@FindBy(xpath = "//main//li[@class='ng-scope']//a[1]")
	protected WebElement plan_SSUP;

	@FindBy(xpath = "//p[contains(text(),'1-800-523-5880')]")
	protected WebElement preEffClaimsSuppNum;

	@FindBy(xpath = "//h3[@class='needhelp h4 margin-none atdd-claims-header']")
	protected WebElement preEffClaimsSuppHeader;

	@FindBy(xpath ="//*[@id='moreInfoLinkAtdd2']/a")
	protected WebElement eobSpecificClaimLnk;

	@FindBy (id = "numClaims1")
	protected WebElement medicalClaimsNum;

	@FindBy (id = "numClaims3")
	protected WebElement rxClaimsNum;

	@FindBy (xpath = ".//*[@id='prescriptionDrug']")
	protected WebElement drugClaimsTbl;

	//@FindBy (id = "ship")
	//protected WebElement claimsTableSHIP;

	@FindBy(css = ".claim-results")
	protected WebElement claimsSummPg;

	@FindBy(xpath="//div[contains(@ng-if,'systemFailure')]//*[contains(text(),'system error')]")
	protected WebElement systemErrorMsg;

	@FindBy(xpath=".//*[@id='medical']")
	protected WebElement medicalClaimsTbl;

	@FindBy(xpath="//div[@class='claim-results']//p[contains(text(),'View your current prescription drug cost summary at')]//a[text()='OptumRx.com']")
	protected WebElement optumRxLnkTxt_noClaims;

	@FindBy(xpath="//div[contains(@class,'tablenavigationarea')]//a[contains(text(),'VIEW YOUR CURRENT PRESCRIPTION DRUG COST SUMMARY AT OPTUMRX.COM')]")
	protected WebElement optumRxLnkTxt_hasClaims;

	@FindBy(xpath="//h1[contains(text(),'Benefits Information')]")
	protected WebElement optumRxPgHeader;

	@FindBy(xpath = "//div[@class='medical-claims shipCompSection']//div//*[@id='document-date']//option[contains(@value,'24 months')]")
	protected WebElement diff_last24months;

	@FindBy(xpath = "//table[@id='ship']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))][count(//table[@id='ship']/tbody/tr/th/p[text() ='Provider']/parent::th/preceding-sibling::th)+1]")
	protected WebElement vbf_shipProviderNameVal;

	@FindBy(xpath = "//table[@id='medical']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))]")
	protected List<WebElement> vbf_medicalTblRow;

	@FindBy(xpath = "//table[@id='medical']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))][count(//table[@id='medical']/tbody/tr/th/p[contains(text(),'Provider Name')]/parent::th/preceding-sibling::th)+1]")
	protected WebElement vbf_providerNameVal;

	@FindBy(xpath = "//table[@id='prescriptionDrug']/tbody/tr[2]/td[not (contains(@class,'ng-hide'))][not (contains(@class,'hidden-lg'))]")
	protected List<WebElement> vbf_drugTblRow;

	@FindBy(xpath = "//table[@id='ship']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))]")
	protected List<WebElement> vbf_shipTblRow;
	
	@FindBy(xpath="//h1[contains(text(),'Explanation of Benefits')]")
	protected WebElement eobPageHeader;
	
	@FindBy(xpath = "//*[@id='49144037']")
	protected WebElement pdpNavTab;
	
	@FindBy(xpath = "//*[@id='15825500']")
	protected WebElement medsuppNavTab;
	
	@FindBy(xpath = "//*[@id='71710697']")
	protected WebElement mapdNavTab;
	
	@FindBy(xpath="//button[@aria-label='Calendar' and contains(@class,'custom_from_date_fed')]")
	protected WebElement fromCalendarIconBtn_fed;

	@FindBy(xpath="//ul[@ng-model='date'][1]//button[contains(@class,'btn-sm') and contains(@class,'active')]")
	protected WebElement fromCalendarDatePicker_today_fed;

	@FindBy(xpath="//button[@aria-label='Calendar' and contains(@class,'custom_to_date_fed')]")
	protected WebElement toCalendarIconBtn_fed;

	@FindBy(xpath="//ul[@ng-model='date'][2]//button[contains(@class,'btn-sm') and contains(@class,'active')]")
	protected WebElement toCalendarDatePicker_today_fed;
	
	@FindBy(xpath="//button[@aria-label='Calendar' and contains(@class,'custom_from_date_ship')]")
	protected WebElement fromCalendarIconBtn_ship;

	@FindBy(xpath="//ul[@ng-model='date'][3]//button[contains(@class,'btn-sm') and contains(@class,'active')]")
	protected WebElement fromCalendarDatePicker_today_ship;

	@FindBy(xpath="//button[@aria-label='Calendar' and contains(@class,'custom_to_date_ship')]")
	protected WebElement toCalendarIconBtn_ship;

	@FindBy(xpath="//ul[@ng-model='date'][4]//button[contains(@class,'btn-sm') and contains(@class,'active')]")
	protected WebElement toCalendarDatePicker_today_ship;
	
}
