package pages.regression.accounthomepage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
//import pages.member.redesign.ContactUsPage;
import pages.member_deprecated.ulayer.OneTimePaymentsPage;
import pages.member_deprecated.ulayer.PlanComparePage;
import pages.member_deprecated.ulayer.Rallytool_Page;
import pages.memberrdesignVBF.RallyDashboardPage;
//import pages.member_deprecated.ulayer.TestHarness;
import pages.regression.IDCardPage.IDCardPage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.claims.ClaimDetailsPage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.contactus.ContactUsPage;
import pages.regression.drugcostestimator.DrugCostEstimatorPage;
import pages.regression.explanationofbenefits.DreamEOBPage;
import pages.regression.explanationofbenefits.EOBPage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import pages.regression.healthandwellness.HealthAndWellnessPage;
import pages.regression.ordermaterials.OrderMaterialsPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.pharmacylocator.PharmacySearchPage;
import pages.regression.planDocumentsAndResources.PlanDocumentsAndResourcesPage;
//import pages.member_deprecated.bluelayer.BenefitsAndCoveragePage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import org.apache.commons.lang.time.StopWatch;
import org.openqa.selenium.WebDriverException;
import pages.regression.testharness.*;

public class AccountHomePage extends UhcDriver {

	@FindBy(xpath = ".//*[@id='dropdown-options-0']/a[3]/span")
	private WebElement acctProfile;

	@FindBy(xpath = "//a[contains(text(),'Go to Forms and Resource page')]")
	private WebElement FormRsrceLinkTestHarness;

	@FindBy(xpath = "//*[@id='dropdown-options--1']/a[3]")
	private WebElement acctSetting;

	@FindBy(xpath = "(//h2)[1]")
	private WebElement preEffectiveMessage;

	@FindBy(id = "plan_material_fnr2018")
	private WebElement PlanMaterialSection;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Contact Us')]")
	private WebElement contactUsPageLink;

	// @FindBy(css = ".view-id-link")
//	@FindBy(xpath = "(//*[contains(text(),'View & print member ID cards')])[1]")
//	private WebElement idCardLink;

	@FindBy(xpath = "(//*[@class='ng-scope']//a[text()='Premium Payments'])[1]")
	private WebElement paymentsLink;

	@FindBy(xpath = "//a[contains(text(),'Go to Payments page')]")
	private WebElement TestHarnesspaymentsLink;

	@FindBy(xpath = "//*[@id='premiumpayment_3']")
	private WebElement paymentsLink3; // after clicking benefit and coverage
	// page this is the link for payment
	// history

	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;

	@FindBy(className = "footerContainer")
	private WebElement footerSection;

	@FindBy(id = "claimsummaryC1")
	private WebElement claimSummary;

	@FindBy(id = "eobC1")
	private WebElement explainationOfBenefits;

	@FindBy(linkText = "medical providers")
	private WebElement medicalProviders;

	@FindBy(id = "claims_1")
	private WebElement claims;

	@FindBy(xpath = "//a[@class='quick-link' and contains(@href,'claims/overview.html')]")
	private WebElement viewYourClaimsLink;
	/*
	 * @FindBy(xpath = "//li[@id='fd_myMenu']/a")
	 */
	@FindBy(xpath = "//li[@id='fd_myMenu']/a")
	private WebElement myMenuNavigator;

	@FindBy(linkText = "Prescription drug cost and benefits summary")
	private WebElement prescriptionDrugCostBenefitSummaryLink;

	@FindBy(linkText = "Search drug claims")
	private WebElement searchDrugClaims;

	@FindBy(linkText = "Search claim history")
	private WebElement searchClaimsHistory;

	@FindBy(linkText = "Search medical claims")
	private WebElement searchMedicalClaims;

	@FindBy(xpath = "(.//*[@class='link-row ng-scope']//a[@class='link-text ng-scope ng-binding'])[1]")
	private WebElement medicalEobLink;

	@FindBy(xpath = "//*[@id='dashboard']/div[1]/section[7]/link-bar/div/div/div[1]/div/a)")
	private WebElement medicalEobLinkOther;

	@FindBy(linkText = "Prescription Drug Explanation of Benefits (EOB)")
	private WebElement prescriptionDrugEobLink;

	@FindBy(xpath = "//div[@id='medicareTitle']/h1")
	private WebElement pharmacyLocatorHeading;

	@FindBy(xpath = "//*[@id='medicareTitle']/p/a[1]")
	private WebElement espanolLink;

	@FindBy(xpath = "//*[@id='medicareTitle']/p/a[2]") // Story 261070
	private WebElement chineseLink;

	@FindBy(xpath = "////*[@id='subPageLeft']/div[2]/div[2]/h3[2]/a")
	private WebElement createPdfLink;

	@FindBy(xpath = "//span[contains(.,'Print temporary ID card')]")
	private WebElement viewIDCard;

	// @FindBy(xpath = "//div[@class='claim-results']//table[not
	// (contains(@class,'ng-hide'))]//tbody//tr[2]//a[text()='MORE INFO']")
	// @FindBy(xpath = "//a[contains (text(), 'MORE INFO')]")
	@FindBy(xpath = "//*[@id='moreInfoLinkAtdd0']/a")
	private WebElement claimstablemoreinfolinkCombo;

	@FindBy(id = "pcpLogoPrint1left")
	private WebElement validateLogo;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/h1")
	private WebElement paymentsHeading;

	@FindBy(xpath = ".//*[@id='plan_box']/div/div[2]/div/p/a")
	private WebElement planNameLink;

	@FindBy(xpath = "//button[@id='dropdown-toggle--1' or @id='dropdown-toggle-2']")
	private WebElement accountProfileBtn;

	@FindBy(xpath = ".//*[@id='dropdown-options-2']/a[contains(text(),'Account Settings')]")
	// @FindBy(linkText = "Account Settings")
	private WebElement accountSettingOption;

	@FindBy(xpath = "//h1")
	private WebElement heading;

	@FindBy(xpath = "//html//body//div//div//div[1]//div[2]//div//div//header//div//div[1]//nav")
	private WebElement headingContactUs;
	
	// @FindBy(xpath="//*[@id='phr_widget_3_box']/div[233]/p[2]/a")
	// private WebElement providerSearchinPHPage1;

	// @FindBy(xpath="div[@class='phr_greybox_mid']/p[contains(text(),'Need to
	// find a facility?')]/following-sibling::p/a")
	// private WebElement providerSearchinPHPage1;

	@FindBy(xpath = ".//*[@id='IPEinvL']/map/area[2]")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "//button[@class='btn btn-no']")
	private WebElement iPerceptionPopUpNoButton;
	
	@FindBy(xpath = "//dashboard//a[contains(text(),'Contact')]")
	private WebElement linkContactUs;

	@FindBy(xpath = "//a[contains(text(),'Contact Us page')]")
	private WebElement helpAndContactUslink;

	@FindBy(xpath = "html/body/div[2]/div/div[4]/div[2]/div/table/tbody/tr[6]/td[2]/a")
	private WebElement profilenpreferenceslink;

	@FindBy(id = "authQuestiontextLabelId")
	private WebElement questionid;
	@FindBy(id = "challengeQuestionList[0].userAnswer")
	private WebElement securityAnswer;

	@FindBy(id = "continueSubmitButton")
	private WebElement continueButton;
	
	@FindBy(xpath="//button[@name='Update']")
	private WebElement continueButtonmyHCESSO;
	
	@FindBy(xpath="//h1")
	private WebElement hcePageText;

	@FindBy(xpath = "//*[@id='nav']/button[2]")
	private WebElement iPerceptionAutoPopUp;

	public WebElement getiPerceptionAutoPopUp() {
		return iPerceptionAutoPopUp;
	}

	@FindBy(xpath = "//*[@id='sticky-nav']//div[@ng-switch-when='M&R']/a[5]")
	private WebElement PremiumPayment;

	@FindBy(xpath = "//*[@id='premiumpayment_3']")
	private WebElement PremiumPaymentTestHarness;

	@FindBy(xpath = "//*[@id='sticky-nav']//div[@ng-switch-when='M&R']/a[4]")
	private WebElement ShipPremiumPayment;

	@FindBy(xpath = "//*[@id='paymentOverviewApp']//div[@class='container']//div[@class='col-md-12']/h2[1]")
	private WebElement PaymentHeading;

	@FindBy(linkText = "Compare 2017 Plans")
	private WebElement planCompareLink;

	@FindBy(xpath = "//div[@class='prefermain_mid mapd_div']/div/h3")
	private WebElement planCompareHeader;

	@FindBy(xpath = ".//*[contains(text(),'search for providers')]")
	private WebElement searchForProviders;

	@FindBy(linkText = "Order drugs from your Preferred Mail Service Pharmacy")
	private WebElement drugPreferredMailServicePharmacyLink;

	// @FindBy(xpath = "//div[@class='claim-results']//table[not
	// (contains(@class,'ng-hide'))]//tbody//tr[2]//a[text()='MORE INFO']")
	// @FindBy(xpath =
	// "//div[@class='claim-results']//tbody//tr[2]//td//span[@id='moreInfoLinkAtdd0']")
	@FindBy(xpath = "//a[contains (text(), 'MORE INFO')]")
	private WebElement claimstablemoreinfolink;

	@FindBy(css = ".claimDetTableMainSection")
	private WebElement claimDetTableMainSection;

	// @FindBy(xpath = "//*[@id='dashboard']//span[text()='View Your Claims']")
	@FindBy(xpath = "//*[@id='main-nav']/div/div/div/a[3]")
	private WebElement claimsDashboardLink;

	// note: for workaround if getting 'Sorry' error, go to account setting then
	// go to claims
	@FindBy(xpath = "//a[@id='claims_1']")
	private WebElement claimsWorkAround;

	@FindBy(xpath = "//*[@id='row2link1']/td[2]/a")
	private WebElement claimsTestharnessLink;

	@FindBy(xpath = "//*[@id='row2link6']/td[2]/a")
	private WebElement dceTestharnessLink;

	@FindBy(xpath = "//*[contains(@id,'row2link')]/td[2]/a[contains(text(), 'EOB')]")
	private WebElement eobTestharnessLink;

	@FindBy(xpath = "//span[contains (text(), 'Look up Drugs')]")
	private WebElement drugLookup;

	@FindBy(xpath = "//a[contains(text(),'Drug Lookup')]")
	private WebElement drugLookuplink;

	@FindBy(css = ".primary-logo")
	private WebElement logoImage;

	@FindBy(css = ".container .secondary-logo")
	private WebElement cologoImage;

	@FindBy(xpath = "//*[@ng-src='/images/icons/icon-pharmacy-locator.svg']")
	private WebElement pharmacySearchLink;
	
	@FindBy(xpath="//header[@class='section-header']//a[contains(@class,'pharmacy-locator')]")
	private WebElement section_pharmacySearchLink;

	@FindBy(xpath="//header[@class='section-header']//a[contains(@class,'drug-lookup')]")
	private WebElement section_drugLocator;

	// for Header
	@FindBy(id = "premiumpayment_3")
	private WebElement premiumPayment;

	@FindBy(id = "paymentOverviewApp")
	public static WebElement paymentsOverview;
	
	@FindBy(xpath="//*[@class='btn btn--primary onetimepayment']")
	private WebElement MakeAPaymentButton;
	
	@FindBy(xpath="//span[contains(text(),'Make a Payment')]")
	private WebElement makeapayment;

	@FindBy(linkText = "Find Care & Costs")
	private WebElement findCareCost;
	
	@FindBy(xpath = " //h1[@class='main-heading margin-none']")
	private WebElement EOBHeading;
	
	@FindBy(xpath= "//nav[@id='sub-nav']//a[@class='ng-scope'][contains(text(),'Explanation of Benefits')]")
	private WebElement EOBLINK;
	
	/*
	 * @FindBy(xpath = "(//a[text()='Find Care & Costs'])[1]")
	 * private WebElement
	 * findCareCost;
	 */

	@FindBy(xpath = ".//header[@class='hide-mobile']//a[contains(text(),'Find Care & Costs')]")
	private WebElement findCare;

	@FindBy(className = "menuL1")
	private WebElement header;

	@FindBy(id = "IPerceptionsEmbed")
	public WebElement iPerceptionframe;

	@FindBy(id = "closeButton")
	public WebElement iPerceptionclosebtn;

	@FindBy(id = "coveragebenefits_2")
	private WebElement coverageBenefits;

	@FindBy(xpath = "//*[@id='sticky-nav']/sticky-content/nav/div/div/div/div/a[4]")
	private WebElement dashboard_coverageBenefits;

	@FindBy(id = "benefitssummary")
	private WebElement benefitsSummary;

	@FindBy(id = "formsandresourcesC1")
	private WebElement formsAndResources;

	@FindBy(id = "ordermaterials")
	private WebElement orderMaterials;

	@FindBy(id = "accountprofile")
	private WebElement accountProfile;

	@FindBy(id = "Help")
	private WebElement help;

	@FindBy(xpath = ".//*[@id='dropdynamic']/li/a[contains(text(),'Log Out')]")
	private WebElement logOut;

	@FindBy(id = "main-nav")
	private WebElement dashboardHeader;

	// Terminated view

	@FindBy(xpath = ".//header[@class='hide-mobile']//a[contains(text(),'Premium Payments')]")
	private WebElement dashbaordPremiumPayment;

	// @FindBy(xpath =
	// ".//header[@class='hide-mobile']//a[contains(text(),'Coverage &
	// Benefits')]")
	@FindBy(xpath = "//header//*[contains(text(),'Coverage & Benefits')]")
	private WebElement coverageBenefitsDashboard;

	// @FindBy(xpath =
	// ".//header[@class='hide-mobile']//a[contains(text(),'Claims')]")
	@FindBy(xpath = "//header//*[contains(text(),'Claims')]")
	private WebElement claimsDashboard;

	// @FindBy(className = "help-link")
	@FindBy(xpath = "//header//*[contains(text(),'Help')]")
	private WebElement helpDashboard;

	@FindBy(xpath = ".//header[@class='hide-mobile']//a[contains(text(),'Find Care & Costs')]")
	private WebElement dashboardFindCare;

	// Added by Sneha - Navigate to Order Plan Materials
	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement OrderMaterial_Dashboard;

	@FindBy(id = "hello-person")
	private WebElement helloPerson;
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome to your new plan')]")
	private WebElement welcome;

	@FindBy(xpath = "//*[@id='ordermaterials']")
	private WebElement OrderMaterialsTab_BnCPage;

	@FindBy(xpath = "//*[@class = 'main-heading margin-none']")
	private WebElement orderplanHeadertxt;

	// @FindBy(xpath = "//*[@class='tabs-desktop']//li[@role='listitem'][2]/a")
	@FindBy(xpath = "//*[@class='tabs-desktop']//a[contains(.,'Medicare Supplement Insurance Plan')]")
	private WebElement ShipTab;

	@FindBy(xpath = "//*[@class='table-body margin-large']/div[2]//p")
	private WebElement PayDate;

	// @FindBy(xpath = ".//*[@id='cltotshipindsnf']")
	@FindBy(xpath = "//*[@id='cltotshippartb']/div/div[1]/div/div/div/div/div[1]/div/p")
	private WebElement claimtotalcomb;

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

	/*
	 * @FindBy(xpath ="//*[@id='paymentHistoryApp1']//div/p/span") private
	 * WebElement PaymentHistorySection;
	 */
	@FindBy(xpath = "//*[@id='paymentHistoryApp1']//div//div[@class='col-md-12']/h2")
	private WebElement PaymentHistorySection;

	@FindBy(xpath = "//*[@id='atddUhcPagination']/li[3]/a")
	private WebElement paginationRightArrow;

	@FindBy(xpath = "//*[@id='moreInfoLinkAtdd2']/a") // tbd
	private WebElement specificclaimlinkforeob;

	
	 @FindBy(tagName = "arcade-header") 
	 private WebElement shadowRootHeader;
	 

	@FindBy(tagName = "arcade-footer")
	private WebElement shadowRootFooter;

	@FindBy(xpath = "//span[contains(@class,'account-info-label')]")
	private WebElement accountLabel;

	@FindBy(xpath="//span[contains(@class,'account-info-label')]/../../inactive-coverage//span[@translate='COVERAGE_ENDED']")
	private WebElement coverageEnded;

	@FindBy(xpath="//span[contains(@class,'account-info-label')]/../../inactive-coverage//span[@translate='COVERAGE_STARTS']")
	private WebElement coverageStarted;
	
	@FindBy(xpath = "//*[contains(@id,'home')]")
	private WebElement HomeTopMenuButton;

	@FindBy(xpath = "//*[@id='main-nav']/div/div/div/a[6]")
	private WebElement pharPresDashboardLink;

	@FindBy(xpath = "//a[@id='pharmacies_5']")
	private WebElement pharPresDashboardLinkAlternative;

	@FindBy(xpath="//div[@id='ui-view-modal']/div/activate-covid-modal/div/div/div/div/button[2]")
	protected WebElement dashboardCovideModalDismissLink;
	
	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='EOB_SEARCH']")
	private WebElement EOB_Dashboard;
	
	@FindBy(xpath="//header[contains(@class,'sub-nav-header')]//a[contains(@ng-href,'eob.html')]")
	protected WebElement eobTopMenuLink;
	
	//@FindBy(xpath="//a[contains(text(),'View Documents & Resources')]")
	@FindBy(xpath="//div[contains(@class,'link-bar')]//a[contains(@href,'documents/overview.html')]")
	protected WebElement planDocResPgLink;
	
	@FindBy(name="zipCode")
	private WebElement zipCodeTextBox;
	
	@FindBy(xpath="//nav[@class='menuL1']//a[contains(@id,'ordermaterials')]")
	protected WebElement desktopOrderPlanFromBenefitSubLink;

	@FindBy(xpath = "(//*[contains(@class,'btn btn-outline-primary')])[1]")
	private WebElement homePageNotice;

	@FindBy(xpath = "//button/span[contains(text(),'Home Page')]")
	protected WebElement homePageNotice2;

	@FindBy(xpath = "//a[contains(text(),'Home Page')]")
	protected WebElement homePageNotice3;
	
	@FindBy(xpath="//a[contains(@data-track-id,'MANAGE_PRESCRIPTIONS')]")
	private WebElement pharamciesAndPrescriptionsLink;
	
	@FindBy(xpath="//div[contains(text(),'FIND A PHARMACY')]")
	private WebElement findAPharmacyLink;
	@FindBy(xpath = "//span[contains(text(),'View Your Claims')]")
	private WebElement claimsDashboardLink1;
	@FindBy(id="premiumpayment_3")
	private WebElement premiumPayments;
	
	
	private PageData myAccountHome;
	
	public JSONObject accountHomeJson;

	private static String PAGE_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;

	public AccountHomePage(WebDriver driver, String category) {
		super(driver);
		PageFactory.initElements(driver, this);
		if (category.equalsIgnoreCase("Individual")) {
			String fileName = CommonConstants.ACCOUNT_HOME_PAGE_INDIVIDUAL_DATA;
			myAccountHome = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		} else {
			String fileName = CommonConstants.ACCOUNT_HOME_PAGE_DATA;
			myAccountHome = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		}
		// initialize this in case need to workaround later due to Sorry login
		// error for certain testing
		attemptSorryWorkaround = new HashMap<String, String>();
		attemptSorryWorkaround.put("needWorkaround", "no");
		attemptSorryWorkaround.put("planType", "na");
		attemptSorryWorkaround.put("testType", "na");

		// openAndValidate();
	}

	public AccountHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// initialize this in case need to workaround later due to Sorry login
		// error for certain testing
		attemptSorryWorkaround = new HashMap<String, String>();
		attemptSorryWorkaround.put("needWorkaround", "no");
		attemptSorryWorkaround.put("planType", "na");
		attemptSorryWorkaround.put("testType", "na");
		/*
		 * try {
		 * 
		 * if (iPerceptionPopUp.isDisplayed()) { iPerceptionPopUp.click(); }
		 * }catch(Exception e) {
		 * System.out.println("iPerception Pop Up not displayed"); }
		 */
		// openAndValidate();
	}

	public BenefitsAndCoveragePage navigateDirectToBnCPag(String Plantype) {

		if (MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.contains("prod")) {
			checkModelPopup(driver,5);
			if (noWaitValidate(shadowRootHeader)) {
				System.out.println("located shadow-root element, attempt to process further...");
				WebElement root1 = expandRootElement(shadowRootHeader);
				try {
					WebElement benefitsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
					benefitsTopMenuShadowRootLink.click();
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - unable to locate Benefits link on Rally Dashboard top menu", false);
				}		

			} 
			CommonUtility.checkPageIsReady(driver);
			checkModelPopup(driver,5);
			/* tbd 
			if (Plantype.equalsIgnoreCase("MAPD") || Plantype.equalsIgnoreCase("PDP")
					|| Plantype.equalsIgnoreCase("HIP") || Plantype.equalsIgnoreCase("MA")
					|| Plantype.equalsIgnoreCase("MAPDRX") || Plantype.equalsIgnoreCase("MAPDVill")) {
				System.out.println("user is on Stage login page");
				// CommonUtility.waitForPageLoad(driver, claimsDashboardLink,
				// 90);
				if (driver.getCurrentUrl().contains("/dashboard"))
					;
				{
					System.out.println("User is on dashboard page and URL is ==>" + driver.getCurrentUrl());

					driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(driver.getCurrentUrl());
					CommonUtility.waitForPageLoad(driver, heading, 30);
					if (driver.getTitle().contains("Benefits")) {
						System.out.println(driver.getTitle());
						return new BenefitsAndCoveragePage(driver);
					}

				}
			}

			else if (Plantype.equalsIgnoreCase("MEDICA")) {
				System.out.println("user is on Stage login page.");
				// CommonUtility.waitForPageLoad(driver, claimsDashboardLink,
				// 90);
				if (driver.getCurrentUrl().contains("/dashboard"))
					;
				{
					System.out.println("User is on dashboard page and URL is ==>" + driver.getCurrentUrl());

					driver.navigate().to("https://" + MRScenario.environmentMedicare
							+ "-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
					try {
						Thread.sleep(40000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(driver.getCurrentUrl());
					CommonUtility.waitForPageLoad(driver, heading, 30);
					if (driver.getTitle().contains("Benefits")) {
						System.out.println(driver.getTitle());
						return new BenefitsAndCoveragePage(driver);
					}

				}
			} else if (Plantype.equalsIgnoreCase("PCP")) {
				System.out.println("user is on Stage login page");
				// CommonUtility.waitForPageLoad(driver, claimsDashboardLink,
				// 90);
				if (driver.getCurrentUrl().contains("/dashboard"))
					;
				{
					System.out.println("User is on dashboard page and URL is ==>" + driver.getCurrentUrl());

					driver.navigate().to("https://" + MRScenario.environmentMedicare
							+ "-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(driver.getCurrentUrl());
					CommonUtility.waitForPageLoad(driver, heading, 30);
					if (driver.getTitle().contains("Benefits")) {
						System.out.println(driver.getTitle());
						return new BenefitsAndCoveragePage(driver);
					}

				}
			}
			*/
		} else if (MRScenario.environment.equals("team-h") || MRScenario.environment.equals("test-a")
				|| MRScenario.environment.equals("team-e") || MRScenario.environment.equals("team-c")) {

			driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
			System.out.println(driver.getCurrentUrl());
		} else {
			if (Plantype.equalsIgnoreCase("PCP")) {
				driver.navigate().to("https://" + MRScenario.environment
						+ "-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
			} else if (Plantype.equalsIgnoreCase("MEDICA")) {
				driver.navigate().to("https://" + MRScenario.environment
						+ "-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
			} else {
				driver.navigate().to("https://" + MRScenario.environment
						+ "-medicare.ose-elr-core.optum.com/content/medicare/member/benefits/overview.html");
			}
		}

		CommonUtility.waitForPageLoad(driver, heading, 50);
		/*
		 * if (driver.getTitle().equalsIgnoreCase("Benefits")) { return new
		 * BenefitsAndCoveragePage(driver); }
		 */
		if (driver.getTitle().contains("Benefits")) {
			return new BenefitsAndCoveragePage(driver);
		}

		return null;
	}

	public void waitForHomePage(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/*
	 * This function clicks on Benefits and Coverage link from Dashboard after
	 * waiting for Hello-Person name text to be displayed on page
	 */

	public BenefitsAndCoveragePage navigateToBandCPage(String PlanType){
	System.out.println("Checking for Welcome or Hello on Dashboard home page now");
			
			try {
				CommonUtility.waitForPageLoad(driver, helloPerson, 5);
				if (helloPerson.isDisplayed()) 
				{
					System.out.println("Hello PersonName on Dashboard home page was found and exact message is :"+helloPerson.getText());
				}
			    }
			catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Catch block - Hello PersonName message was not found on Dashboard home page, ignore if it is pre-effective member ");	
				}	
			try 
			{
				CommonUtility.waitForPageLoad(driver, welcome, 5);
			    if (welcome.isDisplayed()) 
			    System.out.println("Welcome message displayed on Dashboard is: "+welcome.getText());
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Catch block - Welcome message was not found on Dashboard home page, ignore if it active member ");	
		}
		    		
		if (MRScenario.environment.equalsIgnoreCase("stage") && ("NO".equalsIgnoreCase(MRScenario.isTestHarness))) 
		{
			System.out.println("user is on Stage login page");
			// CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);
		
		if (driver.getCurrentUrl().contains("/aarp/dashboard"))
		        {
				System.out.println("User is on dashboard page and URL is ==>" + driver.getCurrentUrl());

				driver.navigate().to(PAGE_URL + "aarp/member/benefits-coverage.html");
		        }
				
	    if (driver.getCurrentUrl().contains("/pcp/dashboard"))
			 {
					System.out.println("User is on dashboard page and URL is ==>" + driver.getCurrentUrl());

					driver.navigate().to("https://" + MRScenario.environment
							+ "-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
			 }
		if (driver.getCurrentUrl().contains("/medica/dashboard"))
					 {
							System.out.println("User is on dashboard page and URL is ==>" + driver.getCurrentUrl());

							driver.navigate().to("https://" + MRScenario.environment
							+ "-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
					 }
	    if (driver.getCurrentUrl().contains("/retiree/dashboard"))
			 {
			  System.out.println("User is on dashboard page and URL is ==>" + driver.getCurrentUrl());

			  driver.navigate().to(PAGE_URL + "retiree/member/benefits-coverage.html"); 
			 }
		if (driver.getCurrentUrl().contains("/medicare/dashboard"))
				 {
				  System.out.println("User is on dashboard page and URL is ==>" + driver.getCurrentUrl());

				  driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html"); 
	     }
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(driver.getCurrentUrl());
		//CommonUtility.waitForPageLoad(driver, heading, 30);
		if (driver.getTitle().contains("Benefits")) {
			System.out.println(driver.getTitle());
			return new BenefitsAndCoveragePage(driver);
		}
		}										
			
		else if (MRScenario.environment.equals("stage") && ("YES".equalsIgnoreCase(MRScenario.isTestHarness))) {
			driver.navigate().to(PAGE_URL + "content/medicare/member/benefits/overview.html");
			System.out.println(driver.getCurrentUrl());
			if (driver.getTitle().contains("Benefits")) {
				System.out.println(driver.getTitle());
				return new BenefitsAndCoveragePage(driver);
			}

		} else if (MRScenario.environment.equals("team-h") || MRScenario.environment.equals("test-a")) {

			driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
			System.out.println(driver.getCurrentUrl());
		} else if (MRScenario.environment.equals("team-c")) {
			driver.navigate().to(
					"https://team-c-medicare.ose-elr-core.optum.com/content/medicare/member/benefits/overview.html");
			System.out.println(driver.getCurrentUrl());
			return new BenefitsAndCoveragePage(driver);
		} else if (MRScenario.environment.equals("team-e")) {
			jsClickNew(driver.findElement(By.xpath("//td[text()='benefits and coverage page ']/following::a[1]")));
			CommonUtility.waitForPageLoad(driver, heading, 30);
			System.out.println(driver.getCurrentUrl());
			return new BenefitsAndCoveragePage(driver);
		} else if (MRScenario.environment.equals("prod") || MRScenario.environment.equals("offline")) {
			

			if (validate(shadowRootHeader)) {
				System.out.println("located shadow-root element, attempt to process further...");
				WebElement root1 = expandRootElement(shadowRootHeader);
				try {
					// Going inside shadow root to get element, in this case the
					// logo is in the shadow root header
					System.out.println("Value of Plan Type is: "+PlanType);
					
					if (PlanType.equalsIgnoreCase("SHIP"))
					{	
					WebElement BenefitsandCoverageTab = root1.findElement(By
							.cssSelector("#sticky-main-nav > div > div > div > a:nth-child(3)"));
					System.out.println("shadow-root element has been located, now clicking on Benefits and Coverage tab");	
					TestHarness.checkForIPerceptionModel(driver);
					BenefitsandCoverageTab.click();
					}
					else 
					{
						WebElement BenefitsandCoverageTab = root1.findElement(By
								.cssSelector("#sticky-main-nav > div > div > div > a:nth-child(4)"));
						System.out.println("shadow-root element has been located, now clicking on Benefits and Coverage tab");	
						TestHarness.checkForIPerceptionModel(driver);
						BenefitsandCoverageTab.click();
					}
					
					System.out.println("Benefits an Coverage tab has been clicked");	
					CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current URL is : "+driver.getCurrentUrl());
			if (driver.getCurrentUrl().contains("benefits"))
			{
				System.out.println("Current URL contains benefits text in it, returning BenefitsAndCoveragePage");	
			return new BenefitsAndCoveragePage(driver);
		     } 
			else
			{
				Assert.fail("Current URL doesn't contains benefits text in it, benefits page didn't appear , failed");
			}
			}
				catch(Exception e)
			{
				System.out.println("Could not locate shadow root element for benefits and coverage tab");
				Assert.fail("Could not locate shadow root element for benefits and coverage tab");
			}
		}
		}
		else
		{
			driver.navigate().to(
					"https://team-ci1-medicare.ose-elr-core.optum.com/content/medicare/member/benefits/overview.html");
			System.out.println(driver.getCurrentUrl());
			return new BenefitsAndCoveragePage(driver);
		}

		/*
		 * if (validate(iPerceptionPopUp)) { iPerceptionPopUp.click();
		 * System.out.println("iPerception Pop Up displayed"); }
		 */

		CommonUtility.waitForPageLoad(driver, heading, 50);
		if (driver.getTitle().equalsIgnoreCase("Benefits Overview")) {
			return new BenefitsAndCoveragePage(driver);
		}
	
		return null;
		}
	
	public ProfileandPreferencesPage navigateDirectToProfilePage() throws InterruptedException {

		System.out.println("waiting for profile page");
		// Testing through Test Harness Page
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			System.out.println("testing through test harness page");
			try {
				if (acctProfile.isDisplayed()) {
					acctProfile.click();
					acctSetting.click();
				} else {
					driver.findElement(By.xpath("//*[@id='home_2']")).click();
					Thread.sleep(6000);
				}
			} catch (Exception e) {
				driver.findElement(By.xpath("//*[@id='home_2']")).click();
				Thread.sleep(6000);
			}
			checkForIPerceptionModel(driver);
			if (driver.getCurrentUrl().contains("profile")) {
				System.out.println("Navigating to Profile Page");
				return new ProfileandPreferencesPage(driver);
			}
		} else {
			System.out.println("test is through stage");
		} // Testing through Stage
		if (MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.contains("prod") || MRScenario.environment.equalsIgnoreCase("offline")) {
			System.out.println("user is on Stage login page");
			if (driver.getCurrentUrl().contains("/dashboard")) {
				CommonUtility.waitForPageLoad(driver, acctProfile, 9);
				if (validate(acctProfile)) {
					acctProfile.click();
					acctSetting.click();
				} else {
					checkModelPopup(driver,5);
					if (noWaitValidate(shadowRootHeader)) {
						System.out.println("located shadow-root element, attempt to process further...");
						WebElement root1 = expandRootElement(shadowRootHeader);
						try {
							WebElement acctSettingMenuShadowRootBtn = root1.findElement(By.cssSelector("#dropdown-toggle-2,#dropdown-toggle-4"));
							acctSettingMenuShadowRootBtn.click();
						} catch (Exception e) {
							Assert.assertTrue("PROBLEM - unable to locate Account Profile button on Rally Dashboard top menu", false);
						}
						try {
							WebElement acctSettingLink = root1.findElement(By.cssSelector("a[data-testid*=TARGET_AWARE_ACCOUNT_SETTINGS]"));
							acctSettingLink.click();
						} catch (Exception e) {
							Assert.assertTrue("PROBLEM - unable to locate Account Profile link on Rally Dashboard top menu", false);
						}
							
					} 
					CommonUtility.checkPageIsReady(driver);
					checkModelPopup(driver,5);
					/* tbd 

					// note: check to see if account setting dropdown link is
					// inside shadow-root element
					try {
						locateAndClickElementWithinShadowRoot(shadowRootHeader,
								"#dropdown-toggle-2");
						locateAndClickElementWithinShadowRoot(shadowRootHeader,
								"#dropdown-options-2 > a:nth-child(2)");
						System.out.println("clicked account setting dropdown");
						if (validate(accountLabel,0) && (accountLabel.getText().toLowerCase().contains("supplement")
								|| accountLabel.getText().toLowerCase().contains("medicare prescription drug"))
								|| validate(coverageEnded,0) || validate(coverageStarted,0)) {
							int index=2;
							String menuItemCssStr="#dropdown-options-2 > a:nth-child("+index+")";
							WebElement link = locateElementWithinShadowRoot(shadowRootHeader,
									menuItemCssStr);
							if (link.getText().equalsIgnoreCase("logout"))
								menuItemCssStr="#dropdown-options-2 > a:nth-child("+(index-1)+")";
							locateAndClickElementWithinShadowRoot(shadowRootHeader,	menuItemCssStr);
						} else {
							int index=3;
							String menuItemCssStr="#dropdown-options-2 > a:nth-child("+index+")";
							WebElement link = locateElementWithinShadowRoot(shadowRootHeader,
									menuItemCssStr);
							if (link.getText().equalsIgnoreCase("logout"))
								menuItemCssStr="#dropdown-options-2 > a:nth-child("+(index-1)+")";
							locateAndClickElementWithinShadowRoot(shadowRootHeader,	menuItemCssStr);
						}
						System.out.println("clicked account setting options within account setting dropdown button");
					} catch (NoSuchElementException e) { // note: try one more selector before giving up
						System.out.println("got NoSuchElement exception - now try next thing ");
						locateAndClickElementWithinShadowRoot(shadowRootHeader,
								"#dropdown-toggle-0 > span > span:nth-child(2)");
						System.out.println("clicked account setting dropdown");
						if (validate(accountLabel,0) && (accountLabel.getText().toLowerCase().contains("supplement")
								|| accountLabel.getText().toLowerCase().contains("medicare prescription drug")
								|| validate(coverageEnded,0) || validate(coverageStarted,0))) {
							int index=2;
							String menuItemCssStr="#dropdown-options-0 > a:nth-child("+index+")";
							WebElement link = locateElementWithinShadowRoot(shadowRootHeader,
									menuItemCssStr);
							if (link.getText().equalsIgnoreCase("logout"))
								menuItemCssStr="#dropdown-options-0 > a:nth-child("+(index-1)+") >";
							locateAndClickElementWithinShadowRoot(shadowRootHeader,	menuItemCssStr);
						} else {
							int index=3;
							String menuItemCssStr="#dropdown-options-0 > a:nth-child("+index+") >";
							WebElement link = locateElementWithinShadowRoot(shadowRootHeader,
									menuItemCssStr);
							if (link.getText().equalsIgnoreCase("logout"))
								menuItemCssStr="#dropdown-options-0 > a:nth-child("+(index-1)+") >";
							locateAndClickElementWithinShadowRoot(shadowRootHeader,	menuItemCssStr);
						}
						System.out.println("clicked account setting options within account setting dropdown button");
					}
				*/
				} 
				System.out.println("title is " + driver.getTitle());
				System.out.println("Current Url is " + driver.getCurrentUrl());
				checkForIPerceptionModel(driver);
				if (driver.getCurrentUrl().contains("profile")) {
					return new ProfileandPreferencesPage(driver);
				}
				return null;
			} else if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
				workaroundAttempt("profilepref");
			}
			// Thread.sleep(6000);
			// CommonUtility.waitForPageLoad(driver, heading, 10);
			checkForIPerceptionModel(driver);

			if (driver.getCurrentUrl().contains("profile")) {
				return new ProfileandPreferencesPage(driver);
			}
			return null;

		} else if (MRScenario.environment.equals("team-ci1") || MRScenario.environment.equals("team-h")
				|| MRScenario.environment.equals("test-a") || MRScenario.environment.equals("team-e")
				|| MRScenario.environment.equalsIgnoreCase("prod") ) {

			driver.navigate().to(driver.getCurrentUrl() + "/medicare/member/account/profile.html");

			System.out.println("title is " + driver.getTitle());
			System.out.println("Current Url is " + driver.getCurrentUrl());
			// Testing through ci1 Environment
		} else {
			driver.navigate().to(
					"https://team-ci1-medicare.ose-elr-core.optum.com/content/medicare/member/account/profile.html");
			System.out.println("title is " + driver.getTitle());
			System.out.println("Current Url is " + driver.getCurrentUrl());

		}
		checkForIPerceptionModel(driver);
		if (driver.getTitle().contains("Profile")) {
			return new ProfileandPreferencesPage(driver);
		}
		return null;
	}

	public void rallytoolexist() {
		String mainwindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(mainwindow)) {
				driver.switchTo().window(currentWindowHandle);

			}
		}
		CommonUtility.checkPageIsReady(driver);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = driver.getTitle();
		System.out.println(s);

		if (s.equalsIgnoreCase("Find Care")) {
			System.out.println("Rally tool is opened Successfully");
			driver.close();
		} else {
			System.out.println("Rally tool is not opened ");

			Assert.assertFalse("Rally tool displayed", false);

			// Assert.fail("Error :Unable to Login");
			driver.close();
		}

		driver.switchTo().window(mainwindow);

	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : myAccountHome.getExpectedData().keySet()) {
			WebElement element = findElement(myAccountHome.getExpectedData().get(key));
			if (null != element) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		accountHomeJson = jsonObject;
		System.out.println("accountHomeJson----->" + accountHomeJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		JSONObject accountHomeExpectedJson = expectedDataMap.get(CommonConstants.MY_ACCOUNT_HOME);
		accountHomeExpectedJson = CommonUtility.mergeJson(accountHomeExpectedJson, globalExpectedJson);
		return accountHomeExpectedJson;
	}

	public void navigate_ProviderSearch() {
		validate(medicalProviders);
		medicalProviders.click();
		String baseWindowHdl = driver.getWindowHandle();
		driver.getWindowHandles();

		for (String h : driver.getWindowHandles()) {
			driver.switchTo().window(h);
			if (!h.equals(baseWindowHdl)) {
				driver.close();
			}

		}
		driver.switchTo().window(baseWindowHdl);
	}

	public String getPlanName() {
		return planNameLink.getText();
	}

	public void validateHomePage() throws InterruptedException {
		Thread.sleep(10000);
		if (getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | My Account Home")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	public void validateTheSecurityQues(String friendname, String favouritecolor, String phoneNumber) {
		String Question = questionid.getText();
		System.out.println("question is" + Question);
		if (Question.equalsIgnoreCase("What is your best friend's name?")) {
			System.out.println("Question is related to friendname");
			securityAnswer.sendKeys(friendname);
			continueButton.click();
		}

		else if (Question.equalsIgnoreCase("What is your favorite color?")) {
			System.out.println("Question is related to color");
			securityAnswer.sendKeys(favouritecolor);
			continueButton.click();
		} else {
			System.out.println("Question is related to phone");
			securityAnswer.sendKeys(phoneNumber);
			continueButton.click();
		}

	}

	public ProfileandPreferencesPage navigatedirectToProfilePageurl() throws InterruptedException {
		// Navigate direct using Profile Page URL for Stage
		if (MRScenario.environment.equalsIgnoreCase("stage")) {
			System.out.println("user is on Stage login page");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto generated catch block
				e.printStackTrace();
			}

			String StageProfilePageURL = "https://stage-medicare.uhc.com/member/account/profile.html";
			System.out.println("Directly navigating to the Profile Page by passing the URL");
			driver.navigate().to(StageProfilePageURL);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto generated catch block
				e.printStackTrace();
			}

			
			try 
				{
				System.out.println("Trying to switch to iPerception iframe if it is present");	
				driver.switchTo().frame("IPerceptionsEmbed");
				if (validate(iPerceptionPopUpNoButton)) {
					iPerceptionPopUpNoButton.click();
					System.out.println("iPerception Pop Up No button was clicked");
					driver.switchTo().defaultContent();
				}
				
			} catch (Exception e) {
				System.out.println("iPerception Pop Up was not displayed");
			}

			CommonUtility.waitForPageLoad(driver, heading, 5);
			if (driver.getTitle().contains("Profile")) {
				System.out.println("Header (h1) of the page is : " + heading.getText());
				return new ProfileandPreferencesPage(driver);
			}
		}
		return null;
	}
	
	public ProfileandPreferencesPage navigateDirectToProfilePageHsid() throws InterruptedException {
		// TODO Auto-generated method stub
		if (MRScenario.environment.equalsIgnoreCase("stage")) {
			System.out.println("user is on Stage login page");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto generated catch block
				e.printStackTrace();
			}
			// CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);
			if (driver.getCurrentUrl().contains("/dashboard"))
				// ;
			{

				accountProfileBtn.click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto generated catch block
					e.printStackTrace();
				}
				validate(accountSettingOption);
				accountSettingOption.click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto generated catch block
					e.printStackTrace();
				}
				checkForIPerceptionModel(driver);
				System.out.println("title is " + driver.getTitle());
				System.out.println("Current Url is " + driver.getCurrentUrl());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto generated catch block
					e.printStackTrace();
				}
				if (driver.getTitle().contains("Profile")) {

					return new ProfileandPreferencesPage(driver);
				}

			}
		}

		Thread.sleep(5000);
		if (validate(iPerceptionPopUp)) {
			iPerceptionPopUp.click();
			System.out.println("iPerception Pop Up displayed");
		}

		if (MRScenario.environment.equals("team-ci1") || MRScenario.environment.equals("team-h")
				|| MRScenario.environment.equals("test-a") || MRScenario.environment.equals("team-e")) {
			WebElement element = driver.findElement(By.xpath("//a[contains(.,'profile page')]"));
			validateNew(element);
			element.click();
			/*
			 * accountToggleDropdown1.click(); validate(accountSettingOption1);
			 * accountSettingOption1.click();
			 */
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto generated catch block
				e.printStackTrace();
			}
		} else {
			profilenpreferenceslink.click();
		}
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, heading, 5);
		if (driver.getTitle().contains("Profile")) {
			System.out.println("here");
			return new ProfileandPreferencesPage(driver);
		}

		return null;

	}

	public void verifyPageTitle() throws InterruptedException {
		
	    CommonUtility.checkPageIsReadyNew(driver);	
	    if (driver.getCurrentUrl().contains("bannerpopup.html")) {
			System.out.println("COVID 19 Banner page has appeared");
			try {
				CommonUtility.waitForPageLoad(driver, homePageNotice, 20);
				if (validate(homePageNotice, 0)) {
					homePageNotice.click();
					CommonUtility.checkPageIsReady(driver);
				} else if (validate(homePageNotice2, 0)) {
					homePageNotice2.click();
					CommonUtility.checkPageIsReady(driver);
				} else if (validate(homePageNotice3, 0)) {
					homePageNotice3.click();
					CommonUtility.checkPageIsReady(driver);
				}
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Catch block");
			}
		} else {
			System.out.println("COVID 19 Banner page did not appear");
		}
		System.out.println("Now trying to locate Hello Name element on Dashboard home page");
		try {
			
			CommonUtility.waitForPageLoad(driver, helloPerson, 20);
			System.out.println("Hello Name element was displayed : " + helloPerson.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Hello Name element was not displayed after wait, failing the test case");
			Assert.fail();
			}
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println("Checking if title of dashboard page contains Home | UnitedHealthcare ");
		Assert.assertTrue(title.contains("Home | UnitedHealthcare"));
		System.out.println("Assert condition on title of dashboard page that it contains Home | UnitedHealthcare in it was passed");
		System.out.println("@@@ The URL of the page is ==>" + driver.getCurrentUrl());
			}
	
	

	public AccountHomePage navigateToAutoPaymentHistoryPage() {

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		// Thread.sleep(16000);

		try {
			navigateToPaymentHistoryPage();
		} catch (Exception e1) {
			System.out.println("Unable to navigate to premium payment page");
		}
		// tbd waitforElement(PremiumPayment);
		// tbd System.out.println("payment link is displayed on the header");
		// tbd PremiumPayment.click();
		// tbd try {
		// tbd Thread.sleep(10000);
		// tbd } catch (InterruptedException e) {
		// tbd e.printStackTrace();
		// tbd }
		if (PaymentHeading.getText().contains("Premium Payments Overview")) {
			System.out.println("Payment Overview page displayed");
			return new AccountHomePage(driver);
		} else {
			System.out.println("payment overview page not displayed");
			return null;
		}
	}

	public PaymentHistoryPage navigateTooPaymentHistoryPage() {

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		// Thread.sleep(16000);

		try {
			navigateToPaymentHistoryPage();
		} catch (Exception e1) {
			System.out.println("Unable to navigate to premium payment page");
		}
		if (PaymentHeading.getText().contains("Premium Payments Overview")) {
			System.out.println("Payment Overview page displayed");
			return new PaymentHistoryPage(driver);
		} else {
			System.out.println("payment overview page not displayed");
			return null;
		}
	}

	public AccountHomePage navigateToSHIPAutoPaymentHistoryPage() {

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.elementToBeClickable(paymentslink));
		 */
		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		// tbd Thread.sleep(16000);

		waitforElement(ShipPremiumPayment);
		System.out.println("payment link is displayed on the header");
		ShipPremiumPayment.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (PaymentHeading.getText().contains("Premium Payments Overview")) {
			System.out.println("Payment Overview page displayed");
			return new AccountHomePage(driver);
		} else {
			System.out.println("payment overview page not displayed");
			return null;
		}
	}

	public AccountHomePage navigateToSHIPTab() {

		TestHarness.checkForIPerceptionModel(driver);

		waitforElement(ShipTab);
		System.out.println("Ship tab loaded");
		ShipTab.click();
		CommonUtility.checkPageIsReadyNew(driver);
		
		if (PayDate.getText().contains("Paid through Date")) {
			System.out.println("ShipTab with amount displayed");
			return new AccountHomePage(driver);
		} else {
			System.out.println("Ship tab issue");
			return null;
		}
	}

	public PaymentHistoryPage navigateToOneTimePaymentHistoryPage() {

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		waitforElement(PremiumPayment);
		System.out.println("payment link is displayed on the header");
		PremiumPayment.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (PaymentHeading.getText().contains("Premium Payments Overview")) {
			System.out.println("Payment Overview page displayed");
			return new PaymentHistoryPage(driver);
		} else {
			System.out.println("payment overview page not displayed");
			return null;
		}
	}

	public pages.regression.payments.PaymentHistoryPage validtaePaymentHistorySection() throws InterruptedException {

		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,550)", "");

		waitforElement(PaymentHistorySection);

		// tbd Select dateRange = new Select(HistoryDropdown);
		// tbd dateRange.selectByVisibleText("Last 6 months");

		// note: need to mouse over to select
		System.out.println("Payment History Exists");
		jse.executeScript("window.scrollBy(0,-1100)", "");

		return new pages.regression.payments.PaymentHistoryPage(driver);
	}

	public ContactUsPage navigateToContactUsPageTemporarySolution() {

		driver.navigate().to("https://stage-medicare.uhc.com/medicare/member/contact-us/overview.html#/contact-us-two");
		CommonUtility.waitForPageLoad(driver, headingContactUs, 10);
		if (driver.getTitle().contains("contact-us")) {
			return new ContactUsPage(driver);
		}
		return null;
	}

	public ContactUsPage navigateToContactUsPage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			feebackpopupClose();
			if (MRScenario.environmentMedicare.equals("team-ci1") || MRScenario.environmentMedicare.equals("team-h")
					|| MRScenario.environmentMedicare.equals("test-a")
					|| MRScenario.environmentMedicare.equals("team-e")) {
				js.executeScript("arguments[0].click();", helpAndContactUslink);

			} else if ("YES".equalsIgnoreCase(MRScenario.isTestHarness) && !(MRScenario.environment.equalsIgnoreCase("PROD")|| 
					MRScenario.environment.equalsIgnoreCase("offline"))) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,-500)", "");
				validateNew(contactUsPageLink);
				contactUsPageLink.click();
				CommonUtility.checkPageIsReadyNew(driver);
				CommonUtility.waitForPageLoadNew(driver, headingContactUs, CommonConstants.TIMEOUT_60);
				Thread.sleep(3000L);
			} else {
				if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
					workaroundAttempt("contactus");
				} else {
					if (validate(linkContactUs)) {
						linkContactUs.click();
					} else {
						System.out.println(
								"Unable to locate Contact Us on dashboard, will attempt to see if it's in shadow-root");
						locateAndClickElementWithinShadowRoot(shadowRootFooter,
								"div > span > footer > div:nth-child(2) > div:nth-child(2) > ul > li:nth-child(1) > a",
								true);
					}
				}
			}
			CommonUtility.waitForPageLoad(driver, headingContactUs, 10);
			if (driver.getTitle().contains("Contact Us")) {
				return new ContactUsPage(driver);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement expandRootElement1(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
				element);
		return ele;
	}

	public ContactUsPage navigateToContactUsPage2() throws InterruptedException {

		WebElement premiumpaymentLink = driver
				.findElement(By.cssSelector("#main-nav > div > div > div > a:nth-child(5)"));
		WebElement shadowRootpaymentLink = expandRootElement(premiumpaymentLink);
		shadowRootpaymentLink.click();
		Thread.sleep(5000);
		if (driver.findElement(By.xpath("//*[@id='needhelpsectioncontactus']/section/div/div[1]/div/h2"))
				.isDisplayed()) {
			driver.findElement(
					By.xpath("/html/body/div[2]/div/footer/div/div/div[2]/div/div[1]/div[1]/div/div[1]/div/ul/li[1]/a"))
			.click();
		}

		CommonUtility.waitForPageLoad(driver, headingContactUs, 10);
		if (driver.getTitle().contains("Contact Us")) {
			return new ContactUsPage(driver);
		}

		return null;
	}

	public pages.dashboard_deprecated.member.ulayer.PaymentHistoryPage changeUrlToNewPaymentHistoryPage() {

		String NewPayHistoryUrl = "content/dashboard/home/Payments.html";

		String url = driver.getCurrentUrl();
		url = url.replace("home/my-account-home.html", NewPayHistoryUrl);

		driver.get(url);
		// System.out.println("testing2");
		if (paymentsHeading.getText().contains("Premium Payments Overview")) {

			return new pages.dashboard_deprecated.member.ulayer.PaymentHistoryPage(driver);

		}

		return null;
	}

	public PlanComparePage navigateToPlanCompare() {
		// Compare 2017 Plans
		planCompareLink.click();

		CommonUtility.waitForPageLoad(driver, planCompareHeader, 20);

		if (getTitle().equalsIgnoreCase("Compare 2017 Plans")) {
			return new PlanComparePage(driver);

		}
		return null;
	}

	public Rallytool_Page navigateToRallyPage() {
		driver.manage().window().maximize();
		try {
			searchForProviders.click();
			// switch to Rally Page
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			if (driver.getTitle().equalsIgnoreCase("Find Care")) {
				return new Rallytool_Page(driver);
			} else {
				Assert.fail();
			}
		} catch (Exception e) {

			Assert.fail("Link is not Present");
		}

		return null;
	}

	public OneTimePaymentsPage navigateToOneTimePaymentsPage() throws InterruptedException {
		driver.navigate().to("https://member." + MRScenario.environment
				+ "-aarpmedicareplans.uhc.com/content/dashboard/home/one-time-payments.html");
		System.out.println("title  " + driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase("one-time-payment")) {
			return new OneTimePaymentsPage(driver);
		}
		return null;
	}

	public Boolean tempIdValidation() {
		validate(viewIDCard);
		viewIDCard.click();
		if (validate(validateLogo)) {
			return true;
		}
		return false;

	}

	public TestHarness navigateToTestHarnesspage() {
		driver.navigate()
		.to("https://member." + MRScenario.environment + "-aarpmedicareplans.uhc.com/home/testharness.html");
		System.out.println("title  " + driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase("testharness")) {
			return new TestHarness(driver);
		}
		return null;
	}

	public void validateDrugsPreferredMailOderLink() {

		if (validate(drugPreferredMailServicePharmacyLink)) {
			System.out.println("Drug Preferred Mail Service Link is displaying in footer");
		} else {
			System.out.println("Drug Preferred Mail Service Link is not displaying in footer");
		}
	}

	public void validateImagePresent(String logoToBeDisplayedOnDashboard) throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, helloPerson, 20);
	    //locateElementWithinShadowRoot(shadowRootHeader, "div > span > div > header > div.container.utility-nav-container > a > img");
		
			if (validate(shadowRootHeader)) {
				System.out.println("located shadow-root element, attempt to process further...");
				WebElement root1 = expandRootElement(shadowRootHeader);
				try {
					// Going inside shadow root to get element, in this case the
					// logo is in the shadow root header
					WebElement logo = root1.findElement(By
							.cssSelector("div > span > div > header > div.container.utility-nav-container > a > img"));
					Assert.assertTrue("Dashboard header is not displayed", validate(logo));
                    String logo_alt = logo.getAttribute("alt");
                    System.out.println("Actual logo's alt text on Dashboard page is   " + logo_alt);
					System.out.println("Logo to be verified on dashboard is  : " + logoToBeDisplayedOnDashboard);
					if (logoToBeDisplayedOnDashboard.equalsIgnoreCase("AARP"))
					{
						System.out.println("Expected logo's alt text on Dashboard page for AARP is - AARP: Medicare Plans from UnitedHealthcare ");
						Assert.assertTrue(logo_alt.contains("AARP: Medicare Plans from UnitedHealthcare"));
						System.out.println("Dashboard page Primary logo alt text condition is passed");
					}
					
					else if (logoToBeDisplayedOnDashboard.equalsIgnoreCase("MEDICA"))
					
					{
						System.out.println("Expected logo's alt text on Dashboard page for Medica is - Medica Healthcare ");
						Assert.assertTrue(logo_alt.contains("Medica Healthcare"));
						System.out.println("Dashboard page Primary logo alt text condition is passed");
					}
					
					else if (logoToBeDisplayedOnDashboard.equalsIgnoreCase("PCP"))
						
					{
						System.out.println("Expected logo's alt text on Dashboard page for PCP is - Preferred Care Partners ");
						Assert.assertTrue(logo_alt.contains("Preferred Care Partners"));
						System.out.println("Dashboard page Primary logo alt text condition is passed");
					}
					
					else if (logoToBeDisplayedOnDashboard.equalsIgnoreCase("UHC"))
						
					{
						System.out.println("Expected logo's alt text on Dashboard page for UHC is - UnitedHealthcare");
						Assert.assertTrue(logo_alt.contains("UnitedHealthcare"));
						System.out.println("Dashboard page Primary logo alt text condition is passed");
					}
					
                    else if (logoToBeDisplayedOnDashboard.equalsIgnoreCase("TEXASERS"))
						
					{
						System.out.println("Expected logo's alt text on Dashboard page for TEXASERS is - Health Select Medicare RX of Texas ");
						Assert.assertTrue(logo_alt.contains("Health Select Medicare RX of Texas"));
						System.out.println("Dashboard page Primary logo alt text condition is passed");
					}
					
					else
					{
						Assert.fail("Dashboard page Primary logo alt text condition is failed");
					}
					
					System.out.println("naturalWidth of logo is "+logo.getAttribute("naturalWidth"));
					 
                    System.out.println("Now checking that image naturalWidth is not zero , which identifies that image is actually displayed on page");
			        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logo);
			        if (!ImagePresent)
			        {
			         System.out.println("naturalWidth of logo is "+logo.getAttribute("naturalWidth"));
			         System.out.println("naturalWidth is not greater than zero , logo image was not displayed.");
			         Assert.fail("naturalWidth is not greater than zero , logo image was not displayed.");
			        }
			        else
			        {
			        	System.out.println("naturalWidth of logo is "+logo.getAttribute("naturalWidth"));
			            System.out.println("naturalWidth is not zero , Logo image was displayed.");
			         }

				    } 
				catch (Exception e) {
					System.out.println("can't locate Dashboard logo element. Exception e=" + e);
					Assert.assertTrue("Dashboard header not functioning as expected", false);
				}
			} else {
				System.out.println("no shadow-root element , not sure what's going on w/ the header on rally");
				Assert.assertTrue("Dashboard header is not displayed", false);
			}

		}
	
	public void validateCoLogoImagePresent(String cologoToBeDisplayedOnDashboard) throws InterruptedException {
		if (validate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				// Going inside shadow root to get element, in this case the
				// logo is in the shadow root header
				WebElement cologo = root1.findElement(By
						.cssSelector("div > span > div > header > div.container.utility-nav-container > a > img.secondary-logo"));
				String cologo_alt = cologo.getAttribute("alt");
                System.out.println("Actual cologo's alt text on Dashboard page is   " + cologo_alt);
				System.out.println("CoLogo to be verified on dashboard is  : " + cologoToBeDisplayedOnDashboard);
				if (cologoToBeDisplayedOnDashboard.equalsIgnoreCase("Villages"))
				{
					System.out.println("Expected cologo's alt text on Dashboard page for Villages is - M&R - The Villages");
					Assert.assertTrue(cologo_alt.contains("M&R - The Villages"));
					System.out.println("Dashboard page cologo alt text condition is passed");
				}
				
				else if (cologoToBeDisplayedOnDashboard.equalsIgnoreCase("SHBP"))
				
				{
					System.out.println("Expected cologo's alt text on Dashboard page for SHBP is - M&R - GA DCH");
					Assert.assertTrue(cologo_alt.contains("M&R - GA DCH"));
					System.out.println("Dashboard page cologo alt text condition is passed");
				}
				/*NCSHP cologo is not appearing on Dashboard in Offline PROD environment */
				else if (cologoToBeDisplayedOnDashboard.equalsIgnoreCase("NCSHP"))
					
				{
					System.out.println("Expected cologo's alt text on Dashboard page for NCSHP is - M&R - NCSHP ");
					Assert.assertTrue(cologo_alt.contains("M&R - NCSHP"));
					System.out.println("Dashboard page cologo alt text condition is passed");
				}
				/*MCHCP cologo is not appearing on Dashboard in Offline PROD environment */
             else if (cologoToBeDisplayedOnDashboard.equalsIgnoreCase("MCHCP"))
					
				{
					System.out.println("Expected cologo's alt text on Dashboard page for MCHCP is - M&R - State of Missouri (MCHCP) ");
					Assert.assertTrue(cologo_alt.contains("M&R - State of Missouri (MCHCP)"));
					System.out.println("Dashboard page cologo alt text condition is passed");
				}
				
				/*UniversityOfKentucky cologo is not appearing on Dashboard in Offline PROD environment */
                else if (cologoToBeDisplayedOnDashboard.equalsIgnoreCase("UniversityOfKentucky"))
					
				{
					System.out.println("Expected cologo's alt text on Dashboard page for UniversityOfKentucky is - M&R - University of Kentucky");
					Assert.assertTrue(cologo_alt.contains("M&R - University of Kentucky"));
					System.out.println("Dashboard page cologo alt text condition is passed");
				}
								
				else if (cologoToBeDisplayedOnDashboard.equalsIgnoreCase("UHC"))
					
				{
					System.out.println("Expected logo's alt text on Dashboard page for UHC is - UnitedHealthcare");
					Assert.assertTrue(cologo_alt.contains("UnitedHealthcare"));
					System.out.println("Dashboard page Primary logo alt text condition is passed");
				}
				
                else if (cologoToBeDisplayedOnDashboard.equalsIgnoreCase("TEXASERS"))
					
				{
					System.out.println("Expected logo's alt text on Dashboard page for TEXASERS is - Health Select Medicare RX of Texas ");
					Assert.assertTrue(cologo_alt.contains("Health Select Medicare RX of Texas"));
					System.out.println("Dashboard page Primary logo alt text condition is passed");
				}
				
				else
				{
					Assert.fail("Dashboard page cologo alt text condition is failed");
				}
				
				System.out.println("naturalWidth of cologo is "+cologo.getAttribute("naturalWidth"));
				 
                System.out.println("Now checking that image naturalWidth is not zero , which identifies that image is actually displayed on page");
		        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", cologo);
		        if (!ImagePresent)
		        {
		        	
		         System.out.println("naturalWidth of cologo is "+cologo.getAttribute("naturalWidth"));
		         System.out.println("naturalWidth is not greater than zero , cologo image was not displayed.");
		         Assert.fail("naturalWidth is not greater than zero , cologo image was not displayed.");
		        }
		        else
		        {
		        	System.out.println("naturalWidth of cologo is "+cologo.getAttribute("naturalWidth"));
		            System.out.println("naturalWidth is not zero , coLogo image was displayed.");
		         }

			    } 
			catch (Exception e) {
				System.out.println("can't locate cologo element,  doing furthur validation");
				if ((cologoToBeDisplayedOnDashboard.equalsIgnoreCase("NCSHP") || cologoToBeDisplayedOnDashboard.equalsIgnoreCase("MCHCP") || cologoToBeDisplayedOnDashboard.equalsIgnoreCase("UniversityOfKentucky"))  && MRScenario.environment.contains("offline"))
				{
					System.out.println("Skipping the validation of secondary logo on Dashboard for Offline PROD enviroment as Rally UAT envionment does not showing cologo");	
				}
				else
				{
					Assert.fail("can't locate cologo element and environment was not offline PROD, cologo should be visible");
				}
			}
		} else {
			System.out.println("no shadow-root element , not sure what's going on w/ the header on rally");
			Assert.assertTrue("Dashboard header is not displayed", false);
		}
	}

	public ClaimsSummaryPage navigateToClaimsSummaryPage() {
		if (MRScenario.environment.equalsIgnoreCase("team-h")
				|| MRScenario.environment.equalsIgnoreCase("test-a")
				|| MRScenario.environment.contains("team-a")
				|| (MRScenario.environment.equalsIgnoreCase("team-t")
						|| MRScenario.environment.equalsIgnoreCase("team-ci1"))) {
			System.out.println("Go to claims link is present "
					+ driver.findElement(By.xpath("//a[text()='Go to Claims page']")).isDisplayed());
			driver.findElement(By.xpath("//a[text()='Go to Claims page']")).click();
			checkForIPerceptionModel(driver);
			return new ClaimsSummaryPage(driver);
		} else if (MRScenario.environment.equalsIgnoreCase("stage")
				|| MRScenario.environment.equalsIgnoreCase("offline")) {
			System.out.println("user is on '" + MRScenario.environment + "' login page");
			if (driver.getCurrentUrl().contains("/dashboard")) {
				System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
				if (MRScenario.isTestHarness != null && MRScenario.isTestHarness.equals("YES")) {
					claimsTestharnessLink.click();
				} else {
					if (validate(claimsDashboardLink)) {
						claimsDashboardLink.click();
					} else {
						System.out.println("Check for shadow-root before giving up");
						String secondTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(2)";
						String thirdTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(3)";
						WebElement tmp = locateElementWithinShadowRoot(shadowRootHeader,
								secondTopMenuItemCssStr);
						if (tmp.getText().equalsIgnoreCase("Claims")) {
							locateAndClickElementWithinShadowRoot(shadowRootHeader, secondTopMenuItemCssStr);
						} else {
							locateAndClickElementWithinShadowRoot(shadowRootHeader,	thirdTopMenuItemCssStr);
						}
					}
				}
				CommonUtility.checkPageIsReadyNew(driver);
				checkForIPerceptionModel(driver);
			} else if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
				workaroundAttempt("claims");
			}
			checkForIPerceptionModel(driver);
			return new ClaimsSummaryPage(driver);
		} else {
			System.out.println(
					"This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");
		}
		System.out.println(driver.getTitle());
		return null;
	}

	public ClaimDetailsPage navigateToClaimDetailsPage() {
		try {
			CommonUtility.waitForPageLoad(driver, claimstablemoreinfolink, 10);
			Assert.assertTrue("PROBLEM - unable to locate the 'More info' link on page", validate(claimstablemoreinfolink));
			System.out.println("more info link is seen for  ===>" + claimstablemoreinfolink.isDisplayed());
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", claimstablemoreinfolink);
			checkForIPerceptionModel(driver);
			System.out.println(driver.getTitle());
			if (driver.getTitle().equalsIgnoreCase("Claims Summary")) {
				System.out.println("*** Claims Details Page ***");
			}
		} catch (Exception ex) {
			return null;
		}
		return new ClaimDetailsPage(driver);
	}

	@FindBy(className = "loading-block")
	private WebElement loadingImage;

	public PharmacySearchPage navigateToRedesignPharmacyLocaterPage() {
		checkForIPerceptionModel(driver);
		if (MRScenario.environment.equalsIgnoreCase("test-a")
				|| MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			waitForHomePage(helloPerson);
			System.out.println("Go to Pharmacy locator is present " + pharmacySearchLink.isDisplayed());
			pharmacySearchLink.click();
		} else if (MRScenario.environment.contains("team-a")) {
			String Page_URL = "https://www." + MRScenario.environment + "-medicare." + MRScenario.domain
					+ "/content/medicare/member/pharmacy-locator/overview.html";
			if (driver.getCurrentUrl().contains("mymedicareaccount")) {
				System.out.println("This is a case for PCP or MEDICA user, use special URL");
				Page_URL = "https://www." + MRScenario.environment + "-mymedicareaccount." + MRScenario.domain
						+ "/content/medicare/member/pharmacy-locator/overview.html";
			}
			System.out.println("URL for testing: " + Page_URL);
			driver.navigate().to(Page_URL);
		} else if (MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.contains("prod")) {
			if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
				workaroundAttempt("pharmacylocator");
			} else {
				waitForHomePage(helloPerson);
				if (driver.getCurrentUrl().contains("/dashboard")) {
					System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
					CommonUtility.waitForPageLoad(driver, pharmacySearchLink, 5);
					if (noWaitValidate(pharmacySearchLink))
						pharmacySearchLink.click();
					else if (noWaitValidate(section_pharmacySearchLink)) {
						scrollElementToCenterScreen(section_pharmacySearchLink);
						moveMouseToElement(section_pharmacySearchLink);
						section_pharmacySearchLink.click();
					}
					else if(noWaitValidate(pharamciesAndPrescriptionsLink)){
						pharamciesAndPrescriptionsLink.click();
						CommonUtility.waitForPageLoad(driver, findAPharmacyLink, 5);
					    findAPharmacyLink.click();
					}
					else 
						Assert.assertTrue("PROBLEM - unable to locate pharmacy locator link on Rally Dashboard page", false);
					System.out.println("Clicked pharmacy Search Link...");
					CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
				}
			}
		}
		return new PharmacySearchPage(driver);
	}

	/**
	 * @return the pharmacySearchLink
	 */
	public boolean checkPharmacyLinkNotAvailable() {
		try {
			if (pharmacySearchLink.isDisplayed()) {
				System.out.println("Pharmacy link is present");
				return false;
			} else {

			}
		} catch (Exception e) {
			System.out.println("Pharmacy link is not present");
			return true;
		}
		return false;
	}

	// to navigate to forms and resources page
	@SuppressWarnings("unused")
	public FormsAndResourcesPage navigatetoFormsnResources(String memberType, String planType)
			throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		if (validate(iPerceptionAutoPopUp)) {
			iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}

		if (MRScenario.isTestHarness.equals("YES")) {
			System.out.println("user is on TestHarness login page");

			CommonUtility.waitForPageLoad(driver, FormRsrceLinkTestHarness, 30);
			FormRsrceLinkTestHarness.click();

		} else if (MRScenario.environmentMedicare.contains("team-a")
				|| MRScenario.environmentMedicare.equalsIgnoreCase("test-a")
				|| MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			System.out.println("Go to claims link is present "
					+ driver.findElement(By.xpath("//a[text()='Go to Pharmacy Locator page']")).isDisplayed());
			driver.findElement(By.xpath("//a[text()='Go to Pharmacy Locator page']")).click();
		}

		else if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
			System.out.println("user is on Stage login page");
			// Thread.sleep(1000);
			if ((driver.getCurrentUrl().contains("/aarp/dashboard")) && ((!memberType.toLowerCase().contains("pcp")
					&& !memberType.toLowerCase().contains("medica"))
					&& (!planType.toLowerCase().contains("pcp") && !planType.toLowerCase().contains("medica")))) {
				System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
				// Thread.sleep(2000);
				driver.navigate().to(PAGE_URL + "aarp/member/documents/overview.html");
				// https: //
				// stage-mymedicareaccount.uhc.com/pcp/member/documents/overview.html
				System.out.println(driver.getCurrentUrl());
				try {

					wait.until(ExpectedConditions.titleContains("Documents"));

				} catch (Exception e) {
				}
				// CommonUtility.waitForPageLoad(driver, forms.getHome(), 20);
				if (driver.getTitle().contains("Documents & Resources")) {
					System.out.println(driver.getTitle());
				}

				System.out.println(driver.getTitle());

			} /*
			 * else if (driver.getCurrentUrl().contains("/pcp/dashboard"))
			 * 
			 * {
			 */
			else if ((driver.getCurrentUrl().contains("mymedicareaccount"))
					&& (memberType.toLowerCase().contains("pcp") || planType.toLowerCase().contains("pcp")))

			{

				System.out.println("User is on pcp dashboard page and URL is ====>" + driver.getCurrentUrl());
				// Thread.sleep(2000);
				driver.navigate().to("https://stage-mymedicareaccount.uhc.com/pcp/member/documents/overview.html");

				System.out.println(driver.getCurrentUrl());
				try {

					wait.until(ExpectedConditions.titleContains("Documents"));

				} catch (Exception e) {
				}
				// CommonUtility.waitForPageLoad(driver, PlanMaterialSection,
				// 20);
				if (driver.getTitle().contains("Documents & Resources")) {
					System.out.println(driver.getTitle());
				}
			}

			else if (driver.getCurrentUrl().contains("/retiree/dashboard"))

			{
				System.out.println("User is on  dashboard page and URL is ====>" + driver.getCurrentUrl());
				// Thread.sleep(2000);
				driver.navigate().to(PAGE_URL + "retiree/member/documents/overview.html");

				System.out.println(driver.getCurrentUrl());
				try {

					wait.until(ExpectedConditions.titleContains("Documents"));

				} catch (Exception e) {
				}
				// CommonUtility.waitForPageLoad(driver, PlanMaterialSection,
				// 20);
				if (driver.getTitle().contains("Documents & Resources")) {
					System.out.println(driver.getTitle());
				}

			}

			else if (driver.getCurrentUrl().contains("/medicare/dashboard"))

			{
				System.out.println("User is on  dashboard page and URL is ====>" + driver.getCurrentUrl());
				// Thread.sleep(2000);
				driver.navigate().to(PAGE_URL + "medicare/member/documents/overview.html");

				System.out.println(driver.getCurrentUrl());
				try {

					wait.until(ExpectedConditions.titleContains("Documents"));

				} catch (Exception e) {
				}
				// CommonUtility.waitForPageLoad(driver, PlanMaterialSection,
				// 20);
				if (driver.getTitle().contains("Documents & Resources")) {
					System.out.println(driver.getTitle());
				}

			}

			/*
			 * else if (driver.getCurrentUrl().contains("/medica/dashboard"))
			 * 
			 * {
			 */
			else if ((driver.getCurrentUrl().contains("mymedicareaccount"))
					&& (memberType.toLowerCase().contains("medica") || planType.toLowerCase().contains("medica")))

			{

				System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
				// Thread.sleep(2000);
				driver.navigate().to("https://stage-mymedicareaccount.uhc.com/medica/member/documents/overview.html");
				System.out.println(driver.getCurrentUrl());
				try {

					wait.until(ExpectedConditions.titleContains("Documents"));

				} catch (Exception e) {
				}
				// CommonUtility.waitForPageLoad(driver, PlanMaterialSection,
				// 20);
				if (driver.getTitle().contains("Documents & Resources")) {
					System.out.println(driver.getTitle());
				}
			}
		} else {
			if (driver.getCurrentUrl().contains("mymedicareaccount"))
				driver.navigate().to("https://" + MRScenario.environmentMedicare
						+ "-mymedicareaccount.uhc.com/content/medicare/member/documents/overview.html");
			else {
				driver.navigate().to("https://" + MRScenario.environmentMedicare
						+ "-medicare.ose-elr-core.optum.com/content/medicare/member/documents/overview.html");
			}

		}
		return new FormsAndResourcesPage(driver);
	}

	public FormsAndResourcesPage navigatetoFormsnResourcesfrommemauth() throws InterruptedException {
		Thread.sleep(10000);
		if (driver.getCurrentUrl().contains("int.uhc.com")) {
			System.out.println(
					"User is on dashboard page from member auth tool and URL is ====>" + driver.getCurrentUrl());
			Thread.sleep(2000);
			driver.navigate().to(PAGE_URL + "aarp/member/documents/overview.html");
			System.out.println(driver.getCurrentUrl());
			CommonUtility.waitForPageLoad(driver, PlanMaterialSection, 20);
			if (driver.getTitle().equalsIgnoreCase("Documents Overview")) {
				System.out.println(driver.getTitle());
			}
		}

		return new FormsAndResourcesPage(driver);

	}

	public PaymentHistoryPage navigateToPaymentHistoryPage() throws InterruptedException {

        CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("testharness")) {
			System.out.println("TestHarness Page is displayed, clicking the Premium Payments Link");
			TestHarness.checkForIPerceptionModel(driver);
			TestHarnesspaymentsLink.click();
			TestHarness.checkForIPerceptionModel(driver);
			return new PaymentHistoryPage(driver);
		}	
		else {		
			System.out.println("Page was not testharness, trying shadow root element to access Payments page from Dashboard");
			/*	System.out.println("Navigating to B&C Page First");
				navigateDirectToBnCPag();
				TestHarness.checkForIPerceptionModel(driver);
				System.out.println("Navigating to Premium Payment page now");
				try {
					paymentsLink3.click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Could not navidate to Premium Payment page");
				}*/
				if (validate(shadowRootHeader)) {
					System.out.println("located shadow-root element, attempt to process further...");
					WebElement root1 = expandRootElement(shadowRootHeader);
					try {
						// Going inside shadow root to get element, in this case the
						// logo is in the shadow root header
						WebElement PremiumPaymentsTab = root1.findElement(By
								.cssSelector("#sticky-main-nav > div > div > div > a:nth-child(5)"));
						
						System.out.println("shadow-root element has been located, now clicking on Premium Payments tab");	
						TestHarness.checkForIPerceptionModel(driver);
						PremiumPaymentsTab.click();
						System.out.println("Premium PaymentsTabtab has been clicked");	
					
				}
					catch(Exception e)
					{
						System.out.println("Could not locate shadow root element for payments tab");
						Assert.fail("Could not locate shadow root element for payments tab");
					}
				}
					else
					{
						validateNew(premiumPayments);
						premiumPayments.click();
					}
					
			    CommonUtility.checkPageIsReadyNew(driver);
				System.out.println("Current URL is : "+driver.getCurrentUrl());
				if (driver.getCurrentUrl().contains("payments"))
				{
					System.out.println("Current URL contains payments text in it, returning PaymentHistoryPage");	
				return new PaymentHistoryPage(driver);
			     } 
				else
				{
					Assert.fail("Current URL doesn't contains payments text in it, payments page didn't appear , failed");
				}
				CommonUtility.checkPageIsReadyNew(driver);
				TestHarness.checkForIPerceptionModel(driver);
				return new PaymentHistoryPage(driver);
			}
		}

	public PaymentHistoryPage navigateToPaymentPage() throws InterruptedException {
		try {
			System.out.println("iPerception Pop Up is Present");
			driver.switchTo().frame("IPerceptionsEmbed");
			iPerceptionCloseButton.click();
			// driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}
		CommonUtility.checkPageIsReady(driver);

		if (noWaitValidate(paymentsLink)) {
			System.out.println("payment link is displayed on the header");
			paymentsLink.click();
			return new PaymentHistoryPage(driver);
		} else if (validate(TestHarnesspaymentsLink)) {

			System.out.println("TestHarness Page Payments Link is displayed");
			TestHarnesspaymentsLink.click();
			return new PaymentHistoryPage(driver);
		} else {
			return null;
		}
	}
	
	public PaymentHistoryPage navigateToPaymentPageSkipBtnValidation() throws InterruptedException {
		try {
			System.out.println("iPerception Pop Up is Present");
			driver.switchTo().frame("IPerceptionsEmbed");
			iPerceptionCloseButton.click();
			// driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}
		CommonUtility.checkPageIsReady(driver);

		if (noWaitValidate(paymentsLink)) {
			System.out.println("payment link is displayed on the header");
			paymentsLink.click();
			return new PaymentHistoryPage(driver, true);
		} else if (validate(TestHarnesspaymentsLink)) {

			System.out.println("TestHarness Page Payments Link is displayed");
			TestHarnesspaymentsLink.click();
			return new PaymentHistoryPage(driver,true);
		} else {
			return null;
		}
	}
	
	/**
	 * Added by Sneha - To Navigate to Order plan Materials page by clicking on
	 * link on Rally Dashboard mid section
	 */
	public OrderMaterialsPage navigateToOrderPlanMaterialsPage() throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, OrderMaterial_Dashboard, 10);
		if (validate(OrderMaterial_Dashboard)) {
			System.out.println("Order Materials link found on dashboard");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", OrderMaterial_Dashboard);
		} else {
			if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
				workaroundAttempt("order");
			} else {
				String Page_URL = "";
				if (MRScenario.environment.contains("team-a")) {
					Page_URL = "https://www." + MRScenario.environment + "-medicare." + MRScenario.domain
							+ "/content/medicare/member/order-materials/overview.html";
				} else {
					Page_URL = "https://" + MRScenario.environment + "-medicare." + MRScenario.domain
							+ "//member/order-plan-materials.html";
				}
				driver.navigate().to(Page_URL);
				System.out.println("Navigated to Order materials Page URL : " + Page_URL);
			}
		}
		/*
		 * tbd try { Thread.sleep(3000); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		CommonUtility.checkPageIsReady(driver);
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoadNew(driver, orderplanHeadertxt, 30);
		if (validate(orderplanHeadertxt)) {
			return new OrderMaterialsPage(driver);
		}
		return null;
	}

	/**
	 * To Navigate to Order plan Materials page by clicking on top menu sub link
	 * under BnC on rally page
	 */
	public OrderMaterialsPage navigateToOrderPlanMaterialsPageFromTopMenu() throws InterruptedException {
		checkModelPopup(driver,5);
		if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement benefitsMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
				benefitsMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Coverage And Benefits link on Rally Dashboard top menu", false);
			}
		} 
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,5);
		Assert.assertTrue("PROBLEM - unable to locate Order Plan Materials sub link from top menu Coverage & Benefits option", noWaitValidate(desktopOrderPlanFromBenefitSubLink));
		desktopOrderPlanFromBenefitSubLink.click();
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,5);
		CommonUtility.waitForPageLoadNew(driver, orderplanHeadertxt, 30);
		if (validate(orderplanHeadertxt)) {
			return new OrderMaterialsPage(driver);
		}
		return null;
		/* tbd 
		CommonUtility.checkPageIsReady(driver);
		try {
			WebElement topMenuBnCLink = driver.findElement(By.xpath("//a[contains(text(),'Coverage & Benefits')]"));
			if (validate(topMenuBnCLink)) {
				topMenuBnCLink.click();
			} else {
				String linkName = locateElementWithinShadowRoot(shadowRootHeader,
						"#main-nav > div > div > div > a:nth-child(4)").getText();
				if (linkName.equalsIgnoreCase("COVERAGE & BENEFITS")) {
					locateAndClickElementWithinShadowRoot(shadowRootHeader,
							"#main-nav > div > div > div > a:nth-child(4)");
				} else {
					// note: user likely doesn't have Find Cost & Care so link
					// shifted
					locateAndClickElementWithinShadowRoot(shadowRootHeader,
							"#main-nav > div > div > div > a:nth-child(3)");
				}
			}
		} catch (Exception e) {
			String linkName = locateElementWithinShadowRoot(shadowRootHeader,
					"#main-nav > div > div > div > a:nth-child(4)").getText();
			if (linkName.equalsIgnoreCase("COVERAGE & BENEFITS")) {
				locateAndClickElementWithinShadowRoot(shadowRootHeader, "#main-nav > div > div > div > a:nth-child(4)");
			} else {
				// note: user likely doesn't have Find Cost & Care so link
				// shifted
				locateAndClickElementWithinShadowRoot(shadowRootHeader, "#main-nav > div > div > div > a:nth-child(3)");
			}
		}
		try {
			WebElement topMenuOrderPlanMaterialLink = driver.findElement(By.xpath("//a[@id='ordermaterials']"));
			Assert.assertTrue(
					"PROBLEM - unable to locate the order plan materials sub link from Coverage & Benefits link on top menu",
					validate(topMenuOrderPlanMaterialLink));
			topMenuOrderPlanMaterialLink.click();
		} catch (Exception e) {
			Assert.assertTrue(
					"PROBLEM - unable to locate the order plan materials sub link from Coverage & Benefits link on top menu",
					false);
		}
		CommonUtility.checkPageIsReady(driver);
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoadNew(driver, orderplanHeadertxt, 30);
		if (validate(orderplanHeadertxt)) {
			return new OrderMaterialsPage(driver);
		}
		return null;
		*/

	}
	
	public HealthAndWellnessPage navigateDirectToHwPag() {
		checkModelPopup(driver,5);
		if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement hwTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-health-wellness]"));
				hwTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Health & Wellness link on Rally Dashboard top menu", false);
			}		

		} 
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,5);
		return new HealthAndWellnessPage(driver);
	}

	public EOBPage navigateDirectToEOBPag() {
		if (MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			driver.findElement(By.xpath("//a[text()='Eob']")).click();
		} else if (MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.contains("prod")
				|| MRScenario.environment.contains("team-a") || MRScenario.environment.contains("offline")) {
			if (MRScenario.isTestHarness.equals("YES")) {
				Assert.assertTrue("PROBLEM - unable to locate the Explanation of Benefits link on testharness page table", validate(eobTestharnessLink,0));
				eobTestharnessLink.click();
			} else if (driver.getCurrentUrl().contains("/dashboard")) {
				checkModelPopup(driver,5);
				if (noWaitValidate(shadowRootHeader)) {
					System.out.println("located shadow-root element, attempt to process further...");
					WebElement root1 = expandRootElement(shadowRootHeader);
					try {
						WebElement claimsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-claims]"));
						//WebElement claimsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[href$='claims.html']"));
						claimsTopMenuShadowRootLink.click();
					} catch (Exception e) {
						Assert.assertTrue("PROBLEM - unable to locate Claims link on Rally Dashboard top menu", false);
					}		
					
					if (noWaitValidate(explainationOfBenefits)) 
						explainationOfBenefits.click();
					else if (noWaitValidate(eobTopMenuLink)) 
						eobTopMenuLink.click();
					else 
						Assert.assertTrue("PROBLEM - unable to locate Explanation of Benefits tab in Claims' sub menu with expected WebElements", false);
				} else {
					System.out.println("no shadow-root element, attempt to use the link in the rally dashboard page body");
					Assert.assertTrue("PROBLEM - unable to locate the Explanation of Benefits link on the Rally Dashboard page body", noWaitValidate(EOB_Dashboard));
					EOB_Dashboard.click();
				}
				CommonUtility.checkPageIsReady(driver);
				checkModelPopup(driver,5);
			}
		} else {
			System.out.println(
					"This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");
		}

		return new EOBPage(driver);
	}
	
	public DreamEOBPage navigateDirectToDreamEOBPag() {
		if (MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			driver.findElement(By.xpath("//a[text()='Eob']")).click();

		} else if (MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.contains("prod")) {

			if (MRScenario.isTestHarness.equals("YES")) {
				//				startNew("https://stage-medicare.uhc.com/member/eob.html");
				eobTestharnessLink.click();
			} else if (driver.getCurrentUrl().contains("/dashboard")) {
				try {
					if (iPerceptionPopUp.isDisplayed()) {
						iPerceptionPopUp.click();
					}
				} catch (Exception e) {
					System.out.println("iPerception Pop Up not displayed");
				}

				validateNew(EOB_Dashboard,0);
				EOB_Dashboard.click();
				// validate(medicalEobLink);
				/*
				 * if(medicalEobLink.isDisplayed()){ medicalEobLink.click();
				 * }else{
				 */
				// scrollToView(medicalEobLinkOther);
				// medicalEobLinkOther.click();
				// }

				//startNew("https://stage-medicare.uhc.com/member/eob.html");
			}
		} else {
			System.out.println(
					"This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");
		}

		return new DreamEOBPage(driver);
	}

	public void validateClaimsL2Tabs() {
		if (claims.isDisplayed()) {
			claims.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue("claimSummary is not displayed", claimSummary.isDisplayed());
			Assert.assertTrue("explainationOfBenefits is not displayed", explainationOfBenefits.isDisplayed());
		}
	}

	@SuppressWarnings("unused")
	public void validateFooterSection() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Assert.assertTrue("Footer section is not displayed", footerSection.isDisplayed());
	}

	public DrugCostEstimatorPage navigate_to_dce() {
		if (MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			driver.findElement(By.xpath("//a[text()='Go to Claims page']")).click();

		} else if (MRScenario.environment.equalsIgnoreCase("stage")) {

			if (MRScenario.isTestHarness.equalsIgnoreCase("YES")) {
				dceTestharnessLink.click();
			} else if (driver.getCurrentUrl().contains("/dashboard")) {
				if(validate(drugLookup)){
					System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
					waitforElement(drugLookup);
					drugLookup.click();
					
				} else {
					waitforElement(drugLookuplink);
					drugLookuplink.click();
				}
				
				try {
						WebElement loadingImage = driver.findElement(By.className("loading-dialog"));
						CommonUtility.waitForPageLoad(driver, loadingImage, 15);
					} catch (Exception e) {
						System.out.println("Exception e: " + e);
					}
				
				
			} else if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
				workaroundAttempt("dce");
			}
		} else if (driver.getCurrentUrl().contains("/dashboard")) {
			if(validate(drugLookup)){
				System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
				waitforElement(drugLookup);
				drugLookup.click();
				
			} else {
				waitforElement(drugLookuplink);
				drugLookuplink.click();
			}
			
			try {
					WebElement loadingImage = driver.findElement(By.className("loading-dialog"));
					CommonUtility.waitForPageLoad(driver, loadingImage, 15);
				} catch (Exception e) {
					System.out.println("Exception e: " + e);
				} 
		} else {
			System.out.println(
					"This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");
		}

		return new DrugCostEstimatorPage(driver);
	}

	public void dce_not_present() {
		if (validate(drugLookup)) {
			Assert.fail("Error: drug lookup tile should not be displayed");
		}
	}

	public void clickPremiumPayment() {
		waitforElement(premiumPayment);
		if (premiumPayment.isDisplayed()) {
			premiumPayment.click();
		}

	}

	/**
	 * validate the Premium payment Page
	 */
	public void validatePremiumPage() {
		Assert.assertTrue("Premium payment overivew is not displayed", paymentsOverview.isDisplayed());
	}

	/*
	 * validate that the Premium payment tab is not displayed on the header
	 */

	public boolean premiumPaymentsNotAvailable() {

		if (validate(premiumPayment) == false) {
			Assert.assertFalse("premium payment is not displayed", validate(premiumPayment));
			return true;

		} else {
			Assert.fail("premium payment is displayed");
			return false;
		}
	}

	/*
	 * validate that the Find care tab is not displayed on the header
	 */

	public boolean findCareNotAvailable() {

		if (validate(findCare) == false) {
			Assert.assertFalse("find care is not displayed", validate(findCare));
			return true;

		} else {
			Assert.fail("find care is displayed");
			return false;
		}
	}

	/**
	 * validate Find Care Cost Tab
	 */

	public void validateFindCareCostTab() {
		if (validate(findCareCost,0)) {
			Assert.assertTrue("Find Care and Cost tab is not displayed", validate(findCareCost,0));
		} else {
			System.out.println(
					"Unable to locate 'Find Care & Costs' from dashboard, check to see if it's in shadow-root");
			locateElementWithinShadowRoot(shadowRootHeader, "a[data-testid*=nav-link-find-care]");
		}

	}

	public void validateFindCarePage() {

		if (driver.getCurrentUrl().contains("/find-care"))
			;
		{
			System.out.println("User is on find care page and URL is ====>" + driver.getCurrentUrl());
		}

	}

	/**
	 * This method used to view ID Card
	 * 
	 * @return
	 */
	
	@FindBy(xpath = "//*[contains(@id,'home_2')]")
	private WebElement TestHarnessPageHomeBttnround;
	
	@FindBy(xpath = "//*[@id='dashboard']")
	private WebElement Dashboard;
	
	public IDCardPage viewIDCard() {

		if (driver.getCurrentUrl().contains("testharness.html")) {
			System.out.println("The page contains test harness");
			jsClickNew(TestHarnessPageHomeBttnround);
			System.out.println("Home button clicked");
			CommonUtility.waitForPageLoad(driver,Dashboard, 30);
			System.out.println("dashboard diplayed");
			validate(viewRecomend);
			viewRecomend.click();
			return new IDCardPage(driver);
		} else {

			validate(viewRecomend);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	viewRecomend.click();
			return new IDCardPage(driver);
		}
	}

	public boolean validateOrderMaterialsLink() {
		if (validate(OrderMaterial_Dashboard))
			return true;
		return false;
	}

	public boolean validateOrderMaterialsPageHeaderNavigation() {
		if (driver.getCurrentUrl().contains("/dashboard")) {
			System.out.println("User is on dashboard page and URL is ==>" + driver.getCurrentUrl());
			driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.getCurrentUrl());
			CommonUtility.waitForPageLoad(driver, heading, 30);
			if (driver.getTitle().contains("Benefits Overview")) {
				System.out.println(driver.getTitle());
				if (validate(OrderMaterialsTab_BnCPage)) {
					System.out.println("Order Plan Materials Tab displayed in B&C Page");
					return true;
				}
			}

		}
		return false;
	}

	public DrugCostEstimatorPage navigate_to_optumrxPage() {
		CommonUtility.waitForPageLoad(driver, drugLookup, 90);
		// waitforElement(drugLookup);
		drugLookup.click();

		String mainwindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(mainwindow)) {
				driver.switchTo().window(currentWindowHandle);
			}
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().equals("https://chp-stage.optumrx.com/public/sso-landing"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}

	/**
	 * Validate the Header of the page
	 */

	public void validateHeader() {
		Assert.assertTrue("Header is not displayed", validate(header,0));
		/**
		 * Wait till page is loaded button is enabled.
		 */

	}

	/**
	 * Validate claims Tab
	 */
	public void validateClaims() {
		Assert.assertTrue("Claims tab is not displayed", validate(claims,0));
	}

	/**
	 * Validate Feedback Model
	 */
	public void checkModelPopup() {
		try {
			FeedbackModal.click();
			System.out.println("FeedBack Modal Present");
			if (validate(FeedbackModal)) {
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			}
			System.out.println("FeedBack Modal Closed");
		} catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");

		}
	}

	/**
	 * Click on claims summary
	 */
	public void clickClaimsSummary() {
		if (claims.isDisplayed()) {
			claims.click();
			if (claimSummary.isDisplayed()) {
				claimSummary.click();
			}
		}
	}

	/**
	 * Click on claims followed by EOB
	 */
	public void clickeob() {
		waitforElement(claims);
		if (claims.isDisplayed()) {
			// claims.click();
			try {
				if (explainationOfBenefits.isDisplayed()) {
					explainationOfBenefits.click();
				}
			} catch (NoSuchElementException e) {
				System.out.println(
						"can't locate explainationOfBenefits element, will try to click coverageBenefits then try again before giving up "
								+ e);
				claims.click();
				waitforElement(explainationOfBenefits);
				if (explainationOfBenefits.isDisplayed()) {
					explainationOfBenefits.click();
				}
			}
		}
	}

	/**
	 * Validate coverage and Benefits tab
	 */
	public void validateCoverageBenefits() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitforElement(coverageBenefits);
		Assert.assertTrue("coverageBenefits tab is displayed", coverageBenefits.isDisplayed());
	}

	/**
	 * Validate Coverage and Benefits Level 2 Tabs
	 */
	public void validateCoverageBenefitsL2Tabs() {
		waitforElement(coverageBenefits);
		if (validate(coverageBenefits,0)) {
			coverageBenefits.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertTrue("benefitsSummary is displayed", validate(benefitsSummary,0));
			Assert.assertTrue("formsAndResources is displayed", validate(formsAndResources,0));
			Assert.assertTrue("orderMaterials is displayed", validate(orderMaterials,0));
		}
	}


	/**
	 * Validate Coverage and Benefits Level 2 Tabs
	 */
	public void validateCoverageBenefitsL2TabsForTerminated() {
		waitforElement(coverageBenefits);
		if (coverageBenefits.isDisplayed()) {
			coverageBenefits.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue("formsAndResources is displayed", formsAndResources.isDisplayed());

		}
	}
	/**
	 * click on Benefits Summary
	 */
	public void clickBenefitsSummary() {
		waitforElement(coverageBenefits);
		if (coverageBenefits.isDisplayed()) {
			try {
				// coverageBenefits.click();
				if (benefitsSummary.isDisplayed()) {
					benefitsSummary.click();
				}
			} catch (NoSuchElementException e) {
				System.out.println(
						"can't locate benefitsSummary element, will try to click coverageBenefits then try again before giving up "
								+ e);
				coverageBenefits.click();
				waitforElement(benefitsSummary);
				if (benefitsSummary.isDisplayed()) {
					benefitsSummary.click();
				}
			}
		}
	}

	/**
	 * click on forms And Resources
	 */
	public void clickFormsResources() {
		waitforElement(coverageBenefits);
		if (coverageBenefits.isDisplayed()) {
			try {
				// coverageBenefits.click();
				if (formsAndResources.isDisplayed()) {
					formsAndResources.click();
				}
			} catch (NoSuchElementException e) {
				System.out.println(
						"can't locate formsAndResources element, will try to click coverageBenefits then try again before giving up "
								+ e);
				coverageBenefits.click();
				waitforElement(formsAndResources);
				if (formsAndResources.isDisplayed()) {
					formsAndResources.click();
				}
			}
		}
	}

	/**
	 * click on Order Materials
	 */
	public void clickOrderMaterials() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitforElement(coverageBenefits);
		if (coverageBenefits.isDisplayed()) {
			// coverageBenefits.click();
			try {
				if (orderMaterials.isDisplayed()) {
					orderMaterials.click();
				}
			} catch (NoSuchElementException e) {
				System.out.println(
						"can't locate orderMaterials element, will try to click coverageBenefits then try again before giving up "
								+ e);
				coverageBenefits.click();
				waitforElement(orderMaterials);
				if (orderMaterials.isDisplayed()) {
					orderMaterials.click();
				}
			}
		}
	}

	public void validateHelp() {
		Assert.assertTrue("Help tab is displayed", validate(help,0));
	}

	public void validateAccountProfile() {
		if (validate(logOut,0)) {
			Assert.assertTrue("Account/Profile tab is displayed",validate(accountProfile,0));
			clickAccountProfile();
			clickLogout();
		} else
			Assert.assertFalse("Account/Profile tab is not displayed", !validate(accountProfile,0));

	}

	/**
	 * Validate the Header on the dasboard
	 */
	public void validateDashboardHeader() {
		Assert.assertTrue("Header is displayed", dashboardHeader.isDisplayed());
	}

	public void clickAccountProfile() {
		if (accountProfile.isDisplayed()) {
			accountProfile.click();
		}

	}

	public void clickLogout() {
		if (validate(logOut,0)) {
			logOut.click();
			if (driver.getTitle().equals("UnitedHealthcare Medicare Member Sign In"))
				Assert.assertTrue("user is logged out", true);

		}

	}

	// Header in a Terminated view

	/**
	 * Validate claims Tab on dashboard
	 */
	public void validateDashboardClaims() {
		Assert.assertTrue("Claims tab is displayed", claimsDashboard.isDisplayed());

	}

	public void validateDashboardClaimsL2Tabs() {
		if (claimsDashboard.isDisplayed()) {
			claimsDashboard.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue("claimSummary is not displayed", claimSummary.isDisplayed());
			Assert.assertTrue("explainationOfBenefits is not displayed", explainationOfBenefits.isDisplayed());

		}

	}

	/**
	 * validate help link on dashboard
	 */
	public void validateDashboardHelp() {
		Assert.assertTrue("help link is displayed", helpDashboard.isDisplayed());
	}

	/**
	 * Validate coverage & Benefits Tab on dashboard
	 */
	public void validateDashboardCoverageBenefits() {
		Assert.assertTrue("coverageBenefits tab is displayed", coverageBenefitsDashboard.isDisplayed());

	}

	public void validateDashboardCoverageBenefitsL2Tabs() {
		waitforElement(coverageBenefits);
		if (coverageBenefitsDashboard.isDisplayed()) {
			coverageBenefitsDashboard.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertFalse("benefitsSummary is Not displayed", benefitsSummary.isDisplayed());
			Assert.assertTrue("formsAndResources is displayed", formsAndResources.isDisplayed());
			Assert.assertFalse("orderMaterials is Not displayed", orderMaterials.isDisplayed());
		}
	}

	public void validateDasboardHelp() {
		Assert.assertTrue("Help tab is displayed", helpDashboard.isDisplayed());
	}

	/*
	 * validate that the Premium payment tab is not displayed for a terminated
	 * member
	 */

	public boolean dashboardPremiumPaymentsNotAvailable() {

		if (validate(premiumPayment) == false) {
			Assert.assertFalse("premium payment is not displayed", validate(dashbaordPremiumPayment));
			return true;

		} else {
			Assert.fail("premium payment is displayed");
			return false;
		}
	}

	/*
	 * validate that the Find care tab is not displayed on the header in a
	 * terminated view
	 */

	public boolean dashboardFindCareNotAvailable() {

		if (validate(dashboardFindCare) == false) {
			Assert.assertFalse("find care is not displayed", validate(dashboardFindCare));
			return true;

		} else {
			Assert.fail("find care is displayed");
			return false;
		}
	}

	/**
	 * validate forms and resources
	 */

	public void validateFormsResources() {
		if (coverageBenefitsDashboard.isDisplayed()) {
			coverageBenefitsDashboard.click();
		}

	}

	public void validateFormsResourcesPage() {

		if (driver.getCurrentUrl().contains("/documents/overview.html"))
			;
		{
			System.out.println("User is on forms resources page and URL is ====>" + driver.getCurrentUrl());
		}

	}

	/**
	 * iPerception popup
	 */

	/* public void feebackpopupClose() throws InterruptedException { // waitForloader(driver,overlay,
		// 20);
		Thread.sleep(20000);
		if (validate(iPerceptionframe)) {

			switchToNewIframe(iPerceptionframe);
			iPerceptionclosebtn.click();
			driver.switchTo().defaultContent();
			// iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
	} */
	
				public void feebackpopupClose() throws InterruptedException { 
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

	public ClaimDetailsPage navigateToClaimDetailsPageCombo() {
		CommonUtility.waitForPageLoad(driver, claimstablemoreinfolinkCombo, 10);
		validateNew(claimstablemoreinfolinkCombo);
		System.out.println("more info link is seen for combo member ===>" + claimstablemoreinfolinkCombo.isDisplayed());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", claimstablemoreinfolinkCombo);
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, claimtotalcomb, 30);
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase("/details")) {
			System.out.println("*** Combo Member is on Claims Details Page ***");
		}
		return new ClaimDetailsPage(driver);
	}

	/**
	 * Navigate to BnC page via the top menu link element instead of hard code URL
	 * @return
	 */
	public BenefitsAndCoveragePage navigateToBenefitAndCoveragePage() {
		if ((MRScenario.environmentMedicare.equalsIgnoreCase("stage") || MRScenario.environmentMedicare.equalsIgnoreCase("offline"))
				&& ("NO".equalsIgnoreCase(MRScenario.isTestHarness))) {
			if (validate(coverageBenefits))
				coverageBenefits.click();
			else {
				System.out.println("Check for shadow-root before giving up");
				String secondTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(2)";
				String thirdTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(3)";
				String forthTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(4)";
				WebElement tmp = locateElementWithinShadowRoot(shadowRootHeader,
						secondTopMenuItemCssStr);
				if (tmp.getText().equalsIgnoreCase("Claims")) {
					locateAndClickElementWithinShadowRoot(shadowRootHeader, thirdTopMenuItemCssStr);
				} else {
					locateAndClickElementWithinShadowRoot(shadowRootHeader,	forthTopMenuItemCssStr);
				}
			}
			System.out.println(driver.getCurrentUrl());
			CommonUtility.waitForPageLoad(driver, heading, 30);
			if (driver.getTitle().contains("Benefits") || driver.getTitle().contains("Documents")) { //note: for case of terminated user on stage - title is Plan Documents & Resources
				System.out.println(driver.getTitle());
				return new BenefitsAndCoveragePage(driver);
			}
		} else {
			Assert.assertTrue("Haven't code yet for the navigation to BnC from env="+MRScenario.environmentMedicare, false);
		}
		return null;
	}
	
	 public BenefitsAndCoveragePage navigateDirectToBnCPag() {
		 checkModelPopup(driver,5);
		 if (noWaitValidate(shadowRootHeader)) {
			 System.out.println("located shadow-root element, attempt to process further...");
			 WebElement root1 = expandRootElement(shadowRootHeader);
			 try {
				 WebElement benefitsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
				 benefitsTopMenuShadowRootLink.click();
			 } catch (Exception e) {
				 Assert.assertTrue("PROBLEM - unable to locate Benefits link on Rally Dashboard top menu", false);
			 }		

		 } 
		 CommonUtility.checkPageIsReady(driver);
		 checkModelPopup(driver,5);

		 CommonUtility.waitForPageLoad(driver, heading, 50);
		 if (driver.getTitle().contains("Benefits")) {
			 return new BenefitsAndCoveragePage(driver);
		 }

		 return null;
	 }

	public BenefitsAndCoveragePage navigateToBandCPag() {

		if (MRScenario.environment.equalsIgnoreCase("stage")) {
			System.out.println("user is on Stage login page");
			// CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);
			if (driver.getCurrentUrl().contains("/dashboard"))
				;
			{
				System.out.println("User is on dashboard page and URL is ==>" + driver.getCurrentUrl());

				driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(driver.getCurrentUrl());
				// CommonUtility.waitForPageLoad(driver, heading, 30);
				if (driver.getTitle().contains("Plan Benefits Summary")) {
					System.out.println(driver.getTitle());
					return new BenefitsAndCoveragePage(driver);
				}

			}
		}

		else if (MRScenario.environment.equals("team-h") || MRScenario.environment.equals("test-a")
				|| MRScenario.environment.equals("team-e")) {

			driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
			System.out.println(driver.getCurrentUrl());
		} else {
			driver.navigate().to(
					"https://team-ci1-medicare.ose-elr-core.optum.com/content/medicare/member/benefits/overview.html");

			System.out.println(driver.getCurrentUrl());
		}

		/*
		 * if (validate(iPerceptionPopUp)) { iPerceptionPopUp.click();
		 * System.out.println("iPerception Pop Up displayed"); }
		 */

		// CommonUtility.waitForPageLoad(driver, heading, 50);
		if (driver.getTitle().equalsIgnoreCase("Plan Benefits Summary")) {
			return new BenefitsAndCoveragePage(driver);
		}

		return null;

	}

	/*
	 * This method checks that Premium Payment tab is displayed for
	 * Pre-Effective members on dashboard page
	 */
	public void validatePremiumPaymentTabDisplayedOnDashboard(String planType) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Now checking for Premium Payment Tab on Dashboard via shadowroot");
		if (validate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				System.out.println("Value of Plan Type is: "+planType);
				if (planType.equalsIgnoreCase("SHIP"))
				{	
				WebElement PremiumPaymentTab = root1.findElement(By
						.cssSelector("#sticky-main-nav > div > div > div > a:nth-child(4)"));
				System.out.println("shadow-root element has been located");	
				TestHarness.checkForIPerceptionModel(driver);
				System.out.println("getText() of Premium Payment is :" +PremiumPaymentTab.getText());
				if (PremiumPaymentTab.isDisplayed() && PremiumPaymentTab.getText().contains("PREMIUM PAYMENTS"))
				{
					System.out.println("Premium Payments tab was displayed");	
				}
				
				else
				{
				Assert.fail("Premium Payments tab was NOT displayed, Test Step is failed");	
				}
			}
			else 
				{
					WebElement PremiumPaymentTab = root1.findElement(By
							.cssSelector("#sticky-main-nav > div > div > div > a:nth-child(5)"));
					System.out.println("shadow-root element has been located");	
					TestHarness.checkForIPerceptionModel(driver);
					System.out.println("getText() of Premium Payment is :" +PremiumPaymentTab.getText());
					if (PremiumPaymentTab.isDisplayed() && PremiumPaymentTab.getText().contains("PREMIUM PAYMENTS"))
					{
						System.out.println("Premium Payments tab was displayed");	
					}
					
					else
					{
					Assert.fail("Premium Payments tab was NOT displayed, Test Step is failed");	
					}
				}
			}
		catch(Exception e)
		{
			System.out.println("Could not locate shadow root element for benefits and coverage tab");
			Assert.fail("Could not locate shadow root element for benefits and coverage tab");
		}
	
	}
}

	/*
	 * This method checks that correct pre-Effective message is displayed on
	 * Dashboard for Pre-Effective members
	 */
	public void validatePreEffectiveMessagePresent() throws InterruptedException {
		Thread.sleep(2000);
		CommonUtility.waitForPageLoad(driver, preEffectiveMessage, 20);
		try{
		String preMessage_text = preEffectiveMessage.getAttribute("innerText");
		System.out.println("Message displayed on Dashboard for this member is: " + preMessage_text);
		Assert.assertTrue(preMessage_text.contains("Use this site to find helpful information while"));
		System.out.println("First assert on the preeffective message is passed");
		Assert.assertTrue(preMessage_text.contains(
				"Get early access to your new plan materials and manage your document delivery preferences."));
		System.out.println("Second assert on the preeffective message is passed");
		}
		catch (Exception e)
		{
		Assert.fail("Failed to read Pre-effective message for member on Dashboard page");	
		}
		
	}

	public BenefitsAndCoveragePage clickOnBenefitsandCoverageTab() throws InterruptedException {
		System.out.println("Now navigating to Coverage and Benefits page");
		driver.findElement(By.xpath("//a[contains(text(),'Coverage & Benefits')]")).click();
		System.out.println("Now waiting for 20 seconds");
		return new BenefitsAndCoveragePage(driver);

	}

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

	// This method the dashboard when a pre effective member lands on the Home
	// page
	public void validateHomePage1() throws InterruptedException {
		Thread.sleep(10000);
		System.out.println(" @@@ The title of the page is " + driver.getTitle());
		if (getTitle().equalsIgnoreCase("Home | UnitedHealthcare")) {
			System.out.println("On the dashboard ");
		}
		System.out.println("@@@ The URL of the page is ==>" + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("https://member.int.uhc.com/aarp/dashboard"))
			;
		System.out.println("Member is on the dashboard");
		validate(preEffectiveMessage);
		System.out
		.println("The pre-effective message fr the member on dashboard is ==>" + preEffectiveMessage.getText());
		String preMessage_text = preEffectiveMessage.getText();
		System.out.println("Message displayed on Dashboard for this member is:" + preEffectiveMessage);
		Assert.assertTrue(preMessage_text.contains(
				"Use this site to find helpful information while you’re getting ready for your plan to start on"));
		System.out.println("Assert on the preeffective message is passed");

	}

	// vvv note: added for 'sorry' login error workaround
	private HashMap<String, String> attemptSorryWorkaround;

	public HashMap<String, String> getAttemptSorryWorkaround() {
		return attemptSorryWorkaround;
	}

	public void setAttemptSorryWorkaround(HashMap<String, String> input) {
		attemptSorryWorkaround = input;
	}

	public void workaroundAttempt(String page) {
		System.out.println(
				"======================== OK LET'S ATTEMPT THE 'SORRY' WORKAROUND  ===========================");

		if (driver.getCurrentUrl().contains("int.uhc.com/internal-error")) {
			// in this case, there will be no userType identifier in URL, do one
			// more step
			// first click the account settings link on footer, get the URL for
			// additional parsing
			// tbd locateAndClickElementWithinShadowRoot(shadowRootFooter, "div
			// > span > footer > div:nth-child(1) > div:nth-child(3) >
			// ul:nth-child(2) > li > a");

			locateAndClickElementWithinShadowRoot(shadowRootHeader, "#dropdown-toggle-3");
			locateAndClickElementWithinShadowRoot(shadowRootHeader, "#dropdown-options-3 > a:nth-child(1)");

		}

		// assumption this is the sorry error url, parse the URL to determine
		// which URL to use
		String currentUrl = driver.getCurrentUrl();

		if (currentUrl.contains("https://systest3.myuhc.com")) {
			System.out.println(
					"Account setting is pointing to systest3.myuhc.com instead.  Give up trying workaround it.");
			Assert.fail(
					"***** Error in loading  Redesign Account Landing Page ***** Got 'Sorry, it's not you. It's us' login error and the account setting is pointed to systest3.myuhc.com");
		}

		String[] tmp1 = currentUrl.split(".com/");
		String[] tmp2 = tmp1[1].split("/");
		String userType = tmp2[0];

		String part1 = "";
		if (attemptSorryWorkaround.get("planType").equalsIgnoreCase("pcp")
				|| attemptSorryWorkaround.get("planType").equalsIgnoreCase("medica")) {
			part1 = "https://" + MRScenario.environmentMedicare + "-mymedicareaccount.uhc.com/";
		} else {
			part1 = "https://" + MRScenario.environmentMedicare + "-medicare.uhc.com/";
		}

		String part2 = userType;

		String part3 = "";
		if (page.equals("claims")) {
			part3 = "/member/claims.html#/overview";
		} else if (page.equals("contactus")) {
			part3 = "/member/contact-us/overview.html#/contact-us-two";
		} else if (page.equals("profilepref")) {
			part3 = "/member/profile.html";
		} else if (page.equals("order")) {
			part3 = "/member/order-materials/overview.html";
		} else if (page.equals("reward")) {
			part3 = "/member/health-and-wellness.html";
		} else if (page.equals("pharmacylocator")) {
			part3 = "/member/pharmacy-locator/overview.html";
		} else if (page.equals("dce")) {
			part3 = "/member/drug-lookup/overview.html#/drug-cost-estimator";
		} else if (page.equals("pnp")) {
			part3 = "/member/pharmacy/overview.html";
		} else { // note: shouldn't have gotten here, but just in case
			Assert.assertTrue("Sorry, testType '" + attemptSorryWorkaround.get("testType")
			+ "' is not covered by this workaround yet, abort this test now", false);
		}

		String workaroundURL = part1 + part2 + part3;
		if (page.equals("dce")) {
			// mimic testharness page
			workaroundURL = "https://stage-medicare.uhc.com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator";
		}
		System.out.println("Workaround URL is going to be: " + workaroundURL);
		driver.get(workaroundURL);
		System.out.println("wait for driver to be ready after loading URL...");
		CommonUtility.checkPageIsReadyNew(driver);
	}
	// ^^^ note: added for 'sorry' login error workaround

	public ClaimDetailsPage navigateToClaimDetailsPagetoseeeobpdflink(int pageNum, int rowNum) {
		CommonUtility.waitForPageLoad(driver, claimstablemoreinfolink, 10);
		try {
			validateNew(claimstablemoreinfolink);
			// note: start with page1, every click increment 1 page
			for (int i = 0; i < pageNum - 1; i++) {
				paginationRightArrow.click();
			}
			System.out.println("more info link is seen for  ===>" + claimstablemoreinfolink.isDisplayed());
			try {
				Thread.sleep(2000); // keep, sometimes detail takes longer to load
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				// note: rowIndex is rowNum-1
				WebElement targetRowMoreInfo = driver
						.findElement(By.xpath("//*[@id='moreInfoLinkAtdd" + (rowNum - 1) + "']/a"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", targetRowMoreInfo);
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate the More Info link element that is expected to have EOB",
						false);
			}
			checkForIPerceptionModel(driver);
			System.out.println(driver.getTitle());
			if (driver.getTitle().equalsIgnoreCase("Claims Summary")) {
				System.out.println("*** Claims Details Page ***");
			}
		} catch (Exception ex) {
			return null;
		}
		return new ClaimDetailsPage(driver);
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
	
	public boolean findElementWithinShadowRoot(WebElement shadowRootElement, String inputSelector) {
		if (noWaitValidate(shadowRootElement)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootElement);
			try {
				WebElement element = root1.findElement(By.cssSelector(inputSelector));
				if (noWaitValidate(element)) 
					return true;
				else
					return false;
			} catch (Exception e) {
				System.out.println("Got exception. can't locate element. Exception e=" + e);
				return false;
			}
		} else {
			System.out.println("no shadow-root element either, not sure what's going on w/ the header on rally");
			return false;
		}
	}

	public void locateAndClickElementWithinShadowRoot(WebElement shadowRootElement, String inputCssSelector) {
		boolean doScroll = false;
		locateAndClickElementWithinShadowRoot(shadowRootElement, inputCssSelector, doScroll);
	}

	public void locateAndClickElementWithinShadowRoot(WebElement shadowRootElement, String inputCssSelector,
			boolean doScroll) {
		if (noWaitValidate(shadowRootElement)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootElement);
			try {
				WebElement element = root1.findElement(By.cssSelector(inputCssSelector));
				Assert.assertTrue("Dashboard Shadow Root Elemnt is not accessible", noWaitValidate(element));
				System.out.println("element is located, click it...");
				System.out.println("We are looking for: " + element.getText() + " and we got it.");
				if (doScroll) { // for contact us at bottom page, need to scroll
					// so it's clickable
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,10000)");
					Thread.sleep(5000);
				}
				element.click();
				CommonUtility.checkPageIsReady(driver);
			} catch (NoSuchElementException ne) {
				System.out.println("Can't locate shadowRoot element with css selector '"+inputCssSelector+" on dashboad', rethrowing the exception for next level to handle");
				throw ne;
				//new NoSuchElementException("Unable to locate css select '"+inputCssSelector+"' in shadow-root");
			} catch (Exception e) {
				System.out.println("can't locate element. Exception e=" + e);
				Assert.assertTrue("Got exception. Can't locate shadowRoot element with css selector '"+inputCssSelector+" on dashboad", false);
			}
		} else {
			System.out.println("no shadow-root element either, not sure what's going on w/ the header on rally");
			Assert.assertTrue("No shadowRoot eleemnt on dashboard header", false);
		}
	}

	public void navigateToClaimsPageByViewYourClaimsLinkThenBackToHome() {
		CommonUtility.waitForPageLoad(driver, viewYourClaimsLink, 10);
		Assert.assertTrue("PROBLEM - unable to locate 'VIEW YOUR CLAIMS' link on dashboard page",
				validate(viewYourClaimsLink,0));
		viewYourClaimsLink.click();
		CommonUtility.checkPageIsReady(driver);
		checkForIPerceptionModel(driver);
		String expUrl = "member/claims/overview.html";
		Assert.assertTrue("PROBLEM - not getting expected claims page. Expected URL contains '" + expUrl
				+ "' | Actual URL='" + driver.getCurrentUrl() + "'", driver.getCurrentUrl().contains(expUrl));
		String expPageTitle = "Claims Summary";
		Assert.assertTrue("PROBLEM - not getting expected page title for claims summary page. Expected to contains="
				+ expPageTitle + " | Actual=" + driver.getTitle(), driver.getTitle().contains(expPageTitle));
		System.out.println("The title of Claims page is-------->" + driver.getTitle());
		if (validate(HomeTopMenuButton,0)) {
			HomeTopMenuButton.click();
		} else {
			locateElementWithinShadowRoot(shadowRootHeader, "#home_2");
		}
		CommonUtility.checkPageIsReady(driver);
		checkForIPerceptionModel(driver);
	}

		public FormsAndResourcesPage navigatetoFormsnResourcesWithTimeout(String memberType, String planType)
			throws InterruptedException {
		checkForIPerceptionModel(driver);
		StopWatch pageLoad = new StopWatch();
		pageLoad.start();
		int forceTimeoutInMin=5;
		try {
			driver.manage().timeouts().pageLoadTimeout((forceTimeoutInMin*60), TimeUnit.SECONDS);
			System.out.println("Set pageLoadTimeout to "+forceTimeoutInMin+" min");

			if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
				System.out.println("user is on Stage login page");
				if ((driver.getCurrentUrl().contains("/aarp/dashboard")) 
						&& ((!memberType.toLowerCase().contains("pcp") && !memberType.toLowerCase().contains("medica"))
								&& (!planType.toLowerCase().contains("pcp") && !planType.toLowerCase().contains("medica")))) {
					System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
					driver.navigate().to(PAGE_URL + "aarp/member/documents/overview.html");
					// https://stage-mymedicareaccount.uhc.com/pcp/member/documents/overview.html
				} else if ((driver.getCurrentUrl().contains("mymedicareaccount"))
						&& (memberType.toLowerCase().contains("pcp") || planType.toLowerCase().contains("pcp"))) {
					System.out.println("User is on pcp dashboard page and URL is ====>" + driver.getCurrentUrl());
					driver.navigate().to("https://stage-mymedicareaccount.uhc.com/pcp/member/documents/overview.html");
					System.out.println(driver.getCurrentUrl());
				} else if (driver.getCurrentUrl().contains("/retiree/dashboard")) {
					System.out.println("User is on  dashboard page and URL is ====>" + driver.getCurrentUrl());
					driver.navigate().to(PAGE_URL + "retiree/member/documents/overview.html");
					System.out.println(driver.getCurrentUrl());
				} else if (driver.getCurrentUrl().contains("/medicare/dashboard")) {
					System.out.println("User is on  dashboard page and URL is ====>" + driver.getCurrentUrl());
					driver.navigate().to(PAGE_URL + "medicare/member/documents/overview.html");
					System.out.println(driver.getCurrentUrl());
				} else if ((driver.getCurrentUrl().contains("mymedicareaccount"))
						&& (memberType.toLowerCase().contains("medica") || planType.toLowerCase().contains("medica"))) {
					System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
					driver.navigate().to("https://stage-mymedicareaccount.uhc.com/medica/member/documents/overview.html");
				}
			} else {
				if (driver.getCurrentUrl().contains("mymedicareaccount"))
					driver.navigate().to("https://" + MRScenario.environmentMedicare
							+ "-mymedicareaccount.uhc.com/content/medicare/member/documents/overview.html");
				else {
					driver.navigate().to("https://" + MRScenario.environmentMedicare
							+ "-medicare.ose-elr-core.optum.com/content/medicare/member/documents/overview.html");
				}
			}
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("waited "+forceTimeoutInMin+" min for the page to finish loading, give up now");
			driver.quit(); //force the test to fail instead of waiting time
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
		
	public PlanDocumentsAndResourcesPage navigateDirectToPlanDocPage(String memberType, String planType, int forceTimeoutInMin)
				throws InterruptedException {
		//tbd checkForIPerceptionModel(driver);
		CommonUtility.checkPageIsReady(driver);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		checkModelPopup(driver, 5);
		StopWatch pageLoad = new StopWatch();
		pageLoad.start();
		try {
			driver.manage().timeouts().pageLoadTimeout((forceTimeoutInMin*60), TimeUnit.SECONDS);
			System.out.println("Set pageLoadTimeout to "+forceTimeoutInMin+" min");

			if (MRScenario.environment.equalsIgnoreCase("stage")) {
				System.out.println("user is on Stage login page");
				if ((driver.getCurrentUrl().contains("/aarp/dashboard")) 
						&& ((!memberType.toLowerCase().contains("pcp") && !memberType.toLowerCase().contains("medica"))
								&& (!planType.toLowerCase().contains("pcp") && !planType.toLowerCase().contains("medica")))) {
					System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
					driver.navigate().to(PAGE_URL + "aarp/member/documents/overview.html");
					// https://stage-mymedicareaccount.uhc.com/pcp/member/documents/overview.html
				} else if ((driver.getCurrentUrl().contains("mymedicareaccount"))
						&& (memberType.toLowerCase().contains("pcp") || planType.toLowerCase().contains("pcp"))) {
					System.out.println("User is on pcp dashboard page and URL is ====>" + driver.getCurrentUrl());
					driver.navigate().to("https://stage-mymedicareaccount.uhc.com/pcp/member/documents/overview.html");
					System.out.println(driver.getCurrentUrl());
				} else if (driver.getCurrentUrl().contains("/retiree/dashboard")) {
					System.out.println("User is on  dashboard page and URL is ====>" + driver.getCurrentUrl());
					driver.navigate().to(PAGE_URL + "retiree/member/documents/overview.html");
					System.out.println(driver.getCurrentUrl());
				} else if (driver.getCurrentUrl().contains("/medicare/dashboard")) {
					System.out.println("User is on  dashboard page and URL is ====>" + driver.getCurrentUrl());
					driver.navigate().to(PAGE_URL + "medicare/member/documents/overview.html");
					System.out.println(driver.getCurrentUrl());
				} else if ((driver.getCurrentUrl().contains("mymedicareaccount"))
						&& (memberType.toLowerCase().contains("medica") || planType.toLowerCase().contains("medica"))) {
					System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
					driver.navigate().to("https://stage-mymedicareaccount.uhc.com/medica/member/documents/overview.html");
				}
				checkModelPopup(driver,5);
			} else if (MRScenario.environment.equalsIgnoreCase("prod") || MRScenario.environment.equalsIgnoreCase("offline")) {
				Assert.assertTrue("PROBLEM - unable to locate the plan doc link on rally dashboard", noWaitValidate(planDocResPgLink));
				checkModelPopup(driver, 5);
				scrollElementToCenterScreen(planDocResPgLink);
				planDocResPgLink.click();
			} else {
				if (driver.getCurrentUrl().contains("mymedicareaccount"))
					driver.navigate().to("https://" + MRScenario.environmentMedicare
							+ "-mymedicareaccount.uhc.com/content/medicare/member/documents/overview.html");
				else {
					driver.navigate().to("https://" + MRScenario.environmentMedicare
							+ "-medicare.ose-elr-core.optum.com/content/medicare/member/documents/overview.html");
				}
			}
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("waited "+forceTimeoutInMin+" min for the page to finish loading, give up now");
			driver.quit(); //force the test to fail instead of waiting time
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
		checkModelPopup(driver, 5);

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
	public PharmaciesAndPrescriptionsPage navigateToPharmaciesAndPrescriptions() {
		System.out.println("user is on '" + MRScenario.environment + "' login page");
		checkForIPerceptionModel(driver);
		if (driver.getCurrentUrl().contains("/dashboard")) {
			System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
			if (validate(pharPresDashboardLink))
				pharPresDashboardLink.click();
			 else if (validate(pharPresDashboardLinkAlternative))
				pharPresDashboardLinkAlternative.click();
			else {
				if (validate(shadowRootHeader)) {
					System.out.println("Check for shadow-root before giving up");
					attemptShadowRootTopMenuLinkNavigationForPnP();
				} else {
					System.out.println("There is no shadow-root menu");
				}
			}
			CommonUtility.checkPageIsReadyNew(driver);
		} else if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
			//System.out.println("don't bother to work around the sorry error, page displays won't look right");
			workaroundAttempt("pnp"); 
		}
		if (driver.getCurrentUrl().contains("pharmacy/overview.html"))
			return new PharmaciesAndPrescriptionsPage(driver);
		return null;
	}	

	public void attemptShadowRootTopMenuLinkNavigationForPnP() {
		//note: use the 2nd menu link as the base and determine which one I really need
		// if 2 is FIND CARE then 6 is PnP
		// if 2 is CARE then 5 is PnP
		String secondTopMenuItemCssStr="#sticky-main-nav > div > div > div > a:nth-child(2)";
		WebElement secondTopMenuItem = locateElementWithinShadowRoot(shadowRootHeader,
				secondTopMenuItemCssStr);
		if (secondTopMenuItem.getText().contains("FIND CARE")) {
			String pnpTopMenuItemCssStr="#sticky-main-nav > div > div > div > a:nth-child(5)";
			WebElement pnpTopMenuLink = locateElementWithinShadowRoot(shadowRootHeader,
					pnpTopMenuItemCssStr);
			if (isPnpLink(pnpTopMenuLink.getText())) 
				locateAndClickElementWithinShadowRoot(shadowRootHeader, pnpTopMenuItemCssStr);
		} else if (secondTopMenuItem.getText().contains("CLAIMS")) {
			String pnpTopMenuItemCssStr="#sticky-main-nav > div > div > div > a:nth-child(4)";
			WebElement pnpTopMenuLink = locateElementWithinShadowRoot(shadowRootHeader,
					pnpTopMenuItemCssStr);
			if (isPnpLink(pnpTopMenuLink.getText())) 
				locateAndClickElementWithinShadowRoot(shadowRootHeader, pnpTopMenuItemCssStr);
		} 
	}
	
	public boolean findShadowRootTopMenuLinkForPnP() {
		String pnpTopMenuItemCssStr="a[data-testid*=nav-link-pharmacies]";
		WebElement pnpTopMenuLink = locateElementWithinShadowRootNoAssert(shadowRootHeader,
				pnpTopMenuItemCssStr);
		if (pnpTopMenuLink!=null && isPnpLink(pnpTopMenuLink.getText()))
			return true;
		return false;
		/* tbd 
		//note: use the 2nd menu link as the base and determine which one I really need
		// if 2 is FIND CARE then 6 is PnP
		// if 2 is CARE then 5 is PnP
		String secondTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(2)";
		WebElement secondTopMenuItem = locateElementWithinShadowRootNoAssert(shadowRootHeader,
				secondTopMenuItemCssStr);
		Assert.assertTrue("PROBLEM - unable locate top menu item", secondTopMenuItem!=null);
		if (secondTopMenuItem!=null && secondTopMenuItem.getText().contains("FIND CARE")) {
			String pnpTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(6)";
			WebElement pnpTopMenuLink = locateElementWithinShadowRootNoAssert(shadowRootHeader,
					pnpTopMenuItemCssStr);
			if (pnpTopMenuLink!=null && isPnpLink(pnpTopMenuLink.getText()))
				return true;
			else { //note: maybe user has no payment tab, try this one before giving up
				pnpTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(5)";
				pnpTopMenuLink = locateElementWithinShadowRootNoAssert(shadowRootHeader,
						pnpTopMenuItemCssStr);
				if (pnpTopMenuLink!=null && isPnpLink(pnpTopMenuLink.getText()))
					return true;
			}
		} else if (secondTopMenuItem.getText().contains("CLAIMS")) { //note: user has no FIND CARE & COSTS tab
			String pnpTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(5)";
			WebElement pnpTopMenuLink = locateElementWithinShadowRootNoAssert(shadowRootHeader,
					pnpTopMenuItemCssStr);
			if (pnpTopMenuLink!=null && isPnpLink(pnpTopMenuLink.getText()))
				return true;
			else { //note: maybe user has no payment tab, try this one before giving up
				pnpTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(4)";
				pnpTopMenuLink = locateElementWithinShadowRootNoAssert(shadowRootHeader,
						pnpTopMenuItemCssStr);
				if (pnpTopMenuLink!=null && isPnpLink(pnpTopMenuLink.getText()))
					return true;
			}
		} 
		return false;
		*/
	}
	
	public PharmaciesAndPrescriptionsPage navigateToPharmaciesAndPrescriptionsFromSecondaryPg() {
		System.out.println("user is on '" + MRScenario.environmentMedicare + "' dashboard page, attempt secondary page navigaton to reach PnP page");
		checkForIPerceptionModel(driver);
		if (driver.getCurrentUrl().contains("/dashboard")) {
			System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
			ClaimsSummaryPage claimsPg=navigateToClaimsSummaryPage();
			Assert.assertTrue("PROBLEM - unable to go to secondary page claims first", claimsPg!=null);
			if (validate(pharPresDashboardLink)) 
				pharPresDashboardLink.click();
			else if (validate(pharPresDashboardLinkAlternative))
				pharPresDashboardLinkAlternative.click();
			else {
				if (validate(shadowRootHeader)) {
					System.out.println("Check for shadow-root before giving up");
					attemptShadowRootTopMenuLinkNavigationForPnP();
				} else {
					System.out.println("There is no shadow-root menu");
				}
			}
			CommonUtility.checkPageIsReadyNew(driver);
		} else if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
			//System.out.println("don't bother to work around the sorry error, page displays won't look right");
			workaroundAttempt("pnp"); 
		}
		if (driver.getCurrentUrl().contains("pharmacy/overview.html"))
			return new PharmaciesAndPrescriptionsPage(driver);
		return null;
	}	
	
	public boolean isPnpLink(String targetLnkTxt) {
		Pattern expectedTxt=Pattern.compile("PHARMACIES . PRESCRIPTIONS");
		if (expectedTxt.matcher(targetLnkTxt).find())
			return true;
		else 
			return false;
	}
	
	public boolean findPnPLinksExistOnPg() {
		System.out.println("user is on '" + MRScenario.environmentMedicare + "' dashboard page, attempt to navigate to secondary page to see if PnP link exists");
		checkForIPerceptionModel(driver);
		if (noWaitValidate(pharPresDashboardLink)) {
			return true;
		} else if (noWaitValidate(pharPresDashboardLinkAlternative)) {
			return true;
		} else {
			if (noWaitValidate(shadowRootHeader)) {
				System.out.println("Check for shadow-root before giving up");
				String secondTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(2)";
				WebElement secondTopMenuItem = locateElementWithinShadowRootNoAssert(shadowRootHeader, secondTopMenuItemCssStr);
				if (secondTopMenuItem !=null && secondTopMenuItem.getText().contains("FIND CARE")) {
					String pnpTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(6)";
					WebElement pnpTopMenuItem = locateElementWithinShadowRootNoAssert(shadowRootHeader, pnpTopMenuItemCssStr);
					if (pnpTopMenuItem!=null && isPnpLink(pnpTopMenuItem.getText())) 
							return true;
					else { //note: user may not have payment tab, try this before giving up
						pnpTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(5)";
						pnpTopMenuItem = locateElementWithinShadowRootNoAssert(shadowRootHeader, pnpTopMenuItemCssStr);
						if (pnpTopMenuItem!=null && isPnpLink(pnpTopMenuItem.getText())) 
								return true;
					}
				} else if (secondTopMenuItem.getText().contains("CLAIMS")) {
					String pnpTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(5)";
					WebElement pnpTopMenuItem = locateElementWithinShadowRootNoAssert(shadowRootHeader, pnpTopMenuItemCssStr);
					if (pnpTopMenuItem!=null && isPnpLink(pnpTopMenuItem.getText())) 
						return true;
					else { //note: user may not have payment tab, try this before giving up
						pnpTopMenuItemCssStr="#main-nav > div > div > div > a:nth-child(4)";
						pnpTopMenuItem = locateElementWithinShadowRootNoAssert(shadowRootHeader, pnpTopMenuItemCssStr);
						if (pnpTopMenuItem!=null && isPnpLink(pnpTopMenuItem.getText())) 
							return true;
					}
				}
			} else {
				System.out.println("There is no shadow-root menu");
			}
		}
		return false;
	}	
	
	public void navigateToNoticeAndDisclousuresPage() {
		String lnkCssStr="div > span > footer > div:nth-child(2) > div:nth-child(1) > ul > li:nth-child(1) > a";
		locateAndClickElementWithinShadowRoot(shadowRootFooter, lnkCssStr);
		CommonUtility.checkPageIsReady(driver);
		checkForIPerceptionModel(driver);
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
	
	@FindBy(xpath ="//span[@id='hello-person']")
	private WebElement memName;
	
	@FindBy(xpath="//span[@class='hide-mobile ng-scope']")
	private WebElement viewRecomend;
	
	/*
	 * This method validates login on Dashboard
	 */
	public void validateLoginonDashboard() throws InterruptedException {
		Thread.sleep(2000);
		String memberName = memName.getAttribute("innerText");
		System.out.println("Name displayed on Dashboard for this member is:" + memberName);
		String idCard = viewRecomend.getAttribute("innerText");
		Assert.assertTrue(idCard.contains("VIEW & PRINT MEMBER ID CARDS"));
		System.out.println(" View & Print member ID cards assert is passed on the Dashboard !!");
	}
	
	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}
	
	public void scrollElementToCenterScreen(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
		                                            + "var elementTop = arguments[0].getBoundingClientRect().top;"
		                                            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		System.out.println("TEST - move element to center view"); 
		/* JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element); */
	}
	
	 public void userdirectlyaccessesmyhcessoPROD() {
			// TODO Auto-generated method stub
		 
		 if (MRScenario.environment.equalsIgnoreCase("prod"))  
		  {
		   System.out.println("Accessing http://medicare.uhc.com/myhce");
		   driver.navigate().to("http://medicare.uhc.com/myhce");
		  }
		 else if (MRScenario.environment.equalsIgnoreCase("offline"))  
		  {
		   System.out.println("Accessing http://offline.medicare.uhc.com/myhce");
		   driver.navigate().to("http://offline.medicare.uhc.com/myhce");
		  }  
		   
		   try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   System.out.println("Current URL is :  "+driver.getCurrentUrl());
		   
		   }
	 
	 public void userEntersZipCodePROD(String zipCode) {
		   
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
	 
	 public void clickContinueonZipEntryPagePROD() {
			// TODO Auto-generated method stub
		   System.out.println("Now clicking Continue button for myHCE SSO");
		   continueButtonmyHCESSO.click();
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
	 
	 public void checkuserlandsonhceestimatorpagePROD() {
		 System.out.println("Current URL is :  "+driver.getCurrentUrl());
		 System.out.println("Now checking for header element h1 of the page");
		 CommonUtility.checkPageIsReadyNew(driver);
			try {
				System.out.println("Waiting for 4 seconds");
				Thread.sleep(4000);
				System.out.println("Waiting for h1 element to be displayed on page");
				waitforElement(hcePageText); 
				if(hcePageText.isDisplayed())
				{
					System.out.println("Element for header h1 was displayed on page");
				}
				else
				{
					Assert.fail("Element for heaer h1 was NOT displayed on page");
				}				
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
	 
	public PharmaciesAndPrescriptionsPage ssousernavigateToPharmaciesAndPrescriptionsPage(String PlanType)

	{
		System.out.println("Checking for Welcome or Hello on Dashboard home page now");

		try {
			if (helloPerson.isDisplayed()) {
				System.out.println("Hello PersonName on Dashboard home page was found");
			} else {
				waitForHomePage(welcome);
				System.out.println("Welcome on Dashboard home page was found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}

		if (MRScenario.environment.equals("prod") || MRScenario.environment.equals("offline")) {
			if (validate(shadowRootHeader)) {
				System.out.println("located shadow-root element, attempt to process further...");
				WebElement root1 = expandRootElement(shadowRootHeader);
				try {
					System.out.println("Value of PlanType is: "+PlanType);

					if (PlanType.equalsIgnoreCase("GroupMAPDWithoutPayment")) {
						WebElement PharmaciesAndPrescriptionsTab = root1
								.findElement(By.cssSelector("#sticky-main-nav > div > div > div > a:nth-child(5)"));
						System.out.println(
								"shadow-root element has been located, now clicking on Pharmacies And Prescriptions tab");
						TestHarness.checkForIPerceptionModel(driver);
						PharmaciesAndPrescriptionsTab.click();
					}

					else {
						WebElement PharmaciesAndPrescriptionsTab = root1
								.findElement(By.cssSelector("#sticky-main-nav > div > div > div > a:nth-child(6)"));
						System.out.println(
								"shadow-root element has been located, now clicking on Pharmacies And Prescriptions tab");
						TestHarness.checkForIPerceptionModel(driver);
						PharmaciesAndPrescriptionsTab.click();
					}
					
					System.out.println("Pharmacies And Prescriptions tab has been clicked");
					CommonUtility.checkPageIsReadyNew(driver);
					System.out.println("Current URL is : " + driver.getCurrentUrl());
					if (driver.getCurrentUrl().contains("pharmacy")) {
						System.out.println(
								"Current URL contains pharmacy text in it, returning PharmaciesAndPrescriptionsPage");
						return new PharmaciesAndPrescriptionsPage(driver);
					} else {
						Assert.fail(
								"Current URL doesn't contains pharmacy text in it, benefits page didn't appear , failed");
					}
				} catch (Exception e) {
					System.out.println("Plan Type was not MAPD, check for error");

				}
			} else {
				System.out.println("Could not locate shadow root element for Pharmacies And Prescriptions tab");
				Assert.fail("Could not locate shadow root element for Pharmacies And Prescriptions tab");
			}
		} else if (MRScenario.environment.equalsIgnoreCase("stage") & "NO".equalsIgnoreCase(MRScenario.isTestHarness)) {
			System.out.println("Add condition here for Stage Dashboard, if needed");
			Assert.fail("Add condition here for Stage Dashboard, if needed");
		}
		return null;
	}
	public PaymentHistoryPage navigateDirectToPaymentHitorypage() {

		if (MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.contains("prod") || MRScenario.environment.equalsIgnoreCase("offline")) {
	    System.out.println("Member auth agent is on the Dashboard page");
	    System.out.println(driver.getCurrentUrl());
	    
	  if (driver.getCurrentUrl().contains("/dashboard")) {
	    System.out.println("Member auth agent is on the Dashboard page");
		CommonUtility.waitForPageLoad(driver, makeapayment, 9);
		if (validate(makeapayment)) {
			makeapayment.click();
		
			} else if (driver.getCurrentUrl().contains("/dashboard")) {
				try {
					if (iPerceptionPopUp.isDisplayed()) {
						iPerceptionPopUp.click();
					}
				} catch (Exception e) {
					System.out.println("iPerception Pop Up not displayed");
				}

				validateNew(makeapayment,0);
				makeapayment.click();				
			}
		} else {
			System.out.println(
					"This script is only intended to be run using test harness");
		}
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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

	public PaymentHistoryPage navigatePaymentHistoryPage1() {
		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}
       // clicking on make a payment tile on the dash board
		waitforElement(makeapayment);
		//System.out.println("payment link is displayed on the header");
		makeapayment.click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
				
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (PaymentHeading.getText().contains("Premium Payments Overview")) {
			System.out.println("Payment Overview page displayed");
			return new PaymentHistoryPage(driver);
		} else {
			System.out.println("payment overview page not displayed");
			return null;
		}
	}

	public ClaimsSummaryPage navigateToClaimsSummaryPage1() {
		
		if (MRScenario.environment.equals("prod") || MRScenario.environment.equals("offline")) {
			System.out.println("user is on '" + MRScenario.environment + "' login page");
			if (driver.getCurrentUrl().contains("/dashboard")) {
				System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
				
					if (validate(claimsDashboardLink1)) {						
						System.out.println(" ********** Claims Tile Loacted on dashboard *******");
						claimsDashboardLink1.click();
					} else {
						System.out.println("claims tile not located on the member auth dashboard");
							}
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				CommonUtility.checkPageIsReadyNew(driver);
				checkForIPerceptionModel(driver);
				try {
					EOBLINK.click(); 					
					System.out.println("*** EOB Link  clicked ***");
					//agentstatusReady.click();
					//System.out.println("*** agent status clicked ***");
					// if status is ready then login as member 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("*** EOB LINK not clicked ***");
					e1.printStackTrace();
				//	System.out.println("*** agent not 2 clicked ***");
				}
				
				 if (EOBHeading.getText().contains("Explanation of Benefits")) {
				  System.out.println("EOB page Loaded");
				  return new
				  ClaimsSummaryPage(driver); } 
				 else 
				 {					 
				  System.out.println("EOB  page not Loaded");
				  }		 
				
					return null;
	}	
			
}
		return null;
	}

}