package pages.memberrdesignVBF;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class RallyDashboardPage extends UhcDriver {

	@FindBy(id = "findcarecost2")
	private WebElement panelFindCareCost1;

	@FindBy(xpath = "(//nav[@id='main-nav']//a[contains(text(),'Find Care')])[1]")
	private WebElement panelFindCareCost;

	@FindBy(xpath = "(//nav[@id='main-nav']//a[contains(text(),'Coverage & Benefits')])[1]")
	private WebElement panelBnC;

	@FindBy(xpath = "(//nav[@id='main-nav']//a[contains(text(),'Premium Payments')])[1]")
	private WebElement panelPremiumPayment;

	@FindBy(xpath = "(//nav[@id='main-nav']//a[contains(text(),'Home')])[1]")
	private WebElement panelHome;

	@FindBy(xpath = "(//nav[@id='main-nav']//a[contains(text(),'Claims')])[1]")
	private WebElement panelClaims;

	@FindBy(xpath = "(//nav[@id='main-nav']//a[contains(text(),'Health')])[1]")
	private WebElement panelHealth;

	@FindBy(xpath = "//button[@id='dropdown-toggle--1']/span[contains(text(),'Profile')]")
	private WebElement accountToggleDropdown;

	@FindBy(xpath = "//a[@class='dropdown-option' and contains(text(),'Account Settings')]")
	private WebElement accountSettingOption;

	@FindBy(xpath = "//header//h1")
	private WebElement heading;

	@FindBy(xpath = "//div[@id='ui-view-page']//span[contains(text(),'Look up Drugs')]")
	private WebElement DCE_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//span[contains(text(),'Claims')]")
	private WebElement Claims_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//span[contains(text(),'Find a Provider')]")
	private WebElement provider_Dashboard;

	@FindBy(xpath = "//span[contains(text(),'Locate a Pharmacy')]/ancestor::a/img")
	private WebElement PharmacyLocator_Dashboard;

	@FindBy(className = "view-id-link")
	private WebElement IDLinkDashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='VIEW_DOCUMENTS_AND_RESOURCES']")
	private WebElement formsResources_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement OrderMaterials_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='EOB_SEARCH']")
	private WebElement EOB_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement OrderMaterial_Dashboard;

	@FindBy(className = "promo-tile")
	private WebElement promoTile_Dashboard;

	@FindBy(xpath = "//h1[@class='h4 margin-none']")
	private WebElement orderplanHeadertxt;

	@FindBy(xpath = "//sticky[@id='sticky-nav']//nav[@id='main-nav']//a[contains(text(),'Coverage & Benefits')]")
	private WebElement BnClink;

	@FindBy(xpath = "(//nav[@id='utility-nav']//a/span[contains(text(),'Help')])[1]")
	private WebElement ContactUsLink;

	@FindBy(id = "hello-person")
	private WebElement HelloMessage;

	@FindBy(id = "claimsummaryC1")
	private WebElement claimSummary;

	@FindBy(id = "eobC1")
	private WebElement explainationOfBenefits;

	@FindBy(id = "coveragebenefits_2")
	private WebElement coverageBenefits;

	@FindBy(id = "benefitssummary")
	private WebElement benefitsSummary;

	@FindBy(id = "formsandresourcesC1")
	private WebElement formsAndResources;

	@FindBy(id = "ordermaterials")
	private WebElement orderMaterials;

	@FindBy(id = "premiumpayment_3")
	private WebElement premiumPayment;

	@FindBy(id = "healthwellness_3")
	private WebElement healthWellness;

	@FindBy(id = "Help")
	private WebElement help;

	@FindBy(id = "accountprofile")
	private WebElement accountProfile;

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

	@FindBy(partialLinkText = "Asistencia de Idiomas | Aviso de no Discriminación (PDF)")
	private WebElement languageAssistanceSpanish;

	@FindBy(xpath = "//a[starts-with(@id,'ACCdropdown_') and contains(text(),'Log Out')]")
	private WebElement NavAccountProfSignOut;

	@FindBy(xpath = "//a[starts-with(@id,'ACCdropdown_') and contains(text(),'Account Settings')]")
	private WebElement NavAccountProfSetting;

	@FindBy(xpath = "//h2[text() = 'Common Services & Costs']")
	private WebElement CommonCostServiceHeading;

	@FindBy(className = "cost-col")
	private WebElement CommonCostTable;

	public RallyDashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, panelHome, 60);
		validateNew(panelClaims);
		validateNew(panelHome);
		validateNew(HelloMessage);
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public PaymentsOverview navigateToPaymentOverview() throws InterruptedException {
		System.out.println("Inside navigateToPaymentOverview functions");
		validateNew(panelPremiumPayment);
		panelPremiumPayment.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Overview")) {
			return new PaymentsOverview(driver);
		}
		return null;
	}

	/***
	 * 
	 * @return
	 */
	public pages.memberrdesignVBF.ProfilePreferencesPage navigateDirectToProfilePage() {
		System.out.println(driver.getTitle());
		validateNew(accountToggleDropdown);
		accountToggleDropdown.click();
		validateNew(accountSettingOption);
		accountSettingOption.click();
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Profile")) {
			System.out.println("Pass!");
			return new ProfilePreferencesPage(driver);
		}
		return null;
	}

	/***
	 * 
	 * @return
	 */
	public BenefitsAndCoveragePage navigateDirectToBnCPag() {

		validateNew(BnClink);
		BnClink.click();

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
	public ContactUsPage navigateToContactUsPage() {
		validateNew(ContactUsLink);
		ContactUsLink.click();
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
		validateNew(DCE_Dashboard);
		DCE_Dashboard.click();
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
	public HealthAndWellness clickHealthnWellnessTab() {
		validateNew(panelHealth);
		panelHealth.click();
		CommonUtility.checkPageIsReadyNew(driver);
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
		validateNew(OrderMaterial_Dashboard);
		OrderMaterial_Dashboard.click();
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
		PharmacyLocator_Dashboard.click();
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
	public ClaimSummarypage navigateToClaimsSummaryPage() {
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(Claims_Dashboard);
		Claims_Dashboard.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new ClaimSummarypage(driver);
		}
		return null;
	}

	/***
	 * 
	 */
	public void validateHomeTab() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(panelHome);
		panelHome.click();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(HelloMessage);
	}

	public ProviderSearchPage validateFindCareCostTab() {
		CommonUtility.checkPageIsReadyNew(driver);
		panelFindCareCost1.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Find Care")) {
			return new ProviderSearchPage(driver);
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
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
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
		if (!(driver.getTitle().equalsIgnoreCase("EOB Search"))) {
			Assert.fail("EOB page not getting displayed");
		}
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
	public BenefitsAndCoveragePage validateBnCNaviation() {
		validateNew(panelBnC);
		panelBnC.click();
		validateNew(benefitsSummary);
		benefitsSummary.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Benefits Overview")) {
			return new BenefitsAndCoveragePage(driver);
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
		if (driver.getTitle().equalsIgnoreCase("Overview")) {
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
		accountProfile.click();
		validateNew(NavAccountProfSignOut);
		validateNew(NavAccountProfSetting);
		scrollToView(accountProfile);
		accountProfile.click();
	}

	/***
	 * 
	 * @return
	 */
	public OrderplanmaterialsPage validateOrderPlanMaterialsPage() {
		orderMaterials.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (orderplanHeadertxt.isDisplayed()) {
			return new OrderplanmaterialsPage(driver);
		}
		return null;
	}

	/***
	 * 
	 * @return
	 */
	public HealthAndWellness validateHealthnWellnessPage() {
		validateNew(healthWellness);
		healthWellness.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Health")) {
			return new HealthAndWellness(driver);
		}
		return null;

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
		Assert.assertTrue("Saved link is not clickable", saved.isDisplayed());
		Assert.assertTrue("Logout link is not clickable", logout.isDisplayed());
		validateQuickLinksFooterLinks();
	}

	public static void checkModelPopup(WebDriver driver) {
		int counter = 0;
		System.out.println("Initial value of conter: " + counter);
		do {

			System.out.println("current value of conter: " + counter);

			if (driver.findElements(By.xpath("//area[@href='javascript:clWin()'][@alt = 'no']")).isEmpty()) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}

			}

			else {
				System.out.println("FeedBack Modal Present and counter value is:" + counter);
				try {
					Thread.sleep(2000);
					WebElement NoThanks = driver.findElement(By.xpath("//*[@id='IPEinvL']/map/area[3]"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", NoThanks);
					js.executeScript("arguments[0].click();", NoThanks);
					break;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			counter++;
		} while (counter < 1);
	}

	/***
	 * 
	 */
	public void validateSavedLink() {
		Assert.assertTrue("Saved link is not clickable", saved.isDisplayed());
	}

	/***
	 * 
	 * @return
	 */
	public EOBPage navigateToEOBPage() {
		validateNew(EOB_Dashboard);
		EOB_Dashboard.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (!(driver.getTitle().equalsIgnoreCase("EOB Search"))) {
			Assert.fail("EOB page not getting displayed");
			return null;
		} else {
			CommonUtility.waitForPageLoadNew(driver, heading, 10);
			return new EOBPage(driver);
		}
	}

	public ProviderSearchPage navigateToProviderSearch() {
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, provider_Dashboard, 60);
		validateNew(provider_Dashboard);
		provider_Dashboard.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Find Care")) {
			return new ProviderSearchPage(driver);
		}
		return null;
	}

	/***
	 * 
	 * @param Category
	 */
	public void validateDashboardElements(String Category) {
		CommonUtility.checkPageIsReadyNew(driver);
		if (!(("Ship").equalsIgnoreCase(Category))) {
			validateNew(panelFindCareCost);
		}
		if (!(("GroupRetireeMapd").equalsIgnoreCase(Category))) {
			validateNew(panelPremiumPayment);
		}
		validateNew(panelClaims);
		validateNew(panelHealth);
		validateNew(accountToggleDropdown);
		validateNew(Claims_Dashboard);
		validateNew(IDLinkDashboard);
		validateNew(CommonCostServiceHeading);
		validateNew(CommonCostTable);
		validateNew(formsResources_Dashboard);
		validateNew(OrderMaterials_Dashboard);
		validateNew(promoTile_Dashboard);
		validateNew(ContactUsLink);
		validateNew(HelloMessage);
		validateNew(helpnContactUs);
		validateNew(accountnSettings);

	}

}