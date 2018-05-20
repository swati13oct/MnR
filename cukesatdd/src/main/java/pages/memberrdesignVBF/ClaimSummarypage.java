package pages.memberrdesignVBF;

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

@SuppressWarnings("deprecation")
public class ClaimSummarypage extends UhcDriver{

	@FindBy(css = ".claim-results")
	private WebElement ClaimsSummaryPage;
	
	@FindBy (xpath = "//div[@class='medical-claims']//h2[@ng-bind-html='planName']/parent::div//*[@id='document-date']//option[contains(@value,'24 months')]")
	private WebElement last24months;

	@FindBy(xpath="//select[@name='document-date' and not(contains(@ng-hide,'todate'))]")
	private WebElement viewClaimsFrom;

	@FindBy (id = "medical")
	private WebElement claimsTableMedical;

	@FindBy (id = "prescriptionDrug")
	private WebElement claimsTablePrescriptionDrug;
	
	@FindBy (id = "ship")
	private WebElement claimsTableSHIP;
	
	@FindBy (xpath = "//div[@class='summaryParsys parsys']/div/div[not (contains(@class,'ng-hide'))][1]//span[text()='Medical EOB']/parent::a[contains(@class,'btn btn--secondary')]")
	private WebElement medicalEobText;

	@FindBy (xpath = "//div[@class='summaryParsys parsys']/div/div[not (contains(@class,'ng-hide'))][1]//p[text()='Prescription Drug EOB']/following::a[contains(@class,'btn btn--secondary')][1]")
	private WebElement PrescriptionEobText;
	
	@FindBy (xpath="//span[text()='Ship EOB']/parent::a")
	private WebElement ShipClaimsEobText;

	@FindBy (className="downloadLink")
	private WebElement downloadmydatabutton;
	
	@FindBy (id="siteleaving-popup-overlay")
	private WebElement proceedToDownloadPopUp;

	@FindBy (id = "cancelbtn")
	private WebElement cancelButtonDownloadPopUp;
	
	@FindBy(xpath = "//div[@class='claim-results']//table[not (contains(@class,'ng-hide'))]//tbody//tr[2]//a[text()='MORE INFO']")
	private WebElement claimstablemoreinfolink;
	
	@FindBy(className = "loading-block")
	public List<WebElement> loadingImages;
	
	public ClaimSummarypage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, viewClaimsFrom, 60);
	}

/***
 * 
 * @param domain
 * @param plantype
 * @return
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

	/***
	 * 
	 * @param planType
	 * @param claimPeriod
	 */
	public void searchClaimsByTimePeriod(String planType,String claimPeriod) {
		
			if(planType.contains("SHIP")){
				System.out.println(planType+"SHIP plan type last 24 moths is going to select");
						
				last24months = driver.findElement(By.xpath("//div[@class='medical-claims shipCompSection']//div//*[@id='document-date']//option[contains(@value,'24 months')]"));
			
			}else{
				Select dateDropdown = new Select(viewClaimsFrom);
				dateDropdown.selectByVisibleText(claimPeriod);
							}
			
			if(loadingImages.size()>0){
				CommonUtility.waitForElementToDisappear(driver, loadingImages.get(0), 120);
				}
	}
/***
 * 
 */
	@SuppressWarnings("deprecation")
	public void validateClaimsTable() {
		CommonUtility.waitForPageLoadNew(driver, ClaimsSummaryPage,60);
		scrollToView(ClaimsSummaryPage);
		if(claimsTableMedical.isDisplayed() || claimsTablePrescriptionDrug.isDisplayed() || claimsTableSHIP.isDisplayed()){
			System.out.println("!!!!!!!!! Able to find the claims table !!!!!!!!!");
			
		}	
		else
		{
			System.out.println("!!!!!!!!! NOT Able to find the claim table !!!!!!!!!");
		Assert.fail("!!!!!!!!! NOT Able to find the claim table !!!!!!!!!");
		}
	}
/***
 * 
 */
	public void validateDownloadMyData() {
		scrollToView(downloadmydatabutton);
		CommonUtility.waitForPageLoadNew(driver, downloadmydatabutton, 60);
		if (downloadmydatabutton.isDisplayed()){				
			downloadmydatabutton.click();
			
			waitforElementNew(proceedToDownloadPopUp);
			System.out.println("Proceed button is displayed ===>"+(proceedToDownloadPopUp.isDisplayed()));
			validateNew(cancelButtonDownloadPopUp);
			cancelButtonDownloadPopUp.click();
		}
		else 
		{
			System.out.println("Downlaod my data button is not displayed ");

		}
	}
	
	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public pages.memberrdesignVBF.ClaimDetailsPage navigateToClaimDetailsPage() throws InterruptedException {
		CommonUtility.waitForPageLoadNew(driver, claimstablemoreinfolink, 60);
		scrollToView(claimstablemoreinfolink);
		jsClickNew(claimstablemoreinfolink);
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
			return new pages.memberrdesignVBF.ClaimDetailsPage(driver);

		}
		return null;
	}

	
}






