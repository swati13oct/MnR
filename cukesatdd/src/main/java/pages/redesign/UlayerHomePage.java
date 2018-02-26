/**
 * 
 */
package pages.redesign;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

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
	
	public static String Page_URL;

	private PageData myAccountHome;

/*	public JSONObject accountHomeJson;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;*/

	public UlayerHomePage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ACCOUNT_HOME_PAGE_DATA;
		myAccountHome = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		Thread.sleep(3000);
		CommonUtility.checkPageIsReady(driver);
		
		Page_URL = driver.getCurrentUrl().split(".com")[0];
		//openAndValidate();
	}

	public PaymentHistoryPage navigateToPayments() throws InterruptedException {

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


	public MyProfilesPage navigateToProfAndPref() throws InterruptedException {

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
 		driver.navigate().to(Page_URL+".com/content/medicare/member/pharmacy-locator/overview.html#/Pharmacy-Search-English");
		Thread.sleep(10000);
		CommonUtility.checkPageIsReady(driver);
		if (validate(PharmacyLocatorPageHeader)) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public MedicalClaimSummaryPage navigateToMedicalClaimsSummary() throws InterruptedException {
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

	public EoBSearchPage navigateToBenefitsAndCoverage() throws InterruptedException {
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


	public OrderplanmaterialsPage navigateToOrderPlanMaterialsPage() throws InterruptedException {
		driver.navigate().to(Page_URL+".com/content/medicare/member/order-materials/overview.html");
		//OrderPlanMaterialslnk.click();
		CommonUtility.checkPageIsReady(driver);
		if (orderplanHeadertxt.isDisplayed()) {
			return new OrderplanmaterialsPage(driver);
		}
		return null;
	}

	public ContactUsPage navigatesToContactUsPage() throws InterruptedException {

		//GoToContactUsLnk.click();
		driver.navigate().to("https://"+MRScenario.environment+"-medicare.uhc.com/content/medicare/member/contact-us/overview.html#/contact-us-two");
		CommonUtility.checkPageIsReady(driver);
		if (driver.findElement(By.xpath("//div[@ng-controller='contactUsCtrl']")).isDisplayed()){
			return new ContactUsPage(driver);
		} else {
			return null;
		}
	}

	public OrderplanmaterialsPage navigateToValidateOrderConfirmationInAarpPage() throws InterruptedException {
		Thread.sleep(9000);
		addordermaterialLink.click();
		Thread.sleep(3000);
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
