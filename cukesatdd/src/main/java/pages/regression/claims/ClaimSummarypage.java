package pages.regression.claims;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
//import junit.framework.Assert;
import pages.regression.footer.FooterPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;


/**
 * Functionality : this page validates the Claim Summary page.
 */
public class ClaimSummarypage extends UhcDriver{

	@FindBy(xpath = ".//*[@id='globalContentIdForSkipLink']/div[3]/div[1]/div/div/div/div/div/p")
	private WebElement messageForPreeffective;
	
	@FindBy(xpath = "//p[contains(text(),'1-888-980-8125')]")
	public WebElement preEffectiveTechSupportNumber;

	@FindBy (xpath=".//*[@id='MA']")
	private WebElement MA;

	@FindBy (xpath=".//*[@id='MAPD']")
	private WebElement MAPD;

	@FindBy (xpath=".//*[@id='PDP']")
	private WebElement PDP;

	@FindBy(xpath=".//*[@class='claimsearch section']/div[1]//h1")
	private WebElement myCaimsText;

	@FindBy(css = ".claim-results")
	private WebElement ClaimsSummaryPage;

	@FindBy(xpath="//div[normalize-space()='Medical']")
	private WebElement claimTypeMA;

	@FindBy(id="claim-type")
	private WebElement claimTypeMAPD;
    
	@FindBy(xpath = ".//*[@id='planNameFed']")
	private WebElement planame;
	
	//@FindBy (xpath = "//*[@id='document-date']//option[contains(@value,'custom-search')]")
	@FindBy(xpath =".//*[@id='dateCustomSearchAtdd']")
	private WebElement customSearch;
	
	@FindBy (xpath = "//div[@class='medical-claims']//h2[@ng-bind-html='planName']/parent::div//*[@id='document-date']//option[contains(@value,'24 months')]")
	private WebElement last24months;
	
	@FindBy(xpath="//div[normalize-space()='Prescription Drug']")
	private WebElement claimTypePDP;

	@FindBy(id="document-date")
	private WebElement viewClaimsFrom;
	

	//@FindBy (xpath="(.//*[@id='summaryview']//section/div/div/div/p)[1]")   
	@FindBy (id="numDays1")
	private WebElement claimsCopyText;
	
	@FindBy (id="learnmoresummarytoggle")
	private WebElement learnMoreAboutClaims;

	@FindBy (xpath="(.//*[@id='summaryview']//section/div/div/div/p)[2]")                    
	private WebElement claimsCopyText2;

	@FindBy (xpath=".//*[@id='table-medical']/div[1]/div[1]/div/h2[1]")
	private WebElement dynamicNumberOfClaimsText;

	@FindBy (xpath=".//*[@id='table-medical']/div[1]/div[1]/div/h2[2]")
	private WebElement dynamicNumberOfClaimsTextPdp;

	//@FindBy (xpath = "//*[@id='medical'or @id='table-medical']/")
	//@FindBy(xpath=".//*[@id='table-medical']/div[3]/div/div")
	@FindBy(xpath=".//*[@id='medical']")
	private WebElement claimsTableMedical;

	@FindBy (xpath = ".//*[@id='prescriptionDrug']")
	//@FindBy (id= ".//*[@id='table-medical']")
	private WebElement claimsTablePrescriptionDrug;
	
	@FindBy (id = "ship")
	private WebElement claimsTableSHIP;
	
	@FindBy(className="modal-body")
	private WebElement iPerceptionPopUp;
	
	//@FindBy (xpath=".//*[@id='summaryview']/div/div/main/div/div[2]/section/div/div/div[2]/div/div/ul")
	//@FindBy(xpath ="(//*[contains(text(),'items found. Displaying ')]")
	@FindBy (xpath =".//*[@id='graySection']/div/div/div[2]/div/div/ul")
	private WebElement claimsTablePagination;
	
	@FindBy(xpath="//*[@id='atddUhcPagination']/li[1]/p")	
	private WebElement verifyClaimSummaryAndPagination;

	//@FindBy (xpath="//div[not (contains(@class,'ng-hide')) and contains(@ng-show,'AEM')]//div[@id='ma_mapd']//a")
	//@FindBy (xpath="(//p[contains(text(),'Medical EOB')])[2]/ancestor::div[1]")
	//@FindBy (xpath="//div[@class='parsys summaryParsys']/div/div[not (contains(@class,'ng-hide'))][1]//a[contains(@class,'btn btn--secondary')]")
	//@FindBy (xpath = "//div[@class='parsys summaryParsys']/div/div[not (contains(@class,'ng-hide'))][1]//span[text()='Medical EOB']/parent::a[contains(@class,'btn btn--secondary')]")
	@FindBy (xpath ="//div[@ng-hide='phipError']//div[@class='customsegments parbase section'][1]//p[contains(text(), 'Medical EOB')]")
	private WebElement medicalEobText;

	//@FindBy (xpath="//div[not (contains(@class,'ng-hide')) and contains(@ng-show,'AEM')]//div[@id='pdp_mapd']//a")
	@FindBy (xpath="(//p[contains(text(),'Prescription Drug EOB')])[1]/ancestor::div[1]")
	//@FindBy (xpath = "//div[@class='parsys summaryParsys']/div/div[not (contains(@class,'ng-hide'))][1]//a[contains(@class,'btn btn--secondary')]")
	//@FindBy (xpath = "//div[@class='parsys summaryParsys']/div/div[not (contains(@class,'ng-hide'))][1]//p[text()='Prescription Drug EOB']/following::a[contains(@class,'btn btn--secondary')][1]")
	private WebElement PrescriptionEobText;
	
	@FindBy (xpath = "//div[@class='summaryParsys parsys']/div/div[not (contains(@class,'ng-hide'))][1]//p[text()='Prescription Drug EOB']/following::a[contains(@class,'btn btn--secondary')][1]")
    private WebElement PrescriptionEobText1;
	@FindBy (xpath="//span[text()='Ship EOB']/parent::a")
	private WebElement ShipClaimsEobText;

	@FindBy (xpath=".//*[@id='table-medical']/div[2]/div[1]/div/a")
	private WebElement learnmorefalse;

	@FindBy (xpath=".//*[@id='table-medical']/div[2]/div[2]/div/a")
	private WebElement learnmorePdp;
	
	@FindBy (xpath=".//*[@id='dateCustomSearchAtdd']")
	private WebElement customSearchText;
	
	@FindBy(id = "atddPagination")
	private WebElement verifyClaimSummaryAndPagination3;
	
	@FindBy (xpath=".//*[@id='custom_from_date_fed']")
	private WebElement fromDate;
	
	@FindBy (xpath=".//*[@id='custom_to_date_fed']")
	private WebElement toDate;
	
	@FindBy (xpath=".//*[@id='customsearchbuttonFedBtn']")
	private WebElement srch;
	
	@FindBy (xpath= ".//*[@id='validDivErr']")
	private WebElement messageaftersrch;

	//@FindBy (id="DownloadLinkBtnAtdd")
	@FindBy (xpath=".//*[@id='downloadHypLinkAtdd']")
	private WebElement downloadmydatabutton;

	//@FindBy (xpath=".//*[@id='siteleaving-popup-overlay']")
	@FindBy(xpath=".//*[@id='siteleaving-popup-overlay']/div/div[1]/p[1]")
	private WebElement leavingsitepopup; /* proceedToDownloadPopUp;*/

	@FindBy(id="proceedbtn")
	private WebElement proceedButtonDownloadPopUp;

	@FindBy(id="cancelbtn")
	private WebElement cancelButtonDownloadPopUp;

	//@FindBy (xpath="(//button[@class="btn btn--primary margin-none"])[1]")
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
    
	@FindBy (css = ".color-red.semi-bold>p>span")
	private WebElement fedDateRangeErrMsg;
	
	@FindBy (xpath ="//*[@id='futureDateErrorDivErr']/p/span")
	private WebElement fromDateLaterThanToDateError;
	
	/*@FindBy (xpath =".//*[@id='moreInfoLinkAtdd0']/a")
	private WebElement claimstablemoreinfolink;*/
	
	@FindBy(xpath = ".//*[@id='claim-type']/option[2]")
	private WebElement PrescriptionDrug;
	
	@FindBy  (xpath =".//*[@id='prescriptionDrug']/tbody/tr[1]/th[7]/p")
	private WebElement RxNumberinthecalimstable;
	
	//@FindBy(xpath ="dtmname="claims search:claim type:Medical" value="medical" ])
	@FindBy (xpath =".//*[@id='claim-type']/option[1]")
	private WebElement Medical;
	
	/*@FindBy (xpath =".//*[@id='moreInfoLinkAtdd3']/a' or id='.//*[@id='learnmoresummarytoggle']/div[3]/p'")
	private WebElement claimstablemoreinfolink;*/
	
	@FindBy(xpath = "//div[@class='claim-results']//table[not (contains(@class,'ng-hide'))]//tbody//tr[2]//a[text()='MORE INFO']")
	private WebElement claimstablemoreinfolink;
	

	@FindBy (xpath= "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li")
	private List<WebElement> comboTabsOnclaimsPage;	

	@FindBy(id= "claims_1")
	private static WebElement claimsLink;

	@FindBy(id="fed-document-date")
	private WebElement claimFromDropDown1;
	
		
	@FindBy(id="claim-type")
	private WebElement clamtypeFromDropDown;
	
	@FindBy(xpath = "//*[@id='IPerceptionsEmbed']")
	private WebElement WelcomePage_iPerceptionPresent;
	
	@FindBy(xpath = "//*[@id='PoweredByiPerceptions']")
	private WebElement iPerceptionPopUp1;

	@FindBy(xpath = "//*[@id='closeButton']")
	private WebElement iPerceptionClose;
	
	@FindBy(xpath=".//*[@id='atddPagination']/p")
	private WebElement verifyClaimSummaryAndPagination1;
	
	@FindBy(xpath="//.[contains(text(),'Review your claims search results below or enter new dates to search again')]")
	private WebElement clamisSummCopyText;
	
	@FindBy(xpath=".//*[@id='learnmoresummarytoggle']")
	private WebElement learmore;

	@FindBy(id="numDays2")
	private WebElement Youhave;
	
	//@FindBy(xpath=".//*[@id='globalContentIdForSkipLink']/div[3]/div[1]/div/div/main/div/div[1]/section/div[1]/div/div/div/div/div[3]/div/p")
	@FindBy(xpath=".//*[@id='globalContentIdForSkipLink']/div[3]/div[1]/div/div/div/div[2]/div/div[1]/section/div[2]/section/div/div/div/div/div/div/div[1]/p")
	private WebElement PCPtext;
	
	@FindBy(xpath="//*[@id='skipToBodyContent']//div[@class='reviewclaimstextFed parsys']//p")
	private WebElement clamsSummaryCopyText;
	
	@FindBy(id = "all-claims-print-claims-btn")
	private WebElement validateclaimsprintbutton;
	
	@FindBy(id = "all-claims-download-btn")
	private WebElement validateclaimsdownloadbutton;

	@FindBy(xpath = "//div[contains(@class,'shipCompSection')]//select[@name='document-date']")
	private WebElement claimDropDownBoxForShip;	

	@FindBy(xpath = "//div[contains(@class,'fedCompSection')]//select[@name='document-date']")
	private WebElement claimDropDownBoxForFed;	
	
	@FindBy(xpath="//div[@id='tableAtddFed']//div[contains(text(),'Prescription Drug')]")
	public WebElement pdpPrescriptionDrug;
	
	//vvv note:	added for def1041	
	@FindBy(xpath="//div[@id='validDivErr']//p//span") 
	private WebElement greatederThanTwoYearsError;

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
	private WebElement greatederThanTwoYearsErrorShip;

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
	//^^^ note:	added for def1041				


	public ClaimSummarypage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage, 60);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub



	}


	public void validateHeader() {
		// TODO Auto-generated method stub
		if(myCaimsText.getText().equals("My Claims")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Claims Page Header Not found");
		}
	}
	/**
	 * @toDo : this method validates claim type
	 */
	public  boolean validateClaimType(String abc){	

		if(abc.equals("MA")){	
			return claimTypeMA.isDisplayed();		
		}
		else if(abc.equals("PDP")){	
			System.out.println(claimTypePDP.isDisplayed());
			return claimTypePDP.isDisplayed();		
		}
		else{
			System.out.println(claimTypeMAPD.isDisplayed());
			return claimTypeMAPD.isDisplayed();	
			/*Select select = new Select(claimTypeMAPD);
		int size = select.getOptions().size();
		//select.getFirstSelectedOption()
		if(size!=2){
			return false;		
		}
		else{
			List<WebElement> values = select.getOptions();
			System.out.println(values.get(0));
			System.out.println(values.get(1));
			return values.get(0).equals("medical")&&values.get(1).equals("prescription drug");
		}*/
		}	
	}	
	/**
	 * @toDo : this method validates view claim FROM drop down 
	 */
	public String validateViewClaimsFromDropDown(){		
		Select select = new Select(viewClaimsFrom);
		return select.getFirstSelectedOption().getText(); 		
	}
	/**
	 * @toDo : this method validates the text 
	 */
	public boolean verifyCopyText(){
		return claimsCopyText.isDisplayed();
	}
	/**
	 * @toDo : this method validates the text 
	 */
	public boolean verifyCopyText2(){
		return claimsCopyText2.isDisplayed();
	}
	/**
	 * @toDo : this method validates dynamic text
	 */
	public boolean verifyDynamicText(){
		return dynamicNumberOfClaimsText.isDisplayed() || dynamicNumberOfClaimsTextPdp.isDisplayed() ;

	}
	/**
	 * @toDo : this method validates claims table and pagination
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
	 * @toDo : this method validates Claims by time period 
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
	 * @toDo : Validate Pagination under the claims table  
	 */
	public boolean verifyClaimsTableAndPagination1(){
				
	     try{
	    	 
	    	 if(validate (verifyClaimSummaryAndPagination1))
	 		{
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
	 * @toDo:validate the pagination on the claims summary page
	 *//*
	public boolean verifyClaimsTableAndPagination3(){
		     
	    	   try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   
			validateNew (verifyClaimSummaryAndPagination3);
			if 
			(verifyClaimSummaryAndPagination3.isDisplayed())
			{
			System.out.println("Pagination is seen ===>"+verifyClaimSummaryAndPagination3.getText());
			return true;
	              }	
			else {
		System.out.println("************Pagination is not displayed as records are less***************");
		return false;
	}
	}	*/
	
	/**
	 * @toDo:validate the pagination on the claims summary page
	 */
	public boolean verifyClaimsTableAndPagination3(){
		     
	    	   try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   
			validateNew (verifyClaimSummaryAndPagination3);
			if 
			(verifyClaimSummaryAndPagination3.isDisplayed())
			{
			System.out.println("Pagination is seen ===>"+verifyClaimSummaryAndPagination3.getText());
			return true;
	              }	
			else {
		System.out.println("************Pagination is not displayed as records are less***************");
		return false;
	}
	}	
		
		
		
	/**
	 * @toDo : this method validates EOB 
	 */
	public boolean validateEobfordifferentDomainType(String domain, String plantype){

		if (domain.equals("COSMOS")&& plantype.equals("MAPD"))
		{
			System.out.println("for MAPD COSMOS  medical and precription drug EOB's are displayed===> "+ (medicalEobText.isDisplayed() && PrescriptionEobText.isDisplayed()));
			return medicalEobText.isDisplayed() && PrescriptionEobText.isDisplayed();

		}
		else if (domain.equals("NICE")&&plantype.equals("MAPD"))
		{
			System.out.println("for MAPD NICE prescription drug EOB's are displayed ===>"+ (PrescriptionEobText.isDisplayed()));
			return PrescriptionEobText.isDisplayed();
		}
		else if ( (domain.equals("COSMOS")&&plantype.equals("MA")))
		{
			validate(medicalEobText);
			System.out.println("for MA medical Eob is diplayed ====>"+ (medicalEobText.isDisplayed()));
			return medicalEobText.isDisplayed();
		}
		else if ((domain.equals("NICE")&&plantype.equals("MA")))
		{
			System.out.println("Medical EOB is Displayed for MA NICE member" + (medicalEobText.isDisplayed()));
			return true;
		}
		//SHIP CLAIMS EOB
		else if ((domain.equals("NA") && plantype.equals("SHIP"))){
			System.out.println("for SHIP Eob is diplayed ====>"+ (ShipClaimsEobText.isDisplayed()));
			return ShipClaimsEobText.isDisplayed();			
			
		}
		else {
			System.out.println("for PDP prescription drug EOB's are diaplayed ====> "+ (PrescriptionEobText.isDisplayed()));
			return PrescriptionEobText.isDisplayed();

		}
	}
	/**
	 * @toDo : this method validates Learn More 
	 */

	public boolean validateLearnmoreaboutsection() {

		return learnmorefalse.isDisplayed() || learnmorePdp.isDisplayed();

	}
	/**
	 * @toDo : this method validates Down Load my Data Button
	 */
	public /*Boolean*/ void validateDownloadMyDataButton(){
		CommonUtility.waitForPageLoad(driver, downloadmydatabutton, 60);
		validate(downloadmydatabutton);
		  System.out.println("!!! Blue Button-DownLoad my Data Button is displayed ===>"+downloadmydatabutton.isDisplayed());
		  downloadmydatabutton.click();
		  validate(leavingsitepopup);
		  System.out.println("!!!Proceed Button is displayed ===>"+leavingsitepopup.isDisplayed());
		  validate(cancelButtonDownloadPopUp);
		  System.out.println("!!!Cancel Button is displayed ===>"+cancelButtonDownloadPopUp.isDisplayed());
		if (downloadmydatabutton.isDisplayed())      
		{			
			downloadmydatabutton.click();
			//now click cancel and validate any element on page
			cancelButtonDownloadPopUp.click();
			if(driver.getTitle().contains("Claims")){
				System.out.println("Cancel button functionality is working as expected");
				//now again validate site leaving popup
				downloadmydatabutton.click();
				//now click on proceed and validate new tab opens
				//proceedToDownloadPopUp.click();
			waitforElement(leavingsitepopup);
			System.out.println("Proceed button is displayed ===>"+(leavingsitepopup.isDisplayed()));
			//now click on proceed and validate new tab opens
			//proceedToDownloadPopUp.click();
			if(leavingsitepopup.isDisplayed()){
				proceedButtonDownloadPopUp.click();
				switchToNewTab();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				CommonUtility.waitForPageLoad(driver, downloadmydatabutton, 60);
			if (downloadmydatabutton.isDisplayed())
			{			
				downloadmydatabutton.click();		
				waitforElement(leavingsitepopup);
				System.out.println("Proceed button is displayed ===>"+(leavingsitepopup.isDisplayed()));
				//proceedToDownloadPopUp.click();
				if(leavingsitepopup.isDisplayed()){
					proceedButtonDownloadPopUp.click();
					System.out.println("Proceed button functionality is working as expected");
				}
				cancelButtonDownloadPopUp.click();
				if(driver.getTitle().contains("Claims")){
					System.out.println("Cancel button functionality is working as expected");
				}
			}
			else 
			{
				System.out.println("Downlaod my data button is not displayed ");
			}
			}
			}
		}
			
}
	/**
	 * @toDo : this method validates required plan type
	 */
	public  boolean selectRequiredPlanType(String planType) {

		if (planType.equals("MA")){
			waitforElement(MA);
			MA.click();
			return MA.isSelected();

		}else if (planType.equals("MAPD")){

			waitforElement(MAPD);
			MAPD.click();
			return MAPD.isSelected();
		}		

		else if (planType.equals("PDP")) {
			PDP.click();
			waitforElement(PDP);
			return PDP.isSelected();

		}
		return false;

	}
	/**
	 * @toDo : this method validates claims by time interval 
	 */

	public void searchClaimsByTimeInterval(String toDate, String fromDate) {
		System.out.println("The title of the page is-------->"+driver.getTitle());
	//if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans from UnitedHealthCare - Claims Summary")){
		if(driver.getTitle().contains("Claims Summary")){

		


			sendkeys(from,fromDate);
			sendkeys(to,toDate);

			CommonUtility.waitForPageLoad(driver, searchButton,60);
			searchButton.click();
		}
	}
	/**
	 * @toDo : this method validates Plan Name
	 */
	
	public boolean validatePlanName(){
		
	     if(driver.getTitle().equalsIgnoreCase("Claims")){	
		validate(planame);
		System.out.println("!!! The Plan Name is ===>"+(planame.getText()));
	     }
	else
				System.out.println("************Plan Name not displayed ***************");
				return false;

		}
	
	
	/**
	 * @throws InterruptedException 
	 * @toDo : this method validates Claims by time period 
	 */
	public void searchClaimsByTimePeriod(String planType,String claimPeriod) throws InterruptedException {
		/*try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			WelcomePage_iPerceptionPresent.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			Alert alert = driver.switchTo().alert();
			System.out.println("FeedBack Modal Alert Present");
			if(validate(iPerceptionPopUp1)){
				System.out.println("FeedBack Modal Present");
				iPerceptionClose.click();
				if (validate(iPerceptionPopUp1)){
					System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
				}
				else
					System.out.println("FeedBack Modal Closed");
			}
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");
*/
	

		/*Thread.sleep(1000);
		try{
			if (iPerceptionPopUp.isDisplayed()) {
				iPerceptionPopUp.click();
			}
		}catch(Exception e)        {
			System.out.println("iPerception Pop Up not displayed");
		}*/
		/*
		//System.out.println("The title of Claims page is-------->"+driver.getTitle());
		//System.out.println("The URL of the Claims page is---------->"+driver.getCurrentUrl());
		if(driver.getCurrentUrl().equalsIgnoreCase("Claims")){	
			System.out.println("!!! The member is on Claims Summary page !!!");
			try { Thread.sleep(1000); } 
			catch (InterruptedException e) {						
				// TODO Auto-generated catch block 
				e.printStackTrace();
				}
			//System.out.println("!!! Going to select Last 24 months from the dropdown !!! ");
			if(planType.contains("SHIP")){
				System.out.println(planType +"SHIP plan type last 24 moths is going to select");
						
				last24months = driver.findElement(By.xpath("//div[@class='medical-claims shipCompSection']//div//*[@id='document-date']//option[contains(@value,'24 months')]"));
				//last24months = driver.findElement(By.id(".//*[@id='dateShip24MAtdd']"));
				//last24months.click();
			}
		System.out.println("The title of Claims page is-------->"+driver.getTitle());
		//System.out.println("The URL of the Claims page is---------->"+driver.getCurrentUrl());
		
		if(driver.getTitle().equalsIgnoreCase("Claims")){	
			System.out.println("!!! The member is on Claims Summary page !!!");
			validate(planame);
			System.out.println("The Plan Name is ===>"+(planame.getText()));*/
		/*	try { Thread.sleep(1000); } 
			catch (InterruptedException e) {						
				// TODO Auto-generated catch block 
				e.printStackTrace();
				}
		*/	//System.out.println("!!! Going to select Last 24 months from the dropdown !!! ");
		/*
			if(planType.contains("SHIP")){
				System.out.println(planType+"SHIP plan type last 24 moths is going to select");
						
				last24months = driver.findElement(By.xpath("//div[@class='medical-claims shipCompSection']//div//*[@id='document-date']//option[contains(@value,'24 months')]"));
			
			}
			
			else if (planType.contains("MAPD")){
			*/	
		if(planType.contains("SHIP")){
			System.out.println("For ship case, locate the drop down box and select 24 months option");
			Select dropdown=new Select (claimDropDownBoxForShip);	
			dropdown.selectByVisibleText("Last 24 months");
			System.out.println("Clicked 24 months option");
		}
		else if (planType.contains("PDP")) {
			System.out.println("!!!Claim type PDP is validated !!!");
			Select dropdown=new Select (claimDropDownBoxForFed);	
			dropdown.selectByVisibleText("Last 24 months");
			System.out.println("Clicked 24 months option");
			validate(pdpPrescriptionDrug);
		}
		else if (planType.contains("MAPD") || planType.contains("MA")||planType.contains("PCP")){
	
					/*validate (customSearch);
					System.out.println("!!! Custom search is seen in the view Claims From drop down ===>"+(customSearch.getText()));*/
					System.out.println("!!! Validating the drop down to select the claims from last 24 months  !!!");
					last24months = driver.findElement(By.id("date24MAtdd"));
					last24months.click();
					System.out.println("!!! Month Selected from the view claims from drop down is ====>"+(last24months.getText()));
					//Thread.sleep(2000);
					validate (Medical);
					System.out.println("!! Claim type Medical is validated!!! ");
					validate (Medical);
					if (planType.contains("MAPD") || planType.contains("PCP")) {
					validate(PrescriptionDrug);
	    			System.out.println("!!!Claim type PDP is validated !!!");
	    			PrescriptionDrug.click();
					/* 
					Select claimTypeDropdown = new Select(PrescriptionDrug);
					claimTypeDropdown.selectByVisibleText("PrescriptionDrug");
					//PrescriptionDrug = driver.findElement(By.id("claim-type"));
					PrescriptionDrug.click();
					*/
					
					System.out.println("!!! Claim Type PDP is clicked !!!");
					//Thread.sleep(3000);
					
				
					validate(claimsTablePrescriptionDrug);
					System.out.println("!!! Claims Table PDP is seen on the Claims Summary page!!!");
				    validate (RxNumberinthecalimstable);
				    System.out.println("Element on the Rx table is ===>"+ RxNumberinthecalimstable.getText());
					//	Assert.fail();
					/* 
					Select claimType = new Select(PrescriptionDrug);
					claimType.selectByVisibleText("PrescriptionDrug");*/
					System.out.println("!!! Claim Type Prescription Drug is Selected !!!");
					Medical.click();
					}
				
			}
			else{
				validate (customSearch);
				System.out.println("!!! Custom search is seen in the view Claims From drop down ===>"+(customSearch.getText()));
				System.out.println("!!! Validating the drop down to select the claims !!!");
			
				//last24months = driver.findElement(By.xpath("//div[@class='medical-claims']//h2[@ng-bind-html='planName']/parent::div//*[@id='document-date']//option[contains(@value,'24 months')]"));
			}
			
			/*last24months.click();
			System.out.println("!!! Month Selected from the view claims from drop down is ====>"+(last24months.getText()));*/
			/*try { Thread.sleep(10000); } 
			catch (InterruptedException e) {			
				
				// TODO Auto-generated catch block 
				e.printStackTrace();
				}
			*/
			/*Select claimsFrom = new Select(viewClaimsFrom);
			claimsFrom.selectByValue("24 months");*/
//			validate (claimsCopyText);
//			System.out.println(claimsCopyText.getText());
			validate (learnMoreAboutClaims);
			System.out.println("!!! Learn More About Claims link is seen on the claims Summary page ===>"+(learnMoreAboutClaims.isDisplayed()));
			//validate(claimsTablePagination);
			//System.out.println(" !!! Pagination is seen on Claims Summary page under the claims table ===>"+claimsTablePagination.isDisplayed());
		}
	
	
	/**
	 * @toDo : this method validates claims table
	 */
	public boolean validateClaimsTable() {
		CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage,60);
		validate(claimsTableMedical);
		System.out.println("!!! Claims Table is seen on the Claims Summary page!!!");
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if (validate(claimstablemoreinfolink)) {
			System.out.println("more info seen claim summary page ==>" +claimstablemoreinfolink);
		}
		Assert.assertTrue("PROBLEM - should not get System Error message on claim page", !validate(systemErrorMsg));
		if(claimsTableMedical.isDisplayed() || claimsTablePrescriptionDrug.isDisplayed() || claimsTableSHIP.isDisplayed()){
			if (claimsTableMedical.isDisplayed())System.out.println("!!! Claims Table is seen for Federal members on Claims Summary page!!!");
			else if (claimsTablePrescriptionDrug.isDisplayed())System.out.println("!!! Claims Table is seen for PDP members on Claims Summary page!!!");
			else if (claimsTableSHIP.isDisplayed())System.out.println("!!! Claims Table is seen for Ship  members on Claims Summary page!!!");
						return true;
		}	
		else
		{
			System.out.println("!!!!!!!!! NOT Able to find the claim table !!!!!!!!! - MedicalTable="+claimsTableMedical.isDisplayed()+" | PrescriptionTable="+claimsTablePrescriptionDrug.isDisplayed()+" | ShipTable="+claimsTableSHIP.isDisplayed());
		//	validate(claimsTablePagination);
		//	System.out.println(" !!! Pagination is seen on Claims Summary page under the claims table ===>"+claimsTablePagination.isDisplayed());
		Assert.assertTrue("PROBLEM - no claims table showing, check to see if test user has any claims or getting system error, test assumes user will have claims for the given test range so the claims table should have show accordingly - MedicalTable="+claimsTableMedical.isDisplayed()+" | PrescriptionTable="+claimsTablePrescriptionDrug.isDisplayed()+" | ShipTable="+claimsTableSHIP.isDisplayed(), false);
		return false;
		}
		
		
	}
	/**
	 * @toDo: On Claims Summary page the member Validates the Download my data section.
	 */
	public void validateDownloadMyData() {
		CommonUtility.waitForPageLoad(driver, downloadmydatabutton, 60);
		validate(downloadmydatabutton);
		  System.out.println("!!! Blue Button-DownLoad my Data Button is displayed ===>"+downloadmydatabutton.isDisplayed());
		  downloadmydatabutton.click();
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  validate(leavingsitepopup);
		  System.out.println("!!!Leaving site popup is displayed ===>"+leavingsitepopup.isDisplayed());
		  validate(cancelButtonDownloadPopUp);
		  System.out.println("!!!Cancel Button is displayed ===>"+cancelButtonDownloadPopUp.isDisplayed());
		  validate(proceedButtonDownloadPopUp);
		  System.out.println("!!!Proceed Button is displayed ===>"+proceedButtonDownloadPopUp.isDisplayed());
		/*if (downloadmydatabutton.isDisplayed())      
		{			
			downloadmydatabutton.click();-*/
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			//now click cancel and validate any element on page
			cancelButtonDownloadPopUp.click();
			if(driver.getTitle().contains("Claims")){
				System.out.println("Cancel button functionality is working as expected");
				//now again validate site leaving popup
				//downloadmydatabutton.click();
				//now click on proceed and validate new tab opens
				//proceedToDownloadPopUp.click();
			//waitforElement(leavingsitepopup);
			//System.out.println("Site leaving pop up is displayed ===>"+(leavingsitepopup.isDisplayed()));
			//now click on proceed and validate new tab opens
			//proceedToDownloadPopUp.click();
			/*if(leavingsitepopup.isDisplayed()){
				//proceedButtonDownloadPopUp.click();
				//switchToNewTab();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				//capture next page title
				String pageTitle = driver.getTitle();
				System.out.println(pageTitle);
				if(driver.getTitle().contains("Medicare.gov")){
					System.out.println(driver.getTitle());
				}
				System.out.println("Proceed button functionality is working as expected");
				
				
			}*/
			
		}
		else 
		{
			System.out.println("Downlaod my data button is not displayed ");

		}
		
		}
	
	
		/*CommonUtility.waitForPageLoad(driver, downloadmydatabutton, 60);
		if (downloadmydatabutton.isDisplayed())
		{			
			downloadmydatabutton.click();		
			waitforElement(proceedToDownloadPopUp);
			System.out.println("Proceed button is displayed ===>"+(proceedToDownloadPopUp.isDisplayed()));
			//proceedToDownloadPopUp.click();
			if(proceedToDownloadPopUp.isDisplayed()){
				proceedButtonDownloadPopUp.click();
				System.out.println("Proceed button functionality is working as expected");
			}
			cancelButtonDownloadPopUp.click();
			if(driver.getTitle().contains("Claims")){
				System.out.println("Cancel button functionality is working as expected");
			}
		}
		else 
		{
			System.out.println("Downlaod my data button is not displayed ");
		}
	}*/
	
	 /* @toDo : this method validates Error Max claims reached 
	 */
	
	public boolean validateRxReachexMaxClaimsErrorMsg() {

		return rxErrorMsg.isDisplayed();
	}
	/**
	 * @toDo : this method validates Error greater than 24 months 
	 */
	public void validateShipGreaterThan24MonthsErrorMsg() {
		if (!shipDateRangeErrMsg.isDisplayed())
		Assert.fail(shipDateRangeErrMsg + "is not being displayed");

		// shipDateRangeErrMsg.isDisplayed();
	}
	/**
	 * @toDo : this method validates Error message greater than 24 months.
	 */	
	public void validateFedGreaterThan24MonthsErrorMsg() {
		validate(messageaftersrch);
		System.out.println("!!! The error message is seen. !!! ");
		messageaftersrch.isDisplayed();
		if(!messageaftersrch.isDisplayed())
		//if(!fedDateRangeErrMsg.isDisplayed())
			Assert.fail(messageaftersrch +"Is not being displayed");		
	}
	/**
	 * @toDo : this method validates ERROR message from date later than to date 
	 */	
	public void  validatefromDateLaterThanToDateError() {
		
		
			if(!fromDateLaterThanToDateError.getText().contains("Your From date needs to come before or")){
			Assert.fail(fromDateLaterThanToDateError + "is not beind dsiplayed");	
		}
		//fromDateLaterThanToDateError = driver.findElement(By.xpath("//*[@id="futureDateErrorDivErr"]/p/span/text()"));
		/*	
		if(!fromDateLaterThanToDateError.isDisplayed())
			Assert.fail(fromDateLaterThanToDateError + "is not beind dsiplayed");	*/	
	}
	/**
	 * @toDo : this method validates combo tab section
	 */
	public ClaimSummarypage comboTabSelection(){
		for (WebElement webElement : comboTabsOnclaimsPage) {
			System.out.println(webElement.getText());
			webElement.click();
			try {
				Thread.sleep(10000);
				last24months = driver.findElement(By.xpath("//div[@class='medical-claims']//h2[@ng-bind-html='planName']/parent::div//*[@id='document-date']//option[contains(@value,'24 months')]"));
				last24months.click();
				validateClaimsTable();
				if (validateClaimsTable() == true)
					break;
			} catch (InterruptedException e) {
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
	 * @throws InterruptedException 
	 * @toDo :Validate error message for PHIP member on Claims Summary page
	 */
public boolean ValidatePHIPErrorMessage() throws InterruptedException{
	    Thread.sleep(3000);
	     //if(driver.getTitle().equalsIgnoreCase("Claims")){	
		// System.out.println("!!! The member is on Claims Summary page with PHIP Plan  !!!");
		 validate(PHIPerrorMsg);		
		if (PHIPerrorMsg.isDisplayed()){			
			System.out.println("*************Error Message Displayed for PHIP Member on claims Summary page***************");
			System.out.println("*************Error Message : "+PHIPerrorMsg.getText()+"***************");
			return true;
			}
			else
				System.out.println("************Error message not displayed for PHIP Member on claims Summary page ***************");
				return false;
				}


		
 
     public void validateCustomSearch(){
    	 System.out.println("The title of the page is-------->"+driver.getTitle());
 		if(driver.getTitle().equalsIgnoreCase("Claims")){
 		String fdate = ("10/12/2012");
 		String tdate=("12/12/2016");
    	 validate (customSearchText );
       	 System.out.println("!!! Custom Search is dispalyed ==>"+customSearchText.isDisplayed());
       	validate(srch);
   	    System.out.println("!!! Search button is seen!!!");
    	 customSearchText.click();
    	// validate (fromDate);
    	 System.out.println(" !!! From Date is Displayed !!!"+fromDate.isDisplayed());
    	// validate(toDate);
    	 System.out.println(" !!! From Date is Displayed !!!"+toDate.isDisplayed());
    	 fromDate.clear();
    	 fromDate.click();
    	 fromDate.sendKeys(fdate);
    	 toDate.clear();
    	 toDate.click();
    	 toDate.sendKeys(tdate);
    	 srch.click();
    	 validate(messageaftersrch);    	 
    	 
     }
     }
     



public void NavigateToClaimsPage(){
	validate(claimsLink);
	if(claimsLink.isDisplayed()){
	System.out.println("Claims link is displayed");
	claimsLink.click();
	System.out.println("Claims link is clicked");
	
	
	}
	
}
  public FooterPage validatePageFooter(){
	  	  
	  	 
	  	 return new FooterPage(driver);
  }
  
  /**
	 * @toDo : Validate You have text 
	 */

     public void validateYouHavemessage() {
 		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 validate(Youhave);
 		if (Youhave.getText().contains("You have"))
 		{
 			System.out.println(Youhave.getText());
 			System.out.println("You have claims messgae displayed ");
 			//Assert.assertTrue(Youhave.getText().contains("You have")+"message is displayed", true);
 			
 		
 		}	
 		
 	} 
     /**
 	 * @toDo : Validate You have text 
 	 */
	public boolean validateYouHavemessage1() throws InterruptedException {  	
 			Thread.sleep(2000); 		
     	 validate(Youhave);
  		//if (Youhave.getText().contains("You have"))
     	if (Youhave.isDisplayed())
     	{
  			System.out.println(Youhave.getText());
  			System.out.println("You have claims messgae displayed ");
  			System.out.println("**** Message : "+Youhave.getText()+ " ****");
  			return true;  			
  		}
     	else
				System.out.println("************You have message not displayed *****");
		return false;
				} 		
   
     
     public void validateClaimsHeaderCopyText() {
  		// TODO Auto-generated method stub
  		if (clamsSummaryCopyText.getText().contains("Review your claims search"))
  		{
  			System.out.println(clamsSummaryCopyText.getText());
  			System.out.println("claims Summary page copy text is dipalyed ");
  			Assert.assertTrue(clamsSummaryCopyText.getText().contains("Review your claims search")+"copy text is displayed", true);
  		
  		}	
  	}

 public void validateClaimsFromDropDowns1() {
 		
		 
 		Select select = new Select(claimFromDropDown1);
 		System.out.println("Slected value is  =>" +select.getFirstSelectedOption());
 		for(int i=0;i<select.getOptions().size();i++){
 			System.out.println(select.getOptions().get(i).getAttribute("value"));
 		} 		
 	}
 /**
	 * @toDo : Validate claims FROM DROP DOWN
	 */
 public void validateClaimsFromDropDown2() {
		
 System.out.println("The title of Claims page is-------->"+driver.getTitle());
	//System.out.println("The URL of the Claims page is---------->"+driver.getCurrentUrl());
	
	if(driver.getTitle().equalsIgnoreCase("Claims")){
		System.out.println("!!! The member is on Claims Summary page !!!");
		validate(planame);
		System.out.println("The Plan Name is ===>"+(planame.getText()));
		validate(claimFromDropDown1);
		 System.out.println("*** Drop down for months visible***");	
		 
	 		Select select = new Select(claimFromDropDown1);
	 		System.out.println("Slected value is  =>" +select.getFirstSelectedOption());
	 		for(int i=0;i<select.getOptions().size();i++){
	 			System.out.println(select.getOptions().get(i).getAttribute("value"));
	 		} 	
	 		  }
	             }	
		
 public void validateLearnmoreaboutsection1(){
	 validate(learmore);
	 System.out.println("***Laearn More link is seen on the claim summart page ***");
 }


	 public void validateClaimsPlantype() {
	 		// TODO Auto-generated method stub
	 		Select select = new Select(clamtypeFromDropDown);
	 		System.out.println("Slected value is  =>" +select.getFirstSelectedOption());
	 		for(int i=0;i<select.getOptions().size();i++){
	 			System.out.println(select.getOptions().get(i).getAttribute("value"));
	 		}
	 	}

		public ClaimDetailsPage navigateToClaimDetailsPage() throws InterruptedException {
			// TODO Auto-generated method stub
			CommonUtility.waitForPageLoadNew(driver, claimstablemoreinfolink, 60);
			scrollToView(claimstablemoreinfolink);
			claimstablemoreinfolink.click();
			int counter =0;
			do{
				if(counter<=12)
				Thread.sleep(5000);
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
		

			

		

		public 	 ClaimSummarypage comboTabSelection1(){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (WebElement webElement : comboTabsOnclaimsPage) {
				System.out.println(webElement.getText());
				webElement.click();
				

}
			return new ClaimSummarypage(driver);	
			}
		
		// @SuppressWarnings("deprecation")
		public void validatePCPtext(){
			/* WebElement t = PCPtext;
			 if (t.getText().contains ("plan members can view claims"))
			 //if(driver.getCurrentUrl().contains("/documents/medication-program"))
				{
					System.out.println(t.getText());
					Assert.assertTrue(true);
				}
				else
				{
					Assert.fail();
				}*/
			 validate(PCPtext);
			 System.out.println("PCP text is seen on the page" + PCPtext.isDisplayed());
		 }
		 
		    /**
			 * @toDo : Validate EOB section for PDP plans 
			 */
		 
		 public void validateEobPDP(){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				validate(PrescriptionEobText1);
				System.out.println("PDP EOB is displayed"  +  PrescriptionEobText.isDisplayed());
			}
		 
	   
		    /**
			 * @toDo : Validate claims table for PDP plans
			 */
		 public void validateClaimsTablePDP() {
				CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage,60);
				validate(claimsTablePrescriptionDrug);
				System.out.println("!!! Claims Table is seen on the Claims Summary page!!!"+claimsTablePrescriptionDrug.isDisplayed());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		 
		 /*
			 * this method checks that Claims Summary Sub Navigation Link 
			 * under Claims is NOT displayed
			 */
			
			public void validateClaimsSummarySubNavNotDisplayed() throws InterruptedException 
			{
			     
			    System.out.println("Now checking for claims summary sub navigation of Claims");
			     
				Dimension size = driver.findElement(By.id("claimsummaryC1")).getSize();
				System.out.println(size);
				int height = size.getHeight();
				System.out.println("Height is "+height);
				int width = size.getWidth();
				System.out.println("Width is "+width);
				if (height == 0)
				{
					System.out.println("Claims Summary Sub Navigation Link under Claims was NOT displayed");
			 	}
			    	
				else 
				{
					System.out.println("Claims Summary Sub Navigation Link under Claims was displayed, Test step is failed due to it");
			    	Assert.fail("Claims Summary Sub Navigation Link under Claims was displayed, Test step is failed due to it");	
				}
				
			}	
			
			public void validateExplanationOfBenefitsSubNavNotDisplayed() throws InterruptedException 
			{
			    Thread.sleep(2000);  
			    System.out.println("Now checking for Explanation of benefits sub navigation of Claims");
			     
				Dimension size = driver.findElement(By.id("eobC1")).getSize();
				System.out.println(size);
				int height = size.getHeight();
				System.out.println("Height is "+height);
				int width = size.getWidth();
				System.out.println("Width is "+width);
				if (height == 0)
				{
					System.out.println("Explanation of Benefits Sub Navigation Link under Claims was NOT displayed");
			 	}
			    	
				else 
				{
					System.out.println("Explanation of Benefits Sub Navigation Link under Claims was displayed, Test step is failed due to it");
			    	Assert.fail("Explanation of Benefits Sub Navigation Link under Claims was displayed, Test step is failed due to it");	
				}
				
			}	
			
			
			public void verifyCorrectMessageForPreEffectiveMembers() throws InterruptedException 
			{
			    Thread.sleep(2000);  
			    System.out.println("Now checking for message on Claims Page for Pre-effective members");
			    System.out.println("The message displayed on screen is "+messageForPreeffective.getText());
				if(!messageForPreeffective.getText().contains("When your plan starts,"))
              	  Assert.fail("Correct message is not displayed");
				System.out.println("Assert for preeffective message on claims page was passed");
				
			}
			
			
			public void verifyCorrectTechSupportNumberForPreEffectiveMembers() throws InterruptedException 
			{
				
			    System.out.println("Now checking for Tech Support Number for Pre-effective members on claims page");
			    System.out.println("The Tech Support phone number displayed on screen is "+preEffectiveTechSupportNumber.getText());
				Assert.assertEquals(preEffectiveTechSupportNumber.getText(),"1-888-980-8125");
				System.out.println("Assert for correct Tech Suppport Phone Number on claims page was passed");
				
			}
			public void verifyPaymentTabIsNotDisplayedForPreEffectiveMembers() throws InterruptedException 
			{
				
				try {
			    	driver.findElement(By.xpath("//a[contains(text(),'Premium Payments')]"));
			    	System.out.println("Premium Payment tab was displayed on Claims secondary page");
			    	Assert.fail("Premium Payment tab was displayed, Test step is failed");
			 } catch (NoSuchElementException e) {
			        // TODO Auto-generated catch block
				   System.out.println("Premium Payment tab was not displayed on Claims secondary page, Test Step is Passed ");
			  }
			    
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
			
			public boolean verifyPrintAndDownloadOption() {
				if(MRScenario.environment.equalsIgnoreCase("team-a"))
				{
					CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage,60);				
					validateNew (validateclaimsprintbutton);
					validateNew (validateclaimsdownloadbutton);
					return true;	
				}else{
					return true;
				}
								
			}

			public boolean validatePrintAndDownloadOption() {
				if(MRScenario.environment.equalsIgnoreCase("team-a"))
				{
				CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage,60);
				String winHandleBefore = driver.getWindowHandle();
				validateclaimsdownloadbutton.click();
				validateclaimsprintbutton.click();
				switchToNewTab();
				System.out.println("New window = "+driver.getTitle());
				driver.switchTo().window(winHandleBefore);
				System.out.println("Main window = "+driver.getTitle());				
				return true;
				}else{
					return true;
				}
			}

			public ProfileandPreferencesPage navigateDirectToProfilePage() {
			
				if(driver.findElement(By.id("accountprofile")).isDisplayed()){
					 driver.findElement(By.id("accountprofile")).click();
					 driver.findElement(By.linkText("Account Settings")).click();
				}else
					Assert.fail("Account profile dropdown not found");
				CommonUtility.waitForPageLoadNew(driver, driver.findElement(By.xpath("//h1[contains(text(),'Account Settings')]")),20 );
				if (driver.getCurrentUrl().contains("profile")) {
					 System.out.println("Landed on Account Settings page");
					 return new ProfileandPreferencesPage(driver);
				 }
				return null;
			}
			
			//vvv note:	added for def1041	
			public void validateGreaterThanTwoYearError(String planType) {
				WebElement errorTextElement=greatederThanTwoYearsError;
				if (planType.equals("SHIP")) {
					errorTextElement=greatederThanTwoYearsErrorShip;
				}
				if(!errorTextElement.getText().contains("The time between your From date and your To date cannot be more than 24 months.For help with claims older than 24 months, call Customer Service at the number listed on the Contact Us web page.")){
					Assert.fail(errorTextElement + "is not beind dsiplayed");	
				}
			}

			public int getNumClaims(String range, String claimType) {
				int sleepTimeInSec=10;
				if (range.equals("Last 12 months") || range.equals("Last 24 months") || range.equals("Custom search")) {
					sleepTimeInSec=15;
				}
				try {
					Thread.sleep(sleepTimeInSec*1000); //the claims take time to load sometimes, if don't way then it will think 0 claims
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				WebElement numClaimsElement=numberOfClaims;
				if (range.equalsIgnoreCase("custom search")) {
					if (claimType.equalsIgnoreCase("prescription drug")) {
						numClaimsElement=numberOfClaimsPrescriptionDrugCustomSearch;
					} else if (claimType.equalsIgnoreCase("medical")) {
						numClaimsElement=customSearchNumberOfClaims;
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
				//MA - Medical
				//MAPID | PCP - Medical & Prescription drug
				//PDP - Prescription drug
				//SHIP - no Medical or Prescription drug
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
				} else if (planType.equals("MAPD") || planType.equals("MA") || planType.equals("PCP") || planType.equals("MEDICA")){
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

					if (planType.equals("MA")) {
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
				validate (learnMoreAboutClaims);
				System.out.println("!!! Learn More About Claims link is seen on the claims Summary page ===>"+(learnMoreAboutClaims.isDisplayed()));
			}

			public boolean verifyPrintAndDownloadOptions(int numClaims) {
				boolean result=false;
				CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage,60);
				if (numClaims >0) {
					System.out.println("Has claim(s), expect to see print and download buttons");
					if (validate(validateclaimsprintbutton) && validate(validateclaimsdownloadbutton)) {
						result=true;
					} else {
						result=false;
					}
				} else {
					System.out.println("Has no claim, expect NOT to see print and download buttons");
					if (!validate(validateclaimsprintbutton) && !validate(validateclaimsdownloadbutton)) {
						result=true;
					} else {
						result=false;
					}
				}
				return result;	
			}

			public HashMap<String,String> gatherDataFromSummaryPage(String claimType, int rowNum, String claimsSystem, boolean hasYourShare) {
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
						if (claimsSystem.contains("NICE")) {
							xpath="//table[@id='medical']//tr["+rowNum+"]//td[8]";
						} else {
							xpath="//table[@id='medical']//tr["+rowNum+"]//td[7]";
						}
						element=driver.findElement(By.xpath(xpath));
						Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", validate(element));
						value=element.getText().trim();
						dataMap.put(key, value);
					} else {
						if (claimsSystem.contains("NICE")) {
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
					//System.out.println("TEST - Converted date format from '"+inputDateString+"' to  '" + dateStr+"'");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return dateStr;
			}

			public void searchClaimsByTimeInterval(String planType, String toDate, String fromDate) {
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
				scrollToView(row);
				row.click();
				int counter =0;
				do{
					if(counter<=12)
						Thread.sleep(5000);
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

			public void validateSystemErrorMsgNotExist() {
				Assert.assertTrue("PROBLEM - located System Error",!validate(systemErrorMsg));
			}
			//^^^ note:	added for def1041			
}
