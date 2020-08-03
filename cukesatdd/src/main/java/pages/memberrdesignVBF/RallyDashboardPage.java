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
import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.memberrdesignVBF.HealthAndWellness;

public class RallyDashboardPage extends UhcDriver {

	@FindBy(id = "findcarecost2")
	private WebElement panelFindCareCost1;

	@FindBy(xpath = "(//sticky[@id='sticky-nav']//a[contains(text(),'Find Care')])[1]")
	private List<WebElement> panelFindCareCost;

	@FindBy(xpath = "(//sticky[@id='sticky-nav']//a[contains(text(),'Coverage & Benefits')])[1]")
	private WebElement panelBnC;

	@FindBy(xpath = "(//sticky[@id='sticky-nav']//a[contains(text(),'Premium Payments')])[1]")
	private List<WebElement> panelPremiumPayment;

	@FindBy(xpath = "(//sticky[@id='sticky-nav']//a[contains(text(),'Home')])[1]")
	private WebElement panelHome;

	@FindBy(xpath = "(//sticky[@id='sticky-nav']//a[contains(text(),'Claims')])[1]")
	private WebElement panelClaims;

	@FindBy(xpath = "(//sticky[@id='sticky-nav']//a[contains(text(),'Health')])[1]")
	private WebElement panelHealth;

	@FindBy(xpath = "//button[@id='dropdown-toggle--1']/span[contains(text(),'Profile')]")
	private WebElement accountToggleDropdown;

	@FindBy(xpath = "//a[@class='dropdown-option' and contains(text(),'Account Settings')]")
	private WebElement accountSettingOption;

	@FindBy(xpath = "//h1[contains(@class,'main-heading')]")
	private WebElement heading;

	@FindBy(xpath = "//div[@id='ui-view-page']//span[contains(text(),'Look up Drugs')]")
	private WebElement DCE_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//span[contains(text(),'Claims')]")
	private WebElement Claims_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//span[contains(text(),'Discounts')]")
	private WebElement discount_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//span[contains(text(),'Find a Provider')]")
	private WebElement provider_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//span[contains(text(),'EOB')]")
	private WebElement EobTile_Dashboard;

	@FindBy(xpath = "//span[contains(text(),'Locate a Pharmacy')]/ancestor::a/img")
	private WebElement PharmacyLocator_Dashboard;

	@FindBy(className = "view-id-link")
	private WebElement IDLinkDashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='VIEW_DOCUMENTS_AND_RESOURCES']")
	private WebElement formsResources_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//div[@class='container']//a[@track='VIEW_DISCOUNTS_AND_SERVICES']")
	private WebElement discountLink_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//div[@class='container']//a[@track='AARP']")
	private WebElement aarpOrg_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement OrderMaterials_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='EOB_SEARCH']")
	private WebElement EOB_Dashboard;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement OrderMaterial_Dashboard;

	@FindBy(className = "promo-tile")
	private WebElement promoTile_Dashboard;

	@FindBy(xpath = "//h1[contains(@class,'margin-none')]")
	private WebElement orderplanHeadertxt;

	@FindBy(xpath = "//sticky[@id='sticky-nav']//a[contains(text(),'Coverage & Benefits')]")
	private WebElement BnClink;

	@FindBy(xpath = "(//nav[contains(@class,'utility-nav')]//a/span[contains(text(),'Help')])[1]")
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

	@FindBy(id = "healthwellness_5")
	private WebElement healthWellness;

	@FindBy(id = "Help")
	private WebElement help;

	@FindBy(id = "accountprofile")
	private WebElement accountProfile;

	@FindBy(className = "menuL1")
	private WebElement header;

	@FindBy(id = "arcade-footer")
	private WebElement footerSection;

	@FindBy(xpath = "//*[@id='IPEinvL']/map/area[3]")
	private static WebElement FeedbackModal;

	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'no']")
	private static List<WebElement> FeedbackModalList;

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

	@FindBy(xpath = "//ul[@id='dropdynamic']//a[contains(text(),'Log Out')]")
	private WebElement NavAccountProfSignOut;

	@FindBy(xpath = "//ul[@id='dropdynamic']//a[contains(text(),'Account Settings')]")
	private WebElement NavAccountProfSetting;

	@FindBy(xpath = "//h2[text() = 'Common Services & Costs']")
	private List<WebElement> CommonCostServiceHeading;

	@FindBy(className = "cost-col")
	private List<WebElement> CommonCostTable;

	@FindBy(xpath = "//div[@class='id-card-links']/ul[contains(@class,'account-info')]/li/span")
	private List<WebElement> memberIDs;

	@FindBy(xpath = "//div[contains(@class,'costs')]//div[@class='cost-col ng-scope no-cost-items']/a[contains(text(),'View plan detail')]")
	private WebElement commonCostSectionShip;

	@FindBy(xpath = "(//div[@class='inactive-coverage-status ng-scope']//span[contains(text(),'Coverage Ended:')])[1]")
	private WebElement coverageEndedText;
	
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

	public RallyDashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		category = CommonStepDefinition.getMemberAttributeMap().get("Member Type");
		checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, HelloMessage, 60);
		//validateNew(panelClaims);
		//validateNew(panelHome);
		validateNew(HelloMessage,0);

		if (category != null && category.contains(CommonConstants.CATEGORY_TERMIATED)) {
			validateNew(coverageEndedText,0);
		}
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public PaymentsOverview navigateToPaymentOverview() throws InterruptedException {
		System.out.println("Inside navigateToPaymentOverview functions");
		validateNew(panelPremiumPayment.get(0));
		panelPremiumPayment.get(0).click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Payment")) {
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

		if (driver.getTitle().contains("Profile")) {
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

		if (driver.getTitle().contains("Benefits")) {
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
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_30);
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
		if (driver.getTitle().contains("Claims")) {
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
		if (!(driver.getTitle().contains("Explanation of Benefits"))) {
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
		if (driver.getTitle().contains("Benefits")) {
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
		jsClickNew(healthWellness);
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
		if (!(driver.getTitle().contains("Explanation of Benefits"))) {
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
		if (Category.contains(CommonConstants.CATEGORY_TERMIATED)) {
			Assert.assertTrue("Common Cost Service Heading not display", CommonCostServiceHeading.isEmpty());
			Assert.assertTrue("Common Cost Service table not display", CommonCostTable.isEmpty());
			Assert.assertTrue("Find Care and Cost not display", panelFindCareCost.isEmpty());
			validateNew(HelloMessage);
			validateNew(EobTile_Dashboard);
			validateNew(Claims_Dashboard);
			validateNew(IDLinkDashboard);
			validateNew(EOB_Dashboard);
			validateNew(formsResources_Dashboard);
			validateNew(ContactUsLink);
			validateNew(helpnContactUs);
			validateNew(accountnSettings);

		} else {
			if (!(("Ship").equalsIgnoreCase(Category))) {
				validateNew(panelFindCareCost.get(0));
			}
			if (!(("GroupRetireeMapd").equalsIgnoreCase(Category))) {
				validateNew(panelPremiumPayment.get(0));
			}
			if (("ComboMAPDANDSHIP").equalsIgnoreCase(Category)) {
				validateNew(memberIDs.get(0));
				Assert.assertTrue("The first member ID:" + memberIDs.get(0).getText() + " is a non ship plan",
						memberIDs.get(0).getText().contains("-00"));
				validateNew(memberIDs.get(1));
				Assert.assertTrue("The first member ID:" + memberIDs.get(1).getText() + " is a ship plan",
						memberIDs.get(1).getText().contains("-11"));
				validateNew(commonCostSectionShip);
				/*
				 * validateNew(discount_Dashboard);
				 * validateNew(discountLink_Dashboard);
				 */
				validateNew(aarpOrg_Dashboard);
			}
			validateNew(panelClaims);
			validateNew(panelHealth);
			validateNew(accountToggleDropdown);
			validateNew(Claims_Dashboard);
			validateNew(IDLinkDashboard);
			validateNew(CommonCostServiceHeading.get(0));
			validateNew(CommonCostTable.get(0));
			validateNew(formsResources_Dashboard);
			validateNew(OrderMaterials_Dashboard);
			validateNew(promoTile_Dashboard);
			validateNew(ContactUsLink);
			validateNew(HelloMessage);
			validateNew(helpnContactUs);
			validateNew(accountnSettings);
		}
	}

	/***
	 * 
	 * @return
	 */
	public FormsAndResourcesPage navigateDirectToFnRPage() {
		if (category.contains(CommonConstants.CATEGORY_TERMIATED)) {
			validateNew(BnClink);
			BnClink.click();
		} else {
			validateNew(formsResources_Dashboard);
			formsResources_Dashboard.click();
		}
		CommonUtility.checkPageIsReadyNew(driver);
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
	public FormsAndResourcesPage clickFormsAndResourcesTab() {

		validateNew(formsAndResources);
		formsAndResources.click();

		CommonUtility.checkPageIsReadyNew(driver);
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
	public HealthAndWellness clickHealthnWellnessSecondaryTab() {
		validateNew(healthWellness);
		jsClickNew(healthWellness);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Health")) {
			return new HealthAndWellness(driver);
		}
		return null;

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
}