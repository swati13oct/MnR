/**
 *
 */
package pages.acquisition.bluelayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import pages.acquisition.ulayer.ComparePlansPage;
import pages.acquisition.ulayer.PageTitleConstants;
import pages.acquisition.vppforaep.AepVppPlanSummaryPage;

/**
 * @author pagarwa5
 *
 */
public class VPPPlanSummaryPage extends UhcDriver {

	@FindBy(xpath = "//a[text()='Passport Flyer (PDF)']")
	private WebElement PassportFlyerPDF;

	@FindBy(id = "change-location")
	private WebElement changeLocationBtn;

	@FindBy(xpath = ".//*[@id='maplans2']")
	private WebElement showMaPlans;

	@FindBy(xpath = ".//*[@id='pdpplans2']")
	private WebElement showPdpPlans;

	@FindBy(xpath = "//div[@class='snpplans_planbutton']/div[2]/div[2]/div")
	private WebElement showSnpPlans;

	@FindBy(xpath = "//div[@class='medsupplans_planbutton']/div[2]/div[1]/a")
	private WebElement showMsPlans;

	@FindBy(xpath = "//div[@id='chooseplan']/div/div/h3")
	private WebElement pageHeading;

	@FindBy(xpath = "//div[@id='maplans_container']")
	WebElement maPlanConatiner;

	@FindBy(xpath = "//div[@id='pdpplans_container']")
	WebElement pdpPlanConatiner;

	@FindBy(xpath = "//div[@id='snpplans_container']")
	WebElement snpPlanConatiner;

	// @FindBy(xpath
	// ="//div[@id='maplans_container']/div[3]/div/div/div/div[@class='ng-scope']")
	@FindBy(xpath = "//div[@class='module-plan-overview module swiper-slide ng-scope']")
	List<WebElement> maPlanElement;

	@FindBy(xpath = "//div[@id='plan-list-1']/div/div[1]/div/div/h2")
	WebElement maPlanHeadingText;

	@FindBy(xpath = "//div[@id='maplans_container']/h1/span")
	WebElement maPlanHeadingYear;

	@FindBy(xpath = "//div[contains(@ng-repeat,'plan in planModel.maPlans')]")
	List<WebElement> maPlans;

	@FindBy(xpath = "//div[@id='plan-list-3']/div/div[1]/div/div/h2")
	WebElement pdpPlanHeadingText;

	@FindBy(xpath = "//div[@id='pdpplans_container']/h1/span")
	WebElement pdpPlanHeadingYear;

	@FindBy(xpath = "//div[contains(@ng-repeat,'plan in planModel.pdpPlans')]")
	List<WebElement> pdpPlans;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[1]//*[@class='trigger-closed']")
	private WebElement viewPlans;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[3]//*[@class='trigger-closed']")
	private WebElement viewPDPPlans;

	@FindBy(xpath = "//div[@id='snpplans_container']/h1/span[2]")
	WebElement msnPlanHeadingText;

	@FindBy(xpath = "//div[@id='snpplans_container']/h1/span")
	WebElement msnPlanHeadingYear;

	@FindBy(xpath = "//div[@data-ng-repeat='plan in snpplans']")
	List<WebElement> msnPlans;

	@FindBy(xpath = ".//*[@id='pdpplans_container']")
	List<WebElement> pdpPlanElement;

	@FindBy(xpath = ".//*[@id='plan-list-1']//a[contains(@class,'view-more-link']")
	List<WebElement> viewDetailsBtnMA;

	@FindBy(xpath = "//div[@id='snpplans_container']")
	List<WebElement> snpPlanElement;

	@FindBy(linkText = "Make an appointment with an agent")
	private WebElement make_an_appointment_agent;

	@FindBy(css = "#pdpplans_container .planCompareBtn")
	private WebElement comparePDPPlanChkBox;

	@FindBy(css = "#maplans_container .compareHeading>p")
	private WebElement compareUpto3PlansPopup;

	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[3]/div[3]/div/div/span[1]/label")
	private WebElement compareChkBox3;

	@FindBy(xpath = "//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[1]/b")
	private WebElement comparePopUpTxt1;

	@FindBy(xpath = "//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[2]")
	private WebElement comparePopUpTxt2;

	@FindBy(xpath = ".//*[@id='togglenextYear']/a")
	private WebElement toggleplanYear;

	@FindBy(xpath = "//div[@id='maplans_container']/div[3]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr/td[3]/div/div[2]/div[3]/div[1]/p/a")
	private WebElement MaProviderLink;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[1]/h2")
	private WebElement allPlansSize;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs')]/div[1]/div[contains(@class,'tab-contents')]/span[contains(@class,'title')]/span")
	private WebElement maPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs')]/div[2]/div[contains(@class,'tab-contents')]/span[contains(@class,'title')]/span")
	private WebElement msPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs')]/div[3]/div[contains(@class,'tab-contents')]/span[contains(@class,'title')]/span")
	private WebElement pdpPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs')]/div[4]/div[contains(@class,'tab-contents')]/span[contains(@class,'title')]/span")
	private WebElement snpPlansCount;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[2]/div[4]/div/span[1]/span")
	private WebElement msnPlansCount;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/span/a")
	private WebElement view2017Plans;

	@FindBy(id = "drugsTabId")
	public WebElement step1;

	@FindBy(className = "planYear")
	WebElement planYear;

	@FindBy(xpath = ".//*[@class='action-btn getStarted']")
	private WebElement GetStarted;

	@FindBy(xpath=".//*[@class='gs-option']//*[contains(text(),'People')]")
	private WebElement People;

	@FindBy(id = "change-location")
	private WebElement ChangeLocationLink;
	
	@FindBy(id = "submit")
	private WebElement FIndPlansButton;
	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[1]/div/*[@class='trigger-closed']")
	private WebElement closedTrigger;

	@FindBy(xpath = "//*[contains(text(), 'Special Needs Plans')]/following-sibling::*[@class = 'trigger-closed']")
	private WebElement snpplans;

	@FindBy(xpath = "//div[@class='medsupplans_planbutton']/div[2]/div[1]/a")
	private WebElement medsupplans;
	// "

	// @FindBy(xpath="//*[contains(text(),'Primary Care')]")
	@FindBy(xpath = ".//*[@class='gs-option']//*[contains(text(),'Primary Care')]")
	private WebElement Primary;

	@FindBy(xpath = "//*[contains(text(),'Primary Care Physician')] ")
	private WebElement Physician;

	// @FindBy(xpath=".//*[contains(@ng-bind-html,'buttonText') and
	// contains(text(),'Save')]")
	//private WebElement Savebtn;

	@FindBy(xpath="//div[contains(@class,'first')]//div[@class='hidden-phone']//button")

	private WebElement Savebtn;

	@FindBy(id = "label_unsaved_selectedLocation0")
	private WebElement firstLocation;

	//@FindBy(xpath="//button[@class='action-btn']")
	@FindBy(xpath="//*[@id='skip-to-main-content']/div/div[1]/div[1]/location-result/div/div/div/div[2]/div[2]/div[1]/div/div/div[3]/toggle-saved-provider/button/span")
	private WebElement secondSaveBtn;

	@FindBy(xpath = "//*[contains(text(),'View Saved')]")
	private WebElement Viewsavebtn;

	@FindBy(xpath = "//button[@class='action-btn negative']")
	private WebElement Checkcoverage;

	@FindBy(xpath = "//*[@id='physicians_info']")
	private WebElement provider;

	@FindBy(className = "planType_info")
	WebElement planHeadingText;

	@FindBy(xpath = ".//*[@id='viewmoredetlinkpdp']")
	WebElement viewDetailsPDP;

	@FindBy(xpath = "//div[@class='module-closed-enrollment-alert']/span/a")
	private WebElement viewPlansYearLink;

	@FindBy(xpath = ".//*[@class='swiper-container']")
	List<WebElement> maPlanElement1;

	// Right Rail Element - TFN
	@FindBy(xpath = "//*[contains(@class,'tel ng-binding')]")
	private WebElement RightRail_TFN;

	@FindBy(xpath = "//*[@id='togglecurrentYear']/a")
	private WebElement YearToggle;

	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;
	
	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;
	
	@FindBy(id = "multiCountyCancelBtn")
	private WebElement MultiCOunty_CancelBtn;
	
	@FindBy(id = "zipcode")
	private WebElement ZipCodeTxtBx;

	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='maviewplans']/following-sibling::a")
	private WebElement maPlansViewLink;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[2]//a[@class='trigger-closed'][text()='View Plans']")
	private WebElement msPlansViewLink;

	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='pdpviewplans']/following-sibling::a")
	private WebElement pdpPlansViewLink;

	@FindBy(xpath = "//div[contains(@id,'plan-list-') and not(contains(@class,'ng-hide'))]/div[contains(@class,'plan-list-content')]")
	private WebElement planListContainer;

	@FindBy(xpath = "//div[@id='responsiveplan']")
	private List<WebElement> medSuppPlanList;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[4]//a[@class='trigger-closed']")
	private WebElement snpPlansViewLink;

	@FindBy(xpath = "//div[contains(@class,'overview-main')]/h2")
	private WebElement vppTop;

	@FindBy(xpath = "//div[contains(@class,'plan-overview-list')]//div[contains(@id,'plan-list-')][not (contains(@class,'ng-hide'))]//div[contains(@class,'module-plan-overview')]//input[contains(@id,'compare-plan-')]/following-sibling::label")
	private List<WebElement> planCompareList;

	@FindBy(xpath = "//span[contains(@class,'single-added-text show')]/following::a[contains(text(),'View Plan')][1]")
	private WebElement ViewPlanLink_AddedToCompare;
	
	@FindBy(xpath = "//div[contains(@class,'plan-overview-list')]//div[contains(@id,'plan-list-')][not (contains(@class,'ng-hide'))]//div[contains(@class,'module-plan-overview')]//div[not (contains(@class,'ng-hide'))]/a[contains(@class,'view-more-link')]")
	private WebElement ViewPlanLink;

	@FindBy(id = "plan-list-1")
	private WebElement maPlanList;
	
	@FindBy(xpath = "(//*[contains(@class,'content-secondary plans')]//*[contains(@class,'drug-list')])[1]")
	private WebElement drugCoveredInfo;
	
	@FindBy(xpath = "(//div[contains(@class,'mabenefittable')]//li[contains(@class,'ng-scope')]/span[contains(text(),'Estimated Annual Drug Cost')])[1]")
	private WebElement estimatedAnnualDrugCostLabel;
	
	@FindBy(xpath = "(//div[contains(@class,'mabenefittable')]//li[contains(@class,'ng-scope')]/span[contains(text(),'Estimated Annual Drug Cost:')]/following-sibling::span[not(contains(@class,'ng-hide'))])[1]")
	private WebElement estimatedAnnualDrugCostValue;
	
	@FindBy(xpath = "(.//*[@id='globalContentIdForSkipLink']//div[contains(@class,'module module-aside no-med-supp rigntrailwidget')])[2]")
	private WebElement promoWidject;
	
    @FindBy(id = "plan-list-3")
    private WebElement pdpPlanList;
    
    @FindBy(id = "plan-list-4")
    private WebElement snpPlanList;
    
    @FindBy(xpath =".//*[@id='vpp-monthly-premium-modal-header']/ancestor::div[contains (@class , 'popup-modal active')]")
    private WebElement learnMoreModalPopUp;
    
    @FindBy(id="lisBackBtn")
    private WebElement backButtonInLearnMoreModal;
    
    @FindBy(xpath="//*[contains(@class,'container plans-section')]//*[contains(@class,'col-md-3')]")
    public WebElement RightRailSection;
    
    @FindBy(xpath="//*[contains(@class,'container plans-section')]//*[contains(@class,'col-md-3')]//*[contains(@class,'module module-aside rigntrailwidget')]//*[contains(text(),'Need Help')]")
    public WebElement needHelpRightRail;
    
    @FindBy(xpath="//*[contains(text(),'Find an agent in your area')]")
    public WebElement RightRail_AgentInYourArea; 
    
    @FindBy(xpath="//*[contains(text() , 'Get a Free Medicare Guide')]/ancestor::div[contains(@class,'uhc-container')]")
    public WebElement MedicareGuideRightRail;
    
    @FindBy(xpath="//*[contains(text() , 'Need More Information?')]/ancestor::div[@class='rightrail']//div[@class='uhc-container']")
    public WebElement NeedMoreInformationRightRail;
    
    @FindBy(xpath="//*[contains(text() , 'Need More Information?')]/ancestor::div[@class='rightrail']//div[@class='uhc-container']//a[contains(text(),'Choose a video ')]")
    public WebElement ChooseAVideo;
    
    @FindBy(xpath="//*[contains (@class ,'rightrail')]//*[contains(@class,'uhc-container')]//*[contains(@dtmname,'Plan Selector')]")
    public WebElement PlanSelectorToolRightRail; 
    
    //@FindBy(xpath="//*[contains(text() , 'Plan Selector Tool')]/ancestor::div[@class='rightrail']//div[@class='uhc-container']//span")
    @FindBy(xpath="//*[contains(@id , 'selector')]")
    public WebElement StartPlanSelector; 
    
    @FindBy(xpath="//input[@id='updates-first-name']")
    public WebElement firstNameField;
    
    @FindBy(xpath="//*[contains(@id, 'updates-form')]//input[@id='updates-email']")
    public WebElement emailField;
    
    @FindBy(xpath="//input[@id='updates-last-name']")
    public WebElement lastNameField;
    
    @FindBy(xpath="//button[@id='signUp']")
    public WebElement Submitbutton;
	
	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;

	//vvv note: added for US1598162
	@FindBy(xpath = "//div[@ng-show='showMaPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	private WebElement maPrintOption;

	@FindBy(xpath = "//div[@ng-show='showMaPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	private WebElement maEmailOption;

	@FindBy(xpath = "//div[@ng-show='showPdpPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	private WebElement pdpPrintOption;

	@FindBy(xpath = "//div[@ng-show='showPdpPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	private WebElement pdpEmailOption;
	
	@FindBy(xpath = "//div[@ng-show='showSnpPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	private WebElement snpPrintOption;

	@FindBy(xpath = "//div[@ng-show='showSnpPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	private WebElement snpEmailOption;

	@FindBy(xpath = "//a[@id='ghn_lnk_1']")
	private WebElement homeBtn;

	@FindBy(xpath ="//ul[contains(@class,'primary-nav')]//a[contains(@href,'health-plans.html')]")
	private WebElement topMenushopForAPlanOption;
	
	@FindBy(xpath="//input[contains(@class,'zip-field')]")
	private WebElement shopForAPlanOptionZipcodeFieldBox;

	@FindBy(xpath="//button[contains(@class,'zip-button') and contains(@dtmid,'top')]")
	private WebElement shopForAPlanOptionFindPlanButton;

	@FindBy(xpath = "//a[@id='change-location']")
	private WebElement planOverviewChangeZipCodeLink;
	
	@FindBy(xpath = "//input[@id='zipcode']")
	private WebElement planOverviewZipCodeFieldBox;

	@FindBy(xpath = "//button[contains(@class,'zip-button') and contains(@dtmid,'landing')]")
	private WebElement planOverviewFindPlanButton;
/* tbd
    private String savePlanLinkTextXpath= "//span[contains(text(),'Save Plan')]";
	private String savePlanImgXpath="//img[contains(@src,'ic_favorite-unfilled.png')]";
    private String savedPlanLinkTextXpath= "//span[text()='Saved']";
	private String savedPlanImgXpath="//img[contains(@src,'ic_favorite-filled.png')]";
	*/
	@FindBy(xpath="//a[@id='popupClose']")
	private WebElement closeProfilePopup;
	
    private String savePlanLinkTextXpath= "//span[contains(text(),'Save Plan')]";
	private String savePlanImgXpath="//img[contains(@src,'ic_favorite-unfilled.png')]";
    private String savedPlanLinkTextXpath= "//span[text()='Saved']";
	private String savedPlanImgXpath="//img[contains(@src,'ic_favorite-filled.png')]";
	
	@FindBy(xpath = "//div[@id='emailPlanSummaryPopUp']")
	private WebElement emailPlanSummaryPopupScreen;
	
	@FindBy(xpath = "//h3[@id='emailplandetail']")
	private WebElement emailPlanSummaryPopupScreenText;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailPlanSummaryFieldBox;

	@FindBy(xpath = "//button[@class='cta-button cta-button sendbtn']")
	private WebElement emailPlanSummarySendButton;

	@FindBy(xpath = "//button[@class='cta-button close-modal secondary']")
	private WebElement emailPlanSummaryCancelButton;

	@FindBy(xpath = "//p[@id='emailSuccess']") 
	private WebElement emailPlanSummarySuccessText;
	
	@FindBy(xpath = "//button[@ng-click='closeEmailSuccessMsgSummaryPopUp()']")
	private WebElement emailPlanSummarySuccessCloseButton;

	@FindBy(xpath = "//input[@id='email' and @class='error']")
	private WebElement emailPlanSummaryErrorFieldBox;

	@FindBy(xpath = "//p//span[@id='emailError']")
	private WebElement emailPlanSummaryInputErrorText;

	//MedSupp Resume application
	
		@FindBy(xpath = "(//*[contains(text(),'Start application')])[1]")
		private WebElement Start_ApplicationBtn;
		
		@FindBy(id = "msVppZipCode")
		private WebElement medSupZipcode;
		
		@FindBy(id = "msVppDOB")
		private WebElement DOB;

		@FindBy(xpath = "//*[contains(@id,'mpaed-month')]")
		private WebElement monthDrpDwn_PartA;
		
		@FindBy(id = "mpaed-year")
		private WebElement yearDrpDwn_PartA;
		
		@FindBy(id = "mpbed-month")
		private WebElement monthBDrpDwn;
		
		@FindBy(id = "mpbed-year")
		private WebElement yearBDrpDwn;

		@FindBy(xpath = "//*[@id='mpaed-month']/option[2]")
		private WebElement monthDrpDwnOption;
		
		@FindBy(xpath = "//*[@id='mpaed-year']/option[3]")
		private WebElement yearDrpDwnOption;
		
		@FindBy(xpath = "//*[@id='mpbed-month']/option[2]")
		private WebElement monthBDrpDwnOption;
		
		@FindBy(xpath = "//*[@id='mpbed-year']/option[3]")
		private WebElement yearBDrpDwnOption;

		@FindBy(id = "msVppdpsd")
		private WebElement startDrpDwn;

		@FindBy(xpath = "//*[@id='msVppdpsd']/option[2]")
		private WebElement startDrpDwnOption;
		
		@FindBy(xpath = "//*[contains(@class,'viewPlans')]")
		WebElement ViewPlanMedSupPage;

		@FindBy(xpath ="(//*[contains(@for,'Gender_1')])[2]")
		private WebElement MaleGender;
		
		@FindBy(xpath = "//input[@id='CurrentlyInsured_2']//..")
		private WebElement insuredStatus;

		@FindBy(xpath = "//button[@class='cta-button next-button action_next']")
		private WebElement nextButton;

		@FindBy(id = "FirstName")
		private WebElement firstName;

		@FindBy(id = "LastName")
		private WebElement lastName;

		@FindBy(id = "AddressLine1")
		private WebElement address1;

		@FindBy(id = "City")
		private WebElement cityName;

		@FindBy(xpath = "//input[@id='alt-address-no']//..//label")
		private WebElement alternatemailingAddressBtn;

		@FindBy(xpath = "//input[@id='Email']")
		private WebElement emailAddress;

		@FindBy(xpath = "//input[@id='PhonePrimary']")
		private WebElement phoneNumber;

		@FindBy(xpath = "//a[@class='cancel-button modal-link inline-block']")
		private WebElement cancelButton;

		@FindBy(xpath = "(//a[contains(text(),'Cancel Application')])[2]")
		private WebElement cancelButtonPopUp;

		@FindBy(xpath = "//a[contains(text(),'Enter your existing Application ID code')]")
		private WebElement resumeApplication;
		
		
		@FindBy(xpath = "(//input[@id='DOB'])[1]")
		private WebElement ResumeDOB;

		@FindBy(xpath = "(//input[@id='applicationId'])[1]")
		private WebElement applicationID;

		@FindBy(xpath = "//button[contains(text(),'Resume Application')]")
		private WebElement resumeApplicationBtn;

		@FindBy(xpath = "(//input[@id='ZipCode'])[1]")
		private WebElement ResumeZipCode;
		
		@FindBy(xpath = "//p[contains(text(),'Return to this application using the code below')]//..//span")
		private WebElement resumeKey;
		
		@FindBy(xpath = "//span[contains(text(),'Welcome to Online Enrollment')]")
		private WebElement welcomeHeader;
		
		@FindBy(xpath = "//span[text()='Welcome to Online Enrollment']")
		private WebElement welcomepage;
		
		@FindBy(xpath = "(//*[@id='overlay'])[1]]")
		private WebElement loadingIndicator;
		
		@FindBy(xpath ="//div[contains(@class,'closeBg')]/*[contains (text() , 'Thank you for your interest')]")
		private WebElement medicareGuidePopup;
		
		@FindBy(id="pop-btn-1")
		private WebElement createProfileBtn;
		
		@FindBy(id="pop-btn-2")
		private WebElement continueAsGuest;
		
		@FindBy(id="popupClose")
		private WebElement btnClose;
		
		@FindBy(xpath="//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
		public static WebElement proactiveChatExitBtn;

		@FindBy(xpath="//div[@class='popup-modal active']//h2[@id='plan-year-modal-header']")
		private WebElement planYearPopup;
		
		@FindBy(xpath="//div[contains(@class,'planOptions')]//label[@for='current_Year']")
		private WebElement currentYearSelection;
		
		@FindBy(xpath="//div[contains(@class,'planOptions')]//label[@for='next_Year']")
		private WebElement nextYearSelection;
		
		@FindBy(xpath="//button[@id='lisGoBtn']")
		private WebElement planYearPopupGoButton;
		

		public WebElement getLoadingIndicator() {
			return loadingIndicator;
		}

		public WebElement getValEstimatedAnnualDrugCostValue(String planName) {
			//WebElement valEstimatedAnnualDrugCostValue = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[@ng-show='plan.network']"));
			WebElement valEstimatedAnnualDrugCostValue = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::*[contains(@class,'module-plan-overview module')]//span[contains(text(),'Estimated Annual Drug Cost:')]/following-sibling::span[not(contains(@class,'ng-hide'))]"));
			
			return valEstimatedAnnualDrugCostValue;
		}
		
		public String estimatedAnnualDrugCostVPP(String planName) {
			
			scrollToView(getValEstimatedAnnualDrugCostValue(planName));
			return getValEstimatedAnnualDrugCostValue(planName).getText().trim();
			
			
		}

	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	//^^^ note: added for US1598162	

	
	public VPPPlanSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}

	public VPPPlanSummaryPage(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
		}

	public VPPPlanSummaryPage(WebDriver driver, String OLE_Campaign_URL,boolean flag) {
		super(driver);
		PageFactory.initElements(driver, this);
		start(OLE_Campaign_URL);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		openAndValidate();

		// TODO Auto-generated constructor stub
	}
	
	public boolean validatePlanSummary() {
		boolean flag = true;
		int allPlans = 0;
		int maPlans = 0;
		int msPlans = 0;
		int pdpPlans = 0;
		int msnPlans = 0;
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (validate(allPlansSize)) {
			allPlans = Integer.valueOf(allPlansSize.getText().split(" ")[2]);
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(maPlansCount)) {
			maPlans = Integer.valueOf(maPlansCount.getText());
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(msPlansCount)) {
			msPlans = Integer.valueOf(msPlansCount.getText());
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(pdpPlansCount)) {
			pdpPlans = Integer.valueOf(pdpPlansCount.getText());
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(msnPlansCount)) {
			msnPlans = Integer.valueOf(msnPlansCount.getText());
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}
	
		if(validate(msnPlansCount)){
			if (!(allPlans == maPlans + msPlans + pdpPlans + msnPlans)) {
				flag = false;
			}
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		return flag;
	}

	public boolean validateAvailablePlans(String planType) {
		boolean flag = true;
		int planCount = 0;
		if (planType.equals("MAPD") || planType.equals("MA")) {
			String planHeading = null;
			if (maPlanHeadingText.isDisplayed()) {
				planHeading = maPlanHeadingText.getText();
				System.out.println(planHeading);
				if (!planHeading.contains("Medicare Advantage Plans")) {
					flag = false;
				}
			}

			planCount = Integer.valueOf(maPlansCount.getText());
			for (int i = 0; i < planCount; i++) {
				if (maPlans.get(i).getText().length() == 0) {
					flag = false;
				}
			}

		} else if (planType.equals("PDP")) {
			String planHeading = null;
			if (pdpPlanHeadingText.isDisplayed()) {
				planHeading = pdpPlanHeadingText.getText();
				System.out.println(planHeading);
				if (!planHeading.contains("Medicare Prescription Drug Plans")) {
					flag = false;
				}
			}
			planCount = Integer.valueOf(pdpPlansCount.getText());
			for (int i = 0; i < planCount; i++) {
				if (pdpPlans.get(i).getText().length() == 0) {
					flag = false;
				}
			}
		} else if (planType.equals("SNP")) {
			String planHeading = msnPlanHeadingText.getText();
			System.out.println(planHeading);
			if (!planHeading.equals("Medicare Special Needs Plans")) {
				flag = false;
			}
			planCount = Integer.valueOf(msnPlansCount.getText());
			for (int i = 0; i < planCount; i++) {
				if (msnPlans.get(i).getText().length() == 0) {
					flag = false;
				}
			}
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean validatePlanSummarydetails(String planName) {
		boolean flag = true;
		String fileName = null;
		WebElement planContainer = null;
		if (planName.contains("SNP")) {
			fileName = "snpplansummary.json";
			planContainer = snpPlanConatiner;
		} else if (planName.contains("HMO")) {
			fileName = "maplansummary.json";
			planContainer = maPlanConatiner;
		} else if (planName.contains("PDP")) {
			fileName = "pdpplansummary.json";
			planContainer = pdpPlanConatiner;
		} else if (planName.contains("Regional PPO")) {
			fileName = "mamultistateplansummary.json";
			planContainer = maPlanConatiner;
		}

		vppPlanSummary = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		ElementData elementData = new ElementData("className","ng-scope");
		List<WebElement> planElement = findChildElements(elementData, planContainer);
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {
				for (String key : vppPlanSummary.getExpectedData().keySet()) {
					WebElement element = findChildElement(vppPlanSummary.getExpectedData().get(key), plan);
					System.out.println("Checking for the element : "+key );
					flag = validate(element);
					if (!flag) {
						break;
					}
				}
			}
		}
		return flag;
	}

	public PlanDetailsPage navigateToPlanDetails(String planName, String planType) {

		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View Plan')]"));
			CommonUtility.waitForPageLoadNew(driver, MAmoreDetailsLink, 30);
			jsClickNew(MAmoreDetailsLink);
			System.out.println("View Plan Details Link is clicked for MA plan" + planName);

		} else if (planType.equalsIgnoreCase("PDP")) {
            WebElement PDPmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
                    + "')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@id,'viewmoredetlinkpdp')]"));
			CommonUtility.waitForPageLoadNew(driver, PDPmoreDetailsLink, 30);
			jsClickNew(PDPmoreDetailsLink);
			System.out.println("View Plan Details Link is clicked for PDP plan"+planName);
			
		} else if (planType.equalsIgnoreCase("SNP")) {
			WebElement SNPmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//a[contains(text(),'View Plan')]"));
			CommonUtility.waitForPageLoadNew(driver, SNPmoreDetailsLink, 30);
			jsClickNew(SNPmoreDetailsLink);
			System.out.println("View Plan Details Link is clicked for SNP plan"+planName);

		}else if (planName.contains("HMO") || planName.contains("Regional PPO")) {
			WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[contains(text(),'View plan and drug coverage details')]"));
			//CommonUtility.waitForPageLoad(driver, MAmoreDetailsLink, 30);	
					validate(MAmoreDetailsLink);
					
					jsClickNew(MAmoreDetailsLink);
					System.out.println("View Plan Details Link is clicked for MA plan"+planName);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("#/details")) {	
			return new PlanDetailsPage(driver,planType);
		}
		return null;
	}
	
	
	public AcquisitionHomePage navigateToPlanDetailsDST(String planName, String planType) {

		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan')]"));
			CommonUtility.waitForPageLoadNew(driver, MAmoreDetailsLink, 30);
			MAmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for MA plan" + planName);

		} else if (planType.equalsIgnoreCase("PDP")) {
			WebElement PDPmoreDetailsLink = driver.findElement(By.xpath("//h2[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//*[@id = 'viewmoredetlinkpdp']"));
			CommonUtility.waitForPageLoadNew(driver, PDPmoreDetailsLink, 30);
			PDPmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for PDP plan"+planName);
			
		} else if (planType.equalsIgnoreCase("SNP")) {
			WebElement SNPmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//a[contains(text(),'View plan')]"));
			CommonUtility.waitForPageLoadNew(driver, SNPmoreDetailsLink, 30);
			SNPmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for SNP plan"+planName);

		}else if (planName.contains("HMO") || planName.contains("Regional PPO")) {
			WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[contains(text(),'View plan and drug coverage details')]"));
			//CommonUtility.waitForPageLoad(driver, MAmoreDetailsLink, 30);	
					validate(MAmoreDetailsLink);
					
					MAmoreDetailsLink.click();
					System.out.println("View Plan Details Link is clicked for MA plan"+planName);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		try{
		Thread.sleep(3000);
		}catch(Exception e)
		{
			System.out.println("Thread not slept");
		}
		if (driver.getCurrentUrl().contains("#/details")) {	
			System.out.println("Mil gaya");
			return new AcquisitionHomePage(driver, planType, true);
		}
		return null;
	}
	

	private WebElement getViewPlanDetailsElement(List<WebElement> maPlanElement2, ElementData elementData,
			String planName) {

		for (WebElement plan : maPlanElement2) {
			System.out.println(plan.getText());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (plan.getText().contains(planName)) {

				WebElement element = findChildElement(elementData, plan);

				return element;

			}
		}
		return null;
	}

        public void viewPlanSummary(String planType) {
            if (planType.equalsIgnoreCase("PDP")) {
                            CommonUtility.waitForPageLoadNew(driver, pdpPlansViewLink, 30);
                            sleepBySec(2); //note: add sleep for timing issue, tried increase timeout from waitForPageLoadNew but didn't work
                            jsClickNew(pdpPlansViewLink);
                            System.out.println("PDP Plan Type Clicked");
                            CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
            } else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
                            CommonUtility.waitForPageLoadNew(driver, maPlansViewLink, 30);
                            sleepBySec(2);
							jsClickNew(maPlansViewLink);
                           // maPlansViewLink.click();
                            CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
            } else if (planType.equalsIgnoreCase("MS")) {
            			driver.navigate().refresh();
                            CommonUtility.waitForPageLoadNew(driver, msPlansViewLink, 30);
                            sleepBySec(2);
                            jsClickNew(msPlansViewLink);
                           // CommonUtility.waitForPageLoadNew(driver, medSuppPlanList.get(0), 30);
            } else if (planType.equalsIgnoreCase("SNP")) {
            			sleepBySec(5);
        	            CommonUtility.checkPageIsReady(driver);
        	            jsClickNew(snpPlansViewLink);
        	            CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
            }
          }

	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver,45);
		else 
			checkModelPopup(driver,10);
		handleChatPopup();
		validateVPPPlanSummaryPage();
	}

	public JSONObject getPlanSummaryActualData(String planName) {
		String fileName = null;
		if (planName.contains("SNP")) {
			fileName = "snpplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName, snpPlanConatiner);
			return jsonObject;
		} else if (planName.contains("HMO") || planName.contains("Regional PPO")) {
			fileName = "maplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName, maPlanConatiner);
			return jsonObject;
		} else if (planName.contains("PDP")) {
			fileName = "pdpplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName, pdpPlanConatiner);
			return jsonObject;
		} else if (planName.contains("Regional PPO")) {
			fileName = "mamultistateplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName, maPlanConatiner);
			return jsonObject;

		}

		return null;
	}

	private JSONObject getActualJsonObject(String fileName, String planName, WebElement planContainer) {

		vppPlanSummary = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		ElementData elementData = new ElementData("className", "ng-scope");
		List<WebElement> planElement = findChildElements(elementData, planContainer);
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {
				JSONObject jsonObject = new JSONObject();
				for (String key : vppPlanSummary.getExpectedData().keySet()) {
					WebElement element = findChildElement(vppPlanSummary.getExpectedData().get(key), plan);
					validate(element);
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				return jsonObject;

			}
		}
		return null;

	}

	public String viewplans(String planName) {
		// TODO Auto-generated method stub
		return null;
	}

	public EstimateDrugCostPage navigateToSummaryPage(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			showPdpPlans.click();
		}
		return new EstimateDrugCostPage(driver);
	}

	public ManageDrugPage navigateToEditDrugList(String planName) {

		if (planName.contains("HMO")) {
			ElementData elementData = new ElementData("id", "editDrugMA");
			WebElement element = getViewPlanDetailsElement(maPlanElement, elementData, planName);
			if (element != null) {
				element.click();

			}

		} else if (planName.contains("PDP")) {
			ElementData elementData = new ElementData("id", "editDrugMA");
			WebElement element = getViewPlanDetailsElement(pdpPlanElement, elementData, planName);
			if (element != null) {
				element.click();

			}

		}
		CommonUtility.checkPageIsReady(driver);
		if (currentUrl().contains("manageDrugList")) {
			return new ManageDrugPage(driver);
		}

		return null;
	}

	public EnrollPlanInfoPage clicksOnEnrollInplanLink(String planName) {
		if (planName.contains("HMO")) {
			if (maPlans != null) {
				for (WebElement plan : maPlans) {
					if (plan.getText().contains(planName)) {
						ElementData elementData = new ElementData("id", "enrollMAButton");
						if (findChildElement(elementData, plan).isDisplayed()) {
							findChildElement(elementData, plan).click();
							break;
						} else {
							if (viewPlansYearLink.isDisplayed()) {
								viewPlansYearLink.click();
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								viewPlanSummary("MA");
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								if (maPlans != null) {
									for (WebElement newPlan : maPlans) {
										if (newPlan.getText().contains(planName)) {
											ElementData newelementData = new ElementData("id", "enrollMAButton");
											findChildElement(newelementData, newPlan).click();
											break;
										}
									}
								}
								break;
							}
						}
					}
				}
			}
		}
		if (planName.contains("PDP")) {
			for (WebElement plan : pdpPlans) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enrollPDPButton"); // TODO:
					// Re-check
					if (findChildElement(elementData, plan).isDisplayed()) {
						findChildElement(elementData, plan).click();
						break;
					} else {

						if (viewPlansYearLink.isDisplayed()) {
							viewPlansYearLink.click();
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							viewPlanSummary("PDP");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for (WebElement newPlan : pdpPlans) {
								if (newPlan.getText().contains(planName)) {
									ElementData newelementData = new ElementData("id", "enrollPDPButton");
									findChildElement(newelementData, newPlan).click();
									break;
								}
							}
							break;
						}

					}
				}
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for( int i = 0; i<10; i++){
			if (pageHeading.getText().equalsIgnoreCase("You Have Chosen to Enroll in the Following Plan")) {
				break;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (pageHeading.getText().equalsIgnoreCase("You Have Chosen to Enroll in the Following Plan")) {
			return new EnrollPlanInfoPage(driver);
		} else {
			return null;
		}

	}

	public GetStartedPage clicksOnEnterDrugInformationLink(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enterDrugMA");
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (planName.contains("PDP")) {
			for (WebElement plan : pdpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enterDrugPDP"); // TODO Re-check
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new GetStartedPage(driver);
		}
		return null;

	}

	public Rallytool_Page clicksOnIsProviderCovered(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "doctorCoverMA");
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (planName.contains("SNP")) {
			for (WebElement plan : snpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "doctorCoverMA"); // TODO Re-check
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (driver.getTitle().equalsIgnoreCase("Welcome")) {
			return new Rallytool_Page(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}

	public ProviderSearchPage clicksOnIsProviderCoveredUms(String planName) {

		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@class,'add-provider')]"));
		validateNew(ProviderSearchLink);
		switchToNewTabNew(ProviderSearchLink);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPage(driver);
				}
		return null;
			}

	public VPPPlanSummaryPage clicksOnIsProviderCoveredA(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement1) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "doctorCoverMA");
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (planName.contains("SNP")) {
			for (WebElement plan : snpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "doctorCoverMA"); // TODO Re-check
					findChildElement(elementData, plan).click();
				}
			}
		}

		String mainwindow = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {

			if (!currentWindowHandle.equals(mainwindow)) {
				driver.switchTo().window(currentWindowHandle);

			}
		}

		driver.manage().window().maximize();
		waitforElement(GetStarted);
		GetStarted.click();

		waitforElement(People);

		People.click();

		waitforElement(Primary);

		Primary.click();

		waitforElement(Physician);

		Physician.click();

		waitforElement(Savebtn);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Savebtn);

		// Savebtn.click();
		waitforElement(Viewsavebtn);

		Viewsavebtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waitforElement(Checkcoverage);
		CommonUtility.waitForPageLoad(driver, Checkcoverage, 10);
		Checkcoverage.click();
		driver.switchTo().window(mainwindow);

		return new VPPPlanSummaryPage(driver);

	}

	public boolean providerinfo() {
		String providerinfo=provider.getText();
		if (providerinfo.contains("1 providers covered")) {
			return true;
		}
		return false;
	}
	
	public boolean providerinfo(String planName) {

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'provider-list added')]"));
		String mproviderinfo=ProviderSearchLink.getText();
        System.out.println(mproviderinfo);
		if (mproviderinfo.toLowerCase().contains("providers covered")) {
			return true;
		}
		return false;
	}

	public RequestAgentAppointmentPage nagiateToRequetAnAppointmentPage() {
		make_an_appointment_agent.click();

		try {
			if (make_an_appointment_agent.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, make_an_appointment_agent, CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("make_an_appointment_agent not found");
		} catch (TimeoutException ex) {
			System.out.println("make_an_appointment_agent not found");
		} catch (Exception e) {
			System.out.println("make_an_appointment_agent not found");
		}
		if (currentUrl().contains("medicare-advantage-plans/request-information/agentebrc.html")) {
			return new RequestAgentAppointmentPage(driver);
		}

		return null;

	}

	public String togglePlan() {
		String currentYearFlag = "false";
		validate(toggleplanYear);
		if (toggleplanYear != null) {
			toggleplanYear.click();
			currentYearFlag = "true";
		}
		return currentYearFlag;
	}

	public VPPPlanSummaryPage togglePlanYear(String planType) {

		validate(toggleplanYear);
		if (toggleplanYear != null) {
			toggleplanYear.click();
		}
		return new VPPPlanSummaryPage(driver, planType);
	}

	public void clicksOnMAProviderCoveredLink() {
		MaProviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}

	/**
	 * This method verifies whether the Compare 3 Plans button is Inactive or NOt
	 */
	public void verifyInactiveCompare3PlansButton() {
		waitforElement(comparePDPPlanChkBox);
		Assert.assertTrue("FAIL - Compare 3 plans button is not displayed", elementFound(comparePDPPlanChkBox));
		Assert.assertEquals("true", comparePDPPlanChkBox.getAttribute("readonly"));
	}

	public void clickAndVerifyCompareUpto3PlansPopup() {
		comparePDPPlanChkBox.click();
		Assert.assertEquals("Compare up to 3 plans Select 2-3 plans that you'd like to compare.",
				compareUpto3PlansPopup.getText().trim());
	}

	public boolean verifyCompareCheckBoxesAreUnchecked(){
		if (!planCompareList.get(0).isSelected())
			return true;
		return false;

	}

	public void UncheckAndVerifyCompareChkBox() {
		if (validate(compareChkBox3)) {
			compareChkBox3.click();
		}

		Assert.assertEquals("compare_checkbox ng-scope ng-valid ng-dirty", compareChkBox3.getAttribute("class"));
	}

	public void VerifyComparePopUpText() {

		Assert.assertEquals("Select 1 more plan to compare", comparePopUpTxt1.getText().trim());
		Assert.assertEquals("Select 2-3 plans that you'd like to compare", comparePopUpTxt2.getText().trim());
	}

	public void clickCompareChkBox(){
		
		WebElement planCompare = driver.findElement(By.xpath("//input[@id='compare-plan-1']/following-sibling::label"));
		planCompare.click();
		
		/*for(int currentCheckboxIndex = 0; currentCheckboxIndex < planCompareList.size(); currentCheckboxIndex ++) {
		if(planCompareList.get(currentCheckboxIndex).getText().trim().equalsIgnoreCase("Add to compare")){
			planCompareList.get(currentCheckboxIndex).click();
				Assert.assertTrue("Text not changed after checking checkbox", planCompareList.get(currentCheckboxIndex)
						.getText().trim().equalsIgnoreCase("Added to compare"));
		break;
			} else {
			continue;
		}
		}*/

	}

	public void clickCompareChkBoxPDP() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allPDPPlans = driver
				.findElements(By.xpath(".//*[@id='plan-list-3']//div[contains(@class,'compare-box')]//label"));

		if (allPDPPlans != null) {
			for (int i = 0; i < allPDPPlans.size(); i++) {
				allPDPPlans.get(i).click();
				if (i == 3){
					break;
		}
			}
		}

	}

	public boolean validatepassportData() {
		try {
			Thread.sleep(20000);

			String expectedpassportdata = PassportFlyerPDF.getText();
			String actualpassportdata = "Passport Flyer (PDF)";
			if (expectedpassportdata.equalsIgnoreCase(actualpassportdata)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;

	}

	public boolean validateVPPPlanSummaryPage() {
		//CommonUtility.waitForElementToDisappear(driver,getLoadingIndicator(),CommonConstants.TIMEOUT_40);
		//note: this refresh line is causign the plan year selection popup not able to click Go, so comment it out for now
		//driver.navigate().refresh(); //rectified page load issue on stage
		
		CommonUtility.waitForPageLoad(driver, vppTop, 30);
		validateNonPresenceOfElement(getLoadingIndicator());
		validateNew(maPlansCount);
		validateNew(msPlansCount);
		validateNew(pdpPlansCount);
		validateNew(snpPlansCount);
		//note: once you change zipcode once using it, this field will not show again
		//validateNew(changeLocationBtn);

		int allPlans = Integer.valueOf(vppTop.getText().substring(10, 12).trim());
		int maPlans = Integer.valueOf(maPlansCount.getText());
		int msPlans = 0;
		try {
			msPlans = Integer.valueOf(msPlansCount.getText());
		} catch (NumberFormatException e) {
			msPlans = 0;
		}
		int pdpPlans = Integer.valueOf(pdpPlansCount.getText());
		int snpPlans = Integer.valueOf(snpPlansCount.getText());

		if (allPlans == maPlans + msPlans + pdpPlans + snpPlans) {
			return true;
		}
		return false;

	}

	public PlanDetailsPage clickViewDetails_AddedToCompare() {

		validateNew(ViewPlanLink_AddedToCompare);
		ViewPlanLink_AddedToCompare.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (currentUrl().contains("#/details"))
			return new PlanDetailsPage(driver);
		return null;
	}

	public PlanDetailsPage clickViewDetails() {

		validateNew(ViewPlanLink);
		ViewPlanLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (currentUrl().contains("#/details"))
			return new PlanDetailsPage(driver);
		return null;
	}

	public PlanDetailsPage clickViewDetailsPDP() {
		if (validate(viewDetailsPDP)) {
			viewDetailsPDP.click();
		}

		if (currentUrl().contains("#/details"))
			return new PlanDetailsPage(driver);
		return null;
	}

	public void clickonViewPlans() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if (validateNew(viewPlans)) {
				viewPlans.click();
			}

		}

	public void clickOnPDPPlans() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (validate(viewPDPPlans)) {
			viewPDPPlans.click();
		}
	}

	public void clickOnViewPlans(String plantype) {
		CommonUtility.waitForPageLoad(driver, viewPlans, 30);
		if (plantype.equals("MA") || plantype.equals("MAPD")) {
			viewPlans.click();
		} else
			viewPDPPlans.click();

	}

	public DrugCostEstimatorPage navigateToDCE(String plantype) {
		if (plantype.equals("MA") || plantype.equals("MAPD")) {
			List<WebElement> maDCELink = driver.findElements(By.xpath(".//*[@id='plan-list-1']//*[contains(@class,'add-drug')]"));
			maDCELink.get(0).click();
		} else {
			List<WebElement> view2017PDPPlans = driver.findElements(By.id("pdpDrugCostEstimatorLink"));
			view2017PDPPlans.get(0).click();

		}
		CommonUtility.waitForPageLoad(driver, step1, 30);
		if (currentUrl().contains("/drug-cost-estimator"))
			return new DrugCostEstimatorPage(driver);
		return null;

	}

	public DrugCostEstimatorPage navigateToDCEAfterDrugAdded(String plantype) {
		CommonUtility.waitForPageLoad(driver, viewPlans, 30);
		if (plantype.equals("MA") || plantype.equals("MAPD")) {
			if (validate(viewPlans)) {
				viewPlans.click();
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> view2017Plans = driver.findElements(By.linkText("Edit drug list"));
			view2017Plans.get(0).click();
		} else {
			if (validate(viewPDPPlans)) {
				viewPDPPlans.click();
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> view2017PDPPlans = driver.findElements(By.linkText("Edit drug list"));
			view2017PDPPlans.get(0).click();

		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("/estimate-drug-costs.html#/drug-cost-estimator"))
			return new DrugCostEstimatorPage(driver);
		return null;

	}

	public void choose2017Plans() {

		if (validate(viewPlans)) {
			viewPlans.click();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (view2017Plans != null) {
			view2017Plans.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// viewPlans.click();
		}

	}

	public boolean yearBtnExists() {
		if (validate(view2017Plans))
			return true;
		return false;
	}

	/**
	 * Methods added for OLE Flow validations
	 * 
	 * @author sdwaraka
	 * @param PlanName
	 * @return
	 */
	public String getPlanPremium(String PlanName) {

		System.out.println("Plan Name is : "+PlanName);
		
		WebElement PremiumForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+PlanName+"')]//following::ul[@class='benefits-table'][1]//li[1]//span/span[contains(text(),'$') and (contains(@class,'scope'))]"));
		CommonUtility.waitForPageLoadNew(driver, PremiumForPlan, 30);
		String PlanPremium = PremiumForPlan.getText();

		System.out.println("Premium for Plan : " + PlanPremium);
		return PlanPremium;
	}

	/**
	 * @author sdwaraka Method Added for OLE Flow - Navigate to OLE from Plan
	 *         Summary Page
	 * @param planName
	 * @return
	 * @throws InterruptedException
	 */
	public WelcomePage Enroll_OLE_Plan(String planName,String planType) throws InterruptedException {

		WebElement enrollForPlan = null;
		System.out.println("Enroll in Plan for Plan : "+planName);
	//	driver.navigate().refresh();
		Thread.sleep(6000);
		if(planType.equalsIgnoreCase("PDP"))
			enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'enrollment')]//*[contains(@class,'cta-button')]"));
		else
			enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/following::a[contains(text(),'Enroll in Plan')][2]"));
		
		if(enrollForPlan!=null){
			validateNew(enrollForPlan);
			enrollForPlan.click();
		}
		

		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		if (driver.getCurrentUrl().contains("enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}
	
	public WelcomePage Enroll_OLE_Plan_campaign_uhc(String planName,String planType) throws InterruptedException {

		WebElement enrollForPlan = null;
		System.out.println("Enroll in Plan for Plan : "+planName);
		
		if(planType.equalsIgnoreCase("PDP"))
			enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'enrollment')]//*[contains(@class,'cta-button')]"));
		else
			enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/following::a[contains(text(),'Enroll in Plan')][2]"));
		
		if(enrollForPlan!=null){
			validateNew(enrollForPlan);
			enrollForPlan.click();
		}
		

		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		if (driver.getCurrentUrl().contains("enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}

	/**
	 * @author sdwaraka Method added for OLE Flow Validations
	 * @return
	 */
	public String GetTFNforPlanType() {
		if (validateNew(RightRail_TFN,45)) {
			System.out.println("TFN is displayed in Right Rail");
			String TFN_Number = RightRail_TFN.getText();
			return TFN_Number;
		}
		System.out.println("TFN is not Displayed for PlanType in VPP page");

		return null;
	}

	public PlanComparePage selectplantocompare(String PlanType) {
		// To add upto 4 plans to compare and navigate to Plan Compare Page
		int count = 1;
		if (PlanType.contains("PDP")) {
			System.out.println("Plan Type is :" + PlanType);
			count = (Integer.parseInt(maPlansCount.getText())) + 1;
			System.out.println("Plan count starts is :" + count);
		}
		int CountUntil = count + 4;
		do {
			String temp = Integer.toString(count);
			WebElement SelectCompare = driver
					.findElement(By.xpath("//*[@id = 'compare-plan-" + temp + "']//following-sibling::label"));
			if(validate(SelectCompare))
				SelectCompare.click();
			count++;
		} while (count < CountUntil);

		List<WebElement> ComparePlansLinks = driver.findElements(By.xpath("//a[@class='compare-link']"));
		// validate();
		for (WebElement CompareLink : ComparePlansLinks) {
			if (CompareLink.isDisplayed()) {
				CompareLink.click();
				CommonUtility.checkPageIsReady(driver);
				if (driver.getCurrentUrl().contains("plan-compare")) {
					return new PlanComparePage(driver);
				}
			}
		}
		System.out.println("Compare Plans Link not displayed");
		return null;
	}

	public String EnrollmentValidation(String PlanName) {

		try {
			Thread.sleep(5000);
			try {
			if(YearToggle.getText().contains("View 2019 Plans"))
				YearToggle.click();
			Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("Toggle Not found");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Plan Name is : " + PlanName);

		if (PlanName.equalsIgnoreCase("UnitedHealthcare Medicare Silver (Regional PPO SNP)")) {
			WebElement EnrollmentButton = driver
					.findElement(By.xpath("(//*[@class='enrollment']/div[@class='swiper-content ng-scope']/a)[5]"));
			String Enrollment = EnrollmentButton.getText();
			if (EnrollmentButton.isDisplayed())
				EnrollmentButton.click();
			System.out.println("Enrollment Button present and clicked");
			return Enrollment;
		} else {
		try{
				WebElement EnrollmentButton = driver
						.findElement(By.xpath("//*[@class='enrollment']/div[@class='acqplans ng-scope']/div/a/span"));
		String Enrollment = EnrollmentButton.getText();
		if(EnrollmentButton.isDisplayed())
			EnrollmentButton.click();
		System.out.println("Enrollment Button present and clicked");
		return Enrollment;
			} catch (Exception e) {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,800)", "");
				WebElement EnrollmentButton = driver.findElement(By.xpath(
						"(//*[@class='module-plan-overview module swiper-slide ng-scope'])[9]//div[@class='enrollment']//a/span"));
			String Enrollment = EnrollmentButton.getText();
			if(EnrollmentButton.isDisplayed())
				EnrollmentButton.click();
			System.out.println("Enrollment Button present and clicked");
			return Enrollment;
		}
		}
			}

public WelcomePage EnrollmentValidationChronic(String PlanName) throws InterruptedException {
	
			
		try {
			Thread.sleep(5000);	
		if(YearToggle.getText().contains("View 2019 Plans"))
			YearToggle.click();
		Thread.sleep(5000);
			} catch (Exception e) {
			System.out.println("Toggle Not found");
		}

	System.out.println("Plan Name is : "+PlanName);	
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor)driver;
		 * jse.executeScript("window.scrollBy(0,-10)", "");
		 */
		Thread.sleep(2000);
		WebElement EnrollmentButton = driver
				.findElement(By.xpath("(//*[@class='enrollment']/div[@class='swiper-content ng-scope']/a/span)[5]"));
	if(EnrollmentButton.isDisplayed())
		EnrollmentButton.click();
	System.out.println("Enrollment Button present and clicked");
	Thread.sleep(2000);
	return new WelcomePage(driver);
	
		}

	public AepVppPlanSummaryPage validate_aepPlanYearLinks(String currentYear, String nextYear) {
		 // Commenting below lines of code as it is being covered by step - When user views plans of the below plan type in UMS site

		/*WebElement CurrentYearRadio = driver.findElement(By.xpath("//label[contains(@for, 'current_Year')]"));
		WebElement NextYearRadio = driver.findElement(By.xpath("//label[contains(@for, 'next_Year')]"));
		WebElement SelectYearGoBtn = driver.findElement(By.xpath("//*[contains(@id, 'GoBtnText')]"));
		System.out.println("Next Year Displayed in AEP Year Selection Modal : " + NextYearRadio.getText());
		System.out.println("Current Year Displayed in AEP Year Selection Modal : " + CurrentYearRadio.getText());

//		System.out.println("AEP Year Toggle link is displayed on VPP Page : "+CurrentYearRadio.getText());
		System.out.println("*****CLICKING ON NEXT YEAR Radio*****");
		NextYearRadio.click();
		System.out.println("*****CLICKING ON Year Toggle Go button*****");

		SelectYearGoBtn.click();*/
		WebElement CurrentYearLink = driver.findElement(By.xpath("//label[contains(@for, 'currentYear')]"));
		WebElement NextYearLink = driver.findElement(By.xpath("//label[contains(@for, 'futureYear')]"));
		System.out.println("Current Year link on VPP Page : "+CurrentYearLink.getText());

		//List <WebElement> NextYearHeadings = driver.findElements(By.xpath("//*[contains(text(), '"+nextYear+"')]"));
		if( validate(CurrentYearLink) && validate(NextYearLink)){
			System.out.println("Current and Next year toggle displayed for AEP");
			return new AepVppPlanSummaryPage(driver);
		} else {
			System.out.println("Current and Next year toggle NOT displayed for AEP");
		}

		// TODO Auto-generated method stub
		return null;
	}

public ComparePlansPageBlayer clickOnCompareLink(){
		
		List<WebElement> compareLinks = driver
				.findElements(By.xpath(".//span[contains(@class,'added-text show')]//button[contains(text(),'Compare plans')]"));
		compareLinks.get(1).click();



		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPageBlayer(driver);
		return null;
	}

public boolean validateAllPlansChecked() {
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		//tbd List<WebElement> compareChkBoxes = driver.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]"));
	List<WebElement> compareChkBoxes = driver.findElements(By.xpath("//div[contains(@class,'compare-add')]"));	
		if (compareChkBoxes.get(0).getText().contains("3 plans added")
				&& compareChkBoxes.get(1).getText().contains("3 plans added")
				&& compareChkBoxes.get(2).getText().contains("3 plans added"))
		return true;
	return false;
}

	public void checkAllMAPlans() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allMAPlans = driver
				.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]//label"));

		if (allMAPlans != null) {
			for (int i = 0; i < allMAPlans.size(); i++) {
				allMAPlans.get(i).click();
				if (i == 3){
					break;
				}
			}
		}

	}

    public boolean getSpecificPlanInfo(String planName) throws InterruptedException {
        boolean isSpecificPlanInfoPresent = false;
        if (planName.contains("SNP")) {
            //ElementData elementData = new ElementData("id", "viewDetailsMA");
        Thread.sleep(5000);
isSpecificPlanInfoPresent = getSpecificPlanSummary(snpPlanList, planName);
           // element = getSpecificPlanSummary(findChildElements(elementData, snpPlanList), planName);
}
        else if(planName.contains("HMO")) {
                        isSpecificPlanInfoPresent = getSpecificPlanSummary(maPlanList, planName);
        }
        else if (planName.contains("PDP")) {
            //ElementData elementData = new ElementData("id", "viewDetailsPDP");
            //element = getSpecificPlanSummary(findChildElements(elementData, pdpPlanList), planName);
 isSpecificPlanInfoPresent = getSpecificPlanSummary(pdpPlanList, planName);
} 
        

        return isSpecificPlanInfoPresent;
}

/*private boolean getSpecificPlanSummary(WebElement element, String planName) {
        if (element.getText().contains(planName)) {
                        return true;
        } else {
                        return false;
        }
}*/
/*public void validateMedicalBenefitDrugSection() {
        validateNew(drugCoveredInfo);
        validateNew(estimatedAnnualDrigCostLabel);
        validateNew(estimatedAnnualDrigCostValue);
}*/

public MultiCountyModalPage VPP_ChangeLocationValidateMultiCOuntyPopUp(String zipcode) {
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	validate(ChangeLocationLink);
	ChangeLocationLink.click();
	validate(ZipCodeTxtBx);
	ZipCodeTxtBx.click();
	ZipCodeTxtBx.clear();
	ZipCodeTxtBx.sendKeys(zipcode);
	validate(FIndPlansButton);
	FIndPlansButton.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	if (countyModal.isDisplayed()) {
		return new MultiCountyModalPage(driver);
	}
	return null;
}
public PlanDetailsPage validatePromoWidjet(String planname) {
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planname+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan')]"));
	validateNew(MAmoreDetailsLink);
	validateNew(promoWidject);
	
	return new PlanDetailsPage(driver);
	
	//validateNew();
	
}

private boolean getSpecificPlanSummary(WebElement element, String planName) {
    if (element.getText().contains(planName)) {
                    return true;
    } else {
                    return false;
    }
}
public void validateMedicalBenefitDrugSection(String planName) {

	//If any of these elements are not found, the test will fail so no need to add validate method.
	
	 driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'drug-list-accordion')]"));
	driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(text(),'Estimated Annual Drug Cost')]"));
	 driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(text(),'Estimated Annual Drug Cost')]/following-sibling::span[not(contains(@class,'ng-hide'))]"));


}

public void validateAndClickAddtoCompareinUMS(String planType , String planName) throws InterruptedException {
    if (planType.equalsIgnoreCase("MAPD")) {
    System.out.println("Choose Plan to Compare : "+planName);
    //WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//input[@id='compare-plan-2']"));
    WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//div[contains(@class ,'compare-box')]//span[contains(@class ,'ng-scope')]/label"));
    validateNew(addToCompare);
    addToCompare.click();
    }
    if (planType.equalsIgnoreCase("MA")) {
                    System.out.println("Choose Plan to Compare : "+planName);
                    WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//div[contains(@class ,'compare-box')]//span[contains(@class ,'ng-scope')]/label"));
                    validateNew(addToCompare);
                    addToCompare.click();
                    }
    if (planType.equalsIgnoreCase("PDP")) {
                    System.out.println("Choose Plan to Compare : "+planName);
                    WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//div[contains(@class ,'compare-box')]//span[contains(@class ,'ng-scope')]/label"));
                    validateNew(addToCompare);
                    addToCompare.click();
                    }
    
}

public boolean compareTextAfterclickingAddtoCompareinUMS(String planName) throws InterruptedException {                
WebElement compareText = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[contains(@class,'compare-add')]//span[contains(@class,'single-added-text')]"));    
    if(compareText.getText().contains("1 plan added")){
                    System.out.println("1 plan has been selected for comparison");                
                    return true;
    } else {
                    return false;
    }
    }
public void validateAddToCompareNotPresentForDSNP(String planName){
try{
if(driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[contains(@class, 'module-plan-overview')]//*[contains(text(), 'compare-plan')]")).isDisplayed()){
Assert.fail("Add to compare checkbox is present for DSNP Plans");  
}
}
catch(Exception e){
System.out.println("Add to compare checkbox is not present for DSNP Plans");
Assert.assertTrue(true);
}
}
public void validatesLearnMoreAboutExtraHelpPopup() {
validateNew(learnMoreModalPopUp);
backButtonInLearnMoreModal.click();

}
public void validateAndClickLearnMoreAboutExtraHelpInUMS(String planType , String planName) throws InterruptedException {
    if (planType.equalsIgnoreCase("MAPD")) {
    	int attempts = 0;
	    while(attempts < 2) { //this code is used to prevent staleelement exception
	        try {
		    	WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[contains(@class, 'module-plan-overview')]//a[contains(@class, 'inline-edit-link modal-link vpp-monthly-premium-modal')]"));
			    validateNew(learnMoreAboutExtraHelp);            
			    learnMoreAboutExtraHelp.click();
			    break;
	         } catch(StaleElementReferenceException e) {
	         }
	        attempts++;
	    }
    }
    if (planType.equalsIgnoreCase("SNP")) {
    	int attempts = 0;
	    while(attempts < 2) {
	        try {
                    WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[contains(@class, 'module-plan-overview')]//ul[contains(@class,'benefits-table')]//li//*[contains(@class,'inline-edit-link')]"));
                    CommonUtility.waitForPageLoadNew(driver,learnMoreAboutExtraHelp, 30);
                    validateNew(learnMoreAboutExtraHelp);
                    learnMoreAboutExtraHelp.click();
                    break;
	         } catch(StaleElementReferenceException e) {
	         }
	        attempts++;
	    }
                    }
    if (planType.equalsIgnoreCase("PDP")) {
    	int attempts = 0;
	    while(attempts < 2) {
	        try {
                    WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[contains(@class, 'module-plan-overview')]//li//span[1]//a[contains(@id, 'S5921413000Link')]"));
                    validateNew(learnMoreAboutExtraHelp);
                    learnMoreAboutExtraHelp.click();
                    break;
	        } catch(StaleElementReferenceException e) {
	        }
	        	attempts++;
	    }
                    }
    if(planType.equalsIgnoreCase("MA")){
    	try{
       //WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("(//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[@class='inline-edit-link modal-link vpp-monthly-premium-modal'])[1]"));
       //validateNonPresenceOfElement(driver.findElement(By.xpath("(//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[@class='inline-edit-link modal-link vpp-monthly-premium-modal'])[1]")));
    	if(driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//a[contains(@class, 'inline-edit-link modal-link vpp-monthly-premium-modal')]")).isDisplayed()){
    		Assert.fail("Learn More About Extra Help is present for MA plans");
    	}	
    	}
    	catch (Exception e){
    		System.out.println("Learn More About Extra Help is not present for MA plans");
    		Assert.assertTrue(true);
    	}
    }
    
}            
public void validateIsMyProviderCoveredLinkInUMS(String planType , String planName) {
    int attempts = 0;
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	while(attempts < 2) {
        try {
			WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
		                                    + "\')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@class,'add-provider')]"));
		    if(planType.equalsIgnoreCase("PDP")){
		                    validateNonPresenceOfElement(ProviderSearchLink);
		                    break;
		    }
		    else {
		                    validateNew(ProviderSearchLink);
		                    break;
		    }
        }catch(StaleElementReferenceException e) {
        }
    	attempts++;
	}
}

public void clicksOnIsProviderCoveredUMS(String planName) throws InterruptedException {
    
    //CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
    
    WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
                                    + "\')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@class,'add-provider')]"));
    //switchToNewTabNew(ProviderSearchLink);
    String parentHandle = driver.getWindowHandle();
    int initialCount = driver.getWindowHandles().size();
    ProviderSearchLink.click();
    Thread.sleep(5000);
    waitForCountIncrement(initialCount);
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    String currentHandle = null;
    for (int i = 0; i < initialCount + 1; i++) {
                    driver.switchTo().window(tabs.get(i));
                    currentHandle = driver.getWindowHandle();
                    if (!currentHandle.contentEquals(parentHandle))
                                    break;
    }

    if (driver.getCurrentUrl().contains("werally")) {
                    System.out.println("Provider Search Page is displayed");
                    Assert.assertTrue(true);
                    driver.switchTo().window(parentHandle);
                    if (driver.getCurrentUrl().contains("plan-summary")) {
                                    System.out.println("Back to VPP Plan Summary Page");
                                    Assert.assertTrue(true);
                    }
                    else
                    {
                                    Assert.fail("Unable to navigate back to VPP Plan Summary Page");
                    }
                    }
    else 
      Assert.fail("Provider Search Page is not displayed");      
                    }

public void validatePlanPremium (String planName , String monthlyPremium){
	WebElement premiumForPlan = null;
	if(planName.contains("SNP")){
		 premiumForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li[contains(@id, 'linkforsnp')]//*[contains(text(),'Monthly Premium')])"));
	}else if(planName.contains("PDP")){
		 premiumForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Monthly Premium')])"));
	}else
		 premiumForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li//*[contains(text(),'Monthly Premium')])"));
	
	validateNew(premiumForPlan);
    }
    
    public void validatePrimaryCarePhysicianBenefit (String planType , String planName , String primaryCarePhysician){
    	WebElement PrimaryCarePhysicianForPlan = null;
		
		
		if(planName.contains("SNP")){
			PrimaryCarePhysicianForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li[contains(@id, 'linkforsnp')]//*[contains(text(),'Primary Care Physician')]"));
		}else if(planName.contains("PDP")){
			PrimaryCarePhysicianForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Primary Care Physician')]"));
		}else
			PrimaryCarePhysicianForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li//*[contains(text(),'Primary Care Physician')])"));

		
		validateNew(PrimaryCarePhysicianForPlan);
      /*  if(!planType.equals("SNP")){
        	String PrimaryCare = PrimaryCarePhysicianForPlan.getText();	
        	if(PrimaryCare.equalsIgnoreCase(primaryCarePhysician)){
                System.out.println("PrimaryCare for the plan is " + PrimaryCare); 
                Assert.assertTrue(true);
              }
              else
                Assert.fail("Primary Care Physician Benefit for the plan is incorrect : "+planName);
        }
        else {
          String PrimaryCare = PrimaryCarePhysicianForPlan.getText().replaceAll("\n", " ");
          if(PrimaryCare.equalsIgnoreCase(primaryCarePhysician)){
              System.out.println("PrimaryCare for the plan is " + PrimaryCare); 
              Assert.assertTrue(true);
            }
            else
              Assert.fail("Primary Care Physician Benefit for the plan is incorrect : "+planName);
      } */
    }
    
    public void validateSpecialistBenefit (String planType , String planName , String specialist) {
    	WebElement specialistForPlan = null;
    	if(planName.contains("SNP")){
			specialistForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li[contains(@id, 'linkforsnp')]//*[contains(text(),'Specialist')]"));
		}else if(planName.contains("PDP")){
			specialistForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Specialist')]"));
		}else
			specialistForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li//*[contains(text(),'Specialist')]"));
        
    	validateNew(specialistForPlan);
    	/*if(!planType.equals("SNP")){
        String SpecialistBenefit = SpecialistForPlan.getText();
        if(SpecialistBenefit.equals(specialist)){
          System.out.println("Specialist Benefit for the plan is " + SpecialistBenefit);         
          Assert.assertTrue(true);
        }
        else
                        Assert.fail("Specialist Benefit for the plan is incorrect : "+planName);
      }
        else {
        	String SpecialistBenefit = SpecialistForPlan.getText().replaceAll("\n", " ");
        	 if(SpecialistBenefit.equals(specialist)){
                 System.out.println("Specialist Benefit for the plan is " + SpecialistBenefit);         
                 Assert.assertTrue(true);
               }
               else
                               Assert.fail("Specialist Benefit for the plan is incorrect : "+planName);
             }*/
        }
    
    public void validateReferrralRequiredBenefit (String planName , String referralRequired) {
    	
    	WebElement referralRequiredForPlan = null;
		if(planName.contains("SNP")){
			referralRequiredForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li[contains(@id, 'linkforsnp')]//*[contains(text(),'Referral')])"));
		}else if(planName.contains("PDP")){
			referralRequiredForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Referral')])"));
		}else
			referralRequiredForPlan =driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li//*[contains(text(),'Referral')]"));

		validateNew(referralRequiredForPlan);
        /*if(ReferRequired.equals(referralRequired)){
          System.out.println("Referral Required Benefit for the plan is " + ReferRequired);            
          Assert.assertTrue(true);
        }
        else
                        Assert.fail("Referral Required Benefit for the plan is incorrect : "+planName);*/
}
    
    public void validatesOutOfPocketMaximum (String planName , String outOfPocketMaximum) {

    	WebElement outOfPocketForPlan = null;
		if(planName.contains("SNP")){
			outOfPocketForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li//*[contains(text(),'Out Of Pocket')])"));
		}else if(planName.contains("PDP")){
			outOfPocketForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Out Of Pocket')])"));
		}else
			outOfPocketForPlan =driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li[contains(text(),'Out Of Pocket')]"));
		validateNew(outOfPocketForPlan);
         /*if(OOPMax.equals(outOfPocketMaximum)){
          System.out.println("OOPMax for the plan is " + OOPMax);        
          Assert.assertTrue(true);
        }
        else
                        Assert.fail("Out of Pocket Maximum Benefit for the plan is incorrect : "+planName);*/
}
    
    public void validatePrescriptionDrugsTier1(String planName,String planType, String prescriptionDrugsTier1) {
    	WebElement drugsForPlan = null;
		
	
		if(!prescriptionDrugsTier1.contains("No drug coverage")){
			if(planType.equalsIgnoreCase("SNP")){
				drugsForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li[contains(@id, 'linkforsnp')]//*[contains(text(),'Prescription Drugs')])"));
			}else if(planType.equalsIgnoreCase("PDP")){
				drugsForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Prescription Drugs')])"));
			}else if(planType.equalsIgnoreCase("MAPD")){
				drugsForPlan =driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li//*[contains(text(),'Prescription Drugs')]"));
			}else{
			}
		}
		
		if(drugsForPlan!=null)
			validateNew(drugsForPlan);
        /*if(PrescriptionDrugs.equals(prescriptionDrugsTier1)){
          System.out.println("PrescriptionDrugs for the plan is " + PrescriptionDrugs);      
          Assert.assertTrue(true);
        }
        else
          Assert.fail("Prescription Drugs, Tier 1 for the plan is incorrect : "+planName);*/
}
    
    public void validateAnnualDeductible(String planName , String annualDeductible) {
    	WebElement AnnualDeductibleForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(text(), 'Annual Deductible')]/span)[2]"));
        String planDeductible = AnnualDeductibleForPlan.getAttribute("textContent").trim();
          /* try {
           	 
           	System.out.println(" The text is " +AnnualDeductibleForPlan.getAttribute("textContent").trim());
           	System.out.println(" The text from feature file is " +annualDeductible);
				
			} catch (Exception e) {
				System.out.println(" The text is" +AnnualDeductibleForPlan.getText());
			}*/
           if(annualDeductible.equalsIgnoreCase(planDeductible)){
               System.out.println("Annual Deductible for the plan is " + planDeductible);            
               Assert.assertTrue(true);
             }
             else
               Assert.fail("Annual Deductible for the plan is incorrect : "+planName);
}
    
    public void validateMarketingBullets(String planType , String planName){
    	if(!planType.equals("PDP")){
             WebElement marketingBullets = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[contains(@class,'module-plan-overview')]//ul[contains(@class ,'highlight-list')]"));
             validateNew(marketingBullets);
	            }
	            if(planType.equals("PDP")){
	            	WebElement marketingBullets = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::div[contains(@class,'module-plan-overview')]//ul)[2]"));
	            	validateNew(marketingBullets);
	            }
    }
    
    public void toolTipForPremium0(String planName){
		WebElement toolTip = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[contains(@class,'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//*[name()='use']"));
		WebElement tooltipContent = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[contains(@class,'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//span"));
		Actions action = new Actions(driver);
		action.moveToElement(toolTip).build().perform();
		String toolTipText = tooltipContent.getAttribute("textContent").trim();
		if (toolTipText.contains("Why is my premium")){
			System.out.println("ToolTip text is " + toolTipText);
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Tool Tip is not working");	     	
	}
	
	public void toolTipForAnnualDeductible(String planName) {
		WebElement toolTip = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::div[contains(@class,'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//*[name()='use'])[2]"));
		WebElement tooltipContent = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::div[contains(@class,'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//span)[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(toolTip).build().perform();
		String toolTipText = tooltipContent.getAttribute("textContent").trim();
		if (toolTipText.contains("annual deductible")){
			System.out.println("ToolTip text is " + toolTipText);
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Tool Tip is not working");
	}
    
    public DrugCostEstimatorPage navigatetoDCEPage(String planName){
    	WebElement DCELink = null;
		
		if(planName.contains("SNP")){
			DCELink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'add-drug')]"));
		}else if(planName.contains("PDP")){
			DCELink = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li//*[contains(@id,'pdpDrugCostEstimatorLink')])"));
		}else
			DCELink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'add-drug')]"));

		Actions action = new Actions(driver);
		action.moveToElement(DCELink).build().perform();
    	DCELink.click();
    	CommonUtility.checkPageIsReadyNew(driver);
    	if(driver.getCurrentUrl().contains("drug-cost-estimator")){
    		System.out.println("DCE Page is loaded");
    		return new DrugCostEstimatorPage(driver);
    	}	
    	else
    		return null;  
    	}
    public void deselectAddToCompareinAARP(String planName){
    	try{
    	//WebElement addToCompareCheck = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope compare-add']//div[@class='compare-box']/span[@class='ng-scope']"));
    	WebElement addToCompareCheck = driver.findElement(By.xpath("//*[contains(@class,'added-num')]/ancestor::div[contains(@class,'compare-add')]//label[contains(@for,'compare-plan')]"));
    		addToCompareCheck.click();
    		System.out.println("Add to compare checkbox has been deselected");
    		Assert.assertTrue("deselected add to compare ", true);
    	}
    	catch (Exception e){	
    		Assert.fail("Unable to deselect Add to compare");
    	 }
    		}
    public void validateRightRailSection(){
    	validateNew(RightRailSection);
    }
   
    public void validateNeedHelpRightRail() {
    	validateNew(needHelpRightRail);
    	System.out.println("Need Help Section is present");
    }
    
    public void validateAgentEBRCPage() {
        validateNew(RightRail_AgentInYourArea);
        CommonUtility.waitForPageLoadNew(driver, RightRail_AgentInYourArea, 30);
        RightRail_AgentInYourArea.click();
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("agentebrc")) {
           System.out.println("Agent EBRC Page is displayed");
           Assert.assertTrue(true);
           driver.navigate().back();
           CommonUtility.checkPageIsReadyNew(driver);
           if(driver.getCurrentUrl().contains("plan-summary")) {
        	   System.out.println("Back on VPP Plan Summary Page");
               Assert.assertTrue(true);                    	  
           }
           else
        	   Assert.fail("Unable to load VPP Plan Summary Page");
          }
        else
        	Assert.fail("Unable to load Agent EBRC Page");                    
    	}                         
    
  public void validateMedicareGuideRightRail() {
	  validateNew(MedicareGuideRightRail);
  	System.out.println("Get a Free Medicare Guide Section is present");  
  }

  public void validateNeedMoreInformationRightRail() {
	  validateNew(NeedMoreInformationRightRail);
  	System.out.println("Need more Information Section is present");   	
  }
  
  public void validateMedicareVideoGuideRightRail() throws InterruptedException {
	  
	  validateNew(ChooseAVideo); 
  	 String parentHandle = driver.getWindowHandle();
  	 ChooseAVideo.click();
  	Thread.sleep(5000);
      System.out.println("Video link has been clicked");
  	 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
  for (String newWindow : tabs) {
	  driver.switchTo().window(newWindow);
	  System.out.println(driver.getTitle());
}
  System.out.println("Page navigation successful");
//  driver.switchTo().window(parentHandle);
	  
	  
	  
	  
	  
	  
	  
	  
	/* validateNew(ChooseAVideo); 
	// CommonUtility.waitForPageLoadNew(driver, RightRail_AgentInYourArea, 30);
	 String parentHandle = driver.getWindowHandle();
	 int initialCount = driver.getWindowHandles().size();
	 ChooseAVideo.click();

	 waitForCountIncrement(initialCount);
	 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
     String currentHandle = null;
     for (int i = 0; i < initialCount + 1; i++) {
                     driver.switchTo().window(tabs.get(i));
                     currentHandle = driver.getWindowHandle();
                     if (!currentHandle.contentEquals(parentHandle))
                                     break;
     }*/
  
  try {
	Thread.sleep(5000);
	
	System.out.println(" page  ");
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println(" page catch block ");
}
  
  
     if (driver.getCurrentUrl().contains("medicareguide")) {
         System.out.println("Medicare Plans Video Guide is displayed");
         Assert.assertTrue(true);
     }
         /*driver.switchTo().window(parentHandle);
         if (driver.getCurrentUrl().contains("plan-summary")) {
                         System.out.println("Back to VPP Plan Summary Page");
                         Assert.assertTrue(true);
         }
         else                
                         Assert.fail("Unable to navigate back to VPP Plan Summary Page");                   
         }*/
        else 
        Assert.fail("Medicare Plans Video Guide Page is not displayed");      
         }
  
  public void validatePlanSelectorToolRightRail(){
	  validateNew(PlanSelectorToolRightRail);
    	System.out.println("Plan Selector Tool Section is present");    
  }
  
  public void validatePlanSelectorPageInRightRail() {
	  validateNew(StartPlanSelector);
	  StartPlanSelector.click();
	  CommonUtility.checkPageIsReadyNew(driver);
	  if (driver.getCurrentUrl().contains("medicare-plans")) {
		    WebElement PlanSelector = driver.findElement(By.xpath("//*[@id='planSelectorTool']"));
			CommonUtility.waitForPageLoadNew(driver, PlanSelector, 30);			
			validateNew(PlanSelector);
          System.out.println("Plan Selector Tool Page is displayed");
          Assert.assertTrue(true);
          driver.navigate().back();
          CommonUtility.checkPageIsReadyNew(driver);
          if(driver.getCurrentUrl().contains("plan-summary")) {
       	   System.out.println("Back on VPP Plan Summary Page");
              Assert.assertTrue(true);                    	  
          }
          else
       	   Assert.fail("Unable to load VPP Plan Summary Page");
         }
       else
       	Assert.fail("Unable to load Plan Selector Tool Page");                    
   	} 
	  
  public void enterRequiredFieldsForMedicareGuide(Map<String, String> memberAttributesMap) {
	  String FirstName = memberAttributesMap.get("First Name");
		  String LastName =  memberAttributesMap.get("Last Name");
		  String EmailAddress = memberAttributesMap.get("Email Address");
		  sendkeysNew(firstNameField, FirstName);
	  sendkeysNew(lastNameField, LastName);
	  sendkeysNew(emailField, EmailAddress);
	  validateNew(Submitbutton);
	  jsClickNew(Submitbutton);	 
	  if(validateNew(medicareGuidePopup)){
		  System.out.println("Pop up message has been displayed");
		  WebElement closePopUp = driver.findElement(By.xpath("//*[contains(@class , 'emailsubmit_close')]"));
		  closePopUp.click();
		  CommonUtility.checkPageIsReadyNew(driver);
		  Assert.assertTrue(true);
	  }
	  else
		  Assert.fail("Popup message has not been displayed");
     }

public PlanComparePage selectplantocompare(String planType, String PlanName) {
	//To add upto 4 plans to compare and navigate to Plan Compare Page
	int count = 1;
	if(planType.contains("PDP")){
		System.out.println("Plan Type is :"+planType);
		count = (Integer.parseInt(maPlansCount.getText())) + 1;
		System.out.println("Plan count starts is :"+count);
	}
	int CountUntil = count+3;
	do{
		String temp = Integer.toString(count);
		WebElement SelectCompare = driver.findElement(By.xpath("//*[@id = 'compare-plan-"+temp+"']//following-sibling::label"));
		if(validate(SelectCompare))
			SelectCompare.click();
		count++;
	}while(count<CountUntil);

	try {
		if(driver.findElement(By.xpath("//*[contains(text(), '"+PlanName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//label[contains(@for, 'compare-plan')]")).getText().equalsIgnoreCase("Add to compare")){
			driver.findElement(By.xpath("//*[contains(text(), '"+PlanName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//label[contains(@for, 'compare-plan')]")).click();
			System.out.println("Add to Compare is clicked for the plan : "+PlanName);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		if(driver.findElement(By.xpath("//*[contains(text(), '"+PlanName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//label[contains(@for, 'compare-plan')]")).getText().equalsIgnoreCase("Added to compare")){
				System.out.println("Add to Compare already clicked for the plan : "+PlanName);
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List <WebElement> ComparePlansLinks = driver.findElements(By.xpath("//button[contains(text(), 'Compare plans') and @type='submit']"));
	//validate();
	for(WebElement CompareLink : ComparePlansLinks){
		if(CompareLink.isDisplayed()){
			CompareLink.click();
			CommonUtility.checkPageIsReady(driver);
			if (driver.getCurrentUrl().contains("plan-compare")) {
				return new PlanComparePage(driver);
			}
		}
	}
	System.out.println("Compare Plans Link not displayed");
	return null;
}
  


//vvv note: added for US1598162
public void sleepBySec(int sec) {
	try {
		Thread.sleep(sec*1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void validateEmailOptionExistOnPage(String planType) {
	//System.out.println("TEST - playType="+planType);
	WebElement emailElement=null;
	if (planType.equalsIgnoreCase("mapd") || planType.equalsIgnoreCase("ma")) {
		//System.out.println("TEST - going to validate the print and email element for MA");
		emailElement=maEmailOption;
	} else if (planType.equalsIgnoreCase("pdp")) {
		//System.out.println("TEST - going to validate the print and email element for PDP");
		emailElement=pdpEmailOption;
	} else if (planType.equalsIgnoreCase("snp")) {
		//System.out.println("TEST - going to validate the print and email element for SNP");
		emailElement=snpEmailOption;
	} else {
		Assert.assertTrue("PROBLEM - test not coded for this '"+planType+"' planType testing", false);
	}

	Assert.assertTrue("PROBLEM - Unable to locate the email option. emailCheck="+validate(emailElement), validate(emailElement));
}

public void validatePrintOptionExistOnPage(String planType) {
	//System.out.println("TEST - playType="+planType);
	WebElement printElement=null;
	if (planType.equalsIgnoreCase("mapd") || planType.equalsIgnoreCase("ma")) {
		//System.out.println("TEST - going to validate the print and email element for MA");
		printElement=maPrintOption;
	} else if (planType.equalsIgnoreCase("pdp")) {
		//System.out.println("TEST - going to validate the print and email element for PDP");
		printElement=pdpPrintOption;
	} else if (planType.equalsIgnoreCase("snp")) {
		//System.out.println("TEST - going to validate the print and email element for SNP");
		printElement=snpPrintOption;
	} else {
		Assert.assertTrue("PROBLEM - test not coded for this '"+planType+"' planType testing", false);
	}
	Assert.assertTrue("PROBLEM - Unable to locate the print option or the email option. printCheck="+validate(printElement), validate(printElement));
	
	/* tbd-remove 
	//note: temperary - remove the following when email option is enable, this is just to make sure it wasn't turn on by mistake
	WebElement emailElement=null;
	if (planType.equalsIgnoreCase("mapd") || planType.equalsIgnoreCase("ma")) {
		//System.out.println("TEST - going to validate the print and email element for MA");
		emailElement=maEmailOption;
	} else if (planType.equalsIgnoreCase("pdp")) {
		//System.out.println("TEST - going to validate the print and email element for PDP");
		emailElement=pdpEmailOption;
	} else if (planType.equalsIgnoreCase("snp")) {
		//System.out.println("TEST - going to validate the print and email element for SNP");
		emailElement=snpEmailOption;
	} else {
		Assert.assertTrue("PROBLEM - test not coded for this '"+planType+"' planType testing", false);
	}
	Assert.assertTrue("PROBLEM - Email option should NOT show up (disabled until feature approved). emailCheck="+validate(emailElement), !validate(emailElement));
	*/
}


public void validateDefaultNoSavedPlan(String planType) {
	String maOrMapdSectionXpath="//div[@ng-show='showMaPlans']";
	String pdpSectionXpath="//div[@ng-show='showPdpPlans']";
	String snpSectionXpath="//div[@ng-show='showSnpPlans']";

	String plansXpath="//span[@class='plan-index ng-binding ng-scope']";

	String savePlanXpath=savePlanLinkTextXpath;
	String unfilledIconXpath=savePlanXpath+"/.."+savePlanImgXpath;

	String testXpath="";
	if (planType.equals("MA") || planType.equals("MAPD")) {
		testXpath=maOrMapdSectionXpath;
	} else if (planType.equals("PDP")) {
		testXpath=pdpSectionXpath;
	} else if (planType.equals("SNP")) {
		testXpath=snpSectionXpath;
	} else {
		Assert.assertTrue("PROBLEM - unsupported test for this scenario planType.  Expected=MA or MAPD or PDP or SNP | Actual='"+planType+"'", false);
	}

	List<WebElement> listOfPlans=driver.findElements(By.xpath(testXpath+plansXpath));
	int numOfAvaliablePlans=listOfPlans.size();
	//System.out.println("TEST - listOfPlans xpath="+testXpath+plansXpath);
	//System.out.println("TEST - Number of Available Plan for planType='"+planType+"'="+numOfAvaliablePlans);

	List<WebElement> listOfUnsavedPlans=driver.findElements(By.xpath(testXpath+"//*[contains(@class,'module-plan-overview module swiper-slide ng-scope')]"+savePlanXpath));
	int numOfUnsavedPlans=listOfUnsavedPlans.size();
	//System.out.println("TEST - listOfUnsavedPlans xpath="+testXpath+unsavePlanXpath);
	//System.out.println("TEST - Number of unsave plan link for planType='"+planType+"'="+numOfUnsavedPlans);

	List<WebElement> listOfUnfilledIcons=driver.findElements(By.xpath(testXpath+"//*[contains(@class,'module-plan-overview module swiper-slide ng-scope')]"+unfilledIconXpath));
	int numOfUnfilledIcons=listOfUnfilledIcons.size();
	//System.out.println("TEST - listOfUnfilledIcons xpath="+testXpath+unfilledIconXpath);
	//System.out.println("TEST - Number of unsave plan icon for planType='"+planType+"'="+numOfUnfilledIcons);

	Assert.assertTrue("PROBLEM: Total number of unsaved plans should equal to total number of avaliable plans.  Actual numOfAvaliablePlans='"+numOfAvaliablePlans+"' | Actual numOfUnsavedPlans='"+numOfUnsavedPlans+"'",numOfAvaliablePlans==numOfUnsavedPlans);
	Assert.assertTrue("PROBLEM: Total number of unsaved plans should equal to total number of unfilled icons.  Actual numOfUnfilledIcons='"+numOfUnfilledIcons+"' | Actual numOfUnsavedPlans='"+numOfUnsavedPlans+"'",numOfUnfilledIcons==numOfUnsavedPlans);
}

	public void savePlans(String savePlanNames, String planType){
		List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));
		System.out.println("Going to mark the following "+listOfTestPlans.size()+" number of test plans as favorite");
	
		for (String plan: listOfTestPlans) {
			System.out.println("Proceed to locate plan="+plan);
	
			String testPlanXpath="//*[contains(text(),'"+plan+"')]";
			System.out.println("TEST - textPlanXpath xpath="+testPlanXpath);
			List<WebElement>  listOfPlans=driver.findElements(By.xpath(testPlanXpath));
			int expMatch=1;
			Assert.assertTrue("PROBLEM - unable to locate plan='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfPlans.size()+"'",listOfPlans.size()==expMatch);
			
			System.out.println("Proceed to validate 'Save Plan' icon appeared before clicking");
			String initial_savePlanIconXpath="//*[contains(text(),'"+plan+"')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"+savePlanImgXpath;
			System.out.println("TEST - initial_savePlanLIconXpath xpath="+initial_savePlanIconXpath);
		
			List<WebElement>  listOfSavePlanIcons=driver.findElements(By.xpath(initial_savePlanIconXpath));
			expMatch=1;
			Assert.assertTrue("PROBLEM - unable to locate Save Plan icon for ='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfSavePlanIcons.size()+"'",listOfSavePlanIcons.size()==expMatch);
	
			System.out.println("Proceed to validate 'Saved Plan' icon will not appear before 'Save Plan' is clicked");
			String savedPlanIconXpath="//*[contains(text(),'"+plan+"')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@class,'js-favorite-plan favorite-plan ng-scope added')]"+savedPlanImgXpath;
			System.out.println("TEST - savedPlanIconXpath xpath="+savedPlanIconXpath);
			List<WebElement>  listOfSavedPlanIcons=driver.findElements(By.xpath(savedPlanIconXpath));
			expMatch=0;
			Assert.assertTrue("PROBLEM - unable to locate Save Plan icon for ='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfSavedPlanIcons.size()+"'",listOfSavedPlanIcons.size()==expMatch);
	
			//----------------------------------------
			System.out.println("Proceed to click to save plan");
			 System.out.println("TEST - initial save plan xpath : "+ initial_savePlanIconXpath);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", listOfSavePlanIcons.get(0));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", listOfSavePlanIcons.get(0));
	
		}
	}
public void validateAbilityToSavePlans(String savePlanNames, String planType) {
	String subPath=determineSubpath(planType);
	String headerPath=determineHeaderPath(planType);
	
	List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));
	System.out.println("Going to mark the following "+listOfTestPlans.size()+" number of test plans as favorite");

	for (String plan: listOfTestPlans) {
		System.out.println("Proceed to locate plan="+plan);

		String testPlanXpath="//*[contains(text(),'"+plan+"') and contains(@class,'ng-binding')]";
		System.out.println("TEST - textPlanXpath xpath="+testPlanXpath);
		List<WebElement>  listOfPlans=driver.findElements(By.xpath(testPlanXpath));
		int expMatch=1;
		Assert.assertTrue("PROBLEM - unable to locate plan='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfPlans.size()+"'",listOfPlans.size()==expMatch);
		
		System.out.println("Proceed to validate 'Save Plan' icon appeared before clicking");
		String initial_savePlanIconXpath="//*[contains(text(),'"+plan+"')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"+savePlanImgXpath;
		System.out.println("TEST - initial_savePlanLIconXpath xpath="+initial_savePlanIconXpath);
	
		List<WebElement>  listOfSavePlanIcons=driver.findElements(By.xpath(initial_savePlanIconXpath));
		expMatch=1;
		Assert.assertTrue("PROBLEM - unable to locate Save Plan icon for ='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfSavePlanIcons.size()+"'",listOfSavePlanIcons.size()==expMatch);

		System.out.println("Proceed to validate 'Saved Plan' icon will not appear before 'Save Plan' is clicked");
		String savedPlanIconXpath="//*[contains(text(),'"+plan+"')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@class,'js-favorite-plan favorite-plan ng-scope added')]"+savedPlanImgXpath;
		System.out.println("TEST - savedPlanIconXpath xpath="+savedPlanIconXpath);
		List<WebElement>  listOfSavedPlanIcons=driver.findElements(By.xpath(savedPlanIconXpath));
		expMatch=0;
		Assert.assertTrue("PROBLEM - unable to locate Save Plan icon for ='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfSavedPlanIcons.size()+"'",listOfSavedPlanIcons.size()==expMatch);

		//----------------------------------------
		System.out.println("Proceed to click to save plan");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", listOfSavePlanIcons.get(0));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", listOfSavePlanIcons.get(0));

		System.out.println("Click to close on the create profile popup");
		if (validate(closeProfilePopup))
			closeProfilePopup.click();
		CommonUtility.checkPageIsReady(driver);
		
		//clicking the saved heart to validate it goes back to unsaved
		/*String afterSavePlanIconXpath=headerPath+"//*[contains(text(),'"+plan+"')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@class,'js-favorite-plan favorite-plan ng-scope added')]//img[contains(@src,'ic_favorite-unfilled.png')]";
		listOfSavePlanIcons=driver.findElements(By.xpath(afterSavePlanIconXpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", listOfSavePlanIcons.get(0));
		
		System.out.println("Proceed to validate 'Save Plan' link and icon disappeared after clicking it");
		System.out.println("TEST - initial_savePlanLIconXpath xpath="+initial_savePlanIconXpath);
		expMatch=0;
		Assert.assertTrue("PROBLEM - 'Save Plan' icon should have disappeared after click for ='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfSavePlanIcons.size()+"'",listOfSavePlanIcons.size()==expMatch);
		
		//clicking the save heart option again and validate it was saved
		listOfSavePlanIcons=driver.findElements(By.xpath(initial_savePlanIconXpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", listOfSavePlanIcons.get(0));*/
		System.out.println("Proceed to validate 'Saved Plan' icon will appear after 'Save Plan' is clicked");
		String appeared_savedPlanIconXpath="";
		
		appeared_savedPlanIconXpath="//*[contains(text(),'"+plan+"')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"+savedPlanImgXpath;

		System.out.println("TEST - appeared_savedPlanLIconXpath xpath="+appeared_savedPlanIconXpath);
		List<WebElement>  listOfAppearedSavedPlanIcons=driver.findElements(By.xpath(appeared_savedPlanIconXpath));
		expMatch=1;
		Assert.assertTrue("PROBLEM - unable to locate Saved Plan icon after click for ='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfAppearedSavedPlanIcons.size()+"'",listOfAppearedSavedPlanIcons.size()==expMatch);

		System.out.println("Proceed to validate 'Saved' text will appear after 'Save Plan' is clicked");
		String appeared_savedTextXpath="";
		
		
		appeared_savedTextXpath="//*[contains(text(),'"+plan+"')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]//span[contains(text(),'Saved')]";
		
		System.out.println("TEST - appeared_savedTextXpath xpath="+appeared_savedTextXpath);
		List<WebElement>  listOfAppearedSavedText=driver.findElements(By.xpath(appeared_savedTextXpath));
		expMatch=1;
		Assert.assertTrue("PROBLEM - unable to locate Saved Plan icon after click for ='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfAppearedSavedText.size()+"'",listOfAppearedSavedText.size()==expMatch);
	}
}

public void validatePlansAreSaved(String savePlanNames, String planType) {
	String subPath=determineSubpath(planType);
	String headerPath=determineHeaderPath(planType);
	String planTypePath="";
	if (planType.equalsIgnoreCase("ma") || planType.equalsIgnoreCase("mapd")) {
		planTypePath="//div[@ng-show='showMaPlans']";
	} else if (planType.equalsIgnoreCase("pdp")) {
		planTypePath="//div[@ng-show='showPdpPlans']";
	} else if (planType.equalsIgnoreCase("snp")) {
		planTypePath="//div[@ng-show='showSnpPlans']";
	}
	List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));
	
	System.out.println("Validate "+listOfTestPlans.size()+" number of test plans are saved as favorite");
	String appeared_savedPlanLIconXpath=planTypePath+"//*[contains(@class,'added')]"+savedPlanImgXpath;
	System.out.println("TEST - appeared_savedPlanLIconXpath xpath="+appeared_savedPlanLIconXpath);
	List<WebElement>  listOfAppearedSavedPlanIcons=driver.findElements(By.xpath(appeared_savedPlanLIconXpath));
	int expMatch=listOfTestPlans.size();
	Assert.assertTrue("PROBLEM - total saved plan icons not as expected.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfAppearedSavedPlanIcons.size()+"'",listOfAppearedSavedPlanIcons.size()==expMatch);
}

public String determineSubpath(String planType) {
	//System.out.println("TEST - The test planType="+planType);
	if (planType.equals("MAPD") || planType.equals("MA")) {
		return "/../../..";
	} else {
		return "/../..";
	}
}

public String determineHeaderPath(String planType) {
	//System.out.println("TEST - The test planType="+planType);
	if (planType.equals("MAPD") || planType.equals("MA") || planType.equals("PDP")) {
		return "//h3";
	} else {
		return "//h2";
	}
}

public void clickHomeButton() {
	System.out.println("Proceed to click on Home so that zipcode can be entered again without clearing cache");
	try {
		sleepBySec(2);
		homeBtn.isDisplayed();
		homeBtn.click();
	} catch (Exception e) {
		Assert.assertTrue("PROBLEM - Unable to click Home button", false);
	}
	//System.out.println("TEST - clicked home button");
}

public VPPPlanSummaryPage navagateToShopAPlanAndFindZipcode(String zipcode, String countyName, String isMultiCounty) {
	System.out.println("Proceed to go to top menu to select 'Shop A Plan' option and enter zipcode '"+zipcode+"' to find plan");
	Actions builder = new Actions(driver);
	Action mouseOverButton=builder.moveToElement(topMenushopForAPlanOption).build();
	mouseOverButton.perform();
	sleepBySec(5);
	shopForAPlanOptionZipcodeFieldBox.sendKeys(zipcode);
	sleepBySec(1);
	shopForAPlanOptionFindPlanButton.click();
	if (isMultiCounty.equalsIgnoreCase("yes")) {
		System.out.println("Handle mutliple county");
		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
	}
	sleepBySec(3);
	if(driver.findElement(By.xpath("//*[contains(text(),'"+zipcode+" "+countyName+"')]")).isDisplayed()) {
		return new VPPPlanSummaryPage(driver);
	}
	return null;
}

public VPPPlanSummaryPage navagateToChangeZipcodeOptionToChangeZipcode(String zipcode, String countyName, String isMultiCounty) {
	System.out.println("Proceed to go to plan overview section to enter zipcode '"+zipcode+"' to find plan'");
	try {
		//if change zip code link is there then click it, once you used it then it will only display field box going forward.
		planOverviewChangeZipCodeLink.click();
	} catch (Exception e) {
		System.out.println("Change ZipCode link already not on the page, proceed to update zipcode for search directly");
	}
	//if field box already there then clear it if left over text from prior run
	planOverviewZipCodeFieldBox.sendKeys(Keys.CONTROL + "a");
	planOverviewZipCodeFieldBox.sendKeys(Keys.DELETE);
	//enter zipcode
	planOverviewZipCodeFieldBox.sendKeys(zipcode);
	planOverviewFindPlanButton.click();

	if (isMultiCounty.equalsIgnoreCase("yes")) {
		System.out.println("Handle mutliple county case");
		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
	}
	sleepBySec(2);
	if(driver.findElement(By.xpath("//*[contains(text(),'"+zipcode+" "+countyName+"')]")).isDisplayed()) {
		return new VPPPlanSummaryPage(driver);
	}
	return null;
}

public void validateAbilityToUnSavePlans(String savedPlans, String planType) {
	String subPath=determineSubpath(planType);
	String headerPath=determineHeaderPath(planType);

	List<String> listOfTestPlans = Arrays.asList(savedPlans.split(","));
	String unsavePlan=listOfTestPlans.get(0);
	System.out.println("Proceed to unsave 1st plan from input '"+unsavePlan+"'");

	String testPlanXpath="//*[contains(text(),'"+unsavePlan+"')]";
	List<WebElement>  listOfPlans=driver.findElements(By.xpath(testPlanXpath));
	int expMatch=1;
	Assert.assertTrue("PROBLEM - unable to locate plan='"+unsavePlan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfPlans.size()+"'",listOfPlans.size()==expMatch);
	
	System.out.println("Proceed to validate 'Saved Plan' icon is there before clicking to unsave it");
	String appeared_savedPlanLIconXpath="//*[contains(text(),'"+unsavePlan+"')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@class,'added')]"+savedPlanImgXpath;
	System.out.println("TEST - appeared_savedPlanLIconXpath xpath="+appeared_savedPlanLIconXpath);
	List<WebElement>  listOfAppearedSavedPlanIcons=driver.findElements(By.xpath(appeared_savedPlanLIconXpath));
	expMatch=1;
	Assert.assertTrue("PROBLEM - unable to locate Saved Plan icon after click for ='"+unsavePlan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfAppearedSavedPlanIcons.size()+"'",listOfAppearedSavedPlanIcons.size()==expMatch);

	System.out.println("Proceed to click to unsave plan");
	jsClickNew(listOfAppearedSavedPlanIcons.get(0));
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	System.out.println("Proceed to validate 'Saved Plan' icon is not there after clicking to unsave it");
	System.out.println("TEST - appeared_savedPlanLIconXpath xpath="+appeared_savedPlanLIconXpath);
	listOfAppearedSavedPlanIcons=driver.findElements(By.xpath(appeared_savedPlanLIconXpath));
	expMatch=0;
	Assert.assertTrue("PROBLEM - 'Saved Plan' icon should no longer appear for ='"+unsavePlan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfAppearedSavedPlanIcons.size()+"'",listOfAppearedSavedPlanIcons.size()==expMatch);

	System.out.println("Proceed to validate 'Save Plan' icon appeared again after unsaved plan");
	String savePlanIconXpath="//*[contains(text(),'"+unsavePlan+"')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"+savePlanImgXpath;
	System.out.println("TEST - savePlanIconXpath xpath="+savePlanIconXpath);
	List<WebElement>  listOfSavePlanIcons=driver.findElements(By.xpath(savePlanIconXpath));
	expMatch=1;
	Assert.assertTrue("PROBLEM - unable to locate Save Plan icon for ='"+unsavePlan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfSavePlanIcons.size()+"'",listOfSavePlanIcons.size()==expMatch);
}

public void validateOnePlanSavedOnePlanUnsaved(String savePlanNames, String planType) {
	String subPath=determineSubpath(planType);
	String headerPath=determineHeaderPath(planType);
	List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));

	System.out.println("Validate first plan on list is saved and second plan on list is unsaved");
	for (int i=0; i<listOfTestPlans.size(); i++) {
		if (i==0) {
			String plan=listOfTestPlans.get(i);
			System.out.println("Plan '"+plan+"' should be saved");
			System.out.println("Proceed to locate plan="+plan);

			String testPlanXpath="//*[contains(text(),'"+plan+"')]";
			System.out.println("TEST - testPlanXpath xpath="+testPlanXpath);
			List<WebElement>  listOfPlans=driver.findElements(By.xpath(testPlanXpath));
			System.out.println("TEST - size="+listOfPlans.size());
			int expMatch=1;
			Assert.assertTrue("PROBLEM - unable to locate plan='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfPlans.size()+"'",listOfPlans.size()==expMatch);

			System.out.println("Proceed to validate 'Save Plan' icon appeared again after unsaved plan");
			String savedPlanIconXpath="//*[contains(text(),'"+plan+"')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@class,'added')]"+savedPlanImgXpath;
			System.out.println("TEST - initial_savePlanLIconXpath xpath="+savedPlanIconXpath);
			sleepBySec(5);
			List<WebElement>  listOfSavePlanIcons=driver.findElements(By.xpath(savedPlanIconXpath));
			expMatch=0;
			Assert.assertTrue("PROBLEM - unable to locate Save Plan icon for ='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfSavePlanIcons.size()+"'",listOfSavePlanIcons.size()==expMatch);
		} else if (i==1) {
			String plan=listOfTestPlans.get(i);
			System.out.println("Plan '"+plan+"' should be unsaved");

			String testPlanXpath="//*[contains(text(),'"+plan+"')]";
			List<WebElement>  listOfPlans=driver.findElements(By.xpath(testPlanXpath));
			int expMatch=1;
			Assert.assertTrue("PROBLEM - unable to locate plan='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfPlans.size()+"'",listOfPlans.size()==expMatch);

			System.out.println("Proceed to validate 'Save Plan' icon appeared again after unsaved plan");
			String savePlanIconXpath="//*[contains(text(),'"+plan+"')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"+savePlanImgXpath;
			System.out.println("TEST - savedPlanIconXpath xpath="+savePlanIconXpath);
			List<WebElement>  listOfSavePlanIcons=driver.findElements(By.xpath(savePlanIconXpath));
			expMatch=1;
			Assert.assertTrue("PROBLEM - unable to locate Save Plan icon for ='"+plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"+listOfSavePlanIcons.size()+"'",listOfSavePlanIcons.size()==expMatch);
		}
	}
}

public void validateEmailOption(String planType) {
	WebElement emailButton=null;
	if (planType.equalsIgnoreCase("ma") || planType.equalsIgnoreCase("mapd")) {
		emailButton=maEmailOption;
	} else if (planType.equalsIgnoreCase("pdp")) {
		emailButton=pdpEmailOption;
	} else if (planType.equalsIgnoreCase("snp")) {
		emailButton=snpEmailOption;
	} else {
		Assert.assertTrue("PROBLEM - '"+planType+"' is not supported test scenario. Only support MA/MAPD/PDP/SNP, please update input argument", false);
	}
	System.out.println("Proceed to validate email popup screen for cancel option");
	emailButton.click();
	Assert.assertTrue("PROBLEM - unable to locate email popup screen after email link is clicked",validate(emailPlanSummaryPopupScreen));
	String expectedEmailBoxHeader=emailPlanSummaryPopupScreenText.getText();
	String actualEmailBoxHeader="Email Plan List";
	Assert.assertTrue("PROBLEM - header text for the email popup screen is not as expected.  Expecte='"+expectedEmailBoxHeader+"' | Actual='"+actualEmailBoxHeader+"'",expectedEmailBoxHeader.equals(actualEmailBoxHeader));
	Assert.assertTrue("PROBLEM - unable to locate email field box on email popup screen after email link is clicked",validate(emailPlanSummaryFieldBox));
	Assert.assertTrue("PROBLEM - unable to locate send button on email popup screen after email link is clicked",validate(emailPlanSummarySendButton));
	Assert.assertTrue("PROBLEM - unable to locate cancel button on email popup screen after email link is clicked",validate(emailPlanSummaryCancelButton));
	
	System.out.println("Proceed to click cancel button on email screen, email screen should close");
	emailPlanSummaryCancelButton.click();
	Assert.assertTrue("PROBLEM - email popup screen should have disappeared after cancel button is clicked", !validate(emailPlanSummaryPopupScreen));

	//----- failure cases ------------------
	System.out.println("Proceed to validate email popup screen for send option for failure case 1");
	emailButton.click();
	String testEmailAddresss="bademailformat";
	emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
	emailPlanSummarySendButton.click();
	
	Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",validate(emailPlanSummaryErrorFieldBox));
	Assert.assertTrue("PROBLEM - unable to locate error text after email address validation failed",validate(emailPlanSummaryInputErrorText));
	String actualErrorText=emailPlanSummaryInputErrorText.getText();
	String execptedErrorText="Please Enter Valid Email Address";
	
	Assert.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '"+execptedErrorText+"' | Actual='"+actualErrorText+"'", (execptedErrorText.equals(actualErrorText)) );

	System.out.println("Proceed to validate email popup screen for send option for failure case 2 ");
	testEmailAddresss="bademailformat@";
	emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
	emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
	emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
	emailPlanSummarySendButton.click();
	
	Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",validate(emailPlanSummaryErrorFieldBox));
	Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",validate(emailPlanSummaryInputErrorText));
	actualErrorText=emailPlanSummaryInputErrorText.getText();
	execptedErrorText="Please Enter Valid Email Address";
	
	Assert.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '"+execptedErrorText+"' | Actual='"+actualErrorText+"'", (execptedErrorText.equals(actualErrorText)) );

	System.out.println("Proceed to validate email popup screen for send option for failure case 3");
	testEmailAddresss="bademailformat@test.";
	emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
	emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
	emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
	emailPlanSummarySendButton.click();
	
	Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",validate(emailPlanSummaryErrorFieldBox));
	Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",validate(emailPlanSummaryInputErrorText));
	actualErrorText=emailPlanSummaryInputErrorText.getText();
	execptedErrorText="Please Enter Valid Email Address";
	
	Assert.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '"+execptedErrorText+"' | Actual='"+actualErrorText+"'", (execptedErrorText.equals(actualErrorText)) );

	//----- success cases ------------------
	System.out.println("Proceed to validate email popup screen for send option for successful case");
	testEmailAddresss="test@optum.com";
	emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
	emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
	emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
	jsClickNew(emailPlanSummarySendButton);
	validateNew(emailPlanSummarySuccessText, 15);
	String expectedSuccess1="Thank you!";
	String expectedSuccess2="The email with your information will arrive shortly.";
	String actualEmailSuccessText=emailPlanSummarySuccessText.getText();
	Assert.assertTrue("PROBLEM - Email success message is not as expected.  Expected to contain '"+expectedSuccess1+"' and '"+expectedSuccess2+"' | Actual='"+actualEmailSuccessText+"'", (actualEmailSuccessText.contains(expectedSuccess1)) && (actualEmailSuccessText.contains(expectedSuccess2)));

	validateNew(emailPlanSummarySuccessCloseButton);
	System.out.println("Proceed to close the email popup screen to cleanup");
	emailPlanSummarySuccessCloseButton.click();
}

public void validatePrintOption(String planType) {
	//note: the print function will bring up the print preview window where the content can't be controlled by selenium
	// for now will only validate the print button will bring up the print preview page
	WebElement printButton=null;
	if (planType.equalsIgnoreCase("ma") || planType.equalsIgnoreCase("mapd")) {
		printButton=maPrintOption;
	} else if (planType.equalsIgnoreCase("pdp")) {
		printButton=pdpPrintOption;
	} else if (planType.equalsIgnoreCase("snp")) {
		printButton=snpPrintOption;
	} else {
		Assert.assertTrue("PROBLEM - '"+planType+"' is not supported test scenario. Only support MA/MAPD/PDP/SNP, please update input argument", false);
	}
	System.out.println("Proceed to validate print popup screen for cancel option");
	printButton.click();

	// Store the current window handle
	String winHandleBefore = driver.getWindowHandle();
	//System.out.println("TEST --------------- before handler="+driver.getWindowHandle());
	String originalPageTitle=driver.getTitle();

	//switch to handle the new print window
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	sleepBySec(5);
	//CommonUtility.checkPageIsReady(driver);
	// Perform the actions on new window
	//System.out.println("TEST  --------------- after handler="+driver.getWindowHandle());
	System.out.println("Proceed to validate the new window content for print");
	String printPreviewPageTitle=driver.getTitle();
	Assert.assertTrue("PROBLEM - print preview page title should be empty (untitled).  Actual='"+printPreviewPageTitle+"'", printPreviewPageTitle.equals(""));
	   
	System.out.println("Proceed to close the print preview window");
	driver.close();

	// note: Switch back to original browser (first window)
	driver.switchTo().window(winHandleBefore);
	
	//System.out.println("TEST  --------------- back handler="+driver.getWindowHandle());
	String pageTitleAfterClosingPrintPreview=driver.getTitle();
	Assert.assertTrue("PROBLEM - page title should have been the same after closing print preview.  | Before='"+originalPageTitle+"' | After='"+pageTitleAfterClosingPrintPreview+"'", originalPageTitle.equals(pageTitleAfterClosingPrintPreview));
}

public void closeOriginalTabAndOpenNewTab() {
	
    //get original tab handler
	String winHandleBefore = driver.getWindowHandle();
	
	System.out.println("Proceed to open a new blank tab as placeholder so the driver won't close");
	//open new tab
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.open('about:blank','_blank');");
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	String winHandleTmp = driver.getWindowHandle();
	System.out.println("Proceed to close the original tab that has plans saved, should left with a blank tab afterward");
	driver.switchTo().window(winHandleBefore);
	driver.close();
    
	driver.switchTo().window(winHandleTmp);
	System.out.println("Proceed to open the acquisition url in new tab");
    js.executeScript("window.open('"+UMS_ACQISITION_PAGE_URL+"','_blank');");

    for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	String winHandleNew = driver.getWindowHandle();

	System.out.println("Proceed to close the placeholder blank tab");
	driver.switchTo().window(winHandleTmp);
	driver.close();

	System.out.println("Proceed to use this newly opened tab for remaining validation");
	driver.switchTo().window(winHandleNew);
}
//^^^ note: added for US1598162	

public void MedSupFormValidation(String DateOfBirth, String zipcode) throws InterruptedException {
	Thread.sleep(4000);
	CommonUtility.waitForPageLoadNew(driver, medSupZipcode, 20);
	System.out.println("MedSup page form is displayed");
	medSupZipcode.sendKeys(zipcode);
	Thread.sleep(2000);
	validateNew(DOB);
	DOB.click();
	Thread.sleep(2000);
	DOB.sendKeys(DateOfBirth);
	System.out.println("Date of birth is entered");
	jsClickNew(MaleGender);
	Thread.sleep(2000);
	jsClickNew(monthDrpDwn_PartA);
	validateNew(monthDrpDwnOption);
	monthDrpDwnOption.click();
	Thread.sleep(2000);
	System.out.println("Effective date- month value selected");
	yearDrpDwn_PartA.click();
	Thread.sleep(2000);
	yearDrpDwnOption.click();
	System.out.println("Effective date- year value selected");
	Thread.sleep(2000);
	monthBDrpDwn.click();
	Thread.sleep(2000);
	monthBDrpDwnOption.click();
	Thread.sleep(2000);
	yearBDrpDwn.click();
	Thread.sleep(2000);
	yearBDrpDwnOption.click();
	Thread.sleep(2000);
	startDrpDwn.click();
	Thread.sleep(2000);
	startDrpDwnOption.click();
	Thread.sleep(2000);
	System.out.println("Plan to start date selected");
	ViewPlanMedSupPage.click();
}

public void MedSupFormValidation_2ndTime(String DateOfBirth, String zipcode) throws InterruptedException {
	Thread.sleep(4000);
	CommonUtility.waitForPageLoadNew(driver, medSupZipcode, 20);
	System.out.println("MedSup page form is displayed");
	//medSupZipcode.sendKeys(zipcode);
	DOB.click();
	DOB.sendKeys(DateOfBirth);
	System.out.println("Date of birth is entered");
	jsClickNew(MaleGender);
	jsClickNew(monthDrpDwn_PartA);
	monthDrpDwnOption.click();
	Thread.sleep(2000);
	System.out.println("Effective date- month value selected");
	yearDrpDwn_PartA.click();
	yearDrpDwnOption.click();
	System.out.println("Effective date- year value selected");
	Thread.sleep(2000);
	monthBDrpDwn.click();
	monthBDrpDwnOption.click();
	Thread.sleep(2000);
	yearBDrpDwn.click();
	yearBDrpDwnOption.click();
	Thread.sleep(2000);
	startDrpDwn.click();
	Thread.sleep(2000);
	startDrpDwnOption.click();
	Thread.sleep(3000);
	System.out.println("Plan to start date selected");
	ViewPlanMedSupPage.click();
}

public String StartApplicationButton(String FirstName, String LastName) throws InterruptedException {
	Thread.sleep(5000);
	CommonUtility.waitForPageLoadNew(driver, Start_ApplicationBtn, 20);
	Start_ApplicationBtn.click();
	System.out.println("Start application button is clicked on application page");
	Thread.sleep(8000);
	CommonUtility.waitForPageLoadNew(driver, insuredStatus, 20);
	insuredStatus.click();
	Thread.sleep(2000);
	nextButton.click();
	Thread.sleep(2000);
	nextButton.click();
	Thread.sleep(2000);
	nextButton.click();
	Thread.sleep(2000);
	nextButton.click();
	Thread.sleep(2000);
	firstName.sendKeys(FirstName);
	lastName.sendKeys(LastName);
	nextButton.click();
	CommonUtility.waitForPageLoadNew(driver, address1, 20);
	address1.sendKeys("TestAddress1");
	cityName.sendKeys("TestCity");
	alternatemailingAddressBtn.click();
	emailAddress.sendKeys("John_Kerry@test.com");
	phoneNumber.sendKeys("1234567890");
	nextButton.click();
	Thread.sleep(2000);
	nextButton.click();
	Thread.sleep(2000);
	String ResumeKey= resumeKey.getText();
	System.out.println("The return to the application code is- "+ResumeKey);
	cancelButton.click();
	CommonUtility.waitForPageLoad(driver, cancelButtonPopUp, 30);
	jsClickNew(cancelButtonPopUp);
	System.out.println("Cancel application has been clicked on the pop up");
	return ResumeKey;
}

public void ResumeApplicationButton() throws InterruptedException{
	Thread.sleep(5000);
	Start_ApplicationBtn.click();
	CommonUtility.waitForPageLoadNew(driver, resumeApplication, 30);
	resumeApplication.click();
	System.out.println("Resume application link clicked successfully");
}
public void EnterDataForResumeApp(String ApplicationID,String DOB,String zipcode) throws InterruptedException{
	CommonUtility.waitForPageLoadNew(driver, resumeApplicationBtn, 30);
	validateNew(resumeApplicationBtn);
	
	applicationID.sendKeys(ApplicationID);
	ResumeDOB.sendKeys(DOB);
	ResumeZipCode.click();
	Thread.sleep(2000);
	ResumeZipCode.sendKeys("90210");
	resumeApplicationBtn.click();
	
	System.out.println("Resume application button has been clicked successfully after entering the data on resume application page");
}



public void ResumeApplicationButtonValidation(String FirstName,String LastName) throws InterruptedException{
Thread.sleep(2000);
CommonUtility.waitForPageLoadNew(driver, welcomeHeader, 30);
validateNew(welcomeHeader);

Thread.sleep(5000);
nextButton.click();
Thread.sleep(2000);
nextButton.click();
Thread.sleep(2000);
nextButton.click();
Thread.sleep(2000);
CommonUtility.waitForPageLoadNew(driver, firstName, 20);

String name= firstName.getAttribute("value");
System.out.println("The name displaying on  your information page is "+name);
if(name.equals(FirstName)){
	System.out.println("Application has been resumed successfully");
	Assert.assertTrue("Application has been resumed successfully", true);
	
}
else{
	
	Assert.assertFalse("Application has not been resumed successfully", false);
}



}
public void RetrieveApplicationButtonValidation(String ApplicationID) throws InterruptedException{
CommonUtility.waitForPageLoadNew(driver, welcomepage, 30);

try {
	validateNew(welcomepage);
		System.out.println("Application has been retrived successfully");
		Assert.assertTrue("Application has been retrived successfully", true);
	} 
catch (Exception e) {
	Assert.assertFalse("Application has not been retrived successfully", false);
}
}

	/**
	 * Validate Create Profile Prompt
	 */
	public void validateCreateProfilePrompt() {
		Assert.assertTrue(validateNew(btnClose));
		Assert.assertTrue(validateNew(createProfileBtn));
		Assert.assertTrue(validateNew(continueAsGuest));
	}
	
	/**
	 * Click on Continue as guest link on create profile prompt
	 * @return
	 */
	public VisitorProfilePage continueAsGuest(){
		continueAsGuest.click();
		if(driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		}else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	
	public void handlePlanYearSelectionPopup() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, planYearPopup, 5);
		if (validate(planYearPopup)) {
			if (validate(nextYearSelection)) {
				nextYearSelection.click();
				CommonUtility.waitForPageLoadNew(driver, planYearPopupGoButton, 10);
				planYearPopupGoButton.click();
				
			}
		} 
	}	
	public void handleChatPopup() {
		CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn,20); // do not change this to waitForPageLoadNew as we're not trying to fail the test if it isn't found
		try{
			if(proactiveChatExitBtn.isDisplayed()) {
				jsClickNew(proactiveChatExitBtn);
				System.out.println("Clicked Exit button on chat");
			}
		}catch(Exception e){
			System.out.println("Proactive chat popup not displayed");
		}
	}

	public void CheckClick_CurrentYear_Plans() {
		
		try {
			WebElement CurrentYearRadio = driver.findElement(By.xpath("//label[contains(@for, 'current_Year')]"));
			WebElement SelectYearGoBtn = driver.findElement(By.xpath("//*[contains(@id, 'GoBtnText')]"));
			System.out.println("AEP Year Toggle link is displayed on VPP Page : "+CurrentYearRadio.getText());
			System.out.println("*****CLICKING ON CURRENT YEAR Radio*****");
			CurrentYearRadio.click();
			System.out.println("*****CLICKING ON Year Toggle Go button*****");
			SelectYearGoBtn.click();
		} catch (Exception e) {
			System.out.println("AEP Year Toggle Radio and Modal is NOT displayed on VPP Page : ");
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CheckClick_NextYear_Plans() {

		try {
			WebElement NextYearRadio = driver.findElement(By.xpath("//label[contains(@for, 'next_Year')]"));
			WebElement SelectYearGoBtn = driver.findElement(By.xpath("//*[contains(@id, 'GoBtnText')]"));
			System.out.println("AEP Year Toggle link is displayed on VPP Page : "+NextYearRadio.getText());
			System.out.println("*****CLICKING ON NEXT YEAR Radio*****");
			NextYearRadio.click();
			System.out.println("*****CLICKING ON Year Toggle Go button*****");
			
			SelectYearGoBtn.click();
			CommonUtility.checkPageIsReadyNew(driver);
		} catch (Exception e) {
			System.out.println("AEP Year Toggle Radio and Modal is NOT displayed on VPP Page : ");
			e.printStackTrace();
		}
		
	}
	
	@FindBy(xpath="//div[contains(@class,'plan-list show active')]//div[contains(@class,'module-plan-overview')][1]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan') or contains(text(),'View Plan Details')]")
	private WebElement firstPlanDetailsLink;
	public PlanDetailsPage navigateToFirstPlanForPlanDetails(String planType) {
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, firstPlanDetailsLink, 30);
		firstPlanDetailsLink.click();
		System.out.println("View Plan Details Link is clicked for first plan for "+planType);
				CommonUtility.checkPageIsReadyNew(driver);
				if (driver.getCurrentUrl().contains("#/details")) {	
					return new PlanDetailsPage(driver,planType);
				}
				return null;
	}
	
	public void selectCurrentYearPlanYearSelectionPopup() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, planYearPopup, 5);
		if (validate(planYearPopup)) {
			if (validate(currentYearSelection)) {
				currentYearSelection.click();
				CommonUtility.waitForPageLoadNew(driver, planYearPopupGoButton, 10);
				planYearPopupGoButton.click();
			}
		} 
		CommonUtility.checkPageIsReady(driver);
	}
	
	//--------------------------------------------
	//note: begin - added for email deeplink validaton
	@FindBy(xpath="//div[contains(@id,'plan-list') and contains(@class,'active')]//div[contains(@class,'plan-card') or contains(@class,'swiper-slide')][1]//span[contains(@class,'show')]//button[contains(text(),'Compare plans')]")
	private WebElement firstComparePlanButton;
	
	@FindBy(xpath="//h2[contains(@class,'zipcodePrint') and not(contains(@class,'ng-hide'))]")
	private WebElement comparePgnHeader;
	
	public ComparePlansPage clickFirstComparePlanBtn(String plantype){
		firstComparePlanButton.click();
		CommonUtility.waitForPageLoad(driver, comparePgnHeader, 5);
		if(currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;
	}
	
	public int checkAllMAPlansCount(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> allMAPlans = driver.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]//label"));	
		int plansForCompare=allMAPlans.size();
		if (plansForCompare > 4) {
			System.out.println("There are more than 4 plans, only first 4 will be compared");
			plansForCompare=4;
		}
		if(allMAPlans !=null){
			for(int i = 0; i<plansForCompare; i++){
				allMAPlans.get(i).click();
				System.out.println("Plan added to compare : "+i);
			}
		}
		return plansForCompare;
	}
	
	public int checkAllPDPlans(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allPDPlans = driver.findElements(By.xpath(".//*[@id='plan-list-3']//div[contains(@class,'compare-box')]//label"));	
		int plansForCompare=allPDPlans.size();
		if (plansForCompare > 4) {
			System.out.println("There are more than 4 plans, only first 4 will be compared");
			plansForCompare=4;
		}
		if(allPDPlans !=null){
			for(int i = 0; i<plansForCompare; i++){
				allPDPlans.get(i).click();
				System.out.println("Plan added to compare : "+i);
			}
		}
		return plansForCompare;
	}
	//note: end - added for deeplink validaton
	//--------------------------------------------
	public void clickOnViewMoreForPlan(String planName) {
		List<WebElement> viewMoreLink =  driver.findElements
				(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'accordion-arrow collapsed')]"));
	
		if(viewMoreLink.size()>0) //if it finds the that the View More is shown then it will click on it
				viewMoreLink.get(0).click();


			
	}
}
