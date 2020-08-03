package pages.dashboard_deprecated.member.ulayer;
import java.util.List;

import org.openqa.selenium.By;
/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

/**
 * Functionality : this page validates the Claim Summary page.
 */
public class ClaimSummarypage extends UhcDriver{

	

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

	@FindBy(xpath = "//option[@value = 'custom-search']")
	private WebElement customSearch;
	
	@FindBy (xpath = "//div[@class='medical-claims']//h2[@ng-bind-html='planName']/parent::div//*[@id='document-date']//option[contains(@value,'24 months')]")
	private WebElement last24months;
	
	@FindBy(xpath="//div[normalize-space()='Prescription Drug']")
	private WebElement claimTypePDP;

	@FindBy(id="document-date")
	private WebElement viewClaimsFrom;
	

	@FindBy (xpath="(.//*[@id='summaryview']//section/div/div/div/p)[1]")                    
	private WebElement claimsCopyText;

	@FindBy (xpath="(.//*[@id='summaryview']//section/div/div/div/p)[2]")                    
	private WebElement claimsCopyText2;

	@FindBy (xpath=".//*[@id='table-medical']/div[1]/div[1]/div/h2[1]")
	private WebElement dynamicNumberOfClaimsText;

	@FindBy (xpath=".//*[@id='table-medical']/div[1]/div[1]/div/h2[2]")
	private WebElement dynamicNumberOfClaimsTextPdp;

	@FindBy (id = "medical")
	private WebElement claimsTableMedical;

	@FindBy (id = "prescriptionDrug")
	private WebElement claimsTablePrescriptionDrug;
	
	@FindBy (id = "ship")
	private WebElement claimsTableSHIP;
	
	@FindBy (xpath=".//*[@id='summaryview']/div/div/main/div/div[2]/section/div/div/div[2]/div/div/ul")
	private WebElement claimsTablePagination;

	//@FindBy (xpath="//div[not (contains(@class,'ng-hide')) and contains(@ng-show,'AEM')]//div[@id='ma_mapd']//a")
	@FindBy (xpath="(.//p[contains(text(),'Medical EOB')])[2]/ancestor::div[1]")
	//@FindBy (xpath="//div[@class='parsys summaryParsys']/div/div[not (contains(@class,'ng-hide'))][1]//a[contains(@class,'btn btn--secondary')]")
	//@FindBy (xpath = "//div[@class='parsys summaryParsys']/div/div[not (contains(@class,'ng-hide'))][1]//span[text()='Medical EOB']/parent::a[contains(@class,'btn btn--secondary')]")
	private WebElement medicalEobText;

	//@FindBy (xpath="//div[not (contains(@class,'ng-hide')) and contains(@ng-show,'AEM')]//div[@id='pdp_mapd']//a")
	@FindBy (xpath="(.//p[contains(text(),'Prescription Drug EOB')])[1]/ancestor::div[1]")
	//@FindBy (xpath = "//div[@class='parsys summaryParsys']/div/div[not (contains(@class,'ng-hide'))][1]//a[contains(@class,'btn btn--secondary')]")
	//@FindBy (xpath = "//div[@class='parsys summaryParsys']/div/div[not (contains(@class,'ng-hide'))][1]//p[text()='Prescription Drug EOB']/following::a[contains(@class,'btn btn--secondary')][1]")
	private WebElement PrescriptionEobText;
	
	@FindBy (xpath="//span[text()='Ship EOB']/parent::a")
	private WebElement ShipClaimsEobText;

	@FindBy (xpath=".//*[@id='table-medical']/div[2]/div[1]/div/a")
	private WebElement learnmorefalse;

	@FindBy (xpath=".//*[@id='table-medical']/div[2]/div[2]/div/a")
	private WebElement learnmorePdp;

	@FindBy (xpath=".//a[@class='downloadMyDataLink']")
	private WebElement downloadmydatabutton;

	@FindBy (xpath=".//*[@id='siteleaving-popup-overlay']")
	private WebElement proceedToDownloadPopUp;

	//@FindBy (xpath="(//button[@class="btn btn--primary margin-none"])[1]")
	@FindBy (xpath ="(//*[text()='Search'])[1]")
	private WebElement searchButton;
	

	@FindBy (id="custom-from")
	private WebElement from;

	@FindBy (id="custom-to")
	private WebElement to;
	@FindBy (xpath = ".//*[@id='errorMsg']/div/p")
	private WebElement rxErrorMsg;
	
	@FindBy (css = ".ng-scope>p>span")
	private WebElement shipDateRangeErrMsg;
	
	@FindBy (css = ".color-red.semi-bold>p>span")
	private WebElement fedDateRangeErrMsg;
	
	@FindBy (css = ".color-red.semi-bold>p>span")
	private WebElement fromDateLaterThanToDateError;
	

	@FindBy (xpath= "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li")
	private List<WebElement> comboTabsOnclaimsPage;
	


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


	@SuppressWarnings("deprecation")
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

		return claimsTableMedical.isDisplayed()&& claimsTablePagination.isDisplayed();

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
			System.out.println("for MA medical Eob is diplayed ====>"+ (medicalEobText.isDisplayed()));
			return medicalEobText.isDisplayed();
		}
		else if ((domain.equals("NICE")&&plantype.equals("MA")))
		{
			System.out.println("Medical EOB is not Displayed for MA NICE member");
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
	public Boolean validateDownloadMyDataButton(){

		System.out.println("download my data button is displayed ====>"+ (downloadmydatabutton.isDisplayed()));

		if (downloadmydatabutton.isDisplayed())

		{			
			downloadmydatabutton.click();		
			waitforElement(proceedToDownloadPopUp);
			System.out.println("proceed button pop up is displayed ===>"+(proceedToDownloadPopUp.isDisplayed()));


			return proceedToDownloadPopUp.isDisplayed();
		}
		else 
		{
			System.out.println("bownlaod my data button is not displayed ");
			return false;
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
		if(driver.getTitle().equalsIgnoreCase("Claims")){

			customSearch.click();

			sendkeys(from,fromDate);
			sendkeys(to,toDate);

			CommonUtility.waitForPageLoad(driver, searchButton,60);
			searchButton.click();
		}
	}
	/**
	 * @toDo : this method validates Claims by time period 
	 */
	
	public void searchClaimsByTimePeriod(String planType,String claimPeriod) {
		System.out.println("The title of the page is-------->"+driver.getTitle());
		System.out.println("The URL of the page is---------->"+driver.getCurrentUrl());
		if(driver.getTitle().equalsIgnoreCase("Claims")){
			
			
			try { Thread.sleep(10000); } 
			catch (InterruptedException e) {						
				// TODO Auto-generated catch block 
				e.printStackTrace();
				}
			
			if(planType.contains("SHIP")){
				System.out.println(planType+"SHIP plan type last 24 moths is going to select");
						
				last24months = driver.findElement(By.xpath("//div[@class='medical-claims shipCompSection']//div//*[@id='document-date']//option[contains(@value,'24 months')]"));
			
			}else{
				
				last24months = driver.findElement(By.xpath("//div[@class='medical-claims']//h2[@ng-bind-html='planName']/parent::div//*[@id='document-date']//option[contains(@value,'24 months')]"));
							}
			
			//Select dropdown = new Select(driver.findElement(By.xpath("//div[@class='medical-claims']//h2[@ng-bind-html='planName']/parent::div//*[@id='document-date']//option[contains(@value,'24 months')]")));
			
			//dropdown.selectByIndex(4);
			//CommonUtility.waitForPageLoad(driver, last24months, 60);
			last24months.click();
			try { Thread.sleep(10000); } 
			catch (InterruptedException e) {			
				
				// TODO Auto-generated catch block 
				e.printStackTrace();
				}
			
			/*Select claimsFrom = new Select(viewClaimsFrom);
			claimsFrom.selectByValue("24 months");*/
		}
	}
	/**
	 * @toDo : this method validates claims table
	 */
	public boolean validateClaimsTable() {
		CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage,60);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(claimsTableMedical.isDisplayed() || claimsTablePrescriptionDrug.isDisplayed() || claimsTableSHIP.isDisplayed()){
			System.out.println("!!!!!!!!! Able to find the claims table !!!!!!!!!");
			return true;
			
		}	
		else
		{
			System.out.println("!!!!!!!!! NOT Able to find the claim table !!!!!!!!!");
		Assert.fail();
		return false;
		}
	}
	/**
	 * @toDo : this method validates Download My Data
	 */
	public void validateDownloadMyData() {
		CommonUtility.waitForPageLoad(driver, downloadmydatabutton, 60);
		if (downloadmydatabutton.isDisplayed())

		{			
			downloadmydatabutton.click();		
			waitforElement(proceedToDownloadPopUp);
			System.out.println("Proceed button is displayed ===>"+(proceedToDownloadPopUp.isDisplayed()));
			proceedToDownloadPopUp.click();
			/*if(proceedToDownloadPopUp.isDisplayed()){
				proceedButtonDownloadPopUp.click();
				System.out.println("Proceed button functionality is working as expected");
			}

			cancelButtonDownloadPopUp.click();
			if(driver.getTitle().contains("Claims")){
				System.out.println("Cancel button functionality is working as expected");
			}
*/

		}
		else 
		{
			System.out.println("Downlaod my data button is not displayed ");

		}
	}
	/**
	 * @toDo : this method validates Error Max claims reached 
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
		
		if(!fedDateRangeErrMsg.isDisplayed())
			Assert.fail(fedDateRangeErrMsg +"Is not being displayed");		
	}
	/**
	 * @toDo : this method validates ERROR message from date later than to date 
	 */	
	public void  validatefromDateLaterThanToDateError() {
		
		
		if(!fromDateLaterThanToDateError.isDisplayed())
			Assert.fail(fromDateLaterThanToDateError + "is not beind dsiplayed");		
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
	
}






