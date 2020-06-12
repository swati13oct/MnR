/**
 * 
 */
package pages.acquisition.ole;

import org.openqa.selenium.By;
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
public class SupplementalBenefitsPage extends UhcDriver{
	
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
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class,'only-prelim')]")
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
	
	@FindBy(xpath = ".//*[@id='ole-form-content']//label[contains(text(),'No. I do not')]")
	private WebElement ridersNoBtn;
	
	@FindBy(xpath = "//input[@type='radio']/parent::span//label[contains(text(),'Yes, I want to add')]")
	private WebElement dentalRiderYes;
	
	@FindBy(xpath = "//input[@type='checkbox']/parent::span//label[contains(text(),'Yes, I want to add')]")
	public WebElement fitnessRiderYes;
	
	public SupplementalBenefitsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, ridersNoBtn, 30);
		validateNew(PageHeader);
		System.out.println("Page header is Displayed"+PageHeader.getText());	
	}

	public AuthorizationPage navigate_to_Authorization_Page() {
		validateNew(NextBtn);
		jsClickNew(NextBtn);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/
		
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Authorization')]")))){
			System.out.println("OLE Authorization page is Displayed : Navigation from Optional Benefits Page Passed");
			return new AuthorizationPage(driver);
		}
		else{
			System.out.println("OLE Authorization page is Displayed : Navigation from Optional Benefits Page Passed");
			return null;
		}
	}

	public void select_riders(String DentalRider, String FitnessRider) {
		if (DentalRider.contains("true")) {
			dentalRiderYes.isDisplayed();
			jsClickNew(dentalRiderYes);
		} else
			System.out.println("No rider available");
		if (DentalRider.contains("true")) {
			fitnessRiderYes.isDisplayed();
			jsClickNew(fitnessRiderYes);
		} else
			System.out.println("No rider available");
	}

}