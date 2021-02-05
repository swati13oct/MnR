package pages.acquisition.commonpages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class CampaignExternalLinks extends UhcDriver {

	@FindBy(xpath = "//*[contains(@id,'cta-zipcode')]")
	private WebElement zipCodeField;

	public String testSiteUrl;
	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;
	private static String AARP_ACQISITION_PROD_PAGE_URL = MRConstants.AARP_URL_PROD;
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
	private static String UMS_ACQISITION_PROD_PAGE_URL = MRConstants.UHCM_URL_PROD;

	public static String PSC_CODE = "psccode";
	public static String FEDERAL_TFN = "federaltfn";
	public static String MEDSUPP_TFN = "medsupptfn";

	@FindBy(xpath = "//span[contains(text(),'Find Plans')]")
	private WebElement ShopEnrollButton;

	@FindBy(xpath = "//span[contains(text(),'Shop Plans')]")
	private WebElement ShopEnrollMedsuppButton;

	@FindBy(xpath = "//*[contains(@id,'change-location')]")
	private WebElement zipcodeChangeLink;

	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;

	@FindBy(xpath = "//div[@class='overview-main']//h2")
	private WebElement vppTop;

	@FindBy(xpath = "//button//span[contains(text(), 'Shop')]")
	private WebElement ArticlesEnrollButton;

	@FindBy(xpath = "//input[contains(@id,'find-plans-zip')]")
	private WebElement zipcodeEnter;

	@FindBy(xpath = "//button[contains(text(),'View Plans & Pricing')]")
	private WebElement submit;

	@FindBy(xpath = "//a[contains(@href,'https://www.uhcmedicaresolutions.com/medicare-education.html')]")
	private WebElement LearnAboutMedicareBtn;

	@FindBy(xpath = "//span[contains(text(),'Privacy')]")
	private WebElement privacylink;

	@FindBy(xpath = "//a[@data-asset-name='Find Plans & Pricing']")
	private WebElement findPlansPricing;

	@FindBy(xpath = "//h2[contains(text(),'View plans')]//following::input[contains(@id,'find-plans-zip')]")
	private WebElement zipcodeEnterFld;

	@FindBy(xpath = "//a[contains(@href,'https://www.uhcmedicaresolutions.com/medicare-plans.html')]")
	private WebElement getHelpFindingPlanBtn;

	@FindBy(xpath = "//h2[contains(text(),'View plans')]//following::a[contains(@href,'#modal--zip-finder')]")
	private WebElement locateZipcodeLink;

	@FindBy(xpath = "//h2[contains(text(),'View plans')]//following::button[contains(text(),'Find a Plan')]")
	private WebElement findPlanSubmitBtn;

	@FindBy(xpath = "//p[contains(@class,'c-tfn-fragment__headline')]")
	private WebElement tfnHeader;

	@FindBy(xpath = "//span[contains(text(),'Accessibility')]")
	private WebElement accessibilitylink;

	@FindBy(xpath = "//div[contains(@aria-label,'Disclaimer Information')]")
	private WebElement footerInfo;

	public CampaignExternalLinks(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		System.out.println("Current URL - " + driver.getCurrentUrl());

	}

	public void openUrl(String url) {
		// TODO Auto-generated method stub
		start(url);
	}

	@FindBy(xpath = "//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
	public static WebElement proactiveChatExitBtn;

	public void CheckiPerseptions() {
		CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn, 10); // do not change this to waitForPageLoadNew as
																			// we're not trying to fail the test if it
																			// isn't found
		try {
			if (proactiveChatExitBtn.isDisplayed())
				jsClickNew(proactiveChatExitBtn);
		} catch (Exception e) {
			System.out.println("Proactive chat popup not displayed");
		}
	}

	/**
	 * 
	 * @param site - ulayer or blayer
	 * @param path - path for the url To open Homepage+ path as per env,
	 */

	public void OpenPath(String site, String path) {
		if ("ULayer".equalsIgnoreCase(site)) {
			if (MRScenario.environment.equals("offline")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = AARP_ACQISITION_OFFLINE_PAGE_URL + path;
				driver.get(testSiteUrl);
			} else if (MRScenario.environment.equals("prod")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = AARP_ACQISITION_PROD_PAGE_URL + path;
				driver.get(testSiteUrl);
			} else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = AARP_ACQISITION_PAGE_URL + path;
				driver.get(testSiteUrl);
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
		} else if ("BLayer".equalsIgnoreCase(site)) {
			if (MRScenario.environment.equals("offline")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = UMS_ACQISITION_OFFLINE_PAGE_URL + path;
				driver.get(testSiteUrl);
			} else if (MRScenario.environment.equals("prod")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = UMS_ACQISITION_PROD_PAGE_URL + path;
				driver.get(testSiteUrl);
			} else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = UMS_ACQISITION_PAGE_URL + path;
				driver.get(testSiteUrl);
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
		}
	}

	private void CheckPageLoad() {
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: " + driver.getCurrentUrl());
		checkModelPopup(driver, 10);

	}

	public void navigateToUrl(String uRLpath) {

		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL : " + CurrentURL);
		String SiteURL = CurrentURL.split(".com")[0];
		System.out.println("Split URL : " + SiteURL);
		SiteURL = SiteURL + ".com/";
		System.out.println("Site URL : " + SiteURL);
		String NavigateToURL = SiteURL + uRLpath;
		System.out.println("Navigating to URL : " + NavigateToURL);
		driver.navigate().to(NavigateToURL);
		CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 35);
		System.out.println("Page Title : " + (driver.findElement(By.xpath("//title")).getText()));
	}

	public void clickOnmedicareplans11Link(String zipcode) {

		validateNew(zipcodeEnter);
		CommonUtility.waitForPageLoadNew(driver, zipcodeEnter, 30);
		sendkeys(zipcodeEnter, zipcode);
		validateNew(zipcodeEnter);
		CommonUtility.waitForPageLoadNew(driver, zipcodeEnter, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(submit);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("/plan-summary")) {
			System.out.println("****************Page is displayed  ***************" + CurrentRailURL);

			Assert.assertTrue(true);
		} else {
			Assert.fail("**************** Page is not displayed ***************");
		}
		CheckPageLoad();
		CheckiPerseptions();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public AcquisitionHomePage clickOnLearnAboutMedicareBtn() {
		validateNew(LearnAboutMedicareBtn);
		CommonUtility.waitForPageLoadNew(driver, LearnAboutMedicareBtn, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(LearnAboutMedicareBtn);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("=https%3A%2F%2Fwww.myuhcplans.com%2Fmorganstanley&subdomain=group")) {
			System.out.println("****************Page is displayed  ***************" + CurrentRailURL);
			CheckiPerseptions();
			return new AcquisitionHomePage(driver);
		}
		return null;
		/*
		 * else Assert.fail("**************** Page is not displayed ***************");
		 * CheckPageLoad(); try { Thread.sleep(3000); } catch (InterruptedException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	public void clickOnmedicareplans11PrivacyLink() {

		validateNew(privacylink);
		CommonUtility.waitForPageLoadNew(driver, privacylink, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(privacylink);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("&WT.mc_id=8000158")) {
			System.out.println("****************Page is displayed  ***************" + CurrentRailURL);

			Assert.assertTrue(true);
		} else {
			Assert.fail("**************** Page is not displayed ***************");
		}
		CheckPageLoad();
		CheckiPerseptions();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void clickFindPlansPricing() {
		String parentWindow = driver.getWindowHandle();
		findPlansPricing.click();
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
	}
	
	public AcquisitionHomePage validateShopForPlanLoaded() {
		if (driver.getCurrentUrl().contains("WT.mc_id=8012869")) {
			System.out.println("****************Page is displayed  ***************" + driver.getCurrentUrl());
			return new AcquisitionHomePage(driver);
		}
		return null;
	}

	public void validateMorganStanleyExternalPage(String tfnXpath, String expTfnNo) {
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("myuhcplans.com/morganstanley")) {
			Assert.assertTrue(true);
			System.out.println("Morgan Stanley External Link Page opens successsfully");
		} else
			Assert.fail("Morgan Stanley External Link page is not opening up");
		validateNew(LearnAboutMedicareBtn);
		validateNew(getHelpFindingPlanBtn);
		validateNew(zipcodeEnterFld);
		validateNew(locateZipcodeLink);
		validateNew(findPlanSubmitBtn);
		validateNew(tfnHeader);

		WebElement TFNelement = driver.findElement(By.xpath(tfnXpath));
		String actualTfnNo = TFNelement.getText();
		if (validateNew(TFNelement) && actualTfnNo.equals(expTfnNo))
			System.out.println("TFN is Displayed on Page : " + actualTfnNo);
		else
			Assert.fail("TFN elemnet is not found / TFN no is not same on page");

		System.out.println(tfnHeader.getText());
		System.out.print(TFNelement.getText());

		validateNew(accessibilitylink);
		validateNew(footerInfo);
	}
}