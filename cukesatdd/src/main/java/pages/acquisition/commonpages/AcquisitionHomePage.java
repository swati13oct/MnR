package pages.acquisition.commonpages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.isinsuranceagent.IsInsuranceAgent;
import pages.acquisition.ole.OLETestHarnessPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;

/**
 * @author pperugu
 *
 */
public class AcquisitionHomePage extends GlobalWebElements {

//	@FindBy(xpath = "//*[contains(@id,'zipcodemeded') or contains(@id,'cta-zipcode')]")
	@FindBy(xpath = "//*[contains(@id,'zipcodemeded') or contains(@id,'cta-zipcode')]")
	private WebElement zipCodeField;

	@FindBy(xpath = "//*[contains(@id,'zipcodemeded-0')]")
	private WebElement zipCodeShopField;

	@FindBy(xpath = "//input[contains(@id,'zipcodemeded')]")
	private WebElement zipCodeMedicareField;

	@FindBy(xpath = "//*[contains(@id,'zipcodemeded')][1]//following-sibling::button//*[contains(text(),'Shop Plans')]")
	private WebElement viewShopPlansButton;

	// @FindBy(xpath = "//p[contains(text(),'UnitedHealthcare Insurance Company
	// (UnitedHealthcare)')]")
	@FindBy(xpath = "//*[contains(text(),'UnitedHealthcare Insurance Company or an affiliate')]")
	private WebElement UHCICSubTitle;

	// @FindBy(xpath =
	// "//*[contains(@id,'zipcodemeded')][1]//following-sibling::button//*[contains(text(),'Get
	// Started')]")
	@FindBy(xpath = "(//*[contains(@id,'zipcodemeded')][1]//following-sibling::button)[1]")
	// @FindBy(xpath = "//button//span[contains(text(), 'Shop')]")
	private WebElement ShopEnrollButton;

	// @FindBy(xpath =
	// "(//*[contains(@id,'zipcodemeded')][1]//following-sibling::button)[1]")
	@FindBy(xpath = "//button//span[contains(text(), 'Shop')]")
	private WebElement ShopdsnpEnrollButton;

	// @FindBy(xpath = "(//button[contains(@class,'zip-button')])")
	// @FindBy(xpath = "(//button[contains(@class,'zip-button')])[2]")
	@FindBy(xpath = "//button[contains(@class,'zip-button')]")
	private WebElement LearnMedicareMedsuppEnrollButton;

	@FindBy(id = "zipcode")
	private WebElement healthPlansZipcode;

	@FindBy(className = "fd_myPlans")
	private WebElement myPlansTab;

	@FindBy(id = "dce")
	private WebElement getStartedButton;

	@FindBy(id = "learnfindplanBtn")
	private WebElement learnfindPlansButton;

	@FindBy(id = "Find a pharmacy near you")
	private WebElement pharmacyNearLink;

	// @FindBy(className = "zip-button")
	// @FindBy(xpath = "(//*[@class='zip-button'])[1]")
	@FindBy(xpath = "//*[contains(@class,'uhc-button') and contains(text(),'Find Plans')]")
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

	@FindBy(xpath = "//div[@id='subnav_2']//h3/a[contains(text(),'Provider')]")
	private WebElement providerlocator;

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

	// Updated xpath for DCE link on Home Page
	@FindBy(xpath = "//a[contains(@href,'drug-cost-estimator') and contains(@title, 'Drug Cost Estimator Tool')]")
	public WebElement getStarted;

	// @FindBy(xpath = ".//*[contains(@class,
	// 'meded-article-content__section')]//*[contains(text(), 'Request an
	// Appointment')]")
	@FindBy(xpath = "//*[contains(@class,'uhc-tempo-button') and contains(text(),'Find an Agent')]")
	private WebElement requestAgentBtn;

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

	// @FindBy(xpath = "//*[contains(@id,'zipcodebtn') or (@class='zip-button') and
	// (contains(@dtmid,'plans'))]")
	// @FindBy(xpath = "//*[contains(@class,'uhc-zip-button')]")
	// @FindBy(xpath = "(//*[contains(@class,'zip-button') or
	// contains(@id,'zipcodebtn')])[2]")
	// @FindBy(xpath = "(//button[contains(@class,'zip-button') or
	// contains(@id,'zipcodebtn')])[2]")
	// @FindBy(xpath = "//*[contains(@class,'zip-button') or
	// contains(@id,'zipcodebtn')]"

	@FindBy(xpath = "(//*[contains(@class,'zip-button') or contains(@id,'zipcodebtn')])[1]")
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

	@FindBy(className = "textalign")
	private WebElement countyModal1;

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlans;

	// @FindBy(id = "nav-zipcode")
	@FindBy(xpath = "//input[contains(@id,'nav-zipcode')]")
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

	@FindBy(xpath = "//*[contains(@class,'heading-1') and contains(text(),'Privacy Policy')]")
	public WebElement privacyHeader;

	// @FindBy(xpath = "//*[@class='container
	// meded-article-header']//span[contains(text(),'Health Insurance Broker')]")
	@FindBy(xpath = "//h1//*[contains(text(),'Health Insurance Broker & Agent Tools')]")
	public WebElement brokerHeader;

	/* LearnAboutMedicare link */
	@FindBy(xpath = "//*[@id='ghn_lnk_3']")
	// @FindBy(xpath="//a[contains(text(),'Learn About Medicare')]")
	private WebElement lnkLearnAboutMedicare;

	@FindBy(xpath = "//h3//*[contains(@onclick,'loadCachedProviderSearch')]")
	private WebElement providerSearchFromGlobalHeader;

	// @FindBy(xpath = "//a[contains(text(),'Find a Provider')]")
	@FindBy(xpath = "//div[@class='d-none d-lg-block']//nav[@aria-label='Footer tools and resources navigation']//p[4]/a")
	private WebElement providerSearchFromHomeScreen;

	@FindBy(id = "ghn_lnk_2")
	private WebElement ShopForaplan;

	@FindBy(id = "ghn_lnk_3")
	private WebElement learnaboutMedicare;

	@FindBy(xpath = ".//*[@id='updates-mobile-form']/div/div[2]/button")
	private WebElement submit;

	@FindBy(id = "state-select")
	private WebElement stateDropDown;

	@FindBy(xpath = "//a[contains(@class, 'backtotop1')]")
	private WebElement backToTop_Disclaimer;

	@FindBy(xpath = "//*[@id='more-list-heading']/..//a[contains(@href,'aarp.org')]")
	private WebElement visitAARPFooterLink;

	@FindBy(xpath = "//*[contains(@class, 'aarp-link')]")
	private WebElement visitAARPHeaderLink;

	@FindBy(xpath = "//a[contains(@class, 'back-to-top')]")
	private WebElement backToTop;

	@FindBy(xpath = "//div[contains(@class, 'viewdisclaimerstext')]")
	private WebElement disclaimerInformation;

	@FindBy(css = ".icon-search")
	private WebElement searchbutton;

	@FindBy(id = "search-field")
	private WebElement searchfield;

	//@FindBy(id = "dupIconFlyOut")
	@FindBy(xpath = "//*[contains(@class,'saved_items')]")
	private WebElement shoppingCartIcon;

	//@FindBy(css = "a#visitor-profile-header")
	@FindBy(xpath = "//*[contains(@id,'saved-items-button') and contains(@class,'show-element')]")
	private WebElement lnkProfile;

	@FindBy(xpath = "//button[@id='sam-call-button']//*[contains(@class,'sam__button__text desktop')]")
	private WebElement callsam;

	@FindBy(xpath = "(//div[@ng-show='fedTfn'])[2]/p/span/a/u")
	private WebElement callusonpage;

	@FindBy(xpath = "(//span[contains(text(),'Need Help?')]/following::p/span/a[@class='tel tfn desktop ng-scope'])[1]")
	private WebElement needhelp;

	@FindBy(xpath = "//h3[contains(text(),'Call UnitedHealthcare at:')]/following::p/a[1]")
	private WebElement tfnonpopup;

	// @FindBy(xpath = "//*[@id='sam-call-button']/div/span[1]")
	@FindBy(xpath = "//*[contains(@class,'sam__button__text') and contains(text(),'1-')]")
	private WebElement callsamtooltip;

	@FindBy(xpath = "//*[@id='sam-call-modal']/div/div")
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

	@FindBy(xpath = "//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]")
	private WebElement CallSamModel;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@dtmname,'TFN Link') and contains(text(),'1-')]")
	private WebElement CallSamTFN;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'timezone')]")
	private WebElement CallSamTFNtimezone;

	@FindBy(xpath = "//div[@id='sam-call-modal']//p[contains(text(),'Already a member')]")
	private WebElement CallSamTFNMember;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'modal-close')]")
	private WebElement CallSamTFNClose;

	// String CallSam= "Call a Licensed Insurance Agent";
	String CallSam1855 = "1-855";
	String CallSam1877 = "1-877";

	//@FindBy(xpath = "//*[contains(@id,'sam-button--chat')]")
	
	@FindBy(xpath = "//*[contains(@id,'LPMcontainer')]//*[contains(text(),'Chat Now')]")
	private WebElement chatsam;

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

	@FindBy(xpath = "//div[@class='proactive-offer__button-wrapper']/button[2]")
	private WebElement proActiveChat;

	@FindBy(xpath = "//div[@class='proactive-offer__button-wrapper']")
	private WebElement proActiveChatPopUp;

	@FindBy(xpath = "//input[@id='cancelPreChatForm']")
	private WebElement proActiveChatCancel;

	@FindBy(xpath = "//input[@id='submitChat']")
	private WebElement proActiveChatSubmit;

	@FindBy(xpath = "//*[contains(@class,'commonFields')]//*[contains(@id,'last_name')]")
	private WebElement samChatLastNameField;

	@FindBy(xpath = "//*[contains(@class,'commonFields')]//*[contains(@id,'zip_code')]")
	private WebElement samChatZipField;

	@FindBy(xpath = "//*[contains(@class,'commonFields')]//*[contains(@id,'email') and contains(@name, 'email')]")
	private WebElement samChatEmailField;

	@FindBy(xpath = "//*[contains(@class,'commonFields')]//*[@class='option']/label[contains(text(),'Plan pricing')]")
	private WebElement samChatOptions;
	
	@FindBy(id = "cancelPreChatForm")
	private WebElement samChatCancel;
	

	// @FindBy(xpath
	// ="//*[contains(@class,'prechat__action-buttons')]//*[contains(@class,'servicepatternBtn
	// phone')]")
	@FindBy(xpath = "//*[contains(@id,'offline-form')]//*[contains(@class,'servicepatternBtn phone')]")
	private WebElement samChatConnect;

	@FindBy(xpath = "//*[@id='agent-name']")
	private WebElement ChatSamHead;

	// @FindBy(xpath ="//*[contains(@id,'sp-close-frame')]")
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

	// @FindBy(xpath = "//button[@type='submit']")
	@FindBy(xpath = "//*[@id='nav_search_icon']")
	private WebElement SubmitBtn;

	@FindBy(xpath = "//h1[contains(text(),'Search Results')]")
	private WebElement SearchResults;

	@FindBy(xpath = "//h2[@class='search-results-count']")
	private WebElement SearchResultsCount;

	@FindBy(xpath = "//a[@dtmname='pagination:previous']")
	private WebElement PreviousBtn;

	@FindBy(xpath = "//a[@dtmname='pagination:next']")
	private WebElement NextBtn;

	// @FindBy(xpath = "//button[@class='btn button-transparent clear-button']")
	@FindBy(xpath = "//button[contains(@class,'btn button-transparent clear-button')]")
	private WebElement SecondaryClearBtn;

	@FindBy(xpath = "//input[@id='secondarySearchInput']")
	private WebElement SecondarySearchInput;

	// @FindBy(xpath = "//button[@class='btn button-transparent
	// clear-button']/following::button[1]")
	@FindBy(xpath = "//button[contains(@class,'btn button-transparent clear-button')]/following::button[1]")
	private WebElement SecondarySearchBtn;

	@FindBy(xpath = "//*[contains(@aria-label, 'Close') and contains(@id, 'sp-close-frame')]")
	private WebElement ChatCancelBtn;

	@FindBy(xpath = "//button[@id='details-button' and contains(text(),'Advanced')]")
	private WebElement advancedBtn;

	@FindBy(xpath = "//a[@id='proceed-link']")
	private WebElement proceedLink;

	@FindBy(xpath = "//button[contains(@dtmname,'add my drugs')]")
	public WebElement AddMyDrugsBtn;

	@FindBy(xpath = "//a[contains(@href,'https://www.myuhcagent.com/')]")
	private WebElement RightRail_FindAnAgent;

	@FindBy(xpath = "//a[contains(@href,'/shop/connect.html')]")
	private WebElement RequestMoreInformationLink;

	@FindBy(xpath = "(//a[contains(@href,'https://www.myuhcagent.com/')])[1]")
	private WebElement RightRail_FindAnAgentMedsupp;

	@FindBy(xpath = "(//span[contains(text(),'Submit')])[2]")
	private WebElement SubmitEmail;

	@FindBy(xpath = "//span[contains(text(),'SignUp')]")
	private WebElement SignUpEmail;

	@FindBy(xpath = "//*[contains(text(),'Please enter First Name')]")
	private WebElement ErrorFirstName;

	@FindBy(xpath = "//*[contains(text(),'Please enter Last Name')]")
	private WebElement ErrorLastName;

	@FindBy(xpath = "(//*[contains(text(),'Please enter a valid email address')])[1]")
	private WebElement ErrorEmailAddress;

	@FindBy(xpath = "//input[@name='newsletter-input1']")
	private WebElement EmailFirstName;

	@FindBy(xpath = "//input[@name='newsletter-input2']")
	private WebElement EmailLastName;

	@FindBy(xpath = "//input[@name='newsletter-input3']")
	private WebElement EmailAddress;

	@FindBy(xpath = "//div[@class='confirmationtext']/p[1]/b")
	private WebElement Thankyou;

	@FindBy(xpath = "//p[contains(text(),'UnitedHealthcare Insurance Company (UnitedHealthcare)')]")
	private WebElement UHCICSubTiltle;

	@FindBy(xpath = "//*[contains(text(),'UnitedHealthcare Medicare Solutions | Provider Search')]")
	private WebElement UnitedHealthcareMedicareSolutions;

	@FindBy(xpath = "//*[contains(@id, 'piFirstName')]")
	private WebElement registerFirstName;

	@FindBy(id = "redirect_content")
	private WebElement leaveAARPMedicarePlansDialog;

	@FindBy(id = "proceed")
	private WebElement proceedLeaveAARPMedicare;

	@FindBy(id = "cancel")
	private WebElement cancelLeaveAARPMedicare;

	// @FindBy(xpath="//a[contains(text(),'Learn More') or contains(@title,'Learn
	// More About Medicare')]")
	@FindBy(xpath = "//span[contains(text(),'Learn More About Medicare')]")
	private WebElement learnAboutMedicareHomeScreen;

	@FindBy(xpath = "//*[@id='shop-plans-list-heading']/..//a[contains(@href,'medicare-advantage-plans')]")
	private WebElement MedicareAdvantagePlans;

	@FindBy(xpath = "//*[@id='shop-plans-list-heading']/..//a[contains(@href,'dual-special-needs-plans')]")
	private WebElement DualSpecialNeedsPlans;

	@FindBy(xpath = "//*[@id='shop-plans-list-heading']/..//a[contains(@href,'medicare-supplement-plans')]")
	private WebElement MedicareSupplementInsurancePlans;

	@FindBy(xpath = "//*[@id='shop-plans-list-heading']/..//a[contains(@href,'prescription-drug-plans')]")
	private WebElement MedicarePrescriptionDrugPlans;

	@FindBy(xpath = "//*[@id='shop-plans-list-heading']/..//a[contains(@href,'prescription-drug-plans')]")
	private WebElement footerMedicarePrescriptionDrugPlans;

	@FindBy(xpath = "(//*[@id='learn-about-medicare-list-heading']/..//a[contains(@href,'medicare-education')])[1]")
	private WebElement MedicareEducation;

	@FindBy(xpath = "//a[@class='back-to-top']")
	private WebElement BackToTop;

	@FindBy(xpath = "//*[@class='footer-bottom']//a[contains(@href,'accessibility')]")
	private WebElement Accessibility;

	@FindBy(xpath = "(//a[@id='gf_lnk_2']")
	private WebElement Aboutus;

	@FindBy(xpath = "//button[contains(@id,'guest-saved')]")
	private WebElement guestProfileLink;

	@FindBy(xpath = "//*[@id='enrollmentPopup']/..")
	private WebElement savedPlansPopup;

	@FindBy(xpath = "//*[@id='enrollmentPopup']/..//*[@class='uhc-modal__close']")
	private WebElement savedPlansPopupCloseIcon;

	@FindBy(xpath = "//h3//a[text()='Medicare Prescription Drug Plans']")
	private WebElement planTypePDPLink;

	@FindBy(xpath = "//a[@title='Pharmacy Locator']")
	private WebElement pdpPharmacyLink;

	@FindBy(xpath = "//a[contains(@href,'https://www.myuhcagent.com/')]")
	private WebElement FindAnAgent;

	@FindBy(xpath = "//a[@id='ghn_lnk_1']")
	private WebElement homeTab;

	@FindBy(xpath = "//div[@id='sp-root-container']/div[@id='sp-chat-frame']/div[@id='sp-side-bar']/div[@id='sp-close-frame']/*[1]")
	private WebElement CloseChat;

	@FindBy(xpath = "//div[@class='label-icon']//following-sibling::div/div")
	private WebElement rightRailsectionTFNtimezone;

	@FindBy(xpath = "(//div[@class='uhc-container']//h4)[3]")
	private WebElement rightRailSectionTFNHeaderMedsupp;

	@FindBy(xpath = "(//div[@class='label-icon']//h5)[1]")
	private WebElement rightRailSectionTFNHeaderMedsupp1;

	@FindBy(xpath = "//span[contains(@class,'size14 day')]")
	private WebElement rightRailsectionTFNtimezoneMedsupp;

	//@FindBy(xpath = "(//div[contains(@class,'label-icon')]//following-sibling::div/p)[1]")
	@FindBy(xpath = "(//*[contains(@class,'layout-container')])[3]//p[4]")
	private WebElement rightRailsectionTFNtimezoneOLE;

	@FindBy(xpath = "(//div[@class='uhc-container']//h2)[1]")
	private WebElement rightRailSectionTFNHeader;

	@FindBy(xpath = "(//div[@class='label-icon']//h3)[1]")
	private WebElement rightRailSectionTFNHeader1;

	@FindBy(xpath = "(//*[contains(text(),'Call UnitedHealthcare')])[3]")
	private WebElement footertextsectioncallus;

	@FindBy(xpath = "(//*[contains(text(),'Hours: 8 a.m.')])")
	private WebElement footertextsectionTFNtimezone;

	@FindBy(xpath = "(//div[@class='label-icon']/h5)[1]")
	private WebElement footertextsectionTFNHeader;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'medsuptime')]/p[2]")
	private WebElement CallSamTFNMedsupptimezone;

	@FindBy(xpath = "//h3[@class='sam-callbody-head']")
	private WebElement CallSamModalMember;

	@FindBy(xpath = "//*[@id='sam-call-modal']//*[contains(@class,'modal-title')]")
	private WebElement CallSamModalHeader;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@dtmname,'TFN Link') and contains(text(),'1-')]/..")
	private WebElement CallSamTFNInfo;

	@FindBy(xpath = "//div[contains(@class,'calluswidgets')]//p[3]")
	private WebElement footertextsectionMedsuppTFNtimezone;

	@FindBy(xpath = "(//div[@class='label-icon']/h5)[7]")
	private WebElement footertextsectionHeadermedsupp;

	@FindBy(xpath = "(//div[contains(@class,'calluswidgets')]//p[1])[4]")
	private WebElement footertextsectioncallusMedsupp;

	// @FindBy(xpath =
	// "(//div[contains(@class,'label-icon')]//following-sibling::div/p)[2]")
	@FindBy(xpath = "//div[contains(@class,'label-icon')]//following-sibling::div/p[2]/span[@class='ng-scope']")
	private WebElement rightRailsectionTFNtimezonePlanDetails;

	@FindBy(id = "zipcode")
	private WebElement externalzipCodeField;

	@FindBy(id = "autocomplete-list")
	private WebElement autoCompleteSuggestion;

	@FindBy(id = "searchresults-item0")
	private WebElement firstAutoCompleteSuggestion;

	@FindBy(id = "listPop")
	private WebElement autoCompleteSuggestionSiteSearch;

	@FindBy(xpath = "(//*[@id='listPop']//*[contains(@class,'uhc-autocomplete')])[1]")
	private WebElement firstAutoCompleteSuggestionSiteSearch;

	@FindBy(xpath = "//a[text()='Medicare Supplement Plans']")
	private WebElement MedSuppPlan;

	@FindBy(xpath = "//a[@href='/shop/medicare-supplement-plans-classic.html']")
	private WebElement MedSuppClassicUrl;

	@FindBy(xpath = "//a[@href='/shop/medicare-supplement-plans.html']")
	private WebElement MedicareSuppUrl;

	@FindBy(id = "learnmore-email-address")
	private WebElement learnMoreMedicareEmailTxtBox;

	@FindBy(xpath = "//*[@id='learnmore-email-address']/../button")
	private WebElement learnMoreMedicareEmailSubmitBtn;

	@FindBy(xpath = "//*[contains(@class,'thankYouMsg')]")
	private WebElement learnMoreMedicareEmailSubmissionMsg;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'medsuptime')]/p[2]")
	private WebElement CallSamTFNtimezone_Medsup;

	@FindBy(xpath = "//div[@style='']//p[contains(text(),'Already a member?')]")
	private WebElement CallSamTFNMember_Medsup;

	@FindBy(xpath = "//*[contains(@class,'plan-mem-linkwrap')]//button")
	private WebElement planMemberLink;

	@FindBy(xpath = "//*[contains(@class,'plan-mem-linkwrap')]//a[contains(text(),'Go to the Member Site')]")
	private WebElement goToMemberSiteLink;
	
	@FindBy(id = "header-tfn-link")
	private WebElement tfnHeaderLink;
	
	@FindBy(xpath = "(//*[contains(@data-bind-class,'hidden') and not(contains(@class,'hidden'))])[1]//a")
	private WebElement tfnHeaderPopup;
	
	@FindBy(xpath = "//*[contains(@id,'header-tfn')]//*[contains(@class,'modal-close')]")
	private WebElement tfnHeaderPopupClose;
	
	//@FindBy(xpath = "(//div[contains(@class,'label-icon')]//following-sibling::p/span)[1]")
	@FindBy(xpath = "(//*[contains(@class,'layout-container')])[3]//p[2]")
	private WebElement tfnHeaderRightRailOLE;
	
	//@FindBy(xpath = "//*[contains(@id,'sam-button--chat')]")
			@FindBy(xpath = "//*[contains(@id,'LPMcontainer')]//*[contains(text(),'Chat Now')]")
			private WebElement samChatIcon;
			
			@FindBy(xpath = "//*[contains(@class,'lp_maximized')]")
			private WebElement samChatPopup;
			
			@FindBy(xpath = "//*[contains(@class,'lp_maximized')]//span[contains(@class,'lpc_maximized-header')]")
			private WebElement samChatPopupHeader;
			
			@FindBy(xpath = "//*[contains(@id,'lp_line_bubble_0')]")
			private WebElement samChatPopupMsg;
			
			@FindBy(id = "proactive-chat-widget-new")
			private WebElement proactiveChatModal;
			
			@FindBy(xpath = "//*[@id='proactive-chat-widget-new']//*[contains(@class,'proactive-header-text')]")
			private WebElement proactiveChatMsg;
			
			@FindBy(xpath = "//*[@id='proactive-chat-widget-new']//*[contains(@class,'proactive-chat-cross')]//*[@role='presentation']")
			private WebElement proactiveChatCloseIcon;
			
			@FindBy(xpath = "//*[@id='proactive-chat-widget-new']//*[contains(@class,'proactive-chat-button-text')]")
			private WebElement proactiveChatBtn;
			
			@FindBy(xpath = "//*[contains(@class,'chips-row')]//button[contains(@class,'chips-item')]")
			private List<WebElement> chatSuggestionMsg;
			
			@FindBy(xpath = "//*[contains(@class,'lpc_maximized-header__menu-button-asset')]")
			private WebElement chatPopupOptions;
			
			@FindBy(xpath = "//*[contains(@id,'LP_EndChatAction_2')]")
			private WebElement chatPopupEndChatOption;
			
			//@FindBy(xpath = "//*[contains(@id,'LP_EndChatAction_4')]")
			
			//@FindBy(xpath = "//button[contains(@id,'LP_EndChatAction_8')]")
			@FindBy(xpath = "//*[contains(@id,'LP_EndChatAction_2')]")
			private WebElement proactiveChatPopupEndChatOption;

	String ChatSamText = "Chat with a Licensed Insurance Agent";

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

	public boolean isHealthPlan = false;

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

	public AcquisitionHomePage(WebDriver driver, String siteOrPage, String testharnessurl) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(siteOrPage, testharnessurl);
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
				// checkModelPopup(driver, 10);
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
			} else {
				start(AARP_ACQISITION_PAGE_URL);
				testSiteUrl = AARP_ACQISITION_PAGE_URL;
				checkForSecurityPage();
				// checkModelPopup(driver, 10);
			}
		} else if (site.equalsIgnoreCase("PRE") || site.equalsIgnoreCase("ARE")) {
			System.out.println("Temporary condition added to bypass openAndValidate for PRE/ARE"); // added on 3/3/21 as
																									// part of AARP/UHC
																									// cleanup
		}

		if (!(site.equalsIgnoreCase("PRE") || site.equalsIgnoreCase("ARE"))) { // adding this condition temporarily to
																				// bypass PRE/ARE flows
			// CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
			// checkModelPopup(driver,15);
			// CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 25);
			// CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn, 20); // do not
			// change this to waitForPageLoadNew as
			// we're not trying to fail the test if it
			// isn't found
			try {
				validate(proactiveChatExitBtn, 20);
				if (proactiveChatExitBtn.isDisplayed())
					jsClickNew(proactiveChatExitBtn);
			} catch (Exception e) {
				System.out.println("Proactive chat popup not displayed");
			}
		}
	}

	public void openAndValidate(boolean alreadyOnSite) {
		if (alreadyOnSite) {

			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
			testSiteUrl = driver.getCurrentUrl();
			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
				checkModelPopup(driver);
			CommonUtility.waitForPageLoadNew(driver, zipCodeField, 15);
			try {
				if (proactiveChatExitBtn != null)
					jsClickNew(proactiveChatExitBtn);

				else
					Assertion.fail("Please check booleanvalue");

			} catch (Exception e) {
				System.out.println("Proactive chat popup not displayed");
			}
		}
	}

	public void openAndValidate(String siteOrPage, String testharnessurl) {
		String testharurl = "content/" + testharnessurl + "testharnesspage.html";
		// String testharurl = "content/pharmacysearchtestharnesspage.html";
		if ("ULayer".equalsIgnoreCase(siteOrPage)) {
			if (MRScenario.environment.equals("offline")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = AARP_ACQISITION_OFFLINE_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = AARP_ACQISITION_OFFLINE_PAGE_URL + testharurl;
			} else if (MRScenario.environment.equals("prod")) {
				startNew(AARP_ACQISITION_PROD_PAGE_URL + testharurl);
				testSiteUrl = AARP_ACQISITION_PROD_PAGE_URL + testharurl;
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = AARP_ACQISITION_PROD_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = AARP_ACQISITION_PROD_PAGE_URL + testharurl;
			} else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = AARP_ACQISITION_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = AARP_ACQISITION_PAGE_URL + testharurl;
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
		} else if ("BLayer".equalsIgnoreCase(siteOrPage)) {
			if (MRScenario.environment.equals("offline")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = UMS_ACQISITION_OFFLINE_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = UMS_ACQISITION_OFFLINE_PAGE_URL + testharurl;
			} else if (MRScenario.environment.equals("prod")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = UMS_ACQISITION_PROD_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = UMS_ACQISITION_PROD_PAGE_URL + testharurl;
			} else {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				testSiteUrl = UMS_ACQISITION_PAGE_URL;
				driver.get(testSiteUrl + testharurl);
				MicroAppSiteUrl = UMS_ACQISITION_PAGE_URL + testharurl;
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
		}
	}

	public void openAndValidate(int visitorProfile) {
		if (visitorProfile > 0) {

			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
			testSiteUrl = driver.getCurrentUrl();
			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
				checkModelPopup(driver, 15);
			CommonUtility.waitForPageLoadNew(driver, zipCode, 45);
			try {
				if (proactiveChatExitBtn != null)
					jsClickNew(proactiveChatExitBtn);

				else
					Assertion.fail("Please check booleanvalue");

			} catch (Exception e) {
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
		if (!MRScenario.domain.contains("uhc.com")) {
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
		waitForPageLoadSafari();
		if (isHealthPlan) {
			CommonUtility.waitForPageLoadNew(driver, zipCode, 30);
			sendkeys(zipCode, zipcode);

			jsClickNew(btnGO);
		} else {
			CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
			sendkeys(zipCodeField, zipcode);

			jsClickNew(viewPlansButton);
		}

		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		if (validate(countyModal))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
		}
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
		pageloadcomplete();
		validateNew(zipCodeField);
//		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
		// sendkeys(zipCodeField, zipcode);
		sendkeysNew(zipCodeField, zipcode);
		//viewPlansButton.click();
		validateNew(viewPlansButton);
		jsClickNew(viewPlansButton);
		// }
		// while(validate(overlayFilm, 10)) {/**wait*/}
		// CommonUtility.waitForElementToDisappear(driver, overlayFilm, 75);
		waitForPageLoadSafari();
		pageloadcomplete();
		// CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		validateNew(vppTop, 30);
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
		}
		if (driver.getCurrentUrl().contains("health-plans")) {
			return new VPPPlanSummaryPage(driver);
		} else
			return null;
	}

	public VPPPlanSummaryPage searchPlanOnHealthPlansPage(String zipcode, String county, String isMultiCounty) {
		CommonUtility.waitForPageLoadNew(driver, healthPlansZipcode, 30);
		sendkeys(healthPlansZipcode, zipcode);
		jsClickNew(findPlansBtn);
		waitForPageLoadSafari();
		if (isMultiCounty.equalsIgnoreCase("YES")) {
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
		// checkModelPopup(driver);
		Actions action = new Actions(driver);
		scrollToView(navigationSectionHomeLink);
		action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		validate(pharmacylocator, 5);
		pharmacylocator.click();
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().toLowerCase()
				.contains((PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase())) {
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
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		// CommonUtility.waitForPageLoadNew(driver, requestAgentApptDropdown, 60);
		if (validateNew(requestAgentBtn)) {
			return new RequestHelpAndInformationPage(driver);
		}
		return null;
	}

	public AboutUsAARPPage aboutUsFooterClick() {
		validateNew(footerAboutUsLink);
		// footerAboutUsLink.click();
		jsClickNew(footerAboutUsLink);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if (getTitle().contains("About UnitedHealthcare")) {
			return new AboutUsAARPPage(driver);
		}
		return null;
	}

	// public void validateFooterLinks() {
	// validateNew(footerHomeLink);
	// validateNew(footerAboutUsLink);
	// validateNew(footerContactUsLink);
	// validateNew(footerSiteMapLink);
	// validateNew(footerPrivacyPolicyLink);
	// validateNew(footerTermsnConditionsLink);
	// validateNew(footerDisclaimersLink);
	// validateNew(footerAgentsnBrokersLink);
	// //validateNew(footerRequestforAssistancelink);
	// validateNew(footerAccessibilitylink);
	// //validateNew(aarpOrgLink);
	// validateNew(medicareAdvantagePlansLink);
	// validateNew(medicareSupplementInsurancePlansLink);
	// validateNew(medicarePrescriptionDrug_PlansLink);
	// validateNew(learnAboutMedicareLink);
	// validateNew(viewAllDisclaimerInformationLink);

	// }

	/*
	 * public ContactUsAARPPage contactUsFooterClick() {
	 * validateNew(footerContactUsLink); footerContactUsLink.click();
	 * CommonUtility.checkPageIsReadyNew(driver); waitForPageLoadSafari(); if
	 * (driver.getCurrentUrl().contains("contact-us")) { return new
	 * ContactUsAARPPage(driver); } return null; }
	 * 
	 * 
	 * 
	 * 
	 * public TermsnConditionsAARPPage termsnconditionsFooterClick() {
	 * validate(footerTermsnConditionsLink); footerTermsnConditionsLink.click();
	 * jsClickNew(footerTermsnConditionsLink);
	 * CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("terms-of-use")) { return new
	 * TermsnConditionsAARPPage(driver); } return null; }
	 * 
	 * public DisclaimersAARPPage disclaimersFooterClick() {
	 * validate(footerDisclaimersLink); // footerDisclaimersLink.click();
	 * jsClickNew(footerDisclaimersLink); CommonUtility.checkPageIsReadyNew(driver);
	 * if (driver.getCurrentUrl().contains("disclaimer")) { return new
	 * DisclaimersAARPPage(driver); } return null; }
	 * 
	 * public AgentsnBrokersAARPPage agentsnbrokersFooterClick() {
	 * validate(footerAgentsnBrokersLink); // footerAgentsnBrokersLink.click();
	 * jsClickNew(footerAgentsnBrokersLink);
	 * CommonUtility.checkPageIsReadyNew(driver); validateNew(brokerHeader);
	 * if(driver.getCurrentUrl().contains("health-insurance-brokers")){ return new
	 * AgentsnBrokersAARPPage(driver); } return null; }
	 * 
	 * public AcquisitionHomePage homeFooterClick() { validateNew(footerHomeLink);
	 * // footerHomeLink.click(); jsClickNew(footerHomeLink);
	 * CommonUtility.checkPageIsReadyNew(driver); if (validateNew(zipCodeField)) {
	 * return new AcquisitionHomePage(driver, true); } return null; }
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
	 * 
	 * public boolean validateAllElementsOnPage() { if (!validateNew(zipCodeField)
	 * && !validateNew(findPlansButton) && !validateNew(lookzip)) return false; //
	 * if all three elements return false for validation // then this condition
	 * passes due to ! and returns // false meaning all three elements were not
	 * found // on page return true; }
	 * 
	 * public GetStartedPage navigateToPrescriptionDrug() {
	 * enterYourDrugListButton.click(); if (getTitle().
	 * equalsIgnoreCase("Our Medicare Plan Types | AARP? Medicare Plans from UnitedHealthcare?"
	 * )) { return new GetStartedPage(driver); } else { return null; } }
	 * 
	 * public DrugCostEstimatorPage navigateToDCEToolFromHome() throws
	 * InterruptedException { validateNew(getStarted); getStarted.click();
	 * 
	 * if (driver.getCurrentUrl().contains("health-plans/estimate-drug-costs.html"))
	 * return new DrugCostEstimatorPage(driver); return null; }
	 * 
	 * public VPPPlanSummaryPage ZipcodeSearch(String zipcode) { try {
	 * Thread.sleep(3000); } catch (InterruptedException e) {
	 * System.out.println("page took time to load"); } JavascriptExecutor jse =
	 * (JavascriptExecutor) driver; jse.executeScript("window.scrollBy(0,300)", "");
	 * 
	 * sendkeys(StandaloneZipcode, zipcode); StandalonSearchCounty.click();
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); try { if
	 * (countyDropdown.isDisplayed()) { countyDropdown.click(); Thread.sleep(3000);
	 * // StandalonSearchCounty.click(); }
	 * 
	 * } catch (Exception e) { System.out.println("county box not found"); }
	 * jse.executeScript("window.scrollBy(0,100)", ""); try { Thread.sleep(2000); }
	 * catch (InterruptedException e) {
	 * System.out.println("page took time to load"); }
	 * ViewPlansPricingButton.click();
	 * 
	 * if (driver.getCurrentUrl().contains("plan-summary")) { return new
	 * VPPPlanSummaryPage(driver); } return null; }
	 * 
	 * 
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
	 * 
	 * public ProviderSearchPage clicksOnRallyToolFromGlobalHeader() {
	 * 
	 * // Actions action = new Actions(driver); //
	 * action.moveToElement(navigationSectionHomeLink).moveToElement(
	 * ourPlansHoverLink).build().perform(); jsMouseOver(navigationSectionHomeLink);
	 * jsMouseOver(ourPlansHoverLink); validateNew(providerSearchFromGlobalHeader);
	 * 
	 * switchToNewTabNew(providerSearchFromGlobalHeader);
	 * 
	 * CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("werally")) {
	 * 
	 * return new ProviderSearchPage(driver);
	 * 
	 * } return null; }
	 * 
	 * public ProviderSearchPage clicksOnRallyToolFromHomePage() {
	 * validateNew(providerSearchFromHomeScreen);
	 * 
	 * switchToNewTabNew(providerSearchFromHomeScreen);
	 * 
	 * CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("werally")) {
	 * 
	 * return new ProviderSearchPage(driver);
	 * 
	 * } return null; }
	 * 
	 * public DrugCostEstimatorPage navigationDrugCostEstimator() {
	 * navigateToMenuLinks(ShopForaplan, headerDrugCostEstimatorLink);
	 * 
	 * 
	 * return new DrugCostEstimatorPage(driver); }
	 * 
	 * public ShopForPlanNavigationPage Hoveronaplan() throws InterruptedException {
	 * waitforElement(ShopForaplan); if (ShopForaplan.isDisplayed()) { // Actions
	 * action = new Actions(driver); //
	 * action.moveToElement(ShopForaplan).build().perform();
	 * jsMouseOver(ShopForaplan); return new ShopForPlanNavigationPage(driver); }
	 * else { return null;} }
	 * 
	 * public WelcomePage ZipcodeSearchToOLEWithOutCounty(String zipcode,String
	 * planName) throws Exception { try { Thread.sleep(3000); } catch
	 * (InterruptedException e) { System.out.println("page took time to load"); }
	 * JavascriptExecutor jse = (JavascriptExecutor) driver;
	 * jse.executeScript("window.scrollBy(0,300)", "");
	 * 
	 * sendkeys(StandaloneZipcode, zipcode); StandalonSearchCounty.click();
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * jse.executeScript("window.scrollBy(0,100)", ""); try { Thread.sleep(2000); }
	 * catch (InterruptedException e) {
	 * System.out.println("page took time to load"); } //String
	 * planYear=ZipCodeLabel.getText();
	 * driver.findElement(By.xpath("//*[@id='js-ole-plan-select']//option[text()='"
	 * + planName + "']")).click(); waitforElement(enrollButton);
	 * enrollButton.click(); Thread.sleep(5000);
	 * System.out.println(driver.getTitle()); if
	 * (driver.getTitle().contains("Online Enrollment")) {
	 * System.out.println("OLE Welcome Page is Displayed"); return new
	 * WelcomePage(driver); } return null; }
	 * 
	 * public WelcomePage ZipcodeSearchToOLEWithCounty(String zipcode, String
	 * countyName,String planName) throws Exception { try { Thread.sleep(3000); }
	 * catch (InterruptedException e) {
	 * System.out.println("page took time to load"); } JavascriptExecutor jse =
	 * (JavascriptExecutor) driver; jse.executeScript("window.scrollBy(0,300)", "");
	 * 
	 * sendkeys(StandaloneZipcode, zipcode); StandalonSearchCounty.click();
	 * driver.findElement(By.xpath(
	 * "//select[@id='ole-county-select']//option[text()='" + countyName +
	 * "']")).click(); driver.manage().timeouts().implicitlyWait(10,
	 * TimeUnit.SECONDS); jse.executeScript("window.scrollBy(0,100)", ""); try {
	 * Thread.sleep(2000); } catch (InterruptedException e) {
	 * System.out.println("page took time to load"); }
	 * driver.findElement(By.xpath("//*[@id='js-ole-plan-select']//option[text()='"
	 * + planName + "']")).click(); waitforElement(enrollButton);
	 * enrollButton.click(); Thread.sleep(5000); if
	 * (driver.getTitle().contains("Online Enrollment")) {
	 * System.out.println("OLE Welcome Page is Displayed"); return new
	 * WelcomePage(driver); } return null; }
	 * 
	 * public void selectState(String state) {
	 * selectFromDropDownByValue(stateDropDown, state); }
	 *//**
		 * This method used to navigate to visitor profile dashboard
		 * 
		 * @return
		 *//*
			 * public VisitorProfilePage navigateToVisitorProfilePage() {
			 * waitforElement(shoppingCartIcon); // shoppingCartIcon.click();
			 * jsClickNew(shoppingCartIcon); waitForPageLoadSafari();
			 * if(driver.getCurrentUrl().contains("profile")) { return new
			 * VisitorProfilePage(driver); }else {
			 * System.out.println("Navigation to visitor profile is failed"); return null; }
			 * }
			 * 
			 * public VPPPlanSummaryPage findPlans(String txtZipCode){
			 * 
			 * zipCode.sendKeys(txtZipCode);
			 * 
			 * 
			 * return new VPPPlanSummaryPage(driver); } public keywordSearchAARP
			 * searchfield() { validate (searchfield);
			 * System.out.println("search field is seen on AARP site  ==>" +
			 * searchfield.isDisplayed()); validate (searchbutton);
			 * System.out.println("search button is seen on AARP site ==>" +
			 * searchbutton.isDisplayed()); searchfield.clear();
			 * searchfield.sendKeys("medicare"); searchbutton.click(); try {
			 * Thread.sleep(3000); } catch (InterruptedException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); } if
			 * (driver.getCurrentUrl().contains("medicare.html?q=medicare")) return new
			 * keywordSearchAARP(driver); return null; }
			 * 
			 * public void validateCallSam() throws InterruptedException { boolean present;
			 * // driver.navigate().refresh(); try { validateNew(callsam); present = true; }
			 * catch (NoSuchElementException e) { present = false; } if (present) {
			 * System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@"); } else
			 * Assertion.fail("@@@@@@@@@ No TFN widget @@@@@@@@@");
			 * 
			 * }
			 * 
			 * public void validateCallSamContent() throws InterruptedException {
			 * 
			 * // Actions action = new Actions(driver); // WebElement element = callsam; //
			 * action.moveToElement(element).perform();
			 * waitforElementNew(callsamtooltip,30); String toolTipText =
			 * callsamtooltip.getText(); System.out.println(
			 * "====================================================================");
			 * System.out.println(toolTipText); System.out.println(
			 * "====================================================================");
			 * 
			 * if (toolTipText.contains(CallSam1877)) {
			 * System.out.println("Call sticky action menu roll out and contain the text: "+
			 * toolTipText);
			 * 
			 * } else if (toolTipText.contains(CallSam1855)) {
			 * System.out.println("Call sticky action menu roll out and contain the text"+
			 * toolTipText); }
			 * 
			 * else Assertion.
			 * fail("No Call sticky action menu didn't roll out and doesn't contain the text 1-877"
			 * );
			 * 
			 * }
			 * 
			 * public AcquisitionHomePage validateCallpopup() throws InterruptedException {
			 * int retry = 1; do { driver.navigate().refresh();
			 * CommonUtility.checkPageIsReady(driver); CheckiPerseptions();
			 * validate(callsamtooltip); jsClickNew(callsam);
			 * System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
			 * driver.switchTo().activeElement(); //
			 * System.out.println(CallSamTFN.getText()); // CallSamTFNClose.click(); //
			 * validateNew(callsam);
			 * System.out.println("Call Sam checking for "+retry+" times"); retry++; } while
			 * (!validate(CallSamTFN) && (retry<6));
			 * 
			 * System.out.println(CallSamTFN.getText()); // CallSamTFNClose.click();
			 * jsClickNew(CallSamTFNClose); validateNew(callsam); return null;
			 * 
			 * validate(callsamtooltip); CheckiPerseptions(); callsam.click();
			 * System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
			 * driver.switchTo().activeElement(); System.out.println(CallSamTFN.getText());
			 * CallSamTFNClose.click(); validateNew(callsam); return null; }
			 * 
			 * public void validateChatSam() throws InterruptedException { boolean present;
			 * try { validateNew(chatsam); present = true; } catch (NoSuchElementException
			 * e) { present = false; } if (present) {
			 * System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			 * 
			 * } else Assertion.fail("@@@@@@@@@ No TFN widget @@@@@@@@@");
			 * 
			 * }
			 * 
			 * public void validateChatSamContent() throws InterruptedException {
			 * 
			 * Actions action = new Actions(driver); WebElement element = chatsam;
			 * action.moveToElement(element).perform(); String ChattoolTipText =
			 * chatsamtooltip.getText(); System.out.println(
			 * "====================================================================");
			 * System.out.println(ChattoolTipText); System.out.println(
			 * "====================================================================");
			 * 
			 * if (ChatSamText.equalsIgnoreCase(ChattoolTipText)) { System.out.
			 * println("Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent"
			 * ); } else Assertion.
			 * fail("No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent"
			 * );
			 * 
			 * }
			 * 
			 * public void validateChatSamContent() throws InterruptedException {
			 * 
			 * Actions action = new Actions(driver); WebElement element = chatsam;
			 * action.moveToElement(element).perform(); String ChattoolTipText =
			 * chatsamtooltip.getText(); System.out.println(
			 * "====================================================================");
			 * System.out.println(ChattoolTipText); System.out.println(
			 * "====================================================================");
			 * 
			 * if (ChatSamText.equalsIgnoreCase(ChattoolTipText)) { System.out.println(
			 * "Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent"
			 * ); // return new AcquisitionHomePage(driver); } else Assertion.fail(
			 * "No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent"
			 * ); // return null; }
			 * 
			 * 
			 * public AcquisitionHomePage validateChatpopup() throws InterruptedException {
			 * //CommonUtility.checkPageIsReady(driver); scrollToView(chatsam);
			 * chatsam.click(); jsClickNew(chatsam);
			 * System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@"); //
			 * chatsamtooltip.click(); driver.switchTo().activeElement(); //
			 * System.out.println(ChatSamHead.getText()); // ChatSamTFNClose.click();
			 * jsClickNew(ChatSamTFNClose); validateNew(chatsam); return null; }
			 * 
			 * public void validateChatpopup() throws InterruptedException { //
			 * CommonUtility.checkPageIsReady(driver); validateNew(chatsam);
			 * System.out.println(chatsam.getText()); jsClickNew(chatsam);
			 * System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");
			 * //validateandcloseChat();
			 * 
			 * chatsamtooltip.click(); driver.switchTo().activeElement();
			 * System.out.println(ChatSamHead.getText()); ChatSamTFNClose.click();
			 * validateNew(chatsam);
			 * 
			 * // return null; }
			 * 
			 * public PharmacySearchPage navigateFromTestharnessToPharmacySearch(String
			 * zipcode) { //checkModelPopup(driver); validateNew(thpharmacyzipsearch);
			 * thpharmacyzipsearch.sendKeys(zipcode); thpharmacyGoButton.click();
			 * CommonUtility.checkPageIsReadyNew(driver); if
			 * (driver.getTitle().toLowerCase().contains((PageTitleConstants.
			 * BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase())) { return new
			 * PharmacySearchPage(driver); } return null;
			 * 
			 * }
			 * 
			 * public DCETestHarnessPage GetDCEtestHarnessPage() { return new
			 * DCETestHarnessPage(driver); }
			 * 
			 * public GetStartedPage navigateToDCERedesignFromHome() throws
			 * InterruptedException { validateNew(getStarted); // getStarted.click();
			 * jsClickNew(getStarted); CommonUtility.checkPageIsReadyNew(driver); if
			 * (validateNew(AddMyDrugsBtn)) return new GetStartedPage(driver); return null;
			 * }
			 * 
			 * public void navigateToMedEdPresDrugPage() {
			 * waitforElement(lnkLearnAboutMedicare); if
			 * (lnkLearnAboutMedicare.isDisplayed()) {
			 * 
			 * // Actions actions = new Actions(driver); //
			 * actions.moveToElement(lnkLearnAboutMedicare); // actions.build().perform();
			 * jsMouseOver(lnkLearnAboutMedicare);
			 * 
			 * System.out.println("Hover over Learn about Medicare completed"); } WebElement
			 * PresProvidersBenefitsLink = driver.findElement(By.
			 * xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-benefits')]"
			 * )); jsClickNew(PresProvidersBenefitsLink); }
			 * 
			 * public GetStartedPage clickDCERedesignLinkonMedEdPage() { WebElement DCELink
			 * = driver.findElement(By.
			 * xpath("//a[contains(@href,'drug-cost-estimator') and contains(@class,'contentRow__mededcontainer')]"
			 * )); validateNew(DCELink); jsClickNew(DCELink); if
			 * (validateNew(AddMyDrugsBtn)) return new GetStartedPage(driver); return null;
			 * }
			 * 
			 * public void navigateToShopPDPpage() { waitforElement(ShopForaplan); if
			 * (ShopForaplan.isDisplayed()) { // Actions actions = new Actions(driver); //
			 * actions.moveToElement(ShopForaplan); // actions.build().perform();
			 * jsMouseOver(ShopForaplan);
			 * System.out.println("Hover over Shop for a Plan completed"); } WebElement
			 * PDPplansLink = driver.findElement(By.
			 * xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'prescription-drug-plans.html')]"
			 * )); jsClickNew(PDPplansLink); waitForPageLoadSafari(); }
			 * 
			 * public GetStartedPage clickDCERedesignLinkonShopPDPpage() {
			 * CommonUtility.checkPageIsReadyNew(driver); WebElement DCELink =
			 * driver.findElement(By.
			 * xpath("//a[contains(@href,'drug-cost-estimator') and contains(text(), 'Prescription Drug Costs')]"
			 * )); validateNew(DCELink, 10); jsClickNew(DCELink); waitForPageLoadSafari();
			 * if (validateNew(AddMyDrugsBtn)) return new GetStartedPage(driver); return
			 * null; }
			 * 
			 * public GetStartedPage navigateToDCERedesignFromSubNav() {
			 * navigateToMenuLinks(ShopForaplan, headerDrugCostEstimatorLink);
			 * 
			 * if (validateNew(AddMyDrugsBtn)) return new GetStartedPage(driver); return
			 * null;
			 * 
			 * }
			 * 
			 * public void navigateToPage(String page) { String pageURL =
			 * driver.getCurrentUrl()+page; System.out.println("==pageURL=="+pageURL);
			 * driver.navigate().to(pageURL);
			 * 
			 * 
			 * }
			 * 
			 * public void verifyChatpopup() throws InterruptedException {
			 * //CommonUtility.checkPageIsReady(driver); chatsam.click();
			 * System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");
			 * 
			 * }
			 * 
			 * public void validateChatpopupconnect() throws InterruptedException {
			 * 
			 * try { driver.switchTo().frame("sp-chat-iframe");
			 * validateNew(samChatFirstNameField); samChatFirstNameField.sendKeys("tester");
			 * 
			 * validateNew(samChatLastNameField); samChatLastNameField.sendKeys("test");
			 * 
			 * validateNew(samChatZipField); samChatZipField.sendKeys("90210");
			 * 
			 * validateNew(samChatEmailField);
			 * samChatEmailField.sendKeys("test123@test.com");
			 * 
			 * validateNew(samChatOptions); samChatOptions.click();
			 * 
			 * driver.switchTo().defaultContent();
			 * System.out.println("Page Title---"+driver.getTitle());
			 * 
			 * }catch(Exception e) {
			 * 
			 * System.out.println("Failed Due To-------"+e.getMessage()); }
			 * 
			 * 
			 * }
			 * 
			 * public boolean validateChat() throws InterruptedException { boolean present =
			 * false; try { //validateNew(chatsam); present=validateNew(samdiv); if(present)
			 * { List<WebElement> list =
			 * driver.findElements(By.xpath("//div[@class='sam']/button")); String chatbtnid
			 * = "sam-button--chat"; for(WebElement element : list ) {
			 * if(element.getAttribute("id").equalsIgnoreCase(chatbtnid)) { present = false;
			 * break; } } }
			 * 
			 * } catch (NoSuchElementException e) { e.printStackTrace(); } return present; }
			 * 
			 * 
			 * public void signInheader() { jsClickNew(headerSignInLink);
			 * validateNew(signIn); if (driver.getCurrentUrl().contains("medicare.uhc.com"))
			 * { Assertion.assertTrue(true); System.out.println("Signin page is loaded");
			 * driver.navigate().back(); CommonUtility.waitForPageLoad(driver,
			 * healthPlansZipcode, 30); System.out.println("Home Page is loaded"); } else {
			 * Assertion.fail("Unable to navigate to signin page"); }
			 * 
			 * }
			 * 
			 * public void validateLogo() { // TODO Auto-generated method stub
			 * if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
			 * validateNew(AARPlogo); WebElement AARPLogo =
			 * driver.findElement(By.xpath("//a[contains(@id, 'aarpSVGLogo')]")); WebElement
			 * UHCLogo = driver.findElement(By.xpath("//a[contains(@id, 'uhcSVGLogo')]"));
			 * if (AARPLogo.isDisplayed() && AARPLogo.isEnabled() && !UHCLogo.isDisplayed())
			 * { Assertion.assertTrue(true);
			 * System.out.println("Correct AARP Logo is Displayed"); } else {
			 * Assertion.fail("AARP logo is not dispalyed for Ulayer"); } } else {
			 * WebElement AARPLogo =
			 * driver.findElement(By.xpath("//a[contains(@id, 'aarpSVGLogo')]")); WebElement
			 * UHCLogo = driver.findElement(By.xpath("//a[contains(@id, 'uhcSVGLogo')]"));
			 * if (UHCLogo.isDisplayed() && UHCLogo.isEnabled() && !AARPLogo.isDisplayed())
			 * { Assertion.assertTrue(true);
			 * System.out.println("Correct UHC Logo is Displayed"); } else {
			 * Assertion.fail("UHC logo is not dispalyed for Ulayer"); }
			 * 
			 * } }
			 * 
			 * private void CheckPageLoad() { CommonUtility.checkPageIsReadyNew(driver);
			 * System.out.println("Current page URL: " + driver.getCurrentUrl());
			 * checkModelPopup(driver, 30);
			 * 
			 * }
			 * 
			 * public void CheckiPerseptions() { CommonUtility.waitForPageLoad(driver,
			 * proactiveChatExitBtn, 20); // do not change this to waitForPageLoadNew as //
			 * we're not trying to fail the test if it // isn't found try { if
			 * (proactiveChatExitBtn.isDisplayed()) jsClickNew(proactiveChatExitBtn); }
			 * catch (Exception e) {
			 * System.out.println("Proactive chat popup not displayed"); } }
			 * 
			 * 
			 * 
			 * 
			 * public void validatevisitorprofile() { if (visitorprofileicon.isDisplayed())
			 * {
			 * 
			 * Actions actions = new Actions(driver);
			 * actions.moveToElement(visitorprofileicon).perform();
			 * jsMouseOver(visitorprofileicon);
			 * 
			 * System.out.println("Hover over visitor profile completed"); } WebElement
			 * CreateProfile =
			 * driver.findElement(By.xpath("//a[contains(text(), 'Create Profile')]"));
			 * WebElement VPSignIn = driver.findElement( By.
			 * xpath("//a[contains(text(), 'Sign In') and not(contains(@aria-labelledby ,'VPSignIn'))]"
			 * )); validateNew(CreateProfile); validateNew(VPSignIn); if
			 * (CreateProfile.isEnabled() && VPSignIn.isEnabled()) {
			 * Assertion.assertTrue(true);
			 * System.out.println("Visitor Profile elements are present on home page"); }
			 * else {
			 * Assertion.fail("Visitor Profile elements are not present on home page"); }
			 * visitorprofileicon.click(); WebElement GuestProfile =
			 * driver.findElement(By.xpath("//*[contains(text(), 'Your Guest Profile')]"));
			 * CheckPageLoad(); waitForPageLoadSafari(); CheckiPerseptions();
			 * CommonUtility.waitForPageLoadNew(driver, GuestProfile, 30); if
			 * (driver.getCurrentUrl().contains("profile/guest")) {
			 * Assertion.assertTrue(true);
			 * System.out.println("Visitor Profile Page opens successsfully"); } else {
			 * Assertion.fail("Visitor Profile page is not opening up"); }
			 * driver.navigate().back(); CheckPageLoad(); waitForPageLoadSafari();
			 * CheckiPerseptions();
			 * 
			 * CommonUtility.waitForPageLoadNew(driver, findPlansButton, 30); }
			 * 
			 * public void navigateToPath(String path) {
			 * 
			 * String CurrentURL = driver.getCurrentUrl();
			 * System.out.println("Current URL : " + CurrentURL);
			 * 
			 * String NavigateToURL = CurrentURL + path;
			 * System.out.println("Navigating to URL : " + NavigateToURL);
			 * driver.navigate().to(NavigateToURL); waitForPageLoadSafari();
			 * CommonUtility.waitForPageLoad(driver,
			 * driver.findElement(By.xpath("//header[contains(@class,'header')]")), 30);
			 * System.out.println("Page Title : " +
			 * (driver.findElement(By.xpath("//title")).getText()));
			 * 
			 * }
			 * 
			 * public void validateGlobalFooterLinks() { validateNew(footerHomeLink);
			 * validateNew(footerAboutUsLink); validateNew(footerContactUsLink);
			 * validateNew(footerSiteMapLink); validateNew(footerPrivacyPolicyLink);
			 * validateNew(footerTermsnConditionsLink); validateNew(footerDisclaimersLink);
			 * validateNew(footerAgentsnBrokersLink); validateNew(footerAccessibilitylink);
			 * if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
			 * validateNew(aarpOrgLink); } else {
			 * System.out.println("UHC Medicare solutions site loaded"); }
			 * validateNew(medicareAdvantagePlansLink);
			 * validateNew(medicareSupplementInsurancePlansLink);
			 * validateNew(medicarePrescriptionDrug_PlansLink);
			 * validateNew(medicareSpecialNeedsPlansLink);
			 * validateNew(learnAboutMedicareLink); }
			 * 
			 * public void validateTFNelement(String tfnXpath) { WebElement TFNelement =
			 * driver.findElement(By.xpath(tfnXpath)); JavascriptExecutor jse =
			 * (JavascriptExecutor) driver;
			 * jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			 * jse.executeScript("window.scrollBy(0,-500)"); validateNew(TFNelement, 45); if
			 * (validateNew(TFNelement) && TFNelement.isDisplayed()) {
			 * System.out.println("TFN is Displayed on Page : " + TFNelement.getText()); }
			 * else { Assertion.fail("TFN elemnet is not found / displayed on page : " +
			 * tfnXpath); } }
			 * 
			 * public void validateSubNavShopPlanLinks() { waitForPageLoadSafari();
			 * CheckPageLoad(); CheckiPerseptions();
			 * 
			 * waitforElement(ShopForaplan); if (ShopForaplan.isDisplayed()) { // Actions
			 * actions = new Actions(driver); // actions.moveToElement(ShopForaplan); //
			 * actions.build().perform(); jsMouseOver(ShopForaplan);
			 * System.out.println("Hover over Shop for a Plan completed");
			 * 
			 * //
			 * waitforElementNew(driver.findElement(By.xpath("//input[@id='nav-zipcode']")))
			 * ; // System.out.println("Submit button is displayed"); } WebElement
			 * ZipCodeTxt = driver.findElement(By.xpath("//input[@id='nav-zipcode']"));
			 * WebElement FindPlansBtn =
			 * driver.findElement(By.xpath("//button[@dtmid='acq_top_nav']")); WebElement
			 * RequestMoreInfoLink = driver
			 * .findElement(By.xpath("//a[@dtmname='Top Nav:Our Plans:Request More Help']"))
			 * ; WebElement EnrollLink =
			 * driver.findElement(By.xpath("//a[contains(@href,'enroll.html')]"));
			 * WebElement ShopLink =
			 * driver.findElement(By.xpath("//a[contains(@href,'shop.html')]")); WebElement
			 * ResourceLink =
			 * driver.findElement(By.xpath("//a[contains(@href,'resources.html')]"));
			 * 
			 * WebElement MAplansLink = driver.findElement(By.xpath(
			 * "//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'medicare-advantage-plans.html')]"
			 * )); List<WebElement> MedSuppPlansLink = driver.findElements(By.xpath(
			 * "//*[contains(@class, 'nav-col nav-col-1')]//*[contains(@href,'medicare-supplement-plans.html') or contains(@href,'medicare-supplement-plans-classic.html')]"
			 * )); WebElement PDPplansLink = driver.findElement(By.xpath(
			 * "//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'prescription-drug-plans.html')]"
			 * )); WebElement SNPplansLink = driver.findElement( By.
			 * xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'special-needs-plans.html')]"
			 * ));
			 * 
			 * WebElement PlanSelectorLink = driver.findElement(By.xpath(
			 * "//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'plan-recommendation-engine.html')]"
			 * )); WebElement DCELink = driver.findElement( By.
			 * xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'drug-cost-estimator')]"
			 * )); WebElement PharmacySearchLink = driver.findElement( By.
			 * xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@href,'aarp-pharmacy.html')]"
			 * )); WebElement ProviderSearchLink = driver.findElement(By
			 * .xpath("//*[contains(@class, 'nav-col nav-col-1')]//a[contains(@onclick,'loadCachedProviderSearch')]"
			 * ));
			 * 
			 * validateNew(ZipCodeTxt); validateNew(FindPlansBtn);
			 * validateNew(RequestMoreInfoLink);
			 * 
			 * validateNew(EnrollLink); validateNew(ShopLink); validateNew(ResourceLink);
			 * 
			 * validateNew(MAplansLink); Assertion.assertTrue(MedSuppPlansLink.size() > 0,
			 * "No Med Sup link found in the header navigation"); validateNew(PDPplansLink);
			 * validateNew(SNPplansLink);
			 * 
			 * validateNew(PlanSelectorLink); validateNew(DCELink);
			 * validateNew(PharmacySearchLink); validateNew(ProviderSearchLink);
			 * 
			 * if (ZipCodeTxt.isDisplayed() && FindPlansBtn.isDisplayed() &&
			 * RequestMoreInfoLink.isDisplayed() && EnrollLink.isDisplayed() &&
			 * ShopLink.isDisplayed() && ResourceLink.isDisplayed() &&
			 * MAplansLink.isDisplayed() && PDPplansLink.isDisplayed() &&
			 * SNPplansLink.isDisplayed() && PlanSelectorLink.isDisplayed() &&
			 * DCELink.isDisplayed() && PharmacySearchLink.isDisplayed() &&
			 * ProviderSearchLink.isDisplayed()) { Assertion.assertTrue(true); System.out.
			 * println("Sub Nav - Shop for a Plan - All links and element displayed on Page : "
			 * ); // Actions actions = new Actions(driver); //
			 * actions.moveToElement(AARPlogo); // actions.build().perform();
			 * jsMouseOver(AARPlogo); } else { Assertion.
			 * fail("Sub Nav - Shop for a Plan - All links and element not found / displayed on page : "
			 * ); } }
			 * 
			 * public void validateSubNavMedEdLinks() { waitForPageLoadSafari();
			 * CheckPageLoad(); CheckiPerseptions();
			 * 
			 * waitforElement(lnkLearnAboutMedicare); if
			 * (lnkLearnAboutMedicare.isDisplayed()) { // Actions actions = new
			 * Actions(driver); // actions.moveToElement(lnkLearnAboutMedicare); //
			 * actions.build().perform(); jsMouseOver(lnkLearnAboutMedicare);
			 * System.out.println("Hover over Learn about Medicare completed"); } WebElement
			 * EligibilityTxt = driver.findElement( By.
			 * xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-eligibility')]"
			 * )); WebElement ChoicesBtn = driver.findElement(By.xpath(
			 * "//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-parts-and-medigap-plans')]"
			 * )); WebElement PresProvidersBenefitsLink = driver.findElement( By.
			 * xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-benefits')]"
			 * )); WebElement CostbasicsLink = driver.findElement( By.
			 * xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-costs')]"
			 * ));
			 * 
			 * WebElement MAplansLink = driver.findElement( By.
			 * xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-advantage-plans')]"
			 * )); WebElement MedSuppPlansLink = driver.findElement(By.xpath(
			 * "//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-supplement-plans.html')]"
			 * )); WebElement PDPplansLink = driver.findElement( By.
			 * xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-part-d')]"
			 * ));
			 * 
			 * WebElement EnrollmentBasicsLink = driver.findElement(By.xpath(
			 * "//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'enrollment-and-changing-plans')]"
			 * )); // WebElement FAQLink = driver.findElement(By.
			 * xpath("//*[contains(@class, 'nav-col nav-col-3')]//a[contains(@href,'medicare-faq')]"
			 * ));
			 * 
			 * validateNew(EligibilityTxt); validateNew(ChoicesBtn);
			 * validateNew(PresProvidersBenefitsLink); validateNew(CostbasicsLink);
			 * 
			 * validateNew(MAplansLink); validateNew(MedSuppPlansLink);
			 * validateNew(PDPplansLink);
			 * 
			 * validateNew(EnrollmentBasicsLink);
			 * 
			 * if (EligibilityTxt.isDisplayed() && ChoicesBtn.isDisplayed() &&
			 * PresProvidersBenefitsLink.isDisplayed() && CostbasicsLink.isDisplayed() &&
			 * MAplansLink.isDisplayed() && MedSuppPlansLink.isDisplayed() &&
			 * PDPplansLink.isDisplayed() && EnrollmentBasicsLink.isDisplayed()) { // &&
			 * FAQLink.isDisplayed() Assertion.assertTrue(true); System.out.
			 * println("Sub Nav - Learn about Medicare - All links and element displayed on Page"
			 * ); // Actions actions = new Actions(driver); //
			 * actions.moveToElement(AARPlogo); // actions.build().perform();
			 * jsMouseOver(AARPlogo); } else { Assertion.
			 * fail("Sub Nav - Learn about Medicare - All links and element not found / displayed on page"
			 * ); } }
			 * 
			 * 
			 * 
			 * public void validateDisclaimer() { validateNew(disclaimerInformation); //
			 * disclaimerInformation.click(); jsClickNew(disclaimerInformation);
			 * validateNew(backToTop_Disclaimer); }
			 * 
			 * public void validateVisitAarpOrglink() {
			 * if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
			 * validateNew(visitAARPFooterLink); String hRef =
			 * visitAARPFooterLink.getAttribute("href");
			 * System.out.println("href for Visit AARP.org link : " + hRef);
			 * Assertion.assertTrue(hRef.contains("www.aarp.org"),
			 * "Incorrect href for Visit AARP.org : " + hRef);
			 * visitAARPFooterLink.isEnabled(); } else {
			 * System.out.println("UHC Medicare solutions site loaded"); }
			 * 
			 * }
			 * 
			 * public void backToToplink() { validateNew(backToTop); // backToTop.click();
			 * jsClickNew(backToTop); }
			 * 
			 * public boolean openPRE() { boolean offline_prod = false; String browser =
			 * MRScenario.browsername; if (!(MRScenario.getProps() == null)) {// If running
			 * from local if (MRScenario.environment.equalsIgnoreCase("digital-uatv2-aarp"))
			 * { startNewPRE(AARP_ACQISITION_PAGE_URL.replace("digital-uatv2-aarp",
			 * "digital-uatv2") .replace(".com/",
			 * ".com/plan-recommendation-engine.html").replace("www.", ""), browser); } else
			 * if (MRScenario.environment.equalsIgnoreCase("digital-uatv2")) {
			 * startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com/",
			 * ".com/plan-recommendation-engine.html") .replace("www.", ""), browser); }
			 * else if (MRScenario.environment.equalsIgnoreCase("offline-stage-aarp")) {
			 * startNewPRE(AARP_ACQISITION_PAGE_URL.replace("offline-stage-aarp",
			 * "offline-stage").replace(".com/", ".com/plan-recommendation-engine.html"),
			 * browser); } else if
			 * (MRScenario.environment.equalsIgnoreCase("offline-stage")) {
			 * startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com/",
			 * ".com/plan-recommendation-engine.html"), browser); } else if
			 * (MRScenario.environment.equalsIgnoreCase("stage-aarp")) {
			 * startNewPRE(AARP_ACQISITION_PAGE_URL.replace("stage-aarp",
			 * "stage").replace(".com/", ".com/plan-recommendation-engine.html"), browser);
			 * } else if (MRScenario.environment.equalsIgnoreCase("stage")) {
			 * startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com/",
			 * ".com/plan-recommendation-engine.html"), browser); } else if
			 * (MRScenario.environment.equalsIgnoreCase("offline-prod-aarp")) {
			 * startNewPRE(AARP_ACQISITION_OFFLINE_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html"), browser); offline_prod = true; }
			 * else if (MRScenario.environment.equalsIgnoreCase("offline-prod")) {
			 * startNewPRE(UMS_ACQISITION_OFFLINE_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html"), browser); offline_prod = true; }
			 * else if (MRScenario.environment.equalsIgnoreCase("prod-aarp")) {
			 * startNewPRE(AARP_ACQISITION_PROD_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html"), browser); offline_prod = true; }
			 * else if (MRScenario.environment.equalsIgnoreCase("prod")) {
			 * startNewPRE(UMS_ACQISITION_PROD_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html"), browser); offline_prod = true; } }
			 * else { // For jenkins job String jenkinsRunnerFiles = MRScenario.runnerFiles;
			 * if (MRScenario.environment.equalsIgnoreCase("digital-uatv2") ||
			 * MRScenario.environment.equalsIgnoreCase("stage") ||
			 * MRScenario.environment.equalsIgnoreCase("offline-stage")) { for (String rname
			 * : jenkinsRunnerFiles.split(",")) { if
			 * ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") ||
			 * rname.contains("PRE")) && rname.toUpperCase().contains("ULAYER")) { if
			 * (MRScenario.environment.equalsIgnoreCase("digital-uatv2"))
			 * startNewPRE(AARP_ACQISITION_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html") .replace("www.", ""), browser); else
			 * startNewPRE( AARP_ACQISITION_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html"), browser); } if
			 * ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") ||
			 * rname.contains("PRE")) && rname.toUpperCase().contains("BLAYER")) { if
			 * (MRScenario.environment.equalsIgnoreCase("digital-uatv2"))
			 * startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html") .replace("www.", ""), browser); else
			 * startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html"), browser); }
			 * 
			 * } } if (MRScenario.environment.equalsIgnoreCase("offline")) { for (String
			 * rname : jenkinsRunnerFiles.split(",")) { if
			 * ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") ||
			 * rname.contains("PRE")) && rname.toUpperCase().contains("ULAYER"))
			 * startNewPRE(AARP_ACQISITION_OFFLINE_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html"), browser); if
			 * ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") ||
			 * rname.contains("PRE")) && rname.toUpperCase().contains("BLAYER"))
			 * startNewPRE( UMS_ACQISITION_OFFLINE_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html"), browser); } offline_prod = true; }
			 * if (MRScenario.environment.equalsIgnoreCase("prod")) { for (String rname :
			 * jenkinsRunnerFiles.split(",")) { if
			 * ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") ||
			 * rname.contains("PRE")) && rname.toUpperCase().contains("ULAYER"))
			 * startNewPRE( AARP_ACQISITION_PROD_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html"), browser); if
			 * ((rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE") ||
			 * rname.contains("PRE")) && rname.toUpperCase().contains("BLAYER"))
			 * startNewPRE( UMS_ACQISITION_PROD_PAGE_URL.replace(".com",
			 * ".com/plan-recommendation-engine.html"), browser); } offline_prod = true; } }
			 * 
			 * System.out.println("Current page URL: " + driver.getCurrentUrl()); return
			 * offline_prod; }
			 * 
			 * public PlanDocsPage navigateToPlanDocsFromHome() {
			 * navigateToMenuLinks(ShopForaplan, menuShop);
			 * 
			 * //driver.findElement(By.xpath(
			 * "//*[@id='globalContentIdForSkipLink']/div/table/tbody/tr[2]/td/div[1]/div/div/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div/a"
			 * )).click(); jsClickNew(driver.findElement(By.xpath(
			 * "//*[@id='globalContentIdForSkipLink']/div/table/tbody/tr[2]/td/div[1]/div/div/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div/a"
			 * )));
			 * 
			 * return new PlanDocsPage(driver); }
			 * 
			 * 
			 * 
			 * 
			 * public VPPPlanSummaryPage searchPlansWithOutCountyShop(String zipcode) throws
			 * InterruptedException {
			 * 
			 * CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
			 * sendkeys(zipCodeShopField, zipcode); viewShopPlansButton.click(); // }
			 * CommonUtility.waitForPageLoadNew(driver, zipcodeChangeLink, 30); if
			 * (driver.getCurrentUrl().contains("health-plans")) { return new
			 * VPPPlanSummaryPage(driver); } else return null; } public VPPPlanSummaryPage
			 * searchPlansShop(String zipcode, String countyName) {
			 * CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
			 * sendkeys(zipCodeShopField, zipcode); viewShopPlansButton.click();
			 * CommonUtility.waitForPageLoad(driver, countyModal, 45); if
			 * (validate(countyModal))
			 * driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" +
			 * countyName + "']")).click(); CommonUtility.waitForPageLoadNew(driver, vppTop,
			 * 30); if (driver.getCurrentUrl().contains("plan-summary")) { return new
			 * VPPPlanSummaryPage(driver); } return null; }
			 * 
			 * 
			 * public VPPPlanSummaryPage searchPlansWithOutCountyShopEnroll(String zipcode)
			 * throws InterruptedException {
			 * 
			 * CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
			 * sendkeys(zipCodeShopField, zipcode); ShopEnrollButton.click(); // }
			 * CommonUtility.waitForPageLoadNew(driver, zipcodeChangeLink, 30); if
			 * (driver.getCurrentUrl().contains("health-plans")) { return new
			 * VPPPlanSummaryPage(driver); } else return null; } public VPPPlanSummaryPage
			 * searchPlansShopEnroll(String zipcode, String countyName) {
			 * CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
			 * sendkeys(zipCodeShopField, zipcode); ShopEnrollButton.click();
			 * CommonUtility.waitForPageLoad(driver, countyModal, 45); if
			 * (validate(countyModal))
			 * driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" +
			 * countyName + "']")).click(); CommonUtility.waitForPageLoadNew(driver, vppTop,
			 * 30); if (driver.getCurrentUrl().contains("plan-summary")) { return new
			 * VPPPlanSummaryPage(driver); } return null; }
			 * 
			 * 
			 * 
			 * 
			 * public RequestHelpAndInformationPage clickonFindanAgentlink(){ WebElement
			 * clickonFindanAgentlink = null; validateNew(RightRail_FindAnAgent);
			 * CommonUtility.waitForPageLoadNew(driver, RightRail_FindAnAgent, 30); String
			 * parentWindow = driver.getWindowHandle(); RightRail_FindAnAgent.click();
			 * sleepBySec(3); Set<String> tabs_windows = driver.getWindowHandles();
			 * Iterator<String> itr = tabs_windows.iterator(); while(itr.hasNext()) { String
			 * window = itr.next(); if(!parentWindow.equals(window)) {
			 * driver.switchTo().window(window); } }
			 * 
			 * CommonUtility.checkPageIsReadyNew(driver); if
			 * (driver.getCurrentUrl().contains("myuhcagent")) {
			 * System.out.println("myuhcagent Page is displayed");
			 * 
			 * 
			 * return new RequestHelpAndInformationPage(driver); } return null; } public
			 * void sleepBySec(int sec) { try { Thread.sleep(sec*1000); } catch
			 * (InterruptedException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } }
			 * 
			 * 
			 * public void clickonFindanAgentlink(String ExpectedUHCAgentURL ) {
			 * 
			 * validateNew(RightRail_FindAnAgent); CommonUtility.waitForPageLoadNew(driver,
			 * RightRail_FindAnAgent, 30); String parentWindow = driver.getWindowHandle();
			 * RightRail_FindAnAgent.click(); sleepBySec(3); Set<String> tabs_windows =
			 * driver.getWindowHandles(); Iterator<String> itr = tabs_windows.iterator();
			 * while(itr.hasNext()) { String window = itr.next();
			 * if(!parentWindow.equals(window)) { driver.switchTo().window(window); } }
			 * 
			 * CommonUtility.checkPageIsReadyNew(driver); String CurrentUHCAgentURL =
			 * driver.getCurrentUrl(); String
			 * ActualCurrentUHCAgentURL=CurrentUHCAgentURL.substring(0, 27).trim();
			 * System.out.println("myuhcagent Page is displayed : "+ActualCurrentUHCAgentURL
			 * ); System.out.println("Expected myuhcagent URL: "+ExpectedUHCAgentURL);
			 * System.out.println("Actual myuhcagent URL: "+ActualCurrentUHCAgentURL);
			 * 
			 * if(ExpectedUHCAgentURL.equalsIgnoreCase(ActualCurrentUHCAgentURL)) {
			 * System.out.
			 * println("****************myuhcagent Page is displayed  ***************");
			 * 
			 * Assertion.assertTrue(true); } else { Assertion.
			 * fail("****************myuhcagent Page is not loaded ***************"); }
			 * 
			 * 
			 * 
			 * } public void sleepBySec(int sec) { try { Thread.sleep(sec*1000); } catch
			 * (InterruptedException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 * 
			 * }
			 * 
			 * public boolean validateChatNonHours() throws InterruptedException {
			 * 
			 * boolean present = true; try { WebElement chat =
			 * driver.findElement(By.xpath("//button[contains(@id,'sam-button--chat')]"));
			 * if(chat.getAttribute("class").contains("activeChatBtn")){ present = false; }
			 * 
			 * } catch (NoSuchElementException e) { e.printStackTrace(); } return present; }
			 * 
			 * public boolean validateChatNonHours1() throws InterruptedException {
			 * 
			 * boolean present = true; try { Calendar cal = Calendar.getInstance(); Date
			 * date = cal.getTime();
			 * 
			 * @SuppressWarnings("deprecation") int hours = date.getHours(); if(hours > 7 &&
			 * hours < 19) { WebElement chat =
			 * driver.findElement(By.xpath("//button[contains(@id,'sam-button--chat')]"));
			 * present = chat.isDisplayed(); }
			 * 
			 * } catch (NoSuchElementException e) { e.printStackTrace(); } return present; }
			 * 
			 * 
			 * public void validateChatIcon() throws InterruptedException { boolean present;
			 * CommonUtility.waitForPageLoadNewForClick(driver, chatsam, 60); if
			 * (chatsam.isDisplayed()) {
			 * System.out.println("@@@@ Chat Icon window opened successfully@@@");
			 * jsClickNew(chatsam); Thread.sleep(5000); //
			 * driver.switchTo().frame("sp-chat-iframe"); validate(ChatCancelBtn, 10);
			 * present = true; CommonUtility.waitForPageLoadNewForClick(driver,
			 * ChatCancelBtn, 30); jsClickNew(ChatCancelBtn); // ChatCancelBtn.click(); //
			 * driver.switchTo().defaultContent();
			 * CommonUtility.waitForPageLoadNewForClick(driver, chatsam, 60);
			 * System.out.println("@@@@ Chat Icon is displayed Successfully@@@"); }
			 * 
			 * else { System.out.println("@@@@@@@@@ No Chat Window  @@@@@@@@@"); //
			 * assertTrue("Chat Icon not displayed on " + pageName + "", false); } }
			 * 
			 * 
			 * 
			 * public void enterSearchtextvalue(String inputvalue) { //
			 * driver.switchTo().defaultContent(); CommonUtility.waitForPageLoad(driver,
			 * EnterSearch, 60); EnterSearch.sendKeys(inputvalue);
			 * CommonUtility.waitForPageLoadNewForClick(driver, SubmitBtn, 60);
			 * jsClickNew(SubmitBtn); waitForPageLoadSafari();
			 * CommonUtility.waitForPageLoadNew(driver, SearchResults, 60);
			 * checkModelPopup(driver, 20);
			 * 
			 * 
			 * } public void validateFifteenResults() {
			 * System.out.println("@@@@@Inside fifteen results validation@@@"); int
			 * sizeofResults =
			 * driver.findElements(By.xpath("//div[@class='list-heading']")).size();
			 * System.out.println("number of results displayed on UI" + sizeofResults); if
			 * (sizeofResults <= 15) {
			 * System.out.println("@@@Inside results displayed less than or equal to 15");
			 * Assertion.assertTrue(true); } else {
			 * System.out.println("@@@Inside results displayed Incorrectly");
			 * Assertion.assertTrue(false); }
			 * 
			 * }
			 * 
			 * public void validatePaginationofSearchResults() {
			 * System.out.println("Inside the pagination validation@@@@"); int sizeofpages =
			 * driver.findElements(By.xpath("//*[@class='pagination']/li/a")).size();
			 * System.out.println("size of pages" + sizeofpages); for (int i = 2; i <
			 * sizeofpages; i++) { System.out.println("@@Inside pagination click@@@");
			 * threadsleep(5);
			 * 
			 * driver.findElement(By.xpath("(//*[@class='pagination']/li/a)[" + i +
			 * "]")).click();
			 * 
			 * //driver.findElement(By.xpath("(//*[@class='pagination']/li/a)[" + i +
			 * "]")).click();
			 * jsClickNew(driver.findElement(By.xpath("(//*[@class='pagination']/li/a)[" + i
			 * + "]")));
			 * 
			 * CommonUtility.waitForPageLoadNew(driver, SearchResultsCount, 30);
			 * this.validateFifteenResults(); threadsleep(5); int sizeofNext =
			 * driver.findElements(By.xpath("//a[@dtmname='pagination:next']")).size();
			 * System.out.println("sizeofNext" + sizeofNext); if (!NextBtn.isDisplayed()) {
			 * System.out.println("@@@@Inside next button disappear loop");
			 * CommonUtility.waitForPageLoadNewForClick(driver, PreviousBtn, 30);
			 * PreviousBtn.click(); this.validateFifteenResults(); break; }
			 * 
			 * } // driver.navigate().back();
			 * 
			 * } public void enterSecondarySearchValue(String str) {
			 * System.out.println("@@@inside secondary search validation method@@@");
			 * CommonUtility.waitForPageLoadNewForClick(driver, SecondaryClearBtn, 30);
			 * SecondaryClearBtn.click(); CommonUtility.waitForPageLoad(driver,
			 * SecondarySearchInput, 30); SecondarySearchInput.sendKeys(str);
			 * CommonUtility.waitForPageLoadNewForClick(driver, SecondarySearchBtn, 30);
			 * SecondarySearchBtn.click(); waitForPageLoadSafari();
			 * CommonUtility.waitForPageLoadNew(driver, SearchResults, 60);
			 * 
			 * }
			 * 
			 * public void insertValueIntoSecondSearchBox(String inputValue) {
			 * System.out.println("Click on clear button");
			 * driver.findElement(By.className("clear-button")).click();
			 * System.out.println("Insert value into secondary searchbox");
			 * driver.findElement(By.id("secondarySearchInput")).sendKeys(inputValue);
			 * driver.findElement(By.id("secondarySearchInput")).sendKeys(Keys.ENTER); }
			 * 
			 * public void validateErrorMsg(String inputValue, String newSearchValue) {
			 * switch (inputValue) { case "Empty":
			 * System.out.println("Varify Error message for " + inputValue + ""); String
			 * errMessage = driver.findElement(By.id("searchErrorMessage")).getText();
			 * assertTrue(errMessage.
			 * contains("Your search box was empty. Please enter some text in the search box"
			 * )); break; case "InvalidCharacter":
			 * System.out.println("Validating invalid character message"); String
			 * invalidSearch =
			 * driver.findElement(By.xpath("//div[@class='invalid-search']")).getText().
			 * replaceAll("\\s+", " "); System.out.println("invalidSearch : >>>>> " +
			 * invalidSearch); assertTrue(invalidSearch.contains("Your search - " +
			 * newSearchValue + " - did not match any documents.")); //
			 * assertTrue(invalidSearch.contains("No pages were found containing //
			 * "+newSearchValue+".")); break; case "Numbers": System.out.println("Numbers");
			 * break; } }
			 * 
			 * 
			 * @FindBy(xpath="(//*[contains(text(),'Sign in')])[1]") private WebElement
			 * memberSignInPage;
			 * 
			 * @FindBy(xpath=
			 * "//a[contains(@href,'https://www.aarpmedicareplans.com/health-plans.html?WT.mc_id=8009508')]")
			 * private WebElement ViewMedicareplanlinks;
			 * 
			 * public void clickonmemberSignInlink(String ExpectedmemberSigninURL) {
			 * validateNew(memberSignInPage); CommonUtility.waitForPageLoadNew(driver,
			 * memberSignInPage, 30); String parentWindow = driver.getWindowHandle();
			 * memberSignInPage.click(); sleepBySec(3); Set<String> tabs_windows =
			 * driver.getWindowHandles(); Iterator<String> itr = tabs_windows.iterator();
			 * while(itr.hasNext()) { String window = itr.next();
			 * if(!parentWindow.equals(window)) { driver.switchTo().window(window); } }
			 * 
			 * CommonUtility.checkPageIsReadyNew(driver); String CurrentmemberSigninURL =
			 * driver.getCurrentUrl(); String
			 * ActualmemberSigninURL=CurrentmemberSigninURL.substring(0, 27).trim();
			 * System.out.println("memberSignin Page is displayed : "+ActualmemberSigninURL)
			 * ; System.out.println("Expected member signin URL: "+ExpectedmemberSigninURL);
			 * System.out.println("Actual member signin URL: "+ActualmemberSigninURL);
			 * 
			 * if(ExpectedmemberSigninURL.equalsIgnoreCase(ActualmemberSigninURL)) {
			 * System.out.
			 * println("****************member signin Page is displayed  ***************");
			 * 
			 * Assertion.assertTrue(true); } else { Assertion.
			 * fail("****************member signin Page is not loaded ***************"); }
			 * 
			 * ViewMedicareplanlinks.click();
			 * 
			 * }
			 * 
			 * 
			 * public void validateSubtitle() { threadsleep(5);
			 * System.out.println("validating the sub header");
			 * Assertion.assertEquals(UHCICSubTiltle.getText(),
			 * "UnitedHealthcare Insurance Company (UnitedHealthcare)");
			 * 
			 * 
			 * }
			 * 
			 * 
			 * 
			 * 
			 * 
			 * public void clickonFindanAgentlinkMedsupp(String ExpectedUHCAgentURL ) {
			 * 
			 * validateNew(RightRail_FindAnAgentMedsupp);
			 * CommonUtility.waitForPageLoadNew(driver, RightRail_FindAnAgentMedsupp, 30);
			 * String parentWindow = driver.getWindowHandle();
			 * RightRail_FindAnAgentMedsupp.click(); sleepBySec(3); Set<String> tabs_windows
			 * = driver.getWindowHandles(); Iterator<String> itr = tabs_windows.iterator();
			 * while(itr.hasNext()) { String window = itr.next();
			 * if(!parentWindow.equals(window)) { driver.switchTo().window(window); } }
			 * 
			 * CommonUtility.checkPageIsReadyNew(driver); String CurrentUHCAgentURL =
			 * driver.getCurrentUrl(); String
			 * ActualCurrentUHCAgentURL=CurrentUHCAgentURL.substring(0, 27).trim();
			 * System.out.println("myuhcagent Page is displayed : "+ActualCurrentUHCAgentURL
			 * ); System.out.println("Expected myuhcagent URL: "+ExpectedUHCAgentURL);
			 * System.out.println("Actual myuhcagent URL: "+ActualCurrentUHCAgentURL);
			 * 
			 * if(ExpectedUHCAgentURL.equalsIgnoreCase(ActualCurrentUHCAgentURL)) {
			 * System.out.
			 * println("****************myuhcagent Page is displayed  ***************");
			 * 
			 * Assertion.assertTrue(true); } else { Assertion.
			 * fail("****************myuhcagent Page is not loaded ***************"); }
			 * 
			 * 
			 * 
			 * }
			 * 
			 * public void hoverOverShopForPlan() { waitforElement(ShopForaplan); if
			 * (ShopForaplan.isDisplayed()) { jsMouseOver(ShopForaplan);
			 * System.out.println("Hover over Shop for a Plan completed"); } }
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * Actions action = new Actions(driver);
			 * action.moveToElement(navigationSectionHomeLink).moveToElement(
			 * ourPlansHoverLink).build().perform(); jsMouseOver(navigationSectionHomeLink);
			 * jsMouseOver(ourPlansHoverLink);
			 * 
			 * pharmacylocator.click(); CommonUtility.checkPageIsReadyNew(driver); if
			 * (driver.getTitle().toLowerCase().contains((PageTitleConstants.
			 * BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase())) { return new
			 * PharmacySearchPage(driver); } return null;
			 * 
			 * }
			 * 
			 * public PDPRequestHelpAndInformationPage navigateToPDPMoreHelpAndInfo() {
			 * 
			 * Actions actions = new Actions(driver); PageFactory.initElements(driver,
			 * this); actions.moveToElement(ourPlansHoverLink);
			 * actions.moveToElement(pdp_moreHelpInfoLink);
			 * actions.click().build().perform(); if
			 * (currentUrl().contains("prescription-drug-plans/request-information.html")) {
			 * return new PDPRequestHelpAndInformationPage(driver); }
			 * 
			 * return null;
			 * 
			 * }
			 * 
			 * public RequestHelpAndInformationPage navigateToMaMoreHelpAndInfo() {
			 * 
			 * Actions actions = new Actions(driver); PageFactory.initElements(driver,
			 * this); actions.moveToElement(ourPlansHoverLink);
			 * actions.moveToElement(moreHelpInfoLink); actions.click().build().perform();
			 * CommonUtility.checkPageIsReadyNew(driver);
			 * CommonUtility.waitForPageLoadNew(driver, requestAgentApptDropdown, 60); if
			 * (validate(requestAgentApptDropdown)) { return new
			 * RequestHelpAndInformationPage(driver); } return null; }
			 * 
			 * public AboutUsAARPPage aboutUsFooterClick() { validateNew(footerAboutUsLink);
			 * // footerAboutUsLink.click(); jsClickNew(footerAboutUsLink);
			 * CommonUtility.checkPageIsReadyNew(driver); waitForPageLoadSafari(); if
			 * (getTitle().contains("About UnitedHealthcare")) { return new
			 * AboutUsAARPPage(driver); } return null; }
			 * 
			 * public void validateFooterLinks() { validateNew(footerHomeLink);
			 * validateNew(footerAboutUsLink); validateNew(footerContactUsLink);
			 * validateNew(footerSiteMapLink); validateNew(footerPrivacyPolicyLink);
			 * validateNew(footerTermsnConditionsLink); validateNew(footerDisclaimersLink);
			 * validateNew(footerAgentsnBrokersLink); //
			 * validateNew(footerRequestforAssistancelink);
			 * validateNew(footerAccessibilitylink); validateNew(aarpOrgLink);
			 * validateNew(medicareAdvantagePlansLink);
			 * validateNew(medicareSupplementInsurancePlansLink);
			 * validateNew(medicarePrescriptionDrug_PlansLink);
			 * validateNew(learnAboutMedicareLink);
			 * validateNew(viewAllDisclaimerInformationLink);
			 * 
			 * }
			 * 
			 * 
			 * public ContactUsAARPPage contactUsFooterClick() {
			 * validateNew(footerContactUsLink); footerContactUsLink.click();
			 * CommonUtility.checkPageIsReadyNew(driver); waitForPageLoadSafari(); if
			 * (driver.getCurrentUrl().contains("contact-us")) { return new
			 * ContactUsAARPPage(driver); } return null; }
			 * 
			 * 
			 * 
			 * 
			 * public TermsnConditionsAARPPage termsnconditionsFooterClick() {
			 * validate(footerTermsnConditionsLink); // footerTermsnConditionsLink.click();
			 * jsClickNew(footerTermsnConditionsLink);
			 * CommonUtility.checkPageIsReadyNew(driver); if
			 * (driver.getCurrentUrl().contains("terms-of-use")) { return new
			 * TermsnConditionsAARPPage(driver); } return null; }
			 * 
			 * public DisclaimersAARPPage disclaimersFooterClick() {
			 * validate(footerDisclaimersLink); // footerDisclaimersLink.click();
			 * jsClickNew(footerDisclaimersLink); CommonUtility.checkPageIsReadyNew(driver);
			 * if (driver.getCurrentUrl().contains("disclaimer")) { return new
			 * DisclaimersAARPPage(driver); } return null; }
			 * 
			 * public AgentsnBrokersAARPPage agentsnbrokersFooterClick() {
			 * validate(footerAgentsnBrokersLink); // footerAgentsnBrokersLink.click();
			 * jsClickNew(footerAgentsnBrokersLink);
			 * CommonUtility.checkPageIsReadyNew(driver); validateNew(brokerHeader);
			 * if(driver.getCurrentUrl().contains("health-insurance-brokers")){ return new
			 * AgentsnBrokersAARPPage(driver); } return null; }
			 * 
			 * public AcquisitionHomePage homeFooterClick() { validateNew(footerHomeLink);
			 * // footerHomeLink.click(); jsClickNew(footerHomeLink);
			 * CommonUtility.checkPageIsReadyNew(driver); if (validateNew(zipCodeField)) {
			 * return new AcquisitionHomePage(driver, true); } return null; }
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
			 * 
			 * public boolean validateAllElementsOnPage() { if (!validateNew(zipCodeField)
			 * && !validateNew(findPlansButton) && !validateNew(lookzip)) return false; //
			 * if all three elements return false for validation // then this condition
			 * passes due to ! and returns // false meaning all three elements were not
			 * found // on page return true; }
			 * 
			 * public GetStartedPage navigateToPrescriptionDrug() {
			 * enterYourDrugListButton.click(); if (getTitle().
			 * equalsIgnoreCase("Our Medicare Plan Types | AARP� Medicare Plans from UnitedHealthcare�"
			 * )) { return new GetStartedPage(driver); } else { return null; } }
			 * 
			 * public DrugCostEstimatorPage navigateToDCEToolFromHome() throws
			 * InterruptedException { validateNew(getStarted); getStarted.click();
			 * 
			 * if (driver.getCurrentUrl().contains("health-plans/estimate-drug-costs.html"))
			 * return new DrugCostEstimatorPage(driver); return null; }
			 * 
			 * public VPPPlanSummaryPage ZipcodeSearch(String zipcode) { try {
			 * Thread.sleep(3000); } catch (InterruptedException e) {
			 * System.out.println("page took time to load"); } JavascriptExecutor jse =
			 * (JavascriptExecutor) driver; jse.executeScript("window.scrollBy(0,300)", "");
			 * 
			 * sendkeys(StandaloneZipcode, zipcode); StandalonSearchCounty.click();
			 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); try { if
			 * (countyDropdown.isDisplayed()) { countyDropdown.click(); Thread.sleep(3000);
			 * // StandalonSearchCounty.click(); }
			 * 
			 * } catch (Exception e) { System.out.println("county box not found"); }
			 * jse.executeScript("window.scrollBy(0,100)", ""); try { Thread.sleep(2000); }
			 * catch (InterruptedException e) {
			 * System.out.println("page took time to load"); }
			 * ViewPlansPricingButton.click();
			 * 
			 * if (driver.getCurrentUrl().contains("plan-summary")) { return new
			 * VPPPlanSummaryPage(driver); } return null; }
			 * 
			 * 
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
			 * 
			 * public ProviderSearchPage clicksOnRallyToolFromGlobalHeader() {
			 * 
			 * // Actions action = new Actions(driver); //
			 * action.moveToElement(navigationSectionHomeLink).moveToElement(
			 * ourPlansHoverLink).build().perform(); jsMouseOver(navigationSectionHomeLink);
			 * jsMouseOver(ourPlansHoverLink); jsClickNew(pharmacylocator);
			 * CommonUtility.checkPageIsReadyNew(driver); waitForPageLoadSafari(); if
			 * (driver.getTitle().toLowerCase().contains((PageTitleConstants.
			 * BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase())) { return new
			 * ProviderSearchPage(driver); } return null;
			 * 
			 * }
			 * 
			 * /* public PDPRequestHelpAndInformationPage navigateToPDPMoreHelpAndInfo() {
			 * 
			 * Actions actions = new Actions(driver); PageFactory.initElements(driver,
			 * this); actions.moveToElement(ourPlansHoverLink);
			 * actions.moveToElement(pdp_moreHelpInfoLink);
			 * actions.click().build().perform(); if
			 * (currentUrl().contains("prescription-drug-plans/request-information.html")) {
			 * return new PDPRequestHelpAndInformationPage(driver); }
			 * 
			 * return null;
			 * 
			 * }
			 */
	/*
	 * public RequestHelpAndInformationPage navigateToMaMoreHelpAndInfo() {
	 * 
	 * Actions actions = new Actions(driver); PageFactory.initElements(driver,
	 * this); actions.moveToElement(ourPlansHoverLink);
	 * actions.moveToElement(moreHelpInfoLink); actions.click().build().perform();
	 * CommonUtility.checkPageIsReadyNew(driver);
	 * CommonUtility.waitForPageLoadNew(driver, requestAgentApptDropdown, 60); if
	 * (validate(requestAgentApptDropdown)) { return new
	 * RequestHelpAndInformationPage(driver); } return null; }
	 */

	/*
	 * public AboutUsAARPPage aboutUsFooterClick() { validateNew(footerAboutUsLink);
	 * // footerAboutUsLink.click(); jsClickNew(footerAboutUsLink); sleepBySec(2);
	 * CommonUtility.checkPageIsReadyNew(driver); waitForPageLoadSafari(); if
	 * (getTitle().contains("About UnitedHealthcare")) { return new
	 * AboutUsAARPPage(driver); } return null; }
	 */

	/*
	 * public void validateFooterLinks() { validateNew(footerHomeLink);
	 * validateNew(footerAboutUsLink); validateNew(footerContactUsLink);
	 * validateNew(footerSiteMapLink); validateNew(footerPrivacyPolicyLink);
	 * validateNew(footerTermsnConditionsLink); validateNew(footerDisclaimersLink);
	 * validateNew(footerAgentsnBrokersLink);
	 * //validateNew(footerRequestforAssistancelink);
	 * validateNew(footerAccessibilitylink); //validateNew(aarpOrgLink);
	 * validateNew(medicareAdvantagePlansLink);
	 * validateNew(medicareSupplementInsurancePlansLink);
	 * validateNew(medicarePrescriptionDrug_PlansLink);
	 * validateNew(learnAboutMedicareLink);
	 * validateNew(viewAllDisclaimerInformationLink);
	 * 
	 * }
	 */

	/*
	 * public ContactUsAARPPage contactUsFooterClick() {
	 * validateNew(footerContactUsLink); jsClickNew(footerContactUsLink);
	 * sleepBySec(2); CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("contact-us")) { return new
	 * ContactUsAARPPage(driver); } return null; }
	 */

	// public SiteMapAARPPage siteMapFooterClick() {
	// validateNew(footerSiteMapLink);
	// jsClickNew(footerSiteMapLink);
	// sleepBySec(2);
	// CommonUtility.checkPageIsReadyNew(driver);
	// validateNew(siteMapHeader);
	// if (driver.getCurrentUrl().contains("sitemap.html")){
	// return new SiteMapAARPPage(driver);
	// }
	// return null;
	// }
	//

	// public PrivacyPolicyAARPPage privacypolicyFooterClick() {
	// validateNew(footerPrivacyPolicyLink);
	// jsClickNew(footerPrivacyPolicyLink);
	// sleepBySec(2);
	// CommonUtility.checkPageIsReadyNew(driver);
	// validateNew(privacyHeader);
	// if (driver.getCurrentUrl().contains("privacy-policy.html")) {
	// return new PrivacyPolicyAARPPage(driver);
	// }
	// return null;
	// }

	/*
	 * public TermsnConditionsAARPPage termsnconditionsFooterClick() {
	 * validate(footerTermsnConditionsLink); jsClickNew(footerTermsnConditionsLink);
	 * sleepBySec(2); CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("terms-of-use")) { return new
	 * TermsnConditionsAARPPage(driver); } return null; }
	 * 
	 * public DisclaimersAARPPage disclaimersFooterClick() {
	 * validate(footerDisclaimersLink); jsClickNew(footerDisclaimersLink);
	 * sleepBySec(3); CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("disclaimer")) { return new
	 * DisclaimersAARPPage(driver); } return null; }
	 * 
	 * public AgentsnBrokersAARPPage agentsnbrokersFooterClick() {
	 * validate(footerAgentsnBrokersLink); jsClickNew(footerAgentsnBrokersLink);
	 * sleepBySec(2); CommonUtility.checkPageIsReadyNew(driver);
	 * validateNew(brokerHeader);
	 * if(driver.getCurrentUrl().contains("health-insurance-brokers")){ return new
	 * AgentsnBrokersAARPPage(driver); } return null; }
	 * 
	 * public AcquisitionHomePage homeFooterClick() { validateNew(footerHomeLink);
	 * jsClickNew(footerHomeLink); sleepBySec(2);
	 * CommonUtility.checkPageIsReadyNew(driver); if (validateNew(zipCodeField)) {
	 * return new AcquisitionHomePage(driver, true); } return null; }
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
	 * 
	 * public boolean validateAllElementsOnPage() { if (!validateNew(zipCodeField)
	 * && !validateNew(findPlansButton) && !validateNew(lookzip)) return false; //
	 * if all three elements return false for validation // then this condition
	 * passes due to ! and returns // false meaning all three elements were not
	 * found // on page return true; }
	 * 
	 * public GetStartedPage navigateToPrescriptionDrug() {
	 * enterYourDrugListButton.click(); if (getTitle().
	 * equalsIgnoreCase("Our Medicare Plan Types | AARP� Medicare Plans from UnitedHealthcare�"
	 * )) { return new GetStartedPage(driver); } else { return null; } }
	 * 
	 * public DrugCostEstimatorPage navigateToDCEToolFromHome() throws
	 * InterruptedException { validateNew(getStarted); getStarted.click();
	 * 
	 * if (driver.getCurrentUrl().contains("health-plans/estimate-drug-costs.html"))
	 * return new DrugCostEstimatorPage(driver); return null; }
	 * 
	 * public VPPPlanSummaryPage ZipcodeSearch(String zipcode) { try {
	 * Thread.sleep(3000); } catch (InterruptedException e) {
	 * System.out.println("page took time to load"); } JavascriptExecutor jse =
	 * (JavascriptExecutor) driver; jse.executeScript("window.scrollBy(0,300)", "");
	 * 
	 * sendkeys(StandaloneZipcode, zipcode); StandalonSearchCounty.click();
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); try { if
	 * (countyDropdown.isDisplayed()) { countyDropdown.click(); Thread.sleep(3000);
	 * // StandalonSearchCounty.click(); }
	 * 
	 * } catch (Exception e) { System.out.println("county box not found"); }
	 * jse.executeScript("window.scrollBy(0,100)", ""); try { Thread.sleep(2000); }
	 * catch (InterruptedException e) {
	 * System.out.println("page took time to load"); }
	 * ViewPlansPricingButton.click();
	 * 
	 * if (driver.getCurrentUrl().contains("plan-summary")) { return new
	 * VPPPlanSummaryPage(driver); } return null; }
	 * 
	 * 
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
	 */

	/*
	 * public MultiCountyModalPage SubNav_ValidateMultiCOuntyPopUp(String zipcode) {
	 * hoverourplanslink(); validate(OurPlans_zipfield); OurPlans_zipfield.click();
	 * OurPlans_zipfield.sendKeys(zipcode); validate(OurPlans_viewPlansButton);
	 * OurPlans_viewPlansButton.click();
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); if
	 * (countyModal.isDisplayed()) { return new MultiCountyModalPage(driver); }
	 * return null; }
	 */

	public ProviderSearchPage clicksOnProviderToolFromGlobalHeader() {

		// Actions action = new Actions(driver);
		// action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		jsMouseOver(navigationSectionHomeLink);
		jsMouseOver(ourPlansHoverLink);
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
		scrollToView(providerSearchFromHomeScreen);

		switchToNewTabNew(providerSearchFromHomeScreen);
//		jsClickNew(providerSearchFromHomeScreen);
		waitForPageLoadSafari();

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

	public ShopForPlanNavigationPage Hoveronaplan() throws InterruptedException {
		waitforElement(ShopForaplan);
		if (ShopForaplan.isDisplayed()) {
			// Actions action = new Actions(driver);
			// action.moveToElement(ShopForaplan).build().perform();
			jsMouseOver(ShopForaplan);
			return new ShopForPlanNavigationPage(driver);
		} else {
			return null;
		}
	}

	public WelcomePage ZipcodeSearchToOLEWithOutCounty(String zipcode, String planName) throws Exception {
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
			return new WelcomePage(driver);
		}
		return null;
	}

	public WelcomePage ZipcodeSearchToOLEWithCounty(String zipcode, String countyName, String planName)
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
			return new WelcomePage(driver);
		}
		return null;
	}

	public void selectState(String state) {
		validateNew(stateDropDown);
		selectFromDropDownByValue(stateDropDown, state);
		openAndValidate(true);
	}

	/**
	 * This method used to navigate to visitor profile dashboard
	 * 
	 * @return
	 */
	public VisitorProfilePage navigateToVisitorProfilePage() {
		waitforElement(shoppingCartIcon);
		// shoppingCartIcon.click();
		jsClickNew(shoppingCartIcon);
		jsClickNew(lnkProfile);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public VPPPlanSummaryPage findPlans(String txtZipCode) {

		zipCode.sendKeys(txtZipCode);

		return new VPPPlanSummaryPage(driver);
	}

	public KeywordSearchPage searchfield() {
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
			return new KeywordSearchPage(driver);
		return null;
	}

	public void validateCallSam() throws InterruptedException {
		boolean present;
		// driver.navigate().refresh();
	}

	public void validateCallSamValue() throws InterruptedException {
		threadsleep(10);
		if (driver.findElement(By.xpath("(//div[@ng-show='fedTfn'])[1]/p/span/a/u")).isDisplayed()) {
			// threadsleep(25);
			WebElement ele = driver.findElement(By.xpath("(//div[@ng-show='fedTfn'])[1]/p/span/a/u"));
			waitforElementVisibilityInTime(ele, 30);
			String str = ele.getText();
			System.out.println("Stru" + str);
			String valueonCallUsMed = driver
					.findElement(By.xpath("//span[@class='sam__button__text desktop-tfn-text']")).getText();
			System.out.println("valueonCallUs" + valueonCallUsMed);
			System.out.println("valueOnPopup" + valueonCallUsMed);
			Assertion.assertEquals(str, valueonCallUsMed);
		} else {
			validateNew(callsam);
			String valueOncallSam = callsam.getText();
			System.out.println("valueOncallSam" + valueOncallSam);
			threadsleep(15);
			String valueonCallUs = callusonpage.getText();
			System.out.println("valueonCallUs" + valueonCallUs);
			Assertion.assertEquals(valueOncallSam, valueonCallUs);
			callsam.click();
			threadsleep(10);
			String valueOnPopup = tfnonpopup.getText();
			System.out.println("valueOnPopup" + valueOnPopup);
			Assertion.assertEquals(valueOncallSam, valueOnPopup);
			driver.findElement(By.xpath("//a[@class='modal-close']")).click();
			threadsleep(10);

			if (needhelp.isDisplayed()) {
				String needHelpValue = needhelp.getText();
				System.out.println("needHelpValue" + needHelpValue);
				Assertion.assertEquals(valueOncallSam, needHelpValue);
			}
		}

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
			Assertion.fail("No Call sticky action menu didn't roll out and doesn't contain the text 1-877");

	}

	public AcquisitionHomePage validateCallpopup() throws InterruptedException {
		/*
		 * int retry = 1; do { driver.navigate().refresh();
		 * CommonUtility.checkPageIsReady(driver); CheckiPerseptions();
		 * validate(callsamtooltip); jsClickNew(callsam);
		 * System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		 * driver.switchTo().activeElement(); System.out.println(CallSamTFN.getText());
		 * CallSamTFNClose.click(); validateNew(callsam);
		 * System.out.println("Call Sam checking for "+retry+" times"); retry++; } while
		 * (!validate(CallSamTFN) && (retry<1));
		 * 
		 * System.out.println(CallSamTFN.getText()); // CallSamTFNClose.click();
		 * jsClickNew(CallSamTFNClose); validateNew(callsam); return null;
		 */
		driver.navigate().refresh();
		CommonUtility.checkPageIsReady(driver);
		CheckiPerseptions();
		validate(callsamtooltip);
		validate(callsam);
		String ActualCallSAMTFN = callsam.getText();
		System.out.println("TFN No displayed on the Page" + ActualCallSAMTFN);
		jsClickNew(callsam);
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		driver.switchTo().activeElement();
		validate(CallSamTFN);
		String ExpectedCallSAMTFN = CallSamTFN.getText();
		System.out.println("TFN No displayed on the Page" + ExpectedCallSAMTFN);
		if (ExpectedCallSAMTFN.contains(ActualCallSAMTFN)) {
			System.out
					.println("****************TFN number was  found macthing with the SAM call Popup  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("*****************TFN number was  not found macthing with the SAM call Popup ***************"
					+ ExpectedCallSAMTFN);
		}
		String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. � 8 p.m., 7 days a week.*\n*Alaska and Hawaii: 8 a.m. � 8 p.m. Monday � Friday, 8 a.m. � 5 p.m. Saturday and Sunday.";
		validate(CallSamTFNtimezone);
		String ActualCallSamTFNtimezone = CallSamTFNtimezone.getText();
		System.out.println(ExpectedCallSamTFNtimezone);
		System.out.println(ActualCallSamTFNtimezone);
		if (ExpectedCallSamTFNtimezone.replace(" ", "").replace("\n", "")
				.equalsIgnoreCase(ActualCallSamTFNtimezone.replace(" ", "").replace("\n", ""))) {
			System.out.println(
					"****************TFN Timezone Content was  found macthing with the SAM call Popup  ***************");
			// Assertion.assertTrue(true);
		} else {
			// Assertion.fail("*****************TFN Timezone Content was not found macthing
			// with the SAM call Popup ***************"+ActualCallSamTFNtimezone);
			System.out.println(
					"****************TFN Timezone Content was not found macthing with the SAM call Popup  ***************");
		}
		String ExpectedCallSamTFNMember = "Already a member? Call the number on the back of your member ID card.";
		// ActualCallSamTFNMember.replace("", " ");
		// WebElement strCallSamTFNMember=
		// driver.findElement(By.xpath("//p[contains(text(),'Already a member?')]"));
		validate(CallSamTFNMember);
		String ActualCallSamTFNMember = CallSamTFNMember.getText();
		System.out.println(ExpectedCallSamTFNMember);
		if (ExpectedCallSamTFNMember.equalsIgnoreCase(ActualCallSamTFNMember)) {
			System.out.println(
					"****************TFN Member Content was  found macthing with the SAM call Popup  ***************");
			Assertion.assertTrue(true);
		} else {
			Assertion.fail(
					"*****************TFN Member Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);
		}
		validate(CallSamTFNClose);
		jsClickNew(CallSamTFNClose);
		/*
		 * validate(callsamtooltip); CheckiPerseptions(); callsam.click();
		 * System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		 * driver.switchTo().activeElement(); System.out.println(CallSamTFN.getText());
		 * CallSamTFNClose.click(); validateNew(callsam); return null;
		 */
		return null;
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

		} else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");

	}

	/*
	 * public void validateChatSamContent() throws InterruptedException {
	 * 
	 * Actions action = new Actions(driver); WebElement element = chatsam;
	 * action.moveToElement(element).perform(); String ChattoolTipText =
	 * chatsamtooltip.getText(); System.out.println(
	 * "====================================================================");
	 * System.out.println(ChattoolTipText); System.out.println(
	 * "====================================================================");
	 * 
	 * if (ChatSamText.equalsIgnoreCase(ChattoolTipText)) { System.out.
	 * println("Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent"
	 * ); } else Assertion.
	 * fail("No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent"
	 * );
	 * 
	 * }
	 */

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
			Assertion.fail(
					"No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
		// return null;
	}

	/*
	 * public AcquisitionHomePage validateChatpopup() throws InterruptedException {
	 * //CommonUtility.checkPageIsReady(driver); scrollToView(chatsam);
	 * chatsam.click(); jsClickNew(chatsam);
	 * System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@"); //
	 * chatsamtooltip.click(); driver.switchTo().activeElement(); //
	 * System.out.println(ChatSamHead.getText()); // ChatSamTFNClose.click();
	 * jsClickNew(ChatSamTFNClose); validateNew(chatsam); return null; }
	 */

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

	public PharmacySearchPage navigateFromTestharnessToPharmacySearch(String zipcode) {
		// checkModelPopup(driver);
		validateNew(thpharmacyzipsearch);
		thpharmacyzipsearch.sendKeys(zipcode);
		thpharmacyGoButton.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().toLowerCase()
				.contains((PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase())) {
			return new PharmacySearchPage(driver);
		}
		return null;

	}

	public GetStartedPage navigateToDCERedesignFromHome() throws InterruptedException {
		validateNew(getStarted);
		// getStarted.click();
		jsClickNew(getStarted);
		pageloadcomplete();
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPage(driver);
		return null;
	}

	public void navigateToMedEdPresDrugPage() {
		waitforElement(lnkLearnAboutMedicare);
		if (lnkLearnAboutMedicare.isDisplayed()) {
			// Actions actions = new Actions(driver);
			// actions.moveToElement(lnkLearnAboutMedicare);
			// actions.build().perform();
			jsMouseOver(lnkLearnAboutMedicare);
			System.out.println("Hover over Learn about Medicare completed");
		}
		WebElement PresProvidersBenefitsLink = driver.findElement(By.xpath(
				"//*[contains(@id, 'learnmore-scroll')]//*[contains(@class, 'desktop')]//a[contains(@href,'medicare-benefits')]"));
		jsClickNew(PresProvidersBenefitsLink);
		waitForPageLoadSafari();
	}

	public GetStartedPage clickDCERedesignLinkonMedEdPage() {
		 //WebElement DCELink = driver.findElement(By.xpath("//a[contains(@href,'drug-cost-estimator') and contains(@title, 'prescription drug costs')]"));
		WebElement DCELink = driver.findElement(By.xpath(
				"//a[contains(@href,'drug-cost-estimator') and (contains(@title, 'prescription drug costs') or @onkeydown)]"));
		validateNew(DCELink);
		jsClickNew(DCELink);
		//String winHandleBefore = driver.getWindowHandle();
		//switchToNewTabNew(DCELink);
		//String winHandleCurrent = driver.getWindowHandle();
		//driver.switchTo().window(winHandleBefore);
		//driver.close();
		//driver.switchTo().window(winHandleCurrent);
		CommonUtility.waitForPageLoadNew(driver, AddMyDrugsBtn, 20);
		if (driver.getCurrentUrl().contains("drug-cost-estimator"))
			return new GetStartedPage(driver);
		return null;
	}

	public void navigateToShopPDPpage() {
		waitforElement(ShopForaplan);
		if (ShopForaplan.isDisplayed()) {
			// Actions actions = new Actions(driver);
			// actions.moveToElement(ShopForaplan);
			// actions.build().perform();
			jsMouseOver(ShopForaplan);
			System.out.println("Hover over Shop for a Plan completed");
		}
		WebElement PDPplansLink = driver.findElement(By.xpath(
				"//*[contains(@class, 'desktop')]//*[contains(@dtmid,'acq_top_nav')and contains(@href,'prescription-drug-plans.html')]"));
		jsClickNew(PDPplansLink);
		waitForPageLoadSafari();
	}

	public GetStartedPage clickDCERedesignLinkonShopPDPpage() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement DCELink = driver.findElement(
				By.xpath("//a[contains(@href,'drug-cost-estimator') and contains(text(), 'Prescription Drug Costs')]"));
		validateNew(DCELink, 10);
		jsClickNew(DCELink);
		pageloadcomplete();
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
		String pageURL = driver.getCurrentUrl() + page;
		System.out.println("==pageURL==" + pageURL);
		driver.navigate().to(pageURL);

	}

	public void verifyChatpopup() throws InterruptedException {
		// CommonUtility.checkPageIsReady(driver);
		// chatsam.click();
		jsClickNew(chatsam);
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

			validate(CloseChat);
			//jsClickNew(CloseChat);
			samChatCancel.click();
			driver.switchTo().defaultContent();
			System.out.println("Page Title---" + driver.getTitle());

		} catch (Exception e) {

			System.out.println("Failed Due To-------" + e.getMessage());
		}

	}

	public void validateProActiveChatpopupconnect() {
		driver.navigate().refresh();
		System.out.println("@@here@@@");
		threadsleep(20);
		// waitTillElementClickableInTime(proactiveChatExitBtn, 30);
		if (proactiveChatExitBtn != null) {
			System.out.println("@@@proactive chat popup is displayed@@@@");
			waitTillElementClickableInTime(proactiveChatChatBtn, 30);
			jsClickNew(proactiveChatChatBtn);
			System.out.println("@@@clciked@@@@");
		} // driver.switchTo().defaultContent();
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
		validateNew(proActiveChatCancel);
		validateNew(proActiveChatSubmit);
		proActiveChatCancel.click();
		driver.switchTo().defaultContent();
		System.out.println("Page Title---" + driver.getTitle());

	}

	public boolean validateChat() throws InterruptedException {
		boolean present = false;
		try {
			// validateNew(chatsam);
			present = validateNew(samdiv);
			if (present) {
				List<WebElement> list = driver.findElements(By.xpath("//div[@class='sam']/button"));
				String chatbtnid = "sam-button--chat";
				for (WebElement element : list) {
					if (element.getAttribute("id").equalsIgnoreCase(chatbtnid)) {
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
		// validateNew(headerSignInLink);
		// jsMouseOver(planMemberLink);
		Actions action = new Actions(driver);
		action.moveToElement(planMemberLink).perform();
		// validateNew(headerRegisterLink);
		validateNew(goToMemberSiteLink);
		jsMouseOut(planMemberLink);
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			validateNew(visitAARPLink);
		} else {
			System.out.println("UHC Medicare solutions site loaded");
		}
		validateLogo();
		validateNew(globalSiteSearchTxtBox);
		validateNew(headerTfn);
		validateNew(visitorprofileicon);
		validateVisitorProfileIcon();
	}

	public void signInheader() {
		jsClickNew(headerSignInLink);
		waitForPageLoadSafari();
		validateNew(signIn);
		if (driver.getCurrentUrl().contains("medicare.uhc.com")) {
			Assertion.assertTrue(true);
			System.out.println("Signin page is loaded");
			// driver.navigate().back();
			clickBrowserBackButton();
			CommonUtility.waitForPageLoad(driver, healthPlansZipcode, 30);
			System.out.println("Home Page is loaded");
		} else {
			Assertion.fail("Unable to navigate to signin page");
		}

	}

	public void validateLogo() {
		// TODO Auto-generated method stub
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			validateNew(AARPlogo);
			WebElement AARPLogo = driver.findElement(By.xpath("//*[contains(@id, 'aarpSVGLogo')]"));
			WebElement UHCLogo = driver.findElement(By.xpath("//*[contains(@id, 'uhcSVGLogo')]"));
			if (AARPLogo.isDisplayed() && AARPLogo.isEnabled() && !UHCLogo.isDisplayed()) {
				scrollToView(AARPLogo);
				Assertion.assertTrue(true);
				System.out.println("Correct AARP Logo is Displayed");
			} else {
				Assertion.fail("AARP logo is not dispalyed for Ulayer");
			}
		} else {
			WebElement AARPLogo = driver.findElement(By.xpath("//*[contains(@id, 'aarpSVGLogo')]"));
			WebElement UHCLogo = driver.findElement(By.xpath("//*[contains(@id, 'uhcSVGLogo')]"));
			if (UHCLogo.isDisplayed() && UHCLogo.isEnabled() && !AARPLogo.isDisplayed()) {
				scrollToView(UHCLogo);
				Assertion.assertTrue(true);
				System.out.println("Correct UHC Logo is Displayed");
			} else {
				Assertion.fail("UHC logo is not dispalyed for Blayer");
			}

		}
	}

	private void CheckPageLoad() {
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: " + driver.getCurrentUrl());
		if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver, 20);

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

	// public void headerRegisterLink() {
	// validateNew(headerRegisterLink);
	// Assertion.assertTrue(true);
	// jsClickNew(headerRegisterLink);
	// CommonUtility.checkPageIsReadyNew(driver);
	// waitForPageLoadSafari();
	// if(validate(registerFirstName))
	// System.out.println("Register link is displayed in the header");
	// else
	// Assertion.fail("Register link did not lead to the right page");
	//
	//
	// }

	public void validatevisitorprofile() {
		if (visitorprofileicon.isDisplayed()) {
			Actions actions = new Actions(driver);
			actions.moveToElement(visitorprofileicon).perform();
			// jsMouseOver(visitorprofileicon);
			// visitorprofileicon.click();
			System.out.println("Hover over visitor profile completed");
		}
		// WebElement CreateProfile = driver.findElement(By.xpath("//a[contains(text(),
		// 'Create Profile')]"));
		WebElement CreateProfile = driver.findElement(By.xpath("//button[@id='guest-saved-items-button']"));
		WebElement VPSignIn = driver.findElement(
				By.xpath("//a[contains(text(), 'Sign In') and not(contains(@aria-labelledby ,'VPSignIn'))]"));
		validate(CreateProfile);
		validate(VPSignIn);
		if (CreateProfile.isEnabled() && VPSignIn.isEnabled()) {
			Assertion.assertTrue(true);
			System.out.println("Visitor Profile elements are present on home page");
		} else {
			Assertion.fail("Visitor Profile elements are not present on home page");
		}
		visitorprofileicon.click();
		jsClickNew(CreateProfile);
		CommonUtility.checkPageIsReadyNew(driver);
		// driver.navigate().refresh();
		// sleepBySec(3);
		// WebElement GuestProfile = driver.findElement(By.xpath("//*[contains(text(),
		// 'Your Guest Profile')]"));
		/*
		 * WebElement GuestProfile =
		 * driver.findElement(By.xpath("//h2[contains(text(), 'Your Guest Profile')]"));
		 * CheckPageLoad(); waitForPageLoadSafari(); CheckiPerseptions();
		 * CommonUtility.waitForPageLoadNew(driver, GuestProfile, 30);
		 */
		if (driver.getCurrentUrl().contains("profile")) {
			Assertion.assertTrue(true);
			System.out.println("Visitor Profile Page opens successsfully");
		} else {
			Assertion.fail("Visitor Profile page is not opening up");
		}
		/*
		 * driver.navigate().back(); CommonUtility.checkPageIsReady(driver);
		 */
		/* CheckPageLoad(); */
		// waitForPageLoadSafari();
		// CheckiPerseptions();

		// CommonUtility.waitForPageLoadNew(driver, findPlansButton, 30);
	}

	public void navigateToPath(String path) {

		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL : " + CurrentURL);

		String NavigateToURL = CurrentURL + path;
		System.out.println("Navigating to URL : " + NavigateToURL);
		driver.navigate().to(NavigateToURL);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 30);
		System.out.println("Page Title : " + (driver.findElement(By.xpath("//title")).getText()));

	}

	public void validateGlobalFooterLinks() {
		scrollToView(footerSiteMapLink);
		// validateNew(footerHomeLink);
		// validateNew(footerAboutUsLink);
		// validateNew(footerContactUsLink);
		validateNew(footerSiteMapLink);
		validateNew(footerPrivacyPolicyLink);
		validateNew(footerTermsnConditionsLink);
		validateNew(footerDisclaimersLink);
		validateNew(footerAgentsnBrokersLink);
		validateNew(footerAccessibilitylink);
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			validateNew(aarpOrgLink);
		} else {
			System.out.println("UHC Medicare solutions site loaded");
		}
		validateNew(medicareAdvantagePlansLink);
		validateNew(medicareSupplementInsurancePlansLink);
		validateNew(medicarePrescriptionDrug_PlansLink);
		validateNew(medicareSpecialNeedsPlansLink);
		// validateNew(learnAboutMedicareLink);

		validateNew(planRecommendationLink);
		validateNew(drugCostEstimatorLink);
		validateNew(pharmacySearchLink);
		validateNew(providerSearchLink);

		validateNew(introductioMedicareLink);
		validateNew(eligibilityLink);
		validateNew(coverageChoiceLink);
		validateNew(medicareFaqLink);

		validateNew(aboutLink);
		validateNew(contactLink);
		validateNew(languageAssistanceLink);
	}

	public void validateTFNelement(String tfnXpath) {
		threadsleep(15);
		WebElement TFNelement = driver.findElement(By.xpath(tfnXpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		jse.executeScript("window.scrollBy(0,-500)");
		validate(TFNelement, 45);
		System.out.println(">>>>>>>>>>>>> :"+TFNelement.getText());
		if (TFNelement.isDisplayed()) {
			System.out.println("TFN is Displayed on Page : " + TFNelement.getText());
		} else {
			Assertion.fail("TFN elemnet is not found / displayed on page : " + tfnXpath);
		}
	}

	public void validateSubNavShopPlanLinks() {
		waitForPageLoadSafari();
		CheckPageLoad();
		CheckiPerseptions();

		waitforElement(ShopForaplan);
		if (ShopForaplan.isDisplayed()) {
			scrollToView(ShopForaplan);
			/*
			 * Actions actions = new Actions(driver); actions.moveToElement(ShopForaplan);
			 * actions.build().perform();
			 */

			jsMouseOver(ShopForaplan);
			/*
			 * JavascriptExecutor js = (JavascriptExecutor) driver;
			 * js.executeScript("$('#ghn_lnk_2').mouseover();");
			 */
			System.out.println("Hover over Shop for a Plan completed");
			// waitforElementNew(driver.findElement(By.xpath("//input[@id='nav-zipcode']")));
			// System.out.println("Submit button is displayed");
		}
		WebElement ZipCodeTxt = driver.findElement(By.xpath("//input[@id='nav-zipcode']"));
		WebElement FindPlansBtn = driver.findElement(By.xpath("//button//*[text()='Find Plans']"));
		WebElement RequestMoreInfoLink = driver
				.findElement(By.xpath("//a[text()='Request More Help and Information']"));
		WebElement EnrollLink = driver.findElement(By.xpath("//a[contains(@href,'enroll.html')]"));
		WebElement ShopLink = driver.findElement(By.xpath("//a[contains(@href,'shop.html')]"));
		WebElement ResourceLink = driver.findElement(By.xpath("//a[contains(@href,'resources.html')]"));

		WebElement MAplansLink = driver.findElement(
				By.xpath("//*[contains(@class, 'section-2')]//a[contains(@href,'medicare-advantage-plans.html')]"));
		List<WebElement> MedSuppPlansLink = driver.findElements(By.xpath(
				"//*[contains(@class, 'section-2')]//*[contains(@href,'medicare-supplement-plans.html') or contains(@href,'medicare-supplement-plans-classic.html')]"));
		WebElement PDPplansLink = driver.findElement(
				By.xpath("//*[contains(@class, 'section-2')]//a[contains(@href,'prescription-drug-plans.html')]"));
		WebElement SNPplansLink = driver.findElement(
				By.xpath("//*[contains(@class, 'section-2')]//a[contains(@href,'special-needs-plans.html')]"));

		WebElement PlanSelectorLink = driver.findElement(
				By.xpath("//*[contains(@class, 'section-3')]//a[contains(@href,'plan-recommendation-engine.html')]"));
		WebElement DCELink = driver
				.findElement(By.xpath("//*[contains(@class, 'section-3')]//a[contains(@href,'drug-cost-estimator')]"));
		WebElement PharmacySearchLink = driver
				.findElement(By.xpath("//*[contains(@class, 'section-3')]//a[contains(@href,'aarp-pharmacy.html')]"));
		WebElement searchDoctors = driver
				.findElement(By.xpath("//*[contains(@class, 'section-3')]//a[contains(text(),'Search Doctors')]"));
		
		WebElement searchDentists = driver
				.findElement(By.xpath("//*[contains(@class, 'section-3')]//a[contains(text(),'Search Dentists')]"));

		validateNew(ZipCodeTxt);
		validateNew(FindPlansBtn);
		validateNew(RequestMoreInfoLink);

		validateNew(EnrollLink);
		validateNew(ShopLink);
		validateNew(ResourceLink);

		validateNew(MAplansLink);
		Assertion.assertTrue("No Med Sup link found in the header navigation", MedSuppPlansLink.size() > 0);
		validateNew(PDPplansLink);
		validateNew(SNPplansLink);

		validateNew(PlanSelectorLink);
		validateNew(DCELink);
		validateNew(PharmacySearchLink);
		validateNew(searchDoctors);
		validateNew(searchDentists);

		if (ZipCodeTxt.isDisplayed() && FindPlansBtn.isDisplayed() && RequestMoreInfoLink.isDisplayed()
				&& EnrollLink.isDisplayed() && ShopLink.isDisplayed() && ResourceLink.isDisplayed()
				&& MAplansLink.isDisplayed() && PDPplansLink.isDisplayed() && SNPplansLink.isDisplayed()
				&& PlanSelectorLink.isDisplayed() && DCELink.isDisplayed() && PharmacySearchLink.isDisplayed()
				&& searchDoctors.isDisplayed()&& searchDentists.isDisplayed()) {
			Assertion.assertTrue(true);
			System.out.println("Sub Nav - Shop for a Plan - All links and element displayed on Page : ");
			// Actions actions = new Actions(driver);
			// actions.moveToElement(AARPlogo);
			// actions.build().perform();
			jsMouseOut(ShopForaplan);
			jsMouseOver(AARPlogo);
		} else {
			Assertion.fail("Sub Nav - Shop for a Plan - All links and element not found / displayed on page : ");
		}
	}

	public void validateSubNavMedEdLinks() {
		waitForPageLoadSafari();
		CheckPageLoad();
		CheckiPerseptions();

		waitforElement(lnkLearnAboutMedicare);
		if (lnkLearnAboutMedicare.isDisplayed()) {
			// Actions actions = new Actions(driver);
			// actions.moveToElement(lnkLearnAboutMedicare);
			// actions.build().perform();
			jsMouseOver(lnkLearnAboutMedicare);
			waitForPageLoadSafari();
			System.out.println("Hover over Learn about Medicare completed");
		}
		WebElement EligibilityTxt = driver
				.findElement(By.xpath("//*[contains(@class, 'sctn')]//a[contains(@href,'medicare-eligibility')]"));
		WebElement ChoicesBtn = driver.findElement(
				By.xpath("//*[contains(@class, 'sctn')]//a[contains(@href,'medicare-parts-and-medigap-plans')]"));
		WebElement PresProvidersBenefitsLink = driver
				.findElement(By.xpath("//*[contains(@class, 'sctn')]//a[contains(@href,'medicare-benefits')]"));
		WebElement CostbasicsLink = driver
				.findElement(By.xpath("//*[contains(@class, 'sctn')]//a[contains(@href,'medicare-costs')]"));
		WebElement MAplansLink = driver.findElement(By.xpath(
				"//*[contains(@class, 'sctn')]//a[contains(@href,'/medicare-education/medicare-advantage-plans')]"));
		WebElement MedSuppPlansLink = driver.findElement(
				// By.xpath("//*[contains(@class,
				// 'sctn')]//a[contains(@href,'medicare-supplement-plans.html')]"));
				By.xpath("//*[contains(@class, 'sctn')]//a[contains(text(),'Medicare Supplement Insurance')]"));
		WebElement PDPplansLink = driver
				.findElement(By.xpath("//*[contains(@class, 'sctn')]//a[contains(@href,'medicare-part-d')]"));

		// WebElement EnrollmentBasicsLink = driver.findElement(
		// By.xpath("//*[contains(@class,
		// 'sctn')]//a[contains(@href,'enrollment-and-changing-plans')]"));
		// WebElement compareMAMSPlans =
		// driver.findElement(By.xpath("//*[contains(@class,
		// 'sctn')]//a[contains(@href,'enrollment-and-changing-plans')]"));

		WebElement whenToEnrollLink = driver
				.findElement(By.xpath("//*[contains(@class, 'sctn')]//a[contains(@href,'when-to-enroll')]"));
		WebElement FAQLink = driver
				.findElement(By.xpath("//*[contains(@class, 'sctn')]//a[contains(@href,'medicare-faq')]"));

		validateNew(EligibilityTxt);
		validateNew(ChoicesBtn);
		validateNew(PresProvidersBenefitsLink);
		validateNew(CostbasicsLink);

		validateNew(MAplansLink);
		validateNew(MedSuppPlansLink);
		validateNew(PDPplansLink);
		// validateNew(compareMAMSPlans);

		// validateNew(EnrollmentBasicsLink);
		validateNew(whenToEnrollLink);
		validateNew(FAQLink);

		if (EligibilityTxt.isDisplayed() && ChoicesBtn.isDisplayed() && PresProvidersBenefitsLink.isDisplayed()
				&& CostbasicsLink.isDisplayed() && MAplansLink.isDisplayed() && MedSuppPlansLink.isDisplayed()
				&& PDPplansLink.isDisplayed() && whenToEnrollLink.isDisplayed() && FAQLink.isDisplayed()) {
			// && FAQLink.isDisplayed()
			// && compareMAMSPlans.isDisplayed()
			Assertion.assertTrue(true);
			System.out.println("Sub Nav - Learn about Medicare - All links and element displayed on Page");
			// Actions actions = new Actions(driver);
			// actions.moveToElement(AARPlogo);
			// actions.build().perform();
			jsMouseOut(lnkLearnAboutMedicare);
			jsMouseOver(AARPlogo);
		} else {
			Assertion.fail("Sub Nav - Learn about Medicare - All links and element not found / displayed on page");
		}
	}

	public void validateStateDropDown() {
		validateNew(stateDropDown);
		selectFromDropDownByValue(stateDropDown, "California");

		// String StateSessionStorage = ReturnDriverStorage(driver, "sessionStorage",
		// "ucp_geotrackingState");

		String StateSessionStorage = returnDriverStorageJS("sessionStorage", "ucp_geotrackingState");

		// ReturnDriverStorage(driver, "sessionStorage", "ucp_geotrackingState");

		System.out.println("State selected : California");
		System.out.println("State GeoSessionStorage value : " + StateSessionStorage);
		Assertion.assertTrue("Geolocation State validation Failed ", StateSessionStorage.equalsIgnoreCase("CA"));
	}

	@FindBy(xpath = "//*[@id=\'accordion-disclaimer-button\']/div[2]")
	private WebElement hide_Disclaimer_Information;

	public void validateDisclaimer() {
		validateNew(disclaimerInformation);
		// disclaimerInformation.click();
		jsClickNew(disclaimerInformation);
		validateNew(hide_Disclaimer_Information);
		jsClickNew(hide_Disclaimer_Information);
	}

	public void validateVisitAarpOrglink() {
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			validateNew(visitAARPFooterLink);
			String hRef = visitAARPFooterLink.getAttribute("href");
			System.out.println("href for Visit AARP.org link : " + hRef);
			Assertion.assertTrue("Incorrect href for Visit AARP.org : " + hRef, hRef.contains("www.aarp.org"));
			visitAARPFooterLink.isEnabled();
		} else {
			System.out.println("UHC Medicare solutions site loaded");
		}

	}

	public void backToToplink() {
		validateNew(backToTop);
		// backToTop.click();
		jsClickNew(backToTop);
	}

	public boolean openPRE(String site) {
		boolean offline_prod = false;
		String browser = MRScenario.browserName;
		if (!(MRScenario.getProps() == null)) {// If running from local
			if (MRScenario.environment.equalsIgnoreCase("digital-devv2-aarp")) {
				startNewPRE(AARP_ACQISITION_PAGE_URL.replace("digital-devv2-aarp", "digital-devv2")
				.replace(".com/", ".com/plan-recommendation-engine.html#/get-started"), browser);
			} else if (MRScenario.environment.equalsIgnoreCase("digital-devv2")) {
				startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com/", ".com/plan-recommendation-engine.html#/get-started"), browser);
			} else if (MRScenario.environment.equalsIgnoreCase("team-f")) {
				startNewPRE(AARP_ACQISITION_PAGE_URL.replace(".com/", ".com/plan-recommendation-engine.html#/get-started"), browser);
			} else if (MRScenario.environment.equalsIgnoreCase("digital-uatv2-aarp")) {
				startNewPRE(AARP_ACQISITION_PAGE_URL.replace("digital-uatv2-aarp", "digital-uatv2")
						.replace(".com/", ".com/plan-recommendation-engine.html#/get-started").replace("www.", ""), browser);
			} else if (MRScenario.environment.equalsIgnoreCase("digital-uatv2")) {
				startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com/", ".com/plan-recommendation-engine.html#/get-started")
						.replace("www.", ""), browser);
			} else if (MRScenario.environment.equalsIgnoreCase("offline-stage-aarp")) {
				startNewPRE(AARP_ACQISITION_PAGE_URL.replace("offline-stage-aarp", "offline-stage").replace(".com/",
						".com/plan-recommendation-engine.html#/get-started"), browser);
			} else if (MRScenario.environment.equalsIgnoreCase("offline-stage")) {
				startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com/", ".com/plan-recommendation-engine.html#/get-started"), browser);
			} else if (MRScenario.environment.equalsIgnoreCase("stage-aarp")) {
				startNewPRE(AARP_ACQISITION_PAGE_URL.replace("stage-aarp", "stage").replace(".com/",
						".com/plan-recommendation-engine.html#/get-started"), browser);
			} else if (MRScenario.environment.equalsIgnoreCase("stage")) {
				startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com/", ".com/plan-recommendation-engine.html#/get-started"), browser);
			} else if (MRScenario.environment.equalsIgnoreCase("offline-prod-aarp")) {
				startNewPRE(AARP_ACQISITION_OFFLINE_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html#/get-started"),
						browser);
				offline_prod = true;
			} else if (MRScenario.environment.equalsIgnoreCase("offline-prod")) {
				startNewPRE(UMS_ACQISITION_OFFLINE_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html#/get-started"),
						browser);
				offline_prod = true;
			} else if (MRScenario.environment.equalsIgnoreCase("prod-aarp")) {
				startNewPRE(AARP_ACQISITION_PROD_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html#/get-started"),
						browser);
				offline_prod = true;
			} else if (MRScenario.environment.equalsIgnoreCase("prod")) {
				startNewPRE(UMS_ACQISITION_PROD_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html#/get-started"),
						browser);
				offline_prod = true;
			}
		} else { // For jenkins job
			String jenkinsTagLists = MRScenario.getTagLists();
			if (MRScenario.environment.equalsIgnoreCase("digital-uatv2")
					|| MRScenario.environment.equalsIgnoreCase("digital-devv2")
					|| MRScenario.environment.equalsIgnoreCase("team-f")
					|| MRScenario.environment.equalsIgnoreCase("stage")
					|| MRScenario.environment.equalsIgnoreCase("offline-stage")
					|| MRScenario.environment.equalsIgnoreCase("offline-stage-origin")
					|| MRScenario.environment.equalsIgnoreCase("mnr-acq-ci1")
					|| MRScenario.environment.equalsIgnoreCase("mnr-acq-ci2")) {
				for (String rname : jenkinsTagLists.split(",")) {
					if (rname.toUpperCase().contains("AARP") || site.toUpperCase().contains("AARP")) {
						if (MRScenario.environment.equalsIgnoreCase("digital-uatv2")
								|| MRScenario.environment.equalsIgnoreCase("offline-stage-origin"))
							startNewPRE(AARP_ACQISITION_PAGE_URL.replace(".com/", ".com/plan-recommendation-engine.html#/get-started").replace("www.", ""), browser);
						else
							startNewPRE(
									AARP_ACQISITION_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html#/get-started"),
									browser);
					}
					if (rname.toUpperCase().contains("UHC") || site.toUpperCase().contains("UHC")) {
						if (MRScenario.environment.equalsIgnoreCase("digital-uatv2")
								|| MRScenario.environment.equalsIgnoreCase("offline-stage-origin"))
							startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html#/get-started")
									.replace("www.", ""), browser);
						else
							startNewPRE(UMS_ACQISITION_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html#/get-started"),
									browser);
					}
				}
			}
			if (MRScenario.environment.equalsIgnoreCase("offline")) {
				for (String rname : jenkinsTagLists.split(",")) {
					if (rname.toUpperCase().contains("AARP") || site.toUpperCase().contains("AARP"))
						startNewPRE(AARP_ACQISITION_OFFLINE_PAGE_URL.replace(".com",
								".com/plan-recommendation-engine.html#/get-started"), browser);
					if (rname.toUpperCase().contains("UHC") || site.toUpperCase().contains("UHC"))
						startNewPRE(
								UMS_ACQISITION_OFFLINE_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html#/get-started"),
								browser);
				}
				offline_prod = true;
			}
			if (MRScenario.environment.equalsIgnoreCase("prod")) {
				for (String rname : jenkinsTagLists.split(",")) {
					if (rname.toUpperCase().contains("AARP") || site.toUpperCase().contains("AARP"))
						startNewPRE(
								AARP_ACQISITION_PROD_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html#/get-started"),
								browser);
					if (rname.toUpperCase().contains("UHC") || site.toUpperCase().contains("UHC"))
						startNewPRE(
								UMS_ACQISITION_PROD_PAGE_URL.replace(".com", ".com/plan-recommendation-engine.html#/get-started"),
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

		// driver.findElement(By.xpath("//*[@id='globalContentIdForSkipLink']/div/table/tbody/tr[2]/td/div[1]/div/div/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div/a")).click();
		jsClickNew(driver.findElement(By.xpath(
				"//*[@id='globalContentIdForSkipLink']/div/table/tbody/tr[2]/td/div[1]/div/div/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div/a")));
		waitForPageLoadSafari();
		return new PlanDocsPage(driver);
	}

	public VPPPlanSummaryPage searchPlansWithOutCountyShop(String zipcode) throws InterruptedException {

		CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
		sendkeys(zipCodeShopField, zipcode);
		jsClickNew(viewShopPlansButton);
		// }
		waitForPageLoadSafari();
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

	/*
	 * public RequestHelpAndInformationPage clickonFindanAgentlink(){ WebElement
	 * clickonFindanAgentlink = null; validateNew(RightRail_FindAnAgent);
	 * CommonUtility.waitForPageLoadNew(driver, RightRail_FindAnAgent, 30); String
	 * parentWindow = driver.getWindowHandle(); RightRail_FindAnAgent.click();
	 * sleepBySec(3); Set<String> tabs_windows = driver.getWindowHandles();
	 * Iterator<String> itr = tabs_windows.iterator(); while(itr.hasNext()) { String
	 * window = itr.next(); if(!parentWindow.equals(window)) {
	 * driver.switchTo().window(window); } }
	 * 
	 * CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("myuhcagent")) {
	 * System.out.println("myuhcagent Page is displayed");
	 * 
	 * 
	 * return new RequestHelpAndInformationPage(driver); } return null; } public
	 * void sleepBySec(int sec) { try { Thread.sleep(sec*1000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

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

	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean validateChatNonHours() throws InterruptedException {

		boolean present = true;
		try {
			WebElement chat = driver.findElement(By.xpath("//button[contains(@id,'sam-button--chat')]"));
			if (chat.getAttribute("class").contains("activeChatBtn")) {
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
			if (hours > 7 && hours < 19) {
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
		if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver, 20);

	}

	public void validateFifteenResults() {
		System.out.println("@@@@@Inside fifteen results validation@@@");
		int sizeofResults = driver.findElements(By.xpath("//div[@class='list-heading']")).size();
		System.out.println("number of results displayed on UI" + sizeofResults);
		if (sizeofResults <= 15) {
			System.out.println("@@@Inside results displayed less than or equal to 15");
			Assertion.assertTrue(true);
		} else {
			System.out.println("@@@Inside results displayed Incorrectly");
			Assertion.assertTrue(false);
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

			// driver.findElement(By.xpath("(//*[@class='pagination']/li/a)[" + i +
			// "]")).click();
			jsClickNew(driver.findElement(By.xpath("(//*[@class='pagination']/li/a)[" + i + "]")));

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

	public VPPPlanSummaryPage navigateToPathNew(String path) {

		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL : " + CurrentURL);

		String NavigateToURL = CurrentURL + path;
		System.out.println("Navigating to URL : " + NavigateToURL);
		driver.navigate().to(NavigateToURL);
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 30);
		System.out.println("Page Title : " + (driver.findElement(By.xpath("//title")).getText()));
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		} else {
			System.out.println("Navigation to vpp plan summary page is failed");
			return null;
		}
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
			String invalidSearch = driver.findElement(By.xpath("//div[@class='invalid-search']")).getText()
					.replaceAll("\\s+", " ");
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
		Assertion.assertEquals(expectedCount, expectedCountfromAttribute);
		System.out.println("check");

	}

	@FindBy(xpath = "(//*[contains(text(),'Sign in')])[1]")
	private WebElement memberSignInPage;

	// @FindBy(xpath="//a[contains(@href,'https://www.aarpmedicareplans.com/health-plans.html?WT.mc_id=8009508')]")
	@FindBy(xpath = "//a[contains(@href,'https://www.aarpmedicareplans.com') or contains(@href,'https://www.aarpmedicareplans.com/?WT.mc_id=8009508')]")
	private WebElement ViewMedicareplanlinks;

	public void clickonmemberSignInlink(String ExpectedmemberSigninURL) {
		//validateNew(memberSignInPage);
		//CommonUtility.waitForPageLoadNew(driver, memberSignInPage, 30);
		Actions action = new Actions(driver);
		action.moveToElement(planMemberLink).perform();
		validateNew(goToMemberSiteLink);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(goToMemberSiteLink);
		// memberSignInPage.click();
		//jsClickNew(memberSignInPage);
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
		String CurrentmemberSigninURL = driver.getCurrentUrl();
		String ActualmemberSigninURL = CurrentmemberSigninURL.substring(0, 28).trim();
		System.out.println("memberSignin Page is displayed : " + ActualmemberSigninURL);
		System.out.println("Expected member signin URL: " + ExpectedmemberSigninURL);
		System.out.println("Actual member signin URL: " + ActualmemberSigninURL);

		if (ExpectedmemberSigninURL.contains(ActualmemberSigninURL)) {
			System.out.println("****************member signin Page is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************member signin Page is not loaded ***************");
		}
		validateNew(ViewMedicareplanlinks);
		CommonUtility.waitForPageLoadNew(driver, ViewMedicareplanlinks, 30);
		String parentWindow1 = driver.getWindowHandle();
		jsClickNew(ViewMedicareplanlinks);
		sleepBySec(3);
		Set<String> tabs_windows1 = driver.getWindowHandles();
		Iterator<String> itr1 = tabs_windows1.iterator();
		while (itr1.hasNext()) {
			String window = itr1.next();
			if (!parentWindow1.equals(window)) {
				driver.switchTo().window(window);
			}
		}
	}

	public void clickBrowserBackButton() {
		driver.navigate().back();

		// Added refresh and wait as elements are not located in Safari 13 browser after
		// using navigate back
		if (MRScenario.browserName.equalsIgnoreCase("Safari")) {
			// driver.navigate().refresh();
			waitForPageLoadSafari();
		}
		CommonUtility.checkPageIsReadyNew(driver);
	}

	public RequestHelpAndInformationPage RequestLinkOnShopPlan() throws Exception {
		// Thread.sleep(4000);
		if (validate(RequestMoreInformationLink)) {
			waitforElement(RequestMoreInformationLink);
			System.out.println("Contact Us Page is Displayed");
			return new RequestHelpAndInformationPage(driver);
		}
		return null;
	}

	public RequestHelpAndInformationPage navigateToRequestmoreHelp() {

		waitforElement(ShopForaplan);
		if (ShopForaplan.isDisplayed()) {
			/*
			 * Actions action = new Actions(driver);
			 * action.moveToElement(ShopForaplan).build().perform();
			 */
			jsMouseOver(ShopForaplan);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			validateNew(RequestMoreInformationLink);
			jsClickNew(RequestMoreInformationLink);
			return new RequestHelpAndInformationPage(driver);
		} else {
			return null;
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

	public void hoverOverShopForPlan() {
		waitforElement(ShopForaplan);
		if (ShopForaplan.isDisplayed()) {
			jsMouseOver(ShopForaplan);
			System.out.println("Hover over Shop for a Plan completed");
		}
	}

	// public void clickVisitAARPHeaderLink() {
	// if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
	// jsClickNew(visitAARPHeaderLink);
	// if(!driver.getCurrentUrl().contains("aarp.org"))
	// Assertion.fail("Visit AARP link did not lead to the right page");
	// }
	//
	// }
	//
	// public void clickVisitAARPFooterLink() {
	// if(driver.getCurrentUrl().contains("aarpmedicareplans")) {
	// jsClickNew(visitAARPFooterLink);
	// if(!driver.getCurrentUrl().contains("aarp.org"))
	// Assertion.fail("Visit AARP link did not lead to the right page");
	// }
	// }
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

	public void headerRegisterLink() {
		validateNew(headerRegisterLink);
		Assertion.assertTrue(true);
		jsClickNew(headerRegisterLink);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if (validate(registerFirstName))
			System.out.println("Register link is displayed in the header");
		else
			Assertion.fail("Register link did not lead to the right page");
	}

	public void clickVisitAARPHeaderLink() {
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			CommonConstants.setMainWindowHandle(driver.getWindowHandle());
			jsClickNew(visitAARPHeaderLink);
			// waitForPageLoadSafari();
			Set<String> winHandles = driver.getWindowHandles();
			for (String win : winHandles) {
				// if (!win.equals(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION)) {
				if (!win.equals(CommonConstants.getMainWindowHandle())) {
					driver.switchTo().window(win);
					proceedToLeaveAARP();
					if (!driver.getCurrentUrl().contains("aarp.org")) {
						Assertion.fail("Visit AARP link did not lead to the right page");
					} else {
						Assertion.assertTrue("Navigated to AARP org page", true);
					}
					driver.close();
					break;
				}
			}
			// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
			driver.switchTo().window(CommonConstants.getMainWindowHandle());
		}

	}
	public void clickVisitAARPHeaderLinkforcancel() {
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			jsClickNew(visitAARPHeaderLink);
			//proceedToLeaveAARP();
			cancelLeaveAARPRedirect();
			// CommonUtility.checkPageIsReadyNew(driver);
			if (driver.getCurrentUrl().contains("aarp.org")) {
				Assertion.fail("Visit AARP link did not lead to the right page");
			} else {
				Assertion.assertTrue("Navigated to AARP org page", true);
			}
		}

	}

	public void clickVisitAARPFooterLink() {
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			// CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
			CommonConstants.setMainWindowHandle(driver.getWindowHandle());
			jsClickNew(visitAARPFooterLink);
			// waitForPageLoadSafari();
			Set<String> winHandles = driver.getWindowHandles();
			for (String win : winHandles) {
				// if (!win.equals(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION)) {
				if (!win.equals(CommonConstants.getMainWindowHandle())) {
					driver.switchTo().window(win);
					proceedToLeaveAARP();
					if (!driver.getCurrentUrl().contains("aarp.org")) {
						Assertion.fail("Visit AARP link did not lead to the right page");
					} else {
						Assertion.assertTrue("Navigated to AARP org page", true);
					}
					driver.close();
					break;
				}
			}
			// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
			driver.switchTo().window(CommonConstants.getMainWindowHandle());
		}
	}

	public void proceedToLeaveAARP() {
		if (validate(leaveAARPMedicarePlansDialog)) {
			jsClickNew(proceedLeaveAARPMedicare);
			waitForPageLoadSafari();
			sleepBySec(5);
			// CommonUtility.checkPageIsReadyNew(driver);
		}
	}

	public void cancelLeaveAARPRedirect() {
		if (validate(leaveAARPMedicarePlansDialog)) {
			jsClickNew(cancelLeaveAARPMedicare);
			waitForPageLoadSafari();
			// CommonUtility.checkPageIsReadyNew(driver);
		}
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
		// footerSiteMapLink.click();
		jsClickNew(footerSiteMapLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(siteMapHeader);
		if (driver.getCurrentUrl().contains("sitemap.html")) {
			return new SiteMapAARPPage(driver);
		}
		return null;
	}

	public PrivacyPolicyAARPPage privacypolicyFooterClick() {
		validateNew(footerPrivacyPolicyLink);
		// footerPrivacyPolicyLink.click();
		jsClickNew(footerPrivacyPolicyLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(privacyHeader);
		if (driver.getCurrentUrl().contains("privacy-policy.html")) {
			return new PrivacyPolicyAARPPage(driver);
		}
		return null;
	}

	// public void clickBrowserBackButton() {
	// driver.navigate().back();
	// }
	//
	// }

	public String fetchEnvironmentUrls() {
		if (MRScenario.environment.equals("offline")) {
			testSiteUrl = AARP_ACQISITION_OFFLINE_PAGE_URL;
			return testSiteUrl;
		} else if (MRScenario.environment.equals("prod")) {
			testSiteUrl = AARP_ACQISITION_PROD_PAGE_URL;
			return testSiteUrl;
		} else if (MRScenario.environment.contains("stage-0")) {
			testSiteUrl = AARP_ACQISITION_PAGE_URL_NEW;
			return testSiteUrl;
		} else
			testSiteUrl = AARP_ACQISITION_PAGE_URL;
		return testSiteUrl;
	}

	public LearnAboutMedicareHomePage clickLearnMoreOnHomePage() {

		validateNew(learnAboutMedicareHomeScreen);
		jsClickNew(learnAboutMedicareHomeScreen);
		waitForPageLoadSafari();
		String urlCheck = driver.getCurrentUrl();
		if (urlCheck.contains("medicare-education.html") || urlCheck.contains("medicare-education-classic.html")) {
			return new LearnAboutMedicareHomePage(driver);
		} else {
			return null;
		}
	}

	public String fetchEnvironmentUrlsUMS() {
		if (MRScenario.environment.equals("offline")) {
			testSiteUrl = UMS_ACQISITION_OFFLINE_PAGE_URL;
			return testSiteUrl;
		} else if (MRScenario.environment.equals("prod")) {
			testSiteUrl = UMS_ACQISITION_PROD_PAGE_URL;
			return testSiteUrl;
		} else if (MRScenario.environment.contains("stage-0")) {
			testSiteUrl = UMS_ACQISITION_PAGE_URL_NEW;
			return testSiteUrl;
		} else
			testSiteUrl = UMS_ACQISITION_PAGE_URL;
		return testSiteUrl;
	}

	public void clickonmemberSignInStagelink(String ExpectedmemberSigninURL) {
		//validateNew(memberSignInPage);
		//CommonUtility.waitForPageLoadNew(driver, memberSignInPage, 30);
		Actions action = new Actions(driver);
		action.moveToElement(planMemberLink).perform();
		validateNew(goToMemberSiteLink);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(goToMemberSiteLink);
		//jsClickNew(memberSignInPage);
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
		String CurrentmemberSigninURL = driver.getCurrentUrl();
		String ActualmemberSigninURL = CurrentmemberSigninURL.substring(0, 31).trim();
		System.out.println("memberSignin Page is displayed : " + ActualmemberSigninURL);
		System.out.println("Expected member signin URL: " + ExpectedmemberSigninURL);
		System.out.println("Actual member signin URL: " + ActualmemberSigninURL);

		if (ExpectedmemberSigninURL.contains(ActualmemberSigninURL)) {
			System.out.println("****************member signin Page is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************member signin Page is not loaded ***************");
		}
		// ViewMedicareplanlinks.click();
		validateNew(ViewMedicareplanlinks);
		CommonUtility.waitForPageLoadNew(driver, ViewMedicareplanlinks, 30);
		//String parentWindow1 = driver.getWindowHandle();
		jsClickNew(ViewMedicareplanlinks);
		sleepBySec(3);
		//Set<String> tabs_windows1 = driver.getWindowHandles();
		//Iterator<String> itr1 = tabs_windows1.iterator();
		/*while (itr1.hasNext()) {
			String window = itr1.next();
			if (!parentWindow1.equals(window)) {
				driver.switchTo().window(window);
			}
		}*/
		CommonUtility.checkPageIsReadyNew(driver);
		String stageURL = "https://www.stage-aarpmedicareplans.uhc.com/";
		String prodURL = "https://www.aarpmedicareplans.com/";
		String urlCheck = driver.getCurrentUrl();
		String expectedURL = urlCheck.replace(prodURL, stageURL);
		System.out.println("**********Actual URL is displayed *************" + expectedURL);

	}

	public void clickonmemberSignInOfflinelink(String ExpectedmemberSigninURL) {
		//validateNew(memberSignInPage);
				//CommonUtility.waitForPageLoadNew(driver, memberSignInPage, 30);
				Actions action = new Actions(driver);
				action.moveToElement(planMemberLink).perform();
				validateNew(goToMemberSiteLink);
				String parentWindow = driver.getWindowHandle();
				jsClickNew(goToMemberSiteLink);
				//jsClickNew(memberSignInPage);
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
		String CurrentmemberSigninURL = driver.getCurrentUrl();
		String ActualmemberSigninURL = CurrentmemberSigninURL.substring(0, 32).trim();
		System.out.println("memberSignin Page is displayed : " + ActualmemberSigninURL);
		System.out.println("Expected member signin URL: " + ExpectedmemberSigninURL);
		System.out.println("Actual member signin URL: " + ActualmemberSigninURL);

		if (ExpectedmemberSigninURL.contains(ActualmemberSigninURL)) {
			System.out.println("****************member signin Page is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************member signin Page is not loaded ***************");
		}
		// ViewMedicareplanlinks.click();
				validateNew(ViewMedicareplanlinks);
				CommonUtility.waitForPageLoadNew(driver, ViewMedicareplanlinks, 30);
				//String parentWindow1 = driver.getWindowHandle();
				jsClickNew(ViewMedicareplanlinks);
				sleepBySec(3);
				//Set<String> tabs_windows1 = driver.getWindowHandles();
				//Iterator<String> itr1 = tabs_windows1.iterator();
				/*while (itr1.hasNext()) {
					String window = itr1.next();
					if (!parentWindow1.equals(window)) {
						driver.switchTo().window(window);
					}
				}*/
		CommonUtility.checkPageIsReadyNew(driver);
		String stageURL = "https://www.stage-aarpmedicareplans.uhc.com/";
		String prodURL = "https://www.aarpmedicareplans.com/";
		String offlineprodURL = "https://offline.aarpmedicareplans.com/";
		String urlCheck = driver.getCurrentUrl();
		String expectedURL = urlCheck.replace(prodURL, offlineprodURL);
		System.out.println("**********Actual URL is displayed *************" + expectedURL);

	}

	public void MedicareAdvantagePlans() {
		// threadsleep(6);
		threadsleep(5000);
		// MedicareAdvantagePlans.click();
		jsClickNew(MedicareAdvantagePlans);
		threadsleep(5000);
		if (driver.getCurrentUrl().contains("shop/medicare-advantage-plans.html")) {
			Assertion.assertTrue(true);
			System.out.println("MA Plan Page open: URL-->  " + driver.getCurrentUrl());
		} else {
			Assertion.fail("Error loading MA Link");
		}
		// Assertion.assertEquals(driver.getCurrentUrl(),
		// "https://www.stage-aarpmedicareplans.uhc.com/shop/medicare-advantage-plans.html");
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			assertTrue(true);
		}
	}

	public void DualSplNeedPlans() {

		threadsleep(6);
		// DualSpecialNeedsPlans.click();
		jsClickNew(DualSpecialNeedsPlans);
		threadsleep(5);
		if (driver.getCurrentUrl().contains("shop/dual-special-needs-plans.html")) {
			Assertion.assertTrue(true);
			System.out.println("DSNP Plan Page open: URL--> " + driver.getCurrentUrl());
		} else {
			Assertion.fail("Error loading DSNP Link");
		}
		// Assertion.assertEquals(driver.getCurrentUrl(),
		// "https://www.stage-aarpmedicareplans.uhc.com/shop/dual-special-needs-plans.html");
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			assertTrue(true);
		}

	}

	public void Medicaresupplementinsuranceplans() {

		threadsleep(6);
		// MedicareSupplementInsurancePlans.click();
		scrollToView(MedicareSupplementInsurancePlans);
		jsClickNew(MedicareSupplementInsurancePlans);
		threadsleep(5);
		if (driver.getCurrentUrl().contains("shop/medicare-supplement-plans.html")) {
			Assertion.assertTrue(true);
			System.out.println("MS Plan Page open: URL-->" + driver.getCurrentUrl());
		} else {
			Assertion.fail("Error loading MS link");
		}
		// Assertion.assertEquals(driver.getCurrentUrl(),
		// "https://www.stage-aarpmedicareplans.uhc.com/shop/medicare-supplement-plans.html");
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			assertTrue(true);
		}
	}

	public void MedicarePrescriptionDrugPlans() {

		threadsleep(6);
		// MedicarePrescriptionDrugPlans.click();
		jsClickNew(footerMedicarePrescriptionDrugPlans);
		threadsleep(5);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("shop/prescription-drug-plans.html")) {
			Assertion.assertTrue(true);
			System.out.println("PDP Plan Page open: URL-->" + driver.getCurrentUrl());
		} else {
			Assertion.fail("Error loading PDP link");
		}
		// Assertion.assertEquals(driver.getCurrentUrl(),
		// "https://www.stage-aarpmedicareplans.uhc.com/shop/prescription-drug-plans.html");
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			assertTrue(true);
		}
	}

	public void MedicareEducation() {
		threadsleep(6);
		// MedicareEducation.click();
		jsClickNew(MedicareEducation);
		threadsleep(5);
		if (driver.getCurrentUrl().contains("medicare-education")) {
			Assert.assertTrue(true);
			System.out.println("Medicare Education Homepage open: URL-->" + driver.getCurrentUrl());
		} else {
			Assert.fail("Error loading Medicare Education Homepage link");
		}
		// Assertion.assertEquals(driver.getCurrentUrl(),
		// "https://www.stage-aarpmedicareplans.uhc.com/medicare-education.html");
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			assertTrue(true);
		}

	}

	public void backtotop() {
		threadsleep(6);
		// BackToTop.click();
		jsClickNew(BackToTop);
		threadsleep(5);
		if (driver.getCurrentUrl().contains("aarpmedicareplans.com")
				|| driver.getCurrentUrl().contains("uhcmedicaresolutions.com")) {
			assertTrue(true);
		}

	}

	public void Accessibility() {

		// threadsleep(6);
		threadsleep(5000);
		// Accessibility.click();
		String base = driver.getWindowHandle();
		jsClickNew(Accessibility);
		threadsleep(5000);
		// Assertion.assertEquals(driver.getCurrentUrl(),
		// "https://www.uhc.com/legal/accessibility");
		Set<String> all = driver.getWindowHandles();
		Iterator<String> I = all.iterator();
		while (I.hasNext()) {
			String childWindow = I.next();
			if (!base.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				Assert.assertTrue(driver.getCurrentUrl().contains("accessibility"));
				driver.close();
			}
		}
		driver.switchTo().window(base);
		/*if (driver.getCurrentUrl().contains("accessibility")) {
			assertTrue(true);
		}*/
	}

	public void clickUnitedHealthcareMedicareSolutions() {
		// threadsleep(8);
		threadsleep(5000);
		// UnitedHealthcareMedicareSolutions.click();
		jsClickNew(UnitedHealthcareMedicareSolutions);
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
			assertTrue(true);
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

	public VPPPlanSummaryPage checkZipCompSubNavVpp(String zipCode) {
		sendkeys(OurPlans_zipfield, zipCode);
		jsClickNew(FindPlansButton1);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		if (getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE)) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	/**
	 * This method used to navigate to new visitor profile dashboard
	 * 
	 * @return
	 */
	public VisitorProfilePage navigateToNewVisitorProfilePage() {
		waitForPageLoadSafari();
		try {
			if (savedPlansPopup.isDisplayed()) {
				savedPlansPopupCloseIcon.click();
			}
		} catch (Exception e) {
			System.out.println("Saved Plans modal not displayed");
		}
		waitforElement(shoppingCartIcon);
		shoppingCartIcon.click();
		guestProfileLink.click();
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("profile")) {
			System.out.println("Navigated to Visitor profile page");
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			Assertion.fail("User not navigated to Visitor profile page");
		}
		return null;
	}

	public PharmacySearchPage navigateToPharmacyLocatorFromPlanType() {
		jsMouseOver(navigationSectionHomeLink);
		jsMouseOver(ourPlansHoverLink);
		jsClickNew(planTypePDPLink);
		CommonUtility.checkPageIsReadyNew(driver);
		waitforElement(shoppingCartIcon);
		jsClickNew(pdpPharmacyLink);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if (driver.getTitle().toLowerCase()
				.contains((PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase())) {
			return new PharmacySearchPage(driver);
		}
		return null;

	}

	// method to click View Disclaimer Information link present in Footer
	public void clickViewDisclaimerInfoLink() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(viewAllDisclaimerInformationLink);
		jsClickNew(viewAllDisclaimerInformationLink);
		sleepBySec(2);
		WebElement content = driver.findElement(By.xpath("//div[contains(@class,'hidedisclaimerstext')]"));
		if (content.isDisplayed() && content.isEnabled()) {
			System.out.println("View Diclaimer Information Link clicked Successfully");
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Error clicking View Diclaimer Information Link ");
		}
	}

	// method to click Hide Disclaimer Information link present in Footer
	public void clickHideDisclaimerInfoLink() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(hideDiscliamerInformation);
		jsClickNew(hideDiscliamerInformation);
		sleepBySec(2);
		WebElement content = driver.findElement(By.xpath("//div[contains(@class,'hidedisclaimers')]"));
		if (!content.isDisplayed() && content.isEnabled()) {
			System.out.println("Hide Diclaimer Information Link clicked Successfully");
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Error clicking Hide Diclaimer Information Link ");
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
			Assertion.fail("Error Clicking Contact( " + language + " ) link");
		}
		// driver.navigate().back();
		WebElement headLogo = driver.findElement(By.xpath("//a[contains(@class,'uhc-header__logo') and not(contains(@style,'display'))]"));
		scrollToView(headLogo);
		headLogo.click();
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
		// jsClickNew(backToTop);
	}

	public void clickComplaintFormLink() {
		WebElement lnkComplaintForm = driver.findElement(By.xpath("(//a[contains(text(),'Complaint Form')])[1]"));
		validateNew(lnkComplaintForm);
		scrollToView(lnkComplaintForm);
		jsClickNew(lnkComplaintForm);
		proceedToLeaveAARP();
		if (driver.getCurrentUrl().contains("medicare.gov/MedicareComplaintForm")) {
			System.out.println("Successfully clicked Complaint Form link");
			Assertion.assertTrue(true);

		} else {
			Assertion.fail("Error clicking Complaint Form link");
		}
		driver.navigate().back();
		CommonUtility.checkPageIsReadyNew(driver);
		clickViewDisclaimerInfoLink();
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
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Assistance link( " + language + " ) did not clicked Successfully ");
		}
		driver.close();
		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());
		CommonUtility.checkPageIsReadyNew(driver);
	}

	public void closeBrowserTab() {
		if (driver.getWindowHandles().size() > 1) {
			String currentPage = driver.getWindowHandle();
			Set<String> newWindow = driver.getWindowHandles();
			for (String tabs : newWindow) {
				if (!tabs.equalsIgnoreCase(currentPage)) {
					driver.switchTo().window(currentPage).close();
					driver.switchTo().window(tabs);
					CommonUtility.checkPageIsReadyNew(driver);
				}
			}
		}

	}

	public ShopForPlanNavigationPage HoveronalearnaboutMedicare() throws InterruptedException {
		waitforElement(learnaboutMedicare);
		if (learnaboutMedicare.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(learnaboutMedicare).build().perform();
			jsMouseOver(learnaboutMedicare);
			return new ShopForPlanNavigationPage(driver);
		} else {
			return null;
		}
	}

	public VPPPlanSummaryPage searchPlansWithOutCountyLearnMedicareMedsupp(String zipcode) throws InterruptedException {

		CommonUtility.waitForPageLoadNew(driver, zipCodeMedicareField, 30);
		sendkeys(zipCodeMedicareField, zipcode);
		// jsClickNew(LearnMedicareMedsuppEnrollButton);
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoadNew(driver, LearnMedicareMedsuppEnrollButton, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(LearnMedicareMedsuppEnrollButton);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(parentWindow);
				driver.close();
				driver.switchTo().window(window);
			}
		}
		CommonUtility.waitForPageLoadNew(driver, zipcodeChangeLink, 30);
		if (driver.getCurrentUrl().contains("health-plans")) {
			return new VPPPlanSummaryPage(driver);
		} else
			return null;
	}

	public VPPPlanSummaryPage searchPlansLearnMedicareMedsupp(String zipcode, String countyName) {
		CommonUtility.waitForPageLoadNew(driver, zipCodeMedicareField, 30);
		sendkeys(zipCodeMedicareField, zipcode);
		CommonUtility.waitForPageLoadNew(driver, LearnMedicareMedsuppEnrollButton, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(LearnMedicareMedsuppEnrollButton);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}
		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		if (validate(countyModal))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public ProviderSearchPage clicksOnRallyToolFromGlobalHeader() {

		// Actions action = new Actions(driver);
		// action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		jsMouseOver(navigationSectionHomeLink);
		jsMouseOver(ourPlansHoverLink);
		jsClickNew(pharmacylocator);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if (driver.getTitle().toLowerCase()
				.contains((PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase())) {
			return new ProviderSearchPage(driver);
		}
		return null;
	}

	public void enterAndvalidateEmail() {
		threadsleep(8);
		int size = driver.findElements(By.xpath("//span[contains(text(),'Sign Up')]")).size();
		System.out.println("size of sign up" + size);
		if (size > 0) {
			driver.findElement(By.xpath("//span[contains(text(),'Sign Up')]")).click();
			threadsleep(4);
			Assertion.assertEquals(ErrorEmailAddress.getText(), "Error: Please enter a valid email address");
			threadsleep(4);
			EmailFirstName.sendKeys("abc");
			EmailLastName.sendKeys("def");
			EmailAddress.sendKeys("a@gmail.com");
			driver.findElement(By.xpath("//span[contains(text(),'Sign Up')]")).click();
		} else {
			threadsleep(8);
			// SubmitEmail.click();
			scrollToView(SubmitEmail);
			jsClickNew(SubmitEmail);
			threadsleep(4);
			Assertion.assertEquals(ErrorFirstName.getText(), "Error: Please enter First Name");
			threadsleep(2);
			Assertion.assertEquals(ErrorLastName.getText(), "Error: Please enter Last Name");
			threadsleep(2);
			Assertion.assertEquals(ErrorEmailAddress.getText(), "Error: Please enter a valid email address");
			threadsleep(4);
			EmailFirstName.sendKeys("abc");
			EmailLastName.sendKeys("def");
			EmailAddress.sendKeys("a@gmail.com");
			// SubmitEmail.click();
			jsClickNew(SubmitEmail);
			threadsleep(4);
			if (Thankyou.getText().equalsIgnoreCase("Thank you!")) {
				assertTrue(true);
			}
		}

	}

	public TermsnConditionsAARPPage termsnconditionsFooterClick() {
		validate(footerTermsnConditionsLink);
		// footerTermsnConditionsLink.click();
		jsClickNew(footerTermsnConditionsLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("terms-of-use")) {
			return new TermsnConditionsAARPPage(driver);
		}
		return null;
	}

	public DisclaimersAARPPage disclaimersFooterClick() {
		validate(footerDisclaimersLink);
		// footerDisclaimersLink.click();
		jsClickNew(footerDisclaimersLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("disclaimer")) {
			return new DisclaimersAARPPage(driver);
		}
		return null;
	}

	public AgentsnBrokersAARPPage agentsnbrokersFooterClick() {
		validate(footerAgentsnBrokersLink);
		// footerAgentsnBrokersLink.click();
		jsClickNew(footerAgentsnBrokersLink);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(brokerHeader);
		if (driver.getCurrentUrl().contains("health-insurance-brokers")) {
			return new AgentsnBrokersAARPPage(driver);
		}
		return null;
	}

	public AcquisitionHomePage homeFooterClick() {
		validateNew(footerHomeLink);
		// footerHomeLink.click();
		jsClickNew(footerHomeLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (validateNew(zipCodeField)) {
			return new AcquisitionHomePage(driver, true);
		}
		return null;
	}

	public VPPPlanSummaryPage searchPlansWithOutCountyShopDSNPEnroll(String zipcode) throws InterruptedException {

		CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
		sendkeys(zipCodeShopField, zipcode);
		jsClickNew(ShopdsnpEnrollButton);
		waitForPageLoadSafari();
		// }
		CommonUtility.waitForPageLoadNew(driver, zipcodeChangeLink, 30);
		if (driver.getCurrentUrl().contains("health-plans")) {
			return new VPPPlanSummaryPage(driver);
		} else
			return null;
	}

	public VPPPlanSummaryPage searchPlansShopDSNPEnroll(String zipcode, String countyName) {
		CommonUtility.waitForPageLoadNew(driver, zipCodeShopField, 30);
		sendkeys(zipCodeShopField, zipcode);
		jsClickNew(ShopdsnpEnrollButton);
		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		if (validate(countyModal))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
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
		 * Assertion.assertTrue(true); } else { Assertion.
		 * fail("****************myuhcagent Page is not loaded ***************"); }
		 */
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

		// close the window only if a new window is opened
		if (tabs_windows.size() > 1) {
			driver.close();
			driver.switchTo().window(parentWindow);
		}

	}

	public void clickHomeTab() {
		homeTab.click();
	}

	public void validateHomePage() {
		validate(zipCodeField);
	}

	public void validatePageNavigated(String path) {
		if (driver.getCurrentUrl().contains(path)) {
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("User not navigated to correct page");
		}
	}

	public void validateCallpopuponapage(String TFNXpath, String ExpecetdTFNNo) throws InterruptedException {
		// driver.navigate().refresh();
		CommonUtility.checkPageIsReady(driver);
		CheckiPerseptions();
		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);
		// if(validateNew(TFNelement) && TFNelement.isDisplayed()) {
		if (ExpecetdTFNNo.contains(ActualTFNelement.getText())) {
			System.out.println("TFN is Displayed on Page : " + ActualTFNelement.getText());

		}

		else {
			Assertion.fail("TFN elemnet is not found / displayed on page : " + TFNXpath);
		}
		// validate(callsamtooltip);
		validate(ActualTFNelement);
		String ActualCallSAMTFN = ActualTFNelement.getText();
		System.out.println("TFN No displayed on the Page" + ActualCallSAMTFN);
		jsClickNew(ActualTFNelement);
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		driver.switchTo().activeElement();
		validate(CallSamTFN);
		String ExpectedCallSAMTFN = CallSamTFN.getText();
		System.out.println("TFN No displayed on the Page" + ExpectedCallSAMTFN);
		if (ExpectedCallSAMTFN.contains(ActualCallSAMTFN)) {
			System.out
					.println("****************TFN number was  found macthing with the SAM call Popup  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("*****************TFN number was  not found macthing with the SAM call Popup ***************"
					+ ExpectedCallSAMTFN);
		}
		String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. � 8 p.m., 7 days a week.*\n*Alaska and Hawaii: 8 a.m. � 8 p.m. Monday � Friday, 8 a.m. � 5 p.m. Saturday and Sunday.";
		validate(CallSamTFNtimezone);
		String ActualCallSamTFNtimezone = CallSamTFNtimezone.getText();
		System.out.println(ExpectedCallSamTFNtimezone);
		System.out.println(ActualCallSamTFNtimezone);
		if (ExpectedCallSamTFNtimezone.replace(" ", "").replace("\n", "")
				.equalsIgnoreCase(ActualCallSamTFNtimezone.replace(" ", "").replace("\n", ""))) {
			System.out.println(
					"****************TFN Timezone Content was  found macthing with the SAM call Popup  ***************");

		} else {
			System.out.println(
					"****************TFN Timezone Content was not found macthing with the SAM call Popup  ***************");
		}
		String ExpectedCallSamTFNMember = "Already a member? Call the number on the back of your member ID card.";
		// ActualCallSamTFNMember.replace("", " ");
		// WebElement strCallSamTFNMember=
		// driver.findElement(By.xpath("//p[contains(text(),'Already a member?')]"));
		validate(CallSamTFNMember);
		String ActualCallSamTFNMember = CallSamTFNMember.getText();
		System.out.println(ExpectedCallSamTFNMember);
		if (ExpectedCallSamTFNMember.equalsIgnoreCase(ActualCallSamTFNMember)) {
			System.out.println(
					"****************TFN Member Content was  found macthing with the SAM call Popup  ***************");
			Assertion.assertTrue(true);
		} else {
			Assertion.fail(
					"*****************TFN Member Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);
		}
		validate(CallSamTFNClose);
		jsClickNew(CallSamTFNClose);
		/*
		 * validate(callsamtooltip); CheckiPerseptions(); callsam.click();
		 * System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		 * driver.switchTo().activeElement(); System.out.println(CallSamTFN.getText());
		 * CallSamTFNClose.click(); validateNew(callsam); return null;
		 */
		// return null;
	}

	public IsInsuranceAgent navigateToISPath(String path) {

		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL : " + CurrentURL);

		String NavigateToURL = CurrentURL + path;
		System.out.println("Navigating to URL : " + NavigateToURL);
		driver.navigate().to(NavigateToURL);
		// CommonUtility.waitForPageLoad(driver,
		// driver.findElement(By.xpath("//header[contains(@class,'header')]")), 30);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Page Title : " + (driver.findElement(By.xpath("//title")).getText()));
		// return IsInsuranceAgent;
		return new IsInsuranceAgent(driver);

	}

	public void openExternalLinkPRE(String site) {
		String browser = MRScenario.browserName;
		if (site.equalsIgnoreCase("Myuhcplans")) {
			startNewPRE("https://myuhcplans.com/steelcase", browser);
		}
		if (site.equalsIgnoreCase("uhcandwellmedsa")) {
			startNewPRE("https://www.uhcandwellmedsa.com/", browser);
		}
		if (site.equalsIgnoreCase("mauhcmedicaresolutions")) {
			startNewPRE("https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage", browser);
		}
		if (site.equalsIgnoreCase("maaarpmedicareplans")) {
			startNewPRE("https://ma.aarpmedicareplans.com/aarp-medicare-advantage", browser);
		}
		if (site.equalsIgnoreCase("uhcmedicaresolutions")) {
			startNewPRE("https://www.uhcmedicaresolutions.com/", browser);
		}
		if (site.equalsIgnoreCase("aarpmedicareplans")) {
			startNewPRE("https://www.aarpmedicareplans.com/", browser);
		}
	}

	public LearnAboutMedicareHomePage openLearnAboutMedicarePage() {

		jsClickNew(lnkLearnAboutMedicare);
		validateNonPresenceOfElement(zipCodeField);
		return new LearnAboutMedicareHomePage(driver);
	}

	public boolean isValidatePageLoadError() {

		String url = driver.getCurrentUrl();
		System.out.println("Current page URL: " + url);
		if (driver.findElements(By.id("medicareTitle")).isEmpty()) {
			// if(driver.findElement(By.xpath("//*[@id='medicareTitle']/h1").id(id)){
			System.out.println("if");
			return false;
		} else {
			System.out.println("else");
			return true;
		}

	}

	public boolean isValidateContent(String file) {
		if (file.contains("robot")) {

			WebElement xpathvar = driver.findElement(By.xpath("/html/body/pre"));
			String strFileContent = xpathvar.getText();
			boolean strSiteMap = strFileContent.contains("Sitemap");

			if (xpathvar.isDisplayed() && strSiteMap) {
				System.out.println("file loaded");
				return true;
			} else {
				System.out.println("file not loaded");
				return false;
			}
		} else if (file.contains("sitemap")) {

			WebElement xpathvar = driver.findElement(By.xpath("//*[@id='folder1']"));
			System.out.println("xpath==" + xpathvar.getText());

			if (xpathvar.isDisplayed()) {
				System.out.println("xml id found");
				return true;
			} else {
				System.out.println("xml id not found");
				return false;
			}
		}
		return false;
	}

	public void openTelesalesAgentPortal() {
		if (MRScenario.environment.equalsIgnoreCase("team-c")) {
			startNew(MRConstants.AARP_TELESALES_AGENT_PAGE_URL);
		} else if (MRScenario.environment.equalsIgnoreCase("stage")) {
			startNew(MRConstants.AARP_TELESALES_AGENT_PAGE_URL_STAGE);
		} else if (MRScenario.environment.contains("digital-uatv2")) {
			startNew(MRConstants.AARP_TELESALES_AGENT_PAGE_URL_Team);
		}
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

	public OLETestHarnessPage GetOLETestHarnessPage() {
		return new OLETestHarnessPage(driver);
	}

	public void validateTFNNoonRightRail(String TFNXpath, String ExpecetdTFNNo) throws InterruptedException {

		CommonUtility.checkPageIsReady(driver);
		// checkModelPopup(driver, 10);
		// CheckiPerseptions();

		System.out.println("########Validating TFN Info in RIght Rail section########");

		if (validate(rightRailSectionTFNHeader)) {
			scrollToView(rightRailSectionTFNHeader);
			System.out.println(rightRailSectionTFNHeader.getText());
			System.out.println(rightRailSectionTFNHeader1.getText());
		}

		String ExpectedCallSamTFNMember = "Call UnitedHealthcare toll-free at " + ExpecetdTFNNo + " (TTY 711)";
		// String ExpectedCallSamTFNMember = footertextsectioncallus.getText();
		validateNew(footertextsectioncallus);
		String ActualCallSamTFNMember = footertextsectioncallus.getText();

		System.out.println("Expected TFN member: " + ExpectedCallSamTFNMember);
		System.out.println("Actual TFN member: " + ActualCallSamTFNMember);

		if (ExpectedCallSamTFNMember.contains(ActualCallSamTFNMember)) {
			System.out.println(
					"****************call us Content was found macthing with the SAM call Popup  ***************");
			Assert.assertTrue(true);
		} else
			Assert.fail(
					"*****************call us Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);

		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validate(ActualTFNelement);

		System.out.println("########Validating TFN No in Right Rail########");
		System.out.println("Expected TFN No on Right Rail: " + ExpecetdTFNNo);
		System.out.println("Actual TFN No on Right Rail: " + ActualTFNelement.getText());

		if (ExpecetdTFNNo.contains(ActualTFNelement.getText()))
			System.out.println("TFN is Displayed on Right Rail on the Page : " + ActualTFNelement.getText());
		else
			Assert.fail("TFN element is not found / displayed on Right rail on the page : ");

		String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. � 8 p.m.,\n7 days a week";
		// String ExpectedCallSamTFNtimezone1 = "Hours: 8 a.m. - 8 p.m.,\n7 days a
		// week";
		// String ExpectedCallSamTFNtimezone2 = "Hours: 8 a.m. - 8 p.m., 7 days a week";
		// String ExpectedCallSamTFNtimezone = rightRailsectionTFNtimezone.getText();
		String ActualCallSamTFNtimezone = rightRailsectionTFNtimezone.getText();

		System.out.println("########Validating TFN Time zone in Right Rail scetion########");
		System.out.println("Expected TFN time zone: " + ExpectedCallSamTFNtimezone);
		System.out.println("Actual TFN time zone: " + ActualCallSamTFNtimezone);

		if (ExpectedCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")
				.equalsIgnoreCase(ActualCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")))
			System.out.println(
					"****************TFN Timezone Content was  found matching with the SAM call Popup  ***************");
		else
			Assert.fail(
					"****************TFN Timezone Content was not found matching with the SAM call Popup  ***************");
	}

	public void validatefootercallussection(String TFNXpath, String ExpecetdTFNNo) {
		CommonUtility.checkPageIsReady(driver);

		System.out.println("########Validating TFN member in Footer section########");
		if (validate(footertextsectionTFNHeader)) {
			scrollToView(footertextsectionTFNHeader);
			System.out.println(footertextsectionTFNHeader.getText());
		}

		String ExpectedCallSamTFNMember = "Call UnitedHealthcare: 1-877-755-5345 (TTY 711)";
		validate(footertextsectioncallus);
		String ActualCallSamTFNMember = footertextsectioncallus.getText();

		System.out.println("Expected TFN member: " + ExpectedCallSamTFNMember);
		System.out.println("Actual TFN member: " + ActualCallSamTFNMember);

		if (ExpectedCallSamTFNMember.equalsIgnoreCase(ActualCallSamTFNMember)) {
			System.out.println(
					"****************call us Content was found macthing with the SAM call Popup  ***************");
			Assert.assertTrue(true);
		} else
			Assert.fail(
					"*****************call us Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);

		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);

		System.out.println("########Validating TFN No in Footer section########");
		System.out.println("Expected TFN No: " + ExpecetdTFNNo);
		System.out.println("Actual TFN No: " + ActualTFNelement.getText());

		// if(validateNew(TFNelement) && TFNelement.isDisplayed()) {
		if (ExpecetdTFNNo.contains(ActualTFNelement.getText()))
			System.out.println("TFN is Displayed on Page : " + ActualTFNelement.getText());

		else
			Assert.fail("TFN element is not found / displayed on page : " + TFNXpath);

		String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. � 8 p.m., 7 days a week";
		String ActualCallSamTFNtimezone = footertextsectionTFNtimezone.getText();

		System.out.println("########Validating TFN Time zone in Footer scetion########");
		System.out.println("Expected TFN time zone: " + ExpectedCallSamTFNtimezone);
		System.out.println("Actual TFN time zone: " + ActualCallSamTFNtimezone);

		if (ActualCallSamTFNtimezone.replace("\n", "").replaceAll("[^A-Za-z0-9:.]", "")
				.contains(ExpectedCallSamTFNtimezone.replace("\n", "").replaceAll("[^A-Za-z0-9:.]", "")))
			System.out.println(
					"****************call us Timezone Content was found matching with the SAM call Popup  ***************");
		else
			Assert.fail(
					"****************call us Timezone Content was not found matching with the SAM call Popup  ***************");

		/*
		 * String ExpectedCallSamTFNtimezone1 = "7 days a week"; String
		 * ActualCallSamTFNtimezone1 = footertextsectionTFNtimezone1.getText();
		 * 
		 * 
		 * System.out.println("Expected TFN time zone: " + ExpectedCallSamTFNtimezone1);
		 * System.out.println("Actual TFN time zone: " + ActualCallSamTFNtimezone1); if
		 * (ActualCallSamTFNtimezone1.replace(" ", "").replace("\n", "")
		 * .contains(ExpectedCallSamTFNtimezone1.replace(" ", "").replace("\n", "")))
		 * System.out.println(
		 * "****************call us Timezone1 Content was  found macthing with the SAM call Popup  ***************"
		 * ); else Assert.fail(
		 * "****************call us Timezone1 Content was not found macthing with the SAM call Popup  ***************"
		 * );
		 */

		// validate(CallSamTFNClose);
		// jsClickNew(CallSamTFNClose);

	}

	public void validateCallpopuponMedsupppage(String TFNXpath, String ExpecetdTFNNo) {
		threadsleep(10);
		System.out.println("########Validating TFN on Call SAM icon and Call popup for Medsupp#######");
		CommonUtility.checkPageIsReady(driver);

		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);

		System.out.println("Expected TFN No: " + ExpecetdTFNNo);
		System.out.println("Actual TFN No on Call SAM icon: " + ActualTFNelement.getText());

		if (ExpecetdTFNNo.contains(ActualTFNelement.getText()))
			System.out.println("TFN is validated successfully on the SAM call icon : " + ActualTFNelement.getText());
		else
			Assert.fail("TFN element is not found / displayed on SAM icon : " + TFNXpath);

		jsClickNew(ActualTFNelement);

		System.out.println("#######Validating TFN info on Call Popup#######");
		validateNew(CallSamModalHeader, 5);
		System.out.println(CallSamModalHeader.getText());

		validateNew(CallSamModalMember);
		System.out.println(CallSamModalMember.getText());

		System.out.println("######Validating TFN number on Call Popup########");
		if (ExpecetdTFNNo.contains(CallSamTFN.getText()))
			System.out.println("TFN is validated successfully on the call popup : " + CallSamTFNInfo.getText());
		else
			Assert.fail("TFN elemet is not found / displayed on Call popup icon : ");

		System.out.println("#######Validating TFN time zone on Call Popup#######");
		String ExpectedCallSamTFNtimezone = "7 a.m. � 11 p.m. ET, Monday-Friday\n9 a.m. � 5 p.m. ET, Saturday";
		validateNew(CallSamTFNMedsupptimezone);
		String ActualCallSamTFNtimezone = CallSamTFNMedsupptimezone.getText();

		System.out.println("Expected TFN time zone: " + ExpectedCallSamTFNtimezone);
		System.out.println("Actual TFN time zone: " + ActualCallSamTFNtimezone);

		if (ExpectedCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")
				.equalsIgnoreCase(ActualCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")))
			System.out.println(
					"****************TFN Timezone Content was found macthing with the SAM call Popup  ***************");

		else
			Assert.fail(
					"****************TFN Timezone Content was not found macthing with the SAM call Popup  ***************");

		String ExpectedCallSamTFNMember = "Already a member? Call the number on the back of your member ID card.";
		validate(CallSamTFNMember_Medsup);
		String ActualCallSamTFNMember = CallSamTFNMember_Medsup.getText();
		System.out.println("TFN Member on CAll popup: " + ExpectedCallSamTFNMember);
		if (ExpectedCallSamTFNMember.equalsIgnoreCase(ActualCallSamTFNMember)) {
			System.out.println(
					"****************TFN Member Content was found macthing with the SAM call Popup  ***************");
			Assert.assertTrue(true);
		} else {
			Assert.fail(
					"*****************TFN Member Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);
		}
		validate(CallSamTFNClose);
		jsClickNew(CallSamTFNClose);
	}

	public void validateCallpopuponaprivacypage(String TFNXpath, String ExpecetdTFNNo) {
		try {
			System.out.println("########Validating TFN on Call SAM icon and Call popup#######");
			// driver.navigate().refresh();
			CommonUtility.checkPageIsReady(driver);
			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
				checkModelPopup(driver, 10);

			WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
			validateNew(ActualTFNelement);

			System.out.println("Expected TFN No on Call SAM icon: " + ExpecetdTFNNo);
			System.out.println("Actual TFN No on Call SAM icon: " + ActualTFNelement.getText());

			if (ExpecetdTFNNo.contains(ActualTFNelement.getText()))
				System.out
						.println("TFN is validated successfully on the SAM call icon : " + ActualTFNelement.getText());
			else
				Assert.fail("TFN elemnet is not found / displayed on SAM icon : " + TFNXpath);

			driver.navigate().refresh();

			jsClickNew(ActualTFNelement);

			System.out.println("#######Validating TFN info on Call Popup#######");
			validateNew(CallSamModalHeader, 5);
			System.out.println(CallSamModalHeader.getText());

			validateNew(CallSamModalMember);
			System.out.println(CallSamModalMember.getText());

			System.out.println("######Validating TFN number on Call Popup########");
			if (ExpecetdTFNNo.contains(CallSamTFN.getText()))
				System.out.println("TFN is validated successfully on the call popup : " + CallSamTFNInfo.getText());
			else
				Assert.fail("TFN element is not found / displayed on Call popup icon : ");

			System.out.println("#######Validating TFN time zone on Call Popup#######");
			String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. Â- 8 p.m., 7 days a week.*\n*Alaska and Hawaii: 8 a.m. Â- 8 p.m. Monday � Friday, 8 a.m. Â- 5 p.m. Saturday and Sunday.";
			validate(CallSamTFNtimezone);
			String ActualCallSamTFNtimezone = CallSamTFNtimezone.getText();
			System.out.println("TFN Timezone Content for Expected Values:" + ExpectedCallSamTFNtimezone);
			System.out.println("TFN Timezone Content for Actual Values  :" + ActualCallSamTFNtimezone);
			if (ExpectedCallSamTFNtimezone.replace(" ", "").replace("\n", "")
					.equalsIgnoreCase(ActualCallSamTFNtimezone.replace(" ", "").replace("\n", ""))) {
				System.out.println(
						"****************TFN Timezone Content was  found macthing with the SAM call Popup  ***************");

			} else {

				System.out.println(
						"****************TFN Timezone Content was not found macthing with the SAM call Popup  ***************");
			}

			String ExpectedCallSamTFNMember = "Already a member? Call the number on the back of your member ID card.";
			validate(CallSamTFNMember);
			String ActualCallSamTFNMember = CallSamTFNMember.getText();
			System.out.println("TFN Member on CAll popup: " + ExpectedCallSamTFNMember);
			if (ExpectedCallSamTFNMember.equalsIgnoreCase(ActualCallSamTFNMember)) {
				System.out.println(
						"****************TFN Member Content was found macthing with the SAM call Popup  ***************");
				Assert.assertTrue(true);
			} else {
				Assert.fail(
						"*****************TFN Member Content was not found macthing with the SAM call Popup  ***************"
								+ ActualCallSamTFNMember);
			}
			validate(CallSamTFNClose);
			jsClickNew(CallSamTFNClose);

			// }
		} catch (Exception e) {
			System.out.println("Proactive chat popup not displayed");
		}
	}

	public void validateMedsuppfootercallussection(String TFNXpath, String ExpecetdTFNNo) {
		System.out.println("########Validating TFN in Medsupp Footer section########");
		if (validate(footertextsectionHeadermedsupp))
			System.out.println(footertextsectionHeadermedsupp.getText());

		String ExpectedCallSamTFNMember = "Call UnitedHealthcare: 1-877-755-5345 (TTY 711)";
		validateNew(footertextsectioncallusMedsupp);
		String ActualCallSamTFNMember = footertextsectioncallusMedsupp.getText();

		System.out.println("Expected TFN member: " + ExpectedCallSamTFNMember);
		System.out.println("Actual TFN member: " + ActualCallSamTFNMember);

		if (ExpectedCallSamTFNMember.contains(ActualCallSamTFNMember)) {
			System.out.println(
					"****************call us Content was found macthing with the SAM call Popup  ***************");
			Assert.assertTrue(true);
		} else
			Assert.fail(
					"*****************call us Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);

		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);

		System.out.println("########Validating TFN No in Footer section########");
		System.out.println("Expected TFN No: " + ExpecetdTFNNo);
		System.out.println("Actual TFN No: " + ActualTFNelement.getText());

		// if(validateNew(TFNelement) && TFNelement.isDisplayed()) {
		if (ExpecetdTFNNo.contains(ActualTFNelement.getText()))
			System.out.println("TFN is Displayed on Medsupp Page footer: " + ActualTFNelement.getText());

		else
			Assert.fail("TFN element is not found / displayed on page : " + TFNXpath);

		String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. � 8 p.m., 7 days a week.\nHours: 8 a.m. � 8 p.m. Monday � Friday, 8 a.m. � 5 p.m. Saturday and Sunday.";
		String ActualCallSamTFNtimezone = footertextsectionMedsuppTFNtimezone.getText();

		System.out.println("########Validating TFN Time zone in Footer scetion########");
		System.out.println("Expected TFN time zone: " + ExpectedCallSamTFNtimezone);
		System.out.println("Actual TFN time zone: " + ActualCallSamTFNtimezone);

		if (ActualCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")
				.contains(ExpectedCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")))
			System.out.println(
					"****************call us Timezone Content was found matching with the SAM call Popup  ***************");
		else
			// Assert.fail(
			System.out.println(
					"****************call us Timezone Content was not found matching with the SAM call Popup  ***************");
	}

	public void validateTFNNoonRightRailforMedsupp(String TFNXpath, String ExpecetdTFNNo) {

		CommonUtility.checkPageIsReady(driver);
		// checkModelPopup(driver, 10);

		System.out.println("########Validating TFN Info in RIght Rail section for Medsupp########");

		if (validate(rightRailSectionTFNHeaderMedsupp)) {
			scrollToView(rightRailSectionTFNHeaderMedsupp);
			System.out.println(rightRailSectionTFNHeaderMedsupp.getText());
			System.out.println(rightRailSectionTFNHeaderMedsupp1.getText());
		}

		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);

		System.out.println("########Validating TFN No in Right Rail########");
		System.out.println("Expected TFN No on Right Rail: " + ExpecetdTFNNo);
		System.out.println("Actual TFN No on Right Rail: " + ActualTFNelement.getText());

		if (ExpecetdTFNNo.contains(ActualTFNelement.getText()))
			System.out.println("TFN is Displayed on Right Rail on the Page : " + ActualTFNelement.getText());
		else
			Assert.fail("TFN element is not found / displayed on Right rail on the page : ");

		// String ActualCallSamTFNtimezone =
		// rightRailsectionTFNtimezoneMedsupp.getText();

		/*
		 * String ExpectedCallSamTFNtimezone =
		 * "Hours: 8 a.m. � 8 p.m., 7 days a week"; String ActualCallSamTFNtimezone =
		 * rightRailsectionTFNtimezone.getText();
		 * 
		 * System.out.
		 * println("########Validating TFN Time zone in Right Rail section for Medsupp#####"
		 * ); System.out.println("Expected TFN time zone: " +
		 * ExpectedCallSamTFNtimezone); System.out.println("Actual TFN time zone: " +
		 * ActualCallSamTFNtimezone);
		 * 
		 * if (ActualCallSamTFNtimezone.replace(" ", "").replace("\n", "")
		 * .contains(ExpectedCallSamTFNtimezone.replace(" ", "").replace("\n", "")))
		 * System.out.println(
		 * "****************call us Timezone Content was found matching with the SAM call Popup  ***************"
		 * ); else Assert.fail(
		 * "****************call us Timezone Content was not found matching with the SAM call Popup  ***************"
		 * );
		 */

	}

	public void validateTFNNoonRightRailForOLE(String TFNXpath, String ExpecetdTFNNo) throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		// checkModelPopup(driver, 10);
		// CheckiPerseptions();

		System.out.println("########Validating TFN Info in RIght Rail section########");

		if (validate(rightRailSectionTFNHeader)) {
			scrollToView(rightRailSectionTFNHeader);
			System.out.println(rightRailSectionTFNHeader.getText());
			System.out.println(rightRailSectionTFNHeader1.getText());
		}

		String ExpectedCallSamTFNMember = "Call UnitedHealthcare at:";
		// String ExpectedCallSamTFNMember = footertextsectioncallus.getText();
		//validateNew(footertextsectioncallus);
		validateNew(tfnHeaderRightRailOLE);
		String ActualCallSamTFNMember = tfnHeaderRightRailOLE.getText().trim().replace("\n", " ");

		System.out.println("Expected TFN member: " + ExpectedCallSamTFNMember);
		System.out.println("Actual TFN member: " + ActualCallSamTFNMember);

		if (ExpectedCallSamTFNMember.contains(ActualCallSamTFNMember)) {
			System.out.println(
					"****************call us Content was found macthing with the SAM call Popup  ***************");
			Assert.assertTrue(true);
		} else
			Assert.fail(
					"*****************call us Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);

		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);

		System.out.println("########Validating TFN No in Right Rail########");
		System.out.println("Expected TFN No on Right Rail: " + ExpecetdTFNNo);
		System.out.println("Actual TFN No on Right Rail: " + ActualTFNelement.getText());

		if (ExpecetdTFNNo.contains(ActualTFNelement.getText()))
			System.out.println("TFN is Displayed on Right Rail on the Page : " + ActualTFNelement.getText());
		else
			Assert.fail("TFN element is not found / displayed on Right rail on the page : ");

		String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. Â– 8 p.m., 7 days a week\n(Alaska and Hawaii: 8 a.m. Â– 8 p.m. Monday Â– Friday, 8 a.m. Â– 5 p.m. Saturday Â– Sunday)";
		String ExpectedCallSamTFNtimezone1 = "Hours: 8 a.m. - 8 p.m., 7 days a week\n(Alaska and Hawaii: 8 a.m. - 8 p.m. Monday - Friday, 8 a.m. - 5 p.m. Saturday - Sunday)";
		// String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. Â– 8 p.m., 7 days a
		// week";
		// String ExpectedCallSamTFNtimezone = rightRailsectionTFNtimezone.getText();
		String ActualCallSamTFNtimezone = rightRailsectionTFNtimezoneOLE.getText();

		System.out.println("########Validating TFN Time zone in Right Rail scetion########");
		System.out.println("Expected TFN time zone: " + ExpectedCallSamTFNtimezone);
		System.out.println("Actual TFN time zone: " + ActualCallSamTFNtimezone);

		if (ExpectedCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")
				.equalsIgnoreCase(ActualCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")))
			System.out.println(
					"****************call us Timezone Content was found matching with the SAM call Popup  ***************");
		else

			Assert.fail(
					"****************TFN Timezone Content was not found matching with the SAM call Popup  ***************");
	}

	public void validateTFNNoonRightRailForPlanDetailsPage(String TFNXpath, String ExpecetdTFNNo)
			throws InterruptedException {

		CommonUtility.checkPageIsReady(driver);
		// checkModelPopup(driver, 10);
		// CheckiPerseptions();

		System.out.println("########Validating TFN Info in RIght Rail section########");

		if (validate(rightRailSectionTFNHeader)) {
			scrollToView(rightRailSectionTFNHeader);
			System.out.println(rightRailSectionTFNHeader.getText());
			System.out.println(rightRailSectionTFNHeader1.getText());
		}

		String ExpectedCallSamTFNMember = "Call UnitedHealthcare toll-free at " + ExpecetdTFNNo + " (TTY 711)";
		// String ExpectedCallSamTFNMember = footertextsectioncallus.getText();
		validateNew(footertextsectioncallus);
		String ActualCallSamTFNMember = footertextsectioncallus.getText().replace("\n", " ");

		System.out.println("Expected TFN member: " + ExpectedCallSamTFNMember);
		System.out.println("Actual TFN member: " + ActualCallSamTFNMember);

		if (ExpectedCallSamTFNMember.contains(ActualCallSamTFNMember)) {
			System.out.println(
					"****************call us Content was found macthing with the SAM call Popup  ***************");
			Assert.assertTrue(true);
		} else
			Assert.fail(
					"*****************call us Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);

		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);

		System.out.println("########Validating TFN No in Right Rail########");
		System.out.println("Expected TFN No on Right Rail: " + ExpecetdTFNNo);
		System.out.println("Actual TFN No on Right Rail: " + ActualTFNelement.getText());

		if (ExpecetdTFNNo.contains(ActualTFNelement.getText()))
			System.out.println("TFN is Displayed on Right Rail on the Page : " + ActualTFNelement.getText());
		else
			Assert.fail("TFN element is not found / displayed on Right rail on the page : ");

		String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. Â- 8 p.m.,\n7 days a week";
		String ExpectedCallSamTFNtimezone1 = "Hours: 8 a.m. - 8 p.m.,\n7 days a week";
		String ExpectedCallSamTFNtimezone2 = "Hours: 8 a.m. - 8 p.m., 7 days a week";
		// String ExpectedCallSamTFNtimezone = rightRailsectionTFNtimezone.getText();
		String ActualCallSamTFNtimezone = rightRailsectionTFNtimezonePlanDetails.getText();

		System.out.println("########Validating TFN Time zone in Right Rail scetion########");
		System.out.println("Expected TFN time zone: " + ExpectedCallSamTFNtimezone);
		System.out.println("Actual TFN time zone: " + ActualCallSamTFNtimezone);

		if (ExpectedCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")
				.equalsIgnoreCase(ActualCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", ""))) {
			System.out.println(
					"****************TFN Timezone Content was  found macthing with the SAM call Popup  ***************");
			// Assert.assertTrue(true);
		} else {
			Assert.fail(
					"****************TFN Timezone Content was not found matching with the SAM call Popup  ***************");
		}
	}

	public void validateTFNNoonZipCodeComponent(String TFNXpath, String ExpecetdTFNNo) throws InterruptedException {

		CommonUtility.checkPageIsReady(driver);
		// checkModelPopup(driver, 10);
		// CheckiPerseptions();

		System.out.println("########Validating TFN Info in ZipCode Component section########");

		String ExpectedCallSamTFNMember = "Need Help? Call UnitedHealthcare at " + ExpecetdTFNNo
				+ " (TTY 711) toll free, 8 a.m. – 8 p.m., 7 days a week.";
		// String ExpectedCallSamTFNMember = footertextsectioncallus.getText();
		validateNew(footertextsectioncallus);
		String ActualCallSamTFNMember = footertextsectioncallus.getText().replace("\n", "");

		System.out.println("Expected TFN member: " + ExpectedCallSamTFNMember);
		System.out.println("Actual TFN member: " + ActualCallSamTFNMember);

		// if (ExpectedCallSamTFNMember.contains(ActualCallSamTFNMember)) {
		// System.out.println(
		if (ExpectedCallSamTFNMember.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")
				.equalsIgnoreCase(ActualCallSamTFNMember.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", ""))) {

			System.out.println(
					"****************call us Content was found macthing with the SAM call Popup  ***************");
			Assert.assertTrue(true);
		} else
			Assert.fail(
					"*****************call us Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);

		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);

		System.out.println("########Validating TFN No in Right Rail########");
		System.out.println("Expected TFN No on Right Rail: " + ExpecetdTFNNo);
		System.out.println("Actual TFN No on Right Rail: " + ActualTFNelement.getText());

		if (ExpecetdTFNNo.contains(ActualTFNelement.getText()))
			System.out.println("TFN is Displayed on Right Rail on the Page : " + ActualTFNelement.getText());
		else
			Assert.fail("TFN element is not found / displayed on Right rail on the page : ");

	}

	public void validateTFNNoonSNPRightRailForOLE(String TFNXpath, String ExpecetdTFNNo) throws InterruptedException {

		CommonUtility.checkPageIsReady(driver);

		System.out.println("########Validating TFN Info in RIght Rail section########");

		if (validate(rightRailSectionTFNHeader)) {
			scrollToView(rightRailSectionTFNHeader);
			System.out.println(rightRailSectionTFNHeader.getText());
			System.out.println(rightRailSectionTFNHeader1.getText());
		}

		String ExpectedCallSamTFNMember = "Call UnitedHealthcare at:" + ExpecetdTFNNo + " (TTY 711)";
		// String ExpectedCallSamTFNMember = footertextsectioncallus.getText();
		//validateNew(footertextsectioncallus);
		validateNew(tfnHeaderRightRailOLE);
		String ActualCallSamTFNMember = tfnHeaderRightRailOLE.getText().replace("\n", " ");

		System.out.println("Expected TFN member: " + ExpectedCallSamTFNMember);
		System.out.println("Actual TFN member: " + ActualCallSamTFNMember);

		if (ExpectedCallSamTFNMember.contains(ActualCallSamTFNMember)) {
			System.out.println(
					"****************call us Content was found macthing with the SAM call Popup  ***************");
			Assert.assertTrue(true);
		} else
			Assert.fail(
					"*****************call us Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);

		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);

		System.out.println("########Validating TFN No in Right Rail########");
		System.out.println("Expected TFN No on Right Rail: " + ExpecetdTFNNo);
		System.out.println("Actual TFN No on Right Rail: " + ActualTFNelement.getText());

		if (ExpecetdTFNNo.contains(ActualTFNelement.getText()))
			System.out.println("TFN is Displayed on Right Rail on the Page : " + ActualTFNelement.getText());
		else
			Assert.fail("TFN element is not found / displayed on Right rail on the page : ");

		String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. – 8 p.m., local time, 7 days a week";
		// String ExpectedCallSamTFNtimezone1 = "Hours: 8 a.m. - 8 p.m., 7 days a
		// week\n(Alaska and Hawaii: 8 a.m. - 8 p.m. Monday - Friday, 8 a.m. - 5 p.m.
		// Saturday - Sunday)";
		// String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. Â– 8 p.m., 7 days a
		// week";
		// String ExpectedCallSamTFNtimezone = rightRailsectionTFNtimezone.getText();
		String ActualCallSamTFNtimezone = rightRailsectionTFNtimezoneOLE.getText();

		System.out.println("########Validating TFN Time zone in Right Rail scetion########");
		System.out.println("Expected TFN time zone: " + ExpectedCallSamTFNtimezone);
		System.out.println("Actual TFN time zone: " + ActualCallSamTFNtimezone);

		if (ExpectedCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")
				.equalsIgnoreCase(ActualCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")))
			System.out.println(
					"****************call us Timezone Content was found matching with the SAM call Popup  ***************");
		else

			Assert.fail(
					"****************TFN Timezone Content was not found matching with the SAM call Popup  ***************");
	}

	public VPPPlanSummaryPage searchPlansWithOutCountyForExternalLink(String zipcode) throws InterruptedException {

		waitForPageLoadSafari();
		CommonUtility.waitForPageLoadNew(driver, externalzipCodeField, 30);
		if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver, 10);
		// sendkeys(zipCodeField, zipcode);
		sendkeysNew(externalzipCodeField, zipcode);
		jsClickNew(findPlansBtn);
		// }
		// while(validate(overlayFilm, 10)) {/**wait*/}
		// CommonUtility.waitForElementToDisappear(driver, overlayFilm, 75);
		waitForPageLoadSafari();

		// CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		validateNew(vppTop, 30);
		if (driver.getCurrentUrl().contains("health-plans")) {
			return new VPPPlanSummaryPage(driver);
		} else
			return null;
	}

	public VPPPlanSummaryPage externalsearchPlans(String zipcode, String countyName) {
		waitForPageLoadSafari();
		if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver, 10);
		CommonUtility.waitForPageLoadNew(driver, externalzipCodeField, 30);
		sendkeys(externalzipCodeField, zipcode);
		jsClickNew(viewPlansButton);

		CommonUtility.waitForPageLoad(driver, countyModal, 15);
		if (validate(countyModal))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));
		if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver, 10);

		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void enterSiteSearchValue(String inputvalue) {
		CommonUtility.waitForPageLoad(driver, EnterSearch, 60);
		EnterSearch.sendKeys(inputvalue);
	}

	public void validateAutoCompleteSuggestion() {
		validate(autoCompleteSuggestion);
	}

	public void clickFirstSuggestion() {
		jsClickNew(firstAutoCompleteSuggestion);
	}

	public void enterSecondarySiteSearchValue(String str) {
		System.out.println("@@@inside secondary search validation method@@@");
		CommonUtility.waitForPageLoadNewForClick(driver, SecondaryClearBtn, 30);
		SecondaryClearBtn.click();
		CommonUtility.waitForPageLoad(driver, SecondarySearchInput, 30);
		SecondarySearchInput.sendKeys(str);
	}

	public void validateAutoCompleteSuggestionSiteSearchPage() {
		validate(autoCompleteSuggestionSiteSearch);
		waitTillElementClickableInTime(firstAutoCompleteSuggestionSiteSearch, 30);
	}

	public void clickFirstSuggestionSiteSearch() {
		jsClickNew(firstAutoCompleteSuggestionSiteSearch);
	}

	public void clickMedSupp(String state) throws InterruptedException {
		scrollToView(ShopForaplan);
		// waitforElement(ShopForaplan);
		// driver.navigate().refresh();
		validate(ShopForaplan);
		jsMouseOver(ShopForaplan);
		if (state.equalsIgnoreCase("Oregon"))
			MedSuppClassicUrl.click();
		else
			MedicareSuppUrl.click();
	}

	public void validatestatedropDown(String state, String code) {
		validateNew(stateDropDown);
		selectFromDropDownByValue(stateDropDown, state);
		/*
		 * String StateSessionStorage = returnDriverStorageJS("sessionStorage",
		 * "ucp_geotrackingState"); System.out.println("State selected : " + state);
		 * System.out.println("State GeoSessionStorage value : " + StateSessionStorage);
		 * Assertion.assertTrue("Gesolocation State validation Failed ",
		 * StateSessionStorage.equalsIgnoreCase(code));
		 */
	}

	public void validateMedupsStateUrl(String state, String code, String classicStates, String AllStates) {
		if (state.equalsIgnoreCase("Oregon")) {
			validate(stateDropDown);
			validate(MedSuppClassicUrl);
			System.out.println("State is: " + state);
			System.out.println("Code is: " + code);
			System.out.println("Medicare Supplement Url is: " + MedSuppClassicUrl.getAttribute("href"));
			Assert.assertTrue(MedSuppClassicUrl.getAttribute("href").contains(classicStates));
			String CurrentURL = driver.getCurrentUrl();
			System.out.println("Current URL : " + CurrentURL);
			Assert.assertTrue(CurrentURL.contains(classicStates));
		} else {
			validate(stateDropDown);
			validate(MedicareSuppUrl);
			System.out.println("State is: " + state);
			System.out.println("Code is: " + code);
			System.out.println("Medicare Supplement Url is: " + MedicareSuppUrl.getAttribute("href"));
			Assert.assertTrue(MedicareSuppUrl.getAttribute("href").contains(AllStates));
			String CurrentURL = driver.getCurrentUrl();
			System.out.println("Current URL : " + CurrentURL);
			Assert.assertTrue(CurrentURL.contains(AllStates));
		}
	}

	@FindBy(xpath = "//span[contains(text(),'Make an appointment for Medicare Supplement Insura')]")
	private WebElement clickISlinkMedEDPages;

	public IsInsuranceAgent clickISlinkMedEDPages() {

		CommonUtility.waitForPageLoadNew(driver, clickISlinkMedEDPages, 30);
		jsClickNew(clickISlinkMedEDPages);

		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL : " + CurrentURL);
		driver.navigate().to(CurrentURL);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Page Title : " + (driver.findElement(By.xpath("//title")).getText()));
		// return IsInsuranceAgent;
		return new IsInsuranceAgent(driver);
	}

	public LearnAboutMedicareHomePage HoveronaLearnMedicare() throws InterruptedException {
		waitforElement(learnaboutMedicare);
		if (learnaboutMedicare.isDisplayed()) {
			// Actions action = new Actions(driver);
			// action.moveToElement(ShopForaplan).build().perform();
			jsMouseOver(learnaboutMedicare);
			return new LearnAboutMedicareHomePage(driver);
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//a[contains(text(), 'Introduction')]")
	private WebElement introductionLearnaboutMedicare;

	public LearnAboutMedicareHomePage learnAboutMedicareintroduction() throws InterruptedException {
		waitforElement(introductionLearnaboutMedicare);
		if (introductionLearnaboutMedicare.isDisplayed()) {
			// Actions action = new Actions(driver);
			// action.moveToElement(ShopForaplan).build().perform();
			validate(introductionLearnaboutMedicare);
			jsClickNew(introductionLearnaboutMedicare);
			return new LearnAboutMedicareHomePage(driver);
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//a[contains(text(), 'Eligibility')]")
	private WebElement eligibilityLearnaboutMedicare;

	public LearnAboutMedicareHomePage learnAboutMedicareeligibility() throws InterruptedException {
		waitforElement(eligibilityLearnaboutMedicare);
		if (eligibilityLearnaboutMedicare.isDisplayed()) {
			// Actions action = new Actions(driver);
			// action.moveToElement(ShopForaplan).build().perform();
			validate(eligibilityLearnaboutMedicare);
			waitforElement(eligibilityLearnaboutMedicare);
			Thread.sleep(5000);
			// eligibilityLearnaboutMedicare.click();
			jsClickNew(eligibilityLearnaboutMedicare);
			return new LearnAboutMedicareHomePage(driver);
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//a[contains(text(), 'Options')]")
	private WebElement coverageOptionsLearnaboutMedicare;

	public LearnAboutMedicareHomePage learnAboutMedicareCoverageOptions() throws InterruptedException {

		waitforElement(coverageOptionsLearnaboutMedicare);
		if (coverageOptionsLearnaboutMedicare.isDisplayed()) {
			// Actions action = new Actions(driver);
			// action.moveToElement(ShopForaplan).build().perform();
			validate(coverageOptionsLearnaboutMedicare);
			// eligibilityLearnaboutMedicare.click();
			jsClickNew(coverageOptionsLearnaboutMedicare);
			return new LearnAboutMedicareHomePage(driver);
		} else {
			return null;
		}
	}

	public void clickLearnAboutMedicareNavLink(String linkName) {
		WebElement link = driver.findElement(
				By.xpath("//div[contains(@id,'learnmore-scroll')]//a[contains(text(),'" + linkName + "')]"));
		waitforElement(link);
		jsClickNew(link);
	}

	public void validateLearnAboutMedicareLinkNavigation(String linkName) {
		switch (linkName) {

		case "Introduction":
			Assertion.assertTrue("Navigation to Introduction page failed",
					driver.getCurrentUrl().contains("/medicare-education"));
			break;
		case "Eligibility":
			Assertion.assertTrue("Navigation to Eligibility page failed",
					driver.getCurrentUrl().contains("/medicare-eligibility"));
			break;
		case "Coverage Options":
			Assertion.assertTrue("Navigation to Coverage Options failed",
					driver.getCurrentUrl().contains("medicare-parts-and-medigap-plans"));
			break;

		case "Prescriptions, Providers & Benefits":
			Assertion.assertTrue("Navigation to Prescriptions, Providers & Benefits page failed",
					driver.getCurrentUrl().contains("medicare-benefits"));
			break;

		case "Medicare Cost Basics":
			Assertion.assertTrue("Navigation to Medicare Cost Basics page failed",
					driver.getCurrentUrl().contains("medicare-costs"));
			break;

		case "Medicare Advantage Plans":
			Assertion.assertTrue("Navigation to Medicare Advantage Plans page failed",
					driver.getCurrentUrl().contains("medicare-advantage-plans"));
			break;

		case "Medicare Supplement Insurance":
			Assertion.assertTrue("Navigation to Medicare Supplement Insurance Plans page failed",
					driver.getCurrentUrl().contains("medicare-supplement-plans"));
			break;

		case "Medicare Prescription Drug Plans":
			Assertion.assertTrue("Navigation to Medicare Prescription Drug Plans page failed",
					driver.getCurrentUrl().contains("medicare-part-d"));
			break;

		case "When to Enroll":
			Assertion.assertTrue("Navigation to When to Enroll page failed",
					driver.getCurrentUrl().contains("enrollment-and-changing-plans")||driver.getCurrentUrl().contains("when-to-enroll"));
			break;
			
		case "Working Past 65":
			Assertion.assertTrue("Navigation to Working Past 65 page failed",
					driver.getCurrentUrl().contains("medicare-while-working"));
			break;
			
		case "Changing Plans":
			Assertion.assertTrue("Navigation to Changing Plans page failed",
					driver.getCurrentUrl().contains("changing-plans"));
			break;
			
		case "How to Enroll":
			Assertion.assertTrue("Navigation to How to Enroll page failed",
					driver.getCurrentUrl().contains("how-to-enroll-in-medicare"));
			break;
			
		case "Overview of Plans":
			Assertion.assertTrue("Navigation to Overview of Plans page failed",
					driver.getCurrentUrl().contains("medicare-plans-overview"));
			break;
			
		case "Special Needs Plans":
			Assertion.assertTrue("Navigation to Special Needs Plans page failed",
					driver.getCurrentUrl().contains("special-needs-plans"));
			break;

		case "Medicare FAQ":
			Assertion.assertTrue("Navigation to Medicare FAQ page failed",
					driver.getCurrentUrl().contains("medicare-faq"));
			break;

		case "Articles and Special Topics":
			Assertion.assertTrue("Navigation to Articles and Special Topics page failed",
					driver.getCurrentUrl().contains("medicare-articles"));
			break;
			
		case "Glossary":
			Assertion.assertTrue("Navigation to Glossary page failed",
					driver.getCurrentUrl().contains("medicare-glossary"));
			break;

		default:
			System.out.println("Link not available under Learn about Medicare");
		}
	}

	public void validateLearnAboutMedicareEmailSection() {
		learnMoreMedicareEmailTxtBox.sendKeys("abc@abc.com");
		learnMoreMedicareEmailSubmitBtn.click();
	}

	public void validateEmailSubmissionMessage(String expectedMsg) {
		waitforElement(learnMoreMedicareEmailSubmissionMsg);
		System.out.println(learnMoreMedicareEmailSubmissionMsg.getText().replace("\n", ""));
		String actualMsg = learnMoreMedicareEmailSubmissionMsg.getText().replace("\n", "");
		System.out.println(expectedMsg);
		Assertion.assertTrue("Expected message is not displayed", actualMsg.contains(expectedMsg));
	}

	public WelcomePage navigateToPathOLE(String path) {

		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL : " + CurrentURL);

		String NavigateToURL = CurrentURL + path;
		System.out.println("Navigating to URL : " + NavigateToURL);
		driver.navigate().to(NavigateToURL);
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 30);
		System.out.println("Page Title : " + (driver.findElement(By.xpath("//title")).getText()));
		if (driver.getCurrentUrl().contains("welcome")) {
			return new WelcomePage(driver);
		} else {
			System.out.println("Navigation to OLE Page is failed");
			return null;
		}
	}

	public AcquisitionHomePage validateTFNCallpopup() throws InterruptedException {
		driver.navigate().refresh();
		CommonUtility.checkPageIsReady(driver);
		CheckiPerseptions();
		validate(callsamtooltip);
		validate(callsam);
		String ActualCallSAMTFN = callsam.getText();
		System.out.println("TFN No displayed on the Page" + ActualCallSAMTFN);
		jsClickNew(callsam);
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		driver.switchTo().activeElement();
		validate(CallSamTFN);
		String ExpectedCallSAMTFN = CallSamTFN.getText();
		System.out.println("TFN No displayed on the Page" + ExpectedCallSAMTFN);
		if (ExpectedCallSAMTFN.contains(ActualCallSAMTFN)) {
			System.out
					.println("****************TFN number was  found macthing with the SAM call Popup  ***************");

			Assert.assertTrue(true);
		} else {
			Assert.fail("*****************TFN number was  not found macthing with the SAM call Popup ***************"
					+ ExpectedCallSAMTFN);
		}
		if (driver.getCurrentUrl().contains("medicare-supplement-plans")
				|| driver.getCurrentUrl().contains("/compare/compare-ms")
				|| driver.getCurrentUrl().contains("/enroll/ms-apply")
				|| driver.getCurrentUrl().contains("shop/estimate/ms-costs")) {
			String ExpectedCallSamTFNtimezone = "7 a.m. â€“ 11 p.m. ET, Monday-Friday\n9 a.m. â€“ 5 p.m. ET, Saturday";
			validate(CallSamTFNtimezone_Medsup);
			String ActualCallSamTFNtimezone = CallSamTFNtimezone_Medsup.getText();
			System.out.println(ExpectedCallSamTFNtimezone);
			System.out.println(ActualCallSamTFNtimezone);
			if (ExpectedCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")
					.equalsIgnoreCase(ActualCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", ""))) {
				System.out.println(
						"****************TFN Timezone Content was  found macthing with the SAM call Popup  ***************");
			} else {
				Assert.fail(
						"****************TFN Timezone Content was not found macthing with the SAM call Popup  ***************"
								+ ExpectedCallSamTFNtimezone);
			}
			String ExpectedCallSamTFNMember = "Already a member? Call the number on the back of your member ID card.";
			validate(CallSamTFNMember_Medsup);
			String ActualCallSamTFNMember = CallSamTFNMember_Medsup.getText();
			System.out.println(ExpectedCallSamTFNMember);
			if (ExpectedCallSamTFNMember.equalsIgnoreCase(ActualCallSamTFNMember)) {
				System.out.println(
						"****************TFN Member Content was  found macthing with the SAM call Popup  ***************");
				Assert.assertTrue(true);
			} else {
				Assert.fail(
						"*****************TFN Member Content was not found macthing with the SAM call Popup  ***************"
								+ ActualCallSamTFNMember);
			}
		} else {
			String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. � 8 p.m., 7 days a week.*\n*Alaska and Hawaii: 8 a.m. � 8 p.m. Monday � Friday, 8 a.m. � 5 p.m. Saturday and Sunday.";
			validate(CallSamTFNtimezone);
			String ActualCallSamTFNtimezone = CallSamTFNtimezone.getText();
			System.out.println(ExpectedCallSamTFNtimezone);
			System.out.println(ActualCallSamTFNtimezone);
			if (ActualCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", "")
					.equalsIgnoreCase(ExpectedCallSamTFNtimezone.replaceAll("[^A-Za-z0-9:.]", "").replace("\n", ""))) {
				System.out.println(
						"****************TFN Timezone Content was  found macthing with the SAM call Popup  ***************");
				// Assert.assertTrue(true);
			} else {
				// Assert.fail("*****************TFN Timezone Content was not found macthing
				// with the SAM call Popup ***************"+ActualCallSamTFNtimezone);
				System.out.println(
						"****************TFN Timezone Content was not found macthing with the SAM call Popup  ***************");
			}
			String ExpectedCallSamTFNMember = "Already a member? Call the number on the back of your member ID card.";
			// ActualCallSamTFNMember.replace("", " ");
			// WebElement strCallSamTFNMember=
			// driver.findElement(By.xpath("//p[contains(text(),'Already a member?')]"));
			validate(CallSamTFNMember);
			String ActualCallSamTFNMember = CallSamTFNMember.getText();
			System.out.println(ExpectedCallSamTFNMember);
			if (ExpectedCallSamTFNMember.equalsIgnoreCase(ActualCallSamTFNMember)) {
				System.out.println(
						"****************TFN Member Content was  found macthing with the SAM call Popup  ***************");
				Assert.assertTrue(true);
			} else {
				Assert.fail(
						"*****************TFN Member Content was not found macthing with the SAM call Popup  ***************"
								+ ActualCallSamTFNMember);
			}
		}
		validate(CallSamTFNClose);
		jsClickNew(CallSamTFNClose);
		/*
		 * validate(callsamtooltip); CheckiPerseptions(); callsam.click();
		 * System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		 * driver.switchTo().activeElement(); System.out.println(CallSamTFN.getText());
		 * CallSamTFNClose.click(); validateNew(callsam); return null;
		 */
		return null;
	}

	public void selectStateForGeotargeting(String geoState) {
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
		WebElement stateDropDown = driver.findElement(By.id("state-select"));
		scrollToView(stateDropDown);
		waitTllOptionsAvailableInDropdown(stateDropDown, 5);
		stateDropDown.click();
		System.out.println("State to be Selected: " + geoState);
		String stateXPath = "//select[@id='state-select']//option[contains(@value,'" + geoState + "')]";
		WebElement stateGeotargeting = driver.findElement(By.xpath(stateXPath));
		// scrollToView(stateGeotargeting);
		stateGeotargeting.click();
		if (!geoState.equalsIgnoreCase(stateGeotargeting.getText())) {
			Assert.fail("Wrong state selected for geotarget");
		}
		// jsClickNew(stateGeotargeting);
		waitforElementNew(stateGeotargeting, 5);
		System.out.println("State selected for Geotargetting: " + stateGeotargeting.getText());
		waitforElementNew(stateGeotargeting, 5);

	}

	public LearnAboutMedicareHomePageNew clickLearnMoreAboutMedicareOnHomePage() {

		validateNew(learnAboutMedicareHomeScreen);
		scrollToView(learnAboutMedicareHomeScreen);
		jsClickNew(learnAboutMedicareHomeScreen);
		waitForPageLoadSafari();
		String urlCheck = driver.getCurrentUrl();
		if (urlCheck.contains("medicare-education.html")) {
			return new LearnAboutMedicareHomePageNew(driver);
		} else {
			return null;
		}
	}

	public void clickOnPlanRecommendationButton() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement lnkPRE = driver
				.findElement(By.xpath("//a[contains(@href,'/plan-recommendation-engine.html') and @role='button']"));
		jsClickNew(lnkPRE);
		sleepBySec(5);
		if (driver.getCurrentUrl().contains("/plan-recommendation-engine.html")) {
			System.out.println("Plan Recommendation Engine open successfully");
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Plan Recommendation Engine did not open successfully");
		}
		driver.navigate().back();
	}

	public void clickFooterLinks(String linkName) {
		WebElement link = null;
		String url = driver.getCurrentUrl();

		if (linkName.equals("Medicare Supplement Insurance Plans")) {
			link = driver.findElement(
					By.xpath("//*[@class='uhc-footer']//span[contains(text(),'Medicare Supplement Insurance Plans')]"));
			waitforElement(link);
			jsClickNew(link);
			pageloadcomplete();
		} else {
			if (url.contains("uhcmedicaresolutions") && linkName.equals("AARP.org")) {
				int size = driver.findElements(By.xpath("//*[@class='uhc-footer']//a[contains(text(),'" + linkName
						+ "')]")).size();
				if (size != 0) {
					System.out.println("AARP.org link is not displaying");
				} else {
					System.out.println("AARP.org link is displaying");
					Assert.assertFalse(size == 0);
				}
			} else {
				link = driver.findElement(By.xpath("//*[@class='uhc-footer']//a[contains(text(),'" + linkName
						+ "')]"));
				waitforElement(link);
				jsClickNew(link);
				pageloadcomplete();
			}
		}

	}

	public void validateFooterLinksNavigation(String linkName) {
		String base = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		boolean flag = false;
		switch (linkName) {

		case "Introduction to Medicare":
			Assertion.assertTrue("Navigation to Introduction page failed",
					driver.getCurrentUrl().contains("/medicare-education"));
			break;
		case "Eligibility":
			Assertion.assertTrue("Navigation to Eligibility page failed",
					driver.getCurrentUrl().contains("/medicare-eligibility"));
			break;
		case "Coverage Choices":
			Assertion.assertTrue("Navigation to Coverage Options failed",
					driver.getCurrentUrl().contains("medicare-parts-and-medigap-plans"));
			break;

		case "Medicare FAQ":
			Assertion.assertTrue("Navigation to Medicare FAQ page failed",
					driver.getCurrentUrl().contains("medicare-faq"));
			break;

		case "Medicare Advantage Plans":
			Assertion.assertTrue("Navigation to Medicare Advantage Plans page failed",
					driver.getCurrentUrl().contains("medicare-advantage-plans"));
			break;

		case "Medicare Supplement Insurance Plans":
			Assertion.assertTrue("Navigation to Medicare Supplement Insurance Plans page failed",
					driver.getCurrentUrl().contains("medicare-supplement-plans"));
			break;

		case "Medicare Prescription Drug Plans":
			Assertion.assertTrue("Navigation to Medicare Prescription Drug Plans page failed",
					driver.getCurrentUrl().contains("prescription-drug-plans"));
			break;

		case "Dual Special Needs Plans":
			Assertion.assertTrue("Navigation to Dual Special Needs Plans page failed",
					driver.getCurrentUrl().contains("dual-special-needs-plans"));
			break;

		case "Plan Recommendation":
			Assertion.assertTrue("Navigation to Plan Recommendation page failed",
					driver.getCurrentUrl().contains("plan-recommendation-engine"));
			break;

		case "Estimate Drug Costs":
			Assertion.assertTrue("Navigation to Drug Cost Estimator page failed",
					driver.getCurrentUrl().contains("drug-cost-estimator"));
			break;

		case "Search for a Pharmacy":
			Assertion.assertTrue("Navigation to Pharmacy Search page failed",
					driver.getCurrentUrl().contains("Pharmacy-Search"));
			break;

		case "Search Doctors":
			for (String s : all) {
				driver.switchTo().window(s);
				// sleepBySec(5);
				flag = driver.getCurrentUrl().contains("werally");
				if (!base.equals(s)) {
					driver.close();
					break;
				}
			}
			driver.switchTo().window(base);
			Assertion.assertTrue("Navigation to Provider Search page failed", flag);
			break;

		case "Search Dentists":
			for (String s : all) {
				driver.switchTo().window(s);
				// sleepBySec(5);
				flag = driver.getCurrentUrl().contains("werally");
				if (!base.equals(s)) {
					driver.close();
					break;
				}
			}
			driver.switchTo().window(base);
			Assertion.assertTrue("Navigation to Provider Search page failed", flag);
			break;

		case "About":
			Assertion.assertTrue("Navigation to About page failed", driver.getCurrentUrl().contains("about-us"));
			break;

		case "Contact":
			Assertion.assertTrue("Navigation to Contact page failed", driver.getCurrentUrl().contains("contact-us"));
			break;

		case "Language Assistance":
			for (String s : all) {
				driver.switchTo().window(s);
				flag = driver.getCurrentUrl().contains("language-assistance");
				if (!base.equals(s)) {
					driver.close();
					break;
				}
			}
			driver.switchTo().window(base);
			Assertion.assertTrue("Navigation to Language Assistance page failed", flag);
			break;

		case "AARP.org":
			if (driver.getCurrentUrl().contains("uhcmedicaresolutions")) {
				System.out.println("AARP.org link not present for UHC site");
				break;
			} else {
				for (String s : all) {
					driver.switchTo().window(s);
					flag = driver.getCurrentUrl().contains("leaving.intermediatepage.html?https://www.aarp.org");
					if (!base.equals(s)) {
						driver.close();
						break;
					}
				}
				driver.switchTo().window(base);
				Assertion.assertTrue("Navigation to AARP.org page failed", flag);
				break;
			}

		default:
			System.out.println("Link not available under Learn about Medicare");
		}
	}

	public void validateVisitorProfileIcon() {
		// jsMouseOver(visitorprofileicon);
		Actions action = new Actions(driver);
		action.moveToElement(visitorprofileicon).perform();
		validateNew(visitorProfileFlyoutTitle);
		if (!driver.getCurrentUrl().contains("profile")) {
			validateNew(visitorProfileFlyoutViewSavedItemBtn);
		}
		validateNew(visitorProfileFlyoutAddDrugBtn);
		validateNew(visitorProfileFlyoutAddPlansBtn);
		validateNew(visitorProfileFlyoutSignInLink);
	}

	public void clickMemberSiteLink() {
		// validateNew(headerSignInLink);
		// jsMouseOver(planMemberLink);
		Actions action = new Actions(driver);
		action.moveToElement(planMemberLink).perform();
		// validateNew(headerRegisterLink);
		validateNew(goToMemberSiteLink);
		jsClickNew(goToMemberSiteLink);
		String base = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		Iterator<String> I = all.iterator();
		while (I.hasNext()) {
			String childWindow = I.next();
			if (!base.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				Assert.assertTrue(driver.getCurrentUrl().contains("medicare.uhc.com"));
				driver.close();
			}
		}
		driver.switchTo().window(base);
	}
	
	public void validateTfnInHeader() throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		CheckiPerseptions();
		validateNew(tfnHeaderLink);
		String ActualCallSAMTFN = tfnHeaderLink.getText().trim();
		System.out.println("TFN No displayed on the Page" + ActualCallSAMTFN);
		jsClickNew(tfnHeaderLink);
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		driver.switchTo().activeElement();
		validate(tfnHeaderPopup);
		String ExpectedCallSAMTFN = tfnHeaderPopup.getText();
		System.out.println("TFN No displayed on the Modal" + ExpectedCallSAMTFN);
		if (ExpectedCallSAMTFN.contains(ActualCallSAMTFN)) {
			System.out
					.println("****************TFN number was  found macthing with the SAM call Popup  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("*****************TFN number was  not found macthing with the SAM call Popup ***************"
					+ ExpectedCallSAMTFN);
		}
		
		validate(tfnHeaderPopupClose);
		jsClickNew(tfnHeaderPopupClose);
		
	}
	public AcquisitionHomePage navigateToURL(String site) {

		String CurrentURL = driver.getCurrentUrl();
		//System.out.println("Current URL : " + CurrentURL);

/*		String NavigateToURL = path;
		System.out.println("Navigating to URL : " + NavigateToURL);
		driver.navigate().to(NavigateToURL);
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 30);
		System.out.println("Page Title : " + (driver.findElement(By.xpath("//title")).getText()));
*/
		
		
		
		if ("BLayer".equalsIgnoreCase(site) || site.equalsIgnoreCase("UHC") || site.equalsIgnoreCase("UMS")) {
			if (MRScenario.environment.equals("offline")) {
				driver.navigate().to(UMS_ACQISITION_OFFLINE_PAGE_URL);
				testSiteUrl = UMS_ACQISITION_OFFLINE_PAGE_URL;
				checkModelPopup(driver, 45);
			} else if (MRScenario.environment.equals("prod")) {
				driver.navigate().to(UMS_ACQISITION_PROD_PAGE_URL);
				testSiteUrl = UMS_ACQISITION_PROD_PAGE_URL;
				checkModelPopup(driver, 45);
			} else if (MRScenario.environment.contains("stage-0")) {
				driver.navigate().to(UMS_ACQISITION_PAGE_URL_NEW);
				checkModelPopup(driver, 20);
			} else {
				driver.navigate().to(UMS_ACQISITION_PAGE_URL);
				testSiteUrl = UMS_ACQISITION_PAGE_URL;
				checkForSecurityPage();
				// checkModelPopup(driver, 10);
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
				driver.navigate().to(AARP_ACQISITION_OFFLINE_PAGE_URL);
				testSiteUrl = AARP_ACQISITION_OFFLINE_PAGE_URL;
				checkModelPopup(driver, 45);
			} else if (MRScenario.environment.equals("prod")) {
				driver.navigate().to(AARP_ACQISITION_PROD_PAGE_URL);
				testSiteUrl = AARP_ACQISITION_PROD_PAGE_URL;
				checkModelPopup(driver, 45);
			} else if (MRScenario.environment.contains("stage-0")) {
				driver.navigate().to(AARP_ACQISITION_PAGE_URL_NEW);
				checkModelPopup(driver, 20);
			} else {
				driver.navigate().to(AARP_ACQISITION_PAGE_URL);
				testSiteUrl = AARP_ACQISITION_PAGE_URL;
				checkForSecurityPage();
				// checkModelPopup(driver, 10);
			}
		} else if (site.equalsIgnoreCase("PRE") || site.equalsIgnoreCase("ARE")) {
			System.out.println("Temporary condition added to bypass openAndValidate for PRE/ARE"); // added on 3/3/21 as
																									// part of AARP/UHC
																									// cleanup
		}

		if (!(site.equalsIgnoreCase("PRE") || site.equalsIgnoreCase("ARE"))) { // adding this condition temporarily to
																				// bypass PRE/ARE flows
			// CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
			// checkModelPopup(driver,15);
			// CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 25);
			// CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn, 20); // do not
			// change this to waitForPageLoadNew as
			// we're not trying to fail the test if it
			// isn't found
			try {
				validate(proactiveChatExitBtn, 20);
				if (proactiveChatExitBtn.isDisplayed())
					jsClickNew(proactiveChatExitBtn);
			} catch (Exception e) {
				System.out.println("Proactive chat popup not displayed");
			}
		}
		return new AcquisitionHomePage(driver);
	}
	
	public void validateSamChatIcon() throws InterruptedException {
		boolean present;
		try {
			threadsleep(10);
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(35))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(TimeoutException.class);
			fwait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			         return driver.findElement(By.xpath("//*[contains(@id,'LPMcontainer')]//*[contains(text(),'Chat Now')]"));
			       }
			});
			validateNew(samChatIcon);
			present = true;
		} catch (Exception e) {
			present = false;
			if(driver.getCurrentUrl().contains("welcome"));
			driver.navigate().refresh();
			present= validateNew(samChatIcon);
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to see Chat Icon @@@@@@@@@");

		} else
			System.out.println("@@@@@@@@@ Chat Icon not available @@@@@@@@@");

	}
	
	public void validateSamChatPopup() throws InterruptedException {
		try {
			jsClickNew(samChatIcon);
			threadsleep(3);
			validateNew(samChatPopup);
			threadsleep(3);
			validateNew(samChatPopupHeader);
			validateNew(samChatPopupMsg);
			Assertion.assertTrue("Expected message not displayed in popup", samChatPopupMsg.getText().trim().equals("Hi, I'm UnitedHealthcare's online guide. I'm here to transfer you to our team. How can I help you today?"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(0).getText().trim().contains("Questions about My Plan"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(1).getText().trim().contains("Lost Member ID Card"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(2).getText().trim().contains("Looking for a Plan"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(3).getText().trim().contains("Medicare Questions"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(4).getText().trim().contains("Ready to Enroll"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(5).getText().trim().contains("Other"));
			
		} catch (Exception e) {

			System.out.println("Failed Due To-------" + e.getMessage());
		}
		closeChatPopup();
	}
	
	public void validateProactiveChat() throws InterruptedException {
		boolean present;
		try {
			//waitforElementNew(proactiveChatModal, 30);
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(TimeoutException.class);
			fwait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			         return driver.findElement(By.id("proactive-chat-widget-new"));
			       }
			});
			validateNew(proactiveChatModal);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to see Proative Chat Modal @@@@@@@@@");

		} else
			System.out.println("@@@@@@@@@ Proactive Chat not available @@@@@@@@@");

		Assertion.assertTrue("Proactive chat modal message not found", proactiveChatMsg.getText().trim().contains("Message with UnitedHealthcare"));
		validateNew(proactiveChatCloseIcon);
		validateNew(proactiveChatBtn);
	}
	
	public void validateProactiveChatPopup() throws InterruptedException {
		try {
			jsClickNew(proactiveChatBtn);
			threadsleep(3);
			validateNew(samChatPopup);
			threadsleep(3);
			validateNew(samChatPopupHeader);
			validateNew(samChatPopupMsg);
			Assertion.assertTrue("Expected message not displayed in popup", samChatPopupMsg.getText().trim().equals("Hi, I'm UnitedHealthcare's online guide. I'm here to transfer you to our team. How can I help you today?"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(0).getText().contains("Questions about My Plan"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(1).getText().contains("Lost Member ID Card"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(2).getText().contains("Looking for a Plan"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(3).getText().contains("Medicare Questions"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(4).getText().contains("Ready to Enroll"));
			Assertion.assertTrue("Expected chat message sugesstion not found",chatSuggestionMsg.get(5).getText().contains("Other"));
			
		} catch (Exception e) {

			System.out.println("Failed Due To-------" + e.getMessage());
		}
		closeProactiveChatPopup();
	}
	
	public void closeChatPopup() {
		chatPopupOptions.click();
		chatPopupEndChatOption.click();
	}
	
	public void closeProactiveChatPopup() {
		chatPopupOptions.click();
		proactiveChatPopupEndChatOption.click();
	}

}
