package pages.dashboard.member.ulayer;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;
/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;
public class ClaimDetailsPage extends UhcDriver{
	private PageData newClaimDetailspage;

	@FindBy (xpath=".//*[@id='claimSearchButton']/p/b")
	private WebElement claimSearch;
	
	@FindBy (id="claimDetailsHeader")
	private WebElement claimDetailPageHeader;
	
	@FindBy(xpath = "//html/body/div[2]/div/div/div/div/main/div/div[1]/div[2]/header/div/div/div/div/div/div/h2")
	private  WebElement myCaimsDetailsText;

	@FindBy(xpath=".//*[@id='claimdetailspage']")
	private WebElement ClaimDetailsPage;

	@FindBy(xpath=".//*[@id='dateRange']")
	private  WebElement  dateRange;

	@FindBy(xpath=".//*[@id='providerName']")
	private  WebElement providerName;

	@FindBy(id="claim-type")
	private WebElement claimTypeMAPD;


	@FindBy(xpath=".//*[@id='claimNumberLabel']")
	private WebElement claimNumber;

	@FindBy(xpath=".//*[@id='claimDynamicNum']")
	private WebElement claimNumDynamic;

	@FindBy (xpath=".//*[@id='claimTypeLabel']")                    
	private WebElement claimType;


	@FindBy (xpath=".//*[@id='claimDynamicType']")                    
	private WebElement claimsTypeDynamic;

	@FindBy (xpath=".//*[@id='claimStatusLabel']")
	private WebElement claimStatus;
	
	@FindBy (xpath=".//*[@id='claimDynamicStatus']")
	private WebElement claimStatusDynamic;

	@FindBy (xpath=".//*[@id='medicalEOB']")
	private WebElement medicalEOB;

	@FindBy (xpath=".//*[@id='viewPDF']")
	private WebElement viewPDF;
	
	@FindBy (xpath="//*[@id='learnmoreMA']")
	private WebElement learnmoreMA;
	
	@FindBy (xpath="//*[@id='learnmorePDP']")
	private WebElement learnmorePDP;
	
	@FindBy(css = ".claimDetTableMainSection")
	public WebElement claimDetTableMainSection;
	
	//@FindBy(className = "claimdettable")
	@FindBy(css = ".claimsTotalTable")
	public WebElement claimstotalTable;
	
	//@FindBy(id = "learnmoretoggleship")
	@FindBy(xpath = ".//*[@id='learnmoredetailstoggle']/p")
	private WebElement learnMoreLink;
	
	@FindBy(id = "eobClass")
	private WebElement headerEOB;
	
	@FindBy(xpath = ".//*[@id='ship_eob']/div/section/a/p")
	private WebElement EOB;
	
	@FindBy(xpath = ".//*[@id='cltotshippartb']/div/div[1]/div")
	private WebElement claimsTotalSHIP;
	
	@FindBy(xpath = ".//*[@id='cltotmednice']/div/div[1]/div/div")
	private WebElement claimsTotalFED;
	
	public ClaimDetailsPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		//CommonUtility.waitForPageLoad(driver, ClaimDetailsPage, 60);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		validate(claimDetailPageHeader);
		// TODO Auto-generated method stub

	}
	
	@SuppressWarnings("deprecation")
	public void validateClaimSearch() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(claimSearch.isDisplayed()){
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue("Claims Search button is not present in Claims Details Page", false);
		}
		
	}
	public void validateHeader() {
		if(myCaimsDetailsText.getText().equals("My Claims Details")){
			Assert.assertTrue(true);
		}
		else{

			Assert.assertTrue("Claims Details Header is not present in Claims Details Page", false);
		}
	}

	public boolean verifyDateRange(){
		System.out.println("verifyDateRange");
		return dateRange.isDisplayed();
	}


	public boolean verifyProviderName(){
		System.out.println("verifyProviderName");
		return providerName.isDisplayed();
	}


	public boolean verifyClaimNumber(){
		System.out.println("verifyClaimNumber");
		return claimNumber.isDisplayed();

	}

	public boolean verifyDynamicClaimNumber(){
		System.out.println("verifyDynamicClaimNumber");
		return claimNumDynamic.isDisplayed();

	}

	public boolean validateClaimType() {
		System.out.println("validateClaimType");
		return claimType.isDisplayed();

	}

	public boolean validateDynamicClaimType(){
		System.out.println("validateDynamicClaimType");
			return claimsTypeDynamic.isDisplayed();
		}
	public boolean validateClaimStatus(){
		System.out.println("validateClaimStatus");
		return claimStatus.isDisplayed();
	}
	public boolean validateDynamicClaimStatus(){
		System.out.println("validateDynamicClaimStatus");
		return claimStatusDynamic.isDisplayed();
	}
	public boolean validateMedicalEOBfordifferentDomainType(String domain, String plantype){

		if (domain.equals("COSMOS")&& plantype.equals("MAPD"))
		{
			System.out.println("validateMedicalEOBfordifferentDomainType");
			System.out.println("for MAPD COSMOS EOB's are displayed===> "+ (medicalEOB.isDisplayed() && viewPDF.isDisplayed()));
			return medicalEOB.isDisplayed() && viewPDF.isDisplayed();
		}
		return false;
		
	}
	
	public boolean validateDetailsLearnmoreaboutsectionDetails() {

		return learnmoreMA.isDisplayed() || learnmorePDP.isDisplayed();

	}

	@SuppressWarnings("deprecation")
	public void validateClaimsTableInDetailsPage() {
		validate(claimDetTableMainSection);
		if(claimDetTableMainSection.isDisplayed()){
			Assert.assertTrue(true);
		}
			else{
				Assert.assertTrue("Claims Table is not present in Claims Details Page", false);
		}
		
	}

	@SuppressWarnings("deprecation")
	public void validateLearnMoreInDetailsPage() {
		if(learnMoreLink.isDisplayed()){
			Assert.assertTrue(true);
		}
			else{
				Assert.assertTrue("Learn more section is not present in Claims Details Page", false);
		}
		
	}

	@SuppressWarnings("deprecation")
	public void clickOnEOB() {
		if(headerEOB.isDisplayed()){
			Assert.assertTrue(true);
			headerEOB.click();			
		}
		else{
			Assert.assertTrue("EOB link is not present in Claims Details Page", false);
		}
		
	}

	public void validateEOB() {
		if(EOB.isDisplayed()){
			Assert.assertTrue(true);
			EOB.click();			
		}
		else{
			Assert.assertTrue("Search your history button is not present in Claims Details Page", false);
		}
		
	}

	public void validateClaimsTotalInDetailsPage() {
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(claimstotalTable);
		if(claimstotalTable.isDisplayed()){
			Assert.assertTrue(true);			
		}
		else{
			Assert.assertTrue("Claims Total is not present in Claims Details Page", false);
		}
		
	}
	
}
