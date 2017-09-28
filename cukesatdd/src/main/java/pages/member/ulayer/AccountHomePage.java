
/**
 * 
 */
package pages.member.ulayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.dashboard.eob.EOBPage;

/**
 * @author pjaising
 */

public class AccountHomePage extends UhcDriver {

	@FindBy(className = "fd_myPlans")
	private WebElement myPlansTab;

	@FindBy(linkText = "My Profile & Preferences")
	private WebElement profAndPrefLink;
	
	@FindBy(linkText = "Contact Us")
	private WebElement contactUsLink;
	
	@FindBy(className = "fd_myPersonalHealthRecord")
	private WebElement phrTab;

	@FindBy(linkText = "Plan Benefits")
	private WebElement benefitsLink;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(linkText = "View recent premium payments")
	private WebElement paymentsLink;

//	@FindBy(partialLinkText = "get forms & resources")
//	private WebElement formsAndResourcesLink;
	
	@FindBy(xpath="//*[@id='footer']/ul/li[1]/div[2]/div[2]/a/span")
	private WebElement formsAndResourcesLink;
	
	@FindBy(xpath="//[@id='benefits']/a")
	private WebElement benefitsAndCoverageLink;

	@FindBy(linkText = "locate a pharmacy")
	private WebElement pharmacyLocator;
	
	@FindBy(linkText = "medical providers")
	private WebElement medicalProviders ;

	@FindBy(xpath = "//li[@id='fd_myMenu']/a")
	private WebElement myMenuNavigator;

	@FindBy(xpath = "//span[contains(.,'Print temporary ID card')]")
	private WebElement viewIDCard;
	
	@FindBy(id = "pcpLogoPrint1left")
	private WebElement validateLogo;
	
	@FindBy(linkText = "Prescription drug cost and benefits summary")
	private WebElement prescriptionDrugCostBenefitSummaryLink;

	@FindBy(linkText = "Medical Explanation of Benefits (EOB)")
	private WebElement medicalEobLink;

	@FindBy(linkText = "Prescription Drug Explanation of Benefits (EOB)")
	private WebElement prescriptionDrugEobLink;

	@FindBy(linkText = "look up drugs")
	private WebElement drugLookupLink;

	@FindBy(linkText = "Search claim history")
	private WebElement searchClaimsHistory;

	@FindBy(linkText = "Search medical claims")
	private WebElement searchMedicalClaims;

	@FindBy(linkText = "Search drug claims")
	private WebElement searchDrugClaims;

	@FindBy(linkText = "Supplemental Insurance Explanation of Benefits (EOB)")
	private WebElement suppInsurancelEobLink;

	@FindBy(className = "fd_myMenu")
	private WebElement myMenuLinkAarp;

	@FindBy(linkText = "Order plan materials")
	private WebElement orderPlanMaterials;

	@FindBy(id = "gogreenmeter")
	private WebElement goGreenMeterIndicator;

	@FindBy(className = "fd_myHealthWellness")
	private WebElement hwTab;
	
	@FindBy(linkText = "Compare 2017 Plans")
	private WebElement planCompareLink;	
	
	@FindBy(linkText = "Go to MultiEmail Address page")
	private WebElement MultiEmailAddressLink;	
	
	@FindBy(xpath = "//div[@class='prefermain_mid mapd_div']/div/h3")
	private WebElement planCompareHeader;	

	@FindBy(xpath = "//div[@class='myProfileMid']/div/div/div[2]/h2")
	private WebElement myProfilePageHeading;
	
	@FindBy(xpath = "//div[@class='myProfileMid']/div/form/div/div/div/div[2]/div/div[2]/h3")
	private WebElement preferencesPageHeading;
	
	@FindBy(xpath=".//*[contains(text(),'search for providers')]")
	private WebElement searchForProviders;
	
	@FindBy(xpath = "//*[@id='medicareTitle']/a[1]")
	private WebElement espanolLink;
	
	@FindBy(xpath = "//*[@id='medicareTitle']/a[2]")   //Story 261070
	private WebElement chineseLink;
	
	@FindBy(xpath = "//*[@id='subPageLeft']/div[2]/div[2]/div[2]/div/h3[2]/a")
	private WebElement createPdfLink;
	
	@FindBy(xpath = "//*[@id='gogreenlogin_box']/div[4]/div")
	private WebElement gogreenPopup;
	
	@FindBy(xpath = "//*[@id='gogreenlogin_box']/div[4]/div/a")
	private WebElement gogreenPopupClose;
		
	@FindBy(xpath = "//*[@id='paymentOverviewApp']/div[1]/div/div/div/h1")
	private WebElement paymentsHeading;
	
	@FindBy(id = "onetimepayment")
	private WebElement OTPButton;
	
	@FindBy(id = "setupautopayment")
	private WebElement AutomaticPaymentButton;
	
	@FindBy(xpath = ".//*[@id='emailOption.label']/strong")
	private WebElement MultipleEmailAddressMessage;
	
	@FindBy(linkText = "Go to NoEmail Address page")
	private WebElement NoEmailAddressLink;	
	
	private PageData myAccountHome;
	
	private static String EOB_DIRECT_URL = MRConstants.EOB_DIRECT_URL;
	
	public JSONObject accountHomeJson;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;

	public AccountHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ACCOUNT_HOME_PAGE_DATA;
		myAccountHome = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public PlanBenefitsCoveragePage navigateToBnC() {
		benefitsLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Plan Benefits and Coverage")) {
			return new PlanBenefitsCoveragePage(driver);
		} else
			return null;
	}
	
	
	public PlanBenefitsCoveragePage navigateToBenefitsAndCoverage() {
		benefitsAndCoverageLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Plan Benefits and Coverage")) {
			return new PlanBenefitsCoveragePage(driver);
		} else
			return null;
	}
	

	public EstimateYourDrugCostPage navigateToDrugLookup() {		
		drugLookupLink.click();
		if (driver.getTitle().equalsIgnoreCase("Drug Lookup")) {
			return new EstimateYourDrugCostPage(driver);
		} else

			return null;
	}

	public void logOut() {
		logOut.click();

	}

	public PaymentHistoryPage navigateToPayments() {

		paymentsLink.click();
		if (driver.getTitle().equalsIgnoreCase("Premium Payment History")) {
			return new PaymentHistoryPage(driver);
		} else

			return null;
	}

	public PhrPage navigateToPhr() {
		phrTab.click();
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"How to Choose a Medicare Plan and Compare Medicare Plan Costs | UnitedHealthcare")) {
			return new PhrPage(driver);
		}
		return null;

	}

	public FormsandresourcesPage navigateToFormsandResourceAarpPage() {

		formsAndResourcesLink.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Forms and Resources")) {
			return new FormsandresourcesPage(driver);
		} else

			return null;

	}
	public PharmacySearchPage navigateNonEnglishContent() {  //STORY 261070
		espanolLink.click();
		chineseLink.click();
		createPdfLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Pharmacy Directory")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public MyProfilesPage navigateToProfAndPref() {

		profAndPrefLink.click();
		CommonUtility.waitForPageLoad(driver, myProfilePageHeading, 25);
		Cookie ck = driver.manage().getCookieNamed("green");
		System.out.println("Cooke Name ::: " + ck.getName());
		System.out.println("Cooke value ::: " + ck.getValue());
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | My Personal Profile")) {
			return new MyProfilesPage(driver);
		}
		return null;

	}

	public PlanSummaryPage navigateToPlanSummary() {

		myPlansTab.click();
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Plan Summary")) {
			return new PlanSummaryPage(driver);
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
	
	public PharmacySearchPage navigateToPharmacyLocator() {

		pharmacyLocator.click();
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Pharmacy Directory")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public DrugCostandBenefitSummaryPage navigateToPrescriptionDrugCostPage() {

		/*
		 * Actions builder = new Actions(driver);
		 * builder.moveToElement(myMenuNavigator).perform();
		 * builder.click(prescriptionDrugCostBenefitSummaryLink); TODO: NEED TO
		 * FIX HOVER ISSUE prescriptionDrugCostBenefitSummaryLink.click();
		 * CommonUtility.checkPageIsReady(driver);
		 */
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Drug Cost and Benefits Summary")) {
			return new DrugCostandBenefitSummaryPage(driver);
		}

		return null;
	}

	public MedicalClaimSummaryPage navigateToMedicalClaimsSummary() {

		searchMedicalClaims.click();
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new MedicalClaimSummaryPage(driver);
		}
		return null;
	}

	public DrugClaimSummaryPage navigateToDrugClaimsSummary() {

		searchDrugClaims.click();
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new DrugClaimSummaryPage(driver);
		}
		return null;
	}

	public MedicalEobPage navigateToMedicalEob() {

		/*
		 * Actions builder = new Actions(driver);
		 * builder.moveToElement(myMenuNavigator).perform();
		 * builder.click(medicalEobLink); medicalEobLink.click();
		 * CommonUtility.checkPageIsReady(driver);
		 * 
		 * if (driver.getCurrentUrl().contains("medical-eob-search.html")) {
		 * return new MedicalEobPage(driver); }
		 */
		return null;
	}

	public PrescriptionDrugEobPage navigateToPresDrugEob() {
		/*
		 * Actions builder = new Actions(driver);
		 * builder.moveToElement(myMenuNavigator).perform();
		 * builder.click(prescriptionDrugEobLink);
		 * prescriptionDrugEobLink.click();
		 * CommonUtility.checkPageIsReady(driver);
		 * 
		 * if (driver.getCurrentUrl().contains("part-d-eob-search.html")) {
		 * return new PrescriptionDrugEobPage(driver); }
		 */
		return null;
	}

	public SupplementalInsuranceEobPage navigateToSuppInsuranceEob() {
		/*
		 * Actions builder = new Actions(driver);
		 * builder.moveToElement(myMenuNavigator).perform();
		 * builder.click(suppInsurancelEobLink); suppInsurancelEobLink.click();
		 * CommonUtility.checkPageIsReady(driver);
		 * 
		 * if
		 * (driver.getCurrentUrl().contains("supplemental-insurance-eob.html"))
		 * { return new SupplementalInsuranceEobPage(driver); }
		 */
		return null;
	}

	@Override
	public void openAndValidate() {
		validate(benefitsLink);
		validate(phrTab);
		// validate(formsAndResourcesLink);
		validate(benefitsLink);
		validate(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : myAccountHome.getExpectedData().keySet()) {
			WebElement element = findElement(myAccountHome.getExpectedData()
					.get(key));
			if (element != null) {
				if(validate(element)){
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}
		accountHomeJson = jsonObject;
		
		System.out.println("accountHomeJson----->"+accountHomeJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		
		JSONObject accountHomeExpectedJson = expectedDataMap
				.get(CommonConstants.MY_ACCOUNT_HOME);
		
		return accountHomeExpectedJson;
	}

	public JSONObject getAdditionalPlanExpectedData(
			Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject addPlanExpectedJson = expectedDataMap
				.get(CommonConstants.ADD_PLAN);
		JSONObject accountHomeExpectedJson = expectedDataMap
				.get(CommonConstants.MY_ACCOUNT_HOME);
		JSONObject accountHomeComboExpectedJson = expectedDataMap
				.get(CommonConstants.MY_ACCOUNT_HOME_COMBO);
		accountHomeExpectedJson = CommonUtility.mergeJson(
				accountHomeExpectedJson, globalExpectedJson);
		accountHomeExpectedJson = CommonUtility.mergeJson(
				accountHomeExpectedJson, addPlanExpectedJson);
		accountHomeExpectedJson = CommonUtility.mergeJson(
				accountHomeExpectedJson, accountHomeComboExpectedJson);
		return accountHomeExpectedJson;
	}

	public OrderplanmaterialsPage navigateToOrderPlanMaterialsAarpPage() {

		myMenuLinkAarp.click();
		orderPlanMaterials.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Order Plan Materials")) {
			return new OrderplanmaterialsPage(driver);
		}
		return null;
	}

	public MyPreferencesPage clicksOnGoGreenIcon() {
		goGreenMeterIndicator.click();
		CommonUtility.waitForPageLoad(driver, preferencesPageHeading, 20);
		if (currentUrl().contains("my-preferences")) {
			return new MyPreferencesPage(driver);
		}
		return null;
	}

	public HealthAndWellnessPage navigateToHWPage() {
		hwTab.click();
		if (currentUrl().contains("my-health-and-wellness.html")) {
			return new HealthAndWellnessPage(driver);
		}
		return null;
	}

	public ContactUsPage navigatesToContactUsPage() {
		
		contactUsLink.click();
		if(getTitle().equalsIgnoreCase("AARP Medicare Plans | Contact Us"))
		{
			return new ContactUsPage(driver);
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

	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.AARPM_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		browserCheckJson = jsonObject;

		return browserCheckJson;
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
	

	public void navigate_ProviderSearch() {
		validate(medicalProviders);
		medicalProviders.click();
			
	}
	
	public boolean validateGogreenPopup(){
		boolean flag=false;
		try {
			flag= validate(gogreenPopup);
			return flag;
		} catch (Exception e) {
			return flag;
		}		
	}
	
	public void closeGogreenPopup(){
		gogreenPopupClose.click();
	}
	

	public OneTimePaymentsPage navigateToOneTimePaymentsPage() {
		//river.navigate().to("https://member."+MRScenario.environment+"-aarpmedicareplans.uhc.com/content/dashboard/home/one-time-payments.html");
		OTPButton.click();
		System.out.println("title  "+driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("payments-client") || driver.getTitle().equalsIgnoreCase("onetimepayments")){
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

	public AutomaticPaymentsPage navigateToAutomaticPaymentsPage() {
		//driver.navigate().to("https://member."+MRScenario.environment+"-aarpmedicareplans.uhc.com/content/dashboard/home/automatic-payments.html");
		AutomaticPaymentButton.click();
		System.out.println("title  "+driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("payments-client")){
			return new AutomaticPaymentsPage(driver);
		}
		return null;
	}
	
	public TestHarness navigateToTestHarnesspage() {
		driver.navigate().to("https://member."+MRScenario.environment+"-aarpmedicareplans.uhc.com/home/testharness.html");
		System.out.println("title  "+driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("testharness")){
			return new TestHarness(driver);
		}
		return null;
	}
	
    public TestHarness navigateToTeamHTestHarnesspage() {
		driver.navigate().to("https://member.team-h-aarpmedicareplans.uhc.com/home/testharness.html");
		System.out.println("title  "+driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("testharness")){
			return new TestHarness(driver);
		}
		return null;
	}
    
    public TestHarness navigateToTeamCTestHarnesspage() {
		driver.navigate().to("https://member.team-c-aarpmedicareplans.uhc.com/home/testharness.html");
		System.out.println("title  "+driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("testharness")){
			return new TestHarness(driver);
		}
		return null;
	}
	
	public MedicalEobPage navigateDirectToEOBPage(){
		driver.navigate().to(EOB_DIRECT_URL);
 		if(driver.getTitle().equalsIgnoreCase("Member Claims")){
        return new MedicalEobPage(driver);
		}
		return null;
	}

	public EOBPage navigateDirectToEOBPag(){
		driver.navigate().to(EOB_DIRECT_URL);
 		if(driver.getTitle().equalsIgnoreCase("Member Claims")){
        return new EOBPage(driver);
		}
		return null;
	}
	
	public MultipleEmailAddressNewPage navigateToMultipleEmailTestHarness(){
		driver.navigate().to("https://member.team-c-aarpmedicareplans.uhc.com/home/testharness.html");
 		if(driver.getTitle().equalsIgnoreCase("testharness")){
 			MultiEmailAddressLink.click();
 			 Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Multiple Email Address"));
 			 return new MultipleEmailAddressNewPage(driver);
		}
		return null;
	}
	
	
	public NewEmailAddressPage navigateToNoEmailTestHarness(){
		driver.navigate().to("https://member.team-c-aarpmedicareplans.uhc.com/home/testharness.html");
 		if(driver.getTitle().equalsIgnoreCase("testharness")){
 			NoEmailAddressLink.click();
 			 Assert.assertTrue(driver.getTitle().equalsIgnoreCase("No Email Address"));
 			 return new NewEmailAddressPage(driver);
		}
		return null;
	}
	
	public AccountHomePage ValidateMultipleEmailAddress() throws InterruptedException{
		Thread.sleep(10000);
 		if(MultipleEmailAddressMessage.getText().equalsIgnoreCase("Which email address would you like to use?")){
        return new AccountHomePage(driver);
		}
		return null;
	}
	

	public AccountHomePage SelectDifferentEmailAddress() throws InterruptedException{
		Thread.sleep(10000);
 		if(MultipleEmailAddressMessage.getText().equalsIgnoreCase("Which email address would you like to use?")){
        return new AccountHomePage(driver);
		}
		return null;
	}
	}
