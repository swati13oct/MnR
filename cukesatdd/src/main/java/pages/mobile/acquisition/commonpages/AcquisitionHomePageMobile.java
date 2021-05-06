package pages.mobile.acquisition.commonpages;

import static atdd.framework.Assertion.assertTrue;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import pages.acquisition.commonpages.LearnAboutMedicareHomePage;
import pages.acquisition.commonpages.PageTitleConstants;
import pages.acquisition.commonpages.RequestHelpAndInformationPage;
import pages.acquisition.commonpages.ShopForPlanNavigationPage;
import pages.mobile.acquisition.commonpages.AboutUsPageMobile;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.AgentsAndBrokersPageMobile;
import pages.mobile.acquisition.commonpages.ContactUsUmsPageMobile;
import pages.mobile.acquisition.commonpages.DisclaimersPageMobile;
import pages.mobile.acquisition.commonpages.EnterZipCodePage;
import pages.mobile.acquisition.commonpages.KeywordSearchAARPMobile;
import pages.mobile.acquisition.commonpages.PharmacySearchPageMobile;
import pages.mobile.acquisition.commonpages.PrivacyPolicyUmsPageMobile;
import pages.mobile.acquisition.commonpages.VPPTestHarnessPageMobile;
import pages.mobile.acquisition.commonpages.ZipcodeLookupHomePageMobile;
import pages.mobile.acquisition.dce.bluelayer.DCETestHarnessPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.ole.OLETestHarnessPageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;

/**
 * @author pperugu
 *
 */
public class AcquisitionHomePageMobile extends GlobalWebElements {

	String CallSamPopupTitle = "Need Help? Call us.";
	@FindBy(xpath = "//*[contains(@id,'zipcodemeded')]")
	private WebElement zipCodeField;

	@FindBy(xpath = "//a[contains(@href,'https://www.myuhcagent.com/')]")
	private WebElement FindAnAgent;

	@FindBy(xpath = "//*[contains(@id,'zipcodemeded-0')]")
	private WebElement zipCodeShopField;

	@FindBy(xpath = "//*[contains(@id,'zipcodemeded')][1]//following-sibling::button//*[contains(text(),'Shop Plans')]")
	private WebElement viewShopPlansButton;

	@FindBy(css = "#zipcode")
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

	@FindBy(xpath = "(//div[@id='subnav_2']//h3/a[contains(text(),'Pharmacy')])[2]")
	private WebElement pharmacylocator;

	@FindBy(xpath = "//*[@id=\"planTypesColumn\"]/h3[2]/a")
	private WebElement enroll;

	@FindBy(id = "ghn_lnk_1")
	public WebElement navigationSectionHomeLink;

	@FindBy(id = "ghn_lnk_2")
	public WebElement ourPlansHoverLink;

	@FindBy(id = "subnav_2")
	public WebElement ourPlansDropdownText;

	@FindBy(xpath = "//html[@id='ctl00_MasterHtmlTag']/head/title")
	public WebElement test;

	@FindBy(id = "provider")
	private WebElement po7Link;

	@FindBy(id = "dce")
	private WebElement enterYourDrugListButton;

	@FindBy(xpath = "//*[@id='ghn_lnk_4']")
	private WebElement hoverhealthandwellnesslink;

	@FindBy(xpath = "//*[@id='subnav_4']/div/div/div[2]/div/a")
	public WebElement forgotusernamepasswordlink;

	@FindBy(xpath = "//*[@id='subnav_4']/div/div/div[2]/div/span[2]/a")
	public WebElement registerherelink;

	@FindBy(xpath = "//div[@class='overview-main']//h2")
	private WebElement vppTop;

	// @FindBy(xpath =
	// ".//*[contains(@id,'colhowdoesthiswork')]//*[@itemprop='significantLink']/*[contains(@class,'cta-button
	// secondary')and contains(text(),'Get')]")
	@FindBy(xpath = "//span[text()='Get Started']")
	public WebElement getStarted;

	@FindBy(id = "redirect_content")
	private WebElement leaveAARPMedicarePlansDialog;

	@FindBy(id = "proceed")
	private WebElement proceedLeaveAARPMedicare;

	@FindBy(xpath = "//a[@class='viewLink disclaimer']")
	private WebElement disclaimerLnkMobile;

	// @FindBy(xpath = ".//*[contains(@class,
	// 'meded-article-content__section')]//*[contains(text(), 'Request an
	// Appointment')]")
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

	@FindBy(xpath = "//*[contains(@class,'uhc-zip-button')]")
	private WebElement viewPlansButton;

	@FindBy(xpath = "//form[@id='zip-form']//button[@class='zip-button']")
	private WebElement findPlansBtn;

	@FindBy(xpath = "//button[@class='zip-button' and text()='Go']")
	public WebElement btnGO;

	/*
	 * @FindBy(id = "vpp_selectcounty_box") private WebElement countyModal;
	 */

	@FindBy(xpath = "//*[contains(@id,'change-location')]")
	private WebElement zipcodeChangeLink;

	@FindBy(id = "zipcode")
	private WebElement zipCode;

	@FindBy(id = "cta-zipcode")
	private WebElement zipCode1;

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

	@FindBy(xpath = "//tr[@id='contentRow']//h1")
	public WebElement footerLinkHeader;

	@FindBy(id = "medicareTitle")
	public WebElement siteMapHeader;

	@FindBy(xpath = "//*[contains(@dtmname,'Privacy')]//*[contains(text(),'Privacy Policy')]")
	public WebElement privacyHeader;

	@FindBy(xpath = "//h1//*[contains(text(),'Health Insurance Broker & Agent Tools')]")
	public WebElement brokerHeader;

	/* LearnAboutMedicare link */
	@FindBy(xpath = "//*[@id='ghn_lnk_3']")
	private WebElement lnkLearnAboutMedicare;

	@FindBy(xpath = "//*[@id='sam-call-modal']//h3[@id='sam-call-modal__title']")
	private WebElement callSamPopupTitle;

	@FindBy(xpath = "//h3//*[contains(@onclick,'loadCachedProviderSearch')]")
	private WebElement providerSearchFromGlobalHeader;

	@FindBy(xpath = "//*[@id='']")
	private WebElement searchIcon;

	@FindBy(xpath = "(//a[text()='Provider Search'])[2]")
	private WebElement providerSearchFromHomeScreen;

	@FindBy(id = "ghn_lnk_2")
	private WebElement ShopForaplan;

	@FindBy(xpath ="//*[@class='mob-sctn section-3 column column-lg-4']/p")
	private WebElement toolsToChoosePlan;
			
	@FindBy(xpath = ".//*[@id='updates-mobile-form']/div/div[2]/button")
	private WebElement submit;

	@FindBy(xpath = "//select[@id='state-select']")
	private WebElement stateDropDown;

	@FindBy(xpath = "//a[contains(@class, 'back-to-top')]")
	private WebElement backToTop_Disclaimer;

	@FindBy(xpath = "//a[contains(@dtmname, 'Footer:Visit AARP')]")
	private WebElement visitAARPFooterLink;

	@FindBy(xpath = "//a[contains(@class, 'back-to-top')]")
	private WebElement backToTop;

	@FindBy(xpath = "//div[contains(text(),'Disclaimers')]")
	private WebElement disclaimerInformation;

	@FindBy(css = ".icon-search")
	private WebElement searchbutton;

	@FindBy(id = "search-field")
	private WebElement searchfield;

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "//h3[@id='guest-profile']")
	private WebElement guestProfileLink;

	@FindBy(xpath = "//a[@id='ctc-sam-mobile']")
	private WebElement callsam;

	// String CallSam= "Call a Licensed Insurance Agent";
	String CallSam1855 = "1-855";
	String CallSam1877 = "1-877";

	// @FindBy(xpath = "//*[@id='sam-call-button']/div/span[1]")
	// @FindBy(xpath =
	// "//*[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text')]")
	@FindBy(xpath = "//a[@id='ctc-sam-mobile']")
	private WebElement callsamtooltip;

	@FindBy(xpath = "//*[@id='sam-call-modal']/div/div")
	private WebElement callSamPopup;

	@FindBy(xpath = "//*[contains(@class,'proactive-offer')]")
	private WebElement ProActivePopup;

	@FindBy(xpath = "//*[contains(@class,'proactive-offer__close') and contains(@class, 'close-icon')]")
	private WebElement ProActivePopup_Close;

	@FindBy(xpath = "//button[contains(@class,'proactive-offer__close') and contains(text(), 'Exit')]")
	private WebElement ProActivePopup_ExitBtn;

	@FindBy(xpath = "//button[contains(@class,'proactive-offer__button_type_chat') and contains(text(), 'Chat')]")
	private WebElement ProActivePopup_ChatBtn;

	@FindBy(xpath = "//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]")
	private WebElement CallSamModel;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@dtmname,'TFN Link') and contains(text(),'1-')]")
	private WebElement CallSamTFN;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'modal-close')]")
	private WebElement CallSamTFNClose;

	@FindBy(xpath = "//*[contains(@class,'activeChatBtn')]")
	private WebElement chatsam;

	String ChatSam = "Chat with a Licensed Insurance Agent";

	@FindBy(xpath = "//*[@id='sam-button--chat']/div//a[@class='sam__button__text']")
	private WebElement chatSamTooltip;

	@FindBy(xpath = "//div[@class='sam']")
	private WebElement samdiv;

	@FindBy(xpath = "//*[contains(@id,'sam-button--chat')]//*[contains(@class,'sam__button__text')]")
	private WebElement chatsamtooltip;

	@FindBy(xpath = "//*[contains(@id,'inner-chat')]")
	private WebElement chatSamPopup;

	@FindBy(xpath = "//*[contains(@id,'sp-chat-frame')]")
	private WebElement ProActivechatPopup;

	@FindBy(xpath = "//*[contains(@class,'commonFields')]//*[contains(@id,'first_name')]")
	private WebElement samChatFirstNameField;

	@FindBy(xpath = "//*[contains(@class,'commonFields')]//*[contains(@id,'last_name')]")
	private WebElement samChatLastNameField;

	@FindBy(xpath = "//*[contains(@class,'commonFields')]//*[contains(@id,'zip_code')]")
	private WebElement samChatZipField;

	@FindBy(xpath = "//*[contains(@class,'commonFields')]//*[contains(@id,'email') and contains(@name, 'email')]")
	private WebElement samChatEmailField;

	@FindBy(xpath = "//*[contains(@class,'commonFields')]//*[@class='option']//*[contains(@value,'Plan pricing ')]")
	private WebElement samChatOptions;

	// @FindBy(xpath
	// ="//*[contains(@class,'prechat__action-buttons')]//*[contains(@class,'servicepatternBtn
	// phone')]")
	@FindBy(xpath = "//*[contains(@id,'offline-form')]//*[contains(@class,'servicepatternBtn phone')]")
	private WebElement samChatConnect;

	@FindBy(xpath = "//*[@id='agent-name']")
	private WebElement ChatSamHead;

	// @FindBy(xpath ="//*[contains(@id,'sp-close-frame')]")
	@FindBy(xpath = " //*[@id='sp-chat-frame']//div/div[@id='sp-close-frame']")
	private WebElement ChatSamTFNClose;

	@FindBy(id = "pharmacy-zip-search")
	private WebElement thpharmacyzipsearch;

	@FindBy(xpath = "//input/parent::form//button[text()='Go']")
	private WebElement thpharmacyGoButton;

	@FindBy(id = "zipcodeTxt")
	private WebElement pharmacyZipCodeTextBox;

	@FindBy(id = "zipcode")
	private WebElement zipCodeHealthPlans;

	@FindBy(xpath = "//form[@name='zipcodeform']//button[contains(@class,'zip-button')]")
	private WebElement GoBtnHealthPlans;

	@FindBy(xpath = "//input[@id='search-field']")
	private WebElement EnterSearch;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SubmitBtn;

	@FindBy(xpath = "//h1[contains(text(),'Search Results')]")
	// @FindBy(xpath = "//h1[contains(@class,'search-results-title')]")
	private WebElement SearchResults;

	@FindBy(xpath = "//h2[@class='search-results-count']")
	private WebElement SearchResultsCount;

	@FindBy(xpath = "//a[@dtmname='pagination:previous']")
	private WebElement PreviousBtn;

	@FindBy(xpath = "//a[@dtmname='pagination:next']")
	private WebElement NextBtn;

	@FindBy(xpath = "//button[contains(@class,'btn button-transparent clear-button')]")
	private WebElement SecondaryClearBtn;

	@FindBy(xpath = "//input[@id='secondarySearchInput']")
	private WebElement SecondarySearchInput;

	@FindBy(xpath = "//button[contains(@class,'btn button-transparent clear-button')]/following::button[1]")
	private WebElement SecondarySearchBtn;

	@FindBy(xpath = "//*[contains(@aria-label, 'Close') and contains(@id, 'sp-close-frame')]")
	private WebElement ChatCancelBtn;

	@FindBy(xpath = "//button[@id='details-button' and contains(text(),'Advanced')]")
	private WebElement advancedBtn;

	@FindBy(xpath = "//a[@id='proceed-link']")
	private WebElement proceedLink;

	@FindBy(xpath = "//*[contains(text(),'UnitedHealthcare Medicare Solutions | Provider Search')]")
	private WebElement UnitedHealthcareMedicareSolutions;

	@FindBy(xpath = "//*[@aria-label='menu navigation']")
	private WebElement menu;

	@FindBy(id = "pharmacylocatorheader_id")
	private WebElement locatePharmacy;

	@FindBy(xpath = "//body/div[@id='overlay']")
	private WebElement overlayFilm;

	@FindBy(xpath = "//p[contains(text(),'UnitedHealthcare Insurance Company (UnitedHealthcare)')]")
	private WebElement UHCICSubTiltle;

	@FindBy(xpath = "//span[contains(text(),'Learn More About Medicare')]")
	private WebElement learnAboutMedicareHomeScreen;

	// String ChatSamText= "Chat with a Licensed Insurance Agent";
	String ChatSamText = "Chat Now";
	String CallSam = "1-877";
	// String CallSam= "Call a Licensed Insurance Agent";
	// String CallSam= "Call UnitedHealthcare Ins. Co.";

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

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	public AcquisitionHomePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public AcquisitionHomePageMobile(WebDriver driver, String site) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(site);
	}

	public AcquisitionHomePageMobile(WebDriver driver, boolean alreadyOnSite) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(alreadyOnSite);
	}

	public AcquisitionHomePageMobile(WebDriver driver, String siteOrPage, String testharnessurl) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(siteOrPage, testharnessurl);
	}

	public OLETestHarnessPageMobile GetOLETestHarnessPage() {
		return new OLETestHarnessPageMobile(driver);
	}

	public DCETestHarnessPageMobile GetDCEtestHarnessPage() {
		return new DCETestHarnessPageMobile(driver);
	}

	
	public void openPRE() {
		if (!(MRScenario.getProps() == null)) {// If running from local
			if (MRScenario.environment.equalsIgnoreCase("digital-uatv2-aarp")) {
				startNewMobile(
						AARP_ACQISITION_PAGE_URL.replace("digital-uatv2-aarp", "digital-uatv2").replace("www.", ""));
				// startNewMobile(AARP_ACQISITION_PAGE_URL.replace("digital-uatv2-aarp",
				// "digital-uatv2"));
			} else if (MRScenario.environment.equalsIgnoreCase("digital-uatv2")) {
				startNewMobile(UMS_ACQISITION_PAGE_URL.replace("www.", ""));
				// startNewMobile(UMS_ACQISITION_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("offline-stage-aarp")) {
				startNewMobile(AARP_ACQISITION_PAGE_URL.replace("offline-stage-aarp", "offline-stage"));
			} else if (MRScenario.environment.equalsIgnoreCase("offline-stage")) {
				startNewMobile(UMS_ACQISITION_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("stage-aarp")) {
				startNewMobile(AARP_ACQISITION_PAGE_URL.replace("stage-aarp", "stage"));
			} else if (MRScenario.environment.equalsIgnoreCase("stage")) {
				startNewMobile(UMS_ACQISITION_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("offline-prod-aarp")) {
				startNewMobile(AARP_ACQISITION_OFFLINE_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("offline-prod")) {
				startNewMobile(UMS_ACQISITION_OFFLINE_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("prod-aarp")) {
				startNewMobile(AARP_ACQISITION_PROD_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("prod")) {
				startNewMobile(UMS_ACQISITION_PROD_PAGE_URL);
			}
		} else { // For jenkins job
			String jenkinsRunnerFiles = MRScenario.getRunnerFileName();
			if (MRScenario.environment.equalsIgnoreCase("digital-uatv2")
					|| MRScenario.environment.equalsIgnoreCase("stage")
					|| MRScenario.environment.equalsIgnoreCase("offline-stage")) {
				for (String rname : jenkinsRunnerFiles.split(",")) {
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("ULAYER")) {
						if (MRScenario.environment.equalsIgnoreCase("digital-uatv2"))
							startNewMobile(AARP_ACQISITION_PAGE_URL.replace("www.", ""));
						else
							startNewMobile(AARP_ACQISITION_PAGE_URL);
					}
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("BLAYER")) {
						if (MRScenario.environment.equalsIgnoreCase("digital-uatv2"))
							startNewMobile(UMS_ACQISITION_PAGE_URL.replace("www.", ""));
						else
							startNewMobile(UMS_ACQISITION_PAGE_URL);
					}
				}
			}
			if (MRScenario.environment.equalsIgnoreCase("offline")) {
				for (String rname : jenkinsRunnerFiles.split(",")) {
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("ULAYER"))
						startNewMobile(AARP_ACQISITION_OFFLINE_PAGE_URL);
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("BLAYER"))
						startNewMobile(UMS_ACQISITION_OFFLINE_PAGE_URL);
				}
			}
			if (MRScenario.environment.equalsIgnoreCase("prod")) {
				for (String rname : jenkinsRunnerFiles.split(",")) {
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("ULAYER"))
						startNewMobile(AARP_ACQISITION_PROD_PAGE_URL);
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("BLAYER"))
						startNewMobile(UMS_ACQISITION_PROD_PAGE_URL);
				}
			}
		}
		System.out.println("Current mobile page URL: " + driver.getCurrentUrl());
	}

	public void fixPrivateConnection() {
		try {
			// String URL = "https://self-signed.badssl.com/";
			threadsleep(1000);
			if (driver.findElement(By.cssSelector("body.ssl h1")).getText()
					.contains("Your connection is not private")) {
				driver.findElement(By.cssSelector("button#details-button")).click();
				threadsleep(1000);
				driver.findElement(By.cssSelector("a#proceed-link")).click();
				threadsleep(1000);
				pageloadcomplete();
			}
		} catch (Exception e) {
			System.out.println("No SSL error / Exception");
		}
	}

	public AcquisitionHomePageMobile verifyChatpopupOnTablet() {
		chatsam.click();
		System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");
		return null;
	}

	public AcquisitionHomePageMobile validateChatSamContentOnTablet() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(chatsam).perform();
		String toolTipText = chatSamTooltip.getText();
		System.out.println("====================================================================");
		System.out.println(toolTipText);
		System.out.println("====================================================================");

		if (ChatSam.equalsIgnoreCase(toolTipText)) {
			System.out.println(
					"Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent");
			return new AcquisitionHomePageMobile(driver);
		} else
			System.out.println(
					"No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
		return null;
	}

	public void openAndValidate(String siteOrPage, String testharnessurl) {
		String testharurl = "content/" + testharnessurl + "testharnesspage.html";
		// String testharurl = "content/pharmacysearchtestharnesspage.html";
		if ("ULayer".equalsIgnoreCase(siteOrPage)) {
			if (MRScenario.environment.equals("offline")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// driver.manage().window().maximize();
				testSiteUrl = AARP_ACQISITION_OFFLINE_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = AARP_ACQISITION_OFFLINE_PAGE_URL + testharurl;
			} else if (MRScenario.environment.equals("prod")) {
				startNew(AARP_ACQISITION_PROD_PAGE_URL + testharurl);
				testSiteUrl = AARP_ACQISITION_PROD_PAGE_URL + testharurl;
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// driver.manage().window().maximize();
				testSiteUrl = AARP_ACQISITION_PROD_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = AARP_ACQISITION_PROD_PAGE_URL + testharurl;
			} else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// driver.manage().window().maximize();
				testSiteUrl = AARP_ACQISITION_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = AARP_ACQISITION_PAGE_URL + testharurl;
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
		} else if ("BLayer".equalsIgnoreCase(siteOrPage)) {
			if (MRScenario.environment.equals("offline")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// driver.manage().window().maximize();
				testSiteUrl = UMS_ACQISITION_OFFLINE_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = UMS_ACQISITION_OFFLINE_PAGE_URL + testharurl;
			} else if (MRScenario.environment.equals("prod")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// driver.manage().window().maximize();
				testSiteUrl = UMS_ACQISITION_PROD_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = UMS_ACQISITION_PROD_PAGE_URL + testharurl;
			} else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// driver.manage().window().maximize();
				testSiteUrl = UMS_ACQISITION_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = UMS_ACQISITION_PAGE_URL + testharurl;
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
		}
	}

	public void openAndValidate(boolean alreadyOnSite) {
		if (alreadyOnSite) {

			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
			testSiteUrl = driver.getCurrentUrl();
			checkModelPopup(driver);
			CommonUtility.waitForPageLoadNew(driver, zipCodeField, 15);
			try {
				if (proactiveChatExitBtn != null)
					jsClickNew(proactiveChatExitBtn);

				else
					Assert.fail("Please check booleanvalue");

			} catch (Exception e) {
				System.out.println("Proactive chat popup not displayed");
			}
		}
	}

	public AcquisitionHomePageMobile validateChatSamOnTablet() throws InterruptedException {
		boolean present;
		try {
			validateNew(chatsam);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to find Chat widget @@@@@@@@@");
			return new AcquisitionHomePageMobile(driver);
		} else
			System.out.println("@@@@@@@@@ No Chat widget @@@@@@@@@");
		return null;
	}
	// public AcquisitionHomePageMobile(WebDriver driver, boolean alreadyOnSite) {
	// super(driver);
	// PageFactory.initElements(driver, this);
	// openAndValidate(alreadyOnSite);
	// }
	//
	// public AcquisitionHomePageMobile(WebDriver driver, String siteOrPage) {
	// super(driver);
	// PageFactory.initElements(driver, this);
	// openAndValidate(siteOrPage);
	// }

	public String fetchEnvironmentUrls() {
		if (MRScenario.environment.equals("offline")) {
			testSiteUrl = AARP_ACQISITION_OFFLINE_PAGE_URL;
			return testSiteUrl;
		} else if (MRScenario.environment.equals("prod")) {
			testSiteUrl = AARP_ACQISITION_PROD_PAGE_URL;
			return testSiteUrl;
		} else
			testSiteUrl = AARP_ACQISITION_PAGE_URL;
		return testSiteUrl;
	}

	public void validateTFN(String tfnXpath) {

		WebElement TFNelement = driver.findElement(By.xpath(tfnXpath));
		validateNew(TFNelement, 45);
		if (validateNew(TFNelement) && TFNelement.isDisplayed()) {
			System.out.println("TFN is Displayed on Page : " + TFNelement.getText());
			scrollToView(TFNelement);
			jsClickMobile(TFNelement);
			System.out.println("@@@@@@@@@@@@@@@ TFN Clicked @@@@@@@@@@@@@@@");
			threadsleep(3000);
			verifyTFNPopUp(TFNelement);
		} else {
			org.testng.Assert.fail("TFN elemnet is not found / displayed on page : " + tfnXpath);
		}

	}

	public void verifyTFNPopUp(WebElement TFNelement) {
		Alert alert;
		try {
			alert = driver.switchTo().alert();
			System.out.println("Alert message : " + alert.getText());
			String TFN = driver.switchTo().alert().getText().replace(" (", "-").replace(") ", "-");
			System.out.println(TFN);
			if (TFN.contains(TFNelement.getText())) {
				System.out.println("The Call Alert is displayed with correct TFN : VALIDATION PASSED");
				alert.dismiss();
			} else {

				System.out.println("The Call Alert is displayed with INCORRECT TFN : Validation FAILED");
				alert.dismiss();
			}

		} catch (Exception e) {

			System.out.println("TFN Call pop-up NOT Displayed");
		}
	}

	public AcquisitionHomePageMobile validateCallpopupOnTablet() throws InterruptedException {
		boolean present;
		callsam.click();
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		driver.switchTo().activeElement();
		// System.out.println(CallSamTFN.getText());
		String toolTipText = callSamPopupTitle.getText();
		try {
			validateNew(callSamPopup);
		} catch (NoSuchElementException e) {
			System.out.println("Call popup not displayed");
		}
		CallSamTFNClose.click();
		present = validateNew(callsam);
		if (present && (CallSamPopupTitle.equalsIgnoreCase(toolTipText))) {
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			return new AcquisitionHomePageMobile(driver);
		} else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
		return null;
	}
	public void openAndValidate(String site) {
		if ("BLayer".equalsIgnoreCase(site) || site.equalsIgnoreCase("UHC") || site.equalsIgnoreCase("UMS")) {
			if (MRScenario.environment.equals("offline")) {
				startNew(UMS_ACQISITION_OFFLINE_PAGE_URL);
				testSiteUrl = UMS_ACQISITION_OFFLINE_PAGE_URL;
				checkModelPopup(driver, 45);
			} else if (MRScenario.environment.equals("prod")) {
				startNew(UMS_ACQISITION_PROD_PAGE_URL);
				testSiteUrl = UMS_ACQISITION_PROD_PAGE_URL;
				checkModelPopup(driver, 45);
			} else if (MRScenario.environment.contains("stage-0")) {
				startNew(UMS_ACQISITION_PAGE_URL_NEW);
				checkModelPopup(driver, 20);
			} else {
				startNew(UMS_ACQISITION_PAGE_URL);
				testSiteUrl = UMS_ACQISITION_PAGE_URL;
				checkForSecurityPage();
				checkModelPopup(driver, 10);
			}

		} else if ("health-plans".equalsIgnoreCase(site)) {
			isHealthPlan = true;
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
			testSiteUrl = driver.getCurrentUrl();
			checkModelPopup(driver, 15);
			CommonUtility.waitForPageLoadNew(driver, zipCode, 45);
			try {
				if (proactiveChatExitBtn != null) {
					jsClickNew(proactiveChatExitBtn);
				} else {
					Assertion.fail("Please check booleanvalue");
				}
			} catch (Exception e) {
				System.out.println("Proactive chat popup not displayed");
			}
		} else if (site.equalsIgnoreCase("AARP") || site.equalsIgnoreCase("Ulayer") || site.equalsIgnoreCase("AMP")) {
			if (MRScenario.environment.equals("offline")) {
				start(AARP_ACQISITION_OFFLINE_PAGE_URL);
				testSiteUrl = AARP_ACQISITION_OFFLINE_PAGE_URL;
				checkModelPopup(driver, 45);
			} else if (MRScenario.environment.equals("prod")) {
				start(AARP_ACQISITION_PROD_PAGE_URL);
				testSiteUrl = AARP_ACQISITION_PROD_PAGE_URL;
				checkModelPopup(driver, 45);
			} else if (MRScenario.environment.contains("stage-0")) {
				startNew(AARP_ACQISITION_PAGE_URL_NEW);
				checkModelPopup(driver, 20);
			}else {
				start(AARP_ACQISITION_PAGE_URL);
				testSiteUrl = AARP_ACQISITION_PAGE_URL;
				checkForSecurityPage();
				checkModelPopup(driver, 10);
			}
		}else if(site.equalsIgnoreCase("PRE")||site.equalsIgnoreCase("ARE")) {
			System.out.println("Temporary condition added to bypass openAndValidate for PRE/ARE"); //added on 3/3/21 as part of AARP/UHC cleanup
		}

		if(!(site.equalsIgnoreCase("PRE")||site.equalsIgnoreCase("ARE"))) { //adding this condition temporarily to bypass PRE/ARE flows
			//CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
			// checkModelPopup(driver,15);
			//CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 25);
			//CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn, 20); // do not change this to waitForPageLoadNew as
																				// we're not trying to fail the test if it
																				// isn't found
			try {
				validate(proactiveChatExitBtn,20);
				if (proactiveChatExitBtn.isDisplayed())
					jsClickNew(proactiveChatExitBtn);
			} catch (Exception e) {
				System.out.println("Proactive chat popup not displayed");
			}
		}
	}


	public void checkForSecurityPage() {
		if (!MRScenario.domain.contains("uhc.com")) {
			try {
				if (advancedBtn.isDisplayed()) {
					// advancedBtn.click();
					jsClickNew(advancedBtn);
					// proceedLink.click();
					jsClickNew(proceedLink);
				}
			} catch (Exception e) {
				System.out.println("Advanced button not displayed");
			}
		}
	}

	public PrivacyPolicyAARPPageMobile privacypolicyFooterClick() {
		validateNew(footerPrivacyPolicyLink);
		// footerPrivacyPolicyLink.click();
		jsClickNew(footerPrivacyPolicyLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(privacyHeader);
		if (driver.getCurrentUrl().contains("privacy-policy.html")) {
			return new PrivacyPolicyAARPPageMobile(driver);
		}
		return null;
	}

	public AgentsnBrokersAARPPageMobile agentsnbrokersFooterClick() {
		validate(footerAgentsnBrokersLink);
		// footerAgentsnBrokersLink.click();
		jsClickNew(footerAgentsnBrokersLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(brokerHeader);
		if (driver.getCurrentUrl().contains("health-insurance-brokers")) {
			return new AgentsnBrokersAARPPageMobile(driver);
		}
		return null;
	}

	public DisclaimersAARPPageMobile disclaimersFooterClick() {
		validate(footerDisclaimersLink);
		// footerDisclaimersLink.click();
		jsClickNew(footerDisclaimersLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("disclaimer")) {
			return new DisclaimersAARPPageMobile(driver);
		}
		return null;
	}

	public AcquisitionHomePageMobile homeFooterClick() {
		validateNew(footerHomeLink);
		// footerHomeLink.click();
		jsClickNew(footerHomeLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (validateNew(zipCodeField)) {
			return new AcquisitionHomePageMobile(driver);
		}
		return null;
	}

	public AboutUsAARPPageMobile aboutUsFooterClick() {
		validateNew(footerAboutUsLink);
		scrollToView(footerAboutUsLink);
		jsClickNew(footerAboutUsLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(footerLinkHeader, 30);
		if (getTitle().contains("About UnitedHealthcare")) {
			return new AboutUsAARPPageMobile(driver);
		}
		return null;
	}

	// public SiteMapUMSPageMobile siteMapFooterClick() {
	// validateNew(footerSiteMapLink);
	// footerSiteMapLink.click();
	// CommonUtility.checkPageIsReadyNew(driver);
	// validateNew(siteMapHeader);
	// if (driver.getCurrentUrl().contains("sitemap.html")) {
	// return new SiteMapUMSPageMobile(driver);
	// }
	// return null;
	// }

	public void clickBrowserBackButton() {
		driver.navigate().back();
	}

	public SiteMapAARPPageMobile siteMapFooterClick() {
		validateNew(footerSiteMapLink);
		// footerSiteMapLink.click();
		jsClickNew(footerSiteMapLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(siteMapHeader);
		if (driver.getCurrentUrl().contains("sitemap.html")) {
			return new SiteMapAARPPageMobile(driver);
		}
		return null;
	}

	public ContactUsAARPPageMobile contactUsFooterClick() {
		validateNew(footerContactUsLink);
		// footerContactUsLink.click();
		jsClickNew(footerContactUsLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("contact-us")) {
			return new ContactUsAARPPageMobile(driver);
		}
		return null;
	}

	public PrivacyPolicyUmsPageMobile privacyPolicyClick() {
		validateNew(footerPrivacyPolicyLink);
		// footerPrivacyPolicyLink.click();
		jsClickNew(footerPrivacyPolicyLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("privacy-policy.html")) {
			return new PrivacyPolicyUmsPageMobile(driver);
		}
		return null;

	}

	public DisclaimersPageMobile disclaimersClick() {
		validateNew(footerDisclaimersLink);
		// footerDisclaimersLink.click();
		jsClickNew(footerDisclaimersLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("disclaimer")) {
			return new DisclaimersPageMobile(driver);
		}
		return null;

	}

	/*
	 * @SuppressWarnings("deprecation") public void openAndValidate(boolean
	 * alreadyOnSite) { if (alreadyOnSite) {
	 * 
	 * CommonUtility.checkPageIsReadyNew(driver);
	 * System.out.println("Current page URL: "+driver.getCurrentUrl());
	 * testSiteUrl=driver.getCurrentUrl(); checkModelPopup(driver);
	 * CommonUtility.waitForPageLoadNew(driver, zipCodeField, 45); try{
	 * if(proactiveChatExitBtn!=null) jsClickNew(proactiveChatExitBtn);
	 * 
	 * else Assert.fail("Please check booleanvalue");
	 * 
	 * }catch(Exception e){
	 * System.out.println("Proactive chat popup not displayed"); } } }
	 * 
	 * public void openAndValidate(int visitorProfile) { if (visitorProfile>0) {
	 * 
	 * CommonUtility.checkPageIsReadyNew(driver);
	 * System.out.println("Current page URL: "+driver.getCurrentUrl());
	 * testSiteUrl=driver.getCurrentUrl(); checkModelPopup(driver,30);
	 * CommonUtility.waitForPageLoadNew(driver, zipCode, 45); try{
	 * if(proactiveChatExitBtn!=null) jsClickNew(proactiveChatExitBtn);
	 * 
	 * else Assert.fail("Please check booleanvalue");
	 * 
	 * }catch(Exception e){
	 * System.out.println("Proactive chat popup not displayed"); } } }
	 */
	/*
	 * public void openAndValidate(String siteOrPage) { if
	 * ("BLayer".equalsIgnoreCase(siteOrPage)) { if
	 * (MRScenario.environment.equals("offline")) {
	 * startNew(UMS_ACQISITION_OFFLINE_PAGE_URL);
	 * testSiteUrl=UMS_ACQISITION_OFFLINE_PAGE_URL; } else if
	 * (MRScenario.environment.equals("prod")) {
	 * startNew(UMS_ACQISITION_PROD_PAGE_URL);
	 * testSiteUrl=UMS_ACQISITION_PROD_PAGE_URL; } else {
	 * startNew(UMS_ACQISITION_PAGE_URL); testSiteUrl=UMS_ACQISITION_PAGE_URL; }
	 * CommonUtility.checkPageIsReadyNew(driver);
	 * System.out.println("Current page URL: "+driver.getCurrentUrl());
	 * checkModelPopup(driver,30); CommonUtility.waitForPageLoadNew(driver,
	 * navigationSectionHomeLink, 45); CommonUtility.waitForPageLoad(driver,
	 * proactiveChatExitBtn,20); // do not change this to waitForPageLoadNew as
	 * we're not trying to fail the test if it isn't found try{
	 * if(proactiveChatExitBtn.isDisplayed()) jsClickNew(proactiveChatExitBtn);
	 * }catch(Exception e){
	 * System.out.println("Proactive chat popup not displayed"); } } else
	 * if("health-plans".equalsIgnoreCase(siteOrPage)){ isHealthPlan = true;
	 * CommonUtility.checkPageIsReadyNew(driver);
	 * System.out.println("Current page URL: "+driver.getCurrentUrl());
	 * testSiteUrl=driver.getCurrentUrl(); checkModelPopup(driver,30);
	 * CommonUtility.waitForPageLoadNew(driver, zipCode, 45); try{
	 * if(proactiveChatExitBtn!=null) jsClickNew(proactiveChatExitBtn);
	 * 
	 * else Assert.fail("Please check booleanvalue");
	 * 
	 * }catch(Exception e){
	 * System.out.println("Proactive chat popup not displayed"); } }else{
	 * openAndValidate(); } }
	 */
	public String getTestSiteUrl() {
		return testSiteUrl;
	}

	public VPPPlanSummaryPageMobile searchPlans(String zipcode, String countyName) {
		waitForPageLoadSafari();
		if (isHealthPlan) {
			CommonUtility.waitForPageLoadNew(driver, zipCode, 30);
			scrollToView(zipCodeField);
			sendkeysMobile(zipCodeField, zipcode);

			jsClickNew(btnGO);
		} else {
			// CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
			scrollToView(zipCodeField);
			sendkeysMobile(zipCodeField, zipcode);

			jsClickNew(viewPlansButton);
		}

		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		if (validate(countyModal))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	public VPPPlanSummaryPageMobile searchPlanOnHealthPlansPage(String zipcode, String county, String isMultiCounty) {
		CommonUtility.waitForPageLoadNew(driver, healthPlansZipcode, 30);
		sendkeys(healthPlansZipcode, zipcode);
		// findPlansBtn.click();
		jsClickNew(findPlansBtn);

		if (isMultiCounty.equalsIgnoreCase("YES")) {
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			if (validate(countyModal))
				driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + county + "']")).click();
		}
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	// public VPPPlanSummaryPageMobile searchPlansForLearnFindPlans(String zipcode,
	// String countyName) {
	// sendkeys(learnzipCodeField, zipcode);
	// learnfindPlansButton.click();
	// try {
	// if (countyModal.isDisplayed()) {
	// for (WebElement county : countyRows) {
	// if (county.getText().equalsIgnoreCase(countyName)) {
	// county.click();
	// break;
	// }
	//
	// }
	// }
	// } catch (Exception e) {
	// System.out.println("county box not found");
	// }
	// if
	// (getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_PLAN_SUMMARY_PAGE_TITLE))
	// {
	// return new VPPPlanSummaryPageMobile(driver);
	// }
	// return null;
	// }

	public VPPPlanSummaryPageMobile navigateToVpp(String zipcode) {
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 3000);
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();
		// jsClickNew(viewPlansButton);
		CommonUtility.waitForPageLoadNew(driver, vppTop, 3000);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	public String selectsHomeFooter() {

		return homefooter.getText();
	}

	public VPPPlanSummaryPageMobile enterZipcode(String zipCode, String county, String planYear) {
		sendkeys(zipCodeField, zipCode);
		// zipCodebtn.click();
		jsClickNew(zipCodebtn);
		return new VPPPlanSummaryPageMobile(driver);
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

	public AcquisitionHomePageMobile veiwAllDisclaimerLinkSectionLinksClick() {
		validateNew(viewAllDisclaimerInformationLink);
		// viewAllDisclaimerInformationLink.click();
		jsClickNew(viewAllDisclaimerInformationLink);

		validateNew(disclaimerBackToTopLink);
		// disclaimerBackToTopLink.click();
		jsClickNew(disclaimerBackToTopLink);

		validateNew(hideDiscliamerInformation);
		// hideDiscliamerInformation.click();
		jsClickNew(hideDiscliamerInformation);

		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP� Medicare Plans from UnitedHealthcare�")) {
			return new AcquisitionHomePageMobile(driver);
		}
		return null;
	}

	// public Boolean visitAARPOrgClick() {
	// validateNew(visitAARPLink);
	// visitAARPLink.click();
	// validateNew(visitAARPLink);
	// ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	// driver.switchTo().window(tabs.get(1));
	// if (getTitle().equalsIgnoreCase("You are now leaving AARPMedicarerx.com")) {
	// proceedLink.click();
	// if (driver.getCurrentUrl().equals("http://www.aarp.org/")) {
	// return true;
	//
	// }
	// }
	// return false;
	// }

	public Boolean validate_alreadyPlanMemberButton_inactive() {
		return validateNew(alreadyPlanMemberButtonInactive);

	}

	public Boolean validate_alreadyPlanMemberButton_active() {
		validateNew(alreadyPlanMemberButton);
		// alreadyPlanMemberButton.click();
		jsClickNew(alreadyPlanMemberButton);
		return validateNew(alreadyPlanMemberButtonActive);

	}

	public Boolean validate_textField() {

		validateNew(usernameField);
		// usernameField.click();
		jsClickNew(usernameField);
		usernameField.sendKeys("q1ulayer");
		String user = usernameField.getAttribute("value");
		validateNew(passwordField);
		// passwordField.click();
		jsClickNew(passwordField);
		passwordField.sendKeys("Password");
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("q1ulayer") && pass.equalsIgnoreCase("Password")) {
			return true;
		}
		return false;
	}

	public AcquisitionHomePageMobile navigationSectionHomeLinkClick() {
		validateNew(navigationSectionHomeLink);
		// navigationSectionHomeLink.click();
		jsClickNew(navigationSectionHomeLink);
		validateNew(navigationSectionHomeLink);
		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP� Medicare Plans from UnitedHealthcare�")) {
			return new AcquisitionHomePageMobile(driver);
		}

		return null;
	}

	public Boolean navigationSectionEnterSearchClick() {
		validateNew(navigationSectionEnterSearch);
		// navigationSectionEnterSearch.click();
		jsClickNew(navigationSectionEnterSearch);
		navigationSectionEnterSearch.sendKeys("home");
		String search = navigationSectionEnterSearch.getAttribute("value");
		if (search.equalsIgnoreCase("home")) {
			return true;
		}

		return false;
	}

	public Boolean enterInvalidUserNamePassword() {
		validateNew(usernameField);
		// usernameField.click();
		jsClickNew(usernameField);
		usernameField.sendKeys("");
		// usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validateNew(passwordField);
		// passwordField.click();
		jsClickNew(passwordField);
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
		// signInButton.click();
		jsClickNew(signInButton);
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

	public AcquisitionHomePageMobile findplansbuttonclick() {
		validateNew(FindPlansButton1);
		FindPlansButton1.click();
		validateNew(FindPlansButton1);
		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP� Medicare Plans from UnitedHealthcare�")) {
			return new AcquisitionHomePageMobile(driver);
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

	public PharmacySearchPageMobile navigateToPharmacySearchMobile() {

		MobileMenuAccessPharmacy();

		if (locatePharmacy.getText().contains((PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE))) {
			return new PharmacySearchPageMobile(driver);
		} else {
			return null;
		}
	}

	public PharmacySearchPageMobile navigateToEnrollMobile() {
		waitforElement(menu);
		if (menu.isDisplayed()) {
			jsClickMobile(menu);
			if (OurPlans.isDisplayed()) {
				jsClickMobile(OurPlans);
				while (!enroll.isDisplayed()) {
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,100)", "");
				}
				jsClickMobile(enroll);
			}
		}

		if (locatePharmacy.getText().contains((PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE))) {
			return new PharmacySearchPageMobile(driver);
		} else {
			return null;
		}
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

	public VPPPlanSummaryPageMobile searchPlansWithOutCounty(String zipcode) throws InterruptedException {

		pageloadcomplete();
		// CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);

		scrollToView(zipCodeField);
		// sendkeysNew(zipCodeField, zipcode);
		jsSendkeys(zipCodeField, zipcode);
		jsClickNew(viewPlansButton);

		pageloadcomplete();

		validateNew(vppTop, 10);
		if (driver.getCurrentUrl().contains("health-plans")) {
			return new VPPPlanSummaryPageMobile(driver);
		} else
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

	/*
	 * public AboutUsAARPPage aboutUsFooterClick() { validateNew(footerAboutUsLink);
	 * footerAboutUsLink.click(); CommonUtility.checkPageIsReadyNew(driver); if
	 * (getTitle().contains("About UnitedHealthcare")) { return new
	 * AboutUsAARPPage(driver); } return null; }
	 * 
	 * public void validateFooterLinks() { validateNew(footerHomeLink);
	 * validateNew(footerAboutUsLink); validateNew(footerContactUsLink);
	 * validateNew(footerSiteMapLink); validateNew(footerPrivacyPolicyLink);
	 * validateNew(footerTermsnConditionsLink); validateNew(footerDisclaimersLink);
	 * validateNew(footerAgentsnBrokersLink);
	 * //validateNew(footerRequestforAssistancelink);
	 * validateNew(footerAccessibilitylink); validateNew(aarpOrgLink);
	 * validateNew(medicareAdvantagePlansLink);
	 * validateNew(medicareSpecialNeedsPlansLink);
	 * validateNew(medicareSupplementInsurancePlansLink);
	 * validateNew(medicarePrescriptionDrug_PlansLink);
	 * validateNew(learnAboutMedicareLink);
	 * validateNew(viewAllDisclaimerInformationLink);
	 * 
	 * }
	 * 
	 * public ContactUsAARPPage contactUsFooterClick() {
	 * validateNew(footerContactUsLink); footerContactUsLink.click();
	 * CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("contact-us")) { return new
	 * ContactUsAARPPage(driver); } return null; }
	 * 
	 * 
	 * 
	 * public PrivacyPolicyAARPPage privacypolicyFooterClick() {
	 * validateNew(footerPrivacyPolicyLink); footerPrivacyPolicyLink.click();
	 * CommonUtility.checkPageIsReadyNew(driver); validateNew(privacyHeader); if
	 * (driver.getCurrentUrl().contains("privacy-policy.html")) { return new
	 * PrivacyPolicyAARPPage(driver); } return null; }
	 * 
	 * public TermsnConditionsAARPPage termsnconditionsFooterClick() {
	 * validate(footerTermsnConditionsLink); footerTermsnConditionsLink.click();
	 * CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("terms-of-use")) { return new
	 * TermsnConditionsAARPPage(driver); } return null; }
	 * 
	 * public AcquisitionHomePageMobile homeFooterClick() {
	 * validateNew(footerHomeLink); footerHomeLink.click();
	 * CommonUtility.checkPageIsReadyNew(driver); if (validateNew(zipCodeField)) {
	 * return new AcquisitionHomePageMobile(driver, true); } return null; }
	 * 
	 * public void clickRequestAsistancce() {
	 * validateNew(footerRequestforAssistancelink); if(proactiveChatExitBtn!=null)
	 * proactiveChatExitBtn.click(); footerRequestforAssistancelink.click();
	 * CommonUtility.waitForPageLoadNew(driver, requestAssistanceModal, 30);
	 * validateNew(requestAssistanceTitle); validateNew(requestAssistanceAgentID);
	 * requestAssistanceClose.click();
	 * waitforElementDisapper(By.id("cobrowse-disclaimer"), 30); } public boolean
	 * validateSomeElementsOnPage() { if (validateNew(zipCodeField) &&
	 * validateNew(findPlansButton) && validateNew(lookzip)) return true; // if all
	 * three return false;
	 * 
	 * }
	 */
	public boolean validateAllElementsOnPage() {
		if (!validateNew(zipCodeField) && !validateNew(findPlansButton) && !validateNew(lookzip))
			return false; // if all three elements return false for validation
							// then this condition passes due to ! and returns
							// false meaning all three elements were not found
							// on page
		return true;
	}

	public GetStartedPageMobile clickDCERedesignLinkonMedEdPage() {
		WebElement DCELink = driver.findElement(By
				.xpath("//a[contains(@href,'drug-cost-estimator') and contains(@class,'contentRow__mededcontainer')]"));
		validateNew(DCELink);
		jsClickNew(DCELink);
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPageMobile(driver);
		return null;
	}

	@FindBy(xpath = "//div[.='MENU']")
	private WebElement Menu;

	public void navigateToMedEdPresDrugPage() {
		waitforElement(Menu);
		jsClickMobile(Menu);

		waitforElement(lnkLearnAboutMedicare);

		if (lnkLearnAboutMedicare.isDisplayed()) {
			Actions actions = new Actions(driver);
			actions.moveToElement(lnkLearnAboutMedicare);
			actions.build().perform();
			System.out.println("Hover over Learn about Medicare completed");
		}

		// WebElement PresProvidersBenefitsLink =
		// driver.findElement(By.xpath("//*[contains(@class, 'nav-col
		// nav-col-3')]//a[contains(@href,'medicare-benefits')]"));
		WebElement PresProvidersBenefitsLink = driver
				.findElement(By.xpath("//span[contains(text(),'Prescriptions, Providers & Benefits')]"));
		jsClickNew(PresProvidersBenefitsLink);
	}

	public VPPPlanSummaryPageMobile ZipcodeSearch(String zipcode) {
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
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	/*
	 * public MultiCountyModalPage ValidateMultiCOuntyPopUp(String zipcode) {
	 * CommonUtility.waitForPageLoad(driver, zipCodeField, 30);
	 * sendkeys(zipCodeField, zipcode);
	 * 
	 * viewPlansButton.click(); driver.manage().timeouts().implicitlyWait(10,
	 * TimeUnit.SECONDS); if (countyModal.isDisplayed()) { return new
	 * MultiCountyModalPage(driver); } return null; }
	 * 
	 * public WebElement getLnkLearnAboutMedicare() { return lnkLearnAboutMedicare;
	 * }
	 * 
	 * public LearnAboutMedicareHomePage openLearnAboutMedicarePage() {
	 * 
	 * getLnkLearnAboutMedicare().click();
	 * validateNonPresenceOfElement(zipCodeField); return new
	 * LearnAboutMedicareHomePage(driver); }
	 * 
	 * 
	 * 
	 * public MultiCountyModalPage SubNav_ValidateMultiCOuntyPopUp(String zipcode) {
	 * hoverourplanslink(); validate(OurPlans_zipfield); OurPlans_zipfield.click();
	 * OurPlans_zipfield.sendKeys(zipcode); validate(OurPlans_viewPlansButton);
	 * OurPlans_viewPlansButton.click();
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); if
	 * (countyModal.isDisplayed()) { return new MultiCountyModalPage(driver); }
	 * return null; }
	 */

	@FindBy(xpath = "//a[@dtmname='NavLinks:Shop for a Plan:Plan Types:Provider Search']")
	public WebElement ProviderSearch;

	public ProviderSearchPageMobile clicksOnRallyToolFromGlobalHeader() {

		MobileMenuToolsToHelp();

		scrollToView(ProviderSearch);
		ProviderSearch.click();
		switchToNewTabNew(ProviderSearch);

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {

			return new ProviderSearchPageMobile(driver);

		}
		return null;
	}

	public pages.mobile.acquisition.commonpages.ProviderSearchPageMobile clicksOnRallyToolFromHomePages() {
		MobileMenu();
		MobileMenuShopTool();
		validateNew(providerSearchFromHomeScreen);

		switchToNewTabNew(providerSearchFromHomeScreen);

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {

			return new pages.mobile.acquisition.commonpages.ProviderSearchPageMobile(driver);

		}
		return null;
	}

	public ProviderSearchPageMobile clicksOnRallyToolFromHomePage() {
		MobileMenuMain();
		MobileMenuProviderSearch();
		validateNew(providerSearchFromHomeScreen);

		switchToNewTabNew(providerSearchFromHomeScreen);

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {

			return new ProviderSearchPageMobile(driver);

		}
		return null;
	}

	public AcquisitionHomePageMobile hovershopaplan() throws InterruptedException {

		waitforElement(ShopForaplan);
		if (ShopForaplan.isDisplayed()) {
			Actions actions = new Actions(driver);
			actions.moveToElement(ShopForaplan);
			waitforElementNew(submit);
			System.out.println("Submit button is displayed");
			return new AcquisitionHomePageMobile(driver);
		} else {
			return null;
		}
	}

	/*
	 * public ShopforaplanAARPlayer Hoveronaplan() throws InterruptedException {
	 * waitforElement(ShopForaplan); if (ShopForaplan.isDisplayed()) { Actions
	 * action = new Actions(driver);
	 * action.moveToElement(ShopForaplan).build().perform(); return new
	 * ShopforaplanAARPlayer(driver); } else { return null;} }
	 */
	public WelcomePageMobile ZipcodeSearchToOLEWithOutCounty(String zipcode, String planName) throws Exception {
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
		// String planYear=ZipCodeLabel.getText();
		driver.findElement(By.xpath("//*[@id='js-ole-plan-select']//option[text()='" + planName + "']")).click();
		waitforElement(enrollButton);
		enrollButton.click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("Online Enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePageMobile(driver);
		}
		return null;
	}

	public LearnAboutMedicareHomePageMobile HoveronaLearnMedicare() throws InterruptedException {
		waitforElement(learnaboutMedicare);
		if (learnaboutMedicare.isDisplayed()) {
//            Actions action = new Actions(driver);
//            action.moveToElement(ShopForaplan).build().perform();
			jsMouseOver(learnaboutMedicare);
			return new LearnAboutMedicareHomePageMobile(driver);
		} else {
			return null;
		}
	}
	
	public WelcomePageMobile ZipcodeSearchToOLEWithCounty(String zipcode, String countyName, String planName)
			throws Exception {
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
			return new WelcomePageMobile(driver);
		}
		return null;
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
			Assertion.assertTrue(errMessage.contains("Your search box was empty. Please enter some text in the search box"));
			break;
		case "InvalidCharacter":
			System.out.println("Validating invalid character message");
			String invalidSearch = driver.findElement(By.xpath("//div[@class='invalid-search']")).getText();
			System.out.println("invalidSearch : >>>>> " + invalidSearch);
			Assertion.assertTrue(invalidSearch.contains("Your search - " + newSearchValue + " - did not match any documents."));
			// Assertion.assertTrue(invalidSearch.contains("No pages were found containing
			// "+newSearchValue+"."));
			break;
		case "Numbers":
			System.out.println("Numbers");
			break;
		}
	}

	public void enterSecondarySearchValue(String str) {
		System.out.println("@@@inside secondary search validation method@@@");
		CommonUtility.waitForPageLoadNewForClick(driver, SecondaryClearBtn, 30);
		SecondaryClearBtn.click();
		CommonUtility.waitForPageLoad(driver, SecondarySearchInput, 30);
		SecondarySearchInput.sendKeys(str);
		CommonUtility.waitForPageLoadNewForClick(driver, SecondarySearchBtn, 30);
		SecondarySearchBtn.click();
		CommonUtility.waitForPageLoadNew(driver, SearchResults, 60);

	}

	public void validateCountResults() {
		System.out.println("@@@inside count results validation@@");
		String SearchResultsCountUI = SearchResultsCount.getText();
		System.out.println("SearchResultsCountUI" + SearchResultsCountUI);

		String[] arr = SearchResultsCountUI.split("\\s+");
		String expectedCount = arr[3];
		System.out.println("Expected count from UI" + expectedCount);
		String SearchResultsCountAttribute = SearchResultsCount.getAttribute("dtmname");
		System.out.println("SearchResultsCountAttribute" + SearchResultsCountAttribute);
		String[] arr1 = SearchResultsCountAttribute.split("\\s+");
		String expectedCountfromAttribute = arr1[0];
		System.out.println("Expected Count from Attribute" + expectedCountfromAttribute);
		Assert.assertEquals(expectedCount, expectedCountfromAttribute);
		System.out.println("check");

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

	public void enterSearchtextvalue(String sv) {
		System.out.println("@@@Inside search text value Method@@@");
		threadsleep(5);
		// driver.switchTo().defaultContent();
		// CommonUtility.waitForPageLoad(driver, EnterSearch, 60);
		// EnterSearch.sendKeys(sv);
		jsSendkeys(EnterSearch, sv);
		// CommonUtility.waitForPageLoadNewForClick(driver, SubmitBtn, 60);
		scrollToView(SubmitBtn);
		// SubmitBtn.click();
		jsClickNew(SubmitBtn);
		CommonUtility.waitForPageLoadNew(driver, SearchResults, 60);

	}

	public VisitorProfileTestHarnessPageMobile GetVisitorProfileTestHarnessPage() {
		return new VisitorProfileTestHarnessPageMobile(driver);
	}

	public VPPTestHarnessPageMobile GetVPPTestHarnessPage() {
		return new VPPTestHarnessPageMobile(driver);
	}

	public void validateCallSamContent() throws InterruptedException {

		// Actions action = new Actions(driver);
		// WebElement element = callsam;
		// action.moveToElement(element).perform();
		waitforElementNew(callsamtooltip, 30);
		String toolTipText = callsamtooltip.getText();
		System.out.println("====================================================================");
		System.out.println(toolTipText);
		System.out.println("====================================================================");

		if (toolTipText.contains(CallSam1877)) {
			System.out.println("Call sticky action menu roll out and contain the text: " + toolTipText);

		} else if (toolTipText.contains(CallSam1855)) {
			System.out.println("Call sticky action menu roll out and contain the text" + toolTipText);
		}

		else
			Assert.fail("No Call sticky action menu didn't roll out and doesn't contain the text 1-877");

	}

	public void selectState(String state) {
		pageloadcomplete();
		// selectFromDropDownByValue(stateDropDown, state);
		mobileSelectOption(stateDropDown, state, true);

	}

	/**
	 * This method used to navigate to visitor profile dashboard
	 * 
	 * @return
	 */

	public VPPPlanSummaryPageMobile findPlans(String txtZipCode) {

		zipCode.sendKeys(txtZipCode);

		return new VPPPlanSummaryPageMobile(driver);
	}

	public MultiCountyModalPageMobile ValidateMultiCOuntyPopUp(String zipcode) {
		// TODO Auto-generated method stub
		return null;
	}

	public MultiCountyModalPageMobile SubNav_ValidateMultiCOuntyPopUp(String zipcode) {
		// TODO Auto-generated method stub
		return null;

	}

	/*
	 * public keywordSearchAARP searchfield() { validate (searchfield);
	 * System.out.println("search field is seen on AARP site  ==>" +
	 * searchfield.isDisplayed()); validate (searchbutton);
	 * System.out.println("search button is seen on AARP site ==>" +
	 * searchbutton.isDisplayed()); searchfield.clear();
	 * searchfield.sendKeys("medicare"); searchbutton.click(); try {
	 * Thread.sleep(3000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } if
	 * (driver.getCurrentUrl().contains("medicare.html?q=medicare")) return new
	 * keywordSearchAARP(driver); return null; }
	 */
	public ZipcodeLookupHomePageMobile looksupforZipcodes() {

		// lookzip.click();
		validate(lookzip);
		jsClickNew(lookzip);

		CommonUtility.waitForPageLoad(driver, zipCodeSearchPopup, CommonConstants.TIMEOUT_30);
		if (zipCodeSearchPopupHeading.getText().equalsIgnoreCase("Find a ZIP code")) {
			System.out.println("zipCodeSearchPopupHeading");
			return new ZipcodeLookupHomePageMobile(driver);
		}
		return null;

	}

	public VPPPlanSummaryPageMobile searchPlansCounty(String countyName) {
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
			return new VPPPlanSummaryPageMobile(driver);

		}
		return null;
	}

	public VPPPlanSummaryPageMobile searchPlansNoCounty() {
		if (isHealthPlan) {
			CommonUtility.waitForPageLoadNew(driver, zipCodeHealthPlans, 45);
			zipCodeHealthPlans.click();
			GoBtnHealthPlans.click();
			CommonUtility.waitForPageLoadNew(driver, vppTop, 30);

		} else {
			CommonUtility.waitForPageLoadNew(driver, zipCodeField, 20);
			zipCodeField.click();
			viewPlansButton.click();
			CommonUtility.waitForPageLoadNew(driver, vppTop, 40);
		}
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	public void validateStateDropDown() {
		scrollToView(stateDropDown);
		validateNew(stateDropDown);
		selectFromDropDownByValue(stateDropDown, "California");
		String StateSessionStorage = returnDriverStorageJS("sessionStorage", "ucp_geotrackingState");
		System.out.println("State selected : California");
		System.out.println("State GeoSessionStorage value : " + StateSessionStorage);
		Assert.assertTrue(StateSessionStorage.equalsIgnoreCase("CA"), "Geolocation State validation Failed ");
	}

	public void validateDisclaimer() {

		scrollToView(disclaimerInformation);
		validateNew(disclaimerInformation);
		// disclaimerInformation.click();
		jsClickNew(disclaimerInformation);
		validateNew(backToTop_Disclaimer, 3);

	}

	public void validateVisitAarpOrglink() {
		waitforElementVisibilityInTime(visitAARPFooterLink, 10);
		validateNew(visitAARPFooterLink);
		String hRef = visitAARPFooterLink.getAttribute("href");
		System.out.println("href for Visit AARP.org link : " + hRef);
		Assert.assertTrue(hRef.contains("www.aarp.org"), "Incorrect href for Visit AARP.org : " + hRef);
		visitAARPFooterLink.isEnabled();
	}

	public void backToToplink() {
		validateNew(backToTop);
		// backToTop.click();
		jsClickNew(backToTop);
	}

	// public void validateHeaderLinks() {
	// validateNew(headerSignInLink);
	// validateNew(headerRegisterLink);
	// validateNew(visitAARPLink);
	// validateNew(AARPlogo);
	// validateNew(visitorprofileicon);
	// }

	public void signInheader() {
		MobileMenuMain();

		jsClickNew(headerSignInLink);
		waitForPageLoadSafari();
		validateNew(signIn);
		if (driver.getCurrentUrl().contains("medicare.uhc.com")) {
			Assert.assertTrue(true);
			System.out.println("Signin page is loaded");

			clickBrowserBackButton();
			CommonUtility.waitForPageLoad(driver, healthPlansZipcode, 30);
			System.out.println("Home Page is loaded");
		} else {
			Assert.fail("Unable to navigate to signin page");
		}

	}

	// public void validateAARPlogo() {
	// // TODO Auto-generated method stub
	// validateNew(AARPlogo);
	// WebElement AARPLogo = driver.findElement(By.xpath("//a[contains(@id,
	// 'aarpSVGLogo')]"));
	// WebElement UHCLogo = driver.findElement(By.xpath("//a[contains(@id,
	// 'uhcSVGLogo')]"));
	// if(AARPLogo.isDisplayed() && AARPLogo.isEnabled() && !UHCLogo.isDisplayed()){
	// Assert.assertTrue(true);
	// System.out.println("Correct AARP Logo is Displayed");
	// }
	// else
	// {
	// Assert.fail("AARP logo is not dispalyed for Ulayer");
	// }
	//
	// }

	public void navigateToPath(String path) {

		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL : " + CurrentURL);

		String NavigateToURL = CurrentURL + path;
		System.out.println("Navigating to URL : " + NavigateToURL);
		driver.navigate().to(NavigateToURL);
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
		// validateNew(aarpOrgLink);
		validateNew(medicareAdvantagePlansLink);
		validateNew(medicareSupplementInsurancePlansLink);
		validateNew(medicarePrescriptionDrug_PlansLink);
		validateNew(medicareSpecialNeedsPlansLink);
		validateNew(learnAboutMedicareLink);
	}

	public PharmacySearchPageMobile navigateToPharmacyLocator() {
		jsClickMobile(Menu);

		waitforElement(ShopForaplan);
		if (ShopForaplan.isDisplayed()) {
			jsClickNew(ShopForaplan);
			scrollToView(toolsToChoosePlan);
			waitforElement(toolsToChoosePlan);
			jsClickNew(toolsToChoosePlan);
			System.out.println("clicked on tools to choose plan");
			
			scrollToView(pharmacylocator);
			waitforElement(pharmacylocator);
			jsClickNew(pharmacylocator);
			System.out.println("navigating to pharmacy locator page");
		}
		
		if (driver.getTitle().toLowerCase()
				.contains((PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase())) {
			return new PharmacySearchPageMobile(driver);
		}
		return null;
		

	}

	public void validateTFNelement(String tfnXpath) {
		WebElement TFNelement = driver.findElement(By.xpath(tfnXpath));
		validateNew(TFNelement);
		if (validateNew(TFNelement) && TFNelement.isDisplayed()) {
			System.out.println("TFN is Displayed on Page : " + TFNelement.getText());
		} else {
			Assert.fail("TFN elemnet is not found / displayed on page : " + tfnXpath);
		}
	}

	private void CheckPageLoad() {
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: " + driver.getCurrentUrl());
		checkModelPopup(driver, 30);

	}
	//
	// public void CheckiPerseptions() {
	// CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn,20); // do not
	// change this to waitForPageLoadNew as we're not trying to fail the test if it
	// isn't found
	// try{
	// if(proactiveChatExitBtn.isDisplayed())
	// jsClickNew(proactiveChatExitBtn);
	// }catch(Exception e){
	// System.out.println("Proactive chat popup not displayed");
	// }
	// }
	//

	public void validateSubNavShopPlanLinks() {
		CheckPageLoad();
		// CheckiPerseptions();

		// waitforElement(ShopForaplan);

		MobileMenuShopTool();

		// MobileMenuMain();
		// scrollToView(ShopForaplan);
		// validateNew(ShopForaplan, 5);
		// if (ShopForaplan.isDisplayed()) {
		// Actions actions = new Actions(driver);
		// actions.moveToElement(ShopForaplan);
		// actions.build().perform();
		// System.out.println("Hover over Shop for a Plan completed");
		//
		// //
		// waitforElementNew(driver.findElement(By.xpath("//input[@id='nav-zipcode']")));
		// // System.out.println("Submit button is displayed");
		// }
		WebElement ZipCodeTxt = driver.findElement(By.xpath("//input[@id='nav-zipcode']"));
		WebElement FindPlansBtn = driver.findElement(By.xpath("//button[@dtmid='acq_top_nav']"));
		WebElement RequestMoreInfoLink = driver
				.findElement(By.xpath("//a[@dtmname='Top Nav:Our Plans:Request More Help']"));
		WebElement EnrollLink = driver.findElement(By.xpath("//a[contains(@href,'enroll.html')]"));
		WebElement ShopLink = driver.findElement(By.xpath("//a[contains(@href,'shop.html')]"));
		WebElement ResourceLink = driver.findElement(By.xpath("//a[contains(@href,'resources.html')]"));

		WebElement MAplansLink = driver.findElement(By.xpath(
				"//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'medicare-advantage-plans.html')]"));
		WebElement MedSuppPlansLink = driver.findElement(By.xpath(
				"//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'medicare-supplement-plans.html')]"));
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
		validateNew(MedSuppPlansLink);
		validateNew(PDPplansLink);
		validateNew(SNPplansLink);

		validateNew(PlanSelectorLink);
		validateNew(DCELink);
		validateNew(PharmacySearchLink);
		validateNew(ProviderSearchLink);

		if (ZipCodeTxt.isDisplayed() && FindPlansBtn.isDisplayed() && RequestMoreInfoLink.isDisplayed()
				&& EnrollLink.isDisplayed() && ShopLink.isDisplayed() && ResourceLink.isDisplayed()
				&& MAplansLink.isDisplayed() && MedSuppPlansLink.isDisplayed() && PDPplansLink.isDisplayed()
				&& SNPplansLink.isDisplayed() && PlanSelectorLink.isDisplayed() && DCELink.isDisplayed()
				&& PharmacySearchLink.isDisplayed() && ProviderSearchLink.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Sub Nav - Shop for a Plan - All links and element displayed on Page : ");
			Actions actions = new Actions(driver);
			// actions.moveToElement(AARPlogo);
			actions.build().perform();
		} else {
			Assert.fail("Sub Nav - Shop for a Plan - All links and element not found / displayed on page : ");
		}

		// MobileMenuBackBtn.click();
		jsClickNew(MobileMenuBackBtn);

	}

	@FindBy(xpath = "//span[@role='button']")
	private WebElement MobileMenuBackBtn;

	@FindBy(xpath = "//a[@aria-label='Close Navigation button']")
	private WebElement MobileMenuCloseNavigationBtn;

	public void validateSubNavMedEdLinks() {
		CheckPageLoad();
		// CheckiPerseptions();

		waitforElement(lnkLearnAboutMedicare);
		jsClickNew(lnkLearnAboutMedicare);
		// if (lnkLearnAboutMedicare.isDisplayed()) {
		// Actions actions = new Actions(driver);
		// actions.moveToElement(lnkLearnAboutMedicare);
		// actions.build().perform();
		// System.out.println("Hover over Learn about Medicare completed");
		// }
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
		// WebElement FAQLink = driver.findElement(By.xpath("//*[contains(@class,
		// 'nav-col nav-col-3')]//a[contains(@href,'medicare-faq')]"));

		if (validateNew(EligibilityTxt)) {
			validateNew(ChoicesBtn);
			validateNew(PresProvidersBenefitsLink);
			validateNew(CostbasicsLink);

			validateNew(MAplansLink);
			validateNew(MedSuppPlansLink);
			validateNew(PDPplansLink);

			scrollToView(EnrollmentBasicsLink);

			Assert.assertTrue(true);
			System.out.println("Sub Nav - Learn about Medicare - All links and element displayed on Page");

			// if (EligibilityTxt.isDisplayed() && ChoicesBtn.isDisplayed() &&
			// PresProvidersBenefitsLink.isDisplayed()
			// && CostbasicsLink.isDisplayed() && MAplansLink.isDisplayed() &&
			// MedSuppPlansLink.isDisplayed()
			// && PDPplansLink.isDisplayed() && EnrollmentBasicsLink.isDisplayed()) {
			// // && FAQLink.isDisplayed()
			// Assert.assertTrue(true);
			// System.out.println("Sub Nav - Learn about Medicare - All links and element
			// displayed on Page");
			// Actions actions = new Actions(driver);
			// // actions.moveToElement(AARPlogo);
			// actions.build().perform();
		} else

		{
			Assert.fail("Sub Nav - Learn about Medicare - All links and element not found / displayed on page");
		}

		pageloadcomplete();
		jsClickNew(MobileMenuBackBtn);

		jsClickNew(MobileMenuCloseNavigationBtn);

	}

	public void headerRegisterLink() {
		MobileMenuMain();
		if (headerRegisterLink.isDisplayed() && headerRegisterLink.isEnabled()) {
			Assert.assertTrue(true);
			System.out.println("Register link is displayed on home page");
			scrollToView(MenuCrossMobile);
			jsClickNew(MenuCrossMobile);
		} else {
			Assert.fail("Register link is not found/ displayed on home page");
		}

	}

	public void fixPrivateConnectionMobile() {
		try {
			// String URL = "https://self-signed.badssl.com/";
			threadsleep(1000);
			if (driver.findElement(By.cssSelector("body.ssl h1")).getText()
					.contains("Your connection is not private")) {
				driver.findElement(By.cssSelector("button#details-button")).click();
				threadsleep(1000);
				driver.findElement(By.cssSelector("a#proceed-link")).click();
				threadsleep(1000);
				pageloadcomplete();
			}
		} catch (Exception e) {
			System.out.println("No SSL error / Exception");
		}
	}

	public void openMobileURL() {
		if (MRScenario.environment.equalsIgnoreCase("prod")) {
			startNewMobile(AARP_ACQISITION_PROD_PAGE_URL);
		} else if (MRScenario.environment.equalsIgnoreCase("offline")) {
			startNewMobile(AARP_ACQISITION_OFFLINE_PAGE_URL);
		} else
			startNewMobile(AARP_ACQISITION_PAGE_URL);
		System.out.println("Current mobile page URL: " + driver.getCurrentUrl());
	}
	
	public void openTelesalesAgentPortal() {
		if (MRScenario.environment.equalsIgnoreCase("team-c")) {
			startNewMobile(MRConstants.AARP_TELESALES_AGENT_PAGE_URL);
		} else if (MRScenario.environment.equalsIgnoreCase("stage")) {
			startNewMobile(MRConstants.AARP_TELESALES_AGENT_PAGE_URL_STAGE);
		}else if (MRScenario.environment.contains("digital-uatv2")) {
			startNewMobile(MRConstants.AARP_TELESALES_AGENT_PAGE_URL_Team);
		}
	}

	/* Added for Mobile */

	public AcquisitionHomePageMobile navigateToPage(String page) {
		String pageURL = driver.getCurrentUrl() + page;
		System.out.println("==pageURL==" + pageURL);
		driver.navigate().to(pageURL);
		return null;
	}

	public AcquisitionHomePageMobile validateCallSamOnTablet() throws InterruptedException {
		boolean present;
		try {
			validateNew(callsam);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			return new AcquisitionHomePageMobile(driver);
		} else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
		return null;
	}

	public AcquisitionHomePageMobile validateCallSamContentOnTablet() throws InterruptedException {
		Actions action = new Actions(driver);
		// WebElement element = callsam;
		action.moveToElement(callsam).perform();
		String toolTipText = callsamtooltip.getText();
		System.out.println("====================================================================");
		System.out.println(toolTipText);
		System.out.println("====================================================================");

		if (CallSam.equalsIgnoreCase(toolTipText)) {
			System.out.println("Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent");
			return new AcquisitionHomePageMobile(driver);
		} else
			System.out.println(
					"No Call sticky action menu didn't roll out and doesn't contain the text Call a Licensed Insurance Agent");
		return null;
	}

	public void navigateToShopPDPpage() {
		jsClickMobile(Menu);

		waitforElement(ShopForaplan);
		if (ShopForaplan.isDisplayed()) {
			Actions actions = new Actions(driver);
			actions.moveToElement(ShopForaplan);
			actions.build().perform();
			System.out.println("Hover over Shop for a Plan completed");
		}
		WebElement PDPplansLink = driver.findElement(By.xpath(
				"//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'prescription-drug-plans.html')]"));
		jsClickNew(PDPplansLink);
	}

	public GetStartedPageMobile clickDCERedesignLinkonShopPDPpage() {
		WebElement DCELink = driver.findElement(
				By.xpath("//a[contains(@href,'drug-cost-estimator') and contains(text(), 'Prescription Drug Costs')]"));
		validateNew(DCELink);
		jsClickNew(DCELink);
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPageMobile(driver);
		return null;
	}

	public KeywordSearchAARPMobile searchfield() {
		validate(searchfield);
		System.out.println("search field is seen on AARP site  ==>" + searchfield.isDisplayed());
		validate(searchbutton);
		System.out.println("search button is seen on AARP site ==>" + searchbutton.isDisplayed());
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
			return new KeywordSearchAARPMobile(driver);
		return null;
	}

	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	public GetStartedPageMobile navigateToDCERedesignFromHome() throws InterruptedException {
		MobileMenuAccessDCE();
		validateNew(getStarted);
		// jsClickNew(getStarted);

		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPageMobile(driver);
		return null;
	}

	public void openVPPPage() {
		if (!(MRScenario.getProps() == null)) {
			if (MRScenario.environment.equalsIgnoreCase("team-acme-aarp")) {
				startNewMobile(AARP_ACQISITION_PAGE_URL.replace("team-acme-aarp", "team-acme").replace("www.", ""));
			} else if (MRScenario.environment.equalsIgnoreCase("team-acme")) {
				startNewMobile(UMS_ACQISITION_PAGE_URL.replace("www.", ""));
			} else if (MRScenario.environment.equalsIgnoreCase("offline-stage-aarp")) {
				startNewMobile(AARP_ACQISITION_PAGE_URL.replace("offline-stage-aarp", "offline-stage"));
			} else if (MRScenario.environment.equalsIgnoreCase("offline-stage")) {
				startNewMobile(UMS_ACQISITION_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("stage-aarp")) {
				startNewMobile(AARP_ACQISITION_PAGE_URL.replace("stage-aarp", "stage"));
			} else if (MRScenario.environment.equalsIgnoreCase("stage")) {
				startNewMobile(UMS_ACQISITION_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("offline-prod-aarp")) {
				startNewMobile(AARP_ACQISITION_OFFLINE_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("offline-prod")) {
				startNewMobile(UMS_ACQISITION_OFFLINE_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("prod-aarp")) {
				startNewMobile(AARP_ACQISITION_PROD_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("prod")) {
				startNewMobile(UMS_ACQISITION_PROD_PAGE_URL);
			}
		} else { // For jenkins job
			String jenkinsRunnerFiles = MRScenario.getRunnerFileName();
			if (MRScenario.environment.equalsIgnoreCase("team-acme") || MRScenario.environment.equalsIgnoreCase("stage")
					|| MRScenario.environment.equalsIgnoreCase("offline-stage")) {
				for (String rname : jenkinsRunnerFiles.split(",")) {
					if (rname.toUpperCase().contains("health-plans") && rname.toUpperCase().contains("ULAYER")) {
						if (MRScenario.environment.equalsIgnoreCase("team-acme"))
							startNewMobile(AARP_ACQISITION_PAGE_URL.replace("www.", ""));
						else
							startNewMobile(AARP_ACQISITION_PAGE_URL);
					}
					if (rname.toUpperCase().contains("health-plans") && rname.toUpperCase().contains("BLAYER")) {
						if (MRScenario.environment.equalsIgnoreCase("team-acme"))
							startNewMobile(UMS_ACQISITION_PAGE_URL.replace("www.", ""));
						else
							startNewMobile(UMS_ACQISITION_PAGE_URL);
					}
				}
			}
			if (MRScenario.environment.equalsIgnoreCase("offline")) {
				for (String rname : jenkinsRunnerFiles.split(",")) {
					if (rname.toUpperCase().contains("health-plans") && rname.toUpperCase().contains("ULAYER"))
						startNewMobile(AARP_ACQISITION_OFFLINE_PAGE_URL);
					if (rname.toUpperCase().contains("health-plans") && rname.toUpperCase().contains("BLAYER"))
						startNewMobile(UMS_ACQISITION_OFFLINE_PAGE_URL);
				}
			}
			if (MRScenario.environment.equalsIgnoreCase("prod")) {
				for (String rname : jenkinsRunnerFiles.split(",")) {
					if (rname.toUpperCase().contains("health-plans") && rname.toUpperCase().contains("ULAYER"))
						startNewMobile(AARP_ACQISITION_PROD_PAGE_URL);
					if (rname.toUpperCase().contains("health plans") && rname.toUpperCase().contains("BLAYER"))
						startNewMobile(UMS_ACQISITION_PROD_PAGE_URL);
				}
			}
		}
		System.out.println("Current mobile page URL: " + driver.getCurrentUrl());

	}

	public void validateCallSam() throws InterruptedException {
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
		/*
		 * else System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
		 */

	}

	public void validateCallpopup() throws InterruptedException {

		/* Mobile does not show callSam popup hence verifying callSam icon */
		validateNew(callsam, 5);
		// // CommonUtility.checkPageIsReady(driver);
		// System.out.println(callsam.getText());
		// callsam.click();
		// System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		// driver.switchTo().activeElement();
		// System.out.println(CallSamTFN.getText());
		// // CallSamTFNClose.click();
		// // validateNew(callsam);
		// // return null;
		// if (CallSamTFN.getText().isEmpty()) {
		// // return null;
		// Assert.fail("TFN number was not found on the SAM call Popup");
		// } else {
		// CallSamTFNClose.click();
		// validateNew(callsam);
		// // return new AcquisitionHomePage(driver);
		// }
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
			System.out.println("@@@@@@@@@ Able to find Chat TFN widget @@@@@@@@@");
			// validateChatSamContent();
		}

	}

	public void verifyChatpopup() throws InterruptedException {
		// CommonUtility.checkPageIsReady(driver);
		chatsam.click();
		System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");

	}

	public AboutUsPageMobile aboutUsClick() {
		validateNew(footerAboutUsLink);
		// footerAboutUsLink.click();
		jsClickNew(footerAboutUsLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (getTitle().contains("About")) {
			return new AboutUsPageMobile(driver);
		}
		return null;

	}

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
		} else
			Assert.fail(
					"No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
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

	public ContactUsUmsPageMobile contactUsClick() {
		validateNew(footerContactUsLink);
		// footerContactUsLink.click();
		jsClickNew(footerContactUsLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("contact-us")) {
			return new ContactUsUmsPageMobile(driver);
		}
		return null;

	}

	public AgentsAndBrokersPageMobile agentsAndBrokersClick() {
		validateNew(footerAgentsnBrokersLink);
		// footerAgentsnBrokersLink.click();
		jsClickNew(footerAgentsnBrokersLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("health-insurance-brokers")) {
			return new AgentsAndBrokersPageMobile(driver);
		}
		return null;

	}

	public VisitorProfilePageMobile navigateToVisitorProfilePage() {
		waitforElement(shoppingCartIcon);
		// shoppingCartIcon.click();
		jsClickNew(shoppingCartIcon);
		jsClickNew(guestProfileLink);
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
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
		// validateNew(footerRequestforAssistancelink);
		validateNew(footerAccessibilitylink);
		validateNew(aarpOrgLink);
		validateNew(medicareAdvantagePlansLink);
		validateNew(medicareSpecialNeedsPlansLink);
		validateNew(medicareSupplementInsurancePlansLink);
		validateNew(medicarePrescriptionDrug_PlansLink);
		validateNew(learnAboutMedicareLink);
		// validateNew(viewAllDisclaimerInformationLink, 20);

	}

	@FindBy(xpath = "(//*[contains(text(),'Please enter a valid email address')])[3]")
	private WebElement ErrorEmailAddress;

	@FindBy(xpath = "//input[@name='newsletter-input1']")
	private WebElement EmailFirstName;

	@FindBy(xpath = "//input[@name='newsletter-input2']")
	private WebElement EmailLastName;

	@FindBy(xpath = "//input[@name='newsletter-input3']")
	private WebElement EmailAddress;

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement SubmitEmail;

	@FindBy(xpath = "//*[contains(text(),'Please enter First Name')]")
	private WebElement ErrorFirstName;

	@FindBy(xpath = "//*[contains(text(),'Please enter Last Name')]")
	private WebElement ErrorLastName;

	@FindBy(xpath = "//div[@class='confirmationtext']/p[1]/b")
	private WebElement Thankyou;

	public void enterAndvalidateEmail() {

		threadsleep(8);

		// if(SubmitEmail.isDisplayed()) {
		int size = driver.findElements(By.xpath("//span[contains(text(),'Sign Up')]")).size();
		System.out.println("size of sign up" + size);
		if (size > 0) {
			jsClickNew(driver.findElement(By.xpath("//span[contains(text(),'Sign Up')]")));
			threadsleep(4);
			Assert.assertEquals(ErrorEmailAddress.getText(), "Please enter a valid email address");
			threadsleep(4);
			EmailFirstName.sendKeys("abc");
			EmailLastName.sendKeys("def");
			EmailAddress.sendKeys("a@gmail.com");
			jsClickNew(driver.findElement(By.xpath("//span[contains(text(),'Sign Up')]")));
		} else {
			// SubmitEmail.click();
			jsClickNew(SubmitEmail);
			threadsleep(4);
			Assert.assertEquals(ErrorFirstName.getText(), "Please enter First Name");
			threadsleep(2);
			Assert.assertEquals(ErrorLastName.getText(), "Please enter Last Name");
			threadsleep(2);
			Assert.assertEquals(ErrorEmailAddress.getText(), "Please enter a valid email address");
			threadsleep(4);
			EmailFirstName.sendKeys("abc");
			EmailLastName.sendKeys("def");
			EmailAddress.sendKeys("a@gmail.com");
			// SubmitEmail.click();
			jsClickNew(SubmitEmail);
		}

		threadsleep(4);
		if (Thankyou.getText().equalsIgnoreCase("Thank you!")) {
			Assertion.assertTrue(true);
		}

	}

	public TermsnConditionsAARPPageMobile termsnconditionsFooterClick() {
		validate(footerTermsnConditionsLink);
		scrollToView(footerTermsnConditionsLink);
		jsClickNew(footerTermsnConditionsLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(footerLinkHeader);
		if (driver.getCurrentUrl().contains("terms-of-use")) {
			return new TermsnConditionsAARPPageMobile(driver);
		}
		return null;
	}

	public EnterZipCodePage enterZipCode() {
		return new EnterZipCodePage(driver);
	}

	public void validateAARPlogo() {
		// TODO Auto-generated method stub
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

	public void validateProActiveChatpopup() {
		validateNew(ProActivePopup_ChatBtn);
		jsClickNew(ProActivePopup_ChatBtn);
		System.out.println("@@@@@@@@@@@@@@@ Pro-Avtive Chat Button Clicked @@@@@@@@@@@@@@@");
		validateandcloseChat();
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

	public void validatevisitorprofile() {
		pageloadcomplete();

		if (visitorprofileicon.isDisplayed()) {
			scrollToView(visitorprofileicon);
			Actions actions = new Actions(driver);
			actions.moveToElement(visitorprofileicon).perform();
			// jsMouseOver(visitorprofileicon);
			// visitorprofileicon.click();
			System.out.println("Hover over visitor profile completed");
		}

		WebElement CreateProfile = driver.findElement(By.xpath("//h3[@id='guest-profile']"));
		WebElement VPSignIn = driver.findElement(
				By.xpath("//a[contains(text(), 'Sign In') and not(contains(@aria-labelledby ,'VPSignIn'))]"));

		jsClickNew(visitorprofileicon);

		if (driver.getCurrentUrl().contains("profile")) {
			Assert.assertTrue(true);
			System.out.println("Visitor Profile Page opens successsfully");
		} else {
			Assert.fail("Visitor Profile page is not opening up");
		}

	}

	public void validateLogo() {
		// TODO Auto-generated method stub
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			validateNew(AARPlogo);
			WebElement AARPLogo = driver.findElement(By.xpath("//a[contains(@id, 'aarpSVGLogo')]"));
			WebElement UHCLogo = driver.findElement(By.xpath("//a[contains(@id, 'uhcSVGLogo')]"));
			if (AARPLogo.isDisplayed() && AARPLogo.isEnabled() && !UHCLogo.isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("Correct AARP Logo is Displayed");
			} else {
				Assert.fail("AARP logo is not dispalyed for Ulayer");
			}
		} else {
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

	public GetStartedPageMobile navigateToDCERedesignFromSubNav() {
		// navigateToMenuLinks(ShopForaplan, headerDrugCostEstimatorLink);

		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPageMobile(driver);
		return null;

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
			// Assertion.assertTrue("Chat Icon not displayed on " + pageName + "", false);
		}
	}

	public void validateChatpopup() throws InterruptedException {
		// CommonUtility.checkPageIsReady(driver);

		validateNew(chatsam);
		System.out.println(chatsam.getText());
		jsClickNew(chatsam);
		System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");
		// validateandcloseChat();
		/*
		 * chatsamtooltip.click(); driver.switchTo().activeElement();
		 * System.out.println(ChatSamHead.getText()); ChatSamTFNClose.click();
		 * validateNew(chatsam);
		 */
		// return null;
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

	public void validateChatProActive() {
		boolean present;
		CommonUtility.waitForPageLoadNew(driver, ProActivePopup, 30);
		validateNew(ProActivePopup);
		validateNew(ProActivePopup_Close);
		validateNew(ProActivePopup_ExitBtn);
		validateNew(ProActivePopup_ChatBtn);
		present = true;
		if (ProActivePopup.isEnabled() && ProActivePopup_Close.isEnabled() && ProActivePopup_ExitBtn.isEnabled()
				&& ProActivePopup_ChatBtn.isEnabled()) {
			System.out.println("@@@@@@@@@ Able to find Pro-Active Chat widget @@@@@@@@@");
		} else {
			System.out.println("@@@@@@@@@ No Pro-Active widget @@@@@@@@@");
			Assert.fail();
		}
	}

	public void validateHeaderLinks() {
		MobileMenuMain();
		scrollToView(headerSignInLink);
		// validateNew(headerSignInLink);
		// validateNew(headerRegisterLink);
		scrollToView(headerRegisterLink);
		jsClickNew(headerRegisterLink);
		clickBrowserBackButton();
		validateNew(visitAARPLink);
		validateNew(AARPlogo);
		validateNew(visitorprofileicon);
	}

	public void clickRequestAsistancce() {
		validateNew(footerRequestforAssistancelink);
		if (proactiveChatExitBtn != null)
			proactiveChatExitBtn.click();
		footerRequestforAssistancelink.click();
		CommonUtility.waitForPageLoadNew(driver, requestAssistanceModal, 30);
		validateNew(requestAssistanceTitle);
		validateNew(requestAssistanceAgentID);
		requestAssistanceClose.click();
		waitforElementDisapper(By.id("cobrowse-disclaimer"), 30);
	}

	public SiteMapAARPPageMobile siteMapFooterClick1() {
		validateNew(footerSiteMapLink);
		scrollToView(footerSiteMapLink);
		jsClickNew(footerSiteMapLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(siteMapHeader);
		if (driver.getCurrentUrl().contains("sitemap.html")) {
			return new SiteMapAARPPageMobile(driver);
		}
		return null;
	}

	public DrugCostEstimatorPageMobile navigateToDCEToolFromHome() {
		MobileMenuAccessDCE();
		validateNew(getStarted);
		jsClickNew(getStarted);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("health-plans/estimate-drug-costs.html"))
			return new DrugCostEstimatorPageMobile(driver);
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

	public void checkLinkContact(String language) {

		WebElement lnkContact;
		if (language.equalsIgnoreCase("english")) {
			lnkContact = driver.findElement(By.xpath("//a[contains(text(),'contact')]"));
		} else {
			lnkContact = driver.findElement(By.xpath("//a[contains(@title,'" + language + "')]"));
		}

		scrollToView(lnkContact);
		validateNew(lnkContact);
		jsClickNew(lnkContact);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("contact-us.html")) {
			System.out.println("Contact( " + language + " ) link is clicked Successfully");

		} else {
			Assert.fail("Error Clicking Contact( " + language + " ) link");
		}
		// driver.navigate().back();
		WebElement headLogo = driver.findElement(By.xpath("//div[contains(@class,'logo aarplogo')]"));
		scrollToView(headLogo);
		headLogo.click();
		CommonUtility.checkPageIsReadyNew(driver);
		clickViewDisclaimerInfoLink();

	}

	public void proceedToLeaveAARP() {
		if (validate(leaveAARPMedicarePlansDialog)) {
			jsClickNew(proceedLeaveAARPMedicare);
			waitForPageLoadSafari();
			CommonUtility.checkPageIsReadyNew(driver);
		}
	}

	public void clickComplaintFormLink() {
		/* Open Disclaimer Link section on mobile to validate complaint form */
		disclaimerLnkMobile.click();
		WebElement lnkComplaintForm = driver.findElement(By.xpath("(//a[contains(text(),'Complaint Form')])[1]"));
		validateNew(lnkComplaintForm);
		scrollToView(lnkComplaintForm);
		jsClickNew(lnkComplaintForm);
		proceedToLeaveAARP();
		if (driver.getCurrentUrl().contains("medicare.gov/MedicareComplaintForm")) {
			System.out.println("Successfully clicked Complaint Form link");
			Assert.assertTrue(true);

		} else {
			Assert.fail("Error clicking Complaint Form link");
		}
		driver.navigate().back();
		CommonUtility.checkPageIsReadyNew(driver);
		clickViewDisclaimerInfoLink();
	}

	public void selectStateForGeotargeting() {
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
		WebElement stateDropDown = driver.findElement(By.id("state-select"));
		scrollToView(stateDropDown);
		waitTllOptionsAvailableInDropdown(stateDropDown, 5);

		WebElement stateGeotargeting = driver.findElement(By.xpath("(//select[@id='state-select']//option)[2]"));
		// scrollToView(stateGeotargeting);
		// stateGeotargeting.click();
		jsClickNew(stateGeotargeting);
		waitforElementNew(stateGeotargeting, 5);
		System.out.println("State selected for Geotagging: " + stateGeotargeting.getText());
		waitforElementNew(stateGeotargeting, 5);
		jsClickNew(backToTop);
	}

	// method to click View Disclaimer Information link present in Footer
	public void clickViewDisclaimerInfoLink() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(viewAllDisclaimerInformationLink);
		jsClickNew(viewAllDisclaimerInformationLink);
		sleepBySec(2);
		WebElement content = driver.findElement(By.xpath("//div[contains(@class,'hideLink')]"));
		if (content.isDisplayed() && content.isEnabled()) {
			System.out.println("View Diclaimer Information Link clicked Successfully");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error clicking View Diclaimer Information Link ");
		}
	}

	@FindBy(xpath = "//div[contains(text(),'Accessibility')]")
	private WebElement Accessibility;

	public void Accessibility() {

		// threadsleep(6);
		pageloadcomplete();
		// Accessibility.click();
		jsClickNew(Accessibility);
		threadsleep(5000);
		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://www.uhc.com/legal/accessibility");
		if (driver.getCurrentUrl().contains("accessibility")) {
			Assertion.assertTrue(true);
		}
	}

	public void validateAssistancelink(String language) {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement lnkAssistance = null;
		if (language.equalsIgnoreCase("english")) {
			lnkAssistance = driver.findElement(By.xpath("(//a[contains(@href,'legal/medicare')])[1]"));
		} else if (language.equalsIgnoreCase("spanish")) {
			lnkAssistance = driver.findElement(By.xpath("(//a[contains(@href,'legal/medicare')])[2]"));
		} else if (language.equalsIgnoreCase("chinese")) {
			lnkAssistance = driver.findElement(By.xpath("(//a[contains(@href,'legal/medicare')])[3]"));
		}

		scrollToView(lnkAssistance);
		validateNew(lnkAssistance);
		sleepBySec(2);
		switchToNewTabNew(lnkAssistance);
		if (driver.getCurrentUrl().contains("https://www.uhc.com/legal/medicare-plans")) {
			System.out.println("Assistance link( " + language + " ) clicked Successfully ");
		} else {
			Assert.fail("Assistance link( " + language + " ) did not clicked Successfully ");
		}
		driver.close();
		driver.switchTo().window(CommonConstants.getMainWindowHandle());
		CommonUtility.checkPageIsReadyNew(driver);
	}

	// method to click Hide Disclaimer Information link present in Footer
	public void clickHideDisclaimerInfoLink() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(hideDiscliamerInformation);
		jsClickNew(hideDiscliamerInformation);
		sleepBySec(2);
		WebElement content = driver.findElement(By.xpath("//div[contains(@class,'hideLink')]"));
		if (!content.isDisplayed() && content.isEnabled()) {
			System.out.println("Hide Diclaimer Information Link clicked Successfully");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error clicking Hide Diclaimer Information Link ");
		}
	}

	@FindBy(xpath = "//a[@id='gfn_lnk_row2_1']")
	private WebElement MedicareAdvantagePlans;

	@FindBy(xpath = "//a[@id='gfn_lnk_row2_2']")
	private WebElement DualSpecialNeedsPlans;

	@FindBy(xpath = "//a[@id='gfn_lnk_row2_3']")
	private WebElement MedicareSupplementInsurancePlans;

	@FindBy(xpath = "//span[contains(text(),'Medicare Prescription Drug Plans')]")
	private WebElement MedicarePrescriptionDrugPlans;

	@FindBy(xpath = "//a[@id='gfn_lnk_row2_5']")
	private WebElement footerMedicarePrescriptionDrugPlans;

	@FindBy(xpath = "//span[contains(text(),'Medicare Education')]")
	private WebElement MedicareEducation;

	@FindBy(xpath = "//a[@class='back-to-top']")
	private WebElement BackToTop;

	public void MedicareAdvantagePlans() {
		threadsleep(6);
		// MedicareAdvantagePlans.click();
		jsClickNew(MedicareAdvantagePlans);
		threadsleep(5);
		if (driver.getCurrentUrl().contains("shop/medicare-advantage-plans.html")) {
			Assert.assertTrue(true);
			System.out.println("MA Plan Page open: URL-->  " + driver.getCurrentUrl());
		} else {
			Assert.fail("Error loading MA Link");
		}
		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://www.stage-aarpmedicareplans.uhc.com/shop/medicare-advantage-plans.html");
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			Assertion.assertTrue(true);
		}

	}

	@FindBy(xpath = "//*[@id='enrollmentPopup']/..")
	private WebElement savedPlansPopup;

	@FindBy(xpath = "//*[@id='enrollmentPopup']/..//*[@class='uhc-modal__close']")
	private WebElement savedPlansPopupCloseIcon;

	/**
	 * This method used to navigate to new visitor profile dashboard
	 * 
	 * @return
	 */
	public VisitorProfilePageMobile navigateToNewVisitorProfilePage() {
		try {
			if (savedPlansPopup.isDisplayed()) {
				savedPlansPopupCloseIcon.click();
			}
		} catch (Exception e) {
			System.out.println("Saved Plans modal not displayed");
		}
		waitforElement(shoppingCartIcon);
		shoppingCartIcon.click();
		// guestProfileLink.click();
		jsClickNew(guestProfileLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("profile")) {
			System.out.println("Navigated to Visitor profile page");
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			Assert.fail("User not navigated to Visitor profile page");
		}
		return null;
	}

	public void DualSplNeedPlans() {

		threadsleep(6);
		// DualSpecialNeedsPlans.click();
		jsClickNew(DualSpecialNeedsPlans);
		threadsleep(5);
		if (driver.getCurrentUrl().contains("shop/dual-special-needs-plans.html")) {
			Assert.assertTrue(true);
			System.out.println("DSNP Plan Page open: URL--> " + driver.getCurrentUrl());
		} else {
			Assert.fail("Error loading DSNP Link");
		}
		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://www.stage-aarpmedicareplans.uhc.com/shop/dual-special-needs-plans.html");
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			Assertion.assertTrue(true);
		}

	}

	public void Medicaresupplementinsuranceplans() {

		threadsleep(6);
		// MedicareSupplementInsurancePlans.click();
		scrollToView(MedicareSupplementInsurancePlans);
		jsClickNew(MedicareSupplementInsurancePlans);
		threadsleep(5);
		if (driver.getCurrentUrl().contains("shop/medicare-supplement-plans.html")) {
			Assert.assertTrue(true);
			System.out.println("MS Plan Page open: URL-->" + driver.getCurrentUrl());
		} else {
			Assert.fail("Error loading MS link");
		}
		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://www.stage-aarpmedicareplans.uhc.com/shop/medicare-supplement-plans.html");
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			Assertion.assertTrue(true);
		}
	}

	@FindBy(xpath = "//*[contains(@id, 'aarplink')]")
	private WebElement visitAARPHeaderLink;

	public void clickVisitAARPHeaderLink() {
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			jsClickNew(visitAARPHeaderLink);
			proceedToLeaveAARP();
			if (!driver.getCurrentUrl().contains("aarp.org"))
				Assert.fail("Visit AARP link did not lead to the right page");
		}
	}

	public void MedicarePrescriptionDrugPlans() {

		threadsleep(6);
		// MedicarePrescriptionDrugPlans.click();
		jsClickNew(footerMedicarePrescriptionDrugPlans);
		threadsleep(5);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("shop/prescription-drug-plans.html")) {
			Assert.assertTrue(true);
			System.out.println("PDP Plan Page open: URL-->" + driver.getCurrentUrl());
		} else {
			Assert.fail("Error loading PDP link");
		}
		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://www.stage-aarpmedicareplans.uhc.com/shop/prescription-drug-plans.html");
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			Assertion.assertTrue(true);
		}
	}

	public void MedicareEducation() {
		threadsleep(6);
		// MedicareEducation.click();
		jsClickNew(MedicareEducation);
		threadsleep(5);
		if (driver.getCurrentUrl().contains("medicare-education.html")) {
			Assert.assertTrue(true);
			System.out.println("Medicare Education Homepage open: URL-->" + driver.getCurrentUrl());
		} else {
			Assert.fail("Error loading Medicare Education Homepage link");
		}
		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://www.stage-aarpmedicareplans.uhc.com/medicare-education.html");
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			Assertion.assertTrue(true);
		}

	}

	public ProviderSearchPageMobile clicksOnProviderToolFromGlobalHeader() {

		// Actions action = new Actions(driver);
		// action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		jsMouseOver(navigationSectionHomeLink);
		jsMouseOver(ourPlansHoverLink);
		validateNew(providerSearchFromGlobalHeader);

		switchToNewTabNew(providerSearchFromGlobalHeader);

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {

			return new ProviderSearchPageMobile(driver);

		}
		return null;
	}

	public void backtotop() {
		threadsleep(6);
		// BackToTop.click();
		jsClickNew(BackToTop);
		threadsleep(5);
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			Assertion.assertTrue(true);
		}

	}

	public void clickonFindanAgentlinkfromArticle(String ExpectedUHCAgentURL) {

		validateNew(FindAnAgent);
		CommonUtility.waitForPageLoadNew(driver, FindAnAgent, 30);
		String parentWindow = driver.getWindowHandle();
		// FindAnAgent.click();
		jsClickNew(FindAnAgent);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}

		/*
		 * CommonUtility.checkPageIsReadyNew(driver); String CurrentUHCAgentURL =
		 * driver.getCurrentUrl();
		 * System.out.println("myuhcagent Page is displayed : "+CurrentUHCAgentURL);
		 * System.out.println("Expected myuhcagent URL: "+ExpectedUHCAgentURL);
		 * 
		 * if(ExpectedUHCAgentURL.equalsIgnoreCase(CurrentUHCAgentURL)) { System.out.
		 * println("****************myuhcagent Page is displayed  ***************");
		 * 
		 * Assert.assertTrue(true); } else {
		 * Assert.fail("****************myuhcagent Page is not loaded ***************");
		 * }
		 */
		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentUHCAgentURL = driver.getCurrentUrl();
		String ActualCurrentUHCAgentURL = CurrentUHCAgentURL.substring(0, 27).trim();
		System.out.println("myuhcagent Page is displayed : " + ActualCurrentUHCAgentURL);
		System.out.println("Expected myuhcagent URL: " + ExpectedUHCAgentURL);
		System.out.println("Actual myuhcagent URL: " + ActualCurrentUHCAgentURL);

		if (ExpectedUHCAgentURL.equalsIgnoreCase(ActualCurrentUHCAgentURL)) {
			System.out.println("****************myuhcagent Page is displayed  ***************");

			Assert.assertTrue(true);
		} else {
			Assert.fail("****************myuhcagent Page is not loaded ***************");
		}

		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void clickVisitAARPFooterLink() {
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			switchToNewTabNew(visitAARPFooterLink);
			proceedToLeaveAARP();
			if (!driver.getCurrentUrl().contains("aarp.org")) {
				Assert.fail("Visit AARP link did not lead to the right page");
			} else {
				Assert.assertTrue(true, "Navigated to AARP org page");
				// driver.close();
				// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
			}
		}

	}

	@FindBy(xpath = "//div[contains(@class,'companyNameHeader')]//*[contains(text(),'UnitedHealthcare Insurance Company')]")
	private WebElement UHCICSubTitle;

	public void validateSubtitle() {
		threadsleep(5);
		if (UHCICSubTitle.isDisplayed()) {
			System.out.println("validating the sub header");
			// Assertion.assertEquals(UHCICSubTitle.getText(), "UnitedHealthcare Insurance
			// Company (UnitedHealthcare)");
			if (UHCICSubTitle.getText().contains("UnitedHealthcare Insurance Company ")) {
				Assertion.assertTrue(true);
			}
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

	}
	
	@FindBy(xpath = "//*[contains(@class,'uhc-tempo-button') and contains(text(),'Find an Agent')]")
	private WebElement requestAgentBtn;
	
	public pages.mobile.acquisition.commonpages.RequestHelpAndInformationPage navigateToMaMoreHelpAndInfo() {

		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(moreHelpInfoLink);
		actions.click().build().perform();
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		//CommonUtility.waitForPageLoadNew(driver, requestAgentApptDropdown, 60);
		if (validateNew(requestAgentBtn)) {
			return new pages.mobile.acquisition.commonpages.RequestHelpAndInformationPage(driver);
		}
		return null;
	}

	

	@FindBy(xpath = "//a[contains(@href,'https://www.myuhcagent.com/')]")
	private WebElement RightRail_FindAnAgent;

	@FindBy(xpath = "//a[contains(@href,'/shop/connect.html')]")
	private WebElement RequestMoreInformationLink;

	@FindBy(xpath = "(//a[contains(@href,'https://www.myuhcagent.com/')])[1]")
	private WebElement RightRail_FindAnAgentMedsupp;


	public void clickonFindanAgentlink(String ExpectedUHCAgentURL) {
		// threadsleep(10);
		validateNew(RightRail_FindAnAgent);
		CommonUtility.waitForPageLoadNew(driver, RightRail_FindAnAgent, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(RightRail_FindAnAgent);
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

	}

	@FindBy(id = "ghn_lnk_3")
	private WebElement learnaboutMedicare;

	public pages.mobile.acquisition.commonpages.ShopForPlanNavigationPage HoveronalearnaboutMedicare()
			throws InterruptedException {
		waitforElement(learnaboutMedicare);
		if (driver.getClass().toString().toUpperCase().contains("ANDROID")
				|| driver.getClass().toString().toUpperCase().contains("IOS")) {
			System.out.println("Hove Action skipped on Mobile");
		} else {
			if (learnaboutMedicare.isDisplayed()) {
				Actions action = new Actions(driver);
				action.moveToElement(learnaboutMedicare).build().perform();
				jsMouseOver(learnaboutMedicare);
				return new pages.mobile.acquisition.commonpages.ShopForPlanNavigationPage(driver);
			} else {
				return null;
			}
		}
		return new pages.mobile.acquisition.commonpages.ShopForPlanNavigationPage(driver);
	}

	public pages.mobile.acquisition.commonpages.ShopForPlanNavigationPage Hoveronaplan() throws InterruptedException {
		waitforElement(ShopForaplan);

		if (driver.getClass().toString().toUpperCase().contains("ANDROID")
				|| driver.getClass().toString().toUpperCase().contains("IOS")) {
			System.out.println("Hove Action skipped on Mobile");
		} else {
			if (ShopForaplan.isDisplayed()) {
				// Actions action = new Actions(driver);
				// action.moveToElement(ShopForaplan).build().perform();
				jsMouseOver(ShopForaplan);
				return new pages.mobile.acquisition.commonpages.ShopForPlanNavigationPage(driver);
			} else {
				return null;
			}
		}
		return new pages.mobile.acquisition.commonpages.ShopForPlanNavigationPage(driver);
	}

	public void clickUnitedHealthcareMedicareSolutions() {
		// threadsleep(8);
		threadsleep(5000);
		// UnitedHealthcareMedicareSolutions.click();
		jsClickNew(UnitedHealthcareMedicareSolutions);
	}

	public LearnAboutMedicareHomePageMobile clickLearnMoreOnHomePage() {

		validateNew(learnAboutMedicareHomeScreen);
		jsClickNew(learnAboutMedicareHomeScreen);
		waitForPageLoadSafari();
		String urlCheck = driver.getCurrentUrl();
		if (urlCheck.contains("medicare-education.html")) {
			return new LearnAboutMedicareHomePageMobile(driver);
		} else {
			return null;
		}
	}
	
	public void hoverOverShopForPlan() {
		waitforElement(ShopForaplan);
		if (ShopForaplan.isDisplayed()) {
			jsMouseOver(ShopForaplan);
			System.out.println("Hover over Shop for a Plan completed");
		}
	}

	
	public boolean checkZipCompErrorInSubNav() {
		hoverOverShopForPlan();
		sleepBySec(3);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(OurPlans_zipfield);
		validateNew(FindPlansButton1);
		WebElement errorMsg = driver.findElement(By.xpath("//span[@class='field-error-msg']"));
		jsClickNew(FindPlansButton1);
		waitforElementNew(errorMsg);
		if (errorMsg.isDisplayed()) {
			System.out.println("Zip Component present in Sub Nav");
			System.out.println("Error Message Displayed: " + errorMsg.getText());
			return true;
		} else
			return false;
	}
	
	public void validateUrl(String url) {
		threadsleep(6);
		String parentWindow = driver.getWindowHandle();
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		System.out.println(driver.getTitle());
		String str = driver.getTitle();
		// Assertion.assertTrue( "Title mismatch for dental
		// directory",driver.getTitle().equals(url));
		if (str.equals(url)) {
			Assertion.assertTrue(true);
		}

	}
}