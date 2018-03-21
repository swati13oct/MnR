package pages.memberrdesignVBF;

/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
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
	
	@FindBy(css = ".claimsTotalTable")
	public WebElement claimstotalTable;
	
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

		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		validateNew(claimDetailPageHeader);
		// TODO Auto-generated method stub

	}
	
/***
 * 
 */
	@SuppressWarnings("deprecation")
	public void validateClaimsTableInDetailsPage() {
		CommonUtility.waitForPageLoadNew(driver, claimDetTableMainSection, 40);
			Assert.assertTrue(claimDetTableMainSection.isDisplayed());
		
	}

/***
 * 
 */
	public void validateClaimsTotalInDetailsPage() {
		validateNew(claimstotalTable);
		if(claimstotalTable.isDisplayed()){
			Assert.assertTrue(true);			
		}
		else{
			Assert.assertTrue("Claims Total is not present in Claims Details Page", false);
		}
		
	}
	
}
