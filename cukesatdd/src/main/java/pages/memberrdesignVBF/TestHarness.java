package pages.memberrdesignVBF;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.memberrdesignVBF.HealthAndWellness;

public class TestHarness extends UhcDriver {

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Payment')]")
	private WebElement PaymentPageLik;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Claim')]")
	private WebElement claimsPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Forms and Resource')]")
	private WebElement formsPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'benefits')]")
	private WebElement benefitsPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'profile')]")
	private WebElement profilePageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'preferences')]")
	private WebElement preferencesPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'EOB Search')]")
	private WebElement eobPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Payments')]")
	private WebElement paymentPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Order Plan material')]")
	private WebElement orderPlanPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Pharmacy')]")
	private WebElement pharmacyPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'DCE')]")
	private WebElement dcePageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Contact Us')]")
	private WebElement contactUsPageLink;

	@FindBy(xpath = "//a[contains(.,'Go to Payments page')]")
	private WebElement TeamHPaymentPage;

	@FindBy(linkText = "Go to payment link page")
	private WebElement TeamCPaymentPage;

	@FindBy(id = "home_2")
	private WebElement panelHome;

	@FindBy(id = "claims_1")
	private WebElement panelClaims;

	@FindBy(id = "findcarecost2")
	private WebElement panelFindCareCost;

	@FindBy(id = "premiumpayment_3")
	private WebElement panelPremiumPayment;

	@FindBy(id = "healthwellness_3")
	private WebElement healthWellness;

	@FindBy(xpath = "//header//h1")
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
		validateNew(heading);
		validateNew(orderPlanPageLink);
		validateNew(claimsPageLink);
	}
/***
 * 
 * @return
 * @throws InterruptedException
 */
	public PaymentsOverview navigateToPaymentOverview() throws InterruptedException {
		System.out.println("Inside navigateToPaymentOverview functions");
		/*
		 * waitforElement(panelFindCareCost, 60); if(panelClaims.isEnabled()){
		 * panelClaims.click();
		 */
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// waitforElement(panelPremiumPayment, 60);
		validateNew(PaymentPageLik);
		PaymentPageLik.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Overview")) {
			return new PaymentsOverview(driver);
		}
		// }
		return null;
	}

	public PaymentsOverview navigateToTeamHPaymentOverview() throws InterruptedException {
		System.out.println("Inside navigateToTeamHPaymentOverview functions");
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(15000);
		if (TeamHPaymentPage.isEnabled()) {
			TeamHPaymentPage.click();
			System.out.println("Go to Payment link clicked");
			// Implementing direct navigation as PaymentLink in test harness is
			// not getting clicked via selenium
			driver.get("https://team-h-medicare.uhc.com/content/medicare/member/payments/overview.html");
			return new PaymentsOverview(driver);
		}
		return null;
	}

	public PaymentsOverview navigateToTeamCPaymentOverview() {
		if (TeamCPaymentPage.isEnabled()) {
			TeamCPaymentPage.click();
			return new PaymentsOverview(driver);
		}
		return null;
	}
/***
 * 
 * @param Category
 */
	public void validateTestHarnessElements(String Category) {
		RallyDashboardPage.checkModelPopup(driver);
		CommonUtility.checkPageIsReadyNew(driver);
		if (!(("GroupRetireeMapd").equalsIgnoreCase(Category))) {
			validateNew(PaymentPageLik);
		}
		validateNew(formsPageLink);
		validateNew(claimsPageLink);
		validateNew(benefitsPageLink);
		validateNew(profilePageLink);

	}
/***
 * 
 * @return
 */
	public BenefitsAndCoveragePage navigateDirectToBnCPag() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,50)", "");
		scrollToView(benefitsPageLink);
		jsClickNew(benefitsPageLink);

		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Benefits Overview")) {
			return new BenefitsAndCoveragePage(driver);
		}
		return null;
	}
/***
 * 
 * @return
 */
	public ClaimSummarypage navigateToClaimsSummaryPage() {
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(claimsPageLink);
		claimsPageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new ClaimSummarypage(driver);
		}
		return null;
	}
/***
 * 
 * @return
 */
	public ContactUsPage navigateToContactUsPage() {
		validateNew(contactUsPageLink);
		contactUsPageLink.click();
		CommonUtility.waitForPageLoadNew(driver, heading, 10);
		if (driver.getTitle().equalsIgnoreCase("Overview")) {
			return new ContactUsPage(driver);
		}
		return null;
	}
/***
 * 
 * @return
 * @throws InterruptedException
 */
	public DrugCostEstimatorPage navigateToDCEPage() throws InterruptedException {
		validateNew(dcePageLink);
		dcePageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Overview")) {
			return new DrugCostEstimatorPage(driver);
		}
		return null;
	}
/***
 * 
 * @return
 */
	public EOBPage navigateToEOBPage() {
		validateNew(eobPageLink);
		eobPageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (!(driver.getTitle().equalsIgnoreCase("EOB Search"))) {
			Assert.fail("EOB page not getting displayed");
			return null;
		} else {
			CommonUtility.waitForPageLoadNew(driver, heading, 10);
			return new EOBPage(driver);
		}
	}
/***
 * 
 * @return
 * @throws InterruptedException 
 */
	public HealthAndWellness clickHealthnWellnessTab() throws InterruptedException {
		/*validateNew(healthWellness);
		healthWellness.click();*/
		startNew(MRConstants.HEALTH_AND_WELLNESS_TESTHARNESS);
		int counter = 0;

		do {
			if (counter <= 10) {
				Thread.sleep(5000);
				System.out.println("Time elapsed post sign In clicked --" + counter + "*5 sec.");
			} else {
				System.out.println("TimeOut!!!");
				return null;
			}
			counter++;

			if (driver.getTitle().contains("Health")) {
				return new HealthAndWellness(driver);
			}
			
		} while (!(driver.getTitle().contains("Find Care")));
		//CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Health")) {
			return new HealthAndWellness(driver);
		}
		return null;

	}
/***
 * 
 * @return
 */
	public OrderplanmaterialsPage navigateToOrderPlanMaterialsPage() {
		validateNew(orderPlanPageLink);
		orderPlanPageLink.click();
		CommonUtility.waitForPageLoadNew(driver, orderplanHeadertxt, 30);
		if (orderplanHeadertxt.isDisplayed()) {
			return new OrderplanmaterialsPage(driver);
		}
		return null;
	}
/***
 * 
 * @return
 * @throws InterruptedException
 */
	public PharmacySearchPage navigateToPharmacyLocator() throws InterruptedException {

		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(pharmacyPageLink);
		pharmacyPageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("Pharmacy")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}
/***
 * 
 * @return
 */
	public pages.memberrdesignVBF.ProfilePreferencesPage navigateDirectToProfilePage() {
		System.out.println(driver.getTitle());
		validateNew(profilePageLink);
		profilePageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getTitle());

		if ("Profile".equalsIgnoreCase(driver.getTitle())) {
			System.out.println("Pass!");
			return new ProfilePreferencesPage(driver);
		}
		return null;
	}

public ProviderSearchPage navigateToProviderSearch() throws InterruptedException {
	/*validateNew(panelFindCareCost);
	panelFindCareCost.click();*/
	startNew(MRConstants.PROVIDER_TESTHARNESS);
	int counter = 0;

	do {
		if (counter <= 10) {
			Thread.sleep(5000);
			System.out.println("Time elapsed post sign In clicked --" + counter + "*5 sec.");
		} else {
			System.out.println("TimeOut!!!");
			return null;
		}
		counter++;

		if (driver.getTitle().contains("Find Care")) {
			return new ProviderSearchPage(driver);
		}
		
	} while (!(driver.getTitle().contains("Find Care")));
	return null;
}

}
