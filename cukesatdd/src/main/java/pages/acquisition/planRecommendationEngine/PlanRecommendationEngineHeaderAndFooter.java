/**
 * 
 */
package pages.acquisition.planRecommendationEngine;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import atdd.framework.MRScenario;
import pages.acquisition.commonpages.GlobalWebElements;

public class PlanRecommendationEngineHeaderAndFooter extends GlobalWebElements {
	
	Actions actions = new Actions(driver);

	public PlanRecommendationEngineHeaderAndFooter(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
//		validate(getStartedBtn, 30);

	}

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

//Header Elements
	
	@FindBy(xpath = "//h1[contains(@class,'text-display')]")
	private WebElement landingpageHeader;

	@FindBy(xpath = "//header[contains(@class,'header')]")
	private WebElement headerSection;
	
	@FindBy(xpath = "//*[@id='aarpSVGLogo']")
	private WebElement AARPlogoInHeader;
	
	@FindBy(css = "#uhcSVGLogo")
	private WebElement UHClogoInHeader;
	
	@FindBy(css = ".companyNameHeader>p")
	private WebElement companyNameUnderAARPlogoInHeader;
	
	@FindBy(xpath = "//a[@id='aarpSVGLogo']")
	private WebElement headerVisitAARPOrgLink;
	
	@FindBy(css = ".plan-mem-linkwrap button")
	private WebElement headerAlreadyAPlanMember;
	
	@FindBy(xpath = "//*[@class='signup']/span[2]")
	private WebElement headerAlreadyAPlanMemberPipeSymbol;
	
	@FindBy(xpath = "//*[@class='signup']/a[1]")
	private WebElement headerSigninLink;
	
	@FindBy(css = "#RegisterSignupSeperator")
	private WebElement headerPipeline;
	
	@FindBy(xpath = "//*[@class='signup']/a[2]")
	private WebElement headerRegisterLink;
	
	@FindBy(xpath = "//a[@id='dupIconFlyOut']//img[@dtmid='acq_visitor_profile']")
	private WebElement headerHeartImage;
	
	@FindBy(xpath = "//a[@id='dupIconFlyOut']/span")
	private WebElement headerHeartNumberofPlan;
	
	@FindBy(css = "#collapsible-0>#nav>.uhc-container")
	private WebElement headerNavigationBar;
	
	@FindBy(css = ".closeBg>#closeIcon")
	private WebElement closeIcon;
	
	@FindBy(xpath = "//*[@id='ghn_lnk_1']")
	private WebElement headerNavigationBarHomeTab;
	
	@FindBy(css = ".twobyone-child1")
	private List<WebElement> PREWidgetHomepage;
	
	@FindBy(css = "a[dtmname*='Shop For a Plan']")
	private WebElement headerNavigationBarShopForaPlanTab;
	
	@FindBy(css = "a[dtmname*='Learn About Medicare']")
	private WebElement headerNavigationBarLearnAboutMedicareTab;
	
	@FindBy(css = "input#search-field")
	private WebElement headerNavigationBarEnterSearchTab;
	
	@FindBy(css = "button#nav_search_icon")
	private WebElement headerNavigationBarSearchIconTab;
	
	@FindBy(css = "input#zipcodemeded-0")
	private WebElement ZipcodeHomepage;
	
	@FindBy(css = "button[class*='uhc-zip-button']")
	private WebElement homePageFindPlans;
	
	@FindBy(css = ".plan-overview-wrapper>div[class='overview-main'] h2")
	private WebElement planZipInfo;
	
	@FindBy(css = "body>div#overlay")
	private WebElement planLoaderscreen;
	
//Inside Shop for a Plan Elements
	
	@FindBy(css = "#subnav_2 > div.scroll-wrapper > div > div:nth-child(1) > label")
	private WebElement headerShopForaPlanFindplansinyourarea;
	
	@FindBy(css = "input#nav-zipcode")
	private WebElement headerShopForaPlanZipcodeBox;
	
	@FindBy(css = ".subnav-footer >button> span.uhc-button__text")
	private WebElement headerShopForaPlanZipcodeButton;
	
	@FindBy(css = "div.zip-help p:nth-child(1)")
	private WebElement headerShopForaPlanNeedQuestionofZipcode;
	
	@FindBy(css = "div.zip-help p:nth-child(2) a")
	private WebElement headerShopForaPlanLookupZipcode;
	
	@FindBy(css = "div.zip-help p:nth-child(4)>a")
	private WebElement headerShopForaPlanRequestMoreHelp;
	
	@FindBy(xpath = "div.emailIntro h4")
	private WebElement headerShopForaPlanMedicareGuide;
	
	@FindBy(xpath = "div.emailIntro p")
	private WebElement headerShopForaPlanMedicareGuideText;
	
	@FindBy(css = ".email-sctn input#learnmore-email-address")
	private WebElement headerShopForaPlanEmailBox;
	
	@FindBy(css = ".email-sctn button>span.uhc-button__text")
	private WebElement headerShopForaPlanEmailButton;
	
	@FindBy(css = "div[class*='thankYouMsg'] h4")
	private WebElement headerShopForaPlanThankYou;
	
	@FindBy(css = "#shop-scroll div[class*='section-1'] >h3:nth-of-type(1)>a")
    private WebElement headerShopLink;
    
    @FindBy(css = "#shop-scroll div[class*='section-1'] >h3:nth-of-type(2)>a")
    private WebElement headerEnrollLink;
    
    @FindBy(css = "#shop-scroll div[class*='section-1'] >h3:nth-of-type(3)>a")
    private WebElement headerResourcesLink;
    
//    @FindBy(css = "#planTypesColumn h3:nth-of-type(4)>a")
//    private WebElement headerResourcesLink;
    
    @FindBy(css = "#shop-scroll div[class*='desktop-sctn section-2']>h3:nth-of-type(1)>a")
    private WebElement headerAdvantageplanLink;
    
    @FindBy(css = "#shop-scroll div[class*='desktop-sctn section-2']>h3:nth-of-type(2)>strong>a")
	private WebElement headerDualSpecialLink;

	@FindBy(css = "#shop-scroll div[class*='desktop-sctn section-2']>h3:nth-of-type(3)>a>span:nth-child(2)")
    private WebElement headerMedicaresupplementplanLink;
    
	@FindBy(css = "#shop-scroll div[class*='desktop-sctn section-2']>h3:nth-of-type(5)>a")
    private WebElement headerPrescriptionLink;
    
    @FindBy(css = ".desktop-sctn:nth-child(4) h3:nth-child(2)")
    private WebElement headerGetaPlanRecommendationLink;
    
    @FindBy(linkText = "Estimate Drug Costs")
    private WebElement headerDrugcostLink;
    
    @FindBy(linkText = "Search for a Pharmacy")
    private WebElement headerPharmacysearchLink;
    
    @FindBy(partialLinkText = "Search Doctors")
    private WebElement headerProvidersearchLink;
    
    
 //Learn about Medicare inner element
        
    @FindBy(css = "#learnmore-scroll div >div:nth-child(1)[class*='desktop-sctn sctn'] >div>p:nth-child(3)")
    private WebElement headerEligibilityLink;
    
    @FindBy(css = "#learnmore-scroll div >div:nth-child(1)[class*='desktop-sctn sctn'] >div>p:nth-child(4)")
    private WebElement headerCoverageLink;
    
    @FindBy(css = "#learnmore-scroll div >div:nth-child(1)[class*='desktop-sctn sctn'] >div>p:nth-child(5)")
    private WebElement headermedicarePrescriptionProviderLink;
    
    @FindBy(css = "#learnmore-scroll div >div:nth-child(1)[class*='desktop-sctn sctn'] >div>p:nth-child(6)")
    private WebElement headerCostbasicsLink;
    
    @FindBy(css = "#learnmore-scroll div >div:nth-child(3)[class*='desktop-sctn sctn'] >div>p:nth-child(3)")
    private WebElement headerMedicareadvantageLink;
    
    @FindBy(css = "#learnmore-scroll div >div:nth-child(3)[class*='desktop-sctn sctn'] >div>p:nth-child(4)") //Geotargetting
    private WebElement headerMedicaresupplemnetLink;
    
    @FindBy(css = "#learnmore-scroll div >div:nth-child(3)[class*='desktop-sctn sctn'] >div>p:nth-child(5)")
    private WebElement headerMedicareprescriptionLink;
    
    @FindBy(css = "#learnmore-scroll div >div:nth-child(5)[class*='desktop-sctn sctn'] >div>p:nth-child(2)>a")
    private WebElement headerEnrollment;
    
    @FindBy(css = "#learnmore-scroll div[class*='desktop-sctn sctn']:nth-child(3) div>p:nth-child(8)>a")
    private WebElement headerFAQLink;
    
    @FindBy(css = "#learnmore-scroll div[class*='desktop-sctn sctn']:nth-child(1)  div>p:nth-child(8)>a")
    private WebElement headerMedicareArticles;
    
    @FindBy(css = "#subnav_3 div[class$='content-3']>div:nth-child(2)>ul>li:nth-child(1)")
    private WebElement headerEligibilityEnrollment;
    
    @FindBy(css = "#subnav_3 div[class$='content-3']>div:nth-child(2)>ul>li:nth-child(2)")
    private WebElement headerBenefitsCoverage;
    
    @FindBy(css = "#subnav_3 div[class$='content-3']>div:nth-child(2)>ul>li:nth-child(3)")
    private WebElement headerMedicareCosts;

    @FindBy(css = "#subnav_3 div[class$='content-3']>div:nth-child(2)>ul>li:nth-child(4)")
    private WebElement headerShoppingforMedicare;
    
    @FindBy(css = "#subnav_3 div[class$='content-3']>div:nth-child(2)>ul>li:nth-child(5)")
    private WebElement headerWorkingPast65;
    
    @FindBy(css = "#subnav_3 div[class$='content-3']>div:nth-child(2)>ul>li:nth-child(6)")
    private WebElement headerMedicareTipsFAQs;
    
//'Read More' is Inside Medicare Articles Menu
    
    @FindBy(css = "div[class*='breadcrumb']")
	private WebElement HeaderBreadcrumb;
    
    @FindBy(css = "a[href*='medicare-articles/eligibility-and-enrollment.html']")
	private WebElement HeaderEnrollMedicareArticles;
    
    @FindBy(css = "div a[class*='uhc-tempo-button--primary']")
	private WebElement HeaderGetStartedMedicareArticles;
    
//Inside Medicare Education Menu
    
    @FindBy(css = "div[class*='NewCustomRTE parsys'] span[class*='heading-2']")
	private List<WebElement> PREWidegetTitle;
    
    @FindBy(css = "div[class*='aem-Grid aem-Grid--12'] div[class*='layout-container'] a[href*='/plan-recommendation-engine.html']")
	private WebElement GetaPlanRecommBtn;
    
    @FindBy(css = "ul[class*='uhc-side-nav--secondary'] li:nth-child(3) a")
	private WebElement CoverageOptionsLink;
    
    @FindBy(css = "ul[class*='uhc-side-nav--secondary'] li:nth-child(5) a")
	private WebElement MedicareCostBasicsLink;
    
    @FindBy(css = "ul[class*='uhc-side-nav--secondary'] li:nth-child(6) a")
	private WebElement OriginalMedicareLink;       
    
//'Get Help Choosing' is Inside Shop Menu
    
    @FindBy(css = "div[class*='aem-GridColumn'] a[title='Learn More']")
	private WebElement HeaderShopFromHomeInFindYourPlan;
    
    @FindBy(css = "a[data-asset-name='Get Started']")
	private WebElement HeaderGetRecommendationInShop;
	
//Footer Elements
	
	@FindBy(css = "div[class*='footernavigation '] .footer-row")
	private WebElement footerSection;
	
	@FindBy(css = "ul.visitaarp.linksCond > li > a")
	private WebElement footerVisitAARPOrgLink;
	
	@FindBy(css = ".shopLinks-forAnalytics:nth-child(2) p:nth-child(1) a")
	private WebElement footerMedicareAdvantagePlansLink;
		
	@FindBy(css = ".shopLinks-forAnalytics:nth-child(2) p:nth-child(3) a")
	private WebElement footerMedicareSupplementInsurancePlansLink;
	
	@FindBy(css = ".shopLinks-forAnalytics:nth-child(2) p:nth-child(4) a")
	private WebElement footerMedicarePrescriptionDrugPlansLink;
	
	@FindBy(css = "#gfn_lnk_row3_1 > span")
	public WebElement footerMedicareEducationLink;
	
	@FindBy(css = ".footer-top>ul>li>a.back-to-top")
	public WebElement footerBackToTopLink;
	
	@FindBy(css = "#stateWidget > div > label")
	public WebElement footerYourState;
	
	@FindBy(css = ".linksCond > #gf_lnk_1 > div")
	public WebElement footerHomeLink;
	
	@FindBy(css = ".moreLinks-forAnalytics:nth-child(2) p:nth-child(1) a")
	public WebElement footerAboutUsLink;
	
	@FindBy(css = ".moreLinks-forAnalytics:nth-child(2) p:nth-child(2) a")
	public WebElement footerContactUsLink;
	
	@FindBy(css = ".linksCond > #gf_lnk_4 > div")
	public WebElement footerSiteMapLink;
	
	@FindBy(css = ".linksCond > #gf_lnk_5 > div")
	public WebElement footerPrivacyPolicyLink;
	
	@FindBy(css = ".linksCond > #gf_lnk_6 > div")
	public WebElement footerTermsofUseLink;
	
	@FindBy(css = ".linksCond > #gf_lnk_7 > div")
	public WebElement footerDisclaimersLink;
	
	@FindBy(css = ".linksCond > #gf_lnk_8 > div")
	public WebElement footerAgentsBrokersLink;
	
	@FindBy(css = ".linksCond > #gf_lnk_9 > div")
	public WebElement footerAccessibilityLink;
	
	@FindBy(css = ".footer-middle>p:nth-of-type(1)")
	public WebElement footerCertificateStatement;
	
	@FindBy(css = ".footer-middle>p:nth-of-type(2)")
	public WebElement footerLastUpdated;
	
	@FindBy(css = "select#state-select")
	public WebElement selectState;
        
// DCE elements
	
	@FindBy(css = "a[dtmid*='cta_dce']")
	private WebElement drugAddBtn;
	
	@FindBy(css = "h1[class*='drug-cost-estimator']")
	private WebElement dceTitle;
	
//Header Element Verification Method 
	
	String Browsername = MRScenario.browsername;
	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);
	
	public void headerElements() {
		System.out.println("Validating Header Elements: ");
		String actualpageurl = driver.getCurrentUrl();
		if(actualpageurl.contains("aarpmedicareplans")) {
			validate(AARPlogoInHeader, 30);
			try {
				if(companyNameUnderAARPlogoInHeader.isDisplayed()) //only aarp and geo targetting
					System.out.println("Element found!!!!");
				Assert.assertTrue(companyNameUnderAARPlogoInHeader.getText().contains("UnitedHealthcare Insurance Company"));
			}
			catch(Exception e){
				System.out.println("Company name is not Visible");
			}
			validate(headerVisitAARPOrgLink, 30);
		}else if(actualpageurl.contains("uhcmedicaresolutions")){
			validate(UHClogoInHeader, 30);
		}
		validate(headerSection, 30);
		validate(headerAlreadyAPlanMember, 30);
		Assert.assertTrue(headerAlreadyAPlanMember.getText().trim().contains("For Plan Members"));
		validate(headerNavigationBarHomeTab, 30);
		Assert.assertTrue(headerNavigationBarHomeTab.getText().contains("Home"));
		validate(headerNavigationBarShopForaPlanTab, 30);
		Assert.assertTrue(headerNavigationBarShopForaPlanTab.getText().contains("Shop For a Plan"));
		validate(headerNavigationBarLearnAboutMedicareTab, 30);
		Assert.assertTrue(headerNavigationBarLearnAboutMedicareTab.getText().contains("Learn About Medicare"));
		validate(headerNavigationBarEnterSearchTab, 30);
		validate(headerNavigationBarSearchIconTab, 30);

//MouseOver on Shop of a Plan and Validating Inside Shop of a Plan
		System.out.println("Validating Shop of a Plan Elements: ");
		threadsleep(2000);
//		actions.clickAndHold(headerNavigationBarShopForaPlanTab).build().perform();
		desktopCommonUtils.MouseOver(headerNavigationBarShopForaPlanTab, Browsername);
		validate(headerShopForaPlanFindplansinyourarea, 30);
		validate(headerShopForaPlanZipcodeBox, 30);
		validate(headerShopForaPlanZipcodeButton, 30);
		Assert.assertTrue(headerShopForaPlanZipcodeButton.getText().contains("Find Plans"));
		validate(headerShopForaPlanNeedQuestionofZipcode, 30);
		Assert.assertTrue(headerShopForaPlanNeedQuestionofZipcode.getText().contains("Need help finding a ZIP Code?"));
		validate(headerShopForaPlanLookupZipcode, 30);
		validate(headerShopForaPlanRequestMoreHelp, 30);
//2nd column in Shop for a plan		headerNewExistingMemberLink
		validate(headerShopLink, 30);
		Assert.assertTrue(headerShopLink.getText().contains("Shop"));
//		validate(headerNewExistingMemberLink, 30);
//		Assertion.assertTrue(headerNewExistingMemberLink.getText().contains("New and Existing Members"));
		validate(headerEnrollLink, 30);
		Assert.assertTrue(headerEnrollLink.getText().contains("Enroll"));
		validate(headerResourcesLink, 30);
		Assert.assertTrue(headerResourcesLink.getText().contains("Resources"));
//3rd column in Shop for a plan
		validate(headerAdvantageplanLink, 30);
		Assert.assertTrue(headerAdvantageplanLink.getText().contains("Medicare Advantage Plans"));
		validate(headerMedicaresupplementplanLink, 30);
		Assert.assertTrue(headerMedicaresupplementplanLink.getText().contains("Medicare Supplement Plans"));  //GeoTargeting Element
		validate(headerPrescriptionLink, 30);
		Assert.assertTrue(headerPrescriptionLink.getText().contains("Medicare Prescription Drug Plans"));
		validate(headerGetaPlanRecommendationLink, 30);
		Assert.assertTrue(headerGetaPlanRecommendationLink.getText().contains("Get a Plan Recommendation"));
		validate(headerDrugcostLink, 30);
		Assert.assertTrue(headerDrugcostLink.getText().contains("Estimate Drug Costs"));
		validate(headerPharmacysearchLink, 30);
		Assert.assertTrue(headerPharmacysearchLink.getText().contains("Search for a Pharmacy"));
		validate(headerProvidersearchLink, 30);
		Assert.assertTrue(headerProvidersearchLink.getText().contains("Search Doctors"));
		validate(headerShopForaPlanMedicareGuide, 30);
		validate(headerShopForaPlanMedicareGuideText, 30);
		validate(headerShopForaPlanEmailBox, 30);
		validate(headerShopForaPlanEmailButton, 30);
//MouseOver on Learn About Medicare and Validating Learn About Medicare
		driver.navigate().refresh();
		System.out.println("Validating Learn About Medicare Elements: ");
		threadsleep(2000);
		validate(headerNavigationBarLearnAboutMedicareTab, 45);
//		actions.clickAndHold(headerNavigationBarLearnAboutMedicareTab).build().perform();
		desktopCommonUtils.MouseOver(headerNavigationBarLearnAboutMedicareTab, Browsername);
		validate(headerEligibilityLink, 30);		
		validate(headerCoverageLink, 30);
		validate(headermedicarePrescriptionProviderLink, 30);
		validate(headerCostbasicsLink, 30);
		validate(headerMedicareadvantageLink, 30);
		validate(headerMedicaresupplemnetLink, 30);
		validate(headerMedicareprescriptionLink, 30);
		validate(headerEnrollment, 30);
		validate(headerFAQLink, 30);  //GeoTargeting Element
		validate(headerMedicareArticles, 30);
		Assert.assertTrue(headerMedicareArticles.getText().contains("Articles and Special Topics"));
/*		validate(headerEligibilityEnrollment, 30);
		validate(headerBenefitsCoverage, 30);
		validate(headerMedicareCosts, 30);
		validate(headerShoppingforMedicare, 30);
		validate(headerWorkingPast65, 30);
		validate(headerMedicareTipsFAQs, 30);*/
	}
	
	
//	Header Element Click Verification Method 
	
		public void headerLinkvalidation(){
		String curURL = driver.getCurrentUrl();			
		validate(headerNavigationBarShopForaPlanTab, 45);
		desktopCommonUtils.MouseOver(headerNavigationBarShopForaPlanTab, Browsername);
		headerShopForaPlanLookupZipcode.click();
		validateLinks("/health-plans.html?lookupZipcode");
		backtoshopforaplan();
		headerShopForaPlanRequestMoreHelp.click();
		validateLinks("contact-us.html");
		backtoshopforaplan();
		headerShopLink.click();
		validateLinks("/shop.html");
		backtoshopforaplan();
		headerEnrollLink.click();
		validateLinks("/enroll.html");
		backtoshopforaplan();
		headerResourcesLink.click();
		validateLinks("/resources.html");
		backtoshopforaplan();
		headerAdvantageplanLink.click();
		validateLinks("/shop/medicare-advantage-plans.html");
		backtoshopforaplan();
		headerMedicaresupplementplanLink.click();
		validateLinks("/shop/medicare-supplement-plans.html");
		backtoshopforaplan();
		headerPrescriptionLink.click();
		validateLinks("/shop/prescription-drug-plans.html"); 
		backtoshopforaplan();
		headerGetaPlanRecommendationLink.click();
		validateLinks("/plan-recommendation-engine.html");
		validate(headerNavigationBarShopForaPlanTab, 45);
//		actions.clickAndHold(headerNavigationBarShopForaPlanTab).build().perform();
		desktopCommonUtils.MouseOver(headerNavigationBarShopForaPlanTab, Browsername);
		headerDrugcostLink.click();
		validateLinks("/health-plans/estimate-drug-costs.html");
		backtoshopforaplan();
		headerPharmacysearchLink.click();
		validateLinks("/health-plans/aarp-pharmacy.html");
		
//		Opens in another window
		backtoshopforaplan();
		if (curURL.contains("aarpmedicare")) {
				//another window - only aarp
				navigatesubLink(headerProvidersearchLink.getAttribute("href"));
		}else if(curURL.contains("uhcmedicaresolutions")){
			//another window - only aarp
			navigatesubLink(headerProvidersearchLink.getAttribute("href"));
		}
		
// Learn about medicare inner elements	
//		actions.clickAndHold(headerNavigationBarLearnAboutMedicareTab).build().perform();
		backtoshopforaplan();
		state();
		desktopCommonUtils.MouseOver(headerNavigationBarLearnAboutMedicareTab, Browsername);
		headerEligibilityLink.click();
		validateLinks("/medicare-education/medicare-eligibility.html");
		backtolearnmoremodicare();
		headerCoverageLink.click();
		validateLinks("/medicare-education/medicare-parts-and-medigap-plans.html");
		backtolearnmoremodicare();
		headermedicarePrescriptionProviderLink.click();
		validateLinks("/medicare-education/medicare-benefits.html");
		backtolearnmoremodicare();
		headerCostbasicsLink.click();
		validateLinks("/medicare-education/medicare-costs.html");
		backtolearnmoremodicare();
		headerMedicareadvantageLink.click();
		validateLinks("/medicare-education/medicare-advantage-plans.html");
		
		backtolearnmoremodicare();
		try {
		validate(headerMedicaresupplemnetLink,30);
		headerMedicaresupplemnetLink.click(); //geotargetting
		validateLinks("/medicare-education/medicare-supplement-plans.html");
		}catch(Exception e) {
			System.out.println("Geo targetting link 'Medicare Supplement Insurance Plans' is not available");
		}
		backtolearnmoremodicare();
		headerMedicareprescriptionLink.click();
		validateLinks("/medicare-education/medicare-part-d.html");
		backtolearnmoremodicare();
		state();
		validate(headerEnrollment,30);
		navigatesubLink(headerEnrollment.getAttribute("href"));
		validateLinks("medicare-education/when-to-enroll.html");
		backtolearnmoremodicare();
		try {
		validate(headerFAQLink,30);//geotargetting
		navigatesubLink(headerFAQLink.getAttribute("href"));
		validateLinks("/medicare-education/medicare-faq.html");
		browserBack();
		}catch(Exception e) {
			System.out.println("Geo targetting link 'Medicare FAQ' is not available");
		}
		validate(headerNavigationBarLearnAboutMedicareTab, 45);
		desktopCommonUtils.MouseOver(headerNavigationBarLearnAboutMedicareTab, Browsername);
		headerMedicareArticles.click();
		validateLinks("/medicare-articles.html");
		backtolearnmoremodicare();

		}
		
// PRE BreadCrumbs in Header	
		
		public void breadCrumbs() {
			try {
				String preBreadcrumbs = (driver.findElement(By.cssSelector("div.breadcrumb"))).getText();
				Assert.assertTrue(preBreadcrumbs.contains("Home / Plan Recommendation Engine"));
				System.out.println(preBreadcrumbs);
			} catch(StaleElementReferenceException e) {

			}
		}
		
//	Footer Element Verification Method
	
	public void footerElements() {
		System.out.println("Validating Footer Elements: ");
		scrollToView(footerSection);
		validate(footerSection, 30);
		validate(footerMedicareAdvantagePlansLink, 30);
		Assert.assertTrue(footerMedicareAdvantagePlansLink.getText().contains("Medicare Advantage Plans"));
		validate(footerMedicareSupplementInsurancePlansLink, 30);	//GeoTargeting Element
		validate(footerMedicarePrescriptionDrugPlansLink, 30);
		Assert.assertTrue(footerMedicarePrescriptionDrugPlansLink.getText().contains("Medicare Prescription Drug Plans"));
		validate(footerAboutUsLink, 30);
		Assert.assertTrue(footerAboutUsLink.getText().contains("About"));
		validate(footerContactUsLink, 30);
		Assert.assertTrue(footerContactUsLink.getText().contains("Contact"));
		validate(footerLastUpdated, 30);
	}
	
//	Footer Element Click Verification Method
	
	public void footerLinkvalidation() throws Exception{
		String curWindow;
		if (driver.getCurrentUrl().contains("aarpmedicare")) {
			validate(AARPlogoInHeader, 30);
			AARPlogoInHeader.click();
		} else if (driver.getCurrentUrl().contains("uhcmedicare")) {
			validate(UHClogoInHeader, 30);
			UHClogoInHeader.click();
		}
		navigationToPlanRecommendationEngine();
		String curURL = driver.getCurrentUrl();
		footerMedicareAdvantagePlansLink.click();
		validateLinks("/shop/medicare-advantage-plans.html");
		browserBack();
		footerMedicareSupplementInsurancePlansLink.click();
		validateLinks("/shop/medicare-supplement-plans.html");
		browserBack();
		
		footerMedicarePrescriptionDrugPlansLink.click();
		validateLinks("/shop/prescription-drug-plans.html");
		browserBack();

		footerAboutUsLink.click();
		validateLinks("/about-us");
		browserBack();
		footerContactUsLink.click();
		validateLinks("/contact-us.html");
		browserBack();
	}
	
//Navigating Plan RecommendationEngine via Get Plan Recommendation	
	public void navigationToPlanRecommendationEngine() {
		validate(headerNavigationBarShopForaPlanTab, 45);
		jsMouseOver(headerNavigationBarShopForaPlanTab);
//		jsClickNew(headerNavigationBarShopForaPlanTab);
		threadsleep(1000);							//E2E : Adding additional wait for element to be visible
		validate(headerGetaPlanRecommendationLink);
		jsClickNew(headerGetaPlanRecommendationLink);
		jsMouseOut(headerNavigationBarShopForaPlanTab); // Chargers: Added jsMouseOut to avoid clickIntercept exceptions
		validate(landingpageHeader, 30);
	}
	
//Navigating Plan RecommendationEngine via Shop for a plan -->Shop-->Tools-->Get Help Choosing	
	public void navigationToPlanRecommendationEngineViaShopTools() {
		waitForPageLoadSafari();
		validate(headerNavigationBarShopForaPlanTab, 45);
//		actions.clickAndHold(headerNavigationBarShopForaPlanTab).build().perform();
		//desktopCommonUtils.MouseOver(headerNavigationBarShopForaPlanTab, Browsername);
		jsMouseOver(headerNavigationBarShopForaPlanTab);
		jsClickNew(headerNavigationBarShopForaPlanTab);
		jsClickNew(headerShopLink);;
		scrollToView(HeaderGetRecommendationInShop);
		validate(HeaderGetRecommendationInShop, 30);
		jsClickNew(HeaderGetRecommendationInShop);
		validate(landingpageHeader, 30);
		Assert.assertTrue(landingpageHeader.getText().contains("Plan"));
	}
	
//Navigating Plan RecommendationEngine via Learning About Medicare --> Medicare Articles-->Get Started
		public void navigationToPlanRecommendationEngineViaMedicareArticles() {
			validate(headerNavigationBarLearnAboutMedicareTab, 45);
			jsMouseOver(headerNavigationBarLearnAboutMedicareTab);
			jsClickNew(headerNavigationBarLearnAboutMedicareTab);
			jsClickNew(headerMedicareArticles);
			validate(HeaderBreadcrumb, 30);
			Assert.assertTrue(HeaderBreadcrumb.getText().trim().contains("Home / Medicare Articles"), "Medicare Articles page not opened");
			validate(HeaderEnrollMedicareArticles, 30);
			jsClickNew(HeaderEnrollMedicareArticles);
			validate(HeaderBreadcrumb, 30);
			Assert.assertTrue(HeaderBreadcrumb.getText().trim().contains("Home / Medicare Articles / Eligibility & Enrollment"),"Medicare and COBRA page not opened");
			scrollToView(HeaderGetStartedMedicareArticles);
			validate(HeaderGetStartedMedicareArticles, 30);
			jsClickNew(HeaderGetStartedMedicareArticles);
			validate(landingpageHeader, 30);
			Assert.assertTrue(landingpageHeader.getText().contains("Plan"));
		}
	
//	Navigate to DCE
	
	public void navigationToDrugCostEstimatorViaShopTools() {
		jsClickNew(headerNavigationBarHomeTab);
		threadsleep(2000);
		validate(headerNavigationBarShopForaPlanTab, 45);
		jsMouseOver(headerNavigationBarShopForaPlanTab);
//		jsClickNew(headerNavigationBarShopForaPlanTab);
		jsClickNew(headerDrugcostLink);
		threadsleep(2000);
		waitForPageLoadSafari();
		validate(drugAddBtn, 30);
		validate(dceTitle, 30);
		Assert.assertTrue(dceTitle.getText().contains("Drug Cost Estimator"));
	}
	
//	Navigating Plan RecommendationEngine via Learning About Medicare --> Medicare Education -> PRE Widget
			public void navigationToPlanRecommendationEngineViaMedicareEducation() {
				System.out.println("Validating PRE Widget in Medicare Education pages");
				state();
				validate(headerNavigationBarLearnAboutMedicareTab, 45);
//				desktopCommonUtils.MouseOver(headerNavigationBarLearnAboutMedicareTab, Browsername);
				jsMouseOver(headerNavigationBarLearnAboutMedicareTab);
//				jsClickNew(headerNavigationBarLearnAboutMedicareTab);
				headerEligibilityLink.click();
				validate(HeaderBreadcrumb, 30);
				Assert.assertTrue(HeaderBreadcrumb.getText().trim().contains("Home / Introduction to Medicare / Medicare Eligibility"), "Medicare Eligibility page not opened");
				PRE();
				scrollToView(CoverageOptionsLink);
				validate(CoverageOptionsLink);
				CoverageOptionsLink.click();
				Assert.assertTrue(HeaderBreadcrumb.getText().trim().contains("Home / Introduction to Medicare / Coverage Options"), "Coverage Choices page not opened");
				PRE();
				scrollToView(MedicareCostBasicsLink);
				validate(MedicareCostBasicsLink);
				MedicareCostBasicsLink.click();
				Assert.assertTrue(HeaderBreadcrumb.getText().trim().contains("Home / Introduction to Medicare / Medicare Cost Basics"), "Medicare Cost Basics page not opened");
				PRE();
				scrollToView(OriginalMedicareLink);
				validate(OriginalMedicareLink);
				OriginalMedicareLink.click();
				Assert.assertTrue(HeaderBreadcrumb.getText().trim().contains("Home / Introduction to Medicare / Original Medicare"), "Original Medicare page not opened");
				PRE();
			}	
			
			//PRE Widget Validation and Navigation to PRE
			public void PRE() {
				int count = PREWidegetTitle.size();
				for(int i=0;i<count;i++) {
					if(PREWidegetTitle.get(i).getText().equalsIgnoreCase("Get a Plan Recommendation") || PREWidegetTitle.get(i).getText().equalsIgnoreCase("Need Help Finding a Plan?")){
						System.out.println("PRE Widget is Available in Medicare Education");
						scrollToView(GetaPlanRecommBtn);
						validate(GetaPlanRecommBtn);
						GetaPlanRecommBtn.click();
						Assert.assertTrue(driver.getCurrentUrl().contains("/plan-recommendation-engine.html"),"PRE Not opened");
						browserBack();
						threadsleep(2000);
						waitForPageLoadSafari();
						break;
					}
					else
						System.out.println("PRE Widget is not Available");
				}
			}
			
// Navigating Plan RecommendationEngine via Homepage PRE Widget
					public void navigationToPREViaHomePageWidget() {
						System.out.println("Validating PRE Widget in homepage");
						state();
						Assert.assertTrue(validate(PREWidgetHomepage.get(0), 20), "PRE Widget is not present in homepage");
						Assert.assertTrue(PREWidgetHomepage.get(0).findElement(By.cssSelector("div[class*='NewCustomRTE']>h2")).getText().toUpperCase().trim().equalsIgnoreCase("NEED HELP FINDING A PLAN?"), "PRE Widget header is not present in homepage");
						Assert.assertTrue(PREWidgetHomepage.get(0).findElement(By.cssSelector("div[class*='NewCustomRTE'] a[title='Get Started']")).getText().toUpperCase().trim().contains("GET STARTED"), "PRE Widget link is not present in homepage");
						PREWidgetHomepage.get(0).findElement(By.cssSelector("div[class*='NewCustomRTE'] a[title='Get Started']")).click();
						threadsleep(2000);
						driver.getCurrentUrl().contains("plan-recommendation-engine.html#/get-started");
						validate(landingpageHeader,20);
					}
			
//Reseting State to Select State
			public void state() {
				headerNavigationBarHomeTab.click();
				scrollToView(selectState);
				Select dropdown = new Select(selectState);
				waitUntilSelectOptionsPopulated(dropdown);
				dropdown.selectByVisibleText("California");
				threadsleep(2000);
				scrollToView(headerNavigationBarHomeTab);
			}
	
//ZipCode Function inside Shop for a Plan
	public void zipcodeFunctionInShopforaplan(String zipcode) throws InterruptedException {
		validate(headerNavigationBarShopForaPlanTab, 45);
//		actions.clickAndHold(headerNavigationBarShopForaPlanTab).build().perform();
//		actions.moveToElement(headerShopForaPlanZipcodeBox).click();
		desktopCommonUtils.MouseOver(headerNavigationBarShopForaPlanTab, Browsername);
		jsClickNew(headerShopForaPlanZipcodeBox);
		headerShopForaPlanZipcodeBox.sendKeys(zipcode);
		jsClickNew(headerShopForaPlanZipcodeButton);
		Thread.sleep(5000);
		validateLinks("/plan-summary");
		jsClickNew(headerNavigationBarHomeTab);
		navigationToPlanRecommendationEngine();
	}
	
//Email Function inside Shop for a Plan	
	public void emailFunctionInShopforaplan(String email) {
		validate(headerNavigationBarLearnAboutMedicareTab, 45);
//		actions.clickAndHold(headerNavigationBarLearnAboutMedicareTab).build().perform();
		desktopCommonUtils.MouseOver(headerNavigationBarLearnAboutMedicareTab, Browsername);
		jsClickNew(headerShopForaPlanEmailBox);
		headerShopForaPlanEmailBox.sendKeys(email);
		jsClickNew(headerShopForaPlanEmailButton);
		validate(headerShopForaPlanThankYou, 60);
		try {
			validate(closeIcon,30);
			validate(closeIcon, 60);
			jsClickNew(closeIcon);
			validate(headerNavigationBarHomeTab, 60);
			jsClickNew(headerNavigationBarHomeTab);
			navigationToPlanRecommendationEngine();
			}catch(Exception e) {
				System.out.println("Thank You Popup is not displaying");
				driver.navigate().refresh();
			}
		
	}
	
//	Enter Search Key Function in Navigation bar
	public void enterSearchFunction(String SearchKey) {
		validate(headerNavigationBarEnterSearchTab, 45);
		String actualpageurl = driver.getCurrentUrl();
		System.out.println("Actual Page is :"+actualpageurl);
		headerNavigationBarEnterSearchTab.click();
		headerNavigationBarEnterSearchTab.sendKeys(SearchKey);
		threadsleep(2000);
		headerNavigationBarSearchIconTab.click();
		String expectedpageurl = driver.getCurrentUrl();
		String ExpectedPage = "site-search.html?";
		Boolean url = ((actualpageurl.equals(expectedpageurl)));
		if(url!=true) {
			Assert.assertTrue(expectedpageurl.contains(ExpectedPage));
			browserBack();
		}else {
			Assert.assertFalse(false, "Search function not working as expected");
		}
		
	}
	
//	Back to Top Function in Footer
	public void backtoTopFunction() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
		validate(footerBackToTopLink, 45);
		jsClickNew(footerBackToTopLink);
		String actualpageurl = driver.getCurrentUrl();
		if(actualpageurl.contains("aarpmedicareplans")) {
			validate(AARPlogoInHeader, 30);
			AARPlogoInHeader.isSelected();
		}else if(actualpageurl.contains("uhcmedicaresolutions")){
			validate(UHClogoInHeader, 30);
			UHClogoInHeader.isSelected();
		}
	}
	
	public void validateLinks(String expURL) {
		threadsleep(2000);
		String curURL = driver.getCurrentUrl();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(expURL.contains("||") && curURL.contains(expURL.split("\\|\\|")[0]) || expURL.contains("||") && curURL.contains(expURL.split("\\|\\|")[1])){
			System.out.println("Link validation True");
		}
		else if(curURL.contains(expURL)) {
			System.out.println("Link validation True");
		}else {
			System.out.println("Link validation False");
			System.out.println("Expected URL "+expURL);
			System.out.println("Actual URL "+curURL);
			Assert.assertTrue(false);
		}
	}
	
	public void backtoshopforaplan() {
		browserBack();
		threadsleep(2000);
		validate(headerNavigationBarShopForaPlanTab, 45);
//		actions.clickAndHold(headerNavigationBarShopForaPlanTab).build().perform();
		desktopCommonUtils.MouseOver(headerNavigationBarShopForaPlanTab, Browsername);
	}
	
	public void backtolearnmoremodicare() {
		browserBack();
		threadsleep(2000);
		validate(headerNavigationBarLearnAboutMedicareTab, 45);
//		actions.clickAndHold(headerNavigationBarLearnAboutMedicareTab).build().perform();
		desktopCommonUtils.MouseOver(headerNavigationBarLearnAboutMedicareTab, Browsername);
	}
	
	public void navigatesubLink(String subURL) {
		driver.navigate().to(subURL);
	}
	
	public void validateLinksanotherWindow(String expURL, String primaryWindow) {
		threadsleep(2000);
		ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(windows);
		if (windows.size() >= 2) {
			driver.switchTo().window(windows.get(1)); 	
			System.out.println(driver.getCurrentUrl());
			validateLinks(expURL);
			driver.close();
			driver.switchTo().window(windows.get(0));
			}
		else {
			System.out.println("Link validation fails in popup window" + expURL);
			driver.switchTo().window(primaryWindow);
			threadsleep(1000);
			Assert.assertTrue(false);
		}
	}
	
	public void storedZipcode(String zipcode) {
		System.out.println("Validating Zipcode stored in PRE session");
		headerNavigationBarHomeTab.click();
		threadsleep(2000);
		validate(ZipcodeHomepage);
//		Assert.assertTrue(ZipcodeHomepage.getText().trim().contains(zipcode), "Zipcode is Invalid ");
		jsClickNew(homePageFindPlans);
		validate(planZipInfo, 60);
        waitforElementInvisibilityInTime(planLoaderscreen,60);
        threadsleep(5000);// Plan loader
        Assert.assertTrue(planZipInfo.getText().contains(zipcode),"Invalid Zip");
	}

	public void browserBack() {

		driver.navigate().back();
	}
}
