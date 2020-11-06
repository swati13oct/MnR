package pages.acquisition.commonpages;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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
import org.testng.Assert;

import pages.acquisition.commonpages.EnterZipCodePage;
import pages.acquisition.dce.DCETestHarnessPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.ulayer.ProviderSearchPage;


/**
 * @author pperugu
 *
 */
public class AcquisitionHomePage extends GlobalWebElements {

	@FindBy(xpath= "//*[contains(@id,'cta-zipcode')]")
	private WebElement zipCodeField;
	
	@FindBy(xpath = "//*[contains(@id,'zipcodemeded-0')]")
	private WebElement zipCodeShopField;
	
	@FindBy(xpath = "//*[contains(@id,'zipcodemeded')][1]//following-sibling::button//*[contains(text(),'Shop Plans')]")
	private WebElement viewShopPlansButton;
	

	//@FindBy(xpath = "//*[contains(@id,'zipcodemeded')][1]//following-sibling::button//*[contains(text(),'Get Started')]")
	@FindBy(xpath = "(//*[contains(@id,'zipcodemeded')][1]//following-sibling::button)[1]")
	private WebElement ShopEnrollButton;
	
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

	@FindBy(xpath = "//div[@class='overview-main']//h2")
	private WebElement vppTop;

	@FindBy(xpath = ".//*[contains(@id,'colhowdoesthiswork')]//*[@itemprop='significantLink']/*[contains(@class,'cta-button secondary')and contains(text(),'Get')]")
	public WebElement getStarted;

	//@FindBy(xpath = ".//*[contains(@class, 'meded-article-content__section')]//*[contains(text(), 'Request an Appointment')]")
	@FindBy(xpath = "//a[contains(text(),'Find an Agent')]")
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

	@FindBy(xpath = "//*[contains(@id,'zipcodebtn') or (@class='zip-button') and (contains(@dtmid,'plans'))]")
	private WebElement viewPlansButton;
	
	@FindBy(xpath = "//form[@id='zip-form']//button[@class='zip-button']")
	private WebElement findPlansBtn;
	
	@FindBy(xpath="//button[@class='zip-button' and text()='Go']")
	public WebElement btnGO;

	/*
	 * @FindBy(id = "vpp_selectcounty_box") private WebElement countyModal;
	 */

	@FindBy(xpath = "//*[contains(@id,'change-location')]")
	private WebElement zipcodeChangeLink;
	
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
	
	
	@FindBy(xpath ="//*[contains(@class,'cta-button secondary') and contains(text(),'Find a Provider')]")
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
    
	@FindBy(xpath = "//button[@id='sam-call-button']//*[contains(@class,'sam__button__text desktop')]")
   	private WebElement callsam;
   	
   	//@FindBy(xpath = "//*[@id='sam-call-button']/div/span[1]")
  	@FindBy(xpath = "//*[contains(@class,'sam__button__text') and contains(text(),'1-')]")
   	private WebElement callsamtooltip;
   	
   	@FindBy(xpath ="//*[@id='sam-call-modal']/div/div")
   	private WebElement callSamPopup;
   	
   	@FindBy(xpath = "//*[contains(@class,'companyNameHeader')]/p")
   	private WebElement pageheader;

    
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
   	
   	@FindBy(xpath ="//*[contains(@id,'sam-call-modal')]//*[contains(@dtmname,'TFN Link') and contains(text(),'1-')]")
   	private WebElement CallSamTFN;
   	
   	@FindBy(xpath ="//*[contains(@id,'sam-call-modal')]//*[contains(@class,'modal-close')]")
   	private WebElement CallSamTFNClose;
   	
//   	String CallSam= "Call a Licensed Insurance Agent";
   	String CallSam1855= "1-855";
   	String CallSam1877= "1-877";
   	
   	@FindBy(xpath = "//*[contains(@class,'activeChatBtn')]")
   	private WebElement chatsam;
   	
	@FindBy(xpath = "//div[@class='sam']")
   	private WebElement samdiv;
   	
   	@FindBy(xpath = "//*[contains(@id,'sam-button--chat')]//*[contains(@class,'sam__button__text')]")
   	private WebElement chatsamtooltip;
   	
   	@FindBy(xpath ="//*[contains(@id,'inner-chat')]")
   	private WebElement chatSamPopup;

   	@FindBy(xpath ="//*[contains(@id,'sp-chat-frame')]")
   	private WebElement ProActivechatPopup;
   	
   	@FindBy(xpath ="//*[contains(@class,'commonFields')]//*[contains(@id,'first_name')]")
	private WebElement samChatFirstNameField;
	
	@FindBy(xpath ="//*[contains(@class,'commonFields')]//*[contains(@id,'last_name')]")
	private WebElement samChatLastNameField;
	
	@FindBy(xpath ="//*[contains(@class,'commonFields')]//*[contains(@id,'zip_code')]")
	private WebElement samChatZipField;
	
	@FindBy(xpath ="//*[contains(@class,'commonFields')]//*[contains(@id,'email') and contains(@name, 'email')]")
	private WebElement samChatEmailField;
	
	@FindBy(xpath ="//*[contains(@class,'commonFields')]//*[@class='option']//*[contains(@value,'Plan pricing ')]")
	private WebElement samChatOptions;
	
	//@FindBy(xpath ="//*[contains(@class,'prechat__action-buttons')]//*[contains(@class,'servicepatternBtn phone')]")
	@FindBy(xpath ="//*[contains(@id,'offline-form')]//*[contains(@class,'servicepatternBtn phone')]")
	private WebElement samChatConnect;
   	
	@FindBy(xpath ="//*[@id='agent-name']")
   	private WebElement ChatSamHead;
   	
   	//@FindBy(xpath ="//*[contains(@id,'sp-close-frame')]")
   	@FindBy(xpath = "//*[@id='sp-chat-frame']//div/div[@id='sp-close-frame']")
	private WebElement ChatSamTFNClose;
   	
   	@FindBy(id = "pharmacy-zip-search")
	private WebElement thpharmacyzipsearch;
   	
   	@FindBy(xpath = "//input/parent::form//button[text()='Go']")
	private WebElement thpharmacyGoButton;
   	
   	@FindBy(id = "zipcode")
	private WebElement zipCodeHealthPlans;
   	
   	@FindBy(xpath = "//form[@name='zipcodeform']//button[contains(@class,'zip-button')]")
	private WebElement GoBtnHealthPlans;
   	
   	@FindBy(xpath = "//input[@id='search-field']")
	private WebElement EnterSearch;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SubmitBtn;

	@FindBy(xpath = "//h1[contains(text(),'Search Results')]")
	private WebElement SearchResults;

	@FindBy(xpath = "//h2[@class='search-results-count']")
	private WebElement SearchResultsCount;
	
	@FindBy(xpath="//a[@dtmname='pagination:previous']")
	private WebElement PreviousBtn;
	
	
	@FindBy(xpath="//a[@dtmname='pagination:next']")
	private WebElement NextBtn;
	
	@FindBy(xpath="//button[@class='btn button-transparent clear-button']")
	private WebElement SecondaryClearBtn;
	
	@FindBy(xpath="//input[@id='secondarySearchInput']")
	private WebElement SecondarySearchInput;
	
	@FindBy(xpath="//button[@class='btn button-transparent clear-button']/following::button[1]")
	private WebElement SecondarySearchBtn;

	@FindBy(xpath = "//*[contains(@aria-label, 'Close') and contains(@id, 'sp-close-frame')]")
	private WebElement ChatCancelBtn;
   	
	@FindBy(xpath = "//button[@id='details-button' and contains(text(),'Advanced')]")
	private WebElement advancedBtn;

	@FindBy(xpath = "//a[@id='proceed-link']")
	private WebElement proceedLink;
	
	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	@FindBy(xpath="//a[contains(@href,'https://www.myuhcagent.com/')]")
	private WebElement RightRail_FindAnAgent; 

   	String ChatSamText= "Chat with a Licensed Insurance Agent";

	private static String TeamC_ACQUISITION_PAGE_URL = MRConstants.TeamC_UHC_URL;

	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private static String AARP_ACQISITION_PAGE_URL_NEW = MRConstants.AARP_URL_NEW;
	private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;
	private static String AARP_ACQISITION_PROD_PAGE_URL = MRConstants.AARP_URL_PROD;
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	private static String UMS_ACQISITION_PAGE_URL_NEW = MRConstants.UHC_URL_NEW;
	private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
	private static String UMS_ACQISITION_PROD_PAGE_URL = MRConstants.UHCM_URL_PROD;	

	private PageData globalFooter;
	
	public static boolean isHealthPlan = false;
	
	public String testSiteUrl;
	
	public String MicroAppSiteUrl;
	
	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public AcquisitionHomePage(WebDriver driver, String planType, boolean details, String site) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(site);
	}
	
	public AcquisitionHomePage(WebDriver driver, String site) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(site);
	}
	
	public AcquisitionHomePage(WebDriver driver, boolean alreadyOnSite) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(alreadyOnSite);
	}
	
	public AcquisitionHomePage(WebDriver driver, String siteOrPage,String testharnessurl) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(siteOrPage,testharnessurl);
	}

	public void openAndValidate(String site) {
		if ("BLayer".equalsIgnoreCase(site)|| site.equalsIgnoreCase("UHC")||site.equalsIgnoreCase("UMS")) {
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
			
		} else if("health-plans".equalsIgnoreCase(site)){
			isHealthPlan = true;
				CommonUtility.checkPageIsReadyNew(driver);
				System.out.println("Current page URL: "+driver.getCurrentUrl());
				testSiteUrl=driver.getCurrentUrl();
				checkModelPopup(driver,15);
				CommonUtility.waitForPageLoadNew(driver, zipCode, 45);
				try{
					if(proactiveChatExitBtn!=null)
					jsClickNew(proactiveChatExitBtn);
					
					else 
						Assert.fail("Please check booleanvalue");
					
				}catch(Exception e){
					System.out.println("Proactive chat popup not displayed");
				}
		}else if(site.equalsIgnoreCase("AARP")|| site.equalsIgnoreCase("Ulayer")||site.equalsIgnoreCase("AMP")){
			if (MRScenario.environment.equals("offline")) {
				start(AARP_ACQISITION_OFFLINE_PAGE_URL);
				testSiteUrl=AARP_ACQISITION_OFFLINE_PAGE_URL;
				checkModelPopup(driver,45);
			}
			else if (MRScenario.environment.equals("prod")) {
				start(AARP_ACQISITION_PROD_PAGE_URL);
				testSiteUrl=AARP_ACQISITION_PROD_PAGE_URL;
				checkModelPopup(driver,45);
			}else if (MRScenario.environment.contains("stage-0")) {
				startNew(AARP_ACQISITION_PAGE_URL_NEW);
				checkModelPopup(driver, 20);
			}
			else {
				start(AARP_ACQISITION_PAGE_URL);
				testSiteUrl=AARP_ACQISITION_PAGE_URL;
				checkForSecurityPage();
				checkModelPopup(driver,20);		
			}
		}
		
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		checkModelPopup(driver,15);
		CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 25);
		CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn,20); // do not change this to waitForPageLoadNew as we're not trying to fail the test if it isn't found
		try{
			if(proactiveChatExitBtn.isDisplayed())
				jsClickNew(proactiveChatExitBtn);
		}catch(Exception e){
			System.out.println("Proactive chat popup not displayed");
		}
	}
	
	public void openAndValidate(boolean alreadyOnSite) {
		if (alreadyOnSite) {
			
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		testSiteUrl=driver.getCurrentUrl();
		checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 15);
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
	
	public void openAndValidate(String siteOrPage, String testharnessurl) {
		String testharurl = "content/"+testharnessurl+"testharnesspage.html";
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
	
	
	
	public void openAndValidate(int visitorProfile) {
		if (visitorProfile>0) {
			
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		testSiteUrl=driver.getCurrentUrl();
		checkModelPopup(driver,15);
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
	
	public void openAndValidate() {
		
	}
	public String getTestSiteUrl() {
		return testSiteUrl;
	}
	
	public void checkForSecurityPage() {
		if(!MRScenario.domain.contains("uhc.com")) {
			try {
				if (advancedBtn.isDisplayed()) {
					advancedBtn.click();
					proceedLink.click();
				}
				} catch (Exception e) {
					System.out.println("Advanced button not displayed");
				}
		}
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
	
	public EnterZipCodePage enterZipCode() {
		return new EnterZipCodePage(driver);
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
		
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
			sendkeys(zipCodeField, zipcode);
			viewPlansButton.click();
	//	}
//			while(validate(overlayFilm, 10)) {/**wait*/}
//			CommonUtility.waitForElementToDisappear(driver, overlayFilm, 75);
			waitForPageLoadSafari();
			
//			CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
			validateNew(vppTop, 30);
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
		waitForPageLoadSafari();
		if(isMultiCounty.equalsIgnoreCase("YES")){
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			if (validate(countyModal))
				driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + county + "']")).click();
		}
		waitForPageLoadSafari();
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
//		footerAboutUsLink.click();
		jsClickNew(footerAboutUsLink);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
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
		//validateNew(aarpOrgLink);
		validateNew(medicareAdvantagePlansLink);
		validateNew(medicareSupplementInsurancePlansLink);
		validateNew(medicarePrescriptionDrug_PlansLink);
		validateNew(learnAboutMedicareLink);
		validateNew(viewAllDisclaimerInformationLink);

	}
	

	public ContactUsAARPPage contactUsFooterClick() {
		validateNew(footerContactUsLink);
		footerContactUsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("contact-us")) {
			return new ContactUsAARPPage(driver);
		}
		return null;
	}
	
	public SiteMapAARPPage siteMapFooterClick() {
		validateNew(footerSiteMapLink);
//		footerSiteMapLink.click();
		jsClickNew(footerSiteMapLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(siteMapHeader);
		if (driver.getCurrentUrl().contains("sitemap.html")){
			return new SiteMapAARPPage(driver);
		}
		return null;
	}
	
		
	
	public PrivacyPolicyAARPPage privacypolicyFooterClick() {
		validateNew(footerPrivacyPolicyLink);
//		footerPrivacyPolicyLink.click();
		jsClickNew(footerPrivacyPolicyLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(privacyHeader);
		if (driver.getCurrentUrl().contains("privacy-policy.html")) {
			return new PrivacyPolicyAARPPage(driver);
		}
		return null;
	}

	public TermsnConditionsAARPPage termsnconditionsFooterClick() {
		validate(footerTermsnConditionsLink);
//		footerTermsnConditionsLink.click();
		jsClickNew(footerTermsnConditionsLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("terms-of-use")) {
			return new TermsnConditionsAARPPage(driver);
		}
		return null;
	}
	
	public DisclaimersAARPPage disclaimersFooterClick() {
		validate(footerDisclaimersLink);
//		footerDisclaimersLink.click();
		jsClickNew(footerDisclaimersLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("disclaimer")) {
			return new DisclaimersAARPPage(driver);
		}
		return null;
	}
	
	public AgentsnBrokersAARPPage agentsnbrokersFooterClick() {
		validate(footerAgentsnBrokersLink);
//		footerAgentsnBrokersLink.click();
		jsClickNew(footerAgentsnBrokersLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(brokerHeader);
		if(driver.getCurrentUrl().contains("health-insurance-brokers")){
			return new AgentsnBrokersAARPPage(driver);
		}
		return null;
	}
	
	public AcquisitionHomePage homeFooterClick() {
		validateNew(footerHomeLink);
//		footerHomeLink.click();
		jsClickNew(footerHomeLink);
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
	
	public DrugCostEstimatorPage navigationDrugCostEstimator() {
     	navigateToMenuLinks(ShopForaplan, headerDrugCostEstimatorLink);

     	
     		return new DrugCostEstimatorPage(driver);
	 }
	
	public ShopforaplanAARPlayer Hoveronaplan() throws InterruptedException
    {             
           waitforElement(ShopForaplan);
     if (ShopForaplan.isDisplayed()) {
//            Actions action = new Actions(driver);
//            action.moveToElement(ShopForaplan).build().perform();
		    jsMouseOver(ShopForaplan);
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
//		shoppingCartIcon.click();
		jsClickNew(shoppingCartIcon);
		waitForPageLoadSafari();
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
	
	 public void validateCallSam() throws InterruptedException {
	        boolean present;
//	        driver.navigate().refresh();
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
	        	Assert.fail("@@@@@@@@@ No TFN widget @@@@@@@@@");
	      
		}
		
		public void validateCallSamContent() throws InterruptedException {
			
//			Actions action = new Actions(driver);
//			WebElement element = callsam;
//			action.moveToElement(element).perform();
			waitforElementNew(callsamtooltip,30);
			String toolTipText = callsamtooltip.getText();
			System.out.println("====================================================================");
			System.out.println(toolTipText);
			System.out.println("====================================================================");
			
	        if (toolTipText.contains(CallSam1877)) {
	          System.out.println("Call sticky action menu roll out and contain the text: "+ toolTipText);
	          
	        }
	        else if (toolTipText.contains(CallSam1855))	{
	        	System.out.println("Call sticky action menu roll out and contain the text"+ toolTipText);
	        }
	        		
	        else
	        	Assert.fail("No Call sticky action menu didn't roll out and doesn't contain the text 1-877");
	       
		}
		
		public AcquisitionHomePage  validateCallpopup() throws InterruptedException {
			int retry = 1;
			do	{
				driver.navigate().refresh();
				CommonUtility.checkPageIsReady(driver);
				CheckiPerseptions();
				validate(callsamtooltip);
				jsClickNew(callsam);
				System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
				driver.switchTo().activeElement();
//				System.out.println(CallSamTFN.getText());
//				CallSamTFNClose.click();
//				validateNew(callsam);
				System.out.println("Call Sam checking for "+retry+" times");
				retry++;
			} while (!validate(CallSamTFN) && (retry<6));
			
			System.out.println(CallSamTFN.getText());
//			CallSamTFNClose.click();
			jsClickNew(CallSamTFNClose);
			validateNew(callsam);		
			return null;
			
		/*	validate(callsamtooltip);
			CheckiPerseptions();
			callsam.click();
			System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
			driver.switchTo().activeElement();
			System.out.println(CallSamTFN.getText());
			CallSamTFNClose.click();
			validateNew(callsam);		
			return null;*/
		}
		
		public void validateChatSam() throws InterruptedException {
	        boolean present;
	        try {
	        validateNew(chatsam);
	        present = true;
	        } catch (NoSuchElementException e) {
	        present = false;
	        }
	        if (present) {
	          System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
	          
	        }
	        else
	        	Assert.fail("@@@@@@@@@ No TFN widget @@@@@@@@@");
	       
		}
		
		/*public void validateChatSamContent() throws InterruptedException {
			
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
	        	Assert.fail("No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
		
		}*/
		
		public void validateChatSamContent() throws InterruptedException {

			Actions action = new Actions(driver);
			WebElement element = chatsam;
			action.moveToElement(element).perform();
			String ChattoolTipText = chatsamtooltip.getText();
			System.out.println("====================================================================");
			System.out.println(ChattoolTipText);
			System.out.println("====================================================================");

			if (ChatSamText.equalsIgnoreCase(ChattoolTipText)) {
				System.out.println(
						"Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent");
				// return new AcquisitionHomePage(driver);
			} else
				Assert.fail(
						"No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
			// return null;
		}
		
		
		/*public AcquisitionHomePage  validateChatpopup() throws InterruptedException {
			//CommonUtility.checkPageIsReady(driver);
			scrollToView(chatsam);
			chatsam.click();
			jsClickNew(chatsam);
			System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");	
//			chatsamtooltip.click();
			driver.switchTo().activeElement();
//			System.out.println(ChatSamHead.getText());
//			ChatSamTFNClose.click();
			jsClickNew(ChatSamTFNClose);
			validateNew(chatsam);		
			return null;
		}*/
		
		public void validateChatpopup() throws InterruptedException {
			// CommonUtility.checkPageIsReady(driver);
			validateNew(chatsam);
			System.out.println(chatsam.getText());
			jsClickNew(chatsam);
			System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");
			//validateandcloseChat();
			/*
			 * chatsamtooltip.click(); driver.switchTo().activeElement();
			 * System.out.println(ChatSamHead.getText()); ChatSamTFNClose.click();
			 * validateNew(chatsam);
			 */
			// return null;
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
		
		public GetStartedPage navigateToDCERedesignFromHome() throws InterruptedException {
			validateNew(getStarted);
//			getStarted.click();
			jsClickNew(getStarted);
			CommonUtility.checkPageIsReadyNew(driver);
			if (validateNew(AddMyDrugsBtn))
				return new GetStartedPage(driver);
			return null;
		}
		
		public void navigateToMedEdPresDrugPage()
		{
			waitforElement(lnkLearnAboutMedicare);
			if (lnkLearnAboutMedicare.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(lnkLearnAboutMedicare);
				actions.build().perform();
				System.out.println("Hover over Learn about Medicare completed");
		    }
			WebElement PresProvidersBenefitsLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-benefits')]"));
			jsClickNew(PresProvidersBenefitsLink);
		}

		public GetStartedPage clickDCERedesignLinkonMedEdPage() {
			WebElement DCELink = driver.findElement(By.xpath("//a[contains(@href,'drug-cost-estimator') and contains(@class,'contentRow__mededcontainer')]"));
			validateNew(DCELink);
			jsClickNew(DCELink);
			if (validateNew(AddMyDrugsBtn))
				return new GetStartedPage(driver);
			return null;
		}
		
		public void navigateToShopPDPpage()
		{
			waitforElement(ShopForaplan);
			if (ShopForaplan.isDisplayed()) {
//				Actions actions = new Actions(driver);
//				actions.moveToElement(ShopForaplan);
//				actions.build().perform();
				jsMouseOver(ShopForaplan);
				System.out.println("Hover over Shop for a Plan completed");
		    }
			WebElement PDPplansLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'prescription-drug-plans.html')]"));
			jsClickNew(PDPplansLink);
			waitForPageLoadSafari();
		}
		
		public GetStartedPage clickDCERedesignLinkonShopPDPpage() {
			CommonUtility.checkPageIsReadyNew(driver);
			WebElement DCELink = driver.findElement(By.xpath("//a[contains(@href,'drug-cost-estimator') and contains(text(), 'Prescription Drug Costs')]"));
			validateNew(DCELink, 10);
			jsClickNew(DCELink);
			waitForPageLoadSafari();
			if (validateNew(AddMyDrugsBtn))
				return new GetStartedPage(driver);
			return null;
		}

		public GetStartedPage navigateToDCERedesignFromSubNav() {
	     	navigateToMenuLinks(ShopForaplan, headerDrugCostEstimatorLink);

			if (validateNew(AddMyDrugsBtn))
				return new GetStartedPage(driver);
			return null;
			
		 }
		
		public void navigateToPage(String page) {
			String pageURL = driver.getCurrentUrl()+page;
			System.out.println("==pageURL=="+pageURL);
			driver.navigate().to(pageURL);
			
			
		}
		
		public void verifyChatpopup() throws InterruptedException {
			//CommonUtility.checkPageIsReady(driver);
			chatsam.click();
			System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");	
			
		}
		
		public void validateChatpopupconnect() throws InterruptedException {

			try {
			driver.switchTo().frame("sp-chat-iframe");
			validateNew(samChatFirstNameField);				
			samChatFirstNameField.sendKeys("tester");				
			
			validateNew(samChatLastNameField);
			samChatLastNameField.sendKeys("test");		
			
			validateNew(samChatZipField);
			samChatZipField.sendKeys("90210");
		
			validateNew(samChatEmailField);
			samChatEmailField.sendKeys("test123@test.com");
			
			 validateNew(samChatOptions); 
			 samChatOptions.click();
			 
			 driver.switchTo().defaultContent();
			System.out.println("Page Title---"+driver.getTitle());
			
			}catch(Exception e) {
			
			System.out.println("Failed Due To-------"+e.getMessage());
			}


	}
		
		public boolean validateChat() throws InterruptedException {
			boolean present = false;
			try {
				//validateNew(chatsam);
				present=validateNew(samdiv);
				if(present) {
					List<WebElement> list = driver.findElements(By.xpath("//div[@class='sam']/button"));
					String chatbtnid = "sam-button--chat";
					for(WebElement element : list ) {
						if(element.getAttribute("id").equalsIgnoreCase(chatbtnid)) {
							present = false;
							break;
						}
					}
				}
				
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			  	return present;
		}
		
		public void validateHeaderLinks() {
			validateNew(headerSignInLink);
			validateNew(headerRegisterLink);
			if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
				validateNew(visitAARPLink);
				validateNew(AARPlogo);
			}
			else
			{
				System.out.println("UHC Medicare solutions site loaded");
			}
			validateNew(visitorprofileicon);
		}
		
		public void signInheader() {
			jsClickNew(headerSignInLink);
			validateNew(signIn);
			if (driver.getCurrentUrl().contains("medicare.uhc.com")) {
				Assert.assertTrue(true);
				System.out.println("Signin page is loaded");
				driver.navigate().back();
				CommonUtility.waitForPageLoad(driver, healthPlansZipcode, 30);
				System.out.println("Home Page is loaded");
			} else {
				Assert.fail("Unable to navigate to signin page");
			}

		}
		
		public void validateLogo() {
			// TODO Auto-generated method stub
			if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
				validateNew(AARPlogo);
				WebElement AARPLogo = driver.findElement(By.xpath("//a[contains(@id, 'aarpSVGLogo')]"));
				WebElement UHCLogo = driver.findElement(By.xpath("//a[contains(@id, 'uhcSVGLogo')]"));
				if (AARPLogo.isDisplayed() && AARPLogo.isEnabled() && !UHCLogo.isDisplayed()) {
					Assert.assertTrue(true);
					System.out.println("Correct AARP Logo is Displayed");
				} else {
					Assert.fail("AARP logo is not dispalyed for Ulayer");
				}
			}
			else {
				WebElement AARPLogo = driver.findElement(By.xpath("//a[contains(@id, 'aarpSVGLogo')]"));
				WebElement UHCLogo = driver.findElement(By.xpath("//a[contains(@id, 'uhcSVGLogo')]"));
				if (UHCLogo.isDisplayed() && UHCLogo.isEnabled() && !AARPLogo.isDisplayed()) {
					Assert.assertTrue(true);
					System.out.println("Correct UHC Logo is Displayed");
				} else {
					Assert.fail("UHC logo is not dispalyed for Ulayer");
				}
				
			}
		}
		
		private void CheckPageLoad() {
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
			checkModelPopup(driver, 30);

		}

		public void CheckiPerseptions() {
			CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn, 20); // do not change this to waitForPageLoadNew as
																				// we're not trying to fail the test if it
																				// isn't found
			try {
				if (proactiveChatExitBtn.isDisplayed())
					jsClickNew(proactiveChatExitBtn);
			} catch (Exception e) {
				System.out.println("Proactive chat popup not displayed");
			}
		}

		
		public void headerRegisterLink() {
			if (headerRegisterLink.isDisplayed() && headerRegisterLink.isEnabled()) {
				Assert.assertTrue(true);
				System.out.println("Register link is displayed on home page");
			} else {
				Assert.fail("Register link is not found/ displayed on home page");
			}

		}
		
		public void validatevisitorprofile() {
			if (visitorprofileicon.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(visitorprofileicon).perform();
				System.out.println("Hover over visitor profile completed");
			}
			WebElement CreateProfile = driver.findElement(By.xpath("//a[contains(text(), 'Create Profile')]"));
			WebElement VPSignIn = driver.findElement(
					By.xpath("//a[contains(text(), 'Sign In') and not(contains(@aria-labelledby ,'VPSignIn'))]"));
			validateNew(CreateProfile);
			validateNew(VPSignIn);
			if (CreateProfile.isEnabled() && VPSignIn.isEnabled()) {
				Assert.assertTrue(true);
				System.out.println("Visitor Profile elements are present on home page");
			} else {
				Assert.fail("Visitor Profile elements are not present on home page");
			}
			visitorprofileicon.click();
			WebElement GuestProfile = driver.findElement(By.xpath("//*[contains(text(), 'Your Guest Profile')]"));
			CheckPageLoad();
			waitForPageLoadSafari();
			CheckiPerseptions();
			CommonUtility.waitForPageLoadNew(driver, GuestProfile, 30);
			if (driver.getCurrentUrl().contains("profile/guest")) {
				Assert.assertTrue(true);
				System.out.println("Visitor Profile Page opens successsfully");
			} else {
				Assert.fail("Visitor Profile page is not opening up");
			}
			driver.navigate().back();
			CheckPageLoad();
			waitForPageLoadSafari();
			CheckiPerseptions();

			CommonUtility.waitForPageLoadNew(driver, findPlansButton, 30);
		}
		
		public void navigateToPath(String path) {

			String CurrentURL = driver.getCurrentUrl();
			System.out.println("Current URL : " + CurrentURL);

			String NavigateToURL = CurrentURL + path;
			System.out.println("Navigating to URL : " + NavigateToURL);
			driver.navigate().to(NavigateToURL);
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 30);
			System.out.println("Page Title : " + (driver.findElement(By.xpath("//title")).getText()));

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
			if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
				validateNew(aarpOrgLink);
			}
			else
			{
				System.out.println("UHC Medicare solutions site loaded");
			}
			validateNew(medicareAdvantagePlansLink);
			validateNew(medicareSupplementInsurancePlansLink);
			validateNew(medicarePrescriptionDrug_PlansLink);
			validateNew(medicareSpecialNeedsPlansLink);
			validateNew(learnAboutMedicareLink);
		}
		
		public void validateTFNelement(String tfnXpath) {
			WebElement TFNelement = driver.findElement(By.xpath(tfnXpath));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			jse.executeScript("window.scrollBy(0,-500)");
			validateNew(TFNelement, 45);
			if (validateNew(TFNelement) && TFNelement.isDisplayed()) {
				System.out.println("TFN is Displayed on Page : " + TFNelement.getText());
			} else {
				Assert.fail("TFN elemnet is not found / displayed on page : " + tfnXpath);
			}
		}
		
		public void validateSubNavShopPlanLinks() {
			waitForPageLoadSafari();
			CheckPageLoad();
			CheckiPerseptions();

			waitforElement(ShopForaplan);
			if (ShopForaplan.isDisplayed()) {
//				Actions actions = new Actions(driver);
//				actions.moveToElement(ShopForaplan);
//				actions.build().perform();
				jsMouseOver(ShopForaplan);
				System.out.println("Hover over Shop for a Plan completed");

//					waitforElementNew(driver.findElement(By.xpath("//input[@id='nav-zipcode']")));
//					System.out.println("Submit button is displayed");
			}
			WebElement ZipCodeTxt = driver.findElement(By.xpath("//input[@id='nav-zipcode']"));
			WebElement FindPlansBtn = driver.findElement(By.xpath("//button[@dtmid='acq_top_nav']"));
			WebElement RequestMoreInfoLink = driver
					.findElement(By.xpath("//a[@dtmname='Top Nav:Our Plans:Request More Help']"));
			WebElement EnrollLink = driver.findElement(By.xpath("//a[contains(@href,'enroll.html')]"));
			WebElement ShopLink = driver.findElement(By.xpath("//a[contains(@href,'shop.html')]"));
			WebElement ResourceLink = driver.findElement(By.xpath("//a[contains(@href,'resources.html')]"));

			WebElement MAplansLink = driver.findElement(By.xpath(
					"//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'medicare-advantage-plans.html')]"));
			List<WebElement> MedSuppPlansLink = driver.findElements(By.xpath(
					"//*[contains(@class, 'nav-col nav-col-1')]//*[contains(@href,'medicare-supplement-plans.html') or contains(@href,'medicare-supplement-plans-classic.html')]"));
			WebElement PDPplansLink = driver.findElement(By.xpath(
					"//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'prescription-drug-plans.html')]"));
			WebElement SNPplansLink = driver.findElement(
					By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'special-needs-plans.html')]"));

			WebElement PlanSelectorLink = driver.findElement(By.xpath(
					"//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'plan-recommendation-engine.html')]"));
			WebElement DCELink = driver.findElement(
					By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'drug-cost-estimator')]"));
			WebElement PharmacySearchLink = driver.findElement(
					By.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'aarp-pharmacy.html')]"));
			WebElement ProviderSearchLink = driver.findElement(By
					.xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@onclick,'loadCachedProviderSearch')]"));

			validateNew(ZipCodeTxt);
			validateNew(FindPlansBtn);
			validateNew(RequestMoreInfoLink);

			validateNew(EnrollLink);
			validateNew(ShopLink);
			validateNew(ResourceLink);

			validateNew(MAplansLink);
			Assert.assertTrue(MedSuppPlansLink.size() > 0, "No Med Sup link found in the header navigation");
			validateNew(PDPplansLink);
			validateNew(SNPplansLink);

			validateNew(PlanSelectorLink);
			validateNew(DCELink);
			validateNew(PharmacySearchLink);
			validateNew(ProviderSearchLink);

			if (ZipCodeTxt.isDisplayed() && FindPlansBtn.isDisplayed() && RequestMoreInfoLink.isDisplayed()
					&& EnrollLink.isDisplayed() && ShopLink.isDisplayed() && ResourceLink.isDisplayed()
					&& MAplansLink.isDisplayed() && PDPplansLink.isDisplayed() && SNPplansLink.isDisplayed()
					&& PlanSelectorLink.isDisplayed() && DCELink.isDisplayed() && PharmacySearchLink.isDisplayed()
					&& ProviderSearchLink.isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("Sub Nav - Shop for a Plan - All links and element displayed on Page : ");
//				Actions actions = new Actions(driver);
//				actions.moveToElement(AARPlogo);
//				actions.build().perform();
				jsMouseOver(AARPlogo);
			} else {
				Assert.fail("Sub Nav - Shop for a Plan - All links and element not found / displayed on page : ");
			}
		}
		
		public void validateSubNavMedEdLinks() {
			waitForPageLoadSafari();
			CheckPageLoad();
			CheckiPerseptions();

			waitforElement(lnkLearnAboutMedicare);
			if (lnkLearnAboutMedicare.isDisplayed()) {
//				Actions actions = new Actions(driver);
//				actions.moveToElement(lnkLearnAboutMedicare);
//				actions.build().perform();
				jsMouseOver(lnkLearnAboutMedicare);
				System.out.println("Hover over Learn about Medicare completed");
			}
			WebElement EligibilityTxt = driver.findElement(
					By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-eligibility')]"));
			WebElement ChoicesBtn = driver.findElement(By.xpath(
					"//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-parts-and-medigap-plans')]"));
			WebElement PresProvidersBenefitsLink = driver.findElement(
					By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-benefits')]"));
			WebElement CostbasicsLink = driver.findElement(
					By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-costs')]"));

			WebElement MAplansLink = driver.findElement(
					By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-advantage-plans')]"));
			WebElement MedSuppPlansLink = driver.findElement(By.xpath(
					"//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-supplement-plans.html')]"));
			WebElement PDPplansLink = driver.findElement(
					By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-part-d')]"));

			WebElement EnrollmentBasicsLink = driver.findElement(By.xpath(
					"//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'enrollment-and-changing-plans')]"));
//				WebElement FAQLink = driver.findElement(By.xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-faq')]"));

			validateNew(EligibilityTxt);
			validateNew(ChoicesBtn);
			validateNew(PresProvidersBenefitsLink);
			validateNew(CostbasicsLink);

			validateNew(MAplansLink);
			validateNew(MedSuppPlansLink);
			validateNew(PDPplansLink);

			validateNew(EnrollmentBasicsLink);

			if (EligibilityTxt.isDisplayed() && ChoicesBtn.isDisplayed() && PresProvidersBenefitsLink.isDisplayed()
					&& CostbasicsLink.isDisplayed() && MAplansLink.isDisplayed() && MedSuppPlansLink.isDisplayed()
					&& PDPplansLink.isDisplayed() && EnrollmentBasicsLink.isDisplayed()) {
				// && FAQLink.isDisplayed()
				Assert.assertTrue(true);
				System.out.println("Sub Nav - Learn about Medicare - All links and element displayed on Page");
//				Actions actions = new Actions(driver);
//				actions.moveToElement(AARPlogo);
//				actions.build().perform();
				jsMouseOver(AARPlogo);
			} else {
				Assert.fail("Sub Nav - Learn about Medicare - All links and element not found / displayed on page");
			}
		}
		
		public void validateStateDropDown() {
			validateNew(stateDropDown);
			selectFromDropDownByValue(stateDropDown, "California");
			String StateSessionStorage = ReturnDriverStorage(driver, "sessionStorage", "ucp_geotrackingState");
			System.out.println("State selected : California");
			System.out.println("State GeoSessionStorage value : " + StateSessionStorage);
			Assert.assertTrue(StateSessionStorage.equalsIgnoreCase("CA"), "Geolocation State validation Failed ");
		}
		
		public void validateDisclaimer() {
			validateNew(disclaimerInformation);
//			disclaimerInformation.click();
			jsClickNew(disclaimerInformation);
			validateNew(backToTop_Disclaimer);
		}
		
		public void validateVisitAarpOrglink() {
			if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
				validateNew(visitAARPFooterLink);
				String hRef = visitAARPFooterLink.getAttribute("href");
				System.out.println("href for Visit AARP.org link : " + hRef);
				Assert.assertTrue(hRef.contains("www.aarp.org"), "Incorrect href for Visit AARP.org : " + hRef);
				visitAARPFooterLink.isEnabled();
			}
			else
			{
				System.out.println("UHC Medicare solutions site loaded");
			}
			
		}
		
		public void backToToplink() {
			validateNew(backToTop);
//			backToTop.click();
			jsClickNew(backToTop);
		}
	
		public boolean openPRE() {
			boolean offline_prod = false;
			String browser = MRScenario.browsername;
			if (!(MRScenario.getProps() == null)) {// If running from local
				if (MRScenario.environment.equalsIgnoreCase("digital-uatv2-aarp")) {
					startNewPRE(AARP_ACQISITION_PAGE_URL.replace("digital-uatv2-aarp", "digital-uatv2")
							.replace(".com/", ".com/plan-recommendation-engine.html").replace("www.", ""), browser);
				} else if (MRScenario.environment.equalsIgnoreCase("digital-uatv2")) {
					startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com/", ".com/plan-recommendation-engine.html")
							.replace("www.", ""), browser);
				} else if (MRScenario.environment.equalsIgnoreCase("offline-stage-aarp")) {
					startNewPRE(AARP_ACQISITION_PAGE_URL.replace("offline-stage-aarp", "offline-stage").replace(".com/",
							".com/plan-recommendation-engine.html"), browser);
				} else if (MRScenario.environment.equalsIgnoreCase("offline-stage")) {
					startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com/", ".com/plan-recommendation-engine.html"), browser);
				} else if (MRScenario.environment.equalsIgnoreCase("stage-aarp")) {
					startNewPRE(AARP_ACQISITION_PAGE_URL.replace("stage-aarp", "stage").replace(".com/",
							".com/plan-recommendation-engine.html"), browser);
				} else if (MRScenario.environment.equalsIgnoreCase("stage")) {
						startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com/", ".com/plan-recommendation-engine.html"), browser);
				} else if (MRScenario.environment.equalsIgnoreCase("offline-prod-aarp")) {
					startNewPRE(AARP_ACQISITION_OFFLINE_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html"),
							browser);
					offline_prod = true;
				} else if (MRScenario.environment.equalsIgnoreCase("offline-prod")) {
					startNewPRE(UMS_ACQISITION_OFFLINE_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html"),
							browser);
					offline_prod = true;
				} else if (MRScenario.environment.equalsIgnoreCase("prod-aarp")) {
					startNewPRE(AARP_ACQISITION_PROD_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html"),
							browser);
					offline_prod = true;
				} else if (MRScenario.environment.equalsIgnoreCase("prod")) {
					startNewPRE(UMS_ACQISITION_PROD_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html"),
							browser);
					offline_prod = true;
				}
			} else { // For jenkins job
				String jenkinsRunnerFiles = MRScenario.runnerFiles;
				if (MRScenario.environment.equalsIgnoreCase("digital-uatv2")
						|| MRScenario.environment.equalsIgnoreCase("stage")
						|| MRScenario.environment.equalsIgnoreCase("offline-stage"))
				{
					for (String rname : jenkinsRunnerFiles.split(",")) {
						if ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") || rname.contains("PRE"))
								&& rname.toUpperCase().contains("ULAYER")) {
							if (MRScenario.environment.equalsIgnoreCase("digital-uatv2"))
								startNewPRE(AARP_ACQISITION_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html")
										.replace("www.", ""), browser);
							else
								startNewPRE(
										AARP_ACQISITION_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html"),
										browser);
						}
						if ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") || rname.contains("PRE"))
								&& rname.toUpperCase().contains("BLAYER")) {
							if (MRScenario.environment.equalsIgnoreCase("digital-uatv2"))
								startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html")
										.replace("www.", ""), browser);
							else
								startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html"),
										browser);
						}

					}
				}
				if (MRScenario.environment.equalsIgnoreCase("offline")) {
					for (String rname : jenkinsRunnerFiles.split(",")) {
						if ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") || rname.contains("PRE"))
								&& rname.toUpperCase().contains("ULAYER"))
							startNewPRE(AARP_ACQISITION_OFFLINE_PAGE_URL.replace(".com",
									".com/plan-recommendation-engine.html"), browser);
						if ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") || rname.contains("PRE"))
								&& rname.toUpperCase().contains("BLAYER"))
							startNewPRE(
									UMS_ACQISITION_OFFLINE_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html"),
									browser);
					}
					offline_prod = true;
				}
				if (MRScenario.environment.equalsIgnoreCase("prod")) {
					for (String rname : jenkinsRunnerFiles.split(",")) {
						if ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") || rname.contains("PRE"))
								&& rname.toUpperCase().contains("ULAYER"))
							startNewPRE(
									AARP_ACQISITION_PROD_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html"),
									browser);
						if ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") || rname.contains("PRE"))
								&& rname.toUpperCase().contains("BLAYER"))
							startNewPRE(
									UMS_ACQISITION_PROD_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html"),
									browser);
					}
					offline_prod = true;
				}
			}

			System.out.println("Current page URL: " + driver.getCurrentUrl());
			return offline_prod;
		}
		
		public PlanDocsPage navigateToPlanDocsFromHome() {
	     	navigateToMenuLinks(ShopForaplan, menuShop);
	     	
	     	//driver.findElement(By.xpath("//*[@id='globalContentIdForSkipLink']/div/table/tbody/tr[2]/td/div[1]/div/div/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div/a")).click();
			jsClickNew(driver.findElement(By.xpath("//*[@id='globalContentIdForSkipLink']/div/table/tbody/tr[2]/td/div[1]/div/div/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div/a")));
	     	    	
	     		return new PlanDocsPage(driver);
		 }

		
		
		
		public VPPPlanSummaryPage searchPlansWithOutCountyShop(String zipcode) throws InterruptedException {

			CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
			sendkeys(zipCodeShopField, zipcode);
			viewShopPlansButton.click();
			// }
			CommonUtility.waitForPageLoadNew(driver, zipcodeChangeLink, 30);
			if (driver.getCurrentUrl().contains("health-plans")) {
				return new VPPPlanSummaryPage(driver);
			} else
				return null;
		}
			public VPPPlanSummaryPage searchPlansShop(String zipcode, String countyName) {
			CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
			sendkeys(zipCodeShopField, zipcode);
			viewShopPlansButton.click();
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			if (validate(countyModal))
				driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
			CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				return new VPPPlanSummaryPage(driver);
			}
			return null;
		}
			
			
			public VPPPlanSummaryPage searchPlansWithOutCountyShopEnroll(String zipcode) throws InterruptedException {

				CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
				sendkeys(zipCodeShopField, zipcode);
				ShopEnrollButton.click();
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
				ShopEnrollButton.click();
				CommonUtility.waitForPageLoad(driver, countyModal, 45);
				if (validate(countyModal))
					driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
				CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
				if (driver.getCurrentUrl().contains("plan-summary")) {
					return new VPPPlanSummaryPage(driver);
				}
				return null;
			}	
				
				
			
				/*	
				public RequestHelpAndInformationPage clickonFindanAgentlink(){
					WebElement clickonFindanAgentlink = null;
					validateNew(RightRail_FindAnAgent);
					CommonUtility.waitForPageLoadNew(driver, RightRail_FindAnAgent, 30);
					String parentWindow = driver.getWindowHandle();
					RightRail_FindAnAgent.click();
					sleepBySec(3);
					Set<String> tabs_windows = driver.getWindowHandles();
					Iterator<String> itr = tabs_windows.iterator();
					while(itr.hasNext()) {
						String window = itr.next();
						if(!parentWindow.equals(window)) {
							driver.switchTo().window(window);
						}
					}
					
					CommonUtility.checkPageIsReadyNew(driver);
					if (driver.getCurrentUrl().contains("myuhcagent")) {
						System.out.println("myuhcagent Page is displayed");
				
					
					return new RequestHelpAndInformationPage(driver);        				
				}
				return null;
}
				public void sleepBySec(int sec) {
					try {
						Thread.sleep(sec*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}
				}*/			
				
				
				public void clickonFindanAgentlink(String ExpectedUHCAgentURL ) {
					
					validateNew(RightRail_FindAnAgent);
					CommonUtility.waitForPageLoadNew(driver, RightRail_FindAnAgent, 30);
					String parentWindow = driver.getWindowHandle();
					RightRail_FindAnAgent.click();
					sleepBySec(3);
					Set<String> tabs_windows = driver.getWindowHandles();
					Iterator<String> itr = tabs_windows.iterator();
					while(itr.hasNext()) {
						String window = itr.next();
						if(!parentWindow.equals(window)) {
							driver.switchTo().window(window);
						}
					}
					
					CommonUtility.checkPageIsReadyNew(driver);
					String CurrentUHCAgentURL = driver.getCurrentUrl();
					String ActualCurrentUHCAgentURL=CurrentUHCAgentURL.substring(0, 27).trim();
					System.out.println("myuhcagent Page is displayed : "+ActualCurrentUHCAgentURL);
					System.out.println("Expected myuhcagent URL: "+ExpectedUHCAgentURL);
					System.out.println("Actual myuhcagent URL: "+ActualCurrentUHCAgentURL);

					if(ExpectedUHCAgentURL.equalsIgnoreCase(ActualCurrentUHCAgentURL)) {
						System.out.println("****************myuhcagent Page is displayed  ***************");

						Assert.assertTrue(true);
					}
					else {
						Assert.fail("****************myuhcagent Page is not loaded ***************");
					}
				
					
					
				}			
				public void sleepBySec(int sec) {
					try {
						Thread.sleep(sec*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}		

				}
				
				public boolean validateChatNonHours() throws InterruptedException {
					
					boolean present = true;
					try {
							WebElement chat = driver.findElement(By.xpath("//button[contains(@id,'sam-button--chat')]"));
							if(chat.getAttribute("class").contains("activeChatBtn")){
								present = false;
							}
							
					} catch (NoSuchElementException e) {
						e.printStackTrace();
					}
					return present;
				}
				
                 public boolean validateChatNonHours1() throws InterruptedException {
					
					boolean present = true;
					try {
				        	Calendar cal = Calendar.getInstance(); 
				        	Date date = cal.getTime();
				        	@SuppressWarnings("deprecation")
							int hours = date.getHours();
				        	if(hours > 7  && hours < 19) {
							WebElement chat = driver.findElement(By.xpath("//button[contains(@id,'sam-button--chat')]"));
							present = chat.isDisplayed();
				        	}
							
					} catch (NoSuchElementException e) {
						e.printStackTrace();
					}
					return present;
				}
				

				public void validateChatIcon() throws InterruptedException {
					boolean present;
					CommonUtility.waitForPageLoadNewForClick(driver, chatsam, 60);
					if (chatsam.isDisplayed()) {
						System.out.println("@@@@ Chat Icon window opened successfully@@@");
						jsClickNew(chatsam);
						Thread.sleep(5000);
						// driver.switchTo().frame("sp-chat-iframe");
						validate(ChatCancelBtn, 10);
						present = true;
						CommonUtility.waitForPageLoadNewForClick(driver, ChatCancelBtn, 30);
						jsClickNew(ChatCancelBtn);
						// ChatCancelBtn.click();
						// driver.switchTo().defaultContent();
						CommonUtility.waitForPageLoadNewForClick(driver, chatsam, 60);
						System.out.println("@@@@ Chat Icon is displayed Successfully@@@");
					}

					else {
						System.out.println("@@@@@@@@@ No Chat Window  @@@@@@@@@");
						// assertTrue("Chat Icon not displayed on " + pageName + "", false);
					}
				}
			
	
		
		public void enterSearchtextvalue(String inputvalue) {
			// driver.switchTo().defaultContent();
			CommonUtility.waitForPageLoad(driver, EnterSearch, 60);
			EnterSearch.sendKeys(inputvalue);
			CommonUtility.waitForPageLoadNewForClick(driver, SubmitBtn, 60);
			jsClickNew(SubmitBtn);
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoadNew(driver, SearchResults, 60);
			checkModelPopup(driver, 20);
			

		}
		public void validateFifteenResults() {
			System.out.println("@@@@@Inside fifteen results validation@@@");
			int sizeofResults = driver.findElements(By.xpath("//div[@class='list-heading']")).size();
			System.out.println("number of results displayed on UI" + sizeofResults);
			if (sizeofResults <= 15) {
				System.out.println("@@@Inside results displayed less than or equal to 15");
				Assert.assertTrue(true);
			} else {
				System.out.println("@@@Inside results displayed Incorrectly");
				Assert.assertTrue(false);
			}
			
		}
		
		public void validatePaginationofSearchResults() {
			System.out.println("Inside the pagination validation@@@@");
			int sizeofpages = driver.findElements(By.xpath("//*[@class='pagination']/li/a")).size();
			System.out.println("size of pages" + sizeofpages);
			for (int i = 2; i < sizeofpages; i++) {
				System.out.println("@@Inside pagination click@@@");
				threadsleep(5);
				driver.findElement(By.xpath("(//*[@class='pagination']/li/a)[" + i + "]")).click();
				CommonUtility.waitForPageLoadNew(driver, SearchResultsCount, 30);
				this.validateFifteenResults();
				threadsleep(5);
				int sizeofNext = driver.findElements(By.xpath("//a[@dtmname='pagination:next']")).size();
				System.out.println("sizeofNext" + sizeofNext);
				if (!NextBtn.isDisplayed()) {
					System.out.println("@@@@Inside next button disappear loop");
					CommonUtility.waitForPageLoadNewForClick(driver, PreviousBtn, 30);
					PreviousBtn.click();
					this.validateFifteenResults();
					break;
				}

			}
			// driver.navigate().back();

		}
		public void enterSecondarySearchValue(String str) {
			System.out.println("@@@inside secondary search validation method@@@");
			CommonUtility.waitForPageLoadNewForClick(driver, SecondaryClearBtn, 30);
			SecondaryClearBtn.click();
			CommonUtility.waitForPageLoad(driver, SecondarySearchInput, 30);
			SecondarySearchInput.sendKeys(str);
			CommonUtility.waitForPageLoadNewForClick(driver, SecondarySearchBtn, 30);
			SecondarySearchBtn.click();
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoadNew(driver, SearchResults, 60);

		}
		
		public void insertValueIntoSecondSearchBox(String inputValue) {
			System.out.println("Click on clear button");
			driver.findElement(By.className("clear-button")).click();
			System.out.println("Insert value into secondary searchbox");
			driver.findElement(By.id("secondarySearchInput")).sendKeys(inputValue);
			driver.findElement(By.id("secondarySearchInput")).sendKeys(Keys.ENTER);
		}
		
		public void validateErrorMsg(String inputValue, String newSearchValue) {
			switch (inputValue) {
			case "Empty":
				System.out.println("Varify Error message for " + inputValue + "");
				String errMessage = driver.findElement(By.id("searchErrorMessage")).getText();
				assertTrue(errMessage.contains("Your search box was empty. Please enter some text in the search box"));
				break;
			case "InvalidCharacter":
				System.out.println("Validating invalid character message");
				String invalidSearch = driver.findElement(By.xpath("//div[@class='invalid-search']")).getText().replaceAll("\\s+", " ");
				System.out.println("invalidSearch : >>>>> " + invalidSearch);
				assertTrue(invalidSearch.contains("Your search - " + newSearchValue + " - did not match any documents."));
				// assertTrue(invalidSearch.contains("No pages were found containing
				// "+newSearchValue+"."));
				break;
			case "Numbers":
				System.out.println("Numbers");
				break;
			}
		}


		@FindBy(xpath="(//*[contains(text(),'Sign in')])[1]")
		private WebElement memberSignInPage;

		@FindBy(xpath="//a[contains(@href,'https://www.aarpmedicareplans.com/health-plans.html?WT.mc_id=8009508')]")
		private WebElement ViewMedicareplanlinks;

		public void clickonmemberSignInlink(String ExpectedmemberSigninURL) {
			validateNew(memberSignInPage);
			CommonUtility.waitForPageLoadNew(driver, memberSignInPage, 30);
			String parentWindow = driver.getWindowHandle();
			memberSignInPage.click();
			sleepBySec(3);
			Set<String> tabs_windows = driver.getWindowHandles();
			Iterator<String> itr = tabs_windows.iterator();
			while(itr.hasNext()) {
				String window = itr.next();
				if(!parentWindow.equals(window)) {
					driver.switchTo().window(window);
				}
			}

			CommonUtility.checkPageIsReadyNew(driver);
			String CurrentmemberSigninURL = driver.getCurrentUrl();
			String ActualmemberSigninURL=CurrentmemberSigninURL.substring(0, 27).trim();
			System.out.println("memberSignin Page is displayed : "+ActualmemberSigninURL);
			System.out.println("Expected member signin URL: "+ExpectedmemberSigninURL);
			System.out.println("Actual member signin URL: "+ActualmemberSigninURL);

			if(ExpectedmemberSigninURL.equalsIgnoreCase(ActualmemberSigninURL)) {
				System.out.println("****************member signin Page is displayed  ***************");

				Assert.assertTrue(true);
			}
			else {
				Assert.fail("****************member signin Page is not loaded ***************");
			}

			ViewMedicareplanlinks.click();

		}
}