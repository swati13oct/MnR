package pages.acquisition.tfn;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * @author sdwaraka
 *
 */

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;



public class CampaignTFNPage extends UhcDriver {

	@FindBy(xpath= "//*[contains(@id,'cta-zipcode')]")
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
	@FindBy(xpath = "//*[contains(@title,'Search')]")
	public WebElement GoogleSearchField;

	@FindBy(xpath = "//*[@id='tsf']/div[2]/div/div[3]/center/input[1]")
	public WebElement GoogleSearchButton;

	//@FindBy(xpath = "//h3[contains(text(),'AARP® Medicare Plans from UnitedHealthcare®')]")
	@FindBy(xpath = "//a[contains(@href, 'https://www.aarpmedicareplans.com/health-plans/shop/medicare-advantage-plans.html')][1]")
	public WebElement AARPSearchLinkfromGoogle;
	
	//@FindBy(xpath = "//h3[contains(text(),'AARP® Medicare Advantage (Part C) Plans ...')]")
	//@FindBy(xpath = "//h3[contains(text(),'AARP Medicare Advantage (Part C) Plans | UnitedHealthcare')]")	
	//@FindBy(xpath = "//h3[contains(text(),'AARP Medicare Advantage (Part C) Plans | UnitedHealthcare') or contains(text(),'AARP Medicare Advantage (Part C) Plans | UnitedHea')]")
	//@FindBy(xpath = "//a[@href='https://www.aarpmedicareplans.com/shop/medicare-advantage-plans.html']")
	@FindBy(xpath = "//h3[contains(text(),'AARP Medicare Plans from UnitedHealthcare')]")
	public WebElement AARPSearchLinkfromGoogle_alternative;

	//@FindBy(xpath = "(//a[contains(@href,'medicaresolutions')])[3]")
	//@FindBy(xpath = "//h3[contains(text(),'Learn More About Medicare Advantage (Part C)')]")
	@FindBy(xpath = "//a//span[contains(text(),'Learn More About Medicare Advantage (Part C) Plans - AARP ...')]")
	//@FindBy(xpath = "//a//h3[contains(text(),'Learn More About Medicare Advantage (Part C) Plans - AARP ...') or contains(text(),'Find Medicare Plans Available from UnitedHealthcare')]")
	//@FindBy(xpath = "//h3[contains(text(),'Learn More About Medicare Advantage (Part C)') or contains(text(),'Find Medicare Plans Available from UnitedHealthcare')]")
	//@FindBy(xpath = "//h3[contains(text(),'Find Medicare Plans Available from UnitedHealthcare')]")
	//@FindBy(xpath = "(//a[contains(@href,'https://www.uhcmedicaresolutions.com/health-plans/shop/medicare-advantage-plan')])[1]")
	public WebElement UHCSearchLinkfromGoogle;

	@FindBy(xpath = "(//*[contains(text(),'Find Medicare Plans Available From UnitedHealthcare®')])[2]")
	public WebElement UHCSearchLinkfromGoogle1;

//	@FindBy(xpath = "//*[@id='uh-search-box']")
	//@FindBy(xpath = "//input[@id='header-search-input']")
	@FindBy(xpath = "//label[text()='Search query']//following-sibling::input[1]")
	public WebElement YahooSearchField;

	
//	@FindBy(xpath = "//*[@id='uh-search-button']")
	//@FindBy(xpath = "//button[contains(@id,'search-button')]")
	@FindBy(xpath = "//button[@type='button']//following-sibling::input[1]")
	public WebElement YahooSearchBttn;

	//@FindBy(xpath = "//h3//a[contains(text(),'AARP® Medicare Advantage (Part C) Plans')]")
	//@FindBy(xpath = "//h3//a[contains(text(),'AARP Medicare Advantage (Part C) Plans | UnitedHealthcare')]")
	//@FindBy(xpath = "//a[contains(@href,'https://www.aarpmedicareplans.com/health-plans/shop/medicare-advantage-plans/ma-plan-benefits.html')]")
	@FindBy(xpath = "//a[contains(text(),'AARP Medicare Plans from UnitedHealthcare')]")
	public WebElement YahooSearchResult;

	//@FindBy(xpath = "//h3//a[contains(text(),'Medicare Advantage (Part C) Plans')]")
	//@FindBy(xpath = "//h3//a[contains(text(),'Find Medicare Plans Available')]")
	@FindBy(xpath = "//h3//a[contains(text(),'Find Medicare Plans Available') or contains(@href,'https://www.uhcmedicaresolutions.com/health-plans.html')]")
	public WebElement YahooSearchResultUHC;

	@FindBy(xpath = "//*[@id='sb_form_q']")
	public WebElement bingSearchField;

	@FindBy(xpath = "//*[@class='b_searchboxSubmit']")
	public WebElement bingSearchBttn;

	//@FindBy(xpath = "//a[contains(@href,'https://www.aarpmedicareplans.com/health-plans/shop/medicare-advantage-plans.html')]")
	//@FindBy(xpath = "//a[contains(@href,'https://www.aarpmedicareplans.com/health-plans/shop/medicare-ad')]")
	//@FindBy(xpath = "//a[contains(text(),'AARP Medicare Plans from UnitedHealthcare')]")
	@FindBy(xpath = "//a[contains(@href,'https://www.aarpmedicareplans.com/health-plans/shop/medicare-advantage-plans.html') or contains(text(),'AARP Medicare Plans from UnitedHealthcare')]")
	public WebElement AARPSearchLinkfromBing;

	//@FindBy(xpath = "//a[contains(@href,'https://www.uhcmedicaresolutions.com/health-plans/shop/medicare-advantage-plans.html')]")
	//@FindBy(xpath = "//h2//a[contains(text(),'Find Medicare Plans ')]")
	@FindBy(xpath = "//a[contains(@href,'https://www.uhcmedicaresolutions.com/health-plans/shop/medicare-advantage-plans.html')or contains(@href,'https://www.uhcmedicaresolutions.com/health-plans.html') or contains(@href,'https://www.uhcmedicaresolutions.com/shop/medicare-advantage-plans.html')]")
	public WebElement UHCSearchLinkfromBing;


	public CampaignTFNPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		System.out.println("Current URL - "+driver.getCurrentUrl());

	}
	
	
	public void openUrl(String url) {
		// TODO Auto-generated method stub
		start(url);}
	
	
	@FindBy(xpath="//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
	public static WebElement proactiveChatExitBtn;
	
	public void CheckiPerseptions() {
		CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn,20); // do not change this to waitForPageLoadNew as we're not trying to fail the test if it isn't found
		try{
			if(proactiveChatExitBtn.isDisplayed())
				jsClickNew(proactiveChatExitBtn);
		}catch(Exception e){
			System.out.println("Proactive chat popup not displayed");
		}
	}
	/**
	 * 
	 * @param site - ulayer or blayer
	 * @param path - path for the url
	 * To open Homepage+ path as per env, 
	 */

	public void OpenPath(String site, String path) {
		if ("ULayer".equalsIgnoreCase(site)) {
			if (MRScenario.environment.equals("offline")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=AARP_ACQISITION_OFFLINE_PAGE_URL+path;
				driver.get(testSiteUrl);
			} else if (MRScenario.environment.equals("prod")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=AARP_ACQISITION_PROD_PAGE_URL+path;
				driver.get(testSiteUrl);
			} else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=AARP_ACQISITION_PAGE_URL+path;
				driver.get(testSiteUrl);
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: "+driver.getCurrentUrl());
		}
		else if ("BLayer".equalsIgnoreCase(site)) {
			if (MRScenario.environment.equals("offline")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=UMS_ACQISITION_OFFLINE_PAGE_URL+path;
				driver.get(testSiteUrl);
			} else if (MRScenario.environment.equals("prod")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=UMS_ACQISITION_PROD_PAGE_URL+path;
				driver.get(testSiteUrl);
			} else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=UMS_ACQISITION_PAGE_URL+path;
				driver.get(testSiteUrl);
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: "+driver.getCurrentUrl());
		}
	}



	private void CheckPageLoad() {
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		checkModelPopup(driver, 30);
	
	}
	
	public void retrieveTFNcookie() {
		System.out.println("Current URL - "+driver.getCurrentUrl());
		Cookie cookietfn = driver.manage().getCookieNamed("TFNSessionCookie");
		System.err.println(cookietfn);
		String str = cookietfn.toString();
		System.out.println("TFN Cookie Value - "+str);
		String[] arrOfStr = str.split("%2C"); 
		String PSC_Code;
		String FedTFN;
		String MedSuppTFN ;
		for (String a : arrOfStr)
		        
		            System.out.println(a); 
		String PSC_Code_Str= arrOfStr[0];
		String[] arrStr_1 = PSC_Code_Str.split("="); 
		PSC_Code = arrStr_1[1];
		FedTFN=arrOfStr[2];
		MedSuppTFN = arrOfStr[3];
		
		System.out.println("Campaign PSC code - "+PSC_Code);
		System.out.println("Federal TFN - "+FedTFN);
		System.out.println("MedSupp TFN - "+MedSuppTFN);
		
		PSC_CODE = PSC_Code;
		FEDERAL_TFN=FedTFN;
		MEDSUPP_TFN=MedSuppTFN;
		
		/*
		 * getLoginScenario().saveBean(TFNCommonConstants.PSC_CODE, PSC_Code);
		 * getLoginScenario().saveBean(TFNCommonConstants.FEDERAL_TFN, FedTFN);
		 * getLoginScenario().saveBean(TFNCommonConstants.MEDSUPP_TFN, MedSuppTFN);
		 */		

	}

	public void validatePSCcode(String ExpectedpscCode) {
		
		String PSC_Code = PSC_CODE;
		System.out.println("Expected PSC code: "+ExpectedpscCode);
		System.out.println("Actual PSC code: "+PSC_Code);
		
		if(ExpectedpscCode.contentEquals(PSC_Code)) {
			System.out.println("****************Expected PSC Code matches Actual PSC code from TFN cookie ***************");

			Assert.assertTrue(true);
		}
		else {
			Assert.fail("****************Expected PSC Code DOES NOT match Actual PSC code from TFN cookie ***************");
		}
		// TODO Auto-generated method stub
		
	}

	public void navigateToUrl(String uRLpath) {

		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL : "+CurrentURL);
		String SiteURL = CurrentURL.split(".com")[0];
		System.out.println("Split URL : "+SiteURL);
		SiteURL = SiteURL+".com/";
		System.out.println("Site URL : "+SiteURL);
		String NavigateToURL = SiteURL+uRLpath;
		System.out.println("Navigating to URL : "+NavigateToURL);
		driver.navigate().to(NavigateToURL);
		CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 35);
		System.out.println("Page Title : "+(driver.findElement(By.xpath("//title")).getText()));
	}

	public void validateFederalTFN(String tFN_Xpath) {
		WebElement TFNelement = driver.findElement(By.xpath(tFN_Xpath));
		validateNew(TFNelement);	
		if(validateNew(TFNelement) && TFNelement.isDisplayed()) {
			System.out.println("TFN is Displayed on Page : "+TFNelement.getText());
		}
		else {
			Assert.fail("TFN elemnet is not found / displayed on page : "+tFN_Xpath);
		}
		String TFNonPage = TFNelement.getText();
		if(TFNonPage.contains(FEDERAL_TFN)) {
			System.out.println("Correct Federal TFN is Displayed on Page : "+TFNelement.getText());
		}
		else {
			Assert.fail("TFN displayed is INCORRECT for Federal : "+tFN_Xpath);
		}


	}

	public void validateMedSuppTFN(String tFN_Xpath) {
		WebElement TFNelement = driver.findElement(By.xpath(tFN_Xpath));
		validateNew(TFNelement);	
		if(validateNew(TFNelement) && TFNelement.isDisplayed()) {
			System.out.println("TFN is Displayed on Page : "+TFNelement.getText());
		}
		else {
			Assert.fail("TFN elemnet is not found / displayed on page : "+tFN_Xpath);
		}
		String TFNonPage = TFNelement.getText();
		if(TFNonPage.contains(MEDSUPP_TFN)) {
			System.out.println("Correct Med Supp TFN is Displayed on Page : "+TFNelement.getText());
		}
		else {
			Assert.fail("TFN displayed is INCORRECT for Med Supp Page : "+tFN_Xpath);
		}
	}
	
	public void navigateToCampaignURL(String campaignUrl , String envUrl) {
		System.out.println("Environment URL : "+envUrl);
		String NavigateToURL = envUrl+campaignUrl;
		System.out.println("Campaign URL : "+NavigateToURL);
		driver.navigate().to(NavigateToURL);
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 40);
		System.out.println("Page Title : "+(driver.findElement(By.xpath("//title")).getText()));		
	}
	

	public void googleSearchAARP() {
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
		if(YahooSearchResult.isDisplayed())
			System.out.println("Yahoo search result found");
		else {
			System.out.println("yahoo search result not found");
			Assert.assertFalse("no yahoo search result found", false);
		}
		YahooSearchResult.click();
		System.out.println("Yahoo Results - AARP Medicare Advantage Plan - Link Clicked");
		switchToNewTab();
		CheckPageLoad();
	}

	public void BingSearchAARP() {
		CommonUtility.waitForPageLoad(driver, bingSearchField, 30);

		bingSearchField.click();
		bingSearchField.clear();
		bingSearchField.sendKeys("AARP Medicare Advantage Plan"+Keys.ENTER);
		System.out.println("Looking for AARP medicare Plans link , please bear with me :) ");
		System.out.println("Current URL is ==  "+driver.getCurrentUrl());
		CommonUtility.waitForPageLoad(driver, AARPSearchLinkfromBing, 30);
		if(AARPSearchLinkfromBing.isDisplayed())
			System.out.println("Bing search result found");
		else {
			Assert.assertFalse("Bing search result not found", false);
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
		//UHCSearchLinkfromGoogle.click();
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
		if(YahooSearchResultUHC.isDisplayed())
			System.out.println("Yahoo search result found");
		else {
			System.out.println("yahoo search result not found");
			Assert.assertFalse("no yahoo search result found", false);
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
		bingSearchField.sendKeys("UHC Medicare Advantage Plan"+Keys.ENTER);
		System.out.println("Looking for UHC medicare Plans link , please bear with me :) ");
		System.out.println("Current URL is ==  "+driver.getCurrentUrl());
		CommonUtility.waitForPageLoad(driver, UHCSearchLinkfromBing, 30);
		if(UHCSearchLinkfromBing.isDisplayed())
			System.out.println("Bing search result found");
		else {
			Assert.assertFalse("Bing search result not found", false);
		}
		UHCSearchLinkfromBing.click();		
		System.out.println("Bing Results - UHC Medicare Advantage Plan - Link Clicked");
		CheckPageLoad();
	}

	public void navigateToPDPPlans() {
	(driver.findElement(By.xpath("//a[contains(@dtmname,'PDP:View Plans')]"))).click();;
	System.out.println("Navigated to PDP Plan Summary Page");	
	}

	

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlansLink1;

	@FindBy(id = "zipcodebtn")
	private WebElement findPlansButton;
	
	@FindBy(id="cta-zipcode")
	private WebElement HomePage_EnterZip;

	@FindBy(id = "nav-zipcode")
	private WebElement OurPlans_zipfield;

	@FindBy(xpath = "//*[@id = 'nav-zipcode']/following-sibling::button[@class = 'zip-button']")
	public WebElement OurPlans_viewPlansButton;
	

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

		//validateNew(OurPlansLink1);
		// Hover over text
		//Actions action = new Actions(driver);
		//action.moveToElement(OurPlansLink1).build().perform();
		// action.click().build().perform();
		//validateNew(OurPlansLink1);
		validate(HomePage_EnterZip);
		HomePage_EnterZip.click();
		HomePage_EnterZip.sendKeys(zip);
		validate(findPlansButton);
		findPlansButton.click();
	}
	
	@FindBy(id = "plan-list-1")
	private WebElement maPlanList;

	@FindBy(id = "plan-list-3")
	private WebElement pdpPlanList;

	@FindBy(id = "plan-list-4")
	private WebElement snpPlanList;

	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='maviewplans']/following-sibling::a")
	private WebElement maPlansViewLink;

	//@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[4]//a[@class='trigger-closed']")
	//@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[4]//a[@class='trigger-closed ng-scope']")
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[contains(@ng-click,'viewSnp')]//*[contains(@aria-label,'Medicare Special')]")
	private WebElement snpPlansViewLink;

	//@FindBy(xpath = "//*[@class='overview-tabs module-tabs-tabs']//*[contains(@ng-click,'MedSupp')]//*[@class='trigger-closed'][text()='View Plans']")
	@FindBy(xpath = "//*[@class='overview-tabs module-tabs-tabs']//*[contains(@ng-click,'MedSupp')]//*[contains(@aria-label,'Medicare Supplement')]")
	private WebElement msPlansViewLink;

	@FindBy(xpath = "//*[contains(@class,'module-tabs-tabs')]/*[not (contains(@class,'active'))]//*[contains(@id,'pdpviewplans')]/following-sibling::*[contains(@aria-label,'View Plans')]")
	private WebElement pdpPlansViewLink;

	@FindBy(id="msVppZipCode")
	private WebElement medSuppZipCode;


	@FindBy(xpath = "//div[contains(@id,'plan-list-') and not(contains(@class,'ng-hide'))]/div[contains(@class,'plan-list-content')]")
	private WebElement planListContainer;

	public void ViewPlanSummary(String planType) {
		CheckPageLoad();
		CheckiPerseptions();

		if (planType.equalsIgnoreCase("PDP")) {
			CommonUtility.waitForPageLoadNew(driver, pdpPlansViewLink, 30);
//			sleepBySec(2); //note: add sleep for timing issue, tried increase timeout from waitForPageLoadNew but didn't work
			pdpPlansViewLink.click();
			System.out.println("PDP Plan Type Clicked");
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
		} else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			CommonUtility.waitForPageLoadNew(driver, maPlansViewLink, 30);
//			sleepBySec(2);
			maPlansViewLink.click();
			System.out.println("MA Plan Type Clicked");
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
		} else if (planType.equalsIgnoreCase("MS")) {
			CommonUtility.waitForPageLoadNew(driver, msPlansViewLink, 30);
			//sleepBySec(2);
			msPlansViewLink.click();
			CommonUtility.waitForPageLoadNew(driver, medSuppZipCode, 30);
			/*msPlansViewLink.click();
			CommonUtility.waitForPageLoadNew(driver, medSuppPlanList.get(0), 30);*/
		} else if (planType.equalsIgnoreCase("SNP")) {
//			sleepBySec(5);
			CommonUtility.waitForPageLoadNew(driver, snpPlansViewLink, 30);
			snpPlansViewLink.click();
			System.out.println("SNP Plan Type Clicked");
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
	
		}	
	}
	@FindBy(xpath="//div[contains(@class,'plan-list show active')]//div[contains(@class,'module-plan-overview')][1]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan') or contains(text(),'View Plan Details')]")
	private WebElement firstPlanDetailsLink;

	public void NavigateToPlanDetails(String planType) {
		CheckPageLoad();
		CheckiPerseptions();
		CommonUtility.waitForPageLoadNew(driver, firstPlanDetailsLink, 30);
		firstPlanDetailsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("View Plan Details Link is clicked for first plan for "+planType);
				CommonUtility.checkPageIsReadyNew(driver);
				if (driver.getCurrentUrl().contains("#/details")) {	
					Assert.assertTrue("Plan Details is displayed for Plan Type : "+planType, true);
				}
				else {
					Assert.assertTrue("Plan Details NOT Diaplyed for Plan Type : "+planType, false);
				}
	
	}

	@FindBy(xpath="//div[contains(@class,'plan-list show active')]//div[contains(@class,'module-plan-overview')][1]//div[contains(@class,'enroll')]//*[contains(text(), 'Enroll in ')and (not(contains(@class,'ng-hide')))]")
	private WebElement firstEnrollPlanLink;

	public void NavigateToOLE(String planType) {
		CheckPageLoad();
		CheckiPerseptions();
		CommonUtility.waitForPageLoadNew(driver, firstEnrollPlanLink, 30);
		firstEnrollPlanLink.click();
		System.out.println("Enroll In Plan Link is clicked for first plan for "+planType);
				CommonUtility.checkPageIsReadyNew(driver);
				if (driver.getCurrentUrl().contains("welcome")) {	
					Assert.assertTrue("OLE Welcome Page is displayed for Plan Type : "+planType, true);
				}
				else {
					Assert.assertTrue("OLE Welcome Page NOT Diaplyed for Plan Type : "+planType, false);
				}
	}

	@FindBy(xpath="(//a[contains(@dtmname, 'Top Nav:Logo') and not(contains(@style, 'display:'))])[1]")
	private WebElement HomeLogo;


	@FindBy(xpath="//button[(contains(text(), 'Leave Online') )or (contains(@id, 'proceed'))]")
	private WebElement LeaveOLE;
	
	public void NavigateToHomeFromPlanDetails() {
		CheckPageLoad();
		CheckiPerseptions();
		CommonUtility.waitForPageLoadNew(driver, HomeLogo, 30);
		HomeLogo.click();
		System.out.println("Home Logo is clicked to navigate to Home Page");
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
		if(!validateNew(zipCodeField)){
			Assert.assertTrue("Home Page NOT Diaplyed", false);
		}
	}

	
	public void NavigateToHome() {
		CheckPageLoad();
		CheckiPerseptions();
		CommonUtility.waitForPageLoadNew(driver, HomeLogo, 30);
		HomeLogo.click();
		System.out.println("Home Logo is clicked to navigate to Home Page");
		try {
			if(LeaveOLE.isDisplayed()) {
				LeaveOLE.click();
				System.out.println("Leave OLE is clicked to navigate to Home Page");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
		if(!validateNew(zipCodeField)){
			Assert.assertTrue("Home Page NOT Displayed", false);
		}
	}
	
	@FindBy(xpath = "//div[@class='switch-field ng-scope']//label[@class='ng-binding'][contains(text(),'Shop for 2020 plans')]")
	private WebElement  CurrentYearPlansBtn;

	public void handlePlanYearSelectionPopup() {
		CommonUtility.checkPageIsReadyNew(driver);			
			if(validate(CurrentYearPlansBtn, 20)) {
				System.out.println("*****CLICKING ON Current Year button*****: "+CurrentYearPlansBtn.getText());
				jsClickNew(CurrentYearPlansBtn);	
			}
		}
		}