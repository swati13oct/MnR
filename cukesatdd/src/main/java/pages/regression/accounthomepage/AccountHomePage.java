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

//import pages.member.redesign.ContactUsPage;
import pages.member.ulayer.OneTimePaymentsPage;
import pages.member.ulayer.PlanComparePage;
import pages.member.ulayer.Rallytool_Page;
import pages.member.ulayer.TestHarness;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.claims.ClaimDetailsPage;
import pages.regression.claims.ClaimSummarypage;
//import pages.regression.claims.ClaimSummarypage;
import pages.regression.contactus.ContactUsPage;
import pages.regression.explanationofbenefits.EOBPage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import pages.regression.ordermaterials.OrderMaterialsPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.pharmacylocator.PharmacySearchPage;
//import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.drugcostestimator.*;





public class AccountHomePage extends UhcDriver {

	@FindBy(xpath = "(//*[@class='ng-scope']//a[text()='Premium Payments'])[1]")
	private WebElement paymentsLink;

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

	/*@FindBy(xpath = "//li[@id='fd_myMenu']/a")
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

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/h1")
	private WebElement paymentsHeading;

	@FindBy(xpath = ".//*[@id='plan_box']/div/div[2]/div/p/a")
	private WebElement planNameLink;

	@FindBy(id = "dropdown-toggle--1")
	private WebElement accountProfileBtn;

	@FindBy(xpath = "//button[@id='dropdown-toggle--1']/span[contains(text(),'Profile')]")
	private WebElement accountToggleDropdown;

	@FindBy(xpath = ".//*[@id='dropdown-options--1']/a[contains(text(),'Account Settings')]")
	private WebElement accountSettingOption;

	@FindBy(xpath = "//header//h1")
	private WebElement heading;

	// @FindBy(xpath="//*[@id='phr_widget_3_box']/div[233]/p[2]/a")
	// private WebElement providerSearchinPHPage1;

	// @FindBy(xpath="div[@class='phr_greybox_mid']/p[contains(text(),'Need to
	// find a facility?')]/following-sibling::p/a")
	// private WebElement providerSearchinPHPage1;

	@FindBy(xpath=".//*[@id='IPEinvL']/map/area[2]")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath="//dashboard//a[contains(text(),'Contact')]")
	private WebElement linkContactUs;

	@FindBy(xpath="//a[contains(text(),'Contact Us page')]")
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

	@FindBy(xpath = "//*[@id='sticky-nav']//div[@ng-switch-when='M&R']/a[5]")
	private WebElement PremiumPayment;

	@FindBy(xpath = "//*[@id='sticky-nav']//div[@ng-switch-when='M&R']/a[4]")
	private WebElement ShipPremiumPayment;

	@FindBy(id = "payment-date")
	private WebElement HistoryDropdown;

	@FindBy(xpath = "(//*[@id='paymentTable'])[1]")
	private WebElement HistoryTable;

	@FindBy(xpath = "//*[@id='paymentOverviewApp']//div[@class='container']//div[@class='col-md-12']/h2[1]")
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

	@FindBy(xpath = "//span[contains (text(), 'Look up Drugs')]")
	private WebElement drugLookup;

	//@FindBy(css = "img.primary-logo")
	//private WebElement logoImage;

	@FindBy(xpath = "//div[@id='white-label']/a/img")
	private WebElement logoImage;

	@FindBy(xpath = "//*[@ng-src='/images/icons/icon-pharmacy-locator.svg']")
	private WebElement pharmacySearchLink;


	//Added by Sneha - Navigate to Order Plan Materials 
	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement OrderMaterial_Dashboard;

	@FindBy(xpath = "//h1[@class='h4 margin-none']")
	private WebElement orderplanHeadertxt;

	@FindBy(xpath = "//*[@class='tabs-desktop']//li[@role='listitem'][2]/a")
	private WebElement ShipTab;

	@FindBy(xpath = "//*[@class='table-body margin-large']/div[2]//p")
	private WebElement PayDate;

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

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
		try {

			if (iPerceptionPopUp.isDisplayed()) {
				iPerceptionPopUp.click();
			}
		}catch(Exception e)        {
			System.out.println("iPerception Pop Up not displayed");
		}
		//openAndValidate();
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
				//driver.navigate().to(PAGE_URL + "medicare/member/account/profile.html");
				waitforElement(accountProfileBtn);
				accountProfileBtn.click();
				accountSettingOption.click();
				System.out.println("title is " + driver.getTitle());
				System.out.println("Current Url is " + driver.getCurrentUrl());
				CommonUtility.waitForPageLoad(driver, heading, 50);

				if (driver.getCurrentUrl().contains("profile")) {

					return new ProfileandPreferencesPage(driver);
				}

			}
		}

		if (MRScenario.environment.equals("team-ci1") || MRScenario.environment.equals("team-h")
				|| MRScenario.environment.equals("test-a") || MRScenario.environment.equals("team-e") || MRScenario.environment.equals("stage")) {

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

	public AccountHomePage navigateToAutoPaymentHistoryPage(){

		try {   
			Thread.sleep(2000); 		
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		}
		catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}	

		// Thread.sleep(16000);

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
			return new AccountHomePage(driver);
		} else {
			System.out.println("payment overview page not displayed");
			return null;
		}
	}


	public AccountHomePage navigateToSHIPAutoPaymentHistoryPage(){

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
		}
		catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		// Thread.sleep(16000);

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

	public AccountHomePage navigateToSHIPTab(){	        

		try {   
			Thread.sleep(2000); 		
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		}
		catch (Exception e) {
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


	public PaymentHistoryPage navigateToOneTimePaymentHistoryPage(){

		try {   
			Thread.sleep(2000); 		
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		}
		catch (Exception e) {
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

	public pages.regression.payments.PaymentHistoryPage scrollDownAndUp() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,550)", "");

		waitforElement(HistoryDropdown);

		Select dateRange = new Select(HistoryDropdown);
		dateRange.selectByVisibleText("Last 6 months");

		Thread.sleep(6000);

		try{			
			if (HistoryTable.isDisplayed()) {
				System.out.println("Payment History Exists");
				jse.executeScript("window.scrollBy(0,-1100)", "");
				Thread.sleep(5000);			
			} }
		catch(Exception e)
		{
			System.out.println("History table not present for this member");	

		}

		jse.executeScript("window.scrollBy(0,-1000)", "");
		Thread.sleep(5000);

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
	public void validateImagePresent(String logoToBeDisplayedOnDashboard) throws InterruptedException {
		Thread.sleep(2000);	
		String logo_src = logoImage.getAttribute("src");
		String logo_alt = logoImage.getAttribute("alt");
		System.out.println("Actual logo's source on Dashboard page is   "+logo_src+" and Expected logo source    "+logoToBeDisplayedOnDashboard+" .");	
		System.out.println("logo's alt text on Dashboard page is   "+logo_alt);		
		Assert.assertTrue(logo_src.contains(logoToBeDisplayedOnDashboard));

	}

	public ClaimSummarypage navigateToClaimsSummaryPage() {

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

	public ClaimDetailsPage navigateToClaimDetailsPage() {
		CommonUtility.waitForPageLoad(driver, claimstablemoreinfolink, 60);
		claimstablemoreinfolink.click();
		CommonUtility.waitForPageLoad(driver, claimDetTableMainSection, 60);

		//driver.findElement(By.xpath("//a[contains(text(),'MORE INFO')]")).click();
		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new ClaimDetailsPage(driver);

		}
		return new ClaimDetailsPage(driver);
	}

	public PharmacySearchPage navigateToRedesignPharmacyLocaterPage() {
		if (validate(iPerceptionAutoPopUp)) {
			iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
		if (MRScenario.environmentMedicare.equalsIgnoreCase("team-a") || MRScenario.environmentMedicare.equalsIgnoreCase("test-a") || MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			System.out.println("Go to Pharmacy locator is present "+ pharmacySearchLink.isDisplayed());
			pharmacySearchLink.click();			
		}
		else if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {	
			if(driver.getCurrentUrl().contains("/dashboard"));
			{
				System.out.println("User is on dashboard page and URL is ====>"+driver.getCurrentUrl());
				pharmacySearchLink.click();
				try {
					Thread.sleep(10000);	

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
			if(pharmacySearchLink.isDisplayed()) {
				System.out.println("Pharmacy link is present");
				return false;
			}
			else {

			}
		}
		catch(Exception e) {
			System.out.println("Pharmacy link is not present");
			return true;
		}
		return false;
	}

	// to navigate to forms and resources page
	public pages.regression.formsandresources.FormsAndResourcesPage navigatetoFormsnResources() {

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
		return new FormsAndResourcesPage(driver);
		//return null;
	}

	public PaymentHistoryPage navigateToPaymentHistoryPage() throws InterruptedException
	{

		/*WebDriverWait wait = new WebDriverWait(driver, 30);
	 				wait.until(ExpectedConditions.elementToBeClickable(paymentslink));
		 */
		try {
			System.out.println("iPerception Pop Up is Present");
			driver.switchTo().frame("IPerceptionsEmbed");
			iPerceptionCloseButton.click();
			//driver.switchTo().defaultContent();
			Thread.sleep(5000);
		}
		catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
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

	/*
	 * Added by Sneha - To Navigate to Order plan Materials page by clicking on link in Rally Dashboard
	 * 
	 */
	public OrderMaterialsPage navigateToOrderPlanMaterialsPage() throws InterruptedException {

		CommonUtility.checkPageIsReady(driver);
		if(validate(OrderMaterial_Dashboard)){
			System.out.println("Order Materials link found on dashboard");
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", OrderMaterial_Dashboard);
			//OrderMaterial_Dashboard.click();
		}
		else{
			String Page_URL = "https://" + MRScenario.environment + "-medicare.uhc.com//member/order-plan-materials.html";
			//String Page_URL = driver.getCurrentUrl().split(".com")[0];
			driver.navigate().to(Page_URL);
			System.out.println("Navigated to Order materials Page URL : "+Page_URL);
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReady(driver);
		//		CommonUtility.waitForPageLoadNew(driver, orderplanHeadertxt, 30);
		if (orderplanHeadertxt.isDisplayed()) {
			return new OrderMaterialsPage(driver);
		}
		return null;
	}
	public EOBPage navigateDirectToEOBPag(){
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(eobLink));*/
		try{
			if (iPerceptionPopUp.isDisplayed()) {
				iPerceptionPopUp.click();
			}
		}catch(Exception e)        {
			System.out.println("iPerception Pop Up not displayed");
		}

		validate(medicalEobLink);
		medicalEobLink.click();
		return new EOBPage(driver);
	}

	public void validateClaimsL2Tabs(){
		if(claims.isDisplayed()){
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

	public void validateFooterSection() {		

		JavascriptExecutor jse = (JavascriptExecutor) driver; 
		Assert.assertTrue("Footer section is not displayed", footerSection.isDisplayed());
	}

	public DrugCostEstimatorPage navigate_to_dce(){
		waitforElement(drugLookup);
		drugLookup.click();
		Assert.assertTrue("drugLookup link is not present", true);

		return new DrugCostEstimatorPage(driver);
	}

	public  void dce_not_present(){
		Assert.assertFalse("Drug look up link is not present", drugLookup.isDisplayed());	
	}
}
