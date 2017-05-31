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

	@FindBy (xpath=".//*[@id='claimSearchButton']")
	private WebElement claimSearch;

	@FindBy(xpath=".//*[@id='claimDetailsHeader']")
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
	
	@FindBy(className = "claimdettable")
	public WebElement claimsTable;
	
	public ClaimDetailsPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, ClaimDetailsPage, 60);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub

	}
	
	@SuppressWarnings("deprecation")
	public boolean validateClaimSearch() {
		// TODO Auto-generated method stub
		System.out.println("validateClaimSearch not found------"+ claimSearch.isDisplayed());
		return claimSearch.isDisplayed();
		
	}
	public void validateHeader() {
		// TODO Auto-generated method stub
		if(myCaimsDetailsText.getText().equals("My Claims Detail")){
			Assert.assertTrue(true);
			System.out.println("validateHeader");
		}
		else{
			System.out.println("exception");
			Assert.fail("Claim Details Page Header Not found");
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
		if(claimsTable.isDisplayed()){
			Assert.assertTrue(true);
		}
			else{
				Assert.assertTrue("Claims Table is not present in Claims Details Page", false);
		}
		
	}
	
}
