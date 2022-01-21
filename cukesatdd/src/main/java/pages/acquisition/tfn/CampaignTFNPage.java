package pages.acquisition.tfn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

/**
 * @author sdwaraka
 *
 */

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;

public class CampaignTFNPage extends UhcDriver {

	// @FindBy(xpath= "//*[contains(@id,'cta-zipcode')]")
	@FindBy(xpath = "//*[contains(@id,'zipcodemeded-0') or contains(@id,'cta-zipcode')]")
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

	// @FindBy(xpath = "//*[contains(@title,'Search')]")

	@FindBy(xpath = "//*[contains(@class,'gLFyf gsfi')]")
	public WebElement GoogleSearchField;

	@FindBy(xpath = "//*[@id='tsf']/div[2]/div/div[3]/center/input[1]")
	public WebElement GoogleSearchButton;

	// @FindBy(xpath = "//h3[contains(text(),'AARPï¿½ Medicare Plans from
	// UnitedHealthcareï¿½')]")
	@FindBy(xpath = "//a[contains(@href, 'https://www.aarpmedicareplans.com/health-plans/shop/medicare-advantage-plans.html')][1]")
	public WebElement AARPSearchLinkfromGoogle;

	// @FindBy(xpath = "//h3[contains(text(),'AARPï¿½ Medicare Advantage (Part C)
	// Plans ...')]")
	// @FindBy(xpath = "//h3[contains(text(),'AARP Medicare Advantage (Part C) Plans
	// | UnitedHealthcare')]")
	// @FindBy(xpath = "//h3[contains(text(),'AARP Medicare Advantage (Part C) Plans
	// | UnitedHealthcare') or contains(text(),'AARP Medicare Advantage (Part C)
	// Plans | UnitedHea')]")
	// @FindBy(xpath =
	// "//a[@href='https://www.aarpmedicareplans.com/shop/medicare-advantage-plans.html']")
	@FindBy(xpath = "//h3[contains(text(),'AARP Medicare Plans from UnitedHealthcare')]")
	// @FindBy(xpath = "(//h3//span[contains(text(),'AARP Medicare Advantage (Part
	// C) Plans | UnitedHealthcare') or contains(text(),'Shop AARP Medicare
	// Advantage Plans from UnitedHealthcare')])[1]")
	// @FindBy(xpath = "//*[contains(text(),'AARP Medicare Plans from
	// UnitedHealthcare')]")

	public WebElement AARPSearchLinkfromGoogle_alternative;

	// @FindBy(xpath = "(//a[contains(@href,'medicaresolutions')])[3]")
	// @FindBy(xpath = "//h3//span[contains(text(),'Learn More About Medicare
	// Advantage (Part C)') or contains(text(),'Find Medicare Plans Available from
	// UnitedHealthcare')]")
	// @FindBy(xpath = "//a//span[contains(text(),'Learn More About Medicare
	// Advantage (Part C) Plans - AARP ...')]")
	// @FindBy(xpath = "(//h3//span[contains(text(),'Learn More About Medicare
	// Advantage (Part C) Plans - AARP ...')])[2]")
	// @FindBy(xpath = "(//h3//span[contains(text(),'Learn More About Medicare
	// Advantage (Part C) Plans - AARP ...') or contains(text(),'Find Medicare
	// Advantage Plans from UnitedHealthcare')])")
	// @FindBy(xpath = "//a//h3[contains(text(),'Learn More About Medicare Advantage
	// (Part C) Plans - AARP ...') or contains(text(),'Find Medicare Plans Available
	// from UnitedHealthcare')]")
	// @FindBy(xpath = "//h3[contains(text(),'Learn More About Medicare Advantage
	// (Part C)') or contains(text(),'Find Medicare Plans Available from
	// UnitedHealthcare')]")
	// @FindBy(xpath = "//h3[contains(text(),'Find Medicare Plans Available from
	// UnitedHealthcare')]")
	// @FindBy(xpath =
	// "(//a[contains(@href,'https://www.uhcmedicaresolutions.com/shop/medicare-advantage-plan')])[3]")

	// @FindBy(xpath = "//*[contains(text(),'Learn More About Medicare Advantage
	// (Part C) Plans - UHC ..')]")
	// @FindBy(xpath = "(//h3[contains(text(),'Learn More About Medicare Advantage
	// (Part C) Plans')])/..")
	// @FindBy(xpath = "(//h3[contains(text(),'Medicare Advantage (Part C) Plans
	// from UnitedHealthcare')])/..")
	// @FindBy(xpath = "(//h3[contains(text(),'Learn More About Medicare Advantage
	// Plans')]")
	@FindBy(xpath = "//h3[normalize-space()='Learn More About Medicare Advantage Plans']")
	public WebElement UHCSearchLinkfromGoogle;

	@FindBy(xpath = "(//*[contains(text(),'Find Medicare Plans Available From UnitedHealthcareï¿½')])[2]")
	public WebElement UHCSearchLinkfromGoogle1;

	// @FindBy(xpath = "//*[@id='uh-search-box']")
	// @FindBy(xpath = "//input[@id='header-search-input']")
	@FindBy(xpath = "//label[text()='Search query']//following-sibling::input[1]")
	public WebElement YahooSearchField;

	// @FindBy(xpath = "//*[@id='uh-search-button']")
	// @FindBy(xpath = "//button[contains(@id,'search-button')]")
	@FindBy(xpath = "//button[@type='button']//following-sibling::input[1]")
	public WebElement YahooSearchBttn;

	// @FindBy(xpath = "//h3//a[contains(text(),'AARPï¿½ Medicare Advantage (Part C)
	// Plans')]")
	// @FindBy(xpath = "//h3//a[contains(text(),'AARP Medicare Advantage (Part C)
	// Plans | UnitedHealthcare')]")
	// @FindBy(xpath =
	// "//a[contains(@href,'https://www.aarpmedicareplans.com/health-plans/shop/medicare-advantage-plans/ma-plan-benefits.html')]")
	@FindBy(xpath = "//a[contains(text(),'AARP Medicare Plans from UnitedHealthcare')]")
	public WebElement YahooSearchResult;

	// a[contains(@href,'https://www.aarpmedicareplans.com/shop/medicare-advantage-plans.html')]
	@FindBy(xpath = "//a[contains(@href,'https://www.aarpmedicareplans.com/shop/medicare-advantage-plans.html')]")
	public WebElement YahooSearchResultshop;
	// @FindBy(xpath = "//h3//a[contains(text(),'Medicare Advantage (Part C)
	// Plans')]")
	@FindBy(xpath = "//h3//a[contains(text(),'Learn More About Medicare Advantage Plans')]")
	// @FindBy(xpath = "//h3//a[contains(text(),'Find Medicare Plans Available') or
	// contains(@href,'https://www.uhcmedicaresolutions.com/health-plans.html') or
	// contains(text(),'Learn More About Medicare Advantage (Part C) Plans')]")
	public WebElement YahooSearchResultUHC;

	@FindBy(xpath = "//*[@id='sb_form_q']")
	public WebElement bingSearchField;

	@FindBy(xpath = "//*[@class='b_searchboxSubmit']")
	public WebElement bingSearchBttn;

	// @FindBy(xpath =
	// "//a[contains(@href,'https://www.aarpmedicareplans.com/health-plans/shop/medicare-advantage-plans.html')]")
	// @FindBy(xpath =
	// "//a[contains(@href,'https://www.aarpmedicareplans.com/health-plans/shop/medicare-ad')]")
	// @FindBy(xpath = "//a[contains(text(),'AARP Medicare Plans from
	// UnitedHealthcare')]")
	@FindBy(xpath = "//a[contains(@href,'https://www.aarpmedicareplans.com/health-plans/shop/medicare-advantage-plans.html') or contains(text(),'AARP Medicare Plans from UnitedHealthcare')]")
	public WebElement AARPSearchLinkfromBing;

	// @FindBy(xpath =
	// "//a[contains(@href,'https://www.uhcmedicaresolutions.com/health-plans/shop/medicare-advantage-plans.html')]")
	// @FindBy(xpath = "//h2//a[contains(text(),'Find Medicare Plans ')]")
	//@FindBy(xpath = "//a[contains(@href,'https://www.uhcmedicaresolutions.com/health-plans/shop/medicare-advantage-plans.html')or contains(@href,'https://www.uhcmedicaresolutions.com/health-plans.html') or contains(@href,'https://www.uhcmedicaresolutions.com/shop/medicare-advantage-plans.html')]")
	
	@FindBy(xpath = "//a[normalize-space()='Learn More About Medicare Advantage Plans']")
	public WebElement UHCSearchLinkfromBing;

	// @FindBy(xpath = "//*[contains(@id,'zipcodemeded-0')]")
	@FindBy(xpath = "//input[contains(@id,'zipcodemeded')]")
	private WebElement zipCodeShopField;
	// @FindBy(xpath =
	// "(//*[contains(@id,'zipcodemeded')][1]//following-sibling::button)[1]")
	// @FindBy(xpath = "//button//span[contains(text(), 'Shop')]")
	// @FindBy(xpath = "//span[contains(text(),'Find Plans')]")
	@FindBy(xpath = "(//span[contains(text(),'Find Plans')])[2]")
	private WebElement ShopEnrollButton;

	// @FindBy(xpath = "//span[contains(text(),'Shop Plans')]")
	@FindBy(xpath = "//*[contains(@class,'zipCompForm-0')]//button[contains(@class,'uhc-zip-button')]")
	private WebElement ShopEnrollMedsuppButton;

	@FindBy(xpath = "//*[contains(@id,'change-location')]")
	private WebElement zipcodeChangeLink;
	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;
	@FindBy(xpath = "//div[@class='overview-main']//h2")
	private WebElement vppTop;

	@FindBy(xpath = "//button//span[contains(text(), 'Shop')]")
	private WebElement ArticlesEnrollButton;

	@FindBy(id = "msVppZipCode")
	private WebElement medSuppZipCode;

	// @FindBy(xpath = "//h1[contains(text(),'Medicare Supplement Insurance Plans
	// insured by')]")
	// private WebElement medsuppTitle;

	@FindBy(xpath = "//button[contains(@class,'viewPlans')]")
	private WebElement viewPlansBtnMedSupp;

	@FindBy(id = "mpaed-month")
	private WebElement part_A_monthDrpDwn;

	@FindBy(id = "mpaed-year")
	private WebElement part_A_yearDrpDwn;

	@FindBy(xpath = "//*[@id='mpaed-month']/option[2]")
	private WebElement Part_A_monthDrpDwnOption;

	@FindBy(xpath = "//*[@id='mpaed-year']/option[3]")
	private WebElement Part_A_yearDrpDwnOption;

	@FindBy(id = "mpbed-month")
	private WebElement part_B_monthDrpDwn;

	@FindBy(id = "mpbed-year")
	private WebElement part_B_yearDrpDwn;

	@FindBy(xpath = "//*[@id='mpbed-month']/option[2]")
	private WebElement Part_B_monthDrpDwnOption;

	@FindBy(xpath = "//*[@id='mpbed-year']/option[3]")
	private WebElement Part_B_yearDrpDwnOption;

	@FindBy(xpath = "//*[contains(@class,'viewPlans')]")
	WebElement ViewPlanMedSupPage;

	@FindBy(xpath = "(//*[contains(@for,'Gender_2')])[2]")
	private WebElement femaleGender;

	@FindBy(xpath = "(//*[contains(@for,'Gender_1')])[2]")
	private WebElement MaleGender;

	@FindBy(xpath = "(//button[contains(text(),'Start application')])[1]")
	// @FindBy(xpath =
	// "(//*[contains(@class,'swiper-content')]//*[contains(text(),'Start
	// application')])[1]")
	private WebElement Start_ApplicationBtn;

	@FindBy(xpath = "//input[@id='CurrentlyInsured_2']//..")
	private WebElement insuredStatus;

	@FindBy(xpath = "//button[@class='cta-button next-button action_next']")
	private WebElement nextButton;

	@FindBy(id = "FirstName")
	private WebElement firstName;

	@FindBy(id = "LastName")
	private WebElement lastName;

	@FindBy(xpath = "//*[@id='header-tfn-link']//span[contains(@class,'invoca_swap')]")
	private WebElement tfnHeaderLink;

	@FindBy(xpath = "(//*[contains(@class,'tel tfn')]//u)[1]")
	private WebElement tfnHeaderPopupLink;

	@FindBy(xpath = "(//*[contains(@id,'sam-call-button')]//*[contains(@class,'invoca_swap')])[1]")
	private WebElement samTFN;

	@FindBy(xpath = "(//*[contains(@class,'modal-body')]//*[contains(@class,'invoca_swap')])[1]")
	private WebElement samTFNPopupLink;

	@FindBy(xpath = "(//*[contains(@class,'modal-close')])[1]")
	private WebElement tfnHeaderPopupClose;

	@FindBy(xpath = "//h1[contains(normalize-space(),'AARP® Medicare Supplement Insurance Plans insured by UnitedHealthcare')]")
	private WebElement msPlansHeading;

	@FindBy(xpath = "//a[contains(@class,'samModalClose')]")
	private WebElement samTfnPopupClose;

	@FindBy(xpath = "//button[@aria-describedby='View plan details Plan F']")
	private WebElement ms3ViewPlanDetails;

	@FindBy(xpath = "//a[@class='back-to-plans resTopPadding10 back-arrow-left leftPadding20' and normalize-space()='Back to all plans']")
	private WebElement ms3BackToAllPlans;
	
	@FindBy(xpath = "//a[@class='uhc-link-button plandetails view-more-link' and @plancode='F01']")
	private WebElement ms4ViewPlanDetails;

	@FindBy(xpath = "//a[@class='uhc-link-button back-to-plans' and normalize-space()='Back to plan list']")
	private WebElement ms4BackToPlanList;


	public CampaignTFNPage(WebDriver driver) {
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
		CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn, 10); // do not change this to
																			// CommonUtility.waitForPageLoadNew as we're
																			// not trying to fail the test if it isn't
																			// found
		try {
			if (proactiveChatExitBtn.isDisplayed())
				jsClickNew(proactiveChatExitBtn);
		} catch (Exception e) {
			System.out.println("Proactive chat popup not displayed");
		}
	}

	/**
	 * 
	 * @param site
	 *            - ulayer or blayer
	 * @param path
	 *            - path for the url To open Homepage+ path as per env,
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
				System.out.println("Final URL" + testSiteUrl);
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
		if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver, 10);

	}

	public HashMap<String, String> retrieveTFNcookie() {
		System.out.println("Current URL - " + driver.getCurrentUrl());
		Cookie cookietfn = driver.manage().getCookieNamed("TFNSessionCookie");
		System.err.println(cookietfn);
		String str = cookietfn.toString();
		System.out.println("TFN Cookie Value - " + str);
		
		/*
		 * String sep = str.contains(",") ? "," : "%2C"; String[] arrOfStr =
		 * str.split("%2C"); arrOfStr = str.split(sep);
		 */
		

		
		String[] arrStr = str.split(";"); 
		String[] arrOfStr = arrStr[0].split("%2C");
		//if (str.contains(",")) { arrOfStr = str.split(","); }
		
		String PSC_Code;
		String FedTFN;
		String MedSuppTFN;
		String SRC_Code;

		for (String a : arrOfStr)

			System.out.println(a);
		String PSC_Code_Str = arrOfStr[0];
		String[] arrStr_1 = PSC_Code_Str.split("=");

		PSC_Code = arrStr_1[1];
		SRC_Code = arrOfStr[1];
		FedTFN = arrOfStr[2];
		MedSuppTFN = arrOfStr[3];

		System.out.println("Campaign PSC code - " + PSC_Code);
		System.out.println("Source code - " + SRC_Code);
		System.out.println("Federal TFN - " + FedTFN);
		System.out.println("MedSupp TFN - " + MedSuppTFN);

		HashMap<String, String> tfnCookieValues = new HashMap<String, String>();
		tfnCookieValues.put("PSC Code", PSC_Code);
		tfnCookieValues.put("Source Code", SRC_Code);
		tfnCookieValues.put("Fed TFN", FedTFN);
		tfnCookieValues.put("Medsup TFN", MedSuppTFN);
		System.out.println(tfnCookieValues);
		return tfnCookieValues; 

		
		/*
		 * getLoginScenario().saveBean(TFNCommonConstants.PSC_CODE, PSC_Code);
		 * getLoginScenario().saveBean(TFNCommonConstants.FEDERAL_TFN, FedTFN);
		 * getLoginScenario().saveBean(TFNCommonConstants.MEDSUPP_TFN, MedSuppTFN);
		 */	
		}

	

	public void validatePSCcode(String ExpectedpscCode, String actualPscCode) {

		// String PSC_Code = PSC_CODE;
		System.out.println("Expected PSC code: " + ExpectedpscCode);
		System.out.println("Actual PSC code: " + actualPscCode);

		if (ExpectedpscCode.contentEquals(actualPscCode)) {
			System.out.println(
					"****************Expected PSC Code matches Actual PSC code from TFN cookie ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail(
					"****************Expected PSC Code DOES NOT match Actual PSC code from TFN cookie ***************");
		}
		// TODO Auto-generated method stub

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

	public void validateFederalTFN(String tFN_Xpath) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement TFNelement = driver.findElement(By.xpath(tFN_Xpath));
		validateNew(TFNelement);
		if (validateNew(TFNelement) && TFNelement.isDisplayed()) {
			System.out.println("TFN is Displayed on Page : " + TFNelement.getText());
		} else {
			Assertion.fail("TFN elemnet is not found / displayed on page : " + tFN_Xpath);
		}
		String TFNonPage = TFNelement.getText();
		/*
		 * if (TFNonPage.contains(FEDERAL_TFN)) {
		 * System.out.println("Correct Federal TFN is Displayed on Page : " +
		 * TFNelement.getText()); } else {
		 * Assertion.fail("TFN displayed is INCORRECT for Federal : " + tFN_Xpath); }
		 */

	}

	public void validateMedSuppTFN(String tFN_Xpath) {
		WebElement TFNelement = driver.findElement(By.xpath(tFN_Xpath));
		validateNew(TFNelement);
		if (validateNew(TFNelement) && TFNelement.isDisplayed()) {
			System.out.println("TFN is Displayed on Page : " + TFNelement.getText());
		} else {
			Assertion.fail("TFN elemnet is not found / displayed on page : " + tFN_Xpath);
		}
		String TFNonPage = TFNelement.getText();
		if (TFNonPage.contains(MEDSUPP_TFN)) {
			System.out.println("Correct Med Supp TFN is Displayed on Page : " + TFNelement.getText());
		} else {
			Assertion.fail("TFN displayed is INCORRECT for Med Supp Page : " + tFN_Xpath);
		}
	}

	public void navigateToCampaignURL(String campaignUrl, String envUrl) {
		System.out.println("Environment URL : " + envUrl);
		String NavigateToURL = envUrl + campaignUrl;
		System.out.println("Campaign URL : " + NavigateToURL);
		driver.navigate().to(NavigateToURL);
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 40);
		System.out.println("Page Title : " + (driver.findElement(By.xpath("//title")).getText()));
	}

	public void googleSearchAARP() {
		CommonUtility.waitForPageLoad(driver, GoogleSearchField, 30);
		validateNew(GoogleSearchField);
		GoogleSearchField.sendKeys("AARP Medicare Advantage Plan" + Keys.ENTER);
		System.out.println("Google Search entered for : AARP Medicare Advantage Plan");
		validateNew(AARPSearchLinkfromGoogle_alternative);
		AARPSearchLinkfromGoogle_alternative.click();
		System.out.println("Google Results - AARP Medicare Advantage Plan - Link Clicked");
		CheckPageLoad();
	}

	public void YahooSearchAARP() {

		CommonUtility.waitForPageLoad(driver, YahooSearchField, 30);
		YahooSearchField.sendKeys("AARP Medicare Advantage Plan");
		CommonUtility.waitForPageLoad(driver, YahooSearchBttn, 30);
		YahooSearchBttn.click();
		System.out.println("Yahoo Search entered for : AARP Medicare Advantage Plan");

		CommonUtility.waitForPageLoad(driver, YahooSearchResult, 30);
		if (YahooSearchResult.isDisplayed())
			System.out.println("Yahoo search result found");
		else {
			System.out.println("yahoo search result not found");
			Assertion.assertFalse("no yahoo search result found", false);
		}
		YahooSearchResult.click();
		System.out.println("Yahoo Results - AARP Medicare Advantage Plan - Link Clicked");
		switchToNewTab();
		CheckPageLoad();
	}

	public void YahooSearchAARPShopPages() {

		CommonUtility.waitForPageLoad(driver, YahooSearchField, 30);
		YahooSearchField.sendKeys("AARP Medicare Advantage Plan");
		CommonUtility.waitForPageLoad(driver, YahooSearchBttn, 30);
		YahooSearchBttn.click();
		System.out.println("Yahoo Search entered for : AARP Medicare Advantage Plan");

		CommonUtility.waitForPageLoad(driver, YahooSearchResultshop, 30);
		if (YahooSearchResultshop.isDisplayed())
			System.out.println("Yahoo search result found");
		else {
			System.out.println("yahoo search result not found");
			Assertion.assertFalse("no yahoo search result found", false);
		}
		YahooSearchResultshop.click();
		System.out.println("Yahoo Results - AARP Medicare Advantage Plan - Link Clicked");
		switchToNewTab();
		CheckPageLoad();
	}

	public void BingSearchAARP() {
		CommonUtility.waitForPageLoad(driver, bingSearchField, 30);

		bingSearchField.click();
		bingSearchField.clear();
		bingSearchField.sendKeys("AARP Medicare Advantage Plan" + Keys.ENTER);
		System.out.println("Looking for AARP medicare Plans link , please bear with me :) ");
		System.out.println("Current URL is ==  " + driver.getCurrentUrl());
		CommonUtility.waitForPageLoad(driver, AARPSearchLinkfromBing, 30);
		if (AARPSearchLinkfromBing.isDisplayed())
			System.out.println("Bing search result found");
		else {
			Assertion.assertFalse("Bing search result not found", false);
		}
		AARPSearchLinkfromBing.click();
		System.out.println("Bing Results - AARP Medicare Advantage Plan - Link Clicked");
		CheckPageLoad();
	}

	public void googleSearchUHC() {
		validateNew(GoogleSearchField);
		GoogleSearchField.sendKeys("UHC Medicare Advantage Plans" + Keys.ENTER);
		System.out.println("Google Search entered for : UHC Medicare Advantage Plan");
		validateNew(UHCSearchLinkfromGoogle);
		// UHCSearchLinkfromGoogle.click();
		jsClickNew(UHCSearchLinkfromGoogle);
		System.out.println("Google Results - UHC Medicare Advantage Plan - Link Clicked");
		CheckPageLoad();
	}

	public void YahooSearchUHC() {

		CommonUtility.waitForPageLoad(driver, YahooSearchField, 30);
		YahooSearchField.sendKeys("UHC Medicare Advantage Plan");
		CommonUtility.waitForPageLoad(driver, YahooSearchBttn, 30);
		YahooSearchBttn.click();
		System.out.println("Yahoo Search entered for : UHC Medicare Advantage Plan");

		CommonUtility.waitForPageLoad(driver, YahooSearchResultUHC, 30);
		if (YahooSearchResultUHC.isDisplayed())
			System.out.println("Yahoo search result found");
		else {
			System.out.println("yahoo search result not found");
			Assertion.assertFalse("no yahoo search result found", false);
		}
		YahooSearchResultUHC.click();
		System.out.println("Yahoo Results - UHC Medicare Advantage Plan - Link Clicked");
		switchToNewTab();
		CheckPageLoad();
	}

	public void BingSearchUHC() {
		CommonUtility.waitForPageLoad(driver, bingSearchField, 30);

		bingSearchField.click();
		bingSearchField.clear();
		bingSearchField.sendKeys("UHC Medicare Advantage Plan" + Keys.ENTER);
		System.out.println("Looking for UHC medicare Plans link , please bear with me :) ");
		System.out.println("Current URL is ==  " + driver.getCurrentUrl());
		CommonUtility.waitForPageLoad(driver, UHCSearchLinkfromBing, 30);
		if (UHCSearchLinkfromBing.isDisplayed())
			System.out.println("Bing search result found");
		else {
			Assertion.assertFalse("Bing search result not found", false);
		}
		UHCSearchLinkfromBing.click();
		System.out.println("Bing Results - UHC Medicare Advantage Plan - Link Clicked");
		CheckPageLoad();
	}

	public void navigateToPDPPlans() {
		(driver.findElement(By.xpath("//a[contains(@dtmname,'PDP:View Plans')]"))).click();
		;
		System.out.println("Navigated to PDP Plan Summary Page");
	}

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlansLink1;

	// @FindBy(id = "zipcodebtn")
	// @FindBy(id = "//button[contains(@id,'zipcodebtn')]")
	@FindBy(xpath = "//*[contains(@class,'uhc-zip-button') or contains(@id,'zipcodebtn')]")
	private WebElement findPlansButton;

	// @FindBy(xpath = "(//button[contains(@class,'zip-button')])[2]")
	@FindBy(xpath = "//button[contains(@class,'zip-button')]")
	private WebElement findPlansButtonExternalLinks;

	// @FindBy(id="cta-zipcode")
	@FindBy(xpath = "//*[contains(@id,'zipcodemeded-0') or contains(@id,'cta-zipcode')]")

	private WebElement HomePage_EnterZip;

	@FindBy(xpath = "(//input[contains(@id,'zipcode')])[2]")
	private WebElement HomePageExternalLinks_EnterZip;

	@FindBy(id = "nav-zipcode")
	private WebElement OurPlans_zipfield;

	@FindBy(xpath = "//*[@id = 'nav-zipcode']/following-sibling::button[@class = 'zip-button']")
	public WebElement OurPlans_viewPlansButton;

	// @FindBy(id="cta-zipcode")
	@FindBy(xpath = "//*[contains(@id,'zipcodemeded') or contains(@id,'cta-zipcode')]")
	private WebElement HomePageOLE_EnterZip;

	// @FindBy(id = "zipcodebtn")
	@FindBy(id = "//button[contains(@id,'zipcodebtn')]")
	private WebElement findPlansButtonOLE;

	public void SubNavPlanSearch(String zip) {
		CheckPageLoad();
		CheckiPerseptions();
		validateNew(OurPlansLink1);
		// Hover over text
		Actions action = new Actions(driver);
		action.moveToElement(OurPlansLink1).build().perform();
		// action.click().build().perform();
		validateNew(OurPlansLink1);
		validate(OurPlans_zipfield);
		OurPlans_zipfield.click();
		OurPlans_zipfield.sendKeys(zip);
		validate(OurPlans_viewPlansButton);
		OurPlans_viewPlansButton.click();
	}

	public void HomepagePlanSearch(String zip) {
		CheckPageLoad();
		CheckiPerseptions();

		// validateNew(OurPlansLink1);
		// Hover over text
		// Actions action = new Actions(driver);
		// action.moveToElement(OurPlansLink1).build().perform();
		// action.click().build().perform();
		// validateNew(OurPlansLink1);
		try {
			validate(surveyPopupNoBtn, 20);
			if (surveyPopupNoBtn.isDisplayed())
				jsClickNew(surveyPopupNoBtn);
		} catch (Exception e) {
			System.out.println("survey popup not displayed");
		}
		validate(HomePage_EnterZip);
		HomePage_EnterZip.click();
		HomePage_EnterZip.sendKeys(zip);
		validate(findPlansButton);
		findPlansButton.click();
	}

	public void HomepagePlanSearchOLE(String zip) {
		CheckPageLoad();
		CheckiPerseptions();

		// validateNew(OurPlansLink1);
		// Hover over text
		// Actions action = new Actions(driver);
		// action.moveToElement(OurPlansLink1).build().perform();
		// action.click().build().perform();
		// validateNew(OurPlansLink1);
		validate(HomePageOLE_EnterZip);
		HomePageOLE_EnterZip.click();
		HomePageOLE_EnterZip.sendKeys(zip);
		validate(findPlansButtonOLE);
		findPlansButtonOLE.click();
	}

	@FindBy(id = "plan-list-1")
	private WebElement maPlanList;

	@FindBy(id = "plan-list-3")
	private WebElement pdpPlanList;

	@FindBy(id = "plan-list-4")
	private WebElement snpPlanList;

	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='maviewplans']/following-sibling::a")
	private WebElement maPlansViewLink;

	// @FindBy(xpath = "//div[@class='overview-tabs
	// module-tabs-tabs']/div[4]//a[@class='trigger-closed']")
	// @FindBy(xpath = "//div[@class='overview-tabs
	// module-tabs-tabs']/div[4]//a[@class='trigger-closed ng-scope']")
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[contains(@ng-click,'viewSnp')]//*[contains(@aria-label,'Medicare Special')]")
	private WebElement snpPlansViewLink;

	// @FindBy(xpath = "//*[@class='overview-tabs
	// module-tabs-tabs']//*[contains(@ng-click,'MedSupp')]//*[@class='trigger-closed'][text()='View
	// Plans']")
	@FindBy(xpath = "//*[@class='overview-tabs module-tabs-tabs']//*[contains(@ng-click,'MedSupp')]//*[contains(@aria-label,'Medicare Supplement')]")
	private WebElement msPlansViewLink;

	@FindBy(xpath = "//*[contains(@class,'module-tabs-tabs')]/*[not (contains(@class,'active'))]//*[contains(@id,'pdpviewplans')]/following-sibling::*[contains(@aria-label,'View Plans')]")
	private WebElement pdpPlansViewLink;

	// @FindBy(id="msVppZipCode")
	// private WebElement medSuppZipCode;

	@FindBy(xpath = "//div[contains(@id,'plan-list-') and not(contains(@class,'ng-hide'))]/div[contains(@class,'plan-list-content')]")
	private WebElement planListContainer;

	public VPPPlanSummaryPage ViewPlanSummary(String planType) {
		CheckPageLoad();
		CheckiPerseptions();

		if (planType.equalsIgnoreCase("PDP")) {
			CommonUtility.waitForPageLoadNew(driver, pdpPlansViewLink, 30);
			// sleepBySec(2); //note: add sleep for timing issue, tried increase timeout
			// from CommonUtility.waitForPageLoadNew but didn't work
			pdpPlansViewLink.click();
			System.out.println("PDP Plan Type Clicked");
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
			return new VPPPlanSummaryPage(driver);
		} else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			CommonUtility.waitForPageLoadNew(driver, maPlansViewLink, 30);
			// sleepBySec(2);
			maPlansViewLink.click();
			System.out.println("MA Plan Type Clicked");
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
			return new VPPPlanSummaryPage(driver);
		} else if (planType.equalsIgnoreCase("MS")) {
			CommonUtility.waitForPageLoadNew(driver, msPlansViewLink, 30);
			// sleepBySec(2);
			msPlansViewLink.click();
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoadNew(driver, medSuppZipCode, 30);
			/*
			 * msPlansViewLink.click(); CommonUtility.waitForPageLoadNew(driver,
			 * medSuppPlanList.get(0), 30);
			 */
			return new VPPPlanSummaryPage(driver);
		} else if (planType.equalsIgnoreCase("MS4.0")) {
			CommonUtility.waitForPageLoadNew(driver, msPlansViewLink, 30);
			// sleepBySec(2);
			msPlansViewLink.click();
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoadNew(driver, msPlansHeading, 30);
			/*
			 * msPlansViewLink.click(); CommonUtility.waitForPageLoadNew(driver,
			 * medSuppPlanList.get(0), 30);
			 */
			return new VPPPlanSummaryPage(driver);
		} else if (planType.equalsIgnoreCase("SNP")) {
			// sleepBySec(5);
			CommonUtility.waitForPageLoadNew(driver, snpPlansViewLink, 30);
			snpPlansViewLink.click();
			System.out.println("SNP Plan Type Clicked");
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	@FindBy(xpath = "//div[contains(@class,'plan-list show active')]//div[contains(@class,'module-plan-overview')][1]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan') or contains(text(),'View Plan Details')]")
	private WebElement firstPlanDetailsLink;

	public void NavigateToPlanDetails(String planType) {
		CheckPageLoad();
		CheckiPerseptions();
		CommonUtility.waitForPageLoadNew(driver, firstPlanDetailsLink, 30);
		jsClickNew(firstPlanDetailsLink);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("View Plan Details Link is clicked for first plan for " + planType);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("#/details")) {
			Assertion.assertTrue("Plan Details is displayed for Plan Type : " + planType, true);
		} else {
			Assertion.assertTrue("Plan Details NOT Diaplyed for Plan Type : " + planType, false);
		}

	}

	@FindBy(xpath = "//div[contains(@class,'plan-list show active')]//div[contains(@class,'module-plan-overview')][1]//div[contains(@class,'enroll')]//*[contains(text(), 'Enroll in ')and (not(contains(@class,'ng-hide')))]")
	private WebElement firstEnrollPlanLink;

	public void NavigateToOLE(String planType) {
		CheckPageLoad();
		CheckiPerseptions();
		CommonUtility.waitForPageLoadNew(driver, firstEnrollPlanLink, 30);
		jsClickNew(firstEnrollPlanLink);
		waitForPageLoadSafari();
		System.out.println("Enroll In Plan Link is clicked for first plan for " + planType);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("welcome")) {
			Assertion.assertTrue("OLE Welcome Page is displayed for Plan Type : " + planType, true);
		} else {
			Assertion.assertTrue("OLE Welcome Page NOT Diaplyed for Plan Type : " + planType, false);
		}
	}

	@FindBy(xpath = "(//a[contains(@dtmname, 'Top Nav:Logo') and not(contains(@style, 'display:'))])[1]")
	//@FindBy(xpath="//a[contains(@dtmname, 'Top Nav:Logo') and (contains(@style,'display: block'))]")
	private WebElement HomeLogo;

	@FindBy(xpath = "//button[(contains(text(), 'Leave Online') )or (contains(@id, 'proceed'))]")
	// @FindBy(xpath="//div[contains(@id,'enroll-cancel')]//a[(contains(text(),
	// 'Leave Online'))]")
	private WebElement LeaveOLE;

	@FindBy(xpath = "(//a[contains(@dtmname, 'Top Nav:Logo') and not(contains(@style, 'display:'))])[1]")
	// @FindBy(xpath="(//a[contains(@dtmname, 'Top Nav:Logo')])[1]")
	private WebElement HomeLogoOle;

	public void NavigateToHomeFromPlanDetails() {
		CheckPageLoad();
		CheckiPerseptions();
		CommonUtility.waitForPageLoadNew(driver, HomeLogo, 30);
		jsClickNew(HomeLogo);
		System.out.println("Home Logo is clicked to navigate to Home Page");
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
		if (!validateNew(zipCodeField)) {
			Assertion.assertTrue("Home Page NOT Diaplyed", false);
		}
	}

	public void NavigateToHome() {
		// CheckPageLoad();
		// CheckiPerseptions();
		if (driver.getCurrentUrl().contains("online-application")) {
			CommonUtility.waitForPageLoadNew(driver, HomeLogoOle, 10);
			jsClickNew(HomeLogoOle);
			if (validate(LeaveOLE, 10)) {
				jsClickNew(LeaveOLE);
				System.out.println("Leave OLE is clicked to navigate to Home Page");
			}
		} else {
			CommonUtility.waitForPageLoadNew(driver, HomeLogo, 10);
			jsClickNew(HomeLogo);
			System.out.println("Home Logo is clicked to navigate to Home Page");
		}
		// CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
		if (!validateNew(zipCodeField)) {
			Assertion.assertTrue("Home Page NOT Displayed", false);
		}
	}

	@FindBy(xpath = "//div[@class='switch-field ng-scope']//label[@class='ng-binding'][contains(text(),'Shop for 2020 plans')]")
	private WebElement CurrentYearPlansBtn;

	public void handlePlanYearSelectionPopup() {
		CommonUtility.checkPageIsReadyNew(driver);
		if (validate(CurrentYearPlansBtn, 20)) {
			System.out.println("*****CLICKING ON Current Year button*****: " + CurrentYearPlansBtn.getText());
			jsClickNew(CurrentYearPlansBtn);
		}
	}

	@FindBy(xpath = "//*[@id='ip-no']")
	private WebElement surveyPopupNoBtn;

	public VPPPlanSummaryPage searchPlansWithOutCountyShopEnroll(String zipcode) throws InterruptedException {
		try {
			validate(surveyPopupNoBtn, 20);
			if (surveyPopupNoBtn.isDisplayed())
				jsClickNew(surveyPopupNoBtn);
		} catch (Exception e) {
			System.out.println("survey popup not displayed");
		}

		CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
		sendkeys(zipCodeShopField, zipcode);
		jsClickNew(ShopEnrollButton);
		waitForPageLoadSafari();
		// }
		CommonUtility.waitForPageLoadNew(driver, zipcodeChangeLink, 30);
		if (driver.getCurrentUrl().contains("health-plans")) {
			return new VPPPlanSummaryPage(driver);
		} else
			return null;
	}

	public VPPPlanSummaryPage searchPlansShopEnroll(String zipcode, String countyName) {
		CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
		sendkeys(zipCodeShopField, zipcode);
		jsClickNew(ShopEnrollButton);
		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		if (validate(countyModal))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage searchPlansWithOutCountyArticlePage(String zipcode) throws InterruptedException {

		CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
		sendkeys(zipCodeShopField, zipcode);
		jsClickNew(ArticlesEnrollButton);
		waitForPageLoadSafari();
		// }
		CommonUtility.waitForPageLoadNew(driver, zipcodeChangeLink, 30);
		if (driver.getCurrentUrl().contains("health-plans")) {
			return new VPPPlanSummaryPage(driver);
		} else
			return null;
	}

	public VPPPlanSummaryPage searchPlansShopArticlePage(String zipcode, String countyName) {
		CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
		sendkeys(zipCodeShopField, zipcode);
		jsClickNew(ArticlesEnrollButton);
		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		if (validate(countyModal))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	@FindBy(xpath = "//a[contains(text(),'Enroll in plan')]")
	private WebElement EnrollPlanLink;

	public void NavigateToOLEEnroll(String planType) {
		CheckPageLoad();
		CheckiPerseptions();
		CommonUtility.waitForPageLoadNew(driver, EnrollPlanLink, 30);
		jsClickNew(EnrollPlanLink);
		waitForPageLoadSafari();
		System.out.println("Enroll In Plan Link is clicked for first plan for " + planType);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("welcome")) {
			Assertion.assertTrue("OLE Welcome Page is displayed for Plan Type : " + planType, true);
		} else {
			Assertion.assertTrue("OLE Welcome Page NOT Diaplyed for Plan Type : " + planType, false);
		}
	}

	public void validateFederalTFNNo(String TFNXpath, String ExpecetdTFNNo) {
		CheckPageLoad();
		CheckiPerseptions();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validate(ActualTFNelement);
		// if(validateNew(TFNelement) && TFNelement.isDisplayed()) {
		// if(ExpecetdTFNNo.contains(ActualTFNelement.getText())) {
		// System.out.println("TFN is Displayed on Page : "+ActualTFNelement.getText());

		// }

		// else {
		// Assertion.fail("TFN elemnet is not found / displayed on page : "+TFNXpath);
	}

	// }

	public void validatebackpage() {

		driver.navigate().back();
	}

	public void validateRefreshpage() throws InterruptedException {

		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	public void validatecloseandReopenbroswer() throws InterruptedException {

		// Thread.sleep(2000);
		driver.close();
		//
	}

	@FindBy(xpath = "(//button//span[contains(text(),'View plan') or contains(text(),'View Plan Details')])[2]")
	private WebElement firstPlanDetailsLinkdce;

	public void NavigateToPlanDetailsdce(String planType) {
		CheckPageLoad();
		CheckiPerseptions();
		CommonUtility.waitForPageLoadNew(driver, firstPlanDetailsLinkdce, 30);
		jsClickNew(firstPlanDetailsLinkdce);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("View Plan Details Link is clicked for first plan for " + planType);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("#/details")) {
			Assertion.assertTrue("Plan Details is displayed for Plan Type : " + planType, true);
		} else {
			Assertion.assertTrue("Plan Details NOT Diaplyed for Plan Type : " + planType, false);
		}

	}

	@FindBy(xpath = "(//a[contains(text(),'Estimate your drug costs at a Walgreens preferred retail pharmacy')])[2]")
	private WebElement DCELink;

	public void NavigateToDCE() throws InterruptedException {

		validateNew(DCELink);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", DCELink);
		DCELink.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//a//span[contains(text(),'Enroll in plan')]")
	private WebElement EnrollPlanLinkDSNP;

	public void NavigateToOLEEnrollDSNP(String planType) {
		CheckPageLoad();
		CheckiPerseptions();
		CommonUtility.waitForPageLoadNew(driver, EnrollPlanLinkDSNP, 30);
		jsClickNew(EnrollPlanLinkDSNP);
		waitForPageLoadSafari();
		System.out.println("Enroll In Plan Link is clicked for first plan for " + planType);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("welcome")) {
			Assertion.assertTrue("OLE Welcome Page is displayed for Plan Type : " + planType, true);
		} else {
			Assertion.assertTrue("OLE Welcome Page NOT Diaplyed for Plan Type : " + planType, false);
		}
	}

	public void HomepagePlanSearchExternalLinks(String zip) {
		CheckPageLoad();
		CheckiPerseptions();

		// validateNew(OurPlansLink1);
		// Hover over text
		// Actions action = new Actions(driver);
		// action.moveToElement(OurPlansLink1).build().perform();
		// action.click().build().perform();
		// validateNew(OurPlansLink1);
		validate(HomePageExternalLinks_EnterZip);
		HomePageExternalLinks_EnterZip.click();
		HomePageExternalLinks_EnterZip.clear();
		HomePageExternalLinks_EnterZip.sendKeys(zip);
		validate(findPlansButtonExternalLinks);
		findPlansButtonExternalLinks.click();
	}

	@FindBy(xpath = "(//div[contains(@class,'plan-list show active')]//div[contains(@class,'module-plan-overview')][1]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'view plans') or contains(text(),'Enroll in Plan')])[2]")
	private WebElement VPPEnrollPlanLinkOLE;

	public void EnrollonVPPPage(String planType) {
		CheckPageLoad();
		CheckiPerseptions();
		CommonUtility.waitForPageLoadNew(driver, VPPEnrollPlanLinkOLE, 30);
		jsClickNew(VPPEnrollPlanLinkOLE);
		waitForPageLoadSafari();
		System.out.println("Enroll In Plan Link is clicked for first plan for " + planType);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("welcome")) {
			Assertion.assertTrue("OLE Welcome Page is displayed for Plan Type : " + planType, true);
		} else {
			Assertion.assertTrue("OLE Welcome Page NOT Diaplyed for Plan Type : " + planType, false);
		}
	}

	@FindBy(id = "msVppdpsd")
	private WebElement startDrpDwn;

	@FindBy(xpath = "//select[@id='msVppdpsd']//option[2]")
	private WebElement startDrpDwnOption;

	// @FindBy(id = "msVppDOB")
	@FindBy(xpath = "//input[contains(@id,'msVppDOB')]")
	private WebElement DOB;

	@FindBy(xpath = "//img[contains(@class,'d-lg-inline-block')]//following-sibling::p//a[@dtmid='cta_acq_ms_vpp']")
	private WebElement addYourInformation;

	public void MedSupFormValidationTFN(String DateOfBirth) throws InterruptedException {
		CheckPageLoad();
		CheckiPerseptions();
		validateNew(DOB, 30);
		System.out.println("MedSup page form is displayed");
		// DOB.click();
		jsClickNew(DOB);
		DOB.sendKeys(DateOfBirth);
		System.out.println("Date of birth is entered");
		Thread.sleep(2000);
		jsClickNew(MaleGender);
		Thread.sleep(2000);
		part_A_monthDrpDwn.click();
		Thread.sleep(2000);
		Part_A_monthDrpDwnOption.click();
		Thread.sleep(2000);
		System.out.println("Effective date- month value selected");
		jsClickNew(part_A_yearDrpDwn);
		Thread.sleep(2000);
		Part_A_yearDrpDwnOption.click();
		System.out.println("Effective date- year value selected");
		Thread.sleep(2000);
		part_B_monthDrpDwn.click();
		Thread.sleep(2000);
		Part_B_monthDrpDwnOption.click();
		Thread.sleep(2000);
		part_B_yearDrpDwn.click();
		Thread.sleep(2000);
		Part_B_yearDrpDwnOption.click();
		Thread.sleep(2000);
		scrollToView(startDrpDwn);
		jsClickNew(startDrpDwn);
		Thread.sleep(2000);
		startDrpDwnOption.click();
		System.out.println("Plan to start date selected");
		Thread.sleep(15000);
		jsMouseOver(ViewPlanMedSupPage);
		jsClickNew(ViewPlanMedSupPage);
	}

	@FindBy(xpath = "//a[@class='cancel-button modal-link']")
	private WebElement cancelButton;

	@FindBy(xpath = "(//a[contains(text(),'Cancel Application')])[3]")
	private WebElement cancelButtonPopUp;

	@FindBy(xpath = "(//a[contains(text(),'Return to Application')])[3]")
	private WebElement ReturntoApplicationButton;

	@FindBy(xpath = "//p[contains(text(),'Return to this application using the code below')]//..//span")
	private WebElement resumeKey;

	public String StartApplicationTFN(String FirstName, String LastName) throws InterruptedException {
		Thread.sleep(4000);
		CommonUtility.waitForPageLoadNew(driver, Start_ApplicationBtn, 20);
		jsClickNew(Start_ApplicationBtn);
		System.out.println("Start application button is clicked on application page");
		Thread.sleep(4000);
		// CommonUtility.waitForPageLoadNew(driver, insuredStatus, 20);
		// insuredStatus.click();
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		jsClickNew(nextButton);
		/*
		 * Thread.sleep(2000); String ResumeKey = resumeKey.getText();
		 * System.out.println("The return to the application code is- " + ResumeKey);
		 * jsClickNew(cancelButton); CommonUtility.waitForPageLoad(driver,
		 * cancelButtonPopUp, 30); jsClickNew(cancelButtonPopUp);
		 * System.out.println("Cancel application has been clicked on the pop up");
		 */
		return LastName;
	}

	public String CancelApplicationTFN(String FirstName, String LastName) throws InterruptedException {
		String ResumeKey = resumeKey.getText();
		System.out.println("The return to the application code is- " + ResumeKey);
		jsClickNew(cancelButton);
		CommonUtility.waitForPageLoad(driver, cancelButtonPopUp, 30);
		jsClickNew(cancelButtonPopUp);
		System.out.println("Cancel application has been clicked on the pop up");
		return ResumeKey;
	}

	public void closeOriginalTabAndOpenNewTab() {

		// get original tab handler
		String winHandleBefore = driver.getWindowHandle();

		System.out.println("Proceed to open a new blank tab as placeholder so the driver won't close");
		// open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('about:blank','_blank');");
		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equals(winHandleBefore)) {
				driver.switchTo().window(winHandle);
			}
		}
		String winHandleTmp = driver.getWindowHandle();
		System.out.println(
				"Proceed to close the original tab that has plans saved, should left with a blank tab afterward");
		driver.switchTo().window(winHandleBefore);
		driver.close();

		driver.switchTo().window(winHandleTmp);
		System.out.println("Proceed to open the acquisition url in new tab");
		if (MRScenario.environment.equalsIgnoreCase("prod")) {
			js.executeScript("window.open('" + AARP_ACQISITION_PROD_PAGE_URL + "','_blank');");
		} else {
			js.executeScript("window.open('" + AARP_ACQISITION_PAGE_URL + "','_blank');");
		}
		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equals(winHandleTmp)) {
				driver.switchTo().window(winHandle);
			}
		}
		String winHandleNew = driver.getWindowHandle();

		System.out.println("Proceed to close the placeholder blank tab");
		driver.switchTo().window(winHandleTmp);
		driver.close();

		System.out.println("Proceed to use this newly opened tab for remaining validation");
		driver.switchTo().window(winHandleNew);
	}

	@FindBy(xpath = "//a[contains(normalize-space(),'Make an appointment with a licensed insurance agent.')]")
	// @FindBy(xpath = "//*[contains(@class,'decisionGuide')//a)]")
	// @FindBy(xpath = "(//a[contains(@href,'https://www.myuhcagent.com/')])[1]")
	// @FindBy(xpath = "//a[contains(text(),'Click here to get your Decision
	// Guide')]")
	private WebElement FindAnAgentMedsupp;

	public void clickOnAgentLinkMedSup(String TFNXpath, String ExpecetdTFNNo) {

		validateNew(FindAnAgentMedsupp);
		CommonUtility.waitForPageLoadNew(driver, FindAnAgentMedsupp, 30);
		String parentWindow = driver.getWindowHandle();
		FindAnAgentMedsupp.click();
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

		if (CurrentRailURL.contains("myuhcagent")) {
			System.out.println("****************  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************  ***************");
		}
		CheckPageLoad();
		CheckiPerseptions();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);
		// if(validateNew(TFNelement) && TFNelement.isDisplayed()) {
		/*if (ExpecetdTFNNo.contains(ActualTFNelement.getText())) {
			System.out.println("TFN is Displayed on Page : " + ActualTFNelement.getText());

		}

		else {
			Assertion.fail("TFN elemnet is not found / displayed on page : " + TFNXpath);
		}*/

		driver.switchTo().window(parentWindow);

	}

	@FindBy(xpath = "(//a[contains(@href,'https://www.myuhcagent.com/')])[1]")
	private WebElement RightRail_FindAnAgentMedsupp;

	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickonFindanAgentlinkMedsupp(String ExpectedUHCAgentURL) {

		validateNew(RightRail_FindAnAgentMedsupp);
		CommonUtility.waitForPageLoadNew(driver, RightRail_FindAnAgentMedsupp, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(RightRail_FindAnAgentMedsupp);
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
		String CurrentUHCAgentURL = driver.getCurrentUrl();
		String ActualCurrentUHCAgentURL = CurrentUHCAgentURL.substring(0, 27).trim();
		System.out.println("myuhcagent Page is displayed : " + ActualCurrentUHCAgentURL);
		System.out.println("Expected myuhcagent URL: " + ExpectedUHCAgentURL);
		System.out.println("Actual myuhcagent URL: " + ActualCurrentUHCAgentURL);

		if (ExpectedUHCAgentURL.equalsIgnoreCase(ActualCurrentUHCAgentURL)) {
			System.out.println("****************myuhcagent Page is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************myuhcagent Page is not loaded ***************");
		}
		driver.switchTo().window(parentWindow);
	}

	public VPPPlanSummaryPage searchPlansWithOutCountyShopEnrollMedsupp(String zipcode) throws InterruptedException {

		CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
		sendkeys(zipCodeShopField, zipcode);
		jsClickNew(ShopEnrollMedsuppButton);
		waitForPageLoadSafari();
		// }
		CommonUtility.waitForPageLoadNew(driver, zipcodeChangeLink, 30);
		if (driver.getCurrentUrl().contains("health-plans")) {
			return new VPPPlanSummaryPage(driver);
		} else
			return null;
	}

	public VPPPlanSummaryPage searchPlansShopEnrollMedsupp(String zipcode, String countyName) {
		CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
		sendkeys(zipCodeShopField, zipcode);
		jsClickNew(ShopEnrollMedsuppButton);
		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		if (validate(countyModal))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	@FindBy(xpath = "//input[@id='zip-code']")
	private WebElement ZipcodePharmacy;

	@FindBy(xpath = "//select[@id='plans']")
	private WebElement seletPlandropdown;

	@FindBy(xpath = "//button[contains(@dtmid,'pharmacy')]//span[contains(text(),'Search')]")
	private WebElement ContinuePharmacy;
	
	
	@FindBy(xpath = "//button[contains(@dtmid, 'pharmacy')] //span[normalize-space()='Search']")
	private WebElement searchPharmacy;
	

	@FindBy(xpath = "//p//a[contains(text(),'Estimate your drug costs at a preferred retail pharmacy')]")
	private WebElement PreferredRetailedPharmacy;

	public void enterZipDistanceDetails(String zipcode, String distance, String county, String planName)
			throws InterruptedException {
		// TODO Auto-generated method stub
		CheckPageLoad();
		CheckiPerseptions();

		validateNew(ZipcodePharmacy);
		CommonUtility.waitForPageLoadNew(driver, ZipcodePharmacy, 30);
		sendkeys(ZipcodePharmacy, zipcode);
		scrollToView(seletPlandropdown);
		waitTllOptionsAvailableInDropdown(seletPlandropdown, 45);
		// seletPlandropdown.click();
		jsClickNew(seletPlandropdown);
		sleepBySec(1);
		selectFromDropDownByText(driver, seletPlandropdown, planName);
		sleepBySec(2);
		jsClickNew(searchPharmacy);
		try {
			Thread.sleep(5000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jsClickNew(PreferredRetailedPharmacy);

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);
		/*
		 * if (CurrentRailURL.contains("estimate-drug-costs.html#/reviewdrugcosts")) {
		 * System.out.println("****************  ***************");
		 * 
		 * Assertion.assertTrue(true); } else {
		 * Assertion.fail("****************  ***************"); }
		 */
		CheckPageLoad();
		CheckiPerseptions();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FindBy(id = "backToPlanSummaryTop")
	private WebElement lnkBackToAllPlans;

	public void navigateBackToPlanSummaryPageFromDetailsPage() {
		validateNew(lnkBackToAllPlans);
		jsClickNew(lnkBackToAllPlans);
	}

	@FindBy(xpath = "//*[contains(@class,'decisionGuide')]//a")
	private WebElement decisionGuideClick;

	@FindBy(xpath = "//a[normalize-space()='Back to previous page']")
	private WebElement backToPreviousPage;

	public void decisionGuide() {
		validateNew(decisionGuideClick);
		decisionGuideClick.click();
		// jsClickNew(decisionGuideClick);
		// backToPreviousPage.click();
		// driver.navigate().back();
	}

	public void openURLNewTabAARP(String url) {
		// get original tab handler
		String winHandleBefore = driver.getWindowHandle();
		Cookie cookie1 = driver.manage().getCookieNamed("TFNSessionCookie");
		System.out.println("Proceed to open a new blank tab as placeholder so the driver won't close");
		// open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('about:blank','_blank');");
		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equals(winHandleBefore)) {
				driver.switchTo().window(winHandle);
			}
		}
		String winHandleTmp = driver.getWindowHandle();
		System.out.println(
				"Proceed to close the original tab that has plans saved, should left with a blank tab afterward");

		driver.switchTo().window(winHandleTmp);
		System.out.println("Proceed to open the acquisition url in new tab");
		start(url);
		googleSearchAARP();
		driver.manage().addCookie(cookie1);
		driver.switchTo().window(winHandleBefore);
		driver.close();
		driver.switchTo().window(winHandleTmp);
		System.out.println("Proceed to use this newly opened tab for remaining validation");

	}

	public void openURLNewTabUHC(String url) {
		// get original tab handler
		String winHandleBefore = driver.getWindowHandle();
		Cookie cookie1 = driver.manage().getCookieNamed("TFNSessionCookie");
		System.out.println("Proceed to open a new blank tab as placeholder so the driver won't close");
		// open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('about:blank','_blank');");
		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equals(winHandleBefore)) {
				driver.switchTo().window(winHandle);
			}
		}
		String winHandleTmp = driver.getWindowHandle();
		System.out.println(
				"Proceed to close the original tab that has plans saved, should left with a blank tab afterward");

		driver.switchTo().window(winHandleTmp);
		System.out.println("Proceed to open the acquisition url in new tab");

		start(url);
		googleSearchUHC();
		driver.manage().addCookie(cookie1);
		driver.switchTo().window(winHandleBefore);
		driver.close();
		driver.switchTo().window(winHandleTmp);
		System.out.println("Proceed to use this newly opened tab for remaining validation");

	}

	public void validateFedTFNNo(String expectedFedTFN, String actualFedTFN) {
		System.out.println("Expected Fed TFN: " + expectedFedTFN);
		System.out.println("Actual Fed TFN: " + actualFedTFN);

		if (expectedFedTFN.contentEquals(actualFedTFN)) {
			System.out
					.println("****************Expected Fed TFN matches Actual Fed TFN from TFN cookie ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail(
					"****************Expected Fed TFN DOES NOT match Actual Fed TFN from TFN cookie ***************");
		}

	}

	public void validateMedsupTFNNo(String expectedMedsupTFN, String actualMedsupTFN) {
		System.out.println("Expected Medsup TFN: " + expectedMedsupTFN);
		System.out.println("Actual Medsup TFN: " + actualMedsupTFN);

		if (expectedMedsupTFN.contentEquals(actualMedsupTFN)) {
			System.out.println(
					"****************Expected Medsup TFN matches Actual Medsup TFN from TFN cookie ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail(
					"****************Expected Medsup TFN DOES NOT match Actual Medsup TFN from TFN cookie ***************");
		}

	}

	public void validateTFNHeaderAndSAMIcon() {
		CheckPageLoad();
		CheckiPerseptions();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(tfnHeaderLink);
		sleepBySec(5);
		String tfnHeader = tfnHeaderLink.getText();
		tfnHeaderLink.click();
		System.out.println("Clicked on TFN link in header");
		sleepBySec(5);
		validate(tfnHeaderPopupLink);
		String tfnHeaderPopup = tfnHeaderPopupLink.getText();
		Assertion.assertTrue("TFN in header does not match with TFN in header popup", tfnHeader.equals(tfnHeaderPopup));
		jsClickNew(tfnHeaderPopupClose);
		validate(samTFN);
		sleepBySec(5);
		Assertion.assertTrue("TFN in header does not match with TFN in SAM icon", tfnHeader.equals(samTFN.getText()));
		samTFN.click();
		System.out.println("Clicked on SAM TFN");
		sleepBySec(5);
		Assertion.assertTrue("TFN in SAM icon  does not match with TFN in SAM popup",
				tfnHeader.equals(samTFNPopupLink.getText()));
		// samTfnPopupClose.click();
		jsClickNew(samTfnPopupClose);
	}

	public void validateSourceCode(String expectedSrcCode, String actualSrcCode) {
		System.out.println("Expected Source code: " + expectedSrcCode);
		System.out.println("Actual Source code: " + actualSrcCode);

		if (expectedSrcCode.contentEquals(actualSrcCode)) {
			System.out.println(
					"****************Expected Source code matches Actual Source code from TFN cookie ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail(
					"****************Expected Source code DOES NOT match Actual Source code from TFN cookie ***************");
		}
	}

	public void addInfoAndMedSupFormTFN() throws InterruptedException {
		CheckPageLoad();
		CheckiPerseptions();
		validate(addYourInformation, 30);
		jsClickNew(addYourInformation);

	}

	@FindBy(xpath = "//button[@dtmid='cta_acq_ms_vpp']//span[@class='uhc-button__text'][normalize-space()='Cancel']")
	private WebElement cancelMS4FormModal;

	public void decisionGuidenotPresent() {
		Assert.assertFalse(validate(decisionGuideClick), "Verify if Decision Guide link displayed on Medsup 4.0.");
		// driver.navigate().back();

	}

	@FindBy(xpath = "//a[contains(normalize-space(),'Find an Agent')]")
	private WebElement findAnAgentMedsupp4;

	public void clickAgentLinkMedsup4(String TFNXpath, String ExpecetdTFNNo) {
		validateNew(findAnAgentMedsupp4);
		// CommonUtility.waitForPageLoadNew(driver, findAnAgentMedsupp4, 30);
		// String parentWindow = driver.getWindowHandle();
		findAnAgentMedsupp4.click();
		sleepBySec(3);
		// CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("myuhcagent")) {
			System.out.println("****************  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************  ***************");
		}
		CheckPageLoad();
		CheckiPerseptions();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);
		// if(validateNew(TFNelement) && TFNelement.isDisplayed()) {
		/*if (ExpecetdTFNNo.contains(ActualTFNelement.getText())) {
			System.out.println("TFN is Displayed on Page : " + ActualTFNelement.getText());

		}

		else {
			Assertion.fail("TFN elemnet is not found / displayed on page : " + TFNXpath);
		}*/

		driver.navigate().back();

	}

	@FindBy(xpath = "//a[@class='backToPrevPage']")
	private WebElement backToPreviousDG;

	public void backtoPreviousDGMedsup4() {
		Assert.assertFalse(validate(decisionGuideClick), "Verify if Decision Guide link displayed on Medsup 4.0.");
		jsClickNew(cancelMS4FormModal);
		// driver.navigate().back();
	}

	public void backtoPreviousDGMedsup3() {
		validate(backToPreviousDG);
		jsClickNew(backToPreviousDG);
	}

	@FindBy(xpath = "//button[@dtmid='cta_acq_ms_vpp' and @plancode='F01']//span[@class='uhc-button__text'][normalize-space()='Start Application']")
	private WebElement startMS4OLE;

	public void clickStartMS4Ole() {
		jsClickNew(startMS4OLE);
	}

	@FindBy(xpath = "//button[@data-plancode='F']")
	private WebElement startMS3OLE;

	public void clickStartMS3Ole() {
		jsClickNew(startMS3OLE);
	}

	public void clickCancelMS4Ole() {
		validate(cancelMS4FormModal);
		jsClickNew(cancelMS4FormModal);
	}

	@FindBy(xpath = "//a[@class='cancel-button modal-link' and normalize-space()= 'Cancel Application']")
	private WebElement cancelMS3OLE;

	@FindBy(xpath = "//a[@class='cta-button action_end_session' and normalize-space()= 'Cancel Application']")
	private WebElement cancelMS3OLEModal;

	public void clickCancelMS3Ole() {
		validate(cancelMS3OLE);
		jsClickNew(cancelMS3OLE);
		validate(cancelMS3OLEModal);
		jsClickNew(cancelMS3OLEModal);
	}

	public void ms4ViewPlanDetails() {

		validate(ms4ViewPlanDetails);
		jsClickNew(ms4ViewPlanDetails);
	}

	public void ms3ViewPlanDetails() {

		try {
			validate(surveyPopupNoBtn, 20);
			if (surveyPopupNoBtn.isDisplayed())
				jsClickNew(surveyPopupNoBtn);
		} catch (Exception e) {
			System.out.println("survey popup not displayed");
		}
		validate(ms3ViewPlanDetails);
		jsClickNew(ms3ViewPlanDetails);

	}

	public void ms4BackToPlanList() {

		jsClickNew(ms4BackToPlanList);
	}

	public void ms3BackToAllPlans() {

		jsClickNew(ms3BackToAllPlans);
	}
	
	public HashMap<String, String> retrieveTFNcookieLP() {
		System.out.println("Current URL - " + driver.getCurrentUrl());
		Cookie cookietfn = driver.manage().getCookieNamed("TFNSessionCookie");
		System.err.println(cookietfn);
		String str = cookietfn.toString();
		System.out.println("TFN Cookie Value - " + str);
		/*
		 * String sep = str.contains(",") ? "," : "%2C"; // String[] arrOfStr =
		 * str.split("%2C"); String[] arrOfStr = str.split(sep);
		 */

		String[] arrStr = str.split(",");
		/*String[] arrOfStr = arrStr[0].split(";");
		/*
		 * if (str.contains(",")) { arrOfStr = str.split(","); }
		 */
		String PSC_Code;
		String FedTFN;
		String MedSuppTFN;	
		String SRC_Code;

		/*for (String a : arrOfStr)

		*	System.out.println(a);*/
		String PSC_Code_Str = arrStr[0];
		String[] arrStr_1 = PSC_Code_Str.split("=");

		PSC_Code = arrStr_1[1];
		FedTFN = arrStr[2];
		MedSuppTFN = arrStr[3];
		SRC_Code = arrStr[4];

		System.out.println("Campaign PSC code - " + PSC_Code);
		System.out.println("Source code - " + SRC_Code);
		System.out.println("Federal TFN - " + FedTFN);
		System.out.println("MedSupp TFN - " + MedSuppTFN);

		HashMap<String, String> tfnCookieValues = new HashMap<String, String>();
		tfnCookieValues.put("PSC Code", PSC_Code);
		tfnCookieValues.put("Source Code", SRC_Code);
		tfnCookieValues.put("Fed TFN", FedTFN);
		tfnCookieValues.put("Medsup TFN", MedSuppTFN);
		System.out.println(tfnCookieValues);
		return tfnCookieValues;

		/*
		 * getLoginScenario().saveBean(TFNCommonConstants.PSC_CODE, PSC_Code);
		 * getLoginScenario().saveBean(TFNCommonConstants.FEDERAL_TFN, FedTFN);
		 * getLoginScenario().saveBean(TFNCommonConstants.MEDSUPP_TFN, MedSuppTFN);
		 */

	}

}

