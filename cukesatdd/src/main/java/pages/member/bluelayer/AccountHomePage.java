/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

import pages.member.bluelayer.OrderplanmaterialsPage;
import pages.member.bluelayer.ContactUsPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.UhcDriver;


/**
 * @author pagarwa5
 *
 */
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

	@FindBy(xpath = "//*[@id='footer']/ul/li[1]/div[2]/div[2]/a/span")
	private WebElement formsAndResourcesLink;

	@FindBy(linkText = "My Profile & Preferences")
	private WebElement profAndPrefLink;

	@FindBy(xpath = "//a[@class='fd_myPlans']")
	private WebElement myPlansTab;

	@FindBy(linkText = "locate a pharmacy")
	private WebElement pharmacyLocator;
	
	@FindBy(linkText = "medical providers")
	private WebElement medicalProviders ;

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

	@FindBy(linkText = "Medical Explanation of Benefits (EOB)")
	private WebElement medicalEobLink;

	@FindBy(linkText = "Prescription Drug Explanation of Benefits (EOB)")
	private WebElement prescriptionDrugEobLink;
	
	@FindBy(xpath = "//div[@id='medicareTitle']/h1")
	private WebElement pharmacyLocatorHeading;
	
	@FindBy(xpath = "//*[@id='medicareTitle']/p/a[1]")
	private WebElement espanolLink;
	
	@FindBy(xpath = "//*[@id='medicareTitle']/p/a[2]")   //Story 261070
	private WebElement chineseLink;
	
	@FindBy(xpath = "////*[@id='subPageLeft']/div[2]/div[2]/h3[2]/a")
	private WebElement createPdfLink;
	

	@FindBy(xpath = "//span[contains(.,'Print temporary ID card')]")
	private WebElement viewIDCard;
	
	@FindBy(id = "pcpLogoPrint1left")
	private WebElement validateLogo;
	
	@FindBy(xpath = "//a[contains(text(),'UnitedHealthcare MedicareComplete Choice (PPO)')]")
	private WebElement uhcMedicareCompleteChoicePPO;
	
	@FindBy(xpath ="//*[@id='healthwellness']/a")
	private WebElement healthAndWellnessTab;
		
	@FindBy(xpath ="//*[@id='gogreenmeter']/a")
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
	
	@FindBy(xpath = "//*[@id='saver-checkbox']/label")
	private WebElement filterLink;
	
	@FindBy(xpath = "//fieldset[1]/ul/li[1]/label")
	private WebElement pharmacyfilterLink;
	
	@FindBy(xpath = "//*[@id='_content_pharmacy_en_uhc_jcr_content_pharmacylocator_par_teaser']")
	private WebElement widgetLink;
	
	@FindBy(xpath = "//a[contains(text(),'Get Directions')]")
	private WebElement getdirectionLink;
	
	@FindBy(xpath = "//a[contains(text(),'More Information')]")
	private WebElement moreinformationLink;
	
	@FindBy(xpath = "//*[@id='pharmacySaverPharmacyTooltip']/svg/path")
	private WebElement tooltipLink;
	
	@FindBy(xpath = "//*[@id='healthrecord']/a")
	private WebElement myHealthRecordLink;
	
	@FindBy(xpath = "//*[@id='phr_widget_7_box']/div[9]/p/a")
	private WebElement preferdPharmacyBenefitLink;
	
	@FindBy(xpath = "//*[@id='_content_campaigns_uhcm_formsresources-main_formsresources-main_jcr_content_par_teaser']/div/div[1]/div[2]/div[1]/div/div[1]/p[3]/a[1]")
	private WebElement appointRepresentativeLink;
	
	@FindBy(xpath = "//*[@id='row2link2']/p/a")
	private WebElement privacypolicyLink;

	private PageData myAccountHome;

	public JSONObject accountHomeJson;

	public AccountHomePage(WebDriver driver,String category) {
		super(driver);
		PageFactory.initElements(driver, this);
		if(category.equalsIgnoreCase("Individual"))
		{
			String fileName = CommonConstants.ACCOUNT_HOME_PAGE_INDIVIDUAL_DATA;
			myAccountHome = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		}
		else
		{
			String fileName = CommonConstants.ACCOUNT_HOME_PAGE_DATA;
			myAccountHome = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		}
		
		openAndValidate();
	}

	public AccountHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
//		openAndValidate();
	}

	public String getMyPlans() {
		return planBox.getText();
	}

	public BenefitsCoveragePage navigateToBnC() {

		benefitsLink.click();
		try {
			Thread.sleep(90000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title = driver.getTitle().toString();
		if (title.equalsIgnoreCase("UnitedHealthcare Medicare Solutions | Plan Benefits and Coverage")) {
			return new BenefitsCoveragePage(driver);
		}
		else
		return null;
	}

	public ManageDrugPage navigateToEstimateCost(String category) {

		estimateCostLink.click();
		if (getTitle().equalsIgnoreCase("Drug Cost Estimator") && category.equalsIgnoreCase(CommonConstants.GROUP)) {
			return new ManageDrugPage(driver,category);
		}
		else if((getTitle().equalsIgnoreCase("Drug Cost Estimator"))){
			return new ManageDrugPage(driver);
		}

		return null;
	}

	public PhrPage navigateToPhr() {

		phrTab.click();
		if (getTitle().equalsIgnoreCase(
						"UnitedHealthcare Medicare Solutions | My Personal Health Record")) {
			return new PhrPage(driver);
		}

		return null;

	}

	public PaymentHistoryPage navigateToPayments() {

		paymentsLink.click();


		if (getTitle().equalsIgnoreCase("Premium Payment History"))
			return new PaymentHistoryPage(driver);

		else
			return null;
	}

	public FormsandresourcesPage navigateToFormsandResourcePage() {

		formsAndResourcesLink.click();

		return null;

	}

	public PlanSummaryPage navigateToPlanSummary() {

		myPlansTab.click();

		CommonUtility.checkPageIsReady(driver);
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Plan Summary")) {
			return new PlanSummaryPage(driver);
		}

		return null;
	}

	public PharmacySearchPage navigateToPharmacyLocator() {
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.navigate().to("https://member.team-a-uhcmedicaresolutions.uhc.com/content/uhcm/home/pharmacy_search.html.html#/Pharmacy-Search-English");
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		/*pharmacyLocator.click();
		CommonUtility.waitForPageLoad(driver, pharmacyLocatorHeading, CommonConstants.TIMEOUT_30);
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Pharmacy Directory")) {
			return new PharmacySearchPage(driver);
		}*/
		return null;
	}
	
	public PharmacySearchPage navigateNonEnglishContent() {   //STORY 261070

		espanolLink.click();
		chineseLink.click();
		createPdfLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Pharmacy Directory")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}


	public DrugCostandBenefitSummaryPage navigateToPrescriptionDrugCostPage() {

		myMenuNavigator.click();
		prescriptionDrugCostBenefitSummaryLink.click();

		if (getTitle().equalsIgnoreCase(
						"UnitedHealthcare Medicare Solutions | Drug Cost and Benefits Summary")) {
			return new DrugCostandBenefitSummaryPage(driver);
		}

		return null;
	}

	public MyProfilesPage navigateToMyProfilesPage() {

		profAndPrefLink.click();
		CommonUtility.waitForPageLoad(driver, myProfilesHeading, CommonConstants.TIMEOUT_30);
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Personal Profile")) {
			return new MyProfilesPage(driver);
		}
		return null;

	}

	public ClaimSummaryPage navigateToMedicalClaimsSummary() {

		searchMedicalClaims.click();
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Claims")) {
			return new ClaimSummaryPage(driver);
		}

		return null;
	}

	public ClaimSummaryPage navigateToDrugClaimsSummary(String planCategory) {

		searchDrugClaims.click();
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Claims")) {
			/*if (planCategory.equalsIgnoreCase("Individual")) {
				return new ClaimSummaryPage(driver, planCategory);
			} else { */
				return new ClaimSummaryPage(driver);
			/*}*/
		}

		return null;
	}
public ContactUsPage navigatesToContactUsPage() {
		
		contactUsLink.click();
		if(getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | Contact Us"))
		{
			return new ContactUsPage(driver);
		}
		return null;
				
	}
	public MedicalEobPage navigateToMedicalEob() {

		/*
		 * myMenuNavigator.click(); medicalEobLink.click();
		 * CommonUtility.checkPageIsReady(driver);// Wait until complete page
		 * loads
		 * 
		 * if (driver.getCurrentUrl().contains("medical-eob-search.html")) {
		 * return new MedicalEobPage(driver); }
		 */
		return null;
	}

	public PrescriptionDrugEobPage navigateToPresDrugEob() {

		myMenuNavigator.click();
		prescriptionDrugEobLink.click();
		if (currentUrl().contains("part-d-eob-search.html")) {
			return new PrescriptionDrugEobPage(driver);
		}

		return null;
	}

	public OrderplanmaterialsPage navigateToOrderPlanMaterialsPage() {

		myMenuNavigator.click();
		orderPlanMaterials.click();
		CommonUtility.checkPageIsReady(driver);
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Order Plan Materials")) {
			return new OrderplanmaterialsPage(driver);
		}
		return null;
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : myAccountHome.getExpectedData().keySet()) {
			WebElement element = findElement(myAccountHome.getExpectedData()
					.get(key));
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
		System.out.println("accountHomeJson----->"+accountHomeJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject accountHomeExpectedJson = expectedDataMap
				.get(CommonConstants.MY_ACCOUNT_HOME);
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

	public PlanSummaryPage navigateToPlanSummary(String category) {
		myPlansTab.click();
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Plan Summary")
				&& category.equalsIgnoreCase(CommonConstants.GROUP)) {
			return new PlanSummaryPage(driver, category);
		} else if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Plan Summary")) {
			return new PlanSummaryPage(driver);
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
	public void validatePlanName(){
	    	String planName = LoginCommonConstants.PLAN_NAME;
	    	System.out.println(planName);
	    	List<WebElement> planWebElement = driver.findElements(By.xpath("//*[text()='"+LoginCommonConstants.PLAN_NAME+"']"));
	    	for(int i=0; i<planWebElement.size();i++){
	    		if(planWebElement.get(i).getText().contains("HealthSelect Medicare Rx ")){
	    			System.out.println("----------Failed due to presence of HealthSelect Medicare Rx ------------");
	    			Assert.fail();
	    		}
	    		else if(planWebElement.get(i).getText().equalsIgnoreCase(LoginCommonConstants.PLAN_NAME)){
	    			System.out.println("----------Plan name displayed as expected="+planName);
	    		} else{
	    			System.out.println("----------Failed because Plan NAme not present");
	    			Assert.fail();
	    		} 		 
	    	}
	 }

	
	/**
	* Below method will validate plan name: 'uhcMedicareCompleteChoicePPO'
	* Added as part of commandos team
	* @return
	*/
	public boolean isUHCMedicareCompleteChoicePPOPresent(){
	try{
	if(uhcMedicareCompleteChoicePPO.getText() == CommonConstants.SIERRA_PLAN_NAME){
	System.out.println("uhcMedicareCompleteChoicePPO is displayed ");
	}else{
	System.out.println("uhcMedicareCompleteChoicePPO.getText() >>>>>>   "+uhcMedicareCompleteChoicePPO.getText());
	}
	}catch(Exception e){
	return false;
	}
	return true;
	}

	public HealthAndWellnessPage navigateToHealthAndWellnessPage() {

		healthAndWellnessTab.click();
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Health and Wellness")) {
			return new HealthAndWellnessPage(driver);
		}

		return null;

	}
	
	public GoGreenPage navigateToGoGreenPage() {

		goGreenLink.click();
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Go Green")) {
			return new GoGreenPage(driver);
		}

		return null;

	}

	public void navigate_ProviderSearch() {
		validate(medicalProviders);
		medicalProviders.click();
	}
	
	public pages.dashboard.member.blayer.PaymentHistoryPage navigateToNewPaymentHistoryPage() {
		String NewPayHistoryUrl = "content/dashboard/home/Payments.html";
		String url = driver.getCurrentUrl();
		url = url.replace("home/my-account-home.html", NewPayHistoryUrl);
		driver.get(url);

		if (paymentsHeading.getText().contains("Premium Payments Overview")) {
			return new pages.dashboard.member.blayer.PaymentHistoryPage(driver);
		}
		return null;
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
	
	public FormsandresourcesPage navigateToFormsandResourceUmsPage() {

		formsAndResourcesLink.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Forms and Resources")) {
			return new FormsandresourcesPage(driver);
		} else

			return null;

	}
	
	
public FormsandresourcesPage navigateToMydocumentUmsPage() {
		
		MyDocumentLink.click();
		
		return null;
	}

	public FormsandresourcesPage navigatebackToformsandresourcesUmsPage() {
		
		backTopreviouspageLink.click();
		return null;
	}
	
    public FormsandresourcesPage navigateToviewdownloadlinkUmsPage() {
		
		viewanddownloadLink.click();
		
		return null;
	}

	public FormsandresourcesPage navigateTopaginationlinkUmsPage() {
		
		Select select = new  Select(driver.findElement(By.id("document-date")));
		select.selectByVisibleText("Current Year");
		
		paginationLink.click();
		
		return null;
	}

	public FormsandresourcesPage navigateTocustomsearchlinkUmsPage() {
		Select select = new  Select(driver.findElement(By.id("document-date")));
		select.selectByVisibleText("Custom Search");
		fromdate.sendKeys("01/04/2017");
		todate.sendKeys("01/07/2017");
		searchLink.click();
		return null;
	}

	public FormsandresourcesPage navigateTosortingsearchlinkUmsPage() {
		Select select = new  Select(driver.findElement(By.id("document-date")));
		select.selectByVisibleText("Current Year");
		dateLink.click();
		return null;
	}
	

	public PharmacySearchPage navigateToPharmacyLocatorSearchResults() {
		filterLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public PharmacySearchPage navigateTomultipleLanguageDropdownResultsearch() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		/*Select select = new  Select(driver.findElement(By.id("lang-select")));
		select.selectByVisibleText("español");*/
		//((JavascriptExecutor) driver).executeScript("return document.getElementById('lang-select').selectedIndex = '" + "español" + "'");
		driver.findElement(By.xpath("//select[@id='lang-select']/option[1]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public PharmacySearchPage navigateToPharmacySaverPharmaciesSearchResults() {
		Select select = new  Select(driver.findElement(By.id("plan-year")));
		select.selectByVisibleText("2016");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		select = new  Select(driver.findElement(By.id("plan-type")));
		select.selectByVisibleText("UnitedHealthcare MedicareComplete Plan 1 (HMO)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//pharmacyfilterLink.click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public PharmacySearchPage navigateToPreferedMailServiceWidgetResult() {
		//pharmacyfilterLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		widgetLink.isDisplayed();
		return null;
	}

	public PharmacySearchPage navigateToPrpnSearchAndBallonMarkerResult() {
		pharmacyfilterLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public PharmacySearchPage navigateToGetDirection() {
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		getdirectionLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}
	
	public PharmacySearchPage navigateToMoreInformation() {
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		//System.out.println(moreinformationLink.isEnabled());
		moreinformationLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public PharmacySearchPage navigateToFilterAndTooltip() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//System.out.println(filterLink.isEnabled());
		pharmacyfilterLink.click();
		//tooltipLink.mouseover();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}
	
	public FormsandresourcesPage navigateToMyPersonalHealthrecord() {
		myHealthRecordLink.click();
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		return null;
	}
	
	public FormsandresourcesPage navigateToPreferedPharmacyBenefit() {
		preferdPharmacyBenefitLink.click();
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		return null;
	}

	public FormsandresourcesPage navigateToAppointRepresentative() {
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		appointRepresentativeLink.click();
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		return null;
	}
	
	public FormsandresourcesPage navigateToprivacypolicyUms() {
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		privacypolicyLink.click();
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		return null;
	}
	
}