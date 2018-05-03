package pages.regression.accounthomepage;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.claims.ClaimSummarypage;
import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import pages.member.bluelayer.ProfilePreferencesPage;
import pages.member.redesign.ContactUsPage;
import pages.member.ulayer.OneTimePaymentsPage;
import pages.redesign.PaymentHistoryPage;
import pages.member.ulayer.PlanComparePage;
import pages.member.ulayer.Rallytool_Page;
import pages.member.ulayer.TestHarness;
import pages.redesign.PharmacySearchPage;


public class AccountHomePage extends UhcDriver {

	@FindBy(css = "a.fd_myPersonalHealthRecord")
	private WebElement phrTab;

	@FindBy(id = "plan_box")
	private WebElement planBox;

	@FindBy(linkText = "Order plan materials")
	private WebElement orderPlanMaterials;

	@FindBy(xpath = "//div[@class='myProfileMid']/div[1]/div/div[2]/h2")
	private WebElement myProfilesHeading;

	@FindBy(linkText = "estimate costs")
	private WebElement estimateCostLink;

	@FindBy(linkText = "Contact Us")
	private WebElement contactUsLink;

	@FindBy(linkText = "Plan Benefits")
	private WebElement benefitsLink;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(linkText = "Premium payment information")
	private WebElement paymentsLink;

	@FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_panelnav-planresources-main_links_jcr_content_par_teaser']/div/li/a")
	private WebElement formsAndResourcesLink;

	@FindBy(linkText = "My Profile & Preferences")
	private WebElement profAndPrefLink;

	@FindBy(xpath = "//*[@id='myshipplans']/a")
	private WebElement myPlansTab;

	@FindBy(linkText = "locate a pharmacy")
	private WebElement pharmacyLocator;

	@FindBy(linkText = "medical providers")
	private WebElement medicalProviders;

	@FindBy(xpath = "//li[@id='fd_myMenu']/a")
	private WebElement myMenuNavigator;

	@FindBy(linkText = "Prescription drug cost and benefits summary")
	private WebElement prescriptionDrugCostBenefitSummaryLink;

	@FindBy(linkText = "Search drug claims")
	private WebElement searchDrugClaims;

	@FindBy(linkText = "Search claim history")
	private WebElement searchClaimsHistory;

	@FindBy(linkText = "Search medical claims")
	// @FindBy(xpath =
	// ".//*[@id='_content_campaigns_uhcm_chunkyfooter-activitylinks-main_activitylinks-main_jcr_content_par_teaser']/div/li/a")//(linkText
	// = "Search medical claims")
	private WebElement searchMedicalClaims;

	@FindBy(linkText = "Medical Explanation of Benefits (EOB)")
	private WebElement medicalEobLink;

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

	@FindBy(id = "pcpLogoPrint1left")
	private WebElement validateLogo;

	@FindBy(xpath = "//a[contains(text(),'UnitedHealthcare MedicareComplete Choice (PPO)')]")
	private WebElement uhcMedicareCompleteChoicePPO;

	@FindBy(xpath = "//*[@id='healthwellness']/a")
	private WebElement healthAndWellnessTab;

	@FindBy(xpath = "html/body/div[3]/div/div[1]/header/div/div/div/div/div/div/p/a[2]")
	private WebElement backToPreviousPage;

	@FindBy(xpath = "//*[@id='gogreenmeter']/a")
	private WebElement goGreenLink;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/h1")
	private WebElement paymentsHeading;

	@FindBy(xpath = "//*[@id='gogreenlogin_box']/div[4]/div/a")
	private WebElement gogreenPopupClose;

	@FindBy(xpath = "//*[@id='gogreenlogin_box']/div[4]/div")
	private WebElement gogreenPopup;

	@FindBy(linkText = "My Documents")
	private WebElement MyDocumentLink;

	@FindBy(linkText = "Back to previous page")
	private WebElement backTopreviouspageLink;

	@FindBy(xpath = "//html/body/title")
	private WebElement newClaimsPageHeading;

	@FindBy(linkText = "View/Download")
	private WebElement viewanddownloadLink;

	@FindBy(xpath = "//*[@id='myDocuments']/div/div[2]/div/p[2]/ul/li[4]/a")
	private WebElement paginationLink;

	@FindBy(xpath = "//*[@id='myDocuments']/div/div[1]/div/form/div/div[2]/div[2]/div[2]/div[1]/div/input")
	private WebElement fromdate;

	@FindBy(xpath = "//*[@id='myDocuments']/div/div[1]/div/form/div/div[2]/div[2]/div[2]/div[2]/div/input")
	private WebElement todate;

	@FindBy(xpath = "//*[@id='myDocuments']/div/div[1]/div/form/div/div[2]/div[2]/div[2]/div[3]/button")
	private WebElement searchLink;

	@FindBy(linkText = "Date")
	private WebElement dateLink;

	@FindBy(xpath = ".//*[@id='plan_box']/div/div[2]/div/table/tbody/tr[3]/td[2]")
	private WebElement status;

	@FindBy(xpath = ".//*[@id='plan_box']/div/div[2]/div/table/tbody/tr[2]/td[2]")
	private WebElement memberId;

	@FindBy(xpath = ".//*[@id='plan_box']/div/div[2]/div/table/tbody/tr[1]/td[2]")
	private WebElement groupId;

	@FindBy(id = "_content_uhcm_home_my-account-home_jcr_content_contentPar_myresource_contentParResource_teaser")
	private WebElement myResource;

	@FindBy(linkText = "mental health or substance use")
	private WebElement MentalHealthOrSubstanceUse;

	@FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_2']/div/div[2]")
	private WebElement drugLookup;

	@FindBy(xpath = ".//*[@id='plan_box']/div/div[2]/div/p/a")
	private WebElement planNameLink;

	@FindBy(xpath = ".//*[@id='contentRow']")
	private WebElement homePageContent;

	@FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_2']/div/div[2]")
	private WebElement drugLookupBox;

	@FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_2']/div/div[2]/a/span")
	private WebElement estimateCostsBtn;

	@FindBy(xpath = ".//*[@id='contentRow']/td/table/tbody/tr/td/div/div[2]/div[3]/div[3]/div[2]")
	private WebElement myResourcesContent;

	@FindBy(xpath = "//*[@class='zip']/span[1]")
	private WebElement RallyZipcode;

	@FindBy(xpath = "//*[@id='IPEinvL']/map/area[3]")
	private WebElement closebtn;

	@FindBy(xpath = "//a[contains(text(),'Provider search')]")
	private WebElement providerSearchinPanelNavigation;

	@FindBy(xpath = "//a[contains(text(),'Medical Explanation of Benefits (EOB)')]")
	private WebElement medicalEOBLinkInPanelNavigation;

	@FindBy(id = "btn_searchforaprovider")
	private WebElement medicalEOBproviderlink;

	@FindBy(linkText = "Medical Explanation of Benefits (EOB)")
	private WebElement medicalEOBlink;

	@FindBy(id = "zipCode")
	private WebElement zipCode;

	@FindBy(id = "fd_myMenu")
	private WebElement myMenu;

	@FindBy(linkText = "Benefits and Coverage")
	private WebElement benefitsAndCoveragelink;

	@FindBy(xpath = "//button[@id='dropdown-toggle--1']/span[contains(text(),'Profile')]")
	private WebElement accountToggleDropdown;

	@FindBy(xpath = "//a[@class='dropdown-option' and contains(text(),'Account Settings')]")
	private WebElement accountSettingOption;

	@FindBy(xpath = "//header//h1")
	private WebElement heading;

	@FindBy(xpath = "//a[contains(text(),'Search for a provider')]")
	private WebElement providerlinkinPCPSection;

	@FindBy(css = "li#accountdetails>a")
	private WebElement accountHome;

	@FindBy(id = "widgetbuttoncontainer")
	private WebElement searchLinkinClaimsPage;

	@FindBy(id = "phr_widget_3")
	private WebElement showLink;

	@FindBy(xpath = "//div[@class='phr_greybox_mid']/p[contains(text(),'Looking for a doctor')]/following-sibling::p/a")
	private WebElement providerSearchinPHPage;

	// @FindBy(xpath="//*[@id='phr_widget_3_box']/div[233]/p[2]/a")
	// private WebElement providerSearchinPHPage1;

	// @FindBy(xpath="div[@class='phr_greybox_mid']/p[contains(text(),'Need to
	// find a facility?')]/following-sibling::p/a")
	// private WebElement providerSearchinPHPage1;

	@FindBy(xpath = "(//a[@id='btn_searchforaprovider'])[1]")
	private WebElement providerSearchinPHPage1;

	@FindBy(linkText = "Claims")
	private WebElement claimsLink;

	@FindBy(xpath = "(//a[contains(@href,'my-plans/forms-and-resources')])[4]")
	private WebElement FormsandResourcesLinkn;

	@FindBy(xpath = "//a[contains(text(),'search for providers')]")
	private WebElement searchforproviderlinkinClaimsPage;

	@FindBy(xpath = "//*[@id='btn_searchforaprovider']")
	private WebElement providerLink;

	@FindBy(xpath = "//a[@class='searchforproviders margin_top_5px']")
	private WebElement searchProviderinFormsandResourcePage;

	@FindBy(xpath = "//span[text()='search providers']")
	private WebElement searchProviderLinkinFormsandResourcePage;

	@FindBy(xpath = "html/body/div[2]/div/div[4]/div[2]/div/table/tbody/tr[4]/td[2]/a")
	private WebElement linkbenefit;

	@FindBy(xpath=".//*[@id='IPEinvL']/map/area[2]")
    private WebElement iPerceptionPopUp;
	
	@FindBy(xpath="//dashboard//a[contains(text(),'Contact')]")
	private WebElement linkContactUs;
	
	@FindBy(xpath="//a[contains(text(),'Contact Us page')]")
	private WebElement helpAndContactUslink;

	@FindBy(xpath = "//a[contains(text(),'Go to benefits and coverage page')]")
	private WebElement benefitcoveragelink;

	@FindBy(xpath = "html/body/div[2]/div/div[4]/div[2]/div/table/tbody/tr[6]/td[2]/a")
	private WebElement profilenpreferenceslink;

	@FindBy(linkText = "Go to profile page")
	private WebElement profilenpreferenceslink1;

	@FindBy(id = "authQuestiontextLabelId")
	private WebElement questionid;
	@FindBy(id = "challengeQuestionList[0].userAnswer")
	private WebElement securityAnswer;

	@FindBy(id = "continueSubmitButton")
	private WebElement continueButton;

	@FindBy(xpath = "//sticky[@id='sticky-nav']//nav[@id='main-nav']//a[contains(text(),'Coverage & Benefits')]")
	private WebElement BnClink;

	@FindBy(xpath = "//*[@id='IPEinvL']/map/area[3]")
	private WebElement iPerceptionAutoPopUp;

	@FindBy(xpath = "//*[@id='sticky-nav']//div[@ng-switch-when='M&R']/a[5]")
	private WebElement PremiumPayment;

	@FindBy(id = "payment-date")
	private WebElement HistoryDropdown;

	@FindBy(xpath = "(//*[@id='paymentTable'])[1]")
	private WebElement HistoryTable;

	@FindBy(xpath = "//*[@id='paymentOverviewApp']//div[@class='container']//div[@class='col-md-12']/h1")
	private WebElement PaymentHeading;
	
	@FindBy(linkText = "Compare 2017 Plans")
	private WebElement planCompareLink;
	
	@FindBy(xpath = "//div[@class='prefermain_mid mapd_div']/div/h3")
	private WebElement planCompareHeader;

	@FindBy(xpath=".//*[contains(text(),'search for providers')]")
	private WebElement searchForProviders;
	
	@FindBy(linkText = "Order drugs from your Preferred Mail Service Pharmacy")
	private WebElement drugPreferredMailServicePharmacyLink;
	
	@FindBy(xpath = "//div[@class='claim-results']//table[not (contains(@class,'ng-hide'))]//tbody//tr[2]//a[text()='MORE INFO']")
	private WebElement claimstablemoreinfolink;
  
	@FindBy (css = ".claimDetTableMainSection")
	private WebElement claimDetTableMainSection;
  
	@FindBy(xpath = "//*[@id='dashboard']//span[text()='View Your Claims']")
	private WebElement claimsDashboardLink;
	
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

		// openAndValidate();
	}

	public AccountHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// openAndValidate();
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
				System.out.println(driver.getCurrentUrl());
				CommonUtility.waitForPageLoad(driver, heading, 30);
				if (driver.getTitle().equalsIgnoreCase("Benefits Overview")) {
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

		CommonUtility.waitForPageLoad(driver, heading, 50);
		if (driver.getTitle().equalsIgnoreCase("Benefits Overview")) {
			return new BenefitsAndCoveragePage(driver);
		}

		return null;
	}

	public ProfileandPreferencesPage navigateDirectToProfilePage() throws InterruptedException {

		if (MRScenario.environment.equalsIgnoreCase("stage")) {
			System.out.println("user is on Stage login page");
			// CommonUtility.waitForPageLoad(driver, claimsDashboardLink, 90);
			if (driver.getCurrentUrl().contains("/dashboard"))
				;
			{

				/*
				 * accountToggleDropdown.click();
				 * validate(accountSettingOption); accountSettingOption.click();
				 * try { Thread.sleep(3000); } catch (InterruptedException e) {
				 * // TODO Auto generated catch block e.printStackTrace(); }
				 */
				driver.navigate().to(PAGE_URL + "medicare/member/account/profile.html");

				System.out.println("title is " + driver.getTitle());
				System.out.println("Current Url is " + driver.getCurrentUrl());
				CommonUtility.waitForPageLoad(driver, heading, 50);

				if (driver.getTitle().equalsIgnoreCase("Profile")) {

					return new ProfileandPreferencesPage(driver);
				}

			}
		}

		if (MRScenario.environment.equals("team-ci1") || MRScenario.environment.equals("team-h")
				|| MRScenario.environment.equals("test-a") || MRScenario.environment.equals("team-e")) {

			driver.navigate().to(PAGE_URL + "medicare/member/account/profile.html");

			System.out.println("title is " + driver.getTitle());
			System.out.println("Current Url is " + driver.getCurrentUrl());

		} else {
			driver.navigate().to(
					"https://team-ci1-medicare.ose-elr-core.optum.com/content/medicare/member/account/profile.html");
			System.out.println("title is " + driver.getTitle());
			System.out.println("Current Url is " + driver.getCurrentUrl());

		}
		CommonUtility.waitForPageLoad(driver, heading, 50);
		if (driver.getTitle().equalsIgnoreCase("Profile")) {
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

				accountToggleDropdown.click();
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
				CommonUtility.waitForPageLoad(driver, heading, 50);

				if (driver.getTitle().equalsIgnoreCase("Profile")) {

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
		CommonUtility.waitForPageLoad(driver, heading, 50);
		if (driver.getTitle().equalsIgnoreCase("Profile")) {
			System.out.println("here");
			return new ProfileandPreferencesPage(driver);
		}

		return null;

	}

	public void verifyPageTitle() throws InterruptedException {
		String title = driver.getTitle();
		// Assert.assertEquals(title, "Home | UnitedHealthcare");
		Assert.assertTrue(title.contains("UnitedHealthcare"));

	}

	public AccountHomePage navigateToAutoPaymentHistoryPage() throws InterruptedException {

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.elementToBeClickable(paymentslink));
		 */
		if (validate(iPerceptionAutoPopUp)) {
			iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}

		// Thread.sleep(16000);

		waitforElement(PremiumPayment);
		System.out.println("payment link is displayed on the header");
		PremiumPayment.click();
		Thread.sleep(10000);
		if (PaymentHeading.getText().contains("Premium Payments Overview")) {
			System.out.println("Payment Overview page displayed");
			return new AccountHomePage(driver);
		} else {
			System.out.println("payment overview page not displayed");
			return null;
		}
	}

	public pages.regression.payments.PaymentHistoryPage scrollDownAndUp() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		waitforElement(HistoryDropdown);

		Select dateRange = new Select(HistoryDropdown);
		dateRange.selectByVisibleText("Last 6 months");

		Thread.sleep(6000);

		try{			
			if (HistoryTable.isDisplayed()) {
				System.out.println("Payment History Exists");
				jse.executeScript("window.scrollBy(0,-600)", "");
				Thread.sleep(3000);			
			} }
			catch(Exception e)
			{
				System.out.println("History table not present for this member");
				jse.executeScript("window.scrollBy(0,-600)", "");
				Thread.sleep(3000);				
			}
			return new pages.regression.payments.PaymentHistoryPage(driver);
		}

	
	
public ContactUsPage navigateToContactUsPage() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (validate(iPerceptionPopUp)) {
            iPerceptionPopUp.click();
            System.out.println("iPerception Pop Up displayed");
		}
		if (MRScenario.environmentMedicare.equals("team-ci1") || MRScenario.environmentMedicare.equals("team-h") || MRScenario.environmentMedicare.equals("test-a") || MRScenario.environmentMedicare.equals("team-e")) {
			js.executeScript("arguments[0].click();", helpAndContactUslink);
			
		}else{
			linkContactUs.click();
		}
		CommonUtility.waitForPageLoad(driver, heading, 10);
		if(driver.getTitle().equalsIgnoreCase("Overview"))
		{
			return new ContactUsPage(driver);
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
		//Compare 2017 Plans
		planCompareLink.click();
		
		CommonUtility.waitForPageLoad(driver, planCompareHeader, 20);
		
		if(getTitle().equalsIgnoreCase("Compare 2017 Plans"))
		{
			return new PlanComparePage(driver);
			
					}
		return null;
	}

	
	public Rallytool_Page navigateToRallyPage() { 
		driver.manage().window().maximize(); 
		try{
		searchForProviders.click();
		//switch to Rally Page
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (driver.getTitle().equalsIgnoreCase("Find Care")) {
		return new Rallytool_Page(driver);
		}
		else{
			Assert.fail();
		}
		}
		catch(Exception e){
					
		Assert.fail("Link is not Present");
		} 

		return null;
		}
	

	public OneTimePaymentsPage navigateToOneTimePaymentsPage() throws InterruptedException {
		driver.navigate().to("https://member."+MRScenario.environment+"-aarpmedicareplans.uhc.com/content/dashboard/home/one-time-payments.html");
		System.out.println("title  "+driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("one-time-payment")){
			return new OneTimePaymentsPage(driver);
		}
		return null;
	}

	public Boolean tempIdValidation() {
		validate(viewIDCard);
		viewIDCard.click();
		if(validate(validateLogo)){
			return true;
		}
		return false;
		
	}

	
	  public TestHarness navigateToTestHarnesspage() {
          driver.navigate().to("https://member."+MRScenario.environment+"-aarpmedicareplans.uhc.com/home/testharness.html");
          System.out.println("title  "+driver.getTitle());
          if(driver.getTitle().equalsIgnoreCase("testharness")){
                  return new TestHarness(driver);
          }
          return null;
  }

	
	
	public void validateDrugsPreferredMailOderLink() {
		
		if(validate(drugPreferredMailServicePharmacyLink))
		{
			System.out.println("Drug Preferred Mail Service Link is displaying in footer");	
		}
		else
		{
			System.out.println("Drug Preferred Mail Service Link is not displaying in footer");
		}
	}
	
	
public pages.regression.claims.ClaimSummarypage navigateToClaimsSummaryPage() {
		
		if (MRScenario.environmentMedicare.equalsIgnoreCase("team-h") || MRScenario.environmentMedicare.equalsIgnoreCase("test-a") || (MRScenario.environmentMedicare.equalsIgnoreCase("team-t") || MRScenario.environment.equalsIgnoreCase("team-ci1"))) {
			System.out.println("Go to claims link is present "+driver.findElement(By.xpath("//a[text()='Go to Claims page']")).isDisplayed());
			driver.findElement(By.xpath("//a[text()='Go to Claims page']")).click();			
		}
		else if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
			System.out.println("user is on Stage login page");						
			if(driver.getCurrentUrl().contains("/dashboard"));
			{
				System.out.println("User is on dashboard page and URL is ====>"+driver.getCurrentUrl());
				claimsDashboardLink.click();
				try {
					Thread.sleep(10000);	
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
		else 
		{
			System.out.println("This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");	
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
		return new ClaimSummarypage(driver);
}

public pages.regression.claims.ClaimDetailsPage navigateToClaimDetailsPage() {
	CommonUtility.waitForPageLoad(driver, claimstablemoreinfolink, 60);
	claimstablemoreinfolink.click();
	CommonUtility.waitForPageLoad(driver, claimDetTableMainSection, 30);

	//driver.findElement(By.xpath("//a[contains(text(),'MORE INFO')]")).click();
	/*
	 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 */
	System.out.println(driver.getTitle());
	if (driver.getTitle().equalsIgnoreCase("claims   ")) {
		return new pages.regression.claims.ClaimDetailsPage(driver);

	}
	return new pages.regression.claims.ClaimDetailsPage(driver);
}

public pages.redesign.PharmacySearchPage navigateToRedesignPharmacyLocaterPage() {
	
	if (MRScenario.environmentMedicare.equalsIgnoreCase("team-a") || MRScenario.environmentMedicare.equalsIgnoreCase("test-a") || MRScenario.environment.equalsIgnoreCase("team-ci1")) {
		System.out.println("Go to claims link is present "+driver.findElement(By.xpath("//a[text()='Go to Pharmacy Locator page']")).isDisplayed());
		driver.findElement(By.xpath("//a[text()='Go to Pharmacy Locator page']")).click();			
	}
	/*else if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
		System.out.println("user is on Stage login page");						
		if(driver.getCurrentUrl().contains("/dashboard"));
		{
			System.out.println("User is on dashboard page and URL is ====>"+driver.getCurrentUrl());
			claimsDashboardLink.click();
			try {
				Thread.sleep(10000);	
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	else 
	{
		System.out.println("This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");	
	}
	System.out.println(driver.getTitle());
*/
	/*if (driver.getTitle().equalsIgnoreCase("Claims")) {
		try {
			Thread.sleep(10000);
			ClaimSummarypage comboTab = new ClaimSummarypage(driver).comboTabSelection();
            comboTab.comboTabSelection();
            
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	

}*/
	return null;
}
	
	public PaymentHistoryPage navigateToPaymentHistoryPage() throws InterruptedException
	 {

	 	    	/*WebDriverWait wait = new WebDriverWait(driver, 30);
	 				wait.until(ExpectedConditions.elementToBeClickable(paymentslink));
	 */
	 	    	if(	validate(iPerceptionPopUp)) {
	 	    		iPerceptionPopUp.click();
	 	    	}
	 	    	else  {
	 	    		System.out.println("iPerception Pop Up not displayed");
	 	    	}
	 	    	
	 	        Thread.sleep(6000);

	 	    	if (validate(paymentsLink)) {

	 	    		System.out.println("payment link is displayed on the header");
	 	    		paymentsLink.click();
	 	    		return new PaymentHistoryPage(driver);
	 	    	}else{
	 	    		System.out.println("payment link is not displayed on the header");
	 	    		return null;
	 	    	}
	 	    	/*else{
	 	    		CoverageAndBenefits.click();
		 	    	
		 	    	WebDriverWait wait = new WebDriverWait(driver, 30);
		 			wait.until(ExpectedConditions.elementToBeClickable(paymentslink));
		 	    	
		 	    	validate(paymentslink);
		 	    	paymentslink.click();
		 	    	return new PaymentHistoryPage(driver);
	 	    	}*/
	 	

	//return new PaymentHistoryPage(driver);
}
}
