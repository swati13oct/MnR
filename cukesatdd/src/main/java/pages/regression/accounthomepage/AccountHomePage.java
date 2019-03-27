package pages.regression.accounthomepage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
//import pages.member.redesign.ContactUsPage;
import pages.member.ulayer.OneTimePaymentsPage;
import pages.member.ulayer.PlanComparePage;
import pages.member.ulayer.Rallytool_Page;
import pages.member.ulayer.TestHarness;
import pages.regression.IDCardPage.IDCardPage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.claims.ClaimDetailsPage;
import pages.regression.claims.ClaimSummarypage;
//import pages.regression.claims.ClaimSummarypage;
import pages.regression.contactus.ContactUsPage;
import pages.regression.drugcostestimator.DrugCostEstimatorPage;
import pages.regression.explanationofbenefits.EOBPage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import pages.regression.ordermaterials.OrderMaterialsPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.pharmacylocator.PharmacySearchPage;
//import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;

public class AccountHomePage extends UhcDriver {

	@FindBy(xpath = "//h2[@class='ng-scope' and @translate='FUTURE_MESSAGE_COVERAGE_START']")
	private WebElement preEffectiveMessage;

	@FindBy(id = "plan_material_fnr2018")
	private WebElement PlanMaterialSection;

	@FindBy(xpath = "//table[@class='componentTable']/tbody/tr/td/a[contains(.,'Contact Us')]")
	private WebElement contactUsPageLink;

	//@FindBy(css = ".view-id-link")
	@FindBy(xpath = "//*[@id='dashboard']/div[1]/section[1]/account-info/div/div/a/span[1]")
	private WebElement idCardLink;

	@FindBy(xpath = "(//*[@class='ng-scope']//a[text()='Premium Payments'])[1]")
	private WebElement paymentsLink;

	@FindBy(xpath = "(//a[contains(text(),'Payments Page')])")
	private WebElement TestHarnesspaymentsLink;

	@FindBy(xpath = "//*[@id='premiumpayment_3']")
	private WebElement paymentsLink3; // after clicking benefit and coverage page this is the link for payment history

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

	//@FindBy(xpath = "//div[@class='claim-results']//table[not (contains(@class,'ng-hide'))]//tbody//tr[2]//a[text()='MORE INFO']")
	//@FindBy(xpath = "//a[contains (text(), 'MORE INFO')]")
	@FindBy(xpath = "//*[@id='moreInfoLinkAtdd0']/a")
	private WebElement claimstablemoreinfolinkCombo;

	@FindBy(id = "pcpLogoPrint1left")
	private WebElement validateLogo;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/h1")
	private WebElement paymentsHeading;

	@FindBy(xpath = ".//*[@id='plan_box']/div/div[2]/div/p/a")
	private WebElement planNameLink;

	//@FindBy(id = "dropdown-toggle--1")
	@FindBy(id = "accountProfile")											 
	private WebElement accountProfileBtn;

	// @FindBy(xpath = ".//*[@id='dropdown-options--1']/a[contains(text(),'Account
	// Settings')]")
	@FindBy(linkText = "Account Settings")
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

	//@FindBy(id = "payment-date")
	@FindBy(xpath ="//*[@id='menubutton']")
	private WebElement HistoryDropdown;

	@FindBy(xpath = "(//*[@id='paymentTable'])[1]")
	private WebElement HistoryTable;

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
	//@FindBy(xpath = "//div[@class='claim-results']//tbody//tr[2]//td//span[@id='moreInfoLinkAtdd0']")
	@FindBy(xpath = "//a[contains (text(), 'MORE INFO')]")
	private WebElement claimstablemoreinfolink;

	@FindBy(css = ".claimDetTableMainSection")
	private WebElement claimDetTableMainSection;

	@FindBy(xpath = "//*[@id='dashboard']//span[text()='View Your Claims']")
	//@FindBy(xpath = "//*[@id='claims_1']") @FindBy(xpath = "//a[text()='Go to Claims page']")
	private WebElement claimsDashboardLink;

	//note: for workaround if getting 'Sorry' error, go to account setting then go to claims
	@FindBy(xpath = "//a[@id='claims_1']")
	private WebElement claimsWorkAround;

	
	@FindBy(xpath = "//*[@id='row2link1']/td[2]/a")
	private WebElement claimsTestharnessLink;

	@FindBy(xpath = "//*[@id='row2link6']/td[2]/a")
	private WebElement dceTestharnessLink;

	@FindBy(xpath = "//*[@id='row2link10']/td[2]/a")
	private WebElement eobTestharnessLink;	

	@FindBy(xpath = "//span[contains (text(), 'Look up Drugs')]")
	private WebElement drugLookup;

	// @FindBy(css = "img.primary-logo")
	// private WebElement logoImage;

@FindBy (css = ".container .primary-logo")
	private WebElement logoImage;								  																				  

	@FindBy(css = ".container .secondary-logo")
	private WebElement cologoImage;

	@FindBy(xpath = "//*[@ng-src='/images/icons/icon-pharmacy-locator.svg']")
	private WebElement pharmacySearchLink;

	// for Header
	@FindBy(id = "premiumpayment_3")
	private WebElement premiumPayment;

	@FindBy(id = "paymentOverviewApp")
	public static WebElement paymentsOverview;

	@FindBy(linkText = "FIND CARE & COSTS")
	private WebElement findCareCost;

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

	//@FindBy(xpath = ".//header[@class='hide-mobile']//a[contains(text(),'Coverage & Benefits')]")
	@FindBy(xpath ="//header//*[contains(text(),'Coverage & Benefits')]")
	private WebElement coverageBenefitsDashboard;

	//@FindBy(xpath = ".//header[@class='hide-mobile']//a[contains(text(),'Claims')]")
	@FindBy(xpath = "//header//*[contains(text(),'Claims')]")
	private WebElement claimsDashboard;

	//@FindBy(className = "help-link")
	@FindBy(xpath = "//header//*[contains(text(),'Help')]")
	private WebElement helpDashboard;

	@FindBy(xpath = ".//header[@class='hide-mobile']//a[contains(text(),'Find Care & Costs')]")
	private WebElement dashboardFindCare;

	// Added by Sneha - Navigate to Order Plan Materials
	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement OrderMaterial_Dashboard;

	@FindBy(id = "hello-person")
	private WebElement helloPerson;
	@FindBy(xpath = "//*[@id='dashboard']/div[1]/section[1]/account-info/div/div[1]/h1")
	private WebElement welcome;

	@FindBy(xpath = "//*[@id='ordermaterials']")
	private WebElement OrderMaterialsTab_BnCPage;

	@FindBy(xpath = "//*[@class = 'main-heading margin-none']")
	private WebElement orderplanHeadertxt;

	//@FindBy(xpath = "//*[@class='tabs-desktop']//li[@role='listitem'][2]/a")
	@FindBy(xpath ="//*[@class='tabs-desktop']//a[contains(.,'Medicare Supplement Insurance Plan')]")
	private WebElement ShipTab;

	@FindBy(xpath = "//*[@class='table-body margin-large']/div[2]//p")
	private WebElement PayDate;

	//@FindBy(xpath = ".//*[@id='cltotshipindsnf']")
	@FindBy(xpath = "//*[@id='cltotshippartb']/div/div[1]/div/div/div/div/div[1]/div/p")
	private WebElement claimtotalcomb;

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;
	
	/*@FindBy(xpath ="//*[@id='paymentHistoryApp1']//div/p/span")
	private WebElement PaymentHistorySection;*/
	@FindBy(xpath ="//*[@id='paymentHistoryApp1']//div//div[@class='col-md-12']/h2")
	private WebElement PaymentHistorySection;

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
		//initialize this in case need to workaround later due to Sorry login error for certain testing
		attemptSorryWorkaround=new HashMap<String,String>();
		attemptSorryWorkaround.put("needWorkaround", "no");
		attemptSorryWorkaround.put("planType", "na");
		attemptSorryWorkaround.put("testType", "na");

		// openAndValidate();
	}

	public AccountHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//initialize this in case need to workaround later due to Sorry login error for certain testing
		attemptSorryWorkaround=new HashMap<String,String>();
		attemptSorryWorkaround.put("needWorkaround", "no");
		attemptSorryWorkaround.put("planType", "na");
		attemptSorryWorkaround.put("testType", "na");
		/*
		 * try {
		 * 
		 * if (iPerceptionPopUp.isDisplayed()) { iPerceptionPopUp.click(); }
		 * }catch(Exception e) { System.out.println("iPerception Pop Up not displayed");
		 * }
		 */
		// openAndValidate();
	}

	public BenefitsAndCoveragePage navigateDirectToBnCPag(String Plantype) {

		if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
			if (Plantype.equalsIgnoreCase("MAPD") || Plantype.equalsIgnoreCase("PDP")
					|| Plantype.equalsIgnoreCase("HIP") || Plantype.equalsIgnoreCase("MA")
					|| Plantype.equalsIgnoreCase("MAPDRX") || Plantype.equalsIgnoreCase("MAPDVill")) {
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
					CommonUtility.waitForPageLoad(driver, heading, 30);
					if (driver.getTitle().contains("Benefits")) {
						System.out.println(driver.getTitle());
						return new BenefitsAndCoveragePage(driver);
					}

				}
			}

			else if (Plantype.equalsIgnoreCase("MEDICA")) {
				System.out.println("user is on Stage login page.");
				// CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);
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
				// CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);
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
		}

		else if (MRScenario.environmentMedicare.equals("team-h") || MRScenario.environmentMedicare.equals("test-a")
				|| MRScenario.environmentMedicare.equals("team-e") ||  MRScenario.environmentMedicare.equals("team-c")){

			driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
			System.out.println(driver.getCurrentUrl());
		} else {
			if(Plantype.equalsIgnoreCase("PCP")) {driver.navigate().to("https://" + MRScenario.environmentMedicare
					+ "-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");}
			else if (Plantype.equalsIgnoreCase("MEDICA")) {driver.navigate().to("https://" + MRScenario.environmentMedicare
					+ "-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");}
				else {
				driver.navigate().to(
						"https://" +MRScenario.environmentMedicare+"-medicare.ose-elr-core.optum.com/content/medicare/member/benefits/overview.html");
				}
		}
		CommonUtility.waitForPageLoad(driver, heading, 50);
		/*if (driver.getTitle().equalsIgnoreCase("Benefits")) {
			return new BenefitsAndCoveragePage(driver);
		}
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

	public BenefitsAndCoveragePage navigateToBandCPage() {
		System.out.println("Checking for Welcome or Hello on Dashboard home page now");
	  try{
		if(helloPerson.isDisplayed()){
			System.out.println("Hello PersonName on Dashboard home page was found");
		} else{
			waitForHomePage(welcome);
			System.out.println("Welcome on Dashboard home page was found");
		}	} catch	(Exception e){
			waitForHomePage(welcome);
			System.out.println("Welcome on Dashboard home page was found");
			
		}		
		if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
			System.out.println("User is on Stage environment");

			if (driver.getCurrentUrl().contains("/dashboard"))
				;
			{
				System.out.println("User is on dashboard page and URL is ==>" + driver.getCurrentUrl());
				driver.findElement(By.xpath("//a[contains(text(),'Coverage & Benefits')]")).click();
				System.out.println("Now waiting for 10 seconds");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Current URL is " + driver.getCurrentUrl());
				if (driver.getTitle().contains("Benefits")) {
					System.out.println("Title of Current Page is " + driver.getTitle());
					return new BenefitsAndCoveragePage(driver);
				}

			}
		}

		else if (MRScenario.environmentMedicare.equals("team-h") || MRScenario.environmentMedicare.equals("test-a")
				|| MRScenario.environmentMedicare.equals("team-e")) {

			driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
			System.out.println(driver.getCurrentUrl());
		} else {
			driver.navigate().to(
					"https://team-ci1-medicare.ose-elr-core.optum.com/content/medicare/member/benefits/overview.html");

			System.out.println(driver.getCurrentUrl());
		}

		CommonUtility.waitForPageLoad(driver, heading, 50);
		if (driver.getTitle().equalsIgnoreCase("Benefits Overview")) {
			return new BenefitsAndCoveragePage(driver);
		}

		return null;
	}

	public ProfileandPreferencesPage navigateDirectToProfilePage() throws InterruptedException {

			System.out.println("waitning for profile page");
		// If we test through test harness , this is needed to navigate to profile page
 	
			if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)){
			 System.out.println("testing through test harness page");
			 try{
				 if(driver.findElement(By.id("accountprofile")).isDisplayed()){
					 driver.findElement(By.id("accountprofile")).click();
					 driver.findElement(By.linkText("Account Settings")).click();
				 }else{
					 driver.findElement(By.xpath("//*[@id='home_2']")).click();
					 Thread.sleep(6000);
				 }
			 } catch (Exception e) {
				 driver.findElement(By.xpath("//*[@id='home_2']")).click();
				 Thread.sleep(6000);
			 }
			 if (driver.getCurrentUrl().contains("profile")) {
				 System.out.println("Navigating to Profile Page");
				 return new ProfileandPreferencesPage(driver);
			 }
			 
			//CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//*[@id='dashboard']/div[1]/section[1]/account-info/div/div[1]/h1")), 30);
		} else{
			System.out.println("test is through stage");
		}									  																													
		if (MRScenario.environment.equalsIgnoreCase("stage")) {
			System.out.println("user is on Stage login page");
			// CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);
			if (driver.getCurrentUrl().contains("/dashboard")) {

				/*
				 * accountToggleDropdown.click(); validate(accountSettingOption);
				 * accountSettingOption.click(); try { Thread.sleep(3000); } catch
				 * (InterruptedException e) { // TODO Auto generated catch block
				 * e.printStackTrace(); }
				 */
				// driver.navigate().to(PAGE_URL + "medicare/member/account/profile.html");
				waitforElement(accountProfileBtn);
				accountProfileBtn.click();
				accountSettingOption.click();
				System.out.println("title is " + driver.getTitle());
				System.out.println("Current Url is " + driver.getCurrentUrl());
			}
			else if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
				workaroundAttempt("profilepref");
			}
			Thread.sleep(6000);	   
			//CommonUtility.waitForPageLoad(driver, heading, 10);

			if (driver.getCurrentUrl().contains("profile")) {
				return new ProfileandPreferencesPage(driver);
			} 
			return null;



		} else if (MRScenario.environment.equals("team-ci1") || MRScenario.environment.equals("team-h")
				|| MRScenario.environment.equals("test-a") || MRScenario.environment.equals("team-e")
				|| MRScenario.environment.equals("stage")) {

			driver.navigate().to(PAGE_URL + "medicare/member/account/profile.html");

			System.out.println("title is " + driver.getTitle());
			System.out.println("Current Url is " + driver.getCurrentUrl());

		} else {
			driver.navigate().to(
					"https://team-ci1-medicare.ose-elr-core.optum.com/content/medicare/member/account/profile.html");
			System.out.println("title is " + driver.getTitle());
			System.out.println("Current Url is " + driver.getCurrentUrl());

		}
		//CommonUtility.waitForPageLoad(driver, heading, 50);
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

	public ProfileandPreferencesPage navigateDirectToProfilePageHsid() throws InterruptedException {
		// TODO Auto-generated method stub
		if (MRScenario.environment.equalsIgnoreCase("stage")) {
			System.out.println("user is on Stage login page");
			// CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);
			if (driver.getCurrentUrl().contains("/dashboard"))
				;
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
		CommonUtility.waitForPageLoad(driver, heading, 5);
		if (driver.getTitle().contains("Profile")) {
			System.out.println("here");
			return new ProfileandPreferencesPage(driver);
		}

		return null;

	}

	public void verifyPageTitle() throws InterruptedException {
		 System.out.println("Checking for Hello Name element after waiting for 20 seconds");
		 Thread.sleep(20000);
         waitForHomePage(helloPerson);
         System.out.println("Hello Name element was displayed");
  String title = driver.getTitle();
  System.out.println(title);
  Assert.assertTrue(title.contains("UnitedHealthcare"));
  System.out.println("Assert condition on title of dashboard page was passed");

		
		
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
		//tbd		waitforElement(PremiumPayment);
		//tbd		System.out.println("payment link is displayed on the header");
		//tbd		PremiumPayment.click();
		//tbd		try {
		//tbd			Thread.sleep(10000);
		//tbd		} catch (InterruptedException e) {
		//tbd			e.printStackTrace();
		//tbd		}
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

		//tbd Thread.sleep(16000);

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

		waitforElement(ShipTab);
		System.out.println("Ship tab loaded");
		ShipTab.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

		//tbd		Select dateRange = new Select(HistoryDropdown);
		//tbd		dateRange.selectByVisibleText("Last 6 months");

		// note: need to mouse over to select
		System.out.println("Payment History Exists");
		jse.executeScript("window.scrollBy(0,-1100)", "");
		
		return new pages.regression.payments.PaymentHistoryPage(driver);
	}
	
	public pages.regression.payments.PaymentHistoryPage scrollDownAndUp() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,550)", "");

		waitforElement(HistoryDropdown);

		//tbd		Select dateRange = new Select(HistoryDropdown);
		//tbd		dateRange.selectByVisibleText("Last 6 months");

		// note: need to mouse over to select
		Actions builder = new Actions(driver);
		WebElement last6Month=driver.findElement(By.xpath("//*[@id='menu2']/li[2]/a"));
		builder.moveToElement(HistoryDropdown).perform();
		builder.click(last6Month);

		Thread.sleep(6000);

		try {
			if (HistoryTable.isDisplayed()) {
				System.out.println("Payment History Exists");
				jse.executeScript("window.scrollBy(0,-1100)", "");
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			System.out.println("History table not present for this member");

		}

		jse.executeScript("window.scrollBy(0,-1000)", "");
		Thread.sleep(5000);

		return new pages.regression.payments.PaymentHistoryPage(driver);
	}

	public ContactUsPage navigateToContactUsPage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			feebackpopupClose();
			if (MRScenario.environmentMedicare.equals("team-ci1") || MRScenario.environmentMedicare.equals("team-h")
					|| MRScenario.environmentMedicare.equals("test-a")
					|| MRScenario.environmentMedicare.equals("team-e")) {
				js.executeScript("arguments[0].click();", helpAndContactUslink);

			} else if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
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
					linkContactUs.click();
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

	public pages.dashboard.member.ulayer.PaymentHistoryPage changeUrlToNewPaymentHistoryPage() {

		String NewPayHistoryUrl = "content/dashboard/home/Payments.html";

		String url = driver.getCurrentUrl();
		url = url.replace("home/my-account-home.html", NewPayHistoryUrl);

		driver.get(url);
		// System.out.println("testing2");
		if (paymentsHeading.getText().contains("Premium Payments Overview")) {

			return new pages.dashboard.member.ulayer.PaymentHistoryPage(driver);

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
		CommonUtility.waitForPageLoad(driver,logoImage,30); 
        String logo_src = logoImage.getAttribute("src");
        String logo_alt = logoImage.getAttribute("alt");
        System.out.println("Actual logo's source on Dashboard page is   "+logo_src+" and Expected logo source    "+logoToBeDisplayedOnDashboard+" .");   
        System.out.println("logo's alt text on Dashboard page is   "+logo_alt);           
        Assert.assertTrue(logo_src.contains(logoToBeDisplayedOnDashboard));
        System.out.println("Dashboard page Primary logo assert condition is passed");
	}

	public void validateCoLogoImagePresent(String cologoToBeDisplayedOnDashboard) throws InterruptedException {
		CommonUtility.waitForPageLoad(driver,cologoImage,30);
		String cologo_src = cologoImage.getAttribute("src");
		String cologo_alt = cologoImage.getAttribute("alt");
		System.out.println("Actual cologo's source on Dashboard page is   " + cologo_src
				+ " and Expected cologo source    " + cologoToBeDisplayedOnDashboard + " .");
		System.out.println("cologo's alt text on Dashboard page is   " + cologo_alt);
		Assert.assertTrue(cologo_src.contains(cologoToBeDisplayedOnDashboard));
		System.out.println("Dashboard page cologo assert condition is passed");
	}

	public ClaimSummarypage navigateToClaimsSummaryPage() {

		if (MRScenario.environmentMedicare.equalsIgnoreCase("team-h")
				|| MRScenario.environmentMedicare.equalsIgnoreCase("test-a")
				|| MRScenario.environmentMedicare.equalsIgnoreCase("team-a")
				|| (MRScenario.environmentMedicare.equalsIgnoreCase("team-t")
						|| MRScenario.environment.equalsIgnoreCase("team-ci1"))) {
			System.out.println("Go to claims link is present "
					+ driver.findElement(By.xpath("//a[text()='Go to Claims page']")).isDisplayed());
			driver.findElement(By.xpath("//a[text()='Go to Claims page']")).click();
			return new ClaimSummarypage(driver);
		} else if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
			System.out.println("user is on Stage login page");
			if (driver.getCurrentUrl().contains("/dashboard"))
			{
				System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
				if(MRScenario.isTestHarness.equals("YES")){
					claimsTestharnessLink.click();
				}else{
					claimsDashboardLink.click();
				}
				try {
					Thread.sleep(10000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			else if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
				workaroundAttempt("claims");
			}
			return new ClaimSummarypage(driver);

		} else {
			System.out.println(
					"This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");
		}
		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			try {
				Thread.sleep(10000);
				ClaimSummarypage comboTab = new ClaimSummarypage(driver).comboTabSelection();
				comboTab.comboTabSelection();

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		return null;
	}

	public ClaimDetailsPage navigateToClaimDetailsPage() {

		try {
			//	feebackpopupClose();
			//driver.switchTo().defaultContent();
			// CommonUtility.waitForPageLoad(driver, claimstablemoreinfolink, 60);
			// Thread.sleep(20);
			validate(claimstablemoreinfolink);
			System.out.println("more info link is seen for  ===>" + claimstablemoreinfolink.isDisplayed());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", claimstablemoreinfolink);

			// claimstablemoreinfolinkCombo.click();
			//CommonUtility.waitForPageLoad(driver, claimtotalcomb, 30);
			System.out.println(driver.getTitle());
			// System.out.println("*** Combo Member is on Claims Details Page ***");
			if (driver.getTitle().equalsIgnoreCase("Claims Summary")) {
				System.out.println("*** Claims Details Page ***");

			}
		} catch (Exception ex) {
			return null;
		}

		return new ClaimDetailsPage(driver);
	}

	public PharmacySearchPage navigateToRedesignPharmacyLocaterPage() {
		//tbd waitForHomePage(helloPerson);
		/*
		 * if (validate(iPerceptionAutoPopUp)) { iPerceptionAutoPopUp.click(); } else {
		 * System.out.println("iPerception Pop Up not displayed"); }
		 */
		checkForIPerceptionModel(driver);
		if (MRScenario.environmentMedicare.equalsIgnoreCase("test-a")
				|| MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			waitForHomePage(helloPerson);
			System.out.println("Go to Pharmacy locator is present " + pharmacySearchLink.isDisplayed());
			pharmacySearchLink.click();
		} else if (MRScenario.environment.equalsIgnoreCase("team-a")) {
			String Page_URL = "https://www." + MRScenario.environment
					+ "-medicare."+MRScenario.domain+"/content/medicare/member/pharmacy-locator/overview.html";
			if (driver.getCurrentUrl().contains("mymedicareaccount")) {
				System.out.println("This is a case for PCP or MEDICA user, use special URL");
				Page_URL= "https://www."+MRScenario.environment
						+"-mymedicareaccount."+MRScenario.domain+"/content/medicare/member/pharmacy-locator/overview.html";
			} 
			System.out.println("URL for testing: "+Page_URL);
			driver.navigate().to(Page_URL);
		} else if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
			if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
				workaroundAttempt("pharmacylocator");
			} else {
				waitForHomePage(helloPerson);
				if (driver.getCurrentUrl().contains("/dashboard")) {
					System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
					pharmacySearchLink.click();
					try {
						Thread.sleep(10000);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		// waitForHomePage(helloPerson);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if (validate(iPerceptionAutoPopUp)) {
			iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
		if (MRScenario.environmentMedicare.equalsIgnoreCase("team-a")
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
					&& !memberType.toLowerCase().contains("medica")) && (!planType.toLowerCase().contains("pcp")
							&& !planType.toLowerCase().contains("medica")))) {
				System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
				// Thread.sleep(2000);
				driver.navigate().to(PAGE_URL + "aarp/member/documents/overview.html");
				// https: // stage-mymedicareaccount.uhc.com/pcp/member/documents/overview.html
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
			else if ((driver.getCurrentUrl().contains("mymedicareaccount"))&& (memberType.toLowerCase().contains("pcp") || planType.toLowerCase().contains("pcp")))

			{

				System.out.println("User is on pcp dashboard page and URL is ====>" + driver.getCurrentUrl());
				// Thread.sleep(2000);
				driver.navigate().to("https://stage-mymedicareaccount.uhc.com/pcp/member/documents/overview.html");

				System.out.println(driver.getCurrentUrl());
				try {

					wait.until(ExpectedConditions.titleContains("Documents"));

				} catch (Exception e) {
				}
				// CommonUtility.waitForPageLoad(driver, PlanMaterialSection, 20);
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
				// CommonUtility.waitForPageLoad(driver, PlanMaterialSection, 20);
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
				// CommonUtility.waitForPageLoad(driver, PlanMaterialSection, 20);
				if (driver.getTitle().contains("Documents & Resources")) {
					System.out.println(driver.getTitle());
				}

			}

			/*
			 * else if (driver.getCurrentUrl().contains("/medica/dashboard"))
			 * 
			 * {
			 */
			else if ((driver.getCurrentUrl().contains("mymedicareaccount"))&& (memberType.toLowerCase().contains("medica") || planType.toLowerCase().contains("medica")))

			{

				System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
				// Thread.sleep(2000);
				driver.navigate().to("https://stage-mymedicareaccount.uhc.com/medica/member/documents/overview.html");
				System.out.println(driver.getCurrentUrl());
				try {

					wait.until(ExpectedConditions.titleContains("Documents"));

				} catch (Exception e) {
				}
				// CommonUtility.waitForPageLoad(driver, PlanMaterialSection, 20);
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

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.elementToBeClickable(paymentslink));
		 */
		try {
			System.out.println("iPerception Pop Up is Present");
			driver.switchTo().frame("IPerceptionsEmbed");
			iPerceptionCloseButton.click();
			// driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		Thread.sleep(6000);

		if (validate(paymentsLink)) {

			System.out.println("payment link is displayed on the header");
			paymentsLink.click();
			return new PaymentHistoryPage(driver);
		} 
		else if (validate(TestHarnesspaymentsLink)) {

			System.out.println("TestHarness Page Payments Link is displayed");
			TestHarnesspaymentsLink.click();
			return new PaymentHistoryPage(driver);
		} else {
			//tbd		System.out.println("payment link is not displayed on the header");  // when in future date
			//tbd		coverageBenefits.click();

			// NOTE:
			// work-around, when Home, data maintained by Rally, is out of sync, payment tab may not show
			// go to secondary page first then locate the payment tab.
			System.out.println("payment link is not displayed on the dashboard header - attempt the workaround"); 
			try {
				String Page_URL = "https://" + MRScenario.environment
						+ "-medicare.uhc.com/aarp/member/payments/overview.html";
				//String Page_URL = driver.getCurrentUrl().split(".com")[0];
				driver.navigate().to(Page_URL);
			} catch (Exception e1) {
				try {
					coverageBenefits.click();
				} catch (NoSuchElementException e) {
					dashboard_coverageBenefits.click();
				}
				WebDriverWait wait = new WebDriverWait(driver, 30);
				paymentsLink3.click(); 
			}
			System.out.println("Navigated to Payments Overview Page URL : " +driver.getCurrentUrl());
			return new PaymentHistoryPage(driver); 

		}

		//tbd		 else{ CoverageAndBenefits.click();
		//tbd		 
		//tbd		 WebDriverWait wait = new WebDriverWait(driver, 30);
		//tbd		 wait.until(ExpectedConditions.elementToBeClickable(paymentslink));
		//tbd		 
		//tbd		 validate(paymentslink); paymentslink.click(); return new
		//tbd		 PaymentHistoryPage(driver); }
		//tbd		
		//tbd return new PaymentHistoryPage(driver);
	}

	/*
	 * Added by Sneha - To Navigate to Order plan Materials page by clicking on link
	 * in Rally Dashboard
	 * 
	 */
	public OrderMaterialsPage navigateToOrderPlanMaterialsPage() throws InterruptedException {

		CommonUtility.checkPageIsReady(driver);
		if (validate(OrderMaterial_Dashboard)) {
			System.out.println("Order Materials link found on dashboard");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", OrderMaterial_Dashboard);
			// OrderMaterial_Dashboard.click();
		} else {
			if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
				workaroundAttempt("order");
			} else {
				String Page_URL="";
				if (MRScenario.environment.equalsIgnoreCase("team-a")) {
					Page_URL = "https://www." + MRScenario.environment
							+ "-medicare."+MRScenario.domain+"/content/medicare/member/order-materials/overview.html";
				} else {
					Page_URL = "https://" + MRScenario.environment
							+ "-medicare."+MRScenario.domain+"//member/order-plan-materials.html";
				}
				
				// String Page_URL = driver.getCurrentUrl().split(".com")[0];
				driver.navigate().to(Page_URL);
				System.out.println("Navigated to Order materials Page URL : " + Page_URL);
			}
			
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReady(driver);
		// CommonUtility.waitForPageLoadNew(driver, orderplanHeadertxt, 30);
		if (orderplanHeadertxt.isDisplayed()) {
			return new OrderMaterialsPage(driver);
		}
		return null;
	}

	public EOBPage navigateDirectToEOBPag() {
		if (MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			driver.findElement(By.xpath("//a[text()='Eob']")).click();

		} else if (MRScenario.environment.equalsIgnoreCase("stage")) {

			if(MRScenario.isTestHarness.equals("YES")){
				eobTestharnessLink.click();
			}else if (driver.getCurrentUrl().contains("/dashboard")){
				try {
					if (iPerceptionPopUp.isDisplayed()) {
						iPerceptionPopUp.click();
					}
				} catch (Exception e) {
					System.out.println("iPerception Pop Up not displayed");
				}

				//validate(medicalEobLink);
				/*if(medicalEobLink.isDisplayed()){
				medicalEobLink.click();
				}else{ */
					//scrollToView(medicalEobLinkOther);
				  //medicalEobLinkOther.click();
				//}
				
				 startNew("https://stage-medicare.uhc.com/member/eob.html");
			}
		} else {
			System.out.println(
					"This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");
		}



		return new EOBPage(driver);
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

			if(MRScenario.isTestHarness.equals("YES")){
				dceTestharnessLink.click();
			}else if (driver.getCurrentUrl().contains("/dashboard")){
				System.out.println("User is on dashboard page and URL is ====>" + driver.getCurrentUrl());
				waitforElement(drugLookup);
				drugLookup.click();
				try {
					WebElement loadingImage = driver.findElement(By.className("loading-dialog"));
					CommonUtility.waitForPageLoad(driver, loadingImage, 15);
				} catch (Exception e) {
					System.out.println("Exception e: "+e);
				}
			} else if (attemptSorryWorkaround.get("needWorkaround").equalsIgnoreCase("yes")) {
				workaroundAttempt("dce");
			}
		} else {
			System.out.println("This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");
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
		Assert.assertTrue("Find Care and Cost tab is not displayed", findCareCost.isDisplayed());

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
	public IDCardPage viewIDCard() {
		try {
			if (iPerceptionPopUp.isDisplayed()) {
				iPerceptionPopUp.click();
			}
		} catch (Exception e) {
			System.out.println("iPerception Pop Up not displayed");
		}

		if(driver.getCurrentUrl().contains("testharness")){
			driver.findElement(By.id("home_2")).click();
			CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//*[@id='dashboard']")), 10);											
		validate(idCardLink);
		idCardLink.click();
		return new IDCardPage(driver);
		} else{

			validate(idCardLink);
			idCardLink.click();
			return new IDCardPage(driver);}				  
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
		//waitforElement(drugLookup);
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
		Assert.assertTrue("Header is not displayed", header.isDisplayed());
		/**
		 * Wait till page is loaded button is enabled.
		 */

	}

	/**
	 * Validate claims Tab
	 */
	public void validateClaims() {
		Assert.assertTrue("Claims tab is not displayed", claims.isDisplayed());
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
			//claims.click();
			try {
				if (explainationOfBenefits.isDisplayed()) {
					explainationOfBenefits.click();
				}
			} catch (NoSuchElementException e) {
				System.out.println("can't locate explainationOfBenefits element, will try to click coverageBenefits then try again before giving up "+e);
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
		if (coverageBenefits.isDisplayed()) {
			coverageBenefits.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue("benefitsSummary is displayed", benefitsSummary.isDisplayed());
			Assert.assertTrue("formsAndResources is displayed", formsAndResources.isDisplayed());
			Assert.assertTrue("orderMaterials is displayed", orderMaterials.isDisplayed());
		}
	}

	/**
	 * click on Benefits Summary
	 */
	public void clickBenefitsSummary() {
		waitforElement(coverageBenefits);
		if (coverageBenefits.isDisplayed()) {
			try{
				//coverageBenefits.click();
				if (benefitsSummary.isDisplayed()) {
					benefitsSummary.click();
				}
			} catch (NoSuchElementException e) {
				System.out.println("can't locate benefitsSummary element, will try to click coverageBenefits then try again before giving up "+e);
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
				//coverageBenefits.click();
				if (formsAndResources.isDisplayed()) {
					formsAndResources.click();
				}
			} catch (NoSuchElementException e) {
				System.out.println("can't locate formsAndResources element, will try to click coverageBenefits then try again before giving up "+e);
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
			//coverageBenefits.click();
			try {
				if (orderMaterials.isDisplayed()) {
					orderMaterials.click();
				}
			} catch (NoSuchElementException e) {
				System.out.println("can't locate orderMaterials element, will try to click coverageBenefits then try again before giving up "+e);
				coverageBenefits.click();
				waitforElement(orderMaterials);
				if (orderMaterials.isDisplayed()) {
					orderMaterials.click();
				}
			}
		}
	}

	public void validateHelp() {
		Assert.assertTrue("Help tab is displayed", help.isDisplayed());
	}

	public void validateAccountProfile() {
		if (logOut.isDisplayed()) {
			Assert.assertTrue("Account/Profile tab is displayed", accountProfile.isDisplayed());
			clickAccountProfile();
			clickLogout();
		} else
			Assert.assertFalse("Account/Profile tab is not displayed", !accountProfile.isDisplayed());

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
		if (logOut.isDisplayed()) {
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

	public void feebackpopupClose() throws InterruptedException { // waitForloader(driver,overlay, 20);
		Thread.sleep(20000);
		if (validate(iPerceptionframe)) {

			switchToNewIframe(iPerceptionframe);
			iPerceptionclosebtn.click();
			driver.switchTo().defaultContent();
			// iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
	}

	public ClaimDetailsPage navigateToClaimDetailsPageCombo() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(claimstablemoreinfolinkCombo);
		System.out.println("more info link is seen for combo member ===>" + claimstablemoreinfolinkCombo.isDisplayed());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", claimstablemoreinfolinkCombo);

		// claimstablemoreinfolinkCombo.click();
		CommonUtility.waitForPageLoad(driver, claimtotalcomb, 30);
		System.out.println(driver.getTitle());
		// System.out.println("*** Combo Member is on Claims Details Page ***");
		if (driver.getTitle().equalsIgnoreCase("/details")) {
			System.out.println("*** Combo Member is on Claims Details Page ***");

		}
		return new ClaimDetailsPage(driver);
	}

	public BenefitsAndCoveragePage navigateDirectToBnCPag() {

		if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
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
				CommonUtility.waitForPageLoad(driver, heading, 30);
				if (driver.getTitle().contains("Benefits")) {
					System.out.println(driver.getTitle());
					return new BenefitsAndCoveragePage(driver);
				}

			}
		}

		else if (MRScenario.environmentMedicare.equals("team-h") || MRScenario.environmentMedicare.equals("test-a")){

			driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
			System.out.println(driver.getCurrentUrl());
		} else if(MRScenario.environmentMedicare.equals("team-c")){
			driver.navigate().to(
					"https://team-c-medicare.ose-elr-core.optum.com/content/medicare/member/benefits/overview.html");
			System.out.println(driver.getCurrentUrl());
			return new BenefitsAndCoveragePage(driver);
		}else if(MRScenario.environmentMedicare.equals("team-e")){
			jsClickNew(driver.findElement(By.xpath("//td[text()='benefits and coverage page ']/following::a[1]")));
			CommonUtility.waitForPageLoad(driver, heading, 30);
			System.out.println(driver.getCurrentUrl());
			return new BenefitsAndCoveragePage(driver);
		}else
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

	public BenefitsAndCoveragePage navigateToBandCPag() {

		if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
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

		else if (MRScenario.environmentMedicare.equals("team-h") || MRScenario.environmentMedicare.equals("test-a")
				|| MRScenario.environmentMedicare.equals("team-e")) {

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
	 * This method checks that Premium Payment tab is not displayed for
	 * Pre-Effective members
	 */
	public void validatePremiumPaymentTabNotDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Now checking for Premium Payment Tab on Dashboard");

		try {
			driver.findElement(By.xpath("//a[contains(text(),'Premium Payments')]"));
			System.out.println("Premium Payment tab was displayed on Dashboard");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			Assert.fail("Premium Payment tab was not displayed on Dashboard, Test Step is failed ");
		}

	}

	/*
	 * This method checks that correct pre-Effective message is displayed on
	 * Dashboard for Pre-Effective members
	 */
	public void validatePreEffectiveMessagePresent() throws InterruptedException {
		Thread.sleep(2000);
		String preMessage_text = preEffectiveMessage.getAttribute("innerText");
		System.out.println("Message displayed on Dashboard for this member is:" + preMessage_text);
		Assert.assertTrue(preMessage_text.contains(
				"Use this site to find helpful information while you�re getting ready for your plan to start on"));
		System.out.println("First assert on the preeffective message is passed");
		Assert.assertTrue(preMessage_text.contains(
				"Depending on your plan coverage, you can find a provider, locate a pharmacy, or view important plan documents."));
		System.out.println("Second assert on the preeffective message is passed");
	}

	public BenefitsAndCoveragePage clickOnBenefitsandCoverageTab() throws InterruptedException {
		System.out.println("Now clicking on Benefits and Coverage Tab on Dashboard");
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
					Thread.sleep(5000);
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



	//This method the dashboard when a pre effective member lands on the Home page 
	public void validateHomePage1() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println(" @@@ The title of the page is "+driver.getTitle());         
        if (getTitle().equalsIgnoreCase("Home | UnitedHealthcare")) {        	 
     	   System.out.println("On the dashboard ");            
        }
        System.out.println("@@@ The URL of the page is ==>" + driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains("https://member.int.uhc.com/aarp/dashboard"));
        System.out.println("Member is on the dashboard");
        validate(preEffectiveMessage);
        System.out.println("The pre-effective message fr the member on dashboard is ==>" +preEffectiveMessage.getText());
    	String preMessage_text = preEffectiveMessage.getText();
 	System.out.println("Message displayed on Dashboard for this member is:" + preEffectiveMessage);
 	Assert.assertTrue(preMessage_text.contains(
 			"Use this site to find helpful information while you’re getting ready for your plan to start on"));
 	System.out.println("Assert on the preeffective message is passed");

	}
    
	//vvv note: added for 'sorry' login error workaround	
	private HashMap<String,String> attemptSorryWorkaround;

	public HashMap<String,String> getAttemptSorryWorkaround() {
		return attemptSorryWorkaround;
	}

	public void setAttemptSorryWorkaround(HashMap<String,String> input) {
		attemptSorryWorkaround=input;
	}

	public void workaroundAttempt(String page) {
		System.out.println("======================== OK LET'S ATTEMPT THE 'SORRY' WORKAROUND  ===========================");
		//assumption this is the sorry error url, parse the URL to determine which URL to use
		String currentUrl=driver.getCurrentUrl();
		String[] tmp1=currentUrl.split(".com/");
		String[] tmp2=tmp1[1].split("/");
		String userType=tmp2[0];

		String part1="";
		if (attemptSorryWorkaround.get("planType").equalsIgnoreCase("pcp") || attemptSorryWorkaround.get("planType").equalsIgnoreCase("medica")) {
			part1="https://"+MRScenario.environmentMedicare+"-mymedicareaccount.uhc.com/";
		} else {
			part1="https://"+MRScenario.environmentMedicare+"-medicare.uhc.com/";
		}

		String part2=userType;

		String part3="";
		if (page.equals("claims")) {
			part3="/member/claims.html#/overview";
		} else if (page.equals("contactus")) {
			part3="/member/contact-us/overview.html#/contact-us-two";
		} else if (page.equals("profilepref")) {
			part3="/member/profile.html";
		} else if (page.equals("order")) { 
			part3="/member/order-materials/overview.html";
		} else if (page.equals("reward")) { 
			part3="/member/health-and-wellness.html";
		} else if (page.equals("pharmacylocator")) { 
			part3="/member/pharmacy-locator/overview.html";
		//} else if (page.equals("dce")) { 
		//	part3="/member/drug-lookup/overview.html#/drug-cost-estimator";
		} else {	//note: shouldn't have gotten here, but just in case
			Assert.assertTrue("Sorry, testType '"+attemptSorryWorkaround.get("testType")+"' is not covered by this workaround yet, abort this test now", false);
		}

		String workaroundURL=part1+part2+part3;
		if (page.equals("dce")) {
			// mimic testharness page
			workaroundURL="https://stage-medicare.uhc.com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator"; 
		}
		System.out.println("Workaround URL is going to be: "+workaroundURL);
		driver.get(workaroundURL);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//^^^ note: added for 'sorry' login error workaround	

}























