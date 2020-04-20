package pages.acquisition.ulayer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import junit.framework.Assert;
import pages.acquisition.dce.ulayer.DCETestHarnessPage;
import pages.acquisition.ole.OLETestHarnessPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;

/**
 * @author pperugu
 *
 */
public class AcquisitionHomePage extends GlobalWebElements {

	@FindBy(xpath= "//*[contains(@id,'cta-zipcode')]")
	private WebElement zipCodeField;
	
	@FindBy(id= "zipcode")
	private WebElement healthPlansZipcode;

	@FindBy(className = "fd_myPlans")
	private WebElement myPlansTab;

	@FindBy(id = "dce")
	private WebElement getStartedButton;

	@FindBy(id = "learnfindplanBtn")
	private WebElement learnfindPlansButton;

	@FindBy(id = "Find a pharmacy near you")
	private WebElement pharmacyNearLink;

	@FindBy(className = "zip-button")
	private WebElement FindPlansButton1;

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlansLink1;

	@FindBy(id = "zipcodebtn")
	private WebElement findPlansButton;

	@FindBy(id = "learn-zipcode")
	private WebElement learnzipCodeField;

	@FindBy(id = "lookzip")
	private WebElement lookzip;
	
	@FindBy(id = "findazip_box")
	private WebElement zipCodeSearchPopup;
	
	@FindBy(xpath = "//div[@id='findazip_box']/div/div/div/h4")
	private WebElement zipCodeSearchPopupHeading;

	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;

	@FindBy(id = "homefooter")
	private WebElement homefooter;

	@FindBys(value = { @FindBy(id = "selectCounty") })
	List<WebElement> countyRows;

	@FindBy(xpath = "/html/body/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/div[2]/div/div/div[2]/div/ul/li[2]/a")
	WebElement zipCodebtn;

	@FindBy(xpath = "//a[contains(text(),'Request More Help')]")
	private WebElement pdp_moreHelpInfoLink;

	@FindBy(xpath = ".//*[@id='atdd_ma_plans']/span")
	private WebElement ma_moreHelpInfoLink;

	@FindBy(xpath = "//a[contains(text(),'Request More')]")
	private WebElement moreHelpInfoLink;

	@FindBy(xpath = "//div[@id='subnav_2']//h3/a[contains(text(),'Pharmacy')]")
	private WebElement pharmacylocator;

	@FindBy(id = "ghn_lnk_1")
	public static WebElement navigationSectionHomeLink;

	@FindBy(id = "ghn_lnk_2")
	public static WebElement ourPlansHoverLink;

	@FindBy(id = "subnav_2")
	public static WebElement ourPlansDropdownText;

	@FindBy(xpath = "//html[@id='ctl00_MasterHtmlTag']/head/title")
	public static WebElement test;

	@FindBy(id = "provider")
	private WebElement po7Link;

	@FindBy(id = "dce")
	private WebElement enterYourDrugListButton;

	@FindBy(xpath = "//*[@id='ghn_lnk_4']")
	private WebElement hoverhealthandwellnesslink;

	@FindBy(xpath = "//*[@id='subnav_4']/div/div/div[2]/div/a")
	public static WebElement forgotusernamepasswordlink;

	@FindBy(xpath = "//*[@id='subnav_4']/div/div/div[2]/div/span[2]/a")
	public static WebElement registerherelink;

	@FindBy(xpath = "//div[@class='overview-main']/h2")
	private WebElement vppTop;

	@FindBy(xpath = ".//*[contains(@id,'colhowdoesthiswork')]//*[@itemprop='significantLink']/*[contains(@class,'cta-button secondary')and contains(text(),'Get')]")
	public WebElement getStarted;

	@FindBy(xpath = ".//*[contains(@class, 'meded-article-content__section')]//*[contains(text(), 'Request an Appointment')]")
	private WebElement requestAgentApptDropdown;

	@FindBy(xpath = "//*[@class='textalign']//p[2]/a")
	private WebElement county;

	@FindBy(xpath = "//*[@id='ole-county-select']/option[@value=1]")
	private WebElement countyDropdown;

	@FindBy(xpath = "//*[@id='js-ole-plan-select']//optgroup[1]/option[@value=0]")
	private WebElement selectFirstOptionOnPlanSelect;

	@FindBy(xpath = "//*[@id='js-ole-plan-select']//optgroup[2]/option[1]")
	private WebElement StandaloneSNPoptions;

	@FindBy(xpath = "//*[@id='js-ole-plan-select']//following::button")
	private WebElement enrollButton;

	@FindBy(id = "js-ole-zip-search")
	private WebElement StandaloneZipcode;

	@FindBy(xpath = "//*[@id='js-ole-zip-search']/following-sibling::button")
	private WebElement StandalonSearch;

	@FindBy(xpath = "//*[@id='js-ole-plan-result']/p/following-sibling::button")
	private WebElement StandaloneVPP;

	@FindBy(xpath = "//button[text()='View Plans & Pricing']")
	private WebElement ViewPlansPricingButton;

	@FindBy(xpath = "//*[contains(@class,'btn--bottom')]")
	private WebElement StandalonSearchCounty;

	@FindBy(xpath = "//*[@id='planTypesColumn']/h3[2]/a")
	private WebElement PDPLandingLink;

	@FindBy(xpath = "//*[@id='planTypesColumn']/h3[1]/a")
	private WebElement MALandingLink;

	@FindBy(xpath = "//*[@class='container meded-article-header']/h1']")
	private WebElement MALandingHeading;

	@FindBy(xpath = "//*[contains(@id,'zipcodebtn') or (contains(@class,'zip-button' ) and contains( text(),'Go'))]")
	private WebElement viewPlansButton;
	
	@FindBy(xpath="//button[@class='zip-button' and text()='Go']")
	public WebElement btnGO;

	/*
	 * @FindBy(id = "vpp_selectcounty_box") private WebElement countyModal;
	 */

	@FindBy(id = "zipcode")
	private WebElement zipCode;

	@FindBy(className = "textalign")
	private WebElement countyModal1;

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlans;

	@FindBy(id = "nav-zipcode")
	private WebElement OurPlans_zipfield;

	@FindBy(xpath = "//*[@id = 'nav-zipcode']/following-sibling::button[@class = 'zip-button']")
	public WebElement OurPlans_viewPlansButton;
	
	@FindBy(xpath = "(//*[@class='zip-button'])[2]")
	private WebElement GoButton;
	
	@FindBy(id = "cobrowse-disclaimer")
	private WebElement requestAssistanceModal;
	
	@FindBy(xpath = "//div[@id='cobrowse-disclaimer']//*[contains(@class,'modal-title')]")
	private WebElement requestAssistanceTitle;
	
	@FindBy(id = "correlationId")
	private WebElement requestAssistanceAgentID;
	
	@FindBy(xpath = "//a[contains(@class,'closer')]")
	private WebElement requestAssistanceClose;
	
	@FindBy(id = "gbqfbb")
	private WebElement feelingluckyBtn;
	
	@FindBy(id = "medicareTitle")
	public WebElement siteMapHeader;
	
	@FindBy(xpath = "//*[contains(@dtmname,'Privacy')]//*[contains(text(),'Privacy Policy')]")
	public WebElement privacyHeader;
	
	@FindBy(xpath = "//*[@class='container meded-article-header']//span[contains(text(),'Health Insurance Broker')]")
	public WebElement brokerHeader;
	
	/* LearnAboutMedicare link */
	@FindBy(xpath = "//*[@id='ghn_lnk_3']")
	private WebElement lnkLearnAboutMedicare;
	
	@FindBy(xpath = "//h3//*[contains(@onclick,'loadCachedProviderSearch')]")
	private WebElement providerSearchFromGlobalHeader;

	@FindBy(xpath ="//*[contains(@class,'cta-button secondary') and contains(text(),'Provider')]")
	private WebElement providerSearchFromHomeScreen;
	
	@FindBy(id="ghn_lnk_2")
	private WebElement ShopForaplan;
	
    @FindBy(xpath=".//*[@id='updates-mobile-form']/div/div[2]/button")
	private WebElement submit;
    
    @FindBy(id="state-select")
    private WebElement stateDropDown;
    
    @FindBy(xpath="//a[contains(@class, 'backtotop1')]")
    private WebElement backToTop_Disclaimer;
    
    @FindBy(xpath="//a[contains(@dtmname, 'Footer:Visit AARP')]")
    private WebElement visitAARPFooterLink;
    
    @FindBy(xpath="//a[contains(@class, 'back-to-top')]")
    private WebElement backToTop;
    
    @FindBy(xpath="//a[contains(@class, 'viewLink disclaimer')]")
    private WebElement disclaimerInformation;
    
    @FindBy(css=".icon-search")
	private WebElement searchbutton;
    
	@FindBy(id= "search-field")
	private static WebElement searchfield;
    
    @FindBy(id="dupIconFlyOut")
    private WebElement shoppingCartIcon;
    
	@FindBy(xpath = "//*[@id='sam-call-button']/div/span[2]/img")
   	private WebElement callsam;
   	
   	@FindBy(xpath = "//*[@id='sam-call-button']/div/span[1]")
   	private WebElement callsamtooltip;
   	
   	@FindBy(xpath ="//*[@id='sam-call-modal']/div/div")
   	private WebElement callSamPopup;

    
	@FindBy(xpath = "//*[contains(@class,'proactive-offer')]")
   	private WebElement ProActivePopup;

	@FindBy(xpath = "//*[contains(@class,'proactive-offer__close') and contains(@class, 'close-icon')]")
   	private WebElement ProActivePopup_Close;

	@FindBy(xpath = "//button[contains(@class,'proactive-offer__close') and contains(text(), 'Exit')]")
   	private WebElement ProActivePopup_ExitBtn;

	@FindBy(xpath = "//button[contains(@class,'proactive-offer__button_type_chat') and contains(text(), 'Chat')]")
   	private WebElement ProActivePopup_ChatBtn;

   	
   	@FindBy(xpath ="//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]")
   	private WebElement CallSamModel;
   	
   	@FindBy(xpath ="//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]")
   	private WebElement CallSamTFN;
   	
   	@FindBy(xpath ="//*[@id='sam-call-modal']/div/div/div[1]/a")
   	private WebElement CallSamTFNClose;
   	
   	String CallSam= "Call a Licensed Insurance Agent";
   	@FindBy(xpath = "//*[contains(@class,'activeChatBtn')]")
   	private WebElement chatsam;
   	
   	@FindBy(xpath = "//*[contains(@class,'activeChatBtn')]/div/a[1]")
   	private WebElement chatsamtooltip;
   	
   	@FindBy(xpath ="//*[@id='inner-chat']")
   	private WebElement chatSamPopup;

   	@FindBy(xpath ="//*[@id='sp-chat-frame']")
   	private WebElement ProActivechatPopup;

  
   	@FindBy(xpath ="//*[@id='agent-name']")
   	private WebElement ChatSamHead;
   	
   	@FindBy(xpath ="//*[@id='sp-close-frame']")
   	private WebElement ChatSamTFNClose;
   	
   	@FindBy(id = "pharmacy-zip-search")
	private WebElement thpharmacyzipsearch;
   	
   	@FindBy(xpath = "//input/parent::form//button[text()='Go']")
	private WebElement thpharmacyGoButton;
   	
   	@FindBy(id = "zipcode")
	private WebElement zipCodeHealthPlans;
   	
   	@FindBy(xpath = "//form[@name='zipcodeform']//button[contains(@class,'zip-button')]")
	private WebElement GoBtnHealthPlans;
   	
   	
   	
   	
   	String ChatSamText= "Chat with a Licensed Insurance Agent";

	private static String TeamC_ACQUISITION_PAGE_URL = MRConstants.TeamC_UHC_URL;

	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;
	private static String AARP_ACQISITION_PROD_PAGE_URL = MRConstants.AARP_URL_PROD;
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
	private static String UMS_ACQISITION_PROD_PAGE_URL = MRConstants.UHCM_URL_PROD;	

	private PageData globalFooter;

	public JSONObject globalFooterJson;
	public JSONObject browserCheckJson;

	public JSONObject homePageDisclaimerJson;

	public JSONObject homePageDisclaimerHideJson;

	public JSONObject alreadyPlanMemberJson;
	public JSONObject medicareEducationDropDownJson;

	public JSONObject headerJson;

	private PageData globalHeader;

	public JSONObject globalHeaderJson;

	public JSONObject ourplansdropdownJson;

	public JSONObject homeJson;

	private PageData healthandwellnessdropdown;

	public JSONObject healthandwellnessdropdownJson;

	public JSONObject globalFooterDTMJson;
	
	public static boolean isHealthPlan = false;
	
	public String testSiteUrl;
	
	public String MicroAppSiteUrl;
	
	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public AcquisitionHomePage(WebDriver driver, boolean alreadyOnSite) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(alreadyOnSite);
	}
	
	public AcquisitionHomePage(WebDriver driver, String siteOrPage) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(siteOrPage);
	}
	
	public AcquisitionHomePage(WebDriver driver, String siteOrPage,String testharnessurl) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(siteOrPage,testharnessurl);
	}
    
	public String fetchEnvironmentUrls () {
		if (MRScenario.environment.equals("offline")) {
		  testSiteUrl = AARP_ACQISITION_OFFLINE_PAGE_URL;
		  return testSiteUrl;
		}
		else if (MRScenario.environment.equals("prod")) {
			 testSiteUrl = AARP_ACQISITION_PROD_PAGE_URL;
			 return testSiteUrl;
		}
		else
			testSiteUrl = AARP_ACQISITION_PAGE_URL;
		    return testSiteUrl;
	  }
	
	@Override
	public void openAndValidate() {


		if (MRScenario.environment.equals("offline")) {
			start(AARP_ACQISITION_OFFLINE_PAGE_URL);
			testSiteUrl=AARP_ACQISITION_OFFLINE_PAGE_URL;
			checkModelPopup(driver,45);
		}
		else if (MRScenario.environment.equals("prod")) {
			start(AARP_ACQISITION_PROD_PAGE_URL);
			testSiteUrl=AARP_ACQISITION_PROD_PAGE_URL;
			checkModelPopup(driver,45);
		}else {
			start(AARP_ACQISITION_PAGE_URL);
			testSiteUrl=AARP_ACQISITION_PAGE_URL;
			checkModelPopup(driver,30);		
		}
	//	CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		
		CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 45);
		CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn,20); // do not change this to waitForPageLoadNew as we're not trying to fail the test if it isn't found
		try{
			if(proactiveChatExitBtn.isDisplayed())
				jsClickNew(proactiveChatExitBtn);
		}catch(Exception e){
			System.out.println("Proactive chat popup not displayed");
		}
	}

	public void openAndValidate(String siteOrPage) {
		if ("BLayer".equalsIgnoreCase(siteOrPage)) {
			if (MRScenario.environment.equals("offline")) {
				startNew(UMS_ACQISITION_OFFLINE_PAGE_URL);
				testSiteUrl=UMS_ACQISITION_OFFLINE_PAGE_URL;
			} else if (MRScenario.environment.equals("prod")) {
				startNew(UMS_ACQISITION_PROD_PAGE_URL);
				testSiteUrl=UMS_ACQISITION_PROD_PAGE_URL;
			} else {
				startNew(UMS_ACQISITION_PAGE_URL);
				testSiteUrl=UMS_ACQISITION_PAGE_URL;
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: "+driver.getCurrentUrl());
			checkModelPopup(driver,30);
			CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 45);
			CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn,20); // do not change this to waitForPageLoadNew as we're not trying to fail the test if it isn't found
			try{
				if(proactiveChatExitBtn.isDisplayed())
					jsClickNew(proactiveChatExitBtn);
			}catch(Exception e){
				System.out.println("Proactive chat popup not displayed");
			}
		} else if("health-plans".equalsIgnoreCase(siteOrPage)){
			isHealthPlan = true;
				CommonUtility.checkPageIsReadyNew(driver);
				System.out.println("Current page URL: "+driver.getCurrentUrl());
				testSiteUrl=driver.getCurrentUrl();
				checkModelPopup(driver,30);
				CommonUtility.waitForPageLoadNew(driver, zipCode, 45);
				try{
					if(proactiveChatExitBtn!=null)
					jsClickNew(proactiveChatExitBtn);
					
					else 
						Assert.fail("Please check booleanvalue");
					
				}catch(Exception e){
					System.out.println("Proactive chat popup not displayed");
				}
		}else{
			openAndValidate();
		}
	}
	
	public void openAndValidate(String siteOrPage, String testharnessurl) {
		String testharurl = "content/"+testharnessurl+"testharness.html";
		//String testharurl = "content/pharmacysearchtestharnesspage.html";
		if ("ULayer".equalsIgnoreCase(siteOrPage)) {
			if (MRScenario.environment.equals("offline")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=AARP_ACQISITION_OFFLINE_PAGE_URL;
				driver.get(testSiteUrl+testharurl);
				MicroAppSiteUrl=AARP_ACQISITION_OFFLINE_PAGE_URL+testharurl;
			} else if (MRScenario.environment.equals("prod")) {
				startNew(AARP_ACQISITION_PROD_PAGE_URL+testharurl);
				testSiteUrl=AARP_ACQISITION_PROD_PAGE_URL+testharurl;
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=AARP_ACQISITION_PROD_PAGE_URL;
				driver.get(testSiteUrl+testharurl);
				MicroAppSiteUrl=AARP_ACQISITION_PROD_PAGE_URL+testharurl;
			} else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=AARP_ACQISITION_PAGE_URL;
				driver.get(testSiteUrl+testharurl);
				MicroAppSiteUrl=AARP_ACQISITION_PAGE_URL+testharurl;
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: "+driver.getCurrentUrl());
		}
		else if ("BLayer".equalsIgnoreCase(siteOrPage)) {
			if (MRScenario.environment.equals("offline")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=UMS_ACQISITION_OFFLINE_PAGE_URL;
				driver.get(testSiteUrl+testharurl);
				MicroAppSiteUrl=UMS_ACQISITION_OFFLINE_PAGE_URL+testharurl;
			} else if (MRScenario.environment.equals("prod")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=UMS_ACQISITION_PROD_PAGE_URL;
				driver.get(testSiteUrl+testharurl);
				MicroAppSiteUrl=UMS_ACQISITION_PROD_PAGE_URL+testharurl;
			} else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl=UMS_ACQISITION_PAGE_URL;
				driver.get(testSiteUrl+testharurl);
				MicroAppSiteUrl=UMS_ACQISITION_PAGE_URL+testharurl;
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: "+driver.getCurrentUrl());
		}
	}
	
	@SuppressWarnings("deprecation")
	public void openAndValidate(boolean alreadyOnSite) {
		if (alreadyOnSite) {
			
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		testSiteUrl=driver.getCurrentUrl();
		checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 45);
		try{
			if(proactiveChatExitBtn!=null)
			jsClickNew(proactiveChatExitBtn);
			
			else 
				Assert.fail("Please check booleanvalue");
			
		}catch(Exception e){
			System.out.println("Proactive chat popup not displayed");
		}
		}
	}
	
	public void openAndValidate(int visitorProfile) {
		if (visitorProfile>0) {
			
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		testSiteUrl=driver.getCurrentUrl();
		checkModelPopup(driver,30);
		CommonUtility.waitForPageLoadNew(driver, zipCode, 45);
		try{
			if(proactiveChatExitBtn!=null)
			jsClickNew(proactiveChatExitBtn);
			
			else 
				Assert.fail("Please check booleanvalue");
			
		}catch(Exception e){
			System.out.println("Proactive chat popup not displayed");
		}
		}
	}
	
	public String getTestSiteUrl() {
		return testSiteUrl;
	}
	
	public VPPPlanSummaryPage searchPlans(String zipcode, String countyName) {
		if (isHealthPlan) {
			CommonUtility.waitForPageLoadNew(driver, zipCode, 30);
			sendkeys(zipCode, zipcode);

			btnGO.click();
		} else {
			CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
			sendkeys(zipCodeField, zipcode);

			viewPlansButton.click();
		}

		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		if (validate(countyModal))
			driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage searchPlansForLearnFindPlans(String zipcode, String countyName) {
		sendkeys(learnzipCodeField, zipcode);
		learnfindPlansButton.click();
		try {
			if (countyModal.isDisplayed()) {
				for (WebElement county : countyRows) {
					if (county.getText().equalsIgnoreCase(countyName)) {
						county.click();
						break;
					}

				}
			}
		} catch (Exception e) {
			System.out.println("county box not found");
		}
		if (getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_PLAN_SUMMARY_PAGE_TITLE)) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage navigateToVpp(String zipcode) {
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 3000);
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();
		CommonUtility.waitForPageLoadNew(driver, vppTop, 3000);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public String selectsHomeFooter() {

		return homefooter.getText();
	}

	public VPPPlanSummaryPage enterZipcode(String zipCode, String county, String planYear) {
		sendkeys(zipCodeField, zipCode);
		zipCodebtn.click();
		return new VPPPlanSummaryPage(driver);
	}

	public JSONObject accessGlobalFooter() {
		String fileName = CommonConstants.GLOBAL_FOOTER_PAGE_DATA;
		globalFooter = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : globalFooter.getExpectedData().keySet()) {
			WebElement element = findElement(globalFooter.getExpectedData().get(key));
			if (element != null) {
				if (validateNew(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		globalFooterJson = jsonObject;

		return globalFooterJson;
	}

	public AcquisitionHomePage veiwAllDisclaimerLinkSectionLinksClick() {
		validateNew(viewAllDisclaimerInformationLink);
		viewAllDisclaimerInformationLink.click();

		validateNew(disclaimerBackToTopLink);
		disclaimerBackToTopLink.click();

		validateNew(hideDiscliamerInformation);
		hideDiscliamerInformation.click();

		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP� Medicare Plans from UnitedHealthcare�")) {
			return new AcquisitionHomePage(driver);
		}
		return null;
	}

	public Boolean visitAARPOrgClick() {
		validateNew(visitAARPLink);
		visitAARPLink.click();
		validateNew(visitAARPLink);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase("You are now leaving AARPMedicarerx.com")) {
			proceedLink.click();
			if (driver.getCurrentUrl().equals("http://www.aarp.org/")) {
				return true;

			}
		}
		return false;
	}

	public Boolean validate_alreadyPlanMemberButton_inactive() {
		return validateNew(alreadyPlanMemberButtonInactive);

	}

	public Boolean validate_alreadyPlanMemberButton_active() {
		validateNew(alreadyPlanMemberButton);
		alreadyPlanMemberButton.click();
		return validateNew(alreadyPlanMemberButtonActive);

	}

	public Boolean validate_textField() {

		validateNew(usernameField);
		usernameField.click();
		usernameField.sendKeys("q1ulayer");
		String user = usernameField.getAttribute("value");
		validateNew(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password");
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("q1ulayer") && pass.equalsIgnoreCase("Password")) {
			return true;
		}
		return false;
	}

	public AcquisitionHomePage navigationSectionHomeLinkClick() {
		validateNew(navigationSectionHomeLink);
		navigationSectionHomeLink.click();
		validateNew(navigationSectionHomeLink);
		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP� Medicare Plans from UnitedHealthcare�")) {
			return new AcquisitionHomePage(driver);
		}

		return null;
	}

	public Boolean navigationSectionEnterSearchClick() {
		validateNew(navigationSectionEnterSearch);
		navigationSectionEnterSearch.click();
		navigationSectionEnterSearch.sendKeys("home");
		String search = navigationSectionEnterSearch.getAttribute("value");
		if (search.equalsIgnoreCase("home")) {
			return true;
		}

		return false;
	}

	public Boolean enterInvalidUserNamePassword() {
		validateNew(usernameField);
		usernameField.click();
		usernameField.sendKeys("");
		// usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validateNew(passwordField);
		passwordField.click();
		passwordField.sendKeys("pas");
		// passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("") && pass.equalsIgnoreCase("pas")) {
			return true;
		}
		return false;
	}

	public Boolean checkErrorMessage() {
		validateNew(signInButton);
		signInButton.click();
		validateNew(signInButton);
		return validateNew(alreadyMemberInvalidCredsErrorMessage);
	}

	public Boolean enterValidUserNamePassword() {
		validateNew(usernameField);
		usernameField.click();
		usernameField.sendKeys("q3ulayer_090");
		// usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validateNew(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password@1");
		// passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("q3ulayer_090") && pass.equalsIgnoreCase("Password@1")) {
			return true;
		}
		return false;
	}

	public void hoverourplanslink() {
		validateNew(OurPlansLink1);
		// Hover over text
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(OurPlansLink1).build().perform();

		// to click
		// action.click().build().perform();

		validateNew(OurPlansLink1);

		// TODO Auto-generated method stub

	}

	public AcquisitionHomePage findplansbuttonclick() {
		validateNew(FindPlansButton1);
		FindPlansButton1.click();
		validateNew(FindPlansButton1);
		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP� Medicare Plans from UnitedHealthcare�")) {
			return new AcquisitionHomePage(driver);
		}

		return null;
	}

	// private PageData ourPlansNav;
	public JSONObject ourPlansNavJson;

	public void ourPlansHover() {
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(ourPlansDropdownText);
		actions.click();
		actions.perform();

	}

	public Boolean cookieValid() {
		validateNew(signInButton);
		signInButton.click();
		// validateNew(signInButton);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		validateNew(myPlansTab);
		if (getCookieName("membervisited") != null) {
			driver.switchTo().window(tabs.get(0));
			if (getCookieName("membervisited") != null) {
				return true;
			}
		}

		return false;
	}

	public Boolean alreadyMemberActiveValid() {

		validateNew(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if (timerId.contains("cookie")) {
			if (cookieValid()) {
				driver.navigate().refresh();
				String[] parts = timerId.split("-");
				String timerString = parts[1];
				int timer = Integer.parseInt(timerString);
				if (timer > 0) {
					return validateNew(signInButton);
				}
			}
		} else if (timerId.contains("visitor")) {
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			if (timer > 0) {
				return validateNew(signInButton);
			}

		}
		return false;
	}

	public Boolean cookieTimerValid() {
		driver.navigate().refresh();
		validateNew(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if (timerId.contains("cookie") || timerId.contains("visitor")) {
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			timer = timer * 1000;
			try {
				Thread.sleep(timer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return validateNew(signInButton);
	}

	public Boolean stopTimerValid() {
		validateNew(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if (timerId.contains("cookie")) {
			if (cookieValid()) {
				driver.navigate().refresh();
				String[] parts = timerId.split("-");
				String timerString = parts[1];
				int timer = Integer.parseInt(timerString);
				timer = timer * 1000;
				usernameField.click();
				try {
					Thread.sleep(timer);
					return validateNew(signInButton);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		} else if (timerId.contains("visitor")) {
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			try {
				Thread.sleep(timer);
				return validateNew(signInButton);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public void hoverhealthandwellnesslink() {

		validateNew(hoverhealthandwellnesslink);
		// Hover over text
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(hoverhealthandwellnesslink).build().perform();

		// TODO Auto-generated method stub

	}

	public JSONObject accessinghealthandwellnesslink() {

		hoverhealthandwellnesslink();
		return getHealthandWellnessDropdownJson();
	}

	public JSONObject getHealthandWellnessDropdownJson() {

		String fileName = CommonConstants.HEALTH_AND_WELLNESS_DROPDOWN_DATA;
		healthandwellnessdropdown = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : healthandwellnessdropdown.getExpectedData().keySet()) {
			WebElement element = findElement(healthandwellnessdropdown.getExpectedData().get(key));
			if (element != null) {
				if (validateNew(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		healthandwellnessdropdownJson = jsonObject;

		return healthandwellnessdropdownJson;

	}

	public JSONObject validatesDTMTags() {
		String fileName = CommonConstants.GLOBAL_FOOTER_PAGE_DATA;
		String filePath = CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ;
		String dtmFilePath = CommonConstants.DTM_TAG_ACQ_FILENAME;
		String dtmDir = CommonConstants.PAGE_OBJECT_DTM_TAG_DIR;
		globalFooterDTMJson = getDTMPageJson(fileName, filePath, dtmFilePath, dtmDir);
		return globalFooterDTMJson;

	}

	public void multiple_county(String zipcode) {
		System.out.println("Hi");
		sendkeys(zipCodeField, zipcode);
		System.out.println("Hi");
		viewPlansButton.click();
		if (countyModal.isDisplayed()) {
			System.out.println("County model window appeared");
		} else {
			System.out.println("County model window not found");
		}
	}

	public VPPPlanSummaryPage searchPlansWithOutCounty(String zipcode) throws InterruptedException {
		
			CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
			sendkeys(zipCodeField, zipcode);
			viewPlansButton.click();
	//	}
			CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
			if (driver.getCurrentUrl().contains("health-plans")) {
				return new VPPPlanSummaryPage(driver);
			}
			else
				return null;
	}
	
	public VPPPlanSummaryPage searchPlanOnHealthPlansPage(String zipcode, String county, String isMultiCounty){
		CommonUtility.waitForPageLoadNew(driver, healthPlansZipcode, 30);
		sendkeys(healthPlansZipcode, zipcode);
		viewPlansButton.click();
		
		if(isMultiCounty.equalsIgnoreCase("YES")){
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			if (validate(countyModal))
				driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + county + "']")).click();
		}
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage addPlansForVisitorProfile(String zipcode) {
		
		CommonUtility.waitForPageLoadNew(driver, zipCode, 30);
		sendkeys(zipCode, zipcode);

		btnGO.click();
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("health-plans")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void navigateToRequestMoreHelpAndInformation(String planType) {
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		moreHelpInfoLink.click();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (driver.getCurrentUrl().contains("request-information"))
				break;
		}
	}

	public void OurPlansPDPLanding() {

		Actions action = new Actions(driver);
		action.moveToElement(navigationSectionOurPlansLink).build().perform();

		PDPLandingLink.click();

		try {
			Thread.sleep(15000);
			System.out.println("Thread Sleep completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void OurPlanMALanding() {

		Actions action = new Actions(driver);
		action.moveToElement(navigationSectionOurPlansLink).build().perform();

		MALandingLink.click();

		try {
			Thread.sleep(15000);
			System.out.println("Thread Sleep completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PharmacySearchPage navigateToPharmacyLocator() {
		//checkModelPopup(driver);
		Actions action = new Actions(driver);
		action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		pharmacylocator.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().toLowerCase().contains((PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase())) {
			return new PharmacySearchPage(driver);
		}
		return null;

	}

	public PDPRequestHelpAndInformationPage navigateToPDPMoreHelpAndInfo() {

		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(pdp_moreHelpInfoLink);
		actions.click().build().perform();
		if (currentUrl().contains("prescription-drug-plans/request-information.html")) {
			return new PDPRequestHelpAndInformationPage(driver);
		}

		return null;

	}

	public RequestHelpAndInformationPage navigateToMaMoreHelpAndInfo() {

		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(moreHelpInfoLink);
		actions.click().build().perform();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, requestAgentApptDropdown, 60);
		if (validate(requestAgentApptDropdown)) {
			return new RequestHelpAndInformationPage(driver);
		}
		return null;
	}

	public AboutUsAARPPage aboutUsFooterClick() {
		validateNew(footerAboutUsLink);
		footerAboutUsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (getTitle().contains("About UnitedHealthcare")) {
			return new AboutUsAARPPage(driver);
		}
		return null;
	}

	public void validateFooterLinks() {
		validateNew(footerHomeLink);
		validateNew(footerAboutUsLink);
		validateNew(footerContactUsLink);
		validateNew(footerSiteMapLink);
		validateNew(footerPrivacyPolicyLink);
		validateNew(footerTermsnConditionsLink);
		validateNew(footerDisclaimersLink);
		validateNew(footerAgentsnBrokersLink);
		//validateNew(footerRequestforAssistancelink);
		validateNew(footerAccessibilitylink);
		validateNew(aarpOrgLink);
		validateNew(medicareAdvantagePlansLink);
		validateNew(medicareSpecialNeedsPlansLink);
		validateNew(medicareSupplementInsurancePlansLink);
		validateNew(medicarePrescriptionDrug_PlansLink);
		validateNew(learnAboutMedicareLink);
		validateNew(viewAllDisclaimerInformationLink);

	}

	public ContactUsAARPPage contactUsFooterClick() {
		validateNew(footerContactUsLink);
		footerContactUsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("contact-us")) {
			return new ContactUsAARPPage(driver);
		}
		return null;
	}
	
	public SiteMapAARPPage siteMapFooterClick() {
		validateNew(footerSiteMapLink);
		footerSiteMapLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(siteMapHeader);
		if (driver.getCurrentUrl().contains("sitemap.html")){
			return new SiteMapAARPPage(driver);
		}
		return null;
	}
	
		
	
	public PrivacyPolicyAARPPage privacypolicyFooterClick() {
		validateNew(footerPrivacyPolicyLink);
		footerPrivacyPolicyLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(privacyHeader);
		if (driver.getCurrentUrl().contains("privacy-policy.html")) {
			return new PrivacyPolicyAARPPage(driver);
		}
		return null;
	}

	public TermsnConditionsAARPPage termsnconditionsFooterClick() {
		validate(footerTermsnConditionsLink);
		footerTermsnConditionsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("terms-of-use")) {
			return new TermsnConditionsAARPPage(driver);
		}
		return null;
	}
	
	public DisclaimersAARPPage disclaimersFooterClick() {
		validate(footerDisclaimersLink);
		footerDisclaimersLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("disclaimer")) {
			return new DisclaimersAARPPage(driver);
		}
		return null;
	}
	
	public AgentsnBrokersAARPPage agentsnbrokersFooterClick() {
		validate(footerAgentsnBrokersLink);
		footerAgentsnBrokersLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(brokerHeader);
		if(driver.getCurrentUrl().contains("health-insurance-brokers")){
			return new AgentsnBrokersAARPPage(driver);
		}
		return null;
	}
	
	public AcquisitionHomePage homeFooterClick() {
		validateNew(footerHomeLink);
		footerHomeLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (validateNew(zipCodeField)) {
			return new AcquisitionHomePage(driver, true);
		}
		return null;
	}
	
	public void clickRequestAsistancce() {
		validateNew(footerRequestforAssistancelink);
		if(proactiveChatExitBtn!=null)
			proactiveChatExitBtn.click();
		footerRequestforAssistancelink.click();
		CommonUtility.waitForPageLoadNew(driver, requestAssistanceModal, 30);
		validateNew(requestAssistanceTitle);
		validateNew(requestAssistanceAgentID);
		requestAssistanceClose.click();
		waitforElementDisapper(By.id("cobrowse-disclaimer"), 30);
	}
	public boolean validateSomeElementsOnPage() {
		if (validateNew(zipCodeField) && validateNew(findPlansButton) && validateNew(lookzip))
			return true; // if all three
		return false;

	}

	public boolean validateAllElementsOnPage() {
		if (!validateNew(zipCodeField) && !validateNew(findPlansButton) && !validateNew(lookzip))
			return false; // if all three elements return false for validation
							// then this condition passes due to ! and returns
							// false meaning all three elements were not found
							// on page
		return true;
	}

	public GetStartedPage navigateToPrescriptionDrug() {
		enterYourDrugListButton.click();
		if (getTitle().equalsIgnoreCase("Our Medicare Plan Types | AARP� Medicare Plans from UnitedHealthcare�")) {
			return new GetStartedPage(driver);
		} else {
			return null;
		}
	}

	public DrugCostEstimatorPage navigateToDCEToolFromHome() throws InterruptedException {
		validateNew(getStarted);
		getStarted.click();

		if (driver.getCurrentUrl().contains("health-plans/estimate-drug-costs.html"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}

	public VPPPlanSummaryPage ZipcodeSearch(String zipcode) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");

		sendkeys(StandaloneZipcode, zipcode);
		StandalonSearchCounty.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (countyDropdown.isDisplayed()) {
				countyDropdown.click();
				Thread.sleep(3000);
				// StandalonSearchCounty.click();
			}

		} catch (Exception e) {
			System.out.println("county box not found");
		}
		jse.executeScript("window.scrollBy(0,100)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		ViewPlansPricingButton.click();

		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}
		
	
	public MultiCountyModalPage ValidateMultiCOuntyPopUp(String zipcode) {		
		CommonUtility.waitForPageLoad(driver, zipCodeField, 30);
		sendkeys(zipCodeField, zipcode);

		viewPlansButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (countyModal.isDisplayed()) {
			return new MultiCountyModalPage(driver);
		}
		return null;
	}
	
	public WebElement getLnkLearnAboutMedicare() {
		return lnkLearnAboutMedicare;
	}

	public LearnAboutMedicareHomePage openLearnAboutMedicarePage() {

		getLnkLearnAboutMedicare().click();
		validateNonPresenceOfElement(zipCodeField);
		return new LearnAboutMedicareHomePage(driver);
	}

	

	public MultiCountyModalPage SubNav_ValidateMultiCOuntyPopUp(String zipcode) {
		hoverourplanslink();
		validate(OurPlans_zipfield);
		OurPlans_zipfield.click();
		OurPlans_zipfield.sendKeys(zipcode);
		validate(OurPlans_viewPlansButton);
		OurPlans_viewPlansButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (countyModal.isDisplayed()) {
			return new MultiCountyModalPage(driver);
		}
		return null;
	}		
	
	public ProviderSearchPage clicksOnRallyToolFromGlobalHeader() {

		Actions action = new Actions(driver);
		action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		validateNew(providerSearchFromGlobalHeader);

		switchToNewTabNew(providerSearchFromGlobalHeader);

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {

			return new ProviderSearchPage(driver);

		}
		return null;
	}

	public ProviderSearchPage clicksOnRallyToolFromHomePage() {
		validateNew(providerSearchFromHomeScreen);

		switchToNewTabNew(providerSearchFromHomeScreen);

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {

			return new ProviderSearchPage(driver);

		}
		return null;
	}
	public AcquisitionHomePage hovershopaplan() throws InterruptedException {
		
		waitforElement(ShopForaplan);
		if (ShopForaplan.isDisplayed()) {
			Actions actions = new Actions(driver);
			actions.moveToElement(ShopForaplan);
			waitforElementNew(submit);
			System.out.println("Submit button is displayed");
			return new AcquisitionHomePage(driver);
	      }
		else {
			return null;}
	
	
}
	public DrugCostEstimatorPage navigationDrugCostEstimator() {
     	navigateToMenuLinks(ShopForaplan, headerDrugCostEstimatorLink);

     	
     		return new DrugCostEstimatorPage(driver);
	 }
	
	public ShopforaplanAARPlayer Hoveronaplan() throws InterruptedException
    {             
           waitforElement(ShopForaplan);
     if (ShopForaplan.isDisplayed()) {
            Actions action = new Actions(driver);
            action.moveToElement(ShopForaplan).build().perform();
            return new ShopforaplanAARPlayer(driver);
     }
           else {
                  return null;}
    }
	
	public WelcomePage ZipcodeSearchToOLEWithOutCounty(String zipcode,String planName) throws Exception {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");

		sendkeys(StandaloneZipcode, zipcode);
		StandalonSearchCounty.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		jse.executeScript("window.scrollBy(0,100)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		//String planYear=ZipCodeLabel.getText();
		driver.findElement(By.xpath("//*[@id='js-ole-plan-select']//option[text()='" + planName + "']")).click();
		waitforElement(enrollButton);
		enrollButton.click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("Online Enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}
	
	public WelcomePage ZipcodeSearchToOLEWithCounty(String zipcode, String countyName,String planName) throws Exception {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");

		sendkeys(StandaloneZipcode, zipcode);
		StandalonSearchCounty.click();
		driver.findElement(By.xpath("//select[@id='ole-county-select']//option[text()='" + countyName + "']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		jse.executeScript("window.scrollBy(0,100)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		driver.findElement(By.xpath("//*[@id='js-ole-plan-select']//option[text()='" + planName + "']")).click();
		waitforElement(enrollButton);
		enrollButton.click();
		Thread.sleep(5000);
		if (driver.getTitle().contains("Online Enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}
	
	public void selectState(String state) {
		selectFromDropDownByValue(stateDropDown, state);
	}
	/**
	 * This method used to navigate to visitor profile dashboard
	 * @return
	 */
	public VisitorProfilePage navigateToVisitorProfilePage() {
		waitforElement(shoppingCartIcon);
		shoppingCartIcon.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if(driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		}else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}
	
	public VPPPlanSummaryPage findPlans(String txtZipCode){
		
		zipCode.sendKeys(txtZipCode);
		
		
		return new VPPPlanSummaryPage(driver);
	}
	public  keywordSearchAARP searchfield() {
		validate (searchfield);		
		System.out.println("search field is seen on AARP site  ==>" + searchfield.isDisplayed());
		validate (searchbutton);
		System.out.println("search button is seen on AARP site ==>"  + searchbutton.isDisplayed());
		searchfield.clear();		
		searchfield.sendKeys("medicare");
		searchbutton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("medicare.html?q=medicare"))
		return new  keywordSearchAARP(driver);
		return null;	
	}
	
	 public AcquisitionHomePage validateCallSam() throws InterruptedException {
	        boolean present;
	        try {
	        validateNew(callsam);
	        present = true;
	        } catch (NoSuchElementException e) {
	        present = false;
	        }
	        if (present) {
	          System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
	          return new AcquisitionHomePage(driver);
	        }
	        else
	        	System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
	       return null;
		}
		
		public AcquisitionHomePage validateCallSamContent() throws InterruptedException {
			
			Actions action = new Actions(driver);
			WebElement element = callsam;
			action.moveToElement(element).perform();
			String toolTipText = callsamtooltip.getText();
			System.out.println("====================================================================");
			System.out.println(toolTipText);
			System.out.println("====================================================================");
			
	        if (CallSam.equalsIgnoreCase(toolTipText)) {
	          System.out.println("Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent");
	          return new AcquisitionHomePage(driver);
	        }
	        else
	        	System.out.println("No Call sticky action menu didn't roll out and doesn't contain the text Call a Licensed Insurance Agent");
	       return null;
		}
		
		public AcquisitionHomePage  validateCallpopup() throws InterruptedException {
			//CommonUtility.checkPageIsReady(driver);
			callsam.click();
			System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");		
			driver.switchTo().activeElement();
			System.out.println(CallSamTFN.getText());
			CallSamTFNClose.click();
			validateNew(callsam);		
			return null;
		}
		
		public AcquisitionHomePage validateChatSam() throws InterruptedException {
	        boolean present;
	        try {
	        validateNew(chatsam);
	        present = true;
	        } catch (NoSuchElementException e) {
	        present = false;
	        }
	        if (present) {
	          System.out.println("@@@@@@@@@ Able to find Chat widget @@@@@@@@@");
	          return new AcquisitionHomePage(driver);
	        }
	        else
	        	System.out.println("@@@@@@@@@ No Chat widget @@@@@@@@@");
	       return null;
		}
		
		public AcquisitionHomePage validateChatSamContent() throws InterruptedException {
			
			Actions action = new Actions(driver);
			WebElement element = chatsam;
			action.moveToElement(element).perform();
			String ChattoolTipText = chatsamtooltip.getText();
			System.out.println("====================================================================");
			System.out.println(ChattoolTipText);
			System.out.println("====================================================================");
			
	        if (ChatSamText.equalsIgnoreCase(ChattoolTipText)) {
	          System.out.println("Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent");
	          return new AcquisitionHomePage(driver);
	        }
	        else
	        	System.out.println("No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
	       return null;
		}
		
		public AcquisitionHomePage  validateChatpopup() throws InterruptedException {
			//CommonUtility.checkPageIsReady(driver);
			validateNew(chatsam);
			jsClickNew(chatsam);
			System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");	
			validateandcloseChat();
/*			chatsamtooltip.click();
			driver.switchTo().activeElement();
			System.out.println(ChatSamHead.getText());
			ChatSamTFNClose.click();
			validateNew(chatsam);		*/
			return null;
		}
		
		
		
		public PharmacySearchPage navigateFromTestharnessToPharmacySearch(String zipcode) {
			//checkModelPopup(driver);
			validateNew(thpharmacyzipsearch);
			thpharmacyzipsearch.sendKeys(zipcode);
			thpharmacyGoButton.click();
			CommonUtility.checkPageIsReadyNew(driver);
			if (driver.getTitle().toLowerCase().contains((PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase())) {
				return new PharmacySearchPage(driver);
			}
			return null;

		}

		public DCETestHarnessPage GetDCEtestHarnessPage() {
			return new DCETestHarnessPage(driver);
		}
		
		public ZipcodeLookupHomePage looksupforZipcodes() {

			lookzip.click();

			CommonUtility.waitForPageLoad(driver, zipCodeSearchPopup, CommonConstants.TIMEOUT_30);
			if (zipCodeSearchPopupHeading.getText().equalsIgnoreCase("Find a ZIP code")) {
				System.out.println("zipCodeSearchPopupHeading");
				return new ZipcodeLookupHomePage(driver);
			}
			return null;

		}
		
		public VPPPlanSummaryPage searchPlansCounty(String countyName) {
			if (isHealthPlan) {
				CommonUtility.waitForPageLoadNew(driver, zipCodeHealthPlans, 45);
				GoBtnHealthPlans.click();
				CommonUtility.waitForPageLoadNew(driver, vppTop, 30);

			} else {
				CommonUtility.waitForPageLoadNew(driver, zipCodeField, 20);
				viewPlansButton.click();
			}
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			if (validate(countyModal))
				System.out.println("County should be selected : " + countyName);
			driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
			CommonUtility.waitForPageLoadNew(driver, vppTop, 35);

			if (driver.getCurrentUrl().contains("plan-summary")) {
				return new VPPPlanSummaryPage(driver);

			}
			return null;
		}

		public VPPPlanSummaryPage searchPlansNoCounty() {
			if (isHealthPlan) {
				CommonUtility.waitForPageLoadNew(driver, zipCodeHealthPlans, 45);
				GoBtnHealthPlans.click();
				CommonUtility.waitForPageLoadNew(driver, vppTop, 30);

			} else {
				CommonUtility.waitForPageLoadNew(driver, zipCodeField, 20);
				viewPlansButton.click();
				CommonUtility.waitForPageLoadNew(driver, vppTop, 35);
			}
			if (driver.getCurrentUrl().contains("plan-summary")) {
				return new VPPPlanSummaryPage(driver);
			}
			return null;
		}
		
		public VPPTestHarnessPage GetVPPTestHarnessPage() {
			return new VPPTestHarnessPage(driver);
		}

		public VisitorProfileTestHarnessPage GetVisitorProfileTestHarnessPage() {
			return new VisitorProfileTestHarnessPage(driver);
		}
		public OLETestHarnessPage GetOLETestHarnessPage() {
			return new OLETestHarnessPage(driver);
		}
		
		public void validateStateDropDown() {
			validateNew(stateDropDown);
			selectFromDropDownByValue(stateDropDown, "California");
			String StateSessionStorage = ReturnDriverStorage(driver, "sessionStorage","ucp_geotrackingState" );
			System.out.println("State selected : California");
			System.out.println("State GeoSessionStorage value : "+StateSessionStorage);
			Assert.assertTrue("Geolocation State validation Failed ", StateSessionStorage.equalsIgnoreCase("CA"));
		}

		public void validateDisclaimer() {
		  validateNew(disclaimerInformation);
		  disclaimerInformation.click();
		  validateNew(backToTop_Disclaimer);	
		}

		public void validateVisitAarpOrglink() {
		  validateNew(visitAARPFooterLink);
		  String hRef = visitAARPFooterLink.getAttribute("href");
		  System.out.println("href for Visit AARP.org link : "+hRef);
		  Assert.assertTrue("Incorrect href for Visit AARP.org : "+hRef,hRef.contains("www.aarp.org"));
		  visitAARPFooterLink.isEnabled();
		}

		public void backToToplink() {
		 validateNew(backToTop);
		 backToTop.click();	
		}

		public void validateHeaderLinks() {
			  validateNew(headerSignInLink);
			  validateNew(headerRegisterLink);
			  validateNew(visitAARPLink);
			  validateNew(AARPlogo);
			  validateNew(visitorprofileicon);
			}

		public void signInheader() {
			headerSignInLink.click();
			CommonUtility.waitForPageLoad(driver, signIn, 30);
			if(driver.getCurrentUrl().contains("medicare.uhc.com/aarp")){
				Assert.assertTrue(true);
				System.out.println("Signin page is loaded");
				driver.navigate().back();
				CommonUtility.waitForPageLoad(driver, healthPlansZipcode, 30);
				System.out.println("Home Page is loaded");
			}
			else
			{
				Assert.fail("Unable to navigate to signin page");
			}	
			
		}

		public void validateAARPlogo() {
			// TODO Auto-generated method stub
			  validateNew(AARPlogo);	
			  WebElement AARPLogo = driver.findElement(By.xpath("//a[contains(@id, 'aarpSVGLogo')]"));
			  WebElement UHCLogo = driver.findElement(By.xpath("//a[contains(@id, 'uhcSVGLogo')]"));
				if(AARPLogo.isDisplayed() && AARPLogo.isEnabled() && !UHCLogo.isDisplayed()){
					Assert.assertTrue(true);
					System.out.println("Correct AARP Logo is Displayed");
				}
				else
				{
					Assert.fail("AARP logo is not dispalyed for Ulayer");
				}	

		}

		public void navigateToPath(String path) {

			String CurrentURL = driver.getCurrentUrl();
			System.out.println("Current URL : "+CurrentURL);

			String NavigateToURL = CurrentURL+path;
			System.out.println("Navigating to URL : "+NavigateToURL);
			driver.navigate().to(NavigateToURL);
			CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 30);
			System.out.println("Page Title : "+(driver.findElement(By.xpath("//title")).getText()));

			
		}

		public void validateGlobalFooterLinks() {
			validateNew(footerHomeLink);
			validateNew(footerAboutUsLink);
			validateNew(footerContactUsLink);
			validateNew(footerSiteMapLink);
			validateNew(footerPrivacyPolicyLink);
			validateNew(footerTermsnConditionsLink);
			validateNew(footerDisclaimersLink);
			validateNew(footerAgentsnBrokersLink);
			validateNew(footerAccessibilitylink);
			validateNew(aarpOrgLink);
			validateNew(medicareAdvantagePlansLink);
			validateNew(medicareSupplementInsurancePlansLink);
			validateNew(medicarePrescriptionDrug_PlansLink);
			validateNew(medicareSpecialNeedsPlansLink);
			validateNew(learnAboutMedicareLink);
		}

		public void validateTFNelement(String tfnXpath) {
			WebElement TFNelement = driver.findElement(By.xpath(tfnXpath));
			validateNew(TFNelement);	
			if(validateNew(TFNelement) && TFNelement.isDisplayed()) {
				System.out.println("TFN is Displayed on Page : "+TFNelement.getText());
			}
			else {
				Assert.fail("TFN elemnet is not found / displayed on page : "+tfnXpath);
			}
		}

		
		private void CheckPageLoad() {
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: "+driver.getCurrentUrl());
			checkModelPopup(driver, 30);
		
		}
		
		public void CheckiPerseptions() {
			CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn,20); // do not change this to waitForPageLoadNew as we're not trying to fail the test if it isn't found
			try{
				if(proactiveChatExitBtn.isDisplayed())
					jsClickNew(proactiveChatExitBtn);
			}catch(Exception e){
				System.out.println("Proactive chat popup not displayed");
			}
		}
		
		
		public void validateSubNavShopPlanLinks() {
			CheckPageLoad();
			CheckiPerseptions();
		
			waitforElement(ShopForaplan);
			if (ShopForaplan.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(ShopForaplan);
				actions.build().perform();
				System.out.println("Hover over Shop for a Plan completed");

//				waitforElementNew(driver.findElement(By.xpath("//input[@id='nav-zipcode']")));
//				System.out.println("Submit button is displayed");
		    }
			WebElement ZipCodeTxt = driver.findElement(By.xpath("//input[@id='nav-zipcode']"));
			WebElement FindPlansBtn = driver.findElement(By.xpath("//button[@dtmid='acq_top_nav']"));
			WebElement RequestMoreInfoLink = driver.findElement(By.xpath("//a[@dtmname='Top Nav:Our Plans:Request More Help']"));
			WebElement EnrollLink = driver.findElement(By.xpath("//a[contains(@href,'enroll.html')]"));
			WebElement ShopLink = driver.findElement(By.xpath("//a[contains(@href,'shop.html')]"));
			WebElement ResourceLink = driver.findElement(By.xpath("//a[contains(@href,'resources.html')]"));

			WebElement MAplansLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'medicare-advantage-plans.html')]"));
			WebElement MedSuppPlansLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'medicare-supplement-plans.html')]"));
			WebElement PDPplansLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'prescription-drug-plans.html')]"));
			WebElement SNPplansLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'special-needs-plans.html')]"));

			WebElement PlanSelectorLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'medicare-plans.html')]"));
			WebElement DCELink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'drug-cost-estimator')]"));
			WebElement PharmacySearchLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'aarp-pharmacy.html')]"));
			WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@onclick,'loadCachedProviderSearch')]"));

			validateNew(ZipCodeTxt);
			validateNew(FindPlansBtn);
			validateNew(RequestMoreInfoLink);
			
			validateNew(EnrollLink);
			validateNew(ShopLink);
			validateNew(ResourceLink);
			
			validateNew(MAplansLink);
			validateNew(MedSuppPlansLink);
			validateNew(PDPplansLink);
			validateNew(SNPplansLink);
			
			validateNew(PlanSelectorLink);
			validateNew(DCELink);
			validateNew(PharmacySearchLink);
			validateNew(ProviderSearchLink);

			if(ZipCodeTxt.isDisplayed() && FindPlansBtn.isDisplayed() && RequestMoreInfoLink.isDisplayed()
					&& EnrollLink.isDisplayed() && ShopLink.isDisplayed() && ResourceLink.isDisplayed()
					&& MAplansLink.isDisplayed() && MedSuppPlansLink.isDisplayed() && PDPplansLink.isDisplayed()
					&& SNPplansLink.isDisplayed() && PlanSelectorLink.isDisplayed() && DCELink.isDisplayed() && PharmacySearchLink.isDisplayed() && ProviderSearchLink.isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("Sub Nav - Shop for a Plan - All links and element displayed on Page : "); 
				Actions actions = new Actions(driver);
				actions.moveToElement(AARPlogo);
				actions.build().perform();
}
			else {
				Assert.fail("Sub Nav - Shop for a Plan - All links and element not found / displayed on page : "); 
			}
		 			
		}

		public void validateSubNavMedEdLinks() {
			CheckPageLoad();
			CheckiPerseptions();
		
			waitforElement(lnkLearnAboutMedicare);
			if (lnkLearnAboutMedicare.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(lnkLearnAboutMedicare);
				actions.build().perform();
				System.out.println("Hover over Learn about Medicare completed");
		    }
			WebElement EligibilityTxt = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-eligibility')]"));
			WebElement ChoicesBtn = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-parts-and-medigap-plans')]"));
			WebElement PresProvidersBenefitsLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-benefits')]"));
			WebElement CostbasicsLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-costs')]"));

			WebElement MAplansLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-advantage-plans')]"));
			WebElement MedSuppPlansLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-supplement-plans.html')]"));
			WebElement PDPplansLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-part-d')]"));

			WebElement EnrollmentBasicsLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'enrollment-and-changing-plans')]"));
//			WebElement FAQLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-faq')]"));

		validateNew(EligibilityTxt);
		validateNew(ChoicesBtn);
		validateNew(PresProvidersBenefitsLink);
		validateNew(CostbasicsLink);

		validateNew(MAplansLink);
		validateNew(MedSuppPlansLink);
		validateNew(PDPplansLink);

		validateNew(EnrollmentBasicsLink);

		  if(EligibilityTxt.isDisplayed() && ChoicesBtn.isDisplayed() &&
				  PresProvidersBenefitsLink.isDisplayed() && CostbasicsLink.isDisplayed() &&
				  MAplansLink.isDisplayed() && MedSuppPlansLink.isDisplayed() &&
				  PDPplansLink.isDisplayed() &&
				  EnrollmentBasicsLink.isDisplayed()) { 
			  //&& FAQLink.isDisplayed()
			  Assert.assertTrue(true); 
			  System.out.println("Sub Nav - Learn about Medicare - All links and element displayed on Page");
				Actions actions = new Actions(driver);
				actions.moveToElement(AARPlogo);
				actions.build().perform();
		  } 
		  else { 
			  Assert.fail("Sub Nav - Learn about Medicare - All links and element not found / displayed on page"); 
			  }
		}

		public void headerRegisterLink() {
			if(headerRegisterLink.isDisplayed() && headerRegisterLink.isEnabled()) {
				Assert.assertTrue(true);
				System.out.println("Register link is displayed on home page");
			}
			else {
				Assert.fail("Register link is not found/ displayed on home page");
			}
			
		}

		public void validatevisitorprofile() {
			if(visitorprofileicon.isDisplayed()){
				Actions actions = new Actions(driver);
				actions.moveToElement(visitorprofileicon).perform();
				System.out.println("Hover over visitor profile completed");
			}
			WebElement CreateProfile = driver.findElement(By.xpath("//a[contains(text(), 'Create Profile')]"));
			WebElement VPSignIn = driver.findElement(By.xpath("//a[contains(text(), 'Sign In') and not(contains(@aria-labelledby ,'VPSignIn'))]"));
			validateNew(CreateProfile);
			validateNew(VPSignIn);
			if(CreateProfile.isEnabled() && VPSignIn.isEnabled()){
				Assert.assertTrue(true);
				System.out.println("Visitor Profile elements are present on home page");
			}
			else {
				Assert.fail("Visitor Profile elements are not present on home page");
			}	
			visitorprofileicon.click();
			WebElement GuestProfile = driver.findElement(By.xpath("//*[contains(text(), 'Your Guest Profile')]"));
			CheckPageLoad();
			CheckiPerseptions();
			CommonUtility.waitForPageLoadNew(driver, GuestProfile, 30);
			if(driver.getCurrentUrl().contains("profile/guest")){
		      Assert.assertTrue(true);
		      System.out.println("Visitor Profile Page opens successsfully");
			}
			else {
				Assert.fail("Visitor Profile page is not opening up");
			}
			driver.navigate().back();
			CheckPageLoad();
			CheckiPerseptions();

			CommonUtility.waitForPageLoadNew(driver, findPlansButton, 30);
		}

		public void validateChatProActive() {
	        boolean present;
	        CommonUtility.waitForPageLoadNew(driver, ProActivePopup, 30);
	        validateNew(ProActivePopup);
	        validateNew(ProActivePopup_Close);
	        validateNew(ProActivePopup_ExitBtn);
	        validateNew(ProActivePopup_ChatBtn);
	        present = true;
	        if (ProActivePopup.isEnabled() && ProActivePopup_Close.isEnabled()
	        		&& ProActivePopup_ExitBtn.isEnabled() && ProActivePopup_ChatBtn.isEnabled()) {
	          System.out.println("@@@@@@@@@ Able to find Pro-Active Chat widget @@@@@@@@@");
	        }
	        else {
	        	System.out.println("@@@@@@@@@ No Pro-Active widget @@@@@@@@@");
	        	Assert.fail();
	        }			
		}

		public void validateProActiveChatpopup() {
	        validateNew(ProActivePopup_ChatBtn);
			jsClickNew(ProActivePopup_ChatBtn);
			System.out.println("@@@@@@@@@@@@@@@ Pro-Avtive Chat Button Clicked @@@@@@@@@@@@@@@");	
			validateandcloseChat();
		}

		private void validateandcloseChat() {
			driver.switchTo().activeElement();
			validateNew(ProActivechatPopup);
			validateNew(ChatSamTFNClose);
			System.out.println(ProActivechatPopup.getText());
			jsClickNew(ChatSamTFNClose);
			System.out.println("Exiting Chat");
			validateNew(chatsam);		
		
		}
		
		//***** below functions are used to validate SAM Call Icon on All of the Acquisition Pages
		public void validateCallSamAcq() throws InterruptedException {
			boolean present;
			try {
				validateNew(callsam);
				present = true;
				} catch (NoSuchElementException e) {
				present = false;
				}
				if (present) {
				  System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
				}
			else
				System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");		
		}
		
		public void validateCallSamContentAcq() throws InterruptedException {
		
		Actions action = new Actions(driver);
		WebElement element = callsam;
		action.moveToElement(element).perform();
		String toolTipText = callsamtooltip.getText();
		System.out.println("====================================================================");
		System.out.println(toolTipText);
		System.out.println("====================================================================");
		
		if (CallSam.equalsIgnoreCase(toolTipText)) {
		  System.out.println("Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent");
		}
		else
			System.out.println("No Call sticky action menu didn't roll out and doesn't contain the text Call a Licensed Insurance Agent");
		}
		
		
		public AcquisitionHomePage  verifyChatpopup() throws InterruptedException {
			//CommonUtility.checkPageIsReady(driver);
			chatsam.click();
			System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");	
				
			return null;
		}
		
		public AcquisitionHomePage validateChatSamAcq() throws InterruptedException {
	        boolean present;
	        try {
	        validateNew(chatsam);
	        present = true;
	        } catch (NoSuchElementException e) {
	        present = false;
	        }
	        if (present) {
	          System.out.println("@@@@@@@@@ Able to find Chat widget @@@@@@@@@");
	        }
	        else
	        	System.out.println("@@@@@@@@@ No Chat widget @@@@@@@@@");
	       return null;
		}
		
		public AcquisitionHomePage validateChatSamContentAcq() throws InterruptedException {
			
			Actions action = new Actions(driver);
			WebElement element = chatsam;
			action.moveToElement(element).perform();
			String ChattoolTipText = chatsamtooltip.getText();
			System.out.println("====================================================================");
			System.out.println(ChattoolTipText);
			System.out.println("====================================================================");
			
	        if (ChatSamText.equalsIgnoreCase(ChattoolTipText)) {
	          System.out.println("Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent");
	        }
	        else
	        	System.out.println("No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
	       return null;
		}
		
	public AcquisitionHomePage  navigateToPage(String page) {
		String pageURL = driver.getCurrentUrl()+page;
		System.out.println("==pageURL=="+pageURL);
		driver.navigate().to(pageURL);
		
		
		return null;
		
	}

	}

	 


	 