package pages.memberrdesignVBF;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.memberrdesignVBF.HealthAndWellness;
import pages.regression.accounthomepage.AccountHomePage;

public class TestHarness extends UhcDriver {

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Payment')]")
	private WebElement PaymentPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Claim')]")
	private WebElement claimsPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Forms and Resource')]")
	private WebElement formsPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'benefits')]")
	private WebElement benefitsPageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'profile')]")
	private WebElement profilePageLink;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'EOB Search')]")
	private WebElement eobPageLink;

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

	@FindBy(xpath = "//div[contains(@class,'header') or contains(@class,'testharness')]/h1[normalize-space()=contains(text(),' ')][not (contains(@class,'ng-hide'))]")
	private WebElement heading;

	@FindBy(xpath = "//div[@class='tabs-desktop']/ul[@class='nav nav-tabs']/li")
	private List<WebElement> tabsForComboMember;

	@FindBy(id = "home_2")
	private WebElement panelHome;

	@FindBy(id = "claims_1")
	private WebElement panelClaims;

	@FindBy(id = "coveragebenefits_1")
	private WebElement panelBenefits;

	@FindBy(id = "healthwellness_4")
	private List<WebElement> panelHealthWellness;

	@FindBy(id = "findcarecost2")
	private List<WebElement> panelFindcarecost;

	@FindBy(id = "claimsummaryC1")
	private WebElement claimSummary;

	@FindBy(id = "eobC1")
	private WebElement explainationOfBenefits;

	@FindBy(id = "benefitssummary")
	private WebElement benefitsSummary;

	@FindBy(id = "formsandresourcesC1")
	private WebElement formsAndResources;

	@FindBy(id = "ordermaterials")
	private WebElement orderMaterials;

	@FindBy(id = "coveragebenefits_2")
	private WebElement coverageBenefits;

	@FindBy(id = "premiumpayment_3")
	private WebElement premiumPayment;

	@FindBy(id = "Help")
	private WebElement help;

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

	@FindBy(id = "copyrightUHC")
	private WebElement aboutUHC;

	@FindBy(linkText = "Legal Entity Disclosure")
	private WebElement legalDisclosures;

	@FindBy(linkText = "Privacy Policy")
	private WebElement privacyPolicy;

	@FindBy(linkText = "Terms of Use")
	private WebElement termsOfUse;

	@FindBy(partialLinkText = "Language Assistance | Non-Discrimination Notice")
	private WebElement languageAssistanceEnglish;

	@FindBy(partialLinkText = "Asistencia de Idiomas | Aviso de no Discriminación (PDF)")
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
	
	@FindBy(className = "atdd-need-help")
	private WebElement neepHelp;
	
	@FindBy(xpath = "//div[@class='technical section']//*[contains(@class,'atdd-tech-header')]")
	private WebElement technicalSupportHeading;
	
	@FindBy(xpath = "//div[@class='plan section']//*[contains(@class,'atdd-plan-header')]")
	private WebElement planSupportHeading;
	
	@FindBy(xpath = "//div[@class='technical section']//*[contains(@class,'display-inline-block') and string-length(text()=13)]")
	private WebElement techSupportTelephone;
	
	@FindBy(xpath = "//div[@class='plan section']//*[contains(@class,'display-inline-block') and string-length(text()=13)]")
	private WebElement planSupportTelephone;
	
	String category = null;

	public TestHarness(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		category = CommonStepDefinition.getMemberAttributeMap().get("Member Type");
		checkModelPopup(driver);
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

	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public PaymentsOverview navigateToPaymentOverview() throws InterruptedException {
		System.out.println("Inside navigateToPaymentOverview functions");
		CommonUtility.waitForPageLoadNew(driver, premiumPayment, 30);
		premiumPayment.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, heading, 60);
		if (driver.getTitle().contains("Payments")) {
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
		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_60);
		System.out.println(driver.getTitle());

		if (driver.getTitle().contains("Benefits")) {
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
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
		if (driver.getTitle().contains("Claims")) {
			return new ClaimSummarypage(driver);
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkForIPerceptionModel(driver);
		validateNew(contactUsPageLink);
		contactUsPageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_60);
		if (driver.getTitle().trim().contains("Contact Us")) {
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
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
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

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public HealthAndWellness clickHealthnWellnessTab() throws InterruptedException {
		/*
		 * validateNew(healthWellness); healthWellness.click();
		 */
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
		// CommonUtility.checkPageIsReadyNew(driver);
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
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
		if (driver.getTitle().contains("Order")) {
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
		CommonUtility.waitForPageLoad(driver, pharmacyPageLink, 30);
		validateNew(pharmacyPageLink);
		pharmacyPageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
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
	public pages.memberrdesignVBF.ProfilePreferencesPage navigateDirectToProfilePage() {
		System.out.println(driver.getTitle());
		CommonUtility.waitForPageLoad(driver, profilePageLink, 30);
		validateNew(profilePageLink);
		profilePageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_60);

		if (driver.getTitle().contains("Profile")) {
			System.out.println("Pass!");
			return new ProfilePreferencesPage(driver);
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
	 */
	public FormsAndResourcesPage navigateDirectToFnRPage() {
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
	public BenefitsAndCoveragePage validateBnCNaviation() {
		validateNew(coverageBenefits);
		coverageBenefits.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
		benefitsSummary.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
		if (driver.getTitle().contains("Benefits")) {
			return new BenefitsAndCoveragePage(driver);
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
	 */
	public FormsAndResourcesPage clickFormsAndResourcesTab() {

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
	 */
	public OrderplanmaterialsPage validateOrderPlanMaterialsPage() {
		orderMaterials.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
		if (heading.isDisplayed()) {
			return new OrderplanmaterialsPage(driver);
		}
		return null;
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public PaymentsOverview validatePremiumPaymentPage() throws InterruptedException {
		System.out.println("Inside navigateToPaymentOverview functions");
		validateNew(premiumPayment);
		premiumPayment.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_60);
		if (driver.getTitle().contains("Payment")) {
			return new PaymentsOverview(driver);
		}
		return null;
	}

	/***
	 * 
	 */
	public void validateContactUsPage() {
		validateNew(help);
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
	public void validateNeedHelpSection(){
		scrollToView(neepHelp);
		Assert.assertTrue("neepHelp is not displayed", neepHelp.isDisplayed());
		scrollToView(technicalSupportHeading);
		Assert.assertTrue("technicalSupportHeading is not displayed", technicalSupportHeading.isDisplayed());
		scrollToView(planSupportHeading);
		Assert.assertTrue("planSupportHeading is not displayed", planSupportHeading.isDisplayed());
		scrollToView(techSupportTelephone);
		Assert.assertTrue("techSupportTelephone is not displayed", techSupportTelephone.isDisplayed());
		scrollToView(planSupportTelephone);
		Assert.assertTrue("neepHelp is not displayed", planSupportTelephone.isDisplayed());
		
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
}
