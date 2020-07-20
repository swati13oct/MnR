package pages.regression.explanationofbenefits;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class EOBWebElements extends UhcDriver{

	@FindBy(xpath="//select[@id='eob-type']")
	protected WebElement eobTypeDropdown;
	
	@FindBy(xpath="//label[@for='eob-type']")
	protected WebElement eobTypeLabel;

	@FindBy(xpath="//div[contains(@class,'dropdown') and not(contains(@class,'ng-hide'))]//select[contains(@id,'date-range')]")
	protected WebElement eobDateRangeDropdown;
	
	@FindBy(xpath="//div[contains(@ng-show,'Plan') and not(contains(@class,'ng-hide'))]//label[contains(@for,'date-range')]")
	protected WebElement eobDateRangeLabel;

	@FindBy(id="custom-from2")
	protected WebElement fromDateInputBox;

	@FindBy(id="custom-to1")
	protected WebElement toDateInputBox;

	@FindBy(className="btn custom-date-search-btn")
	protected WebElement searchButton;

	@FindBy(xpath="//a[contains(@class, 'learnmoreeob')]")
	protected WebElement learnMoreLink;

	@FindBy(xpath="//div[contains(@ng-if, 'Prescription Drug') and not(contains(@class,'ng-hide'))]")
	protected WebElement drugText;
	
	@FindBy(id="eobvideoicon")
	protected WebElement eobVideoBox;

	@FindBy(xpath = "//a[contains(text(), 'Adobe')]")
	protected WebElement adobeWebsiteLink;

	@FindBy(xpath = "//a[contains(@id, 'proceedbtn')]")
	protected WebElement siteLeavingProceedButton;

	@FindBy(xpath = "//a[contains(@id, 'cancelbtn')]")
	protected WebElement siteLeavingCancelButton;

	@FindBy(className="modal-body")
	protected WebElement iPerceptionPopUp;

	@FindBy(xpath = ".//*[@id='56884830']")
	protected WebElement MAPlanTab;

	@FindBy(xpath = ".//*[@id='23758777']/a")
	protected WebElement HIPplanTab;

	@FindBy(xpath = "//a[contains(text(), 'Medicare Prescription Drug Plan')]")
	protected WebElement PDPPlanTab;

	@FindBy(xpath = "//a[contains(text(), 'Medicare Supplement Insurance Plan')]")
	protected WebElement MedSuppPlanTab;

	@FindBy(xpath = "//a[contains(text(), 'Supplemental  Insurance Plans')]")
	protected WebElement SuppTab;

	@FindBy(xpath = "//a[contains(text(),'EOB Search')]")
	protected WebElement eobLink;

	@FindBy(id="toDatepicker")
	protected WebElement toDate;

	@FindBy(id="fromDatepicker")
	protected WebElement fromDate;	

	@FindBy(className=" btn btn—primary")
	protected WebElement customSearchButton;

	@FindBy(xpath="//div[contains(@id,'result') and not(contains(@class,'ng-hide'))]//*[contains(@class,'bold number-title ng-binding')]")
	protected WebElement eobCount;

	@FindBy(className="rightarrow")
	protected WebElement nextPageArrow;

	@FindBy(xpath="//li[contains(@class,'disabled')]//i[contains(@class,'leftarrow')]")
	protected WebElement prevPageArrow_disabled;

	@FindBy(xpath="//li[not(contains(@class,'disabled'))]//i[contains(@class,'leftarrow')]")
	protected WebElement prevPageArrow_enabled;

	@FindBy(id="eoblist0")
	protected WebElement eobFirst;

	@FindBy(id="coveragebenefits_2")
	protected WebElement bncTab;

	@FindBy(xpath = "//h1[contains(text(),'Plan Benefits Summary')]")
	protected WebElement bncPageHeader;

	@FindBy(xpath = "//*[@id='49144037']")
	protected WebElement pdpNavTab;

	@FindBy(xpath = "//*[@id='15825500']")
	protected WebElement medsuppNavTab;

	@FindBy(xpath = "//*[@id='71710697']")
	protected WebElement mapdNavTab;

	@FindBy(xpath = "//div[(@id='medical-prescription-results' or @id='error-results') and not(contains(@class,'ng-hide'))]//*[contains(text(),'Learn More About EOB')]")
	protected WebElement rightRailLearnMoreHeader;

	//tbd @FindBy(xpath = "//a[contains(text(),'How to read your monthly Medical Explanation of Benefits')]")
	@FindBy(xpath = "//div[(@id='medical-prescription-results' or @id='error-results') and not(contains(@class,'ng-hide'))]//a[contains(text(),'How to read your monthly Explanation of Benefits')]")
	protected WebElement rightRailLearnMoreLink;

	@FindBy(xpath = "//h1")
	protected WebElement pageHeader;

	@FindBy(xpath="//h1[contains(text(),'Explanation of Benefits')]")
	protected WebElement eobHeader;
	
	@FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/h2[not(contains(@class,'ng-hide')) and contains(text(),'Explanation of Benefits (EOB) Search')]")
	protected WebElement eobSubSectionHeader;
	
	@FindBy(xpath="//div[contains(@class,'EOBpagedescription') and not(contains(@class,'ng-hide'))]")
	protected WebElement eobSubSectionDescription;

	@FindBy(xpath="//div[@id='invalidFromOrToDateErrornvda']")
	protected WebElement futureDateErr;
	
	@FindBy(xpath="//div[@id='futureDateErrornvda']")
	protected WebElement beforeDateErr;
	
	@FindBy(xpath="//div[@id='maxDateRangeExceedednvda']")
	protected WebElement rangeExceedErr;
	
	@FindBy(xpath="//*[contains(text(),'Re-enter the From date in the format: MM/DD/YYYY.')]")
	protected WebElement blankFromDateErr;

	@FindBy(xpath="//*[contains(text(),'Re-enter the To date in the format: MM/DD/YYYY.')]")
	protected WebElement blankToDateErr;
	
	@FindBy(xpath="//button[contains(@class,'custom-date-search-btn')]")
	protected WebElement customSearchBtn;
	
	@FindBy(xpath="//*[@id='fromDatepicker']")
	protected WebElement fromTxtField;

	@FindBy(xpath="//*[@id='toDatepicker']")
	protected WebElement toTxtField;

	
	@FindBy(xpath="//button[contains(@aria-label,'calendar') and contains(@class,'fromDatepicker')]")
	protected WebElement fromCalendarIconBtn;

	@FindBy(xpath="//button[contains(@aria-label,'calenda') and contains(@class,'toDatepicker')]")
	protected WebElement toCalendarIconBtn;
	
	@FindBy(xpath="//ul[@ng-model='date'][1]//button[contains(@class,'btn-sm') and contains(@class,'active')]")
	protected WebElement fromCalendarDatePicker_today;

	@FindBy(xpath="//ul[@ng-model='date'][2]//button[contains(@class,'btn-sm') and contains(@class,'active')]")
	protected WebElement toCalendarDatePicker_today;

	@FindBy(xpath="//*[contains(@id, 'hl-widget-video-overlay')]")
	protected WebElement eobVideo;

	@FindBy(xpath="//*[contains(@id, 'widget-video')]//a[contains(@class, 'close')]")
	protected WebElement closeVideo;

	@FindBy(xpath=".//*[@id='eoblist0']/a")
	protected List<WebElement> listOfEOBs;

	@FindBy(xpath=".//*[@id='eoblist0']/a/img")
	protected List<WebElement> listOfPdfIcon;

	@FindBy(xpath=".//*[@id='eoblist0']/a/span")
	protected List<WebElement> listOfFileType;

	@FindBy(xpath=".//*[@id='eoblist0']/p")
	protected List<WebElement> listOfDatesDisplayed;

	@FindBy(xpath="//div[contains(@class,'loadingimage')]")
	protected WebElement eobLoadingimage;

	@FindBy(xpath="//span[contains(@class,'eobstmts')]//p")
	protected WebElement eobStmt;
	
	@FindBy(xpath="//div[contains(@class,'contactuseob')]//p")
	protected WebElement eobContactus;

	@FindBy(xpath="//*[contains(text(),'OPTUMRX.COM')]")
	protected WebElement optumRxLnk;
	

	@FindBy(xpath=".//*[@id='medical-prescription-results']//*[contains(@class,'document-list-new margin-large')]//li")
	protected List<WebElement> listOfEobs;

	@FindBy(xpath=".//table//tbody//tr")
	protected List<WebElement> listOfEobs_dream;

	@FindBy(xpath="//div[contains(@class,'eobErrors')]//p[contains(text(),'no EOBs available')]")
	protected WebElement noEobErr;
	
	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	protected WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	protected WebElement needHelp_TechicalSupportSection;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	protected WebElement needHelp_TechicalSupport_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	protected WebElement needHelp_TechicalSupport_phone;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	protected WebElement needHelp_TechicalSupport_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	protected WebElement needHelp_TechicalSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	protected WebElement needHelp_TechicalSupport_wkEndHrs;

	//note: need help - general section
	@FindBy(xpath="//div[contains(@class,'general section')]")
	protected WebElement needHelp_GeneralQuestionsSection;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[1]//img")
	protected WebElement needHelp_GeneralQuestions_img;

	@FindBy(xpath="//div[contains(@class,'general section')]/div/div/p[1]")
	protected WebElement needHelp_GeneralQuestions_phone;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[2]")
	protected WebElement needHelp_GeneralQuestions_tty;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[3]")
	protected WebElement needHelp_GeneralQuestions_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[4]")
	protected WebElement needHelp_GeneralQuestions_wkEndHrs;

	//note: need help - claims section
	@FindBy(xpath="//div[contains(@class,'claims section')]")
	protected WebElement needHelp_ClaimsSupportSection;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[1]//img")
	protected WebElement needHelp_ClaimsSupport_img;

	@FindBy(xpath="//div[contains(@class,'claims section')]/div/div/div/p[1]")
	protected WebElement needHelp_ClaimsSupport_phone;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[2]")
	protected WebElement needHelp_ClaimsSupport_tty;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[3]")
	protected WebElement needHelp_ClaimsSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[4]")
	protected WebElement needHelp_ClaimsSupport_wkEndHrs;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	protected WebElement needHelp_PlanSupportSection;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	protected WebElement needHelp_PlanSupport_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	protected WebElement needHelp_PlanSupport_phone;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	protected WebElement needHelp_PlanSupport_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	protected WebElement needHelp_PlanSupport_wkDayHrs;

	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	protected WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	protected WebElement needHelp_contactUsLink;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[not(contains(text(),'Supplement')) and not(contains(text(),'Prescription')) and contains(text(),'Medicare')]") 
	protected WebElement comboTab_MA;
	
	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Prescription') and contains(text(),'Medicare')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Supplement')]") 
	protected WebElement comboTab_SHIP;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Hospital Indemnity')]") 
	protected WebElement comboTab_SHIP_HIP;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Prescription') and not(contains(text(),'Medicare'))]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSP;
	
	@FindBy(xpath="//div[contains(@ng-show,'SSP') and not(contains(@class,'ng-hide'))]//p[@class='color-red']")
	protected WebElement sspError;
	
	@FindBy(xpath="//div[contains(@ng-show,'PHIP') and not(contains(@class,'ng-hide'))]//p[@class='color-red']")
	protected WebElement phipError;
	
	//note: specific for dream
	@FindBy(xpath="//label[contains(@for,'date-range') and contains(text(),'View EOBs From')]")
	protected WebElement eobDateRangeLabel_dream;

	@FindBy(xpath="//tr[@ng-repeat='eobData in pagedListItems[currentPage]'][1]//td[3]")
	protected WebElement eobFirst_dream;
	
	@FindBy(xpath="//body")
	protected WebElement apiResponseJson;
	
	@FindBy(xpath="//ul[contains(@class, 'nav-tabs')]//li//a")
	protected List<WebElement> comboTabList;
	
	@FindBy(xpath="//li[contains(@data-ng-class,'header')]//a[contains(@href,'eob.html') and text()='Explanation of Benefits']")
	protected WebElement eobOptionUnderClaimsMenu;
	
	@FindBy(xpath="//*[contatins(text(),'We are currently experiencing an internal server problem')]")
	protected WebElement internalServerError;
	
	@FindBy(xpath="//div[@id='servicefailerrnvda']")
	protected WebElement internalServerError2;
	
	@FindBy(xpath="//nav[@id='sub-nav']//a[contains(@href,'spending-and-cost-summary')]")
	protected WebElement spendingCostSummaryTab_topSubMenu;
	
	@FindBy(xpath="//div[contains(@class,'dropdown-menu')]//a[contains(@href,'spending-and-cost-summary')]")
	protected WebElement spendingCostSummaryTab_topSubMenu2;
	
	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(text(),'My Claims')]")
	protected WebElement myClaimsSubTopMenu;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(text(),'Claims Summary')]")
	protected WebElement oldClaimsSubTopMenu;
	
	@FindBy(xpath="//h2[contains(text(),'Spending')]")
	protected WebElement spendingCostSummaryPgHeader;

	@FindBy(id="date-range-1")
	protected WebElement eobMonthDateRange;

	@FindBy(xpath="//table//tr/th[1][contains(text(),'Date')]")
	protected WebElement tblHeaderDate;
	
	@FindBy(xpath="//table//tr/th[2][contains(text(),'EOB Type')]")
	protected WebElement tblHeaderType;
	
	@FindBy(xpath="//table//tr/th[3][contains(text(),'EOB Statement')]")
	protected WebElement tblHeaderStmt;
	
	@FindBy(xpath="//div[contains(@class,'contactus')]//p[contains(text(),'If you are having')]")
	protected WebElement contactusStmt1;
	
	@FindBy(xpath="//div[contains(@class,'contactus')]//p[contains(text(),'If you are having')]//a")
	protected WebElement contactusStmtLnk;

	@FindBy(xpath="//p[contains(text(),'In some instances')]")
	protected WebElement contactusStmt2;
	
	@FindBy(xpath="//p//strong[contains(text(),'Is there a provider')]/../a")
	protected WebElement contactusLnk;
	
	public EOBWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}
}


