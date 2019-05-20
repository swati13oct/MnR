package pages.regression.claims;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;


/**
 * Functionality : this page validates the Claim Summary page.
 */
public class ClaimSummarypage extends UhcDriver{

	@FindBy(xpath = ".//*[@id='globalContentIdForSkipLink']/div[3]/div[1]/div/div/div/div/div/p")
	private WebElement messageForPreeffective;

	@FindBy(xpath = "//p[contains(text(),'1-866-254-3132')]")
	public WebElement preEffectiveTechSupportNumber;

	@FindBy(css = ".claim-results")
	private WebElement ClaimsSummaryPage;//in use

	@FindBy(xpath = "//h1")
	private WebElement pageHeader;

	@FindBy(xpath="//div[contains(@class,'shipCompSection')]//h2")
	private WebElement ship_subPageHeader;

	@FindBy(xpath = ".//*[@id='planNameFed']")
	private WebElement planName;

	@FindBy(xpath="//ul[@ng-repeat='planName in shipPlansList']//li")
	private WebElement ship_planName;

	@FindBy(xpath =".//*[@id='dateCustomSearchAtdd']")
	private WebElement customSearch;

	@FindBy (xpath = "//div[@class='medical-claims']//h2[@ng-bind-html='planName']/parent::div//*[@id='document-date']//option[contains(@value,'24 months')]")
	private WebElement last24months;

	@FindBy (id="learnmoresummarytoggle")
	private WebElement learnMoreAboutClaims;

	@FindBy(xpath="//div[contains(@class,'LearnMoreAboutYour') and not(contains(@class,'ng-hide'))]") 
	private WebElement learnMoreAboutClaimsContent;

	@FindBy(xpath=".//*[@id='medical']")
	private WebElement claimsTableMedical;

	@FindBy (xpath = ".//*[@id='prescriptionDrug']")
	private WebElement claimsTablePrescriptionDrug;

	@FindBy (id = "ship")
	private WebElement claimsTableSHIP;

	@FindBy(className="modal-body")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath="//*[@id='atddUhcPagination']/li[1]/p")	
	private WebElement verifyClaimSummaryAndPagination;

	@FindBy (xpath ="//div[@ng-hide='phipError']//div[@class='customsegments parbase section'][1]//p[contains(text(), 'Medical EOB')]")
	private WebElement medicalEobText;

	@FindBy (xpath="(//p[contains(text(),'Prescription Drug EOB')])[1]/ancestor::div[1]")
	private WebElement PrescriptionEobText;

	@FindBy (xpath = "//div[@class='summaryParsys parsys']/div/div[not (contains(@class,'ng-hide'))][1]//p[text()='Prescription Drug EOB']/following::a[contains(@class,'btn btn--secondary')][1]")
	private WebElement PrescriptionEobText1;

	@FindBy (xpath="//span[text()='Ship EOB']/parent::a")
	private WebElement ShipClaimsEobText;

	@FindBy(id = "atddPagination")
	private WebElement verifyClaimSummaryAndPagination3;

	@FindBy (xpath= ".//*[@id='validDivErr']")
	private WebElement messageaftersrch;

	@FindBy (xpath=".//*[@id='downloadHypLinkAtdd']")
	private WebElement downloadmydatabutton;

	@FindBy(xpath=".//*[@id='siteleaving-popup-overlay']/div/div[1]/p[1]")
	private WebElement leavingsitepopup; 

	@FindBy(id="proceedbtn")
	private WebElement proceedButtonDownloadPopUp;

	@FindBy(id="cancelbtn")
	private WebElement cancelButtonDownloadPopUp;

	@FindBy (xpath ="(//*[text()='Search'])[1]")
	private WebElement searchButton;

	@FindBy (xpath="//*[@id='custom_from_date_fed']")
	private WebElement from;

	@FindBy (xpath="//*[@id='custom_to_date_fed']")
	private WebElement to;

	@FindBy (xpath = ".//*[@id='errorMsg']/div/p")
	private WebElement rxErrorMsg;

	@FindBy (css = ".ng-scope>p>span")
	private WebElement shipDateRangeErrMsg;

	@FindBy (id="errorMsg")
	private WebElement PHIPerrorMsg;

	/* tbd-remove @FindBy (css = ".color-red.semi-bold>p>span")
	private WebElement fedDateRangeErrMsg; */

	@FindBy (xpath ="//*[@id='futureDateErrorDivErr']/p/span")
	private WebElement fromDateLaterThanToDateError;

	@FindBy(xpath = ".//*[@id='claim-type']/option[2]")
	private WebElement PrescriptionDrug;

	@FindBy  (xpath =".//*[@id='prescriptionDrug']/tbody/tr[1]/th[7]/p")
	private WebElement RxNumberinthecalimstable;

	@FindBy (xpath =".//*[@id='claim-type']/option[1]")
	private WebElement Medical;

	@FindBy(xpath = "//div[@class='claim-results']//table[not (contains(@class,'ng-hide'))]//tbody//tr[2]//a[text()='MORE INFO']")
	private WebElement claimstablemoreinfolink;

	@FindBy (xpath= "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li")
	private List<WebElement> comboTabsOnclaimsPage;	

	/* tbd-remove @FindBy(id= "claims_1")
	private static WebElement claimsLink; */

	@FindBy(xpath="//label[@for='fed-document-date']")
	private WebElement viewclaimsFromLabel;

	@FindBy(xpath="//label[@id='viewClaimsShipAtdd']")
	private WebElement ship_viewclaimsFromLabel;

	@FindBy(id="fed-document-date")
	private WebElement searchclaimsRangeDropDown;

	@FindBy(id="document-date")
	private WebElement ship_searchclaimsRangeDropDown;

	@FindBy(xpath="//label[@for='claim-type']")
	private WebElement claimTypeLabel;

	@FindBy(xpath="//label[@for='provider-type']")
	private WebElement ship_claimTypeLabel;

	@FindBy(id="claim-type")
	private WebElement claimTypeDropDown;

	@FindBy(id="claim-provider")
	private WebElement ship_claimTypeDropDown;

	@FindBy(xpath="//div[@id='tableAtddFed']//div[contains(@class,'table-body-cell') and contains(text(),'Medical')]")
	private WebElement claimTypeJustMedical;

	@FindBy(xpath="//div[@id='tableAtddFed']//div[contains(@class,'table-body-cell') and contains(text(),'Prescription Drug')]")
	private WebElement claimTypeJustDrug;

	@FindBy(xpath = "//*[@id='IPerceptionsEmbed']")
	private WebElement WelcomePage_iPerceptionPresent;

	@FindBy(xpath="//div[contains(@class,'ReviewYourClaimsLanguage') and not(contains(@class,'ng-hide'))]")
	private WebElement reviewClaimsText;

	@FindBy(xpath="//div[contains(@class,'GeneralContentSHIP') and not(contains(@class,'ng-hide'))]")
	private WebElement ship_reviewClaimsText;

	@FindBy(xpath = "//*[@id='PoweredByiPerceptions']")
	private WebElement iPerceptionPopUp1;

	@FindBy(xpath = "//*[@id='closeButton']")
	private WebElement iPerceptionClose;

	@FindBy(xpath=".//*[@id='atddPagination']/p")
	private WebElement verifyClaimSummaryAndPagination1;

	/* tbd-remove @FindBy(xpath="//.[contains(text(),'Review your claims search results below or enter new dates to search again')]")
	private WebElement clamisSummCopyText; */

	@FindBy(xpath=".//*[@id='learnmoresummarytoggle']")
	private WebElement learmore;

	@FindBy(id="numDays1")
	private WebElement Youhave1;

	@FindBy(id="numDays2")
	private WebElement Youhave2;

	@FindBy(id="numDays3")
	private WebElement Youhave3;

	@FindBy(xpath=".//*[@id='globalContentIdForSkipLink']/div[3]/div[1]/div/div/div/div[2]/div/div[1]/section/div[2]/section/div/div/div/div/div/div/div[1]/p")
	private WebElement PCPtext;

	@FindBy(xpath="//*[@class='otherPages ReviewYourClaimsLanguage']//p")
	private WebElement clamsSummaryCopyText;

	@FindBy(xpath="//button[@id='all-claims-print-claims-btn']")
	private WebElement claimsSummaryPrintButton;

	@FindBy(xpath="//button[@id='all-claims-download-btn']")
	private WebElement claimsSummaryDownloadButton;

	@FindBy(xpath = "//div[contains(@class,'shipCompSection')]//select[@name='document-date']")
	private WebElement claimDropDownBoxForShip;	

	@FindBy(xpath = "//div[contains(@class,'fedCompSection')]//select[@name='document-date']")
	private WebElement claimDropDownBoxForFed;	

	@FindBy(xpath="//div[@id='tableAtddFed']//div[contains(text(),'Prescription Drug')]")
	public WebElement pdpPrescriptionDrug;

	@FindBy(xpath="//div[@id='twoValidDivErr']//p//span") 
	private WebElement greaterThanTwoYearsError;

	@FindBy(xpath="//div[@id='validDivErr']//p//span") 
	private WebElement greaterThan24monthsError;

	@FindBy(xpath="//span[@id='numClaims1']")	
	private WebElement numberOfClaims;

	@FindBy(xpath="//span[@id='numClaims3']")	
	private WebElement numberOfClaimsPrescriptionDrug;

	@FindBy(xpath="//span[@id='numClaims4']")	
	private WebElement numberOfClaimsPrescriptionDrugCustomSearch;

	@FindBy(xpath="//span[@id='numClaims5']")	
	private WebElement numberOfClaimsShip;

	@FindBy(xpath="//span[@id='numClaims6']")	
	private WebElement numberOfClaimsShipCustomSearch;

	@FindBy(xpath="//span[contains(@class,'days-title')]//span[@id='numClaims2']")
	private WebElement customSearchNumberOfClaims;

	@FindBy(xpath="//div[contains(@class,'shipCompSection')]//p[contains(@id,'validShipDivErr')]/..//p[2]//span")
	private WebElement greaterThan24monthsErrorShip;

	@FindBy(xpath=".//*[@id='ship' ]")
	private WebElement claimsTableShip;

	@FindBy(xpath="//b[contains(text(),'Claim Type')]/../../../../div[contains(text(),'Medical')]")
	private WebElement ma_medicalClaimTypeText;

	@FindBy(xpath="//b[contains(text(),'Claim Type')]/../../../../div[contains(text(),'Prescription')]")
	private WebElement pdp_prescriptionDrugClaimTypeText;

	@FindBy(xpath="//div[contains(@ng-if,'systemFailure')]//*[contains(text(),'system error')]")
	private WebElement systemErrorMsg;

	@FindBy(xpath="//*[@id='custom_from_date_ship']")
	private WebElement shipFrom;

	@FindBy(xpath="//*[@id='custom_to_date_ship']")
	private WebElement shipTo;

	@FindBy(xpath="//div[contains(@class,'shipCompSection')]//div[contains(@ng-if,'futureDateError')]//p//span")
	private WebElement fromDateLaterThanToDateErrorShip;

	@FindBy(xpath="//button[@id='customsearchbuttonShipBtn']")
	private WebElement shipSearchButton;

	@FindBy(xpath="//div[contains(@class,'EOBComponentMA') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Medical')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	private WebElement medicalEOB_MA;
	@FindBy(xpath="//div[contains(@class,'EOBComponentMA') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Prescription')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	private WebElement drugEOB_MA;

	@FindBy(xpath="//div[contains(@class,'EOBComponentMAPD') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Medical')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	private WebElement medicalEOB_MAPD;
	@FindBy(xpath="//div[contains(@class,'EOBComponentMAPD') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Prescription')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	private WebElement drugEOB_MAPD;

	@FindBy(xpath="//div[contains(@class,'EOBComponentPDP') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Medical')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	private WebElement medicalEOB_PDP;
	@FindBy(xpath="//div[contains(@class,'EOBComponentPDP') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Prescription')]/..//p[contains(text(),'SEARCH EOB HISTORY')]")
	private WebElement drugEOB_PDP;

	@FindBy(xpath="//div[contains(@class,'EOBComponentSHIP') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Ship')]/../p[contains(text(),'VIEW EOB STATEMENT')]")
	private WebElement EOB_SHIP;

	@FindBy(xpath="//a//span[text()='keyboard_arrow_left']")
	private WebElement leftArrowButton;
	@FindBy(xpath="//a//span[text()='keyboard_arrow_right']")
	private WebElement rightArrowButton;

	@FindBy(xpath="//div[@id='atddPagination']//p[contains(text(),'items found. Displaying 1 to')]")
	private WebElement itemsFoundDisplayingText;

	@FindBy(xpath="//p[contains(text(),'Not the claims you were expecting? Select a different date range to search again.')]")
	private WebElement notTheClaimsYouWereExpecting;

	@FindBy(xpath="//div[@id='prefix-overlay-step1']")
	private WebElement makeTheMostPopup;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	private WebElement comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	private WebElement comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan')]") 
	private WebElement comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	private WebElement comboTab_SSUP;

	@FindBy(xpath="//div[contains(@class,'AdobeAcrobatComponent') and not(contains(@class,'ng-hide'))]//p//b[contains(text(),'This page contains PDF documents')]")
	private WebElement pageContainsPdfDocText;

	@FindBy(xpath="//div[contains(@class,'EOBComponent') and not(contains(@class,'ng-hide'))]//*[contains(text(),'SEARCH')]")
	private WebElement searchAnyEobHistoryText;

	@FindBy(xpath="//div[contains(@class,'EOBComponent') and not(contains(@class,'ng-hide'))]//*[contains(text(),'VIEW EOB')]")
	private WebElement searchEobStatementsText;

	@FindBy(xpath="//p[contains(text(),'View your current prescription drug cost summary at')]//a[contains(text(),'OptumRx.com')]")
	private WebElement viewCurrentDrugCostText;

	@FindBy(xpath="//a[contains(text(),'OptumRx.com')]")
	private WebElement viewCurrentDrugCostLink;

	@FindBy(xpath="//div[@id='datesEmptyErrorContent']//p//span")
	private WebElement EmptyDatesError;

	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	private WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	private WebElement needHelp_TechicalSupportSection;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	private WebElement needHelp_TechicalSupport_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	private WebElement needHelp_TechicalSupport_phone;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	private WebElement needHelp_TechicalSupport_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	private WebElement needHelp_TechicalSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	private WebElement needHelp_TechicalSupport_wkEndHrs;

	//note: need help - general section
	@FindBy(xpath="//div[contains(@class,'general section')]")
	private WebElement needHelp_GeneralQuestionsSection;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[1]//img")
	private WebElement needHelp_GeneralQuestions_img;

	@FindBy(xpath="//div[contains(@class,'general section')]/div/div/p[1]")
	private WebElement needHelp_GeneralQuestions_phone;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[2]")
	private WebElement needHelp_GeneralQuestions_tty;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[3]")
	private WebElement needHelp_GeneralQuestions_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[4]")
	private WebElement needHelp_GeneralQuestions_wkEndHrs;

	//note: need help - claims section
	@FindBy(xpath="//div[contains(@class,'claims section')]")
	private WebElement needHelp_ClaimsSupportSection;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[1]//img")
	private WebElement needHelp_ClaimsSupport_img;

	@FindBy(xpath="//div[contains(@class,'claims section')]/div/div/div/p[1]")
	private WebElement needHelp_ClaimsSupport_phone;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[2]")
	private WebElement needHelp_ClaimsSupport_tty;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[3]")
	private WebElement needHelp_ClaimsSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[4]")
	private WebElement needHelp_ClaimsSupport_wkEndHrs;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	private WebElement needHelp_PlanSupportSection;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	private WebElement needHelp_PlanSupport_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	private WebElement needHelp_PlanSupport_phone;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	private WebElement needHelp_PlanSupport_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	private WebElement needHelp_PlanSupport_wkDayHrs;

	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	private WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	private WebElement needHelp_contactUsLink;

	@FindBy(id="eobC1")
	private WebElement EOB_claims;

	@FindBy(xpath="//h1[contains(text(),'Explanation of Benefits')]")
	private WebElement EOB_header;

	@FindBy(xpath="//p[contains(text(),'EOBs for your plan are currently not available on this site. We apologize for the inconvenience.')]")
	private WebElement EOB_errorMsg;

	@FindBy(xpath="//div[@class='otherPages EOBpagedescriptionPDP']//p[contains(text(),'Your monthly EOB shows a summary of the claims we ')]")
	private WebElement EOB_MsgForPDP;

	@FindBy(id = "claims_1")
	private WebElement claimsPageLink;

	@FindBy(xpath = "//main//li[@class='ng-scope']//a[1]")
	private WebElement ssup_Plan;

	@FindBy(xpath = "//p[contains(text(),'1-800-523-5880')]")
	public WebElement preEffectiveClaimsSupportNumber;

	@FindBy(xpath = "//h3[@class='needhelp h4 margin-none atdd-claims-header']")
	public WebElement preEffectiveClaimsSupportHeader;

	@FindBy(xpath ="//*[@id='atddUhcPagination']/li[3]/a")
	private WebElement paginationRightArrow;

	@FindBy(xpath ="//*[@id='moreInfoLinkAtdd2']/a")
	private WebElement specificclaimlinkforeob;

	@FindBy (id = "numClaims1")
	private WebElement medicalclaimsnumber;

	@FindBy (id = "numClaims3")
	private WebElement rxclaimsnumber;

	@FindBy(css = ".claimDetTableMainSection")
	public WebElement claimDetTableMainSection;

	//vvv note:	added for VBF	
	@FindBy(xpath = "//table[@id='ship']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))][count(//table[@id='ship']/tbody/tr/th/p[text() ='Provider']/parent::th/preceding-sibling::th)+1]")
	private WebElement vbf_shipProviderNameValue;

	@FindBy(xpath = "//table[@id='medical']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))]")
	private List<WebElement> vbf_medicalTableRow;

	@FindBy(xpath = "//table[@id='medical']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))][count(//table[@id='medical']/tbody/tr/th/p[contains(text(),'Provider Name')]/parent::th/preceding-sibling::th)+1]")
	private WebElement vbf_providerNameValue;

	@FindBy(xpath = "//table[@id='prescriptionDrug']/tbody/tr[2]/td[not (contains(@class,'ng-hide'))][not (contains(@class,'hidden-lg'))]")
	private List<WebElement> vbf_drugTableRow;

	@FindBy(xpath = "//table[@id='ship']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))]")
	private List<WebElement> vbf_shipTableRow;
	//^^^ note:	added for VBF			

	public ClaimSummarypage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}

	/**
	 * this method validates claims table and pagination
	 */
	public boolean verifyClaimsTableAndPagination(){
		try {
			if(validate (verifyClaimSummaryAndPagination)){
				System.out.println("Pagination is seen ===>"+verifyClaimSummaryAndPagination.getText());
				return true;
			}else{
				System.out.println("Pagination is not displayed as records are less");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @throws InterruptedException 
	 * this method validates Claims by time period 
	 */
	public void searchClaimsbyCustomDate(String planType,String claimPeriod) throws InterruptedException {
		customSearch = driver.findElement(By.id("dateCustomSearchAtdd"));
		validate (customSearch);

		customSearch = driver.findElement(By.id("dateCustomSearchAtdd"));
		customSearch.click();
		System.out.println("!!! Custom search is seen in the view Claims From drop down ===>"+(customSearch.getText()));
		System.out.println("!!! Validating the drop down to select the claims !!!");
	}

	/**
	 * Validate Pagination under the claims table  
	 */
	public boolean verifyClaimsTableAndPagination1(){ // This is pagination is verified for MAPD and working fine
		try{
			if(validate (verifyClaimSummaryAndPagination1))	{
				System.out.println("Pagination is seen ===>"+verifyClaimSummaryAndPagination.getText());
				return true;
			} else{
				System.out.println("Pagination is not displayed as records are less");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	

	/**
	 * validate the pagination on the claims summary page
	 */
	public boolean verifyClaimsTableAndPagination3(){
		CommonUtility.waitForPageLoadNew(driver, verifyClaimSummaryAndPagination3, 30);	   
		validateNew (verifyClaimSummaryAndPagination3);
		if (verifyClaimSummaryAndPagination3.isDisplayed())	{
			System.out.println("Pagination is seen ===>"+verifyClaimSummaryAndPagination3.getText());
			return true;
		} else {
			System.out.println("************Pagination is not displayed as records are less***************");
			return false;
		}
	}		
	
	/** 
	 * this method validates EOB 
	 */
	public boolean validateEobfordifferentClaimsSystem(String claimSystem, String plantype){
		if(plantype.equals("PCP")) {
			plantype = "MAPD";
			System.out.println("PCP new plan type is MAPD");
		}
		if (claimSystem.toUpperCase().contains("COSMOS")&& plantype.equals("MAPD"))	{
			System.out.println("for MAPD COSMOS  medical and precription drug EOB's are displayed===> "+ (medicalEobText.isDisplayed() && PrescriptionEobText.isDisplayed()));
			return medicalEobText.isDisplayed() && PrescriptionEobText.isDisplayed();
		} else if (claimSystem.toUpperCase().contains("NICE")&&plantype.equals("MAPD"))	{
			System.out.println("for MAPD NICE prescription drug EOB's are displayed ===>"+ (PrescriptionEobText.isDisplayed()));
			return PrescriptionEobText.isDisplayed();
		} else if ( (claimSystem.toUpperCase().contains("COSMOS")&&plantype.equals("MA"))) {
			validate(medicalEobText);
			System.out.println("for MA medical Eob is diplayed ====>"+ (medicalEobText.isDisplayed()));
			return medicalEobText.isDisplayed();
		} else if ((claimSystem.toUpperCase().contains("NICE")&&plantype.equals("MA")))	{
			System.out.println("Medical EOB is Displayed for MA NICE member" + (medicalEobText.isDisplayed()));
			return true;
		} else if ((claimSystem.toUpperCase().contains("COMPASS") && plantype.equals("SHIP"))){
			//SHIP CLAIMS EOB
			System.out.println("for SHIP Eob is diplayed ====>"+ (ShipClaimsEobText.isDisplayed()));
			return ShipClaimsEobText.isDisplayed();			
		} else if(claimSystem.toUpperCase().contains("RX")){
			System.out.println("for PDP prescription drug EOB's are diaplayed ====> "+ (PrescriptionEobText.isDisplayed()));
			return PrescriptionEobText.isDisplayed();
		} else{
			System.err.println("You have to pass the Correct Claims System  and Plan Type");
			System.out.println("please correct Claims System and Plan Type - current test used" +plantype + "&&" +claimSystem);
			Assert.fail();
			return false ;
		}
	}
	
	/**
	 * this method validates claims by time interval 
	 */
	public void searchClaimsByTimeInterval(String toDate, String fromDate) {
		System.out.println("The title of the page is-------->"+driver.getTitle());
		if(driver.getTitle().contains("Claims Summary")){
			sendkeys(from,fromDate);
			sendkeys(to,toDate);
			CommonUtility.waitForPageLoad(driver, searchButton,60);
			searchButton.click();
		}
	}

	/**
	 * @throws InterruptedException 
	 * this method validates Claims by time period 
	 */
	public void searchClaimsByTimePeriod(String planType,String claimPeriod) throws InterruptedException { // Need to debug and need to understand what it is doing	
		if(planType.contains("SHIP")){
			System.out.println("For ship case, locate the drop down box and select 24 months option");
			Select dropdown=new Select (claimDropDownBoxForShip);	
			dropdown.selectByVisibleText("Last 24 months");
			System.out.println("Clicked 24 months option");
		} else if (planType.contains("PDP")) {
			System.out.println("!!!Claim type PDP is validated !!!");
			Select dropdown=new Select (claimDropDownBoxForFed);	
			dropdown.selectByVisibleText("Last 24 months");
			System.out.println("Clicked 24 months option");
			validate(pdpPrescriptionDrug);
		} else if (planType.contains("MAPD") || planType.contains("MA")||planType.contains("PCP") || planType.contains("MEDICA")){
			System.out.println("!!! Validating the drop down to select the claims from last 24 months  !!!");
			last24months = driver.findElement(By.id("date24MAtdd"));
			last24months.click();
			System.out.println("!!! Month Selected from the view claims from drop down is ====>"+(last24months.getText()));
			validate (Medical);
			System.out.println("!! Claim type Medical is validated!!! ");
			validate (Medical);
			if (planType.contains("MAPD") || planType.contains("PCP")) {
				validate(PrescriptionDrug);
				System.out.println("!!!Claim type PDP is validated !!!");
				PrescriptionDrug.click();
				System.out.println("!!! Claim Type PDP is clicked !!!");
				validate(claimsTablePrescriptionDrug);
				System.out.println("!!! Claims Table PDP is seen on the Claims Summary page!!!");
				validate (RxNumberinthecalimstable);
				System.out.println("Element on the Rx table is ===>"+ RxNumberinthecalimstable.getText());
				System.out.println("!!! Claim Type Prescription Drug is Selected !!!");
				Medical.click();
			}
		} else {
			validate (customSearch);
			System.out.println("!!! Custom search is seen in the view Claims From drop down ===>"+(customSearch.getText()));
			System.out.println("!!! Validating the drop down to select the claims !!!");
		}
	}

	/**
	 * this method validates claims table
	 */
	public boolean validateClaimsTable() {
		CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage,60);
		validate(claimsTableMedical);
		System.out.println("!!! Claims Table is seen on the Claims Summary page!!!");
		if (validate(claimstablemoreinfolink)) {
			System.out.println("more info seen claim summary page ==>" +claimstablemoreinfolink);
		}
		Assert.assertTrue("PROBLEM - should not get System Error message on claim page", !validate(systemErrorMsg));
		if(claimsTableMedical.isDisplayed() || claimsTablePrescriptionDrug.isDisplayed() || claimsTableSHIP.isDisplayed()){
			if (claimsTableMedical.isDisplayed())System.out.println("!!! Claims Table is seen for Federal members on Claims Summary page!!!");
			else if (claimsTablePrescriptionDrug.isDisplayed())System.out.println("!!! Claims Table is seen for PDP members on Claims Summary page!!!");
			else if (claimsTableSHIP.isDisplayed())System.out.println("!!! Claims Table is seen for Ship  members on Claims Summary page!!!");
			return true;
		} else {
			System.out.println("!!!!!!!!! NOT Able to find the claim table !!!!!!!!! - MedicalTable="+claimsTableMedical.isDisplayed()+" | PrescriptionTable="+claimsTablePrescriptionDrug.isDisplayed()+" | ShipTable="+claimsTableSHIP.isDisplayed());
			Assert.assertTrue("PROBLEM - no claims table showing, check to see if test user has any claims or getting system error, test assumes user will have claims for the given test range so the claims table should have show accordingly - MedicalTable="+claimsTableMedical.isDisplayed()+" | PrescriptionTable="+claimsTablePrescriptionDrug.isDisplayed()+" | ShipTable="+claimsTableSHIP.isDisplayed(), false);
			return false;
		}
	}
	
	/**
	 * this method validates Error Max claims reached 
	 */
	public boolean validateRxReachexMaxClaimsErrorMsg() {
		return rxErrorMsg.isDisplayed();
	}

	/**
	 * this method validates Error greater than 24 months 
	 */
	public void validateShipGreaterThan24MonthsErrorMsg() {
		if (!shipDateRangeErrMsg.isDisplayed())
			Assert.fail(shipDateRangeErrMsg + "is not being displayed");
	}
	
	/**
	 * this method validates Error message greater than 24 months.
	 */	
	public void validateFedGreaterThan24MonthsErrorMsg() {
		validate(messageaftersrch);
		System.out.println("!!! The error message is seen. !!! ");
		messageaftersrch.isDisplayed();
		if(!messageaftersrch.isDisplayed())
			Assert.fail(messageaftersrch +"Is not being displayed");		
	}
	
	/**
	 * this method validates ERROR message from date later than to date 
	 */	
	public void  validatefromDateLaterThanToDateError() {
		if(!fromDateLaterThanToDateError.getText().contains("Your From date needs to come before or")) {
			Assert.fail(fromDateLaterThanToDateError + "is not beind dsiplayed");	
		}
	}
	
	/**
	 * this method validates combo tab section
	 */
	public ClaimSummarypage comboTabSelection(){
		for (WebElement webElement : comboTabsOnclaimsPage) {
			System.out.println(webElement.getText());
			webElement.click();
			try {
				CommonUtility.waitForPageLoadNew(driver, last24months, 10);	
				last24months = driver.findElement(By.xpath("//div[@class='medical-claims']//h2[@ng-bind-html='planName']/parent::div//*[@id='document-date']//option[contains(@value,'24 months')]"));
				last24months.click();
				validateClaimsTable();
				if (validateClaimsTable() == true)
					break;
			} catch (Exception e) {
				last24months = driver.findElement(By.xpath("//div[@class='medical-claims shipCompSection']//div//*[@id='document-date']//option[contains(@value,'24 months')]"));
				last24months.click();
				validateClaimsTable();
				if (validateClaimsTable() == true)
					break;
				e.printStackTrace();
			}
		}
		return new ClaimSummarypage(driver);
	}

	/**
	 * Validate error message for PHIP member on Claims Summary page
	 */
	public boolean ValidatePHIPErrorMessage() throws InterruptedException{ //Need to identify the PHIP member
		CommonUtility.waitForPageLoadNew(driver, PHIPerrorMsg, 5);	

		validate(PHIPerrorMsg);		
		if (PHIPerrorMsg.isDisplayed()){			
			System.out.println("*************Error Message Displayed for PHIP Member on claims Summary page***************");
			System.out.println("*************Error Message : "+PHIPerrorMsg.getText()+"***************");
			return true;
		} else
			System.out.println("************Error message not displayed for PHIP Member on claims Summary page ***************");
		return false;
	}

	/**
	 * This Meathod is to validate the You have XX medical/RX claims from the Last XX days Text 
	 * This Need to be re-write the logic
	 */
	public void validateYouHavemessage(String planType) {
		CommonUtility.checkPageIsReadyNew(driver);
		try {// As of now i am keepting it in try block as i need to run for more members and need to write a logic like NICE SHIP RX is pending 
			System.out.println("medical claims - Member Has ========> "+ ":"+ (medicalclaimsnumber.getText())+ " Claims");//This is working for MA and MAPD COSMOS or NICE 
			System.out.println("rx claims      - Member Has ========> "+ ":"+ (rxclaimsnumber.getText())+ " Claims"); 
		} catch (Exception e) {
		} 
		WebElement e=Youhave3;
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - Unable to locate the 'You have...' message on page", validate(e));
		} else {
			if(validate(Youhave1)) {
				e=Youhave1;
			} else if (validate(Youhave2)) {
				e=Youhave2;
			}
			Assert.assertTrue("PROBLEM - Unable to locate the 'You have...' message on page", validate(Youhave1) || validate(Youhave2));
		}
		String expText="You have";
		Assert.assertTrue("PROBLEM - 'You have...' message on page is not as expected.  Expected to contain='' | Actual msg='"+e.getText()+"'", (e.getText()).contains(expText));
	} 

	public void validateClaimsHeaderCopyText() {
		if (clamsSummaryCopyText.getText().contains("Review your claims search")) 
			Assert.assertTrue(clamsSummaryCopyText.getText().contains("Review your claims search") + "copy text is displayed", true);
	}

	/**
	 * Validate claims FROM DROP DOWN
	 */
	public void validateClaimsSummaryHeaderSection(String planType, String memberType) {
		//note: validate page title
		String expPageTitle="Claims Summary";
		Assert.assertTrue("PROBLEM - not getting expected page title for claims summary page. Expected to contains="+expPageTitle+" | Actual="+driver.getTitle(), driver.getTitle().contains(expPageTitle));
		System.out.println("The title of Claims page is-------->"+driver.getTitle());

		if (memberType.toLowerCase().contains("combo")) {
			validateComboTabs();
			goToSpecificComboTab(planType);
		}
		
		//note: validate header element
		String expPageHeadingText="Claims Summary";
		Assert.assertTrue("PROBLEM - unable to locate page header element on claims summary page", validate(pageHeader));
		Assert.assertTrue("PROBLEM - not getting expected page header text on claims summary page. Expected="+expPageHeadingText+" | Actual="+pageHeader.getText(), expPageHeadingText.equals(pageHeader.getText()));
		System.out.println("The header text-------->"+pageHeader.getText());

		if (planType.equalsIgnoreCase("SHIP")) {
			String expSubHeader="My Supplement Insurance Plan Claims";
			Assert.assertTrue("PROBLEM - unable to locate sub header element on claims summary page for SHIP user", validate(ship_subPageHeader));
			Assert.assertTrue("PROBLEM - "+expSubHeader+"' label text is not as expected.  Expected="+expSubHeader+" | Actual="+ship_subPageHeader.getText(), ship_subPageHeader.getText().equals(expSubHeader));

			//note: validate plan name element
			Assert.assertTrue("PROBLEM - unable to locate plan name element on claims summary page", validate(ship_planName));
			System.out.println("The Plan Name is ===>"+(ship_planName.getText()));

			//note: validate claims date range search dropdown options
			String expViewClaimsLabelText="View Claims From:";
			Assert.assertTrue("PROBLEM - unable to locate '"+expViewClaimsLabelText+"' label element on claims summary page", validate(ship_viewclaimsFromLabel));
			Assert.assertTrue("PROBLEM - "+expViewClaimsLabelText+"' label text is not as expected.  Expected="+expViewClaimsLabelText+" | Actual="+ship_viewclaimsFromLabel.getText(), ship_viewclaimsFromLabel.getText().equals(expViewClaimsLabelText));
			Assert.assertTrue("PROBLEM - unable to locate '"+expViewClaimsLabelText+"' dropdown element on claims summary page", validate(ship_searchclaimsRangeDropDown));

			System.out.println("Validating provider dropdown options for planType="+planType+" scenario...");
			//note: All Providers or more depends on if claims...validate it has >=1
			String expClaimTypeLabelText="From Provider:";
			List<String> expTypeOptionsList=new ArrayList<String>();
			expTypeOptionsList.add("All Providers");
			int expNumTypeOptions=expTypeOptionsList.size();
			Select ship_claimTypeSelect = new Select(ship_claimTypeDropDown);
			Assert.assertTrue("PROBLEM - default search claims date range dropdown option is not as expected.  Expected='"+expTypeOptionsList.get(0)+"' | Actual='"+ship_claimTypeSelect.getFirstSelectedOption().getText()+"'", (expTypeOptionsList.get(0)).equals(ship_claimTypeSelect.getFirstSelectedOption().getText()));
			Assert.assertTrue("PROBLEM - number of '"+expClaimTypeLabelText+"' drop down optons is not as expected on claims summary page.  Expected="+expNumTypeOptions+" | Actual="+ship_claimTypeSelect.getOptions().size(), ship_claimTypeSelect.getOptions().size()>=expNumTypeOptions);
			System.out.println("Due to user data often changed, will not validate list of available providers from the drop down.  Will only printout the list of providers");
			for(int i=0;i<ship_claimTypeSelect.getOptions().size();i++){
				System.out.println("Located dropdown option =>"+ship_claimTypeSelect.getOptions().get(i).getText());
			} 	
			//note: validate 'review your claims' element exists
			Assert.assertTrue("PROBLEM - Unable to locate the 'Review your claims...' element", validate(ship_reviewClaimsText));
		} else {
			//note: validate plan name element
			Assert.assertTrue("PROBLEM - unable to locate plan name element on claims summary page", validate(planName));
			System.out.println("The Plan Name is ===>"+(planName.getText()));

			//note: validate claims date range search dropdown options
			String expViewClaimsLabelText="View Claims From:";
			Assert.assertTrue("PROBLEM - unable to locate '"+expViewClaimsLabelText+"' label element on claims summary page", validate(viewclaimsFromLabel));
			Assert.assertTrue("PROBLEM - "+expViewClaimsLabelText+"' label text is not as expected.  Expected="+expViewClaimsLabelText+" | Actual="+viewclaimsFromLabel.getText(), viewclaimsFromLabel.getText().equals(expViewClaimsLabelText));
			Assert.assertTrue("PROBLEM - unable to locate '"+expViewClaimsLabelText+"' dropdown element on claims summary page", validate(searchclaimsRangeDropDown));

			List<String> expOptionsList=new ArrayList<String>();
			expOptionsList.add("Last 30 days");
			expOptionsList.add("Last 90 days");
			expOptionsList.add("Last 6 months");
			expOptionsList.add("Last 12 months");
			expOptionsList.add("Last 24 months");
			expOptionsList.add("Custom search");
			Select RangeSelect = new Select(searchclaimsRangeDropDown);
			Assert.assertTrue("PROBLEM - default search claims date range dropdown option is not as expected.  Expected="+expOptionsList.get(1)+" | Actual="+RangeSelect.getFirstSelectedOption().getText(), (expOptionsList.get(1)).equals(RangeSelect.getFirstSelectedOption().getText()));
			System.out.println("Default selected option is  =>" +RangeSelect.getFirstSelectedOption().getText());
			int expNumOptions=6;
			Assert.assertTrue("PROBLEM - number of '"+expViewClaimsLabelText+"' drop down optons is not as expected on claims summary page.  Expected="+expNumOptions+" | Actual="+RangeSelect.getOptions().size(), RangeSelect.getOptions().size()==expNumOptions);
			for(int i=0;i<RangeSelect.getOptions().size();i++){
				Assert.assertTrue("PROBLEM - dropdown option value/order is not as expected.  Expected="+expOptionsList.get(i)+" | Actual="+RangeSelect.getOptions().get(i).getText(), (expOptionsList.get(i)).equals(RangeSelect.getOptions().get(i).getText()));
				System.out.println("Located dropdown option =>"+RangeSelect.getOptions().get(i).getText());
			} 	

			//note: validate claims type search dropdown options
			String expClaimTypeLabelText="Claim Type:";
			Assert.assertTrue("PROBLEM - unable to '"+expClaimTypeLabelText+"' label element on claims summary page", validate(claimTypeLabel));
			Assert.assertTrue("PROBLEM - "+expClaimTypeLabelText+"' label text is not as expected.  Expected="+expClaimTypeLabelText+" | Actual="+claimTypeLabel.getText(), claimTypeLabel.getText().equals(expClaimTypeLabelText));

			System.out.println("Validating claimType dropdown options for planType="+planType+" scenario...");
			if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("SSUP")) {
				//note: only Medical
				Assert.assertTrue("PROBLEM - unable to locate 'Medical' for Claim Type field on claims summary page", validate(claimTypeJustMedical));
			} else if (planType.equalsIgnoreCase("PDP")) {
				//note: only Prescription drug
				Assert.assertTrue("PROBLEM - unable to locate 'Prescription drug' for Claim Type field on claims summary page", validate(claimTypeJustDrug));
			} else {
				//note: both Medical and Prescription drug
				Assert.assertTrue("PROBLEM - unable to locate '"+expClaimTypeLabelText+"' dropdown element on claims summary page", validate(claimTypeDropDown));
				List<String> expTypeOptionsList=new ArrayList<String>();
				expTypeOptionsList.add("Medical");
				expTypeOptionsList.add("Prescription drug");
				int expNumTypeOptions=expTypeOptionsList.size();
				Select claimTypeSelect = new Select(claimTypeDropDown);
				Assert.assertTrue("PROBLEM - default search claims date range dropdown option is not as expected.  Expected='"+expTypeOptionsList.get(0)+"' | Actual='"+claimTypeSelect.getFirstSelectedOption().getText()+"'", (expTypeOptionsList.get(0)).equals(claimTypeSelect.getFirstSelectedOption().getText()));
				Assert.assertTrue("PROBLEM - number of '"+expClaimTypeLabelText+"' drop down optons is not as expected on claims summary page.  Expected="+expNumTypeOptions+" | Actual="+claimTypeSelect.getOptions().size(), claimTypeSelect.getOptions().size()==expNumTypeOptions);
				for(int i=0;i<claimTypeSelect.getOptions().size();i++){
					Assert.assertTrue("PROBLEM - dropdown option value/order is not as expected.  Expected='"+expTypeOptionsList.get(i)+"' | Actual='"+claimTypeSelect.getOptions().get(i).getText()+"'", (expTypeOptionsList.get(i)).equals(claimTypeSelect.getOptions().get(i).getText()));
					System.out.println("Located dropdown option =>"+claimTypeSelect.getOptions().get(i).getText());
				} 	
			}
			//note: validate 'review your claims' element exists
			Assert.assertTrue("PROBLEM - Unable to locate the 'Review your claims...' element", validate(reviewClaimsText));
		}
	}	

	public void validateLearnmoreaboutsection1(){
		validate(learmore);
		System.out.println("***Laearn More link is seen on the claim summart page ***");
	}

	public void validateClaimsPlantype() {
		Select select = new Select(claimTypeDropDown);
		System.out.println("Slected value is  =>" +select.getFirstSelectedOption().getText());
		for(int i=0;i<select.getOptions().size();i++){
			System.out.println(select.getOptions().get(i).getAttribute("value"));
		}
	}

	public ClaimDetailsPage navigateToClaimDetailsPage()  {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoadNew(driver, claimstablemoreinfolink, 60);
		scrollToView(claimsSummaryPrintButton);
		claimstablemoreinfolink.click();
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver,claimDetTableMainSection , 10);
		while(!(driver.getCurrentUrl().contains("/details")));
		if (driver.getCurrentUrl().contains("/details")) {
			return new pages.regression.claims.ClaimDetailsPage(driver);
		}
		return null;
	}

	public ClaimSummarypage comboTabSelection1(){
		CommonUtility.checkPageIsReadyNew(driver);
		for (WebElement webElement : comboTabsOnclaimsPage) {
			System.out.println(webElement.getText());
			webElement.click();
		}
		return new ClaimSummarypage(driver);	
	}

	public void validatePCPtext(){
		Assert.assertTrue("PROBLEM - unable to locate PCPtext element", validate(PCPtext));
		System.out.println("PCP text is seen on the page" + PCPtext.getText());
	}

	/**
	 * Validate EOB section for PDP plans 
	 */
	public void validateEobPDP(){
		CommonUtility.waitForPageLoadNew(driver, PrescriptionEobText1, 10);
		validate(PrescriptionEobText1);
		System.out.println("PDP EOB is displayed"  +  PrescriptionEobText.isDisplayed());
	}

	/**
	 * Validate claims table for PDP plans
	 */
	public void validateClaimsTablePDP() {
		CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage,60);
		validate(claimsTablePrescriptionDrug);
		System.out.println("!!! Claims Table is seen on the Claims Summary page!!!"+claimsTablePrescriptionDrug.isDisplayed());
	}

	/**
	 * this method checks that Claims Summary Sub Navigation Link 
	 * under Claims is NOT displayed
	 */
	public void validateClaimsSummarySubNavNotDisplayed() throws InterruptedException {
		System.out.println("Now checking for claims summary sub navigation of Claims");
		Dimension size = driver.findElement(By.id("claimsummaryC1")).getSize();
		System.out.println(size);
		int height = size.getHeight();
		System.out.println("Height is "+height);
		int width = size.getWidth();
		System.out.println("Width is "+width);
		if (height == 0) {
			System.out.println("Claims Summary Sub Navigation Link under Claims was NOT displayed");
		} else {
			System.out.println("Claims Summary Sub Navigation Link under Claims was displayed, Test step is failed due to it");
			Assert.fail("Claims Summary Sub Navigation Link under Claims was displayed, Test step is failed due to it");	
		}
	}	

	public void validateExplanationOfBenefitsSubNavNotDisplayed() throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, driver.findElement(By.id("eobC1")), 5);
		System.out.println("Now checking for Explanation of benefits sub navigation of Claims");

		Dimension size = driver.findElement(By.id("eobC1")).getSize();
		System.out.println(size);
		int height = size.getHeight();
		System.out.println("Height is "+height);
		int width = size.getWidth();
		System.out.println("Width is "+width);
		if (height == 0) {
			System.out.println("Explanation of Benefits Sub Navigation Link under Claims was NOT displayed");
		} else {
			System.out.println("Explanation of Benefits Sub Navigation Link under Claims was displayed, Test step is failed due to it");
			Assert.fail("Explanation of Benefits Sub Navigation Link under Claims was displayed, Test step is failed due to it");	
		}
	}	

	public void validateExplanationOfBenefitsSubNavNotDisplayedForSSUP() throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, EOB_claims, 5);
		System.out.println("Now checking for Explanation of benefits sub navigation of Claims");
		try {
			EOB_claims.isDisplayed();
			System.out.println("Explanation of Benefits Sub Navigation Link under Claims was displayed");
			Assert.fail("Explanation of Benefits Sub Navigation Link under Claims was displayed, Test step is failed due to it");
		} catch (Exception e) {
			System.out.println("Explanation of Benefits Sub Navigation Link under Claims was NOT displayed, Test step is passed due to it");
		}
	}

	public void validateExplanationOfBenefitsSubNavDisplayedForGroupSSUP() throws InterruptedException 
	{
		CommonUtility.waitForPageLoad(driver, EOB_claims, 5);
		System.out.println("Now checking for Explanation of benefits sub navigation of Claims");
		EOB_claims.click();
		CommonUtility.checkPageIsReady(driver);
		try {
			validateNew(EOB_claims);
			validateNew(EOB_header);
			validateNew(EOB_MsgForPDP);
			System.out.println("Explanation of Benefits page for PDP plan through Sub Navigation Link under Claims was displayed");
		} catch (Exception e) {
			System.out.println("Explanation of Benefits page for PDP plan through Sub Navigation Link under Claims was not displayed");
			Assert.fail("Explanation of Benefits page for PDP plan through Sub Navigation Link under Claims was not displayed");
		}
		// below code will validate same page for SSUP	plan	
		System.out.println("Now checking for Explanation of benefits page for SSUP plan");
		claimsPageLink.click();
		CommonUtility.checkPageIsReady(driver);
		try {
			validateNew(EOB_claims);
			validateNew(ssup_Plan);

			ssup_Plan.click();
			CommonUtility.checkPageIsReady(driver);
			System.out.println("SSUP plan has been selected");
			EOB_claims.click();
			CommonUtility.checkPageIsReady(driver);
			validateNew(EOB_MsgForPDP);
			System.out.println("Explanation of Benefits page for SSUP plan through Sub Navigation Link under Claims was displayed as PDP Plan, Test step is passed due to it");
		} catch (Exception e) {
			System.out.println("Explanation of Benefits page for SSUP plan through Sub Navigation Link under Claims was not displayed as PDP Plan, Test step is failed due to it");
			Assert.fail("Explanation of Benefits page for SSUP plan through Sub Navigation Link under Claims was not displayed as PDP Plan, Test step is failed due to it");
		}
	}

	public void invokeEOBDeepLink() throws InterruptedException 
	{
		CommonUtility.checkPageIsReady(driver);
		//tbd Thread.sleep(2000);  
		System.out.println("Now invoking the deep link of Explanation of benefits");
		if (MRScenario.environmentMedicare.equalsIgnoreCase("team-h")){
			startNew("https://www.team-h-medicare.ocp-ctc-dmz-nonprod.optum.com/aarp/member/eob.html");
		} else if((MRScenario.environmentMedicare.equalsIgnoreCase("Stage"))){
			startNew("https://stage-medicare.uhc.com/aarp/member/eob.html");
		}
		try {
			CommonUtility.waitForPageLoad(driver, EOB_claims, 5);
			EOB_claims.isDisplayed();
			System.out.println("Explanation of Benefits Sub Navigation Link under Claims was displayed");
			Assert.fail("Explanation of Benefits Sub Navigation Link under Claims was displayed, Test step is failed due to it");
		} catch (Exception e) {
			System.out.println("Explanation of Benefits Sub Navigation Link under Claims was NOT displayed, Working as expected for SSUP member");
			validateNew(EOB_header);
			validateNew(EOB_errorMsg);
			System.out.println("EOB page with the message 'EOBs for your plan are currently not available on this site. We apologize for the inconvenience.' is displaying ");
		}
	}

	public void verifyCorrectMessageForPreEffectiveMembers() throws InterruptedException 
	{
		CommonUtility.waitForPageLoad(driver, messageForPreeffective, 5);
		System.out.println("Now checking for message on Claims Page for Pre-effective members");
		System.out.println("The message displayed on screen is "+messageForPreeffective.getText());
		String expText="When your plan starts,";
		Assert.assertTrue("PROBLEM - Correct message is not displayed. Expected msg contains '"+expText+"' | Actual='"+messageForPreeffective.getText()+"'", messageForPreeffective.getText().contains(expText));
		System.out.println("Assert for preeffective message on claims page was passed");
	}


	public void verifyCorrectTechSupportNumberForPreEffectiveMembers() throws InterruptedException {
		System.out.println("Now checking for Tech Support Number for Pre-effective members on claims page");
		System.out.println("The Tech Support phone number displayed on screen is "+preEffectiveTechSupportNumber.getText());
		String expPhone="1-866-254-3132";
		Assert.assertEquals("PROBLEM - not getting expected phone#.  Expected='"+expPhone+"' | Actual='"+preEffectiveTechSupportNumber.getText()+"'", preEffectiveTechSupportNumber.getText(),expPhone);
		System.out.println("Assert for correct Tech Suppport Phone Number on claims page was passed");
	}
	
	public void verifyPaymentTabIsDisplayedForPreEffectiveMembers() throws InterruptedException {
		Assert.assertTrue("PROBLEM - unable to locate Payment tab",(driver.findElement(By.xpath("//a[contains(text(),'Premium Payments')]"))).isDisplayed());
		System.out.println("Premium Payment tab was displayed on Claims secondary page");
	}

	public static void checkForIPerceptionModel(WebDriver driver) {
		int counter = 0;
		do {

			System.out.println("current value of counter: " + counter);
			List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

			if (IPerceptionsFrame.isEmpty()) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}

			} else {
				driver.switchTo().frame(IPerceptionsFrame.get(0));
				driver.findElement(By.className("btn-no")).click();
				driver.switchTo().defaultContent();
			}
			counter++;
		} while (counter < 2);
	}

	public boolean validateLearnMoreAndPrintAndDownloadOptionExistAndWork() {
		if (validate (learnMoreAboutClaims) && validate(claimsSummaryPrintButton) && validate(claimsSummaryDownloadButton)) {
			//note: validate learn more
			learnMoreAboutClaims.click();
			if (validate(learnMoreAboutClaimsContent)) {
				Assert.assertTrue("PROBLEM - unable to locate the 'Learn More..' content after clicking link", validate(learnMoreAboutClaimsContent));
			} else {
				System.out.println("This planType doesn't have any additional Learn More content.  Author driven content, will not flag this.");
			}

			//note: validate download
			try {
			claimsSummaryDownloadButton.click();
			} catch(Exception e) {
				Assert.assertTrue("PROBLEM - encounted exception when attempting to click donwload button", false);
			}

			//note: validate print
			String winHandleBefore = driver.getWindowHandle();
			claimsSummaryPrintButton.click();
			try {
				Thread.sleep(2000); //note: need this sleep otherwise the drive will be NPE when check page is ready
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//note: need to dynamically determine the number of tabs because if running offline prod then extra tab
			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();					
			driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));

			CommonUtility.checkPageIsReady(driver);
			System.out.println("New window for print = "+driver.getTitle());
			String expPrintPageTitle="Print: My Claims Details";
			Assert.assertTrue("PROBLEM - print page title is not as expected.", driver.getTitle().contains(expPrintPageTitle));
			driver.close();
			driver.switchTo().window(winHandleBefore);
			System.out.println("Main window = "+driver.getTitle());	
			return true;
		} else
			return false;
	} 

	public ProfileandPreferencesPage navigateDirectToProfilePage() {
		if(driver.findElement(By.id("accountprofile")).isDisplayed()){
			driver.findElement(By.id("accountprofile")).click();
			driver.findElement(By.linkText("Account Settings")).click();
		} else
			Assert.fail("Account profile dropdown not found");
		CommonUtility.waitForPageLoadNew(driver, driver.findElement(By.xpath("//h1[contains(text(),'Account Settings')]")),20 );
		if (driver.getCurrentUrl().contains("profile")) {
			System.out.println("Landed on Account Settings page");
			return new ProfileandPreferencesPage(driver);
		}
		return null;
	}

	public void validateGreaterThanTwoYearError(String planType) {
		String errorTextContent1="The time between your From date and your To date cannot be more than 24 months.For help with claims older than 24 months, call Customer Service at the number listed on the Contact Us web page.";
		String errorTextContent2="For information about claims older than 2 years, contact Customer Service toll-free at 1-800-523-5880.";
		if (planType.equals("SHIP")) {
			Assert.assertTrue(greaterThan24monthsErrorShip + "is not beind dsiplayed", validate(greaterThan24monthsErrorShip));
			Assert.assertTrue("error text is not as expected. \nExpected="+errorTextContent1+" \nActual="+greaterThan24monthsErrorShip.getText(), greaterThan24monthsErrorShip.getText().contains(errorTextContent1));
		} else {
			Assert.assertTrue(greaterThan24monthsError + "is not beind dsiplayed", validate(greaterThan24monthsError));
			Assert.assertTrue("error text is not as expected. \nExpected="+errorTextContent1+" \nActual="+greaterThan24monthsError.getText(), greaterThan24monthsError.getText().contains(errorTextContent1));

			Assert.assertTrue(greaterThanTwoYearsError + "is not beind dsiplayed", validate(greaterThanTwoYearsError));
			Assert.assertTrue("error text is not as expected. \nExpected="+errorTextContent2+" \nActual="+greaterThanTwoYearsError.getText(), greaterThanTwoYearsError.getText().contains(errorTextContent2));
		}
	}

	public int getNumClaims(String range, String claimType) {
		CommonUtility.checkPageIsReadyNew(driver);
		// note: do not modify this check - critical to wait
		int extra=2000;
		int x=0;
		while(x<45) {
			try {
				Thread.sleep(1000);
				if (validate(verifyClaimSummaryAndPagination)) {
					Thread.sleep(extra); //give it more time to settle the page
					System.out.println("sleep for another 2 sec for the page to settle down...");
					System.out.println("there is some indication of claims...let's check it out");
					break;
				}
			} catch (InterruptedException e) {}
			x=x+1;
		}
		System.out.println("Waited total of "+(x*1000+extra)+" seconds for claims to show up");

		WebElement numClaimsElement=numberOfClaims;
		if (range.equalsIgnoreCase("custom search")) {
			if (claimType.equalsIgnoreCase("prescription drug")) {
				numClaimsElement=numberOfClaimsPrescriptionDrugCustomSearch;
			} else if (claimType.equalsIgnoreCase("medical")) {
				if (validate(customSearchNumberOfClaims)) {
					numClaimsElement=customSearchNumberOfClaims;
				} 
			} else {
				numClaimsElement=numberOfClaimsShipCustomSearch;
			}
		} else {
			if (claimType.equalsIgnoreCase("prescription drug")) {
				numClaimsElement=numberOfClaimsPrescriptionDrug;
			} else if (claimType.equalsIgnoreCase("medical")) {
				numClaimsElement=numberOfClaims;
			} else {
				numClaimsElement=numberOfClaimsShip;
			}
		}
		Assert.assertTrue("PROBLEM - unable to lcoate the element for number of claims for range="+range, validate(numClaimsElement));
		try {
			int numClaims=Integer.valueOf(numClaimsElement.getText().trim());
			System.out.println("numClaims="+numClaims);	
			return numClaims;
		} catch (Exception e) {
			System.out.println("Exception e: "+e);
			Assert.assertTrue("PROBLEM: Unable to locate the value for number of claim for given range="+range,false);
		}
		return 0;
	}

	public void searchClaimsByTimePeriodClaimType(String planType,String claimPeriod, String claimType) throws InterruptedException {
		//note: MA - Medical; MAPID | PCP - Medical & Prescription drug; PDP - Prescription drug; SHIP - no Medical or Prescription drug
		if(planType.equals("SHIP")){
			System.out.println("For ship case, locate the drop down box and select '"+claimPeriod+"' option");
			Select dropdown=new Select (claimDropDownBoxForShip);	
			dropdown.selectByVisibleText(claimPeriod);
			System.out.println("Clicked '"+claimPeriod+"' option");
		} else if (planType.contains("PDP")) {
			System.out.println("!!!Claim type PDP is validated !!!");
			Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the prescription drug option",validate(pdp_prescriptionDrugClaimTypeText));
			Select dropdown=new Select (claimDropDownBoxForFed);	
			dropdown.selectByVisibleText(claimPeriod);
			System.out.println("Clicked '"+claimPeriod+"' option");
		} else if (planType.equals("MAPD") || planType.equals("MA") || planType.equals("SSUP") || planType.equals("PCP") || planType.equals("MEDICA")){
			WebElement option=null;
			if (claimPeriod.equals("Last 30 days")) {
				option = driver.findElement(By.id("date30Atdd"));
			} else if (claimPeriod.equals("Last 90 days")) {
				option = driver.findElement(By.id("date90Atdd"));
			} else if (claimPeriod.equals("Last 6 months")) {
				option = driver.findElement(By.id("date6MAtdd"));
			} else if (claimPeriod.equals("Last 12 months")) {
				option = driver.findElement(By.id("date12MAtdd"));
			} else if (claimPeriod.equals("Last 24 months")) {
				option = driver.findElement(By.id("date24MAtdd"));
			} else if (claimPeriod.equals("Custom search")) {
				option = driver.findElement(By.id("dateCustomSearchAtdd"));
			}
			System.out.println("!!! Validating the drop down to select the claims from '"+claimPeriod+"'  !!!");
			option.click();
			System.out.println("!!! Option selected from the view claims from drop down is ====>"+(option.getText()));

			if (planType.equals("MA") || planType.equals("SSUP")) {
				Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the medical option",validate(ma_medicalClaimTypeText));
			}

			System.out.println("!! Claim type Medical is validated!!! ");
			if ((planType.equals("MAPD") || planType.equals("PCP") || planType.equals("MEDICA")) && claimType.equalsIgnoreCase("prescription drug")) {
				Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the prescription drug option",validate(PrescriptionDrug));
				System.out.println("!!!Claim type PrescriptionDrug is validated !!!");
				PrescriptionDrug.click();
				System.out.println("!!! Claim Type PrescriptionDrug is clicked !!!");
			} else if ((planType.equals("MAPD") || planType.equals("PCP") || planType.equals("MEDICA")) && claimType.equalsIgnoreCase("medical")) {
				Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the medical option",validate(Medical));
				// note: MAPD has both medical and prescription drug options
				// for MA case there will be just medical so there won't be a need for click
				Medical.click();
			}
		} else{
			validate (customSearch);
			System.out.println("!!! Custom search is seen in the view Claims From drop down ===>"+(customSearch.getText()));
			System.out.println("!!! Validating the drop down to select the claims !!!");
		}
	}

	public boolean verifyDownloadMyDataAndLearnMoreAndPrintAndDownloadOptions(int numClaims, String planType) {
		CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage,60);
		boolean result=true;
		if (numClaims >0) {
			if (!validateLearnMoreAndPrintAndDownloadOptionExistAndWork()) {
				System.out.println("locate 'Learn More About Your Claims' link result="+validate(learnMoreAboutClaims));
				System.out.println("locate 'Print' button result="+validate(claimsSummaryPrintButton));
				System.out.println("locate 'Download Claims' button result="+validate(claimsSummaryDownloadButton));
				System.out.println("locate 'DownloadMyData' button result="+validate(downloadmydatabutton));
				result=false;
			}
			System.out.println("Has claim(s), Got the expected behavior, able to locate 'Learn More About Your Claims' link and 'PRINT' and 'DOWNLOAD CLAIMS' buttons");
		} else {
			if (validate (learnMoreAboutClaims) || validate(claimsSummaryPrintButton) || validate(claimsSummaryDownloadButton)) {
				System.out.println("locate 'Learn More About Your Claims' link result="+validate(learnMoreAboutClaims));
				System.out.println("locate 'Print' button result="+validate(claimsSummaryPrintButton));
				System.out.println("locate 'Download Claims' button result="+validate(claimsSummaryDownloadButton));
				result=false;
			}
			System.out.println("Has no claim, Got the expected behavior and didn't see 'Learn More About Your Claims' link and 'PRINT' and 'DOWNLOAD CLAIMS'");
		}
		if (planType.equalsIgnoreCase("SHIP")) {
			//note: ship user doesn't have DownloadMyData button
			if (validate(downloadmydatabutton)) {
				System.out.println("locate 'DownloadMyData' button result="+validate(downloadmydatabutton));
				result=false;
			}
			System.out.println("Got the expected behavior where 'DownloadMyData' button not exist for SHIP user ");
		} else {
			//note: all other users should have DownloadMyData button 
			if (!validateDownloadMyDataExistsAndWorks()) {
				System.out.println("validateDownloadMyDataExistsAndWorks failed");
				result=false;
			}
			System.out.println("Got the expected 'DownloadMyData' button");
		}
		return result;
	}

	public HashMap<String,String> gatherDataFromSummaryPage(String claimType, int rowNum, String claimSystem, boolean hasYourShare) {
		HashMap<String,String> dataMap=new HashMap<String,String> ();
		//note: for claim summary medical table
		if (claimType.equalsIgnoreCase("medical")) {
			String xpath="//table[@id='medical']//tr["+rowNum+"]//td[2]";
			String key="med_dateOfService";
			WebElement element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			String value=element.getText().trim();
			dataMap.put(key, convertDateFormat(value));

			xpath="//table[@id='medical']//tr["+rowNum+"]//td[3]";
			key="med_providerName";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='medical']//tr["+rowNum+"]//td[4]";
			key="med_providerType";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='medical']//tr["+rowNum+"]//td[5]";
			key="med_amountBilled";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='medical']//tr["+rowNum+"]//td[6]";
			key="med_claimStatus";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="med_yourShare";
			if (hasYourShare) {
				if (claimSystem.contains("NICE")) {
					xpath="//table[@id='medical']//tr["+rowNum+"]//td[8]";
				} else {
					xpath="//table[@id='medical']//tr["+rowNum+"]//td[7]";
				}
				element=driver.findElement(By.xpath(xpath));
				Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
				value=element.getText().trim();
				dataMap.put(key, value);
			} else {
				if (claimSystem.contains("NICE")) {
					xpath="//table[@id='medical']//tr["+rowNum+"]//td[8]";
				} else {
					xpath="//table[@id='medical']//tr["+rowNum+"]//td[7]";
				}
				element=driver.findElement(By.xpath(xpath));
				Assert.assertTrue("PROBLEM - should not have 'Your Share' value showing on detail page", !validate(element));
				value="$0.00";
				dataMap.put(key, value);
			}
		} else if (claimType.equalsIgnoreCase("prescription drug")) {
			String xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[3]";
			String key="drug_dateFilled";
			WebElement element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			String value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[4]";
			key="drug_medication";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[5]";
			key="drug_rxNumber";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[6]";
			key="drug_pharmacy";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[7]";
			key="drug_planPaid";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[8]";
			key="drug_youPaid";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[9]";
			key="drug_otherPayments";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);
		} else {
			String xpath="//table[@id='ship']//tr["+rowNum+"]//td[4]";
			String key="ship_dateOfService";
			WebElement element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			String value=element.getText().trim();
			dataMap.put(key, convertDateFormat(value));

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[5]";
			key="ship_provider";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[6]";
			key="ship_claimType";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[7]";
			key="ship_charged";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[8]";
			key="ship_paidToYou";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[9]";
			key="ship_paidToProvider";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[10]";
			key="ship_processedDate";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, convertDateFormat(value));
		}
		System.out.println("Collected data from summary page 1st data row from claims table\n"+Arrays.asList(dataMap)+"\n");
		return dataMap;
	}

	public String convertDateFormat(String inputDateString) {
		String dateStr="";
		try {
			DateFormat srcDf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = srcDf.parse(inputDateString);	 // parse the date string into Date object
			DateFormat destDf = new SimpleDateFormat("MM/dd/yyyy");
			dateStr = destDf.format(date);	// format the date into another format
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateStr;
	}

	public void searchClaimsByTimeInterval(String planType, String fromDate, String toDate) {
		System.out.println("The title of the page is-------->"+driver.getTitle());
		if(driver.getTitle().contains("Claims Summary")){
			if (planType.equals("SHIP")) {
				sendkeys(shipFrom,fromDate);
				sendkeys(shipTo,toDate);
				CommonUtility.waitForPageLoad(driver, shipSearchButton,60);
				shipSearchButton.click();
			} else {
				sendkeys(from,fromDate);
				sendkeys(to,toDate);
				CommonUtility.waitForPageLoad(driver, searchButton,60);
				searchButton.click();
			}
		}
	}

	public void  validatefromDateLaterThanToDateError(String planType) {
		WebElement errorTextElement=fromDateLaterThanToDateError;
		if (planType.equals("SHIP")) {
			errorTextElement=fromDateLaterThanToDateErrorShip;
		} 
		if(!errorTextElement.getText().contains("Your From date needs to come before or")){
			Assert.fail(errorTextElement + "is not beind dsiplayed");	
		}
	}

	public void  validateEmptyDatesError() {
		searchButton.click();
		Assert.assertTrue("PROBLEM - unable to locate the EmptyDatesError element when 'To' and 'From' dates are emtpy", validate(EmptyDatesError));
		String expectedErrorText="The dates are empty, please re-enter the date in the following format: MM/DD/YYYY";
		Assert.assertTrue("PROBLEM -error text is not as expected when 'To' and 'From' dates are emtpy. Expected='"+expectedErrorText+"' | Actual='"+EmptyDatesError.getText()+"'", EmptyDatesError.getText().contains(expectedErrorText));
	}

	public void validateClaimsTableHeaderColumns(String claimType, String claimSystem, boolean hasYourShare) {
		if (claimType.equalsIgnoreCase("medical")) {
			//note: medical tbl doesn't have column6, don't know why
			String actualCol1=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[1]")).getText();
			String expectCol1="Date of Service";
			Assert.assertTrue("PROBLEM - medical claims table header column1 value not as expected. Expected='"+expectCol1+"' | Actual='"+actualCol1+"'", expectCol1.equals(actualCol1));

			String actualCol2=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[2]")).getText();
			String expectCol2="Provider Name";
			Assert.assertTrue("PROBLEM - medical claims table header column2 value not as expected. Expected='"+expectCol2+"' | Actual='"+actualCol2+"'", expectCol2.equals(actualCol2));

			String actualCol3=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[3]")).getText();
			String expectCol3="Provider Type";
			Assert.assertTrue("PROBLEM - medical claims table header column3 value not as expected. Expected='"+expectCol3+"' | Actual='"+actualCol3+"'", expectCol3.equals(actualCol3));

			String actualCol4=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[4]")).getText();
			String expectCol4="Amount providers have billed the plan";
			Assert.assertTrue("PROBLEM - medical claims table header column4 value not as expected. Expected='"+expectCol4+"' | Actual='"+actualCol4+"'", expectCol4.equals(actualCol4));

			String actualCol5=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[5]")).getText();
			String expectCol5="Claim Status";
			Assert.assertTrue("PROBLEM - medical claims table header column5 value not as expected. Expected='"+expectCol5+"' | Actual='"+actualCol5+"'", expectCol5.equals(actualCol5));

			if (hasYourShare) {
				if (claimSystem.contains("NICE")) {
					String actualCol6=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[6]")).getText();
					String expectCol6="Your Share";
					Assert.assertTrue("PROBLEM - medical claims table header column6 value not as expected. Expected='"+expectCol6+"' | Actual='"+actualCol6+"'", expectCol6.equals(actualCol6));
				} else {
					String actualCol7=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[7]")).getText();
					String expectCol7="Your Share";
					Assert.assertTrue("PROBLEM - medical claims table header column7 value not as expected. Expected='"+expectCol7+"' | Actual='"+actualCol7+"'", expectCol7.equals(actualCol7));
				}
			} else {
				if (claimSystem.contains("NICE")) {
					boolean result=validate(driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[6]")));
					Assert.assertTrue("PROBLEM - 'Your Share' column is showing up unexpectedly on summary page", !result);
				} else {
					boolean result=validate(driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[7]")));
					Assert.assertTrue("PROBLEM - 'Your Share' column is showing up unexpectedly on summary page", !result);
				}
			}
			String actualCol8=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[8]")).getText();
			String expectCol8="Claim Details";
			Assert.assertTrue("PROBLEM - medical claims table header column8 value not as expected. Expected='"+expectCol8+"' | Actual='"+actualCol8+"'", expectCol8.equals(actualCol8));
		} else if (claimType.equalsIgnoreCase("prescription drug")) {
			String actualCol1=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[1]")).getText();
			String expectCol1="Date Filled";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column1 value not as expected. Expected='"+expectCol1+"' | Actual='"+actualCol1+"'", expectCol1.equals(actualCol1));

			String actualCol2=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[2]")).getText();
			String expectCol2="Medication";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column2 value not as expected. Expected='"+expectCol2+"' | Actual='"+actualCol2+"'", expectCol2.equals(actualCol2));

			String actualCol3=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[3]")).getText();
			String expectCol3="Rx Number";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column3 value not as expected. Expected='"+expectCol3+"' | Actual='"+actualCol3+"'", expectCol3.equals(actualCol3));

			String actualCol4=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[4]")).getText();
			String expectCol4="Pharmacy";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column4 value not as expected. Expected='"+expectCol4+"' | Actual='"+actualCol4+"'", expectCol4.equals(actualCol4));

			String actualCol5=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[5]")).getText();
			String expectCol5="Plan Paid";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column5 value not as expected. Expected='"+expectCol5+"' | Actual='"+actualCol5+"'", expectCol5.equals(actualCol5));

			String actualCol6=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[6]")).getText();
			String expectCol6="You Paid";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column6 value not as expected. Expected='"+expectCol6+"' | Actual='"+actualCol6+"'", expectCol6.equals(actualCol6));

			String actualCol7=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[7]")).getText();
			String expectCol7="Other Payments";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column7 value not as expected. Expected='"+expectCol7+"' | Actual='"+actualCol7+"'", expectCol7.equals(actualCol7));
		} else {
			String actualCol1=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[1]")).getText();
			String expectCol1="Dates of Service";
			Assert.assertTrue("PROBLEM - ship claims table header column1 value not as expected. Expected='"+expectCol1+"' | Actual='"+actualCol1+"'", expectCol1.equals(actualCol1));

			String actualCol2=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[2]")).getText();
			String expectCol2="Provider";
			Assert.assertTrue("PROBLEM - ship claims table header column2 value not as expected. Expected='"+expectCol2+"' | Actual='"+actualCol2+"'", expectCol2.equals(actualCol2));

			String actualCol3=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[3]")).getText();
			String expectCol3="Claim Type";
			Assert.assertTrue("PROBLEM - ship claims table header column3 value not as expected. Expected='"+expectCol3+"' | Actual='"+actualCol3+"'", expectCol3.equals(actualCol3));

			String actualCol4=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[4]")).getText();
			String expectCol4="Charged";
			Assert.assertTrue("PROBLEM - ship claims table header column4 value not as expected. Expected='"+expectCol4+"' | Actual='"+actualCol4+"'", expectCol4.equals(actualCol4));

			String actualCol5=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[5]")).getText();
			String expectCol5="Paid to You";
			Assert.assertTrue("PROBLEM - ship claims table header column5 value not as expected. Expected='"+expectCol5+"' | Actual='"+actualCol5+"'", expectCol5.equals(actualCol5));

			String actualCol6=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[6]")).getText();
			String expectCol6="Paid to Provider";
			Assert.assertTrue("PROBLEM - ship claims table header column6 value not as expected. Expected='"+expectCol6+"' | Actual='"+actualCol6+"'", expectCol6.equals(actualCol6));

			String actualCol7=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[7]")).getText();
			String expectCol7="Processed Date";
			Assert.assertTrue("PROBLEM - ship claims table header column7 value not as expected. Expected='"+expectCol7+"' | Actual='"+actualCol7+"'", expectCol7.equals(actualCol7));

			String actualCol8=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[8]")).getText();
			String expectCol8="Claim Details";
			Assert.assertTrue("PROBLEM - ship claims table header column8 value not as expected. Expected='"+expectCol8+"' | Actual='"+actualCol8+"'", expectCol8.equals(actualCol8));
		}
	}

	public void validateClaimsTable(String planType, int numClaims,String claimType, String claimSystem, boolean hasYourShare) {
		CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage,60);
		if (numClaims>0) {
			//has claims, table should display
			if (claimType.equalsIgnoreCase("medical")) {
				Assert.assertTrue("PROBLEM - has claims but unable to locate claims table for claimType='"+claimType+"'",claimsTableMedical.isDisplayed());
				validateClaimsTableHeaderColumns(claimType, claimSystem, hasYourShare);
			} else if (claimType.equalsIgnoreCase("prescription drug")) {
				Assert.assertTrue("PROBLEM - has claims but unable to locate claims table for claimType='"+claimType+"'",claimsTablePrescriptionDrug.isDisplayed());
				validateClaimsTableHeaderColumns(claimType, claimSystem, hasYourShare);
			} else {
				Assert.assertTrue("PROBLEM - has claims but unable to locate claims table for claimType='"+claimType+"'",claimsTableSHIP.isDisplayed());
				validateClaimsTableHeaderColumns(claimType, claimSystem, hasYourShare);
			}
		} else {
			//table should not display
			if (claimType.equalsIgnoreCase("medical")) {
				Assert.assertTrue("PROBLEM - has no claims should not be able to locate claims table for claimType='"+claimType+"'",!claimsTableMedical.isDisplayed());
			} else if (claimType.equalsIgnoreCase("prescription drug")) {
				Assert.assertTrue("PROBLEM - has no claims should not be able to locate claims table for claimType='"+claimType+"'",!claimsTablePrescriptionDrug.isDisplayed());
			} else {
				Assert.assertTrue("PROBLEM - has no claims should not be able to locate claims table for claimType='"+claimType+"'",!claimsTableSHIP.isDisplayed());
			}
		}
	}

	public ClaimDetailsPage navigateToClaimDetailsPage(int rowNum) throws InterruptedException {
		System.out.println("Go to claim detail page by clicking 'More Info' button");
		CommonUtility.waitForPageLoadNew(driver, claimstablemoreinfolink, 60);
		WebElement row=driver.findElement(By.xpath("//div[@class='claim-results']//table[not (contains(@class,'ng-hide'))]//tbody//tr["+rowNum+"]//a[text()='MORE INFO']"));
		scrollToView(claimsSummaryPrintButton);
		row.click();
		int counter =0;
		do{
			if(counter<=12)
				Thread.sleep(3000);
			else
				return null;
			counter++;
		} 
		while(!(driver.getCurrentUrl().contains("/details"))); 
		if (driver.getCurrentUrl().contains("/details")) {
			return new pages.regression.claims.ClaimDetailsPage(driver);
		}
		return null;
	}

	public int getTableTotalDataRows(String claimType) {
		int totalRow=0;
		if (claimType.equalsIgnoreCase("medical")) {
			String xpath="//table[@id='medical']//tr";
			List<WebElement> listRows=driver.findElements(By.xpath(xpath));
			if (listRows.size()>1) 
				totalRow=listRows.size()-1;  // remove the row count for header
		} else if (claimType.equalsIgnoreCase("prescription drug")) {
			String xpath="//table[@id='prescriptionDrug']//tr";
			List<WebElement> listRows=driver.findElements(By.xpath(xpath));
			if (listRows.size()>1) 
				totalRow=listRows.size()-1;  // remove the row count for header
		} else {
			String xpath="//table[@id='ship']//tr";
			List<WebElement> listRows=driver.findElements(By.xpath(xpath));
			if (listRows.size()>1) 
				totalRow=listRows.size()-1;  // remove the row count for header
		}
		return totalRow;
	}

	//note: DO NOT REMOVE THIS METHOD, need to confirm behavior then code this
	public void validateClaimsTableSectionText(int numClaims) {
		if (numClaims==0) {
			/* TODO - need to turn on the validation once confirm the behavior for drug option with this link
					Assert.assertTrue("PROBLEM - for PDP group user, unable to locate the 'View your current prescription drug cost summary at OPTUMRX.COM' text", validate(viewCurrentDrugCostText));
					viewCurrentDrugCostLink.click();
					switchToNewTab();
					System.out.println("TEST - optumrx.com -  Driver.getURL="+driver.getCurrentUrl());
					String expectedURL="https://chp-stage.optumrx.com/public/sso-landing";
					//TODO - need to assert this after confirming URL, the curent URL  on stage is not working
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(0)); //switch back to original tab
			 */
		} else {
			//TODO - on offline user has a different link when there is claims, need to confirm behavior then code the assert here
		}
	}

	public void validateSystemErrorMsgNotExist() {
		Assert.assertTrue("PROBLEM - located System Error",!validate(systemErrorMsg));
	}

	public void validateComboTabs(){
		CommonUtility.checkPageIsReadyNew(driver);
		Assert.assertTrue("PROBLEM - this user doesn't have combo tabs, this test is intended for combo testing, please select user that has combo plans", comboTabsOnclaimsPage.size()>1);
	}

	public void goToSpecificComboTab(String planType) {
		if (planType.equalsIgnoreCase("mapd")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", validate(comboTab_MAPD));
			comboTab_MAPD.click();
		} else if (planType.equalsIgnoreCase("ship")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", validate(comboTab_SHIP));
			comboTab_SHIP.click();
		} else if (planType.equalsIgnoreCase("pdp")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(comboTab_PDP));
			comboTab_PDP.click();
		} else if (planType.equalsIgnoreCase("ssup")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(comboTab_SSUP));
			comboTab_SSUP.click();
		} else {
			Assert.assertTrue("PROBLEM - need to enhance code to cover planType '"+planType+"' for combo testing", false);
		}
	}

	public boolean validate_SearchEobHistory_onSummaryPage(String claimSystem, String plantype){
		boolean invokeBypass_INC11365785_searchEOBHistory=false;
		if ((plantype.equals("MAPD") || plantype.equals("PCP") || plantype.equals("MEDICA")) &&
				(claimSystem.toUpperCase().contains("COSMOS") || claimSystem.toUpperCase().contains("NICE"))) {
			Assert.assertTrue("PROBLEM - unable to locate Medical EOB link on summary page", validate(medicalEOB_MAPD));
			Assert.assertTrue("PROBLEM - unable to locate Prescription EOB link on summary page", validate(drugEOB_MAPD));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - medical and precription drug EOB's are displayed===> "+ (medicalEOB_MAPD.isDisplayed() && drugEOB_MAPD.isDisplayed()));
		}
		else if (plantype.equals("MA") && claimSystem.toUpperCase().contains("COSMOS")) {
			Assert.assertTrue("PROBLEM - unable to locate Medical EOB link on summary page", validate(medicalEOB_MA));
			Assert.assertTrue("PROBLEM - should NOT be able to locate Prescription EOB link on summary page", !validate(drugEOB_MA));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - medical EOB's are displayed===> "+ (medicalEOB_MA.isDisplayed()));
		}
		else if (plantype.equals("MA") && claimSystem.toUpperCase().contains("NICE")) {
			//note: not expected behavior but existing behavior, there is an existing defect in prod
			Assert.assertTrue("PROBLEM - existing behavior should not be able to locate Medical EOB link on summary page (NOTE: this is not the right behavior- bypassIssue2)", !validate(medicalEOB_MA));
			Assert.assertTrue("PROBLEM - should NOT be able to locate Prescription EOB link on summary page", !validate(drugEOB_MA));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - no medical or precription drug EOB's are displayed");
			invokeBypass_INC11365785_searchEOBHistory=true;
		}
		else if (plantype.equals("PDP")) {
			Assert.assertTrue("PROBLEM - should NOT be able to locate Medical EOB link on summary page", !validate(medicalEOB_PDP));
			Assert.assertTrue("PROBLEM - unable to locate Prescription EOB link on summary page", validate(drugEOB_PDP));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - medical EOB's are displayed===> "+ (drugEOB_PDP.isDisplayed()));
		}
		else if (plantype.equals("SSUP")) {
			//note: F267688
			Assert.assertTrue("PROBLEM - should NOT be able to locate medical EOB link on summary page", !validate(medicalEOB_MA));
			Assert.assertTrue("PROBLEM - should NOT be able to locate Prescription EOB link on summary page", !validate(drugEOB_MA));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - no medical or precription drug EOB's are displayed");
		}
		else if (plantype.equals("SHIP")){
			Assert.assertTrue("PROBLEM - unable to locate EOB link on summary page for SHIP user", validate(EOB_SHIP));
			System.out.println("for SHIP Eob is diplayed ====>"+ (EOB_SHIP.isDisplayed()));
		}
		else {
			Assert.assertTrue("PROBLEM - need to code the condition for planType="+plantype+" and domain="+claimSystem+" EOB expectation", false);
		}
		return invokeBypass_INC11365785_searchEOBHistory;
	}


	public boolean validateDownloadMyDataExistsAndWorks(){
		if (!validate(downloadmydatabutton)) {
			System.out.println("PROBLEM - not getting expected DownloadMyData button");
			return false;
		}
		Assert.assertTrue("PROBLEM - not getting expected DownloadMyData button",validate(downloadmydatabutton));
		System.out.println("!!! Blue Button-DownLoad my Data Button is displayed ===>"+downloadmydatabutton.isDisplayed());
		downloadmydatabutton.click();
		if (!validate(leavingsitepopup)) {
			System.out.println("PROBLEM - not getting expected leavingsitepopup");
			return false;
		}
		System.out.println("!!!Proceed Button is displayed ===>"+leavingsitepopup.isDisplayed());
		if (!validate(cancelButtonDownloadPopUp)) {
			System.out.println("PROBLEM - not getting expected cancelButtonDownloadPopUp");
			return false;
		}
		//now click cancel and validate any element on page
		cancelButtonDownloadPopUp.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (!driver.getTitle().contains("Claims")) {
			System.out.println("PROBLEM - Cancel button on DownloadPopUp is not working");
			return false;
		}
		System.out.println("Cancel button functionality is working as expected");
		//now again validate site leaving popup
		downloadmydatabutton.click();
		waitforElement(leavingsitepopup);
		System.out.println("Proceed button is displayed ===>"+(leavingsitepopup.isDisplayed()));
		if(leavingsitepopup.isDisplayed()){
			String winHandleBefore = driver.getWindowHandle();
			proceedButtonDownloadPopUp.click();

			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();					
			driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			try {
				Thread.sleep(2000); //note: need this for the page to load before it can check page ready
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			CommonUtility.checkPageIsReady(driver);
			String expectedURL="https://www.medicare.gov/manage-your-health/medicares-blue-button-blue-button-20";
			if (!driver.getCurrentUrl().contains(expectedURL)) {
				System.out.println("PROBLEM - process button is not functioning as expected");
				return false;
			}
			driver.close();
			driver.switchTo().window(winHandleBefore);
			System.out.println("Main window = "+driver.getTitle());	
		}
		return true;
	}

	public boolean validatePageContainsPdfDocText() {
		boolean invokeBypass_INC11365785_conatinsPdfDocText=false;
		System.out.println("Validate PDF Doc text section exists");
		System.out.println("validate(searchAnyEobHistoryText)="+validate(searchAnyEobHistoryText));
		if (validate(searchAnyEobHistoryText) || validate(searchEobStatementsText)) {
			if (validate(pageContainsPdfDocText)) {
				Assert.assertTrue("PROBLEM - unable to locate the Adobe PDF section",validate(pageContainsPdfDocText));
			} else {
				System.out.println("Encountered issue from INC11365785, ignore for now until it's fixed.  TODO: When fixed, take out this else portion");
				invokeBypass_INC11365785_conatinsPdfDocText=true;
			}
		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate the Adobe PDF section because there is no PDF avaialbe on this detail page",!validate(pageContainsPdfDocText));
		}
		return invokeBypass_INC11365785_conatinsPdfDocText;
	}

	public void verifyClaimSupportSupportNumberNOTDisplayedForSHIPPreEffectiveMembers() throws InterruptedException {
		System.out.println("Now checking for Claim Support Number for SHIP Pre-effective members");
		try {
			preEffectiveClaimsSupportNumber.isDisplayed();                            	  
			System.out.println("Claim Support Number for SHIP Pre-effective members was displayed");
			Assert.fail("Claim Support Number for SHIP Pre-effective members was displayed, Test step is failed due to it");
		} catch (Exception e) {
			System.out.println("Claim Support Number for SHIP Pre-effective members was NOT displayed, Test step is passed due to it");
		}
	}

	public void verifyClaimSupportSupportHeaderInNeedHelpNOTDisplayedForSHIPPreEffectiveMembers() throws InterruptedException {
		System.out.println("Now checking for Claim Support Header in Need Help Section for SHIP Pre-effective members");
		try {
			preEffectiveClaimsSupportHeader.isDisplayed();
			System.out.println("Claim Support Header in Need Help Section for SHIP Pre-effective members was displayed");
			Assert.fail("Claim Support Header in Need Help Sectionr for SHIP Pre-effective members was displayed, Test step is failed due to it");
		} catch (Exception e) {
			System.out.println("Claim Support Header in Need Help Section for SHIP Pre-effective members was NOT displayed, Test step is passed due to it");
		}
	}

	public void validateNeedHelpSection(String planType) {
		if (planType.equalsIgnoreCase("SHIP")) {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",validate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,needHelp_TechicalSupport_wkEndHrs);

			validateSection="Need Help - General Questions";
			validateNeedHelpSectionContent(validateSection, needHelp_GeneralQuestionsSection, needHelp_GeneralQuestions_img, needHelp_GeneralQuestions_phone, needHelp_GeneralQuestions_tty, needHelp_GeneralQuestions_wkDayHrs,needHelp_GeneralQuestions_wkEndHrs);

			validateSection="Need Help - Claims Support";
			validateNeedHelpSectionContent(validateSection, needHelp_ClaimsSupportSection, needHelp_ClaimsSupport_img, needHelp_ClaimsSupport_phone, needHelp_ClaimsSupport_tty, needHelp_ClaimsSupport_wkDayHrs,needHelp_ClaimsSupport_wkEndHrs);

			System.out.println("Proceed to validate the Need Help - See More Ways section content");
			Assert.assertTrue("PROBLEM - unable to locate the 'See more ways to' text in Need Help section",validate(needHelp_seeMoreWaysTo));
			Assert.assertTrue("PROBLEM - unable to locate the 'contact us' link in Need Help section",validate(needHelp_contactUsLink));
			needHelp_contactUsLink.click();
			CommonUtility.checkPageIsReady(driver);
			String expContactUsTitle="Help & Contact Us";
			String expContactUsUrl="content/medicare/member/contact-us/overview.html#/contact-us-three";
			System.out.println("New window URL = "+driver.getCurrentUrl());
			System.out.println("New window title = "+driver.getTitle());
			Assert.assertTrue("PROBLEM - not getting expected contact us URL. Expected to contains='"+expContactUsUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", driver.getCurrentUrl().contains(expContactUsUrl));
			Assert.assertTrue("PROBLEM - not getting expected contact us Title. Expected to contains='"+expContactUsTitle+"' | Actual URL='"+driver.getTitle()+"'", driver.getTitle().contains(expContactUsTitle));
			driver.navigate().back();
			System.out.println("Main window = "+driver.getTitle());	
		} else {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",validate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,null);

			validateSection="Need Help - Plan Support";
			validateNeedHelpSectionContent(validateSection, needHelp_PlanSupportSection, needHelp_PlanSupport_img, needHelp_PlanSupport_phone, needHelp_PlanSupport_tty, needHelp_PlanSupport_wkDayHrs, null);
		}
	}
	
	public void validateNeedHelpSectionContent(String section, WebElement SectionElement, WebElement imgElement, WebElement phoneElement, WebElement ttyElement, WebElement hrsOperationElement1, WebElement hrsOperationElement2) {
		System.out.println("Proceed to validate the "+section+" section content");
		Assert.assertTrue("PROBLEM - unable to locate the "+section+" section element",validate(SectionElement));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section",validate(imgElement));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section",validate(phoneElement));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section",validate(ttyElement));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",validate(hrsOperationElement1));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",validate(hrsOperationElement2));
		}
	}

	public ClaimDetailsPage navigateToClaimDetailsPagetoseeeobpdflink() {
		try {
			validateNew(claimstablemoreinfolink);
			paginationRightArrow.click();
			paginationRightArrow.click();
			paginationRightArrow.click();
			System.out.println("more info link is seen for  ===>" + claimstablemoreinfolink.isDisplayed());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", specificclaimlinkforeob);
			System.out.println(driver.getTitle());
			if (driver.getTitle().equalsIgnoreCase("Claims Summary")) {
				System.out.println("*** Claims Details Page ***");
			}
		} catch (Exception ex) {
			return null;
		}
		return new ClaimDetailsPage(driver);
	}

	//vvv note:	added for VBF	
	public void vbf_validateClaimsTable() {
		CommonUtility.waitForPageLoadNew(driver, ClaimsSummaryPage, 60);
		scrollToView(ClaimsSummaryPage);
		if (claimsTableMedical.isDisplayed() || claimsTablePrescriptionDrug.isDisplayed()
				|| claimsTableSHIP.isDisplayed()) {
			System.out.println("!!!!!!!!! Able to find the claims table !!!!!!!!!");
			int counter = 0;
			if (claimsTableMedical.isDisplayed()) {

				int columnSize = vbf_medicalTableRow.size();
				for (int columnNum = 1; columnNum < columnSize; columnNum++) {
					String columnActualText = vbf_medicalTableRow.get(columnNum).getText();
					if (!columnActualText.isEmpty())
						counter++;
				}
				Assert.assertTrue("Claims table gets displayed", counter > 0);
				validateNew(vbf_providerNameValue);
			} else if (claimsTablePrescriptionDrug.isDisplayed()) {
				int columnSize = vbf_drugTableRow.size();
				for (int columnNum = 1; columnNum < columnSize; columnNum++) {
					String columnActualText = vbf_drugTableRow.get(columnNum).getText();
					if (!columnActualText.isEmpty())
						counter++;
				}
				Assert.assertTrue("Claims table gets displayed", counter > 0);
			} else if (claimsTableSHIP.isDisplayed()) {

				int columnSize = vbf_shipTableRow.size();
				for (int columnNum = 1; columnNum < columnSize; columnNum++) {
					String columnActualText = vbf_shipTableRow.get(columnNum).getText();
					if (!columnActualText.isEmpty())
						counter++;
				}
				Assert.assertTrue("Claims table gets displayed", counter > 0);
				validateNew(vbf_shipProviderNameValue);
			}
		}else{
			System.out.println("!!!!!!!!! NOT Able to find the claim table !!!!!!!!!");
			Assert.fail("!!!!!!!!! NOT Able to find the claim table !!!!!!!!!");
		}
	}
	//^^^ note:	added for VBF			

}
