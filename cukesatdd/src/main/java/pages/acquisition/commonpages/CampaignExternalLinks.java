package pages.acquisition.commonpages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import org.testng.Assert;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;

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
	
	@FindBy(xpath = "//a[contains(@href,'/medicare-education.html')]")
	private WebElement LearnAboutMedicareBtn;

	@FindBy(xpath = "//span[contains(text(),'Privacy')]")
	private WebElement privacylink;

	@FindBy(xpath = "//a[@data-asset-name='Find Plans & Pricing']")
	private WebElement findPlansPricing;
	
	@FindBy(xpath = "//p[contains(@class,'c-tfn-fragment__hours')]")
	private WebElement workingHrs;

	//--- locators for scenario 7 

	@FindBy(xpath = "//*[@id='button-94902407']")
	private WebElement planAndPricing;
	
	@FindBy(xpath = "//*[@id='button-127872393']")
	private WebElement estimateDrugCost;

	@FindBy(xpath = "//*[@id='card-62690855']/div[1]/h3")
	private WebElement lookupDrugs;


	@FindBy(xpath = "//*[@id='card-64402169']/div[1]/h3")
	private WebElement findPharmacy;
	
	@FindBy(xpath = "//*[@id='button-356498815']")
	private WebElement startnow;
	
	@FindBy(xpath = "//*[@id='card-943837503']/div[1]/h3")
	private WebElement comparePlanCost;
	
	@FindBy(xpath = "//*[@id='button-1708542647']")
	private WebElement ViewPlanAndPricingButton;

	@FindBy(xpath = "//div[@class='cmp-text']//a[@data-asset-name='View Plans & Pricing']")
	private WebElement ViewPlanAndPricingLink;
	
	@FindBy(xpath = "//*[@id='button-127872393']")
	private WebElement estimateDrugCostButton;
	
	@FindBy(xpath = "//a[contains(@data-asset-name,'Estimate Your Prescription')]")
	private WebElement dceExternalLink;
	
	@FindBy(xpath = "//a[contains(@data-asset-name,'Start Now')]")
	private WebElement preExternalLink;
	
	@FindBy(id = "zipcode")
	private WebElement ZipCodeTxtBx;

	@FindBy(id = "submit")
	private WebElement FindPlansButton;

//	--- locators for scenario 5

	@FindBy(xpath = "//h2[contains(text(),'View plans')]//following::input[contains(@id,'find-plans-zip')]")
	private WebElement zipcodeEnterFld;

	@FindBy(xpath = "//h2[contains(text(),'View plans')]//following::a[contains(@href,'#modal--zip-finder')]")
	private WebElement locateZipcodeLink;

	@FindBy(xpath = "//span[contains(@class,'link-text') and contains(text(),'Medicare Supplement')]")
	private WebElement MedicareSupplementInsurancePlans;
	
	@FindBy(xpath = "//a[contains(@href,'/medicare-plans.html')]")
	private WebElement getHelpFindingPlanBtn;

	@FindBy(xpath = "//h2[contains(text(),'View plans')]//following::button[contains(text(),'Find a Plan')]")
	private WebElement findPlanSubmitBtn;

	@FindBy(xpath = "//p[contains(@class,'c-tfn-fragment__headline')]")
	private WebElement tfnHeader;

	@FindBy(xpath = "//span[contains(text(),'Accessibility')]")
	private WebElement accessibilitylink;

	@FindBy(xpath = "//div[contains(@aria-label,'Disclaimer Information')]")
	private WebElement footerInfo;

	@FindBy(xpath = "(//div[@class='modal-body'])[1]")
	private WebElement countyModalVpp;

	@FindBy(id = "multiCountyCancelBtn")
	private WebElement cancelCountyModal;

	@FindBy(xpath = "//span[contains(@id,'plans_zip_head')]//h2")
	private WebElement zipcodeonpage;
	
	
	//Locators for Scenario 10 - New LPM

	@FindBy(xpath = "//*[contains(@href,'#modal--location-change')]")
	private WebElement LocationLink;


	@FindBy(xpath = "//button[contains(text(),'Change Location')]")
	private WebElement LocationBtn;


	@FindBy(xpath = "//p[contains(text(),'Please enter valid zip code')]")
	private WebElement EnterValidZipCode;

	@FindBy(xpath = "//input[@class='c-input js-state-zipcode']")
	private WebElement InputZipCode;


	@FindBy(xpath = "(//label[@class='c-input-control__label'])[1]")
	private WebElement FirstZipCode;


	@FindBy(xpath ="//button[contains(@id,'drawer')]")
	private WebElement RequestAnAppointMent;


	@FindBy(xpath ="//button[@type='submit']")
	private WebElement ReqAppsubmitBtn;


	@FindBy(xpath ="//p[@id='field-fname-error-msg']")
	private WebElement FirstNameErroMsg;

//Enter a first name and must contain only letters, spaces, hyphens and apostrophes

	@FindBy(xpath ="//input[@class='uhc-input uhc-input--block mobInput field-fname']")
	private WebElement FirstName;


	@FindBy(xpath ="//input[@class='uhc-input uhc-input--block mobInput field-lname']")
	private WebElement LastName;

	@FindBy(xpath ="//p[@id='field-lname-error-msg']")
	private WebElement LastNameErroMsg;

//Enter a last name and must contain only letters, spaces, hyphens and apostrophes


	@FindBy(xpath ="//input[@class='uhc-input uhc-input--block mobInput field-lname pac-target-input']")
	private WebElement Address1Input;

	@FindBy(xpath ="//p[@id='field-address1-error-msg']")
	private WebElement AddressErroMsg;
	
//Enter an address that contains only numbers, letters, apostrophe, comma, hyphen, pound, ampersand, or space

	@FindBy(xpath ="//input[@id='newsletter-input5']")
	private WebElement CityInput;

	@FindBy(xpath ="//p[@id='field-city-error-msg']")
	private WebElement CityErroMsg;


	@FindBy(xpath ="//a[contains(text(),'Find Plans in Your Area')]")
	private WebElement FindPlanInyourArea;

	@FindBy(xpath ="(//a[@class='tel ng-binding'])[1]")
	private WebElement FindPlanTFN;
	
	@FindBy(xpath = "//a[@data-asset-name='Find plans']")
	private WebElement FindPlansLink;

	@FindBy(xpath ="//a[contains(text(),'Find Your Doctor')]")
	private WebElement FindADoctor;

	@FindBy(xpath ="//span[contains(text(),'Privacy Policy')]")
	private WebElement PrivacyPolicy;


	@FindBy(xpath ="//span[@class='heading-1' and contains(text(),'Privacy Policy')]")
	private WebElement Heading;

	@FindBy(xpath ="//span[contains(text(),'Accessibility')]")
	private WebElement Accessibility;

	@FindBy(xpath ="//input[@id='zipcode']")
	private WebElement zip;

	@FindBy(xpath ="//input[@id='location']")
	private WebElement location;
	
	@FindBy(xpath = "//a[contains(@data-asset-name,'Drug cost estimator')]")
	private WebElement dceExternalLinktakeadvantage;
	
	@FindBy(xpath = "//a[contains(text(),'Estimate Your Prescription Drug Costs')]")
	private WebElement dceexternallinkMA;


//Enter a city that only contains non-numeric characters, apostrophe , hyphen or space

	@FindBy(xpath ="//select[@id='newsletter-input6']")
	private WebElement SelectState;

	@FindBy(xpath ="//p[@id='field-state-error-msg']")
	private WebElement SelectStateErroMsg;

//Select a State

	@FindBy(xpath ="//input[@id='newsletter-input9']")
	private WebElement phoneInput;

	@FindBy(xpath ="//p[@id='field-phoneNo-error-msg']")
	private WebElement PhoneErroMsg;




//Please enter  10 digit valid Phone Number


	@FindBy(xpath ="//input[@id='newsletter-input8']")
	private WebElement EmailInput;

	@FindBy(xpath ="//p[@id='field-ename-error-msg']")
	private WebElement EmailErroMsg;

//Please enter a valid email address


	@FindBy(xpath ="//input[@id='newsletter-input7']")
	private WebElement ZipInput;

	@FindBy(xpath ="//p[@id='field-zipCode-error-msg']")
	private WebElement ZipErroMsg;

//Enter a valid 5-digit ZIP code in the format 12345


	@FindBy(xpath = "(//span[contains(text(),'View Plans & Pricing')])[1]")
	private WebElement viewplanspricing;
	
	@FindBy(xpath = "//div[@id='zipErrorMessage-0']")
	private WebElement ziperrorMsg;

	@FindBy(xpath ="//input[@name='zipcodemeded-0']")
	private WebElement Zipinput;
	
	@FindBy(xpath = "(//a[@class='tel ng-binding'])[1]")
	private WebElement tfn;

	@FindBy(xpath = "//a[contains(@data-asset-name,'Find Plans in Your Area')]")
	private WebElement clickFindPlansinyourArea;

	@FindBy(xpath="//button[contains(text(),'Get More Information')]")
	private WebElement GetMoreInformation;
	
	@FindBy(xpath = "//a[@data-asset-name='Find Plans and Pricing']")
	private WebElement findPlansPricingtakeadvantage;
	
	
	@FindBy(xpath = "//a[@data-asset-name='View Plans & Pricing ']")
	private WebElement viewPricingBtn;
	
	@FindBy(xpath = "//span[@class='sam__button__text desktop-tfn-text']")
	private WebElement samTfn;
	
	@FindBy(xpath = "//a[@data-asset-name='Estimate Your Prescription Drug Costs ']")
	private WebElement PrescriptiondrugcostsBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Estimate Your Drug Costs')]")
	private WebElement EstimateDrugCost;

	
	@FindBy(xpath = "//a[contains(text(), 'Start Now')]")
	private WebElement StartNowBtn;
	
	
			
			@FindBy(xpath = "(//a[contains(text(), 'View Plans & Pricing')])[2]")
			private WebElement viewPricingBtn2;
			
	public String parentWindow;
	


	
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
	public WebElement proactiveChatExitBtn;

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

	
	public AcquisitionHomePage clickOnmedicareplans11Link(String zipcode) {

		validateNew(zipcodeEnter);
		CommonUtility.waitForPageLoadNew(driver, zipcodeEnter, 30);
		sendkeys(zipcodeEnter, zipcode);
		validateNew(zipcodeEnter);
		CommonUtility.waitForPageLoadNew(driver, zipcodeEnter, 30);
		parentWindow = driver.getWindowHandle();
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
		//Added Lines for zipcode
			
			String ExpectedZipcode = "33111";
			validateNew(zipcodeonpage);
			String ActualZipcode = zipcodeonpage.getText();

			System.out.println("Expected Zip code on a page: " + ExpectedZipcode);
			System.out.println("Actual Zip code on a page: " + ActualZipcode);

			if (ExpectedZipcode.contains(ActualZipcode))
				System.out.println(
						"****************Zipcode  was found macthing ***************");	
			//
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("**************** Zipcode is not displayed ***************");
		}
		CheckPageLoad();
		CheckiPerseptions();
		try {
			Thread.sleep(3000);
			return new AcquisitionHomePage(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		  return null;
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
		parentWindow = driver.getWindowHandle();
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
		 * else Assertion.fail("**************** Page is not displayed ***************");
		 * CheckPageLoad(); try { Thread.sleep(3000); } catch (InterruptedException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}
	
	public AcquisitionHomePage clickOnPlanandPricingBtn() {
		validateNew(planAndPricing);
		CommonUtility.waitForPageLoadNew(driver, planAndPricing, 30);
		parentWindow = driver.getWindowHandle();
		jsClickNew(planAndPricing);
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

		if (CurrentRailURL.contains("prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27#/plan-summary")) {
			System.out.println("****************Page is displayed  ***************" + CurrentRailURL);
			CheckiPerseptions();
			return new AcquisitionHomePage(driver);
		}
		return null;
		/*
		 * else Assertion.fail("**************** Page is not displayed ***************");
		 * CheckPageLoad(); try { Thread.sleep(3000); } catch (InterruptedException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	public GetStartedPage estimateDrugCostButton() {
		validateNew(estimateDrugCost);
		CommonUtility.waitForPageLoadNew(driver, estimateDrugCost, 10);
		parentWindow = driver.getWindowHandle();
		jsClickNew(estimateDrugCost);
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

		if (CurrentRailURL.contains("estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27#/getstarted")) {
			System.out.println("****************DCE Page is displayed***************" + CurrentRailURL);
//			checkModelPopup(driver, 10);
			return new GetStartedPage(driver);
		}
		return null;
		/*
		 * else Assertion.fail("**************** Page is not displayed ***************");
		 * CheckPageLoad(); try { Thread.sleep(3000); } catch (InterruptedException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}
	
	public GetStartedPage lookUpDrugButton() {
		validateNew(estimateDrugCostButton);
		CommonUtility.waitForPageLoadNew(driver, estimateDrugCostButton, 10);
		parentWindow = driver.getWindowHandle();
		jsClickNew(estimateDrugCostButton);
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

		if (CurrentRailURL.contains("estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27")) {
			System.out.println("****************Page is displayed  ***************" + CurrentRailURL);
			return new GetStartedPage(driver);
		}
		return null;
		/*
		 * else Assertion.fail("**************** Page is not displayed ***************");
		 * CheckPageLoad(); try { Thread.sleep(3000); } catch (InterruptedException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}
	public AcquisitionHomePage clickOnmedicareplans11PrivacyLink() {

		validateNew(privacylink);
		CommonUtility.waitForPageLoadNew(driver, privacylink, 30);
		parentWindow = driver.getWindowHandle();
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

		if (CurrentRailURL.contains("privacy-policy.html?")) {
			System.out.println("****************Page is displayed  ***************" + CurrentRailURL);

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("**************** Page is not displayed ***************");
		}
		CheckPageLoad();
		CheckiPerseptions();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new AcquisitionHomePage(driver);
		}
		return null;

	}
	
	
	public void clickFindPlansPricing() {
		parentWindow = driver.getWindowHandle();
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
		else if (driver.getCurrentUrl().contains("WT.mc_id=8012870")) {
			System.out.println("****************Page is displayed  ***************" + driver.getCurrentUrl());
			return new AcquisitionHomePage(driver);
		}
		return null;
	}

	public void validateMorganStanleyExternalPage(String tfnXpath, String expTfnNo) {
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("myuhcplans.com/morganstanley")) {
			Assertion.assertTrue(true);
			System.out.println("Morgan Stanley External Link Page opens successsfully");
		} else
			Assertion.fail("Morgan Stanley External Link page is not opening up");
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
			Assertion.fail("TFN elemnet is not found / TFN no is not same on page");

		System.out.println(tfnHeader.getText());
		System.out.print(TFNelement.getText());

		validateNew(accessibilitylink);
		validateNew(footerInfo);
	}

	public void validateMedicarePrescriptionDrugExternalPage(String tfnXpath, String expTfnNo) {
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("/medicare-prescription-drug-plans-52")) {
			Assertion.assertTrue(true);
			System.out.println("Medicare Prescription Drugs External Link Page opens successsfully");
		} else
			Assertion.fail("Medicare Prescription Drugs External  Link page is not opening up");
		
		validateNew(planAndPricing);
		validateNew(estimateDrugCost);
		validateNew(lookupDrugs);
		validateNew(findPharmacy);
	
		validateNew(comparePlanCost);
		validateNew(ViewPlanAndPricingButton);
		validateNew(estimateDrugCostButton);
		validateNew(startnow);
				

		WebElement TFNelement = driver.findElement(By.xpath(tfnXpath));
		String actualTfnNo = TFNelement.getText();
		if (validateNew(TFNelement) && actualTfnNo.equals(expTfnNo))
			System.out.println("TFN is Displayed on Page : " + actualTfnNo);
		else
			Assertion.fail("TFN elemnet is not found / TFN no is not same on page");

		System.out.println(tfnHeader.getText());
		System.out.print(TFNelement.getText());

		validateNew(accessibilitylink);
		validateNew(footerInfo);
	}

	
	public void validateAARPExternalPage(String tfnXpath, String expTfnNo, String expWorkingHrs) {
		threadsleep(5);
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: " + driver.getCurrentUrl());
		threadsleep(5);
		
		if (driver.getCurrentUrl().contains("ma.aarpmedicareplans.com/")) {
			Assertion.assertTrue(true);
			System.out.println("AARP External Link Page opens successsfully");
		} else if (driver.getCurrentUrl().contains("ma.uhcmedicaresolutions.com/")) {
			Assertion.assertTrue(true);
			System.out.println("UHC External Link Page opens successsfully");
		} else if (driver.getCurrentUrl().contains("aarpmedicareplans.com/")) {
			Assertion.assertTrue(true);
			System.out.println("AARP External Link Page opens successsfully");
		} else if (driver.getCurrentUrl().contains("uhcmedicaresolutions.com/")) {
			Assertion.assertTrue(true);
			System.out.println("UHC External Link Page opens successsfully");
		} else if (driver.getCurrentUrl().contains("stage-aarpmedicareplans.uhc.com/")) {
			Assertion.assertTrue(true);
			System.out.println("AARP External Link Page opens successsfully");
		} else if (driver.getCurrentUrl().contains("stage-uhcmedicaresolutions.uhc.com/")) {
			Assertion.assertTrue(true);
			System.out.println("UHC External Link Page opens successsfully");
		}else
			Assertion.fail("AARP/UHC External Link page is not opening up");
		threadsleep(8);
		//validateNew(tfnHeader);
		WebElement TFNelement = driver.findElement(By.xpath(tfnXpath));
		String actualTfnNo = TFNelement.getText();
		if (validateNew(TFNelement) && actualTfnNo.equals(expTfnNo))
			System.out.println("TFN is Displayed on Page : " + actualTfnNo);
		else
			Assertion.fail("TFN elemnet is not found / TFN no is not same on page");

		//System.out.println(tfnHeader.getText());
		System.out.print(TFNelement.getText());
		if(validate(workingHrs)) {
			Assertion.assertTrue("Working hours Displayed on Page : ", workingHrs.getText().trim().equals(expWorkingHrs));
		}
		}
	
	
	public AcquisitionHomePage clickOnmedicareplans11backLink(String zipcode) {
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("info.aarpmedicareplans.com/aarp-medicare-plans-11")) {
			System.out.println("aarpmedicareplans External Link naviagted back successsfully");
		}
			
		validateNew(zipcodeEnter);
		validateNew(submit);
		
	//	CommonUtility.waitForPageLoadNew(driver, zipcodeEnter, 30);
	//	CommonUtility.waitForPageLoadNew(driver, submit, 30);
	//	sendkeys(zipcodeEnter, zipcode);
	//	validateNew(zipcodeEnter);
	//	CommonUtility.waitForPageLoadNew(driver, zipcodeEnter, 30);
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

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("**************** Page is not displayed ***************");
		}
		CheckPageLoad();
		CheckiPerseptions();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new AcquisitionHomePage(driver);
		}
		  return null;
		}
	
	public void validateAARPMedicarePlans11ExternalPage(String tfnXpath, String expTfnNo) {
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("info.aarpmedicareplans.com/aarp-medicare-plans-11")) {
			Assertion.assertTrue(true);
			System.out.println("AARP Medicare plans11 External Link Page opens successsfully");
		} else
			Assertion.fail("AARP Medicare plans11 External Link page is not opening up");
		validateNew(zipcodeEnter);
		validateNew(submit);
		validateNew(privacylink);
	//	validateNew(locateZipcodeLink);
		validateNew(tfnHeader);
		
		WebElement TFNelement = driver.findElement(By.xpath(tfnXpath));
		String actualTfnNo = TFNelement.getText();
		if (validateNew(TFNelement) && actualTfnNo.equals(expTfnNo))
			System.out.println("TFN is Displayed on Page : " + actualTfnNo);
		else
			Assertion.fail("TFN elemnet is not found / TFN no is not same on page");

		System.out.println(tfnHeader.getText());
		System.out.print(TFNelement.getText());

		validateNew(accessibilitylink);
		validateNew(footerInfo);
	}
	
	public void navigateBacktoExternalurl(String url) {
		// TODO Auto-generated method stub
		start(url);
	}
	
	
	public void clickFindPlansinyourArea() {
		String parentWindow = driver.getWindowHandle();
		clickFindPlansinyourArea.click();
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
	}
	
	public void closeCurrentTabSwitchToParentTab() {
		driver.close();
		driver.switchTo().window(parentWindow);
		/*
		 * Set<String> tabs_windows = driver.getWindowHandles(); Iterator<String> itr =
		 * tabs_windows.iterator(); while (itr.hasNext()) { String window = itr.next();
		 * if (!parentWindow.equals(window)) { driver.switchTo().window(window); } }
		 */
	}

	public MedicareSupplementInsurancePlansPage medicareSupplementInsurancePlans() {
		scrollToView(MedicareSupplementInsurancePlans);
		jsClickNew(MedicareSupplementInsurancePlans);
		threadsleep(3);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_SUPPLEMENT_INSURANCE_PLANS)) {
			System.out.println("MS Insurance Plans Page opened successfully: URL-->" + driver.getCurrentUrl());
			CheckiPerseptions();
			return new MedicareSupplementInsurancePlansPage(driver);
		} else
			Assertion.fail("Error loading MS Insurance Plans Page");
		return null;
	}
	
	public void navigateToDCERedesignFromExternalPage() {
		parentWindow = driver.getWindowHandle();
		dceExternalLink.click();
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
	}

	public void navigateToPREGetStarted() {
		parentWindow = driver.getWindowHandle();
		preExternalLink.click();
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
	}

	public PharmacySearchPage navigateToPharmacyGetStarted() {
		parentWindow = driver.getWindowHandle();
		startnow.click();
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
		if (driver.getTitle().equalsIgnoreCase("Locate a Pharmacy Near You | UnitedHealthcare")) {
				return new PharmacySearchPage(driver);
		}
		return null;
	}

	public AcquisitionHomePage clickOnGetHelpFindingAPlanBtn() {
		validateNew(getHelpFindingPlanBtn);
		CommonUtility.waitForPageLoadNew(driver, getHelpFindingPlanBtn, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(getHelpFindingPlanBtn);
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

		if (CurrentRailURL.contains("/plan-recommendation-engine.html")) {
			System.out.println("****************PRE Page is displayed***************" + CurrentRailURL);
			checkModelPopup(driver, 10);
			return new AcquisitionHomePage(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage searchPlansWithOutCountyForMorganStanley(String zipcode) {

		waitForPageLoadSafari();
		checkModelPopup(driver, 10);

		validateNew(vppTop, 30);
		if (driver.getCurrentUrl().contains("health-plans")) {
			return new VPPPlanSummaryPage(driver);
		} else
			return null;
	}

	public VPPPlanSummaryPage searchPlanswithCountyForMorganStanley(String zipcode, String countyName) {
		CommonUtility.waitForPageLoad(driver, countyModalVpp, 15);
		if (validate(countyModalVpp))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));

		checkModelPopup(driver, 10);

		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void enterZipcodeFindPlan(String zipcode) {
		validateNew(zipcodeEnterFld);
		sendkeysNew(zipcodeEnterFld, zipcode);

		String parentWindow = driver.getWindowHandle();

		jsClickNew(findPlanSubmitBtn);
		waitForPageLoadSafari();

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

		if (CurrentRailURL.contains("health-plans"))
			System.out.println("****************Vpp Page is displayed***************" + CurrentRailURL);
	}

	public void viewPlansAndPricing() {
		validateNew(ViewPlanAndPricingButton);

		String parentWindow = driver.getWindowHandle();

		jsClickNew(ViewPlanAndPricingButton);
		waitForPageLoadSafari();

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

		if (CurrentRailURL.contains("health-plans"))
			System.out.println("****************Vpp Page is displayed***************" + CurrentRailURL);
	}

	public void linkToViewPlansAndPricing() {
		validateNew(ViewPlanAndPricingLink);

		String parentWindow = driver.getWindowHandle();

		jsClickNew(ViewPlanAndPricingLink);
		waitForPageLoadSafari();

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

		if (CurrentRailURL.contains("health-plans"))
			System.out.println("****************Vpp Page is displayed***************" + CurrentRailURL);
	}

	public VPPPlanSummaryPage searchPlansWithOutCountyForPDPExternalPage(String zipcode) {
		if (validate(countyModalVpp))
			jsClickNew(cancelCountyModal);
		threadsleep(3);

		validateNew(ZipCodeTxtBx);
		ZipCodeTxtBx.clear();
		sendkeysNew(ZipCodeTxtBx, zipcode);

		jsClickNew(FindPlansButton);

		waitForPageLoadSafari();
		checkModelPopup(driver, 10);

		validateNew(vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		} else
			return null;
	}

	public VPPPlanSummaryPage searchPlanswithCountyForPDPExternalPage(String zipcode, String county) {
		if (validate(countyModalVpp))
			jsClickNew(cancelCountyModal);
		threadsleep(3);

		validateNew(ZipCodeTxtBx);
		ZipCodeTxtBx.clear();
		sendkeysNew(ZipCodeTxtBx, zipcode);

		jsClickNew(FindPlansButton);

		CommonUtility.waitForPageLoad(driver, countyModalVpp, 15);
		if (validate(countyModalVpp))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + county + "']")));

		checkModelPopup(driver, 10);

		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}
	
	public void updateHrefUrlVPP_Script1(String env) {
		WebElement element= driver.findElement(By.xpath("(//*[contains(@id,'button') and contains(@href,'available-plans')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
		if(env.equalsIgnoreCase("stage")) {
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8012869&county=053&state=27')", element);
		}else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.aarpmedicareplans.com/health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8012869&county=053&state=27')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.aarpmedicareplans.com/health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8012869&county=053&state=27')", element);
		}
	}
		else {
			if(env.equalsIgnoreCase("stage"))
				js.executeScript("arguments[0].setAttribute('href','https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8012870&county=053&state=27')", element);
				else if (env.equalsIgnoreCase("offline")){
					js.executeScript("arguments[0].setAttribute('href','https://offline.uhcmedicaresolutions.com/health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8012870&county=053&state=27')", element);
				}
				else {
					js.executeScript("arguments[0].setAttribute('href','https://www.uhcmedicaresolutions.com/health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8012870&county=053&state=27')", element);
				}
		}
	}
	
	public void updateHrefUrlDCE_Script1(String env) {
		WebElement element= driver.findElement(By.xpath("//*[contains(@id,'button') and contains(@href,'estimate-drug')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
		if(env.equalsIgnoreCase("stage")) {
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-aarpmedicareplans.uhc.com/health-plans/estimate-drug-costs.html?WT.mc_id=8012869&county=053&state=27')", element);
		}
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.aarpmedicareplans.com/health-plans/estimate-drug-costs.html?WT.mc_id=8012869&county=053&state=27')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.aarpmedicareplans.com/health-plans/estimate-drug-costs.html?WT.mc_id=8012869&county=053&state=27')", element);
		}
		}
		else {
			if(env.equalsIgnoreCase("stage")) {
				js.executeScript("arguments[0].setAttribute('href','https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/estimate-drug-costs.html#/drug-cost-estimator?WT.mc_id=8012870&county=053&state=27')", element);
				}
				else if (env.equalsIgnoreCase("offline")){
					js.executeScript("arguments[0].setAttribute('href','https://offline.uhcmedicaresolutions.com/health-plans/estimate-drug-costs.html#/drug-cost-estimator?WT.mc_id=8012870&county=053&state=27')", element);
				}
				else {
					js.executeScript("arguments[0].setAttribute('href','https://www.uhcmedicaresolutions.com/health-plans/estimate-drug-costs.html#/drug-cost-estimator?WT.mc_id=8012870&county=053&state=27')", element);
				}
		}
	}
	
	public void updateHrefUrlPRE_Script1(String env) {
		WebElement element= driver.findElement(By.xpath("//*[contains(@id,'button') and contains(@href,'plan-recommendation')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
		if(env.equalsIgnoreCase("stage")) {
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-aarpmedicareplans.uhc.com/plan-recommendation-engine.html?WT.mc_id=8012869')", element);
		}
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.aarpmedicareplans.com/plan-recommendation-engine.html?WT.mc_id=8012869')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.aarpmedicareplans.com/plan-recommendation-engine.html?WT.mc_id=8012869')", element);
		}
		}
		else {
			if(env.equalsIgnoreCase("stage")) {
				js.executeScript("arguments[0].setAttribute('href','https://www.stage-uhcmedicaresolutions.uhc.com/plan-recommendation-engine.html?WT.mc_id=8012870')", element);
				}
				else if (env.equalsIgnoreCase("offline")){
					js.executeScript("arguments[0].setAttribute('href','https://offline.uhcmedicaresolutions.com/plan-recommendation-engine.html?WT.mc_id=8012870')", element);
				}
				else {
					js.executeScript("arguments[0].setAttribute('href','https://www.uhcmedicaresolutions.com/plan-recommendation-engine.html?WT.mc_id=8012870')", element);
				}
		}
	}
	
	public void updateHrefUrlVPP_Script7(String env) {
		WebElement element= driver.findElement(By.xpath("//*[@id='button-94902407']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(env.equalsIgnoreCase("stage"))
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-aarpmedicareplans.uhc.com/health-plans/prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27')", element);
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.aarpmedicareplans.com/health-plans/prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.aarpmedicareplans.com/health-plans/prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27')", element);
		}
	}
	
	public void updateHrefUrlDCE_Script7(String env) {
		WebElement element= driver.findElement(By.xpath("//*[@id='button-127872393']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(env.equalsIgnoreCase("stage"))
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-aarpmedicareplans.uhc.com/health-plans/estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27')", element);
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.aarpmedicareplans.com/health-plans/estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.aarpmedicareplans.com/health-plans/estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27')", element);
		}
	}
	
	public void updateHrefUrlDCE_Script7_1(String env) {
		WebElement element= driver.findElement(By.xpath("//*[@id='button-951820959']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(env.equalsIgnoreCase("stage"))
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-aarpmedicareplans.uhc.com/health-plans/estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27')", element);
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.aarpmedicareplans.com/health-plans/estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.aarpmedicareplans.com/health-plans/estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27')", element);
		}
	}
	
	public void updateHrefUrlPharmacy_Script7(String env) {
		WebElement element= driver.findElement(By.xpath("//*[@id='button-356498815']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(env.equalsIgnoreCase("stage"))
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-aarpmedicareplans.uhc.com/health-plans/aarp-pharmacy.html?WT.mc_id=8001024&county=053&state=27')", element);
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.aarpmedicareplans.com/health-plans/aarp-pharmacy.html?WT.mc_id=8001024&county=053&state=27')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.aarpmedicareplans.com/health-plans/aarp-pharmacy.html?WT.mc_id=8001024&county=053&state=27')", element);
		}
	}
	
	public void updateHrefUrlVPP_Script7_1(String env) {
		WebElement element= driver.findElement(By.xpath("//*[@id='button-1708542647']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(env.equalsIgnoreCase("stage"))
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-aarpmedicareplans.uhc.com/health-plans/prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27')", element);
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.aarpmedicareplans.com/health-plans/prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.aarpmedicareplans.com/health-plans/prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27')", element);
		}
	}
	
	public void updateHrefUrlPrivacyLink_Script7(String env) {
		WebElement element= driver.findElement(By.xpath("//span[contains(text(),'Privacy')]/.."));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(env.equalsIgnoreCase("stage"))
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-aarpmedicareplans.uhc.com/privacy-policy.html?WT.mc_id=8001024')", element);
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.aarpmedicareplans.com/privacy-policy.html?WT.mc_id=8001024')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.aarpmedicareplans.com/privacy-policy.html?WT.mc_id=8001024')", element);
		}
	}
	
	public void updateHrefUrlVPP_Script6(String env) {
		WebElement element= driver.findElement(By.xpath("//*[@id='zipfinder-277338403']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(env.equalsIgnoreCase("stage"))
		js.executeScript("arguments[0].setAttribute('data-url','https://www.stage-aarpmedicareplans.uhc.com/health-plans.html')", element);
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('data-url','https://offline.aarpmedicareplans.com/health-plans.html')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('data-url','https://www.aarpmedicareplans.com/health-plans.html')", element);
		}
	}
	
	public void updateHrefUrlPrivacyLink_Script6(String env) {
		WebElement element= driver.findElement(By.xpath("//span[contains(text(),'Privacy')]/.."));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(env.equalsIgnoreCase("stage"))
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-aarpmedicareplans.uhc.com/privacy-policy.html?WT.mc_id=8000158')", element);
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.aarpmedicareplans.com/privacy-policy.html?WT.mc_id=8000158')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.aarpmedicareplans.com/privacy-policy.html?WT.mc_id=8000158')", element);
		}
	}
	
	public void updateHrefUrlLearnMore_Script5(String env) {
		WebElement element= driver.findElement(By.xpath("//*[@id='button-1416089344']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(env.equalsIgnoreCase("stage"))
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-uhcmedicaresolutions.uhc.com/medicare-education.html?WT.mc_id=8002977&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Fmorganstanley&subdomain=group')", element);
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.uhcmedicaresolutions.com/medicare-education.html?WT.mc_id=8002977&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Fmorganstanley&subdomain=group')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.uhcmedicaresolutions.com/medicare-education.html?WT.mc_id=8002977&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Fmorganstanley&subdomain=group')", element);
		}
	}
	
	public void updateHrefUrlGetHelp_Script5(String env) {
		WebElement element= driver.findElement(By.xpath("//*[@id='button-563198609']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(env.equalsIgnoreCase("stage"))
		js.executeScript("arguments[0].setAttribute('href','https://www.stage-uhcmedicaresolutions.uhc.com/medicare-plans.html?WT.mc_id=8002977&coveragePerson=M&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Fmorganstanley&subdomain=group')", element);
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('href','https://offline.uhcmedicaresolutions.com/medicare-plans.html?WT.mc_id=8002977&coveragePerson=M&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Fmorganstanley&subdomain=group')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('href','https://www.uhcmedicaresolutions.com/medicare-plans.html?WT.mc_id=8002977&coveragePerson=M&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Fmorganstanley&subdomain=group')", element);
		}
	}
	
	public void updateHrefUrlVPP_Script5(String env) {
		WebElement element= driver.findElement(By.xpath("//*[@id='zipfinder-213300386']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(env.equalsIgnoreCase("stage"))
		js.executeScript("arguments[0].setAttribute('data-url','https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/available-plans.html')", element);
		else if (env.equalsIgnoreCase("offline")){
			js.executeScript("arguments[0].setAttribute('data-url','https://offline.uhcmedicaresolutions.com/health-plans/medicare-advantage-plans/available-plans.html')", element);
		}
		else {
			js.executeScript("arguments[0].setAttribute('data-url','https://www.uhcmedicaresolutions.com/health-plans/medicare-advantage-plans/available-plans.html')", element);
		}
	}

	public void validateErrorMsg() {
		threadsleep(8);
		validateNew(RequestAnAppointMent);
		RequestAnAppointMent.click();
		threadsleep(8);
		validateNew(ReqAppsubmitBtn);
		ReqAppsubmitBtn.click();
		threadsleep(8);
		validateNew(FirstNameErroMsg);
		Assert.assertEquals("Enter a first name and must contain only letters, spaces, hyphens and apostrophes", FirstNameErroMsg.getText());
		validateNew(LastNameErroMsg);
		Assert.assertEquals("Enter a last name and must contain only letters, spaces, hyphensand apostrophes", LastNameErroMsg.getText());
		validateNew(AddressErroMsg);
		Assert.assertEquals("Enter an address that contains only numbers, letters, apostrophe, comma, hyphen, pound, ampersand, or space", AddressErroMsg.getText());
		validateNew(CityErroMsg);
		Assert.assertEquals("Enter a city that only contains non-numeric characters, apostrophe , hyphen or space", CityErroMsg.getText());
		validateNew(SelectStateErroMsg);
		Assert.assertEquals("Please select state", SelectStateErroMsg.getText());
		validateNew(ZipErroMsg);
		Assert.assertEquals("Enter a valid 5-digit ZIP code in the format 12345", ZipErroMsg.getText());
		validateNew(EmailErroMsg);
		Assert.assertEquals("Please enter a valid email address", EmailErroMsg.getText());
		validateNew(PhoneErroMsg);
		//Assert.assertTrue( PhoneErroMsg.getText().trim().contains("Please enter  10 digit valid Phone Number"));
		Assert.assertEquals("Please enter 10 digit valid Phone Number", PhoneErroMsg.getText());
		System.out.println("@@PhoneNumebr@@"+PhoneErroMsg.getText());
	}

	public void enterdetais() {

		threadsleep(8);
		validateNew(FirstName);
		FirstName.clear();
		FirstName.sendKeys("test_MR_optum_R");
		LastName.clear();
		LastName.sendKeys("test_MR_optum_M");
		Address1Input.clear();
		Address1Input.sendKeys("455 Flatbush Ave");
		Address1Input.sendKeys(Keys.TAB);
		CityInput.clear();
		CityInput.sendKeys("Brooklyn");
		threadsleep(8);
		selectFromDropDownByText(driver, SelectState, "New York");
		ZipInput.clear();
		ZipInput.sendKeys("11238");
		EmailInput.clear();
		EmailInput.sendKeys("test@test.com");
		phoneInput.clear();
		phoneInput.sendKeys("800-800-8000");
		validateNew(ReqAppsubmitBtn);
		ReqAppsubmitBtn.click();
		threadsleep(5);
		driver.findElement(By.xpath("//button[@class='o-modal__close c-button c-button--naked u-text-nowrap']")).click();

	}
	public void validateFindPlansInyourArea() {
		validateNew(FindPlanInyourArea);
		FindPlanInyourArea.click();
		CommonUtility.waitForPageLoadNew(driver, zip, 30);
		Assert.assertTrue(true);
		Assert.assertEquals("1-855-264-3792", FindPlanTFN.getText());
	}
//	public void switchToNewTab() {
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));
//	}

	public void naviagteBack() {

		driver.navigate().back();
	}

	public void  validateFindADoc() {
		validateNew(FindADoctor);
		FindADoctor.click();

		CommonUtility.waitForPageLoadNew(driver, location, 30);
		Assert.assertTrue(true);
		Assert.assertEquals("https://connect.werally.com/county-plan-selection/uhc.mnr/zip?clientPortalCode=AARP1&backBtn=false", driver.getCurrentUrl());
	}

	//https://www.uhc.com/legal/accessibility

	public void validatePrivacy() {
		validateNew(PrivacyPolicy);
		String parentwindow=driver.getWindowHandle();
		PrivacyPolicy.click();
		switchToNewTab();
		CommonUtility.waitForPageLoadNew(driver, Heading, 30);
		Assert.assertEquals("Privacy Policy", Heading.getText());
		driver.close();
		driver.switchTo().window(parentwindow);

	}

	public void validateAccess() {
		validateNew(Accessibility);
		String parentwindow=driver.getWindowHandle();
		Accessibility.click();
		switchToNewTab();
		threadsleep(8);
		Assert.assertEquals("https://www.uhc.com/legal/accessibility", driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentwindow);
	}

	public void validateErrorMsgtakeadvantage() {
		threadsleep(8);
		validateNew(GetMoreInformation);
		GetMoreInformation.click();
		threadsleep(8);
		validateNew(ReqAppsubmitBtn);
		ReqAppsubmitBtn.click();
		threadsleep(8);
		validateNew(FirstNameErroMsg);
		Assert.assertEquals("Enter a first name and must contain only letters, spaces, hyphens and apostrophes", FirstNameErroMsg.getText());
		validateNew(LastNameErroMsg);
		Assert.assertEquals("Enter a last name and must contain only letters, spaces, hyphensand apostrophes", LastNameErroMsg.getText());
		validateNew(AddressErroMsg);
		Assert.assertEquals("Enter an address that contains only numbers, letters, apostrophe, comma, hyphen, pound, ampersand, or space", AddressErroMsg.getText());
		validateNew(CityErroMsg);
		Assert.assertEquals("Enter a city that only contains non-numeric characters, apostrophe , hyphen or space", CityErroMsg.getText());
		validateNew(SelectStateErroMsg);
		Assert.assertEquals("Please select state", SelectStateErroMsg.getText());
		validateNew(ZipErroMsg);
		Assert.assertEquals("Enter a valid 5-digit ZIP code in the format 12345", ZipErroMsg.getText());
		validateNew(EmailErroMsg);
		Assert.assertEquals("Please enter a valid email address", EmailErroMsg.getText());
		validateNew(PhoneErroMsg);
		//Assert.assertTrue( PhoneErroMsg.getText().trim().contains("Please enter  10 digit valid Phone Number"));
		Assert.assertEquals("Please enter 10 digit valid Phone Number", PhoneErroMsg.getText());
		System.out.println("@@PhoneNumebr@@"+PhoneErroMsg.getText());

	}

	public void enterdetailstakeadvantage() {
		threadsleep(8);
		validateNew(FirstName);
		FirstName.clear();
		FirstName.sendKeys("test-MR-optum-R");
		LastName.clear();
		LastName.sendKeys("test-MR-optum-M");
		Address1Input.clear();
		Address1Input.sendKeys("455 Flatbush Ave");
		Address1Input.sendKeys(Keys.TAB);
		CityInput.clear();
		CityInput.sendKeys("Brooklyn");
		threadsleep(8);
		selectFromDropDownByText(driver, SelectState, "New York");
		ZipInput.clear();
		ZipInput.sendKeys("11238");
		EmailInput.clear();
		EmailInput.sendKeys("test@test.com");
		phoneInput.clear();
		phoneInput.sendKeys("800-800-8000");
		validateNew(ReqAppsubmitBtn);
		ReqAppsubmitBtn.click();
		threadsleep(5);
		driver.findElement(By.xpath("//button[@class='o-modal__close c-button c-button--naked u-text-nowrap']")).click();

	}
	
	public void validateAARPExternalPageZipCode(String zipcodeSingle, String zipcodeMulti) {
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(LocationLink);
		LocationLink.click();
		threadsleep(5);
		validateNew(LocationBtn);
		LocationBtn.click();
		threadsleep(5);
		Assert.assertEquals("Please enter valid zip code", EnterValidZipCode.getText());
		InputZipCode.clear();
		InputZipCode.sendKeys(zipcodeSingle);
		threadsleep(8);
		LocationBtn.click();
		threadsleep(8);
		driver.navigate().refresh();
		CommonUtility.waitForPageLoad(driver, LocationLink, 30);
		LocationLink.click();
		threadsleep(8);
		InputZipCode.clear();
		InputZipCode.sendKeys(zipcodeMulti);
		jsClickNew(LocationBtn);
		threadsleep(3);
		FirstZipCode.click();
		jsClickNew(LocationBtn);
		
			
	}

	public void validatezipcodecomponent() {
		// TODO Auto-generated method stub
		
		waitforElementNew(viewplanspricing);
		viewplanspricing.click();
		
		waitforElementNew(ziperrorMsg);
		System.out.println("@@Zip error Message@@@"+ziperrorMsg.getText());
		Assert.assertEquals(ziperrorMsg.getText(), "Please enter a valid zip code");
		
		Zipinput.clear();
		Zipinput.sendKeys("33111");
		viewplanspricing.click();
		
		waitforElementNew(tfn);
		
		System.out.println("@@tfn@@"+tfn.getText());
		Assert.assertEquals(tfn.getText(), "1-855-264-3792");
		
//		//driver.navigate().back();
		
		
	}

	public void clickFindPlansPricingtakeadvantage() {
		parentWindow = driver.getWindowHandle();
		findPlansPricingtakeadvantage.click();
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
	}

		public void clickFindPlansLink() {
			parentWindow = driver.getWindowHandle();
			FindPlansLink.click();
			Set<String> tabs_windows = driver.getWindowHandles();
			Iterator<String> itr = tabs_windows.iterator();
			while (itr.hasNext()) {
				String window = itr.next();
				if (!parentWindow.equals(window)) {
					driver.switchTo().window(window);
				}
			}
}

		public void clickonViewpricingAndNavigatesToVPP() {
			
			waitforElementNew(viewPricingBtn);
			viewPricingBtn.click();
			threadsleep(4);
			waitforElementNew(samTfn);
			
		}

		public void clickonPrescriptionDrugCostAndNavigatesToDCE() {
			// TODO Auto-generated method stub
			waitforElementNew(PrescriptiondrugcostsBtn);
			PrescriptiondrugcostsBtn.click();
			threadsleep(4);
			waitforElementNew(samTfn);
			
		}

		public void clickonEstimateDrugCostBtnAndNavigatesToDCE() {
			waitforElementNew(EstimateDrugCost);
			EstimateDrugCost.click();
			threadsleep(4);
			waitforElementNew(samTfn);
		}

		public void clickonStartNowAndNavigatesToPharmacyPage() {
			// TODO Auto-generated method stub
			waitforElementNew(StartNowBtn);
			StartNowBtn.click();
			threadsleep(4);
			waitforElementNew(samTfn);
		}

		public void clickonViewPlanPricingBtnAndNavigatesToVPP() {
			waitforElementNew(viewPricingBtn2);
			viewPricingBtn2.click();
			threadsleep(4);
			waitforElementNew(samTfn);
			
		}

		public void navigateToPath(String path) {
			// TODO Auto-generated method stub
			
		}

		public void navigateToDCERedesignFromExternaltakeadvantagePage() {
			// TODO Auto-generated method stub
			parentWindow = driver.getWindowHandle();
			dceExternalLinktakeadvantage.click();
			Set<String> tabs_windows = driver.getWindowHandles();
			Iterator<String> itr = tabs_windows.iterator();
			while (itr.hasNext()) {
				String window = itr.next();
				if (!parentWindow.equals(window)) {
					driver.switchTo().window(window);
				}
			}
			
		}
		
		public void validateDCEExternallinkMA() {
			parentWindow = driver.getWindowHandle();
			dceexternallinkMA.click();
			Set<String> tabs_windows = driver.getWindowHandles();
			Iterator<String> itr = tabs_windows.iterator();
			while (itr.hasNext()) {
				String window = itr.next();
				if (!parentWindow.equals(window)) {
					driver.switchTo().window(window);
				}
			}
}
}