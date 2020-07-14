package pages.regression.claims;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** WebElements for Claim Details page */
public class ClaimDetailsWebElements extends ClaimsBase{

	public ClaimDetailsWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	@FindBy (xpath=".//*[@id='claimSearchButton']/p/b")
	protected WebElement claimSrch;

	@FindBy(xpath = "//html/body/div[2]/div/div/div/div/main/div/div[1]/div[2]/header/div/div/div/div/div/div/h2")
	protected  WebElement myClaimsDetlTxt;

	@FindBy(xpath=".//*[@id='dateRange']")
	protected WebElement dateRng;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][1]//div[@class='table-body-cell'][1]//p")
	protected WebElement ship_dateRngLbl;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][1]//div[@class='table-body-cell'][2]//p")
	protected WebElement ship_dateRngVal;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][2]//div[@class='table-body-cell'][1]//p")
	protected WebElement ship_claimsNumLbl;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][2]//div[@class='table-body-cell'][2]//p")
	protected WebElement ship_claimsNumVal;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][3]//div[@class='table-body-cell'][1]//p")
	protected WebElement ship_claimsTypLbl;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][3]//div[@class='table-body-cell'][2]//p")
	protected WebElement ship_claimsTypVal;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][4]//div[1]//p")
	protected WebElement ship_eobLbl;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][4]//div[2]//p")
	protected WebElement ship_eobVal;

	@FindBy(xpath="//div[contains(@class,'eobinformation')]")
	protected WebElement ship_eobStmtTxt;

	@FindBy(xpath=".//*[@id='providerName']")
	protected  WebElement providerName;

	@FindBy (xpath =".//*[@id='claimSearchButtons']")
	protected WebElement claimsSummLnkOnDetlTopPg;

	@FindBy (xpath =".//*[@id='claimSearchButton']")
	protected WebElement ship_claimsSummLnkOnDetlTopPg;

	@FindBy (xpath =".//*[@id='claimSearchButtonBottom']")
	protected WebElement claimsSummLnkOnDetlBtmPg;

	@FindBy(xpath=".//*[@id='claimNumberLabel']/p/b")
	protected WebElement claimsNumLbl;

	@FindBy(xpath="//div[contains(@class,'ship')]//p//b[contains(text(),'Claim #:')]")
	protected WebElement ship_detl_claimsNumLbl;

	@FindBy(xpath=".//*[@id='claimDynamicNum']")
	protected WebElement claimsNumDyn;

	@FindBy (xpath=".//*[@id='claimTypeLabel']")                    
	protected WebElement claimsTypLbl;

	@FindBy (xpath=".//*[@id='claimDynamicType']")                    
	protected WebElement claimsTypDyn;

	@FindBy (xpath=".//*[@id='claimStatusLabel']")
	protected WebElement claimsStatLbl;

	@FindBy (xpath=".//*[@id='claimDynamicStatus']")
	protected WebElement claimsStatDyn;

	@FindBy (xpath=".//*[@id='medicalEOB']")
	protected WebElement medicalEobLbl;

	@FindBy (xpath=".//*[@id='viewPDF']")
	protected WebElement viewPdf;

	@FindBy (xpath="//*[@id='learnmoreMA']")
	protected WebElement lrnMore_MA;

	@FindBy (xpath="//*[@id='learnmorePDP']")
	protected WebElement lrnMore_PDP;

	@FindBy(css = ".claimDetTableMainSection")
	public WebElement claimsDetlTblMainSect;

	@FindBy(css = ".claimsTotalTable")
	public WebElement claimsTotTbl;

	@FindBy(xpath = ".//*[@id='learnmoredetailstoggle']")
	protected WebElement lrnMoreLnkTog;

	@FindBy(id = "eobClass")
	protected WebElement headerEob;

	@FindBy(xpath =".//*[@id='claimDetailsHeaders']/p")
	protected WebElement medicalClaimsDetlTxt;

	@FindBy(xpath ="//div[contains(@class,'fed')]//h2[contains(@id,'claimDetailsHeader')]//p")
	protected WebElement fed_medicalClaimsDetlTxt;

	@FindBy(xpath ="//div[contains(@class,'ship')]//h2[contains(@id,'claimDetailsHeader')]//p")
	protected WebElement ship_medicalClaimsDetlTxt;

	@FindBy(xpath = ".//*[@id='ship_eob']/div/section/a/p")
	protected WebElement ship_eob;

	@FindBy(xpath = ".//*[@id='medicalEOB']/span/p/b")
	protected WebElement eobUnAva;

	//note: for claim summary medical table
	//note: value need to strip and process before validation e.g. 2019-01-25 vs 01/25/2019 to 01/25/2019
	@FindBy(xpath="//p[@id='dateRange']")
	protected WebElement med_dateOfService; 
	@FindBy(xpath="//p[@id='providerName']")
	protected WebElement med_providerName;  //note: value on team-a env needs to strip white space
	@FindBy(xpath="//div[@id='claimDynamicType']//span//p")
	protected WebElement med_providerType;
	@FindBy(xpath="//div[contains(@class, 'claimstotaltable')]//p[contains(text(),'Amount')]/../../p")
	protected WebElement med_amountBilled;
	@FindBy(xpath="//div[@id='claimDynamicStatus']//span//p")
	protected WebElement med_claimStatus;
	@FindBy(xpath="//div[contains(@class, 'claimstotaltable')]//p[contains(text(),'Your share')]/../../../p")
	protected WebElement med_yourShare;

	//note: for claim summary drug table
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[2]")
	protected WebElement drug_dateFilled;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[3]")
	protected WebElement drug_medication;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[4]")
	protected WebElement drug_rxNumber;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[5]")
	protected WebElement drug_pharmacy;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[6]")
	protected WebElement drug_planPaid;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[7]")
	protected WebElement drug_youPaid;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[8]")
	protected WebElement drug_otherPayments;

	//note: for claim summary ship table
	@FindBy(xpath="//b[contains(text(),'Service Date(s):')]/../..")   
	protected WebElement ship_dateOfService;   // note: will need to process before validation e.g. Service Date(s): 06/01/2017 - 06/06/2017
	@FindBy(xpath="//p[contains(@class,'subtitle')]") 
	protected WebElement ship_provider;  // note: validate via contains
	@FindBy(xpath="//div[@class='table-body-cell']//b[contains(text(),'Claim Type')]/../../../../div[2]//p")
	protected WebElement ship_claimType;
	@FindBy(xpath="//section[contains(@id, 'cltotshippartb')]//i[contains(text(),'Amount Charged')]/../../../p")
	protected WebElement ship_charged;
	@FindBy(xpath="//h2[contains(@ng-if,'paidToYouAmountTotal')]")
	protected WebElement ship_paidToYou;
	@FindBy(xpath="//h2[contains(@ng-if,'paidByPlanAmountTotal')]")
	protected WebElement ship_paidToProvider;
	@FindBy(xpath="//div[@class='table-body-cell']//b[contains(text(),'Processed Date')]/../../../../div[2]//p")
	protected WebElement ship_processedDate;  // 2017-06-01 vs 05/07/2018

	@FindBy(xpath="//a[@id='claimsummaryC1']")
	protected WebElement claimsSummLnk;

	@FindBy(xpath="//a[@id='claimSearchButtons']")
	protected WebElement claimsSummBkBtn;

	@FindBy(xpath="//a[@id='claimSearchButton']")
	protected WebElement ship_claimsSummBkBtn;

	@FindBy(xpath="//p[contains(text(),'Medical Claim Details')]")
	protected WebElement claimsDetlHeader;

	@FindBy(xpath="//h1[contains(@class,'heading')]")
	protected WebElement claimsSummHeader;

	@FindBy(xpath="//div[@class='learnmorearea learnMoreAboutBreakdownDetails']")
	protected WebElement lrnMoreCost; 

	@FindBy(xpath="//div[contains(@class,'EOBComponentMA') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Medical')]/../p[contains(text(),'SEARCH YOUR HISTORY')]")
	protected WebElement detl_medicalEob;

	@FindBy(xpath="//div[contains(@class,'EOBComponentMA') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Prescription')]/../p[contains(text(),'SEARCH YOUR HISTORY')]")
	protected WebElement detl_drugEob;

	@FindBy(xpath="//div[contains(@class,'EOBComponentSHIP') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Ship')]/../p[contains(text(),'VIEW EOB STATEMENT')]")
	protected WebElement eob_Ship;

	@FindBy(xpath="//div[contains(@class,'AdobeAcrobatComponent') and not(contains(@class,'ng-hide'))]//p//b[contains(text(),'This page contains PDF documents')]")
	protected WebElement adobePdfDocTxt;

	@FindBy(xpath="//div[contains(@class,'EOBComponent') and not(contains(@class,'ng-hide'))]//*[contains(text(),'SEARCH')]")
	protected WebElement srchAnyEobHistTxt;

	@FindBy(xpath="//div[contains(@class,'EOBComponent') and not(contains(@class,'ng-hide'))]//*[contains(text(),'VIEW EOB')]")
	protected WebElement srchEobStatTxt;

	//this give u number of rows on the claims list table
	@FindBy(xpath="//div[@class='medical-claims']//div[@class='claimDetTableMainSection']//div[contains(@ng-repeat,'bl in billLineDetailsList')]")
	protected List<WebElement> claimsTblRows;

	//note: total will be 8, just take p[1] - [4] 
	@FindBy(xpath="//div[@class='medical-claims']//div[@class='claimDetTableMainSection']//div[contains(@ng-repeat,'bl in billLineDetailsList')]//div[@class='row margin-small']//div[@class='col-md-3']//p")
	protected List<WebElement> claimsColmItems;
	//note: 1=amount | 2=adjustment | 3=plansShare | 4=your share
	@FindBy(xpath="//div[@class='medical-claims']//div[contains(@class,'claimsTotalTable')]//section[@id='cltotmednice']//div[@class='row margin-small']//div[@class='col-md-3']//p[contains(@class,'h5')]")
	protected List<WebElement> claimsTotItems;

	@FindBy(xpath="//div[@id='shipPartBDetailsTable']//div[contains(@ng-repeat,'billLineDetailsList')]//div[@class='card-body']")
	protected List<WebElement> ship_claimsTblRows;

	@FindBy(xpath="//b[contains(text(),'Note')]")
	protected WebElement note;

	@FindBy(xpath="//b[contains(text(),'Medical Explanation of Benefits (EOB):')]")
	protected WebElement medicalEobTxt;

	@FindBy(xpath="//div[@id='medicaleobNotavialable']//p[text()='Not Available (Pending)']")
	protected WebElement medicalEobNotAvaTxt;

	@FindBy (xpath=".//*[@id='viewPDF']")
	protected WebElement medicalEobViewPdf;

	//note: tooltips
	@FindBy(xpath="//div[@id='claimDynamicStatus']//button[contains(@class,'tooltip')]")
	protected WebElement claimsStatTooltipsBtn;

	@FindBy(xpath="//div[contains(@ng-show,'medicalDetails') and not(contains(@class,'ng-hide'))]//button[contains(@class,'tooltip')]")
	protected WebElement eobTooltipsBtn;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//button[contains(@class,'tooltip-large')]")
	protected WebElement ship_eobTooltipsBtn;

	@FindBy(xpath="//div[@class='tooltipster-content']")
	protected WebElement tooltipsElemTxt;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	protected WebElement comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan')]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSUP;

	//vvv note:	added for VBF		
	@FindBy(xpath = "//div[@class='claimDetTableMainSection']//div[@class='card-body']//div/p[contains(text(),'$')]")
	protected List<WebElement> claimsTblVal;

	@FindBy(xpath = "//section[@id='cltotshippartb']//div[@class='card-body']")
	protected WebElement shipClaimsTotTbl;

	@FindBy(xpath = "//section[@id='cltotshippartb']//div[@class='card-body']//div[@class='col-md-2']/p[contains(text(),'$')]")
	protected List<WebElement> shipClaimsTotVal;
	//^^^ note:	added for VBF		
	
	@FindBy(xpath="//div[contains(@ng-show,'providerType') and not(contains(@class,'ng-hide'))]//div[contains(@class,'adjustmentsToggle') and @data-toggle='collapse']//span[contains(@class,'tZero')]")
	protected WebElement adjustmentToggleCollapsed;

	@FindBy(xpath="//div[contains(@ng-show,'providerType') and not(contains(@class,'ng-hide'))]//div[contains(@class,'adjustmentsToggle') and @data-toggle='collapse']//span[contains(@class,'t180')]")
	protected WebElement adjustmentToggleExpanded;

	@FindBy(xpath="//div[contains(@ng-show,'providerType') and not(contains(@class,'ng-hide'))]//div[contains(@class,'adjustmentsToggle') and @data-toggle='collapse']//parent::div/following-sibling::div/div[contains(@class,'adjustmentsToggle_sec')]//div[contains(@class,'row')][1]")
	protected WebElement adjustmentPayableAmountSection;
	
	@FindBy(xpath="//div[contains(@ng-show,'providerType') and not(contains(@class,'ng-hide'))]//div[contains(@class,'adjustmentsToggle') and @data-toggle='collapse']//parent::div/following-sibling::div/div[contains(@class,'adjustmentsToggle_sec')]//div[contains(@class,'row')][1]//p[1]")
	protected WebElement adjustmentPayableAmountSectionValue;

	@FindBy(xpath="//div[contains(@ng-show,'providerType') and not(contains(@class,'ng-hide'))]//div[contains(@class,'adjustmentsToggle') and @data-toggle='collapse']//parent::div/following-sibling::div/div[contains(@class,'adjustmentsToggle_sec')]//div[contains(@class,'row')][1]//p[2]")
	protected WebElement adjustmentPayableAmountSectionText;
	
	
	@FindBy(xpath="//div[contains(@ng-show,'providerType') and not(contains(@class,'ng-hide'))]//div[contains(@class,'adjustmentsToggle') and @data-toggle='collapse']//parent::div/following-sibling::div/div[contains(@class,'adjustmentsToggle_sec')]//div[contains(@class,'row')][2]")
	protected WebElement adjustmentPaymentAdjustmentSection;

	@FindBy(xpath="//div[contains(@ng-show,'providerType') and not(contains(@class,'ng-hide'))]//div[contains(@class,'adjustmentsToggle') and @data-toggle='collapse']//parent::div/following-sibling::div/div[contains(@class,'adjustmentsToggle_sec')]//div[contains(@class,'row')][2]/div[1]")
	protected WebElement adjustmentPaymentAdjustmentSectionSign;
	
	@FindBy(xpath="//div[contains(@ng-show,'providerType') and not(contains(@class,'ng-hide'))]//div[contains(@class,'adjustmentsToggle') and @data-toggle='collapse']//parent::div/following-sibling::div/div[contains(@class,'adjustmentsToggle_sec')]//div[contains(@class,'row')][2]//p[1]")
	protected WebElement adjustmentPaymentAdjustmentSectionValue;

	@FindBy(xpath="//div[contains(@ng-show,'providerType') and not(contains(@class,'ng-hide'))]//div[contains(@class,'adjustmentsToggle') and @data-toggle='collapse']//parent::div/following-sibling::div/div[contains(@class,'adjustmentsToggle_sec')]//div[contains(@class,'row')][2]//p[2]")
	protected WebElement adjustmentPaymentAdjustmentSectionText;
}
