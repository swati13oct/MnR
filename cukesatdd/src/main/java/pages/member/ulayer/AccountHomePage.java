/**
 * 
 */
package pages.member.ulayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

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

	/*@FindBy(partialLinkText = "get forms & resources")
	private WebElement formsAndResourcesLink;*/
	
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

	@FindBy(linkText = "Search medical claims" )
	private WebElement searchMedicalClaims;
	
	@FindBy(xpath = "//a[contains(text(), 'Go to Claims')]")
	private WebElement ClaimsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Go to EOB Search')]")
	private WebElement EOBsearchLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Go to MyProfile ')]")
	private WebElement MyProfileLink;

	@FindBy(xpath = "//a[contains(text(), 'Go to Payments')]")
	private WebElement GoToPaymentsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Go to Contact Us')]")
	private WebElement GoToContactUsLnk;
	
	@FindBy(linkText = "Search drug claims")
	private WebElement searchDrugClaims;

	@FindBy(linkText = "Supplemental Insurance Explanation of Benefits (EOB)")
	private WebElement suppInsurancelEobLink;

	@FindBy(className = "fd_myMenu")
	private WebElement myMenuLinkAarp;

	@FindBy(linkText = "Order plan materials")
	private WebElement orderPlanMaterials;
	
	
	@FindBy(linkText = "Go to Pharmacy Locator page")
	private WebElement PharmacyLocatorLink;

	@FindBy(id = "gogreenmeter")
	private WebElement goGreenMeterIndicator;

	@FindBy(className = "fd_myHealthWellness")
	private WebElement hwTab;
	
	@FindBy(linkText = "Compare 2017 Plans")
	private WebElement planCompareLink;	
	
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
	
	@FindBy(linkText = "My Documents")
	private WebElement MyDocumentLink;
	
	@FindBy(linkText = "Back to previous page")
	private WebElement backTopreviouspageLink;
	
	@FindBy(xpath = "//*[@id='myDocuments']/div/div[2]/div/p[2]/ul/li[4]/a")
	private WebElement paginationLink;
	
	@FindBy(linkText = "View/Download")
	private WebElement viewanddownloadLink;
	
	@FindBy(xpath = "//*[@id='myDocuments']/div/div[1]/div/form/div/div[2]/div[2]/div[2]/div[1]/div/input")
	private WebElement fromdate;
	
	@FindBy(xpath = "//*[@id='myDocuments']/div/div[1]/div/form/div/div[2]/div[2]/div[2]/div[2]/div/input")
	private WebElement todate;
	
	@FindBy(xpath = "//*[@id='myDocuments']/div/div[1]/div/form/div/div[2]/div[2]/div[2]/div[3]/button")
	private WebElement searchLink;
	
	@FindBy(linkText = "Date")
	private WebElement dateLink;
	
	@FindBy(xpath = "//*[@id='saver-checkbox']/label")
	private WebElement filterLink;
	
	@FindBy(xpath = "//a[contains(@href,'pharmacyDirectory')]")
	private WebElement viewpdfLink;
	
	@FindBy(xpath = "//a[contains(text(),'Show on Map')]")
	private WebElement showonmapLink;
		
	@FindBy(xpath = "//*[@id='_content_pharmacy_en_uhc_jcr_content_pharmacylocator_par_teaser']")
	private WebElement widgetLink;
	
	@FindBy(xpath = "//form/fieldset[1]/ul/li[2]/label")
	private WebElement pharmacyfilterLink;
	
	@FindBy(xpath = "//*[@id='row2link2']/p/a")
	private WebElement privacypolicyLink;
	
	@FindBy(xpath = "//a[2]/span['DOWNLOAD']")
	private WebElement downloadLink;
		
	@FindBy(linkText = "VIEW")
	private WebElement viewLink;

	@FindBy(xpath = "html/body/div[2]/div/div/header/div/div/div/div/div/div/a/p")
	private WebElement backtopreviousLink;
	
	@FindBy(xpath = "//*[@id='row2link3']/p/a")
	private WebElement termsofuseLink;
	
	@FindBy(xpath = "//*[@id='fd_myMenu']/a")
	private WebElement mymenuLink;
	
	@FindBy(xpath = "//*[@id='planinformation']/div[2]/div[5]/span[2]/a")
	private WebElement benefitandcoverageLink;
	
	@FindBy(xpath = "//label[@for='member-materials']")
	private WebElement radiokitLink;
	
	@FindBy(xpath = "//p[contains(text(),'Replacement ID card')]")
	private WebElement radioidLink;

	@FindBy(xpath = "html/body/div[2]/div/div/main/div/section[1]/div/div/div/form/button")
	private WebElement submitLink;
	
	//@FindBy(linkText = "ORDER ADDITIONAL MATERIALS")
	@FindBy(xpath = "//section[1]/div/div/div/a")
	private WebElement addordermaterialLink;
	
	@FindBy(xpath="//a[contains(text(),'Go to Order plan materials')]")
	private WebElement OrderPlanMaterialslnk;
	
	@FindBy(xpath="//h3[contains(text(),'Technical Support') or contains(text(),'Plan Support')]/ancestor::div[@class='col-md-4']")
	private WebElement needhelpcomponent;
	
	@FindBy(xpath="//h1[@class='h4 margin-none']")
	private WebElement orderplanHeadertxt;
	
	
	private PageData myAccountHome;

	public JSONObject accountHomeJson;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;

	public AccountHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ACCOUNT_HOME_PAGE_DATA;
		myAccountHome = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		if(!currentUrl().contains("/testharness.html"))
		{
			openAndValidate();
		}
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
		EOBsearchLink.click();
		CommonUtility.checkPageIsReady(driver);
		//benefitsAndCoverageLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Plan Benefits and Coverage") || driver.getTitle().equalsIgnoreCase("Explanation of Benefits (EOB)")) {
			return new PlanBenefitsCoveragePage(driver);
		} 
		else {
			return null;
		}
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

		GoToPaymentsLink.click();
		CommonUtility.checkPageIsReady(driver);
		//paymentsLink.click();
		if (driver.getTitle().equalsIgnoreCase("Premium Payment History") || driver.getTitle().equalsIgnoreCase("payments-overview")) {
			return new PaymentHistoryPage(driver);
		} 
		else{
			return null;
		}
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

		//formsAndResourcesLink.click();
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/forms-and-resources.html");
		/*CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Forms and Resources")) {
			return new FormsandresourcesPage(driver);
		} else*/

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

		MyProfileLink.click();
		CommonUtility.checkPageIsReady(driver);
		/*profAndPrefLink.click();
		CommonUtility.waitForPageLoad(driver, myProfilePageHeading, 25);
		Cookie ck = driver.manage().getCookieNamed("green");
		System.out.println("Cooke Name ::: " + ck.getName());
		System.out.println("Cooke value ::: " + ck.getValue());*/
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | My Personal Profile") || driver.getTitle().equalsIgnoreCase(
						"My Profile & Preferences")) {
			return new MyProfilesPage(driver);
		}
		else{
			return null;
		}

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
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		PharmacyLocatorLink.click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		
/*		if (driver.findElement(By.xpath("//*[contains(text(), 'Locate a Pharmacy')]")).isDisplayed()){
			return new PharmacySearchPage(driver);
		}
		pharmacyLocator.click();*/
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Pharmacy Directory") || driver.getTitle().equalsIgnoreCase(
						"Locate a Pharmacy")) {
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
		ClaimsLink.click();
		CommonUtility.checkPageIsReady(driver);
		//searchMedicalClaims.click();
		System.out.println("Claims link clicked");

		/*if (ClaimsLink.isDisplayed()){
			ClaimsLink.click();
		}
		else{
			
		}*/
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			System.out.println("Claims Page loaded");
			return new MedicalClaimSummaryPage(driver);
		}
		else{
			return null;
		}
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

		//myMenuLinkAarp.click();
		
		CommonUtility.checkPageIsReady(driver);
		
		OrderPlanMaterialslnk.click();
		CommonUtility.checkPageIsReady(driver);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		if (driver.findElement(By.xpath("//*[contains(text(), 'Order Plan Materials')]")).isDisplayed()){
			return new OrderplanmaterialsPage(driver);

		}

/*		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Order Plan Materials") || (driver.getTitle().equalsIgnoreCase("Order Plan Materials"))) {
			return new OrderplanmaterialsPage(driver);
		}
*/		
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
		
		GoToContactUsLnk.click();
		//contactUsLink.click();
		CommonUtility.checkPageIsReady(driver);
		if(getTitle().equalsIgnoreCase("AARP Medicare Plans | Contact Us") || getTitle().equalsIgnoreCase("Contact Us"))
		{
			return new ContactUsPage(driver);
		}
		else{
			return null;
		}
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

	public AutomaticPaymentsPage navigateToAutomaticPaymentsPage() {
		driver.navigate().to("https://member."+MRScenario.environment+"-aarpmedicareplans.uhc.com/content/dashboard/home/automatic-payments.html");
		System.out.println("title  "+driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("Automatic Payments")){
			return new AutomaticPaymentsPage(driver);
		}
		return null;
	}

    public FormsandresourcesPage navigateToMydocumentAarpPage() {
		
		MyDocumentLink.click();
		
		return null;
	}

	public FormsandresourcesPage navigatebackToformsandresourcesAarpPage() {
		
		backTopreviouspageLink.click();
		
		return null;
	}

	public FormsandresourcesPage navigateTopaginationAarpPage() {
		
		Select select = new  Select(driver.findElement(By.id("document-date")));
		select.selectByVisibleText("Current Year");
		
		paginationLink.click();
		
		return null;
	}

	public FormsandresourcesPage navigateToviewdowloadlinkAarpPage() {
		
		viewanddownloadLink.click();
		return null;
	}

	public FormsandresourcesPage navigateTocustomersearchlinkAarpPage() {
		
		Select select = new  Select(driver.findElement(By.id("document-date")));
		select.selectByVisibleText("Custom Search");
		fromdate.sendKeys("01/09/2017");
		todate.sendKeys("01/13/2017");
		searchLink.click();
		return null;
	}

	public FormsandresourcesPage navigateTosortingsearchlinkAarpPage() {
		Select select = new  Select(driver.findElement(By.id("document-date")));
		select.selectByVisibleText("Current Year");
		dateLink.click();
		return null;
	}
	

	public PharmacySearchPage navigateToPharmacySearchResult() {
		Select select = new  Select(driver.findElement(By.id("plan-year")));
		select.selectByVisibleText("2016");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		select = new  Select(driver.findElement(By.id("plan-type")));
		select.selectByVisibleText("AARP MedicareComplete Plan 1 (HMO)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		filterLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public PharmacySearchPage navigateToviewResultPdf() {
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		driver.findElement(By.linkText("VIEW RESULTS AS PDF")).click();
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		return null;
	}

	public PharmacySearchPage navigateToshowOnMapResult() {
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		showonmapLink.click();
		return null;
	}

	public PharmacySearchPage navigateTomultipleLanguageDropdownResult() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//Select select = new  Select(driver.findElement(By.id("lang-select")));
		//select.selectByVisibleText("espa�ol");
		driver.findElement(By.xpath("//select[@id='lang-select']/option[1]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		return null;
		
	}

	public PharmacySearchPage navigateToPrpnWidgetResult() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		widgetLink.isDisplayed();
		return null;
	}

	public PharmacySearchPage navigateToPrpnSearchAndBallonMarkerResult() {
		pharmacyfilterLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}
	
	public PharmacySearchPage navigateToFilterAndTooltipResult() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		filterLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}
	
	public FormsandresourcesPage navigateToPrescriptionDrugAarpPage() {
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/forms-and-resources/new-drug-transition-process-pdp.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToPrivacyPolicyAarpPage() {
		// TODO Auto-generated method stub
		privacypolicyLink.click();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}
	
	public FormsandresourcesPage navigateToappealsAarpPage() {
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/forms-and-resources/appeals-and-grievances-process-noaccordion-ma.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToDownloadAarpPage() {
		downloadLink.click();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToViewAarpPage() {
		viewLink.click();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToBackToPreviousAarpPage() {
		backtopreviousLink.click();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}
	
	public FormsandresourcesPage navigateToMemberResponsibilitiesAarpPage() {
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/forms-and-resources/noacc-member-rights-and-responsibilities-ma.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToSeasonalFluInformationAarpPage() {
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/forms-and-resources/season-flu-shot-info0.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToTermsOfUseAarpPage() {
		termsofuseLink.click();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToMedicalTherapyProgramAarpPage() {
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/forms-and-resources/medication-therapy-mgmt-mapd0.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToPreferedMailServiceAarpPage() {
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/noacc-mail-service-pharmacy-mapd.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToMymenuAarpPage() {
		mymenuLink.click();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateTodisenrollmentAarpPage() {
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/forms-and-resources/disenrollment-rights-responsibilities-noacc-pdp.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToMedicationTherapyManagementAarpPage() {
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/forms-and-resources/medication-therapy-mgmt-pdp0.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToCoverageAppealsAndGrievancesAarpPage() {
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/forms-and-resources/coverage-determination-appeals-pdp-acc.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToPreferredMailPharmacyBenefitAarpPage() {
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/mailOrderPharmacyNonAccPDP.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToBenefitAndCoverageAarpPage() {
		//benefitandcoverageLink.click();
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/plan-benefits-and-coverage.html?planId=51509149");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToLowerTierDrugLearnmoreAarpPage() {
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/my-plans/noaccordion-medicare-partd-coverage.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}
	
	public OrderplanmaterialsPage navigateToLinkOrderPlanMaterialsAarpPage() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/order-plan-materials-dashboard.html");
		//OrderPlanMaterialslnk.click();
		if(driver.getTitle().equalsIgnoreCase("Order Plan Materials")){
			return new OrderplanmaterialsPage(driver);
		}
		
		
		
		return null;
	}

	public OrderplanmaterialsPage navigateToValidateRadioButtonInAarpPage() {
		radiokitLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		radioidLink.click();
		return null;
	}
	
	public OrderplanmaterialsPage navigateToValidateRadioAndSubmitButtonInAarpPage() {
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		radioidLink.click();
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		submitLink.click();
				return null;
	}

	public OrderplanmaterialsPage navigateToValidateOrderConfirmationInAarpPage() {
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		addordermaterialLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}
	
	public OrderplanmaterialsPage verifyneedHelpcomponent(){
		boolean present;
		try{
			validate(needhelpcomponent);
			present=true;
		}catch(NoSuchElementException e)
		{
			present=false;
		}
		if(present)
		System.out.println("Able to find needhelp component");
		else
			System.out.println("No needhelp component is displayed");
		return null;
	}
	
	public OrderplanmaterialsPage verifyHeaderTextandSubtext(){
		boolean present;
		try{
			validate(orderplanHeadertxt);
			present=true;
		}catch(NoSuchElementException e)
		{
			present=false;
		}
		if(present)
		System.out.println("@@@@@ Able to find order plan header text @@@@@");
		else
			System.out.println("order plan header text is not displayed");
		return null;
	}

}
