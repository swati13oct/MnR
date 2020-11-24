package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ShopPage extends UhcDriver {

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement ShopForaplan;

	@FindBy(xpath = ".//*[@id='updates-mobile-form']/div/div[2]/button")
	private WebElement submit;

	@FindBy(id = "updates-email")
	private WebElement updatesemail;

	@FindBy(xpath = "//*[@id='subnav_2']/div[2]/div/p")
	private WebElement successMessage;

	@FindBy(xpath = "//a[text()='Plan Selector']")
	private WebElement PlanSelector;

	@FindBy(xpath = "")
	private WebElement shopHeader;

	@FindBy(xpath = "//div[@id='widget_POmb5hgvb0afo9HIaTIbiQ']/div/a")
	private WebElement GetStarted;

	@FindBy(xpath = "//*[contains(@id,'zipcodemeded-0')]")
	private WebElement zipCodeField1;
	
	@FindBy(xpath = "//*[contains(@id,'zipcodemeded-1')]")
	private WebElement zipCodeField2;

	@FindBy(xpath = "//a[text()='Drug Cost Estimator']")
	private WebElement Drugcostestimator;

	@FindBy(xpath = "//a[text()='Pharmacy Search']")
	private WebElement Pharmacysearch;

	@FindBy(xpath = "//a[text()='Provider Search']")
	private WebElement Providersearch;

	@FindBy(xpath = "//a[@class='cta-button secondary']")
	private WebElement canceldrugsearch;

	@FindBy(xpath = "//input[@id='zipcodeTxt']")
	private WebElement zipcodetxt;

	@FindBy(xpath = "//select[@id='plan-type']")
	private WebElement chooseaplan;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement pcontinue;

	@FindBy(xpath = "//div[@id='planTypesColumn']//a[text()='Enroll']")
	private WebElement enrollLink;
	
	@FindBy(xpath = "//div[@id='planTypesColumn']//a[text()='Shop']")
	private WebElement enrollShopLink;

	@FindBy(xpath = "//a[contains(@href,'ma-enrollment')]")
	private WebElement maLeanHowToEnrollLink;
	
	@FindBy(xpath = "//*[contains(@href,'/shop/dual-special-needs-plans.html')and contains(text(),'Shop')]")
	private WebElement dsnpShopLink;
	
	@FindBy(xpath = "//*[contains(@href,'/shop/prescription-drug-plans.html')and contains(text(),'Shop')]")
	private WebElement pdpShopLink;
	
	@FindBy(xpath = "//*[contains(@href,'/shop/medicare-advantage-plans') and contains(text(),'Shop')]")
	private WebElement MAShopLink;
	
	@FindBy(xpath = "//a[contains(@href,'/shop/medicare-supplement-plans.html') and contains(text(),'Shop')]")
	private WebElement medSupShopLink;
	
	@FindBy(xpath = "//div[@id='accordion2']//h3[text()='Enrollment']")
	private WebElement EnrollmentLink;

	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(MAShopLink);
		validateNew(ShopForaplan);
	}

	public EnrollmentBasicsPage enrollLinkOnShopPlan() throws Exception {
		waitforElement(enrollLink);
		enrollLink.click();
		Thread.sleep(4000);
		if (validate(maLeanHowToEnrollLink)) {
			waitforElement(maLeanHowToEnrollLink);
			System.out.println("OLE Learn More Modal is Displayed");
			return new EnrollmentBasicsPage(driver);
		}
		return null;
	}

	public ShopPage ShopLinkOnShopPlan() throws Exception {
		waitforElement(enrollShopLink);
		enrollShopLink.click();
		Thread.sleep(4000);
		if (validate(dsnpShopLink)) {
			waitforElement(dsnpShopLink);
			System.out.println("Shop Page Plan is Displayed");
			return new ShopPage(driver);
		}
		return null;
	}
	
	
	
	public void clickONEnrollShopLink(String plantype, String planName) throws Exception{
		if(plantype.equals("SNP")){
			waitforElement(dsnpShopLink);
			jsClickNew(dsnpShopLink);
			//Thread.sleep(5000);
		
		}
		else if(plantype.equals("PDP")){
			waitforElement(pdpShopLink);
			jsClickNew(pdpShopLink);
			//Thread.sleep(5000);
		}	
		
		else if(plantype.equals("MAPD") || plantype.equals("MA")){
			waitforElement(MAShopLink);
			jsClickNew(MAShopLink);
			//Thread.sleep(5000);
		}
		waitForPageLoadSafari();
	}

	public ShopPage ShopLinkOnMedsuppPlan() throws Exception {
		waitforElement(enrollShopLink);
		enrollShopLink.click();
		//Thread.sleep(4000);
		if (validate(medSupShopLink)) {
			//waitforElement(medSupShopLink);
			jsClickNew(medSupShopLink);
			System.out.println("Shop Page Medsupp Plan is Displayed");
			return new ShopPage(driver);
		}
		return null;
	}

	public void clickOnMAShopButton() {
		validateNew(MAShopLink);
		jsClickNew(MAShopLink);
		waitForPageLoadSafari();
		validateNew(zipCodeField1);
		if(!driver.getCurrentUrl().contains("shop/medicare-advantage-plans.html")) {
			Assert.fail("MA plans page did not load properly");
		}
	}
	
	public void clickOnPDPShopButton() {
		validateNew(pdpShopLink);
		jsClickNew(pdpShopLink);
		waitForPageLoadSafari();
		validateNew(zipCodeField1);
		if(!driver.getCurrentUrl().contains("shop/prescription-drug-plans.html")) {
			Assert.fail("PDP plans page did not load properly");
		}
	}
	
	public void clickOnSNPShopButton() {
		validateNew(dsnpShopLink);
		jsClickNew(dsnpShopLink);
		waitForPageLoadSafari();
		validateNew(zipCodeField1);
		if(!driver.getCurrentUrl().contains("shop/dual-special-needs-plans.html")) {
			Assert.fail("SNP plans page did not load properly");
		}
	}
}
