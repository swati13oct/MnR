package pages.member.ulayer;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.dashboard.eob.EOBPage;
import pages.dashboard.member.ulayer.ClaimSummarypage;
import pages.dashboard.member.ulayer.RallyDashboardPage;
import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.member.bluelayer.ConfirmOneTimePaymentPage;
import pages.member.bluelayer.DrugCostEstimatorPage;
import pages.member.bluelayer.HealthAndWellness;
import pages.member.bluelayer.ProfilePreferencesPage;
import pages.member.redesign.ContactUsPage;
import pages.redesign.PharmacySearchPage;

public class TestHarness extends UhcDriver{
	
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Payment')]")
	private WebElement PaymentPageLik;
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Claim')]")
	private WebElement claimsPageLink;
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Forms and Resource')]")
	private WebElement formsPageLink;
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'benefits')]")
	private WebElement benefitsPageLink;
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'profile')]")
	private WebElement profilePageLink;
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'preferences')]")
	private WebElement preferencesPageLink;
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'EOB Search')]")
	private WebElement eobPageLink;
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Payments')]")
	private WebElement paymentPageLink;
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Order Plan material')]")
	private WebElement orderPlanPageLink;
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Pharmacy')]")
	private WebElement pharmacyPageLink;
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'DCE')]")
	private WebElement dcePageLink;
	
	@FindBy(xpath="//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Contact Us')]")
	private WebElement contactUsPageLink;
	
	@FindBy(xpath="//a[contains(.,'Go to Payments page')]")                  
	private WebElement TeamHPaymentPage;
	
	@FindBy(linkText="Go to payment link page")
	private WebElement TeamCPaymentPage;
	
	@FindBy(id="home_2")
	private WebElement panelHome;
	
	@FindBy(id="claims_1")
	private WebElement panelClaims;
	
	@FindBy(id="findcarecost2")
	private WebElement panelFindCareCost;
	
	@FindBy(id="premiumpayment_3")
	private WebElement panelPremiumPayment;
	
	@FindBy(id = "healthwellness_3")
	private WebElement healthWellness;
	
	@FindBy(xpath="//header//h1")
	private WebElement heading;
	
	@FindBy(xpath = "//h1[@class='h4 margin-none']")
	private WebElement orderplanHeadertxt;
	
	
	public TestHarness(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(heading);	
		validate(orderPlanPageLink);	
		validate(claimsPageLink);
	}	
	
	public PaymentsOverview navigateToPaymentOverview() throws InterruptedException
	{
		System.out.println("Inside navigateToPaymentOverview functions");
/*		waitforElement(panelFindCareCost, 60);
		if(panelClaims.isEnabled()){
			panelClaims.click();*/
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//waitforElement(panelPremiumPayment, 60);
			validate(PaymentPageLik);
			PaymentPageLik.click();
			CommonUtility.checkPageIsReady(driver);
			if (driver.getTitle().equalsIgnoreCase("Overview")) {
				return new PaymentsOverview(driver);	
			}			
		//}
		return null;
	}
	
	public PaymentsOverview navigateToTeamHPaymentOverview() throws InterruptedException
	{
		System.out.println("Inside navigateToTeamHPaymentOverview functions");
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(15000);
		if(TeamHPaymentPage.isEnabled()){
			TeamHPaymentPage.click();
			System.out.println("Go to Payment link clicked");
			//Implementing direct navigation as PaymentLink in test harness is not getting clicked via selenium
			driver.get("https://team-h-medicare.uhc.com/content/medicare/member/payments/overview.html");
			return new PaymentsOverview(driver);
		}
		return null;
	}
	
	public PaymentsOverview navigateToTeamCPaymentOverview()
	{
		if(TeamCPaymentPage.isEnabled()){
			TeamCPaymentPage.click();
			return new PaymentsOverview(driver);
		}
		return null;
	}
	
	public void validateTestHarnessElements(String Category){
		RallyDashboardPage.checkModelPopup(driver);
		CommonUtility.checkPageIsReady(driver);
		/*if(!(("Ship").equalsIgnoreCase(Category))){
		validate(panelFindCareCost);
		}*/
		if(!(("GroupRetireeMapd").equalsIgnoreCase(Category))){
		validate(PaymentPageLik);
		}
		validate(formsPageLink);
		validate(claimsPageLink);
		validate(benefitsPageLink);
		validate(profilePageLink);
		
	}
	
public BenefitsAndCoveragePage navigateDirectToBnCPag() {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,50)", "");
		scrollToView(benefitsPageLink);
		jsClick(benefitsPageLink);

		 CommonUtility.checkPageIsReady(driver);
		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equalsIgnoreCase("Benefits Overview")) {
			return new BenefitsAndCoveragePage(driver);
		}
		return null;
	}

public ClaimSummarypage navigateToClaimsSummaryPage() {
		CommonUtility.checkPageIsReady(driver);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		validate(claimsPageLink);
		claimsPageLink.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new ClaimSummarypage(driver);	
		}
		return null;
	}

public ContactUsPage navigateToContactUsPage() {
		validate(contactUsPageLink);
		contactUsPageLink.click();
		CommonUtility.waitForPageLoad(driver, heading, 10);
		if(driver.getTitle().equalsIgnoreCase("Overview"))
		{
			return new ContactUsPage(driver);
		}
		return null;
	}

public DrugCostEstimatorPage navigateToDCEPage() throws InterruptedException {
		validate(dcePageLink);
		dcePageLink.click();
		CommonUtility.checkPageIsReady(driver);
	    //Thread.sleep(10000);
		if (driver.getTitle().contains("Overview")) {
			return new DrugCostEstimatorPage(driver);
		}
		return null;
	}

public EOBPage navigateToEOBPage() {
	validate(eobPageLink);
	eobPageLink.click();
	CommonUtility.checkPageIsReady(driver);
	if (!(driver.getTitle().equalsIgnoreCase("EOB Search"))) {
	Assert.fail("EOB page not getting displayed");	
	return null;
	}
	else{
		CommonUtility.waitForPageLoad(driver, heading, 10);
		return new EOBPage(driver);
	}
}

public HealthAndWellness clickHealthnWellnessTab(){
		validate(healthWellness);
		healthWellness.click();
			CommonUtility.checkPageIsReady(driver);
			/*try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			if (driver.getTitle().contains("Health")) {
				return new HealthAndWellness(driver);
			}
			return null;

	}

public OrderplanmaterialsPage navigateToOrderPlanMaterialsPage() {
	//driver.navigate().to("https://"+MRScenario.environment+"-medicare.uhc.com/content/medicare/member/order-materials/overview.html");
	/*validate(BnClink);
	BnClink.click();*/
	validate(orderPlanPageLink);
	orderPlanPageLink.click();
	//CommonUtility.checkPageIsReady(driver);
	CommonUtility.waitForPageLoad(driver, orderplanHeadertxt, 30);
	if (orderplanHeadertxt.isDisplayed()) {
		return new OrderplanmaterialsPage(driver);
	}
	return null;
}

public PharmacySearchPage navigateToPharmacyLocator() throws InterruptedException {
				
				CommonUtility.checkPageIsReady(driver);
				validate(pharmacyPageLink);
				pharmacyPageLink.click();
				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				CommonUtility.checkPageIsReady(driver);

				System.out.println(driver.getTitle());
				
				if (driver.getTitle().contains("Pharmacy")) {
					return new PharmacySearchPage(driver);
				}
				return null;
	}

public pages.member.bluelayer.ProfilePreferencesPage navigateDirectToProfilePage() {
		System.out.println(driver.getTitle());
		validate(profilePageLink);
		profilePageLink.click();
		CommonUtility.checkPageIsReady(driver);
		/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Profile")) {
			 System.out.println("Pass!");
			return new ProfilePreferencesPage(driver);
		}
		/*JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)", "");*/
		/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return null;
	}

}
