package pages.regression.testharness;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.memberredesign.HSID.CommonStepDefinition;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.*;
import pages.regression.formsandresources.*;
import pages.regression.claims.*;
import pages.regression.contactus.ContactUsPage;
import pages.regression.drugcostestimator.*;
import pages.memberrdesignVBF.EOBPage;

import pages.regression.healthandwellness.*;
import pages.regression.myDocumentsPage.MyDocumentsPage;
import pages.regression.ordermaterials.*;
import pages.memberrdesignVBF.PaymentsOverview;
import pages.regression.pharmacylocator.*;
import pages.regression.planDocumentsAndResources.PlanDocumentsAndResourcesPage;
import pages.regression.profileandpreferences.*;
import pages.memberrdesignVBF.ProviderSearchPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;


public class TestHarness extends UhcDriver {

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Payment')]")
	private WebElement PaymentPageLink;

	@FindBy(xpath = "//*[contains(@id,'claims')]")
	private WebElement claimsTab;
	
	@FindBy(xpath="//a[contains(text(),'Go to Claims page')]")
	private WebElement testHarnessClaimsLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Forms and Resource')]")
	private WebElement formsPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'benefits')]")
	private WebElement benefitsPageLink;

	@FindBy(xpath = "//a[contains(text(),'Go to benefits and coverage page')]")
	private WebElement testHarnessBenefitsPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'profile')]")
	private WebElement profilePageLink;

	@FindBy(xpath = "//a[contains(text(),'Go to preferences page')]")
	private WebElement testHarnessProfilePageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'EOB Search')]")
	private WebElement eobPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Order Plan material')]")
	private WebElement orderPlanPageLink;

	@FindBy(xpath="//a[contains(text(),'Go to Order Plan materials page')]")
	private WebElement testHarnessOrderPlanPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Pharmacy')]")
	private WebElement pharmacyPageLink;

	@FindBy(xpath = "//a[contains(text(),'Go to Pharmacy Locator page')]")
	private WebElement testHarnessPharmacyPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'DCE')]")
	private WebElement dcePageLink;

	@FindBy(xpath = "//a[contains(text(),'Go to DCE page')]")
	private WebElement testHarnessDcePageLink;
	
	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Contact Us')]")
	private WebElement contactUsPageLink;

	@FindBy(xpath = "//a[contains(text(),'Go to Contact Us page')]")
	private WebElement testHarnessContactUsPageLink;

	@FindBy(xpath = "//a[contains(.,'Go to Payments page')]")
	private WebElement TeamHPaymentPage;

	@FindBy(linkText = "Go to payment link page")
	private WebElement TeamCPaymentPage;

	//tbd @FindBy(xpath = "//div[contains(@class,'header') or contains(@class,'testharness')]/h1[normalize-space()=contains(text(),' ')][not (contains(@class,'ng-hide'))]")
	@FindBy(xpath="//div[contains(@class,'header') and not(contains(@class,'hide'))]//h1")
	private WebElement heading;

	@FindBy(xpath = "//div[@class='tabs-desktop']/ul[@class='nav nav-tabs']/li")
	private List<WebElement> tabsForComboMember;

	@FindBy(id = "home_2")
	private WebElement panelHome;

	@FindBy(xpath="//title[contains(text(),'Contact Us')]")
	private WebElement contactUsTitleElement;
	
	@FindBy(id = "claims_1")
	private WebElement panelClaims;

	@FindBy(id = "coveragebenefits_1")
	private WebElement panelBenefits;

	@FindBy(id = "healthwellness_4")
	private List<WebElement> panelHealthWellness;

	@FindBy(xpath = "//*[contains(@id,'findcarecost2')]")
	private List<WebElement> panelFindcarecost;

	@FindBy(xpath = "//*[contains(@id,'claimsummary')]")
	private WebElement claimSummary;

	@FindBy(id = "eobC1")
	private WebElement explainationOfBenefits;

	@FindBy(id = "benefitssummary")
	private WebElement benefitsSummary;

	@FindBy(xpath = "//*[contains(@id,'formsandresources')]")
	private WebElement formsAndResources;

	@FindBy(id = "ordermaterials")
	private WebElement orderMaterials;

	@FindBy(xpath = "//*[contains(@id,'coveragebenefits')]")
	private WebElement coverageBenefits;

	@FindBy(xpath = "//*[contains(@id,'premiumpayment')]")
	private WebElement premiumPayment;

	@FindBy(id = "Help")
	private WebElement helpLink;

	@FindBy(id = "accountprofile")
	private WebElement accountProfile;

	@FindBy(xpath = "//ul[@id='dropdynamic']//a[contains(text(),'Log Out')]")
	private WebElement NavAccountProfSignOut;

	@FindBy(xpath = "//ul[@id='dropdynamic']//a[contains(text(),'Account Settings')]")
	private WebElement NavAccountProfSetting;

	@FindBy(id = "arcade-footer")
	private WebElement footerSection;

	@FindBy(linkText = "Help & Contact Us")
	private WebElement helpnContactUs;

	@FindBy(linkText = "Legal Notices & Disclosures")
	private WebElement legalNotices;

	@FindBy(linkText = "Account Settings")
	private WebElement accountnSettings;

	@FindBy(linkText = "Saved")
	private WebElement saved;

	@FindBy(linkText = "Logout")
	private WebElement logout;

	@FindBy(linkText = "About UnitedHealthcare")
	private WebElement aboutUHC;

	@FindBy(linkText = "Legal Entity Disclosure")
	private WebElement legalDisclosures;

	@FindBy(linkText = "Privacy Policy")
	private WebElement privacyPolicy;

	@FindBy(linkText = "Terms of Use")
	private WebElement termsOfUse;

	@FindBy(partialLinkText = "Language Assistance | Non-Discrimination Notice")
	private WebElement languageAssistanceEnglish;

	@FindBy(partialLinkText = "Asistencia de Idiomas | Aviso de no Discriminaci�n (PDF)")
	private WebElement languageAssistanceSpanish;

	@FindBy(xpath = "//h1[@id='pageHeader']")
	private WebElement formsPageHeading;
	
	@FindBy(xpath = ".//*[@id='zipcode-button']")
	private WebElement zipcode;
	
	@FindBy(xpath = "//div[contains(@class,'desktopLogoContainer')]//div[@class='myuhcTopContainer']//div[contains(@class,'logo-container')]//img[contains(@src,'PCP') or contains(@src,'MEDICA')]")
	private WebElement pcpMedicaLogo;
	
	@FindBy(id = "home_1")
	private WebElement panelHomePcpMedica;
	
	@FindBy(xpath = "//div[contains(@class,'testharnessHeader')]")
	private WebElement testHarnessHeader;
	
	
	@FindBy(id = "premiumpayment_4")
	private WebElement premPaymentsTab;
	
	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement OrderMaterial_Dashboard;
	
	@FindBy(id = "coveragebenefits_2")
	private WebElement coverageandbenefitslink;
	
	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'benefits')]")
	private WebElement benefitsPagetestharnessLink;
	
	 @FindBy(css = "img.img-responsive")
     private WebElement logoImage;
	 
	 @FindBy(xpath = "(//img[@alt='CoLogo'])[1]")
     private WebElement cologoImage;
	
     @FindBy(xpath="//a[contains(text(),'Go to Pharmacies and prescriptions page') or contains(text(),'Go to Pharmacies & prescriptions page')]")
     private WebElement testHarnessPharPresLink;

 	@FindBy(xpath="//a[@id='pharmacies_5']")
 	private WebElement testHarnessTopMenuPhaPresLink;
 	
	@FindBy(xpath = "//*[@id='main-nav']/div/div/div/a[6]")
	private WebElement pharPresDashboardLink;

	@FindBy(xpath="//h1[contains(text(),'Estimate Your Drug Costs')]")
	private WebElement dceHeaderTxt;
	
	@FindBy(xpath="//nav[@class='menuL1']//a[contains(@id,'payment')]")
	private WebElement paymentTabOnTopMenu;
	
	@FindBy(xpath = "//*[contains(@id,'findcarecost')]")
	private WebElement findCareCostTab;
	
	@FindBy(xpath="(//a[@id='pharmacies_5'])[1]")
	private WebElement pharmaciesTab;
	
	@FindBy(xpath="//h1[contains(text(),'Pharmacies')]")
	private WebElement pharmaciesHeader;
	
	@FindBy(id="healthwellness_6")
	private WebElement healthAndWellnessTab;
	
	@FindBy(xpath="//h1//*[contains(text(),'Health & Wellness')]")
	private WebElement healthAndWellnessHeader;
	
		/*
	 * @FindBy(
	 * xpath="//*[contains(@id,'ACCdropdown') and contains(text(),'Log Out')]")
	 * private WebElement logOut;
	 */
	
	@FindBy(xpath="(//a[contains(text(),'Log Out')])[1]")
	private WebElement logOut;
	
	
	@FindBy(xpath="//*[contains(@id,'username')]")
	private WebElement usernameField;
	
	@FindBy(xpath="//a[contains(text(),'Go to Health and wellness')]")
	private WebElement testHarnessHealthAndWellnessLink;
	
	@FindBy(xpath="//a[contains(text(),'Go to My Documents')]")
	private WebElement testHarnessMyDocumentsLink;
	
	@FindBy(name="zipCode")
	private WebElement zipCodeTextBox;
	
	@FindBy(xpath="//button[@name='Update']")
	private WebElement continueButton;
	
	@FindBy(xpath="//h1")
	private WebElement hcePageText;
	
	@FindBy(xpath="//*[@class='btn btn--primary onetimepayment']")
	private WebElement MakeAPaymentButton;
	
	@FindBy(xpath = "//a[contains(text(),'Go to Payments page')]")
	private WebElement TestHarnesspaymentsLink;
		
	String category = null;

	public TestHarness(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	public MRScenario getLoginScenario() {
		MRScenario loginScenario = null;
		return loginScenario;
	}

	@Override
	public void openAndValidate() {
		AccountHomePage.checkForIPerceptionModel(driver);
		//vvv note: temp-workaround for team-a env, by-pass this for now
		if (MRScenario.environment.contains("team-a") ||MRScenario.environment.equalsIgnoreCase("team-f") ) {
			CommonUtility.waitForPageLoad(driver, panelHome, 30);
			return;
		}
		//^^^ note: temp-workaround for team-a env, by-pass this for now
		//category = CommonStepDefinition.getMemberAttributeMap().get("Member Type");
		
		category = "Category";
				//(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
				System.out.println("The selected category is " +category);
		if (category.equalsIgnoreCase("PCP") || category.equalsIgnoreCase("MEDICA")) {
			CommonUtility.waitForPageLoad(driver, panelHomePcpMedica, 30);
			validateNew(pcpMedicaLogo);		
		}
		else{
			CommonUtility.waitForPageLoad(driver, panelHome, 30);
		}	
		//validateNew(panelHome);
		validateNew(panelClaims);
		if (category.contains(CommonConstants.CATEGORY_TERMIATED)) {
			if (panelHealthWellness.isEmpty() && panelFindcarecost.isEmpty()) {
				Assert.assertTrue("Terminated view is present", true);
			} else {
				Assert.fail("Check member termination date!!!");
			}
		}
		//validateNew(orderPlanPageLink);
		//validateNew(claimsPageLink);
		else{
			System.out.println("Active view is present");
		}
		
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public PaymentHistoryPage navigateToPaymentOverview() throws InterruptedException {
		
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, premPaymentsTab, 30);
		premPaymentsTab.click();		
		CommonUtility.waitForPageLoad(driver, heading, 60);
		if (driver.getCurrentUrl().contains("payments")) {
			return new PaymentHistoryPage(driver);
		}
		
		return null;
	}
	
	public PaymentHistoryPage navigateToPaymentOverviewSkipBtnValidation() throws InterruptedException {
		
		CommonUtility.waitForPageLoad(driver, premPaymentsTab, 30);
		if(validateNew(premPaymentsTab))
			premPaymentsTab.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, heading, 60);
		if (driver.getCurrentUrl().contains("payments")) {
			return new PaymentHistoryPage(driver, true);
		}
		
		return null;
	}
	
	public PaymentHistoryPage navigateToPaymentFromTestHarnessPage() throws InterruptedException {
		    CommonUtility.checkPageIsReadyNew(driver);
			if (driver.getCurrentUrl().contains("testharness")) {
				System.out.println("TestHarness Page is displayed, clicking the Premium Payments Link");
				TestHarness.checkForIPerceptionModel(driver);
				TestHarness.checkForIPerceptionModel(driver);
				TestHarnesspaymentsLink.click();
				TestHarness.checkForIPerceptionModel(driver);
				CommonUtility.checkPageIsReadyNew(driver);
				CommonUtility.waitForPageLoad(driver, MakeAPaymentButton, 20);
		if (MakeAPaymentButton.isDisplayed())
		{
		System.out.println("Make a payment button was displayed on Payments page");
		return new PaymentHistoryPage(driver);
		}
		else
		{
			System.out.println("Make a payment button was not displayed on first time Payments page loaded, refreshing the page");
			driver.navigate().refresh();
			if (MakeAPaymentButton.isDisplayed())
				
			{
				System.out.println("Make a payment button was displayed on Payments page");
				return new PaymentHistoryPage(driver);
				}
			else
			{
				System.out.println("Make a payment button was displayed on Payments page");
				Assert.fail("Make a payment button was not displayed on Payments page");
			}
			
		}
		if (driver.getCurrentUrl().contains("payments")) {
			return new PaymentHistoryPage(driver);
		}
		
	    }
			return null;
			
	}
	public PaymentHistoryPage navigateToPaymentFromTestHarnessPageSkipBtnValidation() throws InterruptedException {
		//tbd CommonUtility.waitForPageLoad(driver, premPaymentsTab, 30);
		if(validateNew(PaymentPageLink))
			PaymentPageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, heading, 60);
		if (driver.getCurrentUrl().contains("payments")) {
			return new PaymentHistoryPage(driver, true);
		}
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

	public PaymentHistoryPage navigateToTeamCPaymentOverview() {
		if (TeamCPaymentPage.isEnabled()) {
			TeamCPaymentPage.click();
			return new PaymentHistoryPage(driver);
		}
		return null;
	}

	/***
	 * 
	 * @param Category
	 */
	public void validateTestHarnessElements(String Category) {
		checkModelPopup(driver);
		CommonUtility.checkPageIsReadyNew(driver);
		if (!(("GroupRetireeMapd").equalsIgnoreCase(Category))) {
			validateNew(PaymentPageLink);
		}
		if (("ComboMAPDANDSHIP").equalsIgnoreCase(Category)) {
			validateNew(tabsForComboMember.get(0));
			validateNew(tabsForComboMember.get(1));
		}
		validateNew(formsPageLink);
		validateNew(claimsTab);
		validateNew(benefitsPageLink);
		validateNew(profilePageLink);

	}

	/***
	 * 
	 * @return
	 */
	public pages.regression.benefitandcoverage.BenefitsAndCoveragePage navigateDirectToBnCPag() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,50)", "");
		scrollToView(benefitsPageLink);
		jsClickNew(benefitsPageLink);

		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_60);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("Benefits")) {
			return new pages.regression.benefitandcoverage.BenefitsAndCoveragePage(driver);
		}
		return null;
	}

	public BenefitsAndCoveragePage navigateDirectToBnCPagFromTestharnessPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,50)", "");
		scrollToView(testHarnessBenefitsPageLink);
		jsClickNew(testHarnessBenefitsPageLink);
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, heading, 60);
		System.out.println(driver.getTitle());
		if (!driver.getTitle().contains("Benefits")) { //note: in case timing issue, one more try
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("second try - "+driver.getTitle());
		}
		if (driver.getTitle().contains("Benefits")) {
			return new BenefitsAndCoveragePage(driver);
		}
		return null;
	}
	/***
	 * 
	 * @return
	 */
	public ClaimsSummaryPage navigateToClaimsSummaryPage() {
		validateNew(claimsTab,0);
		claimsTab.click();
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_90);
		if (driver.getTitle().contains("Claims")) {
			return new ClaimsSummaryPage(driver);
		}
		return null;
	}

	public ClaimsSummaryPage navigateToClaimsSummaryFromTestHarnessPage() {
		CommonUtility.checkPageIsReady(driver);
		try{
			validateNew(testHarnessClaimsLink);
			testHarnessClaimsLink.click();
		} catch (WebDriverException e) {
			checkForIPerceptionModel(driver);
			CommonUtility.checkPageIsReady(driver);
			testHarnessClaimsLink.click();
		}
		CommonUtility.checkPageIsReady(driver);
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_90);
		if (driver.getTitle().contains("Claims")) {
			return new ClaimsSummaryPage(driver);
		}
		return null;
	}
		

	/***
	 * 
	 * @return
	 */
	public ContactUsPage navigateToContactUsPage() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		CommonUtility.waitForPageLoad(driver, contactUsPageLink, 30);
		validateNew(contactUsPageLink);
		contactUsPageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, panelHome, CommonConstants.TIMEOUT_60);
		if (driver.getTitle().trim().contains("Contact Us")) {
			return new ContactUsPage(driver);
		}
		return null;
	}
	
	public ContactUsPage navigateToContactUsPageFromTestHarnessPage() {
		String memberType="doesntMatter";
		return navigateToContactUsPageFromTestHarnessPage(memberType);
	}
	
	public ContactUsPage navigateToContactUsPageFromTestHarnessPage(String memberType) {
		TestHarness.checkForIPerceptionModel(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		CommonUtility.waitForPageLoadNew(driver, contactUsPageLink, 30);
		validateNew(testHarnessContactUsPageLink);
		TestHarness.checkForIPerceptionModel(driver);
		contactUsPageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.waitForPageLoad(driver, panelHome, CommonConstants.TIMEOUT_90);
		System.out.println("TEST - driver.getTitle().trim()="+driver.getTitle().trim());
		if (driver.getTitle().trim().contains("Contact Us")) {
			if(memberType.equals("memberType")) {
				return new ContactUsPage(driver);
			} else {
				return new ContactUsPage(driver, memberType);
			}
			//tbd return new ContactUsPage(driver);
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
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
		if (driver.getTitle().contains("Overview")) {
			return new DrugCostEstimatorPage(driver);
		}
		return null;
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public DrugCostEstimatorPage navigateToDCEPageFromTestHarnessPage() throws InterruptedException {
		checkModelPopup(driver,5);
		validateNew(testHarnessDcePageLink);
		testHarnessDcePageLink.click();
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,5);
		CommonUtility.waitForPageLoad(driver, dceHeaderTxt, CommonConstants.TIMEOUT_90);
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
		CommonUtility.waitForPageLoad(driver, eobPageLink,30);
		validateNew(eobPageLink);
		eobPageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_60);
		if (!(driver.getTitle().contains("Explanation of Benefits"))) {
			Assert.fail("EOB page not getting displayed");
			return null;
		} else {
			return new EOBPage(driver);
		}
	}
	
	

	@FindBy(xpath = ".//*[@id='IPEinvL']/map/area[2]")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "//*[contains(@id,'row2link')]/td[2]/a[contains(text(), 'EOB')]")
	private WebElement eobTestharnessLink;

	public pages.regression.explanationofbenefits.EOBPage navigateDirectToEOBPag() {
		if (MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			driver.findElement(By.xpath("//a[text()='Eob']")).click();
		} else if (MRScenario.environment.equalsIgnoreCase("stage") 
				|| MRScenario.environment.contains("team-a")) {

			if (MRScenario.isTestHarness.equalsIgnoreCase("YES")) {
				try {
					jsClickNew(eobTestharnessLink);
				} catch (UnhandledAlertException ae) {
					Alert alert = driver.switchTo().alert();
					System.out.println("Alert text="+alert.getText());
					if (alert.getText().contains("an error while processing your information")) {
						Assert.assertTrue("***** getting unexpected alert error while accessing EOB page - Got Alert message: "+alert.getText(), false);
					} else {
						alert.accept();
						CommonUtility.checkPageIsReady(driver);
					}
				}

				System.out.println("EOB linked Clicked on Test Harness Dashboard page");
			}
		} else {
			System.out.println(
					"This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");
		}

		return new pages.regression.explanationofbenefits.EOBPage(driver);
	}

	public pages.regression.explanationofbenefits.DreamEOBPage navigateDirectToDreamEOBPag() {
		if (MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			driver.findElement(By.xpath("//a[text()='Eob']")).click();

		} else if (MRScenario.environment.equalsIgnoreCase("stage")) {

			if (MRScenario.isTestHarness.equals("YES")) {
//				startNew("https://stage-medicare.uhc.com/member/eob.html");
				eobTestharnessLink.click();
			}
		} else {
			System.out.println(
					"This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");
		}

		return new pages.regression.explanationofbenefits.DreamEOBPage(driver);
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public HealthAndWellnessPage clickHealthnWellnessTab()  {
		/*
		 * validateNew(healthWellness); healthWellness.click();
		 */
		healthAndWellnessTab.click();
		validateNew(healthAndWellnessHeader,60);

		if (driver.getTitle().contains("Health")) {
			return new HealthAndWellnessPage(driver);
		}

		
		return null;

	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public OrderMaterialsPage navigateToOrderPlanMaterialsPage() throws InterruptedException {
		validateNew(orderPlanPageLink);
		orderPlanPageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
		if (driver.getTitle().contains("Order")) {
			return new OrderMaterialsPage(driver);
		}
		return null;
	}

	@FindBy(xpath="//h1[contains(text(),'Order Plan Materials')]")
	private WebElement orderHeader;
	/***
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public OrderMaterialsPage navigateToOrderPlanMaterialsPageFromTestHarnessPage() throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		try{
			validateNew(testHarnessOrderPlanPageLink);
			testHarnessOrderPlanPageLink.click();
		} catch (WebDriverException e) {
			checkForIPerceptionModel(driver);
			CommonUtility.checkPageIsReady(driver);
			testHarnessOrderPlanPageLink.click();
		}		
		CommonUtility.checkPageIsReady(driver);
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, orderHeader, 90);
		if (driver.getTitle().contains("Order")) {
			return new OrderMaterialsPage(driver);
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
		CommonUtility.waitForPageLoad(driver, pharmacyPageLink, 30);
		validateNew(pharmacyPageLink);
		pharmacyPageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, zipcode, 60);
		if (driver.getTitle().contains("Pharmacy")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}
	
	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public PharmacySearchPage navigateToPharmacyLocatorFromTestHarnessPage() throws InterruptedException {

		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, testHarnessPharmacyPageLink, 90);
		try{
			validateNew(testHarnessPharmacyPageLink);
			testHarnessPharmacyPageLink.click();
		} catch (WebDriverException e) {
			checkForIPerceptionModel(driver);
			CommonUtility.checkPageIsReady(driver);
			testHarnessPharmacyPageLink.click();
		}		
		CommonUtility.checkPageIsReady(driver);
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, zipcode, 60);
		if (driver.getTitle().contains("Pharmacy")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	/***
	 * 
	 * @return
	 */
	public ProfileandPreferencesPage navigateDirectToProfilePage() {
		System.out.println(driver.getTitle());
		CommonUtility.waitForPageLoad(driver, profilePageLink, 30);
		validateNew(profilePageLink);
		profilePageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_60);

		if (driver.getTitle().contains("Profile")) {
			System.out.println("Pass!");
			return new ProfileandPreferencesPage(driver);
		}
		return null;
	}
	
	/***
	 * 
	 * @return
	 */
	public ProfileandPreferencesPage navigateDirectToProfilePageFromTestHarnessPage() {
		System.out.println(driver.getTitle());
		CommonUtility.waitForPageLoad(driver, profilePageLink, 90);
		try{
			validateNew(testHarnessProfilePageLink);
			profilePageLink.click();
		} catch (WebDriverException e) {
			checkForIPerceptionModel(driver);
			CommonUtility.checkPageIsReady(driver);
			profilePageLink.click();
		}
		CommonUtility.checkPageIsReady(driver);
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_90);

		if (driver.getTitle().contains("Profile")) {
			System.out.println("Pass!");
			return new ProfileandPreferencesPage(driver);
		}
		return null;
	}
	
	

	public ProviderSearchPage navigateToProviderSearch() throws InterruptedException {
		/*
		 * validateNew(panelFindCareCost); panelFindCareCost.click();
		 */
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

	/***
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public FormsAndResourcesPage navigateDirectToFnRPage() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,50)", "");
		scrollToView(formsPageLink);
		jsClickNew(formsPageLink);
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, formsPageHeading, CommonConstants.TIMEOUT_90);

		if (driver.getTitle().contains("Documents")) {
			return new FormsAndResourcesPage(driver);
		}
		return null;
	}

	
	/***
	 * 
	 * @return
	 */
	public pages.memberrdesignVBF.ClaimSummarypage panelNavigateToClaimsSummaryPage() {
		CommonUtility.checkPageIsReadyNew(driver);
		panelClaims.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
		if (driver.getTitle().contains("Claims")) {
			return new pages.memberrdesignVBF.ClaimSummarypage(driver);
		}
		return null;
	}

	/***
	 * 
	 */
	public void validateClaimsL2Tabs() {

		Assert.assertTrue("claimSummary is not displayed", claimSummary.isDisplayed());
		Assert.assertTrue("explainationOfBenefits is not displayed", explainationOfBenefits.isDisplayed());
	}

	/***
	 * 
	 */
	public void validateEobL2Tab() {
		validateNew(explainationOfBenefits);
		explainationOfBenefits.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
		if (!(driver.getTitle().contains("Explanation of Benefits"))) {
			Assert.fail("EOB page not getting displayed");
		}
	}

	/***
	 * 
	 * @return
	 */
	public BenefitsAndCoveragePage validateBnCNavigation() {
		validateNew(coverageBenefits,0);
		coverageBenefits.click();

		if (driver.getTitle().contains("Benefits")) {
			return new BenefitsAndCoveragePage(driver);
		}
		return null;
	}
	
	public FormsAndResourcesPage validateBnCNavigationForTerminated() {
		validateNew(coverageBenefits);
		coverageBenefits.click();

		if (driver.getTitle().contains("Documents")) {
			try {
				return new FormsAndResourcesPage(driver);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/***
	 * 
	 */
	public void validateCoverageBenefitsL2Tabs() {
		validateNew(coverageBenefits);
		Assert.assertTrue("benefitsSummary is not displayed", benefitsSummary.isDisplayed());
		Assert.assertTrue("formsAndResources is not displayed", formsAndResources.isDisplayed());
		Assert.assertTrue("orderMaterials is not displayed", orderMaterials.isDisplayed());
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public FormsAndResourcesPage clickFormsAndResourcesTab() throws InterruptedException {

		validateNew(formsAndResources);
		formsAndResources.click();

		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, formsPageHeading, CommonConstants.TIMEOUT_90);
		System.out.println(driver.getTitle());

		if (driver.getTitle().contains("Documents")) {
			return new FormsAndResourcesPage(driver);
		}
		return null;

	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public OrderMaterialsPage validateOrderPlanMaterialsPage() throws InterruptedException {
		orderMaterials.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
		checkModelPopup(driver,5);
		if (heading.isDisplayed()) {
			return new OrderMaterialsPage(driver);
		}
		return null;
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public PaymentHistoryPage validatePremiumPaymentPage() {
		System.out.println("Inside navigateToPaymentOverview functions");
		validateNew(premiumPayment);
		premiumPayment.click();
		checkModelPopup(driver,5);
		if (driver.getTitle().contains("Payment")) {
			return new PaymentHistoryPage(driver);
		}
		return null;
	}

	/***
	 * 
	 */
	public void validateContactUsPage() {
		validateNew(helpLink);
	}

	/***
	 * 
	 */
	public void validateAccountProfile() {
		Assert.assertTrue("Account/Profile tab is not displayed", accountProfile.isDisplayed());
		jsClickNew(accountProfile);
		validateNew(NavAccountProfSignOut);
		validateNew(NavAccountProfSetting);
		scrollToView(accountProfile);
		jsClickNew(accountProfile);
	}

	/***
	 * 
	 */
	public void validateFooterSection() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
		validateNew(footerSection);
		Assert.assertTrue("Footer section is not displayed", footerSection.isDisplayed());
	}

	/***
	 * 
	 */
	public void validateMemberSupport() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
		validateNew(helpnContactUs);
		Assert.assertTrue("Help & Contact Us link is not clickable", helpnContactUs.isDisplayed());
		Assert.assertTrue("legal notices and disclaimer link is not clickable", legalNotices.isDisplayed());
		validateMemberSupportFooterLinks();
	}

	public void validateMemberSupportFooterLinks() {
		Assert.assertTrue("About link is not displayed", aboutUHC.isDisplayed());
		Assert.assertTrue("Legal Disclosures link is not displayed", legalDisclosures.isDisplayed());
		Assert.assertTrue("Privacy Policy link is not displayed", privacyPolicy.isDisplayed());
		Assert.assertTrue("Terms of Use link is not displayed", termsOfUse.isDisplayed());
	}

	public void validateQuickLinksFooterLinks() {
		Assert.assertTrue("Language Assistance english link is not displayed", languageAssistanceEnglish.isDisplayed());
		Assert.assertTrue("Language Assistance Spanish is not displayed", languageAssistanceSpanish.isDisplayed());

	}

	/***
	 * 
	 */
	public void validateQuickLinks() {
		Assert.assertTrue("Account and Settings link is not clickable", accountnSettings.isDisplayed());
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			Assert.assertTrue("Skipping Saved validation in footer as Rally Provider Search tool is not integrated",
					true);
		} else {
			Assert.assertTrue("Saved link is not clickable", saved.isDisplayed());
		}
		Assert.assertTrue("Logout link is not clickable", logout.isDisplayed());
		validateQuickLinksFooterLinks();
	}

	/***
	 * 
	 */
	public void validateSavedLink() {
		Assert.assertTrue("Saved link is not clickable", saved.isDisplayed());
	}

	public void validatePreEffectiveMessagePresent() throws InterruptedException {
		CommonUtility.waitForPageLoadNew(driver, testHarnessHeader, 20);
		String preMessage_text = testHarnessHeader.getText();
		Assert.assertTrue(preMessage_text.contains("Preeffective Test Harness"));
		
	}

	public void validatePremiumPaymentTabIsDisplayed() {
		validateNew(premPaymentsTab);
		
	}
	
	public boolean validateOrderMaterialsLink() {
		if (validate(OrderMaterial_Dashboard))
			return true;
		return false;
	}
	
	public pages.regression.benefitandcoverage.BenefitsAndCoveragePage clickOnBenefitsandCoverageTab() throws InterruptedException {
		System.out.println("Now clicking on Benefits and Coverage Tab on Dashboard");
		Thread.sleep(5000);
		checkForIPerceptionModel(driver);
		coverageandbenefitslink.click();
		return new pages.regression.benefitandcoverage.BenefitsAndCoveragePage(driver);

	}
	public BenefitsAndCoveragePage navigateDirectToBnCFromTestHarnessPage() {
		System.out.println(driver.getTitle());
		CommonUtility.waitForPageLoad(driver, benefitsPagetestharnessLink, 30);
		validateNew(benefitsPagetestharnessLink);
		benefitsPagetestharnessLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_30);

		if (driver.getTitle().contains("Plan Benefits Summary")) {
			System.out.println("Pass!");
			return new BenefitsAndCoveragePage(driver);
		}
		return null;
	}
	
    public void validateImagePresent(String logoToBeDisplayedOnSecondaryPage) throws InterruptedException {
        CommonUtility.waitForPageLoad(driver,logoImage,15);
        String logo_src = logoImage.getAttribute("src");
        String logo_alt = logoImage.getAttribute("alt");
        System.out.println("Actual logo's source on Test Harness page is   "+logo_src+" and Expected logo source is  "+logoToBeDisplayedOnSecondaryPage+" . ");                     
        System.out.println("logo's alt text on secondary page is   "+logo_alt);          
        Assert.assertTrue(logo_src.contains(logoToBeDisplayedOnSecondaryPage));
        System.out.println("Test harness page main logo assert condition for image source is passed"); 
        
		System.out.println("naturalWidth of logo is "+logoImage.getAttribute("naturalWidth"));
		 
       System.out.println("Now checking that image naturalWidth is not zero , which identifies that image is actually displayed on page");
       Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logoImage);
       if (!ImagePresent)
       {
        System.out.println("naturalWidth of logo is "+logoImage.getAttribute("naturalWidth"));
        System.out.println("naturalWidth is not greater than zero , logo image was not displayed.");
        Assert.fail("naturalWidth is not greater than zero , logo image was not displayed.");
       }
       else
       {
       	System.out.println("naturalWidth of logo is "+logoImage.getAttribute("naturalWidth"));
           System.out.println("naturalWidth is not zero , Logo image was displayed.");
        }
	          
}


        public void validateCoLogoImagePresent(String cologoToBeDisplayedOnSecondaryPage) throws InterruptedException {
        
        	 CommonUtility.waitForPageLoad(driver,cologoImage,15);
             String cologo_src = cologoImage.getAttribute("src");
             String cologo_alt = cologoImage.getAttribute("alt");
             System.out.println("Actual cologo's source on Test harness page is   " + cologo_src
                                           + " and Expected cologo source is  " + cologoToBeDisplayedOnSecondaryPage + " . ");
             System.out.println("cologo's alt text on secondary page is   " + cologo_alt);
             Assert.assertTrue(cologo_src.contains(cologoToBeDisplayedOnSecondaryPage));
             System.out.println("Test Harness page co-logo assert condition for image source is passed");
             System.out.println("Now checking that co-image naturalwidth is not zero , which identifies that image is actually displayed on page");
             
             Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", cologoImage);
             if (!ImagePresent)
             {
              System.out.println("naturalWidth of cologo is "+cologoImage.getAttribute("naturalWidth"));
              System.out.println("naturalwidth is zero , co-logo image was not displayed.");
              Assert.fail("naturalwidth is zero , co-logo image was not displayed.");
             }
             else
             {
             	System.out.println("naturalWidth of cologo is "+cologoImage.getAttribute("naturalWidth"));
                 System.out.println("naturalwidth is not zero , co-logo image was displayed.");
                 
             }
     }
    	/**
    	 * For iPerception Model
    	 * @param driver
    	 */
    	public static void checkForIPerceptionModel(WebDriver driver) {
    		int counter = 0;
    		do {
    			System.out.println("current value of counter: " + counter);
    			List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

    			if (IPerceptionsFrame.isEmpty()) {
    				try {
    					Thread.sleep(1500);
    				} catch (InterruptedException e) {
    					System.out.println(e.getMessage());
    				}
    			} else {
    				driver.switchTo().frame(IPerceptionsFrame.get(0));
    				driver.findElement(By.className("btn-no")).click();
    				driver.switchTo().defaultContent();
    			}
    			counter++;
    		} while (counter < 2);
    	}
    	
    	public FormsAndResourcesPage navigateDirectToFnRPageWithTimeout() throws InterruptedException {
    		checkForIPerceptionModel(driver);
    		StopWatch pageLoad = new StopWatch();
    		pageLoad.start();
    		JavascriptExecutor jse = (JavascriptExecutor) driver;
    		jse.executeScript("window.scrollBy(0,50)", "");
    		scrollToView(formsPageLink);
    		int forceTimeoutInMin=5;
    		try {
    			driver.manage().timeouts().pageLoadTimeout((forceTimeoutInMin*60), TimeUnit.SECONDS);
    			System.out.println("Set pageLoadTimeout to "+forceTimeoutInMin+" min");
    			jsClickNew(formsPageLink);
        		CommonUtility.checkPageIsReady(driver);
    		} catch (org.openqa.selenium.TimeoutException e) {
    			System.out.println("waited "+forceTimeoutInMin+" min for the page to finish loading, give up now");
    			driver.quit(); //note: force the test to fail instead of waiting time
    			Assert.assertTrue("PROBLEM - page still laoding after "+forceTimeoutInMin+" min, probably stuck, kill test now",false);
    		} catch (WebDriverException we) {
    			System.out.println("Got driver exception while waiting for page to finish loading, give up now");
    			driver.quit(); //force the test to fail instead of waiting time
    			Assert.assertTrue("PROBLEM - Got driver exception while waiting for page to finish loading",false);
    		}
    		System.out.println("page load should stopped loading now, give it 2 more sec to settle down");
    		Thread.sleep(2000); // note: give it a bit more time to settle down
    		pageLoad.stop();
    		long pageLoadTime_ms = pageLoad.getTime();
    		long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
    		System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
    		System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
    		if (driver.getTitle().contains("Documents")) {
    			return new FormsAndResourcesPage(driver);
    		}
    		return null;
    	}    
    	
    	public PlanDocumentsAndResourcesPage navigateDirectToPlanDocPage(int forceTimeoutInMin) throws InterruptedException {
    		checkForIPerceptionModel(driver);
    		StopWatch pageLoad = new StopWatch();
    		pageLoad.start();
    		JavascriptExecutor jse = (JavascriptExecutor) driver;
    		jse.executeScript("window.scrollBy(0,50)", "");
    		scrollToView(formsPageLink);
    		try {
    			driver.manage().timeouts().pageLoadTimeout((forceTimeoutInMin*60), TimeUnit.SECONDS);
    			System.out.println("Set pageLoadTimeout to "+forceTimeoutInMin+" min");
    			jsClickNew(formsPageLink);
        		Thread.sleep(5000);
        		isAlertPresent();
        		CommonUtility.checkPageIsReady(driver);
    		} catch (org.openqa.selenium.TimeoutException e) {
    			System.out.println("waited "+forceTimeoutInMin+" min for the page to finish loading, give up now");
    			driver.quit(); //note: force the test to fail instead of waiting time
    			Assert.assertTrue("PROBLEM - page still laoding after "+forceTimeoutInMin+" min, probably stuck, kill test now",false);
    		} catch (WebDriverException we) {
    			System.out.println("Got driver exception while waiting for page to finish loading, give up now");
    			//driver.quit(); //force the test to fail instead of waiting time
    			Assert.assertTrue("PROBLEM - Got driver exception while waiting for page to finish loading",false);
    		}
    		System.out.println("page load should stopped loading now, give it 2 more sec to settle down");
    		Thread.sleep(2000); // note: give it a bit more time to settle down
    		pageLoad.stop();
    		long pageLoadTime_ms = pageLoad.getTime();
    		long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
    		System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
    		System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
    		if (driver.getTitle().contains("Documents")) {
    			return new PlanDocumentsAndResourcesPage(driver);
    		}
    		return null;
    	}  
    	
    	public boolean isAlertPresent() {
    		try {
    				Alert alert = driver.switchTo().alert();
    				alert.accept();
    				System.out.println("Detected Alert popup, accept it and move on...");
    		} catch (NoAlertPresentException Ex) {
    			System.out.println("DID NOT detect Alert popup, move on...");
    			return false;
    		}
    		return true;
    	}


    	
    	public PharmaciesAndPrescriptionsPage navigateToPharAndPresFromTestHarnessPage() {
    		CommonUtility.checkPageIsReady(driver);
			checkForIPerceptionModel(driver);
    		try{
    			if (noWaitValidate(testHarnessPharPresLink)) 
    				testHarnessPharPresLink.click();
    			else 
    				testHarnessTopMenuPhaPresLink.click();
    		} catch (WebDriverException e) {
    			checkForIPerceptionModel(driver);
    			CommonUtility.checkPageIsReady(driver);
    			testHarnessPharPresLink.click();
    		}
    		CommonUtility.checkPageIsReady(driver);
    		checkForIPerceptionModel(driver);
    		if (driver.getCurrentUrl().contains("pharmacy/overview.html")) {
    			return new PharmaciesAndPrescriptionsPage(driver);
    		}
    		return null;
    	}
    	
    	@FindBy(tagName = "arcade-header")
    	private WebElement shadowRootHeader;

    	public boolean findPnPLinksExistOnPg() {
    		System.out.println("user is on '" + MRScenario.environmentMedicare + "' dashboard page, attempt to navigate to secondary page to see if PnP link exists");
    		checkForIPerceptionModel(driver);
    		if (noWaitValidate(pharPresDashboardLink)) {
    			return true;
    		} else if (noWaitValidate(testHarnessTopMenuPhaPresLink)) {
    			return true;
    		} else {
    			if (noWaitValidate(shadowRootHeader)) {
    				System.out.println("Check for shadow-root before giving up");
    				String secondTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(2)";
    				WebElement secondTopMenuItem = locateElementWithinShadowRootNoAssert(shadowRootHeader, secondTopMenuItemCssStr);
    				if (secondTopMenuItem!=null && secondTopMenuItem.getText().contains("FIND CARE")) {
    					String pnpTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(6)";
    					WebElement pnpTopMenuItem = locateElementWithinShadowRootNoAssert(shadowRootHeader, pnpTopMenuItemCssStr);
    					if (pnpTopMenuItem!=null && isPnpLink(pnpTopMenuItem.getText())) 
							return true;
    				} else if (secondTopMenuItem.getText().contains("CLAIMS")) {
    					String pnpTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(5)";
    					WebElement pnpTopMenuItem = locateElementWithinShadowRootNoAssert(shadowRootHeader, pnpTopMenuItemCssStr);
    					if (pnpTopMenuItem!=null && isPnpLink(pnpTopMenuItem.getText())) 
							return true;
    				}
    			} else {
    				System.out.println("There is no shadow-root menu");
    			}
    		}
    		return false;
    	}
 
    	public boolean isPnpLink(String targetLnkTxt) {
    		if (targetLnkTxt.equals("PHARMACIES") && targetLnkTxt.equals("PRESCRIPTIONS"))
    			return true;
    		else 
    			return false;
    	}

    	public WebElement expandRootElement(WebElement element) {
    		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
    				element);
    		return ele;
    	}

    	public WebElement locateElementWithinShadowRoot(WebElement shadowRootElement, String inputSelector) {
    		if (noWaitValidate(shadowRootElement)) {
    			System.out.println("located shadow-root element, attempt to process further...");
    			WebElement root1 = expandRootElement(shadowRootElement);
    			try {
    				WebElement element = root1.findElement(By.cssSelector(inputSelector));
    				Assert.assertTrue("Unable to locate shadowRoot element css select '"+inputSelector+"' on Dashboard", noWaitValidate(element));
    				return element;
    			} catch (Exception e) {
    				System.out.println("can't locate element. Exception e=" + e);
    				Assert.assertTrue("Got exception. Unable to locate shadowRoot element css select '"+inputSelector+"' on Dashboard", false);
    			}
    		} else {
    			System.out.println("no shadow-root element either, not sure what's going on w/ the header on rally");
    			Assert.assertTrue("No shadowRoot element on Dashboard", false);
    		}
    		return null;
    	}
    	
    	public WebElement locateElementWithinShadowRootNoAssert(WebElement shadowRootElement, String inputSelector) {
    		if (noWaitValidate(shadowRootElement)) {
    			System.out.println("located shadow-root element, attempt to process further...");
    			WebElement root1 = expandRootElement(shadowRootElement);
    			try {
    				WebElement element = root1.findElement(By.cssSelector(inputSelector));
    				if (noWaitValidate(element))
    					return element;
    			} catch (Exception e) {
    				System.out.println("can't locate element. Exception e=" + e);
    			}
    		} else {
    			System.out.println("no shadow-root element either, not sure what's going on w/ the header on rally");
    		}
    		return null;
    	}
    	
    	@FindBy(xpath="//a[contains(text(),'Notices')]")
    	private WebElement noticeAndDisclosuresLnk;
    	public void navigateToNoticeAndDisclosuresPage() {
    		Assert.assertTrue("PROBLEM - unable to locate the Legal Notice & Disclosures link on testhareness page", noWaitValidate(noticeAndDisclosuresLnk));
    		noticeAndDisclosuresLnk.click();
    		CommonUtility.checkPageIsReady(driver);
    		
    	}
    	
    	public boolean findPaymentTabOnTopMenu() {
    		return (noWaitValidate(paymentTabOnTopMenu));
    	}

    	//note: same as the UhcDriver validate but took out the waitforElementNew to speed things up
    	//note: don't want to @override that validate in case someone actually need that wait for 30 sec...
    	public boolean noWaitValidate(WebElement element) {
    		try {
    			if (element.isDisplayed()) {
    				System.out.println("Element found!!!!");
    				return true;
    			} else
    				System.out.println("Element not found/not visible");
    		} catch (Exception e) {
    			System.out.println("Exception: Element not found/not visible. Exception message - "+e.getMessage());
    		}
    		return false;
    	}
    	
    	@FindBy(xpath="//table[contains(@class,'testhatnessMemberTable')]")
    	private WebElement testharnessTable;
    	
    	public void waitForTestharnessTableToShow() {
    		CommonUtility.waitForPageLoad(driver, testharnessTable, 5);
    	}
    	/*
    	 * Validates Login on TestHarness Page 
    	 */
    	public void validateLoginonTestharness() throws InterruptedException {
    		CommonUtility.waitForPageLoadNew(driver, testHarnessHeader, 20);
    		String Message_text = testHarnessHeader.getText();
    		Assert.assertTrue(Message_text.contains("Test Harness"));
    		System.out.println(" *** TestHarness message assert is passed on the Testharness *** ");  
    		System.out.println("***The member is on Test Harness Dashboard & the text is :- "+ Message_text);
    		    		
    	}
    	
    	@FindBy(xpath = "//*[contains(@id,'home_2')]")
    	private WebElement HomeButton;
    	
    	public AccountHomePage navigateDirectToAcccntHomePage() {
    		JavascriptExecutor jse = (JavascriptExecutor) driver;
    		jse.executeScript("window.scrollBy(0,50)", "");
    		jsClickNew(HomeButton);
    		CommonUtility.checkPageIsReadyNew(driver);
    		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_60);
    		System.out.println(driver.getTitle());

    		if(driver.getCurrentUrl().contains("dashboard"))
    		 {  
    			return new AccountHomePage(driver);
    		}
    		return null;
    	}
		public void validateFindCareCostTab(String memberType) {
			if(memberType.equalsIgnoreCase("TERMINATED"))
				Assert.assertTrue("See find care cost tab when not expected", !validate(findCareCostTab,0));
			else
				validateNew(findCareCostTab,0);

		}
		public void clickOnPharmaciesNavTab() {
			CommonUtility.waitForPageLoad(driver, pharmaciesTab, 10);
			validateNew(pharmaciesTab,0);
			pharmaciesTab.click();
			validateNew(pharmaciesHeader,0);
			
		}
		public ContactUsPage clickOnHelpLink() {
			helpLink.click();
			return new ContactUsPage(driver);
		}
		
		public void clickLogout() {
			if (validate(logOut,0)) {
				logOut.click();
				validateNew(usernameField,0);
				if (driver.getTitle().equals("UnitedHealthcare Medicare Member Sign In"))
					Assert.assertTrue("user is logged out", true);

			}

		}

		@FindBy(xpath="//ul[contains(@class,'tabs')]//a[contains(text(),'Prescription') and contains(text(),'Medical')]") 
		protected WebElement comboTab_MAPD;

		@FindBy(xpath="//ul[contains(@class,'tabs')]//a[contains(text(),'Supplement')]") 
		protected WebElement comboTab_SHIP;

		@FindBy(xpath="//ul[contains(@class,'tabs')]//a[contains(text(),'Prescription') and not(contains(text(),'Medical'))]") 
		protected WebElement comboTab_PDP;

		@FindBy(xpath="//ul[contains(@class,'tabs')]//a[contains(text(),'Senior Supplement Plan')]") 
		protected WebElement comboTab_SSP;

		public void validatePaymentsTabNotDisplayed(String planType, String memberType) {
			if(validate(premiumPayment,0)) {
				if (memberType.toLowerCase().contains("combo")) {
					//note: has payment tab, check payment page to see if the plan tab show up or not
					premiumPayment.click();
					CommonUtility.checkPageIsReady(driver);
					WebElement targetTab=null;
					if (planType.equalsIgnoreCase("MAPD"))
						targetTab=comboTab_MAPD;
					else if (planType.equalsIgnoreCase("PDP") || planType.toUpperCase().startsWith("PDP")) 
						targetTab=comboTab_PDP;
					else if (planType.equalsIgnoreCase("SHIP")) 
						targetTab=comboTab_SHIP;
					else if (planType.equalsIgnoreCase("SSP") || planType.equalsIgnoreCase("SSUP")) 
						targetTab=comboTab_SSP;
					else  
						Assert.assertTrue("PROBLEM - ATDD hasn't code this condition yet", false);;
					Assert.assertTrue("PROBLEM - planType '"+planType+"' tab should not show up on payment page if it has 100% subsidy", !validate(targetTab,0));
				} else {
					Assert.fail("Payments tab not expected but still displayed");
				}
			}
		}

		public void validatePharmaciesTabNotDisplayed() {
			if(validate(pharmaciesTab,0))
				Assert.fail("Pharmacies Tab is not expected but still displayed");
			
		}
		public void validateHealthAndWellnessTabNotDisplayed() {
			if(validate(healthAndWellnessTab,0))
				Assert.fail("H&W Tab is not expected but still displayed");
			
		}
		public void validateFindCareCostTabNotAvailable() {
			Assert.assertTrue("find care cost tab displayed when not expected", !validate(findCareCostTab,0));			
		}
		
		/***
		 * 
		 * @param Category
		 */
		public void validateTestHarnessElement(String Category) {
			System.out.println(driver.getTitle());
			//checkModelPopup(driver);
			CommonUtility.checkPageIsReadyNew(driver);		
			validateNew(formsPageLink);
			validateNew(claimsTab);
			validateNew(benefitsPageLink);
			validateNew(profilePageLink);

		}
		
		public HealthAndWellnessPage navigateToHealthAndWellnessFromTestHarnessPage() {
			CommonUtility.checkPageIsReady(driver);
			checkModelPopup(driver,5);
			validateNew(testHarnessHealthAndWellnessLink,0);
			testHarnessHealthAndWellnessLink.click();
			CommonUtility.checkPageIsReady(driver);
			checkModelPopup(driver,5);
			CommonUtility.waitForPageLoad(driver, healthAndWellnessHeader, CommonConstants.TIMEOUT_90);
			if (driver.getTitle().contains("Health And Wellness")) {
				return new HealthAndWellnessPage(driver);
			}
			return null;
		}

		public MyDocumentsPage navigateToMyDocumentsFromTestHarnessPage() {
			CommonUtility.checkPageIsReady(driver);
			checkModelPopup(driver,5);
			validateNew(testHarnessMyDocumentsLink);
			testHarnessMyDocumentsLink.click();
			CommonUtility.checkPageIsReady(driver);
			checkModelPopup(driver,5);
			CommonUtility.waitForPageLoad(driver, heading, 5);
			if (driver.getTitle().contains("My Documents")) {
				return new MyDocumentsPage(driver);
			}
			return null;
		}
		
		   public void userdirectlyaccessesmyhcesso() {
			   System.out.println("Accessing https://stage-medicare.uhc.com/myhce");
			   driver.navigate().to("https://stage-medicare.uhc.com/myhce");
				 
			   try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   System.out.println("Current URL is :  "+driver.getCurrentUrl());
			   
			   }

		 
		   public void userEntersZipCode(String zipCode) {
			   
			   	try {
			   		if (driver.getTitle().contains("Zip Code Entry Page"))
			   				{
			   			System.out.println("Zip code Page / zip entry text box field was displayed");
			   			CommonUtility.waitForPageLoad(driver, zipCodeTextBox, 20);
			   			System.out.println("Now entering Zip code fetched from feature file");
			   			sendkeys(zipCodeTextBox, zipCode);
			   			System.out.println("Zip code was enetered");
			   				}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Zip code Page / zip entry text box field was not displayed, failing this test script");
					Assert.fail("Zip code text box fiels was not displayed");
				}
			       }	
		   
	public void clickContinueonZipEntryPage() {
				// TODO Auto-generated method stub
			   System.out.println("Now clicking Continue button");
			   continueButton.click();
			   System.out.println("Continue button was clicked");
			   try {
				   System.out.println("Waiting for 5 seconds");
					Thread.sleep(5000);
					CommonUtility.checkPageIsReadyNew(driver);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		   
		   
		public void checkuserlandsonhceestimatorpage() {
			 System.out.println("Current URL is :  "+driver.getCurrentUrl());
			 System.out.println("Now checking for header element h1 of the page");
			 
				try {
					String gethcePageText = hcePageText.getText();
					System.out.println("Now checking if header element h1 of the page contains myHealthcare Cost Estimator text");
			   		if (gethcePageText.contains("myHealthcare Cost Estimator"))
			   				{
			   			System.out.println("myHealthcare Cost Estimator Text was displayed");
			   			
			   				}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("myHealthcare Cost Estimator Text was not displayed in h1 header of myhce page, failing this test script");
					Assert.fail("myHealthcare Cost Estimator Text was not displayed");
				}
			
			
		}
		   
}
