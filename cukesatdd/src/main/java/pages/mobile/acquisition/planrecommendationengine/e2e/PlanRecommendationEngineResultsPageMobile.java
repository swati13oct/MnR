/**
* 
 */
package pages.mobile.acquisition.planrecommendationengine.e2e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.acquisition.planRecommendationEngine.PlanRecommendationEngineStepDefinition;
import acceptancetests.data.PageConstants;
import acceptancetests.mobile.acquisition.planrecommendationengine.e2e.PlanRecommendationStepDefinitionMobile;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.planRecommendationEngine.ACQDrugCostEstimatorPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineCommonutility;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDrugsPage;

import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;

import pages.mobile.acquisition.planrecommendationengine.DoctorsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DrugMobilePage;

public class PlanRecommendationEngineResultsPageMobile extends UhcDriver {

	public PlanRecommendationEngineResultsPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String flow;
	ArrayList<String> DrugsInPRE;
	ArrayList<String> DrugsInDCE;
	ArrayList<String> DrugsList = new ArrayList<String>();
	ArrayList<String> ModelDrugsList = new ArrayList<String>();
	static ArrayList<String> werallyResults = new ArrayList<String>();
	static ArrayList<String> vppResults = new ArrayList<String>();
	static ArrayList<String> vppProviderResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults1 = new ArrayList<String>();
	static ArrayList<String> confirmationProviderResults = new ArrayList<String>();
	public WebElement drugCoveredeVPP;
	PlanRecommendationEngineDrugsPage drug = new PlanRecommendationEngineDrugsPage(driver);

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;
	
	@FindBy(css = ".footer-top>ul>li>a.back-to-top")
	public WebElement footerBackToTopLink;

	// Results loading page Elements

	@FindBy(css = "#loadingText")
	private WebElement resultsloadingTitle;

	@FindBy(css = ".loading-container .container>div>div>div:nth-of-type(2)>img")
	private WebElement svgAnimation;

	@FindBy(css = "div>img[alt*='Loading Plan Recommendations']")
	private WebElement loadingImage;

	// Result Page Elements

	@FindBy(css = ".plan-overview-wrapper>div[class='overview-main'] h2")
	private WebElement planZipInfo;

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

	@FindBy(xpath = "//a[@aria-describedby='recommendation_ms']")
	private WebElement msPlanview;

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

	@FindBy(xpath = "//a[contains(text(),'Back to plan results') and @href='#']")
	private WebElement BackToPlanResultsLink;

	@FindBy(css = "#mainBody .swiper-container .module-plan-overview:nth-of-type(1)")
	private WebElement MS1stPlan;

	@FindBy(css = "#mainBody .swiper-container .module-plan-overview:nth-of-type(1) h2")
	private WebElement MS1stPlanName;

	@FindBy(css = "#mainBody .swiper-container .module-plan-overview:nth-of-type(2) .swiper-content .apply-button")
	private WebElement MS1stPlanEnroll;

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

	@FindBy(css = "#emailSuccessSummaryMsgPopUp #emailSuccess")
	private WebElement emailSuccess;

	@FindBy(css = "#emailSuccessSummaryMsgPopUp button")
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

	// Provider and Drug Details in Plan Type

	@FindBy(css = "#plan-list-1 div.module-plan-overview")
	private List<WebElement> MA1stPlanList;

	@FindBy(css = "#plan-list-1 div.module-plan-overview:nth-child(1) .drugs-list div[class*='drug-info-container']")
	private List<WebElement> DrugsNames;

	@FindBy(xpath = "//*[contains(@class,'get-started-banner')]//button[contains(text(),'Get Started')]")
	private WebElement StartNowButton;

	// Start Over Popup

	@FindBy(css = "#plan-list-1 .plan-list-content #editMyAnswers")
	private WebElement StartOverButton;

	@FindBy(css = "#startoverdetails")
	private WebElement StartOverDetails;

	@FindBy(xpath = "//a[@aria-describedby='recommendation_ma']")
	private WebElement MAPDLink;

	@FindBy(css = "#startOverContent")
	private WebElement StartOverContent;

	@FindBy(css = "#closestartoverpopup")
	private WebElement closeButton;

	@FindBy(css = "#startoverPopUp button[class*='cta-button sendbtn']")
	private WebElement startOverButtoninPopup;

	@FindBy(xpath = "//*[contains(@class,'get-started-banner')]//button[contains(text(),'Get Started')]")
	private WebElement getStartedBtn;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(xpath = "//*[contains(@id,'zipcodemeded')]")
	private WebElement homePageZiptxt;

	@FindBy(css = "#ghn_lnk_1>span")
	private WebElement headerNavigationBarHomeTab;

	@FindBy(xpath = "//span[text()='Get Started']")
	private WebElement homePageFindPlans;

	// Zipcode Page

	@FindBy(xpath = "//*[@id='zip-code']")
	private WebElement zipCode;

	@FindBy(css = "#selectCounty")
	private WebElement multiCountyDialog;

	@FindBy(css = "#selectCounty p a")
	private List<WebElement> multiCounty;

	@FindBy(id = "zipInfo")
	private WebElement countyInfo;

	@FindBy(id = "MultipleCounty")
	private WebElement multiCountyInfo;

	// VPP Details page

	@FindBy(css = ".uhc-container div.content h2")
	private WebElement planNameVPPDetailsPage;

	@FindBy(id = "backToPlanSummaryTop")
	private WebElement backtoPlanSummary;

	@FindBy(css = ".segment h2")
	private WebElement planNameEnrollPage;

	@FindBy(css = "label[for='currentYear']")
	private WebElement currentPlanYear;

	@FindBy(css = "label[for='futureYear']")
	private WebElement futurePlanYear;

	@FindBy(css = "input#futureYear[class*='selected']")
	private WebElement futurePlanYearSelected;

	@FindBy(css = "input#currentYear[class*='selected']")
	private WebElement currentPlanYearSelected;

	@FindBy(xpath = "//span[contains(text(),'Add My Drugs')]")
	private WebElement adddrugbtn;

	// Result Loading Page Element Verification Method

	public void resultsloadingpage() {
		System.out.println("Validating Results loading Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(resultsloadingTitle);
		validate(svgAnimation, 30);
		validate(loadingImage, 30);
	}

	// Results Page Element Verification Method

	public void resultsUI(String zip, String county, String R1, String R2, boolean tie) {
		System.out.println("Validating Results UI Page: ");
		pageloadcomplete();

		validate(planZipInfo, 60);
		waitforElementInvisibilityInTime(planLoaderscreen, 60);
		Assert.assertTrue(planZipInfo.getText().contains(zip), "Invalid Zip");
		Assert.assertTrue(planZipInfo.getText().toUpperCase().contains(county.toUpperCase()), "Invalid County");
		Assert.assertTrue(Integer.parseInt(planZipInfo.getText().split(" ")[2]) > 0, "Total Plan count is less than 1");
		String recom = "Recommended";
		String recom1 = "#1 Recommendation";
		String recom2 = "#2 Recommendation";
		if (tie == false) {
			Assert.assertTrue(planBasedInfo.getText().toUpperCase().contains("BASED"), "Text box is not availabe");
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

	public void validateZipcodePage(String zip, String county, String isMultiCounty) {
		System.out.println("Validating Zipcode and County in location Page");
		pageloadcomplete();
		validateNew(getStartedBtn, 10);
		if (getStartedBtn.isDisplayed()) {
			jsClickNew(getStartedBtn);
			Assert.assertTrue(zipCode.getAttribute("ng-reflect-model").contains(zip), "Invalid Zip");
			if (isMultiCounty.equalsIgnoreCase("NO")) {
				validate(countyInfo, 20);
				Assert.assertTrue(countyInfo.getText().toUpperCase().contains(county.toUpperCase()), "Invalid County");
			} else {
				validate(multiCountyInfo, 20);
				Assert.assertTrue(multiCountyInfo.getText().toUpperCase().contains(county.toUpperCase()),
						"Invalid County");
			}
			// continueBtn.click();
			jsClickNew(continueBtn);

		} else {

			Assert.assertTrue(zipCode.getAttribute("ng-reflect-model").contains(zip), "Invalid Zip");
			if (isMultiCounty.equalsIgnoreCase("NO")) {
				validate(countyInfo, 20);
				Assert.assertTrue(countyInfo.getText().toUpperCase().contains(county.toUpperCase()), "Invalid County");
			} else {
				validate(multiCountyInfo, 20);
				Assert.assertTrue(multiCountyInfo.getText().toUpperCase().contains(county.toUpperCase()),
						"Invalid County");
			}
			// continueBtn.click();
			jsClickNew(continueBtn);

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
		if (MSPlanInfo.getText().contains(rcom1))
			R1Count++;
		if (PDPPlanInfo.getText().contains(rcom1))
			R1Count++;
		if (SNPPlanInfo.getText().contains(rcom1))
			R1Count++;
		if (MAPlanInfo.getText().contains(rcom2))
			R2Count++;
		if (MSPlanInfo.getText().contains(rcom2))
			R2Count++;
		if (PDPPlanInfo.getText().contains(rcom2))
			R2Count++;
		if (SNPPlanInfo.getText().contains(rcom2))
			R2Count++;
		Assert.assertTrue(R1Count == 1, "#1Recommendation presents more than once");
		if (R2.isEmpty() || R2 == "")
			Assert.assertTrue(R2Count == 0, "#2Recommendation presents");
		else
			Assert.assertTrue(R2Count == 1, "#2Recommendation presents more than once or not available");
	}

	public void validateRecommendationPlan(String R1) {
		String currentPageUrl = driver.getCurrentUrl();
		boolean isDSNP = true;
		if (R1.equalsIgnoreCase("MA")) {
			// MAViewPlansLink.click();
			validate(MA1stPlanName, 60);
			// Assert.assertTrue(MA1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),
			// "MA Invalid Plan Ranking");
			// mobileUtils.mobileLocateElementClick(MA1stPlanEnroll);
			// clickEnrolldesktop(MA1stPlanEnroll);
		}
		if (R1.equalsIgnoreCase("MS")) {
			// MSViewPlansLink.click();
			submitMSform();
			validate(MS1stPlanName, 60);
			// Assert.assertTrue(MS1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),"MS
			// Invalid Plan Ranking");
			// mobileUtils.mobileLocateElementClick(MS1stPlanEnroll);
			clickEnrolldesktop(MS1stPlanEnroll, needhelptxtMS);
		}
		if (R1.equalsIgnoreCase("PDP")) {
			// PDPViewPlansLink.click();
			validate(PDP1stPlanName, 60);
			// Assert.assertTrue(PDP1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),"PDP
			// Invalid Plan Ranking");
			// mobileUtils.mobileLocateElementClick(PDP1stPlanEnroll);
			// clickEnrolldesktop(PDP1stPlanEnroll);
		}
		if (R1.equalsIgnoreCase("SNP")) {
			// SNPViewPlansLink.click();
			validate(SNP1stPlanName, 60);
			// Assert.assertTrue(SNP1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),"SNP
			// Invalid Plan Ranking");
			// mobileUtils.mobileLocateElementClick(SNP1stPlanEnroll);
			if (SNP1stPlanName.getText().toUpperCase().contains("D-SNP"))
				clickEnrolldesktop(SNP1stPlanEnroll, needhelptxt);
			else
				isDSNP = false;
		}
		threadsleep(5000);
		pageloadcomplete();
		if (isDSNP)
			Assert.assertTrue(currentPageUrl != driver.getCurrentUrl(), "Enroll Plan URL is not working");
	}

	// Filling MS form with default value
	public void submitMSform() {
		// Zip value is pre-populated by default
		// MSPlanDOB.sendKeys("01/06/1940");
		// msPlanview.click();
		jsClickNew(msPlanview);
		jsSendkeys(MSPlanDOB, "01/06/1940");
		jsClickNew(MSPlanGender);
		threadsleep(8000);
		jsClickNew(MSPlanGender);
		Select temp = new Select(MSPlanPartAMonth);
		temp.selectByVisibleText("January 1");
		temp = new Select(MSPlanPartAYear);
		temp.selectByVisibleText("2021");
		temp = new Select(MSPlanPartBMonth);
		temp.selectByVisibleText("January 1");
		temp = new Select(MSPlanPartBYear);
		temp.selectByVisibleText("2021");
		temp = new Select(MSPlanStartMonth);
		// temp.selectByVisibleText("February 1, 2021");
		temp.selectByIndex(1);
		jsClickNew(MSViewPlanButton);
		// E2E Mobile specific code
		jsClickNew(BackToPlanResultsLink);
	}

	public void clickEnrolldesktop(WebElement enrollButton, WebElement needhelp) {
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
		if (R1 == "")
			Assert.assertTrue(RCount == 0, "Recommendation Count is not equal to Zero");
		else if (R2 == "")
			Assert.assertTrue(RCount == 1, "Recommendation Count is not equal to One");
		else
			Assert.assertTrue(RCount == 2, "Recommendation is not equals to Two");
	}

	public void navigateVPP(String zip) {
		validate(headerNavigationBarHomeTab, 20);
		jsClickNew(headerNavigationBarHomeTab);
		validate(homePageZiptxt, 60);
		homePageZiptxt.sendKeys(zip);
		jsClickNew(homePageFindPlans);
		validate(planZipInfo, 60);
		if (MRScenario.mobileDeviceOSName.equalsIgnoreCase("IOS")) {
			waitforElementInvisibilityInTime(planLoaderscreen, 60);
		} else
			threadsleep(5000);// Plan loader
		Assert.assertTrue(planZipInfo.getText().contains(zip), "Invalid Zip");
		jsClickNew(MAViewPlansLink);
		pageloadcomplete();

	}

	public void drugsDetailsPREtoVPP() {
		System.out.println("Validating PRE Drugs Details in VPP Page Plan Type: ");
		DrugsInPRE = PlanRecommendationEngineDrugsPage.drugNames;
		int count = DrugsInPRE.size();
		drugsCoveredInVPP(count);
		verifyConfirmationmodalResults(count, DrugsInPRE, DrugsList);
	}

	public void removedDrugsDetailsVPPtoPRE() {
		System.out.println("Validating removed Drugs Details from VPP to PRE Drug Page: ");
		String plantype = PlanRecommendationStepDefinitionMobile.PlanType;

		flow = PlanRecommendationStepDefinitionMobile.PREflow;
		DrugsInPRE = PlanRecommendationEngineDrugsPageMobile.drugNames;
		boolean remove = true;
		int count = DrugsInPRE.size();
		drugsCoveredInVPP(count, plantype);
		removeDrugs(count);
		// vppToPre();
		MobileMenuAndGetPlanRecom();
		validateDrugPage(flow, true);

	}

	public void startnowtilldrugs() {
		System.out.println("Navigating to PRE Using StartNow: ");
		flow = PlanRecommendationEngineStepDefinition.PREflow;
		MobileMenuAndGetPlanRecom();
		// vppToPre();
		validateDrugPage(flow, false);
	}

	public void DrugsDetailsVPPtoPRE() {
		System.out.println("Validating Drugs Details from DCE to VPP Drug Page: ");

		ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(driver);
		DrugsInDCE = dce.vppDrugsResults;
		int count = DrugsInDCE.size();
		drugsCoveredInVPP(count);
		verifyConfirmationmodalResults(count, DrugsInDCE, DrugsList);
		System.out.println("Validating Drugs Details from VPP to PRE Drug Page: ");
		MobileMenuAndGetPlanRecom();
		// vppToPre();
	}

	public void removeDrugs(int count) {
		// By default removing 2nd drug
		int beforeRemove = DrugsList.size();
		threadsleep(5000);
		drugcoveredsession();
		// DrugsNames.get(count-1).findElement(By.cssSelector("button[class*='remove-icon']")).click();
		jsClickNew(DrugsNames.get(count - 1).findElement(By.cssSelector("button[class*='remove-icon']")));
		threadsleep(8000);
		// drugcoveredsession();
		pageloadcomplete();
		drugcoveredsession();
		drugsCoveredInVPP(count - 1);
		int afterRemove = DrugsList.size();
		if (beforeRemove != afterRemove) {
			System.out.println("Remove Results Count mismatch");

		} else {
			System.out.println("Remove Results Count matching and Remove is not removed");
			Assert.assertTrue(false);
		}
	}

	@FindBy(xpath = "//a[@aria-describedby='recommendation_ma']")
	private WebElement maPlansViewLink;

	public ArrayList<String> drugsCoveredInVPP(int count) {
		System.out.println("Clicking on Drugs Details in Plan Type: " + count);
		DrugsList = new ArrayList<String>();
		validate(MAPlanCount, 60);
		WebElement drugImageVPP = MA1stPlanList.get(0).findElement(By.cssSelector("a[class*='drug-list-toggle'] img"));
		validate(drugImageVPP, 20);
		threadsleep(5000);
		drugcoveredsession();

		for (int i = count - 1; i >= 0; i--) {
			threadsleep(1000);
			DrugsList.add(
					DrugsNames.get(i).findElement(By.cssSelector("div[class*='flex-col drug-info'] span:nth-child(1)"))
							.getText().trim().toUpperCase()
							+ " "
							+ DrugsNames.get(i)
									.findElement(By.cssSelector("div[class*='flex-col drug-info'] span:nth-child(2)"))
									.getText().trim().replace("Qty ", "").toUpperCase());
			WebElement RemoveIcon = DrugsNames.get(i).findElement(By.cssSelector("button[class*='remove-icon']"));
			WebElement coveredIcon = MA1stPlanList.get(i).findElement(By.cssSelector(".drugs-list div[id*='Covered']"));
			validate(RemoveIcon, 20);
			validate(coveredIcon, 20);
		}
		Collections.sort(DrugsList);
		jsClickNew(drugCoveredeVPP);
		System.out.println("DrugsList Size is : " + DrugsList.size());
		System.out.println("DrugList Content is : " + DrugsList);
		return DrugsList;
	}

	public ArrayList<String> drugsCoveredInVPP(int count, String plantype) {
		System.out.println("Clicking on Drugs Details in Plan Type: " + count);
		DrugsList = new ArrayList<String>();
		validate(MAPlanCount, 60);
		WebElement drugImageVPP = MA1stPlanList.get(0).findElement(By.cssSelector("a[class*='drug-list-toggle'] img"));
		validate(drugImageVPP, 20);
		threadsleep(5000);
		drugcoveredsession();

		if (plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("MA")) {
			jsClickNew(MAViewPlansLink);
		}

		for (int i = count - 1; i >= 0; i--) {
			threadsleep(1000);
			DrugsList.add(
					DrugsNames.get(i).findElement(By.cssSelector("div[class*='flex-col drug-info'] span:nth-child(1)"))
							.getText().trim().toUpperCase()
							+ " "
							+ DrugsNames.get(i)
									.findElement(By.cssSelector("div[class*='flex-col drug-info'] span:nth-child(2)"))
									.getText().trim().replace("Qty ", "").toUpperCase());
			WebElement RemoveIcon = DrugsNames.get(i).findElement(By.cssSelector("button[class*='remove-icon']"));
			WebElement coveredIcon = MA1stPlanList.get(i).findElement(By.cssSelector(".drugs-list div[id*='Covered']"));
			validate(RemoveIcon, 20);
			validate(coveredIcon, 20);
		}
		Collections.sort(DrugsList);
		jsClickNew(drugCoveredeVPP);
		System.out.println("DrugsList Size is : " + DrugsList.size());
		System.out.println("DrugList Content is : " + DrugsList);
		return DrugsList;
	}

	private MRScenario getLoginScenario() {
		// TODO Auto-generated method stub
		return null;
	}

	public void drugcoveredsession() {
		drugCoveredeVPP = MA1stPlanList.get(0).findElement(By.cssSelector("a[class*='drug-list-toggle']"));
		jsClickNew(drugCoveredeVPP);
	}

	public void verifyConfirmationmodalResults(int count, ArrayList<String> drug, ArrayList<String> drugListVPP) {
		if (drug.size() == drugListVPP.size() && count == drug.size()) {
			String druglist = drug.toString().toUpperCase();
			String vppdruglist = drugListVPP.toString().toUpperCase();
			if (druglist.contains(vppdruglist)) {
				System.out.println("Drug and Modal Result's Content matched");
			} else {
				System.out.println("Drug and Modal Result's Content mismatch");
				Assert.assertTrue(false);
			}
		} else {
			System.out.println("Drug and Modal Results Count mismatch");
			Assert.assertTrue(false);
		}

		if (drug.size() == drugListVPP.size() && count == drug.size()) {
			String druglist = drug.toString();
			String vppdruglist = drugListVPP.toString();
			if (druglist.equalsIgnoreCase(vppdruglist)) {
				System.out.println("Drug and Modal Result's Content matched");
			} else {
				System.out.println("Drug and Modal Result's Content mismatch");
				Assert.assertTrue(false);
			}
		} else {
			System.out.println("Drug and Modal Results Count mismatch");
			Assert.assertTrue(false);
		}
	}

	public void vppToDCE() {
		System.out.println("Validating VPP to DCE Page");
		WebElement drugSummary = MA1stPlanList.get(0).findElement(By.cssSelector("a.add-drug"));
		validate(drugSummary, 20);
		Assert.assertTrue(drugSummary.getText().contains("Enter drug information"),
				"Enter drug information link is not available");
		jsClickNew(drugSummary);
		pageloadcomplete();
		Assert.assertTrue(driver.getCurrentUrl().contains("drug-cost-estimator"), "Page is not navigated to DCE");

	}

	public void vppToPre() {
		System.out.println("Validating VPP to PRE Page");
		MobileMenuAndGetPlanRecom();
		validate(StartNowButton, 20);
		jsClickNew(StartNowButton);
		validateNew(continueBtn, 5);
		pageloadcomplete();

	}

	public void validateDrugPage(String plan, boolean removedrug) {
		System.out.println("Validating Drugs in Drug Page");

		scrollToView(getStartedBtn);
		jsClickNew(getStartedBtn);
		threadsleep(2000);
		int MAPD = 6;
		int PDP = 3;
		int None = 6;
		if (plan.equalsIgnoreCase("MAPD")) {
			for (int i = 0; i < MAPD; i++) {
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();

			}
		} else if (plan.equalsIgnoreCase("None")) {
			for (int i = 0; i < None; i++) {
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();

			}
		} else if (plan.equalsIgnoreCase("PDP")) {
			for (int i = 0; i < PDP; i++) {
				// continueBtn.click();
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();

			}
		}
		if (removedrug == true) {
			DrugsList = DrugsList;
		} else {
			DrugsList = drug.drugNames;
		}
		ModelDrugsList = drug.drugnamesList();
		System.out.println("DrugsList Size is : " + DrugsList.size());
		System.out.println("ModelDrugsList Size is : " + ModelDrugsList.size());
		verifyConfirmationmodalResults(DrugsList.size(), DrugsList, ModelDrugsList);
	}

	public void startNowFullFlow(String plan) {
		System.out.println("Validating Start Now Full flow in PRE");
		int MAPD = 1;
		int PDP = 2;
		int None = 1;
		if (plan.equalsIgnoreCase("MAPD")) {
			for (int i = 0; i < MAPD; i++) {
				// continueBtn.click();
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();
			}
		} else if (plan.equalsIgnoreCase("None")) {
			for (int i = 0; i < None; i++) {
				// continueBtn.click();
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();
			}
		} else if (plan.equalsIgnoreCase("PDP")) {
			for (int i = 0; i < PDP; i++) {
				// continueBtn.click();
				jsClickNew(continueBtn);
				threadsleep(2000);
				pageloadcomplete();
			}
		}
	}

	PlanRecommendationEngineDoctorsPageMobile docdesktop = new PlanRecommendationEngineDoctorsPageMobile(driver);
	int count = 1;

	public void addProviderVPP(String name, String multi) {
		// MAViewPlansLink.click();
		String curdriverhandle = driver.getWindowHandle();
		// enterProvidersInfoMA1stPlan.click();
		jsClickNew(enterProvidersInfoMA1stPlan);
		if (multi.equalsIgnoreCase("Yes"))
			count = 1;
		werallyResults = docdesktop.validateLinksanotherWindow(curdriverhandle, "Doctors", name, count);
		ArrayList<String> vppResults = getProvidersVPP();
		Assert.assertTrue(vppResults.size() == count, "Providers count mismatch in VPP");
	}

	public ArrayList<String> getProvidersVPP() {
		threadsleep(5000);
		pageloadcomplete();
		// providersInfoMA1stPlan.click();
		jsClickNew(providersInfoMA1stPlan);
		vppProviderResults = new ArrayList<String>();
		for (WebElement e : providersListMA1stPlan) {
			vppProviderResults.add(e.getText().trim());
		}
		return vppProviderResults;
	}

	public void verifyProviderVPP() {
		containsname(werallyResults, vppProviderResults);
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
		Assert.assertTrue(result, "Providers name mismatch");
		return result;
	}

	public void getProvidersPRE(String multi) {
		if (multi.equalsIgnoreCase("Yes"))
			count = 3;
		confirmationResults1 = docdesktop.getConfimationPopupResults(count);
		System.out.println("confirmationResults1 Size is : " + confirmationResults1.size());
	}

	public void verifyProvidersSession(String multi) {
		if (multi.equalsIgnoreCase("Yes"))
			count = 3;
		docdesktop.verifyConfirmationmodalResults(count, werallyResults, confirmationResults1);
		docdesktop.nextPageValidationDoctor();
	}

	public void verifyDoctorsSession(String multi) {
		if (multi.equalsIgnoreCase("Yes"))
			count = 3;
		else
			count = 1;
		confirmationResults = docdesktop.confirmationResults;
		System.out.println("confirmationResults Size is : " + confirmationResults.size());
		verifyConfirmationmodalResults(confirmationResults1.size(), confirmationResults, confirmationResults1);
		docdesktop.nextPageValidationDoctor();
	}

	public void navigatePRE() {
		// StartNowButton.click();
		jsClickNew(StartNowButton);
		pageloadcomplete();
		Assert.assertTrue(driver.getCurrentUrl().contains("plan-recommendation-engine.html"));
		// driver.navigate().refresh();
		// pageloadcomplete();
	}

	public void verifyProviderPREVPP() {
		waitforElementInvisibilityInTime(planLoaderscreen, 60);
		threadsleep(5000);// Plan loader
		getProvidersVPP();
		containsname(PlanRecommendationEngineDoctorsPageMobile.confirmationProviderResults, vppProviderResults);
	}

	public void countyandViewPlan(String zip, String county, String isMultiCounty) {
		System.out.println("Validating Zipcode in Results UI Page: ");
		validate(headerNavigationBarHomeTab, 20);
		jsClickNew(headerNavigationBarHomeTab);
		validate(homePageZiptxt, 60);
		homePageZiptxt.sendKeys(zip);
		jsClickNew(homePageFindPlans);
		pageloadcomplete();
		if (isMultiCounty.equalsIgnoreCase("YES")) {
			validate(multiCountyDialog);
			selectFromDropDown(multiCounty, county);
		}
		validate(planZipInfo, 60);
		// waitforElementInvisibilityInTime(planLoaderscreen, 60);
		Assert.assertTrue(planZipInfo.getText().contains(zip), "Invalid Zip");
		Assert.assertTrue(planZipInfo.getText().toUpperCase().contains(county.toUpperCase()), "Invalid County");
		Assert.assertTrue(Integer.parseInt(planZipInfo.getText().split(" ")[2]) > 0, "Total Plan count is less than 1");
		jsClickNew(MAViewPlansLink);
		pageloadcomplete();
	}

	public void vppToPreStartOver() {
		if (MAPDLink.isDisplayed())
			jsClickNew(MAPDLink);

		System.out.println("Validating VPP to PRE Page Clicking on Start Over Button");
		validate(StartOverButton, 20);
		jsClickNew(StartOverButton);
		startOverPopup();
		pageloadcomplete();

	}

	public void startOverPopup() {
		System.out.println("Validating Start Over Popup elements");
		validate(StartOverDetails, 20);
		validate(StartOverContent, 20);
		validate(closeButton, 20);
		validate(startOverButtoninPopup, 20);
		jsClickNew(startOverButtoninPopup);
	}

	public void validateRankingPlans(String Recom, String plans) {
		System.out.println("Validating Plans Ranking : ");
		plansLoader();
		if (Recom.equalsIgnoreCase("MA")) {
			validate(MA1stPlanName, 60);
			verifyRankings(MAPlansName, plans);
		}
		if (Recom.equalsIgnoreCase("MS")) {
			submitMSform();
			validate(MS1stPlanName, 60);
			Assert.assertTrue(false, "MS Plans ranking is not Implemented");
		}
		if (Recom.equalsIgnoreCase("PDP")) {
			validate(PDP1stPlanName, 60);
			verifyRankings(PDPPlansName, plans);
		}
		if (Recom.equalsIgnoreCase("SNP")) {
			validate(SNP1stPlanName, 60);
		}
	}

	public void plansLoader() {
		pageloadcomplete();
		validate(planLoaderscreen, 60);
		waitforElementInvisibilityInTime(planLoaderscreen, 60);
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
		Assert.assertTrue(planName.length() > 1, "--- Unable to get the Plan name ---");
		return planName;
	}

	public void sendEmail(String plan, String email) {
		pageloadcomplete();
		System.out.println("Email Plan list from VPP : ");
		plansLoader();
		if (plan.equalsIgnoreCase("PDP")) {
			jsClickNew(pdpemailList);
		} else if (plan.equalsIgnoreCase("MA")) {
			jsClickNew(maemailList);

		} else if (plan.equalsIgnoreCase("SNP")) {
			jsClickNew(snpemailList);

		} else {
			Assert.assertTrue(false, "Print Email is not configured for the given Plan :" + plan);
		}
		// emailText.sendKeys(email);
		jsSendkeys(emailText, email);
		jsClickNew(emailSendButton);
		validate(emailSuccess, 15);
		// jsClickNew(emailCloseButton);
	}

	public void validateUIAPIRecommendations() {
		System.out.println("Validating UI vs API Plans Recommendation : ");
		plansLoader();

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

	

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	

	@FindBy(css = "div[data-rel='#plan-list-1'] .title small")
	private WebElement MAViewPlansTab;
	
	public void validateUIAPIRankingPlans() {
		System.out.println("Validating UI vs API Plans Ranking : ");
		plansLoader();
		String rankingJSON = returnDriverStorageJS("Session Storage", "ucp_planRecommendationResults");
		List<String> maAPIRankings = getAPIPlansRanking(rankingJSON, "MA");
		if (maAPIRankings.size() > 0) {
			mobileUtils.mobileLocateElementClick(MAViewPlansTab);
			validate(MA1stPlanName, 60);
			mobileUtils.mobileLocateElement(MA1stPlanEnroll);
			verifyAPIRankings(MAPlansId, maAPIRankings);
			// mobileFindElement(backtoPlans,3,false);
			// backtoPlans.click();
			driver.navigate().refresh();
			plansLoader();
			backtoTop();
		}
		List<String> pdpAPIRankings = getAPIPlansRanking(rankingJSON, "PDP");
		mobileUtils.mobileLocateElement(PDPViewPlansLink);
		jsClickMobile(PDPViewPlansLink);
		validate(PDP1stPlanName, 60);
		mobileUtils.mobileLocateElement(PDP1stPlanEnroll);
		verifyAPIRankings(PDPPlansId, pdpAPIRankings);
		// mobileFindElement(backtoPlans,3,false);
		// backtoPlans.click();
		driver.navigate().refresh();
		plansLoader();
		backtoTop();
		List<String> snpAPIRankings = getAPIPlansRanking(rankingJSON, "SNP");
		if (snpAPIRankings.size() > 0) {
			mobileUtils.mobileLocateElement(SNPViewPlansLink);
			jsClickMobile(SNPViewPlansLink);
			validate(SNP1stPlanName, 60);
			mobileUtils.mobileLocateElement(SNP1stPlanEnroll);
			verifyAPIRankings(SNPPlansId, snpAPIRankings);
		}
	}
	


	private void backtoTop() {
		boolean checkElemPosition = mobileUtils.mobileCheckElementBeforeCallBanner(footerBackToTopLink);
		// System.out.println(checkElemPosition);
		// checkElemPosition =
		// mobileUtils.mobileCheckElementBeforeCallBanner(MAViewPlansLink);
		// System.out.println(checkElemPosition);
		if (!checkElemPosition)
			mobileUtils.mobileLocateElement(footerBackToTopLink);
		try {//This single JSclick line is enough instead of this method
			jsClickMobile(footerBackToTopLink);
			//footerBackToTopLink.click();
			threadsleep(2000);
		} catch (Exception e) {

		}
	}

	public List<String> getAPIPlansRanking(String rankingJSON, String givenPlanType) {

		List<String> rankingOrder = new ArrayList<String>();
		JSONParser parser = new JSONParser();
		JSONArray jarray = new JSONArray();
		;
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
					} else {
						System.out.println("JSON Ranking Order changed finding accurate Rank...");
						for (int k = 0; k < jarray.size(); k++) {
							// System.out.println(jarray.get(k));
							jsonObj = (JSONObject) jarray.get(k);
							apiRank = (String) jsonObj.get("rank");
							// System.out.println("Rank : " + apiRank);
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
		Assert.assertTrue(rankingOrder.size() == jarray.size(), "API ranking count is not in sync with plans count");
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
		// System.out.println(jarray.size());
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

	public void verifyAPIRankings(List<WebElement> plansId, List<String> APIRankings) {

		List<String> vppPlans = new ArrayList<String>();
		System.out.println(plansId.size());
		for (WebElement e : plansId)
			vppPlans.add(getplanId(e));
		for (int i = 0; i < APIRankings.size(); i++) {
			Assert.assertTrue(vppPlans.get(i).toUpperCase().contains(APIRankings.get(i).toUpperCase()),
					"Invalid Plan Ranking between API and UI : " + vppPlans.get(i) + "<-> " + APIRankings.get(i));
		}
		System.out.println("API vs UI Plan Ranking Successful");
	}

	public String getplanId(WebElement plan) {
		String planName = "";
		String planId = "";
		int i = 0;
		while (i < 5) {
			planName = plan.getText().trim();
			planId = plan.getAttribute("id");
			System.out.println(planName);
			if (planName.isEmpty()) {
				i++;
			} else
				break;
		}
		Assert.assertTrue(planId.length() > 1, "--- Unable to get the Plan Id ---");
		System.out.println("UI Plan ID : " + planId);
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

	public void verifyPlanNames(List<WebElement> plansName, int maPlanCount) {
		List<String> vppPlans = new ArrayList<String>();
		System.out.println(plansName.size());
		for (int i = 0; i < maPlanCount; i++) {
			vppPlans.add(verifygetplanName(plansName.get(i)));
		}
		System.out.println("Plan Name compared Successful Clicks on Plan Name");
	}

	public String verifygetplanName(WebElement plan) {
		String actualplanName = "";
		scrollToView(plan);
		String exceptedplanName = plan.getText().trim();
		System.out.println("Plan Name in VPP Summary Page: " + exceptedplanName);
		plan.click();
		pageloadcomplete();
		actualplanName = planNameVPPDetailsPage.getText().split("\n")[0];
		System.out.println("Plan Name in VPP Details Page: " + actualplanName);
		Assert.assertTrue(exceptedplanName.contains(actualplanName), "--- Plan name are not matches---");
		backtoPlanSummary.click();
		pageloadcomplete();
		return actualplanName;
	}

	public String verifyviewplanDetails(List<WebElement> plansName, int PlanCount) {
		WebElement planViewdetailsBut = null;
		String actualplanName = "";
		String exceptedplanName = "";
		for (int i = 0; i < PlanCount; i++) {
			scrollToView(plansName.get(i));
			exceptedplanName = plansName.get(i).getText().trim();
			System.out.println("Plan Name in VPP Summary Page: " + exceptedplanName);
			if (exceptedplanName.contains("SNP"))
				planViewdetailsBut = SNPPlansNames.get(i)
						.findElement(By.cssSelector(".enroll-details a[dtmid='cta_acq_plans_landing']:nth-of-type(1)"));
			else if (exceptedplanName.contains("PDP"))
				planViewdetailsBut = PDPPlansNames.get(i).findElement(By.cssSelector("#viewmoredetlinkpdp"));
			else
				planViewdetailsBut = MAPlansNames.get(i)
						.findElement(By.cssSelector(".enroll-details a[dtmid='cta_acq_plans_landing']:nth-of-type(1)"));
			planViewdetailsBut.click();
			pageloadcomplete();
			actualplanName = planNameVPPDetailsPage.getText().split("\n")[0];
			System.out.println("Plan Name in VPP Details Page: " + actualplanName);
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
		for (int i = 0; i < PlanCount; i++) {

			if (i >= 1) {
				if (actualplanName.contains("PDP"))
					PDPViewPlansLink.click();
				else if ((actualplanName.contains("SNP")) || (actualplanName.contains("Medicare Advantage")))
					break;
			}
			scrollToView(plansName.get(i));
			exceptedplanName = plansName.get(i).getText().trim();
			System.out.println("Plan Name in VPP Summary Page: " + exceptedplanName);
			if (exceptedplanName.contains("SNP"))
				planViewdetailsBut = SNPPlansNames.get(i)
						.findElement(By.cssSelector(".enroll-details a[dtmid='cta_acq_plans_landing']:nth-of-type(2)"));
			else if (exceptedplanName.contains("PDP"))
				planViewdetailsBut = PDPPlansNames.get(i).findElement(By.cssSelector("div.enrollment span"));
			else
				planViewdetailsBut = MAPlansNames.get(i)
						.findElement(By.cssSelector(".enroll-details a[dtmid='cta_acq_plans_landing']:nth-of-type(2)"));
			planViewdetailsBut.click();
			pageloadcomplete();
			actualplanName = planNameEnrollPage.getText().trim();
			System.out.println("Plan Name in Plan Enroll Page: " + actualplanName);
			Assert.assertTrue(actualplanName.contains(exceptedplanName), "--- Plan name are not matches---");
			// backtoPlanSummary.click();
			browserBack();
			threadsleep(10000);
			try {
				WebDriverWait wait = new WebDriverWait(driver, 2);
				if (wait.until(ExpectedConditions.alertIsPresent()) == null)
					System.out.println("alert was not present");
				else {
					Alert alert = driver.switchTo().alert();
					alert.accept();
					System.out.println("alert was present and accepted");
				}

			} catch (Exception e) {
				// exception handling
			}
		}
		System.out.println("Plan Name compared Successful Clicks on Enroll Plan");
		return actualplanName;
	}

	public void browserBack() {

		driver.navigate().back();
		plansLoader();
	}

	public void DrugsDetailsVPPtoDCE() {
		pages.mobile.acquisition.planrecommendationengine.e2e.ACQDrugCostEstimatorPage dce = new pages.mobile.acquisition.planrecommendationengine.e2e.ACQDrugCostEstimatorPage(
				driver);
		System.out.println("Validating Pharmacy Details in DCE Page: ");
		MobileMenuAccessDCE();
		jsClickNew(adddrugbtn);
		dce.Pharmacytype();
		System.out.println("Validating Drugs Details from VPP to DCE Page: ");
		DrugsInDCE = dce.DCEDrugsResults;
		int count = DrugsInDCE.size();
		verifyConfirmationmodalResults(count, DrugsInDCE, DrugsList);
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
		threadsleep(10000);
		drugCoveredeVPP = MA1stPlanList.get(0).findElement(By.cssSelector("a[class*='add-drug']"));
		jsClickNew(drugCoveredeVPP);
	}

	public boolean changePlanyear(String year) {

		jsClickNew(MAViewPlansLink);
		// Checking and Changing to Current Year
		if (year.equalsIgnoreCase("current")) {
			if (validate(currentPlanYear, 15)) {
				jsClickNew(currentPlanYear);
				Assert.assertTrue(currentPlanYearSelected.getAttribute("id").length() > 0,
						"Current Plan Year is not Selected");
				threadsleep(5000);
				return true;
			}
		}

		// Checking and Changing Future Year
		if (year.equalsIgnoreCase("future")) {
			if (validate(futurePlanYear, 15)) {
				jsClickNew(futurePlanYear);
				Assert.assertTrue(futurePlanYearSelected.getAttribute("id").length() > 0,
						"Future Plan Year is not Selected");
				threadsleep(5000);
				return true;
			} else {
				Assert.assertTrue(false, "Future Plan Year Toggle is Needed");
			}
		}
		return false;
	}

	public boolean checkPlanyear(String year) {
		// Checking Current year selection
		try {
			// MAViewPlansLink.click();
			jsClickNew(MAViewPlansLink);
			if (year.equalsIgnoreCase("current")) {
				if (validate(currentPlanYear, 15) && currentPlanYearSelected.getAttribute("id").length() > 0) {
					return true;
				}
			}
			if (year.equalsIgnoreCase("future")) {
				if (validate(futurePlanYear, 15) && futurePlanYearSelected.getAttribute("id").length() > 0) {
					return true;
				} else {
					Assert.assertTrue(false, "Future Plan Year Toggle is not available / not selected");
				}
			}
		} catch (Exception e) {
			System.out.println("Exception Occcured Plan year toggle");
		}
		return false;
	}

	@FindBy(xpath = "//div[@class='switch-field ng-scope']//label[@class='ng-binding'][contains(text(),'2020 plans')]")
	private WebElement CurrentYearPlansBtn;

	public VPPPlanSummaryPageMobile handlePlanYearSelectionPRE(String planYear) {

		CommonUtility.checkPageIsReadyNew(driver);
		if (planYear.equalsIgnoreCase("current")) { // if the scenario is for current year
			if (validate(CurrentYearPlansBtn, 20)) {
				System.out.println("*****CLICKING ON Current Year button*****: " + CurrentYearPlansBtn.getText());
				jsClickNew(CurrentYearPlansBtn);
				CommonUtility.checkPageIsReadyNew(driver);
			}
		}
		return null;

	}
}