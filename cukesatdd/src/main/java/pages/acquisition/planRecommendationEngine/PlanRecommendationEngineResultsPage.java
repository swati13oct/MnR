package pages.acquisition.planRecommendationEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.acquisition.planRecommendationEngine.PlanRecommendationEngineStepDefinition;
import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import pages.acquisition.commonpages.GlobalWebElements;
import pages.acquisition.commonpages.VPPPlanSummaryPage;

public class PlanRecommendationEngineResultsPage extends GlobalWebElements {

	public PlanRecommendationEngineResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}
	
	String flow;
	ArrayList<String> DrugsInPRE;
	public ArrayList<String> DocInPRE;
	ArrayList<String> DrugsInDCE;
	ArrayList<String> DrugsInVPP;
	ArrayList<String> DrugsList = new ArrayList<String>();
	ArrayList<String> ModelDrugsList = new ArrayList<String>();
	ArrayList<String> werallyResults = new ArrayList<String>();
	ArrayList<String> vppResults = new ArrayList<String>();		
	ArrayList<String> vppProviderResults = new ArrayList<String>();
	ArrayList<String> confirmationResults = new ArrayList<String>();
	ArrayList<String> confirmationResults1 = new ArrayList<String>();
	ArrayList<String> confirmationProviderResults = new ArrayList<String>();
	public WebElement drugCoveredeVPP;
	PlanRecommendationEngineDrugsPage drug = new PlanRecommendationEngineDrugsPage(driver);
	PlanRecommendationEngineEditResponsePage editRes = new PlanRecommendationEngineEditResponsePage(driver);
	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);
	Actions actions = new Actions(driver);
	PlanRecommendationEngineNewResultsPage planSelectorNewResultspage =  new PlanRecommendationEngineNewResultsPage(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

// Results loading page Elements

	@FindBy(css = "#loadingText")
	private WebElement resultsloadingTitle;

	@FindBy(css = ".loading-container .container>div>div>div:nth-of-type(2)>img")
	private WebElement svgAnimation;

	@FindBy(css = "div>img[alt*='Loading Plan Recommendations']")
	private WebElement loadingImage;

//Result Page Elements
	String Browsername = MRScenario.browsername;
	
	@FindBy(css = "a[dtmname*='Shop For a Plan']")
	private WebElement headerNavigationBarShopForaPlanTab;
	
	@FindBy(css = "#uhc-footer div[class*='d-none d-lg-block'] a[href*='drug-cost-estimator']")
    private WebElement headerDrugcostLink;
	
	@FindBy(linkText = "Provider Search")
    private WebElement headerProvidersearchLink;
	
	@FindBy(css = "#uhc-footer div[class*='d-none d-lg-block'] a[href*='plan-recommendation-engine']")
    private WebElement headerGetaPlanRecommendationLink;
	
	@FindBy(css = "#selectCounty p>a")
    private List<WebElement> selectMultiZip;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview div[class*='new-plan-compare-box']")
    private List<WebElement> MAPlansCompareBox;
   
    @FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview div[class*='new-compare-box-msg'] button")
    private List<WebElement> MAPlansCompareButton;
   
    @FindBy(css = "#compare-table div[class*='flex'][class*='scope']>div[class*='flex']>div")
    private List<WebElement> planNamesOnlyComparepage;
	
	@FindBy(css = "div[class*='resultsPre'] h1")
	private WebElement planZipInfo;
	
	@FindBy(css = ".returnSection span#viewMorePlans")
	private WebElement pagenoLabel;
	
	@FindBy(css = ".paginationSection button[class*='view-plans-next']")
	private WebElement pageNextButton;
	
	@FindBy(css = "div[class*='overview-main'] h2")
	private WebElement planZipInfoinVPP;
	
	@FindBy(css = "body>div#overlay")
	private WebElement planLoaderscreen;
	
	@FindBy(css = "span.title small")
	private WebElement planname;

	@FindBy(css = ".plan-overview-wrapper div.plan-recommendation-summary")
	private WebElement planBasedInfo;

	@FindBy(css = "div[data-rel='#plan-list-1']")
	private WebElement MAPlanInfo;
	
	@FindBy(css = "a#change-location")
	private WebElement changeZIPVPP;

	@FindBy(css = "div[data-rel='#plan-list-1'] span.ng-binding")
	private WebElement MAPlanCount;
	
	@FindBy(css = "div[data-rel='#plan-list-1'] a")
	private WebElement MAViewPlansLink;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) a.add-drug")
	private WebElement enterDrugsInfoMA1stPlan;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) .edit-drugs a")
	private WebElement drugSummarylinkMA1stPlan;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview div.plan-name-div")
	private List<WebElement> MAPlansId;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) a.add-provider")
	private WebElement enterProvidersInfoMA1stPlan;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) a[id*='drug-list-title']")
	private WebElement drugsInfoMA1stPlan;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) div[id*='DrugName']")
	private List<WebElement> drugsListMA1stPlan;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) a[id*='provider-title']")
	private WebElement providersInfoMA1stPlan;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) div[id*='ProviderName'] span:nth-child(1)")
	private List<WebElement> providersListMA1stPlan;

	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1)")
	private WebElement MA1stPlan;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview h3")
	private List<WebElement> MAPlansName;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview")
	private List<WebElement> MAPlansNames;

	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) h3")
	private WebElement MA1stPlanName;

	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) .enroll-details>a:nth-of-type(2)")
	private WebElement MA1stPlanEnroll;
	
	@FindBy(css = "div[data-rel='#plan-list-2']")
	private WebElement MSPlanInfo;
	
	@FindBy(css = "div[data-rel='#plan-list-2'] span.ng-binding")
	private WebElement MSPlanCount;

	@FindBy(css = "div[data-rel='#plan-list-2'] a")
	private WebElement MSViewPlansLink;

	@FindBy(css = "#msVppDOB")
	private WebElement MSPlanDOB;

	@FindBy(xpath = "//form/div/div[@class='inputcomponent section'][3]//label[contains(text(),'Female')]")
	private WebElement MSPlanGender;

	@FindBy(css = "#mpaed-month")
	private WebElement MSPlanPartAMonth;

	@FindBy(css = "#mpaed-year")
	private WebElement MSPlanPartAYear;

	@FindBy(css = "#mpbed-month")
	private WebElement MSPlanPartBMonth;

	@FindBy(css = "#mpbed-year")
	private WebElement MSPlanPartBYear;

	@FindBy(css = "#msVppdpsd")
	private WebElement MSPlanStartMonth;

	@FindBy(css = "button[class*='viewPlans']")
	private WebElement MSViewPlanButton;

	@FindBy(css = "#mainBody .swiper-container .module-plan-overview:nth-of-type(1)")
	private WebElement MS1stPlan;

	@FindBy(css = "#mainBody .swiper-container .module-plan-overview:nth-of-type(1) h2")
	private WebElement MS1stPlanName;

	@FindBy(css = "#mainBody .swiper-container .module-plan-overview:nth-of-type(2) .swiper-content .apply-button")
	private WebElement MS1stPlanEnroll;
	
	@FindBy(css = "#mainBody .swiper-container .module-plan-overview:nth-of-type(2) #responsiveplan .status-bar img.unliked")
	private WebElement MS1stPlanSaveImg;
	
	@FindBy(css = "div[data-rel='#plan-list-3']")
	private WebElement PDPPlanInfo;

	@FindBy(css = "div[data-rel='#plan-list-3'] span.ng-binding")
	private WebElement PDPPlanCount;
	
	@FindBy(css = "div[data-rel='#plan-list-3'] a")
	private WebElement PDPViewPlansLink;
	
	@FindBy(css = "#plan-list-3 a.emailsummary")
	private WebElement pdpemailList;
	
	@FindBy(css = "#plan-list-1 a.emailsummary")
	private WebElement maemailList;

	@FindBy(css = "#plan-list-4 a.emailsummary")
	private WebElement snpemailList;
	
	@FindBy(css = "#emailPlanSummaryPopUp #email")
	private WebElement emailText;
	
	@FindBy(css = "#emailPlanSummaryPopUp button[type='submit']")
	private WebElement emailSendButton;
	
	@FindBy(css = "#emailPlanSummarySuccessPopUp p")
	private WebElement emailSuccess;
	
	@FindBy(css = "#emailPlanSummarySuccessPopUp button[class*='close-popup']")
	private WebElement emailCloseButton;

	@FindBy(css = "#plan-list-3 .swiper-container .module-plan-overview:nth-of-type(1)")
	private WebElement PDP1stPlan;

	@FindBy(css = "#plan-list-3 .swiper-container .module-plan-overview:nth-of-type(1) h3")
	private WebElement PDP1stPlanName;
	
	@FindBy(css = "#plan-list-3 .swiper-container .module-plan-overview h3")
	private List<WebElement> PDPPlansId;
	
	@FindBy(css = "#plan-list-3 .swiper-container .module-plan-overview:nth-of-type(1) .enrollment>div>a")
	private WebElement PDP1stPlanEnroll;
	
	@FindBy(css = "#plan-list-3 .swiper-container .module-plan-overview h3")
	private List<WebElement> PDPPlansName;
	
	@FindBy(css = "#plan-list-3 .swiper-container .module-plan-overview")
	private List<WebElement> PDPPlansNames;
	
	@FindBy(css = "div[data-rel='#plan-list-4']")
	private WebElement SNPPlanInfo;

	@FindBy(css = "div[data-rel='#plan-list-4'] span.ng-binding")
	private WebElement SNPPlanCount;

	@FindBy(css = "div[data-rel='#plan-list-4'] a")
	private WebElement SNPViewPlansLink;

	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview:nth-of-type(1)")
	private WebElement SNP1stPlan;

	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview:nth-of-type(1) h3")
	private WebElement SNP1stPlanName;
	
	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview h3")
	private List<WebElement> SNPPlansName;
	
	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview")
	private List<WebElement> SNPPlansNames;
	
	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview div.plan-name-div")
	private List<WebElement> SNPPlansId;

	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview:nth-of-type(1) .enroll-details>a:nth-of-type(2)")
	private WebElement SNP1stPlanEnroll;
	
	@FindBy(xpath = "//div[@class='uhc-container']//h2[contains(text(),'Need Help?')]")
	private WebElement needhelptxt;
	
	@FindBy(xpath = "//div[@class='uhc-container']//h4[contains(text(),'Need Help?')]")
	private WebElement needhelptxtMS;
	
	@FindBy(css = ".enroll-details a[dtmid='cta_acq_plans_landing']:nth-of-type(1)")
	private WebElement ViewPlanDetailsButton;
	
	@FindBy(css = ".enroll-details a[dtmid='cta_acq_plans_landing']:nth-of-type(2)")
	private WebElement EnrollPlanButton;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview h3>a")
	private List<WebElement> MAPlanNames;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview a[id*='savePlan']")
	private List<WebElement> MAPlansSaveIcon;
	
	@FindBy(css = "#plan-list-3 .swiper-wrapper .module-plan-overview a[class*='favorite-plan']:nth-child(1) span[class*='unliked']")
	private List<WebElement> PDPPlansSaveIcon;
	
	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview a[id*='savePlan']")
	private List<WebElement> SNPPlansSaveIcon;
	
	@FindBy(css = "button[dtmname*='Keep Shopping Plans']")
	//	@FindBy(css = ".modal-footer #popupClose")
	private WebElement keepshoppingPlansBtn;
	
	@FindBy(css = "#pop-btn-2 span")
	private WebElement ViewSavedBtn;
	
	@FindBy(css = ".flyout-heart-icon")
	private WebElement heartIcon;
	
	@FindBy(css = "#guest-saved-items-button a ")
	private WebElement viewSavedItemsBtn;
	
// Provider and Drug Details in Plan Type
	
	@FindBy(css = "#plan-list-1 div.module-plan-overview")
	private  List<WebElement> MA1stPlanList;
	
	@FindBy(css = "#plan-list-1 div.module-plan-overview:nth-child(1) .drugs-list div[class*='drug-info-container']")
	private  List<WebElement> DrugsNames;
	
	@FindBy(css = "a#selector")
	private  WebElement StartNowButton;
	
	@FindBy(css = "#buildyourdruglist button[dtmname*='review drug costs']:nth-child(1)")
	private List<WebElement> reviewDrugCostButtons;

// Start Over Popup
	
	@FindBy(css = "#plan-list-1 .plan-list-content #editMyAnswers")
	private  WebElement StartOverButton;
	
	@FindBy(css = "#startoverdetails")
	private  WebElement StartOverDetails;
	
	@FindBy(css = "#startOverContent")
	private  WebElement StartOverContent;
	
	@FindBy(css = "#closestartoverpopup")
	private  WebElement closeButton;
	
	@FindBy(css = "#startoverPopUp button[class*='cta-button sendbtn']")
	private  WebElement startOverButtoninPopup;
	
	@FindBy(xpath = "//*[contains(@class,'get-started-banner')]//button[contains(text(),'Get Started')]")
	private WebElement getStartedBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;
	
	@FindBy(css = "input#zipcodemeded-0")
	private WebElement homePageZiptxt;
	
	@FindBy(css = "#ghn_lnk_1>span")
	private WebElement headerNavigationBarHomeTab;
	
	@FindBy(css = "button[class*='uhc-zip-button']")
	private WebElement homePageFindPlans;
	
//Zipcode Page
	
	@FindBy(xpath = "//*[@id='zip-code']")
	private WebElement zipCode;
	
	@FindBy(css = "#selectCounty")
	private WebElement multiCountyDialog;
	
	@FindBy(css = "#selectCounty p a")
	private  List<WebElement> multiCounty;
	
	@FindBy(id = "zipInfo")
	private WebElement countyInfo;
	
	@FindBy(id = "MultipleCounty")
	private WebElement multiCountyInfo;
	
// VPP Details page
	
	@FindBy(css = ".uhc-container div.content h2")
	private WebElement planNameVPPDetailsPage;
	
	@FindBy(id = "backToPlanSummaryTop")
	private WebElement backtoPlanSummary;
	
	@FindBy(css = ".uhc-container a[class*='back-to-plans']")
	private List<WebElement> backtoProfile;
	
	@FindBy(css = ".segment div[class*='content p-b-0'] h3")
	private WebElement planNameEnrollPageExternal;
	
	@FindBy(css = ".segment h2")
	private WebElement planNameEnrollPage;
	
	@FindBy(css = "div#toggleYearSection button[class*='current-year']")
	private WebElement currentPlanYear; // Future Year
	
	@FindBy(css = "div#toggleYearSection button[class*='prev-year']")
	private WebElement previousPlanYear; // Current Year
	
	@FindBy(css = "#highlights a[class*='cta-button']>span")
	private List<WebElement> enrollBtnPlanDetails;
	
	@FindBy(css = "button#enrollment-next-button")
	private WebElement nxtBtnOLEPage;
	
	// Visitor profile elements

		@FindBy(css = "div h3[class*='plan-name']")
		private List<WebElement> planNamesVisitorPrf;

		@FindBy(css = ".planTileSection .visitingProfileContainer h3")
		private WebElement MSPlanSection;

		@FindBy(css = ".planTileSection .userProfileMedSuppPlan")
		private List<WebElement> MSPlansCount;

		@FindBy(css = ".planTileSection .userProfileMedSuppPlan .saved-plancard-title h2")
		private List<WebElement> MSPlanName;

		@FindBy(css = ".planTileSection .userProfileMedSuppPlan .saved-plancard-title button.remove-icon")
		private List<WebElement> MSPlanRemoveIcon;

		@FindBy(css = "#navLinks a:nth-child(1)")
		private WebElement BacktoPlansLink;

		@FindBy(css = "#saved-drugs")
		private WebElement DrugCount;

		@FindBy(css = "#saved-doctors h3")
		private WebElement ProviderCount;

		@FindBy(css = ".drugs-list li")
		private List<WebElement> Druglist;

		@FindBy(css = "button[aria-describedby*='removeDrugName']")
		private WebElement DrugRemove;

		@FindBy(css = ".doctors-list li")
		private List<WebElement> Providerlist;

		@FindBy(css = ".callout-find-plans button[class*='uhc-button--secondary']>span")
		private WebElement Addplans;

		@FindBy(css = ".uhc-profile-header-nav li:nth-child(4) span:nth-of-type(2)")
		private WebElement PRESection;

		@FindBy(css = "#saved-plan-recommendations h2")
		private WebElement SavedRecomTitle;

		@FindBy(css = "#saved-plan-recommendations h3")
		private WebElement PRETitleinVP;

		@FindBy(css = "#saved-plan-recommendations button")
		private WebElement GetStartedButton;

		@FindBy(css = "#saved-plan-recommendations img")
		private WebElement PREImage;

		@FindBy(css = ".subheading-text a")
		private WebElement EditMyResponsesLink;

		@FindBy(css = "div.uhc-pre-card")
		private List<WebElement> RecommendationSection;
		
		@FindBy(css = "div[class*='row-collapse']:nth-child(4) div:nth-child(1) p#planType")
		private WebElement FirstRecommendationSectionPlanType;

		@FindBy(css = "div[class*='row-collapse']:nth-child(4) div:nth-child(1) .uhc-pre-card h3")
		private WebElement FirstRecommendationSectionPlanName;

		@FindBy(css = "div[class*='row-collapse']:nth-child(4) div:nth-child(1) a[class*='plan-details-link']")
		private WebElement FirstRecommendationSectionViewPlanDetails;
		
		@FindBy(css = "div[class*='row-collapse']:nth-child(4) div:nth-child(1) .uhc-pre-card button")
		private WebElement FirstRecommendationSectionEnrollToPlanButton;

		@FindBy(css = "div[class*='row-collapse']:nth-child(4) div:nth-child(2) a.pre-action-link")
		private WebElement ViewRankedListOfPlanLinks;

		@FindBy(css = "#saved-plan-recommendations p:nth-child(1)")
		private WebElement PREWidgetParaTalktoExpert;

		@FindBy(css = "#saved-plan-recommendations p:nth-child(3) span")
		private WebElement PREWidgetCallNum;
	
		
		@FindBy(css = ".planNameMinHeight h2")
		private WebElement planNameinPlanDetailsPage;
	
// External page elements
	
	@FindBy(css = ".c-card__footer a[class*='primary']")
	private WebElement GetHelpFindingaPlanBtn;
	
	@FindBy(css = ".c-card__footer a[class*='naked']")
	private WebElement HelpMeChooseBtn;
	
	@FindBy(css = ".c-banner__cta>a")
	private WebElement startNowBtn;
	
	@FindBy(css = ".modal-dialog a.modal-close")
	private WebElement modelclose;
	
	// New Results Page
		@FindBy(css = "uhc-plan-info a")
		private List<WebElement> allPlansID;
		
		
// PRE Result page element
		
		@FindBy(css = "li.planTileGrid")
		private List<WebElement> plantiles;
		
		@FindBy(css = "li.planTileGrid uhc-plan-info")
		private List<WebElement> plantilesMS;
		
		@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview h3>a")
		private List<WebElement> PlanName;
		
		@FindBy(css = "button[class*='saved-items-button']")
		private WebElement mySavedItems ;
		
		@FindBy(css = "#guest-saved-items-button")
		private WebElement guestViewSavedBtn;
		
		
//Result Loading Page Element Verification Method 

	public void resultsloadingpage() {
		System.out.println("Validating Results loading Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(resultsloadingTitle);
		validate(svgAnimation, 30);
		validate(loadingImage, 30);
	}
	
//Results Page Element Verification Method	
	
	public void resultsUI(String zip,String county,String R1,String R2, boolean tie) {
		System.out.println("Validating Results UI Page: ");
		pageloadcomplete();
		waitForPageLoadSafari();
		validate(planZipInfo,60);
		waitforElementInvisibilityInTime(planLoaderscreen,60);
		Assert.assertTrue(planZipInfo.getText().contains(zip),"Invalid Zip");
		Assert.assertTrue(planZipInfo.getText().toUpperCase().contains(county.toUpperCase()),"Invalid County");
		Assert.assertTrue(Integer.parseInt(planZipInfo.getText().split(" ")[2])>0,"Total Plan count is less than 1");
		String recom = "Recommended";
		String recom1 = "#1 Recommendation";
		String recom2 = "#2 Recommendation";
		if (tie == false) {
			Assert.assertTrue(planBasedInfo.getText().toUpperCase().contains("BASED"),"Text box is not availabe");
			checkRecommendationCount(R1, recom1, R2, recom2);
			validateRecommendations(R1, recom1, R2, recom2);
			validateRecommendationPlan(R1);
		} else {
			if (R1.isEmpty()) {
				checkTieRecommendationCount("", recom1, "");
			} else if (R2.isEmpty()) {
				checkTieRecommendationCount(R1, recom1, "");
				validateRecommendations(R1, recom1, "", "");
			} else {
				 checkTieRecommendationCount(R1, recom, R2);
				 validateRecommendations(R1, recom, R2, recom);
			 }
		}
	}
	
	
	public void validateRecommendations(String R1, String rcom1, String R2, String rcom2) {
		System.out.println("Validating Recommendations in Results Page");
		if (R1.equalsIgnoreCase("MA")) {
			Assert.assertTrue(planBasedInfo.getText().contains("Medicare Advantage"));
			Assert.assertTrue(MAPlanInfo.getText().contains(rcom1), "MA Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(MAPlanCount.getText()) > 0, "MA Plan count is less than 1");
		}
		if (R1.equalsIgnoreCase("MS")) {
			Assert.assertTrue(planBasedInfo.getText().contains("Medicare Supplement"));
			Assert.assertTrue(MSPlanInfo.getText().contains(rcom1), "MS Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(MSPlanCount.getText()) > 0, "MS Plan count is less than 1");
		}
		if (R1.equalsIgnoreCase("PDP")) {
			Assert.assertTrue(planBasedInfo.getText().contains("Medicare Prescription Drug"));
			Assert.assertTrue(PDPPlanInfo.getText().contains(rcom1), "PDP Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(PDPPlanCount.getText()) > 0, "PDP Plan count is less than 1");
		}
		if (R1.equalsIgnoreCase("SNP")) {
			Assert.assertTrue(planBasedInfo.getText().contains("Medicare Special Needs"));
			Assert.assertTrue(SNPPlanInfo.getText().contains(rcom1), "SNP Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(SNPPlanCount.getText()) > 0, "SNP Plan count is less than 1");
		}
		// Verify 2nd Recommendation
		if (R2.equalsIgnoreCase("MA")) {
			Assert.assertTrue(MAPlanInfo.getText().contains(rcom2), "MA Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(MAPlanCount.getText()) > 0, "MA Plan count is less than 1");
		}
		if (R2.equalsIgnoreCase("MS")) {
			Assert.assertTrue(MSPlanInfo.getText().contains(rcom2), "MS Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(MSPlanCount.getText()) > 0, "MS Plan count is less than 1");
		}
		if (R2.equalsIgnoreCase("PDP")) {
			Assert.assertTrue(PDPPlanInfo.getText().contains(rcom2), "PDP Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(PDPPlanCount.getText()) > 0, "PDP Plan count is less than 1");	
		}
		if (R2.equalsIgnoreCase("SNP")) {
			Assert.assertTrue(SNPPlanInfo.getText().contains(rcom2), "SNP Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(SNPPlanCount.getText()) > 0, "SNP Plan count is less than 1");
		}
	}
	
	public void checkRecommendationCount(String R1, String rcom1, String R2, String rcom2) {
		System.out.println("Verifying Recommendation counts");
		int R1Count = 0, R2Count = 0;
		if (MAPlanInfo.getText().contains(rcom1))
			R1Count++;
		if(MSPlanInfo.getText().contains(rcom1))
			R1Count++;
		if(PDPPlanInfo.getText().contains(rcom1))
			R1Count++;
		if(SNPPlanInfo.getText().contains(rcom1))
			R1Count++;
		if(MAPlanInfo.getText().contains(rcom2))
			R2Count++;
		if(MSPlanInfo.getText().contains(rcom2))
			R2Count++;
		if(PDPPlanInfo.getText().contains(rcom2))
			R2Count++;
		if(SNPPlanInfo.getText().contains(rcom2))
			R2Count++;
		Assert.assertTrue(R1Count == 1, "#1Recommendation presents more than once");
		if (R2.isEmpty() || R2 == "")
			Assert.assertTrue(R2Count == 0, "#2Recommendation presents");
		else
			Assert.assertTrue(R2Count == 1, "#2Recommendation presents more than once or not available");
	}

	public void validateRecommendationPlan(String R1) {
		String currentPageUrl = driver.getCurrentUrl();
		boolean isDSNP=true;
		if (R1.equalsIgnoreCase("MA")) {
//			MAViewPlansLink.click();
			validate(MA1stPlanName, 60);
//			Assertion.assertTrue(MA1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()), "MA Invalid Plan Ranking");
			//mobileUtils.mobileLocateElementClick(MA1stPlanEnroll);
//			clickEnrolldesktop(MA1stPlanEnroll);
		}
		if (R1.equalsIgnoreCase("MS")) {
//			MSViewPlansLink.click();
			submitMSform();
			validate(MS1stPlanName, 60);
//			Assertion.assertTrue(MS1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),"MS Invalid Plan Ranking");
			//mobileUtils.mobileLocateElementClick(MS1stPlanEnroll);
			clickEnrolldesktop(MS1stPlanEnroll,needhelptxtMS);
		}
		if (R1.equalsIgnoreCase("PDP")) {
//			PDPViewPlansLink.click();
			validate(PDP1stPlanName, 60);
//			Assertion.assertTrue(PDP1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),"PDP Invalid Plan Ranking");
			//mobileUtils.mobileLocateElementClick(PDP1stPlanEnroll);
//			clickEnrolldesktop(PDP1stPlanEnroll);
		}
		if (R1.equalsIgnoreCase("SNP")) {
//			SNPViewPlansLink.click();
			validate(SNP1stPlanName, 60);
//			Assertion.assertTrue(SNP1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),"SNP Invalid Plan Ranking");
			//mobileUtils.mobileLocateElementClick(SNP1stPlanEnroll);
			if(SNP1stPlanName.getText().toUpperCase().contains("D-SNP")) 
				clickEnrolldesktop(SNP1stPlanEnroll,needhelptxt);
			else
				isDSNP=false;
		}
		threadsleep(5000);
		pageloadcomplete();
		if(isDSNP)
			Assert.assertTrue(currentPageUrl != driver.getCurrentUrl(), "Enroll Plan URL is not working");
	}
	
// Filling MS form with default value
		public void submitMSform() {
			//Zip value is pre-populated by default
			MSPlanDOB.sendKeys("01/06/1940");
			jsClickNew(MSPlanGender);
			threadsleep(8000);
			jsClickNew(MSPlanGender);
			threadsleep(3000);							//E2E: Added for the overlay to disappear after selecting a option
			Select temp = new Select(MSPlanPartAMonth);
			temp.selectByVisibleText("January 1");
			threadsleep(2000);							//E2E: Added for the overlay to disappear after selecting a option
			temp = new Select(MSPlanPartAYear);
			temp.selectByVisibleText(nxtYear);
			threadsleep(2000);							//E2E: Added for the overlay to disappear after selecting a option
			temp = new Select(MSPlanPartBMonth);
			temp.selectByVisibleText("January 1");
			threadsleep(2000);							//E2E: Added for the overlay to disappear after selecting a option
			temp = new Select(MSPlanPartBYear);
			temp.selectByVisibleText(nxtYear);
			threadsleep(2000);							//E2E: Added for the overlay to disappear after selecting a option
			temp = new Select(MSPlanStartMonth);
			temp.selectByVisibleText("January 1, " + nxtYear);
			jsClickNew(MSViewPlanButton);
		}
		
		int Year = Integer.parseInt(getCurrentYear()) +1;
		String nxtYear = Integer.toString(Year);
		public String getCurrentYear() {
			DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
			Date date = new Date();
			String curDate = dateFormat.format(date);
			return curDate.split("/")[2];
		}

		public void clickEnrolldesktop(WebElement enrollButton,WebElement needhelp) {
			boolean click = false;
			for (int i = 0; i < 5; i++) {
				try {
					validate(enrollButton, 5);
					jsClickNew(enrollButton);
					click = true;
					break;
				} catch (Exception e) {
					System.out.println("Unable to enroll");
				}
			}
			Assert.assertTrue(click, "Unable to click the Enroll button");
		}
		
		public void checkTieRecommendationCount(String R1, String rcom, String R2) {
			int RCount = 0;
			if (MAPlanInfo.getText().contains(rcom))
				RCount++;
			if (MSPlanInfo.getText().contains(rcom))
				RCount++;
			if (PDPPlanInfo.getText().contains(rcom))
				RCount++;
			if (SNPPlanInfo.getText().contains(rcom))
				RCount++;
			if(R1=="")
				Assert.assertTrue(RCount == 0, "Recommendation Count is not equal to Zero");
			else if(R2=="")
				Assert.assertTrue(RCount == 1, "Recommendation Count is not equal to One");
			else
				Assert.assertTrue(RCount == 2, "Recommendation is not equals to Two");
		}
		
		public void navigateVPP(HashMap<String, String> inputdata) {
            validate(headerNavigationBarHomeTab,20);
            jsClickNew(headerNavigationBarHomeTab);
            String zipcode =inputdata.get("Zip Code");
            validate(homePageZiptxt,60);
            homePageZiptxt.sendKeys(zipcode);
            jsClickNew(homePageFindPlans);
            if (inputdata.get("Is Multi County").equalsIgnoreCase("yes")) {
                if (selectMultiZip.get(0).getText().toUpperCase().contains(inputdata.get("CountyDropDown").toUpperCase()))
                    selectMultiZip.get(0).click();
                // mobileUtils.mobileLocateElementClick(selectMultiZip.get(0));
                else if (selectMultiZip.get(1).getText().toUpperCase().contains(inputdata.get("CountyDropDown").toUpperCase()))
                    selectMultiZip.get(1).click();
                // mobileUtils.mobileLocateElementClick(selectMultiZip.get(1));
            }
            validate(planZipInfoinVPP, 60);
            waitforElementInvisibilityInTime(planLoaderscreen,60);
            threadsleep(5000);// Plan loader
            Assert.assertTrue(planZipInfoinVPP.getText().contains(inputdata.get("Zip Code")),"Invalid Zip");       
            jsClickNew(MAViewPlansLink);
            pageloadcomplete();
            waitForPageLoadSafari();
        }
		
		public void drugsDetailsPREtoVPP() {
			System.out.println("Validating PRE Drugs Details in VPP Page Plan Type: ");
			DrugsInPRE = PlanRecommendationEngineDrugsPage.drugNames;
			int count =DrugsInPRE.size();
			drugsCoveredInVPP(count);
			verifyConfirmationmodalResults(count,DrugsInPRE,DrugsList);
			validate(drugSummarylinkMA1stPlan, 60);
			jsClickNew(drugSummarylinkMA1stPlan);
		}
		
		public void removedDrugsDetailsVPPtoPRE() {
			System.out.println("Validating removed Drugs Details from VPP to PRE Drug Page: ");
			flow = CommonConstants.PRE_FLOW.get(String.valueOf(Thread.currentThread().getId()));//PlanRecommendationEngineStepDefinition.PREflow;
			DrugsInPRE = PlanRecommendationEngineDrugsPage.drugNames;
			boolean remove = true;
			int count =DrugsInPRE.size();
			drugsCoveredInVPP(count);
			removeDrugs(count);
			vppToPre();
			validateDrugPage(flow, true);
		}
		
		public void startnowtilldrugs() {
			System.out.println("Navigating to PRE Using StartNow: ");
			flow = CommonConstants.PRE_FLOW.get(String.valueOf(Thread.currentThread().getId()));//PlanRecommendationEngineStepDefinition.PREflow;
			vppToPre();
			validateDrugPage(flow, false);
		}
		
		public void DrugsDetailsVPPtoPRE() {
			System.out.println("Validating Drugs Details from DCE to VPP Drug Page: ");
			ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(driver);
			if(validate(MAViewPlansLink, 60))
				jsClickNew(MAViewPlansLink);
			int count = Integer.parseInt(MA1stPlanList.get(0).findElement(By.cssSelector("a[id*='drug-list-title']")).getText().trim().split(" drugs")[0].split("of ")[1]);
					//Druglist.size();
			DrugsInVPP = drugsCoveredInVPP(count);
//			DrugsInDCE = dce.getDrugNamesDCE();
			DCEtoPRE();
		}
		
		public void DrugsDetailsVPPtoDCE(String drugsList) {
			ArrayList<String> drugsName = new ArrayList<String>();
			ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(driver);
			System.out.println("Navigating to DCE Page: ");
			vppToDCE();
			dce.clickDCEAddDrugBtn();
			System.out.println("Validating Drugs Details from VPP to DCE Page: ");
			DrugsInDCE = dce.getDrugNamesDCE();
			int count =DrugsInDCE.size();
			String[] strSplit = drugsList.split(":");
			for(String drug:strSplit)
				drugsName.add(drug.toUpperCase());
			Collections.sort(drugsName);
			System.out.println("DrugList in DCE: "+drugsName);
			verifyConfirmationmodalResults(count,DrugsInDCE,drugsName);
			reviewDrugCostButtons.get(0).click();
			Assert.assertTrue(driver.getCurrentUrl().contains("dcezipinformation"),"ReviewDrugCost Page is not loaded");
		}
		
	
		public void removeDrugs(int count) {
			// By default removing 2nd drug
    		int beforeRemove = DrugsList.size();
    		threadsleep(5000);
    		drugcoveredsession();
//    		DrugsNames.get(count-1).findElement(By.cssSelector("button[class*='remove-icon']")).click();
    		jsClickNew(DrugsNames.get(count-1).findElement(By.cssSelector("button[class*='remove-icon']")));
    		threadsleep(8000);
//    		drugcoveredsession();
    		pageloadcomplete();
    		drugcoveredsession();
    		drugsCoveredInVPP(count-1);
    		int afterRemove = DrugsList.size();
    		if(beforeRemove!=afterRemove) {
    			System.out.println("Remove Results Count mismatch");
    			
    		}else {
    			System.out.println("Remove Results Count matching and Remove is not removed");
    			Assert.assertTrue(false);
    		}
		}
		
		public ArrayList<String> drugsCoveredInVPP(int count) {
			System.out.println("Clicking on Drugs Details in Plan Type: "+count);
			DrugsList = new ArrayList<String>();
			validate(MAPlanCount,60);			
			WebElement drugImageVPP = MA1stPlanList.get(0).findElement(By.cssSelector("a[class*='drug-list-toggle'] img"));
			validate(drugImageVPP,20);
			threadsleep(5000);
			drugcoveredsession();
			for (int i = count-1; i >= 0; i--) {
				threadsleep(1000);
				DrugsList.add(DrugsNames.get(i).findElement(By.cssSelector("div[class*='flex-col drug-info'] span:nth-child(1)")).getText().trim().toUpperCase() );
				WebElement RemoveIcon = DrugsNames.get(i).findElement(By.cssSelector("button[class*='remove-icon']"));
				WebElement coveredIcon = MA1stPlanList.get(i).findElement(By.cssSelector(".drugs-list div[id*='Covered']"));
				validate(RemoveIcon,20);
				validate(coveredIcon,20);
			}
			Collections.sort(DrugsList);
			jsClickNew(drugCoveredeVPP);
			System.out.println("DrugsList Size is : "+DrugsList.size());
			System.out.println("DrugList Content is : "+DrugsList);
			return DrugsList;
		}
		
		public void drugcoveredsession() {
			drugCoveredeVPP = MA1stPlanList.get(0).findElement(By.cssSelector("a[class*='drug-list-toggle']"));
			jsClickNew(drugCoveredeVPP);
		}
		
		public void verifyConfirmationmodalResults(int count,ArrayList<String> drug,ArrayList<String> drugListVPP) {
    		if(drug.size()==drugListVPP.size() && count==drug.size()) {
    			String druglist =drug.toString().toUpperCase();
    			String vppdruglist =drugListVPP.toString();
    			if(druglist.contains(vppdruglist)) {
    				System.out.println("Drug and Modal Result's Content matched");
    			}
    			else {
    				System.out.println("Drug and Modal Result's Content mismatch");
    				Assert.assertTrue(false);
    			}
    		}
    		else {
    			System.out.println("Drug and Modal Results Count mismatch");
    			Assert.assertTrue(false);
    		}
    	}
		
		public void vppToDCE() {
			System.out.println("Validating VPP to DCE Page");
			scrollToView(headerDrugcostLink);
			headerDrugcostLink.click();
			pageloadcomplete();
			Assert.assertTrue(driver.getCurrentUrl().contains("drug-cost-estimator"), "Page is not navigated to DCE");		
		}
		
		public void DCEtoPRE() {
			System.out.println("Navigating to PRE Page");
			scrollToView(headerGetaPlanRecommendationLink);
			headerGetaPlanRecommendationLink.click();
			pageloadcomplete();
			Assert.assertTrue(driver.getCurrentUrl().contains("/plan-recommendation-engine.html#/get-started"), "Page is not navigated to PRE");		
		}
		
	public void vppToPre() {
		System.out.println("Validating VPP to PRE Page");
		validate(StartNowButton,20);
		jsClickNew(StartNowButton);
		pageloadcomplete();
		waitForPageLoadSafari();
	}
	

	public void validateDrugPage(String plan,boolean removedrug) {
		System.out.println("Validating Drugs in Drug Page");
//		getStartedBtn.click();
		jsClickNew(getStartedBtn);
		threadsleep(2000);
		int MAPD = 6;
		int PDP = 3;
		int None = 6;
		if(plan.equalsIgnoreCase("MAPD")) {
			for(int i=0;i<MAPD;i++) {
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();
				waitForPageLoadSafari();
			}
		}else if(plan.equalsIgnoreCase("None")) {
			for(int i=0;i<None;i++) {
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();
				waitForPageLoadSafari();
			}
		}else if(plan.equalsIgnoreCase("PDP")) {
			for(int i=0;i<PDP;i++) {
//				continueBtn.click();
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();
				waitForPageLoadSafari();
			}
		}
		if(removedrug==true) {
			DrugsList = DrugsList;	
		}else {
			DrugsList = drug.drugNames;
		}
		ModelDrugsList = drug.drugnamesList();
		System.out.println("DrugsList Size is : "+DrugsList.size());
		System.out.println("ModelDrugsList Size is : "+ModelDrugsList.size());
		verifyConfirmationmodalResults(DrugsList.size(), DrugsList,ModelDrugsList);
	}
	
	public void startNowFullFlow(String plan) {
		System.out.println("Validating Start Now Full flow in PRE");
		int MAPD = 1;
		int PDP = 2;
		int None = 1;
		if(plan.equalsIgnoreCase("MAPD")) {
			for(int i=0;i<MAPD;i++) {
//				continueBtn.click();
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();
			}
		}else if(plan.equalsIgnoreCase("None")) {
			for(int i=0;i<None;i++) {
//				continueBtn.click();
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();
			}
		}else if(plan.equalsIgnoreCase("PDP")) {
			for(int i=0;i<PDP;i++) {
//				continueBtn.click();
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();
			}
		}
	}
	
	PlanRecommendationEngineDoctorsPage docdesktop = new PlanRecommendationEngineDoctorsPage(driver);
	int count = 1;
	int locationCount = 1;
	
	public void addProviderVPP(String name,String multi) {
//		MAViewPlansLink.click();
		String curdriverhandle = driver.getWindowHandle();
//		enterProvidersInfoMA1stPlan.click();
		jsClickNew(enterProvidersInfoMA1stPlan);
		if(multi.equalsIgnoreCase("Yes"))
			count = 3;
		else if(multi.equalsIgnoreCase("Multi"))
			locationCount = 5;	
		werallyResults=docdesktop.validateLinksanotherWindow(curdriverhandle, "Doctors", name, count, locationCount);	
		ArrayList<String> vppResults = getProvidersVPP();
		Assert.assertTrue(vppResults.size()==count*locationCount,"Providers count mismatch in VPP");
	}
	
	public ArrayList<String> getProvidersVPP() {
		threadsleep(5000);
		pageloadcomplete();
//		providersInfoMA1stPlan.click();
		scrollToView(providersInfoMA1stPlan);
		jsClickNew(providersInfoMA1stPlan);
		vppProviderResults = new ArrayList<String>();
		for(WebElement e:providersListMA1stPlan) {
			vppProviderResults.add(e.getText().trim());
		}	
		return vppProviderResults;
	}
	
	public void verifyProviderVPP() {
		containsname(werallyResults,vppProviderResults);
	}
	
	public boolean containsname(ArrayList<String> werallypreproviders, ArrayList<String> vppprovider) {
		boolean result = true;
		for (int i = 0; i < werallypreproviders.size(); i++) {
			String wname[] = werallypreproviders.get(i).replace(",", "").replace(".", "").split(" ");
			List<String> wnam = Arrays.asList(wname);
			for (int j = 0; j < vppprovider.size(); j++) {
				String dname[] = vppprovider.get(j).replace(",", "").replace(".", "").replace("\n", " ").split(" ");
				List<String> dnam = Arrays.asList(dname);
				if (wnam.containsAll(dnam) || dnam.containsAll(wnam)) {
					result = true;
					break;
				} else {
					result = false;
				}
			}
		}
		System.out.println("Doctors Name validation Result " + result);
		Assert.assertTrue(result,"Providers name mismatch");
		return result;
	}
	
	public void getProvidersPRE(String multi) {
		if(multi.equalsIgnoreCase("Yes"))
			count = 3;
		confirmationResults1=docdesktop.getConfimationPopupResults(count);
		System.out.println("confirmationResults1 Size is : "+confirmationResults1.size());
	}
	
	public void verifyProvidersSession(String multi) {
		if(multi.equalsIgnoreCase("Yes"))
			count = 3;
		docdesktop.verifyConfirmationmodalResults(count, werallyResults, confirmationResults1);
		docdesktop.nextPageValidationDoctor();
	}
	
	public void verifyDoctorsSession(String multi) {
		if(multi.equalsIgnoreCase("Yes"))
			count = 3;
		else
			count =1;
		confirmationResults = docdesktop.confirmationResults;
		System.out.println("confirmationResults Size is : "+confirmationResults.size());
		verifyConfirmationmodalResults(confirmationResults1.size(), confirmationResults, confirmationResults1);
		docdesktop.nextPageValidationDoctor();
	}
	
	public void navigatePRE() {
//		StartNowButton.click();
		jsClickNew(StartNowButton);
		pageloadcomplete();
		Assert.assertTrue(driver.getCurrentUrl().contains("plan-recommendation-engine.html"));
		//driver.navigate().refresh();
		//pageloadcomplete();
	}

	public void verifyProviderPREVPP() {
		waitforElementInvisibilityInTime(planLoaderscreen,60);
		threadsleep(5000);// Plan loader
		getProvidersVPP();
		containsname(PlanRecommendationEngineDoctorsPage.confirmationProviderResults,vppProviderResults);
	}
	
	public void countyandViewPlan(String zip,String county, String isMultiCounty) {
		System.out.println("Validating Zipcode in Results UI Page: ");
		validate(headerNavigationBarHomeTab,20);
		jsClickNew(headerNavigationBarHomeTab);
		validate(homePageZiptxt,60);
		homePageZiptxt.sendKeys(zip);
		jsClickNew(homePageFindPlans);
		pageloadcomplete();
		if(isMultiCounty.equalsIgnoreCase("YES")) {
			validate(multiCountyDialog);
			selectFromDropDown(multiCounty, county);
		}
		validate(planZipInfoinVPP,60);
		waitforElementInvisibilityInTime(planLoaderscreen,60);
		Assert.assertTrue(planZipInfoinVPP.getText().contains(zip),"Invalid Zip");
		Assert.assertTrue(planZipInfoinVPP.getText().toUpperCase().contains(county.toUpperCase()),"Invalid County");
		Assert.assertTrue(Integer.parseInt(planZipInfoinVPP.getText().split(" ")[2])>0,"Total Plan count is less than 1");
		jsClickNew(MAViewPlansLink);
		pageloadcomplete();
	}
	
	public void validateZipcodePage(String zip,String county, String isMultiCounty) {
		System.out.println("Validating Zipcode and County in location Page");
		jsClickNew(getStartedBtn);
		pageloadcomplete();
		Assert.assertTrue(zipCode.getAttribute("ng-reflect-model").contains(zip),"Invalid Zip");
		if (isMultiCounty.equalsIgnoreCase("NO")) {
			validate(countyInfo,20);
			Assert.assertTrue(countyInfo.getText().toUpperCase().contains(county.toUpperCase()),"Invalid County");}
		else {
			validate(multiCountyInfo,20);
			Assert.assertTrue(multiCountyInfo.getText().toUpperCase().contains(county.toUpperCase()),"Invalid County");
		}
		jsClickNew(continueBtn);
		
	}
	
	public void vppToPreStartOver() {
		System.out.println("Validating VPP to PRE Page Clicking on Start Over Button");
		validate(StartOverButton,20);
		jsClickNew(StartOverButton);
		startOverPopup();
		pageloadcomplete();
		waitForPageLoadSafari();
	}
	
	public void startOverPopup() {
		System.out.println("Validating Start Over Popup elements");
		validate(StartOverDetails,20);
		validate(StartOverContent,20);
		validate(closeButton,20);
		validate(startOverButtoninPopup,20);
		jsClickNew(startOverButtoninPopup);
	}
	
	public void validateRankingPlans(String Recom,String plans) {
		System.out.println("Validating Plans Ranking : ");
		plansLoader();
		if (Recom.equalsIgnoreCase("MA")) {
			validate(MA1stPlanName, 60);
			verifyRankings(MAPlansName,plans);
		}
		if (Recom.equalsIgnoreCase("MS")) {
			submitMSform();
			validate(MS1stPlanName, 60);
			Assert.assertTrue(false,"MS Plans ranking is not Implemented");
		}
		if (Recom.equalsIgnoreCase("PDP")) {
			validate(PDP1stPlanName, 60);
			verifyRankings(PDPPlansName,plans);
			}
		if (Recom.equalsIgnoreCase("SNP")) {
			validate(SNP1stPlanName, 60);
		}
	}
	
	public void plansLoader() {
		pageloadcomplete();
		validate(planLoaderscreen, 60);
		waitforElementInvisibilityInTime(planLoaderscreen,60);
		threadsleep(5000);// Plan loader
	}
	
public void verifyRankings(List<WebElement> plansName, String plansOrder) {
		
		String givenPlans[] = plansOrder.split(":");
		// List<String> userPlans = Arrays.asList(givenPlans);
		List<String> vppPlans = new ArrayList<String>();
		// System.out.println(userPlans);
		// System.out.println(userPlans.size());
		System.out.println(plansName.size());
		for (WebElement e : plansName)
			vppPlans.add(getplanName(e));
		for (int i = 0; i < givenPlans.length; i++) {
			Assert.assertTrue(vppPlans.get(i).toUpperCase().contains(givenPlans[i].toUpperCase()),
					"Invalid Plan Ranking/Recommendation type : " + vppPlans.get(i) + "<-> " + givenPlans[i]);
		}
		System.out.println("Plan Ranking Successful");
	}

public String getplanName(WebElement plan) {
	String planName = "";
	int i = 0;
	while (i < 5) {
		planName = plan.getText().trim();
		System.out.println(planName);
		if (planName.isEmpty()) {
			mobileswipeHorizantal("80%", 1, false);
			i++;
		} else
			break;
	}
	Assert.assertTrue(planName.length()>1, "--- Unable to get the Plan name ---");
	return planName;
}

public void sendEmail(String plan, String email) {
	System.out.println("Email Plan list from VPP : ");
//	plansLoader();
	if (plan.equalsIgnoreCase("PDP")) {
		jsClickNew(pdpemailList);
	} else if (plan.equalsIgnoreCase("MA")) {
		jsClickNew(maemailList);

	} else if (plan.equalsIgnoreCase("SNP")) {
		jsClickNew(snpemailList);

	} else {
		Assert.assertTrue(false, "Print Email is not configured for the given Plan :" + plan);
	}
	emailText.sendKeys(email);
	jsClickNew(emailSendButton);
	validate(emailSuccess,15);
	jsClickNew(emailCloseButton);
}

public void validateUIAPIRecommendations() {
	System.out.println("Validating UI vs API Plans Recommendation : ");
//	plansLoader();

	String rankingJSON = returnDriverStorageJS("Session Storage", "ucp_planRecommendationResults");
	String MAPriority = getAPIPlansRecommendation(rankingJSON, "MA");
	String MSPriority = getAPIPlansRecommendation(rankingJSON, "MS");
	String PDPPriority = getAPIPlansRecommendation(rankingJSON, "PDP");
	String SNPPriority = getAPIPlansRecommendation(rankingJSON, "SNP");
	String R1 = "", R2 = "";
	int totalcount = 0;
	if (MAPriority.length() == 1) {
		totalcount++;
		if (MAPriority.equals("1"))
			R1 = "MA";
		else
			R2 = "MA";
	}
	if (MSPriority.length() == 1) {
		totalcount++;
		if (MSPriority.equals("1"))
			R1 = "MS";
		else
			R2 = "MS";
	}
	if (PDPPriority.length() == 1) {
		totalcount++;
		R1 = "PDP";
	}
	if (SNPPriority.length() == 1) {
		totalcount++;
		R1 = "SNP";
	}

	if (totalcount > 2)
		Assert.assertTrue(false, "Recommendation Count should not exceeds 2");

	String recom = "Recommended";
	String recom1 = "#1 Recommendation";
	String recom2 = "#2 Recommendation";
	if (R1.equals("1") && R2.equals("2"))
		validateRecommendations(R1, recom1, R2, recom2);
	if (R1.length() == 1 && R2.length() == 0)
		validateRecommendations(R1, recom1, "", "");
	if (R1.equals(R2) && R1.length() == 1)
		validateRecommendations(R1, recom, R2, recom);
	System.out.println("API vs UI Plan Recommendation Successful");
}	

public void validateUIAPIRankingPlans() {
	System.out.println("Validating UI vs API Plans Ranking on PRE results page: ");
	waitforResultsPage();
	String rankingJSON = returnDriverStorageJS("Session Storage", "ucp_planRecommendationObj");
	List<String> APIRankings = getAPIPlansRanking(rankingJSON);
	if (APIRankings.size() > 0) {
		verifyAPIRankings(allPlansID, APIRankings);
	}
}

// UIAPI Ranking Validation for AEP Years
public void validateAEPUIAPIRankingPlans(String year) {
	System.out.println("Validating UI vs API Plans Ranking on PRE results page: ");
	waitforResultsPage();
	String rankingJSON = returnDriverStorageJS("Session Storage", "ucp_planRecommendationObj");
	List<String> APIRankings = getAEPAPIPlansRanking(rankingJSON, year);
	if (APIRankings.size() > 0) {
		verifyAPIRankings(allPlansID, APIRankings);
	}
}

public void waitforResultsPage() {
	pageloadcomplete();
	waitForPageLoadSafari();
	validate(planZipInfo, 60);
	threadsleep(3000);
}

public List<String> getAPIPlansRanking(String rankingJSON) {
	int uiPlanCount = Integer.parseInt(planZipInfo.getText().split(" ")[4]);
	List<String> rankingOrder = new ArrayList<String>();
	JSONParser parser = new JSONParser();
	JSONArray jarray = new JSONArray();
	JSONObject jsonObject = null;
	try {
		//jarray = (JSONArray) parser.parse(rankingJSON);
		jsonObject = (JSONObject) parser.parse(rankingJSON);
		jarray = (JSONArray) jsonObject.get("plans");
		System.out.println("API Plans Count "+jarray.size());
		System.out.println("UI Plans Count "+uiPlanCount);
		for (int i = 0; i < uiPlanCount; i++) {
			// System.out.println(jarray.get(i));
			for(int j=0;j< uiPlanCount;j++)
			{
			JSONObject jsonObj = (JSONObject) jarray.get(j);
			// String playtype = (String) jsonObj.get("planType");
			// System.out.println("playtype : " + playtype);
			// String apiRank = (String) jsonObj.get("rank");
			// System.out.println("Rank : " + apiRank);
			// String planID = (String) jsonObj.get("planId");
			// System.out.println(planID);
			if(((String)jsonObj.get("rank")).equalsIgnoreCase(String.valueOf(i+1))) {
				rankingOrder.add((String) jsonObj.get("planId"));
				break;
			}
			}
		}
	} catch (ParseException e) {
		e.printStackTrace();
	}
	System.out.println(rankingOrder);
	Assert.assertTrue(rankingOrder.size() == uiPlanCount, "API ranking count is not in sync with plans count");
	return rankingOrder;
}

//Fetching API Ranking Plan details for AEP Years

public List<String> getAEPAPIPlansRanking(String rankingJSON, String Year) {
	int uiPlanCount = Integer.parseInt(planZipInfo.getText().split(" ")[4]);
	List<String> rankingOrder = new ArrayList<String>();
	JSONParser parser = new JSONParser();
	JSONArray jarray = new JSONArray();
	JSONObject jsonObject = null;
	try {
		//jarray = (JSONArray) parser.parse(rankingJSON);
		jsonObject = (JSONObject) parser.parse(rankingJSON);
		if(Year.toLowerCase().equals("future"))
			jarray = (JSONArray) jsonObject.get("plans");
		else if(Year.toLowerCase().equals("current"))
			jarray = (JSONArray) jsonObject.get("prevYearPlans");
		System.out.println("API Plans Count "+jarray.size());
		System.out.println("UI Plans Count "+uiPlanCount);
		for (int i = 0; i < uiPlanCount; i++) {
			// System.out.println(jarray.get(i));
			for(int j=0;j< uiPlanCount;j++)
			{
			JSONObject jsonObj = (JSONObject) jarray.get(j);
			// String playtype = (String) jsonObj.get("planType");
			// System.out.println("playtype : " + playtype);
			// String apiRank = (String) jsonObj.get("rank");
			// System.out.println("Rank : " + apiRank);
			// String planID = (String) jsonObj.get("planId");
			// System.out.println(planID);
			if(((String)jsonObj.get("rank")).equalsIgnoreCase(String.valueOf(i+1))) {
				rankingOrder.add((String) jsonObj.get("planId"));
				break;
			}
			}
		}
	} catch (ParseException e) {
		e.printStackTrace();
	}
	System.out.println(rankingOrder);
	Assert.assertTrue(rankingOrder.size() == uiPlanCount, "API ranking count is not in sync with plans count");
	return rankingOrder;
}


public List<String> getAPIPlansRanking(String rankingJSON, String givenPlanType) {

	List<String> rankingOrder = new ArrayList<String>();
	JSONParser parser = new JSONParser();
	JSONArray jarray = new JSONArray();;
	try {
		jarray = (JSONArray) parser.parse(rankingJSON);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	JSONObject jsonObj = new JSONObject();
	System.out.println(jarray.size());
	System.out.println("GivenPlanType : " + givenPlanType);

	for (int i = 0; i < jarray.size(); i++) {
		// System.out.println(jarray.get(i));
		jsonObj = (JSONObject) jarray.get(i);
		String playtype = (String) jsonObj.get("planType");
		// System.out.println("playtype : " + playtype);

		if (playtype.equalsIgnoreCase(givenPlanType)) {
			String priority = (String) jsonObj.get("priority");
			System.out.println("priority : " + priority);
			jarray = (JSONArray) jsonObj.get("planResponses");
			System.out.println("Total Plans : " + jarray.size());
			if (jarray.size() == 0)
				break;
			for (int j = 0; j < jarray.size(); j++) {
				System.out.println(jarray.get(j));
				jsonObj = (JSONObject) jarray.get(j);
				String apiRank = (String) jsonObj.get("rank");
				System.out.println("Rank : " + apiRank);

				if (Integer.parseInt(apiRank) == j + 1) {
					String planID = (String) jsonObj.get("planId");
					System.out.println(planID);
					rankingOrder.add((String) jsonObj.get("planId"));
				}
				else {
					System.out.println("JSON Ranking Order changed finding accurate Rank...");
					for (int k = 0; k < jarray.size(); k++) {
						//System.out.println(jarray.get(k));
						jsonObj = (JSONObject) jarray.get(k);
						apiRank = (String) jsonObj.get("rank");
						//System.out.println("Rank : " + apiRank);
						if (Integer.parseInt(apiRank) == j + 1) {
							String planID = (String) jsonObj.get("planId");
							System.out.println(planID);
							rankingOrder.add((String) jsonObj.get("planId"));
							break;
						}
					}
				}
			}
			break;
		}
	}
	Assert.assertTrue(rankingOrder.size()==jarray.size(), "API ranking count is not in sync with plans count");
	return rankingOrder;
}


public String getAPIPlansRecommendation(String rankingJSON, String givenPlanType) {
	JSONParser parser = new JSONParser();
	JSONArray jarray = new JSONArray();
	try {
		jarray = (JSONArray) parser.parse(rankingJSON);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	JSONObject jsonObj = new JSONObject();
	String recom = "";
	//System.out.println(jarray.size());
	System.out.println("GivenPlanType : " + givenPlanType);
	for (int i = 0; i < jarray.size(); i++) {
		jsonObj = (JSONObject) jarray.get(i);
		String playtype = (String) jsonObj.get("planType");
		if (playtype.equalsIgnoreCase(givenPlanType)) {
			recom = (String) jsonObj.get("priority");
			System.out.println("priority : " + recom);
			break;
		}
	}
	return recom.trim();
}
int value=1;
public void verifyAPIRankings(List<WebElement> plansId, List<String> APIRankings) {
	List<String> vppPlans = new ArrayList<String>();
	System.out.println(plansId.size());
	for (WebElement e : plansId) {
		int currentPage = Integer.parseInt(pagenoLabel.getText().trim().toLowerCase().replace(" ", "").split("of")[0].replace("page", ""));
		System.out.println("planName in loop count: " +value);
		if(value==(currentPage*3)+1) {
			pageNextButton.click();
			threadsleep(2000);
			}
		threadsleep(2000);
		vppPlans.add(getplanId(e));
		value++;
		}
	for (int i = 0; i < APIRankings.size(); i++) {
		Assert.assertTrue(vppPlans.get(i).toUpperCase().contains(APIRankings.get(i).toUpperCase()),
				"Invalid Plan Ranking between API and UI : " + vppPlans.get(i) + "<-> " + APIRankings.get(i));
	}
	System.out.println("API vs UI Plan Ranking Successful");
}

public String getplanId(WebElement plan) {
	String planName = "";
	String planId="";
	planName = plan.getText().trim();
	threadsleep(3000);
	if(planName.contains("AARP Medicare Supplement Insurance"))
		planId = planName.split("Plan ")[1].trim() + "01";
	else
		planId = plan.getAttribute("href").split("planId=")[1].split("&")[0].trim();
	//System.out.println("UI Plan Name : "+planName);
	System.out.println("planName in loop: " +planId);
	Assert.assertTrue(planId.length()>1, "--- Unable to get the Plan Id ---");
	System.out.println("UI Plan ID : "+planId);
	return planId;
}

public void checkVPP(boolean isPREVPP) {
	if (isPREVPP) {
		try {
			validate(changeZIPVPP, 20);
			System.out.println(changeZIPVPP.getText());
			Assert.assertTrue(false, "Not an Expected PRE->VPP page");
		} catch (Exception e) {
			System.out.println("PRE VPP page displayed");
		}
	} else {
		try {
			System.out.println(planBasedInfo.getText().toUpperCase().contains("BASED"));
			Assert.assertTrue(false, "Not an Expected VPP page");
		} catch (Exception e1) {
			validate(changeZIPVPP, 30);
			System.out.println(changeZIPVPP.getText());
		}
	}
}

public void validateMAPlanNamesSummaryAndDetails() {
	System.out.println("Validating MA Plan Names in result pages : ");
	plansLoader();
	int maPlanCount = Integer.parseInt(MAPlanCount.getText());
	System.out.println(maPlanCount);
	validate(MA1stPlanName, 60);
	verifyPlanNames(MAPlansName, maPlanCount);
	verifyviewplanDetails(MAPlansName, maPlanCount);
	verifyEnrollDetails(MAPlansName, maPlanCount);	
	}

public void validatePDPPlanNamesSummaryAndDetails() {
	System.out.println("Validating PDP Plan Names in result pages : ");
	plansLoader();
	PDPViewPlansLink.click();
	int pdpPlanCount = Integer.parseInt(PDPPlanCount.getText());
	System.out.println(pdpPlanCount);
	validate(PDP1stPlanName, 60);
	verifyviewplanDetails(PDPPlansName, pdpPlanCount);
	verifyEnrollDetails(PDPPlansName, pdpPlanCount);
	plansLoader();
}

public void validateSNPPlanNamesSummaryAndDetails() {
	System.out.println("Validating SNP Plan Names in result pages : ");
	plansLoader();
	SNPViewPlansLink.click();
	int snpPlanCount = Integer.parseInt(SNPPlanCount.getText());
	System.out.println(snpPlanCount);
	validate(SNP1stPlanName, 60);
	verifyPlanNames(SNPPlansName, snpPlanCount);
	verifyviewplanDetails(SNPPlansName, snpPlanCount);
	verifyEnrollDetails(SNPPlansName, snpPlanCount);
}

public void validateSNPPlanName() {
	System.out.println("Validating SNP Plan Names in result pages : ");
	plansLoader();
	verifyPlanNameinOLE();
	browserBack();
	plansLoader();
	browserBack();
	plansLoader();
}

public void verifyPlanNameinOLE() {
	String PlanName= planNameVPPDetailsPage.getText().trim().toUpperCase();
	String planNameinOLE = "";
	enrollBtnPlanDetails.get(0).click();
	pageloadcomplete();
	System.out.println(driver.getCurrentUrl());
	if(validate(planNameEnrollPageExternal)) {
		planNameinOLE = planNameEnrollPageExternal.getText().trim().toUpperCase();
	}else
		planNameinOLE = planNameEnrollPage.getText().trim().toUpperCase(); 
	System.out.println("Plan Name in Plan Enroll Page: "+planNameinOLE);
	Assert.assertTrue(planNameinOLE.contains(PlanName), "--- Plan name are not matches---");	
	System.out.println(driver.getCurrentUrl());
	Assert.assertTrue(driver.getCurrentUrl().contains("online-application.html/welcome"), "OLE page not loaded");
}


public void verifyPlanNames(List<WebElement> plansName, int maPlanCount) {
	List<String> vppPlans = new ArrayList<String>();
	System.out.println(plansName.size());
	for(int i=0;i<maPlanCount;i++) {
			vppPlans.add(verifygetplanName(plansName.get(i)));
	}		
	System.out.println("Plan Name compared Successful Clicks on Plan Name");
}

public String verifygetplanName(WebElement plan) {
	String actualplanName = "";
	scrollToView(plan);
	String exceptedplanName = plan.getText().trim();
	System.out.println("Plan Name in VPP Summary Page: "+exceptedplanName);
	plan.click();
	pageloadcomplete();
	actualplanName = planNameVPPDetailsPage.getText().split("\n")[0];
	System.out.println("Plan Name in VPP Details Page: "+actualplanName);
	Assert.assertTrue(exceptedplanName.contains(actualplanName), "--- Plan name are not matches---");
	backtoPlanSummary.click();
	pageloadcomplete();
	return actualplanName;
}

public String verifyviewplanDetails(List<WebElement> plansName, int PlanCount) {
	WebElement planViewdetailsBut = null;
	String actualplanName = "";
	String exceptedplanName = "";
	for(int i=0;i<PlanCount;i++) {
	scrollToView(plansName.get(i));
    exceptedplanName = plansName.get(i).getText().trim();
    System.out.println("Plan Name in VPP Summary Page: "+exceptedplanName);
    if(exceptedplanName.contains("SNP"))
    	planViewdetailsBut = SNPPlansNames.get(i).findElement(By.cssSelector(".enroll-details a[dtmid='cta_acq_plans_landing']:nth-of-type(1)"));
    else if(exceptedplanName.contains("PDP"))
    	planViewdetailsBut = PDPPlansNames.get(i).findElement(By.cssSelector("#viewmoredetlinkpdp"));
    else
    	planViewdetailsBut = MAPlansNames.get(i).findElement(By.cssSelector(".enroll-details a[dtmid='cta_acq_plans_landing']:nth-of-type(1)"));
	planViewdetailsBut.click();
	pageloadcomplete();
	actualplanName = planNameVPPDetailsPage.getText().split("\n")[0];
	System.out.println("Plan Name in VPP Details Page: "+actualplanName);
	Assert.assertTrue(exceptedplanName.contains(actualplanName), "--- Plan name are not matches---");
	backtoPlanSummary.click();
	pageloadcomplete();
	}
	System.out.println("Plan Name compared Successful Clicks on View Plan Details");
	return actualplanName;
}

public String verifyEnrollDetails(List<WebElement> plansName, int PlanCount) {
	WebElement planViewdetailsBut = null;
	String actualplanName = "";
	String exceptedplanName = "";
	for(int i=0;i<PlanCount;i++) {
		
		if(i>=1) {
			if(actualplanName.contains("PDP"))
				PDPViewPlansLink.click();
			else if ((actualplanName.contains("SNP")) || (actualplanName.contains("Medicare Advantage")))
				break;
		}
		scrollToView(plansName.get(i));
    exceptedplanName = plansName.get(i).getText().trim();
    System.out.println("Plan Name in VPP Summary Page: "+exceptedplanName);
    if(exceptedplanName.contains("SNP"))
    	planViewdetailsBut = SNPPlansNames.get(i).findElement(By.cssSelector(".enroll-details a[dtmid='cta_acq_plans_landing']:nth-of-type(2)"));
    else if(exceptedplanName.contains("PDP"))
    	planViewdetailsBut = PDPPlansNames.get(i).findElement(By.cssSelector("div.enrollment span"));
    else
    	planViewdetailsBut = MAPlansNames.get(i).findElement(By.cssSelector(".enroll-details a[dtmid='cta_acq_plans_landing']:nth-of-type(2)"));
	planViewdetailsBut.click();
	pageloadcomplete();
	actualplanName = planNameEnrollPage.getText().trim(); 
	System.out.println("Plan Name in Plan Enroll Page: "+actualplanName);
	Assert.assertTrue(actualplanName.contains(exceptedplanName), "--- Plan name are not matches---");
//	backtoPlanSummary.click();
	browserBack();
	threadsleep(10000);
	try {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        if(wait.until(ExpectedConditions.alertIsPresent())==null) 
        	System.out.println("alert was not present");
        else {
        	Alert alert = driver.switchTo().alert();
	        alert.accept();
	        System.out.println("alert was present and accepted");
        }
        
    } catch (Exception e) {
        //exception handling
    }
	}
	System.out.println("Plan Name compared Successful Clicks on Enroll Plan");
	return actualplanName;
}

public void browserBack() {

	driver.navigate().back();
	plansLoader();
}

public void useraddDrugsVPP(String drugDetails) {
	threadsleep(10000);
	userPreDCE();
	ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(driver);
	dce.drugsHandlerWithdetails(drugDetails);
	dce.getDrugsDCE();
	dce.choosePharmacyandBacktoPlans();
}

public void userPreDCE() {
	if(validate(MAViewPlansLink,15) ) {
		MAViewPlansLink.click();
	}
	threadsleep(10000);
	drugCoveredeVPP = MA1stPlanList.get(0).findElement(By.cssSelector("a[class*='add-drug']"));
	jsClickNew(drugCoveredeVPP);
}

public boolean changePlanyear(String year) {
	threadsleep(5000);
	if(validate(previousPlanYear, 15) || validate(currentPlanYear, 15)) {
	// Checking and Changing to Current Year
	if (year.equalsIgnoreCase("current")) {
		if (validate(previousPlanYear, 15)) {
			jsClickNew(previousPlanYear);
			Assert.assertTrue(previousPlanYear.getAttribute("aria-selected").contains("true"),"Current Plan Year is not Selected");
			threadsleep(10000);
			System.out.println("Toggling to Current Year");
			return true;
		}
	}

	// Checking and Changing Future Year
	if (year.equalsIgnoreCase("future")) {
		if (validate(currentPlanYear, 15)) {
			jsClickNew(currentPlanYear);
			Assert.assertTrue(currentPlanYear.getAttribute("aria-selected").contains("true"),"Future Plan Year is not Selected");
			threadsleep(5000);
			System.out.println("Toggling to Future Year");
			return true;
		} else {
			Assert.assertTrue(false, "Future Plan Year Toggle is Needed");
		}
	}
	}
	System.out.println("PlanYear Toggle is not displaying in PRE Result page");
	return false;
	}

public boolean checkPlanyear(String year) {
	// Checking Current year selection
	try {
		if (year.equalsIgnoreCase("current")) {
		if (validate(previousPlanYear, 15) && previousPlanYear.getAttribute("aria-selected").contains("true")) {
			return true;
		}
	}
	if (year.equalsIgnoreCase("future")) {
		if (validate(currentPlanYear, 15) && currentPlanYear.getAttribute("aria-selected").contains("true")) {
			return true;
		} else {
			Assert.assertTrue(false, "Future Plan Year Toggle is not available / not selected");
		}
	}
	}catch(Exception e) {
		System.out.println("Exception Occcured Plan year toggle");
	}
	return false;
}


@FindBy(xpath = "//div[@class='switch-field ng-scope']//label[@class='ng-binding'][contains(text(),'2020 plans')]")
private WebElement  CurrentYearPlansBtn;

public VPPPlanSummaryPage handlePlanYearSelectionPRE(String planYear) {

	CommonUtility.checkPageIsReadyNew(driver);			
		if(planYear.equalsIgnoreCase("current")) {				// if the scenario is for current year
			if(validate(CurrentYearPlansBtn, 20)) {
				System.out.println("*****CLICKING ON Current Year button*****: "+CurrentYearPlansBtn.getText());
				jsClickNew(CurrentYearPlansBtn);
				CommonUtility.checkPageIsReadyNew(driver);
			}
		}
		return null;
		
}
PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage =  new PlanRecommendationEngineLandingAndZipcodePages(driver);

public void validateSavePlan(String planInfo, String year) {
	System.out.println("Validate PRE Save Plans functionality");
	String plan = "";
	String[] planslist = planInfo.split(":");
	for (int i = 0; i < planslist.length; i++) {
		plan = planslist[i];
		threadsleep(3000);
		saveplans(plan);
		threadsleep(3000);
		if(i==1) {
			validate(keepshoppingPlansBtn);
			keepshoppingPlansBtn.click();
			threadsleep(3000);
		}
			
	}
	Collections.sort(vppPlans);
	System.out.println(vppPlans);
	threadsleep(3000);
	scrollToView(mySavedItems);
	actions.clickAndHold(mySavedItems).build().perform();
	validate(guestViewSavedBtn);
	guestViewSavedBtn.click();
	verifySavePlans(year, vppPlans);
	verifyPlansVPandPDP(planNamesVisitorPrf);
}


public ArrayList<String> comboPlanNames = new ArrayList<String>();
public void validateCombineSavePlan_old(String year) {
	System.out.println("Validate PRE Save Plans functionality : ");
	int saveplans = 2;
	threadsleep(5000);
	validate(PDPViewPlansLink);
	PDPViewPlansLink.click();
	savecomboplans(PDPPlansName,saveplans, year, PDPPlansSaveIcon);
	validate(keepshoppingPlansBtn);
	keepshoppingPlansBtn.click();
	threadsleep(3000);
	scrollToView(MAViewPlansLink);
	threadsleep(2000);
	MAViewPlansLink.click();
	savecomboplans(MAPlanNames,saveplans, year, MAPlansSaveIcon);
	threadsleep(3000);
	scrollToView(SNPViewPlansLink);
	threadsleep(2000);
	SNPViewPlansLink.click();
	savecomboplans(SNPPlansName,1, year, SNPPlansSaveIcon);
	Collections.sort(comboPlanNames);
	System.out.println(comboPlanNames);
	scrollToView(heartIcon);
	validate(heartIcon);
	heartIcon.click();
	validate(viewSavedItemsBtn);
	viewSavedItemsBtn.click();
	verifySavePlans(year, comboPlanNames);
	verifyPlansVPandPDP(planNamesVisitorPrf);
}

public void viewplanLink(List<WebElement> plansName) {
	if(plansName.get(0).getText().equalsIgnoreCase("Medicare Advantage")) {
		threadsleep(3000);
		scrollToView(MAViewPlansLink);
		validate(MAViewPlansLink);
		MAViewPlansLink.click();
	}else if(plansName.get(0).getText().equalsIgnoreCase("MedicareRx")) {
		threadsleep(3000);
		scrollToView(PDPViewPlansLink);
		validate(PDPViewPlansLink);
		PDPViewPlansLink.click();
	}else if(plansName.get(0).getText().equalsIgnoreCase("UnitedHealthcare")) {
		threadsleep(3000);
		scrollToView(SNPViewPlansLink);
		validate(SNPViewPlansLink);
		SNPViewPlansLink.click();
	}
}
 ArrayList<String> vppPlans = new ArrayList<String>();
public ArrayList<String> saveplans(String plan) {
	int planIndex = planSelectorNewResultspage.findPlan(plan);
	System.out.println("Plans Index is :" +planIndex);
	vppPlans.add(plantiles.get(planIndex).findElement(By.cssSelector(".planName a")).getText().trim());
	threadsleep(3000);
	WebElement planSaveBtn = plantiles.get(planIndex).findElement(By.cssSelector(".enrollSection span.saveButton"));
	scrollToView(planSaveBtn);
	String save = plantiles.get(planIndex).findElement(By.cssSelector(".enrollSection span.saveButton")).getText().trim();;
	if (save.contains("Save") || save.contains("Save Plan")) { 
		threadsleep(3000);
		jsClickNew(planSaveBtn);
	}
	return vppPlans;
}

public ArrayList<String> savecomboplans(List<WebElement> plansName, int saveplans,	String year, List<WebElement> savePlan) {
	System.out.println("Plans Count :" +plansName.size());
	threadsleep(3000);
	for (int plan = 0; plan < saveplans; plan++) {
		comboPlanNames.add(savingplans(plansName.get(plan), savePlan.get(plan)));
	}
	threadsleep(3000);
	return comboPlanNames;
}

public void verifySavePlans(String year, ArrayList<String> vppPlans) {
	threadsleep(3000);
	changePlanyearVisitorProfile(year);
	visitorprofile(planNamesVisitorPrf, vppPlans);
	System.out.println("Plan Name compared Successful Clicks on Save Plan");
}

public void verifyPlansVPandPDP(List<WebElement> plansName) {
	System.out.println("Plan Name in VP Page: " + plansName);
	String actualplanName = "";
	String exceptedplanName = "";
	pageloadcomplete();
	System.out.println(plansName.size());
	for (int i = 0; i < plansName.size(); i++) {
		exceptedplanName = plansName.get(i).getText().trim();
		System.out.println("Plan Name in Visitor Profile Page: " + exceptedplanName);
		plansName.get(i).click();
		threadsleep(30000);
		actualplanName = planNameVPPDetailsPage.getText().split("\n")[0];
		System.out.println("Plan Name in VPP Details Page: "+actualplanName);
		Assert.assertTrue(exceptedplanName.equalsIgnoreCase(actualplanName), "--- Plan name are not matches---");
		planSelectorhomepage.close_Popup();
		backtoProfile.get(0).click();
		pageloadcomplete();	
	}
	System.out.println("Plan Names successfully validated Visitor Profile VS VPP Details Page ");
}

public String savingplans(WebElement plan, WebElement saveplan) {
	scrollToView(plan);
	String exceptedplanName = plan.getText();
	System.out.println("Plan Name in VPP Summary Page: " + exceptedplanName);
	String save = saveplan.getText().trim();
	if (save.equalsIgnoreCase("Save") || save.equalsIgnoreCase("Save Plan")) { 
		threadsleep(3000);
		saveplan.click();
//		jsClickNew(saveplan);
	}
	threadsleep(5000);
	return exceptedplanName;
}

public boolean changePlanyearVisitorProfile(String year) {
	// Checking Current year selection
	if (year.equalsIgnoreCase("current")) {
		if (validate(previousPlanYear, 15)) {
			previousPlanYear.click();
			Assert.assertTrue(previousPlanYear.getAttribute("class").length() > 0,
					"Current Plan Year is not Selected");
			return true;
		}
	}

	// Checking and Changing Future Year
	if (year.equalsIgnoreCase("future")) {
		if (validate(currentPlanYear, 15)) {
			currentPlanYear.click();
			Assert.assertTrue(currentPlanYear.getAttribute("class").length() > 0,
					"Future Plan Year is not Selected");
			return true;
		} else {
			Assert.assertTrue(false, "Future Plan Year Toggle is Needed");
		}
	}
	return false;
}

public void visitorprofile(List<WebElement> plansName, List<String> vppPlans) {
	System.out.println("Plan Name in VPP Page: " + vppPlans);
	String actualplanName = "";
	pageloadcomplete();
	System.out.println(plansName.size());
	for (int i = 0; i < plansName.size(); i++) {
		actualplanName = plansName.get(i).getText().trim();
		System.out.println("Plan Name in Visitor Profile Page: " + actualplanName);
		Assert.assertTrue(vppPlans.contains(actualplanName), "--- Plan name are not matches---");
	}
}

public void validateDrugProvider() {
	System.out.println("Validate Drug and provider details in VP ");
	ArrayList<String> vpdrugs = new ArrayList<String>();
	ArrayList<String> vpProviders = new ArrayList<String>();
	String curID = String.valueOf(Thread.currentThread().getId());
	DrugsInPRE = CommonConstants.PRE_Drugs.get(String.valueOf(Thread.currentThread().getId()));
	System.out.println("**** Current Thread ID is - "+curID+" Drugs in PRE "+DrugsInPRE+" ****");
//	DrugsInPRE = PlanRecommendationEngineDrugsPage.drugNames;
	DocInPRE = CommonConstants.PRE_Providers.get(String.valueOf(Thread.currentThread().getId()));
	System.out.println("**** Current Thread ID is - "+curID+" Provider saved in PRE "+DocInPRE+" ****");
	scrollToView(DrugCount);
	int drgcount =  Integer.parseInt(DrugCount.getText().trim().replace(")", "").replace("(", "").split("&")[0].split("Drugs")[1].trim());
	for(int i=0; i<drgcount;i++) {
		vpdrugs.add(Druglist.get(i).findElement(By.cssSelector("div[id*='DrugName-noplan']")).getText().trim()
				.toUpperCase() + " "
				+ Druglist.get(i).findElement(By.cssSelector("div[id*='DrugQuantityFrequency-noplan']")).getText().trim().replace("per ", "").replace(", refill", "").toUpperCase());
	}
	Collections.sort(vpdrugs);
	System.out.println(vpdrugs);
	verifyConfirmationmodalResults(drgcount,DrugsInPRE,vpdrugs);
//	Assertion.assertTrue(vpdrugs.contains(drugs.toUpperCase()), "--- Drug name are not matches---");
	threadsleep(3000);
	
	int prdcount =  Integer.parseInt(ProviderCount.getText().trim().replace(")", "").replace("(", "").split("Providers")[1].trim());
	for(int i=0; i<prdcount;i++) {
		vpProviders.add(Providerlist.get(i).findElement(By.cssSelector("div[id*='ProviderName-noplan']")).getText().toUpperCase());
	}
	Collections.sort(vpProviders);
	System.out.println(vpProviders);
	verifyConfirmationmodalResults(prdcount,DocInPRE,vpProviders);
//	Assertion.assertTrue(vpProviders.contains(doctors.toUpperCase()), "--- Doctors name are not matches---");
	threadsleep(3000);
	System.out.println("Drug and provider details successfully validated in VP ");
	System.out.println("Validate Pharamacy details in VP ");
	Pharmacytype();
	scrollToView(Addplans);
	jsClickNew(Addplans);
	threadsleep(8000);
	Assert.assertTrue(driver.getCurrentUrl().contains("/plan-summary"), "--- VPP Summary not loaded---");
}

public void Pharmacytype() {
	threadsleep(5000);
	int count = Druglist.size();
	Assert.assertTrue(Druglist.get(count-1).findElement(By.cssSelector("span")).getText().trim().contains("OptumRx Mail Service Pharmacy"), "Pharmacy is not default online");    			
}

public void navigatePRE(HashMap<String, String> inputdata) {
	System.out.println("Navigating PRE from External Site ");
	String curWindow = driver.getWindowHandle();
	String site = inputdata.get("Site Name");
	System.out.println(curWindow);
	if (site.equalsIgnoreCase("Myuhcplans")) {
		validate(GetHelpFindingaPlanBtn);
		GetHelpFindingaPlanBtn.click();
		PREStage(curWindow, site);
	}
	if (site.equalsIgnoreCase("uhcandwellmedsa")) {
		validate(HelpMeChooseBtn);
		HelpMeChooseBtn.click();
		PREStage(curWindow, site);
	}
	if (site.equalsIgnoreCase("mauhcmedicaresolutions") || site.equalsIgnoreCase("maaarpmedicareplans")) {
		if(validate(modelclose))
			modelclose.click();
		validate(startNowBtn);
		startNowBtn.click();
		PREStage(curWindow, site);
	}
	if (site.equalsIgnoreCase("uhcmedicaresolutions") || site.equalsIgnoreCase("aarpmedicareplans")) {
		navigateVPP(inputdata);
		vppToPre();
		PREStage(curWindow, site);
	}
}

public void PREStage(String primaryWindow, String aarp) {
	ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
	System.out.println(windows);
	if (windows.size() == 2) {
		for (String window : windows) {
			System.out.println(window.replace("CDwindow-", ""));
			if (!window.equals(primaryWindow)) {
				driver.switchTo().window(window);
				System.out.println(driver.getCurrentUrl());
				Assert.assertTrue(driver.getCurrentUrl().contains("/plan-recommendation-engine.html"), "PRE is not loading");
			}
			if(aarp.contains("aarpmedicareplans")) {
				driver.navigate().to("https://www.stage-aarpmedicareplans.uhc.com/plan-recommendation-engine.html");
			}
			else
				driver.navigate().to("https://www.stage-uhcmedicaresolutions.uhc.com/plan-recommendation-engine.html");
				driver.navigate().to("https://steelcase.stage-uhcmedicaresolutions.uhc.com/plan-recommendation-engine.html");
			}
	}
	threadsleep(5000);
//	driver.switchTo().window(primaryWindow);
}

public void validatePDPPlanNamesAndEnroll() {
	System.out.println("Validating PDP Plan Names in Details pages : ");
	plansLoader();
	verifyPlanNameinOLE();
}

public void validatePDPPlanNamesAndEnroll_old() {
	System.out.println("Validating PDP Plan Names in Details pages : ");
	plansLoader();
	int pdpPlanCount = Integer.parseInt(PDPPlanCount.getText());
	System.out.println(pdpPlanCount);
	validate(PDP1stPlanName, 60);
	String exceptedplanName = PDPPlansName.get(0).getText().split("\n")[0].trim().toUpperCase();
	System.out.println("Plan Name in VPP Summary Page: "+exceptedplanName);
	WebElement planViewdetailsBut = PDPPlansNames.get(0).findElement(By.cssSelector("#viewmoredetlinkpdp"));
	planViewdetailsBut.click();
	pageloadcomplete();
	String actualplanName = planNameVPPDetailsPage.getText().split("\n")[0].toUpperCase();
	System.out.println("Plan Name in VPP Details Page: "+actualplanName);
	Assert.assertTrue(exceptedplanName.equalsIgnoreCase(actualplanName), "--- Plan name are not matches---");
	enrollBtnPlanDetails.get(0).click();
	pageloadcomplete();
	String planNameinOLE = planNameEnrollPage.getText().trim().toUpperCase(); 
	System.out.println("Plan Name in Plan Enroll Page: "+planNameinOLE);
	Assert.assertTrue(planNameinOLE.contains(exceptedplanName), "--- Plan name are not matches---");	
	System.out.println(driver.getCurrentUrl());
	Assert.assertTrue(driver.getCurrentUrl().contains("online-application.html/welcome"), "OLE page not loaded");
	nxtBtnOLEPage.click();
	System.out.println(driver.getCurrentUrl());
	Assert.assertTrue(driver.getCurrentUrl().contains("online-application.html/steps"), "OLE page not loaded");
}

public void validateMAPlanNamesPlanCompare() {
    System.out.println("Validating MA Plan Names in plan compare pages : ");
    plansLoader();
    int maPlanCount = 2;
    System.out.println(maPlanCount);
    validate(MA1stPlanName, 60);
    verifyPlanNamesComparePage(MAPlansName, maPlanCount,MAPlansCompareBox);
    }

 

public void verifyPlanNamesComparePage(List<WebElement> plansName, int maPlanCount,List<WebElement> plansNameCompare) {
    List<String> vppPlans = new ArrayList<String>();
    List<String> comparepagePlans = new ArrayList<String>();
    System.out.println(plansName.size());
    for(int i=0;i<maPlanCount;i++) {
            vppPlans.add(verifyplanNameCompare(plansName.get(i), plansNameCompare.get(i)));
    }
    MAPlansCompareButton.get(0).click();
    pageloadcomplete();
    Assert.assertTrue(driver.getCurrentUrl().contains("plan-compare"),"Page is not navigated to Plan Compare page");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    for (WebElement elem : planNamesOnlyComparepage) {
        String planName = (String) js.executeScript("return arguments[0].innerText;", elem);
        String val = planName.trim().toUpperCase();
        comparepagePlans.add(val);
    }
    System.out.println("Original Plan Orders" + comparepagePlans);
    vppPlans.equals(comparepagePlans);
    System.out.println("Plan Name compared Successful Clicks on Plan Name");
}

 

public String verifyplanNameCompare(WebElement plan,WebElement planCompare) {
    scrollToView(plan);
    String exceptedplanName = plan.getText().trim().toUpperCase();
    System.out.println("Plan Name in VPP Summary Page: "+exceptedplanName);
    planCompare.click();
    pageloadcomplete();
    return exceptedplanName;
}

public void ValidatePREWithoutMSPlan(String userType) {
	System.out.println("Checking PRE widget in VP without MS Plan saving...");
	validate(PRESection, 30);
	PRESection.click();
	if (userType.equalsIgnoreCase("Guest")) {
		validate(SavedRecomTitle, 30);
		validate(PRETitleinVP, 30);
		validate(GetStartedButton, 30);
		validate(PREImage, 30);
	} else {
		validate(SavedRecomTitle, 30);
		validate(PREImage, 30);
		validate(EditMyResponsesLink, 30);
	}
}

public void ValidatePREWithMSPlan() {
	System.out.println("Checking PRE widget in VP with MS Plan saving...");
	if (!validate(PRESection, 30) || !validate(SavedRecomTitle, 30)) {
		System.out.println("PRE widget is not displaying in VP...");
		removeMSplaninVP();
	} else
		System.out.println("PRE widget is displaying in VP. Since its not having MS Plan...");

}

public void removeMSplaninVP() {
	System.out.println("Deleting MS Plan in VP");
	threadsleep(3000);
	if (validate(MSPlanSection, 20)) {
		scrollToView(MSPlanSection);
		int MScount = MSPlansCount.size();
		for (int i = 0; i < MScount; i++) {
			MSPlanName.get(i).getText();
			MSPlanRemoveIcon.get(i).click();
			threadsleep(2000);
		}
	} else
		System.out.println("MS Plan not found in VP");
}

public void SavingMsplan() {
	System.out.println("Saving MS plan in PRE...");
	if (validate(MSViewPlansLink)) {
		MSViewPlansLink.click();
		threadsleep(5000);
	}
	submitMSform();
	threadsleep(2000);
	validate(MS1stPlanSaveImg, 20);
	MS1stPlanSaveImg.click();
}

public boolean click_ViewPlanLink(WebElement plantype) {
	boolean viewlink_presents = false;
	System.out.println("Checking viewlink Status...");
	if(validate(plantype, 20)) {
		threadsleep(1000);
		jsClickNew(plantype);
		threadsleep(1000);
		viewlink_presents = true;
	}
	return viewlink_presents;
}

public void validateLinks(String function) {
	if(function.equalsIgnoreCase("EditMyResponse button")) {
	validate(EditMyResponsesLink, 10);
	EditMyResponsesLink.click();
	Assert.assertTrue(driver.getCurrentUrl().contains("/plan-recommendation-engine.html/editMyPreferences"), "***Edit My Response Page Not Opened***");
	}else if(function.equalsIgnoreCase("Enroll In Plan")) {
		String planName = FirstRecommendationSectionPlanName.getText().trim();
		validate(FirstRecommendationSectionEnrollToPlanButton, 10);
		FirstRecommendationSectionEnrollToPlanButton.click();
		Assert.assertTrue(driver.getCurrentUrl().contains("online-application.html/welcome"), "***OLE Page Not Opened***");
		Assert.assertTrue(planNameEnrollPage.getText().trim().contains(planName), "PlanName Invalid in OLE");
	}else if(function.equalsIgnoreCase("View Plan Details")) {
		String planName = FirstRecommendationSectionPlanName.getText().trim();
		validate(FirstRecommendationSectionViewPlanDetails, 10);
		FirstRecommendationSectionViewPlanDetails.click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/details"), "***Plan Details Page Not Opened***");
		Assert.assertTrue(planNameinPlanDetailsPage.getText().trim().contains(planName), "PlanName Invalid in PlanDetailsPage");
	}else if(function.equalsIgnoreCase("View ranked list of plans")) {
		validate(ViewRankedListOfPlanLinks, 10);
		ViewRankedListOfPlanLinks.click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/plan-recommendation-engine.html#/result"), "***PRE-Result Page Not Opened***");
	}
}


}


