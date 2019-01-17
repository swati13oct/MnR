/**
 * 
 */
package pages.acquisition.ole;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class PlanPremiumPage extends UhcDriver{
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	@FindBy(xpath = "//*[@class='only-prelim']")
	private WebElement PageHeader;

	//Right Rail Elements

	@FindBy(xpath = "//*[@id='learn-more-ole']/a")
	private WebElement RightRail_LearnMoreLink;
	
	@FindBy(id = "tty-number")
	private WebElement RightRailTFN;
	
	@FindBy(xpath = "//*[@id='ole-plan-name']")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[@id='ole-zip']")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[@id='ole-premium']")
	private WebElement PremiumDisplay;
	
	@FindBy(xpath=".//*[@id='ole-form-content']//label[contains(text(),'I have read and agree')]")
	private WebElement agreeBtn;
	
	public PlanPremiumPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoad(driver, ZipCode_County, 30);
		validate(PageHeader);
		validateNew(ZipCode_County);
		System.out.println("Page header is Displayed : "+PageHeader.getText());	
	}

	public SupplementalBenefitsPage navigate_to_Supplemental_Riders_Page() {
		agreeBtn.click();
		validate(NextBtn);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);
		
		if(driver.getCurrentUrl().contains("optional-benefits")){
			System.out.println("OLE Supplemental Benefits page is Displayed");
			return new SupplementalBenefitsPage(driver);
		}
		else{
			System.out.println("OLE Supplemental Benefits page is Displayed");
			return null;
		}
	}	

	public AuthorizationPage navigate_to_Authorization_Page() {
		agreeBtn.click();
		validate(NextBtn);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);
		
		if(driver.getCurrentUrl().contains("authorization")){
			System.out.println("OLE Authorization page is Displayed : Navigation from Plan Premium Page Passed");
			return new AuthorizationPage(driver);
		}
		else{
			System.out.println("OLE Authorization page is Displayed : Navigation from Plan Premium Page Failed");
			return null;
		}
	}	



}