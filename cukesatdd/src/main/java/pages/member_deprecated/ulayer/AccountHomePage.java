/**
 * 
 */
package pages.member_deprecated.ulayer;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.member_deprecated.redesign.ContactUsPage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.pharmacylocator.PharmacySearchPage;
/**
 * @author pjaising
 */

public class AccountHomePage extends UhcDriver {

	//@FindBy(className = "fd_myPlans")
	//private WebElement myPlansTab;
	
	//@FindBy(xpath="//*[@id='myshipplans']/a")
	//private WebElement myPlansTab;
	
	@FindBy(id="myshipplans")
	private WebElement  myPlansTab;

	@FindBy(linkText = "My Profile & Preferences")
	private WebElement profAndPrefLink;
	
	@FindBy(linkText = "Contact Us")
	private WebElement contactUsLink;
	
	@FindBy(className = "fd_myPersonalHealthRecord")
	private WebElement phrTab;

	@FindBy(linkText = "Coverage & Benefits")
	private WebElement benefitsLink;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(linkText = "View recent premium payments")
	private WebElement paymentsLink;

//	@FindBy(partialLinkText = "get forms & resources")
//	private WebElement formsAndResourcesLink;
	
	@FindBy(xpath=".//*[@id='_content_campaigns_aarpm_panelnav-planresources-main_links_jcr_content_par_teaser']/div/li/a")
	private WebElement formsAndResourcesLink;
	
	@FindBy(xpath="//[@id='benefits']/a")
	private WebElement benefitsAndCoverageLink;

	@FindBy(linkText = "locate a pharmacy")
	private WebElement pharmacyLocator;
	
	@FindBy(linkText = "medical providers")
	private WebElement medicalProviders ;


	@FindBy(xpath = "//span[contains(.,'Print temporary ID card')]")
	private WebElement viewIDCard;
	
	@FindBy(id = "pcpLogoPrint1left")
	private WebElement validateLogo;


	@FindBy(linkText = "look up drugs")
	private WebElement drugLookupLink;


	@FindBy(linkText = "Search medical claims")
	private WebElement searchMedicalClaims;

	@FindBy(linkText = "Search drug claims")
	private WebElement searchDrugClaims;
	
	@FindBy(xpath="//dashboard//a[contains(text(),'Contact')]")
	private WebElement linkContactUs;
	
	@FindBy(xpath="//a[contains(text(),'Contact Us page')]")
	private WebElement helpAndContactUslink;
	
	@FindBy(xpath="//header//h1")
	private WebElement heading;
	
	@FindBy(xpath=".//*[@id='IPEinvL']/map/area[2]")
    private WebElement iPerceptionPopUp;


	@FindBy(className = "fd_myMenu")
	private WebElement myMenuLinkAarp;

	@FindBy(linkText = "Order plan materials")
	private WebElement orderPlanMaterials;

	@FindBy(id = "gogreenmeter")
	private WebElement goGreenMeterIndicator;
	
	@FindBy(id="fd_myMenu")
	private WebElement myMenu;

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
	
	
	
	@FindBy(xpath = "//*[@id='paymentOverviewApp']/div[1]/div/div/div/h1")
	private WebElement paymentsHeading;
	

	@FindBy(linkText = "Preferred Mail Service Pharmacy")
	private WebElement preferredMailServicePharmacyLink;
	
	@FindBy(linkText = "Order drugs from your Preferred Mail Service Pharmacy")
	private WebElement drugPreferredMailServicePharmacyLink;

	@FindBy(xpath = ".//*[@id='contentRow']")
	private WebElement homePageContent;
	
	@FindBy(xpath = ".//*[@id='_content_campaigns_aarpm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_2']/div/div[2]")
	private WebElement drugLookupBox;
	
	@FindBy(xpath = ".//*[@id='_content_campaigns_aarpm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_2']/div/div[2]/a/span")
	private WebElement drugLookupBtn;
	
	@FindBy(xpath = ".//*[@id='contentRow']/td/table/tbody/tr/td/div/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div")
	private WebElement myResourcesContent;

	
	@FindBy(xpath="//a[contains(text(),'Provider search')]")
	private WebElement providerSearchinPanelNavigation;


	@FindBy(xpath="//a[@class='searchforproviders margin_top_5px']")
	private WebElement medicalEOBproviderlink;
	
	@FindBy(linkText = "Benefits and Coverage") 
	private WebElement benefitsAndCoveragelink;
	
	
	//@FindBy(xpath="//a[contains(text(),'Search for a provider')]")
	//private WebElement providerlinkinPCPSection;
	
	@FindBy(xpath="(//p/a[text()='Search for a provider'])[2]")
	private WebElement providerlinkinPCPSection;
	
	@FindBy(css="li#accountdetails>a")
	private WebElement accountHome;
	
	@FindBy(xpath="(//div[@class='widgetbuttonmid']/span)[1]")
	private WebElement searchLinkinClaimsPage;
	
	
	@FindBy(id = "phr_widget_3")
	private WebElement showLink;
	
	
	@FindBy(xpath="//div[@class='phr_greybox_mid']/p[contains(text(),'Looking for a doctor')]/following-sibling::p/a")
	private WebElement providerSearchinPHPage;
	
	//@FindBy(xpath="//*[@id='phr_widget_3_box']/div[233]/p[2]/a")
	//private WebElement providerSearchinPHPage1;
	
	
	@FindBy(xpath="//div[@class='phr_greybox_mid']/p[contains(text(),'Need to find a facility?')]/following-sibling::p/a")
	private WebElement providerSearchinPHPage1;
	
	@FindBy(linkText = "Claims")
	private WebElement claimsLink;
	
	
	@FindBy(xpath ="(//a[contains(@href,'my-plans/forms-and-resources')])[4]")
	private WebElement FormsandResourcesLinkn;
	
	@FindBy(xpath="//a[contains(text(),'search for providers')]")
	private WebElement searchforproviderlinkinClaimsPage;

	  
	  @FindBy(xpath="//a[@class='searchforproviders margin_top_5px']")
		private WebElement searchProviderinFormsandResourcePage;
	  
	  @FindBy(xpath = "//div[@class='claim-results']//table[not (contains(@class,'ng-hide'))]//tbody//tr[2]//a[text()='MORE INFO']")
	  private WebElement claimstablemoreinfolink;
	  
	  @FindBy (css = ".claimDetTableMainSection")
		private WebElement claimDetTableMainSection;
	  
	  @FindBy(xpath = "//*[@id='dashboard']//span[text()='View Your Claims']")
	  private WebElement claimsDashboardLink;
	  
	  @FindBy (xpath = "//*[@id='dashboard']//span[text()='Locate a Pharmacy']")
	  private WebElement dashboardLocateaPharmacyLink;
	  

	
	

	public JSONObject accountHomeJson;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;
	
	@FindBy(xpath ="//*[@id='healthwellness']/a")
	private WebElement healthAndWellnessTab;

	public AccountHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
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
	

	public ManageDrugPage navigateToDrugLookup() {		
		drugLookupLink.click();
		if (driver.getTitle().equalsIgnoreCase("Drug Lookup")) {
			return new ManageDrugPage(driver);
		} else

			return null;
	}

	public void logOut() {
		logOut.click();
		
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
	

public void  rallytoolexist()
	{
		String mainwindow=driver.getWindowHandle();
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
		String s=driver.getTitle();
		System.out.println(s);
		
		
		if(s.equalsIgnoreCase("Find Care"))
		{
			System.out.println("Rally tool is opened Successfully");
			driver.close();
		}
		else
		{
			System.out.println("Rally tool is not opened ");
			
			 Assert.assertFalse("Rally tool displayed", false);
			
			//Assert.fail("Error :Unable to Login");
			driver.close();
		}
		
driver.switchTo().window(mainwindow);

}
	public void panelNavigation()
	{
	
		waitforElement(myMenu);
		myMenu.click();	
		/*myPlansTab.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(myMenu);
		actions.click().build().perform();*/
		waitforElement(providerSearchinPanelNavigation);
		providerSearchinPanelNavigation.click();
		rallytoolexist();
		
		System.out.println(" in panel Navigation method");
		/*
		if(providerSearchinPanelNavigation.isDisplayed())
		{
			myMenu.click();
		}*/
			
	}
	
	public void  waitt()
	{
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void providerSearchRHandWidget()
	{
		waitt();
		//myPlansTab.click();
		waitforElement(medicalEOBproviderlink);
		
		medicalEOBproviderlink.click();
		rallytoolexist();
		System.out.println(" in Provider searh Rifht method");
	}
	
	public void BenefitsandCoverageProviderSearch()
	{
		accountHome.click();
		waitforElement(myPlansTab);
		myPlansTab.click();
		waitforElement(benefitsAndCoveragelink);
		benefitsAndCoveragelink.click();
		waitforElement(medicalEOBproviderlink);
		medicalEOBproviderlink.click();
		rallytoolexist();
		System.out.println(" in Benefit Coverage  method");
		
	}
	
	public void providerSearchLinkinPCPSection()
	{
		waitforElement(providerlinkinPCPSection);
		providerlinkinPCPSection.click();
		rallytoolexist();
		System.out.println(" in PCP benefit  method");
	}

	public void providerSearchLinkinClaimsPage()
	{
		waitforElement(claimsLink);
		claimsLink.click();
		waitforElement(searchLinkinClaimsPage);
		
		searchLinkinClaimsPage.click();
		
		waitforElement(searchforproviderlinkinClaimsPage);
		
		searchforproviderlinkinClaimsPage.click();
		rallytoolexist();
		System.out.println(" in Claims method");
		
	}
	
	public void FormsandResourcesLinkinPlanSummaryPage()
	
	{
		waitforElement(FormsandResourcesLinkn);
		FormsandResourcesLinkn.click();
		
		waitforElement(searchProviderinFormsandResourcePage);
		
		searchProviderinFormsandResourcePage.click();
		rallytoolexist();
		
		System.out.println(" in forms and Resources  method");
		
	}
	
	
	public void PHR()
	{
		phrTab.click();
		
		waitforElement(providerSearchinPHPage);
		providerSearchinPHPage.click();
		rallytoolexist();
		showLink.click();
		waitforElement(providerSearchinPHPage1);
		providerSearchinPHPage1.click();
		rallytoolexist();
		System.out.println(" in PHR");
		
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
		myMenuLinkAarp.click();
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
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Plan Summary")) {
			return new PlanSummaryPage(driver);
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
	
	public PharmacySearchPage navigateToPharmacyLocator() {

		pharmacyLocator.click();
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		//validate(phrTab);
		// validate(formsAndResourcesLink);
		/*validate(benefitsLink);
		validate(logOut);*/

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		
		JSONObject accountHomeExpectedJson = expectedDataMap
				.get(CommonConstants.MY_ACCOUNT_HOME);
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		
		accountHomeExpectedJson = CommonUtility.mergeJson(
				accountHomeExpectedJson, globalExpectedJson);
		
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
		rallytoolexist();
			
	}
	
	public boolean validateGogreenPopup(){
		boolean flag=false;
		if(gogreenPopup!=null) {
			try {
				flag= validate(gogreenPopup);
				return flag;
			} catch (Exception e) {
				return flag;
			}	
		}
		return flag;
	}
	
	public void closeGogreenPopup(){
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//gogreenPopupClose.click();
		driver.close();
		driver.switchTo().window(winHandleBefore);
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

	public AutomaticPaymentsPage navigateToAutomaticPaymentsPage() {
		driver.navigate().to("https://member."+MRScenario.environment+"-aarpmedicareplans.uhc.com/content/dashboard/home/automatic-payments.html");
		System.out.println("title  "+driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("Automatic Payments")){
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

	
	public void validateHWTabsAndContent() {

		HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
		healthAndWellness.validateTabsAndContent();

	}

	public void validateHWLifeStyleTab() {
		HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
		healthAndWellness.validateLifeStyleTab();
	}

	public void validateHWLearningTab() {
		HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
		healthAndWellness.validateLearningTab();
	}

	public void validateHWRewardsTab() {
		HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
		healthAndWellness.validateRewardsTab();
	}
	

	public void validatePreferredMailOderLink() {
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(myMenuLinkAarp);
		actions.perform();
		if(validate(preferredMailServicePharmacyLink))
		{
			System.out.println("Preferred Mail Service Link is displaying ");	
		}
		else
		{
			System.out.println("Preferred Mail Service Link is not displaying ");
		}
		
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
	
	public HealthAndWellnessPage navigateToHealthAndWellnessPage() {

		healthAndWellnessTab.click();
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Health and Wellness")) {
			return new HealthAndWellnessPage(driver);
		}

		return null;

	}

	public boolean validateAccountHome(){
		boolean flag = false;
		if(validate(homePageContent)&&validate(logOut)&&validate(myResourcesContent)&&validate(drugLookupBox)&&validate(drugLookupBtn))
			flag = true;
		return flag;
	}
	
public pages.regression.claims.ClaimsSummaryPage navigateToClaimsSummaryPage() {
		
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
				ClaimsSummaryPage comboTab = new ClaimsSummaryPage(driver).validateComboTabSelection();
                comboTab.validateComboTabSelection();
                
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}	

}
		return new ClaimsSummaryPage(driver);
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

public PharmacySearchPage navigateToRedesignPharmacyLocaterPage() {
	
	if (MRScenario.environmentMedicare.equalsIgnoreCase("team-a") || MRScenario.environmentMedicare.equalsIgnoreCase("test-a") || MRScenario.environment.equalsIgnoreCase("team-ci1")) {
		System.out.println("@@@@@@    Go to Pharmacy Locator page ====>"+driver.findElement(By.xpath("//a[text()='Go to Pharmacy Locator page']")).isDisplayed());
		driver.findElement(By.xpath("//a[text()='Go to Pharmacy Locator page']")).click();			
	}
	else if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
		System.out.println("user is on Stage login page");						
		if(driver.getCurrentUrl().contains("/dashboard"));
		{
			System.out.println("User is on dashboard page and URL is ====>"+driver.getCurrentUrl());
			dashboardLocateaPharmacyLink.click();
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

	/*if (driver.getTitle().equalsIgnoreCase("Claims")) {
		try {
			Thread.sleep(10000);
			ClaimSummarypage comboTab = new ClaimSummarypage(driver).comboTabSelection();
            comboTab.comboTabSelection();
            
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	

}*/
	return new PharmacySearchPage(driver);
}

}
