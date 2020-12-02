package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ShopForPlanNavigationPage extends UhcDriver {

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

	@FindBy(xpath = "//div[contains(@id,'aside-second')]//h1")
	private WebElement heading;

	@FindBy(xpath = "//div[@id='widget_POmb5hgvb0afo9HIaTIbiQ']/div/a")
	private WebElement GetStarted;

	@FindBy(xpath = "//input[contains(@title,'ZIP Code')]")
	private WebElement ZIPcode;

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
	
	@FindBy(xpath = "//*[contains(@id,'planTypesColumn')]//*[contains(text(),'Shop')]")
	private WebElement shopLink;

	@FindBy(xpath = "//a[contains(@href,'ma-enrollment')]")
	private WebElement maLeanHowToEnrollLink;
	
	@FindBy(xpath = "(//a[contains(@href,'/shop/dual-special-needs-plans.html')])[2]")
	private WebElement dsnpLeanHowToshopLink;
	
	@FindBy(xpath = "(//a[contains(@href,'/shop/prescription-drug-plans.html')])[2]")
	private WebElement pdpLeanHowToshopLink;
	@FindBy(xpath = "(//a[contains(@href,'/shop/medicare-advantage-plans')])[2]")
	private WebElement maLeanHowToshopLink;
	
	@FindBy(xpath = "(//a[contains(@href,'/shop/medicare-supplement-plans.html')])[2]")
	private WebElement msLeanHowToshopLink;
	
	@FindBy(xpath = "//div[@id='accordion2']//h3[text()='Enrollment']")
	private WebElement EnrollmentLink;

	public ShopForPlanNavigationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, ShopForaplan, 60);
		validateNew(ShopForaplan);
	}

	public EnrollmentBasicsPage enrollLinkOnShopPlan() throws Exception {
		waitforElement(enrollLink);
		jsClickNew(enrollLink);
		Thread.sleep(4000);
		if (validate(maLeanHowToEnrollLink)) {
			waitforElement(maLeanHowToEnrollLink);
			System.out.println("OLE Learn More Modal is Displayed");
			return new EnrollmentBasicsPage(driver);
		}
		return null;
	}

	public ShopPage ShopLinkOnShopPlan() throws Exception {
		waitforElement(shopLink);
		jsClickNew(shopLink);
		Thread.sleep(4000);
		return new ShopPage(driver);
		
	}
	
	
	
	public void clickONshopLink(String plantype, String planName) throws Exception{
		if(plantype.equals("SNP")){
			waitforElement(dsnpLeanHowToshopLink);
			jsClickNew(dsnpLeanHowToshopLink);
			Thread.sleep(5000);
		
		}
		else if(plantype.equals("PDP")){
			waitforElement(pdpLeanHowToshopLink);
			jsClickNew(pdpLeanHowToshopLink);
			Thread.sleep(5000);
		}	
		
		else if(plantype.equals("MAPD") || plantype.equals("MA")){
			waitforElement(maLeanHowToshopLink);
			jsClickNew(maLeanHowToshopLink);
			Thread.sleep(5000);
		}	
	}

	public ShopPage ShopLinkOnMedsuppPlan() throws Exception {
		waitforElement(shopLink);
		jsClickNew(shopLink);
		Thread.sleep(4000);
		if (validate(msLeanHowToshopLink)) {
			waitforElement(msLeanHowToshopLink);
			jsClickNew(msLeanHowToshopLink);
			threadsleep(2000);
			System.out.println("Shop Page Medsupp Plan is Displayed");
			//return new ShopPage(driver);
		}
	//	return null;
		return null;
	}
}
