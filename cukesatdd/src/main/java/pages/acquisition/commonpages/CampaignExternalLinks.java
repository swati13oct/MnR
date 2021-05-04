package pages.acquisition.commonpages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
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

	@FindBy(xpath = "//a[contains(@href,'https://www.uhcmedicaresolutions.com/medicare-education.html')]")
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

	@FindBy(xpath = "//span[@class='card-link__arrow' and contains(text(),'Medicare Supplement')]")
	private WebElement MedicareSupplementInsurancePlans;
	
	@FindBy(xpath = "//a[contains(@href,'https://www.uhcmedicaresolutions.com/medicare-plans.html')]")
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
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("ma.aarpmedicareplans.com/")) {
			Assertion.assertTrue(true);
			System.out.println("AARP External Link Page opens successsfully");
		} else if (driver.getCurrentUrl().contains("ma.uhcmedicaresolutions.com/")) {
			Assertion.assertTrue(true);
			System.out.println("UHC External Link Page opens successsfully");
		} else
			Assertion.fail("AARP/UHC External Link page is not opening up");
		validateNew(tfnHeader);

		WebElement TFNelement = driver.findElement(By.xpath(tfnXpath));
		String actualTfnNo = TFNelement.getText();
		if (validateNew(TFNelement) && actualTfnNo.equals(expTfnNo))
			System.out.println("TFN is Displayed on Page : " + actualTfnNo);
		else
			Assertion.fail("TFN elemnet is not found / TFN no is not same on page");

		System.out.println(tfnHeader.getText());
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
	
	@FindBy(xpath = "//a[contains(@data-asset-name,'Find Plans in Your Area')]")
	private WebElement clickFindPlansinyourArea;
	
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

		if (CurrentRailURL.contains("https://www.uhcmedicaresolutions.com/plan-recommendation-engine.html")) {
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
}