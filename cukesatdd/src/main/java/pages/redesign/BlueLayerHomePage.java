/**
 * 
 */
package pages.redesign;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.redesign.OrderplanmaterialsPage;
import pages.mypcp.SignInPage;
import pages.member.bluelayer.ContactUsPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;


/**
 * @author sdwaraka
 *
 */

public class BlueLayerHomePage extends UhcDriver {


	@FindBy(xpath = "//a[contains(text(), 'Go to Claims')]")
	private WebElement ClaimsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Go to EOB Search')]")
	private WebElement EOBsearchLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Go to My Profile')]")
	private WebElement MyProfileLink;

	@FindBy(xpath = "//*[@id='profilePreferencesController']//h1")
	private WebElement MyProfilePageHeader;

	@FindBy(xpath = "//a[contains(text(), 'Go to Payments')]")
	private WebElement GoToPaymentsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Go to Contact Us')]")
	private WebElement GoToContactUsLnk;
	
	@FindBy(linkText = "Go to Pharmacy Search page")
	private WebElement PharmacyLocatorLink;

	
	@FindBy(linkText = "Back to previous page")
	private WebElement backTopreviouspageLink;
	
	
	//@FindBy(linkText = "ORDER ADDITIONAL MATERIALS")
	@FindBy(xpath = "//section[1]/div/div/div/a")
	private WebElement addordermaterialLink;
	
	@FindBy(linkText="Go to order-plan-materials-dashboard(Uhcm-Group) page")
	private WebElement OrderPlanMaterialslnk;
	
	@FindBy(xpath="//h3[contains(text(),'Technical Support') or contains(text(),'Plan Support')]/ancestor::div[@class='col-md-4']")
	private WebElement needhelpcomponent;
	
	@FindBy(xpath="//h1[@class='h4 margin-none']")
	private WebElement orderplanHeadertxt;
	
	

	private PageData browserCheckData;

	private JSONObject browserCheckJson;
	
	private PageData myAccountHome;

	public JSONObject accountHomeJson;

	public BlueLayerHomePage(WebDriver driver,String category) {
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

	public BlueLayerHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
//		openAndValidate();
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

	public OrderplanmaterialsPage navigateToLinkOrderPlanMaterialsPage() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		OrderPlanMaterialslnk.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		if(driver.getTitle().equalsIgnoreCase("Order Plan Material")){
			return new OrderplanmaterialsPage(driver);
		}
		return null;
	}


	public MyProfilesPage navigateToProfAndPref() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);

		MyProfileLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CommonUtility.checkPageIsReady(driver);
		if (MyProfilePageHeader.isDisplayed()) {
			return new MyProfilesPage(driver);
		}
		else{
			return null;
		}

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


	@Override
	public void openAndValidate() {
		validate(OrderPlanMaterialslnk);
		validate(GoToContactUsLnk);
		// validate(formsAndResourcesLink);
		validate(ClaimsLink);

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
	
	
}