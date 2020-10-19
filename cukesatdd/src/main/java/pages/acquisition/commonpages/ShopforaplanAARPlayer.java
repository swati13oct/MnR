package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ShopforaplanAARPlayer extends UhcDriver {

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
	
	@FindBy(xpath = "//div[@id='planTypesColumn']//a[text()='Shop']")
	private WebElement enrollShopLink;

	@FindBy(xpath = "//a[contains(@href,'ma-enrollment')]")
	private WebElement maLeanHowToEnrollLink;
	
	@FindBy(xpath = "(//a[contains(@href,'/shop/dual-special-needs-plans.html')])[2]")
	private WebElement dsnpLeanHowToEnrollShopLink;
	
	@FindBy(xpath = "(//a[contains(@href,'/shop/prescription-drug-plans.html')])[2]")
	private WebElement pdpLeanHowToEnrollShopLink;
	@FindBy(xpath = "(//a[contains(@href,'/shop/medicare-advantage-plans')])[2]")
	private WebElement maLeanHowToEnrollShopLink;
	
	@FindBy(xpath = "//div[@id='accordion2']//h3[text()='Enrollment']")
	private WebElement EnrollmentLink;

	public ShopforaplanAARPlayer(WebDriver driver) {
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
		enrollLink.click();
		Thread.sleep(4000);
		if (validate(maLeanHowToEnrollLink)) {
			waitforElement(maLeanHowToEnrollLink);
			System.out.println("OLE Learn More Modal is Displayed");
			return new EnrollmentBasicsPage(driver);
		}
		return null;
	}

	public ShopforaplanAARPlayer ShopLinkOnShopPlan() throws Exception {
		waitforElement(enrollShopLink);
		enrollShopLink.click();
		Thread.sleep(4000);
		if (validate(dsnpLeanHowToEnrollShopLink)) {
			waitforElement(dsnpLeanHowToEnrollShopLink);
			System.out.println("Shop Page Plan is Displayed");
			return new ShopforaplanAARPlayer(driver);
		}
		return null;
	}
	
	
	
	public void clickONEnrollShopLink(String plantype, String planName) throws Exception{
		if(plantype.equals("SNP")){
			waitforElement(dsnpLeanHowToEnrollShopLink);
			dsnpLeanHowToEnrollShopLink.click();
			Thread.sleep(5000);
		
		}
		else if(plantype.equals("PDP")){
			waitforElement(pdpLeanHowToEnrollShopLink);
			pdpLeanHowToEnrollShopLink.click();
			Thread.sleep(5000);
		}	
		
		else if(plantype.equals("MAPD") || plantype.equals("MA")){
			waitforElement(maLeanHowToEnrollShopLink);
			maLeanHowToEnrollShopLink.click();
			Thread.sleep(5000);
		}	
	}

}
