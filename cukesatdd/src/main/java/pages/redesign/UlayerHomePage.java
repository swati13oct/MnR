/**
 * 
 */
package pages.redesign;

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
import pages.redesign.EoBSearchPage;
import pages.redesign.*;

/**
 * @author sdwaraka
 */

@SuppressWarnings("unused")
public class UlayerHomePage extends UhcDriver {
	

	@FindBy(xpath = "//a[contains(text(), 'Go to Claims')]")
	private WebElement ClaimsLink;

	@FindBy(xpath = "//h1[contains(text(), 'My Claims')]")
	private WebElement ClaimsPageHeader;

	@FindBy(xpath = "//a[contains(text(), 'Go to EOB Search')]")
	private WebElement EOBsearchLink;
	
	@FindBy(xpath = "//h1[contains(text(), 'Explanation of Benefits')]")
	private WebElement EOBPageHeader;


	@FindBy(xpath = "//a[contains(text(), 'Go to My Profile and Preferences_Redesign')]")
	private WebElement MyProfileLink;

	@FindBy(xpath = "//h1[contains(text(), 'My Profile and Preferences')]")
	private WebElement MyProfilePageHeader;

	@FindBy(xpath = "//a[contains(text(), 'Go to Payments')]")
	private WebElement GoToPaymentsLink;

	@FindBy(xpath = "//a[contains(text(), 'Go to Contact Us')]")
	private WebElement GoToContactUsLnk;
	
	@FindBy(xpath = "//a[contains(text(), 'Go to Pharmacy Locator')]")
	private WebElement PharmacyLocatorLink;

	@FindBy(xpath = "//h1[contains(text(), 'Locate a Pharmacy')]")
	private WebElement PharmacyLocatorPageHeader;

	@FindBy(linkText = "Back to previous page")
	private WebElement backTopreviouspageLink;

	@FindBy(xpath = "//section[1]/div/div/div/a")
	private WebElement addordermaterialLink;

	@FindBy(xpath = "//a[contains(text(),'Go to Order ')]")
	private WebElement OrderPlanMaterialslnk;

	@FindBy(xpath = "//h3[contains(text(),'Technical Support') or contains(text(),'Plan Support')]/ancestor::div[@class='col-md-4']")
	private WebElement needhelpcomponent;

	@FindBy(xpath = "//h1[@class='h4 margin-none']")
	private WebElement orderplanHeadertxt;
	
	

	private PageData myAccountHome;

	public JSONObject accountHomeJson;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;

	public UlayerHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ACCOUNT_HOME_PAGE_DATA;
		myAccountHome = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		openAndValidate();
	}

	public PaymentHistoryPage navigateToPayments() {

		driver.navigate().to("https://"+MRScenario.environment+"-medicare.uhc.com/content/medicare/member/payments/overview.html");
/*		
		GoToPaymentsLink.click();
*/		CommonUtility.checkPageIsReady(driver);
		// paymentsLink.click();
		if (driver.getTitle().equalsIgnoreCase("Premium Payment History")
				|| driver.getTitle().equalsIgnoreCase("payments-overview")) {
			return new PaymentHistoryPage(driver);
		} else {
			return null;
		}
	}


	public MyProfilesPage navigateToProfAndPref() {

		//MyProfileLink.click();
		driver.navigate().to("https://"+MRScenario.environment+"-medicare.uhc.com/content/medicare/member/account/profile.html");
		
		CommonUtility.checkPageIsReady(driver);
		if (MyProfilePageHeader.isDisplayed()) {

			System.out.println("@@@@  My Profile and Preferences Page is Displayed  @@@@");
			return new MyProfilesPage(driver);
		} else {
			return null;
		}

	}

	public PharmacySearchPage navigateToPharmacyLocator() throws InterruptedException {
/*		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		PharmacyLocatorLink.click();
*/		
 		driver.navigate().to("https://"+MRScenario.environment+"-medicare.uhc.com/content/medicare/member/pharmacy-locator/overview.html#/Pharmacy-Search-English");
		Thread.sleep(8000);
		CommonUtility.checkPageIsReady(driver);
		if (validate(PharmacyLocatorPageHeader)) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public MedicalClaimSummaryPage navigateToMedicalClaimsSummary() {
		//ClaimsLink.click();
		
		driver.navigate().to("https://"+MRScenario.environment+"-medicare.uhc.com/content/medicare/member/claims.html#/overview");
		CommonUtility.checkPageIsReady(driver);
		if (validate(ClaimsPageHeader)) {
			System.out.println("Claims Page loaded");
			return new MedicalClaimSummaryPage(driver);
		} else {
			return null;
		}
	}

	public EoBSearchPage navigateToBenefitsAndCoverage() {
		driver.navigate().to("https://"+MRScenario.environment+"-medicare.uhc.com/content/medicare/member/eob.html");
		//EOBsearchLink.click();

		CommonUtility.checkPageIsReady(driver);

		if (validate(EOBPageHeader)) {
			System.out.println("EOB Page loaded");
			return new EoBSearchPage(driver);
		} else {
			return null;
		}
	}

	@Override
	public void openAndValidate() {
		CommonUtility.checkPageIsReady(driver);

		validate(OrderPlanMaterialslnk);
		validate(GoToContactUsLnk);
		// validate(formsAndResourcesLink);
		validate(ClaimsLink);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject accountHomeExpectedJson = expectedDataMap.get(CommonConstants.MY_ACCOUNT_HOME);

		return accountHomeExpectedJson;
	}

	public JSONObject getAdditionalPlanExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		JSONObject addPlanExpectedJson = expectedDataMap.get(CommonConstants.ADD_PLAN);
		JSONObject accountHomeExpectedJson = expectedDataMap.get(CommonConstants.MY_ACCOUNT_HOME);
		JSONObject accountHomeComboExpectedJson = expectedDataMap.get(CommonConstants.MY_ACCOUNT_HOME_COMBO);
		accountHomeExpectedJson = CommonUtility.mergeJson(accountHomeExpectedJson, globalExpectedJson);
		accountHomeExpectedJson = CommonUtility.mergeJson(accountHomeExpectedJson, addPlanExpectedJson);
		accountHomeExpectedJson = CommonUtility.mergeJson(accountHomeExpectedJson, accountHomeComboExpectedJson);
		return accountHomeExpectedJson;
	}

	public OrderplanmaterialsPage navigateToOrderPlanMaterialsPage() {
		driver.navigate().to("https://"+MRScenario.environment+"-medicare.uhc.com/content/medicare/member/order-materials/overview.html");
		//OrderPlanMaterialslnk.click();
		CommonUtility.checkPageIsReady(driver);
		if (orderplanHeadertxt.isDisplayed()) {
			return new OrderplanmaterialsPage(driver);
		}
		return null;
	}

	public ContactUsPage navigatesToContactUsPage() {

		//GoToContactUsLnk.click();
		driver.navigate().to("https://"+MRScenario.environment+"-medicare.uhc.com/content/medicare/member/contact-us/overview.html#/contact-us-two");
		CommonUtility.checkPageIsReady(driver);
		if (driver.findElement(By.xpath("//div[@ng-controller='contactUsCtrl']")).isDisplayed()){
			return new ContactUsPage(driver);
		} else {
			return null;
		}
	}

	public OrderplanmaterialsPage navigateToValidateOrderConfirmationInAarpPage() {
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		addordermaterialLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return null;
	}

	public OrderplanmaterialsPage verifyneedHelpcomponent() {
		boolean present;
		try {
			validate(needhelpcomponent);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		if (present)
			System.out.println("Able to find needhelp component");
		else
			System.out.println("No needhelp component is displayed");
		return null;
	}

	public OrderplanmaterialsPage verifyHeaderTextandSubtext() {
		boolean present;
		try {
			validate(orderplanHeadertxt);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		if (present)
			System.out.println("@@@@@ Able to find order plan header text @@@@@");
		else
			System.out.println("order plan header text is not displayed");
		return null;
	}

}
