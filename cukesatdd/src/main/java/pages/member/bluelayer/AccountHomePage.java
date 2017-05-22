/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.member.bluelayer.*;
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
	
	
	
	
	
	//plan link -.//*[@id='plan_box']/div/div[2]/div/p
	//group id -  .//*[@id='plan_box']/div/div[2]/div/table/tbody/tr[1]/td[2]
	//member id - .//*[@id='plan_box']/div/div[2]/div/table/tbody/tr[2]/td[2]
	//status - .//*[@id='plan_box']/div/div[2]/div/table/tbody/tr[3]/td[2]
	//myresource - .//*[@id='_content_uhcm_home_my-account-home_jcr_content_contentPar_myresource_contentParResource_teaser']
	//medical provider - .//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser']/div/div[2]/a[1]
	//mental health or substance use -  .//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser']/div/div[2]/a[2]
	//estimate costs - .//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_2']/div/div[2]/a
	//drug lookup -   .//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_2']/div/div[2]
	//pharmacy locator -  .//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_1']/div/div[2]
	//locate a pharmacy -   .//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_1']/div/div[2]/a
	

	
	
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
		
		openAndValidate();
	}

	public String getMyPlans() {
		return planBox.getText();
	}


	public PhrPage navigateToPhr() {

		phrTab.click();
		if (getTitle().equalsIgnoreCase(
						"UnitedHealthcare Medicare Solutions | My Personal Health Record")) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new PhrPage(driver);
		}

		return null;

	}


	public ManageDrugPage navigateToEstimateCost(String category) {
		List<WebElement> estimateCost = driver.findElements(By.xpath(".//*[@id='_content_campaigns_uhcm_home-myresources-main_home-myresources-main_jcr_content_par_teaser_2']/div/div[2]/a"));
		System.out.println("estimateCost size"+estimateCost.size());
		estimateCost.get(0).click();
		if (getTitle().equalsIgnoreCase("Drug Cost Estimator") && category.equalsIgnoreCase(CommonConstants.GROUP)) {
			return new ManageDrugPage(driver,category);
		}
		else if((getTitle().equalsIgnoreCase("Drug Cost Estimator"))){
			return new ManageDrugPage(driver);
		}

		return null;
	}

	public PlanSummaryPage navigateToPlanSummary() {

		List<WebElement> planNameLink = driver.findElements(By.xpath(".//*[@id='plan_box']/div/div[2]/div/p/a"));
		System.out.println("plan name size "+planNameLink.size());
		System.out.println("plan name "+planNameLink.get(0).getText());
		planNameLink.get(0).click();

		CommonUtility.checkPageIsReady(driver);
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Plan Summary")) {
			return new PlanSummaryPage(driver);
		}

		return null;
	}

	public PharmacySearchPage navigateToPharmacyLocator() {

		pharmacyLocator.click();
		CommonUtility.waitForPageLoad(driver, pharmacyLocatorHeading, CommonConstants.TIMEOUT_30);
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Pharmacy Directory")) {
			return new PharmacySearchPage(driver);
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


	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		System.out.println("Key set "+myAccountHome.getExpectedData().keySet());
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
	

	public void navigate_ProviderSearch() {
		validate(medicalProviders);
		medicalProviders.click();
		String baseWindowHdl = driver.getWindowHandle();
		driver.getWindowHandles();
		
		for(String h:driver.getWindowHandles()){
			driver.switchTo().window(h);
			if(!h.equals(baseWindowHdl)){
				driver.close();
			}
			
		}
		driver.switchTo().window(baseWindowHdl);		
	}
	
	public void navigateToHomePage() throws InterruptedException{
		Thread.sleep(10000);
		//driver.navigate().to("https://member.team-b-uhcmedicaresolutions.uhc.com/home/my-account-home.html");
		System.out.println("current url "+driver.getCurrentUrl());
		String homeUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/home/my-account-home.html";
		driver.get(homeUrl);
		//driver.close();
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
		
	
	public void validateTabs(){
		Assert.assertTrue("My Plans tab is not displayed",myPlansTab.isDisplayed());
		Assert.assertTrue("Health and Wellness Tab is not displayed",healthAndWellnessTab.isDisplayed());
		Assert.assertTrue("Personal Health Record Tab is not displayed",phrTab.isDisplayed());
		Assert.assertTrue("My Menu Navigatoris not displayed",myMenuNavigator.isDisplayed());
	}
	
	public void validatWidgetsndButtons(){
		Assert.assertTrue("My plans is not displayed",planBox.isDisplayed());
		//Assert.assertTrue("Status is not displayed",status.isDisplayed());
		Assert.assertTrue("Member Id is not displayed",memberId.isDisplayed());
		Assert.assertTrue("Group Id is not displayed",groupId.isDisplayed());
		if(!getPlanName().contains("PDP")){
			Assert.assertTrue("Medical providers is not displayed",medicalProviders.isDisplayed());
		}
		Assert.assertTrue("Estimate Cost Link is not displayed",estimateCostLink.isDisplayed());
		Assert.assertTrue("Pharmacy locator is not displayed",pharmacyLocator.isDisplayed());
		
	}
	
	public String getPlanName(){
		return planNameLink.getText();
	}
	
	public void navigateBack(){
		driver.navigate().back();
	}
	
	public void validateHomePage() throws InterruptedException{
		Thread.sleep(10000);
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Account Home")){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
		
	}
	
	public void validateHWTabsAndContent(){
		
		HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
		healthAndWellness.validateTabsAndContent();

	}
	
	public void validateHWLifeStyleTab(){
		HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
		healthAndWellness.validateLifeStyleTab();
	}
	
	public void validateHWLearningTab(){
		HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
		healthAndWellness.validateLearningTab();
	}
	
	public void validateHWRewardsTab(){
		HealthAndWellnessPage healthAndWellness = new HealthAndWellnessPage(driver);
		healthAndWellness.validateRewardsTab();
	}
	
	

}

