package pages.member.ulayer;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.dashboard.member.ulayer.RallyDashboardPage;
import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.member.bluelayer.ConfirmOneTimePaymentPage;

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
	
	@FindBy(xpath="//div[@class='menuL1']//li/a[text()='HOME']")
	private WebElement panelHome;
	
	@FindBy(xpath="//div[@class='menuL1']//li/a[text()='Claims']")
	private WebElement panelClaims;
	
	@FindBy(xpath="//div[@class='menuL1']//li/a[text()='Find Care & Costs']")
	private WebElement panelFindCareCost;
	
	@FindBy(xpath="//div[@class='menuL1']//li/a[text()='Premium Payments']")
	private WebElement panelPremiumPayment;
	
	
	public TestHarness(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(panelHome);	
		validate(panelClaims);	
		validate(claimsPageLink);
	}	
	
	public PaymentsOverview navigateToPaymentOverview()
	{
		System.out.println("Inside navigateToPaymentOverview functions");
		if(PaymentPageLik.isEnabled()){
			PaymentPageLik.click();
			System.out.println("Go tp Payment link clicked");
			//Implementing direct navigation as PaymentLink in test harness is not getting clicked via selenium
			//driver.get("https://team-h-medicare.uhc.com/content/medicare/member/payments/overview.html");
			return new PaymentsOverview(driver);
		}
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
		if(!(("Ship").equalsIgnoreCase(Category))){
		validate(panelFindCareCost);
		}
		if(!(("GroupRetireeMapd").equalsIgnoreCase(Category))){
		validate(panelPremiumPayment);
		}
		validate(formsPageLink);
		validate(claimsPageLink);
		validate(benefitsPageLink);
		validate(profilePageLink);
		
	}
	
public BenefitsAndCoveragePage navigateDirectToBnCPag() {
		
		scrollToView(benefitsPageLink);
		benefitsPageLink.click();

		 CommonUtility.checkPageIsReady(driver);
		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equalsIgnoreCase("Benefits Overview")) {
			return new BenefitsAndCoveragePage(driver);
		}
		return null;
	}
}
